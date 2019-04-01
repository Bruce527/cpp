/*     */ package com.sinosoft.banklns.lis.db;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPMaxNoSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPMaxNoSet;
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
/*     */ public class LNPMaxNoDB extends LNPMaxNoSchema
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
/*     */   public LNPMaxNoDB(Connection tConnection)
/*     */   {
/*  32 */     this.con = tConnection;
/*  33 */     this.db = new DBOper(this.con, "LNPMaxNo");
/*  34 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPMaxNoDB()
/*     */   {
/*  39 */     this.con = null;
/*  40 */     this.db = new DBOper("LNPMaxNo");
/*  41 */     this.mflag = false;
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  47 */     LNPMaxNoSchema tSchema = getSchema();
/*  48 */     if (this.db.deleteSQL(tSchema))
/*     */     {
/*  50 */       return true;
/*     */     }
/*     */ 
/*  55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*  56 */     CError tError = new CError();
/*  57 */     tError.moduleName = "LNPMaxNoDB";
/*  58 */     tError.functionName = "deleteSQL";
/*  59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*  60 */     this.mErrors.addOneError(tError);
/*  61 */     return false;
/*     */   }
/*     */ 
/*     */   public int getCount()
/*     */   {
/*  67 */     LNPMaxNoSchema tSchema = getSchema();
/*     */ 
/*  69 */     int tCount = this.db.getCount(tSchema);
/*  70 */     if (tCount < 0)
/*     */     {
/*  73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  74 */       CError tError = new CError();
/*  75 */       tError.moduleName = "LNPMaxNoDB";
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
/*  96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPMaxNo WHERE  NoType = ? AND NoLimit = ?");
/*  97 */       if ((getNoType() == null) || (getNoType().equals("null")))
/*  98 */         pstmt.setNull(1, 12);
/*     */       else {
/* 100 */         pstmt.setString(1, getNoType());
/*     */       }
/* 102 */       if ((getNoLimit() == null) || (getNoLimit().equals("null")))
/* 103 */         pstmt.setNull(2, 12);
/*     */       else {
/* 105 */         pstmt.setString(2, getNoLimit());
/*     */       }
/* 107 */       pstmt.executeUpdate();
/* 108 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 111 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 112 */       CError tError = new CError();
/* 113 */       tError.moduleName = "LNPMaxNoDB";
/* 114 */       tError.functionName = "delete()";
/* 115 */       tError.errorMessage = ex.toString();
/* 116 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 119 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 122 */       if (!this.mflag)
/*     */         try {
/* 124 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 128 */       return false;
/*     */     }
/*     */ 
/* 131 */     if (!this.mflag)
/*     */       try {
/* 133 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 137 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 142 */     PreparedStatement pstmt = null;
/*     */ 
/* 144 */     if (!this.mflag) {
/* 145 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 150 */       pstmt = this.con.prepareStatement("UPDATE LNPMaxNo SET  NoType = ? , NoLimit = ? , MaxNo = ? WHERE  NoType = ? AND NoLimit = ?");
/* 151 */       if ((getNoType() == null) || (getNoType().equals("null")))
/* 152 */         pstmt.setNull(1, 12);
/*     */       else {
/* 154 */         pstmt.setString(1, getNoType());
/*     */       }
/* 156 */       if ((getNoLimit() == null) || (getNoLimit().equals("null")))
/* 157 */         pstmt.setNull(2, 12);
/*     */       else {
/* 159 */         pstmt.setString(2, getNoLimit());
/*     */       }
/* 161 */       pstmt.setInt(3, getMaxNo());
/*     */ 
/* 163 */       if ((getNoType() == null) || (getNoType().equals("null")))
/* 164 */         pstmt.setNull(4, 12);
/*     */       else {
/* 166 */         pstmt.setString(4, getNoType());
/*     */       }
/* 168 */       if ((getNoLimit() == null) || (getNoLimit().equals("null")))
/* 169 */         pstmt.setNull(5, 12);
/*     */       else {
/* 171 */         pstmt.setString(5, getNoLimit());
/*     */       }
/* 173 */       pstmt.executeUpdate();
/* 174 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 177 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 178 */       CError tError = new CError();
/* 179 */       tError.moduleName = "LNPMaxNoDB";
/* 180 */       tError.functionName = "update()";
/* 181 */       tError.errorMessage = ex.toString();
/* 182 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 185 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 188 */       if (!this.mflag)
/*     */         try {
/* 190 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 194 */       return false;
/*     */     }
/*     */ 
/* 197 */     if (!this.mflag)
/*     */       try {
/* 199 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 203 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 208 */     PreparedStatement pstmt = null;
/*     */ 
/* 210 */     if (!this.mflag) {
/* 211 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 216 */       pstmt = this.con.prepareStatement("INSERT INTO LNPMaxNo VALUES( ? , ? , ?)");
/* 217 */       if ((getNoType() == null) || (getNoType().equals("null")))
/* 218 */         pstmt.setNull(1, 12);
/*     */       else {
/* 220 */         pstmt.setString(1, getNoType());
/*     */       }
/* 222 */       if ((getNoLimit() == null) || (getNoLimit().equals("null")))
/* 223 */         pstmt.setNull(2, 12);
/*     */       else {
/* 225 */         pstmt.setString(2, getNoLimit());
/*     */       }
/* 227 */       pstmt.setInt(3, getMaxNo());
/*     */ 
/* 229 */       pstmt.executeUpdate();
/* 230 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 233 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 234 */       CError tError = new CError();
/* 235 */       tError.moduleName = "LNPMaxNoDB";
/* 236 */       tError.functionName = "insert()";
/* 237 */       tError.errorMessage = ex.toString();
/* 238 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 241 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 244 */       if (!this.mflag)
/*     */         try {
/* 246 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 250 */       return false;
/*     */     }
/*     */ 
/* 253 */     if (!this.mflag)
/*     */       try {
/* 255 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 259 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean getInfo()
/*     */   {
/* 264 */     PreparedStatement pstmt = null;
/* 265 */     ResultSet rs = null;
/*     */ 
/* 267 */     if (!this.mflag) {
/* 268 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 273 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPMaxNo WHERE  NoType = ? AND NoLimit = ?", 
/* 274 */         1003, 1007);
/* 275 */       if ((getNoType() == null) || (getNoType().equals("null")))
/* 276 */         pstmt.setNull(1, 12);
/*     */       else {
/* 278 */         pstmt.setString(1, getNoType());
/*     */       }
/* 280 */       if ((getNoLimit() == null) || (getNoLimit().equals("null")))
/* 281 */         pstmt.setNull(2, 12);
/*     */       else {
/* 283 */         pstmt.setString(2, getNoLimit());
/*     */       }
/* 285 */       rs = pstmt.executeQuery();
/* 286 */       int i = 0;
/* 287 */       if (rs.next())
/*     */       {
/* 289 */         i++;
/* 290 */         if (!setSchema(rs, i))
/*     */         {
/* 293 */           CError tError = new CError();
/* 294 */           tError.moduleName = "LNPMaxNoDB";
/* 295 */           tError.functionName = "getInfo";
/* 296 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/* 297 */           this.mErrors.addOneError(tError);
/*     */           try {
/* 299 */             rs.close(); } catch (Exception localException1) {
/*     */           }try { pstmt.close(); } catch (Exception localException2) {
/*     */           }
/* 302 */           if (!this.mflag)
/*     */           {
/*     */             try
/*     */             {
/* 306 */               this.con.close();
/*     */             } catch (Exception localException3) {
/*     */             }
/*     */           }
/* 310 */           return false;
/*     */         }
/*     */       }
/*     */       try {
/* 314 */         rs.close(); } catch (Exception localException4) {
/*     */       }try { pstmt.close(); } catch (Exception localException5) {
/*     */       }
/* 317 */       if (i == 0)
/*     */       {
/* 319 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 323 */             this.con.close();
/*     */           } catch (Exception localException6) {
/*     */           }
/*     */         }
/* 327 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 333 */       CError tError = new CError();
/* 334 */       tError.moduleName = "LNPMaxNoDB";
/* 335 */       tError.functionName = "getInfo";
/* 336 */       tError.errorMessage = e.toString();
/* 337 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 339 */         rs.close(); } catch (Exception localException7) {
/*     */       }try { pstmt.close(); } catch (Exception localException8) {
/*     */       }
/* 342 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 346 */           this.con.close();
/*     */         } catch (Exception localException9) {
/*     */         }
/*     */       }
/* 350 */       return false;
/*     */     }
/*     */ 
/* 353 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 357 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException10) {
/*     */       }
/*     */     }
/* 362 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPMaxNoSet query()
/*     */   {
/* 367 */     Statement stmt = null;
/* 368 */     ResultSet rs = null;
/* 369 */     LNPMaxNoSet aLNPMaxNoSet = new LNPMaxNoSet();
/*     */ 
/* 371 */     if (!this.mflag) {
/* 372 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 377 */       stmt = this.con.createStatement(1003, 1007);
/* 378 */       SQLString sqlObj = new SQLString("LNPMaxNo");
/* 379 */       LNPMaxNoSchema aSchema = getSchema();
/* 380 */       sqlObj.setSQL(5, aSchema);
/* 381 */       String sql = sqlObj.getSQL();
/*     */ 
/* 383 */       rs = stmt.executeQuery(sql);
/* 384 */       int i = 0;
/* 385 */       while (rs.next())
/*     */       {
/* 387 */         i++;
/* 388 */         LNPMaxNoSchema s1 = new LNPMaxNoSchema();
/* 389 */         s1.setSchema(rs, i);
/* 390 */         aLNPMaxNoSet.add(s1);
/*     */       }try {
/* 392 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 398 */       CError tError = new CError();
/* 399 */       tError.moduleName = "LNPMaxNoDB";
/* 400 */       tError.functionName = "query";
/* 401 */       tError.errorMessage = e.toString();
/* 402 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 404 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 407 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 411 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 417 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 421 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 426 */     return aLNPMaxNoSet;
/*     */   }
/*     */ 
/*     */   public LNPMaxNoSet executeQuery(String sql)
/*     */   {
/* 431 */     Statement stmt = null;
/* 432 */     ResultSet rs = null;
/* 433 */     LNPMaxNoSet aLNPMaxNoSet = new LNPMaxNoSet();
/*     */ 
/* 435 */     if (!this.mflag) {
/* 436 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 441 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 443 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 444 */       int i = 0;
/* 445 */       while (rs.next())
/*     */       {
/* 447 */         i++;
/* 448 */         LNPMaxNoSchema s1 = new LNPMaxNoSchema();
/* 449 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 452 */           CError tError = new CError();
/* 453 */           tError.moduleName = "LNPMaxNoDB";
/* 454 */           tError.functionName = "executeQuery";
/* 455 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/* 456 */           this.mErrors.addOneError(tError);
/*     */         }
/* 458 */         aLNPMaxNoSet.add(s1);
/*     */       }try {
/* 460 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 466 */       CError tError = new CError();
/* 467 */       tError.moduleName = "LNPMaxNoDB";
/* 468 */       tError.functionName = "executeQuery";
/* 469 */       tError.errorMessage = e.toString();
/* 470 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 472 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 475 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 479 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 485 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 489 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 494 */     return aLNPMaxNoSet;
/*     */   }
/*     */ 
/*     */   public LNPMaxNoSet query(int nStart, int nCount)
/*     */   {
/* 499 */     Statement stmt = null;
/* 500 */     ResultSet rs = null;
/* 501 */     LNPMaxNoSet aLNPMaxNoSet = new LNPMaxNoSet();
/*     */ 
/* 503 */     if (!this.mflag) {
/* 504 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 509 */       stmt = this.con.createStatement(1003, 1007);
/* 510 */       SQLString sqlObj = new SQLString("LNPMaxNo");
/* 511 */       LNPMaxNoSchema aSchema = getSchema();
/* 512 */       sqlObj.setSQL(5, aSchema);
/* 513 */       String sql = sqlObj.getSQL();
/*     */ 
/* 515 */       rs = stmt.executeQuery(sql);
/* 516 */       int i = 0;
/* 517 */       while (rs.next())
/*     */       {
/* 519 */         i++;
/*     */ 
/* 521 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 525 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 529 */         LNPMaxNoSchema s1 = new LNPMaxNoSchema();
/* 530 */         s1.setSchema(rs, i);
/* 531 */         aLNPMaxNoSet.add(s1);
/*     */       }try {
/* 533 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 539 */       CError tError = new CError();
/* 540 */       tError.moduleName = "LNPMaxNoDB";
/* 541 */       tError.functionName = "query";
/* 542 */       tError.errorMessage = e.toString();
/* 543 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 545 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 548 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 552 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 558 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 562 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 567 */     return aLNPMaxNoSet;
/*     */   }
/*     */ 
/*     */   public LNPMaxNoSet executeQuery(String sql, int nStart, int nCount)
/*     */   {
/* 572 */     Statement stmt = null;
/* 573 */     ResultSet rs = null;
/* 574 */     LNPMaxNoSet aLNPMaxNoSet = new LNPMaxNoSet();
/*     */ 
/* 576 */     if (!this.mflag) {
/* 577 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 582 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 584 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 585 */       int i = 0;
/* 586 */       while (rs.next())
/*     */       {
/* 588 */         i++;
/*     */ 
/* 590 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 594 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 598 */         LNPMaxNoSchema s1 = new LNPMaxNoSchema();
/* 599 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 602 */           CError tError = new CError();
/* 603 */           tError.moduleName = "LNPMaxNoDB";
/* 604 */           tError.functionName = "executeQuery";
/* 605 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/* 606 */           this.mErrors.addOneError(tError);
/*     */         }
/* 608 */         aLNPMaxNoSet.add(s1);
/*     */       }try {
/* 610 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 616 */       CError tError = new CError();
/* 617 */       tError.moduleName = "LNPMaxNoDB";
/* 618 */       tError.functionName = "executeQuery";
/* 619 */       tError.errorMessage = e.toString();
/* 620 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 622 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 625 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 629 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 635 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 639 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 644 */     return aLNPMaxNoSet;
/*     */   }
/*     */ 
/*     */   public boolean update(String strWherePart)
/*     */   {
/* 649 */     Statement stmt = null;
/*     */ 
/* 651 */     if (!this.mflag) {
/* 652 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 657 */       stmt = this.con.createStatement(1003, 1007);
/* 658 */       SQLString sqlObj = new SQLString("LNPMaxNo");
/* 659 */       LNPMaxNoSchema aSchema = getSchema();
/* 660 */       sqlObj.setSQL(2, aSchema);
/* 661 */       String sql = "update LNPMaxNo " + sqlObj.getUpdPart() + " where " + strWherePart;
/*     */ 
/* 663 */       int operCount = stmt.executeUpdate(sql);
/* 664 */       if (operCount == 0)
/*     */       {
/* 667 */         CError tError = new CError();
/* 668 */         tError.moduleName = "LNPMaxNoDB";
/* 669 */         tError.functionName = "update";
/* 670 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/* 671 */         this.mErrors.addOneError(tError);
/*     */ 
/* 673 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 677 */             this.con.close();
/*     */           } catch (Exception localException1) {
/*     */           }
/*     */         }
/* 681 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 687 */       CError tError = new CError();
/* 688 */       tError.moduleName = "LNPMaxNoDB";
/* 689 */       tError.functionName = "update";
/* 690 */       tError.errorMessage = e.toString();
/* 691 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 693 */         stmt.close(); } catch (Exception localException2) {
/*     */       }
/* 695 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 699 */           this.con.close();
/*     */         } catch (Exception localException3) {
/*     */         }
/*     */       }
/* 703 */       return false;
/*     */     }
/*     */ 
/* 706 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 710 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException4) {
/*     */       }
/*     */     }
/* 715 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean prepareData(String strSQL)
/*     */   {
/* 721 */     if (this.mResultSet != null)
/*     */     {
/* 724 */       CError tError = new CError();
/* 725 */       tError.moduleName = "LNPMaxNoDB";
/* 726 */       tError.functionName = "prepareData";
/* 727 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/* 728 */       this.mErrors.addOneError(tError);
/* 729 */       return false;
/*     */     }
/*     */ 
/* 732 */     if (!this.mflag)
/*     */     {
/* 734 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */     try
/*     */     {
/* 738 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 739 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 744 */       CError tError = new CError();
/* 745 */       tError.moduleName = "LNPMaxNoDB";
/* 746 */       tError.functionName = "prepareData";
/* 747 */       tError.errorMessage = e.toString();
/* 748 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 751 */         this.mResultSet.close();
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 757 */         this.mStatement.close();
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 761 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 765 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 770 */       return false;
/*     */     }
/*     */ 
/* 773 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 777 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException4) {
/*     */       }
/*     */     }
/* 782 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean hasMoreData()
/*     */   {
/* 788 */     boolean flag = true;
/* 789 */     if (this.mResultSet == null)
/*     */     {
/* 791 */       CError tError = new CError();
/* 792 */       tError.moduleName = "LNPMaxNoDB";
/* 793 */       tError.functionName = "hasMoreData";
/* 794 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 795 */       this.mErrors.addOneError(tError);
/* 796 */       return false;
/*     */     }
/*     */     try
/*     */     {
/* 800 */       flag = this.mResultSet.next();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 804 */       CError tError = new CError();
/* 805 */       tError.moduleName = "LNPMaxNoDB";
/* 806 */       tError.functionName = "hasMoreData";
/* 807 */       tError.errorMessage = ex.toString();
/* 808 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 811 */         this.mResultSet.close();
/* 812 */         this.mResultSet = null;
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 818 */         this.mStatement.close();
/* 819 */         this.mStatement = null;
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 823 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 827 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 832 */       return false;
/*     */     }
/* 834 */     return flag;
/*     */   }
/*     */ 
/*     */   public LNPMaxNoSet getData()
/*     */   {
/* 839 */     int tCount = 0;
/* 840 */     LNPMaxNoSet tLNPMaxNoSet = new LNPMaxNoSet();
/* 841 */     LNPMaxNoSchema tLNPMaxNoSchema = null;
/* 842 */     if (this.mResultSet == null)
/*     */     {
/* 844 */       CError tError = new CError();
/* 845 */       tError.moduleName = "LNPMaxNoDB";
/* 846 */       tError.functionName = "getData";
/* 847 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 848 */       this.mErrors.addOneError(tError);
/* 849 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 853 */       tCount = 1;
/* 854 */       tLNPMaxNoSchema = new LNPMaxNoSchema();
/* 855 */       tLNPMaxNoSchema.setSchema(this.mResultSet, 1);
/* 856 */       tLNPMaxNoSet.add(tLNPMaxNoSchema);
/*     */ 
/* 858 */       while (tCount++ < 5000)
/*     */       {
/* 860 */         if (!this.mResultSet.next())
/*     */           continue;
/* 862 */         tLNPMaxNoSchema = new LNPMaxNoSchema();
/* 863 */         tLNPMaxNoSchema.setSchema(this.mResultSet, 1);
/* 864 */         tLNPMaxNoSet.add(tLNPMaxNoSchema);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 870 */       CError tError = new CError();
/* 871 */       tError.moduleName = "LNPMaxNoDB";
/* 872 */       tError.functionName = "getData";
/* 873 */       tError.errorMessage = ex.toString();
/* 874 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 877 */         this.mResultSet.close();
/* 878 */         this.mResultSet = null;
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 884 */         this.mStatement.close();
/* 885 */         this.mStatement = null;
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 889 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 893 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 898 */       return null;
/*     */     }
/* 900 */     return tLNPMaxNoSet;
/*     */   }
/*     */ 
/*     */   public boolean closeData()
/*     */   {
/* 905 */     boolean flag = true;
/*     */     try
/*     */     {
/* 908 */       if (this.mResultSet == null)
/*     */       {
/* 910 */         CError tError = new CError();
/* 911 */         tError.moduleName = "LNPMaxNoDB";
/* 912 */         tError.functionName = "closeData";
/* 913 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 914 */         this.mErrors.addOneError(tError);
/* 915 */         flag = false;
/*     */       }
/*     */       else
/*     */       {
/* 919 */         this.mResultSet.close();
/* 920 */         this.mResultSet = null;
/*     */       }
/*     */     }
/*     */     catch (Exception ex2)
/*     */     {
/* 925 */       CError tError = new CError();
/* 926 */       tError.moduleName = "LNPMaxNoDB";
/* 927 */       tError.functionName = "closeData";
/* 928 */       tError.errorMessage = ex2.toString();
/* 929 */       this.mErrors.addOneError(tError);
/* 930 */       flag = false;
/*     */     }
/*     */     try
/*     */     {
/* 934 */       if (this.mStatement == null)
/*     */       {
/* 936 */         CError tError = new CError();
/* 937 */         tError.moduleName = "LNPMaxNoDB";
/* 938 */         tError.functionName = "closeData";
/* 939 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 940 */         this.mErrors.addOneError(tError);
/* 941 */         flag = false;
/*     */       }
/*     */       else
/*     */       {
/* 945 */         this.mStatement.close();
/* 946 */         this.mStatement = null;
/*     */       }
/*     */     }
/*     */     catch (Exception ex3)
/*     */     {
/* 951 */       CError tError = new CError();
/* 952 */       tError.moduleName = "LNPMaxNoDB";
/* 953 */       tError.functionName = "closeData";
/* 954 */       tError.errorMessage = ex3.toString();
/* 955 */       this.mErrors.addOneError(tError);
/* 956 */       flag = false;
/*     */     }
/* 958 */     return flag;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPMaxNoDB
 * JD-Core Version:    0.6.0
 */