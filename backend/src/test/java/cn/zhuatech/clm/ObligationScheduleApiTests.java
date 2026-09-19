/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.clm;import org.junit.jupiter.api.*;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.boot.test.context.SpringBootTest;import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;import org.springframework.http.MediaType;import org.springframework.test.web.servlet.MockMvc;import java.util.regex.*;import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@SpringBootTest @AutoConfigureMockMvc class ObligationScheduleApiTests{@Autowired MockMvc mvc;String token;static final String BODY="""
 {"contractNo":"CLM-1","asOf":"2026-09-20","obligations":[{"obligationNo":"OB-1","type":"PAYMENT","dueDate":"2026-09-10","amount":100000,"owner":"张三","completed":false,"evidenceAttached":false},{"obligationNo":"OB-2","type":"REPORT","dueDate":"2026-10-01","amount":0,"owner":"李四","completed":false,"evidenceAttached":false}]}
 """;
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 @BeforeEach void login()throws Exception{String json=mvc.perform(post("/api/auth/login").contentType(MediaType.APPLICATION_JSON).content("{\"username\":\"planner\",\"password\":\"Demo@2026\"}")).andReturn().getResponse().getContentAsString();Matcher matcher=Pattern.compile("\\\"token\\\":\\\"([^\\\"]+)\\\"").matcher(json);Assertions.assertTrue(matcher.find());token=matcher.group(1);}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 @Test void classifiesOverdueAndDueSoonObligations()throws Exception{mvc.perform(post("/api/advanced/clm/obligation-plan").header("Authorization","Bearer "+token).contentType(MediaType.APPLICATION_JSON).content(BODY)).andExpect(status().isOk()).andExpect(jsonPath("$.data.portfolioStatus").value("ESCALATE")).andExpect(jsonPath("$.data.statusCounts.OVERDUE").value(1)).andExpect(jsonPath("$.data.exposedAmount").value(100000));}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 @Test void anonymousIsDenied()throws Exception{mvc.perform(post("/api/advanced/clm/obligation-plan").contentType(MediaType.APPLICATION_JSON).content(BODY)).andExpect(status().isForbidden());}}
