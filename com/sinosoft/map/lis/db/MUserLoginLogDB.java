/*     */ package com.sinosoft.map.lis.db;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MUserLoginLogSchema;
/*     */ import com.sinosoft.map.lis.vschema.MUserLoginLogSet;
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
/*     */ public class MUserLoginLogDB extends MUserLoginLogSchema
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*  23 */   public CErrors mErrors = new CErrors();
/*     */ 
/*  25 */   private ResultSet mResultSet = null;
/*  26 */   private Statement mStatement = null;
/*     */ 
/*     */   public MUserLoginLogDB(Connection tConnection)
/*     */   {
/*  30 */     this.con = tConnection;
/*  31 */     this.db = new DBOper(this.con, "MUserLoginLog");
/*  32 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MUserLoginLogDB()
/*     */   {
/*  37 */     this.con = null;
/*  38 */     this.db = new DBOper("MUserLoginLog");
/*  39 */     this.mflag = false;
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  45 */     MUserLoginLogSchema tSchema = getSchema();
/*  46 */     if (this.db.deleteSQL(tSchema))
/*     */     {
/*  48 */       return true;
/*     */     }
/*     */ 
/*  53 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*  54 */     CError tError = new CError();
/*  55 */     tError.moduleName = "MUserLoginLogDB";
/*  56 */     tError.functionName = "deleteSQL";
/*  57 */     tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  58 */     this.mErrors.addOneError(tError);
/*  59 */     return false;
/*     */   }
/*     */ 
/*     */   public int getCount()
/*     */   {
/*  65 */     MUserLoginLogSchema tSchema = getSchema();
/*     */ 
/*  67 */     int tCount = this.db.getCount(tSchema);
/*  68 */     if (tCount < 0)
/*     */     {
/*  71 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  72 */       CError tError = new CError();
/*  73 */       tError.moduleName = "MUserLoginLogDB";
/*  74 */       tError.functionName = "getCount";
/*  75 */       tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  76 */       this.mErrors.addOneError(tError);
/*     */ 
/*  78 */       return -1;
/*     */     }
/*     */ 
/*  81 */     return tCount;
/*     */   }
/*     */ 
/*     */   public boolean delete()
/*     */   {
/*  86 */     PreparedStatement pstmt = null;
/*     */ 
/*  88 */     if (!this.mflag) {
/*  89 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  94 */       pstmt = this.con.prepareStatement("DELETE FROM MUserLoginLog WHERE  ID = ?");
/*  95 */       if ((getID() == null) || (getID().equals("null")))
/*  96 */         pstmt.setNull(1, 12);
/*     */       else {
/*  98 */         pstmt.setString(1, getID());
/*     */       }
/* 100 */       pstmt.executeUpdate();
/* 101 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 104 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 105 */       CError tError = new CError();
/* 106 */       tError.moduleName = "MUserLoginLogDB";
/* 107 */       tError.functionName = "delete()";
/* 108 */       tError.errorMessage = ex.toString();
/* 109 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 112 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 115 */       if (!this.mflag)
/*     */         try {
/* 117 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 121 */       return false;
/*     */     }
/*     */ 
/* 124 */     if (!this.mflag)
/*     */       try {
/* 126 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 130 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 135 */     PreparedStatement pstmt = null;
/*     */ 
/* 137 */     if (!this.mflag) {
/* 138 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 143 */       pstmt = this.con.prepareStatement("UPDATE MUserLoginLog SET  ID = ? , UserCode = ? , UserType = ? , ClientName = ? , ClientType = ? , ClientIP = ? , LoginDate = ? , LoginTime = ? , LogoutDate = ? , LogoutTime = ? WHERE  ID = ?");
/* 144 */       if ((getID() == null) || (getID().equals("null")))
/* 145 */         pstmt.setNull(1, 12);
/*     */       else {
/* 147 */         pstmt.setString(1, getID());
/*     */       }
/* 149 */       if ((getUserCode() == null) || (getUserCode().equals("null")))
/* 150 */         pstmt.setNull(2, 12);
/*     */       else {
/* 152 */         pstmt.setString(2, getUserCode());
/*     */       }
/* 154 */       if ((getUserType() == null) || (getUserType().equals("null")))
/* 155 */         pstmt.setNull(3, 12);
/*     */       else {
/* 157 */         pstmt.setString(3, getUserType());
/*     */       }
/* 159 */       if ((getClientName() == null) || (getClientName().equals("null")))
/* 160 */         pstmt.setNull(4, 12);
/*     */       else {
/* 162 */         pstmt.setString(4, getClientName());
/*     */       }
/* 164 */       if ((getClientType() == null) || (getClientType().equals("null")))
/* 165 */         pstmt.setNull(5, 12);
/*     */       else {
/* 167 */         pstmt.setString(5, getClientType());
/*     */       }
/* 169 */       if ((getClientIP() == null) || (getClientIP().equals("null")))
/* 170 */         pstmt.setNull(6, 12);
/*     */       else {
/* 172 */         pstmt.setString(6, getClientIP());
/*     */       }
/* 174 */       if ((getLoginTime() == null) || (getLoginTime().equals("null")))
/* 175 */         pstmt.setNull(8, 12);
/*     */       else {
/* 177 */         pstmt.setString(8, getLoginTime());
/*     */       }
/* 179 */       if ((getLogoutTime() == null) || (getLogoutTime().equals("null")))
/* 180 */         pstmt.setNull(10, 12);
/*     */       else {
/* 182 */         pstmt.setString(10, getLogoutTime());
/*     */       }
/*     */ 
/* 185 */       if ((getID() == null) || (getID().equals("null")))
/* 186 */         pstmt.setNull(11, 12);
/*     */       else {
/* 188 */         pstmt.setString(11, getID());
/*     */       }
/* 190 */       pstmt.executeUpdate();
/* 191 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 194 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 195 */       CError tError = new CError();
/* 196 */       tError.moduleName = "MUserLoginLogDB";
/* 197 */       tError.functionName = "update()";
/* 198 */       tError.errorMessage = ex.toString();
/* 199 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 202 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 205 */       if (!this.mflag)
/*     */         try {
/* 207 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 211 */       return false;
/*     */     }
/*     */ 
/* 214 */     if (!this.mflag)
/*     */       try {
/* 216 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 220 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 225 */     PreparedStatement pstmt = null;
/*     */ 
/* 227 */     if (!this.mflag) {
/* 228 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 233 */       pstmt = this.con.prepareStatement("INSERT INTO MUserLoginLog VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 234 */       if ((getID() == null) || (getID().equals("null")))
/* 235 */         pstmt.setNull(1, 12);
/*     */       else {
/* 237 */         pstmt.setString(1, getID());
/*     */       }
/* 239 */       if ((getUserCode() == null) || (getUserCode().equals("null")))
/* 240 */         pstmt.setNull(2, 12);
/*     */       else {
/* 242 */         pstmt.setString(2, getUserCode());
/*     */       }
/* 244 */       if ((getUserType() == null) || (getUserType().equals("null")))
/* 245 */         pstmt.setNull(3, 12);
/*     */       else {
/* 247 */         pstmt.setString(3, getUserType());
/*     */       }
/* 249 */       if ((getClientName() == null) || (getClientName().equals("null")))
/* 250 */         pstmt.setNull(4, 12);
/*     */       else {
/* 252 */         pstmt.setString(4, getClientName());
/*     */       }
/* 254 */       if ((getClientType() == null) || (getClientType().equals("null")))
/* 255 */         pstmt.setNull(5, 12);
/*     */       else {
/* 257 */         pstmt.setString(5, getClientType());
/*     */       }
/* 259 */       if ((getClientIP() == null) || (getClientIP().equals("null")))
/* 260 */         pstmt.setNull(6, 12);
/*     */       else {
/* 262 */         pstmt.setString(6, getClientIP());
/*     */       }
/* 264 */       if ((getLoginTime() == null) || (getLoginTime().equals("null")))
/* 265 */         pstmt.setNull(8, 12);
/*     */       else {
/* 267 */         pstmt.setString(8, getLoginTime());
/*     */       }
/* 269 */       if ((getLogoutTime() == null) || (getLogoutTime().equals("null")))
/* 270 */         pstmt.setNull(10, 12);
/*     */       else {
/* 272 */         pstmt.setString(10, getLogoutTime());
/*     */       }
/*     */ 
/* 275 */       pstmt.executeUpdate();
/* 276 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 279 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 280 */       CError tError = new CError();
/* 281 */       tError.moduleName = "MUserLoginLogDB";
/* 282 */       tError.functionName = "insert()";
/* 283 */       tError.errorMessage = ex.toString();
/* 284 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 287 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 290 */       if (!this.mflag)
/*     */         try {
/* 292 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 296 */       return false;
/*     */     }
/*     */ 
/* 299 */     if (!this.mflag)
/*     */       try {
/* 301 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 305 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean getInfo()
/*     */   {
/* 310 */     PreparedStatement pstmt = null;
/* 311 */     ResultSet rs = null;
/*     */ 
/* 313 */     if (!this.mflag) {
/* 314 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 319 */       pstmt = this.con.prepareStatement("SELECT * FROM MUserLoginLog WHERE  ID = ?", 
/* 320 */         1003, 1007);
/* 321 */       if ((getID() == null) || (getID().equals("null")))
/* 322 */         pstmt.setNull(1, 12);
/*     */       else {
/* 324 */         pstmt.setString(1, getID());
/*     */       }
/* 326 */       rs = pstmt.executeQuery();
/* 327 */       int i = 0;
/* 328 */       if (rs.next())
/*     */       {
/* 330 */         i++;
/* 331 */         if (!setSchema(rs, i))
/*     */         {
/* 334 */           CError tError = new CError();
/* 335 */           tError.moduleName = "MUserLoginLogDB";
/* 336 */           tError.functionName = "getInfo";
/* 337 */           tError.errorMessage = "\u53D6\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/* 338 */           this.mErrors.addOneError(tError);
/*     */           try {
/* 340 */             rs.close(); } catch (Exception localException1) {
/*     */           }try { pstmt.close(); } catch (Exception localException2) {
/*     */           }
/* 343 */           if (!this.mflag)
/*     */           {
/*     */             try
/*     */             {
/* 347 */               this.con.close();
/*     */             } catch (Exception localException3) {
/*     */             }
/*     */           }
/* 351 */           return false;
/*     */         }
/*     */       }
/*     */       try {
/* 355 */         rs.close(); } catch (Exception localException4) {
/*     */       }try { pstmt.close(); } catch (Exception localException5) {
/*     */       }
/* 358 */       if (i == 0)
/*     */       {
/* 360 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 364 */             this.con.close();
/*     */           } catch (Exception localException6) {
/*     */           }
/*     */         }
/* 368 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 374 */       CError tError = new CError();
/* 375 */       tError.moduleName = "MUserLoginLogDB";
/* 376 */       tError.functionName = "getInfo";
/* 377 */       tError.errorMessage = e.toString();
/* 378 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 380 */         rs.close(); } catch (Exception localException7) {
/*     */       }try { pstmt.close(); } catch (Exception localException8) {
/*     */       }
/* 383 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 387 */           this.con.close();
/*     */         } catch (Exception localException9) {
/*     */         }
/*     */       }
/* 391 */       return false;
/*     */     }
/*     */ 
/* 394 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 398 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException10) {
/*     */       }
/*     */     }
/* 403 */     return true;
/*     */   }
/*     */ 
/*     */   public MUserLoginLogSet query()
/*     */   {
/* 408 */     Statement stmt = null;
/* 409 */     ResultSet rs = null;
/* 410 */     MUserLoginLogSet aMUserLoginLogSet = new MUserLoginLogSet();
/*     */ 
/* 412 */     if (!this.mflag) {
/* 413 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 418 */       stmt = this.con.createStatement(1003, 1007);
/* 419 */       SQLString sqlObj = new SQLString("MUserLoginLog");
/* 420 */       MUserLoginLogSchema aSchema = getSchema();
/* 421 */       sqlObj.setSQL(5, aSchema);
/* 422 */       String sql = sqlObj.getSQL();
/*     */ 
/* 424 */       rs = stmt.executeQuery(sql);
/* 425 */       int i = 0;
/* 426 */       while (rs.next())
/*     */       {
/* 428 */         i++;
/* 429 */         MUserLoginLogSchema s1 = new MUserLoginLogSchema();
/* 430 */         s1.setSchema(rs, i);
/* 431 */         aMUserLoginLogSet.add(s1);
/*     */       }try {
/* 433 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 439 */       CError tError = new CError();
/* 440 */       tError.moduleName = "MUserLoginLogDB";
/* 441 */       tError.functionName = "query";
/* 442 */       tError.errorMessage = e.toString();
/* 443 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 445 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 448 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 452 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 458 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 462 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 467 */     return aMUserLoginLogSet;
/*     */   }
/*     */ 
/*     */   public MUserLoginLogSet executeQuery(String sql)
/*     */   {
/* 472 */     Statement stmt = null;
/* 473 */     ResultSet rs = null;
/* 474 */     MUserLoginLogSet aMUserLoginLogSet = new MUserLoginLogSet();
/*     */ 
/* 476 */     if (!this.mflag) {
/* 477 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 482 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 484 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 485 */       int i = 0;
/* 486 */       while (rs.next())
/*     */       {
/* 488 */         i++;
/* 489 */         MUserLoginLogSchema s1 = new MUserLoginLogSchema();
/* 490 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 493 */           CError tError = new CError();
/* 494 */           tError.moduleName = "MUserLoginLogDB";
/* 495 */           tError.functionName = "executeQuery";
/* 496 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/* 497 */           this.mErrors.addOneError(tError);
/*     */         }
/* 499 */         aMUserLoginLogSet.add(s1);
/*     */       }try {
/* 501 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 507 */       CError tError = new CError();
/* 508 */       tError.moduleName = "MUserLoginLogDB";
/* 509 */       tError.functionName = "executeQuery";
/* 510 */       tError.errorMessage = e.toString();
/* 511 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 513 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 516 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 520 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 526 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 530 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 535 */     return aMUserLoginLogSet;
/*     */   }
/*     */ 
/*     */   public MUserLoginLogSet query(int nStart, int nCount)
/*     */   {
/* 540 */     Statement stmt = null;
/* 541 */     ResultSet rs = null;
/* 542 */     MUserLoginLogSet aMUserLoginLogSet = new MUserLoginLogSet();
/*     */ 
/* 544 */     if (!this.mflag) {
/* 545 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 550 */       stmt = this.con.createStatement(1003, 1007);
/* 551 */       SQLString sqlObj = new SQLString("MUserLoginLog");
/* 552 */       MUserLoginLogSchema aSchema = getSchema();
/* 553 */       sqlObj.setSQL(5, aSchema);
/* 554 */       String sql = sqlObj.getSQL();
/*     */ 
/* 556 */       rs = stmt.executeQuery(sql);
/* 557 */       int i = 0;
/* 558 */       while (rs.next())
/*     */       {
/* 560 */         i++;
/*     */ 
/* 562 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 566 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 570 */         MUserLoginLogSchema s1 = new MUserLoginLogSchema();
/* 571 */         s1.setSchema(rs, i);
/* 572 */         aMUserLoginLogSet.add(s1);
/*     */       }try {
/* 574 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 580 */       CError tError = new CError();
/* 581 */       tError.moduleName = "MUserLoginLogDB";
/* 582 */       tError.functionName = "query";
/* 583 */       tError.errorMessage = e.toString();
/* 584 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 586 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 589 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 593 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 599 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 603 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 608 */     return aMUserLoginLogSet;
/*     */   }
/*     */ 
/*     */   public MUserLoginLogSet executeQuery(String sql, int nStart, int nCount)
/*     */   {
/* 613 */     Statement stmt = null;
/* 614 */     ResultSet rs = null;
/* 615 */     MUserLoginLogSet aMUserLoginLogSet = new MUserLoginLogSet();
/*     */ 
/* 617 */     if (!this.mflag) {
/* 618 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 623 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 625 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 626 */       int i = 0;
/* 627 */       while (rs.next())
/*     */       {
/* 629 */         i++;
/*     */ 
/* 631 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 635 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 639 */         MUserLoginLogSchema s1 = new MUserLoginLogSchema();
/* 640 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 643 */           CError tError = new CError();
/* 644 */           tError.moduleName = "MUserLoginLogDB";
/* 645 */           tError.functionName = "executeQuery";
/* 646 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/* 647 */           this.mErrors.addOneError(tError);
/*     */         }
/* 649 */         aMUserLoginLogSet.add(s1);
/*     */       }try {
/* 651 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 657 */       CError tError = new CError();
/* 658 */       tError.moduleName = "MUserLoginLogDB";
/* 659 */       tError.functionName = "executeQuery";
/* 660 */       tError.errorMessage = e.toString();
/* 661 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 663 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 666 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 670 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 676 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 680 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 685 */     return aMUserLoginLogSet;
/*     */   }
/*     */ 
/*     */   public boolean update(String strWherePart)
/*     */   {
/* 690 */     Statement stmt = null;
/*     */ 
/* 692 */     if (!this.mflag) {
/* 693 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 698 */       stmt = this.con.createStatement(1003, 1007);
/* 699 */       SQLString sqlObj = new SQLString("MUserLoginLog");
/* 700 */       MUserLoginLogSchema aSchema = getSchema();
/* 701 */       sqlObj.setSQL(2, aSchema);
/* 702 */       String sql = "update MUserLoginLog " + sqlObj.getUpdPart() + " where " + strWherePart;
/*     */ 
/* 704 */       int operCount = stmt.executeUpdate(sql);
/* 705 */       if (operCount == 0)
/*     */       {
/* 708 */         CError tError = new CError();
/* 709 */         tError.moduleName = "MUserLoginLogDB";
/* 710 */         tError.functionName = "update";
/* 711 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u7EDE\u044D\u62F7\u951F\uFFFD!";
/* 712 */         this.mErrors.addOneError(tError);
/*     */ 
/* 714 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 718 */             this.con.close();
/*     */           } catch (Exception localException1) {
/*     */           }
/*     */         }
/* 722 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 728 */       CError tError = new CError();
/* 729 */       tError.moduleName = "MUserLoginLogDB";
/* 730 */       tError.functionName = "update";
/* 731 */       tError.errorMessage = e.toString();
/* 732 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 734 */         stmt.close(); } catch (Exception localException2) {
/*     */       }
/* 736 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 740 */           this.con.close();
/*     */         } catch (Exception localException3) {
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
/*     */   public boolean prepareData(String strSQL)
/*     */   {
/* 762 */     if (this.mResultSet != null)
/*     */     {
/* 765 */       CError tError = new CError();
/* 766 */       tError.moduleName = "MUserLoginLogDB";
/* 767 */       tError.functionName = "prepareData";
/* 768 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u5F3A\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u4E4B\u951F\u65A4\u62F7\u6CA1\u951F\u53EB\u5173\u95ED\uFF4F\u62F7";
/* 769 */       this.mErrors.addOneError(tError);
/* 770 */       return false;
/*     */     }
/*     */ 
/* 773 */     if (!this.mflag)
/*     */     {
/* 775 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */     try
/*     */     {
/* 779 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 780 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 785 */       CError tError = new CError();
/* 786 */       tError.moduleName = "MUserLoginLogDB";
/* 787 */       tError.functionName = "prepareData";
/* 788 */       tError.errorMessage = e.toString();
/* 789 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 792 */         this.mResultSet.close();
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 798 */         this.mStatement.close();
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 802 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 806 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 811 */       return false;
/*     */     }
/*     */ 
/* 814 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 818 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException4) {
/*     */       }
/*     */     }
/* 823 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean hasMoreData()
/*     */   {
/* 829 */     boolean flag = true;
/* 830 */     if (this.mResultSet == null)
/*     */     {
/* 832 */       CError tError = new CError();
/* 833 */       tError.moduleName = "MUserLoginLogDB";
/* 834 */       tError.functionName = "hasMoreData";
/* 835 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/* 836 */       this.mErrors.addOneError(tError);
/* 837 */       return false;
/*     */     }
/*     */     try
/*     */     {
/* 841 */       flag = this.mResultSet.next();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 845 */       CError tError = new CError();
/* 846 */       tError.moduleName = "MUserLoginLogDB";
/* 847 */       tError.functionName = "hasMoreData";
/* 848 */       tError.errorMessage = ex.toString();
/* 849 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 852 */         this.mResultSet.close();
/* 853 */         this.mResultSet = null;
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 859 */         this.mStatement.close();
/* 860 */         this.mStatement = null;
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 864 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 868 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 873 */       return false;
/*     */     }
/* 875 */     return flag;
/*     */   }
/*     */ 
/*     */   public MUserLoginLogSet getData()
/*     */   {
/* 880 */     int tCount = 0;
/* 881 */     MUserLoginLogSet tMUserLoginLogSet = new MUserLoginLogSet();
/* 882 */     MUserLoginLogSchema tMUserLoginLogSchema = null;
/* 883 */     if (this.mResultSet == null)
/*     */     {
/* 885 */       CError tError = new CError();
/* 886 */       tError.moduleName = "MUserLoginLogDB";
/* 887 */       tError.functionName = "getData";
/* 888 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/* 889 */       this.mErrors.addOneError(tError);
/* 890 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 894 */       tCount = 1;
/* 895 */       tMUserLoginLogSchema = new MUserLoginLogSchema();
/* 896 */       tMUserLoginLogSchema.setSchema(this.mResultSet, 1);
/* 897 */       tMUserLoginLogSet.add(tMUserLoginLogSchema);
/*     */ 
/* 899 */       while (tCount++ < 5000)
/*     */       {
/* 901 */         if (!this.mResultSet.next())
/*     */           continue;
/* 903 */         tMUserLoginLogSchema = new MUserLoginLogSchema();
/* 904 */         tMUserLoginLogSchema.setSchema(this.mResultSet, 1);
/* 905 */         tMUserLoginLogSet.add(tMUserLoginLogSchema);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 911 */       CError tError = new CError();
/* 912 */       tError.moduleName = "MUserLoginLogDB";
/* 913 */       tError.functionName = "getData";
/* 914 */       tError.errorMessage = ex.toString();
/* 915 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 918 */         this.mResultSet.close();
/* 919 */         this.mResultSet = null;
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 925 */         this.mStatement.close();
/* 926 */         this.mStatement = null;
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 930 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 934 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 939 */       return null;
/*     */     }
/* 941 */     return tMUserLoginLogSet;
/*     */   }
/*     */ 
/*     */   public boolean closeData()
/*     */   {
/* 946 */     boolean flag = true;
/*     */     try
/*     */     {
/* 949 */       if (this.mResultSet == null)
/*     */       {
/* 951 */         CError tError = new CError();
/* 952 */         tError.moduleName = "MUserLoginLogDB";
/* 953 */         tError.functionName = "closeData";
/* 954 */         tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 955 */         this.mErrors.addOneError(tError);
/* 956 */         flag = false;
/*     */       }
/*     */       else
/*     */       {
/* 960 */         this.mResultSet.close();
/* 961 */         this.mResultSet = null;
/*     */       }
/*     */     }
/*     */     catch (Exception ex2)
/*     */     {
/* 966 */       CError tError = new CError();
/* 967 */       tError.moduleName = "MUserLoginLogDB";
/* 968 */       tError.functionName = "closeData";
/* 969 */       tError.errorMessage = ex2.toString();
/* 970 */       this.mErrors.addOneError(tError);
/* 971 */       flag = false;
/*     */     }
/*     */     try
/*     */     {
/* 975 */       if (this.mStatement == null)
/*     */       {
/* 977 */         CError tError = new CError();
/* 978 */         tError.moduleName = "MUserLoginLogDB";
/* 979 */         tError.functionName = "closeData";
/* 980 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 981 */         this.mErrors.addOneError(tError);
/* 982 */         flag = false;
/*     */       }
/*     */       else
/*     */       {
/* 986 */         this.mStatement.close();
/* 987 */         this.mStatement = null;
/*     */       }
/*     */     }
/*     */     catch (Exception ex3)
/*     */     {
/* 992 */       CError tError = new CError();
/* 993 */       tError.moduleName = "MUserLoginLogDB";
/* 994 */       tError.functionName = "closeData";
/* 995 */       tError.errorMessage = ex3.toString();
/* 996 */       this.mErrors.addOneError(tError);
/* 997 */       flag = false;
/*     */     }
/* 999 */     return flag;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MUserLoginLogDB
 * JD-Core Version:    0.6.0
 */