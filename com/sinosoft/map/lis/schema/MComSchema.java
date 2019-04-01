/*      */ package com.sinosoft.map.lis.schema;
/*      */ 
/*      */ import com.sinosoft.map.lis.db.MComDB;
/*      */ import com.sinosoft.map.utility.CError;
/*      */ import com.sinosoft.map.utility.CErrors;
/*      */ import com.sinosoft.map.utility.Schema;
/*      */ import com.sinosoft.map.utility.StrTool;
/*      */ import java.io.PrintStream;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ 
/*      */ public class MComSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String comCode;
/*      */   private String outComCode;
/*      */   private String name;
/*      */   private String shortName;
/*      */   private String address;
/*      */   private String zipCode;
/*      */   private String phone;
/*      */   private String fax;
/*      */   private String eMail;
/*      */   private String webAddress;
/*      */   private String satrapName;
/*      */   private String insuMonitorCode;
/*      */   private String insureID;
/*      */   private String signID;
/*      */   private String country;
/*      */   private String province;
/*      */   private String city;
/*      */   private String comNature;
/*      */   private String validCode;
/*      */   private String sign;
/*      */   public static final int FIELDNUM = 20;
/*      */   private static String[] PK;
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public MComSchema()
/*      */   {
/*   69 */     this.mErrors = new CErrors();
/*      */ 
/*   71 */     String[] pk = new String[1];
/*   72 */     pk[0] = "ComCode";
/*      */ 
/*   74 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   81 */     MComSchema cloned = (MComSchema)super.clone();
/*   82 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   83 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   89 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getComCode()
/*      */   {
/*   94 */     return this.comCode;
/*      */   }
/*      */ 
/*      */   public void setComCode(String aComCode) {
/*   98 */     this.comCode = aComCode;
/*      */   }
/*      */ 
/*      */   public String getOutComCode() {
/*  102 */     return this.outComCode;
/*      */   }
/*      */ 
/*      */   public void setOutComCode(String aOutComCode) {
/*  106 */     this.outComCode = aOutComCode;
/*      */   }
/*      */ 
/*      */   public String getName() {
/*  110 */     return this.name;
/*      */   }
/*      */ 
/*      */   public void setName(String aName) {
/*  114 */     this.name = aName;
/*      */   }
/*      */ 
/*      */   public String getShortName() {
/*  118 */     return this.shortName;
/*      */   }
/*      */ 
/*      */   public void setShortName(String aShortName) {
/*  122 */     this.shortName = aShortName;
/*      */   }
/*      */ 
/*      */   public String getAddress() {
/*  126 */     return this.address;
/*      */   }
/*      */ 
/*      */   public void setAddress(String aAddress) {
/*  130 */     this.address = aAddress;
/*      */   }
/*      */ 
/*      */   public String getZipCode() {
/*  134 */     return this.zipCode;
/*      */   }
/*      */ 
/*      */   public void setZipCode(String aZipCode) {
/*  138 */     this.zipCode = aZipCode;
/*      */   }
/*      */ 
/*      */   public String getPhone() {
/*  142 */     return this.phone;
/*      */   }
/*      */ 
/*      */   public void setPhone(String aPhone) {
/*  146 */     this.phone = aPhone;
/*      */   }
/*      */ 
/*      */   public String getFax() {
/*  150 */     return this.fax;
/*      */   }
/*      */ 
/*      */   public void setFax(String aFax) {
/*  154 */     this.fax = aFax;
/*      */   }
/*      */ 
/*      */   public String getEMail() {
/*  158 */     return this.eMail;
/*      */   }
/*      */ 
/*      */   public void setEMail(String aEMail) {
/*  162 */     this.eMail = aEMail;
/*      */   }
/*      */ 
/*      */   public String getWebAddress() {
/*  166 */     return this.webAddress;
/*      */   }
/*      */ 
/*      */   public void setWebAddress(String aWebAddress) {
/*  170 */     this.webAddress = aWebAddress;
/*      */   }
/*      */ 
/*      */   public String getSatrapName() {
/*  174 */     return this.satrapName;
/*      */   }
/*      */ 
/*      */   public void setSatrapName(String aSatrapName) {
/*  178 */     this.satrapName = aSatrapName;
/*      */   }
/*      */ 
/*      */   public String getInsuMonitorCode() {
/*  182 */     return this.insuMonitorCode;
/*      */   }
/*      */ 
/*      */   public void setInsuMonitorCode(String aInsuMonitorCode) {
/*  186 */     this.insuMonitorCode = aInsuMonitorCode;
/*      */   }
/*      */ 
/*      */   public String getInsureID() {
/*  190 */     return this.insureID;
/*      */   }
/*      */ 
/*      */   public void setInsureID(String aInsureID) {
/*  194 */     this.insureID = aInsureID;
/*      */   }
/*      */ 
/*      */   public String getSignID() {
/*  198 */     return this.signID;
/*      */   }
/*      */ 
/*      */   public void setSignID(String aSignID) {
/*  202 */     this.signID = aSignID;
/*      */   }
/*      */ 
/*      */   public String getCountry() {
/*  206 */     return this.country;
/*      */   }
/*      */ 
/*      */   public void setCountry(String aCountry) {
/*  210 */     this.country = aCountry;
/*      */   }
/*      */ 
/*      */   public String getProvince() {
/*  214 */     return this.province;
/*      */   }
/*      */ 
/*      */   public void setProvince(String aProvince) {
/*  218 */     this.province = aProvince;
/*      */   }
/*      */ 
/*      */   public String getCity() {
/*  222 */     return this.city;
/*      */   }
/*      */ 
/*      */   public void setCity(String aCity) {
/*  226 */     this.city = aCity;
/*      */   }
/*      */ 
/*      */   public String getComNature() {
/*  230 */     return this.comNature;
/*      */   }
/*      */ 
/*      */   public void setComNature(String aComNature) {
/*  234 */     this.comNature = aComNature;
/*      */   }
/*      */ 
/*      */   public String getValidCode() {
/*  238 */     return this.validCode;
/*      */   }
/*      */ 
/*      */   public void setValidCode(String aValidCode) {
/*  242 */     this.validCode = aValidCode;
/*      */   }
/*      */ 
/*      */   public String getSign() {
/*  246 */     return this.sign;
/*      */   }
/*      */ 
/*      */   public void setSign(String aSign) {
/*  250 */     this.sign = aSign;
/*      */   }
/*      */ 
/*      */   public void setSchema(MComSchema aMComSchema)
/*      */   {
/*  256 */     this.comCode = aMComSchema.getComCode();
/*  257 */     this.outComCode = aMComSchema.getOutComCode();
/*  258 */     this.name = aMComSchema.getName();
/*  259 */     this.shortName = aMComSchema.getShortName();
/*  260 */     this.address = aMComSchema.getAddress();
/*  261 */     this.zipCode = aMComSchema.getZipCode();
/*  262 */     this.phone = aMComSchema.getPhone();
/*  263 */     this.fax = aMComSchema.getFax();
/*  264 */     this.eMail = aMComSchema.getEMail();
/*  265 */     this.webAddress = aMComSchema.getWebAddress();
/*  266 */     this.satrapName = aMComSchema.getSatrapName();
/*  267 */     this.insuMonitorCode = aMComSchema.getInsuMonitorCode();
/*  268 */     this.insureID = aMComSchema.getInsureID();
/*  269 */     this.signID = aMComSchema.getSignID();
/*  270 */     this.country = aMComSchema.getCountry();
/*  271 */     this.province = aMComSchema.getProvince();
/*  272 */     this.city = aMComSchema.getCity();
/*  273 */     this.comNature = aMComSchema.getComNature();
/*  274 */     this.validCode = aMComSchema.getValidCode();
/*  275 */     this.sign = aMComSchema.getSign();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  284 */       if (rs.getString("ComCode") == null)
/*  285 */         this.comCode = null;
/*      */       else {
/*  287 */         this.comCode = rs.getString("ComCode").trim();
/*      */       }
/*  289 */       if (rs.getString("OutComCode") == null)
/*  290 */         this.outComCode = null;
/*      */       else {
/*  292 */         this.outComCode = rs.getString("OutComCode").trim();
/*      */       }
/*  294 */       if (rs.getString("Name") == null)
/*  295 */         this.name = null;
/*      */       else {
/*  297 */         this.name = rs.getString("Name").trim();
/*      */       }
/*  299 */       if (rs.getString("ShortName") == null)
/*  300 */         this.shortName = null;
/*      */       else {
/*  302 */         this.shortName = rs.getString("ShortName").trim();
/*      */       }
/*  304 */       if (rs.getString("Address") == null)
/*  305 */         this.address = null;
/*      */       else {
/*  307 */         this.address = rs.getString("Address").trim();
/*      */       }
/*  309 */       if (rs.getString("ZipCode") == null)
/*  310 */         this.zipCode = null;
/*      */       else {
/*  312 */         this.zipCode = rs.getString("ZipCode").trim();
/*      */       }
/*  314 */       if (rs.getString("Phone") == null)
/*  315 */         this.phone = null;
/*      */       else {
/*  317 */         this.phone = rs.getString("Phone").trim();
/*      */       }
/*  319 */       if (rs.getString("Fax") == null)
/*  320 */         this.fax = null;
/*      */       else {
/*  322 */         this.fax = rs.getString("Fax").trim();
/*      */       }
/*  324 */       if (rs.getString("EMail") == null)
/*  325 */         this.eMail = null;
/*      */       else {
/*  327 */         this.eMail = rs.getString("EMail").trim();
/*      */       }
/*  329 */       if (rs.getString("WebAddress") == null)
/*  330 */         this.webAddress = null;
/*      */       else {
/*  332 */         this.webAddress = rs.getString("WebAddress").trim();
/*      */       }
/*  334 */       if (rs.getString("SatrapName") == null)
/*  335 */         this.satrapName = null;
/*      */       else {
/*  337 */         this.satrapName = rs.getString("SatrapName").trim();
/*      */       }
/*  339 */       if (rs.getString("InsuMonitorCode") == null)
/*  340 */         this.insuMonitorCode = null;
/*      */       else {
/*  342 */         this.insuMonitorCode = rs.getString("InsuMonitorCode").trim();
/*      */       }
/*  344 */       if (rs.getString("InsureID") == null)
/*  345 */         this.insureID = null;
/*      */       else {
/*  347 */         this.insureID = rs.getString("InsureID").trim();
/*      */       }
/*  349 */       if (rs.getString("SignID") == null)
/*  350 */         this.signID = null;
/*      */       else {
/*  352 */         this.signID = rs.getString("SignID").trim();
/*      */       }
/*  354 */       if (rs.getString("Country") == null)
/*  355 */         this.country = null;
/*      */       else {
/*  357 */         this.country = rs.getString("Country").trim();
/*      */       }
/*  359 */       if (rs.getString("Province") == null)
/*  360 */         this.province = null;
/*      */       else {
/*  362 */         this.province = rs.getString("Province").trim();
/*      */       }
/*  364 */       if (rs.getString("City") == null)
/*  365 */         this.city = null;
/*      */       else {
/*  367 */         this.city = rs.getString("City").trim();
/*      */       }
/*  369 */       if (rs.getString("ComNature") == null)
/*  370 */         this.comNature = null;
/*      */       else {
/*  372 */         this.comNature = rs.getString("ComNature").trim();
/*      */       }
/*  374 */       if (rs.getString("ValidCode") == null)
/*  375 */         this.validCode = null;
/*      */       else {
/*  377 */         this.validCode = rs.getString("ValidCode").trim();
/*      */       }
/*  379 */       if (rs.getString("Sign") == null)
/*  380 */         this.sign = null;
/*      */       else {
/*  382 */         this.sign = rs.getString("Sign").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  387 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MCom\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  389 */       CError tError = new CError();
/*  390 */       tError.moduleName = "MComSchema";
/*  391 */       tError.functionName = "setSchema";
/*  392 */       tError.errorMessage = sqle.toString();
/*  393 */       this.mErrors.addOneError(tError);
/*  394 */       return false;
/*      */     }
/*  396 */     return true;
/*      */   }
/*      */ 
/*      */   public MComSchema getSchema()
/*      */   {
/*  401 */     MComSchema aMComSchema = new MComSchema();
/*  402 */     aMComSchema.setSchema(this);
/*  403 */     return aMComSchema;
/*      */   }
/*      */ 
/*      */   public MComDB getDB()
/*      */   {
/*  408 */     MComDB aDBOper = new MComDB();
/*  409 */     aDBOper.setSchema(this);
/*  410 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  417 */     StringBuffer strReturn = new StringBuffer(256);
/*  418 */     strReturn.append(StrTool.cTrim(this.comCode)); strReturn.append("|");
/*  419 */     strReturn.append(StrTool.cTrim(this.outComCode)); strReturn.append("|");
/*  420 */     strReturn.append(StrTool.cTrim(this.name)); strReturn.append("|");
/*  421 */     strReturn.append(StrTool.cTrim(this.shortName)); strReturn.append("|");
/*  422 */     strReturn.append(StrTool.cTrim(this.address)); strReturn.append("|");
/*  423 */     strReturn.append(StrTool.cTrim(this.zipCode)); strReturn.append("|");
/*  424 */     strReturn.append(StrTool.cTrim(this.phone)); strReturn.append("|");
/*  425 */     strReturn.append(StrTool.cTrim(this.fax)); strReturn.append("|");
/*  426 */     strReturn.append(StrTool.cTrim(this.eMail)); strReturn.append("|");
/*  427 */     strReturn.append(StrTool.cTrim(this.webAddress)); strReturn.append("|");
/*  428 */     strReturn.append(StrTool.cTrim(this.satrapName)); strReturn.append("|");
/*  429 */     strReturn.append(StrTool.cTrim(this.insuMonitorCode)); strReturn.append("|");
/*  430 */     strReturn.append(StrTool.cTrim(this.insureID)); strReturn.append("|");
/*  431 */     strReturn.append(StrTool.cTrim(this.signID)); strReturn.append("|");
/*  432 */     strReturn.append(StrTool.cTrim(this.country)); strReturn.append("|");
/*  433 */     strReturn.append(StrTool.cTrim(this.province)); strReturn.append("|");
/*  434 */     strReturn.append(StrTool.cTrim(this.city)); strReturn.append("|");
/*  435 */     strReturn.append(StrTool.cTrim(this.comNature)); strReturn.append("|");
/*  436 */     strReturn.append(StrTool.cTrim(this.validCode)); strReturn.append("|");
/*  437 */     strReturn.append(StrTool.cTrim(this.sign));
/*  438 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  446 */       this.comCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  447 */       this.outComCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  448 */       this.name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  449 */       this.shortName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  450 */       this.address = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  451 */       this.zipCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  452 */       this.phone = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  453 */       this.fax = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  454 */       this.eMail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  455 */       this.webAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  456 */       this.satrapName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  457 */       this.insuMonitorCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  458 */       this.insureID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  459 */       this.signID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  460 */       this.country = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  461 */       this.province = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  462 */       this.city = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  463 */       this.comNature = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  464 */       this.validCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  465 */       this.sign = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  470 */       CError tError = new CError();
/*  471 */       tError.moduleName = "MComSchema";
/*  472 */       tError.functionName = "decode";
/*  473 */       tError.errorMessage = ex.toString();
/*  474 */       this.mErrors.addOneError(tError);
/*      */ 
/*  476 */       return false;
/*      */     }
/*  478 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  484 */     String strReturn = "";
/*  485 */     if (FCode.equalsIgnoreCase("comCode"))
/*      */     {
/*  487 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.comCode));
/*      */     }
/*  489 */     if (FCode.equalsIgnoreCase("outComCode"))
/*      */     {
/*  491 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.outComCode));
/*      */     }
/*  493 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/*  495 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.name));
/*      */     }
/*  497 */     if (FCode.equalsIgnoreCase("shortName"))
/*      */     {
/*  499 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.shortName));
/*      */     }
/*  501 */     if (FCode.equalsIgnoreCase("address"))
/*      */     {
/*  503 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.address));
/*      */     }
/*  505 */     if (FCode.equalsIgnoreCase("zipCode"))
/*      */     {
/*  507 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.zipCode));
/*      */     }
/*  509 */     if (FCode.equalsIgnoreCase("phone"))
/*      */     {
/*  511 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.phone));
/*      */     }
/*  513 */     if (FCode.equalsIgnoreCase("fax"))
/*      */     {
/*  515 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.fax));
/*      */     }
/*  517 */     if (FCode.equalsIgnoreCase("eMail"))
/*      */     {
/*  519 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.eMail));
/*      */     }
/*  521 */     if (FCode.equalsIgnoreCase("webAddress"))
/*      */     {
/*  523 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.webAddress));
/*      */     }
/*  525 */     if (FCode.equalsIgnoreCase("satrapName"))
/*      */     {
/*  527 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.satrapName));
/*      */     }
/*  529 */     if (FCode.equalsIgnoreCase("insuMonitorCode"))
/*      */     {
/*  531 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuMonitorCode));
/*      */     }
/*  533 */     if (FCode.equalsIgnoreCase("insureID"))
/*      */     {
/*  535 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insureID));
/*      */     }
/*  537 */     if (FCode.equalsIgnoreCase("signID"))
/*      */     {
/*  539 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.signID));
/*      */     }
/*  541 */     if (FCode.equalsIgnoreCase("country"))
/*      */     {
/*  543 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.country));
/*      */     }
/*  545 */     if (FCode.equalsIgnoreCase("province"))
/*      */     {
/*  547 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.province));
/*      */     }
/*  549 */     if (FCode.equalsIgnoreCase("city"))
/*      */     {
/*  551 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.city));
/*      */     }
/*  553 */     if (FCode.equalsIgnoreCase("comNature"))
/*      */     {
/*  555 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.comNature));
/*      */     }
/*  557 */     if (FCode.equalsIgnoreCase("validCode"))
/*      */     {
/*  559 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.validCode));
/*      */     }
/*  561 */     if (FCode.equalsIgnoreCase("sign"))
/*      */     {
/*  563 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sign));
/*      */     }
/*  565 */     if (strReturn.equals(""))
/*      */     {
/*  567 */       strReturn = "null";
/*      */     }
/*      */ 
/*  570 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  577 */     String strFieldValue = "";
/*  578 */     switch (nFieldIndex) {
/*      */     case 0:
/*  580 */       strFieldValue = StrTool.GBKToUnicode(this.comCode);
/*  581 */       break;
/*      */     case 1:
/*  583 */       strFieldValue = StrTool.GBKToUnicode(this.outComCode);
/*  584 */       break;
/*      */     case 2:
/*  586 */       strFieldValue = StrTool.GBKToUnicode(this.name);
/*  587 */       break;
/*      */     case 3:
/*  589 */       strFieldValue = StrTool.GBKToUnicode(this.shortName);
/*  590 */       break;
/*      */     case 4:
/*  592 */       strFieldValue = StrTool.GBKToUnicode(this.address);
/*  593 */       break;
/*      */     case 5:
/*  595 */       strFieldValue = StrTool.GBKToUnicode(this.zipCode);
/*  596 */       break;
/*      */     case 6:
/*  598 */       strFieldValue = StrTool.GBKToUnicode(this.phone);
/*  599 */       break;
/*      */     case 7:
/*  601 */       strFieldValue = StrTool.GBKToUnicode(this.fax);
/*  602 */       break;
/*      */     case 8:
/*  604 */       strFieldValue = StrTool.GBKToUnicode(this.eMail);
/*  605 */       break;
/*      */     case 9:
/*  607 */       strFieldValue = StrTool.GBKToUnicode(this.webAddress);
/*  608 */       break;
/*      */     case 10:
/*  610 */       strFieldValue = StrTool.GBKToUnicode(this.satrapName);
/*  611 */       break;
/*      */     case 11:
/*  613 */       strFieldValue = StrTool.GBKToUnicode(this.insuMonitorCode);
/*  614 */       break;
/*      */     case 12:
/*  616 */       strFieldValue = StrTool.GBKToUnicode(this.insureID);
/*  617 */       break;
/*      */     case 13:
/*  619 */       strFieldValue = StrTool.GBKToUnicode(this.signID);
/*  620 */       break;
/*      */     case 14:
/*  622 */       strFieldValue = StrTool.GBKToUnicode(this.country);
/*  623 */       break;
/*      */     case 15:
/*  625 */       strFieldValue = StrTool.GBKToUnicode(this.province);
/*  626 */       break;
/*      */     case 16:
/*  628 */       strFieldValue = StrTool.GBKToUnicode(this.city);
/*  629 */       break;
/*      */     case 17:
/*  631 */       strFieldValue = StrTool.GBKToUnicode(this.comNature);
/*  632 */       break;
/*      */     case 18:
/*  634 */       strFieldValue = StrTool.GBKToUnicode(this.validCode);
/*  635 */       break;
/*      */     case 19:
/*  637 */       strFieldValue = StrTool.GBKToUnicode(this.sign);
/*  638 */       break;
/*      */     default:
/*  640 */       strFieldValue = "";
/*      */     }
/*  642 */     if (strFieldValue.equals("")) {
/*  643 */       strFieldValue = "null";
/*      */     }
/*  645 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  651 */     if (StrTool.cTrim(FCode).equals("")) {
/*  652 */       return false;
/*      */     }
/*  654 */     if (FCode.equalsIgnoreCase("comCode"))
/*      */     {
/*  656 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  658 */         this.comCode = FValue.trim();
/*      */       }
/*      */       else
/*  661 */         this.comCode = null;
/*      */     }
/*  663 */     if (FCode.equalsIgnoreCase("outComCode"))
/*      */     {
/*  665 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  667 */         this.outComCode = FValue.trim();
/*      */       }
/*      */       else
/*  670 */         this.outComCode = null;
/*      */     }
/*  672 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/*  674 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  676 */         this.name = FValue.trim();
/*      */       }
/*      */       else
/*  679 */         this.name = null;
/*      */     }
/*  681 */     if (FCode.equalsIgnoreCase("shortName"))
/*      */     {
/*  683 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  685 */         this.shortName = FValue.trim();
/*      */       }
/*      */       else
/*  688 */         this.shortName = null;
/*      */     }
/*  690 */     if (FCode.equalsIgnoreCase("address"))
/*      */     {
/*  692 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  694 */         this.address = FValue.trim();
/*      */       }
/*      */       else
/*  697 */         this.address = null;
/*      */     }
/*  699 */     if (FCode.equalsIgnoreCase("zipCode"))
/*      */     {
/*  701 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  703 */         this.zipCode = FValue.trim();
/*      */       }
/*      */       else
/*  706 */         this.zipCode = null;
/*      */     }
/*  708 */     if (FCode.equalsIgnoreCase("phone"))
/*      */     {
/*  710 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  712 */         this.phone = FValue.trim();
/*      */       }
/*      */       else
/*  715 */         this.phone = null;
/*      */     }
/*  717 */     if (FCode.equalsIgnoreCase("fax"))
/*      */     {
/*  719 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  721 */         this.fax = FValue.trim();
/*      */       }
/*      */       else
/*  724 */         this.fax = null;
/*      */     }
/*  726 */     if (FCode.equalsIgnoreCase("eMail"))
/*      */     {
/*  728 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  730 */         this.eMail = FValue.trim();
/*      */       }
/*      */       else
/*  733 */         this.eMail = null;
/*      */     }
/*  735 */     if (FCode.equalsIgnoreCase("webAddress"))
/*      */     {
/*  737 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  739 */         this.webAddress = FValue.trim();
/*      */       }
/*      */       else
/*  742 */         this.webAddress = null;
/*      */     }
/*  744 */     if (FCode.equalsIgnoreCase("satrapName"))
/*      */     {
/*  746 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  748 */         this.satrapName = FValue.trim();
/*      */       }
/*      */       else
/*  751 */         this.satrapName = null;
/*      */     }
/*  753 */     if (FCode.equalsIgnoreCase("insuMonitorCode"))
/*      */     {
/*  755 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  757 */         this.insuMonitorCode = FValue.trim();
/*      */       }
/*      */       else
/*  760 */         this.insuMonitorCode = null;
/*      */     }
/*  762 */     if (FCode.equalsIgnoreCase("insureID"))
/*      */     {
/*  764 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  766 */         this.insureID = FValue.trim();
/*      */       }
/*      */       else
/*  769 */         this.insureID = null;
/*      */     }
/*  771 */     if (FCode.equalsIgnoreCase("signID"))
/*      */     {
/*  773 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  775 */         this.signID = FValue.trim();
/*      */       }
/*      */       else
/*  778 */         this.signID = null;
/*      */     }
/*  780 */     if (FCode.equalsIgnoreCase("country"))
/*      */     {
/*  782 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  784 */         this.country = FValue.trim();
/*      */       }
/*      */       else
/*  787 */         this.country = null;
/*      */     }
/*  789 */     if (FCode.equalsIgnoreCase("province"))
/*      */     {
/*  791 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  793 */         this.province = FValue.trim();
/*      */       }
/*      */       else
/*  796 */         this.province = null;
/*      */     }
/*  798 */     if (FCode.equalsIgnoreCase("city"))
/*      */     {
/*  800 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  802 */         this.city = FValue.trim();
/*      */       }
/*      */       else
/*  805 */         this.city = null;
/*      */     }
/*  807 */     if (FCode.equalsIgnoreCase("comNature"))
/*      */     {
/*  809 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  811 */         this.comNature = FValue.trim();
/*      */       }
/*      */       else
/*  814 */         this.comNature = null;
/*      */     }
/*  816 */     if (FCode.equalsIgnoreCase("validCode"))
/*      */     {
/*  818 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  820 */         this.validCode = FValue.trim();
/*      */       }
/*      */       else
/*  823 */         this.validCode = null;
/*      */     }
/*  825 */     if (FCode.equalsIgnoreCase("sign"))
/*      */     {
/*  827 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  829 */         this.sign = FValue.trim();
/*      */       }
/*      */       else
/*  832 */         this.sign = null;
/*      */     }
/*  834 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  839 */     if (otherObject == null) return false;
/*  840 */     if (this == otherObject) return true;
/*  841 */     if (getClass() != otherObject.getClass()) return false;
/*  842 */     MComSchema other = (MComSchema)otherObject;
/*  843 */     if ((this.comCode == null) && (other.getComCode() != null)) return false;
/*  844 */     if ((this.comCode != null) && (!this.comCode.equals(other.getComCode()))) return false;
/*  845 */     if ((this.outComCode == null) && (other.getOutComCode() != null)) return false;
/*  846 */     if ((this.outComCode != null) && (!this.outComCode.equals(other.getOutComCode()))) return false;
/*  847 */     if ((this.name == null) && (other.getName() != null)) return false;
/*  848 */     if ((this.name != null) && (!this.name.equals(other.getName()))) return false;
/*  849 */     if ((this.shortName == null) && (other.getShortName() != null)) return false;
/*  850 */     if ((this.shortName != null) && (!this.shortName.equals(other.getShortName()))) return false;
/*  851 */     if ((this.address == null) && (other.getAddress() != null)) return false;
/*  852 */     if ((this.address != null) && (!this.address.equals(other.getAddress()))) return false;
/*  853 */     if ((this.zipCode == null) && (other.getZipCode() != null)) return false;
/*  854 */     if ((this.zipCode != null) && (!this.zipCode.equals(other.getZipCode()))) return false;
/*  855 */     if ((this.phone == null) && (other.getPhone() != null)) return false;
/*  856 */     if ((this.phone != null) && (!this.phone.equals(other.getPhone()))) return false;
/*  857 */     if ((this.fax == null) && (other.getFax() != null)) return false;
/*  858 */     if ((this.fax != null) && (!this.fax.equals(other.getFax()))) return false;
/*  859 */     if ((this.eMail == null) && (other.getEMail() != null)) return false;
/*  860 */     if ((this.eMail != null) && (!this.eMail.equals(other.getEMail()))) return false;
/*  861 */     if ((this.webAddress == null) && (other.getWebAddress() != null)) return false;
/*  862 */     if ((this.webAddress != null) && (!this.webAddress.equals(other.getWebAddress()))) return false;
/*  863 */     if ((this.satrapName == null) && (other.getSatrapName() != null)) return false;
/*  864 */     if ((this.satrapName != null) && (!this.satrapName.equals(other.getSatrapName()))) return false;
/*  865 */     if ((this.insuMonitorCode == null) && (other.getInsuMonitorCode() != null)) return false;
/*  866 */     if ((this.insuMonitorCode != null) && (!this.insuMonitorCode.equals(other.getInsuMonitorCode()))) return false;
/*  867 */     if ((this.insureID == null) && (other.getInsureID() != null)) return false;
/*  868 */     if ((this.insureID != null) && (!this.insureID.equals(other.getInsureID()))) return false;
/*  869 */     if ((this.signID == null) && (other.getSignID() != null)) return false;
/*  870 */     if ((this.signID != null) && (!this.signID.equals(other.getSignID()))) return false;
/*  871 */     if ((this.country == null) && (other.getCountry() != null)) return false;
/*  872 */     if ((this.country != null) && (!this.country.equals(other.getCountry()))) return false;
/*  873 */     if ((this.province == null) && (other.getProvince() != null)) return false;
/*  874 */     if ((this.province != null) && (!this.province.equals(other.getProvince()))) return false;
/*  875 */     if ((this.city == null) && (other.getCity() != null)) return false;
/*  876 */     if ((this.city != null) && (!this.city.equals(other.getCity()))) return false;
/*  877 */     if ((this.comNature == null) && (other.getComNature() != null)) return false;
/*  878 */     if ((this.comNature != null) && (!this.comNature.equals(other.getComNature()))) return false;
/*  879 */     if ((this.validCode == null) && (other.getValidCode() != null)) return false;
/*  880 */     if ((this.validCode != null) && (!this.validCode.equals(other.getValidCode()))) return false;
/*  881 */     if ((this.sign == null) && (other.getSign() != null)) return false;
/*  882 */     return (this.sign == null) || (this.sign.equals(other.getSign()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  889 */     return 20;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  895 */     if (strFieldName.equals("comCode")) {
/*  896 */       return 0;
/*      */     }
/*  898 */     if (strFieldName.equals("outComCode")) {
/*  899 */       return 1;
/*      */     }
/*  901 */     if (strFieldName.equals("name")) {
/*  902 */       return 2;
/*      */     }
/*  904 */     if (strFieldName.equals("shortName")) {
/*  905 */       return 3;
/*      */     }
/*  907 */     if (strFieldName.equals("address")) {
/*  908 */       return 4;
/*      */     }
/*  910 */     if (strFieldName.equals("zipCode")) {
/*  911 */       return 5;
/*      */     }
/*  913 */     if (strFieldName.equals("phone")) {
/*  914 */       return 6;
/*      */     }
/*  916 */     if (strFieldName.equals("fax")) {
/*  917 */       return 7;
/*      */     }
/*  919 */     if (strFieldName.equals("eMail")) {
/*  920 */       return 8;
/*      */     }
/*  922 */     if (strFieldName.equals("webAddress")) {
/*  923 */       return 9;
/*      */     }
/*  925 */     if (strFieldName.equals("satrapName")) {
/*  926 */       return 10;
/*      */     }
/*  928 */     if (strFieldName.equals("insuMonitorCode")) {
/*  929 */       return 11;
/*      */     }
/*  931 */     if (strFieldName.equals("insureID")) {
/*  932 */       return 12;
/*      */     }
/*  934 */     if (strFieldName.equals("signID")) {
/*  935 */       return 13;
/*      */     }
/*  937 */     if (strFieldName.equals("country")) {
/*  938 */       return 14;
/*      */     }
/*  940 */     if (strFieldName.equals("province")) {
/*  941 */       return 15;
/*      */     }
/*  943 */     if (strFieldName.equals("city")) {
/*  944 */       return 16;
/*      */     }
/*  946 */     if (strFieldName.equals("comNature")) {
/*  947 */       return 17;
/*      */     }
/*  949 */     if (strFieldName.equals("validCode")) {
/*  950 */       return 18;
/*      */     }
/*  952 */     if (strFieldName.equals("sign")) {
/*  953 */       return 19;
/*      */     }
/*  955 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/*  961 */     String strFieldName = "";
/*  962 */     switch (nFieldIndex) {
/*      */     case 0:
/*  964 */       strFieldName = "comCode";
/*  965 */       break;
/*      */     case 1:
/*  967 */       strFieldName = "outComCode";
/*  968 */       break;
/*      */     case 2:
/*  970 */       strFieldName = "name";
/*  971 */       break;
/*      */     case 3:
/*  973 */       strFieldName = "shortName";
/*  974 */       break;
/*      */     case 4:
/*  976 */       strFieldName = "address";
/*  977 */       break;
/*      */     case 5:
/*  979 */       strFieldName = "zipCode";
/*  980 */       break;
/*      */     case 6:
/*  982 */       strFieldName = "phone";
/*  983 */       break;
/*      */     case 7:
/*  985 */       strFieldName = "fax";
/*  986 */       break;
/*      */     case 8:
/*  988 */       strFieldName = "eMail";
/*  989 */       break;
/*      */     case 9:
/*  991 */       strFieldName = "webAddress";
/*  992 */       break;
/*      */     case 10:
/*  994 */       strFieldName = "satrapName";
/*  995 */       break;
/*      */     case 11:
/*  997 */       strFieldName = "insuMonitorCode";
/*  998 */       break;
/*      */     case 12:
/* 1000 */       strFieldName = "insureID";
/* 1001 */       break;
/*      */     case 13:
/* 1003 */       strFieldName = "signID";
/* 1004 */       break;
/*      */     case 14:
/* 1006 */       strFieldName = "country";
/* 1007 */       break;
/*      */     case 15:
/* 1009 */       strFieldName = "province";
/* 1010 */       break;
/*      */     case 16:
/* 1012 */       strFieldName = "city";
/* 1013 */       break;
/*      */     case 17:
/* 1015 */       strFieldName = "comNature";
/* 1016 */       break;
/*      */     case 18:
/* 1018 */       strFieldName = "validCode";
/* 1019 */       break;
/*      */     case 19:
/* 1021 */       strFieldName = "sign";
/* 1022 */       break;
/*      */     default:
/* 1024 */       strFieldName = "";
/*      */     }
/* 1026 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1032 */     if (strFieldName.equals("comCode")) {
/* 1033 */       return 0;
/*      */     }
/* 1035 */     if (strFieldName.equals("outComCode")) {
/* 1036 */       return 0;
/*      */     }
/* 1038 */     if (strFieldName.equals("name")) {
/* 1039 */       return 0;
/*      */     }
/* 1041 */     if (strFieldName.equals("shortName")) {
/* 1042 */       return 0;
/*      */     }
/* 1044 */     if (strFieldName.equals("address")) {
/* 1045 */       return 0;
/*      */     }
/* 1047 */     if (strFieldName.equals("zipCode")) {
/* 1048 */       return 0;
/*      */     }
/* 1050 */     if (strFieldName.equals("phone")) {
/* 1051 */       return 0;
/*      */     }
/* 1053 */     if (strFieldName.equals("fax")) {
/* 1054 */       return 0;
/*      */     }
/* 1056 */     if (strFieldName.equals("eMail")) {
/* 1057 */       return 0;
/*      */     }
/* 1059 */     if (strFieldName.equals("webAddress")) {
/* 1060 */       return 0;
/*      */     }
/* 1062 */     if (strFieldName.equals("satrapName")) {
/* 1063 */       return 0;
/*      */     }
/* 1065 */     if (strFieldName.equals("insuMonitorCode")) {
/* 1066 */       return 0;
/*      */     }
/* 1068 */     if (strFieldName.equals("insureID")) {
/* 1069 */       return 0;
/*      */     }
/* 1071 */     if (strFieldName.equals("signID")) {
/* 1072 */       return 0;
/*      */     }
/* 1074 */     if (strFieldName.equals("country")) {
/* 1075 */       return 0;
/*      */     }
/* 1077 */     if (strFieldName.equals("province")) {
/* 1078 */       return 0;
/*      */     }
/* 1080 */     if (strFieldName.equals("city")) {
/* 1081 */       return 0;
/*      */     }
/* 1083 */     if (strFieldName.equals("comNature")) {
/* 1084 */       return 0;
/*      */     }
/* 1086 */     if (strFieldName.equals("validCode")) {
/* 1087 */       return 0;
/*      */     }
/* 1089 */     if (strFieldName.equals("sign")) {
/* 1090 */       return 0;
/*      */     }
/* 1092 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1098 */     int nFieldType = -1;
/* 1099 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1101 */       nFieldType = 0;
/* 1102 */       break;
/*      */     case 1:
/* 1104 */       nFieldType = 0;
/* 1105 */       break;
/*      */     case 2:
/* 1107 */       nFieldType = 0;
/* 1108 */       break;
/*      */     case 3:
/* 1110 */       nFieldType = 0;
/* 1111 */       break;
/*      */     case 4:
/* 1113 */       nFieldType = 0;
/* 1114 */       break;
/*      */     case 5:
/* 1116 */       nFieldType = 0;
/* 1117 */       break;
/*      */     case 6:
/* 1119 */       nFieldType = 0;
/* 1120 */       break;
/*      */     case 7:
/* 1122 */       nFieldType = 0;
/* 1123 */       break;
/*      */     case 8:
/* 1125 */       nFieldType = 0;
/* 1126 */       break;
/*      */     case 9:
/* 1128 */       nFieldType = 0;
/* 1129 */       break;
/*      */     case 10:
/* 1131 */       nFieldType = 0;
/* 1132 */       break;
/*      */     case 11:
/* 1134 */       nFieldType = 0;
/* 1135 */       break;
/*      */     case 12:
/* 1137 */       nFieldType = 0;
/* 1138 */       break;
/*      */     case 13:
/* 1140 */       nFieldType = 0;
/* 1141 */       break;
/*      */     case 14:
/* 1143 */       nFieldType = 0;
/* 1144 */       break;
/*      */     case 15:
/* 1146 */       nFieldType = 0;
/* 1147 */       break;
/*      */     case 16:
/* 1149 */       nFieldType = 0;
/* 1150 */       break;
/*      */     case 17:
/* 1152 */       nFieldType = 0;
/* 1153 */       break;
/*      */     case 18:
/* 1155 */       nFieldType = 0;
/* 1156 */       break;
/*      */     case 19:
/* 1158 */       nFieldType = 0;
/* 1159 */       break;
/*      */     default:
/* 1161 */       nFieldType = -1;
/*      */     }
/* 1163 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MComSchema
 * JD-Core Version:    0.6.0
 */