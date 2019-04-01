/*     */ package com.sinosoft.map.lis.db;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MMaxNoSchema;
/*     */ import com.sinosoft.map.lis.vschema.MMaxNoSet;
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
/*     */ public class MMaxNoDB extends MMaxNoSchema
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
/*     */   public MMaxNoDB(Connection tConnection)
/*     */   {
/*  31 */     this.con = tConnection;
/*  32 */     this.db = new DBOper(this.con, "MMaxNo");
/*  33 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MMaxNoDB()
/*     */   {
/*  38 */     this.con = null;
/*  39 */     this.db = new DBOper("MMaxNo");
/*  40 */     this.mflag = false;
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  46 */     MMaxNoSchema tSchema = getSchema();
/*  47 */     if (this.db.deleteSQL(tSchema))
/*     */     {
/*  49 */       return true;
/*     */     }
/*     */ 
/*  54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*  55 */     CError tError = new CError();
/*  56 */     tError.moduleName = "MMaxNoDB";
/*  57 */     tError.functionName = "deleteSQL";
/*  58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*  59 */     this.mErrors.addOneError(tError);
/*  60 */     return false;
/*     */   }
/*     */ 
/*     */   public int getCount()
/*     */   {
/*  66 */     MMaxNoSchema tSchema = getSchema();
/*     */ 
/*  68 */     int tCount = this.db.getCount(tSchema);
/*  69 */     if (tCount < 0)
/*     */     {
/*  72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  73 */       CError tError = new CError();
/*  74 */       tError.moduleName = "MMaxNoDB";
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
/*  95 */       pstmt = this.con.prepareStatement("DELETE FROM MMaxNo WHERE  NoType = ? AND NoLimit = ?");
/*  96 */       if ((getNoType() == null) || (getNoType().equals("null")))
/*  97 */         pstmt.setNull(1, 12);
/*     */       else {
/*  99 */         pstmt.setString(1, getNoType());
/*     */       }
/* 101 */       if ((getNoLimit() == null) || (getNoLimit().equals("null")))
/* 102 */         pstmt.setNull(2, 12);
/*     */       else {
/* 104 */         pstmt.setString(2, getNoLimit());
/*     */       }
/* 106 */       pstmt.executeUpdate();
/* 107 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 110 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 111 */       CError tError = new CError();
/* 112 */       tError.moduleName = "MMaxNoDB";
/* 113 */       tError.functionName = "delete()";
/* 114 */       tError.errorMessage = ex.toString();
/* 115 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 118 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 121 */       if (!this.mflag)
/*     */         try {
/* 123 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 127 */       return false;
/*     */     }
/*     */ 
/* 130 */     if (!this.mflag)
/*     */       try {
/* 132 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 136 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 141 */     PreparedStatement pstmt = null;
/*     */ 
/* 143 */     if (!this.mflag) {
/* 144 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 149 */       pstmt = this.con.prepareStatement("UPDATE MMaxNo SET  NoType = ? , NoLimit = ? , MaxNo = ? WHERE  NoType = ? AND NoLimit = ?");
/* 150 */       if ((getNoType() == null) || (getNoType().equals("null")))
/* 151 */         pstmt.setNull(1, 12);
/*     */       else {
/* 153 */         pstmt.setString(1, getNoType());
/*     */       }
/* 155 */       if ((getNoLimit() == null) || (getNoLimit().equals("null")))
/* 156 */         pstmt.setNull(2, 12);
/*     */       else {
/* 158 */         pstmt.setString(2, getNoLimit());
/*     */       }
/* 160 */       pstmt.setInt(3, getMaxNo());
/*     */ 
/* 162 */       if ((getNoType() == null) || (getNoType().equals("null")))
/* 163 */         pstmt.setNull(4, 12);
/*     */       else {
/* 165 */         pstmt.setString(4, getNoType());
/*     */       }
/* 167 */       if ((getNoLimit() == null) || (getNoLimit().equals("null")))
/* 168 */         pstmt.setNull(5, 12);
/*     */       else {
/* 170 */         pstmt.setString(5, getNoLimit());
/*     */       }
/* 172 */       pstmt.executeUpdate();
/* 173 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 176 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 177 */       CError tError = new CError();
/* 178 */       tError.moduleName = "MMaxNoDB";
/* 179 */       tError.functionName = "update()";
/* 180 */       tError.errorMessage = ex.toString();
/* 181 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 184 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 187 */       if (!this.mflag)
/*     */         try {
/* 189 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 193 */       return false;
/*     */     }
/*     */ 
/* 196 */     if (!this.mflag)
/*     */       try {
/* 198 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 202 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 207 */     PreparedStatement pstmt = null;
/*     */ 
/* 209 */     if (!this.mflag) {
/* 210 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 215 */       pstmt = this.con.prepareStatement("INSERT INTO MMaxNo VALUES( ? , ? , ?)");
/* 216 */       if ((getNoType() == null) || (getNoType().equals("null")))
/* 217 */         pstmt.setNull(1, 12);
/*     */       else {
/* 219 */         pstmt.setString(1, getNoType());
/*     */       }
/* 221 */       if ((getNoLimit() == null) || (getNoLimit().equals("null")))
/* 222 */         pstmt.setNull(2, 12);
/*     */       else {
/* 224 */         pstmt.setString(2, getNoLimit());
/*     */       }
/* 226 */       pstmt.setInt(3, getMaxNo());
/*     */ 
/* 228 */       pstmt.executeUpdate();
/* 229 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 232 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 233 */       CError tError = new CError();
/* 234 */       tError.moduleName = "MMaxNoDB";
/* 235 */       tError.functionName = "insert()";
/* 236 */       tError.errorMessage = ex.toString();
/* 237 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 240 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 243 */       if (!this.mflag)
/*     */         try {
/* 245 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 249 */       return false;
/*     */     }
/*     */ 
/* 252 */     if (!this.mflag)
/*     */       try {
/* 254 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 258 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean getInfo()
/*     */   {
/* 263 */     PreparedStatement pstmt = null;
/* 264 */     ResultSet rs = null;
/*     */ 
/* 266 */     if (!this.mflag) {
/* 267 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 272 */       pstmt = this.con.prepareStatement("SELECT * FROM MMaxNo WHERE  NoType = ? AND NoLimit = ?", 
/* 273 */         1003, 1007);
/* 274 */       if ((getNoType() == null) || (getNoType().equals("null")))
/* 275 */         pstmt.setNull(1, 12);
/*     */       else {
/* 277 */         pstmt.setString(1, getNoType());
/*     */       }
/* 279 */       if ((getNoLimit() == null) || (getNoLimit().equals("null")))
/* 280 */         pstmt.setNull(2, 12);
/*     */       else {
/* 282 */         pstmt.setString(2, getNoLimit());
/*     */       }
/* 284 */       rs = pstmt.executeQuery();
/* 285 */       int i = 0;
/* 286 */       if (rs.next())
/*     */       {
/* 288 */         i++;
/* 289 */         if (!setSchema(rs, i))
/*     */         {
/* 292 */           CError tError = new CError();
/* 293 */           tError.moduleName = "MMaxNoDB";
/* 294 */           tError.functionName = "getInfo";
/* 295 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/* 296 */           this.mErrors.addOneError(tError);
/*     */           try {
/* 298 */             rs.close(); } catch (Exception localException1) {
/*     */           }try { pstmt.close(); } catch (Exception localException2) {
/*     */           }
/* 301 */           if (!this.mflag)
/*     */           {
/*     */             try
/*     */             {
/* 305 */               this.con.close();
/*     */             } catch (Exception localException3) {
/*     */             }
/*     */           }
/* 309 */           return false;
/*     */         }
/*     */       }
/*     */       try {
/* 313 */         rs.close(); } catch (Exception localException4) {
/*     */       }try { pstmt.close(); } catch (Exception localException5) {
/*     */       }
/* 316 */       if (i == 0)
/*     */       {
/* 318 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 322 */             this.con.close();
/*     */           } catch (Exception localException6) {
/*     */           }
/*     */         }
/* 326 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 332 */       CError tError = new CError();
/* 333 */       tError.moduleName = "MMaxNoDB";
/* 334 */       tError.functionName = "getInfo";
/* 335 */       tError.errorMessage = e.toString();
/* 336 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 338 */         rs.close(); } catch (Exception localException7) {
/*     */       }try { pstmt.close(); } catch (Exception localException8) {
/*     */       }
/* 341 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 345 */           this.con.close();
/*     */         } catch (Exception localException9) {
/*     */         }
/*     */       }
/* 349 */       return false;
/*     */     }
/*     */ 
/* 352 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 356 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException10) {
/*     */       }
/*     */     }
/* 361 */     return true;
/*     */   }
/*     */ 
/*     */   public MMaxNoSet query()
/*     */   {
/* 366 */     Statement stmt = null;
/* 367 */     ResultSet rs = null;
/* 368 */     MMaxNoSet aMMaxNoSet = new MMaxNoSet();
/*     */ 
/* 370 */     if (!this.mflag) {
/* 371 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 376 */       stmt = this.con.createStatement(1003, 1007);
/* 377 */       SQLString sqlObj = new SQLString("MMaxNo");
/* 378 */       MMaxNoSchema aSchema = getSchema();
/* 379 */       sqlObj.setSQL(5, aSchema);
/* 380 */       String sql = sqlObj.getSQL();
/*     */ 
/* 382 */       rs = stmt.executeQuery(sql);
/* 383 */       int i = 0;
/* 384 */       while (rs.next())
/*     */       {
/* 386 */         i++;
/* 387 */         MMaxNoSchema s1 = new MMaxNoSchema();
/* 388 */         s1.setSchema(rs, i);
/* 389 */         aMMaxNoSet.add(s1);
/*     */       }try {
/* 391 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 397 */       CError tError = new CError();
/* 398 */       tError.moduleName = "MMaxNoDB";
/* 399 */       tError.functionName = "query";
/* 400 */       tError.errorMessage = e.toString();
/* 401 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 403 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 406 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 410 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 416 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 420 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 425 */     return aMMaxNoSet;
/*     */   }
/*     */ 
/*     */   public MMaxNoSet executeQuery(String sql)
/*     */   {
/* 430 */     Statement stmt = null;
/* 431 */     ResultSet rs = null;
/* 432 */     MMaxNoSet aMMaxNoSet = new MMaxNoSet();
/*     */ 
/* 434 */     if (!this.mflag) {
/* 435 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 440 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 442 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 443 */       int i = 0;
/* 444 */       while (rs.next())
/*     */       {
/* 446 */         i++;
/* 447 */         MMaxNoSchema s1 = new MMaxNoSchema();
/* 448 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 451 */           CError tError = new CError();
/* 452 */           tError.moduleName = "MMaxNoDB";
/* 453 */           tError.functionName = "executeQuery";
/* 454 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/* 455 */           this.mErrors.addOneError(tError);
/*     */         }
/* 457 */         aMMaxNoSet.add(s1);
/*     */       }try {
/* 459 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 465 */       CError tError = new CError();
/* 466 */       tError.moduleName = "MMaxNoDB";
/* 467 */       tError.functionName = "executeQuery";
/* 468 */       tError.errorMessage = e.toString();
/* 469 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 471 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 474 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 478 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 484 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 488 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 493 */     return aMMaxNoSet;
/*     */   }
/*     */ 
/*     */   public MMaxNoSet query(int nStart, int nCount)
/*     */   {
/* 498 */     Statement stmt = null;
/* 499 */     ResultSet rs = null;
/* 500 */     MMaxNoSet aMMaxNoSet = new MMaxNoSet();
/*     */ 
/* 502 */     if (!this.mflag) {
/* 503 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 508 */       stmt = this.con.createStatement(1003, 1007);
/* 509 */       SQLString sqlObj = new SQLString("MMaxNo");
/* 510 */       MMaxNoSchema aSchema = getSchema();
/* 511 */       sqlObj.setSQL(5, aSchema);
/* 512 */       String sql = sqlObj.getSQL();
/*     */ 
/* 514 */       rs = stmt.executeQuery(sql);
/* 515 */       int i = 0;
/* 516 */       while (rs.next())
/*     */       {
/* 518 */         i++;
/*     */ 
/* 520 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 524 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 528 */         MMaxNoSchema s1 = new MMaxNoSchema();
/* 529 */         s1.setSchema(rs, i);
/* 530 */         aMMaxNoSet.add(s1);
/*     */       }try {
/* 532 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 538 */       CError tError = new CError();
/* 539 */       tError.moduleName = "MMaxNoDB";
/* 540 */       tError.functionName = "query";
/* 541 */       tError.errorMessage = e.toString();
/* 542 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 544 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 547 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 551 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 557 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 561 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 566 */     return aMMaxNoSet;
/*     */   }
/*     */ 
/*     */   public MMaxNoSet executeQuery(String sql, int nStart, int nCount)
/*     */   {
/* 571 */     Statement stmt = null;
/* 572 */     ResultSet rs = null;
/* 573 */     MMaxNoSet aMMaxNoSet = new MMaxNoSet();
/*     */ 
/* 575 */     if (!this.mflag) {
/* 576 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 581 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 583 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 584 */       int i = 0;
/* 585 */       while (rs.next())
/*     */       {
/* 587 */         i++;
/*     */ 
/* 589 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 593 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 597 */         MMaxNoSchema s1 = new MMaxNoSchema();
/* 598 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 601 */           CError tError = new CError();
/* 602 */           tError.moduleName = "MMaxNoDB";
/* 603 */           tError.functionName = "executeQuery";
/* 604 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/* 605 */           this.mErrors.addOneError(tError);
/*     */         }
/* 607 */         aMMaxNoSet.add(s1);
/*     */       }try {
/* 609 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 615 */       CError tError = new CError();
/* 616 */       tError.moduleName = "MMaxNoDB";
/* 617 */       tError.functionName = "executeQuery";
/* 618 */       tError.errorMessage = e.toString();
/* 619 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 621 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 624 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 628 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 634 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 638 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 643 */     return aMMaxNoSet;
/*     */   }
/*     */ 
/*     */   public boolean update(String strWherePart)
/*     */   {
/* 648 */     Statement stmt = null;
/*     */ 
/* 650 */     if (!this.mflag) {
/* 651 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 656 */       stmt = this.con.createStatement(1003, 1007);
/* 657 */       SQLString sqlObj = new SQLString("MMaxNo");
/* 658 */       MMaxNoSchema aSchema = getSchema();
/* 659 */       sqlObj.setSQL(2, aSchema);
/* 660 */       String sql = "update MMaxNo " + sqlObj.getUpdPart() + " where " + strWherePart;
/*     */ 
/* 662 */       int operCount = stmt.executeUpdate(sql);
/* 663 */       if (operCount == 0)
/*     */       {
/* 666 */         CError tError = new CError();
/* 667 */         tError.moduleName = "MMaxNoDB";
/* 668 */         tError.functionName = "update";
/* 669 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/* 670 */         this.mErrors.addOneError(tError);
/*     */ 
/* 672 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 676 */             this.con.close();
/*     */           } catch (Exception localException1) {
/*     */           }
/*     */         }
/* 680 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 686 */       CError tError = new CError();
/* 687 */       tError.moduleName = "MMaxNoDB";
/* 688 */       tError.functionName = "update";
/* 689 */       tError.errorMessage = e.toString();
/* 690 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 692 */         stmt.close(); } catch (Exception localException2) {
/*     */       }
/* 694 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 698 */           this.con.close();
/*     */         } catch (Exception localException3) {
/*     */         }
/*     */       }
/* 702 */       return false;
/*     */     }
/*     */ 
/* 705 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 709 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException4) {
/*     */       }
/*     */     }
/* 714 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean prepareData(String strSQL)
/*     */   {
/* 720 */     if (this.mResultSet != null)
/*     */     {
/* 723 */       CError tError = new CError();
/* 724 */       tError.moduleName = "MMaxNoDB";
/* 725 */       tError.functionName = "prepareData";
/* 726 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/* 727 */       this.mErrors.addOneError(tError);
/* 728 */       return false;
/*     */     }
/*     */ 
/* 731 */     if (!this.mflag)
/*     */     {
/* 733 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */     try
/*     */     {
/* 737 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 738 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 743 */       CError tError = new CError();
/* 744 */       tError.moduleName = "MMaxNoDB";
/* 745 */       tError.functionName = "prepareData";
/* 746 */       tError.errorMessage = e.toString();
/* 747 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 750 */         this.mResultSet.close();
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 756 */         this.mStatement.close();
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 760 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 764 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 769 */       return false;
/*     */     }
/*     */ 
/* 772 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 776 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException4) {
/*     */       }
/*     */     }
/* 781 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean hasMoreData()
/*     */   {
/* 787 */     boolean flag = true;
/* 788 */     if (this.mResultSet == null)
/*     */     {
/* 790 */       CError tError = new CError();
/* 791 */       tError.moduleName = "MMaxNoDB";
/* 792 */       tError.functionName = "hasMoreData";
/* 793 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 794 */       this.mErrors.addOneError(tError);
/* 795 */       return false;
/*     */     }
/*     */     try
/*     */     {
/* 799 */       flag = this.mResultSet.next();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 803 */       CError tError = new CError();
/* 804 */       tError.moduleName = "MMaxNoDB";
/* 805 */       tError.functionName = "hasMoreData";
/* 806 */       tError.errorMessage = ex.toString();
/* 807 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 810 */         this.mResultSet.close();
/* 811 */         this.mResultSet = null;
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 817 */         this.mStatement.close();
/* 818 */         this.mStatement = null;
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 822 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 826 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 831 */       return false;
/*     */     }
/* 833 */     return flag;
/*     */   }
/*     */ 
/*     */   public MMaxNoSet getData()
/*     */   {
/* 838 */     int tCount = 0;
/* 839 */     MMaxNoSet tMMaxNoSet = new MMaxNoSet();
/* 840 */     MMaxNoSchema tMMaxNoSchema = null;
/* 841 */     if (this.mResultSet == null)
/*     */     {
/* 843 */       CError tError = new CError();
/* 844 */       tError.moduleName = "MMaxNoDB";
/* 845 */       tError.functionName = "getData";
/* 846 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 847 */       this.mErrors.addOneError(tError);
/* 848 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 852 */       tCount = 1;
/* 853 */       tMMaxNoSchema = new MMaxNoSchema();
/* 854 */       tMMaxNoSchema.setSchema(this.mResultSet, 1);
/* 855 */       tMMaxNoSet.add(tMMaxNoSchema);
/*     */ 
/* 857 */       while (tCount++ < 5000)
/*     */       {
/* 859 */         if (!this.mResultSet.next())
/*     */           continue;
/* 861 */         tMMaxNoSchema = new MMaxNoSchema();
/* 862 */         tMMaxNoSchema.setSchema(this.mResultSet, 1);
/* 863 */         tMMaxNoSet.add(tMMaxNoSchema);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 869 */       CError tError = new CError();
/* 870 */       tError.moduleName = "MMaxNoDB";
/* 871 */       tError.functionName = "getData";
/* 872 */       tError.errorMessage = ex.toString();
/* 873 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 876 */         this.mResultSet.close();
/* 877 */         this.mResultSet = null;
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 883 */         this.mStatement.close();
/* 884 */         this.mStatement = null;
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 888 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 892 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 897 */       return null;
/*     */     }
/* 899 */     return tMMaxNoSet;
/*     */   }
/*     */ 
/*     */   public boolean closeData()
/*     */   {
/* 904 */     boolean flag = true;
/*     */     try
/*     */     {
/* 907 */       if (this.mResultSet == null)
/*     */       {
/* 909 */         CError tError = new CError();
/* 910 */         tError.moduleName = "MMaxNoDB";
/* 911 */         tError.functionName = "closeData";
/* 912 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 913 */         this.mErrors.addOneError(tError);
/* 914 */         flag = false;
/*     */       }
/*     */       else
/*     */       {
/* 918 */         this.mResultSet.close();
/* 919 */         this.mResultSet = null;
/*     */       }
/*     */     }
/*     */     catch (Exception ex2)
/*     */     {
/* 924 */       CError tError = new CError();
/* 925 */       tError.moduleName = "MMaxNoDB";
/* 926 */       tError.functionName = "closeData";
/* 927 */       tError.errorMessage = ex2.toString();
/* 928 */       this.mErrors.addOneError(tError);
/* 929 */       flag = false;
/*     */     }
/*     */     try
/*     */     {
/* 933 */       if (this.mStatement == null)
/*     */       {
/* 935 */         CError tError = new CError();
/* 936 */         tError.moduleName = "MMaxNoDB";
/* 937 */         tError.functionName = "closeData";
/* 938 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 939 */         this.mErrors.addOneError(tError);
/* 940 */         flag = false;
/*     */       }
/*     */       else
/*     */       {
/* 944 */         this.mStatement.close();
/* 945 */         this.mStatement = null;
/*     */       }
/*     */     }
/*     */     catch (Exception ex3)
/*     */     {
/* 950 */       CError tError = new CError();
/* 951 */       tError.moduleName = "MMaxNoDB";
/* 952 */       tError.functionName = "closeData";
/* 953 */       tError.errorMessage = ex3.toString();
/* 954 */       this.mErrors.addOneError(tError);
/* 955 */       flag = false;
/*     */     }
/* 957 */     return flag;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MMaxNoDB
 * JD-Core Version:    0.6.0
 */