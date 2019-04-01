/*     */ package com.sinosoft.banklns.lis.schema;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPRiskAmountDB;
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
/*     */ public class LNPRiskAmountSchema
/*     */   implements Schema
/*     */ {
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
/*     */   public static final int FIELDNUM = 11;
/*     */   private static String[] PK;
/*  47 */   private FDate fDate = new FDate();
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public LNPRiskAmountSchema()
/*     */   {
/*  54 */     this.mErrors = new CErrors();
/*     */ 
/*  56 */     String[] pk = new String[2];
/*  57 */     pk[0] = "contno";
/*  58 */     pk[1] = "ftype";
/*     */ 
/*  60 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  66 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getcontno()
/*     */   {
/*  71 */     if (this.contno != null) this.contno.equals("");
/*     */ 
/*  75 */     return this.contno;
/*     */   }
/*     */ 
/*     */   public void setcontno(String acontno) {
/*  79 */     this.contno = acontno;
/*     */   }
/*     */ 
/*     */   public String getftype() {
/*  83 */     if (this.ftype != null) this.ftype.equals("");
/*     */ 
/*  87 */     return this.ftype;
/*     */   }
/*     */ 
/*     */   public void setftype(String aftype) {
/*  91 */     this.ftype = aftype;
/*     */   }
/*     */ 
/*     */   public double getfamnt() {
/*  95 */     return this.famnt;
/*     */   }
/*     */ 
/*     */   public void setfamnt(double afamnt) {
/*  99 */     this.famnt = afamnt;
/*     */   }
/*     */ 
/*     */   public void setfamnt(String afamnt) {
/* 103 */     if ((afamnt != null) && (!afamnt.equals("")))
/*     */     {
/* 105 */       Double tDouble = new Double(afamnt);
/* 106 */       double d = tDouble.doubleValue();
/* 107 */       this.famnt = d;
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getvar1()
/*     */   {
/* 113 */     if (this.var1 != null) this.var1.equals("");
/*     */ 
/* 117 */     return this.var1;
/*     */   }
/*     */ 
/*     */   public void setvar1(String avar1) {
/* 121 */     this.var1 = avar1;
/*     */   }
/*     */ 
/*     */   public String getvar2() {
/* 125 */     if (this.var2 != null) this.var2.equals("");
/*     */ 
/* 129 */     return this.var2;
/*     */   }
/*     */ 
/*     */   public void setvar2(String avar2) {
/* 133 */     this.var2 = avar2;
/*     */   }
/*     */ 
/*     */   public String getvar3() {
/* 137 */     if (this.var3 != null) this.var3.equals("");
/*     */ 
/* 141 */     return this.var3;
/*     */   }
/*     */ 
/*     */   public void setvar3(String avar3) {
/* 145 */     this.var3 = avar3;
/*     */   }
/*     */ 
/*     */   public String getvar4() {
/* 149 */     if (this.var4 != null) this.var4.equals("");
/*     */ 
/* 153 */     return this.var4;
/*     */   }
/*     */ 
/*     */   public void setvar4(String avar4) {
/* 157 */     this.var4 = avar4;
/*     */   }
/*     */ 
/*     */   public String getmakedate() {
/* 161 */     if (this.makedate != null) {
/* 162 */       return this.fDate.getString(this.makedate);
/*     */     }
/* 164 */     return null;
/*     */   }
/*     */ 
/*     */   public void setmakedate(Date amakedate) {
/* 168 */     this.makedate = amakedate;
/*     */   }
/*     */ 
/*     */   public void setmakedate(String amakedate) {
/* 172 */     if ((amakedate != null) && (!amakedate.equals("")))
/*     */     {
/* 174 */       this.makedate = this.fDate.getDate(amakedate);
/*     */     }
/*     */     else
/* 177 */       this.makedate = null;
/*     */   }
/*     */ 
/*     */   public String getmaketime()
/*     */   {
/* 182 */     if (this.maketime != null) this.maketime.equals("");
/*     */ 
/* 186 */     return this.maketime;
/*     */   }
/*     */ 
/*     */   public void setmaketime(String amaketime) {
/* 190 */     this.maketime = amaketime;
/*     */   }
/*     */ 
/*     */   public String getmodifydate() {
/* 194 */     if (this.modifydate != null) {
/* 195 */       return this.fDate.getString(this.modifydate);
/*     */     }
/* 197 */     return null;
/*     */   }
/*     */ 
/*     */   public void setmodifydate(Date amodifydate) {
/* 201 */     this.modifydate = amodifydate;
/*     */   }
/*     */ 
/*     */   public void setmodifydate(String amodifydate) {
/* 205 */     if ((amodifydate != null) && (!amodifydate.equals("")))
/*     */     {
/* 207 */       this.modifydate = this.fDate.getDate(amodifydate);
/*     */     }
/*     */     else
/* 210 */       this.modifydate = null;
/*     */   }
/*     */ 
/*     */   public String getmodifytime()
/*     */   {
/* 215 */     if (this.modifytime != null) this.modifytime.equals("");
/*     */ 
/* 219 */     return this.modifytime;
/*     */   }
/*     */ 
/*     */   public void setmodifytime(String amodifytime) {
/* 223 */     this.modifytime = amodifytime;
/*     */   }
/*     */ 
/*     */   public void setSchema(LNPRiskAmountSchema aLNPRiskAmountSchema)
/*     */   {
/* 229 */     this.contno = aLNPRiskAmountSchema.getcontno();
/* 230 */     this.ftype = aLNPRiskAmountSchema.getftype();
/* 231 */     this.famnt = aLNPRiskAmountSchema.getfamnt();
/* 232 */     this.var1 = aLNPRiskAmountSchema.getvar1();
/* 233 */     this.var2 = aLNPRiskAmountSchema.getvar2();
/* 234 */     this.var3 = aLNPRiskAmountSchema.getvar3();
/* 235 */     this.var4 = aLNPRiskAmountSchema.getvar4();
/* 236 */     this.makedate = this.fDate.getDate(aLNPRiskAmountSchema.getmakedate());
/* 237 */     this.maketime = aLNPRiskAmountSchema.getmaketime();
/* 238 */     this.modifydate = this.fDate.getDate(aLNPRiskAmountSchema.getmodifydate());
/* 239 */     this.modifytime = aLNPRiskAmountSchema.getmodifytime();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 248 */       if (rs.getString("contno") == null)
/* 249 */         this.contno = null;
/*     */       else {
/* 251 */         this.contno = rs.getString("contno").trim();
/*     */       }
/* 253 */       if (rs.getString("ftype") == null)
/* 254 */         this.ftype = null;
/*     */       else {
/* 256 */         this.ftype = rs.getString("ftype").trim();
/*     */       }
/* 258 */       this.famnt = rs.getDouble("famnt");
/* 259 */       if (rs.getString("var1") == null)
/* 260 */         this.var1 = null;
/*     */       else {
/* 262 */         this.var1 = rs.getString("var1").trim();
/*     */       }
/* 264 */       if (rs.getString("var2") == null)
/* 265 */         this.var2 = null;
/*     */       else {
/* 267 */         this.var2 = rs.getString("var2").trim();
/*     */       }
/* 269 */       if (rs.getString("var3") == null)
/* 270 */         this.var3 = null;
/*     */       else {
/* 272 */         this.var3 = rs.getString("var3").trim();
/*     */       }
/* 274 */       if (rs.getString("var4") == null)
/* 275 */         this.var4 = null;
/*     */       else {
/* 277 */         this.var4 = rs.getString("var4").trim();
/*     */       }
/* 279 */       this.makedate = rs.getDate("makedate");
/* 280 */       if (rs.getString("maketime") == null)
/* 281 */         this.maketime = null;
/*     */       else {
/* 283 */         this.maketime = rs.getString("maketime").trim();
/*     */       }
/* 285 */       this.modifydate = rs.getDate("modifydate");
/* 286 */       if (rs.getString("modifytime") == null)
/* 287 */         this.modifytime = null;
/*     */       else {
/* 289 */         this.modifytime = rs.getString("modifytime").trim();
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 295 */       CError tError = new CError();
/* 296 */       tError.moduleName = "LNPRiskAmountSchema";
/* 297 */       tError.functionName = "setSchema";
/* 298 */       tError.errorMessage = sqle.toString();
/* 299 */       this.mErrors.addOneError(tError);
/*     */ 
/* 301 */       return false;
/*     */     }
/* 303 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPRiskAmountSchema getSchema()
/*     */   {
/* 308 */     LNPRiskAmountSchema aLNPRiskAmountSchema = new LNPRiskAmountSchema();
/* 309 */     aLNPRiskAmountSchema.setSchema(this);
/* 310 */     return aLNPRiskAmountSchema;
/*     */   }
/*     */ 
/*     */   public LNPRiskAmountDB getDB()
/*     */   {
/* 315 */     LNPRiskAmountDB aDBOper = new LNPRiskAmountDB();
/* 316 */     aDBOper.setSchema(this);
/* 317 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 324 */     String strReturn = "";
/* 325 */     strReturn = StrTool.cTrim(StrTool.unicodeToGBK(this.contno)) + "|" + 
/* 326 */       StrTool.cTrim(StrTool.unicodeToGBK(this.ftype)) + "|" + 
/* 327 */       ChgData.chgData(this.famnt) + "|" + 
/* 328 */       StrTool.cTrim(StrTool.unicodeToGBK(this.var1)) + "|" + 
/* 329 */       StrTool.cTrim(StrTool.unicodeToGBK(this.var2)) + "|" + 
/* 330 */       StrTool.cTrim(StrTool.unicodeToGBK(this.var3)) + "|" + 
/* 331 */       StrTool.cTrim(StrTool.unicodeToGBK(this.var4)) + "|" + 
/* 332 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.makedate))) + "|" + 
/* 333 */       StrTool.cTrim(StrTool.unicodeToGBK(this.maketime)) + "|" + 
/* 334 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.modifydate))) + "|" + 
/* 335 */       StrTool.cTrim(StrTool.unicodeToGBK(this.modifytime));
/* 336 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 344 */       this.contno = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 345 */       this.ftype = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 346 */       this.famnt = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 3, "|"))).doubleValue();
/* 347 */       this.var1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 348 */       this.var2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 349 */       this.var3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 350 */       this.var4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 351 */       this.makedate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|"));
/* 352 */       this.maketime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/* 353 */       this.modifydate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
/* 354 */       this.modifytime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 359 */       CError tError = new CError();
/* 360 */       tError.moduleName = "LNPRiskAmountSchema";
/* 361 */       tError.functionName = "decode";
/* 362 */       tError.errorMessage = ex.toString();
/* 363 */       this.mErrors.addOneError(tError);
/*     */ 
/* 365 */       return false;
/*     */     }
/* 367 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 373 */     String strReturn = "";
/* 374 */     if (FCode.equals("contno"))
/*     */     {
/* 376 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contno));
/*     */     }
/* 378 */     if (FCode.equals("ftype"))
/*     */     {
/* 380 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.ftype));
/*     */     }
/* 382 */     if (FCode.equals("famnt"))
/*     */     {
/* 384 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.famnt));
/*     */     }
/* 386 */     if (FCode.equals("var1"))
/*     */     {
/* 388 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.var1));
/*     */     }
/* 390 */     if (FCode.equals("var2"))
/*     */     {
/* 392 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.var2));
/*     */     }
/* 394 */     if (FCode.equals("var3"))
/*     */     {
/* 396 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.var3));
/*     */     }
/* 398 */     if (FCode.equals("var4"))
/*     */     {
/* 400 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.var4));
/*     */     }
/* 402 */     if (FCode.equals("makedate"))
/*     */     {
/* 404 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getmakedate()));
/*     */     }
/* 406 */     if (FCode.equals("maketime"))
/*     */     {
/* 408 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.maketime));
/*     */     }
/* 410 */     if (FCode.equals("modifydate"))
/*     */     {
/* 412 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getmodifydate()));
/*     */     }
/* 414 */     if (FCode.equals("modifytime"))
/*     */     {
/* 416 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifytime));
/*     */     }
/* 418 */     if (strReturn.equals(""))
/*     */     {
/* 420 */       strReturn = "null";
/*     */     }
/*     */ 
/* 423 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 430 */     String strFieldValue = "";
/* 431 */     switch (nFieldIndex) {
/*     */     case 0:
/* 433 */       strFieldValue = StrTool.GBKToUnicode(this.contno);
/* 434 */       break;
/*     */     case 1:
/* 436 */       strFieldValue = StrTool.GBKToUnicode(this.ftype);
/* 437 */       break;
/*     */     case 2:
/* 439 */       strFieldValue = String.valueOf(this.famnt);
/* 440 */       break;
/*     */     case 3:
/* 442 */       strFieldValue = StrTool.GBKToUnicode(this.var1);
/* 443 */       break;
/*     */     case 4:
/* 445 */       strFieldValue = StrTool.GBKToUnicode(this.var2);
/* 446 */       break;
/*     */     case 5:
/* 448 */       strFieldValue = StrTool.GBKToUnicode(this.var3);
/* 449 */       break;
/*     */     case 6:
/* 451 */       strFieldValue = StrTool.GBKToUnicode(this.var4);
/* 452 */       break;
/*     */     case 7:
/* 454 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmakedate()));
/* 455 */       break;
/*     */     case 8:
/* 457 */       strFieldValue = StrTool.GBKToUnicode(this.maketime);
/* 458 */       break;
/*     */     case 9:
/* 460 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmodifydate()));
/* 461 */       break;
/*     */     case 10:
/* 463 */       strFieldValue = StrTool.GBKToUnicode(this.modifytime);
/* 464 */       break;
/*     */     default:
/* 466 */       strFieldValue = "";
/*     */     }
/* 468 */     if (strFieldValue.equals("")) {
/* 469 */       strFieldValue = "null";
/*     */     }
/* 471 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 477 */     if (StrTool.cTrim(FCode).equals("")) {
/* 478 */       return false;
/*     */     }
/* 480 */     if (FCode.equals("contno"))
/*     */     {
/* 482 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 484 */         this.contno = FValue.trim();
/*     */       }
/*     */       else
/* 487 */         this.contno = null;
/*     */     }
/* 489 */     if (FCode.equals("ftype"))
/*     */     {
/* 491 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 493 */         this.ftype = FValue.trim();
/*     */       }
/*     */       else
/* 496 */         this.ftype = null;
/*     */     }
/* 498 */     if (FCode.equals("famnt"))
/*     */     {
/* 500 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 502 */         Double tDouble = new Double(FValue);
/* 503 */         double d = tDouble.doubleValue();
/* 504 */         this.famnt = d;
/*     */       }
/*     */     }
/* 507 */     if (FCode.equals("var1"))
/*     */     {
/* 509 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 511 */         this.var1 = FValue.trim();
/*     */       }
/*     */       else
/* 514 */         this.var1 = null;
/*     */     }
/* 516 */     if (FCode.equals("var2"))
/*     */     {
/* 518 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 520 */         this.var2 = FValue.trim();
/*     */       }
/*     */       else
/* 523 */         this.var2 = null;
/*     */     }
/* 525 */     if (FCode.equals("var3"))
/*     */     {
/* 527 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 529 */         this.var3 = FValue.trim();
/*     */       }
/*     */       else
/* 532 */         this.var3 = null;
/*     */     }
/* 534 */     if (FCode.equals("var4"))
/*     */     {
/* 536 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 538 */         this.var4 = FValue.trim();
/*     */       }
/*     */       else
/* 541 */         this.var4 = null;
/*     */     }
/* 543 */     if (FCode.equals("makedate"))
/*     */     {
/* 545 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 547 */         this.makedate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 550 */         this.makedate = null;
/*     */     }
/* 552 */     if (FCode.equals("maketime"))
/*     */     {
/* 554 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 556 */         this.maketime = FValue.trim();
/*     */       }
/*     */       else
/* 559 */         this.maketime = null;
/*     */     }
/* 561 */     if (FCode.equals("modifydate"))
/*     */     {
/* 563 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 565 */         this.modifydate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 568 */         this.modifydate = null;
/*     */     }
/* 570 */     if (FCode.equals("modifytime"))
/*     */     {
/* 572 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 574 */         this.modifytime = FValue.trim();
/*     */       }
/*     */       else
/* 577 */         this.modifytime = null;
/*     */     }
/* 579 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 584 */     if (this == otherObject) return true;
/* 585 */     if (otherObject == null) return false;
/* 586 */     if (getClass() != otherObject.getClass()) return false;
/* 587 */     LNPRiskAmountSchema other = (LNPRiskAmountSchema)otherObject;
/* 588 */     return 
/* 589 */       (this.contno.equals(other.getcontno())) && 
/* 590 */       (this.ftype.equals(other.getftype())) && 
/* 591 */       (this.famnt == other.getfamnt()) && 
/* 592 */       (this.var1.equals(other.getvar1())) && 
/* 593 */       (this.var2.equals(other.getvar2())) && 
/* 594 */       (this.var3.equals(other.getvar3())) && 
/* 595 */       (this.var4.equals(other.getvar4())) && 
/* 596 */       (this.fDate.getString(this.makedate).equals(other.getmakedate())) && 
/* 597 */       (this.maketime.equals(other.getmaketime())) && 
/* 598 */       (this.fDate.getString(this.modifydate).equals(other.getmodifydate())) && 
/* 599 */       (this.modifytime.equals(other.getmodifytime()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 605 */     return 11;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 611 */     if (strFieldName.equals("contno")) {
/* 612 */       return 0;
/*     */     }
/* 614 */     if (strFieldName.equals("ftype")) {
/* 615 */       return 1;
/*     */     }
/* 617 */     if (strFieldName.equals("famnt")) {
/* 618 */       return 2;
/*     */     }
/* 620 */     if (strFieldName.equals("var1")) {
/* 621 */       return 3;
/*     */     }
/* 623 */     if (strFieldName.equals("var2")) {
/* 624 */       return 4;
/*     */     }
/* 626 */     if (strFieldName.equals("var3")) {
/* 627 */       return 5;
/*     */     }
/* 629 */     if (strFieldName.equals("var4")) {
/* 630 */       return 6;
/*     */     }
/* 632 */     if (strFieldName.equals("makedate")) {
/* 633 */       return 7;
/*     */     }
/* 635 */     if (strFieldName.equals("maketime")) {
/* 636 */       return 8;
/*     */     }
/* 638 */     if (strFieldName.equals("modifydate")) {
/* 639 */       return 9;
/*     */     }
/* 641 */     if (strFieldName.equals("modifytime")) {
/* 642 */       return 10;
/*     */     }
/* 644 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 650 */     String strFieldName = "";
/* 651 */     switch (nFieldIndex) {
/*     */     case 0:
/* 653 */       strFieldName = "contno";
/* 654 */       break;
/*     */     case 1:
/* 656 */       strFieldName = "ftype";
/* 657 */       break;
/*     */     case 2:
/* 659 */       strFieldName = "famnt";
/* 660 */       break;
/*     */     case 3:
/* 662 */       strFieldName = "var1";
/* 663 */       break;
/*     */     case 4:
/* 665 */       strFieldName = "var2";
/* 666 */       break;
/*     */     case 5:
/* 668 */       strFieldName = "var3";
/* 669 */       break;
/*     */     case 6:
/* 671 */       strFieldName = "var4";
/* 672 */       break;
/*     */     case 7:
/* 674 */       strFieldName = "makedate";
/* 675 */       break;
/*     */     case 8:
/* 677 */       strFieldName = "maketime";
/* 678 */       break;
/*     */     case 9:
/* 680 */       strFieldName = "modifydate";
/* 681 */       break;
/*     */     case 10:
/* 683 */       strFieldName = "modifytime";
/* 684 */       break;
/*     */     default:
/* 686 */       strFieldName = "";
/*     */     }
/* 688 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 694 */     if (strFieldName.equals("contno")) {
/* 695 */       return 0;
/*     */     }
/* 697 */     if (strFieldName.equals("ftype")) {
/* 698 */       return 0;
/*     */     }
/* 700 */     if (strFieldName.equals("famnt")) {
/* 701 */       return 4;
/*     */     }
/* 703 */     if (strFieldName.equals("var1")) {
/* 704 */       return 0;
/*     */     }
/* 706 */     if (strFieldName.equals("var2")) {
/* 707 */       return 0;
/*     */     }
/* 709 */     if (strFieldName.equals("var3")) {
/* 710 */       return 0;
/*     */     }
/* 712 */     if (strFieldName.equals("var4")) {
/* 713 */       return 0;
/*     */     }
/* 715 */     if (strFieldName.equals("makedate")) {
/* 716 */       return 1;
/*     */     }
/* 718 */     if (strFieldName.equals("maketime")) {
/* 719 */       return 0;
/*     */     }
/* 721 */     if (strFieldName.equals("modifydate")) {
/* 722 */       return 1;
/*     */     }
/* 724 */     if (strFieldName.equals("modifytime")) {
/* 725 */       return 0;
/*     */     }
/* 727 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 733 */     int nFieldType = -1;
/* 734 */     switch (nFieldIndex) {
/*     */     case 0:
/* 736 */       nFieldType = 0;
/* 737 */       break;
/*     */     case 1:
/* 739 */       nFieldType = 0;
/* 740 */       break;
/*     */     case 2:
/* 742 */       nFieldType = 4;
/* 743 */       break;
/*     */     case 3:
/* 745 */       nFieldType = 0;
/* 746 */       break;
/*     */     case 4:
/* 748 */       nFieldType = 0;
/* 749 */       break;
/*     */     case 5:
/* 751 */       nFieldType = 0;
/* 752 */       break;
/*     */     case 6:
/* 754 */       nFieldType = 0;
/* 755 */       break;
/*     */     case 7:
/* 757 */       nFieldType = 1;
/* 758 */       break;
/*     */     case 8:
/* 760 */       nFieldType = 0;
/* 761 */       break;
/*     */     case 9:
/* 763 */       nFieldType = 1;
/* 764 */       break;
/*     */     case 10:
/* 766 */       nFieldType = 0;
/* 767 */       break;
/*     */     default:
/* 769 */       nFieldType = -1;
/*     */     }
/* 771 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPRiskAmountSchema
 * JD-Core Version:    0.6.0
 */