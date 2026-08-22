/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.clm.repository; import cn.zhuatech.clm.model.ContractReview; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface ContractReviewRepository extends JpaRepository<ContractReview,Long>{List<ContractReview> findAllByOrderByDueDateAsc();List<ContractReview> findByContractPortfolioCodeOrderByDueDateAsc(String code);long countByStatus(ContractReview.Status status);}
