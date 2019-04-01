/*    */ package com.sinosoft.map.lis.encrypt;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.net.URLEncoder;
/*    */ 
/*    */ public class LisIDEA extends TripleDES
/*    */ {
/*    */   public String encryptString(String arg)
/*    */   {
/*    */     try
/*    */     {
/* 17 */       return URLEncoder.encode(super.encryptString(arg));
/*    */     }
/*    */     catch (Exception ex) {
/*    */     }
/* 21 */     return "";
/*    */   }
/*    */ 
/*    */   public String encryptDBString(String arg)
/*    */     throws Exception
/*    */   {
/*    */     try
/*    */     {
/* 29 */       return super.encryptString(arg);
/*    */     }
/*    */     catch (Exception ex) {
/*    */     }
/* 33 */     throw ex;
/*    */   }
/*    */ 
/*    */   public String decryptString_pre(String arg)
/*    */   {
/* 39 */     String decryptString = super.decryptString_pre(arg);
/*    */ 
/* 42 */     return decryptString;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/* 48 */     LisIDEA tLisIDEA = new LisIDEA();
/* 49 */     System.out.println("http://localhost:2514/MetB2C/product/itemintro.jsf?arg=" + URLEncoder.encode("61%30%-102%82%117%-81%127%-59%-123%83%-38%-56%-98%-66%-13%-23%-66%72%-56%109%-56%54%-75%-39%"));
/*    */ 
/* 51 */     System.out.println(tLisIDEA.encryptString("111111111111111111"));
/* 52 */     System.out.println(tLisIDEA.decryptString_pre("-40|-81|-99|99|107|-13|38|-125|-40|-81|-49|99|107|-13|38|-125|4|22|119|71|96|-24|36|119|"));
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.encrypt.LisIDEA
 * JD-Core Version:    0.6.0
 */