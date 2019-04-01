/*     */ package com.sinosoft.banklns.lis.schema;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPAccountDB;
/*     */ import com.sinosoft.banklns.lis.pubfun.FDate;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.Schema;
/*     */ import com.sinosoft.banklns.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class LNPAccountSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String customerId;
/*     */   private String customerNo;
/*     */   private String accKind;
/*     */   private String bankCode;
/*     */   private String bankAccNo;
/*     */   private String accName;
/*     */   private String operator;
/*     */   private Date makeDate;
/*     */   private String makeTime;
/*     */   private Date modifyDate;
/*     */   private String modifyTime;
/*     */   public static final int FIELDNUM = 11;
/*     */   private static String[] PK;
/*  49 */   private FDate fDate = new FDate();
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public LNPAccountSchema()
/*     */   {
/*  56 */     this.mErrors = new CErrors();
/*     */ 
/*  58 */     String[] pk = new String[3];
/*  59 */     pk[0] = "CustomerNo";
/*  60 */     pk[1] = "BankCode";
/*  61 */     pk[2] = "BankAccNo";
/*     */ 
/*  63 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  70 */     LNPAccountSchema cloned = (LNPAccountSchema)super.clone();
/*  71 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  72 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  73 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  79 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getCustomerId()
/*     */   {
/*  84 */     return this.customerId;
/*     */   }
/*     */ 
/*     */   public void setCustomerId(String aCustomerId) {
/*  88 */     this.customerId = aCustomerId;
/*     */   }
/*     */ 
/*     */   public String getCustomerNo() {
/*  92 */     return this.customerNo;
/*     */   }
/*     */ 
/*     */   public void setCustomerNo(String aCustomerNo) {
/*  96 */     this.customerNo = aCustomerNo;
/*     */   }
/*     */ 
/*     */   public String getAccKind() {
/* 100 */     return this.accKind;
/*     */   }
/*     */ 
/*     */   public void setAccKind(String aAccKind) {
/* 104 */     this.accKind = aAccKind;
/*     */   }
/*     */ 
/*     */   public String getBankCode() {
/* 108 */     return this.bankCode;
/*     */   }
/*     */ 
/*     */   public void setBankCode(String aBankCode) {
/* 112 */     this.bankCode = aBankCode;
/*     */   }
/*     */ 
/*     */   public String getBankAccNo() {
/* 116 */     return this.bankAccNo;
/*     */   }
/*     */ 
/*     */   public void setBankAccNo(String aBankAccNo) {
/* 120 */     this.bankAccNo = aBankAccNo;
/*     */   }
/*     */ 
/*     */   public String getAccName() {
/* 124 */     return this.accName;
/*     */   }
/*     */ 
/*     */   public void setAccName(String aAccName) {
/* 128 */     this.accName = aAccName;
/*     */   }
/*     */ 
/*     */   public String getOperator() {
/* 132 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String aOperator) {
/* 136 */     this.operator = aOperator;
/*     */   }
/*     */ 
/*     */   public String getMakeDate() {
/* 140 */     if (this.makeDate != null) {
/* 141 */       return this.fDate.getString(this.makeDate);
/*     */     }
/* 143 */     return null;
/*     */   }
/*     */ 
/*     */   public void setMakeDate(Date aMakeDate) {
/* 147 */     this.makeDate = aMakeDate;
/*     */   }
/*     */ 
/*     */   public void setMakeDate(String aMakeDate) {
/* 151 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*     */     {
/* 153 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*     */     }
/*     */     else
/* 156 */       this.makeDate = null;
/*     */   }
/*     */ 
/*     */   public String getMakeTime()
/*     */   {
/* 161 */     return this.makeTime;
/*     */   }
/*     */ 
/*     */   public void setMakeTime(String aMakeTime) {
/* 165 */     this.makeTime = aMakeTime;
/*     */   }
/*     */ 
/*     */   public String getModifyDate() {
/* 169 */     if (this.modifyDate != null) {
/* 170 */       return this.fDate.getString(this.modifyDate);
/*     */     }
/* 172 */     return null;
/*     */   }
/*     */ 
/*     */   public void setModifyDate(Date aModifyDate) {
/* 176 */     this.modifyDate = aModifyDate;
/*     */   }
/*     */ 
/*     */   public void setModifyDate(String aModifyDate) {
/* 180 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*     */     {
/* 182 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*     */     }
/*     */     else
/* 185 */       this.modifyDate = null;
/*     */   }
/*     */ 
/*     */   public String getModifyTime()
/*     */   {
/* 190 */     return this.modifyTime;
/*     */   }
/*     */ 
/*     */   public void setModifyTime(String aModifyTime) {
/* 194 */     this.modifyTime = aModifyTime;
/*     */   }
/*     */ 
/*     */   public void setSchema(LNPAccountSchema aLNPAccountSchema)
/*     */   {
/* 200 */     this.customerId = aLNPAccountSchema.getCustomerId();
/* 201 */     this.customerNo = aLNPAccountSchema.getCustomerNo();
/* 202 */     this.accKind = aLNPAccountSchema.getAccKind();
/* 203 */     this.bankCode = aLNPAccountSchema.getBankCode();
/* 204 */     this.bankAccNo = aLNPAccountSchema.getBankAccNo();
/* 205 */     this.accName = aLNPAccountSchema.getAccName();
/* 206 */     this.operator = aLNPAccountSchema.getOperator();
/* 207 */     this.makeDate = this.fDate.getDate(aLNPAccountSchema.getMakeDate());
/* 208 */     this.makeTime = aLNPAccountSchema.getMakeTime();
/* 209 */     this.modifyDate = this.fDate.getDate(aLNPAccountSchema.getModifyDate());
/* 210 */     this.modifyTime = aLNPAccountSchema.getModifyTime();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 219 */       if (rs.getString("CustomerId") == null)
/* 220 */         this.customerId = null;
/*     */       else {
/* 222 */         this.customerId = rs.getString("CustomerId").trim();
/*     */       }
/* 224 */       if (rs.getString("CustomerNo") == null)
/* 225 */         this.customerNo = null;
/*     */       else {
/* 227 */         this.customerNo = rs.getString("CustomerNo").trim();
/*     */       }
/* 229 */       if (rs.getString("AccKind") == null)
/* 230 */         this.accKind = null;
/*     */       else {
/* 232 */         this.accKind = rs.getString("AccKind").trim();
/*     */       }
/* 234 */       if (rs.getString("BankCode") == null)
/* 235 */         this.bankCode = null;
/*     */       else {
/* 237 */         this.bankCode = rs.getString("BankCode").trim();
/*     */       }
/* 239 */       if (rs.getString("BankAccNo") == null)
/* 240 */         this.bankAccNo = null;
/*     */       else {
/* 242 */         this.bankAccNo = rs.getString("BankAccNo").trim();
/*     */       }
/* 244 */       if (rs.getString("AccName") == null)
/* 245 */         this.accName = null;
/*     */       else {
/* 247 */         this.accName = rs.getString("AccName").trim();
/*     */       }
/* 249 */       if (rs.getString("Operator") == null)
/* 250 */         this.operator = null;
/*     */       else {
/* 252 */         this.operator = rs.getString("Operator").trim();
/*     */       }
/* 254 */       this.makeDate = rs.getDate("MakeDate");
/* 255 */       if (rs.getString("MakeTime") == null)
/* 256 */         this.makeTime = null;
/*     */       else {
/* 258 */         this.makeTime = rs.getString("MakeTime").trim();
/*     */       }
/* 260 */       this.modifyDate = rs.getDate("ModifyDate");
/* 261 */       if (rs.getString("ModifyTime") == null)
/* 262 */         this.modifyTime = null;
/*     */       else {
/* 264 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 269 */       System.out.println("\u93C1\u7248\u5D41\u6434\u64B2\u8151\u9428\u51E9NPAccount\u741B\u3125\u74E7\u5A08\u5178\u91DC\u93C1\u677F\u62F0Schema\u6D93\uE160\u6B91\u701B\u6941\uE18C\u6D93\uE045\u669F\u6D93\u5D84\u7AF4\u9477\u8FBE\u7D1D\u93B4\u682C\uFFFD\u546E\u58BD\u741B\u5B92b.executeQuery\u93CC\u30E8\uE1D7\u93C3\u8235\u75C5\u93C8\u5909\u5A07\u9422\u256Felect * from tables");
/*     */ 
/* 271 */       CError tError = new CError();
/* 272 */       tError.moduleName = "LNPAccountSchema";
/* 273 */       tError.functionName = "setSchema";
/* 274 */       tError.errorMessage = sqle.toString();
/* 275 */       this.mErrors.addOneError(tError);
/* 276 */       return false;
/*     */     }
/* 278 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPAccountSchema getSchema()
/*     */   {
/* 283 */     LNPAccountSchema aLNPAccountSchema = new LNPAccountSchema();
/* 284 */     aLNPAccountSchema.setSchema(this);
/* 285 */     return aLNPAccountSchema;
/*     */   }
/*     */ 
/*     */   public LNPAccountDB getDB()
/*     */   {
/* 290 */     LNPAccountDB aDBOper = new LNPAccountDB();
/* 291 */     aDBOper.setSchema(this);
/* 292 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 299 */     StringBuffer strReturn = new StringBuffer(256);
/* 300 */     strReturn.append(StrTool.cTrim(this.customerId)); strReturn.append("|");
/* 301 */     strReturn.append(StrTool.cTrim(this.customerNo)); strReturn.append("|");
/* 302 */     strReturn.append(StrTool.cTrim(this.accKind)); strReturn.append("|");
/* 303 */     strReturn.append(StrTool.cTrim(this.bankCode)); strReturn.append("|");
/* 304 */     strReturn.append(StrTool.cTrim(this.bankAccNo)); strReturn.append("|");
/* 305 */     strReturn.append(StrTool.cTrim(this.accName)); strReturn.append("|");
/* 306 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/* 307 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/* 308 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/* 309 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/* 310 */     strReturn.append(StrTool.cTrim(this.modifyTime));
/* 311 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 319 */       this.customerId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 320 */       this.customerNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 321 */       this.accKind = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 322 */       this.bankCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 323 */       this.bankAccNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 324 */       this.accName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 325 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 326 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|"));
/* 327 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/* 328 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
/* 329 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 334 */       CError tError = new CError();
/* 335 */       tError.moduleName = "LNPAccountSchema";
/* 336 */       tError.functionName = "decode";
/* 337 */       tError.errorMessage = ex.toString();
/* 338 */       this.mErrors.addOneError(tError);
/*     */ 
/* 340 */       return false;
/*     */     }
/* 342 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 348 */     String strReturn = "";
/* 349 */     if (FCode.equalsIgnoreCase("customerId"))
/*     */     {
/* 351 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.customerId));
/*     */     }
/* 353 */     if (FCode.equalsIgnoreCase("customerNo"))
/*     */     {
/* 355 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.customerNo));
/*     */     }
/* 357 */     if (FCode.equalsIgnoreCase("accKind"))
/*     */     {
/* 359 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.accKind));
/*     */     }
/* 361 */     if (FCode.equalsIgnoreCase("bankCode"))
/*     */     {
/* 363 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bankCode));
/*     */     }
/* 365 */     if (FCode.equalsIgnoreCase("bankAccNo"))
/*     */     {
/* 367 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bankAccNo));
/*     */     }
/* 369 */     if (FCode.equalsIgnoreCase("accName"))
/*     */     {
/* 371 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.accName));
/*     */     }
/* 373 */     if (FCode.equalsIgnoreCase("operator"))
/*     */     {
/* 375 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*     */     }
/* 377 */     if (FCode.equalsIgnoreCase("makeDate"))
/*     */     {
/* 379 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*     */     }
/* 381 */     if (FCode.equalsIgnoreCase("makeTime"))
/*     */     {
/* 383 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*     */     }
/* 385 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*     */     {
/* 387 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*     */     }
/* 389 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*     */     {
/* 391 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*     */     }
/* 393 */     if (strReturn.equals(""))
/*     */     {
/* 395 */       strReturn = "null";
/*     */     }
/*     */ 
/* 398 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 405 */     String strFieldValue = "";
/* 406 */     switch (nFieldIndex) {
/*     */     case 0:
/* 408 */       strFieldValue = StrTool.GBKToUnicode(this.customerId);
/* 409 */       break;
/*     */     case 1:
/* 411 */       strFieldValue = StrTool.GBKToUnicode(this.customerNo);
/* 412 */       break;
/*     */     case 2:
/* 414 */       strFieldValue = StrTool.GBKToUnicode(this.accKind);
/* 415 */       break;
/*     */     case 3:
/* 417 */       strFieldValue = StrTool.GBKToUnicode(this.bankCode);
/* 418 */       break;
/*     */     case 4:
/* 420 */       strFieldValue = StrTool.GBKToUnicode(this.bankAccNo);
/* 421 */       break;
/*     */     case 5:
/* 423 */       strFieldValue = StrTool.GBKToUnicode(this.accName);
/* 424 */       break;
/*     */     case 6:
/* 426 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 427 */       break;
/*     */     case 7:
/* 429 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/* 430 */       break;
/*     */     case 8:
/* 432 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 433 */       break;
/*     */     case 9:
/* 435 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/* 436 */       break;
/*     */     case 10:
/* 438 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 439 */       break;
/*     */     default:
/* 441 */       strFieldValue = "";
/*     */     }
/* 443 */     if (strFieldValue.equals("")) {
/* 444 */       strFieldValue = "null";
/*     */     }
/* 446 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 452 */     if (StrTool.cTrim(FCode).equals("")) {
/* 453 */       return false;
/*     */     }
/* 455 */     if (FCode.equalsIgnoreCase("customerId"))
/*     */     {
/* 457 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 459 */         this.customerId = FValue.trim();
/*     */       }
/*     */       else
/* 462 */         this.customerId = null;
/*     */     }
/* 464 */     if (FCode.equalsIgnoreCase("customerNo"))
/*     */     {
/* 466 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 468 */         this.customerNo = FValue.trim();
/*     */       }
/*     */       else
/* 471 */         this.customerNo = null;
/*     */     }
/* 473 */     if (FCode.equalsIgnoreCase("accKind"))
/*     */     {
/* 475 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 477 */         this.accKind = FValue.trim();
/*     */       }
/*     */       else
/* 480 */         this.accKind = null;
/*     */     }
/* 482 */     if (FCode.equalsIgnoreCase("bankCode"))
/*     */     {
/* 484 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 486 */         this.bankCode = FValue.trim();
/*     */       }
/*     */       else
/* 489 */         this.bankCode = null;
/*     */     }
/* 491 */     if (FCode.equalsIgnoreCase("bankAccNo"))
/*     */     {
/* 493 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 495 */         this.bankAccNo = FValue.trim();
/*     */       }
/*     */       else
/* 498 */         this.bankAccNo = null;
/*     */     }
/* 500 */     if (FCode.equalsIgnoreCase("accName"))
/*     */     {
/* 502 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 504 */         this.accName = FValue.trim();
/*     */       }
/*     */       else
/* 507 */         this.accName = null;
/*     */     }
/* 509 */     if (FCode.equalsIgnoreCase("operator"))
/*     */     {
/* 511 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 513 */         this.operator = FValue.trim();
/*     */       }
/*     */       else
/* 516 */         this.operator = null;
/*     */     }
/* 518 */     if (FCode.equalsIgnoreCase("makeDate"))
/*     */     {
/* 520 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 522 */         this.makeDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 525 */         this.makeDate = null;
/*     */     }
/* 527 */     if (FCode.equalsIgnoreCase("makeTime"))
/*     */     {
/* 529 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 531 */         this.makeTime = FValue.trim();
/*     */       }
/*     */       else
/* 534 */         this.makeTime = null;
/*     */     }
/* 536 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*     */     {
/* 538 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 540 */         this.modifyDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 543 */         this.modifyDate = null;
/*     */     }
/* 545 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*     */     {
/* 547 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 549 */         this.modifyTime = FValue.trim();
/*     */       }
/*     */       else
/* 552 */         this.modifyTime = null;
/*     */     }
/* 554 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 559 */     if (otherObject == null) return false;
/* 560 */     if (this == otherObject) return true;
/* 561 */     if (getClass() != otherObject.getClass()) return false;
/* 562 */     LNPAccountSchema other = (LNPAccountSchema)otherObject;
/* 563 */     if ((this.customerId == null) && (other.getCustomerId() != null)) return false;
/* 564 */     if ((this.customerId != null) && (!this.customerId.equals(other.getCustomerId()))) return false;
/* 565 */     if ((this.customerNo == null) && (other.getCustomerNo() != null)) return false;
/* 566 */     if ((this.customerNo != null) && (!this.customerNo.equals(other.getCustomerNo()))) return false;
/* 567 */     if ((this.accKind == null) && (other.getAccKind() != null)) return false;
/* 568 */     if ((this.accKind != null) && (!this.accKind.equals(other.getAccKind()))) return false;
/* 569 */     if ((this.bankCode == null) && (other.getBankCode() != null)) return false;
/* 570 */     if ((this.bankCode != null) && (!this.bankCode.equals(other.getBankCode()))) return false;
/* 571 */     if ((this.bankAccNo == null) && (other.getBankAccNo() != null)) return false;
/* 572 */     if ((this.bankAccNo != null) && (!this.bankAccNo.equals(other.getBankAccNo()))) return false;
/* 573 */     if ((this.accName == null) && (other.getAccName() != null)) return false;
/* 574 */     if ((this.accName != null) && (!this.accName.equals(other.getAccName()))) return false;
/* 575 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 576 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 577 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 578 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 579 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 580 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 581 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 582 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 583 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 584 */     return (this.modifyTime == null) || (this.modifyTime.equals(other.getModifyTime()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 591 */     return 11;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 597 */     if (strFieldName.equals("customerId")) {
/* 598 */       return 0;
/*     */     }
/* 600 */     if (strFieldName.equals("customerNo")) {
/* 601 */       return 1;
/*     */     }
/* 603 */     if (strFieldName.equals("accKind")) {
/* 604 */       return 2;
/*     */     }
/* 606 */     if (strFieldName.equals("bankCode")) {
/* 607 */       return 3;
/*     */     }
/* 609 */     if (strFieldName.equals("bankAccNo")) {
/* 610 */       return 4;
/*     */     }
/* 612 */     if (strFieldName.equals("accName")) {
/* 613 */       return 5;
/*     */     }
/* 615 */     if (strFieldName.equals("operator")) {
/* 616 */       return 6;
/*     */     }
/* 618 */     if (strFieldName.equals("makeDate")) {
/* 619 */       return 7;
/*     */     }
/* 621 */     if (strFieldName.equals("makeTime")) {
/* 622 */       return 8;
/*     */     }
/* 624 */     if (strFieldName.equals("modifyDate")) {
/* 625 */       return 9;
/*     */     }
/* 627 */     if (strFieldName.equals("modifyTime")) {
/* 628 */       return 10;
/*     */     }
/* 630 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 636 */     String strFieldName = "";
/* 637 */     switch (nFieldIndex) {
/*     */     case 0:
/* 639 */       strFieldName = "customerId";
/* 640 */       break;
/*     */     case 1:
/* 642 */       strFieldName = "customerNo";
/* 643 */       break;
/*     */     case 2:
/* 645 */       strFieldName = "accKind";
/* 646 */       break;
/*     */     case 3:
/* 648 */       strFieldName = "bankCode";
/* 649 */       break;
/*     */     case 4:
/* 651 */       strFieldName = "bankAccNo";
/* 652 */       break;
/*     */     case 5:
/* 654 */       strFieldName = "accName";
/* 655 */       break;
/*     */     case 6:
/* 657 */       strFieldName = "operator";
/* 658 */       break;
/*     */     case 7:
/* 660 */       strFieldName = "makeDate";
/* 661 */       break;
/*     */     case 8:
/* 663 */       strFieldName = "makeTime";
/* 664 */       break;
/*     */     case 9:
/* 666 */       strFieldName = "modifyDate";
/* 667 */       break;
/*     */     case 10:
/* 669 */       strFieldName = "modifyTime";
/* 670 */       break;
/*     */     default:
/* 672 */       strFieldName = "";
/*     */     }
/* 674 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 680 */     if (strFieldName.equals("customerId")) {
/* 681 */       return 0;
/*     */     }
/* 683 */     if (strFieldName.equals("customerNo")) {
/* 684 */       return 0;
/*     */     }
/* 686 */     if (strFieldName.equals("accKind")) {
/* 687 */       return 0;
/*     */     }
/* 689 */     if (strFieldName.equals("bankCode")) {
/* 690 */       return 0;
/*     */     }
/* 692 */     if (strFieldName.equals("bankAccNo")) {
/* 693 */       return 0;
/*     */     }
/* 695 */     if (strFieldName.equals("accName")) {
/* 696 */       return 0;
/*     */     }
/* 698 */     if (strFieldName.equals("operator")) {
/* 699 */       return 0;
/*     */     }
/* 701 */     if (strFieldName.equals("makeDate")) {
/* 702 */       return 1;
/*     */     }
/* 704 */     if (strFieldName.equals("makeTime")) {
/* 705 */       return 0;
/*     */     }
/* 707 */     if (strFieldName.equals("modifyDate")) {
/* 708 */       return 1;
/*     */     }
/* 710 */     if (strFieldName.equals("modifyTime")) {
/* 711 */       return 0;
/*     */     }
/* 713 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 719 */     int nFieldType = -1;
/* 720 */     switch (nFieldIndex) {
/*     */     case 0:
/* 722 */       nFieldType = 0;
/* 723 */       break;
/*     */     case 1:
/* 725 */       nFieldType = 0;
/* 726 */       break;
/*     */     case 2:
/* 728 */       nFieldType = 0;
/* 729 */       break;
/*     */     case 3:
/* 731 */       nFieldType = 0;
/* 732 */       break;
/*     */     case 4:
/* 734 */       nFieldType = 0;
/* 735 */       break;
/*     */     case 5:
/* 737 */       nFieldType = 0;
/* 738 */       break;
/*     */     case 6:
/* 740 */       nFieldType = 0;
/* 741 */       break;
/*     */     case 7:
/* 743 */       nFieldType = 1;
/* 744 */       break;
/*     */     case 8:
/* 746 */       nFieldType = 0;
/* 747 */       break;
/*     */     case 9:
/* 749 */       nFieldType = 1;
/* 750 */       break;
/*     */     case 10:
/* 752 */       nFieldType = 0;
/* 753 */       break;
/*     */     default:
/* 755 */       nFieldType = -1;
/*     */     }
/* 757 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPAccountSchema
 * JD-Core Version:    0.6.0
 */