/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.clm.config;

import cn.zhuatech.clm.model.*;
import cn.zhuatech.clm.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner seed(ContractPortfolioRepository contractPortfolios, ContractReviewRepository orders,
                           ClauseTemplateRepository clauseTemplates, ObligationAlertRepository obligationAlerts,
                           UserRepository users, PasswordEncoder encoder) {
        return args -> {
            if (contractPortfolios.count() > 0) return;
            ContractPortfolio chemistry = contractPortfolios.save(new ContractPortfolio("CLM-CHEM", "销售合同组合", "合同中心", 180));
            ContractPortfolio micro = contractPortfolios.save(new ContractPortfolio("CLM-MICRO", "渠道合同组合", "研发中心", 120));
            ContractPortfolio material = contractPortfolios.save(new ContractPortfolio("CLM-MAT", "采购合同组合", "工程中心", 96));

            ContractReview t1 = orders.save(new ContractReview("CTR-260801-018", "GB-T-228", "华东区域年度框架采购合同", material, 24, 16, 1, LocalDate.now().plusDays(1), ContractReview.Status.RUNNING, "V3.2"));
            ContractReview t2 = orders.save(new ContractReview("CTR-260801-021", "CLM-SAAS-03", "软件私有化部署合同", chemistry, 18, 8, 0, LocalDate.now().plusDays(1), ContractReview.Status.RUNNING, "V2.1"));
            ContractReview t3 = orders.save(new ContractReview("CTR-260802-006", "ISO-4833", "渠道合作协议", micro, 12, 0, 0, LocalDate.now().plusDays(3), ContractReview.Status.RELEASED, "V1.4"));
            ContractReview t4 = orders.save(new ContractReview("CTR-260723-015", "CLM-MAINT-04", "客户维保续费合同", chemistry, 20, 20, 1, LocalDate.now(), ContractReview.Status.COMPLETED, "V5.0"));

            clauseTemplates.saveAll(List.of(
                new ClauseTemplate("CLS-HPLC-03", "付款条款模板", chemistry, ClauseTemplate.Status.RUNNING, 88),
                new ClauseTemplate("CLS-ICP-02", "交付验收模板", chemistry, ClauseTemplate.Status.IDLE, 76),
                new ClauseTemplate("CLS-UTM-05", "违约责任条款", material, ClauseTemplate.Status.RUNNING, 91),
                new ClauseTemplate("CLS-INC-08", "数据保护条款", micro, ClauseTemplate.Status.ALARM, 62)
            ));
            obligationAlerts.saveAll(List.of(
                new ObligationAlert("OBL-260801-032", t1, "留样复核", 6, 0, ObligationAlert.Result.PASSED, "周妍"),
                new ObligationAlert("OBL-260801-011", t2, "前处理复核", 3, 0, ObligationAlert.Result.PASSED, "陆承"),
                new ObligationAlert("OBL-260801-018", t4, "法务复核", 5, 1, ObligationAlert.Result.FAILED, "周妍"),
                new ObligationAlert("OBL-260802-003", t3, "合同收件确认", 4, 0, ObligationAlert.Result.PENDING, "陆承")
            ));
            String demo = encoder.encode("Demo@2026");
            users.saveAll(List.of(
                new UserAccount("operator", demo, "陆承", UserAccount.Role.CONTRACT_SPECIALIST, "CLM-CHEM"),
                new UserAccount("planner", demo, "周妍", UserAccount.Role.CONTRACT_MANAGER, null),
                new UserAccount("quality", demo, "顾清", UserAccount.Role.QUALITY, null),
                new UserAccount("admin", encoder.encode("ZhuaTech@2026"), "系统管理员", UserAccount.Role.ADMIN, null)
            ));
        };
    }
}
