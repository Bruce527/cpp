/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPComDB;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.Schema;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.io.PrintStream;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ 
/*      */ public class LNPComSchema
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
/*      */   public LNPComSchema()
/*      */   {
/*   72 */     this.mErrors = new CErrors();
/*      */ 
/*   74 */     String[] pk = new String[0];
/*      */ 
/*   76 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*   83 */     LNPComSchema cloned = (LNPComSchema)super.clone();
/*   84 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*   85 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*   91 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getComCode()
/*      */   {
/*   96 */     return this.comCode;
/*      */   }
/*      */ 
/*      */   public void setComCode(String aComCode) {
/*  100 */     this.comCode = aComCode;
/*      */   }
/*      */ 
/*      */   public String getOutComCode() {
/*  104 */     return this.outComCode;
/*      */   }
/*      */ 
/*      */   public void setOutComCode(String aOutComCode) {
/*  108 */     this.outComCode = aOutComCode;
/*      */   }
/*      */ 
/*      */   public String getName() {
/*  112 */     return this.name;
/*      */   }
/*      */ 
/*      */   public void setName(String aName) {
/*  116 */     this.name = aName;
/*      */   }
/*      */ 
/*      */   public String getShortName() {
/*  120 */     return this.shortName;
/*      */   }
/*      */ 
/*      */   public void setShortName(String aShortName) {
/*  124 */     this.shortName = aShortName;
/*      */   }
/*      */ 
/*      */   public String getAddress() {
/*  128 */     return this.address;
/*      */   }
/*      */ 
/*      */   public void setAddress(String aAddress) {
/*  132 */     this.address = aAddress;
/*      */   }
/*      */ 
/*      */   public String getZipCode() {
/*  136 */     return this.zipCode;
/*      */   }
/*      */ 
/*      */   public void setZipCode(String aZipCode) {
/*  140 */     this.zipCode = aZipCode;
/*      */   }
/*      */ 
/*      */   public String getPhone() {
/*  144 */     return this.phone;
/*      */   }
/*      */ 
/*      */   public void setPhone(String aPhone) {
/*  148 */     this.phone = aPhone;
/*      */   }
/*      */ 
/*      */   public String getFax() {
/*  152 */     return this.fax;
/*      */   }
/*      */ 
/*      */   public void setFax(String aFax) {
/*  156 */     this.fax = aFax;
/*      */   }
/*      */ 
/*      */   public String getEMail() {
/*  160 */     return this.eMail;
/*      */   }
/*      */ 
/*      */   public void setEMail(String aEMail) {
/*  164 */     this.eMail = aEMail;
/*      */   }
/*      */ 
/*      */   public String getWebAddress() {
/*  168 */     return this.webAddress;
/*      */   }
/*      */ 
/*      */   public void setWebAddress(String aWebAddress) {
/*  172 */     this.webAddress = aWebAddress;
/*      */   }
/*      */ 
/*      */   public String getSatrapName() {
/*  176 */     return this.satrapName;
/*      */   }
/*      */ 
/*      */   public void setSatrapName(String aSatrapName) {
/*  180 */     this.satrapName = aSatrapName;
/*      */   }
/*      */ 
/*      */   public String getInsuMonitorCode() {
/*  184 */     return this.insuMonitorCode;
/*      */   }
/*      */ 
/*      */   public void setInsuMonitorCode(String aInsuMonitorCode) {
/*  188 */     this.insuMonitorCode = aInsuMonitorCode;
/*      */   }
/*      */ 
/*      */   public String getInsureID() {
/*  192 */     return this.insureID;
/*      */   }
/*      */ 
/*      */   public void setInsureID(String aInsureID) {
/*  196 */     this.insureID = aInsureID;
/*      */   }
/*      */ 
/*      */   public String getSignID() {
/*  200 */     return this.signID;
/*      */   }
/*      */ 
/*      */   public void setSignID(String aSignID) {
/*  204 */     this.signID = aSignID;
/*      */   }
/*      */ 
/*      */   public String getCountry() {
/*  208 */     return this.country;
/*      */   }
/*      */ 
/*      */   public void setCountry(String aCountry) {
/*  212 */     this.country = aCountry;
/*      */   }
/*      */ 
/*      */   public String getProvince() {
/*  216 */     return this.province;
/*      */   }
/*      */ 
/*      */   public void setProvince(String aProvince) {
/*  220 */     this.province = aProvince;
/*      */   }
/*      */ 
/*      */   public String getCity() {
/*  224 */     return this.city;
/*      */   }
/*      */ 
/*      */   public void setCity(String aCity) {
/*  228 */     this.city = aCity;
/*      */   }
/*      */ 
/*      */   public String getComNature() {
/*  232 */     return this.comNature;
/*      */   }
/*      */ 
/*      */   public void setComNature(String aComNature) {
/*  236 */     this.comNature = aComNature;
/*      */   }
/*      */ 
/*      */   public String getValidCode() {
/*  240 */     return this.validCode;
/*      */   }
/*      */ 
/*      */   public void setValidCode(String aValidCode) {
/*  244 */     this.validCode = aValidCode;
/*      */   }
/*      */ 
/*      */   public String getSign() {
/*  248 */     return this.sign;
/*      */   }
/*      */ 
/*      */   public void setSign(String aSign) {
/*  252 */     this.sign = aSign;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPComSchema aLNPComSchema)
/*      */   {
/*  258 */     this.comCode = aLNPComSchema.getComCode();
/*  259 */     this.outComCode = aLNPComSchema.getOutComCode();
/*  260 */     this.name = aLNPComSchema.getName();
/*  261 */     this.shortName = aLNPComSchema.getShortName();
/*  262 */     this.address = aLNPComSchema.getAddress();
/*  263 */     this.zipCode = aLNPComSchema.getZipCode();
/*  264 */     this.phone = aLNPComSchema.getPhone();
/*  265 */     this.fax = aLNPComSchema.getFax();
/*  266 */     this.eMail = aLNPComSchema.getEMail();
/*  267 */     this.webAddress = aLNPComSchema.getWebAddress();
/*  268 */     this.satrapName = aLNPComSchema.getSatrapName();
/*  269 */     this.insuMonitorCode = aLNPComSchema.getInsuMonitorCode();
/*  270 */     this.insureID = aLNPComSchema.getInsureID();
/*  271 */     this.signID = aLNPComSchema.getSignID();
/*  272 */     this.country = aLNPComSchema.getCountry();
/*  273 */     this.province = aLNPComSchema.getProvince();
/*  274 */     this.city = aLNPComSchema.getCity();
/*  275 */     this.comNature = aLNPComSchema.getComNature();
/*  276 */     this.validCode = aLNPComSchema.getValidCode();
/*  277 */     this.sign = aLNPComSchema.getSign();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  286 */       if (rs.getString("ComCode") == null)
/*  287 */         this.comCode = null;
/*      */       else {
/*  289 */         this.comCode = rs.getString("ComCode").trim();
/*      */       }
/*  291 */       if (rs.getString("OutComCode") == null)
/*  292 */         this.outComCode = null;
/*      */       else {
/*  294 */         this.outComCode = rs.getString("OutComCode").trim();
/*      */       }
/*  296 */       if (rs.getString("Name") == null)
/*  297 */         this.name = null;
/*      */       else {
/*  299 */         this.name = rs.getString("Name").trim();
/*      */       }
/*  301 */       if (rs.getString("ShortName") == null)
/*  302 */         this.shortName = null;
/*      */       else {
/*  304 */         this.shortName = rs.getString("ShortName").trim();
/*      */       }
/*  306 */       if (rs.getString("Address") == null)
/*  307 */         this.address = null;
/*      */       else {
/*  309 */         this.address = rs.getString("Address").trim();
/*      */       }
/*  311 */       if (rs.getString("ZipCode") == null)
/*  312 */         this.zipCode = null;
/*      */       else {
/*  314 */         this.zipCode = rs.getString("ZipCode").trim();
/*      */       }
/*  316 */       if (rs.getString("Phone") == null)
/*  317 */         this.phone = null;
/*      */       else {
/*  319 */         this.phone = rs.getString("Phone").trim();
/*      */       }
/*  321 */       if (rs.getString("Fax") == null)
/*  322 */         this.fax = null;
/*      */       else {
/*  324 */         this.fax = rs.getString("Fax").trim();
/*      */       }
/*  326 */       if (rs.getString("EMail") == null)
/*  327 */         this.eMail = null;
/*      */       else {
/*  329 */         this.eMail = rs.getString("EMail").trim();
/*      */       }
/*  331 */       if (rs.getString("WebAddress") == null)
/*  332 */         this.webAddress = null;
/*      */       else {
/*  334 */         this.webAddress = rs.getString("WebAddress").trim();
/*      */       }
/*  336 */       if (rs.getString("SatrapName") == null)
/*  337 */         this.satrapName = null;
/*      */       else {
/*  339 */         this.satrapName = rs.getString("SatrapName").trim();
/*      */       }
/*  341 */       if (rs.getString("InsuMonitorCode") == null)
/*  342 */         this.insuMonitorCode = null;
/*      */       else {
/*  344 */         this.insuMonitorCode = rs.getString("InsuMonitorCode").trim();
/*      */       }
/*  346 */       if (rs.getString("InsureID") == null)
/*  347 */         this.insureID = null;
/*      */       else {
/*  349 */         this.insureID = rs.getString("InsureID").trim();
/*      */       }
/*  351 */       if (rs.getString("SignID") == null)
/*  352 */         this.signID = null;
/*      */       else {
/*  354 */         this.signID = rs.getString("SignID").trim();
/*      */       }
/*  356 */       if (rs.getString("Country") == null)
/*  357 */         this.country = null;
/*      */       else {
/*  359 */         this.country = rs.getString("Country").trim();
/*      */       }
/*  361 */       if (rs.getString("Province") == null)
/*  362 */         this.province = null;
/*      */       else {
/*  364 */         this.province = rs.getString("Province").trim();
/*      */       }
/*  366 */       if (rs.getString("City") == null)
/*  367 */         this.city = null;
/*      */       else {
/*  369 */         this.city = rs.getString("City").trim();
/*      */       }
/*  371 */       if (rs.getString("ComNature") == null)
/*  372 */         this.comNature = null;
/*      */       else {
/*  374 */         this.comNature = rs.getString("ComNature").trim();
/*      */       }
/*  376 */       if (rs.getString("ValidCode") == null)
/*  377 */         this.validCode = null;
/*      */       else {
/*  379 */         this.validCode = rs.getString("ValidCode").trim();
/*      */       }
/*  381 */       if (rs.getString("Sign") == null)
/*  382 */         this.sign = null;
/*      */       else {
/*  384 */         this.sign = rs.getString("Sign").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  389 */       System.out.println("\u93C1\u7248\u5D41\u6434\u64B2\u8151\u9428\u51E9NPCom\u741B\u3125\u74E7\u5A08\u5178\u91DC\u93C1\u677F\u62F0Schema\u6D93\uE160\u6B91\u701B\u6941\uE18C\u6D93\uE045\u669F\u6D93\u5D84\u7AF4\u9477\u8FBE\u7D1D\u93B4\u682C\uFFFD\u546E\u58BD\u741B\u5B92b.executeQuery\u93CC\u30E8\uE1D7\u93C3\u8235\u75C5\u93C8\u5909\u5A07\u9422\u256Felect * from tables");
/*      */ 
/*  391 */       CError tError = new CError();
/*  392 */       tError.moduleName = "LNPComSchema";
/*  393 */       tError.functionName = "setSchema";
/*  394 */       tError.errorMessage = sqle.toString();
/*  395 */       this.mErrors.addOneError(tError);
/*  396 */       return false;
/*      */     }
/*  398 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPComSchema getSchema()
/*      */   {
/*  403 */     LNPComSchema aLNPComSchema = new LNPComSchema();
/*  404 */     aLNPComSchema.setSchema(this);
/*  405 */     return aLNPComSchema;
/*      */   }
/*      */ 
/*      */   public LNPComDB getDB()
/*      */   {
/*  410 */     LNPComDB aDBOper = new LNPComDB();
/*  411 */     aDBOper.setSchema(this);
/*  412 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  419 */     StringBuffer strReturn = new StringBuffer(256);
/*  420 */     strReturn.append(StrTool.cTrim(this.comCode)); strReturn.append("|");
/*  421 */     strReturn.append(StrTool.cTrim(this.outComCode)); strReturn.append("|");
/*  422 */     strReturn.append(StrTool.cTrim(this.name)); strReturn.append("|");
/*  423 */     strReturn.append(StrTool.cTrim(this.shortName)); strReturn.append("|");
/*  424 */     strReturn.append(StrTool.cTrim(this.address)); strReturn.append("|");
/*  425 */     strReturn.append(StrTool.cTrim(this.zipCode)); strReturn.append("|");
/*  426 */     strReturn.append(StrTool.cTrim(this.phone)); strReturn.append("|");
/*  427 */     strReturn.append(StrTool.cTrim(this.fax)); strReturn.append("|");
/*  428 */     strReturn.append(StrTool.cTrim(this.eMail)); strReturn.append("|");
/*  429 */     strReturn.append(StrTool.cTrim(this.webAddress)); strReturn.append("|");
/*  430 */     strReturn.append(StrTool.cTrim(this.satrapName)); strReturn.append("|");
/*  431 */     strReturn.append(StrTool.cTrim(this.insuMonitorCode)); strReturn.append("|");
/*  432 */     strReturn.append(StrTool.cTrim(this.insureID)); strReturn.append("|");
/*  433 */     strReturn.append(StrTool.cTrim(this.signID)); strReturn.append("|");
/*  434 */     strReturn.append(StrTool.cTrim(this.country)); strReturn.append("|");
/*  435 */     strReturn.append(StrTool.cTrim(this.province)); strReturn.append("|");
/*  436 */     strReturn.append(StrTool.cTrim(this.city)); strReturn.append("|");
/*  437 */     strReturn.append(StrTool.cTrim(this.comNature)); strReturn.append("|");
/*  438 */     strReturn.append(StrTool.cTrim(this.validCode)); strReturn.append("|");
/*  439 */     strReturn.append(StrTool.cTrim(this.sign));
/*  440 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  448 */       this.comCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  449 */       this.outComCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  450 */       this.name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  451 */       this.shortName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  452 */       this.address = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  453 */       this.zipCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  454 */       this.phone = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  455 */       this.fax = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  456 */       this.eMail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  457 */       this.webAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  458 */       this.satrapName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  459 */       this.insuMonitorCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  460 */       this.insureID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  461 */       this.signID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  462 */       this.country = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  463 */       this.province = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  464 */       this.city = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  465 */       this.comNature = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  466 */       this.validCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  467 */       this.sign = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  472 */       CError tError = new CError();
/*  473 */       tError.moduleName = "LNPComSchema";
/*  474 */       tError.functionName = "decode";
/*  475 */       tError.errorMessage = ex.toString();
/*  476 */       this.mErrors.addOneError(tError);
/*      */ 
/*  478 */       return false;
/*      */     }
/*  480 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  486 */     String strReturn = "";
/*  487 */     if (FCode.equalsIgnoreCase("comCode"))
/*      */     {
/*  489 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.comCode));
/*      */     }
/*  491 */     if (FCode.equalsIgnoreCase("outComCode"))
/*      */     {
/*  493 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.outComCode));
/*      */     }
/*  495 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/*  497 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.name));
/*      */     }
/*  499 */     if (FCode.equalsIgnoreCase("shortName"))
/*      */     {
/*  501 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.shortName));
/*      */     }
/*  503 */     if (FCode.equalsIgnoreCase("address"))
/*      */     {
/*  505 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.address));
/*      */     }
/*  507 */     if (FCode.equalsIgnoreCase("zipCode"))
/*      */     {
/*  509 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.zipCode));
/*      */     }
/*  511 */     if (FCode.equalsIgnoreCase("phone"))
/*      */     {
/*  513 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.phone));
/*      */     }
/*  515 */     if (FCode.equalsIgnoreCase("fax"))
/*      */     {
/*  517 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.fax));
/*      */     }
/*  519 */     if (FCode.equalsIgnoreCase("eMail"))
/*      */     {
/*  521 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.eMail));
/*      */     }
/*  523 */     if (FCode.equalsIgnoreCase("webAddress"))
/*      */     {
/*  525 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.webAddress));
/*      */     }
/*  527 */     if (FCode.equalsIgnoreCase("satrapName"))
/*      */     {
/*  529 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.satrapName));
/*      */     }
/*  531 */     if (FCode.equalsIgnoreCase("insuMonitorCode"))
/*      */     {
/*  533 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insuMonitorCode));
/*      */     }
/*  535 */     if (FCode.equalsIgnoreCase("insureID"))
/*      */     {
/*  537 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.insureID));
/*      */     }
/*  539 */     if (FCode.equalsIgnoreCase("signID"))
/*      */     {
/*  541 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.signID));
/*      */     }
/*  543 */     if (FCode.equalsIgnoreCase("country"))
/*      */     {
/*  545 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.country));
/*      */     }
/*  547 */     if (FCode.equalsIgnoreCase("province"))
/*      */     {
/*  549 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.province));
/*      */     }
/*  551 */     if (FCode.equalsIgnoreCase("city"))
/*      */     {
/*  553 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.city));
/*      */     }
/*  555 */     if (FCode.equalsIgnoreCase("comNature"))
/*      */     {
/*  557 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.comNature));
/*      */     }
/*  559 */     if (FCode.equalsIgnoreCase("validCode"))
/*      */     {
/*  561 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.validCode));
/*      */     }
/*  563 */     if (FCode.equalsIgnoreCase("sign"))
/*      */     {
/*  565 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sign));
/*      */     }
/*  567 */     if (strReturn.equals(""))
/*      */     {
/*  569 */       strReturn = "null";
/*      */     }
/*      */ 
/*  572 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  579 */     String strFieldValue = "";
/*  580 */     switch (nFieldIndex) {
/*      */     case 0:
/*  582 */       strFieldValue = StrTool.GBKToUnicode(this.comCode);
/*  583 */       break;
/*      */     case 1:
/*  585 */       strFieldValue = StrTool.GBKToUnicode(this.outComCode);
/*  586 */       break;
/*      */     case 2:
/*  588 */       strFieldValue = StrTool.GBKToUnicode(this.name);
/*  589 */       break;
/*      */     case 3:
/*  591 */       strFieldValue = StrTool.GBKToUnicode(this.shortName);
/*  592 */       break;
/*      */     case 4:
/*  594 */       strFieldValue = StrTool.GBKToUnicode(this.address);
/*  595 */       break;
/*      */     case 5:
/*  597 */       strFieldValue = StrTool.GBKToUnicode(this.zipCode);
/*  598 */       break;
/*      */     case 6:
/*  600 */       strFieldValue = StrTool.GBKToUnicode(this.phone);
/*  601 */       break;
/*      */     case 7:
/*  603 */       strFieldValue = StrTool.GBKToUnicode(this.fax);
/*  604 */       break;
/*      */     case 8:
/*  606 */       strFieldValue = StrTool.GBKToUnicode(this.eMail);
/*  607 */       break;
/*      */     case 9:
/*  609 */       strFieldValue = StrTool.GBKToUnicode(this.webAddress);
/*  610 */       break;
/*      */     case 10:
/*  612 */       strFieldValue = StrTool.GBKToUnicode(this.satrapName);
/*  613 */       break;
/*      */     case 11:
/*  615 */       strFieldValue = StrTool.GBKToUnicode(this.insuMonitorCode);
/*  616 */       break;
/*      */     case 12:
/*  618 */       strFieldValue = StrTool.GBKToUnicode(this.insureID);
/*  619 */       break;
/*      */     case 13:
/*  621 */       strFieldValue = StrTool.GBKToUnicode(this.signID);
/*  622 */       break;
/*      */     case 14:
/*  624 */       strFieldValue = StrTool.GBKToUnicode(this.country);
/*  625 */       break;
/*      */     case 15:
/*  627 */       strFieldValue = StrTool.GBKToUnicode(this.province);
/*  628 */       break;
/*      */     case 16:
/*  630 */       strFieldValue = StrTool.GBKToUnicode(this.city);
/*  631 */       break;
/*      */     case 17:
/*  633 */       strFieldValue = StrTool.GBKToUnicode(this.comNature);
/*  634 */       break;
/*      */     case 18:
/*  636 */       strFieldValue = StrTool.GBKToUnicode(this.validCode);
/*  637 */       break;
/*      */     case 19:
/*  639 */       strFieldValue = StrTool.GBKToUnicode(this.sign);
/*  640 */       break;
/*      */     default:
/*  642 */       strFieldValue = "";
/*      */     }
/*  644 */     if (strFieldValue.equals("")) {
/*  645 */       strFieldValue = "null";
/*      */     }
/*  647 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  653 */     if (StrTool.cTrim(FCode).equals("")) {
/*  654 */       return false;
/*      */     }
/*  656 */     if (FCode.equalsIgnoreCase("comCode"))
/*      */     {
/*  658 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  660 */         this.comCode = FValue.trim();
/*      */       }
/*      */       else
/*  663 */         this.comCode = null;
/*      */     }
/*  665 */     if (FCode.equalsIgnoreCase("outComCode"))
/*      */     {
/*  667 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  669 */         this.outComCode = FValue.trim();
/*      */       }
/*      */       else
/*  672 */         this.outComCode = null;
/*      */     }
/*  674 */     if (FCode.equalsIgnoreCase("name"))
/*      */     {
/*  676 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  678 */         this.name = FValue.trim();
/*      */       }
/*      */       else
/*  681 */         this.name = null;
/*      */     }
/*  683 */     if (FCode.equalsIgnoreCase("shortName"))
/*      */     {
/*  685 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  687 */         this.shortName = FValue.trim();
/*      */       }
/*      */       else
/*  690 */         this.shortName = null;
/*      */     }
/*  692 */     if (FCode.equalsIgnoreCase("address"))
/*      */     {
/*  694 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  696 */         this.address = FValue.trim();
/*      */       }
/*      */       else
/*  699 */         this.address = null;
/*      */     }
/*  701 */     if (FCode.equalsIgnoreCase("zipCode"))
/*      */     {
/*  703 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  705 */         this.zipCode = FValue.trim();
/*      */       }
/*      */       else
/*  708 */         this.zipCode = null;
/*      */     }
/*  710 */     if (FCode.equalsIgnoreCase("phone"))
/*      */     {
/*  712 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  714 */         this.phone = FValue.trim();
/*      */       }
/*      */       else
/*  717 */         this.phone = null;
/*      */     }
/*  719 */     if (FCode.equalsIgnoreCase("fax"))
/*      */     {
/*  721 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  723 */         this.fax = FValue.trim();
/*      */       }
/*      */       else
/*  726 */         this.fax = null;
/*      */     }
/*  728 */     if (FCode.equalsIgnoreCase("eMail"))
/*      */     {
/*  730 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  732 */         this.eMail = FValue.trim();
/*      */       }
/*      */       else
/*  735 */         this.eMail = null;
/*      */     }
/*  737 */     if (FCode.equalsIgnoreCase("webAddress"))
/*      */     {
/*  739 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  741 */         this.webAddress = FValue.trim();
/*      */       }
/*      */       else
/*  744 */         this.webAddress = null;
/*      */     }
/*  746 */     if (FCode.equalsIgnoreCase("satrapName"))
/*      */     {
/*  748 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  750 */         this.satrapName = FValue.trim();
/*      */       }
/*      */       else
/*  753 */         this.satrapName = null;
/*      */     }
/*  755 */     if (FCode.equalsIgnoreCase("insuMonitorCode"))
/*      */     {
/*  757 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  759 */         this.insuMonitorCode = FValue.trim();
/*      */       }
/*      */       else
/*  762 */         this.insuMonitorCode = null;
/*      */     }
/*  764 */     if (FCode.equalsIgnoreCase("insureID"))
/*      */     {
/*  766 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  768 */         this.insureID = FValue.trim();
/*      */       }
/*      */       else
/*  771 */         this.insureID = null;
/*      */     }
/*  773 */     if (FCode.equalsIgnoreCase("signID"))
/*      */     {
/*  775 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  777 */         this.signID = FValue.trim();
/*      */       }
/*      */       else
/*  780 */         this.signID = null;
/*      */     }
/*  782 */     if (FCode.equalsIgnoreCase("country"))
/*      */     {
/*  784 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  786 */         this.country = FValue.trim();
/*      */       }
/*      */       else
/*  789 */         this.country = null;
/*      */     }
/*  791 */     if (FCode.equalsIgnoreCase("province"))
/*      */     {
/*  793 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  795 */         this.province = FValue.trim();
/*      */       }
/*      */       else
/*  798 */         this.province = null;
/*      */     }
/*  800 */     if (FCode.equalsIgnoreCase("city"))
/*      */     {
/*  802 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  804 */         this.city = FValue.trim();
/*      */       }
/*      */       else
/*  807 */         this.city = null;
/*      */     }
/*  809 */     if (FCode.equalsIgnoreCase("comNature"))
/*      */     {
/*  811 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  813 */         this.comNature = FValue.trim();
/*      */       }
/*      */       else
/*  816 */         this.comNature = null;
/*      */     }
/*  818 */     if (FCode.equalsIgnoreCase("validCode"))
/*      */     {
/*  820 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  822 */         this.validCode = FValue.trim();
/*      */       }
/*      */       else
/*  825 */         this.validCode = null;
/*      */     }
/*  827 */     if (FCode.equalsIgnoreCase("sign"))
/*      */     {
/*  829 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  831 */         this.sign = FValue.trim();
/*      */       }
/*      */       else
/*  834 */         this.sign = null;
/*      */     }
/*  836 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  841 */     if (otherObject == null) return false;
/*  842 */     if (this == otherObject) return true;
/*  843 */     if (getClass() != otherObject.getClass()) return false;
/*  844 */     LNPComSchema other = (LNPComSchema)otherObject;
/*  845 */     if ((this.comCode == null) && (other.getComCode() != null)) return false;
/*  846 */     if ((this.comCode != null) && (!this.comCode.equals(other.getComCode()))) return false;
/*  847 */     if ((this.outComCode == null) && (other.getOutComCode() != null)) return false;
/*  848 */     if ((this.outComCode != null) && (!this.outComCode.equals(other.getOutComCode()))) return false;
/*  849 */     if ((this.name == null) && (other.getName() != null)) return false;
/*  850 */     if ((this.name != null) && (!this.name.equals(other.getName()))) return false;
/*  851 */     if ((this.shortName == null) && (other.getShortName() != null)) return false;
/*  852 */     if ((this.shortName != null) && (!this.shortName.equals(other.getShortName()))) return false;
/*  853 */     if ((this.address == null) && (other.getAddress() != null)) return false;
/*  854 */     if ((this.address != null) && (!this.address.equals(other.getAddress()))) return false;
/*  855 */     if ((this.zipCode == null) && (other.getZipCode() != null)) return false;
/*  856 */     if ((this.zipCode != null) && (!this.zipCode.equals(other.getZipCode()))) return false;
/*  857 */     if ((this.phone == null) && (other.getPhone() != null)) return false;
/*  858 */     if ((this.phone != null) && (!this.phone.equals(other.getPhone()))) return false;
/*  859 */     if ((this.fax == null) && (other.getFax() != null)) return false;
/*  860 */     if ((this.fax != null) && (!this.fax.equals(other.getFax()))) return false;
/*  861 */     if ((this.eMail == null) && (other.getEMail() != null)) return false;
/*  862 */     if ((this.eMail != null) && (!this.eMail.equals(other.getEMail()))) return false;
/*  863 */     if ((this.webAddress == null) && (other.getWebAddress() != null)) return false;
/*  864 */     if ((this.webAddress != null) && (!this.webAddress.equals(other.getWebAddress()))) return false;
/*  865 */     if ((this.satrapName == null) && (other.getSatrapName() != null)) return false;
/*  866 */     if ((this.satrapName != null) && (!this.satrapName.equals(other.getSatrapName()))) return false;
/*  867 */     if ((this.insuMonitorCode == null) && (other.getInsuMonitorCode() != null)) return false;
/*  868 */     if ((this.insuMonitorCode != null) && (!this.insuMonitorCode.equals(other.getInsuMonitorCode()))) return false;
/*  869 */     if ((this.insureID == null) && (other.getInsureID() != null)) return false;
/*  870 */     if ((this.insureID != null) && (!this.insureID.equals(other.getInsureID()))) return false;
/*  871 */     if ((this.signID == null) && (other.getSignID() != null)) return false;
/*  872 */     if ((this.signID != null) && (!this.signID.equals(other.getSignID()))) return false;
/*  873 */     if ((this.country == null) && (other.getCountry() != null)) return false;
/*  874 */     if ((this.country != null) && (!this.country.equals(other.getCountry()))) return false;
/*  875 */     if ((this.province == null) && (other.getProvince() != null)) return false;
/*  876 */     if ((this.province != null) && (!this.province.equals(other.getProvince()))) return false;
/*  877 */     if ((this.city == null) && (other.getCity() != null)) return false;
/*  878 */     if ((this.city != null) && (!this.city.equals(other.getCity()))) return false;
/*  879 */     if ((this.comNature == null) && (other.getComNature() != null)) return false;
/*  880 */     if ((this.comNature != null) && (!this.comNature.equals(other.getComNature()))) return false;
/*  881 */     if ((this.validCode == null) && (other.getValidCode() != null)) return false;
/*  882 */     if ((this.validCode != null) && (!this.validCode.equals(other.getValidCode()))) return false;
/*  883 */     if ((this.sign == null) && (other.getSign() != null)) return false;
/*  884 */     return (this.sign == null) || (this.sign.equals(other.getSign()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/*  891 */     return 20;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/*  897 */     if (strFieldName.equals("comCode")) {
/*  898 */       return 0;
/*      */     }
/*  900 */     if (strFieldName.equals("outComCode")) {
/*  901 */       return 1;
/*      */     }
/*  903 */     if (strFieldName.equals("name")) {
/*  904 */       return 2;
/*      */     }
/*  906 */     if (strFieldName.equals("shortName")) {
/*  907 */       return 3;
/*      */     }
/*  909 */     if (strFieldName.equals("address")) {
/*  910 */       return 4;
/*      */     }
/*  912 */     if (strFieldName.equals("zipCode")) {
/*  913 */       return 5;
/*      */     }
/*  915 */     if (strFieldName.equals("phone")) {
/*  916 */       return 6;
/*      */     }
/*  918 */     if (strFieldName.equals("fax")) {
/*  919 */       return 7;
/*      */     }
/*  921 */     if (strFieldName.equals("eMail")) {
/*  922 */       return 8;
/*      */     }
/*  924 */     if (strFieldName.equals("webAddress")) {
/*  925 */       return 9;
/*      */     }
/*  927 */     if (strFieldName.equals("satrapName")) {
/*  928 */       return 10;
/*      */     }
/*  930 */     if (strFieldName.equals("insuMonitorCode")) {
/*  931 */       return 11;
/*      */     }
/*  933 */     if (strFieldName.equals("insureID")) {
/*  934 */       return 12;
/*      */     }
/*  936 */     if (strFieldName.equals("signID")) {
/*  937 */       return 13;
/*      */     }
/*  939 */     if (strFieldName.equals("country")) {
/*  940 */       return 14;
/*      */     }
/*  942 */     if (strFieldName.equals("province")) {
/*  943 */       return 15;
/*      */     }
/*  945 */     if (strFieldName.equals("city")) {
/*  946 */       return 16;
/*      */     }
/*  948 */     if (strFieldName.equals("comNature")) {
/*  949 */       return 17;
/*      */     }
/*  951 */     if (strFieldName.equals("validCode")) {
/*  952 */       return 18;
/*      */     }
/*  954 */     if (strFieldName.equals("sign")) {
/*  955 */       return 19;
/*      */     }
/*  957 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/*  963 */     String strFieldName = "";
/*  964 */     switch (nFieldIndex) {
/*      */     case 0:
/*  966 */       strFieldName = "comCode";
/*  967 */       break;
/*      */     case 1:
/*  969 */       strFieldName = "outComCode";
/*  970 */       break;
/*      */     case 2:
/*  972 */       strFieldName = "name";
/*  973 */       break;
/*      */     case 3:
/*  975 */       strFieldName = "shortName";
/*  976 */       break;
/*      */     case 4:
/*  978 */       strFieldName = "address";
/*  979 */       break;
/*      */     case 5:
/*  981 */       strFieldName = "zipCode";
/*  982 */       break;
/*      */     case 6:
/*  984 */       strFieldName = "phone";
/*  985 */       break;
/*      */     case 7:
/*  987 */       strFieldName = "fax";
/*  988 */       break;
/*      */     case 8:
/*  990 */       strFieldName = "eMail";
/*  991 */       break;
/*      */     case 9:
/*  993 */       strFieldName = "webAddress";
/*  994 */       break;
/*      */     case 10:
/*  996 */       strFieldName = "satrapName";
/*  997 */       break;
/*      */     case 11:
/*  999 */       strFieldName = "insuMonitorCode";
/* 1000 */       break;
/*      */     case 12:
/* 1002 */       strFieldName = "insureID";
/* 1003 */       break;
/*      */     case 13:
/* 1005 */       strFieldName = "signID";
/* 1006 */       break;
/*      */     case 14:
/* 1008 */       strFieldName = "country";
/* 1009 */       break;
/*      */     case 15:
/* 1011 */       strFieldName = "province";
/* 1012 */       break;
/*      */     case 16:
/* 1014 */       strFieldName = "city";
/* 1015 */       break;
/*      */     case 17:
/* 1017 */       strFieldName = "comNature";
/* 1018 */       break;
/*      */     case 18:
/* 1020 */       strFieldName = "validCode";
/* 1021 */       break;
/*      */     case 19:
/* 1023 */       strFieldName = "sign";
/* 1024 */       break;
/*      */     default:
/* 1026 */       strFieldName = "";
/*      */     }
/* 1028 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1034 */     if (strFieldName.equals("comCode")) {
/* 1035 */       return 0;
/*      */     }
/* 1037 */     if (strFieldName.equals("outComCode")) {
/* 1038 */       return 0;
/*      */     }
/* 1040 */     if (strFieldName.equals("name")) {
/* 1041 */       return 0;
/*      */     }
/* 1043 */     if (strFieldName.equals("shortName")) {
/* 1044 */       return 0;
/*      */     }
/* 1046 */     if (strFieldName.equals("address")) {
/* 1047 */       return 0;
/*      */     }
/* 1049 */     if (strFieldName.equals("zipCode")) {
/* 1050 */       return 0;
/*      */     }
/* 1052 */     if (strFieldName.equals("phone")) {
/* 1053 */       return 0;
/*      */     }
/* 1055 */     if (strFieldName.equals("fax")) {
/* 1056 */       return 0;
/*      */     }
/* 1058 */     if (strFieldName.equals("eMail")) {
/* 1059 */       return 0;
/*      */     }
/* 1061 */     if (strFieldName.equals("webAddress")) {
/* 1062 */       return 0;
/*      */     }
/* 1064 */     if (strFieldName.equals("satrapName")) {
/* 1065 */       return 0;
/*      */     }
/* 1067 */     if (strFieldName.equals("insuMonitorCode")) {
/* 1068 */       return 0;
/*      */     }
/* 1070 */     if (strFieldName.equals("insureID")) {
/* 1071 */       return 0;
/*      */     }
/* 1073 */     if (strFieldName.equals("signID")) {
/* 1074 */       return 0;
/*      */     }
/* 1076 */     if (strFieldName.equals("country")) {
/* 1077 */       return 0;
/*      */     }
/* 1079 */     if (strFieldName.equals("province")) {
/* 1080 */       return 0;
/*      */     }
/* 1082 */     if (strFieldName.equals("city")) {
/* 1083 */       return 0;
/*      */     }
/* 1085 */     if (strFieldName.equals("comNature")) {
/* 1086 */       return 0;
/*      */     }
/* 1088 */     if (strFieldName.equals("validCode")) {
/* 1089 */       return 0;
/*      */     }
/* 1091 */     if (strFieldName.equals("sign")) {
/* 1092 */       return 0;
/*      */     }
/* 1094 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1100 */     int nFieldType = -1;
/* 1101 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1103 */       nFieldType = 0;
/* 1104 */       break;
/*      */     case 1:
/* 1106 */       nFieldType = 0;
/* 1107 */       break;
/*      */     case 2:
/* 1109 */       nFieldType = 0;
/* 1110 */       break;
/*      */     case 3:
/* 1112 */       nFieldType = 0;
/* 1113 */       break;
/*      */     case 4:
/* 1115 */       nFieldType = 0;
/* 1116 */       break;
/*      */     case 5:
/* 1118 */       nFieldType = 0;
/* 1119 */       break;
/*      */     case 6:
/* 1121 */       nFieldType = 0;
/* 1122 */       break;
/*      */     case 7:
/* 1124 */       nFieldType = 0;
/* 1125 */       break;
/*      */     case 8:
/* 1127 */       nFieldType = 0;
/* 1128 */       break;
/*      */     case 9:
/* 1130 */       nFieldType = 0;
/* 1131 */       break;
/*      */     case 10:
/* 1133 */       nFieldType = 0;
/* 1134 */       break;
/*      */     case 11:
/* 1136 */       nFieldType = 0;
/* 1137 */       break;
/*      */     case 12:
/* 1139 */       nFieldType = 0;
/* 1140 */       break;
/*      */     case 13:
/* 1142 */       nFieldType = 0;
/* 1143 */       break;
/*      */     case 14:
/* 1145 */       nFieldType = 0;
/* 1146 */       break;
/*      */     case 15:
/* 1148 */       nFieldType = 0;
/* 1149 */       break;
/*      */     case 16:
/* 1151 */       nFieldType = 0;
/* 1152 */       break;
/*      */     case 17:
/* 1154 */       nFieldType = 0;
/* 1155 */       break;
/*      */     case 18:
/* 1157 */       nFieldType = 0;
/* 1158 */       break;
/*      */     case 19:
/* 1160 */       nFieldType = 0;
/* 1161 */       break;
/*      */     default:
/* 1163 */       nFieldType = -1;
/*      */     }
/* 1165 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPComSchema
 * JD-Core Version:    0.6.0
 */