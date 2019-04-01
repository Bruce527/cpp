/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MPublicMessageBSchema;
/*     */ import com.sinosoft.map.lis.vschema.MPublicMessageBSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MPublicMessageBDBSet extends MPublicMessageBSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MPublicMessageBDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MPublicMessageB");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MPublicMessageBDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MPublicMessageB");
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
/*  49 */     tError.moduleName = "MPublicMessageBDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MPublicMessageB WHERE  EdorNo = ?");
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
/*  86 */       tError.moduleName = "MPublicMessageBDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MPublicMessageB SET  EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? , ID = ? , ReceiveBranch = ? , ManageCom = ? , BranchType = ? , Message = ? , Type = ? , Author = ? , State = ? , StartDate = ? , EndDate = ? , StartTime = ? , EndTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , Operator = ? , ModifyOperator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? WHERE  EdorNo = ?");
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
/* 158 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 159 */           pstmt.setString(7, null);
/*     */         else {
/* 161 */           pstmt.setString(7, get(i).getID());
/*     */         }
/* 163 */         if ((get(i).getReceiveBranch() == null) || (get(i).getReceiveBranch().equals("null")))
/* 164 */           pstmt.setString(8, null);
/*     */         else {
/* 166 */           pstmt.setString(8, get(i).getReceiveBranch());
/*     */         }
/* 168 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 169 */           pstmt.setString(9, null);
/*     */         else {
/* 171 */           pstmt.setString(9, get(i).getManageCom());
/*     */         }
/* 173 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 174 */           pstmt.setString(10, null);
/*     */         else {
/* 176 */           pstmt.setString(10, get(i).getBranchType());
/*     */         }
/* 178 */         if ((get(i).getMessage() == null) || (get(i).getMessage().equals("null")))
/* 179 */           pstmt.setString(11, null);
/*     */         else {
/* 181 */           pstmt.setString(11, get(i).getMessage());
/*     */         }
/* 183 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 184 */           pstmt.setString(12, null);
/*     */         else {
/* 186 */           pstmt.setString(12, get(i).getType());
/*     */         }
/* 188 */         if ((get(i).getAuthor() == null) || (get(i).getAuthor().equals("null")))
/* 189 */           pstmt.setString(13, null);
/*     */         else {
/* 191 */           pstmt.setString(13, get(i).getAuthor());
/*     */         }
/* 193 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 194 */           pstmt.setString(14, null);
/*     */         else {
/* 196 */           pstmt.setString(14, get(i).getState());
/*     */         }
/* 198 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 199 */           pstmt.setDate(15, null);
/*     */         else {
/* 201 */           pstmt.setDate(15, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 203 */         if ((get(i).getEndDate() == null) || (get(i).getEndDate().equals("null")))
/* 204 */           pstmt.setDate(16, null);
/*     */         else {
/* 206 */           pstmt.setDate(16, Date.valueOf(get(i).getEndDate()));
/*     */         }
/* 208 */         if ((get(i).getStartTime() == null) || (get(i).getStartTime().equals("null")))
/* 209 */           pstmt.setString(17, null);
/*     */         else {
/* 211 */           pstmt.setString(17, get(i).getStartTime());
/*     */         }
/* 213 */         if ((get(i).getEndTime() == null) || (get(i).getEndTime().equals("null")))
/* 214 */           pstmt.setString(18, null);
/*     */         else {
/* 216 */           pstmt.setString(18, get(i).getEndTime());
/*     */         }
/* 218 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 219 */           pstmt.setString(19, null);
/*     */         else {
/* 221 */           pstmt.setString(19, get(i).getVF01());
/*     */         }
/* 223 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 224 */           pstmt.setString(20, null);
/*     */         else {
/* 226 */           pstmt.setString(20, get(i).getNF01());
/*     */         }
/* 228 */         pstmt.setInt(21, get(i).getIF01());
/* 229 */         pstmt.setDouble(22, get(i).getDF02());
/* 230 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 231 */           pstmt.setDate(23, null);
/*     */         else {
/* 233 */           pstmt.setDate(23, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 235 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 236 */           pstmt.setString(24, null);
/*     */         else {
/* 238 */           pstmt.setString(24, get(i).getOperator());
/*     */         }
/* 240 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 241 */           pstmt.setString(25, null);
/*     */         else {
/* 243 */           pstmt.setString(25, get(i).getModifyOperator());
/*     */         }
/* 245 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 246 */           pstmt.setDate(26, null);
/*     */         else {
/* 248 */           pstmt.setDate(26, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 250 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 251 */           pstmt.setString(27, null);
/*     */         else {
/* 253 */           pstmt.setString(27, get(i).getMakeTime());
/*     */         }
/* 255 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 256 */           pstmt.setDate(28, null);
/*     */         else {
/* 258 */           pstmt.setDate(28, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 260 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 261 */           pstmt.setString(29, null);
/*     */         else {
/* 263 */           pstmt.setString(29, get(i).getModifyTime());
/*     */         }
/* 265 */         if ((get(i).getCheckState() == null) || (get(i).getCheckState().equals("null")))
/* 266 */           pstmt.setString(30, null);
/*     */         else {
/* 268 */           pstmt.setString(30, get(i).getCheckState());
/*     */         }
/* 270 */         if ((get(i).getCheckOperator() == null) || (get(i).getCheckOperator().equals("null")))
/* 271 */           pstmt.setString(31, null);
/*     */         else {
/* 273 */           pstmt.setString(31, get(i).getCheckOperator());
/*     */         }
/* 275 */         if ((get(i).getCheckReason() == null) || (get(i).getCheckReason().equals("null")))
/* 276 */           pstmt.setString(32, null);
/*     */         else {
/* 278 */           pstmt.setString(32, get(i).getCheckReason());
/*     */         }
/* 280 */         if ((get(i).getCheckDate() == null) || (get(i).getCheckDate().equals("null")))
/* 281 */           pstmt.setDate(33, null);
/*     */         else {
/* 283 */           pstmt.setDate(33, Date.valueOf(get(i).getCheckDate()));
/*     */         }
/* 285 */         if ((get(i).getCheckTime() == null) || (get(i).getCheckTime().equals("null")))
/* 286 */           pstmt.setString(34, null);
/*     */         else {
/* 288 */           pstmt.setString(34, get(i).getCheckTime());
/*     */         }
/*     */ 
/* 291 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 292 */           pstmt.setString(35, null);
/*     */         else {
/* 294 */           pstmt.setString(35, get(i).getEdorNo());
/*     */         }
/* 296 */         pstmt.addBatch();
/*     */       }
/* 298 */       pstmt.executeBatch();
/* 299 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 302 */       ex.printStackTrace();
/* 303 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 304 */       CError tError = new CError();
/* 305 */       tError.moduleName = "MPublicMessageBDBSet";
/* 306 */       tError.functionName = "update()";
/* 307 */       tError.errorMessage = ex.toString();
/* 308 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 311 */         pstmt.close(); } catch (Exception e) {
/* 312 */         e.printStackTrace();
/*     */       }
/* 314 */       if (!this.mflag) {
/*     */         try {
/* 316 */           this.con.close(); } catch (Exception e) {
/* 317 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 320 */       return false;
/*     */     }
/*     */ 
/* 323 */     if (!this.mflag) {
/*     */       try {
/* 325 */         this.con.close(); } catch (Exception e) {
/* 326 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 329 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 335 */     PreparedStatement pstmt = null;
/*     */ 
/* 337 */     if (!this.mflag) {
/* 338 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 343 */       int tCount = size();
/* 344 */       pstmt = this.con.prepareStatement("INSERT INTO MPublicMessageB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 345 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 347 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 348 */           pstmt.setString(1, null);
/*     */         else {
/* 350 */           pstmt.setString(1, get(i).getEdorNo());
/*     */         }
/* 352 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 353 */           pstmt.setString(2, null);
/*     */         else {
/* 355 */           pstmt.setString(2, get(i).getEdorType());
/*     */         }
/* 357 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 358 */           pstmt.setString(3, null);
/*     */         else {
/* 360 */           pstmt.setString(3, get(i).getEdorCase());
/*     */         }
/* 362 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 363 */           pstmt.setString(4, null);
/*     */         else {
/* 365 */           pstmt.setString(4, get(i).getOperator2());
/*     */         }
/* 367 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 368 */           pstmt.setDate(5, null);
/*     */         else {
/* 370 */           pstmt.setDate(5, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 372 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 373 */           pstmt.setString(6, null);
/*     */         else {
/* 375 */           pstmt.setString(6, get(i).getMakeTime2());
/*     */         }
/* 377 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 378 */           pstmt.setString(7, null);
/*     */         else {
/* 380 */           pstmt.setString(7, get(i).getID());
/*     */         }
/* 382 */         if ((get(i).getReceiveBranch() == null) || (get(i).getReceiveBranch().equals("null")))
/* 383 */           pstmt.setString(8, null);
/*     */         else {
/* 385 */           pstmt.setString(8, get(i).getReceiveBranch());
/*     */         }
/* 387 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 388 */           pstmt.setString(9, null);
/*     */         else {
/* 390 */           pstmt.setString(9, get(i).getManageCom());
/*     */         }
/* 392 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 393 */           pstmt.setString(10, null);
/*     */         else {
/* 395 */           pstmt.setString(10, get(i).getBranchType());
/*     */         }
/* 397 */         if ((get(i).getMessage() == null) || (get(i).getMessage().equals("null")))
/* 398 */           pstmt.setString(11, null);
/*     */         else {
/* 400 */           pstmt.setString(11, get(i).getMessage());
/*     */         }
/* 402 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 403 */           pstmt.setString(12, null);
/*     */         else {
/* 405 */           pstmt.setString(12, get(i).getType());
/*     */         }
/* 407 */         if ((get(i).getAuthor() == null) || (get(i).getAuthor().equals("null")))
/* 408 */           pstmt.setString(13, null);
/*     */         else {
/* 410 */           pstmt.setString(13, get(i).getAuthor());
/*     */         }
/* 412 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 413 */           pstmt.setString(14, null);
/*     */         else {
/* 415 */           pstmt.setString(14, get(i).getState());
/*     */         }
/* 417 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 418 */           pstmt.setDate(15, null);
/*     */         else {
/* 420 */           pstmt.setDate(15, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 422 */         if ((get(i).getEndDate() == null) || (get(i).getEndDate().equals("null")))
/* 423 */           pstmt.setDate(16, null);
/*     */         else {
/* 425 */           pstmt.setDate(16, Date.valueOf(get(i).getEndDate()));
/*     */         }
/* 427 */         if ((get(i).getStartTime() == null) || (get(i).getStartTime().equals("null")))
/* 428 */           pstmt.setString(17, null);
/*     */         else {
/* 430 */           pstmt.setString(17, get(i).getStartTime());
/*     */         }
/* 432 */         if ((get(i).getEndTime() == null) || (get(i).getEndTime().equals("null")))
/* 433 */           pstmt.setString(18, null);
/*     */         else {
/* 435 */           pstmt.setString(18, get(i).getEndTime());
/*     */         }
/* 437 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 438 */           pstmt.setString(19, null);
/*     */         else {
/* 440 */           pstmt.setString(19, get(i).getVF01());
/*     */         }
/* 442 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 443 */           pstmt.setString(20, null);
/*     */         else {
/* 445 */           pstmt.setString(20, get(i).getNF01());
/*     */         }
/* 447 */         pstmt.setInt(21, get(i).getIF01());
/* 448 */         pstmt.setDouble(22, get(i).getDF02());
/* 449 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 450 */           pstmt.setDate(23, null);
/*     */         else {
/* 452 */           pstmt.setDate(23, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 454 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 455 */           pstmt.setString(24, null);
/*     */         else {
/* 457 */           pstmt.setString(24, get(i).getOperator());
/*     */         }
/* 459 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 460 */           pstmt.setString(25, null);
/*     */         else {
/* 462 */           pstmt.setString(25, get(i).getModifyOperator());
/*     */         }
/* 464 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 465 */           pstmt.setDate(26, null);
/*     */         else {
/* 467 */           pstmt.setDate(26, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 469 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 470 */           pstmt.setString(27, null);
/*     */         else {
/* 472 */           pstmt.setString(27, get(i).getMakeTime());
/*     */         }
/* 474 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 475 */           pstmt.setDate(28, null);
/*     */         else {
/* 477 */           pstmt.setDate(28, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 479 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 480 */           pstmt.setString(29, null);
/*     */         else {
/* 482 */           pstmt.setString(29, get(i).getModifyTime());
/*     */         }
/* 484 */         if ((get(i).getCheckState() == null) || (get(i).getCheckState().equals("null")))
/* 485 */           pstmt.setString(30, null);
/*     */         else {
/* 487 */           pstmt.setString(30, get(i).getCheckState());
/*     */         }
/* 489 */         if ((get(i).getCheckOperator() == null) || (get(i).getCheckOperator().equals("null")))
/* 490 */           pstmt.setString(31, null);
/*     */         else {
/* 492 */           pstmt.setString(31, get(i).getCheckOperator());
/*     */         }
/* 494 */         if ((get(i).getCheckReason() == null) || (get(i).getCheckReason().equals("null")))
/* 495 */           pstmt.setString(32, null);
/*     */         else {
/* 497 */           pstmt.setString(32, get(i).getCheckReason());
/*     */         }
/* 499 */         if ((get(i).getCheckDate() == null) || (get(i).getCheckDate().equals("null")))
/* 500 */           pstmt.setDate(33, null);
/*     */         else {
/* 502 */           pstmt.setDate(33, Date.valueOf(get(i).getCheckDate()));
/*     */         }
/* 504 */         if ((get(i).getCheckTime() == null) || (get(i).getCheckTime().equals("null")))
/* 505 */           pstmt.setString(34, null);
/*     */         else {
/* 507 */           pstmt.setString(34, get(i).getCheckTime());
/*     */         }
/* 509 */         pstmt.addBatch();
/*     */       }
/* 511 */       pstmt.executeBatch();
/* 512 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 515 */       ex.printStackTrace();
/* 516 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 517 */       CError tError = new CError();
/* 518 */       tError.moduleName = "MPublicMessageBDBSet";
/* 519 */       tError.functionName = "insert()";
/* 520 */       tError.errorMessage = ex.toString();
/* 521 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 524 */         pstmt.close(); } catch (Exception e) {
/* 525 */         e.printStackTrace();
/*     */       }
/* 527 */       if (!this.mflag) {
/*     */         try {
/* 529 */           this.con.close(); } catch (Exception e) {
/* 530 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 533 */       return false;
/*     */     }
/*     */ 
/* 536 */     if (!this.mflag) {
/*     */       try {
/* 538 */         this.con.close(); } catch (Exception e) {
/* 539 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 542 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MPublicMessageBDBSet
 * JD-Core Version:    0.6.0
 */