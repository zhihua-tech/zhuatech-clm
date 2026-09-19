/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.clm.model;
import jakarta.persistence.*;import java.math.BigDecimal;import java.time.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="clm_contract_amendment") public class ContractAmendment extends BaseEntity {
 @Column(nullable=false) private Long contractId;@Column(nullable=false) private int fromVersion;@Column(nullable=false) private int toVersion;
 @Column(nullable=false,precision=18,scale=2) private BigDecimal previousAmount;@Column(nullable=false,precision=18,scale=2) private BigDecimal newAmount;
 @Column(nullable=false) private LocalDate previousEndDate;@Column(nullable=false) private LocalDate newEndDate;@Column(nullable=false,length=300) private String reason;
 @Column(nullable=false,length=50) private String changedBy;/**
                                                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                             */
protected ContractAmendment(){}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public ContractAmendment(Long contractId,int fromVersion,int toVersion,BigDecimal previousAmount,BigDecimal newAmount,LocalDate previousEndDate,LocalDate newEndDate,String reason,String changedBy){this.contractId=contractId;this.fromVersion=fromVersion;this.toVersion=toVersion;this.previousAmount=previousAmount;this.newAmount=newAmount;this.previousEndDate=previousEndDate;this.newEndDate=newEndDate;this.reason=reason;this.changedBy=changedBy;}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public Long getContractId(){return contractId;}/**
                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                 */
public int getFromVersion(){return fromVersion;}/**
                                                                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                 */
public int getToVersion(){return toVersion;}/**
                                                                                                                                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                             */
public BigDecimal getPreviousAmount(){return previousAmount;}/**
                                                                                                                                                                                                          * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                          */
public BigDecimal getNewAmount(){return newAmount;}/**
                                                                                                                                                                                                                                                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                             */
public LocalDate getPreviousEndDate(){return previousEndDate;}/**
                                                                                                                                                                                                                                                                                                                           * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                           */
public LocalDate getNewEndDate(){return newEndDate;}/**
                                                                                                                                                                                                                                                                                                                                                                               * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                               */
public String getReason(){return reason;}/**
                                                                                                                                                                                                                                                                                                                                                                                                                        * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                                                                        */
public String getChangedBy(){return changedBy;}
}
