/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.clm.service;
import org.junit.jupiter.api.Test; import static org.assertj.core.api.Assertions.assertThat;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class ContractEffectivenessGovernanceServiceTest{
 private final ContractEffectivenessGovernanceService service=new ContractEffectivenessGovernanceService();
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 @Test void activatesControlledContract(){var r=service.assess(new ContractEffectivenessGovernanceService.Request("CLM-001",true,true,true,true,true,true,true,true,true));assertThat(r.decision()).isEqualTo(ContractEffectivenessGovernanceService.Decision.EFFECTIVE);}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 @Test void holdsUnapprovedContract(){var r=service.assess(new ContractEffectivenessGovernanceService.Request("CLM-002",false,false,false,false,false,false,false,false,false));assertThat(r.decision()).isEqualTo(ContractEffectivenessGovernanceService.Decision.HOLD);assertThat(r.blockers()).hasSize(5);assertThat(r.actions()).hasSize(4);}
}
