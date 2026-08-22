/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.clm.controller;

import cn.zhuatech.clm.common.ApiResponse;
import cn.zhuatech.clm.service.ObligationExposureService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clm/insights")
public class ObligationExposureController {
    private final ObligationExposureService service;
    public ObligationExposureController(ObligationExposureService service) { this.service = service; }
    @PostMapping("/obligation-exposure")
    public ApiResponse<ObligationExposureService.Result> evaluate(
        @Valid @RequestBody ObligationExposureService.Request request) {
        return ApiResponse.ok(service.evaluate(request));
    }
}
