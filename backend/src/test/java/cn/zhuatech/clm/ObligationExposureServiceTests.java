/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.clm;

import cn.zhuatech.clm.service.ObligationExposureService;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ObligationExposureServiceTests {
    private final ObligationExposureService service = new ObligationExposureService();

    @Test void escalatesMaterialObligationExposure() {
        var result = service.evaluate(new ObligationExposureService.Request("C-1001", List.of(
            new ObligationExposureService.Obligation("DELIVERY", 10, new BigDecimal("600000"), true, false, true),
            new ObligationExposureService.Obligation("REPORT", 60, new BigDecimal("10000"), true, false, false))));
        assertEquals(new BigDecimal("600000"), result.penaltyExposure());
        assertEquals("ESCALATE", result.decision());
    }

    @Test void keepsReadyObligationsControlled() {
        var result = service.evaluate(new ObligationExposureService.Request("C-1002", List.of(
            new ObligationExposureService.Obligation("INVOICE", 15, new BigDecimal("10000"), true, true, false))));
        assertEquals("CONTROLLED", result.decision());
    }
}
