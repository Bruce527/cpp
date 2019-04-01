/*     */ package com.sinosoft.banklns.lis.db;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPCodeSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPCodeSet;
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
/*     */ public class LNPCodeDB extends LNPCodeSchema
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
/*     */   public LNPCodeDB(Connection tConnection)
/*     */   {
/*  32 */     this.con = tConnection;
/*  33 */     this.db = new DBOper(this.con, "LNPCode");
/*  34 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPCodeDB()
/*     */   {
/*  39 */     this.con = null;
/*  40 */     this.db = new DBOper("LNPCode");
/*  41 */     this.mflag = false;
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  47 */     LNPCodeSchema tSchema = getSchema();
/*  48 */     if (this.db.deleteSQL(tSchema))
/*     */     {
/*  50 */       return true;
/*     */     }
/*     */ 
/*  55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*  56 */     CError tError = new CError();
/*  57 */     tError.moduleName = "LNPCodeDB";
/*  58 */     tError.functionName = "deleteSQL";
/*  59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*  60 */     this.mErrors.addOneError(tError);
/*  61 */     return false;
/*     */   }
/*     */ 
/*     */   public int getCount()
/*     */   {
/*  67 */     LNPCodeSchema tSchema = getSchema();
/*     */ 
/*  69 */     int tCount = this.db.getCount(tSchema);
/*  70 */     if (tCount < 0)
/*     */     {
/*  73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  74 */       CError tError = new CError();
/*  75 */       tError.moduleName = "LNPCodeDB";
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
/*  96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPCode WHERE  CodeType = ? AND Code = ?");
/*  97 */       if ((getCodeType() == null) || (getCodeType().equals("null")))
/*  98 */         pstmt.setNull(1, 12);
/*     */       else {
/* 100 */         pstmt.setString(1, getCodeType());
/*     */       }
/* 102 */       if ((getCode() == null) || (getCode().equals("null")))
/* 103 */         pstmt.setNull(2, 12);
/*     */       else {
/* 105 */         pstmt.setString(2, getCode());
/*     */       }
/* 107 */       pstmt.executeUpdate();
/* 108 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 111 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 112 */       CError tError = new CError();
/* 113 */       tError.moduleName = "LNPCodeDB";
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
/* 150 */       pstmt = this.con.prepareStatement("UPDATE LNPCode SET  CodeType = ? , Code = ? , CodeName = ? , CodeAlias = ? , ComCode = ? , OtherSign = ? WHERE  CodeType = ? AND Code = ?");
/* 151 */       if ((getCodeType() == null) || (getCodeType().equals("null")))
/* 152 */         pstmt.setNull(1, 12);
/*     */       else {
/* 154 */         pstmt.setString(1, getCodeType());
/*     */       }
/* 156 */       if ((getCode() == null) || (getCode().equals("null")))
/* 157 */         pstmt.setNull(2, 12);
/*     */       else {
/* 159 */         pstmt.setString(2, getCode());
/*     */       }
/* 161 */       if ((getCodeName() == null) || (getCodeName().equals("null")))
/* 162 */         pstmt.setNull(3, 12);
/*     */       else {
/* 164 */         pstmt.setString(3, getCodeName());
/*     */       }
/* 166 */       if ((getCodeAlias() == null) || (getCodeAlias().equals("null")))
/* 167 */         pstmt.setNull(4, 12);
/*     */       else {
/* 169 */         pstmt.setString(4, getCodeAlias());
/*     */       }
/* 171 */       if ((getComCode() == null) || (getComCode().equals("null")))
/* 172 */         pstmt.setNull(5, 12);
/*     */       else {
/* 174 */         pstmt.setString(5, getComCode());
/*     */       }
/* 176 */       if ((getOtherSign() == null) || (getOtherSign().equals("null")))
/* 177 */         pstmt.setNull(6, 12);
/*     */       else {
/* 179 */         pstmt.setString(6, getOtherSign());
/*     */       }
/*     */ 
/* 182 */       if ((getCodeType() == null) || (getCodeType().equals("null")))
/* 183 */         pstmt.setNull(7, 12);
/*     */       else {
/* 185 */         pstmt.setString(7, getCodeType());
/*     */       }
/* 187 */       if ((getCode() == null) || (getCode().equals("null")))
/* 188 */         pstmt.setNull(8, 12);
/*     */       else {
/* 190 */         pstmt.setString(8, getCode());
/*     */       }
/* 192 */       pstmt.executeUpdate();
/* 193 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 196 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 197 */       CError tError = new CError();
/* 198 */       tError.moduleName = "LNPCodeDB";
/* 199 */       tError.functionName = "update()";
/* 200 */       tError.errorMessage = ex.toString();
/* 201 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 204 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 207 */       if (!this.mflag)
/*     */         try {
/* 209 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 213 */       return false;
/*     */     }
/*     */ 
/* 216 */     if (!this.mflag)
/*     */       try {
/* 218 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 222 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 227 */     PreparedStatement pstmt = null;
/*     */ 
/* 229 */     if (!this.mflag) {
/* 230 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 235 */       pstmt = this.con.prepareStatement("INSERT INTO LNPCode VALUES( ? , ? , ? , ? , ? , ?)");
/* 236 */       if ((getCodeType() == null) || (getCodeType().equals("null")))
/* 237 */         pstmt.setNull(1, 12);
/*     */       else {
/* 239 */         pstmt.setString(1, getCodeType());
/*     */       }
/* 241 */       if ((getCode() == null) || (getCode().equals("null")))
/* 242 */         pstmt.setNull(2, 12);
/*     */       else {
/* 244 */         pstmt.setString(2, getCode());
/*     */       }
/* 246 */       if ((getCodeName() == null) || (getCodeName().equals("null")))
/* 247 */         pstmt.setNull(3, 12);
/*     */       else {
/* 249 */         pstmt.setString(3, getCodeName());
/*     */       }
/* 251 */       if ((getCodeAlias() == null) || (getCodeAlias().equals("null")))
/* 252 */         pstmt.setNull(4, 12);
/*     */       else {
/* 254 */         pstmt.setString(4, getCodeAlias());
/*     */       }
/* 256 */       if ((getComCode() == null) || (getComCode().equals("null")))
/* 257 */         pstmt.setNull(5, 12);
/*     */       else {
/* 259 */         pstmt.setString(5, getComCode());
/*     */       }
/* 261 */       if ((getOtherSign() == null) || (getOtherSign().equals("null")))
/* 262 */         pstmt.setNull(6, 12);
/*     */       else {
/* 264 */         pstmt.setString(6, getOtherSign());
/*     */       }
/*     */ 
/* 267 */       pstmt.executeUpdate();
/* 268 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 271 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 272 */       CError tError = new CError();
/* 273 */       tError.moduleName = "LNPCodeDB";
/* 274 */       tError.functionName = "insert()";
/* 275 */       tError.errorMessage = ex.toString();
/* 276 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 279 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 282 */       if (!this.mflag)
/*     */         try {
/* 284 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 288 */       return false;
/*     */     }
/*     */ 
/* 291 */     if (!this.mflag)
/*     */       try {
/* 293 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 297 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean getInfo()
/*     */   {
/* 302 */     PreparedStatement pstmt = null;
/* 303 */     ResultSet rs = null;
/*     */ 
/* 305 */     if (!this.mflag) {
/* 306 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 311 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPCode WHERE  CodeType = ? AND Code = ?", 
/* 312 */         1003, 1007);
/* 313 */       if ((getCodeType() == null) || (getCodeType().equals("null")))
/* 314 */         pstmt.setNull(1, 12);
/*     */       else {
/* 316 */         pstmt.setString(1, getCodeType());
/*     */       }
/* 318 */       if ((getCode() == null) || (getCode().equals("null")))
/* 319 */         pstmt.setNull(2, 12);
/*     */       else {
/* 321 */         pstmt.setString(2, getCode());
/*     */       }
/* 323 */       rs = pstmt.executeQuery();
/* 324 */       int i = 0;
/* 325 */       if (rs.next())
/*     */       {
/* 327 */         i++;
/* 328 */         if (!setSchema(rs, i))
/*     */         {
/* 331 */           CError tError = new CError();
/* 332 */           tError.moduleName = "LNPCodeDB";
/* 333 */           tError.functionName = "getInfo";
/* 334 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/* 335 */           this.mErrors.addOneError(tError);
/*     */           try {
/* 337 */             rs.close(); } catch (Exception localException1) {
/*     */           }try { pstmt.close(); } catch (Exception localException2) {
/*     */           }
/* 340 */           if (!this.mflag)
/*     */           {
/*     */             try
/*     */             {
/* 344 */               this.con.close();
/*     */             } catch (Exception localException3) {
/*     */             }
/*     */           }
/* 348 */           return false;
/*     */         }
/*     */       }
/*     */       try {
/* 352 */         rs.close(); } catch (Exception localException4) {
/*     */       }try { pstmt.close(); } catch (Exception localException5) {
/*     */       }
/* 355 */       if (i == 0)
/*     */       {
/* 357 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 361 */             this.con.close();
/*     */           } catch (Exception localException6) {
/*     */           }
/*     */         }
/* 365 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 371 */       CError tError = new CError();
/* 372 */       tError.moduleName = "LNPCodeDB";
/* 373 */       tError.functionName = "getInfo";
/* 374 */       tError.errorMessage = e.toString();
/* 375 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 377 */         rs.close(); } catch (Exception localException7) {
/*     */       }try { pstmt.close(); } catch (Exception localException8) {
/*     */       }
/* 380 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 384 */           this.con.close();
/*     */         } catch (Exception localException9) {
/*     */         }
/*     */       }
/* 388 */       return false;
/*     */     }
/*     */ 
/* 391 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 395 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException10) {
/*     */       }
/*     */     }
/* 400 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPCodeSet query()
/*     */   {
/* 405 */     Statement stmt = null;
/* 406 */     ResultSet rs = null;
/* 407 */     LNPCodeSet aLNPCodeSet = new LNPCodeSet();
/*     */ 
/* 409 */     if (!this.mflag) {
/* 410 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 415 */       stmt = this.con.createStatement(1003, 1007);
/* 416 */       SQLString sqlObj = new SQLString("LNPCode");
/* 417 */       LNPCodeSchema aSchema = getSchema();
/* 418 */       sqlObj.setSQL(5, aSchema);
/* 419 */       String sql = sqlObj.getSQL();
/*     */ 
/* 421 */       rs = stmt.executeQuery(sql);
/* 422 */       int i = 0;
/* 423 */       while (rs.next())
/*     */       {
/* 425 */         i++;
/* 426 */         LNPCodeSchema s1 = new LNPCodeSchema();
/* 427 */         s1.setSchema(rs, i);
/* 428 */         aLNPCodeSet.add(s1);
/*     */       }try {
/* 430 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 436 */       CError tError = new CError();
/* 437 */       tError.moduleName = "LNPCodeDB";
/* 438 */       tError.functionName = "query";
/* 439 */       tError.errorMessage = e.toString();
/* 440 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 442 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 445 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 449 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 455 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 459 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 464 */     return aLNPCodeSet;
/*     */   }
/*     */ 
/*     */   public LNPCodeSet executeQuery(String sql)
/*     */   {
/* 469 */     Statement stmt = null;
/* 470 */     ResultSet rs = null;
/* 471 */     LNPCodeSet aLNPCodeSet = new LNPCodeSet();
/*     */ 
/* 473 */     if (!this.mflag) {
/* 474 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 479 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 481 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 482 */       int i = 0;
/* 483 */       while (rs.next())
/*     */       {
/* 485 */         i++;
/* 486 */         LNPCodeSchema s1 = new LNPCodeSchema();
/* 487 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 490 */           CError tError = new CError();
/* 491 */           tError.moduleName = "LNPCodeDB";
/* 492 */           tError.functionName = "executeQuery";
/* 493 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/* 494 */           this.mErrors.addOneError(tError);
/*     */         }
/* 496 */         aLNPCodeSet.add(s1);
/*     */       }try {
/* 498 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 504 */       CError tError = new CError();
/* 505 */       tError.moduleName = "LNPCodeDB";
/* 506 */       tError.functionName = "executeQuery";
/* 507 */       tError.errorMessage = e.toString();
/* 508 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 510 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 513 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 517 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 523 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 527 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 532 */     return aLNPCodeSet;
/*     */   }
/*     */ 
/*     */   public LNPCodeSet query(int nStart, int nCount)
/*     */   {
/* 537 */     Statement stmt = null;
/* 538 */     ResultSet rs = null;
/* 539 */     LNPCodeSet aLNPCodeSet = new LNPCodeSet();
/*     */ 
/* 541 */     if (!this.mflag) {
/* 542 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 547 */       stmt = this.con.createStatement(1003, 1007);
/* 548 */       SQLString sqlObj = new SQLString("LNPCode");
/* 549 */       LNPCodeSchema aSchema = getSchema();
/* 550 */       sqlObj.setSQL(5, aSchema);
/* 551 */       String sql = sqlObj.getSQL();
/*     */ 
/* 553 */       rs = stmt.executeQuery(sql);
/* 554 */       int i = 0;
/* 555 */       while (rs.next())
/*     */       {
/* 557 */         i++;
/*     */ 
/* 559 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 563 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 567 */         LNPCodeSchema s1 = new LNPCodeSchema();
/* 568 */         s1.setSchema(rs, i);
/* 569 */         aLNPCodeSet.add(s1);
/*     */       }try {
/* 571 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 577 */       CError tError = new CError();
/* 578 */       tError.moduleName = "LNPCodeDB";
/* 579 */       tError.functionName = "query";
/* 580 */       tError.errorMessage = e.toString();
/* 581 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 583 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 586 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 590 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 596 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 600 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 605 */     return aLNPCodeSet;
/*     */   }
/*     */ 
/*     */   public LNPCodeSet executeQuery(String sql, int nStart, int nCount)
/*     */   {
/* 610 */     Statement stmt = null;
/* 611 */     ResultSet rs = null;
/* 612 */     LNPCodeSet aLNPCodeSet = new LNPCodeSet();
/*     */ 
/* 614 */     if (!this.mflag) {
/* 615 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 620 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 622 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 623 */       int i = 0;
/* 624 */       while (rs.next())
/*     */       {
/* 626 */         i++;
/*     */ 
/* 628 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 632 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 636 */         LNPCodeSchema s1 = new LNPCodeSchema();
/* 637 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 640 */           CError tError = new CError();
/* 641 */           tError.moduleName = "LNPCodeDB";
/* 642 */           tError.functionName = "executeQuery";
/* 643 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/* 644 */           this.mErrors.addOneError(tError);
/*     */         }
/* 646 */         aLNPCodeSet.add(s1);
/*     */       }try {
/* 648 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 654 */       CError tError = new CError();
/* 655 */       tError.moduleName = "LNPCodeDB";
/* 656 */       tError.functionName = "executeQuery";
/* 657 */       tError.errorMessage = e.toString();
/* 658 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 660 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 663 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 667 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 673 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 677 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 682 */     return aLNPCodeSet;
/*     */   }
/*     */ 
/*     */   public boolean update(String strWherePart)
/*     */   {
/* 687 */     Statement stmt = null;
/*     */ 
/* 689 */     if (!this.mflag) {
/* 690 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 695 */       stmt = this.con.createStatement(1003, 1007);
/* 696 */       SQLString sqlObj = new SQLString("LNPCode");
/* 697 */       LNPCodeSchema aSchema = getSchema();
/* 698 */       sqlObj.setSQL(2, aSchema);
/* 699 */       String sql = "update LNPCode " + sqlObj.getUpdPart() + " where " + strWherePart;
/*     */ 
/* 701 */       int operCount = stmt.executeUpdate(sql);
/* 702 */       if (operCount == 0)
/*     */       {
/* 705 */         CError tError = new CError();
/* 706 */         tError.moduleName = "LNPCodeDB";
/* 707 */         tError.functionName = "update";
/* 708 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/* 709 */         this.mErrors.addOneError(tError);
/*     */ 
/* 711 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 715 */             this.con.close();
/*     */           } catch (Exception localException1) {
/*     */           }
/*     */         }
/* 719 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 725 */       CError tError = new CError();
/* 726 */       tError.moduleName = "LNPCodeDB";
/* 727 */       tError.functionName = "update";
/* 728 */       tError.errorMessage = e.toString();
/* 729 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 731 */         stmt.close(); } catch (Exception localException2) {
/*     */       }
/* 733 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 737 */           this.con.close();
/*     */         } catch (Exception localException3) {
/*     */         }
/*     */       }
/* 741 */       return false;
/*     */     }
/*     */ 
/* 744 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 748 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException4) {
/*     */       }
/*     */     }
/* 753 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean prepareData(String strSQL)
/*     */   {
/* 759 */     if (this.mResultSet != null)
/*     */     {
/* 762 */       CError tError = new CError();
/* 763 */       tError.moduleName = "LNPCodeDB";
/* 764 */       tError.functionName = "prepareData";
/* 765 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/* 766 */       this.mErrors.addOneError(tError);
/* 767 */       return false;
/*     */     }
/*     */ 
/* 770 */     if (!this.mflag)
/*     */     {
/* 772 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */     try
/*     */     {
/* 776 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 777 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 782 */       CError tError = new CError();
/* 783 */       tError.moduleName = "LNPCodeDB";
/* 784 */       tError.functionName = "prepareData";
/* 785 */       tError.errorMessage = e.toString();
/* 786 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 789 */         this.mResultSet.close();
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 795 */         this.mStatement.close();
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 799 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 803 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 808 */       return false;
/*     */     }
/*     */ 
/* 811 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 815 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException4) {
/*     */       }
/*     */     }
/* 820 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean hasMoreData()
/*     */   {
/* 826 */     boolean flag = true;
/* 827 */     if (this.mResultSet == null)
/*     */     {
/* 829 */       CError tError = new CError();
/* 830 */       tError.moduleName = "LNPCodeDB";
/* 831 */       tError.functionName = "hasMoreData";
/* 832 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 833 */       this.mErrors.addOneError(tError);
/* 834 */       return false;
/*     */     }
/*     */     try
/*     */     {
/* 838 */       flag = this.mResultSet.next();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 842 */       CError tError = new CError();
/* 843 */       tError.moduleName = "LNPCodeDB";
/* 844 */       tError.functionName = "hasMoreData";
/* 845 */       tError.errorMessage = ex.toString();
/* 846 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 849 */         this.mResultSet.close();
/* 850 */         this.mResultSet = null;
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 856 */         this.mStatement.close();
/* 857 */         this.mStatement = null;
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 861 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 865 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 870 */       return false;
/*     */     }
/* 872 */     return flag;
/*     */   }
/*     */ 
/*     */   public LNPCodeSet getData()
/*     */   {
/* 877 */     int tCount = 0;
/* 878 */     LNPCodeSet tLNPCodeSet = new LNPCodeSet();
/* 879 */     LNPCodeSchema tLNPCodeSchema = null;
/* 880 */     if (this.mResultSet == null)
/*     */     {
/* 882 */       CError tError = new CError();
/* 883 */       tError.moduleName = "LNPCodeDB";
/* 884 */       tError.functionName = "getData";
/* 885 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 886 */       this.mErrors.addOneError(tError);
/* 887 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 891 */       tCount = 1;
/* 892 */       tLNPCodeSchema = new LNPCodeSchema();
/* 893 */       tLNPCodeSchema.setSchema(this.mResultSet, 1);
/* 894 */       tLNPCodeSet.add(tLNPCodeSchema);
/*     */ 
/* 896 */       while (tCount++ < 5000)
/*     */       {
/* 898 */         if (!this.mResultSet.next())
/*     */           continue;
/* 900 */         tLNPCodeSchema = new LNPCodeSchema();
/* 901 */         tLNPCodeSchema.setSchema(this.mResultSet, 1);
/* 902 */         tLNPCodeSet.add(tLNPCodeSchema);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 908 */       CError tError = new CError();
/* 909 */       tError.moduleName = "LNPCodeDB";
/* 910 */       tError.functionName = "getData";
/* 911 */       tError.errorMessage = ex.toString();
/* 912 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 915 */         this.mResultSet.close();
/* 916 */         this.mResultSet = null;
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 922 */         this.mStatement.close();
/* 923 */         this.mStatement = null;
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 927 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 931 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 936 */       return null;
/*     */     }
/* 938 */     return tLNPCodeSet;
/*     */   }
/*     */ 
/*     */   public boolean closeData()
/*     */   {
/* 943 */     boolean flag = true;
/*     */     try
/*     */     {
/* 946 */       if (this.mResultSet == null)
/*     */       {
/* 948 */         CError tError = new CError();
/* 949 */         tError.moduleName = "LNPCodeDB";
/* 950 */         tError.functionName = "closeData";
/* 951 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 952 */         this.mErrors.addOneError(tError);
/* 953 */         flag = false;
/*     */       }
/*     */       else
/*     */       {
/* 957 */         this.mResultSet.close();
/* 958 */         this.mResultSet = null;
/*     */       }
/*     */     }
/*     */     catch (Exception ex2)
/*     */     {
/* 963 */       CError tError = new CError();
/* 964 */       tError.moduleName = "LNPCodeDB";
/* 965 */       tError.functionName = "closeData";
/* 966 */       tError.errorMessage = ex2.toString();
/* 967 */       this.mErrors.addOneError(tError);
/* 968 */       flag = false;
/*     */     }
/*     */     try
/*     */     {
/* 972 */       if (this.mStatement == null)
/*     */       {
/* 974 */         CError tError = new CError();
/* 975 */         tError.moduleName = "LNPCodeDB";
/* 976 */         tError.functionName = "closeData";
/* 977 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 978 */         this.mErrors.addOneError(tError);
/* 979 */         flag = false;
/*     */       }
/*     */       else
/*     */       {
/* 983 */         this.mStatement.close();
/* 984 */         this.mStatement = null;
/*     */       }
/*     */     }
/*     */     catch (Exception ex3)
/*     */     {
/* 989 */       CError tError = new CError();
/* 990 */       tError.moduleName = "LNPCodeDB";
/* 991 */       tError.functionName = "closeData";
/* 992 */       tError.errorMessage = ex3.toString();
/* 993 */       this.mErrors.addOneError(tError);
/* 994 */       flag = false;
/*     */     }
/* 996 */     return flag;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPCodeDB
 * JD-Core Version:    0.6.0
 */