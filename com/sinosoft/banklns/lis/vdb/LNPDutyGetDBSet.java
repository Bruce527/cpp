/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPDutyGetSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPDutyGetSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPDutyGetDBSet extends LNPDutyGetSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPDutyGetDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPDutyGet");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPDutyGetDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPDutyGet");
/*  36 */     this.con = this.db.getConnection();
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  41 */     if (this.db.deleteSQL(this))
/*     */     {
/*  43 */       return true;
/*     */     }
/*     */ 
/*  48 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*  49 */     CError tError = new CError();
/*  50 */     tError.moduleName = "LNPDutyGetDBSet";
/*  51 */     tError.functionName = "deleteSQL";
/*  52 */     tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  53 */     this.mErrors.addOneError(tError);
/*  54 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean delete()
/*     */   {
/*  61 */     PreparedStatement pstmt = null;
/*     */ 
/*  63 */     if (!this.mflag) {
/*  64 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  69 */       int tCount = size();
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPDutyGet WHERE  GetDutyCode = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getGetDutyCode() == null) || (get(i).getGetDutyCode().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getGetDutyCode());
/*     */         }
/*  78 */         pstmt.addBatch();
/*     */       }
/*  80 */       pstmt.executeBatch();
/*  81 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  84 */       ex.printStackTrace();
/*  85 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  86 */       CError tError = new CError();
/*  87 */       tError.moduleName = "LNPDutyGetDBSet";
/*  88 */       tError.functionName = "delete()";
/*  89 */       tError.errorMessage = ex.toString();
/*  90 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/*  93 */         pstmt.close(); } catch (Exception e) {
/*  94 */         e.printStackTrace();
/*     */       }
/*  96 */       if (!this.mflag) {
/*     */         try {
/*  98 */           this.con.close(); } catch (Exception e) {
/*  99 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 102 */       return false;
/*     */     }
/*     */ 
/* 105 */     if (!this.mflag) {
/*     */       try {
/* 107 */         this.con.close(); } catch (Exception e) {
/* 108 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 111 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 117 */     PreparedStatement pstmt = null;
/*     */ 
/* 119 */     if (!this.mflag) {
/* 120 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 125 */       int tCount = size();
/* 126 */       pstmt = this.con.prepareStatement("UPDATE LNPDutyGet SET  GetDutyCode = ? , GetDutyName = ? , Type = ? , GetIntv = ? , DefaultVal = ? , CalCode = ? , CnterCalCode = ? , OthCalCode = ? , GetYear = ? , GetYearFlag = ? , StartDateCalRef = ? , StartDateCalMode = ? , MinGetStartPeriod = ? , GetEndPeriod = ? , GetEndUnit = ? , EndDateCalRef = ? , EndDateCalMode = ? , MaxGetEndPeriod = ? , AddFlag = ? , SexRelaFlag = ? , UnitAppRelaFlag = ? , AddAmntFlag = ? , DiscntFlag = ? , InterestFlag = ? , ShareFlag = ? , InpFlag = ? , BnfFlag = ? , UrgeGetFlag = ? , DeadValiFlag = ? , GetInitFlag = ? , GetLimit = ? , MaxGet = ? , GetRate = ? , NeedAcc = ? , CanGet = ? , NeedCancelAcc = ? , GetType1 = ? , ZeroFlag = ? , GetType2 = ? WHERE  GetDutyCode = ?");
/* 127 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 129 */         if ((get(i).getGetDutyCode() == null) || (get(i).getGetDutyCode().equals("null")))
/* 130 */           pstmt.setString(1, null);
/*     */         else {
/* 132 */           pstmt.setString(1, get(i).getGetDutyCode());
/*     */         }
/* 134 */         if ((get(i).getGetDutyName() == null) || (get(i).getGetDutyName().equals("null")))
/* 135 */           pstmt.setString(2, null);
/*     */         else {
/* 137 */           pstmt.setString(2, get(i).getGetDutyName());
/*     */         }
/* 139 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 140 */           pstmt.setString(3, null);
/*     */         else {
/* 142 */           pstmt.setString(3, get(i).getType());
/*     */         }
/* 144 */         pstmt.setInt(4, get(i).getGetIntv());
/* 145 */         pstmt.setDouble(5, get(i).getDefaultVal());
/* 146 */         if ((get(i).getCalCode() == null) || (get(i).getCalCode().equals("null")))
/* 147 */           pstmt.setString(6, null);
/*     */         else {
/* 149 */           pstmt.setString(6, get(i).getCalCode());
/*     */         }
/* 151 */         if ((get(i).getCnterCalCode() == null) || (get(i).getCnterCalCode().equals("null")))
/* 152 */           pstmt.setString(7, null);
/*     */         else {
/* 154 */           pstmt.setString(7, get(i).getCnterCalCode());
/*     */         }
/* 156 */         if ((get(i).getOthCalCode() == null) || (get(i).getOthCalCode().equals("null")))
/* 157 */           pstmt.setString(8, null);
/*     */         else {
/* 159 */           pstmt.setString(8, get(i).getOthCalCode());
/*     */         }
/* 161 */         pstmt.setInt(9, get(i).getGetYear());
/* 162 */         if ((get(i).getGetYearFlag() == null) || (get(i).getGetYearFlag().equals("null")))
/* 163 */           pstmt.setString(10, null);
/*     */         else {
/* 165 */           pstmt.setString(10, get(i).getGetYearFlag());
/*     */         }
/* 167 */         if ((get(i).getStartDateCalRef() == null) || (get(i).getStartDateCalRef().equals("null")))
/* 168 */           pstmt.setString(11, null);
/*     */         else {
/* 170 */           pstmt.setString(11, get(i).getStartDateCalRef());
/*     */         }
/* 172 */         if ((get(i).getStartDateCalMode() == null) || (get(i).getStartDateCalMode().equals("null")))
/* 173 */           pstmt.setString(12, null);
/*     */         else {
/* 175 */           pstmt.setString(12, get(i).getStartDateCalMode());
/*     */         }
/* 177 */         pstmt.setInt(13, get(i).getMinGetStartPeriod());
/* 178 */         pstmt.setInt(14, get(i).getGetEndPeriod());
/* 179 */         if ((get(i).getGetEndUnit() == null) || (get(i).getGetEndUnit().equals("null")))
/* 180 */           pstmt.setString(15, null);
/*     */         else {
/* 182 */           pstmt.setString(15, get(i).getGetEndUnit());
/*     */         }
/* 184 */         if ((get(i).getEndDateCalRef() == null) || (get(i).getEndDateCalRef().equals("null")))
/* 185 */           pstmt.setString(16, null);
/*     */         else {
/* 187 */           pstmt.setString(16, get(i).getEndDateCalRef());
/*     */         }
/* 189 */         if ((get(i).getEndDateCalMode() == null) || (get(i).getEndDateCalMode().equals("null")))
/* 190 */           pstmt.setString(17, null);
/*     */         else {
/* 192 */           pstmt.setString(17, get(i).getEndDateCalMode());
/*     */         }
/* 194 */         pstmt.setInt(18, get(i).getMaxGetEndPeriod());
/* 195 */         if ((get(i).getAddFlag() == null) || (get(i).getAddFlag().equals("null")))
/* 196 */           pstmt.setString(19, null);
/*     */         else {
/* 198 */           pstmt.setString(19, get(i).getAddFlag());
/*     */         }
/* 200 */         if ((get(i).getSexRelaFlag() == null) || (get(i).getSexRelaFlag().equals("null")))
/* 201 */           pstmt.setString(20, null);
/*     */         else {
/* 203 */           pstmt.setString(20, get(i).getSexRelaFlag());
/*     */         }
/* 205 */         if ((get(i).getUnitAppRelaFlag() == null) || (get(i).getUnitAppRelaFlag().equals("null")))
/* 206 */           pstmt.setString(21, null);
/*     */         else {
/* 208 */           pstmt.setString(21, get(i).getUnitAppRelaFlag());
/*     */         }
/* 210 */         if ((get(i).getAddAmntFlag() == null) || (get(i).getAddAmntFlag().equals("null")))
/* 211 */           pstmt.setString(22, null);
/*     */         else {
/* 213 */           pstmt.setString(22, get(i).getAddAmntFlag());
/*     */         }
/* 215 */         if ((get(i).getDiscntFlag() == null) || (get(i).getDiscntFlag().equals("null")))
/* 216 */           pstmt.setString(23, null);
/*     */         else {
/* 218 */           pstmt.setString(23, get(i).getDiscntFlag());
/*     */         }
/* 220 */         if ((get(i).getInterestFlag() == null) || (get(i).getInterestFlag().equals("null")))
/* 221 */           pstmt.setString(24, null);
/*     */         else {
/* 223 */           pstmt.setString(24, get(i).getInterestFlag());
/*     */         }
/* 225 */         if ((get(i).getShareFlag() == null) || (get(i).getShareFlag().equals("null")))
/* 226 */           pstmt.setString(25, null);
/*     */         else {
/* 228 */           pstmt.setString(25, get(i).getShareFlag());
/*     */         }
/* 230 */         if ((get(i).getInpFlag() == null) || (get(i).getInpFlag().equals("null")))
/* 231 */           pstmt.setString(26, null);
/*     */         else {
/* 233 */           pstmt.setString(26, get(i).getInpFlag());
/*     */         }
/* 235 */         if ((get(i).getBnfFlag() == null) || (get(i).getBnfFlag().equals("null")))
/* 236 */           pstmt.setString(27, null);
/*     */         else {
/* 238 */           pstmt.setString(27, get(i).getBnfFlag());
/*     */         }
/* 240 */         if ((get(i).getUrgeGetFlag() == null) || (get(i).getUrgeGetFlag().equals("null")))
/* 241 */           pstmt.setString(28, null);
/*     */         else {
/* 243 */           pstmt.setString(28, get(i).getUrgeGetFlag());
/*     */         }
/* 245 */         if ((get(i).getDeadValiFlag() == null) || (get(i).getDeadValiFlag().equals("null")))
/* 246 */           pstmt.setString(29, null);
/*     */         else {
/* 248 */           pstmt.setString(29, get(i).getDeadValiFlag());
/*     */         }
/* 250 */         if ((get(i).getGetInitFlag() == null) || (get(i).getGetInitFlag().equals("null")))
/* 251 */           pstmt.setString(30, null);
/*     */         else {
/* 253 */           pstmt.setString(30, get(i).getGetInitFlag());
/*     */         }
/* 255 */         pstmt.setDouble(31, get(i).getGetLimit());
/* 256 */         pstmt.setDouble(32, get(i).getMaxGet());
/* 257 */         pstmt.setDouble(33, get(i).getGetRate());
/* 258 */         if ((get(i).getNeedAcc() == null) || (get(i).getNeedAcc().equals("null")))
/* 259 */           pstmt.setString(34, null);
/*     */         else {
/* 261 */           pstmt.setString(34, get(i).getNeedAcc());
/*     */         }
/* 263 */         if ((get(i).getCanGet() == null) || (get(i).getCanGet().equals("null")))
/* 264 */           pstmt.setString(35, null);
/*     */         else {
/* 266 */           pstmt.setString(35, get(i).getCanGet());
/*     */         }
/* 268 */         if ((get(i).getNeedCancelAcc() == null) || (get(i).getNeedCancelAcc().equals("null")))
/* 269 */           pstmt.setString(36, null);
/*     */         else {
/* 271 */           pstmt.setString(36, get(i).getNeedCancelAcc());
/*     */         }
/* 273 */         if ((get(i).getGetType1() == null) || (get(i).getGetType1().equals("null")))
/* 274 */           pstmt.setString(37, null);
/*     */         else {
/* 276 */           pstmt.setString(37, get(i).getGetType1());
/*     */         }
/* 278 */         if ((get(i).getZeroFlag() == null) || (get(i).getZeroFlag().equals("null")))
/* 279 */           pstmt.setString(38, null);
/*     */         else {
/* 281 */           pstmt.setString(38, get(i).getZeroFlag());
/*     */         }
/* 283 */         if ((get(i).getGetType2() == null) || (get(i).getGetType2().equals("null")))
/* 284 */           pstmt.setString(39, null);
/*     */         else {
/* 286 */           pstmt.setString(39, get(i).getGetType2());
/*     */         }
/*     */ 
/* 289 */         if ((get(i).getGetDutyCode() == null) || (get(i).getGetDutyCode().equals("null")))
/* 290 */           pstmt.setString(40, null);
/*     */         else {
/* 292 */           pstmt.setString(40, get(i).getGetDutyCode());
/*     */         }
/* 294 */         pstmt.addBatch();
/*     */       }
/* 296 */       pstmt.executeBatch();
/* 297 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 300 */       ex.printStackTrace();
/* 301 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 302 */       CError tError = new CError();
/* 303 */       tError.moduleName = "LNPDutyGetDBSet";
/* 304 */       tError.functionName = "update()";
/* 305 */       tError.errorMessage = ex.toString();
/* 306 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 309 */         pstmt.close(); } catch (Exception e) {
/* 310 */         e.printStackTrace();
/*     */       }
/* 312 */       if (!this.mflag) {
/*     */         try {
/* 314 */           this.con.close(); } catch (Exception e) {
/* 315 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 318 */       return false;
/*     */     }
/*     */ 
/* 321 */     if (!this.mflag) {
/*     */       try {
/* 323 */         this.con.close(); } catch (Exception e) {
/* 324 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 327 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 333 */     PreparedStatement pstmt = null;
/*     */ 
/* 335 */     if (!this.mflag) {
/* 336 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 341 */       int tCount = size();
/* 342 */       pstmt = this.con.prepareStatement("INSERT INTO LNPDutyGet VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 343 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 345 */         if ((get(i).getGetDutyCode() == null) || (get(i).getGetDutyCode().equals("null")))
/* 346 */           pstmt.setString(1, null);
/*     */         else {
/* 348 */           pstmt.setString(1, get(i).getGetDutyCode());
/*     */         }
/* 350 */         if ((get(i).getGetDutyName() == null) || (get(i).getGetDutyName().equals("null")))
/* 351 */           pstmt.setString(2, null);
/*     */         else {
/* 353 */           pstmt.setString(2, get(i).getGetDutyName());
/*     */         }
/* 355 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 356 */           pstmt.setString(3, null);
/*     */         else {
/* 358 */           pstmt.setString(3, get(i).getType());
/*     */         }
/* 360 */         pstmt.setInt(4, get(i).getGetIntv());
/* 361 */         pstmt.setDouble(5, get(i).getDefaultVal());
/* 362 */         if ((get(i).getCalCode() == null) || (get(i).getCalCode().equals("null")))
/* 363 */           pstmt.setString(6, null);
/*     */         else {
/* 365 */           pstmt.setString(6, get(i).getCalCode());
/*     */         }
/* 367 */         if ((get(i).getCnterCalCode() == null) || (get(i).getCnterCalCode().equals("null")))
/* 368 */           pstmt.setString(7, null);
/*     */         else {
/* 370 */           pstmt.setString(7, get(i).getCnterCalCode());
/*     */         }
/* 372 */         if ((get(i).getOthCalCode() == null) || (get(i).getOthCalCode().equals("null")))
/* 373 */           pstmt.setString(8, null);
/*     */         else {
/* 375 */           pstmt.setString(8, get(i).getOthCalCode());
/*     */         }
/* 377 */         pstmt.setInt(9, get(i).getGetYear());
/* 378 */         if ((get(i).getGetYearFlag() == null) || (get(i).getGetYearFlag().equals("null")))
/* 379 */           pstmt.setString(10, null);
/*     */         else {
/* 381 */           pstmt.setString(10, get(i).getGetYearFlag());
/*     */         }
/* 383 */         if ((get(i).getStartDateCalRef() == null) || (get(i).getStartDateCalRef().equals("null")))
/* 384 */           pstmt.setString(11, null);
/*     */         else {
/* 386 */           pstmt.setString(11, get(i).getStartDateCalRef());
/*     */         }
/* 388 */         if ((get(i).getStartDateCalMode() == null) || (get(i).getStartDateCalMode().equals("null")))
/* 389 */           pstmt.setString(12, null);
/*     */         else {
/* 391 */           pstmt.setString(12, get(i).getStartDateCalMode());
/*     */         }
/* 393 */         pstmt.setInt(13, get(i).getMinGetStartPeriod());
/* 394 */         pstmt.setInt(14, get(i).getGetEndPeriod());
/* 395 */         if ((get(i).getGetEndUnit() == null) || (get(i).getGetEndUnit().equals("null")))
/* 396 */           pstmt.setString(15, null);
/*     */         else {
/* 398 */           pstmt.setString(15, get(i).getGetEndUnit());
/*     */         }
/* 400 */         if ((get(i).getEndDateCalRef() == null) || (get(i).getEndDateCalRef().equals("null")))
/* 401 */           pstmt.setString(16, null);
/*     */         else {
/* 403 */           pstmt.setString(16, get(i).getEndDateCalRef());
/*     */         }
/* 405 */         if ((get(i).getEndDateCalMode() == null) || (get(i).getEndDateCalMode().equals("null")))
/* 406 */           pstmt.setString(17, null);
/*     */         else {
/* 408 */           pstmt.setString(17, get(i).getEndDateCalMode());
/*     */         }
/* 410 */         pstmt.setInt(18, get(i).getMaxGetEndPeriod());
/* 411 */         if ((get(i).getAddFlag() == null) || (get(i).getAddFlag().equals("null")))
/* 412 */           pstmt.setString(19, null);
/*     */         else {
/* 414 */           pstmt.setString(19, get(i).getAddFlag());
/*     */         }
/* 416 */         if ((get(i).getSexRelaFlag() == null) || (get(i).getSexRelaFlag().equals("null")))
/* 417 */           pstmt.setString(20, null);
/*     */         else {
/* 419 */           pstmt.setString(20, get(i).getSexRelaFlag());
/*     */         }
/* 421 */         if ((get(i).getUnitAppRelaFlag() == null) || (get(i).getUnitAppRelaFlag().equals("null")))
/* 422 */           pstmt.setString(21, null);
/*     */         else {
/* 424 */           pstmt.setString(21, get(i).getUnitAppRelaFlag());
/*     */         }
/* 426 */         if ((get(i).getAddAmntFlag() == null) || (get(i).getAddAmntFlag().equals("null")))
/* 427 */           pstmt.setString(22, null);
/*     */         else {
/* 429 */           pstmt.setString(22, get(i).getAddAmntFlag());
/*     */         }
/* 431 */         if ((get(i).getDiscntFlag() == null) || (get(i).getDiscntFlag().equals("null")))
/* 432 */           pstmt.setString(23, null);
/*     */         else {
/* 434 */           pstmt.setString(23, get(i).getDiscntFlag());
/*     */         }
/* 436 */         if ((get(i).getInterestFlag() == null) || (get(i).getInterestFlag().equals("null")))
/* 437 */           pstmt.setString(24, null);
/*     */         else {
/* 439 */           pstmt.setString(24, get(i).getInterestFlag());
/*     */         }
/* 441 */         if ((get(i).getShareFlag() == null) || (get(i).getShareFlag().equals("null")))
/* 442 */           pstmt.setString(25, null);
/*     */         else {
/* 444 */           pstmt.setString(25, get(i).getShareFlag());
/*     */         }
/* 446 */         if ((get(i).getInpFlag() == null) || (get(i).getInpFlag().equals("null")))
/* 447 */           pstmt.setString(26, null);
/*     */         else {
/* 449 */           pstmt.setString(26, get(i).getInpFlag());
/*     */         }
/* 451 */         if ((get(i).getBnfFlag() == null) || (get(i).getBnfFlag().equals("null")))
/* 452 */           pstmt.setString(27, null);
/*     */         else {
/* 454 */           pstmt.setString(27, get(i).getBnfFlag());
/*     */         }
/* 456 */         if ((get(i).getUrgeGetFlag() == null) || (get(i).getUrgeGetFlag().equals("null")))
/* 457 */           pstmt.setString(28, null);
/*     */         else {
/* 459 */           pstmt.setString(28, get(i).getUrgeGetFlag());
/*     */         }
/* 461 */         if ((get(i).getDeadValiFlag() == null) || (get(i).getDeadValiFlag().equals("null")))
/* 462 */           pstmt.setString(29, null);
/*     */         else {
/* 464 */           pstmt.setString(29, get(i).getDeadValiFlag());
/*     */         }
/* 466 */         if ((get(i).getGetInitFlag() == null) || (get(i).getGetInitFlag().equals("null")))
/* 467 */           pstmt.setString(30, null);
/*     */         else {
/* 469 */           pstmt.setString(30, get(i).getGetInitFlag());
/*     */         }
/* 471 */         pstmt.setDouble(31, get(i).getGetLimit());
/* 472 */         pstmt.setDouble(32, get(i).getMaxGet());
/* 473 */         pstmt.setDouble(33, get(i).getGetRate());
/* 474 */         if ((get(i).getNeedAcc() == null) || (get(i).getNeedAcc().equals("null")))
/* 475 */           pstmt.setString(34, null);
/*     */         else {
/* 477 */           pstmt.setString(34, get(i).getNeedAcc());
/*     */         }
/* 479 */         if ((get(i).getCanGet() == null) || (get(i).getCanGet().equals("null")))
/* 480 */           pstmt.setString(35, null);
/*     */         else {
/* 482 */           pstmt.setString(35, get(i).getCanGet());
/*     */         }
/* 484 */         if ((get(i).getNeedCancelAcc() == null) || (get(i).getNeedCancelAcc().equals("null")))
/* 485 */           pstmt.setString(36, null);
/*     */         else {
/* 487 */           pstmt.setString(36, get(i).getNeedCancelAcc());
/*     */         }
/* 489 */         if ((get(i).getGetType1() == null) || (get(i).getGetType1().equals("null")))
/* 490 */           pstmt.setString(37, null);
/*     */         else {
/* 492 */           pstmt.setString(37, get(i).getGetType1());
/*     */         }
/* 494 */         if ((get(i).getZeroFlag() == null) || (get(i).getZeroFlag().equals("null")))
/* 495 */           pstmt.setString(38, null);
/*     */         else {
/* 497 */           pstmt.setString(38, get(i).getZeroFlag());
/*     */         }
/* 499 */         if ((get(i).getGetType2() == null) || (get(i).getGetType2().equals("null")))
/* 500 */           pstmt.setString(39, null);
/*     */         else {
/* 502 */           pstmt.setString(39, get(i).getGetType2());
/*     */         }
/* 504 */         pstmt.addBatch();
/*     */       }
/* 506 */       pstmt.executeBatch();
/* 507 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 510 */       ex.printStackTrace();
/* 511 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 512 */       CError tError = new CError();
/* 513 */       tError.moduleName = "LNPDutyGetDBSet";
/* 514 */       tError.functionName = "insert()";
/* 515 */       tError.errorMessage = ex.toString();
/* 516 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 519 */         pstmt.close(); } catch (Exception e) {
/* 520 */         e.printStackTrace();
/*     */       }
/* 522 */       if (!this.mflag) {
/*     */         try {
/* 524 */           this.con.close(); } catch (Exception e) {
/* 525 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 528 */       return false;
/*     */     }
/*     */ 
/* 531 */     if (!this.mflag) {
/*     */       try {
/* 533 */         this.con.close(); } catch (Exception e) {
/* 534 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 537 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPDutyGetDBSet
 * JD-Core Version:    0.6.0
 */