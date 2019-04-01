/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPInsuredSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPInsuredSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPInsuredDBSet extends LNPInsuredSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPInsuredDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPInsured");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPInsuredDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPInsured");
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
/*  50 */     tError.moduleName = "LNPInsuredDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPInsured WHERE  ContNo = ? AND InsuredId = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getContNo());
/*     */         }
/*  78 */         if ((get(i).getInsuredId() == null) || (get(i).getInsuredId().equals("null")))
/*  79 */           pstmt.setString(2, null);
/*     */         else {
/*  81 */           pstmt.setString(2, get(i).getInsuredId());
/*     */         }
/*  83 */         pstmt.addBatch();
/*     */       }
/*  85 */       pstmt.executeBatch();
/*  86 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  89 */       ex.printStackTrace();
/*  90 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  91 */       CError tError = new CError();
/*  92 */       tError.moduleName = "LNPInsuredDBSet";
/*  93 */       tError.functionName = "delete()";
/*  94 */       tError.errorMessage = ex.toString();
/*  95 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/*  98 */         pstmt.close(); } catch (Exception e) {
/*  99 */         e.printStackTrace();
/*     */       }
/* 101 */       if (!this.mflag) {
/*     */         try {
/* 103 */           this.con.close(); } catch (Exception e) {
/* 104 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 107 */       return false;
/*     */     }
/*     */ 
/* 110 */     if (!this.mflag) {
/*     */       try {
/* 112 */         this.con.close(); } catch (Exception e) {
/* 113 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 116 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 122 */     PreparedStatement pstmt = null;
/*     */ 
/* 124 */     if (!this.mflag) {
/* 125 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 130 */       int tCount = size();
/* 131 */       pstmt = this.con.prepareStatement("UPDATE LNPInsured SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , InsuredNo = ? , InsuredId = ? , PrtNo = ? , AppntNo = ? , AppntId = ? , ManageCom = ? , SignCity = ? , ExecuteCom = ? , FamilyID = ? , RelationToMainInsured = ? , RelationToAppnt = ? , AddressNo = ? , SequenceNo = ? , Name = ? , Appellation = ? , Sex = ? , Birthday = ? , AppAge = ? , AppAgeType = ? , IDType = ? , IDNo = ? , IDValidity = ? , IDPerpetual = ? , NativePlace = ? , Nationality = ? , RgtAddress = ? , Marriage = ? , MarriageDate = ? , Health = ? , Stature = ? , Avoirdupois = ? , Degree = ? , CreditGrade = ? , BankCode = ? , BankAccNo = ? , AccName = ? , JoinCompanyDate = ? , StartWorkDate = ? , Position = ? , Salary = ? , OccupationType = ? , OccupationCode = ? , PartOccupationType = ? , PartOccupationCode = ? , WorkType = ? , PluralityType = ? , SmokeFlag = ? , ContPlanCode = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , InsuredPeoples = ? WHERE  ContNo = ? AND InsuredId = ?");
/* 132 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 134 */         if ((get(i).getGrpContNo() == null) || (get(i).getGrpContNo().equals("null")))
/* 135 */           pstmt.setString(1, null);
/*     */         else {
/* 137 */           pstmt.setString(1, get(i).getGrpContNo());
/*     */         }
/* 139 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 140 */           pstmt.setString(2, null);
/*     */         else {
/* 142 */           pstmt.setString(2, get(i).getContNo());
/*     */         }
/* 144 */         if ((get(i).getProposalContNo() == null) || (get(i).getProposalContNo().equals("null")))
/* 145 */           pstmt.setString(3, null);
/*     */         else {
/* 147 */           pstmt.setString(3, get(i).getProposalContNo());
/*     */         }
/* 149 */         if ((get(i).getInsuredNo() == null) || (get(i).getInsuredNo().equals("null")))
/* 150 */           pstmt.setString(4, null);
/*     */         else {
/* 152 */           pstmt.setString(4, get(i).getInsuredNo());
/*     */         }
/* 154 */         if ((get(i).getInsuredId() == null) || (get(i).getInsuredId().equals("null")))
/* 155 */           pstmt.setString(5, null);
/*     */         else {
/* 157 */           pstmt.setString(5, get(i).getInsuredId());
/*     */         }
/* 159 */         if ((get(i).getPrtNo() == null) || (get(i).getPrtNo().equals("null")))
/* 160 */           pstmt.setString(6, null);
/*     */         else {
/* 162 */           pstmt.setString(6, get(i).getPrtNo());
/*     */         }
/* 164 */         if ((get(i).getAppntNo() == null) || (get(i).getAppntNo().equals("null")))
/* 165 */           pstmt.setString(7, null);
/*     */         else {
/* 167 */           pstmt.setString(7, get(i).getAppntNo());
/*     */         }
/* 169 */         if ((get(i).getAppntId() == null) || (get(i).getAppntId().equals("null")))
/* 170 */           pstmt.setString(8, null);
/*     */         else {
/* 172 */           pstmt.setString(8, get(i).getAppntId());
/*     */         }
/* 174 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 175 */           pstmt.setString(9, null);
/*     */         else {
/* 177 */           pstmt.setString(9, get(i).getManageCom());
/*     */         }
/* 179 */         if ((get(i).getSignCity() == null) || (get(i).getSignCity().equals("null")))
/* 180 */           pstmt.setString(10, null);
/*     */         else {
/* 182 */           pstmt.setString(10, get(i).getSignCity());
/*     */         }
/* 184 */         if ((get(i).getExecuteCom() == null) || (get(i).getExecuteCom().equals("null")))
/* 185 */           pstmt.setString(11, null);
/*     */         else {
/* 187 */           pstmt.setString(11, get(i).getExecuteCom());
/*     */         }
/* 189 */         if ((get(i).getFamilyID() == null) || (get(i).getFamilyID().equals("null")))
/* 190 */           pstmt.setString(12, null);
/*     */         else {
/* 192 */           pstmt.setString(12, get(i).getFamilyID());
/*     */         }
/* 194 */         if ((get(i).getRelationToMainInsured() == null) || (get(i).getRelationToMainInsured().equals("null")))
/* 195 */           pstmt.setString(13, null);
/*     */         else {
/* 197 */           pstmt.setString(13, get(i).getRelationToMainInsured());
/*     */         }
/* 199 */         if ((get(i).getRelationToAppnt() == null) || (get(i).getRelationToAppnt().equals("null")))
/* 200 */           pstmt.setString(14, null);
/*     */         else {
/* 202 */           pstmt.setString(14, get(i).getRelationToAppnt());
/*     */         }
/* 204 */         if ((get(i).getAddressNo() == null) || (get(i).getAddressNo().equals("null")))
/* 205 */           pstmt.setString(15, null);
/*     */         else {
/* 207 */           pstmt.setString(15, get(i).getAddressNo());
/*     */         }
/* 209 */         if ((get(i).getSequenceNo() == null) || (get(i).getSequenceNo().equals("null")))
/* 210 */           pstmt.setString(16, null);
/*     */         else {
/* 212 */           pstmt.setString(16, get(i).getSequenceNo());
/*     */         }
/* 214 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 215 */           pstmt.setString(17, null);
/*     */         else {
/* 217 */           pstmt.setString(17, get(i).getName());
/*     */         }
/* 219 */         if ((get(i).getAppellation() == null) || (get(i).getAppellation().equals("null")))
/* 220 */           pstmt.setString(18, null);
/*     */         else {
/* 222 */           pstmt.setString(18, get(i).getAppellation());
/*     */         }
/* 224 */         if ((get(i).getSex() == null) || (get(i).getSex().equals("null")))
/* 225 */           pstmt.setString(19, null);
/*     */         else {
/* 227 */           pstmt.setString(19, get(i).getSex());
/*     */         }
/* 229 */         if ((get(i).getBirthday() == null) || (get(i).getBirthday().equals("null")))
/* 230 */           pstmt.setDate(20, null);
/*     */         else {
/* 232 */           pstmt.setDate(20, Date.valueOf(get(i).getBirthday()));
/*     */         }
/* 234 */         pstmt.setInt(21, get(i).getAppAge());
/* 235 */         if ((get(i).getAppAgeType() == null) || (get(i).getAppAgeType().equals("null")))
/* 236 */           pstmt.setString(22, null);
/*     */         else {
/* 238 */           pstmt.setString(22, get(i).getAppAgeType());
/*     */         }
/* 240 */         if ((get(i).getIDType() == null) || (get(i).getIDType().equals("null")))
/* 241 */           pstmt.setString(23, null);
/*     */         else {
/* 243 */           pstmt.setString(23, get(i).getIDType());
/*     */         }
/* 245 */         if ((get(i).getIDNo() == null) || (get(i).getIDNo().equals("null")))
/* 246 */           pstmt.setString(24, null);
/*     */         else {
/* 248 */           pstmt.setString(24, get(i).getIDNo());
/*     */         }
/* 250 */         if ((get(i).getIDValidity() == null) || (get(i).getIDValidity().equals("null")))
/* 251 */           pstmt.setDate(25, null);
/*     */         else {
/* 253 */           pstmt.setDate(25, Date.valueOf(get(i).getIDValidity()));
/*     */         }
/* 255 */         if ((get(i).getIDPerpetual() == null) || (get(i).getIDPerpetual().equals("null")))
/* 256 */           pstmt.setString(26, null);
/*     */         else {
/* 258 */           pstmt.setString(26, get(i).getIDPerpetual());
/*     */         }
/* 260 */         if ((get(i).getNativePlace() == null) || (get(i).getNativePlace().equals("null")))
/* 261 */           pstmt.setString(27, null);
/*     */         else {
/* 263 */           pstmt.setString(27, get(i).getNativePlace());
/*     */         }
/* 265 */         if ((get(i).getNationality() == null) || (get(i).getNationality().equals("null")))
/* 266 */           pstmt.setString(28, null);
/*     */         else {
/* 268 */           pstmt.setString(28, get(i).getNationality());
/*     */         }
/* 270 */         if ((get(i).getRgtAddress() == null) || (get(i).getRgtAddress().equals("null")))
/* 271 */           pstmt.setString(29, null);
/*     */         else {
/* 273 */           pstmt.setString(29, get(i).getRgtAddress());
/*     */         }
/* 275 */         if ((get(i).getMarriage() == null) || (get(i).getMarriage().equals("null")))
/* 276 */           pstmt.setString(30, null);
/*     */         else {
/* 278 */           pstmt.setString(30, get(i).getMarriage());
/*     */         }
/* 280 */         if ((get(i).getMarriageDate() == null) || (get(i).getMarriageDate().equals("null")))
/* 281 */           pstmt.setDate(31, null);
/*     */         else {
/* 283 */           pstmt.setDate(31, Date.valueOf(get(i).getMarriageDate()));
/*     */         }
/* 285 */         if ((get(i).getHealth() == null) || (get(i).getHealth().equals("null")))
/* 286 */           pstmt.setString(32, null);
/*     */         else {
/* 288 */           pstmt.setString(32, get(i).getHealth());
/*     */         }
/* 290 */         pstmt.setDouble(33, get(i).getStature());
/* 291 */         pstmt.setDouble(34, get(i).getAvoirdupois());
/* 292 */         if ((get(i).getDegree() == null) || (get(i).getDegree().equals("null")))
/* 293 */           pstmt.setString(35, null);
/*     */         else {
/* 295 */           pstmt.setString(35, get(i).getDegree());
/*     */         }
/* 297 */         if ((get(i).getCreditGrade() == null) || (get(i).getCreditGrade().equals("null")))
/* 298 */           pstmt.setString(36, null);
/*     */         else {
/* 300 */           pstmt.setString(36, get(i).getCreditGrade());
/*     */         }
/* 302 */         if ((get(i).getBankCode() == null) || (get(i).getBankCode().equals("null")))
/* 303 */           pstmt.setString(37, null);
/*     */         else {
/* 305 */           pstmt.setString(37, get(i).getBankCode());
/*     */         }
/* 307 */         if ((get(i).getBankAccNo() == null) || (get(i).getBankAccNo().equals("null")))
/* 308 */           pstmt.setString(38, null);
/*     */         else {
/* 310 */           pstmt.setString(38, get(i).getBankAccNo());
/*     */         }
/* 312 */         if ((get(i).getAccName() == null) || (get(i).getAccName().equals("null")))
/* 313 */           pstmt.setString(39, null);
/*     */         else {
/* 315 */           pstmt.setString(39, get(i).getAccName());
/*     */         }
/* 317 */         if ((get(i).getJoinCompanyDate() == null) || (get(i).getJoinCompanyDate().equals("null")))
/* 318 */           pstmt.setDate(40, null);
/*     */         else {
/* 320 */           pstmt.setDate(40, Date.valueOf(get(i).getJoinCompanyDate()));
/*     */         }
/* 322 */         if ((get(i).getStartWorkDate() == null) || (get(i).getStartWorkDate().equals("null")))
/* 323 */           pstmt.setDate(41, null);
/*     */         else {
/* 325 */           pstmt.setDate(41, Date.valueOf(get(i).getStartWorkDate()));
/*     */         }
/* 327 */         if ((get(i).getPosition() == null) || (get(i).getPosition().equals("null")))
/* 328 */           pstmt.setString(42, null);
/*     */         else {
/* 330 */           pstmt.setString(42, get(i).getPosition());
/*     */         }
/* 332 */         pstmt.setDouble(43, get(i).getSalary());
/* 333 */         if ((get(i).getOccupationType() == null) || (get(i).getOccupationType().equals("null")))
/* 334 */           pstmt.setString(44, null);
/*     */         else {
/* 336 */           pstmt.setString(44, get(i).getOccupationType());
/*     */         }
/* 338 */         if ((get(i).getOccupationCode() == null) || (get(i).getOccupationCode().equals("null")))
/* 339 */           pstmt.setString(45, null);
/*     */         else {
/* 341 */           pstmt.setString(45, get(i).getOccupationCode());
/*     */         }
/* 343 */         if ((get(i).getPartOccupationType() == null) || (get(i).getPartOccupationType().equals("null")))
/* 344 */           pstmt.setString(46, null);
/*     */         else {
/* 346 */           pstmt.setString(46, get(i).getPartOccupationType());
/*     */         }
/* 348 */         if ((get(i).getPartOccupationCode() == null) || (get(i).getPartOccupationCode().equals("null")))
/* 349 */           pstmt.setString(47, null);
/*     */         else {
/* 351 */           pstmt.setString(47, get(i).getPartOccupationCode());
/*     */         }
/* 353 */         if ((get(i).getWorkType() == null) || (get(i).getWorkType().equals("null")))
/* 354 */           pstmt.setString(48, null);
/*     */         else {
/* 356 */           pstmt.setString(48, get(i).getWorkType());
/*     */         }
/* 358 */         if ((get(i).getPluralityType() == null) || (get(i).getPluralityType().equals("null")))
/* 359 */           pstmt.setString(49, null);
/*     */         else {
/* 361 */           pstmt.setString(49, get(i).getPluralityType());
/*     */         }
/* 363 */         if ((get(i).getSmokeFlag() == null) || (get(i).getSmokeFlag().equals("null")))
/* 364 */           pstmt.setString(50, null);
/*     */         else {
/* 366 */           pstmt.setString(50, get(i).getSmokeFlag());
/*     */         }
/* 368 */         if ((get(i).getContPlanCode() == null) || (get(i).getContPlanCode().equals("null")))
/* 369 */           pstmt.setString(51, null);
/*     */         else {
/* 371 */           pstmt.setString(51, get(i).getContPlanCode());
/*     */         }
/* 373 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 374 */           pstmt.setString(52, null);
/*     */         else {
/* 376 */           pstmt.setString(52, get(i).getOperator());
/*     */         }
/* 378 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 379 */           pstmt.setDate(53, null);
/*     */         else {
/* 381 */           pstmt.setDate(53, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 383 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 384 */           pstmt.setString(54, null);
/*     */         else {
/* 386 */           pstmt.setString(54, get(i).getMakeTime());
/*     */         }
/* 388 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 389 */           pstmt.setDate(55, null);
/*     */         else {
/* 391 */           pstmt.setDate(55, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 393 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 394 */           pstmt.setString(56, null);
/*     */         else {
/* 396 */           pstmt.setString(56, get(i).getModifyTime());
/*     */         }
/* 398 */         pstmt.setInt(57, get(i).getInsuredPeoples());
/*     */ 
/* 400 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 401 */           pstmt.setString(58, null);
/*     */         else {
/* 403 */           pstmt.setString(58, get(i).getContNo());
/*     */         }
/* 405 */         if ((get(i).getInsuredId() == null) || (get(i).getInsuredId().equals("null")))
/* 406 */           pstmt.setString(59, null);
/*     */         else {
/* 408 */           pstmt.setString(59, get(i).getInsuredId());
/*     */         }
/* 410 */         pstmt.addBatch();
/*     */       }
/* 412 */       pstmt.executeBatch();
/* 413 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 416 */       ex.printStackTrace();
/* 417 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 418 */       CError tError = new CError();
/* 419 */       tError.moduleName = "LNPInsuredDBSet";
/* 420 */       tError.functionName = "update()";
/* 421 */       tError.errorMessage = ex.toString();
/* 422 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 425 */         pstmt.close(); } catch (Exception e) {
/* 426 */         e.printStackTrace();
/*     */       }
/* 428 */       if (!this.mflag) {
/*     */         try {
/* 430 */           this.con.close(); } catch (Exception e) {
/* 431 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 434 */       return false;
/*     */     }
/*     */ 
/* 437 */     if (!this.mflag) {
/*     */       try {
/* 439 */         this.con.close(); } catch (Exception e) {
/* 440 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 443 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 449 */     PreparedStatement pstmt = null;
/*     */ 
/* 451 */     if (!this.mflag) {
/* 452 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 457 */       int tCount = size();
/* 458 */       pstmt = this.con.prepareStatement("INSERT INTO LNPInsured VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 459 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 461 */         if ((get(i).getGrpContNo() == null) || (get(i).getGrpContNo().equals("null")))
/* 462 */           pstmt.setString(1, null);
/*     */         else {
/* 464 */           pstmt.setString(1, get(i).getGrpContNo());
/*     */         }
/* 466 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 467 */           pstmt.setString(2, null);
/*     */         else {
/* 469 */           pstmt.setString(2, get(i).getContNo());
/*     */         }
/* 471 */         if ((get(i).getProposalContNo() == null) || (get(i).getProposalContNo().equals("null")))
/* 472 */           pstmt.setString(3, null);
/*     */         else {
/* 474 */           pstmt.setString(3, get(i).getProposalContNo());
/*     */         }
/* 476 */         if ((get(i).getInsuredNo() == null) || (get(i).getInsuredNo().equals("null")))
/* 477 */           pstmt.setString(4, null);
/*     */         else {
/* 479 */           pstmt.setString(4, get(i).getInsuredNo());
/*     */         }
/* 481 */         if ((get(i).getInsuredId() == null) || (get(i).getInsuredId().equals("null")))
/* 482 */           pstmt.setString(5, null);
/*     */         else {
/* 484 */           pstmt.setString(5, get(i).getInsuredId());
/*     */         }
/* 486 */         if ((get(i).getPrtNo() == null) || (get(i).getPrtNo().equals("null")))
/* 487 */           pstmt.setString(6, null);
/*     */         else {
/* 489 */           pstmt.setString(6, get(i).getPrtNo());
/*     */         }
/* 491 */         if ((get(i).getAppntNo() == null) || (get(i).getAppntNo().equals("null")))
/* 492 */           pstmt.setString(7, null);
/*     */         else {
/* 494 */           pstmt.setString(7, get(i).getAppntNo());
/*     */         }
/* 496 */         if ((get(i).getAppntId() == null) || (get(i).getAppntId().equals("null")))
/* 497 */           pstmt.setString(8, null);
/*     */         else {
/* 499 */           pstmt.setString(8, get(i).getAppntId());
/*     */         }
/* 501 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 502 */           pstmt.setString(9, null);
/*     */         else {
/* 504 */           pstmt.setString(9, get(i).getManageCom());
/*     */         }
/* 506 */         if ((get(i).getSignCity() == null) || (get(i).getSignCity().equals("null")))
/* 507 */           pstmt.setString(10, null);
/*     */         else {
/* 509 */           pstmt.setString(10, get(i).getSignCity());
/*     */         }
/* 511 */         if ((get(i).getExecuteCom() == null) || (get(i).getExecuteCom().equals("null")))
/* 512 */           pstmt.setString(11, null);
/*     */         else {
/* 514 */           pstmt.setString(11, get(i).getExecuteCom());
/*     */         }
/* 516 */         if ((get(i).getFamilyID() == null) || (get(i).getFamilyID().equals("null")))
/* 517 */           pstmt.setString(12, null);
/*     */         else {
/* 519 */           pstmt.setString(12, get(i).getFamilyID());
/*     */         }
/* 521 */         if ((get(i).getRelationToMainInsured() == null) || (get(i).getRelationToMainInsured().equals("null")))
/* 522 */           pstmt.setString(13, null);
/*     */         else {
/* 524 */           pstmt.setString(13, get(i).getRelationToMainInsured());
/*     */         }
/* 526 */         if ((get(i).getRelationToAppnt() == null) || (get(i).getRelationToAppnt().equals("null")))
/* 527 */           pstmt.setString(14, null);
/*     */         else {
/* 529 */           pstmt.setString(14, get(i).getRelationToAppnt());
/*     */         }
/* 531 */         if ((get(i).getAddressNo() == null) || (get(i).getAddressNo().equals("null")))
/* 532 */           pstmt.setString(15, null);
/*     */         else {
/* 534 */           pstmt.setString(15, get(i).getAddressNo());
/*     */         }
/* 536 */         if ((get(i).getSequenceNo() == null) || (get(i).getSequenceNo().equals("null")))
/* 537 */           pstmt.setString(16, null);
/*     */         else {
/* 539 */           pstmt.setString(16, get(i).getSequenceNo());
/*     */         }
/* 541 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 542 */           pstmt.setString(17, null);
/*     */         else {
/* 544 */           pstmt.setString(17, get(i).getName());
/*     */         }
/* 546 */         if ((get(i).getAppellation() == null) || (get(i).getAppellation().equals("null")))
/* 547 */           pstmt.setString(18, null);
/*     */         else {
/* 549 */           pstmt.setString(18, get(i).getAppellation());
/*     */         }
/* 551 */         if ((get(i).getSex() == null) || (get(i).getSex().equals("null")))
/* 552 */           pstmt.setString(19, null);
/*     */         else {
/* 554 */           pstmt.setString(19, get(i).getSex());
/*     */         }
/* 556 */         if ((get(i).getBirthday() == null) || (get(i).getBirthday().equals("null")))
/* 557 */           pstmt.setDate(20, null);
/*     */         else {
/* 559 */           pstmt.setDate(20, Date.valueOf(get(i).getBirthday()));
/*     */         }
/* 561 */         pstmt.setInt(21, get(i).getAppAge());
/* 562 */         if ((get(i).getAppAgeType() == null) || (get(i).getAppAgeType().equals("null")))
/* 563 */           pstmt.setString(22, null);
/*     */         else {
/* 565 */           pstmt.setString(22, get(i).getAppAgeType());
/*     */         }
/* 567 */         if ((get(i).getIDType() == null) || (get(i).getIDType().equals("null")))
/* 568 */           pstmt.setString(23, null);
/*     */         else {
/* 570 */           pstmt.setString(23, get(i).getIDType());
/*     */         }
/* 572 */         if ((get(i).getIDNo() == null) || (get(i).getIDNo().equals("null")))
/* 573 */           pstmt.setString(24, null);
/*     */         else {
/* 575 */           pstmt.setString(24, get(i).getIDNo());
/*     */         }
/* 577 */         if ((get(i).getIDValidity() == null) || (get(i).getIDValidity().equals("null")))
/* 578 */           pstmt.setDate(25, null);
/*     */         else {
/* 580 */           pstmt.setDate(25, Date.valueOf(get(i).getIDValidity()));
/*     */         }
/* 582 */         if ((get(i).getIDPerpetual() == null) || (get(i).getIDPerpetual().equals("null")))
/* 583 */           pstmt.setString(26, null);
/*     */         else {
/* 585 */           pstmt.setString(26, get(i).getIDPerpetual());
/*     */         }
/* 587 */         if ((get(i).getNativePlace() == null) || (get(i).getNativePlace().equals("null")))
/* 588 */           pstmt.setString(27, null);
/*     */         else {
/* 590 */           pstmt.setString(27, get(i).getNativePlace());
/*     */         }
/* 592 */         if ((get(i).getNationality() == null) || (get(i).getNationality().equals("null")))
/* 593 */           pstmt.setString(28, null);
/*     */         else {
/* 595 */           pstmt.setString(28, get(i).getNationality());
/*     */         }
/* 597 */         if ((get(i).getRgtAddress() == null) || (get(i).getRgtAddress().equals("null")))
/* 598 */           pstmt.setString(29, null);
/*     */         else {
/* 600 */           pstmt.setString(29, get(i).getRgtAddress());
/*     */         }
/* 602 */         if ((get(i).getMarriage() == null) || (get(i).getMarriage().equals("null")))
/* 603 */           pstmt.setString(30, null);
/*     */         else {
/* 605 */           pstmt.setString(30, get(i).getMarriage());
/*     */         }
/* 607 */         if ((get(i).getMarriageDate() == null) || (get(i).getMarriageDate().equals("null")))
/* 608 */           pstmt.setDate(31, null);
/*     */         else {
/* 610 */           pstmt.setDate(31, Date.valueOf(get(i).getMarriageDate()));
/*     */         }
/* 612 */         if ((get(i).getHealth() == null) || (get(i).getHealth().equals("null")))
/* 613 */           pstmt.setString(32, null);
/*     */         else {
/* 615 */           pstmt.setString(32, get(i).getHealth());
/*     */         }
/* 617 */         pstmt.setDouble(33, get(i).getStature());
/* 618 */         pstmt.setDouble(34, get(i).getAvoirdupois());
/* 619 */         if ((get(i).getDegree() == null) || (get(i).getDegree().equals("null")))
/* 620 */           pstmt.setString(35, null);
/*     */         else {
/* 622 */           pstmt.setString(35, get(i).getDegree());
/*     */         }
/* 624 */         if ((get(i).getCreditGrade() == null) || (get(i).getCreditGrade().equals("null")))
/* 625 */           pstmt.setString(36, null);
/*     */         else {
/* 627 */           pstmt.setString(36, get(i).getCreditGrade());
/*     */         }
/* 629 */         if ((get(i).getBankCode() == null) || (get(i).getBankCode().equals("null")))
/* 630 */           pstmt.setString(37, null);
/*     */         else {
/* 632 */           pstmt.setString(37, get(i).getBankCode());
/*     */         }
/* 634 */         if ((get(i).getBankAccNo() == null) || (get(i).getBankAccNo().equals("null")))
/* 635 */           pstmt.setString(38, null);
/*     */         else {
/* 637 */           pstmt.setString(38, get(i).getBankAccNo());
/*     */         }
/* 639 */         if ((get(i).getAccName() == null) || (get(i).getAccName().equals("null")))
/* 640 */           pstmt.setString(39, null);
/*     */         else {
/* 642 */           pstmt.setString(39, get(i).getAccName());
/*     */         }
/* 644 */         if ((get(i).getJoinCompanyDate() == null) || (get(i).getJoinCompanyDate().equals("null")))
/* 645 */           pstmt.setDate(40, null);
/*     */         else {
/* 647 */           pstmt.setDate(40, Date.valueOf(get(i).getJoinCompanyDate()));
/*     */         }
/* 649 */         if ((get(i).getStartWorkDate() == null) || (get(i).getStartWorkDate().equals("null")))
/* 650 */           pstmt.setDate(41, null);
/*     */         else {
/* 652 */           pstmt.setDate(41, Date.valueOf(get(i).getStartWorkDate()));
/*     */         }
/* 654 */         if ((get(i).getPosition() == null) || (get(i).getPosition().equals("null")))
/* 655 */           pstmt.setString(42, null);
/*     */         else {
/* 657 */           pstmt.setString(42, get(i).getPosition());
/*     */         }
/* 659 */         pstmt.setDouble(43, get(i).getSalary());
/* 660 */         if ((get(i).getOccupationType() == null) || (get(i).getOccupationType().equals("null")))
/* 661 */           pstmt.setString(44, null);
/*     */         else {
/* 663 */           pstmt.setString(44, get(i).getOccupationType());
/*     */         }
/* 665 */         if ((get(i).getOccupationCode() == null) || (get(i).getOccupationCode().equals("null")))
/* 666 */           pstmt.setString(45, null);
/*     */         else {
/* 668 */           pstmt.setString(45, get(i).getOccupationCode());
/*     */         }
/* 670 */         if ((get(i).getPartOccupationType() == null) || (get(i).getPartOccupationType().equals("null")))
/* 671 */           pstmt.setString(46, null);
/*     */         else {
/* 673 */           pstmt.setString(46, get(i).getPartOccupationType());
/*     */         }
/* 675 */         if ((get(i).getPartOccupationCode() == null) || (get(i).getPartOccupationCode().equals("null")))
/* 676 */           pstmt.setString(47, null);
/*     */         else {
/* 678 */           pstmt.setString(47, get(i).getPartOccupationCode());
/*     */         }
/* 680 */         if ((get(i).getWorkType() == null) || (get(i).getWorkType().equals("null")))
/* 681 */           pstmt.setString(48, null);
/*     */         else {
/* 683 */           pstmt.setString(48, get(i).getWorkType());
/*     */         }
/* 685 */         if ((get(i).getPluralityType() == null) || (get(i).getPluralityType().equals("null")))
/* 686 */           pstmt.setString(49, null);
/*     */         else {
/* 688 */           pstmt.setString(49, get(i).getPluralityType());
/*     */         }
/* 690 */         if ((get(i).getSmokeFlag() == null) || (get(i).getSmokeFlag().equals("null")))
/* 691 */           pstmt.setString(50, null);
/*     */         else {
/* 693 */           pstmt.setString(50, get(i).getSmokeFlag());
/*     */         }
/* 695 */         if ((get(i).getContPlanCode() == null) || (get(i).getContPlanCode().equals("null")))
/* 696 */           pstmt.setString(51, null);
/*     */         else {
/* 698 */           pstmt.setString(51, get(i).getContPlanCode());
/*     */         }
/* 700 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 701 */           pstmt.setString(52, null);
/*     */         else {
/* 703 */           pstmt.setString(52, get(i).getOperator());
/*     */         }
/* 705 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 706 */           pstmt.setDate(53, null);
/*     */         else {
/* 708 */           pstmt.setDate(53, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 710 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 711 */           pstmt.setString(54, null);
/*     */         else {
/* 713 */           pstmt.setString(54, get(i).getMakeTime());
/*     */         }
/* 715 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 716 */           pstmt.setDate(55, null);
/*     */         else {
/* 718 */           pstmt.setDate(55, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 720 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 721 */           pstmt.setString(56, null);
/*     */         else {
/* 723 */           pstmt.setString(56, get(i).getModifyTime());
/*     */         }
/* 725 */         pstmt.setInt(57, get(i).getInsuredPeoples());
/* 726 */         pstmt.addBatch();
/*     */       }
/* 728 */       pstmt.executeBatch();
/* 729 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 732 */       ex.printStackTrace();
/* 733 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 734 */       CError tError = new CError();
/* 735 */       tError.moduleName = "LNPInsuredDBSet";
/* 736 */       tError.functionName = "insert()";
/* 737 */       tError.errorMessage = ex.toString();
/* 738 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 741 */         pstmt.close(); } catch (Exception e) {
/* 742 */         e.printStackTrace();
/*     */       }
/* 744 */       if (!this.mflag) {
/*     */         try {
/* 746 */           this.con.close(); } catch (Exception e) {
/* 747 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 750 */       return false;
/*     */     }
/*     */ 
/* 753 */     if (!this.mflag) {
/*     */       try {
/* 755 */         this.con.close(); } catch (Exception e) {
/* 756 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 759 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPInsuredDBSet
 * JD-Core Version:    0.6.0
 */