/*    */ package com.sinosoft.banklns.lis.bean;
/*    */ 
/*    */ import com.sinosoft.banklns.lis.schema.LNPAddressSchema;
/*    */ 
/*    */ public class BankLNPAddressBean extends BankBeanBasic
/*    */ {
/*  6 */   private LNPAddressSchema schema = new LNPAddressSchema();
/*    */ 
/*    */   public LNPAddressSchema getSchema() {
/*  9 */     return this.schema;
/*    */   }
/*    */ 
/*    */   public void setSchema(LNPAddressSchema schema) {
/* 13 */     this.schema = schema;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.bean.BankLNPAddressBean
 * JD-Core Version:    0.6.0
 */