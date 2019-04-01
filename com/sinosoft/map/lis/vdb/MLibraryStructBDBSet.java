/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MLibraryStructBSchema;
/*     */ import com.sinosoft.map.lis.vschema.MLibraryStructBSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MLibraryStructBDBSet extends MLibraryStructBSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MLibraryStructBDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MLibraryStructB");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MLibraryStructBDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MLibraryStructB");
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
/*  49 */     tError.moduleName = "MLibraryStructBDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MLibraryStructB WHERE  EdorNo = ?");
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
/*  86 */       tError.moduleName = "MLibraryStructBDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MLibraryStructB SET  NodeID = ? , Name = ? , ParentID = ? , Discription = ? , ManageCom = ? , BranchType = ? , Position = ? , Operation = ? , DirFlag = ? , FileFlag = ? , ChildDirNum = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  EdorNo = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getNodeID() == null) || (get(i).getNodeID().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getNodeID());
/*     */         }
/* 133 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getName());
/*     */         }
/* 138 */         if ((get(i).getParentID() == null) || (get(i).getParentID().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getParentID());
/*     */         }
/* 143 */         if ((get(i).getDiscription() == null) || (get(i).getDiscription().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getDiscription());
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
/* 158 */         pstmt.setInt(7, get(i).getPosition());
/* 159 */         if ((get(i).getOperation() == null) || (get(i).getOperation().equals("null")))
/* 160 */           pstmt.setString(8, null);
/*     */         else {
/* 162 */           pstmt.setString(8, get(i).getOperation());
/*     */         }
/* 164 */         if ((get(i).getDirFlag() == null) || (get(i).getDirFlag().equals("null")))
/* 165 */           pstmt.setString(9, null);
/*     */         else {
/* 167 */           pstmt.setString(9, get(i).getDirFlag());
/*     */         }
/* 169 */         if ((get(i).getFileFlag() == null) || (get(i).getFileFlag().equals("null")))
/* 170 */           pstmt.setString(10, null);
/*     */         else {
/* 172 */           pstmt.setString(10, get(i).getFileFlag());
/*     */         }
/* 174 */         pstmt.setInt(11, get(i).getChildDirNum());
/* 175 */         if ((get(i).getCheckState() == null) || (get(i).getCheckState().equals("null")))
/* 176 */           pstmt.setString(12, null);
/*     */         else {
/* 178 */           pstmt.setString(12, get(i).getCheckState());
/*     */         }
/* 180 */         if ((get(i).getCheckOperator() == null) || (get(i).getCheckOperator().equals("null")))
/* 181 */           pstmt.setString(13, null);
/*     */         else {
/* 183 */           pstmt.setString(13, get(i).getCheckOperator());
/*     */         }
/* 185 */         if ((get(i).getCheckReason() == null) || (get(i).getCheckReason().equals("null")))
/* 186 */           pstmt.setString(14, null);
/*     */         else {
/* 188 */           pstmt.setString(14, get(i).getCheckReason());
/*     */         }
/* 190 */         if ((get(i).getCheckDate() == null) || (get(i).getCheckDate().equals("null")))
/* 191 */           pstmt.setDate(15, null);
/*     */         else {
/* 193 */           pstmt.setDate(15, Date.valueOf(get(i).getCheckDate()));
/*     */         }
/* 195 */         if ((get(i).getCheckTime() == null) || (get(i).getCheckTime().equals("null")))
/* 196 */           pstmt.setString(16, null);
/*     */         else {
/* 198 */           pstmt.setString(16, get(i).getCheckTime());
/*     */         }
/* 200 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 201 */           pstmt.setString(17, null);
/*     */         else {
/* 203 */           pstmt.setString(17, get(i).getVF01());
/*     */         }
/* 205 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 206 */           pstmt.setString(18, null);
/*     */         else {
/* 208 */           pstmt.setString(18, get(i).getNF01());
/*     */         }
/* 210 */         pstmt.setInt(19, get(i).getIF01());
/* 211 */         pstmt.setDouble(20, get(i).getDF02());
/* 212 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 213 */           pstmt.setDate(21, null);
/*     */         else {
/* 215 */           pstmt.setDate(21, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 217 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 218 */           pstmt.setString(22, null);
/*     */         else {
/* 220 */           pstmt.setString(22, get(i).getModifyOperator());
/*     */         }
/* 222 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 223 */           pstmt.setString(23, null);
/*     */         else {
/* 225 */           pstmt.setString(23, get(i).getOperator());
/*     */         }
/* 227 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 228 */           pstmt.setDate(24, null);
/*     */         else {
/* 230 */           pstmt.setDate(24, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 232 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 233 */           pstmt.setString(25, null);
/*     */         else {
/* 235 */           pstmt.setString(25, get(i).getMakeTime());
/*     */         }
/* 237 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 238 */           pstmt.setDate(26, null);
/*     */         else {
/* 240 */           pstmt.setDate(26, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 242 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 243 */           pstmt.setString(27, null);
/*     */         else {
/* 245 */           pstmt.setString(27, get(i).getModifyTime());
/*     */         }
/* 247 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 248 */           pstmt.setString(28, null);
/*     */         else {
/* 250 */           pstmt.setString(28, get(i).getEdorNo());
/*     */         }
/* 252 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 253 */           pstmt.setString(29, null);
/*     */         else {
/* 255 */           pstmt.setString(29, get(i).getEdorType());
/*     */         }
/* 257 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 258 */           pstmt.setString(30, null);
/*     */         else {
/* 260 */           pstmt.setString(30, get(i).getEdorCase());
/*     */         }
/* 262 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 263 */           pstmt.setString(31, null);
/*     */         else {
/* 265 */           pstmt.setString(31, get(i).getOperator2());
/*     */         }
/* 267 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 268 */           pstmt.setDate(32, null);
/*     */         else {
/* 270 */           pstmt.setDate(32, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 272 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 273 */           pstmt.setString(33, null);
/*     */         else {
/* 275 */           pstmt.setString(33, get(i).getMakeTime2());
/*     */         }
/*     */ 
/* 278 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 279 */           pstmt.setString(34, null);
/*     */         else {
/* 281 */           pstmt.setString(34, get(i).getEdorNo());
/*     */         }
/* 283 */         pstmt.addBatch();
/*     */       }
/* 285 */       pstmt.executeBatch();
/* 286 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 289 */       ex.printStackTrace();
/* 290 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 291 */       CError tError = new CError();
/* 292 */       tError.moduleName = "MLibraryStructBDBSet";
/* 293 */       tError.functionName = "update()";
/* 294 */       tError.errorMessage = ex.toString();
/* 295 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 298 */         pstmt.close(); } catch (Exception e) {
/* 299 */         e.printStackTrace();
/*     */       }
/* 301 */       if (!this.mflag) {
/*     */         try {
/* 303 */           this.con.close(); } catch (Exception e) {
/* 304 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 307 */       return false;
/*     */     }
/*     */ 
/* 310 */     if (!this.mflag) {
/*     */       try {
/* 312 */         this.con.close(); } catch (Exception e) {
/* 313 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 316 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 322 */     PreparedStatement pstmt = null;
/*     */ 
/* 324 */     if (!this.mflag) {
/* 325 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 330 */       int tCount = size();
/* 331 */       pstmt = this.con.prepareStatement("INSERT INTO MLibraryStructB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 332 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 334 */         if ((get(i).getNodeID() == null) || (get(i).getNodeID().equals("null")))
/* 335 */           pstmt.setString(1, null);
/*     */         else {
/* 337 */           pstmt.setString(1, get(i).getNodeID());
/*     */         }
/* 339 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 340 */           pstmt.setString(2, null);
/*     */         else {
/* 342 */           pstmt.setString(2, get(i).getName());
/*     */         }
/* 344 */         if ((get(i).getParentID() == null) || (get(i).getParentID().equals("null")))
/* 345 */           pstmt.setString(3, null);
/*     */         else {
/* 347 */           pstmt.setString(3, get(i).getParentID());
/*     */         }
/* 349 */         if ((get(i).getDiscription() == null) || (get(i).getDiscription().equals("null")))
/* 350 */           pstmt.setString(4, null);
/*     */         else {
/* 352 */           pstmt.setString(4, get(i).getDiscription());
/*     */         }
/* 354 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 355 */           pstmt.setString(5, null);
/*     */         else {
/* 357 */           pstmt.setString(5, get(i).getManageCom());
/*     */         }
/* 359 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 360 */           pstmt.setString(6, null);
/*     */         else {
/* 362 */           pstmt.setString(6, get(i).getBranchType());
/*     */         }
/* 364 */         pstmt.setInt(7, get(i).getPosition());
/* 365 */         if ((get(i).getOperation() == null) || (get(i).getOperation().equals("null")))
/* 366 */           pstmt.setString(8, null);
/*     */         else {
/* 368 */           pstmt.setString(8, get(i).getOperation());
/*     */         }
/* 370 */         if ((get(i).getDirFlag() == null) || (get(i).getDirFlag().equals("null")))
/* 371 */           pstmt.setString(9, null);
/*     */         else {
/* 373 */           pstmt.setString(9, get(i).getDirFlag());
/*     */         }
/* 375 */         if ((get(i).getFileFlag() == null) || (get(i).getFileFlag().equals("null")))
/* 376 */           pstmt.setString(10, null);
/*     */         else {
/* 378 */           pstmt.setString(10, get(i).getFileFlag());
/*     */         }
/* 380 */         pstmt.setInt(11, get(i).getChildDirNum());
/* 381 */         if ((get(i).getCheckState() == null) || (get(i).getCheckState().equals("null")))
/* 382 */           pstmt.setString(12, null);
/*     */         else {
/* 384 */           pstmt.setString(12, get(i).getCheckState());
/*     */         }
/* 386 */         if ((get(i).getCheckOperator() == null) || (get(i).getCheckOperator().equals("null")))
/* 387 */           pstmt.setString(13, null);
/*     */         else {
/* 389 */           pstmt.setString(13, get(i).getCheckOperator());
/*     */         }
/* 391 */         if ((get(i).getCheckReason() == null) || (get(i).getCheckReason().equals("null")))
/* 392 */           pstmt.setString(14, null);
/*     */         else {
/* 394 */           pstmt.setString(14, get(i).getCheckReason());
/*     */         }
/* 396 */         if ((get(i).getCheckDate() == null) || (get(i).getCheckDate().equals("null")))
/* 397 */           pstmt.setDate(15, null);
/*     */         else {
/* 399 */           pstmt.setDate(15, Date.valueOf(get(i).getCheckDate()));
/*     */         }
/* 401 */         if ((get(i).getCheckTime() == null) || (get(i).getCheckTime().equals("null")))
/* 402 */           pstmt.setString(16, null);
/*     */         else {
/* 404 */           pstmt.setString(16, get(i).getCheckTime());
/*     */         }
/* 406 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 407 */           pstmt.setString(17, null);
/*     */         else {
/* 409 */           pstmt.setString(17, get(i).getVF01());
/*     */         }
/* 411 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 412 */           pstmt.setString(18, null);
/*     */         else {
/* 414 */           pstmt.setString(18, get(i).getNF01());
/*     */         }
/* 416 */         pstmt.setInt(19, get(i).getIF01());
/* 417 */         pstmt.setDouble(20, get(i).getDF02());
/* 418 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 419 */           pstmt.setDate(21, null);
/*     */         else {
/* 421 */           pstmt.setDate(21, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 423 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 424 */           pstmt.setString(22, null);
/*     */         else {
/* 426 */           pstmt.setString(22, get(i).getModifyOperator());
/*     */         }
/* 428 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 429 */           pstmt.setString(23, null);
/*     */         else {
/* 431 */           pstmt.setString(23, get(i).getOperator());
/*     */         }
/* 433 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 434 */           pstmt.setDate(24, null);
/*     */         else {
/* 436 */           pstmt.setDate(24, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 438 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 439 */           pstmt.setString(25, null);
/*     */         else {
/* 441 */           pstmt.setString(25, get(i).getMakeTime());
/*     */         }
/* 443 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 444 */           pstmt.setDate(26, null);
/*     */         else {
/* 446 */           pstmt.setDate(26, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 448 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 449 */           pstmt.setString(27, null);
/*     */         else {
/* 451 */           pstmt.setString(27, get(i).getModifyTime());
/*     */         }
/* 453 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 454 */           pstmt.setString(28, null);
/*     */         else {
/* 456 */           pstmt.setString(28, get(i).getEdorNo());
/*     */         }
/* 458 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 459 */           pstmt.setString(29, null);
/*     */         else {
/* 461 */           pstmt.setString(29, get(i).getEdorType());
/*     */         }
/* 463 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 464 */           pstmt.setString(30, null);
/*     */         else {
/* 466 */           pstmt.setString(30, get(i).getEdorCase());
/*     */         }
/* 468 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 469 */           pstmt.setString(31, null);
/*     */         else {
/* 471 */           pstmt.setString(31, get(i).getOperator2());
/*     */         }
/* 473 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 474 */           pstmt.setDate(32, null);
/*     */         else {
/* 476 */           pstmt.setDate(32, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 478 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 479 */           pstmt.setString(33, null);
/*     */         else {
/* 481 */           pstmt.setString(33, get(i).getMakeTime2());
/*     */         }
/* 483 */         pstmt.addBatch();
/*     */       }
/* 485 */       pstmt.executeBatch();
/* 486 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 489 */       ex.printStackTrace();
/* 490 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 491 */       CError tError = new CError();
/* 492 */       tError.moduleName = "MLibraryStructBDBSet";
/* 493 */       tError.functionName = "insert()";
/* 494 */       tError.errorMessage = ex.toString();
/* 495 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 498 */         pstmt.close(); } catch (Exception e) {
/* 499 */         e.printStackTrace();
/*     */       }
/* 501 */       if (!this.mflag) {
/*     */         try {
/* 503 */           this.con.close(); } catch (Exception e) {
/* 504 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 507 */       return false;
/*     */     }
/*     */ 
/* 510 */     if (!this.mflag) {
/*     */       try {
/* 512 */         this.con.close(); } catch (Exception e) {
/* 513 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 516 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MLibraryStructBDBSet
 * JD-Core Version:    0.6.0
 */