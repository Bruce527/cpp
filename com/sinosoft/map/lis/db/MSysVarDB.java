/*     */ package com.sinosoft.map.lis.db;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MSysVarSchema;
/*     */ import com.sinosoft.map.lis.vschema.MSysVarSet;
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
/*     */ public class MSysVarDB extends MSysVarSchema
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
/*     */   public MSysVarDB(Connection tConnection)
/*     */   {
/*  30 */     this.con = tConnection;
/*  31 */     this.db = new DBOper(this.con, "MSysVar");
/*  32 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MSysVarDB()
/*     */   {
/*  37 */     this.con = null;
/*  38 */     this.db = new DBOper("MSysVar");
/*  39 */     this.mflag = false;
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  45 */     MSysVarSchema tSchema = getSchema();
/*  46 */     if (this.db.deleteSQL(tSchema))
/*     */     {
/*  48 */       return true;
/*     */     }
/*     */ 
/*  53 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*  54 */     CError tError = new CError();
/*  55 */     tError.moduleName = "MSysVarDB";
/*  56 */     tError.functionName = "deleteSQL";
/*  57 */     tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  58 */     this.mErrors.addOneError(tError);
/*  59 */     return false;
/*     */   }
/*     */ 
/*     */   public int getCount()
/*     */   {
/*  65 */     MSysVarSchema tSchema = getSchema();
/*     */ 
/*  67 */     int tCount = this.db.getCount(tSchema);
/*  68 */     if (tCount < 0)
/*     */     {
/*  71 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  72 */       CError tError = new CError();
/*  73 */       tError.moduleName = "MSysVarDB";
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
/*  94 */       pstmt = this.con.prepareStatement("DELETE FROM MSysVar WHERE  VarType = ?");
/*  95 */       if ((getVarType() == null) || (getVarType().equals("null")))
/*  96 */         pstmt.setNull(1, 12);
/*     */       else {
/*  98 */         pstmt.setString(1, getVarType());
/*     */       }
/* 100 */       pstmt.executeUpdate();
/* 101 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 104 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 105 */       CError tError = new CError();
/* 106 */       tError.moduleName = "MSysVarDB";
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
/* 143 */       pstmt = this.con.prepareStatement("UPDATE MSysVar SET  VarType = ? , VarValue = ? WHERE  VarType = ?");
/* 144 */       if ((getVarType() == null) || (getVarType().equals("null")))
/* 145 */         pstmt.setNull(1, 12);
/*     */       else {
/* 147 */         pstmt.setString(1, getVarType());
/*     */       }
/* 149 */       if ((getVarValue() == null) || (getVarValue().equals("null")))
/* 150 */         pstmt.setNull(2, 12);
/*     */       else {
/* 152 */         pstmt.setString(2, getVarValue());
/*     */       }
/*     */ 
/* 155 */       if ((getVarType() == null) || (getVarType().equals("null")))
/* 156 */         pstmt.setNull(3, 12);
/*     */       else {
/* 158 */         pstmt.setString(3, getVarType());
/*     */       }
/* 160 */       pstmt.executeUpdate();
/* 161 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 164 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 165 */       CError tError = new CError();
/* 166 */       tError.moduleName = "MSysVarDB";
/* 167 */       tError.functionName = "update()";
/* 168 */       tError.errorMessage = ex.toString();
/* 169 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 172 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 175 */       if (!this.mflag)
/*     */         try {
/* 177 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 181 */       return false;
/*     */     }
/*     */ 
/* 184 */     if (!this.mflag)
/*     */       try {
/* 186 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 190 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 195 */     PreparedStatement pstmt = null;
/*     */ 
/* 197 */     if (!this.mflag) {
/* 198 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 203 */       pstmt = this.con.prepareStatement("INSERT INTO MSysVar VALUES( ? , ?)");
/* 204 */       if ((getVarType() == null) || (getVarType().equals("null")))
/* 205 */         pstmt.setNull(1, 12);
/*     */       else {
/* 207 */         pstmt.setString(1, getVarType());
/*     */       }
/* 209 */       if ((getVarValue() == null) || (getVarValue().equals("null")))
/* 210 */         pstmt.setNull(2, 12);
/*     */       else {
/* 212 */         pstmt.setString(2, getVarValue());
/*     */       }
/*     */ 
/* 215 */       pstmt.executeUpdate();
/* 216 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 219 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 220 */       CError tError = new CError();
/* 221 */       tError.moduleName = "MSysVarDB";
/* 222 */       tError.functionName = "insert()";
/* 223 */       tError.errorMessage = ex.toString();
/* 224 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 227 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 230 */       if (!this.mflag)
/*     */         try {
/* 232 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 236 */       return false;
/*     */     }
/*     */ 
/* 239 */     if (!this.mflag)
/*     */       try {
/* 241 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 245 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean getInfo()
/*     */   {
/* 250 */     PreparedStatement pstmt = null;
/* 251 */     ResultSet rs = null;
/*     */ 
/* 253 */     if (!this.mflag) {
/* 254 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 259 */       pstmt = this.con.prepareStatement("SELECT * FROM MSysVar WHERE  VarType = ?", 
/* 260 */         1003, 1007);
/* 261 */       if ((getVarType() == null) || (getVarType().equals("null")))
/* 262 */         pstmt.setNull(1, 12);
/*     */       else {
/* 264 */         pstmt.setString(1, getVarType());
/*     */       }
/* 266 */       rs = pstmt.executeQuery();
/* 267 */       int i = 0;
/* 268 */       if (rs.next())
/*     */       {
/* 270 */         i++;
/* 271 */         if (!setSchema(rs, i))
/*     */         {
/* 274 */           CError tError = new CError();
/* 275 */           tError.moduleName = "MSysVarDB";
/* 276 */           tError.functionName = "getInfo";
/* 277 */           tError.errorMessage = "\u53D6\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/* 278 */           this.mErrors.addOneError(tError);
/*     */           try {
/* 280 */             rs.close(); } catch (Exception localException1) {
/*     */           }try { pstmt.close(); } catch (Exception localException2) {
/*     */           }
/* 283 */           if (!this.mflag)
/*     */           {
/*     */             try
/*     */             {
/* 287 */               this.con.close();
/*     */             } catch (Exception localException3) {
/*     */             }
/*     */           }
/* 291 */           return false;
/*     */         }
/*     */       }
/*     */       try {
/* 295 */         rs.close(); } catch (Exception localException4) {
/*     */       }try { pstmt.close(); } catch (Exception localException5) {
/*     */       }
/* 298 */       if (i == 0)
/*     */       {
/* 300 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 304 */             this.con.close();
/*     */           } catch (Exception localException6) {
/*     */           }
/*     */         }
/* 308 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 314 */       CError tError = new CError();
/* 315 */       tError.moduleName = "MSysVarDB";
/* 316 */       tError.functionName = "getInfo";
/* 317 */       tError.errorMessage = e.toString();
/* 318 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 320 */         rs.close(); } catch (Exception localException7) {
/*     */       }try { pstmt.close(); } catch (Exception localException8) {
/*     */       }
/* 323 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 327 */           this.con.close();
/*     */         } catch (Exception localException9) {
/*     */         }
/*     */       }
/* 331 */       return false;
/*     */     }
/*     */ 
/* 334 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 338 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException10) {
/*     */       }
/*     */     }
/* 343 */     return true;
/*     */   }
/*     */ 
/*     */   public MSysVarSet query()
/*     */   {
/* 348 */     Statement stmt = null;
/* 349 */     ResultSet rs = null;
/* 350 */     MSysVarSet aMSysVarSet = new MSysVarSet();
/*     */ 
/* 352 */     if (!this.mflag) {
/* 353 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 358 */       stmt = this.con.createStatement(1003, 1007);
/* 359 */       SQLString sqlObj = new SQLString("MSysVar");
/* 360 */       MSysVarSchema aSchema = getSchema();
/* 361 */       sqlObj.setSQL(5, aSchema);
/* 362 */       String sql = sqlObj.getSQL();
/*     */ 
/* 364 */       rs = stmt.executeQuery(sql);
/* 365 */       int i = 0;
/* 366 */       while (rs.next())
/*     */       {
/* 368 */         i++;
/* 369 */         MSysVarSchema s1 = new MSysVarSchema();
/* 370 */         s1.setSchema(rs, i);
/* 371 */         aMSysVarSet.add(s1);
/*     */       }try {
/* 373 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 379 */       CError tError = new CError();
/* 380 */       tError.moduleName = "MSysVarDB";
/* 381 */       tError.functionName = "query";
/* 382 */       tError.errorMessage = e.toString();
/* 383 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 385 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 388 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 392 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 398 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 402 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 407 */     return aMSysVarSet;
/*     */   }
/*     */ 
/*     */   public MSysVarSet executeQuery(String sql)
/*     */   {
/* 412 */     Statement stmt = null;
/* 413 */     ResultSet rs = null;
/* 414 */     MSysVarSet aMSysVarSet = new MSysVarSet();
/*     */ 
/* 416 */     if (!this.mflag) {
/* 417 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 422 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 424 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 425 */       int i = 0;
/* 426 */       while (rs.next())
/*     */       {
/* 428 */         i++;
/* 429 */         MSysVarSchema s1 = new MSysVarSchema();
/* 430 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 433 */           CError tError = new CError();
/* 434 */           tError.moduleName = "MSysVarDB";
/* 435 */           tError.functionName = "executeQuery";
/* 436 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/* 437 */           this.mErrors.addOneError(tError);
/*     */         }
/* 439 */         aMSysVarSet.add(s1);
/*     */       }try {
/* 441 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 447 */       CError tError = new CError();
/* 448 */       tError.moduleName = "MSysVarDB";
/* 449 */       tError.functionName = "executeQuery";
/* 450 */       tError.errorMessage = e.toString();
/* 451 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 453 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 456 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 460 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 466 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 470 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 475 */     return aMSysVarSet;
/*     */   }
/*     */ 
/*     */   public MSysVarSet query(int nStart, int nCount)
/*     */   {
/* 480 */     Statement stmt = null;
/* 481 */     ResultSet rs = null;
/* 482 */     MSysVarSet aMSysVarSet = new MSysVarSet();
/*     */ 
/* 484 */     if (!this.mflag) {
/* 485 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 490 */       stmt = this.con.createStatement(1003, 1007);
/* 491 */       SQLString sqlObj = new SQLString("MSysVar");
/* 492 */       MSysVarSchema aSchema = getSchema();
/* 493 */       sqlObj.setSQL(5, aSchema);
/* 494 */       String sql = sqlObj.getSQL();
/*     */ 
/* 496 */       rs = stmt.executeQuery(sql);
/* 497 */       int i = 0;
/* 498 */       while (rs.next())
/*     */       {
/* 500 */         i++;
/*     */ 
/* 502 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 506 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 510 */         MSysVarSchema s1 = new MSysVarSchema();
/* 511 */         s1.setSchema(rs, i);
/* 512 */         aMSysVarSet.add(s1);
/*     */       }try {
/* 514 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 520 */       CError tError = new CError();
/* 521 */       tError.moduleName = "MSysVarDB";
/* 522 */       tError.functionName = "query";
/* 523 */       tError.errorMessage = e.toString();
/* 524 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 526 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 529 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 533 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 539 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 543 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 548 */     return aMSysVarSet;
/*     */   }
/*     */ 
/*     */   public MSysVarSet executeQuery(String sql, int nStart, int nCount)
/*     */   {
/* 553 */     Statement stmt = null;
/* 554 */     ResultSet rs = null;
/* 555 */     MSysVarSet aMSysVarSet = new MSysVarSet();
/*     */ 
/* 557 */     if (!this.mflag) {
/* 558 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 563 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 565 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 566 */       int i = 0;
/* 567 */       while (rs.next())
/*     */       {
/* 569 */         i++;
/*     */ 
/* 571 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 575 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 579 */         MSysVarSchema s1 = new MSysVarSchema();
/* 580 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 583 */           CError tError = new CError();
/* 584 */           tError.moduleName = "MSysVarDB";
/* 585 */           tError.functionName = "executeQuery";
/* 586 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/* 587 */           this.mErrors.addOneError(tError);
/*     */         }
/* 589 */         aMSysVarSet.add(s1);
/*     */       }try {
/* 591 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 597 */       CError tError = new CError();
/* 598 */       tError.moduleName = "MSysVarDB";
/* 599 */       tError.functionName = "executeQuery";
/* 600 */       tError.errorMessage = e.toString();
/* 601 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 603 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 606 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 610 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 616 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 620 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 625 */     return aMSysVarSet;
/*     */   }
/*     */ 
/*     */   public boolean update(String strWherePart)
/*     */   {
/* 630 */     Statement stmt = null;
/*     */ 
/* 632 */     if (!this.mflag) {
/* 633 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 638 */       stmt = this.con.createStatement(1003, 1007);
/* 639 */       SQLString sqlObj = new SQLString("MSysVar");
/* 640 */       MSysVarSchema aSchema = getSchema();
/* 641 */       sqlObj.setSQL(2, aSchema);
/* 642 */       String sql = "update MSysVar " + sqlObj.getUpdPart() + " where " + strWherePart;
/*     */ 
/* 644 */       int operCount = stmt.executeUpdate(sql);
/* 645 */       if (operCount == 0)
/*     */       {
/* 648 */         CError tError = new CError();
/* 649 */         tError.moduleName = "MSysVarDB";
/* 650 */         tError.functionName = "update";
/* 651 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u7EDE\u044D\u62F7\u951F\uFFFD!";
/* 652 */         this.mErrors.addOneError(tError);
/*     */ 
/* 654 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 658 */             this.con.close();
/*     */           } catch (Exception localException1) {
/*     */           }
/*     */         }
/* 662 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 668 */       CError tError = new CError();
/* 669 */       tError.moduleName = "MSysVarDB";
/* 670 */       tError.functionName = "update";
/* 671 */       tError.errorMessage = e.toString();
/* 672 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 674 */         stmt.close(); } catch (Exception localException2) {
/*     */       }
/* 676 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 680 */           this.con.close();
/*     */         } catch (Exception localException3) {
/*     */         }
/*     */       }
/* 684 */       return false;
/*     */     }
/*     */ 
/* 687 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 691 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException4) {
/*     */       }
/*     */     }
/* 696 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean prepareData(String strSQL)
/*     */   {
/* 702 */     if (this.mResultSet != null)
/*     */     {
/* 705 */       CError tError = new CError();
/* 706 */       tError.moduleName = "MSysVarDB";
/* 707 */       tError.functionName = "prepareData";
/* 708 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u5F3A\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u4E4B\u951F\u65A4\u62F7\u6CA1\u951F\u53EB\u5173\u95ED\uFF4F\u62F7";
/* 709 */       this.mErrors.addOneError(tError);
/* 710 */       return false;
/*     */     }
/*     */ 
/* 713 */     if (!this.mflag)
/*     */     {
/* 715 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */     try
/*     */     {
/* 719 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 720 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 725 */       CError tError = new CError();
/* 726 */       tError.moduleName = "MSysVarDB";
/* 727 */       tError.functionName = "prepareData";
/* 728 */       tError.errorMessage = e.toString();
/* 729 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 732 */         this.mResultSet.close();
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 738 */         this.mStatement.close();
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 742 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 746 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 751 */       return false;
/*     */     }
/*     */ 
/* 754 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 758 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException4) {
/*     */       }
/*     */     }
/* 763 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean hasMoreData()
/*     */   {
/* 769 */     boolean flag = true;
/* 770 */     if (this.mResultSet == null)
/*     */     {
/* 772 */       CError tError = new CError();
/* 773 */       tError.moduleName = "MSysVarDB";
/* 774 */       tError.functionName = "hasMoreData";
/* 775 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/* 776 */       this.mErrors.addOneError(tError);
/* 777 */       return false;
/*     */     }
/*     */     try
/*     */     {
/* 781 */       flag = this.mResultSet.next();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 785 */       CError tError = new CError();
/* 786 */       tError.moduleName = "MSysVarDB";
/* 787 */       tError.functionName = "hasMoreData";
/* 788 */       tError.errorMessage = ex.toString();
/* 789 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 792 */         this.mResultSet.close();
/* 793 */         this.mResultSet = null;
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 799 */         this.mStatement.close();
/* 800 */         this.mStatement = null;
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 804 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 808 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 813 */       return false;
/*     */     }
/* 815 */     return flag;
/*     */   }
/*     */ 
/*     */   public MSysVarSet getData()
/*     */   {
/* 820 */     int tCount = 0;
/* 821 */     MSysVarSet tMSysVarSet = new MSysVarSet();
/* 822 */     MSysVarSchema tMSysVarSchema = null;
/* 823 */     if (this.mResultSet == null)
/*     */     {
/* 825 */       CError tError = new CError();
/* 826 */       tError.moduleName = "MSysVarDB";
/* 827 */       tError.functionName = "getData";
/* 828 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/* 829 */       this.mErrors.addOneError(tError);
/* 830 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 834 */       tCount = 1;
/* 835 */       tMSysVarSchema = new MSysVarSchema();
/* 836 */       tMSysVarSchema.setSchema(this.mResultSet, 1);
/* 837 */       tMSysVarSet.add(tMSysVarSchema);
/*     */ 
/* 839 */       while (tCount++ < 5000)
/*     */       {
/* 841 */         if (!this.mResultSet.next())
/*     */           continue;
/* 843 */         tMSysVarSchema = new MSysVarSchema();
/* 844 */         tMSysVarSchema.setSchema(this.mResultSet, 1);
/* 845 */         tMSysVarSet.add(tMSysVarSchema);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 851 */       CError tError = new CError();
/* 852 */       tError.moduleName = "MSysVarDB";
/* 853 */       tError.functionName = "getData";
/* 854 */       tError.errorMessage = ex.toString();
/* 855 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 858 */         this.mResultSet.close();
/* 859 */         this.mResultSet = null;
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 865 */         this.mStatement.close();
/* 866 */         this.mStatement = null;
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 870 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 874 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 879 */       return null;
/*     */     }
/* 881 */     return tMSysVarSet;
/*     */   }
/*     */ 
/*     */   public boolean closeData()
/*     */   {
/* 886 */     boolean flag = true;
/*     */     try
/*     */     {
/* 889 */       if (this.mResultSet == null)
/*     */       {
/* 891 */         CError tError = new CError();
/* 892 */         tError.moduleName = "MSysVarDB";
/* 893 */         tError.functionName = "closeData";
/* 894 */         tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 895 */         this.mErrors.addOneError(tError);
/* 896 */         flag = false;
/*     */       }
/*     */       else
/*     */       {
/* 900 */         this.mResultSet.close();
/* 901 */         this.mResultSet = null;
/*     */       }
/*     */     }
/*     */     catch (Exception ex2)
/*     */     {
/* 906 */       CError tError = new CError();
/* 907 */       tError.moduleName = "MSysVarDB";
/* 908 */       tError.functionName = "closeData";
/* 909 */       tError.errorMessage = ex2.toString();
/* 910 */       this.mErrors.addOneError(tError);
/* 911 */       flag = false;
/*     */     }
/*     */     try
/*     */     {
/* 915 */       if (this.mStatement == null)
/*     */       {
/* 917 */         CError tError = new CError();
/* 918 */         tError.moduleName = "MSysVarDB";
/* 919 */         tError.functionName = "closeData";
/* 920 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 921 */         this.mErrors.addOneError(tError);
/* 922 */         flag = false;
/*     */       }
/*     */       else
/*     */       {
/* 926 */         this.mStatement.close();
/* 927 */         this.mStatement = null;
/*     */       }
/*     */     }
/*     */     catch (Exception ex3)
/*     */     {
/* 932 */       CError tError = new CError();
/* 933 */       tError.moduleName = "MSysVarDB";
/* 934 */       tError.functionName = "closeData";
/* 935 */       tError.errorMessage = ex3.toString();
/* 936 */       this.mErrors.addOneError(tError);
/* 937 */       flag = false;
/*     */     }
/* 939 */     return flag;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MSysVarDB
 * JD-Core Version:    0.6.0
 */