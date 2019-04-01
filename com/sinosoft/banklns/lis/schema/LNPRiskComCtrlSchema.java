/*     */ package com.sinosoft.banklns.lis.schema;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPRiskComCtrlDB;
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
/*     */ public class LNPRiskComCtrlSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String riskCode;
/*     */   private String manageComGrp;
/*     */   private String saleChnl;
/*     */   private Date startDate;
/*     */   private Date endDate;
/*     */   private double mAXAmnt;
/*     */   private double mAXMult;
/*     */   private double mAXPrem;
/*     */   private double mINAmnt;
/*     */   private double mINMult;
/*     */   private double mINPrem;
/*     */   public static final int FIELDNUM = 11;
/*     */   private static String[] PK;
/*  49 */   private FDate fDate = new FDate();
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public LNPRiskComCtrlSchema()
/*     */   {
/*  56 */     this.mErrors = new CErrors();
/*     */ 
/*  58 */     String[] pk = new String[3];
/*  59 */     pk[0] = "RiskCode";
/*  60 */     pk[1] = "ManageComGrp";
/*  61 */     pk[2] = "SaleChnl";
/*     */ 
/*  63 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  70 */     LNPRiskComCtrlSchema cloned = (LNPRiskComCtrlSchema)super.clone();
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
/*     */   public String getRiskCode()
/*     */   {
/*  84 */     return this.riskCode;
/*     */   }
/*     */ 
/*     */   public void setRiskCode(String aRiskCode) {
/*  88 */     this.riskCode = aRiskCode;
/*     */   }
/*     */ 
/*     */   public String getManageComGrp() {
/*  92 */     return this.manageComGrp;
/*     */   }
/*     */ 
/*     */   public void setManageComGrp(String aManageComGrp) {
/*  96 */     this.manageComGrp = aManageComGrp;
/*     */   }
/*     */ 
/*     */   public String getSaleChnl() {
/* 100 */     return this.saleChnl;
/*     */   }
/*     */ 
/*     */   public void setSaleChnl(String aSaleChnl) {
/* 104 */     this.saleChnl = aSaleChnl;
/*     */   }
/*     */ 
/*     */   public String getStartDate() {
/* 108 */     if (this.startDate != null) {
/* 109 */       return this.fDate.getString(this.startDate);
/*     */     }
/* 111 */     return null;
/*     */   }
/*     */ 
/*     */   public void setStartDate(Date aStartDate) {
/* 115 */     this.startDate = aStartDate;
/*     */   }
/*     */ 
/*     */   public void setStartDate(String aStartDate) {
/* 119 */     if ((aStartDate != null) && (!aStartDate.equals("")))
/*     */     {
/* 121 */       this.startDate = this.fDate.getDate(aStartDate);
/*     */     }
/*     */     else
/* 124 */       this.startDate = null;
/*     */   }
/*     */ 
/*     */   public String getEndDate()
/*     */   {
/* 129 */     if (this.endDate != null) {
/* 130 */       return this.fDate.getString(this.endDate);
/*     */     }
/* 132 */     return null;
/*     */   }
/*     */ 
/*     */   public void setEndDate(Date aEndDate) {
/* 136 */     this.endDate = aEndDate;
/*     */   }
/*     */ 
/*     */   public void setEndDate(String aEndDate) {
/* 140 */     if ((aEndDate != null) && (!aEndDate.equals("")))
/*     */     {
/* 142 */       this.endDate = this.fDate.getDate(aEndDate);
/*     */     }
/*     */     else
/* 145 */       this.endDate = null;
/*     */   }
/*     */ 
/*     */   public double getMAXAmnt()
/*     */   {
/* 150 */     return this.mAXAmnt;
/*     */   }
/*     */ 
/*     */   public void setMAXAmnt(double aMAXAmnt) {
/* 154 */     this.mAXAmnt = aMAXAmnt;
/*     */   }
/*     */ 
/*     */   public void setMAXAmnt(String aMAXAmnt) {
/* 158 */     if ((aMAXAmnt != null) && (!aMAXAmnt.equals("")))
/*     */     {
/* 160 */       Double tDouble = new Double(aMAXAmnt);
/* 161 */       double d = tDouble.doubleValue();
/* 162 */       this.mAXAmnt = d;
/*     */     }
/*     */   }
/*     */ 
/*     */   public double getMAXMult()
/*     */   {
/* 168 */     return this.mAXMult;
/*     */   }
/*     */ 
/*     */   public void setMAXMult(double aMAXMult) {
/* 172 */     this.mAXMult = aMAXMult;
/*     */   }
/*     */ 
/*     */   public void setMAXMult(String aMAXMult) {
/* 176 */     if ((aMAXMult != null) && (!aMAXMult.equals("")))
/*     */     {
/* 178 */       Double tDouble = new Double(aMAXMult);
/* 179 */       double d = tDouble.doubleValue();
/* 180 */       this.mAXMult = d;
/*     */     }
/*     */   }
/*     */ 
/*     */   public double getMAXPrem()
/*     */   {
/* 186 */     return this.mAXPrem;
/*     */   }
/*     */ 
/*     */   public void setMAXPrem(double aMAXPrem) {
/* 190 */     this.mAXPrem = aMAXPrem;
/*     */   }
/*     */ 
/*     */   public void setMAXPrem(String aMAXPrem) {
/* 194 */     if ((aMAXPrem != null) && (!aMAXPrem.equals("")))
/*     */     {
/* 196 */       Double tDouble = new Double(aMAXPrem);
/* 197 */       double d = tDouble.doubleValue();
/* 198 */       this.mAXPrem = d;
/*     */     }
/*     */   }
/*     */ 
/*     */   public double getMINAmnt()
/*     */   {
/* 204 */     return this.mINAmnt;
/*     */   }
/*     */ 
/*     */   public void setMINAmnt(double aMINAmnt) {
/* 208 */     this.mINAmnt = aMINAmnt;
/*     */   }
/*     */ 
/*     */   public void setMINAmnt(String aMINAmnt) {
/* 212 */     if ((aMINAmnt != null) && (!aMINAmnt.equals("")))
/*     */     {
/* 214 */       Double tDouble = new Double(aMINAmnt);
/* 215 */       double d = tDouble.doubleValue();
/* 216 */       this.mINAmnt = d;
/*     */     }
/*     */   }
/*     */ 
/*     */   public double getMINMult()
/*     */   {
/* 222 */     return this.mINMult;
/*     */   }
/*     */ 
/*     */   public void setMINMult(double aMINMult) {
/* 226 */     this.mINMult = aMINMult;
/*     */   }
/*     */ 
/*     */   public void setMINMult(String aMINMult) {
/* 230 */     if ((aMINMult != null) && (!aMINMult.equals("")))
/*     */     {
/* 232 */       Double tDouble = new Double(aMINMult);
/* 233 */       double d = tDouble.doubleValue();
/* 234 */       this.mINMult = d;
/*     */     }
/*     */   }
/*     */ 
/*     */   public double getMINPrem()
/*     */   {
/* 240 */     return this.mINPrem;
/*     */   }
/*     */ 
/*     */   public void setMINPrem(double aMINPrem) {
/* 244 */     this.mINPrem = aMINPrem;
/*     */   }
/*     */ 
/*     */   public void setMINPrem(String aMINPrem) {
/* 248 */     if ((aMINPrem != null) && (!aMINPrem.equals("")))
/*     */     {
/* 250 */       Double tDouble = new Double(aMINPrem);
/* 251 */       double d = tDouble.doubleValue();
/* 252 */       this.mINPrem = d;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setSchema(LNPRiskComCtrlSchema aLNPRiskComCtrlSchema)
/*     */   {
/* 260 */     this.riskCode = aLNPRiskComCtrlSchema.getRiskCode();
/* 261 */     this.manageComGrp = aLNPRiskComCtrlSchema.getManageComGrp();
/* 262 */     this.saleChnl = aLNPRiskComCtrlSchema.getSaleChnl();
/* 263 */     this.startDate = this.fDate.getDate(aLNPRiskComCtrlSchema.getStartDate());
/* 264 */     this.endDate = this.fDate.getDate(aLNPRiskComCtrlSchema.getEndDate());
/* 265 */     this.mAXAmnt = aLNPRiskComCtrlSchema.getMAXAmnt();
/* 266 */     this.mAXMult = aLNPRiskComCtrlSchema.getMAXMult();
/* 267 */     this.mAXPrem = aLNPRiskComCtrlSchema.getMAXPrem();
/* 268 */     this.mINAmnt = aLNPRiskComCtrlSchema.getMINAmnt();
/* 269 */     this.mINMult = aLNPRiskComCtrlSchema.getMINMult();
/* 270 */     this.mINPrem = aLNPRiskComCtrlSchema.getMINPrem();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 279 */       if (rs.getString("RiskCode") == null)
/* 280 */         this.riskCode = null;
/*     */       else {
/* 282 */         this.riskCode = rs.getString("RiskCode").trim();
/*     */       }
/* 284 */       if (rs.getString("ManageComGrp") == null)
/* 285 */         this.manageComGrp = null;
/*     */       else {
/* 287 */         this.manageComGrp = rs.getString("ManageComGrp").trim();
/*     */       }
/* 289 */       if (rs.getString("SaleChnl") == null)
/* 290 */         this.saleChnl = null;
/*     */       else {
/* 292 */         this.saleChnl = rs.getString("SaleChnl").trim();
/*     */       }
/* 294 */       this.startDate = rs.getDate("StartDate");
/* 295 */       this.endDate = rs.getDate("EndDate");
/* 296 */       this.mAXAmnt = rs.getDouble("MAXAmnt");
/* 297 */       this.mAXMult = rs.getDouble("MAXMult");
/* 298 */       this.mAXPrem = rs.getDouble("MAXPrem");
/* 299 */       this.mINAmnt = rs.getDouble("MINAmnt");
/* 300 */       this.mINMult = rs.getDouble("MINMult");
/* 301 */       this.mINPrem = rs.getDouble("MINPrem");
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 305 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPRiskComCtrl\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*     */ 
/* 307 */       CError tError = new CError();
/* 308 */       tError.moduleName = "LNPRiskComCtrlSchema";
/* 309 */       tError.functionName = "setSchema";
/* 310 */       tError.errorMessage = sqle.toString();
/* 311 */       this.mErrors.addOneError(tError);
/* 312 */       return false;
/*     */     }
/* 314 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPRiskComCtrlSchema getSchema()
/*     */   {
/* 319 */     LNPRiskComCtrlSchema aLNPRiskComCtrlSchema = new LNPRiskComCtrlSchema();
/* 320 */     aLNPRiskComCtrlSchema.setSchema(this);
/* 321 */     return aLNPRiskComCtrlSchema;
/*     */   }
/*     */ 
/*     */   public LNPRiskComCtrlDB getDB()
/*     */   {
/* 326 */     LNPRiskComCtrlDB aDBOper = new LNPRiskComCtrlDB();
/* 327 */     aDBOper.setSchema(this);
/* 328 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 335 */     StringBuffer strReturn = new StringBuffer(256);
/* 336 */     strReturn.append(StrTool.cTrim(this.riskCode)); strReturn.append("|");
/* 337 */     strReturn.append(StrTool.cTrim(this.manageComGrp)); strReturn.append("|");
/* 338 */     strReturn.append(StrTool.cTrim(this.saleChnl)); strReturn.append("|");
/* 339 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.startDate))); strReturn.append("|");
/* 340 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.endDate))); strReturn.append("|");
/* 341 */     strReturn.append(ChgData.chgData(this.mAXAmnt)); strReturn.append("|");
/* 342 */     strReturn.append(ChgData.chgData(this.mAXMult)); strReturn.append("|");
/* 343 */     strReturn.append(ChgData.chgData(this.mAXPrem)); strReturn.append("|");
/* 344 */     strReturn.append(ChgData.chgData(this.mINAmnt)); strReturn.append("|");
/* 345 */     strReturn.append(ChgData.chgData(this.mINMult)); strReturn.append("|");
/* 346 */     strReturn.append(ChgData.chgData(this.mINPrem));
/* 347 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 355 */       this.riskCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 356 */       this.manageComGrp = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 357 */       this.saleChnl = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 358 */       this.startDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|"));
/* 359 */       this.endDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|"));
/* 360 */       this.mAXAmnt = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 6, "|"))).doubleValue();
/* 361 */       this.mAXMult = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 7, "|"))).doubleValue();
/* 362 */       this.mAXPrem = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 8, "|"))).doubleValue();
/* 363 */       this.mINAmnt = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 9, "|"))).doubleValue();
/* 364 */       this.mINMult = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 10, "|"))).doubleValue();
/* 365 */       this.mINPrem = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 11, "|"))).doubleValue();
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 370 */       CError tError = new CError();
/* 371 */       tError.moduleName = "LNPRiskComCtrlSchema";
/* 372 */       tError.functionName = "decode";
/* 373 */       tError.errorMessage = ex.toString();
/* 374 */       this.mErrors.addOneError(tError);
/*     */ 
/* 376 */       return false;
/*     */     }
/* 378 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 384 */     String strReturn = "";
/* 385 */     if (FCode.equalsIgnoreCase("riskCode"))
/*     */     {
/* 387 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.riskCode));
/*     */     }
/* 389 */     if (FCode.equalsIgnoreCase("manageComGrp"))
/*     */     {
/* 391 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageComGrp));
/*     */     }
/* 393 */     if (FCode.equalsIgnoreCase("saleChnl"))
/*     */     {
/* 395 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.saleChnl));
/*     */     }
/* 397 */     if (FCode.equalsIgnoreCase("startDate"))
/*     */     {
/* 399 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/*     */     }
/* 401 */     if (FCode.equalsIgnoreCase("endDate"))
/*     */     {
/* 403 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/*     */     }
/* 405 */     if (FCode.equalsIgnoreCase("mAXAmnt"))
/*     */     {
/* 407 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.mAXAmnt));
/*     */     }
/* 409 */     if (FCode.equalsIgnoreCase("mAXMult"))
/*     */     {
/* 411 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.mAXMult));
/*     */     }
/* 413 */     if (FCode.equalsIgnoreCase("mAXPrem"))
/*     */     {
/* 415 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.mAXPrem));
/*     */     }
/* 417 */     if (FCode.equalsIgnoreCase("mINAmnt"))
/*     */     {
/* 419 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.mINAmnt));
/*     */     }
/* 421 */     if (FCode.equalsIgnoreCase("mINMult"))
/*     */     {
/* 423 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.mINMult));
/*     */     }
/* 425 */     if (FCode.equalsIgnoreCase("mINPrem"))
/*     */     {
/* 427 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.mINPrem));
/*     */     }
/* 429 */     if (strReturn.equals(""))
/*     */     {
/* 431 */       strReturn = "null";
/*     */     }
/*     */ 
/* 434 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 441 */     String strFieldValue = "";
/* 442 */     switch (nFieldIndex) {
/*     */     case 0:
/* 444 */       strFieldValue = StrTool.GBKToUnicode(this.riskCode);
/* 445 */       break;
/*     */     case 1:
/* 447 */       strFieldValue = StrTool.GBKToUnicode(this.manageComGrp);
/* 448 */       break;
/*     */     case 2:
/* 450 */       strFieldValue = StrTool.GBKToUnicode(this.saleChnl);
/* 451 */       break;
/*     */     case 3:
/* 453 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getStartDate()));
/* 454 */       break;
/*     */     case 4:
/* 456 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getEndDate()));
/* 457 */       break;
/*     */     case 5:
/* 459 */       strFieldValue = String.valueOf(this.mAXAmnt);
/* 460 */       break;
/*     */     case 6:
/* 462 */       strFieldValue = String.valueOf(this.mAXMult);
/* 463 */       break;
/*     */     case 7:
/* 465 */       strFieldValue = String.valueOf(this.mAXPrem);
/* 466 */       break;
/*     */     case 8:
/* 468 */       strFieldValue = String.valueOf(this.mINAmnt);
/* 469 */       break;
/*     */     case 9:
/* 471 */       strFieldValue = String.valueOf(this.mINMult);
/* 472 */       break;
/*     */     case 10:
/* 474 */       strFieldValue = String.valueOf(this.mINPrem);
/* 475 */       break;
/*     */     default:
/* 477 */       strFieldValue = "";
/*     */     }
/* 479 */     if (strFieldValue.equals("")) {
/* 480 */       strFieldValue = "null";
/*     */     }
/* 482 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 488 */     if (StrTool.cTrim(FCode).equals("")) {
/* 489 */       return false;
/*     */     }
/* 491 */     if (FCode.equalsIgnoreCase("riskCode"))
/*     */     {
/* 493 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 495 */         this.riskCode = FValue.trim();
/*     */       }
/*     */       else
/* 498 */         this.riskCode = null;
/*     */     }
/* 500 */     if (FCode.equalsIgnoreCase("manageComGrp"))
/*     */     {
/* 502 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 504 */         this.manageComGrp = FValue.trim();
/*     */       }
/*     */       else
/* 507 */         this.manageComGrp = null;
/*     */     }
/* 509 */     if (FCode.equalsIgnoreCase("saleChnl"))
/*     */     {
/* 511 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 513 */         this.saleChnl = FValue.trim();
/*     */       }
/*     */       else
/* 516 */         this.saleChnl = null;
/*     */     }
/* 518 */     if (FCode.equalsIgnoreCase("startDate"))
/*     */     {
/* 520 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 522 */         this.startDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 525 */         this.startDate = null;
/*     */     }
/* 527 */     if (FCode.equalsIgnoreCase("endDate"))
/*     */     {
/* 529 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 531 */         this.endDate = this.fDate.getDate(FValue);
/*     */       }
/*     */       else
/* 534 */         this.endDate = null;
/*     */     }
/* 536 */     if (FCode.equalsIgnoreCase("mAXAmnt"))
/*     */     {
/* 538 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 540 */         Double tDouble = new Double(FValue);
/* 541 */         double d = tDouble.doubleValue();
/* 542 */         this.mAXAmnt = d;
/*     */       }
/*     */     }
/* 545 */     if (FCode.equalsIgnoreCase("mAXMult"))
/*     */     {
/* 547 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 549 */         Double tDouble = new Double(FValue);
/* 550 */         double d = tDouble.doubleValue();
/* 551 */         this.mAXMult = d;
/*     */       }
/*     */     }
/* 554 */     if (FCode.equalsIgnoreCase("mAXPrem"))
/*     */     {
/* 556 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 558 */         Double tDouble = new Double(FValue);
/* 559 */         double d = tDouble.doubleValue();
/* 560 */         this.mAXPrem = d;
/*     */       }
/*     */     }
/* 563 */     if (FCode.equalsIgnoreCase("mINAmnt"))
/*     */     {
/* 565 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 567 */         Double tDouble = new Double(FValue);
/* 568 */         double d = tDouble.doubleValue();
/* 569 */         this.mINAmnt = d;
/*     */       }
/*     */     }
/* 572 */     if (FCode.equalsIgnoreCase("mINMult"))
/*     */     {
/* 574 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 576 */         Double tDouble = new Double(FValue);
/* 577 */         double d = tDouble.doubleValue();
/* 578 */         this.mINMult = d;
/*     */       }
/*     */     }
/* 581 */     if (FCode.equalsIgnoreCase("mINPrem"))
/*     */     {
/* 583 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 585 */         Double tDouble = new Double(FValue);
/* 586 */         double d = tDouble.doubleValue();
/* 587 */         this.mINPrem = d;
/*     */       }
/*     */     }
/* 590 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 595 */     if (otherObject == null) return false;
/* 596 */     if (this == otherObject) return true;
/* 597 */     if (getClass() != otherObject.getClass()) return false;
/* 598 */     LNPRiskComCtrlSchema other = (LNPRiskComCtrlSchema)otherObject;
/* 599 */     if ((this.riskCode == null) && (other.getRiskCode() != null)) return false;
/* 600 */     if ((this.riskCode != null) && (!this.riskCode.equals(other.getRiskCode()))) return false;
/* 601 */     if ((this.manageComGrp == null) && (other.getManageComGrp() != null)) return false;
/* 602 */     if ((this.manageComGrp != null) && (!this.manageComGrp.equals(other.getManageComGrp()))) return false;
/* 603 */     if ((this.saleChnl == null) && (other.getSaleChnl() != null)) return false;
/* 604 */     if ((this.saleChnl != null) && (!this.saleChnl.equals(other.getSaleChnl()))) return false;
/* 605 */     if ((this.startDate == null) && (other.getStartDate() != null)) return false;
/* 606 */     if ((this.startDate != null) && (!this.fDate.getString(this.startDate).equals(other.getStartDate()))) return false;
/* 607 */     if ((this.endDate == null) && (other.getEndDate() != null)) return false;
/* 608 */     if ((this.endDate != null) && (!this.fDate.getString(this.endDate).equals(other.getEndDate()))) return false;
/* 609 */     if (Double.doubleToLongBits(this.mAXAmnt) != Double.doubleToLongBits(other.getMAXAmnt())) return false;
/* 610 */     if (Double.doubleToLongBits(this.mAXMult) != Double.doubleToLongBits(other.getMAXMult())) return false;
/* 611 */     if (Double.doubleToLongBits(this.mAXPrem) != Double.doubleToLongBits(other.getMAXPrem())) return false;
/* 612 */     if (Double.doubleToLongBits(this.mINAmnt) != Double.doubleToLongBits(other.getMINAmnt())) return false;
/* 613 */     if (Double.doubleToLongBits(this.mINMult) != Double.doubleToLongBits(other.getMINMult())) return false;
/* 614 */     return Double.doubleToLongBits(this.mINPrem) == Double.doubleToLongBits(other.getMINPrem());
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 621 */     return 11;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 627 */     if (strFieldName.equals("riskCode")) {
/* 628 */       return 0;
/*     */     }
/* 630 */     if (strFieldName.equals("manageComGrp")) {
/* 631 */       return 1;
/*     */     }
/* 633 */     if (strFieldName.equals("saleChnl")) {
/* 634 */       return 2;
/*     */     }
/* 636 */     if (strFieldName.equals("startDate")) {
/* 637 */       return 3;
/*     */     }
/* 639 */     if (strFieldName.equals("endDate")) {
/* 640 */       return 4;
/*     */     }
/* 642 */     if (strFieldName.equals("mAXAmnt")) {
/* 643 */       return 5;
/*     */     }
/* 645 */     if (strFieldName.equals("mAXMult")) {
/* 646 */       return 6;
/*     */     }
/* 648 */     if (strFieldName.equals("mAXPrem")) {
/* 649 */       return 7;
/*     */     }
/* 651 */     if (strFieldName.equals("mINAmnt")) {
/* 652 */       return 8;
/*     */     }
/* 654 */     if (strFieldName.equals("mINMult")) {
/* 655 */       return 9;
/*     */     }
/* 657 */     if (strFieldName.equals("mINPrem")) {
/* 658 */       return 10;
/*     */     }
/* 660 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 666 */     String strFieldName = "";
/* 667 */     switch (nFieldIndex) {
/*     */     case 0:
/* 669 */       strFieldName = "riskCode";
/* 670 */       break;
/*     */     case 1:
/* 672 */       strFieldName = "manageComGrp";
/* 673 */       break;
/*     */     case 2:
/* 675 */       strFieldName = "saleChnl";
/* 676 */       break;
/*     */     case 3:
/* 678 */       strFieldName = "startDate";
/* 679 */       break;
/*     */     case 4:
/* 681 */       strFieldName = "endDate";
/* 682 */       break;
/*     */     case 5:
/* 684 */       strFieldName = "mAXAmnt";
/* 685 */       break;
/*     */     case 6:
/* 687 */       strFieldName = "mAXMult";
/* 688 */       break;
/*     */     case 7:
/* 690 */       strFieldName = "mAXPrem";
/* 691 */       break;
/*     */     case 8:
/* 693 */       strFieldName = "mINAmnt";
/* 694 */       break;
/*     */     case 9:
/* 696 */       strFieldName = "mINMult";
/* 697 */       break;
/*     */     case 10:
/* 699 */       strFieldName = "mINPrem";
/* 700 */       break;
/*     */     default:
/* 702 */       strFieldName = "";
/*     */     }
/* 704 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 710 */     if (strFieldName.equals("riskCode")) {
/* 711 */       return 0;
/*     */     }
/* 713 */     if (strFieldName.equals("manageComGrp")) {
/* 714 */       return 0;
/*     */     }
/* 716 */     if (strFieldName.equals("saleChnl")) {
/* 717 */       return 0;
/*     */     }
/* 719 */     if (strFieldName.equals("startDate")) {
/* 720 */       return 1;
/*     */     }
/* 722 */     if (strFieldName.equals("endDate")) {
/* 723 */       return 1;
/*     */     }
/* 725 */     if (strFieldName.equals("mAXAmnt")) {
/* 726 */       return 4;
/*     */     }
/* 728 */     if (strFieldName.equals("mAXMult")) {
/* 729 */       return 4;
/*     */     }
/* 731 */     if (strFieldName.equals("mAXPrem")) {
/* 732 */       return 4;
/*     */     }
/* 734 */     if (strFieldName.equals("mINAmnt")) {
/* 735 */       return 4;
/*     */     }
/* 737 */     if (strFieldName.equals("mINMult")) {
/* 738 */       return 4;
/*     */     }
/* 740 */     if (strFieldName.equals("mINPrem")) {
/* 741 */       return 4;
/*     */     }
/* 743 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 749 */     int nFieldType = -1;
/* 750 */     switch (nFieldIndex) {
/*     */     case 0:
/* 752 */       nFieldType = 0;
/* 753 */       break;
/*     */     case 1:
/* 755 */       nFieldType = 0;
/* 756 */       break;
/*     */     case 2:
/* 758 */       nFieldType = 0;
/* 759 */       break;
/*     */     case 3:
/* 761 */       nFieldType = 1;
/* 762 */       break;
/*     */     case 4:
/* 764 */       nFieldType = 1;
/* 765 */       break;
/*     */     case 5:
/* 767 */       nFieldType = 4;
/* 768 */       break;
/*     */     case 6:
/* 770 */       nFieldType = 4;
/* 771 */       break;
/*     */     case 7:
/* 773 */       nFieldType = 4;
/* 774 */       break;
/*     */     case 8:
/* 776 */       nFieldType = 4;
/* 777 */       break;
/*     */     case 9:
/* 779 */       nFieldType = 4;
/* 780 */       break;
/*     */     case 10:
/* 782 */       nFieldType = 4;
/* 783 */       break;
/*     */     default:
/* 785 */       nFieldType = -1;
/*     */     }
/* 787 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPRiskComCtrlSchema
 * JD-Core Version:    0.6.0
 */