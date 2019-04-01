/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MHomePictureCheckBSchema;
/*     */ import com.sinosoft.map.lis.vschema.MHomePictureCheckBSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MHomePictureCheckBDBSet extends MHomePictureCheckBSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MHomePictureCheckBDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MHomePictureCheckB");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MHomePictureCheckBDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MHomePictureCheckB");
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
/*  49 */     tError.moduleName = "MHomePictureCheckBDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MHomePictureCheckB WHERE  EdorNo = ?");
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
/*  86 */       tError.moduleName = "MHomePictureCheckBDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MHomePictureCheckB SET  ID = ? , URL = ? , RefURL = ? , Name = ? , Alt = ? , PicOrder = ? , DisplayFlag = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  EdorNo = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 133 */         if ((get(i).getURL() == null) || (get(i).getURL().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getURL());
/*     */         }
/* 138 */         if ((get(i).getRefURL() == null) || (get(i).getRefURL().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getRefURL());
/*     */         }
/* 143 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getName());
/*     */         }
/* 148 */         if ((get(i).getAlt() == null) || (get(i).getAlt().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getAlt());
/*     */         }
/* 153 */         pstmt.setInt(6, get(i).getPicOrder());
/* 154 */         if ((get(i).getDisplayFlag() == null) || (get(i).getDisplayFlag().equals("null")))
/* 155 */           pstmt.setString(7, null);
/*     */         else {
/* 157 */           pstmt.setString(7, get(i).getDisplayFlag());
/*     */         }
/* 159 */         if ((get(i).getCheckState() == null) || (get(i).getCheckState().equals("null")))
/* 160 */           pstmt.setString(8, null);
/*     */         else {
/* 162 */           pstmt.setString(8, get(i).getCheckState());
/*     */         }
/* 164 */         if ((get(i).getCheckOperator() == null) || (get(i).getCheckOperator().equals("null")))
/* 165 */           pstmt.setString(9, null);
/*     */         else {
/* 167 */           pstmt.setString(9, get(i).getCheckOperator());
/*     */         }
/* 169 */         if ((get(i).getCheckReason() == null) || (get(i).getCheckReason().equals("null")))
/* 170 */           pstmt.setString(10, null);
/*     */         else {
/* 172 */           pstmt.setString(10, get(i).getCheckReason());
/*     */         }
/* 174 */         if ((get(i).getCheckDate() == null) || (get(i).getCheckDate().equals("null")))
/* 175 */           pstmt.setDate(11, null);
/*     */         else {
/* 177 */           pstmt.setDate(11, Date.valueOf(get(i).getCheckDate()));
/*     */         }
/* 179 */         if ((get(i).getCheckTime() == null) || (get(i).getCheckTime().equals("null")))
/* 180 */           pstmt.setString(12, null);
/*     */         else {
/* 182 */           pstmt.setString(12, get(i).getCheckTime());
/*     */         }
/* 184 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 185 */           pstmt.setString(13, null);
/*     */         else {
/* 187 */           pstmt.setString(13, get(i).getVF01());
/*     */         }
/* 189 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 190 */           pstmt.setString(14, null);
/*     */         else {
/* 192 */           pstmt.setString(14, get(i).getNF01());
/*     */         }
/* 194 */         pstmt.setInt(15, get(i).getIF01());
/* 195 */         pstmt.setDouble(16, get(i).getDF02());
/* 196 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 197 */           pstmt.setDate(17, null);
/*     */         else {
/* 199 */           pstmt.setDate(17, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 201 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 202 */           pstmt.setString(18, null);
/*     */         else {
/* 204 */           pstmt.setString(18, get(i).getModifyOperator());
/*     */         }
/* 206 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 207 */           pstmt.setString(19, null);
/*     */         else {
/* 209 */           pstmt.setString(19, get(i).getOperator());
/*     */         }
/* 211 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 212 */           pstmt.setDate(20, null);
/*     */         else {
/* 214 */           pstmt.setDate(20, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 216 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 217 */           pstmt.setString(21, null);
/*     */         else {
/* 219 */           pstmt.setString(21, get(i).getMakeTime());
/*     */         }
/* 221 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 222 */           pstmt.setDate(22, null);
/*     */         else {
/* 224 */           pstmt.setDate(22, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 226 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 227 */           pstmt.setString(23, null);
/*     */         else {
/* 229 */           pstmt.setString(23, get(i).getModifyTime());
/*     */         }
/* 231 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 232 */           pstmt.setString(24, null);
/*     */         else {
/* 234 */           pstmt.setString(24, get(i).getEdorNo());
/*     */         }
/* 236 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 237 */           pstmt.setString(25, null);
/*     */         else {
/* 239 */           pstmt.setString(25, get(i).getEdorType());
/*     */         }
/* 241 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 242 */           pstmt.setString(26, null);
/*     */         else {
/* 244 */           pstmt.setString(26, get(i).getEdorCase());
/*     */         }
/* 246 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 247 */           pstmt.setString(27, null);
/*     */         else {
/* 249 */           pstmt.setString(27, get(i).getOperator2());
/*     */         }
/* 251 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 252 */           pstmt.setDate(28, null);
/*     */         else {
/* 254 */           pstmt.setDate(28, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 256 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 257 */           pstmt.setString(29, null);
/*     */         else {
/* 259 */           pstmt.setString(29, get(i).getMakeTime2());
/*     */         }
/*     */ 
/* 262 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 263 */           pstmt.setString(30, null);
/*     */         else {
/* 265 */           pstmt.setString(30, get(i).getEdorNo());
/*     */         }
/* 267 */         pstmt.addBatch();
/*     */       }
/* 269 */       pstmt.executeBatch();
/* 270 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 273 */       ex.printStackTrace();
/* 274 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 275 */       CError tError = new CError();
/* 276 */       tError.moduleName = "MHomePictureCheckBDBSet";
/* 277 */       tError.functionName = "update()";
/* 278 */       tError.errorMessage = ex.toString();
/* 279 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 282 */         pstmt.close(); } catch (Exception e) {
/* 283 */         e.printStackTrace();
/*     */       }
/* 285 */       if (!this.mflag) {
/*     */         try {
/* 287 */           this.con.close(); } catch (Exception e) {
/* 288 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 291 */       return false;
/*     */     }
/*     */ 
/* 294 */     if (!this.mflag) {
/*     */       try {
/* 296 */         this.con.close(); } catch (Exception e) {
/* 297 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 300 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 306 */     PreparedStatement pstmt = null;
/*     */ 
/* 308 */     if (!this.mflag) {
/* 309 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 314 */       int tCount = size();
/* 315 */       pstmt = this.con.prepareStatement("INSERT INTO MHomePictureCheckB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 316 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 318 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 319 */           pstmt.setString(1, null);
/*     */         else {
/* 321 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 323 */         if ((get(i).getURL() == null) || (get(i).getURL().equals("null")))
/* 324 */           pstmt.setString(2, null);
/*     */         else {
/* 326 */           pstmt.setString(2, get(i).getURL());
/*     */         }
/* 328 */         if ((get(i).getRefURL() == null) || (get(i).getRefURL().equals("null")))
/* 329 */           pstmt.setString(3, null);
/*     */         else {
/* 331 */           pstmt.setString(3, get(i).getRefURL());
/*     */         }
/* 333 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 334 */           pstmt.setString(4, null);
/*     */         else {
/* 336 */           pstmt.setString(4, get(i).getName());
/*     */         }
/* 338 */         if ((get(i).getAlt() == null) || (get(i).getAlt().equals("null")))
/* 339 */           pstmt.setString(5, null);
/*     */         else {
/* 341 */           pstmt.setString(5, get(i).getAlt());
/*     */         }
/* 343 */         pstmt.setInt(6, get(i).getPicOrder());
/* 344 */         if ((get(i).getDisplayFlag() == null) || (get(i).getDisplayFlag().equals("null")))
/* 345 */           pstmt.setString(7, null);
/*     */         else {
/* 347 */           pstmt.setString(7, get(i).getDisplayFlag());
/*     */         }
/* 349 */         if ((get(i).getCheckState() == null) || (get(i).getCheckState().equals("null")))
/* 350 */           pstmt.setString(8, null);
/*     */         else {
/* 352 */           pstmt.setString(8, get(i).getCheckState());
/*     */         }
/* 354 */         if ((get(i).getCheckOperator() == null) || (get(i).getCheckOperator().equals("null")))
/* 355 */           pstmt.setString(9, null);
/*     */         else {
/* 357 */           pstmt.setString(9, get(i).getCheckOperator());
/*     */         }
/* 359 */         if ((get(i).getCheckReason() == null) || (get(i).getCheckReason().equals("null")))
/* 360 */           pstmt.setString(10, null);
/*     */         else {
/* 362 */           pstmt.setString(10, get(i).getCheckReason());
/*     */         }
/* 364 */         if ((get(i).getCheckDate() == null) || (get(i).getCheckDate().equals("null")))
/* 365 */           pstmt.setDate(11, null);
/*     */         else {
/* 367 */           pstmt.setDate(11, Date.valueOf(get(i).getCheckDate()));
/*     */         }
/* 369 */         if ((get(i).getCheckTime() == null) || (get(i).getCheckTime().equals("null")))
/* 370 */           pstmt.setString(12, null);
/*     */         else {
/* 372 */           pstmt.setString(12, get(i).getCheckTime());
/*     */         }
/* 374 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 375 */           pstmt.setString(13, null);
/*     */         else {
/* 377 */           pstmt.setString(13, get(i).getVF01());
/*     */         }
/* 379 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 380 */           pstmt.setString(14, null);
/*     */         else {
/* 382 */           pstmt.setString(14, get(i).getNF01());
/*     */         }
/* 384 */         pstmt.setInt(15, get(i).getIF01());
/* 385 */         pstmt.setDouble(16, get(i).getDF02());
/* 386 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 387 */           pstmt.setDate(17, null);
/*     */         else {
/* 389 */           pstmt.setDate(17, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 391 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 392 */           pstmt.setString(18, null);
/*     */         else {
/* 394 */           pstmt.setString(18, get(i).getModifyOperator());
/*     */         }
/* 396 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 397 */           pstmt.setString(19, null);
/*     */         else {
/* 399 */           pstmt.setString(19, get(i).getOperator());
/*     */         }
/* 401 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 402 */           pstmt.setDate(20, null);
/*     */         else {
/* 404 */           pstmt.setDate(20, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 406 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 407 */           pstmt.setString(21, null);
/*     */         else {
/* 409 */           pstmt.setString(21, get(i).getMakeTime());
/*     */         }
/* 411 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 412 */           pstmt.setDate(22, null);
/*     */         else {
/* 414 */           pstmt.setDate(22, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 416 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 417 */           pstmt.setString(23, null);
/*     */         else {
/* 419 */           pstmt.setString(23, get(i).getModifyTime());
/*     */         }
/* 421 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 422 */           pstmt.setString(24, null);
/*     */         else {
/* 424 */           pstmt.setString(24, get(i).getEdorNo());
/*     */         }
/* 426 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 427 */           pstmt.setString(25, null);
/*     */         else {
/* 429 */           pstmt.setString(25, get(i).getEdorType());
/*     */         }
/* 431 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 432 */           pstmt.setString(26, null);
/*     */         else {
/* 434 */           pstmt.setString(26, get(i).getEdorCase());
/*     */         }
/* 436 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 437 */           pstmt.setString(27, null);
/*     */         else {
/* 439 */           pstmt.setString(27, get(i).getOperator2());
/*     */         }
/* 441 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 442 */           pstmt.setDate(28, null);
/*     */         else {
/* 444 */           pstmt.setDate(28, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 446 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 447 */           pstmt.setString(29, null);
/*     */         else {
/* 449 */           pstmt.setString(29, get(i).getMakeTime2());
/*     */         }
/* 451 */         pstmt.addBatch();
/*     */       }
/* 453 */       pstmt.executeBatch();
/* 454 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 457 */       ex.printStackTrace();
/* 458 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 459 */       CError tError = new CError();
/* 460 */       tError.moduleName = "MHomePictureCheckBDBSet";
/* 461 */       tError.functionName = "insert()";
/* 462 */       tError.errorMessage = ex.toString();
/* 463 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 466 */         pstmt.close(); } catch (Exception e) {
/* 467 */         e.printStackTrace();
/*     */       }
/* 469 */       if (!this.mflag) {
/*     */         try {
/* 471 */           this.con.close(); } catch (Exception e) {
/* 472 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 475 */       return false;
/*     */     }
/*     */ 
/* 478 */     if (!this.mflag) {
/*     */       try {
/* 480 */         this.con.close(); } catch (Exception e) {
/* 481 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 484 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MHomePictureCheckBDBSet
 * JD-Core Version:    0.6.0
 */