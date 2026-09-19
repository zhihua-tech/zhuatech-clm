/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.clm.model;
import jakarta.persistence.*;import java.math.BigDecimal;import java.time.LocalDate;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="clm_enterprise_contract") public class EnterpriseContract extends BaseEntity {
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public enum State{DRAFT,ACTIVE,TERMINATED}
 @Column(nullable=false,unique=true,length=40) private String contractNo;@Column(nullable=false,length=160) private String title;
 @Column(nullable=false,length=120) private String counterparty;@Column(nullable=false,length=40) private String organizationCode;
 @Column(nullable=false,length=50) private String owner;@Column(nullable=false,length=3) private String currency;
 @Column(nullable=false,precision=18,scale=2) private BigDecimal amount;@Column(nullable=false) private LocalDate startDate;
 @Column(nullable=false) private LocalDate endDate;@Column(nullable=false) private boolean autoRenew;
 @Column(nullable=false) private int noticePeriodDays;@Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private State state;
 @Column(nullable=false) private int businessVersion;@Version private long rowVersion;
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 protected EnterpriseContract(){}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public EnterpriseContract(String contractNo,String title,String counterparty,String organizationCode,String owner,String currency,BigDecimal amount,LocalDate startDate,LocalDate endDate,boolean autoRenew,int noticePeriodDays){
  this.contractNo=contractNo;this.title=title;this.counterparty=counterparty;this.organizationCode=organizationCode;this.owner=owner;this.currency=currency;this.amount=amount;this.startDate=startDate;this.endDate=endDate;this.autoRenew=autoRenew;this.noticePeriodDays=noticePeriodDays;state=State.DRAFT;businessVersion=1;
 }
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public void activate(){state=State.ACTIVE;}/**
                                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                             */
public void amend(BigDecimal amount,LocalDate endDate,boolean autoRenew,int noticePeriodDays){this.amount=amount;this.endDate=endDate;this.autoRenew=autoRenew;this.noticePeriodDays=noticePeriodDays;businessVersion++;}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public String getContractNo(){return contractNo;}/**
                                                   * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                   */
public String getTitle(){return title;}/**
                                                                                          * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                          */
public String getCounterparty(){return counterparty;}/**
                                                                                                                                               * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                               */
public String getOrganizationCode(){return organizationCode;}/**
                                                                                                                                                                                                            * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                            */
public String getOwner(){return owner;}/**
                                                                                                                                                                                                                                                   * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                   */
public String getCurrency(){return currency;}/**
                                                                                                                                                                                                                                                                                                * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                */
public BigDecimal getAmount(){return amount;}/**
                                                                                                                                                                                                                                                                                                                                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                             */
public LocalDate getStartDate(){return startDate;}/**
                                                                                                                                                                                                                                                                                                                                                                                               * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                                               */
public LocalDate getEndDate(){return endDate;}/**
                                                                                                                                                                                                                                                                                                                                                                                                                                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                                                                                             */
public boolean isAutoRenew(){return autoRenew;}/**
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            */
public int getNoticePeriodDays(){return noticePeriodDays;}/**
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      */
public State getState(){return state;}/**
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            */
public int getBusinessVersion(){return businessVersion;}/**
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    */
public long getRowVersion(){return rowVersion;}
}
