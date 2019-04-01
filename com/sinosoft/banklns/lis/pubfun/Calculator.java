/*    */ package com.sinosoft.banklns.lis.pubfun;
/*    */ 
/*    */ import com.sinosoft.banklns.utility.CError;
/*    */ import com.sinosoft.banklns.utility.CErrors;
/*    */ 
/*    */ public class Calculator
/*    */ {
/* 13 */   public CErrors mErrors = new CErrors();
/*    */   public String PolNo;
/* 18 */   private String CalCode = "";
/*    */ 
/*    */   public void setCalCode(String tCalCode) {
/* 21 */     this.CalCode = tCalCode;
/*    */   }
/*    */ 
/*    */   private boolean checkCalculate()
/*    */   {
/* 26 */     if ((this.CalCode == null) || (this.CalCode.equals("")))
/*    */     {
/* 29 */       CError tError = new CError();
/* 30 */       tError.moduleName = "Calculator";
/* 31 */       tError.functionName = "checkCalculate";
/* 32 */       tError.errorMessage = "\u8BA1\u7B97\u65F6\u5FC5\u987B\u6709\u8BA1\u7B97\u7F16\u7801\u3002";
/* 33 */       this.mErrors.addOneError(tError);
/* 34 */       return false;
/*    */     }
/* 36 */     return true;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.pubfun.Calculator
 * JD-Core Version:    0.6.0
 */