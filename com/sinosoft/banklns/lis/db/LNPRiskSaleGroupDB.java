/*     */ package com.sinosoft.banklns.lis.db;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPRiskSaleGroupSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPRiskSaleGroupSet;
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
/*     */ public class LNPRiskSaleGroupDB extends LNPRiskSaleGroupSchema
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
/*     */   public LNPRiskSaleGroupDB(Connection tConnection)
/*     */   {
/*  32 */     this.con = tConnection;
/*  33 */     this.db = new DBOper(this.con, "LNPRiskSaleGroup");
/*  34 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPRiskSaleGroupDB()
/*     */   {
/*  39 */     this.con = null;
/*  40 */     this.db = new DBOper("LNPRiskSaleGroup");
/*  41 */     this.mflag = false;
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  47 */     LNPRiskSaleGroupSchema tSchema = getSchema();
/*  48 */     if (this.db.deleteSQL(tSchema))
/*     */     {
/*  50 */       return true;
/*     */     }
/*     */ 
/*  55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*  56 */     CError tError = new CError();
/*  57 */     tError.moduleName = "LNPRiskSaleGroupDB";
/*  58 */     tError.functionName = "deleteSQL";
/*  59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*  60 */     this.mErrors.addOneError(tError);
/*  61 */     return false;
/*     */   }
/*     */ 
/*     */   public int getCount()
/*     */   {
/*  67 */     LNPRiskSaleGroupSchema tSchema = getSchema();
/*     */ 
/*  69 */     int tCount = this.db.getCount(tSchema);
/*  70 */     if (tCount < 0)
/*     */     {
/*  73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  74 */       CError tError = new CError();
/*  75 */       tError.moduleName = "LNPRiskSaleGroupDB";
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
/*  96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPRiskSaleGroup WHERE  GroupCode = ?");
/*  97 */       if ((getGroupCode() == null) || (getGroupCode().equals("null")))
/*  98 */         pstmt.setNull(1, 12);
/*     */       else {
/* 100 */         pstmt.setString(1, getGroupCode());
/*     */       }
/* 102 */       pstmt.executeUpdate();
/* 103 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 106 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 107 */       CError tError = new CError();
/* 108 */       tError.moduleName = "LNPRiskSaleGroupDB";
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
/* 145 */       pstmt = this.con.prepareStatement("UPDATE LNPRiskSaleGroup SET  GroupCode = ? , GroupName = ? , GroupDescribe = ? WHERE  GroupCode = ?");
/* 146 */       if ((getGroupCode() == null) || (getGroupCode().equals("null")))
/* 147 */         pstmt.setNull(1, 12);
/*     */       else {
/* 149 */         pstmt.setString(1, getGroupCode());
/*     */       }
/* 151 */       if ((getGroupName() == null) || (getGroupName().equals("null")))
/* 152 */         pstmt.setNull(2, 12);
/*     */       else {
/* 154 */         pstmt.setString(2, getGroupName());
/*     */       }
/* 156 */       if ((getGroupDescribe() == null) || (getGroupDescribe().equals("null")))
/* 157 */         pstmt.setNull(3, 12);
/*     */       else {
/* 159 */         pstmt.setString(3, getGroupDescribe());
/*     */       }
/*     */ 
/* 162 */       if ((getGroupCode() == null) || (getGroupCode().equals("null")))
/* 163 */         pstmt.setNull(4, 12);
/*     */       else {
/* 165 */         pstmt.setString(4, getGroupCode());
/*     */       }
/* 167 */       pstmt.executeUpdate();
/* 168 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 171 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 172 */       CError tError = new CError();
/* 173 */       tError.moduleName = "LNPRiskSaleGroupDB";
/* 174 */       tError.functionName = "update()";
/* 175 */       tError.errorMessage = ex.toString();
/* 176 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 179 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 182 */       if (!this.mflag)
/*     */         try {
/* 184 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 188 */       return false;
/*     */     }
/*     */ 
/* 191 */     if (!this.mflag)
/*     */       try {
/* 193 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 197 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 202 */     PreparedStatement pstmt = null;
/*     */ 
/* 204 */     if (!this.mflag) {
/* 205 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 210 */       pstmt = this.con.prepareStatement("INSERT INTO LNPRiskSaleGroup VALUES( ? , ? , ?)");
/* 211 */       if ((getGroupCode() == null) || (getGroupCode().equals("null")))
/* 212 */         pstmt.setNull(1, 12);
/*     */       else {
/* 214 */         pstmt.setString(1, getGroupCode());
/*     */       }
/* 216 */       if ((getGroupName() == null) || (getGroupName().equals("null")))
/* 217 */         pstmt.setNull(2, 12);
/*     */       else {
/* 219 */         pstmt.setString(2, getGroupName());
/*     */       }
/* 221 */       if ((getGroupDescribe() == null) || (getGroupDescribe().equals("null")))
/* 222 */         pstmt.setNull(3, 12);
/*     */       else {
/* 224 */         pstmt.setString(3, getGroupDescribe());
/*     */       }
/*     */ 
/* 227 */       pstmt.executeUpdate();
/* 228 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 231 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 232 */       CError tError = new CError();
/* 233 */       tError.moduleName = "LNPRiskSaleGroupDB";
/* 234 */       tError.functionName = "insert()";
/* 235 */       tError.errorMessage = ex.toString();
/* 236 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 239 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 242 */       if (!this.mflag)
/*     */         try {
/* 244 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 248 */       return false;
/*     */     }
/*     */ 
/* 251 */     if (!this.mflag)
/*     */       try {
/* 253 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 257 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean getInfo()
/*     */   {
/* 262 */     PreparedStatement pstmt = null;
/* 263 */     ResultSet rs = null;
/*     */ 
/* 265 */     if (!this.mflag) {
/* 266 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 271 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPRiskSaleGroup WHERE  GroupCode = ?", 
/* 272 */         1003, 1007);
/* 273 */       if ((getGroupCode() == null) || (getGroupCode().equals("null")))
/* 274 */         pstmt.setNull(1, 12);
/*     */       else {
/* 276 */         pstmt.setString(1, getGroupCode());
/*     */       }
/* 278 */       rs = pstmt.executeQuery();
/* 279 */       int i = 0;
/* 280 */       if (rs.next())
/*     */       {
/* 282 */         i++;
/* 283 */         if (!setSchema(rs, i))
/*     */         {
/* 286 */           CError tError = new CError();
/* 287 */           tError.moduleName = "LNPRiskSaleGroupDB";
/* 288 */           tError.functionName = "getInfo";
/* 289 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/* 290 */           this.mErrors.addOneError(tError);
/*     */           try {
/* 292 */             rs.close(); } catch (Exception localException1) {
/*     */           }try { pstmt.close(); } catch (Exception localException2) {
/*     */           }
/* 295 */           if (!this.mflag)
/*     */           {
/*     */             try
/*     */             {
/* 299 */               this.con.close();
/*     */             } catch (Exception localException3) {
/*     */             }
/*     */           }
/* 303 */           return false;
/*     */         }
/*     */       }
/*     */       try {
/* 307 */         rs.close(); } catch (Exception localException4) {
/*     */       }try { pstmt.close(); } catch (Exception localException5) {
/*     */       }
/* 310 */       if (i == 0)
/*     */       {
/* 312 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 316 */             this.con.close();
/*     */           } catch (Exception localException6) {
/*     */           }
/*     */         }
/* 320 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 326 */       CError tError = new CError();
/* 327 */       tError.moduleName = "LNPRiskSaleGroupDB";
/* 328 */       tError.functionName = "getInfo";
/* 329 */       tError.errorMessage = e.toString();
/* 330 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 332 */         rs.close(); } catch (Exception localException7) {
/*     */       }try { pstmt.close(); } catch (Exception localException8) {
/*     */       }
/* 335 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 339 */           this.con.close();
/*     */         } catch (Exception localException9) {
/*     */         }
/*     */       }
/* 343 */       return false;
/*     */     }
/*     */ 
/* 346 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 350 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException10) {
/*     */       }
/*     */     }
/* 355 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPRiskSaleGroupSet query()
/*     */   {
/* 360 */     Statement stmt = null;
/* 361 */     ResultSet rs = null;
/* 362 */     LNPRiskSaleGroupSet aLNPRiskSaleGroupSet = new LNPRiskSaleGroupSet();
/*     */ 
/* 364 */     if (!this.mflag) {
/* 365 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 370 */       stmt = this.con.createStatement(1003, 1007);
/* 371 */       SQLString sqlObj = new SQLString("LNPRiskSaleGroup");
/* 372 */       LNPRiskSaleGroupSchema aSchema = getSchema();
/* 373 */       sqlObj.setSQL(5, aSchema);
/* 374 */       String sql = sqlObj.getSQL();
/*     */ 
/* 376 */       rs = stmt.executeQuery(sql);
/* 377 */       int i = 0;
/* 378 */       while (rs.next())
/*     */       {
/* 380 */         i++;
/* 381 */         LNPRiskSaleGroupSchema s1 = new LNPRiskSaleGroupSchema();
/* 382 */         s1.setSchema(rs, i);
/* 383 */         aLNPRiskSaleGroupSet.add(s1);
/*     */       }try {
/* 385 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 391 */       CError tError = new CError();
/* 392 */       tError.moduleName = "LNPRiskSaleGroupDB";
/* 393 */       tError.functionName = "query";
/* 394 */       tError.errorMessage = e.toString();
/* 395 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 397 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 400 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 404 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 410 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 414 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 419 */     return aLNPRiskSaleGroupSet;
/*     */   }
/*     */ 
/*     */   public LNPRiskSaleGroupSet executeQuery(String sql)
/*     */   {
/* 424 */     Statement stmt = null;
/* 425 */     ResultSet rs = null;
/* 426 */     LNPRiskSaleGroupSet aLNPRiskSaleGroupSet = new LNPRiskSaleGroupSet();
/*     */ 
/* 428 */     if (!this.mflag) {
/* 429 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 434 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 436 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 437 */       int i = 0;
/* 438 */       while (rs.next())
/*     */       {
/* 440 */         i++;
/* 441 */         LNPRiskSaleGroupSchema s1 = new LNPRiskSaleGroupSchema();
/* 442 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 445 */           CError tError = new CError();
/* 446 */           tError.moduleName = "LNPRiskSaleGroupDB";
/* 447 */           tError.functionName = "executeQuery";
/* 448 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/* 449 */           this.mErrors.addOneError(tError);
/*     */         }
/* 451 */         aLNPRiskSaleGroupSet.add(s1);
/*     */       }try {
/* 453 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 459 */       CError tError = new CError();
/* 460 */       tError.moduleName = "LNPRiskSaleGroupDB";
/* 461 */       tError.functionName = "executeQuery";
/* 462 */       tError.errorMessage = e.toString();
/* 463 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 465 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 468 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 472 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 478 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 482 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 487 */     return aLNPRiskSaleGroupSet;
/*     */   }
/*     */ 
/*     */   public LNPRiskSaleGroupSet query(int nStart, int nCount)
/*     */   {
/* 492 */     Statement stmt = null;
/* 493 */     ResultSet rs = null;
/* 494 */     LNPRiskSaleGroupSet aLNPRiskSaleGroupSet = new LNPRiskSaleGroupSet();
/*     */ 
/* 496 */     if (!this.mflag) {
/* 497 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 502 */       stmt = this.con.createStatement(1003, 1007);
/* 503 */       SQLString sqlObj = new SQLString("LNPRiskSaleGroup");
/* 504 */       LNPRiskSaleGroupSchema aSchema = getSchema();
/* 505 */       sqlObj.setSQL(5, aSchema);
/* 506 */       String sql = sqlObj.getSQL();
/*     */ 
/* 508 */       rs = stmt.executeQuery(sql);
/* 509 */       int i = 0;
/* 510 */       while (rs.next())
/*     */       {
/* 512 */         i++;
/*     */ 
/* 514 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 518 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 522 */         LNPRiskSaleGroupSchema s1 = new LNPRiskSaleGroupSchema();
/* 523 */         s1.setSchema(rs, i);
/* 524 */         aLNPRiskSaleGroupSet.add(s1);
/*     */       }try {
/* 526 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 532 */       CError tError = new CError();
/* 533 */       tError.moduleName = "LNPRiskSaleGroupDB";
/* 534 */       tError.functionName = "query";
/* 535 */       tError.errorMessage = e.toString();
/* 536 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 538 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 541 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 545 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 551 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 555 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 560 */     return aLNPRiskSaleGroupSet;
/*     */   }
/*     */ 
/*     */   public LNPRiskSaleGroupSet executeQuery(String sql, int nStart, int nCount)
/*     */   {
/* 565 */     Statement stmt = null;
/* 566 */     ResultSet rs = null;
/* 567 */     LNPRiskSaleGroupSet aLNPRiskSaleGroupSet = new LNPRiskSaleGroupSet();
/*     */ 
/* 569 */     if (!this.mflag) {
/* 570 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 575 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 577 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 578 */       int i = 0;
/* 579 */       while (rs.next())
/*     */       {
/* 581 */         i++;
/*     */ 
/* 583 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 587 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 591 */         LNPRiskSaleGroupSchema s1 = new LNPRiskSaleGroupSchema();
/* 592 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 595 */           CError tError = new CError();
/* 596 */           tError.moduleName = "LNPRiskSaleGroupDB";
/* 597 */           tError.functionName = "executeQuery";
/* 598 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/* 599 */           this.mErrors.addOneError(tError);
/*     */         }
/* 601 */         aLNPRiskSaleGroupSet.add(s1);
/*     */       }try {
/* 603 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 609 */       CError tError = new CError();
/* 610 */       tError.moduleName = "LNPRiskSaleGroupDB";
/* 611 */       tError.functionName = "executeQuery";
/* 612 */       tError.errorMessage = e.toString();
/* 613 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 615 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 618 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 622 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 628 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 632 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 637 */     return aLNPRiskSaleGroupSet;
/*     */   }
/*     */ 
/*     */   public boolean update(String strWherePart)
/*     */   {
/* 642 */     Statement stmt = null;
/*     */ 
/* 644 */     if (!this.mflag) {
/* 645 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 650 */       stmt = this.con.createStatement(1003, 1007);
/* 651 */       SQLString sqlObj = new SQLString("LNPRiskSaleGroup");
/* 652 */       LNPRiskSaleGroupSchema aSchema = getSchema();
/* 653 */       sqlObj.setSQL(2, aSchema);
/* 654 */       String sql = "update LNPRiskSaleGroup " + sqlObj.getUpdPart() + " where " + strWherePart;
/*     */ 
/* 656 */       int operCount = stmt.executeUpdate(sql);
/* 657 */       if (operCount == 0)
/*     */       {
/* 660 */         CError tError = new CError();
/* 661 */         tError.moduleName = "LNPRiskSaleGroupDB";
/* 662 */         tError.functionName = "update";
/* 663 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/* 664 */         this.mErrors.addOneError(tError);
/*     */ 
/* 666 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 670 */             this.con.close();
/*     */           } catch (Exception localException1) {
/*     */           }
/*     */         }
/* 674 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 680 */       CError tError = new CError();
/* 681 */       tError.moduleName = "LNPRiskSaleGroupDB";
/* 682 */       tError.functionName = "update";
/* 683 */       tError.errorMessage = e.toString();
/* 684 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 686 */         stmt.close(); } catch (Exception localException2) {
/*     */       }
/* 688 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 692 */           this.con.close();
/*     */         } catch (Exception localException3) {
/*     */         }
/*     */       }
/* 696 */       return false;
/*     */     }
/*     */ 
/* 699 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 703 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException4) {
/*     */       }
/*     */     }
/* 708 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean prepareData(String strSQL)
/*     */   {
/* 714 */     if (this.mResultSet != null)
/*     */     {
/* 717 */       CError tError = new CError();
/* 718 */       tError.moduleName = "LNPRiskSaleGroupDB";
/* 719 */       tError.functionName = "prepareData";
/* 720 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/* 721 */       this.mErrors.addOneError(tError);
/* 722 */       return false;
/*     */     }
/*     */ 
/* 725 */     if (!this.mflag)
/*     */     {
/* 727 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */     try
/*     */     {
/* 731 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 732 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 737 */       CError tError = new CError();
/* 738 */       tError.moduleName = "LNPRiskSaleGroupDB";
/* 739 */       tError.functionName = "prepareData";
/* 740 */       tError.errorMessage = e.toString();
/* 741 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 744 */         this.mResultSet.close();
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 750 */         this.mStatement.close();
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 754 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 758 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 763 */       return false;
/*     */     }
/*     */ 
/* 766 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 770 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException4) {
/*     */       }
/*     */     }
/* 775 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean hasMoreData()
/*     */   {
/* 781 */     boolean flag = true;
/* 782 */     if (this.mResultSet == null)
/*     */     {
/* 784 */       CError tError = new CError();
/* 785 */       tError.moduleName = "LNPRiskSaleGroupDB";
/* 786 */       tError.functionName = "hasMoreData";
/* 787 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 788 */       this.mErrors.addOneError(tError);
/* 789 */       return false;
/*     */     }
/*     */     try
/*     */     {
/* 793 */       flag = this.mResultSet.next();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 797 */       CError tError = new CError();
/* 798 */       tError.moduleName = "LNPRiskSaleGroupDB";
/* 799 */       tError.functionName = "hasMoreData";
/* 800 */       tError.errorMessage = ex.toString();
/* 801 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 804 */         this.mResultSet.close();
/* 805 */         this.mResultSet = null;
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 811 */         this.mStatement.close();
/* 812 */         this.mStatement = null;
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 816 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 820 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 825 */       return false;
/*     */     }
/* 827 */     return flag;
/*     */   }
/*     */ 
/*     */   public LNPRiskSaleGroupSet getData()
/*     */   {
/* 832 */     int tCount = 0;
/* 833 */     LNPRiskSaleGroupSet tLNPRiskSaleGroupSet = new LNPRiskSaleGroupSet();
/* 834 */     LNPRiskSaleGroupSchema tLNPRiskSaleGroupSchema = null;
/* 835 */     if (this.mResultSet == null)
/*     */     {
/* 837 */       CError tError = new CError();
/* 838 */       tError.moduleName = "LNPRiskSaleGroupDB";
/* 839 */       tError.functionName = "getData";
/* 840 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 841 */       this.mErrors.addOneError(tError);
/* 842 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 846 */       tCount = 1;
/* 847 */       tLNPRiskSaleGroupSchema = new LNPRiskSaleGroupSchema();
/* 848 */       tLNPRiskSaleGroupSchema.setSchema(this.mResultSet, 1);
/* 849 */       tLNPRiskSaleGroupSet.add(tLNPRiskSaleGroupSchema);
/*     */ 
/* 851 */       while (tCount++ < 5000)
/*     */       {
/* 853 */         if (!this.mResultSet.next())
/*     */           continue;
/* 855 */         tLNPRiskSaleGroupSchema = new LNPRiskSaleGroupSchema();
/* 856 */         tLNPRiskSaleGroupSchema.setSchema(this.mResultSet, 1);
/* 857 */         tLNPRiskSaleGroupSet.add(tLNPRiskSaleGroupSchema);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 863 */       CError tError = new CError();
/* 864 */       tError.moduleName = "LNPRiskSaleGroupDB";
/* 865 */       tError.functionName = "getData";
/* 866 */       tError.errorMessage = ex.toString();
/* 867 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 870 */         this.mResultSet.close();
/* 871 */         this.mResultSet = null;
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 877 */         this.mStatement.close();
/* 878 */         this.mStatement = null;
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 882 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 886 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 891 */       return null;
/*     */     }
/* 893 */     return tLNPRiskSaleGroupSet;
/*     */   }
/*     */ 
/*     */   public boolean closeData()
/*     */   {
/* 898 */     boolean flag = true;
/*     */     try
/*     */     {
/* 901 */       if (this.mResultSet == null)
/*     */       {
/* 903 */         CError tError = new CError();
/* 904 */         tError.moduleName = "LNPRiskSaleGroupDB";
/* 905 */         tError.functionName = "closeData";
/* 906 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 907 */         this.mErrors.addOneError(tError);
/* 908 */         flag = false;
/*     */       }
/*     */       else
/*     */       {
/* 912 */         this.mResultSet.close();
/* 913 */         this.mResultSet = null;
/*     */       }
/*     */     }
/*     */     catch (Exception ex2)
/*     */     {
/* 918 */       CError tError = new CError();
/* 919 */       tError.moduleName = "LNPRiskSaleGroupDB";
/* 920 */       tError.functionName = "closeData";
/* 921 */       tError.errorMessage = ex2.toString();
/* 922 */       this.mErrors.addOneError(tError);
/* 923 */       flag = false;
/*     */     }
/*     */     try
/*     */     {
/* 927 */       if (this.mStatement == null)
/*     */       {
/* 929 */         CError tError = new CError();
/* 930 */         tError.moduleName = "LNPRiskSaleGroupDB";
/* 931 */         tError.functionName = "closeData";
/* 932 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 933 */         this.mErrors.addOneError(tError);
/* 934 */         flag = false;
/*     */       }
/*     */       else
/*     */       {
/* 938 */         this.mStatement.close();
/* 939 */         this.mStatement = null;
/*     */       }
/*     */     }
/*     */     catch (Exception ex3)
/*     */     {
/* 944 */       CError tError = new CError();
/* 945 */       tError.moduleName = "LNPRiskSaleGroupDB";
/* 946 */       tError.functionName = "closeData";
/* 947 */       tError.errorMessage = ex3.toString();
/* 948 */       this.mErrors.addOneError(tError);
/* 949 */       flag = false;
/*     */     }
/* 951 */     return flag;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPRiskSaleGroupDB
 * JD-Core Version:    0.6.0
 */