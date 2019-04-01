/*      */ package com.sinosoft.map.lis.pubfun;
/*      */ 
/*      */ import com.sinosoft.map.common.WebVisitor;
/*      */ import com.sinosoft.map.ec.utility.ECPubFun;
/*      */ import com.sinosoft.map.lis.db.MCodeDB;
/*      */ import com.sinosoft.map.lis.db.MComDB;
/*      */ import com.sinosoft.map.lis.schema.MCodeSchema;
/*      */ import com.sinosoft.map.lis.schema.MComSchema;
/*      */ import com.sinosoft.map.lis.vschema.MCodeSet;
/*      */ import com.sinosoft.map.lis.vschema.MComSet;
/*      */ import com.sinosoft.map.user.UserModel;
/*      */ import com.sinosoft.map.utility.ExeSQL;
/*      */ import com.sinosoft.map.utility.SSRS;
/*      */ import java.io.PrintStream;
/*      */ import java.text.DecimalFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import javax.faces.event.ValueChangeEvent;
/*      */ import javax.faces.model.SelectItem;
/*      */ 
/*      */ public class MCodeList
/*      */ {
/*   24 */   private String provienceID = "";
/*      */   private String riskCode;
/*      */   private String comCode;
/*   30 */   private List<SelectItem> codeTypeMap = new ArrayList();
/*      */ 
/*   32 */   private List<SelectItem> riskTypeMap = new ArrayList();
/*   33 */   private List<SelectItem> riskPropMap = new ArrayList();
/*   34 */   private List<SelectItem> bonusFlagMap = new ArrayList();
/*   35 */   private List<SelectItem> bonusModeMap = new ArrayList();
/*   36 */   private List<SelectItem> subRiskFlagMap = new ArrayList();
/*   37 */   private List<SelectItem> insuredFlagMap = new ArrayList();
/*   38 */   private List<SelectItem> shareFlagMap = new ArrayList();
/*   39 */   private List<SelectItem> bnfFlagMap = new ArrayList();
/*   40 */   private List<SelectItem> impartFlagMap = new ArrayList();
/*   41 */   private List<SelectItem> choDutyFlagMap = new ArrayList();
/*   42 */   private List<SelectItem> cPayFlagMap = new ArrayList();
/*   43 */   private List<SelectItem> getFlagMap = new ArrayList();
/*   44 */   private List<SelectItem> edorFlagMap = new ArrayList();
/*   45 */   private List<SelectItem> rnewFlagMap = new ArrayList();
/*   46 */   private List<SelectItem> uwFlagMap = new ArrayList();
/*   47 */   private List<SelectItem> rinsFlagMap = new ArrayList();
/*   48 */   private List<SelectItem> insuAccFlagMap = new ArrayList();
/*   49 */   private List<SelectItem> payModeMap = new ArrayList();
/*   50 */   private List<SelectItem> riskPeriodMap = new ArrayList();
/*   51 */   private List<SelectItem> userStateMap = new ArrayList();
/*   52 */   private List<SelectItem> superFlagMap = new ArrayList();
/*   53 */   private List<SelectItem> orgMap = new ArrayList();
/*   54 */   private List<SelectItem> insuMonitorMap = new ArrayList();
/*   55 */   private List<SelectItem> comNatureMap = new ArrayList();
/*   56 */   private List<SelectItem> productClass = new ArrayList();
/*   57 */   private List<SelectItem> popedom = new ArrayList();
/*   58 */   private List<SelectItem> orderMap = new ArrayList();
/*      */ 
/*   60 */   private List<SelectItem> insureMoneyMap = new ArrayList();
/*   61 */   private List<SelectItem> payFrequencyMap = new ArrayList();
/*   62 */   private List<SelectItem> getTypeMap = new ArrayList();
/*   63 */   private List<SelectItem> polTermMap = new ArrayList();
/*      */ 
/*   65 */   private List<SelectItem> userStateMapR = new ArrayList();
/*      */ 
/*   68 */   private List<SelectItem> policyStateMap = new ArrayList();
/*      */ 
/*   70 */   private List<SelectItem> calTypeMap = new ArrayList();
/*      */ 
/*   72 */   private List<SelectItem> persionTypelist = new ArrayList();
/*      */ 
/*   74 */   private List<SelectItem> persionTypeMap = new ArrayList();
/*      */ 
/*   76 */   private List<SelectItem> customerTypeMap = new ArrayList();
/*      */ 
/*   78 */   private List<SelectItem> sexMap = new ArrayList();
/*      */ 
/*   80 */   private List<SelectItem> deGreeMap = new ArrayList();
/*      */ 
/*   82 */   private List<SelectItem> idTypeMap = new ArrayList();
/*      */ 
/*   84 */   private List<SelectItem> changeCodeMap = new ArrayList();
/*      */ 
/*   89 */   private List<SelectItem> payPeriodList = new ArrayList();
/*      */ 
/*   91 */   private List<SelectItem> amntLimitList = new ArrayList();
/*      */ 
/*   94 */   private List<SelectItem> idTypeList = new ArrayList();
/*      */ 
/*   97 */   private List<SelectItem> questionForPwdList = new ArrayList();
/*      */ 
/*  100 */   private List<SelectItem> provinceList = new ArrayList();
/*      */ 
/*  103 */   private List<SelectItem> cityList = new ArrayList();
/*      */ 
/*  106 */   private List<SelectItem> accProvinceList = new ArrayList();
/*      */ 
/*  109 */   private List<SelectItem> accCityList = new ArrayList();
/*      */ 
/*  113 */   private List<SelectItem> knowSiteList = new ArrayList();
/*      */ 
/*  116 */   private List<SelectItem> workTypeList = new ArrayList();
/*      */ 
/*  119 */   private List<SelectItem> occupationTypeList2 = new ArrayList();
/*      */ 
/*  122 */   private List<SelectItem> workTypeInsuredList = new ArrayList();
/*      */ 
/*  125 */   private List<SelectItem> occupationInsuredTypeList = new ArrayList();
/*      */ 
/*  128 */   private List<SelectItem> payModeList = new ArrayList();
/*      */ 
/*  131 */   private List<SelectItem> wageTimeList = new ArrayList();
/*      */ 
/*  134 */   private List<SelectItem> agentPccTypeList = new ArrayList();
/*      */ 
/*  137 */   private List<SelectItem> agentPccQueryTypeList = new ArrayList();
/*      */ 
/*  140 */   private List<SelectItem> projectType = new ArrayList();
/*      */ 
/*  143 */   private List<SelectItem> maintainProjectType = new ArrayList();
/*      */ 
/*  145 */   private List<SelectItem> branchAttrList = new ArrayList();
/*      */ 
/*  147 */   private List<SelectItem> yesnoList = new ArrayList();
/*      */ 
/*  150 */   private List<SelectItem> agentgroupList = new ArrayList();
/*      */   private String oldWorkType;
/*      */   private String currentWorkType;
/*      */   private String oldInsuredWorkType;
/*      */   private String currentInsuredWorkType;
/*      */   private String currentProvince;
/*      */   private String oldProvince;
/*      */   private String phoneAreaCode;
/*  402 */   List<SelectItem> bankComCodeList = null;
/*      */ 
/*  532 */   List<SelectItem> comCodeList = null;
/*      */ 
/* 1215 */   private List<SelectItem> payPeriodList2 = new ArrayList();
/*      */ 
/* 1287 */   private List<SelectItem> amntLimitList2 = new ArrayList();
/*      */ 
/* 1322 */   private List<SelectItem> polTermList = new ArrayList();
/*      */ 
/* 1338 */   private List<SelectItem> polTermList2 = new ArrayList();
/*      */ 
/* 1352 */   private List<SelectItem> payIntvList2 = new ArrayList();
/*      */ 
/* 1367 */   private List<SelectItem> payIntvList = new ArrayList();
/*      */ 
/* 1394 */   private List<SelectItem> getModeList2 = new ArrayList();
/*      */ 
/* 1409 */   private List<SelectItem> getModeList = new ArrayList();
/*      */ 
/* 1459 */   private List<SelectItem> yesOrNoList = new ArrayList();
/*      */ 
/* 1474 */   private List<SelectItem> relationList = new ArrayList();
/*      */ 
/* 1499 */   private List<SelectItem> relationListAll = new ArrayList();
/*      */ 
/* 1512 */   private List<SelectItem> occupationTypeList = new ArrayList();
/*      */ 
/* 1523 */   private List<SelectItem> marriageList = new ArrayList();
/*      */ 
/* 1548 */   private List<SelectItem> idTypeAppList = new ArrayList();
/*      */ 
/* 1568 */   private List<SelectItem> idTypeList2 = new ArrayList();
/*      */ 
/* 1588 */   private List<SelectItem> insuredIdTypeList = new ArrayList();
/*      */ 
/* 1610 */   private List<SelectItem> comProvinceList = new ArrayList();
/* 1611 */   private List<SelectItem> comCityList = new ArrayList();
/*      */ 
/*      */   public List<SelectItem> getBranchAttrList()
/*      */   {
/*  175 */     List list = new ArrayList();
/*  176 */     if ((list != null) && (list.size() > 0))
/*      */     {
/*  178 */       return list;
/*      */     }
/*      */ 
/*  181 */     WebVisitor tWebVisitor = new WebVisitor();
/*  182 */     tWebVisitor = ECPubFun.getWebVisitor();
/*  183 */     UserModel user = tWebVisitor.getUser();
/*      */ 
/*  185 */     StringBuffer tSql = new StringBuffer();
/*      */ 
/*  189 */     tSql.append("select a.branchattr ,a.name from (select dbo.reversemapping('BRANCH',branchattr) branchattr,name from labranchgroup where 1=1 ");
/*  190 */     tSql.append(" and BranchManager = '" + user.getUserCode() + "'");
/*  191 */     tSql.append(" and ManageCom like '" + user.getManageCom() + "%' ");
/*  192 */     tSql.append(" and EndFlag = 'N' ");
/*      */ 
/*  195 */     tSql.append(" union select dbo.reversemapping('BRANCH',branchattr) branchattr,name from labranchgroupb where 1=1 ");
/*      */ 
/*  197 */     tSql.append(" and BranchManager = '" + user.getUserCode() + "'");
/*  198 */     tSql.append(" and ManageCom like '" + user.getManageCom() + "%' ");
/*  199 */     tSql.append(" and EndFlag = 'N'  ) a group by a.branchattr,a.name order by a.branchattr ");
/*      */ 
/*  201 */     ExeSQL tExeSQL = new ExeSQL();
/*  202 */     SSRS tSSRS = tExeSQL.execSQL(tSql.toString());
/*      */ 
/*  205 */     if ((tSSRS != null) && (tSSRS.getMaxRow() >= 0))
/*      */     {
/*  207 */       for (int iLoop = 1; iLoop <= tSSRS.MaxRow; iLoop++)
/*      */       {
/*  209 */         list.add(new SelectItem(tSSRS.GetText(iLoop, 1) + "--" + tSSRS.GetText(iLoop, 2), tSSRS.GetText(iLoop, 1)));
/*      */       }
/*      */     }
/*      */ 
/*  213 */     return list;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> createCodeItem(String codeType, String flag)
/*      */   {
/*  220 */     List list = new ArrayList();
/*  221 */     MCodeDB dao = new MCodeDB();
/*  222 */     MCodeSet set = new MCodeSet();
/*  223 */     dao.setCodeType(codeType);
/*  224 */     set = dao.query();
/*      */ 
/*  226 */     if (flag.equals("L"))
/*      */     {
/*  228 */       if ((set != null) && (set.size() > 0))
/*      */       {
/*  230 */         for (int iLoop = 1; iLoop <= set.size(); iLoop++)
/*      */         {
/*  232 */           MCodeSchema schema = new MCodeSchema();
/*  233 */           schema = set.get(iLoop);
/*      */ 
/*  235 */           list.add(
/*  236 */             new SelectItem(schema.getCode() + "--" + 
/*  236 */             schema.getCodeName(), schema.getCode()));
/*      */         }
/*      */       }
/*      */     }
/*  240 */     else if (flag.equals("R"))
/*      */     {
/*  242 */       if ((set != null) && (set.size() > 0))
/*      */       {
/*  244 */         for (int iLoop = 1; iLoop <= set.size(); iLoop++)
/*      */         {
/*  246 */           MCodeSchema schema = new MCodeSchema();
/*  247 */           schema = set.get(iLoop);
/*      */ 
/*  249 */           list.add(new SelectItem(schema.getCode(), schema.getCode() + "--" + schema.getCodeName()));
/*      */         }
/*      */       }
/*      */     }
/*  253 */     return list;
/*      */   }
/*      */ 
/*      */   public void setIdTypeList(List<SelectItem> idTypeList)
/*      */   {
/*  258 */     this.idTypeList = idTypeList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getIdTypeList()
/*      */   {
/*  263 */     if ((this.idTypeList != null) && (this.idTypeList.size() > 0))
/*      */     {
/*  265 */       return this.idTypeList;
/*      */     }
/*  267 */     this.idTypeList = createCodeItem("idtype", "L");
/*      */ 
/*  278 */     return this.idTypeList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getWorkTypeList() {
/*  282 */     if (this.workTypeList != null) {
/*  283 */       this.workTypeList.clear();
/*      */     }
/*  285 */     String mainRisk = getRiskCode();
/*  286 */     ExeSQL tExeSQL = new ExeSQL();
/*  287 */     String workSQL = "select paramvalue,paramname from lepriskparam where paramcode='AppntWorkType' and riskcode='" + mainRisk + "'";
/*  288 */     String orderBy = " order by length(paramname)";
/*  289 */     workSQL = workSQL + orderBy;
/*  290 */     SSRS tSRS = tExeSQL.execSQL(workSQL);
/*  291 */     for (int i = 1; i <= tSRS.MaxRow; i++) {
/*  292 */       this.workTypeList.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*      */     }
/*  294 */     return this.workTypeList;
/*      */   }
/*      */ 
/*      */   public void setWorkTypeList(List<SelectItem> workTypeList) {
/*  298 */     this.workTypeList = workTypeList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getOccupationTypeList2() {
/*  302 */     if ((this.currentWorkType == null) || ("".equals(this.currentWorkType))) {
/*  303 */       return this.occupationTypeList2;
/*      */     }
/*  305 */     if ((this.oldWorkType != null) && (!"".equals(this.oldWorkType)) && 
/*  306 */       (this.oldWorkType.equals(this.currentWorkType))) {
/*  307 */       return this.occupationTypeList2;
/*      */     }
/*      */ 
/*  310 */     this.occupationTypeList2.clear();
/*  311 */     ExeSQL tExeSQL = new ExeSQL();
/*  312 */     String occupSQL = "select occupationCode,occupationName from ledOccupation where workType='" + this.currentWorkType + "'";
/*  313 */     String orderBy = "  order by length(occupationName)";
/*  314 */     occupSQL = occupSQL + orderBy;
/*  315 */     SSRS tSSRS = tExeSQL.execSQL(occupSQL);
/*  316 */     for (int i = 1; i <= tSSRS.MaxRow; i++) {
/*  317 */       this.occupationTypeList2.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));
/*      */     }
/*  319 */     setOldWorkType(this.currentWorkType);
/*  320 */     return this.occupationTypeList2;
/*      */   }
/*      */ 
/*      */   public void setOccupationTypeList2(List<SelectItem> OccupationTypeList2) {
/*  324 */     this.occupationTypeList2 = OccupationTypeList2;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getWorkTypeInsuredList()
/*      */   {
/*  329 */     if ((this.workTypeInsuredList != null) && (this.workTypeInsuredList.size() > 0)) {
/*  330 */       return this.workTypeInsuredList;
/*      */     }
/*  332 */     ExeSQL tExeSQL = new ExeSQL();
/*  333 */     String workSQL = "select distinct worktype,workname from LEDOccupation where worktype in('35','39')";
/*  334 */     String orderBy = " order by length(workname)";
/*  335 */     workSQL = workSQL + orderBy;
/*  336 */     SSRS tSRS = tExeSQL.execSQL(workSQL);
/*  337 */     for (int i = 1; i <= tSRS.MaxRow; i++) {
/*  338 */       this.workTypeInsuredList.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*      */     }
/*  340 */     return this.workTypeInsuredList;
/*      */   }
/*      */ 
/*      */   public void setWorkTypeInsuredList(List<SelectItem> workTypeInsuredList) {
/*  344 */     this.workTypeInsuredList = workTypeInsuredList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getOccupationInsuredTypeList()
/*      */   {
/*  356 */     if ((this.occupationInsuredTypeList != null) && (this.occupationInsuredTypeList.size() > 0)) {
/*  357 */       return this.occupationInsuredTypeList;
/*      */     }
/*  359 */     this.occupationInsuredTypeList.clear();
/*  360 */     ExeSQL tExeSQL = new ExeSQL();
/*  361 */     String mainRisk = getRiskCode();
/*      */ 
/*  363 */     String occupSQL = "select paramvalue,paramname from lepriskparam where paramcode='InsureWorkType' and riskcode='" + mainRisk + "'";
/*  364 */     String orderBy = "  order by length(paramname)";
/*  365 */     occupSQL = occupSQL + orderBy;
/*  366 */     SSRS tSSRS = tExeSQL.execSQL(occupSQL);
/*  367 */     for (int i = 1; i <= tSSRS.MaxRow; i++) {
/*  368 */       this.occupationInsuredTypeList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));
/*      */     }
/*      */ 
/*  371 */     return this.occupationInsuredTypeList;
/*      */   }
/*      */ 
/*      */   public void setOccupationInsuredTypeList(List<SelectItem> occupationInsuredTypeList) {
/*  375 */     this.occupationInsuredTypeList = occupationInsuredTypeList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getQuestionForPwdList()
/*      */   {
/*  380 */     if ((this.questionForPwdList != null) && (this.questionForPwdList.size() > 0))
/*      */     {
/*  382 */       return this.questionForPwdList;
/*      */     }
/*  384 */     ExeSQL tExeSQL = new ExeSQL();
/*  385 */     SSRS tSSRS = new SSRS();
/*  386 */     String sql = "select code,codename from ledcode where codetype='questionforpwd' ";
/*  387 */     tSSRS = tExeSQL.execSQL(sql);
/*  388 */     for (int i = 1; i <= tSSRS.getMaxRow(); i++)
/*      */     {
/*  390 */       this.questionForPwdList.add(
/*  391 */         new SelectItem(tSSRS.GetText(i, 1), tSSRS
/*  391 */         .GetText(i, 2)));
/*      */     }
/*  393 */     return this.questionForPwdList;
/*      */   }
/*      */ 
/*      */   public void setQuestionForPwdList(List<SelectItem> questionForPwdList)
/*      */   {
/*  398 */     this.questionForPwdList = questionForPwdList;
/*      */   }
/*      */ 
/*      */   public void setBankComCodeList(List<SelectItem> bankComCodeList)
/*      */   {
/*  404 */     this.bankComCodeList = bankComCodeList;
/*      */   }
/*      */   public List<SelectItem> getBankComCodeList() {
/*  407 */     if (this.bankComCodeList == null) {
/*  408 */       this.bankComCodeList = new ArrayList();
/*      */     }
/*  410 */     this.bankComCodeList.clear();
/*  411 */     ExeSQL tExeSQL = new ExeSQL();
/*  412 */     String comN = getComCode();
/*  413 */     if ((comN == null) || ("".equals(comN))) {
/*  414 */       return this.bankComCodeList;
/*      */     }
/*  416 */     String bankSQL = "select a.bankCode, a.bankName from ledbank a where a.bankAppType='B' and exists (select 1 from ledbankcomrela rela where rela.comCode='" + comN + "' and " + 
/*  417 */       " rela.bankAppType='B' and a.bankCode=rela.bankCode) order by length(a.bankName)";
/*  418 */     SSRS tSSRS = tExeSQL.execSQL(bankSQL);
/*  419 */     for (int i = 1; i <= tSSRS.MaxRow; i++) {
/*  420 */       this.bankComCodeList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));
/*      */     }
/*  422 */     return this.bankComCodeList;
/*      */   }
/*      */ 
/*      */   public void setPayModeList(List<SelectItem> payModeList)
/*      */   {
/*  428 */     this.payModeList = payModeList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getPayModeList() {
/*  432 */     if ((this.payModeList != null) && (this.payModeList.size() > 0)) {
/*  433 */       return this.payModeList;
/*      */     }
/*  435 */     this.payModeList.clear();
/*  436 */     ExeSQL tExeSQL = new ExeSQL();
/*  437 */     SSRS tSSRS = new SSRS();
/*  438 */     String sql = "select code,codename from ledcode where codetype='paymode' and code<>'4' order by code";
/*  439 */     tSSRS = tExeSQL.execSQL(sql);
/*  440 */     for (int i = 1; i <= tSSRS.getMaxRow(); i++) {
/*  441 */       this.payModeList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));
/*      */     }
/*  443 */     return this.payModeList;
/*      */   }
/*      */ 
/*      */   public void setProjectType(List<SelectItem> projectType)
/*      */   {
/*  448 */     this.projectType = projectType;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getProjectType() {
/*  452 */     if ((this.projectType != null) && (this.projectType.size() > 0)) {
/*  453 */       return this.projectType;
/*      */     }
/*  455 */     this.projectType.clear();
/*  456 */     ExeSQL tExeSQL = new ExeSQL();
/*  457 */     SSRS tSSRS = new SSRS();
/*  458 */     String sql = "select code,codename  from mcode where codetype='projectType'  order by code";
/*  459 */     tSSRS = tExeSQL.execSQL(sql);
/*  460 */     for (int i = 1; i <= tSSRS.getMaxRow(); i++) {
/*  461 */       this.projectType.add(new SelectItem(tSSRS.GetText(i, 2), tSSRS.GetText(i, 2)));
/*      */     }
/*  463 */     return this.projectType;
/*      */   }
/*      */ 
/*      */   public void setWageTimeList(List<SelectItem> wageTimeList)
/*      */   {
/*  468 */     this.wageTimeList = wageTimeList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getWageTimeList() {
/*  472 */     if ((this.wageTimeList != null) && (this.wageTimeList.size() > 0)) {
/*  473 */       return this.wageTimeList;
/*      */     }
/*  475 */     this.wageTimeList.clear();
/*  476 */     ExeSQL tExeSQL = new ExeSQL();
/*  477 */     SSRS tSSRS = new SSRS();
/*  478 */     String sql = "select code,codename  from mcode where codetype='wagetimetype'  order by code";
/*  479 */     tSSRS = tExeSQL.execSQL(sql);
/*  480 */     for (int i = 1; i <= tSSRS.getMaxRow(); i++) {
/*  481 */       this.wageTimeList.add(new SelectItem(tSSRS.GetText(i, 1) + "--" + tSSRS.GetText(i, 2), tSSRS.GetText(i, 2)));
/*      */     }
/*  483 */     return this.wageTimeList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getAgentPccTypeList()
/*      */   {
/*  489 */     if (this.agentPccTypeList == null) {
/*  490 */       this.agentPccTypeList = new ArrayList();
/*      */     }
/*  492 */     this.agentPccTypeList.clear();
/*  493 */     ExeSQL tExeSQL = new ExeSQL();
/*  494 */     SSRS tSSRS = new SSRS();
/*  495 */     String sql = "select code,codename  from mcode where codetype='agentpcctype'  order by code";
/*  496 */     tSSRS = tExeSQL.execSQL(sql);
/*  497 */     for (int i = 1; i <= tSSRS.getMaxRow(); i++) {
/*  498 */       this.agentPccTypeList.add(new SelectItem(tSSRS.GetText(i, 1) + "--" + tSSRS.GetText(i, 2), tSSRS.GetText(i, 2)));
/*      */     }
/*  500 */     return this.agentPccTypeList;
/*      */   }
/*      */ 
/*      */   public void setAgentPccTypeList(List<SelectItem> agentPccTypeList)
/*      */   {
/*  505 */     this.agentPccTypeList = agentPccTypeList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getAgentPccQueryTypeList()
/*      */   {
/*  512 */     if (this.agentPccQueryTypeList == null) {
/*  513 */       this.agentPccQueryTypeList = new ArrayList();
/*      */     }
/*  515 */     this.agentPccQueryTypeList.clear();
/*  516 */     ExeSQL tExeSQL = new ExeSQL();
/*  517 */     SSRS tSSRS = new SSRS();
/*  518 */     String sql = "select code,codename  from mcode where codetype='agentpccquerytype'  order by code";
/*  519 */     tSSRS = tExeSQL.execSQL(sql);
/*  520 */     for (int i = 1; i <= tSSRS.getMaxRow(); i++) {
/*  521 */       this.agentPccQueryTypeList.add(new SelectItem(tSSRS.GetText(i, 1) + "--" + tSSRS.GetText(i, 2), tSSRS.GetText(i, 2)));
/*      */     }
/*  523 */     return this.agentPccQueryTypeList;
/*      */   }
/*      */ 
/*      */   public void setAgentPccQueryTypeList(List<SelectItem> agentPccQueryTypeList)
/*      */   {
/*  528 */     this.agentPccQueryTypeList = agentPccQueryTypeList;
/*      */   }
/*      */ 
/*      */   public void setComCodeList(List<SelectItem> comCodeList)
/*      */   {
/*  534 */     this.comCodeList = comCodeList;
/*      */   }
/*      */   public List<SelectItem> getComCodeList() {
/*  537 */     if ((this.comCodeList != null) && (this.comCodeList.size() > 0)) {
/*  538 */       return this.comCodeList;
/*      */     }
/*  540 */     if (this.comCodeList == null) {
/*  541 */       this.comCodeList = new ArrayList();
/*      */     }
/*  543 */     ExeSQL tExeSQL = new ExeSQL();
/*  544 */     String comSQL = "select comCode, name from mcom where 1=1 order by comCode";
/*  545 */     SSRS tSSRS = tExeSQL.execSQL(comSQL);
/*  546 */     for (int i = 1; i <= tSSRS.MaxRow; i++) {
/*  547 */       this.comCodeList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));
/*      */     }
/*  549 */     return this.comCodeList;
/*      */   }
/*      */ 
/*      */   public void setKnowSiteList(List<SelectItem> knowSiteList)
/*      */   {
/*  555 */     this.knowSiteList = knowSiteList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getKnowSiteList() {
/*  559 */     if ((this.knowSiteList != null) && (this.knowSiteList.size() > 0)) {
/*  560 */       return this.knowSiteList;
/*      */     }
/*  562 */     if (this.knowSiteList == null) {
/*  563 */       this.knowSiteList = new ArrayList();
/*      */     }
/*  565 */     ExeSQL tExeSQL = new ExeSQL();
/*  566 */     String siteSQL = "select code, codename from ledcode where codetype='KnowSite' order by code";
/*  567 */     SSRS tSSRS = tExeSQL.execSQL(siteSQL);
/*  568 */     for (int i = 1; i <= tSSRS.MaxRow; i++) {
/*  569 */       this.knowSiteList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));
/*      */     }
/*  571 */     return this.knowSiteList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getProvinceList()
/*      */   {
/*  576 */     if ((this.provinceList != null) && (this.provinceList.size() > 0))
/*      */     {
/*  578 */       return this.provinceList;
/*      */     }
/*  580 */     this.provinceList = new ArrayList();
/*  581 */     MCodeDB codeDAO = new MCodeDB();
/*  582 */     MCodeSet codeSet = new MCodeSet();
/*  583 */     codeDAO.setCodeType("provience");
/*  584 */     codeDAO.setOtherSign("N");
/*  585 */     codeSet = codeDAO.query();
/*  586 */     if ((codeSet != null) && (codeSet.size() > 0))
/*      */     {
/*  588 */       for (int iLoop = 1; iLoop <= codeSet.size(); iLoop++)
/*      */       {
/*  590 */         MCodeSchema codeSchema = codeSet.get(iLoop);
/*  591 */         this.provinceList
/*  592 */           .add(new SelectItem(codeSchema.getCode(), codeSchema
/*  593 */           .getCode() + 
/*  594 */           "--" + codeSchema.getCodeName()));
/*      */       }
/*      */     }
/*  597 */     return this.provinceList;
/*      */   }
/*      */ 
/*      */   public void setProvinceList(List<SelectItem> provinceList)
/*      */   {
/*  602 */     this.provinceList = provinceList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getAccProvinceList()
/*      */   {
/*  607 */     if ((this.accProvinceList != null) && (this.accProvinceList.size() > 0)) {
/*  608 */       return this.accProvinceList;
/*      */     }
/*  610 */     this.accProvinceList = new ArrayList();
/*  611 */     MCodeDB codeDAO = new MCodeDB();
/*  612 */     MCodeSet codeSet = new MCodeSet();
/*  613 */     codeDAO.setCodeType("provience");
/*  614 */     codeDAO.setOtherSign("N");
/*  615 */     codeSet = codeDAO.query();
/*  616 */     if (codeSet.size() > 0)
/*      */     {
/*  618 */       for (int iLoop = 1; iLoop <= codeSet.size(); iLoop++)
/*      */       {
/*  620 */         MCodeSchema codeSchema = codeSet.get(iLoop);
/*  621 */         this.accProvinceList.add(new SelectItem(codeSchema.getCode(), codeSchema.getCodeName()));
/*      */       }
/*      */     }
/*  624 */     return this.accProvinceList;
/*      */   }
/*      */ 
/*      */   public void setAccProvinceList(List<SelectItem> accProvinceList)
/*      */   {
/*  629 */     this.accProvinceList = accProvinceList;
/*      */   }
/*      */ 
/*      */   public String getCurrentProvince()
/*      */   {
/*  634 */     return this.currentProvince;
/*      */   }
/*      */ 
/*      */   public void setCurrentProvince(String currentProvince)
/*      */   {
/*  639 */     this.currentProvince = currentProvince;
/*      */   }
/*      */ 
/*      */   public String getOldProvince()
/*      */   {
/*  644 */     return this.oldProvince;
/*      */   }
/*      */ 
/*      */   public void setOldProvince(String oldProvince)
/*      */   {
/*  649 */     this.oldProvince = oldProvince;
/*      */   }
/*      */ 
/*      */   public void changeCity(ValueChangeEvent event) {
/*  653 */     System.out.println("\u9009\u62E9\u7684\u65B0\u57CE\u5E02\u503C\u662F:" + event.getNewValue().toString());
/*  654 */     String city = event.getNewValue().toString();
/*  655 */     String areaCodeSQL = "select codealias from ledcode where codetype='city' and code='" + city + "'";
/*  656 */     ExeSQL tExeSQL = new ExeSQL();
/*  657 */     String areaCode = tExeSQL.getOneValue(areaCodeSQL);
/*  658 */     System.out.println("====areaCode====" + areaCode);
/*  659 */     setPhoneAreaCode(areaCode);
/*      */   }
/*      */ 
/*      */   public void changeProvince(ValueChangeEvent event)
/*      */   {
/*  664 */     System.out.println("\u9009\u62E9\u7684\u65B0\u503C\u662F:" + event.getNewValue().toString());
/*  665 */     setCurrentProvince(event.getNewValue().toString());
/*      */   }
/*      */ 
/*      */   public void changeAppntWorkType(ValueChangeEvent event) {
/*  669 */     System.out.println("\u9009\u62E9\u7684\u65B0\u804C\u4E1A\u7C7B\u522B\u662F:" + event.getNewValue().toString());
/*  670 */     setCurrentWorkType(event.getNewValue().toString());
/*      */   }
/*      */ 
/*      */   public void changeInsuredWorkType(ValueChangeEvent event) {
/*  674 */     System.out.println("\u9009\u62E9\u7684\u65B0\u804C\u4E1A\u7C7B\u522B\u662F:" + event.getNewValue().toString());
/*  675 */     setCurrentInsuredWorkType(event.getNewValue().toString());
/*      */   }
/*      */ 
/*      */   public void change()
/*      */   {
/*  685 */     System.out.println("Chang\u4E86\u5417\uFF1F");
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getCityList()
/*      */   {
/*  690 */     if ((this.oldProvince != null) && (!"".equals(this.oldProvince)))
/*      */     {
/*  692 */       if (this.oldProvince.equals(this.currentProvince))
/*      */       {
/*  694 */         return this.cityList;
/*      */       }
/*      */     }
/*  697 */     this.cityList = new ArrayList();
/*  698 */     if ((this.currentProvince != null) && (!"".equals(this.currentProvince)))
/*      */     {
/*  700 */       MCodeDB codeDAO = new MCodeDB();
/*  701 */       MCodeSet codeSet = new MCodeSet();
/*  702 */       codeDAO.setCodeType("city");
/*  703 */       codeDAO.setOtherSign("N");
/*  704 */       codeDAO.setComCode(this.currentProvince);
/*  705 */       codeSet = codeDAO.query();
/*  706 */       if ((codeSet != null) && (codeSet.size() > 0))
/*      */       {
/*  708 */         for (int iLoop = 1; iLoop <= codeSet.size(); iLoop++)
/*      */         {
/*  710 */           MCodeSchema codeSchema = codeSet.get(iLoop);
/*  711 */           this.cityList.add(
/*  712 */             new SelectItem(codeSchema.getCode(), 
/*  712 */             codeSchema.getCode() + "--" + 
/*  713 */             codeSchema.getCodeName()));
/*      */         }
/*      */       }
/*      */     }
/*  717 */     return this.cityList;
/*      */   }
/*      */ 
/*      */   public void setCityList(List<SelectItem> cityList)
/*      */   {
/*  722 */     this.cityList = cityList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getAccCityList()
/*      */   {
/*  750 */     if (this.accCityList == null) {
/*  751 */       this.accCityList = new ArrayList();
/*      */     }
/*  753 */     this.accCityList.clear();
/*  754 */     String sql = "select code, codeName from ledcode where codetype='city' and othersign='N' and code in ('110100','210100','210200','440100','440300','500100')";
/*  755 */     ExeSQL tExeSQL = new ExeSQL();
/*  756 */     SSRS tSSRS = tExeSQL.execSQL(sql);
/*  757 */     if (tSSRS.MaxRow > 0) {
/*  758 */       for (int iLoop = 1; iLoop <= tSSRS.MaxRow; iLoop++) {
/*  759 */         this.accCityList.add(new SelectItem(tSSRS.GetText(iLoop, 1), tSSRS.GetText(iLoop, 2)));
/*      */       }
/*      */     }
/*      */ 
/*  763 */     return this.accCityList;
/*      */   }
/*      */ 
/*      */   public void setAccCityList(List<SelectItem> accCityList)
/*      */   {
/*  768 */     this.accCityList = accCityList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getRiskTypeMap()
/*      */   {
/*  773 */     if ((this.riskTypeMap != null) && (this.riskTypeMap.size() > 0))
/*      */     {
/*  775 */       return this.riskTypeMap;
/*      */     }
/*  777 */     this.riskTypeMap = createCodeItem("riskType", "L");
/*  778 */     return this.riskTypeMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getProductClass()
/*      */   {
/*  784 */     if ((this.productClass != null) && (this.productClass.size() > 0))
/*      */     {
/*  786 */       return this.productClass;
/*      */     }
/*  788 */     this.productClass = createCodeItem("productsT", "L");
/*  789 */     return this.productClass;
/*      */   }
/*      */ 
/*      */   public void setProductClass(List<SelectItem> productT)
/*      */   {
/*  794 */     this.productClass = productT;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getPopedom()
/*      */   {
/*  800 */     if ((this.popedom != null) && (this.popedom.size() > 0))
/*      */     {
/*  802 */       return this.popedom;
/*      */     }
/*  804 */     this.popedom = createCodeItem("popedom", "L");
/*  805 */     return this.popedom;
/*      */   }
/*      */ 
/*      */   public void setPopedom(List<SelectItem> tPopedom)
/*      */   {
/*  810 */     this.popedom = tPopedom;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getOrderMap()
/*      */   {
/*  816 */     if ((this.orderMap != null) && (this.orderMap.size() > 0))
/*      */     {
/*  818 */       return this.orderMap;
/*      */     }
/*  820 */     this.orderMap = createCodeItem("orderState", "L");
/*  821 */     return this.orderMap;
/*      */   }
/*      */ 
/*      */   public void setOrderMap(List<SelectItem> tOrderMap)
/*      */   {
/*  826 */     this.orderMap = tOrderMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getRiskPropMap()
/*      */   {
/*  831 */     if ((this.riskPropMap != null) && (this.riskPropMap.size() > 0))
/*      */     {
/*  833 */       return this.riskPropMap;
/*      */     }
/*  835 */     this.riskPropMap = createCodeItem("riskProp", "L");
/*  836 */     return this.riskPropMap;
/*      */   }
/*      */ 
/*      */   public void setRiskPropMap(List<SelectItem> riskPropMap)
/*      */   {
/*  841 */     this.riskPropMap = riskPropMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getBonusFlagMap()
/*      */   {
/*  846 */     if ((this.bonusFlagMap != null) && (this.bonusFlagMap.size() > 0))
/*      */     {
/*  848 */       return this.bonusFlagMap;
/*      */     }
/*  850 */     this.bonusFlagMap = createCodeItem("bonusFlag", "L");
/*  851 */     return this.bonusFlagMap;
/*      */   }
/*      */ 
/*      */   public void setBonusFlagMap(List<SelectItem> bonusFlagMap)
/*      */   {
/*  856 */     this.bonusFlagMap = bonusFlagMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getBonusModeMap()
/*      */   {
/*  861 */     if ((this.bonusModeMap != null) && (this.bonusModeMap.size() > 0))
/*      */     {
/*  863 */       return this.bonusModeMap;
/*      */     }
/*  865 */     this.bonusModeMap = createCodeItem("bonusMode", "L");
/*  866 */     return this.bonusModeMap;
/*      */   }
/*      */ 
/*      */   public void setBonusModeMap(List<SelectItem> bonusModeMap)
/*      */   {
/*  871 */     this.bonusModeMap = bonusModeMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getSubRiskFlagMap()
/*      */   {
/*  876 */     if ((this.subRiskFlagMap != null) && (this.subRiskFlagMap.size() > 0))
/*      */     {
/*  878 */       return this.subRiskFlagMap;
/*      */     }
/*  880 */     this.subRiskFlagMap = createCodeItem("subRiskFlag", "L");
/*  881 */     return this.subRiskFlagMap;
/*      */   }
/*      */ 
/*      */   public void setSubRiskFlagMap(List<SelectItem> subRiskFlagMap)
/*      */   {
/*  886 */     this.subRiskFlagMap = subRiskFlagMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getInsuredFlagMap()
/*      */   {
/*  891 */     if ((this.insuredFlagMap != null) && (this.insuredFlagMap.size() > 0))
/*      */     {
/*  893 */       return this.insuredFlagMap;
/*      */     }
/*  895 */     this.insuredFlagMap = createCodeItem("insuredFlag", "L");
/*  896 */     return this.insuredFlagMap;
/*      */   }
/*      */ 
/*      */   public void setInsuredFlagMap(List<SelectItem> insuredFlagMap)
/*      */   {
/*  901 */     this.insuredFlagMap = insuredFlagMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getShareFlagMap()
/*      */   {
/*  906 */     if ((this.shareFlagMap != null) && (this.shareFlagMap.size() > 0))
/*      */     {
/*  908 */       return this.shareFlagMap;
/*      */     }
/*  910 */     this.shareFlagMap = createCodeItem("shareFlag", "L");
/*  911 */     return this.shareFlagMap;
/*      */   }
/*      */ 
/*      */   public void setShareFlagMap(List<SelectItem> shareFlagMap)
/*      */   {
/*  916 */     this.shareFlagMap = shareFlagMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getBnfFlagMap()
/*      */   {
/*  921 */     if ((this.bnfFlagMap != null) && (this.bnfFlagMap.size() > 0))
/*      */     {
/*  923 */       return this.bnfFlagMap;
/*      */     }
/*  925 */     this.bnfFlagMap = createCodeItem("bnfFlag", "L");
/*  926 */     return this.bnfFlagMap;
/*      */   }
/*      */ 
/*      */   public void setBnfFlagMap(List<SelectItem> bnfFlagMap)
/*      */   {
/*  931 */     this.bnfFlagMap = bnfFlagMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getImpartFlagMap()
/*      */   {
/*  936 */     if ((this.impartFlagMap != null) && (this.impartFlagMap.size() > 0))
/*      */     {
/*  938 */       return this.impartFlagMap;
/*      */     }
/*  940 */     this.impartFlagMap = createCodeItem("impartFlag", "L");
/*  941 */     return this.impartFlagMap;
/*      */   }
/*      */ 
/*      */   public void setImpartFlagMap(List<SelectItem> impartFlagMap)
/*      */   {
/*  946 */     this.impartFlagMap = impartFlagMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getChoDutyFlagMap()
/*      */   {
/*  951 */     if ((this.choDutyFlagMap != null) && (this.choDutyFlagMap.size() > 0))
/*      */     {
/*  953 */       return this.choDutyFlagMap;
/*      */     }
/*  955 */     this.choDutyFlagMap = createCodeItem("choDutyFlag", "L");
/*  956 */     return this.choDutyFlagMap;
/*      */   }
/*      */ 
/*      */   public void setChoDutyFlagMap(List<SelectItem> choDutyFlagMap)
/*      */   {
/*  961 */     this.choDutyFlagMap = choDutyFlagMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getCPayFlagMap()
/*      */   {
/*  966 */     if ((this.cPayFlagMap != null) && (this.cPayFlagMap.size() > 0))
/*      */     {
/*  968 */       return this.cPayFlagMap;
/*      */     }
/*  970 */     this.cPayFlagMap = createCodeItem("cPayFlag", "L");
/*  971 */     return this.cPayFlagMap;
/*      */   }
/*      */ 
/*      */   public void setCPayFlagMap(List<SelectItem> payFlagMap)
/*      */   {
/*  976 */     this.cPayFlagMap = payFlagMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getGetFlagMap()
/*      */   {
/*  981 */     if ((this.getFlagMap != null) && (this.getFlagMap.size() > 0))
/*      */     {
/*  983 */       return this.getFlagMap;
/*      */     }
/*  985 */     this.getFlagMap = createCodeItem("getFlag", "L");
/*  986 */     return this.getFlagMap;
/*      */   }
/*      */ 
/*      */   public void setGetFlagMap(List<SelectItem> getFlagMap)
/*      */   {
/*  991 */     this.getFlagMap = getFlagMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getEdorFlagMap()
/*      */   {
/*  996 */     if ((this.edorFlagMap != null) && (this.edorFlagMap.size() > 0))
/*      */     {
/*  998 */       return this.edorFlagMap;
/*      */     }
/* 1000 */     this.edorFlagMap = createCodeItem("edorFlag", "L");
/* 1001 */     return this.edorFlagMap;
/*      */   }
/*      */ 
/*      */   public void setEdorFlagMap(List<SelectItem> edorFlagMap)
/*      */   {
/* 1006 */     this.edorFlagMap = edorFlagMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getRnewFlagMap()
/*      */   {
/* 1011 */     if ((this.rnewFlagMap != null) && (this.rnewFlagMap.size() > 0))
/*      */     {
/* 1013 */       return this.rnewFlagMap;
/*      */     }
/* 1015 */     this.rnewFlagMap = createCodeItem("rnewFlag", "L");
/* 1016 */     return this.rnewFlagMap;
/*      */   }
/*      */ 
/*      */   public void setRnewFlagMap(List<SelectItem> rnewFlagMap)
/*      */   {
/* 1021 */     this.rnewFlagMap = rnewFlagMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getUwFlagMap()
/*      */   {
/* 1026 */     if ((this.uwFlagMap != null) && (this.uwFlagMap.size() > 0))
/*      */     {
/* 1028 */       return this.uwFlagMap;
/*      */     }
/* 1030 */     this.uwFlagMap = createCodeItem("UWFlag", "L");
/* 1031 */     return this.uwFlagMap;
/*      */   }
/*      */ 
/*      */   public void setUwFlagMap(List<SelectItem> uwFlagMap)
/*      */   {
/* 1036 */     this.uwFlagMap = uwFlagMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getRinsFlagMap()
/*      */   {
/* 1041 */     if ((this.rinsFlagMap != null) && (this.rinsFlagMap.size() > 0))
/*      */     {
/* 1043 */       return this.rinsFlagMap;
/*      */     }
/* 1045 */     this.rinsFlagMap = createCodeItem("rinsFlag", "L");
/* 1046 */     return this.rinsFlagMap;
/*      */   }
/*      */ 
/*      */   public void setRinsFlagMap(List<SelectItem> rinsFlagMap)
/*      */   {
/* 1051 */     this.rinsFlagMap = rinsFlagMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getInsuAccFlagMap()
/*      */   {
/* 1056 */     if ((this.insuAccFlagMap != null) && (this.insuAccFlagMap.size() > 0))
/*      */     {
/* 1058 */       return this.insuAccFlagMap;
/*      */     }
/* 1060 */     this.insuAccFlagMap = createCodeItem("insuAccFlag", "L");
/* 1061 */     return this.insuAccFlagMap;
/*      */   }
/*      */ 
/*      */   public void setInsuAccFlagMap(List<SelectItem> insuAccFlagMap)
/*      */   {
/* 1066 */     this.insuAccFlagMap = insuAccFlagMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getPayModeMap()
/*      */   {
/* 1071 */     if ((this.payModeMap != null) && (this.payModeMap.size() > 0))
/*      */     {
/* 1073 */       return this.payModeMap;
/*      */     }
/* 1075 */     this.payModeMap = createCodeItem("payMode", "L");
/* 1076 */     return this.payModeMap;
/*      */   }
/*      */ 
/*      */   public void setPayModeMap(List<SelectItem> payModeMap)
/*      */   {
/* 1081 */     this.payModeMap = payModeMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getRiskPeriodMap()
/*      */   {
/* 1086 */     if ((this.riskPeriodMap != null) && (this.riskPeriodMap.size() > 0))
/*      */     {
/* 1088 */       return this.riskPeriodMap;
/*      */     }
/* 1090 */     this.riskPeriodMap = createCodeItem("riskPeriod", "L");
/* 1091 */     return this.riskPeriodMap;
/*      */   }
/*      */ 
/*      */   public void setRiskPeriodMap(List<SelectItem> riskPeriodMap)
/*      */   {
/* 1096 */     this.riskPeriodMap = riskPeriodMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getOrgMap()
/*      */   {
/* 1101 */     if ((this.orgMap != null) && (this.orgMap.size() > 0))
/*      */     {
/* 1103 */       return this.orgMap;
/*      */     }
/*      */ 
/* 1106 */     this.orgMap = new ArrayList();
/* 1107 */     MComDB comDAO = new MComDB();
/* 1108 */     MComSet comSet = new MComSet();
/* 1109 */     comSet = comDAO.executeQuery("select * from mcom order by comcode");
/* 1110 */     if ((comSet != null) && (comSet.size() > 0))
/*      */     {
/* 1112 */       for (int iLoop = 1; iLoop <= comSet.size(); iLoop++)
/*      */       {
/* 1114 */         MComSchema comSchema = comSet.get(iLoop);
/* 1115 */         this.orgMap.add(
/* 1116 */           new SelectItem(comSchema.getComCode() + "--" + 
/* 1116 */           comSchema.getName(), comSchema.getComCode()));
/*      */       }
/*      */     }
/* 1119 */     return this.orgMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getUserStateMap()
/*      */   {
/* 1124 */     if ((this.userStateMap != null) && (this.userStateMap.size() > 0))
/*      */     {
/* 1126 */       return this.userStateMap;
/*      */     }
/* 1128 */     this.userStateMap = createCodeItem("UserState", "L");
/* 1129 */     return this.userStateMap;
/*      */   }
/*      */ 
/*      */   public void setUserStateMap(List<SelectItem> userStateMap)
/*      */   {
/* 1134 */     this.userStateMap = userStateMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getSuperFlagMap()
/*      */   {
/* 1139 */     if ((this.superFlagMap != null) && (this.superFlagMap.size() > 0))
/*      */     {
/* 1141 */       return this.superFlagMap;
/*      */     }
/* 1143 */     this.superFlagMap = createCodeItem("SuperPopedomFlag", "L");
/* 1144 */     return this.superFlagMap;
/*      */   }
/*      */ 
/*      */   public void setSuperFlagMap(List<SelectItem> superFlagMap)
/*      */   {
/* 1149 */     this.superFlagMap = superFlagMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getCodeTypeMap()
/*      */   {
/* 1154 */     if ((this.codeTypeMap != null) && (this.codeTypeMap.size() > 0))
/*      */     {
/* 1156 */       return this.codeTypeMap;
/*      */     }
/*      */ 
/* 1159 */     this.codeTypeMap = new ArrayList();
/* 1160 */     MCodeDB codeDAO = new MCodeDB();
/* 1161 */     MCodeSet codeSet = new MCodeSet();
/* 1162 */     codeDAO.setCodeType("codetype");
/* 1163 */     codeDAO.setOtherSign("N");
/* 1164 */     codeSet = codeDAO.query();
/* 1165 */     if ((codeSet != null) && (codeSet.size() > 0))
/*      */     {
/* 1167 */       for (int iLoop = 1; iLoop <= codeSet.size(); iLoop++)
/*      */       {
/* 1169 */         MCodeSchema codeSchema = codeSet.get(iLoop);
/* 1170 */         this.codeTypeMap.add(
/* 1171 */           new SelectItem(codeSchema.getCode() + "--" + 
/* 1171 */           codeSchema.getCodeName(), codeSchema.getCode()));
/*      */       }
/*      */     }
/* 1174 */     return this.codeTypeMap;
/*      */   }
/*      */ 
/*      */   public void setCodeTypeMap(List<SelectItem> codeTypeMap)
/*      */   {
/* 1179 */     this.codeTypeMap = codeTypeMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getInsuMonitorMap()
/*      */   {
/* 1184 */     if ((this.insuMonitorMap != null) && (this.insuMonitorMap.size() > 0))
/*      */     {
/* 1186 */       return this.insuMonitorMap;
/*      */     }
/*      */ 
/* 1189 */     this.insuMonitorMap = createCodeItem("insuMonitor", "L");
/* 1190 */     return this.insuMonitorMap;
/*      */   }
/*      */ 
/*      */   public void setInsuMonitorMap(List<SelectItem> insuMonitorMap)
/*      */   {
/* 1195 */     this.insuMonitorMap = insuMonitorMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getComNatureMap()
/*      */   {
/* 1200 */     if ((this.comNatureMap != null) && (this.comNatureMap.size() > 0))
/*      */     {
/* 1202 */       return this.comNatureMap;
/*      */     }
/*      */ 
/* 1205 */     this.comNatureMap = createCodeItem("comNature", "L");
/* 1206 */     return this.comNatureMap;
/*      */   }
/*      */ 
/*      */   public void setComNatureMap(List<SelectItem> comNatureMap)
/*      */   {
/* 1211 */     this.comNatureMap = comNatureMap;
/*      */   }
/*      */ 
/*      */   public void setPayPeriodList2(List<SelectItem> payPeriodList2)
/*      */   {
/* 1219 */     this.payPeriodList2 = payPeriodList2;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getPayPeriodList2()
/*      */   {
/* 1224 */     if (this.payPeriodList2.size() > 0) {
/* 1225 */       this.payPeriodList2.clear();
/*      */     }
/* 1227 */     String riskN = getRiskCode();
/* 1228 */     if ((riskN == null) || ("".equals(riskN))) {
/* 1229 */       return this.payPeriodList2;
/*      */     }
/* 1231 */     ExeSQL tExeSQL = new ExeSQL();
/* 1232 */     String sql = "select b.paramvalue,(case when b.paramvalue='0' then '\u8DB8\u4EA4' else b.paramvalue||'\u5E74\u4EA4' end) from lepriskparam b where b.riskcode='" + riskN + "' and b.paramcode='PayPeriod'";
/* 1233 */     SSRS tSSRS = tExeSQL.execSQL(sql);
/* 1234 */     for (int i = 1; i <= tSSRS.MaxRow; i++) {
/* 1235 */       this.payPeriodList2.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));
/*      */     }
/* 1237 */     return this.payPeriodList2;
/*      */   }
/*      */ 
/*      */   public void setPayPeriodList(List<SelectItem> payPeriodList)
/*      */   {
/* 1244 */     this.payPeriodList = payPeriodList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getPayPeriodList()
/*      */   {
/* 1249 */     if (this.payPeriodList.size() > 0) {
/* 1250 */       return this.payPeriodList;
/*      */     }
/* 1252 */     return getRiskParam("PayPeriod");
/*      */   }
/*      */ 
/*      */   public void setAmntLimitList(List<SelectItem> amntLimitList)
/*      */   {
/* 1257 */     this.amntLimitList = amntLimitList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getAmntLimitList()
/*      */   {
/* 1262 */     if (this.amntLimitList.size() > 0) {
/* 1263 */       return this.amntLimitList;
/*      */     }
/* 1265 */     String sql = "select paramvalue,paramname from lepriskparam where riskcode='RTM209' and paramcode='AmntLimit'";
/* 1266 */     ExeSQL tExeSQL = new ExeSQL();
/* 1267 */     SSRS tSSRS = new SSRS();
/* 1268 */     tSSRS = tExeSQL.execSQL(sql);
/* 1269 */     DecimalFormat df = new DecimalFormat("0.0");
/*      */     try
/*      */     {
/* 1272 */       for (int i = 1; i <= tSSRS.getMaxRow(); i++)
/*      */       {
/* 1274 */         this.amntLimitList.add(new SelectItem(df.format(Double.parseDouble(tSSRS.GetText(i, 1).trim())), tSSRS.GetText(i, 2)));
/*      */       }
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1279 */       System.out.println(ex.getMessage());
/* 1280 */       return this.amntLimitList;
/*      */     }
/* 1282 */     return this.amntLimitList;
/*      */   }
/*      */ 
/*      */   public void setAmntLimitList2(List<SelectItem> amntLimitList2)
/*      */   {
/* 1289 */     this.amntLimitList2 = amntLimitList2;
/*      */   }
/*      */   public List<SelectItem> getAmntLimitList2() {
/* 1292 */     if (this.amntLimitList2.size() > 0)
/*      */     {
/* 1294 */       this.amntLimitList2.clear();
/*      */     }
/* 1296 */     String riskN = getRiskCode();
/* 1297 */     if ((riskN == null) || ("".equals(riskN))) {
/* 1298 */       return this.amntLimitList2;
/*      */     }
/* 1300 */     String sql = "select a.code,a.codename from ledcode a where a.codetype='AmntLimit' and exists (select 1 from lepriskparam b where b.riskcode='" + 
/* 1301 */       riskN + "' and b.paramcode='AmntLimit' and a.code=b.paramvalue)";
/* 1302 */     String orderby = " order by to_number(a.code)";
/* 1303 */     sql = sql + orderby;
/* 1304 */     ExeSQL tExeSQL = new ExeSQL();
/* 1305 */     SSRS tSSRS = new SSRS();
/* 1306 */     tSSRS = tExeSQL.execSQL(sql);
/* 1307 */     DecimalFormat df = new DecimalFormat("0.0");
/*      */     try {
/* 1309 */       for (int i = 1; i <= tSSRS.getMaxRow(); i++)
/* 1310 */         this.amntLimitList2.add(new SelectItem(df.format(Double.parseDouble(tSSRS.GetText(i, 1).trim())), tSSRS.GetText(i, 2)));
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1314 */       System.out.println(ex.getMessage());
/* 1315 */       return this.amntLimitList2;
/*      */     }
/* 1317 */     return this.amntLimitList2;
/*      */   }
/*      */ 
/*      */   public void setPolTermList(List<SelectItem> polTermList)
/*      */   {
/* 1326 */     this.polTermList = polTermList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getPolTermList()
/*      */   {
/* 1331 */     if (this.polTermList.size() > 0) {
/* 1332 */       return this.polTermList;
/*      */     }
/* 1334 */     return getRiskParam("PolTerm");
/*      */   }
/*      */ 
/*      */   public void setPolTermList2(List<SelectItem> polTermList2)
/*      */   {
/* 1341 */     this.polTermList2 = polTermList2;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getPolTermList2()
/*      */   {
/* 1346 */     if (this.polTermList2.size() > 0) {
/* 1347 */       return this.polTermList2;
/*      */     }
/* 1349 */     return getRiskParamFromLEDCode("PolTerm");
/*      */   }
/*      */ 
/*      */   public void setPayIntvList2(List<SelectItem> payIntvList2)
/*      */   {
/* 1356 */     this.payIntvList2 = payIntvList2;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getPayIntvList2()
/*      */   {
/* 1361 */     if (this.payIntvList2.size() > 0) {
/* 1362 */       return this.payIntvList2;
/*      */     }
/* 1364 */     return getRiskParamFromLEDCode("PayIntv");
/*      */   }
/*      */ 
/*      */   public void setPayIntvList(List<SelectItem> payIntvList)
/*      */   {
/* 1371 */     this.payIntvList = payIntvList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getPayIntvList()
/*      */   {
/* 1377 */     if ((this.payIntvList != null) && (this.payIntvList.size() > 0))
/*      */     {
/* 1379 */       return this.payIntvList;
/*      */     }
/* 1381 */     this.payIntvList = new ArrayList();
/* 1382 */     String sql = "select code,codename from mcode where codetype='payintv' order by codeorder";
/* 1383 */     ExeSQL tExeSQL = new ExeSQL();
/* 1384 */     SSRS tSSRS = new SSRS();
/* 1385 */     tSSRS = tExeSQL.execSQL(sql);
/* 1386 */     for (int i = 1; i <= tSSRS.getMaxRow(); i++)
/*      */     {
/* 1388 */       this.payIntvList.add(new SelectItem(tSSRS.GetText(i, 1) + "--" + tSSRS.GetText(i, 2), tSSRS.GetText(i, 2)));
/*      */     }
/* 1390 */     return this.payIntvList;
/*      */   }
/*      */ 
/*      */   public void setGetModeList2(List<SelectItem> getModeList2)
/*      */   {
/* 1398 */     this.getModeList2 = getModeList2;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getGetModeList2()
/*      */   {
/* 1403 */     if (this.getModeList2.size() > 0) {
/* 1404 */       return this.getModeList2;
/*      */     }
/* 1406 */     return getRiskParamFromLEDCode("GetMode");
/*      */   }
/*      */ 
/*      */   public void setGetModeList(List<SelectItem> getModeList)
/*      */   {
/* 1413 */     this.getModeList = getModeList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getGetModeList()
/*      */   {
/* 1418 */     if (this.getModeList.size() > 0) {
/* 1419 */       return this.getModeList;
/*      */     }
/* 1421 */     return getRiskParam("GetMode");
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getRiskParamFromLEDCode(String paramCode)
/*      */   {
/* 1426 */     List paramList = new ArrayList();
/* 1427 */     String riskN = getRiskCode();
/* 1428 */     if ((riskN == null) || ("".equals(riskN))) {
/* 1429 */       return paramList;
/*      */     }
/* 1431 */     String paramSQL = "select a.code,a.codename from ledcode a where a.codetype='" + paramCode + "'" + 
/* 1432 */       " and exists (select 1 from lepriskparam b where b.riskcode='" + riskN + "' and b.paramcode='" + paramCode + "'" + 
/* 1433 */       " and b.paramvalue=a.code)";
/* 1434 */     ExeSQL tExeSQL = new ExeSQL();
/* 1435 */     SSRS tSSRS = tExeSQL.execSQL(paramSQL);
/* 1436 */     for (int i = 1; i <= tSSRS.getMaxRow(); i++)
/*      */     {
/* 1438 */       paramList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));
/*      */     }
/* 1440 */     return paramList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getRiskParam(String paramCode)
/*      */   {
/* 1445 */     List paramList = new ArrayList();
/* 1446 */     String sql = "select paramvalue,paramname from lepriskparam where riskcode='RTM209' and paramcode='" + 
/* 1447 */       paramCode + "' ";
/* 1448 */     ExeSQL tExeSQL = new ExeSQL();
/* 1449 */     SSRS tSSRS = new SSRS();
/* 1450 */     tSSRS = tExeSQL.execSQL(sql);
/* 1451 */     for (int i = 1; i <= tSSRS.getMaxRow(); i++)
/*      */     {
/* 1453 */       paramList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 
/* 1454 */         2)));
/*      */     }
/* 1456 */     return paramList;
/*      */   }
/*      */ 
/*      */   public void setYesOrNoList(List<SelectItem> yesOrNoList)
/*      */   {
/* 1463 */     this.yesOrNoList = yesOrNoList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getYesOrNoList()
/*      */   {
/* 1468 */     if (this.yesOrNoList.size() > 0) {
/* 1469 */       return this.yesOrNoList;
/*      */     }
/* 1471 */     return getCodeAndName("yesno");
/*      */   }
/*      */ 
/*      */   public void setRelationList(List<SelectItem> relationList)
/*      */   {
/* 1476 */     this.relationList = relationList;
/*      */   }
/*      */   public List<SelectItem> getRelationList() {
/* 1479 */     if (this.relationList.size() > 0) {
/* 1480 */       return this.relationList;
/*      */     }
/* 1482 */     String riskN = getRiskCode();
/* 1483 */     if ((riskN == null) || ("".equals(riskN))) {
/* 1484 */       this.relationList.clear();
/* 1485 */       return this.relationList;
/*      */     }
/* 1487 */     String sql = "select a.code,a.codename From ledcode a where a.codetype='relation' and exists (select 1 from lepriskparam b where b.paramcode='relation' and b.riskCode='" + riskN + "' and b.paramvalue=a.code) order by a.code";
/* 1488 */     ExeSQL tExeSQL = new ExeSQL();
/* 1489 */     SSRS tSSRS = new SSRS();
/* 1490 */     tSSRS = tExeSQL.execSQL(sql);
/* 1491 */     for (int i = 1; i <= tSSRS.getMaxRow(); i++)
/*      */     {
/* 1493 */       this.relationList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));
/*      */     }
/* 1495 */     return this.relationList;
/*      */   }
/*      */ 
/*      */   public void setRelationListAll(List<SelectItem> relationListAll)
/*      */   {
/* 1501 */     this.relationListAll = relationListAll;
/*      */   }
/*      */   public List<SelectItem> getRelationListAll() {
/* 1504 */     if (this.relationListAll.size() > 0) {
/* 1505 */       return this.relationListAll;
/*      */     }
/* 1507 */     this.relationListAll = createCodeItem("relation", "R");
/* 1508 */     return this.relationListAll;
/*      */   }
/*      */ 
/*      */   public void setOccupationTypeList(List<SelectItem> occupationTypeList)
/*      */   {
/* 1514 */     this.occupationTypeList = occupationTypeList;
/*      */   }
/*      */   public List<SelectItem> getOccupationTypeList() {
/* 1517 */     if (this.occupationTypeList.size() > 0) {
/* 1518 */       return this.occupationTypeList;
/*      */     }
/* 1520 */     return getCodeAndName("occupationtype");
/*      */   }
/*      */ 
/*      */   public void setMarriageList(List<SelectItem> marriageList)
/*      */   {
/* 1525 */     this.marriageList = marriageList;
/*      */   }
/*      */   public List<SelectItem> getMarriageList() {
/* 1528 */     if (this.marriageList.size() > 0) {
/* 1529 */       return this.marriageList;
/*      */     }
/* 1531 */     return getCodeAndName("marriage");
/*      */   }
/*      */ 
/*      */   private List<SelectItem> getCodeAndName(String codeType) {
/* 1535 */     List codeAndNameList = new ArrayList();
/* 1536 */     String sql = "select code,codename From ledcode where codetype='" + codeType + "' order by code";
/* 1537 */     ExeSQL tExeSQL = new ExeSQL();
/* 1538 */     SSRS tSSRS = new SSRS();
/* 1539 */     tSSRS = tExeSQL.execSQL(sql);
/* 1540 */     for (int i = 1; i <= tSSRS.getMaxRow(); i++)
/*      */     {
/* 1542 */       codeAndNameList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));
/*      */     }
/* 1544 */     return codeAndNameList;
/*      */   }
/*      */ 
/*      */   public void setIdTypeAppList(List<SelectItem> idTypeAppList)
/*      */   {
/* 1550 */     this.idTypeAppList = idTypeAppList;
/*      */   }
/*      */   public List<SelectItem> getIdTypeAppList() {
/* 1553 */     if ((this.idTypeAppList != null) && (this.idTypeAppList.size() > 0)) {
/* 1554 */       return this.idTypeAppList;
/*      */     }
/* 1556 */     String sql = "select code,codename From ledcode where codetype='idtype' and code in ('A','B','C','I') order by code";
/* 1557 */     ExeSQL tExeSQL = new ExeSQL();
/* 1558 */     SSRS tSSRS = new SSRS();
/* 1559 */     tSSRS = tExeSQL.execSQL(sql);
/* 1560 */     for (int i = 1; i <= tSSRS.getMaxRow(); i++)
/*      */     {
/* 1562 */       this.idTypeAppList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));
/*      */     }
/* 1564 */     return this.idTypeAppList;
/*      */   }
/*      */ 
/*      */   public void setIdTypeList2(List<SelectItem> idTypeList2)
/*      */   {
/* 1570 */     this.idTypeList2 = idTypeList2;
/*      */   }
/*      */   public List<SelectItem> getIdTypeList2() {
/* 1573 */     if ((this.idTypeList2 != null) && (this.idTypeList2.size() > 0)) {
/* 1574 */       return this.idTypeList2;
/*      */     }
/* 1576 */     String sql = "select code,codename From ledcode where codetype='idtype' and code in ('A','B','C','M','Q') order by code";
/* 1577 */     ExeSQL tExeSQL = new ExeSQL();
/* 1578 */     SSRS tSSRS = new SSRS();
/* 1579 */     tSSRS = tExeSQL.execSQL(sql);
/* 1580 */     for (int i = 1; i <= tSSRS.getMaxRow(); i++)
/*      */     {
/* 1582 */       this.idTypeList2.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));
/*      */     }
/* 1584 */     return this.idTypeList2;
/*      */   }
/*      */ 
/*      */   public void setInsuredIdTypeList(List<SelectItem> insuredIdTypeList)
/*      */   {
/* 1590 */     this.insuredIdTypeList = insuredIdTypeList;
/*      */   }
/*      */   public List<SelectItem> getInsuredIdTypeList() {
/* 1593 */     if ((this.insuredIdTypeList != null) && (this.insuredIdTypeList.size() > 0)) {
/* 1594 */       return this.insuredIdTypeList;
/*      */     }
/* 1596 */     String sql = "select code,codename From ledcode where codetype='idtype' and code in ('A','B','Q') order by code";
/* 1597 */     ExeSQL tExeSQL = new ExeSQL();
/* 1598 */     SSRS tSSRS = new SSRS();
/* 1599 */     tSSRS = tExeSQL.execSQL(sql);
/* 1600 */     for (int i = 1; i <= tSSRS.getMaxRow(); i++)
/*      */     {
/* 1602 */       this.insuredIdTypeList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));
/*      */     }
/* 1604 */     return this.insuredIdTypeList;
/*      */   }
/*      */ 
/*      */   public void setComProvinceList(List<SelectItem> comProvinceList)
/*      */   {
/* 1614 */     this.comProvinceList = comProvinceList;
/*      */   }
/*      */   public List<SelectItem> getComProvinceList() {
/* 1617 */     if ((this.comProvinceList != null) && (this.comProvinceList.size() > 0)) {
/* 1618 */       return this.comProvinceList;
/*      */     }
/* 1620 */     String sql = "select distinct Province,(select codename from ledcode where codetype='provience' and code=a.Province) From ledcom a order by Province";
/* 1621 */     ExeSQL tExeSQL = new ExeSQL();
/* 1622 */     SSRS tSSRS = new SSRS();
/* 1623 */     tSSRS = tExeSQL.execSQL(sql);
/* 1624 */     for (int i = 1; i <= tSSRS.getMaxRow(); i++)
/*      */     {
/* 1626 */       this.comProvinceList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));
/*      */     }
/* 1628 */     return this.comProvinceList;
/*      */   }
/*      */ 
/*      */   public void setComCityList(List<SelectItem> comCityList) {
/* 1632 */     this.comCityList = comCityList;
/*      */   }
/*      */   public List<SelectItem> getComCityList() {
/* 1635 */     if ((this.currentProvince == null) || ("".equals(this.currentProvince))) {
/* 1636 */       this.comCityList = new ArrayList();
/* 1637 */       return this.comCityList;
/*      */     }
/* 1639 */     if ((this.oldProvince != null) && (!"".equals(this.oldProvince)))
/*      */     {
/* 1641 */       if (this.oldProvince.equals(this.currentProvince))
/*      */       {
/* 1643 */         return this.comCityList;
/*      */       }
/*      */     }
/* 1646 */     this.comCityList = new ArrayList();
/* 1647 */     String sql = "select distinct City,(select codename from ledcode where codetype='city' and code=a.city) From ledcom a where province = '" + this.currentProvince + "' order by City";
/* 1648 */     ExeSQL tExeSQL = new ExeSQL();
/* 1649 */     SSRS tSSRS = new SSRS();
/* 1650 */     tSSRS = tExeSQL.execSQL(sql);
/* 1651 */     for (int i = 1; i <= tSSRS.getMaxRow(); i++)
/*      */     {
/* 1653 */       this.comCityList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));
/*      */     }
/* 1655 */     setOldProvince(this.currentProvince);
/* 1656 */     return this.comCityList;
/*      */   }
/*      */ 
/*      */   public void setProvienceID(String provienceID)
/*      */   {
/* 1661 */     this.provienceID = provienceID;
/* 1662 */     setCurrentProvince(this.provienceID);
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getInsureMoneyMap()
/*      */   {
/* 1667 */     if ((this.insureMoneyMap != null) && (this.insureMoneyMap.size() > 0))
/*      */     {
/* 1669 */       return this.insureMoneyMap;
/*      */     }
/* 1671 */     this.insureMoneyMap = createCodeItem("AmntLimit", "R");
/* 1672 */     return this.insureMoneyMap;
/*      */   }
/*      */ 
/*      */   public void setInsureMoneyMap(List<SelectItem> insureMoneyMap)
/*      */   {
/* 1677 */     this.insureMoneyMap = insureMoneyMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getPayFrequencyMap()
/*      */   {
/* 1682 */     if ((this.payFrequencyMap != null) && (this.payFrequencyMap.size() > 0))
/*      */     {
/* 1684 */       return this.payFrequencyMap;
/*      */     }
/* 1686 */     this.payFrequencyMap = createCodeItem("PayIntv", "R");
/* 1687 */     return this.payFrequencyMap;
/*      */   }
/*      */ 
/*      */   public void setPayFrequencyMap(List<SelectItem> payFrequencyMap)
/*      */   {
/* 1692 */     this.payFrequencyMap = payFrequencyMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getGetTypeMap()
/*      */   {
/* 1697 */     if ((this.getTypeMap != null) && (this.getTypeMap.size() > 0))
/*      */     {
/* 1699 */       return this.getTypeMap;
/*      */     }
/* 1701 */     this.getTypeMap = createCodeItem("GetMode", "R");
/* 1702 */     return this.getTypeMap;
/*      */   }
/*      */ 
/*      */   public void setGetTypeMap(List<SelectItem> getTypeMap)
/*      */   {
/* 1707 */     this.getTypeMap = getTypeMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getPolTermMap()
/*      */   {
/* 1712 */     if ((this.polTermMap != null) && (this.polTermMap.size() > 0))
/*      */     {
/* 1714 */       return this.polTermMap;
/*      */     }
/* 1716 */     this.polTermMap = createCodeItem("PolTerm", "R");
/* 1717 */     return this.polTermMap;
/*      */   }
/*      */ 
/*      */   public void setPolTermMap(List<SelectItem> polTermMap)
/*      */   {
/* 1722 */     this.polTermMap = polTermMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getUserStateMapR()
/*      */   {
/* 1753 */     if ((this.userStateMapR != null) && (this.userStateMapR.size() > 0))
/*      */     {
/* 1755 */       return this.userStateMapR;
/*      */     }
/* 1757 */     this.userStateMapR = createCodeItem("UserState", "R");
/* 1758 */     return this.userStateMapR;
/*      */   }
/*      */ 
/*      */   public String getOldWorkType() {
/* 1762 */     return this.oldWorkType;
/*      */   }
/*      */ 
/*      */   public void setOldWorkType(String oldWorkType) {
/* 1766 */     this.oldWorkType = oldWorkType;
/*      */   }
/*      */ 
/*      */   public String getCurrentWorkType() {
/* 1770 */     return this.currentWorkType;
/*      */   }
/*      */ 
/*      */   public void setCurrentWorkType(String currentWorkType) {
/* 1774 */     this.currentWorkType = currentWorkType;
/*      */   }
/*      */ 
/*      */   public String getCurrentInsuredWorkType() {
/* 1778 */     return this.currentInsuredWorkType;
/*      */   }
/*      */ 
/*      */   public void setCurrentInsuredWorkType(String currentInsuredWorkType) {
/* 1782 */     this.currentInsuredWorkType = currentInsuredWorkType;
/*      */   }
/*      */ 
/*      */   public String getOldInsuredWorkType() {
/* 1786 */     return this.oldInsuredWorkType;
/*      */   }
/*      */ 
/*      */   public void setOldInsuredWorkType(String oldInsuredWorkType) {
/* 1790 */     this.oldInsuredWorkType = oldInsuredWorkType;
/*      */   }
/*      */ 
/*      */   public String getRiskCode() {
/* 1794 */     return this.riskCode;
/*      */   }
/*      */ 
/*      */   public void setRiskCode(String riskCode) {
/* 1798 */     this.riskCode = riskCode;
/*      */   }
/*      */ 
/*      */   public String getComCode() {
/* 1802 */     return this.comCode;
/*      */   }
/*      */ 
/*      */   public void setComCode(String comCode) {
/* 1806 */     this.comCode = comCode;
/*      */   }
/*      */ 
/*      */   public String getPhoneAreaCode() {
/* 1810 */     return this.phoneAreaCode;
/*      */   }
/*      */ 
/*      */   public void setPhoneAreaCode(String phoneAreaCode) {
/* 1814 */     this.phoneAreaCode = phoneAreaCode;
/*      */   }
/*      */ 
/*      */   public void setBranchAttrList(List<SelectItem> branchAttrList)
/*      */   {
/* 1819 */     this.branchAttrList = branchAttrList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getPolicyStateMap()
/*      */   {
/* 1825 */     if ((this.policyStateMap != null) && (this.policyStateMap.size() > 0))
/*      */     {
/* 1827 */       return this.policyStateMap;
/*      */     }
/* 1829 */     this.policyStateMap = createCodeItem("polstate", "L");
/* 1830 */     return this.policyStateMap;
/*      */   }
/*      */ 
/*      */   public void setPolicyStateMap(List<SelectItem> policyStateMap)
/*      */   {
/* 1837 */     this.policyStateMap = policyStateMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getCalTypeMap()
/*      */   {
/* 1843 */     if ((this.calTypeMap != null) && (this.calTypeMap.size() > 0))
/*      */     {
/* 1845 */       return this.calTypeMap;
/*      */     }
/*      */ 
/* 1848 */     this.calTypeMap.clear();
/* 1849 */     ExeSQL tExeSQL = new ExeSQL();
/* 1850 */     SSRS tSSRS = new SSRS();
/* 1851 */     String sql = "select code,codename  from mcode where codetype='caltype'  order by code";
/* 1852 */     tSSRS = tExeSQL.execSQL(sql);
/* 1853 */     for (int i = 1; i <= tSSRS.getMaxRow(); i++) {
/* 1854 */       this.calTypeMap.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 1) + "--" + tSSRS.GetText(i, 2)));
/*      */     }
/*      */ 
/* 1857 */     return this.calTypeMap;
/*      */   }
/*      */ 
/*      */   public void setCalTypeMap(List<SelectItem> calTypeMap)
/*      */   {
/* 1863 */     this.calTypeMap = calTypeMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getPersionTypeMap()
/*      */   {
/* 1871 */     if ((this.persionTypeMap != null) && (this.persionTypeMap.size() > 0))
/*      */     {
/* 1873 */       return this.persionTypeMap;
/*      */     }
/* 1875 */     this.persionTypeMap = createCodeItem("persionType", "L");
/* 1876 */     return this.persionTypeMap;
/*      */   }
/*      */ 
/*      */   public void setPersionTypeMap(List<SelectItem> persionTypeMap)
/*      */   {
/* 1882 */     this.persionTypeMap = persionTypeMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getPersionTypelist()
/*      */   {
/* 1890 */     if ((this.persionTypelist != null) && (this.persionTypelist.size() > 0)) {
/* 1891 */       return this.persionTypelist;
/*      */     }
/* 1893 */     this.persionTypelist.clear();
/* 1894 */     ExeSQL tExeSQL = new ExeSQL();
/* 1895 */     SSRS tSSRS = new SSRS();
/* 1896 */     String sql = "select code,codename  from mcode where codetype='persionType'  order by code";
/* 1897 */     tSSRS = tExeSQL.execSQL(sql);
/* 1898 */     for (int i = 1; i <= tSSRS.getMaxRow(); i++) {
/* 1899 */       this.persionTypelist.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 1) + "--" + tSSRS.GetText(i, 2)));
/*      */     }
/*      */ 
/* 1902 */     return this.persionTypelist;
/*      */   }
/*      */ 
/*      */   public void setPersionTypelist(List<SelectItem> persionTypelist)
/*      */   {
/* 1908 */     this.persionTypelist = persionTypelist;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getCustomerTypeMap()
/*      */   {
/* 1914 */     if ((this.customerTypeMap != null) && (this.customerTypeMap.size() > 0))
/*      */     {
/* 1916 */       return this.customerTypeMap;
/*      */     }
/* 1918 */     this.customerTypeMap = createCodeItem("customerType", "L");
/* 1919 */     return this.customerTypeMap;
/*      */   }
/*      */ 
/*      */   public void setCustomerTypeMap(List<SelectItem> customerTypeMap)
/*      */   {
/* 1926 */     this.customerTypeMap = customerTypeMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getSexMap()
/*      */   {
/* 1932 */     if ((this.sexMap != null) && (this.sexMap.size() > 0))
/*      */     {
/* 1934 */       return this.sexMap;
/*      */     }
/* 1936 */     this.sexMap = createCodeItem("sex", "L");
/* 1937 */     return this.sexMap;
/*      */   }
/*      */ 
/*      */   public void setSexMap(List<SelectItem> sexMap)
/*      */   {
/* 1944 */     this.sexMap = sexMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getDeGreeMap()
/*      */   {
/* 1950 */     if ((this.deGreeMap != null) && (this.deGreeMap.size() > 0))
/*      */     {
/* 1952 */       return this.deGreeMap;
/*      */     }
/* 1954 */     this.deGreeMap = createCodeItem("degree", "L");
/* 1955 */     return this.deGreeMap;
/*      */   }
/*      */ 
/*      */   public void setDeGreeMap(List<SelectItem> deGreeMap)
/*      */   {
/* 1961 */     this.deGreeMap = deGreeMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getIdTypeMap()
/*      */   {
/* 1967 */     if ((this.idTypeMap != null) && (this.idTypeMap.size() > 0))
/*      */     {
/* 1969 */       return this.idTypeMap;
/*      */     }
/* 1971 */     this.idTypeMap = createCodeItem("customeridtype", "L");
/* 1972 */     return this.idTypeMap;
/*      */   }
/*      */ 
/*      */   public void setIdTypeMap(List<SelectItem> idTypeMap)
/*      */   {
/* 1980 */     this.idTypeMap = idTypeMap;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getMaintainProjectType()
/*      */   {
/* 1985 */     if ((this.maintainProjectType != null) && (this.maintainProjectType.size() > 0)) {
/* 1986 */       return this.maintainProjectType;
/*      */     }
/* 1988 */     this.maintainProjectType.clear();
/* 1989 */     ExeSQL tExeSQL = new ExeSQL();
/* 1990 */     SSRS tSSRS = new SSRS();
/* 1991 */     String sql = "select code,codename  from mcode where codetype='maintainProject'  order by codeorder";
/* 1992 */     tSSRS = tExeSQL.execSQL(sql);
/* 1993 */     for (int i = 1; i <= tSSRS.getMaxRow(); i++) {
/* 1994 */       this.maintainProjectType.add(new SelectItem(tSSRS.GetText(i, 2), tSSRS.GetText(i, 2)));
/*      */     }
/* 1996 */     return this.maintainProjectType;
/*      */   }
/*      */ 
/*      */   public void setMaintainProjectType(List<SelectItem> maintainProjectType)
/*      */   {
/* 2002 */     this.maintainProjectType = maintainProjectType;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getYesnoList()
/*      */   {
/* 2007 */     if ((this.yesnoList != null) && (this.yesnoList.size() > 0)) {
/* 2008 */       return this.yesnoList;
/*      */     }
/* 2010 */     this.yesnoList.clear();
/* 2011 */     ExeSQL tExeSQL = new ExeSQL();
/* 2012 */     SSRS tSSRS = new SSRS();
/* 2013 */     String sql = "select code,codename  from mcode where codetype='yesno'  order by codeorder";
/* 2014 */     tSSRS = tExeSQL.execSQL(sql);
/* 2015 */     for (int i = 1; i <= tSSRS.getMaxRow(); i++) {
/* 2016 */       this.yesnoList.add(new SelectItem(tSSRS.GetText(i, 2), tSSRS.GetText(i, 2)));
/*      */     }
/* 2018 */     return this.yesnoList;
/*      */   }
/*      */ 
/*      */   public void setYesnoList(List<SelectItem> yesnoList)
/*      */   {
/* 2023 */     this.yesnoList = yesnoList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getAgentgroupList()
/*      */   {
/* 2028 */     if ((this.agentgroupList != null) && (this.agentgroupList.size() > 0)) {
/* 2029 */       return this.agentgroupList;
/*      */     }
/* 2031 */     this.agentgroupList.clear();
/* 2032 */     ExeSQL tExeSQL = new ExeSQL();
/* 2033 */     SSRS tSSRS = new SSRS();
/* 2034 */     String sql = "select comcode , shortname from mcom";
/* 2035 */     tSSRS = tExeSQL.execSQL(sql);
/* 2036 */     for (int i = 1; i <= tSSRS.getMaxRow(); i++) {
/* 2037 */       this.agentgroupList.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 1) + "--" + tSSRS.GetText(i, 2)));
/*      */     }
/*      */ 
/* 2041 */     return this.agentgroupList;
/*      */   }
/*      */ 
/*      */   public void setAgentgroupList(List<SelectItem> agentgroupList)
/*      */   {
/* 2046 */     this.agentgroupList = agentgroupList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getChangeCodeMap() {
/* 2050 */     if ((this.changeCodeMap != null) && (this.changeCodeMap.size() > 0))
/*      */     {
/* 2052 */       return this.changeCodeMap;
/*      */     }
/* 2054 */     this.changeCodeMap = createCodeItem("ChangeCode", "L");
/* 2055 */     return this.changeCodeMap;
/*      */   }
/*      */ 
/*      */   public void setChangeCodeMap(List<SelectItem> changeCodeMap)
/*      */   {
/* 2060 */     this.changeCodeMap = changeCodeMap;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.pubfun.MCodeList
 * JD-Core Version:    0.6.0
 */