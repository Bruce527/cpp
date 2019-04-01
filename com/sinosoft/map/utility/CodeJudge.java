/*    */ package com.sinosoft.map.utility;
/*    */ 
/*    */ public class CodeJudge
/*    */ {
/*    */   public static String getCodeType(String strCode)
/*    */   {
/* 18 */     if ((strCode == null) || (strCode.equals("")))
/*    */     {
/* 20 */       return "00";
/*    */     }
/*    */ 
/*    */     try
/*    */     {
/* 27 */       return strCode.substring(0, 2);
/*    */     }
/*    */     catch (Exception e) {
/*    */     }
/* 31 */     return "00";
/*    */   }
/*    */ 
/*    */   public static boolean judgeCodeType(String strCode, String strType)
/*    */   {
/* 39 */     if ((strCode == null) || (strCode.equals("")) || (strType == null) || 
/* 40 */       (strType.equals("")))
/*    */     {
/* 42 */       return false;
/*    */     }
/*    */ 
/*    */     try
/*    */     {
/* 48 */       return getCodeType(strCode).compareTo(strType) == 0;
/*    */     }
/*    */     catch (Exception e) {
/*    */     }
/* 52 */     return false;
/*    */   }
/*    */ 
/*    */   public static String getCodeType(String strCode, String strStart, String strLength)
/*    */   {
/* 61 */     if ((strCode == null) || (strCode.equals("")))
/*    */     {
/* 63 */       return "00";
/*    */     }
/*    */ 
/*    */     try
/*    */     {
/* 69 */       return strCode.substring(Integer.parseInt(strStart), 
/* 70 */         Integer.parseInt(strStart) + 
/* 71 */         Integer.parseInt(strLength));
/*    */     }
/*    */     catch (Exception e) {
/*    */     }
/* 75 */     return "00";
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.CodeJudge
 * JD-Core Version:    0.6.0
 */