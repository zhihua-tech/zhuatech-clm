/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.clm.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ObligationExposureService {
    public Result evaluate(Request request) {
        List<Obligation> atRisk = request.obligations().stream()
            .filter(item -> item.daysUntilDue() <= 30 && (!item.evidenceReady() || item.dependencyBlocked()))
            .toList();
        int overdue = (int) request.obligations().stream().filter(item -> item.daysUntilDue() < 0).count();
        BigDecimal exposure = atRisk.stream().map(Obligation::penaltyExposure)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
        String decision = overdue > 0 || exposure.compareTo(new BigDecimal("500000")) >= 0 ? "ESCALATE"
            : atRisk.isEmpty() ? "CONTROLLED" : "ACT_NOW";
        List<String> actions = new ArrayList<>();
        if (overdue > 0) actions.add("升级逾期义务并通知法务与业务负责人");
        if (atRisk.stream().anyMatch(item -> !item.ownerAssigned())) actions.add("为无责任人的义务指定履约负责人");
        if (!atRisk.isEmpty()) actions.add("补齐履约证据并解除外部依赖");
        if (atRisk.isEmpty()) actions.add("保持当前提醒计划并归档履约证据");
        return new Result(request.contractNo(), atRisk.size(), overdue, exposure,
            decision, atRisk.stream().map(Obligation::obligationCode).toList(), actions);
    }

    public record Request(@NotBlank String contractNo,
                          @NotEmpty List<@Valid Obligation> obligations) {}
    public record Obligation(@NotBlank String obligationCode, int daysUntilDue,
                             @DecimalMin("0") BigDecimal penaltyExposure,
                             boolean ownerAssigned, boolean evidenceReady,
                             boolean dependencyBlocked) {}
    public record Result(String contractNo, int atRiskObligations, int overdueObligations,
                         BigDecimal penaltyExposure, String decision,
                         List<String> obligationCodes, List<String> actions) {}
}
