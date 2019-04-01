/*      */ package com.sinosoft.banklns.lnsmodel;
/*      */ 
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
/*      */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPInsuredSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPPersonSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPInsuredSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPUWQuestionSet;
/*      */ import com.sinosoft.banklns.utility.ExeSQL;
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
/*      */ public class InsuredPersonInfo
/*      */ {
/*      */   private boolean editFlag;
/*   35 */   private boolean operateResult = true;
/*      */ 
/*   38 */   private boolean hasPolTag = false;
/*      */   private IGlobalInput tempGI;
/*      */   private LNPContSchema contSch;
/*      */   private String message;
/*      */   private String infoSource;
/*      */   private String contNo;
/*   51 */   private LNPInsuredSchema insuredSchema = new LNPInsuredSchema();
/*   52 */   private LNPPersonSchema lnpPersonSchema = new LNPPersonSchema();
/*   53 */   private LNPAddressSchema lnpAddressSchema = new LNPAddressSchema();
/*      */   private String insuredId;
/*      */   private String name;
/*      */   private String birthday;
/*      */   private String IDNo;
/*      */   private String IDValidity;
/*      */   private String occupationName;
/*      */   private String occupationCode;
/*      */   private String partOccupationName;
/*      */   private String partOccupationCode;
/*   70 */   private String nameHidden = null;
/*   71 */   private String birthdayHidden = null;
/*   72 */   private String sexHidden = null;
/*   73 */   private String occupationCodeHidden = null;
/*   74 */   private String insuNativeHidden = null;
/*      */   private String postalAddress;
/*      */   private String phone;
/*      */   private String zipCode;
/*      */   private String grpName;
/*      */   private String companyMail;
/*      */   private String companyAddress;
/*      */   private String companyPhone;
/*      */   private String companyZipCode;
/*      */   private String homeAddress;
/*      */   private String homePhone;
/*      */   private String homeZipCode;
/*   91 */   private String age = "";
/*      */ 
/*   93 */   private String insuCity = "";
/*      */ 
/*   95 */   private String insuOtherCity = "";
/*      */   private String sex;
/*      */   private String marriage;
/*      */   private String insuNative;
/*      */   private String idType;
/*      */   private String signCityFirst;
/*      */   private String idPerpetual;
/*  106 */   private List<SelectItem> signCityList = new ArrayList();
/*      */   private String operType;
/*      */   private String manageCom;
/*      */   private String pvalidate;
/*      */   private String reAge;
/*      */ 
/*      */   public String getPvalidate()
/*      */   {
/*  117 */     if (this.contSch != null) {
/*  118 */       return this.contSch.getPValiDate();
/*      */     }
/*  120 */     return this.pvalidate;
/*      */   }
/*      */ 
/*      */   public void setPvalidate(String pvalidate)
/*      */   {
/*  127 */     this.pvalidate = pvalidate;
/*      */   }
/*      */ 
/*      */   public void initData()
/*      */   {
/*      */     try {
/*  133 */       this.operateResult = true;
/*  134 */       HttpSession session = (HttpSession)
/*  135 */         FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*  136 */       this.tempGI = ((IGlobalInput)session.getValue("NPGI"));
/*  137 */       this.insuredSchema = new LNPInsuredSchema();
/*  138 */       this.lnpPersonSchema = new LNPPersonSchema();
/*  139 */       this.lnpAddressSchema = new LNPAddressSchema();
/*  140 */       this.postalAddress = "";
/*  141 */       this.phone = "";
/*  142 */       this.zipCode = "";
/*  143 */       this.grpName = "";
/*  144 */       this.companyMail = "";
/*  145 */       this.companyAddress = "";
/*  146 */       this.companyPhone = "";
/*  147 */       this.companyZipCode = "";
/*  148 */       this.homeAddress = "";
/*  149 */       this.homePhone = "";
/*  150 */       this.homeZipCode = "";
/*  151 */       this.insuredId = "";
/*  152 */       this.name = "";
/*  153 */       this.birthday = "";
/*  154 */       this.IDNo = "";
/*  155 */       this.IDValidity = "";
/*  156 */       this.occupationName = "";
/*  157 */       this.occupationCode = "";
/*  158 */       this.partOccupationName = "";
/*  159 */       this.partOccupationCode = "";
/*  160 */       this.insuCity = "";
/*      */ 
/*  164 */       this.sex = null;
/*  165 */       this.age = "";
/*  166 */       this.marriage = null;
/*  167 */       this.idType = "1";
/*  168 */       this.insuNative = "";
/*  169 */       this.signCityFirst = "";
/*  170 */       this.idPerpetual = "0";
/*      */ 
/*  172 */       this.operType = this.tempGI.OperType;
/*  173 */       this.manageCom = this.tempGI.ManageCom;
/*      */ 
/*  176 */       Boolean getEditFlag = (Boolean)session.getAttribute("editFlag");
/*      */ 
/*  179 */       if (((String)session.getAttribute("ContNo") != null) && 
/*  180 */         (!((String)session.getAttribute("ContNo")).equals(""))) {
/*  181 */         this.contNo = ((String)session.getAttribute("ContNo"));
/*      */ 
/*  183 */         this.signCityList = doSignCityListValue();
/*      */ 
/*  185 */         PolicyMainInfo mainInfo = new PolicyMainInfo();
/*  186 */         this.contSch = mainInfo.getContByContNo(this.contNo);
/*      */ 
/*  188 */         if ((this.contSch != null) && (this.contSch.getInsuredId() != null) && (!this.contSch.getInsuredId().equals(""))) {
/*  189 */           String myInsuredId = this.contSch.getInsuredId();
/*      */ 
/*  191 */           PersonFunction pf = new PersonFunction();
/*      */ 
/*  193 */           this.insuredSchema = getOneInsuredPersonInfo(this.contNo, 
/*  194 */             myInsuredId);
/*  195 */           this.lnpPersonSchema = pf.getLnpPersonByCustomerId(myInsuredId);
/*  196 */           this.lnpAddressSchema = pf.getLnpAddrByCustomerId(myInsuredId);
/*  197 */           this.insuredId = myInsuredId;
/*  198 */           this.name = this.insuredSchema.getName();
/*  199 */           this.birthday = this.insuredSchema.getBirthday();
/*  200 */           this.IDNo = this.insuredSchema.getIDNo();
/*  201 */           this.IDValidity = this.insuredSchema.getIDValidity();
/*  202 */           this.occupationName = getOccupName(this.insuredSchema.getOccupationCode());
/*  203 */           this.occupationCode = this.insuredSchema.getOccupationCode();
/*  204 */           this.partOccupationName = getOccupName(this.insuredSchema.getPartOccupationCode());
/*  205 */           this.partOccupationCode = this.insuredSchema.getPartOccupationCode();
/*      */ 
/*  207 */           this.postalAddress = this.lnpAddressSchema.getPostalAddress();
/*  208 */           this.phone = this.lnpAddressSchema.getPhone();
/*  209 */           this.zipCode = this.lnpAddressSchema.getZipCode();
/*  210 */           this.grpName = this.lnpAddressSchema.getGrpName();
/*  211 */           this.companyMail = this.lnpAddressSchema.getCompanyMail();
/*  212 */           this.companyAddress = this.lnpAddressSchema.getCompanyAddress();
/*  213 */           this.companyPhone = this.lnpAddressSchema.getCompanyPhone();
/*  214 */           this.companyZipCode = this.lnpAddressSchema.getCompanyZipCode();
/*  215 */           this.homeAddress = this.lnpAddressSchema.getHomeAddress();
/*  216 */           this.homePhone = this.lnpAddressSchema.getHomePhone();
/*  217 */           this.homeZipCode = this.lnpAddressSchema.getHomeZipCode();
/*      */ 
/*  221 */           this.sex = this.insuredSchema.getSex();
/*  222 */           this.marriage = this.insuredSchema.getMarriage();
/*  223 */           this.idType = this.insuredSchema.getIDType();
/*  224 */           this.insuNative = this.insuredSchema.getNativePlace();
/*  225 */           this.idPerpetual = this.insuredSchema.getIDPerpetual();
/*  226 */           this.signCityFirst = this.insuredSchema.getSignCity();
/*  227 */           if ((this.insuredSchema.getBirthday() != null) && (!"".equals(this.insuredSchema.getBirthday()))) {
/*  228 */             this.age = LNPPubFun.getAgeByBirthdayNew(this.insuredSchema.getBirthday(), this.contSch.getPValiDate());
/*      */           }
/*  230 */           this.insuCity = this.lnpAddressSchema.getDuchy();
/*  231 */           this.insuOtherCity = this.lnpAddressSchema.getOtherDuchy();
/*      */ 
/*  233 */           this.nameHidden = this.name;
/*  234 */           this.sexHidden = this.sex;
/*  235 */           this.birthdayHidden = this.birthday;
/*  236 */           this.occupationCodeHidden = this.occupationCode;
/*  237 */           this.insuNativeHidden = this.insuNative;
/*      */ 
/*  239 */           String editState_Pol = this.contSch.getEditstate().substring(3, 4);
/*  240 */           if ("1".equals(editState_Pol))
/*  241 */             this.hasPolTag = true;
/*  242 */           else if ("0".equals(editState_Pol)) {
/*  243 */             this.hasPolTag = false;
/*      */           }
/*      */ 
/*  247 */           this.infoSource = "modify";
/*      */         } else {
/*  249 */           this.infoSource = "add";
/*      */         }
/*      */       }
/*      */       else {
/*  253 */         getEditFlag = Boolean.valueOf(false);
/*      */       }
/*      */ 
/*  256 */       if ((getEditFlag != null) && (!getEditFlag.booleanValue())) {
/*  257 */         this.infoSource = "undo";
/*  258 */         this.editFlag = false;
/*      */       } else {
/*  260 */         this.editFlag = true;
/*      */       }
/*      */     }
/*      */     catch (RuntimeException e)
/*      */     {
/*  265 */       e.printStackTrace();
/*  266 */       this.message = "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u02F3\uFFFD\u02BC\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD";
/*  267 */       this.operateResult = false;
/*      */     }
/*      */   }
/*      */ 
/*      */   private String getOccupName(String occcode) {
/*  272 */     String reName = "";
/*  273 */     if (occcode != null) {
/*  274 */       LNPOccupationDB occDB = new LNPOccupationDB();
/*  275 */       occDB.setOccupationCode(occcode);
/*  276 */       if (occDB.getInfo()) {
/*  277 */         reName = occDB.getOccupationName();
/*      */       }
/*      */     }
/*  280 */     return reName;
/*      */   }
/*      */ 
/*      */   public void saveOccupMenuNO()
/*      */   {
/*  285 */     HttpSession session = (HttpSession)FacesContext.getCurrentInstance()
/*  286 */       .getExternalContext().getSession(true);
/*  287 */     session.setAttribute("occupationName", "");
/*  288 */     session.setAttribute("occupationCode", "");
/*      */   }
/*      */ 
/*      */   public void cancleOccupSession()
/*      */   {
/*  294 */     HttpSession session = (HttpSession)FacesContext.getCurrentInstance()
/*  295 */       .getExternalContext().getSession(true);
/*  296 */     String occupationName = (String)session.getAttribute("occupationName");
/*  297 */     String occupationCode = (String)session.getAttribute("occupationCode");
/*      */ 
/*  299 */     if ((occupationName != null) && (!occupationName.equals("")))
/*  300 */       this.occupationName = occupationName;
/*      */     else {
/*  302 */       this.occupationName = "";
/*      */     }
/*  304 */     if ((occupationCode != null) && (!occupationCode.equals("")))
/*  305 */       this.occupationCode = occupationCode;
/*      */     else {
/*  307 */       this.occupationCode = "";
/*      */     }
/*      */ 
/*  310 */     session.removeAttribute("occupationName");
/*  311 */     session.removeAttribute("occupationCode");
/*      */   }
/*      */ 
/*      */   public void reWriteOccupation()
/*      */   {
/*  317 */     String sql = "select occupationcode,occupationname from lnpoccupation where occupationcode='" + this.occupationCode + "';";
/*      */ 
/*  319 */     ExeSQL tExeSQL = new ExeSQL();
/*  320 */     SSRS tSSRS = tExeSQL.execSQL(sql);
/*      */ 
/*  323 */     if (tSSRS.MaxRow > 0) {
/*  324 */       this.operateResult = false;
/*  325 */       this.occupationCode = tSSRS.GetText(1, 1);
/*  326 */       this.occupationName = tSSRS.GetText(1, 2);
/*      */     } else {
/*  328 */       this.operateResult = true;
/*  329 */       this.occupationCode = "";
/*  330 */       this.occupationName = "";
/*      */ 
/*  332 */       this.message = "\uFFFD\uFFFD\u05B0\u04B5\uFFFD\uFFFD\uFFFD\uBCBB\uFFFD\uFFFD\uFFFD\u06A3\uFFFD";
/*      */     }
/*      */   }
/*      */ 
/*      */   public void reWriteOccupationPart() {
/*  337 */     String sql = "select occupationcode,occupationname from lnpoccupation where occupationcode='" + this.partOccupationCode + "';";
/*      */ 
/*  339 */     ExeSQL tExeSQL = new ExeSQL();
/*  340 */     SSRS tSSRS = tExeSQL.execSQL(sql);
/*      */ 
/*  343 */     if (tSSRS.MaxRow > 0) {
/*  344 */       this.operateResult = false;
/*  345 */       this.partOccupationCode = tSSRS.GetText(1, 1);
/*  346 */       this.partOccupationName = tSSRS.GetText(1, 2);
/*      */     } else {
/*  348 */       this.operateResult = true;
/*  349 */       this.partOccupationCode = "";
/*  350 */       this.partOccupationName = "";
/*  351 */       this.message = "\uFFFD\u00FC\uFFFD\u05B0\u05B0\u04B5\uFFFD\uFFFD\uFFFD\uBCBB\uFFFD\uFFFD\uFFFD\u06A3\uFFFD";
/*      */     }
/*      */   }
/*      */ 
/*      */   public void canclePartOccupSession() {
/*  356 */     HttpSession session = (HttpSession)FacesContext.getCurrentInstance()
/*  357 */       .getExternalContext().getSession(true);
/*  358 */     String occupationName = (String)session.getAttribute("occupationName");
/*  359 */     String occupationCode = (String)session.getAttribute("occupationCode");
/*      */ 
/*  361 */     if ((occupationName != null) && (!occupationName.equals("")))
/*  362 */       this.partOccupationName = occupationName;
/*      */     else {
/*  364 */       this.partOccupationName = "";
/*      */     }
/*  366 */     if ((occupationCode != null) && (!occupationCode.equals("")))
/*  367 */       this.partOccupationCode = occupationCode;
/*      */     else {
/*  369 */       this.partOccupationCode = "";
/*      */     }
/*      */ 
/*  373 */     session.removeAttribute("occupationName");
/*  374 */     session.removeAttribute("occupationCode");
/*      */   }
/*      */ 
/*      */   public void saveInusPeople()
/*      */   {
/*  380 */     this.message = null;
/*  381 */     this.operateResult = true;
/*      */     try
/*      */     {
/*  386 */       if ((this.infoSource.equals("undo")) || (this.contSch == null)) {
/*  387 */         this.message = "\u0376\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03E2\uFFFD\uFFFD\u02A7\uFFFD\uFFFD";
/*  388 */         this.operateResult = true;
/*      */ 
/*  390 */         return;
/*      */       }
/*      */ 
/*  393 */       this.lnpAddressSchema.setPostalAddress(this.postalAddress);
/*  394 */       this.lnpAddressSchema.setPhone(this.phone);
/*  395 */       this.lnpAddressSchema.setZipCode(this.zipCode);
/*  396 */       this.lnpAddressSchema.setGrpName(this.grpName);
/*  397 */       this.lnpAddressSchema.setCompanyMail(this.companyMail);
/*  398 */       this.lnpAddressSchema.setCompanyAddress(this.companyAddress);
/*  399 */       this.lnpAddressSchema.setCompanyPhone(this.companyPhone);
/*  400 */       this.lnpAddressSchema.setCompanyZipCode(this.companyZipCode);
/*  401 */       this.lnpAddressSchema.setHomeAddress(this.homeAddress);
/*  402 */       this.lnpAddressSchema.setHomePhone(this.homePhone);
/*  403 */       this.lnpAddressSchema.setHomeZipCode(this.homeZipCode);
/*      */ 
/*  405 */       this.insuredSchema.setName(this.name);
/*  406 */       this.insuredSchema.setBirthday(this.birthday);
/*  407 */       this.insuredSchema.setIDNo(this.IDNo);
/*  408 */       this.insuredSchema.setIDValidity(this.IDValidity);
/*      */ 
/*  410 */       this.insuredSchema.setOccupationCode(this.occupationCode);
/*      */ 
/*  412 */       this.insuredSchema.setPartOccupationCode(this.partOccupationCode);
/*      */ 
/*  415 */       this.insuredSchema.setNativePlace(getInsuNative());
/*  416 */       this.insuredSchema.setSex(getSex());
/*  417 */       this.insuredSchema.setMarriage(getMarriage());
/*  418 */       this.insuredSchema.setIDType(getIdType());
/*  419 */       this.insuredSchema.setIDPerpetual(getIdPerpetual());
/*      */ 
/*  422 */       if (this.insuredSchema.getIDValidity() != null)
/*  423 */         this.insuredSchema.setIDValidity(this.insuredSchema.getIDValidity());
/*      */       else {
/*  425 */         this.insuredSchema.setIDValidity("");
/*      */       }
/*      */ 
/*  429 */       String agePer = "";
/*  430 */       String ageType = "";
/*  431 */       agePer = LNPPubFun.getAgeByBirthdayNew(this.insuredSchema.getBirthday(), this.contSch.getPValiDate());
/*  432 */       this.age = agePer;
/*  433 */       if (agePer.indexOf("\uFFFD\uFFFD") > -1) {
/*  434 */         ageType = "D";
/*  435 */         agePer = agePer.substring(0, agePer.indexOf("\uFFFD\uFFFD"));
/*      */       } else {
/*  437 */         ageType = "Y";
/*  438 */         agePer = agePer.substring(0, agePer.indexOf("\uFFFD\uFFFD"));
/*      */       }
/*  440 */       this.insuredSchema.setAppAge(agePer);
/*  441 */       this.insuredSchema.setAppAgeType(ageType);
/*      */ 
/*  443 */       this.insuredSchema.setSignCity(this.signCityFirst);
/*      */ 
/*  445 */       if (!validate()) {
/*  446 */         this.operateResult = false;
/*  447 */         return;
/*      */       }
/*      */ 
/*  453 */       if (this.infoSource.equals("add"))
/*      */       {
/*  458 */         if (checkInsuredExist(this.contSch.getContNo())) {
/*  459 */           if (modifyInusPeople()) {
/*  460 */             this.message = "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03E2\uFFFD\uFFFD\uFFFD\uFFFD\u0279\uFFFD\uFFFD\uFFFD";
/*  461 */             this.operateResult = true;
/*      */           }
/*      */ 
/*      */         }
/*  465 */         else if (addInusByNewCustomer()) {
/*  466 */           this.message = "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03E2\uFFFD\uFFFD\uFFFD\uFFFD\u0279\uFFFD\uFFFD\uFFFD";
/*  467 */           this.operateResult = true;
/*      */         }
/*      */       }
/*  470 */       else if ((this.infoSource.equals("modify")) && 
/*  471 */         (modifyInusPeople())) {
/*  472 */         this.message = "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03E2\uFFFD\uFFFD\uFFFD\uFFFD\u0279\uFFFD\uFFFD\uFFFD";
/*  473 */         this.operateResult = true;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (RuntimeException e)
/*      */     {
/*  479 */       e.printStackTrace();
/*  480 */       this.message = "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03E2\uFFFD\uFFFD\uFFFD\uFFFD\u02A7\uFFFD\u0723\uFFFD";
/*  481 */       this.operateResult = false;
/*      */     }
/*      */   }
/*      */ 
/*      */   public LNPInsuredSchema getInsuPeopleByContNo(String contNo, String aInsuredId)
/*      */   {
/*  498 */     LNPInsuredDB lnpInsuredDB = new LNPInsuredDB();
/*  499 */     lnpInsuredDB.setContNo(contNo);
/*  500 */     lnpInsuredDB.setInsuredId(aInsuredId);
/*      */ 
/*  502 */     if (lnpInsuredDB.getInfo()) {
/*  503 */       return lnpInsuredDB.getSchema();
/*      */     }
/*  505 */     return null;
/*      */   }
/*      */ 
/*      */   public List getInsuPeopleListByContNo(String aContNo)
/*      */   {
/*  511 */     LNPInsuredDB lnpInsuredDB = new LNPInsuredDB();
/*  512 */     lnpInsuredDB.setContNo(aContNo);
/*      */ 
/*  514 */     LNPInsuredSet lnpInsuredSet = lnpInsuredDB.query();
/*  515 */     List list = new ArrayList();
/*  516 */     if (lnpInsuredSet.size() > 0) {
/*  517 */       list = new ArrayList();
/*  518 */       for (int i = 1; i <= lnpInsuredSet.size(); i++) {
/*  519 */         LNPInsuredSchema temp = lnpInsuredSet.get(i);
/*  520 */         list.add(temp);
/*      */       }
/*      */     }
/*      */ 
/*  524 */     return list;
/*      */   }
/*      */ 
/*      */   public LNPInsuredSchema getOneInsuredPersonInfo(String contNo, String insuredId)
/*      */   {
/*  531 */     LNPInsuredDB saveLSInsuredDB = new LNPInsuredDB();
/*  532 */     saveLSInsuredDB.setContNo(contNo);
/*  533 */     saveLSInsuredDB.setInsuredId(insuredId);
/*      */ 
/*  535 */     if (saveLSInsuredDB.getInfo()) {
/*  536 */       return saveLSInsuredDB.getSchema();
/*      */     }
/*  538 */     return null;
/*      */   }
/*      */ 
/*      */   private boolean addInusByNewCustomer()
/*      */   {
/*  546 */     boolean flag = false;
/*      */ 
/*  549 */     String date = PubFun.getCurrentDate();
/*  550 */     String time = PubFun.getCurrentTime();
/*      */ 
/*  555 */     SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
/*  556 */     this.insuredSchema.setInsuredId(maxNoMap.CreateMaxNo("CustomerNo", ""));
/*      */ 
/*  558 */     LNPContSchema lnpContSch = getMyLNPContByContNo(this.contNo);
/*  559 */     this.insuredSchema.setGrpContNo(lnpContSch.getGrpContNo());
/*  560 */     this.insuredSchema.setPrtNo(lnpContSch.getPrtNo());
/*  561 */     this.insuredSchema.setContNo(lnpContSch.getContNo());
/*  562 */     this.insuredSchema.setProposalContNo(lnpContSch.getProposalContNo());
/*      */ 
/*  564 */     this.insuredSchema.setOperator(this.tempGI.Operator);
/*  565 */     this.insuredSchema.setMakeDate(date);
/*  566 */     this.insuredSchema.setMakeTime(time);
/*  567 */     this.insuredSchema.setModifyDate(date);
/*  568 */     this.insuredSchema.setModifyTime(time);
/*      */ 
/*  571 */     this.lnpPersonSchema.setAgentCode(this.insuredSchema.getOperator());
/*  572 */     this.lnpPersonSchema.setCustomerId(this.insuredSchema.getInsuredId());
/*  573 */     this.lnpPersonSchema.setName(this.insuredSchema.getName());
/*  574 */     this.lnpPersonSchema.setSex(this.insuredSchema.getSex());
/*  575 */     this.lnpPersonSchema.setBirthday(this.insuredSchema.getBirthday());
/*  576 */     this.lnpPersonSchema.setIDType(this.insuredSchema.getIDType());
/*  577 */     this.lnpPersonSchema.setIDNo(this.insuredSchema.getIDNo());
/*  578 */     this.lnpPersonSchema.setNativePlace(this.insuredSchema.getNativePlace());
/*  579 */     this.lnpPersonSchema.setMarriage(this.insuredSchema.getMarriage());
/*  580 */     this.lnpPersonSchema.setOccupationCode(this.insuredSchema.getOccupationCode());
/*      */ 
/*  582 */     this.lnpPersonSchema.setPartOccupationCode(this.insuredSchema.getPartOccupationCode());
/*      */ 
/*  584 */     this.lnpPersonSchema.setAge(this.insuredSchema.getAppAge());
/*  585 */     this.lnpPersonSchema.setIDPerpetual(this.insuredSchema.getIDPerpetual());
/*  586 */     this.lnpPersonSchema.setIDValidity(this.insuredSchema.getIDValidity());
/*      */ 
/*  589 */     this.lnpPersonSchema.setOperator(this.tempGI.Operator);
/*  590 */     this.lnpPersonSchema.setMakeDate(date);
/*  591 */     this.lnpPersonSchema.setMakeTime(time);
/*  592 */     this.lnpPersonSchema.setModifyDate(date);
/*  593 */     this.lnpPersonSchema.setModifyTime(time);
/*      */ 
/*  595 */     this.lnpAddressSchema.setAddressNo(maxNoMap.CreateMaxNo("LNPAddRNo", ""));
/*  596 */     this.lnpAddressSchema.setDuchy(getInsuCity());
/*  597 */     this.lnpAddressSchema.setOtherDuchy(getInsuOtherCity() != null ? getInsuOtherCity() : "");
/*  598 */     this.lnpAddressSchema.setCustomerId(this.insuredSchema.getInsuredId());
/*  599 */     this.lnpAddressSchema.setOperator(this.tempGI.Operator);
/*  600 */     this.lnpAddressSchema.setMakeDate(date);
/*  601 */     this.lnpAddressSchema.setMakeTime(time);
/*  602 */     this.lnpAddressSchema.setModifyDate(date);
/*  603 */     this.lnpAddressSchema.setModifyTime(time);
/*      */ 
/*  605 */     this.insuredSchema.setAddressNo(this.lnpAddressSchema.getAddressNo());
/*      */ 
/*  608 */     lnpContSch.setInsuredId(this.insuredSchema.getInsuredId());
/*  609 */     lnpContSch.setInsuredNo(this.insuredSchema.getInsuredNo());
/*  610 */     lnpContSch.setInsuredName(this.insuredSchema.getName());
/*  611 */     lnpContSch.setInsuredBirthday(this.insuredSchema.getBirthday());
/*  612 */     lnpContSch.setInsuredIDType(this.insuredSchema.getIDType());
/*  613 */     lnpContSch.setInsuredIDNo(this.insuredSchema.getIDNo());
/*  614 */     lnpContSch.setInsuredSex(this.insuredSchema.getSex());
/*      */ 
/*  616 */     StateOperatorDeal operatorDeal = new StateOperatorDeal();
/*  617 */     List stateList = operatorDeal.infoOperate(this.contSch.getState(), this.contSch.getEditstate(), this.infoSource, "02");
/*      */ 
/*  619 */     lnpContSch.setState((String)stateList.get(0));
/*  620 */     lnpContSch.setEditstate((String)stateList.get(1));
/*      */ 
/*  622 */     if ("2".equals(lnpContSch.getUWFlag())) {
/*  623 */       lnpContSch.setUWFlag("1");
/*      */     }
/*      */ 
/*  626 */     lnpContSch.setModifyDate(date);
/*  627 */     lnpContSch.setModifyTime(time);
/*      */ 
/*  630 */     PubSubmit ps = new PubSubmit();
/*  631 */     MMap map = new MMap();
/*      */ 
/*  633 */     map.put(this.insuredSchema, "INSERT");
/*  634 */     map.put(this.lnpPersonSchema, "INSERT");
/*  635 */     map.put(this.lnpAddressSchema, "INSERT");
/*  636 */     map.put(lnpContSch, "UPDATE");
/*      */ 
/*  638 */     VData vd = new VData();
/*  639 */     vd.add(map);
/*  640 */     if (!ps.submitData(vd, "")) {
/*  641 */       this.message = "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03E2\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD";
/*  642 */       flag = false;
/*      */     } else {
/*  644 */       flag = true;
/*      */ 
/*  647 */       operatorDeal.afterAddInsurance(this.contSch.getContNo());
/*      */     }
/*      */ 
/*  652 */     return flag;
/*      */   }
/*      */ 
/*      */   private boolean checkInsuredExist(String contno)
/*      */   {
/*  658 */     LNPInsuredDB saveLSInsuredDB = new LNPInsuredDB();
/*  659 */     String searchsql = "select * from lnpinsured where contno ='" + contno + "'";
/*  660 */     LNPInsuredSet reSet = saveLSInsuredDB.executeQuery(searchsql);
/*      */ 
/*  663 */     return (reSet != null) && (reSet.size() > 0);
/*      */   }
/*      */ 
/*      */   private LNPContSchema getMyLNPContByContNo(String contNo2)
/*      */   {
/*  670 */     PolicyMainInfo mainInfo = new PolicyMainInfo();
/*  671 */     LNPContSchema aLNPContSchema = mainInfo.getContByContNo(contNo2);
/*  672 */     return aLNPContSchema;
/*      */   }
/*      */ 
/*      */   private boolean modifyInusPeople()
/*      */   {
/*      */     boolean flag;
/*      */     try {
/*  680 */       boolean flag = false;
/*  681 */       String date = PubFun.getCurrentDate();
/*  682 */       String time = PubFun.getCurrentTime();
/*      */ 
/*  684 */       String midifyContNo = this.insuredSchema.getContNo();
/*  685 */       String midifyInsuredId = this.insuredSchema.getInsuredId();
/*      */ 
/*  687 */       PubSubmit ps = new PubSubmit();
/*  688 */       MMap map = new MMap();
/*      */ 
/*  690 */       PersonFunction pf = new PersonFunction();
/*      */ 
/*  692 */       LNPInsuredSchema modifyInsuPeopleSchema = getInsuPeopleByContNo(midifyContNo, midifyInsuredId);
/*  693 */       LNPInsuredSchema tempmodifyInsuPeopleSchema = getInsuPeopleByContNo(midifyContNo, midifyInsuredId);
/*      */ 
/*  695 */       LNPAddressSchema modifylnpAddressSchema = pf.getLnpAddrByCustomerId(midifyInsuredId);
/*  696 */       LNPPersonSchema modifylnpPersonSchema = pf.getLnpPersonByCustomerId(midifyInsuredId);
/*  697 */       LNPContSchema lnpContSch = getMyLNPContByContNo(midifyContNo);
/*      */ 
/*  699 */       if ((modifyInsuPeopleSchema != null) && 
/*  700 */         (modifylnpAddressSchema != null) && 
/*  701 */         (modifylnpPersonSchema != null)) {
/*  702 */         System.out.println("-- modifylnpAddressSchema--" + modifylnpAddressSchema.getAddressNo());
/*      */ 
/*  706 */         modifyInsuPeopleSchema.setSignCity(this.insuredSchema
/*  707 */           .getSignCity());
/*  708 */         modifyInsuPeopleSchema.setName(this.insuredSchema.getName());
/*  709 */         modifyInsuPeopleSchema.setSex(this.insuredSchema.getSex());
/*  710 */         modifyInsuPeopleSchema.setBirthday(this.insuredSchema
/*  711 */           .getBirthday());
/*  712 */         modifyInsuPeopleSchema.setAppAge(this.insuredSchema.getAppAge());
/*  713 */         modifyInsuPeopleSchema.setAppAgeType(this.insuredSchema.getAppAgeType());
/*  714 */         modifyInsuPeopleSchema.setIDValidity(this.insuredSchema.getIDValidity());
/*  715 */         modifyInsuPeopleSchema.setIDPerpetual(this.insuredSchema.getIDPerpetual());
/*      */ 
/*  717 */         modifyInsuPeopleSchema.setIDType(this.insuredSchema.getIDType());
/*  718 */         modifyInsuPeopleSchema.setIDNo(this.insuredSchema.getIDNo());
/*  719 */         modifyInsuPeopleSchema.setNativePlace(this.insuredSchema.getNativePlace());
/*  720 */         modifyInsuPeopleSchema.setMarriage(this.insuredSchema.getMarriage());
/*      */ 
/*  722 */         modifyInsuPeopleSchema.setOccupationCode(this.insuredSchema.getOccupationCode());
/*      */ 
/*  724 */         modifyInsuPeopleSchema.setPartOccupationCode(this.insuredSchema.getPartOccupationCode());
/*      */ 
/*  726 */         modifyInsuPeopleSchema.setModifyDate(date);
/*  727 */         modifyInsuPeopleSchema.setModifyTime(time);
/*      */ 
/*  730 */         modifylnpPersonSchema.setName(modifyInsuPeopleSchema.getName());
/*  731 */         modifylnpPersonSchema.setSex(modifyInsuPeopleSchema.getSex());
/*  732 */         modifylnpPersonSchema.setBirthday(modifyInsuPeopleSchema.getBirthday());
/*  733 */         modifylnpPersonSchema.setIDType(modifyInsuPeopleSchema.getIDType());
/*  734 */         modifylnpPersonSchema.setIDNo(modifyInsuPeopleSchema.getIDNo());
/*  735 */         modifylnpPersonSchema.setNativePlace(modifyInsuPeopleSchema.getNativePlace());
/*  736 */         modifylnpPersonSchema.setMarriage(modifyInsuPeopleSchema.getMarriage());
/*  737 */         modifylnpPersonSchema.setOccupationCode(modifyInsuPeopleSchema.getOccupationCode());
/*      */ 
/*  739 */         modifylnpPersonSchema.setAge(modifyInsuPeopleSchema.getAppAge());
/*  740 */         modifylnpPersonSchema.setPartOccupationCode(modifyInsuPeopleSchema.getPartOccupationCode());
/*      */ 
/*  742 */         modifylnpPersonSchema.setAgeType(modifyInsuPeopleSchema.getAppAgeType());
/*  743 */         modifylnpPersonSchema.setIDPerpetual(modifyInsuPeopleSchema.getIDPerpetual());
/*  744 */         modifylnpPersonSchema.setIDValidity(modifyInsuPeopleSchema.getIDValidity());
/*      */ 
/*  748 */         modifylnpPersonSchema.setModifyDate(date);
/*  749 */         modifylnpPersonSchema.setModifyTime(time);
/*      */ 
/*  752 */         modifylnpAddressSchema.setGrpName(this.lnpAddressSchema.getGrpName());
/*  753 */         modifylnpAddressSchema.setPostalAddress(this.lnpAddressSchema.getPostalAddress());
/*  754 */         modifylnpAddressSchema.setZipCode(this.lnpAddressSchema.getZipCode());
/*  755 */         modifylnpAddressSchema.setPhone(this.lnpAddressSchema.getPhone());
/*  756 */         modifylnpAddressSchema.setHomeAddress(this.lnpAddressSchema.getHomeAddress());
/*  757 */         modifylnpAddressSchema.setHomeZipCode(this.lnpAddressSchema.getHomeZipCode());
/*  758 */         modifylnpAddressSchema.setHomePhone(this.lnpAddressSchema.getHomePhone());
/*  759 */         modifylnpAddressSchema.setCompanyAddress(this.lnpAddressSchema.getCompanyAddress());
/*  760 */         modifylnpAddressSchema.setCompanyPhone(this.lnpAddressSchema.getCompanyPhone());
/*  761 */         modifylnpAddressSchema.setCompanyMail(this.lnpAddressSchema.getCompanyMail());
/*  762 */         modifylnpAddressSchema.setCompanyZipCode(this.lnpAddressSchema.getCompanyZipCode());
/*  763 */         modifylnpAddressSchema.setDuchy(getInsuCity());
/*  764 */         modifylnpAddressSchema.setOtherDuchy(getInsuOtherCity() != null ? getInsuOtherCity() : "");
/*      */ 
/*  766 */         modifylnpAddressSchema.setModifyDate(date);
/*  767 */         modifylnpAddressSchema.setModifyTime(time);
/*      */ 
/*  771 */         lnpContSch.setInsuredId(this.insuredSchema.getInsuredId());
/*  772 */         lnpContSch.setInsuredNo(this.insuredSchema.getInsuredNo());
/*  773 */         lnpContSch.setInsuredName(this.insuredSchema.getName());
/*  774 */         lnpContSch.setInsuredBirthday(this.insuredSchema.getBirthday());
/*  775 */         lnpContSch.setInsuredIDType(this.insuredSchema.getIDType());
/*  776 */         lnpContSch.setInsuredIDNo(this.insuredSchema.getIDNo());
/*  777 */         lnpContSch.setInsuredSex(this.insuredSchema.getSex());
/*      */ 
/*  779 */         StateOperatorDeal operatorDeal = new StateOperatorDeal();
/*  780 */         List stateList = operatorDeal.infoOperate(this.contSch.getState(), this.contSch.getEditstate(), this.infoSource, "02");
/*      */ 
/*  782 */         lnpContSch.setState((String)stateList.get(0));
/*  783 */         lnpContSch.setEditstate((String)stateList.get(1));
/*      */ 
/*  786 */         if ("2".equals(lnpContSch.getUWFlag())) {
/*  787 */           lnpContSch.setUWFlag("1");
/*      */         }
/*  789 */         lnpContSch.setModifyDate(date);
/*  790 */         lnpContSch.setModifyTime(time);
/*      */ 
/*  792 */         map.put(modifyInsuPeopleSchema, "UPDATE");
/*  793 */         map.put(modifylnpPersonSchema, "UPDATE");
/*  794 */         map.put(modifylnpAddressSchema, "UPDATE");
/*  795 */         map.put(lnpContSch, "UPDATE");
/*      */       } else {
/*  797 */         this.message = "\uFFFD\uFFFD\u077F\uFFFD\uFFFD\uFFFD\u03B4\uFFFD\uFFFD\u046F\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03E2\uFFFD\uFFFD";
/*      */       }
/*      */ 
/*  800 */       VData vd = new VData();
/*  801 */       vd.add(map);
/*  802 */       if (!ps.submitData(vd, "")) {
/*  803 */         this.message = "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03E2\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD";
/*  804 */         flag = false;
/*      */       } else {
/*  806 */         flag = true;
/*  807 */         boolean mflag = afterupdateInsured(this.contNo);
/*  808 */         StateOperatorDeal operatorDeal = new StateOperatorDeal();
/*  809 */         boolean checkSpelFlag = checkSpelKeyChange(tempmodifyInsuPeopleSchema, this.insuredSchema.getName(), this.insuredSchema.getSex(), 
/*  810 */           this.insuredSchema.getBirthday(), this.insuredSchema.getOccupationCode(), this.insuredSchema.getAppAge(), this.insuredSchema.getAppAgeType(), this.insuredSchema.getNativePlace());
/*  811 */         boolean ageChangeToJuvenilesFlag = checkAgeChangeToJuveniles(tempmodifyInsuPeopleSchema, this.insuredSchema.getAppAge(), this.insuredSchema.getAppAgeType());
/*  812 */         boolean bool1 = operatorDeal.afterModifyInsurance(lnpContSch.getContNo(), checkSpelFlag, ageChangeToJuvenilesFlag);
/*      */       }
/*      */     }
/*      */     catch (RuntimeException e)
/*      */     {
/*  817 */       e.printStackTrace();
/*  818 */       this.message = "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03E2\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD";
/*  819 */       flag = false;
/*      */     }
/*  821 */     return flag;
/*      */   }
/*      */ 
/*      */   private boolean afterupdateInsured(String contno)
/*      */   {
/*  827 */     System.out.println("-----\uFFFD\u0431?\uFFFD\uFFFD \uFFFD\u07B8\u0131\uFFFD\uFFFD\uFFFD\uFFFD\u02F9\uFFFD\uFFFD \u027E\uFFFD\uFFFD\u02F1\uFFFD\uFFFD\uFFFD\uFFFD\u06F6\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD ----");
/*  828 */     boolean flag = false;
/*      */     try {
/*  830 */       PubSubmit ps = new PubSubmit();
/*  831 */       MMap mmap = new MMap();
/*      */ 
/*  833 */       LNPUWQuestionDB queDB = new LNPUWQuestionDB();
/*      */ 
/*  835 */       String sql = "select * from LNPUWQuestion where contno='" + contno + "'";
/*  836 */       LNPUWQuestionSet queSet = queDB.executeQuery(sql);
/*  837 */       if ((queSet != null) && (queSet.size() > 0)) {
/*  838 */         mmap.put(queSet, "DELETE");
/*      */       }
/*  840 */       PolicyMainInfo mainInfo = new PolicyMainInfo();
/*  841 */       LNPContSchema tLNPContSchema = mainInfo.getContByContNo(contno);
/*  842 */       if ("2".equals(tLNPContSchema.getUWFlag())) {
/*  843 */         tLNPContSchema.setUWFlag("1");
/*      */       }
/*      */ 
/*  847 */       tLNPContSchema.setApproveFlag("0");
/*  848 */       mmap.put(tLNPContSchema, "UPDATE");
/*      */ 
/*  850 */       VData vd = new VData();
/*  851 */       vd.add(mmap);
/*      */ 
/*  853 */       if (!ps.submitData(vd, ""))
/*  854 */         flag = false;
/*      */       else
/*  856 */         flag = true;
/*      */     }
/*      */     catch (RuntimeException e)
/*      */     {
/*  860 */       e.printStackTrace();
/*      */     }
/*      */ 
/*  863 */     return flag;
/*      */   }
/*      */ 
/*      */   private boolean checkAgeChangeToJuveniles(LNPInsuredSchema tempmodifyInsuPeopleSchema, int appAge, String appAgeType)
/*      */   {
/*  869 */     boolean flag = false;
/*      */ 
/*  871 */     String relationToInsured = "";
/*  872 */     String sql = "select relationtoinsured from lnpappnt where contno='" + tempmodifyInsuPeopleSchema.getContNo() + "'";
/*  873 */     ExeSQL tExeSQL = new ExeSQL();
/*  874 */     SSRS tSSRS = tExeSQL.execSQL(sql);
/*  875 */     if ((tSSRS != null) && (tSSRS.getMaxRow() > 0))
/*      */     {
/*  877 */       relationToInsured = tSSRS.GetText(1, 1);
/*      */     }
/*  879 */     else return flag;
/*      */ 
/*  883 */     if ("D".equals(tempmodifyInsuPeopleSchema.getAppAgeType())) {
/*  884 */       flag = false;
/*      */     }
/*      */ 
/*  907 */     if ("Y".equals(tempmodifyInsuPeopleSchema.getAppAgeType()))
/*      */     {
/*  909 */       if (tempmodifyInsuPeopleSchema.getAppAge() >= 16)
/*      */       {
/*  911 */         if ((("D".equals(appAgeType)) || (("Y".equals(appAgeType)) && (appAge < 16))) && ("0".equals(relationToInsured))) {
/*  912 */           flag = true;
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  918 */     return flag;
/*      */   }
/*      */ 
/*      */   private boolean checkSpelKeyChange(LNPInsuredSchema modifyInsuPeopleSchema, String name, String sex2, String birthday, String occupationCode2, int age, String ageType, String navition)
/*      */   {
/*  924 */     boolean ageflag = checkAgeChange(age, ageType, modifyInsuPeopleSchema.getAppAge(), modifyInsuPeopleSchema.getAppAgeType());
/*      */ 
/*  929 */     boolean nameflag = name.equals(modifyInsuPeopleSchema.getName() != null ? modifyInsuPeopleSchema.getName() : "");
/*  930 */     boolean birthdayflag = birthday.equals(modifyInsuPeopleSchema.getBirthday() != null ? modifyInsuPeopleSchema.getBirthday() : "");
/*  931 */     boolean occflag = occupationCode2.equals(modifyInsuPeopleSchema.getOccupationCode() != null ? modifyInsuPeopleSchema.getOccupationCode() : "");
/*  932 */     boolean sexflag = sex2.equals(modifyInsuPeopleSchema.getSex() != null ? modifyInsuPeopleSchema.getSex() : "");
/*  933 */     boolean navation = navition.equals(modifyInsuPeopleSchema.getNativePlace() != null ? modifyInsuPeopleSchema.getNativePlace() : "");
/*      */ 
/*  941 */     return (!nameflag) || (!sexflag) || (!birthdayflag) || (!occflag) || (!ageflag) || (!navation);
/*      */   }
/*      */ 
/*      */   private List<SelectItem> doSignCityListValue()
/*      */   {
/*  949 */     List list = new ArrayList();
/*      */     try {
/*  951 */       if ((this.operType != null) && (this.contNo != null)) {
/*  952 */         ExeSQL tExeSQL = new ExeSQL();
/*  953 */         String sql = "";
/*  954 */         SSRS tSRS = new SSRS();
/*  955 */         if (this.operType.equals("1")) {
/*  956 */           sql = "select code,codename from lnpcode  where codetype='signcity'  and codealias ='" + 
/*  958 */             this.contNo.substring(0, 2) + "' " + 
/*  959 */             " order by othersign ";
/*  960 */           tSRS = tExeSQL.execSQL(sql);
/*      */         } else {
/*  962 */           sql = "select code,codename from lnpcode  where codetype='signcity'  and codealias ='" + 
/*  964 */             this.contNo.substring(0, 2) + "' " + 
/*  965 */             " order by othersign ";
/*  966 */           tSRS = tExeSQL.execSQL(sql);
/*      */         }
/*  968 */         if ((tSRS != null) && (tSRS.MaxRow > 0))
/*  969 */           for (int i = 1; i <= tSRS.MaxRow; i++)
/*  970 */             list.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*      */       }
/*      */     }
/*      */     catch (RuntimeException e)
/*      */     {
/*  975 */       e.printStackTrace();
/*      */     }
/*  977 */     return list;
/*      */   }
/*      */ 
/*      */   private boolean checkAgeChange(int age2, String ageType, int appAge, String appAgeType)
/*      */   {
/*  986 */     if (ageType.equals("Y"))
/*      */     {
/*  988 */       return appAge == age2;
/*      */     }
/*      */ 
/*  992 */     if (ageType.equals("D"))
/*      */     {
/*  994 */       return (appAge == 0) && (appAgeType.equals("Y"));
/*      */     }
/*      */ 
/* 1001 */     return false;
/*      */   }
/*      */ 
/*      */   public void getAgeByBirthday()
/*      */   {
/* 1006 */     this.reAge = "-1";
/*      */     try {
/* 1008 */       this.reAge = LNPPubFun.getAgeByBirthdayNew(this.birthday, this.contSch.getPValiDate());
/*      */     }
/*      */     catch (RuntimeException e) {
/* 1011 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   public String getReAge()
/*      */   {
/* 1018 */     return this.reAge;
/*      */   }
/*      */ 
/*      */   public void setReAge(String reAge)
/*      */   {
/* 1023 */     this.reAge = reAge;
/*      */   }
/*      */ 
/*      */   private boolean validate()
/*      */   {
/* 1031 */     if ((this.insuredSchema.getName() == null) || 
/* 1032 */       (this.insuredSchema.getName().equals("")))
/*      */     {
/* 1034 */       this.message = "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 1035 */       return false;
/*      */     }
/* 1037 */     if (!ValidateTools.isValidString1(this.insuredSchema.getName())) {
/* 1038 */       this.message = "\uFFFD\uBC34\uFFFD\uFFFD\uFFFD\uFFFD\u0237\uFFFD\uFFFD\u02BD\u00BC\uFFFD\uBC7B\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD";
/* 1039 */       this.insuredSchema.setName("");
/* 1040 */       return false;
/*      */     }
/*      */ 
/* 1044 */     if ((this.insuredSchema.getSex() == null) || 
/* 1045 */       (this.insuredSchema.getSex().equals("-1")) || 
/* 1046 */       (this.insuredSchema.getSex().equals("")))
/*      */     {
/* 1048 */       this.message = "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0531\uFFFD\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 1049 */       return false;
/*      */     }
/*      */ 
/* 1052 */     if ((this.insuredSchema.getBirthday() == null) || 
/* 1053 */       (this.insuredSchema.getBirthday().equals("")))
/*      */     {
/* 1055 */       this.message = "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u06B2\uFFFD\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 1056 */       return false;
/*      */     }
/*      */ 
/* 1059 */     if ((this.insuredSchema.getBirthday() == null) || 
/* 1060 */       (this.insuredSchema.getBirthday().equals("")))
/*      */     {
/* 1062 */       this.message = "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u4CBB\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 1063 */       return false;
/*      */     }
/* 1065 */     if ((this.insuredSchema.getMarriage() == null) || 
/* 1066 */       (this.insuredSchema.getMarriage().equals("-1")) || 
/* 1067 */       (this.insuredSchema.getMarriage().equals("")))
/*      */     {
/* 1069 */       this.message = "\uFFFD\uFFFD\uFFFD\uFFFD\u05F4\uFFFD\uFFFD\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 1070 */       return false;
/*      */     }
/* 1072 */     if ((this.insuredSchema.getNativePlace() == null) || 
/* 1073 */       (this.insuredSchema.getNativePlace().equals("-1")) || 
/* 1074 */       (this.insuredSchema.getNativePlace().equals("")))
/*      */     {
/* 1076 */       this.message = "\uFFFD\uFFFD\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 1077 */       return false;
/*      */     }
/* 1079 */     if ((this.insuredSchema.getIDType() == null) || 
/* 1080 */       (this.insuredSchema.getIDType().equals("-1")) || 
/* 1081 */       (this.insuredSchema.getIDType().equals("")))
/*      */     {
/* 1083 */       this.message = "\u05A4\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0372\uFFFD\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 1084 */       return false;
/*      */     }
/* 1086 */     if ((this.insuredSchema.getIDNo() == null) || 
/* 1087 */       (this.insuredSchema.getIDNo().equals("")))
/*      */     {
/* 1089 */       this.message = "\u05A4\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uBCBB\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 1090 */       return false;
/*      */     }
/*      */ 
/* 1094 */     if (this.insuredSchema.getIDType().equals("1")) {
/* 1095 */       String returnString = ValidateTools.isValidIDNo(this.insuredSchema
/* 1096 */         .getIDNo(), this.insuredSchema.getBirthday(), 
/* 1097 */         this.insuredSchema.getSex());
/* 1098 */       if (!returnString.equals("")) {
/* 1099 */         this.message = returnString;
/* 1100 */         this.insuredSchema.setIDNo("");
/* 1101 */         return false;
/*      */       }
/*      */     }
/*      */ 
/* 1105 */     if ((this.insuredSchema.getIDPerpetual().equals("0")) && (
/* 1106 */       (this.insuredSchema.getIDValidity() == null) || (this.insuredSchema.getIDValidity().equals("")))) {
/* 1107 */       this.message = "\u05A4\uFFFD\uFFFD\uFFFD\uFFFD\u0427\uFFFD\uFFFD\uFFFD\u06B2\uFFFD\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 1108 */       return false;
/*      */     }
/*      */ 
/* 1116 */     if ((this.insuredSchema.getOccupationCode() == null) || 
/* 1117 */       (this.insuredSchema.getOccupationCode().equals("")))
/*      */     {
/* 1119 */       this.message = "\u05B0\u04B5\uFFFD\uFFFD\uFFFD\uBCBB\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 1120 */       return false;
/*      */     }
/*      */ 
/* 1123 */     if ((this.insuredSchema.getSignCity() == null) || 
/* 1124 */       (this.insuredSchema.getSignCity().equals("-1")) || 
/* 1125 */       (this.insuredSchema.getSignCity().equals("")))
/*      */     {
/* 1127 */       this.message = "\u01E9\uFFFD\uFFFD\u0632\uFFFD\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 1128 */       return false;
/*      */     }
/*      */ 
/* 1131 */     System.out.println("---- \u0423\uFFFD\uFFFD\u03AA\uFFFD\uFFFD lnpAddressSchema  --" + this.lnpAddressSchema);
/* 1132 */     System.out.println("---- \u0423\uFFFD\uFFFD\u03AA\uFFFD\uFFFD lnpAddressSchema getPostalAddress --" + this.lnpAddressSchema.getPostalAddress());
/*      */ 
/* 1134 */     if ((this.lnpAddressSchema.getPostalAddress() == null) || 
/* 1135 */       (this.lnpAddressSchema.getPostalAddress().equals("")))
/*      */     {
/* 1137 */       this.message = "\uFFFD\u0577\u0475\uFFFD\u05B7\uFFFD\uFFFD\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 1138 */       return false;
/*      */     }
/*      */ 
/* 1141 */     if ((this.lnpAddressSchema.getPhone() == null) || 
/* 1142 */       (this.lnpAddressSchema.getPhone().equals("")))
/*      */     {
/* 1144 */       this.message = "\uFFFD\u0577\u0475\u7EF0\uFFFD\uFFFD\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 1145 */       return false;
/*      */     }
/* 1147 */     if ((this.lnpAddressSchema.getZipCode() == null) || 
/* 1148 */       (this.lnpAddressSchema.getZipCode().equals("")))
/*      */     {
/* 1150 */       this.message = "\uFFFD\u0577\uFFFD\uFFFD\u02B1\u0CBB\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 1151 */       return false;
/*      */     }
/*      */ 
/* 1154 */     if ((this.lnpAddressSchema.getGrpName() != null) && 
/* 1155 */       (!this.lnpAddressSchema.getGrpName().equals("")) && 
/* 1156 */       (!ValidateTools.isValidString3(this.lnpAddressSchema.getGrpName()))) {
/* 1157 */       this.message = "\uFFFD\uBC34\uFFFD\uFFFD\uFFFD\uFFFD\u0237\uFFFD\uFFFD\u02BD\u00BC\uFFFD\uBE64\uFFFD\uFFFD\u03BB\uFFFD\uFFFD";
/* 1158 */       this.lnpAddressSchema.setGrpName("");
/* 1159 */       return false;
/*      */     }
/*      */ 
/* 1163 */     if ((this.lnpAddressSchema.getCompanyZipCode() != null) && 
/* 1164 */       (!this.lnpAddressSchema.getCompanyZipCode().equals("")))
/*      */     {
/* 1166 */       if (!ValidateTools.isValidZipCode(this.lnpAddressSchema
/* 1166 */         .getCompanyZipCode())) {
/* 1167 */         this.message = "\uFFFD\uBC34\uFFFD\uFFFD\uFFFD\uFFFD\u0237\uFFFD\uFFFD\u02BD\u00BC\uFFFD\uBD65\u03BB\uFFFD\u02B1\u08E1";
/* 1168 */         this.lnpAddressSchema.setCompanyZipCode("");
/* 1169 */         return false;
/*      */       }
/*      */     }
/*      */ 
/* 1173 */     if ((this.lnpAddressSchema.getCompanyAddress() != null) && 
/* 1174 */       (!this.lnpAddressSchema.getCompanyAddress().equals("")))
/*      */     {
/* 1176 */       if (!ValidateTools.isValidString3(this.lnpAddressSchema
/* 1176 */         .getCompanyAddress())) {
/* 1177 */         this.message = "\uFFFD\uBC34\uFFFD\uFFFD\uFFFD\uFFFD\u0237\uFFFD\uFFFD\u02BD\u00BC\uFFFD\uBD65\u03BB\uFFFD\uFFFD\u05B7\uFFFD\uFFFD";
/* 1178 */         this.lnpAddressSchema.setCompanyAddress("");
/* 1179 */         return false;
/*      */       }
/*      */     }
/*      */ 
/* 1183 */     if ((this.lnpAddressSchema.getCompanyMail() != null) && 
/* 1184 */       (!this.lnpAddressSchema.getCompanyMail().equals("")))
/*      */     {
/* 1186 */       if (!ValidateTools.isValidString4(this.lnpAddressSchema
/* 1186 */         .getCompanyMail())) {
/* 1187 */         this.message = "\uFFFD\uBC34\uFFFD\uFFFD\uFFFD\uFFFD\u0237\uFFFD\uFFFD\u02BD\u00BC\uFFFD\uBD65\u03BB\uFFFD\uFFFD\uFFFD\u02A3\uFFFD";
/* 1188 */         this.lnpAddressSchema.setCompanyMail("");
/* 1189 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1196 */     if ((this.lnpAddressSchema.getHomeAddress() != null) && 
/* 1197 */       (!this.lnpAddressSchema.getHomeAddress().equals("")))
/*      */     {
/* 1199 */       if (!ValidateTools.isValidString3(this.lnpAddressSchema.getHomeAddress())) {
/* 1200 */         this.message = "\uFFFD\uBC34\uFFFD\uFFFD\uFFFD\uFFFD\u0237\uFFFD\uFFFD\u02BD\u00BC\uFFFD\uFFFD\u05E1\u05B7\uFFFD\uFFFD";
/* 1201 */         this.lnpAddressSchema.setHomeAddress("");
/* 1202 */         return false;
/*      */       }
/*      */     }
/*      */ 
/* 1206 */     if ((this.lnpAddressSchema.getHomeZipCode() != null) && 
/* 1207 */       (!this.lnpAddressSchema.getHomeZipCode().equals("")))
/*      */     {
/* 1209 */       if (!ValidateTools.isValidZipCode(this.lnpAddressSchema.getHomeZipCode())) {
/* 1210 */         this.message = "\uFFFD\uBC34\uFFFD\uFFFD\uFFFD\uFFFD\u0237\uFFFD\uFFFD\u02BD\u00BC\uFFFD\uFFFD\uFFFD\u02B1\u08E1";
/* 1211 */         this.lnpAddressSchema.setHomeZipCode("");
/* 1212 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1220 */     if ((this.lnpAddressSchema.getPostalAddress() != null) && 
/* 1221 */       (!this.lnpAddressSchema.getPostalAddress().equals("")))
/*      */     {
/* 1223 */       if (!ValidateTools.isValidString3(this.lnpAddressSchema
/* 1223 */         .getPostalAddress())) {
/* 1224 */         this.message = "\uFFFD\uBC34\uFFFD\uFFFD\uFFFD\uFFFD\u0237\uFFFD\uFFFD\u02BD\u00BC\uFFFD\uFFFD\uFFFD\u0577\u0475\uFFFD\u05B7\uFFFD\uFFFD";
/* 1225 */         this.lnpAddressSchema.setPostalAddress("");
/* 1226 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1232 */     if ((this.lnpAddressSchema.getZipCode() != null) && 
/* 1233 */       (!this.lnpAddressSchema.getZipCode().equals("")) && 
/* 1234 */       (!ValidateTools.isValidZipCode(this.lnpAddressSchema.getZipCode()))) {
/* 1235 */       this.message = "\uFFFD\uBC34\uFFFD\uFFFD\uFFFD\uFFFD\u0237\uFFFD\uFFFD\u02BD\u00BC\uFFFD\uFFFD\uFFFD\u0577\uFFFD\uFFFD\u02B1\u08E1";
/* 1236 */       this.lnpAddressSchema.setZipCode("");
/* 1237 */       return false;
/*      */     }
/*      */ 
/* 1242 */     return true;
/*      */   }
/*      */ 
/*      */   public LNPAddressSchema getLnpAddressSchema() {
/* 1246 */     return this.lnpAddressSchema;
/*      */   }
/*      */ 
/*      */   public void setLnpAddressSchema(LNPAddressSchema lnpAddressSchema) {
/* 1250 */     this.lnpAddressSchema = lnpAddressSchema;
/*      */   }
/*      */ 
/*      */   public LNPPersonSchema getLnpPersonSchema() {
/* 1254 */     return this.lnpPersonSchema;
/*      */   }
/*      */ 
/*      */   public void setLnpPersonSchema(LNPPersonSchema lnpPersonSchema) {
/* 1258 */     this.lnpPersonSchema = lnpPersonSchema;
/*      */   }
/*      */ 
/*      */   public LNPInsuredSchema getInsuredSchema() {
/* 1262 */     return this.insuredSchema;
/*      */   }
/*      */ 
/*      */   public void setInsuredSchema(LNPInsuredSchema insuredSchema) {
/* 1266 */     this.insuredSchema = insuredSchema;
/*      */   }
/*      */ 
/*      */   public String getMessage() {
/* 1270 */     return this.message;
/*      */   }
/*      */ 
/*      */   public void setMessage(String message) {
/* 1274 */     this.message = message;
/*      */   }
/*      */ 
/*      */   public String getIdType() {
/* 1278 */     return this.idType;
/*      */   }
/*      */ 
/*      */   public void setIdType(String idType) {
/* 1282 */     this.idType = idType;
/*      */   }
/*      */ 
/*      */   public String getInsuNative() {
/* 1286 */     return this.insuNative;
/*      */   }
/*      */ 
/*      */   public void setInsuNative(String insuNative) {
/* 1290 */     this.insuNative = insuNative;
/*      */   }
/*      */ 
/*      */   public String getInsuCity() {
/* 1294 */     return this.insuCity;
/*      */   }
/*      */ 
/*      */   public void setInsuCity(String insuCity)
/*      */   {
/* 1299 */     this.insuCity = insuCity;
/*      */   }
/*      */ 
/*      */   public String getMarriage()
/*      */   {
/* 1304 */     return this.marriage;
/*      */   }
/*      */ 
/*      */   public void setMarriage(String marriage) {
/* 1308 */     this.marriage = marriage;
/*      */   }
/*      */ 
/*      */   public String getSex() {
/* 1312 */     return this.sex;
/*      */   }
/*      */ 
/*      */   public void setSex(String sex) {
/* 1316 */     this.sex = sex;
/*      */   }
/*      */ 
/*      */   public String getSignCityFirst() {
/* 1320 */     return this.signCityFirst;
/*      */   }
/*      */ 
/*      */   public void setSignCityFirst(String signCityFirst) {
/* 1324 */     this.signCityFirst = signCityFirst;
/*      */   }
/*      */ 
/*      */   public boolean isOperateResult() {
/* 1328 */     return this.operateResult;
/*      */   }
/*      */ 
/*      */   public void setOperateResult(boolean operateResult) {
/* 1332 */     this.operateResult = operateResult;
/*      */   }
/*      */ 
/*      */   public boolean isEditFlag() {
/* 1336 */     return this.editFlag;
/*      */   }
/*      */ 
/*      */   public void setEditFlag(boolean editFlag) {
/* 1340 */     this.editFlag = editFlag;
/*      */   }
/*      */ 
/*      */   public String getContNo() {
/* 1344 */     return this.contNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String contNo) {
/* 1348 */     this.contNo = contNo;
/*      */   }
/*      */ 
/*      */   public String getIdPerpetual() {
/* 1352 */     return this.idPerpetual;
/*      */   }
/*      */ 
/*      */   public void setIdPerpetual(String idPerpetual) {
/* 1356 */     this.idPerpetual = idPerpetual;
/*      */   }
/*      */ 
/*      */   public String getAge()
/*      */   {
/* 1361 */     return this.age;
/*      */   }
/*      */ 
/*      */   public void setAge(String age)
/*      */   {
/* 1366 */     this.age = age;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getSignCityList()
/*      */   {
/* 1372 */     if (this.signCityList != null) {
/* 1373 */       this.signCityList.clear();
/*      */     }
/* 1375 */     this.signCityList = doSignCityListValue();
/* 1376 */     return this.signCityList;
/*      */   }
/*      */ 
/*      */   public void setSignCityList(List<SelectItem> signCityList)
/*      */   {
/* 1382 */     this.signCityList = signCityList;
/*      */   }
/*      */ 
/*      */   public String getCompanyAddress()
/*      */   {
/* 1388 */     return this.companyAddress;
/*      */   }
/*      */ 
/*      */   public void setCompanyAddress(String companyAddress)
/*      */   {
/* 1393 */     this.companyAddress = companyAddress;
/*      */   }
/*      */ 
/*      */   public String getCompanyMail()
/*      */   {
/* 1398 */     return this.companyMail;
/*      */   }
/*      */ 
/*      */   public void setCompanyMail(String companyMail)
/*      */   {
/* 1403 */     this.companyMail = companyMail;
/*      */   }
/*      */ 
/*      */   public String getCompanyPhone()
/*      */   {
/* 1408 */     return this.companyPhone;
/*      */   }
/*      */ 
/*      */   public void setCompanyPhone(String companyPhone)
/*      */   {
/* 1413 */     this.companyPhone = companyPhone;
/*      */   }
/*      */ 
/*      */   public String getCompanyZipCode()
/*      */   {
/* 1418 */     return this.companyZipCode;
/*      */   }
/*      */ 
/*      */   public void setCompanyZipCode(String companyZipCode)
/*      */   {
/* 1423 */     this.companyZipCode = companyZipCode;
/*      */   }
/*      */ 
/*      */   public String getGrpName()
/*      */   {
/* 1428 */     return this.grpName;
/*      */   }
/*      */ 
/*      */   public void setGrpName(String grpName)
/*      */   {
/* 1433 */     this.grpName = grpName;
/*      */   }
/*      */ 
/*      */   public String getHomeAddress()
/*      */   {
/* 1438 */     return this.homeAddress;
/*      */   }
/*      */ 
/*      */   public void setHomeAddress(String homeAddress)
/*      */   {
/* 1443 */     this.homeAddress = homeAddress;
/*      */   }
/*      */ 
/*      */   public String getHomePhone()
/*      */   {
/* 1448 */     return this.homePhone;
/*      */   }
/*      */ 
/*      */   public void setHomePhone(String homePhone)
/*      */   {
/* 1453 */     this.homePhone = homePhone;
/*      */   }
/*      */ 
/*      */   public String getHomeZipCode()
/*      */   {
/* 1458 */     return this.homeZipCode;
/*      */   }
/*      */ 
/*      */   public void setHomeZipCode(String homeZipCode)
/*      */   {
/* 1463 */     this.homeZipCode = homeZipCode;
/*      */   }
/*      */ 
/*      */   public String getPhone()
/*      */   {
/* 1468 */     return this.phone;
/*      */   }
/*      */ 
/*      */   public void setPhone(String phone)
/*      */   {
/* 1473 */     this.phone = phone;
/*      */   }
/*      */ 
/*      */   public String getPostalAddress()
/*      */   {
/* 1479 */     return this.postalAddress;
/*      */   }
/*      */ 
/*      */   public void setPostalAddress(String postalAddress)
/*      */   {
/* 1484 */     System.out.println("--  set setPostalAddress---" + postalAddress);
/*      */ 
/* 1486 */     this.postalAddress = postalAddress;
/*      */   }
/*      */ 
/*      */   public String getZipCode()
/*      */   {
/* 1491 */     return this.zipCode;
/*      */   }
/*      */ 
/*      */   public void setZipCode(String zipCode)
/*      */   {
/* 1496 */     this.zipCode = zipCode;
/*      */   }
/*      */ 
/*      */   public String getBirthday()
/*      */   {
/* 1501 */     return this.birthday;
/*      */   }
/*      */ 
/*      */   public void setBirthday(String birthday)
/*      */   {
/* 1506 */     this.birthday = birthday;
/*      */   }
/*      */ 
/*      */   public String getIDNo()
/*      */   {
/* 1511 */     return this.IDNo;
/*      */   }
/*      */ 
/*      */   public void setIDNo(String no)
/*      */   {
/* 1516 */     this.IDNo = no;
/*      */   }
/*      */ 
/*      */   public String getIDValidity()
/*      */   {
/* 1521 */     return this.IDValidity;
/*      */   }
/*      */ 
/*      */   public void setIDValidity(String validity)
/*      */   {
/* 1526 */     this.IDValidity = validity;
/*      */   }
/*      */ 
/*      */   public String getInsuredId()
/*      */   {
/* 1531 */     return this.insuredId;
/*      */   }
/*      */ 
/*      */   public void setInsuredId(String insuredId)
/*      */   {
/* 1536 */     this.insuredId = insuredId;
/*      */   }
/*      */ 
/*      */   public String getName()
/*      */   {
/* 1541 */     return this.name;
/*      */   }
/*      */ 
/*      */   public void setName(String name)
/*      */   {
/* 1546 */     this.name = name;
/*      */   }
/*      */ 
/*      */   public String getOccupationCode()
/*      */   {
/* 1551 */     return this.occupationCode;
/*      */   }
/*      */ 
/*      */   public void setOccupationCode(String occupationCode)
/*      */   {
/* 1556 */     this.occupationCode = occupationCode;
/*      */   }
/*      */ 
/*      */   public String getPartOccupationCode()
/*      */   {
/* 1561 */     return this.partOccupationCode;
/*      */   }
/*      */ 
/*      */   public void setPartOccupationCode(String partOccupationCode)
/*      */   {
/* 1566 */     this.partOccupationCode = partOccupationCode;
/*      */   }
/*      */ 
/*      */   public String getOccupationName() {
/* 1570 */     return this.occupationName;
/*      */   }
/*      */ 
/*      */   public void setOccupationName(String occupationName) {
/* 1574 */     this.occupationName = occupationName;
/*      */   }
/*      */ 
/*      */   public String getPartOccupationName() {
/* 1578 */     return this.partOccupationName;
/*      */   }
/*      */ 
/*      */   public void setPartOccupationName(String partOccupationName) {
/* 1582 */     this.partOccupationName = partOccupationName;
/*      */   }
/*      */ 
/*      */   public String getInsuOtherCity() {
/* 1586 */     return this.insuOtherCity;
/*      */   }
/*      */ 
/*      */   public void setInsuOtherCity(String insuOtherCity) {
/* 1590 */     this.insuOtherCity = insuOtherCity;
/*      */   }
/*      */ 
/*      */   public String getNameHidden() {
/* 1594 */     return this.nameHidden;
/*      */   }
/*      */ 
/*      */   public void setNameHidden(String nameHidden) {
/* 1598 */     this.nameHidden = nameHidden;
/*      */   }
/*      */ 
/*      */   public String getBirthdayHidden() {
/* 1602 */     return this.birthdayHidden;
/*      */   }
/*      */ 
/*      */   public void setBirthdayHidden(String birthdayHidden) {
/* 1606 */     this.birthdayHidden = birthdayHidden;
/*      */   }
/*      */ 
/*      */   public String getSexHidden() {
/* 1610 */     return this.sexHidden;
/*      */   }
/*      */ 
/*      */   public void setSexHidden(String sexHidden) {
/* 1614 */     this.sexHidden = sexHidden;
/*      */   }
/*      */ 
/*      */   public String getOccupationCodeHidden() {
/* 1618 */     return this.occupationCodeHidden;
/*      */   }
/*      */ 
/*      */   public void setOccupationCodeHidden(String occupationCodeHidden) {
/* 1622 */     this.occupationCodeHidden = occupationCodeHidden;
/*      */   }
/*      */ 
/*      */   public boolean isHasPolTag() {
/* 1626 */     return this.hasPolTag;
/*      */   }
/*      */ 
/*      */   public void setHasPolTag(boolean hasPolTag) {
/* 1630 */     this.hasPolTag = hasPolTag;
/*      */   }
/*      */ 
/*      */   public String getInsuNativeHidden() {
/* 1634 */     return this.insuNativeHidden;
/*      */   }
/*      */ 
/*      */   public void setInsuNativeHidden(String insuNativeHidden) {
/* 1638 */     this.insuNativeHidden = insuNativeHidden;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.InsuredPersonInfo
 * JD-Core Version:    0.6.0
 */