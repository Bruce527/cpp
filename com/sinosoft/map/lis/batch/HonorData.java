/*     */ package com.sinosoft.map.lis.batch;
/*     */ 
/*     */ import com.sinosoft.map.lis.pubfun.MMap;
/*     */ import com.sinosoft.map.lis.pubfun.PubFun;
/*     */ import com.sinosoft.map.lis.pubfun.PubSubmit;
/*     */ import com.sinosoft.map.lis.pubfun.SysMaxNoMap;
/*     */ import com.sinosoft.map.lis.schema.MC2BMessageSchema;
/*     */ import com.sinosoft.map.lis.vschema.MC2BMessageSet;
/*     */ import com.sinosoft.map.utility.ExeSQL;
/*     */ import com.sinosoft.map.utility.SSRS;
/*     */ import com.sinosoft.map.utility.VData;
/*     */ 
/*     */ public class HonorData
/*     */ {
/*  17 */   private String tCalStatYM = "";
/*  18 */   private String tCalStartDate = "";
/*     */ 
/*     */   public void batch()
/*     */   {
/*  25 */     if (IsBatch())
/*     */     {
/*  28 */       doBatch();
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean IsBatch()
/*     */   {
/*  36 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean doBatch()
/*     */   {
/*  42 */     String branchtype = "1";
/*  43 */     ExeSQL exeSQL = new ExeSQL();
/*     */     try
/*     */     {
/*  47 */       SSRS ssrs1 = new SSRS();
/*     */ 
/*  51 */       String lpsql = "select managecom,statyear,statbatch,case when datatype ='1' then 'LP' when datatype ='2' then 'SM' when datatype ='3' then 'AM' end from MHonorCheck where checkstate = '2' and datediff(dd,checkdate,getdate()) = 1";
/*     */ 
/*  54 */       ssrs1 = exeSQL.execSQL(lpsql);
/*     */ 
/*  59 */       MC2BMessageSet tMC2BMessageSet = new MC2BMessageSet();
/*     */ 
/*  61 */       if ((ssrs1 != null) && (ssrs1.MaxRow > 0))
/*     */       {
/*  63 */         for (int i = 1; i <= ssrs1.MaxRow; i++)
/*     */         {
/*  65 */           MC2BMessageSchema tMC2BMessageSchema = new MC2BMessageSchema();
/*  66 */           SysMaxNoMap tSysMaxNoMap = new SysMaxNoMap("MC2BMessageNO", 12, 1);
/*  67 */           String tID = tSysMaxNoMap.next();
/*  68 */           tMC2BMessageSchema.setID(tID);
/*  69 */           tMC2BMessageSchema.setManageCom(ssrs1.GetText(i, 1));
/*  70 */           tMC2BMessageSchema.setBranchType(branchtype);
/*  71 */           tMC2BMessageSchema.setKeyData(ssrs1.GetText(i, 2));
/*  72 */           tMC2BMessageSchema.setKeyData2(ssrs1.GetText(i, 3));
/*  73 */           tMC2BMessageSchema.setKeyData3(ssrs1.GetText(i, 4));
/*  74 */           tMC2BMessageSchema.setMessageType("09");
/*  75 */           tMC2BMessageSchema.setType("2");
/*  76 */           tMC2BMessageSchema.setState("1");
/*     */ 
/*  78 */           tMC2BMessageSchema.setMakeDate(PubFun.getCurrentDate());
/*  79 */           tMC2BMessageSchema.setMakeTime(PubFun.getCurrentTime());
/*     */ 
/*  81 */           tMC2BMessageSet.add(tMC2BMessageSchema);
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/*  86 */         return false;
/*     */       }
/*     */ 
/*  93 */       MMap mmap = new MMap();
/*  94 */       mmap.put(tMC2BMessageSet, "INSERT");
/*     */ 
/*  96 */       VData tVData = new VData();
/*  97 */       tVData.add(mmap);
/*     */ 
/*  99 */       PubSubmit tPubSubmit = new PubSubmit();
/* 100 */       tPubSubmit.submitData(tVData, "");
/*     */ 
/* 102 */       return true;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 107 */       e.printStackTrace();
/* 108 */     }return false;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.batch.HonorData
 * JD-Core Version:    0.6.0
 */