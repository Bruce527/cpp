/*    */ package com.sinosoft.banklns.lis.pubfun;
/*    */ 
/*    */ public class IGlobalInput
/*    */ {
/*    */   public String Operator;
/*    */   public String ManageCom;
/*    */   public String ComCode;
/*    */   public String Lang;
/*    */   public String BranchType;
/*    */   public String OperType;
/*    */   public int PwdErrCount;
/*    */   public long LastLogoTime;
/* 15 */   public boolean logoflag = false;
/* 16 */   public boolean LNPEntry = false;
/* 17 */   public boolean LNPAudit = false;
/* 18 */   public boolean LNPQuery = false;
/* 19 */   public boolean LNPCancel = false;
/*    */ 
/* 21 */   public String LNPRole = "";
/*    */   public String chanlesign;
/*    */   public String riskSaleGroup;
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/* 31 */     IGlobalInput globalInput1 = new IGlobalInput();
/*    */   }
/*    */ 
/*    */   public void setSchema(IGlobalInput cGlobalInput)
/*    */   {
/* 37 */     this.Operator = cGlobalInput.Operator;
/* 38 */     this.ComCode = cGlobalInput.ComCode;
/* 39 */     this.ManageCom = cGlobalInput.ManageCom;
/* 40 */     this.Lang = cGlobalInput.Lang;
/* 41 */     this.PwdErrCount = cGlobalInput.PwdErrCount;
/* 42 */     this.LastLogoTime = cGlobalInput.LastLogoTime;
/* 43 */     this.logoflag = cGlobalInput.logoflag;
/* 44 */     this.chanlesign = cGlobalInput.chanlesign;
/* 45 */     this.riskSaleGroup = cGlobalInput.riskSaleGroup;
/* 46 */     this.BranchType = cGlobalInput.BranchType;
/* 47 */     this.OperType = cGlobalInput.OperType;
/* 48 */     this.LNPEntry = cGlobalInput.LNPEntry;
/* 49 */     this.LNPAudit = cGlobalInput.LNPAudit;
/* 50 */     this.LNPQuery = cGlobalInput.LNPQuery;
/* 51 */     this.LNPRole = cGlobalInput.LNPRole;
/* 52 */     this.LNPCancel = cGlobalInput.LNPCancel;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.pubfun.IGlobalInput
 * JD-Core Version:    0.6.0
 */