/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MPublicMessageSchema;
/*     */ import com.sinosoft.map.lis.vschema.MPublicMessageSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MPublicMessageDBSet extends MPublicMessageSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MPublicMessageDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MPublicMessage");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MPublicMessageDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MPublicMessage");
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
/*  49 */     tError.moduleName = "MPublicMessageDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MPublicMessage WHERE  ID = ?");
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
/*  86 */       tError.moduleName = "MPublicMessageDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MPublicMessage SET  ID = ? , ManageCom = ? , ReceiveBranch = ? , BranchType = ? , Message = ? , Type = ? , Author = ? , State = ? , StartDate = ? , EndDate = ? , StartTime = ? , EndTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , Operator = ? , ModifyOperator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? WHERE  ID = ?");
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
/* 138 */         if ((get(i).getReceiveBranch() == null) || (get(i).getReceiveBranch().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getReceiveBranch());
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
/* 153 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 154 */           pstmt.setString(6, null);
/*     */         else {
/* 156 */           pstmt.setString(6, get(i).getType());
/*     */         }
/* 158 */         if ((get(i).getAuthor() == null) || (get(i).getAuthor().equals("null")))
/* 159 */           pstmt.setString(7, null);
/*     */         else {
/* 161 */           pstmt.setString(7, get(i).getAuthor());
/*     */         }
/* 163 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 164 */           pstmt.setString(8, null);
/*     */         else {
/* 166 */           pstmt.setString(8, get(i).getState());
/*     */         }
/* 168 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 169 */           pstmt.setDate(9, null);
/*     */         else {
/* 171 */           pstmt.setDate(9, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 173 */         if ((get(i).getEndDate() == null) || (get(i).getEndDate().equals("null")))
/* 174 */           pstmt.setDate(10, null);
/*     */         else {
/* 176 */           pstmt.setDate(10, Date.valueOf(get(i).getEndDate()));
/*     */         }
/* 178 */         if ((get(i).getStartTime() == null) || (get(i).getStartTime().equals("null")))
/* 179 */           pstmt.setString(11, null);
/*     */         else {
/* 181 */           pstmt.setString(11, get(i).getStartTime());
/*     */         }
/* 183 */         if ((get(i).getEndTime() == null) || (get(i).getEndTime().equals("null")))
/* 184 */           pstmt.setString(12, null);
/*     */         else {
/* 186 */           pstmt.setString(12, get(i).getEndTime());
/*     */         }
/* 188 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 189 */           pstmt.setString(13, null);
/*     */         else {
/* 191 */           pstmt.setString(13, get(i).getVF01());
/*     */         }
/* 193 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 194 */           pstmt.setString(14, null);
/*     */         else {
/* 196 */           pstmt.setString(14, get(i).getNF01());
/*     */         }
/* 198 */         pstmt.setInt(15, get(i).getIF01());
/* 199 */         pstmt.setDouble(16, get(i).getDF02());
/* 200 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 201 */           pstmt.setDate(17, null);
/*     */         else {
/* 203 */           pstmt.setDate(17, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 205 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 206 */           pstmt.setString(18, null);
/*     */         else {
/* 208 */           pstmt.setString(18, get(i).getOperator());
/*     */         }
/* 210 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 211 */           pstmt.setString(19, null);
/*     */         else {
/* 213 */           pstmt.setString(19, get(i).getModifyOperator());
/*     */         }
/* 215 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 216 */           pstmt.setDate(20, null);
/*     */         else {
/* 218 */           pstmt.setDate(20, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 220 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 221 */           pstmt.setString(21, null);
/*     */         else {
/* 223 */           pstmt.setString(21, get(i).getMakeTime());
/*     */         }
/* 225 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 226 */           pstmt.setDate(22, null);
/*     */         else {
/* 228 */           pstmt.setDate(22, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 230 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 231 */           pstmt.setString(23, null);
/*     */         else {
/* 233 */           pstmt.setString(23, get(i).getModifyTime());
/*     */         }
/* 235 */         if ((get(i).getCheckState() == null) || (get(i).getCheckState().equals("null")))
/* 236 */           pstmt.setString(24, null);
/*     */         else {
/* 238 */           pstmt.setString(24, get(i).getCheckState());
/*     */         }
/* 240 */         if ((get(i).getCheckOperator() == null) || (get(i).getCheckOperator().equals("null")))
/* 241 */           pstmt.setString(25, null);
/*     */         else {
/* 243 */           pstmt.setString(25, get(i).getCheckOperator());
/*     */         }
/* 245 */         if ((get(i).getCheckReason() == null) || (get(i).getCheckReason().equals("null")))
/* 246 */           pstmt.setString(26, null);
/*     */         else {
/* 248 */           pstmt.setString(26, get(i).getCheckReason());
/*     */         }
/* 250 */         if ((get(i).getCheckDate() == null) || (get(i).getCheckDate().equals("null")))
/* 251 */           pstmt.setDate(27, null);
/*     */         else {
/* 253 */           pstmt.setDate(27, Date.valueOf(get(i).getCheckDate()));
/*     */         }
/* 255 */         if ((get(i).getCheckTime() == null) || (get(i).getCheckTime().equals("null")))
/* 256 */           pstmt.setString(28, null);
/*     */         else {
/* 258 */           pstmt.setString(28, get(i).getCheckTime());
/*     */         }
/*     */ 
/* 261 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 262 */           pstmt.setString(29, null);
/*     */         else {
/* 264 */           pstmt.setString(29, get(i).getID());
/*     */         }
/* 266 */         pstmt.addBatch();
/*     */       }
/* 268 */       pstmt.executeBatch();
/* 269 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 272 */       ex.printStackTrace();
/* 273 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 274 */       CError tError = new CError();
/* 275 */       tError.moduleName = "MPublicMessageDBSet";
/* 276 */       tError.functionName = "update()";
/* 277 */       tError.errorMessage = ex.toString();
/* 278 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 281 */         pstmt.close(); } catch (Exception e) {
/* 282 */         e.printStackTrace();
/*     */       }
/* 284 */       if (!this.mflag) {
/*     */         try {
/* 286 */           this.con.close(); } catch (Exception e) {
/* 287 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 290 */       return false;
/*     */     }
/*     */ 
/* 293 */     if (!this.mflag) {
/*     */       try {
/* 295 */         this.con.close(); } catch (Exception e) {
/* 296 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 299 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 305 */     PreparedStatement pstmt = null;
/*     */ 
/* 307 */     if (!this.mflag) {
/* 308 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 313 */       int tCount = size();
/* 314 */       pstmt = this.con.prepareStatement("INSERT INTO MPublicMessage VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 315 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 317 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 318 */           pstmt.setString(1, null);
/*     */         else {
/* 320 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 322 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 323 */           pstmt.setString(2, null);
/*     */         else {
/* 325 */           pstmt.setString(2, get(i).getManageCom());
/*     */         }
/* 327 */         if ((get(i).getReceiveBranch() == null) || (get(i).getReceiveBranch().equals("null")))
/* 328 */           pstmt.setString(3, null);
/*     */         else {
/* 330 */           pstmt.setString(3, get(i).getReceiveBranch());
/*     */         }
/* 332 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 333 */           pstmt.setString(4, null);
/*     */         else {
/* 335 */           pstmt.setString(4, get(i).getBranchType());
/*     */         }
/* 337 */         if ((get(i).getMessage() == null) || (get(i).getMessage().equals("null")))
/* 338 */           pstmt.setString(5, null);
/*     */         else {
/* 340 */           pstmt.setString(5, get(i).getMessage());
/*     */         }
/* 342 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 343 */           pstmt.setString(6, null);
/*     */         else {
/* 345 */           pstmt.setString(6, get(i).getType());
/*     */         }
/* 347 */         if ((get(i).getAuthor() == null) || (get(i).getAuthor().equals("null")))
/* 348 */           pstmt.setString(7, null);
/*     */         else {
/* 350 */           pstmt.setString(7, get(i).getAuthor());
/*     */         }
/* 352 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 353 */           pstmt.setString(8, null);
/*     */         else {
/* 355 */           pstmt.setString(8, get(i).getState());
/*     */         }
/* 357 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 358 */           pstmt.setDate(9, null);
/*     */         else {
/* 360 */           pstmt.setDate(9, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 362 */         if ((get(i).getEndDate() == null) || (get(i).getEndDate().equals("null")))
/* 363 */           pstmt.setDate(10, null);
/*     */         else {
/* 365 */           pstmt.setDate(10, Date.valueOf(get(i).getEndDate()));
/*     */         }
/* 367 */         if ((get(i).getStartTime() == null) || (get(i).getStartTime().equals("null")))
/* 368 */           pstmt.setString(11, null);
/*     */         else {
/* 370 */           pstmt.setString(11, get(i).getStartTime());
/*     */         }
/* 372 */         if ((get(i).getEndTime() == null) || (get(i).getEndTime().equals("null")))
/* 373 */           pstmt.setString(12, null);
/*     */         else {
/* 375 */           pstmt.setString(12, get(i).getEndTime());
/*     */         }
/* 377 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 378 */           pstmt.setString(13, null);
/*     */         else {
/* 380 */           pstmt.setString(13, get(i).getVF01());
/*     */         }
/* 382 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 383 */           pstmt.setString(14, null);
/*     */         else {
/* 385 */           pstmt.setString(14, get(i).getNF01());
/*     */         }
/* 387 */         pstmt.setInt(15, get(i).getIF01());
/* 388 */         pstmt.setDouble(16, get(i).getDF02());
/* 389 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 390 */           pstmt.setDate(17, null);
/*     */         else {
/* 392 */           pstmt.setDate(17, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 394 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 395 */           pstmt.setString(18, null);
/*     */         else {
/* 397 */           pstmt.setString(18, get(i).getOperator());
/*     */         }
/* 399 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 400 */           pstmt.setString(19, null);
/*     */         else {
/* 402 */           pstmt.setString(19, get(i).getModifyOperator());
/*     */         }
/* 404 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 405 */           pstmt.setDate(20, null);
/*     */         else {
/* 407 */           pstmt.setDate(20, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 409 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 410 */           pstmt.setString(21, null);
/*     */         else {
/* 412 */           pstmt.setString(21, get(i).getMakeTime());
/*     */         }
/* 414 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 415 */           pstmt.setDate(22, null);
/*     */         else {
/* 417 */           pstmt.setDate(22, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 419 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 420 */           pstmt.setString(23, null);
/*     */         else {
/* 422 */           pstmt.setString(23, get(i).getModifyTime());
/*     */         }
/* 424 */         if ((get(i).getCheckState() == null) || (get(i).getCheckState().equals("null")))
/* 425 */           pstmt.setString(24, null);
/*     */         else {
/* 427 */           pstmt.setString(24, get(i).getCheckState());
/*     */         }
/* 429 */         if ((get(i).getCheckOperator() == null) || (get(i).getCheckOperator().equals("null")))
/* 430 */           pstmt.setString(25, null);
/*     */         else {
/* 432 */           pstmt.setString(25, get(i).getCheckOperator());
/*     */         }
/* 434 */         if ((get(i).getCheckReason() == null) || (get(i).getCheckReason().equals("null")))
/* 435 */           pstmt.setString(26, null);
/*     */         else {
/* 437 */           pstmt.setString(26, get(i).getCheckReason());
/*     */         }
/* 439 */         if ((get(i).getCheckDate() == null) || (get(i).getCheckDate().equals("null")))
/* 440 */           pstmt.setDate(27, null);
/*     */         else {
/* 442 */           pstmt.setDate(27, Date.valueOf(get(i).getCheckDate()));
/*     */         }
/* 444 */         if ((get(i).getCheckTime() == null) || (get(i).getCheckTime().equals("null")))
/* 445 */           pstmt.setString(28, null);
/*     */         else {
/* 447 */           pstmt.setString(28, get(i).getCheckTime());
/*     */         }
/* 449 */         pstmt.addBatch();
/*     */       }
/* 451 */       pstmt.executeBatch();
/* 452 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 455 */       ex.printStackTrace();
/* 456 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 457 */       CError tError = new CError();
/* 458 */       tError.moduleName = "MPublicMessageDBSet";
/* 459 */       tError.functionName = "insert()";
/* 460 */       tError.errorMessage = ex.toString();
/* 461 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 464 */         pstmt.close(); } catch (Exception e) {
/* 465 */         e.printStackTrace();
/*     */       }
/* 467 */       if (!this.mflag) {
/*     */         try {
/* 469 */           this.con.close(); } catch (Exception e) {
/* 470 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 473 */       return false;
/*     */     }
/*     */ 
/* 476 */     if (!this.mflag) {
/*     */       try {
/* 478 */         this.con.close(); } catch (Exception e) {
/* 479 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 482 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MPublicMessageDBSet
 * JD-Core Version:    0.6.0
 */