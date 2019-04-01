/*     */ package com.sinosoft.map.lis.db;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MCCSAcceptanceStateSchema;
/*     */ import com.sinosoft.map.lis.vschema.MCCSAcceptanceStateSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import com.sinosoft.map.utility.SQLString;
/*     */ import com.sinosoft.map.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ 
/*     */ public class MCCSAcceptanceStateDB extends MCCSAcceptanceStateSchema
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
/*     */   public MCCSAcceptanceStateDB(Connection tConnection)
/*     */   {
/*  31 */     this.con = tConnection;
/*  32 */     this.db = new DBOper(this.con, "MCCSAcceptanceState");
/*  33 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MCCSAcceptanceStateDB()
/*     */   {
/*  38 */     this.con = null;
/*  39 */     this.db = new DBOper("MCCSAcceptanceState");
/*  40 */     this.mflag = false;
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  46 */     MCCSAcceptanceStateSchema tSchema = getSchema();
/*  47 */     if (this.db.deleteSQL(tSchema))
/*     */     {
/*  49 */       return true;
/*     */     }
/*     */ 
/*  54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*  55 */     CError tError = new CError();
/*  56 */     tError.moduleName = "MCCSAcceptanceStateDB";
/*  57 */     tError.functionName = "deleteSQL";
/*  58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*  59 */     this.mErrors.addOneError(tError);
/*  60 */     return false;
/*     */   }
/*     */ 
/*     */   public int getCount()
/*     */   {
/*  66 */     MCCSAcceptanceStateSchema tSchema = getSchema();
/*     */ 
/*  68 */     int tCount = this.db.getCount(tSchema);
/*  69 */     if (tCount < 0)
/*     */     {
/*  72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  73 */       CError tError = new CError();
/*  74 */       tError.moduleName = "MCCSAcceptanceStateDB";
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
/*  95 */       pstmt = this.con.prepareStatement("DELETE FROM MCCSAcceptanceState WHERE  ServiceNo = ? AND AgentCode = ?");
/*  96 */       if ((getServiceNo() == null) || (getServiceNo().equals("null")))
/*  97 */         pstmt.setNull(1, 12);
/*     */       else {
/*  99 */         pstmt.setString(1, getServiceNo());
/*     */       }
/* 101 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/* 102 */         pstmt.setNull(2, 12);
/*     */       else {
/* 104 */         pstmt.setString(2, getAgentCode());
/*     */       }
/* 106 */       pstmt.executeUpdate();
/* 107 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 110 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 111 */       CError tError = new CError();
/* 112 */       tError.moduleName = "MCCSAcceptanceStateDB";
/* 113 */       tError.functionName = "delete()";
/* 114 */       tError.errorMessage = ex.toString();
/* 115 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 118 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 121 */       if (!this.mflag)
/*     */         try {
/* 123 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 127 */       return false;
/*     */     }
/*     */ 
/* 130 */     if (!this.mflag)
/*     */       try {
/* 132 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 136 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 141 */     PreparedStatement pstmt = null;
/*     */ 
/* 143 */     if (!this.mflag) {
/* 144 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 149 */       pstmt = this.con.prepareStatement("UPDATE MCCSAcceptanceState SET  ServiceNo = ? , AgentCode = ? , Status = ? , BY1 = ? , BY2 = ? , BY3 = ? WHERE  ServiceNo = ? AND AgentCode = ?");
/* 150 */       if ((getServiceNo() == null) || (getServiceNo().equals("null")))
/* 151 */         pstmt.setNull(1, 12);
/*     */       else {
/* 153 */         pstmt.setString(1, getServiceNo());
/*     */       }
/* 155 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/* 156 */         pstmt.setNull(2, 12);
/*     */       else {
/* 158 */         pstmt.setString(2, getAgentCode());
/*     */       }
/* 160 */       if ((getStatus() == null) || (getStatus().equals("null")))
/* 161 */         pstmt.setNull(3, 12);
/*     */       else {
/* 163 */         pstmt.setString(3, getStatus());
/*     */       }
/* 165 */       if ((getBY1() == null) || (getBY1().equals("null")))
/* 166 */         pstmt.setNull(4, 12);
/*     */       else {
/* 168 */         pstmt.setString(4, getBY1());
/*     */       }
/* 170 */       if ((getBY2() == null) || (getBY2().equals("null")))
/* 171 */         pstmt.setNull(5, 12);
/*     */       else {
/* 173 */         pstmt.setString(5, getBY2());
/*     */       }
/* 175 */       if ((getBY3() == null) || (getBY3().equals("null")))
/* 176 */         pstmt.setNull(6, 12);
/*     */       else {
/* 178 */         pstmt.setString(6, getBY3());
/*     */       }
/*     */ 
/* 181 */       if ((getServiceNo() == null) || (getServiceNo().equals("null")))
/* 182 */         pstmt.setNull(7, 12);
/*     */       else {
/* 184 */         pstmt.setString(7, getServiceNo());
/*     */       }
/* 186 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/* 187 */         pstmt.setNull(8, 12);
/*     */       else {
/* 189 */         pstmt.setString(8, getAgentCode());
/*     */       }
/* 191 */       pstmt.executeUpdate();
/* 192 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 195 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 196 */       CError tError = new CError();
/* 197 */       tError.moduleName = "MCCSAcceptanceStateDB";
/* 198 */       tError.functionName = "update()";
/* 199 */       tError.errorMessage = ex.toString();
/* 200 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 203 */         pstmt.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 206 */       if (!this.mflag)
/*     */         try {
/* 208 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/* 212 */       return false;
/*     */     }
/*     */ 
/* 215 */     if (!this.mflag)
/*     */       try {
/* 217 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/* 221 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 226 */     PreparedStatement pstmt = null;
/*     */ 
/* 228 */     if (!this.mflag) {
/* 229 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 234 */       pstmt = this.con.prepareStatement("INSERT INTO MCCSAcceptanceState VALUES( ? , ? , ? , ? , ? , ?)");
/* 235 */       if ((getServiceNo() == null) || (getServiceNo().equals("null")))
/* 236 */         pstmt.setNull(1, 12);
/*     */       else {
/* 238 */         pstmt.setString(1, getServiceNo());
/*     */       }
/* 240 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/* 241 */         pstmt.setNull(2, 12);
/*     */       else {
/* 243 */         pstmt.setString(2, getAgentCode());
/*     */       }
/* 245 */       if ((getStatus() == null) || (getStatus().equals("null")))
/* 246 */         pstmt.setNull(3, 12);
/*     */       else {
/* 248 */         pstmt.setString(3, getStatus());
/*     */       }
/* 250 */       if ((getBY1() == null) || (getBY1().equals("null")))
/* 251 */         pstmt.setNull(4, 12);
/*     */       else {
/* 253 */         pstmt.setString(4, getBY1());
/*     */       }
/* 255 */       if ((getBY2() == null) || (getBY2().equals("null")))
/* 256 */         pstmt.setNull(5, 12);
/*     */       else {
/* 258 */         pstmt.setString(5, getBY2());
/*     */       }
/* 260 */       if ((getBY3() == null) || (getBY3().equals("null")))
/* 261 */         pstmt.setNull(6, 12);
/*     */       else {
/* 263 */         pstmt.setString(6, getBY3());
/*     */       }
/*     */ 
/* 266 */       pstmt.executeUpdate();
/* 267 */       System.out.println("=========== execute insert ok==============");
/* 268 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 271 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 272 */       CError tError = new CError();
/* 273 */       tError.moduleName = "MCCSAcceptanceStateDB";
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
/* 311 */       pstmt = this.con.prepareStatement("SELECT * FROM MCCSAcceptanceState WHERE  ServiceNo = ? AND AgentCode = ?", 
/* 312 */         1003, 1007);
/* 313 */       if ((getServiceNo() == null) || (getServiceNo().equals("null")))
/* 314 */         pstmt.setNull(1, 12);
/*     */       else {
/* 316 */         pstmt.setString(1, getServiceNo());
/*     */       }
/* 318 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/* 319 */         pstmt.setNull(2, 12);
/*     */       else {
/* 321 */         pstmt.setString(2, getAgentCode());
/*     */       }
/* 323 */       rs = pstmt.executeQuery();
/* 324 */       int i = 0;
/* 325 */       if (rs.next())
/*     */       {
/* 327 */         i++;
/* 328 */         if (!setSchema(rs, i))
/*     */         {
/* 331 */           CError tError = new CError();
/* 332 */           tError.moduleName = "MCCSAcceptanceStateDB";
/* 333 */           tError.functionName = "getInfo";
/* 334 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
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
/* 372 */       tError.moduleName = "MCCSAcceptanceStateDB";
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
/*     */   public MCCSAcceptanceStateSet query()
/*     */   {
/* 405 */     Statement stmt = null;
/* 406 */     ResultSet rs = null;
/* 407 */     MCCSAcceptanceStateSet aMCCSAcceptanceStateSet = new MCCSAcceptanceStateSet();
/*     */ 
/* 409 */     if (!this.mflag) {
/* 410 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 415 */       stmt = this.con.createStatement(1003, 1007);
/* 416 */       SQLString sqlObj = new SQLString("MCCSAcceptanceState");
/* 417 */       MCCSAcceptanceStateSchema aSchema = getSchema();
/* 418 */       sqlObj.setSQL(5, aSchema);
/* 419 */       String sql = sqlObj.getSQL();
/*     */ 
/* 421 */       rs = stmt.executeQuery(sql);
/* 422 */       int i = 0;
/* 423 */       while (rs.next())
/*     */       {
/* 425 */         i++;
/* 426 */         MCCSAcceptanceStateSchema s1 = new MCCSAcceptanceStateSchema();
/* 427 */         s1.setSchema(rs, i);
/* 428 */         aMCCSAcceptanceStateSet.add(s1);
/*     */       }try {
/* 430 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 436 */       CError tError = new CError();
/* 437 */       tError.moduleName = "MCCSAcceptanceStateDB";
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
/* 464 */     return aMCCSAcceptanceStateSet;
/*     */   }
/*     */ 
/*     */   public MCCSAcceptanceStateSet executeQuery(String sql)
/*     */   {
/* 469 */     Statement stmt = null;
/* 470 */     ResultSet rs = null;
/* 471 */     MCCSAcceptanceStateSet aMCCSAcceptanceStateSet = new MCCSAcceptanceStateSet();
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
/* 486 */         MCCSAcceptanceStateSchema s1 = new MCCSAcceptanceStateSchema();
/* 487 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 490 */           CError tError = new CError();
/* 491 */           tError.moduleName = "MCCSAcceptanceStateDB";
/* 492 */           tError.functionName = "executeQuery";
/* 493 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/* 494 */           this.mErrors.addOneError(tError);
/*     */         }
/* 496 */         aMCCSAcceptanceStateSet.add(s1);
/*     */       }try {
/* 498 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 504 */       CError tError = new CError();
/* 505 */       tError.moduleName = "MCCSAcceptanceStateDB";
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
/* 532 */     return aMCCSAcceptanceStateSet;
/*     */   }
/*     */ 
/*     */   public MCCSAcceptanceStateSet query(int nStart, int nCount)
/*     */   {
/* 537 */     Statement stmt = null;
/* 538 */     ResultSet rs = null;
/* 539 */     MCCSAcceptanceStateSet aMCCSAcceptanceStateSet = new MCCSAcceptanceStateSet();
/*     */ 
/* 541 */     if (!this.mflag) {
/* 542 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 547 */       stmt = this.con.createStatement(1003, 1007);
/* 548 */       SQLString sqlObj = new SQLString("MCCSAcceptanceState");
/* 549 */       MCCSAcceptanceStateSchema aSchema = getSchema();
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
/* 567 */         MCCSAcceptanceStateSchema s1 = new MCCSAcceptanceStateSchema();
/* 568 */         s1.setSchema(rs, i);
/* 569 */         aMCCSAcceptanceStateSet.add(s1);
/*     */       }try {
/* 571 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 577 */       CError tError = new CError();
/* 578 */       tError.moduleName = "MCCSAcceptanceStateDB";
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
/* 605 */     return aMCCSAcceptanceStateSet;
/*     */   }
/*     */ 
/*     */   public MCCSAcceptanceStateSet executeQuery(String sql, int nStart, int nCount)
/*     */   {
/* 610 */     Statement stmt = null;
/* 611 */     ResultSet rs = null;
/* 612 */     MCCSAcceptanceStateSet aMCCSAcceptanceStateSet = new MCCSAcceptanceStateSet();
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
/* 636 */         MCCSAcceptanceStateSchema s1 = new MCCSAcceptanceStateSchema();
/* 637 */         if (!s1.setSchema(rs, i))
/*     */         {
/* 640 */           CError tError = new CError();
/* 641 */           tError.moduleName = "MCCSAcceptanceStateDB";
/* 642 */           tError.functionName = "executeQuery";
/* 643 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/* 644 */           this.mErrors.addOneError(tError);
/*     */         }
/* 646 */         aMCCSAcceptanceStateSet.add(s1);
/*     */       }try {
/* 648 */         rs.close(); } catch (Exception localException1) {
/*     */       }try { stmt.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 654 */       CError tError = new CError();
/* 655 */       tError.moduleName = "MCCSAcceptanceStateDB";
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
/* 682 */     return aMCCSAcceptanceStateSet;
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
/* 696 */       SQLString sqlObj = new SQLString("MCCSAcceptanceState");
/* 697 */       MCCSAcceptanceStateSchema aSchema = getSchema();
/* 698 */       sqlObj.setSQL(2, aSchema);
/* 699 */       String sql = "update MCCSAcceptanceState " + sqlObj.getUpdPart() + " where " + strWherePart;
/*     */ 
/* 701 */       int operCount = stmt.executeUpdate(sql);
/* 702 */       if (operCount == 0)
/*     */       {
/* 705 */         CError tError = new CError();
/* 706 */         tError.moduleName = "MCCSAcceptanceStateDB";
/* 707 */         tError.functionName = "update";
/* 708 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
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
/* 726 */       tError.moduleName = "MCCSAcceptanceStateDB";
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
/* 763 */       tError.moduleName = "MCCSAcceptanceStateDB";
/* 764 */       tError.functionName = "prepareData";
/* 765 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
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
/* 783 */       tError.moduleName = "MCCSAcceptanceStateDB";
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
/* 830 */       tError.moduleName = "MCCSAcceptanceStateDB";
/* 831 */       tError.functionName = "hasMoreData";
/* 832 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
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
/* 843 */       tError.moduleName = "MCCSAcceptanceStateDB";
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
/*     */   public MCCSAcceptanceStateSet getData()
/*     */   {
/* 877 */     int tCount = 0;
/* 878 */     MCCSAcceptanceStateSet tMCCSAcceptanceStateSet = new MCCSAcceptanceStateSet();
/* 879 */     MCCSAcceptanceStateSchema tMCCSAcceptanceStateSchema = null;
/* 880 */     if (this.mResultSet == null)
/*     */     {
/* 882 */       CError tError = new CError();
/* 883 */       tError.moduleName = "MCCSAcceptanceStateDB";
/* 884 */       tError.functionName = "getData";
/* 885 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 886 */       this.mErrors.addOneError(tError);
/* 887 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 891 */       tCount = 1;
/* 892 */       tMCCSAcceptanceStateSchema = new MCCSAcceptanceStateSchema();
/* 893 */       tMCCSAcceptanceStateSchema.setSchema(this.mResultSet, 1);
/* 894 */       tMCCSAcceptanceStateSet.add(tMCCSAcceptanceStateSchema);
/*     */ 
/* 896 */       while (tCount++ < 5000)
/*     */       {
/* 898 */         if (!this.mResultSet.next())
/*     */           continue;
/* 900 */         tMCCSAcceptanceStateSchema = new MCCSAcceptanceStateSchema();
/* 901 */         tMCCSAcceptanceStateSchema.setSchema(this.mResultSet, 1);
/* 902 */         tMCCSAcceptanceStateSet.add(tMCCSAcceptanceStateSchema);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 908 */       CError tError = new CError();
/* 909 */       tError.moduleName = "MCCSAcceptanceStateDB";
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
/* 938 */     return tMCCSAcceptanceStateSet;
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
/* 949 */         tError.moduleName = "MCCSAcceptanceStateDB";
/* 950 */         tError.functionName = "closeData";
/* 951 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
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
/* 964 */       tError.moduleName = "MCCSAcceptanceStateDB";
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
/* 975 */         tError.moduleName = "MCCSAcceptanceStateDB";
/* 976 */         tError.functionName = "closeData";
/* 977 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
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
/* 990 */       tError.moduleName = "MCCSAcceptanceStateDB";
/* 991 */       tError.functionName = "closeData";
/* 992 */       tError.errorMessage = ex3.toString();
/* 993 */       this.mErrors.addOneError(tError);
/* 994 */       flag = false;
/*     */     }
/* 996 */     return flag;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MCCSAcceptanceStateDB
 * JD-Core Version:    0.6.0
 */