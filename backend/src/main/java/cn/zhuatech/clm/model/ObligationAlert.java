/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.clm.model;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="clm_obligation_alert") public class ObligationAlert extends BaseEntity {
    public enum Result { PENDING, PASSED, FAILED }
    @Column(nullable=false,unique=true,length=32) private String obligationAlertNo; @ManyToOne(optional=false,fetch=FetchType.LAZY) private ContractReview contractReview;
    @Column(nullable=false,length=30) private String obligationAlertType; @Column(nullable=false) private int obligationAlertQty; @Column(nullable=false) private int defectQty; @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private Result result;
    @Column(length=50) private String inspector; @Column(nullable=false) private LocalDateTime createdAt;
    protected ObligationAlert(){} public ObligationAlert(String obligationAlertNo,ContractReview contractReview,String obligationAlertType,int obligationAlertQty,int defectQty,Result result,String inspector){this.obligationAlertNo=obligationAlertNo;this.contractReview=contractReview;this.obligationAlertType=obligationAlertType;this.obligationAlertQty=obligationAlertQty;this.defectQty=defectQty;this.result=result;this.inspector=inspector;this.createdAt=LocalDateTime.now();}
    public String getObligationAlertNo(){return obligationAlertNo;} public ContractReview getContractReview(){return contractReview;} public String getObligationAlertType(){return obligationAlertType;} public int getObligationAlertQty(){return obligationAlertQty;} public int getDefectQty(){return defectQty;} public Result getResult(){return result;} public String getInspector(){return inspector;}
}
