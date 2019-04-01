/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPFAndIImpResultSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPFAndIImpResultSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPFAndIImpResultDBSet extends LNPFAndIImpResultSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPFAndIImpResultDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPFAndIImpResult");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPFAndIImpResultDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPFAndIImpResult");
/*  36 */     this.con = this.db.getConnection();
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  41 */     if (this.db.deleteSQL(this))
/*     */     {
/*  43 */       return true;
/*     */     }
/*     */ 
/*  48 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*  49 */     CError tError = new CError();
/*  50 */     tError.moduleName = "LNPFAndIImpResultDBSet";
/*  51 */     tError.functionName = "deleteSQL";
/*  52 */     tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  53 */     this.mErrors.addOneError(tError);
/*  54 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean delete()
/*     */   {
/*  61 */     PreparedStatement pstmt = null;
/*     */ 
/*  63 */     if (!this.mflag) {
/*  64 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  69 */       int tCount = size();
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPFAndIImpResult WHERE  ResultId = ? AND Grouporder = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getResultId() == null) || (get(i).getResultId().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getResultId());
/*     */         }
/*  78 */         if ((get(i).getGrouporder() == null) || (get(i).getGrouporder().equals("null")))
/*  79 */           pstmt.setString(2, null);
/*     */         else {
/*  81 */           pstmt.setString(2, get(i).getGrouporder());
/*     */         }
/*  83 */         pstmt.addBatch();
/*     */       }
/*  85 */       pstmt.executeBatch();
/*  86 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  89 */       ex.printStackTrace();
/*  90 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  91 */       CError tError = new CError();
/*  92 */       tError.moduleName = "LNPFAndIImpResultDBSet";
/*  93 */       tError.functionName = "delete()";
/*  94 */       tError.errorMessage = ex.toString();
/*  95 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/*  98 */         pstmt.close(); } catch (Exception e) {
/*  99 */         e.printStackTrace();
/*     */       }
/* 101 */       if (!this.mflag) {
/*     */         try {
/* 103 */           this.con.close(); } catch (Exception e) {
/* 104 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 107 */       return false;
/*     */     }
/*     */ 
/* 110 */     if (!this.mflag) {
/*     */       try {
/* 112 */         this.con.close(); } catch (Exception e) {
/* 113 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 116 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 122 */     PreparedStatement pstmt = null;
/*     */ 
/* 124 */     if (!this.mflag) {
/* 125 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 130 */       int tCount = size();
/* 131 */       pstmt = this.con.prepareStatement("UPDATE LNPFAndIImpResult SET  ResultId = ? , GrpContNo = ? , ContNo = ? , ProposalContNo = ? , ImpartId = ? , Grouporder = ? , QID01 = ? , A01 = ? , QID02 = ? , A02 = ? , QID03 = ? , A03 = ? , QID04 = ? , A04 = ? , QID05 = ? , A05 = ? , QID06 = ? , A06 = ? , QID07 = ? , A07 = ? , QID08 = ? , A08 = ? , QID09 = ? , A09 = ? , QID10 = ? , A10 = ? , QID11 = ? , A11 = ? , QID12 = ? , A12 = ? , QID13 = ? , A13 = ? , QID14 = ? , A14 = ? , QID15 = ? , A15 = ? , QID16 = ? , A16 = ? , Operator = ? , ManageCom = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ResultId = ? AND Grouporder = ?");
/* 132 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 134 */         if ((get(i).getResultId() == null) || (get(i).getResultId().equals("null")))
/* 135 */           pstmt.setString(1, null);
/*     */         else {
/* 137 */           pstmt.setString(1, get(i).getResultId());
/*     */         }
/* 139 */         if ((get(i).getGrpContNo() == null) || (get(i).getGrpContNo().equals("null")))
/* 140 */           pstmt.setString(2, null);
/*     */         else {
/* 142 */           pstmt.setString(2, get(i).getGrpContNo());
/*     */         }
/* 144 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 145 */           pstmt.setString(3, null);
/*     */         else {
/* 147 */           pstmt.setString(3, get(i).getContNo());
/*     */         }
/* 149 */         if ((get(i).getProposalContNo() == null) || (get(i).getProposalContNo().equals("null")))
/* 150 */           pstmt.setString(4, null);
/*     */         else {
/* 152 */           pstmt.setString(4, get(i).getProposalContNo());
/*     */         }
/* 154 */         if ((get(i).getImpartId() == null) || (get(i).getImpartId().equals("null")))
/* 155 */           pstmt.setString(5, null);
/*     */         else {
/* 157 */           pstmt.setString(5, get(i).getImpartId());
/*     */         }
/* 159 */         if ((get(i).getGrouporder() == null) || (get(i).getGrouporder().equals("null")))
/* 160 */           pstmt.setString(6, null);
/*     */         else {
/* 162 */           pstmt.setString(6, get(i).getGrouporder());
/*     */         }
/* 164 */         if ((get(i).getQID01() == null) || (get(i).getQID01().equals("null")))
/* 165 */           pstmt.setString(7, null);
/*     */         else {
/* 167 */           pstmt.setString(7, get(i).getQID01());
/*     */         }
/* 169 */         if ((get(i).getA01() == null) || (get(i).getA01().equals("null")))
/* 170 */           pstmt.setString(8, null);
/*     */         else {
/* 172 */           pstmt.setString(8, get(i).getA01());
/*     */         }
/* 174 */         if ((get(i).getQID02() == null) || (get(i).getQID02().equals("null")))
/* 175 */           pstmt.setString(9, null);
/*     */         else {
/* 177 */           pstmt.setString(9, get(i).getQID02());
/*     */         }
/* 179 */         if ((get(i).getA02() == null) || (get(i).getA02().equals("null")))
/* 180 */           pstmt.setString(10, null);
/*     */         else {
/* 182 */           pstmt.setString(10, get(i).getA02());
/*     */         }
/* 184 */         if ((get(i).getQID03() == null) || (get(i).getQID03().equals("null")))
/* 185 */           pstmt.setString(11, null);
/*     */         else {
/* 187 */           pstmt.setString(11, get(i).getQID03());
/*     */         }
/* 189 */         if ((get(i).getA03() == null) || (get(i).getA03().equals("null")))
/* 190 */           pstmt.setString(12, null);
/*     */         else {
/* 192 */           pstmt.setString(12, get(i).getA03());
/*     */         }
/* 194 */         if ((get(i).getQID04() == null) || (get(i).getQID04().equals("null")))
/* 195 */           pstmt.setString(13, null);
/*     */         else {
/* 197 */           pstmt.setString(13, get(i).getQID04());
/*     */         }
/* 199 */         if ((get(i).getA04() == null) || (get(i).getA04().equals("null")))
/* 200 */           pstmt.setString(14, null);
/*     */         else {
/* 202 */           pstmt.setString(14, get(i).getA04());
/*     */         }
/* 204 */         if ((get(i).getQID05() == null) || (get(i).getQID05().equals("null")))
/* 205 */           pstmt.setString(15, null);
/*     */         else {
/* 207 */           pstmt.setString(15, get(i).getQID05());
/*     */         }
/* 209 */         if ((get(i).getA05() == null) || (get(i).getA05().equals("null")))
/* 210 */           pstmt.setString(16, null);
/*     */         else {
/* 212 */           pstmt.setString(16, get(i).getA05());
/*     */         }
/* 214 */         if ((get(i).getQID06() == null) || (get(i).getQID06().equals("null")))
/* 215 */           pstmt.setString(17, null);
/*     */         else {
/* 217 */           pstmt.setString(17, get(i).getQID06());
/*     */         }
/* 219 */         if ((get(i).getA06() == null) || (get(i).getA06().equals("null")))
/* 220 */           pstmt.setString(18, null);
/*     */         else {
/* 222 */           pstmt.setString(18, get(i).getA06());
/*     */         }
/* 224 */         if ((get(i).getQID07() == null) || (get(i).getQID07().equals("null")))
/* 225 */           pstmt.setString(19, null);
/*     */         else {
/* 227 */           pstmt.setString(19, get(i).getQID07());
/*     */         }
/* 229 */         if ((get(i).getA07() == null) || (get(i).getA07().equals("null")))
/* 230 */           pstmt.setString(20, null);
/*     */         else {
/* 232 */           pstmt.setString(20, get(i).getA07());
/*     */         }
/* 234 */         if ((get(i).getQID08() == null) || (get(i).getQID08().equals("null")))
/* 235 */           pstmt.setString(21, null);
/*     */         else {
/* 237 */           pstmt.setString(21, get(i).getQID08());
/*     */         }
/* 239 */         if ((get(i).getA08() == null) || (get(i).getA08().equals("null")))
/* 240 */           pstmt.setString(22, null);
/*     */         else {
/* 242 */           pstmt.setString(22, get(i).getA08());
/*     */         }
/* 244 */         if ((get(i).getQID09() == null) || (get(i).getQID09().equals("null")))
/* 245 */           pstmt.setString(23, null);
/*     */         else {
/* 247 */           pstmt.setString(23, get(i).getQID09());
/*     */         }
/* 249 */         if ((get(i).getA09() == null) || (get(i).getA09().equals("null")))
/* 250 */           pstmt.setString(24, null);
/*     */         else {
/* 252 */           pstmt.setString(24, get(i).getA09());
/*     */         }
/* 254 */         if ((get(i).getQID10() == null) || (get(i).getQID10().equals("null")))
/* 255 */           pstmt.setString(25, null);
/*     */         else {
/* 257 */           pstmt.setString(25, get(i).getQID10());
/*     */         }
/* 259 */         if ((get(i).getA10() == null) || (get(i).getA10().equals("null")))
/* 260 */           pstmt.setString(26, null);
/*     */         else {
/* 262 */           pstmt.setString(26, get(i).getA10());
/*     */         }
/* 264 */         if ((get(i).getQID11() == null) || (get(i).getQID11().equals("null")))
/* 265 */           pstmt.setString(27, null);
/*     */         else {
/* 267 */           pstmt.setString(27, get(i).getQID11());
/*     */         }
/* 269 */         if ((get(i).getA11() == null) || (get(i).getA11().equals("null")))
/* 270 */           pstmt.setString(28, null);
/*     */         else {
/* 272 */           pstmt.setString(28, get(i).getA11());
/*     */         }
/* 274 */         if ((get(i).getQID12() == null) || (get(i).getQID12().equals("null")))
/* 275 */           pstmt.setString(29, null);
/*     */         else {
/* 277 */           pstmt.setString(29, get(i).getQID12());
/*     */         }
/* 279 */         if ((get(i).getA12() == null) || (get(i).getA12().equals("null")))
/* 280 */           pstmt.setString(30, null);
/*     */         else {
/* 282 */           pstmt.setString(30, get(i).getA12());
/*     */         }
/* 284 */         if ((get(i).getQID13() == null) || (get(i).getQID13().equals("null")))
/* 285 */           pstmt.setString(31, null);
/*     */         else {
/* 287 */           pstmt.setString(31, get(i).getQID13());
/*     */         }
/* 289 */         if ((get(i).getA13() == null) || (get(i).getA13().equals("null")))
/* 290 */           pstmt.setString(32, null);
/*     */         else {
/* 292 */           pstmt.setString(32, get(i).getA13());
/*     */         }
/* 294 */         if ((get(i).getQID14() == null) || (get(i).getQID14().equals("null")))
/* 295 */           pstmt.setString(33, null);
/*     */         else {
/* 297 */           pstmt.setString(33, get(i).getQID14());
/*     */         }
/* 299 */         if ((get(i).getA14() == null) || (get(i).getA14().equals("null")))
/* 300 */           pstmt.setString(34, null);
/*     */         else {
/* 302 */           pstmt.setString(34, get(i).getA14());
/*     */         }
/* 304 */         if ((get(i).getQID15() == null) || (get(i).getQID15().equals("null")))
/* 305 */           pstmt.setString(35, null);
/*     */         else {
/* 307 */           pstmt.setString(35, get(i).getQID15());
/*     */         }
/* 309 */         if ((get(i).getA15() == null) || (get(i).getA15().equals("null")))
/* 310 */           pstmt.setString(36, null);
/*     */         else {
/* 312 */           pstmt.setString(36, get(i).getA15());
/*     */         }
/* 314 */         if ((get(i).getQID16() == null) || (get(i).getQID16().equals("null")))
/* 315 */           pstmt.setString(37, null);
/*     */         else {
/* 317 */           pstmt.setString(37, get(i).getQID16());
/*     */         }
/* 319 */         if ((get(i).getA16() == null) || (get(i).getA16().equals("null")))
/* 320 */           pstmt.setString(38, null);
/*     */         else {
/* 322 */           pstmt.setString(38, get(i).getA16());
/*     */         }
/* 324 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 325 */           pstmt.setString(39, null);
/*     */         else {
/* 327 */           pstmt.setString(39, get(i).getOperator());
/*     */         }
/* 329 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 330 */           pstmt.setString(40, null);
/*     */         else {
/* 332 */           pstmt.setString(40, get(i).getManageCom());
/*     */         }
/* 334 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 335 */           pstmt.setDate(41, null);
/*     */         else {
/* 337 */           pstmt.setDate(41, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 339 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 340 */           pstmt.setString(42, null);
/*     */         else {
/* 342 */           pstmt.setString(42, get(i).getMakeTime());
/*     */         }
/* 344 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 345 */           pstmt.setDate(43, null);
/*     */         else {
/* 347 */           pstmt.setDate(43, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 349 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 350 */           pstmt.setString(44, null);
/*     */         else {
/* 352 */           pstmt.setString(44, get(i).getModifyTime());
/*     */         }
/*     */ 
/* 355 */         if ((get(i).getResultId() == null) || (get(i).getResultId().equals("null")))
/* 356 */           pstmt.setString(45, null);
/*     */         else {
/* 358 */           pstmt.setString(45, get(i).getResultId());
/*     */         }
/* 360 */         if ((get(i).getGrouporder() == null) || (get(i).getGrouporder().equals("null")))
/* 361 */           pstmt.setString(46, null);
/*     */         else {
/* 363 */           pstmt.setString(46, get(i).getGrouporder());
/*     */         }
/* 365 */         pstmt.addBatch();
/*     */       }
/* 367 */       pstmt.executeBatch();
/* 368 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 371 */       ex.printStackTrace();
/* 372 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 373 */       CError tError = new CError();
/* 374 */       tError.moduleName = "LNPFAndIImpResultDBSet";
/* 375 */       tError.functionName = "update()";
/* 376 */       tError.errorMessage = ex.toString();
/* 377 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 380 */         pstmt.close(); } catch (Exception e) {
/* 381 */         e.printStackTrace();
/*     */       }
/* 383 */       if (!this.mflag) {
/*     */         try {
/* 385 */           this.con.close(); } catch (Exception e) {
/* 386 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 389 */       return false;
/*     */     }
/*     */ 
/* 392 */     if (!this.mflag) {
/*     */       try {
/* 394 */         this.con.close(); } catch (Exception e) {
/* 395 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 398 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 404 */     PreparedStatement pstmt = null;
/*     */ 
/* 406 */     if (!this.mflag) {
/* 407 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 412 */       int tCount = size();
/* 413 */       pstmt = this.con.prepareStatement("INSERT INTO LNPFAndIImpResult VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 414 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 416 */         if ((get(i).getResultId() == null) || (get(i).getResultId().equals("null")))
/* 417 */           pstmt.setString(1, null);
/*     */         else {
/* 419 */           pstmt.setString(1, get(i).getResultId());
/*     */         }
/* 421 */         if ((get(i).getGrpContNo() == null) || (get(i).getGrpContNo().equals("null")))
/* 422 */           pstmt.setString(2, null);
/*     */         else {
/* 424 */           pstmt.setString(2, get(i).getGrpContNo());
/*     */         }
/* 426 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 427 */           pstmt.setString(3, null);
/*     */         else {
/* 429 */           pstmt.setString(3, get(i).getContNo());
/*     */         }
/* 431 */         if ((get(i).getProposalContNo() == null) || (get(i).getProposalContNo().equals("null")))
/* 432 */           pstmt.setString(4, null);
/*     */         else {
/* 434 */           pstmt.setString(4, get(i).getProposalContNo());
/*     */         }
/* 436 */         if ((get(i).getImpartId() == null) || (get(i).getImpartId().equals("null")))
/* 437 */           pstmt.setString(5, null);
/*     */         else {
/* 439 */           pstmt.setString(5, get(i).getImpartId());
/*     */         }
/* 441 */         if ((get(i).getGrouporder() == null) || (get(i).getGrouporder().equals("null")))
/* 442 */           pstmt.setString(6, null);
/*     */         else {
/* 444 */           pstmt.setString(6, get(i).getGrouporder());
/*     */         }
/* 446 */         if ((get(i).getQID01() == null) || (get(i).getQID01().equals("null")))
/* 447 */           pstmt.setString(7, null);
/*     */         else {
/* 449 */           pstmt.setString(7, get(i).getQID01());
/*     */         }
/* 451 */         if ((get(i).getA01() == null) || (get(i).getA01().equals("null")))
/* 452 */           pstmt.setString(8, null);
/*     */         else {
/* 454 */           pstmt.setString(8, get(i).getA01());
/*     */         }
/* 456 */         if ((get(i).getQID02() == null) || (get(i).getQID02().equals("null")))
/* 457 */           pstmt.setString(9, null);
/*     */         else {
/* 459 */           pstmt.setString(9, get(i).getQID02());
/*     */         }
/* 461 */         if ((get(i).getA02() == null) || (get(i).getA02().equals("null")))
/* 462 */           pstmt.setString(10, null);
/*     */         else {
/* 464 */           pstmt.setString(10, get(i).getA02());
/*     */         }
/* 466 */         if ((get(i).getQID03() == null) || (get(i).getQID03().equals("null")))
/* 467 */           pstmt.setString(11, null);
/*     */         else {
/* 469 */           pstmt.setString(11, get(i).getQID03());
/*     */         }
/* 471 */         if ((get(i).getA03() == null) || (get(i).getA03().equals("null")))
/* 472 */           pstmt.setString(12, null);
/*     */         else {
/* 474 */           pstmt.setString(12, get(i).getA03());
/*     */         }
/* 476 */         if ((get(i).getQID04() == null) || (get(i).getQID04().equals("null")))
/* 477 */           pstmt.setString(13, null);
/*     */         else {
/* 479 */           pstmt.setString(13, get(i).getQID04());
/*     */         }
/* 481 */         if ((get(i).getA04() == null) || (get(i).getA04().equals("null")))
/* 482 */           pstmt.setString(14, null);
/*     */         else {
/* 484 */           pstmt.setString(14, get(i).getA04());
/*     */         }
/* 486 */         if ((get(i).getQID05() == null) || (get(i).getQID05().equals("null")))
/* 487 */           pstmt.setString(15, null);
/*     */         else {
/* 489 */           pstmt.setString(15, get(i).getQID05());
/*     */         }
/* 491 */         if ((get(i).getA05() == null) || (get(i).getA05().equals("null")))
/* 492 */           pstmt.setString(16, null);
/*     */         else {
/* 494 */           pstmt.setString(16, get(i).getA05());
/*     */         }
/* 496 */         if ((get(i).getQID06() == null) || (get(i).getQID06().equals("null")))
/* 497 */           pstmt.setString(17, null);
/*     */         else {
/* 499 */           pstmt.setString(17, get(i).getQID06());
/*     */         }
/* 501 */         if ((get(i).getA06() == null) || (get(i).getA06().equals("null")))
/* 502 */           pstmt.setString(18, null);
/*     */         else {
/* 504 */           pstmt.setString(18, get(i).getA06());
/*     */         }
/* 506 */         if ((get(i).getQID07() == null) || (get(i).getQID07().equals("null")))
/* 507 */           pstmt.setString(19, null);
/*     */         else {
/* 509 */           pstmt.setString(19, get(i).getQID07());
/*     */         }
/* 511 */         if ((get(i).getA07() == null) || (get(i).getA07().equals("null")))
/* 512 */           pstmt.setString(20, null);
/*     */         else {
/* 514 */           pstmt.setString(20, get(i).getA07());
/*     */         }
/* 516 */         if ((get(i).getQID08() == null) || (get(i).getQID08().equals("null")))
/* 517 */           pstmt.setString(21, null);
/*     */         else {
/* 519 */           pstmt.setString(21, get(i).getQID08());
/*     */         }
/* 521 */         if ((get(i).getA08() == null) || (get(i).getA08().equals("null")))
/* 522 */           pstmt.setString(22, null);
/*     */         else {
/* 524 */           pstmt.setString(22, get(i).getA08());
/*     */         }
/* 526 */         if ((get(i).getQID09() == null) || (get(i).getQID09().equals("null")))
/* 527 */           pstmt.setString(23, null);
/*     */         else {
/* 529 */           pstmt.setString(23, get(i).getQID09());
/*     */         }
/* 531 */         if ((get(i).getA09() == null) || (get(i).getA09().equals("null")))
/* 532 */           pstmt.setString(24, null);
/*     */         else {
/* 534 */           pstmt.setString(24, get(i).getA09());
/*     */         }
/* 536 */         if ((get(i).getQID10() == null) || (get(i).getQID10().equals("null")))
/* 537 */           pstmt.setString(25, null);
/*     */         else {
/* 539 */           pstmt.setString(25, get(i).getQID10());
/*     */         }
/* 541 */         if ((get(i).getA10() == null) || (get(i).getA10().equals("null")))
/* 542 */           pstmt.setString(26, null);
/*     */         else {
/* 544 */           pstmt.setString(26, get(i).getA10());
/*     */         }
/* 546 */         if ((get(i).getQID11() == null) || (get(i).getQID11().equals("null")))
/* 547 */           pstmt.setString(27, null);
/*     */         else {
/* 549 */           pstmt.setString(27, get(i).getQID11());
/*     */         }
/* 551 */         if ((get(i).getA11() == null) || (get(i).getA11().equals("null")))
/* 552 */           pstmt.setString(28, null);
/*     */         else {
/* 554 */           pstmt.setString(28, get(i).getA11());
/*     */         }
/* 556 */         if ((get(i).getQID12() == null) || (get(i).getQID12().equals("null")))
/* 557 */           pstmt.setString(29, null);
/*     */         else {
/* 559 */           pstmt.setString(29, get(i).getQID12());
/*     */         }
/* 561 */         if ((get(i).getA12() == null) || (get(i).getA12().equals("null")))
/* 562 */           pstmt.setString(30, null);
/*     */         else {
/* 564 */           pstmt.setString(30, get(i).getA12());
/*     */         }
/* 566 */         if ((get(i).getQID13() == null) || (get(i).getQID13().equals("null")))
/* 567 */           pstmt.setString(31, null);
/*     */         else {
/* 569 */           pstmt.setString(31, get(i).getQID13());
/*     */         }
/* 571 */         if ((get(i).getA13() == null) || (get(i).getA13().equals("null")))
/* 572 */           pstmt.setString(32, null);
/*     */         else {
/* 574 */           pstmt.setString(32, get(i).getA13());
/*     */         }
/* 576 */         if ((get(i).getQID14() == null) || (get(i).getQID14().equals("null")))
/* 577 */           pstmt.setString(33, null);
/*     */         else {
/* 579 */           pstmt.setString(33, get(i).getQID14());
/*     */         }
/* 581 */         if ((get(i).getA14() == null) || (get(i).getA14().equals("null")))
/* 582 */           pstmt.setString(34, null);
/*     */         else {
/* 584 */           pstmt.setString(34, get(i).getA14());
/*     */         }
/* 586 */         if ((get(i).getQID15() == null) || (get(i).getQID15().equals("null")))
/* 587 */           pstmt.setString(35, null);
/*     */         else {
/* 589 */           pstmt.setString(35, get(i).getQID15());
/*     */         }
/* 591 */         if ((get(i).getA15() == null) || (get(i).getA15().equals("null")))
/* 592 */           pstmt.setString(36, null);
/*     */         else {
/* 594 */           pstmt.setString(36, get(i).getA15());
/*     */         }
/* 596 */         if ((get(i).getQID16() == null) || (get(i).getQID16().equals("null")))
/* 597 */           pstmt.setString(37, null);
/*     */         else {
/* 599 */           pstmt.setString(37, get(i).getQID16());
/*     */         }
/* 601 */         if ((get(i).getA16() == null) || (get(i).getA16().equals("null")))
/* 602 */           pstmt.setString(38, null);
/*     */         else {
/* 604 */           pstmt.setString(38, get(i).getA16());
/*     */         }
/* 606 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 607 */           pstmt.setString(39, null);
/*     */         else {
/* 609 */           pstmt.setString(39, get(i).getOperator());
/*     */         }
/* 611 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 612 */           pstmt.setString(40, null);
/*     */         else {
/* 614 */           pstmt.setString(40, get(i).getManageCom());
/*     */         }
/* 616 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 617 */           pstmt.setDate(41, null);
/*     */         else {
/* 619 */           pstmt.setDate(41, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 621 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 622 */           pstmt.setString(42, null);
/*     */         else {
/* 624 */           pstmt.setString(42, get(i).getMakeTime());
/*     */         }
/* 626 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 627 */           pstmt.setDate(43, null);
/*     */         else {
/* 629 */           pstmt.setDate(43, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 631 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 632 */           pstmt.setString(44, null);
/*     */         else {
/* 634 */           pstmt.setString(44, get(i).getModifyTime());
/*     */         }
/* 636 */         pstmt.addBatch();
/*     */       }
/* 638 */       pstmt.executeBatch();
/* 639 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 642 */       ex.printStackTrace();
/* 643 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 644 */       CError tError = new CError();
/* 645 */       tError.moduleName = "LNPFAndIImpResultDBSet";
/* 646 */       tError.functionName = "insert()";
/* 647 */       tError.errorMessage = ex.toString();
/* 648 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 651 */         pstmt.close(); } catch (Exception e) {
/* 652 */         e.printStackTrace();
/*     */       }
/* 654 */       if (!this.mflag) {
/*     */         try {
/* 656 */           this.con.close(); } catch (Exception e) {
/* 657 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 660 */       return false;
/*     */     }
/*     */ 
/* 663 */     if (!this.mflag) {
/*     */       try {
/* 665 */         this.con.close(); } catch (Exception e) {
/* 666 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 669 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPFAndIImpResultDBSet
 * JD-Core Version:    0.6.0
 */