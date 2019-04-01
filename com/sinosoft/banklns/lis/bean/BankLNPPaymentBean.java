/*    */ package com.sinosoft.banklns.lis.bean;
/*    */ 
/*    */ import com.sinosoft.banklns.lis.schema.LNPPaymentSchema;
/*    */ 
/*    */ public class BankLNPPaymentBean extends BankBeanBasic
/*    */ {
/*  8 */   private LNPPaymentSchema schema = new LNPPaymentSchema();
/*    */ 
/*    */   public LNPPaymentSchema getSchema() {
/* 11 */     return this.schema;
/*    */   }
/*    */ 
/*    */   public void setSchema(LNPPaymentSchema schema) {
/* 15 */     this.schema = schema;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.bean.BankLNPPaymentBean
 * JD-Core Version:    0.6.0
 */