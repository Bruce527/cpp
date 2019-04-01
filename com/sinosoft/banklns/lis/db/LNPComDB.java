/*     */ package com.sinosoft.banklns.lis.db;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPComSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPComSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import com.sinosoft.banklns.utility.SQLString;
/*     */ import com.sinosoft.banklns.utility.StrTool;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ 
/*     */ public class LNPComDB extends LNPComSchema
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*  24 */   public CErrors mErrors = new CErrors();
/*     */ 
/*  27 */   private ResultSet mResultSet = null;
/*  28 */   private Statement mStatement = null;
/*     */ 
/*     */   public LNPComDB(Connection tConnection)
/*     */   {
/*  32 */     this.con = tConnection;
/*  33 */     this.db = new DBOper(this.con, "LNPCom");
/*  34 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPComDB()
/*     */   {
/*  39 */     this.con = null;
/*  40 */     this.db = new DBOper("LNPCom");
/*  41 */     this.mflag = false;
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  47 */     LNPComSchema tSchema = getSchema();
/*  48 */     if (this.db.deleteSQL(tSchema))
/*     */     {
/*  50 */       return true;
/*     */     }
/*     */ 
/*  55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*  56 */     CError tError = new CError();
/*  57 */     tError.moduleName = "LNPComDB";
/*  58 */     tError.functionName = "deleteSQL";
/*  59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*  60 */     this.mErrors.addOneError(tError);
/*  61 */     return false;
/*     */   }
/*     */ 
/*     */   public int getCount()
/*     */   {
/*  67 */     LNPComSchema tSchema = getSchema();
/*     */ 
/*  69 */     int tCount = this.db.getCount(tSchema);
/*  70 */     if (tCount < 0)
/*     */     {
/*  73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  74 */       CError tError = new CError();
/*  75 */       tError.moduleName = "LNPComDB";
/*  76 */       tError.functionName = "getCount";
/*  77 */       tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*  78 */       this.mErrors.addOneError(tError);
/*     */ 
/*  80 */       return -1;
/*     */     }
/*     */ 
/*  83 */     return tCount;
/*     */   }
/*     */ 
/*     */   public boolean delete()
/*     */   {
/*  88 */     PreparedStatement pstmt = null;
/*     */ 
/*  90 */     if (!this.mflag) {
/*  91 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPCom WHERE ");
/*  97 */       pstmt.executeUpdate();
/*  98 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 101 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 102 */       CError tError = new CError();
/* 103 */       tError.moduleName = "LNPComDB";
/* 104 */       tError.functionName = "delete()";
/* 105 */       tError.errorMessage = ex.toString();
/* 106 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 109 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 112 */       if (!this.mflag)
/*     */         try {
/* 114 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 118 */       return false;
/*     */     }
/*     */ 
/* 121 */     if (!this.mflag)
/*     */       try {
/* 123 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 127 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 132 */     PreparedStatement pstmt = null;
/*     */ 
/* 134 */     if (!this.mflag) {
/* 135 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 140 */       pstmt = this.con.prepareStatement("UPDATE LNPCom SET  ComCode = ? , OutComCode = ? , Name = ? , ShortName = ? , Address = ? , ZipCode = ? , Phone = ? , Fax = ? , EMail = ? , WebAddress = ? , SatrapName = ? , InsuMonitorCode = ? , InsureID = ? , SignID = ? , Country = ? , Province = ? , City = ? , ComNature = ? , ValidCode = ? , Sign = ? WHERE ");
/*     */ 
/* 142 */       pstmt.executeUpdate();
/* 143 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 146 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 147 */       CError tError = new CError();
/* 148 */       tError.moduleName = "LNPComDB";
/* 149 */       tError.functionName = "update()";
/* 150 */       tError.errorMessage = ex.toString();
/* 151 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 154 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 157 */       if (!this.mflag)
/*     */         try {
/* 159 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 163 */       return false;
/*     */     }
/*     */ 
/* 166 */     if (!this.mflag)
/*     */       try {
/* 168 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 172 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 177 */     PreparedStatement pstmt = null;
/*     */ 
/* 179 */     if (!this.mflag) {
/* 180 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 185 */       pstmt = this.con.prepareStatement("INSERT INTO LNPCom VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*     */ 
/* 187 */       pstmt.executeUpdate();
/* 188 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 191 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 192 */       CError tError = new CError();
/* 193 */       tError.moduleName = "LNPComDB";
/* 194 */       tError.functionName = "insert()";
/* 195 */       tError.errorMessage = ex.toString();
/* 196 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 199 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 202 */       if (!this.mflag)
/*     */         try {
/* 204 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 208 */       return false;
/*     */     }
/*     */ 
/* 211 */     if (!this.mflag)
/*     */       try {
/* 213 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 217 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean getInfo()
/*     */   {
/* 222 */     PreparedStatement pstmt = null;
/* 223 */     ResultSet rs = null;
/*     */ 
/* 225 */     if (!this.mflag) {
/* 226 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 231 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPCom WHERE ", 
/* 232 */         1003, 1007);
/* 233 */       rs = pstmt.executeQuery();
/* 234 */       int i = 0;
/* 235 */       if (rs.next())
/*     */       {
/* 237 */         i++;
/* 238 */         if (!setSchema(rs, i))
/*     */         {
/* 241 */           CError tError = new CError();
/* 242 */           tError.moduleName = "LNPComDB";
/* 243 */           tError.functionName = "getInfo";
/* 244 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/* 245 */           this.mErrors.addOneError(tError);
/*     */           try {
/* 247 */             rs.close(); } catch (Exception localException1) {
/*     */           }try { pstmt.close(); } catch (Exception localException2) {
/*     */           }
/* 250 */           if (!this.mflag)
/*     */           {
/*     */             try
/*     */             {
/* 254 */               this.con.close();
/*     */             } catch (Exception localException3) {
/*     */             }
/*     */           }
/* 258 */           return false;
/*     */         }
/*     */       }
/*     */       try {
/* 262 */         rs.close(); } catch (Exception localException4) {
/*     */       }try { pstmt.close(); } catch (Exception localException5) {
/*     */       }
/* 265 */       if (i == 0)
/*     */       {
/* 267 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 271 */             this.con.close();
/*     */           } catch (Exception localException6) {
/*     */           }
/*     */         }
/* 275 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 281 */       CError tError = new CError();
/* 282 */       tError.moduleName = "LNPComDB";
/* 283 */       tError.functionName = "getInfo";
/* 284 */       tError.errorMessage = e.toString();
/* 285 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 287 */         rs.close(); } catch (Exception localException7) {
/*     */       }try { pstmt.close(); } catch (Exception localException8) {
/*     */       }
/* 290 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 294 */           this.con.close();
/*     */         } catch (Exception localException9) {
/*     */         }
/*     */       }
/* 298 */       return false;
/*     */     }
/*     */ 
/* 301 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 305 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException10) {
/*     */       }
/*     */     }
/* 310 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPComSet query()
/*     */   {
/* 315 */     Statement stmt = null;
/* 316 */     ResultSet rs = null;
/* 317 */     LNPComSet aLNPComSet = new LNPComSet();
/*     */ 
/* 319 */     if (!this.mflag) {
/* 320 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 325 */       stmt = this.con.createStatement(1003, 1007);
/* 326 */       SQLString sqlObj = new SQLString("LNPCom");
/* 327 */       LNPComSchema aSchema = getSchema();
/* 328 */       sqlObj.setSQL(5, aSchema);
/* 329 */       String sql = sqlObj.getSQL();
/*     */ 
/* 331 */       rs = stmt.executeQuery(sql);
/* 332 */       int i = 0;
/* 333 */       while (rs.next())
/*     */       {
/* 335 */         i++;
/* 336 */         LNPComSchema s1 = new LNPComSchema();
/* 337 */         s1.setSchema(rs, i);
/* 338 */         aLNPComSet.add(s1);
/*     */       }try {
/* 340 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 346 */       CError tError = new CError();
/* 347 */       tError.moduleName = "LNPComDB";
/* 348 */       tError.functionName = "query";
/* 349 */       tError.errorMessage = e.toString();
/* 350 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 352 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 355 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 359 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 365 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 369 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 374 */     return aLNPComSet;
/*     */   }
/*     */ 
/*     */   public LNPComSet executeQuery(String sql)
/*     */   {
/* 379 */     Statement stmt = null;
/* 380 */     ResultSet rs = null;
/* 381 */     LNPComSet aLNPComSet = new LNPComSet();
/*     */ 
/* 383 */     if (!this.mflag) {
/* 384 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 389 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 391 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 392 */       int i = 0;
/* 393 */       while (rs.next())
/*     */       {
/* 395 */         i++;
/* 396 */         LNPComSchema s1 = new LNPComSchema();
/* 397 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 400 */           CError tError = new CError();
/* 401 */           tError.moduleName = "LNPComDB";
/* 402 */           tError.functionName = "executeQuery";
/* 403 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/* 404 */           this.mErrors.addOneError(tError);
/*     */         }
/* 406 */         aLNPComSet.add(s1);
/*     */       }try {
/* 408 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 414 */       CError tError = new CError();
/* 415 */       tError.moduleName = "LNPComDB";
/* 416 */       tError.functionName = "executeQuery";
/* 417 */       tError.errorMessage = e.toString();
/* 418 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 420 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 423 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 427 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 433 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 437 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 442 */     return aLNPComSet;
/*     */   }
/*     */ 
/*     */   public LNPComSet query(int nStart, int nCount)
/*     */   {
/* 447 */     Statement stmt = null;
/* 448 */     ResultSet rs = null;
/* 449 */     LNPComSet aLNPComSet = new LNPComSet();
/*     */ 
/* 451 */     if (!this.mflag) {
/* 452 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 457 */       stmt = this.con.createStatement(1003, 1007);
/* 458 */       SQLString sqlObj = new SQLString("LNPCom");
/* 459 */       LNPComSchema aSchema = getSchema();
/* 460 */       sqlObj.setSQL(5, aSchema);
/* 461 */       String sql = sqlObj.getSQL();
/*     */ 
/* 463 */       rs = stmt.executeQuery(sql);
/* 464 */       int i = 0;
/* 465 */       while (rs.next())
/*     */       {
/* 467 */         i++;
/*     */ 
/* 469 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 473 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 477 */         LNPComSchema s1 = new LNPComSchema();
/* 478 */         s1.setSchema(rs, i);
/* 479 */         aLNPComSet.add(s1);
/*     */       }try {
/* 481 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 487 */       CError tError = new CError();
/* 488 */       tError.moduleName = "LNPComDB";
/* 489 */       tError.functionName = "query";
/* 490 */       tError.errorMessage = e.toString();
/* 491 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 493 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 496 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 500 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 506 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 510 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 515 */     return aLNPComSet;
/*     */   }
/*     */ 
/*     */   public LNPComSet executeQuery(String sql, int nStart, int nCount)
/*     */   {
/* 520 */     Statement stmt = null;
/* 521 */     ResultSet rs = null;
/* 522 */     LNPComSet aLNPComSet = new LNPComSet();
/*     */ 
/* 524 */     if (!this.mflag) {
/* 525 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 530 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 532 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 533 */       int i = 0;
/* 534 */       while (rs.next())
/*     */       {
/* 536 */         i++;
/*     */ 
/* 538 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 542 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 546 */         LNPComSchema s1 = new LNPComSchema();
/* 547 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 550 */           CError tError = new CError();
/* 551 */           tError.moduleName = "LNPComDB";
/* 552 */           tError.functionName = "executeQuery";
/* 553 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/* 554 */           this.mErrors.addOneError(tError);
/*     */         }
/* 556 */         aLNPComSet.add(s1);
/*     */       }try {
/* 558 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 564 */       CError tError = new CError();
/* 565 */       tError.moduleName = "LNPComDB";
/* 566 */       tError.functionName = "executeQuery";
/* 567 */       tError.errorMessage = e.toString();
/* 568 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 570 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 573 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 577 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 583 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 587 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 592 */     return aLNPComSet;
/*     */   }
/*     */ 
/*     */   public boolean update(String strWherePart)
/*     */   {
/* 597 */     Statement stmt = null;
/*     */ 
/* 599 */     if (!this.mflag) {
/* 600 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 605 */       stmt = this.con.createStatement(1003, 1007);
/* 606 */       SQLString sqlObj = new SQLString("LNPCom");
/* 607 */       LNPComSchema aSchema = getSchema();
/* 608 */       sqlObj.setSQL(2, aSchema);
/* 609 */       String sql = "update LNPCom " + sqlObj.getUpdPart() + " where " + strWherePart;
/*     */ 
/* 611 */       int operCount = stmt.executeUpdate(sql);
/* 612 */       if (operCount == 0)
/*     */       {
/* 615 */         CError tError = new CError();
/* 616 */         tError.moduleName = "LNPComDB";
/* 617 */         tError.functionName = "update";
/* 618 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/* 619 */         this.mErrors.addOneError(tError);
/*     */ 
/* 621 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 625 */             this.con.close();
/*     */           } catch (Exception localException1) {
/*     */           }
/*     */         }
/* 629 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 635 */       CError tError = new CError();
/* 636 */       tError.moduleName = "LNPComDB";
/* 637 */       tError.functionName = "update";
/* 638 */       tError.errorMessage = e.toString();
/* 639 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 641 */         stmt.close(); } catch (Exception localException2) {
/*     */       }
/* 643 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 647 */           this.con.close();
/*     */         } catch (Exception localException3) {
/*     */         }
/*     */       }
/* 651 */       return false;
/*     */     }
/*     */ 
/* 654 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 658 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException4) {
/*     */       }
/*     */     }
/* 663 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean prepareData(String strSQL)
/*     */   {
/* 669 */     if (this.mResultSet != null)
/*     */     {
/* 672 */       CError tError = new CError();
/* 673 */       tError.moduleName = "LNPComDB";
/* 674 */       tError.functionName = "prepareData";
/* 675 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/* 676 */       this.mErrors.addOneError(tError);
/* 677 */       return false;
/*     */     }
/*     */ 
/* 680 */     if (!this.mflag)
/*     */     {
/* 682 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */     try
/*     */     {
/* 686 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 687 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 692 */       CError tError = new CError();
/* 693 */       tError.moduleName = "LNPComDB";
/* 694 */       tError.functionName = "prepareData";
/* 695 */       tError.errorMessage = e.toString();
/* 696 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 699 */         this.mResultSet.close();
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 705 */         this.mStatement.close();
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 709 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 713 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 718 */       return false;
/*     */     }
/*     */ 
/* 721 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 725 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException4) {
/*     */       }
/*     */     }
/* 730 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean hasMoreData()
/*     */   {
/* 736 */     boolean flag = true;
/* 737 */     if (this.mResultSet == null)
/*     */     {
/* 739 */       CError tError = new CError();
/* 740 */       tError.moduleName = "LNPComDB";
/* 741 */       tError.functionName = "hasMoreData";
/* 742 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 743 */       this.mErrors.addOneError(tError);
/* 744 */       return false;
/*     */     }
/*     */     try
/*     */     {
/* 748 */       flag = this.mResultSet.next();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 752 */       CError tError = new CError();
/* 753 */       tError.moduleName = "LNPComDB";
/* 754 */       tError.functionName = "hasMoreData";
/* 755 */       tError.errorMessage = ex.toString();
/* 756 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 759 */         this.mResultSet.close();
/* 760 */         this.mResultSet = null;
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 766 */         this.mStatement.close();
/* 767 */         this.mStatement = null;
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 771 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 775 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 780 */       return false;
/*     */     }
/* 782 */     return flag;
/*     */   }
/*     */ 
/*     */   public LNPComSet getData()
/*     */   {
/* 787 */     int tCount = 0;
/* 788 */     LNPComSet tLNPComSet = new LNPComSet();
/* 789 */     LNPComSchema tLNPComSchema = null;
/* 790 */     if (this.mResultSet == null)
/*     */     {
/* 792 */       CError tError = new CError();
/* 793 */       tError.moduleName = "LNPComDB";
/* 794 */       tError.functionName = "getData";
/* 795 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 796 */       this.mErrors.addOneError(tError);
/* 797 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 801 */       tCount = 1;
/* 802 */       tLNPComSchema = new LNPComSchema();
/* 803 */       tLNPComSchema.setSchema(this.mResultSet, 1);
/* 804 */       tLNPComSet.add(tLNPComSchema);
/*     */ 
/* 806 */       while (tCount++ < 5000)
/*     */       {
/* 808 */         if (!this.mResultSet.next())
/*     */           continue;
/* 810 */         tLNPComSchema = new LNPComSchema();
/* 811 */         tLNPComSchema.setSchema(this.mResultSet, 1);
/* 812 */         tLNPComSet.add(tLNPComSchema);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 818 */       CError tError = new CError();
/* 819 */       tError.moduleName = "LNPComDB";
/* 820 */       tError.functionName = "getData";
/* 821 */       tError.errorMessage = ex.toString();
/* 822 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 825 */         this.mResultSet.close();
/* 826 */         this.mResultSet = null;
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 832 */         this.mStatement.close();
/* 833 */         this.mStatement = null;
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 837 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 841 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 846 */       return null;
/*     */     }
/* 848 */     return tLNPComSet;
/*     */   }
/*     */ 
/*     */   public boolean closeData()
/*     */   {
/* 853 */     boolean flag = true;
/*     */     try
/*     */     {
/* 856 */       if (this.mResultSet == null)
/*     */       {
/* 858 */         CError tError = new CError();
/* 859 */         tError.moduleName = "LNPComDB";
/* 860 */         tError.functionName = "closeData";
/* 861 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 862 */         this.mErrors.addOneError(tError);
/* 863 */         flag = false;
/*     */       }
/*     */       else
/*     */       {
/* 867 */         this.mResultSet.close();
/* 868 */         this.mResultSet = null;
/*     */       }
/*     */     }
/*     */     catch (Exception ex2)
/*     */     {
/* 873 */       CError tError = new CError();
/* 874 */       tError.moduleName = "LNPComDB";
/* 875 */       tError.functionName = "closeData";
/* 876 */       tError.errorMessage = ex2.toString();
/* 877 */       this.mErrors.addOneError(tError);
/* 878 */       flag = false;
/*     */     }
/*     */     try
/*     */     {
/* 882 */       if (this.mStatement == null)
/*     */       {
/* 884 */         CError tError = new CError();
/* 885 */         tError.moduleName = "LNPComDB";
/* 886 */         tError.functionName = "closeData";
/* 887 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 888 */         this.mErrors.addOneError(tError);
/* 889 */         flag = false;
/*     */       }
/*     */       else
/*     */       {
/* 893 */         this.mStatement.close();
/* 894 */         this.mStatement = null;
/*     */       }
/*     */     }
/*     */     catch (Exception ex3)
/*     */     {
/* 899 */       CError tError = new CError();
/* 900 */       tError.moduleName = "LNPComDB";
/* 901 */       tError.functionName = "closeData";
/* 902 */       tError.errorMessage = ex3.toString();
/* 903 */       this.mErrors.addOneError(tError);
/* 904 */       flag = false;
/*     */     }
/* 906 */     return flag;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPComDB
 * JD-Core Version:    0.6.0
 */