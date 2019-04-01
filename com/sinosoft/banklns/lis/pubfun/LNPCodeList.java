/*     */ package com.sinosoft.banklns.lis.pubfun;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPCodeDB;
/*     */ import com.sinosoft.banklns.lis.schema.LNPCodeSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPCodeSet;
/*     */ import com.sinosoft.banklns.utility.ExeSQL;
/*     */ import com.sinosoft.banklns.utility.SSRS;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.faces.model.SelectItem;
/*     */ 
/*     */ public class LNPCodeList
/*     */ {
/*  17 */   private List<SelectItem> relationFamilyList = new ArrayList();
/*  18 */   private List<SelectItem> familyRelaItems = new ArrayList();
/*  19 */   private List<SelectItem> idTypeList = new ArrayList();
/*  20 */   private List<SelectItem> countryOrAreaList = new ArrayList();
/*  21 */   private List<SelectItem> degreesList = new ArrayList();
/*  22 */   private List<SelectItem> marriageList = new ArrayList();
/*  23 */   private List<SelectItem> customeTypeList = new ArrayList();
/*  24 */   private List<SelectItem> yearTypeList = new ArrayList();
/*  25 */   private List<SelectItem> montheList = new ArrayList();
/*  26 */   private List<SelectItem> dayList = new ArrayList();
/*  27 */   private List<SelectItem> sugNameList = new ArrayList();
/*  28 */   private List<SelectItem> sugPrintList = new ArrayList();
/*  29 */   private List<SelectItem> sugIntervalList = new ArrayList();
/*  30 */   private List<SelectItem> cityList = new ArrayList();
/*  31 */   private List<SelectItem> cityList0 = new ArrayList();
/*  32 */   private List<SelectItem> sexList = new ArrayList();
/*  33 */   private List<SelectItem> burialType = new ArrayList();
/*  34 */   private List<SelectItem> schoolType = new ArrayList();
/*  35 */   private List<SelectItem> loanNameList = new ArrayList();
/*  36 */   private List<SelectItem> hospitalStageList = new ArrayList();
/*  37 */   private List<SelectItem> hosRoomStageList = new ArrayList();
/*  38 */   private List<SelectItem> incomeDataList = new ArrayList();
/*  39 */   private List<SelectItem> investDataList = new ArrayList();
/*  40 */   private List<SelectItem> insuranceList = new ArrayList();
/*  41 */   private List<SelectItem> feeNameList = new ArrayList();
/*  42 */   private List<SelectItem> tfeeNameList = new ArrayList();
/*     */ 
/*  44 */   private List<SelectItem> payYearTypeList = new ArrayList();
/*     */ 
/*  46 */   private List<SelectItem> helpTypeName = new ArrayList();
/*     */ 
/*  48 */   private List<SelectItem> insuSexList = new ArrayList();
/*  49 */   private List<SelectItem> insuredidtypeList = new ArrayList();
/*  50 */   private List<SelectItem> idPerpetualList = new ArrayList();
/*  51 */   private List<SelectItem> insuCityList = new ArrayList();
/*  52 */   private List<SelectItem> countryareacodeList = new ArrayList();
/*  53 */   private List<SelectItem> contStatusList = new ArrayList();
/*     */ 
/*  55 */   private List<SelectItem> isAgreeList = new ArrayList();
/*     */ 
/*  57 */   private List<SelectItem> bonusAndPayTypeList = new ArrayList();
/*     */ 
/*  59 */   private List<SelectItem> marriagecodeList = new ArrayList();
/*     */ 
/*  65 */   private List<SelectItem> bnfRelationtoinsuredList = new ArrayList();
/*     */ 
/*  67 */   private List<SelectItem> appntRelationtoinsuredList = new ArrayList();
/*     */ 
/*  69 */   private List<SelectItem> lnpStateList = new ArrayList();
/*     */ 
/*     */   public List<SelectItem> getLnpStateList()
/*     */   {
/*  73 */     if (this.lnpStateList != null) {
/*  74 */       this.lnpStateList.clear();
/*     */     }
/*  76 */     this.lnpStateList = getNormalList("lnpState");
/*  77 */     return this.lnpStateList;
/*     */   }
/*     */ 
/*     */   public void setLnpStateList(List<SelectItem> lnpStateList)
/*     */   {
/*  82 */     this.lnpStateList = lnpStateList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getIsAgreeList()
/*     */   {
/*  87 */     if (this.isAgreeList != null) {
/*  88 */       this.isAgreeList.clear();
/*     */     }
/*  90 */     this.isAgreeList = getNormalList("isAgree");
/*  91 */     return this.isAgreeList;
/*     */   }
/*     */ 
/*     */   public void setIsAgreeList(List<SelectItem> isAgreeList) {
/*  95 */     this.isAgreeList = isAgreeList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getInsuCityList()
/*     */   {
/* 100 */     if (this.insuCityList != null) {
/* 101 */       this.insuCityList.clear();
/*     */     }
/* 103 */     this.insuCityList = getNormalList("insuCityType");
/* 104 */     return this.insuCityList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getAppntRelationtoinsuredList()
/*     */   {
/* 109 */     if (this.appntRelationtoinsuredList != null) {
/* 110 */       this.appntRelationtoinsuredList.clear();
/*     */     }
/* 112 */     this.appntRelationtoinsuredList = getNormalList("appntrelationtoinsured");
/*     */ 
/* 115 */     return this.appntRelationtoinsuredList;
/*     */   }
/*     */ 
/*     */   public void setAppntRelationtoinsuredList(List<SelectItem> appntRelationtoinsuredList)
/*     */   {
/* 122 */     this.appntRelationtoinsuredList = appntRelationtoinsuredList;
/*     */   }
/*     */ 
/*     */   public void setInsuCityList(List<SelectItem> insuCityList)
/*     */   {
/* 127 */     this.insuCityList = insuCityList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getBonusAndPayTypeList()
/*     */   {
/* 132 */     if (this.bonusAndPayTypeList != null) {
/* 133 */       this.bonusAndPayTypeList.clear();
/*     */     }
/* 135 */     this.bonusAndPayTypeList = getNormalList("bonusAndPayType");
/* 136 */     return this.bonusAndPayTypeList;
/*     */   }
/*     */ 
/*     */   public void setBonusAndPayTypeList(List<SelectItem> bonusAndPayTypeList)
/*     */   {
/* 141 */     this.bonusAndPayTypeList = bonusAndPayTypeList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getIdPerpetualList()
/*     */   {
/* 147 */     if (this.idPerpetualList != null) {
/* 148 */       this.idPerpetualList.clear();
/*     */     }
/* 150 */     this.idPerpetualList = getNormalList("idPerpetualType");
/* 151 */     return this.idPerpetualList;
/*     */   }
/*     */ 
/*     */   public void setIdPerpetualList(List<SelectItem> idPerpetualList)
/*     */   {
/* 156 */     this.idPerpetualList = idPerpetualList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getBnfRelationtoinsuredList()
/*     */   {
/* 161 */     if (this.bnfRelationtoinsuredList != null) {
/* 162 */       this.bnfRelationtoinsuredList.clear();
/*     */     }
/* 164 */     this.bnfRelationtoinsuredList = getNormalList("bnfrelationtoinsured");
/*     */ 
/* 166 */     return this.bnfRelationtoinsuredList;
/*     */   }
/*     */ 
/*     */   public void setBnfRelationtoinsuredList(List<SelectItem> bnfRelationtoinsuredList)
/*     */   {
/* 171 */     this.bnfRelationtoinsuredList = bnfRelationtoinsuredList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getInsuSexList()
/*     */   {
/* 199 */     if (this.insuSexList != null) {
/* 200 */       this.insuSexList.clear();
/*     */     }
/* 202 */     this.insuSexList = getNormalList("sex");
/*     */ 
/* 204 */     return this.insuSexList;
/*     */   }
/*     */ 
/*     */   public void setInsuSexList(List<SelectItem> insuSexList)
/*     */   {
/* 209 */     this.insuSexList = insuSexList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getContStatusList()
/*     */   {
/* 215 */     if (this.contStatusList != null) {
/* 216 */       this.contStatusList.clear();
/*     */     }
/* 218 */     this.contStatusList = getNormalList("contStatus");
/* 219 */     return this.contStatusList;
/*     */   }
/*     */ 
/*     */   public void setContStatusList(List<SelectItem> contStatusList)
/*     */   {
/* 224 */     this.contStatusList = contStatusList;
/*     */   }
/*     */ 
/*     */   private List<SelectItem> getNormalList(String typename)
/*     */   {
/* 229 */     List reList = new ArrayList();
/* 230 */     ExeSQL tExeSQL = new ExeSQL();
/* 231 */     String sql = "select code,codename from lnpcode where codetype='" + typename + "' order by code";
/* 232 */     SSRS tSRS = tExeSQL.execSQL(sql);
/* 233 */     for (int i = 1; i <= tSRS.MaxRow; i++) {
/* 234 */       reList.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*     */     }
/* 236 */     return reList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getCountryareacodeList()
/*     */   {
/* 241 */     if (this.countryareacodeList != null) {
/* 242 */       this.countryareacodeList.clear();
/*     */     }
/* 244 */     this.insuredidtypeList = new ArrayList();
/* 245 */     this.countryareacodeList = getNormalList("countryareacode");
/* 246 */     return this.countryareacodeList;
/*     */   }
/*     */ 
/*     */   public void setCountryareacodeList(List<SelectItem> countryareacodeList) {
/* 250 */     this.countryareacodeList = countryareacodeList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getInsuredidtypeList()
/*     */   {
/* 259 */     if (this.insuredidtypeList != null) {
/* 260 */       this.insuredidtypeList.clear();
/*     */     }
/* 262 */     this.insuredidtypeList = new ArrayList();
/* 263 */     this.insuredidtypeList = getNormalList("insuredidtype");
/* 264 */     return this.insuredidtypeList;
/*     */   }
/*     */   public void setInsuredidtypeList(List<SelectItem> insuredidtypeList) {
/* 267 */     this.insuredidtypeList = insuredidtypeList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getMarriagecodeList() {
/* 271 */     if (this.marriagecodeList != null) {
/* 272 */       this.marriagecodeList.clear();
/*     */     }
/* 274 */     this.marriagecodeList = new ArrayList();
/* 275 */     this.marriagecodeList = getNormalList("marriagecode");
/* 276 */     return this.marriagecodeList;
/*     */   }
/*     */ 
/*     */   public void setMarriagecodeList(List<SelectItem> marriagecodeList)
/*     */   {
/* 281 */     this.marriagecodeList = marriagecodeList;
/*     */   }
/*     */ 
/*     */   public void change()
/*     */   {
/* 299 */     System.out.println("data Changed");
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getLoanNameList()
/*     */   {
/* 322 */     this.loanNameList = new ArrayList();
/* 323 */     this.loanNameList.add(new SelectItem(new String("\u6C7D\u8F66\u8D37\u6B3E"), "\u6C7D\u8F66\u8D37\u6B3E"));
/* 324 */     this.loanNameList.add(new SelectItem(new String("\u4FE1\u7528\u8D37\u6B3E"), "\u4FE1\u7528\u8D37\u6B3E"));
/* 325 */     this.loanNameList.add(new SelectItem(new String("\u4E2A\u4EBA\u501F\u8D37"), "\u4E2A\u4EBA\u501F\u8D37"));
/* 326 */     this.loanNameList.add(new SelectItem(new String("\u5176\u4ED6\u81EA\u5B9A\u4E49"), "\u5176\u4ED6\u81EA\u5B9A\u4E49"));
/* 327 */     return this.loanNameList;
/*     */   }
/*     */ 
/*     */   public void setLoanNameList(List<SelectItem> LoanNameList) {
/* 331 */     this.loanNameList = LoanNameList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getSchoolType() {
/* 335 */     this.schoolType = new ArrayList();
/* 336 */     this.schoolType.add(new SelectItem(new String("c0"), "\u516C\u7ACB"));
/* 337 */     this.schoolType.add(new SelectItem(new String("c1"), "\u79C1\u7ACB"));
/* 338 */     this.schoolType.add(new SelectItem(new String("c2"), "\u5883\u5916"));
/* 339 */     return this.schoolType;
/*     */   }
/*     */ 
/*     */   public void setSchoolType(List<SelectItem> schoolType) {
/* 343 */     this.schoolType = schoolType;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getBurialType() {
/* 347 */     this.burialType = new ArrayList();
/* 348 */     this.burialType.add(new SelectItem(new String("f0"), ""));
/* 349 */     this.burialType.add(new SelectItem(new String("f1"), "1\u7EA7"));
/* 350 */     this.burialType.add(new SelectItem(new String("f2"), "2\u7EA7"));
/* 351 */     this.burialType.add(new SelectItem(new String("f3"), "3\u7EA7"));
/* 352 */     return this.burialType;
/*     */   }
/*     */ 
/*     */   public void setBurialType(List<SelectItem> burialType) {
/* 356 */     this.burialType = burialType;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getSexList() {
/* 360 */     this.sexList = new ArrayList();
/* 361 */     this.sexList.add(new SelectItem(new String("0"), "\u7537"));
/* 362 */     this.sexList.add(new SelectItem(new String("1"), "\u5973"));
/* 363 */     return this.sexList;
/*     */   }
/*     */ 
/*     */   public void setSexList(List<SelectItem> sexList) {
/* 367 */     this.sexList = sexList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getIdTypeList() {
/* 371 */     if (this.idTypeList.size() <= 0) {
/* 372 */       this.idTypeList = new ArrayList();
/* 373 */       ExeSQL tExeSQL = new ExeSQL();
/* 374 */       SSRS tSSRS = new SSRS();
/* 375 */       String sql = "select code,codename from ldcode where codetype='idtype' ";
/* 376 */       tSSRS = tExeSQL.execSQL(sql);
/* 377 */       for (int i = 1; i <= tSSRS.getMaxRow(); i++) {
/* 378 */         this.idTypeList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));
/*     */       }
/*     */     }
/* 381 */     return this.idTypeList;
/*     */   }
/*     */ 
/*     */   public void setIdTypeList(List<SelectItem> idTypeList) {
/* 385 */     this.idTypeList = idTypeList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getCountryOrAreaList() {
/* 389 */     if (this.countryOrAreaList.size() <= 0) {
/* 390 */       this.countryOrAreaList = new ArrayList();
/* 391 */       ExeSQL tExeSQL = new ExeSQL();
/* 392 */       SSRS tSSRS = new SSRS();
/* 393 */       String sql = "select code,codename from ldcode where codetype='countryareacode' ";
/* 394 */       tSSRS = tExeSQL.execSQL(sql);
/* 395 */       for (int i = 1; i <= tSSRS.getMaxRow(); i++) {
/* 396 */         this.countryOrAreaList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));
/*     */       }
/*     */     }
/* 399 */     return this.countryOrAreaList;
/*     */   }
/*     */ 
/*     */   public void setCountryOrAreaList(List<SelectItem> countryOrAreaList) {
/* 403 */     this.countryOrAreaList = countryOrAreaList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getMarriageList() {
/* 407 */     if (this.marriageList.size() <= 0) {
/* 408 */       this.marriageList = new ArrayList();
/* 409 */       ExeSQL tExeSQL = new ExeSQL();
/* 410 */       SSRS tSSRS = new SSRS();
/* 411 */       String sql = "select code,codename from ldcode where codetype='wedlock' ";
/* 412 */       tSSRS = tExeSQL.execSQL(sql);
/* 413 */       for (int i = 1; i <= tSSRS.getMaxRow(); i++) {
/* 414 */         this.marriageList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));
/*     */       }
/*     */     }
/* 417 */     return this.marriageList;
/*     */   }
/*     */ 
/*     */   public void setMarriageList(List<SelectItem> marriageList) {
/* 421 */     this.marriageList = marriageList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getCustomeTypeList() {
/* 425 */     if (this.customeTypeList.size() <= 0) {
/* 426 */       this.customeTypeList = new ArrayList();
/* 427 */       ExeSQL tExeSQL = new ExeSQL();
/* 428 */       SSRS tSSRS = new SSRS();
/* 429 */       String sql = "select code,codename from ldcode where codetype='customeType-old' ";
/* 430 */       tSSRS = tExeSQL.execSQL(sql);
/* 431 */       for (int i = 1; i <= tSSRS.getMaxRow(); i++) {
/* 432 */         this.customeTypeList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));
/*     */       }
/*     */     }
/* 435 */     return this.customeTypeList;
/*     */   }
/*     */ 
/*     */   public void setCustomeTypeList(List<SelectItem> customeTypeList) {
/* 439 */     this.customeTypeList = customeTypeList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getDegreesList() {
/* 443 */     if (this.degreesList.size() <= 0) {
/* 444 */       this.degreesList = new ArrayList();
/* 445 */       ExeSQL tExeSQL = new ExeSQL();
/* 446 */       SSRS tSSRS = new SSRS();
/* 447 */       String sql = "select code,codename from ldcode where codetype='degree' ";
/* 448 */       tSSRS = tExeSQL.execSQL(sql);
/* 449 */       for (int i = 1; i <= tSSRS.getMaxRow(); i++) {
/* 450 */         this.degreesList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));
/*     */       }
/*     */     }
/* 453 */     return this.degreesList;
/*     */   }
/*     */ 
/*     */   public void setDegreesList(List<SelectItem> degreesList) {
/* 457 */     this.degreesList = degreesList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getYearTypeList() {
/* 461 */     if (this.yearTypeList.size() <= 0) {
/* 462 */       this.yearTypeList = new ArrayList();
/* 463 */       for (int i = 1900; i <= 2020; i++) {
/* 464 */         this.yearTypeList.add(new SelectItem(String.valueOf(i), String.valueOf(i)));
/*     */       }
/*     */     }
/* 467 */     return this.yearTypeList;
/*     */   }
/*     */ 
/*     */   public void setYearTypeList(List<SelectItem> yearTypeList) {
/* 471 */     this.yearTypeList = yearTypeList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getMontheList() {
/* 475 */     if (this.montheList.size() <= 0) {
/* 476 */       this.montheList = new ArrayList();
/* 477 */       for (int j = 1; j <= 12; j++) {
/* 478 */         if (j >= 10)
/* 479 */           this.montheList.add(new SelectItem(String.valueOf(j), String.valueOf(j)));
/*     */         else {
/* 481 */           this.montheList.add(new SelectItem("0" + j, "0" + j));
/*     */         }
/*     */       }
/*     */     }
/* 485 */     return this.montheList;
/*     */   }
/*     */ 
/*     */   public void setMontheList(List<SelectItem> montheList) {
/* 489 */     this.montheList = montheList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getDayList() {
/* 493 */     if (this.dayList.size() <= 0) {
/* 494 */       this.dayList = new ArrayList();
/* 495 */       for (int j = 1; j <= 31; j++) {
/* 496 */         if (j >= 10)
/* 497 */           this.dayList.add(new SelectItem(String.valueOf(j), String.valueOf(j)));
/*     */         else {
/* 499 */           this.dayList.add(new SelectItem("0" + j, "0" + j));
/*     */         }
/*     */       }
/*     */     }
/* 503 */     return this.dayList;
/*     */   }
/*     */ 
/*     */   public void setDayList(List<SelectItem> dayList) {
/* 507 */     this.dayList = dayList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getSugNameList()
/*     */   {
/* 512 */     this.sugNameList = new ArrayList();
/* 513 */     LNPCodeDB reLNPCodeDB = new LNPCodeDB();
/* 514 */     reLNPCodeDB.setCodeType("suggestname");
/* 515 */     LNPCodeSet reLNPCodeSet = reLNPCodeDB.query();
/* 516 */     for (int i = 1; (reLNPCodeSet != null) && (i <= reLNPCodeSet.size()); i++) {
/* 517 */       LNPCodeSchema tempLNPCodeSchema = reLNPCodeSet.get(i);
/* 518 */       this.sugNameList.add(new SelectItem(tempLNPCodeSchema.getCodeAlias()));
/*     */     }
/* 520 */     return this.sugNameList;
/*     */   }
/*     */ 
/*     */   public void setSugNameList(List<SelectItem> sugNameList) {
/* 524 */     this.sugNameList = sugNameList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getSugPrintList() {
/* 528 */     this.sugPrintList = new ArrayList();
/* 529 */     ExeSQL tExeSQL = new ExeSQL();
/* 530 */     SSRS tSSRS = new SSRS();
/* 531 */     String sql = "select code,codename from ldcode where codetype='CoverPic' ";
/* 532 */     tSSRS = tExeSQL.execSQL(sql);
/* 533 */     for (int i = 1; i <= tSSRS.getMaxRow(); i++) {
/* 534 */       this.sugPrintList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));
/*     */     }
/* 536 */     return this.sugPrintList;
/*     */   }
/*     */ 
/*     */   public void setSugPrintList(List<SelectItem> sugPrintList) {
/* 540 */     this.sugPrintList = sugPrintList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getSugIntervalList() {
/* 544 */     this.sugIntervalList = new ArrayList();
/* 545 */     ExeSQL tExeSQL = new ExeSQL();
/* 546 */     SSRS tSSRS = new SSRS();
/* 547 */     String sql = "select code,codename from ldcode where codetype='printIntv' Order By codealias";
/* 548 */     tSSRS = tExeSQL.execSQL(sql);
/* 549 */     for (int i = 1; i <= tSSRS.getMaxRow(); i++) {
/* 550 */       this.sugIntervalList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));
/*     */     }
/* 552 */     return this.sugIntervalList;
/*     */   }
/*     */ 
/*     */   public void setSugIntervalList(List<SelectItem> sugIntervalList) {
/* 556 */     this.sugIntervalList = sugIntervalList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getCityList() {
/* 560 */     if (this.cityList.size() <= 0) {
/* 561 */       this.cityList = new ArrayList();
/* 562 */       ExeSQL tExeSQL = new ExeSQL();
/* 563 */       SSRS tSSRS = new SSRS();
/* 564 */       String sql = "select code,codename from ldcode where codetype='province' Order By code";
/* 565 */       tSSRS = tExeSQL.execSQL(sql);
/* 566 */       for (int i = 1; i <= tSSRS.getMaxRow(); i++) {
/* 567 */         this.cityList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));
/*     */       }
/*     */     }
/* 570 */     return this.cityList;
/*     */   }
/*     */ 
/*     */   public void setCityList(List<SelectItem> cityList) {
/* 574 */     this.cityList = cityList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getCityList0() {
/* 578 */     if (this.cityList0.size() <= 0) {
/* 579 */       this.cityList0 = new ArrayList();
/* 580 */       ExeSQL tExeSQL = new ExeSQL();
/* 581 */       SSRS tSSRS = new SSRS();
/* 582 */       String sql = "select code,codename from ldcode where codetype='province' Order By code";
/* 583 */       tSSRS = tExeSQL.execSQL(sql);
/* 584 */       for (int i = 1; i <= tSSRS.getMaxRow(); i++) {
/* 585 */         this.cityList0.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));
/*     */       }
/*     */     }
/* 588 */     return this.cityList0;
/*     */   }
/*     */ 
/*     */   public void setCityList0(List<SelectItem> cityList) {
/* 592 */     this.cityList0 = cityList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getFamilyRelaItems() {
/* 596 */     if (this.familyRelaItems.size() <= 0) {
/* 597 */       this.familyRelaItems = new ArrayList();
/* 598 */       ExeSQL tExeSQL = new ExeSQL();
/* 599 */       SSRS tSSRS = new SSRS();
/* 600 */       String sql = "select code,codename from ldcode where codetype='relation' Order By code";
/* 601 */       tSSRS = tExeSQL.execSQL(sql);
/* 602 */       for (int i = 1; i <= tSSRS.getMaxRow(); i++) {
/* 603 */         this.familyRelaItems.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));
/*     */       }
/*     */     }
/* 606 */     return this.familyRelaItems;
/*     */   }
/*     */ 
/*     */   public void setFamilyRelaItems(List<SelectItem> familyRelaItems) {
/* 610 */     this.familyRelaItems = familyRelaItems;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getFeeNameList() {
/* 614 */     this.feeNameList = new ArrayList();
/* 615 */     this.feeNameList.add(new SelectItem(new String("\u65C5\u6E38\u8D39\u7528"), "\u65C5\u6E38\u8D39\u7528"));
/* 616 */     this.feeNameList.add(new SelectItem(new String("\u7ED3\u5A5A\u8D39\u7528"), "\u7ED3\u5A5A\u8D39\u7528"));
/* 617 */     this.feeNameList.add(new SelectItem(new String("\u4FDD\u9669\u8D39"), "\u4FDD\u9669\u8D39"));
/* 618 */     this.feeNameList.add(new SelectItem(new String("\u5176\u4ED6\u81EA\u5B9A\u4E49"), "\u5176\u4ED6\u81EA\u5B9A\u4E49"));
/* 619 */     return this.feeNameList;
/*     */   }
/*     */ 
/*     */   public void setFeeNameList(List<SelectItem> feeNameList) {
/* 623 */     this.feeNameList = feeNameList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getHospitalStageList() {
/* 627 */     this.hospitalStageList = new ArrayList();
/* 628 */     this.hospitalStageList.add(new SelectItem("h0", "\u4E09\u7EA7\u7532\u7B49"));
/* 629 */     this.hospitalStageList.add(new SelectItem("h1", "\u4E09\u7EA7\u4E59\u7B49"));
/* 630 */     this.hospitalStageList.add(new SelectItem("h2", "\u4E8C\u7EA7\u7532\u7B49"));
/* 631 */     this.hospitalStageList.add(new SelectItem("h3", "\u4E8C\u7EA7\u4E59\u7B49"));
/* 632 */     return this.hospitalStageList;
/*     */   }
/*     */ 
/*     */   public void setHospitalStageList(List<SelectItem> hospitalStageList) {
/* 636 */     this.hospitalStageList = hospitalStageList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getHosRoomStageList() {
/* 640 */     this.hosRoomStageList = new ArrayList();
/* 641 */     this.hosRoomStageList.add(new SelectItem("h0", "\u5355\u4EBA\u95F4"));
/* 642 */     this.hosRoomStageList.add(new SelectItem("h1", "\u591A\u4EBA\u95F4"));
/* 643 */     return this.hosRoomStageList;
/*     */   }
/*     */ 
/*     */   public void setHosRoomStageList(List<SelectItem> hosRoomStageList) {
/* 647 */     this.hosRoomStageList = hosRoomStageList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getRelationFamilyList() {
/* 651 */     if (this.relationFamilyList.size() <= 0) {
/* 652 */       this.relationFamilyList = new ArrayList();
/* 653 */       ExeSQL tExeSQL = new ExeSQL();
/* 654 */       SSRS tSSRS = new SSRS();
/* 655 */       String sql = "select code,codename from ldcode where codetype='relationFamily' Order By comcode";
/* 656 */       tSSRS = tExeSQL.execSQL(sql);
/* 657 */       for (int i = 1; i <= tSSRS.getMaxRow(); i++) {
/* 658 */         this.relationFamilyList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));
/*     */       }
/*     */     }
/* 661 */     return this.relationFamilyList;
/*     */   }
/*     */ 
/*     */   public void setRelationFamilyList(List<SelectItem> relationFamilyList) {
/* 665 */     this.relationFamilyList = relationFamilyList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getIncomeDataList() {
/* 669 */     this.incomeDataList = new ArrayList();
/* 670 */     this.incomeDataList.add(new SelectItem(new String("\u79DF\u623F\u6536\u5165"), "\u79DF\u623F\u6536\u5165"));
/* 671 */     this.incomeDataList.add(new SelectItem(new String("\u5B50\u5973\u5949\u517B\u91D1"), "\u5B50\u5973\u5949\u517B\u91D1"));
/* 672 */     this.incomeDataList.add(new SelectItem(new String("\u5176\u4ED6\u81EA\u5B9A\u4E49"), "\u5176\u4ED6\u81EA\u5B9A\u4E49"));
/* 673 */     return this.incomeDataList;
/*     */   }
/*     */ 
/*     */   public void setIncomeDataList(List<SelectItem> incomeDataList) {
/* 677 */     this.incomeDataList = incomeDataList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getInvestDataList() {
/* 681 */     this.investDataList = new ArrayList();
/* 682 */     this.investDataList.add(new SelectItem(new String("\u50A8\u84C4"), "\u50A8\u84C4"));
/* 683 */     this.investDataList.add(new SelectItem(new String("\u6295\u8D44\u6027\u623F\u5730\u4EA7"), "\u6295\u8D44\u6027\u623F\u5730\u4EA7"));
/* 684 */     this.investDataList.add(new SelectItem(new String("\u80A1\u7968"), "\u80A1\u7968"));
/* 685 */     this.investDataList.add(new SelectItem(new String("\u57FA\u91D1"), "\u57FA\u91D1"));
/* 686 */     this.investDataList.add(new SelectItem(new String("\u5176\u4ED6\u81EA\u5B9A\u4E49"), "\u5176\u4ED6\u81EA\u5B9A\u4E49"));
/* 687 */     return this.investDataList;
/*     */   }
/*     */ 
/*     */   public void setInvestDataList(List<SelectItem> investDataList) {
/* 691 */     this.investDataList = investDataList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getInsuranceList() {
/* 695 */     this.insuranceList = new ArrayList();
/* 696 */     this.insuranceList.add(new SelectItem(new String("0"), "\u7EC8\u8EAB"));
/* 697 */     this.insuranceList.add(new SelectItem(new String("1"), "\u517B\u8001"));
/* 698 */     this.insuranceList.add(new SelectItem(new String("2"), "\u5B9A\u671F"));
/* 699 */     return this.insuranceList;
/*     */   }
/*     */ 
/*     */   public void setInsuranceList(List<SelectItem> insuranceList) {
/* 703 */     this.insuranceList = insuranceList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getTfeeNameList() {
/* 707 */     this.tfeeNameList = new ArrayList();
/* 708 */     this.tfeeNameList.add(new SelectItem(new String("\u9057\u4EA7\u5904\u7F6E"), "\u9057\u4EA7\u5904\u7F6E"));
/* 709 */     this.tfeeNameList.add(new SelectItem(new String("\u62A4\u7406\u8D39\u7528"), "\u62A4\u7406\u8D39\u7528"));
/* 710 */     this.tfeeNameList.add(new SelectItem(new String("\u533B\u7597\u8D39\u7528"), "\u533B\u7597\u8D39\u7528"));
/* 711 */     this.tfeeNameList.add(new SelectItem(new String("\u65C5\u6E38\u8D39\u7528"), "\u65C5\u6E38\u8D39\u7528"));
/* 712 */     this.tfeeNameList.add(new SelectItem(new String("\u5176\u4ED6\u81EA\u5B9A\u4E49"), "\u5176\u4ED6\u81EA\u5B9A\u4E49"));
/* 713 */     return this.tfeeNameList;
/*     */   }
/*     */   public void setTfeeNameList(List<SelectItem> tfeeNameList) {
/* 716 */     this.tfeeNameList = tfeeNameList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getPayYearTypeList() {
/* 720 */     this.payYearTypeList = new ArrayList();
/* 721 */     this.payYearTypeList.add(new SelectItem(new String("a"), "\u4EA4\u8D39\u5E74\u671F (\u5E74)"));
/* 722 */     this.payYearTypeList.add(new SelectItem(new String("b"), "\u7F34\u81F3\u5E74\u9F84 (\u5C81)"));
/* 723 */     return this.payYearTypeList;
/*     */   }
/*     */ 
/*     */   public void setPayYearTypeList(List<SelectItem> payYearTypeList) {
/* 727 */     this.payYearTypeList = payYearTypeList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getHelpTypeName() {
/* 731 */     this.helpTypeName = new ArrayList();
/* 732 */     this.helpTypeName.add(new SelectItem(new String(""), ""));
/* 733 */     ExeSQL tExeSQL = new ExeSQL();
/* 734 */     SSRS tSSRS = new SSRS();
/* 735 */     String sql = "select distinct helpType from fnahelppara";
/* 736 */     tSSRS = tExeSQL.execSQL(sql);
/* 737 */     for (int i = 1; i <= tSSRS.getMaxRow(); i++) {
/* 738 */       this.helpTypeName.add(new SelectItem(new String(tSSRS.GetText(i, 1)), tSSRS.GetText(i, 1)));
/*     */     }
/* 740 */     return this.helpTypeName;
/*     */   }
/*     */ 
/*     */   public void setHelpTypeName(List<SelectItem> helpTypeName) {
/* 744 */     this.helpTypeName = helpTypeName;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.pubfun.LNPCodeList
 * JD-Core Version:    0.6.0
 */