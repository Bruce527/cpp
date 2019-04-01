/*     */ package com.sinosoft.banklns.lnsmodel.interfaces;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPAddressDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPAppntDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPContDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPInsuredDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPPolDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPRiskAmountDB;
/*     */ import com.sinosoft.banklns.lis.pubfun.MMap;
/*     */ import com.sinosoft.banklns.lis.pubfun.SysMaxNoMAPNP;
/*     */ import com.sinosoft.banklns.lis.schema.LNPAddressSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPAppntSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPInsuredSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPPolSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPRiskAmountSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPAddressSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPAppntSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPInsuredSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPPolSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPRiskAmountSet;
/*     */ import com.sinosoft.banklns.utility.ExeSQL;
/*     */ import com.sinosoft.banklns.utility.SSRS;
/*     */ import java.io.PrintStream;
/*     */ import java.util.List;
/*     */ import org.jdom.Element;
/*     */ import org.jdom.Namespace;
/*     */ 
/*     */ public class CalPrem extends PublicInterfaces
/*     */ {
/*  31 */   private LNPContSchema tLNPContSchema = null;
/*     */ 
/*  34 */   private LNPPolSet tLNPPolSet = null;
/*     */ 
/*  37 */   private LNPAppntSet tLNPAppntSet = null;
/*     */ 
/*  39 */   private LNPAddressSet tLnpAddressSet = null;
/*     */ 
/*  42 */   private LNPInsuredSet tLNPInsuredSet = null;
/*     */ 
/*  45 */   private boolean flag = false;
/*     */ 
/*  47 */   private String rnewflag = "";
/*     */   private String userName;
/*     */   private String password;
/*     */ 
/*     */   protected void initObject()
/*     */   {
/*  55 */     this.modelFileName = "prem_in.xml";
/*  56 */     this.sendFileName = "prem_in";
/*  57 */     this.returnFileName = "prem_out";
/*  58 */     this.defaultErrorMessage = "\u4FDD\u8D39\u8BA1\u7B97\u5931\u8D25\uFF01";
/*     */ 
/*  63 */     super.initObject();
/*     */   }
/*     */ 
/*     */   protected boolean dealReturn()
/*     */   {
/*     */     try
/*     */     {
/*  72 */       LNPPolSet bakLnpPolSet = new LNPPolSet();
/*  73 */       bakLnpPolSet.set(this.tLNPPolSet);
/*     */ 
/*  75 */       LNPContSchema bakSchema = new LNPContSchema();
/*  76 */       bakSchema.setSchema(this.tLNPContSchema);
/*     */ 
/*  79 */       Element returnN = getReturnBody();
/*     */ 
/*  85 */       Namespace err = Namespace.getNamespace("http://www.csc.smart/bo/schemas/Error");
/*  86 */       Element errorN = returnN.getChild("ERROR", err);
/*  87 */       if (errorN != null) {
/*  88 */         System.out.println("EAI\u8C03\u7528LA\u6210\u529F\uFF0C\u4F46\u8FD4\u56DE\u4E86\u9519\u8BEF\uFF01");
/*  89 */         Element statusN = errorN.getChild("STATUS", err);
/*  90 */         Element reason = errorN.getChild("REASON", err);
/*  91 */         String valiReason = reason.getChild("ERROR_DESC", err).getText();
/*  92 */         this.message += valiReason;
/*  93 */         System.out.println("ERROR_DESC==" + this.message);
/*     */ 
/*  95 */         return false;
/*     */       }
/*     */ 
/* 105 */       Element premiumN = returnN.getChild("PREMIUM");
/* 106 */       if (premiumN == null) {
/* 107 */         System.out.println("*************************SOAP ERROR************MSP\u63A5\u53E3PRMService\u8C03\u7528\u51FA\u9519\uFF01");
/* 108 */         return false;
/*     */       }
/* 110 */       System.out.println("--PREMIUM --" + premiumN.getName());
/*     */ 
/* 115 */       if ("0".equals(getValueInXML(premiumN, "ERRCODE"))) {
/* 116 */         setModifyTime(this.tLNPContSchema);
/* 117 */         this.tLNPContSchema.setPrem(0.0D);
/* 118 */         this.tLNPContSchema.setSumPrem(0.0D);
/*     */ 
/* 121 */         String premstring = getValueInXML(premiumN, "TOTAL");
/* 122 */         if ((premstring != null) && (!"".equals(premstring))) {
/* 123 */           this.tLNPContSchema.setPrem(premstring);
/* 124 */           this.tLNPContSchema.setSumPrem(premstring);
/*     */         }
/*     */ 
/* 129 */         LNPPolSet mLNPPolSet = new LNPPolDB(this.con).executeQuery("select * from lnppol where contno='" + this.tContNo + "' and RiskVersion is not null and RiskVersion<>''");
/*     */ 
/* 131 */         LNPPolSchema tPolSchema = new LNPPolSchema();
/*     */ 
/* 139 */         LNPPolSet zLNPPolSet = new LNPPolSet();
/*     */ 
/* 143 */         Element insuredList = premiumN.getChild("INSUREDLIST");
/* 144 */         Element insured = insuredList.getChild("INSURED");
/*     */ 
/* 146 */         List insrskamntItemN = insured.getChildren("INSRSKAMNT");
/* 147 */         System.out.println(insrskamntItemN);
/* 148 */         LNPRiskAmountSet riskAmountSet = new LNPRiskAmountSet();
/* 149 */         LNPRiskAmountSet bakRiskAmountSet = new LNPRiskAmountDB(this.con).executeQuery("select * from LNPRiskAmount where contno='" + this.tLNPContSchema.getContNo() + "'");
/* 150 */         for (Element e : insrskamntItemN) {
/* 151 */           LNPRiskAmountSchema tSchema = new LNPRiskAmountSchema();
/*     */ 
/* 153 */           String ZNRSKCD02 = getValueInXML(e, "ZNRSKCD02");
/* 154 */           if ("".equals(ZNRSKCD02))
/*     */           {
/*     */             continue;
/*     */           }
/* 158 */           tSchema.setcontno(this.tLNPContSchema.getContNo());
/* 159 */           tSchema.setftype(getValueInXML(e, "ZNRSKCD02"));
/* 160 */           tSchema.setfamnt(getValueInXML(e, "SUMINS02"));
/* 161 */           setSaveTime(tSchema);
/* 162 */           riskAmountSet.add(tSchema);
/*     */         }
/*     */ 
/* 165 */         List coverages = insured.getChild("COVERAGELIST").getChildren();
/* 166 */         System.out.println("----------------coverage.size=" + coverages.size());
/* 167 */         System.out.println(coverages);
/* 168 */         if (this.flag) {
/* 169 */           SysMaxNoMAPNP MaxNoMap = new SysMaxNoMAPNP();
/* 170 */           for (int j = 0; j < coverages.size(); j++) {
/* 171 */             Element tmpb = (Element)coverages.get(j);
/* 172 */             LNPPolSchema tSchema = new LNPPolSchema();
/*     */ 
/* 174 */             if ((j == 0) && (("1".equals(mLNPPolSet.get(j + 1).getRnewFlag())) || ("2".equals(mLNPPolSet.get(j + 1).getRnewFlag()))))
/*     */             {
/* 176 */               tPolSchema = mLNPPolSet.get(j + 1);
/*     */             }
/* 178 */             else if (("1".equals(mLNPPolSet.get(j).getRnewFlag())) || ("2".equals(mLNPPolSet.get(j).getRnewFlag()))) {
/* 179 */               tPolSchema = mLNPPolSet.get(j);
/*     */             }
/*     */ 
/* 182 */             tSchema.setSchema(tPolSchema);
/* 183 */             setSaveTime(tSchema);
/* 184 */             if ("00".equals(getValueInXML(tmpb, "RIDER"))) {
/* 185 */               tSchema.setRnewFlag(this.rnewflag);
/* 186 */               tSchema.setSubFlag("M");
/*     */             } else {
/* 188 */               tSchema.setRnewFlag("");
/* 189 */               tSchema.setSubFlag("S");
/*     */             }
/* 191 */             tSchema.setPolNo(MaxNoMap.CreateMaxNo("CustomerNo", ""));
/*     */ 
/* 193 */             tSchema.setRiskCode(getValueInXML(tmpb, "ZNPRDCODE"));
/*     */ 
/* 195 */             tSchema.setAmnt(getValueInXML(tmpb, "SUMIN"));
/*     */ 
/* 197 */             tSchema.setSumPrem(this.tLNPContSchema.getSumPrem());
/*     */ 
/* 199 */             tSchema.setPrem(getValueInXML(tmpb, "INSTPRM"));
/* 200 */             tSchema.setManageFeeRate(getValueInXML(tmpb, "INSTPRM"));
/*     */ 
/* 203 */             if ((turnNullToString(tSchema.getPayMode()).equals("")) || (Integer.parseInt(tSchema.getPayMode()) <= 0) || (
/* 204 */               (turnNullToString(tSchema.getPayMode()).equals("1000")) && (!"1".equals(turnNullToString(getValueInXML(tmpb, "PCESSTRM")))) && (!"0".equals(turnNullToString(getValueInXML(tmpb, "PCESSTRM")))))) {
/* 205 */               if (!turnNullToString(getValueInXML(tmpb, "PCESSAGE")).equals("")) {
/* 206 */                 tSchema.setPayMode(turnNullToString(getValueInXML(tmpb, "PCESSAGE")));
/* 207 */                 tSchema.setAcciYearFlag("A");
/*     */               } else {
/* 209 */                 tSchema.setPayMode(turnNullToString(getValueInXML(tmpb, "PCESSTRM")));
/* 210 */                 tSchema.setAcciYearFlag("Y");
/*     */               }
/*     */ 
/*     */             }
/*     */ 
/* 216 */             if (!turnNullToString(getValueInXML(tmpb, "RCESSAGE")).equals("")) {
/* 217 */               tSchema.setPayLocation(turnNullToString(getValueInXML(tmpb, "RCESSAGE")));
/* 218 */               tSchema.setPremToAmnt("A");
/* 219 */             } else if (!turnNullToString(getValueInXML(tmpb, "RCESSTRM")).equals("")) {
/* 220 */               tSchema.setPayLocation(turnNullToString(getValueInXML(tmpb, "RCESSTRM")));
/* 221 */               tSchema.setPremToAmnt("Y");
/*     */             }
/*     */ 
/* 224 */             zLNPPolSet.add(tSchema);
/*     */           }
/*     */         } else {
/* 227 */           for (int j = 0; j < coverages.size(); j++)
/*     */           {
/* 231 */             Element tmpb = (Element)coverages.get(j);
/*     */ 
/* 233 */             LNPPolSchema pol = null;
/*     */ 
/* 253 */             for (int h = 0; h < this.tLNPPolSet.size(); h++) {
/* 254 */               if ((!this.tLNPPolSet.get(h + 1).getRiskCode().equals(getValueInXML(tmpb, "ZNPRDCODE"))) || 
/* 255 */                 (!this.tLNPPolSet.get(h + 1).getHandler().equals(getValueInXML(tmpb, "RIDER")))) continue;
/* 256 */               pol = this.tLNPPolSet.get(h + 1);
/* 257 */               break;
/*     */             }
/*     */ 
/* 260 */             if (pol != null) {
/* 261 */               setSaveTime(pol);
/*     */ 
/* 263 */               pol.setAmnt(getValueInXML(tmpb, "SUMIN"));
/*     */ 
/* 265 */               pol.setSumPrem(fomartNum(this.tLNPContSchema.getSumPrem()));
/*     */ 
/* 267 */               pol.setPrem(getValueInXML(tmpb, "INSTPRM"));
/* 268 */               pol.setManageFeeRate(getValueInXML(tmpb, "INSTPRM"));
/*     */ 
/* 271 */               if ((pol.getPayEndYear() <= 0) || ((pol.getPayEndYear() == 1000) && (!"1".equals(turnNullToString(getValueInXML(tmpb, "PCESSTRM")))) && (!"0".equals(turnNullToString(getValueInXML(tmpb, "PCESSTRM")))))) {
/* 272 */                 if (!turnNullToString(getValueInXML(tmpb, "PCESSAGE")).equals("")) {
/* 273 */                   pol.setPayEndYear(turnNullToString(getValueInXML(tmpb, "PCESSAGE")));
/* 274 */                   pol.setPayEndYearFlag("A");
/*     */                 } else {
/* 276 */                   pol.setPayEndYear(turnNullToString(getValueInXML(tmpb, "PCESSTRM")));
/* 277 */                   pol.setPayEndYearFlag("Y");
/*     */                 }
/*     */               }
/*     */ 
/* 281 */               if (pol.getInsuYear() <= 0) {
/* 282 */                 if (!turnNullToString(getValueInXML(tmpb, "RCESSAGE")).equals("")) {
/* 283 */                   pol.setInsuYear(turnNullToString(getValueInXML(tmpb, "RCESSAGE")));
/* 284 */                   pol.setInsuYearFlag("A");
/*     */                 } else {
/* 286 */                   pol.setInsuYear(turnNullToString(getValueInXML(tmpb, "RCESSTRM")));
/* 287 */                   pol.setInsuYearFlag("Y");
/*     */                 }
/*     */ 
/*     */               }
/*     */ 
/*     */             }
/*     */ 
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/* 298 */         if (this.flag) {
/* 299 */           this.bakMap.put(mLNPPolSet, "DELETE");
/* 300 */           this.bakMap.put(zLNPPolSet, "DELETE");
/* 301 */           this.bakMap.put(tPolSchema, "DELETE&INSERT");
/* 302 */           this.map.put(mLNPPolSet, "DELETE");
/* 303 */           this.map.put(zLNPPolSet, "INSERT");
/*     */         } else {
/* 305 */           this.bakMap.put(bakLnpPolSet, "UPDATE"); this.map.put(this.tLNPPolSet, "UPDATE");
/*     */         }
/* 307 */         this.bakMap.put(riskAmountSet, "DELETE"); this.bakMap.put(bakRiskAmountSet, "DELETE&INSERT"); this.map.put(riskAmountSet, "DELETE&INSERT");
/* 308 */         this.bakMap.put(bakSchema, "UPDATE"); this.map.put(this.tLNPContSchema, "UPDATE");
/* 309 */         return true;
/*     */       }
/* 311 */       this.message = getValueInXML(premiumN, "PDESC");
/* 312 */       return false;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 326 */       e.printStackTrace();
/*     */     }
/* 328 */     return false;
/*     */   }
/*     */ 
/*     */   protected boolean dealSend()
/*     */   {
/*     */     try
/*     */     {
/* 336 */       Element msgBody = getSendBody();
/* 337 */       String company = mappingCode(this.tLNPContSchema.getManageCom(), "BankSigned");
/*     */ 
/* 341 */       Namespace msp = Namespace.getNamespace("http://www.csc.smart/msp/schemas/MSPContext");
/*     */ 
/* 343 */       List msgList = msgBody.getChildren();
/* 344 */       Element mspContent = (Element)msgList.get(0);
/*     */ 
/* 346 */       Element userId = mspContent.getChild("UserId", msp);
/* 347 */       userId.setText(this.userName);
/* 348 */       Element uerPassword = mspContent.getChild("UserPassword", msp);
/* 349 */       uerPassword.setText(this.password);
/* 350 */       Element reqps = mspContent.getChild("RequestParameters", msp);
/* 351 */       Element requestParameter = reqps.getChild("RequestParameter", msp);
/* 352 */       requestParameter.setAttribute("name", "BRANCH").setAttribute("value", company);
/*     */ 
/* 366 */       Element premium = msgBody.getChild("PREMIUM");
/* 367 */       updateText(premium, "ZNBAKFLD", "");
/* 368 */       updateText(premium, "CNTBRANCH", company);
/* 369 */       updateText(premium, "TTMPRCNO", this.tLNPContSchema.getContNo());
/* 370 */       updateText(premium, "CHDRTYPE", "");
/* 371 */       updateText(premium, "OCCDATE", fomartDate(this.tLNPContSchema.getPValiDate()));
/*     */ 
/* 374 */       Element policyOwner = premium.getChild("POLICYOWNER");
/* 375 */       updateText(policyOwner, "OWNERSEL", this.tLNPContSchema.getAppntNo());
/* 376 */       updateText(policyOwner, "DOB", fomartDate(this.tLNPAppntSet.get(1).getAppntBirthday()));
/* 377 */       updateText(policyOwner, "AGE", turnNullToString(Integer.valueOf(this.tLNPAppntSet.get(1).getAppntAge())));
/* 378 */       updateText(policyOwner, "CLTSEX", mappingCode(this.tLNPAppntSet.get(1).getAppntSex(), "BankPolicySex"));
/* 379 */       updateText(policyOwner, "OCCUP", this.tLNPAppntSet.get(1).getOccupationCode());
/*     */ 
/* 382 */       LNPPolSet tset = new LNPPolDB().executeQuery("select * from lnppol where contno='" + this.tContNo + "' and RiskVersion is not null and RiskVersion<>'' and RnewFlag in('1','2')");
/*     */ 
/* 384 */       if (tset.size() > 0) {
/* 385 */         this.flag = true;
/* 386 */         this.rnewflag = tset.get(1).getRnewFlag();
/* 387 */         updateText(premium, "BILLFREQ", mappingCode(turnNullToString(Integer.valueOf(tset.get(1).getPayIntv())), "BankFrequency"));
/*     */       } else {
/* 389 */         updateText(premium, "BILLFREQ", mappingCode(turnNullToString(Integer.valueOf(this.tLNPPolSet.get(1).getPayIntv())), "BankFrequency"));
/*     */       }
/* 391 */       updateText(premium, "SRCEBUS", "3");
/* 392 */       if ((tset.size() > 0) && ("2".equals(tset.get(1).getRnewFlag()))) {
/* 393 */         updateText(premium, "SRCEBUS", turnToCode(tset.get(1).getUWTime()));
/*     */       }
/* 395 */       updateText(premium, "CNTCURR", "CNY");
/* 396 */       updateText(premium, "BILLCURR", "CNY");
/*     */ 
/* 399 */       Element insured = premium.getChild("INSUREDLIST").getChild("INSURED");
/* 400 */       updateText(insured, "Life", "01");
/* 401 */       updateText(insured, "LIFCNUM", this.tLNPContSchema.getInsuredNo());
/* 402 */       updateText(insured, "CLTDOB", fomartDate(this.tLNPInsuredSet.get(1).getBirthday()));
/* 403 */       updateText(insured, "INSAGE", turnNullToString(Integer.valueOf(this.tLNPInsuredSet.get(1).getAppAge())));
/* 404 */       updateText(insured, "SEX", mappingCode(this.tLNPInsuredSet.get(1).getSex(), "BankPolicySex"));
/* 405 */       updateText(insured, "OCCUPD", this.tLNPInsuredSet.get(1).getOccupationCode());
/*     */ 
/* 461 */       if (this.flag)
/*     */       {
/* 463 */         Element packageInfo = insured.getChild("PACKAGEINFO");
/* 464 */         updateText(packageInfo, "ZNPKGCODE", turnNullToString(tset.get(1).getRiskVersion()));
/*     */ 
/* 466 */         updateText(packageInfo, "TOTPRE", turnNullToString(tset.get(1).getRemark()));
/*     */ 
/* 468 */         updateText(packageInfo, "ZTOTSI", "0");
/*     */ 
/* 471 */         Element coverage = insured.getChild("COVERAGELIST");
/* 472 */         Element acoverage = coverage.getChild("COVERAGEINFO");
/*     */ 
/* 476 */         if (tset.size() > 1)
/*     */         {
/* 478 */           coverage.removeContent();
/* 479 */           for (int i = 0; i < 2; i++)
/*     */           {
/* 481 */             Element tempCoverage = (Element)acoverage.clone();
/* 482 */             updateText(tempCoverage, "COVERAGE", "");
/* 483 */             updateText(tempCoverage, "CCDATE", "0");
/* 484 */             updateText(tempCoverage, "RIDER", "");
/* 485 */             updateText(tempCoverage, "ZNPRDCODE", "");
/* 486 */             updateText(tempCoverage, "SUMIN", "0");
/* 487 */             updateText(tempCoverage, "ZNDISPER", "0");
/* 488 */             updateText(tempCoverage, "ZNRFAGE", "0");
/* 489 */             updateText(tempCoverage, "RCESSAGE", "0");
/* 490 */             updateText(tempCoverage, "RCESSTRM", "0");
/* 491 */             updateText(tempCoverage, "INSTPRM", "0");
/*     */ 
/* 493 */             updateText(tempCoverage, "JLSEX", "");
/* 494 */             updateText(tempCoverage, "ZNJLAGE", "0");
/* 495 */             updateText(tempCoverage, "BENPLN", "");
/* 496 */             updateText(tempCoverage, "LIVESNO", "");
/* 497 */             coverage.addContent(tempCoverage);
/*     */           }
/*     */ 
/* 500 */           int i = 2; for (int j = 2; i <= tset.size(); i++) {
/* 501 */             Element tempCoverage = (Element)acoverage.clone();
/* 502 */             LNPPolSchema tempPol = tset.get(i);
/* 503 */             updateText(tempCoverage, "COVERAGE", "01");
/* 504 */             updateText(tempCoverage, "CCDATE", fomartDate(this.tLNPContSchema.getPValiDate()));
/*     */ 
/* 506 */             String tRiskIdx = null;
/* 507 */             if ("M".equalsIgnoreCase(tempPol.getSubFlag())) {
/* 508 */               tRiskIdx = "0" + j++;
/* 509 */               updateText(tempCoverage, "RIDER", tRiskIdx);
/*     */             }
/* 511 */             tempPol.setHandler(tRiskIdx);
/*     */ 
/* 513 */             updateText(tempCoverage, "ZNPRDCODE", tempPol.getRiskVersion());
/* 514 */             updateText(tempCoverage, "SUMIN", turnNullToString(Integer.valueOf((int)tempPol.getAmnt())));
/* 515 */             updateText(tempCoverage, "ZNDISPER", "1");
/* 516 */             updateText(tempCoverage, "ZNRFAGE", turnNullToString(Integer.valueOf(tempPol.getGetYear())));
/* 517 */             if ("A".equals(tempPol.getInsuYearFlag()))
/* 518 */               updateText(tempCoverage, "RCESSAGE", turnNullToString(Integer.valueOf(tempPol.getInsuYear())));
/*     */             else {
/* 520 */               updateText(tempCoverage, "RCESSTRM", turnNullToString(Integer.valueOf(tempPol.getInsuYear())));
/*     */             }
/* 522 */             if ("A".equals(tempPol.getPayEndYearFlag()))
/* 523 */               updateText(tempCoverage, "PCESSAGE", turnNullToString(Integer.valueOf(tempPol.getPayEndYear())));
/*     */             else {
/* 525 */               updateText(tempCoverage, "PCESSTRM", "1000".equals(turnNullToString(Integer.valueOf(tempPol.getPayEndYear()))) ? "1" : turnNullToString(Integer.valueOf(tempPol.getPayEndYear())));
/*     */             }
/* 527 */             updateText(tempCoverage, "INSTPRM", turnNullToString(fomartNum(tempPol.getPrem())));
/*     */ 
/* 530 */             updateText(tempCoverage, "JLSEX", "");
/* 531 */             updateText(tempCoverage, "ZNJLAGE", "0");
/* 532 */             updateText(tempCoverage, "BENPLN", "");
/* 533 */             updateText(tempCoverage, "LIVESNO", "");
/* 534 */             coverage.addContent(tempCoverage);
/*     */           }
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 540 */         Element coverage = insured.getChild("COVERAGELIST");
/* 541 */         Element acoverage = coverage.getChild("COVERAGEINFO");
/* 542 */         if (this.tLNPPolSet.size() > 0) {
/* 543 */           coverage.removeContent();
/*     */         }
/*     */ 
/* 546 */         int i = 1; for (int j = 1; i <= this.tLNPPolSet.size(); i++) {
/* 547 */           Element tempCoverage = (Element)acoverage.clone();
/* 548 */           LNPPolSchema tempPol = this.tLNPPolSet.get(i);
/* 549 */           updateText(tempCoverage, "COVERAGE", "01");
/* 550 */           updateText(tempCoverage, "CCDATE", fomartDate(this.tLNPContSchema.getPValiDate()));
/*     */           String tRiskIdx;
/* 553 */           if (!"M".equalsIgnoreCase(tempPol.getSubFlag())) {
/* 554 */             String tRiskIdx = "0" + j++;
/* 555 */             updateText(tempCoverage, "RIDER", tRiskIdx);
/*     */           } else {
/* 557 */             tRiskIdx = "00";
/* 558 */             updateText(tempCoverage, "RIDER", tRiskIdx);
/*     */           }
/* 560 */           tempPol.setHandler(tRiskIdx);
/*     */ 
/* 562 */           updateText(tempCoverage, "ZNPRDCODE", tempPol.getRiskCode());
/*     */ 
/* 564 */           updateText(tempCoverage, "SUMIN", turnNullToString(Integer.valueOf((int)tempPol.getAmnt())));
/* 565 */           updateText(tempCoverage, "ZNDISPER", "1");
/* 566 */           updateText(tempCoverage, "ZNRFAGE", turnNullToString(Integer.valueOf(tempPol.getGetYear())));
/* 567 */           if ("A".equals(tempPol.getInsuYearFlag()))
/* 568 */             updateText(tempCoverage, "RCESSAGE", turnNullToString(Integer.valueOf(tempPol.getInsuYear())));
/*     */           else {
/* 570 */             updateText(tempCoverage, "RCESSTRM", turnNullToString(Integer.valueOf(tempPol.getInsuYear())));
/*     */           }
/* 572 */           if ("A".equals(tempPol.getPayEndYearFlag()))
/* 573 */             updateText(tempCoverage, "PCESSAGE", turnNullToString(Integer.valueOf(tempPol.getPayEndYear())));
/*     */           else {
/* 575 */             updateText(tempCoverage, "PCESSTRM", "1000".equals(turnNullToString(Integer.valueOf(tempPol.getPayEndYear()))) ? "1" : turnNullToString(Integer.valueOf(tempPol.getPayEndYear())));
/*     */           }
/* 577 */           updateText(tempCoverage, "INSTPRM", turnNullToString(fomartNum(tempPol.getPrem())));
/*     */ 
/* 580 */           updateText(tempCoverage, "JLSEX", "");
/* 581 */           updateText(tempCoverage, "ZNJLAGE", "0");
/* 582 */           updateText(tempCoverage, "BENPLN", "");
/* 583 */           updateText(tempCoverage, "LIVESNO", "");
/* 584 */           coverage.addContent(tempCoverage);
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 589 */       e.printStackTrace();
/* 590 */       return false;
/*     */     }
/* 592 */     return true;
/*     */   }
/*     */ 
/*     */   protected boolean getInputData(String tContNo)
/*     */   {
/*     */     try
/*     */     {
/* 599 */       this.flag = false;
/* 600 */       this.valiPassFlag = true;
/* 601 */       if ((tContNo != null) && (!tContNo.equals("")))
/*     */       {
/* 603 */         ExeSQL exeSQL = new ExeSQL(this.con);
/* 604 */         SSRS ssrs = exeSQL.execSQL("select sysvartype,sysvarvalue from lnpsysvar where SysVar='issue_user_password'");
/* 605 */         if (ssrs.MaxRow > 0) {
/* 606 */           this.userName = ssrs.GetText(1, 1);
/* 607 */           this.password = ssrs.GetText(1, 2);
/*     */         } else {
/* 609 */           this.message = "\u7F3A\u5931\u6743\u9650,\u8BF7\u83B7\u53D6\u6743\u9650\u540E\u7EE7\u7EED\u64CD\u4F5C!";
/* 610 */           return this.valiPassFlag = 0;
/*     */         }
/*     */ 
/* 613 */         LNPContDB tLNPContDB = new LNPContDB(this.con);
/* 614 */         tLNPContDB.setContNo(tContNo);
/* 615 */         if (tLNPContDB.getInfo()) {
/* 616 */           this.tLNPContSchema = tLNPContDB.getSchema();
/* 617 */           String msg = "\u8BF7\u5B8C\u5584\u201C\u57FA\u7840\u4FE1\u606F\u201D\u90E8\u5206\u7684\u4FE1\u606F\u9879\uFF01";
/* 618 */           if ((turnNullToString(this.tLNPContSchema.getManageCom()).equals("")) || (turnNullToString(this.tLNPContSchema.getPValiDate()).equals(""))) {
/* 619 */             this.message = msg;
/* 620 */             return this.valiPassFlag = 0;
/*     */           }
/*     */         } else {
/* 623 */           this.message = "\u83B7\u53D6\u6295\u4FDD\u4E66\u4FE1\u606F\u5931\u8D25\uFF01";
/* 624 */           return this.valiPassFlag = 0;
/*     */         }
/*     */ 
/* 628 */         LNPPolDB lnpDb = new LNPPolDB(this.con);
/* 629 */         this.tLNPPolSet = lnpDb.executeQuery("select 1 from lnppol where contno='" + tContNo + "'");
/* 630 */         if (this.tLNPPolSet.size() <= 0) {
/* 631 */           this.message = "\u9669\u79CD\u4FE1\u606F\u672A\u586B\u5199\uFF01";
/* 632 */           return this.valiPassFlag = 0;
/*     */         }
/* 634 */         this.tLNPPolSet = lnpDb.executeQuery("select * from lnppol where contno='" + tContNo + "'");
/* 635 */         String msg = "\u8BF7\u5B8C\u5584\u201C\u6295\u4FDD\u4E8B\u9879\u201D\u4E2D\u201C\u9669\u79CD\u4FE1\u606F\u201D\u90E8\u5206\u7684\u4FE1\u606F\u9879\uFF01";
/*     */ 
/* 637 */         for (int i = 1; i <= this.tLNPPolSet.size(); i++) {
/* 638 */           LNPPolSchema tSchema = this.tLNPPolSet.get(i);
/*     */ 
/* 640 */           if ((turnNullToString(tSchema.getRiskVersion()).equals("")) && (
/* 641 */             (turnNullToString(Integer.valueOf(tSchema.getPayIntv())).equals("")) || (turnNullToString(tSchema.getRiskCode()).equals("")) || (
/* 642 */             (turnNullToString(Double.valueOf(tSchema.getAmnt())).equals("")) && (turnNullToString(Double.valueOf(tSchema.getPrem())).equals(""))))) {
/* 643 */             this.message = msg;
/* 644 */             return this.valiPassFlag = 0;
/*     */           }
/*     */ 
/* 664 */           if ((i != 1) || (!"03".equals(tSchema.getKindCode())) || (
/* 665 */             (!turnNullToString(Integer.valueOf(tSchema.getPayIntv())).equals("")) && 
/* 667 */             ((!turnNullToString(Double.valueOf(tSchema.getAmnt())).equals("")) || (!turnNullToString(Double.valueOf(tSchema.getPrem())).equals("")) || (!turnNullToString(tSchema.getRemark()).equals(""))) && 
/* 668 */             ((tSchema.getAmnt() > 0.0D) || (tSchema.getPrem() > 0.0D) || (!turnNullToString(tSchema.getRemark()).equals(""))) && 
/* 669 */             (!turnNullToString(tSchema.getPayMode()).equals("")) && 
/* 670 */             (!turnNullToString(tSchema.getPayLocation()).equals("")))) continue;
/* 671 */           this.message = msg;
/* 672 */           return this.valiPassFlag = 0;
/*     */         }
/*     */ 
/* 680 */         LNPAppntDB tLNPAppntDB = new LNPAppntDB(this.con);
/* 681 */         tLNPAppntDB.setContNo(tContNo);
/* 682 */         this.tLNPAppntSet = tLNPAppntDB.query();
/* 683 */         if (this.tLNPAppntSet.size() <= 0) {
/* 684 */           this.message = "\u8BF7\u5148\u8BBE\u7F6E\u6295\u4FDD\u4EBA\uFF01";
/* 685 */           return this.valiPassFlag = 0;
/*     */         }
/*     */ 
/* 689 */         String msg = "\u8BF7\u5B8C\u5584\u201C\u5BA2\u6237\u4FE1\u606F\u201D\u4E2D\u201C\u6295\u4FDD\u4EBA\u4FE1\u606F\u201D\u90E8\u5206\u7684\u4FE1\u606F\u9879\uFF01";
/* 690 */         LNPAppntSchema tSchema = this.tLNPAppntSet.get(1);
/* 691 */         LNPAddressDB tAddressBDB = new LNPAddressDB();
/* 692 */         tAddressBDB.setCustomerId(tSchema.getAppntId());
/* 693 */         tAddressBDB.setAddressNo(tSchema.getAddressNo());
/* 694 */         this.tLnpAddressSet = tAddressBDB.query();
/* 695 */         if (this.tLnpAddressSet.size() <= 0) {
/* 696 */           this.message = "\u8BF7\u5B8C\u6574\u5F55\u5165\u6295\u4FDD\u4EBA\u7684\u4FE1\u606F\uFF01";
/* 697 */           return this.valiPassFlag = 0;
/*     */         }
/*     */ 
/* 700 */         LNPAddressSchema tAddressSchema = this.tLnpAddressSet.get(1);
/* 701 */         if (turnNullToString(tAddressSchema.getEMail()).equals("")) {
/* 702 */           this.message = "\u6295\u4FDD\u4EBA\u5730\u5740\u5F55\u5165\u4E0D\u5B8C\u6574";
/* 703 */           return this.valiPassFlag = 0;
/*     */         }
/* 705 */         if ((turnNullToString(tSchema.getAppntName()).equals("")) || (turnNullToString(tSchema.getIDNo()).equals("")) || 
/* 706 */           (turnNullToString(tSchema.getAppntSex()).equals("")) || (turnNullToString(tSchema.getAppntBirthday()).equals("")) || 
/* 707 */           (turnNullToString(Integer.valueOf(tSchema.getAppntAge())).equals(""))) {
/* 708 */           this.message = msg;
/* 709 */           return this.valiPassFlag = 0;
/*     */         }
/*     */ 
/* 714 */         LNPInsuredDB tLNPInsuredDB = new LNPInsuredDB(this.con);
/* 715 */         tLNPInsuredDB.setContNo(tContNo);
/* 716 */         this.tLNPInsuredSet = tLNPInsuredDB.query();
/*     */ 
/* 718 */         if (this.tLNPInsuredSet.size() <= 0) {
/* 719 */           this.message = "\u8BF7\u5148\u8BBE\u7F6E\u88AB\u4FDD\u4EBA\uFF01";
/* 720 */           return this.valiPassFlag = 0;
/*     */         }
/* 722 */         String msg = "\u8BF7\u5B8C\u5584\u201C\u5BA2\u6237\u4FE1\u606F\u201D\u4E2D\u201C\u88AB\u4FDD\u4EBA\u4FE1\u606F\u201D\u90E8\u5206\u7684\u4FE1\u606F\u9879\uFF01";
/* 723 */         LNPInsuredSchema tSchema = this.tLNPInsuredSet.get(1);
/* 724 */         if ((turnNullToString(tSchema.getName()).equals("")) || (turnNullToString(tSchema.getIDNo()).equals("")) || 
/* 725 */           (turnNullToString(tSchema.getSex()).equals("")) || (turnNullToString(tSchema.getBirthday()).equals("")) || 
/* 726 */           (turnNullToString(Integer.valueOf(tSchema.getAppAge())).equals(""))) {
/* 727 */           this.message = msg;
/* 728 */           return this.valiPassFlag = 0;
/*     */         }
/*     */       }
/*     */       else {
/* 732 */         this.message = "\u7F3A\u5931\u6295\u4FDD\u4E66\u53F7\uFF01";
/* 733 */         return this.valiPassFlag = 0;
/*     */       }
/*     */     } catch (Exception ex) {
/* 736 */       ex.printStackTrace();
/* 737 */       return this.valiPassFlag = 0;
/*     */     }
/* 739 */     return true;
/*     */   }
/*     */ 
/*     */   private boolean isExistDoubleRisk(LNPPolSet tLnpPolSet) {
/* 743 */     boolean flag = false;
/* 744 */     for (int i = 1; i <= tLnpPolSet.size(); i++) {
/* 745 */       if (flag) break;
/* 746 */       LNPPolSchema tSchema = tLnpPolSet.get(i);
/* 747 */       for (int j = 1; j <= tLnpPolSet.size(); j++) {
/* 748 */         if (tSchema.getRiskCode().equals(tLnpPolSet.get(j).getRiskCode())) {
/* 749 */           flag = true;
/* 750 */           break;
/*     */         }
/*     */       }
/*     */     }
/* 754 */     return flag;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/* 758 */     CalPrem cal = new CalPrem();
/* 759 */     String tContNo = "123213213123";
/* 760 */     tContNo = "098765431111";
/* 761 */     tContNo = "201804261007";
/*     */ 
/* 763 */     tContNo = "201812271556";
/* 764 */     cal.calInterfaces(tContNo);
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.interfaces.CalPrem
 * JD-Core Version:    0.6.0
 */