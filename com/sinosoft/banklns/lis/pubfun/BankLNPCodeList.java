/*     */ package com.sinosoft.banklns.lis.pubfun;
/*     */ 
/*     */ import com.sinosoft.banklns.utility.ExeSQL;
/*     */ import com.sinosoft.banklns.utility.SSRS;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.faces.context.ExternalContext;
/*     */ import javax.faces.context.FacesContext;
/*     */ import javax.faces.model.SelectItem;
/*     */ 
/*     */ public class BankLNPCodeList
/*     */ {
/*  15 */   private List<SelectItem> relationItems = new ArrayList();
/*     */ 
/*  17 */   private List<SelectItem> yesOrNoItems = new ArrayList();
/*     */ 
/*  19 */   private List<SelectItem> genderItems = new ArrayList();
/*     */ 
/*  21 */   private List<SelectItem> idTypeItems = new ArrayList();
/*     */ 
/*  23 */   private List<SelectItem> idTypeItemPolicyholder = new ArrayList();
/*     */ 
/*  25 */   private List<SelectItem> idVailityTypeItems = new ArrayList();
/*     */ 
/*  27 */   private List<SelectItem> isExistsBnfItems = new ArrayList();
/*     */ 
/*  29 */   private List<SelectItem> bnfRelationItems = new ArrayList();
/*     */ 
/*  33 */   private List<SelectItem> paymentTypeItems = new ArrayList();
/*     */ 
/*  35 */   private List<SelectItem> transTypeItems = new ArrayList();
/*     */ 
/*  39 */   private List<SelectItem> banksignlist = new ArrayList();
/*     */ 
/*  43 */   private List<SelectItem> bankinvestmentlist = new ArrayList();
/*     */ 
/*  45 */   private List<SelectItem> bankpayintvlist = new ArrayList();
/*     */ 
/*  47 */   private List<SelectItem> bankchooselist = new ArrayList();
/*     */ 
/*  49 */   private List<SelectItem> bankbonuslist = new ArrayList();
/*     */ 
/*  51 */   private List<SelectItem> bankoverduelist = new ArrayList();
/*     */ 
/*  53 */   private List<SelectItem> bankannuitylist = new ArrayList();
/*     */ 
/*  55 */   private List<SelectItem> bankannuityreceivelist = new ArrayList();
/*     */ 
/*  57 */   private List<SelectItem> salechannellist = new ArrayList();
/*     */ 
/*  60 */   private List<SelectItem> areaCodeList = new ArrayList();
/*     */ 
/*     */   public static void main1(String[] args) {
/*  63 */     BankLNPCodeList t = new BankLNPCodeList();
/*  64 */     t.getBanksignlist();
/*  65 */     t.getBankoverduelist();
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getRelationItems() {
/*     */     try {
/*  70 */       if (this.relationItems.size() <= 0) {
/*  71 */         ExeSQL tExeSQL = new ExeSQL();
/*  72 */         String sql = "select code,codename from lnpcode where codetype='BankRelationship' order by othersign";
/*  73 */         System.out.println("sql-->" + sql);
/*  74 */         SSRS tSRS = tExeSQL.execSQL(sql);
/*  75 */         for (int i = 1; i <= tSRS.MaxRow; i++)
/*  76 */           this.relationItems.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  81 */       e.printStackTrace();
/*     */     }
/*  83 */     return this.relationItems;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getYesOrNoItems() {
/*     */     try {
/*  88 */       if (this.yesOrNoItems.size() <= 0) {
/*  89 */         ExeSQL tExeSQL = new ExeSQL();
/*  90 */         String sql = "select code,codename from lnpcode where codetype='BankIsOrNo' order by othersign";
/*  91 */         System.out.println("sql-->" + sql);
/*  92 */         SSRS tSRS = tExeSQL.execSQL(sql);
/*  93 */         for (int i = 1; i <= tSRS.MaxRow; i++)
/*  94 */           this.yesOrNoItems.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/*  98 */       e.printStackTrace();
/*     */     }
/* 100 */     return this.yesOrNoItems;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getGenderItems() {
/*     */     try {
/* 105 */       if (this.genderItems.size() <= 0) {
/* 106 */         ExeSQL tExeSQL = new ExeSQL();
/* 107 */         String sql = "select code,codename from lnpcode where codetype='BankPolicySex' order by othersign";
/* 108 */         System.out.println("sql-->" + sql);
/* 109 */         SSRS tSRS = tExeSQL.execSQL(sql);
/* 110 */         for (int i = 1; i <= tSRS.MaxRow; i++)
/* 111 */           this.genderItems.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 115 */       e.printStackTrace();
/*     */     }
/* 117 */     return this.genderItems;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getIdTypeItems()
/*     */   {
/*     */     try {
/* 123 */       if (this.idTypeItems.size() <= 0) {
/* 124 */         ExeSQL tExeSQL = new ExeSQL();
/* 125 */         String sql = "select code,codename from lnpcode where codetype='BankCertType' order by othersign";
/* 126 */         System.out.println("sql-->" + sql);
/* 127 */         SSRS tSRS = tExeSQL.execSQL(sql);
/* 128 */         for (int i = 1; i <= tSRS.MaxRow; i++)
/* 129 */           this.idTypeItems.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 133 */       e.printStackTrace();
/*     */     }
/* 135 */     return this.idTypeItems;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getIdVailityTypeItems() {
/*     */     try {
/* 140 */       if (this.idVailityTypeItems.size() <= 0) {
/* 141 */         ExeSQL tExeSQL = new ExeSQL();
/* 142 */         String sql = "select code,codename from lnpcode where codetype='BankCertificatesType' order by othersign";
/* 143 */         System.out.println("sql-->" + sql);
/* 144 */         SSRS tSRS = tExeSQL.execSQL(sql);
/* 145 */         for (int i = 1; i <= tSRS.MaxRow; i++)
/* 146 */           this.idVailityTypeItems.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 150 */       e.printStackTrace();
/*     */     }
/* 152 */     return this.idVailityTypeItems;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getIsExistsBnfItems() {
/*     */     try {
/* 157 */       if (this.isExistsBnfItems.size() <= 0) {
/* 158 */         ExeSQL tExeSQL = new ExeSQL();
/* 159 */         String sql = "select code,codename from lnpcode where codetype='BankDeathBenefit' order by othersign";
/* 160 */         System.out.println("sql-->" + sql);
/* 161 */         SSRS tSRS = tExeSQL.execSQL(sql);
/* 162 */         for (int i = 1; i <= tSRS.MaxRow; i++)
/* 163 */           this.isExistsBnfItems.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 167 */       e.printStackTrace();
/*     */     }
/* 169 */     return this.isExistsBnfItems;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getBnfRelationItems() {
/*     */     try {
/* 174 */       if (this.bnfRelationItems.size() <= 0) {
/* 175 */         ExeSQL tExeSQL = new ExeSQL();
/* 176 */         String sql = "select code,codename from lnpcode where codetype='BankBenefitAndInsured' order by othersign";
/* 177 */         System.out.println("sql-->" + sql);
/* 178 */         SSRS tSRS = tExeSQL.execSQL(sql);
/* 179 */         for (int i = 1; i <= tSRS.MaxRow; i++)
/* 180 */           this.bnfRelationItems.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 184 */       e.printStackTrace();
/*     */     }
/* 186 */     return this.bnfRelationItems;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getPaymentTypeItems() {
/*     */     try {
/* 191 */       if (this.paymentTypeItems.size() <= 0) {
/* 192 */         ExeSQL tExeSQL = new ExeSQL();
/* 193 */         String sql = "select code,codename from lnpcode where codetype='BankRenewal' order by othersign";
/* 194 */         System.out.println("sql-->" + sql);
/* 195 */         SSRS tSRS = tExeSQL.execSQL(sql);
/* 196 */         for (int i = 1; i <= tSRS.MaxRow; i++)
/* 197 */           this.paymentTypeItems.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 201 */       e.printStackTrace();
/*     */     }
/* 203 */     return this.paymentTypeItems;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getTransTypeItems() {
/*     */     try {
/* 208 */       if (this.transTypeItems.size() <= 0) {
/* 209 */         ExeSQL tExeSQL = new ExeSQL();
/* 210 */         String sql = "select code,codename from lnpcode where codetype='BankDeliveryType' order by othersign";
/* 211 */         System.out.println("sql-->" + sql);
/* 212 */         SSRS tSRS = tExeSQL.execSQL(sql);
/* 213 */         for (int i = 1; i <= tSRS.MaxRow; i++)
/* 214 */           this.transTypeItems.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 218 */       e.printStackTrace();
/*     */     }
/* 220 */     return this.transTypeItems;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getBanksignlist() {
/*     */     try {
/* 225 */       if (this.banksignlist.size() <= 0) {
/* 226 */         ExeSQL tExeSQL = new ExeSQL();
/* 227 */         String sql = "select code,codename from lnpcode where codetype='BankSigned' order by othersign";
/* 228 */         System.out.println("sql-->" + sql);
/* 229 */         SSRS tSRS = tExeSQL.execSQL(sql);
/* 230 */         for (int i = 1; i <= tSRS.MaxRow; i++)
/* 231 */           this.banksignlist.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 235 */       e.printStackTrace();
/*     */     }
/* 237 */     return this.banksignlist;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getBankinvestmentlist() {
/*     */     try {
/* 242 */       if (this.bankinvestmentlist.size() <= 0) {
/* 243 */         ExeSQL tExeSQL = new ExeSQL();
/* 244 */         String sql = "select code,codename from lnpcode where codetype='BankInvestment' order by othersign";
/* 245 */         System.out.println("sql-->" + sql);
/* 246 */         SSRS tSRS = tExeSQL.execSQL(sql);
/* 247 */         for (int i = 1; i <= tSRS.MaxRow; i++)
/* 248 */           this.bankinvestmentlist.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 252 */       e.printStackTrace();
/*     */     }
/* 254 */     return this.bankinvestmentlist;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getBankpayintvlist() {
/*     */     try {
/* 259 */       if (this.bankpayintvlist.size() <= 0) {
/* 260 */         ExeSQL tExeSQL = new ExeSQL();
/* 261 */         String sql = "select code,codename from lnpcode where codetype='BankFrequency' order by othersign";
/* 262 */         System.out.println("sql-->" + sql);
/* 263 */         SSRS tSRS = tExeSQL.execSQL(sql);
/* 264 */         for (int i = 1; i <= tSRS.MaxRow; i++)
/* 265 */           this.bankpayintvlist.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 269 */       e.printStackTrace();
/*     */     }
/* 271 */     return this.bankpayintvlist;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getBankchooselist() {
/*     */     try {
/* 276 */       if (this.bankchooselist.size() <= 0) {
/* 277 */         ExeSQL tExeSQL = new ExeSQL();
/* 278 */         String sql = "select code,codename from lnpcode where codetype='BankNextChoose' order by othersign";
/* 279 */         System.out.println("sql-->" + sql);
/* 280 */         SSRS tSRS = tExeSQL.execSQL(sql);
/* 281 */         for (int i = 1; i <= tSRS.MaxRow; i++)
/* 282 */           this.bankchooselist.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 286 */       e.printStackTrace();
/*     */     }
/* 288 */     return this.bankchooselist;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getBankbonuslist() {
/*     */     try {
/* 293 */       if (this.bankbonuslist.size() <= 0) {
/* 294 */         ExeSQL tExeSQL = new ExeSQL();
/* 295 */         String sql = "select code,codename from lnpcode where codetype='BankBonusPayMent' order by othersign";
/* 296 */         System.out.println("sql-->" + sql);
/* 297 */         SSRS tSRS = tExeSQL.execSQL(sql);
/* 298 */         for (int i = 1; i <= tSRS.MaxRow; i++) {
/* 299 */           this.bankbonuslist.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*     */         }
/*     */       }
/* 302 */       System.out.println("hahaha---getBankbonuslist");
/* 303 */       reconfigRisk();
/*     */     } catch (Exception e) {
/* 305 */       e.printStackTrace();
/*     */     }
/* 307 */     return this.bankbonuslist;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getBankoverduelist() {
/*     */     try {
/* 312 */       if (this.bankoverduelist.size() <= 0) {
/* 313 */         ExeSQL tExeSQL = new ExeSQL();
/* 314 */         String sql = "select code,codename from lnpcode where codetype='BankOverDue' order by othersign";
/* 315 */         System.out.println("sql-->" + sql);
/* 316 */         SSRS tSRS = tExeSQL.execSQL(sql);
/* 317 */         for (int i = 1; i <= tSRS.MaxRow; i++)
/* 318 */           this.bankoverduelist.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 322 */       e.printStackTrace();
/*     */     }
/* 324 */     return this.bankoverduelist;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getBankannuitylist() {
/*     */     try {
/* 329 */       if (this.bankannuitylist.size() <= 0) {
/* 330 */         ExeSQL tExeSQL = new ExeSQL();
/* 331 */         String sql = "select code,codename from lnpcode where codetype='BankAnnuity' order by othersign";
/* 332 */         System.out.println("sql-->" + sql);
/* 333 */         SSRS tSRS = tExeSQL.execSQL(sql);
/* 334 */         for (int i = 1; i <= tSRS.MaxRow; i++)
/* 335 */           this.bankannuitylist.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 339 */       e.printStackTrace();
/*     */     }
/* 341 */     System.out.println("hahaha---getBankannuitylist");
/* 342 */     reconfigRisk();
/* 343 */     return this.bankannuitylist;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getBankannuityreceivelist() {
/*     */     try {
/* 348 */       if (this.bankannuityreceivelist.size() <= 0) {
/* 349 */         ExeSQL tExeSQL = new ExeSQL();
/* 350 */         String sql = "select code,codename from lnpcode where codetype='BankAnnuityReceive' order by othersign";
/* 351 */         System.out.println("sql-->" + sql);
/* 352 */         SSRS tSRS = tExeSQL.execSQL(sql);
/* 353 */         for (int i = 1; i <= tSRS.MaxRow; i++)
/* 354 */           this.bankannuityreceivelist.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 358 */       e.printStackTrace();
/*     */     }
/* 360 */     System.out.println("hahaha---getBankannuityreceivelist");
/* 361 */     reconfigRisk();
/* 362 */     return this.bankannuityreceivelist;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getAreaCodeList() {
/* 366 */     if (this.areaCodeList != null) {
/* 367 */       this.areaCodeList.clear();
/*     */     }
/* 369 */     ExeSQL tExeSQL = new ExeSQL();
/* 370 */     String sql = "select code,codename from lnpcode where codetype='areaCode' order by othersign";
/* 371 */     System.out.println("sql-->" + sql);
/* 372 */     SSRS tSRS = tExeSQL.execSQL(sql);
/* 373 */     for (int i = 1; i <= tSRS.MaxRow; i++) {
/* 374 */       this.areaCodeList.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*     */     }
/* 376 */     return this.areaCodeList;
/*     */   }
/*     */ 
/*     */   public void setAreaCodeList(List<SelectItem> areaCodeList) {
/* 380 */     this.areaCodeList = areaCodeList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getSalechannellist() {
/*     */     try {
/* 385 */       if (this.salechannellist.size() <= 0) {
/* 386 */         ExeSQL tExeSQL = new ExeSQL();
/* 387 */         String sql = "select code,codename from lnpcode where codetype='BankSalechannel' order by othersign";
/* 388 */         System.out.println("sql-->" + sql);
/* 389 */         SSRS tSRS = tExeSQL.execSQL(sql);
/* 390 */         for (int i = 1; i <= tSRS.MaxRow; i++)
/* 391 */           this.salechannellist.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 395 */       e.printStackTrace();
/*     */     }
/* 397 */     return this.salechannellist;
/*     */   }
/*     */ 
/*     */   public void setSalechannellist(List<SelectItem> salechannellist) {
/* 401 */     this.salechannellist = salechannellist;
/*     */   }
/*     */ 
/*     */   public synchronized void reconfigRisk()
/*     */   {
/*     */     try
/*     */     {
/* 413 */       String[] riskcode = new String[9];
/* 414 */       for (int i = 0; i < riskcode.length; i++) {
/* 415 */         riskcode[i] = ((String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("riskcode" + i));
/*     */       }
/*     */ 
/* 419 */       System.out.println("+++++++++++++\u524D\u53F0\u4F20\u5165\u7684\u9669\u79CD\u4EE3\u7801\u53C2\u6570\u4E3A\uFF1A" + riskcode);
/* 420 */       if ((riskcode[0] == null) || ("".equals(riskcode[0]))) {
/* 421 */         riskcode[0] = "Defult";
/* 422 */         System.out.println("\u91CD\u7F6E\u83DC\u5355\u7EC4+++++Defult++++++++++++");
/*     */       }
/*     */ 
/* 425 */       String L_BankBonusMode = "";
/* 426 */       String L_BankAnnMode = "";
/* 427 */       String L_BankAnnFreq = "";
/* 428 */       String L_BankCpnMode = "";
/*     */ 
/* 433 */       ExeSQL tExeSQL = new ExeSQL();
/* 434 */       String sql = "select top 1 L_BankBonusMode,L_BankAnnMode,L_BankAnnFreq,L_BankCpnMode from [LNPRiskConfig] where";
/* 435 */       for (int i = 0; i < riskcode.length; i++) {
/* 436 */         if (!"".equals(riskcode[i])) {
/* 437 */           sql = sql + " L_RiskCode='" + riskcode[i] + "' or";
/*     */         }
/*     */       }
/*     */ 
/* 441 */       sql = sql + " 1<>1";
/*     */ 
/* 443 */       SSRS tSRS = tExeSQL.execSQL(sql);
/* 444 */       if (tSRS.MaxRow > 0) {
/* 445 */         L_BankBonusMode = tSRS.GetText(1, 1);
/* 446 */         L_BankAnnMode = tSRS.GetText(1, 2);
/* 447 */         L_BankAnnFreq = tSRS.GetText(1, 3);
/* 448 */         L_BankCpnMode = tSRS.GetText(1, 4);
/*     */       }
/*     */       else {
/* 451 */         this.bankannuitylist.clear();
/* 452 */         this.bankannuityreceivelist.clear();
/* 453 */         this.bankbonuslist.clear();
/* 454 */         return;
/*     */       }
/*     */ 
/* 466 */       String ITEM = "";
/* 467 */       if (!"-1".equals(L_BankAnnMode)) {
/* 468 */         ITEM = L_BankAnnMode;
/*     */       }
/* 470 */       if (!"-1".equals(L_BankCpnMode)) {
/* 471 */         ITEM = L_BankCpnMode;
/*     */       }
/*     */ 
/* 474 */       this.bankannuitylist.clear();
/* 475 */       if (!"".equals(ITEM)) {
/* 476 */         String[] annmode = ITEM.split("-");
/* 477 */         String sql1 = "select code,codename from lnpcode where codetype='BankAnnuity' and (";
/* 478 */         for (int i = 0; i < annmode.length; i++) {
/* 479 */           sql1 = sql1 + " code='" + annmode[i] + "' or";
/*     */         }
/* 481 */         sql1 = sql1 + " 1<>1)order by othersign";
/* 482 */         System.out.println(sql1);
/* 483 */         tSRS = tExeSQL.execSQL(sql1);
/* 484 */         for (int i = 1; i <= tSRS.MaxRow; i++) {
/* 485 */           this.bankannuitylist.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 491 */       this.bankannuityreceivelist.clear();
/* 492 */       if (!"-1".equals(L_BankAnnFreq)) {
/* 493 */         String[] annmode = L_BankAnnFreq.split("-");
/* 494 */         String sql1 = "select code,codename from lnpcode where codetype='BankAnnuityReceive' and (";
/* 495 */         for (int i = 0; i < annmode.length; i++) {
/* 496 */           sql1 = sql1 + " code='" + annmode[i] + "' or";
/*     */         }
/* 498 */         sql1 = sql1 + " 1<>1 )order by othersign";
/* 499 */         System.out.println(sql1);
/* 500 */         tSRS = tExeSQL.execSQL(sql1);
/*     */ 
/* 502 */         for (int i = 1; i <= tSRS.MaxRow; i++) {
/* 503 */           this.bankannuityreceivelist.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 508 */       this.bankbonuslist.clear();
/* 509 */       if (!"-1".equals(L_BankBonusMode)) {
/* 510 */         String[] annmode = L_BankBonusMode.split("-");
/* 511 */         String sql1 = "select code,codename from lnpcode where codetype='BankBonusPayMent' and (";
/* 512 */         for (int i = 0; i < annmode.length; i++) {
/* 513 */           sql1 = sql1 + " code='" + annmode[i] + "' or";
/*     */         }
/* 515 */         sql1 = sql1 + " 1<>1 )order by othersign";
/* 516 */         System.out.println(sql1);
/* 517 */         tSRS = tExeSQL.execSQL(sql1);
/*     */ 
/* 519 */         for (int i = 1; i <= tSRS.MaxRow; i++)
/* 520 */           this.bankbonuslist.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 524 */       System.out.println("\u6839\u636E\u914D\u7F6E\u8868\u81EA\u52A8\u914D\u7F6E\u5E74\u91D1\u7EA2\u5229\u9009\u9879\u51FA\u9519, \u62A5\u9519\u4FE1\u606F\u4E3A\uFF1A");
/* 525 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 531 */     BankLNPCodeList bankLNPCodeList = new BankLNPCodeList();
/* 532 */     bankLNPCodeList.reconfigRisk();
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.pubfun.BankLNPCodeList
 * JD-Core Version:    0.6.0
 */