/*     */ package com.sinosoft.map.user;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ public class LoginModel
/*     */   implements Serializable
/*     */ {
/*     */   private String userType;
/*     */   private String userCode;
/*     */   private String password;
/*     */   private String manageCom;
/*     */   private String branchType;
/*     */   private String userState;
/*     */   private boolean verifyResult;
/*     */   private boolean verifyPwd;
/*     */   private String pwdLastSetDate;
/*     */   private boolean isLogin;
/*     */ 
/*     */   public String getUserType()
/*     */   {
/*  28 */     return this.userType;
/*     */   }
/*     */ 
/*     */   public void setUserType(String userType) {
/*  32 */     this.userType = userType;
/*     */   }
/*     */ 
/*     */   public String getUserCode() {
/*  36 */     return this.userCode;
/*     */   }
/*     */ 
/*     */   public void setUserCode(String userCode) {
/*  40 */     this.userCode = userCode;
/*     */   }
/*     */ 
/*     */   public String getPassword() {
/*  44 */     return this.password;
/*     */   }
/*     */ 
/*     */   public void setPassword(String password) {
/*  48 */     this.password = password;
/*     */   }
/*     */ 
/*     */   public String getManageCom() {
/*  52 */     return this.manageCom;
/*     */   }
/*     */ 
/*     */   public void setManageCom(String manageCom) {
/*  56 */     this.manageCom = manageCom;
/*     */   }
/*     */ 
/*     */   public String getUserState() {
/*  60 */     return this.userState;
/*     */   }
/*     */ 
/*     */   public void setUserState(String userState) {
/*  64 */     this.userState = userState;
/*     */   }
/*     */ 
/*     */   public boolean isLogin() {
/*  68 */     return this.isLogin;
/*     */   }
/*     */ 
/*     */   public void setLogin(boolean isLogin) {
/*  72 */     this.isLogin = isLogin;
/*     */   }
/*     */ 
/*     */   public String getBranchType() {
/*  76 */     return this.branchType;
/*     */   }
/*     */ 
/*     */   public void setBranchType(String branchType) {
/*  80 */     this.branchType = branchType;
/*     */   }
/*     */ 
/*     */   public boolean isVerifyResult() {
/*  84 */     return this.verifyResult;
/*     */   }
/*     */ 
/*     */   public void setVerifyResult(boolean verifyResult) {
/*  88 */     this.verifyResult = verifyResult;
/*     */   }
/*     */ 
/*     */   public String getPwdLastSetDate() {
/*  92 */     return this.pwdLastSetDate;
/*     */   }
/*     */ 
/*     */   public void setPwdLastSetDate(String pwdLastSetDate) {
/*  96 */     this.pwdLastSetDate = pwdLastSetDate;
/*     */   }
/*     */ 
/*     */   public boolean isVerifyPwd() {
/* 100 */     return this.verifyPwd;
/*     */   }
/*     */ 
/*     */   public void setVerifyPwd(boolean verifyPwd) {
/* 104 */     this.verifyPwd = verifyPwd;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.user.LoginModel
 * JD-Core Version:    0.6.0
 */