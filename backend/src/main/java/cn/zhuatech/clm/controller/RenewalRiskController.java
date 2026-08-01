/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.clm.controller;

import cn.zhuatech.clm.common.ApiResponse;
import cn.zhuatech.clm.service.RenewalRiskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class RenewalRiskController {
    private final RenewalRiskService service;
    public RenewalRiskController(RenewalRiskService service) { this.service = service; }
    @PostMapping("/renewal-risk")
    public ApiResponse<RenewalRiskService.Result> assess(@Valid @RequestBody RenewalRiskService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}
