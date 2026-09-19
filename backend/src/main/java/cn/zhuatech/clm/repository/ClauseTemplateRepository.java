/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.clm.repository; import cn.zhuatech.clm.model.ClauseTemplate; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
public interface ClauseTemplateRepository extends JpaRepository<ClauseTemplate,Long>{/**
                                                                                      * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                      */
List<ClauseTemplate> findAllByOrderByCodeAsc();/**
                                                                                                                                     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                     */
long countByStatus(ClauseTemplate.Status status);}
