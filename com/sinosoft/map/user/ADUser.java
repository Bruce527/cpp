/*    */ package com.sinosoft.map.user;
/*    */ 
/*    */ public class ADUser
/*    */ {
/*    */   private String userCode;
/*    */   private String passWord;
/*    */   private String pwdLastSetDate;
/*    */   private boolean isLogin;
/*    */   private String newPassWord;
/*    */ 
/*    */   public String getNewPassWord()
/*    */   {
/* 21 */     return this.newPassWord;
/*    */   }
/*    */ 
/*    */   public void setNewPassWord(String newPassWord) {
/* 25 */     this.newPassWord = newPassWord;
/*    */   }
/*    */ 
/*    */   public String getPwdLastSetDate() {
/* 29 */     return this.pwdLastSetDate;
/*    */   }
/*    */ 
/*    */   public void setPwdLastSetDate(String pwdLastSetDate) {
/* 33 */     this.pwdLastSetDate = pwdLastSetDate;
/*    */   }
/*    */ 
/*    */   public String getUserCode() {
/* 37 */     return this.userCode;
/*    */   }
/*    */ 
/*    */   public void setUserCode(String userCode) {
/* 41 */     this.userCode = userCode;
/*    */   }
/*    */ 
/*    */   public String getPassWord() {
/* 45 */     return this.passWord;
/*    */   }
/*    */ 
/*    */   public void setPassWord(String passWord) {
/* 49 */     this.passWord = passWord;
/*    */   }
/*    */ 
/*    */   public boolean isLogin()
/*    */   {
/* 54 */     return this.isLogin;
/*    */   }
/*    */ 
/*    */   public void setLogin(boolean isLogin) {
/* 58 */     this.isLogin = isLogin;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.user.ADUser
 * JD-Core Version:    0.6.0
 */