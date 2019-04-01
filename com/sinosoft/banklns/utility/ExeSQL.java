/*     */ package com.sinosoft.banklns.utility;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.pubfun.FDate;
/*     */ import com.sinosoft.banklns.lis.pubfun.PubFun;
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ 
/*     */ public class ExeSQL
/*     */ {
/*     */   private Connection con;
/*  20 */   private boolean mflag = false;
/*     */ 
/*  22 */   private FDate fDate = new FDate();
/*     */ 
/*  24 */   public CErrors mErrors = new CErrors();
/*     */ 
/*     */   public ExeSQL(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public ExeSQL()
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getOneValue(String sql)
/*     */   {
/*  38 */     PreparedStatement pstmt = null;
/*  39 */     ResultSet rs = null;
/*  40 */     String mValue = "";
/*  41 */     if (!this.mflag) {
/*  42 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */     try
/*     */     {
/*  46 */       pstmt = this.con.prepareStatement(StrTool.GBKToUnicode(sql), 
/*  47 */         1003, 1007);
/*  48 */       rs = pstmt.executeQuery();
/*     */ 
/*  50 */       if (rs.next()) {
/*  51 */         mValue = rs.getString(1);
/*     */       }
/*     */ 
/*  55 */       if (!this.mflag)
/*  56 */         this.con.close();
/*     */     }
/*     */     catch (SQLException e) {
/*  59 */       System.out.println("### Error ExeSQL at exeSQL1: " + sql);
/*  60 */       e.printStackTrace();
/*     */ 
/*  65 */       CError.buildErr(this, e.toString());
/*     */ 
/*  67 */       mValue = null;
/*     */       try
/*     */       {
/*  71 */         if (rs != null) {
/*  72 */           rs.close();
/*     */         }
/*  74 */         if (pstmt != null) {
/*  75 */           pstmt.close();
/*     */         }
/*     */ 
/*  78 */         if (!this.mflag) {
/*  79 */           this.con.close();
/*     */         }
/*     */       }
/*     */       catch (SQLException localSQLException1)
/*     */       {
/*     */       }
/*     */     }
/*  86 */     if (!this.mflag)
/*     */       try {
/*  88 */         this.con.close();
/*     */       }
/*     */       catch (SQLException localSQLException2)
/*     */       {
/*     */       }
/*  93 */     return StrTool.cTrim(mValue);
/*     */   }
/*     */ 
/*     */   private int getResultCount(String sql, PreparedStatement pstmt, ResultSet rs)
/*     */   {
/*  98 */     int iCount = 0;
/*     */ 
/* 101 */     sql = "select count(1) from (" + sql + ") rsc";
/*     */     try {
/* 103 */       pstmt = this.con.prepareStatement(StrTool.GBKToUnicode(sql), 
/* 104 */         1003, 1007);
/* 105 */       rs = pstmt.executeQuery();
/* 106 */       rs.next();
/*     */ 
/* 108 */       iCount = rs.getInt(1);
/* 109 */       rs.close();
/* 110 */       pstmt.close();
/*     */     } catch (SQLException e) {
/* 112 */       e.printStackTrace();
/*     */ 
/* 116 */       CError.buildErr(this, e.toString());
/* 117 */       iCount = -1;
/*     */       try {
/* 119 */         rs.close();
/* 120 */         pstmt.close();
/* 121 */         if (!this.mflag)
/* 122 */           this.con.close();
/*     */       }
/*     */       catch (SQLException localSQLException1) {
/*     */       }
/*     */     }
/* 127 */     return iCount;
/*     */   }
/*     */ 
/*     */   public String getEncodedResult(String sql, int start)
/*     */   {
/* 132 */     PreparedStatement pstmt = null;
/* 133 */     ResultSet rs = null;
/* 134 */     ResultSetMetaData rsmd = null;
/* 135 */     StringBuffer mResult = new StringBuffer(256);
/*     */ 
/* 140 */     if (start <= 0) {
/* 141 */       start = 1;
/*     */     }
/*     */ 
/* 145 */     if (!this.mflag) {
/* 146 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */     try
/*     */     {
/* 150 */       pstmt = this.con.prepareStatement(StrTool.GBKToUnicode(sql), 
/* 151 */         1003, 1007);
/*     */ 
/* 154 */       rs = pstmt.executeQuery();
/* 155 */       rsmd = rs.getMetaData();
/* 156 */       int n = rsmd.getColumnCount();
/* 157 */       int m = start + 200;
/*     */ 
/* 160 */       int k = 0;
/* 161 */       while (rs.next()) {
/* 162 */         k++;
/* 163 */         if ((k < start) || (k >= m))
/*     */           continue;
/* 165 */         for (int j = 1; j <= n; j++) {
/* 166 */           if (j == 1)
/* 167 */             mResult.append(getDataValue(rsmd, rs, j));
/*     */           else {
/* 169 */             mResult.append("|" + 
/* 170 */               getDataValue(rsmd, rs, j));
/*     */           }
/*     */         }
/* 173 */         mResult.append("^");
/*     */       }
/*     */ 
/* 177 */       if (k >= start)
/*     */       {
/* 182 */         mResult.insert(0, "0|" + String.valueOf(k) + 
/* 183 */           "^");
/* 184 */         mResult.delete(mResult.length() - 1, mResult.length());
/*     */       } else {
/* 186 */         mResult.append("100|\u672A\u951F\u65A4\u62F7\u8BE2\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7!");
/*     */       }
/* 188 */       rs.close();
/* 189 */       pstmt.close();
/* 190 */       if (!this.mflag)
/* 191 */         this.con.close();
/*     */     }
/*     */     catch (SQLException e) {
/* 194 */       System.out.println("### Error ExeSQL at Encode2: " + sql);
/* 195 */       e.printStackTrace();
/*     */ 
/* 199 */       CError.buildErr(this, e.toString());
/* 200 */       mResult.setLength(0);
/*     */       try {
/* 202 */         if (rs != null) {
/* 203 */           rs.close();
/*     */         }
/* 205 */         if (pstmt != null) {
/* 206 */           pstmt.close();
/*     */         }
/* 208 */         if (!this.mflag)
/* 209 */           this.con.close();
/*     */       }
/*     */       catch (SQLException localSQLException1)
/*     */       {
/*     */       }
/*     */     }
/* 215 */     if (!this.mflag)
/*     */       try {
/* 217 */         this.con.close();
/*     */       }
/*     */       catch (SQLException localSQLException2) {
/*     */       }
/* 221 */     return mResult.toString();
/*     */   }
/*     */ 
/*     */   public String getEncodedResultLarge(String sql, int start)
/*     */   {
/* 226 */     PreparedStatement pstmt = null;
/* 227 */     ResultSet rs = null;
/* 228 */     ResultSetMetaData rsmd = null;
/* 229 */     StringBuffer mResult = new StringBuffer(256);
/*     */ 
/* 232 */     if (start <= 0) {
/* 233 */       start = 1;
/*     */     }
/*     */ 
/* 237 */     if (!this.mflag) {
/* 238 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/* 242 */     int iCount = getResultCount(sql, pstmt, rs);
/*     */ 
/* 244 */     if (iCount <= 0) {
/*     */       try {
/* 246 */         if (!this.mflag)
/* 247 */           this.con.close();
/*     */       }
/*     */       catch (SQLException localSQLException1) {
/*     */       }
/* 251 */       return "100|\u672A\u951F\u65A4\u62F7\u8BE2\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7!";
/*     */     }
/*     */     try
/*     */     {
/* 255 */       int m = start + 200;
/*     */ 
/* 258 */       StringBuffer tSBql = new StringBuffer();
/* 259 */       if ("SQLSERVER".equals("ORACLE")) {
/* 260 */         tSBql.append("select * from (select rownum rnm,rs.* from (");
/* 261 */         tSBql.append(sql);
/* 262 */         tSBql.append(") rs where rownum < ");
/* 263 */         tSBql.append(m);
/* 264 */         tSBql.append(") rss where rnm >= ");
/* 265 */         tSBql.append(start);
/*     */       } else {
/* 267 */         tSBql
/* 268 */           .append("select * from (select rownumber() OVER () rnm ,rs.* from (");
/* 269 */         tSBql.append(sql);
/* 270 */         tSBql.append(") rs) rss WHERE rnm BETWEEN ");
/* 271 */         tSBql.append(start);
/* 272 */         tSBql.append(" and ");
/* 273 */         tSBql.append(m - 1);
/*     */       }
/*     */ 
/* 278 */       pstmt = this.con.prepareStatement(
/* 279 */         StrTool.GBKToUnicode(tSBql.toString()), 
/* 280 */         1003, 1007);
/*     */ 
/* 283 */       rs = pstmt.executeQuery();
/* 284 */       rsmd = rs.getMetaData();
/* 285 */       int n = rsmd.getColumnCount();
/*     */ 
/* 288 */       int k = 0;
/* 289 */       while (rs.next()) {
/* 290 */         k++;
/*     */ 
/* 293 */         for (int j = 2; j <= n; j++) {
/* 294 */           if (j == 2)
/* 295 */             mResult.append(getDataValue(rsmd, rs, j));
/*     */           else {
/* 297 */             mResult.append("|" + 
/* 298 */               getDataValue(rsmd, rs, j));
/*     */           }
/*     */         }
/* 301 */         mResult.append("^");
/*     */       }
/*     */ 
/* 304 */       if (k > 0)
/*     */       {
/* 306 */         mResult.insert(0, "0|" + String.valueOf(iCount) + 
/* 307 */           "^");
/* 308 */         mResult.delete(mResult.length() - 1, mResult.length());
/*     */       } else {
/* 310 */         mResult.append("100|\u672A\u951F\u65A4\u62F7\u8BE2\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7!");
/*     */       }
/* 312 */       rs.close();
/* 313 */       pstmt.close();
/* 314 */       if (!this.mflag)
/* 315 */         this.con.close();
/*     */     }
/*     */     catch (SQLException e) {
/* 318 */       System.out.println("### Error ExeSQL at Encode2: " + sql);
/* 319 */       e.printStackTrace();
/*     */ 
/* 323 */       CError.buildErr(this, e.toString());
/* 324 */       mResult.setLength(0);
/*     */       try {
/* 326 */         if (rs != null) {
/* 327 */           rs.close();
/*     */         }
/* 329 */         if (pstmt != null) {
/* 330 */           pstmt.close();
/*     */         }
/* 332 */         if (!this.mflag)
/* 333 */           this.con.close();
/*     */       }
/*     */       catch (SQLException localSQLException2)
/*     */       {
/*     */       }
/*     */     }
/* 339 */     if (!this.mflag)
/*     */       try {
/* 341 */         this.con.close();
/*     */       }
/*     */       catch (SQLException localSQLException3) {
/*     */       }
/* 345 */     return mResult.toString();
/*     */   }
/*     */ 
/*     */   public String getEncodedResult(String sql) {
/* 349 */     PreparedStatement pstmt = null;
/* 350 */     ResultSet rs = null;
/* 351 */     ResultSetMetaData rsmd = null;
/* 352 */     StringBuffer mResult = new StringBuffer(256);
/*     */ 
/* 356 */     if (!this.mflag)
/* 357 */       this.con = DBConnPool.getConnection();
/*     */     try
/*     */     {
/* 360 */       pstmt = this.con.prepareStatement(StrTool.GBKToUnicode(sql), 
/* 361 */         1003, 1007);
/*     */ 
/* 363 */       pstmt.setFetchSize(500);
/* 364 */       rs = pstmt.executeQuery();
/* 365 */       rs.setFetchSize(500);
/* 366 */       rsmd = rs.getMetaData();
/* 367 */       int n = rsmd.getColumnCount();
/* 368 */       int k = 0;
/*     */ 
/* 370 */       while (rs.next()) {
/* 371 */         k++;
/* 372 */         for (int j = 1; j <= n; j++) {
/* 373 */           if (j == 1) {
/* 374 */             mResult.append(getDataValue(rsmd, rs, j));
/*     */           } else {
/* 376 */             mResult.append("|");
/* 377 */             mResult.append(getDataValue(rsmd, rs, j));
/*     */           }
/*     */         }
/* 380 */         mResult.append("^");
/*     */       }
/* 382 */       if (k > 0)
/*     */       {
/* 384 */         mResult.insert(0, "0|" + String.valueOf(k) + 
/* 385 */           "^");
/* 386 */         mResult.delete(mResult.length() - 1, mResult.length());
/*     */       } else {
/* 388 */         mResult.append("100|\u672A\u951F\u65A4\u62F7\u8BE2\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u6377\uFF4F\u62F7");
/*     */       }
/* 390 */       rs.close();
/* 391 */       pstmt.close();
/* 392 */       if (!this.mflag)
/* 393 */         this.con.close();
/*     */     }
/*     */     catch (SQLException e) {
/* 396 */       System.out.println("### Error ExeSQL at Encode1: " + sql);
/* 397 */       e.printStackTrace();
/*     */ 
/* 401 */       CError.buildErr(this, e.toString());
/* 402 */       mResult.setLength(0);
/*     */       try {
/* 404 */         if (rs != null) {
/* 405 */           rs.close();
/*     */         }
/* 407 */         if (pstmt != null) {
/* 408 */           pstmt.close();
/*     */         }
/* 410 */         if (!this.mflag)
/* 411 */           this.con.close();
/*     */       }
/*     */       catch (SQLException localSQLException1)
/*     */       {
/*     */       }
/*     */     }
/* 417 */     if (!this.mflag)
/*     */       try {
/* 419 */         this.con.close();
/*     */       }
/*     */       catch (SQLException localSQLException2) {
/*     */       }
/* 423 */     return mResult.toString();
/*     */   }
/*     */ 
/*     */   public String getEncodedResult(String sql, int start, int nCount)
/*     */   {
/* 428 */     PreparedStatement pstmt = null;
/* 429 */     ResultSet rs = null;
/* 430 */     ResultSetMetaData rsmd = null;
/* 431 */     StringBuffer mResult = new StringBuffer(256);
/*     */ 
/* 435 */     if (start <= 0) {
/* 436 */       start = 1;
/*     */     }
/* 438 */     if (nCount <= 0) {
/* 439 */       nCount = 1;
/*     */     }
/*     */ 
/* 442 */     if (!this.mflag) {
/* 443 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 449 */       pstmt = this.con.prepareStatement(StrTool.GBKToUnicode(sql), 
/* 450 */         1003, 1007);
/* 451 */       rs = pstmt.executeQuery();
/* 452 */       rsmd = rs.getMetaData();
/* 453 */       int n = rsmd.getColumnCount();
/* 454 */       int m = start + nCount;
/*     */ 
/* 456 */       int k = 0;
/* 457 */       while (rs.next()) {
/* 458 */         k++;
/*     */ 
/* 460 */         if (k >= m) {
/*     */           break;
/*     */         }
/* 463 */         if ((k < start) || (k >= m))
/*     */           continue;
/* 465 */         for (int j = 1; j <= n; j++) {
/* 466 */           if (j == 1)
/* 467 */             mResult.append(getDataValue(rsmd, rs, j));
/*     */           else {
/* 469 */             mResult.append("|").append(
/* 470 */               getDataValue(rsmd, rs, j));
/*     */           }
/*     */         }
/* 473 */         mResult.append("^");
/*     */       }
/*     */ 
/* 477 */       if (k >= start)
/*     */       {
/* 479 */         mResult.insert(0, "0|" + String.valueOf(k) + 
/* 480 */           "^");
/* 481 */         mResult.delete(mResult.length() - 1, mResult.length());
/*     */       } else {
/* 483 */         mResult.append("100|\u672A\u951F\u65A4\u62F7\u8BE2\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u6377\uFF4F\u62F7");
/*     */       }
/* 485 */       rs.close();
/* 486 */       pstmt.close();
/* 487 */       if (!this.mflag)
/* 488 */         this.con.close();
/*     */     }
/*     */     catch (SQLException e) {
/* 491 */       System.out.println("### Error ExeSQL at Encode3: " + sql);
/* 492 */       e.printStackTrace();
/*     */ 
/* 496 */       CError.buildErr(this, e.toString());
/* 497 */       mResult.setLength(0);
/*     */       try {
/* 499 */         if (rs != null) {
/* 500 */           rs.close();
/*     */         }
/* 502 */         if (pstmt != null) {
/* 503 */           pstmt.close();
/*     */         }
/* 505 */         if (!this.mflag)
/* 506 */           this.con.close();
/*     */       }
/*     */       catch (SQLException localSQLException1)
/*     */       {
/*     */       }
/*     */     }
/* 512 */     if (!this.mflag)
/*     */       try {
/* 514 */         this.con.close();
/*     */       }
/*     */       catch (SQLException localSQLException2) {
/*     */       }
/* 518 */     return mResult.toString();
/*     */   }
/*     */ 
/*     */   public String getDataValue(ResultSetMetaData rsmd, ResultSet rs, int i)
/*     */   {
/* 523 */     String strValue = "";
/*     */     try
/*     */     {
/* 526 */       int dataType = rsmd.getColumnType(i);
/* 527 */       int dataScale = rsmd.getScale(i);
/* 528 */       int dataPrecision = rsmd.getPrecision(i);
/*     */ 
/* 531 */       if ((dataType == 1) || (dataType == 12)) {
/* 532 */         strValue = StrTool.unicodeToGBK(rs.getString(i));
/*     */       }
/* 536 */       else if ((dataType == 93) || (dataType == 91))
/*     */       {
/* 538 */         strValue = rs.getString(i);
/* 539 */         if ((strValue != null) && (strValue.length() > 10)) {
/* 540 */           strValue = strValue.substring(0, 19);
/*     */         }
/*     */ 
/*     */       }
/* 544 */       else if ((dataType == 3) || (dataType == 6) || 
/* 545 */         (dataType == 7))
/*     */       {
/* 548 */         strValue = String.valueOf(rs.getBigDecimal(i));
/*     */ 
/* 550 */         strValue = PubFun.getInt(strValue);
/*     */       }
/* 553 */       else if (dataType == 8) {
/* 554 */         strValue = String.valueOf(rs.getDouble(i));
/* 555 */         strValue = PubFun.getInt(strValue);
/*     */       }
/* 559 */       else if ((dataType == 4) || 
/* 560 */         (dataType == 5)) {
/* 561 */         strValue = String.valueOf(rs.getInt(i));
/* 562 */         strValue = PubFun.getInt(strValue);
/*     */       }
/* 566 */       else if (dataType == 2) {
/* 567 */         if (dataScale == 0) {
/* 568 */           if (dataPrecision == 0)
/*     */           {
/* 571 */             strValue = String.valueOf(rs.getBigDecimal(i));
/*     */           }
/* 573 */           else strValue = String.valueOf(rs.getLong(i));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 578 */           strValue = String.valueOf(rs.getBigDecimal(i));
/*     */         }
/* 580 */         strValue = PubFun.getInt(strValue);
/* 581 */       } else if (dataType == 8) {
/* 582 */         strValue = String.valueOf(rs.getDouble(i));
/*     */       } else {
/* 584 */         strValue = rs.getString(i);
/*     */       }
/*     */     }
/*     */     catch (SQLException ex) {
/* 588 */       ex.printStackTrace();
/*     */     }
/*     */ 
/* 591 */     return StrTool.cTrim(strValue);
/*     */   }
/*     */ 
/*     */   public boolean execUpdateSQL(String sql)
/*     */   {
/* 596 */     PreparedStatement pstmt = null;
/*     */ 
/* 600 */     if (!this.mflag) {
/* 601 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 607 */       pstmt = this.con.prepareStatement(StrTool.GBKToUnicode(sql), 
/* 608 */         1003, 1008);
/* 609 */       pstmt.executeUpdate();
/*     */ 
/* 612 */       pstmt.close();
/*     */ 
/* 614 */       if (!this.mflag)
/*     */       {
/* 616 */         this.con.close();
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 623 */       System.out.println("### Error ExeSQL at Update: " + sql);
/*     */ 
/* 626 */       CError.buildErr(this, e.toString());
/*     */       try
/*     */       {
/* 629 */         pstmt.close();
/*     */ 
/* 631 */         if (!this.mflag)
/*     */         {
/* 633 */           this.con.close();
/*     */         }
/*     */       } catch (SQLException ex) {
/* 636 */         return false;
/*     */       }
/*     */ 
/* 639 */       return false;
/*     */     }
/*     */ 
/* 642 */     if (!this.mflag)
/*     */       try {
/* 644 */         this.con.close();
/*     */       }
/*     */       catch (SQLException localSQLException1) {
/*     */       }
/* 648 */     return true;
/*     */   }
/*     */ 
/*     */   public void execSQL(String csql, PrintWriter ous) {
/* 652 */     String tStr = "";
/* 653 */     Statement stmt = null;
/* 654 */     ResultSet rs = null;
/* 655 */     ResultSetMetaData rsmd = null;
/*     */     try
/*     */     {
/* 661 */       stmt = this.con.createStatement(1003, 
/* 662 */         1007);
/*     */ 
/* 664 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(csql));
/*     */ 
/* 667 */       rsmd = rs.getMetaData();
/* 668 */       int n = rsmd.getColumnCount();
/*     */ 
/* 671 */       while (rs.next()) {
/* 672 */         for (int j = 1; j <= n; j++) {
/* 673 */           String strValue = "";
/*     */ 
/* 676 */           strValue = getDataValue(rsmd, rs, j);
/* 677 */           tStr = tStr + strValue;
/*     */ 
/* 679 */           if (j != n) {
/* 680 */             tStr = tStr + ",";
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/* 685 */         ous.println(tStr);
/* 686 */         tStr = "";
/*     */       }
/* 688 */       ous.flush();
/* 689 */       ous.close();
/* 690 */       rs.close();
/* 691 */       stmt.close();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 695 */       e.printStackTrace();
/*     */ 
/* 698 */       CError tError = new CError();
/* 699 */       tError.moduleName = "ExeSQL";
/* 700 */       tError.functionName = "ExecSQL";
/* 701 */       tError.errorMessage = ("\u951F\u65A4\u62F7\u8BE2\u5931\u951F\u6770\uFF4F\u62F7\u539F\u951F\u65A4\u62F7\u951F\u89D2\uFF4F\u62F7" + e.toString());
/* 702 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 705 */         rs.close();
/* 706 */         stmt.close();
/*     */       }
/*     */       catch (Exception localException1) {
/*     */       }
/* 710 */       if (!this.mflag)
/*     */         try {
/* 712 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2)
/*     */         {
/*     */         }
/*     */     }
/* 718 */     if (!this.mflag)
/*     */       try {
/* 720 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3)
/*     */       {
/*     */       }
/*     */   }
/*     */ 
/*     */   public SSRS execSQL(String sql) {
/* 728 */     PreparedStatement pstmt = null;
/* 729 */     ResultSet rs = null;
/* 730 */     ResultSetMetaData rsmd = null;
/* 731 */     SSRS tSSRS = null;
/*     */ 
/* 733 */     System.out.println("MDES ExecSQL : " + sql);
/*     */ 
/* 735 */     if (!this.mflag) {
/* 736 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 742 */       pstmt = this.con.prepareStatement(StrTool.GBKToUnicode(sql), 
/* 743 */         1003, 1007);
/* 744 */       rs = pstmt.executeQuery();
/* 745 */       rsmd = rs.getMetaData();
/*     */ 
/* 747 */       int n = rsmd.getColumnCount();
/* 748 */       tSSRS = new SSRS(n);
/*     */ 
/* 752 */       while (rs.next()) {
/* 753 */         for (int j = 1; j <= n; j++)
/*     */         {
/* 755 */           tSSRS.SetText(getDataValue(rsmd, rs, j));
/*     */         }
/*     */       }
/*     */ 
/* 759 */       rs.close();
/* 760 */       pstmt.close();
/*     */ 
/* 762 */       if (!this.mflag)
/* 763 */         this.con.close();
/*     */     }
/*     */     catch (SQLException e) {
/* 766 */       System.out.println("### Error ExeSQL at exeSQL1: " + sql);
/* 767 */       e.printStackTrace();
/*     */ 
/* 772 */       CError.buildErr(this, e.toString());
/*     */ 
/* 774 */       tSSRS = null;
/*     */       try
/*     */       {
/* 778 */         if (rs != null) {
/* 779 */           rs.close();
/*     */         }
/* 781 */         if (pstmt != null) {
/* 782 */           pstmt.close();
/*     */         }
/*     */ 
/* 785 */         if (!this.mflag) {
/* 786 */           this.con.close();
/*     */         }
/*     */       }
/*     */       catch (SQLException localSQLException1)
/*     */       {
/*     */       }
/*     */     }
/* 793 */     if (!this.mflag)
/*     */       try {
/* 795 */         this.con.close();
/*     */       }
/*     */       catch (SQLException localSQLException2)
/*     */       {
/*     */       }
/* 800 */     return tSSRS;
/*     */   }
/*     */ 
/*     */   public SSRS execSQL(String sql, int start, int nCount) {
/* 804 */     PreparedStatement pstmt = null;
/* 805 */     ResultSet rs = null;
/* 806 */     ResultSetMetaData rsmd = null;
/* 807 */     SSRS tSSRS = null;
/*     */ 
/* 811 */     if (start <= 0) {
/* 812 */       start = 1;
/*     */     }
/*     */ 
/* 815 */     if (nCount <= 0) {
/* 816 */       nCount = 1;
/*     */     }
/*     */ 
/* 820 */     if (!this.mflag) {
/* 821 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */     try
/*     */     {
/* 825 */       pstmt = this.con.prepareStatement(StrTool.GBKToUnicode(sql), 
/* 826 */         1003, 1007);
/* 827 */       rs = pstmt.executeQuery();
/* 828 */       rsmd = rs.getMetaData();
/*     */ 
/* 830 */       int n = rsmd.getColumnCount();
/* 831 */       tSSRS = new SSRS(n);
/*     */ 
/* 833 */       int m = start + nCount;
/* 834 */       int k = 0;
/*     */ 
/* 837 */       while (rs.next()) {
/* 838 */         k++;
/*     */ 
/* 841 */         if ((k >= start) && (k < m)) {
/* 842 */           for (int j = 1; j <= n; j++) {
/* 843 */             tSSRS.SetText(getDataValue(rsmd, rs, j));
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 848 */       rs.close();
/* 849 */       pstmt.close();
/*     */ 
/* 851 */       if (!this.mflag)
/* 852 */         this.con.close();
/*     */     }
/*     */     catch (SQLException e) {
/* 855 */       System.out.println("### Error ExeSQL at exeSQL2: " + sql);
/* 856 */       e.printStackTrace();
/*     */ 
/* 861 */       CError.buildErr(this, e.toString());
/*     */ 
/* 863 */       tSSRS = null;
/*     */       try
/*     */       {
/* 866 */         if (rs != null) {
/* 867 */           rs.close();
/*     */         }
/* 869 */         if (pstmt != null) {
/* 870 */           pstmt.close();
/*     */         }
/*     */ 
/* 873 */         if (!this.mflag)
/* 874 */           this.con.close();
/*     */       }
/*     */       catch (SQLException localSQLException1)
/*     */       {
/*     */       }
/*     */     }
/* 880 */     if (!this.mflag)
/*     */       try {
/* 882 */         this.con.close();
/*     */       }
/*     */       catch (SQLException localSQLException2) {
/*     */       }
/* 886 */     return tSSRS;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.ExeSQL
 * JD-Core Version:    0.6.0
 */