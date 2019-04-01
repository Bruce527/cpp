/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MNewClientSchema;
/*     */ import com.sinosoft.map.lis.vschema.MNewClientSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MNewClientDBSet extends MNewClientSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MNewClientDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MNewClient");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MNewClientDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MNewClient");
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
/*  49 */     tError.moduleName = "MNewClientDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MNewClient WHERE  CustomerNo = ?");
/*  70 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  72 */         if ((get(i).getCustomerNo() == null) || (get(i).getCustomerNo().equals("null")))
/*  73 */           pstmt.setString(1, null);
/*     */         else {
/*  75 */           pstmt.setString(1, get(i).getCustomerNo());
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
/*  86 */       tError.moduleName = "MNewClientDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MNewClient SET  CustomerNo = ? , CustomerNo2 = ? , ClientName = ? , Gender = ? , Birthday = ? , EMail = ? , GrpZipCode = ? , GrpAddress = ? , GrpNo = ? , BP = ? , GrpAddressCode = ? , Phone2 = ? , GrpName = ? , GrpPhone = ? , Phone = ? , Mobile = ? , OccupationCode = ? , Position = ? , WorkType = ? , OccupationType = ? , HomeAddress = ? , HomeAddressCode = ? , RgtAddress = ? , PostalAddress = ? , ZipCode = ? , HomeZipCode = ? , SequenceNo = ? , Stature = ? , Avoirdupois = ? , SmokeFlag = ? , DeathDate = ? , Marriage = ? , CredentType = ? , CredentNO = ? , OthIDNo = ? , OthIDType = ? , ICNo = ? , Salary = ? , YearSalary = ? , NativePlace = ? , Nationality = ? , MarriageDate = ? , Degree = ? , PolNo = ? , RelationToInsured = ? , PluralityType = ? , StartWorkDate = ? , Health = ? , Password = ? , JoinCompanyDate = ? , AppntGrade = ? , CreditGrade = ? , ClientType = ? , State = ? , Agentcode = ? , SignDate = ? , AddrChoise = ? , CustomeProperty = ? , BirthdayFlag = ? , Appellation = ? , IDDNo = ? , ValidityDate = ? , CountryOrArea = ? , SpecialDate = ? , DeleteFlag = ? , Interest = ? , CustomeType = ? , Introducer = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  CustomerNo = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getCustomerNo() == null) || (get(i).getCustomerNo().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getCustomerNo());
/*     */         }
/* 133 */         if ((get(i).getCustomerNo2() == null) || (get(i).getCustomerNo2().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getCustomerNo2());
/*     */         }
/* 138 */         if ((get(i).getClientName() == null) || (get(i).getClientName().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getClientName());
/*     */         }
/* 143 */         if ((get(i).getGender() == null) || (get(i).getGender().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getGender());
/*     */         }
/* 148 */         if ((get(i).getEMail() == null) || (get(i).getEMail().equals("null")))
/* 149 */           pstmt.setString(6, null);
/*     */         else {
/* 151 */           pstmt.setString(6, get(i).getEMail());
/*     */         }
/* 153 */         if ((get(i).getGrpZipCode() == null) || (get(i).getGrpZipCode().equals("null")))
/* 154 */           pstmt.setString(7, null);
/*     */         else {
/* 156 */           pstmt.setString(7, get(i).getGrpZipCode());
/*     */         }
/* 158 */         if ((get(i).getGrpAddress() == null) || (get(i).getGrpAddress().equals("null")))
/* 159 */           pstmt.setString(8, null);
/*     */         else {
/* 161 */           pstmt.setString(8, get(i).getGrpAddress());
/*     */         }
/* 163 */         if ((get(i).getGrpNo() == null) || (get(i).getGrpNo().equals("null")))
/* 164 */           pstmt.setString(9, null);
/*     */         else {
/* 166 */           pstmt.setString(9, get(i).getGrpNo());
/*     */         }
/* 168 */         if ((get(i).getBP() == null) || (get(i).getBP().equals("null")))
/* 169 */           pstmt.setString(10, null);
/*     */         else {
/* 171 */           pstmt.setString(10, get(i).getBP());
/*     */         }
/* 173 */         if ((get(i).getGrpAddressCode() == null) || (get(i).getGrpAddressCode().equals("null")))
/* 174 */           pstmt.setString(11, null);
/*     */         else {
/* 176 */           pstmt.setString(11, get(i).getGrpAddressCode());
/*     */         }
/* 178 */         if ((get(i).getPhone2() == null) || (get(i).getPhone2().equals("null")))
/* 179 */           pstmt.setString(12, null);
/*     */         else {
/* 181 */           pstmt.setString(12, get(i).getPhone2());
/*     */         }
/* 183 */         if ((get(i).getGrpName() == null) || (get(i).getGrpName().equals("null")))
/* 184 */           pstmt.setString(13, null);
/*     */         else {
/* 186 */           pstmt.setString(13, get(i).getGrpName());
/*     */         }
/* 188 */         if ((get(i).getGrpPhone() == null) || (get(i).getGrpPhone().equals("null")))
/* 189 */           pstmt.setString(14, null);
/*     */         else {
/* 191 */           pstmt.setString(14, get(i).getGrpPhone());
/*     */         }
/* 193 */         if ((get(i).getPhone() == null) || (get(i).getPhone().equals("null")))
/* 194 */           pstmt.setString(15, null);
/*     */         else {
/* 196 */           pstmt.setString(15, get(i).getPhone());
/*     */         }
/* 198 */         if ((get(i).getMobile() == null) || (get(i).getMobile().equals("null")))
/* 199 */           pstmt.setString(16, null);
/*     */         else {
/* 201 */           pstmt.setString(16, get(i).getMobile());
/*     */         }
/* 203 */         if ((get(i).getOccupationCode() == null) || (get(i).getOccupationCode().equals("null")))
/* 204 */           pstmt.setString(17, null);
/*     */         else {
/* 206 */           pstmt.setString(17, get(i).getOccupationCode());
/*     */         }
/* 208 */         if ((get(i).getPosition() == null) || (get(i).getPosition().equals("null")))
/* 209 */           pstmt.setString(18, null);
/*     */         else {
/* 211 */           pstmt.setString(18, get(i).getPosition());
/*     */         }
/* 213 */         if ((get(i).getWorkType() == null) || (get(i).getWorkType().equals("null")))
/* 214 */           pstmt.setString(19, null);
/*     */         else {
/* 216 */           pstmt.setString(19, get(i).getWorkType());
/*     */         }
/* 218 */         if ((get(i).getOccupationType() == null) || (get(i).getOccupationType().equals("null")))
/* 219 */           pstmt.setString(20, null);
/*     */         else {
/* 221 */           pstmt.setString(20, get(i).getOccupationType());
/*     */         }
/* 223 */         if ((get(i).getHomeAddress() == null) || (get(i).getHomeAddress().equals("null")))
/* 224 */           pstmt.setString(21, null);
/*     */         else {
/* 226 */           pstmt.setString(21, get(i).getHomeAddress());
/*     */         }
/* 228 */         if ((get(i).getHomeAddressCode() == null) || (get(i).getHomeAddressCode().equals("null")))
/* 229 */           pstmt.setString(22, null);
/*     */         else {
/* 231 */           pstmt.setString(22, get(i).getHomeAddressCode());
/*     */         }
/* 233 */         if ((get(i).getRgtAddress() == null) || (get(i).getRgtAddress().equals("null")))
/* 234 */           pstmt.setString(23, null);
/*     */         else {
/* 236 */           pstmt.setString(23, get(i).getRgtAddress());
/*     */         }
/* 238 */         if ((get(i).getPostalAddress() == null) || (get(i).getPostalAddress().equals("null")))
/* 239 */           pstmt.setString(24, null);
/*     */         else {
/* 241 */           pstmt.setString(24, get(i).getPostalAddress());
/*     */         }
/* 243 */         if ((get(i).getZipCode() == null) || (get(i).getZipCode().equals("null")))
/* 244 */           pstmt.setString(25, null);
/*     */         else {
/* 246 */           pstmt.setString(25, get(i).getZipCode());
/*     */         }
/* 248 */         if ((get(i).getHomeZipCode() == null) || (get(i).getHomeZipCode().equals("null")))
/* 249 */           pstmt.setString(26, null);
/*     */         else {
/* 251 */           pstmt.setString(26, get(i).getHomeZipCode());
/*     */         }
/* 253 */         if ((get(i).getSequenceNo() == null) || (get(i).getSequenceNo().equals("null")))
/* 254 */           pstmt.setString(27, null);
/*     */         else {
/* 256 */           pstmt.setString(27, get(i).getSequenceNo());
/*     */         }
/* 258 */         pstmt.setDouble(28, get(i).getStature());
/* 259 */         pstmt.setDouble(29, get(i).getAvoirdupois());
/* 260 */         if ((get(i).getSmokeFlag() == null) || (get(i).getSmokeFlag().equals("null")))
/* 261 */           pstmt.setString(30, null);
/*     */         else {
/* 263 */           pstmt.setString(30, get(i).getSmokeFlag());
/*     */         }
/* 265 */         if ((get(i).getMarriage() == null) || (get(i).getMarriage().equals("null")))
/* 266 */           pstmt.setString(32, null);
/*     */         else {
/* 268 */           pstmt.setString(32, get(i).getMarriage());
/*     */         }
/* 270 */         if ((get(i).getCredentType() == null) || (get(i).getCredentType().equals("null")))
/* 271 */           pstmt.setString(33, null);
/*     */         else {
/* 273 */           pstmt.setString(33, get(i).getCredentType());
/*     */         }
/* 275 */         if ((get(i).getCredentNO() == null) || (get(i).getCredentNO().equals("null")))
/* 276 */           pstmt.setString(34, null);
/*     */         else {
/* 278 */           pstmt.setString(34, get(i).getCredentNO());
/*     */         }
/* 280 */         if ((get(i).getOthIDNo() == null) || (get(i).getOthIDNo().equals("null")))
/* 281 */           pstmt.setString(35, null);
/*     */         else {
/* 283 */           pstmt.setString(35, get(i).getOthIDNo());
/*     */         }
/* 285 */         if ((get(i).getOthIDType() == null) || (get(i).getOthIDType().equals("null")))
/* 286 */           pstmt.setString(36, null);
/*     */         else {
/* 288 */           pstmt.setString(36, get(i).getOthIDType());
/*     */         }
/* 290 */         if ((get(i).getICNo() == null) || (get(i).getICNo().equals("null")))
/* 291 */           pstmt.setString(37, null);
/*     */         else {
/* 293 */           pstmt.setString(37, get(i).getICNo());
/*     */         }
/* 295 */         if ((get(i).getNativePlace() == null) || (get(i).getNativePlace().equals("null")))
/* 296 */           pstmt.setString(40, null);
/*     */         else {
/* 298 */           pstmt.setString(40, get(i).getNativePlace());
/*     */         }
/* 300 */         if ((get(i).getNationality() == null) || (get(i).getNationality().equals("null")))
/* 301 */           pstmt.setString(41, null);
/*     */         else {
/* 303 */           pstmt.setString(41, get(i).getNationality());
/*     */         }
/* 305 */         if ((get(i).getDegree() == null) || (get(i).getDegree().equals("null")))
/* 306 */           pstmt.setString(43, null);
/*     */         else {
/* 308 */           pstmt.setString(43, get(i).getDegree());
/*     */         }
/* 310 */         if ((get(i).getPolNo() == null) || (get(i).getPolNo().equals("null")))
/* 311 */           pstmt.setString(44, null);
/*     */         else {
/* 313 */           pstmt.setString(44, get(i).getPolNo());
/*     */         }
/* 315 */         if ((get(i).getRelationToInsured() == null) || (get(i).getRelationToInsured().equals("null")))
/* 316 */           pstmt.setString(45, null);
/*     */         else {
/* 318 */           pstmt.setString(45, get(i).getRelationToInsured());
/*     */         }
/* 320 */         if ((get(i).getPluralityType() == null) || (get(i).getPluralityType().equals("null")))
/* 321 */           pstmt.setString(46, null);
/*     */         else {
/* 323 */           pstmt.setString(46, get(i).getPluralityType());
/*     */         }
/* 325 */         if ((get(i).getHealth() == null) || (get(i).getHealth().equals("null")))
/* 326 */           pstmt.setString(48, null);
/*     */         else {
/* 328 */           pstmt.setString(48, get(i).getHealth());
/*     */         }
/* 330 */         if ((get(i).getPassword() == null) || (get(i).getPassword().equals("null")))
/* 331 */           pstmt.setString(49, null);
/*     */         else {
/* 333 */           pstmt.setString(49, get(i).getPassword());
/*     */         }
/* 335 */         if ((get(i).getAppntGrade() == null) || (get(i).getAppntGrade().equals("null")))
/* 336 */           pstmt.setString(51, null);
/*     */         else {
/* 338 */           pstmt.setString(51, get(i).getAppntGrade());
/*     */         }
/* 340 */         if ((get(i).getCreditGrade() == null) || (get(i).getCreditGrade().equals("null")))
/* 341 */           pstmt.setString(52, null);
/*     */         else {
/* 343 */           pstmt.setString(52, get(i).getCreditGrade());
/*     */         }
/* 345 */         if ((get(i).getClientType() == null) || (get(i).getClientType().equals("null")))
/* 346 */           pstmt.setString(53, null);
/*     */         else {
/* 348 */           pstmt.setString(53, get(i).getClientType());
/*     */         }
/* 350 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 351 */           pstmt.setString(54, null);
/*     */         else {
/* 353 */           pstmt.setString(54, get(i).getState());
/*     */         }
/* 355 */         if ((get(i).getAgentcode() == null) || (get(i).getAgentcode().equals("null")))
/* 356 */           pstmt.setString(55, null);
/*     */         else {
/* 358 */           pstmt.setString(55, get(i).getAgentcode());
/*     */         }
/* 360 */         if ((get(i).getAddrChoise() == null) || (get(i).getAddrChoise().equals("null")))
/* 361 */           pstmt.setString(57, null);
/*     */         else {
/* 363 */           pstmt.setString(57, get(i).getAddrChoise());
/*     */         }
/* 365 */         if ((get(i).getCustomeProperty() == null) || (get(i).getCustomeProperty().equals("null")))
/* 366 */           pstmt.setString(58, null);
/*     */         else {
/* 368 */           pstmt.setString(58, get(i).getCustomeProperty());
/*     */         }
/* 370 */         if ((get(i).getBirthdayFlag() == null) || (get(i).getBirthdayFlag().equals("null")))
/* 371 */           pstmt.setString(59, null);
/*     */         else {
/* 373 */           pstmt.setString(59, get(i).getBirthdayFlag());
/*     */         }
/* 375 */         if ((get(i).getAppellation() == null) || (get(i).getAppellation().equals("null")))
/* 376 */           pstmt.setString(60, null);
/*     */         else {
/* 378 */           pstmt.setString(60, get(i).getAppellation());
/*     */         }
/* 380 */         if ((get(i).getIDDNo() == null) || (get(i).getIDDNo().equals("null")))
/* 381 */           pstmt.setString(61, null);
/*     */         else {
/* 383 */           pstmt.setString(61, get(i).getIDDNo());
/*     */         }
/* 385 */         if ((get(i).getCountryOrArea() == null) || (get(i).getCountryOrArea().equals("null")))
/* 386 */           pstmt.setString(63, null);
/*     */         else {
/* 388 */           pstmt.setString(63, get(i).getCountryOrArea());
/*     */         }
/* 390 */         if ((get(i).getDeleteFlag() == null) || (get(i).getDeleteFlag().equals("null")))
/* 391 */           pstmt.setString(65, null);
/*     */         else {
/* 393 */           pstmt.setString(65, get(i).getDeleteFlag());
/*     */         }
/* 395 */         if ((get(i).getInterest() == null) || (get(i).getInterest().equals("null")))
/* 396 */           pstmt.setString(66, null);
/*     */         else {
/* 398 */           pstmt.setString(66, get(i).getInterest());
/*     */         }
/* 400 */         if ((get(i).getCustomeType() == null) || (get(i).getCustomeType().equals("null")))
/* 401 */           pstmt.setString(67, null);
/*     */         else {
/* 403 */           pstmt.setString(67, get(i).getCustomeType());
/*     */         }
/* 405 */         if ((get(i).getIntroducer() == null) || (get(i).getIntroducer().equals("null")))
/* 406 */           pstmt.setString(68, null);
/*     */         else {
/* 408 */           pstmt.setString(68, get(i).getIntroducer());
/*     */         }
/* 410 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 411 */           pstmt.setString(69, null);
/*     */         else {
/* 413 */           pstmt.setString(69, get(i).getOperator());
/*     */         }
/* 415 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 416 */           pstmt.setString(71, null);
/*     */         else {
/* 418 */           pstmt.setString(71, get(i).getMakeTime());
/*     */         }
/* 420 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 421 */           pstmt.setString(73, null);
/*     */         else {
/* 423 */           pstmt.setString(73, get(i).getModifyTime());
/*     */         }
/*     */ 
/* 426 */         if ((get(i).getCustomerNo() == null) || (get(i).getCustomerNo().equals("null")))
/* 427 */           pstmt.setString(74, null);
/*     */         else {
/* 429 */           pstmt.setString(74, get(i).getCustomerNo());
/*     */         }
/* 431 */         pstmt.addBatch();
/*     */       }
/* 433 */       pstmt.executeBatch();
/* 434 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 437 */       ex.printStackTrace();
/* 438 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 439 */       CError tError = new CError();
/* 440 */       tError.moduleName = "MNewClientDBSet";
/* 441 */       tError.functionName = "update()";
/* 442 */       tError.errorMessage = ex.toString();
/* 443 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 446 */         pstmt.close(); } catch (Exception e) {
/* 447 */         e.printStackTrace();
/*     */       }
/* 449 */       if (!this.mflag) {
/*     */         try {
/* 451 */           this.con.close(); } catch (Exception e) {
/* 452 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 455 */       return false;
/*     */     }
/*     */ 
/* 458 */     if (!this.mflag) {
/*     */       try {
/* 460 */         this.con.close(); } catch (Exception e) {
/* 461 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 464 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 470 */     PreparedStatement pstmt = null;
/*     */ 
/* 472 */     if (!this.mflag) {
/* 473 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 478 */       int tCount = size();
/* 479 */       pstmt = this.con.prepareStatement("INSERT INTO MNewClient VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 480 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 482 */         if ((get(i).getCustomerNo() == null) || (get(i).getCustomerNo().equals("null")))
/* 483 */           pstmt.setString(1, null);
/*     */         else {
/* 485 */           pstmt.setString(1, get(i).getCustomerNo());
/*     */         }
/* 487 */         if ((get(i).getCustomerNo2() == null) || (get(i).getCustomerNo2().equals("null")))
/* 488 */           pstmt.setString(2, null);
/*     */         else {
/* 490 */           pstmt.setString(2, get(i).getCustomerNo2());
/*     */         }
/* 492 */         if ((get(i).getClientName() == null) || (get(i).getClientName().equals("null")))
/* 493 */           pstmt.setString(3, null);
/*     */         else {
/* 495 */           pstmt.setString(3, get(i).getClientName());
/*     */         }
/* 497 */         if ((get(i).getGender() == null) || (get(i).getGender().equals("null")))
/* 498 */           pstmt.setString(4, null);
/*     */         else {
/* 500 */           pstmt.setString(4, get(i).getGender());
/*     */         }
/* 502 */         if ((get(i).getEMail() == null) || (get(i).getEMail().equals("null")))
/* 503 */           pstmt.setString(6, null);
/*     */         else {
/* 505 */           pstmt.setString(6, get(i).getEMail());
/*     */         }
/* 507 */         if ((get(i).getGrpZipCode() == null) || (get(i).getGrpZipCode().equals("null")))
/* 508 */           pstmt.setString(7, null);
/*     */         else {
/* 510 */           pstmt.setString(7, get(i).getGrpZipCode());
/*     */         }
/* 512 */         if ((get(i).getGrpAddress() == null) || (get(i).getGrpAddress().equals("null")))
/* 513 */           pstmt.setString(8, null);
/*     */         else {
/* 515 */           pstmt.setString(8, get(i).getGrpAddress());
/*     */         }
/* 517 */         if ((get(i).getGrpNo() == null) || (get(i).getGrpNo().equals("null")))
/* 518 */           pstmt.setString(9, null);
/*     */         else {
/* 520 */           pstmt.setString(9, get(i).getGrpNo());
/*     */         }
/* 522 */         if ((get(i).getBP() == null) || (get(i).getBP().equals("null")))
/* 523 */           pstmt.setString(10, null);
/*     */         else {
/* 525 */           pstmt.setString(10, get(i).getBP());
/*     */         }
/* 527 */         if ((get(i).getGrpAddressCode() == null) || (get(i).getGrpAddressCode().equals("null")))
/* 528 */           pstmt.setString(11, null);
/*     */         else {
/* 530 */           pstmt.setString(11, get(i).getGrpAddressCode());
/*     */         }
/* 532 */         if ((get(i).getPhone2() == null) || (get(i).getPhone2().equals("null")))
/* 533 */           pstmt.setString(12, null);
/*     */         else {
/* 535 */           pstmt.setString(12, get(i).getPhone2());
/*     */         }
/* 537 */         if ((get(i).getGrpName() == null) || (get(i).getGrpName().equals("null")))
/* 538 */           pstmt.setString(13, null);
/*     */         else {
/* 540 */           pstmt.setString(13, get(i).getGrpName());
/*     */         }
/* 542 */         if ((get(i).getGrpPhone() == null) || (get(i).getGrpPhone().equals("null")))
/* 543 */           pstmt.setString(14, null);
/*     */         else {
/* 545 */           pstmt.setString(14, get(i).getGrpPhone());
/*     */         }
/* 547 */         if ((get(i).getPhone() == null) || (get(i).getPhone().equals("null")))
/* 548 */           pstmt.setString(15, null);
/*     */         else {
/* 550 */           pstmt.setString(15, get(i).getPhone());
/*     */         }
/* 552 */         if ((get(i).getMobile() == null) || (get(i).getMobile().equals("null")))
/* 553 */           pstmt.setString(16, null);
/*     */         else {
/* 555 */           pstmt.setString(16, get(i).getMobile());
/*     */         }
/* 557 */         if ((get(i).getOccupationCode() == null) || (get(i).getOccupationCode().equals("null")))
/* 558 */           pstmt.setString(17, null);
/*     */         else {
/* 560 */           pstmt.setString(17, get(i).getOccupationCode());
/*     */         }
/* 562 */         if ((get(i).getPosition() == null) || (get(i).getPosition().equals("null")))
/* 563 */           pstmt.setString(18, null);
/*     */         else {
/* 565 */           pstmt.setString(18, get(i).getPosition());
/*     */         }
/* 567 */         if ((get(i).getWorkType() == null) || (get(i).getWorkType().equals("null")))
/* 568 */           pstmt.setString(19, null);
/*     */         else {
/* 570 */           pstmt.setString(19, get(i).getWorkType());
/*     */         }
/* 572 */         if ((get(i).getOccupationType() == null) || (get(i).getOccupationType().equals("null")))
/* 573 */           pstmt.setString(20, null);
/*     */         else {
/* 575 */           pstmt.setString(20, get(i).getOccupationType());
/*     */         }
/* 577 */         if ((get(i).getHomeAddress() == null) || (get(i).getHomeAddress().equals("null")))
/* 578 */           pstmt.setString(21, null);
/*     */         else {
/* 580 */           pstmt.setString(21, get(i).getHomeAddress());
/*     */         }
/* 582 */         if ((get(i).getHomeAddressCode() == null) || (get(i).getHomeAddressCode().equals("null")))
/* 583 */           pstmt.setString(22, null);
/*     */         else {
/* 585 */           pstmt.setString(22, get(i).getHomeAddressCode());
/*     */         }
/* 587 */         if ((get(i).getRgtAddress() == null) || (get(i).getRgtAddress().equals("null")))
/* 588 */           pstmt.setString(23, null);
/*     */         else {
/* 590 */           pstmt.setString(23, get(i).getRgtAddress());
/*     */         }
/* 592 */         if ((get(i).getPostalAddress() == null) || (get(i).getPostalAddress().equals("null")))
/* 593 */           pstmt.setString(24, null);
/*     */         else {
/* 595 */           pstmt.setString(24, get(i).getPostalAddress());
/*     */         }
/* 597 */         if ((get(i).getZipCode() == null) || (get(i).getZipCode().equals("null")))
/* 598 */           pstmt.setString(25, null);
/*     */         else {
/* 600 */           pstmt.setString(25, get(i).getZipCode());
/*     */         }
/* 602 */         if ((get(i).getHomeZipCode() == null) || (get(i).getHomeZipCode().equals("null")))
/* 603 */           pstmt.setString(26, null);
/*     */         else {
/* 605 */           pstmt.setString(26, get(i).getHomeZipCode());
/*     */         }
/* 607 */         if ((get(i).getSequenceNo() == null) || (get(i).getSequenceNo().equals("null")))
/* 608 */           pstmt.setString(27, null);
/*     */         else {
/* 610 */           pstmt.setString(27, get(i).getSequenceNo());
/*     */         }
/* 612 */         pstmt.setDouble(28, get(i).getStature());
/* 613 */         pstmt.setDouble(29, get(i).getAvoirdupois());
/* 614 */         if ((get(i).getSmokeFlag() == null) || (get(i).getSmokeFlag().equals("null")))
/* 615 */           pstmt.setString(30, null);
/*     */         else {
/* 617 */           pstmt.setString(30, get(i).getSmokeFlag());
/*     */         }
/* 619 */         if ((get(i).getMarriage() == null) || (get(i).getMarriage().equals("null")))
/* 620 */           pstmt.setString(32, null);
/*     */         else {
/* 622 */           pstmt.setString(32, get(i).getMarriage());
/*     */         }
/* 624 */         if ((get(i).getCredentType() == null) || (get(i).getCredentType().equals("null")))
/* 625 */           pstmt.setString(33, null);
/*     */         else {
/* 627 */           pstmt.setString(33, get(i).getCredentType());
/*     */         }
/* 629 */         if ((get(i).getCredentNO() == null) || (get(i).getCredentNO().equals("null")))
/* 630 */           pstmt.setString(34, null);
/*     */         else {
/* 632 */           pstmt.setString(34, get(i).getCredentNO());
/*     */         }
/* 634 */         if ((get(i).getOthIDNo() == null) || (get(i).getOthIDNo().equals("null")))
/* 635 */           pstmt.setString(35, null);
/*     */         else {
/* 637 */           pstmt.setString(35, get(i).getOthIDNo());
/*     */         }
/* 639 */         if ((get(i).getOthIDType() == null) || (get(i).getOthIDType().equals("null")))
/* 640 */           pstmt.setString(36, null);
/*     */         else {
/* 642 */           pstmt.setString(36, get(i).getOthIDType());
/*     */         }
/* 644 */         if ((get(i).getICNo() == null) || (get(i).getICNo().equals("null")))
/* 645 */           pstmt.setString(37, null);
/*     */         else {
/* 647 */           pstmt.setString(37, get(i).getICNo());
/*     */         }
/* 649 */         if ((get(i).getNativePlace() == null) || (get(i).getNativePlace().equals("null")))
/* 650 */           pstmt.setString(40, null);
/*     */         else {
/* 652 */           pstmt.setString(40, get(i).getNativePlace());
/*     */         }
/* 654 */         if ((get(i).getNationality() == null) || (get(i).getNationality().equals("null")))
/* 655 */           pstmt.setString(41, null);
/*     */         else {
/* 657 */           pstmt.setString(41, get(i).getNationality());
/*     */         }
/* 659 */         if ((get(i).getDegree() == null) || (get(i).getDegree().equals("null")))
/* 660 */           pstmt.setString(43, null);
/*     */         else {
/* 662 */           pstmt.setString(43, get(i).getDegree());
/*     */         }
/* 664 */         if ((get(i).getPolNo() == null) || (get(i).getPolNo().equals("null")))
/* 665 */           pstmt.setString(44, null);
/*     */         else {
/* 667 */           pstmt.setString(44, get(i).getPolNo());
/*     */         }
/* 669 */         if ((get(i).getRelationToInsured() == null) || (get(i).getRelationToInsured().equals("null")))
/* 670 */           pstmt.setString(45, null);
/*     */         else {
/* 672 */           pstmt.setString(45, get(i).getRelationToInsured());
/*     */         }
/* 674 */         if ((get(i).getPluralityType() == null) || (get(i).getPluralityType().equals("null")))
/* 675 */           pstmt.setString(46, null);
/*     */         else {
/* 677 */           pstmt.setString(46, get(i).getPluralityType());
/*     */         }
/* 679 */         if ((get(i).getHealth() == null) || (get(i).getHealth().equals("null")))
/* 680 */           pstmt.setString(48, null);
/*     */         else {
/* 682 */           pstmt.setString(48, get(i).getHealth());
/*     */         }
/* 684 */         if ((get(i).getPassword() == null) || (get(i).getPassword().equals("null")))
/* 685 */           pstmt.setString(49, null);
/*     */         else {
/* 687 */           pstmt.setString(49, get(i).getPassword());
/*     */         }
/* 689 */         if ((get(i).getAppntGrade() == null) || (get(i).getAppntGrade().equals("null")))
/* 690 */           pstmt.setString(51, null);
/*     */         else {
/* 692 */           pstmt.setString(51, get(i).getAppntGrade());
/*     */         }
/* 694 */         if ((get(i).getCreditGrade() == null) || (get(i).getCreditGrade().equals("null")))
/* 695 */           pstmt.setString(52, null);
/*     */         else {
/* 697 */           pstmt.setString(52, get(i).getCreditGrade());
/*     */         }
/* 699 */         if ((get(i).getClientType() == null) || (get(i).getClientType().equals("null")))
/* 700 */           pstmt.setString(53, null);
/*     */         else {
/* 702 */           pstmt.setString(53, get(i).getClientType());
/*     */         }
/* 704 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 705 */           pstmt.setString(54, null);
/*     */         else {
/* 707 */           pstmt.setString(54, get(i).getState());
/*     */         }
/* 709 */         if ((get(i).getAgentcode() == null) || (get(i).getAgentcode().equals("null")))
/* 710 */           pstmt.setString(55, null);
/*     */         else {
/* 712 */           pstmt.setString(55, get(i).getAgentcode());
/*     */         }
/* 714 */         if ((get(i).getAddrChoise() == null) || (get(i).getAddrChoise().equals("null")))
/* 715 */           pstmt.setString(57, null);
/*     */         else {
/* 717 */           pstmt.setString(57, get(i).getAddrChoise());
/*     */         }
/* 719 */         if ((get(i).getCustomeProperty() == null) || (get(i).getCustomeProperty().equals("null")))
/* 720 */           pstmt.setString(58, null);
/*     */         else {
/* 722 */           pstmt.setString(58, get(i).getCustomeProperty());
/*     */         }
/* 724 */         if ((get(i).getBirthdayFlag() == null) || (get(i).getBirthdayFlag().equals("null")))
/* 725 */           pstmt.setString(59, null);
/*     */         else {
/* 727 */           pstmt.setString(59, get(i).getBirthdayFlag());
/*     */         }
/* 729 */         if ((get(i).getAppellation() == null) || (get(i).getAppellation().equals("null")))
/* 730 */           pstmt.setString(60, null);
/*     */         else {
/* 732 */           pstmt.setString(60, get(i).getAppellation());
/*     */         }
/* 734 */         if ((get(i).getIDDNo() == null) || (get(i).getIDDNo().equals("null")))
/* 735 */           pstmt.setString(61, null);
/*     */         else {
/* 737 */           pstmt.setString(61, get(i).getIDDNo());
/*     */         }
/* 739 */         if ((get(i).getCountryOrArea() == null) || (get(i).getCountryOrArea().equals("null")))
/* 740 */           pstmt.setString(63, null);
/*     */         else {
/* 742 */           pstmt.setString(63, get(i).getCountryOrArea());
/*     */         }
/* 744 */         if ((get(i).getDeleteFlag() == null) || (get(i).getDeleteFlag().equals("null")))
/* 745 */           pstmt.setString(65, null);
/*     */         else {
/* 747 */           pstmt.setString(65, get(i).getDeleteFlag());
/*     */         }
/* 749 */         if ((get(i).getInterest() == null) || (get(i).getInterest().equals("null")))
/* 750 */           pstmt.setString(66, null);
/*     */         else {
/* 752 */           pstmt.setString(66, get(i).getInterest());
/*     */         }
/* 754 */         if ((get(i).getCustomeType() == null) || (get(i).getCustomeType().equals("null")))
/* 755 */           pstmt.setString(67, null);
/*     */         else {
/* 757 */           pstmt.setString(67, get(i).getCustomeType());
/*     */         }
/* 759 */         if ((get(i).getIntroducer() == null) || (get(i).getIntroducer().equals("null")))
/* 760 */           pstmt.setString(68, null);
/*     */         else {
/* 762 */           pstmt.setString(68, get(i).getIntroducer());
/*     */         }
/* 764 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 765 */           pstmt.setString(69, null);
/*     */         else {
/* 767 */           pstmt.setString(69, get(i).getOperator());
/*     */         }
/* 769 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 770 */           pstmt.setString(71, null);
/*     */         else {
/* 772 */           pstmt.setString(71, get(i).getMakeTime());
/*     */         }
/* 774 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 775 */           pstmt.setString(73, null);
/*     */         else {
/* 777 */           pstmt.setString(73, get(i).getModifyTime());
/*     */         }
/* 779 */         pstmt.addBatch();
/*     */       }
/* 781 */       pstmt.executeBatch();
/* 782 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 785 */       ex.printStackTrace();
/* 786 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 787 */       CError tError = new CError();
/* 788 */       tError.moduleName = "MNewClientDBSet";
/* 789 */       tError.functionName = "insert()";
/* 790 */       tError.errorMessage = ex.toString();
/* 791 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 794 */         pstmt.close(); } catch (Exception e) {
/* 795 */         e.printStackTrace();
/*     */       }
/* 797 */       if (!this.mflag) {
/*     */         try {
/* 799 */           this.con.close(); } catch (Exception e) {
/* 800 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 803 */       return false;
/*     */     }
/*     */ 
/* 806 */     if (!this.mflag) {
/*     */       try {
/* 808 */         this.con.close(); } catch (Exception e) {
/* 809 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 812 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MNewClientDBSet
 * JD-Core Version:    0.6.0
 */