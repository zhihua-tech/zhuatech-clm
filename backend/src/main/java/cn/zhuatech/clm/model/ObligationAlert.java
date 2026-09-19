/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.clm.model;
import jakarta.persistence.*; import java.time.LocalDateTime;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="clm_obligation_alert") public class ObligationAlert extends BaseEntity {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public enum Result { PENDING, PASSED, FAILED }
    @Column(nullable=false,unique=true,length=32) private String obligationAlertNo; @ManyToOne(optional=false,fetch=FetchType.LAZY) private ContractReview contractReview;
    @Column(nullable=false,length=30) private String obligationAlertType; @Column(nullable=false) private int obligationAlertQty; @Column(nullable=false) private int defectQty; @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private Result result;
    @Column(length=50) private String inspector; @Column(nullable=false) private LocalDateTime createdAt;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected ObligationAlert(){} /**
                                   * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                   */
public ObligationAlert(String obligationAlertNo,ContractReview contractReview,String obligationAlertType,int obligationAlertQty,int defectQty,Result result,String inspector){this.obligationAlertNo=obligationAlertNo;this.contractReview=contractReview;this.obligationAlertType=obligationAlertType;this.obligationAlertQty=obligationAlertQty;this.defectQty=defectQty;this.result=result;this.inspector=inspector;this.createdAt=LocalDateTime.now();}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getObligationAlertNo(){return obligationAlertNo;} /**
                                                                     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                     */
public ContractReview getContractReview(){return contractReview;} /**
                                                                                                                                       * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                       */
public String getObligationAlertType(){return obligationAlertType;} /**
                                                                                                                                                                                                           * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                           */
public int getObligationAlertQty(){return obligationAlertQty;} /**
                                                                                                                                                                                                                                                                          * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                          */
public int getDefectQty(){return defectQty;} /**
                                                                                                                                                                                                                                                                                                                       * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                       */
public Result getResult(){return result;} /**
                                                                                                                                                                                                                                                                                                                                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                 */
public String getInspector(){return inspector;}
}
