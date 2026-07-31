/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.clm.dto;
import jakarta.validation.constraints.*; import java.time.*; import java.util.List;
public final class ClmDto { private ClmDto(){}
    public record Metric(String label,String value,String hint,String tone){}
    public record ContractReviewView(Long id,String orderNo,String productCode,String productName,String contractPortfolio,String workshop,int plannedQty,int completedQty,int defectQty,LocalDate dueDate,String status,String batchNo,int progress){}
    public record ControlView(String code,String name,String contractPortfolio,String status,int oee,LocalDateTime lastHeartbeat){}
    public record ObligationAlertView(String obligationAlertNo,String orderNo,String productName,String obligationAlertType,int obligationAlertQty,int defectQty,String result,String inspector){}
    public record Dashboard(List<Metric> metrics,List<ContractReviewView> contractReviews,List<ControlView> clauseTemplate,List<ObligationAlertView> obligationAlerts){}
    public record ReportRequest(@NotBlank String operationName,@Positive int goodQty,@PositiveOrZero int defectQty,@Size(max=200) String remark){}
    public record ReportResult(String orderNo,int completedQty,int defectQty,int progress,String status){}
}
