/*     */ package com.sinosoft.map.lis.batch;
/*     */ 
/*     */ import com.sinosoft.map.lis.pubfun.MMap;
/*     */ import com.sinosoft.map.lis.pubfun.PubFun;
/*     */ import com.sinosoft.map.lis.pubfun.PubSubmit;
/*     */ import com.sinosoft.map.lis.pubfun.SysMaxNoMap;
/*     */ import com.sinosoft.map.lis.schema.MPrivateMessageSchema;
/*     */ import com.sinosoft.map.lis.vschema.MPrivateMessageSet;
/*     */ import com.sinosoft.map.utility.ExeSQL;
/*     */ import com.sinosoft.map.utility.SSRS;
/*     */ import com.sinosoft.map.utility.VData;
/*     */ 
/*     */ public class Preserve
/*     */ {
/*     */   public void batch()
/*     */   {
/*  18 */     if (IsBatch())
/*     */     {
/*  21 */       doBatch();
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean IsBatch()
/*     */   {
/*  28 */     ExeSQL exeSQL = new ExeSQL();
/*  29 */     SSRS ssrs1 = new SSRS();
/*     */ 
/*  31 */     String branchtype = "1";
/*     */ 
/*  33 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean doBatch() {
/*  37 */     String branchtype = "1";
/*  38 */     ExeSQL exeSQL = new ExeSQL();
/*  39 */     SSRS ssrs1 = new SSRS();
/*     */     try
/*     */     {
/*  53 */       String sql = " select a.agentcode,count(*) from (  select la.agentcode,rcvc.R_KEY  from R_CV_CASE rcvc inner join  R_APP_MODIFY ram   on ram.ram_cv_case=rcvc.r_key  inner join  tb_application tb_app on  rcvc.r_policy_num=tb_app.cd_policy_complement  inner join tb_application_broker tb_a_b  on tb_app.cd_administrator=tb_a_b.cd_administrator  and tb_app.cd_branch=tb_a_b.cd_branch and tb_app.cd_product=tb_a_b.cd_product  and tb_app.cd_application=tb_a_b.cd_application  inner join laagent la  on  '86' + right('0'+ltrim(str(tb_a_b.cd_branch)),2) + right('00000' + ltrim(str(tb_a_b.cd_broker)),6)=la.agentcode  inner join R_CASE_FILE rcf  on rcf.RCF_CASE_KEY=rcvc.R_KEY  inner join R_CASE_STATUS rcs on rcs.rcs_id=rcvc.r_case_status  where 1=1  and ram.ram_status='0'  and rcs.rcs_id not in (3,13,16,22,30)  and la.branchtype='" + 
/*  68 */         branchtype + "' " + 
/*  70 */         " group by la.agentcode,rcvc.R_KEY " + 
/*  71 */         " ) as a group by a.agentcode ";
/*     */ 
/*  73 */       ssrs1 = exeSQL.execSQL(sql);
/*     */ 
/*  75 */       SysMaxNoMap ttMPrivateDelNOMap = new SysMaxNoMap("MPrivateDelNO", 12, 1);
/*  76 */       String tDelID = ttMPrivateDelNOMap.next();
/*     */ 
/*  79 */       MPrivateMessageSet tMPrivateMessageSet = new MPrivateMessageSet();
/*  80 */       if ((ssrs1 != null) && (ssrs1.MaxRow > 0))
/*     */       {
/*  82 */         for (int i = 1; i < ssrs1.MaxRow; i++)
/*     */         {
/*  84 */           MPrivateMessageSchema tMPrivateMessageSchema = new MPrivateMessageSchema();
/*  85 */           SysMaxNoMap tSysMaxNoMap = new SysMaxNoMap("MPrivateMegNO", 12, 1);
/*  86 */           String tID = tSysMaxNoMap.next();
/*  87 */           tMPrivateMessageSchema.setID(tID);
/*  88 */           tMPrivateMessageSchema.setAgentCode(ssrs1.GetText(i, 1));
/*  89 */           tMPrivateMessageSchema.setManageCom(ssrs1.GetText(i, 1).substring(0, 4));
/*  90 */           tMPrivateMessageSchema.setBranchType(branchtype);
/*  91 */           tMPrivateMessageSchema.setMessageType("13");
/*     */ 
/*  93 */           tMPrivateMessageSchema.setKeyData(ssrs1.GetText(i, 2));
/*  94 */           tMPrivateMessageSchema.setType("1");
/*  95 */           tMPrivateMessageSchema.setState("1");
/*     */ 
/*  97 */           tMPrivateMessageSchema.setOperator(tDelID);
/*  98 */           tMPrivateMessageSchema.setMakeDate(PubFun.getCurrentDate());
/*  99 */           tMPrivateMessageSchema.setMakeTime(PubFun.getCurrentTime());
/*     */ 
/* 101 */           tMPrivateMessageSet.add(tMPrivateMessageSchema);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 106 */       MPrivateMessageSet rMPrivateMessageSet = new MPrivateMessageSet();
/*     */ 
/* 108 */       String querysql = " select id from MPrivateMessage where branchtype ='1' and messagetype='13' and operator <> '" + tDelID + "'  ";
/* 109 */       SSRS ssrs2 = new SSRS();
/* 110 */       ssrs2 = exeSQL.execSQL(querysql);
/* 111 */       if ((ssrs2 != null) && (ssrs2.MaxRow > 0))
/*     */       {
/* 113 */         for (int i = 1; i < ssrs2.MaxRow; i++)
/*     */         {
/* 115 */           MPrivateMessageSchema rMPrivateMessageSchema = new MPrivateMessageSchema();
/*     */ 
/* 117 */           rMPrivateMessageSchema.setID(ssrs2.GetText(i, 1));
/* 118 */           rMPrivateMessageSet.add(rMPrivateMessageSchema);
/*     */         }
/*     */       }
/*     */ 
/* 122 */       MMap mmap = new MMap();
/* 123 */       mmap.put(tMPrivateMessageSet, "INSERT");
/* 124 */       mmap.put(rMPrivateMessageSet, "DELETE");
/* 125 */       VData tVData = new VData();
/* 126 */       tVData.add(mmap);
/*     */ 
/* 128 */       PubSubmit tPubSubmit = new PubSubmit();
/* 129 */       tPubSubmit.submitData(tVData, "");
/*     */ 
/* 131 */       return true;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 136 */       e.printStackTrace();
/* 137 */     }return false;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.batch.Preserve
 * JD-Core Version:    0.6.0
 */