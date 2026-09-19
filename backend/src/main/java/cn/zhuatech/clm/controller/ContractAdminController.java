/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.clm.controller; import cn.zhuatech.clm.common.ApiResponse; import cn.zhuatech.clm.dto.ClmDto.*; import cn.zhuatech.clm.service.ClmService; import org.springframework.security.access.prepost.PreAuthorize; import org.springframework.web.bind.annotation.*; import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/admin") @PreAuthorize("hasAnyRole('CONTRACT_MANAGER','QUALITY','ADMIN')") public class ContractAdminController {private final ClmService service;/**
                                                                                                                                                                                        * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                        */
public ContractAdminController(ClmService service){this.service=service;}/**
                                                                                                                                                                                                                                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                 */
@GetMapping("/dashboard") public ApiResponse<Dashboard> dashboard(){return ApiResponse.ok(service.adminDashboard());}/**
                                                                                                                                                                                                                                                                                                                                                                                      * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                                      */
@GetMapping("/work-orders") public ApiResponse<List<ContractReviewView>> orders(){return ApiResponse.ok(service.contractReviews());}}
