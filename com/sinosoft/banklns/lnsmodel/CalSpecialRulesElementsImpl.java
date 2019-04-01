/*    */ package com.sinosoft.banklns.lnsmodel;
/*    */ 
/*    */ import com.sinosoft.banklns.lis.db.LNPInvestRiskDataDB;
/*    */ import com.sinosoft.banklns.lis.db.LNPPolDB;
/*    */ import com.sinosoft.banklns.lis.schema.LNPInvestRiskDataSchema;
/*    */ import com.sinosoft.banklns.lis.vschema.LNPInvestRiskDataSet;
/*    */ 
/*    */ public class CalSpecialRulesElementsImpl
/*    */ {
/*    */   public double getIRAmnt(String polNo)
/*    */   {
/* 11 */     LNPPolDB reLNPPolDB = new LNPPolDB();
/* 12 */     reLNPPolDB.setPolNo(polNo);
/* 13 */     double result = 0.0D;
/* 14 */     if (reLNPPolDB.getInfo()) {
/* 15 */       result = reLNPPolDB.getPrem();
/* 16 */       LNPInvestRiskDataDB ewLNPInvestRiskDataDB = new LNPInvestRiskDataDB();
/* 17 */       String singNo = reLNPPolDB.getStandbyFlag3();
/* 18 */       if ((singNo != null) && (singNo.length() > 0)) {
/* 19 */         ewLNPInvestRiskDataDB.setSignno(singNo);
/* 20 */         ewLNPInvestRiskDataDB.setType("0");
/* 21 */         LNPInvestRiskDataSet reLNPInvestRiskDataSet = ewLNPInvestRiskDataDB.query();
/* 22 */         for (int i = 1; (reLNPInvestRiskDataSet != null) && (i <= reLNPInvestRiskDataSet.size()); i++) {
/* 23 */           LNPInvestRiskDataSchema reLNPInvestRiskDataSchema = reLNPInvestRiskDataSet.get(i);
/* 24 */           double value = reLNPInvestRiskDataSchema.getValue();
/* 25 */           double degree = reLNPInvestRiskDataSchema.getDegree();
/* 26 */           result += value * degree;
/*    */         }
/*    */       }
/*    */     }
/* 30 */     return result;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.CalSpecialRulesElementsImpl
 * JD-Core Version:    0.6.0
 */