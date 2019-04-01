/*     */ package com.sinosoft.banklns.lis.schema;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPRiskAmountBDB;
/*     */ import com.sinosoft.banklns.lis.pubfun.FDate;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.ChgData;
/*     */ import com.sinosoft.banklns.utility.Schema;
/*     */ import com.sinosoft.banklns.utility.StrTool;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class LNPRiskAmountBSchema
/*     */   implements Schema
/*     */ {
/*     */   private String EdorNo;
/*     */   private String serialNo;
/*     */   private String contno;
/*     */   private String ftype;
/*     */   private double famnt;
/*     */   private String var1;
/*     */   private String var2;
/*     */   private String var3;
/*     */   private String var4;
/*     */   private Date makedate;
/*     */   private String maketime;
/*     */   private Date modifydate;
/*     */   private String modifytime;
/*     */   public static final int FIELDNUM = 13;
/*     */   private static String[] PK;
/*  51 */   private FDate fDate = new FDate();
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public LNPRiskAmountBSchema()
/*     */   {
/*  58 */     this.mErrors = new CErrors();
/*     */ 
/*  60 */     String[] pk = new String[2];
/*  61 */     pk[0] = "EdorNo";
/*  62 */     pk[1] = "serialNo";
/*     */ 
/*  64 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  70 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getEdorNo()
/*     */   {
/*  75 */     if (this.EdorNo != null) this.EdorNo.equals("");
/*     */ 
/*  79 */     return this.EdorNo;
/*     */   }
/*     */ 
/*     */   public void setEdorNo(String aEdorNo) {
/*  83 */     this.EdorNo = aEdorNo;
/*     */   }
/*     */ 
/*     */   public String getserialNo() {
/*  87 */     if (this.serialNo != null) this.serialNo.equals("");
/*     */ 
/*  91 */     return this.serialNo;
/*     */   }
/*     */ 
/*     */   public void setserialNo(String aserialNo) {
/*  95 */     this.serialNo = aserialNo;
/*     */   }
/*     */ 
/*     */   public String getcontno() {
/*  99 */     if (this.contno != null) this.contno.equals("");
/*     */ 
/* 103 */     return this.contno;
/*     */   }
/*     */ 
/*     */   public void setcontno(String acontno) {
/* 107 */     this.contno = acontno;
/*     */   }
/*     */ 
/*     */   public String getftype() {
/* 111 */     if (this.ftype != null) this.ftype.equals("");
/*     */ 
/* 115 */     return this.ftype;
/*     */   }
/*     */ 
/*     */   public void setftype(String aftype) {
/* 119 */     this.ftype = aftype;
/*     */   }
/*     */ 
/*     */   public double getfamnt() {
/* 123 */     return this.famnt;
/*     */   }
/*     */ 
/*     */   public void setfamnt(double afamnt) {
/* 127 */     this.famnt = afamnt;
/*     */   }
/*     */ 
/*     */   public void setfamnt(String afamnt) {
/* 131 */     if ((afamnt != null) && (!afamnt.equals("")))
/*     */     {
/* 133 */       Double tDouble = new Double(afamnt);
/* 134 */       double d = tDouble.doubleValue();
/* 135 */       this.famnt = d;
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getvar1()
/*     */   {
/* 141 */     if (this.var1 != null) this.var1.equals("");
/*     */ 
/* 145 */     return this.var1;
/*     */   }
/*     */ 
/*     */   public void setvar1(String avar1) {
/* 149 */     this.var1 = avar1;
/*     */   }
/*     */ 
/*     */   public String getvar2() {
/* 153 */     if (this.var2 != null) this.var2.equals("");
/*     */ 
/* 157 */     return this.var2;
/*     */   }
/*     */ 
/*     */   public void setvar2(String avar2) {
/* 161 */     this.var2 = avar2;
/*     */   }
/*     */ 
/*     */   public String getvar3() {
/* 165 */     if (this.var3 != null) this.var3.equals("");
/*     */ 
/* 169 */     return this.var3;
/*     */   }
/*     */ 
/*     */   public void setvar3(String avar3) {
/* 173 */     this.var3 = avar3;
/*     */   }
/*     */ 
/*     */   public String getvar4() {
/* 177 */     if (this.var4 != null) this.var4.equals("");
/*     */ 
/* 181 */     return this.var4;
/*     */   }
/*     */ 
/*     */   public void setvar4(String avar4) {
/* 185 */     this.var4 = avar4;
/*     */   }
/*     */ 
/*     */   public String getmakedate() {
/* 189 */     if (this.makedate != null) {
/* 190 */       return this.fDate.getString(this.makedate);
/*     */     }
/* 192 */     return null;
/*     */   }
/*     */ 
/*     */   public void setmakedate(Date amakedate) {
/* 196 */     this.makedate = amakedate;
/*     */   }
/*     */ 
/*     */   public void setmakedate(String amakedate) {
/* 200 */     if ((amakedate != null) && (!amakedate.equals("")))
/*     */     {
/* 202 */       this.makedate = this.fDate.getDate(amakedate);
/*     */     }
/*     */     else
/* 205 */       this.makedate = null;
/*     */   }
/*     */ 
/*     */   public String getmaketime()
/*     */   {
/* 210 */     if (this.maketime != null) this.maketime.equals("");
/*     */ 
/* 214 */     return this.maketime;
/*     */   }
/*     */ 
/*     */   public void setmaketime(String amaketime) {
/* 218 */     this.maketime = amaketime;
/*     */   }
/*     */ 
/*     */   public String getmodifydate() {
/* 222 */     if (this.modifydate != null) {
/* 223 */       return this.fDate.getString(this.modifydate);
/*     */     }
/* 225 */     return null;
/*     */   }
/*     */ 
/*     */   public void setmodifydate(Date amodifydate) {
/* 229 */     this.modifydate = amodifydate;
/*     */   }
/*     */ 
/*     */   public void setmodifydate(String amodifydate) {
/* 233 */     if ((amodifydate != null) && (!amodifydate.equals("")))
/*     */     {
/* 235 */       this.modifydate = this.fDate.getDate(amodifydate);
/*     */     }
/*     */     else
/* 238 */       this.modifydate = null;
/*     */   }
/*     */ 
/*     */   public String getmodifytime()
/*     */   {
/* 243 */     if (this.modifytime != null) this.modifytime.equals("");
/*     */ 
/* 247 */     return this.modifytime;
/*     */   }
/*     */ 
/*     */   public void setmodifytime(String amodifytime) {
/* 251 */     this.modifytime = amodifytime;
/*     */   }
/*     */ 
/*     */   public void setSchema(LNPRiskAmountBSchema aLNPRiskAmountBSchema)
/*     */   {
/* 257 */     this.EdorNo = aLNPRiskAmountBSchema.getEdorNo();
/* 258 */     this.serialNo = aLNPRiskAmountBSchema.getserialNo();
/* 259 */     this.contno = aLNPRiskAmountBSchema.getcontno();
/* 260 */     this.ftype = aLNPRiskAmountBSchema.getftype();
/* 261 */     this.famnt = aLNPRiskAmountBSchema.getfamnt();
/* 262 */     this.var1 = aLNPRiskAmountBSchema.getvar1();
/* 263 */     this.var2 = aLNPRiskAmountBSchema.getvar2();
/* 264 */     this.var3 = aLNPRiskAmountBSchema.getvar3();
/* 265 */     this.var4 = aLNPRiskAmountBSchema.getvar4();
/* 266 */     this.makedate = this.fDate.getDate(aLNPRiskAmountBSchema.getmakedate());
/* 267 */     this.maketime = aLNPRiskAmountBSchema.getmaketime();
/* 268 */     this.modifydate = this.fDate.getDate(aLNPRiskAmountBSchema.getmodifydate());
/* 269 */     this.modifytime = aLNPRiskAmountBSchema.getmodifytime();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 278 */       if (rs.getString("EdorNo") == null)
/* 279 */         this.EdorNo = null;
/*     */       else {
/* 281 */         this.EdorNo = rs.getString("EdorNo").trim();
/*     */       }
/* 283 */       if (rs.getString("serialNo") == null)
/* 284 */         this.serialNo = null;
/*     */       else {
/* 286 */         this.serialNo = rs.getString("serialNo").trim();
/*     */       }
/* 288 */       if (rs.getString("contno") == null)
/* 289 */         this.contno = null;
/*     */       else {
/* 291 */         this.contno = rs.getString("contno").trim();
/*     */       }
/* 293 */       if (rs.getString("ftype") == null)
/* 294 */         this.ftype = null;
/*     */       else {
/* 296 */         this.ftype = rs.getString("ftype").trim();
/*     */       }
/* 298 */       this.famnt = rs.getDouble("famnt");
/* 299 */       if (rs.getString("var1") == null)
/* 300 */         this.var1 = null;
/*     */       else {
/* 302 */         this.var1 = rs.getString("var1").trim();
/*     */       }
/* 304 */       if (rs.getString("var2") == null)
/* 305 */         this.var2 = null;
/*     */       else {
/* 307 */         this.var2 = rs.getString("var2").trim();
/*     */       }
/* 309 */       if (rs.getString("var3") == null)
/* 310 */         this.var3 = null;
/*     */       else {
/* 312 */         this.var3 = rs.getString("var3").trim();
/*     */       }
/* 314 */       if (rs.getString("var4") == null)
/* 315 */         this.var4 = null;
/*     */       else {
/* 317 */         this.var4 = rs.getString("var4").trim();
/*     */       }
/* 319 */       this.makedate = rs.getDate("makedate");
/* 320 */       if (rs.getString("maketime") == null)
/* 321 */         this.maketime = null;
/*     */       else {
/* 323 */         this.maketime = rs.getString("maketime").trim();
/*     */       }
/* 325 */       this.modifydate = rs.getDate("modifydate");
/* 326 */       if (rs.getString("modifytime") == null)
/* 327 */         this.modifytime = null;
/*     */       else {
/* 329 */         this.modifytime = rs.getString("modifytime").trim();
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 335 */       CError tError = new CError();
/* 336 */       tError.moduleName = "LNPRiskAmountBSchema";
/* 337 */       tError.functionName = "setSchema";
/* 338 */       tError.errorMessage = sqle.toString();
/* 339 */       this.mErrors.addOneError(tError);
/*     */ 
/* 341 */       return false;
/*     */     }
/* 343 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPRiskAmountBSchema getSchema()
/*     */   {
/* 348 */     LNPRiskAmountBSchema aLNPRiskAmountBSchema = new LNPRiskAmountBSchema();
/* 349 */     aLNPRiskAmountBSchema.setSchema(this);
/* 350 */     return aLNPRiskAmountBSchema;
/*     */   }
/*     */ 
/*     */   public LNPRiskAmountBDB getDB()
/*     */   {
/* 355 */     LNPRiskAmountBDB aDBOper = new LNPRiskAmountBDB();
/* 356 */     aDBOper.setSchema(this);
/* 357 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 364 */     String strReturn = "";
/* 365 */     strReturn = StrTool.cTrim(StrTool.unicodeToGBK(this.EdorNo)) + "|" + 
/* 366 */       StrTool.cTrim(StrTool.unicodeToGBK(this.serialNo)) + "|" + 
/* 367 */       StrTool.cTrim(StrTool.unicodeToGBK(this.contno)) + "|" + 
/* 368 */       StrTool.cTrim(StrTool.unicodeToGBK(this.ftype)) + "|" + 
/* 369 */       ChgData.chgData(this.famnt) + "|" + 
/* 370 */       StrTool.cTrim(StrTool.unicodeToGBK(this.var1)) + "|" + 
/* 371 */       StrTool.cTrim(StrTool.unicodeToGBK(this.var2)) + "|" + 
/* 372 */       StrTool.cTrim(StrTool.unicodeToGBK(this.var3)) + "|" + 
/* 373 */       StrTool.cTrim(StrTool.unicodeToGBK(this.var4)) + "|" + 
/* 374 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.makedate))) + "|" + 
/* 375 */       StrTool.cTrim(StrTool.unicodeToGBK(this.maketime)) + "|" + 
/* 376 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.modifydate))) + "|" + 
/* 377 */       StrTool.cTrim(StrTool.unicodeToGBK(this.modifytime));
/* 378 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 386 */       this.EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 387 */       this.serialNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 388 */       this.contno = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 389 */       this.ftype = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 390 */       this.famnt = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 5, "|"))).doubleValue();
/* 391 */       this.var1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 392 */       this.var2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 393 */       this.var3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/* 394 */       this.var4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/* 395 */       this.makedate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
/* 396 */       this.maketime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/* 397 */       this.modifydate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|"));
/* 398 */       this.modifytime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 403 */       CError tError = new CError();
/* 404 */       tError.moduleName = "LNPRiskAmountBSchema";
/* 405 */       tError.functionName = "decode";
/* 406 */       tError.errorMessage = ex.toString();
/* 407 */       this.mErrors.addOneError(tError);
/*     */ 
/* 409 */       return false;
/*     */     }
/* 411 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 417 */     String strReturn = "";
/* 418 */     if (FCode.equals("EdorNo"))
/*     */     {
/* 420 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.EdorNo));
/*     */     }
/* 422 */     if (FCode.equals("serialNo"))
/*     */     {
/* 424 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.serialNo));
/*     */     }
/* 426 */     if (FCode.equals("contno"))
/*     */     {
/* 428 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contno));
/*     */     }
/* 430 */     if (FCode.equals("ftype"))
/*     */     {
/* 432 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ftype));
/*     */     }
/* 434 */     if (FCode.equals("famnt"))
/*     */     {
/* 436 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.famnt));
/*     */     }
/* 438 */     if (FCode.equals("var1"))
/*     */     {
/* 440 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.var1));
/*     */     }
/* 442 */     if (FCode.equals("var2"))
/*     */     {
/* 444 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.var2));
/*     */     }
/* 446 */     if (FCode.equals("var3"))
/*     */     {
/* 448 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.var3));
/*     */     }
/* 450 */     if (FCode.equals("var4"))
/*     */     {
/* 452 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.var4));
/*     */     }
/* 454 */     if (FCode.equals("makedate"))
/*     */     {
/* 456 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getmakedate()));
/*     */     }
/* 458 */     if (FCode.equals("maketime"))
/*     */     {
/* 460 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.maketime));
/*     */     }
/* 462 */     if (FCode.equals("modifydate"))
/*     */     {
/* 464 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getmodifydate()));
/*     */     }
/* 466 */     if (FCode.equals("modifytime"))
/*     */     {
/* 468 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifytime));
/*     */     }
/* 470 */     if (strReturn.equals(""))
/*     */     {
/* 472 */       strReturn = "null";
/*     */     }
/*     */ 
/* 475 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 482 */     String strFieldValue = "";
/* 483 */     switch (nFieldIndex) {
/*     */     case 0:
/* 485 */       strFieldValue = StrTool.GBKToUnicode(this.EdorNo);
/* 486 */       break;
/*     */     case 1:
/* 488 */       strFieldValue = StrTool.GBKToUnicode(this.serialNo);
/* 489 */       break;
/*     */     case 2:
/* 491 */       strFieldValue = StrTool.GBKToUnicode(this.contno);
/* 492 */       break;
/*     */     case 3:
/* 494 */       strFieldValue = StrTool.GBKToUnicode(this.ftype);
/* 495 */       break;
/*     */     case 4:
/* 497 */       strFieldValue = String.valueOf(this.famnt);
/* 498 */       break;
/*     */     case 5:
/* 500 */       strFieldValue = StrTool.GBKToUnicode(this.var1);
/* 501 */       break;
/*     */     case 6:
/* 503 */       strFieldValue = StrTool.GBKToUnicode(this.var2);
/* 504 */       break;
/*     */     case 7:
/* 506 */       strFieldValue = StrTool.GBKToUnicode(this.var3);
/* 507 */       break;
/*     */     case 8:
/* 509 */       strFieldValue = StrTool.GBKToUnicode(this.var4);
/* 510 */       break;
/*     */     case 9:
/* 512 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmakedate()));
/* 513 */       break;
/*     */     case 10:
/* 515 */       strFieldValue = StrTool.GBKToUnicode(this.maketime);
/* 516 */       break;
/*     */     case 11:
/* 518 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmodifydate()));
/* 519 */       break;
/*     */     case 12:
/* 521 */       strFieldValue = StrTool.GBKToUnicode(this.modifytime);
/* 522 */       break;
/*     */     default:
/* 524 */       strFieldValue = "";
/*     */     }
/* 526 */     if (strFieldValue.equals("")) {
/* 527 */       strFieldValue = "null";
/*     */     }
/* 529 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 535 */     if (StrTool.cTrim(FCode).equals("")) {
/* 536 */       return false;
/*     */     }
/* 538 */     if (FCode.equals("EdorNo"))
/*     */     {
/* 540 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 542 */         this.EdorNo = FValue.trim();
/*     */       }
/*     */       else
/* 545 */         this.EdorNo = null;
/*     */     }
/* 547 */     if (FCode.equals("serialNo"))
/*     */     {
/* 549 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 551 */         this.serialNo = FValue.trim();
/*     */       }
/*     */       else
/* 554 */         this.serialNo = null;
/*     */     }
/* 556 */     if (FCode.equals("contno"))
/*     */     {
/* 558 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 560 */         this.contno = FValue.trim();
/*     */       }
/*     */       else
/* 563 */         this.contno = null;
/*     */     }
/* 565 */     if (FCode.equals("ftype"))
/*     */     {
/* 567 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 569 */         this.ftype = FValue.trim();
/*     */       }
/*     */       else
/* 572 */         this.ftype = null;
/*     */     }
/* 574 */     if (FCode.equals("famnt"))
/*     */     {
/* 576 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 578 */         Double tDouble = new Double(FValue);
/* 579 */         double d = tDouble.doubleValue();
/* 580 */         this.famnt = d;
/*     */       }
/*     */     }
/* 583 */     if (FCode.equals("var1"))
/*     */     {
/* 585 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 587 */         this.var1 = FValue.trim();
/*     */       }
/*     */       else
/* 590 */         this.var1 = null;
/*     */     }
/* 592 */     if (FCode.equals("var2"))
/*     */     {
/* 594 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 596 */         this.var2 = FValue.trim();
/*     */       }
/*     */       else
/* 599 */         this.var2 = null;
/*     */     }
/* 601 */     if (FCode.equals("var3"))
/*     */     {
/* 603 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 605 */         this.var3 = FValue.trim();
/*     */       }
/*     */       else
/* 608 */         this.var3 = null;
/*     */     }
/* 610 */     if (FCode.equals("var4"))
/*     */     {
/* 612 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 614 */         this.var4 = FValue.trim();
/*     */       }
/*     */       else
/* 617 */         this.var4 = null;
/*     */     }
/* 619 */     if (FCode.equals("makedate"))
/*     */     {
/* 621 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 623 */         this.makedate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 626 */         this.makedate = null;
/*     */     }
/* 628 */     if (FCode.equals("maketime"))
/*     */     {
/* 630 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 632 */         this.maketime = FValue.trim();
/*     */       }
/*     */       else
/* 635 */         this.maketime = null;
/*     */     }
/* 637 */     if (FCode.equals("modifydate"))
/*     */     {
/* 639 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 641 */         this.modifydate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 644 */         this.modifydate = null;
/*     */     }
/* 646 */     if (FCode.equals("modifytime"))
/*     */     {
/* 648 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 650 */         this.modifytime = FValue.trim();
/*     */       }
/*     */       else
/* 653 */         this.modifytime = null;
/*     */     }
/* 655 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 660 */     if (this == otherObject) return true;
/* 661 */     if (otherObject == null) return false;
/* 662 */     if (getClass() != otherObject.getClass()) return false;
/* 663 */     LNPRiskAmountBSchema other = (LNPRiskAmountBSchema)otherObject;
/* 664 */     return 
/* 665 */       (this.EdorNo.equals(other.getEdorNo())) && 
/* 666 */       (this.serialNo.equals(other.getserialNo())) && 
/* 667 */       (this.contno.equals(other.getcontno())) && 
/* 668 */       (this.ftype.equals(other.getftype())) && 
/* 669 */       (this.famnt == other.getfamnt()) && 
/* 670 */       (this.var1.equals(other.getvar1())) && 
/* 671 */       (this.var2.equals(other.getvar2())) && 
/* 672 */       (this.var3.equals(other.getvar3())) && 
/* 673 */       (this.var4.equals(other.getvar4())) && 
/* 674 */       (this.fDate.getString(this.makedate).equals(other.getmakedate())) && 
/* 675 */       (this.maketime.equals(other.getmaketime())) && 
/* 676 */       (this.fDate.getString(this.modifydate).equals(other.getmodifydate())) && 
/* 677 */       (this.modifytime.equals(other.getmodifytime()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 683 */     return 13;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 689 */     if (strFieldName.equals("EdorNo")) {
/* 690 */       return 0;
/*     */     }
/* 692 */     if (strFieldName.equals("serialNo")) {
/* 693 */       return 1;
/*     */     }
/* 695 */     if (strFieldName.equals("contno")) {
/* 696 */       return 2;
/*     */     }
/* 698 */     if (strFieldName.equals("ftype")) {
/* 699 */       return 3;
/*     */     }
/* 701 */     if (strFieldName.equals("famnt")) {
/* 702 */       return 4;
/*     */     }
/* 704 */     if (strFieldName.equals("var1")) {
/* 705 */       return 5;
/*     */     }
/* 707 */     if (strFieldName.equals("var2")) {
/* 708 */       return 6;
/*     */     }
/* 710 */     if (strFieldName.equals("var3")) {
/* 711 */       return 7;
/*     */     }
/* 713 */     if (strFieldName.equals("var4")) {
/* 714 */       return 8;
/*     */     }
/* 716 */     if (strFieldName.equals("makedate")) {
/* 717 */       return 9;
/*     */     }
/* 719 */     if (strFieldName.equals("maketime")) {
/* 720 */       return 10;
/*     */     }
/* 722 */     if (strFieldName.equals("modifydate")) {
/* 723 */       return 11;
/*     */     }
/* 725 */     if (strFieldName.equals("modifytime")) {
/* 726 */       return 12;
/*     */     }
/* 728 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 734 */     String strFieldName = "";
/* 735 */     switch (nFieldIndex) {
/*     */     case 0:
/* 737 */       strFieldName = "EdorNo";
/* 738 */       break;
/*     */     case 1:
/* 740 */       strFieldName = "serialNo";
/* 741 */       break;
/*     */     case 2:
/* 743 */       strFieldName = "contno";
/* 744 */       break;
/*     */     case 3:
/* 746 */       strFieldName = "ftype";
/* 747 */       break;
/*     */     case 4:
/* 749 */       strFieldName = "famnt";
/* 750 */       break;
/*     */     case 5:
/* 752 */       strFieldName = "var1";
/* 753 */       break;
/*     */     case 6:
/* 755 */       strFieldName = "var2";
/* 756 */       break;
/*     */     case 7:
/* 758 */       strFieldName = "var3";
/* 759 */       break;
/*     */     case 8:
/* 761 */       strFieldName = "var4";
/* 762 */       break;
/*     */     case 9:
/* 764 */       strFieldName = "makedate";
/* 765 */       break;
/*     */     case 10:
/* 767 */       strFieldName = "maketime";
/* 768 */       break;
/*     */     case 11:
/* 770 */       strFieldName = "modifydate";
/* 771 */       break;
/*     */     case 12:
/* 773 */       strFieldName = "modifytime";
/* 774 */       break;
/*     */     default:
/* 776 */       strFieldName = "";
/*     */     }
/* 778 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 784 */     if (strFieldName.equals("EdorNo")) {
/* 785 */       return 0;
/*     */     }
/* 787 */     if (strFieldName.equals("serialNo")) {
/* 788 */       return 0;
/*     */     }
/* 790 */     if (strFieldName.equals("contno")) {
/* 791 */       return 0;
/*     */     }
/* 793 */     if (strFieldName.equals("ftype")) {
/* 794 */       return 0;
/*     */     }
/* 796 */     if (strFieldName.equals("famnt")) {
/* 797 */       return 4;
/*     */     }
/* 799 */     if (strFieldName.equals("var1")) {
/* 800 */       return 0;
/*     */     }
/* 802 */     if (strFieldName.equals("var2")) {
/* 803 */       return 0;
/*     */     }
/* 805 */     if (strFieldName.equals("var3")) {
/* 806 */       return 0;
/*     */     }
/* 808 */     if (strFieldName.equals("var4")) {
/* 809 */       return 0;
/*     */     }
/* 811 */     if (strFieldName.equals("makedate")) {
/* 812 */       return 1;
/*     */     }
/* 814 */     if (strFieldName.equals("maketime")) {
/* 815 */       return 0;
/*     */     }
/* 817 */     if (strFieldName.equals("modifydate")) {
/* 818 */       return 1;
/*     */     }
/* 820 */     if (strFieldName.equals("modifytime")) {
/* 821 */       return 0;
/*     */     }
/* 823 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 829 */     int nFieldType = -1;
/* 830 */     switch (nFieldIndex) {
/*     */     case 0:
/* 832 */       nFieldType = 0;
/* 833 */       break;
/*     */     case 1:
/* 835 */       nFieldType = 0;
/* 836 */       break;
/*     */     case 2:
/* 838 */       nFieldType = 0;
/* 839 */       break;
/*     */     case 3:
/* 841 */       nFieldType = 0;
/* 842 */       break;
/*     */     case 4:
/* 844 */       nFieldType = 4;
/* 845 */       break;
/*     */     case 5:
/* 847 */       nFieldType = 0;
/* 848 */       break;
/*     */     case 6:
/* 850 */       nFieldType = 0;
/* 851 */       break;
/*     */     case 7:
/* 853 */       nFieldType = 0;
/* 854 */       break;
/*     */     case 8:
/* 856 */       nFieldType = 0;
/* 857 */       break;
/*     */     case 9:
/* 859 */       nFieldType = 1;
/* 860 */       break;
/*     */     case 10:
/* 862 */       nFieldType = 0;
/* 863 */       break;
/*     */     case 11:
/* 865 */       nFieldType = 1;
/* 866 */       break;
/*     */     case 12:
/* 868 */       nFieldType = 0;
/* 869 */       break;
/*     */     default:
/* 871 */       nFieldType = -1;
/*     */     }
/* 873 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPRiskAmountBSchema
 * JD-Core Version:    0.6.0
 */