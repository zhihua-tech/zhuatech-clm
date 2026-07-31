/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.clm.model;
import jakarta.persistence.*;
@Entity @Table(name="clm_user")
public class UserAccount extends BaseEntity {
    public enum Role { ADMIN, CONTRACT_MANAGER, CONTRACT_SPECIALIST, QUALITY }
    @Column(nullable=false,unique=true,length=32) private String username; @Column(nullable=false) private String password;
    @Column(nullable=false,length=50) private String fullName; @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private Role role;
    @Column(name="contract_portfolio_code",length=32) private String contractPortfolioCode; @Column(nullable=false) private boolean enabled=true;
    protected UserAccount(){}
    public UserAccount(String username,String password,String fullName,Role role,String contractPortfolioCode){this.username=username;this.password=password;this.fullName=fullName;this.role=role;this.contractPortfolioCode=contractPortfolioCode;}
    public String getUsername(){return username;} public String getPassword(){return password;} public String getFullName(){return fullName;} public Role getRole(){return role;} public String getContractPortfolioCode(){return contractPortfolioCode;} public boolean isEnabled(){return enabled;}
}
