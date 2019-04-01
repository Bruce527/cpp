/*    */ package com.sinosoft.banklns.lis.bean;
/*    */ 
/*    */ import com.sinosoft.banklns.lis.schema.LNPAppntSchema;
/*    */ 
/*    */ public class BankLNPAppntBean extends BankBeanBasic
/*    */ {
/*  6 */   private LNPAppntSchema schema = new LNPAppntSchema();
/*    */ 
/*    */   public LNPAppntSchema getSchema() {
/*  9 */     return this.schema;
/*    */   }
/*    */ 
/*    */   public void setSchema(LNPAppntSchema schema) {
/* 13 */     this.schema = schema;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.bean.BankLNPAppntBean
 * JD-Core Version:    0.6.0
 */