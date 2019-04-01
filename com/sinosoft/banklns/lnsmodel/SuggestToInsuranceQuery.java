/*      */ package com.sinosoft.banklns.lnsmodel;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPContDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.FDate;
/*      */ import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
/*      */ import com.sinosoft.banklns.lis.pubfun.LNPPubFun;
/*      */ import com.sinosoft.banklns.lis.pubfun.MMap;
/*      */ import com.sinosoft.banklns.lis.pubfun.PubSubmit;
/*      */ import com.sinosoft.banklns.lis.pubfun.SysMaxNoMAPNP;
/*      */ import com.sinosoft.banklns.lis.pubfun.ValidateTools;
/*      */ import com.sinosoft.banklns.lis.schema.LNPAddressSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPAppntSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPInsuredSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPPersonSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPPolSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPPolSet;
/*      */ import com.sinosoft.banklns.lnsmodel.entity.LNPSuggestToInsuranceBean;
/*      */ import com.sinosoft.banklns.utility.ExeSQL;
/*      */ import com.sinosoft.banklns.utility.SSRS;
/*      */ import com.sinosoft.banklns.utility.VData;
/*      */ import com.sinosoft.map.lis.pubfun.PubFun;
/*      */ import java.io.PrintStream;
/*      */ import java.text.DecimalFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.List;
/*      */ import java.util.regex.Pattern;
/*      */ import javax.faces.context.ExternalContext;
/*      */ import javax.faces.context.FacesContext;
/*      */ import javax.faces.model.SelectItem;
/*      */ import javax.servlet.http.HttpSession;
/*      */ 
/*      */ public class SuggestToInsuranceQuery
/*      */ {
/*   37 */   private String message = "";
/*      */ 
/*   39 */   private boolean alertFlag = false;
/*      */ 
/*   44 */   private LNPSuggestToInsuranceBean stiBean = new LNPSuggestToInsuranceBean();
/*      */ 
/*   47 */   private List<LNPSuggestToInsuranceBean> stiBeanList = null;
/*      */ 
/*   50 */   private String startDate = null;
/*      */ 
/*   53 */   private String endDate = null;
/*      */ 
/*   55 */   private IGlobalInput tempGI = null;
/*      */ 
/*   58 */   private boolean showErrorFlag = false;
/*      */ 
/*   60 */   List<SelectItem> comCodeList = new ArrayList();
/*      */ 
/*   66 */   private String contNo = "";
/*      */ 
/*   68 */   private String checkedContNo = "";
/*      */ 
/*   71 */   private String sugNo = "";
/*      */ 
/*   73 */   private String sugInsuredNo = "";
/*      */ 
/*   75 */   private String sugAppntNo = "";
/*      */ 
/*   77 */   private String sugManageCom = "";
/*      */ 
/*   79 */   private String checkRiskcode = "";
/*      */ 
/* 1114 */   private boolean checkRiskFlag = false;
/*      */ 
/*      */   public String getCheckRiskcode()
/*      */   {
/*   83 */     return this.checkRiskcode;
/*      */   }
/*      */ 
/*      */   public void setCheckRiskcode(String checkRiskcode) {
/*   87 */     this.checkRiskcode = checkRiskcode;
/*      */   }
/*      */ 
/*      */   public void initData()
/*      */   {
/*   93 */     System.out.println("--- SuggestToInsuranceQuery initData ---");
/*   94 */     if (this.stiBeanList != null)
/*   95 */       this.stiBeanList.clear();
/*      */     else {
/*   97 */       this.stiBeanList = new ArrayList();
/*      */     }
/*   99 */     HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*  100 */     this.tempGI = ((IGlobalInput)session.getValue("NPGI"));
/*  101 */     if (this.tempGI == null) {
/*  102 */       this.message = "\uFFFD\uFFFD\u00BC\uFFFD\uFFFD\u0531\uFFFD\uFFFD\u03E2\uFFFD\uFFFD\u02A7\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u00B5\uFFFD\u00BD\uFFFD\uFFFD";
/*  103 */       this.alertFlag = true;
/*  104 */       return;
/*      */     }
/*  106 */     if ((this.tempGI.OperType == null) || (this.tempGI.OperType.equals(""))) {
/*  107 */       this.message = "\uFFFD\uFFFD\u01F0\uFFFD\uFFFD\u00BD\uFFFD\uFFFD\u0531\u00FB\uFFFD\u043D\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u046F\u0228\uFFFD\u07A3\uFFFD";
/*  108 */       this.alertFlag = true;
/*  109 */       return;
/*      */     }
/*      */   }
/*      */ 
/*      */   public void querySuggestInfo()
/*      */   {
/*  118 */     System.out.println("--- SuggestToInsuranceQuery querySuggestInfo Start ---");
/*  119 */     this.alertFlag = false;
/*  120 */     this.showErrorFlag = false;
/*  121 */     this.stiBeanList = new ArrayList();
/*      */     try
/*      */     {
/*  124 */       if (this.tempGI == null) {
/*  125 */         this.message = "\uFFFD\u00F5\uFFFD\u00BC\uFFFD\uFFFD\u0531\u00FB\uFFFD\u043D\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u046F\u0228\uFFFD\u07A3\uFFFD";
/*  126 */         this.alertFlag = true;
/*  127 */         return;
/*      */       }
/*  129 */       if (!validateQueryInfo()) {
/*  130 */         this.alertFlag = true;
/*  131 */         return;
/*      */       }
/*      */ 
/*  134 */       String sql = "select distinct s.contno,s.insuredno,s.appntno,s.makedate,s.managecom,s.i_name,s.i_birthday,s.i_idno,s.maketime  from ( select top 200 c.contno,c.insuredno,c.appntno,c.makedate,c.maketime,c.managecom,i.name i_name,i.birthday i_birthday,i.idno i_idno   from lscont c ,lsinsured i where  i.contno=c.contno and c.contno is not null  ";
/*      */ 
/*  141 */       sql = sql + "and c.managecom like '" + this.tempGI.ManageCom + "%' ";
/*  142 */       if ("1".equals(this.tempGI.OperType))
/*      */       {
/*  144 */         sql = sql + " and c.operator='" + this.tempGI.Operator + "' ";
/*      */       }
/*  146 */       String chanleSign = getOutcode("branchtype", "lnp", this.tempGI.chanlesign);
/*  147 */       if ((chanleSign != null) && (!"".equals(chanleSign))) {
/*  148 */         sql = sql + " and c.salechnl = '" + chanleSign + "' ";
/*      */       }
/*  150 */       sql = sql + " order by c.makedate desc,c.maketime desc ";
/*  151 */       sql = sql + " ) s  ";
/*  152 */       sql = sql + "where 1=1 ";
/*  153 */       sql = sql + appendSql();
/*  154 */       sql = sql + " order by s.makedate desc,s.maketime desc";
/*  155 */       System.out.println("QuerySuggestInfo SQL_c : " + sql);
/*  156 */       ExeSQL tExeSql = new ExeSQL();
/*  157 */       SSRS ssrs = tExeSql.execSQL(sql);
/*  158 */       if ((ssrs != null) && (ssrs.MaxRow > 0)) {
/*  159 */         System.out.println("QuerySuggestInfo size : " + ssrs.MaxRow);
/*  160 */         if (ssrs.MaxRow >= 200)
/*      */         {
/*  162 */           this.showErrorFlag = true;
/*      */         }
/*  164 */         this.stiBeanList = new ArrayList();
/*  165 */         for (int i = 1; i <= ssrs.MaxRow; i++)
/*      */         {
/*  167 */           LNPSuggestToInsuranceBean temp = new LNPSuggestToInsuranceBean();
/*  168 */           String SugNO = "";
/*  169 */           if ((ssrs.GetText(i, 1) != null) && (!"".equals(ssrs.GetText(i, 1)))) {
/*  170 */             SugNO = ssrs.GetText(i, 1);
/*      */           }
/*  172 */           temp.setSugNo(SugNO);
/*  173 */           temp.setRiskCode(getRiskString(SugNO));
/*  174 */           if ((ssrs.GetText(i, 2) != null) && (!"".equals(ssrs.GetText(i, 2)))) {
/*  175 */             temp.setSugInsuredNo(ssrs.GetText(i, 2));
/*      */           }
/*  177 */           if ((ssrs.GetText(i, 3) != null) && (!"".equals(ssrs.GetText(i, 3)))) {
/*  178 */             temp.setSugAppntNo(ssrs.GetText(i, 3));
/*      */           }
/*  180 */           if ((ssrs.GetText(i, 4) != null) && (!"".equals(ssrs.GetText(i, 4)))) {
/*  181 */             temp.setMakeDate(ssrs.GetText(i, 4).substring(0, 10));
/*      */           }
/*  183 */           if ((ssrs.GetText(i, 5) != null) && (!"".equals(ssrs.GetText(i, 5)))) {
/*  184 */             temp.setManageCom(ssrs.GetText(i, 5));
/*      */           }
/*  186 */           if ((ssrs.GetText(i, 6) != null) && (!"".equals(ssrs.GetText(i, 6)))) {
/*  187 */             temp.setInsuredName(ssrs.GetText(i, 6));
/*      */           }
/*  189 */           if ((ssrs.GetText(i, 7) != null) && (!"".equals(ssrs.GetText(i, 7)))) {
/*  190 */             temp.setInsuredBirthday(ssrs.GetText(i, 7).substring(0, 10));
/*      */           }
/*  192 */           if ((ssrs.GetText(i, 8) != null) && (!"".equals(ssrs.GetText(i, 8)))) {
/*  193 */             temp.setInsuredIDNo(ssrs.GetText(i, 8));
/*      */           }
/*  195 */           String sql_p = "select sum(p.prem) from lspol p where p.contno='" + 
/*  196 */             SugNO + "' ";
/*      */ 
/*  199 */           DecimalFormat formatMoney = new DecimalFormat("#,##0.00");
/*      */ 
/*  201 */           ExeSQL tExeSql_p = new ExeSQL();
/*  202 */           SSRS ssrs_p = tExeSql_p.execSQL(sql_p);
/*  203 */           String prem = "";
/*  204 */           if ((ssrs_p != null) && (ssrs_p.MaxRow > 0) && 
/*  205 */             (ssrs_p.GetText(1, 1) != null) && 
/*  206 */             (!"".equals(ssrs_p.GetText(1, 1))) && 
/*  207 */             (!"NULL".equals(ssrs_p.GetText(1, 1).toUpperCase()))) {
/*  208 */             String temoprem = ssrs_p.GetText(1, 1);
/*  209 */             prem = formatMoney.format(Double.parseDouble(temoprem)) + " \u052A";
/*      */           }
/*      */ 
/*  214 */           temp.setPrem(prem);
/*      */ 
/*  216 */           this.stiBeanList.add(temp);
/*      */         }
/*      */       } else {
/*  219 */         this.message = " \u00FB\uFFFD\u0437\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u013D\uFFFD\uFFFD";
/*  220 */         this.alertFlag = true;
/*  221 */         if (this.stiBeanList != null)
/*  222 */           this.stiBeanList.clear();
/*      */         else {
/*  224 */           this.stiBeanList = new ArrayList();
/*      */         }
/*  226 */         return;
/*      */       }
/*      */     } catch (Exception e) {
/*  229 */       e.printStackTrace();
/*      */ 
/*  231 */       System.out.println("--- SuggestToInsuranceQuery querySuggestInfo End ---");
/*      */     }
/*      */   }
/*      */ 
/*      */   private String appendSql() {
/*  235 */     String appSql = "";
/*  236 */     if ((this.stiBean.getInsuredName() != null) && (!"".equals(this.stiBean.getInsuredName()))) {
/*  237 */       appSql = appSql + " and s.i_name like '%" + this.stiBean.getInsuredName() + "%' ";
/*      */     }
/*  239 */     if ((this.stiBean.getInsuredIDNo() != null) && (!"".equals(this.stiBean.getInsuredIDNo()))) {
/*  240 */       appSql = appSql + " and s.i_idno = '" + this.stiBean.getInsuredIDNo() + "' ";
/*      */     }
/*  242 */     if ((getStartDate() != null) && (!"".equals(getStartDate()))) {
/*  243 */       appSql = appSql + " and s.makedate >=  '" + getStartDate() + "' ";
/*      */     }
/*  245 */     if ((getEndDate() != null) && (!"".equals(getEndDate()))) {
/*  246 */       appSql = appSql + " and s.makedate <=  '" + getEndDate() + "' ";
/*      */     }
/*  248 */     return appSql;
/*      */   }
/*      */ 
/*      */   private String getRiskString(String contno)
/*      */   {
/*  253 */     ExeSQL tExeSQL = new ExeSQL();
/*  254 */     String riskListString = "";
/*  255 */     String riskSQL1 = "select riskcode from lspol a where contno='" + contno + "' and polno=mainpolno";
/*  256 */     String riskSQL2 = "select riskcode from lspol b where contno='" + contno + "' " + 
/*  257 */       "and polno<>mainpolno order by modifydate ,modifytime";
/*  258 */     SSRS tSSRS1 = tExeSQL.execSQL(riskSQL1);
/*  259 */     SSRS tSSRS2 = tExeSQL.execSQL(riskSQL2);
/*  260 */     riskListString = "";
/*  261 */     if (tSSRS1.MaxRow > 0) {
/*  262 */       riskListString = tSSRS1.GetText(1, 1);
/*  263 */       if (tSSRS2.MaxRow > 0) {
/*  264 */         for (int j = 1; j <= tSSRS2.MaxRow; j++) {
/*  265 */           riskListString = riskListString + "," + tSSRS2.GetText(j, 1);
/*      */         }
/*      */       }
/*      */     }
/*  269 */     return riskListString;
/*      */   }
/*      */ 
/*      */   private String getDoubleStr(String value)
/*      */   {
/*  274 */     if (value == null) {
/*  275 */       return null;
/*      */     }
/*  277 */     String result = "";
/*  278 */     int ch = 0;
/*  279 */     ch = value.lastIndexOf(".");
/*  280 */     if (-1 == ch) {
/*  281 */       result = value;
/*      */     } else {
/*  283 */       String dotper = value.substring(0, ch);
/*  284 */       String dotAft = value.substring(ch, value.length());
/*  285 */       dotAft = dotAft.length() > 3 ? dotAft.substring(0, 3) : dotAft;
/*  286 */       result = dotper + dotAft;
/*      */     }
/*  288 */     return result;
/*      */   }
/*      */ 
/*      */   private String getAgeByBirthday(String strBirthday, String strApplyDay)
/*      */   {
/*  293 */     String returnAge = "-1";
/*  294 */     String[] arrBirthday = strBirthday.split("-");
/*  295 */     String[] arrApplyday = strApplyDay.split("-");
/*      */ 
/*  297 */     int age = Integer.parseInt(arrApplyday[0]) - 
/*  298 */       Integer.parseInt(arrBirthday[0]) - 1;
/*      */ 
/*  300 */     if (Integer.parseInt(arrApplyday[1]) > Integer.parseInt(arrBirthday[1]))
/*  301 */       age++;
/*  302 */     else if (Integer.parseInt(arrApplyday[1]) >= Integer.parseInt(arrBirthday[1]))
/*      */     {
/*  304 */       if (Integer.parseInt(arrApplyday[2]) >= Integer.parseInt(arrBirthday[2]))
/*      */       {
/*  306 */         age++;
/*      */       }
/*      */     }
/*  309 */     if (age >= 0) {
/*  310 */       if (age == 0)
/*  311 */         returnAge = age;
/*      */       else {
/*  313 */         returnAge = age;
/*      */       }
/*      */     }
/*  316 */     return returnAge.trim();
/*      */   }
/*      */ 
/*      */   private boolean validateQueryInfo() {
/*  320 */     if ((this.stiBean.getInsuredIDNo() != null) && (!"".equals(this.stiBean.getInsuredIDNo())) && 
/*  321 */       (!ValidateTools.isValidString2(this.stiBean.getInsuredIDNo()))) {
/*  322 */       this.message = " \uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u05A4\uFFFD\uFFFD\uFFFD\u0178\uFFFD\u02BD\uFFFD\uFFFD\uFFFD\uFFFD\u0237\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0434\uFFFD\uFFFD";
/*  323 */       return false;
/*      */     }
/*      */ 
/*  326 */     return true;
/*      */   }
/*      */ 
/*      */   public void initSuggestToInsurance()
/*      */   {
/*  341 */     this.contNo = "";
/*  342 */     this.alertFlag = false;
/*  343 */     this.sugNo = getSugNo();
/*  344 */     System.out.println("bean sugNo : " + this.sugNo);
/*  345 */     String magCode = "";
/*  346 */     ExeSQL tExeSql = new ExeSQL();
/*  347 */     String preSql = "select distinct managecom from lscont where contno = '" + this.sugNo + "' ";
/*  348 */     SSRS tSSRSfromCom = tExeSql.execSQL(preSql);
/*  349 */     if ((tSSRSfromCom != null) && (tSSRSfromCom.MaxRow > 0)) {
/*  350 */       magCode = tSSRSfromCom.GetText(1, 1);
/*      */     }
/*  352 */     setSugManageCom(magCode);
/*      */   }
/*      */ 
/*      */   public void doSuggestToInsurance()
/*      */   {
/*  359 */     System.out.println("---doSuggestToInsurance Start---");
/*      */ 
/*  361 */     this.alertFlag = false;
/*  362 */     MMap map = new MMap();
/*  363 */     VData vd = new VData();
/*  364 */     PubSubmit ps = new PubSubmit();
/*  365 */     ExeSQL tExeSQL = new ExeSQL();
/*  366 */     HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*  367 */     IGlobalInput tempGI = (IGlobalInput)session.getValue("NPGI");
/*  368 */     LNPContSchema lnpContSchema = new LNPContSchema();
/*  369 */     LNPInsuredSchema lnpInsuredSchema = new LNPInsuredSchema();
/*  370 */     LNPPersonSchema lnpInsPersonSchema = new LNPPersonSchema();
/*  371 */     LNPAddressSchema lnpInsAddressSchema = new LNPAddressSchema();
/*  372 */     LNPAppntSchema lnpAppntSchema = new LNPAppntSchema();
/*  373 */     LNPPersonSchema lnpAppPersonSchema = new LNPPersonSchema();
/*  374 */     LNPAddressSchema lnpAppAddressSchema = new LNPAddressSchema();
/*  375 */     LNPPolSet lnpPolSet = new LNPPolSet();
/*  376 */     SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
/*  377 */     String date = PubFun.getCurrentDate();
/*  378 */     String time = PubFun.getCurrentTime();
/*      */ 
/*  380 */     if (!preDOValidateVar()) {
/*  381 */       return;
/*      */     }
/*  383 */     this.sugInsuredNo = getSugInsuredNoFromDB(this.sugNo);
/*  384 */     this.sugAppntNo = getSugAppntNoFromDB(this.sugNo);
/*      */ 
/*  386 */     if (tempGI == null) {
/*  387 */       this.alertFlag = true;
/*  388 */       this.message = " \u0376\uFFFD\uFFFD\uFFFD\uFFFD\u0171\uFFFD\uFFFD\uFFFD\u02A7\uFFFD\u0723\uFFFD";
/*  389 */       return;
/*      */     }
/*  391 */     System.out.println("bean do sugNo : " + this.sugNo);
/*  392 */     System.out.println("bean do sugInsuredNo : " + this.sugInsuredNo);
/*  393 */     System.out.println("bean do sugAppntNo : " + this.sugAppntNo);
/*      */ 
/*  396 */     System.out.println("1. \uFFFD\u0439\u063B\uFFFD\uFFFD\uFFFD\u03E2");
/*  397 */     lnpContSchema.setContNo(this.contNo);
/*  398 */     lnpContSchema.setProposalContNo(lnpContSchema.getContNo());
/*  399 */     lnpContSchema.setGrpContNo(LNPPubFun.getSysInfo("grpcontno"));
/*  400 */     lnpContSchema.setPrtNo(LNPPubFun.getSysInfo("prtno"));
/*  401 */     lnpContSchema.setSugNo(this.sugNo);
/*  402 */     lnpContSchema.setContType("1");
/*  403 */     lnpContSchema.setPolType("1");
/*  404 */     lnpContSchema.setCardFlag("0");
/*  405 */     lnpContSchema.setState("01");
/*  406 */     lnpContSchema.setProposalType("1");
/*  407 */     lnpContSchema.setEditstate("1000000000");
/*  408 */     lnpContSchema.setOperator(tempGI.Operator);
/*  409 */     lnpContSchema.setManageCom(getManageCom(this.contNo));
/*  410 */     lnpContSchema.setSaleChnlDetail(tempGI.chanlesign);
/*  411 */     if ("1".equals(tempGI.OperType))
/*  412 */       lnpContSchema.setLang("0");
/*      */     else {
/*  414 */       lnpContSchema.setLang("1");
/*      */     }
/*      */ 
/*  417 */     lnpContSchema.setApproveFlag("0");
/*  418 */     lnpContSchema.setUWFlag("0");
/*  419 */     lnpContSchema.setUWTime("0");
/*  420 */     lnpContSchema.setModifyDate(date);
/*  421 */     lnpContSchema.setModifyTime(time);
/*  422 */     lnpContSchema.setMakeDate(date);
/*  423 */     lnpContSchema.setMakeTime(time);
/*  424 */     lnpContSchema.setPSignDate(date);
/*  425 */     lnpContSchema.setPValiDate(countPValidate(date));
/*      */ 
/*  428 */     System.out.println("2.\uFFFD\u0439\u0631\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03E2");
/*      */ 
/*  430 */     lnpInsuredSchema.setGrpContNo(lnpContSchema.getGrpContNo());
/*  431 */     lnpInsuredSchema.setContNo(this.contNo);
/*  432 */     lnpInsuredSchema.setProposalContNo(this.contNo);
/*  433 */     lnpInsuredSchema.setPrtNo(lnpContSchema.getPrtNo());
/*  434 */     lnpInsuredSchema.setInsuredId(maxNoMap.CreateMaxNo("CustomerNo", ""));
/*  435 */     lnpInsuredSchema.setOperator(tempGI.Operator);
/*  436 */     lnpInsuredSchema.setModifyDate(date);
/*  437 */     lnpInsuredSchema.setModifyTime(time);
/*  438 */     lnpInsuredSchema.setMakeDate(date);
/*  439 */     lnpInsuredSchema.setMakeTime(time);
/*  440 */     String lsInsuredSQL = "select name,sex,birthday,occupationtype,occupationcode,nativeplace,relationtoappnt,idtype,idno,marriage,age from lsinsured where contno='" + 
/*  441 */       this.sugNo + "' ";
/*  442 */     if ((this.sugInsuredNo != null) && (!"".equals(this.sugInsuredNo))) {
/*  443 */       lsInsuredSQL = lsInsuredSQL + " and insuredno='" + this.sugInsuredNo + "' ";
/*      */     }
/*  445 */     SSRS lsInsuredSSRS = tExeSQL.execSQL(lsInsuredSQL);
/*  446 */     if ((lsInsuredSSRS != null) && (lsInsuredSSRS.MaxRow > 0)) {
/*  447 */       if ((lsInsuredSSRS.GetText(1, 1) != null) && (!"".equals(lsInsuredSSRS.GetText(1, 1)))) {
/*  448 */         lnpInsuredSchema.setName(lsInsuredSSRS.GetText(1, 1));
/*      */       }
/*  450 */       if ((lsInsuredSSRS.GetText(1, 2) != null) && (!"".equals(lsInsuredSSRS.GetText(1, 2)))) {
/*  451 */         lnpInsuredSchema.setSex(lsInsuredSSRS.GetText(1, 2));
/*      */       }
/*  453 */       if ((lsInsuredSSRS.GetText(1, 3) != null) && (!"".equals(lsInsuredSSRS.GetText(1, 3)))) {
/*  454 */         lnpInsuredSchema.setBirthday(lsInsuredSSRS.GetText(1, 3).substring(0, 10));
/*      */       }
/*      */ 
/*  459 */       if ((lsInsuredSSRS.GetText(1, 4) != null) && (!"".equals(lsInsuredSSRS.GetText(1, 4)))) {
/*  460 */         lnpInsuredSchema.setOccupationType(lsInsuredSSRS.GetText(1, 4));
/*      */       }
/*  462 */       if ((lsInsuredSSRS.GetText(1, 5) != null) && (!"".equals(lsInsuredSSRS.GetText(1, 5)))) {
/*  463 */         lnpInsuredSchema.setOccupationCode(lsInsuredSSRS.GetText(1, 5));
/*      */       }
/*  465 */       if ((lsInsuredSSRS.GetText(1, 6) != null) && (!"".equals(lsInsuredSSRS.GetText(1, 6)))) {
/*  466 */         String naticePlace = getOutcode("countryareacode", "ls", lsInsuredSSRS.GetText(1, 6));
/*  467 */         if ((naticePlace != null) && (!"".equals(naticePlace)))
/*  468 */           lnpInsuredSchema.setNativePlace(naticePlace);
/*      */         else
/*  470 */           lnpInsuredSchema.setNativePlace("0");
/*      */       }
/*      */       else {
/*  473 */         lnpInsuredSchema.setNativePlace("0");
/*      */       }
/*  475 */       if ((lsInsuredSSRS.GetText(1, 7) != null) && (!"".equals(lsInsuredSSRS.GetText(1, 7)))) {
/*  476 */         String outCode = getOutcode("relation", "ls", lsInsuredSSRS.GetText(1, 7));
/*  477 */         if ((outCode != null) && (!"".equals(outCode)))
/*  478 */           lnpInsuredSchema.setRelationToAppnt(outCode);
/*      */         else
/*  480 */           lnpInsuredSchema.setRelationToAppnt("H");
/*      */       }
/*      */       else {
/*  483 */         lnpInsuredSchema.setRelationToAppnt("H");
/*      */       }
/*  485 */       if ((lsInsuredSSRS.GetText(1, 8) != null) && (!"".equals(lsInsuredSSRS.GetText(1, 8)))) {
/*  486 */         String idType = getOutcode("idtype", "ls", lsInsuredSSRS.GetText(1, 8));
/*  487 */         if ((idType != null) && (!"".equals(idType))) {
/*  488 */           lnpInsuredSchema.setIDType(idType);
/*      */         }
/*      */       }
/*  491 */       if ((lsInsuredSSRS.GetText(1, 9) != null) && (!"".equals(lsInsuredSSRS.GetText(1, 9)))) {
/*  492 */         lnpInsuredSchema.setIDNo(lsInsuredSSRS.GetText(1, 9));
/*      */       }
/*  494 */       if ((lsInsuredSSRS.GetText(1, 10) != null) && (!"".equals(lsInsuredSSRS.GetText(1, 10)))) {
/*  495 */         String marr = getOutcode("wedlock", "ls", lsInsuredSSRS.GetText(1, 10));
/*  496 */         if ((marr != null) && (!"".equals(marr))) {
/*  497 */           lnpInsuredSchema.setMarriage(marr);
/*      */         }
/*      */       }
/*  500 */       if ((lsInsuredSSRS.GetText(1, 11) != null) && (!"".equals(lsInsuredSSRS.GetText(1, 11)))) {
/*  501 */         lnpInsuredSchema.setAppAge(lsInsuredSSRS.GetText(1, 11));
/*  502 */         lnpInsuredSchema.setAppAgeType("Y");
/*      */       }
/*      */     }
/*      */ 
/*  506 */     lnpInsPersonSchema.setAgentCode(lnpInsuredSchema.getOperator());
/*  507 */     lnpInsPersonSchema.setCustomerId(lnpInsuredSchema.getInsuredId());
/*  508 */     lnpInsPersonSchema.setName(lnpInsuredSchema.getName() != null ? lnpInsuredSchema.getName() : "");
/*  509 */     lnpInsPersonSchema.setSex(lnpInsuredSchema.getSex() != null ? lnpInsuredSchema.getSex() : "");
/*  510 */     lnpInsPersonSchema.setBirthday(lnpInsuredSchema.getBirthday() != null ? lnpInsuredSchema.getBirthday() : "");
/*  511 */     lnpInsPersonSchema.setAgeType(lnpInsuredSchema.getAppAgeType() != null ? lnpInsuredSchema.getAppAgeType() : "");
/*  512 */     lnpInsPersonSchema.setAge(-1 < lnpInsuredSchema.getAppAge() ? lnpInsuredSchema.getAppAge() : 0);
/*  513 */     lnpInsPersonSchema.setOccupationCode(lnpInsuredSchema.getOccupationCode() != null ? lnpInsuredSchema.getOccupationCode() : "");
/*  514 */     lnpInsPersonSchema.setOccupationType(lnpInsuredSchema.getOccupationType() != null ? lnpInsuredSchema.getOccupationType() : "");
/*  515 */     lnpInsPersonSchema.setIDType(lnpInsuredSchema.getIDType() != null ? lnpInsuredSchema.getIDType() : "");
/*  516 */     lnpInsPersonSchema.setIDNo(lnpInsuredSchema.getIDNo() != null ? lnpInsuredSchema.getIDNo() : "");
/*  517 */     lnpInsPersonSchema.setOperator(tempGI.Operator);
/*  518 */     lnpInsPersonSchema.setMakeDate(date);
/*  519 */     lnpInsPersonSchema.setMakeTime(time);
/*  520 */     lnpInsPersonSchema.setModifyDate(date);
/*  521 */     lnpInsPersonSchema.setModifyTime(time);
/*      */ 
/*  523 */     lnpInsAddressSchema.setCustomerId(lnpInsuredSchema.getInsuredId());
/*  524 */     lnpInsAddressSchema.setAddressNo(maxNoMap.CreateMaxNo("LNPAddRNo", ""));
/*  525 */     lnpInsAddressSchema.setOperator(tempGI.Operator);
/*  526 */     lnpInsAddressSchema.setMakeDate(date);
/*  527 */     lnpInsAddressSchema.setMakeTime(time);
/*  528 */     lnpInsAddressSchema.setModifyDate(date);
/*  529 */     lnpInsAddressSchema.setModifyTime(time);
/*  530 */     String lsInsAddressSQL = "";
/*  531 */     if ((this.sugInsuredNo != null) && (!"".equals(this.sugInsuredNo))) {
/*  532 */       lsInsAddressSQL = "select homecountyaddr,homezipcode,homephone,grpcountyaddr,grpzipcode,grpphone,email,addrchoise from lslatncycustm where customerno='" + 
/*  533 */         this.sugInsuredNo + "' ";
/*      */     }
/*  535 */     SSRS lsInsAddressSSRS = tExeSQL.execSQL(lsInsAddressSQL);
/*  536 */     if ((lsInsAddressSSRS != null) && (lsInsAddressSSRS.MaxRow > 0)) {
/*  537 */       if ((lsInsAddressSSRS.GetText(1, 1) != null) && (!"".equals(lsInsAddressSSRS.GetText(1, 1)))) {
/*  538 */         lnpInsAddressSchema.setHomeAddress(lsInsAddressSSRS.GetText(1, 1));
/*      */       }
/*  540 */       if ((lsInsAddressSSRS.GetText(1, 2) != null) && (!"".equals(lsInsAddressSSRS.GetText(1, 2)))) {
/*  541 */         lnpInsAddressSchema.setHomeZipCode(lsInsAddressSSRS.GetText(1, 2));
/*      */       }
/*  543 */       if ((lsInsAddressSSRS.GetText(1, 3) != null) && (!"".equals(lsInsAddressSSRS.GetText(1, 3)))) {
/*  544 */         lnpInsAddressSchema.setHomePhone(lsInsAddressSSRS.GetText(1, 3));
/*      */       }
/*  546 */       if ((lsInsAddressSSRS.GetText(1, 4) != null) && (!"".equals(lsInsAddressSSRS.GetText(1, 4)))) {
/*  547 */         lnpInsAddressSchema.setCompanyAddress(lsInsAddressSSRS.GetText(1, 4));
/*      */       }
/*  549 */       if ((lsInsAddressSSRS.GetText(1, 5) != null) && (!"".equals(lsInsAddressSSRS.GetText(1, 5)))) {
/*  550 */         lnpInsAddressSchema.setCompanyZipCode(lsInsAddressSSRS.GetText(1, 5));
/*      */       }
/*  552 */       if ((lsInsAddressSSRS.GetText(1, 6) != null) && (!"".equals(lsInsAddressSSRS.GetText(1, 6)))) {
/*  553 */         lnpInsAddressSchema.setCompanyPhone(lsInsAddressSSRS.GetText(1, 6));
/*      */       }
/*  555 */       if ((lsInsAddressSSRS.GetText(1, 7) != null) && (!"".equals(lsInsAddressSSRS.GetText(1, 7)))) {
/*  556 */         lnpInsAddressSchema.setCompanyMail(lsInsAddressSSRS.GetText(1, 7));
/*      */       }
/*  558 */       if ((lsInsAddressSSRS.GetText(1, 8) != null) && (!"".equals(lsInsAddressSSRS.GetText(1, 8))))
/*      */       {
/*  560 */         String addrChoise = lsInsAddressSSRS.GetText(1, 8);
/*      */ 
/*  562 */         if ("0".equals(addrChoise)) {
/*  563 */           lnpInsAddressSchema.setPostalAddress(lnpInsAddressSchema.getHomeAddress() != null ? lnpInsAddressSchema.getHomeAddress() : "");
/*  564 */           lnpInsAddressSchema.setZipCode(lnpInsAddressSchema.getHomeZipCode() != null ? lnpInsAddressSchema.getHomeZipCode() : "");
/*  565 */           lnpInsAddressSchema.setPhone(lnpInsAddressSchema.getHomePhone() != null ? lnpInsAddressSchema.getHomePhone() : "");
/*      */         }
/*  567 */         if ("1".equals(addrChoise)) {
/*  568 */           lnpInsAddressSchema.setPostalAddress(lnpInsAddressSchema.getCompanyAddress() != null ? lnpInsAddressSchema.getCompanyAddress() : "");
/*  569 */           lnpInsAddressSchema.setZipCode(lnpInsAddressSchema.getCompanyZipCode() != null ? lnpInsAddressSchema.getCompanyZipCode() : "");
/*  570 */           lnpInsAddressSchema.setPhone(lnpInsAddressSchema.getCompanyPhone() != null ? lnpInsAddressSchema.getCompanyPhone() : "");
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*  575 */     lnpInsuredSchema.setAddressNo(lnpInsAddressSchema.getAddressNo());
/*      */ 
/*  578 */     System.out.println("3.\uFFFD\u0439\uFFFD\u0376\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03E2");
/*      */ 
/*  580 */     lnpAppntSchema.setGrpContNo(lnpContSchema.getGrpContNo());
/*  581 */     lnpAppntSchema.setContNo(this.contNo);
/*  582 */     lnpAppntSchema.setProposalContNo(this.contNo);
/*  583 */     lnpAppntSchema.setPrtNo(lnpContSchema.getPrtNo());
/*  584 */     lnpAppntSchema.setAppntId(maxNoMap.CreateMaxNo("CustomerNo", ""));
/*  585 */     lnpAppntSchema.setOperator(tempGI.Operator);
/*  586 */     lnpAppntSchema.setModifyDate(date);
/*  587 */     lnpAppntSchema.setModifyTime(time);
/*  588 */     lnpAppntSchema.setMakeDate(date);
/*  589 */     lnpAppntSchema.setMakeTime(time);
/*  590 */     String lsAppntSQL = "select appntname,appntsex,appntbirthday,occupationtype,occupationcode,nativeplace,idtype,idno,marriage,appntage  from lsappnt where contno='" + 
/*  591 */       this.sugNo + "' ";
/*  592 */     if ((this.sugAppntNo != null) && (!"".equals(this.sugAppntNo))) {
/*  593 */       lsAppntSQL = lsAppntSQL + " and appntno='" + this.sugAppntNo + "' ";
/*      */     }
/*  595 */     SSRS lsAppntSSRS = tExeSQL.execSQL(lsAppntSQL);
/*  596 */     if ((lsAppntSSRS != null) && (lsAppntSSRS.MaxRow > 0)) {
/*  597 */       if ((lsAppntSSRS.GetText(1, 1) != null) && (!"".equals(lsAppntSSRS.GetText(1, 1)))) {
/*  598 */         lnpAppntSchema.setAppntName(lsAppntSSRS.GetText(1, 1));
/*      */       }
/*  600 */       if ((lsAppntSSRS.GetText(1, 2) != null) && (!"".equals(lsAppntSSRS.GetText(1, 2)))) {
/*  601 */         lnpAppntSchema.setAppntSex(lsAppntSSRS.GetText(1, 2));
/*      */       }
/*  603 */       if ((lsAppntSSRS.GetText(1, 3) != null) && (!"".equals(lsAppntSSRS.GetText(1, 3)))) {
/*  604 */         lnpAppntSchema.setAppntBirthday(lsAppntSSRS.GetText(1, 3).substring(0, 10));
/*      */       }
/*      */ 
/*  609 */       if ((lsAppntSSRS.GetText(1, 4) != null) && (!"".equals(lsAppntSSRS.GetText(1, 4)))) {
/*  610 */         lnpAppntSchema.setOccupationType(lsAppntSSRS.GetText(1, 4));
/*      */       }
/*  612 */       if ((lsAppntSSRS.GetText(1, 5) != null) && (!"".equals(lsAppntSSRS.GetText(1, 5)))) {
/*  613 */         lnpAppntSchema.setOccupationCode(lsAppntSSRS.GetText(1, 5));
/*      */       }
/*  615 */       if ((lsAppntSSRS.GetText(1, 6) != null) && (!"".equals(lsAppntSSRS.GetText(1, 6)))) {
/*  616 */         String naticePlace = getOutcode("countryareacode", "ls", lsAppntSSRS.GetText(1, 6));
/*  617 */         if ((naticePlace != null) && (!"".equals(naticePlace)))
/*  618 */           lnpAppntSchema.setNativePlace(naticePlace);
/*      */         else
/*  620 */           lnpAppntSchema.setNativePlace("0");
/*      */       }
/*      */       else {
/*  623 */         lnpAppntSchema.setNativePlace("0");
/*      */       }
/*  625 */       if ((lsAppntSSRS.GetText(1, 7) != null) && (!"".equals(lsAppntSSRS.GetText(1, 7)))) {
/*  626 */         String idType = getOutcode("idtype", "ls", lsAppntSSRS.GetText(1, 7));
/*  627 */         if ((idType != null) && (!"".equals(idType))) {
/*  628 */           lnpAppntSchema.setIDType(idType);
/*      */         }
/*      */       }
/*  631 */       if ((lsAppntSSRS.GetText(1, 8) != null) && (!"".equals(lsAppntSSRS.GetText(1, 8)))) {
/*  632 */         lnpAppntSchema.setIDNo(lsAppntSSRS.GetText(1, 8));
/*      */       }
/*  634 */       if ((lsAppntSSRS.GetText(1, 9) != null) && (!"".equals(lsAppntSSRS.GetText(1, 9)))) {
/*  635 */         String marr = getOutcode("wedlock", "ls", lsAppntSSRS.GetText(1, 9));
/*  636 */         if ((marr != null) && (!"".equals(marr))) {
/*  637 */           lnpAppntSchema.setMarriage(marr);
/*      */         }
/*      */       }
/*  640 */       if ((lsAppntSSRS.GetText(1, 10) != null) && (!"".equals(lsAppntSSRS.GetText(1, 10)))) {
/*  641 */         lnpAppntSchema.setAppntAge(lsAppntSSRS.GetText(1, 10));
/*  642 */         lnpAppntSchema.setAppntAgeType("Y");
/*      */       }
/*      */     }
/*      */ 
/*  646 */     lnpAppPersonSchema.setAgentCode(lnpAppntSchema.getOperator());
/*  647 */     lnpAppPersonSchema.setCustomerId(lnpAppntSchema.getAppntId());
/*  648 */     lnpAppPersonSchema.setName(lnpAppntSchema.getAppntName() != null ? lnpAppntSchema.getAppntName() : "");
/*  649 */     lnpAppPersonSchema.setSex(lnpAppntSchema.getAppntSex() != null ? lnpAppntSchema.getAppntSex() : "");
/*  650 */     lnpAppPersonSchema.setBirthday(lnpAppntSchema.getAppntBirthday() != null ? lnpAppntSchema.getAppntBirthday() : "");
/*  651 */     lnpAppPersonSchema.setAgeType(lnpAppntSchema.getAppntAgeType() != null ? lnpAppntSchema.getAppntAgeType() : "");
/*  652 */     lnpAppPersonSchema.setAge(-1 < lnpAppntSchema.getAppntAge() ? lnpAppntSchema.getAppntAge() : 0);
/*  653 */     lnpAppPersonSchema.setOccupationCode(lnpAppntSchema.getOccupationCode() != null ? lnpAppntSchema.getOccupationCode() : "");
/*  654 */     lnpAppPersonSchema.setOccupationType(lnpAppntSchema.getOccupationType() != null ? lnpAppntSchema.getOccupationType() : "");
/*  655 */     lnpAppPersonSchema.setIDType(lnpAppntSchema.getIDType() != null ? lnpAppntSchema.getIDType() : "");
/*  656 */     lnpAppPersonSchema.setIDNo(lnpAppntSchema.getIDNo() != null ? lnpAppntSchema.getIDNo() : "");
/*  657 */     lnpAppPersonSchema.setOperator(tempGI.Operator);
/*  658 */     lnpAppPersonSchema.setMakeDate(date);
/*  659 */     lnpAppPersonSchema.setMakeTime(time);
/*  660 */     lnpAppPersonSchema.setModifyDate(date);
/*  661 */     lnpAppPersonSchema.setModifyTime(time);
/*      */ 
/*  663 */     lnpAppAddressSchema.setCustomerId(lnpAppntSchema.getAppntId());
/*  664 */     lnpAppAddressSchema.setAddressNo(maxNoMap.CreateMaxNo("LNPAddRNo", ""));
/*  665 */     lnpAppAddressSchema.setOperator(tempGI.Operator);
/*  666 */     lnpAppAddressSchema.setMakeDate(date);
/*  667 */     lnpAppAddressSchema.setMakeTime(time);
/*  668 */     lnpAppAddressSchema.setModifyDate(date);
/*  669 */     lnpAppAddressSchema.setModifyTime(time);
/*  670 */     String lsAppAddressSQL = "";
/*  671 */     if ((this.sugAppntNo != null) && (!"".equals(this.sugAppntNo))) {
/*  672 */       lsAppAddressSQL = "select homecountyaddr,homezipcode,homephone,grpcountyaddr,grpzipcode,grpphone,email,addrchoise from lslatncycustm where customerno='" + 
/*  673 */         this.sugAppntNo + "' ";
/*      */     }
/*  675 */     SSRS lsAppAddressSSRS = tExeSQL.execSQL(lsAppAddressSQL);
/*  676 */     if ((lsAppAddressSSRS != null) && (lsAppAddressSSRS.MaxRow > 0)) {
/*  677 */       if ((lsAppAddressSSRS.GetText(1, 1) != null) && (!"".equals(lsAppAddressSSRS.GetText(1, 1)))) {
/*  678 */         lnpAppAddressSchema.setHomeAddress(lsAppAddressSSRS.GetText(1, 1));
/*      */       }
/*  680 */       if ((lsAppAddressSSRS.GetText(1, 2) != null) && (!"".equals(lsAppAddressSSRS.GetText(1, 2)))) {
/*  681 */         lnpAppAddressSchema.setHomeZipCode(lsAppAddressSSRS.GetText(1, 2));
/*      */       }
/*  683 */       if ((lsAppAddressSSRS.GetText(1, 3) != null) && (!"".equals(lsAppAddressSSRS.GetText(1, 3)))) {
/*  684 */         lnpAppAddressSchema.setHomePhone(lsAppAddressSSRS.GetText(1, 3));
/*      */       }
/*  686 */       if ((lsAppAddressSSRS.GetText(1, 4) != null) && (!"".equals(lsAppAddressSSRS.GetText(1, 4)))) {
/*  687 */         lnpAppAddressSchema.setCompanyAddress(lsAppAddressSSRS.GetText(1, 4));
/*      */       }
/*  689 */       if ((lsAppAddressSSRS.GetText(1, 5) != null) && (!"".equals(lsAppAddressSSRS.GetText(1, 5)))) {
/*  690 */         lnpAppAddressSchema.setCompanyZipCode(lsAppAddressSSRS.GetText(1, 5));
/*      */       }
/*  692 */       if ((lsAppAddressSSRS.GetText(1, 6) != null) && (!"".equals(lsAppAddressSSRS.GetText(1, 6)))) {
/*  693 */         lnpAppAddressSchema.setCompanyPhone(lsAppAddressSSRS.GetText(1, 6));
/*      */       }
/*  695 */       if ((lsAppAddressSSRS.GetText(1, 7) != null) && (!"".equals(lsAppAddressSSRS.GetText(1, 7)))) {
/*  696 */         lnpAppAddressSchema.setCompanyMail(lsAppAddressSSRS.GetText(1, 7));
/*      */       }
/*  698 */       if ((lsAppAddressSSRS.GetText(1, 8) != null) && (!"".equals(lsAppAddressSSRS.GetText(1, 8))))
/*      */       {
/*  700 */         String addrChoise = lsAppAddressSSRS.GetText(1, 8);
/*      */ 
/*  702 */         if ("0".equals(addrChoise)) {
/*  703 */           lnpAppAddressSchema.setPostalAddress(lnpAppAddressSchema.getHomeAddress() != null ? lnpAppAddressSchema.getHomeAddress() : "");
/*  704 */           lnpAppAddressSchema.setZipCode(lnpAppAddressSchema.getHomeZipCode() != null ? lnpAppAddressSchema.getHomeZipCode() : "");
/*  705 */           lnpAppAddressSchema.setPhone(lnpAppAddressSchema.getHomePhone() != null ? lnpAppAddressSchema.getHomePhone() : "");
/*      */         }
/*  707 */         if ("1".equals(addrChoise)) {
/*  708 */           lnpAppAddressSchema.setPostalAddress(lnpAppAddressSchema.getCompanyAddress() != null ? lnpAppAddressSchema.getCompanyAddress() : "");
/*  709 */           lnpAppAddressSchema.setZipCode(lnpAppAddressSchema.getCompanyZipCode() != null ? lnpAppAddressSchema.getCompanyZipCode() : "");
/*  710 */           lnpAppAddressSchema.setPhone(lnpAppAddressSchema.getCompanyPhone() != null ? lnpAppAddressSchema.getCompanyPhone() : "");
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*  715 */     lnpAppntSchema.setAddressNo(lnpAppAddressSchema.getAddressNo());
/*  716 */     lnpAppntSchema.setRelationToInsured(lnpInsuredSchema.getRelationToAppnt() != null ? lnpInsuredSchema.getRelationToAppnt() : "");
/*      */ 
/*  720 */     lnpContSchema.setInsuredId(lnpInsuredSchema.getInsuredId());
/*  721 */     lnpContSchema.setInsuredName(lnpInsuredSchema.getName() != null ? lnpInsuredSchema.getName() : "");
/*  722 */     lnpContSchema.setInsuredSex(lnpInsuredSchema.getSex() != null ? lnpInsuredSchema.getSex() : "");
/*  723 */     lnpContSchema.setInsuredBirthday(lnpInsuredSchema.getBirthday() != null ? lnpInsuredSchema.getBirthday() : "");
/*  724 */     lnpContSchema.setInsuredIDType(lnpInsuredSchema.getIDType() != null ? lnpInsuredSchema.getIDType() : "");
/*  725 */     lnpContSchema.setInsuredIDNo(lnpInsuredSchema.getIDNo() != null ? lnpInsuredSchema.getIDNo() : "");
/*  726 */     lnpContSchema.setAppntId(lnpAppntSchema.getAppntId());
/*  727 */     lnpContSchema.setAppntName(lnpAppntSchema.getAppntName() != null ? lnpAppntSchema.getAppntName() : "");
/*  728 */     lnpContSchema.setAppntSex(lnpAppntSchema.getAppntSex() != null ? lnpAppntSchema.getAppntSex() : "");
/*  729 */     lnpContSchema.setAppntBirthday(lnpAppntSchema.getAppntBirthday() != null ? lnpAppntSchema.getAppntBirthday() : "");
/*  730 */     lnpContSchema.setAppntIDType(lnpAppntSchema.getIDType() != null ? lnpAppntSchema.getIDType() : "");
/*  731 */     lnpContSchema.setAppntIDNo(lnpAppntSchema.getIDNo() != null ? lnpAppntSchema.getIDNo() : "");
/*      */ 
/*  735 */     System.out.println("4.\uFFFD\u0439\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03E2");
/*  736 */     String lsMainPolSQL = "select riskcode from lspol where  polno = mainpolno and contno='" + 
/*  737 */       this.sugNo + "' ";
/*  738 */     if ((this.sugInsuredNo != null) && (!"".equals(this.sugInsuredNo))) {
/*  739 */       lsMainPolSQL = lsMainPolSQL + " and insuredno='" + this.sugInsuredNo + "' ";
/*      */     }
/*      */ 
/*  742 */     SSRS lsMainPolSSRS = tExeSQL.execSQL(lsMainPolSQL);
/*      */ 
/*  744 */     if ((lsMainPolSSRS != null) && (lsMainPolSSRS.MaxRow == 1)) {
/*  745 */       String masterPolNo = "";
/*  746 */       if ((lsMainPolSSRS.GetText(1, 1) != null) && (!"".equals(lsMainPolSSRS.GetText(1, 1)))) {
/*  747 */         String riskCode = lsMainPolSSRS.GetText(1, 1);
/*  748 */         masterPolNo = getmasterPolNo(riskCode);
/*      */       }
/*  750 */       String lsPolSql = "select RiskCode,KindCode,RiskVersion,ManageCom,AgentCom,AgentType,AgentCode,AgentGroup,AgentCode1,SaleChnl,Handler,GetYear,PayEndYearFlag,PayEndYear,InsuYearFlag,InsuYear,AcciYearFlag,AcciYear,GetStartType,SpecifyValiDate,PayMode,PayLocation,PayIntv,PayYears,Years,ManageFeeRate,FloatRate,PremRate,PremToAmnt,Mult,StandPrem,Prem,SumPrem,Amnt,RiskAmnt,subflag,standbyflag3 from lspol where contno='" + 
/*  755 */         this.sugNo + "' ";
/*  756 */       if ((this.sugInsuredNo != null) && (!"".equals(this.sugInsuredNo))) {
/*  757 */         lsPolSql = lsPolSql + " and insuredno='" + this.sugInsuredNo + "' ";
/*      */       }
/*  759 */       SSRS lsPolSSRS = tExeSQL.execSQL(lsPolSql);
/*  760 */       if ((lsPolSSRS != null) && (lsPolSSRS.MaxRow > 0)) {
/*  761 */         for (int i = 1; i <= lsPolSSRS.MaxRow; i++) {
/*  762 */           LNPPolSchema lnpPolSchema = new LNPPolSchema();
/*  763 */           lnpPolSchema.setGrpPolNo(LNPPubFun.getSysInfo("grpcontno"));
/*  764 */           lnpPolSchema.setContNo(this.contNo);
/*  765 */           lnpPolSchema.setProposalContNo(this.contNo);
/*  766 */           lnpPolSchema.setGrpContNo(lnpContSchema.getGrpContNo());
/*  767 */           lnpPolSchema.setPrtNo(lnpContSchema.getPrtNo());
/*  768 */           lnpPolSchema.setContType(lnpContSchema.getContType());
/*  769 */           lnpPolSchema.setPolTypeFlag(lnpContSchema.getPolType());
/*  770 */           lnpPolSchema.setOperator(tempGI.Operator);
/*  771 */           lnpPolSchema.setMakeDate(date);
/*  772 */           lnpPolSchema.setMakeTime(time);
/*  773 */           lnpPolSchema.setModifyDate(date);
/*  774 */           lnpPolSchema.setModifyTime(time);
/*  775 */           lnpPolSchema.setMasterPolNo(masterPolNo);
/*  776 */           lnpPolSchema.setInsuredId(lnpInsuredSchema.getInsuredId());
/*  777 */           if (lsPolSSRS.GetText(i, 1) != null) {
/*  778 */             String lsRiskCode = lsPolSSRS.GetText(i, 1);
/*  779 */             lnpPolSchema.setRiskCode(lsRiskCode);
/*  780 */             lnpPolSchema.setPolNo(getmasterPolNo(lsRiskCode));
/*  781 */             lnpPolSchema.setProposalNo(getmasterPolNo(lsRiskCode));
/*      */           }
/*  783 */           if (lsPolSSRS.GetText(i, 2) != null) {
/*  784 */             lnpPolSchema.setKindCode(lsPolSSRS.GetText(i, 2));
/*      */           }
/*  786 */           if (lsPolSSRS.GetText(i, 3) != null) {
/*  787 */             lnpPolSchema.setRiskVersion(lsPolSSRS.GetText(i, 3));
/*      */           }
/*  789 */           if (lsPolSSRS.GetText(i, 4) != null) {
/*  790 */             lnpPolSchema.setManageCom(lsPolSSRS.GetText(i, 4));
/*      */           }
/*  792 */           if (lsPolSSRS.GetText(i, 5) != null) {
/*  793 */             lnpPolSchema.setAgentCom(lsPolSSRS.GetText(i, 5));
/*      */           }
/*  795 */           if (lsPolSSRS.GetText(i, 6) != null) {
/*  796 */             lnpPolSchema.setAgentType(lsPolSSRS.GetText(i, 6));
/*      */           }
/*  798 */           if (lsPolSSRS.GetText(i, 7) != null) {
/*  799 */             lnpPolSchema.setAgentCode(lsPolSSRS.GetText(i, 7));
/*      */           }
/*  801 */           if (lsPolSSRS.GetText(i, 8) != null) {
/*  802 */             lnpPolSchema.setAgentGroup(lsPolSSRS.GetText(i, 8));
/*      */           }
/*  804 */           if (lsPolSSRS.GetText(i, 9) != null) {
/*  805 */             lnpPolSchema.setAgentCode1(lsPolSSRS.GetText(i, 9));
/*      */           }
/*  807 */           if (lsPolSSRS.GetText(i, 10) != null) {
/*  808 */             lnpPolSchema.setSaleChnl(lsPolSSRS.GetText(i, 10));
/*      */           }
/*  810 */           if (lsPolSSRS.GetText(i, 11) != null) {
/*  811 */             lnpPolSchema.setHandler(lsPolSSRS.GetText(i, 11));
/*      */           }
/*  813 */           if (lsPolSSRS.GetText(i, 12) != null) {
/*  814 */             lnpPolSchema.setGetYear(lsPolSSRS.GetText(i, 12));
/*      */           }
/*  816 */           if (lsPolSSRS.GetText(i, 13) != null) {
/*  817 */             lnpPolSchema.setPayEndYearFlag(lsPolSSRS.GetText(i, 13));
/*      */           }
/*  819 */           if (lsPolSSRS.GetText(i, 14) != null) {
/*  820 */             lnpPolSchema.setPayEndYear(lsPolSSRS.GetText(i, 14));
/*      */           }
/*  822 */           if (lsPolSSRS.GetText(i, 15) != null) {
/*  823 */             lnpPolSchema.setInsuYearFlag(lsPolSSRS.GetText(i, 15));
/*      */           }
/*  825 */           if (lsPolSSRS.GetText(i, 16) != null) {
/*  826 */             lnpPolSchema.setInsuYear(lsPolSSRS.GetText(i, 16));
/*      */           }
/*  828 */           if (lsPolSSRS.GetText(i, 17) != null) {
/*  829 */             lnpPolSchema.setAcciYearFlag(lsPolSSRS.GetText(i, 17));
/*      */           }
/*  831 */           if (lsPolSSRS.GetText(i, 18) != null) {
/*  832 */             lnpPolSchema.setAcciYear(lsPolSSRS.GetText(i, 18));
/*      */           }
/*  834 */           if (lsPolSSRS.GetText(i, 19) != null) {
/*  835 */             lnpPolSchema.setGetStartType(lsPolSSRS.GetText(i, 19));
/*      */           }
/*  837 */           if (lsPolSSRS.GetText(i, 20) != null) {
/*  838 */             lnpPolSchema.setSpecifyValiDate(lsPolSSRS.GetText(i, 20));
/*      */           }
/*  840 */           if (lsPolSSRS.GetText(i, 21) != null) {
/*  841 */             lnpPolSchema.setPayMode(lsPolSSRS.GetText(i, 21));
/*      */           }
/*  843 */           if (lsPolSSRS.GetText(i, 22) != null) {
/*  844 */             lnpPolSchema.setPayLocation(lsPolSSRS.GetText(i, 22));
/*      */           }
/*  846 */           if (lsPolSSRS.GetText(i, 23) != null) {
/*  847 */             lnpPolSchema.setPayIntv(lsPolSSRS.GetText(i, 23));
/*      */           }
/*  849 */           if (lsPolSSRS.GetText(i, 24) != null) {
/*  850 */             lnpPolSchema.setPayYears(lsPolSSRS.GetText(i, 24));
/*      */           }
/*  852 */           if (lsPolSSRS.GetText(i, 25) != null) {
/*  853 */             lnpPolSchema.setYears(lsPolSSRS.GetText(i, 25));
/*      */           }
/*  855 */           if (lsPolSSRS.GetText(i, 26) != null) {
/*  856 */             lnpPolSchema.setManageFeeRate(lsPolSSRS.GetText(i, 26));
/*      */           }
/*  858 */           if (lsPolSSRS.GetText(i, 27) != null) {
/*  859 */             lnpPolSchema.setFloatRate(lsPolSSRS.GetText(i, 27));
/*      */           }
/*  861 */           if (lsPolSSRS.GetText(i, 28) != null) {
/*  862 */             lnpPolSchema.setPremRate(lsPolSSRS.GetText(i, 28));
/*      */           }
/*  864 */           if (lsPolSSRS.GetText(i, 29) != null) {
/*  865 */             lnpPolSchema.setPremToAmnt(lsPolSSRS.GetText(i, 29));
/*      */           }
/*  867 */           if (lsPolSSRS.GetText(i, 30) != null) {
/*  868 */             lnpPolSchema.setMult(lsPolSSRS.GetText(i, 30));
/*      */           }
/*  870 */           lsPolSSRS.GetText(i, 31);
/*      */ 
/*  873 */           if (lsPolSSRS.GetText(i, 32) != null)
/*      */           {
/*  875 */             lnpPolSchema.setPrem(0.0D);
/*      */           }
/*  877 */           else lnpPolSchema.setPrem(0.0D);
/*      */ 
/*  879 */           lsPolSSRS.GetText(i, 33);
/*      */ 
/*  882 */           if (lsPolSSRS.GetText(i, 34) != null) {
/*  883 */             lnpPolSchema.setAmnt(lsPolSSRS.GetText(i, 34));
/*      */           }
/*  885 */           if (lsPolSSRS.GetText(i, 35) != null) {
/*  886 */             lnpPolSchema.setRiskAmnt(lsPolSSRS.GetText(i, 35));
/*      */           }
/*      */ 
/*  889 */           if (lsPolSSRS.GetText(i, 36) != null) {
/*  890 */             lnpPolSchema.setSubFlag(lsPolSSRS.GetText(i, 36));
/*      */           }
/*  892 */           if (lsPolSSRS.GetText(i, 37) != null) {
/*  893 */             lnpPolSchema.setStandbyFlag3(lsPolSSRS.GetText(i, 37));
/*      */           }
/*  895 */           lnpPolSchema.setAppFlag("0");
/*  896 */           lnpPolSchema.setPolState("0");
/*      */ 
/*  899 */           lnpPolSet.add(lnpPolSchema);
/*      */         }
/*      */       }
/*      */     }
/*  903 */     System.out.println("5.\uFFFD\uFFFD\uFFFD\uFFFD\u0376\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u077F\uFFFD......");
/*  904 */     map.put(lnpContSchema, "INSERT");
/*  905 */     map.put(lnpInsuredSchema, "INSERT");
/*  906 */     map.put(lnpInsPersonSchema, "INSERT");
/*  907 */     map.put(lnpInsAddressSchema, "INSERT");
/*  908 */     map.put(lnpAppntSchema, "INSERT");
/*  909 */     map.put(lnpAppPersonSchema, "INSERT");
/*  910 */     map.put(lnpAppAddressSchema, "INSERT");
/*  911 */     map.put(lnpPolSet, "INSERT");
/*      */ 
/*  913 */     vd.add(map);
/*  914 */     if (!ps.submitData(vd, "")) {
/*  915 */       System.out.println("---SuggestToInsurance---\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0774\uFFFD\uFFFD\uFFFD");
/*  916 */       this.alertFlag = true;
/*  917 */       this.message = " \uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u05EA\u0376\uFFFD\uFFFD\uFFFD\u9C63\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD";
/*      */     }
/*      */ 
/*  920 */     System.out.println("---doSuggestToInsurance End---");
/*      */   }
/*      */ 
/*      */   private String getmasterPolNo(String riskCode)
/*      */   {
/*  925 */     String masterPolno = "";
/*  926 */     ExeSQL tExeSQL = new ExeSQL();
/*  927 */     String sqlDB = "select sysriskcode from LNPRiskCode where riskcode = '" + riskCode + "'";
/*  928 */     SSRS tSRS = tExeSQL.execSQL(sqlDB);
/*  929 */     if ((tSRS != null) && (tSRS.MaxRow > 0) && 
/*  930 */       (tSRS.GetText(1, 1) != null) && (!"".equals(tSRS.GetText(1, 1)))) {
/*  931 */       masterPolno = this.contNo + tSRS.GetText(1, 1);
/*      */     }
/*      */ 
/*  934 */     return masterPolno;
/*      */   }
/*      */ 
/*      */   private boolean preDOValidateVar()
/*      */   {
/*  941 */     if ((this.contNo == null) || ("" == this.contNo))
/*      */     {
/*  944 */       return false;
/*      */     }
/*  946 */     if ((this.sugNo == null) || ("" == this.sugNo)) {
/*  947 */       this.alertFlag = true;
/*  948 */       this.message = " \uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u05EA\u0376\uFFFD\uFFFD\uFFFD\u9C63\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0237\uFFFD\u03FD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03E2\uFFFD\u01F7\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD ";
/*  949 */       return false;
/*      */     }
/*  951 */     return true;
/*      */   }
/*      */ 
/*      */   private String getSugInsuredNoFromDB(String no)
/*      */   {
/*  956 */     String ino = "";
/*  957 */     ExeSQL tempExeSQL = new ExeSQL();
/*  958 */     String tempSql = "select distinct insuredno from lsinsured where contno = '" + no + "' ";
/*  959 */     SSRS tSRS = new SSRS();
/*  960 */     tSRS = tempExeSQL.execSQL(tempSql);
/*  961 */     if ((tSRS.MaxRow > 0) && 
/*  962 */       (tSRS.GetText(1, 1) != null)) {
/*  963 */       ino = tSRS.GetText(1, 1);
/*      */     }
/*      */ 
/*  966 */     return ino;
/*      */   }
/*      */ 
/*      */   private String getSugAppntNoFromDB(String no)
/*      */   {
/*  971 */     String ano = "";
/*  972 */     ExeSQL tempExeSQL = new ExeSQL();
/*  973 */     String tempSql = "select distinct appntno from lsappnt where contno = '" + no + "' ";
/*  974 */     SSRS tSRS = new SSRS();
/*  975 */     tSRS = tempExeSQL.execSQL(tempSql);
/*  976 */     if ((tSRS.MaxRow > 0) && 
/*  977 */       (tSRS.GetText(1, 1) != null)) {
/*  978 */       ano = tSRS.GetText(1, 1);
/*      */     }
/*      */ 
/*  981 */     return ano;
/*      */   }
/*      */ 
/*      */   public String getOutcode(String changetype, String source, String incode)
/*      */   {
/*  986 */     String outcode = "";
/*  987 */     ExeSQL outcodeExeSQL = new ExeSQL();
/*  988 */     String outcodeExeSQLSql = "select outcode from lnpoutcodemap where changetype = '" + 
/*  989 */       changetype + "' and source='" + source + "' and incode='" + incode + "' ";
/*  990 */     SSRS tSRS = new SSRS();
/*  991 */     tSRS = outcodeExeSQL.execSQL(outcodeExeSQLSql);
/*  992 */     if ((tSRS.MaxRow > 0) && 
/*  993 */       (tSRS.GetText(1, 1) != null)) {
/*  994 */       outcode = tSRS.GetText(1, 1);
/*      */     }
/*      */ 
/*  997 */     return outcode;
/*      */   }
/*      */ 
/*      */   private String getManageCom(String cno)
/*      */   {
/* 1002 */     String com = "";
/* 1003 */     ExeSQL tExeSql = new ExeSQL();
/* 1004 */     String preSql = "select t.comcode,t.name,t.validcode from lnpcom t where t.validcode = '" + cno.toUpperCase().substring(0, 2) + "'";
/* 1005 */     SSRS tSSRSfromCom = tExeSql.execSQL(preSql);
/* 1006 */     if ((tSSRSfromCom != null) && (tSSRSfromCom.MaxRow > 0)) {
/* 1007 */       com = tSSRSfromCom.GetText(1, 1);
/*      */     }
/* 1009 */     return com;
/*      */   }
/*      */ 
/*      */   private String countPValidate(String pSigndateString)
/*      */   {
/* 1014 */     FDate fDate = new FDate();
/* 1015 */     Date pValiDate = fDate.getDate(pSigndateString);
/* 1016 */     long tempt = pValiDate.getTime() + 86400000L;
/* 1017 */     Date nDate = new Date(tempt);
/* 1018 */     return fDate.getString(nDate);
/*      */   }
/*      */ 
/*      */   public void checkContNo()
/*      */   {
/* 1024 */     this.alertFlag = true;
/* 1025 */     HttpSession session = (HttpSession)
/* 1026 */       FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/* 1027 */     IGlobalInput tempGI = (IGlobalInput)session.getValue("NPGI");
/* 1028 */     String sql = "select 1 where '" + this.checkedContNo.toUpperCase().substring(0, 2) + 
/* 1029 */       "' in (select distinct validcode from lnpcom where comcode like '" + tempGI.ManageCom + "%' and comcode<>'86')";
/* 1030 */     ExeSQL tExeSQL = new ExeSQL();
/* 1031 */     SSRS tSSRS = tExeSQL.execSQL(sql);
/* 1032 */     if ((tSSRS != null) && (tSSRS.MaxRow > 0) && 
/* 1033 */       (tSSRS.GetText(1, 1).equals("1"))) {
/* 1034 */       this.alertFlag = false;
/*      */     }
/*      */ 
/* 1037 */     if (!"86".equals(getSugManageCom())) {
/* 1038 */       if (getSugManageCom().equals(getManageCom(this.checkedContNo)))
/* 1039 */         this.alertFlag = false;
/*      */       else {
/* 1041 */         this.alertFlag = true;
/*      */       }
/*      */     }
/* 1044 */     if (this.alertFlag) {
/* 1045 */       this.contNo = "";
/* 1046 */       this.message = " \uFFFD\uFFFD\uFFFD\uFFFD\u0434\uFFFD\uFFFD\u04E6\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0376\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0163\uFFFD";
/* 1047 */       return;
/*      */     }
/* 1049 */     if (!Pattern.matches("^[0-9]{10}", this.checkedContNo.substring(2))) {
/* 1050 */       this.contNo = "";
/* 1051 */       this.message = " \uFFFD\uBC34\uFFFD\uFFFD\uFFFD\uFFFD\u0237\uFFFD\uFFFD\u02BD\u00BC\uFFFD\uFFFD\u0376\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0163\uFFFD";
/* 1052 */       this.alertFlag = true;
/* 1053 */       return;
/*      */     }
/* 1055 */     String newContNo = getCheckedContNo().toUpperCase();
/* 1056 */     this.contNo = newContNo;
/* 1057 */     this.alertFlag = false;
/*      */ 
/* 1060 */     if (!this.alertFlag)
/* 1061 */       checkContNoExist();
/*      */   }
/*      */ 
/*      */   public void checkContNoExist()
/*      */   {
/* 1067 */     String tempContNo = getCheckedContNo();
/* 1068 */     this.alertFlag = false;
/* 1069 */     if ((getContByContNo(tempContNo) != null) || (checkContNoExistInTB(tempContNo))) {
/* 1070 */       this.alertFlag = true;
/* 1071 */       this.contNo = "";
/* 1072 */       this.message = "\uFFFD\uFFFD\u0376\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03F5\u0373\uFFFD\uFFFD\uFFFD\u0474\uFFFD\uFFFD\u06A3\uFFFD";
/*      */     } else {
/* 1074 */       this.alertFlag = false;
/*      */     }
/*      */   }
/*      */ 
/*      */   public LNPContSchema getContByContNo(String contNo)
/*      */   {
/* 1080 */     LNPContDB db = new LNPContDB();
/* 1081 */     db.setContNo(contNo);
/*      */ 
/* 1083 */     if (db.getInfo()) {
/* 1084 */       return db.getSchema();
/*      */     }
/* 1086 */     return null;
/*      */   }
/*      */ 
/*      */   public boolean checkContNoExistInTB(String checkcontno)
/*      */   {
/* 1091 */     boolean flag = false;
/* 1092 */     String sql = "select 1 from tb_application where cd_preprinted_application ='" + checkcontno + "';";
/* 1093 */     ExeSQL tExESQL = new ExeSQL();
/* 1094 */     SSRS tSSRS = tExESQL.execSQL(sql);
/* 1095 */     if ((tSSRS != null) && (tSSRS.MaxRow > 0)) {
/* 1096 */       flag = true;
/*      */     }
/* 1098 */     return flag;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getComCodeListWithSql(String sql) {
/* 1102 */     List list = new ArrayList();
/* 1103 */     ExeSQL tExeSQL = new ExeSQL();
/* 1104 */     String comSQL = sql;
/* 1105 */     SSRS tSSRS = tExeSQL.execSQL(comSQL);
/* 1106 */     for (int i = 1; i <= tSSRS.MaxRow; i++) {
/* 1107 */       list.add(new SelectItem(tSSRS.GetText(i, 1), tSSRS.GetText(i, 2)));
/*      */     }
/* 1109 */     return list;
/*      */   }
/*      */ 
/*      */   public boolean isCheckRiskFlag()
/*      */   {
/* 1116 */     return this.checkRiskFlag;
/*      */   }
/*      */ 
/*      */   public void setCheckRiskFlag(boolean checkRiskFlag) {
/* 1120 */     this.checkRiskFlag = checkRiskFlag;
/*      */   }
/*      */ 
/*      */   public void checkRiskcodeFun() {
/* 1124 */     this.checkRiskFlag = false;
/*      */ 
/* 1126 */     String tmpcheckRiskcode = this.checkRiskcode.replaceAll(",", "','");
/* 1127 */     String sql = "select * from lnprisk a ,LNPRiskComCtrl b where a.riskcode =b.riskcode and  b.salechnl='" + this.tempGI.BranchType + "' " + 
/* 1128 */       "and a.riskcode in('" + tmpcheckRiskcode + "')";
/*      */ 
/* 1130 */     ExeSQL tExESQL = new ExeSQL();
/* 1131 */     SSRS tSSRS = tExESQL.execSQL(sql);
/* 1132 */     if ((tSSRS != null) && (tSSRS.MaxRow > 0))
/* 1133 */       this.checkRiskFlag = true;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getComCodeList()
/*      */   {
/* 1141 */     return this.comCodeList;
/*      */   }
/*      */ 
/*      */   public void setComCodeList(List<SelectItem> comCodeList) {
/* 1145 */     this.comCodeList = comCodeList;
/*      */   }
/*      */ 
/*      */   public String getMessage() {
/* 1149 */     return this.message;
/*      */   }
/*      */   public void setMessage(String message) {
/* 1152 */     this.message = message;
/*      */   }
/*      */   public LNPSuggestToInsuranceBean getStiBean() {
/* 1155 */     return this.stiBean;
/*      */   }
/*      */   public void setStiBean(LNPSuggestToInsuranceBean stiBean) {
/* 1158 */     this.stiBean = stiBean;
/*      */   }
/*      */   public List<LNPSuggestToInsuranceBean> getStiBeanList() {
/* 1161 */     return this.stiBeanList;
/*      */   }
/*      */   public void setStiBeanList(List<LNPSuggestToInsuranceBean> stiBeanList) {
/* 1164 */     this.stiBeanList = stiBeanList;
/*      */   }
/*      */   public String getStartDate() {
/* 1167 */     return this.startDate;
/*      */   }
/*      */ 
/*      */   public void setStartDate(String startDate) {
/* 1171 */     this.startDate = startDate;
/*      */   }
/*      */ 
/*      */   public String getEndDate() {
/* 1175 */     return this.endDate;
/*      */   }
/*      */ 
/*      */   public void setEndDate(String endDate) {
/* 1179 */     this.endDate = endDate;
/*      */   }
/*      */ 
/*      */   public IGlobalInput getTempGI() {
/* 1183 */     return this.tempGI;
/*      */   }
/*      */ 
/*      */   public void setTempGI(IGlobalInput tempGI) {
/* 1187 */     this.tempGI = tempGI;
/*      */   }
/*      */ 
/*      */   public boolean isAlertFlag() {
/* 1191 */     return this.alertFlag;
/*      */   }
/*      */ 
/*      */   public void setAlertFlag(boolean alertFlag) {
/* 1195 */     this.alertFlag = alertFlag;
/*      */   }
/*      */ 
/*      */   public boolean isShowErrorFlag() {
/* 1199 */     return this.showErrorFlag;
/*      */   }
/*      */ 
/*      */   public void setShowErrorFlag(boolean showErrorFlag) {
/* 1203 */     this.showErrorFlag = showErrorFlag;
/*      */   }
/*      */ 
/*      */   public String getContNo() {
/* 1207 */     return this.contNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String contNo) {
/* 1211 */     this.contNo = contNo;
/*      */   }
/*      */ 
/*      */   public String getCheckedContNo() {
/* 1215 */     return this.checkedContNo;
/*      */   }
/*      */ 
/*      */   public void setCheckedContNo(String checkedContNo) {
/* 1219 */     this.checkedContNo = checkedContNo;
/*      */   }
/*      */ 
/*      */   public String getSugNo() {
/* 1223 */     return this.sugNo;
/*      */   }
/*      */ 
/*      */   public void setSugNo(String sugNo) {
/* 1227 */     this.sugNo = sugNo;
/*      */   }
/*      */ 
/*      */   public String getSugInsuredNo() {
/* 1231 */     return this.sugInsuredNo;
/*      */   }
/*      */ 
/*      */   public void setSugInsuredNo(String sugInsuredNo) {
/* 1235 */     this.sugInsuredNo = sugInsuredNo;
/*      */   }
/*      */ 
/*      */   public String getSugAppntNo() {
/* 1239 */     return this.sugAppntNo;
/*      */   }
/*      */ 
/*      */   public void setSugAppntNo(String sugAppntNo) {
/* 1243 */     this.sugAppntNo = sugAppntNo;
/*      */   }
/*      */ 
/*      */   public String getSugManageCom() {
/* 1247 */     return this.sugManageCom;
/*      */   }
/*      */ 
/*      */   public void setSugManageCom(String sugManageCom) {
/* 1251 */     this.sugManageCom = sugManageCom;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.SuggestToInsuranceQuery
 * JD-Core Version:    0.6.0
 */