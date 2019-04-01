/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.CRSInfoSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.CRSInfoSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class CRSInfoDBSet extends CRSInfoSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  13 */   private boolean mflag = false;
/*     */ 
/*     */   public CRSInfoDBSet(Connection tConnection) {
/*  16 */     this.con = tConnection;
/*  17 */     this.db = new DBOper(this.con, "CRSInfo");
/*  18 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public CRSInfoDBSet() {
/*  22 */     this.db = new DBOper("CRSInfo");
/*  23 */     this.con = this.db.getConnection();
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL() {
/*  27 */     if (this.db.deleteSQL(this)) {
/*  28 */       return true;
/*     */     }
/*     */ 
/*  31 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*  32 */     CError tError = new CError();
/*  33 */     tError.moduleName = "CRSInfoDBSet";
/*  34 */     tError.functionName = "deleteSQL";
/*  35 */     tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  36 */     this.mErrors.addOneError(tError);
/*  37 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean delete()
/*     */   {
/*  42 */     PreparedStatement pstmt = null;
/*     */ 
/*  44 */     if (!this.mflag) {
/*  45 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */     try
/*     */     {
/*  49 */       int tCount = size();
/*  50 */       pstmt = this.con.prepareStatement("DELETE FROM CRSInfo WHERE  ContNo = ?");
/*  51 */       for (int i = 1; i <= tCount; i++) {
/*  52 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/*  53 */           pstmt.setString(1, null);
/*     */         else {
/*  55 */           pstmt.setString(1, get(i).getContNo());
/*     */         }
/*  57 */         pstmt.addBatch();
/*     */       }
/*  59 */       pstmt.executeBatch();
/*  60 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  63 */       ex.printStackTrace();
/*  64 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  65 */       CError tError = new CError();
/*  66 */       tError.moduleName = "CRSInfoDBSet";
/*  67 */       tError.functionName = "delete()";
/*  68 */       tError.errorMessage = ex.toString();
/*  69 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/*  72 */         pstmt.close();
/*     */       } catch (Exception e) {
/*  74 */         e.printStackTrace();
/*     */       }
/*     */ 
/*  77 */       if (!this.mflag) {
/*     */         try {
/*  79 */           this.con.close();
/*     */         } catch (Exception e) {
/*  81 */           e.printStackTrace();
/*     */         }
/*     */       }
/*     */ 
/*  85 */       return false;
/*     */     }
/*     */ 
/*  88 */     if (!this.mflag) {
/*     */       try {
/*  90 */         this.con.close();
/*     */       } catch (Exception e) {
/*  92 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */ 
/*  96 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update() {
/* 100 */     PreparedStatement pstmt = null;
/*     */ 
/* 102 */     if (!this.mflag) {
/* 103 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */     try
/*     */     {
/* 107 */       int tCount = size();
/* 108 */       pstmt = this.con.prepareStatement(
/* 109 */         "UPDATE CRSInfo SET  contNo=?, CustomerName = ?,taxResidentType=?, firstName=?, lastName=?, birthday=?, currentAddress_Country=?,currentAddress_Province=?,currentAddress_City=?,currentAddress_Detail=?,currentAddress_Country_en=?, currentAddress_Province_en=?, currentAddress_City_en=?,currentAddress_Detail_en=?, birthAddress_Country=?, birthAddress_Province=?,birthAddress_City=?,birthAddress_Detail=?,birthAddress_Country_en=?,birthAddress_Province_en=?,birthAddress_City_en=?,birthAddress_Detail_en=?,taxResidentCountry1=?,taxpayerCode1=?,taxResidentCountry2=?,taxpayerCode2=?,taxResidentCountry3=?,taxpayerCode3=?,noTaxpayercodeReason=?,reasonDescription=?,sourceType=?  WHERE  ContNo = ?");
/*     */ 
/* 114 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 116 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 117 */           pstmt.setString(1, null);
/*     */         else {
/* 119 */           pstmt.setString(1, get(i).getContNo());
/*     */         }
/* 121 */         if ((get(i).getCustomerName() == null) || (get(i).getCustomerName().equals("null")))
/* 122 */           pstmt.setString(2, null);
/*     */         else {
/* 124 */           pstmt.setString(2, get(i).getCustomerName());
/*     */         }
/* 126 */         if ((get(i).getTaxResidentType() == null) || (get(i).getTaxResidentType().equals("null")))
/* 127 */           pstmt.setString(3, null);
/*     */         else {
/* 129 */           pstmt.setString(3, get(i).getTaxResidentType());
/*     */         }
/* 131 */         if ((get(i).getFirstName() == null) || (get(i).getFirstName().equals("null")))
/* 132 */           pstmt.setString(4, null);
/*     */         else {
/* 134 */           pstmt.setString(4, get(i).getFirstName());
/*     */         }
/* 136 */         if ((get(i).getLastName() == null) || (get(i).getLastName().equals("null")))
/* 137 */           pstmt.setString(5, null);
/*     */         else {
/* 139 */           pstmt.setString(5, get(i).getLastName());
/*     */         }
/* 141 */         if ((get(i).getBirthday() == null) || (get(i).getBirthday().equals("null")))
/* 142 */           pstmt.setString(6, null);
/*     */         else {
/* 144 */           pstmt.setString(6, get(i).getBirthday());
/*     */         }
/* 146 */         if ((get(i).getCurrentAddress_Country() == null) || 
/* 147 */           (get(i).getCurrentAddress_Country().equals("null")))
/* 148 */           pstmt.setString(7, null);
/*     */         else {
/* 150 */           pstmt.setString(7, get(i).getCurrentAddress_Country());
/*     */         }
/* 152 */         if ((get(i).getCurrentAddress_Province() == null) || 
/* 153 */           (get(i).getCurrentAddress_Province().equals("null")))
/* 154 */           pstmt.setString(8, null);
/*     */         else {
/* 156 */           pstmt.setString(8, get(i).getCurrentAddress_Province());
/*     */         }
/* 158 */         if ((get(i).getCurrentAddress_City() == null) || 
/* 159 */           (get(i).getCurrentAddress_City().equals("null")))
/* 160 */           pstmt.setString(9, null);
/*     */         else {
/* 162 */           pstmt.setString(9, get(i).getCurrentAddress_City());
/*     */         }
/* 164 */         if ((get(i).getCurrentAddress_Detail() == null) || 
/* 165 */           (get(i).getCurrentAddress_Detail().equals("null")))
/* 166 */           pstmt.setString(10, null);
/*     */         else {
/* 168 */           pstmt.setString(10, get(i).getCurrentAddress_Detail());
/*     */         }
/* 170 */         if ((get(i).getCurrentAddress_Country_en() == null) || 
/* 171 */           (get(i).getCurrentAddress_Country_en().equals("null")))
/* 172 */           pstmt.setString(11, null);
/*     */         else {
/* 174 */           pstmt.setString(11, get(i).getCurrentAddress_Country_en());
/*     */         }
/* 176 */         if ((get(i).getCurrentAddress_Province_en() == null) || 
/* 177 */           (get(i).getCurrentAddress_Province_en().equals("null")))
/* 178 */           pstmt.setString(12, null);
/*     */         else {
/* 180 */           pstmt.setString(12, get(i).getCurrentAddress_Province_en());
/*     */         }
/* 182 */         if ((get(i).getCurrentAddress_City_en() == null) || 
/* 183 */           (get(i).getCurrentAddress_City_en().equals("null")))
/* 184 */           pstmt.setString(13, null);
/*     */         else {
/* 186 */           pstmt.setString(13, get(i).getCurrentAddress_City_en());
/*     */         }
/* 188 */         if ((get(i).getCurrentAddress_Detail_en() == null) || 
/* 189 */           (get(i).getCurrentAddress_Detail_en().equals("null")))
/* 190 */           pstmt.setString(14, null);
/*     */         else {
/* 192 */           pstmt.setString(14, get(i).getCurrentAddress_Detail_en());
/*     */         }
/* 194 */         if ((get(i).getBirthAddress_Country() == null) || 
/* 195 */           (get(i).getBirthAddress_Country().equals("null")))
/* 196 */           pstmt.setString(15, null);
/*     */         else {
/* 198 */           pstmt.setString(15, get(i).getBirthAddress_Country());
/*     */         }
/* 200 */         if ((get(i).getBirthAddress_Province() == null) || 
/* 201 */           (get(i).getBirthAddress_Province().equals("null")))
/* 202 */           pstmt.setString(16, null);
/*     */         else {
/* 204 */           pstmt.setString(16, get(i).getBirthAddress_Province());
/*     */         }
/* 206 */         if ((get(i).getBirthAddress_City() == null) || (get(i).getBirthAddress_City().equals("null")))
/* 207 */           pstmt.setString(17, null);
/*     */         else {
/* 209 */           pstmt.setString(17, get(i).getBirthAddress_City());
/*     */         }
/* 211 */         if ((get(i).getBirthAddress_Detail() == null) || 
/* 212 */           (get(i).getBirthAddress_Detail().equals("null")))
/* 213 */           pstmt.setString(18, null);
/*     */         else {
/* 215 */           pstmt.setString(18, get(i).getBirthAddress_Detail());
/*     */         }
/* 217 */         if ((get(i).getBirthAddress_Country_en() == null) || 
/* 218 */           (get(i).getBirthAddress_Country_en().equals("null")))
/* 219 */           pstmt.setString(19, null);
/*     */         else {
/* 221 */           pstmt.setString(19, get(i).getBirthAddress_Country_en());
/*     */         }
/* 223 */         if ((get(i).getBirthAddress_Province_en() == null) || 
/* 224 */           (get(i).getBirthAddress_Province_en().equals("null")))
/* 225 */           pstmt.setString(20, null);
/*     */         else {
/* 227 */           pstmt.setString(20, get(i).getBirthAddress_Province_en());
/*     */         }
/* 229 */         if ((get(i).getBirthAddress_City_en() == null) || 
/* 230 */           (get(i).getBirthAddress_City_en().equals("null")))
/* 231 */           pstmt.setString(21, null);
/*     */         else {
/* 233 */           pstmt.setString(21, get(i).getBirthAddress_City_en());
/*     */         }
/* 235 */         if ((get(i).getBirthAddress_Detail_en() == null) || 
/* 236 */           (get(i).getBirthAddress_Detail_en().equals("null")))
/* 237 */           pstmt.setString(22, null);
/*     */         else {
/* 239 */           pstmt.setString(22, get(i).getBirthAddress_Detail_en());
/*     */         }
/* 241 */         if ((get(i).getTaxResidentCountry1() == null) || 
/* 242 */           (get(i).getTaxResidentCountry1().equals("null")))
/* 243 */           pstmt.setString(23, null);
/*     */         else {
/* 245 */           pstmt.setString(23, get(i).getTaxResidentCountry1());
/*     */         }
/* 247 */         if ((get(i).getTaxpayerCode1() == null) || (get(i).getTaxpayerCode1().equals("null")))
/* 248 */           pstmt.setString(24, null);
/*     */         else {
/* 250 */           pstmt.setString(24, get(i).getTaxpayerCode1());
/*     */         }
/* 252 */         if ((get(i).getTaxResidentCountry2() == null) || 
/* 253 */           (get(i).getTaxResidentCountry2().equals("null")))
/* 254 */           pstmt.setString(25, null);
/*     */         else {
/* 256 */           pstmt.setString(25, get(i).getTaxResidentCountry2());
/*     */         }
/* 258 */         if ((get(i).getTaxpayerCode2() == null) || (get(i).getTaxpayerCode2().equals("null")))
/* 259 */           pstmt.setString(26, null);
/*     */         else {
/* 261 */           pstmt.setString(26, get(i).getTaxpayerCode2());
/*     */         }
/* 263 */         if ((get(i).getTaxResidentCountry3() == null) || 
/* 264 */           (get(i).getTaxResidentCountry3().equals("null")))
/* 265 */           pstmt.setString(27, null);
/*     */         else {
/* 267 */           pstmt.setString(27, get(i).getTaxResidentCountry3());
/*     */         }
/* 269 */         if ((get(i).getTaxpayerCode3() == null) || (get(i).getTaxpayerCode3().equals("null")))
/* 270 */           pstmt.setString(28, null);
/*     */         else {
/* 272 */           pstmt.setString(28, get(i).getTaxpayerCode3());
/*     */         }
/* 274 */         if ((get(i).getNoTaxpayercodeReason() == null) || 
/* 275 */           (get(i).getNoTaxpayercodeReason().equals("null")))
/* 276 */           pstmt.setString(29, null);
/*     */         else {
/* 278 */           pstmt.setString(29, get(i).getNoTaxpayercodeReason());
/*     */         }
/* 280 */         if ((get(i).getReasonDescription() == null) || (get(i).getReasonDescription().equals("null")))
/* 281 */           pstmt.setString(30, null);
/*     */         else {
/* 283 */           pstmt.setString(30, get(i).getReasonDescription());
/*     */         }
/* 285 */         if ((get(i).getSourceType() == null) || (get(i).getSourceType().equals("null")))
/* 286 */           pstmt.setString(31, null);
/*     */         else {
/* 288 */           pstmt.setString(31, get(i).getSourceType());
/*     */         }
/*     */ 
/* 291 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 292 */           pstmt.setString(32, null);
/*     */         else {
/* 294 */           pstmt.setString(32, get(i).getContNo());
/*     */         }
/* 296 */         pstmt.addBatch();
/*     */       }
/* 298 */       pstmt.executeBatch();
/* 299 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 302 */       ex.printStackTrace();
/* 303 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 304 */       CError tError = new CError();
/* 305 */       tError.moduleName = "CRSInfoDBSet";
/* 306 */       tError.functionName = "update()";
/* 307 */       tError.errorMessage = ex.toString();
/* 308 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 311 */         pstmt.close();
/*     */       } catch (Exception e) {
/* 313 */         e.printStackTrace();
/*     */       }
/*     */ 
/* 316 */       if (!this.mflag) {
/*     */         try {
/* 318 */           this.con.close();
/*     */         } catch (Exception e) {
/* 320 */           e.printStackTrace();
/*     */         }
/*     */       }
/*     */ 
/* 324 */       return false;
/*     */     }
/*     */ 
/* 327 */     if (!this.mflag) {
/*     */       try {
/* 329 */         this.con.close();
/*     */       } catch (Exception e) {
/* 331 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */ 
/* 335 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert() {
/* 339 */     PreparedStatement pstmt = null;
/*     */ 
/* 341 */     if (!this.mflag) {
/* 342 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */     try
/*     */     {
/* 346 */       int tCount = size();
/* 347 */       pstmt = this.con.prepareStatement(
/* 348 */         "INSERT INTO CRSInfo VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
/* 349 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 351 */         if ((get(i).getContNo() == null) || (get(i).getContNo().equals("null")))
/* 352 */           pstmt.setString(1, null);
/*     */         else {
/* 354 */           pstmt.setString(1, get(i).getContNo());
/*     */         }
/* 356 */         if ((get(i).getCustomerName() == null) || (get(i).getCustomerName().equals("null")))
/* 357 */           pstmt.setString(2, null);
/*     */         else {
/* 359 */           pstmt.setString(2, get(i).getCustomerName());
/*     */         }
/* 361 */         if ((get(i).getTaxResidentType() == null) || (get(i).getTaxResidentType().equals("null")))
/* 362 */           pstmt.setString(3, null);
/*     */         else {
/* 364 */           pstmt.setString(3, get(i).getTaxResidentType());
/*     */         }
/* 366 */         if ((get(i).getFirstName() == null) || (get(i).getFirstName().equals("null")))
/* 367 */           pstmt.setString(4, null);
/*     */         else {
/* 369 */           pstmt.setString(4, get(i).getFirstName());
/*     */         }
/* 371 */         if ((get(i).getLastName() == null) || (get(i).getLastName().equals("null")))
/* 372 */           pstmt.setString(5, null);
/*     */         else {
/* 374 */           pstmt.setString(5, get(i).getLastName());
/*     */         }
/* 376 */         if ((get(i).getBirthday() == null) || (get(i).getBirthday().equals("null")))
/* 377 */           pstmt.setString(6, null);
/*     */         else {
/* 379 */           pstmt.setString(6, get(i).getBirthday());
/*     */         }
/* 381 */         if ((get(i).getCurrentAddress_Country() == null) || 
/* 382 */           (get(i).getCurrentAddress_Country().equals("null")))
/* 383 */           pstmt.setString(7, null);
/*     */         else {
/* 385 */           pstmt.setString(7, get(i).getCurrentAddress_Country());
/*     */         }
/* 387 */         if ((get(i).getCurrentAddress_Province() == null) || 
/* 388 */           (get(i).getCurrentAddress_Province().equals("null")))
/* 389 */           pstmt.setString(8, null);
/*     */         else {
/* 391 */           pstmt.setString(8, get(i).getCurrentAddress_Province());
/*     */         }
/* 393 */         if ((get(i).getCurrentAddress_City() == null) || 
/* 394 */           (get(i).getCurrentAddress_City().equals("null")))
/* 395 */           pstmt.setString(9, null);
/*     */         else {
/* 397 */           pstmt.setString(9, get(i).getCurrentAddress_City());
/*     */         }
/* 399 */         if ((get(i).getCurrentAddress_Detail() == null) || 
/* 400 */           (get(i).getCurrentAddress_Detail().equals("null")))
/* 401 */           pstmt.setString(10, null);
/*     */         else {
/* 403 */           pstmt.setString(10, get(i).getCurrentAddress_Detail());
/*     */         }
/* 405 */         if ((get(i).getCurrentAddress_Country_en() == null) || 
/* 406 */           (get(i).getCurrentAddress_Country_en().equals("null")))
/* 407 */           pstmt.setString(11, null);
/*     */         else {
/* 409 */           pstmt.setString(11, get(i).getCurrentAddress_Country_en());
/*     */         }
/* 411 */         if ((get(i).getCurrentAddress_Province_en() == null) || 
/* 412 */           (get(i).getCurrentAddress_Province_en().equals("null")))
/* 413 */           pstmt.setString(12, null);
/*     */         else {
/* 415 */           pstmt.setString(12, get(i).getCurrentAddress_Province_en());
/*     */         }
/* 417 */         if ((get(i).getCurrentAddress_City_en() == null) || 
/* 418 */           (get(i).getCurrentAddress_City_en().equals("null")))
/* 419 */           pstmt.setString(13, null);
/*     */         else {
/* 421 */           pstmt.setString(13, get(i).getCurrentAddress_City_en());
/*     */         }
/* 423 */         if ((get(i).getCurrentAddress_Detail_en() == null) || 
/* 424 */           (get(i).getCurrentAddress_Detail_en().equals("null")))
/* 425 */           pstmt.setString(14, null);
/*     */         else {
/* 427 */           pstmt.setString(14, get(i).getCurrentAddress_Detail_en());
/*     */         }
/* 429 */         if ((get(i).getBirthAddress_Country() == null) || 
/* 430 */           (get(i).getBirthAddress_Country().equals("null")))
/* 431 */           pstmt.setString(15, null);
/*     */         else {
/* 433 */           pstmt.setString(15, get(i).getBirthAddress_Country());
/*     */         }
/* 435 */         if ((get(i).getBirthAddress_Province() == null) || 
/* 436 */           (get(i).getBirthAddress_Province().equals("null")))
/* 437 */           pstmt.setString(16, null);
/*     */         else {
/* 439 */           pstmt.setString(16, get(i).getBirthAddress_Province());
/*     */         }
/* 441 */         if ((get(i).getBirthAddress_City() == null) || (get(i).getBirthAddress_City().equals("null")))
/* 442 */           pstmt.setString(17, null);
/*     */         else {
/* 444 */           pstmt.setString(17, get(i).getBirthAddress_City());
/*     */         }
/* 446 */         if ((get(i).getBirthAddress_Detail() == null) || 
/* 447 */           (get(i).getBirthAddress_Detail().equals("null")))
/* 448 */           pstmt.setString(18, null);
/*     */         else {
/* 450 */           pstmt.setString(18, get(i).getBirthAddress_Detail());
/*     */         }
/* 452 */         if ((get(i).getBirthAddress_Country_en() == null) || 
/* 453 */           (get(i).getBirthAddress_Country_en().equals("null")))
/* 454 */           pstmt.setString(19, null);
/*     */         else {
/* 456 */           pstmt.setString(19, get(i).getBirthAddress_Country_en());
/*     */         }
/* 458 */         if ((get(i).getBirthAddress_Province_en() == null) || 
/* 459 */           (get(i).getBirthAddress_Province_en().equals("null")))
/* 460 */           pstmt.setString(20, null);
/*     */         else {
/* 462 */           pstmt.setString(20, get(i).getBirthAddress_Province_en());
/*     */         }
/* 464 */         if ((get(i).getBirthAddress_City_en() == null) || 
/* 465 */           (get(i).getBirthAddress_City_en().equals("null")))
/* 466 */           pstmt.setString(21, null);
/*     */         else {
/* 468 */           pstmt.setString(21, get(i).getBirthAddress_City_en());
/*     */         }
/* 470 */         if ((get(i).getBirthAddress_Detail_en() == null) || 
/* 471 */           (get(i).getBirthAddress_Detail_en().equals("null")))
/* 472 */           pstmt.setString(22, null);
/*     */         else {
/* 474 */           pstmt.setString(22, get(i).getBirthAddress_Detail_en());
/*     */         }
/* 476 */         if ((get(i).getTaxResidentCountry1() == null) || 
/* 477 */           (get(i).getTaxResidentCountry1().equals("null")))
/* 478 */           pstmt.setString(23, null);
/*     */         else {
/* 480 */           pstmt.setString(23, get(i).getTaxResidentCountry1());
/*     */         }
/* 482 */         if ((get(i).getTaxpayerCode1() == null) || (get(i).getTaxpayerCode1().equals("null")))
/* 483 */           pstmt.setString(24, null);
/*     */         else {
/* 485 */           pstmt.setString(24, get(i).getTaxpayerCode1());
/*     */         }
/* 487 */         if ((get(i).getTaxResidentCountry2() == null) || 
/* 488 */           (get(i).getTaxResidentCountry2().equals("null")))
/* 489 */           pstmt.setString(25, null);
/*     */         else {
/* 491 */           pstmt.setString(25, get(i).getTaxResidentCountry2());
/*     */         }
/* 493 */         if ((get(i).getTaxpayerCode2() == null) || (get(i).getTaxpayerCode2().equals("null")))
/* 494 */           pstmt.setString(26, null);
/*     */         else {
/* 496 */           pstmt.setString(26, get(i).getTaxpayerCode2());
/*     */         }
/* 498 */         if ((get(i).getTaxResidentCountry3() == null) || 
/* 499 */           (get(i).getTaxResidentCountry3().equals("null")))
/* 500 */           pstmt.setString(27, null);
/*     */         else {
/* 502 */           pstmt.setString(27, get(i).getTaxResidentCountry3());
/*     */         }
/* 504 */         if ((get(i).getTaxpayerCode3() == null) || (get(i).getTaxpayerCode3().equals("null")))
/* 505 */           pstmt.setString(28, null);
/*     */         else {
/* 507 */           pstmt.setString(28, get(i).getTaxpayerCode3());
/*     */         }
/* 509 */         if ((get(i).getNoTaxpayercodeReason() == null) || 
/* 510 */           (get(i).getNoTaxpayercodeReason().equals("null")))
/* 511 */           pstmt.setString(29, null);
/*     */         else {
/* 513 */           pstmt.setString(29, get(i).getNoTaxpayercodeReason());
/*     */         }
/* 515 */         if ((get(i).getReasonDescription() == null) || (get(i).getReasonDescription().equals("null")))
/* 516 */           pstmt.setString(30, null);
/*     */         else {
/* 518 */           pstmt.setString(30, get(i).getReasonDescription());
/*     */         }
/* 520 */         if ((get(i).getSourceType() == null) || (get(i).getSourceType().equals("null")))
/* 521 */           pstmt.setString(31, null);
/*     */         else {
/* 523 */           pstmt.setString(31, get(i).getSourceType());
/*     */         }
/*     */ 
/* 526 */         pstmt.addBatch();
/*     */       }
/* 528 */       pstmt.executeBatch();
/* 529 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 532 */       ex.printStackTrace();
/* 533 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 534 */       CError tError = new CError();
/* 535 */       tError.moduleName = "CRSInfoDBSet";
/* 536 */       tError.functionName = "insert()";
/* 537 */       tError.errorMessage = ex.toString();
/* 538 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 541 */         pstmt.close();
/*     */       } catch (Exception e) {
/* 543 */         e.printStackTrace();
/*     */       }
/*     */ 
/* 546 */       if (!this.mflag) {
/*     */         try {
/* 548 */           this.con.close();
/*     */         } catch (Exception e) {
/* 550 */           e.printStackTrace();
/*     */         }
/*     */       }
/*     */ 
/* 554 */       return false;
/*     */     }
/*     */ 
/* 557 */     if (!this.mflag) {
/*     */       try {
/* 559 */         this.con.close();
/*     */       } catch (Exception e) {
/* 561 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */ 
/* 565 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.CRSInfoDBSet
 * JD-Core Version:    0.6.0
 */