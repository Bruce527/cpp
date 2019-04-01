/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MLibraryBSchema;
/*     */ import com.sinosoft.map.lis.vschema.MLibraryBSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MLibraryBDBSet extends MLibraryBSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MLibraryBDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MLibraryB");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MLibraryBDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MLibraryB");
/*  35 */     this.con = this.db.getConnection();
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  40 */     if (this.db.deleteSQL(this))
/*     */     {
/*  42 */       return true;
/*     */     }
/*     */ 
/*  47 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*  48 */     CError tError = new CError();
/*  49 */     tError.moduleName = "MLibraryBDBSet";
/*  50 */     tError.functionName = "deleteSQL";
/*  51 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*  52 */     this.mErrors.addOneError(tError);
/*  53 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean delete()
/*     */   {
/*  60 */     PreparedStatement pstmt = null;
/*     */ 
/*  62 */     if (!this.mflag) {
/*  63 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  68 */       int tCount = size();
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MLibraryB WHERE  EdorNo = ?");
/*  70 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  72 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/*  73 */           pstmt.setString(1, null);
/*     */         else {
/*  75 */           pstmt.setString(1, get(i).getEdorNo());
/*     */         }
/*  77 */         pstmt.addBatch();
/*     */       }
/*  79 */       pstmt.executeBatch();
/*  80 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  83 */       ex.printStackTrace();
/*  84 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  85 */       CError tError = new CError();
/*  86 */       tError.moduleName = "MLibraryBDBSet";
/*  87 */       tError.functionName = "delete()";
/*  88 */       tError.errorMessage = ex.toString();
/*  89 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/*  92 */         pstmt.close(); } catch (Exception e) {
/*  93 */         e.printStackTrace();
/*     */       }
/*  95 */       if (!this.mflag) {
/*     */         try {
/*  97 */           this.con.close(); } catch (Exception e) {
/*  98 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 101 */       return false;
/*     */     }
/*     */ 
/* 104 */     if (!this.mflag) {
/*     */       try {
/* 106 */         this.con.close(); } catch (Exception e) {
/* 107 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 110 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 116 */     PreparedStatement pstmt = null;
/*     */ 
/* 118 */     if (!this.mflag) {
/* 119 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 124 */       int tCount = size();
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MLibraryB SET  EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? , FileID = ? , Name = ? , DisplayName = ? , FileDescription = ? , ManageCom = ? , BranchType = ? , NodeID = ? , FileType = ? , FilePath = ? , DocumentType = ? , StartDisplayDate = ? , EndDisplayDate = ? , MinDisplayGrade = ? , StartDisplayTime = ? , EndDisplayTime = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , State = ? WHERE  EdorNo = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getEdorNo());
/*     */         }
/* 133 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getEdorType());
/*     */         }
/* 138 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getEdorCase());
/*     */         }
/* 143 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getOperator2());
/*     */         }
/* 148 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 149 */           pstmt.setDate(5, null);
/*     */         else {
/* 151 */           pstmt.setDate(5, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 153 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 154 */           pstmt.setString(6, null);
/*     */         else {
/* 156 */           pstmt.setString(6, get(i).getMakeTime2());
/*     */         }
/* 158 */         if ((get(i).getFileID() == null) || (get(i).getFileID().equals("null")))
/* 159 */           pstmt.setString(7, null);
/*     */         else {
/* 161 */           pstmt.setString(7, get(i).getFileID());
/*     */         }
/* 163 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 164 */           pstmt.setString(8, null);
/*     */         else {
/* 166 */           pstmt.setString(8, get(i).getName());
/*     */         }
/* 168 */         if ((get(i).getDisplayName() == null) || (get(i).getDisplayName().equals("null")))
/* 169 */           pstmt.setString(9, null);
/*     */         else {
/* 171 */           pstmt.setString(9, get(i).getDisplayName());
/*     */         }
/* 173 */         if ((get(i).getFileDescription() == null) || (get(i).getFileDescription().equals("null")))
/* 174 */           pstmt.setString(10, null);
/*     */         else {
/* 176 */           pstmt.setString(10, get(i).getFileDescription());
/*     */         }
/* 178 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 179 */           pstmt.setString(11, null);
/*     */         else {
/* 181 */           pstmt.setString(11, get(i).getManageCom());
/*     */         }
/* 183 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 184 */           pstmt.setString(12, null);
/*     */         else {
/* 186 */           pstmt.setString(12, get(i).getBranchType());
/*     */         }
/* 188 */         if ((get(i).getNodeID() == null) || (get(i).getNodeID().equals("null")))
/* 189 */           pstmt.setString(13, null);
/*     */         else {
/* 191 */           pstmt.setString(13, get(i).getNodeID());
/*     */         }
/* 193 */         if ((get(i).getFileType() == null) || (get(i).getFileType().equals("null")))
/* 194 */           pstmt.setString(14, null);
/*     */         else {
/* 196 */           pstmt.setString(14, get(i).getFileType());
/*     */         }
/* 198 */         if ((get(i).getFilePath() == null) || (get(i).getFilePath().equals("null")))
/* 199 */           pstmt.setString(15, null);
/*     */         else {
/* 201 */           pstmt.setString(15, get(i).getFilePath());
/*     */         }
/* 203 */         if ((get(i).getDocumentType() == null) || (get(i).getDocumentType().equals("null")))
/* 204 */           pstmt.setString(16, null);
/*     */         else {
/* 206 */           pstmt.setString(16, get(i).getDocumentType());
/*     */         }
/* 208 */         if ((get(i).getStartDisplayDate() == null) || (get(i).getStartDisplayDate().equals("null")))
/* 209 */           pstmt.setDate(17, null);
/*     */         else {
/* 211 */           pstmt.setDate(17, Date.valueOf(get(i).getStartDisplayDate()));
/*     */         }
/* 213 */         if ((get(i).getEndDisplayDate() == null) || (get(i).getEndDisplayDate().equals("null")))
/* 214 */           pstmt.setDate(18, null);
/*     */         else {
/* 216 */           pstmt.setDate(18, Date.valueOf(get(i).getEndDisplayDate()));
/*     */         }
/* 218 */         if ((get(i).getMinDisplayGrade() == null) || (get(i).getMinDisplayGrade().equals("null")))
/* 219 */           pstmt.setString(19, null);
/*     */         else {
/* 221 */           pstmt.setString(19, get(i).getMinDisplayGrade());
/*     */         }
/* 223 */         if ((get(i).getStartDisplayTime() == null) || (get(i).getStartDisplayTime().equals("null")))
/* 224 */           pstmt.setString(20, null);
/*     */         else {
/* 226 */           pstmt.setString(20, get(i).getStartDisplayTime());
/*     */         }
/* 228 */         if ((get(i).getEndDisplayTime() == null) || (get(i).getEndDisplayTime().equals("null")))
/* 229 */           pstmt.setString(21, null);
/*     */         else {
/* 231 */           pstmt.setString(21, get(i).getEndDisplayTime());
/*     */         }
/* 233 */         if ((get(i).getCheckState() == null) || (get(i).getCheckState().equals("null")))
/* 234 */           pstmt.setString(22, null);
/*     */         else {
/* 236 */           pstmt.setString(22, get(i).getCheckState());
/*     */         }
/* 238 */         if ((get(i).getCheckOperator() == null) || (get(i).getCheckOperator().equals("null")))
/* 239 */           pstmt.setString(23, null);
/*     */         else {
/* 241 */           pstmt.setString(23, get(i).getCheckOperator());
/*     */         }
/* 243 */         if ((get(i).getCheckReason() == null) || (get(i).getCheckReason().equals("null")))
/* 244 */           pstmt.setString(24, null);
/*     */         else {
/* 246 */           pstmt.setString(24, get(i).getCheckReason());
/*     */         }
/* 248 */         if ((get(i).getCheckDate() == null) || (get(i).getCheckDate().equals("null")))
/* 249 */           pstmt.setDate(25, null);
/*     */         else {
/* 251 */           pstmt.setDate(25, Date.valueOf(get(i).getCheckDate()));
/*     */         }
/* 253 */         if ((get(i).getCheckTime() == null) || (get(i).getCheckTime().equals("null")))
/* 254 */           pstmt.setString(26, null);
/*     */         else {
/* 256 */           pstmt.setString(26, get(i).getCheckTime());
/*     */         }
/* 258 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 259 */           pstmt.setString(27, null);
/*     */         else {
/* 261 */           pstmt.setString(27, get(i).getVF01());
/*     */         }
/* 263 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 264 */           pstmt.setString(28, null);
/*     */         else {
/* 266 */           pstmt.setString(28, get(i).getNF01());
/*     */         }
/* 268 */         pstmt.setInt(29, get(i).getIF01());
/* 269 */         pstmt.setDouble(30, get(i).getDF02());
/* 270 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 271 */           pstmt.setDate(31, null);
/*     */         else {
/* 273 */           pstmt.setDate(31, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 275 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 276 */           pstmt.setString(32, null);
/*     */         else {
/* 278 */           pstmt.setString(32, get(i).getModifyOperator());
/*     */         }
/* 280 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 281 */           pstmt.setString(33, null);
/*     */         else {
/* 283 */           pstmt.setString(33, get(i).getOperator());
/*     */         }
/* 285 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 286 */           pstmt.setDate(34, null);
/*     */         else {
/* 288 */           pstmt.setDate(34, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 290 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 291 */           pstmt.setString(35, null);
/*     */         else {
/* 293 */           pstmt.setString(35, get(i).getMakeTime());
/*     */         }
/* 295 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 296 */           pstmt.setDate(36, null);
/*     */         else {
/* 298 */           pstmt.setDate(36, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 300 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 301 */           pstmt.setString(37, null);
/*     */         else {
/* 303 */           pstmt.setString(37, get(i).getModifyTime());
/*     */         }
/* 305 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 306 */           pstmt.setString(38, null);
/*     */         else {
/* 308 */           pstmt.setString(38, get(i).getState());
/*     */         }
/*     */ 
/* 311 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 312 */           pstmt.setString(39, null);
/*     */         else {
/* 314 */           pstmt.setString(39, get(i).getEdorNo());
/*     */         }
/* 316 */         pstmt.addBatch();
/*     */       }
/* 318 */       pstmt.executeBatch();
/* 319 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 322 */       ex.printStackTrace();
/* 323 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 324 */       CError tError = new CError();
/* 325 */       tError.moduleName = "MLibraryBDBSet";
/* 326 */       tError.functionName = "update()";
/* 327 */       tError.errorMessage = ex.toString();
/* 328 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 331 */         pstmt.close(); } catch (Exception e) {
/* 332 */         e.printStackTrace();
/*     */       }
/* 334 */       if (!this.mflag) {
/*     */         try {
/* 336 */           this.con.close(); } catch (Exception e) {
/* 337 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 340 */       return false;
/*     */     }
/*     */ 
/* 343 */     if (!this.mflag) {
/*     */       try {
/* 345 */         this.con.close(); } catch (Exception e) {
/* 346 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 349 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 355 */     PreparedStatement pstmt = null;
/*     */ 
/* 357 */     if (!this.mflag) {
/* 358 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 363 */       int tCount = size();
/* 364 */       pstmt = this.con.prepareStatement("INSERT INTO MLibraryB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 365 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 367 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 368 */           pstmt.setString(1, null);
/*     */         else {
/* 370 */           pstmt.setString(1, get(i).getEdorNo());
/*     */         }
/* 372 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 373 */           pstmt.setString(2, null);
/*     */         else {
/* 375 */           pstmt.setString(2, get(i).getEdorType());
/*     */         }
/* 377 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 378 */           pstmt.setString(3, null);
/*     */         else {
/* 380 */           pstmt.setString(3, get(i).getEdorCase());
/*     */         }
/* 382 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 383 */           pstmt.setString(4, null);
/*     */         else {
/* 385 */           pstmt.setString(4, get(i).getOperator2());
/*     */         }
/* 387 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 388 */           pstmt.setDate(5, null);
/*     */         else {
/* 390 */           pstmt.setDate(5, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 392 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 393 */           pstmt.setString(6, null);
/*     */         else {
/* 395 */           pstmt.setString(6, get(i).getMakeTime2());
/*     */         }
/* 397 */         if ((get(i).getFileID() == null) || (get(i).getFileID().equals("null")))
/* 398 */           pstmt.setString(7, null);
/*     */         else {
/* 400 */           pstmt.setString(7, get(i).getFileID());
/*     */         }
/* 402 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 403 */           pstmt.setString(8, null);
/*     */         else {
/* 405 */           pstmt.setString(8, get(i).getName());
/*     */         }
/* 407 */         if ((get(i).getDisplayName() == null) || (get(i).getDisplayName().equals("null")))
/* 408 */           pstmt.setString(9, null);
/*     */         else {
/* 410 */           pstmt.setString(9, get(i).getDisplayName());
/*     */         }
/* 412 */         if ((get(i).getFileDescription() == null) || (get(i).getFileDescription().equals("null")))
/* 413 */           pstmt.setString(10, null);
/*     */         else {
/* 415 */           pstmt.setString(10, get(i).getFileDescription());
/*     */         }
/* 417 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 418 */           pstmt.setString(11, null);
/*     */         else {
/* 420 */           pstmt.setString(11, get(i).getManageCom());
/*     */         }
/* 422 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 423 */           pstmt.setString(12, null);
/*     */         else {
/* 425 */           pstmt.setString(12, get(i).getBranchType());
/*     */         }
/* 427 */         if ((get(i).getNodeID() == null) || (get(i).getNodeID().equals("null")))
/* 428 */           pstmt.setString(13, null);
/*     */         else {
/* 430 */           pstmt.setString(13, get(i).getNodeID());
/*     */         }
/* 432 */         if ((get(i).getFileType() == null) || (get(i).getFileType().equals("null")))
/* 433 */           pstmt.setString(14, null);
/*     */         else {
/* 435 */           pstmt.setString(14, get(i).getFileType());
/*     */         }
/* 437 */         if ((get(i).getFilePath() == null) || (get(i).getFilePath().equals("null")))
/* 438 */           pstmt.setString(15, null);
/*     */         else {
/* 440 */           pstmt.setString(15, get(i).getFilePath());
/*     */         }
/* 442 */         if ((get(i).getDocumentType() == null) || (get(i).getDocumentType().equals("null")))
/* 443 */           pstmt.setString(16, null);
/*     */         else {
/* 445 */           pstmt.setString(16, get(i).getDocumentType());
/*     */         }
/* 447 */         if ((get(i).getStartDisplayDate() == null) || (get(i).getStartDisplayDate().equals("null")))
/* 448 */           pstmt.setDate(17, null);
/*     */         else {
/* 450 */           pstmt.setDate(17, Date.valueOf(get(i).getStartDisplayDate()));
/*     */         }
/* 452 */         if ((get(i).getEndDisplayDate() == null) || (get(i).getEndDisplayDate().equals("null")))
/* 453 */           pstmt.setDate(18, null);
/*     */         else {
/* 455 */           pstmt.setDate(18, Date.valueOf(get(i).getEndDisplayDate()));
/*     */         }
/* 457 */         if ((get(i).getMinDisplayGrade() == null) || (get(i).getMinDisplayGrade().equals("null")))
/* 458 */           pstmt.setString(19, null);
/*     */         else {
/* 460 */           pstmt.setString(19, get(i).getMinDisplayGrade());
/*     */         }
/* 462 */         if ((get(i).getStartDisplayTime() == null) || (get(i).getStartDisplayTime().equals("null")))
/* 463 */           pstmt.setString(20, null);
/*     */         else {
/* 465 */           pstmt.setString(20, get(i).getStartDisplayTime());
/*     */         }
/* 467 */         if ((get(i).getEndDisplayTime() == null) || (get(i).getEndDisplayTime().equals("null")))
/* 468 */           pstmt.setString(21, null);
/*     */         else {
/* 470 */           pstmt.setString(21, get(i).getEndDisplayTime());
/*     */         }
/* 472 */         if ((get(i).getCheckState() == null) || (get(i).getCheckState().equals("null")))
/* 473 */           pstmt.setString(22, null);
/*     */         else {
/* 475 */           pstmt.setString(22, get(i).getCheckState());
/*     */         }
/* 477 */         if ((get(i).getCheckOperator() == null) || (get(i).getCheckOperator().equals("null")))
/* 478 */           pstmt.setString(23, null);
/*     */         else {
/* 480 */           pstmt.setString(23, get(i).getCheckOperator());
/*     */         }
/* 482 */         if ((get(i).getCheckReason() == null) || (get(i).getCheckReason().equals("null")))
/* 483 */           pstmt.setString(24, null);
/*     */         else {
/* 485 */           pstmt.setString(24, get(i).getCheckReason());
/*     */         }
/* 487 */         if ((get(i).getCheckDate() == null) || (get(i).getCheckDate().equals("null")))
/* 488 */           pstmt.setDate(25, null);
/*     */         else {
/* 490 */           pstmt.setDate(25, Date.valueOf(get(i).getCheckDate()));
/*     */         }
/* 492 */         if ((get(i).getCheckTime() == null) || (get(i).getCheckTime().equals("null")))
/* 493 */           pstmt.setString(26, null);
/*     */         else {
/* 495 */           pstmt.setString(26, get(i).getCheckTime());
/*     */         }
/* 497 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 498 */           pstmt.setString(27, null);
/*     */         else {
/* 500 */           pstmt.setString(27, get(i).getVF01());
/*     */         }
/* 502 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 503 */           pstmt.setString(28, null);
/*     */         else {
/* 505 */           pstmt.setString(28, get(i).getNF01());
/*     */         }
/* 507 */         pstmt.setInt(29, get(i).getIF01());
/* 508 */         pstmt.setDouble(30, get(i).getDF02());
/* 509 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 510 */           pstmt.setDate(31, null);
/*     */         else {
/* 512 */           pstmt.setDate(31, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 514 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 515 */           pstmt.setString(32, null);
/*     */         else {
/* 517 */           pstmt.setString(32, get(i).getModifyOperator());
/*     */         }
/* 519 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 520 */           pstmt.setString(33, null);
/*     */         else {
/* 522 */           pstmt.setString(33, get(i).getOperator());
/*     */         }
/* 524 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 525 */           pstmt.setDate(34, null);
/*     */         else {
/* 527 */           pstmt.setDate(34, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 529 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 530 */           pstmt.setString(35, null);
/*     */         else {
/* 532 */           pstmt.setString(35, get(i).getMakeTime());
/*     */         }
/* 534 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 535 */           pstmt.setDate(36, null);
/*     */         else {
/* 537 */           pstmt.setDate(36, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 539 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 540 */           pstmt.setString(37, null);
/*     */         else {
/* 542 */           pstmt.setString(37, get(i).getModifyTime());
/*     */         }
/* 544 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 545 */           pstmt.setString(38, null);
/*     */         else {
/* 547 */           pstmt.setString(38, get(i).getState());
/*     */         }
/* 549 */         pstmt.addBatch();
/*     */       }
/* 551 */       pstmt.executeBatch();
/* 552 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 555 */       ex.printStackTrace();
/* 556 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 557 */       CError tError = new CError();
/* 558 */       tError.moduleName = "MLibraryBDBSet";
/* 559 */       tError.functionName = "insert()";
/* 560 */       tError.errorMessage = ex.toString();
/* 561 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 564 */         pstmt.close(); } catch (Exception e) {
/* 565 */         e.printStackTrace();
/*     */       }
/* 567 */       if (!this.mflag) {
/*     */         try {
/* 569 */           this.con.close(); } catch (Exception e) {
/* 570 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 573 */       return false;
/*     */     }
/*     */ 
/* 576 */     if (!this.mflag) {
/*     */       try {
/* 578 */         this.con.close(); } catch (Exception e) {
/* 579 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 582 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MLibraryBDBSet
 * JD-Core Version:    0.6.0
 */