/*    */ package com.sinosoft.banklns.utility;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.util.Properties;
/*    */ 
/*    */ public class PropertiesToolFun
/*    */ {
/*    */   public static Properties getInitPropertiesData(Class name, String perDoc)
/*    */   {
/*  9 */     Properties properties = new Properties();
/* 10 */     InputStream in = name.getResourceAsStream(perDoc);
/*    */     try {
/* 12 */       properties.load(in);
/*    */     } catch (IOException e) {
/* 14 */       e.printStackTrace();
/*    */     }
/* 16 */     return properties;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.PropertiesToolFun
 * JD-Core Version:    0.6.0
 */