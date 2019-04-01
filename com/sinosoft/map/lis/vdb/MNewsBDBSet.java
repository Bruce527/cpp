/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MNewsBSchema;
/*     */ import com.sinosoft.map.lis.vschema.MNewsBSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MNewsBDBSet extends MNewsBSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MNewsBDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MNewsB");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MNewsBDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MNewsB");
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
/*  49 */     tError.moduleName = "MNewsBDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MNewsB WHERE  EdorNo = ?");
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
/*  86 */       tError.moduleName = "MNewsBDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MNewsB SET  EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? , NewsID = ? , ManageCom = ? , BranchType = ? , NewsType = ? , Title = ? , Subhead = ? , Brief = ? , Author = ? , StartDisplayDate = ? , EndDisplayDate = ? , StartDisplayTime = ? , EndDisplayTime = ? , StaticPageURL = ? , MinDisplayGrade = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , ClickRate = ? , FixedTop = ? WHERE  EdorNo = ?");
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
/* 158 */         if ((get(i).getNewsID() == null) || (get(i).getNewsID().equals("null")))
/* 159 */           pstmt.setString(7, null);
/*     */         else {
/* 161 */           pstmt.setString(7, get(i).getNewsID());
/*     */         }
/* 163 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 164 */           pstmt.setString(8, null);
/*     */         else {
/* 166 */           pstmt.setString(8, get(i).getManageCom());
/*     */         }
/* 168 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 169 */           pstmt.setString(9, null);
/*     */         else {
/* 171 */           pstmt.setString(9, get(i).getBranchType());
/*     */         }
/* 173 */         if ((get(i).getNewsType() == null) || (get(i).getNewsType().equals("null")))
/* 174 */           pstmt.setString(10, null);
/*     */         else {
/* 176 */           pstmt.setString(10, get(i).getNewsType());
/*     */         }
/* 178 */         if ((get(i).getTitle() == null) || (get(i).getTitle().equals("null")))
/* 179 */           pstmt.setString(11, null);
/*     */         else {
/* 181 */           pstmt.setString(11, get(i).getTitle());
/*     */         }
/* 183 */         if ((get(i).getSubhead() == null) || (get(i).getSubhead().equals("null")))
/* 184 */           pstmt.setString(12, null);
/*     */         else {
/* 186 */           pstmt.setString(12, get(i).getSubhead());
/*     */         }
/* 188 */         if ((get(i).getBrief() == null) || (get(i).getBrief().equals("null")))
/* 189 */           pstmt.setString(13, null);
/*     */         else {
/* 191 */           pstmt.setString(13, get(i).getBrief());
/*     */         }
/* 193 */         if ((get(i).getAuthor() == null) || (get(i).getAuthor().equals("null")))
/* 194 */           pstmt.setString(14, null);
/*     */         else {
/* 196 */           pstmt.setString(14, get(i).getAuthor());
/*     */         }
/* 198 */         if ((get(i).getStartDisplayDate() == null) || (get(i).getStartDisplayDate().equals("null")))
/* 199 */           pstmt.setDate(15, null);
/*     */         else {
/* 201 */           pstmt.setDate(15, Date.valueOf(get(i).getStartDisplayDate()));
/*     */         }
/* 203 */         if ((get(i).getEndDisplayDate() == null) || (get(i).getEndDisplayDate().equals("null")))
/* 204 */           pstmt.setDate(16, null);
/*     */         else {
/* 206 */           pstmt.setDate(16, Date.valueOf(get(i).getEndDisplayDate()));
/*     */         }
/* 208 */         if ((get(i).getStartDisplayTime() == null) || (get(i).getStartDisplayTime().equals("null")))
/* 209 */           pstmt.setString(17, null);
/*     */         else {
/* 211 */           pstmt.setString(17, get(i).getStartDisplayTime());
/*     */         }
/* 213 */         if ((get(i).getEndDisplayTime() == null) || (get(i).getEndDisplayTime().equals("null")))
/* 214 */           pstmt.setString(18, null);
/*     */         else {
/* 216 */           pstmt.setString(18, get(i).getEndDisplayTime());
/*     */         }
/* 218 */         if ((get(i).getStaticPageURL() == null) || (get(i).getStaticPageURL().equals("null")))
/* 219 */           pstmt.setString(19, null);
/*     */         else {
/* 221 */           pstmt.setString(19, get(i).getStaticPageURL());
/*     */         }
/* 223 */         if ((get(i).getMinDisplayGrade() == null) || (get(i).getMinDisplayGrade().equals("null")))
/* 224 */           pstmt.setString(20, null);
/*     */         else {
/* 226 */           pstmt.setString(20, get(i).getMinDisplayGrade());
/*     */         }
/* 228 */         if ((get(i).getCheckState() == null) || (get(i).getCheckState().equals("null")))
/* 229 */           pstmt.setString(21, null);
/*     */         else {
/* 231 */           pstmt.setString(21, get(i).getCheckState());
/*     */         }
/* 233 */         if ((get(i).getCheckOperator() == null) || (get(i).getCheckOperator().equals("null")))
/* 234 */           pstmt.setString(22, null);
/*     */         else {
/* 236 */           pstmt.setString(22, get(i).getCheckOperator());
/*     */         }
/* 238 */         if ((get(i).getCheckReason() == null) || (get(i).getCheckReason().equals("null")))
/* 239 */           pstmt.setString(23, null);
/*     */         else {
/* 241 */           pstmt.setString(23, get(i).getCheckReason());
/*     */         }
/* 243 */         if ((get(i).getCheckDate() == null) || (get(i).getCheckDate().equals("null")))
/* 244 */           pstmt.setDate(24, null);
/*     */         else {
/* 246 */           pstmt.setDate(24, Date.valueOf(get(i).getCheckDate()));
/*     */         }
/* 248 */         if ((get(i).getCheckTime() == null) || (get(i).getCheckTime().equals("null")))
/* 249 */           pstmt.setString(25, null);
/*     */         else {
/* 251 */           pstmt.setString(25, get(i).getCheckTime());
/*     */         }
/* 253 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 254 */           pstmt.setString(26, null);
/*     */         else {
/* 256 */           pstmt.setString(26, get(i).getVF01());
/*     */         }
/* 258 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 259 */           pstmt.setString(27, null);
/*     */         else {
/* 261 */           pstmt.setString(27, get(i).getNF01());
/*     */         }
/* 263 */         pstmt.setInt(28, get(i).getIF01());
/* 264 */         pstmt.setDouble(29, get(i).getDF02());
/* 265 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 266 */           pstmt.setDate(30, null);
/*     */         else {
/* 268 */           pstmt.setDate(30, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 270 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 271 */           pstmt.setString(31, null);
/*     */         else {
/* 273 */           pstmt.setString(31, get(i).getModifyOperator());
/*     */         }
/* 275 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 276 */           pstmt.setString(32, null);
/*     */         else {
/* 278 */           pstmt.setString(32, get(i).getOperator());
/*     */         }
/* 280 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 281 */           pstmt.setDate(33, null);
/*     */         else {
/* 283 */           pstmt.setDate(33, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 285 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 286 */           pstmt.setString(34, null);
/*     */         else {
/* 288 */           pstmt.setString(34, get(i).getMakeTime());
/*     */         }
/* 290 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 291 */           pstmt.setDate(35, null);
/*     */         else {
/* 293 */           pstmt.setDate(35, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 295 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 296 */           pstmt.setString(36, null);
/*     */         else {
/* 298 */           pstmt.setString(36, get(i).getModifyTime());
/*     */         }
/* 300 */         pstmt.setInt(37, get(i).getClickRate());
/* 301 */         pstmt.setInt(38, get(i).getFixedTop());
/*     */ 
/* 303 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 304 */           pstmt.setString(39, null);
/*     */         else {
/* 306 */           pstmt.setString(39, get(i).getEdorNo());
/*     */         }
/* 308 */         pstmt.addBatch();
/*     */       }
/* 310 */       pstmt.executeBatch();
/* 311 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 314 */       ex.printStackTrace();
/* 315 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 316 */       CError tError = new CError();
/* 317 */       tError.moduleName = "MNewsBDBSet";
/* 318 */       tError.functionName = "update()";
/* 319 */       tError.errorMessage = ex.toString();
/* 320 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 323 */         pstmt.close(); } catch (Exception e) {
/* 324 */         e.printStackTrace();
/*     */       }
/* 326 */       if (!this.mflag) {
/*     */         try {
/* 328 */           this.con.close(); } catch (Exception e) {
/* 329 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 332 */       return false;
/*     */     }
/*     */ 
/* 335 */     if (!this.mflag) {
/*     */       try {
/* 337 */         this.con.close(); } catch (Exception e) {
/* 338 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 341 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 347 */     PreparedStatement pstmt = null;
/*     */ 
/* 349 */     if (!this.mflag) {
/* 350 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 355 */       int tCount = size();
/* 356 */       pstmt = this.con.prepareStatement("INSERT INTO MNewsB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 357 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 359 */         if ((get(i).getEdorNo() == null) || (get(i).getEdorNo().equals("null")))
/* 360 */           pstmt.setString(1, null);
/*     */         else {
/* 362 */           pstmt.setString(1, get(i).getEdorNo());
/*     */         }
/* 364 */         if ((get(i).getEdorType() == null) || (get(i).getEdorType().equals("null")))
/* 365 */           pstmt.setString(2, null);
/*     */         else {
/* 367 */           pstmt.setString(2, get(i).getEdorType());
/*     */         }
/* 369 */         if ((get(i).getEdorCase() == null) || (get(i).getEdorCase().equals("null")))
/* 370 */           pstmt.setString(3, null);
/*     */         else {
/* 372 */           pstmt.setString(3, get(i).getEdorCase());
/*     */         }
/* 374 */         if ((get(i).getOperator2() == null) || (get(i).getOperator2().equals("null")))
/* 375 */           pstmt.setString(4, null);
/*     */         else {
/* 377 */           pstmt.setString(4, get(i).getOperator2());
/*     */         }
/* 379 */         if ((get(i).getMakeDate2() == null) || (get(i).getMakeDate2().equals("null")))
/* 380 */           pstmt.setDate(5, null);
/*     */         else {
/* 382 */           pstmt.setDate(5, Date.valueOf(get(i).getMakeDate2()));
/*     */         }
/* 384 */         if ((get(i).getMakeTime2() == null) || (get(i).getMakeTime2().equals("null")))
/* 385 */           pstmt.setString(6, null);
/*     */         else {
/* 387 */           pstmt.setString(6, get(i).getMakeTime2());
/*     */         }
/* 389 */         if ((get(i).getNewsID() == null) || (get(i).getNewsID().equals("null")))
/* 390 */           pstmt.setString(7, null);
/*     */         else {
/* 392 */           pstmt.setString(7, get(i).getNewsID());
/*     */         }
/* 394 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 395 */           pstmt.setString(8, null);
/*     */         else {
/* 397 */           pstmt.setString(8, get(i).getManageCom());
/*     */         }
/* 399 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 400 */           pstmt.setString(9, null);
/*     */         else {
/* 402 */           pstmt.setString(9, get(i).getBranchType());
/*     */         }
/* 404 */         if ((get(i).getNewsType() == null) || (get(i).getNewsType().equals("null")))
/* 405 */           pstmt.setString(10, null);
/*     */         else {
/* 407 */           pstmt.setString(10, get(i).getNewsType());
/*     */         }
/* 409 */         if ((get(i).getTitle() == null) || (get(i).getTitle().equals("null")))
/* 410 */           pstmt.setString(11, null);
/*     */         else {
/* 412 */           pstmt.setString(11, get(i).getTitle());
/*     */         }
/* 414 */         if ((get(i).getSubhead() == null) || (get(i).getSubhead().equals("null")))
/* 415 */           pstmt.setString(12, null);
/*     */         else {
/* 417 */           pstmt.setString(12, get(i).getSubhead());
/*     */         }
/* 419 */         if ((get(i).getBrief() == null) || (get(i).getBrief().equals("null")))
/* 420 */           pstmt.setString(13, null);
/*     */         else {
/* 422 */           pstmt.setString(13, get(i).getBrief());
/*     */         }
/* 424 */         if ((get(i).getAuthor() == null) || (get(i).getAuthor().equals("null")))
/* 425 */           pstmt.setString(14, null);
/*     */         else {
/* 427 */           pstmt.setString(14, get(i).getAuthor());
/*     */         }
/* 429 */         if ((get(i).getStartDisplayDate() == null) || (get(i).getStartDisplayDate().equals("null")))
/* 430 */           pstmt.setDate(15, null);
/*     */         else {
/* 432 */           pstmt.setDate(15, Date.valueOf(get(i).getStartDisplayDate()));
/*     */         }
/* 434 */         if ((get(i).getEndDisplayDate() == null) || (get(i).getEndDisplayDate().equals("null")))
/* 435 */           pstmt.setDate(16, null);
/*     */         else {
/* 437 */           pstmt.setDate(16, Date.valueOf(get(i).getEndDisplayDate()));
/*     */         }
/* 439 */         if ((get(i).getStartDisplayTime() == null) || (get(i).getStartDisplayTime().equals("null")))
/* 440 */           pstmt.setString(17, null);
/*     */         else {
/* 442 */           pstmt.setString(17, get(i).getStartDisplayTime());
/*     */         }
/* 444 */         if ((get(i).getEndDisplayTime() == null) || (get(i).getEndDisplayTime().equals("null")))
/* 445 */           pstmt.setString(18, null);
/*     */         else {
/* 447 */           pstmt.setString(18, get(i).getEndDisplayTime());
/*     */         }
/* 449 */         if ((get(i).getStaticPageURL() == null) || (get(i).getStaticPageURL().equals("null")))
/* 450 */           pstmt.setString(19, null);
/*     */         else {
/* 452 */           pstmt.setString(19, get(i).getStaticPageURL());
/*     */         }
/* 454 */         if ((get(i).getMinDisplayGrade() == null) || (get(i).getMinDisplayGrade().equals("null")))
/* 455 */           pstmt.setString(20, null);
/*     */         else {
/* 457 */           pstmt.setString(20, get(i).getMinDisplayGrade());
/*     */         }
/* 459 */         if ((get(i).getCheckState() == null) || (get(i).getCheckState().equals("null")))
/* 460 */           pstmt.setString(21, null);
/*     */         else {
/* 462 */           pstmt.setString(21, get(i).getCheckState());
/*     */         }
/* 464 */         if ((get(i).getCheckOperator() == null) || (get(i).getCheckOperator().equals("null")))
/* 465 */           pstmt.setString(22, null);
/*     */         else {
/* 467 */           pstmt.setString(22, get(i).getCheckOperator());
/*     */         }
/* 469 */         if ((get(i).getCheckReason() == null) || (get(i).getCheckReason().equals("null")))
/* 470 */           pstmt.setString(23, null);
/*     */         else {
/* 472 */           pstmt.setString(23, get(i).getCheckReason());
/*     */         }
/* 474 */         if ((get(i).getCheckDate() == null) || (get(i).getCheckDate().equals("null")))
/* 475 */           pstmt.setDate(24, null);
/*     */         else {
/* 477 */           pstmt.setDate(24, Date.valueOf(get(i).getCheckDate()));
/*     */         }
/* 479 */         if ((get(i).getCheckTime() == null) || (get(i).getCheckTime().equals("null")))
/* 480 */           pstmt.setString(25, null);
/*     */         else {
/* 482 */           pstmt.setString(25, get(i).getCheckTime());
/*     */         }
/* 484 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 485 */           pstmt.setString(26, null);
/*     */         else {
/* 487 */           pstmt.setString(26, get(i).getVF01());
/*     */         }
/* 489 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 490 */           pstmt.setString(27, null);
/*     */         else {
/* 492 */           pstmt.setString(27, get(i).getNF01());
/*     */         }
/* 494 */         pstmt.setInt(28, get(i).getIF01());
/* 495 */         pstmt.setDouble(29, get(i).getDF02());
/* 496 */         if ((get(i).getDate01() == null) || (get(i).getDate01().equals("null")))
/* 497 */           pstmt.setDate(30, null);
/*     */         else {
/* 499 */           pstmt.setDate(30, Date.valueOf(get(i).getDate01()));
/*     */         }
/* 501 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 502 */           pstmt.setString(31, null);
/*     */         else {
/* 504 */           pstmt.setString(31, get(i).getModifyOperator());
/*     */         }
/* 506 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 507 */           pstmt.setString(32, null);
/*     */         else {
/* 509 */           pstmt.setString(32, get(i).getOperator());
/*     */         }
/* 511 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 512 */           pstmt.setDate(33, null);
/*     */         else {
/* 514 */           pstmt.setDate(33, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 516 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 517 */           pstmt.setString(34, null);
/*     */         else {
/* 519 */           pstmt.setString(34, get(i).getMakeTime());
/*     */         }
/* 521 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 522 */           pstmt.setDate(35, null);
/*     */         else {
/* 524 */           pstmt.setDate(35, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 526 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 527 */           pstmt.setString(36, null);
/*     */         else {
/* 529 */           pstmt.setString(36, get(i).getModifyTime());
/*     */         }
/* 531 */         pstmt.setInt(37, get(i).getClickRate());
/* 532 */         pstmt.setInt(38, get(i).getFixedTop());
/* 533 */         pstmt.addBatch();
/*     */       }
/* 535 */       pstmt.executeBatch();
/* 536 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 539 */       ex.printStackTrace();
/* 540 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 541 */       CError tError = new CError();
/* 542 */       tError.moduleName = "MNewsBDBSet";
/* 543 */       tError.functionName = "insert()";
/* 544 */       tError.errorMessage = ex.toString();
/* 545 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 548 */         pstmt.close(); } catch (Exception e) {
/* 549 */         e.printStackTrace();
/*     */       }
/* 551 */       if (!this.mflag) {
/*     */         try {
/* 553 */           this.con.close(); } catch (Exception e) {
/* 554 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 557 */       return false;
/*     */     }
/*     */ 
/* 560 */     if (!this.mflag) {
/*     */       try {
/* 562 */         this.con.close(); } catch (Exception e) {
/* 563 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 566 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MNewsBDBSet
 * JD-Core Version:    0.6.0
 */