/*    */ package com.sinosoft.banklns.lnsmodel.util;
/*    */ 
/*    */ import com.sinosoft.banklns.lis.db.LNPRiskDB;
/*    */ import com.sinosoft.banklns.lis.schema.LNPRiskSchema;
/*    */ import java.util.Collection;
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class RiskError
/*    */ {
/* 15 */   private LNPRiskSchema riskInfo = null;
/*    */ 
/* 18 */   private Set set = new HashSet();
/*    */ 
/*    */   public Set getRiskError() {
/* 21 */     return this.set;
/*    */   }
/*    */ 
/*    */   public void setRiskInfo(String riskCode)
/*    */   {
/* 26 */     LNPRiskDB reLMRiskDB = new LNPRiskDB();
/* 27 */     reLMRiskDB.setRiskCode(riskCode);
/* 28 */     if (reLMRiskDB.getInfo())
/* 29 */       this.riskInfo = reLMRiskDB.getSchema();
/*    */   }
/*    */ 
/*    */   public void setRiskInfo(LNPRiskSchema inLNPRiskSchema)
/*    */   {
/* 34 */     this.riskInfo = inLNPRiskSchema;
/*    */   }
/*    */ 
/*    */   public void addError(String strError)
/*    */   {
/* 39 */     if ((strError != null) && (strError.length() > 0))
/* 40 */       this.set.add(strError);
/*    */   }
/*    */ 
/*    */   public void addError(Collection errorCollection)
/*    */   {
/* 46 */     if ((errorCollection != null) && (errorCollection.size() > 0)) {
/* 47 */       Iterator iterator = errorCollection.iterator();
/* 48 */       while (iterator.hasNext()) {
/* 49 */         Object errorObj = iterator.next();
/* 50 */         if ((errorObj != null) && (errorObj.toString().length() > 0))
/* 51 */           this.set.add(errorObj.toString());
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public LNPRiskSchema getRiskInfo()
/*    */   {
/* 58 */     return this.riskInfo;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.util.RiskError
 * JD-Core Version:    0.6.0
 */