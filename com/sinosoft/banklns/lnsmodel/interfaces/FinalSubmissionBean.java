/*      */ package com.sinosoft.banklns.lnsmodel.interfaces;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.CRSInfoDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPAddressDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPAgentInfoDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPAppntDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPBnfDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPBonusInfoDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPCUWMasterDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPCodeDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPContDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPInsuredDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPInvestmentAccountInfoDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPInvestmentInfoDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPPaymentDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPPolDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.MMap;
/*      */ import com.sinosoft.banklns.lis.schema.CRSInfoSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPAddressSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPAgentInfoSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPAppntSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPBnfSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPBonusInfoSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPCUWMasterSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPCodeSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPInsuredSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPInvestmentAccountInfoSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPInvestmentInfoSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPPaymentSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPPolSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPAddressSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPAgentInfoSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPBnfSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPCUWMasterSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPCodeSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPInsuredSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPInvestmentAccountInfoSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPInvestmentInfoSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPPolSet;
/*      */ import com.sinosoft.banklns.utility.Arith;
/*      */ import com.sinosoft.banklns.utility.ExeSQL;
/*      */ import com.sinosoft.banklns.utility.SSRS;
/*      */ import java.io.PrintStream;
/*      */ import java.util.List;
/*      */ import org.jdom.Element;
/*      */ import org.jdom.Namespace;
/*      */ 
/*      */ public class FinalSubmissionBean extends PublicInterfaces
/*      */ {
/*      */   private LNPContSchema tLNPContSchema;
/*      */   private LNPAppntSchema tLNPAppntSchema;
/*      */   private CRSInfoSchema tCRSInfoSchema;
/*      */   private LNPInsuredSchema tLNPInsuredSchema;
/*   74 */   private LNPAddressSchema tAppntAddressSchema = null;
/*      */ 
/*   76 */   private LNPAddressSchema tInsurAddressSchema = null;
/*      */ 
/*   78 */   private LNPPaymentSchema tLNPPaymentSchema = null;
/*      */ 
/*   80 */   private LNPBonusInfoSchema tLNPBonusInfoSchema = null;
/*      */   private LNPPolSet tLNPPolSet;
/*   84 */   private String saleChannel = "";
/*      */   private LNPBnfSet tLNPBnfSet;
/*      */   private LNPAgentInfoSchema tLNPAgentInfoSchema;
/*   91 */   private LNPInvestmentInfoSchema tLNPInvestmentInfoSchema = null;
/*      */   private LNPInvestmentAccountInfoSet tLNpInvestmentAccountInfoSet;
/*      */   private LNPCUWMasterSchema tLNPCUWMasterSchema;
/*      */   private String userName;
/*      */   private String password;
/*      */   boolean flag;
/*      */ 
/*      */   protected void initObject()
/*      */   {
/*  104 */     this.modelFileName = "issue_in.xml";
/*  105 */     this.sendFileName = "issue_in";
/*  106 */     this.returnFileName = "issue_out";
/*  107 */     this.defaultErrorMessage = "\u53D1\u9001\u4FDD\u5355\u5931\u8D25\uFF01";
/*      */ 
/*  113 */     super.initObject();
/*      */ 
/*  115 */     this.tLNPContSchema = null;
/*  116 */     this.tLNPAppntSchema = null;
/*      */ 
/*  118 */     this.tCRSInfoSchema = null;
/*      */ 
/*  120 */     this.tLNPInsuredSchema = null;
/*  121 */     this.tLNPPolSet = null;
/*  122 */     this.tLNPBnfSet = null;
/*      */   }
/*      */ 
/*      */   protected boolean dealReturn()
/*      */   {
/*      */     try {
/*  128 */       LNPContSchema bakLNPContSchema = new LNPContSchema();
/*  129 */       bakLNPContSchema.setSchema(this.tLNPContSchema);
/*      */ 
/*  131 */       Element returnN = getReturnBody();
/*      */ 
/*  133 */       System.out.println("--returnN--" + returnN.getName());
/*      */ 
/*  144 */       Namespace err = Namespace.getNamespace("http://www.csc.smart/bo/schemas/Error");
/*  145 */       Element errorN = returnN.getChild("ERROR", err);
/*  146 */       if (errorN != null) {
/*  147 */         System.out.println("EAI\u8C03\u7528LA\u6210\u529F\uFF0C\u4F46\u8FD4\u56DE\u4E86\u9519\u8BEF\uFF01");
/*  148 */         Element statusN = errorN.getChild("STATUS", err);
/*  149 */         Element reason = errorN.getChild("REASON", err);
/*  150 */         String valiReason = reason.getChild("ERROR_DESC", err).getText();
/*  151 */         this.message += valiReason;
/*  152 */         System.out.println("ERROR_DESC==" + this.message);
/*      */ 
/*  154 */         return false;
/*      */       }
/*      */ 
/*  163 */       Element policylistN = returnN.getChild("POLICYLIST");
/*  164 */       if (policylistN == null) {
/*  165 */         System.out.println("******************SOAP ERROR*******************MSP\u63A5\u53E3NBUPLService\u8C03\u7528\u51FA\u9519\uFF01");
/*  166 */         return false;
/*      */       }
/*  168 */       System.out.println("--policylistN--" + policylistN.getName());
/*      */ 
/*  173 */       Element policyN = policylistN.getChild("POLICY");
/*      */ 
/*  177 */       System.out.println(policyN.getName());
/*  178 */       System.out.println(policyN.getText());
/*      */ 
/*  181 */       if ("0".equals(getValueInXML(policyN, "ERRCODE"))) {
/*  182 */         this.tLNPContSchema.setLang("2");
/*      */ 
/*  184 */         setModifyTime(this.tLNPContSchema);
/*      */ 
/*  186 */         this.tLNPContSchema.setUWOperator(getValueInXML(policyN, "PDESC"));
/*  187 */         this.tLNPContSchema.setUWDate(this.tLNPContSchema.getModifyDate());
/*      */ 
/*  189 */         this.tLNPContSchema.setMainPolNo(getValueInXML(policyN, "CHDRNUM"));
/*  190 */         this.bakMap.put(bakLNPContSchema, "UPDATE");
/*  191 */         this.map.put(this.tLNPContSchema, "UPDATE");
/*  192 */         return true;
/*      */       }
/*  194 */       this.tLNPContSchema.setLang("2");
/*  195 */       this.message = getValueInXML(policyN, "PDESC");
/*      */ 
/*  199 */       this.tLNPContSchema.setUWDate(this.tLNPContSchema.getModifyDate());
/*  200 */       this.bakMap.put(bakLNPContSchema, "UPDATE");
/*  201 */       this.map.put(this.tLNPContSchema, "UPDATE");
/*  202 */       return false;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  218 */       e.printStackTrace();
/*  219 */     }return false;
/*      */   }
/*      */ 
/*      */   protected boolean dealSend()
/*      */   {
/*      */     try {
/*  225 */       Element msgBody = getSendBody();
/*  226 */       String company = mappingCode(this.tLNPContSchema.getManageCom(), "BankSigned");
/*      */ 
/*  230 */       Namespace msp = Namespace.getNamespace("http://www.csc.smart/msp/schemas/MSPContext");
/*      */ 
/*  232 */       List msgList = msgBody.getChildren();
/*  233 */       Element mspContent = (Element)msgList.get(0);
/*      */ 
/*  235 */       Element userId = mspContent.getChild("UserId", msp);
/*  236 */       userId.setText(this.userName);
/*  237 */       Element uerPassword = mspContent.getChild("UserPassword", msp);
/*  238 */       uerPassword.setText(this.password);
/*  239 */       Element reqps = mspContent.getChild("RequestParameters", msp);
/*  240 */       Element requestParameter = reqps.getChild("RequestParameter", msp);
/*  241 */       requestParameter.setAttribute("name", "BRANCH").setAttribute("value", company);
/*      */ 
/*  254 */       Element policy = msgBody.getChild("POLST").getChild("POLICY");
/*  255 */       updateText(policy, "ZNEXTSYS", "4");
/*  256 */       updateText(policy, "PRT1OPT", "Y");
/*  257 */       updateText(policy, "PRT2OPT", "Y");
/*  258 */       updateText(policy, "ZNGPCNO", this.tLNPContSchema.getAgentCode1());
/*  259 */       updateText(policy, "STATCODE", "PS");
/*  260 */       updateText(policy, "CNTBRANCH", company);
/*  261 */       updateText(policy, "TTMPRCNO", this.tLNPContSchema.getContNo());
/*      */ 
/*  263 */       updateText(policy, "CHDRNUM", "");
/*  264 */       updateText(policy, "OCCDATE", fomartDate(this.tLNPContSchema.getPValiDate()));
/*  265 */       updateText(policy, "HPROPDTE", fomartDate(this.tLNPContSchema.getPSignDate()));
/*  266 */       updateText(policy, "HPRRCVDT", fomartDate(this.tLNPAgentInfoSchema.getP1()));
/*      */ 
/*  269 */       Element policyOwner = policy.getChild("POLICYOWNER");
/*  270 */       updateText(policyOwner, "OWNERSEL", this.tLNPAppntSchema.getAppntNo());
/*  271 */       updateText(policyOwner, "SALUTL", "MR / MRS");
/*  272 */       updateText(policyOwner, "LSURNAME", this.tLNPAppntSchema.getAppntName());
/*  273 */       updateText(policyOwner, "DOB", fomartDate(this.tLNPAppntSchema.getAppntBirthday()));
/*  274 */       updateText(policyOwner, "CLTSEX", mappingCode(this.tLNPAppntSchema.getAppntSex(), "BankPolicySex"));
/*  275 */       updateText(policyOwner, "MARRYD", "");
/*      */ 
/*  280 */       updateText(policyOwner, "ZACLTADDR", combAddress(this.tAppntAddressSchema, "2"));
/*  281 */       updateText(policyOwner, "CLTPCODE", this.tAppntAddressSchema.getCompanyZipCode());
/*  282 */       updateText(policyOwner, "ADDRTYPE", "1");
/*  283 */       updateText(policyOwner, "ZNBUSUT", this.tAppntAddressSchema.getGrpName());
/*  284 */       updateText(policyOwner, "CTRYCODE", this.tLNPAppntSchema.getNativePlace());
/*  285 */       updateText(policyOwner, "NATLTY", this.tLNPAppntSchema.getNativePlace());
/*  286 */       updateText(policyOwner, "CLRSKIND", "1");
/*  287 */       updateText(policyOwner, "RSKFLG", "1");
/*  288 */       updateText(policyOwner, "IDNPRF", mappingCode(this.tLNPAppntSchema.getIDType(), "BankCertType"));
/*  289 */       updateText(policyOwner, "SECUITYNO", this.tLNPAppntSchema.getIDNo());
/*  290 */       updateText(policyOwner, "EXPDTE", 
/*  292 */         "1".equals(this.tLNPAppntSchema.getIDPerpetual()) ? fomartDate(this.tLNPAppntSchema.getIDValidity()) : turnNullToString(this.tLNPAppntSchema.getIDValidity()).trim().equals("") ? 
/*  291 */         "99999999" : 
/*  293 */         fomartDate(mappingCode(this.tLNPAppntSchema.getIDPerpetual(), "BankCertificatesType")));
/*  294 */       updateText(policyOwner, "INCPRF", "");
/*  295 */       updateText(policyOwner, "INCDESC", "");
/*  296 */       updateText(policyOwner, "DECGRSAL", 
/*  297 */         turnNullToString(Integer.valueOf((int)Arith.mul(this.tLNPAppntSchema.getSalary(), 10000.0D))));
/*  298 */       updateText(policyOwner, "RMBLPHONE", this.tAppntAddressSchema.getPhone());
/*  299 */       updateText(policyOwner, "CLTPHONE", 
/*  300 */         combPhone(this.tAppntAddressSchema.getMobileChs2(), this.tAppntAddressSchema.getCompanyPhone()));
/*  301 */       updateText(policyOwner, "RINTERNET", this.tAppntAddressSchema.getCompanyMail());
/*  302 */       updateText(policyOwner, "OCCPCODE", this.tLNPAppntSchema.getOccupationCode());
/*  303 */       updateText(policyOwner, "ZNPIDCPYID", mappingCode(this.tLNPAppntSchema.getHealth(), "BankIsOrNo"));
/*      */ 
/*  305 */       updateText(policyOwner, "PRSKINDOWN", "");
/*  306 */       updateText(policyOwner, "ANNPRMTEND", "0");
/*  307 */       updateText(policyOwner, "FMLINCOME", "0");
/*  308 */       updateText(policyOwner, "RSDTKIND", "");
/*      */ 
/*  315 */       updateText(policy, "BILLFREQ", mappingCode(turnNullToString(Integer.valueOf(this.tLNPContSchema.getPayIntv())), "BankFrequency"));
/*  316 */       updateText(policy, "ZNFPMOP", mappingCode(this.tLNPPaymentSchema.getPayMent1(), "BankRenewal"));
/*      */ 
/*  318 */       updateText(policy, "MOP", 
/*  319 */         !"5".equals(turnNullToString(Integer.valueOf(this.tLNPContSchema.getPayIntv()))) ? 
/*  320 */         mappingCode(this.tLNPPaymentSchema.getPayMent2(), "BankRenewal") : 
/*  321 */         "N");
/*  322 */       updateText(policy, "ZDIVOPT", mappingCode(this.tLNPBonusInfoSchema.getBonusWay(), "BankBonusPayMent"));
/*      */ 
/*  324 */       updateText(policy, "ZNFOPT", mappingCode(this.tLNPBonusInfoSchema.getP2(), "BankOverDue"));
/*      */ 
/*  326 */       updateText(policy, "CNTCURR", "CNY");
/*  327 */       updateText(policy, "BILLCURR", "CNY");
/*  328 */       updateText(policy, "REGISTER", "01");
/*  329 */       updateText(policy, "SRCEBUS", "3");
/*  330 */       if ((this.tLNPPolSet.size() > 0) && ("2".equals(this.tLNPPolSet.get(1).getRnewFlag()))) {
/*  331 */         updateText(policy, "SRCEBUS", turnToCode(this.tLNPPolSet.get(1).getUWTime()));
/*      */       }
/*  333 */       updateText(policy, "DLVRMODE", 
/*  334 */         "01,02,03".indexOf(turnNullToString(this.tLNPAgentInfoSchema.getP3())) == -1 ? "04" : 
/*  335 */         mappingCode(this.tLNPAgentInfoSchema.getP3(), "BankDeliveryType"));
/*      */ 
/*  340 */       updateText(policy, "ZNPSTADD", combAddress(this.tAppntAddressSchema, "1"));
/*  341 */       updateText(policy, "CLTPCODE03", this.tAppntAddressSchema.getHomeZipCode());
/*  342 */       updateText(policy, "ZNAGNTSEL", this.tLNPAgentInfoSchema.getP2());
/*      */ 
/*  344 */       updateText(policy, "AGCOMRT", "100");
/*      */ 
/*  347 */       Element subAgent = policy.getChild("SUBAGENTLIST");
/*      */ 
/*  350 */       updateText(subAgent, "ZNAGNTSEL01", "");
/*      */ 
/*  352 */       updateText(subAgent, "SPLITC", "0");
/*      */ 
/*  355 */       updateText(policy, "ZNCSMNAME", this.tLNPAgentInfoSchema.getAgentCode());
/*  356 */       if (("2".equals(this.tLNPPolSet.get(1).getRnewFlag())) && (
/*  357 */         ("AGY".equals(this.tLNPPolSet.get(1).getUWTime())) || ("TM".equals(this.tLNPPolSet.get(1).getUWTime())))) {
/*  358 */         updateText(policy, "ZNCSMNAME", "");
/*      */       }
/*      */ 
/*  362 */       Element insured = policy.getChild("INSLST").getChild("INSURED");
/*  363 */       updateText(insured, "Life", "01");
/*      */ 
/*  365 */       Element insuredInfo = insured.getChild("INSUREDINFO");
/*  366 */       updateText(insuredInfo, "LIFCNUM", this.tLNPInsuredSchema.getInsuredNo());
/*  367 */       updateText(insuredInfo, "SALUTL02", "MR / MRS");
/*  368 */       updateText(insuredInfo, "LSURNAME02", this.tLNPInsuredSchema.getName());
/*  369 */       updateText(insuredInfo, "DOB02", fomartDate(this.tLNPInsuredSchema.getBirthday()));
/*  370 */       updateText(insuredInfo, "CLTSEX02", mappingCode(this.tLNPInsuredSchema.getSex(), "BankPolicySex"));
/*  371 */       updateText(insuredInfo, "MARRYD02", "");
/*      */ 
/*  376 */       updateText(insuredInfo, "ZACLTADDR02", combAddress(this.tInsurAddressSchema, "2"));
/*  377 */       updateText(insuredInfo, "CLTPCODE02", this.tInsurAddressSchema.getCompanyZipCode());
/*  378 */       updateText(insuredInfo, "ADDRTYPE02", "1");
/*  379 */       updateText(insuredInfo, "ZNBUSUT02", this.tInsurAddressSchema.getGrpName());
/*  380 */       updateText(insuredInfo, "CTRYCODE02", this.tLNPInsuredSchema.getNativePlace());
/*  381 */       updateText(insuredInfo, "NATLTY02", this.tLNPInsuredSchema.getNativePlace());
/*  382 */       updateText(insuredInfo, "CLRSKIND02", "1");
/*  383 */       updateText(insuredInfo, "RSKFLG02", "1");
/*  384 */       updateText(insuredInfo, "IDNPRF02", mappingCode(this.tLNPInsuredSchema.getIDType(), "BankCertType"));
/*  385 */       updateText(insuredInfo, "SECUITYNO02", this.tLNPInsuredSchema.getIDNo());
/*  386 */       updateText(insuredInfo, "EXPDTE02", 
/*  388 */         "1".equals(this.tLNPInsuredSchema.getIDPerpetual()) ? fomartDate(this.tLNPInsuredSchema.getIDValidity()) : turnNullToString(this.tLNPInsuredSchema.getIDValidity()).trim().equals("") ? 
/*  387 */         "99999999" : 
/*  389 */         fomartDate(mappingCode(this.tLNPInsuredSchema.getIDPerpetual(), "BankCertificatesType")));
/*  390 */       updateText(insuredInfo, "INCPRF02", "");
/*  391 */       updateText(insuredInfo, "INCDESC02", "");
/*  392 */       updateText(insuredInfo, "DECGRSAL02", 
/*  393 */         turnNullToString(Integer.valueOf((int)Arith.mul(this.tLNPInsuredSchema.getSalary(), 10000.0D))));
/*  394 */       updateText(insuredInfo, "RMBLPHONE02", this.tInsurAddressSchema.getPhone());
/*  395 */       updateText(insuredInfo, "CLTPHONE02", 
/*  396 */         combPhone(this.tInsurAddressSchema.getMobileChs2(), this.tInsurAddressSchema.getCompanyPhone()));
/*  397 */       updateText(insuredInfo, "RINTERNET02", this.tInsurAddressSchema.getCompanyMail());
/*  398 */       updateText(insuredInfo, "OCCPCODE02", this.tLNPInsuredSchema.getOccupationCode());
/*  399 */       updateText(insuredInfo, "ZNPIDCPYID02", mappingCode(this.tLNPInsuredSchema.getHealth(), "BankIsOrNo"));
/*      */ 
/*  402 */       updateText(insuredInfo, "PRSKINDINS", "");
/*      */ 
/*  407 */       updateText(insured, "RELATION", mappingCode(this.tLNPAppntSchema.getRelationToInsured(), "BankRelationship"));
/*      */ 
/*  409 */       updateText(insured, "SELECTION", "");
/*      */ 
/*  414 */       updateText(insured, "HEIGHT", mappingQues("A05", "insur", this.tLNPContSchema.getContNo(), this.saleChannel));
/*  415 */       updateText(insured, "WEIGHT", mappingQues("A06", "insur", this.tLNPContSchema.getContNo(), this.saleChannel));
/*  416 */       updateText(insured, "SMOKING", "");
/*  417 */       updateText(insured, "OCCUP", this.tLNPInsuredSchema.getOccupationCode());
/*      */ 
/*  420 */       Element questionArea = insured.getChild("QUESTIONARE");
/*  421 */       if ("2".equals(this.saleChannel))
/*  422 */         updateText(questionArea, "QUESTSET", "MTQTM");
/*      */       else {
/*  424 */         updateText(questionArea, "QUESTSET", "MTQBA");
/*      */       }
/*      */ 
/*  428 */       boolean isDoHiuTianShi = false;
/*      */ 
/*  430 */       int i = 1; for (int j = 1; i <= this.tLNPPolSet.size(); i++) {
/*  431 */         LNPPolSchema tempPol1 = this.tLNPPolSet.get(i);
/*  432 */         if (("MR12BQ".equals(tempPol1.getRiskCode())) || ("MR12BR".equals(tempPol1.getRiskCode()))) {
/*  433 */           isDoHiuTianShi = true;
/*      */         }
/*      */       }
/*  436 */       if (isDoHiuTianShi) {
/*  437 */         updateText(questionArea, "QUESTSET", "MTQB1");
/*      */       }
/*      */ 
/*  441 */       LNPCodeSet codeSet = new LNPCodeSet();
/*  442 */       LNPCodeDB db = new LNPCodeDB(this.con);
/*      */ 
/*  444 */       db.setCodeType("QueCodeMapping");
/*  445 */       db.setComCode(this.saleChannel);
/*  446 */       codeSet = db.query();
/*  447 */       Element questionList = questionArea.getChild("QUESTIONLIST");
/*  448 */       Element question = questionList.getChild("QUESTION");
/*      */ 
/*  450 */       if (codeSet.size() > 0) {
/*  451 */         questionList.removeContent();
/*      */       }
/*  453 */       for (int i = 1; i <= codeSet.size(); i++) {
/*  454 */         Element tempElement = (Element)question.clone();
/*      */ 
/*  461 */         updateText(tempElement, "QUESTIDF", codeSet.get(i).getCodeName());
/*  462 */         updateText(tempElement, "ANSWER", mappingQues(codeSet.get(i).getCodeName(), 
/*  463 */           codeSet.get(i).getOtherSign(), this.tLNPContSchema.getContNo(), this.saleChannel));
/*      */ 
/*  465 */         String qid = codeSet.get(i).getCodeName();
/*  466 */         if ((!isDoHiuTianShi) && ("B04".equals(qid))) {
/*  467 */           updateText(tempElement, "QUESTIDF", "B03");
/*  468 */           updateText(tempElement, "ANSWER", "");
/*      */         }
/*      */ 
/*  472 */         questionList.addContent(tempElement);
/*      */       }
/*      */ 
/*  477 */       updateText(insured, "HUWDCDTE", "99999999");
/*      */ 
/*  480 */       Element coverageList = insured.getChild("COVLST");
/*  481 */       Element coverageInfo = coverageList.getChild("COVINFO");
/*  482 */       if (this.tLNPPolSet.size() > 0) {
/*  483 */         coverageList.removeContent();
/*      */       }
/*  485 */       int i = 1; for (int j = 1; i <= this.tLNPPolSet.size(); i++) {
/*  486 */         Element tempCoverage = (Element)coverageInfo.clone();
/*  487 */         LNPPolSchema tempPol = this.tLNPPolSet.get(i);
/*  488 */         updateText(tempCoverage, "Coverage", "01");
/*  489 */         if (!"M".equalsIgnoreCase(tempPol.getSubFlag()))
/*  490 */           updateText(tempCoverage, "RIDER", "0" + j++);
/*      */         else {
/*  492 */           updateText(tempCoverage, "RIDER", "00");
/*      */         }
/*  494 */         updateText(tempCoverage, "ZNPRDCODE", tempPol.getRiskCode());
/*  495 */         updateText(tempCoverage, "SUMIN", turnNullToString(Integer.valueOf((int)tempPol.getAmnt())));
/*      */ 
/*  506 */         if (this.flag)
/*      */         {
/*  508 */           if ("A".equals(tempPol.getPremToAmnt()))
/*  509 */             updateText(tempCoverage, "RCESSAGE", turnNullToString(tempPol.getPayLocation()));
/*      */           else {
/*  511 */             updateText(tempCoverage, "RCESSTRM", turnNullToString(tempPol.getPayLocation()));
/*      */           }
/*  513 */           if ("A".equals(tempPol.getAcciYearFlag()))
/*  514 */             updateText(tempCoverage, "PCESSAGE", turnNullToString(tempPol.getPayMode()));
/*      */           else {
/*  516 */             updateText(tempCoverage, "PCESSTRM", "1000".equals(turnNullToString(tempPol.getPayMode())) ? "1" : 
/*  517 */               turnNullToString(tempPol.getPayMode()));
/*      */           }
/*  519 */           if ("A".equals(tempPol.getGetYearFlag()))
/*  520 */             updateText(tempCoverage, "BCESSAGE", turnNullToString(Integer.valueOf(tempPol.getGetYear())));
/*      */           else
/*  522 */             updateText(tempCoverage, "BCESSTRM", turnNullToString(Integer.valueOf(tempPol.getGetYear())));
/*      */         }
/*      */         else {
/*  525 */           if ("A".equals(tempPol.getInsuYearFlag()))
/*  526 */             updateText(tempCoverage, "RCESSAGE", turnNullToString(Integer.valueOf(tempPol.getInsuYear())));
/*      */           else {
/*  528 */             updateText(tempCoverage, "RCESSTRM", turnNullToString(Integer.valueOf(tempPol.getInsuYear())));
/*      */           }
/*  530 */           if ("A".equals(tempPol.getPayEndYearFlag()))
/*  531 */             updateText(tempCoverage, "PCESSAGE", turnNullToString(Integer.valueOf(tempPol.getPayEndYear())));
/*      */           else {
/*  533 */             updateText(tempCoverage, "PCESSTRM", 
/*  534 */               "1000".equals(turnNullToString(Integer.valueOf(tempPol.getPayEndYear()))) ? "1" : 
/*  535 */               turnNullToString(Integer.valueOf(tempPol.getPayEndYear())));
/*      */           }
/*  537 */           if ("A".equals(tempPol.getGetYearFlag()))
/*      */           {
/*  544 */             if ((tempPol.getRiskCode().equals("LA11BA")) && 
/*  545 */               (turnNullToString(Integer.valueOf(tempPol.getInsuYear())).equals("20")))
/*      */             {
/*  548 */               updateText(tempCoverage, "BCESSTRM", "11");
/*      */             }
/*  551 */             else if ((tempPol.getRiskCode().equals("LA11BA")) && 
/*  552 */               (turnNullToString(Integer.valueOf(tempPol.getInsuYear())).equals("25")))
/*      */             {
/*  555 */               updateText(tempCoverage, "BCESSTRM", "16");
/*      */             }
/*      */             else
/*      */             {
/*  559 */               updateText(tempCoverage, "BCESSAGE", turnNullToString(Integer.valueOf(tempPol.getGetYear())));
/*      */             }
/*      */ 
/*      */           }
/*      */           else
/*      */           {
/*  568 */             updateText(tempCoverage, "BCESSTRM", turnNullToString(Integer.valueOf(tempPol.getGetYear())));
/*      */           }
/*      */ 
/*      */         }
/*      */ 
/*  573 */         updateText(tempCoverage, "MORTCLS", "2");
/*  574 */         updateText(tempCoverage, "INSTPRM", turnNullToString(fomartNum(tempPol.getPrem())));
/*      */ 
/*  576 */         updateText(tempCoverage, "ZPRFLG", "N");
/*      */ 
/*  578 */         if ((this.tLNPInvestmentInfoSchema != null) && 
/*  579 */           (!turnNullToString(this.tLNPInvestmentInfoSchema.getTermInvestment()).equals("")) && 
/*  580 */           (this.tLNPInvestmentInfoSchema.getMonthPlusPrem() > 0.0D) && 
/*  581 */           (Double.parseDouble(this.tLNPInvestmentInfoSchema.getTermInvestment()) > 0.0D)) {
/*  582 */           updateText(tempCoverage, "LMPCNT", this.tLNPInvestmentInfoSchema.getPayExtraPremFlag());
/*  583 */           updateText(tempCoverage, "ZPRFLG", "Y");
/*      */ 
/*  585 */           updateText(tempCoverage, "ZNINVAMT", 
/*  586 */             turnNullToString(Integer.valueOf((int)this.tLNPInvestmentInfoSchema.getMonthPlusPrem())));
/*  587 */           updateText(tempCoverage, "ZNTRM", this.tLNPInvestmentInfoSchema.getTermInvestment());
/*      */         }
/*      */ 
/*  590 */         updateText(tempCoverage, "ZUNIT", "1");
/*  591 */         updateText(tempCoverage, "LIVESNO", "1");
/*  592 */         updateText(tempCoverage, "PAYCLT", this.tLNPAppntSchema.getAppntNo());
/*      */ 
/*  594 */         Element payBankInfor = tempCoverage.getChild("PAYBANKINFOR");
/*  595 */         if ("02".equals(this.tLNPPaymentSchema.getPayMent1())) {
/*  596 */           updateText(payBankInfor, "BANKCODE", "");
/*  597 */           updateText(payBankInfor, "BANKKEY", this.tLNPPaymentSchema.getBankCode());
/*  598 */           updateText(payBankInfor, "BANKACCKEY", this.tLNPPaymentSchema.getAccount());
/*  599 */           updateText(payBankInfor, "BANKDESC", this.tLNPAppntSchema.getAppntName());
/*  600 */           updateText(payBankInfor, "BNKACTYP", "");
/*  601 */           updateText(payBankInfor, "CURRCODE", "CNY");
/*  602 */           updateText(payBankInfor, "DATEFROM", fomartDate(this.tLNPContSchema.getPValiDate()));
/*  603 */           updateText(payBankInfor, "TIMESUSE", "0");
/*      */         }
/*      */ 
/*  606 */         updateText(tempCoverage, "FREQANN", "-1".equals(tempPol.getStandbyFlag3()) ? "" : 
/*  607 */           mappingCode(tempPol.getStandbyFlag3(), "BankAnnuityReceive"));
/*      */ 
/*  610 */         String ANNSendtext = "";
/*  611 */         String CPNSendtext = "";
/*  612 */         ExeSQL tExeSQL = new ExeSQL();
/*  613 */         String sql = "select L_BankBonusMode,L_BankAnnMode,L_BankAnnFreq,L_BankCpnMode from [LNPRiskConfig] where L_RiskCode='" + tempPol.getRiskCode() + "'";
/*  614 */         SSRS tSRS = tExeSQL.execSQL(sql);
/*  615 */         if (tSRS.MaxRow > 0) {
/*  616 */           String L_BankAnnMode = tSRS.GetText(1, 2);
/*  617 */           String L_BankCpnMode = tSRS.GetText(1, 4);
/*  618 */           if (!"-1".equals(L_BankAnnMode)) {
/*  619 */             ANNSendtext = "-1".equals(tempPol.getDeadGetMode()) ? "" : mappingCode(tempPol.getDeadGetMode(), "BankAnnuity");
/*      */           }
/*  621 */           if (!"-1".equals(L_BankCpnMode)) {
/*  622 */             CPNSendtext = "-1".equals(tempPol.getDeadGetMode()) ? "" : mappingCode(tempPol.getDeadGetMode(), "BankAnnuity");
/*      */           }
/*  624 */           System.out.println("+_+_+_+_+_ANN=" + ANNSendtext + "|||||CPN=" + CPNSendtext);
/*      */         }
/*      */ 
/*  627 */         updateText(tempCoverage, "PMTANN", ANNSendtext);
/*  628 */         updateText(tempCoverage, "FREQCPN", "");
/*      */ 
/*  630 */         updateText(tempCoverage, "PMTCPN", CPNSendtext);
/*      */ 
/*  632 */         updateText(tempCoverage, "COMMSFLAG", "");
/*  633 */         updateText(tempCoverage, "CLMPMTFRQ", "");
/*      */ 
/*  635 */         updateText(tempCoverage, "ADVANCE", "");
/*  636 */         updateText(tempCoverage, "ARREARS", "");
/*  637 */         updateText(tempCoverage, "GUARPERD", "0");
/*  638 */         updateText(tempCoverage, "WITHPROP", "");
/*  639 */         updateText(tempCoverage, "WITHOPROP", "");
/*  640 */         updateText(tempCoverage, "NOMLIFE", "");
/*  641 */         updateText(tempCoverage, "DTHPERCN", "0");
/*  642 */         updateText(tempCoverage, "DTHPERCO", "0");
/*      */ 
/*  644 */         Element payment = tempCoverage.getChild("PAYMENT");
/*  645 */         updateText(payment, "PAYCLT02", "");
/*  646 */         updateText(payment, "CLTYPE", "");
/*  647 */         updateText(payment, "RGPYMOP", "");
/*  648 */         updateText(payment, "REGPAYFREQ", "-1".equals(tempPol.getStandbyFlag3()) ? "" : 
/*  649 */           mappingCode(tempPol.getStandbyFlag3(), "BankAnnuityReceive"));
/*      */ 
/*  652 */         updateText(payment, "PRCNT", "0");
/*  653 */         updateText(payment, "CLAIMCUR", "CNY");
/*  654 */         if (this.tLNPInvestmentInfoSchema != null)
/*  655 */           updateText(tempCoverage, "RSUNIN", 
/*  656 */             mappingCode(this.tLNPInvestmentInfoSchema.getHesInvestment(), "BankInvestment"));
/*  657 */         updateText(tempCoverage, "PRCAMTIND", "");
/*      */ 
/*  661 */         Element PRMFundList = tempCoverage.getChild("PRMFLST");
/*      */ 
/*  663 */         Element RGUFundList = tempCoverage.getChild("RGUFLST");
/*      */ 
/*  681 */         for (int x = 1; (x <= this.tLNpInvestmentAccountInfoSet.size()) && (x <= 10); x++) {
/*  682 */           if (x < 10) {
/*  683 */             updateText(PRMFundList, "VRTFND0" + x, 
/*  684 */               this.tLNpInvestmentAccountInfoSet.get(x).getInvestAccountCode());
/*  685 */             updateText(PRMFundList, "UALPRC0" + x, turnNullToString(
/*  686 */               Double.valueOf(Arith.mul(this.tLNpInvestmentAccountInfoSet.get(x).getInvestAccountRate(), 100.0D))));
/*      */           } else {
/*  688 */             updateText(PRMFundList, "VRTFND" + x, 
/*  689 */               this.tLNpInvestmentAccountInfoSet.get(x).getInvestAccountCode());
/*  690 */             updateText(PRMFundList, "UALPRC" + x, turnNullToString(
/*  691 */               Double.valueOf(Arith.mul(this.tLNpInvestmentAccountInfoSet.get(x).getInvestAccountRate(), 100.0D))));
/*      */           }
/*      */         }
/*  694 */         for (int x = 1; (x <= this.tLNpInvestmentAccountInfoSet.size()) && (x <= 10); x++) {
/*  695 */           if (x < 10) {
/*  696 */             updateText(RGUFundList, "ZAVRTFND0" + x, 
/*  697 */               this.tLNpInvestmentAccountInfoSet.get(x).getInvestAccountCode());
/*  698 */             updateText(RGUFundList, "ZNSPLAMT0" + x, turnNullToString(
/*  699 */               Double.valueOf(Arith.mul(this.tLNpInvestmentAccountInfoSet.get(x).getInvestAccountRate(), 100.0D))));
/*      */           } else {
/*  701 */             updateText(RGUFundList, "ZAVRTFND" + x, 
/*  702 */               this.tLNpInvestmentAccountInfoSet.get(x).getInvestAccountCode());
/*  703 */             updateText(RGUFundList, "ZNSPLAMT" + x, turnNullToString(
/*  704 */               Double.valueOf(Arith.mul(this.tLNpInvestmentAccountInfoSet.get(x).getInvestAccountRate(), 100.0D))));
/*      */           }
/*      */         }
/*      */ 
/*  708 */         updateText(tempCoverage, "ZACOVBAK01", "");
/*  709 */         updateText(tempCoverage, "ZACOVBAK02", "");
/*  710 */         updateText(tempCoverage, "ZACOVBAK03", "");
/*  711 */         updateText(tempCoverage, "ZACOVBAK04", "");
/*  712 */         updateText(tempCoverage, "ZACOVBAK05", "");
/*      */ 
/*  714 */         coverageList.addContent(tempCoverage);
/*      */       }
/*      */ 
/*  718 */       Element bnfList = policy.getChild("BENEFICIARYLIST");
/*  719 */       Element bnf = bnfList.getChild("BENEFICIARY");
/*      */ 
/*  757 */       if (this.tLNPInsuredSchema.getInsuredPeoples() > 0) {
/*  758 */         bnfList.removeContent();
/*  759 */         for (int x = 1; x <= this.tLNPBnfSet.size(); x++) {
/*  760 */           LNPBnfSchema tempSchema = this.tLNPBnfSet.get(x);
/*  761 */           Element tempBnf = (Element)bnf.clone();
/*  762 */           updateText(tempBnf, "BNYTYPE", "0" + tempSchema.getBenefitType());
/*      */ 
/*  764 */           updateText(tempBnf, "BNYSEL", tempSchema.getBnfNo());
/*  765 */           updateText(tempBnf, "SALUTL04", "MR / MRS");
/*  766 */           updateText(tempBnf, "LSURNAME04", tempSchema.getBnfName());
/*  767 */           updateText(tempBnf, "DOB04", fomartDate(tempSchema.getBnfBirthday()));
/*  768 */           updateText(tempBnf, "CLTSEX04", mappingCode(tempSchema.getBnfSex(), "BankPolicySex"));
/*  769 */           updateText(tempBnf, "MARRYD04", "");
/*  770 */           updateText(tempBnf, "ZACLTADDR04", "");
/*  771 */           updateText(tempBnf, "ADDRTYPE04", "");
/*  772 */           updateText(tempBnf, "ZNBUSUT04", "");
/*  773 */           updateText(tempBnf, "CTRYCODE04", "");
/*  774 */           updateText(tempBnf, "NATLTY04", "");
/*  775 */           updateText(tempBnf, "IDNPRF04", mappingCode(tempSchema.getIDType(), "BankCertType"));
/*  776 */           updateText(tempBnf, "SECUITYNO04", tempSchema.getIDNo());
/*  777 */           updateText(tempBnf, "EXPDTE04", 
/*  779 */             "1".equals(tempSchema.getIDPerpetual()) ? fomartDate(tempSchema.getIDValidity()) : turnNullToString(tempSchema.getIDValidity()).trim().equals("") ? 
/*  778 */             "99999999" : 
/*  780 */             fomartDate(mappingCode(tempSchema.getIDPerpetual(), "BankCertificatesType")));
/*  781 */           updateText(tempBnf, "ZNPIDCPYID04", "");
/*  782 */           updateText(tempBnf, "CLTRELN02", 
/*  783 */             mappingCode(tempSchema.getRelationToInsured(), "BankBenefitAndInsured"));
/*  784 */           updateText(tempBnf, "BNYPC", turnNullToString(Double.valueOf(tempSchema.getBenefitRate())));
/*  785 */           updateText(tempBnf, "ZBNYTLVL", 
/*  786 */             Integer.parseInt(tempSchema.getBenefitOrder()) < 10 ? "0" + tempSchema.getBenefitOrder() : 
/*  787 */             tempSchema.getBenefitOrder());
/*  788 */           updateText(tempBnf, "EFFDATE", "0");
/*  789 */           updateText(tempBnf, "ZDCLMPLN", mappingCode(this.tLNPInsuredSchema.getCreditGrade(), "BankIsOrNo"));
/*      */ 
/*  791 */           updateText(tempBnf, "BENSEQ", "");
/*  792 */           updateText(tempBnf, "BENREF", "");
/*      */ 
/*  805 */           updateText(tempBnf, "CPKIND", "");
/*  806 */           updateText(tempBnf, "PRSKINDBEN", "");
/*      */ 
/*  808 */           bnfList.addContent(tempBnf);
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*  813 */       if ("02".equals(this.tLNPPaymentSchema.getPayMent1())) {
/*  814 */         Element FRTRecBank = policy.getChild("FRTRECBANK");
/*  815 */         updateText(FRTRecBank, "BANKKEY02", this.tLNPPaymentSchema.getBankCode());
/*  816 */         updateText(FRTRecBank, "BANKACCKEY02", this.tLNPPaymentSchema.getAccount());
/*  817 */         updateText(FRTRecBank, "BANKDESC02", this.tLNPAppntSchema.getAppntName());
/*  818 */         updateText(FRTRecBank, "BNKACTYP02", "");
/*  819 */         updateText(FRTRecBank, "CURRCODE02", "CNY");
/*  820 */         updateText(FRTRecBank, "DATEFROM01", fomartDate(this.tLNPContSchema.getPValiDate()));
/*  821 */         updateText(FRTRecBank, "DATETO", "0");
/*      */       }
/*      */ 
/*  824 */       if ("02".equals(this.tLNPPaymentSchema.getPayMent2())) {
/*  825 */         Element SEQRecBank = policy.getChild("SEQRECBANK");
/*  826 */         updateText(SEQRecBank, "BANKKEY03", this.tLNPPaymentSchema.getBankCode());
/*  827 */         updateText(SEQRecBank, "BANKACCKEY03", this.tLNPPaymentSchema.getAccount());
/*  828 */         updateText(SEQRecBank, "BANKDESC03", this.tLNPAppntSchema.getAppntName());
/*  829 */         updateText(SEQRecBank, "BNKACTYP03", "");
/*  830 */         updateText(SEQRecBank, "CURRCODE03", "CNY");
/*  831 */         updateText(SEQRecBank, "DATEFROM02", fomartDate(this.tLNPContSchema.getPValiDate()));
/*  832 */         updateText(SEQRecBank, "DATETO02", "0");
/*      */       }
/*      */ 
/*  835 */       updateText(policy, "TRANDATEX", "0");
/*      */ 
/*  837 */       updateText(policy, "TCHQDATE", "0");
/*  838 */       updateText(policy, "BANKDESC01R", "1");
/*  839 */       updateText(policy, "BANKDESC03R", "");
/*  840 */       updateText(policy, "RFCODE", "CN");
/*  841 */       updateText(policy, "RFNUM", "");
/*  842 */       updateText(policy, "PAYTYPE", "");
/*  843 */       updateText(policy, "DOCORIGAMT", "0");
/*  844 */       updateText(policy, "ZNOVRPAYOP", mappingCode(this.tLNPBonusInfoSchema.getP1(), "BankIsOrNo"));
/*      */ 
/*  850 */       LNPPolSet tset = new LNPPolDB(this.con).executeQuery("select * from lnppol where contno='" + this.tContNo + 
/*  851 */         "' and RiskVersion is not null and RiskVersion<>'' and RnewFlag in ('1','2')");
/*  852 */       if (tset.size() > 0) {
/*  853 */         Element packageInfo = policy.getChild("PACKAGEINFO");
/*  854 */         updateText(packageInfo, "ZNPKGCODE", tset.get(1).getRiskVersion());
/*  855 */         updateText(packageInfo, "TOTPRE", turnNullToString(tset.get(1).getRemark()));
/*  856 */         updateText(packageInfo, "ZTOTSI", "0");
/*      */       }
/*      */ 
/*  860 */       Element remark = policy.getChild("GENERALREMARK");
/*  861 */       String remark01 = "";
/*  862 */       String remark02 = "";
/*  863 */       if (!turnNullToString(this.tLNPContSchema.getConsignNo()).trim().equals(""))
/*      */       {
/*  868 */         remark01 = this.tLNPContSchema.getConsignNo().substring(0, this.tLNPContSchema.getConsignNo().length() / 2);
/*  869 */         remark02 = this.tLNPContSchema.getConsignNo().substring(this.tLNPContSchema.getConsignNo().length() / 2);
/*  870 */         System.out.println(remark01 + "---" + remark02);
/*      */       }
/*  872 */       updateText(remark, "LINE01", remark01);
/*  873 */       updateText(remark, "LINE02", remark02);
/*      */ 
/*  875 */       updateText(policy, "SACSCODE", "");
/*      */ 
/*  877 */       updateText(policy, "CAMPAIGN", "");
/*  878 */       updateText(policy, "ZNPRJTCD", "");
/*      */ 
/*  881 */       updateText(policy, "ZNEPOLFLG", this.tLNPAgentInfoSchema.getPolPrintType());
/*      */ 
/*  884 */       updateText(policy, "ZNDISPER", "0");
/*  885 */       updateText(policy, "ZNSPCTYP", "");
/*  886 */       updateText(policy, "ZNBILLNO", "");
/*  887 */       updateText(policy, "ZNINVBNK", "");
/*  888 */       updateText(policy, "VIP", mappingCode(this.tLNPAppntSchema.getAppntGrade(), "BankIsOrNo"));
/*      */ 
/*  890 */       updateText(policy, "BUYERID", "");
/*      */ 
/*  892 */       updateText(policy, "ZAPOLFLD1", "");
/*  893 */       updateText(policy, "ZAPOLFLD2", "");
/*  894 */       updateText(policy, "ZAPOLFLD3", "");
/*  895 */       updateText(policy, "ZAPOLFLD4", "");
/*      */ 
/*  900 */       System.out.println("\u5F00\u59CB\u751F\u6210CRS\u62A5\u6587\u5B57\u6BB5\u4FE1\u606F");
/*  901 */       if (this.tCRSInfoSchema == null) {
/*  902 */         System.out.println("\u5F00\u59CB\u751F\u6210CRS\u62A5\u6587\u5B57\u6BB5\u4FE1\u606Fnull");
/*  903 */         System.out.println("CRS\u4E3Anull");
/*  904 */         updateText(policy, "ZAPOLFLD5", "");
/*  905 */       } else if ((this.tCRSInfoSchema.getTaxResidentType() == null) || ("".equals(this.tCRSInfoSchema.getTaxResidentType()))) {
/*  906 */         System.out.println("\u5F00\u59CB\u751F\u6210CRS\u62A5\u6587\u5B57\u6BB5\u4FE1\u606Ftype=nul");
/*  907 */         updateText(policy, "ZAPOLFLD5", "");
/*      */       }
/*      */       else {
/*  910 */         System.out.println("\u5F00\u59CB\u751F\u6210CRS\u62A5\u6587\u5B57\u6BB5\u4FE1\u606F1--2--3");
/*  911 */         updateText(policy, "ZAPOLFLD5", this.tCRSInfoSchema.getTaxResidentType());
/*  912 */         System.out.println("CRS\u53D1\u9001LA\u62A5\u6587\u5DF2\u751F\u6210");
/*      */       }
/*      */ 
/*  916 */       updateText(policy, "ZAPOLFLD6", "");
/*  917 */       updateText(policy, "ZAPOLFLD7", "");
/*  918 */       updateText(policy, "ZAPOLFLD8", "");
/*  919 */       updateText(policy, "ZAPOLFLD9", "");
/*  920 */       updateText(policy, "ZAPOLFLD10", "");
/*  921 */       updateText(policy, "ZAPOLFLD11", "");
/*  922 */       updateText(policy, "ZAPOLFLD12", "");
/*  923 */       updateText(policy, "ZAPOLFLD13", "");
/*  924 */       updateText(policy, "ZAPOLFLD14", "");
/*  925 */       updateText(policy, "ZAPOLFLD15", "");
/*      */ 
/*  927 */       return true;
/*      */     }
/*      */     catch (Exception e) {
/*  930 */       e.printStackTrace();
/*  931 */     }return false;
/*      */   }
/*      */ 
/*      */   protected boolean getInputData(String tContNo)
/*      */   {
/*      */     try
/*      */     {
/*  942 */       this.flag = false;
/*  943 */       this.valiPassFlag = true;
/*  944 */       if ((tContNo != null) && (!tContNo.equals("")))
/*      */       {
/*  946 */         ExeSQL exeSQL = new ExeSQL(this.con);
/*  947 */         SSRS ssrs = exeSQL
/*  948 */           .execSQL("select sysvartype,sysvarvalue from lnpsysvar where SysVar='issue_user_password'");
/*  949 */         if (ssrs.MaxRow > 0) {
/*  950 */           this.userName = ssrs.GetText(1, 1);
/*  951 */           this.password = ssrs.GetText(1, 2);
/*      */         } else {
/*  953 */           this.message = "\u7F3A\u5931\u6743\u9650,\u8BF7\u83B7\u53D6\u6743\u9650\u540E\u7EE7\u7EED\u64CD\u4F5C!";
/*  954 */           return this.valiPassFlag = 0;
/*      */         }
/*      */ 
/*  957 */         LNPContDB tLNPContDB = new LNPContDB(this.con);
/*  958 */         tLNPContDB.setContNo(tContNo);
/*  959 */         if (!tLNPContDB.getInfo()) {
/*  960 */           this.message = "\u83B7\u53D6\u6295\u4FDD\u4E66\u4FE1\u606F\u5931\u8D25\uFF01";
/*  961 */           return this.valiPassFlag = 0;
/*      */         }
/*  963 */         this.tLNPContSchema = tLNPContDB.getSchema();
/*      */ 
/*  967 */         LNPAppntDB tLNPAppntDB = new LNPAppntDB(this.con);
/*  968 */         tLNPAppntDB.setContNo(tContNo);
/*  969 */         if (tLNPAppntDB.getInfo()) {
/*  970 */           this.tLNPAppntSchema = tLNPAppntDB.getSchema();
/*      */         } else {
/*  972 */           this.message = "\u7F3A\u5931\u6295\u4FDD\u4EBA\u4FE1\u606F\uFF01";
/*  973 */           return this.valiPassFlag = 0;
/*      */         }
/*  975 */         this.tAppntAddressSchema = new LNPAddressDB(this.con).executeQuery(
/*  976 */           "select * from lnpaddress a where  exists(select 1 from lnpappnt b where a.customerid=b.appntid  and b.contno='" + 
/*  977 */           tContNo + "')")
/*  978 */           .get(1);
/*      */ 
/*  981 */         CRSInfoDB tCRSInfoDB = new CRSInfoDB(this.con);
/*  982 */         tCRSInfoDB.setContNo(tContNo);
/*  983 */         if (tCRSInfoDB.getInfo())
/*  984 */           this.tCRSInfoSchema = tCRSInfoDB.getSchema();
/*      */         else {
/*  986 */           System.out.println("\u8BE5\u4FDD\u5355\u5728\u6570\u636E\u5E93\u4E2D\u65E0\u4FE1\u606F!");
/*      */         }
/*      */ 
/*  990 */         this.tLNPInsuredSchema = new LNPInsuredDB(this.con)
/*  991 */           .executeQuery("select * from LNPInsured where contno='" + tContNo + "'").get(1);
/*  992 */         if (this.tLNPInsuredSchema == null) {
/*  993 */           this.message = "\u7F3A\u5931\u88AB\u4FDD\u4EBA\u4FE1\u606F\uFF01";
/*  994 */           return this.valiPassFlag = 0;
/*      */         }
/*  996 */         this.tInsurAddressSchema = new LNPAddressDB(this.con).executeQuery(
/*  997 */           "select * from lnpaddress a where  exists(select 1 from lnpinsured b where a.customerid=b.insuredid  and b.contno='" + 
/*  998 */           tContNo + "')")
/*  999 */           .get(1);
/*      */ 
/* 1001 */         this.tLNPBnfSet = new LNPBnfDB(this.con).executeQuery("select * from lnpbnf where contno='" + tContNo + 
/* 1002 */           "' and (health is null or health<>'delete') order by bnforder");
/* 1003 */         if ((this.tLNPInsuredSchema.getInsuredPeoples() > 0) && (this.tLNPBnfSet.size() > 0)) {
/* 1004 */           String msg = "\u8BF7\u5B8C\u5584\u201C\u5BA2\u6237\u4FE1\u606F\u201D\u4E2D\u201C\u53D7\u76CA\u4EBA\u4FE1\u606F\u201D\u90E8\u5206\u7684\u4FE1\u606F\u9879\uFF01";
/* 1005 */           for (int i = 1; i <= this.tLNPBnfSet.size(); i++) {
/* 1006 */             LNPBnfSchema tSchema = this.tLNPBnfSet.get(i);
/* 1007 */             if ((!turnNullToString(Double.valueOf(tSchema.getBenefitRate())).equals("")) && 
/* 1008 */               (!turnNullToString(tSchema.getBenefitOrder()).equals("")) && 
/* 1009 */               (!turnNullToString(this.tLNPInsuredSchema.getCreditGrade()).equals(""))) continue;
/* 1010 */             this.message = msg;
/* 1011 */             return this.valiPassFlag = 0;
/*      */           }
/*      */ 
/*      */         }
/*      */ 
/* 1016 */         this.tLNPAgentInfoSchema = new LNPAgentInfoDB(this.con)
/* 1017 */           .executeQuery("select * from LNPAgentInfo where contno='" + tContNo + "'").get(1);
/* 1018 */         if (this.tLNPAgentInfoSchema == null) {
/* 1019 */           this.message = "\u7F3A\u5931\u4EE3\u7406\u4EBA\u4FE1\u606F\uFF01";
/* 1020 */           return this.valiPassFlag = 0;
/*      */         }
/*      */ 
/* 1023 */         LNPPaymentDB tLNPPaymentDB = new LNPPaymentDB(this.con);
/* 1024 */         tLNPPaymentDB.setContNo(tContNo);
/* 1025 */         if (tLNPPaymentDB.getInfo()) {
/* 1026 */           this.tLNPPaymentSchema = tLNPPaymentDB.getSchema();
/* 1027 */           String account = getDecryptAccount(tContNo);
/* 1028 */           this.tLNPPaymentSchema.setAccount(account);
/*      */         } else {
/* 1030 */           this.message = "\u8BF7\u5148\u586B\u5199\u6536\u4ED8\u8D39\u4FE1\u606F\uFF01";
/* 1031 */           return this.valiPassFlag = 0;
/*      */         }
/*      */ 
/* 1034 */         LNPBonusInfoDB tLNPBonusInfoDB = new LNPBonusInfoDB(this.con);
/* 1035 */         tLNPBonusInfoDB.setContNo(tContNo);
/* 1036 */         if (tLNPBonusInfoDB.getInfo()) {
/* 1037 */           this.tLNPBonusInfoSchema = tLNPBonusInfoDB.getSchema();
/*      */         } else {
/* 1039 */           this.message = "\u8BF7\u5148\u586B\u5199\u7EA2\u5229\u4FE1\u606F\uFF01";
/* 1040 */           return this.valiPassFlag = 0;
/*      */         }
/*      */ 
/* 1043 */         this.tLNPPolSet = new LNPPolDB(this.con).executeQuery("select * from lnppol where contno='" + tContNo + "'");
/* 1044 */         for (int i = 1; i <= this.tLNPPolSet.size(); i++) {
/* 1045 */           if (!"".equals(turnNullToString(this.tLNPPolSet.get(i).getRiskVersion()).trim())) {
/* 1046 */             System.out.println("issue_service~~~~~~~~~~~current policy risk type is package~~~~~~~~~~");
/* 1047 */             this.flag = true;
/* 1048 */             break;
/*      */           }
/*      */         }
/* 1051 */         this.saleChannel = turnToCode(this.tLNPPolSet.get(1).getUWTime());
/*      */ 
/* 1053 */         this.tLNPInvestmentInfoSchema = new LNPInvestmentInfoDB(this.con)
/* 1054 */           .executeQuery("select * from LNPInvestmentInfo where contno='" + tContNo + "'").get(1);
/*      */ 
/* 1056 */         this.tLNpInvestmentAccountInfoSet = new LNPInvestmentAccountInfoDB(this.con)
/* 1057 */           .executeQuery("select * from LNPInvestmentAccountInfo where contno='" + tContNo + 
/* 1058 */           "' and InvestAccountRate>0");
/*      */ 
/* 1060 */         LNPCUWMasterSet set = new LNPCUWMasterDB(this.con)
/* 1061 */           .executeQuery("select * from LNPCUWMaster where contno='" + tContNo + "'");
/* 1062 */         if (set.size() > 0) {
/* 1063 */           this.tLNPCUWMasterSchema = set.get(1);
/*      */         } else {
/* 1065 */           System.out.println("\u4E22\u5931\u6838\u4FDD\u7ED3\u8BBA~~~~~~~~");
/* 1066 */           this.tLNPCUWMasterSchema = new LNPCUWMasterSchema();
/*      */         }
/*      */       }
/*      */     } catch (Exception e) {
/* 1070 */       e.printStackTrace();
/* 1071 */       return this.valiPassFlag = 0;
/*      */     }
/* 1073 */     return true;
/*      */   }
/*      */ 
/*      */   public static void main(String[] args)
/*      */   {
/* 1080 */     FinalSubmissionBean cal = new FinalSubmissionBean();
/* 1081 */     String tContNo = "987654128888";
/* 1082 */     tContNo = "098765432111";
/*      */ 
/* 1084 */     tContNo = "201603241559";
/* 1085 */     tContNo = "201703206002";
/*      */ 
/* 1087 */     tContNo = "201901181723";
/*      */ 
/* 1089 */     cal.calInterfaces(tContNo);
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.interfaces.FinalSubmissionBean
 * JD-Core Version:    0.6.0
 */