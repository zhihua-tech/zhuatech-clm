/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.clm.controller;
import cn.zhuatech.clm.common.ApiResponse;import cn.zhuatech.clm.model.*;import cn.zhuatech.clm.service.EnterpriseContractService;import jakarta.validation.Valid;import org.springframework.security.access.prepost.PreAuthorize;import org.springframework.web.bind.annotation.*;import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/admin/contracts") @PreAuthorize("hasAnyRole('CONTRACT_MANAGER','ADMIN')") public class EnterpriseContractController {
 private final EnterpriseContractService service;/**
                                                  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                  */
public EnterpriseContractController(EnterpriseContractService service){this.service=service;}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 @GetMapping ApiResponse<List<EnterpriseContract>> list(){return ApiResponse.ok(service.list());}/**
                                                                                                  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                  */
@PostMapping ApiResponse<EnterpriseContract> create(@Valid @RequestBody EnterpriseContractService.CreateRequest r){return ApiResponse.ok(service.create(r));}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 @GetMapping("/{id}") ApiResponse<EnterpriseContractService.Detail> detail(@PathVariable Long id){return ApiResponse.ok(service.detail(id));}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 @PostMapping("/{id}/activate") ApiResponse<EnterpriseContract> activate(@PathVariable Long id){return ApiResponse.ok(service.activate(id));}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 @PostMapping("/{id}/amendments") ApiResponse<EnterpriseContract> amend(@PathVariable Long id,@Valid @RequestBody EnterpriseContractService.AmendRequest r){return ApiResponse.ok(service.amend(id,r));}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 @PostMapping("/{id}/obligations") ApiResponse<ContractObligationItem> obligation(@PathVariable Long id,@Valid @RequestBody EnterpriseContractService.ObligationRequest r){return ApiResponse.ok(service.addObligation(id,r));}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 @PostMapping("/{id}/obligations/{obligationId}/complete") ApiResponse<ContractObligationItem> complete(@PathVariable Long id,@PathVariable Long obligationId,@Valid @RequestBody EnterpriseContractService.CompleteRequest r){return ApiResponse.ok(service.completeObligation(id,obligationId,r));}
}
