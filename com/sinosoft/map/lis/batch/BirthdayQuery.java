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
/*     */ public class BirthdayQuery
/*     */ {
/*  19 */   private String tNowStatYM = "";
/*  20 */   private String tCalStatYM = "";
/*  21 */   private String tCalStartDate = "";
/*  22 */   private String tCalEndDate = "";
/*  23 */   private String tCalDate = "";
/*  24 */   private String tCalRange = "30";
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
/*  63 */       String sql = " select a.agentcode,count(1) from ( ";
/*  64 */       sql = sql + " select la.agentcode as agentcode ";
/*  65 */       sql = sql + " from tb_application tb_app   ";
/*     */ 
/*  67 */       sql = sql + " INNER JOIN TB_GROUP_NUMBER_Encrypt tb_g ON  tb_app.cd_administrator = tb_g.cd_administrator AND tb_app.cd_branch = tb_g.cd_branch  AND tb_app.cd_administrator_group_number = tb_g.cd_group_number and tb_app.src_cd = tb_g.src_cd ";
/*  68 */       sql = sql + " inner join   tb_application_broker tb_a_b  on tb_app.cd_administrator=tb_a_b.cd_administrator  and tb_app.cd_branch=tb_a_b.cd_branch and tb_app.cd_product=tb_a_b.cd_product  and tb_app.cd_application=tb_a_b.cd_application ";
/*  69 */       sql = sql + " inner join laagent la  on  '86' + right('0'+ltrim(str(tb_a_b.cd_branch)),2) + right('00000' + ltrim(str(tb_a_b.cd_broker)),6)=la.agentcode ";
/*  70 */       sql = sql + " where tb_g.dt_birth is not null ";
/*     */ 
/*  72 */       String caldate1 = PubFun.getCurrentDate();
/*  73 */       String strmonth = caldate1.substring(5, 7);
/*  74 */       String strday = caldate1.substring(8, 10);
/*     */ 
/*  76 */       if ((strmonth.compareTo("12") == 0) && (strday.compareTo("03") >= 0))
/*  77 */         sql = sql + " and (( substring(CONVERT(varchar(24), tb_g.dt_birth, 23),6,10) >= substring(CONVERT(varchar(24),getdate(),23),6,10) and substring(CONVERT(varchar(24), tb_g.dt_birth, 23),6,10) <='12-31') or ( substring(CONVERT(varchar(24), tb_g.dt_birth, 23),6,10) <= substring(CONVERT(varchar(24),getdate()+30,23),6,10) and substring(CONVERT(varchar(24), tb_g.dt_birth, 23),6,10) >='01-01') )";
/*  78 */       else sql = sql + " and substring(CONVERT(varchar(24), tb_g.dt_birth, 23),6,10) >= substring(CONVERT(varchar(24),getdate(),23),6,10) and substring(CONVERT(varchar(24), tb_g.dt_birth, 23),6,10) <= substring(CONVERT(varchar(24),getdate()+30,23),6,10) ";
/*     */ 
/*  82 */       sql = sql + " and la.branchtype='1' ";
/*  83 */       sql = sql + " union all ";
/*  84 */       sql = sql + " select  la.agentcode as agentcode ";
/*  85 */       sql = sql + " from tb_application tb_app ";
/*     */ 
/*  87 */       sql = sql + " INNER JOIN TB_PARTICIPANT_Encrypt tb_p ON  tb_app.cd_administrator = tb_p.cd_administrator AND tb_app.cd_branch = tb_p.cd_branch AND tb_app.cd_participant = tb_p.cd_participant and tb_app.src_cd = tb_p.src_cd ";
/*  88 */       sql = sql + " inner join   tb_application_broker tb_a_b  on tb_app.cd_administrator=tb_a_b.cd_administrator and tb_app.cd_branch=tb_a_b.cd_branch and tb_app.cd_product=tb_a_b.cd_product  and tb_app.cd_application=tb_a_b.cd_application ";
/*  89 */       sql = sql + " inner join laagent la  on  '86' + right('0'+ltrim(str(tb_a_b.cd_branch)),2) + right('00000' + ltrim(str(tb_a_b.cd_broker)),6)=la.agentcode ";
/*  90 */       sql = sql + " where tb_p.dt_birth is not null ";
/*  91 */       sql = sql + " and la.branchtype='1' ";
/*     */ 
/*  94 */       if ((strmonth.compareTo("12") == 0) && (strday.compareTo("03") >= 0))
/*  95 */         sql = sql + " and (( substring(CONVERT(varchar(24), tb_p.dt_birth, 23),6,10) >= substring(CONVERT(varchar(24),getdate(),23),6,10) and substring(CONVERT(varchar(24), tb_p.dt_birth, 23),6,10) <='12-31') or ( substring(CONVERT(varchar(24), tb_p.dt_birth, 23),6,10) <= substring(CONVERT(varchar(24),getdate()+30,23),6,10) and substring(CONVERT(varchar(24), tb_p.dt_birth, 23),6,10) >='01-01') )";
/*  96 */       else sql = sql + " and substring(CONVERT(varchar(24), tb_p.dt_birth, 23),6,10) >= substring(CONVERT(varchar(24),getdate(),23),6,10) and substring(CONVERT(varchar(24), tb_p.dt_birth, 23),6,10) <= substring(CONVERT(varchar(24),getdate()+30,23),6,10) ";
/*     */ 
/* 101 */       sql = sql + " union all ";
/* 102 */       sql = sql + " select la.agentcode as agentcode ";
/* 103 */       sql = sql + " from lslatncycustm c ";
/* 104 */       sql = sql + " inner join laagent la on c.operator=la.agentcode ";
/* 105 */       sql = sql + " where 1=1 and c.Birthday is not null ";
/* 106 */       sql = sql + " and not exists ( select 1 from  mclientrelation where c.CustomerNo=prospectsno ) ";
/*     */ 
/* 109 */       if ((strmonth.compareTo("12") == 0) && (strday.compareTo("03") >= 0))
/* 110 */         sql = sql + " and (( substring(CONVERT(varchar(24), c.Birthday, 23),6,10) >= substring(CONVERT(varchar(24),getdate(),23),6,10) and substring(CONVERT(varchar(24), c.Birthday, 23),6,10) <='12-31') or ( substring(CONVERT(varchar(24), c.Birthday, 23),6,10) <= substring(CONVERT(varchar(24),getdate()+30,23),6,10) and substring(CONVERT(varchar(24), c.Birthday, 23),6,10) >='01-01') )";
/* 111 */       else sql = sql + " and substring(CONVERT(varchar(24), c.Birthday, 23),6,10) >= substring(CONVERT(varchar(24),getdate(),23),6,10) and substring(CONVERT(varchar(24), c.Birthday, 23),6,10) <= substring(CONVERT(varchar(24),getdate()+30,23),6,10) ";
/*     */ 
/* 115 */       sql = sql + " and la.branchtype='1' ";
/*     */ 
/* 117 */       sql = sql + " ) a ";
/* 118 */       sql = sql + " group by a.agentcode ";
/*     */ 
/* 121 */       ssrs1 = exeSQL.execSQL(sql);
/*     */ 
/* 123 */       SysMaxNoMap ttMPrivateDelNOMap = new SysMaxNoMap("MPrivateDelNO", 12, 1);
/* 124 */       String tDelID = ttMPrivateDelNOMap.next();
/*     */ 
/* 127 */       MPrivateMessageSet tMPrivateMessageSet = new MPrivateMessageSet();
/* 128 */       if ((ssrs1 != null) && (ssrs1.MaxRow > 0))
/*     */       {
/* 130 */         for (int i = 1; i <= ssrs1.MaxRow; i++)
/*     */         {
/* 132 */           MPrivateMessageSchema tMPrivateMessageSchema = new MPrivateMessageSchema();
/* 133 */           SysMaxNoMap tSysMaxNoMap = new SysMaxNoMap("MPrivateMegNO", 12, 1);
/* 134 */           String tID = tSysMaxNoMap.next();
/* 135 */           tMPrivateMessageSchema.setID(tID);
/* 136 */           tMPrivateMessageSchema.setAgentCode(ssrs1.GetText(i, 1));
/* 137 */           tMPrivateMessageSchema.setManageCom(ssrs1.GetText(i, 1).substring(0, 4));
/* 138 */           tMPrivateMessageSchema.setBranchType(branchtype);
/* 139 */           tMPrivateMessageSchema.setMessageType("06");
/*     */ 
/* 141 */           tMPrivateMessageSchema.setKeyData(ssrs1.GetText(i, 2));
/* 142 */           tMPrivateMessageSchema.setType("2");
/* 143 */           tMPrivateMessageSchema.setState("1");
/*     */ 
/* 145 */           tMPrivateMessageSchema.setOperator(tDelID);
/*     */ 
/* 147 */           tMPrivateMessageSchema.setMakeDate(PubFun.getCurrentDate());
/* 148 */           tMPrivateMessageSchema.setMakeTime(PubFun.getCurrentTime());
/*     */ 
/* 150 */           tMPrivateMessageSet.add(tMPrivateMessageSchema);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 155 */       MPrivateMessageSet rMPrivateMessageSet = new MPrivateMessageSet();
/*     */ 
/* 157 */       String querysql = " select id from MPrivateMessage where branchtype ='1' and messagetype='06' and operator <> '" + tDelID + "'  ";
/* 158 */       SSRS ssrs2 = new SSRS();
/* 159 */       ssrs2 = exeSQL.execSQL(querysql);
/* 160 */       if ((ssrs2 != null) && (ssrs2.MaxRow > 0))
/*     */       {
/* 162 */         for (int i = 1; i <= ssrs2.MaxRow; i++)
/*     */         {
/* 164 */           MPrivateMessageSchema rMPrivateMessageSchema = new MPrivateMessageSchema();
/*     */ 
/* 166 */           rMPrivateMessageSchema.setID(ssrs2.GetText(i, 1));
/* 167 */           rMPrivateMessageSet.add(rMPrivateMessageSchema);
/*     */         }
/*     */       }
/*     */ 
/* 171 */       MMap mmap = new MMap();
/* 172 */       mmap.put(tMPrivateMessageSet, "INSERT");
/* 173 */       mmap.put(rMPrivateMessageSet, "DELETE");
/* 174 */       VData tVData = new VData();
/* 175 */       tVData.add(mmap);
/*     */ 
/* 177 */       PubSubmit tPubSubmit = new PubSubmit();
/* 178 */       tPubSubmit.submitData(tVData, "");
/*     */ 
/* 180 */       return true;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 185 */       e.printStackTrace();
/* 186 */     }return false;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.batch.BirthdayQuery
 * JD-Core Version:    0.6.0
 */