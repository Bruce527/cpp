/*    */ package com.sinosoft.banklns.lis.bean;
/*    */ 
/*    */ import com.sinosoft.banklns.lis.schema.LNPAgentInfoSchema;
/*    */ 
/*    */ public class BankLNPAgentInfoBean extends BankBeanBasic
/*    */ {
/*  6 */   private LNPAgentInfoSchema schema = new LNPAgentInfoSchema();
/*    */ 
/*  8 */   public LNPAgentInfoSchema getSchema() { return this.schema; }
/*    */ 
/*    */   public void setSchema(LNPAgentInfoSchema schema)
/*    */   {
/* 12 */     this.schema = schema;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.bean.BankLNPAgentInfoBean
 * JD-Core Version:    0.6.0
 */