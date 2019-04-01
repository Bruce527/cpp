/*     */ package com.sinosoft.banklns.lis.schema;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPTransRcorsDB;
/*     */ import com.sinosoft.banklns.lis.pubfun.FDate;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.Schema;
/*     */ import com.sinosoft.banklns.utility.StrTool;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class LNPTransRcorsSchema
/*     */   implements Schema
/*     */ {
/*     */   private String EdorNo;
/*     */   private String serialNo;
/*     */   private String ContNo;
/*     */   private String Operator;
/*     */   private Date MakeDate;
/*     */   private String MakeTime;
/*     */   private String p1;
/*     */   private String p2;
/*     */   private String p3;
/*     */   private String p4;
/*     */   public static final int FIELDNUM = 10;
/*     */   private static String[] PK;
/*  45 */   private FDate fDate = new FDate();
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public LNPTransRcorsSchema()
/*     */   {
/*  52 */     this.mErrors = new CErrors();
/*     */ 
/*  54 */     String[] pk = new String[2];
/*  55 */     pk[0] = "EdorNo";
/*  56 */     pk[1] = "serialNo";
/*     */ 
/*  58 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  64 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getEdorNo()
/*     */   {
/*  69 */     if (this.EdorNo != null) this.EdorNo.equals("");
/*     */ 
/*  73 */     return this.EdorNo;
/*     */   }
/*     */ 
/*     */   public void setEdorNo(String aEdorNo) {
/*  77 */     this.EdorNo = aEdorNo;
/*     */   }
/*     */ 
/*     */   public String getserialNo() {
/*  81 */     if (this.serialNo != null) this.serialNo.equals("");
/*     */ 
/*  85 */     return this.serialNo;
/*     */   }
/*     */ 
/*     */   public void setserialNo(String aserialNo) {
/*  89 */     this.serialNo = aserialNo;
/*     */   }
/*     */ 
/*     */   public String getContNo() {
/*  93 */     if (this.ContNo != null) this.ContNo.equals("");
/*     */ 
/*  97 */     return this.ContNo;
/*     */   }
/*     */ 
/*     */   public void setContNo(String aContNo) {
/* 101 */     this.ContNo = aContNo;
/*     */   }
/*     */ 
/*     */   public String getOperator() {
/* 105 */     if (this.Operator != null) this.Operator.equals("");
/*     */ 
/* 109 */     return this.Operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String aOperator) {
/* 113 */     this.Operator = aOperator;
/*     */   }
/*     */ 
/*     */   public String getMakeDate() {
/* 117 */     if (this.MakeDate != null) {
/* 118 */       return this.fDate.getString(this.MakeDate);
/*     */     }
/* 120 */     return null;
/*     */   }
/*     */ 
/*     */   public void setMakeDate(Date aMakeDate) {
/* 124 */     this.MakeDate = aMakeDate;
/*     */   }
/*     */ 
/*     */   public void setMakeDate(String aMakeDate) {
/* 128 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*     */     {
/* 130 */       this.MakeDate = this.fDate.getDate(aMakeDate);
/*     */     }
/*     */     else
/* 133 */       this.MakeDate = null;
/*     */   }
/*     */ 
/*     */   public String getMakeTime()
/*     */   {
/* 138 */     if (this.MakeTime != null) this.MakeTime.equals("");
/*     */ 
/* 142 */     return this.MakeTime;
/*     */   }
/*     */ 
/*     */   public void setMakeTime(String aMakeTime) {
/* 146 */     this.MakeTime = aMakeTime;
/*     */   }
/*     */ 
/*     */   public String getp1() {
/* 150 */     if (this.p1 != null) this.p1.equals("");
/*     */ 
/* 154 */     return this.p1;
/*     */   }
/*     */ 
/*     */   public void setp1(String ap1) {
/* 158 */     this.p1 = ap1;
/*     */   }
/*     */ 
/*     */   public String getp2() {
/* 162 */     if (this.p2 != null) this.p2.equals("");
/*     */ 
/* 166 */     return this.p2;
/*     */   }
/*     */ 
/*     */   public void setp2(String ap2) {
/* 170 */     this.p2 = ap2;
/*     */   }
/*     */ 
/*     */   public String getp3() {
/* 174 */     if (this.p3 != null) this.p3.equals("");
/*     */ 
/* 178 */     return this.p3;
/*     */   }
/*     */ 
/*     */   public void setp3(String ap3) {
/* 182 */     this.p3 = ap3;
/*     */   }
/*     */ 
/*     */   public String getp4() {
/* 186 */     if (this.p4 != null) this.p4.equals("");
/*     */ 
/* 190 */     return this.p4;
/*     */   }
/*     */ 
/*     */   public void setp4(String ap4) {
/* 194 */     this.p4 = ap4;
/*     */   }
/*     */ 
/*     */   public void setSchema(LNPTransRcorsSchema aLNPTransRcorsSchema)
/*     */   {
/* 200 */     this.EdorNo = aLNPTransRcorsSchema.getEdorNo();
/* 201 */     this.serialNo = aLNPTransRcorsSchema.getserialNo();
/* 202 */     this.ContNo = aLNPTransRcorsSchema.getContNo();
/* 203 */     this.Operator = aLNPTransRcorsSchema.getOperator();
/* 204 */     this.MakeDate = this.fDate.getDate(aLNPTransRcorsSchema.getMakeDate());
/* 205 */     this.MakeTime = aLNPTransRcorsSchema.getMakeTime();
/* 206 */     this.p1 = aLNPTransRcorsSchema.getp1();
/* 207 */     this.p2 = aLNPTransRcorsSchema.getp2();
/* 208 */     this.p3 = aLNPTransRcorsSchema.getp3();
/* 209 */     this.p4 = aLNPTransRcorsSchema.getp4();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 218 */       if (rs.getString("EdorNo") == null)
/* 219 */         this.EdorNo = null;
/*     */       else {
/* 221 */         this.EdorNo = rs.getString("EdorNo").trim();
/*     */       }
/* 223 */       if (rs.getString("serialNo") == null)
/* 224 */         this.serialNo = null;
/*     */       else {
/* 226 */         this.serialNo = rs.getString("serialNo").trim();
/*     */       }
/* 228 */       if (rs.getString("ContNo") == null)
/* 229 */         this.ContNo = null;
/*     */       else {
/* 231 */         this.ContNo = rs.getString("ContNo").trim();
/*     */       }
/* 233 */       if (rs.getString("Operator") == null)
/* 234 */         this.Operator = null;
/*     */       else {
/* 236 */         this.Operator = rs.getString("Operator").trim();
/*     */       }
/* 238 */       this.MakeDate = rs.getDate("MakeDate");
/* 239 */       if (rs.getString("MakeTime") == null)
/* 240 */         this.MakeTime = null;
/*     */       else {
/* 242 */         this.MakeTime = rs.getString("MakeTime").trim();
/*     */       }
/* 244 */       if (rs.getString("p1") == null)
/* 245 */         this.p1 = null;
/*     */       else {
/* 247 */         this.p1 = rs.getString("p1").trim();
/*     */       }
/* 249 */       if (rs.getString("p2") == null)
/* 250 */         this.p2 = null;
/*     */       else {
/* 252 */         this.p2 = rs.getString("p2").trim();
/*     */       }
/* 254 */       if (rs.getString("p3") == null)
/* 255 */         this.p3 = null;
/*     */       else {
/* 257 */         this.p3 = rs.getString("p3").trim();
/*     */       }
/* 259 */       if (rs.getString("p4") == null)
/* 260 */         this.p4 = null;
/*     */       else {
/* 262 */         this.p4 = rs.getString("p4").trim();
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 268 */       CError tError = new CError();
/* 269 */       tError.moduleName = "LNPTransRcorsSchema";
/* 270 */       tError.functionName = "setSchema";
/* 271 */       tError.errorMessage = sqle.toString();
/* 272 */       this.mErrors.addOneError(tError);
/*     */ 
/* 274 */       return false;
/*     */     }
/* 276 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPTransRcorsSchema getSchema()
/*     */   {
/* 281 */     LNPTransRcorsSchema aLNPTransRcorsSchema = new LNPTransRcorsSchema();
/* 282 */     aLNPTransRcorsSchema.setSchema(this);
/* 283 */     return aLNPTransRcorsSchema;
/*     */   }
/*     */ 
/*     */   public LNPTransRcorsDB getDB()
/*     */   {
/* 288 */     LNPTransRcorsDB aDBOper = new LNPTransRcorsDB();
/* 289 */     aDBOper.setSchema(this);
/* 290 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 297 */     String strReturn = "";
/* 298 */     strReturn = StrTool.cTrim(StrTool.unicodeToGBK(this.EdorNo)) + "|" + 
/* 299 */       StrTool.cTrim(StrTool.unicodeToGBK(this.serialNo)) + "|" + 
/* 300 */       StrTool.cTrim(StrTool.unicodeToGBK(this.ContNo)) + "|" + 
/* 301 */       StrTool.cTrim(StrTool.unicodeToGBK(this.Operator)) + "|" + 
/* 302 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.MakeDate))) + "|" + 
/* 303 */       StrTool.cTrim(StrTool.unicodeToGBK(this.MakeTime)) + "|" + 
/* 304 */       StrTool.cTrim(StrTool.unicodeToGBK(this.p1)) + "|" + 
/* 305 */       StrTool.cTrim(StrTool.unicodeToGBK(this.p2)) + "|" + 
/* 306 */       StrTool.cTrim(StrTool.unicodeToGBK(this.p3)) + "|" + 
/* 307 */       StrTool.cTrim(StrTool.unicodeToGBK(this.p4));
/* 308 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 316 */       this.EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 317 */       this.serialNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 318 */       this.ContNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 319 */       this.Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 320 */       this.MakeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|"));
/* 321 */       this.MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 322 */       this.p1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 323 */       this.p2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/* 324 */       this.p3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/* 325 */       this.p4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 330 */       CError tError = new CError();
/* 331 */       tError.moduleName = "LNPTransRcorsSchema";
/* 332 */       tError.functionName = "decode";
/* 333 */       tError.errorMessage = ex.toString();
/* 334 */       this.mErrors.addOneError(tError);
/*     */ 
/* 336 */       return false;
/*     */     }
/* 338 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 344 */     String strReturn = "";
/* 345 */     if (FCode.equals("EdorNo"))
/*     */     {
/* 347 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.EdorNo));
/*     */     }
/* 349 */     if (FCode.equals("serialNo"))
/*     */     {
/* 351 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.serialNo));
/*     */     }
/* 353 */     if (FCode.equals("ContNo"))
/*     */     {
/* 355 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ContNo));
/*     */     }
/* 357 */     if (FCode.equals("Operator"))
/*     */     {
/* 359 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.Operator));
/*     */     }
/* 361 */     if (FCode.equals("MakeDate"))
/*     */     {
/* 363 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*     */     }
/* 365 */     if (FCode.equals("MakeTime"))
/*     */     {
/* 367 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.MakeTime));
/*     */     }
/* 369 */     if (FCode.equals("p1"))
/*     */     {
/* 371 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p1));
/*     */     }
/* 373 */     if (FCode.equals("p2"))
/*     */     {
/* 375 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p2));
/*     */     }
/* 377 */     if (FCode.equals("p3"))
/*     */     {
/* 379 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p3));
/*     */     }
/* 381 */     if (FCode.equals("p4"))
/*     */     {
/* 383 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p4));
/*     */     }
/* 385 */     if (strReturn.equals(""))
/*     */     {
/* 387 */       strReturn = "null";
/*     */     }
/*     */ 
/* 390 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 397 */     String strFieldValue = "";
/* 398 */     switch (nFieldIndex) {
/*     */     case 0:
/* 400 */       strFieldValue = StrTool.GBKToUnicode(this.EdorNo);
/* 401 */       break;
/*     */     case 1:
/* 403 */       strFieldValue = StrTool.GBKToUnicode(this.serialNo);
/* 404 */       break;
/*     */     case 2:
/* 406 */       strFieldValue = StrTool.GBKToUnicode(this.ContNo);
/* 407 */       break;
/*     */     case 3:
/* 409 */       strFieldValue = StrTool.GBKToUnicode(this.Operator);
/* 410 */       break;
/*     */     case 4:
/* 412 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/* 413 */       break;
/*     */     case 5:
/* 415 */       strFieldValue = StrTool.GBKToUnicode(this.MakeTime);
/* 416 */       break;
/*     */     case 6:
/* 418 */       strFieldValue = StrTool.GBKToUnicode(this.p1);
/* 419 */       break;
/*     */     case 7:
/* 421 */       strFieldValue = StrTool.GBKToUnicode(this.p2);
/* 422 */       break;
/*     */     case 8:
/* 424 */       strFieldValue = StrTool.GBKToUnicode(this.p3);
/* 425 */       break;
/*     */     case 9:
/* 427 */       strFieldValue = StrTool.GBKToUnicode(this.p4);
/* 428 */       break;
/*     */     default:
/* 430 */       strFieldValue = "";
/*     */     }
/* 432 */     if (strFieldValue.equals("")) {
/* 433 */       strFieldValue = "null";
/*     */     }
/* 435 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 441 */     if (StrTool.cTrim(FCode).equals("")) {
/* 442 */       return false;
/*     */     }
/* 444 */     if (FCode.equals("EdorNo"))
/*     */     {
/* 446 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 448 */         this.EdorNo = FValue.trim();
/*     */       }
/*     */       else
/* 451 */         this.EdorNo = null;
/*     */     }
/* 453 */     if (FCode.equals("serialNo"))
/*     */     {
/* 455 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 457 */         this.serialNo = FValue.trim();
/*     */       }
/*     */       else
/* 460 */         this.serialNo = null;
/*     */     }
/* 462 */     if (FCode.equals("ContNo"))
/*     */     {
/* 464 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 466 */         this.ContNo = FValue.trim();
/*     */       }
/*     */       else
/* 469 */         this.ContNo = null;
/*     */     }
/* 471 */     if (FCode.equals("Operator"))
/*     */     {
/* 473 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 475 */         this.Operator = FValue.trim();
/*     */       }
/*     */       else
/* 478 */         this.Operator = null;
/*     */     }
/* 480 */     if (FCode.equals("MakeDate"))
/*     */     {
/* 482 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 484 */         this.MakeDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 487 */         this.MakeDate = null;
/*     */     }
/* 489 */     if (FCode.equals("MakeTime"))
/*     */     {
/* 491 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 493 */         this.MakeTime = FValue.trim();
/*     */       }
/*     */       else
/* 496 */         this.MakeTime = null;
/*     */     }
/* 498 */     if (FCode.equals("p1"))
/*     */     {
/* 500 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 502 */         this.p1 = FValue.trim();
/*     */       }
/*     */       else
/* 505 */         this.p1 = null;
/*     */     }
/* 507 */     if (FCode.equals("p2"))
/*     */     {
/* 509 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 511 */         this.p2 = FValue.trim();
/*     */       }
/*     */       else
/* 514 */         this.p2 = null;
/*     */     }
/* 516 */     if (FCode.equals("p3"))
/*     */     {
/* 518 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 520 */         this.p3 = FValue.trim();
/*     */       }
/*     */       else
/* 523 */         this.p3 = null;
/*     */     }
/* 525 */     if (FCode.equals("p4"))
/*     */     {
/* 527 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 529 */         this.p4 = FValue.trim();
/*     */       }
/*     */       else
/* 532 */         this.p4 = null;
/*     */     }
/* 534 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 539 */     if (this == otherObject) return true;
/* 540 */     if (otherObject == null) return false;
/* 541 */     if (getClass() != otherObject.getClass()) return false;
/* 542 */     LNPTransRcorsSchema other = (LNPTransRcorsSchema)otherObject;
/* 543 */     return 
/* 544 */       (this.EdorNo.equals(other.getEdorNo())) && 
/* 545 */       (this.serialNo.equals(other.getserialNo())) && 
/* 546 */       (this.ContNo.equals(other.getContNo())) && 
/* 547 */       (this.Operator.equals(other.getOperator())) && 
/* 548 */       (this.fDate.getString(this.MakeDate).equals(other.getMakeDate())) && 
/* 549 */       (this.MakeTime.equals(other.getMakeTime())) && 
/* 550 */       (this.p1.equals(other.getp1())) && 
/* 551 */       (this.p2.equals(other.getp2())) && 
/* 552 */       (this.p3.equals(other.getp3())) && 
/* 553 */       (this.p4.equals(other.getp4()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 559 */     return 10;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 565 */     if (strFieldName.equals("EdorNo")) {
/* 566 */       return 0;
/*     */     }
/* 568 */     if (strFieldName.equals("serialNo")) {
/* 569 */       return 1;
/*     */     }
/* 571 */     if (strFieldName.equals("ContNo")) {
/* 572 */       return 2;
/*     */     }
/* 574 */     if (strFieldName.equals("Operator")) {
/* 575 */       return 3;
/*     */     }
/* 577 */     if (strFieldName.equals("MakeDate")) {
/* 578 */       return 4;
/*     */     }
/* 580 */     if (strFieldName.equals("MakeTime")) {
/* 581 */       return 5;
/*     */     }
/* 583 */     if (strFieldName.equals("p1")) {
/* 584 */       return 6;
/*     */     }
/* 586 */     if (strFieldName.equals("p2")) {
/* 587 */       return 7;
/*     */     }
/* 589 */     if (strFieldName.equals("p3")) {
/* 590 */       return 8;
/*     */     }
/* 592 */     if (strFieldName.equals("p4")) {
/* 593 */       return 9;
/*     */     }
/* 595 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 601 */     String strFieldName = "";
/* 602 */     switch (nFieldIndex) {
/*     */     case 0:
/* 604 */       strFieldName = "EdorNo";
/* 605 */       break;
/*     */     case 1:
/* 607 */       strFieldName = "serialNo";
/* 608 */       break;
/*     */     case 2:
/* 610 */       strFieldName = "ContNo";
/* 611 */       break;
/*     */     case 3:
/* 613 */       strFieldName = "Operator";
/* 614 */       break;
/*     */     case 4:
/* 616 */       strFieldName = "MakeDate";
/* 617 */       break;
/*     */     case 5:
/* 619 */       strFieldName = "MakeTime";
/* 620 */       break;
/*     */     case 6:
/* 622 */       strFieldName = "p1";
/* 623 */       break;
/*     */     case 7:
/* 625 */       strFieldName = "p2";
/* 626 */       break;
/*     */     case 8:
/* 628 */       strFieldName = "p3";
/* 629 */       break;
/*     */     case 9:
/* 631 */       strFieldName = "p4";
/* 632 */       break;
/*     */     default:
/* 634 */       strFieldName = "";
/*     */     }
/* 636 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 642 */     if (strFieldName.equals("EdorNo")) {
/* 643 */       return 0;
/*     */     }
/* 645 */     if (strFieldName.equals("serialNo")) {
/* 646 */       return 0;
/*     */     }
/* 648 */     if (strFieldName.equals("ContNo")) {
/* 649 */       return 0;
/*     */     }
/* 651 */     if (strFieldName.equals("Operator")) {
/* 652 */       return 0;
/*     */     }
/* 654 */     if (strFieldName.equals("MakeDate")) {
/* 655 */       return 1;
/*     */     }
/* 657 */     if (strFieldName.equals("MakeTime")) {
/* 658 */       return 0;
/*     */     }
/* 660 */     if (strFieldName.equals("p1")) {
/* 661 */       return 0;
/*     */     }
/* 663 */     if (strFieldName.equals("p2")) {
/* 664 */       return 0;
/*     */     }
/* 666 */     if (strFieldName.equals("p3")) {
/* 667 */       return 0;
/*     */     }
/* 669 */     if (strFieldName.equals("p4")) {
/* 670 */       return 0;
/*     */     }
/* 672 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 678 */     int nFieldType = -1;
/* 679 */     switch (nFieldIndex) {
/*     */     case 0:
/* 681 */       nFieldType = 0;
/* 682 */       break;
/*     */     case 1:
/* 684 */       nFieldType = 0;
/* 685 */       break;
/*     */     case 2:
/* 687 */       nFieldType = 0;
/* 688 */       break;
/*     */     case 3:
/* 690 */       nFieldType = 0;
/* 691 */       break;
/*     */     case 4:
/* 693 */       nFieldType = 1;
/* 694 */       break;
/*     */     case 5:
/* 696 */       nFieldType = 0;
/* 697 */       break;
/*     */     case 6:
/* 699 */       nFieldType = 0;
/* 700 */       break;
/*     */     case 7:
/* 702 */       nFieldType = 0;
/* 703 */       break;
/*     */     case 8:
/* 705 */       nFieldType = 0;
/* 706 */       break;
/*     */     case 9:
/* 708 */       nFieldType = 0;
/* 709 */       break;
/*     */     default:
/* 711 */       nFieldType = -1;
/*     */     }
/* 713 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPTransRcorsSchema
 * JD-Core Version:    0.6.0
 */