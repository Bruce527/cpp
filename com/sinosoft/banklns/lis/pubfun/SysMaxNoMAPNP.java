/*     */ package com.sinosoft.banklns.lis.pubfun;
/*     */ 
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.ExeSQL;
/*     */ import com.sinosoft.banklns.utility.VData;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ public class SysMaxNoMAPNP
/*     */   implements SysMaxNo
/*     */ {
/*     */   public String CreateMaxNo(String cNoType, String cNoLimit, VData cVData)
/*     */   {
/*  25 */     return CreateMaxNo(cNoType, cNoLimit);
/*     */   }
/*     */ 
/*     */   public String CreateMaxNo(String cNoType, String cNoLimit) {
/*  29 */     if ((cNoType == null) || (cNoType.trim().length() <= 0) || 
/*  30 */       (cNoLimit == null))
/*     */     {
/*  32 */       System.out.println("NoType\u957F\u5EA6\u9519\u8BEF\u6216\u8005NoLimit\u4E3A\u7A7A");
/*     */ 
/*  34 */       return null;
/*     */     }
/*     */ 
/*  37 */     int serialLen = 20;
/*  38 */     String tReturn = null;
/*  39 */     cNoType = cNoType.toUpperCase();
/*     */ 
/*  41 */     tReturn = cNoLimit.trim();
/*     */ 
/*  44 */     Connection conn = null;
/*     */     try {
/*  46 */       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
/*     */     }
/*     */     catch (ClassNotFoundException e1) {
/*  49 */       e1.printStackTrace();
/*  50 */       return null;
/*     */     }
/*     */ 
/*  54 */     if (conn == null) {
/*     */       try {
/*  56 */         conn = DriverManager.getConnection("jdbc:sqlserver://10.164.4.48\\SQLEXPRESS:1433;databasename=MDES", "edifierg", "edifierg");
/*     */       }
/*     */       catch (SQLException e1) {
/*  59 */         e1.printStackTrace();
/*  60 */         CError.buildErr(this, "\u6570\u636E\u5E93\u8FDE\u63A5\u5931\u8D25");
/*  61 */         return null;
/*     */       }
/*     */     }
/*  64 */     if (conn == null)
/*     */     {
/*  66 */       System.out.println("CreateMaxNo : fail to get db connection");
/*  67 */       return tReturn;
/*     */     }
/*     */ 
/*  70 */     int tMaxNo = 0;
/*     */     try
/*     */     {
/*  75 */       conn.setAutoCommit(false);
/*  76 */       StringBuffer tSBql = new StringBuffer(128);
/*  77 */       tSBql.append("select MaxNo from LNPMaxNo where notype='");
/*  78 */       tSBql.append(cNoType);
/*  79 */       tSBql.append("' and nolimit='");
/*  80 */       tSBql.append(cNoLimit);
/*  81 */       tSBql.append("' ");
/*     */ 
/*  83 */       ExeSQL exeSQL = new ExeSQL(conn);
/*  84 */       String result = null;
/*  85 */       result = exeSQL.getOneValue(tSBql.toString());
/*     */ 
/*  87 */       if (exeSQL.mErrors.needDealError())
/*     */       {
/*  89 */         System.out.println("\u67E5\u8BE2LNPMaxNo\u51FA\u9519\uFF0C\u8BF7\u7A0D\u540E!");
/*  90 */         conn.rollback();
/*  91 */         conn.close();
/*     */ 
/*  93 */         return null;
/*     */       }
/*     */ 
/*  96 */       if ((result == null) || (result.equals("")))
/*     */       {
/*  98 */         tSBql = new StringBuffer(128);
/*  99 */         tSBql.append("insert into lnpmaxno(notype, nolimit, maxno) values('");
/* 100 */         tSBql.append(cNoType);
/* 101 */         tSBql.append("', '");
/* 102 */         tSBql.append(cNoLimit);
/* 103 */         tSBql.append("', 1)");
/*     */ 
/* 105 */         exeSQL = new ExeSQL(conn);
/* 106 */         if (!exeSQL.execUpdateSQL(tSBql.toString()))
/*     */         {
/* 108 */           System.out.println("CreateMaxNo \u63D2\u5165\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5!");
/* 109 */           conn.rollback();
/* 110 */           conn.close();
/*     */ 
/* 112 */           return null;
/*     */         }
/*     */ 
/* 116 */         tMaxNo = 1;
/*     */       }
/*     */       else
/*     */       {
/* 121 */         tSBql = new StringBuffer(128);
/* 122 */         tSBql.append("update lnpmaxno set maxno = maxno + 1 where notype = '");
/* 123 */         tSBql.append(cNoType);
/* 124 */         tSBql.append("' and nolimit = '");
/* 125 */         tSBql.append(cNoLimit);
/* 126 */         tSBql.append("'");
/*     */ 
/* 128 */         exeSQL = new ExeSQL(conn);
/* 129 */         if (!exeSQL.execUpdateSQL(tSBql.toString()))
/*     */         {
/* 131 */           System.out.println("CreateMaxNo \u66F4\u65B0\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5!");
/* 132 */           conn.rollback();
/* 133 */           conn.close();
/*     */ 
/* 135 */           return null;
/*     */         }
/*     */ 
/* 139 */         tMaxNo = Integer.parseInt(result) + 1;
/*     */       }
/*     */ 
/* 143 */       conn.commit();
/* 144 */       conn.close();
/*     */     }
/*     */     catch (Exception Ex)
/*     */     {
/*     */       try
/*     */       {
/* 150 */         conn.rollback();
/* 151 */         conn.close();
/*     */ 
/* 153 */         return null;
/*     */       }
/*     */       catch (Exception e1)
/*     */       {
/* 157 */         e1.printStackTrace();
/*     */ 
/* 159 */         return null;
/*     */       }
/*     */     }
/*     */ 
/* 163 */     String tStr = String.valueOf(tMaxNo);
/* 164 */     tStr = PubFun.LCh(tStr, "0", serialLen);
/*     */ 
/* 166 */     tReturn = tStr;
/* 167 */     return tReturn;
/*     */   }
/*     */ 
/*     */   public String CreateMaxNo1(Connection conn, String cNoType, String cNoLimit)
/*     */   {
/* 173 */     if ((cNoType == null) || (cNoType.trim().length() <= 0) || 
/* 174 */       (cNoLimit == null))
/*     */     {
/* 176 */       System.out.println("NoType\u957F\u5EA6\u9519\u8BEF\u6216\u8005NoLimit\u4E3A\u7A7A");
/*     */ 
/* 178 */       return null;
/*     */     }
/*     */ 
/* 181 */     int serialLen = 20;
/* 182 */     String tReturn = null;
/* 183 */     cNoType = cNoType.toUpperCase();
/*     */ 
/* 185 */     tReturn = cNoLimit.trim();
/*     */ 
/* 189 */     int tMaxNo = 0;
/*     */     try
/*     */     {
/* 195 */       StringBuffer tSBql = new StringBuffer(128);
/* 196 */       tSBql.append("select MaxNo from LNPMaxNo where notype='");
/* 197 */       tSBql.append(cNoType);
/* 198 */       tSBql.append("' and nolimit='");
/* 199 */       tSBql.append(cNoLimit);
/* 200 */       tSBql.append("' ");
/*     */ 
/* 202 */       ExeSQL exeSQL = new ExeSQL(conn);
/* 203 */       String result = null;
/* 204 */       result = exeSQL.getOneValue(tSBql.toString());
/*     */ 
/* 206 */       if (exeSQL.mErrors.needDealError())
/*     */       {
/* 208 */         System.out.println("\u67E5\u8BE2LNPMaxNo\u51FA\u9519\uFF0C\u8BF7\u7A0D\u540E!");
/*     */ 
/* 211 */         return null;
/*     */       }
/*     */ 
/* 214 */       if ((result == null) || (result.equals("")))
/*     */       {
/* 216 */         tSBql = new StringBuffer(128);
/* 217 */         tSBql.append("insert into lnpmaxno(notype, nolimit, maxno) values('");
/* 218 */         tSBql.append(cNoType);
/* 219 */         tSBql.append("', '");
/* 220 */         tSBql.append(cNoLimit);
/* 221 */         tSBql.append("', 1)");
/*     */ 
/* 223 */         exeSQL = new ExeSQL(conn);
/* 224 */         if (!exeSQL.execUpdateSQL(tSBql.toString()))
/*     */         {
/* 226 */           System.out.println("CreateMaxNo \u63D2\u5165\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5!");
/*     */ 
/* 229 */           return null;
/*     */         }
/*     */ 
/* 233 */         tMaxNo = 1;
/*     */       }
/*     */       else
/*     */       {
/* 238 */         tSBql = new StringBuffer(128);
/* 239 */         tSBql.append("update lnpmaxno set maxno = maxno + 1 where notype = '");
/* 240 */         tSBql.append(cNoType);
/* 241 */         tSBql.append("' and nolimit = '");
/* 242 */         tSBql.append(cNoLimit);
/* 243 */         tSBql.append("'");
/*     */ 
/* 245 */         exeSQL = new ExeSQL(conn);
/* 246 */         if (!exeSQL.execUpdateSQL(tSBql.toString()))
/*     */         {
/* 248 */           System.out.println("CreateMaxNo \u66F4\u65B0\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5!");
/*     */ 
/* 251 */           return null;
/*     */         }
/*     */ 
/* 255 */         tMaxNo = Integer.parseInt(result) + 1;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception Ex)
/*     */     {
/*     */       try
/*     */       {
/* 266 */         conn.rollback();
/* 267 */         return null;
/*     */       }
/*     */       catch (Exception e1)
/*     */       {
/* 271 */         e1.printStackTrace();
/*     */ 
/* 275 */         return null;
/*     */       }
/*     */     }
/* 278 */     String tStr = String.valueOf(tMaxNo);
/* 279 */     tStr = PubFun.LCh(tStr, "0", serialLen);
/*     */ 
/* 281 */     tReturn = tStr;
/* 282 */     return tReturn;
/*     */   }
/*     */ 
/*     */   public String CreateMaxNo(String cNoType, int cNoLength)
/*     */   {
/* 287 */     StringBuffer tSBql = null;
/* 288 */     if ((cNoType == null) || (cNoType.trim().length() <= 0) || 
/* 289 */       (cNoLength <= 0))
/*     */     {
/* 291 */       System.out.println("NoType\u957F\u5EA6\u9519\u8BEF\u6216NoLength\u9519\u8BEF");
/* 292 */       return null;
/*     */     }
/*     */ 
/* 295 */     cNoType = cNoType.toUpperCase();
/*     */ 
/* 297 */     Connection conn = DBConnPool.getConnection();
/* 298 */     if (conn == null)
/*     */     {
/* 300 */       System.out.println("CreateMaxNo : fail to get db connection");
/* 301 */       return null;
/*     */     }
/*     */ 
/* 304 */     String tReturn = "";
/* 305 */     String cNoLimit = "SN";
/*     */ 
/* 307 */     if ((cNoType.equals("COMMISIONSN")) || 
/* 308 */       (cNoType.equals("GRPNO")) || (cNoType.equals("CUSTOMERNO")) || 
/* 309 */       (cNoType.equals("SUGDATAITEMCODE")) || 
/* 310 */       (cNoType.equals("SUGITEMCODE")) || 
/* 311 */       (cNoType.equals("SUGMODELCODE")) || 
/* 312 */       (cNoType.equals("SUGCODE")))
/*     */     {
/* 314 */       tSBql = new StringBuffer(128);
/* 315 */       tSBql.append("\u8BE5\u7C7B\u578B\u6D41\u6C34\u53F7\uFF0C\u8BF7\u91C7\u7528CreateMaxNo('");
/* 316 */       tSBql.append(cNoType);
/* 317 */       tSBql.append("','SN')\u65B9\u5F0F\u751F\u6210");
/* 318 */       System.out.println(tSBql.toString());
/* 319 */       return null;
/*     */     }
/* 321 */     int tMaxNo = 0;
/* 322 */     tReturn = cNoLimit;
/*     */     try
/*     */     {
/* 326 */       conn.setAutoCommit(false);
/*     */ 
/* 328 */       tSBql = new StringBuffer(128);
/* 329 */       tSBql.append("select MaxNo from LDMaxNo where notype='");
/* 330 */       tSBql.append(cNoType);
/* 331 */       tSBql.append("' and nolimit='");
/* 332 */       tSBql.append(cNoLimit);
/* 333 */       tSBql.append("' for update");
/*     */ 
/* 335 */       ExeSQL exeSQL = new ExeSQL(conn);
/* 336 */       String result = null;
/* 337 */       result = exeSQL.getOneValue(tSBql.toString());
/*     */ 
/* 339 */       if ((result == null) || (exeSQL.mErrors.needDealError()))
/*     */       {
/* 341 */         System.out.println("CreateMaxNo \u8D44\u6E90\u5FD9\uFF0C\u8BF7\u7A0D\u540E!");
/* 342 */         conn.rollback();
/* 343 */         conn.close();
/*     */ 
/* 345 */         return null;
/*     */       }
/*     */ 
/* 348 */       if (result.equals(""))
/*     */       {
/* 350 */         tSBql = new StringBuffer(128);
/* 351 */         tSBql.append("insert into ldmaxno(notype, nolimit, maxno) values('");
/* 352 */         tSBql.append(cNoType);
/* 353 */         tSBql.append("', '");
/* 354 */         tSBql.append(cNoLimit);
/* 355 */         tSBql.append("', 1)");
/*     */ 
/* 357 */         exeSQL = new ExeSQL(conn);
/* 358 */         if (!exeSQL.execUpdateSQL(tSBql.toString()))
/*     */         {
/* 360 */           System.out.println("CreateMaxNo \u63D2\u5165\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5!");
/* 361 */           conn.rollback();
/* 362 */           conn.close();
/*     */ 
/* 364 */           return null;
/*     */         }
/*     */ 
/* 368 */         tMaxNo = 1;
/*     */       }
/*     */       else
/*     */       {
/* 373 */         tSBql = new StringBuffer(128);
/* 374 */         tSBql.append("update ldmaxno set maxno = maxno + 1 where notype = '");
/* 375 */         tSBql.append(cNoType);
/* 376 */         tSBql.append("' and nolimit = '");
/* 377 */         tSBql.append(cNoLimit);
/* 378 */         tSBql.append("'");
/*     */ 
/* 380 */         exeSQL = new ExeSQL(conn);
/* 381 */         if (!exeSQL.execUpdateSQL(tSBql.toString()))
/*     */         {
/* 383 */           System.out.println("CreateMaxNo \u66F4\u65B0\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5!");
/* 384 */           conn.rollback();
/* 385 */           conn.close();
/*     */ 
/* 387 */           return null;
/*     */         }
/*     */ 
/* 391 */         tMaxNo = Integer.parseInt(result) + 1;
/*     */       }
/*     */ 
/* 395 */       conn.commit();
/* 396 */       conn.close();
/*     */     }
/*     */     catch (Exception Ex)
/*     */     {
/*     */       try
/*     */       {
/* 402 */         conn.rollback();
/* 403 */         conn.close();
/*     */ 
/* 405 */         return null;
/*     */       }
/*     */       catch (Exception e1)
/*     */       {
/* 409 */         e1.printStackTrace();
/* 410 */         return null;
/*     */       }
/*     */     }
/*     */ 
/* 414 */     String tStr = String.valueOf(tMaxNo);
/* 415 */     tStr = PubFun.LCh(tStr, "0", cNoLength);
/* 416 */     tReturn = tStr.trim();
/*     */ 
/* 418 */     return tReturn;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 423 */     SysMaxNoMAPNP sysMaxNoHuaXia1 = new SysMaxNoMAPNP();
/* 424 */     System.out.println(sysMaxNoHuaXia1.CreateMaxNo("CONTNO", "86"));
/* 425 */     System.out.println(sysMaxNoHuaXia1.CreateMaxNo("CUSTOMERNO", "SN"));
/* 426 */     System.out.println(sysMaxNoHuaXia1.CreateMaxNo("GRPNO", "SN"));
/* 427 */     System.out.println(sysMaxNoHuaXia1.CreateMaxNo("TESTNO", 10));
/* 428 */     System.out.println(sysMaxNoHuaXia1.CreateMaxNo("SPNO_TJ", "SYS_PRT"));
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.pubfun.SysMaxNoMAPNP
 * JD-Core Version:    0.6.0
 */