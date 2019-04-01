/*      */ package com.sinosoft.banklns.lnsmodel;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPAppntDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPInsuredDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPOccupationDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPUWQuestionDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
/*      */ import com.sinosoft.banklns.lis.pubfun.LNPPubFun;
/*      */ import com.sinosoft.banklns.lis.pubfun.MMap;
/*      */ import com.sinosoft.banklns.lis.pubfun.PubFun;
/*      */ import com.sinosoft.banklns.lis.pubfun.PubSubmit;
/*      */ import com.sinosoft.banklns.lis.pubfun.SysMaxNoMAPNP;
/*      */ import com.sinosoft.banklns.lis.pubfun.ValidateTools;
/*      */ import com.sinosoft.banklns.lis.schema.LNPAddressSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPAppntSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPInsuredSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPPersonSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPAppntSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPUWQuestionSet;
/*      */ import com.sinosoft.banklns.utility.ExeSQL;
/*      */ import com.sinosoft.banklns.utility.Reflections;
/*      */ import com.sinosoft.banklns.utility.SSRS;
/*      */ import com.sinosoft.banklns.utility.VData;
/*      */ import java.io.PrintStream;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import javax.faces.context.ExternalContext;
/*      */ import javax.faces.context.FacesContext;
/*      */ import javax.faces.model.SelectItem;
/*      */ import javax.servlet.http.HttpSession;
/*      */ 
/*      */ public class AppntPersonInfo
/*      */ {
/*      */   private boolean editFlag;
/*   38 */   private boolean operateResult = true;
/*      */ 
/*   40 */   private boolean hasUnderWrite = false;
/*      */   private IGlobalInput tempGI;
/*      */   private LNPContSchema contSch;
/*      */   private String message;
/*      */   private String infoSource;
/*      */   private String contNo;
/*      */   private String appntId;
/*      */   private String insuredId;
/*      */   private String relationToInsured;
/*   58 */   private String connectionWithInsuranceHidden = null;
/*   59 */   private String nameHidden = null;
/*   60 */   private String birthdayHidden = null;
/*   61 */   private String occupationCodeHidden = null;
/*      */   private boolean renderFlag;
/*      */   private LNPAppntSchema appntSchema;
/*      */   private LNPPersonSchema lnpPersonSchema;
/*      */   private LNPAddressSchema lnpAddressSchema;
/*   70 */   private String age = "";
/*      */   private String sex;
/*      */   private String marriage;
/*      */   private String appntNative;
/*      */   private String idType;
/*      */   private String idPerpetual;
/*   77 */   private List<SelectItem> appntRelationtoinsuredList = new ArrayList();
/*      */   private String occupationCode;
/*      */   private String occupationName;
/*   84 */   private String insuCity = "";
/*      */ 
/*   86 */   private String insuOtherCity = "";
/*      */   private String connectionWithInsurance;
/*      */   private boolean showMessageFlag;
/*      */   private String reAge;
/*      */ 
/*      */   public void initData()
/*      */   {
/*   97 */     System.out.println(" -- appntpersoninfo initData start-- ");
/*      */ 
/*   99 */     HttpSession session = (HttpSession)FacesContext.getCurrentInstance()
/*  100 */       .getExternalContext().getSession(true);
/*      */     try
/*      */     {
/*  104 */       this.tempGI = ((IGlobalInput)session.getValue("NPGI"));
/*  105 */       if (((String)session.getAttribute("ContNo") != null) && 
/*  106 */         (!((String)session.getAttribute("ContNo")).equals("")))
/*      */       {
/*  108 */         this.contNo = ((String)session.getAttribute("ContNo"));
/*      */ 
/*  110 */         PolicyMainInfo mainInfo = new PolicyMainInfo();
/*  111 */         this.contSch = mainInfo.getContByContNo(this.contNo);
/*  112 */         this.appntSchema = new LNPAppntSchema();
/*  113 */         this.occupationName = getOccupName(this.appntSchema.getOccupationCode());
/*  114 */         this.lnpPersonSchema = new LNPPersonSchema();
/*  115 */         this.lnpAddressSchema = new LNPAddressSchema();
/*      */ 
/*  117 */         String myAppntId = this.contSch.getAppntId();
/*  118 */         this.insuredId = this.contSch.getInsuredId();
/*  119 */         this.appntId = this.contSch.getAppntId();
/*  120 */         this.sex = this.appntSchema.getAppntSex();
/*  121 */         this.marriage = this.appntSchema.getMarriage();
/*  122 */         this.idType = "1";
/*  123 */         this.age = "";
/*  124 */         this.appntNative = "";
/*      */ 
/*  126 */         if ((myAppntId != null) && (!myAppntId.equals(""))) {
/*  127 */           initAppntExist();
/*  128 */           this.infoSource = "modify";
/*      */         }
/*      */         else
/*      */         {
/*  132 */           this.infoSource = "add";
/*  133 */           System.out.println("\uFFFD\uFFFD\uFFFD\uFFFD\u0376\uFFFD\uFFFD\uFFFD\uFFFD");
/*      */         }
/*      */       } else {
/*  136 */         this.infoSource = "undo";
/*  137 */         this.operateResult = false;
/*  138 */         this.message = "\u4FDD\u5355\u53F7\u3001\u6295\u4FDD\u4EBAID\u4FE1\u606F\u4E22\u5931";
/*      */       }
/*      */ 
/*  141 */       Boolean getEditFlag = (Boolean)session.getAttribute("editFlag");
/*  142 */       if ((getEditFlag != null) && (!getEditFlag.booleanValue())) {
/*  143 */         this.infoSource = "undo";
/*  144 */         this.editFlag = false;
/*      */       } else {
/*  146 */         this.editFlag = true;
/*      */       }
/*      */     }
/*      */     catch (RuntimeException e) {
/*  150 */       e.printStackTrace();
/*  151 */       this.infoSource = "undo";
/*  152 */       this.operateResult = false;
/*  153 */       this.message = "\u4FDD\u5355\u53F7\u3001\u6295\u4FDD\u4EBAID\u4FE1\u606F\u4E22\u5931";
/*      */     }
/*      */ 
/*  156 */     System.out.println(" -- appntpersoninfo initData end-- ");
/*      */   }
/*      */ 
/*      */   private String getOccupName(String occcode)
/*      */   {
/*  161 */     String reName = "";
/*  162 */     if (occcode != null) {
/*  163 */       LNPOccupationDB occDB = new LNPOccupationDB();
/*  164 */       occDB.setOccupationCode(occcode);
/*  165 */       if (occDB.getInfo()) {
/*  166 */         reName = occDB.getOccupationName();
/*      */       }
/*      */     }
/*  169 */     return reName;
/*      */   }
/*      */ 
/*      */   public void setconnectionWithInsuranceSelf()
/*      */   {
/*  175 */     if (getConnectionWithInsurance().equals("0"))
/*      */     {
/*  177 */       if ((this.insuredId != null) && (!this.insuredId.equals("")))
/*      */       {
/*  179 */         initAppntByInsuredId(this.insuredId);
/*      */ 
/*  181 */         System.out.println("--" + this.appntSchema.getAppntName());
/*      */       }
/*      */       else {
/*  184 */         initAppnt();
/*      */       }
/*      */     }
/*  187 */     else if (this.connectionWithInsurance.equals(this.relationToInsured))
/*      */     {
/*  189 */       initAppntExist();
/*      */     }
/*  191 */     else initAppnt();
/*      */   }
/*      */ 
/*      */   public void validateConnection()
/*      */   {
/*  198 */     this.showMessageFlag = false;
/*      */ 
/*  200 */     if (!checkConn(this.connectionWithInsurance))
/*      */     {
/*  203 */       this.showMessageFlag = true;
/*  204 */       this.message = "\u9700\u63D0\u4F9B\u4E66\u9762\u8BF4\u660E";
/*      */     }
/*      */   }
/*      */ 
/*      */   public boolean isShowMessageFlag() {
/*  209 */     return this.showMessageFlag;
/*      */   }
/*      */ 
/*      */   public void setShowMessageFlag(boolean showMessageFlag) {
/*  213 */     this.showMessageFlag = showMessageFlag;
/*      */   }
/*      */ 
/*      */   private boolean checkConn(String connectionWithInsurance) {
/*  217 */     boolean reflag = false;
/*      */ 
/*  219 */     String sql = "select * from lnpcode where codetype='appntrelationtoinsured' and othersign='1'and code ='" + 
/*  220 */       connectionWithInsurance + "';";
/*      */ 
/*  222 */     ExeSQL tExeSQL = new ExeSQL();
/*  223 */     SSRS tSSRS = null;
/*  224 */     tSSRS = tExeSQL.execSQL(sql);
/*      */ 
/*  226 */     if ((tSSRS != null) && (tSSRS.MaxRow > 0)) {
/*  227 */       reflag = true;
/*      */     }
/*  229 */     return reflag;
/*      */   }
/*      */ 
/*      */   private void initAppntExist() {
/*  233 */     System.out.println("-- initAppntExist --");
/*  234 */     PersonFunction pf = new PersonFunction();
/*  235 */     this.appntSchema = getOneAppntPersonInfo(this.contSch.getContNo(), this.contSch.getAppntId());
/*  236 */     this.occupationName = getOccupName(this.appntSchema.getOccupationCode());
/*  237 */     this.lnpPersonSchema = pf.getLnpPersonByCustomerId(this.contSch.getAppntId());
/*  238 */     this.lnpAddressSchema = pf.getLnpAddrByCustomerId(this.contSch.getAppntId());
/*  239 */     this.relationToInsured = this.appntSchema.getRelationToInsured();
/*  240 */     this.connectionWithInsurance = this.appntSchema
/*  241 */       .getRelationToInsured();
/*  242 */     this.sex = this.appntSchema.getAppntSex();
/*  243 */     this.marriage = this.appntSchema.getMarriage();
/*  244 */     this.appntNative = this.appntSchema.getNativePlace();
/*  245 */     this.idType = this.appntSchema.getIDType();
/*  246 */     this.idPerpetual = this.appntSchema.getIDPerpetual();
/*  247 */     this.insuCity = this.lnpAddressSchema.getDuchy();
/*  248 */     this.insuOtherCity = this.lnpAddressSchema.getOtherDuchy();
/*      */ 
/*  250 */     this.connectionWithInsuranceHidden = this.appntSchema.getRelationToInsured();
/*  251 */     this.nameHidden = this.appntSchema.getAppntName();
/*  252 */     this.birthdayHidden = this.appntSchema.getAppntBirthday();
/*  253 */     this.occupationCodeHidden = this.appntSchema.getOccupationCode();
/*      */ 
/*  257 */     if ("2".equals(this.contSch.getUWFlag()))
/*  258 */       this.hasUnderWrite = true;
/*      */     else {
/*  260 */       this.hasUnderWrite = false;
/*      */     }
/*      */ 
/*  263 */     if ((this.appntSchema.getAppntBirthday() != null) && (!"".equals(this.appntSchema.getAppntBirthday()))) {
/*  264 */       this.age = LNPPubFun.getAgeByBirthdayNew(this.appntSchema.getAppntBirthday(), this.contSch.getPValiDate());
/*      */     }
/*  266 */     System.out.println("-- initAppntExist end--");
/*      */   }
/*      */ 
/*      */   private void initAppnt()
/*      */   {
/*  271 */     String tempid = this.appntSchema.getAppntId();
/*      */ 
/*  273 */     System.out.println("-- initAppnt tempid--" + tempid);
/*  274 */     this.appntSchema = new LNPAppntSchema();
/*  275 */     this.appntSchema.setAppntId(tempid);
/*  276 */     this.occupationName = "";
/*  277 */     System.out.println("-- initAppnt tempid--" + this.appntSchema.getAppntId());
/*  278 */     this.lnpPersonSchema = new LNPPersonSchema();
/*  279 */     this.lnpAddressSchema = new LNPAddressSchema();
/*      */ 
/*  281 */     this.sex = null;
/*  282 */     this.marriage = null;
/*  283 */     this.appntNative = "";
/*  284 */     this.idType = null;
/*  285 */     this.age = "";
/*  286 */     this.idPerpetual = "0";
/*  287 */     this.insuCity = "";
/*  288 */     this.insuOtherCity = "";
/*      */   }
/*      */ 
/*      */   private void initAppntByInsuredId(String insuredId) {
/*  292 */     System.out.println(" -- initAppntByInsuredId --");
/*  293 */     PersonFunction pf = new PersonFunction();
/*  294 */     LNPPersonSchema lnpPersonTemp = pf.getLnpPersonByCustomerId(insuredId);
/*      */ 
/*  297 */     this.appntSchema.setAppntName(lnpPersonTemp.getName());
/*  298 */     this.appntSchema.setAppntSex(lnpPersonTemp.getSex());
/*  299 */     this.appntSchema.setAppntBirthday(lnpPersonTemp.getBirthday());
/*  300 */     this.appntSchema.setIDType(lnpPersonTemp.getIDType());
/*  301 */     this.appntSchema.setIDNo(lnpPersonTemp.getIDNo());
/*  302 */     this.appntSchema.setNativePlace(lnpPersonTemp.getNativePlace());
/*  303 */     this.appntSchema.setMarriage(lnpPersonTemp.getMarriage());
/*  304 */     this.appntSchema.setOccupationCode(lnpPersonTemp.getOccupationCode());
/*      */ 
/*  306 */     this.appntSchema.setAppntAge(lnpPersonTemp.getAge());
/*  307 */     this.appntSchema.setIDPerpetual(lnpPersonTemp.getIDPerpetual());
/*  308 */     this.appntSchema.setIDValidity(lnpPersonTemp.getIDValidity());
/*      */ 
/*  310 */     this.lnpPersonSchema = new LNPPersonSchema();
/*  311 */     this.lnpAddressSchema = pf.getLnpAddrByCustomerId(insuredId);
/*      */ 
/*  313 */     this.occupationName = getOccupName(this.appntSchema.getOccupationCode());
/*  314 */     this.sex = this.appntSchema.getAppntSex();
/*  315 */     this.marriage = this.appntSchema.getMarriage();
/*  316 */     this.appntNative = this.appntSchema.getNativePlace();
/*  317 */     this.idType = this.appntSchema.getIDType();
/*  318 */     this.insuCity = this.lnpAddressSchema.getDuchy();
/*  319 */     this.insuOtherCity = this.lnpAddressSchema.getOtherDuchy();
/*      */ 
/*  323 */     if ((this.appntSchema.getAppntBirthday() != null) && (!"".equals(this.appntSchema.getAppntBirthday()))) {
/*  324 */       this.age = LNPPubFun.getAgeByBirthdayNew(this.appntSchema.getAppntBirthday(), this.contSch.getPValiDate());
/*      */     }
/*      */ 
/*  328 */     this.idPerpetual = this.appntSchema.getIDPerpetual();
/*      */ 
/*  330 */     System.out.println(" -- initAppntByInsuredId end--");
/*      */   }
/*      */ 
/*      */   public void saveOccupMenuNO()
/*      */   {
/*  335 */     HttpSession session = (HttpSession)FacesContext.getCurrentInstance()
/*  336 */       .getExternalContext().getSession(true);
/*  337 */     session.setAttribute("occupationName", "");
/*  338 */     session.setAttribute("occupationCode", "");
/*      */   }
/*      */ 
/*      */   public void cancleOccupSession()
/*      */   {
/*  344 */     HttpSession session = (HttpSession)FacesContext.getCurrentInstance()
/*  345 */       .getExternalContext().getSession(true);
/*  346 */     String occupationName = (String)session.getAttribute("occupationName");
/*  347 */     String occupationCode = (String)session.getAttribute("occupationCode");
/*      */ 
/*  349 */     if ((occupationName != null) && (!occupationName.equals("")))
/*  350 */       this.occupationName = occupationName;
/*      */     else {
/*  352 */       this.occupationName = "";
/*      */     }
/*  354 */     if ((occupationCode != null) && (!occupationCode.equals("")))
/*  355 */       this.appntSchema.setOccupationCode(occupationCode);
/*      */     else {
/*  357 */       this.appntSchema.setOccupationCode("");
/*      */     }
/*      */ 
/*  361 */     session.removeAttribute("occupationName");
/*  362 */     session.removeAttribute("occupationCode");
/*      */   }
/*      */ 
/*      */   public void reWriteOccupation()
/*      */   {
/*  367 */     this.appntSchema.setOccupationCode("");
/*  368 */     this.occupationName = "";
/*  369 */     String sql = "select occupationcode,occupationname from lnpoccupation where occupationcode='" + this.occupationCode + "';";
/*      */ 
/*  371 */     ExeSQL tExeSQL = new ExeSQL();
/*  372 */     SSRS tSSRS = tExeSQL.execSQL(sql);
/*      */ 
/*  374 */     System.out.println("sql--" + sql);
/*      */ 
/*  376 */     if (tSSRS.MaxRow > 0) {
/*  377 */       this.operateResult = false;
/*  378 */       this.appntSchema.setOccupationCode(tSSRS.GetText(1, 1));
/*  379 */       this.occupationName = tSSRS.GetText(1, 2);
/*      */     } else {
/*  381 */       this.operateResult = true;
/*      */ 
/*  383 */       this.message = "\u8BE5\u804C\u4E1A\u4EE3\u7801\u4E0D\u5B58\u5728\uFF01";
/*      */     }
/*      */   }
/*      */ 
/*      */   public void saveappntPeople() {
/*  388 */     this.message = null;
/*  389 */     this.operateResult = true;
/*      */ 
/*  391 */     if ((this.connectionWithInsurance == null) || (this.connectionWithInsurance.equals("-1"))) {
/*  392 */       this.message = "\u4E0E\u88AB\u4FDD\u4EBA\u5173\u7CFB\u4E0D\u80FD\u4E3A\u7A7A\uFF01";
/*  393 */       this.operateResult = false;
/*  394 */       return;
/*      */     }
/*      */ 
/*  397 */     if (this.infoSource.equals("undo")) {
/*  398 */       this.message = "\u6295\u4FDD\u4E66\u4FE1\u606F\u4E22\u5931\uFF01";
/*  399 */       this.operateResult = false;
/*  400 */       return;
/*      */     }
/*      */ 
/*  403 */     System.out.println("----  saveappntPeople start ------");
/*      */ 
/*  407 */     this.appntSchema.setNativePlace(getAppntNative());
/*  408 */     this.appntSchema.setAppntSex(getSex());
/*  409 */     this.appntSchema.setMarriage(getMarriage());
/*  410 */     this.appntSchema.setIDType(getIdType());
/*  411 */     this.appntSchema.setIDPerpetual(getIdPerpetual());
/*  412 */     this.appntSchema.setRelationToInsured(getConnectionWithInsurance());
/*      */ 
/*  415 */     if (("0".equals(this.appntSchema.getIDPerpetual())) && (this.appntSchema.getIDValidity() != null))
/*  416 */       this.appntSchema.setIDValidity(this.appntSchema.getIDValidity());
/*  417 */     else if ("1".equals(this.appntSchema.getIDPerpetual())) {
/*  418 */       this.appntSchema.setIDValidity("");
/*      */     }
/*      */ 
/*  422 */     String agePer = "";
/*  423 */     String ageType = "";
/*  424 */     agePer = LNPPubFun.getAgeByBirthdayNew(this.appntSchema.getAppntBirthday(), this.contSch.getPValiDate());
/*  425 */     this.age = agePer;
/*  426 */     if (agePer.indexOf("\u5929") > -1) {
/*  427 */       ageType = "D";
/*  428 */       agePer = agePer.substring(0, agePer.indexOf("\uFF08"));
/*      */     } else {
/*  430 */       ageType = "Y";
/*  431 */       agePer = agePer.substring(0, agePer.indexOf("\uFF08"));
/*      */     }
/*  433 */     this.appntSchema.setAppntAge(agePer);
/*  434 */     this.appntSchema.setAppntAgeType(ageType);
/*      */ 
/*  436 */     if (!validate()) {
/*  437 */       this.operateResult = false;
/*      */     }
/*      */     else {
/*  440 */       System.out.println("\uFFFD\uFFFD\u01F0\uFFFD\uFFFD\uFFFD\uFFFD---" + this.infoSource);
/*      */ 
/*  443 */       if (this.infoSource.equals("add")) {
/*  444 */         if (addAppntOfNewCustomer()) {
/*  445 */           this.message = "\u6295\u4FDD\u4EBA\u4FE1\u606F\u4FDD\u5B58\u6210\u529F\uFF01";
/*  446 */           this.operateResult = true;
/*      */         }
/*  448 */       } else if ((this.infoSource.equals("modify")) && 
/*  449 */         (modifyappntPeople())) {
/*  450 */         this.message = "\u6295\u4FDD\u4EBA\u4FE1\u606F\u4FDD\u5B58\u6210\u529F\uFF01";
/*  451 */         this.operateResult = true;
/*      */       }
/*      */     }
/*      */ 
/*  455 */     System.out.println("----  saveappntPeople end ------" + this.message);
/*      */   }
/*      */ 
/*      */   private LNPContSchema getMyLNPContByContNo(String contno)
/*      */   {
/*  463 */     PolicyMainInfo mainInfo = new PolicyMainInfo();
/*  464 */     LNPContSchema aLNPContSchema = mainInfo
/*  465 */       .getContByContNo(contno);
/*  466 */     return aLNPContSchema;
/*      */   }
/*      */ 
/*      */   public LNPAppntSchema getAppntPeopleByContNo(String contNo, String aAppntId)
/*      */   {
/*  472 */     LNPAppntDB lnpAppntredDB = new LNPAppntDB();
/*  473 */     LNPAppntSchema aLNPAppntSchema = new LNPAppntSchema();
/*  474 */     aLNPAppntSchema.setContNo(contNo);
/*  475 */     if (!aAppntId.equals("")) {
/*  476 */       aLNPAppntSchema.setAppntId(aAppntId);
/*      */     }
/*  478 */     lnpAppntredDB.setSchema(aLNPAppntSchema);
/*      */ 
/*  480 */     LNPAppntSet lnpAppntredSet = lnpAppntredDB.query();
/*      */ 
/*  482 */     if (lnpAppntredSet.size() > 0)
/*  483 */       aLNPAppntSchema = lnpAppntredSet.get(1);
/*      */     else {
/*  485 */       aLNPAppntSchema = null;
/*      */     }
/*  487 */     return aLNPAppntSchema;
/*      */   }
/*      */ 
/*      */   public List getAppntPeopleListByContNo(String aContNo)
/*      */   {
/*  494 */     LNPAppntDB lnpAppntredDB = new LNPAppntDB();
/*  495 */     lnpAppntredDB.setContNo(aContNo);
/*      */ 
/*  497 */     LNPAppntSet lnpAppntredSet = lnpAppntredDB.query();
/*  498 */     List list = new ArrayList();
/*  499 */     if (lnpAppntredSet.size() > 0) {
/*  500 */       list = new ArrayList();
/*  501 */       for (int i = 1; i < lnpAppntredSet.size(); i++) {
/*  502 */         LNPAppntSchema temp = lnpAppntredSet.get(i);
/*  503 */         list.add(temp);
/*      */       }
/*      */     }
/*      */ 
/*  507 */     return list;
/*      */   }
/*      */ 
/*      */   public LNPAppntSchema getOneAppntPersonInfo(String contNo, String appntId)
/*      */   {
/*  513 */     LNPAppntDB saveLSAppntredDB = new LNPAppntDB();
/*  514 */     saveLSAppntredDB.setContNo(contNo);
/*  515 */     saveLSAppntredDB.setAppntId(appntId);
/*  516 */     LNPAppntSet set = saveLSAppntredDB.query();
/*      */ 
/*  518 */     if (set.size() > 0) {
/*  519 */       return set.get(1);
/*      */     }
/*  521 */     return null;
/*      */   }
/*      */ 
/*      */   private boolean addAppntOfNewCustomer()
/*      */   {
/*  526 */     boolean flag = true;
/*  527 */     String date = PubFun.getCurrentDate();
/*  528 */     String time = PubFun.getCurrentTime();
/*      */ 
/*  530 */     LNPAppntSchema addAppntSch = new LNPAppntSchema();
/*  531 */     Reflections reflect = new Reflections();
/*  532 */     reflect.transFields(addAppntSch, this.appntSchema);
/*      */ 
/*  539 */     SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
/*  540 */     String appntid = maxNoMap.CreateMaxNo("CustomerNo", "");
/*      */ 
/*  543 */     addAppntSch.setAppntId(appntid);
/*  544 */     System.out.println("--- appntId --" + this.contNo + "--" + addAppntSch.getAppntId());
/*      */ 
/*  547 */     LNPContSchema lnpContSch = 
/*  548 */       getMyLNPContByContNo(this.contNo);
/*  549 */     addAppntSch.setGrpContNo(lnpContSch.getGrpContNo());
/*  550 */     addAppntSch.setPrtNo(lnpContSch.getPrtNo());
/*  551 */     addAppntSch.setContNo(lnpContSch.getContNo());
/*  552 */     addAppntSch.setProposalContNo(lnpContSch.getProposalContNo());
/*      */ 
/*  554 */     addAppntSch.setOperator(this.tempGI.Operator);
/*  555 */     addAppntSch.setMakeDate(date);
/*  556 */     addAppntSch.setMakeTime(time);
/*  557 */     addAppntSch.setModifyDate(date);
/*  558 */     addAppntSch.setModifyTime(time);
/*      */ 
/*  561 */     this.lnpPersonSchema.setAgentCode(addAppntSch.getOperator());
/*  562 */     this.lnpPersonSchema.setCustomerId(appntid);
/*  563 */     this.lnpPersonSchema.setName(addAppntSch.getAppntName());
/*  564 */     this.lnpPersonSchema.setSex(addAppntSch.getAppntSex());
/*  565 */     this.lnpPersonSchema.setBirthday(addAppntSch.getAppntBirthday());
/*  566 */     this.lnpPersonSchema.setIDType(addAppntSch.getIDType());
/*  567 */     this.lnpPersonSchema.setIDNo(addAppntSch.getIDNo());
/*  568 */     this.lnpPersonSchema.setNativePlace(addAppntSch.getNativePlace());
/*  569 */     this.lnpPersonSchema.setMarriage(addAppntSch.getMarriage());
/*  570 */     this.lnpPersonSchema.setOccupationCode(addAppntSch.getOccupationCode());
/*      */ 
/*  572 */     this.lnpPersonSchema.setAge(addAppntSch.getAppntAge());
/*  573 */     this.lnpPersonSchema.setAgeType(addAppntSch.getAppntAgeType());
/*  574 */     this.lnpPersonSchema.setIDPerpetual(addAppntSch.getIDPerpetual());
/*  575 */     this.lnpPersonSchema.setIDValidity(addAppntSch.getIDValidity());
/*      */ 
/*  577 */     this.lnpPersonSchema.setOperator(this.tempGI.Operator);
/*  578 */     this.lnpPersonSchema.setMakeDate(date);
/*  579 */     this.lnpPersonSchema.setMakeTime(time);
/*  580 */     this.lnpPersonSchema.setModifyDate(date);
/*  581 */     this.lnpPersonSchema.setModifyTime(time);
/*      */ 
/*  583 */     this.lnpAddressSchema.setAddressNo(maxNoMap.CreateMaxNo("LNPAddRNo", ""));
/*      */ 
/*  585 */     this.lnpAddressSchema.setCustomerId(appntid);
/*  586 */     this.lnpAddressSchema.setOperator(this.tempGI.Operator);
/*  587 */     this.lnpAddressSchema.setDuchy(getInsuCity());
/*  588 */     this.lnpAddressSchema.setOtherDuchy(getInsuOtherCity() != null ? getInsuOtherCity() : "");
/*  589 */     this.lnpAddressSchema.setMakeDate(date);
/*  590 */     this.lnpAddressSchema.setMakeTime(time);
/*  591 */     this.lnpAddressSchema.setModifyDate(date);
/*  592 */     this.lnpAddressSchema.setModifyTime(time);
/*      */ 
/*  595 */     addAppntSch.setAddressNo(this.lnpAddressSchema.getAddressNo());
/*      */ 
/*  598 */     lnpContSch.setAppntId(appntid);
/*  599 */     lnpContSch.setAppntNo(addAppntSch.getAppntNo());
/*  600 */     lnpContSch.setAppntName(addAppntSch.getAppntName());
/*  601 */     lnpContSch.setAppntBirthday(addAppntSch.getAppntBirthday());
/*  602 */     lnpContSch.setAppntIDType(addAppntSch.getIDType());
/*  603 */     lnpContSch.setAppntIDNo(addAppntSch.getIDNo());
/*      */ 
/*  605 */     if ((appntid == null) || ("".equals(appntid))) {
/*  606 */       this.message = "\u6295\u4FDD\u4EBA\u4FE1\u606F\u4FDD\u5B58\u9519\u8BEF\uFF01";
/*  607 */       flag = false;
/*  608 */       return false;
/*      */     }
/*      */ 
/*  611 */     StateOperatorDeal operatorDeal = new StateOperatorDeal();
/*  612 */     List stateList = operatorDeal.infoOperate(this.contSch.getState(), this.contSch.getEditstate(), this.infoSource, "03");
/*      */ 
/*  614 */     lnpContSch.setState((String)stateList.get(0));
/*  615 */     lnpContSch.setEditstate((String)stateList.get(1));
/*      */ 
/*  618 */     if ("2".equals(lnpContSch.getUWFlag())) {
/*  619 */       lnpContSch.setUWFlag("1");
/*      */     }
/*  621 */     lnpContSch.setModifyDate(date);
/*  622 */     lnpContSch.setModifyTime(time);
/*      */ 
/*  624 */     PubSubmit ps = new PubSubmit();
/*  625 */     MMap map = new MMap();
/*      */ 
/*  627 */     map.put(addAppntSch, "INSERT");
/*  628 */     map.put(this.lnpPersonSchema, "INSERT");
/*  629 */     map.put(this.lnpAddressSchema, "INSERT");
/*  630 */     map.put(lnpContSch, "UPDATE");
/*      */ 
/*  633 */     VData vd = new VData();
/*  634 */     vd.add(map);
/*  635 */     if (!ps.submitData(vd, "")) {
/*  636 */       System.out.println("-AppntPeopleInfo-\u63D2\u5165\u9519\u8BEF");
/*      */ 
/*  638 */       this.message = "\u6295\u4FDD\u4EBA\u4FE1\u606F\u4FDD\u5B58\u9519\u8BEF\uFF01";
/*      */ 
/*  640 */       flag = false;
/*      */     }
/*      */     else
/*      */     {
/*  644 */       String sql = "select * from lnpappnt where contno='" + addAppntSch.getContNo() + "'";
/*  645 */       LNPAppntDB adddb = new LNPAppntDB();
/*  646 */       LNPAppntSet addSet = adddb.executeQuery(sql);
/*      */ 
/*  649 */       if ((addSet != null) && (addSet.size() != 1)) {
/*  650 */         flag = true;
/*      */       } else {
/*  652 */         LNPAppntSchema tmp = addSet.get(1);
/*  653 */         if ((tmp.getAppntId() == null) || ("".equals(tmp.getAppntId().trim()))) {
/*  654 */           ExeSQL tExeSQL = new ExeSQL();
/*  655 */           String upSQL = "update lnppol set appntid='" + lnpContSch.getAppntId() + "' where contno='" + addAppntSch.getContNo() + "'";
/*  656 */           System.out.println(upSQL);
/*      */ 
/*  658 */           boolean updateflag = tExeSQL.execUpdateSQL(upSQL);
/*      */ 
/*  660 */           if (!updateflag) {
/*  661 */             System.out.println("-AppntPeopleInfo-\u63D2\u5165\u9519\u8BEF2");
/*  662 */             this.message = "\u6295\u4FDD\u4EBA\u4FE1\u606F\u4FDD\u5B58\u9519\u8BEF\uFF01";
/*      */           }
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*  668 */       reflect.transFields(this.appntSchema, addAppntSch);
/*  669 */       flag = true;
/*      */     }
/*  671 */     return flag;
/*      */   }
/*      */ 
/*      */   private boolean modifyappntPeople() {
/*  764 */     System.out.println("-- modifyappntPeople start --");
/*      */     boolean flag;
/*      */     try {
/*  768 */       boolean flag = false;
/*  769 */       String date = PubFun.getCurrentDate();
/*  770 */       String time = PubFun.getCurrentTime();
/*  771 */       String midifyAppntId = this.appntSchema.getAppntId();
/*      */ 
/*  773 */       PubSubmit ps = new PubSubmit();
/*  774 */       MMap map = new MMap();
/*  775 */       PersonFunction pf = new PersonFunction();
/*  776 */       StateOperatorDeal operatorDeal = new StateOperatorDeal();
/*      */ 
/*  778 */       LNPAppntSchema modifyAppntPeopleSchema = getAppntPeopleByContNo(
/*  779 */         this.contNo, "");
/*  780 */       LNPAppntSchema modifyAppntPeopleSchemaTemp = getAppntPeopleByContNo(
/*  781 */         this.contNo, "");
/*      */ 
/*  783 */       LNPAddressSchema modifylnpAddressSchema = pf
/*  784 */         .getLnpAddrByCustomerId(midifyAppntId);
/*  785 */       LNPPersonSchema modifylnpPersonSchema = pf.getLnpPersonByCustomerId(midifyAppntId);
/*      */ 
/*  787 */       LNPContSchema lnpContSch = getMyLNPContByContNo(this.contNo);
/*  788 */       if ((modifyAppntPeopleSchema != null) && 
/*  789 */         (modifylnpAddressSchema != null) && 
/*  790 */         (modifylnpPersonSchema != null))
/*      */       {
/*  792 */         modifyAppntPeopleSchema.setAppntName(this.appntSchema.getAppntName());
/*  793 */         modifyAppntPeopleSchema.setAppntSex(this.appntSchema.getAppntSex());
/*  794 */         modifyAppntPeopleSchema.setAppntBirthday(this.appntSchema.getAppntBirthday());
/*  795 */         modifyAppntPeopleSchema.setAppntAge(this.appntSchema.getAppntAge());
/*  796 */         modifyAppntPeopleSchema.setAppntAgeType(this.appntSchema.getAppntAgeType());
/*  797 */         modifyAppntPeopleSchema.setIDPerpetual(this.appntSchema.getIDPerpetual());
/*  798 */         modifyAppntPeopleSchema.setIDValidity(this.appntSchema.getIDValidity());
/*  799 */         modifyAppntPeopleSchema.setIDType(this.appntSchema.getIDType());
/*  800 */         modifyAppntPeopleSchema.setIDNo(this.appntSchema.getIDNo());
/*  801 */         modifyAppntPeopleSchema.setNativePlace(this.appntSchema.getNativePlace());
/*  802 */         modifyAppntPeopleSchema.setMarriage(this.appntSchema.getMarriage());
/*      */ 
/*  804 */         modifyAppntPeopleSchema.setOccupationCode(this.appntSchema.getOccupationCode());
/*  805 */         modifyAppntPeopleSchema.setModifyDate(date);
/*  806 */         modifyAppntPeopleSchema.setModifyTime(time);
/*  807 */         modifyAppntPeopleSchema.setAppntAge(this.appntSchema.getAppntAge());
/*  808 */         modifyAppntPeopleSchema.setRelationToInsured(this.connectionWithInsurance);
/*      */ 
/*  811 */         modifylnpPersonSchema.setName(modifyAppntPeopleSchema.getAppntName());
/*  812 */         modifylnpPersonSchema.setSex(modifyAppntPeopleSchema.getAppntSex());
/*  813 */         modifylnpPersonSchema.setBirthday(modifyAppntPeopleSchema.getAppntBirthday());
/*  814 */         modifylnpPersonSchema.setIDType(modifyAppntPeopleSchema.getIDType());
/*  815 */         modifylnpPersonSchema.setIDNo(modifyAppntPeopleSchema.getIDNo());
/*  816 */         modifylnpPersonSchema.setNativePlace(modifyAppntPeopleSchema.getNativePlace());
/*  817 */         modifylnpPersonSchema.setMarriage(modifyAppntPeopleSchema.getMarriage());
/*  818 */         modifylnpPersonSchema.setOccupationCode(modifyAppntPeopleSchema.getOccupationCode());
/*      */ 
/*  820 */         modifylnpPersonSchema.setAge(modifyAppntPeopleSchema.getAppntAge());
/*  821 */         modifylnpPersonSchema.setAgeType(modifyAppntPeopleSchema.getAppntAgeType());
/*  822 */         modifylnpPersonSchema.setIDPerpetual(modifyAppntPeopleSchema.getIDPerpetual());
/*  823 */         modifylnpPersonSchema.setIDValidity(modifyAppntPeopleSchema.getIDValidity());
/*      */ 
/*  825 */         modifylnpPersonSchema.setModifyDate(date);
/*  826 */         modifylnpPersonSchema.setModifyTime(time);
/*      */ 
/*  830 */         System.out.println("\uFFFD\u07B8\u0135\u013F\u037B\uFFFD\uFFFD\uFFFD\u05B7id--" + modifylnpAddressSchema.getAddressNo());
/*      */ 
/*  832 */         modifylnpAddressSchema.setPostalAddress(this.lnpAddressSchema.getPostalAddress());
/*  833 */         modifylnpAddressSchema.setZipCode(this.lnpAddressSchema.getZipCode());
/*  834 */         modifylnpAddressSchema.setPhone(this.lnpAddressSchema.getPhone());
/*  835 */         modifylnpAddressSchema.setHomeAddress(this.lnpAddressSchema.getHomeAddress());
/*  836 */         modifylnpAddressSchema.setHomeZipCode(this.lnpAddressSchema.getHomeZipCode());
/*  837 */         modifylnpAddressSchema.setHomePhone(this.lnpAddressSchema.getHomePhone());
/*  838 */         modifylnpAddressSchema.setCompanyAddress(this.lnpAddressSchema.getCompanyAddress());
/*  839 */         modifylnpAddressSchema.setCompanyPhone(this.lnpAddressSchema.getCompanyPhone());
/*  840 */         modifylnpAddressSchema.setCompanyMail(this.lnpAddressSchema.getCompanyMail());
/*  841 */         modifylnpAddressSchema.setGrpName(this.lnpAddressSchema.getGrpName());
/*  842 */         modifylnpAddressSchema.setCompanyZipCode(this.lnpAddressSchema.getCompanyZipCode());
/*  843 */         modifylnpAddressSchema.setDuchy(getInsuCity());
/*  844 */         modifylnpAddressSchema.setOtherDuchy(getInsuOtherCity() != null ? getInsuOtherCity() : "");
/*  845 */         modifylnpAddressSchema.setModifyDate(date);
/*  846 */         modifylnpAddressSchema.setModifyTime(time);
/*      */ 
/*  849 */         lnpContSch.setAppntId(modifyAppntPeopleSchema.getAppntId());
/*  850 */         lnpContSch.setAppntNo(modifyAppntPeopleSchema.getAppntNo());
/*  851 */         lnpContSch.setAppntName(modifyAppntPeopleSchema.getAppntName());
/*  852 */         lnpContSch.setAppntBirthday(modifyAppntPeopleSchema.getAppntBirthday());
/*  853 */         lnpContSch.setAppntIDType(modifyAppntPeopleSchema.getIDType());
/*  854 */         lnpContSch.setAppntIDNo(modifyAppntPeopleSchema.getIDNo());
/*      */ 
/*  857 */         List stateList = operatorDeal.infoOperate(this.contSch.getState(), this.contSch.getEditstate(), this.infoSource, "03");
/*      */ 
/*  859 */         lnpContSch.setState((String)stateList.get(0));
/*  860 */         lnpContSch.setEditstate((String)stateList.get(1));
/*      */ 
/*  863 */         if ("2".equals(lnpContSch.getUWFlag())) {
/*  864 */           lnpContSch.setUWFlag("1");
/*      */         }
/*      */ 
/*  867 */         lnpContSch.setModifyDate(date);
/*  868 */         lnpContSch.setModifyTime(time);
/*      */ 
/*  870 */         map.put(modifyAppntPeopleSchema, "UPDATE");
/*  871 */         map.put(modifylnpPersonSchema, "UPDATE");
/*  872 */         map.put(modifylnpAddressSchema, "UPDATE");
/*  873 */         map.put(lnpContSch, "UPDATE");
/*      */       } else {
/*  875 */         this.message = "\u6570\u636E\u5E93\u4E2D\u672A\u67E5\u8BE2\u5230\u6295\u4FDD\u4EBA\u4FE1\u606F\uFF01";
/*      */       }
/*      */ 
/*  878 */       VData vd = new VData();
/*  879 */       vd.add(map);
/*  880 */       if (!ps.submitData(vd, "")) {
/*  881 */         System.out.println("-AppntredPersonInfo-\uFFFD\u07B8\u0134\uFFFD\uFFFD\uFFFD");
/*      */ 
/*  883 */         this.message = "\u0376\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03E2\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD";
/*      */ 
/*  885 */         flag = false;
/*      */       } else {
/*  887 */         flag = true;
/*  888 */         afterupdateAppnt(this.contNo);
/*  889 */         boolean checkSpelFlag = checkSpelKeyChange(modifyAppntPeopleSchemaTemp, this.appntSchema.getAppntName(), 
/*  890 */           this.appntSchema.getAppntBirthday(), this.appntSchema.getOccupationCode(), 
/*  891 */           this.appntSchema.getRelationToInsured(), this.appntSchema.getAppntAge(), this.appntSchema.getAppntAgeType());
/*  892 */         boolean bool1 = operatorDeal.afterModifyAppnt(this.contSch.getContNo(), checkSpelFlag);
/*      */       }
/*      */     }
/*      */     catch (RuntimeException e) {
/*  896 */       e.printStackTrace();
/*  897 */       this.message = "\u0376\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03E2\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD";
/*      */ 
/*  899 */       flag = false;
/*      */     }
/*      */ 
/*  902 */     System.out.println("-- modifyappntPeople end --");
/*  903 */     return flag;
/*      */   }
/*      */ 
/*      */   private boolean afterupdateAppnt(String contno)
/*      */   {
/*  911 */     System.out.println("-----\uFFFD\u0431?\uFFFD\uFFFD \uFFFD\u07B8\u0131\uFFFD\uFFFD\uFFFD\uFFFD\u02F9\uFFFD\uFFFD \u027E\uFFFD\uFFFD\u02F1\uFFFD\uFFFD\uFFFD\uFFFD\u06F6\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD ----");
/*  912 */     boolean flag = false;
/*      */     try {
/*  914 */       PubSubmit ps = new PubSubmit();
/*  915 */       MMap mmap = new MMap();
/*      */ 
/*  917 */       LNPUWQuestionDB queDB = new LNPUWQuestionDB();
/*      */ 
/*  919 */       String sql = "select * from LNPUWQuestion where contno='" + contno + "'";
/*  920 */       LNPUWQuestionSet queSet = queDB.executeQuery(sql);
/*  921 */       if ((queSet != null) && (queSet.size() > 0)) {
/*  922 */         mmap.put(queSet, "DELETE");
/*      */       }
/*  924 */       PolicyMainInfo mainInfo = new PolicyMainInfo();
/*  925 */       LNPContSchema tLNPContSchema = mainInfo.getContByContNo(contno);
/*  926 */       if ("2".equals(tLNPContSchema.getUWFlag())) {
/*  927 */         tLNPContSchema.setUWFlag("1");
/*      */       }
/*      */ 
/*  931 */       tLNPContSchema.setApproveFlag("0");
/*  932 */       mmap.put(tLNPContSchema, "UPDATE");
/*      */ 
/*  934 */       VData vd = new VData();
/*  935 */       vd.add(mmap);
/*      */ 
/*  937 */       if (!ps.submitData(vd, ""))
/*  938 */         flag = false;
/*      */       else
/*  940 */         flag = true;
/*      */     }
/*      */     catch (RuntimeException e)
/*      */     {
/*  944 */       e.printStackTrace();
/*      */     }
/*      */ 
/*  947 */     return flag;
/*      */   }
/*      */ 
/*      */   private List<SelectItem> getPageAppntRelationtoinsuredList(String typename, String iid, String cno)
/*      */   {
/*  957 */     List reList = new ArrayList();
/*  958 */     ExeSQL tExeSQL = new ExeSQL();
/*  959 */     String sql = "";
/*  960 */     LNPInsuredDB saveLSInsuredDB = new LNPInsuredDB();
/*  961 */     LNPInsuredSchema insuredSchema = new LNPInsuredSchema();
/*  962 */     saveLSInsuredDB.setContNo(cno);
/*  963 */     saveLSInsuredDB.setInsuredId(iid);
/*  964 */     if (saveLSInsuredDB.getInfo()) {
/*  965 */       insuredSchema = saveLSInsuredDB.getSchema();
/*      */     }
/*      */ 
/*  975 */     if ((("Y".equals(insuredSchema.getAppAgeType())) && (insuredSchema.getAppAge() <= 16)) || ("D".equals(insuredSchema.getAppAgeType())))
/*  976 */       sql = "select code,codename from lnpcode where codetype='" + typename + "' and code != '0' order by code";
/*      */     else {
/*  978 */       sql = "select code,codename from lnpcode where codetype='" + typename + "' order by code";
/*      */     }
/*      */ 
/*  981 */     SSRS tSRS = tExeSQL.execSQL(sql);
/*  982 */     if (tSRS != null) {
/*  983 */       for (int i = 1; i <= tSRS.MaxRow; i++) {
/*  984 */         reList.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*      */       }
/*      */     }
/*  987 */     return reList;
/*      */   }
/*      */ 
/*      */   private boolean checkSpelKeyChange(LNPAppntSchema modifyAppntSchema, String name, String birthday, String occupationCode2, String relationToInsured, int age, String ageType)
/*      */   {
/*  992 */     boolean ageflag = checkAgeChange(age, ageType, modifyAppntSchema.getAppntAge(), modifyAppntSchema.getAppntAgeType());
/*      */ 
/*  997 */     boolean nameflag = name.equals(modifyAppntSchema.getAppntName() != null ? modifyAppntSchema.getAppntName() : "");
/*  998 */     boolean birthdayflag = birthday.equals(modifyAppntSchema.getAppntBirthday() != null ? modifyAppntSchema.getAppntBirthday() : "");
/*  999 */     boolean occflag = occupationCode2.equals(modifyAppntSchema.getOccupationCode() != null ? modifyAppntSchema.getOccupationCode() : "");
/* 1000 */     boolean insuredflag = relationToInsured.equals(modifyAppntSchema.getRelationToInsured() != null ? modifyAppntSchema.getRelationToInsured() : "");
/*      */ 
/* 1008 */     return (!nameflag) || (!birthdayflag) || (!occflag) || (!insuredflag) || (!ageflag);
/*      */   }
/*      */ 
/*      */   private boolean checkAgeChange(int age2, String ageType, int appAge, String appAgeType)
/*      */   {
/* 1015 */     boolean flag = false;
/*      */ 
/* 1019 */     if ((ageType.equals(appAgeType)) && (ageType.equals("Y"))) {
/* 1020 */       if (appAge == age2)
/* 1021 */         flag = true;
/*      */     }
/* 1023 */     else if (ageType.equals("D")) {
/* 1024 */       if ((appAge == 0) && (appAgeType.equals("Y")))
/* 1025 */         flag = true;
/* 1026 */       else if ((appAgeType.equals(ageType)) && 
/* 1027 */         (appAge == age2)) {
/* 1028 */         flag = true;
/*      */       }
/*      */     }
/*      */ 
/* 1032 */     System.out.println("checkAgeChange:" + flag);
/* 1033 */     return flag;
/*      */   }
/*      */ 
/*      */   public void getAgeByBirthday()
/*      */   {
/* 1038 */     this.reAge = "-1";
/*      */     try {
/* 1040 */       this.reAge = LNPPubFun.getAgeByBirthdayNew(this.appntSchema.getAppntBirthday(), this.contSch.getPValiDate());
/*      */     }
/*      */     catch (RuntimeException e) {
/* 1043 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getReAge()
/*      */   {
/* 1050 */     return this.reAge;
/*      */   }
/*      */ 
/*      */   public void setReAge(String reAge)
/*      */   {
/* 1055 */     this.reAge = reAge;
/*      */   }
/*      */ 
/*      */   private boolean validate()
/*      */   {
/* 1061 */     if ((this.appntSchema.getAppntName() == null) || 
/* 1062 */       (this.appntSchema.getAppntName().equals("")))
/*      */     {
/* 1064 */       this.message = "\u0376\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 1065 */       return false;
/*      */     }
/* 1067 */     if (!ValidateTools.isValidString1(this.appntSchema.getAppntName())) {
/* 1068 */       this.message = "\uFFFD\uBC34\uFFFD\uFFFD\uFFFD\uFFFD\u0237\uFFFD\uFFFD\u02BD\u00BC\uFFFD\uFFFD\u0376\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD";
/* 1069 */       return false;
/*      */     }
/*      */ 
/* 1073 */     if ((this.appntSchema.getAppntSex() == null) || 
/* 1074 */       (this.appntSchema.getAppntSex().equals("-1")) || 
/* 1075 */       (this.appntSchema.getAppntSex().equals("")))
/*      */     {
/* 1077 */       this.message = "\u0376\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0531\uFFFD\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 1078 */       return false;
/*      */     }
/*      */ 
/* 1081 */     if ((this.appntSchema.getAppntBirthday() == null) || 
/* 1082 */       (this.appntSchema.getAppntBirthday().equals("")))
/*      */     {
/* 1084 */       this.message = "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u06B2\uFFFD\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 1085 */       return false;
/*      */     }
/*      */ 
/* 1090 */     if (this.appntSchema.getAppntAge() == 0)
/*      */     {
/* 1092 */       this.message = "\u0376\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u4CBB\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 1093 */       return false;
/*      */     }
/* 1095 */     if ((this.appntSchema.getMarriage() == null) || 
/* 1096 */       (this.appntSchema.getMarriage().equals("-1")) || 
/* 1097 */       (this.appntSchema.getMarriage().equals("")))
/*      */     {
/* 1099 */       this.message = "\uFFFD\uFFFD\uFFFD\uFFFD\u05F4\uFFFD\uFFFD\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 1100 */       return false;
/*      */     }
/* 1102 */     if ((this.appntSchema.getNativePlace() == null) || 
/* 1103 */       (this.appntSchema.getNativePlace().equals("-1")) || 
/* 1104 */       (this.appntSchema.getNativePlace().equals("")))
/*      */     {
/* 1106 */       this.message = "\uFFFD\uFFFD\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 1107 */       return false;
/*      */     }
/* 1109 */     if ((this.appntSchema.getIDType() == null) || 
/* 1110 */       (this.appntSchema.getIDType().equals("-1")) || 
/* 1111 */       (this.appntSchema.getIDType().equals("")))
/*      */     {
/* 1113 */       this.message = "\u05A4\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0372\uFFFD\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 1114 */       return false;
/*      */     }
/* 1116 */     if ((this.appntSchema.getIDNo() == null) || 
/* 1117 */       (this.appntSchema.getIDNo().equals("")))
/*      */     {
/* 1119 */       this.message = "\u05A4\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uBCBB\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 1120 */       return false;
/*      */     }
/*      */ 
/* 1124 */     if (this.appntSchema.getIDType().equals("1")) {
/* 1125 */       String returnString = ValidateTools.isValidIDNo(this.appntSchema
/* 1126 */         .getIDNo(), this.appntSchema.getAppntBirthday(), 
/* 1127 */         this.appntSchema.getAppntSex());
/* 1128 */       if (!returnString.equals("")) {
/* 1129 */         this.message = returnString;
/* 1130 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1140 */     if ((this.appntSchema.getOccupationCode() == null) || 
/* 1141 */       (this.appntSchema.getOccupationCode().equals("")))
/*      */     {
/* 1143 */       this.message = "\u05B0\u04B5\uFFFD\uFFFD\uFFFD\uBCBB\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 1144 */       return false;
/*      */     }
/* 1146 */     if ((this.lnpAddressSchema.getPostalAddress() == null) || 
/* 1147 */       (this.lnpAddressSchema.getPostalAddress().equals("")))
/*      */     {
/* 1149 */       this.message = "\uFFFD\u0577\u0475\uFFFD\u05B7\uFFFD\uFFFD\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 1150 */       return false;
/*      */     }
/*      */ 
/* 1155 */     if ((this.lnpAddressSchema.getPhone() == null) || 
/* 1156 */       (this.lnpAddressSchema.getPhone().equals("")))
/*      */     {
/* 1158 */       this.message = "\uFFFD\u0577\u0475\u7EF0\uFFFD\uFFFD\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 1159 */       return false;
/*      */     }
/* 1161 */     if ((this.lnpAddressSchema.getZipCode() == null) || 
/* 1162 */       (this.lnpAddressSchema.getZipCode().equals("")))
/*      */     {
/* 1164 */       this.message = "\uFFFD\u0577\uFFFD\uFFFD\u02B1\u0CBB\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 1165 */       return false;
/*      */     }
/*      */ 
/* 1169 */     if ((this.lnpAddressSchema.getGrpName() != null) && 
/* 1170 */       (!this.lnpAddressSchema.getGrpName().equals("")) && 
/* 1171 */       (!ValidateTools.isValidString3(this.lnpAddressSchema.getGrpName()))) {
/* 1172 */       this.message = "\uFFFD\uBC34\uFFFD\uFFFD\uFFFD\uFFFD\u0237\uFFFD\uFFFD\u02BD\u00BC\uFFFD\uBE64\uFFFD\uFFFD\u03BB\uFFFD\uFFFD";
/* 1173 */       return false;
/*      */     }
/*      */ 
/* 1177 */     if ((this.lnpAddressSchema.getCompanyZipCode() != null) && 
/* 1178 */       (!this.lnpAddressSchema.getCompanyZipCode().equals("")))
/*      */     {
/* 1180 */       if (!ValidateTools.isValidZipCode(this.lnpAddressSchema
/* 1180 */         .getCompanyZipCode())) {
/* 1181 */         this.message = "\uFFFD\uBC34\uFFFD\uFFFD\uFFFD\uFFFD\u0237\uFFFD\uFFFD\u02BD\u00BC\uFFFD\uBD65\u03BB\uFFFD\u02B1\u08E1";
/* 1182 */         return false;
/*      */       }
/*      */     }
/*      */ 
/* 1186 */     if ((this.lnpAddressSchema.getCompanyAddress() != null) && 
/* 1187 */       (!this.lnpAddressSchema.getCompanyAddress().equals("")))
/*      */     {
/* 1189 */       if (!ValidateTools.isValidString3(this.lnpAddressSchema
/* 1189 */         .getCompanyAddress())) {
/* 1190 */         this.message = "\uFFFD\uBC34\uFFFD\uFFFD\uFFFD\uFFFD\u0237\uFFFD\uFFFD\u02BD\u00BC\uFFFD\uBD65\u03BB\uFFFD\uFFFD\u05B7\uFFFD\uFFFD";
/* 1191 */         return false;
/*      */       }
/*      */     }
/*      */ 
/* 1195 */     if ((this.lnpAddressSchema.getCompanyMail() != null) && 
/* 1196 */       (!this.lnpAddressSchema.getCompanyMail().equals("")))
/*      */     {
/* 1198 */       if (!ValidateTools.isValidString4(this.lnpAddressSchema
/* 1198 */         .getCompanyMail())) {
/* 1199 */         this.message = "\uFFFD\uBC34\uFFFD\uFFFD\uFFFD\uFFFD\u0237\uFFFD\uFFFD\u02BD\u00BC\uFFFD\uBD65\u03BB\uFFFD\uFFFD\uFFFD\u02A3\uFFFD";
/* 1200 */         this.lnpAddressSchema.setCompanyMail("");
/* 1201 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1208 */     if ((this.lnpAddressSchema.getHomeAddress() != null) && 
/* 1209 */       (!this.lnpAddressSchema.getHomeAddress().equals("")))
/*      */     {
/* 1211 */       if (!ValidateTools.isValidString3(this.lnpAddressSchema.getHomeAddress())) {
/* 1212 */         this.message = "\uFFFD\uBC34\uFFFD\uFFFD\uFFFD\uFFFD\u0237\uFFFD\uFFFD\u02BD\u00BC\uFFFD\uFFFD\u05E1\u05B7\uFFFD\uFFFD";
/* 1213 */         return false;
/*      */       }
/*      */     }
/*      */ 
/* 1217 */     if ((this.lnpAddressSchema.getHomeZipCode() != null) && 
/* 1218 */       (!this.lnpAddressSchema.getHomeZipCode().equals("")))
/*      */     {
/* 1220 */       if (!ValidateTools.isValidZipCode(this.lnpAddressSchema.getHomeZipCode())) {
/* 1221 */         this.message = "\uFFFD\uBC34\uFFFD\uFFFD\uFFFD\uFFFD\u0237\uFFFD\uFFFD\u02BD\u00BC\uFFFD\uFFFD\uFFFD\u02B1\u08E1";
/* 1222 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1230 */     if ((this.lnpAddressSchema.getPostalAddress() != null) && 
/* 1231 */       (!this.lnpAddressSchema.getPostalAddress().equals("")))
/*      */     {
/* 1233 */       if (!ValidateTools.isValidString3(this.lnpAddressSchema
/* 1233 */         .getPostalAddress())) {
/* 1234 */         this.message = "\uFFFD\uBC34\uFFFD\uFFFD\uFFFD\uFFFD\u0237\uFFFD\uFFFD\u02BD\u00BC\uFFFD\uFFFD\uFFFD\u0577\u0475\uFFFD\u05B7\uFFFD\uFFFD";
/* 1235 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1241 */     if ((this.lnpAddressSchema.getZipCode() != null) && 
/* 1242 */       (!this.lnpAddressSchema.getZipCode().equals("")) && 
/* 1243 */       (!ValidateTools.isValidZipCode(this.lnpAddressSchema.getZipCode()))) {
/* 1244 */       this.message = "\uFFFD\uBC34\uFFFD\uFFFD\uFFFD\uFFFD\u0237\uFFFD\uFFFD\u02BD\u00BC\uFFFD\uFFFD\uFFFD\u0577\uFFFD\uFFFD\u02B1\u08E1";
/* 1245 */       return false;
/*      */     }
/*      */ 
/* 1250 */     return true;
/*      */   }
/*      */ 
/*      */   public String getAppntNative() {
/* 1254 */     return this.appntNative;
/*      */   }
/*      */ 
/*      */   public void setAppntNative(String appntNative) {
/* 1258 */     this.appntNative = appntNative;
/*      */   }
/*      */ 
/*      */   public LNPAppntSchema getAppntSchema() {
/* 1262 */     return this.appntSchema;
/*      */   }
/*      */ 
/*      */   public void setAppntSchema(LNPAppntSchema appntSchema) {
/* 1266 */     this.appntSchema = appntSchema;
/*      */   }
/*      */ 
/*      */   public String getIdType() {
/* 1270 */     return this.idType;
/*      */   }
/*      */ 
/*      */   public void setIdType(String idType) {
/* 1274 */     this.idType = idType;
/*      */   }
/*      */ 
/*      */   public LNPAddressSchema getLnpAddressSchema() {
/* 1278 */     return this.lnpAddressSchema;
/*      */   }
/*      */ 
/*      */   public void setLnpAddressSchema(LNPAddressSchema lnpAddressSchema) {
/* 1282 */     this.lnpAddressSchema = lnpAddressSchema;
/*      */   }
/*      */ 
/*      */   public LNPPersonSchema getLnpPersonSchema() {
/* 1286 */     return this.lnpPersonSchema;
/*      */   }
/*      */ 
/*      */   public void setLnpPersonSchema(LNPPersonSchema lnpPersonSchema) {
/* 1290 */     this.lnpPersonSchema = lnpPersonSchema;
/*      */   }
/*      */ 
/*      */   public String getMarriage() {
/* 1294 */     return this.marriage;
/*      */   }
/*      */ 
/*      */   public void setMarriage(String marriage) {
/* 1298 */     this.marriage = marriage;
/*      */   }
/*      */ 
/*      */   public String getMessage() {
/* 1302 */     return this.message;
/*      */   }
/*      */ 
/*      */   public void setMessage(String message) {
/* 1306 */     this.message = message;
/*      */   }
/*      */ 
/*      */   public String getAge()
/*      */   {
/* 1311 */     return this.age;
/*      */   }
/*      */ 
/*      */   public void setAge(String age) {
/* 1315 */     this.age = age;
/*      */   }
/*      */ 
/*      */   public String getSex() {
/* 1319 */     return this.sex;
/*      */   }
/*      */ 
/*      */   public void setSex(String sex) {
/* 1323 */     this.sex = sex;
/*      */   }
/*      */ 
/*      */   public String getConnectionWithInsurance() {
/* 1327 */     return this.connectionWithInsurance;
/*      */   }
/*      */ 
/*      */   public void setConnectionWithInsurance(String connectionWithInsurance) {
/* 1331 */     this.connectionWithInsurance = connectionWithInsurance;
/*      */   }
/*      */ 
/*      */   public String getIdPerpetual()
/*      */   {
/* 1337 */     return this.idPerpetual;
/*      */   }
/*      */ 
/*      */   public void setIdPerpetual(String idPerpetual) {
/* 1341 */     this.idPerpetual = idPerpetual;
/*      */   }
/*      */ 
/*      */   public boolean isRenderFlag() {
/* 1345 */     return this.renderFlag;
/*      */   }
/*      */ 
/*      */   public void setRenderFlag(boolean renderFlag) {
/* 1349 */     this.renderFlag = renderFlag;
/*      */   }
/*      */ 
/*      */   public boolean isOperateResult() {
/* 1353 */     return this.operateResult;
/*      */   }
/*      */ 
/*      */   public void setOperateResult(boolean operateResult) {
/* 1357 */     this.operateResult = operateResult;
/*      */   }
/*      */ 
/*      */   public boolean isEditFlag() {
/* 1361 */     return this.editFlag;
/*      */   }
/*      */ 
/*      */   public void setEditFlag(boolean editFlag) {
/* 1365 */     this.editFlag = editFlag;
/*      */   }
/*      */ 
/*      */   public String getContNo() {
/* 1369 */     return this.contNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String contNo) {
/* 1373 */     this.contNo = contNo;
/*      */   }
/*      */ 
/*      */   public String getOccupationCode() {
/* 1377 */     return this.occupationCode;
/*      */   }
/*      */ 
/*      */   public void setOccupationCode(String occupationCode) {
/* 1381 */     this.occupationCode = occupationCode;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getAppntRelationtoinsuredList() {
/* 1385 */     if (this.appntRelationtoinsuredList != null) {
/* 1386 */       this.appntRelationtoinsuredList.clear();
/*      */     }
/* 1388 */     this.appntRelationtoinsuredList = getPageAppntRelationtoinsuredList("appntrelationtoinsured", this.insuredId, this.contNo);
/* 1389 */     return this.appntRelationtoinsuredList;
/*      */   }
/*      */ 
/*      */   public void setAppntRelationtoinsuredList(List<SelectItem> appntRelationtoinsuredList)
/*      */   {
/* 1394 */     this.appntRelationtoinsuredList = appntRelationtoinsuredList;
/*      */   }
/*      */ 
/*      */   public String getOccupationName() {
/* 1398 */     return this.occupationName;
/*      */   }
/*      */ 
/*      */   public void setOccupationName(String occupationName) {
/* 1402 */     this.occupationName = occupationName;
/*      */   }
/*      */ 
/*      */   public String getInsuCity() {
/* 1406 */     return this.insuCity;
/*      */   }
/*      */ 
/*      */   public void setInsuCity(String insuCity) {
/* 1410 */     this.insuCity = insuCity;
/*      */   }
/*      */ 
/*      */   public String getInsuOtherCity() {
/* 1414 */     return this.insuOtherCity;
/*      */   }
/*      */ 
/*      */   public void setInsuOtherCity(String insuOtherCity) {
/* 1418 */     this.insuOtherCity = insuOtherCity;
/*      */   }
/*      */ 
/*      */   public String getNameHidden() {
/* 1422 */     return this.nameHidden;
/*      */   }
/*      */ 
/*      */   public void setNameHidden(String nameHidden) {
/* 1426 */     this.nameHidden = nameHidden;
/*      */   }
/*      */ 
/*      */   public String getBirthdayHidden() {
/* 1430 */     return this.birthdayHidden;
/*      */   }
/*      */ 
/*      */   public void setBirthdayHidden(String birthdayHidden) {
/* 1434 */     this.birthdayHidden = birthdayHidden;
/*      */   }
/*      */ 
/*      */   public String getConnectionWithInsuranceHidden()
/*      */   {
/* 1440 */     return this.connectionWithInsuranceHidden;
/*      */   }
/*      */ 
/*      */   public void setConnectionWithInsuranceHidden(String connectionWithInsuranceHidden)
/*      */   {
/* 1445 */     this.connectionWithInsuranceHidden = connectionWithInsuranceHidden;
/*      */   }
/*      */ 
/*      */   public String getOccupationCodeHidden() {
/* 1449 */     return this.occupationCodeHidden;
/*      */   }
/*      */ 
/*      */   public void setOccupationCodeHidden(String occupationCodeHidden) {
/* 1453 */     this.occupationCodeHidden = occupationCodeHidden;
/*      */   }
/*      */ 
/*      */   public boolean isHasUnderWrite() {
/* 1457 */     return this.hasUnderWrite;
/*      */   }
/*      */ 
/*      */   public void setHasUnderWrite(boolean hasUnderWrite) {
/* 1461 */     this.hasUnderWrite = hasUnderWrite;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.AppntPersonInfo
 * JD-Core Version:    0.6.0
 */