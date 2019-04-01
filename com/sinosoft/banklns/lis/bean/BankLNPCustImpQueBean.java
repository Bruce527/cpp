/*    */ package com.sinosoft.banklns.lis.bean;
/*    */ 
/*    */ import com.sinosoft.banklns.lis.schema.LNPCustImpQueSchema;
/*    */ 
/*    */ public class BankLNPCustImpQueBean extends BankBeanBasic
/*    */ {
/* 10 */   private LNPCustImpQueSchema appntQues = new LNPCustImpQueSchema();
/* 11 */   private LNPCustImpQueSchema insurQues = new LNPCustImpQueSchema();
/*    */ 
/* 14 */   private String appntanswer = "";
/* 15 */   private String insuranswer = "";
/* 16 */   private String isAppntAllSelected = "";
/* 17 */   private String isInsurAllSelected = "";
/*    */ 
/*    */   public String getAppntanswer() {
/* 20 */     return this.appntanswer;
/*    */   }
/*    */ 
/*    */   public void setAppntanswer(String appntanswer) {
/* 24 */     this.appntanswer = appntanswer;
/*    */   }
/*    */ 
/*    */   public String getInsuranswer() {
/* 28 */     return this.insuranswer;
/*    */   }
/*    */ 
/*    */   public void setInsuranswer(String insuranswer) {
/* 32 */     this.insuranswer = insuranswer;
/*    */   }
/*    */ 
/*    */   public String getIsAppntAllSelected() {
/* 36 */     return this.isAppntAllSelected;
/*    */   }
/*    */ 
/*    */   public void setIsAppntAllSelected(String isAppntAllSelected) {
/* 40 */     this.isAppntAllSelected = isAppntAllSelected;
/*    */   }
/*    */ 
/*    */   public String getIsInsurAllSelected() {
/* 44 */     return this.isInsurAllSelected;
/*    */   }
/*    */ 
/*    */   public void setIsInsurAllSelected(String isInsurAllSelected) {
/* 48 */     this.isInsurAllSelected = isInsurAllSelected;
/*    */   }
/*    */ 
/*    */   public LNPCustImpQueSchema getAppntQues() {
/* 52 */     return this.appntQues;
/*    */   }
/*    */ 
/*    */   public void setAppntQues(LNPCustImpQueSchema appntQues) {
/* 56 */     this.appntQues = appntQues;
/*    */   }
/*    */ 
/*    */   public LNPCustImpQueSchema getInsurQues() {
/* 60 */     return this.insurQues;
/*    */   }
/*    */ 
/*    */   public void setInsurQues(LNPCustImpQueSchema insurQues) {
/* 64 */     this.insurQues = insurQues;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.bean.BankLNPCustImpQueBean
 * JD-Core Version:    0.6.0
 */