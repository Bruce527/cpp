/*     */ package com.sinosoft.map.lis.schema;
/*     */ 
/*     */ import com.sinosoft.map.lis.db.MHelpDB;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.Schema;
/*     */ import com.sinosoft.map.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ public class MHelpSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String iD;
/*     */   private String manageCom;
/*     */   private String application;
/*     */   private String person;
/*     */   private String email;
/*     */   private String tel;
/*     */   private String vF1;
/*     */   private String vF2;
/*     */   private String vF3;
/*     */   public static final int FIELDNUM = 9;
/*     */   private static String[] PK;
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public MHelpSchema()
/*     */   {
/*  47 */     this.mErrors = new CErrors();
/*     */ 
/*  49 */     String[] pk = new String[1];
/*  50 */     pk[0] = "ID";
/*     */ 
/*  52 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  59 */     MHelpSchema cloned = (MHelpSchema)super.clone();
/*  60 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  61 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  67 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getID()
/*     */   {
/*  72 */     return this.iD;
/*     */   }
/*     */ 
/*     */   public void setID(String aID) {
/*  76 */     this.iD = aID;
/*     */   }
/*     */ 
/*     */   public String getManageCom() {
/*  80 */     return this.manageCom;
/*     */   }
/*     */ 
/*     */   public void setManageCom(String aManageCom) {
/*  84 */     this.manageCom = aManageCom;
/*     */   }
/*     */ 
/*     */   public String getApplication() {
/*  88 */     return this.application;
/*     */   }
/*     */ 
/*     */   public void setApplication(String aApplication) {
/*  92 */     this.application = aApplication;
/*     */   }
/*     */ 
/*     */   public String getPerson() {
/*  96 */     return this.person;
/*     */   }
/*     */ 
/*     */   public void setPerson(String aPerson) {
/* 100 */     this.person = aPerson;
/*     */   }
/*     */ 
/*     */   public String getEmail() {
/* 104 */     return this.email;
/*     */   }
/*     */ 
/*     */   public void setEmail(String aEmail) {
/* 108 */     this.email = aEmail;
/*     */   }
/*     */ 
/*     */   public String getTel() {
/* 112 */     return this.tel;
/*     */   }
/*     */ 
/*     */   public void setTel(String aTel) {
/* 116 */     this.tel = aTel;
/*     */   }
/*     */ 
/*     */   public String getVF1() {
/* 120 */     return this.vF1;
/*     */   }
/*     */ 
/*     */   public void setVF1(String aVF1) {
/* 124 */     this.vF1 = aVF1;
/*     */   }
/*     */ 
/*     */   public String getVF2() {
/* 128 */     return this.vF2;
/*     */   }
/*     */ 
/*     */   public void setVF2(String aVF2) {
/* 132 */     this.vF2 = aVF2;
/*     */   }
/*     */ 
/*     */   public String getVF3() {
/* 136 */     return this.vF3;
/*     */   }
/*     */ 
/*     */   public void setVF3(String aVF3) {
/* 140 */     this.vF3 = aVF3;
/*     */   }
/*     */ 
/*     */   public void setSchema(MHelpSchema aMHelpSchema)
/*     */   {
/* 146 */     this.iD = aMHelpSchema.getID();
/* 147 */     this.manageCom = aMHelpSchema.getManageCom();
/* 148 */     this.application = aMHelpSchema.getApplication();
/* 149 */     this.person = aMHelpSchema.getPerson();
/* 150 */     this.email = aMHelpSchema.getEmail();
/* 151 */     this.tel = aMHelpSchema.getTel();
/* 152 */     this.vF1 = aMHelpSchema.getVF1();
/* 153 */     this.vF2 = aMHelpSchema.getVF2();
/* 154 */     this.vF3 = aMHelpSchema.getVF3();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/* 163 */       if (rs.getString("ID") == null)
/* 164 */         this.iD = null;
/*     */       else {
/* 166 */         this.iD = rs.getString("ID").trim();
/*     */       }
/* 168 */       if (rs.getString("ManageCom") == null)
/* 169 */         this.manageCom = null;
/*     */       else {
/* 171 */         this.manageCom = rs.getString("ManageCom").trim();
/*     */       }
/* 173 */       if (rs.getString("Application") == null)
/* 174 */         this.application = null;
/*     */       else {
/* 176 */         this.application = rs.getString("Application").trim();
/*     */       }
/* 178 */       if (rs.getString("Person") == null)
/* 179 */         this.person = null;
/*     */       else {
/* 181 */         this.person = rs.getString("Person").trim();
/*     */       }
/* 183 */       if (rs.getString("Email") == null)
/* 184 */         this.email = null;
/*     */       else {
/* 186 */         this.email = rs.getString("Email").trim();
/*     */       }
/* 188 */       if (rs.getString("Tel") == null)
/* 189 */         this.tel = null;
/*     */       else {
/* 191 */         this.tel = rs.getString("Tel").trim();
/*     */       }
/* 193 */       if (rs.getString("VF1") == null)
/* 194 */         this.vF1 = null;
/*     */       else {
/* 196 */         this.vF1 = rs.getString("VF1").trim();
/*     */       }
/* 198 */       if (rs.getString("VF2") == null)
/* 199 */         this.vF2 = null;
/*     */       else {
/* 201 */         this.vF2 = rs.getString("VF2").trim();
/*     */       }
/* 203 */       if (rs.getString("VF3") == null)
/* 204 */         this.vF3 = null;
/*     */       else {
/* 206 */         this.vF3 = rs.getString("VF3").trim();
/*     */       }
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 211 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MHelp\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*     */ 
/* 213 */       CError tError = new CError();
/* 214 */       tError.moduleName = "MHelpSchema";
/* 215 */       tError.functionName = "setSchema";
/* 216 */       tError.errorMessage = sqle.toString();
/* 217 */       this.mErrors.addOneError(tError);
/* 218 */       return false;
/*     */     }
/* 220 */     return true;
/*     */   }
/*     */ 
/*     */   public MHelpSchema getSchema()
/*     */   {
/* 225 */     MHelpSchema aMHelpSchema = new MHelpSchema();
/* 226 */     aMHelpSchema.setSchema(this);
/* 227 */     return aMHelpSchema;
/*     */   }
/*     */ 
/*     */   public MHelpDB getDB()
/*     */   {
/* 232 */     MHelpDB aDBOper = new MHelpDB();
/* 233 */     aDBOper.setSchema(this);
/* 234 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 241 */     StringBuffer strReturn = new StringBuffer(256);
/* 242 */     strReturn.append(StrTool.cTrim(this.iD)); strReturn.append("|");
/* 243 */     strReturn.append(StrTool.cTrim(this.manageCom)); strReturn.append("|");
/* 244 */     strReturn.append(StrTool.cTrim(this.application)); strReturn.append("|");
/* 245 */     strReturn.append(StrTool.cTrim(this.person)); strReturn.append("|");
/* 246 */     strReturn.append(StrTool.cTrim(this.email)); strReturn.append("|");
/* 247 */     strReturn.append(StrTool.cTrim(this.tel)); strReturn.append("|");
/* 248 */     strReturn.append(StrTool.cTrim(this.vF1)); strReturn.append("|");
/* 249 */     strReturn.append(StrTool.cTrim(this.vF2)); strReturn.append("|");
/* 250 */     strReturn.append(StrTool.cTrim(this.vF3));
/* 251 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 259 */       this.iD = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 260 */       this.manageCom = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 261 */       this.application = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 262 */       this.person = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 263 */       this.email = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 264 */       this.tel = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 265 */       this.vF1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 266 */       this.vF2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/* 267 */       this.vF3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 272 */       CError tError = new CError();
/* 273 */       tError.moduleName = "MHelpSchema";
/* 274 */       tError.functionName = "decode";
/* 275 */       tError.errorMessage = ex.toString();
/* 276 */       this.mErrors.addOneError(tError);
/*     */ 
/* 278 */       return false;
/*     */     }
/* 280 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 286 */     String strReturn = "";
/* 287 */     if (FCode.equalsIgnoreCase("iD"))
/*     */     {
/* 289 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.iD));
/*     */     }
/* 291 */     if (FCode.equalsIgnoreCase("manageCom"))
/*     */     {
/* 293 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.manageCom));
/*     */     }
/* 295 */     if (FCode.equalsIgnoreCase("application"))
/*     */     {
/* 297 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.application));
/*     */     }
/* 299 */     if (FCode.equalsIgnoreCase("person"))
/*     */     {
/* 301 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.person));
/*     */     }
/* 303 */     if (FCode.equalsIgnoreCase("email"))
/*     */     {
/* 305 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.email));
/*     */     }
/* 307 */     if (FCode.equalsIgnoreCase("tel"))
/*     */     {
/* 309 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.tel));
/*     */     }
/* 311 */     if (FCode.equalsIgnoreCase("vF1"))
/*     */     {
/* 313 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vF1));
/*     */     }
/* 315 */     if (FCode.equalsIgnoreCase("vF2"))
/*     */     {
/* 317 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vF2));
/*     */     }
/* 319 */     if (FCode.equalsIgnoreCase("vF3"))
/*     */     {
/* 321 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.vF3));
/*     */     }
/* 323 */     if (strReturn.equals(""))
/*     */     {
/* 325 */       strReturn = "null";
/*     */     }
/*     */ 
/* 328 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 335 */     String strFieldValue = "";
/* 336 */     switch (nFieldIndex) {
/*     */     case 0:
/* 338 */       strFieldValue = StrTool.GBKToUnicode(this.iD);
/* 339 */       break;
/*     */     case 1:
/* 341 */       strFieldValue = StrTool.GBKToUnicode(this.manageCom);
/* 342 */       break;
/*     */     case 2:
/* 344 */       strFieldValue = StrTool.GBKToUnicode(this.application);
/* 345 */       break;
/*     */     case 3:
/* 347 */       strFieldValue = StrTool.GBKToUnicode(this.person);
/* 348 */       break;
/*     */     case 4:
/* 350 */       strFieldValue = StrTool.GBKToUnicode(this.email);
/* 351 */       break;
/*     */     case 5:
/* 353 */       strFieldValue = StrTool.GBKToUnicode(this.tel);
/* 354 */       break;
/*     */     case 6:
/* 356 */       strFieldValue = StrTool.GBKToUnicode(this.vF1);
/* 357 */       break;
/*     */     case 7:
/* 359 */       strFieldValue = StrTool.GBKToUnicode(this.vF2);
/* 360 */       break;
/*     */     case 8:
/* 362 */       strFieldValue = StrTool.GBKToUnicode(this.vF3);
/* 363 */       break;
/*     */     default:
/* 365 */       strFieldValue = "";
/*     */     }
/* 367 */     if (strFieldValue.equals("")) {
/* 368 */       strFieldValue = "null";
/*     */     }
/* 370 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 376 */     if (StrTool.cTrim(FCode).equals("")) {
/* 377 */       return false;
/*     */     }
/* 379 */     if (FCode.equalsIgnoreCase("iD"))
/*     */     {
/* 381 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 383 */         this.iD = FValue.trim();
/*     */       }
/*     */       else
/* 386 */         this.iD = null;
/*     */     }
/* 388 */     if (FCode.equalsIgnoreCase("manageCom"))
/*     */     {
/* 390 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 392 */         this.manageCom = FValue.trim();
/*     */       }
/*     */       else
/* 395 */         this.manageCom = null;
/*     */     }
/* 397 */     if (FCode.equalsIgnoreCase("application"))
/*     */     {
/* 399 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 401 */         this.application = FValue.trim();
/*     */       }
/*     */       else
/* 404 */         this.application = null;
/*     */     }
/* 406 */     if (FCode.equalsIgnoreCase("person"))
/*     */     {
/* 408 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 410 */         this.person = FValue.trim();
/*     */       }
/*     */       else
/* 413 */         this.person = null;
/*     */     }
/* 415 */     if (FCode.equalsIgnoreCase("email"))
/*     */     {
/* 417 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 419 */         this.email = FValue.trim();
/*     */       }
/*     */       else
/* 422 */         this.email = null;
/*     */     }
/* 424 */     if (FCode.equalsIgnoreCase("tel"))
/*     */     {
/* 426 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 428 */         this.tel = FValue.trim();
/*     */       }
/*     */       else
/* 431 */         this.tel = null;
/*     */     }
/* 433 */     if (FCode.equalsIgnoreCase("vF1"))
/*     */     {
/* 435 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 437 */         this.vF1 = FValue.trim();
/*     */       }
/*     */       else
/* 440 */         this.vF1 = null;
/*     */     }
/* 442 */     if (FCode.equalsIgnoreCase("vF2"))
/*     */     {
/* 444 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 446 */         this.vF2 = FValue.trim();
/*     */       }
/*     */       else
/* 449 */         this.vF2 = null;
/*     */     }
/* 451 */     if (FCode.equalsIgnoreCase("vF3"))
/*     */     {
/* 453 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 455 */         this.vF3 = FValue.trim();
/*     */       }
/*     */       else
/* 458 */         this.vF3 = null;
/*     */     }
/* 460 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 465 */     if (otherObject == null) return false;
/* 466 */     if (this == otherObject) return true;
/* 467 */     if (getClass() != otherObject.getClass()) return false;
/* 468 */     MHelpSchema other = (MHelpSchema)otherObject;
/* 469 */     if ((this.iD == null) && (other.getID() != null)) return false;
/* 470 */     if ((this.iD != null) && (!this.iD.equals(other.getID()))) return false;
/* 471 */     if ((this.manageCom == null) && (other.getManageCom() != null)) return false;
/* 472 */     if ((this.manageCom != null) && (!this.manageCom.equals(other.getManageCom()))) return false;
/* 473 */     if ((this.application == null) && (other.getApplication() != null)) return false;
/* 474 */     if ((this.application != null) && (!this.application.equals(other.getApplication()))) return false;
/* 475 */     if ((this.person == null) && (other.getPerson() != null)) return false;
/* 476 */     if ((this.person != null) && (!this.person.equals(other.getPerson()))) return false;
/* 477 */     if ((this.email == null) && (other.getEmail() != null)) return false;
/* 478 */     if ((this.email != null) && (!this.email.equals(other.getEmail()))) return false;
/* 479 */     if ((this.tel == null) && (other.getTel() != null)) return false;
/* 480 */     if ((this.tel != null) && (!this.tel.equals(other.getTel()))) return false;
/* 481 */     if ((this.vF1 == null) && (other.getVF1() != null)) return false;
/* 482 */     if ((this.vF1 != null) && (!this.vF1.equals(other.getVF1()))) return false;
/* 483 */     if ((this.vF2 == null) && (other.getVF2() != null)) return false;
/* 484 */     if ((this.vF2 != null) && (!this.vF2.equals(other.getVF2()))) return false;
/* 485 */     if ((this.vF3 == null) && (other.getVF3() != null)) return false;
/* 486 */     return (this.vF3 == null) || (this.vF3.equals(other.getVF3()));
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 493 */     return 9;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 499 */     if (strFieldName.equals("iD")) {
/* 500 */       return 0;
/*     */     }
/* 502 */     if (strFieldName.equals("manageCom")) {
/* 503 */       return 1;
/*     */     }
/* 505 */     if (strFieldName.equals("application")) {
/* 506 */       return 2;
/*     */     }
/* 508 */     if (strFieldName.equals("person")) {
/* 509 */       return 3;
/*     */     }
/* 511 */     if (strFieldName.equals("email")) {
/* 512 */       return 4;
/*     */     }
/* 514 */     if (strFieldName.equals("tel")) {
/* 515 */       return 5;
/*     */     }
/* 517 */     if (strFieldName.equals("vF1")) {
/* 518 */       return 6;
/*     */     }
/* 520 */     if (strFieldName.equals("vF2")) {
/* 521 */       return 7;
/*     */     }
/* 523 */     if (strFieldName.equals("vF3")) {
/* 524 */       return 8;
/*     */     }
/* 526 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 532 */     String strFieldName = "";
/* 533 */     switch (nFieldIndex) {
/*     */     case 0:
/* 535 */       strFieldName = "iD";
/* 536 */       break;
/*     */     case 1:
/* 538 */       strFieldName = "manageCom";
/* 539 */       break;
/*     */     case 2:
/* 541 */       strFieldName = "application";
/* 542 */       break;
/*     */     case 3:
/* 544 */       strFieldName = "person";
/* 545 */       break;
/*     */     case 4:
/* 547 */       strFieldName = "email";
/* 548 */       break;
/*     */     case 5:
/* 550 */       strFieldName = "tel";
/* 551 */       break;
/*     */     case 6:
/* 553 */       strFieldName = "vF1";
/* 554 */       break;
/*     */     case 7:
/* 556 */       strFieldName = "vF2";
/* 557 */       break;
/*     */     case 8:
/* 559 */       strFieldName = "vF3";
/* 560 */       break;
/*     */     default:
/* 562 */       strFieldName = "";
/*     */     }
/* 564 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 570 */     if (strFieldName.equals("iD")) {
/* 571 */       return 0;
/*     */     }
/* 573 */     if (strFieldName.equals("manageCom")) {
/* 574 */       return 0;
/*     */     }
/* 576 */     if (strFieldName.equals("application")) {
/* 577 */       return 0;
/*     */     }
/* 579 */     if (strFieldName.equals("person")) {
/* 580 */       return 0;
/*     */     }
/* 582 */     if (strFieldName.equals("email")) {
/* 583 */       return 0;
/*     */     }
/* 585 */     if (strFieldName.equals("tel")) {
/* 586 */       return 0;
/*     */     }
/* 588 */     if (strFieldName.equals("vF1")) {
/* 589 */       return 0;
/*     */     }
/* 591 */     if (strFieldName.equals("vF2")) {
/* 592 */       return 0;
/*     */     }
/* 594 */     if (strFieldName.equals("vF3")) {
/* 595 */       return 0;
/*     */     }
/* 597 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 603 */     int nFieldType = -1;
/* 604 */     switch (nFieldIndex) {
/*     */     case 0:
/* 606 */       nFieldType = 0;
/* 607 */       break;
/*     */     case 1:
/* 609 */       nFieldType = 0;
/* 610 */       break;
/*     */     case 2:
/* 612 */       nFieldType = 0;
/* 613 */       break;
/*     */     case 3:
/* 615 */       nFieldType = 0;
/* 616 */       break;
/*     */     case 4:
/* 618 */       nFieldType = 0;
/* 619 */       break;
/*     */     case 5:
/* 621 */       nFieldType = 0;
/* 622 */       break;
/*     */     case 6:
/* 624 */       nFieldType = 0;
/* 625 */       break;
/*     */     case 7:
/* 627 */       nFieldType = 0;
/* 628 */       break;
/*     */     case 8:
/* 630 */       nFieldType = 0;
/* 631 */       break;
/*     */     default:
/* 633 */       nFieldType = -1;
/*     */     }
/* 635 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MHelpSchema
 * JD-Core Version:    0.6.0
 */