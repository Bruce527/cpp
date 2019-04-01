/*     */ package com.sinosoft.banklns.lis.schema;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPOccupationDB;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.Schema;
/*     */ import com.sinosoft.banklns.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ public class LNPOccupationSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String occupationCode;
/*     */   private String occupationName;
/*     */   private String workType;
/*     */   private String workName;
/*     */   private String lifeRate;
/*     */   private String hiRate;
/*     */   private String paRate;
/*     */   private String wpRate;
/*     */   private String backRate1;
/*     */   private String backRate2;
/*     */   private String relaCode;
/*     */   public static final int FIELDNUM = 11;
/*     */   private static String[] PK;
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public LNPOccupationSchema()
/*     */   {
/*  54 */     this.mErrors = new CErrors();
/*     */ 
/*  56 */     String[] pk = new String[1];
/*  57 */     pk[0] = "OccupationCode";
/*     */ 
/*  59 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  66 */     LNPOccupationSchema cloned = (LNPOccupationSchema)super.clone();
/*  67 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  68 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  74 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getOccupationCode()
/*     */   {
/*  79 */     return this.occupationCode;
/*     */   }
/*     */ 
/*     */   public void setOccupationCode(String aOccupationCode) {
/*  83 */     this.occupationCode = aOccupationCode;
/*     */   }
/*     */ 
/*     */   public String getOccupationName() {
/*  87 */     return this.occupationName;
/*     */   }
/*     */ 
/*     */   public void setOccupationName(String aOccupationName) {
/*  91 */     this.occupationName = aOccupationName;
/*     */   }
/*     */ 
/*     */   public String getWorkType() {
/*  95 */     return this.workType;
/*     */   }
/*     */ 
/*     */   public void setWorkType(String aWorkType) {
/*  99 */     this.workType = aWorkType;
/*     */   }
/*     */ 
/*     */   public String getWorkName() {
/* 103 */     return this.workName;
/*     */   }
/*     */ 
/*     */   public void setWorkName(String aWorkName) {
/* 107 */     this.workName = aWorkName;
/*     */   }
/*     */ 
/*     */   public String getLifeRate() {
/* 111 */     return this.lifeRate;
/*     */   }
/*     */ 
/*     */   public void setLifeRate(String aLifeRate) {
/* 115 */     this.lifeRate = aLifeRate;
/*     */   }
/*     */ 
/*     */   public String getHiRate() {
/* 119 */     return this.hiRate;
/*     */   }
/*     */ 
/*     */   public void setHiRate(String aHiRate) {
/* 123 */     this.hiRate = aHiRate;
/*     */   }
/*     */ 
/*     */   public String getPaRate() {
/* 127 */     return this.paRate;
/*     */   }
/*     */ 
/*     */   public void setPaRate(String aPaRate) {
/* 131 */     this.paRate = aPaRate;
/*     */   }
/*     */ 
/*     */   public String getWpRate() {
/* 135 */     return this.wpRate;
/*     */   }
/*     */ 
/*     */   public void setWpRate(String aWpRate) {
/* 139 */     this.wpRate = aWpRate;
/*     */   }
/*     */ 
/*     */   public String getBackRate1() {
/* 143 */     return this.backRate1;
/*     */   }
/*     */ 
/*     */   public void setBackRate1(String aBackRate1) {
/* 147 */     this.backRate1 = aBackRate1;
/*     */   }
/*     */ 
/*     */   public String getBackRate2() {
/* 151 */     return this.backRate2;
/*     */   }
/*     */ 
/*     */   public void setBackRate2(String aBackRate2) {
/* 155 */     this.backRate2 = aBackRate2;
/*     */   }
/*     */ 
/*     */   public String getRelaCode() {
/* 159 */     return this.relaCode;
/*     */   }
/*     */ 
/*     */   public void setRelaCode(String aRelaCode) {
/* 163 */     this.relaCode = aRelaCode;
/*     */   }
/*     */ 
/*     */   public void setSchema(LNPOccupationSchema aLNPOccupationSchema)
/*     */   {
/* 169 */     this.occupationCode = aLNPOccupationSchema.getOccupationCode();
/* 170 */     this.occupationName = aLNPOccupationSchema.getOccupationName();
/* 171 */     this.workType = aLNPOccupationSchema.getWorkType();
/* 172 */     this.workName = aLNPOccupationSchema.getWorkName();
/* 173 */     this.lifeRate = aLNPOccupationSchema.getLifeRate();
/* 174 */     this.hiRate = aLNPOccupationSchema.getHiRate();
/* 175 */     this.paRate = aLNPOccupationSchema.getPaRate();
/* 176 */     this.wpRate = aLNPOccupationSchema.getWpRate();
/* 177 */     this.backRate1 = aLNPOccupationSchema.getBackRate1();
/* 178 */     this.backRate2 = aLNPOccupationSchema.getBackRate2();
/* 179 */     this.relaCode = aLNPOccupationSchema.getRelaCode();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 188 */       if (rs.getString("OccupationCode") == null)
/* 189 */         this.occupationCode = null;
/*     */       else {
/* 191 */         this.occupationCode = rs.getString("OccupationCode").trim();
/*     */       }
/* 193 */       if (rs.getString("OccupationName") == null)
/* 194 */         this.occupationName = null;
/*     */       else {
/* 196 */         this.occupationName = rs.getString("OccupationName").trim();
/*     */       }
/* 198 */       if (rs.getString("WorkType") == null)
/* 199 */         this.workType = null;
/*     */       else {
/* 201 */         this.workType = rs.getString("WorkType").trim();
/*     */       }
/* 203 */       if (rs.getString("WorkName") == null)
/* 204 */         this.workName = null;
/*     */       else {
/* 206 */         this.workName = rs.getString("WorkName").trim();
/*     */       }
/* 208 */       if (rs.getString("LifeRate") == null)
/* 209 */         this.lifeRate = null;
/*     */       else {
/* 211 */         this.lifeRate = rs.getString("LifeRate").trim();
/*     */       }
/* 213 */       if (rs.getString("HiRate") == null)
/* 214 */         this.hiRate = null;
/*     */       else {
/* 216 */         this.hiRate = rs.getString("HiRate").trim();
/*     */       }
/* 218 */       if (rs.getString("PaRate") == null)
/* 219 */         this.paRate = null;
/*     */       else {
/* 221 */         this.paRate = rs.getString("PaRate").trim();
/*     */       }
/* 223 */       if (rs.getString("WpRate") == null)
/* 224 */         this.wpRate = null;
/*     */       else {
/* 226 */         this.wpRate = rs.getString("WpRate").trim();
/*     */       }
/* 228 */       if (rs.getString("BackRate1") == null)
/* 229 */         this.backRate1 = null;
/*     */       else {
/* 231 */         this.backRate1 = rs.getString("BackRate1").trim();
/*     */       }
/* 233 */       if (rs.getString("BackRate2") == null)
/* 234 */         this.backRate2 = null;
/*     */       else {
/* 236 */         this.backRate2 = rs.getString("BackRate2").trim();
/*     */       }
/* 238 */       if (rs.getString("RelaCode") == null)
/* 239 */         this.relaCode = null;
/*     */       else {
/* 241 */         this.relaCode = rs.getString("RelaCode").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 246 */       System.out.println("\u951F\u65A4\u62F7\u83D8\u951F\u65A4\u62F7\u68B0\u951F\u7D43NPOccupation\u951F\u65A4\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u951F\u7D4Achema\u951F\u53EB\u7889\u62F7\u951F\u8857\u6BB5\u9769\u62F7\u951F\u65A4\u62F7\u4E00\u951F\u94F0\uFF4F\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6267\u951F\u65A4\u62F7db.executeQuery\u951F\u65A4\u62F7\u8BE2\u65F6\u6CA1\u951F\u65A4\u62F7\u4F7F\u951F\u65A4\u62F7select * from tables");
/*     */ 
/* 248 */       CError tError = new CError();
/* 249 */       tError.moduleName = "LNPOccupationSchema";
/* 250 */       tError.functionName = "setSchema";
/* 251 */       tError.errorMessage = sqle.toString();
/* 252 */       this.mErrors.addOneError(tError);
/* 253 */       return false;
/*     */     }
/* 255 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPOccupationSchema getSchema()
/*     */   {
/* 260 */     LNPOccupationSchema aLNPOccupationSchema = new LNPOccupationSchema();
/* 261 */     aLNPOccupationSchema.setSchema(this);
/* 262 */     return aLNPOccupationSchema;
/*     */   }
/*     */ 
/*     */   public LNPOccupationDB getDB()
/*     */   {
/* 267 */     LNPOccupationDB aDBOper = new LNPOccupationDB();
/* 268 */     aDBOper.setSchema(this);
/* 269 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 276 */     StringBuffer strReturn = new StringBuffer(256);
/* 277 */     strReturn.append(StrTool.cTrim(this.occupationCode)); strReturn.append("|");
/* 278 */     strReturn.append(StrTool.cTrim(this.occupationName)); strReturn.append("|");
/* 279 */     strReturn.append(StrTool.cTrim(this.workType)); strReturn.append("|");
/* 280 */     strReturn.append(StrTool.cTrim(this.workName)); strReturn.append("|");
/* 281 */     strReturn.append(StrTool.cTrim(this.lifeRate)); strReturn.append("|");
/* 282 */     strReturn.append(StrTool.cTrim(this.hiRate)); strReturn.append("|");
/* 283 */     strReturn.append(StrTool.cTrim(this.paRate)); strReturn.append("|");
/* 284 */     strReturn.append(StrTool.cTrim(this.wpRate)); strReturn.append("|");
/* 285 */     strReturn.append(StrTool.cTrim(this.backRate1)); strReturn.append("|");
/* 286 */     strReturn.append(StrTool.cTrim(this.backRate2)); strReturn.append("|");
/* 287 */     strReturn.append(StrTool.cTrim(this.relaCode));
/* 288 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 296 */       this.occupationCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 297 */       this.occupationName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 298 */       this.workType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 299 */       this.workName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 300 */       this.lifeRate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 301 */       this.hiRate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 302 */       this.paRate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 303 */       this.wpRate = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/* 304 */       this.backRate1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/* 305 */       this.backRate2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/* 306 */       this.relaCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 311 */       CError tError = new CError();
/* 312 */       tError.moduleName = "LNPOccupationSchema";
/* 313 */       tError.functionName = "decode";
/* 314 */       tError.errorMessage = ex.toString();
/* 315 */       this.mErrors.addOneError(tError);
/*     */ 
/* 317 */       return false;
/*     */     }
/* 319 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 325 */     String strReturn = "";
/* 326 */     if (FCode.equalsIgnoreCase("occupationCode"))
/*     */     {
/* 328 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.occupationCode));
/*     */     }
/* 330 */     if (FCode.equalsIgnoreCase("occupationName"))
/*     */     {
/* 332 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.occupationName));
/*     */     }
/* 334 */     if (FCode.equalsIgnoreCase("workType"))
/*     */     {
/* 336 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.workType));
/*     */     }
/* 338 */     if (FCode.equalsIgnoreCase("workName"))
/*     */     {
/* 340 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.workName));
/*     */     }
/* 342 */     if (FCode.equalsIgnoreCase("lifeRate"))
/*     */     {
/* 344 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.lifeRate));
/*     */     }
/* 346 */     if (FCode.equalsIgnoreCase("hiRate"))
/*     */     {
/* 348 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.hiRate));
/*     */     }
/* 350 */     if (FCode.equalsIgnoreCase("paRate"))
/*     */     {
/* 352 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.paRate));
/*     */     }
/* 354 */     if (FCode.equalsIgnoreCase("wpRate"))
/*     */     {
/* 356 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.wpRate));
/*     */     }
/* 358 */     if (FCode.equalsIgnoreCase("backRate1"))
/*     */     {
/* 360 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.backRate1));
/*     */     }
/* 362 */     if (FCode.equalsIgnoreCase("backRate2"))
/*     */     {
/* 364 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.backRate2));
/*     */     }
/* 366 */     if (FCode.equalsIgnoreCase("relaCode"))
/*     */     {
/* 368 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.relaCode));
/*     */     }
/* 370 */     if (strReturn.equals(""))
/*     */     {
/* 372 */       strReturn = "null";
/*     */     }
/*     */ 
/* 375 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 382 */     String strFieldValue = "";
/* 383 */     switch (nFieldIndex) {
/*     */     case 0:
/* 385 */       strFieldValue = StrTool.GBKToUnicode(this.occupationCode);
/* 386 */       break;
/*     */     case 1:
/* 388 */       strFieldValue = StrTool.GBKToUnicode(this.occupationName);
/* 389 */       break;
/*     */     case 2:
/* 391 */       strFieldValue = StrTool.GBKToUnicode(this.workType);
/* 392 */       break;
/*     */     case 3:
/* 394 */       strFieldValue = StrTool.GBKToUnicode(this.workName);
/* 395 */       break;
/*     */     case 4:
/* 397 */       strFieldValue = StrTool.GBKToUnicode(this.lifeRate);
/* 398 */       break;
/*     */     case 5:
/* 400 */       strFieldValue = StrTool.GBKToUnicode(this.hiRate);
/* 401 */       break;
/*     */     case 6:
/* 403 */       strFieldValue = StrTool.GBKToUnicode(this.paRate);
/* 404 */       break;
/*     */     case 7:
/* 406 */       strFieldValue = StrTool.GBKToUnicode(this.wpRate);
/* 407 */       break;
/*     */     case 8:
/* 409 */       strFieldValue = StrTool.GBKToUnicode(this.backRate1);
/* 410 */       break;
/*     */     case 9:
/* 412 */       strFieldValue = StrTool.GBKToUnicode(this.backRate2);
/* 413 */       break;
/*     */     case 10:
/* 415 */       strFieldValue = StrTool.GBKToUnicode(this.relaCode);
/* 416 */       break;
/*     */     default:
/* 418 */       strFieldValue = "";
/*     */     }
/* 420 */     if (strFieldValue.equals("")) {
/* 421 */       strFieldValue = "null";
/*     */     }
/* 423 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 429 */     if (StrTool.cTrim(FCode).equals("")) {
/* 430 */       return false;
/*     */     }
/* 432 */     if (FCode.equalsIgnoreCase("occupationCode"))
/*     */     {
/* 434 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 436 */         this.occupationCode = FValue.trim();
/*     */       }
/*     */       else
/* 439 */         this.occupationCode = null;
/*     */     }
/* 441 */     if (FCode.equalsIgnoreCase("occupationName"))
/*     */     {
/* 443 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 445 */         this.occupationName = FValue.trim();
/*     */       }
/*     */       else
/* 448 */         this.occupationName = null;
/*     */     }
/* 450 */     if (FCode.equalsIgnoreCase("workType"))
/*     */     {
/* 452 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 454 */         this.workType = FValue.trim();
/*     */       }
/*     */       else
/* 457 */         this.workType = null;
/*     */     }
/* 459 */     if (FCode.equalsIgnoreCase("workName"))
/*     */     {
/* 461 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 463 */         this.workName = FValue.trim();
/*     */       }
/*     */       else
/* 466 */         this.workName = null;
/*     */     }
/* 468 */     if (FCode.equalsIgnoreCase("lifeRate"))
/*     */     {
/* 470 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 472 */         this.lifeRate = FValue.trim();
/*     */       }
/*     */       else
/* 475 */         this.lifeRate = null;
/*     */     }
/* 477 */     if (FCode.equalsIgnoreCase("hiRate"))
/*     */     {
/* 479 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 481 */         this.hiRate = FValue.trim();
/*     */       }
/*     */       else
/* 484 */         this.hiRate = null;
/*     */     }
/* 486 */     if (FCode.equalsIgnoreCase("paRate"))
/*     */     {
/* 488 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 490 */         this.paRate = FValue.trim();
/*     */       }
/*     */       else
/* 493 */         this.paRate = null;
/*     */     }
/* 495 */     if (FCode.equalsIgnoreCase("wpRate"))
/*     */     {
/* 497 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 499 */         this.wpRate = FValue.trim();
/*     */       }
/*     */       else
/* 502 */         this.wpRate = null;
/*     */     }
/* 504 */     if (FCode.equalsIgnoreCase("backRate1"))
/*     */     {
/* 506 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 508 */         this.backRate1 = FValue.trim();
/*     */       }
/*     */       else
/* 511 */         this.backRate1 = null;
/*     */     }
/* 513 */     if (FCode.equalsIgnoreCase("backRate2"))
/*     */     {
/* 515 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 517 */         this.backRate2 = FValue.trim();
/*     */       }
/*     */       else
/* 520 */         this.backRate2 = null;
/*     */     }
/* 522 */     if (FCode.equalsIgnoreCase("relaCode"))
/*     */     {
/* 524 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 526 */         this.relaCode = FValue.trim();
/*     */       }
/*     */       else
/* 529 */         this.relaCode = null;
/*     */     }
/* 531 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 536 */     if (otherObject == null) return false;
/* 537 */     if (this == otherObject) return true;
/* 538 */     if (getClass() != otherObject.getClass()) return false;
/* 539 */     LNPOccupationSchema other = (LNPOccupationSchema)otherObject;
/* 540 */     if ((this.occupationCode == null) && (other.getOccupationCode() != null)) return false;
/* 541 */     if ((this.occupationCode != null) && (!this.occupationCode.equals(other.getOccupationCode()))) return false;
/* 542 */     if ((this.occupationName == null) && (other.getOccupationName() != null)) return false;
/* 543 */     if ((this.occupationName != null) && (!this.occupationName.equals(other.getOccupationName()))) return false;
/* 544 */     if ((this.workType == null) && (other.getWorkType() != null)) return false;
/* 545 */     if ((this.workType != null) && (!this.workType.equals(other.getWorkType()))) return false;
/* 546 */     if ((this.workName == null) && (other.getWorkName() != null)) return false;
/* 547 */     if ((this.workName != null) && (!this.workName.equals(other.getWorkName()))) return false;
/* 548 */     if ((this.lifeRate == null) && (other.getLifeRate() != null)) return false;
/* 549 */     if ((this.lifeRate != null) && (!this.lifeRate.equals(other.getLifeRate()))) return false;
/* 550 */     if ((this.hiRate == null) && (other.getHiRate() != null)) return false;
/* 551 */     if ((this.hiRate != null) && (!this.hiRate.equals(other.getHiRate()))) return false;
/* 552 */     if ((this.paRate == null) && (other.getPaRate() != null)) return false;
/* 553 */     if ((this.paRate != null) && (!this.paRate.equals(other.getPaRate()))) return false;
/* 554 */     if ((this.wpRate == null) && (other.getWpRate() != null)) return false;
/* 555 */     if ((this.wpRate != null) && (!this.wpRate.equals(other.getWpRate()))) return false;
/* 556 */     if ((this.backRate1 == null) && (other.getBackRate1() != null)) return false;
/* 557 */     if ((this.backRate1 != null) && (!this.backRate1.equals(other.getBackRate1()))) return false;
/* 558 */     if ((this.backRate2 == null) && (other.getBackRate2() != null)) return false;
/* 559 */     if ((this.backRate2 != null) && (!this.backRate2.equals(other.getBackRate2()))) return false;
/* 560 */     if ((this.relaCode == null) && (other.getRelaCode() != null)) return false;
/* 561 */     return (this.relaCode == null) || (this.relaCode.equals(other.getRelaCode()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 568 */     return 11;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 574 */     if (strFieldName.equals("occupationCode")) {
/* 575 */       return 0;
/*     */     }
/* 577 */     if (strFieldName.equals("occupationName")) {
/* 578 */       return 1;
/*     */     }
/* 580 */     if (strFieldName.equals("workType")) {
/* 581 */       return 2;
/*     */     }
/* 583 */     if (strFieldName.equals("workName")) {
/* 584 */       return 3;
/*     */     }
/* 586 */     if (strFieldName.equals("lifeRate")) {
/* 587 */       return 4;
/*     */     }
/* 589 */     if (strFieldName.equals("hiRate")) {
/* 590 */       return 5;
/*     */     }
/* 592 */     if (strFieldName.equals("paRate")) {
/* 593 */       return 6;
/*     */     }
/* 595 */     if (strFieldName.equals("wpRate")) {
/* 596 */       return 7;
/*     */     }
/* 598 */     if (strFieldName.equals("backRate1")) {
/* 599 */       return 8;
/*     */     }
/* 601 */     if (strFieldName.equals("backRate2")) {
/* 602 */       return 9;
/*     */     }
/* 604 */     if (strFieldName.equals("relaCode")) {
/* 605 */       return 10;
/*     */     }
/* 607 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 613 */     String strFieldName = "";
/* 614 */     switch (nFieldIndex) {
/*     */     case 0:
/* 616 */       strFieldName = "occupationCode";
/* 617 */       break;
/*     */     case 1:
/* 619 */       strFieldName = "occupationName";
/* 620 */       break;
/*     */     case 2:
/* 622 */       strFieldName = "workType";
/* 623 */       break;
/*     */     case 3:
/* 625 */       strFieldName = "workName";
/* 626 */       break;
/*     */     case 4:
/* 628 */       strFieldName = "lifeRate";
/* 629 */       break;
/*     */     case 5:
/* 631 */       strFieldName = "hiRate";
/* 632 */       break;
/*     */     case 6:
/* 634 */       strFieldName = "paRate";
/* 635 */       break;
/*     */     case 7:
/* 637 */       strFieldName = "wpRate";
/* 638 */       break;
/*     */     case 8:
/* 640 */       strFieldName = "backRate1";
/* 641 */       break;
/*     */     case 9:
/* 643 */       strFieldName = "backRate2";
/* 644 */       break;
/*     */     case 10:
/* 646 */       strFieldName = "relaCode";
/* 647 */       break;
/*     */     default:
/* 649 */       strFieldName = "";
/*     */     }
/* 651 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 657 */     if (strFieldName.equals("occupationCode")) {
/* 658 */       return 0;
/*     */     }
/* 660 */     if (strFieldName.equals("occupationName")) {
/* 661 */       return 0;
/*     */     }
/* 663 */     if (strFieldName.equals("workType")) {
/* 664 */       return 0;
/*     */     }
/* 666 */     if (strFieldName.equals("workName")) {
/* 667 */       return 0;
/*     */     }
/* 669 */     if (strFieldName.equals("lifeRate")) {
/* 670 */       return 0;
/*     */     }
/* 672 */     if (strFieldName.equals("hiRate")) {
/* 673 */       return 0;
/*     */     }
/* 675 */     if (strFieldName.equals("paRate")) {
/* 676 */       return 0;
/*     */     }
/* 678 */     if (strFieldName.equals("wpRate")) {
/* 679 */       return 0;
/*     */     }
/* 681 */     if (strFieldName.equals("backRate1")) {
/* 682 */       return 0;
/*     */     }
/* 684 */     if (strFieldName.equals("backRate2")) {
/* 685 */       return 0;
/*     */     }
/* 687 */     if (strFieldName.equals("relaCode")) {
/* 688 */       return 0;
/*     */     }
/* 690 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 696 */     int nFieldType = -1;
/* 697 */     switch (nFieldIndex) {
/*     */     case 0:
/* 699 */       nFieldType = 0;
/* 700 */       break;
/*     */     case 1:
/* 702 */       nFieldType = 0;
/* 703 */       break;
/*     */     case 2:
/* 705 */       nFieldType = 0;
/* 706 */       break;
/*     */     case 3:
/* 708 */       nFieldType = 0;
/* 709 */       break;
/*     */     case 4:
/* 711 */       nFieldType = 0;
/* 712 */       break;
/*     */     case 5:
/* 714 */       nFieldType = 0;
/* 715 */       break;
/*     */     case 6:
/* 717 */       nFieldType = 0;
/* 718 */       break;
/*     */     case 7:
/* 720 */       nFieldType = 0;
/* 721 */       break;
/*     */     case 8:
/* 723 */       nFieldType = 0;
/* 724 */       break;
/*     */     case 9:
/* 726 */       nFieldType = 0;
/* 727 */       break;
/*     */     case 10:
/* 729 */       nFieldType = 0;
/* 730 */       break;
/*     */     default:
/* 732 */       nFieldType = -1;
/*     */     }
/* 734 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPOccupationSchema
 * JD-Core Version:    0.6.0
 */