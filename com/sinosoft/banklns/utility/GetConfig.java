/*    */ package com.sinosoft.banklns.utility;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.MissingResourceException;
/*    */ import java.util.ResourceBundle;
/*    */ 
/*    */ public class GetConfig
/*    */ {
/*  7 */   private static ResourceBundle bundle = null;
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/* 13 */     System.out.println(getString("remotelistenerservlet.ip"));
/* 14 */     System.out.println(getString("downfile.path"));
/*    */   }
/*    */ 
/*    */   public static ResourceBundle getResourceBundle() {
/* 18 */     if (bundle == null) {
/* 19 */       bundle = ResourceBundle.getBundle("resources.suggest");
/*    */     }
/* 21 */     return bundle;
/*    */   }
/*    */ 
/*    */   public static String getString(String key) {
/* 25 */     String value = null;
/*    */     try {
/* 27 */       value = getResourceBundle().getString(key);
/*    */     } catch (MissingResourceException e) {
/* 29 */       System.out.println(
/* 30 */         "java.util.MissingResourceException: Couldn't find value for: " + 
/* 31 */         key);
/*    */     }
/* 33 */     if (value == null) {
/* 34 */       value = "Could not find resource: " + key + "  ";
/*    */     }
/* 36 */     return value;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.GetConfig
 * JD-Core Version:    0.6.0
 */