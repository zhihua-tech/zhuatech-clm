/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.clm.repository; import cn.zhuatech.clm.model.ContractReview; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
public interface ContractReviewRepository extends JpaRepository<ContractReview,Long>{/**
                                                                                      * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                      */
List<ContractReview> findAllByOrderByDueDateAsc();/**
                                                                                                                                        * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                        */
List<ContractReview> findByContractPortfolioCodeOrderByDueDateAsc(String code);/**
                                                                                                                                                                                                                       * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                       */
long countByStatus(ContractReview.Status status);}
