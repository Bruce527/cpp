/*    */ package com.sinosoft.map.ec.utility;
/*    */ 
/*    */ import javax.mail.Authenticator;
/*    */ import javax.mail.PasswordAuthentication;
/*    */ 
/*    */ public class MailAuthenticator extends Authenticator
/*    */ {
/*    */   private String id;
/*    */   private String password;
/*    */ 
/*    */   public MailAuthenticator(String id, String password)
/*    */   {
/* 12 */     this.id = id;
/* 13 */     this.password = password;
/*    */   }
/*    */ 
/*    */   public PasswordAuthentication getPasswordAuthentication()
/*    */   {
/* 18 */     return new PasswordAuthentication(this.id, this.password);
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.ec.utility.MailAuthenticator
 * JD-Core Version:    0.6.0
 */