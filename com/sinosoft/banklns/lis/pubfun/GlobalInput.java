/*    */ package com.sinosoft.banklns.lis.pubfun;
/*    */ 
/*    */ public class GlobalInput
/*    */ {
/*    */   public String Operator;
/*    */   public String ManageCom;
/*    */   public String ComCode;
/*    */   public String Lang;
/*    */   public int PwdErrCount;
/*    */   public long LastLogoTime;
/* 14 */   public boolean logoflag = false;
/*    */   public String chanlesign;
/*    */   public String riskSaleGroup;
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/* 23 */     GlobalInput globalInput1 = new GlobalInput();
/*    */   }
/*    */ 
/*    */   public void setSchema(GlobalInput cGlobalInput)
/*    */   {
/* 29 */     this.Operator = cGlobalInput.Operator;
/* 30 */     this.ComCode = cGlobalInput.ComCode;
/* 31 */     this.ManageCom = cGlobalInput.ManageCom;
/* 32 */     this.Lang = cGlobalInput.Lang;
/* 33 */     this.PwdErrCount = cGlobalInput.PwdErrCount;
/* 34 */     this.LastLogoTime = cGlobalInput.LastLogoTime;
/* 35 */     this.logoflag = cGlobalInput.logoflag;
/* 36 */     this.chanlesign = cGlobalInput.chanlesign;
/* 37 */     this.riskSaleGroup = cGlobalInput.riskSaleGroup;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.pubfun.GlobalInput
 * JD-Core Version:    0.6.0
 */