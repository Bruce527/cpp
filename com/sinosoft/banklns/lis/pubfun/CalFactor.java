/*    */ package com.sinosoft.banklns.lis.pubfun;
/*    */ 
/*    */ public class CalFactor
/*    */ {
/*    */   private String data1;
/*    */   private String data2;
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/* 12 */     CalFactor schema1 = new CalFactor();
/*    */   }
/*    */ 
/*    */   public String getV(String FCode)
/*    */   {
/* 17 */     String strReturn = "";
/* 18 */     if (FCode.equals("\u4FDD\u989D"))
/*    */     {
/* 20 */       strReturn = this.data1;
/*    */     }
/* 22 */     if (FCode.equals("\u5E74\u9F84"))
/*    */     {
/* 24 */       strReturn = this.data2;
/*    */     }
/* 26 */     return strReturn;
/*    */   }
/*    */ 
/*    */   public boolean setV(String FCode, String FValue) {
/* 30 */     if (FCode.equals("")) {
/* 31 */       return false;
/*    */     }
/* 33 */     if (FCode.equals("\u4FDD\u989D"))
/*    */     {
/* 35 */       if ((FValue != null) && (!FValue.equals("")))
/*    */       {
/* 37 */         this.data1 = FValue.trim();
/*    */       }
/*    */       else
/* 40 */         this.data1 = null;
/*    */     }
/* 42 */     if (FCode.equals("\u5E74\u9F84"))
/*    */     {
/* 44 */       if ((FValue != null) && (!FValue.equals("")))
/*    */       {
/* 46 */         this.data1 = FValue.trim();
/*    */       }
/*    */       else
/* 49 */         this.data1 = null;
/*    */     }
/* 51 */     return true;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.pubfun.CalFactor
 * JD-Core Version:    0.6.0
 */