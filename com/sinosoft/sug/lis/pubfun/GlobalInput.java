/*    */ package com.sinosoft.sug.lis.pubfun;
/*    */ 
/*    */ public class GlobalInput
/*    */ {
/*    */   public String Operator;
/*    */   public String ManageCom;
/*    */   public String ComCode;
/*    */   public String Lang;
/*    */   public int PwdErrCount;
/*    */   public long LastLogoTime;
/* 20 */   public boolean logoflag = false;
/*    */   public String chanlesign;
/*    */   public String riskSaleGroup;
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/* 29 */     GlobalInput globalInput1 = new GlobalInput();
/*    */   }
/*    */ 
/*    */   public void setSchema(GlobalInput cGlobalInput)
/*    */   {
/* 35 */     this.Operator = cGlobalInput.Operator;
/* 36 */     this.ComCode = cGlobalInput.ComCode;
/* 37 */     this.ManageCom = cGlobalInput.ManageCom;
/* 38 */     this.Lang = cGlobalInput.Lang;
/* 39 */     this.PwdErrCount = cGlobalInput.PwdErrCount;
/* 40 */     this.LastLogoTime = cGlobalInput.LastLogoTime;
/* 41 */     this.logoflag = cGlobalInput.logoflag;
/* 42 */     this.chanlesign = cGlobalInput.chanlesign;
/* 43 */     this.riskSaleGroup = cGlobalInput.riskSaleGroup;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.sug.lis.pubfun.GlobalInput
 * JD-Core Version:    0.6.0
 */