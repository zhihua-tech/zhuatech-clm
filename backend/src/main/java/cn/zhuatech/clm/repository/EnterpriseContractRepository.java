/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.clm.repository;import cn.zhuatech.clm.model.EnterpriseContract;import org.springframework.data.jpa.repository.JpaRepository;import java.util.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
public interface EnterpriseContractRepository extends JpaRepository<EnterpriseContract,Long>{/**
                                                                                              * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                              */
Optional<EnterpriseContract> findByContractNo(String contractNo);/**
                                                                                                                                                               * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                               */
List<EnterpriseContract> findAllByOrderByEndDateAsc();}
