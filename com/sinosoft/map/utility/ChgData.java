/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ public class ChgData
/*     */ {
/*     */   public static String chgData(byte byteValue)
/*     */   {
/*  13 */     String strReturn = null;
/*  14 */     if (byteValue == 0)
/*     */     {
/*  16 */       strReturn = "0";
/*     */     }
/*     */     else
/*     */     {
/*  20 */       strReturn = String.valueOf(byteValue);
/*     */     }
/*  22 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public static String chgData(short shortValue)
/*     */   {
/*  28 */     String strReturn = null;
/*  29 */     if (shortValue == 0)
/*     */     {
/*  31 */       strReturn = "0";
/*     */     }
/*     */     else
/*     */     {
/*  35 */       strReturn = String.valueOf(shortValue);
/*     */     }
/*  37 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public static String chgData(int intValue)
/*     */   {
/*  43 */     String strReturn = null;
/*  44 */     if (intValue == 0)
/*     */     {
/*  46 */       strReturn = "0";
/*     */     }
/*     */     else
/*     */     {
/*  50 */       strReturn = String.valueOf(intValue);
/*     */     }
/*  52 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public static String chgData(long longValue)
/*     */   {
/*  58 */     String strReturn = null;
/*  59 */     if (longValue == 0L)
/*     */     {
/*  61 */       strReturn = "0";
/*     */     }
/*     */     else
/*     */     {
/*  65 */       strReturn = String.valueOf(longValue);
/*     */     }
/*  67 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public static String chgData(float floatValue)
/*     */   {
/*  73 */     String strReturn = null;
/*     */ 
/*  75 */     if (floatValue == 0.0F)
/*     */     {
/*  77 */       strReturn = "0";
/*     */     }
/*     */     else
/*     */     {
/*  81 */       strReturn = String.valueOf(floatValue);
/*     */     }
/*  83 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public static String chgData(double doubleValue)
/*     */   {
/*  89 */     String strReturn = null;
/*  90 */     if (doubleValue == 0.0D)
/*     */     {
/*  92 */       strReturn = "0";
/*     */     }
/*     */     else
/*     */     {
/*  96 */       strReturn = String.valueOf(doubleValue);
/*     */     }
/*  98 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public static String chgNumericStr(String strValue)
/*     */   {
/* 104 */     if (strValue == null)
/*     */     {
/* 106 */       return "0";
/*     */     }
/* 108 */     if ((strValue.trim() == "") || (strValue.length() == 0))
/*     */     {
/* 110 */       return "0";
/*     */     }
/*     */ 
/* 114 */     return strValue;
/*     */   }
/*     */ 
/*     */   public static String getBooleanDescribe(String strValue)
/*     */   {
/* 121 */     String strReturn = strValue;
/* 122 */     if ((strValue.equals("Y")) || (strValue.equals("y")))
/*     */     {
/* 124 */       strReturn = "\u662F";
/*     */     }
/* 126 */     else if ((strValue.equals("N")) || (strValue.equals("n")))
/*     */     {
/* 128 */       strReturn = "\u5426";
/*     */     }
/*     */ 
/* 131 */     return strReturn;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.ChgData
 * JD-Core Version:    0.6.0
 */