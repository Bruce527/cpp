/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MNewsSchema;
/*     */ import com.sinosoft.map.lis.vschema.MNewsSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MNewsDBSet extends MNewsSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MNewsDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MNews");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MNewsDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MNews");
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
/*  49 */     tError.moduleName = "MNewsDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MNews WHERE  NewsID = ?");
/*  70 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  72 */         if ((get(i).getNewsID() == null) || (get(i).getNewsID().equals("null")))
/*  73 */           pstmt.setString(1, null);
/*     */         else {
/*  75 */           pstmt.setString(1, get(i).getNewsID());
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
/*  86 */       tError.moduleName = "MNewsDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MNews SET  NewsID = ? , ManageCom = ? , BranchType = ? , NewsType = ? , Title = ? , Subhead = ? , Brief = ? , Author = ? , StartDisplayDate = ? , EndDisplayDate = ? , StartDisplayTime = ? , EndDisplayTime = ? , StaticPageURL = ? , MinDisplayGrade = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , ClickRate = ? , FixedTop = ? WHERE  NewsID = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getNewsID() == null) || (get(i).getNewsID().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getNewsID());
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
/* 143 */         if ((get(i).getNewsType() == null) || (get(i).getNewsType().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getNewsType());
/*     */         }
/* 148 */         if ((get(i).getTitle() == null) || (get(i).getTitle().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getTitle());
/*     */         }
/* 153 */         if ((get(i).getSubhead() == null) || (get(i).getSubhead().equals("null")))
/* 154 */           pstmt.setString(6, null);
/*     */         else {
/* 156 */           pstmt.setString(6, get(i).getSubhead());
/*     */         }
/* 158 */         if ((get(i).getBrief() == null) || (get(i).getBrief().equals("null")))
/* 159 */           pstmt.setString(7, null);
/*     */         else {
/* 161 */           pstmt.setString(7, get(i).getBrief());
/*     */         }
/* 163 */         if ((get(i).getAuthor() == null) || (get(i).getAuthor().equals("null")))
/* 164 */           pstmt.setString(8, null);
/*     */         else {
/* 166 */           pstmt.setString(8, get(i).getAuthor());
/*     */         }
/* 168 */         if ((get(i).getStartDisplayDate() == null) || (get(i).getStartDisplayDate().equals("null")))
/* 169 */           pstmt.setDate(9, null);
/*     */         else {
/* 171 */           pstmt.setDate(9, Date.valueOf(get(i).getStartDisplayDate()));
/*     */         }
/* 173 */         if ((get(i).getEndDisplayDate() == null) || (get(i).getEndDisplayDate().equals("null")))
/* 174 */           pstmt.setDate(10, null);
/*     */         else {
/* 176 */           pstmt.setDate(10, Date.valueOf(get(i).getEndDisplayDate()));
/*     */         }
/* 178 */         if ((get(i).getStartDisplayTime() == null) || (get(i).getStartDisplayTime().equals("null")))
/* 179 */           pstmt.setString(11, null);
/*     */         else {
/* 181 */           pstmt.setString(11, get(i).getStartDisplayTime());
/*     */         }
/* 183 */         if ((get(i).getEndDisplayTime() == null) || (get(i).getEndDisplayTime().equals("null")))
/* 184 */           pstmt.setString(12, null);
/*     */         else {
/* 186 */           pstmt.setString(12, get(i).getEndDisplayTime());
/*     */         }
/* 188 */         if ((get(i).getStaticPageURL() == null) || (get(i).getStaticPageURL().equals("null")))
/* 189 */           pstmt.setString(13, null);
/*     */         else {
/* 191 */           pstmt.setString(13, get(i).getStaticPageURL());
/*     */         }
/* 193 */         if ((get(i).getMinDisplayGrade() == null) || (get(i).getMinDisplayGrade().equals("null")))
/* 194 */           pstmt.setString(14, null);
/*     */         else {
/* 196 */           pstmt.setString(14, get(i).getMinDisplayGrade());
/*     */         }
/* 198 */         if ((get(i).getCheckState() == null) || (get(i).getCheckState().equals("null")))
/* 199 */           pstmt.setString(15, null);
/*     */         else {
/* 201 */           pstmt.setString(15, get(i).getCheckState());
/*     */         }
/* 203 */         if ((get(i).getCheckOperator() == null) || (get(i).getCheckOperator().equals("null")))
/* 204 */           pstmt.setString(16, null);
/*     */         else {
/* 206 */           pstmt.setString(16, get(i).getCheckOperator());
/*     */         }
/* 208 */         if ((get(i).getCheckReason() == null) || (get(i).getCheckReason().equals("null")))
/* 209 */           pstmt.setString(17, null);
/*     */         else {
/* 211 */           pstmt.setString(17, get(i).getCheckReason());
/*     */         }
/* 213 */         if ((get(i).getCheckDate() == null) || (get(i).getCheckDate().equals("null")))
/* 214 */           pstmt.setDate(18, null);
/*     */         else {
/* 216 */           pstmt.setDate(18, Date.valueOf(get(i).getCheckDate()));
/*     */         }
/* 218 */         if ((get(i).getCheckTime() == null) || (get(i).getCheckTime().equals("null")))
/* 219 */           pstmt.setString(19, null);
/*     */         else {
/* 221 */           pstmt.setString(19, get(i).getCheckTime());
/*     */         }
/* 223 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 224 */           pstmt.setString(20, null);
/*     */         else {
/* 226 */           pstmt.setString(20, get(i).getVF01());
/*     */         }
/* 228 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 229 */           pstmt.setString(21, null);
/*     */         else {
/* 231 */           pstmt.setString(21, get(i).getNF01());
/*     */         }
/* 233 */         pstmt.setInt(22, get(i).getIF01());
/* 234 */         pstmt.setDouble(23, get(i).getDF02());
/* 235 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 236 */           pstmt.setDate(24, null);
/*     */         else {
/* 238 */           pstmt.setDate(24, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 240 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 241 */           pstmt.setString(25, null);
/*     */         else {
/* 243 */           pstmt.setString(25, get(i).getModifyOperator());
/*     */         }
/* 245 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 246 */           pstmt.setString(26, null);
/*     */         else {
/* 248 */           pstmt.setString(26, get(i).getOperator());
/*     */         }
/* 250 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 251 */           pstmt.setDate(27, null);
/*     */         else {
/* 253 */           pstmt.setDate(27, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 255 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 256 */           pstmt.setString(28, null);
/*     */         else {
/* 258 */           pstmt.setString(28, get(i).getMakeTime());
/*     */         }
/* 260 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 261 */           pstmt.setDate(29, null);
/*     */         else {
/* 263 */           pstmt.setDate(29, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 265 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 266 */           pstmt.setString(30, null);
/*     */         else {
/* 268 */           pstmt.setString(30, get(i).getModifyTime());
/*     */         }
/* 270 */         pstmt.setInt(31, get(i).getClickRate());
/* 271 */         pstmt.setInt(32, get(i).getFixedTop());
/*     */ 
/* 273 */         if ((get(i).getNewsID() == null) || (get(i).getNewsID().equals("null")))
/* 274 */           pstmt.setString(33, null);
/*     */         else {
/* 276 */           pstmt.setString(33, get(i).getNewsID());
/*     */         }
/* 278 */         pstmt.addBatch();
/*     */       }
/* 280 */       pstmt.executeBatch();
/* 281 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 284 */       ex.printStackTrace();
/* 285 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 286 */       CError tError = new CError();
/* 287 */       tError.moduleName = "MNewsDBSet";
/* 288 */       tError.functionName = "update()";
/* 289 */       tError.errorMessage = ex.toString();
/* 290 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 293 */         pstmt.close(); } catch (Exception e) {
/* 294 */         e.printStackTrace();
/*     */       }
/* 296 */       if (!this.mflag) {
/*     */         try {
/* 298 */           this.con.close(); } catch (Exception e) {
/* 299 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 302 */       return false;
/*     */     }
/*     */ 
/* 305 */     if (!this.mflag) {
/*     */       try {
/* 307 */         this.con.close(); } catch (Exception e) {
/* 308 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 311 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 317 */     PreparedStatement pstmt = null;
/*     */ 
/* 319 */     if (!this.mflag) {
/* 320 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 325 */       int tCount = size();
/* 326 */       pstmt = this.con.prepareStatement("INSERT INTO MNews VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 327 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 329 */         if ((get(i).getNewsID() == null) || (get(i).getNewsID().equals("null")))
/* 330 */           pstmt.setString(1, null);
/*     */         else {
/* 332 */           pstmt.setString(1, get(i).getNewsID());
/*     */         }
/* 334 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 335 */           pstmt.setString(2, null);
/*     */         else {
/* 337 */           pstmt.setString(2, get(i).getManageCom());
/*     */         }
/* 339 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 340 */           pstmt.setString(3, null);
/*     */         else {
/* 342 */           pstmt.setString(3, get(i).getBranchType());
/*     */         }
/* 344 */         if ((get(i).getNewsType() == null) || (get(i).getNewsType().equals("null")))
/* 345 */           pstmt.setString(4, null);
/*     */         else {
/* 347 */           pstmt.setString(4, get(i).getNewsType());
/*     */         }
/* 349 */         if ((get(i).getTitle() == null) || (get(i).getTitle().equals("null")))
/* 350 */           pstmt.setString(5, null);
/*     */         else {
/* 352 */           pstmt.setString(5, get(i).getTitle());
/*     */         }
/* 354 */         if ((get(i).getSubhead() == null) || (get(i).getSubhead().equals("null")))
/* 355 */           pstmt.setString(6, null);
/*     */         else {
/* 357 */           pstmt.setString(6, get(i).getSubhead());
/*     */         }
/* 359 */         if ((get(i).getBrief() == null) || (get(i).getBrief().equals("null")))
/* 360 */           pstmt.setString(7, null);
/*     */         else {
/* 362 */           pstmt.setString(7, get(i).getBrief());
/*     */         }
/* 364 */         if ((get(i).getAuthor() == null) || (get(i).getAuthor().equals("null")))
/* 365 */           pstmt.setString(8, null);
/*     */         else {
/* 367 */           pstmt.setString(8, get(i).getAuthor());
/*     */         }
/* 369 */         if ((get(i).getStartDisplayDate() == null) || (get(i).getStartDisplayDate().equals("null")))
/* 370 */           pstmt.setDate(9, null);
/*     */         else {
/* 372 */           pstmt.setDate(9, Date.valueOf(get(i).getStartDisplayDate()));
/*     */         }
/* 374 */         if ((get(i).getEndDisplayDate() == null) || (get(i).getEndDisplayDate().equals("null")))
/* 375 */           pstmt.setDate(10, null);
/*     */         else {
/* 377 */           pstmt.setDate(10, Date.valueOf(get(i).getEndDisplayDate()));
/*     */         }
/* 379 */         if ((get(i).getStartDisplayTime() == null) || (get(i).getStartDisplayTime().equals("null")))
/* 380 */           pstmt.setString(11, null);
/*     */         else {
/* 382 */           pstmt.setString(11, get(i).getStartDisplayTime());
/*     */         }
/* 384 */         if ((get(i).getEndDisplayTime() == null) || (get(i).getEndDisplayTime().equals("null")))
/* 385 */           pstmt.setString(12, null);
/*     */         else {
/* 387 */           pstmt.setString(12, get(i).getEndDisplayTime());
/*     */         }
/* 389 */         if ((get(i).getStaticPageURL() == null) || (get(i).getStaticPageURL().equals("null")))
/* 390 */           pstmt.setString(13, null);
/*     */         else {
/* 392 */           pstmt.setString(13, get(i).getStaticPageURL());
/*     */         }
/* 394 */         if ((get(i).getMinDisplayGrade() == null) || (get(i).getMinDisplayGrade().equals("null")))
/* 395 */           pstmt.setString(14, null);
/*     */         else {
/* 397 */           pstmt.setString(14, get(i).getMinDisplayGrade());
/*     */         }
/* 399 */         if ((get(i).getCheckState() == null) || (get(i).getCheckState().equals("null")))
/* 400 */           pstmt.setString(15, null);
/*     */         else {
/* 402 */           pstmt.setString(15, get(i).getCheckState());
/*     */         }
/* 404 */         if ((get(i).getCheckOperator() == null) || (get(i).getCheckOperator().equals("null")))
/* 405 */           pstmt.setString(16, null);
/*     */         else {
/* 407 */           pstmt.setString(16, get(i).getCheckOperator());
/*     */         }
/* 409 */         if ((get(i).getCheckReason() == null) || (get(i).getCheckReason().equals("null")))
/* 410 */           pstmt.setString(17, null);
/*     */         else {
/* 412 */           pstmt.setString(17, get(i).getCheckReason());
/*     */         }
/* 414 */         if ((get(i).getCheckDate() == null) || (get(i).getCheckDate().equals("null")))
/* 415 */           pstmt.setDate(18, null);
/*     */         else {
/* 417 */           pstmt.setDate(18, Date.valueOf(get(i).getCheckDate()));
/*     */         }
/* 419 */         if ((get(i).getCheckTime() == null) || (get(i).getCheckTime().equals("null")))
/* 420 */           pstmt.setString(19, null);
/*     */         else {
/* 422 */           pstmt.setString(19, get(i).getCheckTime());
/*     */         }
/* 424 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 425 */           pstmt.setString(20, null);
/*     */         else {
/* 427 */           pstmt.setString(20, get(i).getVF01());
/*     */         }
/* 429 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 430 */           pstmt.setString(21, null);
/*     */         else {
/* 432 */           pstmt.setString(21, get(i).getNF01());
/*     */         }
/* 434 */         pstmt.setInt(22, get(i).getIF01());
/* 435 */         pstmt.setDouble(23, get(i).getDF02());
/* 436 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 437 */           pstmt.setDate(24, null);
/*     */         else {
/* 439 */           pstmt.setDate(24, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 441 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 442 */           pstmt.setString(25, null);
/*     */         else {
/* 444 */           pstmt.setString(25, get(i).getModifyOperator());
/*     */         }
/* 446 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 447 */           pstmt.setString(26, null);
/*     */         else {
/* 449 */           pstmt.setString(26, get(i).getOperator());
/*     */         }
/* 451 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 452 */           pstmt.setDate(27, null);
/*     */         else {
/* 454 */           pstmt.setDate(27, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 456 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 457 */           pstmt.setString(28, null);
/*     */         else {
/* 459 */           pstmt.setString(28, get(i).getMakeTime());
/*     */         }
/* 461 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 462 */           pstmt.setDate(29, null);
/*     */         else {
/* 464 */           pstmt.setDate(29, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 466 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 467 */           pstmt.setString(30, null);
/*     */         else {
/* 469 */           pstmt.setString(30, get(i).getModifyTime());
/*     */         }
/* 471 */         pstmt.setInt(31, get(i).getClickRate());
/* 472 */         pstmt.setInt(32, get(i).getFixedTop());
/* 473 */         pstmt.addBatch();
/*     */       }
/* 475 */       pstmt.executeBatch();
/* 476 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 479 */       ex.printStackTrace();
/* 480 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 481 */       CError tError = new CError();
/* 482 */       tError.moduleName = "MNewsDBSet";
/* 483 */       tError.functionName = "insert()";
/* 484 */       tError.errorMessage = ex.toString();
/* 485 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 488 */         pstmt.close(); } catch (Exception e) {
/* 489 */         e.printStackTrace();
/*     */       }
/* 491 */       if (!this.mflag) {
/*     */         try {
/* 493 */           this.con.close(); } catch (Exception e) {
/* 494 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 497 */       return false;
/*     */     }
/*     */ 
/* 500 */     if (!this.mflag) {
/*     */       try {
/* 502 */         this.con.close(); } catch (Exception e) {
/* 503 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 506 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MNewsDBSet
 * JD-Core Version:    0.6.0
 */