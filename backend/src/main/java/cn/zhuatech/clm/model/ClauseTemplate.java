/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.clm.model;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="clm_clause_template") public class ClauseTemplate extends BaseEntity {
    public enum Status { RUNNING, IDLE, MAINTENANCE, ALARM }
    @Column(nullable=false,unique=true,length=32) private String code; @Column(nullable=false,length=80) private String name; @ManyToOne(optional=false,fetch=FetchType.LAZY) private ContractPortfolio contractPortfolio;
    @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private Status status; @Column(nullable=false) private int oee; @Column(nullable=false) private LocalDateTime lastHeartbeat;
    protected ClauseTemplate(){} public ClauseTemplate(String code,String name,ContractPortfolio contractPortfolio,Status status,int oee){this.code=code;this.name=name;this.contractPortfolio=contractPortfolio;this.status=status;this.oee=oee;this.lastHeartbeat=LocalDateTime.now();}
    public String getCode(){return code;} public String getName(){return name;} public ContractPortfolio getContractPortfolio(){return contractPortfolio;} public Status getStatus(){return status;} public int getOee(){return oee;} public LocalDateTime getLastHeartbeat(){return lastHeartbeat;}
}
