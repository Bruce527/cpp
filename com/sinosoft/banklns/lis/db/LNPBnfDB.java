/*     */ package com.sinosoft.banklns.lis.db;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPBnfSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPBnfSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import com.sinosoft.banklns.utility.SQLString;
/*     */ import com.sinosoft.banklns.utility.StrTool;
/*     */ import java.sql.Connection;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ 
/*     */ public class LNPBnfDB extends LNPBnfSchema
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  30 */   private boolean mflag = false;
/*     */ 
/*  32 */   public CErrors mErrors = new CErrors();
/*     */ 
/*     */   public LNPBnfDB(Connection tConnection)
/*     */   {
/*  37 */     this.con = tConnection;
/*  38 */     this.db = new DBOper(this.con, "LNPBnf");
/*  39 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPBnfDB()
/*     */   {
/*  44 */     this.con = null;
/*  45 */     this.db = new DBOper("LNPBnf");
/*  46 */     this.mflag = false;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/*  52 */     LNPBnfSchema tSchema = getSchema();
/*  53 */     if (!this.db.insert(tSchema))
/*     */     {
/*  56 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  57 */       CError tError = new CError();
/*  58 */       tError.moduleName = "LNPBnfDB";
/*  59 */       tError.functionName = "insert";
/*  60 */       tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  61 */       this.mErrors.addOneError(tError);
/*     */ 
/*  63 */       return false;
/*     */     }
/*     */ 
/*  66 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  71 */     LNPBnfSchema tSchema = getSchema();
/*  72 */     if (!this.db.update(tSchema))
/*     */     {
/*  75 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  76 */       CError tError = new CError();
/*  77 */       tError.moduleName = "LNPBnfDB";
/*  78 */       tError.functionName = "update";
/*  79 */       tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  80 */       this.mErrors.addOneError(tError);
/*     */ 
/*  82 */       return false;
/*     */     }
/*     */ 
/*  85 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  90 */     LNPBnfSchema tSchema = getSchema();
/*  91 */     if (!this.db.deleteSQL(tSchema))
/*     */     {
/*  94 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  95 */       CError tError = new CError();
/*  96 */       tError.moduleName = "LNPBnfDB";
/*  97 */       tError.functionName = "deleteSQL";
/*  98 */       tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  99 */       this.mErrors.addOneError(tError);
/*     */ 
/* 101 */       return false;
/*     */     }
/*     */ 
/* 104 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean delete()
/*     */   {
/* 109 */     LNPBnfSchema tSchema = getSchema();
/* 110 */     if (!this.db.delete(tSchema))
/*     */     {
/* 113 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 114 */       CError tError = new CError();
/* 115 */       tError.moduleName = "LNPBnfDB";
/* 116 */       tError.functionName = "delete";
/* 117 */       tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/* 118 */       this.mErrors.addOneError(tError);
/*     */ 
/* 120 */       return false;
/*     */     }
/*     */ 
/* 123 */     return true;
/*     */   }
/*     */ 
/*     */   public int getCount()
/*     */   {
/* 128 */     LNPBnfSchema tSchema = getSchema();
/*     */ 
/* 130 */     int tCount = this.db.getCount(tSchema);
/* 131 */     if (tCount < 0)
/*     */     {
/* 134 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 135 */       CError tError = new CError();
/* 136 */       tError.moduleName = "LNPBnfDB";
/* 137 */       tError.functionName = "getCount";
/* 138 */       tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/* 139 */       this.mErrors.addOneError(tError);
/*     */ 
/* 141 */       return -1;
/*     */     }
/*     */ 
/* 144 */     return tCount;
/*     */   }
/*     */ 
/*     */   public boolean getInfo()
/*     */   {
/* 149 */     Statement stmt = null;
/* 150 */     ResultSet rs = null;
/*     */ 
/* 152 */     if (!this.mflag) {
/* 153 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 158 */       stmt = this.con.createStatement(1003, 1007);
/* 159 */       SQLString sqlObj = new SQLString("LNPBnf");
/* 160 */       LNPBnfSchema aSchema = getSchema();
/* 161 */       sqlObj.setSQL(6, aSchema);
/* 162 */       String sql = sqlObj.getSQL();
/*     */ 
/* 164 */       rs = stmt.executeQuery(sql);
/* 165 */       int i = 0;
/* 166 */       if (rs.next())
/*     */       {
/* 168 */         i++;
/* 169 */         if (!setSchema(rs, i))
/*     */         {
/* 172 */           CError tError = new CError();
/* 173 */           tError.moduleName = "LNPBnfDB";
/* 174 */           tError.functionName = "getInfo";
/* 175 */           tError.errorMessage = "\u53D6\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/* 176 */           this.mErrors.addOneError(tError);
/*     */           try {
/* 178 */             rs.close(); } catch (Exception localException1) {
/*     */           }try { stmt.close(); } catch (Exception localException2) {
/*     */           }
/* 181 */           if (!this.mflag)
/*     */           {
/*     */             try
/*     */             {
/* 185 */               this.con.close();
/*     */             } catch (Exception localException3) {
/*     */             }
/*     */           }
/* 189 */           return false;
/*     */         }
/*     */       }
/*     */       try {
/* 193 */         rs.close(); } catch (Exception localException4) {
/*     */       }try { stmt.close(); } catch (Exception localException5) {
/*     */       }
/* 196 */       if (i == 0)
/*     */       {
/* 199 */         CError tError = new CError();
/* 200 */         tError.moduleName = "LNPBnfDB";
/* 201 */         tError.functionName = "getInfo";
/* 202 */         tError.errorMessage = "\u672A\u951F\u63ED\u7889\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7!";
/* 203 */         this.mErrors.addOneError(tError);
/*     */ 
/* 205 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 209 */             this.con.close();
/*     */           } catch (Exception localException6) {
/*     */           }
/*     */         }
/* 213 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 219 */       CError tError = new CError();
/* 220 */       tError.moduleName = "LNPBnfDB";
/* 221 */       tError.functionName = "getInfo";
/* 222 */       tError.errorMessage = e.toString();
/* 223 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 225 */         rs.close(); } catch (Exception localException7) {
/*     */       }try { stmt.close(); } catch (Exception localException8) {
/*     */       }
/* 228 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 232 */           this.con.close();
/*     */         } catch (Exception localException9) {
/*     */         }
/*     */       }
/* 236 */       return false;
/*     */     }
/*     */ 
/* 239 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 243 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException10) {
/*     */       }
/*     */     }
/* 248 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPBnfSet query()
/*     */   {
/* 253 */     Statement stmt = null;
/* 254 */     ResultSet rs = null;
/* 255 */     LNPBnfSet aLNPBnfSet = new LNPBnfSet();
/*     */ 
/* 257 */     if (!this.mflag) {
/* 258 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 263 */       stmt = this.con.createStatement(1003, 1007);
/* 264 */       SQLString sqlObj = new SQLString("LNPBnf");
/* 265 */       LNPBnfSchema aSchema = getSchema();
/* 266 */       sqlObj.setSQL(5, aSchema);
/* 267 */       String sql = sqlObj.getSQL();
/*     */ 
/* 269 */       rs = stmt.executeQuery(sql);
/* 270 */       int i = 0;
/* 271 */       while (rs.next())
/*     */       {
/* 273 */         i++;
/* 274 */         LNPBnfSchema s1 = new LNPBnfSchema();
/* 275 */         s1.setSchema(rs, i);
/* 276 */         aLNPBnfSet.add(s1);
/*     */       }try {
/* 278 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 284 */       CError tError = new CError();
/* 285 */       tError.moduleName = "LNPBnfDB";
/* 286 */       tError.functionName = "query";
/* 287 */       tError.errorMessage = e.toString();
/* 288 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 290 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 293 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 297 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 303 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 307 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 312 */     return aLNPBnfSet;
/*     */   }
/*     */ 
/*     */   public LNPBnfSet executeQuery(String sql)
/*     */   {
/* 317 */     Statement stmt = null;
/* 318 */     ResultSet rs = null;
/* 319 */     LNPBnfSet aLNPBnfSet = new LNPBnfSet();
/*     */ 
/* 321 */     if (!this.mflag) {
/* 322 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 327 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 329 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 330 */       int i = 0;
/* 331 */       while (rs.next())
/*     */       {
/* 333 */         i++;
/* 334 */         LNPBnfSchema s1 = new LNPBnfSchema();
/* 335 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 338 */           CError tError = new CError();
/* 339 */           tError.moduleName = "LNPBnfDB";
/* 340 */           tError.functionName = "executeQuery";
/* 341 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/* 342 */           this.mErrors.addOneError(tError);
/*     */         }
/* 344 */         aLNPBnfSet.add(s1);
/*     */       }try {
/* 346 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 352 */       CError tError = new CError();
/* 353 */       tError.moduleName = "LNPBnfDB";
/* 354 */       tError.functionName = "executeQuery";
/* 355 */       tError.errorMessage = e.toString();
/* 356 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 358 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 361 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 365 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 371 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 375 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 380 */     return aLNPBnfSet;
/*     */   }
/*     */ 
/*     */   public LNPBnfSet query(int nStart, int nCount)
/*     */   {
/* 385 */     Statement stmt = null;
/* 386 */     ResultSet rs = null;
/* 387 */     LNPBnfSet aLNPBnfSet = new LNPBnfSet();
/*     */ 
/* 389 */     if (!this.mflag) {
/* 390 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 395 */       stmt = this.con.createStatement(1003, 1007);
/* 396 */       SQLString sqlObj = new SQLString("LNPBnf");
/* 397 */       LNPBnfSchema aSchema = getSchema();
/* 398 */       sqlObj.setSQL(5, aSchema);
/* 399 */       String sql = sqlObj.getSQL();
/*     */ 
/* 401 */       rs = stmt.executeQuery(sql);
/* 402 */       int i = 0;
/* 403 */       while (rs.next())
/*     */       {
/* 405 */         i++;
/*     */ 
/* 407 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 411 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 415 */         LNPBnfSchema s1 = new LNPBnfSchema();
/* 416 */         s1.setSchema(rs, i);
/* 417 */         aLNPBnfSet.add(s1);
/*     */       }try {
/* 419 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 425 */       CError tError = new CError();
/* 426 */       tError.moduleName = "LNPBnfDB";
/* 427 */       tError.functionName = "query";
/* 428 */       tError.errorMessage = e.toString();
/* 429 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 431 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 434 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 438 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 444 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 448 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 453 */     return aLNPBnfSet;
/*     */   }
/*     */ 
/*     */   public LNPBnfSet executeQuery(String sql, int nStart, int nCount)
/*     */   {
/* 458 */     Statement stmt = null;
/* 459 */     ResultSet rs = null;
/* 460 */     LNPBnfSet aLNPBnfSet = new LNPBnfSet();
/*     */ 
/* 462 */     if (!this.mflag) {
/* 463 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 468 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 470 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 471 */       int i = 0;
/* 472 */       while (rs.next())
/*     */       {
/* 474 */         i++;
/*     */ 
/* 476 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 480 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 484 */         LNPBnfSchema s1 = new LNPBnfSchema();
/* 485 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 488 */           CError tError = new CError();
/* 489 */           tError.moduleName = "LNPBnfDB";
/* 490 */           tError.functionName = "executeQuery";
/* 491 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/* 492 */           this.mErrors.addOneError(tError);
/*     */         }
/* 494 */         aLNPBnfSet.add(s1);
/*     */       }try {
/* 496 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 502 */       CError tError = new CError();
/* 503 */       tError.moduleName = "LNPBnfDB";
/* 504 */       tError.functionName = "executeQuery";
/* 505 */       tError.errorMessage = e.toString();
/* 506 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 508 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 511 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 515 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 521 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 525 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 530 */     return aLNPBnfSet;
/*     */   }
/*     */ 
/*     */   public boolean update(String strWherePart)
/*     */   {
/* 535 */     Statement stmt = null;
/*     */ 
/* 537 */     if (!this.mflag) {
/* 538 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 543 */       stmt = this.con.createStatement(1003, 1007);
/* 544 */       SQLString sqlObj = new SQLString("LNPBnf");
/* 545 */       LNPBnfSchema aSchema = getSchema();
/* 546 */       sqlObj.setSQL(2, aSchema);
/* 547 */       String sql = "update LNPBnf " + sqlObj.getUpdPart() + " where " + strWherePart;
/*     */ 
/* 549 */       int operCount = stmt.executeUpdate(sql);
/* 550 */       if (operCount == 0)
/*     */       {
/* 553 */         CError tError = new CError();
/* 554 */         tError.moduleName = "LNPBnfDB";
/* 555 */         tError.functionName = "update";
/* 556 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u7EDE\u044D\u62F7\u951F\uFFFD!";
/* 557 */         this.mErrors.addOneError(tError);
/*     */ 
/* 559 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 563 */             this.con.close();
/*     */           } catch (Exception localException1) {
/*     */           }
/*     */         }
/* 567 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 573 */       CError tError = new CError();
/* 574 */       tError.moduleName = "LNPBnfDB";
/* 575 */       tError.functionName = "update";
/* 576 */       tError.errorMessage = e.toString();
/* 577 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 579 */         stmt.close(); } catch (Exception localException2) {
/*     */       }
/* 581 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 585 */           this.con.close();
/*     */         } catch (Exception localException3) {
/*     */         }
/*     */       }
/* 589 */       return false;
/*     */     }
/*     */ 
/* 592 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 596 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException4) {
/*     */       }
/*     */     }
/* 601 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPBnfDB
 * JD-Core Version:    0.6.0
 */