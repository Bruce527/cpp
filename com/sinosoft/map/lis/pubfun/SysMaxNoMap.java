/*     */ package com.sinosoft.map.lis.pubfun;
/*     */ 
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConn;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.ExeSQL;
/*     */ import java.io.PrintStream;
/*     */ import java.math.BigInteger;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ public class SysMaxNoMap
/*     */ {
/*     */   private String noType;
/*     */   private int noLength;
/*     */   private int step;
/*  17 */   private String[] maxNos = null;
/*     */ 
/*  19 */   private int index = 0;
/*     */ 
/*  21 */   private int tryTimes = 0;
/*     */ 
/*     */   public SysMaxNoMap(String noType, int noLength) {
/*  24 */     this(noType, noLength, 10);
/*     */   }
/*     */ 
/*     */   public SysMaxNoMap(String noType, int noLength, int step)
/*     */   {
/*  29 */     if ((noType == null) || (noType.trim().equals(""))) {
/*  30 */       throw new RuntimeException("MaxNoFactory\u7684\u6784\u9020\u5668\u53EA\u63A5\u53D7\u6709\u610F\u4E49\u7684noType,\u76EE\u524D\u4F20\u5165\u7684\u53C2\u6570noType=" + noType);
/*     */     }
/*  32 */     if (step <= 0) {
/*  33 */       throw new RuntimeException("MaxNoFactory\u7684\u6784\u9020\u5668\u53EA\u63A5\u53D7step\u5927\u4E8E0\u7684\u53C2\u6570,\u76EE\u524D\u4F20\u5165\u7684\u53C2\u6570step=" + step);
/*     */     }
/*  35 */     if (noLength < 10) {
/*  36 */       throw new RuntimeException("MaxNoFactory\u7684\u6784\u9020\u5668\u53EA\u63A5\u53D7noLength\u5927\u4E8E10\u7684\u53C2\u6570,\u76EE\u524D\u4F20\u5165\u7684\u53C2\u6570noLength=" + noLength);
/*     */     }
/*  38 */     this.noType = noType.toUpperCase();
/*  39 */     this.noLength = noLength;
/*  40 */     this.step = step;
/*  41 */     this.maxNos = new String[step];
/*  42 */     initMaxNos();
/*     */   }
/*     */ 
/*     */   private void initMaxNos() {
/*  46 */     if (this.maxNos == null) {
/*  47 */       this.maxNos = new String[this.step];
/*     */     }
/*  49 */     for (int i = 0; i < this.step; i++) {
/*  50 */       this.maxNos[i] = "-1";
/*     */     }
/*  52 */     this.index = 0;
/*     */   }
/*     */ 
/*     */   public String next() {
/*  56 */     String result = null;
/*     */ 
/*  58 */     if ((this.index < this.step) && (!this.maxNos[this.index].equals("-1")))
/*     */     {
/*  60 */       System.out.println("\u4ECE\u7F13\u5B58\u4E2D\u8BFB\u53D6\u6700\u5927\u503C");
/*  61 */       return PubFun.LCh(nextData(), "0", this.noLength);
/*     */     }
/*  63 */     DBConn conn = DBConnPool.getConnection();
/*     */     try {
/*  65 */       result = next(conn);
/*     */     } catch (Exception e) {
/*  67 */       e.printStackTrace();
/*     */       try
/*     */       {
/*  70 */         conn.close();
/*     */       } catch (SQLException e) {
/*  72 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*     */       try
/*     */       {
/*  70 */         conn.close();
/*     */       } catch (SQLException e) {
/*  72 */         e.printStackTrace();
/*     */       }
/*     */     }
/*  75 */     return result;
/*     */   }
/*     */ 
/*     */   public String next(DBConn conn)
/*     */   {
/*  81 */     StringBuffer maxStr = new StringBuffer();
/*  82 */     for (int i = 0; i < this.noLength; i++) {
/*  83 */       maxStr.append("9");
/*     */     }
/*  85 */     String tmp = nextInt(conn);
/*  86 */     if (tmp.equals("")) {
/*  87 */       return "";
/*     */     }
/*  89 */     if (new BigInteger(tmp).compareTo(new BigInteger(maxStr.toString())) > 0) {
/*  90 */       throw new RuntimeException("\u4ECE\u6570\u636E\u5E93\u4E2D\u8BFB\u51FA\u7684MaxNo=" + tmp + "\u5927\u4E8E\u4F20\u5165\u7684\u53C2\u6570noLength=" + this.noLength + "\u6307\u5B9A\u7684\u8303\u56F4");
/*     */     }
/*  92 */     return PubFun.LCh(tmp, "0", this.noLength);
/*     */   }
/*     */ 
/*     */   private String nextInt(DBConn conn) {
/*  96 */     String cNoLimit = "SN";
/*  97 */     if ((this.index < this.step) && (!this.maxNos[this.index].equals("-1")))
/*     */     {
/* 100 */       return nextData();
/*     */     }
/*     */ 
/* 104 */     initMaxNos();
/*     */     try
/*     */     {
/* 107 */       conn.setAutoCommit(false);
/*     */     }
/*     */     catch (SQLException e1) {
/* 110 */       e1.printStackTrace();
/*     */     }
/* 112 */     String result = queryDB(conn, cNoLimit);
/* 113 */     if (result == null) {
/* 114 */       System.out.println("CreateMaxNo \u67E5\u8BE2\u5931\u8D25!");
/* 115 */       return "";
/*     */     }
/*     */ 
/* 118 */     if (result.trim().equals(""))
/*     */     {
/* 120 */       if (insertDB(conn, cNoLimit)) {
/*     */         try {
/* 122 */           conn.commit();
/*     */         } catch (SQLException e) {
/* 124 */           e.printStackTrace();
/* 125 */           return "";
/*     */         }
/* 127 */         comData("0");
/* 128 */         return nextData();
/*     */       }
/* 130 */       System.out.println("CreateMaxNo \u63D2\u5165\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5!");
/*     */       try {
/* 132 */         conn.rollback();
/*     */       } catch (SQLException e) {
/* 134 */         e.printStackTrace();
/*     */       }
/* 136 */       return "";
/*     */     }
/*     */ 
/* 140 */     if (updateDB(conn, cNoLimit, result)) {
/*     */       try {
/* 142 */         conn.commit();
/*     */       } catch (SQLException e) {
/* 144 */         e.printStackTrace();
/* 145 */         return "";
/*     */       }
/*     */ 
/* 148 */       this.tryTimes = 0;
/* 149 */       comData(result);
/* 150 */       return nextData();
/*     */     }
/* 152 */     this.tryTimes += 1;
/* 153 */     if (this.tryTimes > 5) {
/* 154 */       this.tryTimes = 0;
/* 155 */       System.out.println("5\u5C1D\u8BD5\u4FEE\u6539mmaxno\u8868\u5747\u5931\u8D25\uFF0C\u4E0D\u518D\u5C1D\u8BD5");
/*     */       try {
/* 157 */         conn.rollback();
/*     */       } catch (SQLException e) {
/* 159 */         e.printStackTrace();
/*     */       }
/* 161 */       return "";
/*     */     }
/* 163 */     System.out.println("\u7B2C" + this.tryTimes + "\u5C1D\u8BD5\u4FEE\u6539mmaxno\u8868\u5931\u8D25");
/* 164 */     return nextInt(conn);
/*     */   }
/*     */ 
/*     */   private String queryDB(DBConn conn, String cNoLimit)
/*     */   {
/* 173 */     StringBuffer sql = new StringBuffer();
/* 174 */     sql.append("select maxno from mmaxno where notype='");
/* 175 */     sql.append(this.noType);
/* 176 */     sql.append("' and nolimit='");
/* 177 */     sql.append(cNoLimit);
/* 178 */     sql.append("'");
/* 179 */     ExeSQL exeSQL = new ExeSQL(conn);
/* 180 */     String result = exeSQL.getOneValue(sql.toString());
/* 181 */     sql = null;
/*     */ 
/* 183 */     if (exeSQL.mErrors.needDealError()) {
/* 184 */       System.out.println("CreateMaxNo \u67E5\u8BE2\u5931\u8D25!");
/* 185 */       return null;
/*     */     }
/* 187 */     if ((result == null) || (result.trim().equals(""))) {
/* 188 */       return "";
/*     */     }
/* 190 */     return result;
/*     */   }
/*     */ 
/*     */   private boolean updateDB(DBConn conn, String cNoLimit, String result)
/*     */   {
/* 195 */     StringBuffer tSBql = new StringBuffer(128);
/* 196 */     tSBql.append("update mmaxno set maxno = maxno + ");
/* 197 */     tSBql.append(this.step);
/* 198 */     tSBql.append(" where notype = '");
/* 199 */     tSBql.append(this.noType);
/* 200 */     tSBql.append("' and nolimit = '");
/* 201 */     tSBql.append(cNoLimit);
/* 202 */     tSBql.append("' and maxno=");
/* 203 */     tSBql.append(result);
/*     */ 
/* 205 */     ExeSQL exeSQL = new ExeSQL(conn);
/* 206 */     if (!exeSQL.execUpdateSQL(tSBql.toString())) {
/* 207 */       return false;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 212 */       conn.commit();
/*     */     } catch (SQLException e) {
/* 214 */       e.printStackTrace();
/* 215 */       return false;
/*     */     }
/* 217 */     for (int i = 0; i < this.step; i++) {
/* 218 */       this.maxNos[i] = new BigInteger(result).add(
/* 219 */         new BigInteger(String.valueOf(i))).toString();
/*     */     }
/* 221 */     return true;
/*     */   }
/*     */ 
/*     */   private boolean insertDB(DBConn conn, String cNoLimit)
/*     */   {
/* 226 */     StringBuffer tSBql = new StringBuffer(128);
/* 227 */     tSBql.append("insert into mmaxno(notype, nolimit, maxno) values('");
/* 228 */     tSBql.append(this.noType);
/* 229 */     tSBql.append("', '");
/* 230 */     tSBql.append(cNoLimit);
/* 231 */     tSBql.append("', ");
/* 232 */     tSBql.append(this.step);
/* 233 */     tSBql.append(")");
/*     */ 
/* 235 */     ExeSQL exeSQL = new ExeSQL(conn);
/*     */ 
/* 237 */     return exeSQL.execUpdateSQL(tSBql.toString());
/*     */   }
/*     */ 
/*     */   private String nextData()
/*     */   {
/* 244 */     return this.maxNos[(this.index++)];
/*     */   }
/*     */ 
/*     */   private void comData(String result) {
/* 248 */     this.index = 0;
/* 249 */     for (int i = 0; i < this.step; i++)
/* 250 */       this.maxNos[i] = new BigInteger(result).add(
/* 251 */         new BigInteger(String.valueOf(i + 1))).toString();
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */     throws SQLException
/*     */   {
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.pubfun.SysMaxNoMap
 * JD-Core Version:    0.6.0
 */