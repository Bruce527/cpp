/*    */ package com.sinosoft.banklns.lis.pubfun;
/*    */ 
/*    */ import com.sinosoft.banklns.utility.CErrors;
/*    */ import com.sinosoft.banklns.utility.ExeSQL;
/*    */ 
/*    */ public class AgentPubFun
/*    */ {
/*    */   public static void main(String[] args)
/*    */   {
/*    */   }
/*    */ 
/*    */   public static String switchSalChnl(String cSalChnl)
/*    */   {
/* 14 */     String tBranchType = "";
/*    */ 
/* 16 */     cSalChnl = cSalChnl.trim();
/* 17 */     if (cSalChnl.equals("01"))
/*    */     {
/* 19 */       tBranchType = "2";
/* 20 */     } else if (cSalChnl.equals("02"))
/*    */     {
/* 22 */       tBranchType = "1";
/* 23 */     } else if ((cSalChnl.equals("03")) || (cSalChnl.equals("04")) || 
/* 24 */       (cSalChnl.equals("05")) || (cSalChnl.equals("06")))
/*    */     {
/* 26 */       tBranchType = "3";
/*    */     }
/*    */ 
/* 29 */     return tBranchType;
/*    */   }
/*    */ 
/*    */   public static String getAgentSeries(String cAgentGrade) {
/* 33 */     if ((cAgentGrade == null) || (cAgentGrade.equals("")))
/* 34 */       return null;
/* 35 */     String tAgentSeries = "";
/* 36 */     String tSQL = "select Trim(code2) from ldcodeRela where relaType = 'gradeserieslevel' and code1 = '" + 
/* 37 */       cAgentGrade + "' ";
/* 38 */     ExeSQL tExeSQL = new ExeSQL();
/* 39 */     tAgentSeries = tExeSQL.getOneValue(tSQL);
/* 40 */     if (tExeSQL.mErrors.needDealError())
/* 41 */       return null;
/* 42 */     return tAgentSeries;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.pubfun.AgentPubFun
 * JD-Core Version:    0.6.0
 */