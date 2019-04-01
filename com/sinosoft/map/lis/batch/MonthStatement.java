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
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public class MonthStatement
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
/*  36 */     ExeSQL exeSQL = new ExeSQL();
/*  37 */     SSRS ssrs1 = new SSRS();
/*     */ 
/*  39 */     String branchtype = "1";
/*     */ 
/*  42 */     String ttsql = "select max(keydata) from MC2BMessage where branchtype ='" + branchtype + "' and messagetype='01'";
/*  43 */     ssrs1 = exeSQL.execSQL(ttsql);
/*  44 */     System.out.println(ssrs1.GetText(1, 1));
/*  45 */     if ((ssrs1 != null) && (!ssrs1.GetText(1, 1).equals("")))
/*     */     {
/*  48 */       String sql = " select distinct yearmonth,startdate from LASTATSEGMENT where 1=1 ";
/*     */ 
/*  50 */       sql = sql + " and stattype='6' ";
/*  51 */       sql = sql + " and yearmonth > (select max(keydata) from MC2BMessage where branchtype ='" + branchtype + "' and messagetype='01') ";
/*  52 */       sql = sql + " order by yearmonth ";
/*     */ 
/*  54 */       ssrs1 = exeSQL.execSQL(sql);
/*  55 */       if ((ssrs1 != null) && (ssrs1.MaxRow > 0))
/*     */       {
/*  57 */         String statym = ssrs1.GetText(1, 1);
/*  58 */         String startdate = ssrs1.GetText(1, 2);
/*     */ 
/*  61 */         String caldate = PubFun.getCurrentDate();
/*  62 */         if (startdate.equals(caldate))
/*     */         {
/*  65 */           this.tCalStatYM = statym;
/*  66 */           this.tCalStartDate = startdate;
/*  67 */           return true;
/*     */         }
/*     */ 
/*  71 */         return false;
/*     */       }
/*     */ 
/*  77 */       return false;
/*     */     }
/*     */ 
/*  82 */     String sql = "select distinct yearmonth,startdate from LASTATSEGMENT where 1=1 and stattype='6' and startdate <= '" + PubFun.getCurrentDate() + "' and enddate >= '" + PubFun.getCurrentDate() + "' ";
/*     */ 
/*  84 */     ssrs1 = exeSQL.execSQL(sql);
/*  85 */     if ((ssrs1 != null) && (ssrs1.MaxRow > 0))
/*     */     {
/*  87 */       String statym = ssrs1.GetText(1, 1);
/*  88 */       String startdate = ssrs1.GetText(1, 2);
/*  89 */       this.tCalStatYM = statym;
/*  90 */       this.tCalStartDate = startdate;
/*     */ 
/*  92 */       return true;
/*     */     }
/*     */ 
/*  97 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean doBatch()
/*     */   {
/* 108 */     String branchtype = "1";
/* 109 */     ExeSQL exeSQL = new ExeSQL();
/* 110 */     SSRS ssrs1 = new SSRS();
/*     */     try
/*     */     {
/* 115 */       if ((this.tCalStatYM != null) && (!"".equals(this.tCalStatYM)))
/*     */       {
/* 117 */         String sql = " select managecom,stattype,yearmonth,startdate,enddate,areatype from LASTATSEGMENT where stattype='6' and yearmonth='" + this.tCalStatYM + "' ";
/* 118 */         ssrs1 = exeSQL.execSQL(sql);
/*     */ 
/* 120 */         SysMaxNoMap ttMPrivateDelNOMap = new SysMaxNoMap("MPrivateDelNO", 12, 1);
/* 121 */         String tDelID = ttMPrivateDelNOMap.next();
/*     */ 
/* 124 */         MC2BMessageSet tMC2BMessageSet = new MC2BMessageSet();
/* 125 */         if ((ssrs1 != null) && (ssrs1.MaxRow > 0))
/*     */         {
/* 127 */           for (int i = 1; i <= ssrs1.MaxRow; i++)
/*     */           {
/* 129 */             MC2BMessageSchema tMC2BMessageSchema = new MC2BMessageSchema();
/* 130 */             SysMaxNoMap tSysMaxNoMap = new SysMaxNoMap("MC2BMessageNO", 12, 1);
/* 131 */             String tID = tSysMaxNoMap.next();
/* 132 */             tMC2BMessageSchema.setID(tID);
/* 133 */             tMC2BMessageSchema.setManageCom(ssrs1.GetText(i, 1));
/* 134 */             tMC2BMessageSchema.setBranchType(branchtype);
/* 135 */             tMC2BMessageSchema.setKeyData(ssrs1.GetText(i, 3));
/* 136 */             tMC2BMessageSchema.setMessageType("01");
/* 137 */             tMC2BMessageSchema.setType("1");
/* 138 */             tMC2BMessageSchema.setState("1");
/* 139 */             tMC2BMessageSchema.setKeyData2(ssrs1.GetText(i, 5));
/*     */ 
/* 141 */             tMC2BMessageSchema.setMakeDate(PubFun.getCurrentDate());
/* 142 */             tMC2BMessageSchema.setMakeTime(PubFun.getCurrentTime());
/*     */ 
/* 144 */             tMC2BMessageSchema.setOperator(tDelID);
/*     */ 
/* 146 */             tMC2BMessageSet.add(tMC2BMessageSchema);
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/* 152 */         MC2BMessageSet rMC2BMessageSet = new MC2BMessageSet();
/*     */ 
/* 154 */         String querysql = " select id from MC2BMessage where branchtype ='1' and messagetype='01' and operator <> '" + tDelID + "'  ";
/* 155 */         SSRS ssrs2 = new SSRS();
/* 156 */         ssrs2 = exeSQL.execSQL(querysql);
/* 157 */         if ((ssrs2 != null) && (ssrs2.MaxRow > 0))
/*     */         {
/* 159 */           for (int i = 1; i <= ssrs2.MaxRow; i++)
/*     */           {
/* 161 */             MC2BMessageSchema rMC2BMessageSchema = new MC2BMessageSchema();
/*     */ 
/* 163 */             rMC2BMessageSchema.setID(ssrs2.GetText(i, 1));
/* 164 */             rMC2BMessageSet.add(rMC2BMessageSchema);
/*     */           }
/*     */         }
/*     */ 
/* 168 */         MMap mmap = new MMap();
/* 169 */         mmap.put(tMC2BMessageSet, "INSERT");
/* 170 */         mmap.put(rMC2BMessageSet, "DELETE");
/* 171 */         VData tVData = new VData();
/* 172 */         tVData.add(mmap);
/*     */ 
/* 174 */         PubSubmit tPubSubmit = new PubSubmit();
/* 175 */         tPubSubmit.submitData(tVData, "");
/*     */ 
/* 177 */         return true;
/*     */       }
/*     */ 
/* 182 */       return false;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 187 */       e.printStackTrace();
/* 188 */     }return false;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.batch.MonthStatement
 * JD-Core Version:    0.6.0
 */