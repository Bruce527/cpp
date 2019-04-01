/*     */ package com.sinosoft.banklns.lnsmodel.interfaces;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPAddressDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPAgentInfoDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPAppntDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPBnfDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPBonusInfoDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPCUWMasterDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPCodeDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPContDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPInsuredDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPInvestmentAccountInfoDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPInvestmentInfoDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPPaymentDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPPolDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPRiskAmountDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPUWMasterDB;
/*     */ import com.sinosoft.banklns.lis.pubfun.MMap;
/*     */ import com.sinosoft.banklns.lis.pubfun.PubFun;
/*     */ import com.sinosoft.banklns.lis.schema.LNPAddressSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPAgentInfoSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPAppntSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPBnfSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPBonusInfoSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPCUWMasterSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPCodeSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPInsuredSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPInvestmentAccountInfoSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPInvestmentInfoSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPPaymentSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPPolSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPRiskAmountSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPUWMasterSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPAddressSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPAgentInfoSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPAppntSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPBnfSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPCodeSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPInsuredSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPInvestmentAccountInfoSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPInvestmentInfoSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPPolSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPRiskAmountSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPUWMasterSet;
/*     */ import java.io.PrintStream;
/*     */ import java.util.List;
/*     */ import org.jdom.Element;
/*     */ 
/*     */ public class NPUWBean extends PublicInterfaces
/*     */ {
/*  54 */   private LNPContSchema tLNPContSchema = null;
/*     */ 
/*  57 */   private LNPInsuredSchema tLNPInsuredSchema = null;
/*     */ 
/*  60 */   private LNPAppntSchema tLNPAppntSchema = null;
/*     */ 
/*  62 */   private LNPAddressSchema tAppntAddressSchema = null;
/*     */ 
/*  64 */   private LNPAddressSchema tInsurAddressSchema = null;
/*     */ 
/*  67 */   private LNPBnfSet tLNPBnfSet = null;
/*     */ 
/*  70 */   private LNPPolSet tLNPPolSet = null;
/*     */ 
/*  72 */   private LNPPolSet tLNPPolSet2 = null;
/*     */ 
/*  75 */   private LNPCUWMasterSchema tLNPCUWMasterSchema = null;
/*  76 */   private LNPUWMasterSet tLNPUWMasterSet = null;
/*     */ 
/*  79 */   private LNPPaymentSchema tLNPPaymentSchema = null;
/*     */ 
/*  81 */   private LNPBonusInfoSchema tLNPBonusInfoSchema = null;
/*     */ 
/*  84 */   private LNPAgentInfoSet tLNPAgentInfoSet = null;
/*     */ 
/*  87 */   private LNPInvestmentInfoSchema tLNPInvestmentInfoSchema = null;
/*     */   private LNPInvestmentAccountInfoSet tLNpInvestmentAccountInfoSet;
/*     */   private LNPRiskAmountSet tLnpRiskAmountSet;
/*     */ 
/*     */   protected void initObject()
/*     */   {
/*  95 */     this.interfacesFlag = false;
/*  96 */     this.modelFileName = "aura_in.xml";
/*  97 */     this.sendFileName = "aura_in";
/*  98 */     this.returnFileName = "aura_out";
/*  99 */     this.defaultErrorMessage = "\u951F\u527F\u618B\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6821\u951F\u65A4\u62F7\u5931\u951F\u6770\uFF4F\u62F7";
/*     */ 
/* 105 */     super.initObject();
/*     */   }
/*     */ 
/*     */   protected boolean dealReturn()
/*     */   {
/*     */     try {
/* 111 */       this.tLNPPolSet = new LNPPolDB(this.con).executeQuery("select * from lnppol where contno='" + this.tContNo + "'");
/*     */ 
/* 113 */       LNPContSchema bakLNPContSchema = new LNPContSchema();
/* 114 */       bakLNPContSchema.setSchema(this.tLNPContSchema);
/*     */ 
/* 116 */       Element auratx = getReturnBody();
/*     */       int i;
/* 120 */       if (("ACC".equals(getValueInXML(auratx, "ZNCNTUW"))) || 
/* 121 */         ("RUW".equals(getValueInXML(auratx, "ZNCNTUW"))))
/*     */       {
/* 124 */         String zncntuw = getValueInXML(auratx, "ZNCNTUW");
/* 125 */         if (this.tLNPCUWMasterSchema == null) {
/* 126 */           this.tLNPCUWMasterSchema = new LNPCUWMasterSchema();
/* 127 */           setSaveTime(this.tLNPCUWMasterSchema);
/*     */ 
/* 129 */           this.tLNPCUWMasterSchema.setContNo(this.tLNPContSchema.getContNo());
/* 130 */           this.tLNPCUWMasterSchema.setAppDecision(zncntuw);
/*     */ 
/* 132 */           this.bakMap.put(this.tLNPCUWMasterSchema, "DELETE");
/* 133 */           this.map.put(this.tLNPCUWMasterSchema, "INSERT");
/* 134 */         } else if (this.tLNPCUWMasterSchema != null) {
/* 135 */           LNPCUWMasterSchema bakLNPCUWMasterSchema = this.tLNPCUWMasterSchema.getSchema();
/* 136 */           this.bakMap.put(bakLNPCUWMasterSchema, "UPDATE");
/*     */ 
/* 138 */           setModifyTime(this.tLNPCUWMasterSchema);
/* 139 */           this.tLNPCUWMasterSchema.setAppDecision(zncntuw);
/* 140 */           this.map.put(this.tLNPCUWMasterSchema, "UPDATE");
/*     */         }
/*     */ 
/* 144 */         List OverallDecisions = auratx.getChild("Insureds").getChild("Insured").getChild("OverallDecisions").getChildren("Decision");
/*     */ 
/* 146 */         LNPUWMasterSet tempSet = new LNPUWMasterSet();
/* 147 */         for (i = 0; i < OverallDecisions.size(); i++) {
/* 148 */           Element tempEle = (Element)OverallDecisions.get(i);
/* 149 */           LNPUWMasterSchema tempSchema = new LNPUWMasterSchema();
/* 150 */           setSaveTime(tempSchema);
/* 151 */           tempSchema.setContNo(this.tLNPContSchema.getContNo());
/* 152 */           tempSchema.setGrpContNo(this.tLNPContSchema.getGrpContNo());
/* 153 */           tempSchema.setProposalContNo(this.tLNPContSchema.getProposalContNo());
/* 154 */           tempSchema.setOperator("OPERATOR");
/* 155 */           String ZNPRDCODE = getValueInXML(tempEle, "ZNPRDCODE");
/* 156 */           Element UnderwritingDecision = tempEle.getChild("UnderwritingDecision");
/* 157 */           String ZNCOVUW = getValueInXML(UnderwritingDecision, "ZNCOVUW");
/* 158 */           String FUPCODE = getValueInXML(UnderwritingDecision, "FUPCODE");
/* 159 */           String MESSAGE = getValueInXML(UnderwritingDecision, "MESSAGE");
/* 160 */           tempSchema.setRiderCode(ZNPRDCODE);
/* 161 */           tempSchema.setUWDid(ZNCOVUW);
/* 162 */           tempSchema.setDeclinedCode(FUPCODE);
/* 163 */           tempSchema.setDeclinedReason(MESSAGE);
/*     */ 
/* 166 */           for (int j = 1; j <= this.tLNPPolSet.size(); j++) {
/* 167 */             LNPPolSchema lnpPol = this.tLNPPolSet.get(j);
/* 168 */             if (lnpPol.getRiskCode().equals(ZNPRDCODE)) {
/* 169 */               tempSchema.setPolNo(lnpPol.getPolNo());
/* 170 */               tempSchema.setProposalNo(lnpPol.getPolNo());
/* 171 */               tempSet.add(tempSchema);
/* 172 */               break;
/*     */             }
/*     */ 
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/* 182 */         setModifyTime(this.tLNPContSchema);
/*     */ 
/* 184 */         this.bakMap.put(this.tLNPUWMasterSet, "INSERT");
/* 185 */         this.map.put(this.tLNPUWMasterSet, "DELETE");
/*     */ 
/* 187 */         this.bakMap.put(tempSet, "DELETE");
/* 188 */         this.map.put(tempSet, "INSERT");
/*     */ 
/* 190 */         this.bakMap.put(bakLNPContSchema, "UPDATE");
/* 191 */         this.map.put(this.tLNPContSchema, "UPDATE");
/* 192 */         return true;
/*     */       }
/* 194 */       this.message = getValueInXML(auratx, "PDESC");
/* 195 */       if (("".equals(this.message)) || (this.message == null)) {
/* 196 */         Element allDecisionsN = auratx.getChild("Insureds").getChild("Insured").getChild("OverallDecisions");
/* 197 */         List decisionNList = allDecisionsN.getChildren();
/* 198 */         for (Element cDec : decisionNList) {
/* 199 */           this.message = (this.message + " \u951F\u65A4\u62F7\u951F\u65A4\u62F7:" + cDec.getChild("ZNPRDCODE").getText() + "," + cDec.getChild("UnderwritingDecision").getChild("MESSAGE").getText() + ";");
/*     */         }
/*     */       }
/* 202 */       return false;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 207 */       e.printStackTrace();
/* 208 */     }return false;
/*     */   }
/*     */ 
/*     */   protected boolean dealSend()
/*     */   {
/*     */     try
/*     */     {
/* 216 */       Element auratx = getSendBody();
/* 217 */       String company = mappingCode(this.tLNPContSchema.getManageCom(), "BankSigned");
/*     */ 
/* 220 */       Element auraControl = auratx.getChild("AuraControl");
/* 221 */       updateText(auraControl, "UniqueID", this.tLNPContSchema.getContNo().trim() + "_U");
/* 222 */       updateText(auraControl, "UniqueID", fomartDate(PubFun.getCurrentDate()) + PubFun.getCurrentTime().replace(":", "") + "_U");
/*     */ 
/* 224 */       updateText(auraControl, "Company", "mlc");
/* 225 */       updateText(auraControl, "SetCode", "16");
/* 226 */       updateText(auraControl, "SubSet", "2");
/* 227 */       updateText(auraControl, "PostBackTo", "review.jsp");
/* 228 */       updateText(auraControl, "PostErrorsTo", "review.jsp");
/* 229 */       updateText(auraControl, "SaveExitPage", "review.jsp");
/*     */ 
/* 232 */       Element policy = auratx.getChild("POLICY");
/* 233 */       updateText(policy, "ZNUWCAT", "NB");
/* 234 */       updateText(policy, "ZNEXTSYS", "4");
/* 235 */       updateText(policy, "PRT1OPT", "Y");
/* 236 */       updateText(policy, "PRT2OPT", "Y");
/* 237 */       updateText(policy, "ZNGPCNO", "");
/* 238 */       updateText(policy, "STATCODE", "PS");
/* 239 */       updateText(policy, "CNTBRANCH", company);
/* 240 */       updateText(policy, "TTMPRCNO", this.tLNPContSchema.getContNo());
/* 241 */       updateText(policy, "Chdrnum", "");
/* 242 */       updateText(policy, "OCCDATE", fomartDate(this.tLNPContSchema.getPValiDate()));
/* 243 */       updateText(policy, "HPROPDTE", fomartDate(this.tLNPContSchema.getPSignDate()));
/* 244 */       updateText(policy, "HPRRCVDT", fomartDate(this.tLNPAgentInfoSet.get(1).getP1()));
/* 245 */       updateText(policy, "ZDDTEDIF", turnNullToString(Integer.valueOf(PubFun.calInterval(turnNullToString(this.tLNPAgentInfoSet.get(1).getP1()), 
/* 246 */         turnNullToString(this.tLNPContSchema.getPSignDate()), "D"))));
/*     */ 
/* 249 */       Element policyOwner = policy.getChild("PolicyOwner");
/* 250 */       updateText(policyOwner, "OWNERSEL", "".equals(turnNullToString(this.tLNPAppntSchema.getAppntNo())) ? "01" : this.tLNPAppntSchema.getAppntNo());
/* 251 */       updateText(policyOwner, "OWNERSEL", "01");
/* 252 */       updateText(policyOwner, "SALUTL", "MR / MRS");
/* 253 */       updateText(policyOwner, "LSURNAME", this.tLNPAppntSchema.getAppntName());
/* 254 */       updateText(policyOwner, "DOB", fomartDate(this.tLNPAppntSchema.getAppntBirthday()));
/* 255 */       updateText(policyOwner, "Age", turnNullToString(Integer.valueOf(this.tLNPAppntSchema.getAppntAge())));
/* 256 */       updateText(policyOwner, "ZDDAYS", "");
/* 257 */       updateText(policyOwner, "CLTSEX", mappingCode(this.tLNPAppntSchema.getAppntSex(), "BankPolicySex"));
/* 258 */       updateText(policyOwner, "MARRYD", "");
/* 259 */       updateText(policyOwner, "ZACLTADDR", combAddress(this.tAppntAddressSchema.getCompanyFax(), this.tAppntAddressSchema.getBP2(), this.tAppntAddressSchema.getCompanyAddress()));
/* 260 */       updateText(policyOwner, "CLTPCODE", this.tAppntAddressSchema.getCompanyZipCode());
/* 261 */       updateText(policyOwner, "ADDRTYPE", "1");
/* 262 */       updateText(policyOwner, "ZNBUSUT", this.tAppntAddressSchema.getGrpName());
/* 263 */       updateText(policyOwner, "CTRYCODE", this.tLNPAppntSchema.getNativePlace());
/* 264 */       updateText(policyOwner, "NATLTY", this.tLNPAppntSchema.getNativePlace());
/* 265 */       updateText(policyOwner, "CLRSKIND", "1");
/* 266 */       updateText(policyOwner, "RSKFLG", "1");
/* 267 */       updateText(policyOwner, "IDNPRF", mappingCode(this.tLNPAppntSchema.getIDType(), "BankCertType"));
/* 268 */       updateText(policyOwner, "SECUITYNO", this.tLNPAppntSchema.getIDNo());
/* 269 */       updateText(policyOwner, "EXPDTE", "1".equals(this.tLNPAppntSchema.getIDPerpetual()) ? fomartDate(this.tLNPAppntSchema.getIDValidity()) : fomartDate(mappingCode(this.tLNPAppntSchema.getIDPerpetual(), "BankCertificatesType")));
/* 270 */       updateText(policyOwner, "INCPRF", "");
/* 271 */       updateText(policyOwner, "INCDESC", "");
/* 272 */       updateText(policyOwner, "DECGRSAL", turnNullToString(Double.valueOf(this.tLNPAppntSchema.getSalary())));
/* 273 */       updateText(policyOwner, "RMBLPHONE", this.tAppntAddressSchema.getPhone());
/* 274 */       updateText(policyOwner, "CLTPHONE", combPhone(this.tAppntAddressSchema.getMobileChs2(), this.tAppntAddressSchema.getCompanyPhone()));
/* 275 */       updateText(policyOwner, "RINTERNET", this.tAppntAddressSchema.getCompanyMail());
/* 276 */       updateText(policyOwner, "OCCPCODE", this.tLNPAppntSchema.getOccupationCode());
/* 277 */       updateText(policyOwner, "ZNPIDCPYID", mappingCode(this.tLNPAppntSchema.getHealth(), "BankIsOrNo"));
/*     */ 
/* 280 */       if (this.tLnpRiskAmountSet.size() > 0) {
/* 281 */         Element owriskList = policy.getChild("OWNRISKSILIST");
/* 282 */         policy.removeContent(owriskList);
/* 283 */         for (int i = 1; i <= this.tLnpRiskAmountSet.size(); i++) {
/* 284 */           Element tempElement = (Element)owriskList.clone();
/* 285 */           updateText(tempElement, "ZNRSKCD", this.tLnpRiskAmountSet.get(i).getftype());
/* 286 */           updateText(tempElement, "SUMINS", turnNullToString(Double.valueOf(this.tLnpRiskAmountSet.get(i).getfamnt())));
/* 287 */           policy.addContent(tempElement);
/*     */         }
/*     */       }
/*     */ 
/* 291 */       updateText(policy, "BILLFREQ", mappingCode(turnNullToString(Integer.valueOf(this.tLNPContSchema.getPayIntv())), "BankFrequency"));
/* 292 */       updateText(policy, "ZNFPMOP", mappingCode(this.tLNPPaymentSchema.getPayMent1(), "BankRenewal"));
/* 293 */       updateText(policy, "MOP", mappingCode(this.tLNPPaymentSchema.getPayMent2(), "BankRenewal"));
/* 294 */       updateText(policy, "ZDIVOPT", this.tLNPBonusInfoSchema.getBonusWay());
/* 295 */       updateText(policy, "ZNFOPT", this.tLNPBonusInfoSchema.getP2());
/* 296 */       updateText(policy, "CNTCURR", "CNY");
/* 297 */       updateText(policy, "BILLCURR", "CNY");
/* 298 */       updateText(policy, "REGISTER", "PRC");
/* 299 */       updateText(policy, "SRCEBUS", "2");
/* 300 */       updateText(policy, "DLVRMODE", "01,02,03".indexOf(turnNullToString(this.tLNPAgentInfoSet.get(1).getP3())) == -1 ? "04" : mappingCode(this.tLNPAgentInfoSet.get(1).getP3(), "BankDeliveryType"));
/* 301 */       updateText(policy, "ZAPSTADD", combAddress(this.tAppntAddressSchema.getHomeFax(), this.tAppntAddressSchema.getBP(), this.tAppntAddressSchema.getHomeAddress()));
/* 302 */       updateText(policy, "CLTPCODE03", this.tAppntAddressSchema.getHomeZipCode());
/* 303 */       updateText(policy, "ZNAGNTSEL", this.tLNPAgentInfoSet.get(1).getP2());
/* 304 */       updateText(policy, "AGCOMRT", turnNullToString(Integer.valueOf(100 / this.tLNPAgentInfoSet.size())));
/*     */ 
/* 307 */       if (this.tLNPAgentInfoSet.size() == 2) {
/* 308 */         Element subAgent = policy.getChild("SubAgentList");
/* 309 */         updateText(subAgent, "ZNAGNTSEL01", this.tLNPAgentInfoSet.get(2).getAgentCode());
/* 310 */         updateText(subAgent, "SPLITC", turnNullToString(Integer.valueOf(100 / this.tLNPAgentInfoSet.size())));
/*     */       }
/*     */ 
/* 313 */       updateText(policy, "ZNCSMNAME", "");
/*     */ 
/* 315 */       if ((this.tLNPPolSet2.get(1).getRnewFlag().equals("2")) && (
/* 316 */         (this.tLNPPolSet2.get(1).getUWTime().equals("AGY")) || (this.tLNPPolSet2.get(1).getUWTime().equals("TM")))) {
/* 317 */         updateText(policy, "ZNCSMNAME", this.tLNPContSchema.getInputOperator());
/*     */       }
/*     */ 
/* 324 */       Element insured = policy.getChild("INSLST").getChild("Insured");
/* 325 */       updateText(insured, "Life", "01");
/*     */ 
/* 328 */       Element inrisk = insured.getChild("INSRISKSILIST");
/* 329 */       updateText(inrisk, "ZNRSKCD02", "");
/* 330 */       updateText(inrisk, "SUMINS02", "");
/*     */ 
/* 332 */       Element insuredInfo = insured.getChild("InsuredInfo");
/* 333 */       updateText(insuredInfo, "LIFCNUM", "".equals(turnNullToString(this.tLNPInsuredSchema.getInsuredNo())) ? "01" : this.tLNPInsuredSchema.getInsuredNo());
/* 334 */       updateText(insuredInfo, "SALUTL02", "MR / MRS");
/* 335 */       updateText(insuredInfo, "LSURNAME02", this.tLNPInsuredSchema.getName());
/* 336 */       updateText(insuredInfo, "DOB02", fomartDate(this.tLNPInsuredSchema.getBirthday()));
/* 337 */       updateText(insuredInfo, "Age02", turnNullToString(Integer.valueOf(this.tLNPInsuredSchema.getAppAge())));
/* 338 */       updateText(insuredInfo, "ZDDays02", "");
/* 339 */       updateText(insuredInfo, "CLTSEX02", mappingCode(this.tLNPInsuredSchema.getSex(), "BankPolicySex"));
/* 340 */       updateText(insuredInfo, "MARRYD02", "");
/* 341 */       updateText(insuredInfo, "ZACLTADDR02", combAddress(this.tInsurAddressSchema.getCompanyFax(), this.tInsurAddressSchema.getBP2(), this.tInsurAddressSchema.getCompanyAddress()));
/* 342 */       updateText(insuredInfo, "CLTPCODE02", this.tInsurAddressSchema.getCompanyZipCode());
/* 343 */       updateText(insuredInfo, "ADDRTYPE02", "1");
/* 344 */       updateText(insuredInfo, "ZNBUSUT02", this.tInsurAddressSchema.getGrpName());
/* 345 */       updateText(insuredInfo, "CTRYCODE02", this.tLNPInsuredSchema.getNativePlace());
/* 346 */       updateText(insuredInfo, "NATLTY02", this.tLNPInsuredSchema.getNativePlace());
/* 347 */       updateText(insuredInfo, "CLRSKIND02", "1");
/* 348 */       updateText(insuredInfo, "RSKFLG02", "1");
/* 349 */       updateText(insuredInfo, "IDNPRF02", mappingCode(this.tLNPInsuredSchema.getIDType(), "BankCertType"));
/* 350 */       updateText(insuredInfo, "SECUITYNO02", this.tLNPInsuredSchema.getIDNo());
/* 351 */       updateText(insuredInfo, "EXPDTE02", "1".equals(this.tLNPInsuredSchema.getIDPerpetual()) ? fomartDate(this.tLNPInsuredSchema.getIDValidity()) : fomartDate(mappingCode(this.tLNPInsuredSchema.getIDPerpetual(), "BankCertificatesType")));
/* 352 */       updateText(insuredInfo, "INCPRF02", "");
/* 353 */       updateText(insuredInfo, "INCDESC02", "");
/* 354 */       updateText(insuredInfo, "DECGRSAL02", turnNullToString(Double.valueOf(this.tLNPInsuredSchema.getSalary())));
/* 355 */       updateText(insuredInfo, "RMBLPHONE02", this.tInsurAddressSchema.getPhone());
/* 356 */       updateText(insuredInfo, "CLTPHONE02", combPhone(this.tInsurAddressSchema.getMobileChs2(), this.tInsurAddressSchema.getCompanyPhone()));
/* 357 */       updateText(insuredInfo, "RINTERNET02", this.tInsurAddressSchema.getCompanyMail());
/* 358 */       updateText(insuredInfo, "OCCPCODE02", this.tLNPInsuredSchema.getOccupationCode());
/* 359 */       updateText(insuredInfo, "ZNPIDCPYID02", mappingCode(this.tLNPInsuredSchema.getHealth(), "BankIsOrNo"));
/*     */ 
/* 361 */       updateText(insured, "RELATION", mappingCode(this.tLNPAppntSchema.getRelationToInsured(), "BankRelationship"));
/* 362 */       updateText(insured, "SELECTION", "");
/* 363 */       updateText(insured, "HEIGHT", "");
/* 364 */       updateText(insured, "WEIGHT", "");
/* 365 */       updateText(insured, "SMOKING", "");
/* 366 */       updateText(insured, "OCCUP", this.tLNPInsuredSchema.getOccupationCode());
/*     */ 
/* 369 */       Element questionArea = insured.getChild("Questionare");
/* 370 */       updateText(questionArea, "QUESTSET", "MTQBA");
/*     */ 
/* 372 */       LNPCodeSet codeSet = new LNPCodeSet();
/* 373 */       LNPCodeDB db = new LNPCodeDB(this.con);
/* 374 */       db.setCodeType("BanktoLAQuesveiw");
/* 375 */       codeSet = db.query();
/* 376 */       Element questionList = questionArea.getChild("QuestionList");
/* 377 */       Element question = questionList.getChild("Question");
/* 378 */       questionList.removeContent();
/* 379 */       for (int i = 1; i <= codeSet.size(); i++) {
/* 380 */         Element tempElement = (Element)question.clone();
/* 381 */         updateText(tempElement, "QUESTIDF", codeSet.get(i).getCode());
/* 382 */         updateText(tempElement, "ANSWER", mappingQues(codeSet.get(i).getCode(), codeSet.get(i).getOtherSign(), this.tLNPContSchema.getContNo()));
/* 383 */         questionList.addContent(tempElement);
/*     */       }
/* 385 */       updateText(insured, "HUWDCDTE", "99999999");
/*     */ 
/* 388 */       Element coverageList = insured.getChild("COVLST");
/* 389 */       Element coverageInfo = coverageList.getChild("COVINF");
/* 390 */       coverageList.removeContent();
/* 391 */       int i = 1; for (int j = 1; i <= this.tLNPPolSet.size(); i++) {
/* 392 */         Element tempCoverage = (Element)coverageInfo.clone();
/* 393 */         LNPPolSchema tempPol = this.tLNPPolSet.get(i);
/* 394 */         updateText(tempCoverage, "Coverage", "01");
/* 395 */         if (!"M".equalsIgnoreCase(tempPol.getSubFlag()))
/* 396 */           updateText(tempCoverage, "RIDER", "0" + j++);
/*     */         else {
/* 398 */           updateText(tempCoverage, "RIDER", "00");
/*     */         }
/*     */ 
/* 401 */         updateText(tempCoverage, "ZNPRDCODE", tempPol.getRiskCode() + "999");
/* 402 */         updateText(tempCoverage, "SUMIN", turnNullToString(Double.valueOf(tempPol.getAmnt())));
/*     */ 
/* 404 */         if ("A".equals(tempPol.getInsuYearFlag()))
/* 405 */           updateText(tempCoverage, "RCESSAGE", turnNullToString(Integer.valueOf(tempPol.getInsuYear())));
/*     */         else
/* 407 */           updateText(tempCoverage, "RCESSTRM", turnNullToString(Integer.valueOf(tempPol.getInsuYear())));
/* 408 */         if ("A".equals(tempPol.getPayEndYearFlag()))
/* 409 */           updateText(tempCoverage, "PCESSAGE", turnNullToString(Integer.valueOf(tempPol.getPayEndYear())));
/*     */         else
/* 411 */           updateText(tempCoverage, "PCESSTRM", turnNullToString(Integer.valueOf(tempPol.getPayEndYear())));
/* 412 */         if ("A".equals(tempPol.getGetYearFlag()))
/* 413 */           updateText(tempCoverage, "BCESSAGE", turnNullToString(Integer.valueOf(tempPol.getGetYear())));
/*     */         else {
/* 415 */           updateText(tempCoverage, "BCESSTRM", turnNullToString(Integer.valueOf(tempPol.getGetYear())));
/*     */         }
/* 417 */         updateText(tempCoverage, "MORTCLS", "2");
/* 418 */         updateText(tempCoverage, "INSTPRM", turnNullToString(Double.valueOf(tempPol.getPrem())));
/*     */ 
/* 420 */         updateText(tempCoverage, "ZPRFLG", "N");
/*     */ 
/* 422 */         if (this.tLNPInvestmentInfoSchema != null) {
/* 423 */           updateText(tempCoverage, "LMPCNT", this.tLNPInvestmentInfoSchema.getPayExtraPremFlag());
/* 424 */           updateText(tempCoverage, "ZPRFLG", "Y");
/* 425 */           updateText(tempCoverage, "ZNINVAMT", turnNullToString(Double.valueOf(this.tLNPInvestmentInfoSchema.getMonthPlusPrem())));
/* 426 */           updateText(tempCoverage, "ZNTRM", this.tLNPInvestmentInfoSchema.getTermInvestment());
/*     */         }
/*     */ 
/* 429 */         updateText(tempCoverage, "ZUNIT", "1");
/* 430 */         updateText(tempCoverage, "LIVESNO", "1");
/* 431 */         updateText(tempCoverage, "PAYCLT", this.tLNPInsuredSchema.getInsuredNo());
/*     */ 
/* 433 */         Element payBankInfor = tempCoverage.getChild("PayBankInfor");
/* 434 */         if ("02".equals(this.tLNPPaymentSchema.getPayMent1())) {
/* 435 */           updateText(payBankInfor, "BANKCODE", "");
/* 436 */           updateText(payBankInfor, "BANKKEY", this.tLNPPaymentSchema.getBankCode());
/* 437 */           updateText(payBankInfor, "BANKACCKEY", this.tLNPPaymentSchema.getAccount());
/* 438 */           updateText(payBankInfor, "BANKDESC", this.tLNPPaymentSchema.getBankCode());
/* 439 */           updateText(payBankInfor, "BNKACTYP", "");
/* 440 */           updateText(payBankInfor, "CURRCODE", "CNY");
/* 441 */           updateText(payBankInfor, "DATEFROM", fomartDate(this.tLNPContSchema.getPValiDate()));
/* 442 */           updateText(payBankInfor, "TIMESUSE", "");
/*     */         }
/*     */ 
/* 445 */         updateText(tempCoverage, "FREQANN", "");
/* 446 */         updateText(tempCoverage, "ADVANCE", "");
/* 447 */         updateText(tempCoverage, "ARREARS", "");
/* 448 */         updateText(tempCoverage, "GUARPERD", "");
/* 449 */         updateText(tempCoverage, "WITHPROP", "");
/* 450 */         updateText(tempCoverage, "WITHOPROP", "");
/* 451 */         updateText(tempCoverage, "NOMLIFE", "");
/* 452 */         updateText(tempCoverage, "DTHPERCN", "");
/* 453 */         updateText(tempCoverage, "DTHPERCO", "");
/*     */ 
/* 455 */         Element payment = tempCoverage.getChild("Payment");
/* 456 */         updateText(payment, "PAYCLT02", "");
/* 457 */         updateText(payment, "CLTYPE", "");
/* 458 */         updateText(payment, "RGPYMOP", "");
/* 459 */         updateText(payment, "REGPAYFREQ", "");
/* 460 */         updateText(payment, "PRCNT", "");
/* 461 */         updateText(payment, "CLAIMCUR", "CNY");
/*     */ 
/* 463 */         updateText(tempCoverage, "RSUNIN", "");
/* 464 */         updateText(tempCoverage, "PRCAMTIND", "");
/*     */ 
/* 468 */         Element PRMFundList = tempCoverage.getChild("PRMFLST");
/* 469 */         for (int x = 1; (x <= this.tLNpInvestmentAccountInfoSet.size()) && (x <= 10); x++) {
/* 470 */           if (x < 10) {
/* 471 */             updateText(PRMFundList, "VRTFND0" + x, this.tLNpInvestmentAccountInfoSet.get(x).getInvestAccountCode());
/* 472 */             updateText(PRMFundList, "UALPRC0" + x, turnNullToString(Double.valueOf(this.tLNpInvestmentAccountInfoSet.get(x).getInvestAccountRate())));
/*     */           } else {
/* 474 */             updateText(PRMFundList, "VRTFND" + x, this.tLNpInvestmentAccountInfoSet.get(x).getInvestAccountCode());
/* 475 */             updateText(PRMFundList, "UALPRC" + x, turnNullToString(Double.valueOf(this.tLNpInvestmentAccountInfoSet.get(x).getInvestAccountRate())));
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/* 480 */         Element RGUFundList = tempCoverage.getChild("RGUFLST");
/* 481 */         for (int x = 1; (x <= this.tLNpInvestmentAccountInfoSet.size()) && (x <= 10); x++) {
/* 482 */           if (x < 10) {
/* 483 */             updateText(RGUFundList, "ZAVRTFND0" + x, this.tLNpInvestmentAccountInfoSet.get(x).getInvestAccountCode());
/* 484 */             updateText(RGUFundList, "ZNSPLAMT0" + x, turnNullToString(Double.valueOf(this.tLNpInvestmentAccountInfoSet.get(x).getInvestAccountRate())));
/*     */           } else {
/* 486 */             updateText(RGUFundList, "ZNSPLAMT" + x, this.tLNpInvestmentAccountInfoSet.get(x).getInvestAccountCode());
/* 487 */             updateText(RGUFundList, "ZNSPLAMT" + x, turnNullToString(Double.valueOf(this.tLNpInvestmentAccountInfoSet.get(x).getInvestAccountRate())));
/*     */           }
/*     */         }
/*     */ 
/* 491 */         updateText(tempCoverage, "ZACOVBAK01", "");
/* 492 */         updateText(tempCoverage, "ZACOVBAK02", "");
/* 493 */         updateText(tempCoverage, "ZACOVBAK03", "");
/* 494 */         updateText(tempCoverage, "ZACOVBAK04", "");
/* 495 */         updateText(tempCoverage, "ZACOVBAK05", "");
/*     */ 
/* 497 */         coverageList.addContent(tempCoverage);
/*     */       }
/*     */ 
/* 501 */       Element bnfList = policy.getChild("BeneficiaryList");
/* 502 */       Element bnf = bnfList.getChild("Beneficiary");
/* 503 */       bnfList.removeContent();
/*     */ 
/* 506 */       if (this.tLNPInsuredSchema.getInsuredPeoples() > 0) {
/* 507 */         for (int x = 1; x <= this.tLNPBnfSet.size(); x++) {
/* 508 */           LNPBnfSchema tempSchema = this.tLNPBnfSet.get(x);
/* 509 */           Element tempBnf = (Element)bnf.clone();
/* 510 */           updateText(tempBnf, "BNYTYPE", "0" + tempSchema.getBenefitType());
/* 511 */           updateText(tempBnf, "BNYSEL", tempSchema.getBnfNo());
/* 512 */           updateText(tempBnf, "SALUTL04", "MR / MRS");
/* 513 */           updateText(tempBnf, "LSURNAME04", tempSchema.getBnfName());
/* 514 */           updateText(tempBnf, "DOB04", fomartDate(tempSchema.getBnfBirthday()));
/* 515 */           updateText(tempBnf, "CLTSEX04", mappingCode(tempSchema.getBnfSex(), "BankPolicySex"));
/* 516 */           updateText(tempBnf, "MARRYD04", "");
/* 517 */           updateText(tempBnf, "ZACLTADDR04", "");
/* 518 */           updateText(tempBnf, "ADDRTYPE04", "");
/* 519 */           updateText(tempBnf, "ZNBUSUT04", "");
/* 520 */           updateText(tempBnf, "CTRYCODE04", "");
/* 521 */           updateText(tempBnf, "NATLTY04", "");
/* 522 */           updateText(tempBnf, "IDNPRF04", mappingCode(tempSchema.getIDType(), "BankCertType"));
/* 523 */           updateText(tempBnf, "SECUITYNO04", tempSchema.getIDNo());
/* 524 */           updateText(tempBnf, "EXPDTE04", "1".equals(tempSchema.getIDPerpetual()) ? fomartDate(tempSchema.getIDValidity()) : fomartDate(mappingCode(tempSchema.getIDPerpetual(), "BankCertificatesType")));
/* 525 */           updateText(tempBnf, "ZNPIDCPYID04", "");
/* 526 */           updateText(tempBnf, "CLTRELN02", mappingCode(tempSchema.getRelationToInsured(), "BankBenefitAndInsured"));
/* 527 */           updateText(tempBnf, "BNYPC", turnNullToString(Double.valueOf(tempSchema.getBenefitRate())));
/* 528 */           updateText(tempBnf, "ZBNYTLVL", Integer.parseInt(tempSchema.getBenefitOrder()) < 10 ? "0" + tempSchema.getBenefitOrder() : tempSchema.getBenefitOrder());
/* 529 */           updateText(tempBnf, "EFFDATE", "");
/* 530 */           updateText(tempBnf, "ZDCLMPLN", mappingCode(this.tLNPInsuredSchema.getCreditGrade(), "BankIsOrNo"));
/* 531 */           bnfList.addContent(tempBnf);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 536 */       if ("02".equals(this.tLNPPaymentSchema.getPayMent1())) {
/* 537 */         Element FRTRecBank = policy.getChild("FRTRecBank");
/* 538 */         updateText(FRTRecBank, "BANKKEY02", this.tLNPPaymentSchema.getBankCode());
/* 539 */         updateText(FRTRecBank, "BANKACCKEY02", this.tLNPPaymentSchema.getAccount());
/* 540 */         updateText(FRTRecBank, "BANKDESC02", this.tLNPPaymentSchema.getBankCode());
/* 541 */         updateText(FRTRecBank, "BNKACTYP02", "");
/* 542 */         updateText(FRTRecBank, "CURRCODE02", "");
/* 543 */         updateText(FRTRecBank, "DATEFROM01", this.tLNPContSchema.getPValiDate());
/* 544 */         updateText(FRTRecBank, "DATETO", "");
/*     */       }
/*     */ 
/* 547 */       if ("02".equals(this.tLNPPaymentSchema.getPayMent2())) {
/* 548 */         Element SEQRecBank = policy.getChild("SEQRecBank");
/* 549 */         updateText(SEQRecBank, "BANKKEY03", this.tLNPPaymentSchema.getBankCode());
/* 550 */         updateText(SEQRecBank, "BANKACCKEY03", this.tLNPPaymentSchema.getAccount());
/* 551 */         updateText(SEQRecBank, "BANKDESC03", this.tLNPPaymentSchema.getBankCode());
/* 552 */         updateText(SEQRecBank, "BNKACTYP03", "");
/* 553 */         updateText(SEQRecBank, "CURRCODE03", "CNY");
/* 554 */         updateText(SEQRecBank, "DATEFROM02", this.tLNPContSchema.getPValiDate());
/* 555 */         updateText(SEQRecBank, "DATETO02", "");
/*     */       }
/*     */ 
/* 559 */       updateText(policy, "TRANDATEX", "");
/* 560 */       updateText(policy, "BANKCODER", "");
/* 561 */       updateText(policy, "TCHQDATE", "");
/* 562 */       updateText(policy, "BANKDESC01R", "1");
/* 563 */       updateText(policy, "BANKDESC03R", "");
/* 564 */       updateText(policy, "RFCODE", "CN");
/* 565 */       updateText(policy, "RFNUM", "");
/* 566 */       updateText(policy, "PAYTYPE", "");
/* 567 */       updateText(policy, "DOCORIGAMT", "");
/* 568 */       updateText(policy, "ZNOVRPAYOP", "");
/*     */ 
/* 571 */       LNPPolSet tset = new LNPPolDB(this.con).executeQuery("select * from lnppol where contno='" + this.tContNo + "' and RiskVersion is not null and RiskVersion<>'' and RnewFlag='1'");
/* 572 */       if (tset.size() > 0) {
/* 573 */         Element packageInfo = policy.getChild("PackageInfo");
/* 574 */         System.out.println(tset.get(1).getRiskVersion());
/* 575 */         updateText(packageInfo, "ZNPKGCODE", tset.get(1).getRiskVersion());
/* 576 */         updateText(packageInfo, "TOTPRE", turnNullToString(tset.get(1).getRemark()));
/* 577 */         updateText(packageInfo, "ZTOTSI", "");
/*     */       }
/*     */ 
/* 581 */       Element remark = policy.getChild("GeneralRemark");
/* 582 */       updateText(remark, "ALINE01", "");
/* 583 */       updateText(remark, "ALINE02", "");
/*     */ 
/* 585 */       updateText(policy, "SACSCODE", "");
/* 586 */       updateText(policy, "SACSTYPE", "");
/* 587 */       updateText(policy, "CAMPAIGN", "");
/* 588 */       updateText(policy, "ZNPRJTCD", "");
/* 589 */       updateText(policy, "ZNEPOLFLG", "");
/* 590 */       updateText(policy, "ZNBNKODR", "");
/* 591 */       updateText(policy, "ZNDISPER", "");
/* 592 */       updateText(policy, "ZNSPCTYP", "");
/* 593 */       updateText(policy, "ZNBILLNO", "");
/* 594 */       updateText(policy, "ZNINVBNK", "");
/* 595 */       updateText(policy, "ZNVIPIND", "");
/*     */ 
/* 597 */       updateText(policy, "ZAPOLFLD1", "");
/* 598 */       updateText(policy, "ZAPOLFLD2", "");
/* 599 */       updateText(policy, "ZAPOLFLD3", "");
/* 600 */       updateText(policy, "ZAPOLFLD4", "");
/* 601 */       updateText(policy, "ZAPOLFLD5", "");
/*     */ 
/* 603 */       Element hisIn = auratx.getChild("HisIn");
/* 604 */       Element polhis = hisIn.getChild("POLHIS");
/* 605 */       Element inPolicyOwner = polhis.getChild("PolicyOwner");
/* 606 */       updateText(inPolicyOwner, "OWNERSEL05", this.tLNPAppntSchema.getAppntNo());
/* 607 */       updateText(inPolicyOwner, "LSURNAME05", this.tLNPAppntSchema.getAppntName());
/* 608 */       updateText(inPolicyOwner, "DOB05", "");
/* 609 */       updateText(inPolicyOwner, "CLTSEX05", "");
/* 610 */       updateText(inPolicyOwner, "SECUITYNO05", "");
/* 611 */       updateText(inPolicyOwner, "RMBLPHONE05", "");
/* 612 */       updateText(inPolicyOwner, "CLTPHONE05", "");
/*     */ 
/* 614 */       Element inInsured = polhis.getChild("InsuredList").getChild("Insured");
/* 615 */       updateText(inInsured, "LIFCNUM06", this.tLNPInsuredSchema.getInsuredNo());
/* 616 */       updateText(inInsured, "LSURNAME06", this.tLNPInsuredSchema.getName());
/* 617 */       updateText(inInsured, "DOB06", "");
/* 618 */       updateText(inInsured, "CLTSEX06", "");
/* 619 */       updateText(inInsured, "SECUITYNO06", "");
/* 620 */       updateText(inInsured, "RMBLPHONE06", "");
/* 621 */       updateText(inInsured, "CLTPHONE06", "");
/*     */ 
/* 623 */       List benefList = polhis.getChildren("BeneficiaryList");
/* 624 */       Element benLst = (Element)benefList.get(benefList.size() - 1);
/* 625 */       Element beneficiary = benLst.getChild("Beneficiary");
/* 626 */       benLst.removeContent();
/* 627 */       for (int x = 1; x <= this.tLNPBnfSet.size(); x++) {
/* 628 */         LNPBnfSchema tempSchema = this.tLNPBnfSet.get(x);
/* 629 */         Element benef = (Element)beneficiary.clone();
/* 630 */         updateText(benef, "LSURNAME07", tempSchema.getBnfName());
/* 631 */         updateText(benef, "BNYSEL07", "");
/* 632 */         updateText(benef, "DOB07", "");
/* 633 */         updateText(benef, "CLTSEX07", "");
/* 634 */         updateText(benef, "SECUITYNO07", "");
/*     */       }
/*     */ 
/* 637 */       Element policiInfo = polhis.getChild("PolicyInfo");
/*     */ 
/* 639 */       updateText(policiInfo, "CNTBRANCH02", company);
/* 640 */       updateText(policiInfo, "TTMPRCNO02", this.tContNo);
/* 641 */       updateText(policiInfo, "CHDRNUM02", this.tLNPContSchema.getMainPolNo());
/* 642 */       updateText(policiInfo, "ZNAGNTSEL02", this.tLNPAgentInfoSet.get(1).getAgentCode());
/* 643 */       updateText(policiInfo, "CHDRTYPE", "");
/* 644 */       updateText(policiInfo, "ZNCSMNAME02", "");
/* 645 */       updateText(policiInfo, "HPROPDTE02", fomartDate(this.tLNPContSchema.getPSignDate()));
/* 646 */       updateText(policiInfo, "LIFE02", "01");
/*     */ 
/* 648 */       Element covlist = policiInfo.getChild("COVLIST");
/* 649 */       updateText(covlist, "COVERAGE02", "");
/* 650 */       updateText(covlist, "RIDER02", "");
/* 651 */       updateText(covlist, "ZNPRDCODE02", "");
/* 652 */       covlist.removeContent();
/* 653 */       return true;
/*     */     }
/*     */     catch (Exception e) {
/* 656 */       e.printStackTrace();
/* 657 */     }return false;
/*     */   }
/*     */ 
/*     */   private String mappingQues(String code, String otherSign, String contNo)
/*     */   {
/* 664 */     return null;
/*     */   }
/*     */ 
/*     */   private String combAddress(String companyFax, String bp2, String companyAddress)
/*     */   {
/* 670 */     return null;
/*     */   }
/*     */ 
/*     */   protected boolean getInputData(String tContNo)
/*     */   {
/*     */     try
/*     */     {
/* 677 */       this.valiPassFlag = true;
/* 678 */       if ((tContNo == null) || (tContNo.equals(""))) {
/* 679 */         return this.valiPassFlag = 0;
/*     */       }
/*     */ 
/* 682 */       LNPContDB tLNPContDB = new LNPContDB(this.con);
/* 683 */       tLNPContDB.setContNo(tContNo);
/* 684 */       if (!tLNPContDB.getInfo()) {
/* 685 */         this.message = "\u951F\u65A4\u62F7\u53D6\u6295\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F\u5931\u951F\u6770\uFF4F\u62F7";
/* 686 */         return this.valiPassFlag = 0;
/*     */       }
/* 688 */       this.tLNPContSchema = tLNPContDB.getSchema();
/* 689 */       String msg = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u72E1\u2605\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u7889\u62F7\u951F\u65A4\u62F7\u606F\u951F\u7B4B\uFF01";
/* 690 */       if ((turnNullToString(this.tLNPContSchema.getManageCom()).equals("")) || (turnNullToString(this.tLNPContSchema.getPValiDate()).equals("")) || 
/* 691 */         (turnNullToString(this.tLNPContSchema.getPSignDate()).equals(""))) {
/* 692 */         this.message = msg;
/* 693 */         return this.valiPassFlag = 0;
/*     */       }
/*     */ 
/* 698 */       this.tLNPPolSet = new LNPPolDB(this.con).executeQuery("select * from LNPPol where contno='" + tContNo + "'");
/* 699 */       if (this.tLNPPolSet.size() <= 0) {
/* 700 */         this.message = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5199\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F\u951F\u65A4\u62F7";
/* 701 */         return this.valiPassFlag = 0;
/*     */       }
/* 703 */       this.tLNPPolSet2 = this.tLNPPolSet;
/*     */ 
/* 705 */       this.tLNPPolSet = new LNPPolDB(this.con).executeQuery("select * from lnppol where contno='" + tContNo + "' and (RiskVersion is null or RiskVersion='')");
/* 706 */       String msg = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u72E1\u2605\u62F7\u6295\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u7B4B\u201D\u951F\u53EB\u2605\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u7889\u62F7\u951F\u65A4\u62F7\u606F\u951F\u7B4B\uFF01";
/* 707 */       for (int i = 1; i <= this.tLNPPolSet.size(); i++) {
/* 708 */         LNPPolSchema tSchema = this.tLNPPolSet.get(i);
/*     */ 
/* 710 */         if ((!turnNullToString(tSchema.getRiskVersion()).equals("")) || (
/* 711 */           (!turnNullToString(Integer.valueOf(tSchema.getPayIntv())).equals("")) && (!turnNullToString(tSchema.getRiskCode()).equals("")) && (
/* 712 */           (!turnNullToString(Double.valueOf(tSchema.getAmnt())).equals("")) || (!turnNullToString(Double.valueOf(tSchema.getPrem())).equals(""))))) continue;
/* 713 */         this.message = msg;
/* 714 */         return this.valiPassFlag = 0;
/*     */       }
/*     */ 
/* 721 */       LNPCUWMasterDB cuw = new LNPCUWMasterDB(this.con);
/* 722 */       cuw.setContNo(tContNo);
/* 723 */       if (cuw.getInfo()) {
/* 724 */         this.tLNPCUWMasterSchema = cuw.getSchema();
/*     */       }
/*     */ 
/* 727 */       this.tLNPUWMasterSet = new LNPUWMasterDB(this.con).executeQuery("select * from LNPUWMaster where ContNo='" + tContNo + "'");
/*     */ 
/* 730 */       this.tLNPAppntSchema = new LNPAppntDB(this.con).executeQuery("select * from lnpappnt where contno='" + tContNo + "'").get(1);
/* 731 */       this.tAppntAddressSchema = new LNPAddressDB(this.con).executeQuery("select * from lnpaddress a where  exists(select 1 from lnpappnt b where a.customerid=b.appntid  and b.contno='" + tContNo + "')").get(1);
/* 732 */       if ((this.tLNPAppntSchema == null) || (this.tAppntAddressSchema == null)) {
/* 733 */         this.message = "\u7F3A\u5931\u6295\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F\u951F\u65A4\u62F7";
/* 734 */         return this.valiPassFlag = 0;
/*     */       }
/* 736 */       String msg = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u72E1\u2605\u62F7\u951F\u9175\u4F19\u62F7\u951F\u65A4\u62F7\u606F\u951F\u65A4\u62F7\u951F\u53EB\u2605\u62F7\u6295\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u7889\u62F7\u951F\u65A4\u62F7\u606F\u951F\u7B4B\uFF01";
/* 737 */       LNPAppntSchema tSchema = this.tLNPAppntSchema;
/* 738 */       if ((turnNullToString(tSchema.getAppntName()).equals("")) || (turnNullToString(Integer.valueOf(tSchema.getAppntAge())).equals("")) || 
/* 739 */         (turnNullToString(tSchema.getAppntSex()).equals("")) || (turnNullToString(tSchema.getAppntBirthday()).equals("")) || 
/* 740 */         (turnNullToString(this.tAppntAddressSchema.getCompanyAddress()).equals("")) || 
/* 741 */         (turnNullToString(this.tAppntAddressSchema.getCompanyZipCode()).equals("")) || (turnNullToString(tSchema.getNativePlace()).equals("")) || 
/* 742 */         (turnNullToString(tSchema.getIDType()).equals("")) || (turnNullToString(tSchema.getIDNo()).equals("")) || 
/* 743 */         (turnNullToString(tSchema.getIDValidity()).equals("")) || (turnNullToString(tSchema.getRelationToInsured()).equals(""))) {
/* 744 */         this.message = msg;
/* 745 */         return this.valiPassFlag = 0;
/*     */       }
/*     */ 
/* 749 */       this.tLNPInsuredSchema = new LNPInsuredDB(this.con).executeQuery("select * from LNPInsured where contno='" + tContNo + "'").get(1);
/* 750 */       this.tInsurAddressSchema = new LNPAddressDB(this.con).executeQuery("select * from lnpaddress a where  exists(select 1 from lnpinsured b where a.customerid=b.insuredid  and b.contno='" + tContNo + "')").get(1);
/* 751 */       if ((this.tLNPInsuredSchema == null) || (this.tInsurAddressSchema == null)) {
/* 752 */         this.message = "\u7F3A\u5931\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F\u951F\u65A4\u62F7";
/* 753 */         return this.valiPassFlag = 0;
/*     */       }
/* 755 */       String msg = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u72E1\u2605\u62F7\u951F\u9175\u4F19\u62F7\u951F\u65A4\u62F7\u606F\u951F\u65A4\u62F7\u951F\u53EB\u2605\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u7889\u62F7\u951F\u65A4\u62F7\u606F\u951F\u7B4B\uFF01";
/* 756 */       LNPInsuredSchema tSchema = this.tLNPInsuredSchema;
/* 757 */       if ((turnNullToString(tSchema.getName()).equals("")) || (turnNullToString(Integer.valueOf(tSchema.getAppAge())).equals("")) || 
/* 758 */         (turnNullToString(tSchema.getSex()).equals("")) || (turnNullToString(tSchema.getBirthday()).equals("")) || 
/* 759 */         (turnNullToString(this.tInsurAddressSchema.getCompanyAddress()).equals("")) || 
/* 760 */         (turnNullToString(this.tInsurAddressSchema.getCompanyZipCode()).equals("")) || (turnNullToString(tSchema.getNativePlace()).equals("")) || 
/* 761 */         (turnNullToString(tSchema.getIDType()).equals("")) || (turnNullToString(tSchema.getIDNo()).equals("")) || 
/* 762 */         (turnNullToString(tSchema.getIDValidity()).equals(""))) {
/* 763 */         this.message = msg;
/* 764 */         return this.valiPassFlag = 0;
/*     */       }
/*     */ 
/* 769 */       this.tLNPBnfSet = new LNPBnfDB(this.con).executeQuery("select * from lnpbnf where contno='" + tContNo + "' and (health is null or health<>'delete') order by bnforder");
/* 770 */       if ((this.tLNPInsuredSchema.getInsuredPeoples() > 0) && (this.tLNPBnfSet.size() > 0)) {
/* 771 */         String msg = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u72E1\u2605\u62F7\u951F\u9175\u4F19\u62F7\u951F\u65A4\u62F7\u606F\u951F\u65A4\u62F7\u951F\u53EB\u2605\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u7889\u62F7\u951F\u65A4\u62F7\u606F\u951F\u7B4B\uFF01";
/* 772 */         for (int i = 1; i <= this.tLNPBnfSet.size(); i++) {
/* 773 */           LNPBnfSchema tSchema = this.tLNPBnfSet.get(i);
/* 774 */           if ((!turnNullToString(Double.valueOf(tSchema.getBenefitRate())).equals("")) && (!turnNullToString(tSchema.getBenefitOrder()).equals("")) && 
/* 775 */             (!turnNullToString(this.tLNPInsuredSchema.getCreditGrade()).equals(""))) continue;
/* 776 */           this.message = msg;
/* 777 */           return this.valiPassFlag = 0;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 783 */       LNPPaymentDB tLNPPaymentDB = new LNPPaymentDB(this.con);
/* 784 */       tLNPPaymentDB.setContNo(tContNo);
/* 785 */       if (tLNPPaymentDB.getInfo()) {
/* 786 */         this.tLNPPaymentSchema = tLNPPaymentDB.getSchema();
/* 787 */         String msg = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u72E1\u2605\u62F7\u951F\u65A4\u62F7\u77E5\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6743\u951F\u65A4\u62F7\u951F\u53EB\u2605\u62F7\u951F\u79F8\u9769\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u7889\u62F7\u951F\u65A4\u62F7\u606F\u951F\u7B4B\uFF01";
/* 788 */         LNPPaymentSchema tSchema = this.tLNPPaymentSchema;
/* 789 */         if ((turnNullToString(tSchema.getPayMent1()).equals("")) || (turnNullToString(tSchema.getPayMent2()).equals(""))) {
/* 790 */           this.message = msg;
/* 791 */           return this.valiPassFlag = 0;
/*     */         }
/*     */       } else {
/* 794 */         this.message = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5199\u951F\u79F8\u9769\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F\u951F\u65A4\u62F7";
/* 795 */         return this.valiPassFlag = 0;
/*     */       }
/*     */ 
/* 798 */       LNPBonusInfoDB tLNPBonusInfoDB = new LNPBonusInfoDB(this.con);
/* 799 */       tLNPBonusInfoDB.setContNo(tContNo);
/* 800 */       if (tLNPBonusInfoDB.getInfo()) {
/* 801 */         this.tLNPBonusInfoSchema = tLNPBonusInfoDB.getSchema();
/* 802 */         String msg = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u72E1\u2605\u62F7\u6295\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u7B4B\u201D\u951F\u53EB\u2605\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u7B4B\u201D\u951F\u65A4\u62F7\u951F\u8857\u7889\u62F7\u951F\u65A4\u62F7\u606F\u951F\u7B4B\uFF01";
/* 803 */         tSchema = this.tLNPBonusInfoSchema;
/* 804 */         if ((turnNullToString(tSchema.getBonusWay()).equals("")) || (turnNullToString(tSchema.getP2()).equals(""))) {
/* 805 */           this.message = msg;
/* 806 */           return this.valiPassFlag = 0;
/*     */         }
/*     */       } else {
/* 809 */         this.message = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5199\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F\u951F\u65A4\u62F7";
/* 810 */         return this.valiPassFlag = 0;
/*     */       }
/*     */ 
/* 813 */       this.tLNPAgentInfoSet = new LNPAgentInfoDB(this.con).executeQuery("select * from lnpagentinfo where contno='" + tContNo + "'");
/* 814 */       if (this.tLNPAgentInfoSet.size() <= 0) {
/* 815 */         this.message = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u77EB\u8FBE\u62F7\u951F\u65A4\u62F7\u951F\u527F\uFF4F\u62F7";
/* 816 */         return this.valiPassFlag = 0;
/*     */       }
/* 818 */       String msg = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u72E1\u2605\u62F7\u951F\u65A4\u62F7\u77E5\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u6743\u951F\u65A4\u62F7\u951F\u53EB\u2605\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u527F\u9769\u62F7\u77E5\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u7889\u62F7\u951F\u65A4\u62F7\u606F\u951F\u7B4B\uFF01";
/* 819 */       LNPBonusInfoSchema tSchema = this.tLNPAgentInfoSet.get(1);
/*     */ 
/* 827 */       this.tLNPInvestmentInfoSchema = new LNPInvestmentInfoDB(this.con).executeQuery("select * from LNPInvestmentInfo where contno='" + tContNo + "'").get(1);
/*     */ 
/* 829 */       this.tLNpInvestmentAccountInfoSet = new LNPInvestmentAccountInfoDB(this.con).executeQuery("select * from LNPInvestmentAccountInfo where contno='" + tContNo + "'");
/*     */ 
/* 831 */       this.tLnpRiskAmountSet = new LNPRiskAmountDB(this.con).executeQuery("select * from LNPRiskAmount where contno='" + tContNo + "'");
/*     */     }
/*     */     catch (RuntimeException e) {
/* 834 */       e.printStackTrace();
/* 835 */       return this.valiPassFlag = 0;
/*     */     }
/* 837 */     return true;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/* 841 */     NPUWBean cal = new NPUWBean();
/* 842 */     String tContNo = "123213213123";
/* 843 */     tContNo = "098765432111";
/*     */ 
/* 845 */     tContNo = "098765432115";
/* 846 */     tContNo = "098765431111";
/*     */ 
/* 848 */     cal.calInterfaces(tContNo);
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.interfaces.NPUWBean
 * JD-Core Version:    0.6.0
 */