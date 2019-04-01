/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPAppntSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPAppntSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPAppntDBSet extends LNPAppntSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPAppntDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPAppnt");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPAppntDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPAppnt");
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
/*  50 */     tError.moduleName = "LNPAppntDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPAppnt WHERE  ContNo = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getContNo());
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
/*  87 */       tError.moduleName = "LNPAppntDBSet";
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
/* 126 */       pstmt = this.con.prepareStatement("UPDATE LNPAppnt SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , PrtNo = ? , AppntNo = ? , AppntId = ? , RelationToInsured = ? , AppntGrade = ? , Appellation = ? , AppntName = ? , AppntSex = ? , AppntBirthday = ? , AppntAge = ? , AppntAgeType = ? , AppntType = ? , AddressNo = ? , SequenceNo = ? , IDType = ? , IDNo = ? , IDValidity = ? , IDPerpetual = ? , NativePlace = ? , Nationality = ? , RgtAddress = ? , Marriage = ? , MarriageDate = ? , Health = ? , Stature = ? , Avoirdupois = ? , Degree = ? , CreditGrade = ? , BankCode = ? , BankAccNo = ? , AccName = ? , JoinCompanyDate = ? , StartWorkDate = ? , Position = ? , Salary = ? , OccupationType = ? , OccupationCode = ? , WorkType = ? , PluralityType = ? , SmokeFlag = ? , Operator = ? , ManageCom = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ContNo = ?");
/* 127 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 129 */         if ((get(i).getGrpContNo() == null) || (get(i).getGrpContNo().equals("null")))
/* 130 */           pstmt.setString(1, null);
/*     */         else {
/* 132 */           pstmt.setString(1, get(i).getGrpContNo());
/*     */         }
/* 134 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 135 */           pstmt.setString(2, null);
/*     */         else {
/* 137 */           pstmt.setString(2, get(i).getContNo());
/*     */         }
/* 139 */         if ((get(i).getProposalContNo() == null) || (get(i).getProposalContNo().equals("null")))
/* 140 */           pstmt.setString(3, null);
/*     */         else {
/* 142 */           pstmt.setString(3, get(i).getProposalContNo());
/*     */         }
/* 144 */         if ((get(i).getPrtNo() == null) || (get(i).getPrtNo().equals("null")))
/* 145 */           pstmt.setString(4, null);
/*     */         else {
/* 147 */           pstmt.setString(4, get(i).getPrtNo());
/*     */         }
/* 149 */         if ((get(i).getAppntNo() == null) || (get(i).getAppntNo().equals("null")))
/* 150 */           pstmt.setString(5, null);
/*     */         else {
/* 152 */           pstmt.setString(5, get(i).getAppntNo());
/*     */         }
/* 154 */         if ((get(i).getAppntId() == null) || (get(i).getAppntId().equals("null")))
/* 155 */           pstmt.setString(6, null);
/*     */         else {
/* 157 */           pstmt.setString(6, get(i).getAppntId());
/*     */         }
/* 159 */         if ((get(i).getRelationToInsured() == null) || (get(i).getRelationToInsured().equals("null")))
/* 160 */           pstmt.setString(7, null);
/*     */         else {
/* 162 */           pstmt.setString(7, get(i).getRelationToInsured());
/*     */         }
/* 164 */         if ((get(i).getAppntGrade() == null) || (get(i).getAppntGrade().equals("null")))
/* 165 */           pstmt.setString(8, null);
/*     */         else {
/* 167 */           pstmt.setString(8, get(i).getAppntGrade());
/*     */         }
/* 169 */         if ((get(i).getAppellation() == null) || (get(i).getAppellation().equals("null")))
/* 170 */           pstmt.setString(9, null);
/*     */         else {
/* 172 */           pstmt.setString(9, get(i).getAppellation());
/*     */         }
/* 174 */         if ((get(i).getAppntName() == null) || (get(i).getAppntName().equals("null")))
/* 175 */           pstmt.setString(10, null);
/*     */         else {
/* 177 */           pstmt.setString(10, get(i).getAppntName());
/*     */         }
/* 179 */         if ((get(i).getAppntSex() == null) || (get(i).getAppntSex().equals("null")))
/* 180 */           pstmt.setString(11, null);
/*     */         else {
/* 182 */           pstmt.setString(11, get(i).getAppntSex());
/*     */         }
/* 184 */         if ((get(i).getAppntBirthday() == null) || (get(i).getAppntBirthday().equals("null")))
/* 185 */           pstmt.setDate(12, null);
/*     */         else {
/* 187 */           pstmt.setDate(12, Date.valueOf(get(i).getAppntBirthday()));
/*     */         }
/* 189 */         pstmt.setInt(13, get(i).getAppntAge());
/* 190 */         if ((get(i).getAppntAgeType() == null) || (get(i).getAppntAgeType().equals("null")))
/* 191 */           pstmt.setString(14, null);
/*     */         else {
/* 193 */           pstmt.setString(14, get(i).getAppntAgeType());
/*     */         }
/* 195 */         if ((get(i).getAppntType() == null) || (get(i).getAppntType().equals("null")))
/* 196 */           pstmt.setString(15, null);
/*     */         else {
/* 198 */           pstmt.setString(15, get(i).getAppntType());
/*     */         }
/* 200 */         if ((get(i).getAddressNo() == null) || (get(i).getAddressNo().equals("null")))
/* 201 */           pstmt.setString(16, null);
/*     */         else {
/* 203 */           pstmt.setString(16, get(i).getAddressNo());
/*     */         }
/* 205 */         if ((get(i).getSequenceNo() == null) || (get(i).getSequenceNo().equals("null")))
/* 206 */           pstmt.setString(17, null);
/*     */         else {
/* 208 */           pstmt.setString(17, get(i).getSequenceNo());
/*     */         }
/* 210 */         if ((get(i).getIDType() == null) || (get(i).getIDType().equals("null")))
/* 211 */           pstmt.setString(18, null);
/*     */         else {
/* 213 */           pstmt.setString(18, get(i).getIDType());
/*     */         }
/* 215 */         if ((get(i).getIDNo() == null) || (get(i).getIDNo().equals("null")))
/* 216 */           pstmt.setString(19, null);
/*     */         else {
/* 218 */           pstmt.setString(19, get(i).getIDNo());
/*     */         }
/* 220 */         if ((get(i).getIDValidity() == null) || (get(i).getIDValidity().equals("null")))
/* 221 */           pstmt.setDate(20, null);
/*     */         else {
/* 223 */           pstmt.setDate(20, Date.valueOf(get(i).getIDValidity()));
/*     */         }
/* 225 */         if ((get(i).getIDPerpetual() == null) || (get(i).getIDPerpetual().equals("null")))
/* 226 */           pstmt.setString(21, null);
/*     */         else {
/* 228 */           pstmt.setString(21, get(i).getIDPerpetual());
/*     */         }
/* 230 */         if ((get(i).getNativePlace() == null) || (get(i).getNativePlace().equals("null")))
/* 231 */           pstmt.setString(22, null);
/*     */         else {
/* 233 */           pstmt.setString(22, get(i).getNativePlace());
/*     */         }
/* 235 */         if ((get(i).getNationality() == null) || (get(i).getNationality().equals("null")))
/* 236 */           pstmt.setString(23, null);
/*     */         else {
/* 238 */           pstmt.setString(23, get(i).getNationality());
/*     */         }
/* 240 */         if ((get(i).getRgtAddress() == null) || (get(i).getRgtAddress().equals("null")))
/* 241 */           pstmt.setString(24, null);
/*     */         else {
/* 243 */           pstmt.setString(24, get(i).getRgtAddress());
/*     */         }
/* 245 */         if ((get(i).getMarriage() == null) || (get(i).getMarriage().equals("null")))
/* 246 */           pstmt.setString(25, null);
/*     */         else {
/* 248 */           pstmt.setString(25, get(i).getMarriage());
/*     */         }
/* 250 */         if ((get(i).getMarriageDate() == null) || (get(i).getMarriageDate().equals("null")))
/* 251 */           pstmt.setDate(26, null);
/*     */         else {
/* 253 */           pstmt.setDate(26, Date.valueOf(get(i).getMarriageDate()));
/*     */         }
/* 255 */         if ((get(i).getHealth() == null) || (get(i).getHealth().equals("null")))
/* 256 */           pstmt.setString(27, null);
/*     */         else {
/* 258 */           pstmt.setString(27, get(i).getHealth());
/*     */         }
/* 260 */         pstmt.setDouble(28, get(i).getStature());
/* 261 */         pstmt.setDouble(29, get(i).getAvoirdupois());
/* 262 */         if ((get(i).getDegree() == null) || (get(i).getDegree().equals("null")))
/* 263 */           pstmt.setString(30, null);
/*     */         else {
/* 265 */           pstmt.setString(30, get(i).getDegree());
/*     */         }
/* 267 */         if ((get(i).getCreditGrade() == null) || (get(i).getCreditGrade().equals("null")))
/* 268 */           pstmt.setString(31, null);
/*     */         else {
/* 270 */           pstmt.setString(31, get(i).getCreditGrade());
/*     */         }
/* 272 */         if ((get(i).getBankCode() == null) || (get(i).getBankCode().equals("null")))
/* 273 */           pstmt.setString(32, null);
/*     */         else {
/* 275 */           pstmt.setString(32, get(i).getBankCode());
/*     */         }
/* 277 */         if ((get(i).getBankAccNo() == null) || (get(i).getBankAccNo().equals("null")))
/* 278 */           pstmt.setString(33, null);
/*     */         else {
/* 280 */           pstmt.setString(33, get(i).getBankAccNo());
/*     */         }
/* 282 */         if ((get(i).getAccName() == null) || (get(i).getAccName().equals("null")))
/* 283 */           pstmt.setString(34, null);
/*     */         else {
/* 285 */           pstmt.setString(34, get(i).getAccName());
/*     */         }
/* 287 */         if ((get(i).getJoinCompanyDate() == null) || (get(i).getJoinCompanyDate().equals("null")))
/* 288 */           pstmt.setDate(35, null);
/*     */         else {
/* 290 */           pstmt.setDate(35, Date.valueOf(get(i).getJoinCompanyDate()));
/*     */         }
/* 292 */         if ((get(i).getStartWorkDate() == null) || (get(i).getStartWorkDate().equals("null")))
/* 293 */           pstmt.setDate(36, null);
/*     */         else {
/* 295 */           pstmt.setDate(36, Date.valueOf(get(i).getStartWorkDate()));
/*     */         }
/* 297 */         if ((get(i).getPosition() == null) || (get(i).getPosition().equals("null")))
/* 298 */           pstmt.setString(37, null);
/*     */         else {
/* 300 */           pstmt.setString(37, get(i).getPosition());
/*     */         }
/* 302 */         pstmt.setDouble(38, get(i).getSalary());
/* 303 */         if ((get(i).getOccupationType() == null) || (get(i).getOccupationType().equals("null")))
/* 304 */           pstmt.setString(39, null);
/*     */         else {
/* 306 */           pstmt.setString(39, get(i).getOccupationType());
/*     */         }
/* 308 */         if ((get(i).getOccupationCode() == null) || (get(i).getOccupationCode().equals("null")))
/* 309 */           pstmt.setString(40, null);
/*     */         else {
/* 311 */           pstmt.setString(40, get(i).getOccupationCode());
/*     */         }
/* 313 */         if ((get(i).getWorkType() == null) || (get(i).getWorkType().equals("null")))
/* 314 */           pstmt.setString(41, null);
/*     */         else {
/* 316 */           pstmt.setString(41, get(i).getWorkType());
/*     */         }
/* 318 */         if ((get(i).getPluralityType() == null) || (get(i).getPluralityType().equals("null")))
/* 319 */           pstmt.setString(42, null);
/*     */         else {
/* 321 */           pstmt.setString(42, get(i).getPluralityType());
/*     */         }
/* 323 */         if ((get(i).getSmokeFlag() == null) || (get(i).getSmokeFlag().equals("null")))
/* 324 */           pstmt.setString(43, null);
/*     */         else {
/* 326 */           pstmt.setString(43, get(i).getSmokeFlag());
/*     */         }
/* 328 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 329 */           pstmt.setString(44, null);
/*     */         else {
/* 331 */           pstmt.setString(44, get(i).getOperator());
/*     */         }
/* 333 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 334 */           pstmt.setString(45, null);
/*     */         else {
/* 336 */           pstmt.setString(45, get(i).getManageCom());
/*     */         }
/* 338 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 339 */           pstmt.setDate(46, null);
/*     */         else {
/* 341 */           pstmt.setDate(46, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 343 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 344 */           pstmt.setString(47, null);
/*     */         else {
/* 346 */           pstmt.setString(47, get(i).getMakeTime());
/*     */         }
/* 348 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 349 */           pstmt.setDate(48, null);
/*     */         else {
/* 351 */           pstmt.setDate(48, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 353 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 354 */           pstmt.setString(49, null);
/*     */         else {
/* 356 */           pstmt.setString(49, get(i).getModifyTime());
/*     */         }
/*     */ 
/* 359 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 360 */           pstmt.setString(50, null);
/*     */         else {
/* 362 */           pstmt.setString(50, get(i).getContNo());
/*     */         }
/* 364 */         pstmt.addBatch();
/*     */       }
/* 366 */       pstmt.executeBatch();
/* 367 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 370 */       ex.printStackTrace();
/* 371 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 372 */       CError tError = new CError();
/* 373 */       tError.moduleName = "LNPAppntDBSet";
/* 374 */       tError.functionName = "update()";
/* 375 */       tError.errorMessage = ex.toString();
/* 376 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 379 */         pstmt.close(); } catch (Exception e) {
/* 380 */         e.printStackTrace();
/*     */       }
/* 382 */       if (!this.mflag) {
/*     */         try {
/* 384 */           this.con.close(); } catch (Exception e) {
/* 385 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 388 */       return false;
/*     */     }
/*     */ 
/* 391 */     if (!this.mflag) {
/*     */       try {
/* 393 */         this.con.close(); } catch (Exception e) {
/* 394 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 397 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 403 */     PreparedStatement pstmt = null;
/*     */ 
/* 405 */     if (!this.mflag) {
/* 406 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 411 */       int tCount = size();
/* 412 */       pstmt = this.con.prepareStatement("INSERT INTO LNPAppnt VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 413 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 415 */         if ((get(i).getGrpContNo() == null) || (get(i).getGrpContNo().equals("null")))
/* 416 */           pstmt.setString(1, null);
/*     */         else {
/* 418 */           pstmt.setString(1, get(i).getGrpContNo());
/*     */         }
/* 420 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 421 */           pstmt.setString(2, null);
/*     */         else {
/* 423 */           pstmt.setString(2, get(i).getContNo());
/*     */         }
/* 425 */         if ((get(i).getProposalContNo() == null) || (get(i).getProposalContNo().equals("null")))
/* 426 */           pstmt.setString(3, null);
/*     */         else {
/* 428 */           pstmt.setString(3, get(i).getProposalContNo());
/*     */         }
/* 430 */         if ((get(i).getPrtNo() == null) || (get(i).getPrtNo().equals("null")))
/* 431 */           pstmt.setString(4, null);
/*     */         else {
/* 433 */           pstmt.setString(4, get(i).getPrtNo());
/*     */         }
/* 435 */         if ((get(i).getAppntNo() == null) || (get(i).getAppntNo().equals("null")))
/* 436 */           pstmt.setString(5, null);
/*     */         else {
/* 438 */           pstmt.setString(5, get(i).getAppntNo());
/*     */         }
/* 440 */         if ((get(i).getAppntId() == null) || (get(i).getAppntId().equals("null")))
/* 441 */           pstmt.setString(6, null);
/*     */         else {
/* 443 */           pstmt.setString(6, get(i).getAppntId());
/*     */         }
/* 445 */         if ((get(i).getRelationToInsured() == null) || (get(i).getRelationToInsured().equals("null")))
/* 446 */           pstmt.setString(7, null);
/*     */         else {
/* 448 */           pstmt.setString(7, get(i).getRelationToInsured());
/*     */         }
/* 450 */         if ((get(i).getAppntGrade() == null) || (get(i).getAppntGrade().equals("null")))
/* 451 */           pstmt.setString(8, null);
/*     */         else {
/* 453 */           pstmt.setString(8, get(i).getAppntGrade());
/*     */         }
/* 455 */         if ((get(i).getAppellation() == null) || (get(i).getAppellation().equals("null")))
/* 456 */           pstmt.setString(9, null);
/*     */         else {
/* 458 */           pstmt.setString(9, get(i).getAppellation());
/*     */         }
/* 460 */         if ((get(i).getAppntName() == null) || (get(i).getAppntName().equals("null")))
/* 461 */           pstmt.setString(10, null);
/*     */         else {
/* 463 */           pstmt.setString(10, get(i).getAppntName());
/*     */         }
/* 465 */         if ((get(i).getAppntSex() == null) || (get(i).getAppntSex().equals("null")))
/* 466 */           pstmt.setString(11, null);
/*     */         else {
/* 468 */           pstmt.setString(11, get(i).getAppntSex());
/*     */         }
/* 470 */         if ((get(i).getAppntBirthday() == null) || (get(i).getAppntBirthday().equals("null")))
/* 471 */           pstmt.setDate(12, null);
/*     */         else {
/* 473 */           pstmt.setDate(12, Date.valueOf(get(i).getAppntBirthday()));
/*     */         }
/* 475 */         pstmt.setInt(13, get(i).getAppntAge());
/* 476 */         if ((get(i).getAppntAgeType() == null) || (get(i).getAppntAgeType().equals("null")))
/* 477 */           pstmt.setString(14, null);
/*     */         else {
/* 479 */           pstmt.setString(14, get(i).getAppntAgeType());
/*     */         }
/* 481 */         if ((get(i).getAppntType() == null) || (get(i).getAppntType().equals("null")))
/* 482 */           pstmt.setString(15, null);
/*     */         else {
/* 484 */           pstmt.setString(15, get(i).getAppntType());
/*     */         }
/* 486 */         if ((get(i).getAddressNo() == null) || (get(i).getAddressNo().equals("null")))
/* 487 */           pstmt.setString(16, null);
/*     */         else {
/* 489 */           pstmt.setString(16, get(i).getAddressNo());
/*     */         }
/* 491 */         if ((get(i).getSequenceNo() == null) || (get(i).getSequenceNo().equals("null")))
/* 492 */           pstmt.setString(17, null);
/*     */         else {
/* 494 */           pstmt.setString(17, get(i).getSequenceNo());
/*     */         }
/* 496 */         if ((get(i).getIDType() == null) || (get(i).getIDType().equals("null")))
/* 497 */           pstmt.setString(18, null);
/*     */         else {
/* 499 */           pstmt.setString(18, get(i).getIDType());
/*     */         }
/* 501 */         if ((get(i).getIDNo() == null) || (get(i).getIDNo().equals("null")))
/* 502 */           pstmt.setString(19, null);
/*     */         else {
/* 504 */           pstmt.setString(19, get(i).getIDNo());
/*     */         }
/* 506 */         if ((get(i).getIDValidity() == null) || (get(i).getIDValidity().equals("null")))
/* 507 */           pstmt.setDate(20, null);
/*     */         else {
/* 509 */           pstmt.setDate(20, Date.valueOf(get(i).getIDValidity()));
/*     */         }
/* 511 */         if ((get(i).getIDPerpetual() == null) || (get(i).getIDPerpetual().equals("null")))
/* 512 */           pstmt.setString(21, null);
/*     */         else {
/* 514 */           pstmt.setString(21, get(i).getIDPerpetual());
/*     */         }
/* 516 */         if ((get(i).getNativePlace() == null) || (get(i).getNativePlace().equals("null")))
/* 517 */           pstmt.setString(22, null);
/*     */         else {
/* 519 */           pstmt.setString(22, get(i).getNativePlace());
/*     */         }
/* 521 */         if ((get(i).getNationality() == null) || (get(i).getNationality().equals("null")))
/* 522 */           pstmt.setString(23, null);
/*     */         else {
/* 524 */           pstmt.setString(23, get(i).getNationality());
/*     */         }
/* 526 */         if ((get(i).getRgtAddress() == null) || (get(i).getRgtAddress().equals("null")))
/* 527 */           pstmt.setString(24, null);
/*     */         else {
/* 529 */           pstmt.setString(24, get(i).getRgtAddress());
/*     */         }
/* 531 */         if ((get(i).getMarriage() == null) || (get(i).getMarriage().equals("null")))
/* 532 */           pstmt.setString(25, null);
/*     */         else {
/* 534 */           pstmt.setString(25, get(i).getMarriage());
/*     */         }
/* 536 */         if ((get(i).getMarriageDate() == null) || (get(i).getMarriageDate().equals("null")))
/* 537 */           pstmt.setDate(26, null);
/*     */         else {
/* 539 */           pstmt.setDate(26, Date.valueOf(get(i).getMarriageDate()));
/*     */         }
/* 541 */         if ((get(i).getHealth() == null) || (get(i).getHealth().equals("null")))
/* 542 */           pstmt.setString(27, null);
/*     */         else {
/* 544 */           pstmt.setString(27, get(i).getHealth());
/*     */         }
/* 546 */         pstmt.setDouble(28, get(i).getStature());
/* 547 */         pstmt.setDouble(29, get(i).getAvoirdupois());
/* 548 */         if ((get(i).getDegree() == null) || (get(i).getDegree().equals("null")))
/* 549 */           pstmt.setString(30, null);
/*     */         else {
/* 551 */           pstmt.setString(30, get(i).getDegree());
/*     */         }
/* 553 */         if ((get(i).getCreditGrade() == null) || (get(i).getCreditGrade().equals("null")))
/* 554 */           pstmt.setString(31, null);
/*     */         else {
/* 556 */           pstmt.setString(31, get(i).getCreditGrade());
/*     */         }
/* 558 */         if ((get(i).getBankCode() == null) || (get(i).getBankCode().equals("null")))
/* 559 */           pstmt.setString(32, null);
/*     */         else {
/* 561 */           pstmt.setString(32, get(i).getBankCode());
/*     */         }
/* 563 */         if ((get(i).getBankAccNo() == null) || (get(i).getBankAccNo().equals("null")))
/* 564 */           pstmt.setString(33, null);
/*     */         else {
/* 566 */           pstmt.setString(33, get(i).getBankAccNo());
/*     */         }
/* 568 */         if ((get(i).getAccName() == null) || (get(i).getAccName().equals("null")))
/* 569 */           pstmt.setString(34, null);
/*     */         else {
/* 571 */           pstmt.setString(34, get(i).getAccName());
/*     */         }
/* 573 */         if ((get(i).getJoinCompanyDate() == null) || (get(i).getJoinCompanyDate().equals("null")))
/* 574 */           pstmt.setDate(35, null);
/*     */         else {
/* 576 */           pstmt.setDate(35, Date.valueOf(get(i).getJoinCompanyDate()));
/*     */         }
/* 578 */         if ((get(i).getStartWorkDate() == null) || (get(i).getStartWorkDate().equals("null")))
/* 579 */           pstmt.setDate(36, null);
/*     */         else {
/* 581 */           pstmt.setDate(36, Date.valueOf(get(i).getStartWorkDate()));
/*     */         }
/* 583 */         if ((get(i).getPosition() == null) || (get(i).getPosition().equals("null")))
/* 584 */           pstmt.setString(37, null);
/*     */         else {
/* 586 */           pstmt.setString(37, get(i).getPosition());
/*     */         }
/* 588 */         pstmt.setDouble(38, get(i).getSalary());
/* 589 */         if ((get(i).getOccupationType() == null) || (get(i).getOccupationType().equals("null")))
/* 590 */           pstmt.setString(39, null);
/*     */         else {
/* 592 */           pstmt.setString(39, get(i).getOccupationType());
/*     */         }
/* 594 */         if ((get(i).getOccupationCode() == null) || (get(i).getOccupationCode().equals("null")))
/* 595 */           pstmt.setString(40, null);
/*     */         else {
/* 597 */           pstmt.setString(40, get(i).getOccupationCode());
/*     */         }
/* 599 */         if ((get(i).getWorkType() == null) || (get(i).getWorkType().equals("null")))
/* 600 */           pstmt.setString(41, null);
/*     */         else {
/* 602 */           pstmt.setString(41, get(i).getWorkType());
/*     */         }
/* 604 */         if ((get(i).getPluralityType() == null) || (get(i).getPluralityType().equals("null")))
/* 605 */           pstmt.setString(42, null);
/*     */         else {
/* 607 */           pstmt.setString(42, get(i).getPluralityType());
/*     */         }
/* 609 */         if ((get(i).getSmokeFlag() == null) || (get(i).getSmokeFlag().equals("null")))
/* 610 */           pstmt.setString(43, null);
/*     */         else {
/* 612 */           pstmt.setString(43, get(i).getSmokeFlag());
/*     */         }
/* 614 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 615 */           pstmt.setString(44, null);
/*     */         else {
/* 617 */           pstmt.setString(44, get(i).getOperator());
/*     */         }
/* 619 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 620 */           pstmt.setString(45, null);
/*     */         else {
/* 622 */           pstmt.setString(45, get(i).getManageCom());
/*     */         }
/* 624 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 625 */           pstmt.setDate(46, null);
/*     */         else {
/* 627 */           pstmt.setDate(46, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 629 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 630 */           pstmt.setString(47, null);
/*     */         else {
/* 632 */           pstmt.setString(47, get(i).getMakeTime());
/*     */         }
/* 634 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 635 */           pstmt.setDate(48, null);
/*     */         else {
/* 637 */           pstmt.setDate(48, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 639 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 640 */           pstmt.setString(49, null);
/*     */         else {
/* 642 */           pstmt.setString(49, get(i).getModifyTime());
/*     */         }
/* 644 */         pstmt.addBatch();
/*     */       }
/* 646 */       pstmt.executeBatch();
/* 647 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 650 */       ex.printStackTrace();
/* 651 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 652 */       CError tError = new CError();
/* 653 */       tError.moduleName = "LNPAppntDBSet";
/* 654 */       tError.functionName = "insert()";
/* 655 */       tError.errorMessage = ex.toString();
/* 656 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 659 */         pstmt.close(); } catch (Exception e) {
/* 660 */         e.printStackTrace();
/*     */       }
/* 662 */       if (!this.mflag) {
/*     */         try {
/* 664 */           this.con.close(); } catch (Exception e) {
/* 665 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 668 */       return false;
/*     */     }
/*     */ 
/* 671 */     if (!this.mflag) {
/*     */       try {
/* 673 */         this.con.close(); } catch (Exception e) {
/* 674 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 677 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPAppntDBSet
 * JD-Core Version:    0.6.0
 */