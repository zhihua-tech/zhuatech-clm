# Clm 架构

版权所有 © 2026 上海如静知华信息科技有限公司。

浏览器通过 Vue 管理端或合同专员端访问 Spring Boot REST API。安全层完成 JWT 与角色鉴权，业务层负责合同审查、合同、条款模板、复核和结果记录，JPA/Flyway 管理 MySQL 数据。

管理端角色为 `CONTRACT_MANAGER`、`QUALITY`、`ADMIN`；执行端角色为 `CONTRACT_SPECIALIST`。正式部署建议将条款模板连接置于独立采集服务，并隔离合同组合网络和办公网络。
