/*      */ package com.sinosoft.banklns.lis.schema;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.CRSInfoDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.FDate;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.Schema;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.io.PrintStream;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ 
/*      */ public class CRSInfoSchema
/*      */   implements Schema
/*      */ {
/*      */   private String contNo;
/*      */   private String customerName;
/*      */   private String taxResidentType;
/*      */   private String firstName;
/*      */   private String lastName;
/*      */   private String birthday;
/*      */   private String currentAddress_Country;
/*      */   private String currentAddress_Province;
/*      */   private String currentAddress_City;
/*      */   private String currentAddress_Detail;
/*      */   private String currentAddress_Country_en;
/*      */   private String currentAddress_Province_en;
/*      */   private String currentAddress_City_en;
/*      */   private String currentAddress_Detail_en;
/*      */   private String birthAddress_Country;
/*      */   private String birthAddress_Province;
/*      */   private String birthAddress_City;
/*      */   private String birthAddress_Detail;
/*      */   private String birthAddress_Country_en;
/*      */   private String birthAddress_Province_en;
/*      */   private String birthAddress_City_en;
/*      */   private String birthAddress_Detail_en;
/*      */   private String taxResidentCountry1;
/*      */   private String taxpayerCode1;
/*      */   private String taxResidentCountry2;
/*      */   private String taxpayerCode2;
/*      */   private String taxResidentCountry3;
/*      */   private String taxpayerCode3;
/*      */   private String noTaxpayercodeReason;
/*      */   private String reasonDescription;
/*      */   private String sourceType;
/*      */   public static final int FIELDNUM = 31;
/*      */   private static String[] PK;
/*  332 */   private FDate fDate = new FDate();
/*      */   public CErrors mErrors;
/*      */ 
/*      */   public String getCustomerName()
/*      */   {
/*   49 */     return this.customerName;
/*      */   }
/*      */ 
/*      */   public void setCustomerName(String customerName) {
/*   53 */     this.customerName = customerName;
/*      */   }
/*      */ 
/*      */   public String getTaxResidentType() {
/*   57 */     return this.taxResidentType;
/*      */   }
/*      */ 
/*      */   public void setTaxResidentType(String taxResidentType) {
/*   61 */     this.taxResidentType = taxResidentType;
/*      */   }
/*      */ 
/*      */   public String getFirstName() {
/*   65 */     return this.firstName;
/*      */   }
/*      */ 
/*      */   public void setFirstName(String firstName) {
/*   69 */     this.firstName = firstName;
/*      */   }
/*      */ 
/*      */   public String getLastName() {
/*   73 */     return this.lastName;
/*      */   }
/*      */ 
/*      */   public void setLastName(String lastName) {
/*   77 */     this.lastName = lastName;
/*      */   }
/*      */ 
/*      */   public String getBirthday() {
/*   81 */     return this.birthday;
/*      */   }
/*      */ 
/*      */   public void setBirthday(String birthday) {
/*   85 */     this.birthday = birthday;
/*      */   }
/*      */ 
/*      */   public String getCurrentAddress_Country() {
/*   89 */     return this.currentAddress_Country;
/*      */   }
/*      */ 
/*      */   public void setCurrentAddress_Country(String currentAddress_Country) {
/*   93 */     this.currentAddress_Country = currentAddress_Country;
/*      */   }
/*      */ 
/*      */   public String getCurrentAddress_Province() {
/*   97 */     return this.currentAddress_Province;
/*      */   }
/*      */ 
/*      */   public void setCurrentAddress_Province(String currentAddress_Province) {
/*  101 */     this.currentAddress_Province = currentAddress_Province;
/*      */   }
/*      */ 
/*      */   public String getCurrentAddress_City() {
/*  105 */     return this.currentAddress_City;
/*      */   }
/*      */ 
/*      */   public void setCurrentAddress_City(String currentAddress_City) {
/*  109 */     this.currentAddress_City = currentAddress_City;
/*      */   }
/*      */ 
/*      */   public String getCurrentAddress_Detail() {
/*  113 */     return this.currentAddress_Detail;
/*      */   }
/*      */ 
/*      */   public void setCurrentAddress_Detail(String currentAddress_Detail) {
/*  117 */     this.currentAddress_Detail = currentAddress_Detail;
/*      */   }
/*      */ 
/*      */   public String getCurrentAddress_Province_en() {
/*  121 */     return this.currentAddress_Province_en;
/*      */   }
/*      */ 
/*      */   public void setCurrentAddress_Province_en(String currentAddress_Province_en) {
/*  125 */     this.currentAddress_Province_en = currentAddress_Province_en;
/*      */   }
/*      */ 
/*      */   public String getCurrentAddress_City_en() {
/*  129 */     return this.currentAddress_City_en;
/*      */   }
/*      */ 
/*      */   public void setCurrentAddress_City_en(String currentAddress_City_en) {
/*  133 */     this.currentAddress_City_en = currentAddress_City_en;
/*      */   }
/*      */ 
/*      */   public String getCurrentAddress_Detail_en() {
/*  137 */     return this.currentAddress_Detail_en;
/*      */   }
/*      */ 
/*      */   public void setCurrentAddress_Detail_en(String currentAddress_Detail_en) {
/*  141 */     this.currentAddress_Detail_en = currentAddress_Detail_en;
/*      */   }
/*      */ 
/*      */   public String getBirthAddress_Country() {
/*  145 */     return this.birthAddress_Country;
/*      */   }
/*      */ 
/*      */   public void setBirthAddress_Country(String birthAddress_Country) {
/*  149 */     this.birthAddress_Country = birthAddress_Country;
/*      */   }
/*      */ 
/*      */   public String getBirthAddress_Province() {
/*  153 */     return this.birthAddress_Province;
/*      */   }
/*      */ 
/*      */   public void setBirthAddress_Province(String birthAddress_Province) {
/*  157 */     this.birthAddress_Province = birthAddress_Province;
/*      */   }
/*      */ 
/*      */   public String getBirthAddress_City() {
/*  161 */     return this.birthAddress_City;
/*      */   }
/*      */ 
/*      */   public void setBirthAddress_City(String birthAddress_City) {
/*  165 */     this.birthAddress_City = birthAddress_City;
/*      */   }
/*      */ 
/*      */   public String getBirthAddress_Detail() {
/*  169 */     return this.birthAddress_Detail;
/*      */   }
/*      */ 
/*      */   public void setBirthAddress_Detail(String birthAddress_Detail) {
/*  173 */     this.birthAddress_Detail = birthAddress_Detail;
/*      */   }
/*      */ 
/*      */   public String getBirthAddress_Province_en() {
/*  177 */     return this.birthAddress_Province_en;
/*      */   }
/*      */ 
/*      */   public void setBirthAddress_Province_en(String birthAddress_Province_en) {
/*  181 */     this.birthAddress_Province_en = birthAddress_Province_en;
/*      */   }
/*      */ 
/*      */   public String getBirthAddress_City_en() {
/*  185 */     return this.birthAddress_City_en;
/*      */   }
/*      */ 
/*      */   public void setBirthAddress_City_en(String birthAddress_City_en) {
/*  189 */     this.birthAddress_City_en = birthAddress_City_en;
/*      */   }
/*      */ 
/*      */   public String getBirthAddress_Detail_en() {
/*  193 */     return this.birthAddress_Detail_en;
/*      */   }
/*      */ 
/*      */   public void setBirthAddress_Detail_en(String birthAddress_Detail_en) {
/*  197 */     this.birthAddress_Detail_en = birthAddress_Detail_en;
/*      */   }
/*      */ 
/*      */   public String getTaxResidentCountry1() {
/*  201 */     return this.taxResidentCountry1;
/*      */   }
/*      */ 
/*      */   public void setTaxResidentCountry1(String taxResidentCountry1) {
/*  205 */     this.taxResidentCountry1 = taxResidentCountry1;
/*      */   }
/*      */ 
/*      */   public String getTaxpayerCode1() {
/*  209 */     return this.taxpayerCode1;
/*      */   }
/*      */ 
/*      */   public void setTaxpayerCode1(String taxpayerCode1) {
/*  213 */     this.taxpayerCode1 = taxpayerCode1;
/*      */   }
/*      */ 
/*      */   public String getTaxResidentCountry2() {
/*  217 */     return this.taxResidentCountry2;
/*      */   }
/*      */ 
/*      */   public void setTaxResidentCountry2(String taxResidentCountry2) {
/*  221 */     this.taxResidentCountry2 = taxResidentCountry2;
/*      */   }
/*      */ 
/*      */   public String getTaxpayerCode2() {
/*  225 */     return this.taxpayerCode2;
/*      */   }
/*      */ 
/*      */   public void setTaxpayerCode2(String taxpayerCode2) {
/*  229 */     this.taxpayerCode2 = taxpayerCode2;
/*      */   }
/*      */ 
/*      */   public String getTaxResidentCountry3() {
/*  233 */     return this.taxResidentCountry3;
/*      */   }
/*      */ 
/*      */   public void setTaxResidentCountry3(String taxResidentCountry3) {
/*  237 */     this.taxResidentCountry3 = taxResidentCountry3;
/*      */   }
/*      */ 
/*      */   public String getTaxpayerCode3() {
/*  241 */     return this.taxpayerCode3;
/*      */   }
/*      */ 
/*      */   public void setTaxpayerCode3(String taxpayerCode3) {
/*  245 */     this.taxpayerCode3 = taxpayerCode3;
/*      */   }
/*      */ 
/*      */   public String getNoTaxpayercodeReason() {
/*  249 */     return this.noTaxpayercodeReason;
/*      */   }
/*      */ 
/*      */   public void setNoTaxpayercodeReason(String noTaxpayercodeReason) {
/*  253 */     this.noTaxpayercodeReason = noTaxpayercodeReason;
/*      */   }
/*      */ 
/*      */   public String getReasonDescription() {
/*  257 */     return this.reasonDescription;
/*      */   }
/*      */ 
/*      */   public void setReasonDescription(String reasonDescription) {
/*  261 */     this.reasonDescription = reasonDescription;
/*      */   }
/*      */ 
/*      */   public String getSourceType() {
/*  265 */     return this.sourceType;
/*      */   }
/*      */ 
/*      */   public void setSourceType(String sourceType) {
/*  269 */     this.sourceType = sourceType;
/*      */   }
/*      */ 
/*      */   public void setSchema(CRSInfoSchema aCRSInfoSchema) {
/*  273 */     this.birthAddress_City = aCRSInfoSchema.getBirthAddress_City();
/*  274 */     this.birthAddress_City_en = aCRSInfoSchema.getBirthAddress_City_en();
/*  275 */     this.birthAddress_Country = aCRSInfoSchema.getBirthAddress_Country();
/*  276 */     this.birthAddress_Detail = aCRSInfoSchema.getBirthAddress_Detail();
/*  277 */     this.birthAddress_Detail_en = aCRSInfoSchema.getBirthAddress_Detail_en();
/*  278 */     this.birthAddress_Province = aCRSInfoSchema.getBirthAddress_Province();
/*  279 */     this.birthAddress_Province_en = aCRSInfoSchema.getBirthAddress_Province_en();
/*  280 */     this.birthday = aCRSInfoSchema.getBirthday();
/*  281 */     this.currentAddress_City = aCRSInfoSchema.getCurrentAddress_City();
/*  282 */     this.currentAddress_City_en = aCRSInfoSchema.getCurrentAddress_City_en();
/*  283 */     this.currentAddress_Country = aCRSInfoSchema.getCurrentAddress_Country();
/*  284 */     this.currentAddress_Detail = aCRSInfoSchema.getCurrentAddress_Detail();
/*  285 */     this.currentAddress_Detail_en = aCRSInfoSchema.getCurrentAddress_Detail_en();
/*  286 */     this.currentAddress_Province = aCRSInfoSchema.getCurrentAddress_Province();
/*  287 */     this.currentAddress_Province_en = aCRSInfoSchema.getCurrentAddress_Province_en();
/*  288 */     this.customerName = aCRSInfoSchema.getCustomerName();
/*  289 */     this.firstName = aCRSInfoSchema.getFirstName();
/*  290 */     this.lastName = aCRSInfoSchema.getLastName();
/*  291 */     this.noTaxpayercodeReason = aCRSInfoSchema.getNoTaxpayercodeReason();
/*  292 */     this.sourceType = aCRSInfoSchema.getSourceType();
/*  293 */     this.taxpayerCode1 = aCRSInfoSchema.getTaxpayerCode1();
/*  294 */     this.taxpayerCode2 = aCRSInfoSchema.getTaxpayerCode2();
/*  295 */     this.taxpayerCode3 = aCRSInfoSchema.getTaxpayerCode3();
/*  296 */     this.taxResidentCountry1 = aCRSInfoSchema.getTaxResidentCountry1();
/*  297 */     this.taxResidentCountry2 = aCRSInfoSchema.getTaxResidentCountry2();
/*  298 */     this.taxResidentCountry3 = aCRSInfoSchema.getTaxResidentCountry3();
/*  299 */     this.taxResidentType = aCRSInfoSchema.getTaxResidentType();
/*  300 */     this.contNo = aCRSInfoSchema.getContNo();
/*  301 */     this.currentAddress_Country_en = aCRSInfoSchema.getCurrentAddress_Country_en();
/*  302 */     this.birthAddress_Country_en = aCRSInfoSchema.getBirthAddress_Country_en();
/*  303 */     this.reasonDescription = aCRSInfoSchema.getReasonDescription();
/*      */   }
/*      */ 
/*      */   public String getContNo() {
/*  307 */     return this.contNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String contNo) {
/*  311 */     this.contNo = contNo;
/*      */   }
/*      */ 
/*      */   public String getBirthAddress_Country_en() {
/*  315 */     return this.birthAddress_Country_en;
/*      */   }
/*      */ 
/*      */   public void setBirthAddress_Country_en(String birthAddress_Country_en) {
/*  319 */     this.birthAddress_Country_en = birthAddress_Country_en;
/*      */   }
/*      */ 
/*      */   public String getCurrentAddress_Country_en() {
/*  323 */     return this.currentAddress_Country_en;
/*      */   }
/*      */ 
/*      */   public void setCurrentAddress_Country_en(String currentAddress_Country_en) {
/*  327 */     this.currentAddress_Country_en = currentAddress_Country_en;
/*      */   }
/*      */ 
/*      */   public CRSInfoSchema()
/*      */   {
/*  337 */     this.mErrors = new CErrors();
/*      */ 
/*  339 */     String[] pk = new String[1];
/*  340 */     pk[0] = "contNo";
/*      */ 
/*  342 */     PK = pk;
/*      */   }
/*      */ 
/*      */   public Object clone() throws CloneNotSupportedException {
/*  346 */     CRSInfoSchema cloned = (CRSInfoSchema)super.clone();
/*  347 */     cloned.fDate = ((FDate)this.fDate.clone());
/*  348 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  349 */     return cloned;
/*      */   }
/*      */ 
/*      */   public String[] getPK() {
/*  353 */     return PK;
/*      */   }
/*      */ 
/*      */   public boolean setSchema(ResultSet rs, int i) {
/*      */     try {
/*  358 */       if (rs.getString("ContNo") == null)
/*  359 */         this.contNo = null;
/*      */       else
/*  361 */         this.contNo = rs.getString("ContNo").trim();
/*  362 */       if (rs.getString("CustomerName") == null)
/*  363 */         this.customerName = null;
/*      */       else
/*  365 */         this.customerName = rs.getString("CustomerName").trim();
/*  366 */       if (rs.getString("taxResidentType") == null)
/*  367 */         this.taxResidentType = null;
/*      */       else
/*  369 */         this.taxResidentType = rs.getString("taxResidentType").trim();
/*  370 */       if (rs.getString("firstName") == null)
/*  371 */         this.firstName = null;
/*      */       else
/*  373 */         this.firstName = rs.getString("firstName").trim();
/*  374 */       if (rs.getString("lastName") == null)
/*  375 */         this.lastName = null;
/*      */       else
/*  377 */         this.lastName = rs.getString("lastName").trim();
/*  378 */       if (rs.getString("birthday") == null)
/*  379 */         this.birthday = null;
/*      */       else
/*  381 */         this.birthday = rs.getString("birthday").trim();
/*  382 */       if (rs.getString("currentAddress_Country") == null)
/*  383 */         this.currentAddress_Country = null;
/*      */       else
/*  385 */         this.currentAddress_Country = rs.getString("currentAddress_Country").trim();
/*  386 */       if (rs.getString("currentAddress_Province") == null)
/*  387 */         this.currentAddress_Province = null;
/*      */       else
/*  389 */         this.currentAddress_Province = rs.getString("currentAddress_Province").trim();
/*  390 */       if (rs.getString("currentAddress_City") == null)
/*  391 */         this.currentAddress_City = null;
/*      */       else
/*  393 */         this.currentAddress_City = rs.getString("currentAddress_City").trim();
/*  394 */       if (rs.getString("currentAddress_Detail") == null)
/*  395 */         this.currentAddress_Detail = null;
/*      */       else
/*  397 */         this.currentAddress_Detail = rs.getString("currentAddress_Detail").trim();
/*  398 */       if (rs.getString("currentAddress_Country_en") == null)
/*  399 */         this.currentAddress_Country_en = null;
/*      */       else
/*  401 */         this.currentAddress_Country_en = rs.getString("currentAddress_Country_en").trim();
/*  402 */       if (rs.getString("currentAddress_Province_en") == null)
/*  403 */         this.currentAddress_Province_en = null;
/*      */       else
/*  405 */         this.currentAddress_Province_en = rs.getString("currentAddress_Province_en").trim();
/*  406 */       if (rs.getString("currentAddress_City_en") == null)
/*  407 */         this.currentAddress_City_en = null;
/*      */       else
/*  409 */         this.currentAddress_City_en = rs.getString("currentAddress_City_en").trim();
/*  410 */       if (rs.getString("currentAddress_Detail_en") == null)
/*  411 */         this.currentAddress_Detail_en = null;
/*      */       else
/*  413 */         this.currentAddress_Detail_en = rs.getString("currentAddress_Detail_en").trim();
/*  414 */       if (rs.getString("birthAddress_Country") == null)
/*  415 */         this.birthAddress_Country = null;
/*      */       else
/*  417 */         this.birthAddress_Country = rs.getString("birthAddress_Country").trim();
/*  418 */       if (rs.getString("birthAddress_Province") == null)
/*  419 */         this.birthAddress_Province = null;
/*      */       else
/*  421 */         this.birthAddress_Province = rs.getString("birthAddress_Province").trim();
/*  422 */       if (rs.getString("birthAddress_City") == null)
/*  423 */         this.birthAddress_City = null;
/*      */       else
/*  425 */         this.birthAddress_City = rs.getString("birthAddress_City").trim();
/*  426 */       if (rs.getString("birthAddress_Detail") == null)
/*  427 */         this.birthAddress_Detail = null;
/*      */       else
/*  429 */         this.birthAddress_Detail = rs.getString("birthAddress_Detail").trim();
/*  430 */       if (rs.getString("birthAddress_Country_en") == null)
/*  431 */         this.birthAddress_Country_en = null;
/*      */       else
/*  433 */         this.birthAddress_Country_en = rs.getString("birthAddress_Country_en").trim();
/*  434 */       if (rs.getString("birthAddress_Province_en") == null)
/*  435 */         this.birthAddress_Province_en = null;
/*      */       else
/*  437 */         this.birthAddress_Province_en = rs.getString("birthAddress_Province_en").trim();
/*  438 */       if (rs.getString("birthAddress_City_en") == null)
/*  439 */         this.birthAddress_City_en = null;
/*      */       else
/*  441 */         this.birthAddress_City_en = rs.getString("birthAddress_City_en").trim();
/*  442 */       if (rs.getString("birthAddress_Detail_en") == null)
/*  443 */         this.birthAddress_Detail_en = null;
/*      */       else
/*  445 */         this.birthAddress_Detail_en = rs.getString("birthAddress_Detail_en").trim();
/*  446 */       if (rs.getString("taxResidentCountry1") == null)
/*  447 */         this.taxResidentCountry1 = null;
/*      */       else
/*  449 */         this.taxResidentCountry1 = rs.getString("taxResidentCountry1").trim();
/*  450 */       if (rs.getString("taxpayerCode1") == null)
/*  451 */         this.taxpayerCode1 = null;
/*      */       else
/*  453 */         this.taxpayerCode1 = rs.getString("taxpayerCode1").trim();
/*  454 */       if (rs.getString("taxResidentCountry2") == null)
/*  455 */         this.taxResidentCountry2 = null;
/*      */       else
/*  457 */         this.taxResidentCountry2 = rs.getString("taxResidentCountry2").trim();
/*  458 */       if (rs.getString("taxpayerCode2") == null)
/*  459 */         this.taxpayerCode2 = null;
/*      */       else
/*  461 */         this.taxpayerCode2 = rs.getString("taxpayerCode2").trim();
/*  462 */       if (rs.getString("taxResidentCountry3") == null)
/*  463 */         this.taxResidentCountry3 = null;
/*      */       else
/*  465 */         this.taxResidentCountry3 = rs.getString("taxResidentCountry3").trim();
/*  466 */       if (rs.getString("taxpayerCode3") == null)
/*  467 */         this.taxpayerCode3 = null;
/*      */       else
/*  469 */         this.taxpayerCode3 = rs.getString("taxpayerCode3").trim();
/*  470 */       if (rs.getString("noTaxpayercodeReason") == null)
/*  471 */         this.noTaxpayercodeReason = null;
/*      */       else
/*  473 */         this.noTaxpayercodeReason = rs.getString("noTaxpayercodeReason").trim();
/*  474 */       if (rs.getString("reasonDescription") == null)
/*  475 */         this.reasonDescription = null;
/*      */       else
/*  477 */         this.reasonDescription = rs.getString("reasonDescription").trim();
/*  478 */       if (rs.getString("sourceType") == null)
/*  479 */         this.sourceType = null;
/*      */       else
/*  481 */         this.sourceType = rs.getString("sourceType").trim();
/*      */     } catch (SQLException sqle) {
/*  483 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684CRSInfo\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*      */ 
/*  485 */       CError tError = new CError();
/*  486 */       tError.moduleName = "CRSInfoSchema";
/*  487 */       tError.functionName = "setSchema";
/*  488 */       tError.errorMessage = sqle.toString();
/*  489 */       this.mErrors.addOneError(tError);
/*  490 */       return false;
/*      */     }
/*  492 */     return true;
/*      */   }
/*      */ 
/*      */   public CRSInfoSchema getSchema() {
/*  496 */     CRSInfoSchema aCRSInfoSchema = new CRSInfoSchema();
/*  497 */     aCRSInfoSchema.setSchema(this);
/*  498 */     return aCRSInfoSchema;
/*      */   }
/*      */ 
/*      */   public CRSInfoDB getDB() {
/*  502 */     CRSInfoDB cDBOper = new CRSInfoDB();
/*  503 */     cDBOper.setSchema(this);
/*  504 */     return cDBOper;
/*      */   }
/*      */ 
/*      */   public String getV(String FCode) {
/*  508 */     String strReturn = "";
/*  509 */     if (FCode.equalsIgnoreCase("ContNo")) {
/*  510 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.contNo));
/*      */     }
/*  512 */     if (FCode.equalsIgnoreCase("CustomerName")) {
/*  513 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.customerName));
/*      */     }
/*  515 */     if (FCode.equalsIgnoreCase("taxResidentType")) {
/*  516 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.taxResidentType));
/*      */     }
/*  518 */     if (FCode.equalsIgnoreCase("taxResidentType")) {
/*  519 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.taxResidentType));
/*      */     }
/*  521 */     if (FCode.equalsIgnoreCase("lastName")) {
/*  522 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.lastName));
/*      */     }
/*  524 */     if (FCode.equalsIgnoreCase("birthday")) {
/*  525 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.birthday));
/*      */     }
/*  527 */     if (FCode.equalsIgnoreCase("currentAddress_Country")) {
/*  528 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.currentAddress_Country));
/*      */     }
/*  530 */     if (FCode.equalsIgnoreCase("currentAddress_Province")) {
/*  531 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.currentAddress_Province));
/*      */     }
/*  533 */     if (FCode.equalsIgnoreCase("currentAddress_City")) {
/*  534 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.currentAddress_City));
/*      */     }
/*  536 */     if (FCode.equalsIgnoreCase("currentAddress_Detail")) {
/*  537 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.currentAddress_Detail));
/*      */     }
/*  539 */     if (FCode.equalsIgnoreCase("currentAddress_Country_en")) {
/*  540 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.currentAddress_Country_en));
/*      */     }
/*  542 */     if (FCode.equalsIgnoreCase("currentAddress_Province_en")) {
/*  543 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.currentAddress_Province_en));
/*      */     }
/*  545 */     if (FCode.equalsIgnoreCase("currentAddress_City_en")) {
/*  546 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.currentAddress_City_en));
/*      */     }
/*  548 */     if (FCode.equalsIgnoreCase("currentAddress_Detail_en")) {
/*  549 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.currentAddress_Detail_en));
/*      */     }
/*  551 */     if (FCode.equalsIgnoreCase("birthAddress_Country")) {
/*  552 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.birthAddress_Country));
/*      */     }
/*  554 */     if (FCode.equalsIgnoreCase("birthAddress_Province")) {
/*  555 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.birthAddress_Province));
/*      */     }
/*  557 */     if (FCode.equalsIgnoreCase("birthAddress_City")) {
/*  558 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.birthAddress_City));
/*      */     }
/*  560 */     if (FCode.equalsIgnoreCase("birthAddress_Detail")) {
/*  561 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.birthAddress_Detail));
/*      */     }
/*  563 */     if (FCode.equalsIgnoreCase("birthAddress_Country_en")) {
/*  564 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.birthAddress_Country_en));
/*      */     }
/*  566 */     if (FCode.equalsIgnoreCase("birthAddress_Province_en")) {
/*  567 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.birthAddress_Province_en));
/*      */     }
/*  569 */     if (FCode.equalsIgnoreCase("birthAddress_City_en")) {
/*  570 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.birthAddress_City_en));
/*      */     }
/*  572 */     if (FCode.equalsIgnoreCase("birthAddress_Detail_en")) {
/*  573 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.birthAddress_Detail_en));
/*      */     }
/*  575 */     if (FCode.equalsIgnoreCase("taxResidentCountry1")) {
/*  576 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.taxResidentCountry1));
/*      */     }
/*  578 */     if (FCode.equalsIgnoreCase("taxpayerCode1")) {
/*  579 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.taxpayerCode1));
/*      */     }
/*  581 */     if (FCode.equalsIgnoreCase("taxResidentCountry2")) {
/*  582 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.taxResidentCountry2));
/*      */     }
/*  584 */     if (FCode.equalsIgnoreCase("taxpayerCode2")) {
/*  585 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.taxpayerCode2));
/*      */     }
/*  587 */     if (FCode.equalsIgnoreCase("taxResidentCountry3")) {
/*  588 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.taxResidentCountry3));
/*      */     }
/*  590 */     if (FCode.equalsIgnoreCase("taxpayerCode3")) {
/*  591 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.taxpayerCode3));
/*      */     }
/*  593 */     if (FCode.equalsIgnoreCase("noTaxpayercodeReason")) {
/*  594 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.noTaxpayercodeReason));
/*      */     }
/*  596 */     if (FCode.equalsIgnoreCase("reasonDescription")) {
/*  597 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.reasonDescription));
/*      */     }
/*  599 */     if (FCode.equalsIgnoreCase("sourceType")) {
/*  600 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.sourceType));
/*      */     }
/*  602 */     if (strReturn.equals("")) {
/*  603 */       strReturn = "null";
/*      */     }
/*      */ 
/*  606 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public String getV(int nFieldIndex) {
/*  610 */     String strFieldValue = "";
/*  611 */     switch (nFieldIndex) {
/*      */     case 0:
/*  613 */       strFieldValue = StrTool.GBKToUnicode(this.contNo);
/*  614 */       break;
/*      */     case 1:
/*  616 */       strFieldValue = StrTool.GBKToUnicode(this.customerName);
/*  617 */       break;
/*      */     case 2:
/*  619 */       strFieldValue = StrTool.GBKToUnicode(this.taxResidentType);
/*  620 */       break;
/*      */     case 3:
/*  622 */       strFieldValue = StrTool.GBKToUnicode(this.firstName);
/*  623 */       break;
/*      */     case 4:
/*  625 */       strFieldValue = StrTool.GBKToUnicode(this.lastName);
/*  626 */       break;
/*      */     case 5:
/*  628 */       strFieldValue = StrTool.GBKToUnicode(this.birthday);
/*  629 */       break;
/*      */     case 6:
/*  631 */       strFieldValue = StrTool.GBKToUnicode(this.currentAddress_Country);
/*  632 */       break;
/*      */     case 7:
/*  634 */       strFieldValue = StrTool.GBKToUnicode(this.currentAddress_Province);
/*  635 */       break;
/*      */     case 8:
/*  637 */       strFieldValue = StrTool.GBKToUnicode(this.currentAddress_City);
/*  638 */       break;
/*      */     case 9:
/*  640 */       strFieldValue = StrTool.GBKToUnicode(this.currentAddress_Detail);
/*  641 */       break;
/*      */     case 10:
/*  643 */       strFieldValue = StrTool.GBKToUnicode(this.currentAddress_Country_en);
/*  644 */       break;
/*      */     case 11:
/*  646 */       strFieldValue = StrTool.GBKToUnicode(this.currentAddress_Province_en);
/*  647 */       break;
/*      */     case 12:
/*  649 */       strFieldValue = StrTool.GBKToUnicode(this.currentAddress_City_en);
/*  650 */       break;
/*      */     case 13:
/*  652 */       strFieldValue = StrTool.GBKToUnicode(this.currentAddress_Detail_en);
/*  653 */       break;
/*      */     case 14:
/*  655 */       strFieldValue = StrTool.GBKToUnicode(this.birthAddress_Country);
/*  656 */       break;
/*      */     case 15:
/*  658 */       strFieldValue = StrTool.GBKToUnicode(this.birthAddress_Province);
/*  659 */       break;
/*      */     case 16:
/*  661 */       strFieldValue = StrTool.GBKToUnicode(this.birthAddress_City);
/*  662 */       break;
/*      */     case 17:
/*  664 */       strFieldValue = StrTool.GBKToUnicode(this.birthAddress_Detail);
/*  665 */       break;
/*      */     case 18:
/*  667 */       strFieldValue = StrTool.GBKToUnicode(this.birthAddress_Country_en);
/*  668 */       break;
/*      */     case 19:
/*  670 */       strFieldValue = StrTool.GBKToUnicode(this.birthAddress_Province_en);
/*  671 */       break;
/*      */     case 20:
/*  673 */       strFieldValue = StrTool.GBKToUnicode(this.birthAddress_City_en);
/*  674 */       break;
/*      */     case 21:
/*  676 */       strFieldValue = StrTool.GBKToUnicode(this.birthAddress_Detail_en);
/*  677 */       break;
/*      */     case 22:
/*  679 */       strFieldValue = StrTool.GBKToUnicode(this.taxResidentCountry1);
/*  680 */       break;
/*      */     case 23:
/*  682 */       strFieldValue = StrTool.GBKToUnicode(this.taxpayerCode1);
/*  683 */       break;
/*      */     case 24:
/*  685 */       strFieldValue = StrTool.GBKToUnicode(this.taxResidentCountry2);
/*  686 */       break;
/*      */     case 25:
/*  688 */       strFieldValue = StrTool.GBKToUnicode(this.taxpayerCode2);
/*  689 */       break;
/*      */     case 26:
/*  691 */       strFieldValue = StrTool.GBKToUnicode(this.taxResidentCountry3);
/*  692 */       break;
/*      */     case 27:
/*  694 */       strFieldValue = StrTool.GBKToUnicode(this.taxpayerCode3);
/*  695 */       break;
/*      */     case 28:
/*  697 */       strFieldValue = StrTool.GBKToUnicode(this.noTaxpayercodeReason);
/*  698 */       break;
/*      */     case 29:
/*  700 */       strFieldValue = StrTool.GBKToUnicode(this.reasonDescription);
/*  701 */       break;
/*      */     case 30:
/*  703 */       strFieldValue = StrTool.GBKToUnicode(this.sourceType);
/*  704 */       break;
/*      */     default:
/*  707 */       strFieldValue = "";
/*      */     }
/*      */ 
/*  710 */     if (strFieldValue.equals("")) {
/*  711 */       strFieldValue = "null";
/*      */     }
/*  713 */     return strFieldValue;
/*      */   }
/*      */ 
/*      */   public boolean setV(String FCode, String FValue) {
/*  717 */     if (StrTool.cTrim(FCode).equals("")) {
/*  718 */       return false;
/*      */     }
/*  720 */     if (FCode.equalsIgnoreCase("ContNo")) {
/*  721 */       if ((FValue != null) && (!FValue.equals("")))
/*  722 */         this.contNo = FValue.trim();
/*      */       else
/*  724 */         this.contNo = null;
/*      */     }
/*  726 */     if (FCode.equalsIgnoreCase("CustomerName")) {
/*  727 */       if ((FValue != null) && (!FValue.equals("")))
/*  728 */         this.customerName = FValue.trim();
/*      */       else
/*  730 */         this.customerName = null;
/*      */     }
/*  732 */     if (FCode.equalsIgnoreCase("taxResidentType")) {
/*  733 */       if ((FValue != null) && (!FValue.equals("")))
/*  734 */         this.taxResidentType = FValue.trim();
/*      */       else
/*  736 */         this.taxResidentType = null;
/*      */     }
/*  738 */     if (FCode.equalsIgnoreCase("firstName")) {
/*  739 */       if ((FValue != null) && (!FValue.equals("")))
/*  740 */         this.firstName = FValue.trim();
/*      */       else
/*  742 */         this.firstName = null;
/*      */     }
/*  744 */     if (FCode.equalsIgnoreCase("lastName")) {
/*  745 */       if ((FValue != null) && (!FValue.equals("")))
/*  746 */         this.lastName = FValue.trim();
/*      */       else
/*  748 */         this.lastName = null;
/*      */     }
/*  750 */     if (FCode.equalsIgnoreCase("birthday")) {
/*  751 */       if ((FValue != null) && (!FValue.equals("")))
/*  752 */         this.birthday = FValue.trim();
/*      */       else
/*  754 */         this.birthday = null;
/*      */     }
/*  756 */     if (FCode.equalsIgnoreCase("currentAddress_Country")) {
/*  757 */       if ((FValue != null) && (!FValue.equals("")))
/*  758 */         this.currentAddress_Country = FValue.trim();
/*      */       else
/*  760 */         this.currentAddress_Country = null;
/*      */     }
/*  762 */     if (FCode.equalsIgnoreCase("currentAddress_Province")) {
/*  763 */       if ((FValue != null) && (!FValue.equals("")))
/*  764 */         this.currentAddress_Province = FValue.trim();
/*      */       else
/*  766 */         this.currentAddress_Province = null;
/*      */     }
/*  768 */     if (FCode.equalsIgnoreCase("currentAddress_City")) {
/*  769 */       if ((FValue != null) && (!FValue.equals("")))
/*  770 */         this.currentAddress_City = FValue.trim();
/*      */       else
/*  772 */         this.currentAddress_City = null;
/*      */     }
/*  774 */     if (FCode.equalsIgnoreCase("currentAddress_Detail")) {
/*  775 */       if ((FValue != null) && (!FValue.equals("")))
/*  776 */         this.currentAddress_Detail = FValue.trim();
/*      */       else
/*  778 */         this.currentAddress_Detail = null;
/*      */     }
/*  780 */     if (FCode.equalsIgnoreCase("currentAddress_Country_en")) {
/*  781 */       if ((FValue != null) && (!FValue.equals("")))
/*  782 */         this.currentAddress_Country_en = FValue.trim();
/*      */       else
/*  784 */         this.currentAddress_Country_en = null;
/*      */     }
/*  786 */     if (FCode.equalsIgnoreCase("currentAddress_Province_en")) {
/*  787 */       if ((FValue != null) && (!FValue.equals("")))
/*  788 */         this.currentAddress_Province_en = FValue.trim();
/*      */       else
/*  790 */         this.currentAddress_Province_en = null;
/*      */     }
/*  792 */     if (FCode.equalsIgnoreCase("currentAddress_City_en")) {
/*  793 */       if ((FValue != null) && (!FValue.equals("")))
/*  794 */         this.currentAddress_Detail_en = FValue.trim();
/*      */       else
/*  796 */         this.currentAddress_Detail_en = null;
/*      */     }
/*  798 */     if (FCode.equalsIgnoreCase("birthAddress_Country")) {
/*  799 */       if ((FValue != null) && (!FValue.equals("")))
/*  800 */         this.birthAddress_Country = FValue.trim();
/*      */       else
/*  802 */         this.birthAddress_Country = null;
/*      */     }
/*  804 */     if (FCode.equalsIgnoreCase("CustomerName")) {
/*  805 */       if ((FValue != null) && (!FValue.equals("")))
/*  806 */         this.customerName = FValue.trim();
/*      */       else
/*  808 */         this.customerName = null;
/*      */     }
/*  810 */     if (FCode.equalsIgnoreCase("birthAddress_Province")) {
/*  811 */       if ((FValue != null) && (!FValue.equals("")))
/*  812 */         this.birthAddress_Province = FValue.trim();
/*      */       else
/*  814 */         this.birthAddress_Province = null;
/*      */     }
/*  816 */     if (FCode.equalsIgnoreCase("birthAddress_City")) {
/*  817 */       if ((FValue != null) && (!FValue.equals("")))
/*  818 */         this.birthAddress_City = FValue.trim();
/*      */       else
/*  820 */         this.birthAddress_City = null;
/*      */     }
/*  822 */     if (FCode.equalsIgnoreCase("birthAddress_Detail")) {
/*  823 */       if ((FValue != null) && (!FValue.equals("")))
/*  824 */         this.birthAddress_Detail = FValue.trim();
/*      */       else
/*  826 */         this.birthAddress_Detail = null;
/*      */     }
/*  828 */     if (FCode.equalsIgnoreCase("birthAddress_Country_en")) {
/*  829 */       if ((FValue != null) && (!FValue.equals("")))
/*  830 */         this.birthAddress_Country_en = FValue.trim();
/*      */       else
/*  832 */         this.birthAddress_Country_en = null;
/*      */     }
/*  834 */     if (FCode.equalsIgnoreCase("birthAddress_Province_en")) {
/*  835 */       if ((FValue != null) && (!FValue.equals("")))
/*  836 */         this.birthAddress_Province_en = FValue.trim();
/*      */       else
/*  838 */         this.birthAddress_Province_en = null;
/*      */     }
/*  840 */     if (FCode.equalsIgnoreCase("birthAddress_City_en")) {
/*  841 */       if ((FValue != null) && (!FValue.equals("")))
/*  842 */         this.birthAddress_City_en = FValue.trim();
/*      */       else
/*  844 */         this.birthAddress_City_en = null;
/*      */     }
/*  846 */     if (FCode.equalsIgnoreCase("birthAddress_Detail_en")) {
/*  847 */       if ((FValue != null) && (!FValue.equals("")))
/*  848 */         this.birthAddress_Detail_en = FValue.trim();
/*      */       else
/*  850 */         this.birthAddress_Detail_en = null;
/*      */     }
/*  852 */     if (FCode.equalsIgnoreCase("taxResidentCountry1")) {
/*  853 */       if ((FValue != null) && (!FValue.equals("")))
/*  854 */         this.taxResidentCountry1 = FValue.trim();
/*      */       else
/*  856 */         this.taxResidentCountry1 = null;
/*      */     }
/*  858 */     if (FCode.equalsIgnoreCase("taxpayerCode1")) {
/*  859 */       if ((FValue != null) && (!FValue.equals("")))
/*  860 */         this.taxpayerCode1 = FValue.trim();
/*      */       else
/*  862 */         this.taxpayerCode1 = null;
/*      */     }
/*  864 */     if (FCode.equalsIgnoreCase("taxResidentCountry2")) {
/*  865 */       if ((FValue != null) && (!FValue.equals("")))
/*  866 */         this.taxResidentCountry2 = FValue.trim();
/*      */       else
/*  868 */         this.taxResidentCountry2 = null;
/*      */     }
/*  870 */     if (FCode.equalsIgnoreCase("taxpayerCode2")) {
/*  871 */       if ((FValue != null) && (!FValue.equals("")))
/*  872 */         this.taxpayerCode2 = FValue.trim();
/*      */       else
/*  874 */         this.taxpayerCode2 = null;
/*      */     }
/*  876 */     if (FCode.equalsIgnoreCase("taxResidentCountry3")) {
/*  877 */       if ((FValue != null) && (!FValue.equals("")))
/*  878 */         this.taxResidentCountry3 = FValue.trim();
/*      */       else
/*  880 */         this.taxResidentCountry3 = null;
/*      */     }
/*  882 */     if (FCode.equalsIgnoreCase("taxpayerCode3")) {
/*  883 */       if ((FValue != null) && (!FValue.equals("")))
/*  884 */         this.taxpayerCode3 = FValue.trim();
/*      */       else
/*  886 */         this.taxpayerCode3 = null;
/*      */     }
/*  888 */     if (FCode.equalsIgnoreCase("noTaxpayercodeReason")) {
/*  889 */       if ((FValue != null) && (!FValue.equals("")))
/*  890 */         this.noTaxpayercodeReason = FValue.trim();
/*      */       else
/*  892 */         this.noTaxpayercodeReason = null;
/*      */     }
/*  894 */     if (FCode.equalsIgnoreCase("reasonDescription")) {
/*  895 */       if ((FValue != null) && (!FValue.equals("")))
/*  896 */         this.reasonDescription = FValue.trim();
/*      */       else
/*  898 */         this.reasonDescription = null;
/*      */     }
/*  900 */     if (FCode.equalsIgnoreCase("sourceType")) {
/*  901 */       if ((FValue != null) && (!FValue.equals("")))
/*  902 */         this.sourceType = FValue.trim();
/*      */       else
/*  904 */         this.sourceType = null;
/*      */     }
/*  906 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean equals(Object otherObject)
/*      */   {
/*  911 */     if (otherObject == null)
/*  912 */       return false;
/*  913 */     if (this == otherObject)
/*  914 */       return true;
/*  915 */     if (getClass() != otherObject.getClass())
/*  916 */       return false;
/*  917 */     CRSInfoSchema other = (CRSInfoSchema)otherObject;
/*      */ 
/*  919 */     if ((this.contNo == null) && (other.getContNo() != null))
/*  920 */       return false;
/*  921 */     if ((this.contNo != null) && (!this.contNo.equals(other.getContNo())))
/*  922 */       return false;
/*  923 */     if ((this.customerName == null) && (other.getContNo() != null))
/*  924 */       return false;
/*  925 */     if ((this.customerName != null) && (!this.customerName.equals(other.getContNo())))
/*  926 */       return false;
/*  927 */     if ((this.taxResidentType == null) && (other.getContNo() != null))
/*  928 */       return false;
/*  929 */     if ((this.taxResidentType != null) && (!this.taxResidentType.equals(other.getContNo())))
/*  930 */       return false;
/*  931 */     if ((this.firstName == null) && (other.getContNo() != null))
/*  932 */       return false;
/*  933 */     if ((this.firstName != null) && (!this.firstName.equals(other.getContNo())))
/*  934 */       return false;
/*  935 */     if ((this.lastName == null) && (other.getContNo() != null))
/*  936 */       return false;
/*  937 */     if ((this.lastName != null) && (!this.lastName.equals(other.getContNo())))
/*  938 */       return false;
/*  939 */     if ((this.birthday == null) && (other.getContNo() != null))
/*  940 */       return false;
/*  941 */     if ((this.birthday != null) && (!this.birthday.equals(other.getContNo())))
/*  942 */       return false;
/*  943 */     if ((this.currentAddress_Country == null) && (other.getContNo() != null))
/*  944 */       return false;
/*  945 */     if ((this.currentAddress_Country != null) && (!this.currentAddress_Country.equals(other.getContNo())))
/*  946 */       return false;
/*  947 */     if ((this.currentAddress_Province == null) && (other.getContNo() != null))
/*  948 */       return false;
/*  949 */     if ((this.currentAddress_Province != null) && (!this.currentAddress_Province.equals(other.getContNo())))
/*  950 */       return false;
/*  951 */     if ((this.currentAddress_City == null) && (other.getContNo() != null))
/*  952 */       return false;
/*  953 */     if ((this.currentAddress_City != null) && (!this.currentAddress_City.equals(other.getContNo())))
/*  954 */       return false;
/*  955 */     if ((this.currentAddress_Detail == null) && (other.getContNo() != null))
/*  956 */       return false;
/*  957 */     if ((this.currentAddress_Detail != null) && (!this.currentAddress_Detail.equals(other.getContNo())))
/*  958 */       return false;
/*  959 */     if ((this.currentAddress_Country_en == null) && (other.getContNo() != null))
/*  960 */       return false;
/*  961 */     if ((this.currentAddress_Country_en != null) && (!this.currentAddress_Country_en.equals(other.getContNo())))
/*  962 */       return false;
/*  963 */     if ((this.currentAddress_Province_en == null) && (other.getContNo() != null))
/*  964 */       return false;
/*  965 */     if ((this.currentAddress_Province_en != null) && (!this.currentAddress_Province_en.equals(other.getContNo())))
/*  966 */       return false;
/*  967 */     if ((this.currentAddress_City_en == null) && (other.getContNo() != null))
/*  968 */       return false;
/*  969 */     if ((this.currentAddress_City_en != null) && (!this.currentAddress_City_en.equals(other.getContNo())))
/*  970 */       return false;
/*  971 */     if ((this.currentAddress_Detail_en == null) && (other.getContNo() != null))
/*  972 */       return false;
/*  973 */     if ((this.currentAddress_Detail_en != null) && (!this.currentAddress_Detail_en.equals(other.getContNo())))
/*  974 */       return false;
/*  975 */     if ((this.birthAddress_Country == null) && (other.getContNo() != null))
/*  976 */       return false;
/*  977 */     if ((this.birthAddress_Country != null) && (!this.birthAddress_Country.equals(other.getContNo())))
/*  978 */       return false;
/*  979 */     if ((this.birthAddress_Province == null) && (other.getContNo() != null))
/*  980 */       return false;
/*  981 */     if ((this.birthAddress_Province != null) && (!this.birthAddress_Province.equals(other.getContNo())))
/*  982 */       return false;
/*  983 */     if ((this.birthAddress_City == null) && (other.getContNo() != null))
/*  984 */       return false;
/*  985 */     if ((this.birthAddress_City != null) && (!this.birthAddress_City.equals(other.getContNo())))
/*  986 */       return false;
/*  987 */     if ((this.birthAddress_Detail == null) && (other.getContNo() != null))
/*  988 */       return false;
/*  989 */     if ((this.birthAddress_Detail != null) && (!this.birthAddress_Detail.equals(other.getContNo())))
/*  990 */       return false;
/*  991 */     if ((this.birthAddress_Country_en == null) && (other.getContNo() != null))
/*  992 */       return false;
/*  993 */     if ((this.birthAddress_Country_en != null) && (!this.birthAddress_Country_en.equals(other.getContNo())))
/*  994 */       return false;
/*  995 */     if ((this.birthAddress_Province_en == null) && (other.getContNo() != null))
/*  996 */       return false;
/*  997 */     if ((this.birthAddress_Province_en != null) && (!this.birthAddress_Province_en.equals(other.getContNo())))
/*  998 */       return false;
/*  999 */     if ((this.birthAddress_City_en == null) && (other.getContNo() != null))
/* 1000 */       return false;
/* 1001 */     if ((this.birthAddress_City_en != null) && (!this.birthAddress_City_en.equals(other.getContNo())))
/* 1002 */       return false;
/* 1003 */     if ((this.birthAddress_Detail_en == null) && (other.getContNo() != null))
/* 1004 */       return false;
/* 1005 */     if ((this.birthAddress_Detail_en != null) && (!this.birthAddress_Detail_en.equals(other.getContNo())))
/* 1006 */       return false;
/* 1007 */     if ((this.taxResidentCountry1 == null) && (other.getContNo() != null))
/* 1008 */       return false;
/* 1009 */     if ((this.taxResidentCountry1 != null) && (!this.taxResidentCountry1.equals(other.getContNo())))
/* 1010 */       return false;
/* 1011 */     if ((this.taxpayerCode1 == null) && (other.getContNo() != null))
/* 1012 */       return false;
/* 1013 */     if ((this.taxpayerCode1 != null) && (!this.taxpayerCode1.equals(other.getContNo())))
/* 1014 */       return false;
/* 1015 */     if ((this.taxResidentCountry2 == null) && (other.getContNo() != null))
/* 1016 */       return false;
/* 1017 */     if ((this.taxResidentCountry2 != null) && (!this.taxResidentCountry2.equals(other.getContNo())))
/* 1018 */       return false;
/* 1019 */     if ((this.taxpayerCode2 == null) && (other.getContNo() != null))
/* 1020 */       return false;
/* 1021 */     if ((this.taxpayerCode2 != null) && (!this.taxpayerCode2.equals(other.getContNo())))
/* 1022 */       return false;
/* 1023 */     if ((this.taxResidentCountry3 == null) && (other.getContNo() != null))
/* 1024 */       return false;
/* 1025 */     if ((this.taxResidentCountry3 != null) && (!this.taxResidentCountry3.equals(other.getContNo())))
/* 1026 */       return false;
/* 1027 */     if ((this.taxpayerCode3 == null) && (other.getContNo() != null))
/* 1028 */       return false;
/* 1029 */     if ((this.taxpayerCode3 != null) && (!this.taxpayerCode3.equals(other.getContNo())))
/* 1030 */       return false;
/* 1031 */     if ((this.noTaxpayercodeReason == null) && (other.getContNo() != null))
/* 1032 */       return false;
/* 1033 */     if ((this.noTaxpayercodeReason != null) && (!this.noTaxpayercodeReason.equals(other.getContNo())))
/* 1034 */       return false;
/* 1035 */     if ((this.reasonDescription == null) && (other.getContNo() != null))
/* 1036 */       return false;
/* 1037 */     if ((this.reasonDescription != null) && (!this.reasonDescription.equals(other.getContNo())))
/* 1038 */       return false;
/* 1039 */     if ((this.sourceType == null) && (other.getContNo() != null)) {
/* 1040 */       return false;
/*      */     }
/* 1042 */     return (this.sourceType == null) || (this.sourceType.equals(other.getContNo()));
/*      */   }
/*      */ 
/*      */   public int getFieldCount()
/*      */   {
/* 1047 */     return 31;
/*      */   }
/*      */ 
/*      */   public int getFieldIndex(String strFieldName) {
/* 1051 */     if (strFieldName.equals("ContNo")) {
/* 1052 */       return 0;
/*      */     }
/* 1054 */     if (strFieldName.equals("CustomerName")) {
/* 1055 */       return 1;
/*      */     }
/* 1057 */     if (strFieldName.equals("taxResidentType")) {
/* 1058 */       return 2;
/*      */     }
/* 1060 */     if (strFieldName.equals("firstName")) {
/* 1061 */       return 3;
/*      */     }
/* 1063 */     if (strFieldName.equals("lastName")) {
/* 1064 */       return 4;
/*      */     }
/* 1066 */     if (strFieldName.equals("birthday")) {
/* 1067 */       return 5;
/*      */     }
/* 1069 */     if (strFieldName.equals("currentAddress_Country")) {
/* 1070 */       return 6;
/*      */     }
/* 1072 */     if (strFieldName.equals("currentAddress_Province")) {
/* 1073 */       return 7;
/*      */     }
/* 1075 */     if (strFieldName.equals("currentAddress_City")) {
/* 1076 */       return 8;
/*      */     }
/* 1078 */     if (strFieldName.equals("currentAddress_Detail")) {
/* 1079 */       return 9;
/*      */     }
/* 1081 */     if (strFieldName.equals("currentAddress_Country_en")) {
/* 1082 */       return 10;
/*      */     }
/* 1084 */     if (strFieldName.equals("currentAddress_Province_en")) {
/* 1085 */       return 11;
/*      */     }
/* 1087 */     if (strFieldName.equals("currentAddress_City_en")) {
/* 1088 */       return 12;
/*      */     }
/* 1090 */     if (strFieldName.equals("currentAddress_Detail_en")) {
/* 1091 */       return 13;
/*      */     }
/* 1093 */     if (strFieldName.equals("birthAddress_Country")) {
/* 1094 */       return 14;
/*      */     }
/* 1096 */     if (strFieldName.equals("birthAddress_Province")) {
/* 1097 */       return 15;
/*      */     }
/* 1099 */     if (strFieldName.equals("birthAddress_City")) {
/* 1100 */       return 16;
/*      */     }
/* 1102 */     if (strFieldName.equals("birthAddress_Detail")) {
/* 1103 */       return 17;
/*      */     }
/* 1105 */     if (strFieldName.equals("birthAddress_Country_en")) {
/* 1106 */       return 18;
/*      */     }
/* 1108 */     if (strFieldName.equals("birthAddress_Province_en")) {
/* 1109 */       return 19;
/*      */     }
/* 1111 */     if (strFieldName.equals("birthAddress_City_en")) {
/* 1112 */       return 20;
/*      */     }
/* 1114 */     if (strFieldName.equals("birthAddress_Detail_en")) {
/* 1115 */       return 21;
/*      */     }
/* 1117 */     if (strFieldName.equals("taxResidentCountry1")) {
/* 1118 */       return 22;
/*      */     }
/* 1120 */     if (strFieldName.equals("taxpayerCode1")) {
/* 1121 */       return 23;
/*      */     }
/* 1123 */     if (strFieldName.equals("taxResidentCountry2")) {
/* 1124 */       return 24;
/*      */     }
/* 1126 */     if (strFieldName.equals("taxpayerCode2")) {
/* 1127 */       return 25;
/*      */     }
/* 1129 */     if (strFieldName.equals("taxResidentCountry3")) {
/* 1130 */       return 26;
/*      */     }
/* 1132 */     if (strFieldName.equals("taxpayerCode3")) {
/* 1133 */       return 27;
/*      */     }
/* 1135 */     if (strFieldName.equals("noTaxpayercodeReason")) {
/* 1136 */       return 28;
/*      */     }
/* 1138 */     if (strFieldName.equals("reasonDescription")) {
/* 1139 */       return 29;
/*      */     }
/* 1141 */     if (strFieldName.equals("sourceType")) {
/* 1142 */       return 30;
/*      */     }
/* 1144 */     return -1;
/*      */   }
/*      */ 
/*      */   public String getFieldName(int nFieldIndex) {
/* 1148 */     String strFieldName = "";
/* 1149 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1151 */       strFieldName = "contNo";
/* 1152 */       break;
/*      */     case 1:
/* 1154 */       strFieldName = "customerName";
/* 1155 */       break;
/*      */     case 2:
/* 1157 */       strFieldName = "taxResidentType";
/* 1158 */       break;
/*      */     case 3:
/* 1160 */       strFieldName = "firstName";
/* 1161 */       break;
/*      */     case 4:
/* 1163 */       strFieldName = "lastName";
/* 1164 */       break;
/*      */     case 5:
/* 1166 */       strFieldName = "birthday";
/* 1167 */       break;
/*      */     case 6:
/* 1169 */       strFieldName = "currentAddress_Country";
/* 1170 */       break;
/*      */     case 7:
/* 1172 */       strFieldName = "currentAddress_Province";
/* 1173 */       break;
/*      */     case 8:
/* 1175 */       strFieldName = "currentAddress_City";
/* 1176 */       break;
/*      */     case 9:
/* 1178 */       strFieldName = "currentAddress_Detail";
/* 1179 */       break;
/*      */     case 10:
/* 1181 */       strFieldName = "currentAddress_Country_en";
/* 1182 */       break;
/*      */     case 11:
/* 1184 */       strFieldName = "currentAddress_Province_en";
/* 1185 */       break;
/*      */     case 12:
/* 1187 */       strFieldName = "currentAddress_City_en";
/* 1188 */       break;
/*      */     case 13:
/* 1190 */       strFieldName = "currentAddress_Detail_en";
/* 1191 */       break;
/*      */     case 14:
/* 1193 */       strFieldName = "birthAddress_Country";
/* 1194 */       break;
/*      */     case 15:
/* 1196 */       strFieldName = "birthAddress_Province";
/* 1197 */       break;
/*      */     case 16:
/* 1199 */       strFieldName = "birthAddress_City";
/* 1200 */       break;
/*      */     case 17:
/* 1202 */       strFieldName = "birthAddress_Detail";
/* 1203 */       break;
/*      */     case 18:
/* 1205 */       strFieldName = "birthAddress_Country_en";
/* 1206 */       break;
/*      */     case 19:
/* 1208 */       strFieldName = "birthAddress_Province_en";
/* 1209 */       break;
/*      */     case 20:
/* 1211 */       strFieldName = "birthAddress_City_en";
/* 1212 */       break;
/*      */     case 21:
/* 1214 */       strFieldName = "birthAddress_Detail_en";
/* 1215 */       break;
/*      */     case 22:
/* 1217 */       strFieldName = "taxResidentCountry1";
/* 1218 */       break;
/*      */     case 23:
/* 1220 */       strFieldName = "taxpayerCode1";
/* 1221 */       break;
/*      */     case 24:
/* 1223 */       strFieldName = "taxResidentCountry2";
/* 1224 */       break;
/*      */     case 25:
/* 1226 */       strFieldName = "taxpayerCode2";
/* 1227 */       break;
/*      */     case 26:
/* 1229 */       strFieldName = "taxpayerCode3";
/* 1230 */       break;
/*      */     case 27:
/* 1232 */       strFieldName = "taxResidentCountry3";
/* 1233 */       break;
/*      */     case 28:
/* 1235 */       strFieldName = "noTaxpayercodeReason";
/* 1236 */       break;
/*      */     case 29:
/* 1238 */       strFieldName = "reasonDescription";
/* 1239 */       break;
/*      */     case 30:
/* 1241 */       strFieldName = "sourceType";
/* 1242 */       break;
/*      */     default:
/* 1244 */       strFieldName = "";
/*      */     }
/*      */ 
/* 1247 */     return strFieldName;
/*      */   }
/*      */ 
/*      */   public int getFieldType(String strFieldName) {
/* 1251 */     if (strFieldName.equals("contNo")) {
/* 1252 */       return 0;
/*      */     }
/* 1254 */     if (strFieldName.equals("customerName")) {
/* 1255 */       return 0;
/*      */     }
/* 1257 */     if (strFieldName.equals("taxResidentType")) {
/* 1258 */       return 0;
/*      */     }
/* 1260 */     if (strFieldName.equals("firstName")) {
/* 1261 */       return 0;
/*      */     }
/* 1263 */     if (strFieldName.equals("lastName")) {
/* 1264 */       return 0;
/*      */     }
/* 1266 */     if (strFieldName.equals("birthday")) {
/* 1267 */       return 0;
/*      */     }
/* 1269 */     if (strFieldName.equals("currentAddress_Country")) {
/* 1270 */       return 0;
/*      */     }
/* 1272 */     if (strFieldName.equals("currentAddress_Province")) {
/* 1273 */       return 0;
/*      */     }
/* 1275 */     if (strFieldName.equals("currentAddress_City")) {
/* 1276 */       return 0;
/*      */     }
/* 1278 */     if (strFieldName.equals("currentAddress_Detail")) {
/* 1279 */       return 0;
/*      */     }
/* 1281 */     if (strFieldName.equals("currentAddress_Country_en")) {
/* 1282 */       return 0;
/*      */     }
/* 1284 */     if (strFieldName.equals("currentAddress_Province_en")) {
/* 1285 */       return 0;
/*      */     }
/* 1287 */     if (strFieldName.equals("currentAddress_City_en")) {
/* 1288 */       return 0;
/*      */     }
/* 1290 */     if (strFieldName.equals("currentAddress_Detail_en")) {
/* 1291 */       return 0;
/*      */     }
/* 1293 */     if (strFieldName.equals("birthAddress_Country")) {
/* 1294 */       return 0;
/*      */     }
/* 1296 */     if (strFieldName.equals("birthAddress_Province")) {
/* 1297 */       return 0;
/*      */     }
/* 1299 */     if (strFieldName.equals("birthAddress_City")) {
/* 1300 */       return 0;
/*      */     }
/* 1302 */     if (strFieldName.equals("birthAddress_Detail")) {
/* 1303 */       return 0;
/*      */     }
/* 1305 */     if (strFieldName.equals("birthAddress_Country_en")) {
/* 1306 */       return 0;
/*      */     }
/* 1308 */     if (strFieldName.equals("birthAddress_Province_en")) {
/* 1309 */       return 0;
/*      */     }
/* 1311 */     if (strFieldName.equals("birthAddress_City_en")) {
/* 1312 */       return 0;
/*      */     }
/* 1314 */     if (strFieldName.equals("birthAddress_Detail_en")) {
/* 1315 */       return 0;
/*      */     }
/* 1317 */     if (strFieldName.equals("taxResidentCountry1")) {
/* 1318 */       return 0;
/*      */     }
/* 1320 */     if (strFieldName.equals("taxpayerCode1")) {
/* 1321 */       return 0;
/*      */     }
/* 1323 */     if (strFieldName.equals("taxResidentCountry2")) {
/* 1324 */       return 0;
/*      */     }
/* 1326 */     if (strFieldName.equals("taxpayerCode2")) {
/* 1327 */       return 0;
/*      */     }
/* 1329 */     if (strFieldName.equals("taxResidentCountry3")) {
/* 1330 */       return 0;
/*      */     }
/* 1332 */     if (strFieldName.equals("taxpayerCode3")) {
/* 1333 */       return 0;
/*      */     }
/* 1335 */     if (strFieldName.equals("noTaxpayercodeReason")) {
/* 1336 */       return 0;
/*      */     }
/* 1338 */     if (strFieldName.equals("reasonDescription")) {
/* 1339 */       return 0;
/*      */     }
/* 1341 */     if (strFieldName.equals("sourceType")) {
/* 1342 */       return 0;
/*      */     }
/* 1344 */     return -1;
/*      */   }
/*      */ 
/*      */   public int getFieldType(int nFieldIndex) {
/* 1348 */     int nFieldType = -1;
/* 1349 */     switch (nFieldIndex) {
/*      */     case 0:
/* 1351 */       nFieldType = 0;
/* 1352 */       break;
/*      */     case 1:
/* 1354 */       nFieldType = 0;
/* 1355 */       break;
/*      */     case 2:
/* 1357 */       nFieldType = 0;
/* 1358 */       break;
/*      */     case 3:
/* 1360 */       nFieldType = 0;
/* 1361 */       break;
/*      */     case 4:
/* 1363 */       nFieldType = 0;
/* 1364 */       break;
/*      */     case 5:
/* 1366 */       nFieldType = 0;
/* 1367 */       break;
/*      */     case 6:
/* 1369 */       nFieldType = 0;
/* 1370 */       break;
/*      */     case 7:
/* 1372 */       nFieldType = 0;
/* 1373 */       break;
/*      */     case 8:
/* 1375 */       nFieldType = 0;
/* 1376 */       break;
/*      */     case 9:
/* 1378 */       nFieldType = 0;
/* 1379 */       break;
/*      */     case 10:
/* 1381 */       nFieldType = 0;
/* 1382 */       break;
/*      */     case 11:
/* 1384 */       nFieldType = 1;
/* 1385 */       break;
/*      */     case 12:
/* 1387 */       nFieldType = 3;
/* 1388 */       break;
/*      */     case 13:
/* 1390 */       nFieldType = 0;
/* 1391 */       break;
/*      */     case 14:
/* 1393 */       nFieldType = 0;
/* 1394 */       break;
/*      */     case 15:
/* 1396 */       nFieldType = 0;
/* 1397 */       break;
/*      */     case 16:
/* 1399 */       nFieldType = 0;
/* 1400 */       break;
/*      */     case 17:
/* 1402 */       nFieldType = 0;
/* 1403 */       break;
/*      */     case 18:
/* 1405 */       nFieldType = 0;
/* 1406 */       break;
/*      */     case 19:
/* 1408 */       nFieldType = 1;
/* 1409 */       break;
/*      */     case 20:
/* 1411 */       nFieldType = 0;
/* 1412 */       break;
/*      */     case 21:
/* 1414 */       nFieldType = 0;
/* 1415 */       break;
/*      */     case 22:
/* 1417 */       nFieldType = 0;
/* 1418 */       break;
/*      */     case 23:
/* 1420 */       nFieldType = 0;
/* 1421 */       break;
/*      */     case 24:
/* 1423 */       nFieldType = 0;
/* 1424 */       break;
/*      */     case 25:
/* 1426 */       nFieldType = 1;
/* 1427 */       break;
/*      */     case 26:
/* 1429 */       nFieldType = 0;
/* 1430 */       break;
/*      */     case 27:
/* 1432 */       nFieldType = 4;
/* 1433 */       break;
/*      */     case 28:
/* 1435 */       nFieldType = 4;
/* 1436 */       break;
/*      */     case 29:
/* 1438 */       nFieldType = 0;
/* 1439 */       break;
/*      */     case 30:
/* 1441 */       nFieldType = 0;
/* 1442 */       break;
/*      */     default:
/* 1444 */       nFieldType = -1;
/*      */     }
/*      */ 
/* 1447 */     return nFieldType;
/*      */   }
/*      */ 
/*      */   public Object encode() {
/* 1451 */     String strReturn = "";
/* 1452 */     strReturn = StrTool.cTrim(StrTool.unicodeToGBK(this.contNo)) + "|" + 
/* 1453 */       StrTool.cTrim(StrTool.unicodeToGBK(this.customerName)) + "|" + 
/* 1454 */       StrTool.cTrim(StrTool.unicodeToGBK(this.taxResidentType)) + "|" + 
/* 1455 */       StrTool.cTrim(StrTool.unicodeToGBK(this.firstName)) + "|" + 
/* 1456 */       StrTool.cTrim(StrTool.unicodeToGBK(this.lastName)) + "|" + 
/* 1457 */       StrTool.cTrim(StrTool.unicodeToGBK(this.birthday)) + "|" + 
/* 1458 */       StrTool.cTrim(StrTool.unicodeToGBK(this.currentAddress_Country)) + "|" + 
/* 1459 */       StrTool.cTrim(StrTool.unicodeToGBK(this.currentAddress_Province)) + "|" + 
/* 1460 */       StrTool.cTrim(StrTool.unicodeToGBK(this.currentAddress_City)) + "|" + 
/* 1461 */       StrTool.cTrim(StrTool.unicodeToGBK(this.currentAddress_Detail)) + "|" + 
/* 1462 */       StrTool.cTrim(StrTool.unicodeToGBK(this.currentAddress_Country_en)) + "|" + 
/* 1463 */       StrTool.cTrim(StrTool.unicodeToGBK(this.currentAddress_Province_en)) + "|" + 
/* 1464 */       StrTool.cTrim(StrTool.unicodeToGBK(this.currentAddress_City_en)) + "|" + 
/* 1465 */       StrTool.cTrim(StrTool.unicodeToGBK(this.currentAddress_Detail_en)) + "|" + 
/* 1466 */       StrTool.cTrim(StrTool.unicodeToGBK(this.birthAddress_Country)) + "|" + 
/* 1467 */       StrTool.cTrim(StrTool.unicodeToGBK(this.birthAddress_Province)) + "|" + 
/* 1468 */       StrTool.cTrim(StrTool.unicodeToGBK(this.birthAddress_City)) + "|" + 
/* 1469 */       StrTool.cTrim(StrTool.unicodeToGBK(this.birthAddress_Detail)) + "|" + 
/* 1470 */       StrTool.cTrim(StrTool.unicodeToGBK(this.birthAddress_Country_en)) + "|" + 
/* 1471 */       StrTool.cTrim(StrTool.unicodeToGBK(this.birthAddress_Province_en)) + "|" + 
/* 1472 */       StrTool.cTrim(StrTool.unicodeToGBK(this.birthAddress_City_en)) + "|" + 
/* 1473 */       StrTool.cTrim(StrTool.unicodeToGBK(this.birthAddress_Detail_en)) + "|" + 
/* 1474 */       StrTool.cTrim(StrTool.unicodeToGBK(this.taxResidentCountry1)) + "|" + 
/* 1475 */       StrTool.cTrim(StrTool.unicodeToGBK(this.taxpayerCode1)) + "|" + 
/* 1476 */       StrTool.cTrim(StrTool.unicodeToGBK(this.taxResidentCountry2)) + "|" + 
/* 1477 */       StrTool.cTrim(StrTool.unicodeToGBK(this.taxpayerCode2)) + "|" + 
/* 1478 */       StrTool.cTrim(StrTool.unicodeToGBK(this.taxResidentCountry3)) + "|" + 
/* 1479 */       StrTool.cTrim(StrTool.unicodeToGBK(this.taxpayerCode3)) + "|" + 
/* 1480 */       StrTool.cTrim(StrTool.unicodeToGBK(this.noTaxpayercodeReason)) + "|" + 
/* 1481 */       StrTool.cTrim(StrTool.unicodeToGBK(this.reasonDescription)) + "|" + 
/* 1482 */       StrTool.cTrim(StrTool.unicodeToGBK(this.sourceType)) + "|";
/*      */ 
/* 1484 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public boolean decode(String strMessage)
/*      */   {
/*      */     try {
/* 1490 */       this.contNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 1491 */       this.customerName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, "|");
/* 1492 */       this.taxResidentType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, "|");
/* 1493 */       this.firstName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, "|");
/* 1494 */       this.lastName = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, "|");
/* 1495 */       this.birthday = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 6, "|");
/* 1496 */       this.currentAddress_Country = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, "|");
/* 1497 */       this.currentAddress_Province = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, "|");
/* 1498 */       this.currentAddress_City = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, "|");
/* 1499 */       this.currentAddress_Detail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, "|");
/* 1500 */       this.currentAddress_Country_en = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, "|");
/* 1501 */       this.currentAddress_Province_en = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, "|");
/* 1502 */       this.currentAddress_City_en = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13, "|");
/* 1503 */       this.currentAddress_Detail_en = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, "|");
/* 1504 */       this.birthAddress_Country = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15, "|");
/* 1505 */       this.birthAddress_Province = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, "|");
/* 1506 */       this.birthAddress_City = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, "|");
/* 1507 */       this.birthAddress_Detail = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18, "|");
/* 1508 */       this.birthAddress_Country_en = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, "|");
/* 1509 */       this.birthAddress_Province_en = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20, "|");
/* 1510 */       this.birthAddress_City_en = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, "|");
/* 1511 */       this.birthAddress_Detail_en = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 22, "|");
/* 1512 */       this.taxResidentCountry1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 23, "|");
/* 1513 */       this.taxpayerCode1 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 24, "|");
/* 1514 */       this.taxResidentCountry2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 25, "|");
/* 1515 */       this.taxpayerCode2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 26, "|");
/* 1516 */       this.taxResidentCountry3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 27, "|");
/* 1517 */       this.taxpayerCode3 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 28, "|");
/* 1518 */       this.noTaxpayercodeReason = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 29, "|");
/* 1519 */       this.reasonDescription = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 30, "|");
/* 1520 */       this.sourceType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 31, "|");
/*      */     }
/*      */     catch (NumberFormatException ex)
/*      */     {
/* 1525 */       CError tError = new CError();
/* 1526 */       tError.moduleName = "LAComSchema";
/* 1527 */       tError.functionName = "decode";
/* 1528 */       tError.errorMessage = ex.toString();
/* 1529 */       this.mErrors.addOneError(tError);
/*      */ 
/* 1531 */       return false;
/*      */     }
/* 1533 */     return true;
/*      */   }
/*      */ 
/*      */   public String toString()
/*      */   {
/* 1538 */     return "Schema\u4E2D\u7684\u4FE1\u606FCRSInfoSchema [contNo=" + this.contNo + ", customerName=" + this.customerName + ", taxResidentType=" + 
/* 1539 */       this.taxResidentType + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", birthday=" + this.birthday + 
/* 1540 */       ", currentAddress_Country=" + this.currentAddress_Country + ", currentAddress_Province=" + 
/* 1541 */       this.currentAddress_Province + ", currentAddress_City=" + this.currentAddress_City + ", currentAddress_Detail=" + 
/* 1542 */       this.currentAddress_Detail + ", currentAddress_Country_en=" + this.currentAddress_Country_en + 
/* 1543 */       ", currentAddress_Province_en=" + this.currentAddress_Province_en + ", currentAddress_City_en=" + 
/* 1544 */       this.currentAddress_City_en + ", currentAddress_Detail_en=" + this.currentAddress_Detail_en + 
/* 1545 */       ", birthAddress_Country=" + this.birthAddress_Country + ", birthAddress_Province=" + this.birthAddress_Province + 
/* 1546 */       ", birthAddress_City=" + this.birthAddress_City + ", birthAddress_Detail=" + this.birthAddress_Detail + 
/* 1547 */       ", birthAddress_Country_en=" + this.birthAddress_Country_en + ", birthAddress_Province_en=" + 
/* 1548 */       this.birthAddress_Province_en + ", birthAddress_City_en=" + this.birthAddress_City_en + 
/* 1549 */       ", birthAddress_Detail_en=" + this.birthAddress_Detail_en + ", taxResidentCountry1=" + this.taxResidentCountry1 + 
/* 1550 */       ", taxpayerCode1=" + this.taxpayerCode1 + ", taxResidentCountry2=" + this.taxResidentCountry2 + 
/* 1551 */       ", taxpayerCode2=" + this.taxpayerCode2 + ", taxResidentCountry3=" + this.taxResidentCountry3 + 
/* 1552 */       ", taxpayerCode3=" + this.taxpayerCode3 + ", noTaxpayercodeReason=" + this.noTaxpayercodeReason + 
/* 1553 */       ", reasonDescription=" + this.reasonDescription + ", sourceType=" + this.sourceType + ", fDate=" + this.fDate + 
/* 1554 */       ", mErrors=" + this.mErrors + "]";
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.schema.CRSInfoSchema
 * JD-Core Version:    0.6.0
 */