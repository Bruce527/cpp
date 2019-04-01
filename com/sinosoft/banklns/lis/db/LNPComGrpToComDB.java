/*     */ package com.sinosoft.banklns.lis.db;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPComGrpToComSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPComGrpToComSet;
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
/*     */ public class LNPComGrpToComDB extends LNPComGrpToComSchema
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
/*     */   public LNPComGrpToComDB(Connection tConnection)
/*     */   {
/*  32 */     this.con = tConnection;
/*  33 */     this.db = new DBOper(this.con, "LNPComGrpToCom");
/*  34 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPComGrpToComDB()
/*     */   {
/*  39 */     this.con = null;
/*  40 */     this.db = new DBOper("LNPComGrpToCom");
/*  41 */     this.mflag = false;
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  47 */     LNPComGrpToComSchema tSchema = getSchema();
/*  48 */     if (this.db.deleteSQL(tSchema))
/*     */     {
/*  50 */       return true;
/*     */     }
/*     */ 
/*  55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*  56 */     CError tError = new CError();
/*  57 */     tError.moduleName = "LNPComGrpToComDB";
/*  58 */     tError.functionName = "deleteSQL";
/*  59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*  60 */     this.mErrors.addOneError(tError);
/*  61 */     return false;
/*     */   }
/*     */ 
/*     */   public int getCount()
/*     */   {
/*  67 */     LNPComGrpToComSchema tSchema = getSchema();
/*     */ 
/*  69 */     int tCount = this.db.getCount(tSchema);
/*  70 */     if (tCount < 0)
/*     */     {
/*  73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  74 */       CError tError = new CError();
/*  75 */       tError.moduleName = "LNPComGrpToComDB";
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
/*  96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPComGrpToCom WHERE  ComGrpCode = ? AND ComCode = ?");
/*  97 */       if ((getComGrpCode() == null) || (getComGrpCode().equals("null")))
/*  98 */         pstmt.setNull(1, 12);
/*     */       else {
/* 100 */         pstmt.setString(1, getComGrpCode());
/*     */       }
/* 102 */       if ((getComCode() == null) || (getComCode().equals("null")))
/* 103 */         pstmt.setNull(2, 12);
/*     */       else {
/* 105 */         pstmt.setString(2, getComCode());
/*     */       }
/* 107 */       pstmt.executeUpdate();
/* 108 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 111 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 112 */       CError tError = new CError();
/* 113 */       tError.moduleName = "LNPComGrpToComDB";
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
/* 150 */       pstmt = this.con.prepareStatement("UPDATE LNPComGrpToCom SET  ComGrpCode = ? , ComCode = ? , ComCodeType = ? WHERE  ComGrpCode = ? AND ComCode = ?");
/* 151 */       if ((getComGrpCode() == null) || (getComGrpCode().equals("null")))
/* 152 */         pstmt.setNull(1, 12);
/*     */       else {
/* 154 */         pstmt.setString(1, getComGrpCode());
/*     */       }
/* 156 */       if ((getComCode() == null) || (getComCode().equals("null")))
/* 157 */         pstmt.setNull(2, 12);
/*     */       else {
/* 159 */         pstmt.setString(2, getComCode());
/*     */       }
/* 161 */       if ((getComCodeType() == null) || (getComCodeType().equals("null")))
/* 162 */         pstmt.setNull(3, 12);
/*     */       else {
/* 164 */         pstmt.setString(3, getComCodeType());
/*     */       }
/*     */ 
/* 167 */       if ((getComGrpCode() == null) || (getComGrpCode().equals("null")))
/* 168 */         pstmt.setNull(4, 12);
/*     */       else {
/* 170 */         pstmt.setString(4, getComGrpCode());
/*     */       }
/* 172 */       if ((getComCode() == null) || (getComCode().equals("null")))
/* 173 */         pstmt.setNull(5, 12);
/*     */       else {
/* 175 */         pstmt.setString(5, getComCode());
/*     */       }
/* 177 */       pstmt.executeUpdate();
/* 178 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 181 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 182 */       CError tError = new CError();
/* 183 */       tError.moduleName = "LNPComGrpToComDB";
/* 184 */       tError.functionName = "update()";
/* 185 */       tError.errorMessage = ex.toString();
/* 186 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 189 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 192 */       if (!this.mflag)
/*     */         try {
/* 194 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 198 */       return false;
/*     */     }
/*     */ 
/* 201 */     if (!this.mflag)
/*     */       try {
/* 203 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 207 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 212 */     PreparedStatement pstmt = null;
/*     */ 
/* 214 */     if (!this.mflag) {
/* 215 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 220 */       pstmt = this.con.prepareStatement("INSERT INTO LNPComGrpToCom VALUES( ? , ? , ?)");
/* 221 */       if ((getComGrpCode() == null) || (getComGrpCode().equals("null")))
/* 222 */         pstmt.setNull(1, 12);
/*     */       else {
/* 224 */         pstmt.setString(1, getComGrpCode());
/*     */       }
/* 226 */       if ((getComCode() == null) || (getComCode().equals("null")))
/* 227 */         pstmt.setNull(2, 12);
/*     */       else {
/* 229 */         pstmt.setString(2, getComCode());
/*     */       }
/* 231 */       if ((getComCodeType() == null) || (getComCodeType().equals("null")))
/* 232 */         pstmt.setNull(3, 12);
/*     */       else {
/* 234 */         pstmt.setString(3, getComCodeType());
/*     */       }
/*     */ 
/* 237 */       pstmt.executeUpdate();
/* 238 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 241 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 242 */       CError tError = new CError();
/* 243 */       tError.moduleName = "LNPComGrpToComDB";
/* 244 */       tError.functionName = "insert()";
/* 245 */       tError.errorMessage = ex.toString();
/* 246 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 249 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 252 */       if (!this.mflag)
/*     */         try {
/* 254 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 258 */       return false;
/*     */     }
/*     */ 
/* 261 */     if (!this.mflag)
/*     */       try {
/* 263 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 267 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean getInfo()
/*     */   {
/* 272 */     PreparedStatement pstmt = null;
/* 273 */     ResultSet rs = null;
/*     */ 
/* 275 */     if (!this.mflag) {
/* 276 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 281 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPComGrpToCom WHERE  ComGrpCode = ? AND ComCode = ?", 
/* 282 */         1003, 1007);
/* 283 */       if ((getComGrpCode() == null) || (getComGrpCode().equals("null")))
/* 284 */         pstmt.setNull(1, 12);
/*     */       else {
/* 286 */         pstmt.setString(1, getComGrpCode());
/*     */       }
/* 288 */       if ((getComCode() == null) || (getComCode().equals("null")))
/* 289 */         pstmt.setNull(2, 12);
/*     */       else {
/* 291 */         pstmt.setString(2, getComCode());
/*     */       }
/* 293 */       rs = pstmt.executeQuery();
/* 294 */       int i = 0;
/* 295 */       if (rs.next())
/*     */       {
/* 297 */         i++;
/* 298 */         if (!setSchema(rs, i))
/*     */         {
/* 301 */           CError tError = new CError();
/* 302 */           tError.moduleName = "LNPComGrpToComDB";
/* 303 */           tError.functionName = "getInfo";
/* 304 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/* 305 */           this.mErrors.addOneError(tError);
/*     */           try {
/* 307 */             rs.close(); } catch (Exception localException1) {
/*     */           }try { pstmt.close(); } catch (Exception localException2) {
/*     */           }
/* 310 */           if (!this.mflag)
/*     */           {
/*     */             try
/*     */             {
/* 314 */               this.con.close();
/*     */             } catch (Exception localException3) {
/*     */             }
/*     */           }
/* 318 */           return false;
/*     */         }
/*     */       }
/*     */       try {
/* 322 */         rs.close(); } catch (Exception localException4) {
/*     */       }try { pstmt.close(); } catch (Exception localException5) {
/*     */       }
/* 325 */       if (i == 0)
/*     */       {
/* 327 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 331 */             this.con.close();
/*     */           } catch (Exception localException6) {
/*     */           }
/*     */         }
/* 335 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 341 */       CError tError = new CError();
/* 342 */       tError.moduleName = "LNPComGrpToComDB";
/* 343 */       tError.functionName = "getInfo";
/* 344 */       tError.errorMessage = e.toString();
/* 345 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 347 */         rs.close(); } catch (Exception localException7) {
/*     */       }try { pstmt.close(); } catch (Exception localException8) {
/*     */       }
/* 350 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 354 */           this.con.close();
/*     */         } catch (Exception localException9) {
/*     */         }
/*     */       }
/* 358 */       return false;
/*     */     }
/*     */ 
/* 361 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 365 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException10) {
/*     */       }
/*     */     }
/* 370 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPComGrpToComSet query()
/*     */   {
/* 375 */     Statement stmt = null;
/* 376 */     ResultSet rs = null;
/* 377 */     LNPComGrpToComSet aLNPComGrpToComSet = new LNPComGrpToComSet();
/*     */ 
/* 379 */     if (!this.mflag) {
/* 380 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 385 */       stmt = this.con.createStatement(1003, 1007);
/* 386 */       SQLString sqlObj = new SQLString("LNPComGrpToCom");
/* 387 */       LNPComGrpToComSchema aSchema = getSchema();
/* 388 */       sqlObj.setSQL(5, aSchema);
/* 389 */       String sql = sqlObj.getSQL();
/*     */ 
/* 391 */       rs = stmt.executeQuery(sql);
/* 392 */       int i = 0;
/* 393 */       while (rs.next())
/*     */       {
/* 395 */         i++;
/* 396 */         LNPComGrpToComSchema s1 = new LNPComGrpToComSchema();
/* 397 */         s1.setSchema(rs, i);
/* 398 */         aLNPComGrpToComSet.add(s1);
/*     */       }try {
/* 400 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 406 */       CError tError = new CError();
/* 407 */       tError.moduleName = "LNPComGrpToComDB";
/* 408 */       tError.functionName = "query";
/* 409 */       tError.errorMessage = e.toString();
/* 410 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 412 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 415 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 419 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 425 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 429 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 434 */     return aLNPComGrpToComSet;
/*     */   }
/*     */ 
/*     */   public LNPComGrpToComSet executeQuery(String sql)
/*     */   {
/* 439 */     Statement stmt = null;
/* 440 */     ResultSet rs = null;
/* 441 */     LNPComGrpToComSet aLNPComGrpToComSet = new LNPComGrpToComSet();
/*     */ 
/* 443 */     if (!this.mflag) {
/* 444 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 449 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 451 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 452 */       int i = 0;
/* 453 */       while (rs.next())
/*     */       {
/* 455 */         i++;
/* 456 */         LNPComGrpToComSchema s1 = new LNPComGrpToComSchema();
/* 457 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 460 */           CError tError = new CError();
/* 461 */           tError.moduleName = "LNPComGrpToComDB";
/* 462 */           tError.functionName = "executeQuery";
/* 463 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/* 464 */           this.mErrors.addOneError(tError);
/*     */         }
/* 466 */         aLNPComGrpToComSet.add(s1);
/*     */       }try {
/* 468 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 474 */       CError tError = new CError();
/* 475 */       tError.moduleName = "LNPComGrpToComDB";
/* 476 */       tError.functionName = "executeQuery";
/* 477 */       tError.errorMessage = e.toString();
/* 478 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 480 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 483 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 487 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 493 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 497 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 502 */     return aLNPComGrpToComSet;
/*     */   }
/*     */ 
/*     */   public LNPComGrpToComSet query(int nStart, int nCount)
/*     */   {
/* 507 */     Statement stmt = null;
/* 508 */     ResultSet rs = null;
/* 509 */     LNPComGrpToComSet aLNPComGrpToComSet = new LNPComGrpToComSet();
/*     */ 
/* 511 */     if (!this.mflag) {
/* 512 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 517 */       stmt = this.con.createStatement(1003, 1007);
/* 518 */       SQLString sqlObj = new SQLString("LNPComGrpToCom");
/* 519 */       LNPComGrpToComSchema aSchema = getSchema();
/* 520 */       sqlObj.setSQL(5, aSchema);
/* 521 */       String sql = sqlObj.getSQL();
/*     */ 
/* 523 */       rs = stmt.executeQuery(sql);
/* 524 */       int i = 0;
/* 525 */       while (rs.next())
/*     */       {
/* 527 */         i++;
/*     */ 
/* 529 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 533 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 537 */         LNPComGrpToComSchema s1 = new LNPComGrpToComSchema();
/* 538 */         s1.setSchema(rs, i);
/* 539 */         aLNPComGrpToComSet.add(s1);
/*     */       }try {
/* 541 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 547 */       CError tError = new CError();
/* 548 */       tError.moduleName = "LNPComGrpToComDB";
/* 549 */       tError.functionName = "query";
/* 550 */       tError.errorMessage = e.toString();
/* 551 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 553 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 556 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 560 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 566 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 570 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 575 */     return aLNPComGrpToComSet;
/*     */   }
/*     */ 
/*     */   public LNPComGrpToComSet executeQuery(String sql, int nStart, int nCount)
/*     */   {
/* 580 */     Statement stmt = null;
/* 581 */     ResultSet rs = null;
/* 582 */     LNPComGrpToComSet aLNPComGrpToComSet = new LNPComGrpToComSet();
/*     */ 
/* 584 */     if (!this.mflag) {
/* 585 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 590 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 592 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 593 */       int i = 0;
/* 594 */       while (rs.next())
/*     */       {
/* 596 */         i++;
/*     */ 
/* 598 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 602 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 606 */         LNPComGrpToComSchema s1 = new LNPComGrpToComSchema();
/* 607 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 610 */           CError tError = new CError();
/* 611 */           tError.moduleName = "LNPComGrpToComDB";
/* 612 */           tError.functionName = "executeQuery";
/* 613 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/* 614 */           this.mErrors.addOneError(tError);
/*     */         }
/* 616 */         aLNPComGrpToComSet.add(s1);
/*     */       }try {
/* 618 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 624 */       CError tError = new CError();
/* 625 */       tError.moduleName = "LNPComGrpToComDB";
/* 626 */       tError.functionName = "executeQuery";
/* 627 */       tError.errorMessage = e.toString();
/* 628 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 630 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 633 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 637 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 643 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 647 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 652 */     return aLNPComGrpToComSet;
/*     */   }
/*     */ 
/*     */   public boolean update(String strWherePart)
/*     */   {
/* 657 */     Statement stmt = null;
/*     */ 
/* 659 */     if (!this.mflag) {
/* 660 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 665 */       stmt = this.con.createStatement(1003, 1007);
/* 666 */       SQLString sqlObj = new SQLString("LNPComGrpToCom");
/* 667 */       LNPComGrpToComSchema aSchema = getSchema();
/* 668 */       sqlObj.setSQL(2, aSchema);
/* 669 */       String sql = "update LNPComGrpToCom " + sqlObj.getUpdPart() + " where " + strWherePart;
/*     */ 
/* 671 */       int operCount = stmt.executeUpdate(sql);
/* 672 */       if (operCount == 0)
/*     */       {
/* 675 */         CError tError = new CError();
/* 676 */         tError.moduleName = "LNPComGrpToComDB";
/* 677 */         tError.functionName = "update";
/* 678 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/* 679 */         this.mErrors.addOneError(tError);
/*     */ 
/* 681 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 685 */             this.con.close();
/*     */           } catch (Exception localException1) {
/*     */           }
/*     */         }
/* 689 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 695 */       CError tError = new CError();
/* 696 */       tError.moduleName = "LNPComGrpToComDB";
/* 697 */       tError.functionName = "update";
/* 698 */       tError.errorMessage = e.toString();
/* 699 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 701 */         stmt.close(); } catch (Exception localException2) {
/*     */       }
/* 703 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 707 */           this.con.close();
/*     */         } catch (Exception localException3) {
/*     */         }
/*     */       }
/* 711 */       return false;
/*     */     }
/*     */ 
/* 714 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 718 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException4) {
/*     */       }
/*     */     }
/* 723 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean prepareData(String strSQL)
/*     */   {
/* 729 */     if (this.mResultSet != null)
/*     */     {
/* 732 */       CError tError = new CError();
/* 733 */       tError.moduleName = "LNPComGrpToComDB";
/* 734 */       tError.functionName = "prepareData";
/* 735 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/* 736 */       this.mErrors.addOneError(tError);
/* 737 */       return false;
/*     */     }
/*     */ 
/* 740 */     if (!this.mflag)
/*     */     {
/* 742 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */     try
/*     */     {
/* 746 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 747 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 752 */       CError tError = new CError();
/* 753 */       tError.moduleName = "LNPComGrpToComDB";
/* 754 */       tError.functionName = "prepareData";
/* 755 */       tError.errorMessage = e.toString();
/* 756 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 759 */         this.mResultSet.close();
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 765 */         this.mStatement.close();
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 769 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 773 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 778 */       return false;
/*     */     }
/*     */ 
/* 781 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 785 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException4) {
/*     */       }
/*     */     }
/* 790 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean hasMoreData()
/*     */   {
/* 796 */     boolean flag = true;
/* 797 */     if (this.mResultSet == null)
/*     */     {
/* 799 */       CError tError = new CError();
/* 800 */       tError.moduleName = "LNPComGrpToComDB";
/* 801 */       tError.functionName = "hasMoreData";
/* 802 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 803 */       this.mErrors.addOneError(tError);
/* 804 */       return false;
/*     */     }
/*     */     try
/*     */     {
/* 808 */       flag = this.mResultSet.next();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 812 */       CError tError = new CError();
/* 813 */       tError.moduleName = "LNPComGrpToComDB";
/* 814 */       tError.functionName = "hasMoreData";
/* 815 */       tError.errorMessage = ex.toString();
/* 816 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 819 */         this.mResultSet.close();
/* 820 */         this.mResultSet = null;
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 826 */         this.mStatement.close();
/* 827 */         this.mStatement = null;
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 831 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 835 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 840 */       return false;
/*     */     }
/* 842 */     return flag;
/*     */   }
/*     */ 
/*     */   public LNPComGrpToComSet getData()
/*     */   {
/* 847 */     int tCount = 0;
/* 848 */     LNPComGrpToComSet tLNPComGrpToComSet = new LNPComGrpToComSet();
/* 849 */     LNPComGrpToComSchema tLNPComGrpToComSchema = null;
/* 850 */     if (this.mResultSet == null)
/*     */     {
/* 852 */       CError tError = new CError();
/* 853 */       tError.moduleName = "LNPComGrpToComDB";
/* 854 */       tError.functionName = "getData";
/* 855 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 856 */       this.mErrors.addOneError(tError);
/* 857 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 861 */       tCount = 1;
/* 862 */       tLNPComGrpToComSchema = new LNPComGrpToComSchema();
/* 863 */       tLNPComGrpToComSchema.setSchema(this.mResultSet, 1);
/* 864 */       tLNPComGrpToComSet.add(tLNPComGrpToComSchema);
/*     */ 
/* 866 */       while (tCount++ < 5000)
/*     */       {
/* 868 */         if (!this.mResultSet.next())
/*     */           continue;
/* 870 */         tLNPComGrpToComSchema = new LNPComGrpToComSchema();
/* 871 */         tLNPComGrpToComSchema.setSchema(this.mResultSet, 1);
/* 872 */         tLNPComGrpToComSet.add(tLNPComGrpToComSchema);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 878 */       CError tError = new CError();
/* 879 */       tError.moduleName = "LNPComGrpToComDB";
/* 880 */       tError.functionName = "getData";
/* 881 */       tError.errorMessage = ex.toString();
/* 882 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 885 */         this.mResultSet.close();
/* 886 */         this.mResultSet = null;
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 892 */         this.mStatement.close();
/* 893 */         this.mStatement = null;
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 897 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 901 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 906 */       return null;
/*     */     }
/* 908 */     return tLNPComGrpToComSet;
/*     */   }
/*     */ 
/*     */   public boolean closeData()
/*     */   {
/* 913 */     boolean flag = true;
/*     */     try
/*     */     {
/* 916 */       if (this.mResultSet == null)
/*     */       {
/* 918 */         CError tError = new CError();
/* 919 */         tError.moduleName = "LNPComGrpToComDB";
/* 920 */         tError.functionName = "closeData";
/* 921 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 922 */         this.mErrors.addOneError(tError);
/* 923 */         flag = false;
/*     */       }
/*     */       else
/*     */       {
/* 927 */         this.mResultSet.close();
/* 928 */         this.mResultSet = null;
/*     */       }
/*     */     }
/*     */     catch (Exception ex2)
/*     */     {
/* 933 */       CError tError = new CError();
/* 934 */       tError.moduleName = "LNPComGrpToComDB";
/* 935 */       tError.functionName = "closeData";
/* 936 */       tError.errorMessage = ex2.toString();
/* 937 */       this.mErrors.addOneError(tError);
/* 938 */       flag = false;
/*     */     }
/*     */     try
/*     */     {
/* 942 */       if (this.mStatement == null)
/*     */       {
/* 944 */         CError tError = new CError();
/* 945 */         tError.moduleName = "LNPComGrpToComDB";
/* 946 */         tError.functionName = "closeData";
/* 947 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 948 */         this.mErrors.addOneError(tError);
/* 949 */         flag = false;
/*     */       }
/*     */       else
/*     */       {
/* 953 */         this.mStatement.close();
/* 954 */         this.mStatement = null;
/*     */       }
/*     */     }
/*     */     catch (Exception ex3)
/*     */     {
/* 959 */       CError tError = new CError();
/* 960 */       tError.moduleName = "LNPComGrpToComDB";
/* 961 */       tError.functionName = "closeData";
/* 962 */       tError.errorMessage = ex3.toString();
/* 963 */       this.mErrors.addOneError(tError);
/* 964 */       flag = false;
/*     */     }
/* 966 */     return flag;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPComGrpToComDB
 * JD-Core Version:    0.6.0
 */