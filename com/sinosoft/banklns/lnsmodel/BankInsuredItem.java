/*      */ package com.sinosoft.banklns.lnsmodel;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.BankBasicBL;
/*      */ import com.sinosoft.banklns.lis.db.LNPAgentInfoDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPBonusInfoDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPCustImpResultDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPInvestmentAccountInfoDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPInvestmentInfoDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPPolDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
/*      */ import com.sinosoft.banklns.lis.pubfun.MMap;
/*      */ import com.sinosoft.banklns.lis.pubfun.PubFun;
/*      */ import com.sinosoft.banklns.lis.pubfun.PubSubmit;
/*      */ import com.sinosoft.banklns.lis.pubfun.SysMaxNoMAPNP;
/*      */ import com.sinosoft.banklns.lis.schema.LNPAgentInfoSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPBonusInfoSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPInvestmentAccountInfoSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPInvestmentInfoSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPPolSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPAgentInfoSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPBonusInfoSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPCustImpResultSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPInvestmentAccountInfoSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPInvestmentInfoSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPPolSet;
/*      */ import com.sinosoft.banklns.utility.ExeSQL;
/*      */ import com.sinosoft.banklns.utility.SSRS;
/*      */ import com.sinosoft.banklns.utility.VData;
/*      */ import java.io.PrintStream;
/*      */ import java.text.DecimalFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import javax.faces.context.ExternalContext;
/*      */ import javax.faces.context.FacesContext;
/*      */ import javax.servlet.http.HttpSession;
/*      */ 
/*      */ public class BankInsuredItem extends BankBasicBL
/*      */ {
/*      */   private boolean editFlag;
/*   48 */   private boolean operateResult = true;
/*      */   private BankPolicyState policyState;
/*      */   private IGlobalInput tempGI;
/*      */   private String radiotype;
/*   54 */   private boolean allCompelte = false;
/*      */   private LNPContSchema contSchema;
/*      */   private String message;
/*      */   private String infoSource;
/*      */   private String contNo;
/*   64 */   private LNPPolSchema polSchema = new LNPPolSchema();
/*   65 */   private LNPBonusInfoSchema bonusInfoSchema = new LNPBonusInfoSchema();
/*   66 */   private LNPInvestmentInfoSchema investSchema = new LNPInvestmentInfoSchema();
/*      */   private String poltype;
/*      */   private String sumprem;
/*   76 */   private String[] riskcode = new String[30];
/*   77 */   private String[] years = new String[30];
/*   78 */   private String[] payyears = new String[30];
/*   79 */   private String[] type = new String[30];
/*   80 */   private String[] money = new String[30];
/*      */   private String getyear;
/*      */   private List<LNPPolBean> lnpList;
/*      */   private String vulriskcode;
/*      */   private String vulprem;
/*      */   private String vulmonthplus;
/*      */   private String vulyear;
/*      */   private String vulinvestment;
/*      */   private List<LNPVulBean> vulinvestmentList;
/*      */   private int vulsize;
/*   93 */   private boolean vullistflag = true;
/*   94 */   private boolean vulrateflag = false;
/*      */ 
/*   99 */   private String[] combinationriskcode = new String[6];
/*  100 */   private String[] combinationyears = new String[6];
/*  101 */   private String[] combinationpayyears = new String[6];
/*  102 */   private String[] combinationtype = new String[6];
/*  103 */   private String[] combinationmoney = new String[6];
/*      */   private List<LNPPolBean> cbtlnpList;
/*      */   private String salechannel;
/*      */   private String yearmoneychangeriskcode;
/*      */   private String yearmoneychangeyears;
/*      */   private String yearmoneychangepayyears;
/*      */   private String yearmoneychangemoney;
/*      */   private String yearmoneychangegetyear;
/*      */   private List<LNPPolBean> ymclnpList;
/*      */   private Integer payintv;
/*      */   private String overflowpremium;
/*      */   private String overduepremium;
/*      */   private String deadgetmode;
/*      */   private String bonusgetmode;
/*      */   private String annuityfrequency;
/*  125 */   BankRelationContNo relationDeal = new BankRelationContNo();
/*      */   private String operType;
/*      */   private String manageCom;
/*      */   private boolean alertFlag;
/*  136 */   private static DecimalFormat decimalFormat = new DecimalFormat("#0.00");
/*      */ 
/*      */   public void initData()
/*      */   {
/*      */     try
/*      */     {
/*  145 */       HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*  146 */       System.out.println("---------------- start init policy msg -----------------------------");
/*  147 */       System.out.println("\u6295\u4FDD\u4E8B\u9879\u83B7\u53D6\u7684contNo\u662F--------" + this.contNo);
/*  148 */       this.lnpList = new ArrayList();
/*  149 */       this.cbtlnpList = new ArrayList();
/*  150 */       this.ymclnpList = new ArrayList();
/*  151 */       this.vulinvestmentList = new ArrayList();
/*  152 */       this.vulsize = this.vulinvestmentList.size();
/*  153 */       this.radiotype = "";
/*      */ 
/*  155 */       this.poltype = "01";
/*      */ 
/*  157 */       this.overflowpremium = "02";
/*  158 */       this.overduepremium = "03";
/*  159 */       this.bonusgetmode = "01";
/*  160 */       this.deadgetmode = "01";
/*      */ 
/*  162 */       this.getyear = "";
/*  163 */       this.sumprem = "";
/*  164 */       this.operateResult = true;
/*      */ 
/*  166 */       for (int i = 0; i < 30; i++)
/*      */       {
/*  168 */         this.riskcode[i] = "";
/*  169 */         this.years[i] = null;
/*  170 */         this.payyears[i] = null;
/*  171 */         this.type[i] = "";
/*  172 */         this.money[i] = null;
/*      */       }
/*      */ 
/*  176 */       this.vulriskcode = "";
/*  177 */       this.vulprem = null;
/*  178 */       this.vulmonthplus = null;
/*  179 */       this.vulyear = null;
/*  180 */       for (int i = 0; i < 6; i++) {
/*  181 */         this.combinationriskcode[i] = "";
/*  182 */         this.combinationyears[i] = null;
/*  183 */         this.combinationpayyears[i] = null;
/*  184 */         this.combinationtype[i] = "";
/*  185 */         this.combinationmoney[i] = null;
/*      */       }
/*      */ 
/*  193 */       this.yearmoneychangeriskcode = "";
/*  194 */       this.yearmoneychangeyears = null;
/*  195 */       this.yearmoneychangepayyears = null;
/*  196 */       this.yearmoneychangemoney = null;
/*  197 */       this.yearmoneychangegetyear = "";
/*      */ 
/*  199 */       if (getInfoFromSession(session)) {
/*  200 */         this.contSchema = getMyLNPContByContNo(this.contNo);
/*      */ 
/*  203 */         Boolean getEditFlag = (Boolean)session.getAttribute("Queryflag");
/*      */ 
/*  205 */         BankOperateDeal stateDeal = new BankOperateDeal();
/*  206 */         Boolean operateFlag = Boolean.valueOf(stateDeal.isEidtSheet(this.contSchema.getState(), "02", this.tempGI.LNPRole, this.contNo));
/*  207 */         System.out.println("\u5F53\u524D\u7684getEditFlag\u7684\u503C ====" + operateFlag);
/*      */ 
/*  212 */         if (getEditFlag == null) {
/*  213 */           if (operateFlag.booleanValue())
/*  214 */             this.editFlag = true;
/*      */         }
/*  216 */         else if ((getEditFlag.booleanValue()) && (operateFlag.booleanValue()))
/*  217 */           this.editFlag = true;
/*      */         else {
/*  219 */           this.editFlag = false;
/*      */         }
/*      */ 
/*  222 */         LNPPolSet polsetinfo = getPolByContNo(this.contNo);
/*      */ 
/*  224 */         this.bonusInfoSchema = getBonusSchemaByContNo(this.contNo);
/*  225 */         this.investSchema = getInvestmentSchemaByContNo(this.contNo);
/*      */ 
/*  229 */         if ((this.contSchema != null) && (polsetinfo != null) && (polsetinfo.size() > 0))
/*      */         {
/*  232 */           System.out.println("\u6B64\u65F6\u8BF4\u660EcontSchema\u4E0Epolsetinfo\u5DF2\u7ECF\u4E0D\u4E3A\u7A7A\u4E86");
/*  233 */           if (polsetinfo.get(1).getKindCode().equals("01")) {
/*  234 */             System.out.println("\u4F20\u7EDF\u9669\u79CD\u65F6\u8FDB\u5165-------------");
/*  235 */             this.poltype = "01";
/*  236 */             for (int i = 0; i < polsetinfo.size(); i++) {
/*  237 */               if ((!polsetinfo.get(i + 1).getRiskCode().equals("")) && (polsetinfo.get(i + 1).getRiskCode() != null)) {
/*  238 */                 this.riskcode[i] = polsetinfo.get(i + 1).getRiskCode();
/*  239 */                 if ((polsetinfo.get(i + 1).getInsuYear() == 0) && (turnNullToString(polsetinfo.get(i + 1).getInsuYearFlag()).equals("")))
/*  240 */                   this.years[i] = "0";
/*  241 */                 else if ((turnNullToString(polsetinfo.get(i + 1).getInsuYearFlag()).equals("")) || (polsetinfo.get(i + 1).getInsuYear() < 0))
/*  242 */                   this.years[i] = "";
/*  243 */                 else if ((polsetinfo.get(i + 1).getInsuYearFlag().equals("A")) && (polsetinfo.get(i + 1).getInsuYear() != SpecialProductFun.getRiskPro(polsetinfo.get(i + 1).getRiskCode())))
/*  244 */                   this.years[i] = ("T" + polsetinfo.get(i + 1).getInsuYear());
/*  245 */                 else if ((polsetinfo.get(i + 1).getInsuYearFlag().equals("A")) && (polsetinfo.get(i + 1).getInsuYear() == SpecialProductFun.getRiskPro(polsetinfo.get(i + 1).getRiskCode())))
/*  246 */                   this.years[i] = "\u7EC8\u8EAB";
/*  247 */                 else if (polsetinfo.get(i + 1).getInsuYearFlag().equals("Y")) {
/*  248 */                   this.years[i] = polsetinfo.get(i + 1).getInsuYear();
/*      */                 }
/*  250 */                 System.out.println("\u7ED3\u675F\u4FDD\u969C\u671F");
/*      */ 
/*  252 */                 if ((turnNullToString(polsetinfo.get(i + 1).getPayEndYearFlag()).equals("")) || (polsetinfo.get(i + 1).getPayEndYear() < 0))
/*  253 */                   this.payyears[i] = "";
/*  254 */                 else if (polsetinfo.get(i + 1).getPayEndYearFlag().equals("A"))
/*  255 */                   this.payyears[i] = ("T" + polsetinfo.get(i + 1).getPayEndYear());
/*  256 */                 else if ((polsetinfo.get(i + 1).getPayEndYearFlag().equals("Y")) && (polsetinfo.get(i + 1).getPayEndYear() == 1000))
/*  257 */                   this.payyears[i] = "0";
/*  258 */                 else if ((polsetinfo.get(i + 1).getPayEndYearFlag().equals("Y")) && (polsetinfo.get(i + 1).getPayEndYear() != 1000)) {
/*  259 */                   this.payyears[i] = polsetinfo.get(i + 1).getPayEndYear();
/*      */                 }
/*  261 */                 System.out.println("\u7ED3\u675F\u7F34\u8D39\u671F");
/*  262 */                 this.type[i] = polsetinfo.get(i + 1).getUWCode();
/*      */ 
/*  269 */                 if (this.type[i].equals("01"))
/*      */                 {
/*  271 */                   this.money[i] = (polsetinfo.get(i + 1).getAmnt() < 0.0D ? null : decimalFormat.format(polsetinfo.get(i + 1).getAmnt()));
/*      */                 }
/*  273 */                 else if (this.type[i].equals("02")) {
/*  274 */                   this.money[i] = (polsetinfo.get(i + 1).getPrem() < 0.0D ? null : decimalFormat.format(polsetinfo.get(i + 1).getPrem()));
/*      */                 }
/*      */                 else {
/*  277 */                   this.money[i] = null;
/*      */                 }
/*      */               }
/*      */ 
/*  281 */               if ("M".equals(polsetinfo.get(i + 1).getSubFlag()))
/*  282 */                 this.getyear = polsetinfo.get(i + 1).getGetYear();
/*      */             }
/*  284 */             System.out.println("-------------------xboysongjian-------------------------------" + this.getyear);
/*      */ 
/*  286 */             if ((this.contSchema.getState().equals("03")) || (this.contSchema.getState().equals("05")) || (this.contSchema.getState().equals("06")) || 
/*  287 */               (this.contSchema.getState().equals("07")))
/*      */             {
/*  289 */               for (int i = 1; i <= polsetinfo.size(); i++) {
/*  290 */                 LNPPolBean temp = new LNPPolBean();
/*  291 */                 LNPPolSchema schema = polsetinfo.get(i);
/*  292 */                 temp.setSchema(schema, "");
/*      */ 
/*  298 */                 this.lnpList.add(temp);
/*      */               }
/*  300 */               this.sumprem = decimalFormat.format(polsetinfo.get(1).getSumPrem());
/*      */             }
/*      */ 
/*  303 */             this.payintv = Integer.valueOf(polsetinfo.get(1).getPayIntv());
/*  304 */             this.deadgetmode = polsetinfo.get(1).getDeadGetMode();
/*  305 */             this.annuityfrequency = polsetinfo.get(1).getStandbyFlag3();
/*  306 */             this.bonusgetmode = this.bonusInfoSchema.getBonusWay();
/*  307 */             this.overflowpremium = this.bonusInfoSchema.getP1();
/*  308 */             this.overduepremium = this.bonusInfoSchema.getP2();
/*      */           }
/*  310 */           if (polsetinfo.get(1).getKindCode().equals("02")) {
/*  311 */             System.out.println("VUL\u9669\u65F6\u8FDB\u5165--------------");
/*  312 */             this.poltype = "02";
/*  313 */             this.vulriskcode = polsetinfo.get(1).getRiskCode();
/*  314 */             if (this.editFlag)
/*  315 */               this.vulrateflag = false;
/*      */             else {
/*  317 */               this.vulrateflag = true;
/*      */             }
/*  319 */             List vulbean = getInvestList(this.vulriskcode, this.contNo);
/*  320 */             if (vulbean == null) {
/*  321 */               System.out.println("\u5F53\u524D\u6295\u8D44\u4FE1\u606F\u8868\u4E2D\u65E0\u6570\u636E\uFF0C\u8C03\u7528findAccountCode\u65B9\u6CD5\u67E5\u8BE2riskcode\u6570\u636E");
/*  322 */               findAccountCode();
/*      */             } else {
/*  324 */               System.out.println("\u5F53\u524D\u6295\u8D44\u4FE1\u606F\u8868\u4E2D\u6709\u6570\u636E----------");
/*  325 */               this.vulinvestmentList = vulbean;
/*  326 */               this.vulsize = this.vulinvestmentList.size();
/*      */             }
/*  328 */             if (polsetinfo.get(1).getPrem() < 0.0D)
/*  329 */               this.vulprem = null;
/*      */             else {
/*  331 */               this.vulprem = decimalFormat.format(polsetinfo.get(1).getPrem());
/*      */             }
/*  333 */             if (this.investSchema.getMonthPlusPrem() < 0.0D)
/*  334 */               this.vulmonthplus = null;
/*      */             else {
/*  336 */               this.vulmonthplus = decimalFormat.format(this.investSchema.getMonthPlusPrem());
/*      */             }
/*  338 */             this.vulyear = this.investSchema.getTermInvestment();
/*  339 */             this.vulinvestment = this.investSchema.getHesInvestment();
/*  340 */             this.payintv = Integer.valueOf(5);
/*  341 */             this.bonusgetmode = "";
/*  342 */             this.overflowpremium = "02";
/*  343 */             this.overduepremium = "03";
/*  344 */             this.annuityfrequency = "";
/*  345 */             this.deadgetmode = "-1";
/*      */           }
/*  347 */           if (polsetinfo.get(1).getKindCode().equals("03")) {
/*  348 */             System.out.println("\u7EC4\u5408\u9669\u65F6\u8FDB\u5165---------------");
/*  349 */             this.poltype = "03";
/*      */ 
/*  351 */             for (int i = 0; i < polsetinfo.size(); i++)
/*      */             {
/*  353 */               if ((polsetinfo.get(i + 1).getRiskVersion().equals("")) || (polsetinfo.get(i + 1).getRiskVersion() == null)) {
/*      */                 continue;
/*      */               }
/*  356 */               if (("1".equals(polsetinfo.get(i + 1).getRnewFlag())) && ("M".equals(polsetinfo.get(i + 1).getSubFlag()))) {
/*  357 */                 this.combinationriskcode[i] = polsetinfo.get(i + 1).getRiskVersion();
/*  358 */                 if ((turnNullToString(polsetinfo.get(i + 1).getPremToAmnt()).equals("")) && ("0".equals(polsetinfo.get(i + 1).getPayLocation()))) {
/*  359 */                   this.combinationyears[i] = "0";
/*  360 */                 } else if ((turnNullToString(polsetinfo.get(i + 1).getPremToAmnt()).equals("")) || (turnNullToString(polsetinfo.get(i + 1).getPayLocation()).equals(""))) {
/*  361 */                   this.combinationyears[i] = "";
/*      */                 } else {
/*  363 */                   if ((polsetinfo.get(i + 1).getPremToAmnt().equals("A")) && (!polsetinfo.get(i + 1).getPayLocation().equals("106"))) {
/*  364 */                     this.combinationyears[i] = ("T" + polsetinfo.get(i + 1).getPayLocation());
/*      */                   }
/*  366 */                   if ((polsetinfo.get(i + 1).getPremToAmnt().equals("A")) && (polsetinfo.get(i + 1).getPayLocation().equals("106"))) {
/*  367 */                     this.combinationyears[i] = "\u7EC8\u8EAB";
/*      */                   }
/*  369 */                   if (polsetinfo.get(i + 1).getPremToAmnt().equals("Y")) {
/*  370 */                     this.combinationyears[i] = polsetinfo.get(i + 1).getPayLocation();
/*      */                   }
/*      */                 }
/*  373 */                 if ((turnNullToString(polsetinfo.get(i + 1).getAcciYearFlag()).equals("")) || (turnNullToString(polsetinfo.get(i + 1).getPayMode()).equals(""))) {
/*  374 */                   this.combinationpayyears[i] = "";
/*      */                 } else {
/*  376 */                   if (polsetinfo.get(i + 1).getAcciYearFlag().equals("A")) {
/*  377 */                     this.combinationpayyears[i] = ("T" + polsetinfo.get(i + 1).getPayMode());
/*      */                   }
/*  379 */                   if ((polsetinfo.get(i + 1).getAcciYearFlag().equals("Y")) && (polsetinfo.get(i + 1).getPayMode().equals("1000"))) {
/*  380 */                     this.combinationpayyears[i] = "0";
/*      */                   }
/*  382 */                   if ((polsetinfo.get(i + 1).getAcciYearFlag().equals("Y")) && (!polsetinfo.get(i + 1).getPayMode().equals("1000"))) {
/*  383 */                     this.combinationpayyears[i] = polsetinfo.get(i + 1).getPayMode();
/*      */                   }
/*      */                 }
/*      */ 
/*  387 */                 this.combinationtype[i] = polsetinfo.get(i + 1).getUWCode();
/*  388 */                 System.out.println("\u521D\u59CB\u5316\u7EC4\u5408\u9669==================\u4FDD\u989D\u6216\u8005\u4FDD\u8D39\u6807\u5FD7\u4F4D---------------" + this.combinationtype[i]);
/*  389 */                 if ((this.combinationtype[i] == null) || ("".equals(this.combinationtype[i]))) {
/*  390 */                   if ((polsetinfo.get(i + 1).getRemark() == null) || ("".equals(polsetinfo.get(i + 1).getRemark()))) {
/*  391 */                     this.combinationmoney[i] = null;
/*      */                   }
/*      */                   else
/*  394 */                     this.combinationmoney[i] = polsetinfo.get(i + 1).getRemark();
/*      */                 }
/*      */                 else {
/*  397 */                   System.out.println("\u521D\u59CB\u5316\u7EC4\u5408\u9669==================\u4FDD\u989D\u6216\u8005\u4FDD\u8D39\u6807\u5FD7\u4F4D---------------" + this.combinationtype[i]);
/*  398 */                   if (this.combinationtype[i].equals("01")) {
/*  399 */                     System.out.println("\u6B64\u65F6\u4E3A\u4FDD\u989D\u7684\u503C++++++++++");
/*  400 */                     this.combinationmoney[i] = (polsetinfo.get(i + 1).getAmnt() < 0.0D ? null : decimalFormat.format(polsetinfo.get(i + 1).getAmnt()));
/*  401 */                     System.out.println("\u6B64\u65F6\u4FDD\u989D======" + this.combinationmoney[i]);
/*  402 */                   } else if (this.combinationtype[i].equals("02")) {
/*  403 */                     System.out.println("\u6B64\u65F6\u4E3A\u4FDD\u8D39\u7684\u503C++++++++++");
/*  404 */                     this.combinationmoney[i] = (polsetinfo.get(i + 1).getPrem() < 0.0D ? null : decimalFormat.format(polsetinfo.get(i + 1).getPrem()));
/*  405 */                     System.out.println("\u6B64\u65F6\u4FDD\u8D39======" + this.combinationmoney[i]);
/*      */                   } else {
/*  407 */                     System.out.println("\u53D6\u7684\u662F\u73B0\u5728\u7684money\u503C--------");
/*  408 */                     this.combinationmoney[i] = null;
/*      */                   }
/*  410 */                   System.out.println("\u521D\u59CB\u5316\u7EC4\u5408\u9669==================\u4FDD\u989D\u6216\u8005\u4FDD\u8D39---------------" + this.combinationmoney[i]);
/*      */                 }
/*      */               } else {
/*  413 */                 if (i == 1)
/*      */                   continue;
/*  415 */                 this.combinationriskcode[(i - 1)] = polsetinfo.get(i + 1).getRiskCode();
/*  416 */                 if ((turnNullToString(polsetinfo.get(i + 1).getPremToAmnt()).equals("")) && ("0".equals(polsetinfo.get(i + 1).getPayLocation()))) {
/*  417 */                   this.combinationyears[(i - 1)] = "0";
/*  418 */                 } else if ((turnNullToString(polsetinfo.get(i + 1).getPremToAmnt()).equals("")) || (turnNullToString(polsetinfo.get(i + 1).getPayLocation()).equals(""))) {
/*  419 */                   this.combinationyears[(i - 1)] = "";
/*      */                 } else {
/*  421 */                   if ((polsetinfo.get(i + 1).getPremToAmnt().equals("A")) && (!polsetinfo.get(i + 1).getPayLocation().equals("106"))) {
/*  422 */                     this.combinationyears[(i - 1)] = ("T" + polsetinfo.get(i + 1).getPayLocation());
/*      */                   }
/*  424 */                   if ((polsetinfo.get(i + 1).getPremToAmnt().equals("A")) && (polsetinfo.get(i + 1).getPayLocation().equals("106"))) {
/*  425 */                     this.combinationyears[(i - 1)] = "\u7EC8\u8EAB";
/*      */                   }
/*  427 */                   if (polsetinfo.get(i + 1).getPremToAmnt().equals("Y")) {
/*  428 */                     this.combinationyears[(i - 1)] = polsetinfo.get(i + 1).getPayLocation();
/*      */                   }
/*      */                 }
/*  431 */                 if ((turnNullToString(polsetinfo.get(i + 1).getAcciYearFlag()).equals("")) || (turnNullToString(polsetinfo.get(i + 1).getPayMode()).equals(""))) {
/*  432 */                   this.combinationpayyears[(i - 1)] = "";
/*      */                 } else {
/*  434 */                   if (polsetinfo.get(i + 1).getAcciYearFlag().equals("A")) {
/*  435 */                     this.combinationpayyears[(i - 1)] = ("T" + polsetinfo.get(i + 1).getPayMode());
/*      */                   }
/*  437 */                   if ((polsetinfo.get(i + 1).getAcciYearFlag().equals("Y")) && (polsetinfo.get(i + 1).getPayMode().equals("1000"))) {
/*  438 */                     this.combinationpayyears[(i - 1)] = "0";
/*      */                   }
/*  440 */                   if ((polsetinfo.get(i + 1).getAcciYearFlag().equals("Y")) && (!polsetinfo.get(i + 1).getPayMode().equals("1000"))) {
/*  441 */                     this.combinationpayyears[(i - 1)] = polsetinfo.get(i + 1).getPayMode();
/*      */                   }
/*      */                 }
/*      */ 
/*  445 */                 this.combinationtype[(i - 1)] = polsetinfo.get(i + 1).getUWCode();
/*  446 */                 System.out.println("\u521D\u59CB\u5316\u7EC4\u5408\u9669\u9644\u9669==================\u4FDD\u989D\u6216\u8005\u4FDD\u8D39\u6807\u5FD7\u4F4D---------------" + this.combinationtype[(i - 1)]);
/*  447 */                 if ((this.combinationtype[(i - 1)] == null) || ("".equals(this.combinationtype[(i - 1)]))) {
/*  448 */                   if ((polsetinfo.get(i + 1).getRemark() == null) || ("".equals(polsetinfo.get(i + 1).getRemark()))) {
/*  449 */                     this.combinationmoney[(i - 1)] = null;
/*      */                   }
/*      */ 
/*      */                 }
/*      */                 else
/*      */                 {
/*  455 */                   System.out.println("\u521D\u59CB\u5316\u7EC4\u5408\u9669\u9644\u9669==================\u4FDD\u989D\u6216\u8005\u4FDD\u8D39\u6807\u5FD7\u4F4D---------------" + this.combinationtype[(i - 1)]);
/*  456 */                   if (this.combinationtype[(i - 1)].equals("01")) {
/*  457 */                     System.out.println("\u6B64\u65F6\u4E3A\u4FDD\u989D\u7684\u503C++++++++++");
/*  458 */                     this.combinationmoney[(i - 1)] = (polsetinfo.get(i + 1).getAmnt() < 0.0D ? null : decimalFormat.format(polsetinfo.get(i + 1).getAmnt()));
/*  459 */                     System.out.println("\u6B64\u65F6\u4FDD\u989D======" + this.combinationmoney[(i - 1)]);
/*  460 */                   } else if (this.combinationtype[(i - 1)].equals("02")) {
/*  461 */                     System.out.println("\u6B64\u65F6\u4E3A\u4FDD\u8D39\u7684\u503C++++++++++");
/*  462 */                     this.combinationmoney[(i - 1)] = (polsetinfo.get(i + 1).getPrem() < 0.0D ? null : decimalFormat.format(polsetinfo.get(i + 1).getPrem()));
/*  463 */                     System.out.println("\u6B64\u65F6\u4FDD\u8D39======" + this.combinationmoney[(i - 1)]);
/*      */                   } else {
/*  465 */                     System.out.println("\u53D6\u7684\u662F\u73B0\u5728\u7684money\u503C--------");
/*  466 */                     this.combinationmoney[(i - 1)] = null;
/*      */                   }
/*  468 */                   System.out.println("\u521D\u59CB\u5316\u7EC4\u5408\u9669\u9644\u9669==================\u4FDD\u989D\u6216\u8005\u4FDD\u8D39---------------" + this.combinationmoney[(i - 1)]);
/*      */                 }
/*      */ 
/*      */               }
/*      */ 
/*      */             }
/*      */ 
/*  477 */             if ((this.contSchema.getState().equals("03")) || (this.contSchema.getState().equals("05")) || (this.contSchema.getState().equals("06")) || 
/*  478 */               (this.contSchema.getState().equals("07")))
/*      */             {
/*  480 */               for (int i = 1; i <= polsetinfo.size(); i++) {
/*  481 */                 LNPPolBean temp = new LNPPolBean();
/*  482 */                 LNPPolSchema schema = polsetinfo.get(i);
/*  483 */                 temp.setSchema(schema, "Z");
/*      */ 
/*  486 */                 this.cbtlnpList.add(temp);
/*      */               }
/*  488 */               this.sumprem = decimalFormat.format(polsetinfo.get(1).getSumPrem());
/*      */             }
/*  490 */             this.payintv = Integer.valueOf(polsetinfo.get(1).getPayIntv());
/*  491 */             this.bonusgetmode = this.bonusInfoSchema.getBonusWay();
/*  492 */             this.overflowpremium = this.bonusInfoSchema.getP1();
/*  493 */             this.overduepremium = this.bonusInfoSchema.getP2();
/*  494 */             this.annuityfrequency = polsetinfo.get(1).getStandbyFlag3();
/*  495 */             this.deadgetmode = polsetinfo.get(1).getDeadGetMode();
/*      */           }
/*  497 */           else if (polsetinfo.get(1).getKindCode().equals("04")) {
/*  498 */             System.out.println("\u5E74\u91D1\u8F6C\u6362\u9669\u65F6\u8FDB\u5165---------------");
/*  499 */             this.poltype = "04";
/*  500 */             session.setAttribute("saleChannel", polsetinfo.get(1).getUWTime());
/*  501 */             for (int i = 1; i <= polsetinfo.size(); i++) {
/*  502 */               if (("2".equals(polsetinfo.get(i).getRnewFlag())) && ("M".equals(polsetinfo.get(i).getSubFlag()))) {
/*  503 */                 this.yearmoneychangeriskcode = polsetinfo.get(i).getRiskVersion();
/*      */ 
/*  505 */                 if ((turnNullToString(polsetinfo.get(i).getPremToAmnt()).equals("")) && 
/*  506 */                   ("0".equals(polsetinfo.get(i).getPayLocation()))) {
/*  507 */                   this.yearmoneychangeyears = "0";
/*      */                 }
/*  509 */                 else if ((turnNullToString(polsetinfo.get(i).getPremToAmnt()).equals("")) || 
/*  510 */                   (turnNullToString(polsetinfo.get(i).getPayLocation()).equals(""))) {
/*  511 */                   this.yearmoneychangeyears = "";
/*      */                 }
/*  513 */                 else if ((polsetinfo.get(i).getPremToAmnt().equals("A")) && 
/*  514 */                   (Integer.parseInt(polsetinfo.get(i).getPayLocation()) != SpecialProductFun.getRiskPro(polsetinfo.get(i).getRiskCode()))) {
/*  515 */                   this.yearmoneychangeyears = ("T" + polsetinfo.get(i).getPayLocation());
/*      */                 }
/*  517 */                 else if ((polsetinfo.get(i).getPremToAmnt().equals("A")) && 
/*  518 */                   (Integer.parseInt(polsetinfo.get(i).getPayLocation()) == SpecialProductFun.getRiskPro(polsetinfo.get(i).getRiskCode()))) {
/*  519 */                   this.yearmoneychangeyears = "\u7EC8\u8EAB";
/*      */                 }
/*  521 */                 else if (polsetinfo.get(i).getPremToAmnt().equals("Y")) {
/*  522 */                   this.yearmoneychangeyears = polsetinfo.get(i).getPayLocation();
/*      */                 }
/*  524 */                 System.out.println("\u7ED3\u675F\u4FDD\u969C\u671F");
/*      */ 
/*  526 */                 if ((turnNullToString(polsetinfo.get(i).getAcciYearFlag()).equals("")) || 
/*  527 */                   (turnNullToString(polsetinfo.get(i).getPayMode()).equals(""))) {
/*  528 */                   this.yearmoneychangepayyears = "";
/*      */                 }
/*  530 */                 else if (polsetinfo.get(i).getAcciYearFlag().equals("A")) {
/*  531 */                   this.yearmoneychangepayyears = ("T" + polsetinfo.get(i).getPayMode());
/*      */                 }
/*  533 */                 else if ((polsetinfo.get(i).getAcciYearFlag().equals("Y")) && 
/*  534 */                   (polsetinfo.get(i).getPayMode().equals("1000"))) {
/*  535 */                   this.yearmoneychangepayyears = "0";
/*      */                 }
/*  537 */                 else if ((polsetinfo.get(i).getAcciYearFlag().equals("Y")) && 
/*  538 */                   (!polsetinfo.get(i).getPayMode().equals("1000"))) {
/*  539 */                   this.yearmoneychangepayyears = polsetinfo.get(i).getPayMode();
/*      */                 }
/*  541 */                 System.out.println("\u7ED3\u675F\u7F34\u8D39\u671F");
/*      */ 
/*  543 */                 if ((polsetinfo.get(i).getRemark() == null) || ("".equals(polsetinfo.get(i).getRemark())))
/*  544 */                   this.yearmoneychangemoney = null;
/*      */                 else {
/*  546 */                   this.yearmoneychangemoney = polsetinfo.get(i).getRemark();
/*      */                 }
/*  548 */                 if ("M".equals(polsetinfo.get(i).getSubFlag())) {
/*  549 */                   this.yearmoneychangegetyear = polsetinfo.get(i).getGetYear();
/*      */                 }
/*  551 */                 this.salechannel = polsetinfo.get(i).getUWTime();
/*      */               }
/*      */             }
/*  554 */             if ((this.contSchema.getState().equals("03")) || (this.contSchema.getState().equals("05")) || (this.contSchema.getState().equals("06")) || 
/*  555 */               (this.contSchema.getState().equals("07"))) {
/*  556 */               for (int i = 1; i <= polsetinfo.size(); i++) {
/*  557 */                 LNPPolBean temp = new LNPPolBean();
/*  558 */                 LNPPolSchema schema = polsetinfo.get(i);
/*  559 */                 temp.setSchema(schema, "N");
/*  560 */                 this.ymclnpList.add(temp);
/*      */               }
/*  562 */               this.sumprem = decimalFormat.format(polsetinfo.get(1).getSumPrem());
/*      */             }
/*  564 */             this.payintv = Integer.valueOf(polsetinfo.get(1).getPayIntv());
/*  565 */             this.bonusgetmode = this.bonusInfoSchema.getBonusWay();
/*  566 */             this.overflowpremium = this.bonusInfoSchema.getP1();
/*  567 */             this.overduepremium = this.bonusInfoSchema.getP2();
/*  568 */             this.annuityfrequency = polsetinfo.get(1).getStandbyFlag3();
/*  569 */             this.deadgetmode = polsetinfo.get(1).getDeadGetMode();
/*      */           }
/*      */ 
/*  573 */           this.infoSource = "modify";
/*      */         }
/*      */         else {
/*  576 */           this.infoSource = "add";
/*      */         }
/*  578 */         System.out.println("\u5F53\u524D\u662F\u5426\u53EF\u7F16\u8F91\u7684\u72B6\u6001======" + this.editFlag);
/*  579 */         session.setAttribute("RelFlag", Boolean.valueOf(this.editFlag));
/*      */ 
/*  581 */         System.out.println("-------------------start init union others policy ------------------------------");
/*  582 */         this.relationDeal = new BankRelationContNo();
/*  583 */         this.relationDeal.initData();
/*      */       } else {
/*  585 */         this.infoSource = "undo";
/*  586 */         this.editFlag = false;
/*  587 */         buildError("\u5168\u5C40\u6295\u4FDD\u4E66\u4FE1\u606F\u7F3A\u5931!");
/*      */       }
/*      */     } catch (RuntimeException e) {
/*  590 */       turnCurrPolicyLockFlag(null, this.contNo, "unlock");
/*  591 */       e.printStackTrace();
/*  592 */       this.message = "\u6295\u4FDD\u4E8B\u9879\u521D\u59CB\u5316\u9519\u8BEF\uFF01";
/*  593 */       this.operateResult = false;
/*      */     }
/*      */   }
/*      */ 
/*      */   public void getRiskType() {
/*  598 */     System.out.println("\u5F53\u524Drisktype\u7684\u503C=====" + this.poltype);
/*  599 */     this.poltype = this.radiotype;
/*      */   }
/*      */ 
/*      */   private boolean getInfoFromSession(HttpSession session)
/*      */   {
/*  607 */     boolean flag = false;
/*      */     try {
/*  609 */       if (session == null) session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*  610 */       this.tempGI = ((IGlobalInput)session.getAttribute("NPGI"));
/*  611 */       if (((String)session.getAttribute("ContNo") != null) && 
/*  612 */         (!((String)session.getAttribute("ContNo")).equals(""))) {
/*  613 */         this.contNo = ((String)session.getAttribute("ContNo"));
/*  614 */         waitPolicyCommited(session, this.contNo);
/*  615 */         turnCurrPolicyLockFlag(session, this.contNo, "lock");
/*  616 */         flag = true;
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  620 */       turnCurrPolicyLockFlag(session, this.contNo, "unlock");
/*  621 */       flag = false;
/*      */     }
/*  623 */     return flag;
/*      */   }
/*      */ 
/*      */   public void deldata()
/*      */   {
/*  632 */     this.message = new String();
/*  633 */     System.out.println("\u6E05\u9664\u5217\u8868\u4FE1\u606F");
/*  634 */     this.type = new String[30];
/*  635 */     this.lnpList.clear();
/*  636 */     this.cbtlnpList.clear();
/*  637 */     this.vulinvestmentList.clear();
/*  638 */     this.vulsize = this.vulinvestmentList.size();
/*      */ 
/*  640 */     System.out.println("\u8F6C\u6362\u9669\u79CD\uFF0C\u8FDB\u884C\u6570\u636E\u5220\u9664\u64CD\u4F5C--------------");
/*      */ 
/*  645 */     this.contSchema = getMyLNPContByContNo(this.contNo);
/*  646 */     LNPPolSet polsetbase = getPolByContNo(this.contNo);
/*  647 */     this.investSchema = getInvestmentSchemaByContNo(this.contNo);
/*  648 */     this.bonusInfoSchema = getBonusSchemaByContNo(this.contNo);
/*  649 */     LNPInvestmentAccountInfoSet accountSet = getAccountSetByContNo(this.contNo);
/*      */ 
/*  651 */     String date = PubFun.getCurrentDate();
/*  652 */     String time = PubFun.getCurrentTime();
/*      */ 
/*  655 */     this.contSchema.setInputOperator(this.tempGI.Operator);
/*  656 */     this.contSchema.setModifyDate(date);
/*  657 */     this.contSchema.setModifyTime(time);
/*      */ 
/*  660 */     BankOperateDeal stateOperate = new BankOperateDeal();
/*  661 */     List stateList = stateOperate.changeMsgToModify(this.contSchema.getState(), this.contSchema.getEditstate(), this.tempGI.LNPRole);
/*  662 */     if ((polsetbase.size() > 0) && (!polsetbase.get(1).getKindCode().equals(this.poltype))) {
/*  663 */       if (stateList.size() > 0) {
/*  664 */         System.out.println("\u5F53\u524D\u9669\u79CD\u7C7B\u578B\uFF1A" + this.poltype + "\u5E93\u4E2D\u7C7B\u578B:" + polsetbase.get(1).getKindCode());
/*  665 */         System.out.println("------------------------------------------------\u56E0\u4E3A\u9669\u79CD\u5207\u6362,\u5C06\u56DE\u6EDA\u4FDD\u5355\u72B6\u6001\u503C02\u5F85\u5BA1\u6838\u72B6\u6001---------");
/*  666 */         this.contSchema.setState((String)stateList.get(0));
/*  667 */         this.contSchema.setEditstate((String)stateList.get(1));
/*  668 */       } else if ("01".equals(this.contSchema.getState()))
/*      */       {
/*  670 */         String editState = stateOperate.updateEditStateUNDone(this.contSchema.getEditstate(), 2);
/*  671 */         this.contSchema.setEditstate(editState);
/*  672 */         System.out.println("cureditsate:" + editState + "<------------------------------------------------\u56E0\u4E3A\u9669\u79CD\u5207\u6362,state=01 \u65F6\uFF0Ceditsate=11xxxxxx \u65F6\u8F6C\u6362\u9669\u79CD\u65F6\u9700\u8981editstate=10xxxxxx---------");
/*      */       }
/*      */     }
/*  675 */     System.out.println("\u5355\u72B6\u6001state :" + this.contSchema.getState() + "|\u4EE3\u7406\u4EBA\u6743\u9650\u7C7B\u578Beditstate:" + this.contSchema.getEditstate());
/*  676 */     PubSubmit ps = new PubSubmit();
/*  677 */     MMap map = new MMap();
/*      */ 
/*  679 */     map.put(this.contSchema, "UPDATE");
/*  680 */     map.put(polsetbase, "DELETE");
/*  681 */     map.put(this.bonusInfoSchema, "DELETE");
/*  682 */     map.put(this.investSchema, "DELETE");
/*  683 */     map.put(accountSet, "DELETE");
/*  684 */     VData vd = new VData();
/*  685 */     vd.add(map);
/*  686 */     if (!ps.submitData(vd, "")) {
/*  687 */       this.message = "\u8F6C\u6362\u6295\u4FDD\u4E8B\u9879\u9669\u79CD\u7C7B\u578B\u65F6\u5220\u9664\u539F\u6570\u636E\u5E93\u4E2D\u7684\u9669\u79CD\u4FE1\u606F\u5931\u8D25\uFF01";
/*  688 */       this.operateResult = false;
/*  689 */       System.out.println("\u8F6C\u6362\u6295\u4FDD\u4E8B\u9879\u9669\u79CD\u7C7B\u578B\u65F6\u5220\u9664\u539F\u6570\u636E\u5E93\u4E2D\u7684\u9669\u79CD\u4FE1\u606F\u5931\u8D25\uFF01");
/*      */     }
/*      */     else {
/*  692 */       this.sumprem = "";
/*  693 */       this.message = "\u8F6C\u6362\u6295\u4FDD\u4E8B\u9879\u9669\u79CD\u7C7B\u578B\u65F6\u5220\u9664\u539F\u6570\u636E\u5E93\u4E2D\u7684\u9669\u79CD\u4FE1\u606F\u6210\u529F\uFF01";
/*  694 */       this.operateResult = true;
/*  695 */       System.out.println("\u8F6C\u6362\u6295\u4FDD\u4E8B\u9879\u9669\u79CD\u7C7B\u578B\u65F6\u5220\u9664\u539F\u6570\u636E\u5E93\u4E2D\u7684\u9669\u79CD\u4FE1\u606F\u6210\u529F\uFF01");
/*      */     }
/*      */   }
/*      */ 
/*      */   public void findAccountCode()
/*      */   {
/*  707 */     System.out.println("\u5F00\u59CB\u67E5\u627E\u57FA\u91D1\u4FE1\u606F");
/*  708 */     String sql = "select FundAccountCode,FundAccountName from MRiskFundAccount where RiskCode='" + this.vulriskcode + "'";
/*      */ 
/*  710 */     ExeSQL tExeSQL = new ExeSQL();
/*      */ 
/*  712 */     SSRS tSRS = tExeSQL.execSQL(sql);
/*      */ 
/*  714 */     if (tSRS.MaxRow > 0) {
/*  715 */       this.vulinvestmentList = new ArrayList();
/*      */ 
/*  717 */       for (int i = 1; i <= tSRS.MaxRow; i++)
/*      */       {
/*  719 */         LNPVulBean vulBean = new LNPVulBean();
/*  720 */         vulBean.setAccountCode(tSRS.GetText(i, 1));
/*  721 */         vulBean.setAccountName(tSRS.GetText(i, 2));
/*      */ 
/*  723 */         vulBean.setAccountRate("0");
/*      */ 
/*  725 */         this.vulinvestmentList.add(vulBean);
/*      */       }
/*      */     }
/*      */     else {
/*  729 */       System.out.println("\u5F53\u524D\u9669\u79CD\u65E0\u57FA\u91D1\u6570\u636E");
/*  730 */       this.vulinvestmentList.clear();
/*      */     }
/*  732 */     this.vulsize = this.vulinvestmentList.size();
/*      */   }
/*      */ 
/*      */   public List<LNPVulBean> getInvestList(String code, String conNumber)
/*      */   {
/*  743 */     String sql = "select InvestAccountCode,Varc1,InvestAccountRate*100 from LNPInvestmentAccountInfo where contno='" + conNumber + "' and riskcode='" + code + "'";
/*  744 */     ExeSQL tExeSQL = new ExeSQL();
/*  745 */     SSRS tSRS = tExeSQL.execSQL(sql);
/*  746 */     if (tSRS.MaxRow > 0) {
/*  747 */       List vulBeanList = new ArrayList();
/*  748 */       for (int i = 1; i <= tSRS.MaxRow; i++) {
/*  749 */         LNPVulBean vulBean = new LNPVulBean();
/*  750 */         vulBean.setAccountCode(tSRS.GetText(i, 1));
/*  751 */         vulBean.setAccountName(tSRS.GetText(i, 2));
/*  752 */         vulBean.setAccountRate(tSRS.GetText(i, 3));
/*  753 */         vulBeanList.add(vulBean);
/*      */       }
/*  755 */       return vulBeanList;
/*      */     }
/*  757 */     System.out.println("\u6295\u8D44\u8868\u4E2D\u65E0\u4FE1\u606F\u8FD4\u56DEnull");
/*  758 */     return null;
/*      */   }
/*      */ 
/*      */   public void checkrate()
/*      */   {
/*  767 */     System.out.println("\u5F00\u59CB\u6821\u9A8C\u6295\u8D44\u767E\u5206\u6BD4");
/*  768 */     System.out.println("vulinvestmentList\u7684size()==========" + this.vulinvestmentList.size());
/*      */ 
/*  770 */     double value = 0.0D;
/*  771 */     for (int i = 0; i < this.vulinvestmentList.size(); i++) {
/*  772 */       value += Double.valueOf(((LNPVulBean)this.vulinvestmentList.get(i)).getAccountRate()).doubleValue();
/*      */     }
/*  774 */     System.out.println("value========================" + value);
/*  775 */     if (value > 100.0D)
/*      */     {
/*  777 */       this.vullistflag = false;
/*      */     }
/*  779 */     else this.vullistflag = true;
/*      */   }
/*      */ 
/*      */   public void savePol()
/*      */   {
/*  787 */     System.out.println("\u8C03\u7528 savePol()\u65B9\u6CD5-------");
/*  788 */     System.out.println("\u9669\u79CD\u7C7B\u578B  1-\u4F20\u7EDF\u9669\uFF0C2-VUL\uFF0C3-\u7EC4\u5408\u9669\uFF0C4-\u5E74\u9669===" + this.poltype);
/*  789 */     System.out.println("\u672C\u6B21\u6295\u4FDD\u4E8B\u9879\u64CD\u4F5C\u52A8\u4F5CinfoSource====" + this.infoSource);
/*  790 */     this.operateResult = true;
/*      */ 
/*  798 */     label512: 
/*      */     try { this.contSchema = getMyLNPContByContNo(this.contNo);
/*  799 */       System.out.println("\u5F00\u59CB\u6E05\u9664\u5173\u8054\u7EC4----------");
/*  800 */       if ((this.contSchema != null) && (this.contSchema.getAgentCode1() != null) && (!this.contSchema.getAgentCode1().equals(""))) {
/*  801 */         String sql = "select count(*) from lnpcont where agentcode1='" + this.contSchema.getAgentCode1() + "'";
/*  802 */         ExeSQL tExeSQL = new ExeSQL();
/*  803 */         SSRS tSRS = tExeSQL.execSQL(sql);
/*  804 */         String number = tSRS.GetText(1, 1);
/*  805 */         if (number.equals("1")) {
/*  806 */           this.contSchema.setAgentCode1("");
/*  807 */           PubSubmit ps = new PubSubmit();
/*  808 */           MMap map = new MMap();
/*      */ 
/*  810 */           map.put(this.contSchema, "UPDATE");
/*  811 */           VData vd = new VData();
/*  812 */           vd.add(map);
/*  813 */           if (!ps.submitData(vd, "")) {
/*  814 */             this.message = "\u6E05\u9664\u5173\u8054\u7EC4\u5931\u8D25\uFF01";
/*  815 */             this.operateResult = false;
/*  816 */             System.out.println("\u6E05\u9664\u5173\u8054\u7EC4\u5931\u8D25\uFF01");
/*      */           }
/*      */           else {
/*  819 */             this.message = "\u6E05\u9664\u5173\u8054\u7EC4\u6210\u529F\uFF01";
/*  820 */             this.operateResult = true;
/*  821 */             System.out.println("\u6E05\u9664\u5173\u8054\u7EC4\u6210\u529F\uFF01");
/*      */           }
/*      */         }
/*      */       } else {
/*  825 */         System.out.println("\u6B64\u65F6\u4E0D\u9700\u8981\u6E05\u9664\u5173\u8054\u7EC4");
/*      */       }
/*  827 */       System.out.println("\u5F00\u59CB\u4FDD\u5B58\u9669\u79CD\u4FE1\u606F");
/*      */ 
/*  829 */       if (this.editFlag) {
/*  830 */         if (("undo".equals(this.infoSource)) || (this.contSchema == null) || (this.infoSource == null) || ("".equals(this.infoSource))) {
/*  831 */           this.operateResult = true;
/*  832 */           return;
/*      */         }
/*  834 */         if ("add".equals(this.infoSource)) {
/*  835 */           System.out.println("\u8FDB\u5165\u65B0\u589E\u4FE1\u606F\u63A5\u53E3------------------");
/*  836 */           if (addInsuredItem()) {
/*  837 */             this.operateResult = true;
/*      */           }
/*      */         }
/*  840 */         if ("modify".equals(this.infoSource)) {
/*  841 */           System.out.println("\u8FDB\u5165\u4FEE\u6539\u4FE1\u606F\u63A5\u53E3------------------");
/*  842 */           if (modifyInsuredItem()) {
/*  843 */             this.operateResult = true;
/*      */ 
/*  846 */             break label512;
/*      */           }
/*      */         }
/*      */       } else {
/*  849 */         System.out.println("\u6B64\u65F6\u4FDD\u5355\u4E0D\u53EF\u7F16\u8F91\uFF0C\u4E0D\u5BF9\u6570\u636E\u5E93\u8FDB\u884C\u64CD\u4F5C");
/*      */       }
/*      */     }
/*      */     catch (RuntimeException e)
/*      */     {
/*  854 */       e.printStackTrace();
/*  855 */       this.message = "\u6295\u4FDD\u4E8B\u9879\u4FE1\u606F\u4FDD\u5B58\u5931\u8D25\uFF01";
/*  856 */       this.operateResult = false;
/*      */     } finally {
/*  858 */       turnCurrPolicyLockFlag(null, this.contNo, "unlock");
/*      */     }
/*      */   }
/*      */ 
/*      */   private boolean modifyInsuredItem()
/*      */   {
/*  868 */     boolean flag = false;
/*      */ 
/*  879 */     if (this.poltype.equals("01"))
/*      */     {
/*  881 */       flag = saveType0ne();
/*      */     }
/*      */ 
/*  884 */     if (this.poltype.equals("02")) {
/*  885 */       flag = saveTypeTwo();
/*      */     }
/*  887 */     if (this.poltype.equals("03")) {
/*  888 */       flag = saveTypeThree();
/*      */     }
/*  890 */     if (this.poltype.equals("04")) {
/*  891 */       flag = saveTypeFour();
/*      */     }
/*      */ 
/*  894 */     return flag;
/*      */   }
/*      */ 
/*      */   private boolean addInsuredItem()
/*      */   {
/*  901 */     boolean flag = false;
/*  902 */     if (this.poltype.equals("01")) {
/*  903 */       flag = saveType0ne();
/*      */     }
/*  905 */     if (this.poltype.equals("02")) {
/*  906 */       flag = saveTypeTwo();
/*      */     }
/*  908 */     if (this.poltype.equals("03")) {
/*  909 */       flag = saveTypeThree();
/*      */     }
/*  911 */     if (this.poltype.equals("04")) {
/*  912 */       flag = saveTypeFour();
/*      */     }
/*  914 */     if (this.poltype.equals("")) {
/*  915 */       this.message = "\u8BF7\u9009\u62E9\u9669\u79CD\uFF01";
/*  916 */       flag = false;
/*      */     }
/*  918 */     return flag;
/*      */   }
/*      */ 
/*      */   private LNPContSchema getMyLNPContByContNo(String contNo2)
/*      */   {
/*  926 */     System.out.println("\u5F00\u59CB\u521D\u59CB\u5316lnpcont\u4FE1\u606F");
/*  927 */     PolicyMainInfo mainInfo = new PolicyMainInfo();
/*  928 */     LNPContSchema aLNPContSchema = mainInfo.getContByContNo(contNo2);
/*      */ 
/*  930 */     return aLNPContSchema;
/*      */   }
/*      */ 
/*      */   public LNPPolSet getPolByContNo(String contNo)
/*      */   {
/*  943 */     LNPPolDB db = new LNPPolDB();
/*  944 */     db.setContNo(contNo);
/*  945 */     LNPPolSet polset1 = db.query();
/*  946 */     return polset1;
/*      */   }
/*      */ 
/*      */   private LNPPolSchema getPolSchemaByContNo(String contNo) {
/*  950 */     LNPPolDB db = new LNPPolDB();
/*  951 */     db.setContNo(contNo);
/*      */ 
/*  953 */     if (db.getInfo()) {
/*  954 */       return db.getSchema();
/*      */     }
/*  956 */     return null;
/*      */   }
/*      */ 
/*      */   private LNPBonusInfoSchema getBonusSchemaByContNo(String contNo)
/*      */   {
/*  961 */     System.out.println("\u5F00\u59CB\u83B7\u53D6\u7EA2\u5229\u4FE1\u606F");
/*  962 */     LNPBonusInfoDB db = new LNPBonusInfoDB();
/*  963 */     db.setContNo(contNo);
/*  964 */     LNPBonusInfoSet infoset = db.query();
/*  965 */     System.out.println("\u7EA2\u5229\u4FE1\u606F\u7684size()===" + infoset.size());
/*  966 */     if (infoset.size() > 0)
/*      */     {
/*  968 */       infoset.get(1);
/*  969 */       return infoset.get(1);
/*      */     }
/*  971 */     return null;
/*      */   }
/*      */ 
/*      */   private LNPInvestmentInfoSchema getInvestmentSchemaByContNo(String contNo)
/*      */   {
/*  976 */     System.out.println("\u5F00\u59CB\u83B7\u53D6\u6708\u6708\u52A0\u4FE1\u606F");
/*  977 */     LNPInvestmentInfoDB db = new LNPInvestmentInfoDB();
/*  978 */     db.setContNo(contNo);
/*  979 */     LNPInvestmentInfoSet infoset = db.query();
/*  980 */     if (infoset.size() > 0)
/*      */     {
/*  982 */       infoset.get(1);
/*  983 */       return infoset.get(1);
/*      */     }
/*      */ 
/*  986 */     return null;
/*      */   }
/*      */ 
/*      */   private LNPInvestmentAccountInfoSet getAccountSetByContNo(String contNumber)
/*      */   {
/*  991 */     System.out.println("\u5F00\u59CB\u83B7\u53D6\u6295\u8D44\u4FE1\u606F");
/*  992 */     LNPInvestmentAccountInfoDB db = new LNPInvestmentAccountInfoDB();
/*  993 */     db.setContNo(this.contNo);
/*  994 */     LNPInvestmentAccountInfoSet accountSet = db.query();
/*  995 */     return accountSet;
/*      */   }
/*      */ 
/*      */   private boolean saveType0ne()
/*      */   {
/* 1003 */     boolean flagone = false;
/* 1004 */     this.contSchema = getMyLNPContByContNo(this.contNo);
/* 1005 */     this.bonusInfoSchema = getBonusSchemaByContNo(this.contNo);
/* 1006 */     this.investSchema = getInvestmentSchemaByContNo(this.contNo);
/* 1007 */     LNPPolSet polsetbase = getPolByContNo(this.contNo);
/* 1008 */     LNPPolSet polsetpage = new LNPPolSet();
/* 1009 */     LNPBonusInfoSchema infoschema = new LNPBonusInfoSchema();
/* 1010 */     String date = PubFun.getCurrentDate();
/* 1011 */     String time = PubFun.getCurrentTime();
/* 1012 */     SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
/* 1013 */     boolean hasMRiskFlag = false;
/* 1014 */     String mRiskCode = "";
/* 1015 */     for (int i = 0; i < 30; i++) {
/* 1016 */       if ((this.riskcode[i] != null) && (!this.riskcode[i].equals(""))) {
/* 1017 */         this.polSchema = new LNPPolSchema();
/* 1018 */         this.polSchema.setKindCode(this.poltype);
/* 1019 */         this.polSchema.setRiskCode(this.riskcode[i]);
/*      */ 
/* 1021 */         if (this.years[i].startsWith("\u7EC8\u8EAB")) {
/* 1022 */           this.polSchema.setInsuYear(SpecialProductFun.getRiskPro(this.polSchema.getRiskCode()));
/* 1023 */           this.polSchema.setInsuYearFlag("A");
/*      */         }
/* 1025 */         if ((this.years[i].startsWith("T")) || (this.years[i].startsWith("t"))) {
/* 1026 */           this.polSchema.setInsuYear(this.years[i].replaceAll("^[Tt](\\d+)$", "$1"));
/* 1027 */           this.polSchema.setInsuYearFlag("A");
/*      */         }
/* 1029 */         if (this.years[i].matches("^[1-9][0-9]*$")) {
/* 1030 */           this.polSchema.setInsuYear(this.years[i].replace("", ""));
/* 1031 */           this.polSchema.setInsuYearFlag("Y");
/*      */         }
/* 1033 */         if ((this.years[i].equals("")) || (this.years[i] == null)) {
/* 1034 */           this.polSchema.setInsuYear(-1);
/* 1035 */           this.polSchema.setInsuYearFlag("");
/*      */         }
/* 1037 */         if (this.years[i].equals("0")) {
/* 1038 */           this.polSchema.setInsuYear("0");
/* 1039 */           this.polSchema.setInsuYearFlag("");
/*      */         }
/*      */ 
/* 1042 */         if (this.payyears[i].equals("0")) {
/* 1043 */           this.polSchema.setPayEndYear("1000");
/* 1044 */           this.polSchema.setPayEndYearFlag("Y");
/*      */         }
/* 1046 */         if ((this.payyears[i].startsWith("T")) || (this.payyears[i].startsWith("t"))) {
/* 1047 */           this.polSchema.setPayEndYear(this.payyears[i].replaceAll("^[Tt](\\d+)$", "$1"));
/* 1048 */           this.polSchema.setPayEndYearFlag("A");
/*      */         }
/* 1050 */         if (this.payyears[i].matches("^[1-9][0-9]*$")) {
/* 1051 */           this.polSchema.setPayEndYear(this.payyears[i].replace("", ""));
/* 1052 */           this.polSchema.setPayEndYearFlag("Y");
/* 1053 */         }if ((this.payyears[i].equals("")) || (this.payyears[i] == null)) {
/* 1054 */           this.polSchema.setPayEndYear(-1);
/* 1055 */           this.polSchema.setPayEndYearFlag("");
/*      */         }
/* 1057 */         this.polSchema.setUWCode(this.type[i]);
/* 1058 */         System.out.println("\u5F53\u524D\u7684type[i]\u503C======" + this.type[i]);
/* 1059 */         if (this.type[i].equals("01")) {
/* 1060 */           if ((this.money[i] == null) || (this.money[i].equals("")))
/*      */           {
/* 1062 */             this.polSchema.setAmnt(-1.0D);
/* 1063 */             this.polSchema.setPrem(-1.0D);
/*      */           }
/*      */           else {
/* 1066 */             this.polSchema.setAmnt(this.money[i]);
/* 1067 */             this.polSchema.setPrem(0.0D);
/*      */           }
/* 1069 */         } else if (this.type[i].equals("02")) {
/* 1070 */           if ((this.money[i] == null) || (this.money[i].equals("")))
/*      */           {
/* 1072 */             this.polSchema.setAmnt(-1.0D);
/* 1073 */             this.polSchema.setPrem(-1.0D);
/*      */           }
/*      */           else {
/* 1076 */             this.polSchema.setPrem(this.money[i]);
/* 1077 */             this.polSchema.setAmnt(0.0D);
/*      */           }
/*      */         } else {
/* 1080 */           this.polSchema.setAmnt(-1.0D);
/* 1081 */           this.polSchema.setPrem(-1.0D);
/*      */         }
/*      */ 
/* 1084 */         if (i == 0) {
/* 1085 */           if ((this.getyear == null) || (this.getyear.equals(""))) {
/* 1086 */             this.polSchema.setGetYear("-1");
/*      */           } else {
/* 1088 */             this.polSchema.setGetYear(this.getyear);
/* 1089 */             this.polSchema.setGetYearFlag("A");
/*      */           }
/* 1091 */           this.polSchema.setSubFlag("M");
/* 1092 */           hasMRiskFlag = true;
/* 1093 */           mRiskCode = this.polSchema.getRiskCode();
/*      */         } else {
/* 1095 */           this.polSchema.setGetYear("");
/* 1096 */           this.polSchema.setSubFlag("S");
/*      */         }
/*      */ 
/* 1101 */         this.polSchema.setPayIntv(this.payintv.intValue());
/* 1102 */         this.contSchema.setPayIntv(this.polSchema.getPayIntv());
/* 1103 */         this.polSchema.setDeadGetMode(this.deadgetmode);
/* 1104 */         this.polSchema.setStandbyFlag3(this.annuityfrequency);
/*      */ 
/* 1107 */         this.polSchema.setGrpContNo("00000000000000000000");
/* 1108 */         this.polSchema.setGrpPolNo("00000000000000000000");
/* 1109 */         this.polSchema.setContNo(this.contNo);
/* 1110 */         this.polSchema.setProposalContNo(this.contNo);
/* 1111 */         String tIndex = maxNoMap.CreateMaxNo("CustomerNo", "");
/* 1112 */         this.polSchema.setPolNo(tIndex);
/*      */ 
/* 1114 */         this.polSchema.setProposalNo(tIndex);
/* 1115 */         this.polSchema.setPrtNo("00000000000000000000");
/* 1116 */         this.polSchema.setContType("1");
/* 1117 */         this.polSchema.setManageCom(this.contSchema.getSignCom());
/*      */ 
/* 1119 */         this.polSchema.setMakeDate(date);
/* 1120 */         this.polSchema.setMakeTime(time);
/* 1121 */         this.polSchema.setModifyDate(date);
/* 1122 */         this.polSchema.setModifyTime(time);
/* 1123 */         this.polSchema.setOperator(this.tempGI.Operator);
/* 1124 */         polsetpage.add(this.polSchema);
/*      */       } else {
/* 1126 */         System.out.println("riskcode[" + i + "]\u6CA1\u6709\u6570\u636E");
/*      */       }
/*      */     }
/*      */ 
/* 1130 */     LNPInvestmentAccountInfoSet delInvestSet = new LNPInvestmentAccountInfoDB().executeQuery("select * from LNPInvestmentAccountInfo where ContNo='" + this.contNo + "'");
/* 1131 */     LNPInvestmentAccountInfoSet investSet = new LNPInvestmentAccountInfoSet();
/*      */ 
/* 1133 */     if (hasMRiskFlag) {
/* 1134 */       ExeSQL exeSQL = new ExeSQL();
/* 1135 */       SSRS ssrs = exeSQL.execSQL("select FundAccountCode,FundAccountName,p1 from MRiskFundAccount where RiskCode=ltrim(rtrim('" + mRiskCode + "'))");
/* 1136 */       if (ssrs.MaxRow > 0) {
/* 1137 */         System.out.println("-------------------->\u5F53\u524D\u4F20\u7EDF\u9669\u4E3B\u9669\u5B58\u5728\u5BF9\u5E94\u57FA\u91D1\u8D26\u6237\u4FE1\u606F<-------------------");
/* 1138 */         for (int i = 1; i <= ssrs.MaxRow; i++)
/*      */         {
/* 1140 */           LNPInvestmentAccountInfoSchema investSchema = new LNPInvestmentAccountInfoSchema();
/* 1141 */           investSchema.setRiskCode(mRiskCode);
/* 1142 */           investSchema.setInvestAccountCode(ssrs.GetText(i, 1));
/* 1143 */           investSchema.setVarc1(ssrs.GetText(i, 2));
/* 1144 */           investSchema.setInvestAccountRate(ssrs.GetText(i, 3));
/* 1145 */           investSchema.setContNo(this.contNo);
/* 1146 */           investSchema.setOperator(this.tempGI.Operator);
/* 1147 */           investSchema.setMakeDate(date);
/* 1148 */           investSchema.setMakeTime(time);
/* 1149 */           investSchema.setModifyDate(date);
/* 1150 */           investSchema.setModifyTime(time);
/* 1151 */           investSet.add(investSchema);
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/* 1156 */     infoschema.setGrpContNo("00000000000000000000");
/* 1157 */     infoschema.setContNo(this.contNo);
/* 1158 */     infoschema.setProposalContNo(this.contNo);
/* 1159 */     infoschema.setPrtNo("00000000000000000000");
/* 1160 */     infoschema.setBonusWay(this.bonusgetmode);
/* 1161 */     infoschema.setP1(this.overflowpremium);
/* 1162 */     infoschema.setP2(this.overduepremium);
/* 1163 */     infoschema.setOperator(this.tempGI.Operator);
/* 1164 */     infoschema.setMakeDate(date);
/* 1165 */     infoschema.setMakeTime(time);
/* 1166 */     infoschema.setModifyDate(date);
/* 1167 */     infoschema.setModifyTime(time);
/*      */ 
/* 1172 */     this.allCompelte = checkAllCompelte(polsetpage, infoschema, null);
/*      */ 
/* 1174 */     boolean changeStateflag = false;
/* 1175 */     BankOperateDeal stateOperate = new BankOperateDeal();
/*      */ 
/* 1177 */     if (this.allCompelte)
/*      */     {
/* 1179 */       List stateList = stateOperate.infoOprate(this.contSchema.getState(), this.contSchema.getEditstate(), "modify", "02");
/* 1180 */       this.contSchema.setState((String)stateList.get(0));
/* 1181 */       this.contSchema.setEditstate((String)stateList.get(1));
/* 1182 */     } else if ("01".equals(this.contSchema.getState())) {
/* 1183 */       String editState = stateOperate.updateEditStateUNDone(this.contSchema.getEditstate(), 2);
/* 1184 */       this.contSchema.setEditstate(editState);
/*      */     }
/* 1186 */     System.out.println("xboy---------------------------------------------\u4F20\u7EDF\u9669\uFF0C\u5F53\u524Dstate|editstate\uFF1A" + this.contSchema.getState() + "| " + this.contSchema.getEditstate());
/*      */ 
/* 1192 */     if ((polsetpage.size() != 0) && (!polsetpage.get(1).getRiskCode().equals("")) && (polsetpage.size() != polsetbase.size()))
/*      */     {
/* 1194 */       List stateList = stateOperate.changeMsgToModify(this.contSchema.getState(), this.contSchema.getEditstate(), this.tempGI.LNPRole);
/* 1195 */       if (stateList.size() > 0) {
/* 1196 */         System.out.println("-------\u56E0\u4E3A\u6709\u4FDD\u5355\u4FE1\u606F\u88AB\u4FEE\u6539,\u5C06\u56DE\u6EDA\u4FDD\u5355\u72B6\u6001\u503C02\u5F85\u5BA1\u6838\u72B6\u6001---------");
/* 1197 */         changeStateflag = true;
/* 1198 */         this.contSchema.setState((String)stateList.get(0));
/* 1199 */         this.contSchema.setEditstate((String)stateList.get(1));
/*      */       } else {
/* 1201 */         System.out.println("\u5F53\u524D\u64CD\u4F5C\u4E0D\u9700\u8981\u8FDB\u884C\u72B6\u6001\u56DE\u6EDA");
/*      */       }
/*      */ 
/* 1204 */       this.contSchema.setInputOperator(this.tempGI.Operator);
/* 1205 */       this.contSchema.setModifyDate(date);
/* 1206 */       this.contSchema.setModifyTime(time);
/* 1207 */       PubSubmit ps = new PubSubmit();
/* 1208 */       MMap map = new MMap();
/* 1209 */       map.put(delInvestSet, "DELETE");
/* 1210 */       map.put(investSet, "DELETE&INSERT");
/* 1211 */       map.put(polsetbase, "DELETE");
/* 1212 */       map.put(this.bonusInfoSchema, "DELETE");
/* 1213 */       map.put(this.investSchema, "DELETE");
/* 1214 */       map.put(polsetpage, "INSERT");
/* 1215 */       map.put(infoschema, "INSERT");
/* 1216 */       map.put(this.contSchema, "UPDATE");
/* 1217 */       VData vd = new VData();
/* 1218 */       vd.add(map);
/* 1219 */       if (!ps.submitData(vd, "")) {
/* 1220 */         this.message = "\u6295\u4FDD\u4E8B\u9879\u4FE1\u606F\u4FDD\u5B58\u9519\u8BEF\uFF01";
/* 1221 */         System.out.println("\u6295\u4FDD\u4E8B\u9879\u4FDD\u5B58\u5931\u8D25");
/* 1222 */         flagone = false;
/*      */       } else {
/*      */         try {
/* 1225 */           flagone = true;
/* 1226 */           this.infoSource = "modify";
/* 1227 */           this.policyState = new BankPolicyState();
/* 1228 */           if (changeStateflag) {
/* 1229 */             this.policyState.savePolicyState(this.contSchema.getContNo(), this.contSchema.getState(), "3", date, time);
/*      */           }
/* 1231 */           this.message = "\u6295\u4FDD\u4E8B\u9879\u4FE1\u606F\u4FDD\u5B58\u6210\u529F\uFF01";
/* 1232 */           System.out.println("\u4FDD\u5B58\u6210\u529F");
/*      */         } catch (Exception e) {
/* 1234 */           this.message = "\u64CD\u4F5C\u8BB0\u5F55\u63A5\u53E3\u51FA\u95EE\u9898\u4E86";
/* 1235 */           System.out.println("\u64CD\u4F5C\u8BB0\u5F55\u63A5\u53E3\u51FA\u95EE\u9898\u4E86");
/* 1236 */           e.printStackTrace();
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/* 1241 */     if ((polsetpage.size() != 0) && (polsetbase.size() != 0) && (polsetpage.size() == polsetbase.size())) {
/* 1242 */       boolean flags = false;
/* 1243 */       for (int i = 1; i <= polsetbase.size(); i++) {
/* 1244 */         if ((turnNullToString(polsetpage.get(i).getRiskCode()).equals(turnNullToString(polsetbase.get(i).getRiskCode()))) && 
/* 1245 */           (turnNullToString(Integer.valueOf(polsetpage.get(i).getInsuYear())).equals(turnNullToString(Integer.valueOf(polsetbase.get(i).getInsuYear())))) && 
/* 1246 */           (turnNullToString(polsetpage.get(i).getInsuYearFlag()).equals(turnNullToString(polsetbase.get(i).getInsuYearFlag()))) && 
/* 1247 */           (turnNullToString(Integer.valueOf(polsetpage.get(i).getPayEndYear())).equals(turnNullToString(Integer.valueOf(polsetbase.get(i).getPayEndYear())))) && 
/* 1248 */           (turnNullToString(polsetpage.get(i).getPayEndYearFlag()).equals(turnNullToString(polsetbase.get(i).getPayEndYearFlag()))) && 
/* 1249 */           (turnNullToString(polsetpage.get(i).getUWCode()).equals(turnNullToString(polsetbase.get(i).getUWCode()))) && 
/* 1250 */           (!"01".equals(polsetpage.get(i).getUWCode()) ? 
/* 1251 */           turnNullToString(Double.valueOf(polsetpage.get(i).getPrem())).equals(turnNullToString(Double.valueOf(polsetbase.get(i).getPrem()))) : turnNullToString(Double.valueOf(polsetpage.get(i).getAmnt())).equals(turnNullToString(Double.valueOf(polsetbase.get(i).getAmnt())))) && 
/* 1252 */           (turnNullToString(Integer.valueOf(polsetpage.get(1).getGetYear())).equals(turnNullToString(Integer.valueOf(polsetbase.get(1).getGetYear())))) && 
/* 1253 */           (turnNullToString(Integer.valueOf(polsetpage.get(i).getPayIntv())).equals(turnNullToString(Integer.valueOf(polsetbase.get(i).getPayIntv())))) && 
/* 1254 */           (turnNullToString(polsetpage.get(i).getDeadGetMode()).equals(turnNullToString(polsetbase.get(i).getDeadGetMode()))) && 
/* 1255 */           (turnNullToString(polsetpage.get(i).getStandbyFlag3()).equals(turnNullToString(polsetbase.get(i).getStandbyFlag3()))) && 
/* 1256 */           (turnNullToString(infoschema.getBonusWay()).equals(turnNullToString(this.bonusInfoSchema.getBonusWay()))) && 
/* 1257 */           (turnNullToString(infoschema.getP1()).equals(turnNullToString(this.bonusInfoSchema.getP1()))) && 
/* 1258 */           (turnNullToString(infoschema.getP2()).equals(turnNullToString(this.bonusInfoSchema.getP2())))) {
/* 1259 */           flags = true;
/*      */         } else {
/* 1261 */           flags = false;
/* 1262 */           break;
/*      */         }
/*      */       }
/*      */ 
/* 1266 */       System.out.println("\u5F53\u524Dflags\u7684\u503C\u4E3A===" + flags);
/* 1267 */       if (!flags)
/*      */       {
/* 1270 */         List stateList = stateOperate.changeMsgToModify(this.contSchema.getState(), this.contSchema.getEditstate(), this.tempGI.LNPRole);
/* 1271 */         if (stateList.size() > 0) {
/* 1272 */           System.out.println("-------\u56E0\u4E3A\u6709\u4FDD\u5355\u4FE1\u606F\u88AB\u4FEE\u6539,\u5C06\u56DE\u6EDA\u4FDD\u5355\u72B6\u6001\u503C02\u5F85\u5BA1\u6838\u72B6\u6001---------");
/* 1273 */           changeStateflag = true;
/* 1274 */           this.contSchema.setState((String)stateList.get(0));
/* 1275 */           this.contSchema.setEditstate((String)stateList.get(1));
/*      */         } else {
/* 1277 */           System.out.println("\u5F53\u524D\u64CD\u4F5C\u4E0D\u9700\u8981\u8FDB\u884C\u72B6\u6001\u56DE\u6EDA");
/*      */         }
/*      */ 
/* 1280 */         this.contSchema.setInputOperator(this.tempGI.Operator);
/* 1281 */         this.contSchema.setModifyDate(date);
/* 1282 */         this.contSchema.setModifyTime(time);
/* 1283 */         PubSubmit ps = new PubSubmit();
/* 1284 */         MMap map = new MMap();
/* 1285 */         map.put(delInvestSet, "DELETE");
/* 1286 */         map.put(investSet, "DELETE&INSERT");
/* 1287 */         map.put(polsetbase, "DELETE");
/* 1288 */         map.put(this.bonusInfoSchema, "DELETE");
/* 1289 */         map.put(this.investSchema, "DELETE");
/* 1290 */         map.put(polsetpage, "INSERT");
/* 1291 */         map.put(infoschema, "INSERT");
/* 1292 */         map.put(this.contSchema, "UPDATE");
/* 1293 */         VData vd = new VData();
/* 1294 */         vd.add(map);
/* 1295 */         if (!ps.submitData(vd, "")) {
/* 1296 */           this.message = "\u6295\u4FDD\u4E8B\u9879\u4FE1\u606F\u4FDD\u5B58\u9519\u8BEF\uFF01";
/* 1297 */           System.out.println("\u6295\u4FDD\u4E8B\u9879\u4FDD\u5B58\u5931\u8D25");
/* 1298 */           flagone = false;
/*      */         } else {
/*      */           try {
/* 1301 */             flagone = true;
/* 1302 */             this.infoSource = "modify";
/* 1303 */             this.policyState = new BankPolicyState();
/* 1304 */             if (changeStateflag) {
/* 1305 */               this.policyState.savePolicyState(this.contSchema.getContNo(), this.contSchema.getState(), "3", date, time);
/*      */             }
/* 1307 */             this.message = "\u6295\u4FDD\u4E8B\u9879\u4FE1\u606F\u4FDD\u5B58\u6210\u529F\uFF01";
/* 1308 */             System.out.println("\u4FDD\u5B58\u6210\u529F");
/*      */           } catch (Exception e) {
/* 1310 */             this.message = "\u64CD\u4F5C\u8BB0\u5F55\u63A5\u53E3\u51FA\u95EE\u9898\u4E86";
/* 1311 */             System.out.println("\u64CD\u4F5C\u8BB0\u5F55\u63A5\u53E3\u51FA\u95EE\u9898\u4E86");
/* 1312 */             e.printStackTrace();
/*      */           }
/*      */         }
/*      */       } else {
/* 1316 */         System.out.println("\u672C\u6B21\u64CD\u4F5C\u6CA1\u6709\u4FEE\u6539\u6570\u636E");
/* 1317 */         this.message = "\u672C\u6B21\u64CD\u4F5C\u6CA1\u6709\u4FEE\u6539\u6570\u636E\uFF0C\u4E0D\u4F1A\u8FDB\u884C\u6570\u636E\u5E93\u64CD\u4F5C";
/* 1318 */         flagone = false;
/*      */       }
/*      */     }
/*      */ 
/* 1322 */     if ((polsetpage.size() == 0) && (polsetbase.size() == 0)) {
/* 1323 */       flagone = true;
/*      */     }
/*      */ 
/* 1329 */     if ((polsetpage.size() == 0) && (polsetbase.size() != 0))
/*      */     {
/* 1332 */       List stateList = stateOperate.changeMsgToModify(this.contSchema.getState(), this.contSchema.getEditstate(), this.tempGI.LNPRole);
/* 1333 */       if (stateList.size() > 0) {
/* 1334 */         System.out.println("-------\u56E0\u4E3A\u6709\u4FDD\u5355\u4FE1\u606F\u88AB\u4FEE\u6539,\u5C06\u56DE\u6EDA\u4FDD\u5355\u72B6\u6001\u503C02\u5F85\u5BA1\u6838\u72B6\u6001---------");
/* 1335 */         changeStateflag = true;
/* 1336 */         this.contSchema.setState((String)stateList.get(0));
/* 1337 */         this.contSchema.setEditstate((String)stateList.get(1));
/*      */       } else {
/* 1339 */         System.out.println("\u5F53\u524D\u64CD\u4F5C\u4E0D\u9700\u8981\u8FDB\u884C\u72B6\u6001\u56DE\u6EDA");
/*      */       }
/*      */ 
/* 1342 */       this.contSchema.setInputOperator(this.tempGI.Operator);
/* 1343 */       this.contSchema.setModifyDate(date);
/* 1344 */       this.contSchema.setModifyTime(time);
/* 1345 */       PubSubmit ps = new PubSubmit();
/* 1346 */       MMap map = new MMap();
/* 1347 */       map.put(delInvestSet, "DELETE");
/* 1348 */       map.put(polsetbase, "DELETE");
/* 1349 */       map.put(this.bonusInfoSchema, "DELETE");
/* 1350 */       map.put(this.investSchema, "DELETE");
/* 1351 */       map.put(this.contSchema, "UPDATE");
/* 1352 */       VData vd = new VData();
/* 1353 */       vd.add(map);
/* 1354 */       if (!ps.submitData(vd, "")) {
/* 1355 */         this.message = "\u6295\u4FDD\u4E8B\u9879\u4FE1\u606F\u4FDD\u5B58\u9519\u8BEF\uFF01";
/* 1356 */         System.out.println("\u6295\u4FDD\u4E8B\u9879\u4FDD\u5B58\u5931\u8D25");
/* 1357 */         flagone = false;
/*      */       } else {
/*      */         try {
/* 1360 */           flagone = true;
/* 1361 */           this.infoSource = "modify";
/* 1362 */           this.policyState = new BankPolicyState();
/* 1363 */           if (changeStateflag) {
/* 1364 */             this.policyState.savePolicyState(this.contSchema.getContNo(), this.contSchema.getState(), "3", date, time);
/*      */           }
/* 1366 */           this.message = "\u6295\u4FDD\u4E8B\u9879\u4FE1\u606F\u4FDD\u5B58\u6210\u529F\uFF01";
/* 1367 */           System.out.println("\u4FDD\u5B58\u6210\u529F");
/*      */         } catch (Exception e) {
/* 1369 */           this.message = "\u64CD\u4F5C\u8BB0\u5F55\u63A5\u53E3\u51FA\u95EE\u9898\u4E86";
/* 1370 */           System.out.println("\u64CD\u4F5C\u8BB0\u5F55\u63A5\u53E3\u51FA\u95EE\u9898\u4E86");
/* 1371 */           e.printStackTrace();
/*      */         }
/*      */       }
/*      */     }
/* 1375 */     return flagone;
/*      */   }
/*      */ 
/*      */   private boolean saveTypeTwo()
/*      */   {
/* 1384 */     System.out.println("\u5F00\u59CB\u4FDD\u5B58VUL\u9669\u79CD------------------");
/* 1385 */     boolean flagtwo = false;
/* 1386 */     this.contSchema = getMyLNPContByContNo(this.contNo);
/* 1387 */     this.bonusInfoSchema = getBonusSchemaByContNo(this.contNo);
/* 1388 */     LNPPolSet polsetbase = getPolByContNo(this.contNo);
/* 1389 */     this.investSchema = getInvestmentSchemaByContNo(this.contNo);
/* 1390 */     LNPInvestmentAccountInfoSet accountSet = getAccountSetByContNo(this.contNo);
/*      */ 
/* 1392 */     LNPPolSet polsetpage = new LNPPolSet();
/* 1393 */     LNPBonusInfoSchema bonusSchema = new LNPBonusInfoSchema();
/* 1394 */     LNPInvestmentInfoSchema newinvestSchema = new LNPInvestmentInfoSchema();
/*      */ 
/* 1396 */     this.polSchema = new LNPPolSchema();
/* 1397 */     String date = PubFun.getCurrentDate();
/* 1398 */     String time = PubFun.getCurrentTime();
/* 1399 */     SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
/* 1400 */     String tIndex = "";
/*      */ 
/* 1402 */     if ((this.vulriskcode != null) && (!this.vulriskcode.equals(""))) {
/* 1403 */       this.polSchema.setKindCode("02");
/* 1404 */       this.polSchema.setRiskCode(this.vulriskcode);
/* 1405 */       this.polSchema.setPrem("".equals(turnNullToString(this.vulprem).trim()) ? "-1" : this.vulprem);
/* 1406 */       this.polSchema.setSubFlag("M");
/*      */ 
/* 1410 */       if (this.vulriskcode.equals("UL15BA")) {
/* 1411 */         this.polSchema.setInsuYear("5");
/* 1412 */         this.polSchema.setInsuYearFlag("Y");
/*      */       } else {
/* 1414 */         this.polSchema.setInsuYear("106");
/* 1415 */         this.polSchema.setInsuYearFlag("A");
/*      */       }
/* 1417 */       this.polSchema.setPayEndYear("1");
/* 1418 */       this.polSchema.setPayEndYearFlag("Y");
/*      */ 
/* 1420 */       this.polSchema.setStandbyFlag3("");
/* 1421 */       this.polSchema.setDeadGetMode("");
/* 1422 */       this.polSchema.setPayIntv(this.payintv.intValue());
/* 1423 */       this.contSchema.setPayIntv(this.polSchema.getPayIntv());
/*      */ 
/* 1425 */       this.polSchema.setGrpContNo("00000000000000000000");
/* 1426 */       this.polSchema.setGrpPolNo("00000000000000000000");
/* 1427 */       this.polSchema.setContNo(this.contNo);
/* 1428 */       this.polSchema.setProposalContNo(this.contNo);
/* 1429 */       tIndex = maxNoMap.CreateMaxNo("CustomerNo", "");
/* 1430 */       this.polSchema.setPolNo(tIndex);
/* 1431 */       this.polSchema.setProposalNo(tIndex);
/* 1432 */       this.polSchema.setPrtNo("00000000000000000000");
/* 1433 */       this.polSchema.setContType("1");
/* 1434 */       this.polSchema.setManageCom(this.contSchema.getSignCom());
/*      */ 
/* 1436 */       this.polSchema.setMakeDate(date);
/* 1437 */       this.polSchema.setMakeTime(time);
/* 1438 */       this.polSchema.setModifyDate(date);
/* 1439 */       this.polSchema.setModifyTime(time);
/* 1440 */       this.polSchema.setOperator(this.tempGI.Operator);
/* 1441 */       polsetpage.add(this.polSchema);
/*      */     } else {
/* 1443 */       System.out.println("---\u9669\u79CD\u4EE3\u7801\u672A\u5F55\u5165\uFF0C\u6570\u636E\u4E0D\u4F1A\u4FDD\u5B58\u5230\u6570\u636E\u5E93\u4E2D---");
/*      */     }
/* 1445 */     System.out.println("polsetpage.size==================" + polsetpage.size());
/*      */ 
/* 1448 */     newinvestSchema.setID(tIndex);
/* 1449 */     newinvestSchema.setContNo(this.contNo);
/* 1450 */     if ("".equals(turnNullToString(this.vulmonthplus).trim()))
/* 1451 */       newinvestSchema.setMonthPlusPrem(-1.0D);
/*      */     else {
/* 1453 */       newinvestSchema.setMonthPlusPrem(this.vulmonthplus);
/*      */     }
/* 1455 */     newinvestSchema.setTermInvestment(this.vulyear);
/* 1456 */     newinvestSchema.setHesInvestment(this.vulinvestment);
/* 1457 */     newinvestSchema.setOperator(this.tempGI.Operator);
/* 1458 */     newinvestSchema.setMakeDate(date);
/* 1459 */     newinvestSchema.setMakeTime(time);
/* 1460 */     newinvestSchema.setModifyDate(date);
/* 1461 */     newinvestSchema.setModifyTime(time);
/*      */ 
/* 1463 */     LNPInvestmentAccountInfoSet infoSet = new LNPInvestmentAccountInfoSet();
/* 1464 */     for (int i = 0; i < this.vulinvestmentList.size(); i++) {
/* 1465 */       LNPInvestmentAccountInfoSchema accountSchema = new LNPInvestmentAccountInfoSchema();
/* 1466 */       accountSchema.setContNo(this.contNo);
/* 1467 */       accountSchema.setRiskCode(this.vulriskcode);
/* 1468 */       accountSchema.setInvestAccountCode(((LNPVulBean)this.vulinvestmentList.get(i)).getAccountCode());
/* 1469 */       accountSchema.setInvestAccountRate(Double.valueOf(((LNPVulBean)this.vulinvestmentList.get(i)).getAccountRate()).doubleValue() / 100.0D);
/* 1470 */       accountSchema.setVarc1(((LNPVulBean)this.vulinvestmentList.get(i)).getAccountName());
/* 1471 */       accountSchema.setOperator(this.tempGI.Operator);
/* 1472 */       accountSchema.setMakeDate(date);
/* 1473 */       accountSchema.setMakeTime(time);
/* 1474 */       accountSchema.setModifyDate(date);
/* 1475 */       accountSchema.setModifyTime(time);
/* 1476 */       infoSet.add(accountSchema);
/*      */     }
/*      */ 
/* 1482 */     bonusSchema.setGrpContNo("00000000000000000000");
/* 1483 */     bonusSchema.setContNo(this.contNo);
/* 1484 */     bonusSchema.setProposalContNo(this.contNo);
/* 1485 */     bonusSchema.setPrtNo("00000000000000000000");
/* 1486 */     bonusSchema.setBonusWay("00");
/* 1487 */     bonusSchema.setP1("02");
/* 1488 */     bonusSchema.setP2("03");
/* 1489 */     bonusSchema.setOperator(this.tempGI.Operator);
/* 1490 */     bonusSchema.setMakeDate(date);
/* 1491 */     bonusSchema.setMakeTime(time);
/* 1492 */     bonusSchema.setModifyDate(date);
/* 1493 */     bonusSchema.setModifyTime(time);
/*      */ 
/* 1496 */     this.allCompelte = false;
/* 1497 */     this.allCompelte = checkAllCompelte(polsetpage, null, newinvestSchema);
/*      */ 
/* 1499 */     boolean changeStateflag = false;
/* 1500 */     BankOperateDeal stateOperate = new BankOperateDeal();
/*      */ 
/* 1502 */     if (this.allCompelte)
/*      */     {
/* 1504 */       List stateList = stateOperate.infoOprate(this.contSchema.getState(), this.contSchema.getEditstate(), "modify", "02");
/* 1505 */       this.contSchema.setState((String)stateList.get(0));
/* 1506 */       this.contSchema.setEditstate((String)stateList.get(1));
/* 1507 */     } else if ("01".equals(this.contSchema.getState())) {
/* 1508 */       String editState = stateOperate.updateEditStateUNDone(this.contSchema.getEditstate(), 2);
/* 1509 */       this.contSchema.setEditstate(editState);
/*      */     }
/* 1511 */     System.out.println("---------------------------------------------");
/*      */ 
/* 1515 */     if ((polsetpage.size() != 0) && (polsetpage.size() != polsetbase.size()))
/*      */     {
/* 1517 */       List stateList = stateOperate.changeMsgToModify(this.contSchema.getState(), this.contSchema.getEditstate(), this.tempGI.LNPRole);
/* 1518 */       if (stateList.size() > 0) {
/* 1519 */         System.out.println("-------\u56E0\u4E3A\u6709\u4FDD\u5355\u4FE1\u606F\u88AB\u4FEE\u6539,\u5C06\u56DE\u6EDA\u4FDD\u5355\u72B6\u6001\u503C02\u5F85\u5BA1\u6838\u72B6\u6001---------");
/* 1520 */         changeStateflag = true;
/* 1521 */         this.contSchema.setState((String)stateList.get(0));
/* 1522 */         this.contSchema.setEditstate((String)stateList.get(1));
/*      */       } else {
/* 1524 */         System.out.println("\u5F53\u524D\u64CD\u4F5C\u4E0D\u9700\u8981\u8FDB\u884C\u72B6\u6001\u56DE\u6EDA");
/*      */       }
/*      */ 
/* 1527 */       System.out.println("\u5F00\u59CB\u4FDD\u5B58VUL\u9669\u79CD\u6570\u636E11111---------------");
/* 1528 */       this.contSchema.setInputOperator(this.tempGI.Operator);
/* 1529 */       this.contSchema.setModifyDate(date);
/* 1530 */       this.contSchema.setModifyTime(time);
/* 1531 */       PubSubmit ps = new PubSubmit();
/* 1532 */       MMap map = new MMap();
/* 1533 */       map.put(polsetbase, "DELETE");
/* 1534 */       map.put(this.bonusInfoSchema, "DELETE");
/* 1535 */       map.put(accountSet, "DELETE");
/* 1536 */       map.put(this.investSchema, "DELETE");
/* 1537 */       map.put(this.polSchema, "INSERT");
/* 1538 */       map.put(bonusSchema, "INSERT");
/* 1539 */       map.put(newinvestSchema, "INSERT");
/* 1540 */       map.put(infoSet, "INSERT");
/* 1541 */       map.put(this.contSchema, "UPDATE");
/* 1542 */       VData vd = new VData();
/* 1543 */       vd.add(map);
/* 1544 */       if (!ps.submitData(vd, "")) {
/* 1545 */         this.message = "\u6295\u4FDD\u4E8B\u9879\u4FE1\u606F\u4FDD\u5B58\u9519\u8BEF\uFF01";
/* 1546 */         System.out.println("\u6295\u4FDD\u4E8B\u9879\u4FDD\u5B58\u5931\u8D25");
/* 1547 */         flagtwo = false;
/*      */       }
/*      */       else
/*      */       {
/*      */         try
/*      */         {
/* 1553 */           flagtwo = true;
/* 1554 */           this.infoSource = "modify";
/* 1555 */           this.policyState = new BankPolicyState();
/* 1556 */           if (changeStateflag) {
/* 1557 */             this.policyState.savePolicyState(this.contSchema.getContNo(), this.contSchema.getState(), "3", date, time);
/*      */           }
/* 1559 */           this.message = "\u6295\u4FDD\u4E8B\u9879\u4FE1\u606F\u4FDD\u5B58\u6210\u529F\uFF01";
/* 1560 */           System.out.println("\u4FDD\u5B58\u6210\u529F");
/*      */         } catch (Exception e) {
/* 1562 */           this.message = "\u64CD\u4F5C\u8BB0\u5F55\u63A5\u53E3\u51FA\u95EE\u9898\u4E86";
/* 1563 */           System.out.println("\u64CD\u4F5C\u8BB0\u5F55\u63A5\u53E3\u51FA\u95EE\u9898\u4E86");
/* 1564 */           e.printStackTrace();
/*      */         }
/*      */       }
/* 1567 */     } else if ((polsetpage.size() != 0) && (polsetpage.size() == polsetbase.size())) {
/* 1568 */       System.out.println("\u5F00\u59CB\u4FDD\u5B58VUL\u9669\u79CD\u6570\u636E2222222222---------------");
/* 1569 */       for (int i = 1; i <= polsetbase.size(); i++)
/* 1570 */         if ((turnNullToString(this.polSchema.getRiskCode()).equals(turnNullToString(polsetbase.get(i).getRiskCode()))) && 
/* 1571 */           (turnNullToString(Double.valueOf(this.polSchema.getPrem())).equals(turnNullToString(Double.valueOf(polsetbase.get(i).getPrem())))) && 
/* 1572 */           (turnNullToString(Double.valueOf(newinvestSchema.getMonthPlusPrem())).equals(turnNullToString(Double.valueOf(this.investSchema.getMonthPlusPrem())))) && 
/* 1573 */           (turnNullToString(newinvestSchema.getTermInvestment()).equals(turnNullToString(this.investSchema.getTermInvestment()))) && 
/* 1574 */           (turnNullToString(newinvestSchema.getHesInvestment()).equals(turnNullToString(this.investSchema.getHesInvestment()))) && 
/* 1575 */           (checkaccount(infoSet, accountSet)) && (!turnNullToString(this.polSchema.getRiskCode()).equals("")))
/*      */         {
/* 1577 */           this.message = "\u6B64\u65F6\u754C\u9762\u9669\u79CD\u4FE1\u606F\u4E0E\u6570\u636E\u5E93\u4E2D\u4FE1\u606F\u4E00\u81F4\u65E0\u4FEE\u6539";
/* 1578 */           System.out.println("\u6B64\u65F6\u754C\u9762\u9669\u79CD\u4FE1\u606F\u4E0E\u6570\u636E\u5E93\u4E2D\u4FE1\u606F\u4E00\u81F4\u65E0\u4FEE\u6539");
/* 1579 */           flagtwo = false;
/*      */         }
/*      */         else
/*      */         {
/* 1583 */           List stateList = stateOperate.changeMsgToModify(this.contSchema.getState(), this.contSchema.getEditstate(), this.tempGI.LNPRole);
/* 1584 */           if (stateList.size() > 0) {
/* 1585 */             System.out.println("-------\u56E0\u4E3A\u6709\u4FDD\u5355\u4FE1\u606F\u88AB\u4FEE\u6539,\u5C06\u56DE\u6EDA\u4FDD\u5355\u72B6\u6001\u503C02\u5F85\u5BA1\u6838\u72B6\u6001---------");
/* 1586 */             changeStateflag = true;
/* 1587 */             this.contSchema.setState((String)stateList.get(0));
/* 1588 */             this.contSchema.setEditstate((String)stateList.get(1));
/*      */           } else {
/* 1590 */             System.out.println("\u5F53\u524D\u64CD\u4F5C\u4E0D\u9700\u8981\u8FDB\u884C\u72B6\u6001\u56DE\u6EDA");
/*      */           }
/* 1592 */           this.contSchema.setInputOperator(this.tempGI.Operator);
/* 1593 */           this.contSchema.setModifyDate(date);
/* 1594 */           this.contSchema.setModifyTime(time);
/* 1595 */           PubSubmit ps = new PubSubmit();
/* 1596 */           MMap map = new MMap();
/* 1597 */           map.put(polsetbase, "DELETE");
/* 1598 */           map.put(this.bonusInfoSchema, "DELETE");
/* 1599 */           map.put(accountSet, "DELETE");
/* 1600 */           map.put(this.investSchema, "DELETE");
/* 1601 */           map.put(this.polSchema, "INSERT");
/* 1602 */           map.put(bonusSchema, "INSERT");
/* 1603 */           map.put(newinvestSchema, "INSERT");
/* 1604 */           map.put(infoSet, "INSERT");
/* 1605 */           map.put(this.contSchema, "UPDATE");
/* 1606 */           VData vd = new VData();
/* 1607 */           vd.add(map);
/* 1608 */           if (!ps.submitData(vd, "")) {
/* 1609 */             this.message = "\u6295\u4FDD\u4E8B\u9879\u4FE1\u606F\u4FDD\u5B58\u9519\u8BEF\uFF01";
/* 1610 */             System.out.println("\u6295\u4FDD\u4E8B\u9879\u4FDD\u5B58\u5931\u8D25");
/* 1611 */             flagtwo = false;
/*      */           }
/*      */           else
/*      */           {
/*      */             try
/*      */             {
/* 1617 */               flagtwo = true;
/* 1618 */               this.infoSource = "modify";
/* 1619 */               this.policyState = new BankPolicyState();
/* 1620 */               if (changeStateflag) {
/* 1621 */                 this.policyState.savePolicyState(this.contSchema.getContNo(), this.contSchema.getState(), "3", date, time);
/*      */               }
/* 1623 */               this.message = "\u6295\u4FDD\u4E8B\u9879\u4FE1\u606F\u4FDD\u5B58\u6210\u529F\uFF01";
/* 1624 */               System.out.println("\u4FDD\u5B58\u6210\u529F");
/*      */             } catch (Exception e) {
/* 1626 */               this.message = "\u64CD\u4F5C\u8BB0\u5F55\u63A5\u53E3\u51FA\u95EE\u9898\u4E86";
/* 1627 */               System.out.println("\u64CD\u4F5C\u8BB0\u5F55\u63A5\u53E3\u51FA\u95EE\u9898\u4E86");
/* 1628 */               e.printStackTrace();
/*      */             }
/*      */           }
/*      */         }
/*      */     }
/* 1633 */     else if (polsetpage.size() == 0) {
/* 1634 */       if (polsetbase.size() != 0)
/*      */       {
/* 1636 */         List stateList = stateOperate.changeMsgToModify(this.contSchema.getState(), this.contSchema.getEditstate(), this.tempGI.LNPRole);
/* 1637 */         if (stateList.size() > 0) {
/* 1638 */           System.out.println("-------\u56E0\u4E3A\u6709\u4FDD\u5355\u4FE1\u606F\u88AB\u4FEE\u6539,\u5C06\u56DE\u6EDA\u4FDD\u5355\u72B6\u6001\u503C02\u5F85\u5BA1\u6838\u72B6\u6001---------");
/* 1639 */           changeStateflag = true;
/* 1640 */           this.contSchema.setState((String)stateList.get(0));
/* 1641 */           this.contSchema.setEditstate((String)stateList.get(1));
/*      */         } else {
/* 1643 */           System.out.println("\u5F53\u524D\u64CD\u4F5C\u4E0D\u9700\u8981\u8FDB\u884C\u72B6\u6001\u56DE\u6EDA");
/*      */         }
/*      */ 
/* 1646 */         System.out.println("\u5F00\u59CB\u4FDD\u5B58VUL\u9669\u79CD\u6570\u636E33333333---------------");
/* 1647 */         this.contSchema.setInputOperator(this.tempGI.Operator);
/* 1648 */         this.contSchema.setModifyDate(date);
/* 1649 */         this.contSchema.setModifyTime(time);
/* 1650 */         PubSubmit ps = new PubSubmit();
/* 1651 */         MMap map = new MMap();
/* 1652 */         map.put(polsetbase, "DELETE");
/* 1653 */         map.put(this.bonusInfoSchema, "DELETE");
/* 1654 */         map.put(accountSet, "DELETE");
/* 1655 */         map.put(this.investSchema, "DELETE");
/* 1656 */         map.put(this.contSchema, "UPDATE");
/* 1657 */         VData vd = new VData();
/* 1658 */         vd.add(map);
/* 1659 */         if (!ps.submitData(vd, "")) {
/* 1660 */           this.message = "\u6295\u4FDD\u4E8B\u9879\u4FE1\u606F\u4FDD\u5B58\u9519\u8BEF\uFF01";
/* 1661 */           System.out.println("\u6295\u4FDD\u4E8B\u9879\u4FDD\u5B58\u5931\u8D25");
/* 1662 */           flagtwo = false;
/*      */         } else {
/*      */           try {
/* 1665 */             flagtwo = true;
/* 1666 */             this.infoSource = "modify";
/* 1667 */             this.policyState = new BankPolicyState();
/* 1668 */             if (changeStateflag) {
/* 1669 */               this.policyState.savePolicyState(this.contSchema.getContNo(), this.contSchema.getState(), "3", date, time);
/*      */             }
/* 1671 */             this.message = "\u6295\u4FDD\u4E8B\u9879\u4FE1\u606F\u4FDD\u5B58\u6210\u529F\uFF01";
/* 1672 */             System.out.println("\u4FDD\u5B58\u6210\u529F");
/*      */           } catch (Exception e) {
/* 1674 */             this.message = "\u64CD\u4F5C\u8BB0\u5F55\u63A5\u53E3\u51FA\u95EE\u9898\u4E86";
/* 1675 */             System.out.println("\u64CD\u4F5C\u8BB0\u5F55\u63A5\u53E3\u51FA\u95EE\u9898\u4E86");
/* 1676 */             e.printStackTrace();
/*      */           }
/*      */         }
/*      */       } else {
/* 1680 */         System.out.println("\u6570\u636E\u5E93\u4E2D\u65E0\u6570\u636E\uFF0C\u9875\u9762\u4E5F\u65E0\u6570\u636E\uFF0C\u6B64\u65F6\u4E0D\u5BF9\u6570\u636E\u5E93\u8FDB\u884C\u64CD\u4F5C");
/* 1681 */         flagtwo = false;
/*      */       }
/*      */     }
/* 1684 */     return flagtwo;
/*      */   }
/*      */ 
/*      */   public boolean checkaccount(LNPInvestmentAccountInfoSet infoSet, LNPInvestmentAccountInfoSet accountSet)
/*      */   {
/* 1693 */     boolean accountflag = true;
/* 1694 */     if (infoSet.size() != accountSet.size()) {
/* 1695 */       accountflag = false;
/*      */     } else {
/* 1697 */       accountflag = true;
/* 1698 */       for (int i = 1; i <= infoSet.size(); i++) {
/* 1699 */         if (!accountflag) break;
/* 1700 */         LNPInvestmentAccountInfoSchema infoSchema = infoSet.get(i);
/* 1701 */         for (int j = 1; j <= accountSet.size(); j++) {
/* 1702 */           LNPInvestmentAccountInfoSchema accSchema = accountSet.get(j);
/* 1703 */           if (turnNullToString(infoSchema.getInvestAccountCode()).equals(turnNullToString(accSchema.getInvestAccountCode()))) {
/* 1704 */             if ((turnNullToString(Double.valueOf(infoSchema.getInvestAccountRate())).equals(turnNullToString(Double.valueOf(accSchema.getInvestAccountRate())))) && 
/* 1705 */               (turnNullToString(infoSchema.getVarc1()).equals(turnNullToString(accSchema.getVarc1()))) && 
/* 1706 */               (turnNullToString(infoSchema.getRiskCode()).equals(turnNullToString(accSchema.getRiskCode())))) break;
/* 1707 */             return accountflag = 0;
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1714 */     return accountflag;
/*      */   }
/*      */ 
/*      */   private boolean saveTypeThree()
/*      */   {
/* 1729 */     boolean flagthree = false;
/* 1730 */     this.contSchema = getMyLNPContByContNo(this.contNo);
/* 1731 */     this.bonusInfoSchema = getBonusSchemaByContNo(this.contNo);
/* 1732 */     LNPPolSet polsetbase = getPolByContNo(this.contNo);
/* 1733 */     String date = PubFun.getCurrentDate();
/* 1734 */     String time = PubFun.getCurrentTime();
/* 1735 */     this.polSchema = new LNPPolSchema();
/* 1736 */     LNPPolSet polsetpage = new LNPPolSet();
/* 1737 */     LNPBonusInfoSchema newbonusschema = new LNPBonusInfoSchema();
/* 1738 */     SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
/* 1739 */     String tIndex = "";
/* 1740 */     System.out.println("---\u4FDD\u5B58\u7EC4\u5408\u9669----------------------------------------------------?");
/*      */ 
/* 1742 */     for (int i = 0; i < 6; i++)
/*      */     {
/* 1744 */       System.out.println("---\u4FDD\u5B58\u7EC4\u5408\u9669----------------------------------------------------1" + this.combinationriskcode[i]);
/* 1745 */       if ((this.combinationriskcode[i] != null) && (!this.combinationriskcode[i].equals(""))) {
/* 1746 */         this.polSchema = new LNPPolSchema();
/* 1747 */         this.polSchema.setKindCode(this.poltype);
/* 1748 */         this.polSchema.setRiskVersion(this.combinationriskcode[i]);
/* 1749 */         this.polSchema.setSubFlag("M");
/*      */ 
/* 1751 */         if (this.combinationyears[i].startsWith("\u7EC8\u8EAB")) {
/* 1752 */           this.polSchema.setPayLocation("106");
/* 1753 */           this.polSchema.setPremToAmnt("A");
/*      */         }
/* 1755 */         if ((this.combinationyears[i].startsWith("T")) || (this.combinationyears[i].startsWith("t"))) {
/* 1756 */           this.polSchema.setPayLocation(this.combinationyears[i].replaceAll("^[Tt](\\d+)$", "$1"));
/* 1757 */           this.polSchema.setPremToAmnt("A");
/*      */         }
/* 1759 */         if (this.combinationyears[i].matches("^[1-9][0-9]*$")) {
/* 1760 */           this.polSchema.setPayLocation(this.combinationyears[i].replace("", ""));
/* 1761 */           this.polSchema.setPremToAmnt("Y");
/*      */         }
/* 1763 */         if ((this.combinationyears[i] == null) || (this.combinationyears[i].equals(""))) {
/* 1764 */           this.polSchema.setPayLocation("");
/* 1765 */           this.polSchema.setPremToAmnt("");
/*      */         }
/* 1767 */         if (this.combinationyears[i].equals("0")) {
/* 1768 */           this.polSchema.setPayLocation("0");
/* 1769 */           this.polSchema.setPremToAmnt("");
/*      */         }
/*      */ 
/* 1773 */         if (this.combinationpayyears[i].equals("0")) {
/* 1774 */           this.polSchema.setPayMode("1000");
/* 1775 */           this.polSchema.setAcciYearFlag("Y");
/*      */         }
/* 1777 */         if ((this.combinationpayyears[i].startsWith("T")) || (this.combinationpayyears[i].startsWith("t"))) {
/* 1778 */           this.polSchema.setPayMode(this.combinationpayyears[i].replaceAll("^[Tt](\\d+)$", "$1"));
/* 1779 */           this.polSchema.setAcciYearFlag("A");
/*      */         }
/* 1781 */         if (this.combinationpayyears[i].matches("^[1-9][0-9]*$")) {
/* 1782 */           this.polSchema.setPayMode(this.combinationpayyears[i].replace("", ""));
/* 1783 */           this.polSchema.setAcciYearFlag("Y");
/*      */         }
/* 1785 */         if ((this.combinationpayyears[i] == null) || (this.combinationpayyears[i].equals(""))) {
/* 1786 */           this.polSchema.setPayMode("");
/* 1787 */           this.polSchema.setAcciYearFlag("");
/*      */         }
/* 1789 */         if (i == 0) {
/* 1790 */           if ("".equals(turnNullToString(this.combinationmoney[i]).trim())) {
/* 1791 */             this.polSchema.setRemark("");
/*      */           }
/*      */           else
/*      */           {
/* 1796 */             this.polSchema.setRemark(decimalFormat.format(Double.valueOf(this.combinationmoney[i])).toString());
/*      */           }
/*      */ 
/*      */         }
/*      */         else
/*      */         {
/* 1802 */           this.polSchema.setUWCode(this.combinationtype[i]);
/* 1803 */           System.out.println("---\u4FDD\u5B58\u7EC4\u5408\u9669----------------------------------------------------2" + this.combinationtype[i]);
/* 1804 */           System.out.println("combinationmoney[i]" + this.combinationmoney[i]);
/* 1805 */           if (this.combinationtype[i].equals("01")) {
/* 1806 */             if ((this.combinationmoney[i] == null) || (this.combinationmoney[i].equals("")))
/*      */             {
/* 1808 */               this.polSchema.setAmnt(-1.0D);
/* 1809 */               this.polSchema.setPrem(-1.0D);
/*      */             }
/*      */             else {
/* 1812 */               this.polSchema.setAmnt(this.combinationmoney[i]);
/* 1813 */               this.polSchema.setPrem(0.0D);
/*      */             }
/* 1815 */           } else if (this.combinationtype[i].equals("02")) {
/* 1816 */             System.out.println("---\u4FDD\u5B58\u7EC4\u5408\u9669----------------------------------------------------\u4FDD\u8D39" + this.combinationtype[i]);
/* 1817 */             if ((this.combinationmoney[i] == null) || (this.combinationmoney[i].equals("")))
/*      */             {
/* 1819 */               this.polSchema.setAmnt(-1.0D);
/* 1820 */               this.polSchema.setPrem(-1.0D);
/*      */             }
/*      */             else {
/* 1823 */               this.polSchema.setPrem(this.combinationmoney[i]);
/* 1824 */               this.polSchema.setAmnt(0.0D);
/*      */             }
/*      */           } else {
/* 1827 */             this.polSchema.setAmnt(-1.0D);
/* 1828 */             this.polSchema.setPrem(-1.0D);
/*      */           }
/*      */         }
/* 1831 */         this.polSchema.setRnewFlag("1");
/*      */ 
/* 1834 */         this.polSchema.setPayIntv(this.payintv.intValue());
/* 1835 */         this.contSchema.setPayIntv(this.polSchema.getPayIntv());
/* 1836 */         this.polSchema.setDeadGetMode(this.deadgetmode);
/* 1837 */         this.polSchema.setStandbyFlag3(this.annuityfrequency);
/*      */ 
/* 1840 */         this.polSchema.setGrpContNo("00000000000000000000");
/* 1841 */         this.polSchema.setGrpPolNo("00000000000000000000");
/* 1842 */         this.polSchema.setContNo(this.contNo);
/* 1843 */         this.polSchema.setProposalContNo(this.contNo);
/* 1844 */         tIndex = maxNoMap.CreateMaxNo("CustomerNo", "");
/* 1845 */         this.polSchema.setPolNo(tIndex);
/* 1846 */         this.polSchema.setRiskCode("");
/*      */ 
/* 1848 */         this.polSchema.setProposalNo(tIndex);
/* 1849 */         this.polSchema.setPrtNo("00000000000000000000");
/* 1850 */         this.polSchema.setContType("1");
/* 1851 */         this.polSchema.setManageCom(this.contSchema.getSignCom());
/* 1852 */         this.polSchema.setMakeDate(date);
/* 1853 */         this.polSchema.setMakeTime(time);
/* 1854 */         this.polSchema.setModifyDate(date);
/* 1855 */         this.polSchema.setModifyTime(time);
/* 1856 */         this.polSchema.setOperator(this.tempGI.Operator);
/* 1857 */         polsetpage.add(this.polSchema);
/*      */       } else {
/* 1859 */         System.out.println("---\u7EC4\u5408\u9669---\u9669\u79CD\u4EE3\u7801\u672A\u5F55\u5165\uFF0C\u6570\u636E\u4E0D\u4F1A\u4FDD\u5B58\u5230\u6570\u636E\u5E93\u4E2D---");
/*      */       }
/* 1861 */       System.out.println("---\u4FDD\u5B58\u7EC4\u5408\u9669------------------------------------polsetpage.size=" + polsetpage.size());
/*      */     }
/*      */ 
/* 1955 */     newbonusschema.setGrpContNo("00000000000000000000");
/* 1956 */     newbonusschema.setContNo(this.contNo);
/* 1957 */     newbonusschema.setProposalContNo(this.contNo);
/* 1958 */     newbonusschema.setPrtNo("00000000000000000000");
/* 1959 */     newbonusschema.setBonusWay(this.bonusgetmode);
/* 1960 */     newbonusschema.setP1(this.overflowpremium);
/* 1961 */     newbonusschema.setP2(this.overduepremium);
/* 1962 */     newbonusschema.setOperator(this.tempGI.Operator);
/* 1963 */     newbonusschema.setMakeDate(date);
/* 1964 */     newbonusschema.setMakeTime(time);
/* 1965 */     newbonusschema.setModifyDate(date);
/* 1966 */     newbonusschema.setModifyTime(time);
/*      */ 
/* 1969 */     this.allCompelte = false;
/* 1970 */     this.allCompelte = checkAllCompelte(polsetpage, newbonusschema, null);
/*      */ 
/* 1972 */     boolean changeStateflag = false;
/* 1973 */     BankOperateDeal stateOperate = new BankOperateDeal();
/*      */ 
/* 1975 */     if (this.allCompelte)
/*      */     {
/* 1977 */       List stateList = stateOperate.infoOprate(this.contSchema.getState(), this.contSchema.getEditstate(), "modify", "02");
/* 1978 */       this.contSchema.setState((String)stateList.get(0));
/* 1979 */       this.contSchema.setEditstate((String)stateList.get(1));
/* 1980 */     } else if ("01".equals(this.contSchema.getState())) {
/* 1981 */       String editState = stateOperate.updateEditStateUNDone(this.contSchema.getEditstate(), 2);
/* 1982 */       this.contSchema.setEditstate(editState);
/*      */     }
/* 1984 */     System.out.println("---\u4FDD\u5B58\u7EC4\u5408\u9669------------------------------------3" + this.contSchema.getEditstate());
/*      */ 
/* 1987 */     System.out.println("---\u4FDD\u5B58\u7EC4\u5408\u9669------------------------------------polsetpage.size()" + polsetpage.size());
/* 1988 */     System.out.println("---\u4FDD\u5B58\u7EC4\u5408\u9669------------------------------------polsetpage.get(1).getRiskCode()" + polsetpage.get(1).getRiskCode());
/* 1989 */     System.out.println("---\u4FDD\u5B58\u7EC4\u5408\u9669------------------------------------polsetpage.size()" + polsetpage.size());
/*      */ 
/* 1991 */     if ((polsetpage.size() != 0) && (!polsetpage.get(1).getRiskVersion().equals("")) && (((polsetpage.size() != polsetbase.size()) && ((this.contSchema.getState().equals("01")) || (this.contSchema.getState().equals("02")) || (this.contSchema.getState().equals("04")))) || ((polsetpage.size() + 1 != polsetbase.size()) && (!this.contSchema.getState().equals("01")) && (!this.contSchema.getState().equals("02")) && (!this.contSchema.getState().equals("04"))))) {
/* 1992 */       System.out.println("--------\u5F00\u59CB\u4FDD\u5B58\u7EC4\u5408\u9669111111---------");
/* 1993 */       System.out.println("--------\u6570\u636E\u5E93\u4E2D\u7684\u6570\u636E\u4E0E\u9875\u9762\u83B7\u53D6\u7684\u6570\u636E\u6761\u6570\u4E0D\u7B49 insert---------" + polsetpage.size());
/* 1994 */       System.out.println("gelic1:contSchema.getState()" + this.contSchema.getState());
/*      */ 
/* 1996 */       List stateList = stateOperate.changeMsgToModify(this.contSchema.getState(), this.contSchema.getEditstate(), this.tempGI.LNPRole);
/* 1997 */       if (stateList.size() > 0) {
/* 1998 */         System.out.println("-------\u56E0\u4E3A\u6709\u4FDD\u5355\u4FE1\u606F\u88AB\u4FEE\u6539,\u5C06\u56DE\u6EDA\u4FDD\u5355\u72B6\u6001\u503C02\u5F85\u5BA1\u6838\u72B6\u6001---------");
/* 1999 */         changeStateflag = true;
/* 2000 */         this.contSchema.setState((String)stateList.get(0));
/* 2001 */         this.contSchema.setEditstate((String)stateList.get(1));
/*      */       } else {
/* 2003 */         System.out.println("\u5F53\u524D\u64CD\u4F5C\u4E0D\u9700\u8981\u8FDB\u884C\u72B6\u6001\u56DE\u6EDA");
/*      */       }
/* 2005 */       System.out.println("gelic2:contSchema.getState()" + this.contSchema.getState());
/* 2006 */       this.contSchema.setInputOperator(this.tempGI.Operator);
/* 2007 */       this.contSchema.setModifyDate(date);
/* 2008 */       this.contSchema.setModifyTime(time);
/* 2009 */       PubSubmit ps = new PubSubmit();
/*      */ 
/* 2011 */       MMap map = new MMap();
/* 2012 */       map.put(polsetbase, "DELETE");
/*      */ 
/* 2014 */       map.put(this.bonusInfoSchema, "DELETE");
/* 2015 */       map.put(polsetpage, "INSERT");
/* 2016 */       map.put(newbonusschema, "INSERT");
/* 2017 */       map.put(this.contSchema, "UPDATE");
/*      */ 
/* 2020 */       VData vd = new VData();
/*      */ 
/* 2022 */       vd.add(map);
/* 2023 */       if (!ps.submitData(vd, "")) {
/* 2024 */         this.message = "\u6295\u4FDD\u4E8B\u9879\u4FE1\u606F\u4FDD\u5B58\u9519\u8BEF\uFF01";
/* 2025 */         System.out.println("\u6295\u4FDD\u4E8B\u9879\u4FDD\u5B58\u5931\u8D25");
/* 2026 */         flagthree = false;
/*      */       } else {
/*      */         try {
/* 2029 */           flagthree = true;
/* 2030 */           this.infoSource = "modify";
/* 2031 */           this.policyState = new BankPolicyState();
/* 2032 */           if (changeStateflag) {
/* 2033 */             this.policyState.savePolicyState(this.contSchema.getContNo(), this.contSchema.getState(), "3", date, time);
/*      */           }
/* 2035 */           this.message = "\u6295\u4FDD\u4E8B\u9879\u4FE1\u606F\u4FDD\u5B58\u6210\u529F\uFF01";
/* 2036 */           System.out.println("\u4FDD\u5B58\u6210\u529F");
/*      */         } catch (Exception e) {
/* 2038 */           this.message = "\u64CD\u4F5C\u8BB0\u5F55\u63A5\u53E3\u51FA\u95EE\u9898\u4E86";
/* 2039 */           System.out.println("\u64CD\u4F5C\u8BB0\u5F55\u63A5\u53E3\u51FA\u95EE\u9898\u4E86");
/* 2040 */           e.printStackTrace();
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 2048 */     if ((polsetpage.size() != 0) && (polsetbase.size() != 0) && (((polsetpage.size() == polsetbase.size()) && ((this.contSchema.getState().equals("01")) || (this.contSchema.getState().equals("02")) || (this.contSchema.getState().equals("04")))) || ((polsetpage.size() + 1 == polsetbase.size()) && (!this.contSchema.getState().equals("01")) && (!this.contSchema.getState().equals("02")) && (!this.contSchema.getState().equals("04")))))
/*      */     {
/* 2051 */       boolean MPolFlag = false;
/* 2052 */       LNPPolSchema polbaseschema = new LNPPolSchema();
/* 2053 */       for (int i = 1; i <= polsetbase.size(); i++) {
/* 2054 */         if (polsetbase.get(i).getRnewFlag().equals("1")) {
/* 2055 */           polbaseschema = polsetbase.get(i);
/* 2056 */           MPolFlag = true;
/* 2057 */           break;
/*      */         }
/*      */       }
/* 2060 */       if (!MPolFlag) {
/* 2061 */         System.out.println("--ZH------------------>\u672A\u627E\u5230\u4E3B\u9669");
/* 2062 */         return flagthree = 0;
/*      */       }
/* 2064 */       boolean flags = false;
/*      */       int i;
/* 2065 */       if ((this.contSchema.getState().equals("01")) || (this.contSchema.getState().equals("02")) || (this.contSchema.getState().equals("04")))
/*      */       {
/* 2067 */         System.out.println("-------------------->\u9875\u9762\u83B7\u53D6\u7684\u6570\u636E\u4E0E\u6570\u636E\u5E93\u7684\u6761\u6570\u76F8\u540C update");
/* 2068 */         i = 1;
/*      */       }while (true) {
/* 2070 */         if ((turnNullToString(polsetpage.get(i).getRiskVersion()).equals(turnNullToString(polsetbase.get(i).getRiskVersion()))) && 
/* 2071 */           (turnNullToString(polsetpage.get(i).getPayLocation()).equals(turnNullToString(polsetbase.get(i).getPayLocation()))) && 
/* 2072 */           (turnNullToString(polsetpage.get(i).getPremToAmnt()).equals(turnNullToString(polsetbase.get(i).getPremToAmnt()))) && 
/* 2073 */           (turnNullToString(polsetpage.get(i).getPayMode()).equals(turnNullToString(polsetbase.get(i).getPayMode()))) && 
/* 2074 */           (turnNullToString(polsetpage.get(i).getAcciYearFlag()).equals(turnNullToString(polsetbase.get(i).getAcciYearFlag()))) && 
/* 2075 */           (turnNullToString(polsetpage.get(i).getRemark()).equals(turnNullToString(polsetbase.get(i).getRemark()))) && 
/* 2076 */           (turnNullToString(Double.valueOf(polsetpage.get(i).getAmnt())).equals(turnNullToString(Double.valueOf(polsetbase.get(i).getAmnt())))) && 
/* 2077 */           (turnNullToString(Double.valueOf(polsetpage.get(i).getPrem())).equals(turnNullToString(Double.valueOf(polsetbase.get(i).getPrem())))) && 
/* 2078 */           (turnNullToString(Integer.valueOf(polsetpage.get(i).getPayIntv())).equals(turnNullToString(Integer.valueOf(polsetbase.get(i).getPayIntv())))) && 
/* 2079 */           (turnNullToString(polsetpage.get(i).getDeadGetMode()).equals(turnNullToString(polsetbase.get(i).getDeadGetMode()))) && 
/* 2080 */           (turnNullToString(polsetpage.get(i).getStandbyFlag3()).equals(turnNullToString(polsetbase.get(i).getStandbyFlag3()))) && 
/* 2081 */           (turnNullToString(newbonusschema.getBonusWay()).equals(turnNullToString(this.bonusInfoSchema.getBonusWay()))) && 
/* 2082 */           (turnNullToString(newbonusschema.getP1()).equals(turnNullToString(this.bonusInfoSchema.getP1()))) && 
/* 2083 */           (turnNullToString(newbonusschema.getP2()).equals(turnNullToString(this.bonusInfoSchema.getP2())))) {
/* 2084 */           this.message = "\u6B64\u65F6\u754C\u9762\u9669\u79CD\u4FE1\u606F\u4E0E\u6570\u636E\u5E93\u4E2D\u4FE1\u606F\u4E00\u81F4\u65E0\u4FEE\u6539";
/* 2085 */           System.out.println("\u6B64\u65F6\u754C\u9762\u9669\u79CD\u4FE1\u606F\u4E0E\u6570\u636E\u5E93\u4E2D\u4FE1\u606F\u4E00\u81F4\u65E0\u4FEE\u6539");
/* 2086 */           flagthree = true;
/*      */         } else {
/* 2088 */           flagthree = false;
/* 2089 */           break;
/*      */         }
/* 2068 */         i++; if (i <= polsetbase.size())
/*      */         {
/*      */           continue;
/*      */         }
/*      */ 
/* 2092 */         break;
/* 2093 */         System.out.println("-------------------->\u9875\u9762\u83B7\u53D6\u7684\u6570\u636E\u4E0E\u6570\u636E\u5E93\u7684\u6761\u6570\u4E0D\u76F8\u540C update");
/* 2094 */         int i = 1; for (int j = i; i <= polsetbase.size(); j++)
/*      */         {
/* 2096 */           if (i == 2)
/*      */           {
/* 2098 */             i++;
/*      */           }
/* 2100 */           if ((turnNullToString(polsetpage.get(j).getRiskVersion()).equals(turnNullToString(polsetbase.get(i).getRiskVersion()))) && 
/* 2101 */             (turnNullToString(polsetpage.get(j).getPayLocation()).equals(turnNullToString(polsetbase.get(i).getPayLocation()))) && 
/* 2102 */             (turnNullToString(polsetpage.get(j).getPremToAmnt()).equals(turnNullToString(polsetbase.get(i).getPremToAmnt()))) && 
/* 2103 */             (turnNullToString(polsetpage.get(j).getPayMode()).equals(turnNullToString(polsetbase.get(i).getPayMode()))) && 
/* 2104 */             (turnNullToString(polsetpage.get(j).getAcciYearFlag()).equals(turnNullToString(polsetbase.get(i).getAcciYearFlag()))) && 
/* 2105 */             (turnNullToString(polsetpage.get(j).getRemark()).equals(turnNullToString(polsetbase.get(i).getRemark()))) && 
/* 2106 */             (turnNullToString(polsetpage.get(j).getUWCode()).equals(turnNullToString(polsetbase.get(i).getUWCode()))) && 
/* 2107 */             (turnNullToString(Integer.valueOf(polsetpage.get(j).getPayIntv())).equals(turnNullToString(Integer.valueOf(polsetbase.get(i).getPayIntv())))) && 
/* 2108 */             (turnNullToString(polsetpage.get(j).getDeadGetMode()).equals(turnNullToString(polsetbase.get(i).getDeadGetMode()))) && 
/* 2109 */             (turnNullToString(polsetpage.get(j).getStandbyFlag3()).equals(turnNullToString(polsetbase.get(i).getStandbyFlag3()))) && 
/* 2110 */             (turnNullToString(newbonusschema.getBonusWay()).equals(turnNullToString(this.bonusInfoSchema.getBonusWay()))) && 
/* 2111 */             (turnNullToString(newbonusschema.getP1()).equals(turnNullToString(this.bonusInfoSchema.getP1()))) && 
/* 2112 */             (turnNullToString(newbonusschema.getP2()).equals(turnNullToString(this.bonusInfoSchema.getP2())))) {
/* 2113 */             if ((("02".equals(polsetpage.get(j).getUWCode())) && (!turnNullToString(Double.valueOf(polsetpage.get(j).getPrem())).equals(turnNullToString(Double.valueOf(polsetbase.get(i).getPrem()))))) || (
/* 2114 */               ("01".equals(polsetpage.get(j).getUWCode())) && (!turnNullToString(Double.valueOf(polsetpage.get(j).getAmnt())).equals(turnNullToString(Double.valueOf(polsetbase.get(i).getAmnt()))))))
/*      */             {
/* 2116 */               flagthree = false;
/* 2117 */               break;
/*      */             }
/* 2119 */             this.message = "\u6B64\u65F6\u754C\u9762\u526F\u9669\u79CD\u4FE1\u606F\u4E0E\u6570\u636E\u5E93\u4E2D\u4FE1\u606F\u4E00\u81F4\u65E0\u4FEE\u6539";
/* 2120 */             System.out.println("\u6B64\u65F6\u754C\u9762\u526F\u9669\u79CD\u4FE1\u606F\u4E0E\u6570\u636E\u5E93\u4E2D\u4FE1\u606F\u4E00\u81F4\u65E0\u4FEE\u6539");
/* 2121 */             flagthree = true;
/*      */           } else {
/* 2123 */             flagthree = false;
/* 2124 */             break;
/*      */           }
/* 2094 */           i++;
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/* 2128 */       System.out.println("\u5F53\u524Dflagthree\u7684\u503C\u4E3A===" + flags);
/* 2129 */       if (!flagthree)
/*      */       {
/* 2131 */         List stateList = stateOperate.changeMsgToModify(this.contSchema.getState(), this.contSchema.getEditstate(), this.tempGI.LNPRole);
/* 2132 */         if (stateList.size() > 0) {
/* 2133 */           System.out.println("-------\u56E0\u4E3A\u6709\u4FDD\u5355\u4FE1\u606F\u88AB\u4FEE\u6539,\u5C06\u56DE\u6EDA\u4FDD\u5355\u72B6\u6001\u503C02\u5F85\u5BA1\u6838\u72B6\u6001---------");
/* 2134 */           changeStateflag = true;
/* 2135 */           this.contSchema.setState((String)stateList.get(0));
/* 2136 */           this.contSchema.setEditstate((String)stateList.get(1));
/*      */         } else {
/* 2138 */           System.out.println("\u5F53\u524D\u64CD\u4F5C\u4E0D\u9700\u8981\u8FDB\u884C\u72B6\u6001\u56DE\u6EDA");
/*      */         }
/*      */ 
/* 2141 */         this.contSchema.setInputOperator(this.tempGI.Operator);
/* 2142 */         this.contSchema.setModifyDate(date);
/* 2143 */         this.contSchema.setModifyTime(time);
/* 2144 */         PubSubmit ps = new PubSubmit();
/* 2145 */         MMap map = new MMap();
/* 2146 */         map.put(polsetbase, "DELETE");
/* 2147 */         map.put(this.bonusInfoSchema, "DELETE");
/* 2148 */         map.put(this.investSchema, "DELETE");
/*      */ 
/* 2150 */         map.put(polsetpage, "INSERT");
/* 2151 */         map.put(newbonusschema, "INSERT");
/* 2152 */         map.put(this.contSchema, "UPDATE");
/* 2153 */         System.out.println("update ok");
/* 2154 */         VData vd = new VData();
/* 2155 */         vd.add(map);
/* 2156 */         if (!ps.submitData(vd, "")) {
/* 2157 */           this.message = "\u6295\u4FDD\u4E8B\u9879\u4FE1\u606F\u4FDD\u5B58\u9519\u8BEF\uFF01";
/* 2158 */           System.out.println("\u6295\u4FDD\u4E8B\u9879\u4FDD\u5B58\u5931\u8D25");
/* 2159 */           flagthree = false;
/*      */         }
/*      */         else
/*      */         {
/*      */           try
/*      */           {
/* 2166 */             flagthree = true;
/* 2167 */             this.infoSource = "modify";
/* 2168 */             this.policyState = new BankPolicyState();
/* 2169 */             if (changeStateflag) {
/* 2170 */               this.policyState.savePolicyState(this.contSchema.getContNo(), this.contSchema.getState(), "3", date, time);
/*      */             }
/* 2172 */             this.message = "\u6295\u4FDD\u4E8B\u9879\u4FE1\u606F\u4FDD\u5B58\u6210\u529F\uFF01";
/* 2173 */             System.out.println("\u4FDD\u5B58\u6210\u529F");
/*      */           } catch (Exception e) {
/* 2175 */             this.message = "\u64CD\u4F5C\u8BB0\u5F55\u63A5\u53E3\u51FA\u95EE\u9898\u4E86";
/* 2176 */             System.out.println("\u64CD\u4F5C\u8BB0\u5F55\u63A5\u53E3\u51FA\u95EE\u9898\u4E86");
/* 2177 */             e.printStackTrace();
/*      */           }
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 2185 */     if ((polsetpage.size() == 0) && (polsetbase.size() == 0)) {
/* 2186 */       flagthree = true;
/*      */     }
/*      */ 
/* 2193 */     if (polsetpage.size() == 0) {
/* 2194 */       if (polsetbase.size() != 0)
/*      */       {
/* 2196 */         List stateList = stateOperate.changeMsgToModify(this.contSchema.getState(), this.contSchema.getEditstate(), this.tempGI.LNPRole);
/* 2197 */         if (stateList.size() > 0) {
/* 2198 */           System.out.println("-------\u56E0\u4E3A\u6709\u4FDD\u5355\u4FE1\u606F\u88AB\u4FEE\u6539,\u5C06\u56DE\u6EDA\u4FDD\u5355\u72B6\u6001\u503C02\u5F85\u5BA1\u6838\u72B6\u6001---------");
/* 2199 */           changeStateflag = true;
/* 2200 */           this.contSchema.setState((String)stateList.get(0));
/* 2201 */           this.contSchema.setEditstate((String)stateList.get(1));
/*      */         } else {
/* 2203 */           System.out.println("\u5F53\u524D\u64CD\u4F5C\u4E0D\u9700\u8981\u8FDB\u884C\u72B6\u6001\u56DE\u6EDA");
/*      */         }
/*      */ 
/* 2206 */         System.out.println("\u5F00\u59CB\u4FDD\u5B58\u7EC4\u5408\u9669\u79CD\u6570\u636E33333333---------------");
/* 2207 */         this.contSchema.setInputOperator(this.tempGI.Operator);
/* 2208 */         this.contSchema.setModifyDate(date);
/* 2209 */         this.contSchema.setModifyTime(time);
/* 2210 */         PubSubmit ps = new PubSubmit();
/* 2211 */         MMap map = new MMap();
/* 2212 */         map.put(polsetbase, "DELETE");
/* 2213 */         map.put(this.bonusInfoSchema, "DELETE");
/* 2214 */         map.put(this.investSchema, "DELETE");
/* 2215 */         map.put(this.contSchema, "UPDATE");
/*      */ 
/* 2217 */         VData vd = new VData();
/* 2218 */         vd.add(map);
/* 2219 */         if (!ps.submitData(vd, "")) {
/* 2220 */           this.message = "\u6295\u4FDD\u4E8B\u9879\u4FE1\u606F\u4FDD\u5B58\u9519\u8BEF\uFF01";
/* 2221 */           System.out.println("\u6295\u4FDD\u4E8B\u9879\u4FDD\u5B58\u5931\u8D25");
/* 2222 */           flagthree = false;
/*      */         } else {
/*      */           try {
/* 2225 */             flagthree = true;
/* 2226 */             this.infoSource = "modify";
/* 2227 */             this.policyState = new BankPolicyState();
/* 2228 */             if (changeStateflag) {
/* 2229 */               this.policyState.savePolicyState(this.contSchema.getContNo(), this.contSchema.getState(), "3", date, time);
/*      */             }
/* 2231 */             this.message = "\u6295\u4FDD\u4E8B\u9879\u4FE1\u606F\u4FDD\u5B58\u6210\u529F\uFF01";
/* 2232 */             System.out.println("\u4FDD\u5B58\u6210\u529F");
/*      */           } catch (Exception e) {
/* 2234 */             this.message = "\u64CD\u4F5C\u8BB0\u5F55\u63A5\u53E3\u51FA\u95EE\u9898\u4E86";
/* 2235 */             System.out.println("\u64CD\u4F5C\u8BB0\u5F55\u63A5\u53E3\u51FA\u95EE\u9898\u4E86");
/* 2236 */             e.printStackTrace();
/*      */           }
/*      */         }
/*      */       } else {
/* 2240 */         System.out.println("\u6570\u636E\u5E93\u4E2D\u65E0\u6570\u636E\uFF0C\u9875\u9762\u4E5F\u65E0\u6570\u636E\uFF0C\u6B64\u65F6\u4E0D\u5BF9\u6570\u636E\u5E93\u8FDB\u884C\u64CD\u4F5C");
/* 2241 */         flagthree = false;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 2416 */     return flagthree;
/*      */   }
/*      */ 
/*      */   private boolean saveTypeFour()
/*      */   {
/* 2427 */     boolean flagFour = false;
/* 2428 */     this.contSchema = getMyLNPContByContNo(this.contNo);
/* 2429 */     this.bonusInfoSchema = getBonusSchemaByContNo(this.contNo);
/* 2430 */     LNPPolSet polsetbase = getPolByContNo(this.contNo);
/* 2431 */     String date = PubFun.getCurrentDate();
/* 2432 */     String time = PubFun.getCurrentTime();
/* 2433 */     this.polSchema = new LNPPolSchema();
/* 2434 */     LNPPolSet polsetpage = new LNPPolSet();
/* 2435 */     LNPBonusInfoSchema newbonusschema = new LNPBonusInfoSchema();
/* 2436 */     SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
/* 2437 */     String tIndex = "";
/* 2438 */     if ((this.yearmoneychangeriskcode != null) && (!this.yearmoneychangeriskcode.equals("")))
/*      */     {
/* 2440 */       this.polSchema.setKindCode(this.poltype);
/* 2441 */       this.polSchema.setRiskVersion(this.yearmoneychangeriskcode);
/* 2442 */       this.polSchema.setSubFlag("M");
/*      */ 
/* 2444 */       if (this.yearmoneychangeyears.startsWith("\u7EC8\u8EAB")) {
/* 2445 */         this.polSchema.setPayLocation(String.valueOf(SpecialProductFun.getRiskPro(this.polSchema.getRiskCode())));
/* 2446 */         this.polSchema.setPremToAmnt("A");
/*      */       }
/* 2448 */       if ((this.yearmoneychangeyears.startsWith("T")) || (this.yearmoneychangeyears.startsWith("t"))) {
/* 2449 */         this.polSchema.setPayLocation(this.yearmoneychangeyears.replaceAll("^[Tt](\\d+)$", "$1"));
/* 2450 */         this.polSchema.setPremToAmnt("A");
/*      */       }
/* 2452 */       if (this.yearmoneychangeyears.matches("^[1-9][0-9]*$")) {
/* 2453 */         this.polSchema.setPayLocation(this.yearmoneychangeyears.replace("", ""));
/* 2454 */         this.polSchema.setPremToAmnt("Y");
/*      */       }
/* 2456 */       if ((this.yearmoneychangeyears == null) || (this.yearmoneychangeyears.equals(""))) {
/* 2457 */         this.polSchema.setPayLocation("");
/* 2458 */         this.polSchema.setPremToAmnt("");
/*      */       }
/* 2460 */       if (this.yearmoneychangeyears.equals("0")) {
/* 2461 */         this.polSchema.setPayLocation("0");
/* 2462 */         this.polSchema.setPremToAmnt("");
/*      */       }
/*      */ 
/* 2466 */       if (this.yearmoneychangepayyears.equals("0")) {
/* 2467 */         this.polSchema.setPayMode("1000");
/* 2468 */         this.polSchema.setAcciYearFlag("Y");
/*      */       }
/* 2470 */       if ((this.yearmoneychangepayyears.startsWith("T")) || (this.yearmoneychangepayyears.startsWith("t"))) {
/* 2471 */         this.polSchema.setPayMode(this.yearmoneychangepayyears.replaceAll("^[Tt](\\d+)$", "$1"));
/* 2472 */         this.polSchema.setAcciYearFlag("A");
/*      */       }
/* 2474 */       if (this.yearmoneychangepayyears.matches("^[1-9][0-9]*$")) {
/* 2475 */         this.polSchema.setPayMode(this.yearmoneychangepayyears.replace("", ""));
/* 2476 */         this.polSchema.setAcciYearFlag("Y");
/*      */       }
/* 2478 */       if ((this.yearmoneychangepayyears == null) || (this.yearmoneychangepayyears.equals(""))) {
/* 2479 */         this.polSchema.setPayMode("");
/* 2480 */         this.polSchema.setAcciYearFlag("");
/*      */       }
/*      */ 
/* 2483 */       if ("".equals(turnNullToString(this.yearmoneychangemoney).trim()))
/* 2484 */         this.polSchema.setRemark("");
/*      */       else {
/* 2486 */         this.polSchema.setRemark(decimalFormat.format(Double.valueOf(this.yearmoneychangemoney)).toString());
/*      */       }
/*      */ 
/* 2489 */       if ((this.yearmoneychangegetyear == null) || (this.yearmoneychangegetyear.equals(""))) {
/* 2490 */         this.polSchema.setGetYear("-1");
/*      */       } else {
/* 2492 */         this.polSchema.setGetYear(this.getyear);
/* 2493 */         this.polSchema.setGetYearFlag("A");
/*      */       }
/* 2495 */       this.polSchema.setRnewFlag("2");
/*      */ 
/* 2499 */       this.polSchema.setPayIntv(this.payintv.intValue());
/* 2500 */       this.contSchema.setPayIntv(this.polSchema.getPayIntv());
/* 2501 */       this.polSchema.setDeadGetMode(this.deadgetmode);
/* 2502 */       this.polSchema.setStandbyFlag3(this.annuityfrequency);
/*      */ 
/* 2505 */       this.polSchema.setGrpContNo("00000000000000000000");
/* 2506 */       this.polSchema.setGrpPolNo("00000000000000000000");
/* 2507 */       this.polSchema.setContNo(this.contNo);
/* 2508 */       this.polSchema.setProposalContNo(this.contNo);
/* 2509 */       tIndex = maxNoMap.CreateMaxNo("CustomerNo", "");
/* 2510 */       this.polSchema.setPolNo(tIndex);
/* 2511 */       this.polSchema.setRiskCode("");
/*      */ 
/* 2513 */       this.polSchema.setProposalNo(tIndex);
/* 2514 */       this.polSchema.setPrtNo("00000000000000000000");
/* 2515 */       this.polSchema.setContType("1");
/* 2516 */       this.polSchema.setManageCom(this.contSchema.getSignCom());
/* 2517 */       this.polSchema.setMakeDate(date);
/* 2518 */       this.polSchema.setMakeTime(time);
/* 2519 */       this.polSchema.setModifyDate(date);
/* 2520 */       this.polSchema.setModifyTime(time);
/* 2521 */       this.polSchema.setOperator(this.tempGI.Operator);
/* 2522 */       this.polSchema.setGetYear(this.yearmoneychangegetyear);
/* 2523 */       this.polSchema.setUWTime(this.salechannel);
/* 2524 */       polsetpage.add(this.polSchema);
/*      */     } else {
/* 2526 */       System.out.println("---\u5E74\u91D1\u8F6C\u6362\u9669\u79CD---\u9669\u79CD\u4EE3\u7801\u672A\u5F55\u5165\uFF0C\u6570\u636E\u4E0D\u4F1A\u4FDD\u5B58\u5230\u6570\u636E\u5E93\u4E2D---");
/*      */     }
/* 2528 */     System.out.println("polsetpage.size==================" + polsetpage.size());
/*      */ 
/* 2532 */     newbonusschema.setGrpContNo("00000000000000000000");
/* 2533 */     newbonusschema.setContNo(this.contNo);
/* 2534 */     newbonusschema.setProposalContNo(this.contNo);
/* 2535 */     newbonusschema.setPrtNo("00000000000000000000");
/* 2536 */     newbonusschema.setBonusWay(this.bonusgetmode);
/* 2537 */     newbonusschema.setP1(this.overflowpremium);
/* 2538 */     newbonusschema.setP2(this.overduepremium);
/* 2539 */     newbonusschema.setOperator(this.tempGI.Operator);
/* 2540 */     newbonusschema.setMakeDate(date);
/* 2541 */     newbonusschema.setMakeTime(time);
/* 2542 */     newbonusschema.setModifyDate(date);
/* 2543 */     newbonusschema.setModifyTime(time);
/*      */ 
/* 2546 */     this.allCompelte = false;
/* 2547 */     this.allCompelte = checkAllCompelte(polsetpage, newbonusschema, null);
/*      */ 
/* 2549 */     boolean changeStateflag = false;
/* 2550 */     BankOperateDeal stateOperate = new BankOperateDeal();
/*      */ 
/* 2552 */     if (this.allCompelte)
/*      */     {
/* 2554 */       List stateList = stateOperate.infoOprate(this.contSchema.getState(), this.contSchema.getEditstate(), "modify", "02");
/* 2555 */       this.contSchema.setState((String)stateList.get(0));
/* 2556 */       this.contSchema.setEditstate((String)stateList.get(1));
/* 2557 */     } else if ("01".equals(this.contSchema.getState())) {
/* 2558 */       String editState = stateOperate.updateEditStateUNDone(this.contSchema.getEditstate(), 2);
/* 2559 */       this.contSchema.setEditstate(editState);
/*      */     }
/* 2561 */     System.out.println("---------------------------------------------" + this.contSchema.getEditstate());
/*      */ 
/* 2563 */     if (polsetpage.size() != 0) {
/* 2564 */       if (polsetbase.size() == 0) {
/* 2565 */         System.out.println("--------\u5F00\u59CB\u4FDD\u5B58\u5E74\u91D1\u8F6C\u6362\u9669\u79CD---------");
/* 2566 */         this.contSchema.setInputOperator(this.tempGI.Operator);
/* 2567 */         this.contSchema.setModifyDate(date);
/* 2568 */         this.contSchema.setModifyTime(time);
/* 2569 */         PubSubmit ps = new PubSubmit();
/* 2570 */         MMap map = new MMap();
/* 2571 */         map.put(this.polSchema, "INSERT");
/* 2572 */         map.put(newbonusschema, "INSERT");
/* 2573 */         map.put(this.contSchema, "UPDATE");
/* 2574 */         VData vd = new VData();
/* 2575 */         vd.add(map);
/* 2576 */         if (!ps.submitData(vd, "")) {
/* 2577 */           this.message = "\u6295\u4FDD\u4E8B\u9879\u4FE1\u606F\u4FDD\u5B58\u9519\u8BEF\uFF01";
/* 2578 */           System.out.println("\u6295\u4FDD\u4E8B\u9879\u4FDD\u5B58\u5931\u8D25");
/* 2579 */           flagFour = false;
/*      */         } else {
/*      */           try {
/* 2582 */             flagFour = true;
/* 2583 */             this.infoSource = "modify";
/* 2584 */             this.policyState = new BankPolicyState();
/* 2585 */             if (changeStateflag) {
/* 2586 */               this.policyState.savePolicyState(this.contSchema.getContNo(), this.contSchema.getState(), "3", date, time);
/*      */             }
/* 2588 */             this.message = "\u6295\u4FDD\u4E8B\u9879\u4FE1\u606F\u4FDD\u5B58\u6210\u529F\uFF01";
/* 2589 */             System.out.println("\u4FDD\u5B58\u6210\u529F");
/*      */           }
/*      */           catch (Exception e) {
/* 2592 */             this.message = "\u64CD\u4F5C\u8BB0\u5F55\u63A5\u53E3\u51FA\u95EE\u9898\u4E86";
/* 2593 */             System.out.println("\u64CD\u4F5C\u8BB0\u5F55\u63A5\u53E3\u51FA\u95EE\u9898\u4E86");
/* 2594 */             e.printStackTrace();
/*      */           }
/*      */         }
/*      */       }
/*      */       else {
/* 2599 */         boolean MPolFlag = false;
/* 2600 */         LNPPolSchema polbaseschema = new LNPPolSchema();
/* 2601 */         for (int i = 1; i <= polsetbase.size(); i++) {
/* 2602 */           if (polsetbase.get(i).getRnewFlag().equals("2")) {
/* 2603 */             polbaseschema = polsetbase.get(i);
/* 2604 */             MPolFlag = true;
/* 2605 */             break;
/*      */           }
/*      */         }
/* 2608 */         if (!MPolFlag) {
/* 2609 */           System.out.println("--ZH------------------>\u672A\u627E\u5230\u4E3B\u9669");
/* 2610 */           return flagFour = 0;
/*      */         }
/* 2612 */         if ((turnNullToString(this.polSchema.getUWTime()).equals(turnNullToString(polbaseschema.getUWTime()))) && 
/* 2613 */           (turnNullToString(this.polSchema.getRiskVersion()).equals(turnNullToString(polbaseschema.getRiskVersion()))) && 
/* 2614 */           (turnNullToString(this.polSchema.getPayLocation()).equals(turnNullToString(polbaseschema.getPayLocation()))) && 
/* 2615 */           (turnNullToString(this.polSchema.getPremToAmnt()).equals(turnNullToString(polbaseschema.getPremToAmnt()))) && 
/* 2616 */           (turnNullToString(this.polSchema.getPayMode()).equals(turnNullToString(polbaseschema.getPayMode()))) && 
/* 2617 */           (turnNullToString(this.polSchema.getAcciYearFlag()).equals(turnNullToString(polbaseschema.getAcciYearFlag()))) && 
/* 2618 */           (turnNullToString(this.polSchema.getRemark()).equals(turnNullToString(polbaseschema.getRemark()))) && 
/* 2619 */           (turnNullToString(Integer.valueOf(this.polSchema.getGetYear())).equals(turnNullToString(Integer.valueOf(polbaseschema.getGetYear())))) && 
/* 2620 */           (turnNullToString(this.polSchema.getGetYearFlag()).equals(turnNullToString(polbaseschema.getGetYearFlag()))) && 
/* 2621 */           (turnNullToString(Integer.valueOf(this.polSchema.getPayIntv())).equals(turnNullToString(Integer.valueOf(polbaseschema.getPayIntv())))) && 
/* 2622 */           (turnNullToString(this.polSchema.getDeadGetMode()).equals(turnNullToString(polbaseschema.getDeadGetMode()))) && 
/* 2623 */           (turnNullToString(this.polSchema.getStandbyFlag3()).equals(turnNullToString(polbaseschema.getStandbyFlag3()))) && 
/* 2624 */           (turnNullToString(newbonusschema.getBonusWay()).equals(turnNullToString(this.bonusInfoSchema.getBonusWay()))) && 
/* 2625 */           (turnNullToString(newbonusschema.getP1()).equals(turnNullToString(this.bonusInfoSchema.getP1()))) && 
/* 2626 */           (turnNullToString(newbonusschema.getP2()).equals(turnNullToString(this.bonusInfoSchema.getP2())))) {
/* 2627 */           this.message = "\u6B64\u65F6\u754C\u9762\u9669\u79CD\u4FE1\u606F\u4E0E\u6570\u636E\u5E93\u4E2D\u4FE1\u606F\u4E00\u81F4\u65E0\u4FEE\u6539";
/* 2628 */           System.out.println("\u6B64\u65F6\u754C\u9762\u9669\u79CD\u4FE1\u606F\u4E0E\u6570\u636E\u5E93\u4E2D\u4FE1\u606F\u4E00\u81F4\u65E0\u4FEE\u6539");
/* 2629 */           flagFour = true;
/*      */         } else {
/* 2631 */           flagFour = false;
/*      */         }
/*      */ 
/* 2634 */         if (!flagFour)
/*      */         {
/* 2639 */           String oldUWTime = turnNullToString(polbaseschema.getUWTime());
/* 2640 */           String newUWTime = turnNullToString(this.polSchema.getUWTime());
/*      */ 
/* 2643 */           LNPAgentInfoSchema agentInfoSchema = null;
/* 2644 */           LNPAgentInfoDB agentInfoDB = new LNPAgentInfoDB();
/* 2645 */           agentInfoDB.setContNo(this.contNo);
/* 2646 */           LNPAgentInfoSet agentInfoSet = agentInfoDB.query();
/*      */ 
/* 2648 */           if (agentInfoSet.size() > 0) {
/* 2649 */             agentInfoSchema = agentInfoSet.get(1);
/*      */ 
/* 2651 */             if ((oldUWTime.equals("BXS")) && ((newUWTime.equals("AGY")) || (newUWTime.equals("TM")))) {
/* 2652 */               agentInfoSchema.setP2("");
/* 2653 */               agentInfoSchema.setAgentCode("");
/* 2654 */               agentInfoSchema.setOperator(this.tempGI.Operator);
/* 2655 */               agentInfoSchema.setModifyDate(date);
/* 2656 */               agentInfoSchema.setModifyTime(time);
/*      */             }
/*      */ 
/*      */           }
/*      */ 
/* 2662 */           LNPCustImpResultDB resultDB = new LNPCustImpResultDB();
/* 2663 */           resultDB.setContNo(this.contNo);
/* 2664 */           LNPCustImpResultSet resultSet = resultDB.query();
/*      */ 
/* 2666 */           if ((!oldUWTime.equals(newUWTime)) && (resultSet.size() > 0))
/*      */           {
/* 2668 */             String editstate = stateOperate.updateEditStateDone(this.contSchema.getEditstate(), 4);
/* 2669 */             this.contSchema.setEditstate(editstate);
/*      */           }
/*      */ 
/* 2673 */           List stateList = stateOperate.changeMsgToModify(this.contSchema.getState(), this.contSchema.getEditstate(), this.tempGI.LNPRole);
/* 2674 */           if (stateList.size() > 0) {
/* 2675 */             System.out.println("-------\u56E0\u4E3A\u6709\u4FDD\u5355\u4FE1\u606F\u88AB\u4FEE\u6539,\u5C06\u56DE\u6EDA\u4FDD\u5355\u72B6\u6001\u503C02\u5F85\u5BA1\u6838\u72B6\u6001---------");
/* 2676 */             changeStateflag = true;
/* 2677 */             this.contSchema.setState((String)stateList.get(0));
/* 2678 */             this.contSchema.setEditstate((String)stateList.get(1));
/*      */           } else {
/* 2680 */             System.out.println("\u5F53\u524D\u64CD\u4F5C\u4E0D\u9700\u8981\u8FDB\u884C\u72B6\u6001\u56DE\u6EDA");
/*      */           }
/*      */ 
/* 2683 */           this.contSchema.setInputOperator(this.tempGI.Operator);
/* 2684 */           this.contSchema.setModifyDate(date);
/* 2685 */           this.contSchema.setModifyTime(time);
/* 2686 */           PubSubmit ps = new PubSubmit();
/* 2687 */           MMap map = new MMap();
/* 2688 */           map.put(polsetbase, "DELETE");
/* 2689 */           map.put(this.bonusInfoSchema, "DELETE");
/* 2690 */           map.put(this.investSchema, "DELETE");
/* 2691 */           map.put(this.polSchema, "INSERT");
/* 2692 */           map.put(newbonusschema, "INSERT");
/* 2693 */           map.put(this.contSchema, "UPDATE");
/* 2694 */           map.put(agentInfoSchema, "UPDATE");
/* 2695 */           map.put(resultSet, "DELETE");
/* 2696 */           VData vd = new VData();
/* 2697 */           vd.add(map);
/* 2698 */           if (!ps.submitData(vd, "")) {
/* 2699 */             this.message = "\u6295\u4FDD\u4E8B\u9879\u4FE1\u606F\u4FDD\u5B58\u9519\u8BEF\uFF01";
/* 2700 */             System.out.println("\u6295\u4FDD\u4E8B\u9879\u4FDD\u5B58\u5931\u8D25");
/* 2701 */             flagFour = false;
/*      */           } else {
/*      */             try {
/* 2704 */               flagFour = true;
/* 2705 */               this.infoSource = "modify";
/* 2706 */               this.policyState = new BankPolicyState();
/* 2707 */               if (changeStateflag) {
/* 2708 */                 this.policyState.savePolicyState(this.contSchema.getContNo(), this.contSchema.getState(), "3", date, time);
/*      */               }
/* 2710 */               this.message = "\u6295\u4FDD\u4E8B\u9879\u4FE1\u606F\u4FDD\u5B58\u6210\u529F\uFF01";
/* 2711 */               System.out.println("\u4FDD\u5B58\u6210\u529F");
/*      */             }
/*      */             catch (Exception e)
/*      */             {
/* 2715 */               this.message = "\u64CD\u4F5C\u8BB0\u5F55\u63A5\u53E3\u51FA\u95EE\u9898\u4E86";
/* 2716 */               System.out.println("\u64CD\u4F5C\u8BB0\u5F55\u63A5\u53E3\u51FA\u95EE\u9898\u4E86");
/* 2717 */               e.printStackTrace();
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/* 2723 */     else if (polsetpage.size() == 0) {
/* 2724 */       if (polsetbase.size() != 0)
/*      */       {
/* 2726 */         List stateList = stateOperate.changeMsgToModify(this.contSchema.getState(), this.contSchema.getEditstate(), this.tempGI.LNPRole);
/* 2727 */         if (stateList.size() > 0) {
/* 2728 */           System.out.println("-------\u56E0\u4E3A\u6709\u4FDD\u5355\u4FE1\u606F\u88AB\u4FEE\u6539,\u5C06\u56DE\u6EDA\u4FDD\u5355\u72B6\u6001\u503C02\u5F85\u5BA1\u6838\u72B6\u6001---------");
/* 2729 */           changeStateflag = true;
/* 2730 */           this.contSchema.setState((String)stateList.get(0));
/* 2731 */           this.contSchema.setEditstate((String)stateList.get(1));
/*      */         } else {
/* 2733 */           System.out.println("\u5F53\u524D\u64CD\u4F5C\u4E0D\u9700\u8981\u8FDB\u884C\u72B6\u6001\u56DE\u6EDA");
/*      */         }
/*      */ 
/* 2736 */         System.out.println("\u5F00\u59CB\u4FDD\u5B58\u5E74\u91D1\u8F6C\u6362\u9669\u79CD---------------");
/* 2737 */         this.contSchema.setInputOperator(this.tempGI.Operator);
/* 2738 */         this.contSchema.setModifyDate(date);
/* 2739 */         this.contSchema.setModifyTime(time);
/* 2740 */         PubSubmit ps = new PubSubmit();
/* 2741 */         MMap map = new MMap();
/* 2742 */         map.put(polsetbase, "DELETE");
/* 2743 */         map.put(this.bonusInfoSchema, "DELETE");
/* 2744 */         map.put(this.investSchema, "DELETE");
/* 2745 */         map.put(this.contSchema, "UPDATE");
/* 2746 */         VData vd = new VData();
/* 2747 */         vd.add(map);
/* 2748 */         if (!ps.submitData(vd, "")) {
/* 2749 */           this.message = "\u6295\u4FDD\u4E8B\u9879\u4FE1\u606F\u4FDD\u5B58\u9519\u8BEF\uFF01";
/* 2750 */           System.out.println("\u6295\u4FDD\u4E8B\u9879\u4FDD\u5B58\u5931\u8D25");
/* 2751 */           flagFour = false;
/*      */         } else {
/*      */           try {
/* 2754 */             flagFour = true;
/* 2755 */             this.infoSource = "modify";
/* 2756 */             this.policyState = new BankPolicyState();
/* 2757 */             if (changeStateflag) {
/* 2758 */               this.policyState.savePolicyState(this.contSchema.getContNo(), this.contSchema.getState(), "3", date, time);
/*      */             }
/* 2760 */             this.message = "\u6295\u4FDD\u4E8B\u9879\u4FE1\u606F\u4FDD\u5B58\u6210\u529F\uFF01";
/* 2761 */             System.out.println("\u4FDD\u5B58\u6210\u529F");
/*      */           } catch (Exception e) {
/* 2763 */             this.message = "\u64CD\u4F5C\u8BB0\u5F55\u63A5\u53E3\u51FA\u95EE\u9898\u4E86";
/* 2764 */             System.out.println("\u64CD\u4F5C\u8BB0\u5F55\u63A5\u53E3\u51FA\u95EE\u9898\u4E86");
/* 2765 */             e.printStackTrace();
/*      */           }
/*      */         }
/*      */       } else {
/* 2769 */         System.out.println("\u6570\u636E\u5E93\u4E2D\u65E0\u6570\u636E\uFF0C\u9875\u9762\u4E5F\u65E0\u6570\u636E\uFF0C\u6B64\u65F6\u4E0D\u5BF9\u6570\u636E\u5E93\u8FDB\u884C\u64CD\u4F5C");
/* 2770 */         flagFour = false;
/*      */       }
/*      */     }
/* 2773 */     return flagFour;
/*      */   }
/*      */ 
/*      */   private boolean checkAllCompelte(LNPPolSet polsetpage, LNPBonusInfoSchema infoschema, LNPInvestmentInfoSchema newinvestSchema)
/*      */   {
/*      */     try
/*      */     {
/* 2789 */       System.out.println("-----\u5F00\u59CB\u8C03\u7528\u5FC5\u5F55\u9879\u6821\u9A8C-------");
/*      */ 
/* 2791 */       boolean checkflag = false;
/* 2792 */       if ((polsetpage == null) || (polsetpage.size() == 0)) {
/* 2793 */         checkflag = false;
/* 2794 */       } else if (polsetpage.get(1).getKindCode().equals("01")) {
/* 2795 */         System.out.println("------\u4F20\u7EDF\u9669(01)\u5FC5\u5F55\u9879\u6821\u9A8C------");
/* 2796 */         for (int i = 1; i <= polsetpage.size(); i++)
/*      */         {
/* 2801 */           if ((!polsetpage.get(i).getRiskCode().equals("")) && (polsetpage.get(i).getGetYear() >= 0) && 
/* 2802 */             (polsetpage.get(i).getPayIntv() != -1) && (!infoschema.getP1().equals("")) && 
/* 2803 */             (infoschema.getP1() != null) && (!infoschema.getP2().equals(""))) {
/* 2804 */             checkflag = true;
/*      */           } else {
/* 2806 */             checkflag = false;
/* 2807 */             break;
/*      */           }
/*      */         }
/* 2810 */       } else if (polsetpage.get(1).getKindCode().equals("02")) {
/* 2811 */         System.out.println("------VUL\u9669(02)\u5FC5\u5F55\u9879\u6821\u9A8C------");
/* 2812 */         for (int i = 1; i <= polsetpage.size(); i++)
/* 2813 */           if ((!polsetpage.get(i).getRiskCode().equals("")) && (polsetpage.get(i).getPrem() != 0.0D)) {
/* 2814 */             checkflag = true;
/*      */           } else {
/* 2816 */             checkflag = false;
/* 2817 */             break;
/*      */           }
/*      */       }
/* 2820 */       else if (polsetpage.get(1).getKindCode().equals("03")) {
/* 2821 */         System.out.println("------\u7EC4\u5408\u9669(03)\u5FC5\u5F55\u9879\u6821\u9A8C------==" + polsetpage.size());
/* 2822 */         for (int i = 1; i <= polsetpage.size(); i++) {
/* 2823 */           System.out.println("------\u7EC4\u5408\u9669(03)\u5FC5\u5F55\u9879\u6821\u9A8C------==\u300B" + i + "==>" + polsetpage.get(i).getRnewFlag());
/* 2824 */           System.out.println("polsetpage.get(i)====" + polsetpage.get(i).getRnewFlag().equals("1"));
/* 2825 */           if ((polsetpage.get(i).getRnewFlag() == null) || (polsetpage.get(i).getRnewFlag().equals("")) || (!polsetpage.get(i).getRnewFlag().equals("1")) || 
/* 2826 */             (i != 1)) continue;
/* 2827 */           System.out.println("==================\u5F00\u59CB\u6821\u9A8C=================================");
/* 2828 */           System.out.println("polsetpage.get(i).getRiskVersion()\u7ED3\u679C\uFF1A" + polsetpage.get(i).getRiskVersion());
/* 2829 */           System.out.println("polsetpage.get(i).getRemark()\u7ED3\u679C\uFF1A" + polsetpage.get(i).getRemark());
/* 2830 */           System.out.println("polsetpage.get(i).getPayIntv()\u7ED3\u679C\uFF1A" + polsetpage.get(i).getPayIntv());
/* 2831 */           System.out.println("polsetpage.get(i).getP1()\u7ED3\u679C\uFF1A" + infoschema.getP1());
/* 2832 */           System.out.println("polsetpage.get(i).getP2()\u7ED3\u679C\uFF1A" + infoschema.getP2());
/* 2833 */           if ((!polsetpage.get(i).getRiskVersion().equals("")) && (!polsetpage.get(i).getRemark().equals("")) && 
/* 2834 */             (polsetpage.get(i).getPayIntv() != -1) && (!infoschema.getP1().equals("")) && 
/* 2835 */             (infoschema.getP1() != null) && (!infoschema.getP2().equals(""))) {
/* 2836 */             checkflag = true;
/*      */           } else {
/* 2838 */             checkflag = false;
/* 2839 */             break;
/*      */           }
/* 2841 */           System.out.println("------\u7EC4\u5408\u9669(03)\u5FC5\u5F55\u9879\u6821\u9A8C------1\u7ED3\u679C" + checkflag);
/*      */         }
/*      */ 
/*      */       }
/* 2845 */       else if (polsetpage.get(1).getKindCode().equals("04")) {
/* 2846 */         System.out.println("------\u5E74\u91D1\u8F6C\u6362(04)\u5FC5\u5F55\u9879\u6821\u9A8C------");
/* 2847 */         for (int i = 1; i <= polsetpage.size(); i++) {
/* 2848 */           if ((polsetpage.get(i).getRnewFlag() == null) || (polsetpage.get(i).getRnewFlag().equals("")) || 
/* 2849 */             (!polsetpage.get(i).getRnewFlag().equals("2"))) continue;
/* 2850 */           if ((polsetpage.get(i).getUWTime() != null) && (!polsetpage.get(i).getUWTime().equals("-1")) && (!polsetpage.get(i).getUWTime().equals("")) && 
/* 2851 */             (!polsetpage.get(i).getRiskVersion().equals("")) && 
/* 2852 */             (!polsetpage.get(i).getPayLocation().equals("")) && (!polsetpage.get(i).getPremToAmnt().equals("")) && 
/* 2853 */             (!polsetpage.get(i).getPayMode().equals("")) && (!polsetpage.get(i).getAcciYearFlag().equals("")) && 
/* 2854 */             (!polsetpage.get(i).getRemark().equals("")) && 
/* 2855 */             (polsetpage.get(i).getGetYear() >= 0) && 
/* 2856 */             (polsetpage.get(i).getPayIntv() != -1) && 
/* 2857 */             (!infoschema.getP1().equals("")) && (infoschema.getP1() != null) && 
/* 2858 */             (!infoschema.getP2().equals("")) && 
/* 2859 */             (!polsetpage.get(i).getDeadGetMode().equals("")) && (!polsetpage.get(i).getDeadGetMode().equals("-1")) && 
/* 2860 */             (!polsetpage.get(i).getStandbyFlag3().equals("")) && (!polsetpage.get(i).getStandbyFlag3().equals("-1"))) {
/* 2861 */             checkflag = true;
/*      */           } else {
/* 2863 */             checkflag = false;
/* 2864 */             break;
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/* 2869 */       System.out.println("----\u6821\u9A8C\u7ED3\u675F-----checkflag====" + checkflag);
/* 2870 */       return checkflag;
/*      */     } catch (RuntimeException e) {
/* 2872 */       e.printStackTrace();
/* 2873 */       System.out.println("\u8FDB\u884C\u4E86\u4FDD\u5B58\u64CD\u4F5C\u4F46\u662F\u6CA1\u6709\u5F55\u5165\u6570\u636E");
/*      */     }
/* 2875 */     return false;
/*      */   }
/*      */ 
/*      */   private boolean checkMoney(LNPPolSchema lnpPolSchema)
/*      */   {
/* 2881 */     return (lnpPolSchema.getPrem() != 0.0D) || (lnpPolSchema.getAmnt() != 0.0D);
/*      */   }
/*      */ 
/*      */   private String turnNullToString(Object object)
/*      */   {
/* 2895 */     String rst = "";
/*      */     try {
/* 2897 */       rst = object;
/*      */     } catch (Exception e) {
/* 2899 */       e.printStackTrace();
/* 2900 */       buildError(e.getMessage());
/*      */     }
/* 2902 */     return rst.trim();
/*      */   }
/*      */ 
/*      */   private void buildError(String msgErr)
/*      */   {
/* 2907 */     this.message = msgErr;
/* 2908 */     this.operateResult = false;
/*      */   }
/*      */ 
/*      */   public boolean isEditFlag()
/*      */   {
/* 2914 */     return this.editFlag;
/*      */   }
/*      */ 
/*      */   public void setEditFlag(boolean editFlag)
/*      */   {
/* 2919 */     this.editFlag = editFlag;
/*      */   }
/*      */ 
/*      */   public boolean isOperateResult()
/*      */   {
/* 2924 */     return this.operateResult;
/*      */   }
/*      */ 
/*      */   public void setOperateResult(boolean operateResult)
/*      */   {
/* 2929 */     this.operateResult = operateResult;
/*      */   }
/*      */ 
/*      */   public IGlobalInput getTempGI()
/*      */   {
/* 2934 */     return this.tempGI;
/*      */   }
/*      */ 
/*      */   public void setTempGI(IGlobalInput tempGI)
/*      */   {
/* 2939 */     this.tempGI = tempGI;
/*      */   }
/*      */ 
/*      */   public LNPContSchema getContSchema() {
/* 2943 */     return this.contSchema;
/*      */   }
/*      */   public void setContSchema(LNPContSchema contSchema) {
/* 2946 */     this.contSchema = contSchema;
/*      */   }
/*      */   public LNPInvestmentInfoSchema getInvestSchema() {
/* 2949 */     return this.investSchema;
/*      */   }
/*      */   public void setInvestSchema(LNPInvestmentInfoSchema investSchema) {
/* 2952 */     this.investSchema = investSchema;
/*      */   }
/*      */   public String getMessage() {
/* 2955 */     return this.message;
/*      */   }
/*      */ 
/*      */   public void setMessage(String message)
/*      */   {
/* 2960 */     this.message = message;
/*      */   }
/*      */ 
/*      */   public String getInfoSource()
/*      */   {
/* 2965 */     return this.infoSource;
/*      */   }
/*      */ 
/*      */   public void setInfoSource(String infoSource)
/*      */   {
/* 2970 */     this.infoSource = infoSource;
/*      */   }
/*      */ 
/*      */   public String getContNo()
/*      */   {
/* 2975 */     return this.contNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String contNo)
/*      */   {
/* 2980 */     this.contNo = contNo;
/*      */   }
/*      */ 
/*      */   public LNPPolSchema getPolSchema()
/*      */   {
/* 2987 */     return this.polSchema;
/*      */   }
/*      */ 
/*      */   public void setPolSchema(LNPPolSchema polSchema)
/*      */   {
/* 2992 */     this.polSchema = polSchema;
/*      */   }
/*      */ 
/*      */   public String[] getMoney()
/*      */   {
/* 2997 */     return this.money;
/*      */   }
/*      */ 
/*      */   public void setMoney(String[] money) {
/* 3001 */     this.money = money;
/*      */   }
/*      */ 
/*      */   public String getPoltype() {
/* 3005 */     return this.poltype;
/*      */   }
/*      */ 
/*      */   public void setPoltype(String poltype)
/*      */   {
/* 3010 */     this.poltype = poltype;
/*      */   }
/*      */ 
/*      */   public String[] getRiskcode()
/*      */   {
/* 3015 */     return this.riskcode;
/*      */   }
/*      */ 
/*      */   public String[] getType()
/*      */   {
/* 3020 */     return this.type;
/*      */   }
/*      */   public void setType(String[] type) {
/* 3023 */     this.type = type;
/*      */   }
/*      */   public void setRiskcode(String[] riskcode) {
/* 3026 */     this.riskcode = riskcode;
/*      */   }
/*      */ 
/*      */   public String[] getYears()
/*      */   {
/* 3031 */     return this.years;
/*      */   }
/*      */ 
/*      */   public void setYears(String[] years)
/*      */   {
/* 3036 */     this.years = years;
/*      */   }
/*      */ 
/*      */   public String[] getPayyears()
/*      */   {
/* 3041 */     return this.payyears;
/*      */   }
/*      */ 
/*      */   public void setPayyears(String[] payyears)
/*      */   {
/* 3046 */     this.payyears = payyears;
/*      */   }
/*      */ 
/*      */   public String getGetyear()
/*      */   {
/* 3053 */     return this.getyear;
/*      */   }
/*      */ 
/*      */   public void setGetyear(String getyear)
/*      */   {
/* 3058 */     this.getyear = getyear;
/*      */   }
/*      */ 
/*      */   public Integer getPayintv()
/*      */   {
/* 3065 */     return this.payintv;
/*      */   }
/*      */   public void setPayintv(Integer payintv) {
/* 3068 */     this.payintv = payintv;
/*      */   }
/*      */   public String getDeadgetmode() {
/* 3071 */     return this.deadgetmode;
/*      */   }
/*      */   public void setDeadgetmode(String deadgetmode) {
/* 3074 */     this.deadgetmode = deadgetmode;
/*      */   }
/*      */   public String getBonusgetmode() {
/* 3077 */     return this.bonusgetmode;
/*      */   }
/*      */   public void setBonusgetmode(String bonusgetmode) {
/* 3080 */     this.bonusgetmode = bonusgetmode;
/*      */   }
/*      */ 
/*      */   public String getOverflowpremium() {
/* 3084 */     return this.overflowpremium;
/*      */   }
/*      */   public void setOverflowpremium(String overflowpremium) {
/* 3087 */     this.overflowpremium = overflowpremium;
/*      */   }
/*      */   public String getOverduepremium() {
/* 3090 */     return this.overduepremium;
/*      */   }
/*      */   public void setOverduepremium(String overduepremium) {
/* 3093 */     this.overduepremium = overduepremium;
/*      */   }
/*      */   public String getAnnuityfrequency() {
/* 3096 */     return this.annuityfrequency;
/*      */   }
/*      */   public void setAnnuityfrequency(String annuityfrequency) {
/* 3099 */     this.annuityfrequency = annuityfrequency;
/*      */   }
/*      */   public boolean isAlertFlag() {
/* 3102 */     return this.alertFlag;
/*      */   }
/*      */   public void setAlertFlag(boolean alertFlag) {
/* 3105 */     this.alertFlag = alertFlag;
/*      */   }
/*      */ 
/*      */   public String getOperType() {
/* 3109 */     return this.operType;
/*      */   }
/*      */ 
/*      */   public void setOperType(String operType)
/*      */   {
/* 3114 */     this.operType = operType;
/*      */   }
/*      */ 
/*      */   public String getManageCom()
/*      */   {
/* 3119 */     return this.manageCom;
/*      */   }
/*      */ 
/*      */   public void setManageCom(String manageCom)
/*      */   {
/* 3124 */     this.manageCom = manageCom;
/*      */   }
/*      */ 
/*      */   public String getVulriskcode()
/*      */   {
/* 3129 */     return this.vulriskcode;
/*      */   }
/*      */   public void setVulriskcode(String vulriskcode) {
/* 3132 */     this.vulriskcode = vulriskcode;
/*      */   }
/*      */ 
/*      */   public String getSumprem() {
/* 3136 */     return this.sumprem;
/*      */   }
/*      */ 
/*      */   public void setSumprem(String sumprem) {
/* 3140 */     this.sumprem = sumprem;
/*      */   }
/*      */ 
/*      */   public String getVulprem() {
/* 3144 */     return this.vulprem;
/*      */   }
/*      */ 
/*      */   public void setVulprem(String vulprem) {
/* 3148 */     this.vulprem = vulprem;
/*      */   }
/*      */ 
/*      */   public String getVulmonthplus() {
/* 3152 */     return this.vulmonthplus;
/*      */   }
/*      */ 
/*      */   public void setVulmonthplus(String vulmonthplus) {
/* 3156 */     this.vulmonthplus = vulmonthplus;
/*      */   }
/*      */ 
/*      */   public String getVulyear() {
/* 3160 */     return this.vulyear;
/*      */   }
/*      */   public void setVulyear(String vulyear) {
/* 3163 */     this.vulyear = vulyear;
/*      */   }
/*      */   public String getVulinvestment() {
/* 3166 */     return this.vulinvestment;
/*      */   }
/*      */   public void setVulinvestment(String vulinvestment) {
/* 3169 */     this.vulinvestment = vulinvestment;
/*      */   }
/*      */   public String[] getCombinationriskcode() {
/* 3172 */     return this.combinationriskcode;
/*      */   }
/*      */   public void setCombinationriskcode(String[] combinationriskcode) {
/* 3175 */     this.combinationriskcode = combinationriskcode;
/*      */   }
/*      */   public String[] getCombinationyears() {
/* 3178 */     return this.combinationyears;
/*      */   }
/*      */   public void setCombinationyears(String[] combinationyears) {
/* 3181 */     this.combinationyears = combinationyears;
/*      */   }
/*      */   public String[] getCombinationpayyears() {
/* 3184 */     return this.combinationpayyears;
/*      */   }
/*      */   public void setCombinationpayyears(String[] combinationpayyears) {
/* 3187 */     this.combinationpayyears = combinationpayyears;
/*      */   }
/*      */ 
/*      */   public List<LNPPolBean> getLnpList() {
/* 3191 */     return this.lnpList;
/*      */   }
/*      */   public void setLnpList(List<LNPPolBean> lnpList) {
/* 3194 */     this.lnpList = lnpList;
/*      */   }
/*      */ 
/*      */   public String[] getCombinationmoney() {
/* 3198 */     return this.combinationmoney;
/*      */   }
/*      */ 
/*      */   public void setCombinationmoney(String[] combinationmoney) {
/* 3202 */     this.combinationmoney = combinationmoney;
/*      */   }
/*      */ 
/*      */   public LNPBonusInfoSchema getBonusInfoSchema() {
/* 3206 */     return this.bonusInfoSchema;
/*      */   }
/*      */   public void setBonusInfoSchema(LNPBonusInfoSchema bonusInfoSchema) {
/* 3209 */     this.bonusInfoSchema = bonusInfoSchema;
/*      */   }
/*      */ 
/*      */   public String getRadiotype()
/*      */   {
/* 3214 */     return this.radiotype;
/*      */   }
/*      */ 
/*      */   public void setRadiotype(String radiotype) {
/* 3218 */     this.radiotype = radiotype;
/*      */   }
/*      */ 
/*      */   public List<LNPPolBean> getCbtlnpList() {
/* 3222 */     return this.cbtlnpList;
/*      */   }
/*      */ 
/*      */   public void setCbtlnpList(List<LNPPolBean> cbtlnpList) {
/* 3226 */     this.cbtlnpList = cbtlnpList;
/*      */   }
/*      */ 
/*      */   public List<LNPVulBean> getVulinvestmentList() {
/* 3230 */     return this.vulinvestmentList;
/*      */   }
/*      */ 
/*      */   public void setVulinvestmentList(List<LNPVulBean> vulinvestmentList) {
/* 3234 */     this.vulinvestmentList = vulinvestmentList;
/*      */   }
/*      */ 
/*      */   public int getVulsize() {
/* 3238 */     return this.vulsize;
/*      */   }
/*      */ 
/*      */   public void setVulsize(int vulsize) {
/* 3242 */     this.vulsize = vulsize;
/*      */   }
/*      */ 
/*      */   public boolean isVullistflag() {
/* 3246 */     return this.vullistflag;
/*      */   }
/*      */ 
/*      */   public void setVullistflag(boolean vullistflag) {
/* 3250 */     this.vullistflag = vullistflag;
/*      */   }
/*      */ 
/*      */   public boolean isVulrateflag() {
/* 3254 */     return this.vulrateflag;
/*      */   }
/*      */ 
/*      */   public void setVulrateflag(boolean vulrateflag) {
/* 3258 */     this.vulrateflag = vulrateflag;
/*      */   }
/*      */ 
/*      */   public BankRelationContNo getRelationDeal() {
/* 3262 */     return this.relationDeal;
/*      */   }
/*      */ 
/*      */   public void setRelationDeal(BankRelationContNo relationDeal) {
/* 3266 */     this.relationDeal = relationDeal;
/*      */   }
/*      */ 
/*      */   public String getSalechannel() {
/* 3270 */     return this.salechannel;
/*      */   }
/*      */ 
/*      */   public void setSalechannel(String salechannel) {
/* 3274 */     this.salechannel = salechannel;
/* 3275 */     HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/* 3276 */     session.setAttribute("saleChannel", salechannel);
/*      */   }
/*      */ 
/*      */   public String getYearmoneychangeriskcode() {
/* 3280 */     return this.yearmoneychangeriskcode;
/*      */   }
/*      */ 
/*      */   public void setYearmoneychangeriskcode(String yearmoneychangeriskcode) {
/* 3284 */     this.yearmoneychangeriskcode = yearmoneychangeriskcode;
/*      */   }
/*      */ 
/*      */   public String getYearmoneychangeyears() {
/* 3288 */     return this.yearmoneychangeyears;
/*      */   }
/*      */ 
/*      */   public void setYearmoneychangeyears(String yearmoneychangeyears) {
/* 3292 */     this.yearmoneychangeyears = yearmoneychangeyears;
/*      */   }
/*      */ 
/*      */   public String getYearmoneychangepayyears() {
/* 3296 */     return this.yearmoneychangepayyears;
/*      */   }
/*      */ 
/*      */   public void setYearmoneychangepayyears(String yearmoneychangepayyears) {
/* 3300 */     this.yearmoneychangepayyears = yearmoneychangepayyears;
/*      */   }
/*      */ 
/*      */   public String getYearmoneychangemoney() {
/* 3304 */     return this.yearmoneychangemoney;
/*      */   }
/*      */ 
/*      */   public void setYearmoneychangemoney(String yearmoneychangemoney) {
/* 3308 */     this.yearmoneychangemoney = yearmoneychangemoney;
/*      */   }
/*      */ 
/*      */   public String getYearmoneychangegetyear() {
/* 3312 */     return this.yearmoneychangegetyear;
/*      */   }
/*      */ 
/*      */   public void setYearmoneychangegetyear(String yearmoneychangegetyear) {
/* 3316 */     this.yearmoneychangegetyear = yearmoneychangegetyear;
/*      */   }
/*      */ 
/*      */   public List<LNPPolBean> getYmclnpList() {
/* 3320 */     return this.ymclnpList;
/*      */   }
/*      */ 
/*      */   public void setYmclnpList(List<LNPPolBean> ymclnpList) {
/* 3324 */     this.ymclnpList = ymclnpList;
/*      */   }
/*      */ 
/*      */   public String[] getCombinationtype() {
/* 3328 */     return this.combinationtype;
/*      */   }
/*      */ 
/*      */   public void setCombinationtype(String[] combinationtype) {
/* 3332 */     this.combinationtype = combinationtype;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.BankInsuredItem
 * JD-Core Version:    0.6.0
 */