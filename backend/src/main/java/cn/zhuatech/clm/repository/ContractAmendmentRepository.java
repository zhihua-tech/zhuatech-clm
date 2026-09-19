/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.clm.repository;import cn.zhuatech.clm.model.ContractAmendment;import org.springframework.data.jpa.repository.JpaRepository;import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
public interface ContractAmendmentRepository extends JpaRepository<ContractAmendment,Long>{/**
                                                                                            * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                            */
List<ContractAmendment> findByContractIdOrderByToVersionDesc(Long contractId);}
