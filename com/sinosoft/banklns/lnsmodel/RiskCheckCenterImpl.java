/*      */ package com.sinosoft.banklns.lnsmodel;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPAppntDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPCalModeDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPCheckFieldDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPComDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPDutyGetDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPDutyPayDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPInsuredDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPOccupationDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPPolDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPRiskAppDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPRiskParamDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPRiskRoleDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
/*      */ import com.sinosoft.banklns.lis.schema.LNPCheckFieldSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPComSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPDutyGetSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPDutyPaySchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPInsuredSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPPolSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPRiskParamSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPRiskRoleSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPCheckFieldSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPComSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPDutyGetSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPDutyPaySet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPInsuredSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPPolSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPRiskParamSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPRiskRoleSet;
/*      */ import com.sinosoft.banklns.lnsmodel.util.InsuError;
/*      */ import com.sinosoft.banklns.lnsmodel.util.PolElementSchema;
/*      */ import com.sinosoft.banklns.lnsmodel.util.RiskError;
/*      */ import com.sinosoft.banklns.lnsmodel.util.SugError;
/*      */ import com.sinosoft.banklns.utility.EvalJavaTool;
/*      */ import com.sinosoft.banklns.utility.ExeSQL;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Hashtable;
/*      */ import java.util.List;
/*      */ import org.apache.log4j.Logger;
/*      */ 
/*      */ public class RiskCheckCenterImpl
/*      */ {
/*   23 */   private EvalJavaTool evalJavaTool = new EvalJavaTool();
/*      */ 
/*   25 */   private CalSpecialRulesElementsImpl calSpecialRulesElementsImpl = new CalSpecialRulesElementsImpl();
/*      */ 
/*   27 */   private RiskPolImpl riskPolImpl = new RiskPolImpl();
/*      */ 
/*   29 */   private Logger logger = Logger.getLogger(RiskCheckCenterImpl.class);
/*      */ 
/*      */   public SugError checkForOneInsu(String contNo, String insuredId, IGlobalInput tGlobalInput, String flag)
/*      */   {
/*   34 */     String sql = "select * from lnppol where polno=masterpolno and contNo='" + 
/*   35 */       contNo + "' and insuredId='" + insuredId + "'";
/*   36 */     LNPPolDB reLNPPolDB = new LNPPolDB();
/*   37 */     LNPPolSet reLNPPolSet = reLNPPolDB.executeQuery(sql);
/*   38 */     SugError reSugError = new SugError();
/*   39 */     for (int i = 1; (reLNPPolSet != null) && (i <= reLNPPolSet.size()); i++) {
/*   40 */       LNPPolSchema tLNPPolSchema = reLNPPolSet.get(i);
/*   41 */       SugError tempSugError = checkForOnePol(tLNPPolSchema.getPolNo(), 
/*   42 */         tGlobalInput, flag);
/*   43 */       if (tempSugError.hasError()) {
/*   44 */         if (reSugError.hasError()) {
/*   45 */           InsuError insuError = 
/*   46 */             (InsuError)reSugError
/*   46 */             .getInsuErrorList().get(0);
/*   47 */           List riskError = 
/*   48 */             ((InsuError)tempSugError
/*   48 */             .getInsuErrorList().get(0)).getRiskErrorList();
/*   49 */           int j = 0;
/*      */           do { insuError.addRiskError((RiskError)riskError.get(j));
/*      */ 
/*   49 */             j++; if (riskError == null) break;  }
/*   49 */           while (j < riskError.size());
/*      */         }
/*      */         else {
/*   52 */           InsuError insuError = 
/*   53 */             (InsuError)tempSugError
/*   53 */             .getInsuErrorList().get(0);
/*   54 */           reSugError.addInsuError(insuError);
/*      */         }
/*      */       }
/*      */     }
/*   58 */     LNPContSchema reLNPContSchema = new LNPContSchema();
/*   59 */     reLNPContSchema.setContNo(contNo);
/*   60 */     reSugError.setSugInfo(reLNPContSchema);
/*   61 */     return reSugError;
/*      */   }
/*      */ 
/*      */   public SugError checkForOnePol(String mainPolNo, IGlobalInput tGlobalInput, String flagStr)
/*      */   {
/*   68 */     List list = this.riskPolImpl.getPolList(mainPolNo, 1);
/*   69 */     List polList = (List)list.get(1);
/*   70 */     SugError reSugError = new SugError();
/*   71 */     InsuError reInsuError = new InsuError();
/*   72 */     String contNO = "";
/*   73 */     boolean flag = true;
/*   74 */     for (int i = 0; (polList != null) && (i < polList.size()); i++) {
/*   75 */       LNPPolSchema remLNPPolSchema = (LNPPolSchema)polList.get(i);
/*   76 */       contNO = remLNPPolSchema.getContNo();
/*   77 */       PolElementSchema rePolElementSchema = initPolElementSchemaInfo(
/*   78 */         remLNPPolSchema.getPolNo(), tGlobalInput);
/*      */ 
/*   82 */       rePolElementSchema = calSumRiskAmnt(rePolElementSchema);
/*      */ 
/*   85 */       List reusltList = new ArrayList();
/*      */ 
/*   87 */       List list_1 = checkSexAndAge(rePolElementSchema);
/*   88 */       List list_2 = checkOccupationAndPrem(rePolElementSchema);
/*   89 */       List list_3 = checkRiskSpecialRules(rePolElementSchema);
/*   90 */       List list_4 = checkCommonRules(rePolElementSchema);
/*   91 */       List list_5 = checkSpecialRules(rePolElementSchema);
/*   92 */       RiskError reRiskError = new RiskError();
/*      */ 
/*   96 */       if ((list_1 != null) && (list_1.size() > 0)) {
/*   97 */         reusltList.addAll(list_1);
/*      */       }
/*   99 */       if ((list_2 != null) && (list_2.size() > 0)) {
/*  100 */         reusltList.addAll(list_2);
/*      */       }
/*  102 */       if ((list_3 != null) && (list_3.size() > 0)) {
/*  103 */         reusltList.addAll(list_3);
/*      */       }
/*  105 */       if ((list_4 != null) && (list_4.size() > 0)) {
/*  106 */         reusltList.addAll(list_4);
/*      */       }
/*  108 */       if ((list_5 != null) && (list_5.size() > 0)) {
/*  109 */         reusltList.addAll(list_5);
/*      */       }
/*      */ 
/*  114 */       if ("FINAL".equals(flagStr)) {
/*  115 */         List list_6 = finalCheckForALl(rePolElementSchema);
/*  116 */         if ((list_6 != null) && (list_6.size() > 0)) {
/*  117 */           reusltList.addAll(list_6);
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*  122 */       if ("SUBMIT".equals(flagStr)) {
/*  123 */         List list_7 = submitAgentCheckForALl(rePolElementSchema);
/*  124 */         if ((list_7 != null) && (list_7.size() > 0)) {
/*  125 */           reusltList.addAll(list_7);
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*  130 */       if ("SUBMITOPER".equals(flagStr)) {
/*  131 */         List list_7 = submitOperCheckForALl(rePolElementSchema);
/*  132 */         if ((list_7 != null) && (list_7.size() > 0)) {
/*  133 */           reusltList.addAll(list_7);
/*      */         }
/*      */       }
/*      */ 
/*  137 */       if ((reusltList != null) && (reusltList.size() > 0)) {
/*  138 */         reRiskError.setRiskInfo(rePolElementSchema.getRiskCode());
/*  139 */         reRiskError.addError(reusltList);
/*      */ 
/*  141 */         reInsuError.setInsuInfo(rePolElementSchema.getContNo(), 
/*  142 */           rePolElementSchema.getInsuredId());
/*  143 */         reInsuError.addRiskError(reRiskError);
/*  144 */         flag = false;
/*      */       }
/*      */     }
/*  147 */     if (!flag) {
/*  148 */       LNPContSchema reLNPContSchema = new LNPContSchema();
/*  149 */       reLNPContSchema.setContNo(contNO);
/*  150 */       reSugError.setSugInfo(reLNPContSchema);
/*  151 */       reSugError.addInsuError(reInsuError);
/*      */     }
/*      */ 
/*  154 */     return reSugError;
/*      */   }
/*      */ 
/*      */   public SugError checkForOneRisk(String polNo, IGlobalInput tGlobalInput)
/*      */   {
/*  159 */     PolElementSchema rePolElementSchema = initPolElementSchemaInfo(polNo, 
/*  160 */       tGlobalInput);
/*  161 */     rePolElementSchema = calSumRiskAmnt(rePolElementSchema);
/*  162 */     List reusltList = new ArrayList();
/*      */ 
/*  164 */     List list_1 = checkSexAndAge(rePolElementSchema);
/*  165 */     List list_2 = checkOccupationAndPrem(rePolElementSchema);
/*  166 */     List list_3 = checkRiskSpecialRules(rePolElementSchema);
/*  167 */     List list_4 = checkCommonRules(rePolElementSchema);
/*  168 */     List list_5 = checkSpecialRules(rePolElementSchema);
/*      */ 
/*  170 */     SugError reSugError = new SugError();
/*  171 */     InsuError reInsuError = new InsuError();
/*  172 */     RiskError reRiskError = new RiskError();
/*      */ 
/*  176 */     if ((list_1 != null) && (list_1.size() > 0)) {
/*  177 */       reusltList.addAll(list_1);
/*      */     }
/*  179 */     if ((list_2 != null) && (list_2.size() > 0)) {
/*  180 */       reusltList.addAll(list_2);
/*      */     }
/*  182 */     if ((list_3 != null) && (list_3.size() > 0)) {
/*  183 */       reusltList.addAll(list_3);
/*      */     }
/*  185 */     if ((list_4 != null) && (list_4.size() > 0)) {
/*  186 */       reusltList.addAll(list_4);
/*      */     }
/*  188 */     if ((list_5 != null) && (list_5.size() > 0)) {
/*  189 */       reusltList.addAll(list_5);
/*      */     }
/*      */ 
/*  192 */     if ((reusltList != null) && (reusltList.size() > 0)) {
/*  193 */       reRiskError.setRiskInfo(rePolElementSchema.getRiskCode());
/*  194 */       reRiskError.addError(reusltList);
/*      */ 
/*  196 */       reInsuError.setInsuInfo(rePolElementSchema.getContNo(), 
/*  197 */         rePolElementSchema.getInsuredId());
/*  198 */       reInsuError.addRiskError(reRiskError);
/*      */ 
/*  200 */       LNPContSchema reLNPContSchema = new LNPContSchema();
/*  201 */       reLNPContSchema.setContNo(rePolElementSchema.getContNo());
/*  202 */       reSugError.setSugInfo(reLNPContSchema);
/*  203 */       reSugError.addInsuError(reInsuError);
/*      */     }
/*      */ 
/*  206 */     return reSugError;
/*      */   }
/*      */ 
/*      */   public SugError checkForOneSug(String contNo, IGlobalInput tGlobalInput)
/*      */   {
/*  211 */     LNPInsuredDB reLNPInsuredDB = new LNPInsuredDB();
/*  212 */     reLNPInsuredDB.setContNo(contNo);
/*  213 */     LNPInsuredSet reLNPInsuredSet = reLNPInsuredDB.query();
/*  214 */     SugError reSugError = new SugError();
/*  215 */     for (int i = 1; (reLNPInsuredSet != null) && (i <= reLNPInsuredSet.size()); i++) {
/*  216 */       LNPInsuredSchema reLNPInsuredSchema = reLNPInsuredSet.get(i);
/*  217 */       SugError tempSugError = checkForOneInsu(contNo, reLNPInsuredSchema
/*  218 */         .getInsuredId(), tGlobalInput, "FINAL");
/*  219 */       if (tempSugError.hasError()) {
/*  220 */         reSugError.addInsuError(
/*  221 */           (InsuError)tempSugError
/*  221 */           .getInsuErrorList().get(0));
/*      */       }
/*      */     }
/*  224 */     LNPContSchema reLNPContSchema = new LNPContSchema();
/*  225 */     reLNPContSchema.setContNo(contNo);
/*  226 */     reSugError.setSugInfo(reLNPContSchema);
/*  227 */     return reSugError;
/*      */   }
/*      */ 
/*      */   public SugError checkOnePolAfterCal(String contNo, IGlobalInput tGlobalInput)
/*      */   {
/*  233 */     LNPInsuredDB reLNPInsuredDB = new LNPInsuredDB();
/*  234 */     reLNPInsuredDB.setContNo(contNo);
/*  235 */     LNPInsuredSet reLNPInsuredSet = reLNPInsuredDB.query();
/*  236 */     SugError reSugError = new SugError();
/*  237 */     for (int i = 1; (reLNPInsuredSet != null) && (i <= reLNPInsuredSet.size()); i++) {
/*  238 */       LNPInsuredSchema reLNPInsuredSchema = reLNPInsuredSet.get(i);
/*  239 */       SugError tempSugError = checkForOneInsu(contNo, reLNPInsuredSchema
/*  240 */         .getInsuredId(), tGlobalInput, "FINAL");
/*  241 */       if (tempSugError.hasError()) {
/*  242 */         reSugError.addInsuError(
/*  243 */           (InsuError)tempSugError
/*  243 */           .getInsuErrorList().get(0));
/*      */       }
/*      */     }
/*  246 */     LNPContSchema reLNPContSchema = new LNPContSchema();
/*  247 */     reLNPContSchema.setContNo(contNo);
/*  248 */     reSugError.setSugInfo(reLNPContSchema);
/*  249 */     return reSugError;
/*      */   }
/*      */ 
/*      */   public SugError checkOnePolBeforeSubmitAgent(String contNo, IGlobalInput tGlobalInput)
/*      */   {
/*  256 */     LNPInsuredDB reLNPInsuredDB = new LNPInsuredDB();
/*  257 */     reLNPInsuredDB.setContNo(contNo);
/*  258 */     LNPInsuredSet reLNPInsuredSet = reLNPInsuredDB.query();
/*  259 */     SugError reSugError = new SugError();
/*  260 */     for (int i = 1; (reLNPInsuredSet != null) && (i <= reLNPInsuredSet.size()); i++) {
/*  261 */       LNPInsuredSchema reLNPInsuredSchema = reLNPInsuredSet.get(i);
/*  262 */       SugError tempSugError = checkForOneInsu(contNo, reLNPInsuredSchema
/*  263 */         .getInsuredId(), tGlobalInput, "SUBMIT");
/*  264 */       if (tempSugError.hasError()) {
/*  265 */         reSugError.addInsuError(
/*  266 */           (InsuError)tempSugError
/*  266 */           .getInsuErrorList().get(0));
/*      */       }
/*      */     }
/*  269 */     LNPContSchema reLNPContSchema = new LNPContSchema();
/*  270 */     reLNPContSchema.setContNo(contNo);
/*  271 */     reSugError.setSugInfo(reLNPContSchema);
/*  272 */     return reSugError;
/*      */   }
/*      */ 
/*      */   public SugError checkOnePolBeforeSubmitOperator(String contNo, IGlobalInput tGlobalInput)
/*      */   {
/*  278 */     LNPInsuredDB reLNPInsuredDB = new LNPInsuredDB();
/*  279 */     reLNPInsuredDB.setContNo(contNo);
/*  280 */     LNPInsuredSet reLNPInsuredSet = reLNPInsuredDB.query();
/*  281 */     SugError reSugError = new SugError();
/*  282 */     for (int i = 1; (reLNPInsuredSet != null) && (i <= reLNPInsuredSet.size()); i++) {
/*  283 */       LNPInsuredSchema reLNPInsuredSchema = reLNPInsuredSet.get(i);
/*  284 */       SugError tempSugError = checkForOneInsu(contNo, reLNPInsuredSchema
/*  285 */         .getInsuredId(), tGlobalInput, "SUBMITOPER");
/*  286 */       if (tempSugError.hasError()) {
/*  287 */         reSugError.addInsuError(
/*  288 */           (InsuError)tempSugError
/*  288 */           .getInsuErrorList().get(0));
/*      */       }
/*      */     }
/*  291 */     LNPContSchema reLNPContSchema = new LNPContSchema();
/*  292 */     reLNPContSchema.setContNo(contNo);
/*  293 */     reSugError.setSugInfo(reLNPContSchema);
/*  294 */     return reSugError;
/*      */   }
/*      */ 
/*      */   private List checkSexAndAge(PolElementSchema inPolElementSchema)
/*      */   {
/*  299 */     List errorList = new ArrayList();
/*      */ 
/*  301 */     LNPRiskRoleDB eeLNPRiskRoleDB = new LNPRiskRoleDB();
/*  302 */     eeLNPRiskRoleDB.setRiskCode(inPolElementSchema.getRiskCode());
/*  303 */     eeLNPRiskRoleDB.setRiskRole("00");
/*  304 */     LNPRiskRoleSet reLNPRiskRoleSet = eeLNPRiskRoleDB.query();
/*  305 */     if ((reLNPRiskRoleSet != null) && (reLNPRiskRoleSet.size() > 0)) {
/*  306 */       LNPRiskRoleSchema tempLNPRiskRoleSchema = reLNPRiskRoleSet.get(1);
/*  307 */       LNPAppntDB reLNPAppntDB = new LNPAppntDB();
/*  308 */       reLNPAppntDB.setContNo(inPolElementSchema.getContNo());
/*  309 */       reLNPAppntDB.getInfo();
/*      */ 
/*  311 */       String birthday = reLNPAppntDB.getAppntBirthday();
/*      */ 
/*  313 */       String agetype = reLNPAppntDB.getAppntAgeType();
/*  314 */       int age = reLNPAppntDB.getAppntAge();
/*      */ 
/*  326 */       String sex = reLNPAppntDB.getAppntSex();
/*      */ 
/*  328 */       String reSex = tempLNPRiskRoleSchema.getRiskRoleSex();
/*  329 */       if ((!reSex.equals("2")) && (!reSex.equals(sex))) {
/*  330 */         errorList.add("\u0376\uFFFD\uFFFD\uFFFD\u02F5\uFFFD\uFFFD\u0531\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u05B5\uFFFD\uFFFD\u0636\uFFFD\uFFFD\uFFFD\u04AA\uFFFD\uFFFD");
/*      */       }
/*      */ 
/*  333 */       String MinAppAgeFlag = tempLNPRiskRoleSchema.getMinAppAgeFlag();
/*  334 */       int minappAge = tempLNPRiskRoleSchema.getMinAppAge();
/*  335 */       if ((MinAppAgeFlag != null) && (MinAppAgeFlag.equals("Y")))
/*      */       {
/*  337 */         if ("Y".equals(agetype))
/*      */         {
/*  339 */           if (minappAge > age) {
/*  340 */             errorList.add("\u0376\uFFFD\uFFFD\uFFFD\u02F5\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD[" + age + "\uFFFD\uFFFD]\u0421\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u04AA\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0421\uFFFD\uFFFD\uFFFD\uFFFD[" + 
/*  341 */               minappAge + "\uFFFD\uFFFD]\uFFFD\uFFFD");
/*      */           }
/*      */         }
/*  344 */         else if ("D".equals(agetype))
/*      */         {
/*  346 */           errorList.add("\u0376\uFFFD\uFFFD\uFFFD\u02F5\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD[" + age + "\uFFFD\uFFFD]\u0421\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u04AA\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0421\uFFFD\uFFFD\uFFFD\uFFFD[" + 
/*  347 */             minappAge + "\uFFFD\uFFFD]\uFFFD\uFFFD");
/*      */         }
/*      */ 
/*      */       }
/*  351 */       else if ((MinAppAgeFlag != null) && (birthday != null) && 
/*  352 */         (birthday.length() > 0))
/*      */       {
/*  356 */         if (!"Y".equals(agetype))
/*      */         {
/*  360 */           if ("D".equals(agetype))
/*      */           {
/*  362 */             String flag = tempLNPRiskRoleSchema.getMinAppAgeFlag();
/*  363 */             if ((flag.equals("D")) && 
/*  364 */               (minappAge > age))
/*      */             {
/*  366 */               errorList.add("\u0376\uFFFD\uFFFD\uFFFD\u02F5\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD[" + age + "\uFFFD\uFFFD" + "]\u0421\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u04AA\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0421\uFFFD\uFFFD\uFFFD\uFFFD[" + 
/*  367 */                 minappAge + "\uFFFD\uFFFD" + "]\uFFFD\uFFFD");
/*      */             }
/*      */ 
/*      */           }
/*      */ 
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*  383 */       String MAXAppAgeFlag = tempLNPRiskRoleSchema.getMAXAppAgeFlag();
/*  384 */       int MAXAppAge = tempLNPRiskRoleSchema.getMAXAppAge();
/*      */ 
/*  386 */       if ((MAXAppAgeFlag != null) && (MAXAppAgeFlag.equals("Y")))
/*      */       {
/*  388 */         if ("Y".equals(agetype))
/*      */         {
/*  390 */           if (MAXAppAge < age)
/*  391 */             errorList.add("\u0376\uFFFD\uFFFD\uFFFD\u02F5\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD[" + age + "\uFFFD\uFFFD]\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u04AA\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD[" + 
/*  392 */               MAXAppAge + "\uFFFD\uFFFD]\uFFFD\uFFFD");
/*      */         }
/*      */         else {
/*  395 */           "D".equals(agetype);
/*      */         }
/*      */ 
/*      */       }
/*  400 */       else if ((MAXAppAgeFlag != null) && (birthday != null) && 
/*  401 */         (birthday.length() > 0))
/*      */       {
/*  405 */         if ("Y".equals(agetype))
/*      */         {
/*  407 */           errorList.add("\u0376\uFFFD\uFFFD\uFFFD\u02F5\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD[" + age + "\uFFFD\uFFFD]\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u04AA\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD[" + 
/*  408 */             MAXAppAge + "\uFFFD\uFFFD]\uFFFD\uFFFD");
/*      */         }
/*  410 */         else if ("D".equals(agetype))
/*      */         {
/*  412 */           String flag = tempLNPRiskRoleSchema.getMAXAppAgeFlag();
/*  413 */           if ((flag.equals("D")) && 
/*  414 */             (MAXAppAge < age))
/*      */           {
/*  416 */             errorList.add("\u0376\uFFFD\uFFFD\uFFFD\u02F5\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD[" + age + "\uFFFD\uFFFD" + "]\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u04AA\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD[" + 
/*  417 */               minappAge + "\uFFFD\uFFFD" + "]\uFFFD\uFFFD");
/*      */           }
/*      */ 
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  426 */     eeLNPRiskRoleDB = new LNPRiskRoleDB();
/*  427 */     eeLNPRiskRoleDB.setRiskCode(inPolElementSchema.getRiskCode());
/*  428 */     eeLNPRiskRoleDB.setRiskRole("01");
/*  429 */     reLNPRiskRoleSet = eeLNPRiskRoleDB.query();
/*  430 */     if ((reLNPRiskRoleSet != null) && (reLNPRiskRoleSet.size() > 0)) {
/*  431 */       LNPRiskRoleSchema tempLNPRiskRoleSchema = reLNPRiskRoleSet.get(1);
/*  432 */       LNPInsuredDB reLNPInsuredDB = new LNPInsuredDB();
/*  433 */       reLNPInsuredDB.setContNo(inPolElementSchema.getContNo());
/*  434 */       reLNPInsuredDB.setInsuredId(inPolElementSchema.getInsuredId());
/*  435 */       reLNPInsuredDB.getInfo();
/*      */ 
/*  437 */       String birthday = reLNPInsuredDB.getBirthday();
/*      */ 
/*  439 */       String agetype = reLNPInsuredDB.getAppAgeType();
/*  440 */       int age = reLNPInsuredDB.getAppAge();
/*      */ 
/*  443 */       String sex = reLNPInsuredDB.getSex();
/*      */ 
/*  445 */       String reSex = tempLNPRiskRoleSchema.getRiskRoleSex();
/*  446 */       if ((!reSex.equals("2")) && (!reSex.equals(sex))) {
/*  447 */         errorList.add("\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u02F5\uFFFD\uFFFD\u0531\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u05B5\uFFFD\uFFFD\u0636\uFFFD\uFFFD\uFFFD\u04AA\uFFFD\uFFFD");
/*      */       }
/*      */ 
/*  453 */       String MinAppAgeFlag = tempLNPRiskRoleSchema.getMinAppAgeFlag();
/*  454 */       int minappAge = tempLNPRiskRoleSchema.getMinAppAge();
/*  455 */       if ((MinAppAgeFlag != null) && (MinAppAgeFlag.equals("Y")))
/*      */       {
/*  457 */         if ("Y".equals(agetype))
/*      */         {
/*  459 */           if (minappAge > age) {
/*  460 */             errorList.add("\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u02F5\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD[" + age + "\uFFFD\uFFFD]\u0421\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u04AA\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0421\uFFFD\uFFFD\uFFFD\uFFFD[" + 
/*  461 */               minappAge + "\uFFFD\uFFFD]\uFFFD\uFFFD");
/*      */           }
/*      */         }
/*  464 */         else if ("D".equals(agetype))
/*      */         {
/*  466 */           errorList.add("\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u02F5\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD[" + age + "\uFFFD\uFFFD]\u0421\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u04AA\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0421\uFFFD\uFFFD\uFFFD\uFFFD[" + 
/*  467 */             minappAge + "\uFFFD\uFFFD]\uFFFD\uFFFD");
/*      */         }
/*      */ 
/*      */       }
/*  471 */       else if ((MinAppAgeFlag != null) && (birthday != null) && 
/*  472 */         (birthday.length() > 0))
/*      */       {
/*  476 */         if (!"Y".equals(agetype))
/*      */         {
/*  480 */           if ("D".equals(agetype))
/*      */           {
/*  482 */             String flag = tempLNPRiskRoleSchema.getMinAppAgeFlag();
/*  483 */             if ((flag.equals("D")) && 
/*  484 */               (minappAge > age))
/*      */             {
/*  486 */               errorList.add("\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u02F5\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD[" + age + "\uFFFD\uFFFD" + "]\u0421\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u04AA\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0421\uFFFD\uFFFD\uFFFD\uFFFD[" + 
/*  487 */                 minappAge + "\uFFFD\uFFFD" + "]\uFFFD\uFFFD");
/*      */             }
/*      */           }
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*  494 */       String MAXAppAgeFlag = tempLNPRiskRoleSchema.getMAXAppAgeFlag();
/*  495 */       int MAXAppAge = tempLNPRiskRoleSchema.getMAXAppAge();
/*      */ 
/*  497 */       if ((MAXAppAgeFlag != null) && (MAXAppAgeFlag.equals("Y")))
/*      */       {
/*  499 */         if ("Y".equals(agetype))
/*      */         {
/*  501 */           if (MAXAppAge < age)
/*  502 */             errorList.add("\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u02F5\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD[" + age + "\uFFFD\uFFFD]\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u04AA\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD[" + 
/*  503 */               MAXAppAge + "\uFFFD\uFFFD]\uFFFD\uFFFD");
/*      */         }
/*      */         else {
/*  506 */           "D".equals(agetype);
/*      */         }
/*      */ 
/*      */       }
/*  511 */       else if ((MAXAppAgeFlag != null) && (birthday != null) && 
/*  512 */         (birthday.length() > 0))
/*      */       {
/*  516 */         if ("Y".equals(agetype))
/*      */         {
/*  518 */           errorList.add("\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u02F5\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD[" + age + "\uFFFD\uFFFD]\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u04AA\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD[" + 
/*  519 */             MAXAppAge + "\uFFFD\uFFFD]\uFFFD\uFFFD");
/*      */         }
/*  521 */         else if ("D".equals(agetype))
/*      */         {
/*  523 */           String flag = tempLNPRiskRoleSchema.getMAXAppAgeFlag();
/*  524 */           if ((flag.equals("D")) && 
/*  525 */             (MAXAppAge < age))
/*      */           {
/*  527 */             errorList.add("\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u02F5\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD[" + age + "\uFFFD\uFFFD" + "]\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u04AA\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD[" + 
/*  528 */               minappAge + "\uFFFD\uFFFD" + "]\uFFFD\uFFFD");
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*  534 */     return errorList;
/*      */   }
/*      */ 
/*      */   private List checkOccupationAndPrem(PolElementSchema inPolElementSchema)
/*      */   {
/*  540 */     List errorList = new ArrayList();
/*      */ 
/*  543 */     String occupationcode = inPolElementSchema.getOccupationCode();
/*  544 */     String riskcode = inPolElementSchema.getRiskCode();
/*      */ 
/*  546 */     LNPRiskAppDB reLNPRiskAppDB = new LNPRiskAppDB();
/*  547 */     reLNPRiskAppDB.setRiskCode(riskcode);
/*  548 */     reLNPRiskAppDB.getInfo();
/*  549 */     String risktype = reLNPRiskAppDB.getRiskType();
/*      */ 
/*  551 */     String occupationType = null;
/*  552 */     LNPOccupationDB reLNPOccupationDB = new LNPOccupationDB();
/*      */ 
/*  556 */     String riskprop = reLNPRiskAppDB.getRiskProp();
/*  557 */     if ("R".equals(riskprop))
/*      */     {
/*  559 */       reLNPOccupationDB.setOccupationCode(inPolElementSchema
/*  560 */         .getAppntOccupationCode());
/*      */     }
/*  562 */     else reLNPOccupationDB.setOccupationCode(occupationcode);
/*      */ 
/*  564 */     reLNPOccupationDB.getInfo();
/*      */ 
/*  566 */     if (risktype.equals("L"))
/*  567 */       occupationType = reLNPOccupationDB.getLifeRate();
/*  568 */     else if (risktype.equals("W"))
/*  569 */       occupationType = reLNPOccupationDB.getWpRate();
/*  570 */     else if (risktype.equals("H"))
/*  571 */       occupationType = reLNPOccupationDB.getHiRate();
/*  572 */     else if (risktype.equals("A")) {
/*  573 */       occupationType = reLNPOccupationDB.getPaRate();
/*      */     }
/*      */     else {
/*  576 */       occupationType = reLNPOccupationDB.getPaRate();
/*      */     }
/*  578 */     if ("\uFFFD\u0731\uFFFD".equals(occupationType)) {
/*  579 */       errorList.add("\u03F5\u0373\uFFFD\u0731\uFFFD\uFFFD\uFFFD\u01F0\u05B0\u04B5[" + reLNPOccupationDB.getOccupationName() + 
/*  580 */         "]");
/*      */     }
/*      */ 
/*  586 */     String sql = "select * from lnpdutypay where PayPlanCode in (select payplancode from LnpDutyPayRela where dutycode in (select dutycode from lnpriskduty where  riskcode='" + 
/*  588 */       inPolElementSchema.getRiskCode() + "'))";
/*  589 */     LNPDutyPayDB reLNPDutyPayDB = new LNPDutyPayDB();
/*  590 */     LNPDutyPaySet teLNPDutyPaySet = reLNPDutyPayDB.executeQuery(sql);
/*  591 */     if ((teLNPDutyPaySet != null) && (teLNPDutyPaySet.size() > 0)) {
/*  592 */       reLNPDutyPayDB = teLNPDutyPaySet.get(1).getDB();
/*  593 */       String flag = reLNPDutyPayDB.getZeroFlag();
/*  594 */       if (("N".equalsIgnoreCase(flag)) && (inPolElementSchema.getPrem() == 0.0D)) {
/*  595 */         errorList.add("\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD4\uFFFD\u0131\uFFFD\uFFFD\u0472\uFFFD\uFFFD\uFFFD\u03AA0,\uFFFD\uFFFD\uFFFD\uFFFD\u0277\uFFFD\uFFFD\uFFFD\uFFFD\uBC7B\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u01F7\uFFFD\u01A5\uFFFD\uFFFD\uDA87\uDEF1\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u05B0\u04B5\uFFFD\u023C\uFFFD\uFFFD\u01F7\uD98E\uDF39\uFFFD\uFFFD\uFFFD\uFFFD\u01A1\uFFFD");
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  600 */     sql = "select * from lnpdutyget where getdutycode in (select getdutycode from LnpDutygetRela where dutycode in (select dutycode from lnpriskduty where  riskcode='" + 
/*  602 */       inPolElementSchema.getRiskCode() + "'))";
/*  603 */     LNPDutyGetDB reLNPDutyGetDB = new LNPDutyGetDB();
/*  604 */     LNPDutyGetSet reLNPDutyGetSet = reLNPDutyGetDB.executeQuery(sql);
/*  605 */     if ((reLNPDutyGetSet != null) && (reLNPDutyGetSet.size() > 0)) {
/*  606 */       reLNPDutyGetDB = reLNPDutyGetSet.get(1).getDB();
/*  607 */       String flag = reLNPDutyGetDB.getZeroFlag();
/*  608 */       if (("N".equalsIgnoreCase(flag)) && (inPolElementSchema.getAmnt() == 0.0D)) {
/*  609 */         errorList.add("\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD4\uFFFD\u0131\uFFFD\uFFFD\uECBB\uFFFD\uFFFD\u03AA0");
/*      */       }
/*      */     }
/*      */ 
/*  613 */     return errorList;
/*      */   }
/*      */ 
/*      */   private List checkRiskSpecialRules(PolElementSchema inPolElementSchema)
/*      */   {
/*  621 */     List errorList = new ArrayList();
/*  622 */     LNPCheckFieldSchema tempLNPCheckFieldSchema = null;
/*  623 */     ExeSQL tempExeSQL = new ExeSQL();
/*  624 */     LNPCheckFieldDB tLNPCheckFieldDB = new LNPCheckFieldDB();
/*  625 */     String sql = "select * from lnpcheckField where riskcode='" + 
/*  626 */       inPolElementSchema.getRiskCode() + 
/*  627 */       "' and fieldname='TBINSERT' order by SerialNo";
/*  628 */     LNPCheckFieldSet tLNPCheckFieldSet = tLNPCheckFieldDB.executeQuery(sql);
/*  629 */     if (tLNPCheckFieldSet.size() > 0) {
/*  630 */       tempLNPCheckFieldSchema = null;
/*      */ 
/*  632 */       for (int i = 1; i <= tLNPCheckFieldSet.size(); i++) {
/*  633 */         tempLNPCheckFieldSchema = tLNPCheckFieldSet.get(i);
/*  634 */         LNPCalModeDB tLNPCalModeDB = new LNPCalModeDB();
/*  635 */         tLNPCalModeDB.setCalCode(tempLNPCheckFieldSchema.getCalCode());
/*  636 */         if (!tLNPCalModeDB.getInfo()) {
/*      */           continue;
/*      */         }
/*  639 */         String tempsql = tLNPCalModeDB.getCalSQL();
/*  640 */         tempsql = transportExpression(tempsql, inPolElementSchema);
/*      */ 
/*  642 */         if (!check(tempsql, tempExeSQL)) {
/*  643 */           errorList.add(tempLNPCheckFieldSchema.getMsg());
/*      */         }
/*      */       }
/*      */     }
/*  647 */     return errorList;
/*      */   }
/*      */ 
/*      */   private List checkCommonRules(PolElementSchema inPolElementSchema)
/*      */   {
/*  652 */     List errorList = new ArrayList();
/*  653 */     LNPCheckFieldSchema tempLNPCheckFieldSchema = null;
/*  654 */     ExeSQL tempExeSQL = new ExeSQL();
/*  655 */     LNPCheckFieldDB tLNPCheckFieldDB = new LNPCheckFieldDB();
/*      */ 
/*  657 */     String sql = "select * from lnpcheckField where riskcode='000000' and fieldname='TBINSERT' and (location='" + 
/*  659 */       inPolElementSchema.getRiskChannel() + 
/*  660 */       "' or location is null) order by SerialNo";
/*  661 */     LNPCheckFieldSet tLNPCheckFieldSet = tLNPCheckFieldDB.executeQuery(sql);
/*  662 */     if (tLNPCheckFieldSet.size() > 0) {
/*  663 */       tempLNPCheckFieldSchema = null;
/*      */ 
/*  665 */       for (int i = 1; i <= tLNPCheckFieldSet.size(); i++) {
/*  666 */         tempLNPCheckFieldSchema = tLNPCheckFieldSet.get(i);
/*  667 */         LNPCalModeDB tLNPCalModeDB = new LNPCalModeDB();
/*  668 */         tLNPCalModeDB.setCalCode(tempLNPCheckFieldSchema.getCalCode());
/*  669 */         if (!tLNPCalModeDB.getInfo()) {
/*      */           continue;
/*      */         }
/*  672 */         String tempsql = tLNPCalModeDB.getCalSQL();
/*  673 */         tempsql = transportExpression(tempsql, inPolElementSchema);
/*  674 */         if (!check(tempsql, tempExeSQL)) {
/*  675 */           errorList.add(tempLNPCheckFieldSchema.getMsg());
/*      */         }
/*      */       }
/*      */     }
/*  679 */     return errorList;
/*      */   }
/*      */ 
/*      */   private List finalCheckForOneRisk(PolElementSchema inPolElementSchema)
/*      */   {
/*  684 */     List errorList = new ArrayList();
/*  685 */     LNPCheckFieldSchema tempLNPCheckFieldSchema = null;
/*  686 */     ExeSQL tempExeSQL = new ExeSQL();
/*  687 */     LNPCheckFieldDB tLNPCheckFieldDB = new LNPCheckFieldDB();
/*  688 */     String sql = "select * from lmcheckField where riskcode='" + 
/*  689 */       inPolElementSchema.getRiskCode() + 
/*  690 */       "' and fieldname='FINAL' and (location='" + 
/*  691 */       inPolElementSchema.getRiskChannel() + 
/*  692 */       "' or location is null) order by SerialNo";
/*  693 */     LNPCheckFieldSet tLNPCheckFieldSet = tLNPCheckFieldDB.executeQuery(sql);
/*  694 */     if (tLNPCheckFieldSet.size() > 0) {
/*  695 */       tempLNPCheckFieldSchema = null;
/*      */ 
/*  697 */       for (int i = 1; i <= tLNPCheckFieldSet.size(); i++) {
/*  698 */         tempLNPCheckFieldSchema = tLNPCheckFieldSet.get(i);
/*  699 */         LNPCalModeDB tLNPCalModeDB = new LNPCalModeDB();
/*  700 */         tLNPCalModeDB.setCalCode(tempLNPCheckFieldSchema.getCalCode());
/*  701 */         if (!tLNPCalModeDB.getInfo()) {
/*      */           continue;
/*      */         }
/*  704 */         String tempsql = tLNPCalModeDB.getCalSQL();
/*  705 */         tempsql = transportExpression(tempsql, inPolElementSchema);
/*  706 */         if (!check(tempsql, tempExeSQL)) {
/*  707 */           errorList.add(tempLNPCheckFieldSchema.getMsg());
/*      */         }
/*      */       }
/*      */     }
/*  711 */     return errorList;
/*      */   }
/*      */ 
/*      */   private List finalCheckForALl(PolElementSchema inPolElementSchema)
/*      */   {
/*  716 */     List errorList = new ArrayList();
/*  717 */     LNPCheckFieldSchema tempLNPCheckFieldSchema = null;
/*  718 */     ExeSQL tempExeSQL = new ExeSQL();
/*  719 */     LNPCheckFieldDB tLNPCheckFieldDB = new LNPCheckFieldDB();
/*  720 */     String sql = "select * from lNPcheckField where riskcode='000000' and fieldname='FINAL' and (location='" + 
/*  721 */       inPolElementSchema.getRiskChannel() + 
/*  722 */       "' or location is null) order by SerialNo";
/*  723 */     LNPCheckFieldSet tLNPCheckFieldSet = tLNPCheckFieldDB.executeQuery(sql);
/*  724 */     if (tLNPCheckFieldSet.size() > 0) {
/*  725 */       tempLNPCheckFieldSchema = null;
/*      */ 
/*  727 */       for (int i = 1; i <= tLNPCheckFieldSet.size(); i++) {
/*  728 */         tempLNPCheckFieldSchema = tLNPCheckFieldSet.get(i);
/*  729 */         LNPCalModeDB tLNPCalModeDB = new LNPCalModeDB();
/*  730 */         tLNPCalModeDB.setCalCode(tempLNPCheckFieldSchema.getCalCode());
/*  731 */         if (!tLNPCalModeDB.getInfo()) {
/*      */           continue;
/*      */         }
/*  734 */         String tempsql = tLNPCalModeDB.getCalSQL();
/*  735 */         tempsql = transportExpression(tempsql, inPolElementSchema);
/*  736 */         if (!check(tempsql, tempExeSQL)) {
/*  737 */           errorList.add(tempLNPCheckFieldSchema.getMsg());
/*      */         }
/*      */       }
/*      */     }
/*  741 */     return errorList;
/*      */   }
/*      */ 
/*      */   private List submitAgentCheckForALl(PolElementSchema inPolElementSchema)
/*      */   {
/*  746 */     List errorList = new ArrayList();
/*  747 */     LNPCheckFieldSchema tempLNPCheckFieldSchema = null;
/*  748 */     ExeSQL tempExeSQL = new ExeSQL();
/*  749 */     LNPCheckFieldDB tLNPCheckFieldDB = new LNPCheckFieldDB();
/*  750 */     String sql = "select * from lNPcheckField where riskcode='000000' and fieldname like 'SUBMIT%' and (location='" + 
/*  751 */       inPolElementSchema.getRiskChannel() + 
/*  752 */       "' or location is null) order by SerialNo";
/*  753 */     LNPCheckFieldSet tLNPCheckFieldSet = tLNPCheckFieldDB.executeQuery(sql);
/*  754 */     if (tLNPCheckFieldSet.size() > 0) {
/*  755 */       tempLNPCheckFieldSchema = null;
/*      */ 
/*  757 */       for (int i = 1; i <= tLNPCheckFieldSet.size(); i++) {
/*  758 */         tempLNPCheckFieldSchema = tLNPCheckFieldSet.get(i);
/*  759 */         LNPCalModeDB tLNPCalModeDB = new LNPCalModeDB();
/*  760 */         tLNPCalModeDB.setCalCode(tempLNPCheckFieldSchema.getCalCode());
/*  761 */         if (!tLNPCalModeDB.getInfo()) {
/*      */           continue;
/*      */         }
/*  764 */         String tempsql = tLNPCalModeDB.getCalSQL();
/*  765 */         tempsql = transportExpression(tempsql, inPolElementSchema);
/*  766 */         if (!check(tempsql, tempExeSQL)) {
/*  767 */           errorList.add(tempLNPCheckFieldSchema.getMsg());
/*      */         }
/*      */       }
/*      */     }
/*  771 */     return errorList;
/*      */   }
/*      */ 
/*      */   private List submitOperCheckForALl(PolElementSchema inPolElementSchema)
/*      */   {
/*  776 */     List errorList = new ArrayList();
/*  777 */     LNPCheckFieldSchema tempLNPCheckFieldSchema = null;
/*  778 */     ExeSQL tempExeSQL = new ExeSQL();
/*  779 */     LNPCheckFieldDB tLNPCheckFieldDB = new LNPCheckFieldDB();
/*  780 */     String sql = "select * from lNPcheckField where riskcode='000000' and fieldname like 'SUBMITOPER' and (location='" + 
/*  781 */       inPolElementSchema.getRiskChannel() + 
/*  782 */       "' or location is null) order by SerialNo";
/*  783 */     LNPCheckFieldSet tLNPCheckFieldSet = tLNPCheckFieldDB.executeQuery(sql);
/*  784 */     if (tLNPCheckFieldSet.size() > 0) {
/*  785 */       tempLNPCheckFieldSchema = null;
/*      */ 
/*  787 */       for (int i = 1; i <= tLNPCheckFieldSet.size(); i++) {
/*  788 */         tempLNPCheckFieldSchema = tLNPCheckFieldSet.get(i);
/*  789 */         LNPCalModeDB tLNPCalModeDB = new LNPCalModeDB();
/*  790 */         tLNPCalModeDB.setCalCode(tempLNPCheckFieldSchema.getCalCode());
/*  791 */         if (!tLNPCalModeDB.getInfo()) {
/*      */           continue;
/*      */         }
/*  794 */         String tempsql = tLNPCalModeDB.getCalSQL();
/*  795 */         tempsql = transportExpression(tempsql, inPolElementSchema);
/*  796 */         if (!check(tempsql, tempExeSQL)) {
/*  797 */           errorList.add(tempLNPCheckFieldSchema.getMsg());
/*      */         }
/*      */       }
/*      */     }
/*  801 */     return errorList;
/*      */   }
/*      */ 
/*      */   private List checkSpecialRules(PolElementSchema inPolElementSchema)
/*      */   {
/*  810 */     List errorList = new ArrayList();
/*  811 */     LNPRiskParamDB tLNPRiskParamDB = new LNPRiskParamDB();
/*  812 */     tLNPRiskParamDB.setType("SpecialRules");
/*  813 */     tLNPRiskParamDB.setRiskCode(inPolElementSchema.getRiskCode());
/*  814 */     LNPRiskParamSet tLNPRiskParamSet = tLNPRiskParamDB.query();
/*  815 */     for (int i = 1; (tLNPRiskParamSet != null) && (i <= tLNPRiskParamSet.size()); i++) {
/*  816 */       LNPRiskParamSchema tempLNPRiskParamSchema = tLNPRiskParamSet.get(i);
/*  817 */       String beanName = tempLNPRiskParamSchema.getExpression();
/*      */ 
/*  819 */       SpecialRiskRulesImpl insSpecialRiskRulesImpl = new SpecialRiskRulesImpl();
/*  820 */       List list = insSpecialRiskRulesImpl.checkRules(inPolElementSchema);
/*  821 */       errorList.addAll(list);
/*      */     }
/*      */ 
/*  824 */     return errorList;
/*      */   }
/*      */ 
/*      */   private PolElementSchema initPolElementSchemaInfo(String polNo, IGlobalInput tGlobalInput)
/*      */   {
/*  831 */     if (tGlobalInput == null) {
/*  832 */       return null;
/*      */     }
/*      */ 
/*  835 */     PolElementSchema inPolElementSchema = new PolElementSchema();
/*      */ 
/*  838 */     String polManageCom = polNo.substring(0, 2);
/*  839 */     LNPComDB tLNPComDB = new LNPComDB();
/*  840 */     tLNPComDB.setValidCode(polManageCom);
/*  841 */     LNPComSet tLNPComSet = tLNPComDB.query();
/*      */ 
/*  843 */     if (tLNPComSet.get(1) != null)
/*      */     {
/*  845 */       polManageCom = tLNPComSet.get(1).getComCode();
/*      */     }
/*      */     else
/*      */     {
/*  849 */       polManageCom = tGlobalInput.ComCode;
/*      */     }
/*      */ 
/*  852 */     inPolElementSchema.setManageCom(polManageCom);
/*      */ 
/*  854 */     inPolElementSchema.setRiskChannel(tGlobalInput.chanlesign);
/*  855 */     inPolElementSchema.setAgentCode(tGlobalInput.Operator);
/*  856 */     inPolElementSchema.setBranchType(tGlobalInput.BranchType);
/*      */ 
/*  858 */     LNPPolDB reLNPPolDB = new LNPPolDB();
/*  859 */     reLNPPolDB.setPolNo(polNo);
/*  860 */     reLNPPolDB.getInfo();
/*  861 */     inPolElementSchema.setContNo(reLNPPolDB.getContNo());
/*  862 */     inPolElementSchema.setProposalContNo(reLNPPolDB.getProposalContNo());
/*  863 */     inPolElementSchema.setPolNo(reLNPPolDB.getPolNo());
/*  864 */     inPolElementSchema.setProposalNo(reLNPPolDB.getPolNo());
/*  865 */     inPolElementSchema.setMasterPolNo(reLNPPolDB.getMasterPolNo());
/*      */ 
/*  868 */     LNPAppntDB reLNPAppntDB = new LNPAppntDB();
/*      */ 
/*  870 */     reLNPAppntDB.setContNo(reLNPPolDB.getContNo());
/*  871 */     if (reLNPAppntDB.getInfo())
/*      */     {
/*  873 */       inPolElementSchema.setAppntAge(reLNPAppntDB.getAppntAge());
/*  874 */       inPolElementSchema.setAppntAgeType(reLNPAppntDB.getAppntAgeType());
/*  875 */       inPolElementSchema.setAppntNo(reLNPAppntDB.getAppntNo());
/*  876 */       inPolElementSchema.setAppntId(reLNPAppntDB.getAppntId());
/*  877 */       inPolElementSchema.setAppntSex(reLNPAppntDB.getAppntSex());
/*  878 */       inPolElementSchema.setAppntOccupationCode(reLNPAppntDB
/*  879 */         .getOccupationCode());
/*  880 */       inPolElementSchema
/*  881 */         .setAppntNativePlace(reLNPAppntDB.getNativePlace());
/*      */     }
/*      */ 
/*  885 */     LNPInsuredDB reLNPInsuredDB = new LNPInsuredDB();
/*  886 */     reLNPInsuredDB.setContNo(reLNPPolDB.getContNo());
/*  887 */     reLNPInsuredDB.setInsuredId(reLNPPolDB.getInsuredId());
/*  888 */     if (reLNPInsuredDB.getInfo()) {
/*  889 */       inPolElementSchema.setInsuredNo(reLNPInsuredDB.getInsuredNo());
/*  890 */       inPolElementSchema.setInsuredId(reLNPInsuredDB.getInsuredId());
/*  891 */       inPolElementSchema.setName(reLNPInsuredDB.getName());
/*  892 */       inPolElementSchema.setAppAge(reLNPInsuredDB.getAppAge());
/*  893 */       inPolElementSchema.setAppAgeType(reLNPInsuredDB.getAppAgeType());
/*  894 */       inPolElementSchema.setSex(reLNPInsuredDB.getSex());
/*  895 */       inPolElementSchema.setBirthday(reLNPInsuredDB.getBirthday());
/*  896 */       inPolElementSchema.setOccupationCode(reLNPInsuredDB
/*  897 */         .getOccupationCode());
/*  898 */       inPolElementSchema.setInsuredNativePlace(reLNPInsuredDB
/*  899 */         .getNationality());
/*      */ 
/*  901 */       inPolElementSchema.setRelationToAppnt(reLNPInsuredDB
/*  902 */         .getRelationToAppnt());
/*      */     }
/*      */ 
/*  905 */     inPolElementSchema.setRiskCode(reLNPPolDB.getRiskCode());
/*  906 */     inPolElementSchema.setAmnt(reLNPPolDB.getAmnt());
/*      */ 
/*  908 */     inPolElementSchema.setDeadAmntType(reLNPPolDB.getDeadAmntType());
/*  909 */     inPolElementSchema.setTopUpPrem(reLNPPolDB.getTopUpPrem());
/*      */ 
/*  911 */     inPolElementSchema.setPrem(reLNPPolDB.getPrem());
/*  912 */     inPolElementSchema.setMult(reLNPPolDB.getMult());
/*  913 */     inPolElementSchema.setBonusGetMode(reLNPPolDB.getBonusGetMode());
/*  914 */     inPolElementSchema.setGet(reLNPPolDB.getAmnt());
/*  915 */     inPolElementSchema.setLiveGetMode(reLNPPolDB.getLiveGetMode());
/*  916 */     inPolElementSchema.setGetYear(reLNPPolDB.getGetYear());
/*  917 */     inPolElementSchema.setGetYearFlag(reLNPPolDB.getGetYearFlag());
/*  918 */     inPolElementSchema.setInsuYear(reLNPPolDB.getInsuYear());
/*  919 */     inPolElementSchema.setInsuYearFlag(reLNPPolDB.getInsuYearFlag());
/*  920 */     inPolElementSchema.setPayEndYear(reLNPPolDB.getPayEndYear());
/*  921 */     inPolElementSchema.setPayEndYearFlag(reLNPPolDB.getPayEndYearFlag());
/*  922 */     inPolElementSchema.setPayIntv(reLNPPolDB.getPayIntv());
/*  923 */     inPolElementSchema.setStandbyFlag1(reLNPPolDB.getStandbyFlag1());
/*  924 */     inPolElementSchema.setStandbyFlag2(reLNPPolDB.getStandbyFlag2());
/*  925 */     inPolElementSchema.setStandbyFlag3(reLNPPolDB.getStandbyFlag3());
/*  926 */     inPolElementSchema.setSubRiskFlag(reLNPPolDB.getSubFlag());
/*  927 */     inPolElementSchema.setPolNo(reLNPPolDB.getPolNo());
/*  928 */     inPolElementSchema.setMainPolNo(reLNPPolDB.getMainPolNo());
/*      */ 
/*  930 */     inPolElementSchema.setYears(reLNPPolDB.getYears());
/*  931 */     inPolElementSchema.setPayYears(reLNPPolDB.getPayYears());
/*      */ 
/*  933 */     inPolElementSchema.setStandardPrem(reLNPPolDB.getStandPrem());
/*      */ 
/*  936 */     inPolElementSchema = calSumRiskAmnt(inPolElementSchema);
/*      */ 
/*  938 */     return inPolElementSchema;
/*      */   }
/*      */ 
/*      */   private boolean check(String sql, ExeSQL exeSQL)
/*      */   {
/*  943 */     boolean flag = true;
/*  944 */     String result = exeSQL.getOneValue(sql);
/*  945 */     if ((result != null) && (!result.equals("0")) && (!result.equals("null")) && 
/*  946 */       (!result.equals("")))
/*      */     {
/*  948 */       flag = false;
/*      */     }
/*  950 */     return flag;
/*      */   }
/*      */ 
/*      */   private String transportExpression(String oriStr, PolElementSchema inPolElementSchema)
/*      */   {
/*  956 */     if ((oriStr == null) || (oriStr.length() == 0)) {
/*  957 */       return "";
/*      */     }
/*  959 */     oriStr = StrTool.replace(oriStr, "?InsuredNo?", inPolElementSchema
/*  960 */       .getInsuredNo());
/*  961 */     oriStr = StrTool.replace(oriStr, "?InsuredId?", inPolElementSchema
/*  962 */       .getInsuredId());
/*  963 */     oriStr = 
/*  964 */       StrTool.replace(oriStr, "?Name?", inPolElementSchema.getName());
/*  965 */     oriStr = StrTool.replace(oriStr, "?Sex?", inPolElementSchema.getSex());
/*  966 */     oriStr = StrTool.replace(oriStr, "?Birthday?", inPolElementSchema
/*  967 */       .getBirthday());
/*  968 */     oriStr = StrTool.replace(oriStr, "?OccupationCode?", inPolElementSchema
/*  969 */       .getOccupationCode());
/*  970 */     oriStr = StrTool.replace(oriStr, "?AppAge?", inPolElementSchema
/*  971 */       .getAppAge());
/*      */ 
/*  973 */     oriStr = StrTool.replace(oriStr, "?AppAgeType?", inPolElementSchema
/*  974 */       .getAppAgeType());
/*      */ 
/*  976 */     oriStr = StrTool.replace(oriStr, "?RelationToAppnt?", 
/*  977 */       inPolElementSchema.getRelationToAppnt());
/*  978 */     oriStr = StrTool.replace(oriStr, "?InsuredNativePlace?", 
/*  979 */       inPolElementSchema.getInsuredNativePlace());
/*  980 */     oriStr = StrTool.replace(oriStr, "?InsuredNo2?", inPolElementSchema
/*  981 */       .getInsuredNo2());
/*  982 */     oriStr = StrTool.replace(oriStr, "?AppAge2Type?", inPolElementSchema
/*  983 */       .getAppAge2Type());
/*  984 */     oriStr = StrTool.replace(oriStr, "?AppAge2?", inPolElementSchema
/*  985 */       .getAppAge2());
/*  986 */     oriStr = StrTool.replace(oriStr, "?AppntNo?", inPolElementSchema
/*  987 */       .getAppntNo());
/*  988 */     oriStr = StrTool.replace(oriStr, "?AppntId?", inPolElementSchema
/*  989 */       .getAppntId());
/*  990 */     oriStr = StrTool.replace(oriStr, "?AppntNativePlace?", 
/*  991 */       inPolElementSchema.getAppntNativePlace());
/*  992 */     oriStr = StrTool.replace(oriStr, "?AppntOccupationCode?", 
/*  993 */       inPolElementSchema.getAppntOccupationCode());
/*  994 */     oriStr = StrTool.replace(oriStr, "?AppntAge?", inPolElementSchema
/*  995 */       .getAppntAge());
/*      */ 
/*  997 */     oriStr = StrTool.replace(oriStr, "?AppntAgeType?", inPolElementSchema
/*  998 */       .getAppntAgeType());
/*      */ 
/* 1000 */     oriStr = StrTool.replace(oriStr, "?AppntSex?", inPolElementSchema
/* 1001 */       .getAppntSex());
/* 1002 */     oriStr = StrTool.replace(oriStr, "?RiskChannel?", inPolElementSchema
/* 1003 */       .getRiskChannel());
/* 1004 */     oriStr = StrTool.replace(oriStr, "?ManageCom?", inPolElementSchema
/* 1005 */       .getManageCom());
/* 1006 */     oriStr = StrTool.replace(oriStr, "?MainPolNo?", inPolElementSchema
/* 1007 */       .getMainPolNo());
/* 1008 */     oriStr = StrTool.replace(oriStr, "?MasterPolNo?", inPolElementSchema
/* 1009 */       .getMasterPolNo());
/* 1010 */     oriStr = StrTool.replace(oriStr, "?MainPolAmnt?", inPolElementSchema
/* 1011 */       .getMainPolAmnt());
/* 1012 */     oriStr = StrTool.replace(oriStr, "?ContNo?", inPolElementSchema
/* 1013 */       .getContNo());
/* 1014 */     oriStr = StrTool.replace(oriStr, "?DutyCode?", inPolElementSchema
/* 1015 */       .getDutyCode());
/* 1016 */     oriStr = StrTool.replace(oriStr, "?RiskCode?", inPolElementSchema
/* 1017 */       .getRiskCode());
/* 1018 */     oriStr = StrTool.replace(oriStr, "?PolNo?", inPolElementSchema
/* 1019 */       .getPolNo());
/* 1020 */     oriStr = StrTool.replace(oriStr, "?Amnt?", inPolElementSchema.getAmnt());
/*      */ 
/* 1023 */     oriStr = StrTool.replace(oriStr, "?DeadAmntType?", inPolElementSchema.getDeadAmntType());
/*      */ 
/* 1025 */     oriStr = StrTool.replace(oriStr, "?TopUpPrem?", inPolElementSchema.getTopUpPrem());
/*      */ 
/* 1028 */     oriStr = StrTool.replace(oriStr, "?Get?", inPolElementSchema.getGet());
/*      */ 
/* 1030 */     oriStr = StrTool.replace(oriStr, "?Mult?", inPolElementSchema.getMult());
/*      */ 
/* 1032 */     oriStr = StrTool.replace(oriStr, "?Prem?", inPolElementSchema.getPrem());
/*      */ 
/* 1034 */     oriStr = StrTool.replace(oriStr, "?StandardPrem?", inPolElementSchema
/* 1035 */       .getStandardPrem());
/*      */ 
/* 1037 */     oriStr = StrTool.replace(oriStr, "?Vpu?", inPolElementSchema.getVPU());
/* 1038 */     oriStr = StrTool.replace(oriStr, "?PayEndYear?", inPolElementSchema
/* 1039 */       .getPayEndYear());
/*      */ 
/* 1041 */     oriStr = StrTool.replace(oriStr, "?PayEndYearFlag?", inPolElementSchema
/* 1042 */       .getPayEndYearFlag());
/* 1043 */     oriStr = StrTool.replace(oriStr, "?GetYear?", inPolElementSchema
/* 1044 */       .getGetYear());
/*      */ 
/* 1046 */     oriStr = StrTool.replace(oriStr, "?GetYearFlag?", inPolElementSchema
/* 1047 */       .getGetYearFlag());
/* 1048 */     oriStr = StrTool.replace(oriStr, "?InsuYear?", inPolElementSchema
/* 1049 */       .getInsuYear());
/*      */ 
/* 1051 */     oriStr = StrTool.replace(oriStr, "?InsuYearFlag?", inPolElementSchema
/* 1052 */       .getInsuYearFlag());
/* 1053 */     oriStr = StrTool.replace(oriStr, "?PayIntv?", inPolElementSchema
/* 1054 */       .getPayIntv());
/*      */ 
/* 1056 */     oriStr = StrTool.replace(oriStr, "?GetIntv?", inPolElementSchema
/* 1057 */       .getGetIntv());
/*      */ 
/* 1059 */     oriStr = StrTool.replace(oriStr, "?Years?", inPolElementSchema
/* 1060 */       .getYears());
/*      */ 
/* 1062 */     oriStr = StrTool.replace(oriStr, "?PayYears?", inPolElementSchema
/* 1063 */       .getPayYears());
/*      */ 
/* 1065 */     oriStr = StrTool.replace(oriStr, "?LiveGetMode?", inPolElementSchema
/* 1066 */       .getLiveGetMode());
/* 1067 */     oriStr = StrTool.replace(oriStr, "?SubRiskFlag?", inPolElementSchema
/* 1068 */       .getSubRiskFlag());
/* 1069 */     oriStr = StrTool.replace(oriStr, "?BonusGetMode?", inPolElementSchema
/* 1070 */       .getBonusGetMode());
/* 1071 */     oriStr = StrTool.replace(oriStr, "?StandByFlag1?", inPolElementSchema
/* 1072 */       .getStandbyFlag1());
/* 1073 */     oriStr = StrTool.replace(oriStr, "?StandByFlag2?", inPolElementSchema
/* 1074 */       .getStandbyFlag2());
/* 1075 */     oriStr = StrTool.replace(oriStr, "?StandByFlag3?", inPolElementSchema
/* 1076 */       .getStandbyFlag3());
/* 1077 */     oriStr = StrTool.replace(oriStr, "?RiskAmnt?", inPolElementSchema
/* 1078 */       .getRiskAmnt());
/*      */ 
/* 1080 */     oriStr = StrTool.replace(oriStr, "?SumLifeRiskAmnt?", 
/* 1081 */       inPolElementSchema.getSumLifeRiskAmnt());
/* 1082 */     oriStr = StrTool.replace(oriStr, "?SumAccRiskAmnt?", inPolElementSchema
/* 1083 */       .getSumAccRiskAmnt());
/*      */ 
/* 1085 */     oriStr = StrTool.replace(oriStr, "?SumDeaRiskAmnt?", inPolElementSchema
/* 1086 */       .getSumDeaRiskAmnt());
/*      */ 
/* 1088 */     oriStr = StrTool.replace(oriStr, "?SumDeaDutyRiskAmnt?", 
/* 1089 */       inPolElementSchema.getSumDeaDutyRiskAmnt());
/* 1090 */     oriStr = StrTool.replace(oriStr, "?SumBodRiskAmnt?", inPolElementSchema
/* 1091 */       .getSumBodRiskAmnt());
/*      */ 
/* 1093 */     return oriStr;
/*      */   }
/*      */ 
/*      */   private LNPRiskParamSchema getRelaRiskParamSchema(String riskcode, String type, List<LNPRiskParamSchema> list)
/*      */   {
/* 1099 */     LNPRiskParamSchema reLNPRiskParamSchema = null;
/* 1100 */     if ((list != null) && (list.size() > 0)) {
/* 1101 */       for (LNPRiskParamSchema tempLNPRiskParamSchema : list) {
/* 1102 */         if ((!type.equals(tempLNPRiskParamSchema.getParam())) || 
/* 1103 */           (!riskcode.equals(tempLNPRiskParamSchema.getRiskCode()))) continue;
/* 1104 */         reLNPRiskParamSchema = tempLNPRiskParamSchema;
/* 1105 */         break;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1110 */     return reLNPRiskParamSchema;
/*      */   }
/*      */ 
/*      */   private double getValueOfRiskAmntForOnePol(LNPRiskParamSchema inreLNPRiskParamSchema, String type, LNPPolSchema inLNPPolSchema)
/*      */   {
/* 1116 */     double result = 0.0D;
/* 1117 */     if (inreLNPRiskParamSchema != null)
/*      */     {
/* 1119 */       String expression = inreLNPRiskParamSchema.getExpression();
/*      */       try
/*      */       {
/* 1124 */         if ((inreLNPRiskParamSchema.getRemark() != null) && (!inreLNPRiskParamSchema.getRemark().trim().equals("")))
/*      */         {
/* 1126 */           LNPInsuredSchema tLNPInsuredSchema = new LNPInsuredSchema();
/* 1127 */           LNPInsuredDB LNPInsuredDB = new LNPInsuredDB();
/* 1128 */           LNPInsuredDB.setContNo(inLNPPolSchema.getContNo());
/* 1129 */           LNPInsuredDB.setInsuredId(inLNPPolSchema.getInsuredId());
/* 1130 */           tLNPInsuredSchema = LNPInsuredDB.query().get(1);
/*      */ 
/* 1132 */           String Remark = inreLNPRiskParamSchema.getRemark();
/* 1133 */           Remark = StrTool.replace(Remark, "?AppAge?", tLNPInsuredSchema.getAppAge());
/* 1134 */           Remark = StrTool.replace(Remark, "?AppAgeType?", tLNPInsuredSchema.getAppAgeType());
/* 1135 */           Remark = StrTool.replace(Remark, "?InsuYear?", "'" + inLNPPolSchema.getInsuYear() + "/" + inLNPPolSchema.getInsuYearFlag() + "'");
/* 1136 */           Remark = StrTool.replace(Remark, "?Sex?", "'" + tLNPInsuredSchema.getSex() + "'");
/* 1137 */           ExeSQL tExeSQL = new ExeSQL();
/* 1138 */           String bei = tExeSQL.getOneValue(Remark);
/* 1139 */           if (bei != null) {
/* 1140 */             expression = expression + "*" + bei;
/*      */           }
/*      */         }
/* 1143 */         String resultStr = calRiskAmntByExpress(expression, 
/* 1144 */           inLNPPolSchema);
/* 1145 */         if ((resultStr != null) && (!resultStr.equals("")))
/* 1146 */           result = Double.parseDouble(resultStr);
/*      */       }
/*      */       catch (Exception e) {
/* 1149 */         e.printStackTrace();
/*      */       }
/*      */     }
/*      */ 
/* 1153 */     return result;
/*      */   }
/*      */ 
/*      */   private PolElementSchema calSumRiskAmnt(PolElementSchema inPolElementSchema)
/*      */   {
/* 1159 */     LNPRiskParamDB reLNPRiskParasDB = new LNPRiskParamDB();
/* 1160 */     reLNPRiskParasDB.setType("RiskAmnt");
/* 1161 */     LNPRiskParamSet reLNPRiskParamSet = reLNPRiskParasDB.query();
/*      */ 
/* 1165 */     String sql = "select * from Lnppol where contNo='" + 
/* 1166 */       inPolElementSchema.getContNo() + "' and insuredId='" + 
/* 1167 */       inPolElementSchema.getInsuredId() + 
/* 1168 */       "' and MasterPolNo='" + inPolElementSchema.getMasterPolNo() + "'";
/* 1169 */     LNPPolDB reLNPPolDB = new LNPPolDB();
/* 1170 */     LNPPolSet reLNPPolSet = reLNPPolDB.executeQuery(sql);
/*      */ 
/* 1172 */     List lifeRiskAmntList = new ArrayList();
/* 1173 */     List accRiskAmntList = new ArrayList();
/* 1174 */     List deaRiskAmntList = new ArrayList();
/* 1175 */     List deaDutyRiskAmntList = new ArrayList();
/*      */ 
/* 1177 */     for (int i = 1; (reLNPRiskParamSet != null) && (i < reLNPRiskParamSet.size()); i++) {
/* 1178 */       LNPRiskParamSchema tempLNPRiskParamSchema = reLNPRiskParamSet.get(i);
/* 1179 */       String param = tempLNPRiskParamSchema.getParam();
/* 1180 */       if ("Life".equals(param))
/* 1181 */         lifeRiskAmntList.add(tempLNPRiskParamSchema);
/* 1182 */       else if ("Acc".equals(param))
/* 1183 */         accRiskAmntList.add(tempLNPRiskParamSchema);
/* 1184 */       else if ("Dea".equals(param))
/* 1185 */         deaRiskAmntList.add(tempLNPRiskParamSchema);
/* 1186 */       else if ("DeaDuty".equals(param)) {
/* 1187 */         deaDutyRiskAmntList.add(tempLNPRiskParamSchema);
/*      */       }
/*      */     }
/*      */ 
/* 1191 */     double lifeRiskAmnt = 0.0D;
/* 1192 */     double accRiskAmnt = 0.0D;
/* 1193 */     double deaRiskAmnt = 0.0D;
/* 1194 */     double deaDutyRiskAmnt = 0.0D;
/*      */ 
/* 1196 */     for (int i = 1; (reLNPPolSet != null) && (i <= reLNPPolSet.size()); i++) {
/* 1197 */       LNPPolSchema teLNPPolSchema = reLNPPolSet.get(i);
/*      */ 
/* 1200 */       String type = "Life";
/* 1201 */       LNPRiskParamSchema tempLNPRiskParamSchema = getRelaRiskParamSchema(
/* 1202 */         teLNPPolSchema.getRiskCode(), type, lifeRiskAmntList);
/* 1203 */       if (tempLNPRiskParamSchema != null) {
/* 1204 */         lifeRiskAmnt += getValueOfRiskAmntForOnePol(
/* 1205 */           tempLNPRiskParamSchema, type, teLNPPolSchema);
/*      */       }
/*      */ 
/* 1208 */       type = "Acc";
/* 1209 */       tempLNPRiskParamSchema = getRelaRiskParamSchema(teLNPPolSchema
/* 1210 */         .getRiskCode(), type, accRiskAmntList);
/* 1211 */       if (tempLNPRiskParamSchema != null) {
/* 1212 */         accRiskAmnt += getValueOfRiskAmntForOnePol(
/* 1213 */           tempLNPRiskParamSchema, type, teLNPPolSchema);
/*      */       }
/*      */ 
/* 1216 */       type = "Dea";
/* 1217 */       tempLNPRiskParamSchema = getRelaRiskParamSchema(teLNPPolSchema
/* 1218 */         .getRiskCode(), type, deaRiskAmntList);
/* 1219 */       if (tempLNPRiskParamSchema != null) {
/* 1220 */         deaRiskAmnt += getValueOfRiskAmntForOnePol(
/* 1221 */           tempLNPRiskParamSchema, type, teLNPPolSchema);
/*      */       }
/*      */ 
/* 1224 */       type = "DeaDuty";
/* 1225 */       tempLNPRiskParamSchema = getRelaRiskParamSchema(teLNPPolSchema
/* 1226 */         .getRiskCode(), type, deaDutyRiskAmntList);
/* 1227 */       if (tempLNPRiskParamSchema != null) {
/* 1228 */         deaDutyRiskAmnt += getValueOfRiskAmntForOnePol(
/* 1229 */           tempLNPRiskParamSchema, type, teLNPPolSchema);
/*      */       }
/*      */     }
/*      */ 
/* 1233 */     inPolElementSchema.setSumLifeRiskAmnt(lifeRiskAmnt);
/* 1234 */     inPolElementSchema.setSumAccRiskAmnt(accRiskAmnt);
/* 1235 */     inPolElementSchema.setSumDeaRiskAmnt(deaRiskAmnt);
/* 1236 */     inPolElementSchema.setSumDeaDutyRiskAmnt(deaDutyRiskAmnt);
/*      */ 
/* 1238 */     this.logger.info("Life:" + lifeRiskAmnt);
/* 1239 */     this.logger.info("Acc:" + accRiskAmnt);
/* 1240 */     this.logger.info("Dea:" + deaRiskAmnt);
/* 1241 */     this.logger.info("DeaDuty:" + deaDutyRiskAmnt);
/*      */ 
/* 1243 */     return inPolElementSchema;
/*      */   }
/*      */ 
/*      */   private String calRiskAmntByExpress(String expression, LNPPolSchema reLNPPolShcema)
/*      */   {
/* 1250 */     Hashtable reHashtable = new Hashtable();
/* 1251 */     reHashtable.put("ContNo", reLNPPolShcema.getContNo());
/* 1252 */     reHashtable.put("InsuredNo", reLNPPolShcema.getInsuredNo());
/* 1253 */     reHashtable.put("InsuredId", reLNPPolShcema.getInsuredId());
/* 1254 */     reHashtable.put("PolNo", reLNPPolShcema.getPolNo());
/* 1255 */     reHashtable.put("Amnt", Double.valueOf(reLNPPolShcema.getAmnt()));
/* 1256 */     reHashtable.put("Get", Double.valueOf(reLNPPolShcema.getAmnt()));
/* 1257 */     reHashtable.put("Prem", Double.valueOf(reLNPPolShcema.getPrem()));
/*      */ 
/* 1259 */     reHashtable.put("DeadAmntType", reLNPPolShcema.getDeadAmntType());
/* 1260 */     reHashtable.put("TopUpPrem", Double.valueOf(reLNPPolShcema.getTopUpPrem()));
/*      */ 
/* 1262 */     reHashtable.put("Mult", Double.valueOf(reLNPPolShcema.getMult()));
/* 1263 */     reHashtable.put("PayIntv", reLNPPolShcema.getPayIntv());
/* 1264 */     reHashtable.put("InsuYear", reLNPPolShcema.getInsuYear());
/* 1265 */     reHashtable.put("PayYears", reLNPPolShcema.getYears());
/* 1266 */     reHashtable.put("InsuYearFlag", reLNPPolShcema.getInsuYearFlag());
/* 1267 */     reHashtable.put("PayEndYear", reLNPPolShcema.getPayEndYear());
/* 1268 */     reHashtable.put("PayEndYearFlag", reLNPPolShcema.getPayEndYearFlag());
/*      */ 
/* 1270 */     reHashtable.put("LiveGetMode", reLNPPolShcema.getLiveGetMode());
/* 1271 */     reHashtable.put("StandbyFlag1", reLNPPolShcema.getStandbyFlag1());
/* 1272 */     reHashtable.put("StandbyFlag2", reLNPPolShcema.getStandbyFlag2());
/* 1273 */     reHashtable.put("StandbyFlag3", reLNPPolShcema.getStandbyFlag3());
/* 1274 */     reHashtable.put("SPCRiskRulesApi", this.calSpecialRulesElementsImpl);
/* 1275 */     String result = this.evalJavaTool.executeByExpress(expression, reHashtable);
/* 1276 */     return result;
/*      */   }
/*      */ 
/*      */   public CalSpecialRulesElementsImpl getCalSpecialRulesElementsImpl()
/*      */   {
/* 1283 */     return this.calSpecialRulesElementsImpl;
/*      */   }
/*      */ 
/*      */   public void setCalSpecialRulesElementsImpl(CalSpecialRulesElementsImpl calSpecialRulesElementsImpl)
/*      */   {
/* 1289 */     this.calSpecialRulesElementsImpl = calSpecialRulesElementsImpl;
/*      */   }
/*      */ 
/*      */   public RiskPolImpl getRiskPolImpl()
/*      */   {
/* 1294 */     return this.riskPolImpl;
/*      */   }
/*      */ 
/*      */   public void setRiskPolImpl(RiskPolImpl riskPolImpl)
/*      */   {
/* 1299 */     this.riskPolImpl = riskPolImpl;
/*      */   }
/*      */ 
/*      */   public EvalJavaTool getEvalJavaTool()
/*      */   {
/* 1304 */     return this.evalJavaTool;
/*      */   }
/*      */ 
/*      */   public void setEvalJavaTool(EvalJavaTool evalJavaTool) {
/* 1308 */     this.evalJavaTool = evalJavaTool;
/*      */   }
/*      */ 
/*      */   public SugError checkOnePolBeforeCal(String contNo, IGlobalInput tGlobalInput)
/*      */   {
/* 1314 */     LNPInsuredDB reLNPInsuredDB = new LNPInsuredDB();
/* 1315 */     reLNPInsuredDB.setContNo(contNo);
/* 1316 */     LNPInsuredSet reLNPInsuredSet = reLNPInsuredDB.query();
/* 1317 */     SugError reSugError = new SugError();
/* 1318 */     for (int i = 1; (reLNPInsuredSet != null) && (i <= reLNPInsuredSet.size()); i++) {
/* 1319 */       LNPInsuredSchema reLNPInsuredSchema = reLNPInsuredSet.get(i);
/* 1320 */       SugError tempSugError = checkForOneInsuBeforeCal(contNo, reLNPInsuredSchema
/* 1321 */         .getInsuredId(), tGlobalInput, "BeforeCal");
/* 1322 */       if (tempSugError.hasError()) {
/* 1323 */         reSugError.addInsuError(
/* 1324 */           (InsuError)tempSugError
/* 1324 */           .getInsuErrorList().get(0));
/*      */       }
/*      */     }
/* 1327 */     LNPContSchema reLNPContSchema = new LNPContSchema();
/* 1328 */     reLNPContSchema.setContNo(contNo);
/* 1329 */     reSugError.setSugInfo(reLNPContSchema);
/* 1330 */     return reSugError;
/*      */   }
/*      */ 
/*      */   public SugError checkForOneInsuBeforeCal(String contNo, String insuredId, IGlobalInput tGlobalInput, String flag)
/*      */   {
/* 1336 */     String sql = "select * from lnppol where polno=masterpolno and contNo='" + 
/* 1337 */       contNo + "' and insuredId='" + insuredId + "'";
/* 1338 */     LNPPolDB reLNPPolDB = new LNPPolDB();
/* 1339 */     LNPPolSet reLNPPolSet = reLNPPolDB.executeQuery(sql);
/* 1340 */     SugError reSugError = new SugError();
/* 1341 */     for (int i = 1; (reLNPPolSet != null) && (i <= reLNPPolSet.size()); i++) {
/* 1342 */       LNPPolSchema tLNPPolSchema = reLNPPolSet.get(i);
/* 1343 */       SugError tempSugError = checkForOnePolBeforeCal(tLNPPolSchema.getPolNo(), 
/* 1344 */         tGlobalInput, flag);
/* 1345 */       if (tempSugError.hasError()) {
/* 1346 */         if (reSugError.hasError()) {
/* 1347 */           InsuError insuError = 
/* 1348 */             (InsuError)reSugError
/* 1348 */             .getInsuErrorList().get(0);
/* 1349 */           List riskError = 
/* 1350 */             ((InsuError)tempSugError
/* 1350 */             .getInsuErrorList().get(0)).getRiskErrorList();
/* 1351 */           int j = 0;
/*      */           do { insuError.addRiskError((RiskError)riskError.get(j));
/*      */ 
/* 1351 */             j++; if (riskError == null) break;  }
/* 1351 */           while (j < riskError.size());
/*      */         }
/*      */         else {
/* 1354 */           InsuError insuError = 
/* 1355 */             (InsuError)tempSugError
/* 1355 */             .getInsuErrorList().get(0);
/* 1356 */           reSugError.addInsuError(insuError);
/*      */         }
/*      */       }
/*      */     }
/* 1360 */     LNPContSchema reLNPContSchema = new LNPContSchema();
/* 1361 */     reLNPContSchema.setContNo(contNo);
/* 1362 */     reSugError.setSugInfo(reLNPContSchema);
/* 1363 */     return reSugError;
/*      */   }
/*      */ 
/*      */   public SugError checkForOnePolBeforeCal(String mainPolNo, IGlobalInput tGlobalInput, String flagStr)
/*      */   {
/* 1369 */     List list = this.riskPolImpl.getPolList(mainPolNo, 1);
/* 1370 */     List polList = (List)list.get(1);
/* 1371 */     SugError reSugError = new SugError();
/* 1372 */     InsuError reInsuError = new InsuError();
/* 1373 */     String contNO = "";
/* 1374 */     boolean flag = true;
/* 1375 */     for (int i = 0; (polList != null) && (i < polList.size()); i++) {
/* 1376 */       LNPPolSchema remLNPPolSchema = (LNPPolSchema)polList.get(i);
/* 1377 */       contNO = remLNPPolSchema.getContNo();
/* 1378 */       PolElementSchema rePolElementSchema = initPolElementSchemaInfo(
/* 1379 */         remLNPPolSchema.getPolNo(), tGlobalInput);
/*      */ 
/* 1383 */       rePolElementSchema = calSumRiskAmnt(rePolElementSchema);
/*      */ 
/* 1386 */       List reusltList = new ArrayList();
/*      */ 
/* 1388 */       List list_1 = checkSexAndAge(rePolElementSchema);
/*      */ 
/* 1393 */       RiskError reRiskError = new RiskError();
/*      */ 
/* 1397 */       if ((list_1 != null) && (list_1.size() > 0)) {
/* 1398 */         reusltList.addAll(list_1);
/*      */       }
/*      */ 
/* 1414 */       if ("BeforeCal".equals(flagStr)) {
/* 1415 */         List list_6 = finalCheckForALlBeforeCal(rePolElementSchema);
/* 1416 */         if ((list_6 != null) && (list_6.size() > 0)) {
/* 1417 */           reusltList.addAll(list_6);
/*      */         }
/*      */       }
/*      */ 
/* 1421 */       if ((reusltList != null) && (reusltList.size() > 0)) {
/* 1422 */         reRiskError.setRiskInfo(rePolElementSchema.getRiskCode());
/* 1423 */         reRiskError.addError(reusltList);
/*      */ 
/* 1425 */         reInsuError.setInsuInfo(rePolElementSchema.getContNo(), 
/* 1426 */           rePolElementSchema.getInsuredId());
/* 1427 */         reInsuError.addRiskError(reRiskError);
/* 1428 */         flag = false;
/*      */       }
/*      */     }
/* 1431 */     if (!flag) {
/* 1432 */       LNPContSchema reLNPContSchema = new LNPContSchema();
/* 1433 */       reLNPContSchema.setContNo(contNO);
/* 1434 */       reSugError.setSugInfo(reLNPContSchema);
/* 1435 */       reSugError.addInsuError(reInsuError);
/*      */     }
/*      */ 
/* 1438 */     return reSugError;
/*      */   }
/*      */ 
/*      */   private List finalCheckForALlBeforeCal(PolElementSchema inPolElementSchema)
/*      */   {
/* 1443 */     List errorList = new ArrayList();
/* 1444 */     LNPCheckFieldSchema tempLNPCheckFieldSchema = null;
/* 1445 */     ExeSQL tempExeSQL = new ExeSQL();
/* 1446 */     LNPCheckFieldDB tLNPCheckFieldDB = new LNPCheckFieldDB();
/* 1447 */     String sql = "select * from lNPcheckField where riskcode='000000' and fieldname='BeforeCal' and (location='" + 
/* 1448 */       inPolElementSchema.getRiskChannel() + 
/* 1449 */       "' or location is null) order by SerialNo";
/* 1450 */     LNPCheckFieldSet tLNPCheckFieldSet = tLNPCheckFieldDB.executeQuery(sql);
/* 1451 */     if (tLNPCheckFieldSet.size() > 0) {
/* 1452 */       tempLNPCheckFieldSchema = null;
/*      */ 
/* 1454 */       for (int i = 1; i <= tLNPCheckFieldSet.size(); i++) {
/* 1455 */         tempLNPCheckFieldSchema = tLNPCheckFieldSet.get(i);
/* 1456 */         LNPCalModeDB tLNPCalModeDB = new LNPCalModeDB();
/* 1457 */         tLNPCalModeDB.setCalCode(tempLNPCheckFieldSchema.getCalCode());
/* 1458 */         if (!tLNPCalModeDB.getInfo()) {
/*      */           continue;
/*      */         }
/* 1461 */         String tempsql = tLNPCalModeDB.getCalSQL();
/* 1462 */         tempsql = transportExpression(tempsql, inPolElementSchema);
/* 1463 */         if (!check(tempsql, tempExeSQL)) {
/* 1464 */           errorList.add(tempLNPCheckFieldSchema.getMsg());
/*      */         }
/*      */       }
/*      */     }
/* 1468 */     return errorList;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.RiskCheckCenterImpl
 * JD-Core Version:    0.6.0
 */