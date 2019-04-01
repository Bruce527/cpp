/*     */ package com.sinosoft.map.lis.db;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MCodeSchema;
/*     */ import com.sinosoft.map.lis.vschema.MCodeSet;
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
/*     */ public class MCodeDB extends MCodeSchema
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*  23 */   public CErrors mErrors = new CErrors();
/*     */ 
/*  26 */   private ResultSet mResultSet = null;
/*  27 */   private Statement mStatement = null;
/*     */ 
/*     */   public MCodeDB(Connection tConnection)
/*     */   {
/*  31 */     this.con = tConnection;
/*  32 */     this.db = new DBOper(this.con, "MCode");
/*  33 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MCodeDB()
/*     */   {
/*  38 */     this.con = null;
/*  39 */     this.db = new DBOper("MCode");
/*  40 */     this.mflag = false;
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  46 */     MCodeSchema tSchema = getSchema();
/*  47 */     if (this.db.deleteSQL(tSchema))
/*     */     {
/*  49 */       return true;
/*     */     }
/*     */ 
/*  54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*  55 */     CError tError = new CError();
/*  56 */     tError.moduleName = "MCodeDB";
/*  57 */     tError.functionName = "deleteSQL";
/*  58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*  59 */     this.mErrors.addOneError(tError);
/*  60 */     return false;
/*     */   }
/*     */ 
/*     */   public int getCount()
/*     */   {
/*  66 */     MCodeSchema tSchema = getSchema();
/*     */ 
/*  68 */     int tCount = this.db.getCount(tSchema);
/*  69 */     if (tCount < 0)
/*     */     {
/*  72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  73 */       CError tError = new CError();
/*  74 */       tError.moduleName = "MCodeDB";
/*  75 */       tError.functionName = "getCount";
/*  76 */       tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*  77 */       this.mErrors.addOneError(tError);
/*     */ 
/*  79 */       return -1;
/*     */     }
/*     */ 
/*  82 */     return tCount;
/*     */   }
/*     */ 
/*     */   public boolean delete()
/*     */   {
/*  87 */     PreparedStatement pstmt = null;
/*     */ 
/*  89 */     if (!this.mflag) {
/*  90 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  95 */       pstmt = this.con.prepareStatement("DELETE FROM MCode WHERE ");
/*  96 */       pstmt.executeUpdate();
/*  97 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 100 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 101 */       CError tError = new CError();
/* 102 */       tError.moduleName = "MCodeDB";
/* 103 */       tError.functionName = "delete()";
/* 104 */       tError.errorMessage = ex.toString();
/* 105 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 108 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 111 */       if (!this.mflag)
/*     */         try {
/* 113 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 117 */       return false;
/*     */     }
/*     */ 
/* 120 */     if (!this.mflag)
/*     */       try {
/* 122 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 126 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 131 */     PreparedStatement pstmt = null;
/*     */ 
/* 133 */     if (!this.mflag) {
/* 134 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 139 */       pstmt = this.con.prepareStatement("UPDATE MCode SET  CodeType = ? , Code = ? , CodeName = ? , CodeAlias = ? , ComCode = ? , OtherSign = ? , CodeOrder = ? WHERE ");
/*     */ 
/* 141 */       pstmt.executeUpdate();
/* 142 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 145 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 146 */       CError tError = new CError();
/* 147 */       tError.moduleName = "MCodeDB";
/* 148 */       tError.functionName = "update()";
/* 149 */       tError.errorMessage = ex.toString();
/* 150 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 153 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 156 */       if (!this.mflag)
/*     */         try {
/* 158 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 162 */       return false;
/*     */     }
/*     */ 
/* 165 */     if (!this.mflag)
/*     */       try {
/* 167 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 171 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 176 */     PreparedStatement pstmt = null;
/*     */ 
/* 178 */     if (!this.mflag) {
/* 179 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 184 */       pstmt = this.con.prepareStatement("INSERT INTO MCode VALUES( ? , ? , ? , ? , ? , ? , ?)");
/*     */ 
/* 186 */       pstmt.executeUpdate();
/* 187 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 190 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 191 */       CError tError = new CError();
/* 192 */       tError.moduleName = "MCodeDB";
/* 193 */       tError.functionName = "insert()";
/* 194 */       tError.errorMessage = ex.toString();
/* 195 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 198 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 201 */       if (!this.mflag)
/*     */         try {
/* 203 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 207 */       return false;
/*     */     }
/*     */ 
/* 210 */     if (!this.mflag)
/*     */       try {
/* 212 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 216 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean getInfo()
/*     */   {
/* 221 */     PreparedStatement pstmt = null;
/* 222 */     ResultSet rs = null;
/*     */ 
/* 224 */     if (!this.mflag) {
/* 225 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 230 */       pstmt = this.con.prepareStatement("SELECT * FROM MCode WHERE ", 
/* 231 */         1003, 1007);
/* 232 */       rs = pstmt.executeQuery();
/* 233 */       int i = 0;
/* 234 */       if (rs.next())
/*     */       {
/* 236 */         i++;
/* 237 */         if (!setSchema(rs, i))
/*     */         {
/* 240 */           CError tError = new CError();
/* 241 */           tError.moduleName = "MCodeDB";
/* 242 */           tError.functionName = "getInfo";
/* 243 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/* 244 */           this.mErrors.addOneError(tError);
/*     */           try {
/* 246 */             rs.close(); } catch (Exception localException1) {
/*     */           }try { pstmt.close(); } catch (Exception localException2) {
/*     */           }
/* 249 */           if (!this.mflag)
/*     */           {
/*     */             try
/*     */             {
/* 253 */               this.con.close();
/*     */             } catch (Exception localException3) {
/*     */             }
/*     */           }
/* 257 */           return false;
/*     */         }
/*     */       }
/*     */       try {
/* 261 */         rs.close(); } catch (Exception localException4) {
/*     */       }try { pstmt.close(); } catch (Exception localException5) {
/*     */       }
/* 264 */       if (i == 0)
/*     */       {
/* 266 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 270 */             this.con.close();
/*     */           } catch (Exception localException6) {
/*     */           }
/*     */         }
/* 274 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 280 */       CError tError = new CError();
/* 281 */       tError.moduleName = "MCodeDB";
/* 282 */       tError.functionName = "getInfo";
/* 283 */       tError.errorMessage = e.toString();
/* 284 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 286 */         rs.close(); } catch (Exception localException7) {
/*     */       }try { pstmt.close(); } catch (Exception localException8) {
/*     */       }
/* 289 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 293 */           this.con.close();
/*     */         } catch (Exception localException9) {
/*     */         }
/*     */       }
/* 297 */       return false;
/*     */     }
/*     */ 
/* 300 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 304 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException10) {
/*     */       }
/*     */     }
/* 309 */     return true;
/*     */   }
/*     */ 
/*     */   public MCodeSet query()
/*     */   {
/* 314 */     Statement stmt = null;
/* 315 */     ResultSet rs = null;
/* 316 */     MCodeSet aMCodeSet = new MCodeSet();
/*     */ 
/* 318 */     if (!this.mflag) {
/* 319 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 324 */       stmt = this.con.createStatement(1003, 1007);
/* 325 */       SQLString sqlObj = new SQLString("MCode");
/* 326 */       MCodeSchema aSchema = getSchema();
/* 327 */       sqlObj.setSQL(5, aSchema);
/* 328 */       String sql = sqlObj.getSQL();
/*     */ 
/* 330 */       rs = stmt.executeQuery(sql);
/* 331 */       int i = 0;
/* 332 */       while (rs.next())
/*     */       {
/* 334 */         i++;
/* 335 */         MCodeSchema s1 = new MCodeSchema();
/* 336 */         s1.setSchema(rs, i);
/* 337 */         aMCodeSet.add(s1);
/*     */       }try {
/* 339 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 345 */       CError tError = new CError();
/* 346 */       tError.moduleName = "MCodeDB";
/* 347 */       tError.functionName = "query";
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
/* 373 */     return aMCodeSet;
/*     */   }
/*     */ 
/*     */   public MCodeSet executeQuery(String sql)
/*     */   {
/* 378 */     Statement stmt = null;
/* 379 */     ResultSet rs = null;
/* 380 */     MCodeSet aMCodeSet = new MCodeSet();
/*     */ 
/* 382 */     if (!this.mflag) {
/* 383 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 388 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 390 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 391 */       int i = 0;
/* 392 */       while (rs.next())
/*     */       {
/* 394 */         i++;
/* 395 */         MCodeSchema s1 = new MCodeSchema();
/* 396 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 399 */           CError tError = new CError();
/* 400 */           tError.moduleName = "MCodeDB";
/* 401 */           tError.functionName = "executeQuery";
/* 402 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/* 403 */           this.mErrors.addOneError(tError);
/*     */         }
/* 405 */         aMCodeSet.add(s1);
/*     */       }try {
/* 407 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 413 */       CError tError = new CError();
/* 414 */       tError.moduleName = "MCodeDB";
/* 415 */       tError.functionName = "executeQuery";
/* 416 */       tError.errorMessage = e.toString();
/* 417 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 419 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 422 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 426 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 432 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 436 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 441 */     return aMCodeSet;
/*     */   }
/*     */ 
/*     */   public MCodeSet query(int nStart, int nCount)
/*     */   {
/* 446 */     Statement stmt = null;
/* 447 */     ResultSet rs = null;
/* 448 */     MCodeSet aMCodeSet = new MCodeSet();
/*     */ 
/* 450 */     if (!this.mflag) {
/* 451 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 456 */       stmt = this.con.createStatement(1003, 1007);
/* 457 */       SQLString sqlObj = new SQLString("MCode");
/* 458 */       MCodeSchema aSchema = getSchema();
/* 459 */       sqlObj.setSQL(5, aSchema);
/* 460 */       String sql = sqlObj.getSQL();
/*     */ 
/* 462 */       rs = stmt.executeQuery(sql);
/* 463 */       int i = 0;
/* 464 */       while (rs.next())
/*     */       {
/* 466 */         i++;
/*     */ 
/* 468 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 472 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 476 */         MCodeSchema s1 = new MCodeSchema();
/* 477 */         s1.setSchema(rs, i);
/* 478 */         aMCodeSet.add(s1);
/*     */       }try {
/* 480 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 486 */       CError tError = new CError();
/* 487 */       tError.moduleName = "MCodeDB";
/* 488 */       tError.functionName = "query";
/* 489 */       tError.errorMessage = e.toString();
/* 490 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 492 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 495 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 499 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 505 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 509 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 514 */     return aMCodeSet;
/*     */   }
/*     */ 
/*     */   public MCodeSet executeQuery(String sql, int nStart, int nCount)
/*     */   {
/* 519 */     Statement stmt = null;
/* 520 */     ResultSet rs = null;
/* 521 */     MCodeSet aMCodeSet = new MCodeSet();
/*     */ 
/* 523 */     if (!this.mflag) {
/* 524 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 529 */       stmt = this.con.createStatement(1003, 1007);
/*     */ 
/* 531 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 532 */       int i = 0;
/* 533 */       while (rs.next())
/*     */       {
/* 535 */         i++;
/*     */ 
/* 537 */         if (i < nStart)
/*     */         {
/*     */           continue;
/*     */         }
/* 541 */         if (i >= nStart + nCount)
/*     */         {
/*     */           break;
/*     */         }
/* 545 */         MCodeSchema s1 = new MCodeSchema();
/* 546 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 549 */           CError tError = new CError();
/* 550 */           tError.moduleName = "MCodeDB";
/* 551 */           tError.functionName = "executeQuery";
/* 552 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/* 553 */           this.mErrors.addOneError(tError);
/*     */         }
/* 555 */         aMCodeSet.add(s1);
/*     */       }try {
/* 557 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 563 */       CError tError = new CError();
/* 564 */       tError.moduleName = "MCodeDB";
/* 565 */       tError.functionName = "executeQuery";
/* 566 */       tError.errorMessage = e.toString();
/* 567 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 569 */         rs.close(); } catch (Exception localException3) {
/*     */       }try { stmt.close(); } catch (Exception localException4) {
/*     */       }
/* 572 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 576 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException5) {
/*     */         }
/*     */       }
/*     */     }
/* 582 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 586 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/*     */     }
/* 591 */     return aMCodeSet;
/*     */   }
/*     */ 
/*     */   public boolean update(String strWherePart)
/*     */   {
/* 596 */     Statement stmt = null;
/*     */ 
/* 598 */     if (!this.mflag) {
/* 599 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 604 */       stmt = this.con.createStatement(1003, 1007);
/* 605 */       SQLString sqlObj = new SQLString("MCode");
/* 606 */       MCodeSchema aSchema = getSchema();
/* 607 */       sqlObj.setSQL(2, aSchema);
/* 608 */       String sql = "update MCode " + sqlObj.getUpdPart() + " where " + strWherePart;
/*     */ 
/* 610 */       int operCount = stmt.executeUpdate(sql);
/* 611 */       if (operCount == 0)
/*     */       {
/* 614 */         CError tError = new CError();
/* 615 */         tError.moduleName = "MCodeDB";
/* 616 */         tError.functionName = "update";
/* 617 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/* 618 */         this.mErrors.addOneError(tError);
/*     */ 
/* 620 */         if (!this.mflag)
/*     */         {
/*     */           try
/*     */           {
/* 624 */             this.con.close();
/*     */           } catch (Exception localException1) {
/*     */           }
/*     */         }
/* 628 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 634 */       CError tError = new CError();
/* 635 */       tError.moduleName = "MCodeDB";
/* 636 */       tError.functionName = "update";
/* 637 */       tError.errorMessage = e.toString();
/* 638 */       this.mErrors.addOneError(tError);
/*     */       try {
/* 640 */         stmt.close(); } catch (Exception localException2) {
/*     */       }
/* 642 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 646 */           this.con.close();
/*     */         } catch (Exception localException3) {
/*     */         }
/*     */       }
/* 650 */       return false;
/*     */     }
/*     */ 
/* 653 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 657 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException4) {
/*     */       }
/*     */     }
/* 662 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean prepareData(String strSQL)
/*     */   {
/* 668 */     if (this.mResultSet != null)
/*     */     {
/* 671 */       CError tError = new CError();
/* 672 */       tError.moduleName = "MCodeDB";
/* 673 */       tError.functionName = "prepareData";
/* 674 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/* 675 */       this.mErrors.addOneError(tError);
/* 676 */       return false;
/*     */     }
/*     */ 
/* 679 */     if (!this.mflag)
/*     */     {
/* 681 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */     try
/*     */     {
/* 685 */       this.mStatement = this.con.createStatement(1003, 1007);
/* 686 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 691 */       CError tError = new CError();
/* 692 */       tError.moduleName = "MCodeDB";
/* 693 */       tError.functionName = "prepareData";
/* 694 */       tError.errorMessage = e.toString();
/* 695 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 698 */         this.mResultSet.close();
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 704 */         this.mStatement.close();
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 708 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 712 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 717 */       return false;
/*     */     }
/*     */ 
/* 720 */     if (!this.mflag)
/*     */     {
/*     */       try
/*     */       {
/* 724 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException4) {
/*     */       }
/*     */     }
/* 729 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean hasMoreData()
/*     */   {
/* 735 */     boolean flag = true;
/* 736 */     if (this.mResultSet == null)
/*     */     {
/* 738 */       CError tError = new CError();
/* 739 */       tError.moduleName = "MCodeDB";
/* 740 */       tError.functionName = "hasMoreData";
/* 741 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 742 */       this.mErrors.addOneError(tError);
/* 743 */       return false;
/*     */     }
/*     */     try
/*     */     {
/* 747 */       flag = this.mResultSet.next();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 751 */       CError tError = new CError();
/* 752 */       tError.moduleName = "MCodeDB";
/* 753 */       tError.functionName = "hasMoreData";
/* 754 */       tError.errorMessage = ex.toString();
/* 755 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 758 */         this.mResultSet.close();
/* 759 */         this.mResultSet = null;
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 765 */         this.mStatement.close();
/* 766 */         this.mStatement = null;
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 770 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 774 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 779 */       return false;
/*     */     }
/* 781 */     return flag;
/*     */   }
/*     */ 
/*     */   public MCodeSet getData()
/*     */   {
/* 786 */     int tCount = 0;
/* 787 */     MCodeSet tMCodeSet = new MCodeSet();
/* 788 */     MCodeSchema tMCodeSchema = null;
/* 789 */     if (this.mResultSet == null)
/*     */     {
/* 791 */       CError tError = new CError();
/* 792 */       tError.moduleName = "MCodeDB";
/* 793 */       tError.functionName = "getData";
/* 794 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 795 */       this.mErrors.addOneError(tError);
/* 796 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 800 */       tCount = 1;
/* 801 */       tMCodeSchema = new MCodeSchema();
/* 802 */       tMCodeSchema.setSchema(this.mResultSet, 1);
/* 803 */       tMCodeSet.add(tMCodeSchema);
/*     */ 
/* 805 */       while (tCount++ < 5000)
/*     */       {
/* 807 */         if (!this.mResultSet.next())
/*     */           continue;
/* 809 */         tMCodeSchema = new MCodeSchema();
/* 810 */         tMCodeSchema.setSchema(this.mResultSet, 1);
/* 811 */         tMCodeSet.add(tMCodeSchema);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 817 */       CError tError = new CError();
/* 818 */       tError.moduleName = "MCodeDB";
/* 819 */       tError.functionName = "getData";
/* 820 */       tError.errorMessage = ex.toString();
/* 821 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 824 */         this.mResultSet.close();
/* 825 */         this.mResultSet = null;
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try {
/* 831 */         this.mStatement.close();
/* 832 */         this.mStatement = null;
/*     */       }
/*     */       catch (Exception localException2) {
/*     */       }
/* 836 */       if (!this.mflag)
/*     */       {
/*     */         try
/*     */         {
/* 840 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException3) {
/*     */         }
/*     */       }
/* 845 */       return null;
/*     */     }
/* 847 */     return tMCodeSet;
/*     */   }
/*     */ 
/*     */   public boolean closeData()
/*     */   {
/* 852 */     boolean flag = true;
/*     */     try
/*     */     {
/* 855 */       if (this.mResultSet == null)
/*     */       {
/* 857 */         CError tError = new CError();
/* 858 */         tError.moduleName = "MCodeDB";
/* 859 */         tError.functionName = "closeData";
/* 860 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 861 */         this.mErrors.addOneError(tError);
/* 862 */         flag = false;
/*     */       }
/*     */       else
/*     */       {
/* 866 */         this.mResultSet.close();
/* 867 */         this.mResultSet = null;
/*     */       }
/*     */     }
/*     */     catch (Exception ex2)
/*     */     {
/* 872 */       CError tError = new CError();
/* 873 */       tError.moduleName = "MCodeDB";
/* 874 */       tError.functionName = "closeData";
/* 875 */       tError.errorMessage = ex2.toString();
/* 876 */       this.mErrors.addOneError(tError);
/* 877 */       flag = false;
/*     */     }
/*     */     try
/*     */     {
/* 881 */       if (this.mStatement == null)
/*     */       {
/* 883 */         CError tError = new CError();
/* 884 */         tError.moduleName = "MCodeDB";
/* 885 */         tError.functionName = "closeData";
/* 886 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 887 */         this.mErrors.addOneError(tError);
/* 888 */         flag = false;
/*     */       }
/*     */       else
/*     */       {
/* 892 */         this.mStatement.close();
/* 893 */         this.mStatement = null;
/*     */       }
/*     */     }
/*     */     catch (Exception ex3)
/*     */     {
/* 898 */       CError tError = new CError();
/* 899 */       tError.moduleName = "MCodeDB";
/* 900 */       tError.functionName = "closeData";
/* 901 */       tError.errorMessage = ex3.toString();
/* 902 */       this.mErrors.addOneError(tError);
/* 903 */       flag = false;
/*     */     }
/* 905 */     return flag;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MCodeDB
 * JD-Core Version:    0.6.0
 */