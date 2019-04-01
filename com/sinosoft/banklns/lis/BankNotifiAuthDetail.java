/*      */ package com.sinosoft.banklns.lis;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.bean.BankLNPAgentInfoBean;
/*      */ import com.sinosoft.banklns.lis.bean.BankLNPContBean;
/*      */ import com.sinosoft.banklns.lis.bean.BankLNPCustImpQueBean;
/*      */ import com.sinosoft.banklns.lis.bean.BankLNPCustImpResultBean;
/*      */ import com.sinosoft.banklns.lis.bean.BankLNPPaymentBean;
/*      */ import com.sinosoft.banklns.lis.db.LNPAgentInfoDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPCustImpQueDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPCustImpResultDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPPaymentDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
/*      */ import com.sinosoft.banklns.lis.pubfun.MMap;
/*      */ import com.sinosoft.banklns.lis.pubfun.PubSubmit;
/*      */ import com.sinosoft.banklns.lis.pubfun.SysMaxNoMAPNP;
/*      */ import com.sinosoft.banklns.lis.schema.LNPAgentInfoSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPCustImpQueSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPCustImpResultSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPPaymentSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPAgentInfoSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPCustImpQueSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPCustImpResultSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPPaymentSet;
/*      */ import com.sinosoft.banklns.lnsmodel.BankOperateDeal;
/*      */ import com.sinosoft.banklns.lnsmodel.BankPolicyState;
/*      */ import com.sinosoft.banklns.lnsmodel.PolicyMainInfo;
/*      */ import com.sinosoft.banklns.utility.ExeSQL;
/*      */ import com.sinosoft.banklns.utility.PubFun;
/*      */ import com.sinosoft.banklns.utility.SSRS;
/*      */ import com.sinosoft.banklns.utility.VData;
/*      */ import java.io.PrintStream;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Hashtable;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import javax.faces.context.ExternalContext;
/*      */ import javax.faces.context.FacesContext;
/*      */ import javax.faces.model.SelectItem;
/*      */ import javax.servlet.http.HttpSession;
/*      */ 
/*      */ public class BankNotifiAuthDetail extends BankBasicBL
/*      */ {
/*      */   private boolean editFlag;
/*      */   private boolean alertFlag;
/*      */   private String message;
/*   47 */   private ArrayList<String> Errors = new ArrayList();
/*      */ 
/*   49 */   private boolean quesHasFlag = false;
/*   50 */   private boolean agentInfHasFlag = false;
/*   51 */   private boolean paymentHasFlag = false;
/*   52 */   private boolean allComplete = false;
/*   53 */   private boolean quesComplete = false;
/*   54 */   private boolean agentInfComplete = false;
/*   55 */   private boolean paymentComplete = false;
/*      */   private IGlobalInput GI;
/*   58 */   private String ContNo = "";
/*      */   private BankLNPContBean contBean;
/*      */   private BankLNPPaymentBean paymentBean;
/*      */   private BankLNPAgentInfoBean agentInfoBean;
/*   64 */   private List<BankLNPCustImpQueBean> Appntanswers = new ArrayList();
/*   65 */   private List<BankLNPCustImpQueBean> Insuranswers = new ArrayList();
/*      */   private BankLNPContBean contBeanBackup;
/*      */   private BankLNPPaymentBean paymentBeanBackup;
/*      */   private BankLNPAgentInfoBean agentInfoBeanBackup;
/*   70 */   private List<BankLNPCustImpResultBean> AppntanswersBackup = new ArrayList();
/*   71 */   private List<BankLNPCustImpResultBean> InsuranswersBackup = new ArrayList();
/*      */   private String FirPayType;
/*      */   private String EscPayType;
/*      */   private String ACounter;
/*      */   private String AuthBank;
/*      */   private String AuthACount;
/*      */   private String SignDate;
/*      */   private String TargetDate;
/*      */   private String AgentTrantype;
/*      */   private String AgentBranchattr;
/*      */   private String AgentBranchattrNm;
/*      */   private String AgentCode;
/*      */   private String PolPrintType;
/*      */   private BankOperateDeal stateOperate;
/*      */   private BankPolicyState policyState;
/*  102 */   public static Map<String, String> brchAttrNmMap = new Hashtable();
/*  103 */   private List<SelectItem> bankCodeList = new ArrayList();
/*      */   private String saleChannelCode;
/*      */   private String AppntIsAllSelc;
/*      */   private String InsurIsAllSelc;
/*      */   private String quesType;
/*      */   private String quesId;
/*      */   private String quesVal;
/*      */   private String quesText;
/*      */   private String limtType;
/*      */   private String tTargetDate;
/*      */   private String tSignDate;
/*      */   private String tAgentCode;
/* 1636 */   public boolean isRiskBQ = false;
/*      */ 
/* 1638 */   public boolean isRiskBR = false;
/*      */ 
/*      */   static
/*      */   {
/* 1283 */     initBrchAttrNmMap();
/*      */   }
/*      */ 
/*      */   public String getPolPrintType()
/*      */   {
/*   91 */     return this.PolPrintType;
/*      */   }
/*      */   public void setPolPrintType(String polPrintType) {
/*   94 */     this.PolPrintType = polPrintType;
/*      */   }
/*      */ 
/*      */   public static void main(String[] args)
/*      */   {
/*  108 */     BankNotifiAuthDetail detal = new BankNotifiAuthDetail();
/*  109 */     detal.initQuestionList();
/*  110 */     System.out.println(detal.Appntanswers.size() + "---" + detal.Insuranswers.size());
/*      */   }
/*      */   public BankNotifiAuthDetail() {
/*  113 */     System.out.println("----------------->\u6784\u9020\u51FD\u6570initDetail<-------------------------");
/*  114 */     HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*  115 */     this.ContNo = ((String)session.getAttribute("ContNo"));
/*  116 */     initQuestionList();
/*      */   }
/*      */ 
/*      */   public void initDetail()
/*      */   {
/*  121 */     label563: 
/*      */     try { System.out.println("-------------------->initDetail<--------------------------");
/*  122 */       this.alertFlag = false;
/*  123 */       this.message = "";
/*  124 */       this.Errors = new ArrayList();
/*  125 */       this.quesHasFlag = false;
/*  126 */       this.agentInfHasFlag = false;
/*  127 */       this.paymentHasFlag = false;
/*  128 */       this.allComplete = false;
/*  129 */       this.editFlag = true;
/*      */ 
/*  131 */       initQuestionList();
/*      */ 
/*  133 */       initPaymentNotiMsg(new BankLNPContBean(), new BankLNPPaymentBean());
/*      */ 
/*  135 */       initAgenNotiMsg(new BankLNPContBean(), new BankLNPAgentInfoBean());
/*  136 */       if (getInfoFromSession()) {
/*  137 */         this.contBean = recOneContInfo(this.ContNo);
/*  138 */         if (!"".equals(this.contBean.getSchema().getContNo())) {
/*  139 */           String contNo = this.contBean.getSchema().getContNo();
/*      */ 
/*  141 */           this.quesHasFlag = isExistQues(contNo);
/*  142 */           this.paymentHasFlag = isExistPayment(contNo);
/*  143 */           if (this.paymentHasFlag)
/*  144 */             initPaymentNotiMsg(this.contBean, this.paymentBean);
/*      */           else {
/*  146 */             this.ACounter = this.contBean.getSchema().getAppntName();
/*      */           }
/*  148 */           this.agentInfHasFlag = isExistAgentInf(contNo);
/*  149 */           if (this.agentInfHasFlag)
/*  150 */             initAgenNotiMsg(this.contBean, this.agentInfoBean);
/*      */           else {
/*  152 */             this.SignDate = formatDate(turnNullToString(this.agentInfoBean.getSchema().getP4()), "YYYYMMDD");
/*      */           }
/*      */ 
/*  156 */           this.stateOperate = new BankOperateDeal();
/*  157 */           boolean tEditFlag = 
/*  158 */             this.stateOperate.isEidtSheet(this.contBean.getSchema().getState(), "04", this.GI.LNPRole, contNo);
/*  159 */           HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*  160 */           Boolean tQueyEditFlag = (Boolean)session.getAttribute("Queryflag");
/*  161 */           if (tQueyEditFlag == null) {
/*  162 */             tQueyEditFlag = Boolean.valueOf(true);
/*      */           }
/*  164 */           this.editFlag = ((tEditFlag) && (tQueyEditFlag.booleanValue()));
/*      */ 
/*  166 */           System.out.println("---------------->\u521D\u59CBMsg\uFF1A quesHasFlag\uFF1A" + this.quesHasFlag + "|paymentHasFlag:" + this.paymentHasFlag + "|agentInfHasFlag:" + this.agentInfHasFlag);
/*  167 */           System.out.println("---------------->\u521D\u59CBMsg\uFF1A\u5F53\u524Dsheet\u9875\u662F\u5426\u53EF\u7F16\u8F91(tEditFlag:" + tEditFlag + "&&tQueyEditFlag:" + tQueyEditFlag + ")\uFF1A" + this.editFlag + "|\u56E0\u4E3A~\u5F53\u524D\u4EBA\u5458\u7C7B\u578B\uFF1A" + this.GI.LNPRole + "|\u4FDD\u5355\u72B6\u6001\uFF1A" + this.contBean.getSchema().getState() + "|");
/*      */ 
/*  169 */           break label563;
/*      */         } } else {
/*  170 */         buildMsg("\u5168\u5C40\u6295\u4FDD\u4E66\u4FE1\u606F\u7F3A\u5931!");
/*      */       }
/*      */     } catch (Exception e)
/*      */     {
/*  174 */       turnCurrPolicyLockFlag(null, this.ContNo, "unlock");
/*  175 */       e.printStackTrace();
/*  176 */       buildMsg("\u521D\u59CB\u5316\u4FE1\u606F\u5931\u8D25.\u56E0\u4E3A\uFF1A" + e.getMessage());
/*      */     }
/*      */     finally {
/*  179 */       reportMsg();
/*      */     }
/*      */   }
/*      */ 
/*      */   public void saveNotiMsg()
/*      */   {
/*  188 */     this.alertFlag = false;
/*      */ 
/*  190 */     label908: 
/*      */     try { System.out.println("------------------>saveNotiMsg: \u662F\u5426\u53EF\u7F16\u8F91\uFF1A" + this.editFlag + "\uFF0C\u4E0D\u53EF\u7F16\u8F91\u5219\u4E0D\u80FD\u4FDD\u5B58");
/*  191 */       if (this.editFlag) {
/*  192 */         VData cInputData = new VData();
/*  193 */         MMap map = new MMap();
/*  194 */         String curDate = PubFun.getCurrentDate();
/*  195 */         String curTime = PubFun.getCurrentTime();
/*  196 */         if ((!saveQuesMsg(map, this.quesHasFlag, this.contBean, this.Appntanswers, this.Insuranswers, curDate, curTime)) || 
/*  197 */           (!savePaymentMsg(map, this.paymentHasFlag, this.contBean, this.paymentBean, curDate, curTime)) || 
/*  198 */           (!saveAgentInfMsg(map, this.agentInfHasFlag, this.contBean, this.agentInfoBean, curDate, curTime))) {
/*  199 */           if (this.alertFlag) {
/*  200 */             System.out.println();
/*  201 */             System.out.println("\u5B58\u5728\u9519\u8BEF\uFF1A------------------" + this.message);
/*      */           }
/*  203 */           return;
/*      */         }
/*      */ 
/*  206 */         this.allComplete = ((this.quesComplete) && (this.paymentComplete) && (this.agentInfComplete));
/*  207 */         System.out.println("\u672C\u6B21\u5FC5\u5F55\u9879\u72B6\u6001\uFF1AquesComplete-" + this.quesComplete + " |paymentComplete-" + this.paymentComplete + "|agentInfComplete+" + this.agentInfComplete + "| \u4FEE\u6539\u4E4B\u524D\uFF1Astate--\u300B" + this.contBean.getSchema().getState() + "editstate---\u300B" + this.contBean.getSchema().getEditstate());
/*  208 */         this.stateOperate = new BankOperateDeal();
/*  209 */         boolean isChangeToCustomerMsg = false;
/*      */ 
/*  211 */         if (this.allComplete) {
/*  212 */           List stateList = this.stateOperate.infoOprate(this.contBean.getSchema().getState(), 
/*  213 */             this.contBean.getSchema().getEditstate(), "modify", "04");
/*  214 */           this.contBean.getSchema().setState((String)stateList.get(0));
/*  215 */           this.contBean.getSchema().setEditstate((String)stateList.get(1));
/*  216 */         } else if ("01".equals(this.contBean.getSchema().getState())) {
/*  217 */           String editState = this.stateOperate.updateEditStateUNDone(this.contBean.getSchema().getEditstate(), 4);
/*  218 */           this.contBean.getSchema().setEditstate(editState);
/*      */         }
/*      */ 
/*  222 */         boolean isModifyfFlag = (this.paymentHasFlag) && (this.agentInfHasFlag) && (this.allComplete);
/*  223 */         List stateList = dealRefcOtherMsgBySuc(isModifyfFlag, this.contBean, this.paymentBean, this.agentInfoBean);
/*  224 */         if (stateList.size() > 0) {
/*  225 */           System.out.println("-------\u56E0\u4E3A\u6709\u4FDD\u5355\u4FE1\u606F\u88AB\u4FEE\u6539,\u5C06\u56DE\u6EDA\u4FDD\u5355\u72B6\u6001\u503C02\u5F85\u5BA1\u6838\u72B6\u6001---------");
/*  226 */           isChangeToCustomerMsg = true;
/*  227 */           this.contBean.getSchema().setState((String)stateList.get(0));
/*  228 */           this.contBean.getSchema().setEditstate((String)stateList.get(1));
/*      */         }
/*      */ 
/*  231 */         System.out.println("\u4FEE\u6539\u4E4B\u540E\uFF1Astate--\u300B" + this.contBean.getSchema().getState() + "editstate---\u300B" + this.contBean.getSchema().getEditstate());
/*  232 */         this.contBean.getSchema().setModifyDate(curDate);
/*  233 */         this.contBean.getSchema().setModifyTime(curTime);
/*  234 */         this.contBean.getSchema().setInputOperator(this.GI.Operator);
/*  235 */         map.put(this.contBean.getSchema(), "UPDATE");
/*      */ 
/*  239 */         if ((this.AuthACount != null) && (!"".equals(this.AuthACount))) {
/*  240 */           String sql = "OPEN SYMMETRIC KEY key_encryption DECRYPTION BY CERTIFICATE cert_keyProtection;  update lnppayment set account=EncryptByKey(Key_GUID('key_encryption'),account) where contno='" + 
/*  241 */             this.contBean.getSchema().getContNo() + "'; " + 
/*  242 */             " CLOSE SYMMETRIC KEY key_encryption;";
/*      */ 
/*  244 */           map.put(sql, "UPDATE");
/*      */         }
/*      */ 
/*  248 */         cInputData.add(map);
/*  249 */         PubSubmit pubSubmit = new PubSubmit();
/*  250 */         if (!pubSubmit.submitData(cInputData, "")) {
/*  251 */           buildMsg("\u5BA2\u6237\u4FE1\u606F\u4FDD\u5B58\u5931\u8D25!");
/*  252 */           break label908;
/*      */         }try {
/*  254 */           this.policyState = new BankPolicyState();
/*  255 */           if (isChangeToCustomerMsg)
/*  256 */             this.policyState.savePolicyState(this.ContNo, this.contBean.getSchema().getState(), "3", curDate, curTime);
/*      */         } catch (Exception e) {
/*  258 */           e.printStackTrace();
/*  259 */           buildMsg("~~~~~~~~~~~~~~~~~~~~~\u4FDD\u5355\u72B6\u6001\u8BB0\u5F55\u63A5\u53E3\u62A5\u9519!");
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  266 */       e.printStackTrace();
/*  267 */       buildMsg(e.getMessage());
/*      */     } finally {
/*  269 */       turnCurrPolicyLockFlag(null, this.ContNo, "unlock");
/*  270 */       reportMsg();
/*      */     }
/*      */   }
/*      */ 
/*      */   private List<String> dealRefcOtherMsgBySuc(boolean isModify, BankLNPContBean contBean, BankLNPPaymentBean paymentBean, BankLNPAgentInfoBean agentInfoBean)
/*      */   {
/*  276 */     List list = new ArrayList();
/*      */     try {
/*  278 */       this.contBeanBackup = recOneContInfo(this.ContNo);
/*  279 */       if (isModify)
/*      */       {
/*  281 */         this.paymentBeanBackup = recPaymentInfo(this.ContNo);
/*  282 */         boolean isChangeToCustomerMsg = false;
/*  283 */         if ((!turnNullToString(paymentBean.getSchema().getPayMent1()).equals(turnNullToString(this.paymentBeanBackup.getSchema().getPayMent1()))) || 
/*  284 */           (!turnNullToString(paymentBean.getSchema().getPayMent2()).equals(turnNullToString(this.paymentBeanBackup.getSchema().getPayMent2()))) || 
/*  285 */           (!turnNullToString(contBean.getSchema().getAppntName()).equals(turnNullToString(this.contBeanBackup.getSchema().getAppntName()))) || 
/*  286 */           (!turnNullToString(paymentBean.getSchema().getBankCode()).equals(turnNullToString(this.paymentBeanBackup.getSchema().getBankCode()))) || 
/*  287 */           (!turnNullToString(paymentBean.getSchema().getAccount()).equals(turnNullToString(getDecryptAccount(this.ContNo))))) {
/*  288 */           isChangeToCustomerMsg = true;
/*  289 */           System.out.println("-------------------\u6536\u4ED8\u8D39\u4FE1\u606F\u6709\u8FC7\u6539\u52A8---------------------");
/*      */         }
/*      */ 
/*  292 */         this.agentInfoBeanBackup = recAgentInfo(this.ContNo);
/*  293 */         if ((!turnNullToString(contBean.getSchema().getPSignDate()).equals(turnNullToString(this.contBeanBackup.getSchema().getPSignDate()))) || 
/*  294 */           (!turnNullToString(agentInfoBean.getSchema().getP1()).equals(turnNullToString(this.agentInfoBeanBackup.getSchema().getP1()))) || 
/*  295 */           (!turnNullToString(agentInfoBean.getSchema().getP3()).equals(turnNullToString(this.agentInfoBeanBackup.getSchema().getP3()))) || 
/*  296 */           (!turnNullToString(agentInfoBean.getSchema().getP2()).equals(turnNullToString(this.agentInfoBeanBackup.getSchema().getP2()))) || 
/*  297 */           (!turnNullToString(agentInfoBean.getSchema().getP4()).equals(turnNullToString(this.agentInfoBeanBackup.getSchema().getP4()))) || 
/*  298 */           (!turnNullToString(agentInfoBean.getSchema().getAgentCode()).equals(turnNullToString(this.agentInfoBeanBackup.getSchema().getAgentCode())))) {
/*  299 */           isChangeToCustomerMsg = true;
/*  300 */           System.out.println("-------------------\u4EE3\u7406\u4EBA\u544A\u77E5\u4FE1\u606F\u6709\u8FC7\u6539\u52A8---------------------");
/*      */         }
/*      */ 
/*  303 */         if (recAllQuesAnswer(this.ContNo)) {
/*  304 */           boolean tFlag = false;
/*      */ 
/*  306 */           for (int i = 0; i < this.AppntanswersBackup.size(); i++) {
/*  307 */             if (tFlag) break;
/*  308 */             BankLNPCustImpResultBean custRstBean = (BankLNPCustImpResultBean)this.AppntanswersBackup.get(i);
/*  309 */             for (int j = 0; j < this.Appntanswers.size(); j++) {
/*  310 */               BankLNPCustImpQueBean custQuesBean = (BankLNPCustImpQueBean)this.Appntanswers.get(j);
/*  311 */               System.out.println("appnt_quesID---" + custQuesBean.getAppntQues().getSchema().getQuestionid() + "=?" + custRstBean.getSchema().getQuestionId());
/*  312 */               if (turnNullToString(custQuesBean.getAppntQues().getSchema().getQuestionid()).equals(custRstBean.getSchema().getQuestionId())) {
/*  313 */                 if (("2".equals(custRstBean.getSchema().getQuestionType())) && (!turnNullToString(custRstBean.getSchema().getAnswer()).equals(turnNullToString(custQuesBean.getAppntanswer())))) {
/*  314 */                   tFlag = isChangeToCustomerMsg = 1;
/*  315 */                   System.out.println("-------------------\u6295\u4FDD\u4EBA\u57FA\u672C\u544A\u77E5\u4FE1\u606F\u6709\u8FC7\u6539\u52A82---------------------");
/*  316 */                   break; } if ((!"1".equals(custRstBean.getSchema().getQuestionType())) || (turnNullToString(custRstBean.getSchema().getOptionId()).equals(turnNullToString(custQuesBean.getAppntanswer())))) break;
/*  317 */                 tFlag = isChangeToCustomerMsg = 1;
/*  318 */                 System.out.println("-------------------\u6295\u4FDD\u4EBA\u57FA\u672C\u544A\u77E5\u4FE1\u606F\u6709\u8FC7\u6539\u52A81---------------------");
/*      */ 
/*  320 */                 break;
/*      */               }
/*      */             }
/*      */ 
/*      */           }
/*      */ 
/*  326 */           for (int i = 0; i < this.InsuranswersBackup.size(); i++) {
/*  327 */             if (tFlag) break;
/*  328 */             BankLNPCustImpResultBean custRstBean = (BankLNPCustImpResultBean)this.InsuranswersBackup.get(i);
/*  329 */             for (int j = 0; j < this.Insuranswers.size(); j++) {
/*  330 */               BankLNPCustImpQueBean custQuesBean = (BankLNPCustImpQueBean)this.Insuranswers.get(j);
/*  331 */               System.out.println("insur_quesID---" + custQuesBean.getInsurQues().getSchema().getQuestionid() + "=?" + custRstBean.getSchema().getQuestionId());
/*  332 */               if (turnNullToString(custQuesBean.getInsurQues().getSchema().getQuestionid()).equals(custRstBean.getSchema().getQuestionId())) {
/*  333 */                 if (("2".equals(custRstBean.getSchema().getQuestionType())) && (!turnNullToString(custRstBean.getSchema().getAnswer()).equals(custQuesBean.getInsuranswer()))) {
/*  334 */                   tFlag = isChangeToCustomerMsg = 1;
/*  335 */                   System.out.println("-------------------\u88AB\u4FDD\u4EBA\u57FA\u672C\u544A\u77E5\u4FE1\u606F\u6709\u8FC7\u6539\u52A82---------------------");
/*  336 */                   break; } if ((!"1".equals(custRstBean.getSchema().getQuestionType())) || (turnNullToString(custRstBean.getSchema().getOptionId()).equals(custQuesBean.getInsuranswer()))) break;
/*  337 */                 tFlag = isChangeToCustomerMsg = 1;
/*  338 */                 System.out.println("-------------------\u88AB\u4FDD\u4EBA\u57FA\u672C\u544A\u77E5\u4FE1\u606F\u6709\u8FC7\u6539\u52A81---------------------");
/*      */ 
/*  340 */                 break;
/*      */               }
/*      */             }
/*      */           }
/*      */         }
/*  345 */         System.out.println("\u662F\u5426\u7B26\u5408\u4FEE\u6539+\u4FE1\u606F\u6709\u53D8\u52A8\uFF0C\u9700\u8981\u4FDD\u5355\u72B6\u6001\u56DE\u6EDA\u523002\uFF1A" + isChangeToCustomerMsg + " | \u5F53\u524D\u4FDD\u5355\u72B6\u6001\uFF1Astate\uFF1A" + contBean.getSchema().getState() + "|editstate:" + contBean.getSchema().getEditstate() + "|\u89D2\u8272:" + this.GI.LNPRole);
/*  346 */         if (isChangeToCustomerMsg)
/*      */         {
/*  348 */           list = this.stateOperate.changeMsgToModify(contBean.getSchema().getState(), contBean.getSchema().getEditstate(), this.GI.LNPRole);
/*      */         }
/*      */       }
/*      */ 
/*  352 */       copyMsg(this.contBeanBackup, this.paymentBeanBackup, this.agentInfoBeanBackup);
/*      */     } catch (Exception e) {
/*  354 */       e.printStackTrace();
/*      */     }
/*  356 */     return list;
/*      */   }
/*      */ 
/*      */   private void copyMsg(BankLNPContBean oriContBean, BankLNPPaymentBean oriAppntBean, BankLNPAgentInfoBean oriAgentinfoBean)
/*      */   {
/*  361 */     this.contBean.getSchema().setConsignNo(oriContBean.getSchema().getConsignNo());
/*      */   }
/*      */ 
/*      */   private String turnNullToString(Object object)
/*      */   {
/*  370 */     String rst = "";
/*      */     try {
/*  372 */       rst = object;
/*      */     } catch (Exception e) {
/*  374 */       e.printStackTrace();
/*  375 */       buildMsg(e.getMessage());
/*      */     }
/*  377 */     return rst.trim();
/*      */   }
/*      */ 
/*      */   public void changeSelcRadio()
/*      */   {
/*  390 */     System.out.println("-------------->changeSelcRadio<----------------AppntIsAllSelc:" + this.AppntIsAllSelc + "|InsurIsAllSelc:" + this.InsurIsAllSelc + "|quesType:" + this.quesType + "|quesId:" + this.quesId + "|quesVal:" + this.quesVal);
/*  391 */     System.out.println("-------------->changeSelcRadio<----------------quesText:" + this.quesText);
/*  392 */     if (this.quesType.indexOf("all") >= 0) {
/*  393 */       if (this.quesType.indexOf("appnt") >= 0) {
/*  394 */         for (int i = 0; i < this.Appntanswers.size(); i++) {
/*  395 */           String queType = ((BankLNPCustImpQueBean)this.Appntanswers.get(i)).getAppntQues().getQuestionType();
/*  396 */           if ("1".equals(queType)) {
/*  397 */             ((BankLNPCustImpQueBean)this.Appntanswers.get(i)).setAppntanswer(this.AppntIsAllSelc);
/*  398 */             ((BankLNPCustImpQueBean)this.Appntanswers.get(i)).setIsAppntAllSelected(this.AppntIsAllSelc);
/*      */           }
/*      */         }
/*      */ 
/*  402 */         dealQuesText(this.quesText);
/*      */       } else {
/*  404 */         for (int i = 0; i < this.Insuranswers.size(); i++) {
/*  405 */           String queType = ((BankLNPCustImpQueBean)this.Insuranswers.get(i)).getInsurQues().getQuestionType();
/*  406 */           if ("1".equals(queType)) {
/*  407 */             ((BankLNPCustImpQueBean)this.Insuranswers.get(i)).setInsuranswer(this.InsurIsAllSelc);
/*  408 */             ((BankLNPCustImpQueBean)this.Insuranswers.get(i)).setIsInsurAllSelected(this.InsurIsAllSelc);
/*      */           }
/*      */         }
/*  411 */         dealQuesText(this.quesText);
/*      */       }
/*      */     }
/*  414 */     else if (this.quesType.indexOf("appnt") >= 0)
/*      */     {
/*  416 */       for (int i = 0; i < this.Appntanswers.size(); i++) {
/*  417 */         if (((BankLNPCustImpQueBean)this.Appntanswers.get(i)).getAppntQues().getQuestionid().equals(this.quesId)) {
/*  418 */           ((BankLNPCustImpQueBean)this.Appntanswers.get(i)).setAppntanswer(this.quesVal);
/*  419 */           break;
/*      */         }
/*      */       }
/*      */ 
/*  423 */       boolean isSelcAll = true;
/*  424 */       for (int i = 0; i < this.Appntanswers.size(); i++) {
/*  425 */         BankLNPCustImpQueBean tQueBean = (BankLNPCustImpQueBean)this.Appntanswers.get(i);
/*  426 */         if ((!"1".equals(tQueBean.getAppntQues().getQuestionType())) || 
/*  427 */           (tQueBean.getAppntanswer().equals(this.quesVal))) continue;
/*  428 */         isSelcAll = false;
/*  429 */         break;
/*      */       }
/*      */ 
/*  433 */       if (!isSelcAll) {
/*  434 */         for (int i = 0; i < this.Appntanswers.size(); i++) {
/*  435 */           ((BankLNPCustImpQueBean)this.Appntanswers.get(i)).setIsAppntAllSelected("");
/*      */         }
/*      */       }
/*      */       else {
/*  439 */         for (int i = 0; i < this.Appntanswers.size(); i++) {
/*  440 */           ((BankLNPCustImpQueBean)this.Appntanswers.get(i)).setIsAppntAllSelected(this.quesVal);
/*      */         }
/*      */       }
/*  443 */       for (int i = 0; i < this.Appntanswers.size(); i++) {
/*  444 */         BankLNPCustImpQueBean bean = (BankLNPCustImpQueBean)this.Appntanswers.get(i);
/*  445 */         System.out.println(bean.getAppntQues().getQuestionid() + "<--->" + bean.getAppntanswer() + "-->idx:" + i);
/*      */       }
/*      */ 
/*  448 */       dealQuesText(this.quesText);
/*      */     }
/*      */     else {
/*  451 */       for (int i = 0; i < this.Insuranswers.size(); i++) {
/*  452 */         if (((BankLNPCustImpQueBean)this.Insuranswers.get(i)).getInsurQues().getQuestionid().equals(this.quesId)) {
/*  453 */           ((BankLNPCustImpQueBean)this.Insuranswers.get(i)).setInsuranswer(this.quesVal);
/*  454 */           System.out.println("ok" + ((BankLNPCustImpQueBean)this.Insuranswers.get(i)).getAppntanswer());
/*  455 */           break;
/*      */         }
/*      */       }
/*      */ 
/*  459 */       boolean isSelcAll = true;
/*  460 */       for (int i = 0; i < this.Insuranswers.size(); i++) {
/*  461 */         BankLNPCustImpQueBean tQueBean = (BankLNPCustImpQueBean)this.Insuranswers.get(i);
/*  462 */         if ((!"1".equals(tQueBean.getInsurQues().getQuestionType())) || 
/*  463 */           (tQueBean.getInsuranswer().equals(this.quesVal))) continue;
/*  464 */         isSelcAll = false;
/*  465 */         break;
/*      */       }
/*      */ 
/*  469 */       if (!isSelcAll) {
/*  470 */         for (int i = 0; i < this.Insuranswers.size(); i++) {
/*  471 */           ((BankLNPCustImpQueBean)this.Insuranswers.get(i)).setIsInsurAllSelected("");
/*      */         }
/*      */       }
/*      */       else {
/*  475 */         for (int i = 0; i < this.Insuranswers.size(); i++) {
/*  476 */           ((BankLNPCustImpQueBean)this.Insuranswers.get(i)).setIsInsurAllSelected(this.quesVal);
/*      */         }
/*      */       }
/*      */ 
/*  480 */       dealQuesText(this.quesText);
/*      */     }
/*      */ 
/*  484 */     for (int i = 0; i < this.Insuranswers.size(); i++) {
/*  485 */       if ((!"0101170017".equals(((BankLNPCustImpQueBean)this.Insuranswers.get(i)).getInsurQues().getQuestionid())) || 
/*  486 */         (!"2".equals(((BankLNPCustImpQueBean)this.Insuranswers.get(i)).getInsuranswer()))) continue;
/*  487 */       ((BankLNPCustImpQueBean)this.Insuranswers.get(i + 1)).setInsuranswer("");
/*  488 */       System.out.println("\u88AB\u4FDD\u4EBA\u5B55\u5468\u9009\u5426\uFF0C\u6240\u4EE5\u88AB\u6E05\u7A7A");
/*  489 */       break;
/*      */     }
/*      */ 
/*  492 */     for (int i = 0; i < this.Appntanswers.size(); i++) {
/*  493 */       if ((!"0101170017".equals(((BankLNPCustImpQueBean)this.Appntanswers.get(i)).getAppntQues().getQuestionid())) || 
/*  494 */         (!"2".equals(((BankLNPCustImpQueBean)this.Appntanswers.get(i)).getAppntanswer()))) continue;
/*  495 */       ((BankLNPCustImpQueBean)this.Appntanswers.get(i + 1)).setAppntanswer("");
/*  496 */       System.out.println("\u6295\u4FDD\u4EBA\u5B55\u5468\u9009\u5426\uFF0C\u6240\u4EE5\u88AB\u6E05\u7A7A");
/*  497 */       break;
/*      */     }
/*      */   }
/*      */ 
/*      */   private void dealQuesText(String quesText)
/*      */   {
/*  508 */     if ("".equals(quesText)) {
/*  509 */       return;
/*      */     }
/*  511 */     String[] ques = quesText.split("\\|");
/*  512 */     for (int i = 0; i < ques.length; i++) {
/*  513 */       String[] targs = ques[i].split("\\^");
/*  514 */       String quesType = targs[0];
/*  515 */       String quesId = targs[1];
/*  516 */       String quesTxt = "";
/*  517 */       String quesParentId = quesId.substring(0, quesId.length() - 1) + "1";
/*  518 */       String quesParentVal = "";
/*      */ 
/*  520 */       System.out.println("\u7236\u95EE\u9898\u7F16\u7801" + quesParentId);
/*  521 */       if (targs.length > 2) {
/*  522 */         quesTxt = targs[2];
/*      */       }
/*  524 */       if (quesType.indexOf("appnt") >= 0) {
/*  525 */         for (int j = 0; j < this.Appntanswers.size(); j++)
/*      */         {
/*  527 */           if (((BankLNPCustImpQueBean)this.Appntanswers.get(j)).getAppntQues().getQuestionid().equals(quesParentId)) {
/*  528 */             quesParentVal = ((BankLNPCustImpQueBean)this.Appntanswers.get(j)).getAppntanswer();
/*      */           }
/*  530 */           if (!((BankLNPCustImpQueBean)this.Appntanswers.get(j)).getAppntQues().getQuestionid().equals(quesId))
/*      */             continue;
/*  532 */           if ("2".equals(quesParentVal))
/*  533 */             ((BankLNPCustImpQueBean)this.Appntanswers.get(j)).setAppntanswer("");
/*      */           else {
/*  535 */             ((BankLNPCustImpQueBean)this.Appntanswers.get(j)).setAppntanswer(quesTxt);
/*      */           }
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/*  541 */         for (int j = 0; j < this.Insuranswers.size(); j++)
/*      */         {
/*  543 */           if (((BankLNPCustImpQueBean)this.Insuranswers.get(j)).getInsurQues().getQuestionid().equals(quesParentId)) {
/*  544 */             quesParentVal = ((BankLNPCustImpQueBean)this.Insuranswers.get(j)).getInsuranswer();
/*      */           }
/*  546 */           if (!((BankLNPCustImpQueBean)this.Insuranswers.get(j)).getInsurQues().getQuestionid().equals(quesId))
/*      */             continue;
/*  548 */           if ("2".equals(quesParentVal))
/*  549 */             ((BankLNPCustImpQueBean)this.Insuranswers.get(j)).setInsuranswer("");
/*      */           else
/*  551 */             ((BankLNPCustImpQueBean)this.Insuranswers.get(j)).setInsuranswer(quesTxt);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   public void listPre()
/*      */   {
/*  565 */     if ("appnt".equals(this.limtType)) {
/*  566 */       for (int i = 0; i < this.Appntanswers.size(); i++)
/*  567 */         if ("0101180117".equals(((BankLNPCustImpQueBean)this.Appntanswers.get(i)).getAppntQues().getQuestionid())) {
/*  568 */           ((BankLNPCustImpQueBean)this.Appntanswers.get(i)).setAppntanswer("");
/*  569 */           System.out.println("questionID:" + ((BankLNPCustImpQueBean)this.Appntanswers.get(i)).getAppntQues().getQuestionid() + "answer:" + ((BankLNPCustImpQueBean)this.Appntanswers.get(i)).getAppntanswer());
/*  570 */           break;
/*      */         }
/*      */     }
/*      */     else
/*  574 */       for (int i = 0; i < this.Insuranswers.size(); i++)
/*  575 */         if ("0101180117".equals(((BankLNPCustImpQueBean)this.Insuranswers.get(i)).getInsurQues().getQuestionid())) {
/*  576 */           ((BankLNPCustImpQueBean)this.Insuranswers.get(i)).setInsuranswer("");
/*  577 */           break;
/*      */         }
/*      */   }
/*      */ 
/*      */   public boolean checkComCode()
/*      */   {
/*  587 */     boolean flag = false;
/*  588 */     this.alertFlag = false;
/*      */     try {
/*  590 */       ExeSQL execSQL = new ExeSQL();
/*      */ 
/*  592 */       String sql = "select c.agentcom,c.name from LACom c where exists (select 1 from LNPCont b where b.signcom=c.managecom and b.contno='" + this.ContNo + "') and c.agentcom=upper('" + this.AgentBranchattr + "')";
/*  593 */       System.out.println("sql-->" + sql);
/*  594 */       SSRS rs = execSQL.execSQL(sql);
/*  595 */       if (rs.MaxRow > 0) {
/*  596 */         this.AgentBranchattr = rs.GetText(1, 1);
/*  597 */         this.AgentBranchattrNm = rs.GetText(1, 2);
/*  598 */         flag = true;
/*      */       } else {
/*  600 */         buildMsg("\u5BF9\u5E94\u5F53\u524D\u6295\u4FDD\u7B7E\u7F72\u5730\u6240\u9009\u62E9\u7684\u4EE3\u7406\u7F51\u70B9\u4E0D\u5B58\u5728\uFF0C\u8BF7\u91CD\u65B0\u5F55\u5165!");
/*  601 */         this.AgentBranchattr = "";
/*  602 */         this.AgentBranchattrNm = "";
/*      */       }
/*      */     } catch (Exception e) {
/*  605 */       e.printStackTrace();
/*      */     }
/*  607 */     return flag;
/*      */   }
/*      */ 
/*      */   public void checkTarDate()
/*      */   {
/*  612 */     this.alertFlag = false;
/*      */     try {
/*  614 */       String pTargetDate = this.agentInfoBean.getSchema().getP1();
/*  615 */       if ((this.tTargetDate != null) && (!"".equals(this.tTargetDate.trim()))) {
/*  616 */         String curDate = PubFun.getCurrentDate().replaceAll("-", "");
/*  617 */         if ((Integer.parseInt(this.tTargetDate.trim()) > Integer.parseInt(curDate.trim())) || 
/*  618 */           (this.tTargetDate.length() != 8)) {
/*  619 */           this.TargetDate = pTargetDate;
/*  620 */           buildMsg("\u6295\u4FDD\u4E66\u5361\u949F\u65E5\u4E0D\u80FD\u665A\u4E8E\u7CFB\u7EDF\u5F53\u524D\u65E5\u671F");
/*  621 */           return;
/*      */         }
/*  623 */         this.TargetDate = this.tTargetDate;
/*  624 */         this.agentInfoBean.getSchema().setP1(this.tTargetDate);
/*      */       }
/*      */     } catch (RuntimeException e) {
/*  627 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   public String gettTargetDate()
/*      */   {
/*  635 */     return this.tTargetDate;
/*      */   }
/*      */   public void settTargetDate(String tTargetDate) {
/*  638 */     this.tTargetDate = tTargetDate;
/*      */   }
/*      */ 
/*      */   public void checkSignDate()
/*      */   {
/*  646 */     this.alertFlag = false;
/*      */     try {
/*  648 */       String tPvaliDate = turnNullToString(this.contBean.getSchema().getPValiDate()).replaceAll("-", "");
/*  649 */       if ((this.tSignDate != null) && (!"".equals(this.tSignDate.trim()))) {
/*  650 */         String curDate = PubFun.getCurrentDate().replaceAll("-", "");
/*  651 */         if ((Integer.parseInt(this.tSignDate.trim()) > Integer.parseInt(curDate.trim())) || 
/*  652 */           (this.tSignDate.length() != 8)) {
/*  653 */           this.SignDate = tPvaliDate;
/*  654 */           buildMsg("\u6295\u4FDD\u4E66\u7B7E\u7F72\u65E5\u4E0D\u80FD\u665A\u4E8E\u7CFB\u7EDF\u5F53\u524D\u65E5\u671F");
/*  655 */           return;
/*      */         }
/*  657 */         if ((!this.tSignDate.equals(tPvaliDate)) || (!this.tSignDate.equals(this.SignDate))) {
/*  658 */           String appntBirth = this.contBean.getSchema().getAppntBirthday();
/*  659 */           String insurBirth = this.contBean.getSchema().getInsuredBirthday();
/*  660 */           System.out.println("\u6295\u4FDD\u4E66\u7B7E\u7F72\u65E5\u4E0E\u751F\u6548\u65E5\u53D8\u52A8: tsignDate-" + this.tSignDate + "PValiDate-" + tPvaliDate + "appntBirth-" + appntBirth + "insurBirth-" + insurBirth);
/*  661 */           if ((appntBirth != null) && (!"".equals(appntBirth.trim()))) {
/*  662 */             appntBirth = appntBirth.replaceAll("-", "");
/*  663 */             if (Integer.parseInt(this.tSignDate.trim()) < Integer.parseInt(appntBirth.trim())) {
/*  664 */               this.SignDate = tPvaliDate;
/*  665 */               buildMsg("\u6295\u4FDD\u4EBA\u51FA\u751F\u65E5\u671F\u4E3A\u201C" + appntBirth + "\u201D\uFF0C\u6295\u4FDD\u4E66\u7B7E\u7F72\u65E5\u671F\u4E0D\u53EF\u65E9\u4E8E\u6295\u4FDD\u4EBA\u51FA\u751F\u65E5\u671F");
/*  666 */               return;
/*      */             }
/*      */           }
/*  669 */           if ((insurBirth != null) && (!"".equals(insurBirth.trim()))) {
/*  670 */             insurBirth = insurBirth.replaceAll("-", "");
/*  671 */             if (Integer.parseInt(this.tSignDate.trim()) < Integer.parseInt(insurBirth.trim())) {
/*  672 */               this.SignDate = tPvaliDate;
/*  673 */               buildMsg("\u88AB\u4FDD\u4EBA\u51FA\u751F\u65E5\u671F\u4E3A\u201C" + insurBirth + "\u201D\uFF0C\u6295\u4FDD\u4E66\u7B7E\u7F72\u65E5\u671F\u4E0D\u53EF\u65E9\u4E8E\u88AB\u4FDD\u4EBA\u51FA\u751F\u65E5\u671F");
/*  674 */               return;
/*      */             }
/*      */           }
/*  677 */           this.SignDate = this.tSignDate;
/*  678 */           this.contBean.getSchema().setPValiDate(this.tSignDate);
/*      */         }
/*      */       } else {
/*  681 */         this.SignDate = this.tSignDate;
/*      */       }
/*      */     }
/*      */     catch (RuntimeException e)
/*      */     {
/*  686 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   public void checkAgentCode()
/*      */   {
/*  692 */     this.alertFlag = false;
/*      */     try {
/*  694 */       if ((this.tAgentCode != null) && (!"".equals(this.tAgentCode))) {
/*  695 */         ExeSQL execSQL = new ExeSQL();
/*  696 */         String sql = "select agentcode,agentstate from laagent a where exists(select 1 from lnpcont b where a.managecom=b.signcom and b.contno='" + this.ContNo + "') and a.agentcode='" + this.tAgentCode + "'";
/*  697 */         System.out.println("sql-->" + sql);
/*  698 */         SSRS ssrs = execSQL.execSQL(sql);
/*  699 */         if (ssrs.getMaxRow() > 0) {
/*  700 */           this.AgentCode = ssrs.GetText(1, 1);
/*  701 */           return;
/*      */         }
/*  703 */         this.AgentCode = "";
/*  704 */         buildMsg("\u4FDD\u5355\u7B7E\u7F72\u5730\u6240\u5728\u201C" + this.contBean.getSchema().getSignCom() + "\u201D\u5206\u516C\u53F8\uFF0C\u201C" + this.tAgentCode + "\u201D\u4EE3\u7406\u4EBA\u4E0D\u5B58\u5728\uFF0C\u8BF7\u786E\u5B9A\u540E\u5F55\u5165\u3002");
/*  705 */         return;
/*      */       }
/*      */     }
/*      */     catch (RuntimeException e) {
/*  709 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   private boolean saveQuesMsg(MMap map, boolean hasFlag, BankLNPContBean contBean, List<BankLNPCustImpQueBean> appntAnswers, List<BankLNPCustImpQueBean> insurAnswers, String curDate, String curTime)
/*      */   {
/*  725 */     boolean flag = true;
/*      */     try {
/*  727 */       if (!validate("ques")) {
/*  728 */         return false;
/*      */       }
/*  730 */       SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
/*  731 */       String resultId = maxNoMap.CreateMaxNo("ImpReslutId", "");
/*  732 */       LNPCustImpResultSet rstSet = new LNPCustImpResultSet();
/*      */ 
/*  734 */       BankLNPCustImpQueBean rstBean = new BankLNPCustImpQueBean();
/*      */ 
/*  736 */       for (int i = 0; i < appntAnswers.size(); i++) {
/*  737 */         LNPCustImpResultSchema rstSchema = new LNPCustImpResultSchema();
/*  738 */         rstBean = (BankLNPCustImpQueBean)appntAnswers.get(i);
/*  739 */         rstSchema.setImpartId(rstBean.getAppntQues().getImpartId());
/*  740 */         rstSchema.setResultId(resultId);
/*  741 */         rstSchema.setContNo(contBean.getSchema().getContNo());
/*  742 */         rstSchema.setQuestionId(rstBean.getAppntQues().getQuestionid());
/*  743 */         rstSchema.setCustomerNo("appnt");
/*  744 */         rstSchema.setCustomerId(contBean.getSchema().getAppntId());
/*  745 */         rstSchema.setQuestionType(rstBean.getAppntQues().getQuestionType());
/*  746 */         if ("2".equals(rstSchema.getQuestionType()))
/*  747 */           rstSchema.setAnswer(rstBean.getAppntanswer());
/*      */         else {
/*  749 */           rstSchema.setOptionId(rstBean.getAppntanswer());
/*      */         }
/*  751 */         rstSchema.setOperator(this.GI.Operator);
/*  752 */         rstSchema.setManageCom(this.GI.ManageCom);
/*  753 */         rstSchema.setMakeDate(curDate);
/*  754 */         rstSchema.setMakeTime(curTime);
/*  755 */         rstSchema.setModifyDate(curDate);
/*  756 */         rstSchema.setModifyTime(curTime);
/*      */ 
/*  758 */         rstSet.add(rstSchema);
/*      */       }
/*      */ 
/*  762 */       resultId = maxNoMap.CreateMaxNo("ImpReslutId", "");
/*  763 */       for (int i = 0; i < insurAnswers.size(); i++) {
/*  764 */         LNPCustImpResultSchema rstSchema = new LNPCustImpResultSchema();
/*  765 */         rstBean = (BankLNPCustImpQueBean)insurAnswers.get(i);
/*  766 */         rstSchema.setImpartId(rstBean.getInsurQues().getImpartId());
/*  767 */         rstSchema.setResultId(resultId);
/*  768 */         rstSchema.setContNo(contBean.getSchema().getContNo());
/*  769 */         rstSchema.setQuestionId(rstBean.getInsurQues().getQuestionid());
/*  770 */         rstSchema.setCustomerNo("insur");
/*  771 */         rstSchema.setCustomerId(contBean.getSchema().getInsuredId());
/*  772 */         rstSchema.setQuestionType(rstBean.getInsurQues().getQuestionType());
/*  773 */         if ("2".equals(rstSchema.getQuestionType()))
/*  774 */           rstSchema.setAnswer(rstBean.getInsuranswer());
/*      */         else {
/*  776 */           rstSchema.setOptionId(rstBean.getInsuranswer());
/*      */         }
/*  778 */         rstSchema.setOperator(this.GI.Operator);
/*  779 */         rstSchema.setManageCom(this.GI.ManageCom);
/*  780 */         rstSchema.setMakeDate(curDate);
/*  781 */         rstSchema.setMakeTime(curTime);
/*  782 */         rstSchema.setModifyDate(curDate);
/*  783 */         rstSchema.setModifyTime(curTime);
/*      */ 
/*  785 */         rstSet.add(rstSchema);
/*      */       }
/*      */ 
/*  788 */       LNPCustImpResultDB db = new LNPCustImpResultDB();
/*  789 */       String sql = "select * from LNPCustImpResult where contno='" + contBean.getSchema().getContNo() + "'";
/*  790 */       LNPCustImpResultSet bSet = db.executeQuery(sql);
/*  791 */       System.out.println(bSet.size() + "-------size==44? ok:no");
/*  792 */       map.put(bSet, "DELETE");
/*  793 */       map.put(rstSet, "INSERT");
/*      */     } catch (Exception e) {
/*  795 */       e.printStackTrace();
/*  796 */       buildMsg(e.getMessage());
/*      */     }
/*  798 */     return flag;
/*      */   }
/*      */ 
/*      */   private boolean savePaymentMsg(MMap map, boolean hasFlag, BankLNPContBean contBean, BankLNPPaymentBean paymentBean, String curDate, String curTime)
/*      */   {
/*  811 */     boolean flag = true;
/*      */     try {
/*  813 */       if (!validate("pay")) {
/*  814 */         return false;
/*      */       }
/*  816 */       paymentBean.getSchema().setContNo(contBean.getSchema().getContNo());
/*  817 */       paymentBean.getSchema().setAppntID(contBean.getSchema().getAppntId());
/*  818 */       paymentBean.getSchema().setInusredID(contBean.getSchema().getInsuredId());
/*  819 */       paymentBean.getSchema().setPayMent1(this.FirPayType);
/*  820 */       paymentBean.getSchema().setPayMent2(this.EscPayType);
/*  821 */       paymentBean.getSchema().setBankCode(this.AuthBank);
/*  822 */       paymentBean.getSchema().setAccount(this.AuthACount);
/*      */ 
/*  824 */       contBean.getSchema().setBankCode(paymentBean.getSchema().getBankCode());
/*      */ 
/*  826 */       paymentBean.getSchema().setOperator(this.GI.Operator);
/*  827 */       if (hasFlag) {
/*  828 */         paymentBean.getSchema().setModifyDate(curDate);
/*  829 */         paymentBean.getSchema().setModifyTime(curTime);
/*  830 */         map.put(paymentBean.getSchema(), "UPDATE");
/*      */       } else {
/*  832 */         paymentBean.getSchema().setMakeDate(curDate);
/*  833 */         paymentBean.getSchema().setMakeTime(curTime);
/*  834 */         paymentBean.getSchema().setModifyDate(curDate);
/*  835 */         paymentBean.getSchema().setModifyTime(curTime);
/*  836 */         map.put(paymentBean.getSchema(), "INSERT");
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  840 */       e.printStackTrace();
/*  841 */       buildMsg(e.getMessage());
/*      */     }
/*  843 */     return flag;
/*      */   }
/*      */ 
/*      */   private boolean saveAgentInfMsg(MMap map, boolean hasFlag, BankLNPContBean contBean, BankLNPAgentInfoBean agentInfBean, String curDate, String curTime)
/*      */   {
/*  856 */     boolean flag = true;
/*      */     try {
/*  858 */       if (!validate("agent")) {
/*  859 */         return false;
/*      */       }
/*  861 */       agentInfBean.getSchema().setContNo(contBean.getSchema().getContNo());
/*  862 */       agentInfBean.getSchema().setProposalContNo(contBean.getSchema().getContNo());
/*  863 */       agentInfBean.getSchema().setAgentOrder("1");
/*  864 */       if ((this.SignDate != null) && (!"".equals(this.SignDate.trim()))) {
/*  865 */         contBean.getSchema().setPSignDate(this.SignDate);
/*  866 */         if (!turnNullToString(contBean.getSchema().getPValiDate()).equals(contBean.getSchema().getPSignDate())) {
/*  867 */           System.out.println("\u7B7E\u7F72\u65E5\u53D8\u52A8\uFF0C\u540C\u6B65\u751F\u6548\u65E5\uFF0C\u4EE5\u53CA\u6295\u3001\u88AB\u4FDD\u4EBA\u5E74\u9F84\u4FE1\u606F");
/*  868 */           contBean.getSchema().setPValiDate(this.SignDate);
/*      */         }
/*  870 */         System.out.println(this.SignDate + "===save=====" + contBean.getSchema().getPSignDate());
/*      */       }
/*  872 */       agentInfBean.getSchema().setP4(this.SignDate);
/*  873 */       agentInfBean.getSchema().setP1(this.TargetDate);
/*  874 */       agentInfBean.getSchema().setP3(this.AgentTrantype);
/*  875 */       agentInfBean.getSchema().setP2(this.AgentBranchattr);
/*      */ 
/*  877 */       agentInfBean.getSchema().setPolPrintType(this.PolPrintType);
/*      */ 
/*  880 */       agentInfBean.getSchema().setAgentCode(this.AgentCode);
/*  881 */       agentInfBean.getSchema().setBranchAttr(getBranchAttrByAgentCode(this.AgentCode));
/*  882 */       agentInfBean.getSchema().setOperator(this.GI.Operator);
/*  883 */       if (hasFlag) {
/*  884 */         agentInfBean.getSchema().setModifyDate(curDate);
/*  885 */         agentInfBean.getSchema().setModifyTime(curTime);
/*  886 */         map.put(agentInfBean.getSchema(), "UPDATE");
/*      */       } else {
/*  888 */         agentInfBean.getSchema().setMakeDate(curDate);
/*  889 */         agentInfBean.getSchema().setMakeTime(curTime);
/*  890 */         agentInfBean.getSchema().setModifyDate(curDate);
/*  891 */         agentInfBean.getSchema().setModifyTime(curTime);
/*  892 */         map.put(agentInfBean.getSchema(), "INSERT");
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  896 */       e.printStackTrace();
/*  897 */       buildMsg(e.getMessage());
/*      */     }
/*  899 */     return flag;
/*      */   }
/*      */ 
/*      */   private boolean getInfoFromSession()
/*      */   {
/*  907 */     boolean flag = false;
/*  908 */     HttpSession session = null;
/*      */     try {
/*  910 */       session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*  911 */       this.GI = ((IGlobalInput)session.getAttribute("NPGI"));
/*  912 */       if (((String)session.getAttribute("ContNo") != null) && 
/*  913 */         (!((String)session.getAttribute("ContNo")).equals(""))) {
/*  914 */         this.ContNo = ((String)session.getAttribute("ContNo"));
/*  915 */         waitPolicyCommited(session, this.ContNo);
/*  916 */         turnCurrPolicyLockFlag(session, this.ContNo, "lock");
/*  917 */         flag = true;
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  921 */       turnCurrPolicyLockFlag(session, this.ContNo, "unlock");
/*  922 */       flag = false;
/*  923 */       buildMsg(e.getMessage());
/*      */     }
/*  925 */     return flag;
/*      */   }
/*      */ 
/*      */   private void initPaymentNotiMsg(BankLNPContBean contBean, BankLNPPaymentBean paymentBean)
/*      */   {
/*  943 */     this.FirPayType = paymentBean.getSchema().getPayMent1();
/*  944 */     this.EscPayType = paymentBean.getSchema().getPayMent2();
/*  945 */     this.ACounter = contBean.getSchema().getAppntName();
/*  946 */     this.AuthBank = paymentBean.getSchema().getBankCode();
/*      */ 
/*  948 */     this.AuthACount = getDecryptAccount(contBean.getSchema().getContNo());
/*      */   }
/*      */ 
/*      */   private void initAgenNotiMsg(BankLNPContBean contBean, BankLNPAgentInfoBean agentInfoBean)
/*      */   {
/*  957 */     this.SignDate = formatDate(turnNullToString(agentInfoBean.getSchema().getP4()), "YYYYMMDD");
/*  958 */     System.out.println(this.SignDate + "===init=====" + agentInfoBean.getSchema().getP4());
/*  959 */     this.TargetDate = agentInfoBean.getSchema().getP1();
/*  960 */     this.AgentTrantype = agentInfoBean.getSchema().getP3();
/*  961 */     this.AgentBranchattr = agentInfoBean.getSchema().getP2();
/*      */ 
/*  963 */     this.AgentBranchattrNm = (this.AgentBranchattr != null ? getAgentCom(this.AgentBranchattr) : "");
/*  964 */     System.out.println(this.AgentBranchattr + "<_-init--- >" + this.AgentBranchattrNm);
/*  965 */     this.AgentCode = agentInfoBean.getSchema().getAgentCode();
/*      */ 
/*  967 */     this.PolPrintType = agentInfoBean.getSchema().getPolPrintType();
/*      */   }
/*      */ 
/*      */   private void initQuestionList()
/*      */   {
/*      */     try
/*      */     {
/*  977 */       LNPCustImpQueDB db = new LNPCustImpQueDB();
/*  978 */       this.Appntanswers.clear();
/*  979 */       this.Insuranswers.clear();
/*      */ 
/*  981 */       String appntSql = "";
/*  982 */       String insurSql = "";
/*  983 */       getSaleChannelCode(this.ContNo);
/*      */ 
/*  985 */       if ("AGY".equals(this.saleChannelCode))
/*      */       {
/*  988 */         appntSql = "select * from LNPCustImpQue where impartid='0201' and (content1 like 'C%' or content1 like 'D%') order by impartid,queorder";
/*      */ 
/*  991 */         insurSql = "select * from LNPCustImpQue where impartid='0201' and content1 not like 'C%' and content1 not like 'D%' order by impartid,queorder";
/*      */       }
/*  993 */       else if ("TM".equals(this.saleChannelCode))
/*      */       {
/*  996 */         insurSql = "select * from LNPCustImpQue where impartid='0301' order by impartid,queorder";
/*      */       }
/*      */ 
/* 1000 */       if ((this.saleChannelCode == null) || ("".equals(this.saleChannelCode)) || ("null".equals(this.saleChannelCode)) || 
/* 1001 */         ("BXS".equals(this.saleChannelCode)))
/*      */       {
/* 1004 */         appntSql = "select * from LNPCustImpQue where impartid='0101' and questionid not in('0101240023','0101250024','0101260025') order by impartid,queorder";
/*      */ 
/* 1007 */         insurSql = "select * from LNPCustImpQue where impartid='0101' order by impartid,queorder";
/*      */       }
/*      */ 
/* 1010 */       LNPCustImpQueSet set = db.executeQuery(appntSql);
/*      */ 
/* 1014 */       for (int i = 1; i <= set.size(); i++) {
/* 1015 */         BankLNPCustImpQueBean custImpQueBean = new BankLNPCustImpQueBean();
/* 1016 */         LNPCustImpQueSchema tSchema = set.get(i);
/* 1017 */         custImpQueBean.setAppntQues(tSchema);
/* 1018 */         this.Appntanswers.add(custImpQueBean);
/*      */       }
/*      */ 
/* 1021 */       set = db.executeQuery(insurSql);
/*      */ 
/* 1024 */       for (int i = 1; i <= set.size(); i++) {
/* 1025 */         BankLNPCustImpQueBean custImpQueBean = new BankLNPCustImpQueBean();
/* 1026 */         LNPCustImpQueSchema tSchema = set.get(i);
/* 1027 */         custImpQueBean.setInsurQues(tSchema);
/* 1028 */         this.Insuranswers.add(custImpQueBean);
/*      */       }
/*      */     } catch (Exception e) {
/* 1031 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   private String getBranchAttrByAgentCode(String AgentCode)
/*      */   {
/* 1041 */     String branchAttr = "";
/* 1042 */     ExeSQL exeSQL = new ExeSQL();
/*      */ 
/* 1044 */     String sql = "select branchattr from labranchgroup a where exists(select 1 from latree b where a.agentgroup=b.agentgroup and b.agentcode='" + AgentCode + "')";
/* 1045 */     branchAttr = exeSQL.getOneValue(sql);
/* 1046 */     return branchAttr;
/*      */   }
/*      */ 
/*      */   private boolean validate(String vflag)
/*      */   {
/* 1056 */     boolean flag = true;
/* 1057 */     if ("ques".equals(vflag)) {
/* 1058 */       this.quesComplete = true;
/* 1059 */     } else if ("agent".equals(vflag)) {
/* 1060 */       this.agentInfComplete = true;
/* 1061 */       if ((this.FirPayType == null) || ("".equals(this.FirPayType.trim())))
/* 1062 */         this.agentInfComplete = false;
/*      */     }
/* 1064 */     else if ("pay".equals(vflag)) {
/* 1065 */       this.paymentComplete = true;
/* 1066 */       if ((this.saleChannelCode.equals("BXS")) && ((this.AgentCode == null) || ("".equals(this.AgentCode.trim()))))
/*      */       {
/* 1068 */         this.paymentComplete = false;
/*      */       }
/*      */     }
/* 1071 */     return flag;
/*      */   }
/*      */ 
/*      */   private BankLNPContBean recOneContInfo(String contNo)
/*      */   {
/* 1093 */     BankLNPContBean bean = new BankLNPContBean();
/* 1094 */     PolicyMainInfo mainInfo = new PolicyMainInfo();
/* 1095 */     LNPContSchema tSchema = mainInfo.getContByContNo(contNo);
/* 1096 */     if (tSchema != null) {
/* 1097 */       bean.setSchema(tSchema);
/*      */     }
/* 1099 */     return bean;
/*      */   }
/*      */ 
/*      */   private boolean isExistQues(String contNo)
/*      */   {
/* 1113 */     boolean flag = false;
/*      */     try {
/* 1115 */       LNPCustImpResultDB db = new LNPCustImpResultDB();
/* 1116 */       db.setContNo(contNo);
/* 1117 */       LNPCustImpResultSet set = db.query();
/* 1118 */       if (set.size() > 0) {
/* 1119 */         for (int i = 1; i <= set.size(); i++) {
/* 1120 */           LNPCustImpResultSchema rstSchema = set.get(i);
/*      */ 
/* 1122 */           boolean isFind = false;
/* 1123 */           for (int j = 0; j < this.Appntanswers.size(); j++) {
/* 1124 */             LNPCustImpQueSchema queSchema = ((BankLNPCustImpQueBean)this.Appntanswers.get(j)).getAppntQues();
/* 1125 */             if ((queSchema.getQuestionid().indexOf(rstSchema.getQuestionId()) >= 0) && ("appnt".equals(rstSchema.getCustomerNo()))) {
/* 1126 */               if (queSchema.getQuestionType().equals("2"))
/* 1127 */                 ((BankLNPCustImpQueBean)this.Appntanswers.get(j)).setAppntanswer(rstSchema.getAnswer());
/*      */               else {
/* 1129 */                 ((BankLNPCustImpQueBean)this.Appntanswers.get(j)).setAppntanswer(rstSchema.getOptionId());
/*      */               }
/* 1131 */               isFind = true;
/* 1132 */               break;
/*      */             }
/*      */           }
/* 1135 */           if (isFind)
/*      */             continue;
/* 1137 */           for (int k = 0; k < this.Insuranswers.size(); k++) {
/* 1138 */             LNPCustImpQueSchema queSchema = ((BankLNPCustImpQueBean)this.Insuranswers.get(k)).getInsurQues();
/* 1139 */             if ((queSchema.getQuestionid().indexOf(rstSchema.getQuestionId()) >= 0) && ("insur".equals(rstSchema.getCustomerNo()))) {
/* 1140 */               if (queSchema.getQuestionType().equals("2")) {
/* 1141 */                 ((BankLNPCustImpQueBean)this.Insuranswers.get(k)).setInsuranswer(rstSchema.getAnswer());
/* 1142 */                 break;
/* 1143 */               }((BankLNPCustImpQueBean)this.Insuranswers.get(k)).setInsuranswer(rstSchema.getOptionId());
/*      */ 
/* 1145 */               break;
/*      */             }
/*      */           }
/*      */         }
/*      */ 
/* 1150 */         flag = true;
/*      */       }
/*      */     } catch (Exception e) {
/* 1153 */       e.printStackTrace();
/* 1154 */       buildMsg(e.getMessage());
/*      */     }
/* 1156 */     return flag;
/*      */   }
/*      */ 
/*      */   private boolean recAllQuesAnswer(String contNo)
/*      */   {
/* 1164 */     boolean flag = false;
/*      */     try {
/* 1166 */       this.AppntanswersBackup.clear();
/* 1167 */       this.InsuranswersBackup.clear();
/* 1168 */       LNPCustImpResultDB db = new LNPCustImpResultDB();
/*      */ 
/* 1170 */       String sql = "select * from LNPCustImpResult where impartid='0101' and CustomerNo='appnt' and contno='" + contNo + "'";
/* 1171 */       LNPCustImpResultSet set = db.executeQuery(sql);
/* 1172 */       for (int i = 1; i <= set.size(); i++) {
/* 1173 */         BankLNPCustImpResultBean custImpRstBean = new BankLNPCustImpResultBean();
/* 1174 */         LNPCustImpResultSchema tSchema = set.get(i);
/* 1175 */         custImpRstBean.setSchema(tSchema);
/* 1176 */         this.AppntanswersBackup.add(custImpRstBean);
/*      */       }
/*      */ 
/* 1179 */       sql = "select * from LNPCustImpResult where impartid='0101' and CustomerNo='insur' and contno='" + contNo + "'";
/* 1180 */       set = db.executeQuery(sql);
/* 1181 */       for (int i = 1; i <= set.size(); i++) {
/* 1182 */         BankLNPCustImpResultBean custImpRstBean = new BankLNPCustImpResultBean();
/* 1183 */         LNPCustImpResultSchema tSchema = set.get(i);
/* 1184 */         custImpRstBean.setSchema(tSchema);
/* 1185 */         this.InsuranswersBackup.add(custImpRstBean);
/*      */       }
/* 1187 */       flag = true;
/*      */     } catch (Exception e) {
/* 1189 */       e.printStackTrace();
/* 1190 */       buildMsg(e.getMessage());
/*      */     }
/* 1192 */     return flag;
/*      */   }
/*      */ 
/*      */   private boolean isExistAgentInf(String contNo)
/*      */   {
/* 1201 */     boolean flag = false;
/* 1202 */     this.agentInfoBean = new BankLNPAgentInfoBean();
/* 1203 */     LNPAgentInfoDB db = new LNPAgentInfoDB();
/* 1204 */     db.setContNo(contNo);
/* 1205 */     LNPAgentInfoSet set = db.query();
/* 1206 */     if (set.size() > 0) {
/* 1207 */       this.agentInfoBean.setSchema(set.get(1));
/* 1208 */       flag = true;
/*      */     }
/* 1210 */     return flag;
/*      */   }
/*      */ 
/*      */   private BankLNPAgentInfoBean recAgentInfo(String contNo)
/*      */   {
/* 1218 */     BankLNPAgentInfoBean bean = new BankLNPAgentInfoBean();
/* 1219 */     LNPAgentInfoDB db = new LNPAgentInfoDB();
/* 1220 */     db.setContNo(contNo);
/* 1221 */     LNPAgentInfoSet set = db.query();
/* 1222 */     if (set.size() > 0) {
/* 1223 */       bean.setSchema(set.get(1));
/*      */     }
/* 1225 */     return bean;
/*      */   }
/*      */ 
/*      */   private boolean isExistPayment(String contNo)
/*      */   {
/* 1234 */     boolean flag = false;
/* 1235 */     this.paymentBean = new BankLNPPaymentBean();
/* 1236 */     LNPPaymentDB db = new LNPPaymentDB();
/* 1237 */     db.setContNo(contNo);
/* 1238 */     LNPPaymentSet set = db.query();
/* 1239 */     if (set.size() > 0) {
/* 1240 */       this.paymentBean.setSchema(set.get(1));
/* 1241 */       flag = true;
/*      */     }
/* 1243 */     return flag;
/*      */   }
/*      */ 
/*      */   private BankLNPPaymentBean recPaymentInfo(String contNo)
/*      */   {
/* 1251 */     BankLNPPaymentBean bean = new BankLNPPaymentBean();
/* 1252 */     LNPPaymentDB db = new LNPPaymentDB();
/* 1253 */     db.setContNo(contNo);
/* 1254 */     LNPPaymentSet set = db.query();
/* 1255 */     if (set.size() > 0) {
/* 1256 */       bean.setSchema(set.get(1));
/*      */     }
/* 1258 */     return bean;
/*      */   }
/*      */ 
/*      */   private void buildMsg(String msg)
/*      */   {
/* 1265 */     this.alertFlag = true;
/* 1266 */     this.message = msg;
/* 1267 */     String Path = Class.class.getClass().getName();
/* 1268 */     String Result = "--->path: " + Path + ";" + this.message;
/* 1269 */     if (this.Errors.size() > 20) {
/* 1270 */       this.Errors = new ArrayList();
/*      */     }
/* 1272 */     this.Errors.add(Result);
/*      */   }
/*      */   private void reportMsg() {
/* 1275 */     for (int i = 0; i < this.Errors.size(); i++)
/*      */     {
/* 1277 */       System.out.println("index_" + i + ":" + (String)this.Errors.get(i));
/*      */     }
/* 1279 */     this.Errors.clear();
/*      */   }
/*      */ 
/*      */   private static void initBrchAttrNmMap()
/*      */   {
/* 1287 */     brchAttrNmMap.clear();
/*      */ 
/* 1290 */     ExeSQL tExeSQL = new ExeSQL();
/* 1291 */     String sql = "select agentcom,name from lacom";
/* 1292 */     SSRS tSRS = tExeSQL.execSQL(sql);
/* 1293 */     for (int i = 1; i <= tSRS.MaxRow; i++)
/* 1294 */       brchAttrNmMap.put(tSRS.GetText(i, 1), tSRS.GetText(i, 2));
/*      */   }
/*      */ 
/*      */   private String getAgentCom(String code)
/*      */   {
/* 1303 */     System.out.println("----" + code);
/*      */     try {
/* 1305 */       if ((!turnNullToString(code).equals("")) && (!brchAttrNmMap.containsKey(code))) {
/* 1306 */         System.out.println("~~~~~~~~~~~~~~~~~~~because agentcom is not exists,so init");
/* 1307 */         initBrchAttrNmMap();
/*      */       }
/* 1309 */       return (String)brchAttrNmMap.get(code);
/*      */     } catch (Exception localException) {
/*      */     }
/* 1312 */     return "";
/*      */   }
/*      */ 
/*      */   public boolean isEditFlag() {
/* 1316 */     return this.editFlag;
/*      */   }
/*      */   public void setEditFlag(boolean editFlag) {
/* 1319 */     this.editFlag = editFlag;
/*      */   }
/*      */   public BankLNPContBean getContBean() {
/* 1322 */     return this.contBean;
/*      */   }
/*      */   public void setContBean(BankLNPContBean contBean) {
/* 1325 */     this.contBean = contBean;
/*      */   }
/*      */   public boolean isAlertFlag() {
/* 1328 */     return this.alertFlag;
/*      */   }
/*      */   public void setAlertFlag(boolean alertFlag) {
/* 1331 */     this.alertFlag = alertFlag;
/*      */   }
/*      */   public String getMessage() {
/* 1334 */     return this.message;
/*      */   }
/*      */   public void setMessage(String message) {
/* 1337 */     this.message = message;
/*      */   }
/*      */ 
/*      */   public List<BankLNPCustImpQueBean> getAppntanswers() {
/* 1341 */     return this.Appntanswers;
/*      */   }
/*      */ 
/*      */   public void setAppntanswers(List<BankLNPCustImpQueBean> appntanswers) {
/* 1345 */     initQuestionList();
/* 1346 */     this.Appntanswers = appntanswers;
/*      */   }
/*      */ 
/*      */   public List<BankLNPCustImpQueBean> getInsuranswers() {
/* 1350 */     return this.Insuranswers;
/*      */   }
/*      */ 
/*      */   public void setInsuranswers(List<BankLNPCustImpQueBean> insuranswers) {
/* 1354 */     this.Insuranswers = insuranswers;
/*      */   }
/*      */   public ArrayList<String> getErrors() {
/* 1357 */     return this.Errors;
/*      */   }
/*      */   public void setErrors(ArrayList<String> errors) {
/* 1360 */     this.Errors = errors;
/*      */   }
/*      */   public String getFirPayType() {
/* 1363 */     return this.FirPayType;
/*      */   }
/*      */   public void setFirPayType(String firPayType) {
/* 1366 */     this.FirPayType = firPayType;
/*      */   }
/*      */   public String getEscPayType() {
/* 1369 */     return this.EscPayType;
/*      */   }
/*      */   public void setEscPayType(String escPayType) {
/* 1372 */     this.EscPayType = escPayType;
/*      */   }
/*      */   public String getACounter() {
/* 1375 */     return this.ACounter;
/*      */   }
/*      */   public void setACounter(String aCounter) {
/* 1378 */     this.ACounter = aCounter;
/*      */   }
/*      */ 
/*      */   public String getAuthBank() {
/* 1382 */     return this.AuthBank;
/*      */   }
/*      */   public void setAuthBank(String authBank) {
/* 1385 */     this.AuthBank = authBank;
/*      */   }
/*      */   public String getAuthACount() {
/* 1388 */     return this.AuthACount;
/*      */   }
/*      */   public void setAuthACount(String authACount) {
/* 1391 */     this.AuthACount = authACount;
/*      */   }
/*      */   public String getSignDate() {
/* 1394 */     return this.SignDate;
/*      */   }
/*      */   public void setSignDate(String signDate) {
/* 1397 */     this.SignDate = signDate;
/*      */   }
/*      */   public String getTargetDate() {
/* 1400 */     return this.TargetDate;
/*      */   }
/*      */   public void setTargetDate(String targetDate) {
/* 1403 */     this.TargetDate = targetDate;
/*      */   }
/*      */   public String getAgentTrantype() {
/* 1406 */     return this.AgentTrantype;
/*      */   }
/*      */   public void setAgentTrantype(String agentTrantype) {
/* 1409 */     this.AgentTrantype = agentTrantype;
/*      */   }
/*      */   public String getAgentBranchattr() {
/* 1412 */     return this.AgentBranchattr;
/*      */   }
/*      */   public void setAgentBranchattr(String agentBranchattr) {
/* 1415 */     this.AgentBranchattr = agentBranchattr;
/*      */   }
/*      */   public String getAgentBranchattrNm() {
/* 1418 */     return this.AgentBranchattrNm;
/*      */   }
/*      */   public void setAgentBranchattrNm(String agentBranchattrNm) {
/* 1421 */     this.AgentBranchattrNm = agentBranchattrNm;
/*      */   }
/*      */   public String getAgentCode() {
/* 1424 */     return this.AgentCode;
/*      */   }
/*      */   public void setAgentCode(String agentCode) {
/* 1427 */     this.AgentCode = agentCode;
/*      */   }
/*      */   public boolean isQuesHasFlag() {
/* 1430 */     return this.quesHasFlag;
/*      */   }
/*      */   public void setQuesHasFlag(boolean quesHasFlag) {
/* 1433 */     this.quesHasFlag = quesHasFlag;
/*      */   }
/*      */   public boolean isAgentInfHasFlag() {
/* 1436 */     return this.agentInfHasFlag;
/*      */   }
/*      */   public void setAgentInfHasFlag(boolean agentInfHasFlag) {
/* 1439 */     this.agentInfHasFlag = agentInfHasFlag;
/*      */   }
/*      */   public boolean isPaymentHasFlag() {
/* 1442 */     return this.paymentHasFlag;
/*      */   }
/*      */   public void setPaymentHasFlag(boolean paymentHasFlag) {
/* 1445 */     this.paymentHasFlag = paymentHasFlag;
/*      */   }
/*      */   public boolean isAllComplete() {
/* 1448 */     return this.allComplete;
/*      */   }
/*      */   public void setAllComplete(boolean allComplete) {
/* 1451 */     this.allComplete = allComplete;
/*      */   }
/*      */   public boolean isQuesComplete() {
/* 1454 */     return this.quesComplete;
/*      */   }
/*      */   public void setQuesComplete(boolean quesComplete) {
/* 1457 */     this.quesComplete = quesComplete;
/*      */   }
/*      */   public boolean isAgentInfComplete() {
/* 1460 */     return this.agentInfComplete;
/*      */   }
/*      */   public void setAgentInfComplete(boolean agentInfComplete) {
/* 1463 */     this.agentInfComplete = agentInfComplete;
/*      */   }
/*      */   public boolean isPaymentComplete() {
/* 1466 */     return this.paymentComplete;
/*      */   }
/*      */   public void setPaymentComplete(boolean paymentComplete) {
/* 1469 */     this.paymentComplete = paymentComplete;
/*      */   }
/*      */   public BankLNPPaymentBean getPaymentBean() {
/* 1472 */     return this.paymentBean;
/*      */   }
/*      */   public void setPaymentBean(BankLNPPaymentBean paymentBean) {
/* 1475 */     this.paymentBean = paymentBean;
/*      */   }
/*      */   public BankLNPAgentInfoBean getAgentInfoBean() {
/* 1478 */     return this.agentInfoBean;
/*      */   }
/*      */   public void setAgentInfoBean(BankLNPAgentInfoBean agentInfoBean) {
/* 1481 */     this.agentInfoBean = agentInfoBean;
/*      */   }
/*      */   public String getAppntIsAllSelc() {
/* 1484 */     return this.AppntIsAllSelc;
/*      */   }
/*      */   public void setAppntIsAllSelc(String appntIsAllSelc) {
/* 1487 */     this.AppntIsAllSelc = appntIsAllSelc;
/*      */   }
/*      */   public String getInsurIsAllSelc() {
/* 1490 */     return this.InsurIsAllSelc;
/*      */   }
/*      */   public void setInsurIsAllSelc(String insurIsAllSelc) {
/* 1493 */     this.InsurIsAllSelc = insurIsAllSelc;
/*      */   }
/*      */   public String getQuesType() {
/* 1496 */     return this.quesType;
/*      */   }
/*      */   public void setQuesType(String quesType) {
/* 1499 */     this.quesType = quesType;
/*      */   }
/*      */   public String getQuesVal() {
/* 1502 */     return this.quesVal;
/*      */   }
/*      */   public void setQuesVal(String quesVal) {
/* 1505 */     this.quesVal = quesVal;
/*      */   }
/*      */   public String getQuesId() {
/* 1508 */     return this.quesId;
/*      */   }
/*      */   public void setQuesId(String quesId) {
/* 1511 */     this.quesId = quesId;
/*      */   }
/*      */   public String getQuesText() {
/* 1514 */     return this.quesText;
/*      */   }
/*      */   public void setQuesText(String quesText) {
/* 1517 */     this.quesText = quesText;
/*      */   }
/*      */   public List<SelectItem> getBankCodeList() {
/*      */     try {
/* 1521 */       if (this.bankCodeList != null) {
/* 1522 */         this.bankCodeList.clear();
/*      */       }
/* 1524 */       HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/* 1525 */       String ContNo = (String)session.getAttribute("ContNo");
/* 1526 */       this.bankCodeList = getBankList(ContNo);
/*      */     } catch (Exception e) {
/* 1528 */       e.printStackTrace();
/*      */     }
/* 1530 */     return this.bankCodeList;
/*      */   }
/*      */ 
/*      */   private List<SelectItem> getBankList(String contNo) {
/* 1534 */     List reList = new ArrayList();
/*      */     try {
/* 1536 */       ExeSQL tExeSQL = new ExeSQL();
/* 1537 */       String sql = "select bankcode,bankname from mbank a where managecom <>'86' and exists(select 1 from lnpcont b where a.managecom=b.signcom and b.contno='" + contNo + "') and branchtype='3' order by bankcode";
/* 1538 */       System.out.println("sql-->" + sql);
/* 1539 */       SSRS tSRS = tExeSQL.execSQL(sql);
/* 1540 */       for (int i = 1; i <= tSRS.MaxRow; i++)
/* 1541 */         reList.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1545 */       e.printStackTrace();
/*      */     }
/* 1547 */     return reList;
/*      */   }
/*      */   public void setBankCodeList(List<SelectItem> bankCodeList) {
/* 1550 */     this.bankCodeList = bankCodeList;
/*      */   }
/*      */   public String getLimtType() {
/* 1553 */     return this.limtType;
/*      */   }
/*      */   public void setLimtType(String limtType) {
/* 1556 */     this.limtType = limtType;
/*      */   }
/*      */ 
/*      */   private String formatDate(String srcDate, String formate)
/*      */   {
/* 1566 */     String tDate = srcDate;
/* 1567 */     if ((srcDate != null) && (!"".equals(srcDate.trim()))) {
/* 1568 */       if (formate.indexOf("-") > 0)
/* 1569 */         tDate = srcDate.substring(0, 4) + "-" + srcDate.substring(4, 6) + "-" + srcDate.substring(6, 8);
/*      */       else {
/* 1571 */         tDate = srcDate.replaceAll("-", "");
/*      */       }
/*      */     }
/* 1574 */     return tDate;
/*      */   }
/*      */   public String gettSignDate() {
/* 1577 */     return this.tSignDate;
/*      */   }
/*      */   public void settSignDate(String tSignDate) {
/* 1580 */     this.tSignDate = tSignDate;
/*      */   }
/*      */   public String gettAgentCode() {
/* 1583 */     return this.tAgentCode;
/*      */   }
/*      */   public void settAgentCode(String tAgentCode) {
/* 1586 */     this.tAgentCode = tAgentCode;
/*      */   }
/*      */ 
/*      */   public String getDecryptAccount(String contno)
/*      */   {
/* 1594 */     String rStr = "";
/*      */ 
/* 1596 */     ExeSQL tExeSQL = new ExeSQL();
/*      */ 
/* 1598 */     String sql = "OPEN SYMMETRIC KEY key_encryption DECRYPTION BY CERTIFICATE cert_keyProtection;  SELECT convert(nvarchar(500),DecryptByKey(account)) from lnppayment where contno='" + 
/* 1599 */       contno + "' " + 
/* 1600 */       " CLOSE SYMMETRIC KEY key_encryption";
/*      */ 
/* 1602 */     SSRS tSSRS = tExeSQL.execSQL(sql);
/*      */ 
/* 1604 */     if ((tSSRS != null) && (tSSRS.MaxRow > 0)) {
/* 1605 */       rStr = tSSRS.GetText(1, 1);
/*      */     }
/* 1607 */     return rStr;
/*      */   }
/*      */   public String getSaleChannelCode() {
/* 1610 */     return this.saleChannelCode;
/*      */   }
/*      */ 
/*      */   public String getSaleChannelCode(String contno) {
/* 1614 */     HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/* 1615 */     String notiNum = (String)session.getAttribute("saleChannel");
/*      */ 
/* 1617 */     if ((notiNum == null) || ("".equals(notiNum)) || ("-1".equals(notiNum))) {
/* 1618 */       notiNum = "";
/* 1619 */       String mSql = "select uwtime from lnppol where contno='" + this.ContNo + "'";
/* 1620 */       SSRS tSSRS = new ExeSQL().execSQL(mSql);
/*      */ 
/* 1622 */       if ((tSSRS != null) && (tSSRS.getMaxRow() > 0)) {
/* 1623 */         notiNum = tSSRS.GetText(1, 1);
/*      */       }
/*      */     }
/* 1626 */     this.saleChannelCode = notiNum;
/* 1627 */     return notiNum;
/*      */   }
/*      */   public void setSaleChannelCode(String saleChannelCode) {
/* 1630 */     this.saleChannelCode = saleChannelCode;
/*      */   }
/*      */ 
/*      */   public boolean getIsRiskBQ()
/*      */   {
/* 1640 */     String sql = "select 1 from lnppol where contno='" + this.ContNo + "' and riskcode='MR12BQ' ";
/* 1641 */     SSRS tSSRS = new ExeSQL().execSQL(sql);
/* 1642 */     if ((tSSRS != null) && (tSSRS.getMaxRow() > 0)) {
/* 1643 */       this.isRiskBQ = true;
/*      */     }
/* 1645 */     return this.isRiskBQ;
/*      */   }
/*      */   public void setIsRiskBQ(boolean isRiskBQ) {
/* 1648 */     this.isRiskBQ = isRiskBQ;
/*      */   }
/*      */   public boolean getIsRiskBR() {
/* 1651 */     String sql = "select 1 from lnppol where contno='" + this.ContNo + "' and riskcode='MR12BR' ";
/* 1652 */     SSRS tSSRS = new ExeSQL().execSQL(sql);
/* 1653 */     if ((tSSRS != null) && (tSSRS.getMaxRow() > 0)) {
/* 1654 */       this.isRiskBR = true;
/*      */     }
/* 1656 */     return this.isRiskBR;
/*      */   }
/*      */   public void setIsRiskBR(boolean isRiskBR) {
/* 1659 */     this.isRiskBR = isRiskBR;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.BankNotifiAuthDetail
 * JD-Core Version:    0.6.0
 */