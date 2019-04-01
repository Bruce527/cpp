/*    */ package com.sinosoft.banklns.utility;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ 
/*    */ public class DealNull
/*    */ {
/*    */   public static String nullToSpace(String strValue)
/*    */   {
/*    */     String returnValue;
/*    */     String returnValue;
/* 12 */     if (strValue == null)
/* 13 */       returnValue = "";
/*    */     else
/* 15 */       returnValue = strValue;
/* 16 */     return returnValue;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/* 23 */     String aaa = null;
/*    */ 
/* 25 */     String ccc = "1234567";
/* 26 */     DealNull tDealNull = new DealNull();
/*    */ 
/* 28 */     System.out.println("aaa = " + aaa);
/* 29 */     System.out.println("ccc = " + ccc);
/* 30 */     System.out.println("new aaa" + nullToSpace(aaa));
/* 31 */     System.out.println("new ccc" + nullToSpace(ccc));
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.DealNull
 * JD-Core Version:    0.6.0
 */