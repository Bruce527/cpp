/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPAddressDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.FDate;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.Schema;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.io.PrintStream;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.util.Date;
/*      */ 
/*      */ public class LNPAddressSchema
/*      */   implements Schema, Cloneable
/*      */ {
/*      */   private String customerId;
/*      */   private String customerNo;
/*      */   private String addressNo;
/*      */   private String postalAddress;
/*      */   private String zipCode;
/*      */   private String phone;
/*      */   private String fax;
/*      */   private String duchy;
/*      */   private String homeAddress;
/*      */   private String homeZipCode;
/*      */   private String homePhone;
/*      */   private String homeFax;
/*      */   private String companyAddress;
/*      */   private String companyZipCode;
/*      */   private String companyPhone;
/*      */   private String companyFax;
/*      */   private String companyMail;
/*      */   private String mobile;
/*      */   private String mobileChs;
/*      */   private String eMail;
/*      */   private String bP;
/*      */   private String mobile2;
/*      */   private String mobileChs2;
/*      */   private String eMail2;
/*      */   private String bP2;
/*      */   private String operator;
/*      */   private Date makeDate;
/*      */   private String makeTime;
/*      */   private Date modifyDate;
/*      */   private String modifyTime;
/*      */   private String grpName;
/*      */   private String otherDuchy;
/*      */   public static final int FIELDNUM = 32;
/*      */   private static String[] PK;
/*   91 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPAddressSchema()
/*      */   {
/*   98 */     this.mErrors = new CErrors();
/*      */ 
/*  100 */     String[] pk = new String[2];
/*  101 */     pk[0] = "CustomerId";
/*  102 */     pk[1] = "AddressNo";
/*      */ 
/*  104 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone()
/*      */     throws CloneNotSupportedException
/*      */   {
/*  111 */     LNPAddressSchema cloned = (LNPAddressSchema)super.clone();
/*  112 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  113 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  114 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  120 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getCustomerId()
/*      */   {
/*  125 */     return this.customerId;
/*      */   }
/*      */ 
/*      */   public void setCustomerId(String aCustomerId) {
/*  129 */     this.customerId = aCustomerId;
/*      */   }
/*      */ 
/*      */   public String getCustomerNo() {
/*  133 */     return this.customerNo;
/*      */   }
/*      */ 
/*      */   public void setCustomerNo(String aCustomerNo) {
/*  137 */     this.customerNo = aCustomerNo;
/*      */   }
/*      */ 
/*      */   public String getAddressNo() {
/*  141 */     return this.addressNo;
/*      */   }
/*      */ 
/*      */   public void setAddressNo(String aAddressNo) {
/*  145 */     this.addressNo = aAddressNo;
/*      */   }
/*      */ 
/*      */   public String getPostalAddress() {
/*  149 */     return this.postalAddress;
/*      */   }
/*      */ 
/*      */   public void setPostalAddress(String aPostalAddress) {
/*  153 */     this.postalAddress = aPostalAddress;
/*      */   }
/*      */ 
/*      */   public String getZipCode() {
/*  157 */     return this.zipCode;
/*      */   }
/*      */ 
/*      */   public void setZipCode(String aZipCode) {
/*  161 */     this.zipCode = aZipCode;
/*      */   }
/*      */ 
/*      */   public String getPhone() {
/*  165 */     return this.phone;
/*      */   }
/*      */ 
/*      */   public void setPhone(String aPhone) {
/*  169 */     this.phone = aPhone;
/*      */   }
/*      */ 
/*      */   public String getFax() {
/*  173 */     return this.fax;
/*      */   }
/*      */ 
/*      */   public void setFax(String aFax) {
/*  177 */     this.fax = aFax;
/*      */   }
/*      */ 
/*      */   public String getDuchy() {
/*  181 */     return this.duchy;
/*      */   }
/*      */ 
/*      */   public void setDuchy(String aDuchy) {
/*  185 */     this.duchy = aDuchy;
/*      */   }
/*      */ 
/*      */   public String getHomeAddress() {
/*  189 */     return this.homeAddress;
/*      */   }
/*      */ 
/*      */   public void setHomeAddress(String aHomeAddress) {
/*  193 */     this.homeAddress = aHomeAddress;
/*      */   }
/*      */ 
/*      */   public String getHomeZipCode() {
/*  197 */     return this.homeZipCode;
/*      */   }
/*      */ 
/*      */   public void setHomeZipCode(String aHomeZipCode) {
/*  201 */     this.homeZipCode = aHomeZipCode;
/*      */   }
/*      */ 
/*      */   public String getHomePhone() {
/*  205 */     return this.homePhone;
/*      */   }
/*      */ 
/*      */   public void setHomePhone(String aHomePhone) {
/*  209 */     this.homePhone = aHomePhone;
/*      */   }
/*      */ 
/*      */   public String getHomeFax() {
/*  213 */     return this.homeFax;
/*      */   }
/*      */ 
/*      */   public void setHomeFax(String aHomeFax) {
/*  217 */     this.homeFax = aHomeFax;
/*      */   }
/*      */ 
/*      */   public String getCompanyAddress() {
/*  221 */     return this.companyAddress;
/*      */   }
/*      */ 
/*      */   public void setCompanyAddress(String aCompanyAddress) {
/*  225 */     this.companyAddress = aCompanyAddress;
/*      */   }
/*      */ 
/*      */   public String getCompanyZipCode() {
/*  229 */     return this.companyZipCode;
/*      */   }
/*      */ 
/*      */   public void setCompanyZipCode(String aCompanyZipCode) {
/*  233 */     this.companyZipCode = aCompanyZipCode;
/*      */   }
/*      */ 
/*      */   public String getCompanyPhone() {
/*  237 */     return this.companyPhone;
/*      */   }
/*      */ 
/*      */   public void setCompanyPhone(String aCompanyPhone) {
/*  241 */     this.companyPhone = aCompanyPhone;
/*      */   }
/*      */ 
/*      */   public String getCompanyFax() {
/*  245 */     return this.companyFax;
/*      */   }
/*      */ 
/*      */   public void setCompanyFax(String aCompanyFax) {
/*  249 */     this.companyFax = aCompanyFax;
/*      */   }
/*      */ 
/*      */   public String getCompanyMail() {
/*  253 */     return this.companyMail;
/*      */   }
/*      */ 
/*      */   public void setCompanyMail(String aCompanyMail) {
/*  257 */     this.companyMail = aCompanyMail;
/*      */   }
/*      */ 
/*      */   public String getMobile() {
/*  261 */     return this.mobile;
/*      */   }
/*      */ 
/*      */   public void setMobile(String aMobile) {
/*  265 */     this.mobile = aMobile;
/*      */   }
/*      */ 
/*      */   public String getMobileChs() {
/*  269 */     return this.mobileChs;
/*      */   }
/*      */ 
/*      */   public void setMobileChs(String aMobileChs) {
/*  273 */     this.mobileChs = aMobileChs;
/*      */   }
/*      */ 
/*      */   public String getEMail() {
/*  277 */     return this.eMail;
/*      */   }
/*      */ 
/*      */   public void setEMail(String aEMail) {
/*  281 */     this.eMail = aEMail;
/*      */   }
/*      */ 
/*      */   public String getBP() {
/*  285 */     return this.bP;
/*      */   }
/*      */ 
/*      */   public void setBP(String aBP) {
/*  289 */     this.bP = aBP;
/*      */   }
/*      */ 
/*      */   public String getMobile2() {
/*  293 */     return this.mobile2;
/*      */   }
/*      */ 
/*      */   public void setMobile2(String aMobile2) {
/*  297 */     this.mobile2 = aMobile2;
/*      */   }
/*      */ 
/*      */   public String getMobileChs2() {
/*  301 */     return this.mobileChs2;
/*      */   }
/*      */ 
/*      */   public void setMobileChs2(String aMobileChs2) {
/*  305 */     this.mobileChs2 = aMobileChs2;
/*      */   }
/*      */ 
/*      */   public String getEMail2() {
/*  309 */     return this.eMail2;
/*      */   }
/*      */ 
/*      */   public void setEMail2(String aEMail2) {
/*  313 */     this.eMail2 = aEMail2;
/*      */   }
/*      */ 
/*      */   public String getBP2() {
/*  317 */     return this.bP2;
/*      */   }
/*      */ 
/*      */   public void setBP2(String aBP2) {
/*  321 */     this.bP2 = aBP2;
/*      */   }
/*      */ 
/*      */   public String getOperator() {
/*  325 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String aOperator) {
/*  329 */     this.operator = aOperator;
/*      */   }
/*      */ 
/*      */   public String getMakeDate() {
/*  333 */     if (this.makeDate != null) {
/*  334 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  336 */     return null;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(Date aMakeDate) {
/*  340 */     this.makeDate = aMakeDate;
/*      */   }
/*      */ 
/*      */   public void setMakeDate(String aMakeDate) {
/*  344 */     if ((aMakeDate != null) && (!aMakeDate.equals("")))
/*      */     {
/*  346 */       this.makeDate = this.fDate.getDate(aMakeDate);
/*      */     }
/*      */     else
/*  349 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getMakeTime()
/*      */   {
/*  354 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setMakeTime(String aMakeTime) {
/*  358 */     this.makeTime = aMakeTime;
/*      */   }
/*      */ 
/*      */   public String getModifyDate() {
/*  362 */     if (this.modifyDate != null) {
/*  363 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  365 */     return null;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(Date aModifyDate) {
/*  369 */     this.modifyDate = aModifyDate;
/*      */   }
/*      */ 
/*      */   public void setModifyDate(String aModifyDate) {
/*  373 */     if ((aModifyDate != null) && (!aModifyDate.equals("")))
/*      */     {
/*  375 */       this.modifyDate = this.fDate.getDate(aModifyDate);
/*      */     }
/*      */     else
/*  378 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getModifyTime()
/*      */   {
/*  383 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setModifyTime(String aModifyTime) {
/*  387 */     this.modifyTime = aModifyTime;
/*      */   }
/*      */ 
/*      */   public String getGrpName() {
/*  391 */     return this.grpName;
/*      */   }
/*      */ 
/*      */   public void setGrpName(String aGrpName) {
/*  395 */     this.grpName = aGrpName;
/*      */   }
/*      */ 
/*      */   public String getOtherDuchy() {
/*  399 */     return this.otherDuchy;
/*      */   }
/*      */ 
/*      */   public void setOtherDuchy(String aOtherDuchy) {
/*  403 */     this.otherDuchy = aOtherDuchy;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPAddressSchema aLNPAddressSchema)
/*      */   {
/*  409 */     this.customerId = aLNPAddressSchema.getCustomerId();
/*  410 */     this.customerNo = aLNPAddressSchema.getCustomerNo();
/*  411 */     this.addressNo = aLNPAddressSchema.getAddressNo();
/*  412 */     this.postalAddress = aLNPAddressSchema.getPostalAddress();
/*  413 */     this.zipCode = aLNPAddressSchema.getZipCode();
/*  414 */     this.phone = aLNPAddressSchema.getPhone();
/*  415 */     this.fax = aLNPAddressSchema.getFax();
/*  416 */     this.duchy = aLNPAddressSchema.getDuchy();
/*  417 */     this.homeAddress = aLNPAddressSchema.getHomeAddress();
/*  418 */     this.homeZipCode = aLNPAddressSchema.getHomeZipCode();
/*  419 */     this.homePhone = aLNPAddressSchema.getHomePhone();
/*  420 */     this.homeFax = aLNPAddressSchema.getHomeFax();
/*  421 */     this.companyAddress = aLNPAddressSchema.getCompanyAddress();
/*  422 */     this.companyZipCode = aLNPAddressSchema.getCompanyZipCode();
/*  423 */     this.companyPhone = aLNPAddressSchema.getCompanyPhone();
/*  424 */     this.companyFax = aLNPAddressSchema.getCompanyFax();
/*  425 */     this.companyMail = aLNPAddressSchema.getCompanyMail();
/*  426 */     this.mobile = aLNPAddressSchema.getMobile();
/*  427 */     this.mobileChs = aLNPAddressSchema.getMobileChs();
/*  428 */     this.eMail = aLNPAddressSchema.getEMail();
/*  429 */     this.bP = aLNPAddressSchema.getBP();
/*  430 */     this.mobile2 = aLNPAddressSchema.getMobile2();
/*  431 */     this.mobileChs2 = aLNPAddressSchema.getMobileChs2();
/*  432 */     this.eMail2 = aLNPAddressSchema.getEMail2();
/*  433 */     this.bP2 = aLNPAddressSchema.getBP2();
/*  434 */     this.operator = aLNPAddressSchema.getOperator();
/*  435 */     this.makeDate = this.fDate.getDate(aLNPAddressSchema.getMakeDate());
/*  436 */     this.makeTime = aLNPAddressSchema.getMakeTime();
/*  437 */     this.modifyDate = this.fDate.getDate(aLNPAddressSchema.getModifyDate());
/*  438 */     this.modifyTime = aLNPAddressSchema.getModifyTime();
/*  439 */     this.grpName = aLNPAddressSchema.getGrpName();
/*  440 */     this.otherDuchy = aLNPAddressSchema.getOtherDuchy();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  449 */       if (rs.getString("CustomerId") == null)
/*  450 */         this.customerId = null;
/*      */       else {
/*  452 */         this.customerId = rs.getString("CustomerId").trim();
/*      */       }
/*  454 */       if (rs.getString("CustomerNo") == null)
/*  455 */         this.customerNo = null;
/*      */       else {
/*  457 */         this.customerNo = rs.getString("CustomerNo").trim();
/*      */       }
/*  459 */       if (rs.getString("AddressNo") == null)
/*  460 */         this.addressNo = null;
/*      */       else {
/*  462 */         this.addressNo = rs.getString("AddressNo").trim();
/*      */       }
/*  464 */       if (rs.getString("PostalAddress") == null)
/*  465 */         this.postalAddress = null;
/*      */       else {
/*  467 */         this.postalAddress = rs.getString("PostalAddress").trim();
/*      */       }
/*  469 */       if (rs.getString("ZipCode") == null)
/*  470 */         this.zipCode = null;
/*      */       else {
/*  472 */         this.zipCode = rs.getString("ZipCode").trim();
/*      */       }
/*  474 */       if (rs.getString("Phone") == null)
/*  475 */         this.phone = null;
/*      */       else {
/*  477 */         this.phone = rs.getString("Phone").trim();
/*      */       }
/*  479 */       if (rs.getString("Fax") == null)
/*  480 */         this.fax = null;
/*      */       else {
/*  482 */         this.fax = rs.getString("Fax").trim();
/*      */       }
/*  484 */       if (rs.getString("duchy") == null)
/*  485 */         this.duchy = null;
/*      */       else {
/*  487 */         this.duchy = rs.getString("duchy").trim();
/*      */       }
/*  489 */       if (rs.getString("HomeAddress") == null)
/*  490 */         this.homeAddress = null;
/*      */       else {
/*  492 */         this.homeAddress = rs.getString("HomeAddress").trim();
/*      */       }
/*  494 */       if (rs.getString("HomeZipCode") == null)
/*  495 */         this.homeZipCode = null;
/*      */       else {
/*  497 */         this.homeZipCode = rs.getString("HomeZipCode").trim();
/*      */       }
/*  499 */       if (rs.getString("HomePhone") == null)
/*  500 */         this.homePhone = null;
/*      */       else {
/*  502 */         this.homePhone = rs.getString("HomePhone").trim();
/*      */       }
/*  504 */       if (rs.getString("HomeFax") == null)
/*  505 */         this.homeFax = null;
/*      */       else {
/*  507 */         this.homeFax = rs.getString("HomeFax").trim();
/*      */       }
/*  509 */       if (rs.getString("CompanyAddress") == null)
/*  510 */         this.companyAddress = null;
/*      */       else {
/*  512 */         this.companyAddress = rs.getString("CompanyAddress").trim();
/*      */       }
/*  514 */       if (rs.getString("CompanyZipCode") == null)
/*  515 */         this.companyZipCode = null;
/*      */       else {
/*  517 */         this.companyZipCode = rs.getString("CompanyZipCode").trim();
/*      */       }
/*  519 */       if (rs.getString("CompanyPhone") == null)
/*  520 */         this.companyPhone = null;
/*      */       else {
/*  522 */         this.companyPhone = rs.getString("CompanyPhone").trim();
/*      */       }
/*  524 */       if (rs.getString("CompanyFax") == null)
/*  525 */         this.companyFax = null;
/*      */       else {
/*  527 */         this.companyFax = rs.getString("CompanyFax").trim();
/*      */       }
/*  529 */       if (rs.getString("CompanyMail") == null)
/*  530 */         this.companyMail = null;
/*      */       else {
/*  532 */         this.companyMail = rs.getString("CompanyMail").trim();
/*      */       }
/*  534 */       if (rs.getString("Mobile") == null)
/*  535 */         this.mobile = null;
/*      */       else {
/*  537 */         this.mobile = rs.getString("Mobile").trim();
/*      */       }
/*  539 */       if (rs.getString("MobileChs") == null)
/*  540 */         this.mobileChs = null;
/*      */       else {
/*  542 */         this.mobileChs = rs.getString("MobileChs").trim();
/*      */       }
/*  544 */       if (rs.getString("EMail") == null)
/*  545 */         this.eMail = null;
/*      */       else {
/*  547 */         this.eMail = rs.getString("EMail").trim();
/*      */       }
/*  549 */       if (rs.getString("BP") == null)
/*  550 */         this.bP = null;
/*      */       else {
/*  552 */         this.bP = rs.getString("BP").trim();
/*      */       }
/*  554 */       if (rs.getString("Mobile2") == null)
/*  555 */         this.mobile2 = null;
/*      */       else {
/*  557 */         this.mobile2 = rs.getString("Mobile2").trim();
/*      */       }
/*  559 */       if (rs.getString("MobileChs2") == null)
/*  560 */         this.mobileChs2 = null;
/*      */       else {
/*  562 */         this.mobileChs2 = rs.getString("MobileChs2").trim();
/*      */       }
/*  564 */       if (rs.getString("EMail2") == null)
/*  565 */         this.eMail2 = null;
/*      */       else {
/*  567 */         this.eMail2 = rs.getString("EMail2").trim();
/*      */       }
/*  569 */       if (rs.getString("BP2") == null)
/*  570 */         this.bP2 = null;
/*      */       else {
/*  572 */         this.bP2 = rs.getString("BP2").trim();
/*      */       }
/*  574 */       if (rs.getString("Operator") == null)
/*  575 */         this.operator = null;
/*      */       else {
/*  577 */         this.operator = rs.getString("Operator").trim();
/*      */       }
/*  579 */       this.makeDate = rs.getDate("MakeDate");
/*  580 */       if (rs.getString("MakeTime") == null)
/*  581 */         this.makeTime = null;
/*      */       else {
/*  583 */         this.makeTime = rs.getString("MakeTime").trim();
/*      */       }
/*  585 */       this.modifyDate = rs.getDate("ModifyDate");
/*  586 */       if (rs.getString("ModifyTime") == null)
/*  587 */         this.modifyTime = null;
/*      */       else {
/*  589 */         this.modifyTime = rs.getString("ModifyTime").trim();
/*      */       }
/*  591 */       if (rs.getString("GrpName") == null)
/*  592 */         this.grpName = null;
/*      */       else {
/*  594 */         this.grpName = rs.getString("GrpName").trim();
/*      */       }
/*  596 */       if (rs.getString("OtherDuchy") == null)
/*  597 */         this.otherDuchy = null;
/*      */       else {
/*  599 */         this.otherDuchy = rs.getString("OtherDuchy").trim();
/*      */       }
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  604 */       System.out.println("\u93C1\u7248\u5D41\u6434\u64B2\u8151\u9428\u51E9NPAddress\u741B\u3125\u74E7\u5A08\u5178\u91DC\u93C1\u677F\u62F0Schema\u6D93\uE160\u6B91\u701B\u6941\uE18C\u6D93\uE045\u669F\u6D93\u5D84\u7AF4\u9477\u8FBE\u7D1D\u93B4\u682C\uFFFD\u546E\u58BD\u741B\u5B92b.executeQuery\u93CC\u30E8\uE1D7\u93C3\u8235\u75C5\u93C8\u5909\u5A07\u9422\u256Felect * from tables");
/*      */ 
/*  606 */       CError tError = new CError();
/*  607 */       tError.moduleName = "LNPAddressSchema";
/*  608 */       tError.functionName = "setSchema";
/*  609 */       tError.errorMessage = sqle.toString();
/*  610 */       this.mErrors.addOneError(tError);
/*  611 */       return false;
/*      */     }
/*  613 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPAddressSchema getSchema()
/*      */   {
/*  618 */     LNPAddressSchema aLNPAddressSchema = new LNPAddressSchema();
/*  619 */     aLNPAddressSchema.setSchema(this);
/*  620 */     return aLNPAddressSchema;
/*      */   }
/*      */ 
/*      */   public LNPAddressDB getDB()
/*      */   {
/*  625 */     LNPAddressDB aDBOper = new LNPAddressDB();
/*  626 */     aDBOper.setSchema(this);
/*  627 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  634 */     StringBuffer strReturn = new StringBuffer(256);
/*  635 */     strReturn.append(StrTool.cTrim(this.customerId)); strReturn.append("|");
/*  636 */     strReturn.append(StrTool.cTrim(this.customerNo)); strReturn.append("|");
/*  637 */     strReturn.append(StrTool.cTrim(this.addressNo)); strReturn.append("|");
/*  638 */     strReturn.append(StrTool.cTrim(this.postalAddress)); strReturn.append("|");
/*  639 */     strReturn.append(StrTool.cTrim(this.zipCode)); strReturn.append("|");
/*  640 */     strReturn.append(StrTool.cTrim(this.phone)); strReturn.append("|");
/*  641 */     strReturn.append(StrTool.cTrim(this.fax)); strReturn.append("|");
/*  642 */     strReturn.append(StrTool.cTrim(this.duchy)); strReturn.append("|");
/*  643 */     strReturn.append(StrTool.cTrim(this.homeAddress)); strReturn.append("|");
/*  644 */     strReturn.append(StrTool.cTrim(this.homeZipCode)); strReturn.append("|");
/*  645 */     strReturn.append(StrTool.cTrim(this.homePhone)); strReturn.append("|");
/*  646 */     strReturn.append(StrTool.cTrim(this.homeFax)); strReturn.append("|");
/*  647 */     strReturn.append(StrTool.cTrim(this.companyAddress)); strReturn.append("|");
/*  648 */     strReturn.append(StrTool.cTrim(this.companyZipCode)); strReturn.append("|");
/*  649 */     strReturn.append(StrTool.cTrim(this.companyPhone)); strReturn.append("|");
/*  650 */     strReturn.append(StrTool.cTrim(this.companyFax)); strReturn.append("|");
/*  651 */     strReturn.append(StrTool.cTrim(this.companyMail)); strReturn.append("|");
/*  652 */     strReturn.append(StrTool.cTrim(this.mobile)); strReturn.append("|");
/*  653 */     strReturn.append(StrTool.cTrim(this.mobileChs)); strReturn.append("|");
/*  654 */     strReturn.append(StrTool.cTrim(this.eMail)); strReturn.append("|");
/*  655 */     strReturn.append(StrTool.cTrim(this.bP)); strReturn.append("|");
/*  656 */     strReturn.append(StrTool.cTrim(this.mobile2)); strReturn.append("|");
/*  657 */     strReturn.append(StrTool.cTrim(this.mobileChs2)); strReturn.append("|");
/*  658 */     strReturn.append(StrTool.cTrim(this.eMail2)); strReturn.append("|");
/*  659 */     strReturn.append(StrTool.cTrim(this.bP2)); strReturn.append("|");
/*  660 */     strReturn.append(StrTool.cTrim(this.operator)); strReturn.append("|");
/*  661 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.makeDate))); strReturn.append("|");
/*  662 */     strReturn.append(StrTool.cTrim(this.makeTime)); strReturn.append("|");
/*  663 */     strReturn.append(StrTool.cTrim(this.fDate.getString(this.modifyDate))); strReturn.append("|");
/*  664 */     strReturn.append(StrTool.cTrim(this.modifyTime)); strReturn.append("|");
/*  665 */     strReturn.append(StrTool.cTrim(this.grpName)); strReturn.append("|");
/*  666 */     strReturn.append(StrTool.cTrim(this.otherDuchy));
/*  667 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  675 */       this.customerId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  676 */       this.customerNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  677 */       this.addressNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  678 */       this.postalAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  679 */       this.zipCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  680 */       this.phone = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  681 */       this.fax = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  682 */       this.duchy = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  683 */       this.homeAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  684 */       this.homeZipCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  685 */       this.homePhone = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  686 */       this.homeFax = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  687 */       this.companyAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  688 */       this.companyZipCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  689 */       this.companyPhone = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  690 */       this.companyFax = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  691 */       this.companyMail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  692 */       this.mobile = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  693 */       this.mobileChs = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  694 */       this.eMail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/*  695 */       this.bP = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/*  696 */       this.mobile2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/*  697 */       this.mobileChs2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/*  698 */       this.eMail2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/*  699 */       this.bP2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/*  700 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/*  701 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|"));
/*  702 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
/*  703 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|"));
/*  704 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
/*  705 */       this.grpName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
/*  706 */       this.otherDuchy = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  711 */       CError tError = new CError();
/*  712 */       tError.moduleName = "LNPAddressSchema";
/*  713 */       tError.functionName = "decode";
/*  714 */       tError.errorMessage = ex.toString();
/*  715 */       this.mErrors.addOneError(tError);
/*      */ 
/*  717 */       return false;
/*      */     }
/*  719 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  725 */     String strReturn = "";
/*  726 */     if (FCode.equalsIgnoreCase("customerId"))
/*      */     {
/*  728 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.customerId));
/*      */     }
/*  730 */     if (FCode.equalsIgnoreCase("customerNo"))
/*      */     {
/*  732 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.customerNo));
/*      */     }
/*  734 */     if (FCode.equalsIgnoreCase("addressNo"))
/*      */     {
/*  736 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.addressNo));
/*      */     }
/*  738 */     if (FCode.equalsIgnoreCase("postalAddress"))
/*      */     {
/*  740 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.postalAddress));
/*      */     }
/*  742 */     if (FCode.equalsIgnoreCase("zipCode"))
/*      */     {
/*  744 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.zipCode));
/*      */     }
/*  746 */     if (FCode.equalsIgnoreCase("phone"))
/*      */     {
/*  748 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.phone));
/*      */     }
/*  750 */     if (FCode.equalsIgnoreCase("fax"))
/*      */     {
/*  752 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.fax));
/*      */     }
/*  754 */     if (FCode.equalsIgnoreCase("duchy"))
/*      */     {
/*  756 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.duchy));
/*      */     }
/*  758 */     if (FCode.equalsIgnoreCase("homeAddress"))
/*      */     {
/*  760 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.homeAddress));
/*      */     }
/*  762 */     if (FCode.equalsIgnoreCase("homeZipCode"))
/*      */     {
/*  764 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.homeZipCode));
/*      */     }
/*  766 */     if (FCode.equalsIgnoreCase("homePhone"))
/*      */     {
/*  768 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.homePhone));
/*      */     }
/*  770 */     if (FCode.equalsIgnoreCase("homeFax"))
/*      */     {
/*  772 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.homeFax));
/*      */     }
/*  774 */     if (FCode.equalsIgnoreCase("companyAddress"))
/*      */     {
/*  776 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.companyAddress));
/*      */     }
/*  778 */     if (FCode.equalsIgnoreCase("companyZipCode"))
/*      */     {
/*  780 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.companyZipCode));
/*      */     }
/*  782 */     if (FCode.equalsIgnoreCase("companyPhone"))
/*      */     {
/*  784 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.companyPhone));
/*      */     }
/*  786 */     if (FCode.equalsIgnoreCase("companyFax"))
/*      */     {
/*  788 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.companyFax));
/*      */     }
/*  790 */     if (FCode.equalsIgnoreCase("companyMail"))
/*      */     {
/*  792 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.companyMail));
/*      */     }
/*  794 */     if (FCode.equalsIgnoreCase("mobile"))
/*      */     {
/*  796 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.mobile));
/*      */     }
/*  798 */     if (FCode.equalsIgnoreCase("mobileChs"))
/*      */     {
/*  800 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.mobileChs));
/*      */     }
/*  802 */     if (FCode.equalsIgnoreCase("eMail"))
/*      */     {
/*  804 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.eMail));
/*      */     }
/*  806 */     if (FCode.equalsIgnoreCase("bP"))
/*      */     {
/*  808 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bP));
/*      */     }
/*  810 */     if (FCode.equalsIgnoreCase("mobile2"))
/*      */     {
/*  812 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.mobile2));
/*      */     }
/*  814 */     if (FCode.equalsIgnoreCase("mobileChs2"))
/*      */     {
/*  816 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.mobileChs2));
/*      */     }
/*  818 */     if (FCode.equalsIgnoreCase("eMail2"))
/*      */     {
/*  820 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.eMail2));
/*      */     }
/*  822 */     if (FCode.equalsIgnoreCase("bP2"))
/*      */     {
/*  824 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bP2));
/*      */     }
/*  826 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/*  828 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  830 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/*  832 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*      */     }
/*  834 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/*  836 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  838 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/*  840 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*      */     }
/*  842 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/*  844 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/*  846 */     if (FCode.equalsIgnoreCase("grpName"))
/*      */     {
/*  848 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpName));
/*      */     }
/*  850 */     if (FCode.equalsIgnoreCase("otherDuchy"))
/*      */     {
/*  852 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.otherDuchy));
/*      */     }
/*  854 */     if (strReturn.equals(""))
/*      */     {
/*  856 */       strReturn = "null";
/*      */     }
/*      */ 
/*  859 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/*  866 */     String strFieldValue = "";
/*  867 */     switch (nFieldIndex) {
/*      */     case 0:
/*  869 */       strFieldValue = StrTool.GBKToUnicode(this.customerId);
/*  870 */       break;
/*      */     case 1:
/*  872 */       strFieldValue = StrTool.GBKToUnicode(this.customerNo);
/*  873 */       break;
/*      */     case 2:
/*  875 */       strFieldValue = StrTool.GBKToUnicode(this.addressNo);
/*  876 */       break;
/*      */     case 3:
/*  878 */       strFieldValue = StrTool.GBKToUnicode(this.postalAddress);
/*  879 */       break;
/*      */     case 4:
/*  881 */       strFieldValue = StrTool.GBKToUnicode(this.zipCode);
/*  882 */       break;
/*      */     case 5:
/*  884 */       strFieldValue = StrTool.GBKToUnicode(this.phone);
/*  885 */       break;
/*      */     case 6:
/*  887 */       strFieldValue = StrTool.GBKToUnicode(this.fax);
/*  888 */       break;
/*      */     case 7:
/*  890 */       strFieldValue = StrTool.GBKToUnicode(this.duchy);
/*  891 */       break;
/*      */     case 8:
/*  893 */       strFieldValue = StrTool.GBKToUnicode(this.homeAddress);
/*  894 */       break;
/*      */     case 9:
/*  896 */       strFieldValue = StrTool.GBKToUnicode(this.homeZipCode);
/*  897 */       break;
/*      */     case 10:
/*  899 */       strFieldValue = StrTool.GBKToUnicode(this.homePhone);
/*  900 */       break;
/*      */     case 11:
/*  902 */       strFieldValue = StrTool.GBKToUnicode(this.homeFax);
/*  903 */       break;
/*      */     case 12:
/*  905 */       strFieldValue = StrTool.GBKToUnicode(this.companyAddress);
/*  906 */       break;
/*      */     case 13:
/*  908 */       strFieldValue = StrTool.GBKToUnicode(this.companyZipCode);
/*  909 */       break;
/*      */     case 14:
/*  911 */       strFieldValue = StrTool.GBKToUnicode(this.companyPhone);
/*  912 */       break;
/*      */     case 15:
/*  914 */       strFieldValue = StrTool.GBKToUnicode(this.companyFax);
/*  915 */       break;
/*      */     case 16:
/*  917 */       strFieldValue = StrTool.GBKToUnicode(this.companyMail);
/*  918 */       break;
/*      */     case 17:
/*  920 */       strFieldValue = StrTool.GBKToUnicode(this.mobile);
/*  921 */       break;
/*      */     case 18:
/*  923 */       strFieldValue = StrTool.GBKToUnicode(this.mobileChs);
/*  924 */       break;
/*      */     case 19:
/*  926 */       strFieldValue = StrTool.GBKToUnicode(this.eMail);
/*  927 */       break;
/*      */     case 20:
/*  929 */       strFieldValue = StrTool.GBKToUnicode(this.bP);
/*  930 */       break;
/*      */     case 21:
/*  932 */       strFieldValue = StrTool.GBKToUnicode(this.mobile2);
/*  933 */       break;
/*      */     case 22:
/*  935 */       strFieldValue = StrTool.GBKToUnicode(this.mobileChs2);
/*  936 */       break;
/*      */     case 23:
/*  938 */       strFieldValue = StrTool.GBKToUnicode(this.eMail2);
/*  939 */       break;
/*      */     case 24:
/*  941 */       strFieldValue = StrTool.GBKToUnicode(this.bP2);
/*  942 */       break;
/*      */     case 25:
/*  944 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/*  945 */       break;
/*      */     case 26:
/*  947 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getMakeDate()));
/*  948 */       break;
/*      */     case 27:
/*  950 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/*  951 */       break;
/*      */     case 28:
/*  953 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getModifyDate()));
/*  954 */       break;
/*      */     case 29:
/*  956 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/*  957 */       break;
/*      */     case 30:
/*  959 */       strFieldValue = StrTool.GBKToUnicode(this.grpName);
/*  960 */       break;
/*      */     case 31:
/*  962 */       strFieldValue = StrTool.GBKToUnicode(this.otherDuchy);
/*  963 */       break;
/*      */     default:
/*  965 */       strFieldValue = "";
/*      */     }
/*  967 */     if (strFieldValue.equals("")) {
/*  968 */       strFieldValue = "null";
/*      */     }
/*  970 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/*  976 */     if (StrTool.cTrim(FCode).equals("")) {
/*  977 */       return false;
/*      */     }
/*  979 */     if (FCode.equalsIgnoreCase("customerId"))
/*      */     {
/*  981 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  983 */         this.customerId = FValue.trim();
/*      */       }
/*      */       else
/*  986 */         this.customerId = null;
/*      */     }
/*  988 */     if (FCode.equalsIgnoreCase("customerNo"))
/*      */     {
/*  990 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/*  992 */         this.customerNo = FValue.trim();
/*      */       }
/*      */       else
/*  995 */         this.customerNo = null;
/*      */     }
/*  997 */     if (FCode.equalsIgnoreCase("addressNo"))
/*      */     {
/*  999 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1001 */         this.addressNo = FValue.trim();
/*      */       }
/*      */       else
/* 1004 */         this.addressNo = null;
/*      */     }
/* 1006 */     if (FCode.equalsIgnoreCase("postalAddress"))
/*      */     {
/* 1008 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1010 */         this.postalAddress = FValue.trim();
/*      */       }
/*      */       else
/* 1013 */         this.postalAddress = null;
/*      */     }
/* 1015 */     if (FCode.equalsIgnoreCase("zipCode"))
/*      */     {
/* 1017 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1019 */         this.zipCode = FValue.trim();
/*      */       }
/*      */       else
/* 1022 */         this.zipCode = null;
/*      */     }
/* 1024 */     if (FCode.equalsIgnoreCase("phone"))
/*      */     {
/* 1026 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1028 */         this.phone = FValue.trim();
/*      */       }
/*      */       else
/* 1031 */         this.phone = null;
/*      */     }
/* 1033 */     if (FCode.equalsIgnoreCase("fax"))
/*      */     {
/* 1035 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1037 */         this.fax = FValue.trim();
/*      */       }
/*      */       else
/* 1040 */         this.fax = null;
/*      */     }
/* 1042 */     if (FCode.equalsIgnoreCase("duchy"))
/*      */     {
/* 1044 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1046 */         this.duchy = FValue.trim();
/*      */       }
/*      */       else
/* 1049 */         this.duchy = null;
/*      */     }
/* 1051 */     if (FCode.equalsIgnoreCase("homeAddress"))
/*      */     {
/* 1053 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1055 */         this.homeAddress = FValue.trim();
/*      */       }
/*      */       else
/* 1058 */         this.homeAddress = null;
/*      */     }
/* 1060 */     if (FCode.equalsIgnoreCase("homeZipCode"))
/*      */     {
/* 1062 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1064 */         this.homeZipCode = FValue.trim();
/*      */       }
/*      */       else
/* 1067 */         this.homeZipCode = null;
/*      */     }
/* 1069 */     if (FCode.equalsIgnoreCase("homePhone"))
/*      */     {
/* 1071 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1073 */         this.homePhone = FValue.trim();
/*      */       }
/*      */       else
/* 1076 */         this.homePhone = null;
/*      */     }
/* 1078 */     if (FCode.equalsIgnoreCase("homeFax"))
/*      */     {
/* 1080 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1082 */         this.homeFax = FValue.trim();
/*      */       }
/*      */       else
/* 1085 */         this.homeFax = null;
/*      */     }
/* 1087 */     if (FCode.equalsIgnoreCase("companyAddress"))
/*      */     {
/* 1089 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1091 */         this.companyAddress = FValue.trim();
/*      */       }
/*      */       else
/* 1094 */         this.companyAddress = null;
/*      */     }
/* 1096 */     if (FCode.equalsIgnoreCase("companyZipCode"))
/*      */     {
/* 1098 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1100 */         this.companyZipCode = FValue.trim();
/*      */       }
/*      */       else
/* 1103 */         this.companyZipCode = null;
/*      */     }
/* 1105 */     if (FCode.equalsIgnoreCase("companyPhone"))
/*      */     {
/* 1107 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1109 */         this.companyPhone = FValue.trim();
/*      */       }
/*      */       else
/* 1112 */         this.companyPhone = null;
/*      */     }
/* 1114 */     if (FCode.equalsIgnoreCase("companyFax"))
/*      */     {
/* 1116 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1118 */         this.companyFax = FValue.trim();
/*      */       }
/*      */       else
/* 1121 */         this.companyFax = null;
/*      */     }
/* 1123 */     if (FCode.equalsIgnoreCase("companyMail"))
/*      */     {
/* 1125 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1127 */         this.companyMail = FValue.trim();
/*      */       }
/*      */       else
/* 1130 */         this.companyMail = null;
/*      */     }
/* 1132 */     if (FCode.equalsIgnoreCase("mobile"))
/*      */     {
/* 1134 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1136 */         this.mobile = FValue.trim();
/*      */       }
/*      */       else
/* 1139 */         this.mobile = null;
/*      */     }
/* 1141 */     if (FCode.equalsIgnoreCase("mobileChs"))
/*      */     {
/* 1143 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1145 */         this.mobileChs = FValue.trim();
/*      */       }
/*      */       else
/* 1148 */         this.mobileChs = null;
/*      */     }
/* 1150 */     if (FCode.equalsIgnoreCase("eMail"))
/*      */     {
/* 1152 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1154 */         this.eMail = FValue.trim();
/*      */       }
/*      */       else
/* 1157 */         this.eMail = null;
/*      */     }
/* 1159 */     if (FCode.equalsIgnoreCase("bP"))
/*      */     {
/* 1161 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1163 */         this.bP = FValue.trim();
/*      */       }
/*      */       else
/* 1166 */         this.bP = null;
/*      */     }
/* 1168 */     if (FCode.equalsIgnoreCase("mobile2"))
/*      */     {
/* 1170 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1172 */         this.mobile2 = FValue.trim();
/*      */       }
/*      */       else
/* 1175 */         this.mobile2 = null;
/*      */     }
/* 1177 */     if (FCode.equalsIgnoreCase("mobileChs2"))
/*      */     {
/* 1179 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1181 */         this.mobileChs2 = FValue.trim();
/*      */       }
/*      */       else
/* 1184 */         this.mobileChs2 = null;
/*      */     }
/* 1186 */     if (FCode.equalsIgnoreCase("eMail2"))
/*      */     {
/* 1188 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1190 */         this.eMail2 = FValue.trim();
/*      */       }
/*      */       else
/* 1193 */         this.eMail2 = null;
/*      */     }
/* 1195 */     if (FCode.equalsIgnoreCase("bP2"))
/*      */     {
/* 1197 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1199 */         this.bP2 = FValue.trim();
/*      */       }
/*      */       else
/* 1202 */         this.bP2 = null;
/*      */     }
/* 1204 */     if (FCode.equalsIgnoreCase("operator"))
/*      */     {
/* 1206 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1208 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 1211 */         this.operator = null;
/*      */     }
/* 1213 */     if (FCode.equalsIgnoreCase("makeDate"))
/*      */     {
/* 1215 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1217 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1220 */         this.makeDate = null;
/*      */     }
/* 1222 */     if (FCode.equalsIgnoreCase("makeTime"))
/*      */     {
/* 1224 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1226 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 1229 */         this.makeTime = null;
/*      */     }
/* 1231 */     if (FCode.equalsIgnoreCase("modifyDate"))
/*      */     {
/* 1233 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1235 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1238 */         this.modifyDate = null;
/*      */     }
/* 1240 */     if (FCode.equalsIgnoreCase("modifyTime"))
/*      */     {
/* 1242 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1244 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 1247 */         this.modifyTime = null;
/*      */     }
/* 1249 */     if (FCode.equalsIgnoreCase("grpName"))
/*      */     {
/* 1251 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1253 */         this.grpName = FValue.trim();
/*      */       }
/*      */       else
/* 1256 */         this.grpName = null;
/*      */     }
/* 1258 */     if (FCode.equalsIgnoreCase("otherDuchy"))
/*      */     {
/* 1260 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1262 */         this.otherDuchy = FValue.trim();
/*      */       }
/*      */       else
/* 1265 */         this.otherDuchy = null;
/*      */     }
/* 1267 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1272 */     if (otherObject == null) return false;
/* 1273 */     if (this == otherObject) return true;
/* 1274 */     if (getClass() != otherObject.getClass()) return false;
/* 1275 */     LNPAddressSchema other = (LNPAddressSchema)otherObject;
/* 1276 */     if ((this.customerId == null) && (other.getCustomerId() != null)) return false;
/* 1277 */     if ((this.customerId != null) && (!this.customerId.equals(other.getCustomerId()))) return false;
/* 1278 */     if ((this.customerNo == null) && (other.getCustomerNo() != null)) return false;
/* 1279 */     if ((this.customerNo != null) && (!this.customerNo.equals(other.getCustomerNo()))) return false;
/* 1280 */     if ((this.addressNo == null) && (other.getAddressNo() != null)) return false;
/* 1281 */     if ((this.addressNo != null) && (!this.addressNo.equals(other.getAddressNo()))) return false;
/* 1282 */     if ((this.postalAddress == null) && (other.getPostalAddress() != null)) return false;
/* 1283 */     if ((this.postalAddress != null) && (!this.postalAddress.equals(other.getPostalAddress()))) return false;
/* 1284 */     if ((this.zipCode == null) && (other.getZipCode() != null)) return false;
/* 1285 */     if ((this.zipCode != null) && (!this.zipCode.equals(other.getZipCode()))) return false;
/* 1286 */     if ((this.phone == null) && (other.getPhone() != null)) return false;
/* 1287 */     if ((this.phone != null) && (!this.phone.equals(other.getPhone()))) return false;
/* 1288 */     if ((this.fax == null) && (other.getFax() != null)) return false;
/* 1289 */     if ((this.fax != null) && (!this.fax.equals(other.getFax()))) return false;
/* 1290 */     if ((this.duchy == null) && (other.getDuchy() != null)) return false;
/* 1291 */     if ((this.duchy != null) && (!this.duchy.equals(other.getDuchy()))) return false;
/* 1292 */     if ((this.homeAddress == null) && (other.getHomeAddress() != null)) return false;
/* 1293 */     if ((this.homeAddress != null) && (!this.homeAddress.equals(other.getHomeAddress()))) return false;
/* 1294 */     if ((this.homeZipCode == null) && (other.getHomeZipCode() != null)) return false;
/* 1295 */     if ((this.homeZipCode != null) && (!this.homeZipCode.equals(other.getHomeZipCode()))) return false;
/* 1296 */     if ((this.homePhone == null) && (other.getHomePhone() != null)) return false;
/* 1297 */     if ((this.homePhone != null) && (!this.homePhone.equals(other.getHomePhone()))) return false;
/* 1298 */     if ((this.homeFax == null) && (other.getHomeFax() != null)) return false;
/* 1299 */     if ((this.homeFax != null) && (!this.homeFax.equals(other.getHomeFax()))) return false;
/* 1300 */     if ((this.companyAddress == null) && (other.getCompanyAddress() != null)) return false;
/* 1301 */     if ((this.companyAddress != null) && (!this.companyAddress.equals(other.getCompanyAddress()))) return false;
/* 1302 */     if ((this.companyZipCode == null) && (other.getCompanyZipCode() != null)) return false;
/* 1303 */     if ((this.companyZipCode != null) && (!this.companyZipCode.equals(other.getCompanyZipCode()))) return false;
/* 1304 */     if ((this.companyPhone == null) && (other.getCompanyPhone() != null)) return false;
/* 1305 */     if ((this.companyPhone != null) && (!this.companyPhone.equals(other.getCompanyPhone()))) return false;
/* 1306 */     if ((this.companyFax == null) && (other.getCompanyFax() != null)) return false;
/* 1307 */     if ((this.companyFax != null) && (!this.companyFax.equals(other.getCompanyFax()))) return false;
/* 1308 */     if ((this.companyMail == null) && (other.getCompanyMail() != null)) return false;
/* 1309 */     if ((this.companyMail != null) && (!this.companyMail.equals(other.getCompanyMail()))) return false;
/* 1310 */     if ((this.mobile == null) && (other.getMobile() != null)) return false;
/* 1311 */     if ((this.mobile != null) && (!this.mobile.equals(other.getMobile()))) return false;
/* 1312 */     if ((this.mobileChs == null) && (other.getMobileChs() != null)) return false;
/* 1313 */     if ((this.mobileChs != null) && (!this.mobileChs.equals(other.getMobileChs()))) return false;
/* 1314 */     if ((this.eMail == null) && (other.getEMail() != null)) return false;
/* 1315 */     if ((this.eMail != null) && (!this.eMail.equals(other.getEMail()))) return false;
/* 1316 */     if ((this.bP == null) && (other.getBP() != null)) return false;
/* 1317 */     if ((this.bP != null) && (!this.bP.equals(other.getBP()))) return false;
/* 1318 */     if ((this.mobile2 == null) && (other.getMobile2() != null)) return false;
/* 1319 */     if ((this.mobile2 != null) && (!this.mobile2.equals(other.getMobile2()))) return false;
/* 1320 */     if ((this.mobileChs2 == null) && (other.getMobileChs2() != null)) return false;
/* 1321 */     if ((this.mobileChs2 != null) && (!this.mobileChs2.equals(other.getMobileChs2()))) return false;
/* 1322 */     if ((this.eMail2 == null) && (other.getEMail2() != null)) return false;
/* 1323 */     if ((this.eMail2 != null) && (!this.eMail2.equals(other.getEMail2()))) return false;
/* 1324 */     if ((this.bP2 == null) && (other.getBP2() != null)) return false;
/* 1325 */     if ((this.bP2 != null) && (!this.bP2.equals(other.getBP2()))) return false;
/* 1326 */     if ((this.operator == null) && (other.getOperator() != null)) return false;
/* 1327 */     if ((this.operator != null) && (!this.operator.equals(other.getOperator()))) return false;
/* 1328 */     if ((this.makeDate == null) && (other.getMakeDate() != null)) return false;
/* 1329 */     if ((this.makeDate != null) && (!this.fDate.getString(this.makeDate).equals(other.getMakeDate()))) return false;
/* 1330 */     if ((this.makeTime == null) && (other.getMakeTime() != null)) return false;
/* 1331 */     if ((this.makeTime != null) && (!this.makeTime.equals(other.getMakeTime()))) return false;
/* 1332 */     if ((this.modifyDate == null) && (other.getModifyDate() != null)) return false;
/* 1333 */     if ((this.modifyDate != null) && (!this.fDate.getString(this.modifyDate).equals(other.getModifyDate()))) return false;
/* 1334 */     if ((this.modifyTime == null) && (other.getModifyTime() != null)) return false;
/* 1335 */     if ((this.modifyTime != null) && (!this.modifyTime.equals(other.getModifyTime()))) return false;
/* 1336 */     if ((this.grpName == null) && (other.getGrpName() != null)) return false;
/* 1337 */     if ((this.grpName != null) && (!this.grpName.equals(other.getGrpName()))) return false;
/* 1338 */     if ((this.otherDuchy == null) && (other.getOtherDuchy() != null)) return false;
/* 1339 */     return (this.otherDuchy == null) || (this.otherDuchy.equals(other.getOtherDuchy()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1346 */     return 32;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1352 */     if (strFieldName.equals("customerId")) {
/* 1353 */       return 0;
/*      */     }
/* 1355 */     if (strFieldName.equals("customerNo")) {
/* 1356 */       return 1;
/*      */     }
/* 1358 */     if (strFieldName.equals("addressNo")) {
/* 1359 */       return 2;
/*      */     }
/* 1361 */     if (strFieldName.equals("postalAddress")) {
/* 1362 */       return 3;
/*      */     }
/* 1364 */     if (strFieldName.equals("zipCode")) {
/* 1365 */       return 4;
/*      */     }
/* 1367 */     if (strFieldName.equals("phone")) {
/* 1368 */       return 5;
/*      */     }
/* 1370 */     if (strFieldName.equals("fax")) {
/* 1371 */       return 6;
/*      */     }
/* 1373 */     if (strFieldName.equals("duchy")) {
/* 1374 */       return 7;
/*      */     }
/* 1376 */     if (strFieldName.equals("homeAddress")) {
/* 1377 */       return 8;
/*      */     }
/* 1379 */     if (strFieldName.equals("homeZipCode")) {
/* 1380 */       return 9;
/*      */     }
/* 1382 */     if (strFieldName.equals("homePhone")) {
/* 1383 */       return 10;
/*      */     }
/* 1385 */     if (strFieldName.equals("homeFax")) {
/* 1386 */       return 11;
/*      */     }
/* 1388 */     if (strFieldName.equals("companyAddress")) {
/* 1389 */       return 12;
/*      */     }
/* 1391 */     if (strFieldName.equals("companyZipCode")) {
/* 1392 */       return 13;
/*      */     }
/* 1394 */     if (strFieldName.equals("companyPhone")) {
/* 1395 */       return 14;
/*      */     }
/* 1397 */     if (strFieldName.equals("companyFax")) {
/* 1398 */       return 15;
/*      */     }
/* 1400 */     if (strFieldName.equals("companyMail")) {
/* 1401 */       return 16;
/*      */     }
/* 1403 */     if (strFieldName.equals("mobile")) {
/* 1404 */       return 17;
/*      */     }
/* 1406 */     if (strFieldName.equals("mobileChs")) {
/* 1407 */       return 18;
/*      */     }
/* 1409 */     if (strFieldName.equals("eMail")) {
/* 1410 */       return 19;
/*      */     }
/* 1412 */     if (strFieldName.equals("bP")) {
/* 1413 */       return 20;
/*      */     }
/* 1415 */     if (strFieldName.equals("mobile2")) {
/* 1416 */       return 21;
/*      */     }
/* 1418 */     if (strFieldName.equals("mobileChs2")) {
/* 1419 */       return 22;
/*      */     }
/* 1421 */     if (strFieldName.equals("eMail2")) {
/* 1422 */       return 23;
/*      */     }
/* 1424 */     if (strFieldName.equals("bP2")) {
/* 1425 */       return 24;
/*      */     }
/* 1427 */     if (strFieldName.equals("operator")) {
/* 1428 */       return 25;
/*      */     }
/* 1430 */     if (strFieldName.equals("makeDate")) {
/* 1431 */       return 26;
/*      */     }
/* 1433 */     if (strFieldName.equals("makeTime")) {
/* 1434 */       return 27;
/*      */     }
/* 1436 */     if (strFieldName.equals("modifyDate")) {
/* 1437 */       return 28;
/*      */     }
/* 1439 */     if (strFieldName.equals("modifyTime")) {
/* 1440 */       return 29;
/*      */     }
/* 1442 */     if (strFieldName.equals("grpName")) {
/* 1443 */       return 30;
/*      */     }
/* 1445 */     if (strFieldName.equals("otherDuchy")) {
/* 1446 */       return 31;
/*      */     }
/* 1448 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1454 */     String strFieldName = "";
/* 1455 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1457 */       strFieldName = "customerId";
/* 1458 */       break;
/*      */     case 1:
/* 1460 */       strFieldName = "customerNo";
/* 1461 */       break;
/*      */     case 2:
/* 1463 */       strFieldName = "addressNo";
/* 1464 */       break;
/*      */     case 3:
/* 1466 */       strFieldName = "postalAddress";
/* 1467 */       break;
/*      */     case 4:
/* 1469 */       strFieldName = "zipCode";
/* 1470 */       break;
/*      */     case 5:
/* 1472 */       strFieldName = "phone";
/* 1473 */       break;
/*      */     case 6:
/* 1475 */       strFieldName = "fax";
/* 1476 */       break;
/*      */     case 7:
/* 1478 */       strFieldName = "duchy";
/* 1479 */       break;
/*      */     case 8:
/* 1481 */       strFieldName = "homeAddress";
/* 1482 */       break;
/*      */     case 9:
/* 1484 */       strFieldName = "homeZipCode";
/* 1485 */       break;
/*      */     case 10:
/* 1487 */       strFieldName = "homePhone";
/* 1488 */       break;
/*      */     case 11:
/* 1490 */       strFieldName = "homeFax";
/* 1491 */       break;
/*      */     case 12:
/* 1493 */       strFieldName = "companyAddress";
/* 1494 */       break;
/*      */     case 13:
/* 1496 */       strFieldName = "companyZipCode";
/* 1497 */       break;
/*      */     case 14:
/* 1499 */       strFieldName = "companyPhone";
/* 1500 */       break;
/*      */     case 15:
/* 1502 */       strFieldName = "companyFax";
/* 1503 */       break;
/*      */     case 16:
/* 1505 */       strFieldName = "companyMail";
/* 1506 */       break;
/*      */     case 17:
/* 1508 */       strFieldName = "mobile";
/* 1509 */       break;
/*      */     case 18:
/* 1511 */       strFieldName = "mobileChs";
/* 1512 */       break;
/*      */     case 19:
/* 1514 */       strFieldName = "eMail";
/* 1515 */       break;
/*      */     case 20:
/* 1517 */       strFieldName = "bP";
/* 1518 */       break;
/*      */     case 21:
/* 1520 */       strFieldName = "mobile2";
/* 1521 */       break;
/*      */     case 22:
/* 1523 */       strFieldName = "mobileChs2";
/* 1524 */       break;
/*      */     case 23:
/* 1526 */       strFieldName = "eMail2";
/* 1527 */       break;
/*      */     case 24:
/* 1529 */       strFieldName = "bP2";
/* 1530 */       break;
/*      */     case 25:
/* 1532 */       strFieldName = "operator";
/* 1533 */       break;
/*      */     case 26:
/* 1535 */       strFieldName = "makeDate";
/* 1536 */       break;
/*      */     case 27:
/* 1538 */       strFieldName = "makeTime";
/* 1539 */       break;
/*      */     case 28:
/* 1541 */       strFieldName = "modifyDate";
/* 1542 */       break;
/*      */     case 29:
/* 1544 */       strFieldName = "modifyTime";
/* 1545 */       break;
/*      */     case 30:
/* 1547 */       strFieldName = "grpName";
/* 1548 */       break;
/*      */     case 31:
/* 1550 */       strFieldName = "otherDuchy";
/* 1551 */       break;
/*      */     default:
/* 1553 */       strFieldName = "";
/*      */     }
/* 1555 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1561 */     if (strFieldName.equals("customerId")) {
/* 1562 */       return 0;
/*      */     }
/* 1564 */     if (strFieldName.equals("customerNo")) {
/* 1565 */       return 0;
/*      */     }
/* 1567 */     if (strFieldName.equals("addressNo")) {
/* 1568 */       return 0;
/*      */     }
/* 1570 */     if (strFieldName.equals("postalAddress")) {
/* 1571 */       return 0;
/*      */     }
/* 1573 */     if (strFieldName.equals("zipCode")) {
/* 1574 */       return 0;
/*      */     }
/* 1576 */     if (strFieldName.equals("phone")) {
/* 1577 */       return 0;
/*      */     }
/* 1579 */     if (strFieldName.equals("fax")) {
/* 1580 */       return 0;
/*      */     }
/* 1582 */     if (strFieldName.equals("duchy")) {
/* 1583 */       return 0;
/*      */     }
/* 1585 */     if (strFieldName.equals("homeAddress")) {
/* 1586 */       return 0;
/*      */     }
/* 1588 */     if (strFieldName.equals("homeZipCode")) {
/* 1589 */       return 0;
/*      */     }
/* 1591 */     if (strFieldName.equals("homePhone")) {
/* 1592 */       return 0;
/*      */     }
/* 1594 */     if (strFieldName.equals("homeFax")) {
/* 1595 */       return 0;
/*      */     }
/* 1597 */     if (strFieldName.equals("companyAddress")) {
/* 1598 */       return 0;
/*      */     }
/* 1600 */     if (strFieldName.equals("companyZipCode")) {
/* 1601 */       return 0;
/*      */     }
/* 1603 */     if (strFieldName.equals("companyPhone")) {
/* 1604 */       return 0;
/*      */     }
/* 1606 */     if (strFieldName.equals("companyFax")) {
/* 1607 */       return 0;
/*      */     }
/* 1609 */     if (strFieldName.equals("companyMail")) {
/* 1610 */       return 0;
/*      */     }
/* 1612 */     if (strFieldName.equals("mobile")) {
/* 1613 */       return 0;
/*      */     }
/* 1615 */     if (strFieldName.equals("mobileChs")) {
/* 1616 */       return 0;
/*      */     }
/* 1618 */     if (strFieldName.equals("eMail")) {
/* 1619 */       return 0;
/*      */     }
/* 1621 */     if (strFieldName.equals("bP")) {
/* 1622 */       return 0;
/*      */     }
/* 1624 */     if (strFieldName.equals("mobile2")) {
/* 1625 */       return 0;
/*      */     }
/* 1627 */     if (strFieldName.equals("mobileChs2")) {
/* 1628 */       return 0;
/*      */     }
/* 1630 */     if (strFieldName.equals("eMail2")) {
/* 1631 */       return 0;
/*      */     }
/* 1633 */     if (strFieldName.equals("bP2")) {
/* 1634 */       return 0;
/*      */     }
/* 1636 */     if (strFieldName.equals("operator")) {
/* 1637 */       return 0;
/*      */     }
/* 1639 */     if (strFieldName.equals("makeDate")) {
/* 1640 */       return 1;
/*      */     }
/* 1642 */     if (strFieldName.equals("makeTime")) {
/* 1643 */       return 0;
/*      */     }
/* 1645 */     if (strFieldName.equals("modifyDate")) {
/* 1646 */       return 1;
/*      */     }
/* 1648 */     if (strFieldName.equals("modifyTime")) {
/* 1649 */       return 0;
/*      */     }
/* 1651 */     if (strFieldName.equals("grpName")) {
/* 1652 */       return 0;
/*      */     }
/* 1654 */     if (strFieldName.equals("otherDuchy")) {
/* 1655 */       return 0;
/*      */     }
/* 1657 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1663 */     int nFieldType = -1;
/* 1664 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1666 */       nFieldType = 0;
/* 1667 */       break;
/*      */     case 1:
/* 1669 */       nFieldType = 0;
/* 1670 */       break;
/*      */     case 2:
/* 1672 */       nFieldType = 0;
/* 1673 */       break;
/*      */     case 3:
/* 1675 */       nFieldType = 0;
/* 1676 */       break;
/*      */     case 4:
/* 1678 */       nFieldType = 0;
/* 1679 */       break;
/*      */     case 5:
/* 1681 */       nFieldType = 0;
/* 1682 */       break;
/*      */     case 6:
/* 1684 */       nFieldType = 0;
/* 1685 */       break;
/*      */     case 7:
/* 1687 */       nFieldType = 0;
/* 1688 */       break;
/*      */     case 8:
/* 1690 */       nFieldType = 0;
/* 1691 */       break;
/*      */     case 9:
/* 1693 */       nFieldType = 0;
/* 1694 */       break;
/*      */     case 10:
/* 1696 */       nFieldType = 0;
/* 1697 */       break;
/*      */     case 11:
/* 1699 */       nFieldType = 0;
/* 1700 */       break;
/*      */     case 12:
/* 1702 */       nFieldType = 0;
/* 1703 */       break;
/*      */     case 13:
/* 1705 */       nFieldType = 0;
/* 1706 */       break;
/*      */     case 14:
/* 1708 */       nFieldType = 0;
/* 1709 */       break;
/*      */     case 15:
/* 1711 */       nFieldType = 0;
/* 1712 */       break;
/*      */     case 16:
/* 1714 */       nFieldType = 0;
/* 1715 */       break;
/*      */     case 17:
/* 1717 */       nFieldType = 0;
/* 1718 */       break;
/*      */     case 18:
/* 1720 */       nFieldType = 0;
/* 1721 */       break;
/*      */     case 19:
/* 1723 */       nFieldType = 0;
/* 1724 */       break;
/*      */     case 20:
/* 1726 */       nFieldType = 0;
/* 1727 */       break;
/*      */     case 21:
/* 1729 */       nFieldType = 0;
/* 1730 */       break;
/*      */     case 22:
/* 1732 */       nFieldType = 0;
/* 1733 */       break;
/*      */     case 23:
/* 1735 */       nFieldType = 0;
/* 1736 */       break;
/*      */     case 24:
/* 1738 */       nFieldType = 0;
/* 1739 */       break;
/*      */     case 25:
/* 1741 */       nFieldType = 0;
/* 1742 */       break;
/*      */     case 26:
/* 1744 */       nFieldType = 1;
/* 1745 */       break;
/*      */     case 27:
/* 1747 */       nFieldType = 0;
/* 1748 */       break;
/*      */     case 28:
/* 1750 */       nFieldType = 1;
/* 1751 */       break;
/*      */     case 29:
/* 1753 */       nFieldType = 0;
/* 1754 */       break;
/*      */     case 30:
/* 1756 */       nFieldType = 0;
/* 1757 */       break;
/*      */     case 31:
/* 1759 */       nFieldType = 0;
/* 1760 */       break;
/*      */     default:
/* 1762 */       nFieldType = -1;
/*      */     }
/* 1764 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPAddressSchema
 * JD-Core Version:    0.6.0
 */