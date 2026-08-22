/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.clm.repository; import cn.zhuatech.clm.model.ClauseTemplate; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface ClauseTemplateRepository extends JpaRepository<ClauseTemplate,Long>{List<ClauseTemplate> findAllByOrderByCodeAsc();long countByStatus(ClauseTemplate.Status status);}
