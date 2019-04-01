/*    */ package com.sinosoft.banklns.utility;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ 
/*    */ public class CodeJudge
/*    */ {
/*    */   public static String getCodeType(String strCode)
/*    */   {
/* 11 */     if ((strCode == null) || (strCode == "")) {
/* 12 */       return "00";
/*    */     }
/*    */ 
/*    */     try
/*    */     {
/* 17 */       return strCode.substring(11, 13);
/*    */     } catch (Exception e) {
/*    */     }
/* 20 */     return "00";
/*    */   }
/*    */ 
/*    */   public static boolean judgeCodeType(String strCode, String strType)
/*    */   {
/* 27 */     if ((strCode == null) || (strCode == "") || (strType == null) || (strType == "")) {
/* 28 */       return false;
/*    */     }
/*    */     try
/*    */     {
/* 32 */       return getCodeType(strCode).compareTo(strType) == 0;
/*    */     } catch (Exception e) {
/*    */     }
/* 35 */     return false;
/*    */   }
/*    */ 
/*    */   public static String getCodeType(String strCode, String strStart, String strLength)
/*    */   {
/* 42 */     if ((strCode == null) || (strCode == "")) {
/* 43 */       return "00";
/*    */     }
/*    */     try
/*    */     {
/* 47 */       return strCode.substring(Integer.parseInt(strStart), Integer.parseInt(strStart) + Integer.parseInt(strLength));
/*    */     } catch (Exception e) {
/*    */     }
/* 50 */     return "00";
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/* 56 */     CodeJudge codeJudge1 = new CodeJudge();
/* 57 */     System.out.println(getCodeType("abcdefg"));
/* 58 */     System.out.println(judgeCodeType("abcdef", "11"));
/*    */ 
/* 60 */     System.out.println(getCodeType("abcdefghijk11asdfasdf"));
/* 61 */     System.out.println(judgeCodeType("abcdefghijk11asdfasdf", "11"));
/*    */ 
/* 63 */     System.out.println(getCodeType("ab12cdefghijk11asdfasdf", "2", "2"));
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.CodeJudge
 * JD-Core Version:    0.6.0
 */