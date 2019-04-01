/*    */ package com.ibm.filenet.login;
/*    */ 
/*    */ import com.filenet.api.core.Connection;
/*    */ import com.filenet.api.core.Factory.Connection;
/*    */ import com.filenet.api.core.ObjectStore;
/*    */ import com.filenet.api.exception.EngineRuntimeException;
/*    */ import com.filenet.api.exception.ExceptionCode;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.security.auth.Subject;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class UnitLogin
/*    */ {
/* 17 */   private static Logger logger = Logger.getLogger(UnitLogin.class);
/* 18 */   private Subject subject = null;
/*    */ 
/* 20 */   private static String ceUrl = CEConfigOptions.getCeUrl();
/* 21 */   private static String domainName = CEConfigOptions.getDomainName();
/* 22 */   private static String[] defaultOsNames = CEConfigOptions.getObjectStores();
/*    */   private Map<String, ObjectStore> objectStores;
/*    */ 
/*    */   public Subject login(String userName, String passWord)
/*    */   {
/* 26 */     return login(userName, passWord, new String[0]);
/*    */   }
/*    */ 
/*    */   public Subject login(String userName, String passWord, String osName) {
/* 30 */     return login(userName, passWord, new String[] { osName });
/*    */   }
/*    */ 
/*    */   public Subject login(String userName, String passWord, String[] osNames) {
/* 34 */     logout();
/*    */     try {
/* 36 */       DomainProvider dp = DomainProvider.getInstance();
/* 37 */       Connection connection = getConnection(userName, passWord);
/*    */ 
/* 40 */       this.objectStores = new HashMap();
/*    */ 
/* 42 */       if ((osNames == null) || (osNames.length == 0)) {
/* 43 */         osNames = defaultOsNames;
/*    */       }
/* 45 */       for (int i = 0; i < osNames.length; i++) {
/* 46 */         String osName = osNames[i];
/* 47 */         if (!StringUtils.isNotEmpty(osName))
/*    */           continue;
/*    */         try {
/* 50 */           os = dp.fetchObjectStore(connection, domainName, osName);
/*    */         }
/*    */         catch (EngineRuntimeException e)
/*    */         {
/*    */           ObjectStore os;
/* 52 */           if (e.getExceptionCode() == ExceptionCode.E_OBJECT_NOT_FOUND) {
/* 53 */             throw new RuntimeException("ObjectStore \"" + osName + "\" not found", e);
/*    */           }
/* 55 */           throw e;
/*    */         }
/*    */         ObjectStore os;
/* 57 */         this.objectStores.put(osName, os);
/*    */       }
/*    */ 
/* 60 */       logger.info("----Login Success!");
/*    */     } catch (Throwable e) {
/* 62 */       throw new RuntimeException("----Login Fail!" + e.getLocalizedMessage(), e);
/*    */     }
/*    */ 
/* 65 */     return this.subject;
/*    */   }
/*    */ 
/*    */   private Connection getConnection(String userName, String passWord) {
/* 69 */     Connection connection = null;
/*    */     try {
/* 71 */       if (this.subject == null) {
/* 72 */         String url = ceUrl;
/*    */ 
/* 74 */         logger.info("----Login to CE: " + url);
/* 75 */         connection = Factory.Connection.getConnection(url);
/* 76 */         this.subject = UserContextUtils.authenticate(connection, userName, passWord, null);
/*    */       }
/* 78 */       UserContextUtils.pushSubject(this.subject);
/*    */     } catch (EngineRuntimeException erex) {
/* 80 */       erex.printStackTrace();
/*    */     } catch (Exception ex) {
/* 82 */       ex.printStackTrace();
/*    */     }
/* 84 */     return connection;
/*    */   }
/*    */ 
/*    */   public static void logout() {
/* 88 */     UserContextUtils.popSubject();
/*    */   }
/*    */ 
/*    */   public Map<String, ObjectStore> getObjectStores() {
/* 92 */     return this.objectStores;
/*    */   }
/*    */ 
/*    */   public ObjectStore getObjectStore(String osName) {
/* 96 */     return (ObjectStore)this.objectStores.get(osName);
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.ibm.filenet.login.UnitLogin
 * JD-Core Version:    0.6.0
 */