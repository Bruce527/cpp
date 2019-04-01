/*    */ package com.sinosoft.banklns.lnsmodel.util;
/*    */ 
/*    */ import com.sinosoft.banklns.lis.db.LNPInsuredDB;
/*    */ import com.sinosoft.banklns.lis.schema.LNPInsuredSchema;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class InsuError
/*    */ {
/* 13 */   private LNPInsuredSchema insuInfo = null;
/*    */ 
/* 16 */   private List riskErrorList = new ArrayList();
/*    */ 
/*    */   public void setInsuInfo(String contNo, String insuredNo)
/*    */   {
/* 21 */     LNPInsuredDB reLNPInsuredDB = new LNPInsuredDB();
/* 22 */     reLNPInsuredDB.setContNo(contNo);
/* 23 */     reLNPInsuredDB.setInsuredId(insuredNo);
/* 24 */     if (reLNPInsuredDB.getInfo())
/* 25 */       this.insuInfo = reLNPInsuredDB.getSchema();
/*    */   }
/*    */ 
/*    */   public void setInsuInfo(LNPInsuredSchema inLNPInsuredSchema)
/*    */   {
/* 31 */     this.insuInfo = inLNPInsuredSchema;
/*    */   }
/*    */ 
/*    */   public void addRiskError(RiskError riskError)
/*    */   {
/* 36 */     Set set = riskError.getRiskError();
/* 37 */     if ((set != null) && (set.size() > 0))
/* 38 */       this.riskErrorList.add(riskError);
/*    */   }
/*    */ 
/*    */   public LNPInsuredSchema getInsuInfo()
/*    */   {
/* 43 */     return this.insuInfo;
/*    */   }
/*    */ 
/*    */   public List getRiskErrorList() {
/* 47 */     return this.riskErrorList;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.util.InsuError
 * JD-Core Version:    0.6.0
 */