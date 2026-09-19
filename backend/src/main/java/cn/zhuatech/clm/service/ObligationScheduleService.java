/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.clm.service;
import jakarta.validation.Valid;import jakarta.validation.constraints.*;import org.springframework.stereotype.Service;import java.math.*;import java.time.*;import java.time.temporal.ChronoUnit;import java.util.*;
@Service public class ObligationScheduleService{
 public ScheduleResult schedule(@Valid ScheduleRequest request){List<ObligationView> views=new ArrayList<>();Map<String,Integer> counts=new LinkedHashMap<>();BigDecimal exposed=BigDecimal.ZERO;
  for(Obligation item:request.obligations()){long days=ChronoUnit.DAYS.between(request.asOf(),item.dueDate());String status;if(item.completed())status=item.evidenceAttached()?"COMPLETED":"EVIDENCE_REQUIRED";else if(days<0)status="OVERDUE";else if(days<=30)status="DUE_SOON";else status="PLANNED";if((status.equals("OVERDUE")||status.equals("DUE_SOON"))&&item.amount()!=null)exposed=exposed.add(item.amount());counts.merge(status,1,Integer::sum);List<String> actions=new ArrayList<>();if(item.owner()==null||item.owner().isBlank())actions.add("指定履约责任人");if(status.equals("OVERDUE"))actions.add("立即升级逾期义务");if(status.equals("EVIDENCE_REQUIRED"))actions.add("补齐履约凭证");views.add(new ObligationView(item.obligationNo(),item.type(),item.dueDate(),days,status,item.owner(),item.amount(),actions));}
  return new ScheduleResult(request.contractNo(),counts,exposed.setScale(2,RoundingMode.HALF_UP),views,counts.getOrDefault("OVERDUE",0)>0?"ESCALATE":counts.getOrDefault("DUE_SOON",0)>0?"ACTION_REQUIRED":"ON_TRACK");}
 public record ScheduleRequest(@NotBlank String contractNo,@NotNull LocalDate asOf,@NotEmpty List<@Valid Obligation> obligations){}
 public record Obligation(@NotBlank String obligationNo,@NotBlank String type,@NotNull LocalDate dueDate,@DecimalMin("0") BigDecimal amount,String owner,boolean completed,boolean evidenceAttached){}
 public record ObligationView(String obligationNo,String type,LocalDate dueDate,long daysToDue,String status,String owner,BigDecimal amount,List<String>actions){}
 public record ScheduleResult(String contractNo,Map<String,Integer>statusCounts,BigDecimal exposedAmount,List<ObligationView>obligations,String portfolioStatus){}
}
