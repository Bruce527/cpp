/*     */ package com.sinosoft.banklns.lis.db;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPRiskDutySchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPRiskDutySet;
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
/*     */ public class LNPRiskDutyDB extends LNPRiskDutySchema
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
/*     */   public LNPRiskDutyDB(Connection tConnection)
/*     */   {
/*  32 */     this.con = tConnection;
/*  33 */     this.db = new DBOper(this.con, "LNPRiskDuty");
/*  34 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPRiskDutyDB()
/*     */   {
/*  39 */     this.con = null;
/*  40 */     this.db = new DBOper("LNPRiskDuty");
/*  41 */     this.mflag = false;
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  47 */     LNPRiskDutySchema tSchema = getSchema();
/*  48 */     if (this.db.deleteSQL(tSchema))
/*     */     {
/*  50 */       return true;
/*     */     }
/*     */ 
/*  55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*  56 */     CError tError = new CError();
/*  57 */     tError.moduleName = "LNPRiskDutyDB";
/*  58 */     tError.functionName = "deleteSQL";
/*  59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*  60 */     this.mErrors.addOneError(tError);
/*  61 */     return false;
/*     */   }
/*     */ 
/*     */   public int getCount()
/*     */   {
/*  67 */     LNPRiskDutySchema tSchema = getSchema();
/*     */ 
/*  69 */     int tCount = this.db.getCount(tSchema);
/*  70 */     if (tCount < 0)
/*     */     {
/*  73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  74 */       CError tError = new CError();
/*  75 */       tError.moduleName = "LNPRiskDutyDB";
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
/*  96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPRiskDuty WHERE  RiskCode = ? AND DutyCode = ?");
/*  97 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  98 */         pstmt.setNull(1, 12);
/*     */       else {
/* 100 */         pstmt.setString(1, getRiskCode());
/*     */       }
/* 102 */       if ((getDutyCode() == null) || (getDutyCode().equals("null")))
/* 103 */         pstmt.setNull(2, 12);
/*     */       else {
/* 105 */         pstmt.setString(2, getDutyCode());
/*     */       }
/* 107 */       pstmt.executeUpdate();
/* 108 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 111 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 112 */       CError tError = new CError();
/* 113 */       tError.moduleName = "LNPRiskDutyDB";
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
/* 150 */       pstmt = this.con.prepareStatement("UPDATE LNPRiskDuty SET  RiskCode = ? , RiskVer = ? , DutyCode = ? , ChoFlag = ? , SpecFlag = ? WHERE  RiskCode = ? AND DutyCode = ?");
/* 151 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/* 152 */         pstmt.setNull(1, 12);
/*     */       else {
/* 154 */         pstmt.setString(1, getRiskCode());
/*     */       }
/* 156 */       if ((getRiskVer() == null) || (getRiskVer().equals("null")))
/* 157 */         pstmt.setNull(2, 12);
/*     */       else {
/* 159 */         pstmt.setString(2, getRiskVer());
/*     */       }
/* 161 */       if ((getDutyCode() == null) || (getDutyCode().equals("null")))
/* 162 */         pstmt.setNull(3, 12);
/*     */       else {
/* 164 */         pstmt.setString(3, getDutyCode());
/*     */       }
/* 166 */       if ((getChoFlag() == null) || (getChoFlag().equals("null")))
/* 167 */         pstmt.setNull(4, 12);
/*     */       else {
/* 169 */         pstmt.setString(4, getChoFlag());
/*     */       }
/* 171 */       if ((getSpecFlag() == null) || (getSpecFlag().equals("null")))
/* 172 */         pstmt.setNull(5, 12);
/*     */       else {
/* 174 */         pstmt.setString(5, getSpecFlag());
/*     */       }
/*     */ 
/* 177 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/* 178 */         pstmt.setNull(6, 12);
/*     */       else {
/* 180 */         pstmt.setString(6, getRiskCode());
/*     */       }
/* 182 */       if ((getDutyCode() == null) || (getDutyCode().equals("null")))
/* 183 */         pstmt.setNull(7, 12);
/*     */       else {
/* 185 */         pstmt.setString(7, getDutyCode());
/*     */       }
/* 187 */       pstmt.executeUpdate();
/* 188 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 191 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 192 */       CError tError = new CError();
/* 193 */       tError.moduleName = "LNPRiskDutyDB";
/* 194 */       tError.functionName = "update()";
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
/*     */   public boolean insert()
/*     */   {
/* 222 */     PreparedStatement pstmt = null;
/*     */ 
/* 224 */     if (!this.mflag) {
/* 225 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 230 */       pstmt = this.con.prepareStatement("INSERT INTO LNPRiskDuty VALUES( ? , ? , ? , ? , ?)");
/* 231 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/* 232 */         pstmt.setNull(1, 12);
/*     */       else {
/* 234 */         pstmt.setString(1, getRiskCode());
/*     */       }
/* 236 */       if ((getRiskVer() == null) || (getRiskVer().equals("null")))
/* 237 */         pstmt.setNull(2, 12);
/*     */       else {
/* 239 */         pstmt.setString(2, getRiskVer());
/*     */       }
/* 241 */       if ((getDutyCode() == null) || (getDutyCode().equals("null")))
/* 242 */         pstmt.setNull(3, 12);
/*     */       else {
/* 244 */         pstmt.setString(3, getDutyCode());
/*     */       }
/* 246 */       if ((getChoFlag() == null) || (getChoFlag().equals("null")))
/* 247 */         pstmt.setNull(4, 12);
/*     */       else {
/* 249 */         pstmt.setString(4, getChoFlag());
/*     */       }
/* 251 */       if ((getSpecFlag() == null) || (getSpecFlag().equals("null")))
/* 252 */         pstmt.setNull(5, 12);
/*     */       else {
/* 254 */         pstmt.setString(5, getSpecFlag());
/*     */       }
/*     */ 
/* 257 */       pstmt.executeUpdate();
/* 258 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 261 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 262 */       CError tError = new CError();
/* 263 */       tError.moduleName = "LNPRiskDutyDB";
/* 264 */       tError.functionName = "insert()";
/* 265 */       tError.errorMessage = ex.toString();
/* 266 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 269 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 272 */       if (!this.mflag)
/*     */         try {
/* 274 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 278 */       return false;
/*     */     }
/*     */ 
/* 281 */     if (!this.mflag)
/*     */       try {
/* 283 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 287 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean getInfo()
/*     */   {
/* 292 */     PreparedStatement pstmt = null;
/* 293 */     ResultSet rs = null;
/*     */ 
/* 295 */     if (!this.mflag) {
/* 296 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 301 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPRiskDuty WHERE  RiskCode = ? AND DutyCode = ?", 
/* 302 */         1003, 1007);
/* 303 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/* 304 */         pstmt.setNull(1, 12);
/*     */       else {
/* 306 */         pstmt.setString(1, getRiskCode());
/*     */       }
/* 308 */       if ((getDutyCode() == null) || (getDutyCode().equals("null")))
/* 309 */         pstmt.setNull(2, 12);
/*     */       else {
/* 311 */         pstmt.setString(2, getDutyCode());
/*     */       }
/* 313 */       rs = pstmt.executeQuery();
/* 314 */       int i = 0;
/* 315 */       if (rs.next())
/*     */       {
/* 317 */         i++;
/* 318 */         if (!setSchema(rs, i))
/*     */         {
/* 321 */           CError tError = new CError();
/* 322 */           tError.moduleName = "LNPRiskDutyDB";
/* 323 */           tError.functionName = "getInfo";
/* 324 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/* 325 */           this.mErrors.addOneError(tError);
/*     */           try {
/* 327 */             rs.close(); } catch (Exception localException1) {
/*     */           }try { pstmt.close(); } catch (Exception localException2) {
/*     */           }
/* 330 */           if (!this.mflag)
/*     */           {
/*     */             try
/*     */             {
/* 334 */               this.con.close();
/*     */             } catch (Exception localException3) {
/*     */             }
/*     */           }
/* 338 */           return false;
/*     */         }
/*     */       }
/*     */       try {
/* 342 */         rs.close(); } catch (Exception localException4) {
/*     */       }try { pstmt.close(); } catch (Exception localException5) {
/*     */       }
/* 345 */       if (i == 0)
/*     */       {
/* 347 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 351 */             this.con.close();
/*     */           } catch (Exception localException6) {
/*     */           }
/*     */         }
/* 355 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 361 */       CError tError = new CError();
/* 362 */       tError.moduleName = "LNPRiskDutyDB";
/* 363 */       tError.functionName = "getInfo";
/* 364 */       tError.errorMessage = e.toString();
/* 365 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 367 */         rs.close(); } catch (Exception localException7) {
/*     */       }try { pstmt.close(); } catch (Exception localException8) {
/*     */       }
/* 370 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 374 */           this.con.close();
/*     */         } catch (Exception localException9) {
/*     */         }
/*     */       }
/* 378 */       return false;
/*     */     }
/*     */ 
/* 381 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 385 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException10) {
/*     */       }
/*     */     }
/* 390 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPRiskDutySet query()
/*     */   {
/* 395 */     Statement stmt = null;
/* 396 */     ResultSet rs = null;
/* 397 */     LNPRiskDutySet aLNPRiskDutySet = new LNPRiskDutySet();
/*     */ 
/* 399 */     if (!this.mflag) {
/* 400 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 405 */       stmt = this.con.createStatement(1003, 1007);
/* 406 */       SQLString sqlObj = new SQLString("LNPRiskDuty");
/* 407 */       LNPRiskDutySchema aSchema = getSchema();
/* 408 */       sqlObj.setSQL(5, aSchema);
/* 409 */       String sql = sqlObj.getSQL();
/*     */ 
/* 411 */       rs = stmt.executeQuery(sql);
/* 412 */       int i = 0;
/* 413 */       while (rs.next())
/*     */       {
/* 415 */         i++;
/* 416 */         LNPRiskDutySchema s1 = new LNPRiskDutySchema();
/* 417 */         s1.setSchema(rs, i);
/* 418 */         aLNPRiskDutySet.add(s1);
/*     */       }try {
/* 420 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 426 */       CError tError = new CError();
/* 427 */       tError.moduleName = "LNPRiskDutyDB";
/* 428 */       tError.functionName = "query";
/* 429 */       tError.errorMessage = e.toString();
/* 430 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 432 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 435 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 439 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 445 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 449 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 454 */     return aLNPRiskDutySet;
/*     */   }
/*     */ 
/*     */   public LNPRiskDutySet executeQuery(String sql)
/*     */   {
/* 459 */     Statement stmt = null;
/* 460 */     ResultSet rs = null;
/* 461 */     LNPRiskDutySet aLNPRiskDutySet = new LNPRiskDutySet();
/*     */ 
/* 463 */     if (!this.mflag) {
/* 464 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 469 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 471 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 472 */       int i = 0;
/* 473 */       while (rs.next())
/*     */       {
/* 475 */         i++;
/* 476 */         LNPRiskDutySchema s1 = new LNPRiskDutySchema();
/* 477 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 480 */           CError tError = new CError();
/* 481 */           tError.moduleName = "LNPRiskDutyDB";
/* 482 */           tError.functionName = "executeQuery";
/* 483 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/* 484 */           this.mErrors.addOneError(tError);
/*     */         }
/* 486 */         aLNPRiskDutySet.add(s1);
/*     */       }try {
/* 488 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 494 */       CError tError = new CError();
/* 495 */       tError.moduleName = "LNPRiskDutyDB";
/* 496 */       tError.functionName = "executeQuery";
/* 497 */       tError.errorMessage = e.toString();
/* 498 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 500 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 503 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 507 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 513 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 517 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 522 */     return aLNPRiskDutySet;
/*     */   }
/*     */ 
/*     */   public LNPRiskDutySet query(int nStart, int nCount)
/*     */   {
/* 527 */     Statement stmt = null;
/* 528 */     ResultSet rs = null;
/* 529 */     LNPRiskDutySet aLNPRiskDutySet = new LNPRiskDutySet();
/*     */ 
/* 531 */     if (!this.mflag) {
/* 532 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 537 */       stmt = this.con.createStatement(1003, 1007);
/* 538 */       SQLString sqlObj = new SQLString("LNPRiskDuty");
/* 539 */       LNPRiskDutySchema aSchema = getSchema();
/* 540 */       sqlObj.setSQL(5, aSchema);
/* 541 */       String sql = sqlObj.getSQL();
/*     */ 
/* 543 */       rs = stmt.executeQuery(sql);
/* 544 */       int i = 0;
/* 545 */       while (rs.next())
/*     */       {
/* 547 */         i++;
/*     */ 
/* 549 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 553 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 557 */         LNPRiskDutySchema s1 = new LNPRiskDutySchema();
/* 558 */         s1.setSchema(rs, i);
/* 559 */         aLNPRiskDutySet.add(s1);
/*     */       }try {
/* 561 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 567 */       CError tError = new CError();
/* 568 */       tError.moduleName = "LNPRiskDutyDB";
/* 569 */       tError.functionName = "query";
/* 570 */       tError.errorMessage = e.toString();
/* 571 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 573 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 576 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 580 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 586 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 590 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 595 */     return aLNPRiskDutySet;
/*     */   }
/*     */ 
/*     */   public LNPRiskDutySet executeQuery(String sql, int nStart, int nCount)
/*     */   {
/* 600 */     Statement stmt = null;
/* 601 */     ResultSet rs = null;
/* 602 */     LNPRiskDutySet aLNPRiskDutySet = new LNPRiskDutySet();
/*     */ 
/* 604 */     if (!this.mflag) {
/* 605 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 610 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 612 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 613 */       int i = 0;
/* 614 */       while (rs.next())
/*     */       {
/* 616 */         i++;
/*     */ 
/* 618 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 622 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 626 */         LNPRiskDutySchema s1 = new LNPRiskDutySchema();
/* 627 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 630 */           CError tError = new CError();
/* 631 */           tError.moduleName = "LNPRiskDutyDB";
/* 632 */           tError.functionName = "executeQuery";
/* 633 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/* 634 */           this.mErrors.addOneError(tError);
/*     */         }
/* 636 */         aLNPRiskDutySet.add(s1);
/*     */       }try {
/* 638 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 644 */       CError tError = new CError();
/* 645 */       tError.moduleName = "LNPRiskDutyDB";
/* 646 */       tError.functionName = "executeQuery";
/* 647 */       tError.errorMessage = e.toString();
/* 648 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 650 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 653 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 657 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 663 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 667 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 672 */     return aLNPRiskDutySet;
/*     */   }
/*     */ 
/*     */   public boolean update(String strWherePart)
/*     */   {
/* 677 */     Statement stmt = null;
/*     */ 
/* 679 */     if (!this.mflag) {
/* 680 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 685 */       stmt = this.con.createStatement(1003, 1007);
/* 686 */       SQLString sqlObj = new SQLString("LNPRiskDuty");
/* 687 */       LNPRiskDutySchema aSchema = getSchema();
/* 688 */       sqlObj.setSQL(2, aSchema);
/* 689 */       String sql = "update LNPRiskDuty " + sqlObj.getUpdPart() + " where " + strWherePart;
/*     */ 
/* 691 */       int operCount = stmt.executeUpdate(sql);
/* 692 */       if (operCount == 0)
/*     */       {
/* 695 */         CError tError = new CError();
/* 696 */         tError.moduleName = "LNPRiskDutyDB";
/* 697 */         tError.functionName = "update";
/* 698 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/* 699 */         this.mErrors.addOneError(tError);
/*     */ 
/* 701 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 705 */             this.con.close();
/*     */           } catch (Exception localException1) {
/*     */           }
/*     */         }
/* 709 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 715 */       CError tError = new CError();
/* 716 */       tError.moduleName = "LNPRiskDutyDB";
/* 717 */       tError.functionName = "update";
/* 718 */       tError.errorMessage = e.toString();
/* 719 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 721 */         stmt.close(); } catch (Exception localException2) {
/*     */       }
/* 723 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 727 */           this.con.close();
/*     */         } catch (Exception localException3) {
/*     */         }
/*     */       }
/* 731 */       return false;
/*     */     }
/*     */ 
/* 734 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 738 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException4) {
/*     */       }
/*     */     }
/* 743 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean prepareData(String strSQL)
/*     */   {
/* 749 */     if (this.mResultSet != null)
/*     */     {
/* 752 */       CError tError = new CError();
/* 753 */       tError.moduleName = "LNPRiskDutyDB";
/* 754 */       tError.functionName = "prepareData";
/* 755 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/* 756 */       this.mErrors.addOneError(tError);
/* 757 */       return false;
/*     */     }
/*     */ 
/* 760 */     if (!this.mflag)
/*     */     {
/* 762 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */     try
/*     */     {
/* 766 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 767 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 772 */       CError tError = new CError();
/* 773 */       tError.moduleName = "LNPRiskDutyDB";
/* 774 */       tError.functionName = "prepareData";
/* 775 */       tError.errorMessage = e.toString();
/* 776 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 779 */         this.mResultSet.close();
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 785 */         this.mStatement.close();
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 789 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 793 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 798 */       return false;
/*     */     }
/*     */ 
/* 801 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 805 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException4) {
/*     */       }
/*     */     }
/* 810 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean hasMoreData()
/*     */   {
/* 816 */     boolean flag = true;
/* 817 */     if (this.mResultSet == null)
/*     */     {
/* 819 */       CError tError = new CError();
/* 820 */       tError.moduleName = "LNPRiskDutyDB";
/* 821 */       tError.functionName = "hasMoreData";
/* 822 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 823 */       this.mErrors.addOneError(tError);
/* 824 */       return false;
/*     */     }
/*     */     try
/*     */     {
/* 828 */       flag = this.mResultSet.next();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 832 */       CError tError = new CError();
/* 833 */       tError.moduleName = "LNPRiskDutyDB";
/* 834 */       tError.functionName = "hasMoreData";
/* 835 */       tError.errorMessage = ex.toString();
/* 836 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 839 */         this.mResultSet.close();
/* 840 */         this.mResultSet = null;
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 846 */         this.mStatement.close();
/* 847 */         this.mStatement = null;
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 851 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 855 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 860 */       return false;
/*     */     }
/* 862 */     return flag;
/*     */   }
/*     */ 
/*     */   public LNPRiskDutySet getData()
/*     */   {
/* 867 */     int tCount = 0;
/* 868 */     LNPRiskDutySet tLNPRiskDutySet = new LNPRiskDutySet();
/* 869 */     LNPRiskDutySchema tLNPRiskDutySchema = null;
/* 870 */     if (this.mResultSet == null)
/*     */     {
/* 872 */       CError tError = new CError();
/* 873 */       tError.moduleName = "LNPRiskDutyDB";
/* 874 */       tError.functionName = "getData";
/* 875 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 876 */       this.mErrors.addOneError(tError);
/* 877 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 881 */       tCount = 1;
/* 882 */       tLNPRiskDutySchema = new LNPRiskDutySchema();
/* 883 */       tLNPRiskDutySchema.setSchema(this.mResultSet, 1);
/* 884 */       tLNPRiskDutySet.add(tLNPRiskDutySchema);
/*     */ 
/* 886 */       while (tCount++ < 5000)
/*     */       {
/* 888 */         if (!this.mResultSet.next())
/*     */           continue;
/* 890 */         tLNPRiskDutySchema = new LNPRiskDutySchema();
/* 891 */         tLNPRiskDutySchema.setSchema(this.mResultSet, 1);
/* 892 */         tLNPRiskDutySet.add(tLNPRiskDutySchema);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 898 */       CError tError = new CError();
/* 899 */       tError.moduleName = "LNPRiskDutyDB";
/* 900 */       tError.functionName = "getData";
/* 901 */       tError.errorMessage = ex.toString();
/* 902 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 905 */         this.mResultSet.close();
/* 906 */         this.mResultSet = null;
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 912 */         this.mStatement.close();
/* 913 */         this.mStatement = null;
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 917 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 921 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 926 */       return null;
/*     */     }
/* 928 */     return tLNPRiskDutySet;
/*     */   }
/*     */ 
/*     */   public boolean closeData()
/*     */   {
/* 933 */     boolean flag = true;
/*     */     try
/*     */     {
/* 936 */       if (this.mResultSet == null)
/*     */       {
/* 938 */         CError tError = new CError();
/* 939 */         tError.moduleName = "LNPRiskDutyDB";
/* 940 */         tError.functionName = "closeData";
/* 941 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 942 */         this.mErrors.addOneError(tError);
/* 943 */         flag = false;
/*     */       }
/*     */       else
/*     */       {
/* 947 */         this.mResultSet.close();
/* 948 */         this.mResultSet = null;
/*     */       }
/*     */     }
/*     */     catch (Exception ex2)
/*     */     {
/* 953 */       CError tError = new CError();
/* 954 */       tError.moduleName = "LNPRiskDutyDB";
/* 955 */       tError.functionName = "closeData";
/* 956 */       tError.errorMessage = ex2.toString();
/* 957 */       this.mErrors.addOneError(tError);
/* 958 */       flag = false;
/*     */     }
/*     */     try
/*     */     {
/* 962 */       if (this.mStatement == null)
/*     */       {
/* 964 */         CError tError = new CError();
/* 965 */         tError.moduleName = "LNPRiskDutyDB";
/* 966 */         tError.functionName = "closeData";
/* 967 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 968 */         this.mErrors.addOneError(tError);
/* 969 */         flag = false;
/*     */       }
/*     */       else
/*     */       {
/* 973 */         this.mStatement.close();
/* 974 */         this.mStatement = null;
/*     */       }
/*     */     }
/*     */     catch (Exception ex3)
/*     */     {
/* 979 */       CError tError = new CError();
/* 980 */       tError.moduleName = "LNPRiskDutyDB";
/* 981 */       tError.functionName = "closeData";
/* 982 */       tError.errorMessage = ex3.toString();
/* 983 */       this.mErrors.addOneError(tError);
/* 984 */       flag = false;
/*     */     }
/* 986 */     return flag;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPRiskDutyDB
 * JD-Core Version:    0.6.0
 */