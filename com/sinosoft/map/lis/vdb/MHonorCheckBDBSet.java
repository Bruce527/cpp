/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MHonorCheckBSchema;
/*     */ import com.sinosoft.map.lis.vschema.MHonorCheckBSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MHonorCheckBDBSet extends MHonorCheckBSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MHonorCheckBDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MHonorCheckB");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MHonorCheckBDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MHonorCheckB");
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
/*  49 */     tError.moduleName = "MHonorCheckBDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MHonorCheckB WHERE  EdorNo = ?");
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
/*  86 */       tError.moduleName = "MHonorCheckBDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MHonorCheckB SET  CheckID = ? , DataType = ? , StatYear = ? , StatBatch = ? , ManageCom = ? , BranchType = ? , StartDate = ? , EndDate = ? , CheckState = ? , InputState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  EdorNo = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getCheckID() == null) || (get(i).getCheckID().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getCheckID());
/*     */         }
/* 133 */         if ((get(i).getDataType() == null) || (get(i).getDataType().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getDataType());
/*     */         }
/* 138 */         if ((get(i).getStatYear() == null) || (get(i).getStatYear().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getStatYear());
/*     */         }
/* 143 */         if ((get(i).getStatBatch() == null) || (get(i).getStatBatch().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getStatBatch());
/*     */         }
/* 148 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getManageCom());
/*     */         }
/* 153 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 154 */           pstmt.setString(6, null);
/*     */         else {
/* 156 */           pstmt.setString(6, get(i).getBranchType());
/*     */         }
/* 158 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 159 */           pstmt.setDate(7, null);
/*     */         else {
/* 161 */           pstmt.setDate(7, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 163 */         if ((get(i).getEndDate() == null) || (get(i).getEndDate().equals("null")))
/* 164 */           pstmt.setDate(8, null);
/*     */         else {
/* 166 */           pstmt.setDate(8, Date.valueOf(get(i).getEndDate()));
/*     */         }
/* 168 */         if ((get(i).getCheckState() == null) || (get(i).getCheckState().equals("null")))
/* 169 */           pstmt.setString(9, null);
/*     */         else {
/* 171 */           pstmt.setString(9, get(i).getCheckState());
/*     */         }
/* 173 */         if ((get(i).getInputState() == null) || (get(i).getInputState().equals("null")))
/* 174 */           pstmt.setString(10, null);
/*     */         else {
/* 176 */           pstmt.setString(10, get(i).getInputState());
/*     */         }
/* 178 */         if ((get(i).getCheckOperator() == null) || (get(i).getCheckOperator().equals("null")))
/* 179 */           pstmt.setString(11, null);
/*     */         else {
/* 181 */           pstmt.setString(11, get(i).getCheckOperator());
/*     */         }
/* 183 */         if ((get(i).getCheckReason() == null) || (get(i).getCheckReason().equals("null")))
/* 184 */           pstmt.setString(12, null);
/*     */         else {
/* 186 */           pstmt.setString(12, get(i).getCheckReason());
/*     */         }
/* 188 */         if ((get(i).getCheckDate() == null) || (get(i).getCheckDate().equals("null")))
/* 189 */           pstmt.setDate(13, null);
/*     */         else {
/* 191 */           pstmt.setDate(13, Date.valueOf(get(i).getCheckDate()));
/*     */         }
/* 193 */         if ((get(i).getCheckTime() == null) || (get(i).getCheckTime().equals("null")))
/* 194 */           pstmt.setString(14, null);
/*     */         else {
/* 196 */           pstmt.setString(14, get(i).getCheckTime());
/*     */         }
/* 198 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 199 */           pstmt.setString(15, null);
/*     */         else {
/* 201 */           pstmt.setString(15, get(i).getEdorNo());
/*     */         }
/* 203 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 204 */           pstmt.setString(16, null);
/*     */         else {
/* 206 */           pstmt.setString(16, get(i).getEdorType());
/*     */         }
/* 208 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 209 */           pstmt.setString(17, null);
/*     */         else {
/* 211 */           pstmt.setString(17, get(i).getEdorCase());
/*     */         }
/* 213 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 214 */           pstmt.setString(18, null);
/*     */         else {
/* 216 */           pstmt.setString(18, get(i).getOperator2());
/*     */         }
/* 218 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 219 */           pstmt.setDate(19, null);
/*     */         else {
/* 221 */           pstmt.setDate(19, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 223 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 224 */           pstmt.setString(20, null);
/*     */         else {
/* 226 */           pstmt.setString(20, get(i).getMakeTime2());
/*     */         }
/* 228 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 229 */           pstmt.setString(21, null);
/*     */         else {
/* 231 */           pstmt.setString(21, get(i).getModifyOperator());
/*     */         }
/* 233 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 234 */           pstmt.setString(22, null);
/*     */         else {
/* 236 */           pstmt.setString(22, get(i).getOperator());
/*     */         }
/* 238 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 239 */           pstmt.setDate(23, null);
/*     */         else {
/* 241 */           pstmt.setDate(23, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 243 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 244 */           pstmt.setString(24, null);
/*     */         else {
/* 246 */           pstmt.setString(24, get(i).getMakeTime());
/*     */         }
/* 248 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 249 */           pstmt.setDate(25, null);
/*     */         else {
/* 251 */           pstmt.setDate(25, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 253 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 254 */           pstmt.setString(26, null);
/*     */         else {
/* 256 */           pstmt.setString(26, get(i).getModifyTime());
/*     */         }
/*     */ 
/* 259 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 260 */           pstmt.setString(27, null);
/*     */         else {
/* 262 */           pstmt.setString(27, get(i).getEdorNo());
/*     */         }
/* 264 */         pstmt.addBatch();
/*     */       }
/* 266 */       pstmt.executeBatch();
/* 267 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 270 */       ex.printStackTrace();
/* 271 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 272 */       CError tError = new CError();
/* 273 */       tError.moduleName = "MHonorCheckBDBSet";
/* 274 */       tError.functionName = "update()";
/* 275 */       tError.errorMessage = ex.toString();
/* 276 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 279 */         pstmt.close(); } catch (Exception e) {
/* 280 */         e.printStackTrace();
/*     */       }
/* 282 */       if (!this.mflag) {
/*     */         try {
/* 284 */           this.con.close(); } catch (Exception e) {
/* 285 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 288 */       return false;
/*     */     }
/*     */ 
/* 291 */     if (!this.mflag) {
/*     */       try {
/* 293 */         this.con.close(); } catch (Exception e) {
/* 294 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 297 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 303 */     PreparedStatement pstmt = null;
/*     */ 
/* 305 */     if (!this.mflag) {
/* 306 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 311 */       int tCount = size();
/* 312 */       pstmt = this.con.prepareStatement("INSERT INTO MHonorCheckB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 313 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 315 */         if ((get(i).getCheckID() == null) || (get(i).getCheckID().equals("null")))
/* 316 */           pstmt.setString(1, null);
/*     */         else {
/* 318 */           pstmt.setString(1, get(i).getCheckID());
/*     */         }
/* 320 */         if ((get(i).getDataType() == null) || (get(i).getDataType().equals("null")))
/* 321 */           pstmt.setString(2, null);
/*     */         else {
/* 323 */           pstmt.setString(2, get(i).getDataType());
/*     */         }
/* 325 */         if ((get(i).getStatYear() == null) || (get(i).getStatYear().equals("null")))
/* 326 */           pstmt.setString(3, null);
/*     */         else {
/* 328 */           pstmt.setString(3, get(i).getStatYear());
/*     */         }
/* 330 */         if ((get(i).getStatBatch() == null) || (get(i).getStatBatch().equals("null")))
/* 331 */           pstmt.setString(4, null);
/*     */         else {
/* 333 */           pstmt.setString(4, get(i).getStatBatch());
/*     */         }
/* 335 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 336 */           pstmt.setString(5, null);
/*     */         else {
/* 338 */           pstmt.setString(5, get(i).getManageCom());
/*     */         }
/* 340 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 341 */           pstmt.setString(6, null);
/*     */         else {
/* 343 */           pstmt.setString(6, get(i).getBranchType());
/*     */         }
/* 345 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 346 */           pstmt.setDate(7, null);
/*     */         else {
/* 348 */           pstmt.setDate(7, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 350 */         if ((get(i).getEndDate() == null) || (get(i).getEndDate().equals("null")))
/* 351 */           pstmt.setDate(8, null);
/*     */         else {
/* 353 */           pstmt.setDate(8, Date.valueOf(get(i).getEndDate()));
/*     */         }
/* 355 */         if ((get(i).getCheckState() == null) || (get(i).getCheckState().equals("null")))
/* 356 */           pstmt.setString(9, null);
/*     */         else {
/* 358 */           pstmt.setString(9, get(i).getCheckState());
/*     */         }
/* 360 */         if ((get(i).getInputState() == null) || (get(i).getInputState().equals("null")))
/* 361 */           pstmt.setString(10, null);
/*     */         else {
/* 363 */           pstmt.setString(10, get(i).getInputState());
/*     */         }
/* 365 */         if ((get(i).getCheckOperator() == null) || (get(i).getCheckOperator().equals("null")))
/* 366 */           pstmt.setString(11, null);
/*     */         else {
/* 368 */           pstmt.setString(11, get(i).getCheckOperator());
/*     */         }
/* 370 */         if ((get(i).getCheckReason() == null) || (get(i).getCheckReason().equals("null")))
/* 371 */           pstmt.setString(12, null);
/*     */         else {
/* 373 */           pstmt.setString(12, get(i).getCheckReason());
/*     */         }
/* 375 */         if ((get(i).getCheckDate() == null) || (get(i).getCheckDate().equals("null")))
/* 376 */           pstmt.setDate(13, null);
/*     */         else {
/* 378 */           pstmt.setDate(13, Date.valueOf(get(i).getCheckDate()));
/*     */         }
/* 380 */         if ((get(i).getCheckTime() == null) || (get(i).getCheckTime().equals("null")))
/* 381 */           pstmt.setString(14, null);
/*     */         else {
/* 383 */           pstmt.setString(14, get(i).getCheckTime());
/*     */         }
/* 385 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 386 */           pstmt.setString(15, null);
/*     */         else {
/* 388 */           pstmt.setString(15, get(i).getEdorNo());
/*     */         }
/* 390 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 391 */           pstmt.setString(16, null);
/*     */         else {
/* 393 */           pstmt.setString(16, get(i).getEdorType());
/*     */         }
/* 395 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 396 */           pstmt.setString(17, null);
/*     */         else {
/* 398 */           pstmt.setString(17, get(i).getEdorCase());
/*     */         }
/* 400 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 401 */           pstmt.setString(18, null);
/*     */         else {
/* 403 */           pstmt.setString(18, get(i).getOperator2());
/*     */         }
/* 405 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 406 */           pstmt.setDate(19, null);
/*     */         else {
/* 408 */           pstmt.setDate(19, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 410 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 411 */           pstmt.setString(20, null);
/*     */         else {
/* 413 */           pstmt.setString(20, get(i).getMakeTime2());
/*     */         }
/* 415 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 416 */           pstmt.setString(21, null);
/*     */         else {
/* 418 */           pstmt.setString(21, get(i).getModifyOperator());
/*     */         }
/* 420 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 421 */           pstmt.setString(22, null);
/*     */         else {
/* 423 */           pstmt.setString(22, get(i).getOperator());
/*     */         }
/* 425 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 426 */           pstmt.setDate(23, null);
/*     */         else {
/* 428 */           pstmt.setDate(23, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 430 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 431 */           pstmt.setString(24, null);
/*     */         else {
/* 433 */           pstmt.setString(24, get(i).getMakeTime());
/*     */         }
/* 435 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 436 */           pstmt.setDate(25, null);
/*     */         else {
/* 438 */           pstmt.setDate(25, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 440 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 441 */           pstmt.setString(26, null);
/*     */         else {
/* 443 */           pstmt.setString(26, get(i).getModifyTime());
/*     */         }
/* 445 */         pstmt.addBatch();
/*     */       }
/* 447 */       pstmt.executeBatch();
/* 448 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 451 */       ex.printStackTrace();
/* 452 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 453 */       CError tError = new CError();
/* 454 */       tError.moduleName = "MHonorCheckBDBSet";
/* 455 */       tError.functionName = "insert()";
/* 456 */       tError.errorMessage = ex.toString();
/* 457 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 460 */         pstmt.close(); } catch (Exception e) {
/* 461 */         e.printStackTrace();
/*     */       }
/* 463 */       if (!this.mflag) {
/*     */         try {
/* 465 */           this.con.close(); } catch (Exception e) {
/* 466 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 469 */       return false;
/*     */     }
/*     */ 
/* 472 */     if (!this.mflag) {
/*     */       try {
/* 474 */         this.con.close(); } catch (Exception e) {
/* 475 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 478 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MHonorCheckBDBSet
 * JD-Core Version:    0.6.0
 */