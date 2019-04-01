/*    */ package com.ibm.filenet.login;
/*    */ 
/*    */ import java.util.ResourceBundle;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ 
/*    */ public class CEConfigOptions
/*    */ {
/* 10 */   private static final ResourceBundle CONFIG_BUNDLE = ResourceBundle.getBundle("conf/p8");
/*    */ 
/*    */   public static String val(String key) {
/* 13 */     return CONFIG_BUNDLE.getString(key);
/*    */   }
/*    */ 
/*    */   public static String getCeUrl()
/*    */   {
/* 18 */     return val("ce.connectionURL");
/*    */   }
/*    */ 
/*    */   public static String getDomainName() {
/* 22 */     return val("ce.domainName");
/*    */   }
/*    */ 
/*    */   public static String[] getObjectStores() {
/* 26 */     String str = val("ce.objectStoreNames");
/* 27 */     if (StringUtils.isNotEmpty(str)) {
/* 28 */       return str.split(",");
/*    */     }
/* 30 */     return new String[0];
/*    */   }
/*    */ 
/*    */   public static int getSearchMaxPageSize()
/*    */   {
/* 35 */     int pageSize = Integer.valueOf(val("ce.searchcount")).intValue();
/* 36 */     if (pageSize > 1000)
/* 37 */       pageSize = 1000;
/* 38 */     return pageSize;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.ibm.filenet.login.CEConfigOptions
 * JD-Core Version:    0.6.0
 */