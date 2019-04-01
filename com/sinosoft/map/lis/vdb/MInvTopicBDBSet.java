/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MInvTopicBSchema;
/*     */ import com.sinosoft.map.lis.vschema.MInvTopicBSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MInvTopicBDBSet extends MInvTopicBSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MInvTopicBDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MInvTopicB");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MInvTopicBDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MInvTopicB");
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
/*  49 */     tError.moduleName = "MInvTopicBDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MInvTopicB WHERE  EdorNo = ?");
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
/*  86 */       tError.moduleName = "MInvTopicBDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MInvTopicB SET  TopicID = ? , Topic = ? , ManageCom = ? , BranchType = ? , Depiction = ? , Author = ? , Population = ? , StartDate = ? , EndDate = ? , InvType = ? , State = ? , InvState = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  EdorNo = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getTopicID() == null) || (get(i).getTopicID().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getTopicID());
/*     */         }
/* 133 */         if ((get(i).getTopic() == null) || (get(i).getTopic().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getTopic());
/*     */         }
/* 138 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getManageCom());
/*     */         }
/* 143 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getBranchType());
/*     */         }
/* 148 */         if ((get(i).getDepiction() == null) || (get(i).getDepiction().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getDepiction());
/*     */         }
/* 153 */         if ((get(i).getAuthor() == null) || (get(i).getAuthor().equals("null")))
/* 154 */           pstmt.setString(6, null);
/*     */         else {
/* 156 */           pstmt.setString(6, get(i).getAuthor());
/*     */         }
/* 158 */         pstmt.setInt(7, get(i).getPopulation());
/* 159 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 160 */           pstmt.setDate(8, null);
/*     */         else {
/* 162 */           pstmt.setDate(8, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 164 */         if ((get(i).getEndDate() == null) || (get(i).getEndDate().equals("null")))
/* 165 */           pstmt.setDate(9, null);
/*     */         else {
/* 167 */           pstmt.setDate(9, Date.valueOf(get(i).getEndDate()));
/*     */         }
/* 169 */         if ((get(i).getInvType() == null) || (get(i).getInvType().equals("null")))
/* 170 */           pstmt.setString(10, null);
/*     */         else {
/* 172 */           pstmt.setString(10, get(i).getInvType());
/*     */         }
/* 174 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 175 */           pstmt.setString(11, null);
/*     */         else {
/* 177 */           pstmt.setString(11, get(i).getState());
/*     */         }
/* 179 */         if ((get(i).getInvState() == null) || (get(i).getInvState().equals("null")))
/* 180 */           pstmt.setString(12, null);
/*     */         else {
/* 182 */           pstmt.setString(12, get(i).getInvState());
/*     */         }
/* 184 */         if ((get(i).getCheckState() == null) || (get(i).getCheckState().equals("null")))
/* 185 */           pstmt.setString(13, null);
/*     */         else {
/* 187 */           pstmt.setString(13, get(i).getCheckState());
/*     */         }
/* 189 */         if ((get(i).getCheckOperator() == null) || (get(i).getCheckOperator().equals("null")))
/* 190 */           pstmt.setString(14, null);
/*     */         else {
/* 192 */           pstmt.setString(14, get(i).getCheckOperator());
/*     */         }
/* 194 */         if ((get(i).getCheckReason() == null) || (get(i).getCheckReason().equals("null")))
/* 195 */           pstmt.setString(15, null);
/*     */         else {
/* 197 */           pstmt.setString(15, get(i).getCheckReason());
/*     */         }
/* 199 */         if ((get(i).getCheckDate() == null) || (get(i).getCheckDate().equals("null")))
/* 200 */           pstmt.setDate(16, null);
/*     */         else {
/* 202 */           pstmt.setDate(16, Date.valueOf(get(i).getCheckDate()));
/*     */         }
/* 204 */         if ((get(i).getCheckTime() == null) || (get(i).getCheckTime().equals("null")))
/* 205 */           pstmt.setString(17, null);
/*     */         else {
/* 207 */           pstmt.setString(17, get(i).getCheckTime());
/*     */         }
/* 209 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 210 */           pstmt.setString(18, null);
/*     */         else {
/* 212 */           pstmt.setString(18, get(i).getVF01());
/*     */         }
/* 214 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 215 */           pstmt.setString(19, null);
/*     */         else {
/* 217 */           pstmt.setString(19, get(i).getNF01());
/*     */         }
/* 219 */         pstmt.setInt(20, get(i).getIF01());
/* 220 */         pstmt.setDouble(21, get(i).getDF02());
/* 221 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 222 */           pstmt.setDate(22, null);
/*     */         else {
/* 224 */           pstmt.setDate(22, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 226 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 227 */           pstmt.setString(23, null);
/*     */         else {
/* 229 */           pstmt.setString(23, get(i).getModifyOperator());
/*     */         }
/* 231 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 232 */           pstmt.setString(24, null);
/*     */         else {
/* 234 */           pstmt.setString(24, get(i).getOperator());
/*     */         }
/* 236 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 237 */           pstmt.setDate(25, null);
/*     */         else {
/* 239 */           pstmt.setDate(25, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 241 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 242 */           pstmt.setString(26, null);
/*     */         else {
/* 244 */           pstmt.setString(26, get(i).getMakeTime());
/*     */         }
/* 246 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 247 */           pstmt.setDate(27, null);
/*     */         else {
/* 249 */           pstmt.setDate(27, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 251 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 252 */           pstmt.setString(28, null);
/*     */         else {
/* 254 */           pstmt.setString(28, get(i).getModifyTime());
/*     */         }
/* 256 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 257 */           pstmt.setString(29, null);
/*     */         else {
/* 259 */           pstmt.setString(29, get(i).getEdorNo());
/*     */         }
/* 261 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 262 */           pstmt.setString(30, null);
/*     */         else {
/* 264 */           pstmt.setString(30, get(i).getEdorType());
/*     */         }
/* 266 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 267 */           pstmt.setString(31, null);
/*     */         else {
/* 269 */           pstmt.setString(31, get(i).getEdorCase());
/*     */         }
/* 271 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 272 */           pstmt.setString(32, null);
/*     */         else {
/* 274 */           pstmt.setString(32, get(i).getOperator2());
/*     */         }
/* 276 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 277 */           pstmt.setDate(33, null);
/*     */         else {
/* 279 */           pstmt.setDate(33, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 281 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 282 */           pstmt.setString(34, null);
/*     */         else {
/* 284 */           pstmt.setString(34, get(i).getMakeTime2());
/*     */         }
/*     */ 
/* 287 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 288 */           pstmt.setString(35, null);
/*     */         else {
/* 290 */           pstmt.setString(35, get(i).getEdorNo());
/*     */         }
/* 292 */         pstmt.addBatch();
/*     */       }
/* 294 */       pstmt.executeBatch();
/* 295 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 298 */       ex.printStackTrace();
/* 299 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 300 */       CError tError = new CError();
/* 301 */       tError.moduleName = "MInvTopicBDBSet";
/* 302 */       tError.functionName = "update()";
/* 303 */       tError.errorMessage = ex.toString();
/* 304 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 307 */         pstmt.close(); } catch (Exception e) {
/* 308 */         e.printStackTrace();
/*     */       }
/* 310 */       if (!this.mflag) {
/*     */         try {
/* 312 */           this.con.close(); } catch (Exception e) {
/* 313 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 316 */       return false;
/*     */     }
/*     */ 
/* 319 */     if (!this.mflag) {
/*     */       try {
/* 321 */         this.con.close(); } catch (Exception e) {
/* 322 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 325 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 331 */     PreparedStatement pstmt = null;
/*     */ 
/* 333 */     if (!this.mflag) {
/* 334 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 339 */       int tCount = size();
/* 340 */       pstmt = this.con.prepareStatement("INSERT INTO MInvTopicB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 341 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 343 */         if ((get(i).getTopicID() == null) || (get(i).getTopicID().equals("null")))
/* 344 */           pstmt.setString(1, null);
/*     */         else {
/* 346 */           pstmt.setString(1, get(i).getTopicID());
/*     */         }
/* 348 */         if ((get(i).getTopic() == null) || (get(i).getTopic().equals("null")))
/* 349 */           pstmt.setString(2, null);
/*     */         else {
/* 351 */           pstmt.setString(2, get(i).getTopic());
/*     */         }
/* 353 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 354 */           pstmt.setString(3, null);
/*     */         else {
/* 356 */           pstmt.setString(3, get(i).getManageCom());
/*     */         }
/* 358 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 359 */           pstmt.setString(4, null);
/*     */         else {
/* 361 */           pstmt.setString(4, get(i).getBranchType());
/*     */         }
/* 363 */         if ((get(i).getDepiction() == null) || (get(i).getDepiction().equals("null")))
/* 364 */           pstmt.setString(5, null);
/*     */         else {
/* 366 */           pstmt.setString(5, get(i).getDepiction());
/*     */         }
/* 368 */         if ((get(i).getAuthor() == null) || (get(i).getAuthor().equals("null")))
/* 369 */           pstmt.setString(6, null);
/*     */         else {
/* 371 */           pstmt.setString(6, get(i).getAuthor());
/*     */         }
/* 373 */         pstmt.setInt(7, get(i).getPopulation());
/* 374 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 375 */           pstmt.setDate(8, null);
/*     */         else {
/* 377 */           pstmt.setDate(8, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 379 */         if ((get(i).getEndDate() == null) || (get(i).getEndDate().equals("null")))
/* 380 */           pstmt.setDate(9, null);
/*     */         else {
/* 382 */           pstmt.setDate(9, Date.valueOf(get(i).getEndDate()));
/*     */         }
/* 384 */         if ((get(i).getInvType() == null) || (get(i).getInvType().equals("null")))
/* 385 */           pstmt.setString(10, null);
/*     */         else {
/* 387 */           pstmt.setString(10, get(i).getInvType());
/*     */         }
/* 389 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 390 */           pstmt.setString(11, null);
/*     */         else {
/* 392 */           pstmt.setString(11, get(i).getState());
/*     */         }
/* 394 */         if ((get(i).getInvState() == null) || (get(i).getInvState().equals("null")))
/* 395 */           pstmt.setString(12, null);
/*     */         else {
/* 397 */           pstmt.setString(12, get(i).getInvState());
/*     */         }
/* 399 */         if ((get(i).getCheckState() == null) || (get(i).getCheckState().equals("null")))
/* 400 */           pstmt.setString(13, null);
/*     */         else {
/* 402 */           pstmt.setString(13, get(i).getCheckState());
/*     */         }
/* 404 */         if ((get(i).getCheckOperator() == null) || (get(i).getCheckOperator().equals("null")))
/* 405 */           pstmt.setString(14, null);
/*     */         else {
/* 407 */           pstmt.setString(14, get(i).getCheckOperator());
/*     */         }
/* 409 */         if ((get(i).getCheckReason() == null) || (get(i).getCheckReason().equals("null")))
/* 410 */           pstmt.setString(15, null);
/*     */         else {
/* 412 */           pstmt.setString(15, get(i).getCheckReason());
/*     */         }
/* 414 */         if ((get(i).getCheckDate() == null) || (get(i).getCheckDate().equals("null")))
/* 415 */           pstmt.setDate(16, null);
/*     */         else {
/* 417 */           pstmt.setDate(16, Date.valueOf(get(i).getCheckDate()));
/*     */         }
/* 419 */         if ((get(i).getCheckTime() == null) || (get(i).getCheckTime().equals("null")))
/* 420 */           pstmt.setString(17, null);
/*     */         else {
/* 422 */           pstmt.setString(17, get(i).getCheckTime());
/*     */         }
/* 424 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 425 */           pstmt.setString(18, null);
/*     */         else {
/* 427 */           pstmt.setString(18, get(i).getVF01());
/*     */         }
/* 429 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 430 */           pstmt.setString(19, null);
/*     */         else {
/* 432 */           pstmt.setString(19, get(i).getNF01());
/*     */         }
/* 434 */         pstmt.setInt(20, get(i).getIF01());
/* 435 */         pstmt.setDouble(21, get(i).getDF02());
/* 436 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 437 */           pstmt.setDate(22, null);
/*     */         else {
/* 439 */           pstmt.setDate(22, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 441 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 442 */           pstmt.setString(23, null);
/*     */         else {
/* 444 */           pstmt.setString(23, get(i).getModifyOperator());
/*     */         }
/* 446 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 447 */           pstmt.setString(24, null);
/*     */         else {
/* 449 */           pstmt.setString(24, get(i).getOperator());
/*     */         }
/* 451 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 452 */           pstmt.setDate(25, null);
/*     */         else {
/* 454 */           pstmt.setDate(25, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 456 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 457 */           pstmt.setString(26, null);
/*     */         else {
/* 459 */           pstmt.setString(26, get(i).getMakeTime());
/*     */         }
/* 461 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 462 */           pstmt.setDate(27, null);
/*     */         else {
/* 464 */           pstmt.setDate(27, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 466 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 467 */           pstmt.setString(28, null);
/*     */         else {
/* 469 */           pstmt.setString(28, get(i).getModifyTime());
/*     */         }
/* 471 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 472 */           pstmt.setString(29, null);
/*     */         else {
/* 474 */           pstmt.setString(29, get(i).getEdorNo());
/*     */         }
/* 476 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 477 */           pstmt.setString(30, null);
/*     */         else {
/* 479 */           pstmt.setString(30, get(i).getEdorType());
/*     */         }
/* 481 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 482 */           pstmt.setString(31, null);
/*     */         else {
/* 484 */           pstmt.setString(31, get(i).getEdorCase());
/*     */         }
/* 486 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 487 */           pstmt.setString(32, null);
/*     */         else {
/* 489 */           pstmt.setString(32, get(i).getOperator2());
/*     */         }
/* 491 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 492 */           pstmt.setDate(33, null);
/*     */         else {
/* 494 */           pstmt.setDate(33, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 496 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 497 */           pstmt.setString(34, null);
/*     */         else {
/* 499 */           pstmt.setString(34, get(i).getMakeTime2());
/*     */         }
/* 501 */         pstmt.addBatch();
/*     */       }
/* 503 */       pstmt.executeBatch();
/* 504 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 507 */       ex.printStackTrace();
/* 508 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 509 */       CError tError = new CError();
/* 510 */       tError.moduleName = "MInvTopicBDBSet";
/* 511 */       tError.functionName = "insert()";
/* 512 */       tError.errorMessage = ex.toString();
/* 513 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 516 */         pstmt.close(); } catch (Exception e) {
/* 517 */         e.printStackTrace();
/*     */       }
/* 519 */       if (!this.mflag) {
/*     */         try {
/* 521 */           this.con.close(); } catch (Exception e) {
/* 522 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 525 */       return false;
/*     */     }
/*     */ 
/* 528 */     if (!this.mflag) {
/*     */       try {
/* 530 */         this.con.close(); } catch (Exception e) {
/* 531 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 534 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MInvTopicBDBSet
 * JD-Core Version:    0.6.0
 */