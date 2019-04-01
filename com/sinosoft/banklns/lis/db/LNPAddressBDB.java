/*     */ package com.sinosoft.banklns.lis.db;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPAddressBSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPAddressBSet;
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
/*     */ public class LNPAddressBDB extends LNPAddressBSchema
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*  23 */   public CErrors mErrors = new CErrors();
/*     */ 
/*     */   public LNPAddressBDB(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPAddressB");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPAddressBDB()
/*     */   {
/*  35 */     this.con = null;
/*  36 */     this.db = new DBOper("LNPAddressB");
/*  37 */     this.mflag = false;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/*  42 */     LNPAddressBSchema tSchema = getSchema();
/*  43 */     if (!this.db.insert(tSchema))
/*     */     {
/*  45 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  46 */       CError tError = new CError();
/*  47 */       tError.moduleName = "LNPAddressBDB";
/*  48 */       tError.functionName = "insert";
/*  49 */       tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*  50 */       this.mErrors.addOneError(tError);
/*     */ 
/*  52 */       return false;
/*     */     }
/*     */ 
/*  55 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  60 */     LNPAddressBSchema tSchema = getSchema();
/*  61 */     if (!this.db.update(tSchema))
/*     */     {
/*  64 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  65 */       CError tError = new CError();
/*  66 */       tError.moduleName = "LNPAddressBDB";
/*  67 */       tError.functionName = "update";
/*  68 */       tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*  69 */       this.mErrors.addOneError(tError);
/*     */ 
/*  71 */       return false;
/*     */     }
/*     */ 
/*  74 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  79 */     LNPAddressBSchema tSchema = getSchema();
/*  80 */     if (!this.db.deleteSQL(tSchema))
/*     */     {
/*  83 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  84 */       CError tError = new CError();
/*  85 */       tError.moduleName = "LNPAddressBDB";
/*  86 */       tError.functionName = "deleteSQL";
/*  87 */       tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*  88 */       this.mErrors.addOneError(tError);
/*     */ 
/*  90 */       return false;
/*     */     }
/*     */ 
/*  93 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean delete()
/*     */   {
/*  98 */     LNPAddressBSchema tSchema = getSchema();
/*  99 */     if (!this.db.delete(tSchema))
/*     */     {
/* 102 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 103 */       CError tError = new CError();
/* 104 */       tError.moduleName = "LNPAddressBDB";
/* 105 */       tError.functionName = "delete";
/* 106 */       tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/* 107 */       this.mErrors.addOneError(tError);
/*     */ 
/* 109 */       return false;
/*     */     }
/*     */ 
/* 112 */     return true;
/*     */   }
/*     */ 
/*     */   public int getCount()
/*     */   {
/* 117 */     LNPAddressBSchema tSchema = getSchema();
/*     */ 
/* 119 */     int tCount = this.db.getCount(tSchema);
/* 120 */     if (tCount < 0)
/*     */     {
/* 123 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 124 */       CError tError = new CError();
/* 125 */       tError.moduleName = "LNPAddressBDB";
/* 126 */       tError.functionName = "getCount";
/* 127 */       tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/* 128 */       this.mErrors.addOneError(tError);
/*     */ 
/* 130 */       return -1;
/*     */     }
/*     */ 
/* 133 */     return tCount;
/*     */   }
/*     */ 
/*     */   public boolean getInfo()
/*     */   {
/* 138 */     Statement stmt = null;
/* 139 */     ResultSet rs = null;
/*     */ 
/* 141 */     if (!this.mflag) {
/* 142 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 147 */       stmt = this.con.createStatement(1003, 1007);
/* 148 */       SQLString sqlObj = new SQLString("LNPAddressB");
/* 149 */       LNPAddressBSchema aSchema = getSchema();
/* 150 */       sqlObj.setSQL(6, aSchema);
/* 151 */       String sql = sqlObj.getSQL();
/*     */ 
/* 153 */       rs = stmt.executeQuery(sql);
/* 154 */       int i = 0;
/* 155 */       if (rs.next())
/*     */       {
/* 157 */         i++;
/* 158 */         if (!setSchema(rs, i))
/*     */         {
/* 161 */           CError tError = new CError();
/* 162 */           tError.moduleName = "LNPAddressBDB";
/* 163 */           tError.functionName = "getInfo";
/* 164 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/* 165 */           this.mErrors.addOneError(tError);
/*     */           try {
/* 167 */             rs.close(); } catch (Exception localException1) {
/*     */           }try { stmt.close(); } catch (Exception localException2) {
/*     */           }
/* 170 */           if (!this.mflag)
/*     */           {
/*     */             try
/*     */             {
/* 174 */               this.con.close();
/*     */             } catch (Exception localException3) {
/*     */             }
/*     */           }
/* 178 */           return false;
/*     */         }
/*     */       }
/*     */       try {
/* 182 */         rs.close(); } catch (Exception localException4) {
/*     */       }try { stmt.close(); } catch (Exception localException5) {
/*     */       }
/* 185 */       if (i == 0)
/*     */       {
/* 188 */         CError tError = new CError();
/* 189 */         tError.moduleName = "LNPAddressBDB";
/* 190 */         tError.functionName = "getInfo";
/* 191 */         tError.errorMessage = "\u672A\u627E\u5230\u76F8\u5173\u6570\u636E!";
/* 192 */         this.mErrors.addOneError(tError);
/*     */ 
/* 194 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 198 */             this.con.close();
/*     */           } catch (Exception localException6) {
/*     */           }
/*     */         }
/* 202 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 208 */       CError tError = new CError();
/* 209 */       tError.moduleName = "LNPAddressBDB";
/* 210 */       tError.functionName = "getInfo";
/* 211 */       tError.errorMessage = e.toString();
/* 212 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 214 */         rs.close(); } catch (Exception localException7) {
/*     */       }try { stmt.close(); } catch (Exception localException8) {
/*     */       }
/* 217 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 221 */           this.con.close();
/*     */         } catch (Exception localException9) {
/*     */         }
/*     */       }
/* 225 */       return false;
/*     */     }
/*     */ 
/* 228 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 232 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException10) {
/*     */       }
/*     */     }
/* 237 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPAddressBSet query()
/*     */   {
/* 242 */     Statement stmt = null;
/* 243 */     ResultSet rs = null;
/* 244 */     LNPAddressBSet aLNPAddressBSet = new LNPAddressBSet();
/*     */ 
/* 246 */     if (!this.mflag) {
/* 247 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 252 */       stmt = this.con.createStatement(1003, 1007);
/* 253 */       SQLString sqlObj = new SQLString("LNPAddressB");
/* 254 */       LNPAddressBSchema aSchema = getSchema();
/* 255 */       sqlObj.setSQL(5, aSchema);
/* 256 */       String sql = sqlObj.getSQL();
/*     */ 
/* 258 */       rs = stmt.executeQuery(sql);
/* 259 */       int i = 0;
/* 260 */       while (rs.next())
/*     */       {
/* 262 */         i++;
/* 263 */         LNPAddressBSchema s1 = new LNPAddressBSchema();
/* 264 */         s1.setSchema(rs, i);
/* 265 */         aLNPAddressBSet.add(s1);
/*     */       }try {
/* 267 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 273 */       CError tError = new CError();
/* 274 */       tError.moduleName = "LNPAddressBDB";
/* 275 */       tError.functionName = "query";
/* 276 */       tError.errorMessage = e.toString();
/* 277 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 279 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 282 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 286 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 292 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 296 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 301 */     return aLNPAddressBSet;
/*     */   }
/*     */ 
/*     */   public LNPAddressBSet executeQuery(String sql)
/*     */   {
/* 306 */     Statement stmt = null;
/* 307 */     ResultSet rs = null;
/* 308 */     LNPAddressBSet aLNPAddressBSet = new LNPAddressBSet();
/*     */ 
/* 310 */     if (!this.mflag) {
/* 311 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 316 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 318 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 319 */       int i = 0;
/* 320 */       while (rs.next())
/*     */       {
/* 322 */         i++;
/* 323 */         LNPAddressBSchema s1 = new LNPAddressBSchema();
/* 324 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 327 */           CError tError = new CError();
/* 328 */           tError.moduleName = "LNPAddressBDB";
/* 329 */           tError.functionName = "executeQuery";
/* 330 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/* 331 */           this.mErrors.addOneError(tError);
/*     */         }
/* 333 */         aLNPAddressBSet.add(s1);
/*     */       }try {
/* 335 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 341 */       CError tError = new CError();
/* 342 */       tError.moduleName = "LNPAddressBDB";
/* 343 */       tError.functionName = "executeQuery";
/* 344 */       tError.errorMessage = e.toString();
/* 345 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 347 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 350 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 354 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 360 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 364 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 369 */     return aLNPAddressBSet;
/*     */   }
/*     */ 
/*     */   public LNPAddressBSet query(int nStart, int nCount)
/*     */   {
/* 374 */     Statement stmt = null;
/* 375 */     ResultSet rs = null;
/* 376 */     LNPAddressBSet aLNPAddressBSet = new LNPAddressBSet();
/*     */ 
/* 378 */     if (!this.mflag) {
/* 379 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 384 */       stmt = this.con.createStatement(1003, 1007);
/* 385 */       SQLString sqlObj = new SQLString("LNPAddressB");
/* 386 */       LNPAddressBSchema aSchema = getSchema();
/* 387 */       sqlObj.setSQL(5, aSchema);
/* 388 */       String sql = sqlObj.getSQL();
/*     */ 
/* 390 */       rs = stmt.executeQuery(sql);
/* 391 */       int i = 0;
/* 392 */       while (rs.next())
/*     */       {
/* 394 */         i++;
/*     */ 
/* 396 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 400 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 404 */         LNPAddressBSchema s1 = new LNPAddressBSchema();
/* 405 */         s1.setSchema(rs, i);
/* 406 */         aLNPAddressBSet.add(s1);
/*     */       }try {
/* 408 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 414 */       CError tError = new CError();
/* 415 */       tError.moduleName = "LNPAddressBDB";
/* 416 */       tError.functionName = "query";
/* 417 */       tError.errorMessage = e.toString();
/* 418 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 420 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 423 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 427 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 433 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 437 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 442 */     return aLNPAddressBSet;
/*     */   }
/*     */ 
/*     */   public LNPAddressBSet executeQuery(String sql, int nStart, int nCount)
/*     */   {
/* 447 */     Statement stmt = null;
/* 448 */     ResultSet rs = null;
/* 449 */     LNPAddressBSet aLNPAddressBSet = new LNPAddressBSet();
/*     */ 
/* 451 */     if (!this.mflag) {
/* 452 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 457 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 459 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 460 */       int i = 0;
/* 461 */       while (rs.next())
/*     */       {
/* 463 */         i++;
/*     */ 
/* 465 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 469 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 473 */         LNPAddressBSchema s1 = new LNPAddressBSchema();
/* 474 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 477 */           CError tError = new CError();
/* 478 */           tError.moduleName = "LNPAddressBDB";
/* 479 */           tError.functionName = "executeQuery";
/* 480 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/* 481 */           this.mErrors.addOneError(tError);
/*     */         }
/* 483 */         aLNPAddressBSet.add(s1);
/*     */       }try {
/* 485 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close(); } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 490 */       CError tError = new CError();
/* 491 */       tError.moduleName = "LNPAddressBDB";
/* 492 */       tError.functionName = "executeQuery";
/* 493 */       tError.errorMessage = e.toString();
/* 494 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 496 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 499 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 503 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 509 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 513 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 518 */     return aLNPAddressBSet;
/*     */   }
/*     */ 
/*     */   public boolean update(String strWherePart)
/*     */   {
/* 523 */     Statement stmt = null;
/*     */ 
/* 525 */     if (!this.mflag) {
/* 526 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 531 */       stmt = this.con.createStatement(1003, 1007);
/* 532 */       SQLString sqlObj = new SQLString("LNPAddressB");
/* 533 */       LNPAddressBSchema aSchema = getSchema();
/* 534 */       sqlObj.setSQL(2, aSchema);
/* 535 */       String sql = "update LNPAddressB " + sqlObj.getUpdPart() + " where " + strWherePart;
/*     */ 
/* 537 */       int operCount = stmt.executeUpdate(sql);
/* 538 */       if (operCount == 0)
/*     */       {
/* 540 */         CError tError = new CError();
/* 541 */         tError.moduleName = "LNPAddressBDB";
/* 542 */         tError.functionName = "update";
/* 543 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/* 544 */         this.mErrors.addOneError(tError);
/*     */ 
/* 546 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 550 */             this.con.close();
/*     */           } catch (Exception localException1) {
/*     */           }
/*     */         }
/* 554 */         return false;
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 559 */       CError tError = new CError();
/* 560 */       tError.moduleName = "LNPAddressBDB";
/* 561 */       tError.functionName = "update";
/* 562 */       tError.errorMessage = e.toString();
/* 563 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 565 */         stmt.close(); } catch (Exception localException2) {
/*     */       }
/* 567 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 571 */           this.con.close();
/*     */         } catch (Exception localException3) {
/*     */         }
/*     */       }
/* 575 */       return false;
/*     */     }
/* 577 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 581 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException4) {
/*     */       }
/*     */     }
/* 586 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPAddressBDB
 * JD-Core Version:    0.6.0
 */