/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPAddressBDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.FDate;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.Schema;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.util.Date;
/*      */ 
/*      */ public class LNPAddressBSchema
/*      */   implements Schema
/*      */ {
/*      */   private String EdorNo;
/*      */   private String serialNo;
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
/*      */   public static final int FIELDNUM = 34;
/*      */   private static String[] PK;
/*   93 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public LNPAddressBSchema()
/*      */   {
/*  100 */     this.mErrors = new CErrors();
/*      */ 
/*  102 */     String[] pk = new String[2];
/*  103 */     pk[0] = "EdorNo";
/*  104 */     pk[1] = "serialNo";
/*      */ 
/*  106 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public String[] getPK()
/*      */   {
/*  112 */     return PK;
/*      */   }
/*      */ 
/*      */   public String getEdorNo()
/*      */   {
/*  117 */     if (this.EdorNo != null) this.EdorNo.equals("");
/*      */ 
/*  121 */     return this.EdorNo;
/*      */   }
/*      */ 
/*      */   public void setEdorNo(String aEdorNo) {
/*  125 */     this.EdorNo = aEdorNo;
/*      */   }
/*      */ 
/*      */   public String getserialNo() {
/*  129 */     if (this.serialNo != null) this.serialNo.equals("");
/*      */ 
/*  133 */     return this.serialNo;
/*      */   }
/*      */ 
/*      */   public void setserialNo(String aserialNo) {
/*  137 */     this.serialNo = aserialNo;
/*      */   }
/*      */ 
/*      */   public String getcustomerId() {
/*  141 */     if (this.customerId != null) this.customerId.equals("");
/*      */ 
/*  145 */     return this.customerId;
/*      */   }
/*      */ 
/*      */   public void setcustomerId(String acustomerId) {
/*  149 */     this.customerId = acustomerId;
/*      */   }
/*      */ 
/*      */   public String getcustomerNo() {
/*  153 */     if (this.customerNo != null) this.customerNo.equals("");
/*      */ 
/*  157 */     return this.customerNo;
/*      */   }
/*      */ 
/*      */   public void setcustomerNo(String acustomerNo) {
/*  161 */     this.customerNo = acustomerNo;
/*      */   }
/*      */ 
/*      */   public String getaddressNo() {
/*  165 */     if (this.addressNo != null) this.addressNo.equals("");
/*      */ 
/*  169 */     return this.addressNo;
/*      */   }
/*      */ 
/*      */   public void setaddressNo(String aaddressNo) {
/*  173 */     this.addressNo = aaddressNo;
/*      */   }
/*      */ 
/*      */   public String getpostalAddress() {
/*  177 */     if (this.postalAddress != null) this.postalAddress.equals("");
/*      */ 
/*  181 */     return this.postalAddress;
/*      */   }
/*      */ 
/*      */   public void setpostalAddress(String apostalAddress) {
/*  185 */     this.postalAddress = apostalAddress;
/*      */   }
/*      */ 
/*      */   public String getzipCode() {
/*  189 */     if (this.zipCode != null) this.zipCode.equals("");
/*      */ 
/*  193 */     return this.zipCode;
/*      */   }
/*      */ 
/*      */   public void setzipCode(String azipCode) {
/*  197 */     this.zipCode = azipCode;
/*      */   }
/*      */ 
/*      */   public String getphone() {
/*  201 */     if (this.phone != null) this.phone.equals("");
/*      */ 
/*  205 */     return this.phone;
/*      */   }
/*      */ 
/*      */   public void setphone(String aphone) {
/*  209 */     this.phone = aphone;
/*      */   }
/*      */ 
/*      */   public String getfax() {
/*  213 */     if (this.fax != null) this.fax.equals("");
/*      */ 
/*  217 */     return this.fax;
/*      */   }
/*      */ 
/*      */   public void setfax(String afax) {
/*  221 */     this.fax = afax;
/*      */   }
/*      */ 
/*      */   public String getduchy() {
/*  225 */     if (this.duchy != null) this.duchy.equals("");
/*      */ 
/*  229 */     return this.duchy;
/*      */   }
/*      */ 
/*      */   public void setduchy(String aduchy) {
/*  233 */     this.duchy = aduchy;
/*      */   }
/*      */ 
/*      */   public String gethomeAddress() {
/*  237 */     if (this.homeAddress != null) this.homeAddress.equals("");
/*      */ 
/*  241 */     return this.homeAddress;
/*      */   }
/*      */ 
/*      */   public void sethomeAddress(String ahomeAddress) {
/*  245 */     this.homeAddress = ahomeAddress;
/*      */   }
/*      */ 
/*      */   public String gethomeZipCode() {
/*  249 */     if (this.homeZipCode != null) this.homeZipCode.equals("");
/*      */ 
/*  253 */     return this.homeZipCode;
/*      */   }
/*      */ 
/*      */   public void sethomeZipCode(String ahomeZipCode) {
/*  257 */     this.homeZipCode = ahomeZipCode;
/*      */   }
/*      */ 
/*      */   public String gethomePhone() {
/*  261 */     if (this.homePhone != null) this.homePhone.equals("");
/*      */ 
/*  265 */     return this.homePhone;
/*      */   }
/*      */ 
/*      */   public void sethomePhone(String ahomePhone) {
/*  269 */     this.homePhone = ahomePhone;
/*      */   }
/*      */ 
/*      */   public String gethomeFax() {
/*  273 */     if (this.homeFax != null) this.homeFax.equals("");
/*      */ 
/*  277 */     return this.homeFax;
/*      */   }
/*      */ 
/*      */   public void sethomeFax(String ahomeFax) {
/*  281 */     this.homeFax = ahomeFax;
/*      */   }
/*      */ 
/*      */   public String getcompanyAddress() {
/*  285 */     if (this.companyAddress != null) this.companyAddress.equals("");
/*      */ 
/*  289 */     return this.companyAddress;
/*      */   }
/*      */ 
/*      */   public void setcompanyAddress(String acompanyAddress) {
/*  293 */     this.companyAddress = acompanyAddress;
/*      */   }
/*      */ 
/*      */   public String getcompanyZipCode() {
/*  297 */     if (this.companyZipCode != null) this.companyZipCode.equals("");
/*      */ 
/*  301 */     return this.companyZipCode;
/*      */   }
/*      */ 
/*      */   public void setcompanyZipCode(String acompanyZipCode) {
/*  305 */     this.companyZipCode = acompanyZipCode;
/*      */   }
/*      */ 
/*      */   public String getcompanyPhone() {
/*  309 */     if (this.companyPhone != null) this.companyPhone.equals("");
/*      */ 
/*  313 */     return this.companyPhone;
/*      */   }
/*      */ 
/*      */   public void setcompanyPhone(String acompanyPhone) {
/*  317 */     this.companyPhone = acompanyPhone;
/*      */   }
/*      */ 
/*      */   public String getcompanyFax() {
/*  321 */     if (this.companyFax != null) this.companyFax.equals("");
/*      */ 
/*  325 */     return this.companyFax;
/*      */   }
/*      */ 
/*      */   public void setcompanyFax(String acompanyFax) {
/*  329 */     this.companyFax = acompanyFax;
/*      */   }
/*      */ 
/*      */   public String getcompanyMail() {
/*  333 */     if (this.companyMail != null) this.companyMail.equals("");
/*      */ 
/*  337 */     return this.companyMail;
/*      */   }
/*      */ 
/*      */   public void setcompanyMail(String acompanyMail) {
/*  341 */     this.companyMail = acompanyMail;
/*      */   }
/*      */ 
/*      */   public String getmobile() {
/*  345 */     if (this.mobile != null) this.mobile.equals("");
/*      */ 
/*  349 */     return this.mobile;
/*      */   }
/*      */ 
/*      */   public void setmobile(String amobile) {
/*  353 */     this.mobile = amobile;
/*      */   }
/*      */ 
/*      */   public String getmobileChs() {
/*  357 */     if (this.mobileChs != null) this.mobileChs.equals("");
/*      */ 
/*  361 */     return this.mobileChs;
/*      */   }
/*      */ 
/*      */   public void setmobileChs(String amobileChs) {
/*  365 */     this.mobileChs = amobileChs;
/*      */   }
/*      */ 
/*      */   public String geteMail() {
/*  369 */     if (this.eMail != null) this.eMail.equals("");
/*      */ 
/*  373 */     return this.eMail;
/*      */   }
/*      */ 
/*      */   public void seteMail(String aeMail) {
/*  377 */     this.eMail = aeMail;
/*      */   }
/*      */ 
/*      */   public String getbP() {
/*  381 */     if (this.bP != null) this.bP.equals("");
/*      */ 
/*  385 */     return this.bP;
/*      */   }
/*      */ 
/*      */   public void setbP(String abP) {
/*  389 */     this.bP = abP;
/*      */   }
/*      */ 
/*      */   public String getmobile2() {
/*  393 */     if (this.mobile2 != null) this.mobile2.equals("");
/*      */ 
/*  397 */     return this.mobile2;
/*      */   }
/*      */ 
/*      */   public void setmobile2(String amobile2) {
/*  401 */     this.mobile2 = amobile2;
/*      */   }
/*      */ 
/*      */   public String getmobileChs2() {
/*  405 */     if (this.mobileChs2 != null) this.mobileChs2.equals("");
/*      */ 
/*  409 */     return this.mobileChs2;
/*      */   }
/*      */ 
/*      */   public void setmobileChs2(String amobileChs2) {
/*  413 */     this.mobileChs2 = amobileChs2;
/*      */   }
/*      */ 
/*      */   public String geteMail2() {
/*  417 */     if (this.eMail2 != null) this.eMail2.equals("");
/*      */ 
/*  421 */     return this.eMail2;
/*      */   }
/*      */ 
/*      */   public void seteMail2(String aeMail2) {
/*  425 */     this.eMail2 = aeMail2;
/*      */   }
/*      */ 
/*      */   public String getbP2() {
/*  429 */     if (this.bP2 != null) this.bP2.equals("");
/*      */ 
/*  433 */     return this.bP2;
/*      */   }
/*      */ 
/*      */   public void setbP2(String abP2) {
/*  437 */     this.bP2 = abP2;
/*      */   }
/*      */ 
/*      */   public String getoperator() {
/*  441 */     if (this.operator != null) this.operator.equals("");
/*      */ 
/*  445 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setoperator(String aoperator) {
/*  449 */     this.operator = aoperator;
/*      */   }
/*      */ 
/*      */   public String getmakeDate() {
/*  453 */     if (this.makeDate != null) {
/*  454 */       return this.fDate.getString(this.makeDate);
/*      */     }
/*  456 */     return null;
/*      */   }
/*      */ 
/*      */   public void setmakeDate(Date amakeDate) {
/*  460 */     this.makeDate = amakeDate;
/*      */   }
/*      */ 
/*      */   public void setmakeDate(String amakeDate) {
/*  464 */     if ((amakeDate != null) && (!amakeDate.equals("")))
/*      */     {
/*  466 */       this.makeDate = this.fDate.getDate(amakeDate);
/*      */     }
/*      */     else
/*  469 */       this.makeDate = null;
/*      */   }
/*      */ 
/*      */   public String getmakeTime()
/*      */   {
/*  474 */     if (this.makeTime != null) this.makeTime.equals("");
/*      */ 
/*  478 */     return this.makeTime;
/*      */   }
/*      */ 
/*      */   public void setmakeTime(String amakeTime) {
/*  482 */     this.makeTime = amakeTime;
/*      */   }
/*      */ 
/*      */   public String getmodifyDate() {
/*  486 */     if (this.modifyDate != null) {
/*  487 */       return this.fDate.getString(this.modifyDate);
/*      */     }
/*  489 */     return null;
/*      */   }
/*      */ 
/*      */   public void setmodifyDate(Date amodifyDate) {
/*  493 */     this.modifyDate = amodifyDate;
/*      */   }
/*      */ 
/*      */   public void setmodifyDate(String amodifyDate) {
/*  497 */     if ((amodifyDate != null) && (!amodifyDate.equals("")))
/*      */     {
/*  499 */       this.modifyDate = this.fDate.getDate(amodifyDate);
/*      */     }
/*      */     else
/*  502 */       this.modifyDate = null;
/*      */   }
/*      */ 
/*      */   public String getmodifyTime()
/*      */   {
/*  507 */     if (this.modifyTime != null) this.modifyTime.equals("");
/*      */ 
/*  511 */     return this.modifyTime;
/*      */   }
/*      */ 
/*      */   public void setmodifyTime(String amodifyTime) {
/*  515 */     this.modifyTime = amodifyTime;
/*      */   }
/*      */ 
/*      */   public String getgrpName() {
/*  519 */     if (this.grpName != null) this.grpName.equals("");
/*      */ 
/*  523 */     return this.grpName;
/*      */   }
/*      */ 
/*      */   public void setgrpName(String agrpName) {
/*  527 */     this.grpName = agrpName;
/*      */   }
/*      */ 
/*      */   public String getotherDuchy() {
/*  531 */     if (this.otherDuchy != null) this.otherDuchy.equals("");
/*      */ 
/*  535 */     return this.otherDuchy;
/*      */   }
/*      */ 
/*      */   public void setotherDuchy(String aotherDuchy) {
/*  539 */     this.otherDuchy = aotherDuchy;
/*      */   }
/*      */ 
/*      */   public void setSchema(LNPAddressBSchema aLNPAddressBSchema)
/*      */   {
/*  545 */     this.EdorNo = aLNPAddressBSchema.getEdorNo();
/*  546 */     this.serialNo = aLNPAddressBSchema.getserialNo();
/*  547 */     this.customerId = aLNPAddressBSchema.getcustomerId();
/*  548 */     this.customerNo = aLNPAddressBSchema.getcustomerNo();
/*  549 */     this.addressNo = aLNPAddressBSchema.getaddressNo();
/*  550 */     this.postalAddress = aLNPAddressBSchema.getpostalAddress();
/*  551 */     this.zipCode = aLNPAddressBSchema.getzipCode();
/*  552 */     this.phone = aLNPAddressBSchema.getphone();
/*  553 */     this.fax = aLNPAddressBSchema.getfax();
/*  554 */     this.duchy = aLNPAddressBSchema.getduchy();
/*  555 */     this.homeAddress = aLNPAddressBSchema.gethomeAddress();
/*  556 */     this.homeZipCode = aLNPAddressBSchema.gethomeZipCode();
/*  557 */     this.homePhone = aLNPAddressBSchema.gethomePhone();
/*  558 */     this.homeFax = aLNPAddressBSchema.gethomeFax();
/*  559 */     this.companyAddress = aLNPAddressBSchema.getcompanyAddress();
/*  560 */     this.companyZipCode = aLNPAddressBSchema.getcompanyZipCode();
/*  561 */     this.companyPhone = aLNPAddressBSchema.getcompanyPhone();
/*  562 */     this.companyFax = aLNPAddressBSchema.getcompanyFax();
/*  563 */     this.companyMail = aLNPAddressBSchema.getcompanyMail();
/*  564 */     this.mobile = aLNPAddressBSchema.getmobile();
/*  565 */     this.mobileChs = aLNPAddressBSchema.getmobileChs();
/*  566 */     this.eMail = aLNPAddressBSchema.geteMail();
/*  567 */     this.bP = aLNPAddressBSchema.getbP();
/*  568 */     this.mobile2 = aLNPAddressBSchema.getmobile2();
/*  569 */     this.mobileChs2 = aLNPAddressBSchema.getmobileChs2();
/*  570 */     this.eMail2 = aLNPAddressBSchema.geteMail2();
/*  571 */     this.bP2 = aLNPAddressBSchema.getbP2();
/*  572 */     this.operator = aLNPAddressBSchema.getoperator();
/*  573 */     this.makeDate = this.fDate.getDate(aLNPAddressBSchema.getmakeDate());
/*  574 */     this.makeTime = aLNPAddressBSchema.getmakeTime();
/*  575 */     this.modifyDate = this.fDate.getDate(aLNPAddressBSchema.getmodifyDate());
/*  576 */     this.modifyTime = aLNPAddressBSchema.getmodifyTime();
/*  577 */     this.grpName = aLNPAddressBSchema.getgrpName();
/*  578 */     this.otherDuchy = aLNPAddressBSchema.getotherDuchy();
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i)
/*      */   {
/*      */     try
/*      */     {
/*  587 */       if (rs.getString("EdorNo") == null)
/*  588 */         this.EdorNo = null;
/*      */       else {
/*  590 */         this.EdorNo = rs.getString("EdorNo").trim();
/*      */       }
/*  592 */       if (rs.getString("serialNo") == null)
/*  593 */         this.serialNo = null;
/*      */       else {
/*  595 */         this.serialNo = rs.getString("serialNo").trim();
/*      */       }
/*  597 */       if (rs.getString("customerId") == null)
/*  598 */         this.customerId = null;
/*      */       else {
/*  600 */         this.customerId = rs.getString("customerId").trim();
/*      */       }
/*  602 */       if (rs.getString("customerNo") == null)
/*  603 */         this.customerNo = null;
/*      */       else {
/*  605 */         this.customerNo = rs.getString("customerNo").trim();
/*      */       }
/*  607 */       if (rs.getString("addressNo") == null)
/*  608 */         this.addressNo = null;
/*      */       else {
/*  610 */         this.addressNo = rs.getString("addressNo").trim();
/*      */       }
/*  612 */       if (rs.getString("postalAddress") == null)
/*  613 */         this.postalAddress = null;
/*      */       else {
/*  615 */         this.postalAddress = rs.getString("postalAddress").trim();
/*      */       }
/*  617 */       if (rs.getString("zipCode") == null)
/*  618 */         this.zipCode = null;
/*      */       else {
/*  620 */         this.zipCode = rs.getString("zipCode").trim();
/*      */       }
/*  622 */       if (rs.getString("phone") == null)
/*  623 */         this.phone = null;
/*      */       else {
/*  625 */         this.phone = rs.getString("phone").trim();
/*      */       }
/*  627 */       if (rs.getString("fax") == null)
/*  628 */         this.fax = null;
/*      */       else {
/*  630 */         this.fax = rs.getString("fax").trim();
/*      */       }
/*  632 */       if (rs.getString("duchy") == null)
/*  633 */         this.duchy = null;
/*      */       else {
/*  635 */         this.duchy = rs.getString("duchy").trim();
/*      */       }
/*  637 */       if (rs.getString("homeAddress") == null)
/*  638 */         this.homeAddress = null;
/*      */       else {
/*  640 */         this.homeAddress = rs.getString("homeAddress").trim();
/*      */       }
/*  642 */       if (rs.getString("homeZipCode") == null)
/*  643 */         this.homeZipCode = null;
/*      */       else {
/*  645 */         this.homeZipCode = rs.getString("homeZipCode").trim();
/*      */       }
/*  647 */       if (rs.getString("homePhone") == null)
/*  648 */         this.homePhone = null;
/*      */       else {
/*  650 */         this.homePhone = rs.getString("homePhone").trim();
/*      */       }
/*  652 */       if (rs.getString("homeFax") == null)
/*  653 */         this.homeFax = null;
/*      */       else {
/*  655 */         this.homeFax = rs.getString("homeFax").trim();
/*      */       }
/*  657 */       if (rs.getString("companyAddress") == null)
/*  658 */         this.companyAddress = null;
/*      */       else {
/*  660 */         this.companyAddress = rs.getString("companyAddress").trim();
/*      */       }
/*  662 */       if (rs.getString("companyZipCode") == null)
/*  663 */         this.companyZipCode = null;
/*      */       else {
/*  665 */         this.companyZipCode = rs.getString("companyZipCode").trim();
/*      */       }
/*  667 */       if (rs.getString("companyPhone") == null)
/*  668 */         this.companyPhone = null;
/*      */       else {
/*  670 */         this.companyPhone = rs.getString("companyPhone").trim();
/*      */       }
/*  672 */       if (rs.getString("companyFax") == null)
/*  673 */         this.companyFax = null;
/*      */       else {
/*  675 */         this.companyFax = rs.getString("companyFax").trim();
/*      */       }
/*  677 */       if (rs.getString("companyMail") == null)
/*  678 */         this.companyMail = null;
/*      */       else {
/*  680 */         this.companyMail = rs.getString("companyMail").trim();
/*      */       }
/*  682 */       if (rs.getString("mobile") == null)
/*  683 */         this.mobile = null;
/*      */       else {
/*  685 */         this.mobile = rs.getString("mobile").trim();
/*      */       }
/*  687 */       if (rs.getString("mobileChs") == null)
/*  688 */         this.mobileChs = null;
/*      */       else {
/*  690 */         this.mobileChs = rs.getString("mobileChs").trim();
/*      */       }
/*  692 */       if (rs.getString("eMail") == null)
/*  693 */         this.eMail = null;
/*      */       else {
/*  695 */         this.eMail = rs.getString("eMail").trim();
/*      */       }
/*  697 */       if (rs.getString("bP") == null)
/*  698 */         this.bP = null;
/*      */       else {
/*  700 */         this.bP = rs.getString("bP").trim();
/*      */       }
/*  702 */       if (rs.getString("mobile2") == null)
/*  703 */         this.mobile2 = null;
/*      */       else {
/*  705 */         this.mobile2 = rs.getString("mobile2").trim();
/*      */       }
/*  707 */       if (rs.getString("mobileChs2") == null)
/*  708 */         this.mobileChs2 = null;
/*      */       else {
/*  710 */         this.mobileChs2 = rs.getString("mobileChs2").trim();
/*      */       }
/*  712 */       if (rs.getString("eMail2") == null)
/*  713 */         this.eMail2 = null;
/*      */       else {
/*  715 */         this.eMail2 = rs.getString("eMail2").trim();
/*      */       }
/*  717 */       if (rs.getString("bP2") == null)
/*  718 */         this.bP2 = null;
/*      */       else {
/*  720 */         this.bP2 = rs.getString("bP2").trim();
/*      */       }
/*  722 */       if (rs.getString("operator") == null)
/*  723 */         this.operator = null;
/*      */       else {
/*  725 */         this.operator = rs.getString("operator").trim();
/*      */       }
/*  727 */       this.makeDate = rs.getDate("makeDate");
/*  728 */       if (rs.getString("makeTime") == null)
/*  729 */         this.makeTime = null;
/*      */       else {
/*  731 */         this.makeTime = rs.getString("makeTime").trim();
/*      */       }
/*  733 */       this.modifyDate = rs.getDate("modifyDate");
/*  734 */       if (rs.getString("modifyTime") == null)
/*  735 */         this.modifyTime = null;
/*      */       else {
/*  737 */         this.modifyTime = rs.getString("modifyTime").trim();
/*      */       }
/*  739 */       if (rs.getString("grpName") == null)
/*  740 */         this.grpName = null;
/*      */       else {
/*  742 */         this.grpName = rs.getString("grpName").trim();
/*      */       }
/*  744 */       if (rs.getString("otherDuchy") == null)
/*  745 */         this.otherDuchy = null;
/*      */       else {
/*  747 */         this.otherDuchy = rs.getString("otherDuchy").trim();
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/*  753 */       CError tError = new CError();
/*  754 */       tError.moduleName = "LNPAddressBSchema";
/*  755 */       tError.functionName = "setSchema";
/*  756 */       tError.errorMessage = sqle.toString();
/*  757 */       this.mErrors.addOneError(tError);
/*      */ 
/*  759 */       return false;
/*      */     }
/*  761 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPAddressBSchema getSchema()
/*      */   {
/*  766 */     LNPAddressBSchema aLNPAddressBSchema = new LNPAddressBSchema();
/*  767 */     aLNPAddressBSchema.setSchema(this);
/*  768 */     return aLNPAddressBSchema;
/*      */   }
/*      */ 
/*      */   public LNPAddressBDB getDB()
/*      */   {
/*  773 */     LNPAddressBDB aDBOper = new LNPAddressBDB();
/*  774 */     aDBOper.setSchema(this);
/*  775 */     return aDBOper;
/*      */   }
/*      */ 
/*      */   public String encode()
/*      */   {
/*  782 */     String strReturn = "";
/*  783 */     strReturn = StrTool.cTrim(StrTool.unicodeToGBK(this.EdorNo)) + "|" + 
/*  784 */       StrTool.cTrim(StrTool.unicodeToGBK(this.serialNo)) + "|" + 
/*  785 */       StrTool.cTrim(StrTool.unicodeToGBK(this.customerId)) + "|" + 
/*  786 */       StrTool.cTrim(StrTool.unicodeToGBK(this.customerNo)) + "|" + 
/*  787 */       StrTool.cTrim(StrTool.unicodeToGBK(this.addressNo)) + "|" + 
/*  788 */       StrTool.cTrim(StrTool.unicodeToGBK(this.postalAddress)) + "|" + 
/*  789 */       StrTool.cTrim(StrTool.unicodeToGBK(this.zipCode)) + "|" + 
/*  790 */       StrTool.cTrim(StrTool.unicodeToGBK(this.phone)) + "|" + 
/*  791 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fax)) + "|" + 
/*  792 */       StrTool.cTrim(StrTool.unicodeToGBK(this.duchy)) + "|" + 
/*  793 */       StrTool.cTrim(StrTool.unicodeToGBK(this.homeAddress)) + "|" + 
/*  794 */       StrTool.cTrim(StrTool.unicodeToGBK(this.homeZipCode)) + "|" + 
/*  795 */       StrTool.cTrim(StrTool.unicodeToGBK(this.homePhone)) + "|" + 
/*  796 */       StrTool.cTrim(StrTool.unicodeToGBK(this.homeFax)) + "|" + 
/*  797 */       StrTool.cTrim(StrTool.unicodeToGBK(this.companyAddress)) + "|" + 
/*  798 */       StrTool.cTrim(StrTool.unicodeToGBK(this.companyZipCode)) + "|" + 
/*  799 */       StrTool.cTrim(StrTool.unicodeToGBK(this.companyPhone)) + "|" + 
/*  800 */       StrTool.cTrim(StrTool.unicodeToGBK(this.companyFax)) + "|" + 
/*  801 */       StrTool.cTrim(StrTool.unicodeToGBK(this.companyMail)) + "|" + 
/*  802 */       StrTool.cTrim(StrTool.unicodeToGBK(this.mobile)) + "|" + 
/*  803 */       StrTool.cTrim(StrTool.unicodeToGBK(this.mobileChs)) + "|" + 
/*  804 */       StrTool.cTrim(StrTool.unicodeToGBK(this.eMail)) + "|" + 
/*  805 */       StrTool.cTrim(StrTool.unicodeToGBK(this.bP)) + "|" + 
/*  806 */       StrTool.cTrim(StrTool.unicodeToGBK(this.mobile2)) + "|" + 
/*  807 */       StrTool.cTrim(StrTool.unicodeToGBK(this.mobileChs2)) + "|" + 
/*  808 */       StrTool.cTrim(StrTool.unicodeToGBK(this.eMail2)) + "|" + 
/*  809 */       StrTool.cTrim(StrTool.unicodeToGBK(this.bP2)) + "|" + 
/*  810 */       StrTool.cTrim(StrTool.unicodeToGBK(this.operator)) + "|" + 
/*  811 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.makeDate))) + "|" + 
/*  812 */       StrTool.cTrim(StrTool.unicodeToGBK(this.makeTime)) + "|" + 
/*  813 */       StrTool.cTrim(StrTool.unicodeToGBK(this.fDate.getString(this.modifyDate))) + "|" + 
/*  814 */       StrTool.cTrim(StrTool.unicodeToGBK(this.modifyTime)) + "|" + 
/*  815 */       StrTool.cTrim(StrTool.unicodeToGBK(this.grpName)) + "|" + 
/*  816 */       StrTool.cTrim(StrTool.unicodeToGBK(this.otherDuchy));
/*  817 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try
/*      */     {
/*  825 */       this.EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/*  826 */       this.serialNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/*  827 */       this.customerId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/*  828 */       this.customerNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/*  829 */       this.addressNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/*  830 */       this.postalAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/*  831 */       this.zipCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/*  832 */       this.phone = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/*  833 */       this.fax = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/*  834 */       this.duchy = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/*  835 */       this.homeAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/*  836 */       this.homeZipCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/*  837 */       this.homePhone = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/*  838 */       this.homeFax = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/*  839 */       this.companyAddress = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/*  840 */       this.companyZipCode = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/*  841 */       this.companyPhone = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/*  842 */       this.companyFax = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/*  843 */       this.companyMail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/*  844 */       this.mobile = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/*  845 */       this.mobileChs = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/*  846 */       this.eMail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/*  847 */       this.bP = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/*  848 */       this.mobile2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/*  849 */       this.mobileChs2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/*  850 */       this.eMail2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/*  851 */       this.bP2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/*  852 */       this.operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
/*  853 */       this.makeDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|"));
/*  854 */       this.makeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
/*  855 */       this.modifyDate = this.fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|"));
/*  856 */       this.modifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 32, "|");
/*  857 */       this.grpName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 33, "|");
/*  858 */       this.otherDuchy = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 34, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/*  863 */       CError tError = new CError();
/*  864 */       tError.moduleName = "LNPAddressBSchema";
/*  865 */       tError.functionName = "decode";
/*  866 */       tError.errorMessage = ex.toString();
/*  867 */       this.mErrors.addOneError(tError);
/*      */ 
/*  869 */       return false;
/*      */     }
/*  871 */     return true;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode)
/*      */   {
/*  877 */     String strReturn = "";
/*  878 */     if (FCode.equals("EdorNo"))
/*      */     {
/*  880 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.EdorNo));
/*      */     }
/*  882 */     if (FCode.equals("serialNo"))
/*      */     {
/*  884 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.serialNo));
/*      */     }
/*  886 */     if (FCode.equals("customerId"))
/*      */     {
/*  888 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.customerId));
/*      */     }
/*  890 */     if (FCode.equals("customerNo"))
/*      */     {
/*  892 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.customerNo));
/*      */     }
/*  894 */     if (FCode.equals("addressNo"))
/*      */     {
/*  896 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.addressNo));
/*      */     }
/*  898 */     if (FCode.equals("postalAddress"))
/*      */     {
/*  900 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.postalAddress));
/*      */     }
/*  902 */     if (FCode.equals("zipCode"))
/*      */     {
/*  904 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.zipCode));
/*      */     }
/*  906 */     if (FCode.equals("phone"))
/*      */     {
/*  908 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.phone));
/*      */     }
/*  910 */     if (FCode.equals("fax"))
/*      */     {
/*  912 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.fax));
/*      */     }
/*  914 */     if (FCode.equals("duchy"))
/*      */     {
/*  916 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.duchy));
/*      */     }
/*  918 */     if (FCode.equals("homeAddress"))
/*      */     {
/*  920 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.homeAddress));
/*      */     }
/*  922 */     if (FCode.equals("homeZipCode"))
/*      */     {
/*  924 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.homeZipCode));
/*      */     }
/*  926 */     if (FCode.equals("homePhone"))
/*      */     {
/*  928 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.homePhone));
/*      */     }
/*  930 */     if (FCode.equals("homeFax"))
/*      */     {
/*  932 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.homeFax));
/*      */     }
/*  934 */     if (FCode.equals("companyAddress"))
/*      */     {
/*  936 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.companyAddress));
/*      */     }
/*  938 */     if (FCode.equals("companyZipCode"))
/*      */     {
/*  940 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.companyZipCode));
/*      */     }
/*  942 */     if (FCode.equals("companyPhone"))
/*      */     {
/*  944 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.companyPhone));
/*      */     }
/*  946 */     if (FCode.equals("companyFax"))
/*      */     {
/*  948 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.companyFax));
/*      */     }
/*  950 */     if (FCode.equals("companyMail"))
/*      */     {
/*  952 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.companyMail));
/*      */     }
/*  954 */     if (FCode.equals("mobile"))
/*      */     {
/*  956 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.mobile));
/*      */     }
/*  958 */     if (FCode.equals("mobileChs"))
/*      */     {
/*  960 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.mobileChs));
/*      */     }
/*  962 */     if (FCode.equals("eMail"))
/*      */     {
/*  964 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.eMail));
/*      */     }
/*  966 */     if (FCode.equals("bP"))
/*      */     {
/*  968 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bP));
/*      */     }
/*  970 */     if (FCode.equals("mobile2"))
/*      */     {
/*  972 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.mobile2));
/*      */     }
/*  974 */     if (FCode.equals("mobileChs2"))
/*      */     {
/*  976 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.mobileChs2));
/*      */     }
/*  978 */     if (FCode.equals("eMail2"))
/*      */     {
/*  980 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.eMail2));
/*      */     }
/*  982 */     if (FCode.equals("bP2"))
/*      */     {
/*  984 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.bP2));
/*      */     }
/*  986 */     if (FCode.equals("operator"))
/*      */     {
/*  988 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.operator));
/*      */     }
/*  990 */     if (FCode.equals("makeDate"))
/*      */     {
/*  992 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
/*      */     }
/*  994 */     if (FCode.equals("makeTime"))
/*      */     {
/*  996 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.makeTime));
/*      */     }
/*  998 */     if (FCode.equals("modifyDate"))
/*      */     {
/* 1000 */       strReturn = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
/*      */     }
/* 1002 */     if (FCode.equals("modifyTime"))
/*      */     {
/* 1004 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.modifyTime));
/*      */     }
/* 1006 */     if (FCode.equals("grpName"))
/*      */     {
/* 1008 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.grpName));
/*      */     }
/* 1010 */     if (FCode.equals("otherDuchy"))
/*      */     {
/* 1012 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.otherDuchy));
/*      */     }
/* 1014 */     if (strReturn.equals(""))
/*      */     {
/* 1016 */       strReturn = "null";
/*      */     }
/*      */ 
/* 1019 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex)
/*      */   {
/* 1026 */     String strFieldValue = "";
/* 1027 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1029 */       strFieldValue = StrTool.GBKToUnicode(this.EdorNo);
/* 1030 */       break;
/*      */     case 1:
/* 1032 */       strFieldValue = StrTool.GBKToUnicode(this.serialNo);
/* 1033 */       break;
/*      */     case 2:
/* 1035 */       strFieldValue = StrTool.GBKToUnicode(this.customerId);
/* 1036 */       break;
/*      */     case 3:
/* 1038 */       strFieldValue = StrTool.GBKToUnicode(this.customerNo);
/* 1039 */       break;
/*      */     case 4:
/* 1041 */       strFieldValue = StrTool.GBKToUnicode(this.addressNo);
/* 1042 */       break;
/*      */     case 5:
/* 1044 */       strFieldValue = StrTool.GBKToUnicode(this.postalAddress);
/* 1045 */       break;
/*      */     case 6:
/* 1047 */       strFieldValue = StrTool.GBKToUnicode(this.zipCode);
/* 1048 */       break;
/*      */     case 7:
/* 1050 */       strFieldValue = StrTool.GBKToUnicode(this.phone);
/* 1051 */       break;
/*      */     case 8:
/* 1053 */       strFieldValue = StrTool.GBKToUnicode(this.fax);
/* 1054 */       break;
/*      */     case 9:
/* 1056 */       strFieldValue = StrTool.GBKToUnicode(this.duchy);
/* 1057 */       break;
/*      */     case 10:
/* 1059 */       strFieldValue = StrTool.GBKToUnicode(this.homeAddress);
/* 1060 */       break;
/*      */     case 11:
/* 1062 */       strFieldValue = StrTool.GBKToUnicode(this.homeZipCode);
/* 1063 */       break;
/*      */     case 12:
/* 1065 */       strFieldValue = StrTool.GBKToUnicode(this.homePhone);
/* 1066 */       break;
/*      */     case 13:
/* 1068 */       strFieldValue = StrTool.GBKToUnicode(this.homeFax);
/* 1069 */       break;
/*      */     case 14:
/* 1071 */       strFieldValue = StrTool.GBKToUnicode(this.companyAddress);
/* 1072 */       break;
/*      */     case 15:
/* 1074 */       strFieldValue = StrTool.GBKToUnicode(this.companyZipCode);
/* 1075 */       break;
/*      */     case 16:
/* 1077 */       strFieldValue = StrTool.GBKToUnicode(this.companyPhone);
/* 1078 */       break;
/*      */     case 17:
/* 1080 */       strFieldValue = StrTool.GBKToUnicode(this.companyFax);
/* 1081 */       break;
/*      */     case 18:
/* 1083 */       strFieldValue = StrTool.GBKToUnicode(this.companyMail);
/* 1084 */       break;
/*      */     case 19:
/* 1086 */       strFieldValue = StrTool.GBKToUnicode(this.mobile);
/* 1087 */       break;
/*      */     case 20:
/* 1089 */       strFieldValue = StrTool.GBKToUnicode(this.mobileChs);
/* 1090 */       break;
/*      */     case 21:
/* 1092 */       strFieldValue = StrTool.GBKToUnicode(this.eMail);
/* 1093 */       break;
/*      */     case 22:
/* 1095 */       strFieldValue = StrTool.GBKToUnicode(this.bP);
/* 1096 */       break;
/*      */     case 23:
/* 1098 */       strFieldValue = StrTool.GBKToUnicode(this.mobile2);
/* 1099 */       break;
/*      */     case 24:
/* 1101 */       strFieldValue = StrTool.GBKToUnicode(this.mobileChs2);
/* 1102 */       break;
/*      */     case 25:
/* 1104 */       strFieldValue = StrTool.GBKToUnicode(this.eMail2);
/* 1105 */       break;
/*      */     case 26:
/* 1107 */       strFieldValue = StrTool.GBKToUnicode(this.bP2);
/* 1108 */       break;
/*      */     case 27:
/* 1110 */       strFieldValue = StrTool.GBKToUnicode(this.operator);
/* 1111 */       break;
/*      */     case 28:
/* 1113 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmakeDate()));
/* 1114 */       break;
/*      */     case 29:
/* 1116 */       strFieldValue = StrTool.GBKToUnicode(this.makeTime);
/* 1117 */       break;
/*      */     case 30:
/* 1119 */       strFieldValue = StrTool.GBKToUnicode(String.valueOf(getmodifyDate()));
/* 1120 */       break;
/*      */     case 31:
/* 1122 */       strFieldValue = StrTool.GBKToUnicode(this.modifyTime);
/* 1123 */       break;
/*      */     case 32:
/* 1125 */       strFieldValue = StrTool.GBKToUnicode(this.grpName);
/* 1126 */       break;
/*      */     case 33:
/* 1128 */       strFieldValue = StrTool.GBKToUnicode(this.otherDuchy);
/* 1129 */       break;
/*      */     default:
/* 1131 */       strFieldValue = "";
/*      */     }
/* 1133 */     if (strFieldValue.equals("")) {
/* 1134 */       strFieldValue = "null";
/*      */     }
/* 1136 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue)
/*      */   {
/* 1142 */     if (StrTool.cTrim(FCode).equals("")) {
/* 1143 */       return false;
/*      */     }
/* 1145 */     if (FCode.equals("EdorNo"))
/*      */     {
/* 1147 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1149 */         this.EdorNo = FValue.trim();
/*      */       }
/*      */       else
/* 1152 */         this.EdorNo = null;
/*      */     }
/* 1154 */     if (FCode.equals("serialNo"))
/*      */     {
/* 1156 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1158 */         this.serialNo = FValue.trim();
/*      */       }
/*      */       else
/* 1161 */         this.serialNo = null;
/*      */     }
/* 1163 */     if (FCode.equals("customerId"))
/*      */     {
/* 1165 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1167 */         this.customerId = FValue.trim();
/*      */       }
/*      */       else
/* 1170 */         this.customerId = null;
/*      */     }
/* 1172 */     if (FCode.equals("customerNo"))
/*      */     {
/* 1174 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1176 */         this.customerNo = FValue.trim();
/*      */       }
/*      */       else
/* 1179 */         this.customerNo = null;
/*      */     }
/* 1181 */     if (FCode.equals("addressNo"))
/*      */     {
/* 1183 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1185 */         this.addressNo = FValue.trim();
/*      */       }
/*      */       else
/* 1188 */         this.addressNo = null;
/*      */     }
/* 1190 */     if (FCode.equals("postalAddress"))
/*      */     {
/* 1192 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1194 */         this.postalAddress = FValue.trim();
/*      */       }
/*      */       else
/* 1197 */         this.postalAddress = null;
/*      */     }
/* 1199 */     if (FCode.equals("zipCode"))
/*      */     {
/* 1201 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1203 */         this.zipCode = FValue.trim();
/*      */       }
/*      */       else
/* 1206 */         this.zipCode = null;
/*      */     }
/* 1208 */     if (FCode.equals("phone"))
/*      */     {
/* 1210 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1212 */         this.phone = FValue.trim();
/*      */       }
/*      */       else
/* 1215 */         this.phone = null;
/*      */     }
/* 1217 */     if (FCode.equals("fax"))
/*      */     {
/* 1219 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1221 */         this.fax = FValue.trim();
/*      */       }
/*      */       else
/* 1224 */         this.fax = null;
/*      */     }
/* 1226 */     if (FCode.equals("duchy"))
/*      */     {
/* 1228 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1230 */         this.duchy = FValue.trim();
/*      */       }
/*      */       else
/* 1233 */         this.duchy = null;
/*      */     }
/* 1235 */     if (FCode.equals("homeAddress"))
/*      */     {
/* 1237 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1239 */         this.homeAddress = FValue.trim();
/*      */       }
/*      */       else
/* 1242 */         this.homeAddress = null;
/*      */     }
/* 1244 */     if (FCode.equals("homeZipCode"))
/*      */     {
/* 1246 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1248 */         this.homeZipCode = FValue.trim();
/*      */       }
/*      */       else
/* 1251 */         this.homeZipCode = null;
/*      */     }
/* 1253 */     if (FCode.equals("homePhone"))
/*      */     {
/* 1255 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1257 */         this.homePhone = FValue.trim();
/*      */       }
/*      */       else
/* 1260 */         this.homePhone = null;
/*      */     }
/* 1262 */     if (FCode.equals("homeFax"))
/*      */     {
/* 1264 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1266 */         this.homeFax = FValue.trim();
/*      */       }
/*      */       else
/* 1269 */         this.homeFax = null;
/*      */     }
/* 1271 */     if (FCode.equals("companyAddress"))
/*      */     {
/* 1273 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1275 */         this.companyAddress = FValue.trim();
/*      */       }
/*      */       else
/* 1278 */         this.companyAddress = null;
/*      */     }
/* 1280 */     if (FCode.equals("companyZipCode"))
/*      */     {
/* 1282 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1284 */         this.companyZipCode = FValue.trim();
/*      */       }
/*      */       else
/* 1287 */         this.companyZipCode = null;
/*      */     }
/* 1289 */     if (FCode.equals("companyPhone"))
/*      */     {
/* 1291 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1293 */         this.companyPhone = FValue.trim();
/*      */       }
/*      */       else
/* 1296 */         this.companyPhone = null;
/*      */     }
/* 1298 */     if (FCode.equals("companyFax"))
/*      */     {
/* 1300 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1302 */         this.companyFax = FValue.trim();
/*      */       }
/*      */       else
/* 1305 */         this.companyFax = null;
/*      */     }
/* 1307 */     if (FCode.equals("companyMail"))
/*      */     {
/* 1309 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1311 */         this.companyMail = FValue.trim();
/*      */       }
/*      */       else
/* 1314 */         this.companyMail = null;
/*      */     }
/* 1316 */     if (FCode.equals("mobile"))
/*      */     {
/* 1318 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1320 */         this.mobile = FValue.trim();
/*      */       }
/*      */       else
/* 1323 */         this.mobile = null;
/*      */     }
/* 1325 */     if (FCode.equals("mobileChs"))
/*      */     {
/* 1327 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1329 */         this.mobileChs = FValue.trim();
/*      */       }
/*      */       else
/* 1332 */         this.mobileChs = null;
/*      */     }
/* 1334 */     if (FCode.equals("eMail"))
/*      */     {
/* 1336 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1338 */         this.eMail = FValue.trim();
/*      */       }
/*      */       else
/* 1341 */         this.eMail = null;
/*      */     }
/* 1343 */     if (FCode.equals("bP"))
/*      */     {
/* 1345 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1347 */         this.bP = FValue.trim();
/*      */       }
/*      */       else
/* 1350 */         this.bP = null;
/*      */     }
/* 1352 */     if (FCode.equals("mobile2"))
/*      */     {
/* 1354 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1356 */         this.mobile2 = FValue.trim();
/*      */       }
/*      */       else
/* 1359 */         this.mobile2 = null;
/*      */     }
/* 1361 */     if (FCode.equals("mobileChs2"))
/*      */     {
/* 1363 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1365 */         this.mobileChs2 = FValue.trim();
/*      */       }
/*      */       else
/* 1368 */         this.mobileChs2 = null;
/*      */     }
/* 1370 */     if (FCode.equals("eMail2"))
/*      */     {
/* 1372 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1374 */         this.eMail2 = FValue.trim();
/*      */       }
/*      */       else
/* 1377 */         this.eMail2 = null;
/*      */     }
/* 1379 */     if (FCode.equals("bP2"))
/*      */     {
/* 1381 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1383 */         this.bP2 = FValue.trim();
/*      */       }
/*      */       else
/* 1386 */         this.bP2 = null;
/*      */     }
/* 1388 */     if (FCode.equals("operator"))
/*      */     {
/* 1390 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1392 */         this.operator = FValue.trim();
/*      */       }
/*      */       else
/* 1395 */         this.operator = null;
/*      */     }
/* 1397 */     if (FCode.equals("makeDate"))
/*      */     {
/* 1399 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1401 */         this.makeDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1404 */         this.makeDate = null;
/*      */     }
/* 1406 */     if (FCode.equals("makeTime"))
/*      */     {
/* 1408 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1410 */         this.makeTime = FValue.trim();
/*      */       }
/*      */       else
/* 1413 */         this.makeTime = null;
/*      */     }
/* 1415 */     if (FCode.equals("modifyDate"))
/*      */     {
/* 1417 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1419 */         this.modifyDate = this.fDate.getDate(FValue);
/*      */       }
/*      */       else
/* 1422 */         this.modifyDate = null;
/*      */     }
/* 1424 */     if (FCode.equals("modifyTime"))
/*      */     {
/* 1426 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1428 */         this.modifyTime = FValue.trim();
/*      */       }
/*      */       else
/* 1431 */         this.modifyTime = null;
/*      */     }
/* 1433 */     if (FCode.equals("grpName"))
/*      */     {
/* 1435 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1437 */         this.grpName = FValue.trim();
/*      */       }
/*      */       else
/* 1440 */         this.grpName = null;
/*      */     }
/* 1442 */     if (FCode.equals("otherDuchy"))
/*      */     {
/* 1444 */       if ((FValue != null) && (!FValue.equals("")))
/*      */       {
/* 1446 */         this.otherDuchy = FValue.trim();
/*      */       }
/*      */       else
/* 1449 */         this.otherDuchy = null;
/*      */     }
/* 1451 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/* 1456 */     if (this == otherObject) return true;
/* 1457 */     if (otherObject == null) return false;
/* 1458 */     if (getClass() != otherObject.getClass()) return false;
/* 1459 */     LNPAddressBSchema other = (LNPAddressBSchema)otherObject;
/* 1460 */     return 
/* 1461 */       (this.EdorNo.equals(other.getEdorNo())) && 
/* 1462 */       (this.serialNo.equals(other.getserialNo())) && 
/* 1463 */       (this.customerId.equals(other.getcustomerId())) && 
/* 1464 */       (this.customerNo.equals(other.getcustomerNo())) && 
/* 1465 */       (this.addressNo.equals(other.getaddressNo())) && 
/* 1466 */       (this.postalAddress.equals(other.getpostalAddress())) && 
/* 1467 */       (this.zipCode.equals(other.getzipCode())) && 
/* 1468 */       (this.phone.equals(other.getphone())) && 
/* 1469 */       (this.fax.equals(other.getfax())) && 
/* 1470 */       (this.duchy.equals(other.getduchy())) && 
/* 1471 */       (this.homeAddress.equals(other.gethomeAddress())) && 
/* 1472 */       (this.homeZipCode.equals(other.gethomeZipCode())) && 
/* 1473 */       (this.homePhone.equals(other.gethomePhone())) && 
/* 1474 */       (this.homeFax.equals(other.gethomeFax())) && 
/* 1475 */       (this.companyAddress.equals(other.getcompanyAddress())) && 
/* 1476 */       (this.companyZipCode.equals(other.getcompanyZipCode())) && 
/* 1477 */       (this.companyPhone.equals(other.getcompanyPhone())) && 
/* 1478 */       (this.companyFax.equals(other.getcompanyFax())) && 
/* 1479 */       (this.companyMail.equals(other.getcompanyMail())) && 
/* 1480 */       (this.mobile.equals(other.getmobile())) && 
/* 1481 */       (this.mobileChs.equals(other.getmobileChs())) && 
/* 1482 */       (this.eMail.equals(other.geteMail())) && 
/* 1483 */       (this.bP.equals(other.getbP())) && 
/* 1484 */       (this.mobile2.equals(other.getmobile2())) && 
/* 1485 */       (this.mobileChs2.equals(other.getmobileChs2())) && 
/* 1486 */       (this.eMail2.equals(other.geteMail2())) && 
/* 1487 */       (this.bP2.equals(other.getbP2())) && 
/* 1488 */       (this.operator.equals(other.getoperator())) && 
/* 1489 */       (this.fDate.getString(this.makeDate).equals(other.getmakeDate())) && 
/* 1490 */       (this.makeTime.equals(other.getmakeTime())) && 
/* 1491 */       (this.fDate.getString(this.modifyDate).equals(other.getmodifyDate())) && 
/* 1492 */       (this.modifyTime.equals(other.getmodifyTime())) && 
/* 1493 */       (this.grpName.equals(other.getgrpName())) && 
/* 1494 */       (this.otherDuchy.equals(other.getotherDuchy()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1500 */     return 34;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName)
/*      */   {
/* 1506 */     if (strFieldName.equals("EdorNo")) {
/* 1507 */       return 0;
/*      */     }
/* 1509 */     if (strFieldName.equals("serialNo")) {
/* 1510 */       return 1;
/*      */     }
/* 1512 */     if (strFieldName.equals("customerId")) {
/* 1513 */       return 2;
/*      */     }
/* 1515 */     if (strFieldName.equals("customerNo")) {
/* 1516 */       return 3;
/*      */     }
/* 1518 */     if (strFieldName.equals("addressNo")) {
/* 1519 */       return 4;
/*      */     }
/* 1521 */     if (strFieldName.equals("postalAddress")) {
/* 1522 */       return 5;
/*      */     }
/* 1524 */     if (strFieldName.equals("zipCode")) {
/* 1525 */       return 6;
/*      */     }
/* 1527 */     if (strFieldName.equals("phone")) {
/* 1528 */       return 7;
/*      */     }
/* 1530 */     if (strFieldName.equals("fax")) {
/* 1531 */       return 8;
/*      */     }
/* 1533 */     if (strFieldName.equals("duchy")) {
/* 1534 */       return 9;
/*      */     }
/* 1536 */     if (strFieldName.equals("homeAddress")) {
/* 1537 */       return 10;
/*      */     }
/* 1539 */     if (strFieldName.equals("homeZipCode")) {
/* 1540 */       return 11;
/*      */     }
/* 1542 */     if (strFieldName.equals("homePhone")) {
/* 1543 */       return 12;
/*      */     }
/* 1545 */     if (strFieldName.equals("homeFax")) {
/* 1546 */       return 13;
/*      */     }
/* 1548 */     if (strFieldName.equals("companyAddress")) {
/* 1549 */       return 14;
/*      */     }
/* 1551 */     if (strFieldName.equals("companyZipCode")) {
/* 1552 */       return 15;
/*      */     }
/* 1554 */     if (strFieldName.equals("companyPhone")) {
/* 1555 */       return 16;
/*      */     }
/* 1557 */     if (strFieldName.equals("companyFax")) {
/* 1558 */       return 17;
/*      */     }
/* 1560 */     if (strFieldName.equals("companyMail")) {
/* 1561 */       return 18;
/*      */     }
/* 1563 */     if (strFieldName.equals("mobile")) {
/* 1564 */       return 19;
/*      */     }
/* 1566 */     if (strFieldName.equals("mobileChs")) {
/* 1567 */       return 20;
/*      */     }
/* 1569 */     if (strFieldName.equals("eMail")) {
/* 1570 */       return 21;
/*      */     }
/* 1572 */     if (strFieldName.equals("bP")) {
/* 1573 */       return 22;
/*      */     }
/* 1575 */     if (strFieldName.equals("mobile2")) {
/* 1576 */       return 23;
/*      */     }
/* 1578 */     if (strFieldName.equals("mobileChs2")) {
/* 1579 */       return 24;
/*      */     }
/* 1581 */     if (strFieldName.equals("eMail2")) {
/* 1582 */       return 25;
/*      */     }
/* 1584 */     if (strFieldName.equals("bP2")) {
/* 1585 */       return 26;
/*      */     }
/* 1587 */     if (strFieldName.equals("operator")) {
/* 1588 */       return 27;
/*      */     }
/* 1590 */     if (strFieldName.equals("makeDate")) {
/* 1591 */       return 28;
/*      */     }
/* 1593 */     if (strFieldName.equals("makeTime")) {
/* 1594 */       return 29;
/*      */     }
/* 1596 */     if (strFieldName.equals("modifyDate")) {
/* 1597 */       return 30;
/*      */     }
/* 1599 */     if (strFieldName.equals("modifyTime")) {
/* 1600 */       return 31;
/*      */     }
/* 1602 */     if (strFieldName.equals("grpName")) {
/* 1603 */       return 32;
/*      */     }
/* 1605 */     if (strFieldName.equals("otherDuchy")) {
/* 1606 */       return 33;
/*      */     }
/* 1608 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex)
/*      */   {
/* 1614 */     String strFieldName = "";
/* 1615 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1617 */       strFieldName = "EdorNo";
/* 1618 */       break;
/*      */     case 1:
/* 1620 */       strFieldName = "serialNo";
/* 1621 */       break;
/*      */     case 2:
/* 1623 */       strFieldName = "customerId";
/* 1624 */       break;
/*      */     case 3:
/* 1626 */       strFieldName = "customerNo";
/* 1627 */       break;
/*      */     case 4:
/* 1629 */       strFieldName = "addressNo";
/* 1630 */       break;
/*      */     case 5:
/* 1632 */       strFieldName = "postalAddress";
/* 1633 */       break;
/*      */     case 6:
/* 1635 */       strFieldName = "zipCode";
/* 1636 */       break;
/*      */     case 7:
/* 1638 */       strFieldName = "phone";
/* 1639 */       break;
/*      */     case 8:
/* 1641 */       strFieldName = "fax";
/* 1642 */       break;
/*      */     case 9:
/* 1644 */       strFieldName = "duchy";
/* 1645 */       break;
/*      */     case 10:
/* 1647 */       strFieldName = "homeAddress";
/* 1648 */       break;
/*      */     case 11:
/* 1650 */       strFieldName = "homeZipCode";
/* 1651 */       break;
/*      */     case 12:
/* 1653 */       strFieldName = "homePhone";
/* 1654 */       break;
/*      */     case 13:
/* 1656 */       strFieldName = "homeFax";
/* 1657 */       break;
/*      */     case 14:
/* 1659 */       strFieldName = "companyAddress";
/* 1660 */       break;
/*      */     case 15:
/* 1662 */       strFieldName = "companyZipCode";
/* 1663 */       break;
/*      */     case 16:
/* 1665 */       strFieldName = "companyPhone";
/* 1666 */       break;
/*      */     case 17:
/* 1668 */       strFieldName = "companyFax";
/* 1669 */       break;
/*      */     case 18:
/* 1671 */       strFieldName = "companyMail";
/* 1672 */       break;
/*      */     case 19:
/* 1674 */       strFieldName = "mobile";
/* 1675 */       break;
/*      */     case 20:
/* 1677 */       strFieldName = "mobileChs";
/* 1678 */       break;
/*      */     case 21:
/* 1680 */       strFieldName = "eMail";
/* 1681 */       break;
/*      */     case 22:
/* 1683 */       strFieldName = "bP";
/* 1684 */       break;
/*      */     case 23:
/* 1686 */       strFieldName = "mobile2";
/* 1687 */       break;
/*      */     case 24:
/* 1689 */       strFieldName = "mobileChs2";
/* 1690 */       break;
/*      */     case 25:
/* 1692 */       strFieldName = "eMail2";
/* 1693 */       break;
/*      */     case 26:
/* 1695 */       strFieldName = "bP2";
/* 1696 */       break;
/*      */     case 27:
/* 1698 */       strFieldName = "operator";
/* 1699 */       break;
/*      */     case 28:
/* 1701 */       strFieldName = "makeDate";
/* 1702 */       break;
/*      */     case 29:
/* 1704 */       strFieldName = "makeTime";
/* 1705 */       break;
/*      */     case 30:
/* 1707 */       strFieldName = "modifyDate";
/* 1708 */       break;
/*      */     case 31:
/* 1710 */       strFieldName = "modifyTime";
/* 1711 */       break;
/*      */     case 32:
/* 1713 */       strFieldName = "grpName";
/* 1714 */       break;
/*      */     case 33:
/* 1716 */       strFieldName = "otherDuchy";
/* 1717 */       break;
/*      */     default:
/* 1719 */       strFieldName = "";
/*      */     }
/* 1721 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName)
/*      */   {
/* 1727 */     if (strFieldName.equals("EdorNo")) {
/* 1728 */       return 0;
/*      */     }
/* 1730 */     if (strFieldName.equals("serialNo")) {
/* 1731 */       return 0;
/*      */     }
/* 1733 */     if (strFieldName.equals("customerId")) {
/* 1734 */       return 0;
/*      */     }
/* 1736 */     if (strFieldName.equals("customerNo")) {
/* 1737 */       return 0;
/*      */     }
/* 1739 */     if (strFieldName.equals("addressNo")) {
/* 1740 */       return 0;
/*      */     }
/* 1742 */     if (strFieldName.equals("postalAddress")) {
/* 1743 */       return 0;
/*      */     }
/* 1745 */     if (strFieldName.equals("zipCode")) {
/* 1746 */       return 0;
/*      */     }
/* 1748 */     if (strFieldName.equals("phone")) {
/* 1749 */       return 0;
/*      */     }
/* 1751 */     if (strFieldName.equals("fax")) {
/* 1752 */       return 0;
/*      */     }
/* 1754 */     if (strFieldName.equals("duchy")) {
/* 1755 */       return 0;
/*      */     }
/* 1757 */     if (strFieldName.equals("homeAddress")) {
/* 1758 */       return 0;
/*      */     }
/* 1760 */     if (strFieldName.equals("homeZipCode")) {
/* 1761 */       return 0;
/*      */     }
/* 1763 */     if (strFieldName.equals("homePhone")) {
/* 1764 */       return 0;
/*      */     }
/* 1766 */     if (strFieldName.equals("homeFax")) {
/* 1767 */       return 0;
/*      */     }
/* 1769 */     if (strFieldName.equals("companyAddress")) {
/* 1770 */       return 0;
/*      */     }
/* 1772 */     if (strFieldName.equals("companyZipCode")) {
/* 1773 */       return 0;
/*      */     }
/* 1775 */     if (strFieldName.equals("companyPhone")) {
/* 1776 */       return 0;
/*      */     }
/* 1778 */     if (strFieldName.equals("companyFax")) {
/* 1779 */       return 0;
/*      */     }
/* 1781 */     if (strFieldName.equals("companyMail")) {
/* 1782 */       return 0;
/*      */     }
/* 1784 */     if (strFieldName.equals("mobile")) {
/* 1785 */       return 0;
/*      */     }
/* 1787 */     if (strFieldName.equals("mobileChs")) {
/* 1788 */       return 0;
/*      */     }
/* 1790 */     if (strFieldName.equals("eMail")) {
/* 1791 */       return 0;
/*      */     }
/* 1793 */     if (strFieldName.equals("bP")) {
/* 1794 */       return 0;
/*      */     }
/* 1796 */     if (strFieldName.equals("mobile2")) {
/* 1797 */       return 0;
/*      */     }
/* 1799 */     if (strFieldName.equals("mobileChs2")) {
/* 1800 */       return 0;
/*      */     }
/* 1802 */     if (strFieldName.equals("eMail2")) {
/* 1803 */       return 0;
/*      */     }
/* 1805 */     if (strFieldName.equals("bP2")) {
/* 1806 */       return 0;
/*      */     }
/* 1808 */     if (strFieldName.equals("operator")) {
/* 1809 */       return 0;
/*      */     }
/* 1811 */     if (strFieldName.equals("makeDate")) {
/* 1812 */       return 1;
/*      */     }
/* 1814 */     if (strFieldName.equals("makeTime")) {
/* 1815 */       return 0;
/*      */     }
/* 1817 */     if (strFieldName.equals("modifyDate")) {
/* 1818 */       return 1;
/*      */     }
/* 1820 */     if (strFieldName.equals("modifyTime")) {
/* 1821 */       return 0;
/*      */     }
/* 1823 */     if (strFieldName.equals("grpName")) {
/* 1824 */       return 0;
/*      */     }
/* 1826 */     if (strFieldName.equals("otherDuchy")) {
/* 1827 */       return 0;
/*      */     }
/* 1829 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex)
/*      */   {
/* 1835 */     int nFieldType = -1;
/* 1836 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1838 */       nFieldType = 0;
/* 1839 */       break;
/*      */     case 1:
/* 1841 */       nFieldType = 0;
/* 1842 */       break;
/*      */     case 2:
/* 1844 */       nFieldType = 0;
/* 1845 */       break;
/*      */     case 3:
/* 1847 */       nFieldType = 0;
/* 1848 */       break;
/*      */     case 4:
/* 1850 */       nFieldType = 0;
/* 1851 */       break;
/*      */     case 5:
/* 1853 */       nFieldType = 0;
/* 1854 */       break;
/*      */     case 6:
/* 1856 */       nFieldType = 0;
/* 1857 */       break;
/*      */     case 7:
/* 1859 */       nFieldType = 0;
/* 1860 */       break;
/*      */     case 8:
/* 1862 */       nFieldType = 0;
/* 1863 */       break;
/*      */     case 9:
/* 1865 */       nFieldType = 0;
/* 1866 */       break;
/*      */     case 10:
/* 1868 */       nFieldType = 0;
/* 1869 */       break;
/*      */     case 11:
/* 1871 */       nFieldType = 0;
/* 1872 */       break;
/*      */     case 12:
/* 1874 */       nFieldType = 0;
/* 1875 */       break;
/*      */     case 13:
/* 1877 */       nFieldType = 0;
/* 1878 */       break;
/*      */     case 14:
/* 1880 */       nFieldType = 0;
/* 1881 */       break;
/*      */     case 15:
/* 1883 */       nFieldType = 0;
/* 1884 */       break;
/*      */     case 16:
/* 1886 */       nFieldType = 0;
/* 1887 */       break;
/*      */     case 17:
/* 1889 */       nFieldType = 0;
/* 1890 */       break;
/*      */     case 18:
/* 1892 */       nFieldType = 0;
/* 1893 */       break;
/*      */     case 19:
/* 1895 */       nFieldType = 0;
/* 1896 */       break;
/*      */     case 20:
/* 1898 */       nFieldType = 0;
/* 1899 */       break;
/*      */     case 21:
/* 1901 */       nFieldType = 0;
/* 1902 */       break;
/*      */     case 22:
/* 1904 */       nFieldType = 0;
/* 1905 */       break;
/*      */     case 23:
/* 1907 */       nFieldType = 0;
/* 1908 */       break;
/*      */     case 24:
/* 1910 */       nFieldType = 0;
/* 1911 */       break;
/*      */     case 25:
/* 1913 */       nFieldType = 0;
/* 1914 */       break;
/*      */     case 26:
/* 1916 */       nFieldType = 0;
/* 1917 */       break;
/*      */     case 27:
/* 1919 */       nFieldType = 0;
/* 1920 */       break;
/*      */     case 28:
/* 1922 */       nFieldType = 1;
/* 1923 */       break;
/*      */     case 29:
/* 1925 */       nFieldType = 0;
/* 1926 */       break;
/*      */     case 30:
/* 1928 */       nFieldType = 1;
/* 1929 */       break;
/*      */     case 31:
/* 1931 */       nFieldType = 0;
/* 1932 */       break;
/*      */     case 32:
/* 1934 */       nFieldType = 0;
/* 1935 */       break;
/*      */     case 33:
/* 1937 */       nFieldType = 0;
/* 1938 */       break;
/*      */     default:
/* 1940 */       nFieldType = -1;
/*      */     }
/* 1942 */     return nFieldType;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.LNPAddressBSchema
 * JD-Core Version:    0.6.0
 */