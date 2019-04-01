/*    */ package com.sinosoft.banklns.lis.bean;
/*    */ 
/*    */ import com.sinosoft.banklns.lis.schema.LNPPersonSchema;
/*    */ 
/*    */ public class BankLNPPersonBean extends BankBeanBasic
/*    */ {
/*  6 */   private LNPPersonSchema schema = new LNPPersonSchema();
/*    */ 
/*    */   public LNPPersonSchema getSchema() {
/*  9 */     return this.schema;
/*    */   }
/*    */ 
/*    */   public void setSchema(LNPPersonSchema schema) {
/* 13 */     this.schema = schema;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.bean.BankLNPPersonBean
 * JD-Core Version:    0.6.0
 */