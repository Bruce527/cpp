/*     */ package com.sinosoft.banklns.lis.db;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPRiskSaleGroupToRiskSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPRiskSaleGroupToRiskSet;
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
/*     */ public class LNPRiskSaleGroupToRiskDB extends LNPRiskSaleGroupToRiskSchema
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
/*     */   public LNPRiskSaleGroupToRiskDB(Connection tConnection)
/*     */   {
/*  32 */     this.con = tConnection;
/*  33 */     this.db = new DBOper(this.con, "LNPRiskSaleGroupToRisk");
/*  34 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPRiskSaleGroupToRiskDB()
/*     */   {
/*  39 */     this.con = null;
/*  40 */     this.db = new DBOper("LNPRiskSaleGroupToRisk");
/*  41 */     this.mflag = false;
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  47 */     LNPRiskSaleGroupToRiskSchema tSchema = getSchema();
/*  48 */     if (this.db.deleteSQL(tSchema))
/*     */     {
/*  50 */       return true;
/*     */     }
/*     */ 
/*  55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*  56 */     CError tError = new CError();
/*  57 */     tError.moduleName = "LNPRiskSaleGroupToRiskDB";
/*  58 */     tError.functionName = "deleteSQL";
/*  59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*  60 */     this.mErrors.addOneError(tError);
/*  61 */     return false;
/*     */   }
/*     */ 
/*     */   public int getCount()
/*     */   {
/*  67 */     LNPRiskSaleGroupToRiskSchema tSchema = getSchema();
/*     */ 
/*  69 */     int tCount = this.db.getCount(tSchema);
/*  70 */     if (tCount < 0)
/*     */     {
/*  73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  74 */       CError tError = new CError();
/*  75 */       tError.moduleName = "LNPRiskSaleGroupToRiskDB";
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
/*  96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPRiskSaleGroupToRisk WHERE  GroupCode = ? AND RiskCode = ?");
/*  97 */       if ((getGroupCode() == null) || (getGroupCode().equals("null")))
/*  98 */         pstmt.setNull(1, 12);
/*     */       else {
/* 100 */         pstmt.setString(1, getGroupCode());
/*     */       }
/* 102 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/* 103 */         pstmt.setNull(2, 12);
/*     */       else {
/* 105 */         pstmt.setString(2, getRiskCode());
/*     */       }
/* 107 */       pstmt.executeUpdate();
/* 108 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 111 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 112 */       CError tError = new CError();
/* 113 */       tError.moduleName = "LNPRiskSaleGroupToRiskDB";
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
/* 150 */       pstmt = this.con.prepareStatement("UPDATE LNPRiskSaleGroupToRisk SET  GroupCode = ? , RiskCode = ? WHERE  GroupCode = ? AND RiskCode = ?");
/* 151 */       if ((getGroupCode() == null) || (getGroupCode().equals("null")))
/* 152 */         pstmt.setNull(1, 12);
/*     */       else {
/* 154 */         pstmt.setString(1, getGroupCode());
/*     */       }
/* 156 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/* 157 */         pstmt.setNull(2, 12);
/*     */       else {
/* 159 */         pstmt.setString(2, getRiskCode());
/*     */       }
/*     */ 
/* 162 */       if ((getGroupCode() == null) || (getGroupCode().equals("null")))
/* 163 */         pstmt.setNull(3, 12);
/*     */       else {
/* 165 */         pstmt.setString(3, getGroupCode());
/*     */       }
/* 167 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/* 168 */         pstmt.setNull(4, 12);
/*     */       else {
/* 170 */         pstmt.setString(4, getRiskCode());
/*     */       }
/* 172 */       pstmt.executeUpdate();
/* 173 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 176 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 177 */       CError tError = new CError();
/* 178 */       tError.moduleName = "LNPRiskSaleGroupToRiskDB";
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
/* 215 */       pstmt = this.con.prepareStatement("INSERT INTO LNPRiskSaleGroupToRisk VALUES( ? , ?)");
/* 216 */       if ((getGroupCode() == null) || (getGroupCode().equals("null")))
/* 217 */         pstmt.setNull(1, 12);
/*     */       else {
/* 219 */         pstmt.setString(1, getGroupCode());
/*     */       }
/* 221 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/* 222 */         pstmt.setNull(2, 12);
/*     */       else {
/* 224 */         pstmt.setString(2, getRiskCode());
/*     */       }
/*     */ 
/* 227 */       pstmt.executeUpdate();
/* 228 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 231 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 232 */       CError tError = new CError();
/* 233 */       tError.moduleName = "LNPRiskSaleGroupToRiskDB";
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
/* 271 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPRiskSaleGroupToRisk WHERE  GroupCode = ? AND RiskCode = ?", 
/* 272 */         1003, 1007);
/* 273 */       if ((getGroupCode() == null) || (getGroupCode().equals("null")))
/* 274 */         pstmt.setNull(1, 12);
/*     */       else {
/* 276 */         pstmt.setString(1, getGroupCode());
/*     */       }
/* 278 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/* 279 */         pstmt.setNull(2, 12);
/*     */       else {
/* 281 */         pstmt.setString(2, getRiskCode());
/*     */       }
/* 283 */       rs = pstmt.executeQuery();
/* 284 */       int i = 0;
/* 285 */       if (rs.next())
/*     */       {
/* 287 */         i++;
/* 288 */         if (!setSchema(rs, i))
/*     */         {
/* 291 */           CError tError = new CError();
/* 292 */           tError.moduleName = "LNPRiskSaleGroupToRiskDB";
/* 293 */           tError.functionName = "getInfo";
/* 294 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
/* 295 */           this.mErrors.addOneError(tError);
/*     */           try {
/* 297 */             rs.close(); } catch (Exception localException1) {
/*     */           }try { pstmt.close(); } catch (Exception localException2) {
/*     */           }
/* 300 */           if (!this.mflag)
/*     */           {
/*     */             try
/*     */             {
/* 304 */               this.con.close();
/*     */             } catch (Exception localException3) {
/*     */             }
/*     */           }
/* 308 */           return false;
/*     */         }
/*     */       }
/*     */       try {
/* 312 */         rs.close(); } catch (Exception localException4) {
/*     */       }try { pstmt.close(); } catch (Exception localException5) {
/*     */       }
/* 315 */       if (i == 0)
/*     */       {
/* 317 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 321 */             this.con.close();
/*     */           } catch (Exception localException6) {
/*     */           }
/*     */         }
/* 325 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 331 */       CError tError = new CError();
/* 332 */       tError.moduleName = "LNPRiskSaleGroupToRiskDB";
/* 333 */       tError.functionName = "getInfo";
/* 334 */       tError.errorMessage = e.toString();
/* 335 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 337 */         rs.close(); } catch (Exception localException7) {
/*     */       }try { pstmt.close(); } catch (Exception localException8) {
/*     */       }
/* 340 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 344 */           this.con.close();
/*     */         } catch (Exception localException9) {
/*     */         }
/*     */       }
/* 348 */       return false;
/*     */     }
/*     */ 
/* 351 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 355 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException10) {
/*     */       }
/*     */     }
/* 360 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPRiskSaleGroupToRiskSet query()
/*     */   {
/* 365 */     Statement stmt = null;
/* 366 */     ResultSet rs = null;
/* 367 */     LNPRiskSaleGroupToRiskSet aLNPRiskSaleGroupToRiskSet = new LNPRiskSaleGroupToRiskSet();
/*     */ 
/* 369 */     if (!this.mflag) {
/* 370 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 375 */       stmt = this.con.createStatement(1003, 1007);
/* 376 */       SQLString sqlObj = new SQLString("LNPRiskSaleGroupToRisk");
/* 377 */       LNPRiskSaleGroupToRiskSchema aSchema = getSchema();
/* 378 */       sqlObj.setSQL(5, aSchema);
/* 379 */       String sql = sqlObj.getSQL();
/*     */ 
/* 381 */       rs = stmt.executeQuery(sql);
/* 382 */       int i = 0;
/* 383 */       while (rs.next())
/*     */       {
/* 385 */         i++;
/* 386 */         LNPRiskSaleGroupToRiskSchema s1 = new LNPRiskSaleGroupToRiskSchema();
/* 387 */         s1.setSchema(rs, i);
/* 388 */         aLNPRiskSaleGroupToRiskSet.add(s1);
/*     */       }try {
/* 390 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 396 */       CError tError = new CError();
/* 397 */       tError.moduleName = "LNPRiskSaleGroupToRiskDB";
/* 398 */       tError.functionName = "query";
/* 399 */       tError.errorMessage = e.toString();
/* 400 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 402 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 405 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 409 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 415 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 419 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 424 */     return aLNPRiskSaleGroupToRiskSet;
/*     */   }
/*     */ 
/*     */   public LNPRiskSaleGroupToRiskSet executeQuery(String sql)
/*     */   {
/* 429 */     Statement stmt = null;
/* 430 */     ResultSet rs = null;
/* 431 */     LNPRiskSaleGroupToRiskSet aLNPRiskSaleGroupToRiskSet = new LNPRiskSaleGroupToRiskSet();
/*     */ 
/* 433 */     if (!this.mflag) {
/* 434 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 439 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 441 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 442 */       int i = 0;
/* 443 */       while (rs.next())
/*     */       {
/* 445 */         i++;
/* 446 */         LNPRiskSaleGroupToRiskSchema s1 = new LNPRiskSaleGroupToRiskSchema();
/* 447 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 450 */           CError tError = new CError();
/* 451 */           tError.moduleName = "LNPRiskSaleGroupToRiskDB";
/* 452 */           tError.functionName = "executeQuery";
/* 453 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/* 454 */           this.mErrors.addOneError(tError);
/*     */         }
/* 456 */         aLNPRiskSaleGroupToRiskSet.add(s1);
/*     */       }try {
/* 458 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 464 */       CError tError = new CError();
/* 465 */       tError.moduleName = "LNPRiskSaleGroupToRiskDB";
/* 466 */       tError.functionName = "executeQuery";
/* 467 */       tError.errorMessage = e.toString();
/* 468 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 470 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 473 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 477 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 483 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 487 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 492 */     return aLNPRiskSaleGroupToRiskSet;
/*     */   }
/*     */ 
/*     */   public LNPRiskSaleGroupToRiskSet query(int nStart, int nCount)
/*     */   {
/* 497 */     Statement stmt = null;
/* 498 */     ResultSet rs = null;
/* 499 */     LNPRiskSaleGroupToRiskSet aLNPRiskSaleGroupToRiskSet = new LNPRiskSaleGroupToRiskSet();
/*     */ 
/* 501 */     if (!this.mflag) {
/* 502 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 507 */       stmt = this.con.createStatement(1003, 1007);
/* 508 */       SQLString sqlObj = new SQLString("LNPRiskSaleGroupToRisk");
/* 509 */       LNPRiskSaleGroupToRiskSchema aSchema = getSchema();
/* 510 */       sqlObj.setSQL(5, aSchema);
/* 511 */       String sql = sqlObj.getSQL();
/*     */ 
/* 513 */       rs = stmt.executeQuery(sql);
/* 514 */       int i = 0;
/* 515 */       while (rs.next())
/*     */       {
/* 517 */         i++;
/*     */ 
/* 519 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 523 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 527 */         LNPRiskSaleGroupToRiskSchema s1 = new LNPRiskSaleGroupToRiskSchema();
/* 528 */         s1.setSchema(rs, i);
/* 529 */         aLNPRiskSaleGroupToRiskSet.add(s1);
/*     */       }try {
/* 531 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 537 */       CError tError = new CError();
/* 538 */       tError.moduleName = "LNPRiskSaleGroupToRiskDB";
/* 539 */       tError.functionName = "query";
/* 540 */       tError.errorMessage = e.toString();
/* 541 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 543 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 546 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 550 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 556 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 560 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 565 */     return aLNPRiskSaleGroupToRiskSet;
/*     */   }
/*     */ 
/*     */   public LNPRiskSaleGroupToRiskSet executeQuery(String sql, int nStart, int nCount)
/*     */   {
/* 570 */     Statement stmt = null;
/* 571 */     ResultSet rs = null;
/* 572 */     LNPRiskSaleGroupToRiskSet aLNPRiskSaleGroupToRiskSet = new LNPRiskSaleGroupToRiskSet();
/*     */ 
/* 574 */     if (!this.mflag) {
/* 575 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 580 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 582 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 583 */       int i = 0;
/* 584 */       while (rs.next())
/*     */       {
/* 586 */         i++;
/*     */ 
/* 588 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 592 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 596 */         LNPRiskSaleGroupToRiskSchema s1 = new LNPRiskSaleGroupToRiskSchema();
/* 597 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 600 */           CError tError = new CError();
/* 601 */           tError.moduleName = "LNPRiskSaleGroupToRiskDB";
/* 602 */           tError.functionName = "executeQuery";
/* 603 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/* 604 */           this.mErrors.addOneError(tError);
/*     */         }
/* 606 */         aLNPRiskSaleGroupToRiskSet.add(s1);
/*     */       }try {
/* 608 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 614 */       CError tError = new CError();
/* 615 */       tError.moduleName = "LNPRiskSaleGroupToRiskDB";
/* 616 */       tError.functionName = "executeQuery";
/* 617 */       tError.errorMessage = e.toString();
/* 618 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 620 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 623 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 627 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 633 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 637 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 642 */     return aLNPRiskSaleGroupToRiskSet;
/*     */   }
/*     */ 
/*     */   public boolean update(String strWherePart)
/*     */   {
/* 647 */     Statement stmt = null;
/*     */ 
/* 649 */     if (!this.mflag) {
/* 650 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 655 */       stmt = this.con.createStatement(1003, 1007);
/* 656 */       SQLString sqlObj = new SQLString("LNPRiskSaleGroupToRisk");
/* 657 */       LNPRiskSaleGroupToRiskSchema aSchema = getSchema();
/* 658 */       sqlObj.setSQL(2, aSchema);
/* 659 */       String sql = "update LNPRiskSaleGroupToRisk " + sqlObj.getUpdPart() + " where " + strWherePart;
/*     */ 
/* 661 */       int operCount = stmt.executeUpdate(sql);
/* 662 */       if (operCount == 0)
/*     */       {
/* 665 */         CError tError = new CError();
/* 666 */         tError.moduleName = "LNPRiskSaleGroupToRiskDB";
/* 667 */         tError.functionName = "update";
/* 668 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
/* 669 */         this.mErrors.addOneError(tError);
/*     */ 
/* 671 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 675 */             this.con.close();
/*     */           } catch (Exception localException1) {
/*     */           }
/*     */         }
/* 679 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 685 */       CError tError = new CError();
/* 686 */       tError.moduleName = "LNPRiskSaleGroupToRiskDB";
/* 687 */       tError.functionName = "update";
/* 688 */       tError.errorMessage = e.toString();
/* 689 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 691 */         stmt.close(); } catch (Exception localException2) {
/*     */       }
/* 693 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 697 */           this.con.close();
/*     */         } catch (Exception localException3) {
/*     */         }
/*     */       }
/* 701 */       return false;
/*     */     }
/*     */ 
/* 704 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 708 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException4) {
/*     */       }
/*     */     }
/* 713 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean prepareData(String strSQL)
/*     */   {
/* 719 */     if (this.mResultSet != null)
/*     */     {
/* 722 */       CError tError = new CError();
/* 723 */       tError.moduleName = "LNPRiskSaleGroupToRiskDB";
/* 724 */       tError.functionName = "prepareData";
/* 725 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
/* 726 */       this.mErrors.addOneError(tError);
/* 727 */       return false;
/*     */     }
/*     */ 
/* 730 */     if (!this.mflag)
/*     */     {
/* 732 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */     try
/*     */     {
/* 736 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 737 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 742 */       CError tError = new CError();
/* 743 */       tError.moduleName = "LNPRiskSaleGroupToRiskDB";
/* 744 */       tError.functionName = "prepareData";
/* 745 */       tError.errorMessage = e.toString();
/* 746 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 749 */         this.mResultSet.close();
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 755 */         this.mStatement.close();
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 759 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 763 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 768 */       return false;
/*     */     }
/*     */ 
/* 771 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 775 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException4) {
/*     */       }
/*     */     }
/* 780 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean hasMoreData()
/*     */   {
/* 786 */     boolean flag = true;
/* 787 */     if (this.mResultSet == null)
/*     */     {
/* 789 */       CError tError = new CError();
/* 790 */       tError.moduleName = "LNPRiskSaleGroupToRiskDB";
/* 791 */       tError.functionName = "hasMoreData";
/* 792 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 793 */       this.mErrors.addOneError(tError);
/* 794 */       return false;
/*     */     }
/*     */     try
/*     */     {
/* 798 */       flag = this.mResultSet.next();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 802 */       CError tError = new CError();
/* 803 */       tError.moduleName = "LNPRiskSaleGroupToRiskDB";
/* 804 */       tError.functionName = "hasMoreData";
/* 805 */       tError.errorMessage = ex.toString();
/* 806 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 809 */         this.mResultSet.close();
/* 810 */         this.mResultSet = null;
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 816 */         this.mStatement.close();
/* 817 */         this.mStatement = null;
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 821 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 825 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 830 */       return false;
/*     */     }
/* 832 */     return flag;
/*     */   }
/*     */ 
/*     */   public LNPRiskSaleGroupToRiskSet getData()
/*     */   {
/* 837 */     int tCount = 0;
/* 838 */     LNPRiskSaleGroupToRiskSet tLNPRiskSaleGroupToRiskSet = new LNPRiskSaleGroupToRiskSet();
/* 839 */     LNPRiskSaleGroupToRiskSchema tLNPRiskSaleGroupToRiskSchema = null;
/* 840 */     if (this.mResultSet == null)
/*     */     {
/* 842 */       CError tError = new CError();
/* 843 */       tError.moduleName = "LNPRiskSaleGroupToRiskDB";
/* 844 */       tError.functionName = "getData";
/* 845 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/* 846 */       this.mErrors.addOneError(tError);
/* 847 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 851 */       tCount = 1;
/* 852 */       tLNPRiskSaleGroupToRiskSchema = new LNPRiskSaleGroupToRiskSchema();
/* 853 */       tLNPRiskSaleGroupToRiskSchema.setSchema(this.mResultSet, 1);
/* 854 */       tLNPRiskSaleGroupToRiskSet.add(tLNPRiskSaleGroupToRiskSchema);
/*     */ 
/* 856 */       while (tCount++ < 5000)
/*     */       {
/* 858 */         if (!this.mResultSet.next())
/*     */           continue;
/* 860 */         tLNPRiskSaleGroupToRiskSchema = new LNPRiskSaleGroupToRiskSchema();
/* 861 */         tLNPRiskSaleGroupToRiskSchema.setSchema(this.mResultSet, 1);
/* 862 */         tLNPRiskSaleGroupToRiskSet.add(tLNPRiskSaleGroupToRiskSchema);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 868 */       CError tError = new CError();
/* 869 */       tError.moduleName = "LNPRiskSaleGroupToRiskDB";
/* 870 */       tError.functionName = "getData";
/* 871 */       tError.errorMessage = ex.toString();
/* 872 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 875 */         this.mResultSet.close();
/* 876 */         this.mResultSet = null;
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 882 */         this.mStatement.close();
/* 883 */         this.mStatement = null;
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 887 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 891 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 896 */       return null;
/*     */     }
/* 898 */     return tLNPRiskSaleGroupToRiskSet;
/*     */   }
/*     */ 
/*     */   public boolean closeData()
/*     */   {
/* 903 */     boolean flag = true;
/*     */     try
/*     */     {
/* 906 */       if (this.mResultSet == null)
/*     */       {
/* 908 */         CError tError = new CError();
/* 909 */         tError.moduleName = "LNPRiskSaleGroupToRiskDB";
/* 910 */         tError.functionName = "closeData";
/* 911 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
/* 912 */         this.mErrors.addOneError(tError);
/* 913 */         flag = false;
/*     */       }
/*     */       else
/*     */       {
/* 917 */         this.mResultSet.close();
/* 918 */         this.mResultSet = null;
/*     */       }
/*     */     }
/*     */     catch (Exception ex2)
/*     */     {
/* 923 */       CError tError = new CError();
/* 924 */       tError.moduleName = "LNPRiskSaleGroupToRiskDB";
/* 925 */       tError.functionName = "closeData";
/* 926 */       tError.errorMessage = ex2.toString();
/* 927 */       this.mErrors.addOneError(tError);
/* 928 */       flag = false;
/*     */     }
/*     */     try
/*     */     {
/* 932 */       if (this.mStatement == null)
/*     */       {
/* 934 */         CError tError = new CError();
/* 935 */         tError.moduleName = "LNPRiskSaleGroupToRiskDB";
/* 936 */         tError.functionName = "closeData";
/* 937 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
/* 938 */         this.mErrors.addOneError(tError);
/* 939 */         flag = false;
/*     */       }
/*     */       else
/*     */       {
/* 943 */         this.mStatement.close();
/* 944 */         this.mStatement = null;
/*     */       }
/*     */     }
/*     */     catch (Exception ex3)
/*     */     {
/* 949 */       CError tError = new CError();
/* 950 */       tError.moduleName = "LNPRiskSaleGroupToRiskDB";
/* 951 */       tError.functionName = "closeData";
/* 952 */       tError.errorMessage = ex3.toString();
/* 953 */       this.mErrors.addOneError(tError);
/* 954 */       flag = false;
/*     */     }
/* 956 */     return flag;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPRiskSaleGroupToRiskDB
 * JD-Core Version:    0.6.0
 */