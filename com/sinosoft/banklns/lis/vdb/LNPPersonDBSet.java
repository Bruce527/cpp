/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPPersonSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPPersonSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPPersonDBSet extends LNPPersonSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPPersonDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPPerson");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPPersonDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPPerson");
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
/*  50 */     tError.moduleName = "LNPPersonDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPPerson WHERE  CustomerId = ? AND AgentCode = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getCustomerId() == null) || (get(i).getCustomerId().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getCustomerId());
/*     */         }
/*  78 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/*  79 */           pstmt.setString(2, null);
/*     */         else {
/*  81 */           pstmt.setString(2, get(i).getAgentCode());
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
/*  92 */       tError.moduleName = "LNPPersonDBSet";
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
/* 131 */       pstmt = this.con.prepareStatement("UPDATE LNPPerson SET  CustomerId = ? , AgentCode = ? , CustomerNo = ? , Appellation = ? , Name = ? , Sex = ? , Birthday = ? , Age = ? , AgeType = ? , AppntType = ? , IDType = ? , IDNo = ? , IDValidity = ? , IDPerpetual = ? , Password = ? , NativePlace = ? , Nationality = ? , RgtAddress = ? , Marriage = ? , MarriageDate = ? , Health = ? , Stature = ? , Avoirdupois = ? , Degree = ? , CreditGrade = ? , BankCode = ? , BankAccNo = ? , AccName = ? , OthIDType = ? , OthIDNo = ? , ICNo = ? , GrpNo = ? , JoinCompanyDate = ? , StartWorkDate = ? , Position = ? , Salary = ? , OccupationType = ? , OccupationCode = ? , PartOccupationType = ? , PartOccupationCode = ? , WorkType = ? , PluralityType = ? , DeathDate = ? , SmokeFlag = ? , BlacklistFlag = ? , Proterty = ? , Remark = ? , State = ? , VIPValue = ? , Operator = ? , ManageCom = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , GrpName = ? WHERE  CustomerId = ? AND AgentCode = ?");
/* 132 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 134 */         if ((get(i).getCustomerId() == null) || (get(i).getCustomerId().equals("null")))
/* 135 */           pstmt.setString(1, null);
/*     */         else {
/* 137 */           pstmt.setString(1, get(i).getCustomerId());
/*     */         }
/* 139 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/* 140 */           pstmt.setString(2, null);
/*     */         else {
/* 142 */           pstmt.setString(2, get(i).getAgentCode());
/*     */         }
/* 144 */         if ((get(i).getCustomerNo() == null) || (get(i).getCustomerNo().equals("null")))
/* 145 */           pstmt.setString(3, null);
/*     */         else {
/* 147 */           pstmt.setString(3, get(i).getCustomerNo());
/*     */         }
/* 149 */         if ((get(i).getAppellation() == null) || (get(i).getAppellation().equals("null")))
/* 150 */           pstmt.setString(4, null);
/*     */         else {
/* 152 */           pstmt.setString(4, get(i).getAppellation());
/*     */         }
/* 154 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 155 */           pstmt.setString(5, null);
/*     */         else {
/* 157 */           pstmt.setString(5, get(i).getName());
/*     */         }
/* 159 */         if ((get(i).getSex() == null) || (get(i).getSex().equals("null")))
/* 160 */           pstmt.setString(6, null);
/*     */         else {
/* 162 */           pstmt.setString(6, get(i).getSex());
/*     */         }
/* 164 */         if ((get(i).getBirthday() == null) || (get(i).getBirthday().equals("null")))
/* 165 */           pstmt.setDate(7, null);
/*     */         else {
/* 167 */           pstmt.setDate(7, Date.valueOf(get(i).getBirthday()));
/*     */         }
/* 169 */         pstmt.setInt(8, get(i).getAge());
/* 170 */         if ((get(i).getAgeType() == null) || (get(i).getAgeType().equals("null")))
/* 171 */           pstmt.setString(9, null);
/*     */         else {
/* 173 */           pstmt.setString(9, get(i).getAgeType());
/*     */         }
/* 175 */         if ((get(i).getAppntType() == null) || (get(i).getAppntType().equals("null")))
/* 176 */           pstmt.setString(10, null);
/*     */         else {
/* 178 */           pstmt.setString(10, get(i).getAppntType());
/*     */         }
/* 180 */         if ((get(i).getIDType() == null) || (get(i).getIDType().equals("null")))
/* 181 */           pstmt.setString(11, null);
/*     */         else {
/* 183 */           pstmt.setString(11, get(i).getIDType());
/*     */         }
/* 185 */         if ((get(i).getIDNo() == null) || (get(i).getIDNo().equals("null")))
/* 186 */           pstmt.setString(12, null);
/*     */         else {
/* 188 */           pstmt.setString(12, get(i).getIDNo());
/*     */         }
/* 190 */         if ((get(i).getIDValidity() == null) || (get(i).getIDValidity().equals("null")))
/* 191 */           pstmt.setDate(13, null);
/*     */         else {
/* 193 */           pstmt.setDate(13, Date.valueOf(get(i).getIDValidity()));
/*     */         }
/* 195 */         if ((get(i).getIDPerpetual() == null) || (get(i).getIDPerpetual().equals("null")))
/* 196 */           pstmt.setString(14, null);
/*     */         else {
/* 198 */           pstmt.setString(14, get(i).getIDPerpetual());
/*     */         }
/* 200 */         if ((get(i).getPassword() == null) || (get(i).getPassword().equals("null")))
/* 201 */           pstmt.setString(15, null);
/*     */         else {
/* 203 */           pstmt.setString(15, get(i).getPassword());
/*     */         }
/* 205 */         if ((get(i).getNativePlace() == null) || (get(i).getNativePlace().equals("null")))
/* 206 */           pstmt.setString(16, null);
/*     */         else {
/* 208 */           pstmt.setString(16, get(i).getNativePlace());
/*     */         }
/* 210 */         if ((get(i).getNationality() == null) || (get(i).getNationality().equals("null")))
/* 211 */           pstmt.setString(17, null);
/*     */         else {
/* 213 */           pstmt.setString(17, get(i).getNationality());
/*     */         }
/* 215 */         if ((get(i).getRgtAddress() == null) || (get(i).getRgtAddress().equals("null")))
/* 216 */           pstmt.setString(18, null);
/*     */         else {
/* 218 */           pstmt.setString(18, get(i).getRgtAddress());
/*     */         }
/* 220 */         if ((get(i).getMarriage() == null) || (get(i).getMarriage().equals("null")))
/* 221 */           pstmt.setString(19, null);
/*     */         else {
/* 223 */           pstmt.setString(19, get(i).getMarriage());
/*     */         }
/* 225 */         if ((get(i).getMarriageDate() == null) || (get(i).getMarriageDate().equals("null")))
/* 226 */           pstmt.setDate(20, null);
/*     */         else {
/* 228 */           pstmt.setDate(20, Date.valueOf(get(i).getMarriageDate()));
/*     */         }
/* 230 */         if ((get(i).getHealth() == null) || (get(i).getHealth().equals("null")))
/* 231 */           pstmt.setString(21, null);
/*     */         else {
/* 233 */           pstmt.setString(21, get(i).getHealth());
/*     */         }
/* 235 */         pstmt.setDouble(22, get(i).getStature());
/* 236 */         pstmt.setDouble(23, get(i).getAvoirdupois());
/* 237 */         if ((get(i).getDegree() == null) || (get(i).getDegree().equals("null")))
/* 238 */           pstmt.setString(24, null);
/*     */         else {
/* 240 */           pstmt.setString(24, get(i).getDegree());
/*     */         }
/* 242 */         if ((get(i).getCreditGrade() == null) || (get(i).getCreditGrade().equals("null")))
/* 243 */           pstmt.setString(25, null);
/*     */         else {
/* 245 */           pstmt.setString(25, get(i).getCreditGrade());
/*     */         }
/* 247 */         if ((get(i).getBankCode() == null) || (get(i).getBankCode().equals("null")))
/* 248 */           pstmt.setString(26, null);
/*     */         else {
/* 250 */           pstmt.setString(26, get(i).getBankCode());
/*     */         }
/* 252 */         if ((get(i).getBankAccNo() == null) || (get(i).getBankAccNo().equals("null")))
/* 253 */           pstmt.setString(27, null);
/*     */         else {
/* 255 */           pstmt.setString(27, get(i).getBankAccNo());
/*     */         }
/* 257 */         if ((get(i).getAccName() == null) || (get(i).getAccName().equals("null")))
/* 258 */           pstmt.setString(28, null);
/*     */         else {
/* 260 */           pstmt.setString(28, get(i).getAccName());
/*     */         }
/* 262 */         if ((get(i).getOthIDType() == null) || (get(i).getOthIDType().equals("null")))
/* 263 */           pstmt.setString(29, null);
/*     */         else {
/* 265 */           pstmt.setString(29, get(i).getOthIDType());
/*     */         }
/* 267 */         if ((get(i).getOthIDNo() == null) || (get(i).getOthIDNo().equals("null")))
/* 268 */           pstmt.setString(30, null);
/*     */         else {
/* 270 */           pstmt.setString(30, get(i).getOthIDNo());
/*     */         }
/* 272 */         if ((get(i).getICNo() == null) || (get(i).getICNo().equals("null")))
/* 273 */           pstmt.setString(31, null);
/*     */         else {
/* 275 */           pstmt.setString(31, get(i).getICNo());
/*     */         }
/* 277 */         if ((get(i).getGrpNo() == null) || (get(i).getGrpNo().equals("null")))
/* 278 */           pstmt.setString(32, null);
/*     */         else {
/* 280 */           pstmt.setString(32, get(i).getGrpNo());
/*     */         }
/* 282 */         if ((get(i).getJoinCompanyDate() == null) || (get(i).getJoinCompanyDate().equals("null")))
/* 283 */           pstmt.setDate(33, null);
/*     */         else {
/* 285 */           pstmt.setDate(33, Date.valueOf(get(i).getJoinCompanyDate()));
/*     */         }
/* 287 */         if ((get(i).getStartWorkDate() == null) || (get(i).getStartWorkDate().equals("null")))
/* 288 */           pstmt.setDate(34, null);
/*     */         else {
/* 290 */           pstmt.setDate(34, Date.valueOf(get(i).getStartWorkDate()));
/*     */         }
/* 292 */         if ((get(i).getPosition() == null) || (get(i).getPosition().equals("null")))
/* 293 */           pstmt.setString(35, null);
/*     */         else {
/* 295 */           pstmt.setString(35, get(i).getPosition());
/*     */         }
/* 297 */         pstmt.setDouble(36, get(i).getSalary());
/* 298 */         if ((get(i).getOccupationType() == null) || (get(i).getOccupationType().equals("null")))
/* 299 */           pstmt.setString(37, null);
/*     */         else {
/* 301 */           pstmt.setString(37, get(i).getOccupationType());
/*     */         }
/* 303 */         if ((get(i).getOccupationCode() == null) || (get(i).getOccupationCode().equals("null")))
/* 304 */           pstmt.setString(38, null);
/*     */         else {
/* 306 */           pstmt.setString(38, get(i).getOccupationCode());
/*     */         }
/* 308 */         if ((get(i).getPartOccupationType() == null) || (get(i).getPartOccupationType().equals("null")))
/* 309 */           pstmt.setString(39, null);
/*     */         else {
/* 311 */           pstmt.setString(39, get(i).getPartOccupationType());
/*     */         }
/* 313 */         if ((get(i).getPartOccupationCode() == null) || (get(i).getPartOccupationCode().equals("null")))
/* 314 */           pstmt.setString(40, null);
/*     */         else {
/* 316 */           pstmt.setString(40, get(i).getPartOccupationCode());
/*     */         }
/* 318 */         if ((get(i).getWorkType() == null) || (get(i).getWorkType().equals("null")))
/* 319 */           pstmt.setString(41, null);
/*     */         else {
/* 321 */           pstmt.setString(41, get(i).getWorkType());
/*     */         }
/* 323 */         if ((get(i).getPluralityType() == null) || (get(i).getPluralityType().equals("null")))
/* 324 */           pstmt.setString(42, null);
/*     */         else {
/* 326 */           pstmt.setString(42, get(i).getPluralityType());
/*     */         }
/* 328 */         if ((get(i).getDeathDate() == null) || (get(i).getDeathDate().equals("null")))
/* 329 */           pstmt.setDate(43, null);
/*     */         else {
/* 331 */           pstmt.setDate(43, Date.valueOf(get(i).getDeathDate()));
/*     */         }
/* 333 */         if ((get(i).getSmokeFlag() == null) || (get(i).getSmokeFlag().equals("null")))
/* 334 */           pstmt.setString(44, null);
/*     */         else {
/* 336 */           pstmt.setString(44, get(i).getSmokeFlag());
/*     */         }
/* 338 */         if ((get(i).getBlacklistFlag() == null) || (get(i).getBlacklistFlag().equals("null")))
/* 339 */           pstmt.setString(45, null);
/*     */         else {
/* 341 */           pstmt.setString(45, get(i).getBlacklistFlag());
/*     */         }
/* 343 */         if ((get(i).getProterty() == null) || (get(i).getProterty().equals("null")))
/* 344 */           pstmt.setString(46, null);
/*     */         else {
/* 346 */           pstmt.setString(46, get(i).getProterty());
/*     */         }
/* 348 */         if ((get(i).getRemark() == null) || (get(i).getRemark().equals("null")))
/* 349 */           pstmt.setString(47, null);
/*     */         else {
/* 351 */           pstmt.setString(47, get(i).getRemark());
/*     */         }
/* 353 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 354 */           pstmt.setString(48, null);
/*     */         else {
/* 356 */           pstmt.setString(48, get(i).getState());
/*     */         }
/* 358 */         if ((get(i).getVIPValue() == null) || (get(i).getVIPValue().equals("null")))
/* 359 */           pstmt.setString(49, null);
/*     */         else {
/* 361 */           pstmt.setString(49, get(i).getVIPValue());
/*     */         }
/* 363 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 364 */           pstmt.setString(50, null);
/*     */         else {
/* 366 */           pstmt.setString(50, get(i).getOperator());
/*     */         }
/* 368 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 369 */           pstmt.setString(51, null);
/*     */         else {
/* 371 */           pstmt.setString(51, get(i).getManageCom());
/*     */         }
/* 373 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 374 */           pstmt.setDate(52, null);
/*     */         else {
/* 376 */           pstmt.setDate(52, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 378 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 379 */           pstmt.setString(53, null);
/*     */         else {
/* 381 */           pstmt.setString(53, get(i).getMakeTime());
/*     */         }
/* 383 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 384 */           pstmt.setDate(54, null);
/*     */         else {
/* 386 */           pstmt.setDate(54, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 388 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 389 */           pstmt.setString(55, null);
/*     */         else {
/* 391 */           pstmt.setString(55, get(i).getModifyTime());
/*     */         }
/* 393 */         if ((get(i).getGrpName() == null) || (get(i).getGrpName().equals("null")))
/* 394 */           pstmt.setString(56, null);
/*     */         else {
/* 396 */           pstmt.setString(56, get(i).getGrpName());
/*     */         }
/*     */ 
/* 399 */         if ((get(i).getCustomerId() == null) || (get(i).getCustomerId().equals("null")))
/* 400 */           pstmt.setString(57, null);
/*     */         else {
/* 402 */           pstmt.setString(57, get(i).getCustomerId());
/*     */         }
/* 404 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/* 405 */           pstmt.setString(58, null);
/*     */         else {
/* 407 */           pstmt.setString(58, get(i).getAgentCode());
/*     */         }
/* 409 */         pstmt.addBatch();
/*     */       }
/* 411 */       pstmt.executeBatch();
/* 412 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 415 */       ex.printStackTrace();
/* 416 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 417 */       CError tError = new CError();
/* 418 */       tError.moduleName = "LNPPersonDBSet";
/* 419 */       tError.functionName = "update()";
/* 420 */       tError.errorMessage = ex.toString();
/* 421 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 424 */         pstmt.close(); } catch (Exception e) {
/* 425 */         e.printStackTrace();
/*     */       }
/* 427 */       if (!this.mflag) {
/*     */         try {
/* 429 */           this.con.close(); } catch (Exception e) {
/* 430 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 433 */       return false;
/*     */     }
/*     */ 
/* 436 */     if (!this.mflag) {
/*     */       try {
/* 438 */         this.con.close(); } catch (Exception e) {
/* 439 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 442 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 448 */     PreparedStatement pstmt = null;
/*     */ 
/* 450 */     if (!this.mflag) {
/* 451 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 456 */       int tCount = size();
/* 457 */       pstmt = this.con.prepareStatement("INSERT INTO LNPPerson VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 458 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 460 */         if ((get(i).getCustomerId() == null) || (get(i).getCustomerId().equals("null")))
/* 461 */           pstmt.setString(1, null);
/*     */         else {
/* 463 */           pstmt.setString(1, get(i).getCustomerId());
/*     */         }
/* 465 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/* 466 */           pstmt.setString(2, null);
/*     */         else {
/* 468 */           pstmt.setString(2, get(i).getAgentCode());
/*     */         }
/* 470 */         if ((get(i).getCustomerNo() == null) || (get(i).getCustomerNo().equals("null")))
/* 471 */           pstmt.setString(3, null);
/*     */         else {
/* 473 */           pstmt.setString(3, get(i).getCustomerNo());
/*     */         }
/* 475 */         if ((get(i).getAppellation() == null) || (get(i).getAppellation().equals("null")))
/* 476 */           pstmt.setString(4, null);
/*     */         else {
/* 478 */           pstmt.setString(4, get(i).getAppellation());
/*     */         }
/* 480 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 481 */           pstmt.setString(5, null);
/*     */         else {
/* 483 */           pstmt.setString(5, get(i).getName());
/*     */         }
/* 485 */         if ((get(i).getSex() == null) || (get(i).getSex().equals("null")))
/* 486 */           pstmt.setString(6, null);
/*     */         else {
/* 488 */           pstmt.setString(6, get(i).getSex());
/*     */         }
/* 490 */         if ((get(i).getBirthday() == null) || (get(i).getBirthday().equals("null")))
/* 491 */           pstmt.setDate(7, null);
/*     */         else {
/* 493 */           pstmt.setDate(7, Date.valueOf(get(i).getBirthday()));
/*     */         }
/* 495 */         pstmt.setInt(8, get(i).getAge());
/* 496 */         if ((get(i).getAgeType() == null) || (get(i).getAgeType().equals("null")))
/* 497 */           pstmt.setString(9, null);
/*     */         else {
/* 499 */           pstmt.setString(9, get(i).getAgeType());
/*     */         }
/* 501 */         if ((get(i).getAppntType() == null) || (get(i).getAppntType().equals("null")))
/* 502 */           pstmt.setString(10, null);
/*     */         else {
/* 504 */           pstmt.setString(10, get(i).getAppntType());
/*     */         }
/* 506 */         if ((get(i).getIDType() == null) || (get(i).getIDType().equals("null")))
/* 507 */           pstmt.setString(11, null);
/*     */         else {
/* 509 */           pstmt.setString(11, get(i).getIDType());
/*     */         }
/* 511 */         if ((get(i).getIDNo() == null) || (get(i).getIDNo().equals("null")))
/* 512 */           pstmt.setString(12, null);
/*     */         else {
/* 514 */           pstmt.setString(12, get(i).getIDNo());
/*     */         }
/* 516 */         if ((get(i).getIDValidity() == null) || (get(i).getIDValidity().equals("null")))
/* 517 */           pstmt.setDate(13, null);
/*     */         else {
/* 519 */           pstmt.setDate(13, Date.valueOf(get(i).getIDValidity()));
/*     */         }
/* 521 */         if ((get(i).getIDPerpetual() == null) || (get(i).getIDPerpetual().equals("null")))
/* 522 */           pstmt.setString(14, null);
/*     */         else {
/* 524 */           pstmt.setString(14, get(i).getIDPerpetual());
/*     */         }
/* 526 */         if ((get(i).getPassword() == null) || (get(i).getPassword().equals("null")))
/* 527 */           pstmt.setString(15, null);
/*     */         else {
/* 529 */           pstmt.setString(15, get(i).getPassword());
/*     */         }
/* 531 */         if ((get(i).getNativePlace() == null) || (get(i).getNativePlace().equals("null")))
/* 532 */           pstmt.setString(16, null);
/*     */         else {
/* 534 */           pstmt.setString(16, get(i).getNativePlace());
/*     */         }
/* 536 */         if ((get(i).getNationality() == null) || (get(i).getNationality().equals("null")))
/* 537 */           pstmt.setString(17, null);
/*     */         else {
/* 539 */           pstmt.setString(17, get(i).getNationality());
/*     */         }
/* 541 */         if ((get(i).getRgtAddress() == null) || (get(i).getRgtAddress().equals("null")))
/* 542 */           pstmt.setString(18, null);
/*     */         else {
/* 544 */           pstmt.setString(18, get(i).getRgtAddress());
/*     */         }
/* 546 */         if ((get(i).getMarriage() == null) || (get(i).getMarriage().equals("null")))
/* 547 */           pstmt.setString(19, null);
/*     */         else {
/* 549 */           pstmt.setString(19, get(i).getMarriage());
/*     */         }
/* 551 */         if ((get(i).getMarriageDate() == null) || (get(i).getMarriageDate().equals("null")))
/* 552 */           pstmt.setDate(20, null);
/*     */         else {
/* 554 */           pstmt.setDate(20, Date.valueOf(get(i).getMarriageDate()));
/*     */         }
/* 556 */         if ((get(i).getHealth() == null) || (get(i).getHealth().equals("null")))
/* 557 */           pstmt.setString(21, null);
/*     */         else {
/* 559 */           pstmt.setString(21, get(i).getHealth());
/*     */         }
/* 561 */         pstmt.setDouble(22, get(i).getStature());
/* 562 */         pstmt.setDouble(23, get(i).getAvoirdupois());
/* 563 */         if ((get(i).getDegree() == null) || (get(i).getDegree().equals("null")))
/* 564 */           pstmt.setString(24, null);
/*     */         else {
/* 566 */           pstmt.setString(24, get(i).getDegree());
/*     */         }
/* 568 */         if ((get(i).getCreditGrade() == null) || (get(i).getCreditGrade().equals("null")))
/* 569 */           pstmt.setString(25, null);
/*     */         else {
/* 571 */           pstmt.setString(25, get(i).getCreditGrade());
/*     */         }
/* 573 */         if ((get(i).getBankCode() == null) || (get(i).getBankCode().equals("null")))
/* 574 */           pstmt.setString(26, null);
/*     */         else {
/* 576 */           pstmt.setString(26, get(i).getBankCode());
/*     */         }
/* 578 */         if ((get(i).getBankAccNo() == null) || (get(i).getBankAccNo().equals("null")))
/* 579 */           pstmt.setString(27, null);
/*     */         else {
/* 581 */           pstmt.setString(27, get(i).getBankAccNo());
/*     */         }
/* 583 */         if ((get(i).getAccName() == null) || (get(i).getAccName().equals("null")))
/* 584 */           pstmt.setString(28, null);
/*     */         else {
/* 586 */           pstmt.setString(28, get(i).getAccName());
/*     */         }
/* 588 */         if ((get(i).getOthIDType() == null) || (get(i).getOthIDType().equals("null")))
/* 589 */           pstmt.setString(29, null);
/*     */         else {
/* 591 */           pstmt.setString(29, get(i).getOthIDType());
/*     */         }
/* 593 */         if ((get(i).getOthIDNo() == null) || (get(i).getOthIDNo().equals("null")))
/* 594 */           pstmt.setString(30, null);
/*     */         else {
/* 596 */           pstmt.setString(30, get(i).getOthIDNo());
/*     */         }
/* 598 */         if ((get(i).getICNo() == null) || (get(i).getICNo().equals("null")))
/* 599 */           pstmt.setString(31, null);
/*     */         else {
/* 601 */           pstmt.setString(31, get(i).getICNo());
/*     */         }
/* 603 */         if ((get(i).getGrpNo() == null) || (get(i).getGrpNo().equals("null")))
/* 604 */           pstmt.setString(32, null);
/*     */         else {
/* 606 */           pstmt.setString(32, get(i).getGrpNo());
/*     */         }
/* 608 */         if ((get(i).getJoinCompanyDate() == null) || (get(i).getJoinCompanyDate().equals("null")))
/* 609 */           pstmt.setDate(33, null);
/*     */         else {
/* 611 */           pstmt.setDate(33, Date.valueOf(get(i).getJoinCompanyDate()));
/*     */         }
/* 613 */         if ((get(i).getStartWorkDate() == null) || (get(i).getStartWorkDate().equals("null")))
/* 614 */           pstmt.setDate(34, null);
/*     */         else {
/* 616 */           pstmt.setDate(34, Date.valueOf(get(i).getStartWorkDate()));
/*     */         }
/* 618 */         if ((get(i).getPosition() == null) || (get(i).getPosition().equals("null")))
/* 619 */           pstmt.setString(35, null);
/*     */         else {
/* 621 */           pstmt.setString(35, get(i).getPosition());
/*     */         }
/* 623 */         pstmt.setDouble(36, get(i).getSalary());
/* 624 */         if ((get(i).getOccupationType() == null) || (get(i).getOccupationType().equals("null")))
/* 625 */           pstmt.setString(37, null);
/*     */         else {
/* 627 */           pstmt.setString(37, get(i).getOccupationType());
/*     */         }
/* 629 */         if ((get(i).getOccupationCode() == null) || (get(i).getOccupationCode().equals("null")))
/* 630 */           pstmt.setString(38, null);
/*     */         else {
/* 632 */           pstmt.setString(38, get(i).getOccupationCode());
/*     */         }
/* 634 */         if ((get(i).getPartOccupationType() == null) || (get(i).getPartOccupationType().equals("null")))
/* 635 */           pstmt.setString(39, null);
/*     */         else {
/* 637 */           pstmt.setString(39, get(i).getPartOccupationType());
/*     */         }
/* 639 */         if ((get(i).getPartOccupationCode() == null) || (get(i).getPartOccupationCode().equals("null")))
/* 640 */           pstmt.setString(40, null);
/*     */         else {
/* 642 */           pstmt.setString(40, get(i).getPartOccupationCode());
/*     */         }
/* 644 */         if ((get(i).getWorkType() == null) || (get(i).getWorkType().equals("null")))
/* 645 */           pstmt.setString(41, null);
/*     */         else {
/* 647 */           pstmt.setString(41, get(i).getWorkType());
/*     */         }
/* 649 */         if ((get(i).getPluralityType() == null) || (get(i).getPluralityType().equals("null")))
/* 650 */           pstmt.setString(42, null);
/*     */         else {
/* 652 */           pstmt.setString(42, get(i).getPluralityType());
/*     */         }
/* 654 */         if ((get(i).getDeathDate() == null) || (get(i).getDeathDate().equals("null")))
/* 655 */           pstmt.setDate(43, null);
/*     */         else {
/* 657 */           pstmt.setDate(43, Date.valueOf(get(i).getDeathDate()));
/*     */         }
/* 659 */         if ((get(i).getSmokeFlag() == null) || (get(i).getSmokeFlag().equals("null")))
/* 660 */           pstmt.setString(44, null);
/*     */         else {
/* 662 */           pstmt.setString(44, get(i).getSmokeFlag());
/*     */         }
/* 664 */         if ((get(i).getBlacklistFlag() == null) || (get(i).getBlacklistFlag().equals("null")))
/* 665 */           pstmt.setString(45, null);
/*     */         else {
/* 667 */           pstmt.setString(45, get(i).getBlacklistFlag());
/*     */         }
/* 669 */         if ((get(i).getProterty() == null) || (get(i).getProterty().equals("null")))
/* 670 */           pstmt.setString(46, null);
/*     */         else {
/* 672 */           pstmt.setString(46, get(i).getProterty());
/*     */         }
/* 674 */         if ((get(i).getRemark() == null) || (get(i).getRemark().equals("null")))
/* 675 */           pstmt.setString(47, null);
/*     */         else {
/* 677 */           pstmt.setString(47, get(i).getRemark());
/*     */         }
/* 679 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 680 */           pstmt.setString(48, null);
/*     */         else {
/* 682 */           pstmt.setString(48, get(i).getState());
/*     */         }
/* 684 */         if ((get(i).getVIPValue() == null) || (get(i).getVIPValue().equals("null")))
/* 685 */           pstmt.setString(49, null);
/*     */         else {
/* 687 */           pstmt.setString(49, get(i).getVIPValue());
/*     */         }
/* 689 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 690 */           pstmt.setString(50, null);
/*     */         else {
/* 692 */           pstmt.setString(50, get(i).getOperator());
/*     */         }
/* 694 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 695 */           pstmt.setString(51, null);
/*     */         else {
/* 697 */           pstmt.setString(51, get(i).getManageCom());
/*     */         }
/* 699 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 700 */           pstmt.setDate(52, null);
/*     */         else {
/* 702 */           pstmt.setDate(52, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 704 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 705 */           pstmt.setString(53, null);
/*     */         else {
/* 707 */           pstmt.setString(53, get(i).getMakeTime());
/*     */         }
/* 709 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 710 */           pstmt.setDate(54, null);
/*     */         else {
/* 712 */           pstmt.setDate(54, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 714 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 715 */           pstmt.setString(55, null);
/*     */         else {
/* 717 */           pstmt.setString(55, get(i).getModifyTime());
/*     */         }
/* 719 */         if ((get(i).getGrpName() == null) || (get(i).getGrpName().equals("null")))
/* 720 */           pstmt.setString(56, null);
/*     */         else {
/* 722 */           pstmt.setString(56, get(i).getGrpName());
/*     */         }
/* 724 */         pstmt.addBatch();
/*     */       }
/* 726 */       pstmt.executeBatch();
/* 727 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 730 */       ex.printStackTrace();
/* 731 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 732 */       CError tError = new CError();
/* 733 */       tError.moduleName = "LNPPersonDBSet";
/* 734 */       tError.functionName = "insert()";
/* 735 */       tError.errorMessage = ex.toString();
/* 736 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 739 */         pstmt.close(); } catch (Exception e) {
/* 740 */         e.printStackTrace();
/*     */       }
/* 742 */       if (!this.mflag) {
/*     */         try {
/* 744 */           this.con.close(); } catch (Exception e) {
/* 745 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 748 */       return false;
/*     */     }
/*     */ 
/* 751 */     if (!this.mflag) {
/*     */       try {
/* 753 */         this.con.close(); } catch (Exception e) {
/* 754 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 757 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPPersonDBSet
 * JD-Core Version:    0.6.0
 */