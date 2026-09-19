/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.clm.controller;

import cn.zhuatech.clm.common.ApiResponse;
import cn.zhuatech.clm.service.RenewalRiskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/admin")
public class RenewalRiskController {
    private final RenewalRiskService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public RenewalRiskController(RenewalRiskService service) { this.service = service; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/renewal-risk")
    public ApiResponse<RenewalRiskService.Result> assess(@Valid @RequestBody RenewalRiskService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}
