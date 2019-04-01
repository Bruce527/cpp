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
/*     */ public class PolicyYearCheck
/*     */ {
/*  19 */   private String tNowStatYM = "";
/*  20 */   private String tCalStatYM = "";
/*  21 */   private String tCalStartDate = "";
/*  22 */   private String tCalEndDate = "";
/*  23 */   private String tCalDate = "20";
/*     */ 
/*     */   public void batch()
/*     */   {
/*  29 */     if (IsBatch())
/*     */     {
/*  32 */       doBatch();
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean IsBatch()
/*     */   {
/*  40 */     ExeSQL exeSQL = new ExeSQL();
/*  41 */     SSRS ssrs1 = new SSRS();
/*     */ 
/*  43 */     String branchtype = "1";
/*     */ 
/*  46 */     String ttsql = "select max(keydata) from MPrivateMessage where 1=1 and messagetype='04' and branchtype='" + branchtype + "'";
/*  47 */     ssrs1 = exeSQL.execSQL(ttsql);
/*  48 */     if ((ssrs1 != null) && (!ssrs1.GetText(1, 1).equals("")))
/*     */     {
/*  51 */       String caldate = PubFun.getCurrentDate();
/*  52 */       if (caldate.substring(8, 10).equals(this.tCalDate))
/*     */       {
/*  54 */         this.tNowStatYM = (caldate.substring(0, 4) + caldate.substring(5, 7));
/*     */ 
/*  57 */         String sql = " select distinct yearmonth,startdate,enddate from LASTATSEGMENT where 1=1 ";
/*  58 */         sql = sql + " and stattype='1' ";
/*  59 */         sql = sql + " and yearmonth > (select max(keydata) from MPrivateMessage where branchtype ='" + branchtype + "' and messagetype='04') ";
/*  60 */         sql = sql + " order by yearmonth ";
/*     */ 
/*  62 */         ssrs1 = exeSQL.execSQL(sql);
/*  63 */         if ((ssrs1 != null) && (ssrs1.MaxRow > 0))
/*     */         {
/*  66 */           this.tCalStatYM = ssrs1.GetText(1, 1);
/*  67 */           this.tCalStartDate = ssrs1.GetText(1, 2);
/*  68 */           this.tCalEndDate = ssrs1.GetText(1, 3);
/*     */ 
/*  70 */           return true;
/*     */         }
/*     */ 
/*  75 */         return false;
/*     */       }
/*     */ 
/*  81 */       return false;
/*     */     }
/*     */ 
/*  87 */     String sql = "select distinct yearmonth,startdate,enddate from LASTATSEGMENT where 1=1 and stattype='1' and startdate <= CONVERT(varchar(24), getdate(), 23) and enddate >= CONVERT(varchar(24), getdate(), 23) ";
/*     */ 
/*  89 */     ssrs1 = exeSQL.execSQL(sql);
/*  90 */     String caldate = PubFun.getCurrentDate();
/*  91 */     if ((ssrs1 != null) && (ssrs1.MaxRow > 0))
/*     */     {
/*  93 */       this.tNowStatYM = (caldate.substring(0, 4) + caldate.substring(5, 7));
/*  94 */       this.tCalStatYM = ssrs1.GetText(1, 1);
/*  95 */       this.tCalStartDate = ssrs1.GetText(1, 2);
/*  96 */       this.tCalEndDate = ssrs1.GetText(1, 3);
/*     */ 
/*  98 */       return true;
/*     */     }
/*     */ 
/* 103 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean doBatch()
/*     */   {
/* 112 */     String branchtype = "1";
/* 113 */     ExeSQL exeSQL = new ExeSQL();
/* 114 */     SSRS ssrs1 = new SSRS();
/*     */     try
/*     */     {
/* 119 */       if ((this.tCalStatYM != null) && (!"".equals(this.tCalStatYM)))
/*     */       {
/* 121 */         String sql = " select la.agentcode,count(1) ";
/* 122 */         sql = sql + " from tb_application tb_app ";
/* 123 */         sql = sql + " inner join tb_application_broker tb_a_b  on tb_app.cd_administrator=tb_a_b.cd_administrator  and tb_app.cd_branch=tb_a_b.cd_branch and tb_app.cd_product=tb_a_b.cd_product  and tb_app.cd_application=tb_a_b.cd_application  ";
/* 124 */         sql = sql + " and ((tb_a_b.src_cd = 'ILIFE' and tb_a_b.rec_type='S') or (tb_a_b.src_cd = 'ESEG') )  ";
/* 125 */         sql = sql + " inner join laagent la  on  '86' + right('0'+ltrim(str(tb_a_b.cd_branch)),2) + right('00000' + ltrim(str(tb_a_b.cd_broker)),6)=la.agentcode ";
/* 126 */         sql = sql + " where 1=1 ";
/*     */ 
/* 128 */         if ((this.tCalStartDate.length() > 0) && (this.tCalEndDate.length() > 0))
/*     */         {
/* 130 */           sql = sql + " and substring(CONVERT(varchar(24), tb_app.dt_policy_activation, 23),6,10) >='" + this.tCalStartDate.substring(5, 10) + "' and substring(CONVERT(varchar(24), tb_app.dt_policy_activation, 23),6,10) <='" + this.tCalEndDate.substring(5, 10) + "' and year(tb_app.dt_policy_activation) < year(getdate()) ";
/*     */         }
/*     */ 
/* 133 */         sql = sql + " and la.branchtype='" + branchtype + "' ";
/*     */ 
/* 136 */         sql = sql + " and la.agentstate in ('01','02','06') ";
/* 137 */         sql = sql + " and (tb_app.de_status in ('Active','Insolv. Canceled')) ";
/* 138 */         sql = sql + " group by la.agentcode ";
/*     */ 
/* 140 */         ssrs1 = exeSQL.execSQL(sql);
/*     */ 
/* 142 */         SysMaxNoMap ttMPrivateDelNOMap = new SysMaxNoMap("MPrivateDelNO", 12, 1);
/* 143 */         String tDelID = ttMPrivateDelNOMap.next();
/*     */ 
/* 146 */         MPrivateMessageSet tMPrivateMessageSet = new MPrivateMessageSet();
/* 147 */         if ((ssrs1 != null) && (ssrs1.MaxRow > 0))
/*     */         {
/* 149 */           for (int i = 1; i <= ssrs1.MaxRow; i++)
/*     */           {
/* 151 */             MPrivateMessageSchema tMPrivateMessageSchema = new MPrivateMessageSchema();
/* 152 */             SysMaxNoMap tSysMaxNoMap = new SysMaxNoMap("MPrivateMegNO", 12, 1);
/* 153 */             String tID = tSysMaxNoMap.next();
/* 154 */             tMPrivateMessageSchema.setID(tID);
/* 155 */             tMPrivateMessageSchema.setAgentCode(ssrs1.GetText(i, 1));
/* 156 */             tMPrivateMessageSchema.setManageCom(ssrs1.GetText(i, 1).substring(0, 4));
/* 157 */             tMPrivateMessageSchema.setBranchType(branchtype);
/* 158 */             tMPrivateMessageSchema.setMessageType("04");
/* 159 */             tMPrivateMessageSchema.setKeyData(this.tCalStatYM);
/* 160 */             tMPrivateMessageSchema.setKeyData2(ssrs1.GetText(i, 2));
/* 161 */             tMPrivateMessageSchema.setType("1");
/* 162 */             tMPrivateMessageSchema.setState("1");
/*     */ 
/* 164 */             tMPrivateMessageSchema.setOperator(tDelID);
/*     */ 
/* 166 */             tMPrivateMessageSchema.setMakeDate(PubFun.getCurrentDate());
/* 167 */             tMPrivateMessageSchema.setMakeTime(PubFun.getCurrentTime());
/*     */ 
/* 169 */             tMPrivateMessageSet.add(tMPrivateMessageSchema);
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/* 174 */         MPrivateMessageSet rMPrivateMessageSet = new MPrivateMessageSet();
/*     */ 
/* 176 */         String querysql = " select id from MPrivateMessage where branchtype ='1' and messagetype='04' and (KeyData <> '" + this.tCalStatYM + "' or KeyData <> '" + this.tNowStatYM + "') ";
/* 177 */         SSRS ssrs2 = new SSRS();
/* 178 */         ssrs2 = exeSQL.execSQL(querysql);
/* 179 */         if ((ssrs2 != null) && (ssrs2.MaxRow > 0))
/*     */         {
/* 181 */           for (int i = 1; i <= ssrs2.MaxRow; i++)
/*     */           {
/* 183 */             MPrivateMessageSchema rMPrivateMessageSchema = new MPrivateMessageSchema();
/*     */ 
/* 185 */             rMPrivateMessageSchema.setID(ssrs2.GetText(i, 1));
/* 186 */             rMPrivateMessageSet.add(rMPrivateMessageSchema);
/*     */           }
/*     */         }
/*     */ 
/* 190 */         MMap mmap = new MMap();
/* 191 */         mmap.put(tMPrivateMessageSet, "INSERT");
/* 192 */         mmap.put(rMPrivateMessageSet, "DELETE");
/* 193 */         VData tVData = new VData();
/* 194 */         tVData.add(mmap);
/*     */ 
/* 196 */         PubSubmit tPubSubmit = new PubSubmit();
/* 197 */         tPubSubmit.submitData(tVData, "");
/*     */ 
/* 199 */         return true;
/*     */       }
/*     */ 
/* 204 */       return false;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 209 */       e.printStackTrace();
/* 210 */     }return false;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.batch.PolicyYearCheck
 * JD-Core Version:    0.6.0
 */