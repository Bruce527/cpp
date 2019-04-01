/*    */ package com.ibm.filenet.login;
/*    */ 
/*    */ import com.filenet.api.core.Connection;
/*    */ import com.filenet.api.exception.EngineRuntimeException;
/*    */ import com.filenet.api.exception.ExceptionCode;
/*    */ import com.filenet.api.util.UserContext;
/*    */ import javax.security.auth.Subject;
/*    */ 
/*    */ public class UserContextUtils
/*    */ {
/*    */   public static Subject authenticate(Connection connection, String userName, String password, String stanzaName)
/*    */   {
/* 16 */     Subject subject = UserContext.createSubject(connection, userName, password, stanzaName);
/* 17 */     return subject;
/*    */   }
/*    */ 
/*    */   public static void pushSubject(Subject subject) {
/* 21 */     UserContext uc = UserContext.get();
/*    */     try
/*    */     {
/* 33 */       uc.pushSubject(subject);
/*    */     } catch (EngineRuntimeException e) {
/* 35 */       if (e.getExceptionCode() == ExceptionCode.E_NULL_OR_INVALID_PARAM_VALUE) {
/* 36 */         throw new RuntimeException("\u9427\u8BF2\u7D8D\u6769\u56E8\u6E61", e);
/*    */       }
/* 38 */       throw e;
/*    */     }
/*    */   }
/*    */ 
/*    */   public static Subject popSubject() {
/* 43 */     UserContext uc = UserContext.get();
/* 44 */     return uc.popSubject();
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.ibm.filenet.login.UserContextUtils
 * JD-Core Version:    0.6.0
 */