/*      */ package com.sinosoft.banklns.lnsmodel;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.BankBasicBL;
/*      */ import com.sinosoft.banklns.lis.bean.BankLNPContBean;
/*      */ import com.sinosoft.banklns.lis.db.LNPContDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
/*      */ import com.sinosoft.banklns.lis.pubfun.LNPPubFun;
/*      */ import com.sinosoft.banklns.lis.pubfun.MMap;
/*      */ import com.sinosoft.banklns.lis.pubfun.PubFun;
/*      */ import com.sinosoft.banklns.lis.pubfun.PubSubmit;
/*      */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPContSet;
/*      */ import com.sinosoft.banklns.lnsmodel.interfaces.AuraBean;
/*      */ import com.sinosoft.banklns.lnsmodel.interfaces.CalPrem;
/*      */ import com.sinosoft.banklns.lnsmodel.interfaces.CheckUser;
/*      */ import com.sinosoft.banklns.lnsmodel.interfaces.FinalSubmissionBean;
/*      */ import com.sinosoft.banklns.lnsmodel.interfaces.NPUWBean;
/*      */ import com.sinosoft.banklns.utility.ExeSQL;
/*      */ import com.sinosoft.banklns.utility.SSRS;
/*      */ import com.sinosoft.banklns.utility.VData;
/*      */ import java.io.PrintStream;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.Hashtable;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import javax.faces.context.ExternalContext;
/*      */ import javax.faces.context.FacesContext;
/*      */ import javax.servlet.http.HttpSession;
/*      */ 
/*      */ public class BankOperateDeal extends BankBasicBL
/*      */ {
/*      */   private String contNo;
/*      */   private String state;
/*      */   private String editState;
/*      */   private String lnpUserType;
/*      */   private boolean editFlag;
/*      */   private String sheetType;
/*      */   private boolean submitReviewFlag;
/*      */   private boolean calculateFlag;
/*      */   private boolean sendFlag;
/*      */   private boolean cancelFlag;
/*      */   private boolean resumeFlag;
/*      */   private boolean alertFlag;
/*      */   private String message;
/*      */   private String addPremFlag;
/*      */   private boolean uwURLShowFlag;
/*      */   private boolean uwURLFlag;
/*      */   private String uwurl;
/*      */   private boolean auraSuccFlag;
/*      */   private boolean auraErrorsShowFlag;
/*      */   private boolean calPremSuccFlag;
/*      */   private boolean calHtmlErrorShowFlag;
/*      */   private boolean checkUserSuccFlag;
/*      */   private boolean checkUserHtmlErrorShowFlag;
/*      */   private boolean underWriteSuccFlag;
/*      */   private boolean underWriteErrorShowFlag;
/*      */   private boolean submitSuccFlag;
/*      */   private boolean submitErrorShowFlag;
/*      */   private boolean insuDeclarationFlag;
/*      */   private boolean insuDeclarationFlag2;
/*   96 */   private ArrayList Errors = new ArrayList();
/*   97 */   private static Map<String, String> stateMap = new Hashtable();
/*      */ 
/*   99 */   private BankLNPContBean contBean = new BankLNPContBean();
/*  100 */   private IGlobalInput GI = new IGlobalInput();
/*      */   private BankStateOperateDealIface stateOperateDeal;
/*      */   private BankPolicyState policyState;
/*      */ 
/*      */   static
/*      */   {
/*  895 */     intiStateMap();
/*      */   }
/*      */ 
/*      */   public static void main(String[] args)
/*      */   {
/*  107 */     BankOperateDeal operateDeal = new BankOperateDeal();
/*  108 */     String rst = "";
/*      */ 
/*  111 */     rst = rst + operateDeal.detailErMsg("110100");
/*  112 */     System.out.println(rst);
/*      */   }
/*      */ 
/*      */   public void init() {
/*  116 */     System.out.println("------------------->\u6309\u94AE\u63A7\u5236\u9762\u677F start<-------------------");
/*      */     try {
/*  118 */       this.alertFlag = false;
/*  119 */       this.message = "";
/*      */ 
/*  121 */       this.submitReviewFlag = false;
/*  122 */       this.calculateFlag = false;
/*  123 */       this.sendFlag = false;
/*  124 */       this.cancelFlag = false;
/*  125 */       this.resumeFlag = false;
/*      */ 
/*  127 */       this.insuDeclarationFlag = false;
/*  128 */       this.insuDeclarationFlag2 = false;
/*  129 */       if (getInfoFromSession()) {
/*  130 */         HttpSession session = (HttpSession)
/*  131 */           FacesContext.getCurrentInstance().getExternalContext()
/*  132 */           .getSession(true);
/*  133 */         this.stateOperateDeal = new BankStateOperateDealNew();
/*  134 */         if (("0".equals(this.lnpUserType)) || 
/*  135 */           ("2".equals(this.lnpUserType)))
/*      */         {
/*  137 */           this.submitReviewFlag = isDisplay(this.state, this.editState, 1, 
/*  138 */             this.lnpUserType, null);
/*      */         }
/*  140 */         if (("1".equals(this.lnpUserType)) || 
/*  141 */           ("2".equals(this.lnpUserType)))
/*      */         {
/*  143 */           this.calculateFlag = isDisplay(this.state, this.editState, 2, 
/*  144 */             this.lnpUserType, null);
/*  145 */           this.sendFlag = isDisplay(this.state, this.editState, 3, 
/*  146 */             this.lnpUserType, null);
/*  147 */           this.cancelFlag = isDisplay(this.state, this.editState, 4, 
/*  148 */             this.lnpUserType, null);
/*  149 */           this.resumeFlag = isDisplay(this.state, this.editState, 5, 
/*  150 */             this.lnpUserType, null);
/*      */         }
/*  152 */         System.out.println("\u4EBA\u5458\u7C7B\u578B\uFF1A\u201C" + this.lnpUserType + "\u201D\u5F53\u524D\u6309\u94AE\u64CD\u7EB5\u72B6\u6001\uFF1A" + 
/*  153 */           this.submitReviewFlag + "|" + this.calculateFlag + 
/*  154 */           "|" + this.sendFlag + "|" + this.cancelFlag + "|" + 
/*  155 */           this.resumeFlag + "|state=" + this.state + 
/*  156 */           "|editsate=" + this.editState);
/*      */       }
/*      */       else {
/*  159 */         buildMsg("\u6295\u4FDD\u4E66\u5F55\u5165\u524D\u53F0\u4FE1\u606F\u7F3A\u5931\u4E86\uFF01");
/*  160 */         return;
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  164 */       e.printStackTrace();
/*  165 */       buildMsg("\u6295\u4FDD\u4E66\u4FDD\u6309\u94AE\u64CD\u4F5C\u4E8B\u4EF6\u521D\u59CB\u5316\u5931\u8D25\uFF0C\u539F\u56E0\uFF1A" + e.getMessage());
/*      */ 
/*  168 */       reportMsg();
/*  169 */       System.out
/*  170 */         .println("------------------->\u6309\u94AE\u63A7\u5236\u9762\u677F end<-------------------");
/*      */     }
/*      */   }
/*      */ 
/*      */   public boolean getInfoFromSession() {
/*  175 */     System.out.println("----- getInfoFromSession-------------");
/*  176 */     boolean flag = false;
/*      */     try {
/*  178 */       HttpSession session = (HttpSession)
/*  179 */         FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*  180 */       this.GI = ((IGlobalInput)session.getAttribute("NPGI"));
/*      */ 
/*  182 */       if (this.GI != null)
/*  183 */         this.lnpUserType = this.GI.LNPRole;
/*      */       else {
/*  185 */         return flag;
/*      */       }
/*  187 */       this.contNo = ((String)session.getAttribute("ContNo"));
/*      */ 
/*  189 */       if ((this.contNo != null) && (!"".equals(this.contNo))) {
/*  190 */         PolicyMainInfo mainInfo = new PolicyMainInfo();
/*  191 */         LNPContSchema tSchema = mainInfo.getContByContNo(this.contNo);
/*  192 */         this.contBean.setSchema(tSchema);
/*  193 */         if (!"".equals(this.contBean.getSchema().getContNo())) {
/*  194 */           this.editState = this.contBean.getSchema().getEditstate();
/*  195 */           this.state = this.contBean.getSchema().getState();
/*      */         }
/*      */       }
/*  198 */       flag = true;
/*      */     } catch (RuntimeException e) {
/*  200 */       e.printStackTrace();
/*  201 */       buildMsg(e.getMessage());
/*      */     }
/*  203 */     return flag;
/*      */   }
/*      */ 
/*      */   public boolean submitReview() {
/*  207 */     System.out
/*  208 */       .println("---------------------->\u63D0\u4EA4\u5BA1\u6838 start<-----------------------");
/*  209 */     VData vData = new VData();
/*  210 */     MMap mMap = new MMap();
/*  211 */     boolean flag = false;
/*  212 */     List tList = new ArrayList();
/*      */ 
/*  214 */     label642: 
/*      */     try { init();
/*  215 */       if (!this.submitReviewFlag) {
/*  216 */         buildMsg("\u6295\u4FDD\u4E66\u5F53\u524D" + detailErMsg(this.editState) + "\u72B6\u6001\u4E3A\uFF1A" + 
/*  217 */           (String)stateMap.get(this.state) + " ,\u4E0D\u80FD\u8FDB\u884C<\u63D0\u4EA4\u5BA1\u6838>\u64CD\u4F5C\u3002");
/*  218 */         return flag;
/*      */       }
/*  220 */       this.stateOperateDeal = new BankStateOperateDealNew();
/*  221 */       this.policyState = new BankPolicyState();
/*      */       try
/*      */       {
/*  224 */         tList = this.stateOperateDeal.infoOprate(this.state, this.editState, 
/*  225 */           "modify", "71");
/*  226 */         this.policyState.savePolicyState(this.contNo, (String)tList.get(0), "1", 
/*  227 */           PubFun.getCurrentDate(), PubFun.getCurrentTime());
/*  228 */         flag = true;
/*      */       }
/*      */       catch (RuntimeException e) {
/*  231 */         tList = this.stateOperateDeal.infoOprate(this.state, this.editState, 
/*  232 */           "modify", "70");
/*  233 */         throw new RuntimeException("\u540E\u53F0\u62A5\u9519\u4FE1\u606F\uFF1A\u63D0\u4EA4\u5BA1\u6838\u5931\u8D25!");
/*      */       } finally {
/*  235 */         this.contBean.getSchema().setState((String)tList.get(0));
/*  236 */         this.contBean.getSchema().setEditstate((String)tList.get(1));
/*  237 */         this.contBean.getSchema().setModifyDate(
/*  238 */           PubFun.getCurrentDate());
/*  239 */         this.contBean.getSchema().setModifyTime(
/*  240 */           PubFun.getCurrentTime());
/*  241 */         this.contBean.getSchema()
/*  242 */           .setInputOperator(this.GI.Operator);
/*  243 */         mMap.put(this.contBean.getSchema(), "UPDATE");
/*  244 */         vData.add(mMap);
/*  245 */         saveAllMsg(vData);
/*      */       }
/*      */ 
/*  248 */       ExeSQL tExeSQL = new ExeSQL();
/*      */ 
/*  250 */       SSRS tSSRS = tExeSQL
/*  251 */         .execSQL("select appntbirthday from lnpappnt where contno='" + 
/*  252 */         this.contNo + "'");
/*      */ 
/*  254 */       if ((tSSRS != null) && (tSSRS.getMaxRow() > 0))
/*      */       {
/*  256 */         int payYears = calPayYears();
/*  257 */         int appAge = calAppAge(tSSRS.GetText(1, 1));
/*      */ 
/*  259 */         if (payYears + appAge >= 60) {
/*  260 */           this.insuDeclarationFlag2 = true;
/*  261 */           break label642;
/*  262 */         }this.insuDeclarationFlag2 = false;
/*      */       }
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  267 */       e.printStackTrace();
/*      */ 
/*  269 */       tList = this.stateOperateDeal.infoOprate(this.state, this.editState, "modify", 
/*  270 */         "70");
/*  271 */       buildMsg(e.getMessage());
/*      */     } finally {
/*  273 */       turnCurrPolicyLockFlag(null, this.contNo, "unlock");
/*      */     }
/*  275 */     System.out
/*  276 */       .println("---------------------->\u63D0\u4EA4\u5BA1\u6838 end<-----------------------");
/*  277 */     return flag;
/*      */   }
/*      */ 
/*      */   public boolean calculate() {
/*  281 */     System.out
/*  282 */       .println("---------------------->\u8BA1\u7B97\u4FDD\u5355 start<-----------------------");
/*  283 */     VData vData = new VData();
/*  284 */     MMap mMap = new MMap();
/*  285 */     boolean flag = true;
/*  286 */     boolean valiPassFlag = false;
/*  287 */     this.alertFlag = false;
/*  288 */     this.auraSuccFlag = true;
/*  289 */     this.calPremSuccFlag = true;
/*  290 */     this.checkUserSuccFlag = true;
/*  291 */     AuraBean tAuraBean = new AuraBean();
/*  292 */     CalPrem tCalPremBean = new CalPrem();
/*  293 */     CheckUser cu = new CheckUser();
/*  294 */     List tList = new ArrayList();
/*      */     try {
/*  296 */       init();
/*  297 */       if (!this.calculateFlag) {
/*  298 */         buildMsg("\u6295\u4FDD\u4E66\u5F53\u524D\u72B6\u6001\u4E3A\uFF1A" + (String)stateMap.get(this.state) + 
/*  299 */           " ,\u4E0D\u80FD\u8FDB\u884C<\u4FDD\u8D39\u8BA1\u7B97>\u64CD\u4F5C\u3002");
/*  300 */         return false;
/*      */       }
/*  302 */       this.stateOperateDeal = new BankStateOperateDealNew();
/*  303 */       this.policyState = new BankPolicyState();
/*      */       try
/*      */       {
/*  306 */         if (!tAuraBean.calInterfaces(this.contNo)) {
/*  307 */           this.message = tAuraBean.getMessage();
/*  308 */           if ((this.message == null) || ("".equals(this.message))) {
/*  309 */             this.message = "\u6295\u4FDD\u89C4\u5219\u6821\u9A8C\u5931\u8D25\uFF01";
/*      */           }
/*      */ 
/*  312 */           buildMsg(this.message);
/*  313 */           this.auraSuccFlag = (flag = 0);
/*      */         }
/*  316 */         else if (!tCalPremBean.calInterfaces(this.contNo)) {
/*  317 */           this.message = tCalPremBean.getMessage();
/*  318 */           if ((this.message == null) || ("".equals(this.message))) {
/*  319 */             this.message = "\u4FDD\u8D39\u8BA1\u7B97\u5931\u8D25\uFF01";
/*      */           }
/*      */ 
/*  322 */           tCalPremBean.rollbakData();
/*  323 */           buildMsg(this.message);
/*  324 */           this.calPremSuccFlag = (flag = 0);
/*      */         }
/*  327 */         else if (!cu.calInterfaces(this.contNo)) {
/*  328 */           this.message = cu.getMessage();
/*  329 */           if ((this.message == null) || ("".equals(this.message))) {
/*  330 */             this.message = "\u5BA2\u6237\u76F8\u4F3C\u5EA6\u6821\u9A8C\u5931\u8D25\uFF01";
/*      */           }
/*  332 */           cu.rollbakData();
/*  333 */           buildMsg(this.message);
/*  334 */           this.checkUserSuccFlag = (flag = 0);
/*      */         }
/*      */ 
/*  339 */         valiPassFlag = (tCalPremBean.isValiPassFlag()) && 
/*  340 */           (cu.isValiPassFlag()) && 
/*  341 */           (tAuraBean
/*  341 */           .isValiPassFlag());
/*  342 */         System.out.println("-->\u6821\u9A8C\u6210\u529F\u6807\u5FD7:" + valiPassFlag + "\u8BA1\u7B97\u6210\u529F\u6807\u5FD7" + 
/*  343 */           flag);
/*  344 */         if (flag) {
/*  345 */           tList = this.stateOperateDeal.infoOprate(this.state, this.editState, 
/*  346 */             "modify", "81");
/*  347 */         } else if (valiPassFlag)
/*      */         {
/*  349 */           tList = this.stateOperateDeal.infoOprate(this.state, this.editState, 
/*  350 */             "modify", "80");
/*      */         } else {
/*  352 */           tList.add(this.state);
/*  353 */           tList.add(this.editState);
/*      */         }
/*      */ 
/*  356 */         if (valiPassFlag)
/*  357 */           this.policyState.savePolicyState(this.contNo, (String)tList.get(0), 
/*  358 */             "1", PubFun.getCurrentDate(), 
/*  359 */             PubFun.getCurrentTime(), this.message);
/*  360 */         boolean bool1 = flag;
/*      */         PolicyMainInfo mainInfo;
/*      */         LNPContBean contBean;
/*      */         ExeSQL tExeSQL;
/*      */         SSRS tSSRS;
/*      */         SSRS tSSRS2;
/*      */         String salary;
/*      */         String sPrem;
/*      */         double sumPrem;
/*      */         double appSalary;
/*      */         return bool1;
/*      */       }
/*      */       catch (RuntimeException e) {
/*  363 */         tList = this.stateOperateDeal.infoOprate(this.state, this.editState, 
/*  364 */           "modify", "80");
/*  365 */         throw new RuntimeException("\u540E\u53F0\u62A5\u9519\u4FE1\u606F\uFF1A\u4FDD\u5355\u8BA1\u7B97\u63A5\u53E3\u7A0B\u5E8F\u5931\u8D25\uFF01");
/*      */       }
/*      */       finally {
/*  368 */         PolicyMainInfo mainInfo = new PolicyMainInfo();
/*  369 */         LNPContBean contBean = new LNPContBean();
/*  370 */         contBean.setSchema(mainInfo.getContByContNo(this.contNo));
/*  371 */         contBean.getSchema().setState((String)tList.get(0));
/*  372 */         contBean.getSchema().setEditstate((String)tList.get(1));
/*  373 */         contBean.getSchema().setModifyDate(PubFun.getCurrentDate());
/*  374 */         contBean.getSchema().setModifyTime(PubFun.getCurrentTime());
/*  375 */         contBean.getSchema().setInputOperator(this.GI.Operator);
/*  376 */         mMap.put(contBean.getSchema(), "UPDATE");
/*  377 */         vData = new VData();
/*  378 */         vData.add(mMap);
/*  379 */         saveAllMsg(vData);
/*      */ 
/*  381 */         ExeSQL tExeSQL = new ExeSQL();
/*      */ 
/*  383 */         SSRS tSSRS = tExeSQL
/*  384 */           .execSQL("select salary from lnpappnt where contno='" + 
/*  385 */           this.contNo + "'");
/*  386 */         SSRS tSSRS2 = tExeSQL
/*  387 */           .execSQL("select sum(prem) from lnppol where contno='" + 
/*  388 */           this.contNo + "' and payintv='5'");
/*      */ 
/*  390 */         if ((tSSRS != null) && (tSSRS.getMaxRow() > 0) && 
/*  391 */           (tSSRS2 != null) && (tSSRS2.getMaxRow() > 0)) {
/*  392 */           String salary = tSSRS.GetText(1, 1);
/*  393 */           String sPrem = tSSRS2.GetText(1, 1);
/*      */ 
/*  395 */           if ((salary != null) && (!"".equals(salary)) && 
/*  396 */             (!"null".equals(salary)) && (sPrem != null) && 
/*  397 */             (!"".equals(sPrem)) && (!"null".equals(sPrem))) {
/*  398 */             double sumPrem = Double.parseDouble(sPrem);
/*  399 */             double appSalary = Double.parseDouble(salary);
/*      */ 
/*  401 */             if (sumPrem > appSalary * 4.0D * 10000.0D)
/*  402 */               this.insuDeclarationFlag = true;
/*      */             else {
/*  404 */               this.insuDeclarationFlag = false;
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  412 */       e.printStackTrace();
/*      */ 
/*  414 */       tList = this.stateOperateDeal.infoOprate(this.state, this.editState, "modify", 
/*  415 */         "80");
/*  416 */       buildMsg(e.getMessage());
/*      */ 
/*  418 */       System.out
/*  419 */         .println("---------------------->\u8BA1\u7B97\u4FDD\u5355 end<-----------------------");
/*  420 */     }return flag;
/*      */   }
/*      */ 
/*      */   public boolean send() {
/*  424 */     System.out
/*  425 */       .println("----------------------> \u53D1\u9001\u4FDD\u5355 start<-----------------------");
/*  426 */     VData vData = new VData();
/*  427 */     MMap mMap = new MMap();
/*  428 */     boolean flag = true;
/*  429 */     boolean valiPassFlag = false;
/*  430 */     this.alertFlag = false;
/*  431 */     this.underWriteSuccFlag = true;
/*  432 */     this.submitSuccFlag = true;
/*  433 */     List tList = new ArrayList();
/*  434 */     NPUWBean tNPUWBean = new NPUWBean();
/*  435 */     FinalSubmissionBean submitBean = new FinalSubmissionBean();
/*      */     try {
/*  437 */       init();
/*  438 */       if (!this.sendFlag) {
/*  439 */         buildMsg("\u6295\u4FDD\u4E66\u5F53\u524D\u72B6\u6001\u4E3A\uFF1A" + (String)stateMap.get(this.state) + 
/*  440 */           " ,\u4E0D\u80FD\u8FDB\u884C<\u4FDD\u5355\u53D1\u9001>\u64CD\u4F5C\u3002");
/*  441 */         return false;
/*      */       }
/*  443 */       this.stateOperateDeal = new BankStateOperateDealNew();
/*  444 */       this.policyState = new BankPolicyState();
/*      */       try
/*      */       {
/*  447 */         if (!submitBean.calInterfaces(this.contNo)) {
/*  448 */           this.message = submitBean.getMessage();
/*  449 */           if ((this.message == null) || ("".equals(this.message))) {
/*  450 */             this.message = "\u53D1\u9001\u4FDD\u5355\u5931\u8D25\uFF01";
/*      */           }
/*  452 */           submitBean.rollbakData();
/*  453 */           buildMsg(this.message);
/*  454 */           this.submitSuccFlag = (flag = 0);
/*      */         }
/*      */ 
/*  457 */         valiPassFlag = submitBean.isValiPassFlag();
/*  458 */         System.out.println("-->\u6821\u9A8C\u6210\u529F\u6807\u5FD7:" + valiPassFlag + "\u8BA1\u7B97\u6210\u529F\u6807\u5FD7" + 
/*  459 */           flag);
/*  460 */         if (flag) {
/*  461 */           tList = this.stateOperateDeal.infoOprate(this.state, this.editState, 
/*  462 */             "modify", "91");
/*  463 */         } else if (valiPassFlag)
/*      */         {
/*  465 */           tList = this.stateOperateDeal.infoOprate(this.state, this.editState, 
/*  466 */             "modify", "90");
/*      */         } else {
/*  468 */           tList.add(this.state);
/*  469 */           tList.add(this.editState);
/*      */         }
/*      */ 
/*  472 */         if (valiPassFlag)
/*  473 */           this.policyState.savePolicyState(this.contNo, (String)tList.get(0), 
/*  474 */             "1", PubFun.getCurrentDate(), 
/*  475 */             PubFun.getCurrentTime(), this.message);
/*  476 */         boolean bool1 = flag;
/*      */         PolicyMainInfo mainInfo;
/*      */         LNPContBean contBean;
/*      */         return bool1;
/*      */       }
/*      */       catch (RuntimeException e) {
/*  479 */         tList = this.stateOperateDeal.infoOprate(this.state, this.editState, 
/*  480 */           "modify", "90");
/*  481 */         throw new RuntimeException("\u540E\u53F0\u62A5\u9519\u4FE1\u606F\uFF1A\u4FDD\u5355\u53D1\u9001\u63A5\u53E3\u7A0B\u5E8F\u5931\u8D25!");
/*      */       }
/*      */       finally {
/*  484 */         PolicyMainInfo mainInfo = new PolicyMainInfo();
/*  485 */         LNPContBean contBean = new LNPContBean();
/*  486 */         contBean.setSchema(mainInfo.getContByContNo(this.contNo));
/*  487 */         contBean.getSchema().setState((String)tList.get(0));
/*  488 */         contBean.getSchema().setEditstate((String)tList.get(1));
/*  489 */         contBean.getSchema().setModifyDate(PubFun.getCurrentDate());
/*  490 */         contBean.getSchema().setModifyTime(PubFun.getCurrentTime());
/*  491 */         contBean.getSchema().setInputOperator(this.GI.Operator);
/*  492 */         mMap.put(contBean.getSchema(), "UPDATE");
/*  493 */         vData = new VData();
/*  494 */         vData.add(mMap);
/*  495 */         saveAllMsg(vData);
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  499 */       e.printStackTrace();
/*      */ 
/*  501 */       tList = this.stateOperateDeal.infoOprate(this.state, this.editState, "modify", 
/*  502 */         "90");
/*  503 */       buildMsg(e.getMessage());
/*      */ 
/*  505 */       System.out
/*  506 */         .println("---------------------->\u53D1\u9001\u4FDD\u5355 end<-----------------------");
/*  507 */     }return flag;
/*      */   }
/*      */ 
/*      */   public boolean cancel() {
/*  511 */     System.out
/*  512 */       .println("----------------------> \u64A4\u9500\u4FDD\u5355 start<-----------------------");
/*  513 */     VData vData = new VData();
/*  514 */     MMap mMap = new MMap();
/*  515 */     boolean flag = false;
/*      */     try {
/*  517 */       init();
/*  518 */       if (!this.cancelFlag) {
/*  519 */         buildMsg("\u6295\u4FDD\u4E66\u5F53\u524D\u72B6\u6001\u4E3A\uFF1A" + (String)stateMap.get(this.state) + 
/*  520 */           " ,\u4E0D\u80FD\u8FDB\u884C<\u64A4\u9500\u4FDD\u5355>\u64CD\u4F5C\u3002");
/*  521 */         return flag;
/*      */       }
/*  523 */       this.stateOperateDeal = new BankStateOperateDealNew();
/*  524 */       this.policyState = new BankPolicyState();
/*  525 */       List tList = new ArrayList();
/*      */       try
/*      */       {
/*  528 */         this.stateOperateDeal = new BankStateOperateDealNew();
/*  529 */         tList = this.stateOperateDeal.infoOprate(this.state, this.editState, 
/*  530 */           "delete", "A11");
/*  531 */         this.contBean.getSchema().setState((String)tList.get(0));
/*  532 */         this.contBean.getSchema().setEditstate((String)tList.get(1));
/*  533 */         this.contBean.getSchema().setModifyDate(
/*  534 */           PubFun.getCurrentDate());
/*  535 */         this.contBean.getSchema().setModifyTime(
/*  536 */           PubFun.getCurrentTime());
/*  537 */         this.contBean.getSchema()
/*  538 */           .setInputOperator(this.GI.Operator);
/*  539 */         mMap.put(this.contBean.getSchema(), "UPDATE");
/*  540 */         vData.add(mMap);
/*  541 */         saveAllMsg(vData);
/*  542 */         this.policyState.savePolicyState(this.contNo, (String)tList.get(0), "1", 
/*  543 */           PubFun.getCurrentDate(), PubFun.getCurrentTime());
/*  544 */         flag = true;
/*      */       } catch (RuntimeException e) {
/*  546 */         throw new RuntimeException("\u540E\u53F0\u62A5\u9519\u4FE1\u606F\uFF1A\u64A4\u9500\u4FDD\u5355\u5931\u8D25!");
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  552 */       e.printStackTrace();
/*  553 */       buildMsg(e.getMessage());
/*      */ 
/*  555 */       System.out
/*  556 */         .println("---------------------->\u64A4\u9500\u4FDD\u5355 end<-----------------------");
/*  557 */     }return flag;
/*      */   }
/*      */ 
/*      */   public boolean resume() {
/*  561 */     System.out
/*  562 */       .println("---------------------->\u6062\u590D\u64A4\u9500\u4FDD\u5355 start<-----------------------");
/*  563 */     VData vData = new VData();
/*  564 */     MMap mMap = new MMap();
/*  565 */     boolean flag = false;
/*      */     try {
/*  567 */       init();
/*  568 */       if (!this.resumeFlag) {
/*  569 */         buildMsg("\u6295\u4FDD\u4E66\u5F53\u524D\u72B6\u6001\u4E3A\uFF1A" + (String)stateMap.get(this.state) + 
/*  570 */           " ,\u4E0D\u80FD\u8FDB\u884C<\u6062\u590D\u64A4\u9500>\u64CD\u4F5C\u3002");
/*  571 */         return flag;
/*      */       }
/*  573 */       this.stateOperateDeal = new BankStateOperateDealNew();
/*  574 */       this.policyState = new BankPolicyState();
/*  575 */       List tList = new ArrayList();
/*      */       try
/*      */       {
/*  578 */         this.stateOperateDeal = new BankStateOperateDealNew();
/*  579 */         tList = this.stateOperateDeal.infoOprate(this.state, this.editState, 
/*  580 */           "delete", "A10");
/*  581 */         this.contBean.getSchema().setState((String)tList.get(0));
/*  582 */         this.contBean.getSchema().setEditstate((String)tList.get(1));
/*  583 */         this.contBean.getSchema().setModifyDate(
/*  584 */           PubFun.getCurrentDate());
/*  585 */         this.contBean.getSchema().setModifyTime(
/*  586 */           PubFun.getCurrentTime());
/*  587 */         this.contBean.getSchema()
/*  588 */           .setInputOperator(this.GI.Operator);
/*  589 */         mMap.put(this.contBean.getSchema(), "UPDATE");
/*  590 */         vData.add(mMap);
/*  591 */         saveAllMsg(vData);
/*      */ 
/*  593 */         HttpSession session = (HttpSession)
/*  594 */           FacesContext.getCurrentInstance().getExternalContext()
/*  595 */           .getSession(true);
/*  596 */         Boolean tQueyEditFlag = (Boolean)session
/*  597 */           .getAttribute("Queryflag");
/*  598 */         session.setAttribute("Queryflag", Boolean.valueOf(true));
/*  599 */         this.policyState.savePolicyState(this.contNo, (String)tList.get(0), "1", 
/*  600 */           PubFun.getCurrentDate(), PubFun.getCurrentTime());
/*  601 */         flag = true;
/*      */       } catch (Exception e) {
/*  603 */         throw new RuntimeException("\u540E\u53F0\u62A5\u9519\u4FE1\u606F\uFF1A\u6062\u590D\u64A4\u9500\u4FDD\u5355\u5931\u8D25!");
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  609 */       e.printStackTrace();
/*  610 */       buildMsg(e.getMessage());
/*      */ 
/*  612 */       System.out
/*  613 */         .println("---------------------->\u6062\u590D\u64A4\u9500\u4FDD\u5355 end<-----------------------");
/*  614 */     }return flag;
/*      */   }
/*      */ 
/*      */   private void saveAllMsg(VData cInputData) throws Exception {
/*      */     try {
/*  619 */       PubSubmit pubSubmit = new PubSubmit();
/*  620 */       pubSubmit.submitData(cInputData, "");
/*      */     } catch (Exception e) {
/*  622 */       throw e;
/*      */     } finally {
/*  624 */       System.out
/*  625 */         .println("-----------OperDeal button is unlocked--------------");
/*  626 */       turnCurrPolicyLockFlag(null, this.contNo, "unlock");
/*      */     }
/*      */   }
/*      */ 
/*      */   public List<String> infoOprate(String state, String editState, String operateType, String infoType)
/*      */   {
/*  632 */     this.alertFlag = false;
/*  633 */     this.message = "";
/*  634 */     List list = new ArrayList();
/*      */ 
/*  636 */     list.add(state);
/*  637 */     list.add(editState);
/*      */     try {
/*  639 */       this.stateOperateDeal = new BankStateOperateDealNew();
/*  640 */       list = this.stateOperateDeal.infoOprate(state, editState, operateType, 
/*  641 */         infoType);
/*      */     } catch (Exception e) {
/*  643 */       e.printStackTrace();
/*  644 */       buildMsg(e.getMessage());
/*      */     }
/*  646 */     return list;
/*      */   }
/*      */ 
/*      */   public boolean isDisplay(String state, String editState, int buttonType, String userType, String contNo)
/*      */   {
/*  651 */     this.alertFlag = false;
/*  652 */     this.message = "";
/*  653 */     boolean flag = false;
/*      */     try {
/*  655 */       this.stateOperateDeal = new BankStateOperateDealNew();
/*  656 */       flag = this.stateOperateDeal.checkButtonOperate(state, editState, 
/*  657 */         buttonType, userType, contNo);
/*      */     } catch (Exception e) {
/*  659 */       e.printStackTrace();
/*  660 */       buildMsg(e.getMessage());
/*  661 */       flag = false;
/*      */     }
/*  663 */     return flag;
/*      */   }
/*      */ 
/*      */   public boolean isEidtSheet(String state, String sheetType, String userType, String contNo)
/*      */   {
/*  668 */     this.alertFlag = false;
/*  669 */     this.message = "";
/*  670 */     boolean flag = false;
/*      */     try {
/*  672 */       this.stateOperateDeal = new BankStateOperateDealNew();
/*  673 */       flag = this.stateOperateDeal.checkEditOperate(state, sheetType, 
/*  674 */         userType, contNo);
/*      */     } catch (Exception e) {
/*  676 */       e.printStackTrace();
/*  677 */       buildMsg(e.getMessage());
/*  678 */       flag = false;
/*      */     }
/*  680 */     return flag;
/*      */   }
/*      */ 
/*      */   public List<String> changeMsgToModify(String state, String editState, String userType)
/*      */   {
/*  685 */     this.alertFlag = false;
/*  686 */     this.message = "";
/*  687 */     List list = new ArrayList();
/*      */     try
/*      */     {
/*  690 */       System.out.println("\u662F\u5426\u4F1A\u56DE\u6EDA\u4FDD\u5355\u72B6\u6001\u5224\u65AD-->\u5F53\u524D\u4FDD\u5355\u72B6\u6001state :" + state + 
/*  691 */         "|\u4EE3\u7406\u4EBA\u6743\u9650\u7C7B\u578BuserType:" + userType);
/*  692 */       if ((!"01".equals(state)) && (!"02".equals(state)) && 
/*  693 */         (!"05".equals(state)) && (!"06".equals(state)))
/*  694 */         list = modifyInfoOperate(state, editState, userType);
/*      */     }
/*      */     catch (Exception e) {
/*  697 */       e.printStackTrace();
/*  698 */       buildMsg(e.getMessage());
/*      */     }
/*  700 */     return list;
/*      */   }
/*      */ 
/*      */   private List<String> modifyInfoOperate(String state, String editState, String userType)
/*      */   {
/*  705 */     String tState = state;
/*  706 */     String tEditState = "";
/*  707 */     List arrays = new ArrayList();
/*  708 */     String[] editStateArray = new String[editState.length()];
/*  709 */     for (int i = 0; i < editState.length(); i++) {
/*  710 */       editStateArray[i] = editState.substring(i, i + 1);
/*      */     }
/*      */ 
/*  713 */     if (("1".equals(userType)) || ("2".equals(userType)))
/*      */     {
/*  715 */       tState = editState.matches("^[1]{4}\\d{6}$") ? "02" : state;
/*  716 */       editStateArray[7] = "0";
/*  717 */       editStateArray[8] = "0";
/*  718 */       editStateArray[9] = "0";
/*      */     }
/*  720 */     for (int i = 0; i < editStateArray.length; i++) {
/*  721 */       tEditState = tEditState + editStateArray[i];
/*      */     }
/*      */ 
/*  724 */     arrays.add(tState);
/*  725 */     arrays.add(tEditState);
/*  726 */     return arrays;
/*      */   }
/*      */ 
/*      */   public String updateEditStateDone(String editState, int idx) {
/*  730 */     if (idx > 4) {
/*  731 */       System.out.println("BXS\u53EA\u80FD\u6307\u5B9A\u4FEE\u6539\u524D4\u9879\u5185\u5BB9\u57FA\u7840\u4FE1\u606F--\u544A\u77E5\u53CA\u6388\u6743");
/*  732 */       return editState;
/*      */     }
/*  734 */     this.stateOperateDeal = new BankStateOperateDealNew();
/*  735 */     return this.stateOperateDeal.updateEditStateDone(editState, idx);
/*      */   }
/*      */ 
/*      */   public String updateEditStateUNDone(String editState, int idx) {
/*  739 */     if (idx > 4) {
/*  740 */       System.out.println("BXS\u53EA\u80FD\u6307\u5B9A\u4FEE\u6539\u524D4\u9879\u5185\u5BB9\u57FA\u7840\u4FE1\u606F--\u544A\u77E5\u53CA\u6388\u6743");
/*  741 */       return editState;
/*      */     }
/*  743 */     this.stateOperateDeal = new BankStateOperateDealNew();
/*  744 */     return this.stateOperateDeal.updateEditStateUNDone(editState, idx);
/*      */   }
/*      */ 
/*      */   private String detailErMsg(String editState) {
/*  748 */     String rst = "";
/*  749 */     if ((editState != null) && (!editState.trim().equals(""))) {
/*  750 */       String[] editStateArray = new String[editState.length()];
/*  751 */       for (int i = 0; i < editState.length(); i++) {
/*  752 */         editStateArray[i] = editState.substring(i, i + 1);
/*      */       }
/*  754 */       boolean flag = false;
/*  755 */       if (!"1".equals(editStateArray[0])) {
/*  756 */         rst = rst + "\u57FA\u7840\u4FE1\u606F\u3001";
/*  757 */         flag = true;
/*      */       }
/*  759 */       if (!"1".equals(editStateArray[1])) {
/*  760 */         rst = rst + "\u6295\u4FDD\u4E8B\u9879\u3001";
/*  761 */         flag = true;
/*      */       }
/*  763 */       if (!"1".equals(editStateArray[2])) {
/*  764 */         rst = rst + "\u5BA2\u6237\u4FE1\u606F\u3001";
/*  765 */         flag = true;
/*      */       }
/*  767 */       if (!"1".equals(editStateArray[3])) {
/*  768 */         rst = rst + "\u544A\u77E5\u53CA\u6388\u6743\u3001";
/*  769 */         flag = true;
/*      */       }
/*  771 */       if (flag) {
/*  772 */         rst = rst.substring(0, rst.length() - 1);
/*      */       }
/*  774 */       rst = rst + "\u5FC5\u5F55\u9879\u4FE1\u606F\u5C1A\u672A\u5168\u90E8\u5F55\u5165\u5B8C\u6BD5,";
/*      */     }
/*  776 */     return rst;
/*      */   }
/*      */ 
/*      */   public List<String> relInfoOperate(LNPContSchema contSchema, LNPContSchema newContSchema)
/*      */   {
/*  781 */     List list = new ArrayList();
/*  782 */     String newEditState = "";
/*  783 */     String editState = contSchema.getEditstate();
/*  784 */     String neweditState = newContSchema.getEditstate();
/*  785 */     String[] editStateArray = new String[editState.length()];
/*  786 */     String[] neweditStateArray = new String[neweditState.length()];
/*  787 */     for (int i = 0; i < editState.length(); i++) {
/*  788 */       editStateArray[i] = editState.substring(i, i + 1);
/*  789 */       neweditStateArray[i] = neweditState.substring(i, i + 1);
/*      */     }
/*  791 */     neweditStateArray[2] = editStateArray[2];
/*  792 */     neweditStateArray[3] = editStateArray[3];
/*      */ 
/*  794 */     neweditStateArray[7] = "0";
/*  795 */     neweditStateArray[8] = "0";
/*  796 */     neweditStateArray[9] = "0";
/*      */ 
/*  798 */     if ((!"05".equals(contSchema.getState())) && 
/*  799 */       (!"06".equals(contSchema.getState()))) {
/*  800 */       if ("01".equals(contSchema.getState()))
/*      */       {
/*  802 */         neweditStateArray[6] = "0";
/*  803 */         list.add("01");
/*      */       }
/*  806 */       else if (!"01".equals(newContSchema.getState())) {
/*  807 */         neweditStateArray[1] = "1";
/*  808 */         neweditStateArray[6] = "1";
/*  809 */         list.add("02");
/*      */       } else {
/*  811 */         neweditStateArray[6] = "0";
/*  812 */         list.add("01");
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  817 */     for (int j = 0; j < neweditState.length(); j++) {
/*  818 */       newEditState = newEditState + neweditStateArray[j];
/*      */     }
/*  820 */     newContSchema.setEditstate(newEditState);
/*  821 */     list.add(newEditState);
/*  822 */     return list;
/*      */   }
/*      */ 
/*      */   public void turnEditPolicy(HttpSession session, String contNo, boolean originFlag) throws Exception
/*      */   {
/*  827 */     if (session == null) {
/*  828 */       session = (HttpSession)FacesContext.getCurrentInstance()
/*  829 */         .getExternalContext().getSession(true);
/*      */     }
/*  831 */     if ((contNo == null) || ("".equals(contNo))) {
/*  832 */       contNo = (String)session.getAttribute("ContNo");
/*      */     }
/*  834 */     if ("LOCKED".equals(session.getAttribute("CONTLOCK")))
/*      */       try
/*      */       {
/*  837 */         System.out
/*  838 */           .println("######################################current policy edit is fixed after waitPolicyCommited######################################");
/*  839 */         if (originFlag)
/*  840 */           super.waitPolicyCommited(session, contNo);
/*  841 */         PubSubmit ps = new PubSubmit();
/*  842 */         LNPContSet tLNPContSet = new LNPContSet();
/*  843 */         LNPContSet dLNPContSet = new LNPContSet();
/*  844 */         LNPContDB tLNPContDB = new LNPContDB();
/*  845 */         tLNPContSet = tLNPContDB
/*  846 */           .executeQuery("select * from lnpcont where contno='" + 
/*  847 */           contNo + "'");
/*  848 */         for (int i = 1; i <= tLNPContSet.size(); i++) {
/*  849 */           LNPContSchema tSchema = tLNPContSet.get(i).getSchema();
/*  850 */           tSchema.setAgentCode(null);
/*  851 */           System.out.println("##########current policy :" + 
/*  852 */             tSchema.getContNo() + 
/*  853 */             "is prepare unlock! agentcode=" + 
/*  854 */             tSchema.getAgentCode());
/*  855 */           dLNPContSet.add(tSchema);
/*      */         }
/*  857 */         MMap mMap = new MMap();
/*  858 */         mMap.put(dLNPContSet, "UPDATE");
/*  859 */         VData cInputData = new VData();
/*  860 */         cInputData.add(mMap);
/*  861 */         if (ps.submitData(cInputData, "")) {
/*  862 */           System.out.println("##########\u89E3\u9501\u6210\u529F~");
/*  863 */           session.setAttribute("CONTLOCK", "UNLOCKED");
/*  864 */           super.turnCurrPolicyLockFlag(session, contNo, "unlock");
/*  865 */           System.out
/*  866 */             .println("######################################current policy is editdone######################################");
/*      */         }
/*      */       } catch (RuntimeException e) {
/*  869 */         throw new RuntimeException(
/*  870 */           "policy edit fixed erro!! class\uFF1ABankoperateDeal");
/*      */       }
/*      */   }
/*      */ 
/*      */   private void buildMsg(String msg)
/*      */   {
/*  877 */     this.alertFlag = true;
/*  878 */     this.message = msg;
/*  879 */     String Path = Class.class.getClass().getName();
/*  880 */     String Result = "--->path: " + Path + ";" + this.message;
/*  881 */     if (this.Errors.size() > 20) {
/*  882 */       this.Errors = new ArrayList();
/*      */     }
/*  884 */     this.Errors.add(Result);
/*      */   }
/*      */ 
/*      */   private void reportMsg() {
/*  888 */     for (int i = 0; i < this.Errors.size(); i++)
/*      */     {
/*  890 */       System.out.println("index_" + i + ":" + this.Errors.get(i));
/*      */     }
/*      */   }
/*      */ 
/*      */   private static void intiStateMap()
/*      */   {
/*  899 */     stateMap.clear();
/*  900 */     ExeSQL tExeSQL = new ExeSQL();
/*  901 */     String sql = "select code,codename from lnpcode where codetype='lnpLangState' order by code";
/*  902 */     SSRS tSRS = tExeSQL.execSQL(sql);
/*  903 */     for (int i = 1; i <= tSRS.MaxRow; i++)
/*  904 */       stateMap.put(tSRS.GetText(i, 1), tSRS.GetText(i, 2));
/*      */   }
/*      */ 
/*      */   private int calPayYears()
/*      */   {
/*  909 */     int payyears = 0;
/*      */ 
/*  911 */     ExeSQL tExeSQL = new ExeSQL();
/*  912 */     SSRS tSSRS = tExeSQL
/*  913 */       .execSQL("select payendyearflag,payendyear from lnppol where contno='" + 
/*  914 */       this.contNo + "'");
/*  915 */     SSRS tSSRS2 = tExeSQL
/*  916 */       .execSQL("select appntage,appntagetype from lnpappnt where contno='" + 
/*  917 */       this.contNo + "'");
/*      */ 
/*  919 */     if ((tSSRS != null) && (tSSRS.getMaxRow() > 0) && (tSSRS2 != null) && 
/*  920 */       (tSSRS2.getMaxRow() > 0))
/*      */     {
/*  922 */       int index = 0;
/*      */ 
/*  924 */       for (int i = 1; i <= tSSRS.getMaxRow(); i++) {
/*  925 */         String payEndYearFlag = tSSRS.GetText(1, 1);
/*      */ 
/*  927 */         if ((tSSRS.GetText(1, 2) != null) && 
/*  928 */           (!"".equals(tSSRS.GetText(1, 2))) && 
/*  929 */           (!"null".equals(tSSRS.GetText(1, 2))) && 
/*  930 */           (tSSRS2.GetText(1, 1) != null) && 
/*  931 */           (!"".equals(tSSRS2.GetText(1, 1))) && 
/*  932 */           (!"null".equals(tSSRS2.GetText(1, 1)))) {
/*  933 */           int payEndYear = Integer.parseInt(tSSRS.GetText(i, 2));
/*  934 */           int appAge = Integer.parseInt(tSSRS2.GetText(1, 1));
/*  935 */           String appAgeType = tSSRS2.GetText(1, 2);
/*  936 */           if (payEndYear == 1000) {
/*  937 */             payEndYear = 0;
/*      */           }
/*  939 */           if ("Y".equals(payEndYearFlag))
/*  940 */             index = payEndYear;
/*  941 */           else if ("A".equals(payEndYearFlag))
/*      */           {
/*  943 */             if ("Y".equals(appAgeType))
/*  944 */               index = payEndYear - appAge;
/*  945 */             else if ("D".equals(appAgeType))
/*      */             {
/*  947 */               index = payEndYear - 0;
/*      */             }
/*      */           }
/*      */         }
/*  951 */         if (index > payyears) {
/*  952 */           payyears = index;
/*      */         }
/*      */       }
/*      */     }
/*  956 */     return payyears;
/*      */   }
/*      */ 
/*      */   private int calAppAge(String birthday)
/*      */   {
/*  961 */     int appage = 0;
/*      */ 
/*  963 */     if ((birthday == null) || ("".equals(birthday)) || ("null".equals(birthday))) {
/*  964 */       return appage;
/*      */     }
/*      */ 
/*  967 */     SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
/*  968 */     String currentDate = fm.format(new Date());
/*  969 */     String iBirthday = birthday.substring(0, 10);
/*  970 */     String appAgeStr = 
/*  971 */       LNPPubFun.getAgeByBirthdayNew(iBirthday, currentDate);
/*      */ 
/*  973 */     if (appAgeStr.endsWith("\uFF08\u5468\u5C81\uFF09")) {
/*  974 */       int index = appAgeStr.indexOf("\uFF08\u5468\u5C81\uFF09");
/*  975 */       appage = Integer.parseInt(appAgeStr.substring(0, index));
/*  976 */     } else if (appAgeStr.endsWith("\uFF08\u5929\uFF09")) {
/*  977 */       appage = 0;
/*      */     } else {
/*  979 */       appage = 0;
/*      */     }
/*  981 */     return appage;
/*      */   }
/*      */ 
/*      */   public String getContNo() {
/*  985 */     return this.contNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String contNo) {
/*  989 */     this.contNo = contNo;
/*      */   }
/*      */ 
/*      */   public String getState() {
/*  993 */     return this.state;
/*      */   }
/*      */ 
/*      */   public void setState(String state) {
/*  997 */     this.state = state;
/*      */   }
/*      */ 
/*      */   public String getEditState() {
/* 1001 */     return this.editState;
/*      */   }
/*      */ 
/*      */   public void setEditState(String editState) {
/* 1005 */     this.editState = editState;
/*      */   }
/*      */ 
/*      */   public String getLnpUserType() {
/* 1009 */     return this.lnpUserType;
/*      */   }
/*      */ 
/*      */   public void setLnpUserType(String lnpUserType) {
/* 1013 */     this.lnpUserType = lnpUserType;
/*      */   }
/*      */ 
/*      */   public boolean isEditFlag() {
/* 1017 */     return this.editFlag;
/*      */   }
/*      */ 
/*      */   public void setEditFlag(boolean editFlag) {
/* 1021 */     this.editFlag = editFlag;
/*      */   }
/*      */ 
/*      */   public boolean isSubmitReviewFlag() {
/* 1025 */     return this.submitReviewFlag;
/*      */   }
/*      */ 
/*      */   public void setSubmitReviewFlag(boolean submitReviewFlag) {
/* 1029 */     this.submitReviewFlag = submitReviewFlag;
/*      */   }
/*      */ 
/*      */   public boolean isCalculateFlag() {
/* 1033 */     return this.calculateFlag;
/*      */   }
/*      */ 
/*      */   public void setCalculateFlag(boolean calculateFlag) {
/* 1037 */     this.calculateFlag = calculateFlag;
/*      */   }
/*      */ 
/*      */   public boolean isSendFlag() {
/* 1041 */     return this.sendFlag;
/*      */   }
/*      */ 
/*      */   public void setSendFlag(boolean sendFlag) {
/* 1045 */     this.sendFlag = sendFlag;
/*      */   }
/*      */ 
/*      */   public boolean isCancelFlag() {
/* 1049 */     return this.cancelFlag;
/*      */   }
/*      */ 
/*      */   public void setCancelFlag(boolean cancelFlag) {
/* 1053 */     this.cancelFlag = cancelFlag;
/*      */   }
/*      */ 
/*      */   public boolean isResumeFlag() {
/* 1057 */     return this.resumeFlag;
/*      */   }
/*      */ 
/*      */   public void setResumeFlag(boolean resumeFlag) {
/* 1061 */     this.resumeFlag = resumeFlag;
/*      */   }
/*      */ 
/*      */   public boolean isAlertFlag() {
/* 1065 */     return this.alertFlag;
/*      */   }
/*      */ 
/*      */   public void setAlertFlag(boolean alertFlag) {
/* 1069 */     this.alertFlag = alertFlag;
/*      */   }
/*      */ 
/*      */   public String getMessage() {
/* 1073 */     return this.message;
/*      */   }
/*      */ 
/*      */   public void setMessage(String message) {
/* 1077 */     this.message = message;
/*      */   }
/*      */ 
/*      */   public String getAddPremFlag() {
/* 1081 */     return this.addPremFlag;
/*      */   }
/*      */ 
/*      */   public void setAddPremFlag(String addPremFlag) {
/* 1085 */     this.addPremFlag = addPremFlag;
/*      */   }
/*      */ 
/*      */   public boolean isUwURLShowFlag() {
/* 1089 */     return this.uwURLShowFlag;
/*      */   }
/*      */ 
/*      */   public void setUwURLShowFlag(boolean uwURLShowFlag) {
/* 1093 */     this.uwURLShowFlag = uwURLShowFlag;
/*      */   }
/*      */ 
/*      */   public boolean isUwURLFlag() {
/* 1097 */     return this.uwURLFlag;
/*      */   }
/*      */ 
/*      */   public void setUwURLFlag(boolean uwURLFlag) {
/* 1101 */     this.uwURLFlag = uwURLFlag;
/*      */   }
/*      */ 
/*      */   public String getUwurl() {
/* 1105 */     return this.uwurl;
/*      */   }
/*      */ 
/*      */   public void setUwurl(String uwurl) {
/* 1109 */     this.uwurl = uwurl;
/*      */   }
/*      */ 
/*      */   public boolean isAuraSuccFlag() {
/* 1113 */     return this.auraSuccFlag;
/*      */   }
/*      */ 
/*      */   public void setAuraSuccFlag(boolean auraSuccFlag) {
/* 1117 */     this.auraSuccFlag = auraSuccFlag;
/*      */   }
/*      */ 
/*      */   public boolean isAuraErrorsShowFlag() {
/* 1121 */     return this.auraErrorsShowFlag;
/*      */   }
/*      */ 
/*      */   public void setAuraErrorsShowFlag(boolean auraErrorsShowFlag) {
/* 1125 */     this.auraErrorsShowFlag = auraErrorsShowFlag;
/*      */   }
/*      */ 
/*      */   public boolean isCheckUserHtmlErrorShowFlag() {
/* 1129 */     return this.checkUserHtmlErrorShowFlag;
/*      */   }
/*      */ 
/*      */   public void setCheckUserHtmlErrorShowFlag(boolean checkUserHtmlErrorShowFlag) {
/* 1133 */     this.checkUserHtmlErrorShowFlag = checkUserHtmlErrorShowFlag;
/*      */   }
/*      */ 
/*      */   public boolean isCalPremSuccFlag() {
/* 1137 */     return this.calPremSuccFlag;
/*      */   }
/*      */ 
/*      */   public void setCalPremSuccFlag(boolean calPremSuccFlag) {
/* 1141 */     this.calPremSuccFlag = calPremSuccFlag;
/*      */   }
/*      */ 
/*      */   public boolean isCalHtmlErrorShowFlag() {
/* 1145 */     return this.calHtmlErrorShowFlag;
/*      */   }
/*      */ 
/*      */   public void setCalHtmlErrorShowFlag(boolean calHtmlErrorShowFlag) {
/* 1149 */     this.calHtmlErrorShowFlag = calHtmlErrorShowFlag;
/*      */   }
/*      */ 
/*      */   public boolean isUnderWriteSuccFlag() {
/* 1153 */     return this.underWriteSuccFlag;
/*      */   }
/*      */ 
/*      */   public void setUnderWriteSuccFlag(boolean underWriteSuccFlag) {
/* 1157 */     this.underWriteSuccFlag = underWriteSuccFlag;
/*      */   }
/*      */ 
/*      */   public boolean isUnderWriteErrorShowFlag() {
/* 1161 */     return this.underWriteErrorShowFlag;
/*      */   }
/*      */ 
/*      */   public void setUnderWriteErrorShowFlag(boolean underWriteErrorShowFlag) {
/* 1165 */     this.underWriteErrorShowFlag = underWriteErrorShowFlag;
/*      */   }
/*      */ 
/*      */   public boolean isSubmitSuccFlag() {
/* 1169 */     return this.submitSuccFlag;
/*      */   }
/*      */ 
/*      */   public void setSubmitSuccFlag(boolean submitSuccFlag) {
/* 1173 */     this.submitSuccFlag = submitSuccFlag;
/*      */   }
/*      */ 
/*      */   public boolean isSubmitErrorShowFlag() {
/* 1177 */     return this.submitErrorShowFlag;
/*      */   }
/*      */ 
/*      */   public void setSubmitErrorShowFlag(boolean submitErrorShowFlag) {
/* 1181 */     this.submitErrorShowFlag = submitErrorShowFlag;
/*      */   }
/*      */ 
/*      */   public String getSheetType() {
/* 1185 */     return this.sheetType;
/*      */   }
/*      */ 
/*      */   public void setSheetType(String sheetType) {
/* 1189 */     this.sheetType = sheetType;
/*      */   }
/*      */ 
/*      */   public boolean isInsuDeclarationFlag() {
/* 1193 */     return this.insuDeclarationFlag;
/*      */   }
/*      */ 
/*      */   public void setInsuDeclarationFlag(boolean insuDeclarationFlag) {
/* 1197 */     this.insuDeclarationFlag = insuDeclarationFlag;
/*      */   }
/*      */ 
/*      */   public boolean isInsuDeclarationFlag2() {
/* 1201 */     return this.insuDeclarationFlag2;
/*      */   }
/*      */ 
/*      */   public void setInsuDeclarationFlag2(boolean insuDeclarationFlag2) {
/* 1205 */     this.insuDeclarationFlag2 = insuDeclarationFlag2;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.BankOperateDeal
 * JD-Core Version:    0.6.0
 */