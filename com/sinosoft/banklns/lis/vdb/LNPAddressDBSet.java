/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPAddressSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPAddressSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPAddressDBSet extends LNPAddressSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPAddressDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPAddress");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPAddressDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPAddress");
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
/*  50 */     tError.moduleName = "LNPAddressDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPAddress WHERE  CustomerId = ? AND AddressNo = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getCustomerId() == null) || (get(i).getCustomerId().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getCustomerId());
/*     */         }
/*  78 */         if ((get(i).getAddressNo() == null) || (get(i).getAddressNo().equals("null")))
/*  79 */           pstmt.setString(2, null);
/*     */         else {
/*  81 */           pstmt.setString(2, get(i).getAddressNo());
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
/*  92 */       tError.moduleName = "LNPAddressDBSet";
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
/* 131 */       pstmt = this.con.prepareStatement("UPDATE LNPAddress SET  CustomerId = ? , CustomerNo = ? , AddressNo = ? , PostalAddress = ? , ZipCode = ? , Phone = ? , Fax = ? , duchy = ? , HomeAddress = ? , HomeZipCode = ? , HomePhone = ? , HomeFax = ? , CompanyAddress = ? , CompanyZipCode = ? , CompanyPhone = ? , CompanyFax = ? , CompanyMail = ? , Mobile = ? , MobileChs = ? , EMail = ? , BP = ? , Mobile2 = ? , MobileChs2 = ? , EMail2 = ? , BP2 = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , GrpName = ? , OtherDuchy = ? WHERE  CustomerId = ? AND AddressNo = ?");
/* 132 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 134 */         if ((get(i).getCustomerId() == null) || (get(i).getCustomerId().equals("null")))
/* 135 */           pstmt.setString(1, null);
/*     */         else {
/* 137 */           pstmt.setString(1, get(i).getCustomerId());
/*     */         }
/* 139 */         if ((get(i).getCustomerNo() == null) || (get(i).getCustomerNo().equals("null")))
/* 140 */           pstmt.setString(2, null);
/*     */         else {
/* 142 */           pstmt.setString(2, get(i).getCustomerNo());
/*     */         }
/* 144 */         if ((get(i).getAddressNo() == null) || (get(i).getAddressNo().equals("null")))
/* 145 */           pstmt.setString(3, null);
/*     */         else {
/* 147 */           pstmt.setString(3, get(i).getAddressNo());
/*     */         }
/* 149 */         if ((get(i).getPostalAddress() == null) || (get(i).getPostalAddress().equals("null")))
/* 150 */           pstmt.setString(4, null);
/*     */         else {
/* 152 */           pstmt.setString(4, get(i).getPostalAddress());
/*     */         }
/* 154 */         if ((get(i).getZipCode() == null) || (get(i).getZipCode().equals("null")))
/* 155 */           pstmt.setString(5, null);
/*     */         else {
/* 157 */           pstmt.setString(5, get(i).getZipCode());
/*     */         }
/* 159 */         if ((get(i).getPhone() == null) || (get(i).getPhone().equals("null")))
/* 160 */           pstmt.setString(6, null);
/*     */         else {
/* 162 */           pstmt.setString(6, get(i).getPhone());
/*     */         }
/* 164 */         if ((get(i).getFax() == null) || (get(i).getFax().equals("null")))
/* 165 */           pstmt.setString(7, null);
/*     */         else {
/* 167 */           pstmt.setString(7, get(i).getFax());
/*     */         }
/* 169 */         if ((get(i).getDuchy() == null) || (get(i).getDuchy().equals("null")))
/* 170 */           pstmt.setString(8, null);
/*     */         else {
/* 172 */           pstmt.setString(8, get(i).getDuchy());
/*     */         }
/* 174 */         if ((get(i).getHomeAddress() == null) || (get(i).getHomeAddress().equals("null")))
/* 175 */           pstmt.setString(9, null);
/*     */         else {
/* 177 */           pstmt.setString(9, get(i).getHomeAddress());
/*     */         }
/* 179 */         if ((get(i).getHomeZipCode() == null) || (get(i).getHomeZipCode().equals("null")))
/* 180 */           pstmt.setString(10, null);
/*     */         else {
/* 182 */           pstmt.setString(10, get(i).getHomeZipCode());
/*     */         }
/* 184 */         if ((get(i).getHomePhone() == null) || (get(i).getHomePhone().equals("null")))
/* 185 */           pstmt.setString(11, null);
/*     */         else {
/* 187 */           pstmt.setString(11, get(i).getHomePhone());
/*     */         }
/* 189 */         if ((get(i).getHomeFax() == null) || (get(i).getHomeFax().equals("null")))
/* 190 */           pstmt.setString(12, null);
/*     */         else {
/* 192 */           pstmt.setString(12, get(i).getHomeFax());
/*     */         }
/* 194 */         if ((get(i).getCompanyAddress() == null) || (get(i).getCompanyAddress().equals("null")))
/* 195 */           pstmt.setString(13, null);
/*     */         else {
/* 197 */           pstmt.setString(13, get(i).getCompanyAddress());
/*     */         }
/* 199 */         if ((get(i).getCompanyZipCode() == null) || (get(i).getCompanyZipCode().equals("null")))
/* 200 */           pstmt.setString(14, null);
/*     */         else {
/* 202 */           pstmt.setString(14, get(i).getCompanyZipCode());
/*     */         }
/* 204 */         if ((get(i).getCompanyPhone() == null) || (get(i).getCompanyPhone().equals("null")))
/* 205 */           pstmt.setString(15, null);
/*     */         else {
/* 207 */           pstmt.setString(15, get(i).getCompanyPhone());
/*     */         }
/* 209 */         if ((get(i).getCompanyFax() == null) || (get(i).getCompanyFax().equals("null")))
/* 210 */           pstmt.setString(16, null);
/*     */         else {
/* 212 */           pstmt.setString(16, get(i).getCompanyFax());
/*     */         }
/* 214 */         if ((get(i).getCompanyMail() == null) || (get(i).getCompanyMail().equals("null")))
/* 215 */           pstmt.setString(17, null);
/*     */         else {
/* 217 */           pstmt.setString(17, get(i).getCompanyMail());
/*     */         }
/* 219 */         if ((get(i).getMobile() == null) || (get(i).getMobile().equals("null")))
/* 220 */           pstmt.setString(18, null);
/*     */         else {
/* 222 */           pstmt.setString(18, get(i).getMobile());
/*     */         }
/* 224 */         if ((get(i).getMobileChs() == null) || (get(i).getMobileChs().equals("null")))
/* 225 */           pstmt.setString(19, null);
/*     */         else {
/* 227 */           pstmt.setString(19, get(i).getMobileChs());
/*     */         }
/* 229 */         if ((get(i).getEMail() == null) || (get(i).getEMail().equals("null")))
/* 230 */           pstmt.setString(20, null);
/*     */         else {
/* 232 */           pstmt.setString(20, get(i).getEMail());
/*     */         }
/* 234 */         if ((get(i).getBP() == null) || (get(i).getBP().equals("null")))
/* 235 */           pstmt.setString(21, null);
/*     */         else {
/* 237 */           pstmt.setString(21, get(i).getBP());
/*     */         }
/* 239 */         if ((get(i).getMobile2() == null) || (get(i).getMobile2().equals("null")))
/* 240 */           pstmt.setString(22, null);
/*     */         else {
/* 242 */           pstmt.setString(22, get(i).getMobile2());
/*     */         }
/* 244 */         if ((get(i).getMobileChs2() == null) || (get(i).getMobileChs2().equals("null")))
/* 245 */           pstmt.setString(23, null);
/*     */         else {
/* 247 */           pstmt.setString(23, get(i).getMobileChs2());
/*     */         }
/* 249 */         if ((get(i).getEMail2() == null) || (get(i).getEMail2().equals("null")))
/* 250 */           pstmt.setString(24, null);
/*     */         else {
/* 252 */           pstmt.setString(24, get(i).getEMail2());
/*     */         }
/* 254 */         if ((get(i).getBP2() == null) || (get(i).getBP2().equals("null")))
/* 255 */           pstmt.setString(25, null);
/*     */         else {
/* 257 */           pstmt.setString(25, get(i).getBP2());
/*     */         }
/* 259 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 260 */           pstmt.setString(26, null);
/*     */         else {
/* 262 */           pstmt.setString(26, get(i).getOperator());
/*     */         }
/* 264 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 265 */           pstmt.setDate(27, null);
/*     */         else {
/* 267 */           pstmt.setDate(27, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 269 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 270 */           pstmt.setString(28, null);
/*     */         else {
/* 272 */           pstmt.setString(28, get(i).getMakeTime());
/*     */         }
/* 274 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 275 */           pstmt.setDate(29, null);
/*     */         else {
/* 277 */           pstmt.setDate(29, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 279 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 280 */           pstmt.setString(30, null);
/*     */         else {
/* 282 */           pstmt.setString(30, get(i).getModifyTime());
/*     */         }
/* 284 */         if ((get(i).getGrpName() == null) || (get(i).getGrpName().equals("null")))
/* 285 */           pstmt.setString(31, null);
/*     */         else {
/* 287 */           pstmt.setString(31, get(i).getGrpName());
/*     */         }
/* 289 */         if ((get(i).getOtherDuchy() == null) || (get(i).getOtherDuchy().equals("null")))
/* 290 */           pstmt.setString(32, null);
/*     */         else {
/* 292 */           pstmt.setString(32, get(i).getOtherDuchy());
/*     */         }
/*     */ 
/* 295 */         if ((get(i).getCustomerId() == null) || (get(i).getCustomerId().equals("null")))
/* 296 */           pstmt.setString(33, null);
/*     */         else {
/* 298 */           pstmt.setString(33, get(i).getCustomerId());
/*     */         }
/* 300 */         if ((get(i).getAddressNo() == null) || (get(i).getAddressNo().equals("null")))
/* 301 */           pstmt.setString(34, null);
/*     */         else {
/* 303 */           pstmt.setString(34, get(i).getAddressNo());
/*     */         }
/* 305 */         pstmt.addBatch();
/*     */       }
/* 307 */       pstmt.executeBatch();
/* 308 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 311 */       ex.printStackTrace();
/* 312 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 313 */       CError tError = new CError();
/* 314 */       tError.moduleName = "LNPAddressDBSet";
/* 315 */       tError.functionName = "update()";
/* 316 */       tError.errorMessage = ex.toString();
/* 317 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 320 */         pstmt.close(); } catch (Exception e) {
/* 321 */         e.printStackTrace();
/*     */       }
/* 323 */       if (!this.mflag) {
/*     */         try {
/* 325 */           this.con.close(); } catch (Exception e) {
/* 326 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 329 */       return false;
/*     */     }
/*     */ 
/* 332 */     if (!this.mflag) {
/*     */       try {
/* 334 */         this.con.close(); } catch (Exception e) {
/* 335 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 338 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 344 */     PreparedStatement pstmt = null;
/*     */ 
/* 346 */     if (!this.mflag) {
/* 347 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 352 */       int tCount = size();
/* 353 */       pstmt = this.con.prepareStatement("INSERT INTO LNPAddress VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 354 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 356 */         if ((get(i).getCustomerId() == null) || (get(i).getCustomerId().equals("null")))
/* 357 */           pstmt.setString(1, null);
/*     */         else {
/* 359 */           pstmt.setString(1, get(i).getCustomerId());
/*     */         }
/* 361 */         if ((get(i).getCustomerNo() == null) || (get(i).getCustomerNo().equals("null")))
/* 362 */           pstmt.setString(2, null);
/*     */         else {
/* 364 */           pstmt.setString(2, get(i).getCustomerNo());
/*     */         }
/* 366 */         if ((get(i).getAddressNo() == null) || (get(i).getAddressNo().equals("null")))
/* 367 */           pstmt.setString(3, null);
/*     */         else {
/* 369 */           pstmt.setString(3, get(i).getAddressNo());
/*     */         }
/* 371 */         if ((get(i).getPostalAddress() == null) || (get(i).getPostalAddress().equals("null")))
/* 372 */           pstmt.setString(4, null);
/*     */         else {
/* 374 */           pstmt.setString(4, get(i).getPostalAddress());
/*     */         }
/* 376 */         if ((get(i).getZipCode() == null) || (get(i).getZipCode().equals("null")))
/* 377 */           pstmt.setString(5, null);
/*     */         else {
/* 379 */           pstmt.setString(5, get(i).getZipCode());
/*     */         }
/* 381 */         if ((get(i).getPhone() == null) || (get(i).getPhone().equals("null")))
/* 382 */           pstmt.setString(6, null);
/*     */         else {
/* 384 */           pstmt.setString(6, get(i).getPhone());
/*     */         }
/* 386 */         if ((get(i).getFax() == null) || (get(i).getFax().equals("null")))
/* 387 */           pstmt.setString(7, null);
/*     */         else {
/* 389 */           pstmt.setString(7, get(i).getFax());
/*     */         }
/* 391 */         if ((get(i).getDuchy() == null) || (get(i).getDuchy().equals("null")))
/* 392 */           pstmt.setString(8, null);
/*     */         else {
/* 394 */           pstmt.setString(8, get(i).getDuchy());
/*     */         }
/* 396 */         if ((get(i).getHomeAddress() == null) || (get(i).getHomeAddress().equals("null")))
/* 397 */           pstmt.setString(9, null);
/*     */         else {
/* 399 */           pstmt.setString(9, get(i).getHomeAddress());
/*     */         }
/* 401 */         if ((get(i).getHomeZipCode() == null) || (get(i).getHomeZipCode().equals("null")))
/* 402 */           pstmt.setString(10, null);
/*     */         else {
/* 404 */           pstmt.setString(10, get(i).getHomeZipCode());
/*     */         }
/* 406 */         if ((get(i).getHomePhone() == null) || (get(i).getHomePhone().equals("null")))
/* 407 */           pstmt.setString(11, null);
/*     */         else {
/* 409 */           pstmt.setString(11, get(i).getHomePhone());
/*     */         }
/* 411 */         if ((get(i).getHomeFax() == null) || (get(i).getHomeFax().equals("null")))
/* 412 */           pstmt.setString(12, null);
/*     */         else {
/* 414 */           pstmt.setString(12, get(i).getHomeFax());
/*     */         }
/* 416 */         if ((get(i).getCompanyAddress() == null) || (get(i).getCompanyAddress().equals("null")))
/* 417 */           pstmt.setString(13, null);
/*     */         else {
/* 419 */           pstmt.setString(13, get(i).getCompanyAddress());
/*     */         }
/* 421 */         if ((get(i).getCompanyZipCode() == null) || (get(i).getCompanyZipCode().equals("null")))
/* 422 */           pstmt.setString(14, null);
/*     */         else {
/* 424 */           pstmt.setString(14, get(i).getCompanyZipCode());
/*     */         }
/* 426 */         if ((get(i).getCompanyPhone() == null) || (get(i).getCompanyPhone().equals("null")))
/* 427 */           pstmt.setString(15, null);
/*     */         else {
/* 429 */           pstmt.setString(15, get(i).getCompanyPhone());
/*     */         }
/* 431 */         if ((get(i).getCompanyFax() == null) || (get(i).getCompanyFax().equals("null")))
/* 432 */           pstmt.setString(16, null);
/*     */         else {
/* 434 */           pstmt.setString(16, get(i).getCompanyFax());
/*     */         }
/* 436 */         if ((get(i).getCompanyMail() == null) || (get(i).getCompanyMail().equals("null")))
/* 437 */           pstmt.setString(17, null);
/*     */         else {
/* 439 */           pstmt.setString(17, get(i).getCompanyMail());
/*     */         }
/* 441 */         if ((get(i).getMobile() == null) || (get(i).getMobile().equals("null")))
/* 442 */           pstmt.setString(18, null);
/*     */         else {
/* 444 */           pstmt.setString(18, get(i).getMobile());
/*     */         }
/* 446 */         if ((get(i).getMobileChs() == null) || (get(i).getMobileChs().equals("null")))
/* 447 */           pstmt.setString(19, null);
/*     */         else {
/* 449 */           pstmt.setString(19, get(i).getMobileChs());
/*     */         }
/* 451 */         if ((get(i).getEMail() == null) || (get(i).getEMail().equals("null")))
/* 452 */           pstmt.setString(20, null);
/*     */         else {
/* 454 */           pstmt.setString(20, get(i).getEMail());
/*     */         }
/* 456 */         if ((get(i).getBP() == null) || (get(i).getBP().equals("null")))
/* 457 */           pstmt.setString(21, null);
/*     */         else {
/* 459 */           pstmt.setString(21, get(i).getBP());
/*     */         }
/* 461 */         if ((get(i).getMobile2() == null) || (get(i).getMobile2().equals("null")))
/* 462 */           pstmt.setString(22, null);
/*     */         else {
/* 464 */           pstmt.setString(22, get(i).getMobile2());
/*     */         }
/* 466 */         if ((get(i).getMobileChs2() == null) || (get(i).getMobileChs2().equals("null")))
/* 467 */           pstmt.setString(23, null);
/*     */         else {
/* 469 */           pstmt.setString(23, get(i).getMobileChs2());
/*     */         }
/* 471 */         if ((get(i).getEMail2() == null) || (get(i).getEMail2().equals("null")))
/* 472 */           pstmt.setString(24, null);
/*     */         else {
/* 474 */           pstmt.setString(24, get(i).getEMail2());
/*     */         }
/* 476 */         if ((get(i).getBP2() == null) || (get(i).getBP2().equals("null")))
/* 477 */           pstmt.setString(25, null);
/*     */         else {
/* 479 */           pstmt.setString(25, get(i).getBP2());
/*     */         }
/* 481 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 482 */           pstmt.setString(26, null);
/*     */         else {
/* 484 */           pstmt.setString(26, get(i).getOperator());
/*     */         }
/* 486 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 487 */           pstmt.setDate(27, null);
/*     */         else {
/* 489 */           pstmt.setDate(27, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 491 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 492 */           pstmt.setString(28, null);
/*     */         else {
/* 494 */           pstmt.setString(28, get(i).getMakeTime());
/*     */         }
/* 496 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 497 */           pstmt.setDate(29, null);
/*     */         else {
/* 499 */           pstmt.setDate(29, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 501 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 502 */           pstmt.setString(30, null);
/*     */         else {
/* 504 */           pstmt.setString(30, get(i).getModifyTime());
/*     */         }
/* 506 */         if ((get(i).getGrpName() == null) || (get(i).getGrpName().equals("null")))
/* 507 */           pstmt.setString(31, null);
/*     */         else {
/* 509 */           pstmt.setString(31, get(i).getGrpName());
/*     */         }
/* 511 */         if ((get(i).getOtherDuchy() == null) || (get(i).getOtherDuchy().equals("null")))
/* 512 */           pstmt.setString(32, null);
/*     */         else {
/* 514 */           pstmt.setString(32, get(i).getOtherDuchy());
/*     */         }
/* 516 */         pstmt.addBatch();
/*     */       }
/* 518 */       pstmt.executeBatch();
/* 519 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 522 */       ex.printStackTrace();
/* 523 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 524 */       CError tError = new CError();
/* 525 */       tError.moduleName = "LNPAddressDBSet";
/* 526 */       tError.functionName = "insert()";
/* 527 */       tError.errorMessage = ex.toString();
/* 528 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 531 */         pstmt.close(); } catch (Exception e) {
/* 532 */         e.printStackTrace();
/*     */       }
/* 534 */       if (!this.mflag) {
/*     */         try {
/* 536 */           this.con.close(); } catch (Exception e) {
/* 537 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 540 */       return false;
/*     */     }
/*     */ 
/* 543 */     if (!this.mflag) {
/*     */       try {
/* 545 */         this.con.close(); } catch (Exception e) {
/* 546 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 549 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPAddressDBSet
 * JD-Core Version:    0.6.0
 */