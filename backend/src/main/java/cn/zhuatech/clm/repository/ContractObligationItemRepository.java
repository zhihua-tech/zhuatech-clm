/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.clm.repository;import cn.zhuatech.clm.model.ContractObligationItem;import org.springframework.data.jpa.repository.JpaRepository;import java.util.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
public interface ContractObligationItemRepository extends JpaRepository<ContractObligationItem,Long>{/**
                                                                                                      * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                      */
List<ContractObligationItem> findByContractIdOrderByDueDateAsc(Long contractId);/**
                                                                                                                                                                                      * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                      */
Optional<ContractObligationItem> findByContractIdAndObligationNo(Long contractId,String obligationNo);}
