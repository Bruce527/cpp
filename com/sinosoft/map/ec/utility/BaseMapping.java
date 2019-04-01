/*    */ package com.sinosoft.map.ec.utility;
/*    */ 
/*    */ import com.sinosoft.map.utility.ExeSQL;
/*    */ import com.sinosoft.map.utility.SSRS;
/*    */ 
/*    */ public class BaseMapping
/*    */ {
/*  8 */   private ExeSQL mExeSQL = new ExeSQL();
/*    */ 
/*    */   public String agentMapping(String agentcode)
/*    */   {
/* 12 */     String tempAgent = "";
/* 13 */     SSRS mSSRS = new SSRS();
/* 14 */     String agentSQL = "select agentcode from magent where oagentcode='" + agentcode + "'";
/* 15 */     mSSRS = this.mExeSQL.execSQL(agentSQL);
/*    */ 
/* 17 */     if ((mSSRS == null) || (mSSRS.getMaxRow() < 1)) {
/* 18 */       tempAgent = agentcode;
/* 19 */       return tempAgent;
/*    */     }
/* 21 */     tempAgent = mSSRS.GetText(1, 1);
/* 22 */     return tempAgent;
/*    */   }
/*    */ 
/*    */   public String branchMapping(String branch)
/*    */   {
/* 28 */     String tempBranch = "";
/* 29 */     SSRS mSSRS = new SSRS();
/* 30 */     String branchSQL = "select branchattr from mbranch where obranchattr='" + branch + "'";
/* 31 */     mSSRS = this.mExeSQL.execSQL(branchSQL);
/*    */ 
/* 33 */     if ((mSSRS == null) || (mSSRS.getMaxRow() < 1)) {
/* 34 */       tempBranch = branch;
/* 35 */       return tempBranch;
/*    */     }
/* 37 */     tempBranch = mSSRS.GetText(1, 1);
/* 38 */     return tempBranch;
/*    */   }
/*    */ 
/*    */   public String resAgentMapping(String agentcode)
/*    */   {
/* 44 */     String tempAgent = "";
/* 45 */     SSRS mSSRS = new SSRS();
/* 46 */     String agentSQL = "select oagentcode from magent where agentcode='" + agentcode + "'";
/* 47 */     mSSRS = this.mExeSQL.execSQL(agentSQL);
/*    */ 
/* 49 */     if ((mSSRS == null) || (mSSRS.getMaxRow() < 1)) {
/* 50 */       tempAgent = agentcode;
/* 51 */       return tempAgent;
/*    */     }
/* 53 */     tempAgent = mSSRS.GetText(1, 1);
/* 54 */     return tempAgent;
/*    */   }
/*    */ 
/*    */   public String resBranchMapping(String branch)
/*    */   {
/* 60 */     String tempBranch = "";
/* 61 */     SSRS mSSRS = new SSRS();
/* 62 */     String branchSQL = "select obranchattr from mbranch where branchattr='" + branch + "'";
/* 63 */     mSSRS = this.mExeSQL.execSQL(branchSQL);
/*    */ 
/* 65 */     if ((mSSRS == null) || (mSSRS.getMaxRow() < 1)) {
/* 66 */       tempBranch = branch;
/* 67 */       return tempBranch;
/*    */     }
/* 69 */     tempBranch = mSSRS.GetText(1, 1);
/* 70 */     return tempBranch;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.ec.utility.BaseMapping
 * JD-Core Version:    0.6.0
 */