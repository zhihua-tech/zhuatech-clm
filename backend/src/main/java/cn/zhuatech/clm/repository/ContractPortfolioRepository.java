/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.clm.repository; import cn.zhuatech.clm.model.ContractPortfolio; import org.springframework.data.jpa.repository.JpaRepository; import java.util.Optional;
public interface ContractPortfolioRepository extends JpaRepository<ContractPortfolio,Long>{Optional<ContractPortfolio> findByCode(String code);}
