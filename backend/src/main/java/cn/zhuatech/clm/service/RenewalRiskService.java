/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.clm.service;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class RenewalRiskService {
    public Result assess(Request request) {
        int score = (request.daysToExpiry() <= request.noticePeriodDays() ? 30 : 0)
            + (request.annualValue().compareTo(BigDecimal.valueOf(1_000_000)) >= 0 ? 20 : 0)
            + Math.min(24, request.openObligations() * 8)
            + (request.autoRenew() ? 15 : 0) + (request.ownerAssigned() ? 0 : 20);
        score = Math.min(100, score);
        String level = score >= 75 ? "CRITICAL" : score >= 50 ? "HIGH" : score >= 25 ? "WATCH" : "LOW";
        String timing = request.daysToExpiry() <= request.noticePeriodDays() ? "ACTION_NOW" : "MONITOR";
        List<String> actions = new ArrayList<>();
        if (request.daysToExpiry() <= request.noticePeriodDays()) actions.add("立即确认续约、终止或重新谈判决策");
        if (request.openObligations() > 0) actions.add("在续约前关闭未完成履约义务");
        if (request.autoRenew()) actions.add("核对自动续约条款和通知截止日");
        if (!request.ownerAssigned()) actions.add("指定合同续约责任人");
        return new Result(request.contractNo(), score, level, timing, actions);
    }

    public record Request(@NotBlank String contractNo, @Min(0) int daysToExpiry,
                          @DecimalMin("0") BigDecimal annualValue, boolean autoRenew,
                          @Min(0) int openObligations, @Min(0) int noticePeriodDays,
                          boolean ownerAssigned) {}
    public record Result(String contractNo, int riskScore, String level,
                         String timing, List<String> actions) {}
}
