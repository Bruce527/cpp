/*    */ package com.sinosoft.map.lis.pubfun;
/*    */ 
/*    */ import com.sinosoft.map.utility.CErrors;
/*    */ import com.sinosoft.map.utility.VData;
/*    */ 
/*    */ public class EasyQueryUI
/*    */ {
/* 20 */   private VData mResult = new VData();
/*    */   private String mOperate;
/* 28 */   public CErrors mErrors = new CErrors();
/*    */ 
/*    */   public boolean submitData(VData cInputData, String cOperate)
/*    */   {
/* 40 */     this.mOperate = cOperate;
/*    */ 
/* 42 */     EasyQueryBL tEasyQueryBL = new EasyQueryBL();
/*    */ 
/* 45 */     if (tEasyQueryBL.submitData(cInputData, this.mOperate))
/*    */     {
/* 47 */       this.mResult = tEasyQueryBL.getResult();
/*    */     }
/*    */     else
/*    */     {
/* 52 */       this.mErrors.copyAllErrors(tEasyQueryBL.mErrors);
/* 53 */       this.mResult.clear();
/* 54 */       return false;
/*    */     }
/*    */ 
/* 58 */     return true;
/*    */   }
/*    */ 
/*    */   public VData getResult()
/*    */   {
/* 65 */     return this.mResult;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.pubfun.EasyQueryUI
 * JD-Core Version:    0.6.0
 */