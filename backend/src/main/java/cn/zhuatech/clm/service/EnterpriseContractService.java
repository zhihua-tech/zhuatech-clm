/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.clm.service;
import cn.zhuatech.clm.common.BusinessException;import cn.zhuatech.clm.model.*;import cn.zhuatech.clm.repository.*;import jakarta.validation.constraints.*;
import org.springframework.stereotype.Service;import org.springframework.transaction.annotation.Transactional;import java.math.BigDecimal;import java.time.LocalDate;import java.util.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Service @Transactional(readOnly=true) public class EnterpriseContractService {
 private final EnterpriseContractRepository contracts;private final ContractAmendmentRepository amendments;private final ContractObligationItemRepository obligations;private final CurrentUserService current;
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public EnterpriseContractService(EnterpriseContractRepository contracts,ContractAmendmentRepository amendments,ContractObligationItemRepository obligations,CurrentUserService current){this.contracts=contracts;this.amendments=amendments;this.obligations=obligations;this.current=current;}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public List<EnterpriseContract> list(){return contracts.findAllByOrderByEndDateAsc();}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 @Transactional public EnterpriseContract create(CreateRequest r){if(!r.endDate().isAfter(r.startDate()))throw new BusinessException("合同结束日期必须晚于开始日期");if(contracts.findByContractNo(r.contractNo()).isPresent())throw new BusinessException("合同编号已存在");return contracts.save(new EnterpriseContract(r.contractNo(),r.title(),r.counterparty(),r.organizationCode(),r.owner(),r.currency(),r.amount(),r.startDate(),r.endDate(),r.autoRenew(),r.noticePeriodDays()));}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 @Transactional public EnterpriseContract activate(Long id){var c=get(id);if(c.getState()!=EnterpriseContract.State.DRAFT)throw new BusinessException("只有草稿合同可以生效");c.activate();return c;}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 @Transactional public EnterpriseContract amend(Long id,AmendRequest r){var c=get(id);if(c.getState()!=EnterpriseContract.State.ACTIVE)throw new BusinessException("只有生效合同可以变更");if(c.getBusinessVersion()!=r.expectedVersion())throw new BusinessException("合同版本已变化，请刷新后重试");if(!r.newEndDate().isAfter(c.getStartDate()))throw new BusinessException("新结束日期不合法");int from=c.getBusinessVersion();BigDecimal previousAmount=c.getAmount();LocalDate previousEnd=c.getEndDate();c.amend(r.newAmount(),r.newEndDate(),r.autoRenew(),r.noticePeriodDays());amendments.save(new ContractAmendment(c.getId(),from,c.getBusinessVersion(),previousAmount,c.getAmount(),previousEnd,c.getEndDate(),r.reason(),current.get().getFullName()));return c;}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 @Transactional public ContractObligationItem addObligation(Long id,ObligationRequest r){get(id);if(obligations.findByContractIdAndObligationNo(id,r.obligationNo()).isPresent())throw new BusinessException("履约义务编号已存在");return obligations.save(new ContractObligationItem(id,r.obligationNo(),r.title(),r.owner(),r.dueDate()));}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 @Transactional public ContractObligationItem completeObligation(Long id,Long obligationId,CompleteRequest r){get(id);var item=obligations.findById(obligationId).orElseThrow(()->new BusinessException("履约义务不存在"));if(!item.getContractId().equals(id))throw new BusinessException("履约义务不属于该合同");if(item.getState()==ContractObligationItem.State.COMPLETED)throw new BusinessException("履约义务已完成");item.complete(r.evidence());return item;}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public Detail detail(Long id){var c=get(id);return new Detail(c,amendments.findByContractIdOrderByToVersionDesc(id),obligations.findByContractIdOrderByDueDateAsc(id));}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 private EnterpriseContract get(Long id){return contracts.findById(id).orElseThrow(()->new BusinessException("合同不存在"));}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public record CreateRequest(@NotBlank String contractNo,@NotBlank String title,@NotBlank String counterparty,@NotBlank String organizationCode,@NotBlank String owner,@NotBlank @Pattern(regexp="[A-Z]{3}") String currency,@NotNull @DecimalMin("0") BigDecimal amount,@NotNull LocalDate startDate,@NotNull LocalDate endDate,boolean autoRenew,@PositiveOrZero int noticePeriodDays){}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public record AmendRequest(@Positive int expectedVersion,@NotNull @DecimalMin("0") BigDecimal newAmount,@NotNull LocalDate newEndDate,boolean autoRenew,@PositiveOrZero int noticePeriodDays,@NotBlank @Size(max=300) String reason){}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public record ObligationRequest(@NotBlank String obligationNo,@NotBlank String title,@NotBlank String owner,@NotNull LocalDate dueDate){}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public record CompleteRequest(@NotBlank @Size(max=300) String evidence){}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public record Detail(EnterpriseContract contract,List<ContractAmendment> amendments,List<ContractObligationItem> obligations){}
}
