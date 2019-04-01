/*    */ package com.sinosoft.banklns;
/*    */ 
/*    */ import javax.security.auth.Subject;
/*    */ import javax.security.auth.login.LoginContext;
/*    */ import javax.security.auth.login.LoginException;
/*    */ 
/*    */ public class TestFilenet
/*    */ {
/*    */   public static void main(String[] args)
/*    */   {
/*    */     try
/*    */     {
/* 12 */       String uri = "http://10.164.253.51:8081/wsi/FNCEWS40MTOM/";
/* 13 */       String user = "P8services";
/* 14 */       String password = "Hello01";
/* 15 */       String osName = "IWS";
/* 16 */       LoginContext lc = new LoginContext(osName);
/* 17 */       lc.login();
/* 18 */       Subject localSubject = lc.getSubject();
/*    */     }
/*    */     catch (LoginException e) {
/* 21 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.TestFilenet
 * JD-Core Version:    0.6.0
 */