/*     */ package com.sinosoft.banklns.lis.schema;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPAgentImpOptionDB;
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
/*     */ public class LNPAgentImpOptionSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String impartId;
/*     */   private String questionId;
/*     */   private String optionId;
/*     */   private String optionOrder;
/*     */   private String optionContent;
/*     */   private String operator;
/*     */   private String manageCom;
/*     */   private Date makeDate;
/*     */   private String makeTime;
/*     */   private Date modifyDate;
/*     */   private String modifyTime;
/*     */   public static final int FIELDNUM = 11;
/*     */   private static String[] PK;
/*  49 */   private FDate fDate = new FDate();
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public LNPAgentImpOptionSchema()
/*     */   {
/*  56 */     this.mErrors = new CErrors();
/*     */ 
/*  58 */     String[] pk = new String[1];
/*  59 */     pk[0] = "OptionId";
/*     */ 
/*  61 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  68 */     LNPAgentImpOptionSchema cloned = (LNPAgentImpOptionSchema)super.clone();
/*  69 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  70 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  71 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  77 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getImpartId()
/*     */   {
/*  82 */     return this.impartId;
/*     */   }
/*     */ 
/*     */   public void setImpartId(String aImpartId) {
/*  86 */     this.impartId = aImpartId;
/*     */   }
/*     */ 
/*     */   public String getQuestionId() {
/*  90 */     return this.questionId;
/*     */   }
/*     */ 
/*     */   public void setQuestionId(String aQuestionId) {
/*  94 */     this.questionId = aQuestionId;
/*     */   }
/*     */ 
/*     */   public String getOptionId() {
/*  98 */     return this.optionId;
/*     */   }
/*     */ 
/*     */   public void setOptionId(String aOptionId) {
/* 102 */     this.optionId = aOptionId;
/*     */   }
/*     */ 
/*     */   public String getOptionOrder() {
/* 106 */     return this.optionOrder;
/*     */   }
/*     */ 
/*     */   public void setOptionOrder(String aOptionOrder) {
/* 110 */     this.optionOrder = aOptionOrder;
/*     */   }
/*     */ 
/*     */   public String getOptionContent() {
/* 114 */     return this.optionContent;
/*     */   }
/*     */ 
/*     */   public void setOptionContent(String aOptionContent) {
/* 118 */     this.optionContent = aOptionContent;
/*     */   }
/*     */ 
/*     */   public String getOperator() {
/* 122 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String aOperator) {
/* 126 */     this.operator = aOperator;
/*     */   }
/*     */ 
/*     */   public String getManageCom() {
/* 130 */     return this.manageCom;
/*     */   }
/*     */ 
/*     */   public void setManageCom(String aManageCom) {
/* 134 */     this.manageCom = aManageCom;
/*     */   }
/*     */ 
/*     */   public String getMakeDate() {
/* 138 */     if (this.makeDate != null) {
/* 139 */       return this.fDate.getString(this.makeDate);
/*     */     }
/* 141 */     return null;
/*     */   }
/*     */ 
/*     */   public void setMakeDate(Date aMakeDate) {
/* 145 */     this.makeDate = aMakeDate;
/*     */   }
/*     */ 
/*     */   public void setMakeDate(String aMakeDate) {
/* 149 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*     */     {
/* 151 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*     */     }
/*     */     else
/* 154 */       this.makeDate = null;
/*     */   }
/*     */ 
/*     */   public String getMakeTime()
/*     */   {
/* 159 */     return this.makeTime;
/*     */   }
/*     */ 
/*     */   public void setMakeTime(String aMakeTime) {
/* 163 */     this.makeTime = aMakeTime;
/*     */   }
/*     */ 
/*     */   public String getModifyDate() {
/* 167 */     if (this.modifyDate != null) {
/* 168 */       return this.fDate.getString(this.modifyDate);
/*     */     }
/* 170 */     return null;
/*     */   }
/*     */ 
/*     */   public void setModifyDate(Date aModifyDate) {
/* 174 */     this.modifyDate = aModifyDate;
/*     */   }
/*     */ 
/*     */   public void setModifyDate(String aModifyDate) {
/* 178 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*     */     {
/* 180 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*     */     }
/*     */     else
/* 183 */       this.modifyDate = null;
/*     */   }
/*     */ 
/*     */   public String getModifyTime()
/*     */   {
/* 188 */     return this.modifyTime;
/*     */   }
/*     */ 
/*     */   public void setModifyTime(String aModifyTime) {
/* 192 */     this.modifyTime = aModifyTime;
/*     */   }
/*     */ 
/*     */   public void setSchema(LNPAgentImpOptionSchema aLNPAgentImpOptionSchema)
/*     */   {
/* 198 */     this.impartId = aLNPAgentImpOptionSchema.getImpartId();
/* 199 */     this.questionId = aLNPAgentImpOptionSchema.getQuestionId();
/* 200 */     this.optionId = aLNPAgentImpOptionSchema.getOptionId();
/* 201 */     this.optionOrder = aLNPAgentImpOptionSchema.getOptionOrder();
/* 202 */     this.optionContent = aLNPAgentImpOptionSchema.getOptionContent();
/* 203 */     this.operator = aLNPAgentImpOptionSchema.getOperator();
/* 204 */     this.manageCom = aLNPAgentImpOptionSchema.getManageCom();
/* 205 */     this.makeDate = this.fDate.getDate(aLNPAgentImpOptionSchema.getMakeDate());
/* 206 */     this.makeTime = aLNPAgentImpOptionSchema.getMakeTime();
/* 207 */     this.modifyDate = this.fDate.getDate(aLNPAgentImpOptionSchema.getModifyDate());
/* 208 */     this.modifyTime = aLNPAgentImpOptionSchema.getModifyTime();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 217 */       if (rs.getString("ImpartId") == null)
/* 218 */         this.impartId = null;
/*     */       else {
/* 220 */         this.impartId = rs.getString("ImpartId").trim();
/*     */       }
/* 222 */       if (rs.getString("QuestionId") == null)
/* 223 */         this.questionId = null;
/*     */       else {
/* 225 */         this.questionId = rs.getString("QuestionId").trim();
/*     */       }
/* 227 */       if (rs.getString("OptionId") == null)
/* 228 */         this.optionId = null;
/*     */       else {
/* 230 */         this.optionId = rs.getString("OptionId").trim();
/*     */       }
/* 232 */       if (rs.getString("OptionOrder") == null)
/* 233 */         this.optionOrder = null;
/*     */       else {
/* 235 */         this.optionOrder = rs.getString("OptionOrder").trim();
/*     */       }
/* 237 */       if (rs.getString("OptionContent") == null)
/* 238 */         this.optionContent = null;
/*     */       else {
/* 240 */         this.optionContent = rs.getString("OptionContent").trim();
/*     */       }
/* 242 */       if (rs.getString("Operator") == null)
/* 243 */         this.operator = null;
/*     */       else {
/* 245 */         this.operator = rs.getString("Operator").trim();
/*     */       }
/* 247 */       if (rs.getString("ManageCom") == null)
/* 248 */         this.manageCom = null;
/*     */       else {
/* 250 */         this.manageCom = rs.getString("ManageCom").trim();
/*     */       }
/* 252 */       this.makeDate = rs.getDate("MakeDate");
/* 253 */       if (rs.getString("MakeTime") == null)
/* 254 */         this.makeTime = null;
/*     */       else {
/* 256 */         this.makeTime = rs.getString("MakeTime").trim();
/*     */       }
/* 258 */       this.modifyDate = rs.getDate("ModifyDate");
/* 259 */       if (rs.getString("ModifyTime") == null)
/* 260 */         this.modifyTime = null;
/*     */       else {
/* 262 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 267 */       System.out.println("\u93C1\u7248\u5D41\u6434\u64B2\u8151\u9428\u51E9NPAgentImpOption\u741B\u3125\u74E7\u5A08\u5178\u91DC\u93C1\u677F\u62F0Schema\u6D93\uE160\u6B91\u701B\u6941\uE18C\u6D93\uE045\u669F\u6D93\u5D84\u7AF4\u9477\u8FBE\u7D1D\u93B4\u682C\uFFFD\u546E\u58BD\u741B\u5B92b.executeQuery\u93CC\u30E8\uE1D7\u93C3\u8235\u75C5\u93C8\u5909\u5A07\u9422\u256Felect * from tables");
/*     */ 
/* 269 */       CError tError = new CError();
/* 270 */       tError.moduleName = "LNPAgentImpOptionSchema";
/* 271 */       tError.functionName = "setSchema";
/* 272 */       tError.errorMessage = sqle.toString();
/* 273 */       this.mErrors.addOneError(tError);
/* 274 */       return false;
/*     */     }
/* 276 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPAgentImpOptionSchema getSchema()
/*     */   {
/* 281 */     LNPAgentImpOptionSchema aLNPAgentImpOptionSchema = new LNPAgentImpOptionSchema();
/* 282 */     aLNPAgentImpOptionSchema.setSchema(this);
/* 283 */     return aLNPAgentImpOptionSchema;
/*     */   }
/*     */ 
/*     */   public LNPAgentImpOptionDB getDB()
/*     */   {
/* 288 */     LNPAgentImpOptionDB aDBOper = new LNPAgentImpOptionDB();
/* 289 */     aDBOper.setSchema(this);
/* 290 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 297 */     StringBuffer strReturn = new StringBuffer(256);
/* 298 */     strReturn.append(StrTool.cTrim(this.impartId)); strReturn.append("|");
/* 299 */     strReturn.append(StrTool.cTrim(this.questionId)); strReturn.append("|");
/* 300 */     strReturn.append(StrTool.cTrim(this.optionId)); strReturn.append("|");
/* 301 */     strReturn.append(StrTool.cTrim(this.optionOrder)); strReturn.append("|");
/* 302 */     strReturn.append(StrTool.cTrim(this.optionContent)); strReturn.append("|");
/* 303 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/* 304 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/* 305 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/* 306 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/* 307 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/* 308 */     strReturn.append(StrTool.cTrim(this.modifyTime));
/* 309 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 317 */       this.impartId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 318 */       this.questionId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 319 */       this.optionId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 320 */       this.optionOrder = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 321 */       this.optionContent = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 322 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 323 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 324 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|"));
/* 325 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/* 326 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
/* 327 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 332 */       CError tError = new CError();
/* 333 */       tError.moduleName = "LNPAgentImpOptionSchema";
/* 334 */       tError.functionName = "decode";
/* 335 */       tError.errorMessage = ex.toString();
/* 336 */       this.mErrors.addOneError(tError);
/*     */ 
/* 338 */       return false;
/*     */     }
/* 340 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 346 */     String strReturn = "";
/* 347 */     if (FCode.equalsIgnoreCase("impartId"))
/*     */     {
/* 349 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.impartId));
/*     */     }
/* 351 */     if (FCode.equalsIgnoreCase("questionId"))
/*     */     {
/* 353 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.questionId));
/*     */     }
/* 355 */     if (FCode.equalsIgnoreCase("optionId"))
/*     */     {
/* 357 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.optionId));
/*     */     }
/* 359 */     if (FCode.equalsIgnoreCase("optionOrder"))
/*     */     {
/* 361 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.optionOrder));
/*     */     }
/* 363 */     if (FCode.equalsIgnoreCase("optionContent"))
/*     */     {
/* 365 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.optionContent));
/*     */     }
/* 367 */     if (FCode.equalsIgnoreCase("operator"))
/*     */     {
/* 369 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*     */     }
/* 371 */     if (FCode.equalsIgnoreCase("manageCom"))
/*     */     {
/* 373 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*     */     }
/* 375 */     if (FCode.equalsIgnoreCase("makeDate"))
/*     */     {
/* 377 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*     */     }
/* 379 */     if (FCode.equalsIgnoreCase("makeTime"))
/*     */     {
/* 381 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*     */     }
/* 383 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*     */     {
/* 385 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*     */     }
/* 387 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*     */     {
/* 389 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*     */     }
/* 391 */     if (strReturn.equals(""))
/*     */     {
/* 393 */       strReturn = "null";
/*     */     }
/*     */ 
/* 396 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 403 */     String strFieldValue = "";
/* 404 */     switch (nFieldIndex) {
/*     */     case 0:
/* 406 */       strFieldValue = StrTool.GBKToUnicode(this.impartId);
/* 407 */       break;
/*     */     case 1:
/* 409 */       strFieldValue = StrTool.GBKToUnicode(this.questionId);
/* 410 */       break;
/*     */     case 2:
/* 412 */       strFieldValue = StrTool.GBKToUnicode(this.optionId);
/* 413 */       break;
/*     */     case 3:
/* 415 */       strFieldValue = StrTool.GBKToUnicode(this.optionOrder);
/* 416 */       break;
/*     */     case 4:
/* 418 */       strFieldValue = StrTool.GBKToUnicode(this.optionContent);
/* 419 */       break;
/*     */     case 5:
/* 421 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 422 */       break;
/*     */     case 6:
/* 424 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/* 425 */       break;
/*     */     case 7:
/* 427 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/* 428 */       break;
/*     */     case 8:
/* 430 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 431 */       break;
/*     */     case 9:
/* 433 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/* 434 */       break;
/*     */     case 10:
/* 436 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 437 */       break;
/*     */     default:
/* 439 */       strFieldValue = "";
/*     */     }
/* 441 */     if (strFieldValue.equals("")) {
/* 442 */       strFieldValue = "null";
/*     */     }
/* 444 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 450 */     if (StrTool.cTrim(FCode).equals("")) {
/* 451 */       return false;
/*     */     }
/* 453 */     if (FCode.equalsIgnoreCase("impartId"))
/*     */     {
/* 455 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 457 */         this.impartId = FValue.trim();
/*     */       }
/*     */       else
/* 460 */         this.impartId = null;
/*     */     }
/* 462 */     if (FCode.equalsIgnoreCase("questionId"))
/*     */     {
/* 464 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 466 */         this.questionId = FValue.trim();
/*     */       }
/*     */       else
/* 469 */         this.questionId = null;
/*     */     }
/* 471 */     if (FCode.equalsIgnoreCase("optionId"))
/*     */     {
/* 473 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 475 */         this.optionId = FValue.trim();
/*     */       }
/*     */       else
/* 478 */         this.optionId = null;
/*     */     }
/* 480 */     if (FCode.equalsIgnoreCase("optionOrder"))
/*     */     {
/* 482 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 484 */         this.optionOrder = FValue.trim();
/*     */       }
/*     */       else
/* 487 */         this.optionOrder = null;
/*     */     }
/* 489 */     if (FCode.equalsIgnoreCase("optionContent"))
/*     */     {
/* 491 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 493 */         this.optionContent = FValue.trim();
/*     */       }
/*     */       else
/* 496 */         this.optionContent = null;
/*     */     }
/* 498 */     if (FCode.equalsIgnoreCase("operator"))
/*     */     {
/* 500 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 502 */         this.operator = FValue.trim();
/*     */       }
/*     */       else
/* 505 */         this.operator = null;
/*     */     }
/* 507 */     if (FCode.equalsIgnoreCase("manageCom"))
/*     */     {
/* 509 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 511 */         this.manageCom = FValue.trim();
/*     */       }
/*     */       else
/* 514 */         this.manageCom = null;
/*     */     }
/* 516 */     if (FCode.equalsIgnoreCase("makeDate"))
/*     */     {
/* 518 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 520 */         this.makeDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 523 */         this.makeDate = null;
/*     */     }
/* 525 */     if (FCode.equalsIgnoreCase("makeTime"))
/*     */     {
/* 527 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 529 */         this.makeTime = FValue.trim();
/*     */       }
/*     */       else
/* 532 */         this.makeTime = null;
/*     */     }
/* 534 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*     */     {
/* 536 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 538 */         this.modifyDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 541 */         this.modifyDate = null;
/*     */     }
/* 543 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*     */     {
/* 545 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 547 */         this.modifyTime = FValue.trim();
/*     */       }
/*     */       else
/* 550 */         this.modifyTime = null;
/*     */     }
/* 552 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 557 */     if (otherObject == null) return false;
/* 558 */     if (this == otherObject) return true;
/* 559 */     if (getClass() != otherObject.getClass()) return false;
/* 560 */     LNPAgentImpOptionSchema other = (LNPAgentImpOptionSchema)otherObject;
/* 561 */     if ((this.impartId == null) && (other.getImpartId() != null)) return false;
/* 562 */     if ((this.impartId != null) && (!this.impartId.equals(other.getImpartId()))) return false;
/* 563 */     if ((this.questionId == null) && (other.getQuestionId() != null)) return false;
/* 564 */     if ((this.questionId != null) && (!this.questionId.equals(other.getQuestionId()))) return false;
/* 565 */     if ((this.optionId == null) && (other.getOptionId() != null)) return false;
/* 566 */     if ((this.optionId != null) && (!this.optionId.equals(other.getOptionId()))) return false;
/* 567 */     if ((this.optionOrder == null) && (other.getOptionOrder() != null)) return false;
/* 568 */     if ((this.optionOrder != null) && (!this.optionOrder.equals(other.getOptionOrder()))) return false;
/* 569 */     if ((this.optionContent == null) && (other.getOptionContent() != null)) return false;
/* 570 */     if ((this.optionContent != null) && (!this.optionContent.equals(other.getOptionContent()))) return false;
/* 571 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 572 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 573 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 574 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 575 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 576 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 577 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 578 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 579 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 580 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 581 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 582 */     return (this.modifyTime == null) || (this.modifyTime.equals(other.getModifyTime()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 589 */     return 11;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 595 */     if (strFieldName.equals("impartId")) {
/* 596 */       return 0;
/*     */     }
/* 598 */     if (strFieldName.equals("questionId")) {
/* 599 */       return 1;
/*     */     }
/* 601 */     if (strFieldName.equals("optionId")) {
/* 602 */       return 2;
/*     */     }
/* 604 */     if (strFieldName.equals("optionOrder")) {
/* 605 */       return 3;
/*     */     }
/* 607 */     if (strFieldName.equals("optionContent")) {
/* 608 */       return 4;
/*     */     }
/* 610 */     if (strFieldName.equals("operator")) {
/* 611 */       return 5;
/*     */     }
/* 613 */     if (strFieldName.equals("manageCom")) {
/* 614 */       return 6;
/*     */     }
/* 616 */     if (strFieldName.equals("makeDate")) {
/* 617 */       return 7;
/*     */     }
/* 619 */     if (strFieldName.equals("makeTime")) {
/* 620 */       return 8;
/*     */     }
/* 622 */     if (strFieldName.equals("modifyDate")) {
/* 623 */       return 9;
/*     */     }
/* 625 */     if (strFieldName.equals("modifyTime")) {
/* 626 */       return 10;
/*     */     }
/* 628 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 634 */     String strFieldName = "";
/* 635 */     switch (nFieldIndex) {
/*     */     case 0:
/* 637 */       strFieldName = "impartId";
/* 638 */       break;
/*     */     case 1:
/* 640 */       strFieldName = "questionId";
/* 641 */       break;
/*     */     case 2:
/* 643 */       strFieldName = "optionId";
/* 644 */       break;
/*     */     case 3:
/* 646 */       strFieldName = "optionOrder";
/* 647 */       break;
/*     */     case 4:
/* 649 */       strFieldName = "optionContent";
/* 650 */       break;
/*     */     case 5:
/* 652 */       strFieldName = "operator";
/* 653 */       break;
/*     */     case 6:
/* 655 */       strFieldName = "manageCom";
/* 656 */       break;
/*     */     case 7:
/* 658 */       strFieldName = "makeDate";
/* 659 */       break;
/*     */     case 8:
/* 661 */       strFieldName = "makeTime";
/* 662 */       break;
/*     */     case 9:
/* 664 */       strFieldName = "modifyDate";
/* 665 */       break;
/*     */     case 10:
/* 667 */       strFieldName = "modifyTime";
/* 668 */       break;
/*     */     default:
/* 670 */       strFieldName = "";
/*     */     }
/* 672 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 678 */     if (strFieldName.equals("impartId")) {
/* 679 */       return 0;
/*     */     }
/* 681 */     if (strFieldName.equals("questionId")) {
/* 682 */       return 0;
/*     */     }
/* 684 */     if (strFieldName.equals("optionId")) {
/* 685 */       return 0;
/*     */     }
/* 687 */     if (strFieldName.equals("optionOrder")) {
/* 688 */       return 0;
/*     */     }
/* 690 */     if (strFieldName.equals("optionContent")) {
/* 691 */       return 0;
/*     */     }
/* 693 */     if (strFieldName.equals("operator")) {
/* 694 */       return 0;
/*     */     }
/* 696 */     if (strFieldName.equals("manageCom")) {
/* 697 */       return 0;
/*     */     }
/* 699 */     if (strFieldName.equals("makeDate")) {
/* 700 */       return 1;
/*     */     }
/* 702 */     if (strFieldName.equals("makeTime")) {
/* 703 */       return 0;
/*     */     }
/* 705 */     if (strFieldName.equals("modifyDate")) {
/* 706 */       return 1;
/*     */     }
/* 708 */     if (strFieldName.equals("modifyTime")) {
/* 709 */       return 0;
/*     */     }
/* 711 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 717 */     int nFieldType = -1;
/* 718 */     switch (nFieldIndex) {
/*     */     case 0:
/* 720 */       nFieldType = 0;
/* 721 */       break;
/*     */     case 1:
/* 723 */       nFieldType = 0;
/* 724 */       break;
/*     */     case 2:
/* 726 */       nFieldType = 0;
/* 727 */       break;
/*     */     case 3:
/* 729 */       nFieldType = 0;
/* 730 */       break;
/*     */     case 4:
/* 732 */       nFieldType = 0;
/* 733 */       break;
/*     */     case 5:
/* 735 */       nFieldType = 0;
/* 736 */       break;
/*     */     case 6:
/* 738 */       nFieldType = 0;
/* 739 */       break;
/*     */     case 7:
/* 741 */       nFieldType = 1;
/* 742 */       break;
/*     */     case 8:
/* 744 */       nFieldType = 0;
/* 745 */       break;
/*     */     case 9:
/* 747 */       nFieldType = 1;
/* 748 */       break;
/*     */     case 10:
/* 750 */       nFieldType = 0;
/* 751 */       break;
/*     */     default:
/* 753 */       nFieldType = -1;
/*     */     }
/* 755 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPAgentImpOptionSchema
 * JD-Core Version:    0.6.0
 */