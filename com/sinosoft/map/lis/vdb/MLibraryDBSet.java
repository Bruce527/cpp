/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MLibrarySchema;
/*     */ import com.sinosoft.map.lis.vschema.MLibrarySet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MLibraryDBSet extends MLibrarySet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  31 */   private boolean mflag = false;
/*     */ 
/*     */   public MLibraryDBSet(Connection tConnection)
/*     */   {
/*  37 */     this.con = tConnection;
/*  38 */     this.db = new DBOper(this.con, "MLibrary");
/*  39 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MLibraryDBSet()
/*     */   {
/*  44 */     this.db = new DBOper("MLibrary");
/*  45 */     this.con = this.db.getConnection();
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  50 */     if (this.db.deleteSQL(this))
/*     */     {
/*  52 */       return true;
/*     */     }
/*     */ 
/*  57 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*  58 */     CError tError = new CError();
/*  59 */     tError.moduleName = "MLibraryDBSet";
/*  60 */     tError.functionName = "deleteSQL";
/*  61 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*  62 */     this.mErrors.addOneError(tError);
/*  63 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean delete()
/*     */   {
/*  74 */     PreparedStatement pstmt = null;
/*     */ 
/*  76 */     if (!this.mflag) {
/*  77 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  82 */       int tCount = size();
/*  83 */       pstmt = this.con.prepareStatement("DELETE FROM MLibrary WHERE  FileID = ?");
/*  84 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  86 */         if ((get(i).getFileID() == null) || (get(i).getFileID().equals("null")))
/*  87 */           pstmt.setString(1, null);
/*     */         else {
/*  89 */           pstmt.setString(1, get(i).getFileID());
/*     */         }
/*  91 */         pstmt.addBatch();
/*     */       }
/*  93 */       pstmt.executeBatch();
/*  94 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  97 */       ex.printStackTrace();
/*  98 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  99 */       CError tError = new CError();
/* 100 */       tError.moduleName = "MLibraryDBSet";
/* 101 */       tError.functionName = "delete()";
/* 102 */       tError.errorMessage = ex.toString();
/* 103 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 106 */         pstmt.close(); } catch (Exception e) {
/* 107 */         e.printStackTrace();
/*     */       }
/* 109 */       if (!this.mflag) {
/*     */         try {
/* 111 */           this.con.close(); } catch (Exception e) {
/* 112 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 115 */       return false;
/*     */     }
/*     */ 
/* 118 */     if (!this.mflag) {
/*     */       try {
/* 120 */         this.con.close(); } catch (Exception e) {
/* 121 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 124 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 134 */     PreparedStatement pstmt = null;
/*     */ 
/* 136 */     if (!this.mflag) {
/* 137 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 142 */       int tCount = size();
/* 143 */       pstmt = this.con.prepareStatement("UPDATE MLibrary SET  FileID = ? , Name = ? , DisplayName = ? , FileDescription = ? , ManageCom = ? , BranchType = ? , NodeID = ? , FileType = ? , FilePath = ? , DocumentType = ? , StartDisplayDate = ? , EndDisplayDate = ? , MinDisplayGrade = ? , StartDisplayTime = ? , EndDisplayTime = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , State = ? WHERE  FileID = ?");
/* 144 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 146 */         if ((get(i).getFileID() == null) || (get(i).getFileID().equals("null")))
/* 147 */           pstmt.setString(1, null);
/*     */         else {
/* 149 */           pstmt.setString(1, get(i).getFileID());
/*     */         }
/* 151 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 152 */           pstmt.setString(2, null);
/*     */         else {
/* 154 */           pstmt.setString(2, get(i).getName());
/*     */         }
/* 156 */         if ((get(i).getDisplayName() == null) || (get(i).getDisplayName().equals("null")))
/* 157 */           pstmt.setString(3, null);
/*     */         else {
/* 159 */           pstmt.setString(3, get(i).getDisplayName());
/*     */         }
/* 161 */         if ((get(i).getFileDescription() == null) || (get(i).getFileDescription().equals("null")))
/* 162 */           pstmt.setString(4, null);
/*     */         else {
/* 164 */           pstmt.setString(4, get(i).getFileDescription());
/*     */         }
/* 166 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 167 */           pstmt.setString(5, null);
/*     */         else {
/* 169 */           pstmt.setString(5, get(i).getManageCom());
/*     */         }
/* 171 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 172 */           pstmt.setString(6, null);
/*     */         else {
/* 174 */           pstmt.setString(6, get(i).getBranchType());
/*     */         }
/* 176 */         if ((get(i).getNodeID() == null) || (get(i).getNodeID().equals("null")))
/* 177 */           pstmt.setString(7, null);
/*     */         else {
/* 179 */           pstmt.setString(7, get(i).getNodeID());
/*     */         }
/* 181 */         if ((get(i).getFileType() == null) || (get(i).getFileType().equals("null")))
/* 182 */           pstmt.setString(8, null);
/*     */         else {
/* 184 */           pstmt.setString(8, get(i).getFileType());
/*     */         }
/* 186 */         if ((get(i).getFilePath() == null) || (get(i).getFilePath().equals("null")))
/* 187 */           pstmt.setString(9, null);
/*     */         else {
/* 189 */           pstmt.setString(9, get(i).getFilePath());
/*     */         }
/* 191 */         if ((get(i).getDocumentType() == null) || (get(i).getDocumentType().equals("null")))
/* 192 */           pstmt.setString(10, null);
/*     */         else {
/* 194 */           pstmt.setString(10, get(i).getDocumentType());
/*     */         }
/* 196 */         if ((get(i).getStartDisplayDate() == null) || (get(i).getStartDisplayDate().equals("null")))
/* 197 */           pstmt.setDate(11, null);
/*     */         else {
/* 199 */           pstmt.setDate(11, Date.valueOf(get(i).getStartDisplayDate()));
/*     */         }
/* 201 */         if ((get(i).getEndDisplayDate() == null) || (get(i).getEndDisplayDate().equals("null")))
/* 202 */           pstmt.setDate(12, null);
/*     */         else {
/* 204 */           pstmt.setDate(12, Date.valueOf(get(i).getEndDisplayDate()));
/*     */         }
/* 206 */         if ((get(i).getMinDisplayGrade() == null) || (get(i).getMinDisplayGrade().equals("null")))
/* 207 */           pstmt.setString(13, null);
/*     */         else {
/* 209 */           pstmt.setString(13, get(i).getMinDisplayGrade());
/*     */         }
/* 211 */         if ((get(i).getStartDisplayTime() == null) || (get(i).getStartDisplayTime().equals("null")))
/* 212 */           pstmt.setString(14, null);
/*     */         else {
/* 214 */           pstmt.setString(14, get(i).getStartDisplayTime());
/*     */         }
/* 216 */         if ((get(i).getEndDisplayTime() == null) || (get(i).getEndDisplayTime().equals("null")))
/* 217 */           pstmt.setString(15, null);
/*     */         else {
/* 219 */           pstmt.setString(15, get(i).getEndDisplayTime());
/*     */         }
/* 221 */         if ((get(i).getCheckState() == null) || (get(i).getCheckState().equals("null")))
/* 222 */           pstmt.setString(16, null);
/*     */         else {
/* 224 */           pstmt.setString(16, get(i).getCheckState());
/*     */         }
/* 226 */         if ((get(i).getCheckOperator() == null) || (get(i).getCheckOperator().equals("null")))
/* 227 */           pstmt.setString(17, null);
/*     */         else {
/* 229 */           pstmt.setString(17, get(i).getCheckOperator());
/*     */         }
/* 231 */         if ((get(i).getCheckReason() == null) || (get(i).getCheckReason().equals("null")))
/* 232 */           pstmt.setString(18, null);
/*     */         else {
/* 234 */           pstmt.setString(18, get(i).getCheckReason());
/*     */         }
/* 236 */         if ((get(i).getCheckDate() == null) || (get(i).getCheckDate().equals("null")))
/* 237 */           pstmt.setDate(19, null);
/*     */         else {
/* 239 */           pstmt.setDate(19, Date.valueOf(get(i).getCheckDate()));
/*     */         }
/* 241 */         if ((get(i).getCheckTime() == null) || (get(i).getCheckTime().equals("null")))
/* 242 */           pstmt.setString(20, null);
/*     */         else {
/* 244 */           pstmt.setString(20, get(i).getCheckTime());
/*     */         }
/* 246 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 247 */           pstmt.setString(21, null);
/*     */         else {
/* 249 */           pstmt.setString(21, get(i).getVF01());
/*     */         }
/* 251 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 252 */           pstmt.setString(22, null);
/*     */         else {
/* 254 */           pstmt.setString(22, get(i).getNF01());
/*     */         }
/* 256 */         pstmt.setInt(23, get(i).getIF01());
/* 257 */         pstmt.setDouble(24, get(i).getDF02());
/* 258 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 259 */           pstmt.setDate(25, null);
/*     */         else {
/* 261 */           pstmt.setDate(25, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 263 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 264 */           pstmt.setString(26, null);
/*     */         else {
/* 266 */           pstmt.setString(26, get(i).getModifyOperator());
/*     */         }
/* 268 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 269 */           pstmt.setString(27, null);
/*     */         else {
/* 271 */           pstmt.setString(27, get(i).getOperator());
/*     */         }
/* 273 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 274 */           pstmt.setDate(28, null);
/*     */         else {
/* 276 */           pstmt.setDate(28, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 278 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 279 */           pstmt.setString(29, null);
/*     */         else {
/* 281 */           pstmt.setString(29, get(i).getMakeTime());
/*     */         }
/* 283 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 284 */           pstmt.setDate(30, null);
/*     */         else {
/* 286 */           pstmt.setDate(30, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 288 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 289 */           pstmt.setString(31, null);
/*     */         else {
/* 291 */           pstmt.setString(31, get(i).getModifyTime());
/*     */         }
/* 293 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 294 */           pstmt.setString(32, null);
/*     */         else {
/* 296 */           pstmt.setString(32, get(i).getState());
/*     */         }
/*     */ 
/* 299 */         if ((get(i).getFileID() == null) || (get(i).getFileID().equals("null")))
/* 300 */           pstmt.setString(33, null);
/*     */         else {
/* 302 */           pstmt.setString(33, get(i).getFileID());
/*     */         }
/* 304 */         pstmt.addBatch();
/*     */       }
/* 306 */       pstmt.executeBatch();
/* 307 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 310 */       ex.printStackTrace();
/* 311 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 312 */       CError tError = new CError();
/* 313 */       tError.moduleName = "MLibraryDBSet";
/* 314 */       tError.functionName = "update()";
/* 315 */       tError.errorMessage = ex.toString();
/* 316 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 319 */         pstmt.close(); } catch (Exception e) {
/* 320 */         e.printStackTrace();
/*     */       }
/* 322 */       if (!this.mflag) {
/*     */         try {
/* 324 */           this.con.close(); } catch (Exception e) {
/* 325 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 328 */       return false;
/*     */     }
/*     */ 
/* 331 */     if (!this.mflag) {
/*     */       try {
/* 333 */         this.con.close(); } catch (Exception e) {
/* 334 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 337 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 346 */     PreparedStatement pstmt = null;
/*     */ 
/* 348 */     if (!this.mflag) {
/* 349 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 354 */       int tCount = size();
/* 355 */       pstmt = this.con.prepareStatement("INSERT INTO MLibrary VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 356 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 358 */         if ((get(i).getFileID() == null) || (get(i).getFileID().equals("null")))
/* 359 */           pstmt.setString(1, null);
/*     */         else {
/* 361 */           pstmt.setString(1, get(i).getFileID());
/*     */         }
/* 363 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 364 */           pstmt.setString(2, null);
/*     */         else {
/* 366 */           pstmt.setString(2, get(i).getName());
/*     */         }
/* 368 */         if ((get(i).getDisplayName() == null) || (get(i).getDisplayName().equals("null")))
/* 369 */           pstmt.setString(3, null);
/*     */         else {
/* 371 */           pstmt.setString(3, get(i).getDisplayName());
/*     */         }
/* 373 */         if ((get(i).getFileDescription() == null) || (get(i).getFileDescription().equals("null")))
/* 374 */           pstmt.setString(4, null);
/*     */         else {
/* 376 */           pstmt.setString(4, get(i).getFileDescription());
/*     */         }
/* 378 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 379 */           pstmt.setString(5, null);
/*     */         else {
/* 381 */           pstmt.setString(5, get(i).getManageCom());
/*     */         }
/* 383 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 384 */           pstmt.setString(6, null);
/*     */         else {
/* 386 */           pstmt.setString(6, get(i).getBranchType());
/*     */         }
/* 388 */         if ((get(i).getNodeID() == null) || (get(i).getNodeID().equals("null")))
/* 389 */           pstmt.setString(7, null);
/*     */         else {
/* 391 */           pstmt.setString(7, get(i).getNodeID());
/*     */         }
/* 393 */         if ((get(i).getFileType() == null) || (get(i).getFileType().equals("null")))
/* 394 */           pstmt.setString(8, null);
/*     */         else {
/* 396 */           pstmt.setString(8, get(i).getFileType());
/*     */         }
/* 398 */         if ((get(i).getFilePath() == null) || (get(i).getFilePath().equals("null")))
/* 399 */           pstmt.setString(9, null);
/*     */         else {
/* 401 */           pstmt.setString(9, get(i).getFilePath());
/*     */         }
/* 403 */         if ((get(i).getDocumentType() == null) || (get(i).getDocumentType().equals("null")))
/* 404 */           pstmt.setString(10, null);
/*     */         else {
/* 406 */           pstmt.setString(10, get(i).getDocumentType());
/*     */         }
/* 408 */         if ((get(i).getStartDisplayDate() == null) || (get(i).getStartDisplayDate().equals("null")))
/* 409 */           pstmt.setDate(11, null);
/*     */         else {
/* 411 */           pstmt.setDate(11, Date.valueOf(get(i).getStartDisplayDate()));
/*     */         }
/* 413 */         if ((get(i).getEndDisplayDate() == null) || (get(i).getEndDisplayDate().equals("null")))
/* 414 */           pstmt.setDate(12, null);
/*     */         else {
/* 416 */           pstmt.setDate(12, Date.valueOf(get(i).getEndDisplayDate()));
/*     */         }
/* 418 */         if ((get(i).getMinDisplayGrade() == null) || (get(i).getMinDisplayGrade().equals("null")))
/* 419 */           pstmt.setString(13, null);
/*     */         else {
/* 421 */           pstmt.setString(13, get(i).getMinDisplayGrade());
/*     */         }
/* 423 */         if ((get(i).getStartDisplayTime() == null) || (get(i).getStartDisplayTime().equals("null")))
/* 424 */           pstmt.setString(14, null);
/*     */         else {
/* 426 */           pstmt.setString(14, get(i).getStartDisplayTime());
/*     */         }
/* 428 */         if ((get(i).getEndDisplayTime() == null) || (get(i).getEndDisplayTime().equals("null")))
/* 429 */           pstmt.setString(15, null);
/*     */         else {
/* 431 */           pstmt.setString(15, get(i).getEndDisplayTime());
/*     */         }
/* 433 */         if ((get(i).getCheckState() == null) || (get(i).getCheckState().equals("null")))
/* 434 */           pstmt.setString(16, null);
/*     */         else {
/* 436 */           pstmt.setString(16, get(i).getCheckState());
/*     */         }
/* 438 */         if ((get(i).getCheckOperator() == null) || (get(i).getCheckOperator().equals("null")))
/* 439 */           pstmt.setString(17, null);
/*     */         else {
/* 441 */           pstmt.setString(17, get(i).getCheckOperator());
/*     */         }
/* 443 */         if ((get(i).getCheckReason() == null) || (get(i).getCheckReason().equals("null")))
/* 444 */           pstmt.setString(18, null);
/*     */         else {
/* 446 */           pstmt.setString(18, get(i).getCheckReason());
/*     */         }
/* 448 */         if ((get(i).getCheckDate() == null) || (get(i).getCheckDate().equals("null")))
/* 449 */           pstmt.setDate(19, null);
/*     */         else {
/* 451 */           pstmt.setDate(19, Date.valueOf(get(i).getCheckDate()));
/*     */         }
/* 453 */         if ((get(i).getCheckTime() == null) || (get(i).getCheckTime().equals("null")))
/* 454 */           pstmt.setString(20, null);
/*     */         else {
/* 456 */           pstmt.setString(20, get(i).getCheckTime());
/*     */         }
/* 458 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 459 */           pstmt.setString(21, null);
/*     */         else {
/* 461 */           pstmt.setString(21, get(i).getVF01());
/*     */         }
/* 463 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 464 */           pstmt.setString(22, null);
/*     */         else {
/* 466 */           pstmt.setString(22, get(i).getNF01());
/*     */         }
/* 468 */         pstmt.setInt(23, get(i).getIF01());
/* 469 */         pstmt.setDouble(24, get(i).getDF02());
/* 470 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 471 */           pstmt.setDate(25, null);
/*     */         else {
/* 473 */           pstmt.setDate(25, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 475 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 476 */           pstmt.setString(26, null);
/*     */         else {
/* 478 */           pstmt.setString(26, get(i).getModifyOperator());
/*     */         }
/* 480 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 481 */           pstmt.setString(27, null);
/*     */         else {
/* 483 */           pstmt.setString(27, get(i).getOperator());
/*     */         }
/* 485 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 486 */           pstmt.setDate(28, null);
/*     */         else {
/* 488 */           pstmt.setDate(28, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 490 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 491 */           pstmt.setString(29, null);
/*     */         else {
/* 493 */           pstmt.setString(29, get(i).getMakeTime());
/*     */         }
/* 495 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 496 */           pstmt.setDate(30, null);
/*     */         else {
/* 498 */           pstmt.setDate(30, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 500 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 501 */           pstmt.setString(31, null);
/*     */         else {
/* 503 */           pstmt.setString(31, get(i).getModifyTime());
/*     */         }
/* 505 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 506 */           pstmt.setString(32, null);
/*     */         else {
/* 508 */           pstmt.setString(32, get(i).getState());
/*     */         }
/* 510 */         pstmt.addBatch();
/*     */       }
/* 512 */       pstmt.executeBatch();
/* 513 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 516 */       ex.printStackTrace();
/* 517 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 518 */       CError tError = new CError();
/* 519 */       tError.moduleName = "MLibraryDBSet";
/* 520 */       tError.functionName = "insert()";
/* 521 */       tError.errorMessage = ex.toString();
/* 522 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 525 */         pstmt.close(); } catch (Exception e) {
/* 526 */         e.printStackTrace();
/*     */       }
/* 528 */       if (!this.mflag) {
/*     */         try {
/* 530 */           this.con.close(); } catch (Exception e) {
/* 531 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 534 */       return false;
/*     */     }
/*     */ 
/* 537 */     if (!this.mflag) {
/*     */       try {
/* 539 */         this.con.close(); } catch (Exception e) {
/* 540 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 543 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MLibraryDBSet
 * JD-Core Version:    0.6.0
 */