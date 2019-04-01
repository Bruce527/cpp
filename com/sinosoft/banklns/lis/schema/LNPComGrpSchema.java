/*     */ package com.sinosoft.banklns.lis.schema;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPComGrpDB;
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
/*     */ public class LNPComGrpSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String comGrpCode;
/*     */   private String comGrpName;
/*     */   private String comGrpDescription;
/*     */   private String comSign;
/*     */   private String comGrpType;
/*     */   private String operator;
/*     */   private Date makeDate;
/*     */   private String makeTime;
/*     */   public static final int FIELDNUM = 8;
/*     */   private static String[] PK;
/*  43 */   private FDate fDate = new FDate();
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public LNPComGrpSchema()
/*     */   {
/*  50 */     this.mErrors = new CErrors();
/*     */ 
/*  52 */     String[] pk = new String[1];
/*  53 */     pk[0] = "ComGrpCode";
/*     */ 
/*  55 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  62 */     LNPComGrpSchema cloned = (LNPComGrpSchema)super.clone();
/*  63 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  64 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  65 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  71 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getComGrpCode()
/*     */   {
/*  76 */     return this.comGrpCode;
/*     */   }
/*     */ 
/*     */   public void setComGrpCode(String aComGrpCode) {
/*  80 */     this.comGrpCode = aComGrpCode;
/*     */   }
/*     */ 
/*     */   public String getComGrpName() {
/*  84 */     return this.comGrpName;
/*     */   }
/*     */ 
/*     */   public void setComGrpName(String aComGrpName) {
/*  88 */     this.comGrpName = aComGrpName;
/*     */   }
/*     */ 
/*     */   public String getComGrpDescription() {
/*  92 */     return this.comGrpDescription;
/*     */   }
/*     */ 
/*     */   public void setComGrpDescription(String aComGrpDescription) {
/*  96 */     this.comGrpDescription = aComGrpDescription;
/*     */   }
/*     */ 
/*     */   public String getComSign() {
/* 100 */     return this.comSign;
/*     */   }
/*     */ 
/*     */   public void setComSign(String aComSign) {
/* 104 */     this.comSign = aComSign;
/*     */   }
/*     */ 
/*     */   public String getComGrpType() {
/* 108 */     return this.comGrpType;
/*     */   }
/*     */ 
/*     */   public void setComGrpType(String aComGrpType) {
/* 112 */     this.comGrpType = aComGrpType;
/*     */   }
/*     */ 
/*     */   public String getOperator() {
/* 116 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String aOperator) {
/* 120 */     this.operator = aOperator;
/*     */   }
/*     */ 
/*     */   public String getMakeDate() {
/* 124 */     if (this.makeDate != null) {
/* 125 */       return this.fDate.getString(this.makeDate);
/*     */     }
/* 127 */     return null;
/*     */   }
/*     */ 
/*     */   public void setMakeDate(Date aMakeDate) {
/* 131 */     this.makeDate = aMakeDate;
/*     */   }
/*     */ 
/*     */   public void setMakeDate(String aMakeDate) {
/* 135 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*     */     {
/* 137 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*     */     }
/*     */     else
/* 140 */       this.makeDate = null;
/*     */   }
/*     */ 
/*     */   public String getMakeTime()
/*     */   {
/* 145 */     return this.makeTime;
/*     */   }
/*     */ 
/*     */   public void setMakeTime(String aMakeTime) {
/* 149 */     this.makeTime = aMakeTime;
/*     */   }
/*     */ 
/*     */   public void setSchema(LNPComGrpSchema aLNPComGrpSchema)
/*     */   {
/* 155 */     this.comGrpCode = aLNPComGrpSchema.getComGrpCode();
/* 156 */     this.comGrpName = aLNPComGrpSchema.getComGrpName();
/* 157 */     this.comGrpDescription = aLNPComGrpSchema.getComGrpDescription();
/* 158 */     this.comSign = aLNPComGrpSchema.getComSign();
/* 159 */     this.comGrpType = aLNPComGrpSchema.getComGrpType();
/* 160 */     this.operator = aLNPComGrpSchema.getOperator();
/* 161 */     this.makeDate = this.fDate.getDate(aLNPComGrpSchema.getMakeDate());
/* 162 */     this.makeTime = aLNPComGrpSchema.getMakeTime();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 171 */       if (rs.getString("ComGrpCode") == null)
/* 172 */         this.comGrpCode = null;
/*     */       else {
/* 174 */         this.comGrpCode = rs.getString("ComGrpCode").trim();
/*     */       }
/* 176 */       if (rs.getString("ComGrpName") == null)
/* 177 */         this.comGrpName = null;
/*     */       else {
/* 179 */         this.comGrpName = rs.getString("ComGrpName").trim();
/*     */       }
/* 181 */       if (rs.getString("ComGrpDescription") == null)
/* 182 */         this.comGrpDescription = null;
/*     */       else {
/* 184 */         this.comGrpDescription = rs.getString("ComGrpDescription").trim();
/*     */       }
/* 186 */       if (rs.getString("ComSign") == null)
/* 187 */         this.comSign = null;
/*     */       else {
/* 189 */         this.comSign = rs.getString("ComSign").trim();
/*     */       }
/* 191 */       if (rs.getString("ComGrpType") == null)
/* 192 */         this.comGrpType = null;
/*     */       else {
/* 194 */         this.comGrpType = rs.getString("ComGrpType").trim();
/*     */       }
/* 196 */       if (rs.getString("Operator") == null)
/* 197 */         this.operator = null;
/*     */       else {
/* 199 */         this.operator = rs.getString("Operator").trim();
/*     */       }
/* 201 */       this.makeDate = rs.getDate("MakeDate");
/* 202 */       if (rs.getString("MakeTime") == null)
/* 203 */         this.makeTime = null;
/*     */       else {
/* 205 */         this.makeTime = rs.getString("MakeTime").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 210 */       System.out.println("\u93C1\u7248\u5D41\u6434\u64B2\u8151\u9428\u51E9NPComGrp\u741B\u3125\u74E7\u5A08\u5178\u91DC\u93C1\u677F\u62F0Schema\u6D93\uE160\u6B91\u701B\u6941\uE18C\u6D93\uE045\u669F\u6D93\u5D84\u7AF4\u9477\u8FBE\u7D1D\u93B4\u682C\uFFFD\u546E\u58BD\u741B\u5B92b.executeQuery\u93CC\u30E8\uE1D7\u93C3\u8235\u75C5\u93C8\u5909\u5A07\u9422\u256Felect * from tables");
/*     */ 
/* 212 */       CError tError = new CError();
/* 213 */       tError.moduleName = "LNPComGrpSchema";
/* 214 */       tError.functionName = "setSchema";
/* 215 */       tError.errorMessage = sqle.toString();
/* 216 */       this.mErrors.addOneError(tError);
/* 217 */       return false;
/*     */     }
/* 219 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPComGrpSchema getSchema()
/*     */   {
/* 224 */     LNPComGrpSchema aLNPComGrpSchema = new LNPComGrpSchema();
/* 225 */     aLNPComGrpSchema.setSchema(this);
/* 226 */     return aLNPComGrpSchema;
/*     */   }
/*     */ 
/*     */   public LNPComGrpDB getDB()
/*     */   {
/* 231 */     LNPComGrpDB aDBOper = new LNPComGrpDB();
/* 232 */     aDBOper.setSchema(this);
/* 233 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 240 */     StringBuffer strReturn = new StringBuffer(256);
/* 241 */     strReturn.append(StrTool.cTrim(this.comGrpCode)); strReturn.append("|");
/* 242 */     strReturn.append(StrTool.cTrim(this.comGrpName)); strReturn.append("|");
/* 243 */     strReturn.append(StrTool.cTrim(this.comGrpDescription)); strReturn.append("|");
/* 244 */     strReturn.append(StrTool.cTrim(this.comSign)); strReturn.append("|");
/* 245 */     strReturn.append(StrTool.cTrim(this.comGrpType)); strReturn.append("|");
/* 246 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/* 247 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/* 248 */     strReturn.append(StrTool.cTrim(this.makeTime));
/* 249 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 257 */       this.comGrpCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 258 */       this.comGrpName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 259 */       this.comGrpDescription = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 260 */       this.comSign = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 261 */       this.comGrpType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 262 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 263 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|"));
/* 264 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 269 */       CError tError = new CError();
/* 270 */       tError.moduleName = "LNPComGrpSchema";
/* 271 */       tError.functionName = "decode";
/* 272 */       tError.errorMessage = ex.toString();
/* 273 */       this.mErrors.addOneError(tError);
/*     */ 
/* 275 */       return false;
/*     */     }
/* 277 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 283 */     String strReturn = "";
/* 284 */     if (FCode.equalsIgnoreCase("comGrpCode"))
/*     */     {
/* 286 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.comGrpCode));
/*     */     }
/* 288 */     if (FCode.equalsIgnoreCase("comGrpName"))
/*     */     {
/* 290 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.comGrpName));
/*     */     }
/* 292 */     if (FCode.equalsIgnoreCase("comGrpDescription"))
/*     */     {
/* 294 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.comGrpDescription));
/*     */     }
/* 296 */     if (FCode.equalsIgnoreCase("comSign"))
/*     */     {
/* 298 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.comSign));
/*     */     }
/* 300 */     if (FCode.equalsIgnoreCase("comGrpType"))
/*     */     {
/* 302 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.comGrpType));
/*     */     }
/* 304 */     if (FCode.equalsIgnoreCase("operator"))
/*     */     {
/* 306 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*     */     }
/* 308 */     if (FCode.equalsIgnoreCase("makeDate"))
/*     */     {
/* 310 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*     */     }
/* 312 */     if (FCode.equalsIgnoreCase("makeTime"))
/*     */     {
/* 314 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*     */     }
/* 316 */     if (strReturn.equals(""))
/*     */     {
/* 318 */       strReturn = "null";
/*     */     }
/*     */ 
/* 321 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 328 */     String strFieldValue = "";
/* 329 */     switch (nFieldIndex) {
/*     */     case 0:
/* 331 */       strFieldValue = StrTool.GBKToUnicode(this.comGrpCode);
/* 332 */       break;
/*     */     case 1:
/* 334 */       strFieldValue = StrTool.GBKToUnicode(this.comGrpName);
/* 335 */       break;
/*     */     case 2:
/* 337 */       strFieldValue = StrTool.GBKToUnicode(this.comGrpDescription);
/* 338 */       break;
/*     */     case 3:
/* 340 */       strFieldValue = StrTool.GBKToUnicode(this.comSign);
/* 341 */       break;
/*     */     case 4:
/* 343 */       strFieldValue = StrTool.GBKToUnicode(this.comGrpType);
/* 344 */       break;
/*     */     case 5:
/* 346 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 347 */       break;
/*     */     case 6:
/* 349 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/* 350 */       break;
/*     */     case 7:
/* 352 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 353 */       break;
/*     */     default:
/* 355 */       strFieldValue = "";
/*     */     }
/* 357 */     if (strFieldValue.equals("")) {
/* 358 */       strFieldValue = "null";
/*     */     }
/* 360 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 366 */     if (StrTool.cTrim(FCode).equals("")) {
/* 367 */       return false;
/*     */     }
/* 369 */     if (FCode.equalsIgnoreCase("comGrpCode"))
/*     */     {
/* 371 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 373 */         this.comGrpCode = FValue.trim();
/*     */       }
/*     */       else
/* 376 */         this.comGrpCode = null;
/*     */     }
/* 378 */     if (FCode.equalsIgnoreCase("comGrpName"))
/*     */     {
/* 380 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 382 */         this.comGrpName = FValue.trim();
/*     */       }
/*     */       else
/* 385 */         this.comGrpName = null;
/*     */     }
/* 387 */     if (FCode.equalsIgnoreCase("comGrpDescription"))
/*     */     {
/* 389 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 391 */         this.comGrpDescription = FValue.trim();
/*     */       }
/*     */       else
/* 394 */         this.comGrpDescription = null;
/*     */     }
/* 396 */     if (FCode.equalsIgnoreCase("comSign"))
/*     */     {
/* 398 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 400 */         this.comSign = FValue.trim();
/*     */       }
/*     */       else
/* 403 */         this.comSign = null;
/*     */     }
/* 405 */     if (FCode.equalsIgnoreCase("comGrpType"))
/*     */     {
/* 407 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 409 */         this.comGrpType = FValue.trim();
/*     */       }
/*     */       else
/* 412 */         this.comGrpType = null;
/*     */     }
/* 414 */     if (FCode.equalsIgnoreCase("operator"))
/*     */     {
/* 416 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 418 */         this.operator = FValue.trim();
/*     */       }
/*     */       else
/* 421 */         this.operator = null;
/*     */     }
/* 423 */     if (FCode.equalsIgnoreCase("makeDate"))
/*     */     {
/* 425 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 427 */         this.makeDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 430 */         this.makeDate = null;
/*     */     }
/* 432 */     if (FCode.equalsIgnoreCase("makeTime"))
/*     */     {
/* 434 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 436 */         this.makeTime = FValue.trim();
/*     */       }
/*     */       else
/* 439 */         this.makeTime = null;
/*     */     }
/* 441 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 446 */     if (otherObject == null) return false;
/* 447 */     if (this == otherObject) return true;
/* 448 */     if (getClass() != otherObject.getClass()) return false;
/* 449 */     LNPComGrpSchema other = (LNPComGrpSchema)otherObject;
/* 450 */     if ((this.comGrpCode == null) && (other.getComGrpCode() != null)) return false;
/* 451 */     if ((this.comGrpCode != null) && (!this.comGrpCode.equals(other.getComGrpCode()))) return false;
/* 452 */     if ((this.comGrpName == null) && (other.getComGrpName() != null)) return false;
/* 453 */     if ((this.comGrpName != null) && (!this.comGrpName.equals(other.getComGrpName()))) return false;
/* 454 */     if ((this.comGrpDescription == null) && (other.getComGrpDescription() != null)) return false;
/* 455 */     if ((this.comGrpDescription != null) && (!this.comGrpDescription.equals(other.getComGrpDescription()))) return false;
/* 456 */     if ((this.comSign == null) && (other.getComSign() != null)) return false;
/* 457 */     if ((this.comSign != null) && (!this.comSign.equals(other.getComSign()))) return false;
/* 458 */     if ((this.comGrpType == null) && (other.getComGrpType() != null)) return false;
/* 459 */     if ((this.comGrpType != null) && (!this.comGrpType.equals(other.getComGrpType()))) return false;
/* 460 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 461 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 462 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 463 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 464 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 465 */     return (this.makeTime == null) || (this.makeTime.equals(other.getMakeTime()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 472 */     return 8;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 478 */     if (strFieldName.equals("comGrpCode")) {
/* 479 */       return 0;
/*     */     }
/* 481 */     if (strFieldName.equals("comGrpName")) {
/* 482 */       return 1;
/*     */     }
/* 484 */     if (strFieldName.equals("comGrpDescription")) {
/* 485 */       return 2;
/*     */     }
/* 487 */     if (strFieldName.equals("comSign")) {
/* 488 */       return 3;
/*     */     }
/* 490 */     if (strFieldName.equals("comGrpType")) {
/* 491 */       return 4;
/*     */     }
/* 493 */     if (strFieldName.equals("operator")) {
/* 494 */       return 5;
/*     */     }
/* 496 */     if (strFieldName.equals("makeDate")) {
/* 497 */       return 6;
/*     */     }
/* 499 */     if (strFieldName.equals("makeTime")) {
/* 500 */       return 7;
/*     */     }
/* 502 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 508 */     String strFieldName = "";
/* 509 */     switch (nFieldIndex) {
/*     */     case 0:
/* 511 */       strFieldName = "comGrpCode";
/* 512 */       break;
/*     */     case 1:
/* 514 */       strFieldName = "comGrpName";
/* 515 */       break;
/*     */     case 2:
/* 517 */       strFieldName = "comGrpDescription";
/* 518 */       break;
/*     */     case 3:
/* 520 */       strFieldName = "comSign";
/* 521 */       break;
/*     */     case 4:
/* 523 */       strFieldName = "comGrpType";
/* 524 */       break;
/*     */     case 5:
/* 526 */       strFieldName = "operator";
/* 527 */       break;
/*     */     case 6:
/* 529 */       strFieldName = "makeDate";
/* 530 */       break;
/*     */     case 7:
/* 532 */       strFieldName = "makeTime";
/* 533 */       break;
/*     */     default:
/* 535 */       strFieldName = "";
/*     */     }
/* 537 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 543 */     if (strFieldName.equals("comGrpCode")) {
/* 544 */       return 0;
/*     */     }
/* 546 */     if (strFieldName.equals("comGrpName")) {
/* 547 */       return 0;
/*     */     }
/* 549 */     if (strFieldName.equals("comGrpDescription")) {
/* 550 */       return 0;
/*     */     }
/* 552 */     if (strFieldName.equals("comSign")) {
/* 553 */       return 0;
/*     */     }
/* 555 */     if (strFieldName.equals("comGrpType")) {
/* 556 */       return 0;
/*     */     }
/* 558 */     if (strFieldName.equals("operator")) {
/* 559 */       return 0;
/*     */     }
/* 561 */     if (strFieldName.equals("makeDate")) {
/* 562 */       return 1;
/*     */     }
/* 564 */     if (strFieldName.equals("makeTime")) {
/* 565 */       return 0;
/*     */     }
/* 567 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 573 */     int nFieldType = -1;
/* 574 */     switch (nFieldIndex) {
/*     */     case 0:
/* 576 */       nFieldType = 0;
/* 577 */       break;
/*     */     case 1:
/* 579 */       nFieldType = 0;
/* 580 */       break;
/*     */     case 2:
/* 582 */       nFieldType = 0;
/* 583 */       break;
/*     */     case 3:
/* 585 */       nFieldType = 0;
/* 586 */       break;
/*     */     case 4:
/* 588 */       nFieldType = 0;
/* 589 */       break;
/*     */     case 5:
/* 591 */       nFieldType = 0;
/* 592 */       break;
/*     */     case 6:
/* 594 */       nFieldType = 1;
/* 595 */       break;
/*     */     case 7:
/* 597 */       nFieldType = 0;
/* 598 */       break;
/*     */     default:
/* 600 */       nFieldType = -1;
/*     */     }
/* 602 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPComGrpSchema
 * JD-Core Version:    0.6.0
 */