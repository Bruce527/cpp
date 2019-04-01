/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MC2BMessageBSchema;
/*     */ import com.sinosoft.map.lis.vschema.MC2BMessageBSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MC2BMessageBDBSet extends MC2BMessageBSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MC2BMessageBDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MC2BMessageB");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MC2BMessageBDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MC2BMessageB");
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
/*  49 */     tError.moduleName = "MC2BMessageBDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MC2BMessageB WHERE  ID = ?");
/*  70 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  72 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/*  73 */           pstmt.setString(1, null);
/*     */         else {
/*  75 */           pstmt.setString(1, get(i).getID());
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
/*  86 */       tError.moduleName = "MC2BMessageBDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MC2BMessageB SET  ID = ? , ManageCom = ? , BranchType = ? , Message = ? , MessageType = ? , KeyData = ? , KeyData2 = ? , KeyData3 = ? , KeyData4 = ? , URL = ? , Type = ? , State = ? , StartDate = ? , EndDate = ? , StartTime = ? , EndTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , Operator = ? , MakeDate = ? , MakeTime = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  ID = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 133 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getManageCom());
/*     */         }
/* 138 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getBranchType());
/*     */         }
/* 143 */         if ((get(i).getMessage() == null) || (get(i).getMessage().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getMessage());
/*     */         }
/* 148 */         if ((get(i).getMessageType() == null) || (get(i).getMessageType().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getMessageType());
/*     */         }
/* 153 */         if ((get(i).getKeyData() == null) || (get(i).getKeyData().equals("null")))
/* 154 */           pstmt.setString(6, null);
/*     */         else {
/* 156 */           pstmt.setString(6, get(i).getKeyData());
/*     */         }
/* 158 */         if ((get(i).getKeyData2() == null) || (get(i).getKeyData2().equals("null")))
/* 159 */           pstmt.setString(7, null);
/*     */         else {
/* 161 */           pstmt.setString(7, get(i).getKeyData2());
/*     */         }
/* 163 */         if ((get(i).getKeyData3() == null) || (get(i).getKeyData3().equals("null")))
/* 164 */           pstmt.setString(8, null);
/*     */         else {
/* 166 */           pstmt.setString(8, get(i).getKeyData3());
/*     */         }
/* 168 */         if ((get(i).getKeyData4() == null) || (get(i).getKeyData4().equals("null")))
/* 169 */           pstmt.setString(9, null);
/*     */         else {
/* 171 */           pstmt.setString(9, get(i).getKeyData4());
/*     */         }
/* 173 */         if ((get(i).getURL() == null) || (get(i).getURL().equals("null")))
/* 174 */           pstmt.setString(10, null);
/*     */         else {
/* 176 */           pstmt.setString(10, get(i).getURL());
/*     */         }
/* 178 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 179 */           pstmt.setString(11, null);
/*     */         else {
/* 181 */           pstmt.setString(11, get(i).getType());
/*     */         }
/* 183 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 184 */           pstmt.setString(12, null);
/*     */         else {
/* 186 */           pstmt.setString(12, get(i).getState());
/*     */         }
/* 188 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 189 */           pstmt.setDate(13, null);
/*     */         else {
/* 191 */           pstmt.setDate(13, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 193 */         if ((get(i).getEndDate() == null) || (get(i).getEndDate().equals("null")))
/* 194 */           pstmt.setDate(14, null);
/*     */         else {
/* 196 */           pstmt.setDate(14, Date.valueOf(get(i).getEndDate()));
/*     */         }
/* 198 */         if ((get(i).getStartTime() == null) || (get(i).getStartTime().equals("null")))
/* 199 */           pstmt.setString(15, null);
/*     */         else {
/* 201 */           pstmt.setString(15, get(i).getStartTime());
/*     */         }
/* 203 */         if ((get(i).getEndTime() == null) || (get(i).getEndTime().equals("null")))
/* 204 */           pstmt.setString(16, null);
/*     */         else {
/* 206 */           pstmt.setString(16, get(i).getEndTime());
/*     */         }
/* 208 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 209 */           pstmt.setString(17, null);
/*     */         else {
/* 211 */           pstmt.setString(17, get(i).getVF01());
/*     */         }
/* 213 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 214 */           pstmt.setString(18, null);
/*     */         else {
/* 216 */           pstmt.setString(18, get(i).getNF01());
/*     */         }
/* 218 */         pstmt.setInt(19, get(i).getIF01());
/* 219 */         pstmt.setDouble(20, get(i).getDF02());
/* 220 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 221 */           pstmt.setDate(21, null);
/*     */         else {
/* 223 */           pstmt.setDate(21, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 225 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 226 */           pstmt.setString(22, null);
/*     */         else {
/* 228 */           pstmt.setString(22, get(i).getOperator());
/*     */         }
/* 230 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 231 */           pstmt.setDate(23, null);
/*     */         else {
/* 233 */           pstmt.setDate(23, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 235 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 236 */           pstmt.setString(24, null);
/*     */         else {
/* 238 */           pstmt.setString(24, get(i).getMakeTime());
/*     */         }
/* 240 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 241 */           pstmt.setString(25, null);
/*     */         else {
/* 243 */           pstmt.setString(25, get(i).getEdorNo());
/*     */         }
/* 245 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 246 */           pstmt.setString(26, null);
/*     */         else {
/* 248 */           pstmt.setString(26, get(i).getEdorType());
/*     */         }
/* 250 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 251 */           pstmt.setString(27, null);
/*     */         else {
/* 253 */           pstmt.setString(27, get(i).getEdorCase());
/*     */         }
/* 255 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 256 */           pstmt.setString(28, null);
/*     */         else {
/* 258 */           pstmt.setString(28, get(i).getOperator2());
/*     */         }
/* 260 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 261 */           pstmt.setDate(29, null);
/*     */         else {
/* 263 */           pstmt.setDate(29, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 265 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 266 */           pstmt.setString(30, null);
/*     */         else {
/* 268 */           pstmt.setString(30, get(i).getMakeTime2());
/*     */         }
/*     */ 
/* 271 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 272 */           pstmt.setString(31, null);
/*     */         else {
/* 274 */           pstmt.setString(31, get(i).getID());
/*     */         }
/* 276 */         pstmt.addBatch();
/*     */       }
/* 278 */       pstmt.executeBatch();
/* 279 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 282 */       ex.printStackTrace();
/* 283 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 284 */       CError tError = new CError();
/* 285 */       tError.moduleName = "MC2BMessageBDBSet";
/* 286 */       tError.functionName = "update()";
/* 287 */       tError.errorMessage = ex.toString();
/* 288 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 291 */         pstmt.close(); } catch (Exception e) {
/* 292 */         e.printStackTrace();
/*     */       }
/* 294 */       if (!this.mflag) {
/*     */         try {
/* 296 */           this.con.close(); } catch (Exception e) {
/* 297 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 300 */       return false;
/*     */     }
/*     */ 
/* 303 */     if (!this.mflag) {
/*     */       try {
/* 305 */         this.con.close(); } catch (Exception e) {
/* 306 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 309 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 315 */     PreparedStatement pstmt = null;
/*     */ 
/* 317 */     if (!this.mflag) {
/* 318 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 323 */       int tCount = size();
/* 324 */       pstmt = this.con.prepareStatement("INSERT INTO MC2BMessageB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 325 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 327 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 328 */           pstmt.setString(1, null);
/*     */         else {
/* 330 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 332 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 333 */           pstmt.setString(2, null);
/*     */         else {
/* 335 */           pstmt.setString(2, get(i).getManageCom());
/*     */         }
/* 337 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 338 */           pstmt.setString(3, null);
/*     */         else {
/* 340 */           pstmt.setString(3, get(i).getBranchType());
/*     */         }
/* 342 */         if ((get(i).getMessage() == null) || (get(i).getMessage().equals("null")))
/* 343 */           pstmt.setString(4, null);
/*     */         else {
/* 345 */           pstmt.setString(4, get(i).getMessage());
/*     */         }
/* 347 */         if ((get(i).getMessageType() == null) || (get(i).getMessageType().equals("null")))
/* 348 */           pstmt.setString(5, null);
/*     */         else {
/* 350 */           pstmt.setString(5, get(i).getMessageType());
/*     */         }
/* 352 */         if ((get(i).getKeyData() == null) || (get(i).getKeyData().equals("null")))
/* 353 */           pstmt.setString(6, null);
/*     */         else {
/* 355 */           pstmt.setString(6, get(i).getKeyData());
/*     */         }
/* 357 */         if ((get(i).getKeyData2() == null) || (get(i).getKeyData2().equals("null")))
/* 358 */           pstmt.setString(7, null);
/*     */         else {
/* 360 */           pstmt.setString(7, get(i).getKeyData2());
/*     */         }
/* 362 */         if ((get(i).getKeyData3() == null) || (get(i).getKeyData3().equals("null")))
/* 363 */           pstmt.setString(8, null);
/*     */         else {
/* 365 */           pstmt.setString(8, get(i).getKeyData3());
/*     */         }
/* 367 */         if ((get(i).getKeyData4() == null) || (get(i).getKeyData4().equals("null")))
/* 368 */           pstmt.setString(9, null);
/*     */         else {
/* 370 */           pstmt.setString(9, get(i).getKeyData4());
/*     */         }
/* 372 */         if ((get(i).getURL() == null) || (get(i).getURL().equals("null")))
/* 373 */           pstmt.setString(10, null);
/*     */         else {
/* 375 */           pstmt.setString(10, get(i).getURL());
/*     */         }
/* 377 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 378 */           pstmt.setString(11, null);
/*     */         else {
/* 380 */           pstmt.setString(11, get(i).getType());
/*     */         }
/* 382 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 383 */           pstmt.setString(12, null);
/*     */         else {
/* 385 */           pstmt.setString(12, get(i).getState());
/*     */         }
/* 387 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 388 */           pstmt.setDate(13, null);
/*     */         else {
/* 390 */           pstmt.setDate(13, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 392 */         if ((get(i).getEndDate() == null) || (get(i).getEndDate().equals("null")))
/* 393 */           pstmt.setDate(14, null);
/*     */         else {
/* 395 */           pstmt.setDate(14, Date.valueOf(get(i).getEndDate()));
/*     */         }
/* 397 */         if ((get(i).getStartTime() == null) || (get(i).getStartTime().equals("null")))
/* 398 */           pstmt.setString(15, null);
/*     */         else {
/* 400 */           pstmt.setString(15, get(i).getStartTime());
/*     */         }
/* 402 */         if ((get(i).getEndTime() == null) || (get(i).getEndTime().equals("null")))
/* 403 */           pstmt.setString(16, null);
/*     */         else {
/* 405 */           pstmt.setString(16, get(i).getEndTime());
/*     */         }
/* 407 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 408 */           pstmt.setString(17, null);
/*     */         else {
/* 410 */           pstmt.setString(17, get(i).getVF01());
/*     */         }
/* 412 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 413 */           pstmt.setString(18, null);
/*     */         else {
/* 415 */           pstmt.setString(18, get(i).getNF01());
/*     */         }
/* 417 */         pstmt.setInt(19, get(i).getIF01());
/* 418 */         pstmt.setDouble(20, get(i).getDF02());
/* 419 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 420 */           pstmt.setDate(21, null);
/*     */         else {
/* 422 */           pstmt.setDate(21, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 424 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 425 */           pstmt.setString(22, null);
/*     */         else {
/* 427 */           pstmt.setString(22, get(i).getOperator());
/*     */         }
/* 429 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 430 */           pstmt.setDate(23, null);
/*     */         else {
/* 432 */           pstmt.setDate(23, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 434 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 435 */           pstmt.setString(24, null);
/*     */         else {
/* 437 */           pstmt.setString(24, get(i).getMakeTime());
/*     */         }
/* 439 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 440 */           pstmt.setString(25, null);
/*     */         else {
/* 442 */           pstmt.setString(25, get(i).getEdorNo());
/*     */         }
/* 444 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 445 */           pstmt.setString(26, null);
/*     */         else {
/* 447 */           pstmt.setString(26, get(i).getEdorType());
/*     */         }
/* 449 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 450 */           pstmt.setString(27, null);
/*     */         else {
/* 452 */           pstmt.setString(27, get(i).getEdorCase());
/*     */         }
/* 454 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 455 */           pstmt.setString(28, null);
/*     */         else {
/* 457 */           pstmt.setString(28, get(i).getOperator2());
/*     */         }
/* 459 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 460 */           pstmt.setDate(29, null);
/*     */         else {
/* 462 */           pstmt.setDate(29, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 464 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 465 */           pstmt.setString(30, null);
/*     */         else {
/* 467 */           pstmt.setString(30, get(i).getMakeTime2());
/*     */         }
/* 469 */         pstmt.addBatch();
/*     */       }
/* 471 */       pstmt.executeBatch();
/* 472 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 475 */       ex.printStackTrace();
/* 476 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 477 */       CError tError = new CError();
/* 478 */       tError.moduleName = "MC2BMessageBDBSet";
/* 479 */       tError.functionName = "insert()";
/* 480 */       tError.errorMessage = ex.toString();
/* 481 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 484 */         pstmt.close(); } catch (Exception e) {
/* 485 */         e.printStackTrace();
/*     */       }
/* 487 */       if (!this.mflag) {
/*     */         try {
/* 489 */           this.con.close(); } catch (Exception e) {
/* 490 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 493 */       return false;
/*     */     }
/*     */ 
/* 496 */     if (!this.mflag) {
/*     */       try {
/* 498 */         this.con.close(); } catch (Exception e) {
/* 499 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 502 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MC2BMessageBDBSet
 * JD-Core Version:    0.6.0
 */