/*    */ package com.sinosoft.map.lis.encrypt.security;
/*    */ 
/*    */ public class CryptoError extends Error
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   private CryptoError()
/*    */   {
/* 14 */     super("I thought this error was impossible to create!");
/*    */   }
/*    */ 
/*    */   CryptoError(String reason)
/*    */   {
/* 20 */     super(reason);
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.encrypt.security.CryptoError
 * JD-Core Version:    0.6.0
 */