/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MPrivateMessageBSchema;
/*     */ import com.sinosoft.map.lis.vschema.MPrivateMessageBSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MPrivateMessageBDBSet extends MPrivateMessageBSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MPrivateMessageBDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MPrivateMessageB");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MPrivateMessageBDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MPrivateMessageB");
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
/*  49 */     tError.moduleName = "MPrivateMessageBDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MPrivateMessageB WHERE  ID = ?");
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
/*  86 */       tError.moduleName = "MPrivateMessageBDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MPrivateMessageB SET  ID = ? , AgentCode = ? , ManageCom = ? , BranchType = ? , Message = ? , MessageType = ? , KeyData = ? , KeyData2 = ? , KeyData3 = ? , KeyData4 = ? , URL = ? , Type = ? , State = ? , StartDate = ? , EndDate = ? , StartTime = ? , EndTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , Operator = ? , MakeDate = ? , MakeTime = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  ID = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 133 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getAgentCode());
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
/* 148 */         if ((get(i).getMessage() == null) || (get(i).getMessage().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getMessage());
/*     */         }
/* 153 */         if ((get(i).getMessageType() == null) || (get(i).getMessageType().equals("null")))
/* 154 */           pstmt.setString(6, null);
/*     */         else {
/* 156 */           pstmt.setString(6, get(i).getMessageType());
/*     */         }
/* 158 */         if ((get(i).getKeyData() == null) || (get(i).getKeyData().equals("null")))
/* 159 */           pstmt.setString(7, null);
/*     */         else {
/* 161 */           pstmt.setString(7, get(i).getKeyData());
/*     */         }
/* 163 */         if ((get(i).getKeyData2() == null) || (get(i).getKeyData2().equals("null")))
/* 164 */           pstmt.setString(8, null);
/*     */         else {
/* 166 */           pstmt.setString(8, get(i).getKeyData2());
/*     */         }
/* 168 */         if ((get(i).getKeyData3() == null) || (get(i).getKeyData3().equals("null")))
/* 169 */           pstmt.setString(9, null);
/*     */         else {
/* 171 */           pstmt.setString(9, get(i).getKeyData3());
/*     */         }
/* 173 */         if ((get(i).getKeyData4() == null) || (get(i).getKeyData4().equals("null")))
/* 174 */           pstmt.setString(10, null);
/*     */         else {
/* 176 */           pstmt.setString(10, get(i).getKeyData4());
/*     */         }
/* 178 */         if ((get(i).getURL() == null) || (get(i).getURL().equals("null")))
/* 179 */           pstmt.setString(11, null);
/*     */         else {
/* 181 */           pstmt.setString(11, get(i).getURL());
/*     */         }
/* 183 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 184 */           pstmt.setString(12, null);
/*     */         else {
/* 186 */           pstmt.setString(12, get(i).getType());
/*     */         }
/* 188 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 189 */           pstmt.setString(13, null);
/*     */         else {
/* 191 */           pstmt.setString(13, get(i).getState());
/*     */         }
/* 193 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 194 */           pstmt.setDate(14, null);
/*     */         else {
/* 196 */           pstmt.setDate(14, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 198 */         if ((get(i).getEndDate() == null) || (get(i).getEndDate().equals("null")))
/* 199 */           pstmt.setDate(15, null);
/*     */         else {
/* 201 */           pstmt.setDate(15, Date.valueOf(get(i).getEndDate()));
/*     */         }
/* 203 */         if ((get(i).getStartTime() == null) || (get(i).getStartTime().equals("null")))
/* 204 */           pstmt.setString(16, null);
/*     */         else {
/* 206 */           pstmt.setString(16, get(i).getStartTime());
/*     */         }
/* 208 */         if ((get(i).getEndTime() == null) || (get(i).getEndTime().equals("null")))
/* 209 */           pstmt.setString(17, null);
/*     */         else {
/* 211 */           pstmt.setString(17, get(i).getEndTime());
/*     */         }
/* 213 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 214 */           pstmt.setString(18, null);
/*     */         else {
/* 216 */           pstmt.setString(18, get(i).getVF01());
/*     */         }
/* 218 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 219 */           pstmt.setString(19, null);
/*     */         else {
/* 221 */           pstmt.setString(19, get(i).getNF01());
/*     */         }
/* 223 */         pstmt.setInt(20, get(i).getIF01());
/* 224 */         pstmt.setDouble(21, get(i).getDF02());
/* 225 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 226 */           pstmt.setDate(22, null);
/*     */         else {
/* 228 */           pstmt.setDate(22, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 230 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 231 */           pstmt.setString(23, null);
/*     */         else {
/* 233 */           pstmt.setString(23, get(i).getOperator());
/*     */         }
/* 235 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 236 */           pstmt.setDate(24, null);
/*     */         else {
/* 238 */           pstmt.setDate(24, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 240 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 241 */           pstmt.setString(25, null);
/*     */         else {
/* 243 */           pstmt.setString(25, get(i).getMakeTime());
/*     */         }
/* 245 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 246 */           pstmt.setString(26, null);
/*     */         else {
/* 248 */           pstmt.setString(26, get(i).getEdorNo());
/*     */         }
/* 250 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 251 */           pstmt.setString(27, null);
/*     */         else {
/* 253 */           pstmt.setString(27, get(i).getEdorType());
/*     */         }
/* 255 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 256 */           pstmt.setString(28, null);
/*     */         else {
/* 258 */           pstmt.setString(28, get(i).getEdorCase());
/*     */         }
/* 260 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 261 */           pstmt.setString(29, null);
/*     */         else {
/* 263 */           pstmt.setString(29, get(i).getOperator2());
/*     */         }
/* 265 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 266 */           pstmt.setDate(30, null);
/*     */         else {
/* 268 */           pstmt.setDate(30, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 270 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 271 */           pstmt.setString(31, null);
/*     */         else {
/* 273 */           pstmt.setString(31, get(i).getMakeTime2());
/*     */         }
/*     */ 
/* 276 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 277 */           pstmt.setString(32, null);
/*     */         else {
/* 279 */           pstmt.setString(32, get(i).getID());
/*     */         }
/* 281 */         pstmt.addBatch();
/*     */       }
/* 283 */       pstmt.executeBatch();
/* 284 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 287 */       ex.printStackTrace();
/* 288 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 289 */       CError tError = new CError();
/* 290 */       tError.moduleName = "MPrivateMessageBDBSet";
/* 291 */       tError.functionName = "update()";
/* 292 */       tError.errorMessage = ex.toString();
/* 293 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 296 */         pstmt.close(); } catch (Exception e) {
/* 297 */         e.printStackTrace();
/*     */       }
/* 299 */       if (!this.mflag) {
/*     */         try {
/* 301 */           this.con.close(); } catch (Exception e) {
/* 302 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 305 */       return false;
/*     */     }
/*     */ 
/* 308 */     if (!this.mflag) {
/*     */       try {
/* 310 */         this.con.close(); } catch (Exception e) {
/* 311 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 314 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 320 */     PreparedStatement pstmt = null;
/*     */ 
/* 322 */     if (!this.mflag) {
/* 323 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 328 */       int tCount = size();
/* 329 */       pstmt = this.con.prepareStatement("INSERT INTO MPrivateMessageB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 330 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 332 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 333 */           pstmt.setString(1, null);
/*     */         else {
/* 335 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 337 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/* 338 */           pstmt.setString(2, null);
/*     */         else {
/* 340 */           pstmt.setString(2, get(i).getAgentCode());
/*     */         }
/* 342 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 343 */           pstmt.setString(3, null);
/*     */         else {
/* 345 */           pstmt.setString(3, get(i).getManageCom());
/*     */         }
/* 347 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 348 */           pstmt.setString(4, null);
/*     */         else {
/* 350 */           pstmt.setString(4, get(i).getBranchType());
/*     */         }
/* 352 */         if ((get(i).getMessage() == null) || (get(i).getMessage().equals("null")))
/* 353 */           pstmt.setString(5, null);
/*     */         else {
/* 355 */           pstmt.setString(5, get(i).getMessage());
/*     */         }
/* 357 */         if ((get(i).getMessageType() == null) || (get(i).getMessageType().equals("null")))
/* 358 */           pstmt.setString(6, null);
/*     */         else {
/* 360 */           pstmt.setString(6, get(i).getMessageType());
/*     */         }
/* 362 */         if ((get(i).getKeyData() == null) || (get(i).getKeyData().equals("null")))
/* 363 */           pstmt.setString(7, null);
/*     */         else {
/* 365 */           pstmt.setString(7, get(i).getKeyData());
/*     */         }
/* 367 */         if ((get(i).getKeyData2() == null) || (get(i).getKeyData2().equals("null")))
/* 368 */           pstmt.setString(8, null);
/*     */         else {
/* 370 */           pstmt.setString(8, get(i).getKeyData2());
/*     */         }
/* 372 */         if ((get(i).getKeyData3() == null) || (get(i).getKeyData3().equals("null")))
/* 373 */           pstmt.setString(9, null);
/*     */         else {
/* 375 */           pstmt.setString(9, get(i).getKeyData3());
/*     */         }
/* 377 */         if ((get(i).getKeyData4() == null) || (get(i).getKeyData4().equals("null")))
/* 378 */           pstmt.setString(10, null);
/*     */         else {
/* 380 */           pstmt.setString(10, get(i).getKeyData4());
/*     */         }
/* 382 */         if ((get(i).getURL() == null) || (get(i).getURL().equals("null")))
/* 383 */           pstmt.setString(11, null);
/*     */         else {
/* 385 */           pstmt.setString(11, get(i).getURL());
/*     */         }
/* 387 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 388 */           pstmt.setString(12, null);
/*     */         else {
/* 390 */           pstmt.setString(12, get(i).getType());
/*     */         }
/* 392 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 393 */           pstmt.setString(13, null);
/*     */         else {
/* 395 */           pstmt.setString(13, get(i).getState());
/*     */         }
/* 397 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 398 */           pstmt.setDate(14, null);
/*     */         else {
/* 400 */           pstmt.setDate(14, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 402 */         if ((get(i).getEndDate() == null) || (get(i).getEndDate().equals("null")))
/* 403 */           pstmt.setDate(15, null);
/*     */         else {
/* 405 */           pstmt.setDate(15, Date.valueOf(get(i).getEndDate()));
/*     */         }
/* 407 */         if ((get(i).getStartTime() == null) || (get(i).getStartTime().equals("null")))
/* 408 */           pstmt.setString(16, null);
/*     */         else {
/* 410 */           pstmt.setString(16, get(i).getStartTime());
/*     */         }
/* 412 */         if ((get(i).getEndTime() == null) || (get(i).getEndTime().equals("null")))
/* 413 */           pstmt.setString(17, null);
/*     */         else {
/* 415 */           pstmt.setString(17, get(i).getEndTime());
/*     */         }
/* 417 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 418 */           pstmt.setString(18, null);
/*     */         else {
/* 420 */           pstmt.setString(18, get(i).getVF01());
/*     */         }
/* 422 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 423 */           pstmt.setString(19, null);
/*     */         else {
/* 425 */           pstmt.setString(19, get(i).getNF01());
/*     */         }
/* 427 */         pstmt.setInt(20, get(i).getIF01());
/* 428 */         pstmt.setDouble(21, get(i).getDF02());
/* 429 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 430 */           pstmt.setDate(22, null);
/*     */         else {
/* 432 */           pstmt.setDate(22, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 434 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 435 */           pstmt.setString(23, null);
/*     */         else {
/* 437 */           pstmt.setString(23, get(i).getOperator());
/*     */         }
/* 439 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 440 */           pstmt.setDate(24, null);
/*     */         else {
/* 442 */           pstmt.setDate(24, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 444 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 445 */           pstmt.setString(25, null);
/*     */         else {
/* 447 */           pstmt.setString(25, get(i).getMakeTime());
/*     */         }
/* 449 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 450 */           pstmt.setString(26, null);
/*     */         else {
/* 452 */           pstmt.setString(26, get(i).getEdorNo());
/*     */         }
/* 454 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 455 */           pstmt.setString(27, null);
/*     */         else {
/* 457 */           pstmt.setString(27, get(i).getEdorType());
/*     */         }
/* 459 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 460 */           pstmt.setString(28, null);
/*     */         else {
/* 462 */           pstmt.setString(28, get(i).getEdorCase());
/*     */         }
/* 464 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 465 */           pstmt.setString(29, null);
/*     */         else {
/* 467 */           pstmt.setString(29, get(i).getOperator2());
/*     */         }
/* 469 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 470 */           pstmt.setDate(30, null);
/*     */         else {
/* 472 */           pstmt.setDate(30, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 474 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 475 */           pstmt.setString(31, null);
/*     */         else {
/* 477 */           pstmt.setString(31, get(i).getMakeTime2());
/*     */         }
/* 479 */         pstmt.addBatch();
/*     */       }
/* 481 */       pstmt.executeBatch();
/* 482 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 485 */       ex.printStackTrace();
/* 486 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 487 */       CError tError = new CError();
/* 488 */       tError.moduleName = "MPrivateMessageBDBSet";
/* 489 */       tError.functionName = "insert()";
/* 490 */       tError.errorMessage = ex.toString();
/* 491 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 494 */         pstmt.close(); } catch (Exception e) {
/* 495 */         e.printStackTrace();
/*     */       }
/* 497 */       if (!this.mflag) {
/*     */         try {
/* 499 */           this.con.close(); } catch (Exception e) {
/* 500 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 503 */       return false;
/*     */     }
/*     */ 
/* 506 */     if (!this.mflag) {
/*     */       try {
/* 508 */         this.con.close(); } catch (Exception e) {
/* 509 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 512 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MPrivateMessageBDBSet
 * JD-Core Version:    0.6.0
 */