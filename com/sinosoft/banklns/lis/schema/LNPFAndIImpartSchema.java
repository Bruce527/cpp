/*     */ package com.sinosoft.banklns.lis.schema;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPFAndIImpartDB;
/*     */ import com.sinosoft.banklns.lis.pubfun.FDate;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.ChgData;
/*     */ import com.sinosoft.banklns.utility.Schema;
/*     */ import com.sinosoft.banklns.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class LNPFAndIImpartSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String impartId;
/*     */   private String impartName;
/*     */   private String impartVer;
/*     */   private String impartContent;
/*     */   private int questionSum;
/*     */   private String operator;
/*     */   private String manageCom;
/*     */   private String makeTime;
/*     */   private Date makeDate;
/*     */   private Date modifyDate;
/*     */   private String modifyTime;
/*     */   private String p1;
/*     */   private String p2;
/*     */   private String p3;
/*     */   private String p4;
/*     */   public static final int FIELDNUM = 15;
/*     */   private static String[] PK;
/*  57 */   private FDate fDate = new FDate();
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public LNPFAndIImpartSchema()
/*     */   {
/*  64 */     this.mErrors = new CErrors();
/*     */ 
/*  66 */     String[] pk = new String[1];
/*  67 */     pk[0] = "ImpartId";
/*     */ 
/*  69 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  76 */     LNPFAndIImpartSchema cloned = (LNPFAndIImpartSchema)super.clone();
/*  77 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  78 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  79 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  85 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getImpartId()
/*     */   {
/*  90 */     return this.impartId;
/*     */   }
/*     */ 
/*     */   public void setImpartId(String aImpartId) {
/*  94 */     this.impartId = aImpartId;
/*     */   }
/*     */ 
/*     */   public String getImpartName() {
/*  98 */     return this.impartName;
/*     */   }
/*     */ 
/*     */   public void setImpartName(String aImpartName) {
/* 102 */     this.impartName = aImpartName;
/*     */   }
/*     */ 
/*     */   public String getImpartVer() {
/* 106 */     return this.impartVer;
/*     */   }
/*     */ 
/*     */   public void setImpartVer(String aImpartVer) {
/* 110 */     this.impartVer = aImpartVer;
/*     */   }
/*     */ 
/*     */   public String getImpartContent() {
/* 114 */     return this.impartContent;
/*     */   }
/*     */ 
/*     */   public void setImpartContent(String aImpartContent) {
/* 118 */     this.impartContent = aImpartContent;
/*     */   }
/*     */ 
/*     */   public int getQuestionSum() {
/* 122 */     return this.questionSum;
/*     */   }
/*     */ 
/*     */   public void setQuestionSum(int aQuestionSum) {
/* 126 */     this.questionSum = aQuestionSum;
/*     */   }
/*     */ 
/*     */   public void setQuestionSum(String aQuestionSum) {
/* 130 */     if ((aQuestionSum != null) && (!aQuestionSum.equals("")))
/*     */     {
/* 132 */       Integer tInteger = new Integer(aQuestionSum);
/* 133 */       int i = tInteger.intValue();
/* 134 */       this.questionSum = i;
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 140 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String aOperator) {
/* 144 */     this.operator = aOperator;
/*     */   }
/*     */ 
/*     */   public String getManageCom() {
/* 148 */     return this.manageCom;
/*     */   }
/*     */ 
/*     */   public void setManageCom(String aManageCom) {
/* 152 */     this.manageCom = aManageCom;
/*     */   }
/*     */ 
/*     */   public String getMakeTime() {
/* 156 */     return this.makeTime;
/*     */   }
/*     */ 
/*     */   public void setMakeTime(String aMakeTime) {
/* 160 */     this.makeTime = aMakeTime;
/*     */   }
/*     */ 
/*     */   public String getMakeDate() {
/* 164 */     if (this.makeDate != null) {
/* 165 */       return this.fDate.getString(this.makeDate);
/*     */     }
/* 167 */     return null;
/*     */   }
/*     */ 
/*     */   public void setMakeDate(Date aMakeDate) {
/* 171 */     this.makeDate = aMakeDate;
/*     */   }
/*     */ 
/*     */   public void setMakeDate(String aMakeDate) {
/* 175 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*     */     {
/* 177 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*     */     }
/*     */     else
/* 180 */       this.makeDate = null;
/*     */   }
/*     */ 
/*     */   public String getModifyDate()
/*     */   {
/* 185 */     if (this.modifyDate != null) {
/* 186 */       return this.fDate.getString(this.modifyDate);
/*     */     }
/* 188 */     return null;
/*     */   }
/*     */ 
/*     */   public void setModifyDate(Date aModifyDate) {
/* 192 */     this.modifyDate = aModifyDate;
/*     */   }
/*     */ 
/*     */   public void setModifyDate(String aModifyDate) {
/* 196 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*     */     {
/* 198 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*     */     }
/*     */     else
/* 201 */       this.modifyDate = null;
/*     */   }
/*     */ 
/*     */   public String getModifyTime()
/*     */   {
/* 206 */     return this.modifyTime;
/*     */   }
/*     */ 
/*     */   public void setModifyTime(String aModifyTime) {
/* 210 */     this.modifyTime = aModifyTime;
/*     */   }
/*     */ 
/*     */   public String getP1() {
/* 214 */     return this.p1;
/*     */   }
/*     */ 
/*     */   public void setP1(String aP1) {
/* 218 */     this.p1 = aP1;
/*     */   }
/*     */ 
/*     */   public String getP2() {
/* 222 */     return this.p2;
/*     */   }
/*     */ 
/*     */   public void setP2(String aP2) {
/* 226 */     this.p2 = aP2;
/*     */   }
/*     */ 
/*     */   public String getP3() {
/* 230 */     return this.p3;
/*     */   }
/*     */ 
/*     */   public void setP3(String aP3) {
/* 234 */     this.p3 = aP3;
/*     */   }
/*     */ 
/*     */   public String getP4() {
/* 238 */     return this.p4;
/*     */   }
/*     */ 
/*     */   public void setP4(String aP4) {
/* 242 */     this.p4 = aP4;
/*     */   }
/*     */ 
/*     */   public void setSchema(LNPFAndIImpartSchema aLNPFAndIImpartSchema)
/*     */   {
/* 248 */     this.impartId = aLNPFAndIImpartSchema.getImpartId();
/* 249 */     this.impartName = aLNPFAndIImpartSchema.getImpartName();
/* 250 */     this.impartVer = aLNPFAndIImpartSchema.getImpartVer();
/* 251 */     this.impartContent = aLNPFAndIImpartSchema.getImpartContent();
/* 252 */     this.questionSum = aLNPFAndIImpartSchema.getQuestionSum();
/* 253 */     this.operator = aLNPFAndIImpartSchema.getOperator();
/* 254 */     this.manageCom = aLNPFAndIImpartSchema.getManageCom();
/* 255 */     this.makeTime = aLNPFAndIImpartSchema.getMakeTime();
/* 256 */     this.makeDate = this.fDate.getDate(aLNPFAndIImpartSchema.getMakeDate());
/* 257 */     this.modifyDate = this.fDate.getDate(aLNPFAndIImpartSchema.getModifyDate());
/* 258 */     this.modifyTime = aLNPFAndIImpartSchema.getModifyTime();
/* 259 */     this.p1 = aLNPFAndIImpartSchema.getP1();
/* 260 */     this.p2 = aLNPFAndIImpartSchema.getP2();
/* 261 */     this.p3 = aLNPFAndIImpartSchema.getP3();
/* 262 */     this.p4 = aLNPFAndIImpartSchema.getP4();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 271 */       if (rs.getString("ImpartId") == null)
/* 272 */         this.impartId = null;
/*     */       else {
/* 274 */         this.impartId = rs.getString("ImpartId").trim();
/*     */       }
/* 276 */       if (rs.getString("ImpartName") == null)
/* 277 */         this.impartName = null;
/*     */       else {
/* 279 */         this.impartName = rs.getString("ImpartName").trim();
/*     */       }
/* 281 */       if (rs.getString("ImpartVer") == null)
/* 282 */         this.impartVer = null;
/*     */       else {
/* 284 */         this.impartVer = rs.getString("ImpartVer").trim();
/*     */       }
/* 286 */       if (rs.getString("ImpartContent") == null)
/* 287 */         this.impartContent = null;
/*     */       else {
/* 289 */         this.impartContent = rs.getString("ImpartContent").trim();
/*     */       }
/* 291 */       this.questionSum = rs.getInt("QuestionSum");
/* 292 */       if (rs.getString("Operator") == null)
/* 293 */         this.operator = null;
/*     */       else {
/* 295 */         this.operator = rs.getString("Operator").trim();
/*     */       }
/* 297 */       if (rs.getString("ManageCom") == null)
/* 298 */         this.manageCom = null;
/*     */       else {
/* 300 */         this.manageCom = rs.getString("ManageCom").trim();
/*     */       }
/* 302 */       if (rs.getString("MakeTime") == null)
/* 303 */         this.makeTime = null;
/*     */       else {
/* 305 */         this.makeTime = rs.getString("MakeTime").trim();
/*     */       }
/* 307 */       this.makeDate = rs.getDate("MakeDate");
/* 308 */       this.modifyDate = rs.getDate("ModifyDate");
/* 309 */       if (rs.getString("ModifyTime") == null)
/* 310 */         this.modifyTime = null;
/*     */       else {
/* 312 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*     */       }
/* 314 */       if (rs.getString("p1") == null)
/* 315 */         this.p1 = null;
/*     */       else {
/* 317 */         this.p1 = rs.getString("p1").trim();
/*     */       }
/* 319 */       if (rs.getString("p2") == null)
/* 320 */         this.p2 = null;
/*     */       else {
/* 322 */         this.p2 = rs.getString("p2").trim();
/*     */       }
/* 324 */       if (rs.getString("p3") == null)
/* 325 */         this.p3 = null;
/*     */       else {
/* 327 */         this.p3 = rs.getString("p3").trim();
/*     */       }
/* 329 */       if (rs.getString("p4") == null)
/* 330 */         this.p4 = null;
/*     */       else {
/* 332 */         this.p4 = rs.getString("p4").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 337 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPFAndIImpart\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*     */ 
/* 339 */       CError tError = new CError();
/* 340 */       tError.moduleName = "LNPFAndIImpartSchema";
/* 341 */       tError.functionName = "setSchema";
/* 342 */       tError.errorMessage = sqle.toString();
/* 343 */       this.mErrors.addOneError(tError);
/* 344 */       return false;
/*     */     }
/* 346 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPFAndIImpartSchema getSchema()
/*     */   {
/* 351 */     LNPFAndIImpartSchema aLNPFAndIImpartSchema = new LNPFAndIImpartSchema();
/* 352 */     aLNPFAndIImpartSchema.setSchema(this);
/* 353 */     return aLNPFAndIImpartSchema;
/*     */   }
/*     */ 
/*     */   public LNPFAndIImpartDB getDB()
/*     */   {
/* 358 */     LNPFAndIImpartDB aDBOper = new LNPFAndIImpartDB();
/* 359 */     aDBOper.setSchema(this);
/* 360 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 367 */     StringBuffer strReturn = new StringBuffer(256);
/* 368 */     strReturn.append(StrTool.cTrim(this.impartId)); strReturn.append("|");
/* 369 */     strReturn.append(StrTool.cTrim(this.impartName)); strReturn.append("|");
/* 370 */     strReturn.append(StrTool.cTrim(this.impartVer)); strReturn.append("|");
/* 371 */     strReturn.append(StrTool.cTrim(this.impartContent)); strReturn.append("|");
/* 372 */     strReturn.append(ChgData.chgData(this.questionSum)); strReturn.append("|");
/* 373 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/* 374 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/* 375 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/* 376 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/* 377 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/* 378 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/* 379 */     strReturn.append(StrTool.cTrim(this.p1)); strReturn.append("|");
/* 380 */     strReturn.append(StrTool.cTrim(this.p2)); strReturn.append("|");
/* 381 */     strReturn.append(StrTool.cTrim(this.p3)); strReturn.append("|");
/* 382 */     strReturn.append(StrTool.cTrim(this.p4));
/* 383 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 391 */       this.impartId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 392 */       this.impartName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 393 */       this.impartVer = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 394 */       this.impartContent = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 395 */       this.questionSum = new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage, 5, "|"))).intValue();
/* 396 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 397 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 398 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/* 399 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|"));
/* 400 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|"));
/* 401 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/* 402 */       this.p1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/* 403 */       this.p2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/* 404 */       this.p3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/* 405 */       this.p4 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 410 */       CError tError = new CError();
/* 411 */       tError.moduleName = "LNPFAndIImpartSchema";
/* 412 */       tError.functionName = "decode";
/* 413 */       tError.errorMessage = ex.toString();
/* 414 */       this.mErrors.addOneError(tError);
/*     */ 
/* 416 */       return false;
/*     */     }
/* 418 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 424 */     String strReturn = "";
/* 425 */     if (FCode.equalsIgnoreCase("impartId"))
/*     */     {
/* 427 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.impartId));
/*     */     }
/* 429 */     if (FCode.equalsIgnoreCase("impartName"))
/*     */     {
/* 431 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.impartName));
/*     */     }
/* 433 */     if (FCode.equalsIgnoreCase("impartVer"))
/*     */     {
/* 435 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.impartVer));
/*     */     }
/* 437 */     if (FCode.equalsIgnoreCase("impartContent"))
/*     */     {
/* 439 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.impartContent));
/*     */     }
/* 441 */     if (FCode.equalsIgnoreCase("questionSum"))
/*     */     {
/* 443 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.questionSum));
/*     */     }
/* 445 */     if (FCode.equalsIgnoreCase("operator"))
/*     */     {
/* 447 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*     */     }
/* 449 */     if (FCode.equalsIgnoreCase("manageCom"))
/*     */     {
/* 451 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*     */     }
/* 453 */     if (FCode.equalsIgnoreCase("makeTime"))
/*     */     {
/* 455 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*     */     }
/* 457 */     if (FCode.equalsIgnoreCase("makeDate"))
/*     */     {
/* 459 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*     */     }
/* 461 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*     */     {
/* 463 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*     */     }
/* 465 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*     */     {
/* 467 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*     */     }
/* 469 */     if (FCode.equalsIgnoreCase("p1"))
/*     */     {
/* 471 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p1));
/*     */     }
/* 473 */     if (FCode.equalsIgnoreCase("p2"))
/*     */     {
/* 475 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p2));
/*     */     }
/* 477 */     if (FCode.equalsIgnoreCase("p3"))
/*     */     {
/* 479 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p3));
/*     */     }
/* 481 */     if (FCode.equalsIgnoreCase("p4"))
/*     */     {
/* 483 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.p4));
/*     */     }
/* 485 */     if (strReturn.equals(""))
/*     */     {
/* 487 */       strReturn = "null";
/*     */     }
/*     */ 
/* 490 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 497 */     String strFieldValue = "";
/* 498 */     switch (nFieldIndex) {
/*     */     case 0:
/* 500 */       strFieldValue = StrTool.GBKToUnicode(this.impartId);
/* 501 */       break;
/*     */     case 1:
/* 503 */       strFieldValue = StrTool.GBKToUnicode(this.impartName);
/* 504 */       break;
/*     */     case 2:
/* 506 */       strFieldValue = StrTool.GBKToUnicode(this.impartVer);
/* 507 */       break;
/*     */     case 3:
/* 509 */       strFieldValue = StrTool.GBKToUnicode(this.impartContent);
/* 510 */       break;
/*     */     case 4:
/* 512 */       strFieldValue = String.valueOf(this.questionSum);
/* 513 */       break;
/*     */     case 5:
/* 515 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 516 */       break;
/*     */     case 6:
/* 518 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/* 519 */       break;
/*     */     case 7:
/* 521 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 522 */       break;
/*     */     case 8:
/* 524 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/* 525 */       break;
/*     */     case 9:
/* 527 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/* 528 */       break;
/*     */     case 10:
/* 530 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 531 */       break;
/*     */     case 11:
/* 533 */       strFieldValue = StrTool.GBKToUnicode(this.p1);
/* 534 */       break;
/*     */     case 12:
/* 536 */       strFieldValue = StrTool.GBKToUnicode(this.p2);
/* 537 */       break;
/*     */     case 13:
/* 539 */       strFieldValue = StrTool.GBKToUnicode(this.p3);
/* 540 */       break;
/*     */     case 14:
/* 542 */       strFieldValue = StrTool.GBKToUnicode(this.p4);
/* 543 */       break;
/*     */     default:
/* 545 */       strFieldValue = "";
/*     */     }
/* 547 */     if (strFieldValue.equals("")) {
/* 548 */       strFieldValue = "null";
/*     */     }
/* 550 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 556 */     if (StrTool.cTrim(FCode).equals("")) {
/* 557 */       return false;
/*     */     }
/* 559 */     if (FCode.equalsIgnoreCase("impartId"))
/*     */     {
/* 561 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 563 */         this.impartId = FValue.trim();
/*     */       }
/*     */       else
/* 566 */         this.impartId = null;
/*     */     }
/* 568 */     if (FCode.equalsIgnoreCase("impartName"))
/*     */     {
/* 570 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 572 */         this.impartName = FValue.trim();
/*     */       }
/*     */       else
/* 575 */         this.impartName = null;
/*     */     }
/* 577 */     if (FCode.equalsIgnoreCase("impartVer"))
/*     */     {
/* 579 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 581 */         this.impartVer = FValue.trim();
/*     */       }
/*     */       else
/* 584 */         this.impartVer = null;
/*     */     }
/* 586 */     if (FCode.equalsIgnoreCase("impartContent"))
/*     */     {
/* 588 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 590 */         this.impartContent = FValue.trim();
/*     */       }
/*     */       else
/* 593 */         this.impartContent = null;
/*     */     }
/* 595 */     if (FCode.equalsIgnoreCase("questionSum"))
/*     */     {
/* 597 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 599 */         Integer tInteger = new Integer(FValue);
/* 600 */         int i = tInteger.intValue();
/* 601 */         this.questionSum = i;
/*     */       }
/*     */     }
/* 604 */     if (FCode.equalsIgnoreCase("operator"))
/*     */     {
/* 606 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 608 */         this.operator = FValue.trim();
/*     */       }
/*     */       else
/* 611 */         this.operator = null;
/*     */     }
/* 613 */     if (FCode.equalsIgnoreCase("manageCom"))
/*     */     {
/* 615 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 617 */         this.manageCom = FValue.trim();
/*     */       }
/*     */       else
/* 620 */         this.manageCom = null;
/*     */     }
/* 622 */     if (FCode.equalsIgnoreCase("makeTime"))
/*     */     {
/* 624 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 626 */         this.makeTime = FValue.trim();
/*     */       }
/*     */       else
/* 629 */         this.makeTime = null;
/*     */     }
/* 631 */     if (FCode.equalsIgnoreCase("makeDate"))
/*     */     {
/* 633 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 635 */         this.makeDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 638 */         this.makeDate = null;
/*     */     }
/* 640 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*     */     {
/* 642 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 644 */         this.modifyDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 647 */         this.modifyDate = null;
/*     */     }
/* 649 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*     */     {
/* 651 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 653 */         this.modifyTime = FValue.trim();
/*     */       }
/*     */       else
/* 656 */         this.modifyTime = null;
/*     */     }
/* 658 */     if (FCode.equalsIgnoreCase("p1"))
/*     */     {
/* 660 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 662 */         this.p1 = FValue.trim();
/*     */       }
/*     */       else
/* 665 */         this.p1 = null;
/*     */     }
/* 667 */     if (FCode.equalsIgnoreCase("p2"))
/*     */     {
/* 669 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 671 */         this.p2 = FValue.trim();
/*     */       }
/*     */       else
/* 674 */         this.p2 = null;
/*     */     }
/* 676 */     if (FCode.equalsIgnoreCase("p3"))
/*     */     {
/* 678 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 680 */         this.p3 = FValue.trim();
/*     */       }
/*     */       else
/* 683 */         this.p3 = null;
/*     */     }
/* 685 */     if (FCode.equalsIgnoreCase("p4"))
/*     */     {
/* 687 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 689 */         this.p4 = FValue.trim();
/*     */       }
/*     */       else
/* 692 */         this.p4 = null;
/*     */     }
/* 694 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 699 */     if (otherObject == null) return false;
/* 700 */     if (this == otherObject) return true;
/* 701 */     if (getClass() != otherObject.getClass()) return false;
/* 702 */     LNPFAndIImpartSchema other = (LNPFAndIImpartSchema)otherObject;
/* 703 */     if ((this.impartId == null) && (other.getImpartId() != null)) return false;
/* 704 */     if ((this.impartId != null) && (!this.impartId.equals(other.getImpartId()))) return false;
/* 705 */     if ((this.impartName == null) && (other.getImpartName() != null)) return false;
/* 706 */     if ((this.impartName != null) && (!this.impartName.equals(other.getImpartName()))) return false;
/* 707 */     if ((this.impartVer == null) && (other.getImpartVer() != null)) return false;
/* 708 */     if ((this.impartVer != null) && (!this.impartVer.equals(other.getImpartVer()))) return false;
/* 709 */     if ((this.impartContent == null) && (other.getImpartContent() != null)) return false;
/* 710 */     if ((this.impartContent != null) && (!this.impartContent.equals(other.getImpartContent()))) return false;
/* 711 */     if (this.questionSum != other.getQuestionSum()) return false;
/* 712 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 713 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 714 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 715 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 716 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 717 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 718 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 719 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 720 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 721 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 722 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 723 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/* 724 */     if ((this.p1 == null) && (other.getP1() != null)) return false;
/* 725 */     if ((this.p1 != null) && (!this.p1.equals(other.getP1()))) return false;
/* 726 */     if ((this.p2 == null) && (other.getP2() != null)) return false;
/* 727 */     if ((this.p2 != null) && (!this.p2.equals(other.getP2()))) return false;
/* 728 */     if ((this.p3 == null) && (other.getP3() != null)) return false;
/* 729 */     if ((this.p3 != null) && (!this.p3.equals(other.getP3()))) return false;
/* 730 */     if ((this.p4 == null) && (other.getP4() != null)) return false;
/* 731 */     return (this.p4 == null) || (this.p4.equals(other.getP4()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 738 */     return 15;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 744 */     if (strFieldName.equals("impartId")) {
/* 745 */       return 0;
/*     */     }
/* 747 */     if (strFieldName.equals("impartName")) {
/* 748 */       return 1;
/*     */     }
/* 750 */     if (strFieldName.equals("impartVer")) {
/* 751 */       return 2;
/*     */     }
/* 753 */     if (strFieldName.equals("impartContent")) {
/* 754 */       return 3;
/*     */     }
/* 756 */     if (strFieldName.equals("questionSum")) {
/* 757 */       return 4;
/*     */     }
/* 759 */     if (strFieldName.equals("operator")) {
/* 760 */       return 5;
/*     */     }
/* 762 */     if (strFieldName.equals("manageCom")) {
/* 763 */       return 6;
/*     */     }
/* 765 */     if (strFieldName.equals("makeTime")) {
/* 766 */       return 7;
/*     */     }
/* 768 */     if (strFieldName.equals("makeDate")) {
/* 769 */       return 8;
/*     */     }
/* 771 */     if (strFieldName.equals("modifyDate")) {
/* 772 */       return 9;
/*     */     }
/* 774 */     if (strFieldName.equals("modifyTime")) {
/* 775 */       return 10;
/*     */     }
/* 777 */     if (strFieldName.equals("p1")) {
/* 778 */       return 11;
/*     */     }
/* 780 */     if (strFieldName.equals("p2")) {
/* 781 */       return 12;
/*     */     }
/* 783 */     if (strFieldName.equals("p3")) {
/* 784 */       return 13;
/*     */     }
/* 786 */     if (strFieldName.equals("p4")) {
/* 787 */       return 14;
/*     */     }
/* 789 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 795 */     String strFieldName = "";
/* 796 */     switch (nFieldIndex) {
/*     */     case 0:
/* 798 */       strFieldName = "impartId";
/* 799 */       break;
/*     */     case 1:
/* 801 */       strFieldName = "impartName";
/* 802 */       break;
/*     */     case 2:
/* 804 */       strFieldName = "impartVer";
/* 805 */       break;
/*     */     case 3:
/* 807 */       strFieldName = "impartContent";
/* 808 */       break;
/*     */     case 4:
/* 810 */       strFieldName = "questionSum";
/* 811 */       break;
/*     */     case 5:
/* 813 */       strFieldName = "operator";
/* 814 */       break;
/*     */     case 6:
/* 816 */       strFieldName = "manageCom";
/* 817 */       break;
/*     */     case 7:
/* 819 */       strFieldName = "makeTime";
/* 820 */       break;
/*     */     case 8:
/* 822 */       strFieldName = "makeDate";
/* 823 */       break;
/*     */     case 9:
/* 825 */       strFieldName = "modifyDate";
/* 826 */       break;
/*     */     case 10:
/* 828 */       strFieldName = "modifyTime";
/* 829 */       break;
/*     */     case 11:
/* 831 */       strFieldName = "p1";
/* 832 */       break;
/*     */     case 12:
/* 834 */       strFieldName = "p2";
/* 835 */       break;
/*     */     case 13:
/* 837 */       strFieldName = "p3";
/* 838 */       break;
/*     */     case 14:
/* 840 */       strFieldName = "p4";
/* 841 */       break;
/*     */     default:
/* 843 */       strFieldName = "";
/*     */     }
/* 845 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 851 */     if (strFieldName.equals("impartId")) {
/* 852 */       return 0;
/*     */     }
/* 854 */     if (strFieldName.equals("impartName")) {
/* 855 */       return 0;
/*     */     }
/* 857 */     if (strFieldName.equals("impartVer")) {
/* 858 */       return 0;
/*     */     }
/* 860 */     if (strFieldName.equals("impartContent")) {
/* 861 */       return 0;
/*     */     }
/* 863 */     if (strFieldName.equals("questionSum")) {
/* 864 */       return 3;
/*     */     }
/* 866 */     if (strFieldName.equals("operator")) {
/* 867 */       return 0;
/*     */     }
/* 869 */     if (strFieldName.equals("manageCom")) {
/* 870 */       return 0;
/*     */     }
/* 872 */     if (strFieldName.equals("makeTime")) {
/* 873 */       return 0;
/*     */     }
/* 875 */     if (strFieldName.equals("makeDate")) {
/* 876 */       return 1;
/*     */     }
/* 878 */     if (strFieldName.equals("modifyDate")) {
/* 879 */       return 1;
/*     */     }
/* 881 */     if (strFieldName.equals("modifyTime")) {
/* 882 */       return 0;
/*     */     }
/* 884 */     if (strFieldName.equals("p1")) {
/* 885 */       return 0;
/*     */     }
/* 887 */     if (strFieldName.equals("p2")) {
/* 888 */       return 0;
/*     */     }
/* 890 */     if (strFieldName.equals("p3")) {
/* 891 */       return 0;
/*     */     }
/* 893 */     if (strFieldName.equals("p4")) {
/* 894 */       return 0;
/*     */     }
/* 896 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 902 */     int nFieldType = -1;
/* 903 */     switch (nFieldIndex) {
/*     */     case 0:
/* 905 */       nFieldType = 0;
/* 906 */       break;
/*     */     case 1:
/* 908 */       nFieldType = 0;
/* 909 */       break;
/*     */     case 2:
/* 911 */       nFieldType = 0;
/* 912 */       break;
/*     */     case 3:
/* 914 */       nFieldType = 0;
/* 915 */       break;
/*     */     case 4:
/* 917 */       nFieldType = 3;
/* 918 */       break;
/*     */     case 5:
/* 920 */       nFieldType = 0;
/* 921 */       break;
/*     */     case 6:
/* 923 */       nFieldType = 0;
/* 924 */       break;
/*     */     case 7:
/* 926 */       nFieldType = 0;
/* 927 */       break;
/*     */     case 8:
/* 929 */       nFieldType = 1;
/* 930 */       break;
/*     */     case 9:
/* 932 */       nFieldType = 1;
/* 933 */       break;
/*     */     case 10:
/* 935 */       nFieldType = 0;
/* 936 */       break;
/*     */     case 11:
/* 938 */       nFieldType = 0;
/* 939 */       break;
/*     */     case 12:
/* 941 */       nFieldType = 0;
/* 942 */       break;
/*     */     case 13:
/* 944 */       nFieldType = 0;
/* 945 */       break;
/*     */     case 14:
/* 947 */       nFieldType = 0;
/* 948 */       break;
/*     */     default:
/* 950 */       nFieldType = -1;
/*     */     }
/* 952 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPFAndIImpartSchema
 * JD-Core Version:    0.6.0
 */