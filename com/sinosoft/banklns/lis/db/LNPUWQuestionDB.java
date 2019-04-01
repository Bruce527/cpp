/*     */ package com.sinosoft.banklns.lis.db;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPUWQuestionSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPUWQuestionSet;
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
/*     */ public class LNPUWQuestionDB extends LNPUWQuestionSchema
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
/*     */   public LNPUWQuestionDB(Connection tConnection)
/*     */   {
/*  32 */     this.con = tConnection;
/*  33 */     this.db = new DBOper(this.con, "LNPUWQuestion");
/*  34 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPUWQuestionDB()
/*     */   {
/*  39 */     this.con = null;
/*  40 */     this.db = new DBOper("LNPUWQuestion");
/*  41 */     this.mflag = false;
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  47 */     LNPUWQuestionSchema tSchema = getSchema();
/*  48 */     if (this.db.deleteSQL(tSchema))
/*     */     {
/*  50 */       return true;
/*     */     }
/*     */ 
/*  55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*  56 */     CError tError = new CError();
/*  57 */     tError.moduleName = "LNPUWQuestionDB";
/*  58 */     tError.functionName = "deleteSQL";
/*  59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*  60 */     this.mErrors.addOneError(tError);
/*  61 */     return false;
/*     */   }
/*     */ 
/*     */   public int getCount()
/*     */   {
/*  67 */     LNPUWQuestionSchema tSchema = getSchema();
/*     */ 
/*  69 */     int tCount = this.db.getCount(tSchema);
/*  70 */     if (tCount < 0)
/*     */     {
/*  73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  74 */       CError tError = new CError();
/*  75 */       tError.moduleName = "LNPUWQuestionDB";
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
/*  96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPUWQuestion WHERE  ContNo = ?");
/*  97 */       if ((getContNo() == null) || (getContNo().equals("null")))
/*  98 */         pstmt.setNull(1, 12);
/*     */       else {
/* 100 */         pstmt.setString(1, getContNo());
/*     */       }
/* 102 */       pstmt.executeUpdate();
/* 103 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 106 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 107 */       CError tError = new CError();
/* 108 */       tError.moduleName = "LNPUWQuestionDB";
/* 109 */       tError.functionName = "delete()";
/* 110 */       tError.errorMessage = ex.toString();
/* 111 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 114 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 117 */       if (!this.mflag)
/*     */         try {
/* 119 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 123 */       return false;
/*     */     }
/*     */ 
/* 126 */     if (!this.mflag)
/*     */       try {
/* 128 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 132 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 137 */     PreparedStatement pstmt = null;
/*     */ 
/* 139 */     if (!this.mflag) {
/* 140 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 145 */       pstmt = this.con.prepareStatement("UPDATE LNPUWQuestion SET  ContNo = ? , URL = ? WHERE  ContNo = ?");
/* 146 */       if ((getContNo() == null) || (getContNo().equals("null")))
/* 147 */         pstmt.setNull(1, 12);
/*     */       else {
/* 149 */         pstmt.setString(1, getContNo());
/*     */       }
/* 151 */       if ((getURL() == null) || (getURL().equals("null")))
/* 152 */         pstmt.setNull(2, 12);
/*     */       else {
/* 154 */         pstmt.setString(2, getURL());
/*     */       }
/*     */ 
/* 157 */       if ((getContNo() == null) || (getContNo().equals("null")))
/* 158 */         pstmt.setNull(3, 12);
/*     */       else {
/* 160 */         pstmt.setString(3, getContNo());
/*     */       }
/* 162 */       pstmt.executeUpdate();
/* 163 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 166 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 167 */       CError tError = new CError();
/* 168 */       tError.moduleName = "LNPUWQuestionDB";
/* 169 */       tError.functionName = "update()";
/* 170 */       tError.errorMessage = ex.toString();
/* 171 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 174 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 177 */       if (!this.mflag)
/*     */         try {
/* 179 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 183 */       return false;
/*     */     }
/*     */ 
/* 186 */     if (!this.mflag)
/*     */       try {
/* 188 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 192 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 197 */     PreparedStatement pstmt = null;
/*     */ 
/* 199 */     if (!this.mflag) {
/* 200 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 205 */       pstmt = this.con.prepareStatement("INSERT INTO LNPUWQuestion VALUES( ? , ?)");
/* 206 */       if ((getContNo() == null) || (getContNo().equals("null")))
/* 207 */         pstmt.setNull(1, 12);
/*     */       else {
/* 209 */         pstmt.setString(1, getContNo());
/*     */       }
/* 211 */       if ((getURL() == null) || (getURL().equals("null")))
/* 212 */         pstmt.setNull(2, 12);
/*     */       else {
/* 214 */         pstmt.setString(2, getURL());
/*     */       }
/*     */ 
/* 217 */       pstmt.executeUpdate();
/* 218 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 221 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 222 */       CError tError = new CError();
/* 223 */       tError.moduleName = "LNPUWQuestionDB";
/* 224 */       tError.functionName = "insert()";
/* 225 */       tError.errorMessage = ex.toString();
/* 226 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 229 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 232 */       if (!this.mflag)
/*     */         try {
/* 234 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 238 */       return false;
/*     */     }
/*     */ 
/* 241 */     if (!this.mflag)
/*     */       try {
/* 243 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 247 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean getInfo()
/*     */   {
/* 252 */     PreparedStatement pstmt = null;
/* 253 */     ResultSet rs = null;
/*     */ 
/* 255 */     if (!this.mflag) {
/* 256 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 261 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPUWQuestion WHERE  ContNo = ?", 
/* 262 */         1003, 1007);
/* 263 */       if ((getContNo() == null) || (getContNo().equals("null")))
/* 264 */         pstmt.setNull(1, 12);
/*     */       else {
/* 266 */         pstmt.setString(1, getContNo());
/*     */       }
/* 268 */       rs = pstmt.executeQuery();
/* 269 */       int i = 0;
/* 270 */       if (rs.next())
/*     */       {
/* 272 */         i++;
/* 273 */         if (!setSchema(rs, i))
/*     */         {
/* 276 */           CError tError = new CError();
/* 277 */           tError.moduleName = "LNPUWQuestionDB";
/* 278 */           tError.functionName = "getInfo";
/* 279 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/* 280 */           this.mErrors.addOneError(tError);
/*     */           try {
/* 282 */             rs.close(); } catch (Exception localException1) {
/*     */           }try { pstmt.close(); } catch (Exception localException2) {
/*     */           }
/* 285 */           if (!this.mflag)
/*     */           {
/*     */             try
/*     */             {
/* 289 */               this.con.close();
/*     */             } catch (Exception localException3) {
/*     */             }
/*     */           }
/* 293 */           return false;
/*     */         }
/*     */       }
/*     */       try {
/* 297 */         rs.close(); } catch (Exception localException4) {
/*     */       }try { pstmt.close(); } catch (Exception localException5) {
/*     */       }
/* 300 */       if (i == 0)
/*     */       {
/* 302 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 306 */             this.con.close();
/*     */           } catch (Exception localException6) {
/*     */           }
/*     */         }
/* 310 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 316 */       CError tError = new CError();
/* 317 */       tError.moduleName = "LNPUWQuestionDB";
/* 318 */       tError.functionName = "getInfo";
/* 319 */       tError.errorMessage = e.toString();
/* 320 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 322 */         rs.close(); } catch (Exception localException7) {
/*     */       }try { pstmt.close(); } catch (Exception localException8) {
/*     */       }
/* 325 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 329 */           this.con.close();
/*     */         } catch (Exception localException9) {
/*     */         }
/*     */       }
/* 333 */       return false;
/*     */     }
/*     */ 
/* 336 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 340 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException10) {
/*     */       }
/*     */     }
/* 345 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPUWQuestionSet query()
/*     */   {
/* 350 */     Statement stmt = null;
/* 351 */     ResultSet rs = null;
/* 352 */     LNPUWQuestionSet aLNPUWQuestionSet = new LNPUWQuestionSet();
/*     */ 
/* 354 */     if (!this.mflag) {
/* 355 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 360 */       stmt = this.con.createStatement(1003, 1007);
/* 361 */       SQLString sqlObj = new SQLString("LNPUWQuestion");
/* 362 */       LNPUWQuestionSchema aSchema = getSchema();
/* 363 */       sqlObj.setSQL(5, aSchema);
/* 364 */       String sql = sqlObj.getSQL();
/*     */ 
/* 366 */       rs = stmt.executeQuery(sql);
/* 367 */       int i = 0;
/* 368 */       while (rs.next())
/*     */       {
/* 370 */         i++;
/* 371 */         LNPUWQuestionSchema s1 = new LNPUWQuestionSchema();
/* 372 */         s1.setSchema(rs, i);
/* 373 */         aLNPUWQuestionSet.add(s1);
/*     */       }try {
/* 375 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 381 */       CError tError = new CError();
/* 382 */       tError.moduleName = "LNPUWQuestionDB";
/* 383 */       tError.functionName = "query";
/* 384 */       tError.errorMessage = e.toString();
/* 385 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 387 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 390 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 394 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 400 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 404 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 409 */     return aLNPUWQuestionSet;
/*     */   }
/*     */ 
/*     */   public LNPUWQuestionSet executeQuery(String sql)
/*     */   {
/* 414 */     Statement stmt = null;
/* 415 */     ResultSet rs = null;
/* 416 */     LNPUWQuestionSet aLNPUWQuestionSet = new LNPUWQuestionSet();
/*     */ 
/* 418 */     if (!this.mflag) {
/* 419 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 424 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 426 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 427 */       int i = 0;
/* 428 */       while (rs.next())
/*     */       {
/* 430 */         i++;
/* 431 */         LNPUWQuestionSchema s1 = new LNPUWQuestionSchema();
/* 432 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 435 */           CError tError = new CError();
/* 436 */           tError.moduleName = "LNPUWQuestionDB";
/* 437 */           tError.functionName = "executeQuery";
/* 438 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/* 439 */           this.mErrors.addOneError(tError);
/*     */         }
/* 441 */         aLNPUWQuestionSet.add(s1);
/*     */       }try {
/* 443 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 449 */       CError tError = new CError();
/* 450 */       tError.moduleName = "LNPUWQuestionDB";
/* 451 */       tError.functionName = "executeQuery";
/* 452 */       tError.errorMessage = e.toString();
/* 453 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 455 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 458 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 462 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 468 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 472 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 477 */     return aLNPUWQuestionSet;
/*     */   }
/*     */ 
/*     */   public LNPUWQuestionSet query(int nStart, int nCount)
/*     */   {
/* 482 */     Statement stmt = null;
/* 483 */     ResultSet rs = null;
/* 484 */     LNPUWQuestionSet aLNPUWQuestionSet = new LNPUWQuestionSet();
/*     */ 
/* 486 */     if (!this.mflag) {
/* 487 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 492 */       stmt = this.con.createStatement(1003, 1007);
/* 493 */       SQLString sqlObj = new SQLString("LNPUWQuestion");
/* 494 */       LNPUWQuestionSchema aSchema = getSchema();
/* 495 */       sqlObj.setSQL(5, aSchema);
/* 496 */       String sql = sqlObj.getSQL();
/*     */ 
/* 498 */       rs = stmt.executeQuery(sql);
/* 499 */       int i = 0;
/* 500 */       while (rs.next())
/*     */       {
/* 502 */         i++;
/*     */ 
/* 504 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 508 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 512 */         LNPUWQuestionSchema s1 = new LNPUWQuestionSchema();
/* 513 */         s1.setSchema(rs, i);
/* 514 */         aLNPUWQuestionSet.add(s1);
/*     */       }try {
/* 516 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 522 */       CError tError = new CError();
/* 523 */       tError.moduleName = "LNPUWQuestionDB";
/* 524 */       tError.functionName = "query";
/* 525 */       tError.errorMessage = e.toString();
/* 526 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 528 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 531 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 535 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 541 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 545 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 550 */     return aLNPUWQuestionSet;
/*     */   }
/*     */ 
/*     */   public LNPUWQuestionSet executeQuery(String sql, int nStart, int nCount)
/*     */   {
/* 555 */     Statement stmt = null;
/* 556 */     ResultSet rs = null;
/* 557 */     LNPUWQuestionSet aLNPUWQuestionSet = new LNPUWQuestionSet();
/*     */ 
/* 559 */     if (!this.mflag) {
/* 560 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 565 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 567 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 568 */       int i = 0;
/* 569 */       while (rs.next())
/*     */       {
/* 571 */         i++;
/*     */ 
/* 573 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 577 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 581 */         LNPUWQuestionSchema s1 = new LNPUWQuestionSchema();
/* 582 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 585 */           CError tError = new CError();
/* 586 */           tError.moduleName = "LNPUWQuestionDB";
/* 587 */           tError.functionName = "executeQuery";
/* 588 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/* 589 */           this.mErrors.addOneError(tError);
/*     */         }
/* 591 */         aLNPUWQuestionSet.add(s1);
/*     */       }try {
/* 593 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 599 */       CError tError = new CError();
/* 600 */       tError.moduleName = "LNPUWQuestionDB";
/* 601 */       tError.functionName = "executeQuery";
/* 602 */       tError.errorMessage = e.toString();
/* 603 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 605 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 608 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 612 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 618 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 622 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 627 */     return aLNPUWQuestionSet;
/*     */   }
/*     */ 
/*     */   public boolean update(String strWherePart)
/*     */   {
/* 632 */     Statement stmt = null;
/*     */ 
/* 634 */     if (!this.mflag) {
/* 635 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 640 */       stmt = this.con.createStatement(1003, 1007);
/* 641 */       SQLString sqlObj = new SQLString("LNPUWQuestion");
/* 642 */       LNPUWQuestionSchema aSchema = getSchema();
/* 643 */       sqlObj.setSQL(2, aSchema);
/* 644 */       String sql = "update LNPUWQuestion " + sqlObj.getUpdPart() + " where " + strWherePart;
/*     */ 
/* 646 */       int operCount = stmt.executeUpdate(sql);
/* 647 */       if (operCount == 0)
/*     */       {
/* 650 */         CError tError = new CError();
/* 651 */         tError.moduleName = "LNPUWQuestionDB";
/* 652 */         tError.functionName = "update";
/* 653 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/* 654 */         this.mErrors.addOneError(tError);
/*     */ 
/* 656 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 660 */             this.con.close();
/*     */           } catch (Exception localException1) {
/*     */           }
/*     */         }
/* 664 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 670 */       CError tError = new CError();
/* 671 */       tError.moduleName = "LNPUWQuestionDB";
/* 672 */       tError.functionName = "update";
/* 673 */       tError.errorMessage = e.toString();
/* 674 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 676 */         stmt.close(); } catch (Exception localException2) {
/*     */       }
/* 678 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 682 */           this.con.close();
/*     */         } catch (Exception localException3) {
/*     */         }
/*     */       }
/* 686 */       return false;
/*     */     }
/*     */ 
/* 689 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 693 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException4) {
/*     */       }
/*     */     }
/* 698 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean prepareData(String strSQL)
/*     */   {
/* 704 */     if (this.mResultSet != null)
/*     */     {
/* 707 */       CError tError = new CError();
/* 708 */       tError.moduleName = "LNPUWQuestionDB";
/* 709 */       tError.functionName = "prepareData";
/* 710 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/* 711 */       this.mErrors.addOneError(tError);
/* 712 */       return false;
/*     */     }
/*     */ 
/* 715 */     if (!this.mflag)
/*     */     {
/* 717 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */     try
/*     */     {
/* 721 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 722 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 727 */       CError tError = new CError();
/* 728 */       tError.moduleName = "LNPUWQuestionDB";
/* 729 */       tError.functionName = "prepareData";
/* 730 */       tError.errorMessage = e.toString();
/* 731 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 734 */         this.mResultSet.close();
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 740 */         this.mStatement.close();
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 744 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 748 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 753 */       return false;
/*     */     }
/*     */ 
/* 756 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 760 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException4) {
/*     */       }
/*     */     }
/* 765 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean hasMoreData()
/*     */   {
/* 771 */     boolean flag = true;
/* 772 */     if (this.mResultSet == null)
/*     */     {
/* 774 */       CError tError = new CError();
/* 775 */       tError.moduleName = "LNPUWQuestionDB";
/* 776 */       tError.functionName = "hasMoreData";
/* 777 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 778 */       this.mErrors.addOneError(tError);
/* 779 */       return false;
/*     */     }
/*     */     try
/*     */     {
/* 783 */       flag = this.mResultSet.next();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 787 */       CError tError = new CError();
/* 788 */       tError.moduleName = "LNPUWQuestionDB";
/* 789 */       tError.functionName = "hasMoreData";
/* 790 */       tError.errorMessage = ex.toString();
/* 791 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 794 */         this.mResultSet.close();
/* 795 */         this.mResultSet = null;
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 801 */         this.mStatement.close();
/* 802 */         this.mStatement = null;
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 806 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 810 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 815 */       return false;
/*     */     }
/* 817 */     return flag;
/*     */   }
/*     */ 
/*     */   public LNPUWQuestionSet getData()
/*     */   {
/* 822 */     int tCount = 0;
/* 823 */     LNPUWQuestionSet tLNPUWQuestionSet = new LNPUWQuestionSet();
/* 824 */     LNPUWQuestionSchema tLNPUWQuestionSchema = null;
/* 825 */     if (this.mResultSet == null)
/*     */     {
/* 827 */       CError tError = new CError();
/* 828 */       tError.moduleName = "LNPUWQuestionDB";
/* 829 */       tError.functionName = "getData";
/* 830 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 831 */       this.mErrors.addOneError(tError);
/* 832 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 836 */       tCount = 1;
/* 837 */       tLNPUWQuestionSchema = new LNPUWQuestionSchema();
/* 838 */       tLNPUWQuestionSchema.setSchema(this.mResultSet, 1);
/* 839 */       tLNPUWQuestionSet.add(tLNPUWQuestionSchema);
/*     */ 
/* 841 */       while (tCount++ < 5000)
/*     */       {
/* 843 */         if (!this.mResultSet.next())
/*     */           continue;
/* 845 */         tLNPUWQuestionSchema = new LNPUWQuestionSchema();
/* 846 */         tLNPUWQuestionSchema.setSchema(this.mResultSet, 1);
/* 847 */         tLNPUWQuestionSet.add(tLNPUWQuestionSchema);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 853 */       CError tError = new CError();
/* 854 */       tError.moduleName = "LNPUWQuestionDB";
/* 855 */       tError.functionName = "getData";
/* 856 */       tError.errorMessage = ex.toString();
/* 857 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 860 */         this.mResultSet.close();
/* 861 */         this.mResultSet = null;
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 867 */         this.mStatement.close();
/* 868 */         this.mStatement = null;
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 872 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 876 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 881 */       return null;
/*     */     }
/* 883 */     return tLNPUWQuestionSet;
/*     */   }
/*     */ 
/*     */   public boolean closeData()
/*     */   {
/* 888 */     boolean flag = true;
/*     */     try
/*     */     {
/* 891 */       if (this.mResultSet == null)
/*     */       {
/* 893 */         CError tError = new CError();
/* 894 */         tError.moduleName = "LNPUWQuestionDB";
/* 895 */         tError.functionName = "closeData";
/* 896 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 897 */         this.mErrors.addOneError(tError);
/* 898 */         flag = false;
/*     */       }
/*     */       else
/*     */       {
/* 902 */         this.mResultSet.close();
/* 903 */         this.mResultSet = null;
/*     */       }
/*     */     }
/*     */     catch (Exception ex2)
/*     */     {
/* 908 */       CError tError = new CError();
/* 909 */       tError.moduleName = "LNPUWQuestionDB";
/* 910 */       tError.functionName = "closeData";
/* 911 */       tError.errorMessage = ex2.toString();
/* 912 */       this.mErrors.addOneError(tError);
/* 913 */       flag = false;
/*     */     }
/*     */     try
/*     */     {
/* 917 */       if (this.mStatement == null)
/*     */       {
/* 919 */         CError tError = new CError();
/* 920 */         tError.moduleName = "LNPUWQuestionDB";
/* 921 */         tError.functionName = "closeData";
/* 922 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 923 */         this.mErrors.addOneError(tError);
/* 924 */         flag = false;
/*     */       }
/*     */       else
/*     */       {
/* 928 */         this.mStatement.close();
/* 929 */         this.mStatement = null;
/*     */       }
/*     */     }
/*     */     catch (Exception ex3)
/*     */     {
/* 934 */       CError tError = new CError();
/* 935 */       tError.moduleName = "LNPUWQuestionDB";
/* 936 */       tError.functionName = "closeData";
/* 937 */       tError.errorMessage = ex3.toString();
/* 938 */       this.mErrors.addOneError(tError);
/* 939 */       flag = false;
/*     */     }
/* 941 */     return flag;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPUWQuestionDB
 * JD-Core Version:    0.6.0
 */