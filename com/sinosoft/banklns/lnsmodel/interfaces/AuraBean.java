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
/*      */ import com.sinosoft.banklns.lis.db.LNPUWMasterDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.PubFun;
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
/*      */ import com.sinosoft.banklns.lis.vschema.CRSInfoSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPAddressSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPAgentInfoSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPAppntSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPBnfSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPCodeSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPInsuredSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPInvestmentAccountInfoSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPInvestmentInfoSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPPolSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPUWMasterSet;
/*      */ import com.sinosoft.banklns.utility.Arith;
/*      */ import com.sinosoft.banklns.utility.ExeSQL;
/*      */ import com.sinosoft.banklns.utility.SSRS;
/*      */ import java.io.PrintStream;
/*      */ import java.util.List;
/*      */ import org.jdom.Element;
/*      */ 
/*      */ public class AuraBean extends PublicInterfaces
/*      */ {
/*   49 */   private LNPContSchema tLNPContSchema = null;
/*      */ 
/*   52 */   private LNPInsuredSchema tLNPInsuredSchema = null;
/*      */ 
/*   55 */   private LNPAppntSchema tLNPAppntSchema = null;
/*      */ 
/*   57 */   private LNPAddressSchema tAppntAddressSchema = null;
/*      */ 
/*   59 */   private CRSInfoSchema tCRSInfoSchema = null;
/*      */ 
/*   61 */   private LNPAddressSchema tInsurAddressSchema = null;
/*      */ 
/*   64 */   private LNPBnfSet tLNPBnfSet = null;
/*      */ 
/*   67 */   private LNPPolSet tLNPPolSet = null;
/*      */ 
/*   69 */   private LNPPolSet tLNPPolSet2 = null;
/*      */ 
/*   71 */   private String saleChannel = "";
/*      */ 
/*   74 */   private LNPCUWMasterSchema tLNPCUWMasterSchema = null;
/*   75 */   private LNPUWMasterSet tLNPUWMasterSet = null;
/*      */ 
/*   78 */   private LNPPaymentSchema tLNPPaymentSchema = null;
/*      */ 
/*   80 */   private LNPBonusInfoSchema tLNPBonusInfoSchema = null;
/*      */ 
/*   83 */   private LNPAgentInfoSet tLNPAgentInfoSet = null;
/*      */ 
/*   86 */   private LNPInvestmentInfoSchema tLNPInvestmentInfoSchema = null;
/*      */   private LNPInvestmentAccountInfoSet tLNpInvestmentAccountInfoSet;
/*      */ 
/*      */   protected void initObject()
/*      */   {
/*   93 */     this.interfacesFlag = false;
/*   94 */     this.modelFileName = "aura_in.xml";
/*   95 */     this.sendFileName = "appnt_in";
/*   96 */     this.returnFileName = "appnt_out";
/*   97 */     this.defaultErrorMessage = "\u6295\u4FDD\u89C4\u5219\u6821\u9A8C\u5931\u8D25\uFF01";
/*      */ 
/*  100 */     super.initObject();
/*      */   }
/*      */ 
/*      */   protected boolean dealReturn()
/*      */   {
/*      */     try
/*      */     {
/*  110 */       Element auratx = getReturnBody();
/*      */ 
/*  113 */       if (!"ACC".equals(getValueInXML(auratx, "ZNCNTUW"))) {
/*  114 */         this.message = getValueInXML(auratx, "PDESC");
/*  115 */         if (("".equals(this.message)) || (this.message == null)) {
/*  116 */           Element allDecisionsN = auratx.getChild("Insureds").getChild("Insured").getChild("OverallDecisions");
/*  117 */           List decisionNList = allDecisionsN.getChildren();
/*  118 */           for (Element cDec : decisionNList) {
/*  119 */             this.message = (this.message + " \u9669\u79CD:" + cDec.getChild("ZNPRDCODE").getText() + "," + cDec.getChild("UnderwritingDecision").getChild("MESSAGE").getText() + ";");
/*      */           }
/*      */         }
/*  122 */         return false;
/*      */       }
/*  124 */       return true;
/*      */     }
/*      */     catch (Exception e) {
/*  127 */       e.printStackTrace();
/*  128 */     }return false;
/*      */   }
/*      */ 
/*      */   protected boolean dealSend()
/*      */   {
/*      */     try
/*      */     {
/*  136 */       Element auratx = getSendBody();
/*  137 */       String company = mappingCode(this.tLNPContSchema.getManageCom(), "BankSigned");
/*      */ 
/*  140 */       Element auraControl = auratx.getChild("AuraControl");
/*      */ 
/*  142 */       updateText(auraControl, "UniqueID", this.tLNPContSchema.getContNo() + fomartDate(PubFun.getCurrentDate()) + PubFun.getCurrentTime().replace(":", ""));
/*      */ 
/*  144 */       updateText(auraControl, "Company", "mlc");
/*  145 */       updateText(auraControl, "SetCode", "16");
/*  146 */       updateText(auraControl, "SubSet", "1");
/*  147 */       updateText(auraControl, "PostBackTo", "review.jsp");
/*  148 */       updateText(auraControl, "PostErrorsTo", "review.jsp");
/*  149 */       updateText(auraControl, "SaveExitPage", "review.jsp");
/*      */ 
/*  152 */       Element policy = auratx.getChild("POLICY");
/*  153 */       updateText(policy, "ZNUWCAT", "NB");
/*  154 */       updateText(policy, "ZNEXTSYS", "4");
/*  155 */       updateText(policy, "PRT1OPT", "Y");
/*  156 */       updateText(policy, "PRT2OPT", "Y");
/*  157 */       updateText(policy, "ZNGPCNO", "");
/*  158 */       updateText(policy, "STATCODE", "PS");
/*  159 */       updateText(policy, "CNTBRANCH", company);
/*  160 */       updateText(policy, "TTMPRCNO", this.tLNPContSchema.getContNo());
/*  161 */       updateText(policy, "Chdrnum", this.tLNPContSchema.getMainPolNo());
/*  162 */       updateText(policy, "OCCDATE", fomartDate(this.tLNPContSchema.getPValiDate()));
/*  163 */       updateText(policy, "HPROPDTE", fomartDate(this.tLNPContSchema.getPSignDate()));
/*  164 */       updateText(policy, "HPRRCVDT", fomartDate(this.tLNPAgentInfoSet.get(1).getP1()));
/*  165 */       updateText(policy, "ZDDTEDIF", turnNullToString(Integer.valueOf(PubFun.calInterval(turnNullToString(this.tLNPContSchema.getPSignDate()), 
/*  166 */         turnNullToString(this.tLNPAgentInfoSet.get(1).getP1()), "D"))));
/*      */ 
/*  169 */       Element policyOwner = policy.getChild("PolicyOwner");
/*  170 */       updateText(policyOwner, "OWNERSEL", "".equals(turnNullToString(this.tLNPAppntSchema.getAppntNo())) ? "01" : this.tLNPAppntSchema.getAppntNo());
/*  171 */       updateText(policyOwner, "SALUTL", "MR / MRS");
/*  172 */       updateText(policyOwner, "LSURNAME", this.tLNPAppntSchema.getAppntName());
/*  173 */       updateText(policyOwner, "DOB", fomartDate(this.tLNPAppntSchema.getAppntBirthday()));
/*  174 */       if (turnNullToString(this.tLNPAppntSchema.getAppntAgeType()).equals("Y"))
/*  175 */         updateText(policyOwner, "Age", turnNullToString(Integer.valueOf(this.tLNPAppntSchema.getAppntAge())));
/*      */       else {
/*  177 */         updateText(policyOwner, "ZDDAYS", turnNullToString(Integer.valueOf(this.tLNPAppntSchema.getAppntAge())));
/*      */       }
/*  179 */       updateText(policyOwner, "CLTSEX", mappingCode(this.tLNPAppntSchema.getAppntSex(), "BankPolicySex"));
/*  180 */       updateText(policyOwner, "MARRYD", "");
/*      */ 
/*  182 */       updateText(policyOwner, "ZACLTADDR", combAddress(this.tAppntAddressSchema, "2"));
/*  183 */       updateText(policyOwner, "CLTPCODE", this.tAppntAddressSchema.getCompanyZipCode());
/*  184 */       updateText(policyOwner, "ADDRTYPE", "1");
/*  185 */       updateText(policyOwner, "ZNBUSUT", this.tAppntAddressSchema.getGrpName());
/*  186 */       updateText(policyOwner, "CTRYCODE", this.tLNPAppntSchema.getNativePlace());
/*      */ 
/*  188 */       if ((this.tLNPAppntSchema.getNativePlace() == null) || (this.tLNPAppntSchema.getNativePlace() == "")) {
/*  189 */         updateText(policyOwner, "NATLTY", this.tLNPAppntSchema.getNativePlace());
/*      */       }
/*  191 */       else if ((this.tLNPAppntSchema.getNativePlace().equals("01")) || (this.tLNPAppntSchema.getNativePlace().equals("02"))) {
/*  192 */         updateText(policyOwner, "NATLTY", this.tLNPAppntSchema.getNativePlace());
/*      */       }
/*  195 */       else if ((this.tLNPAppntSchema.getNativePlace().equals("IR")) || (this.tLNPAppntSchema.getNativePlace().equals("SY")) || (this.tLNPAppntSchema.getNativePlace().equals("SD")) || (this.tLNPAppntSchema.getNativePlace().equals("CU")) || (this.tLNPAppntSchema.getNativePlace().equals("KP"))) {
/*  196 */         updateText(policyOwner, "NATLTY", "05");
/*      */       }
/*      */       else
/*      */       {
/*  200 */         updateText(policyOwner, "NATLTY", "03");
/*      */       }
/*  202 */       updateText(policyOwner, "CLRSKIND", "1");
/*  203 */       updateText(policyOwner, "RSKFLG", "1");
/*      */ 
/*  206 */       updateText(policyOwner, "IDNPRF", getAuraIdtype(mappingCode(this.tLNPAppntSchema.getIDType(), "BankCertType")));
/*  207 */       updateText(policyOwner, "SECUITYNO", this.tLNPAppntSchema.getIDNo());
/*  208 */       updateText(policyOwner, "EXPDTE", "1".equals(this.tLNPAppntSchema.getIDPerpetual()) ? fomartDate(this.tLNPAppntSchema.getIDValidity()) : fomartDate(mappingCode(this.tLNPAppntSchema.getIDPerpetual(), "BankCertificatesType")));
/*  209 */       updateText(policyOwner, "INCPRF", "");
/*  210 */       updateText(policyOwner, "INCDESC", "");
/*  211 */       updateText(policyOwner, "DECGRSAL", turnNullToString(fomartNum(Arith.mul(this.tLNPAppntSchema.getSalary(), 10000.0D))));
/*  212 */       updateText(policyOwner, "RMBLPHONE", this.tAppntAddressSchema.getPhone());
/*  213 */       updateText(policyOwner, "CLTPHONE", combPhone(this.tAppntAddressSchema.getMobileChs2(), this.tAppntAddressSchema.getCompanyPhone()));
/*  214 */       updateText(policyOwner, "RINTERNET", this.tAppntAddressSchema.getCompanyMail());
/*  215 */       updateText(policyOwner, "OCCPCODE", this.tLNPAppntSchema.getOccupationCode());
/*  216 */       updateText(policyOwner, "ZNPIDCPYID", mappingCode(this.tLNPAppntSchema.getHealth(), "BankIsOrNo"));
/*      */ 
/*  219 */       Element owrisk = policy.getChild("OWNRISKSILIST");
/*  220 */       updateText(owrisk, "ZNRSKCD", "");
/*  221 */       updateText(owrisk, "SUMINS", "");
/*      */ 
/*  223 */       updateText(policy, "BILLFREQ", mappingCode(turnNullToString(Integer.valueOf(this.tLNPContSchema.getPayIntv())), "BankFrequency"));
/*  224 */       updateText(policy, "ZNFPMOP", mappingCode(this.tLNPPaymentSchema.getPayMent1(), "BankRenewal"));
/*  225 */       updateText(policy, "MOP", mappingCode(this.tLNPPaymentSchema.getPayMent2(), "BankRenewal"));
/*  226 */       updateText(policy, "ZDIVOPT", mappingCode(this.tLNPBonusInfoSchema.getBonusWay(), "BankBonusPayMent"));
/*  227 */       updateText(policy, "ZNFOPT", mappingCode(this.tLNPBonusInfoSchema.getP2(), "BankOverDue"));
/*  228 */       updateText(policy, "CNTCURR", "CNY");
/*  229 */       updateText(policy, "BILLCURR", "CNY");
/*  230 */       updateText(policy, "REGISTER", "PRC");
/*  231 */       updateText(policy, "SRCEBUS", "3");
/*  232 */       if ((this.tLNPPolSet2.size() > 0) && ("2".equals(this.tLNPPolSet2.get(1).getRnewFlag()))) {
/*  233 */         updateText(policy, "SRCEBUS", this.saleChannel);
/*      */       }
/*  235 */       updateText(policy, "DLVRMODE", "01,02,03".indexOf(turnNullToString(this.tLNPAgentInfoSet.get(1).getP3())) == -1 ? "04" : mappingCode(this.tLNPAgentInfoSet.get(1).getP3(), "BankDeliveryType"));
/*      */ 
/*  237 */       updateText(policy, "ZAPSTADD", combAddress(this.tAppntAddressSchema, "1"));
/*  238 */       updateText(policy, "CLTPCODE03", this.tAppntAddressSchema.getHomeZipCode());
/*      */ 
/*  241 */       updateText(policy, "ZNAGNTSEL", this.tLNPAgentInfoSet.get(1).getP2());
/*  242 */       updateText(policy, "AGCOMRT", turnNullToString(Integer.valueOf(100 / this.tLNPAgentInfoSet.size())));
/*      */ 
/*  245 */       if (this.tLNPAgentInfoSet.size() == 2) {
/*  246 */         Element subAgent = policy.getChild("SubAgentList");
/*  247 */         updateText(subAgent, "ZNAGNTSEL01", this.tLNPAgentInfoSet.get(2).getAgentCode());
/*  248 */         updateText(subAgent, "SPLITC", turnNullToString(Integer.valueOf(100 / this.tLNPAgentInfoSet.size())));
/*      */       }
/*      */ 
/*  252 */       updateText(policy, "ZNCSMNAME", this.tLNPAgentInfoSet.get(1).getAgentCode());
/*  253 */       if ((this.tLNPPolSet2.size() > 0) && ("2".equals(this.tLNPPolSet2.get(1).getRnewFlag())) && (
/*  254 */         (this.saleChannel.equals("1")) || (this.saleChannel.equals("2")))) {
/*  255 */         updateText(policy, "ZNCSMNAME", "");
/*      */       }
/*      */ 
/*  259 */       Element insured = policy.getChild("INSLST").getChild("Insured");
/*  260 */       updateText(insured, "Life", "01");
/*      */ 
/*  263 */       Element inrisk = insured.getChild("INSRISKSILIST");
/*  264 */       updateText(inrisk, "ZNRSKCD02", "");
/*  265 */       updateText(inrisk, "SUMINS02", "");
/*      */ 
/*  267 */       Element insuredInfo = insured.getChild("InsuredInfo");
/*  268 */       updateText(insuredInfo, "LIFCNUM", "".equals(turnNullToString(this.tLNPInsuredSchema.getInsuredNo())) ? "01" : this.tLNPInsuredSchema.getInsuredNo());
/*  269 */       updateText(insuredInfo, "SALUTL02", "MR / MRS");
/*  270 */       updateText(insuredInfo, "LSURNAME02", this.tLNPInsuredSchema.getName());
/*  271 */       updateText(insuredInfo, "DOB02", fomartDate(this.tLNPInsuredSchema.getBirthday()));
/*  272 */       if (turnNullToString(this.tLNPInsuredSchema.getAppAgeType()).equals("Y"))
/*  273 */         updateText(insuredInfo, "Age02", turnNullToString(Integer.valueOf(this.tLNPInsuredSchema.getAppAge())));
/*      */       else {
/*  275 */         updateText(insuredInfo, "ZDDays02", turnNullToString(Integer.valueOf(this.tLNPInsuredSchema.getAppAge())));
/*      */       }
/*  277 */       updateText(insuredInfo, "CLTSEX02", mappingCode(this.tLNPInsuredSchema.getSex(), "BankPolicySex"));
/*  278 */       updateText(insuredInfo, "MARRYD02", "");
/*      */ 
/*  280 */       updateText(insuredInfo, "ZACLTADDR02", combAddress(this.tInsurAddressSchema, "2"));
/*  281 */       updateText(insuredInfo, "CLTPCODE02", this.tInsurAddressSchema.getCompanyZipCode());
/*  282 */       updateText(insuredInfo, "ADDRTYPE02", "1");
/*  283 */       updateText(insuredInfo, "ZNBUSUT02", this.tInsurAddressSchema.getGrpName());
/*  284 */       updateText(insuredInfo, "CTRYCODE02", this.tLNPInsuredSchema.getNativePlace());
/*      */ 
/*  287 */       if ((this.tLNPInsuredSchema.getNativePlace() == null) || (this.tLNPInsuredSchema.getNativePlace() == "")) {
/*  288 */         updateText(insuredInfo, "NATLTY02", this.tLNPInsuredSchema.getNativePlace());
/*      */       }
/*  290 */       else if ((this.tLNPInsuredSchema.getNativePlace().equals("01")) || (this.tLNPInsuredSchema.getNativePlace().equals("02"))) {
/*  291 */         updateText(insuredInfo, "NATLTY02", this.tLNPInsuredSchema.getNativePlace());
/*      */       }
/*      */       else {
/*  294 */         updateText(insuredInfo, "NATLTY02", "03");
/*      */       }
/*  296 */       updateText(insuredInfo, "CLRSKIND02", "1");
/*  297 */       updateText(insuredInfo, "RSKFLG02", "1");
/*  298 */       updateText(insuredInfo, "IDNPRF02", getAuraIdtype(mappingCode(this.tLNPInsuredSchema.getIDType(), "BankCertType")));
/*  299 */       updateText(insuredInfo, "SECUITYNO02", this.tLNPInsuredSchema.getIDNo());
/*  300 */       updateText(insuredInfo, "EXPDTE02", "1".equals(this.tLNPInsuredSchema.getIDPerpetual()) ? fomartDate(this.tLNPInsuredSchema.getIDValidity()) : fomartDate(mappingCode(this.tLNPInsuredSchema.getIDPerpetual(), "BankCertificatesType")));
/*  301 */       updateText(insuredInfo, "INCPRF02", "");
/*  302 */       updateText(insuredInfo, "INCDESC02", "");
/*  303 */       updateText(insuredInfo, "DECGRSAL02", turnNullToString(fomartNum(Arith.mul(this.tLNPInsuredSchema.getSalary(), 10000.0D))));
/*  304 */       updateText(insuredInfo, "RMBLPHONE02", this.tInsurAddressSchema.getPhone());
/*  305 */       updateText(insuredInfo, "CLTPHONE02", combPhone(this.tInsurAddressSchema.getMobileChs2(), this.tInsurAddressSchema.getCompanyPhone()));
/*  306 */       updateText(insuredInfo, "RINTERNET02", this.tInsurAddressSchema.getCompanyMail());
/*  307 */       updateText(insuredInfo, "OCCPCODE02", this.tLNPInsuredSchema.getOccupationCode());
/*  308 */       updateText(insuredInfo, "ZNPIDCPYID02", mappingCode(this.tLNPInsuredSchema.getHealth(), "BankIsOrNo"));
/*      */ 
/*  310 */       updateText(insured, "RELATION", mappingCode(this.tLNPAppntSchema.getRelationToInsured(), "BankRelationship"));
/*  311 */       updateText(insured, "SELECTION", "");
/*      */ 
/*  314 */       updateText(insured, "HEIGHT", mappingQues("A05", "insur", this.tLNPContSchema.getContNo(), this.saleChannel));
/*  315 */       updateText(insured, "WEIGHT", mappingQues("A06", "insur", this.tLNPContSchema.getContNo(), this.saleChannel));
/*  316 */       updateText(insured, "SMOKING", "");
/*  317 */       updateText(insured, "OCCUP", this.tLNPInsuredSchema.getOccupationCode());
/*      */ 
/*  320 */       Element questionArea = insured.getChild("Questionare");
/*  321 */       if ("2".equals(this.saleChannel))
/*  322 */         updateText(questionArea, "QUESTSET", "MTQTM");
/*      */       else {
/*  324 */         updateText(questionArea, "QUESTSET", "MTQBA");
/*      */       }
/*      */ 
/*  328 */       LNPCodeSet codeSet = new LNPCodeSet();
/*  329 */       LNPCodeDB db = new LNPCodeDB(this.con);
/*      */ 
/*  331 */       db.setCodeType("QueCodeMapping");
/*  332 */       db.setComCode(this.saleChannel);
/*  333 */       codeSet = db.query();
/*  334 */       Element questionList = questionArea.getChild("QuestionList");
/*  335 */       Element question = questionList.getChild("Question");
/*  336 */       questionList.removeContent();
/*  337 */       for (int i = 1; i <= codeSet.size(); i++) {
/*  338 */         Element tempElement = (Element)question.clone();
/*      */ 
/*  341 */         updateText(tempElement, "QUESTIDF", codeSet.get(i).getCodeName());
/*  342 */         updateText(tempElement, "ANSWER", mappingQues(codeSet.get(i).getCodeName(), codeSet.get(i).getOtherSign(), this.tLNPContSchema.getContNo(), this.saleChannel));
/*      */ 
/*  344 */         questionList.addContent(tempElement);
/*      */       }
/*  346 */       updateText(insured, "HUWDCDTE", "99999999");
/*      */ 
/*  349 */       Element coverageList = insured.getChild("COVLST");
/*  350 */       Element coverageInfo = coverageList.getChild("COVINF");
/*  351 */       coverageList.removeContent();
/*  352 */       int i = 1; for (int j = 1; i <= this.tLNPPolSet.size(); i++) {
/*  353 */         Element tempCoverage = (Element)coverageInfo.clone();
/*  354 */         LNPPolSchema tempPol = this.tLNPPolSet.get(i);
/*  355 */         updateText(tempCoverage, "Coverage", "01");
/*  356 */         if (!"M".equalsIgnoreCase(tempPol.getSubFlag()))
/*  357 */           updateText(tempCoverage, "RIDER", "0" + j++);
/*      */         else {
/*  359 */           updateText(tempCoverage, "RIDER", "00");
/*      */         }
/*  361 */         updateText(tempCoverage, "ZNPRDCODE", tempPol.getRiskCode());
/*  362 */         updateText(tempCoverage, "SUMIN", turnNullToString(fomartNum(tempPol.getAmnt())));
/*      */ 
/*  364 */         if ("A".equals(tempPol.getInsuYearFlag())) {
/*  365 */           updateText(tempCoverage, "RCESSAGE", turnNullToString(Integer.valueOf(tempPol.getInsuYear())));
/*  366 */           updateText(tempCoverage, "RCESSTRM", "0");
/*      */         } else {
/*  368 */           updateText(tempCoverage, "RCESSTRM", turnNullToString(Integer.valueOf(tempPol.getInsuYear())));
/*  369 */           updateText(tempCoverage, "RCESSAGE", "0");
/*      */         }
/*  371 */         if ("A".equals(tempPol.getPayEndYearFlag())) {
/*  372 */           updateText(tempCoverage, "PCESSAGE", turnNullToString(Integer.valueOf(tempPol.getPayEndYear())));
/*  373 */           updateText(tempCoverage, "PCESSTRM", "0");
/*      */         } else {
/*  375 */           updateText(tempCoverage, "PCESSTRM", "1000".equals(turnNullToString(Integer.valueOf(tempPol.getPayEndYear()))) ? "1" : turnNullToString(Integer.valueOf(tempPol.getPayEndYear())));
/*  376 */           updateText(tempCoverage, "PCESSAGE", "0");
/*      */         }
/*  378 */         if ("A".equals(tempPol.getGetYearFlag()))
/*      */         {
/*  381 */           if ((tempPol.getRiskCode().equals("LA11BA")) && 
/*  382 */             (turnNullToString(Integer.valueOf(tempPol.getInsuYear())).equals("20"))) {
/*  383 */             updateText(tempCoverage, "BCESSTRM", "11");
/*  384 */           } else if ((tempPol.getRiskCode().equals("LA11BA")) && 
/*  385 */             (turnNullToString(Integer.valueOf(tempPol.getInsuYear())).equals("25"))) {
/*  386 */             updateText(tempCoverage, "BCESSTRM", "16");
/*      */           } else {
/*  388 */             updateText(tempCoverage, "BCESSAGE", turnNullToString(Integer.valueOf(tempPol.getGetYear())));
/*  389 */             updateText(tempCoverage, "BCESSTRM", "0");
/*      */           }
/*      */         } else {
/*  392 */           updateText(tempCoverage, "BCESSTRM", turnNullToString(Integer.valueOf(tempPol.getGetYear())));
/*  393 */           updateText(tempCoverage, "BCESSAGE", "0");
/*      */         }
/*      */ 
/*  396 */         updateText(tempCoverage, "MORTCLS", "2");
/*  397 */         updateText(tempCoverage, "INSTPRM", turnNullToString(fomartNum(tempPol.getPrem())));
/*      */ 
/*  399 */         updateText(tempCoverage, "ZPRFLG", "N");
/*      */ 
/*  401 */         if ((this.tLNPInvestmentInfoSchema != null) && (!turnNullToString(this.tLNPInvestmentInfoSchema.getTermInvestment()).equals("")) && 
/*  402 */           (this.tLNPInvestmentInfoSchema.getMonthPlusPrem() > 0.0D) && (Double.parseDouble(this.tLNPInvestmentInfoSchema.getTermInvestment()) > 0.0D)) {
/*  403 */           updateText(tempCoverage, "LMPCNT", this.tLNPInvestmentInfoSchema.getPayExtraPremFlag());
/*  404 */           updateText(tempCoverage, "ZPRFLG", "Y");
/*  405 */           updateText(tempCoverage, "ZNINVAMT", turnNullToString(fomartNum(this.tLNPInvestmentInfoSchema.getMonthPlusPrem())));
/*  406 */           updateText(tempCoverage, "ZNTRM", this.tLNPInvestmentInfoSchema.getTermInvestment());
/*      */         }
/*      */ 
/*  409 */         updateText(tempCoverage, "ZUNIT", "1");
/*  410 */         updateText(tempCoverage, "LIVESNO", "1");
/*  411 */         updateText(tempCoverage, "PAYCLT", this.tLNPAppntSchema.getAppntNo());
/*      */ 
/*  413 */         Element payBankInfor = tempCoverage.getChild("PayBankInfor");
/*  414 */         if ("02".equals(this.tLNPPaymentSchema.getPayMent1())) {
/*  415 */           updateText(payBankInfor, "BANKCODE", "");
/*  416 */           updateText(payBankInfor, "BANKKEY", this.tLNPPaymentSchema.getBankCode());
/*  417 */           updateText(payBankInfor, "BANKACCKEY", this.tLNPPaymentSchema.getAccount());
/*  418 */           updateText(payBankInfor, "BANKDESC", this.tLNPAppntSchema.getAppntName());
/*  419 */           updateText(payBankInfor, "BNKACTYP", "");
/*  420 */           updateText(payBankInfor, "CURRCODE", "CNY");
/*  421 */           updateText(payBankInfor, "DATEFROM", fomartDate(this.tLNPContSchema.getPValiDate()));
/*  422 */           updateText(payBankInfor, "TIMESUSE", "");
/*      */         }
/*      */ 
/*  425 */         updateText(tempCoverage, "FREQANN", "-1".equals(tempPol.getStandbyFlag3()) ? "" : mappingCode(tempPol.getStandbyFlag3(), "BankAnnuityReceive"));
/*  426 */         updateText(tempCoverage, "ADVANCE", "");
/*  427 */         updateText(tempCoverage, "ARREARS", "");
/*  428 */         updateText(tempCoverage, "GUARPERD", "");
/*  429 */         updateText(tempCoverage, "WITHPROP", "");
/*  430 */         updateText(tempCoverage, "WITHOPROP", "");
/*  431 */         updateText(tempCoverage, "NOMLIFE", "");
/*  432 */         updateText(tempCoverage, "DTHPERCN", "");
/*  433 */         updateText(tempCoverage, "DTHPERCO", "");
/*      */ 
/*  435 */         Element payment = tempCoverage.getChild("Payment");
/*  436 */         updateText(payment, "PAYCLT02", "");
/*  437 */         updateText(payment, "CLTYPE", "");
/*  438 */         updateText(payment, "RGPYMOP", "");
/*  439 */         updateText(payment, "REGPAYFREQ", "-1".equals(tempPol.getStandbyFlag3()) ? "" : mappingCode(tempPol.getStandbyFlag3(), "BankAnnuityReceive"));
/*  440 */         updateText(payment, "PRCNT", "");
/*  441 */         updateText(payment, "CLAIMCUR", "CNY");
/*      */ 
/*  443 */         if (this.tLNPInvestmentInfoSchema != null)
/*  444 */           updateText(tempCoverage, "RSUNIN", mappingCode(this.tLNPInvestmentInfoSchema.getHesInvestment(), "BankInvestment"));
/*  445 */         updateText(tempCoverage, "PRCAMTIND", "");
/*      */ 
/*  449 */         Element PRMFundList = tempCoverage.getChild("PRMFLST");
/*      */ 
/*  451 */         Element RGUFundList = tempCoverage.getChild("RGUFLST");
/*      */ 
/*  453 */         for (int x = 1; x <= 10; x++) {
/*  454 */           if (x < 10) {
/*  455 */             updateText(PRMFundList, "VRTFND0" + x, "0");
/*  456 */             updateText(PRMFundList, "UALPRC0" + x, "0");
/*  457 */             updateText(RGUFundList, "ZAVRTFND0" + x, "0");
/*  458 */             updateText(RGUFundList, "ZNSPLAMT0" + x, "0");
/*      */           }
/*      */           else {
/*  461 */             updateText(PRMFundList, "VRTFND" + x, "0");
/*  462 */             updateText(PRMFundList, "UALPRC" + x, "0");
/*  463 */             updateText(RGUFundList, "ZAVRTFND" + x, "0");
/*  464 */             updateText(RGUFundList, "ZNSPLAMT" + x, "0");
/*      */           }
/*      */ 
/*      */         }
/*      */ 
/*  469 */         for (int x = 1; (x <= this.tLNpInvestmentAccountInfoSet.size()) && (x <= 10); x++) {
/*  470 */           if (x < 10) {
/*  471 */             updateText(PRMFundList, "VRTFND0" + x, this.tLNpInvestmentAccountInfoSet.get(x).getInvestAccountCode());
/*  472 */             updateText(PRMFundList, "UALPRC0" + x, turnNullToString(Double.valueOf(Arith.mul(this.tLNpInvestmentAccountInfoSet.get(x).getInvestAccountRate(), 100.0D))));
/*      */           } else {
/*  474 */             updateText(PRMFundList, "VRTFND" + x, this.tLNpInvestmentAccountInfoSet.get(x).getInvestAccountCode());
/*  475 */             updateText(PRMFundList, "UALPRC" + x, turnNullToString(Double.valueOf(Arith.mul(this.tLNpInvestmentAccountInfoSet.get(x).getInvestAccountRate(), 100.0D))));
/*      */           }
/*      */         }
/*  478 */         for (int x = 1; (x <= this.tLNpInvestmentAccountInfoSet.size()) && (x <= 10); x++) {
/*  479 */           if (x < 10) {
/*  480 */             updateText(RGUFundList, "ZAVRTFND0" + x, this.tLNpInvestmentAccountInfoSet.get(x).getInvestAccountCode());
/*  481 */             updateText(RGUFundList, "ZNSPLAMT0" + x, turnNullToString(Double.valueOf(Arith.mul(this.tLNpInvestmentAccountInfoSet.get(x).getInvestAccountRate(), 100.0D))));
/*      */           } else {
/*  483 */             updateText(RGUFundList, "ZAVRTFND" + x, this.tLNpInvestmentAccountInfoSet.get(x).getInvestAccountCode());
/*  484 */             updateText(RGUFundList, "ZNSPLAMT" + x, turnNullToString(Double.valueOf(Arith.mul(this.tLNpInvestmentAccountInfoSet.get(x).getInvestAccountRate(), 100.0D))));
/*      */           }
/*      */         }
/*      */ 
/*  488 */         updateText(tempCoverage, "ZACOVBAK01", "");
/*  489 */         updateText(tempCoverage, "ZACOVBAK02", "");
/*  490 */         updateText(tempCoverage, "ZACOVBAK03", "");
/*  491 */         updateText(tempCoverage, "ZACOVBAK04", "");
/*  492 */         updateText(tempCoverage, "ZACOVBAK05", "");
/*      */ 
/*  494 */         coverageList.addContent(tempCoverage);
/*      */       }
/*      */ 
/*  498 */       Element bnfList = policy.getChild("BeneficiaryList");
/*  499 */       Element bnf = bnfList.getChild("Beneficiary");
/*  500 */       bnfList.removeContent();
/*      */ 
/*  503 */       if (this.tLNPInsuredSchema.getInsuredPeoples() > 0) {
/*  504 */         for (int x = 1; x <= this.tLNPBnfSet.size(); x++) {
/*  505 */           LNPBnfSchema tempSchema = this.tLNPBnfSet.get(x);
/*  506 */           Element tempBnf = (Element)bnf.clone();
/*  507 */           updateText(tempBnf, "BNYTYPE", "0" + tempSchema.getBenefitType());
/*  508 */           updateText(tempBnf, "BNYSEL", tempSchema.getBnfNo());
/*  509 */           updateText(tempBnf, "SALUTL04", "MR / MRS");
/*  510 */           updateText(tempBnf, "LSURNAME04", tempSchema.getBnfName());
/*  511 */           updateText(tempBnf, "DOB04", fomartDate(tempSchema.getBnfBirthday()));
/*  512 */           updateText(tempBnf, "CLTSEX04", mappingCode(tempSchema.getBnfSex(), "BankPolicySex"));
/*  513 */           updateText(tempBnf, "MARRYD04", "");
/*  514 */           updateText(tempBnf, "ZACLTADDR04", "");
/*  515 */           updateText(tempBnf, "ADDRTYPE04", "");
/*  516 */           updateText(tempBnf, "ZNBUSUT04", "");
/*  517 */           updateText(tempBnf, "CTRYCODE04", "");
/*  518 */           updateText(tempBnf, "NATLTY04", "");
/*  519 */           updateText(tempBnf, "IDNPRF04", getAuraIdtype(mappingCode(tempSchema.getIDType(), "BankCertType")));
/*  520 */           updateText(tempBnf, "SECUITYNO04", tempSchema.getIDNo());
/*  521 */           updateText(tempBnf, "EXPDTE04", "1".equals(tempSchema.getIDPerpetual()) ? fomartDate(tempSchema.getIDValidity()) : fomartDate(mappingCode(tempSchema.getIDPerpetual(), "BankCertificatesType")));
/*  522 */           updateText(tempBnf, "ZNPIDCPYID04", "");
/*  523 */           updateText(tempBnf, "CLTRELN02", mappingCode(tempSchema.getRelationToInsured(), "BankBenefitAndInsured"));
/*  524 */           updateText(tempBnf, "BNYPC", turnNullToString(Double.valueOf(tempSchema.getBenefitRate())));
/*  525 */           updateText(tempBnf, "ZBNYTLVL", Integer.parseInt(tempSchema.getBenefitOrder()) < 10 ? "0" + tempSchema.getBenefitOrder() : tempSchema.getBenefitOrder());
/*  526 */           updateText(tempBnf, "EFFDATE", "");
/*  527 */           updateText(tempBnf, "ZDCLMPLN", mappingCode(this.tLNPInsuredSchema.getCreditGrade(), "BankIsOrNo"));
/*  528 */           bnfList.addContent(tempBnf);
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*  533 */       if ("02".equals(this.tLNPPaymentSchema.getPayMent1())) {
/*  534 */         Element FRTRecBank = policy.getChild("FRTRecBank");
/*  535 */         updateText(FRTRecBank, "BANKKEY02", this.tLNPPaymentSchema.getBankCode());
/*  536 */         updateText(FRTRecBank, "BANKACCKEY02", this.tLNPPaymentSchema.getAccount());
/*  537 */         updateText(FRTRecBank, "BANKDESC02", this.tLNPAppntSchema.getAppntName());
/*  538 */         updateText(FRTRecBank, "BNKACTYP02", "");
/*  539 */         updateText(FRTRecBank, "CURRCODE02", "");
/*  540 */         updateText(FRTRecBank, "DATEFROM01", this.tLNPContSchema.getPValiDate());
/*  541 */         updateText(FRTRecBank, "DATETO", "");
/*      */       }
/*      */ 
/*  544 */       if ("02".equals(this.tLNPPaymentSchema.getPayMent2())) {
/*  545 */         Element SEQRecBank = policy.getChild("SEQRecBank");
/*  546 */         updateText(SEQRecBank, "BANKKEY03", this.tLNPPaymentSchema.getBankCode());
/*  547 */         updateText(SEQRecBank, "BANKACCKEY03", this.tLNPPaymentSchema.getAccount());
/*  548 */         updateText(SEQRecBank, "BANKDESC03", this.tLNPAppntSchema.getAppntName());
/*  549 */         updateText(SEQRecBank, "BNKACTYP03", "");
/*  550 */         updateText(SEQRecBank, "CURRCODE03", "CNY");
/*  551 */         updateText(SEQRecBank, "DATEFROM02", this.tLNPContSchema.getPValiDate());
/*  552 */         updateText(SEQRecBank, "DATETO02", "");
/*      */       }
/*      */ 
/*  556 */       updateText(policy, "TRANDATEX", "");
/*  557 */       updateText(policy, "BANKCODER", "");
/*  558 */       updateText(policy, "TCHQDATE", "");
/*  559 */       updateText(policy, "BANKDESC01R", "1");
/*  560 */       updateText(policy, "BANKDESC03R", "");
/*  561 */       updateText(policy, "RFCODE", "CN");
/*  562 */       updateText(policy, "RFNUM", "");
/*  563 */       updateText(policy, "PAYTYPE", "");
/*  564 */       updateText(policy, "DOCORIGAMT", "");
/*  565 */       updateText(policy, "ZNOVRPAYOP", mappingCode(this.tLNPBonusInfoSchema.getP1(), "BankIsOrNo"));
/*      */ 
/*  568 */       LNPPolSet tset = new LNPPolDB(this.con).executeQuery("select * from lnppol where contno='" + this.tContNo + "' and RiskVersion is not null and RiskVersion<>'' and RnewFlag='1'");
/*  569 */       if (tset.size() > 0) {
/*  570 */         Element packageInfo = policy.getChild("PackageInfo");
/*  571 */         System.out.println(tset.get(1).getRiskVersion());
/*  572 */         updateText(packageInfo, "ZNPKGCODE", tset.get(1).getRiskVersion());
/*  573 */         updateText(packageInfo, "TOTPRE", turnNullToString(tset.get(1).getRemark()));
/*  574 */         updateText(packageInfo, "ZTOTSI", "");
/*      */       }
/*      */ 
/*  578 */       Element remark = policy.getChild("GeneralRemark");
/*  579 */       updateText(remark, "ALINE01", "");
/*  580 */       updateText(remark, "ALINE02", "");
/*      */ 
/*  582 */       updateText(policy, "SACSCODE", "");
/*  583 */       updateText(policy, "SACSTYPE", "");
/*  584 */       updateText(policy, "CAMPAIGN", "");
/*  585 */       updateText(policy, "ZNPRJTCD", "");
/*  586 */       updateText(policy, "ZNEPOLFLG", "");
/*  587 */       updateText(policy, "ZNBNKODR", "");
/*  588 */       updateText(policy, "ZNDISPER", "");
/*  589 */       updateText(policy, "ZNSPCTYP", "");
/*  590 */       updateText(policy, "ZNBILLNO", "");
/*  591 */       updateText(policy, "ZNINVBNK", "");
/*  592 */       updateText(policy, "ZNVIPIND", mappingCode(this.tLNPAppntSchema.getAppntGrade(), "BankIsOrNo"));
/*      */ 
/*  594 */       updateText(policy, "ZAPOLFLD1", "");
/*  595 */       updateText(policy, "ZAPOLFLD2", "");
/*  596 */       updateText(policy, "ZAPOLFLD3", "");
/*  597 */       updateText(policy, "ZAPOLFLD4", "");
/*  598 */       updateText(policy, "ZAPOLFLD5", "");
/*      */ 
/*  600 */       Element hisIn = auratx.getChild("HisIn");
/*  601 */       Element polhis = hisIn.getChild("POLHIS");
/*  602 */       Element inPolicyOwner = polhis.getChild("PolicyOwner");
/*  603 */       updateText(inPolicyOwner, "OWNERSEL05", "".equals(turnNullToString(this.tLNPAppntSchema.getAppntNo())) ? "01" : this.tLNPAppntSchema.getAppntNo());
/*  604 */       updateText(inPolicyOwner, "LSURNAME05", this.tLNPAppntSchema.getAppntName());
/*  605 */       updateText(inPolicyOwner, "DOB05", "");
/*  606 */       updateText(inPolicyOwner, "CLTSEX05", "");
/*  607 */       updateText(inPolicyOwner, "SECUITYNO05", "");
/*  608 */       updateText(inPolicyOwner, "RMBLPHONE05", "");
/*  609 */       updateText(inPolicyOwner, "CLTPHONE05", "");
/*      */ 
/*  611 */       Element inInsured = polhis.getChild("InsuredList").getChild("Insured");
/*  612 */       updateText(inInsured, "LIFCNUM06", "".equals(turnNullToString(this.tLNPInsuredSchema.getInsuredNo())) ? "01" : this.tLNPInsuredSchema.getInsuredNo());
/*  613 */       updateText(inInsured, "LSURNAME06", this.tLNPInsuredSchema.getName());
/*  614 */       updateText(inInsured, "DOB06", "");
/*  615 */       updateText(inInsured, "CLTSEX06", "");
/*  616 */       updateText(inInsured, "SECUITYNO06", "");
/*  617 */       updateText(inInsured, "RMBLPHONE06", "");
/*  618 */       updateText(inInsured, "CLTPHONE06", "");
/*      */ 
/*  620 */       List benefList = polhis.getChildren("BeneficiaryList");
/*  621 */       Element benLst = (Element)benefList.get(benefList.size() - 1);
/*  622 */       Element beneficiary = benLst.getChild("Beneficiary");
/*  623 */       benLst.removeContent();
/*  624 */       for (int x = 1; x <= this.tLNPBnfSet.size(); x++) {
/*  625 */         LNPBnfSchema tempSchema = this.tLNPBnfSet.get(x);
/*  626 */         Element benef = (Element)beneficiary.clone();
/*  627 */         updateText(benef, "LSURNAME07", tempSchema.getBnfName());
/*  628 */         updateText(benef, "BNYSEL07", "");
/*  629 */         updateText(benef, "DOB07", "");
/*  630 */         updateText(benef, "CLTSEX07", "");
/*  631 */         updateText(benef, "SECUITYNO07", "");
/*      */       }
/*      */ 
/*  634 */       Element policiInfo = polhis.getChild("PolicyInfo");
/*      */ 
/*  636 */       updateText(policiInfo, "CNTBRANCH02", company);
/*  637 */       updateText(policiInfo, "TTMPRCNO02", this.tContNo);
/*  638 */       updateText(policiInfo, "CHDRNUM02", this.tLNPContSchema.getMainPolNo());
/*  639 */       updateText(policiInfo, "ZNAGNTSEL02", this.tLNPAgentInfoSet.get(1).getAgentCode());
/*  640 */       if ((this.tLNPPolSet2.size() > 0) && ("2".equals(this.tLNPPolSet2.get(1).getRnewFlag())) && (
/*  641 */         (this.saleChannel.equals("1")) || (this.saleChannel.equals("2")))) {
/*  642 */         updateText(policiInfo, "ZNAGNTSEL02", "");
/*      */       }
/*      */ 
/*  645 */       updateText(policiInfo, "CHDRTYPE", "");
/*  646 */       updateText(policiInfo, "ZNCSMNAME02", "");
/*  647 */       updateText(policiInfo, "HPROPDTE02", fomartDate(this.tLNPContSchema.getPSignDate()));
/*  648 */       updateText(policiInfo, "LIFE02", "01");
/*      */ 
/*  650 */       Element covlist = policiInfo.getChild("COVLIST");
/*  651 */       policiInfo.removeContent(covlist);
/*  652 */       int i = 1; for (int j = 1; i <= this.tLNPPolSet.size(); i++) {
/*  653 */         Element tempCovlist = (Element)covlist.clone();
/*  654 */         LNPPolSchema tempPol = this.tLNPPolSet.get(i);
/*  655 */         updateText(tempCovlist, "COVERAGE02", "01");
/*  656 */         if (!"M".equalsIgnoreCase(tempPol.getSubFlag()))
/*  657 */           updateText(tempCovlist, "RIDER02", "0" + j++);
/*      */         else {
/*  659 */           updateText(tempCovlist, "RIDER02", "00");
/*      */         }
/*  661 */         updateText(tempCovlist, "ZNPRDCODE02", tempPol.getRiskCode());
/*  662 */         if ("A".equals(tempPol.getInsuYearFlag())) {
/*  663 */           updateText(tempCovlist, "RCESSAGE02", turnNullToString(Integer.valueOf(tempPol.getInsuYear())));
/*  664 */           updateText(tempCovlist, "RCESSTRM02", "0");
/*      */         } else {
/*  666 */           updateText(tempCovlist, "RCESSAGE02", "0");
/*  667 */           updateText(tempCovlist, "RCESSTRM02", turnNullToString(Integer.valueOf(tempPol.getInsuYear())));
/*      */         }
/*  669 */         policiInfo.addContent(tempCovlist);
/*      */       }
/*  671 */       return true;
/*      */     }
/*      */     catch (Exception e) {
/*  674 */       e.printStackTrace();
/*  675 */     }return false;
/*      */   }
/*      */ 
/*      */   protected boolean getInputData(String tContNo)
/*      */   {
/*      */     try
/*      */     {
/*  687 */       this.valiPassFlag = true;
/*  688 */       if ((tContNo == null) || (tContNo.equals(""))) {
/*  689 */         return this.valiPassFlag = 0;
/*      */       }
/*      */ 
/*  692 */       LNPContDB tLNPContDB = new LNPContDB(this.con);
/*  693 */       tLNPContDB.setContNo(tContNo);
/*  694 */       if (!tLNPContDB.getInfo()) {
/*  695 */         this.message = "\u83B7\u53D6\u6295\u4FDD\u4E66\u4FE1\u606F\u5931\u8D25\uFF01";
/*  696 */         return this.valiPassFlag = 0;
/*      */       }
/*  698 */       this.tLNPContSchema = tLNPContDB.getSchema();
/*  699 */       String msg = "\u8BF7\u5B8C\u5584\u201C\u57FA\u7840\u4FE1\u606F\u201D\u90E8\u5206\u7684\u4FE1\u606F\u9879\uFF01";
/*  700 */       if ((turnNullToString(this.tLNPContSchema.getManageCom()).equals("")) || (turnNullToString(this.tLNPContSchema.getPValiDate()).equals("")) || 
/*  701 */         (turnNullToString(this.tLNPContSchema.getPSignDate()).equals(""))) {
/*  702 */         this.message = msg;
/*  703 */         return this.valiPassFlag = 0;
/*      */       }
/*      */ 
/*  708 */       this.tLNPPolSet = new LNPPolDB(this.con).executeQuery("select * from LNPPol where contno='" + tContNo + "'");
/*  709 */       if (this.tLNPPolSet.size() <= 0) {
/*  710 */         this.message = "\u8BF7\u5148\u586B\u5199\u9669\u79CD\u4FE1\u606F\uFF01";
/*  711 */         return this.valiPassFlag = 0;
/*      */       }
/*  713 */       this.tLNPPolSet2 = this.tLNPPolSet;
/*  714 */       this.saleChannel = turnToCode(this.tLNPPolSet2.get(1).getUWTime());
/*      */ 
/*  716 */       this.tLNPPolSet = new LNPPolDB(this.con).executeQuery("select * from lnppol where contno='" + tContNo + "' and (RiskVersion is null or RiskVersion='')");
/*  717 */       String msg = "\u8BF7\u5B8C\u5584\u201C\u6295\u4FDD\u4E8B\u9879\u201D\u4E2D\u201C\u9669\u79CD\u4FE1\u606F\u201D\u90E8\u5206\u7684\u4FE1\u606F\u9879\uFF01";
/*  718 */       for (int i = 1; i <= this.tLNPPolSet.size(); i++) {
/*  719 */         LNPPolSchema tSchema = this.tLNPPolSet.get(i);
/*      */ 
/*  721 */         if ((turnNullToString(tSchema.getRiskVersion()).equals("")) && (
/*  722 */           (turnNullToString(Integer.valueOf(tSchema.getPayIntv())).equals("")) || (turnNullToString(tSchema.getRiskCode()).equals("")) || 
/*  723 */           ((turnNullToString(Double.valueOf(tSchema.getAmnt())).equals("")) && (turnNullToString(Double.valueOf(tSchema.getPrem())).equals(""))) || 
/*  724 */           (tSchema.getAmnt() < 0.0D) || (tSchema.getPrem() < 0.0D) || 
/*  725 */           (tSchema.getInsuYear() < 0))) {
/*  726 */           this.message = msg;
/*  727 */           return this.valiPassFlag = 0;
/*      */         }
/*      */ 
/*  731 */         if ("02".equals(tSchema.getKindCode())) {
/*  732 */           LNPInvestmentAccountInfoSet investSet = new LNPInvestmentAccountInfoSet();
/*  733 */           investSet = new LNPInvestmentAccountInfoDB(this.con).executeQuery("select * from LNPInvestmentAccountInfo where contno='" + tContNo + "'");
/*  734 */           double sumRate = 0.0D;
/*  735 */           for (int j = 1; j <= investSet.size(); j++) {
/*  736 */             sumRate = Arith.add(sumRate, investSet.get(j).getInvestAccountRate());
/*      */           }
/*  738 */           System.out.println("\u6295\u8FDE\u9669(VUL/VA),\u57FA\u672C\u4FDD\u8D39\u6295\u8D44\u767E\u5206\u6BD4--->" + sumRate);
/*  739 */           if (sumRate != 1.0D) {
/*  740 */             this.message = "\u6295\u8FDE\u9669(VUL/VA),\u57FA\u672C\u4FDD\u8D39\u6295\u8D44\u767E\u5206\u6BD4\u603B\u548C\u9700\u7B49\u4E8E100% \uFF01";
/*  741 */             return this.valiPassFlag = 0;
/*      */           }
/*      */ 
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*  748 */       LNPCUWMasterDB cuw = new LNPCUWMasterDB(this.con);
/*  749 */       cuw.setContNo(tContNo);
/*  750 */       if (cuw.getInfo()) {
/*  751 */         this.tLNPCUWMasterSchema = cuw.getSchema();
/*      */       }
/*      */ 
/*  754 */       this.tLNPUWMasterSet = new LNPUWMasterDB(this.con).executeQuery("select * from LNPUWMaster where ContNo='" + tContNo + "'");
/*      */ 
/*  757 */       this.tLNPAppntSchema = new LNPAppntDB(this.con).executeQuery("select * from lnpappnt where contno='" + tContNo + "'").get(1);
/*  758 */       this.tAppntAddressSchema = new LNPAddressDB(this.con).executeQuery("select * from lnpaddress a where  exists(select 1 from lnpappnt b where a.customerid=b.appntid  and b.contno='" + tContNo + "')").get(1);
/*  759 */       if ((this.tLNPAppntSchema == null) || (this.tAppntAddressSchema == null)) {
/*  760 */         this.message = "\u7F3A\u5931\u6295\u4FDD\u4EBA\u4FE1\u606F\uFF01";
/*  761 */         return this.valiPassFlag = 0;
/*      */       }
/*  763 */       String msg = "\u8BF7\u5B8C\u5584\u201C\u5BA2\u6237\u4FE1\u606F\u201D\u4E2D\u201C\u6295\u4FDD\u4EBA\u4FE1\u606F\u201D\u90E8\u5206\u7684\u4FE1\u606F\u9879\uFF01";
/*  764 */       LNPAppntSchema tSchema = this.tLNPAppntSchema;
/*  765 */       if ((turnNullToString(tSchema.getAppntName()).equals("")) || (turnNullToString(Integer.valueOf(tSchema.getAppntAge())).equals("")) || 
/*  766 */         (turnNullToString(tSchema.getAppntSex()).equals("")) || (turnNullToString(tSchema.getAppntBirthday()).equals("")) || 
/*  767 */         (turnNullToString(this.tAppntAddressSchema.getCompanyAddress()).equals("")) || 
/*  768 */         (turnNullToString(this.tAppntAddressSchema.getCompanyZipCode()).equals("")) || (turnNullToString(tSchema.getNativePlace()).equals("")) || 
/*  769 */         (turnNullToString(tSchema.getIDType()).equals("")) || (turnNullToString(tSchema.getIDNo()).equals("")) || 
/*  770 */         (turnNullToString(tSchema.getRelationToInsured()).equals(""))) {
/*  771 */         this.message = msg;
/*  772 */         return this.valiPassFlag = 0;
/*      */       }
/*      */ 
/*  776 */       this.tCRSInfoSchema = new CRSInfoDB(this.con).executeQuery("select * from crsinfo where contno='" + tContNo + "'").get(1);
/*  777 */       if (this.tCRSInfoSchema == null) {
/*  778 */         this.message = "\u7F3A\u5931CRS\u4FE1\u606F\uFF01";
/*  779 */         return this.valiPassFlag = 0;
/*      */       }
/*      */ 
/*  782 */       CRSInfoSchema cSchema = this.tCRSInfoSchema;
/*  783 */       String crsmsg = "\u8BF7\u5B8C\u5584\u201C\u5BA2\u6237\u4FE1\u606F\u201D\u4E2D\u201C\u4E2A\u4EBA\u7A0E\u6536\u5C45\u6C11\u8EAB\u4EFD\u58F0\u660E\u6587\u4EF6\u201D\u90E8\u5206\u7684\u4FE1\u606F\u9879\uFF01";
/*  784 */       boolean crsflag = validateCRS(cSchema, tSchema);
/*  785 */       if (!crsflag) {
/*  786 */         this.message = crsmsg;
/*  787 */         return this.valiPassFlag = 0;
/*      */       }
/*      */ 
/*  797 */       this.tLNPInsuredSchema = new LNPInsuredDB(this.con).executeQuery("select * from LNPInsured where contno='" + tContNo + "'").get(1);
/*  798 */       this.tInsurAddressSchema = new LNPAddressDB(this.con).executeQuery("select * from lnpaddress a where  exists(select 1 from lnpinsured b where a.customerid=b.insuredid  and b.contno='" + tContNo + "')").get(1);
/*  799 */       if ((this.tLNPInsuredSchema == null) || (this.tInsurAddressSchema == null)) {
/*  800 */         this.message = "\u7F3A\u5931\u88AB\u4FDD\u4EBA\u4FE1\u606F\uFF01";
/*  801 */         return this.valiPassFlag = 0;
/*      */       }
/*  803 */       String msg = "\u8BF7\u5B8C\u5584\u201C\u5BA2\u6237\u4FE1\u606F\u201D\u4E2D\u201C\u88AB\u4FDD\u4EBA\u4FE1\u606F\u201D\u90E8\u5206\u7684\u4FE1\u606F\u9879\uFF01";
/*  804 */       LNPInsuredSchema tSchema = this.tLNPInsuredSchema;
/*  805 */       if ((turnNullToString(tSchema.getName()).equals("")) || (turnNullToString(Integer.valueOf(tSchema.getAppAge())).equals("")) || 
/*  806 */         (turnNullToString(tSchema.getSex()).equals("")) || (turnNullToString(tSchema.getBirthday()).equals("")) || 
/*  807 */         (turnNullToString(this.tInsurAddressSchema.getCompanyAddress()).equals("")) || 
/*  808 */         (turnNullToString(this.tInsurAddressSchema.getCompanyZipCode()).equals("")) || (turnNullToString(tSchema.getNativePlace()).equals("")) || 
/*  809 */         (turnNullToString(tSchema.getIDType()).equals("")) || (turnNullToString(tSchema.getIDNo()).equals(""))) {
/*  810 */         this.message = msg;
/*  811 */         return this.valiPassFlag = 0;
/*      */       }
/*      */ 
/*  816 */       this.tLNPBnfSet = new LNPBnfDB(this.con).executeQuery("select * from lnpbnf where contno='" + tContNo + "' and (health is null or health<>'delete') order by bnforder");
/*  817 */       if (this.tLNPInsuredSchema.getInsuredPeoples() > 0) {
/*  818 */         String msg = "\u8BF7\u5B8C\u5584\u201C\u5BA2\u6237\u4FE1\u606F\u201D\u4E2D\u201C\u53D7\u76CA\u4EBA\u4FE1\u606F\u201D\u90E8\u5206\u7684\u4FE1\u606F\u9879\uFF01";
/*  819 */         if (this.tLNPBnfSet.size() > 0) {
/*  820 */           for (int i = 1; i <= this.tLNPBnfSet.size(); i++) {
/*  821 */             LNPBnfSchema tSchema = this.tLNPBnfSet.get(i);
/*  822 */             if ((!turnNullToString(Double.valueOf(tSchema.getBenefitRate())).equals("")) && (!turnNullToString(tSchema.getBenefitOrder()).equals("")) && 
/*  823 */               (!turnNullToString(tSchema.getBnfName()).equals("")) && (!turnNullToString(tSchema.getRelationToInsured()).equals("")) && 
/*  824 */               (!turnNullToString(this.tLNPInsuredSchema.getCreditGrade()).equals(""))) continue;
/*  825 */             this.message = msg;
/*  826 */             return this.valiPassFlag = 0;
/*      */           }
/*      */ 
/*  829 */           ExeSQL execSQL = new ExeSQL(this.con);
/*  830 */           SSRS ssrs = execSQL.execSQL("select sum(benefitrate),benefitorder from lnpbnf where contno='" + tContNo + "' and (health<>'delete' or health is null) group by BenefitOrder having sum(benefitrate)<>100");
/*  831 */           if (ssrs.MaxRow > 0) {
/*  832 */             this.message = "\u76F8\u540C\u201C\u53D7\u76CA\u987A\u5E8F\u201D\u7684\u8EAB\u6545\u53D7\u76CA\u4EBA\u201C\u53D7\u76CA\u6BD4\u4F8B\u201D\u603B\u548C\u9700\u7B49\u4E8E100% \uFF01";
/*  833 */             return this.valiPassFlag = 0;
/*      */           }
/*      */         } else {
/*  836 */           this.message = msg;
/*  837 */           return this.valiPassFlag = 0;
/*      */         }
/*  839 */       } else if (this.tLNPInsuredSchema.getInsuredPeoples() < 0) {
/*  840 */         this.message = "\u8BF7\u5B8C\u5584\u201C\u5BA2\u6237\u4FE1\u606F\u201D\u4E2D\u201C\u53D7\u76CA\u4EBA\u4FE1\u606F\u201D\u90E8\u5206\u7684\u4FE1\u606F\u9879\uFF01";
/*  841 */         return this.valiPassFlag = 0;
/*      */       }
/*      */ 
/*  845 */       LNPPaymentDB tLNPPaymentDB = new LNPPaymentDB(this.con);
/*  846 */       tLNPPaymentDB.setContNo(tContNo);
/*  847 */       if (tLNPPaymentDB.getInfo()) {
/*  848 */         this.tLNPPaymentSchema = tLNPPaymentDB.getSchema();
/*  849 */         String account = getDecryptAccount(tContNo);
/*  850 */         this.tLNPPaymentSchema.setAccount(account);
/*  851 */         String msg = "\u8BF7\u5B8C\u5584\u201C\u544A\u77E5\u53CA\u6388\u6743\u201D\u4E2D\u201C\u6536\u4ED8\u8D39\u4FE1\u606F\u201D\u90E8\u5206\u7684\u4FE1\u606F\u9879\uFF01";
/*  852 */         LNPPaymentSchema tSchema = this.tLNPPaymentSchema;
/*  853 */         if ((turnNullToString(tSchema.getPayMent1()).equals("")) || (turnNullToString(tSchema.getPayMent2()).equals(""))) {
/*  854 */           this.message = msg;
/*  855 */           return this.valiPassFlag = 0;
/*      */         }
/*      */       } else {
/*  858 */         this.message = "\u8BF7\u5148\u586B\u5199\u6536\u4ED8\u8D39\u4FE1\u606F\uFF01";
/*  859 */         return this.valiPassFlag = 0;
/*      */       }
/*      */ 
/*  862 */       LNPBonusInfoDB tLNPBonusInfoDB = new LNPBonusInfoDB(this.con);
/*  863 */       tLNPBonusInfoDB.setContNo(tContNo);
/*  864 */       if (tLNPBonusInfoDB.getInfo()) {
/*  865 */         this.tLNPBonusInfoSchema = tLNPBonusInfoDB.getSchema();
/*      */       }
/*      */       else
/*      */       {
/*  873 */         this.message = "\u8BF7\u5148\u586B\u5199\u7EA2\u5229\u4FE1\u606F\uFF01";
/*  874 */         return this.valiPassFlag = 0;
/*      */       }
/*      */ 
/*  877 */       this.tLNPAgentInfoSet = new LNPAgentInfoDB(this.con).executeQuery("select * from lnpagentinfo where contno='" + tContNo + "'");
/*  878 */       if (this.tLNPAgentInfoSet.size() <= 0) {
/*  879 */         this.message = "\u8BF7\u5148\u8BBE\u7F6E\u4EE3\u7406\u4EBA\u4FE1\u606F\uFF01";
/*  880 */         return this.valiPassFlag = 0;
/*      */       }
/*  882 */       String msg = "\u8BF7\u5B8C\u5584\u201C\u544A\u77E5\u53CA\u6388\u6743\u201D\u4E2D\u201C\u4EE3\u7406\u4EBA\u544A\u77E5\u201D\u90E8\u5206\u7684\u4FE1\u606F\u9879\uFF01";
/*  883 */       LNPAgentInfoSchema tSchema = this.tLNPAgentInfoSet.get(1);
/*  884 */       if (turnNullToString(tSchema.getP4()).equals("")) {
/*  885 */         this.message = msg;
/*  886 */         return this.valiPassFlag = 0;
/*      */       }
/*      */ 
/*  891 */       this.tLNPInvestmentInfoSchema = new LNPInvestmentInfoDB(this.con).executeQuery("select * from LNPInvestmentInfo where contno='" + tContNo + "'").get(1);
/*  892 */       if ((this.tLNPInvestmentInfoSchema != null) && ((turnNullToString(this.tLNPInvestmentInfoSchema.getTermInvestment()).equals("")) || (this.tLNPInvestmentInfoSchema.getMonthPlusPrem() <= 0.0D)) && (
/*  893 */         (!turnNullToString(this.tLNPInvestmentInfoSchema.getTermInvestment()).equals("")) || (this.tLNPInvestmentInfoSchema.getMonthPlusPrem() > 0.0D))) {
/*  894 */         this.message = "\u6708\u6708\u52A0\u4FDD\u8D39\u4E0E\u5B9A\u6295\u5E74\u9650\u4E3A\u7ED1\u5B9A\u5F55\u5165\u9879,\u8BF7\u540C\u65F6\u5F55\u5165\uFF01";
/*  895 */         return this.valiPassFlag = 0;
/*      */       }
/*      */ 
/*  900 */       this.tLNpInvestmentAccountInfoSet = new LNPInvestmentAccountInfoDB(this.con).executeQuery("select * from LNPInvestmentAccountInfo where contno='" + tContNo + "'");
/*      */     }
/*      */     catch (RuntimeException e) {
/*  903 */       e.printStackTrace();
/*  904 */       return this.valiPassFlag = 0;
/*      */     }
/*  906 */     return true;
/*      */   }
/*      */ 
/*      */   private boolean validateCRS(CRSInfoSchema cSchema, LNPAppntSchema lSchema)
/*      */   {
/*  915 */     if (("01".equals(lSchema.getIDType().trim())) || ("02".equals(lSchema.getIDType().trim())) || 
/*  916 */       ("04".equals(lSchema.getIDType().trim())) || ("05".equals(lSchema.getIDType().trim())))
/*      */     {
/*  918 */       System.out.println("\u6821\u9A8C\u5FC5\u5F55\u9879\u975E\u519B\u4EBA\u8BC1");
/*  919 */       if ((cSchema.getTaxResidentType() == null) || ("".equals(cSchema.getTaxResidentType().trim()))) {
/*  920 */         this.valiPassFlag = false;
/*      */       }
/*  923 */       else if (!"1".equals(cSchema.getTaxResidentType().trim())) {
/*  924 */         System.out.println("\u6821\u9A8C\u5FC5\u5F55\u9879\u7C7B\u578B2\u30013");
/*  925 */         if ((cSchema.getFirstName() == null) || ("".equals(cSchema.getFirstName().trim()))) {
/*  926 */           this.valiPassFlag = false;
/*      */         }
/*  928 */         if ((cSchema.getLastName() == null) || ("".equals(cSchema.getLastName().trim()))) {
/*  929 */           this.valiPassFlag = false;
/*      */         }
/*      */ 
/*  932 */         if ((cSchema.getCurrentAddress_Country_en() == null) || ("".equals(cSchema.getCurrentAddress_Country_en().trim()))) {
/*  933 */           this.valiPassFlag = false;
/*      */         }
/*  935 */         if ("ZhongGuo".equals(cSchema.getCurrentAddress_Country_en().trim())) {
/*  936 */           if ((cSchema.getCurrentAddress_Province_en() == null) || 
/*  937 */             ("".equals(cSchema.getCurrentAddress_Province_en().trim()))) {
/*  938 */             this.valiPassFlag = false;
/*      */           }
/*  940 */           if ((cSchema.getCurrentAddress_City_en() == null) || ("".equals(cSchema.getCurrentAddress_City_en().trim()))) {
/*  941 */             this.valiPassFlag = false;
/*      */           }
/*      */         }
/*  944 */         if ((cSchema.getCurrentAddress_Detail_en() == null) || ("".equals(cSchema.getCurrentAddress_Detail_en().trim()))) {
/*  945 */           this.valiPassFlag = false;
/*      */         }
/*      */ 
/*  948 */         if ((cSchema.getBirthAddress_Country_en() == null) || ("".equals(cSchema.getBirthAddress_Country_en().trim()))) {
/*  949 */           this.valiPassFlag = false;
/*      */         }
/*  951 */         if ("ZhongGuo".equals(cSchema.getBirthAddress_Country_en().trim())) {
/*  952 */           if ((cSchema.getBirthAddress_Province_en() == null) || ("".equals(cSchema.getBirthAddress_Province_en().trim()))) {
/*  953 */             this.valiPassFlag = false;
/*      */           }
/*  955 */           if ((cSchema.getBirthAddress_City_en() == null) || ("".equals(cSchema.getBirthAddress_City_en().trim()))) {
/*  956 */             this.valiPassFlag = false;
/*      */           }
/*      */ 
/*      */         }
/*      */ 
/*  961 */         if ((cSchema.getBirthAddress_Detail() != null) && (!"".equals(cSchema.getBirthAddress_Detail().trim())) && (
/*  962 */           (cSchema.getBirthAddress_Detail_en() == null) || ("".equals(cSchema.getBirthAddress_Detail_en().trim())))) {
/*  963 */           this.valiPassFlag = false;
/*      */         }
/*      */ 
/*  968 */         if (((cSchema.getTaxpayerCode1() == null) || ("".equals(cSchema.getTaxpayerCode1().trim()))) && 
/*  969 */           ((cSchema.getTaxpayerCode2() == null) || ("".equals(cSchema.getTaxpayerCode2().trim()))) && (
/*  970 */           (cSchema.getTaxpayerCode3() == null) || ("".equals(cSchema.getTaxpayerCode3().trim())))) {
/*  971 */           System.out.println("\u6821\u9A8C\u5FC5\u5F55\u9879\u672A\u586B\u5199\u8BC6\u522B\u53F7\uFF0C\u5219\u539F\u56E0\u5FC5\u586B");
/*  972 */           if ((cSchema.getNoTaxpayercodeReason() == null) || ("".equals(cSchema.getNoTaxpayercodeReason().trim())) || ("2".equals(cSchema.getNoTaxpayercodeReason().trim()))) {
/*  973 */             this.valiPassFlag = false;
/*      */           }
/*      */         }
/*      */ 
/*  977 */         if (("2".equals(cSchema.getNoTaxpayercodeReason().trim())) && 
/*  978 */           ((cSchema.getTaxpayerCode1() == null) || ("".equals(cSchema.getTaxpayerCode1().trim()))) && 
/*  979 */           ((cSchema.getTaxpayerCode2() == null) || ("".equals(cSchema.getTaxpayerCode2().trim()))) && (
/*  980 */           (cSchema.getTaxpayerCode3() == null) || ("".equals(cSchema.getTaxpayerCode3().trim())))) {
/*  981 */           this.valiPassFlag = false;
/*      */         }
/*      */ 
/*  985 */         if (((cSchema.getTaxResidentCountry1() == null) || ("".equals(cSchema.getTaxResidentCountry1().trim()))) && 
/*  986 */           ((cSchema.getTaxResidentCountry2() == null) || ("".equals(cSchema.getTaxResidentCountry2().trim()))) && (
/*  987 */           (cSchema.getTaxResidentCountry3() == null) || ("".equals(cSchema.getTaxResidentCountry3().trim())))) {
/*  988 */           this.valiPassFlag = false;
/*      */         }
/*      */ 
/*  991 */         if ("1".equals(cSchema.getNoTaxpayercodeReason().trim())) {
/*  992 */           System.out.println("\u6821\u9A8C\u5FC5\u5F55\u9879\u586B\u5199\u4E86\u539F\u56E0\u4E3A1,\u6821\u9A8C\u539F\u56E0\u63CF\u8FF0");
/*  993 */           if ((cSchema.getReasonDescription() == null) || ("".equals(cSchema.getReasonDescription().trim())))
/*  994 */             this.valiPassFlag = false;
/*      */         }
/*      */         else {
/*  997 */           System.out.println("\u6821\u9A8C\u5FC5\u5F55\u9879\u586B\u5199\u4E86\u539F\u56E0\u4E3A0\u62162,\u4E0D\u6821\u9A8C");
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/* 1002 */         System.out.println("\u6821\u9A8C\u5FC5\u5F55\u9879taxType=1\uFF0C\u4E0D\u6821\u9A8C\u5C45\u6C11\u4FE1\u606F");
/* 1003 */         this.valiPassFlag = true;
/*      */       }
/* 1005 */     } else if ("03".equals(lSchema.getIDType().trim())) {
/* 1006 */       System.out.println("\u6821\u9A8C\u5FC5\u5F55\u9879ID\u4E3A\u519B\u4EBA\u8BC1\uFF0C\u4E0D\u6821\u9A8CCRS\u4FE1\u606F");
/* 1007 */       this.valiPassFlag = true;
/*      */     }
/* 1009 */     return this.valiPassFlag;
/*      */   }
/*      */ 
/*      */   public String getAuraIdtype(String idtype)
/*      */   {
/* 1014 */     if (("09".equals(idtype)) || ("10".equals(idtype))) {
/* 1015 */       idtype = "03";
/*      */     }
/* 1017 */     return idtype;
/*      */   }
/*      */ 
/*      */   public static void main(String[] args) {
/* 1021 */     AuraBean cal = new AuraBean();
/* 1022 */     String tContNo = "123213213123";
/* 1023 */     tContNo = "098765432111";
/*      */ 
/* 1026 */     tContNo = "038979387593";
/* 1027 */     tContNo = "201707120001";
/* 1028 */     cal.calInterfaces(tContNo);
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.interfaces.AuraBean
 * JD-Core Version:    0.6.0
 */