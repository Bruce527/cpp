/*    */ package com.sinosoft.banklns.utility;
/*    */ 
/*    */ public class ChgData
/*    */ {
/*    */   public static String chgData(byte byteValue)
/*    */   {
/*  8 */     String strReturn = null;
/*  9 */     if (byteValue == 0)
/* 10 */       strReturn = "0";
/*    */     else
/* 12 */       strReturn = String.valueOf(byteValue);
/* 13 */     return strReturn;
/*    */   }
/*    */ 
/*    */   public static String chgData(short shortValue)
/*    */   {
/* 18 */     String strReturn = null;
/* 19 */     if (shortValue == 0)
/* 20 */       strReturn = "0";
/*    */     else
/* 22 */       strReturn = String.valueOf(shortValue);
/* 23 */     return strReturn;
/*    */   }
/*    */ 
/*    */   public static String chgData(int intValue)
/*    */   {
/* 28 */     String strReturn = null;
/* 29 */     if (intValue == 0)
/* 30 */       strReturn = "0";
/*    */     else
/* 32 */       strReturn = String.valueOf(intValue);
/* 33 */     return strReturn;
/*    */   }
/*    */ 
/*    */   public static String chgData(long longValue)
/*    */   {
/* 38 */     String strReturn = null;
/* 39 */     if (longValue == 0L)
/* 40 */       strReturn = "0";
/*    */     else
/* 42 */       strReturn = String.valueOf(longValue);
/* 43 */     return strReturn;
/*    */   }
/*    */ 
/*    */   public static String chgData(float floatValue)
/*    */   {
/* 49 */     String strReturn = null;
/*    */ 
/* 51 */     if (floatValue == 0.0F)
/* 52 */       strReturn = "0";
/*    */     else
/* 54 */       strReturn = String.valueOf(floatValue);
/* 55 */     return strReturn;
/*    */   }
/*    */ 
/*    */   public static String chgData(double doubleValue)
/*    */   {
/* 61 */     String strReturn = null;
/* 62 */     if (doubleValue == 0.0D)
/* 63 */       strReturn = "0";
/*    */     else
/* 65 */       strReturn = String.valueOf(doubleValue);
/* 66 */     return strReturn;
/*    */   }
/*    */ 
/*    */   public static String chgNumericStr(String strValue)
/*    */   {
/* 72 */     if (strValue == null)
/* 73 */       return "0";
/* 74 */     if ((strValue.trim() == "") || (strValue.length() == 0)) {
/* 75 */       return "0";
/*    */     }
/* 77 */     return strValue;
/*    */   }
/*    */ 
/*    */   public static String getBooleanDescribe(String strValue)
/*    */   {
/* 83 */     String strReturn = strValue;
/* 84 */     if ((strValue.equals("Y")) || (strValue.equals("y")))
/* 85 */       strReturn = "\u951F\u65A4\u62F7";
/* 86 */     else if ((strValue.equals("N")) || (strValue.equals("n"))) {
/* 87 */       strReturn = "\u951F\u65A4\u62F7";
/*    */     }
/* 89 */     return strReturn;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.ChgData
 * JD-Core Version:    0.6.0
 */