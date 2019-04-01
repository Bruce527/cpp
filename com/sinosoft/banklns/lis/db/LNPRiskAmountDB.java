/*     */ package com.sinosoft.banklns.lis.db;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPRiskAmountSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPRiskAmountSet;
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
/*     */ public class LNPRiskAmountDB extends LNPRiskAmountSchema
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  23 */   private boolean mflag = false;
/*     */ 
/*  25 */   public CErrors mErrors = new CErrors();
/*     */ 
/*     */   public LNPRiskAmountDB(Connection tConnection)
/*     */   {
/*  30 */     this.con = tConnection;
/*  31 */     this.db = new DBOper(this.con, "LNPRiskAmount");
/*  32 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPRiskAmountDB()
/*     */   {
/*  37 */     this.con = null;
/*  38 */     this.db = new DBOper("LNPRiskAmount");
/*  39 */     this.mflag = false;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/*  45 */     LNPRiskAmountSchema tSchema = getSchema();
/*  46 */     if (!this.db.insert(tSchema))
/*     */     {
/*  49 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  50 */       CError tError = new CError();
/*  51 */       tError.moduleName = "LNPRiskAmountDB";
/*  52 */       tError.functionName = "insert";
/*  53 */       tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*  54 */       this.mErrors.addOneError(tError);
/*     */ 
/*  56 */       return false;
/*     */     }
/*     */ 
/*  59 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  64 */     LNPRiskAmountSchema tSchema = getSchema();
/*  65 */     if (!this.db.update(tSchema))
/*     */     {
/*  68 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  69 */       CError tError = new CError();
/*  70 */       tError.moduleName = "LNPRiskAmountDB";
/*  71 */       tError.functionName = "update";
/*  72 */       tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*  73 */       this.mErrors.addOneError(tError);
/*     */ 
/*  75 */       return false;
/*     */     }
/*     */ 
/*  78 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  83 */     LNPRiskAmountSchema tSchema = getSchema();
/*  84 */     if (!this.db.deleteSQL(tSchema))
/*     */     {
/*  87 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  88 */       CError tError = new CError();
/*  89 */       tError.moduleName = "LNPRiskAmountDB";
/*  90 */       tError.functionName = "deleteSQL";
/*  91 */       tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*  92 */       this.mErrors.addOneError(tError);
/*     */ 
/*  94 */       return false;
/*     */     }
/*     */ 
/*  97 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean delete()
/*     */   {
/* 102 */     LNPRiskAmountSchema tSchema = getSchema();
/* 103 */     if (!this.db.delete(tSchema))
/*     */     {
/* 106 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 107 */       CError tError = new CError();
/* 108 */       tError.moduleName = "LNPRiskAmountDB";
/* 109 */       tError.functionName = "delete";
/* 110 */       tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/* 111 */       this.mErrors.addOneError(tError);
/*     */ 
/* 113 */       return false;
/*     */     }
/*     */ 
/* 116 */     return true;
/*     */   }
/*     */ 
/*     */   public int getCount()
/*     */   {
/* 121 */     LNPRiskAmountSchema tSchema = getSchema();
/*     */ 
/* 123 */     int tCount = this.db.getCount(tSchema);
/* 124 */     if (tCount < 0)
/*     */     {
/* 127 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 128 */       CError tError = new CError();
/* 129 */       tError.moduleName = "LNPRiskAmountDB";
/* 130 */       tError.functionName = "getCount";
/* 131 */       tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/* 132 */       this.mErrors.addOneError(tError);
/*     */ 
/* 134 */       return -1;
/*     */     }
/*     */ 
/* 137 */     return tCount;
/*     */   }
/*     */ 
/*     */   public boolean getInfo()
/*     */   {
/* 142 */     Statement stmt = null;
/* 143 */     ResultSet rs = null;
/*     */ 
/* 145 */     if (!this.mflag) {
/* 146 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 151 */       stmt = this.con.createStatement(1003, 1007);
/* 152 */       SQLString sqlObj = new SQLString("LNPRiskAmount");
/* 153 */       LNPRiskAmountSchema aSchema = getSchema();
/* 154 */       sqlObj.setSQL(6, aSchema);
/* 155 */       String sql = sqlObj.getSQL();
/*     */ 
/* 157 */       rs = stmt.executeQuery(sql);
/* 158 */       int i = 0;
/* 159 */       if (rs.next())
/*     */       {
/* 161 */         i++;
/* 162 */         if (!setSchema(rs, i))
/*     */         {
/* 165 */           CError tError = new CError();
/* 166 */           tError.moduleName = "LNPRiskAmountDB";
/* 167 */           tError.functionName = "getInfo";
/* 168 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/* 169 */           this.mErrors.addOneError(tError);
/*     */           try {
/* 171 */             rs.close(); } catch (Exception localException1) {
/*     */           }try { stmt.close(); } catch (Exception localException2) {
/*     */           }
/* 174 */           if (!this.mflag)
/*     */           {
/*     */             try
/*     */             {
/* 178 */               this.con.close();
/*     */             } catch (Exception localException3) {
/*     */             }
/*     */           }
/* 182 */           return false;
/*     */         }
/*     */       }
/*     */       try {
/* 186 */         rs.close(); } catch (Exception localException4) {
/*     */       }try { stmt.close(); } catch (Exception localException5) {
/*     */       }
/* 189 */       if (i == 0)
/*     */       {
/* 192 */         CError tError = new CError();
/* 193 */         tError.moduleName = "LNPRiskAmountDB";
/* 194 */         tError.functionName = "getInfo";
/* 195 */         tError.errorMessage = "\u672A\u627E\u5230\u76F8\u5173\u6570\u636E!";
/* 196 */         this.mErrors.addOneError(tError);
/*     */ 
/* 198 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 202 */             this.con.close();
/*     */           } catch (Exception localException6) {
/*     */           }
/*     */         }
/* 206 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 212 */       CError tError = new CError();
/* 213 */       tError.moduleName = "LNPRiskAmountDB";
/* 214 */       tError.functionName = "getInfo";
/* 215 */       tError.errorMessage = e.toString();
/* 216 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 218 */         rs.close(); } catch (Exception localException7) {
/*     */       }try { stmt.close(); } catch (Exception localException8) {
/*     */       }
/* 221 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 225 */           this.con.close();
/*     */         } catch (Exception localException9) {
/*     */         }
/*     */       }
/* 229 */       return false;
/*     */     }
/*     */ 
/* 232 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 236 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException10) {
/*     */       }
/*     */     }
/* 241 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPRiskAmountSet query()
/*     */   {
/* 246 */     Statement stmt = null;
/* 247 */     ResultSet rs = null;
/* 248 */     LNPRiskAmountSet aLNPRiskAmountSet = new LNPRiskAmountSet();
/*     */ 
/* 250 */     if (!this.mflag) {
/* 251 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 256 */       stmt = this.con.createStatement(1003, 1007);
/* 257 */       SQLString sqlObj = new SQLString("LNPRiskAmount");
/* 258 */       LNPRiskAmountSchema aSchema = getSchema();
/* 259 */       sqlObj.setSQL(5, aSchema);
/* 260 */       String sql = sqlObj.getSQL();
/*     */ 
/* 262 */       rs = stmt.executeQuery(sql);
/* 263 */       int i = 0;
/* 264 */       while (rs.next())
/*     */       {
/* 266 */         i++;
/* 267 */         LNPRiskAmountSchema s1 = new LNPRiskAmountSchema();
/* 268 */         s1.setSchema(rs, i);
/* 269 */         aLNPRiskAmountSet.add(s1);
/*     */       }try {
/* 271 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 277 */       CError tError = new CError();
/* 278 */       tError.moduleName = "LNPRiskAmountDB";
/* 279 */       tError.functionName = "query";
/* 280 */       tError.errorMessage = e.toString();
/* 281 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 283 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 286 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 290 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 296 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 300 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 305 */     return aLNPRiskAmountSet;
/*     */   }
/*     */ 
/*     */   public LNPRiskAmountSet executeQuery(String sql)
/*     */   {
/* 310 */     Statement stmt = null;
/* 311 */     ResultSet rs = null;
/* 312 */     LNPRiskAmountSet aLNPRiskAmountSet = new LNPRiskAmountSet();
/*     */ 
/* 314 */     if (!this.mflag) {
/* 315 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 320 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 322 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 323 */       int i = 0;
/* 324 */       while (rs.next())
/*     */       {
/* 326 */         i++;
/* 327 */         LNPRiskAmountSchema s1 = new LNPRiskAmountSchema();
/* 328 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 331 */           CError tError = new CError();
/* 332 */           tError.moduleName = "LNPRiskAmountDB";
/* 333 */           tError.functionName = "executeQuery";
/* 334 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/* 335 */           this.mErrors.addOneError(tError);
/*     */         }
/* 337 */         aLNPRiskAmountSet.add(s1);
/*     */       }try {
/* 339 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 345 */       CError tError = new CError();
/* 346 */       tError.moduleName = "LNPRiskAmountDB";
/* 347 */       tError.functionName = "executeQuery";
/* 348 */       tError.errorMessage = e.toString();
/* 349 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 351 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 354 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 358 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 364 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 368 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 373 */     return aLNPRiskAmountSet;
/*     */   }
/*     */ 
/*     */   public LNPRiskAmountSet query(int nStart, int nCount)
/*     */   {
/* 378 */     Statement stmt = null;
/* 379 */     ResultSet rs = null;
/* 380 */     LNPRiskAmountSet aLNPRiskAmountSet = new LNPRiskAmountSet();
/*     */ 
/* 382 */     if (!this.mflag) {
/* 383 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 388 */       stmt = this.con.createStatement(1003, 1007);
/* 389 */       SQLString sqlObj = new SQLString("LNPRiskAmount");
/* 390 */       LNPRiskAmountSchema aSchema = getSchema();
/* 391 */       sqlObj.setSQL(5, aSchema);
/* 392 */       String sql = sqlObj.getSQL();
/*     */ 
/* 394 */       rs = stmt.executeQuery(sql);
/* 395 */       int i = 0;
/* 396 */       while (rs.next())
/*     */       {
/* 398 */         i++;
/*     */ 
/* 400 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 404 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 408 */         LNPRiskAmountSchema s1 = new LNPRiskAmountSchema();
/* 409 */         s1.setSchema(rs, i);
/* 410 */         aLNPRiskAmountSet.add(s1);
/*     */       }try {
/* 412 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 418 */       CError tError = new CError();
/* 419 */       tError.moduleName = "LNPRiskAmountDB";
/* 420 */       tError.functionName = "query";
/* 421 */       tError.errorMessage = e.toString();
/* 422 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 424 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 427 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 431 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 437 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 441 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 446 */     return aLNPRiskAmountSet;
/*     */   }
/*     */ 
/*     */   public LNPRiskAmountSet executeQuery(String sql, int nStart, int nCount)
/*     */   {
/* 451 */     Statement stmt = null;
/* 452 */     ResultSet rs = null;
/* 453 */     LNPRiskAmountSet aLNPRiskAmountSet = new LNPRiskAmountSet();
/*     */ 
/* 455 */     if (!this.mflag) {
/* 456 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 461 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 463 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 464 */       int i = 0;
/* 465 */       while (rs.next())
/*     */       {
/* 467 */         i++;
/*     */ 
/* 469 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 473 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 477 */         LNPRiskAmountSchema s1 = new LNPRiskAmountSchema();
/* 478 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 481 */           CError tError = new CError();
/* 482 */           tError.moduleName = "LNPRiskAmountDB";
/* 483 */           tError.functionName = "executeQuery";
/* 484 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/* 485 */           this.mErrors.addOneError(tError);
/*     */         }
/* 487 */         aLNPRiskAmountSet.add(s1);
/*     */       }try {
/* 489 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 495 */       CError tError = new CError();
/* 496 */       tError.moduleName = "LNPRiskAmountDB";
/* 497 */       tError.functionName = "executeQuery";
/* 498 */       tError.errorMessage = e.toString();
/* 499 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 501 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 504 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 508 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 514 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 518 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 523 */     return aLNPRiskAmountSet;
/*     */   }
/*     */ 
/*     */   public boolean update(String strWherePart)
/*     */   {
/* 528 */     Statement stmt = null;
/*     */ 
/* 530 */     if (!this.mflag) {
/* 531 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 536 */       stmt = this.con.createStatement(1003, 1007);
/* 537 */       SQLString sqlObj = new SQLString("LNPRiskAmount");
/* 538 */       LNPRiskAmountSchema aSchema = getSchema();
/* 539 */       sqlObj.setSQL(2, aSchema);
/* 540 */       String sql = "update LNPRiskAmount " + sqlObj.getUpdPart() + " where " + strWherePart;
/*     */ 
/* 542 */       int operCount = stmt.executeUpdate(sql);
/* 543 */       if (operCount == 0)
/*     */       {
/* 546 */         CError tError = new CError();
/* 547 */         tError.moduleName = "LNPRiskAmountDB";
/* 548 */         tError.functionName = "update";
/* 549 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/* 550 */         this.mErrors.addOneError(tError);
/*     */ 
/* 552 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 556 */             this.con.close();
/*     */           } catch (Exception localException1) {
/*     */           }
/*     */         }
/* 560 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 566 */       CError tError = new CError();
/* 567 */       tError.moduleName = "LNPRiskAmountDB";
/* 568 */       tError.functionName = "update";
/* 569 */       tError.errorMessage = e.toString();
/* 570 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 572 */         stmt.close(); } catch (Exception localException2) {
/*     */       }
/* 574 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 578 */           this.con.close();
/*     */         } catch (Exception localException3) {
/*     */         }
/*     */       }
/* 582 */       return false;
/*     */     }
/*     */ 
/* 585 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 589 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException4) {
/*     */       }
/*     */     }
/* 594 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPRiskAmountDB
 * JD-Core Version:    0.6.0
 */