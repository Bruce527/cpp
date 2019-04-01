/*    */ package com.sinosoft.map.ec.datamodel;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class LoginModel
/*    */   implements Serializable
/*    */ {
/*    */   private String userType;
/*    */   private String userCode;
/*    */   private String password;
/*    */   private String manageCom;
/*    */   private String branchType;
/*    */   private String userState;
/*    */   private boolean verifyResult;
/*    */   private boolean isLogin;
/*    */ 
/*    */   public String getUserType()
/*    */   {
/* 22 */     return this.userType;
/*    */   }
/*    */ 
/*    */   public void setUserType(String userType) {
/* 26 */     this.userType = userType;
/*    */   }
/*    */ 
/*    */   public String getUserCode() {
/* 30 */     return this.userCode;
/*    */   }
/*    */ 
/*    */   public void setUserCode(String userCode) {
/* 34 */     this.userCode = userCode;
/*    */   }
/*    */ 
/*    */   public String getPassword() {
/* 38 */     return this.password;
/*    */   }
/*    */ 
/*    */   public void setPassword(String password) {
/* 42 */     this.password = password;
/*    */   }
/*    */ 
/*    */   public String getManageCom() {
/* 46 */     return this.manageCom;
/*    */   }
/*    */ 
/*    */   public void setManageCom(String manageCom) {
/* 50 */     this.manageCom = manageCom;
/*    */   }
/*    */ 
/*    */   public String getUserState() {
/* 54 */     return this.userState;
/*    */   }
/*    */ 
/*    */   public void setUserState(String userState) {
/* 58 */     this.userState = userState;
/*    */   }
/*    */ 
/*    */   public boolean isLogin() {
/* 62 */     return this.isLogin;
/*    */   }
/*    */ 
/*    */   public void setLogin(boolean isLogin) {
/* 66 */     this.isLogin = isLogin;
/*    */   }
/*    */ 
/*    */   public String getBranchType() {
/* 70 */     return this.branchType;
/*    */   }
/*    */ 
/*    */   public void setBranchType(String branchType) {
/* 74 */     this.branchType = branchType;
/*    */   }
/*    */ 
/*    */   public boolean isVerifyResult() {
/* 78 */     return this.verifyResult;
/*    */   }
/*    */ 
/*    */   public void setVerifyResult(boolean verifyResult) {
/* 82 */     this.verifyResult = verifyResult;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.ec.datamodel.LoginModel
 * JD-Core Version:    0.6.0
 */