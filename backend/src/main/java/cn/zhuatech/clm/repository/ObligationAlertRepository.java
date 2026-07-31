/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.clm.repository; import cn.zhuatech.clm.model.ObligationAlert; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface ObligationAlertRepository extends JpaRepository<ObligationAlert,Long>{List<ObligationAlert> findTop10ByOrderByIdDesc();long countByResult(ObligationAlert.Result result);}
