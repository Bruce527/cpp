/*     */ package com.sinosoft.banklns.lis.pubfun;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPCodeDB;
/*     */ import com.sinosoft.banklns.lis.schema.LNPCodeSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPCodeSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.ExeSQL;
/*     */ import com.sinosoft.banklns.utility.SSRS;
/*     */ import com.sinosoft.banklns.utility.VData;
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public class CodeQueryBL
/*     */ {
/*  13 */   public CErrors mErrors = new CErrors();
/*  14 */   private VData mResult = new VData();
/*     */   private String mOperate;
/*  16 */   private String mSQL = "";
/*     */ 
/*  18 */   private LNPCodeSchema mLNPCodeSchema = new LNPCodeSchema();
/*  19 */   private LNPCodeSet mLNPCodeSet = new LNPCodeSet();
/*  20 */   private ExeSQL mExeSQL = null;
/*     */ 
/*  22 */   private SSRS mSSRS = new SSRS();
/*     */ 
/*     */   public boolean submitData(VData cInputData, String cOperate)
/*     */   {
/*  30 */     this.mOperate = cOperate;
/*     */ 
/*  33 */     if (!getInputData(cInputData)) {
/*  34 */       return false;
/*     */     }
/*     */ 
/*  37 */     if (this.mOperate.equals("QUERY||CODE"))
/*     */     {
/*  39 */       if (!queryCodeData())
/*     */       {
/*  41 */         CError tError = new CError();
/*  42 */         tError.moduleName = "CodeQueryBL";
/*  43 */         tError.functionName = "submitData";
/*  44 */         tError.errorMessage = "\u6570\u636E\u5904\u7406\u5931\u8D25CodeQueryBL-->dealData!";
/*  45 */         this.mErrors.addOneError(tError);
/*  46 */         return false;
/*     */       }
/*     */     }
/*  49 */     else if (this.mOperate.equals("QUERY||SQL"))
/*     */     {
/*  51 */       if (!querySqlData())
/*     */       {
/*  54 */         CError tError = new CError();
/*  55 */         tError.moduleName = "CodeQueryBL";
/*  56 */         tError.functionName = "submitData";
/*  57 */         tError.errorMessage = "\u6570\u636E\u5904\u7406\u5931\u8D25CodeQueryBL-->dealData!";
/*  58 */         this.mErrors.addOneError(tError);
/*  59 */         return false;
/*     */       }
/*     */     }
/*  62 */     return true;
/*     */   }
/*     */ 
/*     */   public VData getResult()
/*     */   {
/*  67 */     return this.mResult;
/*     */   }
/*     */ 
/*     */   private boolean getInputData(VData cInputData)
/*     */   {
/*  72 */     if (this.mOperate.equals("QUERY||CODE"))
/*  73 */       this.mLNPCodeSchema.setSchema((LNPCodeSchema)cInputData.getObjectByObjectName("LNPCodeSchema", 0));
/*  74 */     else if (this.mOperate.equals("QUERY||SQL"))
/*  75 */       this.mSQL = ((String)cInputData.getObjectByObjectName("String", 0));
/*  76 */     return true;
/*     */   }
/*     */ 
/*     */   private boolean queryCodeData()
/*     */   {
/*  81 */     this.mResult.clear();
/*  82 */     LNPCodeDB tLNPCodeDB = new LNPCodeDB();
/*  83 */     tLNPCodeDB.setSchema(this.mLNPCodeSchema);
/*  84 */     LNPCodeSet tLNPCodeSet = new LNPCodeSet();
/*  85 */     tLNPCodeSet.set(tLNPCodeDB.query());
/*     */ 
/*  87 */     if (tLNPCodeDB.mErrors.needDealError())
/*     */     {
/*  89 */       this.mErrors.copyAllErrors(tLNPCodeDB.mErrors);
/*  90 */       CError tError = new CError();
/*  91 */       tError.moduleName = "SLatncyGrpBL";
/*  92 */       tError.functionName = "submitData";
/*  93 */       tError.errorMessage = "\u6570\u636E\u67E5\u8BE2\u5931\u8D25!";
/*  94 */       this.mErrors.addOneError(tError);
/*  95 */       return false;
/*     */     }
/*     */ 
/*  98 */     LNPCodeSchema tLNPCodeSchema = new LNPCodeSchema();
/*  99 */     for (int i = 1; i <= tLNPCodeSet.size(); i++)
/*     */     {
/* 101 */       tLNPCodeSchema.setSchema(tLNPCodeSet.get(i));
/* 102 */       String tResultStr = new String();
/* 103 */       tResultStr = tLNPCodeSchema.getCode() + "-" + tLNPCodeSchema.getCodeName();
/* 104 */       this.mResult.add(tResultStr);
/*     */     }
/*     */ 
/* 109 */     return true;
/*     */   }
/*     */ 
/*     */   private boolean querySqlData()
/*     */   {
/* 114 */     this.mResult.clear();
/* 115 */     this.mExeSQL = new ExeSQL();
/* 116 */     this.mSSRS = this.mExeSQL.execSQL(this.mSQL);
/* 117 */     if (this.mExeSQL.mErrors.needDealError()) {
/* 118 */       this.mErrors.copyAllErrors(this.mExeSQL.mErrors);
/*     */     }
/* 120 */     for (int i = 1; i <= this.mSSRS.getMaxRow(); i++)
/*     */     {
/* 122 */       String tResultStr = "";
/* 123 */       for (int j = 1; j <= this.mSSRS.getMaxCol(); j++)
/*     */       {
/* 125 */         String tStr = this.mSSRS.GetText(i, j);
/* 126 */         if (j == 1)
/* 127 */           tResultStr = tStr;
/*     */         else
/* 129 */           tResultStr = tResultStr + "-" + tStr;
/*     */       }
/* 131 */       this.mResult.add(tResultStr);
/*     */     }
/*     */ 
/* 134 */     return true;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 139 */     CodeQueryBL codeQueryBL1 = new CodeQueryBL();
/* 140 */     codeQueryBL1.mLNPCodeSchema.setCodeType("riskind");
/*     */ 
/* 142 */     VData tVData = codeQueryBL1.getResult();
/* 143 */     System.out.println(codeQueryBL1.mSQL);
/* 144 */     System.out.println(tVData.get(0));
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.pubfun.CodeQueryBL
 * JD-Core Version:    0.6.0
 */