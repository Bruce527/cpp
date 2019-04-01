/*     */ package com.sinosoft.map.lis.pubfun;
/*     */ 
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.ExeSQL;
/*     */ import com.sinosoft.map.utility.VData;
/*     */ 
/*     */ public class EasyQueryBL
/*     */ {
/*  16 */   private VData mInputData = new VData();
/*     */ 
/*  19 */   private VData mResult = new VData();
/*     */   private String mOperate;
/*  25 */   public CErrors mErrors = new CErrors();
/*     */ 
/*  28 */   private String mSQL = "";
/*     */   private int mStartIndex;
/*  30 */   private String mEncodedResult = "";
/*     */ 
/*     */   public boolean submitData(VData cInputData, String cOperate)
/*     */   {
/*  46 */     this.mInputData = ((VData)cInputData.clone());
/*  47 */     this.mOperate = cOperate;
/*     */ 
/*  50 */     if (!getInputData())
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */ 
/*  57 */     if (this.mOperate.equals("QUERY||MAIN"))
/*     */     {
/*  59 */       if (!queryData())
/*     */       {
/*  61 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  67 */     return true;
/*     */   }
/*     */ 
/*     */   private boolean getInputData()
/*     */   {
/*  74 */     this.mSQL = ((String)this.mInputData.getObject(0));
/*  75 */     if ((this.mSQL == null) || (this.mSQL.trim().equals("")))
/*     */     {
/*  78 */       CError tError = new CError();
/*  79 */       tError.moduleName = "EasyQueryBL";
/*  80 */       tError.functionName = "getInputData";
/*  81 */       tError.errorMessage = "\u6CA1\u6709\u4F20\u5165SQL\u8BED\u53E5!";
/*  82 */       this.mErrors.addOneError(tError);
/*  83 */       return false;
/*     */     }
/*  85 */     Integer tStart = (Integer)this.mInputData.getObject(1);
/*  86 */     this.mStartIndex = tStart.intValue();
/*     */ 
/*  88 */     return true;
/*     */   }
/*     */ 
/*     */   private boolean queryData()
/*     */   {
/*  95 */     ExeSQL tExeSQL = new ExeSQL();
/*  96 */     this.mEncodedResult = tExeSQL.getEncodedResult(this.mSQL, this.mStartIndex);
/*  97 */     if (tExeSQL.mErrors.needDealError())
/*     */     {
/* 100 */       this.mErrors.copyAllErrors(tExeSQL.mErrors);
/* 101 */       this.mEncodedResult = "";
/* 102 */       return false;
/*     */     }
/*     */ 
/* 106 */     this.mResult.add(this.mEncodedResult);
/*     */ 
/* 109 */     return true;
/*     */   }
/*     */ 
/*     */   public VData getResult()
/*     */   {
/* 115 */     return this.mResult;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.pubfun.EasyQueryBL
 * JD-Core Version:    0.6.0
 */