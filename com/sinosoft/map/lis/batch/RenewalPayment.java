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
/*     */ public class RenewalPayment
/*     */ {
/*  19 */   private String tNowStatYM = "";
/*  20 */   private String tCalStatYM = "";
/*  21 */   private String tCalStartDate = "";
/*  22 */   private String tCalEndDate = "";
/*  23 */   private String tCalDate = "";
/*  24 */   private String tCalRange = "15";
/*     */ 
/*     */   public void batch()
/*     */   {
/*  30 */     if (IsBatch())
/*     */     {
/*  33 */       doBatch();
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean IsBatch()
/*     */   {
/*  41 */     ExeSQL exeSQL = new ExeSQL();
/*  42 */     SSRS ssrs1 = new SSRS();
/*     */ 
/*  44 */     String branchtype = "1";
/*     */ 
/*  48 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean doBatch()
/*     */   {
/*  54 */     String branchtype = "1";
/*  55 */     ExeSQL exeSQL = new ExeSQL();
/*  56 */     SSRS ssrs1 = new SSRS();
/*     */     try
/*     */     {
/*  61 */       String sql = " select la.agentcode ,count(1) ";
/*  62 */       sql = sql + " from tb_application tb_app ";
/*     */ 
/*  64 */       sql = sql + " INNER JOIN TB_GROUP_NUMBER_Encrypt tb_g ON  tb_app.cd_administrator = tb_g.cd_administrator AND tb_app.cd_branch = tb_g.cd_branch  AND tb_app.cd_administrator_group_number = tb_g.cd_group_number and tb_app.src_cd = tb_g.src_cd ";
/*  65 */       sql = sql + " inner join tb_collection tb_c on tb_app.cd_administrator=tb_c.cd_administrator and tb_app.cd_branch=tb_c.cd_branch and tb_app.cd_line_business=tb_c.cd_line_business and tb_app.cd_policy=tb_c.cd_policy ";
/*  66 */       sql = sql + " inner join tb_application_broker tb_a_b  on tb_app.cd_administrator=tb_a_b.cd_administrator and tb_app.cd_branch=tb_a_b.cd_branch and tb_app.cd_product=tb_a_b.cd_product and tb_app.cd_application=tb_a_b.cd_application ";
/*  67 */       sql = sql + " inner join laagent la  on  '86' + right('0'+ltrim(str(tb_a_b.cd_branch)),2) + right('00000' + ltrim(str(tb_a_b.cd_broker)),6)=la.agentcode ";
/*  68 */       sql = sql + " where 1=1 ";
/*  69 */       sql = sql + " AND tb_app.de_status ='Active' ";
/*  70 */       sql = sql + " and la.branchtype ='1' ";
/*  71 */       sql = sql + " and tb_c.dt_cancelling is null and tb_c.dt_payment is null and tb_c.vl_parcel>0  ";
/*  72 */       sql = sql + " and ((tb_a_b.src_cd = 'ILIFE' and tb_a_b.rec_type='S') or (tb_a_b.src_cd = 'ESEG') ) ";
/*  73 */       sql = sql + " and CONVERT(varchar(24), getdate()-70, 23) <= tb_c.dt_expiration ";
/*  74 */       sql = sql + " and CONVERT(varchar(24), getdate()+15, 23) >= tb_c.dt_expiration ";
/*  75 */       sql = sql + " group by la.agentcode ";
/*     */ 
/*  77 */       ssrs1 = exeSQL.execSQL(sql);
/*     */ 
/*  79 */       SysMaxNoMap ttMPrivateDelNOMap = new SysMaxNoMap("MPrivateDelNO", 12, 1);
/*  80 */       String tDelID = ttMPrivateDelNOMap.next();
/*     */ 
/*  83 */       MPrivateMessageSet tMPrivateMessageSet = new MPrivateMessageSet();
/*  84 */       if ((ssrs1 != null) && (ssrs1.MaxRow > 0))
/*     */       {
/*  86 */         for (int i = 1; i <= ssrs1.MaxRow; i++)
/*     */         {
/*  88 */           MPrivateMessageSchema tMPrivateMessageSchema = new MPrivateMessageSchema();
/*  89 */           SysMaxNoMap tSysMaxNoMap = new SysMaxNoMap("MPrivateMegNO", 12, 1);
/*  90 */           String tID = tSysMaxNoMap.next();
/*  91 */           tMPrivateMessageSchema.setID(tID);
/*  92 */           tMPrivateMessageSchema.setAgentCode(ssrs1.GetText(i, 1));
/*  93 */           tMPrivateMessageSchema.setManageCom(ssrs1.GetText(i, 1).substring(0, 4));
/*  94 */           tMPrivateMessageSchema.setBranchType(branchtype);
/*  95 */           tMPrivateMessageSchema.setMessageType("05");
/*     */ 
/*  97 */           tMPrivateMessageSchema.setKeyData(ssrs1.GetText(i, 2));
/*  98 */           tMPrivateMessageSchema.setType("2");
/*  99 */           tMPrivateMessageSchema.setState("1");
/*     */ 
/* 101 */           tMPrivateMessageSchema.setOperator(tDelID);
/* 102 */           tMPrivateMessageSchema.setMakeDate(PubFun.getCurrentDate());
/* 103 */           tMPrivateMessageSchema.setMakeTime(PubFun.getCurrentTime());
/*     */ 
/* 105 */           tMPrivateMessageSet.add(tMPrivateMessageSchema);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 110 */       MPrivateMessageSet rMPrivateMessageSet = new MPrivateMessageSet();
/*     */ 
/* 112 */       String querysql = " select id from MPrivateMessage where branchtype ='1' and messagetype='05' and operator <> '" + tDelID + "'  ";
/* 113 */       SSRS ssrs2 = new SSRS();
/* 114 */       ssrs2 = exeSQL.execSQL(querysql);
/* 115 */       if ((ssrs2 != null) && (ssrs2.MaxRow > 0))
/*     */       {
/* 117 */         for (int i = 1; i <= ssrs2.MaxRow; i++)
/*     */         {
/* 119 */           MPrivateMessageSchema rMPrivateMessageSchema = new MPrivateMessageSchema();
/*     */ 
/* 121 */           rMPrivateMessageSchema.setID(ssrs2.GetText(i, 1));
/* 122 */           rMPrivateMessageSet.add(rMPrivateMessageSchema);
/*     */         }
/*     */       }
/*     */ 
/* 126 */       MMap mmap = new MMap();
/* 127 */       mmap.put(tMPrivateMessageSet, "INSERT");
/* 128 */       mmap.put(rMPrivateMessageSet, "DELETE");
/* 129 */       VData tVData = new VData();
/* 130 */       tVData.add(mmap);
/*     */ 
/* 132 */       PubSubmit tPubSubmit = new PubSubmit();
/* 133 */       tPubSubmit.submitData(tVData, "");
/*     */ 
/* 135 */       return true;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 140 */       e.printStackTrace();
/* 141 */     }return false;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.batch.RenewalPayment
 * JD-Core Version:    0.6.0
 */