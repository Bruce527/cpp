/*     */ package com.sinosoft.map.lis.db;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MLibraryRateSchema;
/*     */ import com.sinosoft.map.lis.vschema.MLibraryRateSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import com.sinosoft.map.utility.SQLString;
/*     */ import com.sinosoft.map.utility.StrTool;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ 
/*     */ public class MLibraryRateDB extends MLibraryRateSchema
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*  23 */   public CErrors mErrors = new CErrors();
/*     */ 
/*  26 */   private ResultSet mResultSet = null;
/*  27 */   private Statement mStatement = null;
/*     */ 
/*     */   public MLibraryRateDB(Connection tConnection)
/*     */   {
/*  31 */     this.con = tConnection;
/*  32 */     this.db = new DBOper(this.con, "MLibraryRate");
/*  33 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MLibraryRateDB()
/*     */   {
/*  38 */     this.con = null;
/*  39 */     this.db = new DBOper("MLibraryRate");
/*  40 */     this.mflag = false;
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  46 */     MLibraryRateSchema tSchema = getSchema();
/*  47 */     if (this.db.deleteSQL(tSchema))
/*     */     {
/*  49 */       return true;
/*     */     }
/*     */ 
/*  54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*  55 */     CError tError = new CError();
/*  56 */     tError.moduleName = "MLibraryRateDB";
/*  57 */     tError.functionName = "deleteSQL";
/*  58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*  59 */     this.mErrors.addOneError(tError);
/*  60 */     return false;
/*     */   }
/*     */ 
/*     */   public int getCount()
/*     */   {
/*  66 */     MLibraryRateSchema tSchema = getSchema();
/*     */ 
/*  68 */     int tCount = this.db.getCount(tSchema);
/*  69 */     if (tCount < 0)
/*     */     {
/*  72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  73 */       CError tError = new CError();
/*  74 */       tError.moduleName = "MLibraryRateDB";
/*  75 */       tError.functionName = "getCount";
/*  76 */       tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*  77 */       this.mErrors.addOneError(tError);
/*     */ 
/*  79 */       return -1;
/*     */     }
/*     */ 
/*  82 */     return tCount;
/*     */   }
/*     */ 
/*     */   public boolean delete()
/*     */   {
/*  87 */     PreparedStatement pstmt = null;
/*     */ 
/*  89 */     if (!this.mflag) {
/*  90 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  95 */       pstmt = this.con.prepareStatement("DELETE FROM MLibraryRate WHERE  FileID = ?");
/*  96 */       if ((getFileID() == null) || (getFileID().equals("null")))
/*  97 */         pstmt.setNull(1, 12);
/*     */       else {
/*  99 */         pstmt.setString(1, getFileID());
/*     */       }
/* 101 */       pstmt.executeUpdate();
/* 102 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 105 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 106 */       CError tError = new CError();
/* 107 */       tError.moduleName = "MLibraryRateDB";
/* 108 */       tError.functionName = "delete()";
/* 109 */       tError.errorMessage = ex.toString();
/* 110 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 113 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 116 */       if (!this.mflag)
/*     */         try {
/* 118 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 122 */       return false;
/*     */     }
/*     */ 
/* 125 */     if (!this.mflag)
/*     */       try {
/* 127 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 131 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 136 */     PreparedStatement pstmt = null;
/*     */ 
/* 138 */     if (!this.mflag) {
/* 139 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 144 */       pstmt = this.con.prepareStatement("UPDATE MLibraryRate SET  FileID = ? , DownloadRate = ? WHERE  FileID = ?");
/* 145 */       if ((getFileID() == null) || (getFileID().equals("null")))
/* 146 */         pstmt.setNull(1, 12);
/*     */       else {
/* 148 */         pstmt.setString(1, getFileID());
/*     */       }
/* 150 */       pstmt.setDouble(2, getDownloadRate());
/*     */ 
/* 152 */       if ((getFileID() == null) || (getFileID().equals("null")))
/* 153 */         pstmt.setNull(3, 12);
/*     */       else {
/* 155 */         pstmt.setString(3, getFileID());
/*     */       }
/* 157 */       pstmt.executeUpdate();
/* 158 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 161 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 162 */       CError tError = new CError();
/* 163 */       tError.moduleName = "MLibraryRateDB";
/* 164 */       tError.functionName = "update()";
/* 165 */       tError.errorMessage = ex.toString();
/* 166 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 169 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 172 */       if (!this.mflag)
/*     */         try {
/* 174 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 178 */       return false;
/*     */     }
/*     */ 
/* 181 */     if (!this.mflag)
/*     */       try {
/* 183 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 187 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 192 */     PreparedStatement pstmt = null;
/*     */ 
/* 194 */     if (!this.mflag) {
/* 195 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 200 */       pstmt = this.con.prepareStatement("INSERT INTO MLibraryRate VALUES( ? , ?)");
/* 201 */       if ((getFileID() == null) || (getFileID().equals("null")))
/* 202 */         pstmt.setNull(1, 12);
/*     */       else {
/* 204 */         pstmt.setString(1, getFileID());
/*     */       }
/* 206 */       pstmt.setDouble(2, getDownloadRate());
/*     */ 
/* 208 */       pstmt.executeUpdate();
/* 209 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 212 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 213 */       CError tError = new CError();
/* 214 */       tError.moduleName = "MLibraryRateDB";
/* 215 */       tError.functionName = "insert()";
/* 216 */       tError.errorMessage = ex.toString();
/* 217 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 220 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 223 */       if (!this.mflag)
/*     */         try {
/* 225 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 229 */       return false;
/*     */     }
/*     */ 
/* 232 */     if (!this.mflag)
/*     */       try {
/* 234 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 238 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean getInfo()
/*     */   {
/* 243 */     PreparedStatement pstmt = null;
/* 244 */     ResultSet rs = null;
/*     */ 
/* 246 */     if (!this.mflag) {
/* 247 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 252 */       pstmt = this.con.prepareStatement("SELECT * FROM MLibraryRate WHERE  FileID = ?", 
/* 253 */         1003, 1007);
/* 254 */       if ((getFileID() == null) || (getFileID().equals("null")))
/* 255 */         pstmt.setNull(1, 12);
/*     */       else {
/* 257 */         pstmt.setString(1, getFileID());
/*     */       }
/* 259 */       rs = pstmt.executeQuery();
/* 260 */       int i = 0;
/* 261 */       if (rs.next())
/*     */       {
/* 263 */         i++;
/* 264 */         if (!setSchema(rs, i))
/*     */         {
/* 267 */           CError tError = new CError();
/* 268 */           tError.moduleName = "MLibraryRateDB";
/* 269 */           tError.functionName = "getInfo";
/* 270 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/* 271 */           this.mErrors.addOneError(tError);
/*     */           try {
/* 273 */             rs.close(); } catch (Exception localException1) {
/*     */           }try { pstmt.close(); } catch (Exception localException2) {
/*     */           }
/* 276 */           if (!this.mflag)
/*     */           {
/*     */             try
/*     */             {
/* 280 */               this.con.close();
/*     */             } catch (Exception localException3) {
/*     */             }
/*     */           }
/* 284 */           return false;
/*     */         }
/*     */       }
/*     */       try {
/* 288 */         rs.close(); } catch (Exception localException4) {
/*     */       }try { pstmt.close(); } catch (Exception localException5) {
/*     */       }
/* 291 */       if (i == 0)
/*     */       {
/* 293 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 297 */             this.con.close();
/*     */           } catch (Exception localException6) {
/*     */           }
/*     */         }
/* 301 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 307 */       CError tError = new CError();
/* 308 */       tError.moduleName = "MLibraryRateDB";
/* 309 */       tError.functionName = "getInfo";
/* 310 */       tError.errorMessage = e.toString();
/* 311 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 313 */         rs.close(); } catch (Exception localException7) {
/*     */       }try { pstmt.close(); } catch (Exception localException8) {
/*     */       }
/* 316 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 320 */           this.con.close();
/*     */         } catch (Exception localException9) {
/*     */         }
/*     */       }
/* 324 */       return false;
/*     */     }
/*     */ 
/* 327 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 331 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException10) {
/*     */       }
/*     */     }
/* 336 */     return true;
/*     */   }
/*     */ 
/*     */   public MLibraryRateSet query()
/*     */   {
/* 341 */     Statement stmt = null;
/* 342 */     ResultSet rs = null;
/* 343 */     MLibraryRateSet aMLibraryRateSet = new MLibraryRateSet();
/*     */ 
/* 345 */     if (!this.mflag) {
/* 346 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 351 */       stmt = this.con.createStatement(1003, 1007);
/* 352 */       SQLString sqlObj = new SQLString("MLibraryRate");
/* 353 */       MLibraryRateSchema aSchema = getSchema();
/* 354 */       sqlObj.setSQL(5, aSchema);
/* 355 */       String sql = sqlObj.getSQL();
/*     */ 
/* 357 */       rs = stmt.executeQuery(sql);
/* 358 */       int i = 0;
/* 359 */       while (rs.next())
/*     */       {
/* 361 */         i++;
/* 362 */         MLibraryRateSchema s1 = new MLibraryRateSchema();
/* 363 */         s1.setSchema(rs, i);
/* 364 */         aMLibraryRateSet.add(s1);
/*     */       }try {
/* 366 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 372 */       CError tError = new CError();
/* 373 */       tError.moduleName = "MLibraryRateDB";
/* 374 */       tError.functionName = "query";
/* 375 */       tError.errorMessage = e.toString();
/* 376 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 378 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 381 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 385 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 391 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 395 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 400 */     return aMLibraryRateSet;
/*     */   }
/*     */ 
/*     */   public MLibraryRateSet executeQuery(String sql)
/*     */   {
/* 405 */     Statement stmt = null;
/* 406 */     ResultSet rs = null;
/* 407 */     MLibraryRateSet aMLibraryRateSet = new MLibraryRateSet();
/*     */ 
/* 409 */     if (!this.mflag) {
/* 410 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 415 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 417 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 418 */       int i = 0;
/* 419 */       while (rs.next())
/*     */       {
/* 421 */         i++;
/* 422 */         MLibraryRateSchema s1 = new MLibraryRateSchema();
/* 423 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 426 */           CError tError = new CError();
/* 427 */           tError.moduleName = "MLibraryRateDB";
/* 428 */           tError.functionName = "executeQuery";
/* 429 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/* 430 */           this.mErrors.addOneError(tError);
/*     */         }
/* 432 */         aMLibraryRateSet.add(s1);
/*     */       }try {
/* 434 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 440 */       CError tError = new CError();
/* 441 */       tError.moduleName = "MLibraryRateDB";
/* 442 */       tError.functionName = "executeQuery";
/* 443 */       tError.errorMessage = e.toString();
/* 444 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 446 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 449 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 453 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 459 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 463 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 468 */     return aMLibraryRateSet;
/*     */   }
/*     */ 
/*     */   public MLibraryRateSet query(int nStart, int nCount)
/*     */   {
/* 473 */     Statement stmt = null;
/* 474 */     ResultSet rs = null;
/* 475 */     MLibraryRateSet aMLibraryRateSet = new MLibraryRateSet();
/*     */ 
/* 477 */     if (!this.mflag) {
/* 478 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 483 */       stmt = this.con.createStatement(1003, 1007);
/* 484 */       SQLString sqlObj = new SQLString("MLibraryRate");
/* 485 */       MLibraryRateSchema aSchema = getSchema();
/* 486 */       sqlObj.setSQL(5, aSchema);
/* 487 */       String sql = sqlObj.getSQL();
/*     */ 
/* 489 */       rs = stmt.executeQuery(sql);
/* 490 */       int i = 0;
/* 491 */       while (rs.next())
/*     */       {
/* 493 */         i++;
/*     */ 
/* 495 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 499 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 503 */         MLibraryRateSchema s1 = new MLibraryRateSchema();
/* 504 */         s1.setSchema(rs, i);
/* 505 */         aMLibraryRateSet.add(s1);
/*     */       }try {
/* 507 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 513 */       CError tError = new CError();
/* 514 */       tError.moduleName = "MLibraryRateDB";
/* 515 */       tError.functionName = "query";
/* 516 */       tError.errorMessage = e.toString();
/* 517 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 519 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 522 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 526 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 532 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 536 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 541 */     return aMLibraryRateSet;
/*     */   }
/*     */ 
/*     */   public MLibraryRateSet executeQuery(String sql, int nStart, int nCount)
/*     */   {
/* 546 */     Statement stmt = null;
/* 547 */     ResultSet rs = null;
/* 548 */     MLibraryRateSet aMLibraryRateSet = new MLibraryRateSet();
/*     */ 
/* 550 */     if (!this.mflag) {
/* 551 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 556 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 558 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 559 */       int i = 0;
/* 560 */       while (rs.next())
/*     */       {
/* 562 */         i++;
/*     */ 
/* 564 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 568 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 572 */         MLibraryRateSchema s1 = new MLibraryRateSchema();
/* 573 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 576 */           CError tError = new CError();
/* 577 */           tError.moduleName = "MLibraryRateDB";
/* 578 */           tError.functionName = "executeQuery";
/* 579 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/* 580 */           this.mErrors.addOneError(tError);
/*     */         }
/* 582 */         aMLibraryRateSet.add(s1);
/*     */       }try {
/* 584 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 590 */       CError tError = new CError();
/* 591 */       tError.moduleName = "MLibraryRateDB";
/* 592 */       tError.functionName = "executeQuery";
/* 593 */       tError.errorMessage = e.toString();
/* 594 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 596 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 599 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 603 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 609 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 613 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 618 */     return aMLibraryRateSet;
/*     */   }
/*     */ 
/*     */   public boolean update(String strWherePart)
/*     */   {
/* 623 */     Statement stmt = null;
/*     */ 
/* 625 */     if (!this.mflag) {
/* 626 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 631 */       stmt = this.con.createStatement(1003, 1007);
/* 632 */       SQLString sqlObj = new SQLString("MLibraryRate");
/* 633 */       MLibraryRateSchema aSchema = getSchema();
/* 634 */       sqlObj.setSQL(2, aSchema);
/* 635 */       String sql = "update MLibraryRate " + sqlObj.getUpdPart() + " where " + strWherePart;
/*     */ 
/* 637 */       int operCount = stmt.executeUpdate(sql);
/* 638 */       if (operCount == 0)
/*     */       {
/* 641 */         CError tError = new CError();
/* 642 */         tError.moduleName = "MLibraryRateDB";
/* 643 */         tError.functionName = "update";
/* 644 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/* 645 */         this.mErrors.addOneError(tError);
/*     */ 
/* 647 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 651 */             this.con.close();
/*     */           } catch (Exception localException1) {
/*     */           }
/*     */         }
/* 655 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 661 */       CError tError = new CError();
/* 662 */       tError.moduleName = "MLibraryRateDB";
/* 663 */       tError.functionName = "update";
/* 664 */       tError.errorMessage = e.toString();
/* 665 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 667 */         stmt.close(); } catch (Exception localException2) {
/*     */       }
/* 669 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 673 */           this.con.close();
/*     */         } catch (Exception localException3) {
/*     */         }
/*     */       }
/* 677 */       return false;
/*     */     }
/*     */ 
/* 680 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 684 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException4) {
/*     */       }
/*     */     }
/* 689 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean prepareData(String strSQL)
/*     */   {
/* 695 */     if (this.mResultSet != null)
/*     */     {
/* 698 */       CError tError = new CError();
/* 699 */       tError.moduleName = "MLibraryRateDB";
/* 700 */       tError.functionName = "prepareData";
/* 701 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/* 702 */       this.mErrors.addOneError(tError);
/* 703 */       return false;
/*     */     }
/*     */ 
/* 706 */     if (!this.mflag)
/*     */     {
/* 708 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */     try
/*     */     {
/* 712 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 713 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 718 */       CError tError = new CError();
/* 719 */       tError.moduleName = "MLibraryRateDB";
/* 720 */       tError.functionName = "prepareData";
/* 721 */       tError.errorMessage = e.toString();
/* 722 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 725 */         this.mResultSet.close();
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 731 */         this.mStatement.close();
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 735 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 739 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 744 */       return false;
/*     */     }
/*     */ 
/* 747 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 751 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException4) {
/*     */       }
/*     */     }
/* 756 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean hasMoreData()
/*     */   {
/* 762 */     boolean flag = true;
/* 763 */     if (this.mResultSet == null)
/*     */     {
/* 765 */       CError tError = new CError();
/* 766 */       tError.moduleName = "MLibraryRateDB";
/* 767 */       tError.functionName = "hasMoreData";
/* 768 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 769 */       this.mErrors.addOneError(tError);
/* 770 */       return false;
/*     */     }
/*     */     try
/*     */     {
/* 774 */       flag = this.mResultSet.next();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 778 */       CError tError = new CError();
/* 779 */       tError.moduleName = "MLibraryRateDB";
/* 780 */       tError.functionName = "hasMoreData";
/* 781 */       tError.errorMessage = ex.toString();
/* 782 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 785 */         this.mResultSet.close();
/* 786 */         this.mResultSet = null;
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 792 */         this.mStatement.close();
/* 793 */         this.mStatement = null;
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 797 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 801 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 806 */       return false;
/*     */     }
/* 808 */     return flag;
/*     */   }
/*     */ 
/*     */   public MLibraryRateSet getData()
/*     */   {
/* 813 */     int tCount = 0;
/* 814 */     MLibraryRateSet tMLibraryRateSet = new MLibraryRateSet();
/* 815 */     MLibraryRateSchema tMLibraryRateSchema = null;
/* 816 */     if (this.mResultSet == null)
/*     */     {
/* 818 */       CError tError = new CError();
/* 819 */       tError.moduleName = "MLibraryRateDB";
/* 820 */       tError.functionName = "getData";
/* 821 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 822 */       this.mErrors.addOneError(tError);
/* 823 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 827 */       tCount = 1;
/* 828 */       tMLibraryRateSchema = new MLibraryRateSchema();
/* 829 */       tMLibraryRateSchema.setSchema(this.mResultSet, 1);
/* 830 */       tMLibraryRateSet.add(tMLibraryRateSchema);
/*     */ 
/* 832 */       while (tCount++ < 5000)
/*     */       {
/* 834 */         if (!this.mResultSet.next())
/*     */           continue;
/* 836 */         tMLibraryRateSchema = new MLibraryRateSchema();
/* 837 */         tMLibraryRateSchema.setSchema(this.mResultSet, 1);
/* 838 */         tMLibraryRateSet.add(tMLibraryRateSchema);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 844 */       CError tError = new CError();
/* 845 */       tError.moduleName = "MLibraryRateDB";
/* 846 */       tError.functionName = "getData";
/* 847 */       tError.errorMessage = ex.toString();
/* 848 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 851 */         this.mResultSet.close();
/* 852 */         this.mResultSet = null;
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 858 */         this.mStatement.close();
/* 859 */         this.mStatement = null;
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 863 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 867 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 872 */       return null;
/*     */     }
/* 874 */     return tMLibraryRateSet;
/*     */   }
/*     */ 
/*     */   public boolean closeData()
/*     */   {
/* 879 */     boolean flag = true;
/*     */     try
/*     */     {
/* 882 */       if (this.mResultSet == null)
/*     */       {
/* 884 */         CError tError = new CError();
/* 885 */         tError.moduleName = "MLibraryRateDB";
/* 886 */         tError.functionName = "closeData";
/* 887 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 888 */         this.mErrors.addOneError(tError);
/* 889 */         flag = false;
/*     */       }
/*     */       else
/*     */       {
/* 893 */         this.mResultSet.close();
/* 894 */         this.mResultSet = null;
/*     */       }
/*     */     }
/*     */     catch (Exception ex2)
/*     */     {
/* 899 */       CError tError = new CError();
/* 900 */       tError.moduleName = "MLibraryRateDB";
/* 901 */       tError.functionName = "closeData";
/* 902 */       tError.errorMessage = ex2.toString();
/* 903 */       this.mErrors.addOneError(tError);
/* 904 */       flag = false;
/*     */     }
/*     */     try
/*     */     {
/* 908 */       if (this.mStatement == null)
/*     */       {
/* 910 */         CError tError = new CError();
/* 911 */         tError.moduleName = "MLibraryRateDB";
/* 912 */         tError.functionName = "closeData";
/* 913 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 914 */         this.mErrors.addOneError(tError);
/* 915 */         flag = false;
/*     */       }
/*     */       else
/*     */       {
/* 919 */         this.mStatement.close();
/* 920 */         this.mStatement = null;
/*     */       }
/*     */     }
/*     */     catch (Exception ex3)
/*     */     {
/* 925 */       CError tError = new CError();
/* 926 */       tError.moduleName = "MLibraryRateDB";
/* 927 */       tError.functionName = "closeData";
/* 928 */       tError.errorMessage = ex3.toString();
/* 929 */       this.mErrors.addOneError(tError);
/* 930 */       flag = false;
/*     */     }
/* 932 */     return flag;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MLibraryRateDB
 * JD-Core Version:    0.6.0
 */