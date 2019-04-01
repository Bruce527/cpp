/*     */ package com.sinosoft.map.user;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ public class UserModel
/*     */   implements Serializable
/*     */ {
/*     */   private String userType;
/*     */   private String userCode;
/*     */   private String password;
/*     */   private String manageCom;
/*     */   private String branchType;
/*     */   private String branchAttr;
/*     */   private String userState;
/*     */   private String lastLoginDate;
/*     */   private String lastLoginTime;
/*     */   private String loginDate;
/*     */   private String loginTime;
/*     */   private String calDate;
/*     */   private String calWeek;
/*     */   private String ecGrade;
/*     */   private String name;
/*     */   private String agentGrade;
/*     */   private String[] menus;
/*  26 */   private boolean popupFlag = true;
/*     */   private boolean isLogin;
/*     */   private String pwdLastSetDate;
/*     */   private String showUserCode;
/*     */   private String showBranchattr;
/*     */ 
/*     */   public String getPwdLastSetDate()
/*     */   {
/*  36 */     return this.pwdLastSetDate;
/*     */   }
/*     */ 
/*     */   public void setPwdLastSetDate(String pwdLastSetDate) {
/*  40 */     this.pwdLastSetDate = pwdLastSetDate;
/*     */   }
/*     */ 
/*     */   public String getCalWeek() {
/*  44 */     return this.calWeek;
/*     */   }
/*     */ 
/*     */   public void setCalWeek(String calWeek) {
/*  48 */     this.calWeek = calWeek;
/*     */   }
/*     */ 
/*     */   public String getBranchAttr() {
/*  52 */     return this.branchAttr;
/*     */   }
/*     */ 
/*     */   public void setBranchAttr(String branchAttr) {
/*  56 */     this.branchAttr = branchAttr;
/*     */   }
/*     */ 
/*     */   public String getUserType() {
/*  60 */     return this.userType;
/*     */   }
/*     */ 
/*     */   public String getLoginTime() {
/*  64 */     return this.loginTime;
/*     */   }
/*     */ 
/*     */   public void setLoginTime(String loginTime) {
/*  68 */     this.loginTime = loginTime;
/*     */   }
/*     */ 
/*     */   public String getLastLoginTime() {
/*  72 */     return this.lastLoginTime;
/*     */   }
/*     */ 
/*     */   public void setLastLoginTime(String lastLoginTime) {
/*  76 */     this.lastLoginTime = lastLoginTime;
/*     */   }
/*     */ 
/*     */   public void setUserType(String userType) {
/*  80 */     this.userType = userType;
/*     */   }
/*     */ 
/*     */   public String getUserCode() {
/*  84 */     return this.userCode;
/*     */   }
/*     */ 
/*     */   public void setUserCode(String userCode) {
/*  88 */     this.userCode = userCode;
/*     */   }
/*     */ 
/*     */   public String getPassword() {
/*  92 */     return this.password;
/*     */   }
/*     */ 
/*     */   public void setPassword(String password) {
/*  96 */     this.password = password;
/*     */   }
/*     */ 
/*     */   public String getManageCom() {
/* 100 */     return this.manageCom;
/*     */   }
/*     */ 
/*     */   public void setManageCom(String manageCom) {
/* 104 */     this.manageCom = manageCom;
/*     */   }
/*     */ 
/*     */   public String getUserState() {
/* 108 */     return this.userState;
/*     */   }
/*     */ 
/*     */   public void setUserState(String userState) {
/* 112 */     this.userState = userState;
/*     */   }
/*     */ 
/*     */   public boolean isLogin() {
/* 116 */     return this.isLogin;
/*     */   }
/*     */ 
/*     */   public void setLogin(boolean isLogin) {
/* 120 */     this.isLogin = isLogin;
/*     */   }
/*     */ 
/*     */   public String getBranchType() {
/* 124 */     return this.branchType;
/*     */   }
/*     */ 
/*     */   public void setBranchType(String branchType) {
/* 128 */     this.branchType = branchType;
/*     */   }
/*     */ 
/*     */   public String getLastLoginDate() {
/* 132 */     return this.lastLoginDate;
/*     */   }
/*     */ 
/*     */   public void setLastLoginDate(String lastLoginDate) {
/* 136 */     this.lastLoginDate = lastLoginDate;
/*     */   }
/*     */ 
/*     */   public String getName() {
/* 140 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/* 144 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String getAgentGrade() {
/* 148 */     return this.agentGrade;
/*     */   }
/*     */ 
/*     */   public void setAgentGrade(String agentGrade) {
/* 152 */     this.agentGrade = agentGrade;
/*     */   }
/*     */ 
/*     */   public String getLoginDate() {
/* 156 */     return this.loginDate;
/*     */   }
/*     */ 
/*     */   public void setLoginDate(String loginDate) {
/* 160 */     this.loginDate = loginDate;
/*     */   }
/*     */ 
/*     */   public String getCalDate() {
/* 164 */     return this.calDate;
/*     */   }
/*     */ 
/*     */   public void setCalDate(String calDate) {
/* 168 */     this.calDate = calDate;
/*     */   }
/*     */ 
/*     */   public String getEcGrade() {
/* 172 */     return this.ecGrade;
/*     */   }
/*     */ 
/*     */   public void setEcGrade(String ecGrade) {
/* 176 */     this.ecGrade = ecGrade;
/*     */   }
/*     */ 
/*     */   public String[] getMenus() {
/* 180 */     return this.menus;
/*     */   }
/*     */ 
/*     */   public void setMenus(String[] menus) {
/* 184 */     this.menus = menus;
/*     */   }
/*     */ 
/*     */   public boolean isPopupFlag() {
/* 188 */     return this.popupFlag;
/*     */   }
/*     */ 
/*     */   public void setPopupFlag(boolean popupFlag) {
/* 192 */     this.popupFlag = popupFlag;
/*     */   }
/*     */ 
/*     */   public String getShowUserCode() {
/* 196 */     return this.showUserCode;
/*     */   }
/*     */ 
/*     */   public void setShowUserCode(String showUserCode) {
/* 200 */     this.showUserCode = showUserCode;
/*     */   }
/*     */ 
/*     */   public String getShowBranchattr() {
/* 204 */     return this.showBranchattr;
/*     */   }
/*     */ 
/*     */   public void setShowBranchattr(String showBranchattr) {
/* 208 */     this.showBranchattr = showBranchattr;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.user.UserModel
 * JD-Core Version:    0.6.0
 */