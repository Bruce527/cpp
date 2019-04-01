/*    */ package com.sinosoft.banklns.utility;
/*    */ 
/*    */ import com.sinosoft.banklns.lis.db.LNPRiskAppDB;
/*    */ import java.io.PrintStream;
/*    */ 
/*    */ public class RiskCheck
/*    */ {
/*    */   public static boolean checkRiskType(String riskCode, String checTypeCode)
/*    */   {
/*  9 */     LNPRiskAppDB LNPRiskAppDB = new LNPRiskAppDB();
/* 10 */     LNPRiskAppDB.setRiskCode(riskCode);
/* 11 */     String riskType = "";
/*    */ 
/* 13 */     if (LNPRiskAppDB.getInfo())
/* 14 */       riskType = LNPRiskAppDB.getRiskType().trim();
/*    */     else {
/* 16 */       System.out.println(" LMRiskApp\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7" + riskCode + "\u951F\u65A4\u62F7\u951F\u65A4\u62F7");
/*    */     }
/*    */ 
/* 20 */     return riskType.equalsIgnoreCase(checTypeCode.trim());
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.RiskCheck
 * JD-Core Version:    0.6.0
 */