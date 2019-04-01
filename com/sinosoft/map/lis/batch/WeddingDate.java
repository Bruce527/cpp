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
/*     */ public class WeddingDate
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
/*  61 */       String sql = " select a.agentcode,count(1) from ( ";
/*  62 */       sql = sql + " select  la.agentcode as agentcode ";
/*  63 */       sql = sql + " from tb_application tb_app ";
/*     */ 
/*  65 */       sql = sql + " INNER JOIN TB_GROUP_NUMBER_Encrypt tb_g ON  tb_app.cd_administrator = tb_g.cd_administrator AND tb_app.cd_branch = tb_g.cd_branch  AND tb_app.cd_administrator_group_number = tb_g.cd_group_number and tb_app.src_cd = tb_g.src_cd ";
/*  66 */       sql = sql + " inner join tb_application_broker tb_a_b  on tb_app.cd_administrator=tb_a_b.cd_administrator  and tb_app.cd_branch=tb_a_b.cd_branch and tb_app.cd_product=tb_a_b.cd_product  and tb_app.cd_application=tb_a_b.cd_application ";
/*  67 */       sql = sql + " inner join laagent la  on  '86' + right('0'+ltrim(str(tb_a_b.cd_branch)),2) + right('00000' + ltrim(str(tb_a_b.cd_broker)),6)=la.agentcode ";
/*  68 */       sql = sql + " inner join mclientrelation m_cr on tb_g.cd_group_number=m_cr.customerno inner join lslatncycustm c on m_cr.prospectsno=c.CustomerNo ";
/*  69 */       sql = sql + " where  1=1 ";
/*     */ 
/*  71 */       String caldate1 = PubFun.getCurrentDate();
/*  72 */       String strmonth = caldate1.substring(5, 7);
/*  73 */       String strday = caldate1.substring(8, 10);
/*     */ 
/*  75 */       if ((strmonth.compareTo("12") == 0) && (strday.compareTo("03") >= 0))
/*  76 */         sql = sql + " and (( substring(CONVERT(varchar(24), c.SpecialDate, 23),6,10) >= substring(CONVERT(varchar(24),getdate(),23),6,10) and substring(CONVERT(varchar(24), c.SpecialDate, 23),6,10) <='12-31') or ( substring(CONVERT(varchar(24), c.SpecialDate, 23),6,10) <= substring(CONVERT(varchar(24),getdate()+30,23),6,10) and substring(CONVERT(varchar(24), c.SpecialDate, 23),6,10) >='01-01') )";
/*  77 */       else sql = sql + " and substring(CONVERT(varchar(24), c.SpecialDate, 23),6,10) >= substring(CONVERT(varchar(24),getdate(),23),6,10) and substring(CONVERT(varchar(24), c.SpecialDate, 23),6,10) <= substring(CONVERT(varchar(24),getdate()+30,23),6,10) ";
/*     */ 
/*  81 */       sql = sql + " union all ";
/*  82 */       sql = sql + " select la.agentcode as agentcode ";
/*  83 */       sql = sql + " from lslatncycustm c inner join laagent la ";
/*  84 */       sql = sql + " on c.operator=la.agentcode ";
/*  85 */       sql = sql + " and la.branchtype='1' ";
/*  86 */       sql = sql + " where 1=1 ";
/*  87 */       sql = sql + " and  c.CustomerNo not in ( select prospectsno from  mclientrelation )  ";
/*  88 */       sql = sql + " and  not exists ( select 1 from  mclientrelation where prospectsno = c.CustomerNo ) ";
/*  89 */       sql = sql + " and la.branchtype='1' ";
/*  90 */       sql = sql + " and c.SpecialDate is not null ";
/*     */ 
/*  93 */       if ((strmonth.compareTo("12") == 0) && (strday.compareTo("03") >= 0))
/*  94 */         sql = sql + " and (( substring(CONVERT(varchar(24), c.SpecialDate, 23),6,10) >= substring(CONVERT(varchar(24),getdate(),23),6,10) and substring(CONVERT(varchar(24), c.SpecialDate, 23),6,10) <='12-31') or ( substring(CONVERT(varchar(24), c.SpecialDate, 23),6,10) <= substring(CONVERT(varchar(24),getdate()+30,23),6,10) and substring(CONVERT(varchar(24), c.SpecialDate, 23),6,10) >='01-01') )";
/*  95 */       else sql = sql + " and substring(CONVERT(varchar(24), c.SpecialDate, 23),6,10) >= substring(CONVERT(varchar(24),getdate(),23),6,10) and substring(CONVERT(varchar(24), c.SpecialDate, 23),6,10) <= substring(CONVERT(varchar(24),getdate()+30,23),6,10) ";
/*     */ 
/*  99 */       sql = sql + " ) a ";
/* 100 */       sql = sql + " group by a.agentcode ";
/*     */ 
/* 102 */       ssrs1 = exeSQL.execSQL(sql);
/*     */ 
/* 104 */       SysMaxNoMap ttMPrivateDelNOMap = new SysMaxNoMap("MPrivateDelNO", 12, 1);
/* 105 */       String tDelID = ttMPrivateDelNOMap.next();
/*     */ 
/* 108 */       MPrivateMessageSet tMPrivateMessageSet = new MPrivateMessageSet();
/* 109 */       if ((ssrs1 != null) && (ssrs1.MaxRow > 0))
/*     */       {
/* 111 */         for (int i = 1; i <= ssrs1.MaxRow; i++)
/*     */         {
/* 113 */           MPrivateMessageSchema tMPrivateMessageSchema = new MPrivateMessageSchema();
/* 114 */           SysMaxNoMap tSysMaxNoMap = new SysMaxNoMap("MPrivateMegNO", 12, 1);
/* 115 */           String tID = tSysMaxNoMap.next();
/* 116 */           tMPrivateMessageSchema.setID(tID);
/* 117 */           tMPrivateMessageSchema.setAgentCode(ssrs1.GetText(i, 1));
/* 118 */           tMPrivateMessageSchema.setManageCom(ssrs1.GetText(i, 1).substring(0, 4));
/* 119 */           tMPrivateMessageSchema.setBranchType(branchtype);
/* 120 */           tMPrivateMessageSchema.setMessageType("07");
/*     */ 
/* 122 */           tMPrivateMessageSchema.setKeyData(ssrs1.GetText(i, 2));
/* 123 */           tMPrivateMessageSchema.setType("1");
/* 124 */           tMPrivateMessageSchema.setState("1");
/*     */ 
/* 126 */           tMPrivateMessageSchema.setOperator(tDelID);
/* 127 */           tMPrivateMessageSchema.setMakeDate(PubFun.getCurrentDate());
/* 128 */           tMPrivateMessageSchema.setMakeTime(PubFun.getCurrentTime());
/*     */ 
/* 130 */           tMPrivateMessageSet.add(tMPrivateMessageSchema);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 135 */       MPrivateMessageSet rMPrivateMessageSet = new MPrivateMessageSet();
/*     */ 
/* 137 */       String querysql = " select id from MPrivateMessage where branchtype ='1' and messagetype='07' and operator <> '" + tDelID + "' ";
/* 138 */       SSRS ssrs2 = new SSRS();
/* 139 */       ssrs2 = exeSQL.execSQL(querysql);
/* 140 */       if ((ssrs2 != null) && (ssrs2.MaxRow > 0))
/*     */       {
/* 142 */         for (int i = 1; i <= ssrs2.MaxRow; i++)
/*     */         {
/* 144 */           MPrivateMessageSchema rMPrivateMessageSchema = new MPrivateMessageSchema();
/*     */ 
/* 146 */           rMPrivateMessageSchema.setID(ssrs2.GetText(i, 1));
/* 147 */           rMPrivateMessageSet.add(rMPrivateMessageSchema);
/*     */         }
/*     */       }
/*     */ 
/* 151 */       MMap mmap = new MMap();
/* 152 */       mmap.put(tMPrivateMessageSet, "INSERT");
/* 153 */       mmap.put(rMPrivateMessageSet, "DELETE");
/* 154 */       VData tVData = new VData();
/* 155 */       tVData.add(mmap);
/*     */ 
/* 157 */       PubSubmit tPubSubmit = new PubSubmit();
/* 158 */       tPubSubmit.submitData(tVData, "");
/*     */ 
/* 160 */       return true;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 165 */       e.printStackTrace();
/* 166 */     }return false;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.batch.WeddingDate
 * JD-Core Version:    0.6.0
 */