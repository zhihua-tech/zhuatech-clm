/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.clm.model;
import jakarta.persistence.*;import java.time.LocalDate;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="clm_contract_obligation_item",uniqueConstraints=@UniqueConstraint(columnNames={"contractId","obligationNo"})) public class ContractObligationItem extends BaseEntity {
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public enum State{OPEN,COMPLETED,OVERDUE}
 @Column(nullable=false) private Long contractId;@Column(nullable=false,length=40) private String obligationNo;@Column(nullable=false,length=160) private String title;
 @Column(nullable=false,length=50) private String owner;@Column(nullable=false) private LocalDate dueDate;@Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private State state;
 @Column(length=300) private String completionEvidence;/**
                                                        * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                        */
protected ContractObligationItem(){}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public ContractObligationItem(Long contractId,String obligationNo,String title,String owner,LocalDate dueDate){this.contractId=contractId;this.obligationNo=obligationNo;this.title=title;this.owner=owner;this.dueDate=dueDate;this.state=State.OPEN;}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public void complete(String evidence){state=State.COMPLETED;completionEvidence=evidence;}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public Long getContractId(){return contractId;}/**
                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                 */
public String getObligationNo(){return obligationNo;}/**
                                                                                                      * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                      */
public String getTitle(){return title;}/**
                                                                                                                                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                             */
public String getOwner(){return owner;}/**
                                                                                                                                                                                    * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                    */
public LocalDate getDueDate(){return dueDate;}/**
                                                                                                                                                                                                                                  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                  */
public State getState(){return state;}/**
                                                                                                                                                                                                                                                                        * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                        */
public String getCompletionEvidence(){return completionEvidence;}
}
