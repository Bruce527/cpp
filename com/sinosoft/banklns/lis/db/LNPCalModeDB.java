/*     */ package com.sinosoft.banklns.lis.db;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPCalModeSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPCalModeSet;
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
/*     */ public class LNPCalModeDB extends LNPCalModeSchema
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  32 */   private boolean mflag = false;
/*     */ 
/*  34 */   public CErrors mErrors = new CErrors();
/*     */ 
/*  39 */   private ResultSet mResultSet = null;
/*  40 */   private Statement mStatement = null;
/*     */ 
/*     */   public LNPCalModeDB(Connection tConnection)
/*     */   {
/*  44 */     this.con = tConnection;
/*  45 */     this.db = new DBOper(this.con, "LNPCalMode");
/*  46 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPCalModeDB()
/*     */   {
/*  51 */     this.con = null;
/*  52 */     this.db = new DBOper("LNPCalMode");
/*  53 */     this.mflag = false;
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  59 */     LNPCalModeSchema tSchema = getSchema();
/*  60 */     if (this.db.deleteSQL(tSchema))
/*     */     {
/*  62 */       return true;
/*     */     }
/*     */ 
/*  67 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*  68 */     CError tError = new CError();
/*  69 */     tError.moduleName = "LNPCalModeDB";
/*  70 */     tError.functionName = "deleteSQL";
/*  71 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*  72 */     this.mErrors.addOneError(tError);
/*  73 */     return false;
/*     */   }
/*     */ 
/*     */   public int getCount()
/*     */   {
/*  79 */     LNPCalModeSchema tSchema = getSchema();
/*     */ 
/*  81 */     int tCount = this.db.getCount(tSchema);
/*  82 */     if (tCount < 0)
/*     */     {
/*  85 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  86 */       CError tError = new CError();
/*  87 */       tError.moduleName = "LNPCalModeDB";
/*  88 */       tError.functionName = "getCount";
/*  89 */       tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*  90 */       this.mErrors.addOneError(tError);
/*     */ 
/*  92 */       return -1;
/*     */     }
/*     */ 
/*  95 */     return tCount;
/*     */   }
/*     */ 
/*     */   public boolean delete()
/*     */   {
/* 100 */     PreparedStatement pstmt = null;
/*     */ 
/* 102 */     if (!this.mflag) {
/* 103 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 108 */       pstmt = this.con.prepareStatement("DELETE FROM LNPCalMode WHERE  CalCode = ?");
/* 109 */       if ((getCalCode() == null) || (getCalCode().equals("null")))
/* 110 */         pstmt.setNull(1, 12);
/*     */       else {
/* 112 */         pstmt.setString(1, getCalCode());
/*     */       }
/* 114 */       pstmt.executeUpdate();
/* 115 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 118 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 119 */       CError tError = new CError();
/* 120 */       tError.moduleName = "LNPCalModeDB";
/* 121 */       tError.functionName = "delete()";
/* 122 */       tError.errorMessage = ex.toString();
/* 123 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 126 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 129 */       if (!this.mflag)
/*     */         try {
/* 131 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 135 */       return false;
/*     */     }
/*     */ 
/* 138 */     if (!this.mflag)
/*     */       try {
/* 140 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 144 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 149 */     PreparedStatement pstmt = null;
/*     */ 
/* 151 */     if (!this.mflag) {
/* 152 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 157 */       pstmt = this.con.prepareStatement("UPDATE LNPCalMode SET  CalCode = ? , RiskCode = ? , Type = ? , CalSQL = ? , Remark = ? WHERE  CalCode = ?");
/* 158 */       if ((getCalCode() == null) || (getCalCode().equals("null")))
/* 159 */         pstmt.setNull(1, 12);
/*     */       else {
/* 161 */         pstmt.setString(1, getCalCode());
/*     */       }
/* 163 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/* 164 */         pstmt.setNull(2, 12);
/*     */       else {
/* 166 */         pstmt.setString(2, getRiskCode());
/*     */       }
/* 168 */       if ((getType() == null) || (getType().equals("null")))
/* 169 */         pstmt.setNull(3, 12);
/*     */       else {
/* 171 */         pstmt.setString(3, getType());
/*     */       }
/* 173 */       if ((getCalSQL() == null) || (getCalSQL().equals("null")))
/* 174 */         pstmt.setNull(4, 12);
/*     */       else {
/* 176 */         pstmt.setString(4, getCalSQL());
/*     */       }
/* 178 */       if ((getRemark() == null) || (getRemark().equals("null")))
/* 179 */         pstmt.setNull(5, 12);
/*     */       else {
/* 181 */         pstmt.setString(5, getRemark());
/*     */       }
/*     */ 
/* 184 */       if ((getCalCode() == null) || (getCalCode().equals("null")))
/* 185 */         pstmt.setNull(6, 12);
/*     */       else {
/* 187 */         pstmt.setString(6, getCalCode());
/*     */       }
/* 189 */       pstmt.executeUpdate();
/* 190 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 193 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 194 */       CError tError = new CError();
/* 195 */       tError.moduleName = "LNPCalModeDB";
/* 196 */       tError.functionName = "update()";
/* 197 */       tError.errorMessage = ex.toString();
/* 198 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 201 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 204 */       if (!this.mflag)
/*     */         try {
/* 206 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 210 */       return false;
/*     */     }
/*     */ 
/* 213 */     if (!this.mflag)
/*     */       try {
/* 215 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 219 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 224 */     PreparedStatement pstmt = null;
/*     */ 
/* 226 */     if (!this.mflag) {
/* 227 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 232 */       pstmt = this.con.prepareStatement("INSERT INTO LNPCalMode VALUES( ? , ? , ? , ? , ?)");
/* 233 */       if ((getCalCode() == null) || (getCalCode().equals("null")))
/* 234 */         pstmt.setNull(1, 12);
/*     */       else {
/* 236 */         pstmt.setString(1, getCalCode());
/*     */       }
/* 238 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/* 239 */         pstmt.setNull(2, 12);
/*     */       else {
/* 241 */         pstmt.setString(2, getRiskCode());
/*     */       }
/* 243 */       if ((getType() == null) || (getType().equals("null")))
/* 244 */         pstmt.setNull(3, 12);
/*     */       else {
/* 246 */         pstmt.setString(3, getType());
/*     */       }
/* 248 */       if ((getCalSQL() == null) || (getCalSQL().equals("null")))
/* 249 */         pstmt.setNull(4, 12);
/*     */       else {
/* 251 */         pstmt.setString(4, getCalSQL());
/*     */       }
/* 253 */       if ((getRemark() == null) || (getRemark().equals("null")))
/* 254 */         pstmt.setNull(5, 12);
/*     */       else {
/* 256 */         pstmt.setString(5, getRemark());
/*     */       }
/*     */ 
/* 259 */       pstmt.executeUpdate();
/* 260 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 263 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 264 */       CError tError = new CError();
/* 265 */       tError.moduleName = "LNPCalModeDB";
/* 266 */       tError.functionName = "insert()";
/* 267 */       tError.errorMessage = ex.toString();
/* 268 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 271 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 274 */       if (!this.mflag)
/*     */         try {
/* 276 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 280 */       return false;
/*     */     }
/*     */ 
/* 283 */     if (!this.mflag)
/*     */       try {
/* 285 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 289 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean getInfo()
/*     */   {
/* 294 */     PreparedStatement pstmt = null;
/* 295 */     ResultSet rs = null;
/*     */ 
/* 297 */     if (!this.mflag) {
/* 298 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 303 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPCalMode WHERE  CalCode = ?", 
/* 304 */         1003, 1007);
/* 305 */       if ((getCalCode() == null) || (getCalCode().equals("null")))
/* 306 */         pstmt.setNull(1, 12);
/*     */       else {
/* 308 */         pstmt.setString(1, getCalCode());
/*     */       }
/* 310 */       rs = pstmt.executeQuery();
/* 311 */       int i = 0;
/* 312 */       if (rs.next())
/*     */       {
/* 314 */         i++;
/* 315 */         if (!setSchema(rs, i))
/*     */         {
/* 318 */           CError tError = new CError();
/* 319 */           tError.moduleName = "LNPCalModeDB";
/* 320 */           tError.functionName = "getInfo";
/* 321 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/* 322 */           this.mErrors.addOneError(tError);
/*     */           try {
/* 324 */             rs.close(); } catch (Exception localException1) {
/*     */           }try { pstmt.close(); } catch (Exception localException2) {
/*     */           }
/* 327 */           if (!this.mflag)
/*     */           {
/*     */             try
/*     */             {
/* 331 */               this.con.close();
/*     */             } catch (Exception localException3) {
/*     */             }
/*     */           }
/* 335 */           return false;
/*     */         }
/*     */       }
/*     */       try {
/* 339 */         rs.close(); } catch (Exception localException4) {
/*     */       }try { pstmt.close(); } catch (Exception localException5) {
/*     */       }
/* 342 */       if (i == 0)
/*     */       {
/* 344 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 348 */             this.con.close();
/*     */           } catch (Exception localException6) {
/*     */           }
/*     */         }
/* 352 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 358 */       CError tError = new CError();
/* 359 */       tError.moduleName = "LNPCalModeDB";
/* 360 */       tError.functionName = "getInfo";
/* 361 */       tError.errorMessage = e.toString();
/* 362 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 364 */         rs.close(); } catch (Exception localException7) {
/*     */       }try { pstmt.close(); } catch (Exception localException8) {
/*     */       }
/* 367 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 371 */           this.con.close();
/*     */         } catch (Exception localException9) {
/*     */         }
/*     */       }
/* 375 */       return false;
/*     */     }
/*     */ 
/* 378 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 382 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException10) {
/*     */       }
/*     */     }
/* 387 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPCalModeSet query()
/*     */   {
/* 392 */     Statement stmt = null;
/* 393 */     ResultSet rs = null;
/* 394 */     LNPCalModeSet aLNPCalModeSet = new LNPCalModeSet();
/*     */ 
/* 396 */     if (!this.mflag) {
/* 397 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 402 */       stmt = this.con.createStatement(1003, 1007);
/* 403 */       SQLString sqlObj = new SQLString("LNPCalMode");
/* 404 */       LNPCalModeSchema aSchema = getSchema();
/* 405 */       sqlObj.setSQL(5, aSchema);
/* 406 */       String sql = sqlObj.getSQL();
/*     */ 
/* 408 */       rs = stmt.executeQuery(sql);
/* 409 */       int i = 0;
/* 410 */       while (rs.next())
/*     */       {
/* 412 */         i++;
/* 413 */         LNPCalModeSchema s1 = new LNPCalModeSchema();
/* 414 */         s1.setSchema(rs, i);
/* 415 */         aLNPCalModeSet.add(s1);
/*     */       }try {
/* 417 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 423 */       CError tError = new CError();
/* 424 */       tError.moduleName = "LNPCalModeDB";
/* 425 */       tError.functionName = "query";
/* 426 */       tError.errorMessage = e.toString();
/* 427 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 429 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 432 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 436 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 442 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 446 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 451 */     return aLNPCalModeSet;
/*     */   }
/*     */ 
/*     */   public LNPCalModeSet executeQuery(String sql)
/*     */   {
/* 456 */     Statement stmt = null;
/* 457 */     ResultSet rs = null;
/* 458 */     LNPCalModeSet aLNPCalModeSet = new LNPCalModeSet();
/*     */ 
/* 460 */     if (!this.mflag) {
/* 461 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 466 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 468 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 469 */       int i = 0;
/* 470 */       while (rs.next())
/*     */       {
/* 472 */         i++;
/* 473 */         LNPCalModeSchema s1 = new LNPCalModeSchema();
/* 474 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 477 */           CError tError = new CError();
/* 478 */           tError.moduleName = "LNPCalModeDB";
/* 479 */           tError.functionName = "executeQuery";
/* 480 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/* 481 */           this.mErrors.addOneError(tError);
/*     */         }
/* 483 */         aLNPCalModeSet.add(s1);
/*     */       }try {
/* 485 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 491 */       CError tError = new CError();
/* 492 */       tError.moduleName = "LNPCalModeDB";
/* 493 */       tError.functionName = "executeQuery";
/* 494 */       tError.errorMessage = e.toString();
/* 495 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 497 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 500 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 504 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 510 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 514 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 519 */     return aLNPCalModeSet;
/*     */   }
/*     */ 
/*     */   public LNPCalModeSet query(int nStart, int nCount)
/*     */   {
/* 524 */     Statement stmt = null;
/* 525 */     ResultSet rs = null;
/* 526 */     LNPCalModeSet aLNPCalModeSet = new LNPCalModeSet();
/*     */ 
/* 528 */     if (!this.mflag) {
/* 529 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 534 */       stmt = this.con.createStatement(1003, 1007);
/* 535 */       SQLString sqlObj = new SQLString("LNPCalMode");
/* 536 */       LNPCalModeSchema aSchema = getSchema();
/* 537 */       sqlObj.setSQL(5, aSchema);
/* 538 */       String sql = sqlObj.getSQL();
/*     */ 
/* 540 */       rs = stmt.executeQuery(sql);
/* 541 */       int i = 0;
/* 542 */       while (rs.next())
/*     */       {
/* 544 */         i++;
/*     */ 
/* 546 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 550 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 554 */         LNPCalModeSchema s1 = new LNPCalModeSchema();
/* 555 */         s1.setSchema(rs, i);
/* 556 */         aLNPCalModeSet.add(s1);
/*     */       }try {
/* 558 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 564 */       CError tError = new CError();
/* 565 */       tError.moduleName = "LNPCalModeDB";
/* 566 */       tError.functionName = "query";
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
/* 592 */     return aLNPCalModeSet;
/*     */   }
/*     */ 
/*     */   public LNPCalModeSet executeQuery(String sql, int nStart, int nCount)
/*     */   {
/* 597 */     Statement stmt = null;
/* 598 */     ResultSet rs = null;
/* 599 */     LNPCalModeSet aLNPCalModeSet = new LNPCalModeSet();
/*     */ 
/* 601 */     if (!this.mflag) {
/* 602 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 607 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 609 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 610 */       int i = 0;
/* 611 */       while (rs.next())
/*     */       {
/* 613 */         i++;
/*     */ 
/* 615 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 619 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 623 */         LNPCalModeSchema s1 = new LNPCalModeSchema();
/* 624 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 627 */           CError tError = new CError();
/* 628 */           tError.moduleName = "LNPCalModeDB";
/* 629 */           tError.functionName = "executeQuery";
/* 630 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/* 631 */           this.mErrors.addOneError(tError);
/*     */         }
/* 633 */         aLNPCalModeSet.add(s1);
/*     */       }try {
/* 635 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 641 */       CError tError = new CError();
/* 642 */       tError.moduleName = "LNPCalModeDB";
/* 643 */       tError.functionName = "executeQuery";
/* 644 */       tError.errorMessage = e.toString();
/* 645 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 647 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 650 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 654 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 660 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 664 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 669 */     return aLNPCalModeSet;
/*     */   }
/*     */ 
/*     */   public boolean update(String strWherePart)
/*     */   {
/* 674 */     Statement stmt = null;
/*     */ 
/* 676 */     if (!this.mflag) {
/* 677 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 682 */       stmt = this.con.createStatement(1003, 1007);
/* 683 */       SQLString sqlObj = new SQLString("LNPCalMode");
/* 684 */       LNPCalModeSchema aSchema = getSchema();
/* 685 */       sqlObj.setSQL(2, aSchema);
/* 686 */       String sql = "update LNPCalMode " + sqlObj.getUpdPart() + " where " + strWherePart;
/*     */ 
/* 688 */       int operCount = stmt.executeUpdate(sql);
/* 689 */       if (operCount == 0)
/*     */       {
/* 692 */         CError tError = new CError();
/* 693 */         tError.moduleName = "LNPCalModeDB";
/* 694 */         tError.functionName = "update";
/* 695 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/* 696 */         this.mErrors.addOneError(tError);
/*     */ 
/* 698 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 702 */             this.con.close();
/*     */           } catch (Exception localException1) {
/*     */           }
/*     */         }
/* 706 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 712 */       CError tError = new CError();
/* 713 */       tError.moduleName = "LNPCalModeDB";
/* 714 */       tError.functionName = "update";
/* 715 */       tError.errorMessage = e.toString();
/* 716 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 718 */         stmt.close(); } catch (Exception localException2) {
/*     */       }
/* 720 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 724 */           this.con.close();
/*     */         } catch (Exception localException3) {
/*     */         }
/*     */       }
/* 728 */       return false;
/*     */     }
/*     */ 
/* 731 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 735 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException4) {
/*     */       }
/*     */     }
/* 740 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean prepareData(String strSQL)
/*     */   {
/* 750 */     if (this.mResultSet != null)
/*     */     {
/* 753 */       CError tError = new CError();
/* 754 */       tError.moduleName = "LNPCalModeDB";
/* 755 */       tError.functionName = "prepareData";
/* 756 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/* 757 */       this.mErrors.addOneError(tError);
/* 758 */       return false;
/*     */     }
/*     */ 
/* 761 */     if (!this.mflag)
/*     */     {
/* 763 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */     try
/*     */     {
/* 767 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 768 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 773 */       CError tError = new CError();
/* 774 */       tError.moduleName = "LNPCalModeDB";
/* 775 */       tError.functionName = "prepareData";
/* 776 */       tError.errorMessage = e.toString();
/* 777 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 780 */         this.mResultSet.close();
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 786 */         this.mStatement.close();
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 790 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 794 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 799 */       return false;
/*     */     }
/*     */ 
/* 802 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 806 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException4) {
/*     */       }
/*     */     }
/* 811 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean hasMoreData()
/*     */   {
/* 821 */     boolean flag = true;
/* 822 */     if (this.mResultSet == null)
/*     */     {
/* 824 */       CError tError = new CError();
/* 825 */       tError.moduleName = "LNPCalModeDB";
/* 826 */       tError.functionName = "hasMoreData";
/* 827 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 828 */       this.mErrors.addOneError(tError);
/* 829 */       return false;
/*     */     }
/*     */     try
/*     */     {
/* 833 */       flag = this.mResultSet.next();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 837 */       CError tError = new CError();
/* 838 */       tError.moduleName = "LNPCalModeDB";
/* 839 */       tError.functionName = "hasMoreData";
/* 840 */       tError.errorMessage = ex.toString();
/* 841 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 844 */         this.mResultSet.close();
/* 845 */         this.mResultSet = null;
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 851 */         this.mStatement.close();
/* 852 */         this.mStatement = null;
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 856 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 860 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 865 */       return false;
/*     */     }
/* 867 */     return flag;
/*     */   }
/*     */ 
/*     */   public LNPCalModeSet getData()
/*     */   {
/* 876 */     int tCount = 0;
/* 877 */     LNPCalModeSet tLNPCalModeSet = new LNPCalModeSet();
/* 878 */     LNPCalModeSchema tLNPCalModeSchema = null;
/* 879 */     if (this.mResultSet == null)
/*     */     {
/* 881 */       CError tError = new CError();
/* 882 */       tError.moduleName = "LNPCalModeDB";
/* 883 */       tError.functionName = "getData";
/* 884 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 885 */       this.mErrors.addOneError(tError);
/* 886 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 890 */       tCount = 1;
/* 891 */       tLNPCalModeSchema = new LNPCalModeSchema();
/* 892 */       tLNPCalModeSchema.setSchema(this.mResultSet, 1);
/* 893 */       tLNPCalModeSet.add(tLNPCalModeSchema);
/*     */ 
/* 895 */       while (tCount++ < 5000)
/*     */       {
/* 897 */         if (!this.mResultSet.next())
/*     */           continue;
/* 899 */         tLNPCalModeSchema = new LNPCalModeSchema();
/* 900 */         tLNPCalModeSchema.setSchema(this.mResultSet, 1);
/* 901 */         tLNPCalModeSet.add(tLNPCalModeSchema);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 907 */       CError tError = new CError();
/* 908 */       tError.moduleName = "LNPCalModeDB";
/* 909 */       tError.functionName = "getData";
/* 910 */       tError.errorMessage = ex.toString();
/* 911 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 914 */         this.mResultSet.close();
/* 915 */         this.mResultSet = null;
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 921 */         this.mStatement.close();
/* 922 */         this.mStatement = null;
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 926 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 930 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 935 */       return null;
/*     */     }
/* 937 */     return tLNPCalModeSet;
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
/* 952 */         tError.moduleName = "LNPCalModeDB";
/* 953 */         tError.functionName = "closeData";
/* 954 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
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
/* 967 */       tError.moduleName = "LNPCalModeDB";
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
/* 978 */         tError.moduleName = "LNPCalModeDB";
/* 979 */         tError.functionName = "closeData";
/* 980 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
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
/* 993 */       tError.moduleName = "LNPCalModeDB";
/* 994 */       tError.functionName = "closeData";
/* 995 */       tError.errorMessage = ex3.toString();
/* 996 */       this.mErrors.addOneError(tError);
/* 997 */       flag = false;
/*     */     }
/* 999 */     return flag;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPCalModeDB
 * JD-Core Version:    0.6.0
 */