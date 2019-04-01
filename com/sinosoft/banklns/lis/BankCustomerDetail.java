/*      */ package com.sinosoft.banklns.lis;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.bean.BankLNPAddressBean;
/*      */ import com.sinosoft.banklns.lis.bean.BankLNPAppntBean;
/*      */ import com.sinosoft.banklns.lis.bean.BankLNPBnfBean;
/*      */ import com.sinosoft.banklns.lis.bean.BankLNPContBean;
/*      */ import com.sinosoft.banklns.lis.bean.BankLNPInusredBean;
/*      */ import com.sinosoft.banklns.lis.bean.BankLNPPersonBean;
/*      */ import com.sinosoft.banklns.lis.bean.CRSInfoBean;
/*      */ import com.sinosoft.banklns.lis.db.CRSInfoDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPAddressDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPAppntDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPBnfDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPInsuredDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPPersonDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
/*      */ import com.sinosoft.banklns.lis.pubfun.LNPPubFun;
/*      */ import com.sinosoft.banklns.lis.pubfun.MMap;
/*      */ import com.sinosoft.banklns.lis.pubfun.PubSubmit;
/*      */ import com.sinosoft.banklns.lis.pubfun.SysMaxNoMAPNP;
/*      */ import com.sinosoft.banklns.lis.schema.CRSInfoSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPAddressSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPAppntSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPBnfSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPInsuredSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPPersonSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.CRSInfoSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPAddressSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPAppntSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPBnfSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPInsuredSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPPersonSet;
/*      */ import com.sinosoft.banklns.lnsmodel.BankOperateDeal;
/*      */ import com.sinosoft.banklns.lnsmodel.BankPolicyState;
/*      */ import com.sinosoft.banklns.lnsmodel.PolicyMainInfo;
/*      */ import com.sinosoft.banklns.utility.ExeSQL;
/*      */ import com.sinosoft.banklns.utility.PubFun;
/*      */ import com.sinosoft.banklns.utility.SSRS;
/*      */ import com.sinosoft.banklns.utility.VData;
/*      */ import java.io.PrintStream;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.regex.Pattern;
/*      */ import javax.faces.context.ExternalContext;
/*      */ import javax.faces.context.FacesContext;
/*      */ import javax.faces.model.SelectItem;
/*      */ import javax.servlet.http.HttpSession;
/*      */ 
/*      */ public class BankCustomerDetail extends BankBasicBL
/*      */ {
/*   76 */   int i = 0;
/*   77 */   private boolean editFlag = true;
/*   78 */   private String message = "";
/*   79 */   private boolean appntCompelte = false;
/*   80 */   private boolean insurCompelte = false;
/*   81 */   private boolean bnfCompelte = false;
/*   82 */   private boolean crsComplete = false;
/*   83 */   private boolean allCompelte = false;
/*      */ 
/*   85 */   private boolean operateResult = true;
/*      */ 
/*   87 */   private boolean appntHasFlag = false;
/*   88 */   private boolean insurHasFlag = false;
/*   89 */   private boolean bnfHasFlag = false;
/*   90 */   private boolean crsHasFlag = false;
/*      */   private IGlobalInput GI;
/*   93 */   private String ContNo = "";
/*      */ 
/*   95 */   public static Map<String, String> genderMap = new HashMap();
/*   96 */   public static Map<String, String> idTypeMap = new HashMap();
/*   97 */   public static Map<String, String> relationToInsuredMap = new HashMap();
/*   98 */   public static Map<String, String> occNameMap = new HashMap();
/*      */   private BankLNPContBean contBean;
/*      */   private BankLNPAppntBean appntBean;
/*      */   private BankLNPInusredBean insuredBean;
/*      */   private BankLNPPersonBean insurPersonBean;
/*      */   private BankLNPAddressBean insuraddressBean;
/*      */   private BankLNPPersonBean appntPersonBean;
/*      */   private BankLNPAddressBean appntaddressBean;
/*      */   private CRSInfoBean crsBean;
/*      */   private CRSInfoBean crsBeanBackup;
/*      */   private BankLNPContBean contBeanBackup;
/*      */   private BankLNPAppntBean appntBeanBackup;
/*      */   private BankLNPPersonBean appntPersonBeanBackup;
/*      */   private BankLNPAddressBean appntaddressBeanBackup;
/*      */   private BankLNPInusredBean insurBeanBackup;
/*      */   private BankLNPPersonBean insurPersonBeanBackup;
/*      */   private BankLNPAddressBean insuraddressBeanBackup;
/*      */   private String AIRealation;
/*      */   private String AppntVIP;
/*      */   private String AppntName;
/*      */   private String AppntSex;
/*      */   private String AppntBirthDay;
/*      */   private String AppntAge;
/*      */   private String AppntIDType;
/*      */   private String AppntID;
/*      */   private String AppntIDVailityType;
/*      */   private String AppntIDVaility;
/*      */   private String AppntNative;
/*      */   private String AppntIDView;
/*      */   private String AppntGrpName;
/*      */   private String AOccupationCode;
/*      */   private String AOccupationName;
/*      */   private String AppntCompanyAddr;
/*      */   private String AppntCompanyPhone;
/*      */   private String AppntCompanyZipCode;
/*      */   private String AppntIPhone;
/*      */   private String AppntCompanyMail;
/*      */   private String AppntSalary;
/*      */   private String AppntLinkAdr;
/*      */   private String AppntHomeZipCode;
/*      */   private String AppntHomeAddr;
/*      */   private String appntAreaCode;
/*      */   private String appntHomeProvince;
/*      */   private String appntHomeCity;
/*      */   private String appntHomeCounty;
/*      */   private String appntHomeRoad;
/*      */   private String appntHomeVillage;
/*      */   private String appntCompanyProvince;
/*      */   private String appntCompanyCity;
/*      */   private String appntCompanyCounty;
/*      */   private String appntCompanyRoad;
/*      */   private String appntCompanyVillage;
/*  158 */   private List<SelectItem> appntHomeProvinceList = new ArrayList();
/*      */ 
/*  160 */   private List<SelectItem> appntHomeCityList = new ArrayList();
/*      */ 
/*  162 */   private List<SelectItem> appntHomeCountyList = new ArrayList();
/*      */ 
/*  164 */   private List<SelectItem> appntCompanyProvinceList = new ArrayList();
/*      */ 
/*  166 */   private List<SelectItem> appntCompanyCityList = new ArrayList();
/*      */ 
/*  168 */   private List<SelectItem> appntCompanyCountyList = new ArrayList();
/*  169 */   private List<SelectItem> crsBirthProvinceList = new ArrayList();
/*  170 */   private List<SelectItem> crsBirthCityList = new ArrayList();
/*      */   private String InsurName;
/*      */   private String InsurSex;
/*      */   private String InsurBirthDay;
/*      */   private String InsurAge;
/*      */   private String InsurIDType;
/*      */   private String InsurID;
/*      */   private String InsurIDVailityType;
/*      */   private String InsurIDVaility;
/*      */   private String InsurNative;
/*      */   private String InsurIDView;
/*      */   private String InsurGrpName;
/*      */   private String IOccupationCode;
/*      */   private String IOccupationName;
/*      */   private String InsurCompanyAddr;
/*      */   private String InsurCompanyPhone;
/*      */   private String InsurCompanyZipCode;
/*      */   private String InsurIPhone;
/*      */   private String InsurCompanyMail;
/*      */   private String InsurSalary;
/*      */   private String InsurLinkAdr;
/*      */   private String InsurHomeZipCode;
/*      */   private String InsurHomeAddr;
/*      */   private String insuAreaCode;
/*      */   private String insurHomeProvince;
/*      */   private String insurHomeCity;
/*      */   private String insurHomeCounty;
/*      */   private String insurHomeRoad;
/*      */   private String insurHomeVillage;
/*      */   private String insurCompanyProvince;
/*      */   private String insurCompanyCity;
/*      */   private String insurCompanyCounty;
/*      */   private String insurCompanyRoad;
/*      */   private String insurCompanyVillage;
/*  206 */   private List<SelectItem> insurHomeProvinceList = new ArrayList();
/*      */ 
/*  208 */   private List<SelectItem> insurHomeCityList = new ArrayList();
/*      */ 
/*  210 */   private List<SelectItem> insurHomeCountyList = new ArrayList();
/*      */ 
/*  212 */   private List<SelectItem> insurCompanyProvinceList = new ArrayList();
/*      */ 
/*  214 */   private List<SelectItem> insurCompanyCityList = new ArrayList();
/*      */ 
/*  216 */   private List<SelectItem> insurCompanyCountyList = new ArrayList();
/*      */   private String BnfIsExist;
/*      */   private String BnfRecType;
/*  221 */   private List<BankLNPBnfBean> bnfList = new ArrayList();
/*  222 */   private List<BankLNPBnfBean> bnfListBackup = new ArrayList();
/*  223 */   private List<BankLNPBnfBean> delBnfList = new ArrayList();
/*      */ 
/*  225 */   private List<BankLNPBnfBean> bnfValiList = new ArrayList();
/*      */   private String contNo;
/*      */   private String customerName;
/*      */   private String taxResidentType;
/*      */   private String firstName;
/*      */   private String lastName;
/*      */   private String birthday;
/*      */   private String currentAddress_Country;
/*      */   private String currentAddress_Province;
/*      */   private String currentAddress_City;
/*      */   private String currentAddress_Detail;
/*      */   private String currentAddress_Country_en;
/*      */   private String currentAddress_Province_en;
/*      */   private String currentAddress_City_en;
/*      */   private String currentAddress_Detail_en;
/*      */   private String birthAddress_Country;
/*      */   private String birthAddress_Province;
/*      */   private String birthAddress_City;
/*      */   private String birthAddress_Detail;
/*      */   private String birthAddress_Country_en;
/*      */   private String birthAddress_Province_en;
/*      */   private String birthAddress_City_en;
/*      */   private String birthAddress_Detail_en;
/*      */   private String taxResidentCountry1;
/*      */   private String taxpayerCode1;
/*      */   private String taxResidentCountry2;
/*      */   private String taxpayerCode2;
/*      */   private String taxResidentCountry3;
/*      */   private String taxpayerCode3;
/*      */   private String noTaxpayercodeReason;
/*      */   private String reasonDescription;
/*  260 */   private int BnfMinSize = 4;
/*  261 */   private int BnfMaxSize = 10;
/*      */   private int BnfSize;
/*      */   private String valiDate;
/*      */   private BankOperateDeal stateOperate;
/*      */   private BankPolicyState policyState;
/*      */   private String curBnfId;
/*      */   private int curIdx;
/*      */   private String OccType;
/*      */   private String OccCode;
/*      */   private String CAge;
/*      */   private String CType;
/*      */   private String CBirth;
/*      */ 
/*      */   static
/*      */   {
/* 2373 */     initGenderMap();
/* 2374 */     initIdTypeMap();
/* 2375 */     initRelationToInsuredMap();
/* 2376 */     initOccNameMap();
/*      */   }
/*      */ 
/*      */   public static void main(String[] args)
/*      */   {
/*  270 */     BankCustomerDetail t = new BankCustomerDetail();
/*  271 */     String object = "";
/*  272 */     System.out.println(t.turnNullToString(object));
/*  273 */     object = null;
/*  274 */     System.out.println(t.turnNullToString(object));
/*  275 */     double obj = 0.9D;
/*  276 */     System.out.println(t.turnNullToString(Double.valueOf(obj)));
/*      */ 
/*  278 */     t.saveCustomerMsg();
/*      */   }
/*      */ 
/*      */   public boolean insertCRScontNo(CRSInfoBean crsBean, String contNo)
/*      */   {
/*  294 */     crsBean.getSchema().setContNo(contNo);
/*  295 */     System.out.println("insertCRScontNo\u67E5\u5230\u7684CRS\u4FE1\u606F" + contNo + crsBean.getSchema().toString());
/*  296 */     initCRSInfoMsg(crsBean, null);
/*  297 */     MMap insertMap = new MMap();
/*  298 */     if ((recOneCRSInfo(contNo).getSchema().getContNo() == null) || ("".equals(recOneCRSInfo(contNo).getSchema().getContNo()))) {
/*  299 */       insertMap.put(crsBean.getSchema(), "INSERT");
/*      */     }
/*  301 */     VData crsInputData = new VData();
/*  302 */     crsInputData.add(insertMap);
/*  303 */     PubSubmit crsSubmit = new PubSubmit();
/*  304 */     if (!crsSubmit.submitData(crsInputData, "")) {
/*  305 */       buildError("crs\u4FE1\u606F\u4FDD\u5B58\u5931\u8D25!");
/*  306 */       return false;
/*      */     }
/*  308 */     return true;
/*      */   }
/*      */ 
/*      */   public void initData() {
/*  312 */     System.out.println("------------start BankCustomerDetail initData()---------------------");
/*      */     try {
/*  314 */       this.editFlag = true;
/*  315 */       this.message = "";
/*  316 */       this.allCompelte = false;
/*  317 */       this.operateResult = true;
/*  318 */       this.appntHasFlag = false;
/*  319 */       this.insurHasFlag = false;
/*  320 */       this.bnfHasFlag = false;
/*  321 */       this.crsHasFlag = false;
/*  322 */       this.ContNo = "";
/*      */ 
/*  324 */       this.appntBean = new BankLNPAppntBean();
/*  325 */       this.appntBean.getSchema().setSalary("-1");
/*  326 */       this.appntPersonBean = new BankLNPPersonBean();
/*  327 */       this.appntaddressBean = new BankLNPAddressBean();
/*  328 */       this.insuredBean = new BankLNPInusredBean();
/*  329 */       this.insuredBean.getSchema().setSalary("-1");
/*  330 */       this.insurPersonBean = new BankLNPPersonBean();
/*  331 */       this.insuraddressBean = new BankLNPAddressBean();
/*      */ 
/*  333 */       this.crsBean = new CRSInfoBean();
/*  334 */       initCRSInfoMsg(this.crsBean, this.appntaddressBean);
/*      */ 
/*  337 */       initAppntMsg(this.appntBean, this.appntPersonBean, this.appntaddressBean);
/*      */ 
/*  339 */       initInsuredMsg(this.insuredBean, this.insurPersonBean, this.insuraddressBean);
/*      */ 
/*  341 */       this.BnfIsExist = "";
/*  342 */       this.BnfRecType = "";
/*  343 */       if (getInfoFromSession()) {
/*  344 */         this.contBean = recOneContInfo(this.ContNo);
/*      */ 
/*  346 */         if (!"".equals(this.contBean.getSchema().getContNo())) {
/*  347 */           String contNo = this.contBean.getSchema().getContNo();
/*      */ 
/*  349 */           if (this.crsBean.getSchema().getContNo() == null) {
/*  350 */             insertCRScontNo(this.crsBean, contNo);
/*      */           }
/*      */ 
/*  355 */           if ((this.contBean.getSchema().getAppntId() == null) || ("".equals(this.contBean.getSchema().getAppntId()))) {
/*  356 */             String contAppntId = getAppntIDByContno(contNo);
/*  357 */             this.contBean.getSchema().setAppntId(contAppntId);
/*      */           }
/*      */ 
/*  360 */           System.out.println("\u6267\u884C\u5230contBean" + this.contBean.getSchema().getAppntId());
/*  361 */           if ((this.contBean.getSchema().getAppntId() != null) && (!"".equals(this.contBean.getSchema().getAppntId())))
/*      */           {
/*  364 */             String AppntId = this.contBean.getSchema().getAppntId();
/*  365 */             this.appntBean = recOneAppntPersonInfo(contNo, AppntId);
/*  366 */             this.appntPersonBean = recOnePersonInfo(this.contBean.getSchema().getAppntId());
/*  367 */             this.appntaddressBean = recOneAddressInfo(this.contBean.getSchema().getAppntId());
/*      */ 
/*  369 */             this.crsBean = recOneCRSInfo(contNo);
/*  370 */             System.out.println("CRS\u4FE1\u606F\u662F\u5426null====" + this.crsBean.getSchema().getContNo());
/*  371 */             if (this.crsBean.getSchema().getContNo() != null) {
/*  372 */               System.out.println("CRS\u4FE1\u606Fif");
/*  373 */               if (!updateCRS(this.crsBean, contNo, this.appntBean, this.appntaddressBean)) {
/*  374 */                 System.out.println("CRS\u4FE1\u606F\u66F4\u65B0\u5931\u8D25");
/*      */               }
/*      */             }
/*  377 */             this.valiDate = this.contBean.getSchema().getPValiDate();
/*      */ 
/*  379 */             initCRSInfoMsg(this.crsBean, this.appntaddressBean);
/*  380 */             this.crsHasFlag = true;
/*      */ 
/*  382 */             initAppntMsg(this.appntBean, this.appntPersonBean, this.appntaddressBean);
/*      */ 
/*  384 */             this.appntHasFlag = true;
/*  385 */             System.out.println(this.appntBean.getSchema().getAppntName() + "----------initAppntMsg-------------" + 
/*  386 */               this.AppntName);
/*      */           }
/*  388 */           System.out.println("\u6267\u884C\u5230\u8FD9\u91CC\u4E86");
/*      */ 
/*  390 */           if ((this.contBean.getSchema().getInsuredId() != null) && 
/*  391 */             (!"".equals(this.contBean.getSchema().getInsuredId()))) {
/*  392 */             String insuredId = this.contBean.getSchema().getInsuredId();
/*  393 */             this.insuredBean = recOneInsuredPersonInfo(contNo, insuredId);
/*  394 */             this.insurPersonBean = recOnePersonInfo(this.contBean.getSchema().getInsuredId());
/*  395 */             this.insuraddressBean = recOneAddressInfo(this.contBean.getSchema().getInsuredId());
/*  396 */             initInsuredMsg(this.insuredBean, this.insurPersonBean, this.insuraddressBean);
/*  397 */             this.insurHasFlag = true;
/*      */           }
/*      */ 
/*  400 */           this.bnfList = recBnfList(this.contBean.getSchema().getContNo());
/*  401 */           if ((this.bnfList != null) && (this.bnfList.size() > 0)) {
/*  402 */             this.bnfHasFlag = true;
/*      */ 
/*  404 */             for (int i = this.bnfList.size(); this.BnfMinSize - i > 0; i++) {
/*  405 */               BankLNPBnfBean bnfBean = new BankLNPBnfBean();
/*  406 */               bnfBean.getSchema().setBnfOrder(i);
/*      */ 
/*  408 */               this.bnfList.add(bnfBean);
/*      */             }
/*      */           } else {
/*  411 */             this.bnfList = new ArrayList();
/*  412 */             for (int i = this.bnfList.size(); this.BnfMinSize - i > 0; i++) {
/*  413 */               BankLNPBnfBean bnfBean = new BankLNPBnfBean();
/*  414 */               bnfBean.getSchema().setBnfOrder(i);
/*      */ 
/*  417 */               this.bnfList.add(bnfBean);
/*      */             }
/*      */           }
/*  420 */           this.BnfSize = this.bnfList.size();
/*      */ 
/*  422 */           this.stateOperate = new BankOperateDeal();
/*  423 */           boolean tEditFlag = this.stateOperate.isEidtSheet(this.contBean.getSchema().getState(), "03", this.GI.LNPRole, 
/*  424 */             contNo);
/*  425 */           HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext()
/*  426 */             .getSession(true);
/*  427 */           Boolean tQueyEditFlag = (Boolean)session.getAttribute("Queryflag");
/*  428 */           if (tQueyEditFlag == null) {
/*  429 */             tQueyEditFlag = Boolean.valueOf(true);
/*      */           }
/*  431 */           this.editFlag = ((tEditFlag) && (tQueyEditFlag.booleanValue()));
/*      */         }
/*      */       }
/*      */       else {
/*  435 */         buildError("\u5168\u5C40\u6295\u4FDD\u4E66\u4FE1\u606F\u7F3A\u5931!");
/*      */       }
/*      */     } catch (Exception e) {
/*  438 */       turnCurrPolicyLockFlag(null, this.ContNo, "unlock");
/*  439 */       e.printStackTrace();
/*  440 */       buildError(e.getMessage());
/*      */     }
/*      */   }
/*      */ 
/*      */   public boolean updateCRS(CRSInfoBean crsBean, String contNo, BankLNPAppntBean appntBean, BankLNPAddressBean addressBean)
/*      */   {
/*  447 */     crsBean.getSchema().setContNo(contNo);
/*  448 */     crsBean.getSchema().setCustomerName(appntBean.getSchema().getAppntName());
/*  449 */     crsBean.getSchema().setBirthday(appntBean.getSchema().getAppntBirthday());
/*  450 */     crsBean.getSchema().setCurrentAddress_City(getAddressName(addressBean.getSchema().getBP()));
/*  451 */     crsBean.getSchema().setCurrentAddress_Province(getAddressName(addressBean.getSchema().getHomeFax()));
/*  452 */     crsBean.getSchema().setCurrentAddress_Country("\u4E2D\u56FD");
/*  453 */     System.out.println("\u7701\u5E02" + addressBean.getSchema().getHomeFax() + addressBean.getSchema().getBP());
/*  454 */     System.out.println("\u67E5\u5230\u7684CRS\u4FE1\u606F" + contNo + crsBean.getSchema().toString());
/*  455 */     initCRSInfoMsg(crsBean, addressBean);
/*  456 */     MMap insertMap = new MMap();
/*  457 */     insertMap.put(crsBean.getSchema(), "UPDATE");
/*  458 */     VData crsInputData = new VData();
/*  459 */     crsInputData.add(insertMap);
/*  460 */     PubSubmit crsSubmit = new PubSubmit();
/*  461 */     if (!crsSubmit.submitData(crsInputData, "")) {
/*  462 */       buildError("CRS\u4FE1\u606F\u66F4\u65B0\u5931\u8D25!");
/*  463 */       return false;
/*      */     }
/*  465 */     return true;
/*      */   }
/*      */ 
/*      */   public void saveCustomerMsg() {
/*  469 */     this.operateResult = true;
/*      */ 
/*  472 */     label992: 
/*      */     try { if (this.editFlag) {
/*  473 */         VData cInputData = new VData();
/*  474 */         MMap map = new MMap();
/*  475 */         String curDate = PubFun.getCurrentDate();
/*  476 */         String curTime = PubFun.getCurrentTime();
/*      */ 
/*  478 */         System.out.println("\u6570\u636E\u4FDD\u5B58\u5F00\u59CB...");
/*      */ 
/*  480 */         boolean isSave = saveCRSInfo(map, this.crsBean, this.crsHasFlag);
/*  481 */         System.out.println("CRS\u4FE1\u606F\u4FDD\u5B58\u5728map\u4E2D\u7ED3\u679C\u4E3A" + isSave);
/*      */ 
/*  483 */         if ((!saveAppntMsg(map, this.appntHasFlag, this.contBean, this.appntBean, this.appntPersonBean, 
/*  483 */           this.appntaddressBean, curDate, curTime)) || 
/*  485 */           (!isSave) || 
/*  488 */           (!saveInusredMsg(map, this.insurHasFlag, this.contBean, this.insuredBean, this.insurPersonBean, 
/*  488 */           this.insuraddressBean, curDate, curTime)) || 
/*  490 */           (!saveBnfMsg(map, this.bnfHasFlag, this.contBean, this.bnfList, this.delBnfList, curDate, 
/*  490 */           curTime))) {
/*  491 */           if (!this.operateResult) {
/*  492 */             System.out.println();
/*  493 */             System.out.println("\u5B58\u5728\u9519\u8BEF\uFF1A------------------" + this.message);
/*      */           }
/*  495 */           return;
/*      */         }
/*      */         boolean isSave;
/*      */         String curTime;
/*      */         String curDate;
/*      */         MMap map;
/*      */         VData cInputData;
/*  498 */         System.out.println("\u6570\u636E\u6B63\u786E\uFF0C\u5DF2\u4FDD\u5B58");
/*      */ 
/*  500 */         dealAddrMsg(this.appntaddressBean, this.insuraddressBean);
/*      */ 
/*  502 */         this.allCompelte = ((this.appntCompelte) && (this.insurCompelte) && (this.bnfCompelte) && 
/*  503 */           (this.crsComplete));
/*  504 */         System.out.println(
/*  505 */           " this.crsComplete=" + this.crsComplete + "||this.allCompelte=" + this.allCompelte);
/*      */ 
/*  507 */         this.stateOperate = new BankOperateDeal();
/*  508 */         boolean isChangeToCustomerMsg = false;
/*  509 */         System.out.println("\u672C\u6B21\u5FC5\u5F55\u9879\u72B6\u6001\uFF1AappntCompelte-" + this.appntCompelte + " |insurCompelte-" + this.insurCompelte + 
/*  510 */           "|bnfCompelte+" + this.bnfCompelte + "| \u4FEE\u6539\u4E4B\u524D\uFF1Astate--\u300B" + this.contBean.getSchema().getState() + 
/*  511 */           "editstate---\u300B" + this.contBean.getSchema().getEditstate());
/*  512 */         if (this.allCompelte) {
/*  513 */           List stateList = this.stateOperate.infoOprate(this.contBean.getSchema().getState(), 
/*  514 */             this.contBean.getSchema().getEditstate(), "modify", "03");
/*  515 */           this.contBean.getSchema().setState((String)stateList.get(0));
/*  516 */           this.contBean.getSchema().setEditstate((String)stateList.get(1));
/*  517 */         } else if ("01".equals(this.contBean.getSchema().getState())) {
/*  518 */           String editState = this.stateOperate.updateEditStateUNDone(this.contBean.getSchema().getEditstate(), 3);
/*  519 */           this.contBean.getSchema().setEditstate(editState);
/*      */         }
/*      */ 
/*  522 */         boolean isModifyfFlag = (this.appntHasFlag) && (this.insurHasFlag) && (this.allCompelte);
/*  523 */         List stateList = dealRefcOtherMsgBySuc(isModifyfFlag, this.appntBeanBackup, this.appntPersonBean, 
/*  524 */           this.appntaddressBean, this.insurBeanBackup, this.insurPersonBean, 
/*  525 */           this.insuraddressBeanBackup, curDate, curTime);
/*  526 */         if (stateList.size() > 0)
/*      */         {
/*  528 */           isChangeToCustomerMsg = true;
/*  529 */           this.contBean.getSchema().setState((String)stateList.get(0));
/*  530 */           this.contBean.getSchema().setEditstate((String)stateList.get(1));
/*      */         }
/*      */ 
/*  533 */         map.put(this.contBean.getSchema(), "UPDATE");
/*      */ 
/*  535 */         cInputData.add(map);
/*      */ 
/*  537 */         System.out.println("crs" + this.crsBean.getSchema());
/*      */ 
/*  540 */         PubSubmit pubSubmit = new PubSubmit();
/*  541 */         if (!pubSubmit.submitData(cInputData, "")) {
/*  542 */           buildError("\u5BA2\u6237\u4FE1\u606F\u4FDD\u5B58\u5931\u8D25!");
/*  543 */           break label992;
/*      */         }try {
/*  545 */           this.policyState = new BankPolicyState();
/*  546 */           if (isChangeToCustomerMsg)
/*  547 */             this.policyState.savePolicyState(this.ContNo, this.contBean.getSchema().getState(), "3", curDate, 
/*  548 */               curTime);
/*      */         } catch (Exception e) {
/*  550 */           e.printStackTrace();
/*  551 */           buildError("~~~~~~~~~~~~~~~~~~~~~\u4FDD\u5355\u72B6\u6001\u8BB0\u5F55\u63A5\u53E3\u62A5\u9519!");
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  559 */       e.printStackTrace();
/*  560 */       buildError("\u5BA2\u6237\u4FE1\u606F\u4FDD\u5B58\u5931\u8D25!");
/*      */     } finally {
/*  562 */       turnCurrPolicyLockFlag(null, this.ContNo, "unlock");
/*  563 */       if (!this.operateResult) {
/*  564 */         System.out.println();
/*  565 */         System.out.println("\u5B58\u5728\u9519\u8BEF\uFF1A------------------" + this.message);
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   private List<String> dealRefcOtherMsgBySuc(boolean isModify, BankLNPAppntBean appntBean, BankLNPPersonBean appntPersonBean, BankLNPAddressBean appntAddresBean, BankLNPInusredBean insurBean, BankLNPPersonBean insurPersonBean, BankLNPAddressBean insurAddresBean, String curDate, String curTime)
/*      */   {
/*  574 */     List list = new ArrayList();
/*      */     try {
/*  576 */       this.contBeanBackup = recOneContInfo(this.ContNo);
/*  577 */       if (isModify)
/*      */       {
/*  579 */         boolean isChangeToCustomerMsg = false;
/*      */ 
/*  581 */         this.appntBeanBackup = recOneAppntPersonInfo(this.ContNo, this.contBean.getSchema().getAppntId());
/*  582 */         this.appntPersonBeanBackup = recOnePersonInfo(this.contBean.getSchema().getAppntId());
/*  583 */         this.appntaddressBeanBackup = recOneAddressInfo(this.contBean.getSchema().getAppntId());
/*  584 */         System.out.println("cur:" + this.appntBean.getSchema().getAppntName() + "init:" + 
/*  585 */           this.appntBeanBackup.getSchema().getAppntName() + "this.AppntName:" + this.AppntName);
/*      */ 
/*  587 */         if ((!turnNullToString(this.appntBean.getSchema().getAppntName())
/*  587 */           .equals(turnNullToString(this.appntBeanBackup.getSchema().getAppntName()))) || 
/*  589 */           (!turnNullToString(this.appntBean.getSchema().getAppntSex())
/*  589 */           .equals(turnNullToString(this.appntBeanBackup.getSchema().getAppntSex()))) || 
/*  591 */           (!turnNullToString(this.appntBean.getSchema().getAppntBirthday())
/*  591 */           .equals(turnNullToString(this.appntBeanBackup.getSchema().getAppntBirthday()))) || 
/*  593 */           (!turnNullToString(Integer.valueOf(this.appntBean.getSchema().getAppntAge()))
/*  593 */           .equals(turnNullToString(Integer.valueOf(this.appntBeanBackup.getSchema().getAppntAge())))) || 
/*  595 */           (!turnNullToString(this.appntBean.getSchema().getAppntAgeType())
/*  595 */           .equals(turnNullToString(this.appntBeanBackup.getSchema().getAppntAgeType()))) || 
/*  597 */           (!turnNullToString(this.appntBean.getSchema().getIDType())
/*  597 */           .equals(turnNullToString(this.appntBeanBackup.getSchema().getIDType()))) || 
/*  599 */           (!turnNullToString(this.appntBean.getSchema().getIDNo())
/*  599 */           .equals(turnNullToString(this.appntBeanBackup.getSchema().getIDNo()))) || 
/*  601 */           (!turnNullToString(this.appntBean.getSchema().getIDPerpetual())
/*  601 */           .equals(turnNullToString(this.appntBeanBackup.getSchema().getIDPerpetual()))) || 
/*  603 */           (!turnNullToString(this.appntBean.getSchema().getIDValidity())
/*  603 */           .equals(turnNullToString(this.appntBeanBackup.getSchema().getIDValidity()))) || 
/*  605 */           (!turnNullToString(this.appntBean.getSchema().getNativePlace())
/*  605 */           .equals(turnNullToString(this.appntBeanBackup.getSchema().getNativePlace()))) || 
/*  607 */           (!turnNullToString(this.appntBean.getSchema().getHealth())
/*  607 */           .equals(turnNullToString(this.appntBeanBackup.getSchema().getHealth()))) || 
/*  609 */           (!turnNullToString(this.appntaddressBean.getSchema().getGrpName())
/*  609 */           .equals(turnNullToString(this.appntaddressBeanBackup.getSchema().getGrpName()))) || 
/*  611 */           (!turnNullToString(this.appntBean.getSchema().getOccupationCode())
/*  611 */           .equals(turnNullToString(this.appntBeanBackup.getSchema().getOccupationCode()))) || 
/*  613 */           (!turnNullToString(this.appntaddressBean.getSchema().getCompanyFax())
/*  613 */           .equals(turnNullToString(this.appntaddressBeanBackup.getSchema().getCompanyFax()))) || 
/*  615 */           (!turnNullToString(this.appntaddressBean.getSchema().getBP2())
/*  615 */           .equals(turnNullToString(this.appntaddressBeanBackup.getSchema().getBP2()))) || 
/*  617 */           (!turnNullToString(this.appntaddressBean.getSchema().getCompanyAddress())
/*  617 */           .equals(turnNullToString(this.appntaddressBeanBackup.getSchema().getCompanyAddress()))) || 
/*  619 */           (!turnNullToString(this.appntaddressBean.getSchema().getMobileChs2())
/*  619 */           .equals(turnNullToString(this.appntaddressBeanBackup.getSchema().getMobileChs2()))) || 
/*  621 */           (!turnNullToString(this.appntaddressBean.getSchema().getCompanyPhone())
/*  621 */           .equals(turnNullToString(this.appntaddressBeanBackup.getSchema().getCompanyPhone()))) || 
/*  623 */           (!turnNullToString(this.appntaddressBean.getSchema().getCompanyZipCode())
/*  623 */           .equals(turnNullToString(this.appntaddressBeanBackup.getSchema().getCompanyZipCode()))) || 
/*  625 */           (!turnNullToString(this.appntaddressBean.getSchema().getPhone())
/*  625 */           .equals(turnNullToString(this.appntaddressBeanBackup.getSchema().getPhone()))) || 
/*  627 */           (!turnNullToString(this.appntaddressBean.getSchema().getCompanyMail())
/*  627 */           .equals(turnNullToString(this.appntaddressBeanBackup.getSchema().getCompanyMail()))) || 
/*  629 */           (!turnNullToString(Double.valueOf(this.appntBean.getSchema().getSalary()))
/*  629 */           .equals(turnNullToString(Double.valueOf(this.appntBeanBackup.getSchema().getSalary())))) || 
/*  631 */           (!turnNullToString(this.appntaddressBean.getSchema().getPostalAddress())
/*  631 */           .equals(turnNullToString(this.appntaddressBeanBackup.getSchema().getPostalAddress()))) || 
/*  633 */           (!turnNullToString(this.appntaddressBean.getSchema().getHomeZipCode())
/*  633 */           .equals(turnNullToString(this.appntaddressBeanBackup.getSchema().getHomeZipCode()))) || 
/*  635 */           (!turnNullToString(this.appntaddressBean.getSchema().getHomeAddress())
/*  635 */           .equals(turnNullToString(this.appntaddressBeanBackup.getSchema().getHomeAddress()))) || 
/*  637 */           (!turnNullToString(this.appntaddressBean.getSchema().getHomeFax())
/*  637 */           .equals(turnNullToString(this.appntaddressBeanBackup.getSchema().getHomeFax()))) || 
/*  639 */           (!turnNullToString(this.appntaddressBean.getSchema().getBP())
/*  639 */           .equals(turnNullToString(this.appntaddressBeanBackup.getSchema().getBP()))) || 
/*  641 */           (!turnNullToString(this.appntBean.getSchema().getRelationToInsured())
/*  641 */           .equals(turnNullToString(this.appntBeanBackup.getSchema().getRelationToInsured()))) || 
/*  643 */           (!turnNullToString(this.appntBean.getSchema().getAppntGrade())
/*  643 */           .equals(turnNullToString(this.appntBeanBackup.getSchema().getAppntGrade())))) {
/*  644 */           isChangeToCustomerMsg = true;
/*      */         }
/*      */ 
/*  648 */         this.insurBeanBackup = recOneInsuredPersonInfo(this.ContNo, 
/*  649 */           this.contBean.getSchema().getInsuredId());
/*  650 */         this.insurPersonBeanBackup = recOnePersonInfo(this.contBean.getSchema().getInsuredId());
/*  651 */         this.insuraddressBeanBackup = recOneAddressInfo(this.contBean.getSchema().getInsuredId());
/*      */ 
/*  653 */         if ((!turnNullToString(this.insuredBean.getSchema().getName())
/*  653 */           .equals(turnNullToString(this.insurBeanBackup.getSchema().getName()))) || 
/*  655 */           (!turnNullToString(this.insuredBean.getSchema().getSex())
/*  655 */           .equals(turnNullToString(this.insurBeanBackup.getSchema().getSex()))) || 
/*  657 */           (!turnNullToString(this.insuredBean.getSchema().getBirthday())
/*  657 */           .equals(turnNullToString(this.insurBeanBackup.getSchema().getBirthday()))) || 
/*  659 */           (!turnNullToString(Integer.valueOf(this.insuredBean.getSchema().getAppAge()))
/*  659 */           .equals(turnNullToString(Integer.valueOf(this.insurBeanBackup.getSchema().getAppAge())))) || 
/*  661 */           (!turnNullToString(this.insuredBean.getSchema().getAppAgeType())
/*  661 */           .equals(turnNullToString(this.insurBeanBackup.getSchema().getAppAgeType()))) || 
/*  663 */           (!turnNullToString(this.insuredBean.getSchema().getIDType())
/*  663 */           .equals(turnNullToString(this.insurBeanBackup.getSchema().getIDType()))) || 
/*  665 */           (!turnNullToString(this.insuredBean.getSchema().getIDNo())
/*  665 */           .equals(turnNullToString(this.insurBeanBackup.getSchema().getIDNo()))) || 
/*  667 */           (!turnNullToString(this.insuredBean.getSchema().getIDPerpetual())
/*  667 */           .equals(turnNullToString(this.insurBeanBackup.getSchema().getIDPerpetual()))) || 
/*  669 */           (!turnNullToString(this.insuredBean.getSchema().getIDValidity())
/*  669 */           .equals(turnNullToString(this.insurBeanBackup.getSchema().getIDValidity()))) || 
/*  671 */           (!turnNullToString(this.insuredBean.getSchema().getNativePlace())
/*  671 */           .equals(turnNullToString(this.insurBeanBackup.getSchema().getNativePlace()))) || 
/*  673 */           (!turnNullToString(this.insuredBean.getSchema().getHealth())
/*  673 */           .equals(turnNullToString(this.insurBeanBackup.getSchema().getHealth()))) || 
/*  675 */           (!turnNullToString(this.insuraddressBean.getSchema().getGrpName())
/*  675 */           .equals(turnNullToString(this.insuraddressBeanBackup.getSchema().getGrpName()))) || 
/*  677 */           (!turnNullToString(this.insuredBean.getSchema().getOccupationCode())
/*  677 */           .equals(turnNullToString(this.insurBeanBackup.getSchema().getOccupationCode()))) || 
/*  679 */           (!turnNullToString(this.insuraddressBean.getSchema().getCompanyFax())
/*  679 */           .equals(turnNullToString(this.insuraddressBeanBackup.getSchema().getCompanyFax()))) || 
/*  681 */           (!turnNullToString(this.insuraddressBean.getSchema().getBP2())
/*  681 */           .equals(turnNullToString(this.insuraddressBeanBackup.getSchema().getBP2()))) || 
/*  683 */           (!turnNullToString(this.insuraddressBean.getSchema().getMobile2())
/*  683 */           .equals(turnNullToString(this.insuraddressBeanBackup.getSchema().getMobile2()))) || 
/*  685 */           (!turnNullToString(this.insuraddressBean.getSchema().getCompanyAddress())
/*  685 */           .equals(turnNullToString(this.insuraddressBeanBackup.getSchema().getCompanyAddress()))) || 
/*  687 */           (!turnNullToString(this.insuraddressBean.getSchema().getEMail2())
/*  687 */           .equals(turnNullToString(this.insuraddressBeanBackup.getSchema().getEMail2()))) || 
/*  689 */           (!turnNullToString(this.insuraddressBean.getSchema().getMobileChs2())
/*  689 */           .equals(turnNullToString(this.insuraddressBeanBackup.getSchema().getMobileChs2()))) || 
/*  691 */           (!turnNullToString(this.insuraddressBean.getSchema().getCompanyPhone())
/*  691 */           .equals(turnNullToString(this.insuraddressBeanBackup.getSchema().getCompanyPhone()))) || 
/*  693 */           (!turnNullToString(this.insuraddressBean.getSchema().getCompanyZipCode())
/*  693 */           .equals(turnNullToString(this.insuraddressBeanBackup.getSchema().getCompanyZipCode()))) || 
/*  695 */           (!turnNullToString(this.insuraddressBean.getSchema().getPhone())
/*  695 */           .equals(turnNullToString(this.insuraddressBeanBackup.getSchema().getPhone()))) || 
/*  697 */           (!turnNullToString(this.insuraddressBean.getSchema().getCompanyMail())
/*  697 */           .equals(turnNullToString(this.insuraddressBeanBackup.getSchema().getCompanyMail()))) || 
/*  699 */           (!turnNullToString(Double.valueOf(this.insuredBean.getSchema().getSalary()))
/*  699 */           .equals(turnNullToString(Double.valueOf(this.insurBeanBackup.getSchema().getSalary())))) || 
/*  701 */           (!turnNullToString(this.insuraddressBean.getSchema().getPostalAddress())
/*  701 */           .equals(turnNullToString(this.insuraddressBeanBackup.getSchema().getPostalAddress()))) || 
/*  703 */           (!turnNullToString(this.insuraddressBean.getSchema().getHomeZipCode())
/*  703 */           .equals(turnNullToString(this.insuraddressBeanBackup.getSchema().getHomeZipCode()))) || 
/*  705 */           (!turnNullToString(this.insuraddressBean.getSchema().getHomeAddress())
/*  705 */           .equals(turnNullToString(this.insuraddressBeanBackup.getSchema().getHomeAddress()))) || 
/*  707 */           (!turnNullToString(this.insuraddressBean.getSchema().getHomeFax())
/*  707 */           .equals(turnNullToString(this.insuraddressBeanBackup.getSchema().getHomeFax()))) || 
/*  709 */           (!turnNullToString(this.insuraddressBean.getSchema().getBP())
/*  709 */           .equals(turnNullToString(this.insuraddressBeanBackup.getSchema().getBP()))) || 
/*  711 */           (!turnNullToString(this.insuraddressBean.getSchema().getHomePhone())
/*  711 */           .equals(turnNullToString(this.insuraddressBeanBackup.getSchema().getHomePhone()))) || 
/*  713 */           (!turnNullToString(this.insuraddressBean.getSchema().getEMail())
/*  713 */           .equals(turnNullToString(this.insuraddressBeanBackup.getSchema().getEMail()))) || 
/*  716 */           (!turnNullToString(Integer.valueOf(this.insuredBean.getSchema().getInsuredPeoples()))
/*  716 */           .equals(turnNullToString(Integer.valueOf(this.insurBeanBackup.getSchema().getInsuredPeoples())))) || 
/*  719 */           (!turnNullToString(this.insuredBean.getSchema().getCreditGrade())
/*  719 */           .equals(turnNullToString(this.insurBeanBackup.getSchema().getCreditGrade())))) {
/*  720 */           isChangeToCustomerMsg = true;
/*      */         }
/*      */ 
/*  724 */         this.bnfListBackup = recBnfList(this.ContNo);
/*  725 */         System.out.println("new?=old--->" + this.bnfValiList.size() + "?=" + this.bnfListBackup.size());
/*  726 */         if (this.bnfValiList.size() != this.bnfListBackup.size()) {
/*  727 */           isChangeToCustomerMsg = true;
/*      */         }
/*      */         else {
/*  730 */           boolean tFlag = false;
/*  731 */           for (int i = 0; i < this.bnfValiList.size(); i++) {
/*  732 */             if (tFlag)
/*      */               break;
/*  734 */             BankLNPBnfBean bnfBean = (BankLNPBnfBean)this.bnfValiList.get(i);
/*  735 */             for (int j = 0; j < this.bnfListBackup.size(); j++) {
/*  736 */               BankLNPBnfBean bnfBeanBak = (BankLNPBnfBean)this.bnfListBackup.get(j);
/*      */ 
/*  738 */               if (turnNullToString(bnfBean.getSchema().getBnfId())
/*  738 */                 .equals(bnfBeanBak.getSchema().getBnfId())) {
/*  739 */                 if ((bnfBean.isValidate()) && (bnfBeanBak.isValidate()))
/*      */                 {
/*  741 */                   if ((turnNullToString(bnfBean.getSchema().getBnfName())
/*  741 */                     .equals(turnNullToString(bnfBeanBak.getSchema().getBnfName()))) && 
/*  743 */                     (turnNullToString(bnfBean.getSchema().getRelationToInsured()).equals(
/*  743 */                     turnNullToString(bnfBeanBak.getSchema().getRelationToInsured()))) && 
/*  745 */                     (turnNullToString(bnfBean.getSchema().getBenefitOrder())
/*  745 */                     .equals(turnNullToString(bnfBeanBak.getSchema().getBenefitOrder()))) && 
/*  747 */                     (turnNullToString(Double.valueOf(bnfBean.getSchema().getBenefitRate()))
/*  747 */                     .equals(turnNullToString(Double.valueOf(bnfBeanBak.getSchema().getBenefitRate())))) && 
/*  749 */                     (turnNullToString(bnfBean.getSchema().getIDType())
/*  749 */                     .equals(turnNullToString(bnfBeanBak.getSchema().getIDType()))) && 
/*  751 */                     (turnNullToString(bnfBean.getSchema().getIDNo())
/*  751 */                     .equals(turnNullToString(bnfBeanBak.getSchema().getIDNo()))) && 
/*  753 */                     (turnNullToString(bnfBean.getSchema().getIDPerpetual())
/*  753 */                     .equals(turnNullToString(bnfBeanBak.getSchema().getIDPerpetual()))) && 
/*  755 */                     (turnNullToString(bnfBean.getIDVaility())
/*  755 */                     .equals(turnNullToString(bnfBeanBak.getIDVaility())))) continue;
/*  756 */                   tFlag = isChangeToCustomerMsg = 1;
/*      */ 
/*  758 */                   break;
/*      */                 }
/*      */ 
/*  761 */                 tFlag = isChangeToCustomerMsg = 1;
/*      */ 
/*  763 */                 break;
/*      */               }
/*      */             }
/*      */           }
/*      */ 
/*      */         }
/*      */ 
/*  770 */         if (isChangeToCustomerMsg)
/*      */         {
/*  772 */           list = this.stateOperate.changeMsgToModify(this.contBean.getSchema().getState(), 
/*  773 */             this.contBean.getSchema().getEditstate(), this.GI.LNPRole);
/*      */         }
/*      */       }
/*      */ 
/*  777 */       copyMsg(this.contBeanBackup, this.appntBeanBackup, this.appntPersonBeanBackup, this.appntaddressBeanBackup, 
/*  778 */         this.insurBeanBackup, this.insurPersonBeanBackup, this.insuraddressBeanBackup);
/*      */     } catch (Exception e) {
/*  780 */       e.printStackTrace();
/*      */     }
/*  782 */     return list;
/*      */   }
/*      */ 
/*      */   private String turnNullToString(Object object) {
/*  786 */     System.out.println("\u8FDB\u5165turnNullToString");
/*  787 */     String rst = "";
/*      */     try {
/*  789 */       rst = object;
/*      */     } catch (Exception e) {
/*  791 */       e.printStackTrace();
/*  792 */       buildError(e.getMessage());
/*      */     }
/*  794 */     return rst.trim();
/*      */   }
/*      */ 
/*      */   private void copyMsg(BankLNPContBean oriContBean, BankLNPAppntBean oriAppntBean, BankLNPPersonBean oriAppntPersonBean, BankLNPAddressBean oriAppntAddresBean, BankLNPInusredBean oriInsurBean, BankLNPPersonBean oriInsurPersonBean, BankLNPAddressBean oriInsurAddresBean)
/*      */   {
/*  802 */     this.contBean.getSchema().setConsignNo(oriContBean.getSchema().getConsignNo());
/*      */   }
/*      */ 
/*      */   private boolean validateCRS(String valiType, CRSInfoBean crsBean)
/*      */   {
/*  808 */     boolean flag = true;
/*  809 */     if ("crs".equals(valiType)) {
/*  810 */       this.crsComplete = true;
/*  811 */       System.out.println("\u6821\u9A8C\u5FC5\u5F55\u9879" + this.AppntIDType);
/*      */ 
/*  813 */       if (("01".equals(this.AppntIDType.trim())) || ("02".equals(this.AppntIDType.trim())) || 
/*  814 */         ("04".equals(this.AppntIDType.trim())) || ("05".equals(this.AppntIDType.trim())) || 
/*  815 */         ("06".equals(this.AppntIDType.trim()))) {
/*  816 */         System.out.println("\u6821\u9A8C\u5FC5\u5F55\u9879\u975E\u519B\u4EBA\u8BC1");
/*  817 */         if ((this.taxResidentType == null) || ("".equals(this.taxResidentType.trim()))) {
/*  818 */           this.crsComplete = false;
/*      */         }
/*  821 */         else if (!"1".equals(this.taxResidentType.trim())) {
/*  822 */           System.out.println("\u6821\u9A8C\u5FC5\u5F55\u9879\u7C7B\u578B2\u30013");
/*  823 */           if ((this.firstName == null) || ("".equals(this.firstName.trim()))) {
/*  824 */             this.crsComplete = false;
/*      */           }
/*  826 */           if ((this.lastName == null) || ("".equals(this.lastName.trim()))) {
/*  827 */             this.crsComplete = false;
/*      */           }
/*      */ 
/*  830 */           if ((this.currentAddress_Country_en == null) || ("".equals(this.currentAddress_Country_en.trim()))) {
/*  831 */             this.crsComplete = false;
/*      */           }
/*  833 */           if ("ZhongGuo".equals(this.currentAddress_Country_en.trim())) {
/*  834 */             if ((this.currentAddress_Province_en == null) || 
/*  835 */               ("".equals(this.currentAddress_Province_en.trim()))) {
/*  836 */               this.crsComplete = false;
/*      */             }
/*  838 */             if ((this.currentAddress_City_en == null) || ("".equals(this.currentAddress_City_en.trim()))) {
/*  839 */               this.crsComplete = false;
/*      */             }
/*      */           }
/*  842 */           if ((this.currentAddress_Detail_en == null) || ("".equals(this.currentAddress_Detail_en.trim()))) {
/*  843 */             this.crsComplete = false;
/*      */           }
/*      */ 
/*  846 */           if ((this.birthAddress_Country_en == null) || ("".equals(this.birthAddress_Country_en.trim()))) {
/*  847 */             this.crsComplete = false;
/*      */           }
/*  849 */           if ("ZhongGuo".equals(this.birthAddress_Country_en.trim())) {
/*  850 */             if ((this.birthAddress_Province_en == null) || ("".equals(this.birthAddress_Province_en.trim()))) {
/*  851 */               this.crsComplete = false;
/*      */             }
/*  853 */             if ((this.birthAddress_City_en == null) || ("".equals(this.birthAddress_City_en.trim()))) {
/*  854 */               this.crsComplete = false;
/*      */             }
/*      */           }
/*      */ 
/*  858 */           if ((this.birthAddress_Detail != null) && (!"".equals(this.birthAddress_Detail.trim())) && (
/*  859 */             (this.birthAddress_Detail_en == null) || ("".equals(this.birthAddress_Detail_en.trim())))) {
/*  860 */             this.crsComplete = false;
/*      */           }
/*      */ 
/*  864 */           if (((this.taxpayerCode1 == null) || ("".equals(this.taxpayerCode1.trim()))) && 
/*  865 */             ((this.taxpayerCode2 == null) || ("".equals(this.taxpayerCode2.trim()))) && (
/*  866 */             (this.taxpayerCode3 == null) || ("".equals(this.taxpayerCode3.trim())))) {
/*  867 */             System.out.println("\u6821\u9A8C\u5FC5\u5F55\u9879\u672A\u586B\u5199\u8BC6\u522B\u53F7\uFF0C\u5219\u539F\u56E0\u5FC5\u586B");
/*  868 */             if ((this.noTaxpayercodeReason == null) || ("".equals(this.noTaxpayercodeReason.trim())) || ("2".equals(this.noTaxpayercodeReason.trim()))) {
/*  869 */               this.crsComplete = false;
/*      */             }
/*      */ 
/*      */           }
/*      */ 
/*  874 */           if (("2".equals(this.noTaxpayercodeReason.trim())) && 
/*  875 */             ((this.taxpayerCode1 == null) || ("".equals(this.taxpayerCode1.trim()))) && 
/*  876 */             ((this.taxpayerCode2 == null) || ("".equals(this.taxpayerCode2.trim()))) && (
/*  877 */             (this.taxpayerCode3 == null) || ("".equals(this.taxpayerCode3.trim())))) {
/*  878 */             this.crsComplete = false;
/*      */           }
/*      */ 
/*  882 */           if (((this.taxResidentCountry1 == null) || ("".equals(this.taxResidentCountry1.trim()))) && 
/*  883 */             ((this.taxResidentCountry2 == null) || ("".equals(this.taxResidentCountry2.trim()))) && (
/*  884 */             (this.taxResidentCountry3 == null) || ("".equals(this.taxResidentCountry3.trim())))) {
/*  885 */             this.crsComplete = false;
/*      */           }
/*      */ 
/*  888 */           if ("1".equals(this.noTaxpayercodeReason.trim())) {
/*  889 */             System.out.println("\u6821\u9A8C\u5FC5\u5F55\u9879\u586B\u5199\u4E86\u539F\u56E0\u4E3A1,\u6821\u9A8C\u539F\u56E0\u63CF\u8FF0");
/*  890 */             if ((this.reasonDescription == null) || ("".equals(this.reasonDescription.trim())))
/*  891 */               this.crsComplete = false;
/*      */           }
/*      */           else {
/*  894 */             System.out.println("\u6821\u9A8C\u5FC5\u5F55\u9879\u586B\u5199\u4E86\u539F\u56E0\u4E3A0\u62162,\u4E0D\u6821\u9A8C");
/*      */           }
/*      */         }
/*      */         else {
/*  898 */           System.out.println("\u6821\u9A8C\u5FC5\u5F55\u9879taxType=1\uFF0C\u4E0D\u6821\u9A8C\u5C45\u6C11\u4FE1\u606F");
/*  899 */           this.crsComplete = true;
/*      */         }
/*  901 */       } else if ("03".equals(this.AppntIDType.trim())) {
/*  902 */         System.out.println("\u6821\u9A8C\u5FC5\u5F55\u9879ID\u4E3A\u519B\u4EBA\u8BC1\uFF0C\u4E0D\u6821\u9A8CCRS\u4FE1\u606F");
/*  903 */         this.crsComplete = true;
/*      */       }
/*      */     }
/*      */ 
/*  907 */     return flag;
/*      */   }
/*      */ 
/*      */   private boolean saveCRSInfo(MMap tmap, CRSInfoBean crsBean, boolean hasFlag)
/*      */   {
/*  912 */     boolean flag = true;
/*  913 */     validateCRS("crs", crsBean);
/*      */ 
/*  916 */     System.out.println("this.crsComplete=" + this.crsComplete);
/*      */     try
/*      */     {
/*  919 */       crsBean.getSchema().setContNo(this.ContNo);
/*  920 */       crsBean.getSchema().setCustomerName(this.AppntName);
/*  921 */       if ("03".equals(this.AppntIDType.trim()))
/*  922 */         crsBean.getSchema().setTaxResidentType("");
/*      */       else {
/*  924 */         crsBean.getSchema().setTaxResidentType(this.taxResidentType);
/*      */       }
/*  926 */       crsBean.getSchema().setFirstName(this.firstName);
/*  927 */       crsBean.getSchema().setLastName(this.lastName);
/*  928 */       crsBean.getSchema().setBirthday(this.AppntBirthDay);
/*  929 */       crsBean.getSchema().setCurrentAddress_Country("\u4E2D\u56FD");
/*  930 */       crsBean.getSchema().setCurrentAddress_Province(getAddressName(this.appntCompanyProvince));
/*  931 */       crsBean.getSchema().setCurrentAddress_City(getAddressName(this.appntCompanyCity));
/*  932 */       crsBean.getSchema().setCurrentAddress_Detail(this.currentAddress_Detail);
/*  933 */       crsBean.getSchema().setCurrentAddress_Country_en("CN");
/*  934 */       crsBean.getSchema().setCurrentAddress_Province_en(this.currentAddress_Province_en);
/*  935 */       crsBean.getSchema().setCurrentAddress_City_en(this.currentAddress_City_en);
/*  936 */       crsBean.getSchema().setCurrentAddress_Detail_en(this.currentAddress_Detail_en);
/*  937 */       crsBean.getSchema().setBirthAddress_Country(getCName(this.birthAddress_Country, ""));
/*  938 */       crsBean.getSchema().setBirthAddress_Country_en(getCName(this.birthAddress_Country_en, "e"));
/*  939 */       crsBean.getSchema().setBirthAddress_Province(getAddressName(this.birthAddress_Province));
/*  940 */       crsBean.getSchema().setBirthAddress_Province_en(this.birthAddress_Province_en);
/*  941 */       crsBean.getSchema().setBirthAddress_City(getAddressName(this.birthAddress_City));
/*  942 */       crsBean.getSchema().setBirthAddress_City_en(this.birthAddress_City_en);
/*  943 */       crsBean.getSchema().setBirthAddress_Detail(this.birthAddress_Detail);
/*  944 */       crsBean.getSchema().setBirthAddress_Detail_en(this.birthAddress_Detail_en);
/*  945 */       crsBean.getSchema().setTaxpayerCode1(this.taxpayerCode1);
/*  946 */       crsBean.getSchema().setTaxpayerCode2(this.taxpayerCode2);
/*  947 */       crsBean.getSchema().setTaxpayerCode3(this.taxpayerCode3);
/*  948 */       crsBean.getSchema().setTaxResidentCountry1(this.taxResidentCountry1);
/*  949 */       crsBean.getSchema().setTaxResidentCountry2(this.taxResidentCountry2);
/*  950 */       crsBean.getSchema().setTaxResidentCountry3(this.taxResidentCountry3);
/*  951 */       if (((this.taxpayerCode1 != null) && (!"".equals(this.taxpayerCode1.trim()))) || 
/*  952 */         ((this.taxpayerCode2 != null) && (!"".equals(this.taxpayerCode2.trim()))) || (
/*  953 */         (this.taxpayerCode3 != null) && (!"".equals(this.taxpayerCode3.trim())))) {
/*  954 */         this.noTaxpayercodeReason = "2";
/*      */       }
/*  956 */       crsBean.getSchema().setNoTaxpayercodeReason(this.noTaxpayercodeReason);
/*  957 */       crsBean.getSchema().setReasonDescription(this.reasonDescription);
/*  958 */       crsBean.getSchema().setSourceType("ONBOARDING");
/*      */ 
/*  960 */       System.out.println("\u628ABean\u4E2D\u5B57\u6BB5\u6570\u636E\u8D4B\u503C\u4E3A\u9875\u9762\u8F93\u5165\u6570\u636E");
/*  961 */       System.out.println("\u5C06CRS Schema\u4F5C\u4E3Akey\uFF0C\u64CD\u4F5C\u4F5C\u4E3Avalue\u5B58\u50A8\u5728Map\u4E2D=" + crsBean.getSchema().toString());
/*      */ 
/*  965 */       tmap.put(crsBean.getSchema(), "UPDATE");
/*  966 */       System.out.println("\u6267\u884Ccrs\u66F4\u65B0\u64CD\u4F5C");
/*      */     }
/*      */     catch (Exception e) {
/*  969 */       e.printStackTrace();
/*  970 */       buildError(e.getMessage());
/*      */     }
/*  972 */     return flag;
/*      */   }
/*      */ 
/*      */   private boolean saveAppntMsg(MMap tmap, boolean hasFlag, BankLNPContBean contBean, BankLNPAppntBean appntBean, BankLNPPersonBean personBean, BankLNPAddressBean addressBean, String curDate, String curTime)
/*      */   {
/*  978 */     boolean flag = true;
/*  979 */     if (!validate("appnt", contBean, appntBean, null, null, personBean, addressBean)) {
/*  980 */       return false;
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  985 */       appntBean.getSchema().setRelationToInsured(this.AIRealation);
/*      */ 
/*  987 */       if ("01".equals(this.AIRealation)) {
/*  988 */         copyAppntMsgToInsurMsg();
/*      */       }
/*  990 */       appntBean.getSchema().setAppntGrade(this.AppntVIP);
/*  991 */       appntBean.getSchema().setAppntName(this.AppntName);
/*  992 */       appntBean.getSchema().setAppntSex(this.AppntSex);
/*  993 */       appntBean.getSchema().setAppntBirthday(this.AppntBirthDay);
/*      */ 
/*  995 */       String ageType = "";
/*  996 */       String agePer = this.AppntAge;
/*  997 */       if ((agePer != null) && (!"".equals(agePer))) {
/*  998 */         if (agePer.indexOf("\u5929") > -1) {
/*  999 */           ageType = "D";
/* 1000 */           agePer = agePer.substring(0, agePer.indexOf("\uFF08"));
/*      */         } else {
/* 1002 */           ageType = "Y";
/* 1003 */           agePer = agePer.substring(0, agePer.indexOf("\uFF08"));
/*      */         }
/*      */       }
/* 1006 */       appntBean.getSchema().setAppntAge(agePer);
/* 1007 */       appntBean.getSchema().setAppntAgeType(ageType);
/*      */ 
/* 1009 */       appntBean.getSchema().setIDType(this.AppntIDType);
/* 1010 */       appntBean.getSchema().setIDNo(this.AppntID);
/* 1011 */       appntBean.getSchema().setIDPerpetual(this.AppntIDVailityType);
/* 1012 */       if ("0".equals(this.AppntIDVailityType))
/* 1013 */         appntBean.getSchema().setIDValidity("99991231");
/*      */       else {
/* 1015 */         appntBean.getSchema().setIDValidity(this.AppntIDVaility);
/*      */       }
/* 1017 */       appntBean.getSchema().setNativePlace(this.AppntNative);
/* 1018 */       appntBean.getSchema().setHealth(this.AppntIDView);
/* 1019 */       addressBean.getSchema().setGrpName(this.AppntGrpName);
/* 1020 */       appntBean.getSchema().setOccupationCode(this.AOccupationCode);
/*      */ 
/* 1022 */       addressBean.getSchema().setCompanyPhone(this.AppntCompanyPhone);
/* 1023 */       addressBean.getSchema().setCompanyZipCode(this.AppntCompanyZipCode);
/* 1024 */       addressBean.getSchema().setPhone(this.AppntIPhone);
/* 1025 */       addressBean.getSchema().setCompanyMail(this.AppntCompanyMail);
/* 1026 */       appntBean.getSchema()
/* 1027 */         .setSalary(turnNullToString(this.AppntSalary).trim().equals("") ? "-1" : this.AppntSalary);
/* 1028 */       addressBean.getSchema().setPostalAddress(this.AppntLinkAdr);
/* 1029 */       addressBean.getSchema().setHomeZipCode(this.AppntHomeZipCode);
/*      */ 
/* 1032 */       addressBean.getSchema().setMobileChs2(this.appntAreaCode);
/* 1033 */       addressBean.getSchema().setCompanyFax(this.appntCompanyProvince);
/* 1034 */       addressBean.getSchema().setBP2(this.appntCompanyCity);
/* 1035 */       addressBean.getSchema().setMobile2(this.appntCompanyCounty);
/* 1036 */       addressBean.getSchema().setCompanyAddress(this.appntCompanyRoad);
/* 1037 */       addressBean.getSchema().setEMail2(this.appntCompanyVillage);
/* 1038 */       addressBean.getSchema().setHomeFax(this.appntHomeProvince);
/* 1039 */       addressBean.getSchema().setBP(this.appntHomeCity);
/* 1040 */       addressBean.getSchema().setHomePhone(this.appntHomeCounty);
/* 1041 */       addressBean.getSchema().setHomeAddress(this.appntHomeRoad);
/* 1042 */       addressBean.getSchema().setEMail(this.appntHomeVillage);
/*      */ 
/* 1044 */       if (hasFlag)
/*      */       {
/* 1046 */         addressBean.getSchema().setOperator(this.GI.Operator);
/* 1047 */         addressBean.getSchema().setModifyDate(curDate);
/* 1048 */         addressBean.getSchema().setModifyTime(curTime);
/*      */ 
/* 1050 */         appntBean.getSchema().setOperator(this.GI.Operator);
/* 1051 */         appntBean.getSchema().setModifyDate(curDate);
/* 1052 */         appntBean.getSchema().setModifyTime(curTime);
/*      */ 
/* 1054 */         personBean.getSchema().setOperator(this.GI.Operator);
/* 1055 */         personBean.getSchema().setModifyDate(curDate);
/* 1056 */         personBean.getSchema().setModifyTime(curTime);
/*      */ 
/* 1058 */         contBean.getSchema().setModifyDate(curDate);
/* 1059 */         contBean.getSchema().setModifyTime(curTime);
/*      */       }
/*      */       else {
/* 1062 */         SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
/* 1063 */         appntBean.getSchema().setAppntId(maxNoMap.CreateMaxNo("CustomerNo", ""));
/*      */ 
/* 1065 */         addressBean.getSchema().setAddressNo(maxNoMap.CreateMaxNo("LNPAddRNo", ""));
/* 1066 */         appntBean.getSchema().setAddressNo(addressBean.getSchema().getAddressNo());
/*      */ 
/* 1068 */         contBean.getSchema().setModifyDate(curDate);
/* 1069 */         contBean.getSchema().setModifyTime(curTime);
/*      */ 
/* 1071 */         addressBean.getSchema().setOperator(this.GI.Operator);
/* 1072 */         addressBean.getSchema().setModifyDate(curDate);
/* 1073 */         addressBean.getSchema().setModifyTime(curTime);
/* 1074 */         addressBean.getSchema().setMakeDate(curDate);
/* 1075 */         addressBean.getSchema().setMakeTime(curTime);
/*      */ 
/* 1077 */         appntBean.getSchema().setOperator(this.GI.Operator);
/* 1078 */         appntBean.getSchema().setModifyDate(curDate);
/* 1079 */         appntBean.getSchema().setModifyTime(curTime);
/* 1080 */         appntBean.getSchema().setMakeDate(curDate);
/* 1081 */         appntBean.getSchema().setMakeTime(curTime);
/*      */ 
/* 1083 */         personBean.getSchema().setOperator(this.GI.Operator);
/* 1084 */         personBean.getSchema().setModifyDate(curDate);
/* 1085 */         personBean.getSchema().setModifyTime(curTime);
/* 1086 */         personBean.getSchema().setMakeDate(curDate);
/* 1087 */         personBean.getSchema().setMakeTime(curTime);
/*      */       }
/*      */ 
/* 1090 */       appntBean.getSchema().setGrpContNo(contBean.getSchema().getGrpContNo());
/* 1091 */       appntBean.getSchema().setPrtNo(contBean.getSchema().getPrtNo());
/* 1092 */       appntBean.getSchema().setContNo(contBean.getSchema().getContNo());
/* 1093 */       appntBean.getSchema().setProposalContNo(contBean.getSchema().getProposalContNo());
/*      */ 
/* 1095 */       personBean.getSchema().setAgentCode(appntBean.getSchema().getOperator());
/* 1096 */       personBean.getSchema().setCustomerId(appntBean.getSchema().getAppntId());
/* 1097 */       personBean.getSchema().setName(appntBean.getSchema().getAppntName());
/* 1098 */       personBean.getSchema().setSex(appntBean.getSchema().getAppntSex());
/* 1099 */       personBean.getSchema().setBirthday(appntBean.getSchema().getAppntBirthday());
/* 1100 */       personBean.getSchema().setIDType(appntBean.getSchema().getIDType());
/* 1101 */       personBean.getSchema().setIDNo(appntBean.getSchema().getIDNo());
/* 1102 */       personBean.getSchema().setNativePlace(appntBean.getSchema().getNativePlace());
/* 1103 */       personBean.getSchema().setOccupationCode(appntBean.getSchema().getOccupationCode());
/* 1104 */       personBean.getSchema().setAge(appntBean.getSchema().getAppntAge());
/* 1105 */       personBean.getSchema().setAgeType(appntBean.getSchema().getAppntAgeType());
/* 1106 */       personBean.getSchema().setIDPerpetual(appntBean.getSchema().getIDPerpetual());
/* 1107 */       personBean.getSchema().setIDValidity(appntBean.getSchema().getIDValidity());
/*      */ 
/* 1109 */       addressBean.getSchema().setCustomerId(appntBean.getSchema().getAppntId());
/*      */ 
/* 1111 */       contBean.getSchema().setAppntId(appntBean.getSchema().getAppntId());
/* 1112 */       contBean.getSchema().setAppntNo(appntBean.getSchema().getAppntNo());
/* 1113 */       contBean.getSchema().setAppntName(appntBean.getSchema().getAppntName());
/* 1114 */       contBean.getSchema().setAppntBirthday(appntBean.getSchema().getAppntBirthday());
/* 1115 */       contBean.getSchema().setAppntIDType(appntBean.getSchema().getIDType());
/* 1116 */       contBean.getSchema().setAppntIDNo(appntBean.getSchema().getIDNo());
/* 1117 */       contBean.getSchema().setAppntSex(appntBean.getSchema().getAppntSex());
/* 1118 */       contBean.getSchema().setInputOperator(this.GI.Operator);
/*      */ 
/* 1120 */       if (hasFlag) {
/* 1121 */         tmap.put(appntBean.getSchema(), "UPDATE");
/* 1122 */         tmap.put(personBean.getSchema(), "UPDATE");
/* 1123 */         tmap.put(addressBean.getSchema(), "UPDATE");
/*      */       } else {
/* 1125 */         tmap.put(appntBean.getSchema(), "INSERT");
/* 1126 */         tmap.put(personBean.getSchema(), "INSERT");
/* 1127 */         tmap.put(addressBean.getSchema(), "INSERT");
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1131 */       e.printStackTrace();
/* 1132 */       buildError(e.getMessage());
/*      */     }
/* 1134 */     return flag;
/*      */   }
/*      */ 
/*      */   private boolean saveInusredMsg(MMap tmap, boolean hasFlag, BankLNPContBean contBean, BankLNPInusredBean insuredBean, BankLNPPersonBean personBean, BankLNPAddressBean addressBean, String curDate, String curTime)
/*      */   {
/* 1139 */     boolean flag = true;
/* 1140 */     if (!validate("insured", contBean, null, insuredBean, null, personBean, addressBean)) {
/* 1141 */       return false;
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1146 */       insuredBean.getSchema().setName(this.InsurName);
/* 1147 */       insuredBean.getSchema().setSex(this.InsurSex);
/* 1148 */       insuredBean.getSchema().setBirthday(this.InsurBirthDay);
/*      */ 
/* 1150 */       String ageType = "";
/* 1151 */       String agePer = this.InsurAge;
/* 1152 */       if ((agePer != null) && (!"".equals(agePer))) {
/* 1153 */         if (agePer.indexOf("\u5929") > -1) {
/* 1154 */           ageType = "D";
/* 1155 */           agePer = agePer.substring(0, agePer.indexOf("\uFF08"));
/*      */         } else {
/* 1157 */           ageType = "Y";
/* 1158 */           agePer = agePer.substring(0, agePer.indexOf("\uFF08"));
/*      */         }
/*      */       }
/* 1161 */       insuredBean.getSchema().setAppAge(agePer);
/* 1162 */       insuredBean.getSchema().setAppAgeType(ageType);
/*      */ 
/* 1164 */       insuredBean.getSchema().setIDType(this.InsurIDType);
/* 1165 */       insuredBean.getSchema().setIDNo(this.InsurID);
/* 1166 */       insuredBean.getSchema().setIDPerpetual(this.InsurIDVailityType);
/* 1167 */       if ("0".equals(this.InsurIDVailityType))
/* 1168 */         insuredBean.getSchema().setIDValidity("99991231");
/*      */       else {
/* 1170 */         insuredBean.getSchema().setIDValidity(this.InsurIDVaility);
/*      */       }
/* 1172 */       insuredBean.getSchema().setNativePlace(this.InsurNative);
/* 1173 */       insuredBean.getSchema().setHealth(this.InsurIDView);
/* 1174 */       addressBean.getSchema().setGrpName(this.InsurGrpName);
/* 1175 */       insuredBean.getSchema().setOccupationCode(this.IOccupationCode);
/*      */ 
/* 1177 */       addressBean.getSchema().setCompanyPhone(this.InsurCompanyPhone);
/* 1178 */       addressBean.getSchema().setCompanyZipCode(this.InsurCompanyZipCode);
/* 1179 */       addressBean.getSchema().setPhone(this.InsurIPhone);
/* 1180 */       addressBean.getSchema().setCompanyMail(this.InsurCompanyMail);
/* 1181 */       insuredBean.getSchema()
/* 1182 */         .setSalary(turnNullToString(this.InsurSalary).trim().equals("") ? "-1" : this.InsurSalary);
/* 1183 */       addressBean.getSchema().setPostalAddress(this.InsurLinkAdr);
/* 1184 */       addressBean.getSchema().setHomeZipCode(this.InsurHomeZipCode);
/*      */ 
/* 1186 */       insuredBean.getSchema().setInsuredPeoples(this.BnfIsExist);
/* 1187 */       insuredBean.getSchema().setCreditGrade(this.BnfRecType);
/*      */ 
/* 1189 */       addressBean.getSchema().setMobileChs2(this.insuAreaCode);
/* 1190 */       addressBean.getSchema().setCompanyFax(this.insurCompanyProvince);
/* 1191 */       addressBean.getSchema().setBP2(this.insurCompanyCity);
/* 1192 */       addressBean.getSchema().setMobile2(this.insurCompanyCounty);
/* 1193 */       addressBean.getSchema().setCompanyAddress(this.insurCompanyRoad);
/* 1194 */       addressBean.getSchema().setEMail2(this.insurCompanyVillage);
/* 1195 */       addressBean.getSchema().setHomeFax(this.insurHomeProvince);
/* 1196 */       addressBean.getSchema().setBP(this.insurHomeCity);
/* 1197 */       addressBean.getSchema().setHomePhone(this.insurHomeCounty);
/* 1198 */       addressBean.getSchema().setHomeAddress(this.insurHomeRoad);
/* 1199 */       addressBean.getSchema().setEMail(this.insurHomeVillage);
/*      */ 
/* 1201 */       if (hasFlag)
/*      */       {
/* 1203 */         addressBean.getSchema().setOperator(this.GI.Operator);
/* 1204 */         addressBean.getSchema().setModifyDate(curDate);
/* 1205 */         addressBean.getSchema().setModifyTime(curTime);
/*      */ 
/* 1207 */         insuredBean.getSchema().setOperator(this.GI.Operator);
/* 1208 */         insuredBean.getSchema().setModifyDate(curDate);
/* 1209 */         insuredBean.getSchema().setModifyTime(curTime);
/*      */ 
/* 1211 */         personBean.getSchema().setOperator(this.GI.Operator);
/* 1212 */         personBean.getSchema().setModifyDate(curDate);
/* 1213 */         personBean.getSchema().setModifyTime(curTime);
/*      */ 
/* 1215 */         contBean.getSchema().setModifyDate(curDate);
/* 1216 */         contBean.getSchema().setModifyTime(curTime);
/*      */       }
/*      */       else {
/* 1219 */         SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
/* 1220 */         insuredBean.getSchema().setInsuredId(maxNoMap.CreateMaxNo("CustomerNo", ""));
/* 1221 */         insuredBean.getSchema().setAppntId(contBean.getSchema().getAppntId());
/*      */ 
/* 1223 */         addressBean.getSchema().setAddressNo(maxNoMap.CreateMaxNo("LNPAddRNo", ""));
/* 1224 */         insuredBean.getSchema().setAddressNo(addressBean.getSchema().getAddressNo());
/*      */ 
/* 1226 */         contBean.getSchema().setModifyDate(curDate);
/* 1227 */         contBean.getSchema().setModifyTime(curTime);
/*      */ 
/* 1229 */         addressBean.getSchema().setOperator(this.GI.Operator);
/* 1230 */         addressBean.getSchema().setModifyDate(curDate);
/* 1231 */         addressBean.getSchema().setModifyTime(curTime);
/* 1232 */         addressBean.getSchema().setMakeDate(curDate);
/* 1233 */         addressBean.getSchema().setMakeTime(curTime);
/*      */ 
/* 1235 */         insuredBean.getSchema().setOperator(this.GI.Operator);
/* 1236 */         insuredBean.getSchema().setModifyDate(curDate);
/* 1237 */         insuredBean.getSchema().setModifyTime(curTime);
/* 1238 */         insuredBean.getSchema().setMakeDate(curDate);
/* 1239 */         insuredBean.getSchema().setMakeTime(curTime);
/*      */ 
/* 1241 */         personBean.getSchema().setOperator(this.GI.Operator);
/* 1242 */         personBean.getSchema().setModifyDate(curDate);
/* 1243 */         personBean.getSchema().setModifyTime(curTime);
/* 1244 */         personBean.getSchema().setMakeDate(curDate);
/* 1245 */         personBean.getSchema().setMakeTime(curTime);
/*      */       }
/*      */ 
/* 1248 */       insuredBean.getSchema().setGrpContNo(contBean.getSchema().getGrpContNo());
/* 1249 */       insuredBean.getSchema().setPrtNo(contBean.getSchema().getPrtNo());
/* 1250 */       insuredBean.getSchema().setContNo(contBean.getSchema().getContNo());
/* 1251 */       insuredBean.getSchema().setProposalContNo(contBean.getSchema().getProposalContNo());
/*      */ 
/* 1253 */       personBean.getSchema().setAgentCode(insuredBean.getSchema().getOperator());
/* 1254 */       personBean.getSchema().setCustomerId(insuredBean.getSchema().getInsuredId());
/* 1255 */       personBean.getSchema().setName(insuredBean.getSchema().getName());
/* 1256 */       personBean.getSchema().setSex(insuredBean.getSchema().getSex());
/* 1257 */       personBean.getSchema().setBirthday(insuredBean.getSchema().getBirthday());
/* 1258 */       personBean.getSchema().setIDType(insuredBean.getSchema().getIDType());
/* 1259 */       personBean.getSchema().setIDNo(insuredBean.getSchema().getIDNo());
/* 1260 */       personBean.getSchema().setNativePlace(insuredBean.getSchema().getNativePlace());
/* 1261 */       personBean.getSchema().setOccupationCode(insuredBean.getSchema().getOccupationCode());
/* 1262 */       personBean.getSchema().setAge(insuredBean.getSchema().getAppAge());
/* 1263 */       personBean.getSchema().setAgeType(insuredBean.getSchema().getAppAgeType());
/* 1264 */       personBean.getSchema().setIDPerpetual(insuredBean.getSchema().getIDPerpetual());
/* 1265 */       personBean.getSchema().setIDValidity(insuredBean.getSchema().getIDValidity());
/*      */ 
/* 1267 */       addressBean.getSchema().setCustomerId(insuredBean.getSchema().getInsuredId());
/*      */ 
/* 1269 */       contBean.getSchema().setInsuredId(insuredBean.getSchema().getInsuredId());
/* 1270 */       contBean.getSchema().setInsuredNo(insuredBean.getSchema().getInsuredNo());
/* 1271 */       contBean.getSchema().setInsuredName(insuredBean.getSchema().getName());
/* 1272 */       contBean.getSchema().setInsuredBirthday(insuredBean.getSchema().getBirthday());
/* 1273 */       contBean.getSchema().setInsuredIDType(insuredBean.getSchema().getIDType());
/* 1274 */       contBean.getSchema().setInsuredIDNo(insuredBean.getSchema().getIDNo());
/* 1275 */       contBean.getSchema().setInsuredSex(insuredBean.getSchema().getSex());
/* 1276 */       contBean.getSchema().setInputOperator(this.GI.Operator);
/*      */ 
/* 1278 */       if (hasFlag) {
/* 1279 */         tmap.put(insuredBean.getSchema(), "UPDATE");
/* 1280 */         tmap.put(addressBean.getSchema(), "UPDATE");
/* 1281 */         tmap.put(personBean.getSchema(), "UPDATE");
/*      */       } else {
/* 1283 */         tmap.put(insuredBean.getSchema(), "INSERT");
/* 1284 */         tmap.put(addressBean.getSchema(), "INSERT");
/* 1285 */         tmap.put(personBean.getSchema(), "INSERT");
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1289 */       e.printStackTrace();
/* 1290 */       buildError(e.getMessage());
/*      */     }
/* 1292 */     return flag;
/*      */   }
/*      */ 
/*      */   private boolean saveBnfMsg(MMap tmap, boolean hasFlag, BankLNPContBean contBean, List<BankLNPBnfBean> bnfList, List<BankLNPBnfBean> delBnfList, String curDate, String curTime)
/*      */   {
/* 1297 */     boolean flag = true;
/* 1298 */     if (!validate("bnf", contBean, null, null, bnfList, null, null))
/* 1299 */       return false;
/*      */     try
/*      */     {
/* 1302 */       this.bnfValiList.clear();
/*      */ 
/* 1304 */       if ((this.insuredBean.getSchema().getInsuredPeoples() == 1) && (bnfList != null) && (bnfList.size() > 0))
/*      */       {
/* 1306 */         ExeSQL execSql = new ExeSQL();
/* 1307 */         SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
/* 1308 */         LNPBnfSet bnfSchemaSet = new LNPBnfSet();
/* 1309 */         for (int i = 0; i < bnfList.size(); i++) {
/* 1310 */           BankLNPBnfBean curBnfBean = (BankLNPBnfBean)bnfList.get(i);
/* 1311 */           if (curBnfBean.isValidate()) {
/* 1312 */             if (hasFlag) {
/* 1313 */               boolean existsflag = bnfExists(contBean.getSchema().getContNo(), 
/* 1314 */                 curBnfBean.getSchema().getBnfId(), execSql);
/* 1315 */               if (existsflag) {
/* 1316 */                 curBnfBean.getSchema().setOperator(this.GI.Operator);
/* 1317 */                 curBnfBean.getSchema().setManageCom(contBean.getSchema().getSignCom());
/* 1318 */                 curBnfBean.getSchema().setModifyDate(curDate);
/* 1319 */                 curBnfBean.getSchema().setModifyTime(curTime);
/*      */               } else {
/* 1321 */                 curBnfBean.getSchema().setBnfId(maxNoMap.CreateMaxNo("CustomerNo", ""));
/* 1322 */                 curBnfBean.getSchema().setOperator(this.GI.Operator);
/* 1323 */                 curBnfBean.getSchema().setManageCom(contBean.getSchema().getSignCom());
/* 1324 */                 curBnfBean.getSchema().setMakeDate(curDate);
/* 1325 */                 curBnfBean.getSchema().setMakeTime(curTime);
/* 1326 */                 curBnfBean.getSchema().setModifyDate(curDate);
/* 1327 */                 curBnfBean.getSchema().setModifyTime(curTime);
/*      */               }
/*      */             } else {
/* 1330 */               curBnfBean.getSchema().setBnfId(maxNoMap.CreateMaxNo("CustomerNo", ""));
/* 1331 */               curBnfBean.getSchema().setOperator(this.GI.Operator);
/* 1332 */               curBnfBean.getSchema().setManageCom(contBean.getSchema().getSignCom());
/* 1333 */               curBnfBean.getSchema().setMakeDate(curDate);
/* 1334 */               curBnfBean.getSchema().setMakeTime(curTime);
/* 1335 */               curBnfBean.getSchema().setModifyDate(curDate);
/* 1336 */               curBnfBean.getSchema().setModifyTime(curTime);
/*      */             }
/*      */ 
/* 1339 */             curBnfBean.getSchema().setBenefitType("2");
/* 1340 */             curBnfBean.getSchema().setCreditGrade(this.insuredBean.getSchema().getCreditGrade());
/* 1341 */             curBnfBean.getSchema().setContNo(contBean.getSchema().getContNo());
/* 1342 */             curBnfBean.getSchema().setInsuredId(contBean.getSchema().getInsuredId());
/* 1343 */             if ("0".equals(curBnfBean.getSchema().getIDPerpetual())) {
/* 1344 */               curBnfBean.setIDVaility("99991231");
/*      */             }
/* 1346 */             bnfSchemaSet.add(curBnfBean.getSchema());
/* 1347 */             this.bnfValiList.add(curBnfBean);
/*      */           }
/*      */         }
/*      */ 
/* 1351 */         if (hasFlag)
/* 1352 */           tmap.put(bnfSchemaSet, "DELETE&INSERT");
/*      */         else {
/* 1354 */           tmap.put(bnfSchemaSet, "INSERT");
/*      */         }
/*      */ 
/* 1357 */         if (delBnfList.size() > 0) {
/* 1358 */           LNPBnfSet delBnfSchemaSet = new LNPBnfSet();
/* 1359 */           for (int i = 0; i < delBnfList.size(); i++) {
/* 1360 */             BankLNPBnfBean curBnfBean = (BankLNPBnfBean)delBnfList.get(i);
/* 1361 */             curBnfBean.getSchema().setHealth("delete");
/* 1362 */             delBnfSchemaSet.add(curBnfBean.getSchema());
/*      */           }
/* 1364 */           tmap.put(delBnfSchemaSet, "UPDATE");
/* 1365 */           this.delBnfList = new ArrayList();
/*      */         }
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/* 1372 */         LNPBnfDB db = new LNPBnfDB();
/* 1373 */         db.setContNo(this.ContNo);
/* 1374 */         LNPBnfSet delBnfSchemaSet = db.query();
/* 1375 */         for (int i = 1; i <= delBnfSchemaSet.size(); i++) {
/* 1376 */           delBnfSchemaSet.get(i).setHealth("delete");
/* 1377 */           delBnfSchemaSet.get(i).setModifyDate(curDate);
/* 1378 */           delBnfSchemaSet.get(i).setModifyTime(curTime);
/* 1379 */           delBnfSchemaSet.get(i).setOperator(this.GI.Operator);
/*      */         }
/* 1381 */         tmap.put(delBnfSchemaSet, "UPDATE");
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1385 */       e.printStackTrace();
/* 1386 */       buildError(e.getMessage());
/*      */     }
/*      */ 
/* 1389 */     return flag;
/*      */   }
/*      */ 
/*      */   private void dealAddrMsg(BankLNPAddressBean appntAddressBean, BankLNPAddressBean insurAddressBean) {
/*      */     try {
/* 1394 */       String tAIRelation = this.appntBean.getSchema().getRelationToInsured();
/* 1395 */       if ("".equals(tAIRelation.trim())) {
/* 1396 */         String appntLinkAdrType = appntAddressBean.getSchema().getPostalAddress();
/* 1397 */         if ("0".equals(appntLinkAdrType))
/*      */         {
/* 1399 */           appntAddressBean.getSchema().setHomeZipCode(this.AppntCompanyZipCode);
/*      */ 
/* 1401 */           appntAddressBean.getSchema().setHomeFax(this.appntCompanyProvince);
/* 1402 */           appntAddressBean.getSchema().setBP(this.appntCompanyCity);
/* 1403 */           appntAddressBean.getSchema().setHomePhone(this.appntCompanyCounty);
/* 1404 */           appntAddressBean.getSchema().setHomeAddress(this.appntCompanyRoad);
/* 1405 */           appntAddressBean.getSchema().setEMail(this.appntCompanyVillage);
/*      */         }
/* 1407 */         else if ("1".equals(appntLinkAdrType))
/*      */         {
/* 1409 */           appntAddressBean.getSchema().setHomeZipCode(this.InsurCompanyZipCode);
/*      */ 
/* 1411 */           appntAddressBean.getSchema().setHomeFax(this.insurCompanyProvince);
/* 1412 */           appntAddressBean.getSchema().setBP(this.insurCompanyCity);
/* 1413 */           appntAddressBean.getSchema().setHomePhone(this.insurCompanyCounty);
/* 1414 */           appntAddressBean.getSchema().setHomeAddress(this.insurCompanyRoad);
/* 1415 */           appntAddressBean.getSchema().setEMail(this.insurCompanyVillage);
/*      */         }
/*      */ 
/* 1418 */         String insurLinkAdrType = insurAddressBean.getSchema().getPostalAddress();
/* 1419 */         if ("0".equals(insurLinkAdrType))
/*      */         {
/* 1421 */           insurAddressBean.getSchema().setHomeZipCode(this.AppntCompanyZipCode);
/*      */ 
/* 1423 */           insurAddressBean.getSchema().setHomeFax(this.appntCompanyProvince);
/* 1424 */           insurAddressBean.getSchema().setBP(this.appntCompanyCity);
/* 1425 */           insurAddressBean.getSchema().setHomePhone(this.appntCompanyCounty);
/* 1426 */           insurAddressBean.getSchema().setHomeAddress(this.appntCompanyRoad);
/* 1427 */           insurAddressBean.getSchema().setEMail(this.appntCompanyVillage);
/*      */         }
/* 1429 */         else if ("1".equals(insurLinkAdrType))
/*      */         {
/* 1431 */           insurAddressBean.getSchema().setHomeZipCode(this.InsurCompanyZipCode);
/*      */ 
/* 1433 */           insurAddressBean.getSchema().setHomeFax(this.insurCompanyProvince);
/* 1434 */           insurAddressBean.getSchema().setBP(this.insurCompanyCity);
/* 1435 */           insurAddressBean.getSchema().setHomePhone(this.insurCompanyCounty);
/* 1436 */           insurAddressBean.getSchema().setHomeAddress(this.insurCompanyRoad);
/* 1437 */           insurAddressBean.getSchema().setEMail(this.insurCompanyVillage);
/*      */         }
/*      */       }
/* 1440 */       else if ("01".equals(tAIRelation)) {
/* 1441 */         String tLinkAdrType = appntAddressBean.getSchema().getPostalAddress();
/* 1442 */         if ("0".equals(tLinkAdrType))
/*      */         {
/* 1444 */           appntAddressBean.getSchema().setHomeZipCode(this.AppntCompanyZipCode);
/*      */ 
/* 1446 */           appntAddressBean.getSchema().setHomeFax(this.appntCompanyProvince);
/* 1447 */           appntAddressBean.getSchema().setBP(this.appntCompanyCity);
/* 1448 */           appntAddressBean.getSchema().setHomePhone(this.appntCompanyCounty);
/* 1449 */           appntAddressBean.getSchema().setHomeAddress(this.appntCompanyRoad);
/* 1450 */           appntAddressBean.getSchema().setEMail(this.appntCompanyVillage);
/*      */         }
/* 1452 */         else if ("1".equals(tLinkAdrType))
/*      */         {
/* 1454 */           appntAddressBean.getSchema().setHomeZipCode(this.InsurCompanyZipCode);
/*      */ 
/* 1456 */           appntAddressBean.getSchema().setHomeFax(this.insurCompanyProvince);
/* 1457 */           appntAddressBean.getSchema().setBP(this.insurCompanyCity);
/* 1458 */           appntAddressBean.getSchema().setHomePhone(this.insurCompanyCounty);
/* 1459 */           appntAddressBean.getSchema().setHomeAddress(this.insurCompanyRoad);
/* 1460 */           appntAddressBean.getSchema().setEMail(this.insurCompanyVillage);
/*      */         }
/*      */ 
/* 1464 */         insurAddressBean.getSchema().setHomeZipCode(appntAddressBean.getSchema().getHomeZipCode());
/*      */ 
/* 1466 */         insurAddressBean.getSchema().setHomeFax(appntAddressBean.getSchema().getHomeFax());
/* 1467 */         insurAddressBean.getSchema().setBP(appntAddressBean.getSchema().getBP());
/* 1468 */         insurAddressBean.getSchema().setHomePhone(appntAddressBean.getSchema().getHomePhone());
/* 1469 */         insurAddressBean.getSchema().setHomeAddress(appntAddressBean.getSchema().getHomeAddress());
/* 1470 */         insurAddressBean.getSchema().setEMail(appntAddressBean.getSchema().getEMail());
/*      */       } else {
/* 1472 */         String tLinkAdrType = insurAddressBean.getSchema().getPostalAddress();
/* 1473 */         if ("0".equals(tLinkAdrType))
/*      */         {
/* 1475 */           insurAddressBean.getSchema().setHomeZipCode(this.AppntCompanyZipCode);
/*      */ 
/* 1477 */           insurAddressBean.getSchema().setHomeFax(this.appntCompanyProvince);
/* 1478 */           insurAddressBean.getSchema().setBP(this.appntCompanyCity);
/* 1479 */           insurAddressBean.getSchema().setHomePhone(this.appntCompanyCounty);
/* 1480 */           insurAddressBean.getSchema().setHomeAddress(this.appntCompanyRoad);
/* 1481 */           insurAddressBean.getSchema().setEMail(this.appntCompanyVillage);
/*      */         }
/* 1483 */         else if ("1".equals(tLinkAdrType))
/*      */         {
/* 1485 */           insurAddressBean.getSchema().setHomeZipCode(this.InsurCompanyZipCode);
/*      */ 
/* 1487 */           insurAddressBean.getSchema().setHomeFax(this.insurCompanyProvince);
/* 1488 */           insurAddressBean.getSchema().setBP(this.insurCompanyCity);
/* 1489 */           insurAddressBean.getSchema().setHomePhone(this.insurCompanyCounty);
/* 1490 */           insurAddressBean.getSchema().setHomeAddress(this.insurCompanyRoad);
/* 1491 */           insurAddressBean.getSchema().setEMail(this.insurCompanyVillage);
/*      */         }
/*      */ 
/* 1495 */         appntAddressBean.getSchema().setHomeZipCode(insurAddressBean.getSchema().getHomeZipCode());
/*      */ 
/* 1497 */         appntAddressBean.getSchema().setHomeFax(insurAddressBean.getSchema().getHomeFax());
/* 1498 */         appntAddressBean.getSchema().setBP(insurAddressBean.getSchema().getBP());
/* 1499 */         appntAddressBean.getSchema().setHomePhone(insurAddressBean.getSchema().getHomePhone());
/* 1500 */         appntAddressBean.getSchema().setHomeAddress(insurAddressBean.getSchema().getHomeAddress());
/* 1501 */         appntAddressBean.getSchema().setEMail(insurAddressBean.getSchema().getEMail());
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1505 */       e.printStackTrace();
/* 1506 */       buildError(e.getMessage());
/*      */     }
/*      */   }
/*      */ 
/*      */   private void copyAppntMsgToInsurMsg()
/*      */   {
/* 1513 */     this.InsurName = this.AppntName;
/* 1514 */     this.InsurSex = this.AppntSex;
/* 1515 */     this.InsurBirthDay = this.AppntBirthDay;
/* 1516 */     this.InsurAge = this.AppntAge;
/* 1517 */     this.InsurIDType = this.AppntIDType;
/* 1518 */     this.InsurID = this.AppntID;
/* 1519 */     this.InsurIDVailityType = this.AppntIDVailityType;
/* 1520 */     this.InsurIDVaility = this.AppntIDVaility;
/* 1521 */     this.InsurNative = this.AppntNative;
/* 1522 */     this.InsurIDView = this.AppntIDView;
/* 1523 */     this.InsurGrpName = this.AppntGrpName;
/* 1524 */     this.IOccupationCode = this.AOccupationCode;
/* 1525 */     this.IOccupationName = this.AOccupationName;
/*      */ 
/* 1527 */     this.InsurCompanyPhone = this.AppntCompanyPhone;
/* 1528 */     this.InsurCompanyZipCode = this.AppntCompanyZipCode;
/* 1529 */     this.InsurIPhone = this.AppntIPhone;
/* 1530 */     this.InsurCompanyMail = this.AppntCompanyMail;
/* 1531 */     this.InsurSalary = this.AppntSalary;
/* 1532 */     this.InsurLinkAdr = this.AppntLinkAdr;
/* 1533 */     this.InsurHomeZipCode = this.AppntHomeZipCode;
/*      */ 
/* 1536 */     this.insuAreaCode = this.appntAreaCode;
/* 1537 */     this.insurCompanyProvince = this.appntCompanyProvince;
/* 1538 */     this.insurCompanyCity = this.appntCompanyCity;
/* 1539 */     this.insurCompanyCounty = this.appntCompanyCounty;
/* 1540 */     this.insurCompanyRoad = this.appntCompanyRoad;
/* 1541 */     this.insurCompanyVillage = this.appntCompanyVillage;
/* 1542 */     this.insurHomeProvince = this.appntHomeProvince;
/* 1543 */     this.insurHomeCity = this.appntHomeCity;
/* 1544 */     this.insurHomeCounty = this.appntHomeCounty;
/* 1545 */     this.insurHomeRoad = this.appntHomeRoad;
/* 1546 */     this.insurHomeVillage = this.appntHomeVillage;
/*      */   }
/*      */ 
/*      */   public void addOneBnf()
/*      */   {
/* 1552 */     this.operateResult = true;
/* 1553 */     if (this.bnfList.size() < this.BnfMaxSize) {
/* 1554 */       BankLNPBnfBean bnfBean = new BankLNPBnfBean();
/* 1555 */       bnfBean.getSchema().setBnfOrder(this.bnfList.size());
/*      */ 
/* 1557 */       this.bnfList.add(bnfBean);
/* 1558 */       this.BnfSize = this.bnfList.size();
/*      */     } else {
/* 1560 */       buildError("\u53D7\u76CA\u4EBA\u4EBA\u6570\u5DF2\u8FBE\u4E0A\u9650\uFF0C\u4E0D\u80FD\u518D\u8FDB\u884C\u6DFB\u52A0\u64CD\u4F5C");
/*      */     }
/* 1562 */     System.out.println(this.bnfList.size() + "--------addOneBnf------");
/*      */   }
/*      */ 
/*      */   public void delBnfById()
/*      */   {
/* 1570 */     this.operateResult = true;
/*      */ 
/* 1572 */     if (this.bnfList.size() > 0) {
/* 1573 */       BankLNPBnfBean bnfBean = (BankLNPBnfBean)this.bnfList.remove(getBnfIdx(this.bnfList));
/* 1574 */       if ((bnfBean != null) && (bnfBean.isValidate()) && (bnfBean.getSchema().getBnfId() != null) && 
/* 1575 */         (!"".equals(bnfBean.getSchema().getBnfId()))) {
/* 1576 */         this.delBnfList.add(bnfBean);
/*      */       }
/* 1578 */       this.BnfSize = this.bnfList.size();
/*      */     } else {
/* 1580 */       buildError("\u53D7\u76CA\u4EBA\u521D\u59CB\u4EBA\u6570\u5DF2\u8FBE\u4E0B\u9650\uFF0C\u4E0D\u80FD\u518D\u8FDB\u884C\u5220\u9664\u64CD\u4F5C");
/*      */     }
/* 1582 */     System.out.println(this.bnfList.size() + "--------delOneBnf------" + this.delBnfList.size());
/*      */   }
/*      */ 
/*      */   private int getBnfIdx(List<BankLNPBnfBean> bnfList)
/*      */   {
/* 1587 */     int idx = 0;
/*      */     try {
/* 1589 */       if ((bnfList != null) && (bnfList.size() > 0))
/* 1590 */         if (!"".equals(this.curBnfId)) {
/* 1591 */           idx = bnfList.size() - 1;
/* 1592 */           for (int i = 0; i < bnfList.size(); i++) {
/* 1593 */             idx = i;
/* 1594 */             BankLNPBnfBean tBnfBean = (BankLNPBnfBean)bnfList.get(i);
/* 1595 */             if (turnNullToString(tBnfBean.getSchema().getBnfId()).equals(this.curBnfId))
/*      */               break;
/*      */           }
/*      */         }
/*      */         else {
/* 1600 */           idx = this.curIdx;
/*      */         }
/*      */     }
/*      */     catch (Exception localException) {
/*      */     }
/* 1605 */     System.out.println("--input bnfid:" + this.curBnfId + "idx:" + this.curIdx + "----- current idx:" + idx + 
/* 1606 */       " bnf will be delete------------------");
/* 1607 */     return idx;
/*      */   }
/*      */ 
/*      */   private String getCurBenefitOrder(List<BankLNPBnfBean> bnfList, int curOrder)
/*      */   {
/* 1629 */     String idx = "1";
/*      */ 
/* 1631 */     if ((bnfList != null) && (bnfList.size() > 0)) {
/* 1632 */       double rateSum = 0.0D;
/* 1633 */       for (int i = 0; i < curOrder; i++) {
/* 1634 */         BankLNPBnfBean bnfBean = (BankLNPBnfBean)bnfList.get(i);
/* 1635 */         if (i > 0) {
/* 1636 */           if ((bnfBean.getSchema().getBenefitOrder().equals(((BankLNPBnfBean)bnfList.get(i - 1)).getSchema().getBenefitOrder())) || 
/* 1637 */             (bnfBean.getSchema().getBenefitOrder() == null)) {
/* 1638 */             rateSum += bnfBean.getSchema().getBenefitRate();
/*      */           } else {
/* 1640 */             rateSum = 0.0D;
/* 1641 */             rateSum += bnfBean.getSchema().getBenefitRate();
/*      */           }
/*      */         }
/* 1644 */         else rateSum += bnfBean.getSchema().getBenefitRate();
/*      */       }
/*      */ 
/* 1647 */       int tIdx = Integer.parseInt(((BankLNPBnfBean)bnfList.get(curOrder - 1)).getSchema().getBenefitOrder());
/* 1648 */       if (rateSum < 100.0D)
/* 1649 */         idx = tIdx;
/*      */       else {
/* 1651 */         idx = tIdx + 1;
/*      */       }
/*      */     }
/*      */ 
/* 1655 */     for (int i = curOrder; i < bnfList.size(); i++) {
/* 1656 */       ((BankLNPBnfBean)bnfList.get(i)).getSchema().setBenefitOrder(idx);
/*      */     }
/* 1658 */     return idx;
/*      */   }
/*      */ 
/*      */   private boolean bnfExists(String contNo, String bnfId, ExeSQL execSql) {
/* 1662 */     boolean flag = false;
/* 1663 */     SSRS ssrs = execSql.execSQL(
/* 1664 */       "select 1 from lnpbnf where contno=rtrim('" + contNo + "') and bnfId = rtrim('" + bnfId + "'); ");
/* 1665 */     if ((ssrs != null) && (ssrs.getMaxRow() > 0))
/* 1666 */       flag = true;
/* 1667 */     return flag;
/*      */   }
/*      */ 
/*      */   private boolean validate(String valiType, BankLNPContBean contBean, BankLNPAppntBean appntBean, BankLNPInusredBean insuredBean, List<BankLNPBnfBean> bnfList, BankLNPPersonBean personBean, BankLNPAddressBean addressBean)
/*      */   {
/* 1673 */     boolean flag = true;
/* 1674 */     if ("appnt".equals(valiType)) {
/* 1675 */       this.appntCompelte = true;
/*      */ 
/* 1677 */       if ((this.AIRealation == null) || ("".equals(this.AIRealation.trim())))
/*      */       {
/* 1679 */         this.appntCompelte = false;
/*      */       }
/*      */ 
/* 1683 */       if ((this.AppntName == null) || ("".equals(this.AppntName.trim()))) {
/* 1684 */         this.appntCompelte = false;
/*      */       }
/* 1686 */       if ((this.AppntSex == null) || ("".equals(this.AppntSex.trim()))) {
/* 1687 */         this.appntCompelte = false;
/*      */       }
/* 1689 */       if ((this.AppntBirthDay == null) || ("".equals(this.AppntBirthDay.trim()))) {
/* 1690 */         this.appntCompelte = false;
/*      */       }
/* 1692 */       if ((this.AppntAge == null) || ("".equals(this.AppntAge.trim()))) {
/* 1693 */         this.appntCompelte = false;
/*      */       }
/* 1695 */       if ((this.AppntIDType == null) || ("".equals(this.AppntIDType.trim()))) {
/* 1696 */         this.appntCompelte = false;
/*      */       }
/* 1698 */       if ((this.AppntID == null) || ("".equals(this.AppntID.trim()))) {
/* 1699 */         this.appntCompelte = false;
/*      */       }
/*      */ 
/* 1710 */       if ((this.AppntNative == null) || ("".equals(this.AppntNative.trim()))) {
/* 1711 */         this.appntCompelte = false;
/*      */       }
/* 1713 */       if ((this.AppntIDView == null) || ("".equals(this.AppntIDView.trim()))) {
/* 1714 */         this.appntCompelte = false;
/*      */       }
/* 1716 */       if ((this.AppntGrpName == null) || ("".equals(this.AppntGrpName.trim()))) {
/* 1717 */         this.appntCompelte = false;
/*      */       }
/* 1719 */       if ((this.AOccupationCode == null) || ("".equals(this.AOccupationCode.trim()))) {
/* 1720 */         this.appntCompelte = false;
/*      */       }
/*      */ 
/* 1726 */       if ((this.AppntCompanyZipCode == null) || ("".equals(this.AppntCompanyZipCode.trim()))) {
/* 1727 */         this.appntCompelte = false;
/*      */       }
/*      */ 
/* 1730 */       if (((this.appntAreaCode != null) && (!"".equals(this.appntAreaCode)) && (!"-1".equals(this.appntAreaCode)) && (
/* 1731 */         (this.AppntCompanyPhone == null) || ("".equals(this.AppntCompanyPhone.trim())))) || (
/* 1732 */         ((this.appntAreaCode == null) || ("".equals(this.appntAreaCode)) || ("-1".equals(this.appntAreaCode))) && 
/* 1733 */         (this.AppntCompanyPhone != null) && (!"".equals(this.AppntCompanyPhone.trim())))) {
/* 1734 */         this.appntCompelte = false;
/*      */       }
/* 1736 */       if ((this.AppntIPhone == null) || ("".equals(this.AppntIPhone.trim()))) {
/* 1737 */         this.appntCompelte = false;
/*      */       }
/* 1739 */       if ((this.AppntCompanyMail == null) || ("".equals(this.AppntCompanyMail.trim()))) {
/* 1740 */         this.appntCompelte = false;
/*      */       }
/* 1742 */       if ((this.AppntSalary == null) || ("".equals(this.AppntSalary.trim())) || 
/* 1743 */         (Double.parseDouble(this.AppntSalary) < 0.0D)) {
/* 1744 */         this.appntCompelte = false;
/*      */       }
/* 1746 */       if ((this.AppntLinkAdr == null) || ("".equals(this.AppntLinkAdr.trim()))) {
/* 1747 */         this.appntCompelte = false;
/*      */       }
/*      */ 
/* 1750 */       if ((this.appntCompanyProvince == null) || ("".equals(this.appntCompanyProvince.trim())) || 
/* 1751 */         ("-1".equals(this.appntCompanyProvince.trim()))) {
/* 1752 */         this.appntCompelte = false;
/*      */       }
/* 1754 */       if ((this.appntCompanyCity == null) || ("".equals(this.appntCompanyCity.trim())) || 
/* 1755 */         ("-1".equals(this.appntCompanyCity.trim()))) {
/* 1756 */         this.appntCompelte = false;
/*      */       }
/* 1758 */       if ((this.appntCompanyCounty == null) || ("".equals(this.appntCompanyCounty.trim())) || 
/* 1759 */         ("-1".equals(this.appntCompanyCounty.trim()))) {
/* 1760 */         this.appntCompelte = false;
/*      */       }
/* 1762 */       if ((this.appntCompanyRoad == null) || ("".equals(this.appntCompanyRoad.trim()))) {
/* 1763 */         this.appntCompelte = false;
/*      */       }
/* 1765 */       if ((this.appntCompanyVillage == null) || ("".equals(this.appntCompanyVillage.trim()))) {
/* 1766 */         this.appntCompelte = false;
/*      */       }
/*      */ 
/* 1769 */       if ("2".equals(this.AppntLinkAdr)) {
/* 1770 */         if ((this.AppntHomeZipCode == null) || ("".equals(this.AppntHomeZipCode.trim()))) {
/* 1771 */           this.appntCompelte = false;
/*      */         }
/*      */ 
/* 1774 */         if ((this.appntHomeProvince == null) || ("".equals(this.appntHomeProvince.trim())) || 
/* 1775 */           ("-1".equals(this.appntHomeProvince.trim()))) {
/* 1776 */           this.appntCompelte = false;
/*      */         }
/* 1778 */         if ((this.appntHomeCity == null) || ("".equals(this.appntHomeCity.trim())) || 
/* 1779 */           ("-1".equals(this.appntHomeCity.trim()))) {
/* 1780 */           this.appntCompelte = false;
/*      */         }
/* 1782 */         if ((this.appntHomeCounty == null) || ("".equals(this.appntHomeCounty.trim())) || 
/* 1783 */           ("-1".equals(this.appntHomeCounty.trim()))) {
/* 1784 */           this.appntCompelte = false;
/*      */         }
/* 1786 */         if ((this.appntHomeRoad == null) || ("".equals(this.appntHomeRoad.trim()))) {
/* 1787 */           this.appntCompelte = false;
/*      */         }
/* 1789 */         if ((this.appntHomeVillage == null) || ("".equals(this.appntHomeVillage.trim()))) {
/* 1790 */           this.appntCompelte = false;
/*      */         }
/*      */       }
/*      */     }
/* 1794 */     else if ("insured".equals(valiType)) {
/* 1795 */       this.insurCompelte = true;
/*      */ 
/* 1797 */       if ((this.InsurName == null) || ("".equals(this.InsurName.trim()))) {
/* 1798 */         this.appntCompelte = false;
/*      */       }
/* 1800 */       if ((this.InsurSex == null) || ("".equals(this.InsurSex.trim()))) {
/* 1801 */         this.insurCompelte = false;
/*      */       }
/* 1803 */       if ((this.InsurBirthDay == null) || ("".equals(this.InsurBirthDay.trim()))) {
/* 1804 */         this.insurCompelte = false;
/*      */       }
/* 1806 */       if ((this.InsurAge == null) || ("".equals(this.InsurAge.trim()))) {
/* 1807 */         this.insurCompelte = false;
/*      */       }
/* 1809 */       if ((this.InsurIDType == null) || ("".equals(this.InsurIDType.trim()))) {
/* 1810 */         this.insurCompelte = false;
/*      */       }
/* 1812 */       if ((this.InsurID == null) || ("".equals(this.InsurID.trim()))) {
/* 1813 */         this.insurCompelte = false;
/*      */       }
/*      */ 
/* 1816 */       if ((this.InsurNative == null) || ("".equals(this.InsurNative.trim()))) {
/* 1817 */         this.insurCompelte = false;
/*      */       }
/* 1819 */       if ((this.InsurIDView == null) || ("".equals(this.InsurIDView.trim()))) {
/* 1820 */         this.insurCompelte = false;
/*      */       }
/* 1822 */       if ((this.InsurGrpName == null) || ("".equals(this.InsurGrpName.trim()))) {
/* 1823 */         this.insurCompelte = false;
/*      */       }
/* 1825 */       if ((this.IOccupationCode == null) || ("".equals(this.IOccupationCode.trim()))) {
/* 1826 */         this.insurCompelte = false;
/*      */       }
/*      */ 
/* 1829 */       if ((this.InsurCompanyZipCode == null) || ("".equals(this.InsurCompanyZipCode.trim()))) {
/* 1830 */         this.insurCompelte = false;
/*      */       }
/*      */ 
/* 1833 */       if (((this.insuAreaCode != null) && (!"".equals(this.insuAreaCode)) && (!"-1".equals(this.insuAreaCode)) && (
/* 1834 */         (this.InsurCompanyPhone == null) || ("".equals(this.InsurCompanyPhone.trim())))) || (
/* 1835 */         ((this.insuAreaCode == null) || ("".equals(this.insuAreaCode)) || ("-1".equals(this.insuAreaCode))) && 
/* 1836 */         (this.InsurCompanyPhone != null) && (!"".equals(this.InsurCompanyPhone.trim())))) {
/* 1837 */         this.insurCompelte = false;
/*      */       }
/*      */ 
/* 1844 */       if ((this.InsurCompanyMail == null) || ("".equals(this.InsurCompanyMail.trim()))) {
/* 1845 */         this.insurCompelte = false;
/*      */       }
/* 1847 */       if ((this.InsurSalary == null) || ("".equals(this.InsurSalary.trim())) || 
/* 1848 */         (Double.parseDouble(this.InsurSalary) < 0.0D)) {
/* 1849 */         this.insurCompelte = false;
/*      */       }
/* 1851 */       if ((this.InsurLinkAdr == null) || ("".equals(this.InsurLinkAdr.trim()))) {
/* 1852 */         this.insurCompelte = false;
/*      */       }
/*      */ 
/* 1855 */       if ((this.insurCompanyProvince == null) || ("".equals(this.insurCompanyProvince.trim())) || 
/* 1856 */         ("-1".equals(this.insurCompanyProvince.trim()))) {
/* 1857 */         this.insurCompelte = false;
/*      */       }
/* 1859 */       if ((this.insurCompanyCity == null) || ("".equals(this.insurCompanyCity.trim())) || 
/* 1860 */         ("-1".equals(this.insurCompanyCity.trim()))) {
/* 1861 */         this.insurCompelte = false;
/*      */       }
/* 1863 */       if ((this.insurCompanyCounty == null) || ("".equals(this.insurCompanyCounty.trim())) || 
/* 1864 */         ("-1".equals(this.insurCompanyCounty.trim()))) {
/* 1865 */         this.insurCompelte = false;
/*      */       }
/* 1867 */       if ((this.insurCompanyRoad == null) || ("".equals(this.insurCompanyRoad.trim()))) {
/* 1868 */         this.insurCompelte = false;
/*      */       }
/* 1870 */       if ((this.insurCompanyVillage == null) || ("".equals(this.insurCompanyVillage.trim()))) {
/* 1871 */         this.insurCompelte = false;
/*      */       }
/*      */ 
/* 1874 */       if ("2".equals(this.InsurLinkAdr)) {
/* 1875 */         if ((this.InsurHomeZipCode == null) || ("".equals(this.InsurHomeZipCode.trim()))) {
/* 1876 */           this.insurCompelte = false;
/*      */         }
/*      */ 
/* 1879 */         if ((this.insurHomeProvince == null) || ("".equals(this.insurHomeProvince.trim())) || 
/* 1880 */           ("-1".equals(this.insurHomeProvince.trim()))) {
/* 1881 */           this.insurCompelte = false;
/*      */         }
/* 1883 */         if ((this.insurHomeCity == null) || ("".equals(this.insurHomeCity.trim())) || 
/* 1884 */           ("-1".equals(this.insurHomeCity.trim()))) {
/* 1885 */           this.insurCompelte = false;
/*      */         }
/* 1887 */         if ((this.insurHomeCounty == null) || ("".equals(this.insurHomeCounty.trim())) || 
/* 1888 */           ("-1".equals(this.insurHomeCounty.trim()))) {
/* 1889 */           this.insurCompelte = false;
/*      */         }
/* 1891 */         if ((this.insurHomeRoad == null) || ("".equals(this.insurHomeRoad.trim()))) {
/* 1892 */           this.insurCompelte = false;
/*      */         }
/* 1894 */         if ((this.insurHomeVillage == null) || ("".equals(this.insurHomeVillage.trim())))
/* 1895 */           this.insurCompelte = false;
/*      */       }
/*      */     }
/* 1898 */     else if ("bnf".equals(valiType)) {
/* 1899 */       System.out.println("1".equals(this.BnfIsExist));
/* 1900 */       this.bnfCompelte = true;
/* 1901 */       if ("1".equals(this.BnfIsExist)) {
/* 1902 */         if ((bnfList != null) && (bnfList.size() > 0)) {
/* 1903 */           for (int i = 0; i < bnfList.size(); i++) {
/* 1904 */             BankLNPBnfBean bnfBean = (BankLNPBnfBean)bnfList.get(i);
/* 1905 */             LNPBnfSchema bnfSchema = bnfBean.getSchema();
/* 1906 */             if ((bnfBean.isValidate()) && (!"delete".equals(bnfSchema.getHealth()))) {
/* 1907 */               if ((bnfSchema.getBnfName() == null) || ("".equals(bnfSchema.getBnfName().trim()))) {
/* 1908 */                 this.bnfCompelte = false;
/*      */               }
/* 1910 */               if ((bnfSchema.getRelationToInsured() == null) || 
/* 1911 */                 ("".equals(bnfSchema.getRelationToInsured().trim()))) {
/* 1912 */                 this.bnfCompelte = false;
/*      */               }
/* 1914 */               if ((bnfSchema.getBenefitOrder() == null) || ("".equals(bnfSchema.getBenefitOrder().trim()))) {
/* 1915 */                 this.bnfCompelte = false;
/*      */               }
/* 1917 */               if (bnfSchema.getBenefitRate() == 0.0D) {
/* 1918 */                 this.bnfCompelte = false;
/* 1919 */                 System.out.println("\u7B2C" + bnfSchema.getBenefitOrder() + "\u53D7\u76CA\u4EBA:" + bnfSchema.getBnfName() + 
/* 1920 */                   ",\u53D7\u76CA\u6BD4\u4F8B\u9700\u8981\u5927\u4E8E0");
/*      */               }
/*      */ 
/* 1924 */               if ((!"1".equals(bnfSchema.getIDPerpetual())) || 
/* 1925 */                 (bnfSchema.getIDValidity() == null) || 
/* 1926 */                 (!"".equals(bnfSchema.getIDValidity().trim()))) continue;
/* 1927 */               System.out.println("\u7B2C" + bnfSchema.getBenefitOrder() + "\u53D7\u76CA\u4EBA:" + 
/* 1928 */                 bnfSchema.getBnfName() + ",\u8BC1\u4EF6\u4E3A\u975E\u7EC8\u751F\u6709\u6548,\u8BC1\u4EF6\u6709\u6548\u671F\u5E94\u4E0D\u4E3A\u7A7A");
/*      */             }
/*      */           }
/*      */ 
/*      */         }
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/* 1937 */         this.bnfCompelte = true;
/*      */       }
/*      */     }
/* 1940 */     return flag;
/*      */   }
/*      */ 
/*      */   private void initCRSInfoMsg(CRSInfoBean crsBean, BankLNPAddressBean addressBean)
/*      */   {
/*      */     try
/*      */     {
/* 1947 */       CRSInfoSchema crsSchema = crsBean.getSchema();
/* 1948 */       this.contNo = crsSchema.getContNo();
/* 1949 */       System.out.println("\u4ECESchema\u4E2D\u83B7\u53D6\u4FE1\u606F" + crsSchema);
/* 1950 */       this.birthAddress_City = getAddressCode(crsSchema.getBirthAddress_City(), 4);
/* 1951 */       this.birthAddress_City_en = getAddressCode(crsSchema.getBirthAddress_City_en(), 4);
/* 1952 */       this.birthAddress_Country = getCode(crsSchema.getBirthAddress_Country(), "");
/* 1953 */       this.birthAddress_Detail = crsSchema.getBirthAddress_Detail();
/* 1954 */       this.birthAddress_Detail_en = crsSchema.getBirthAddress_Detail_en();
/* 1955 */       this.birthAddress_Province = getAddressCode(crsSchema.getBirthAddress_Province(), 2);
/* 1956 */       this.birthAddress_Province_en = getAddressCode(crsSchema.getBirthAddress_Province_en(), 2);
/* 1957 */       this.birthday = crsSchema.getBirthday();
/* 1958 */       this.currentAddress_City = getAddressCode(addressBean.getSchema().getBP(), 4);
/* 1959 */       this.currentAddress_City_en = getAddressCode(crsSchema.getCurrentAddress_City_en(), 4);
/* 1960 */       this.currentAddress_Country = getCode(crsSchema.getCurrentAddress_Country(), "");
/* 1961 */       this.currentAddress_Detail = crsSchema.getCurrentAddress_Detail();
/* 1962 */       this.currentAddress_Detail_en = crsSchema.getCurrentAddress_Detail_en();
/* 1963 */       this.currentAddress_Province = getAddressCode(addressBean.getSchema().getHomeFax(), 2);
/* 1964 */       this.currentAddress_Province_en = getAddressCode(crsSchema.getCurrentAddress_Province_en(), 2);
/* 1965 */       this.customerName = crsSchema.getCustomerName();
/* 1966 */       this.firstName = crsSchema.getFirstName();
/* 1967 */       this.lastName = crsSchema.getLastName();
/* 1968 */       this.noTaxpayercodeReason = crsSchema.getNoTaxpayercodeReason();
/* 1969 */       this.taxpayerCode1 = crsSchema.getTaxpayerCode1();
/* 1970 */       this.taxpayerCode2 = crsSchema.getTaxpayerCode2();
/* 1971 */       this.taxpayerCode3 = crsSchema.getTaxpayerCode3();
/* 1972 */       this.taxResidentCountry1 = crsSchema.getTaxResidentCountry1();
/* 1973 */       this.taxResidentCountry2 = crsSchema.getTaxResidentCountry2();
/* 1974 */       this.taxResidentCountry3 = crsSchema.getTaxResidentCountry3();
/* 1975 */       this.taxResidentType = crsSchema.getTaxResidentType();
/* 1976 */       this.currentAddress_Country_en = getCode(crsSchema.getCurrentAddress_Country_en(), "e");
/* 1977 */       this.birthAddress_Country_en = getCode(crsSchema.getBirthAddress_Country_en(), "e");
/* 1978 */       this.reasonDescription = crsSchema.getReasonDescription();
/*      */     } catch (Exception e) {
/* 1980 */       buildError(e.getMessage());
/*      */     }
/*      */   }
/*      */ 
/*      */   private void initAppntMsg(BankLNPAppntBean appntBean, BankLNPPersonBean personBean, BankLNPAddressBean addressBean)
/*      */   {
/*      */     try
/*      */     {
/* 1990 */       LNPAppntSchema appntSchema = appntBean.getSchema();
/* 1991 */       LNPPersonSchema personSchema = personBean.getSchema();
/* 1992 */       LNPAddressSchema addrSchema = addressBean.getSchema();
/* 1993 */       this.AIRealation = appntSchema.getRelationToInsured();
/* 1994 */       this.AppntVIP = appntSchema.getAppntGrade();
/* 1995 */       this.AppntName = appntSchema.getAppntName();
/* 1996 */       this.AppntSex = appntSchema.getAppntSex();
/* 1997 */       this.AppntBirthDay = appntSchema.getAppntBirthday();
/* 1998 */       if ((appntSchema.getAppntBirthday() != null) && (!appntSchema.getAppntBirthday().equals("")))
/* 1999 */         this.AppntAge = LNPPubFun.getAgeByBirthdayNew(appntSchema.getAppntBirthday(), 
/* 2000 */           this.contBean.getSchema().getPValiDate());
/*      */       else {
/* 2002 */         this.AppntAge = "";
/*      */       }
/*      */ 
/* 2005 */       this.AppntIDType = appntSchema.getIDType();
/* 2006 */       this.AppntID = appntSchema.getIDNo();
/* 2007 */       this.AppntIDVailityType = appntSchema.getIDPerpetual();
/* 2008 */       this.AppntIDVaility = appntSchema.getIDValidity();
/* 2009 */       this.AppntNative = appntSchema.getNativePlace();
/* 2010 */       this.AppntIDView = appntSchema.getHealth();
/* 2011 */       this.AppntGrpName = addrSchema.getGrpName();
/* 2012 */       this.AOccupationCode = appntSchema.getOccupationCode();
/* 2013 */       this.AOccupationName = ((String)occNameMap.get(appntSchema.getOccupationCode()));
/*      */ 
/* 2015 */       this.AppntCompanyPhone = addrSchema.getCompanyPhone();
/* 2016 */       this.AppntCompanyZipCode = addrSchema.getCompanyZipCode();
/* 2017 */       this.AppntIPhone = addrSchema.getPhone();
/* 2018 */       this.AppntCompanyMail = addrSchema.getCompanyMail();
/* 2019 */       System.out.println("---------------------------------------" + appntSchema.getSalary());
/* 2020 */       this.AppntSalary = appntSchema.getSalary().trim();
/* 2021 */       this.AppntLinkAdr = addrSchema.getPostalAddress();
/* 2022 */       this.AppntHomeZipCode = addrSchema.getHomeZipCode();
/*      */ 
/* 2025 */       this.appntCompanyProvince = addrSchema.getCompanyFax();
/* 2026 */       this.appntCompanyCity = addrSchema.getBP2();
/* 2027 */       this.appntCompanyCounty = addrSchema.getMobile2();
/* 2028 */       this.appntCompanyRoad = addrSchema.getCompanyAddress();
/* 2029 */       this.appntCompanyVillage = addrSchema.getEMail2();
/* 2030 */       this.appntAreaCode = addrSchema.getMobileChs2();
/* 2031 */       this.appntHomeProvince = addrSchema.getHomeFax();
/* 2032 */       this.appntHomeCity = addrSchema.getBP();
/* 2033 */       this.appntHomeCounty = addrSchema.getHomePhone();
/* 2034 */       this.appntHomeRoad = addrSchema.getHomeAddress();
/* 2035 */       this.appntHomeVillage = addrSchema.getEMail();
/* 2036 */       System.out.println("&&&&&&&&&&&\u521D\u59CB\u5316\u6295\u4FDD\u4EBA\u4FE1\u606F\u5B8C\u6210\uFF1AappntBean\uFF1A" + this.appntBean.getSchema().getAppntName());
/*      */     } catch (Exception e) {
/* 2038 */       buildError(e.getMessage());
/*      */     }
/*      */   }
/*      */ 
/*      */   private void initInsuredMsg(BankLNPInusredBean insuredBean, BankLNPPersonBean personBean, BankLNPAddressBean addressBean)
/*      */   {
/*      */     try
/*      */     {
/* 2046 */       LNPInsuredSchema inusredSchema = insuredBean.getSchema();
/* 2047 */       LNPPersonSchema personSchema = personBean.getSchema();
/* 2048 */       LNPAddressSchema addrSchema = addressBean.getSchema();
/* 2049 */       this.InsurName = inusredSchema.getName();
/* 2050 */       this.InsurSex = inusredSchema.getSex();
/* 2051 */       this.InsurBirthDay = inusredSchema.getBirthday();
/* 2052 */       if ((inusredSchema.getBirthday() != null) && (!inusredSchema.getBirthday().equals("")))
/* 2053 */         this.InsurAge = LNPPubFun.getAgeByBirthdayNew(inusredSchema.getBirthday(), 
/* 2054 */           this.contBean.getSchema().getPValiDate());
/*      */       else {
/* 2056 */         this.InsurAge = "";
/*      */       }
/*      */ 
/* 2059 */       this.InsurIDType = inusredSchema.getIDType();
/* 2060 */       this.InsurID = inusredSchema.getIDNo();
/* 2061 */       this.InsurIDVailityType = inusredSchema.getIDPerpetual();
/* 2062 */       this.InsurIDVaility = inusredSchema.getIDValidity();
/* 2063 */       this.InsurNative = inusredSchema.getNativePlace();
/* 2064 */       this.InsurIDView = inusredSchema.getHealth();
/* 2065 */       this.InsurGrpName = addrSchema.getGrpName();
/* 2066 */       this.IOccupationCode = inusredSchema.getOccupationCode();
/* 2067 */       this.IOccupationName = ((String)occNameMap.get(inusredSchema.getOccupationCode()));
/*      */ 
/* 2069 */       this.InsurCompanyPhone = addrSchema.getCompanyPhone();
/* 2070 */       this.InsurCompanyZipCode = addrSchema.getCompanyZipCode();
/* 2071 */       this.InsurIPhone = addrSchema.getPhone();
/* 2072 */       this.InsurCompanyMail = addrSchema.getCompanyMail();
/* 2073 */       this.InsurSalary = inusredSchema.getSalary().trim();
/* 2074 */       this.InsurLinkAdr = addrSchema.getPostalAddress();
/* 2075 */       this.InsurHomeZipCode = addrSchema.getHomeZipCode();
/*      */ 
/* 2077 */       this.BnfIsExist = inusredSchema.getInsuredPeoples();
/* 2078 */       this.BnfRecType = inusredSchema.getCreditGrade();
/*      */ 
/* 2080 */       this.insurCompanyProvince = addrSchema.getCompanyFax();
/* 2081 */       this.insurCompanyCity = addrSchema.getBP2();
/* 2082 */       this.insurCompanyCounty = addrSchema.getMobile2();
/* 2083 */       this.insurCompanyRoad = addrSchema.getCompanyAddress();
/* 2084 */       this.insurCompanyVillage = addrSchema.getEMail2();
/* 2085 */       this.insuAreaCode = addrSchema.getMobileChs2();
/* 2086 */       this.insurHomeProvince = addrSchema.getHomeFax();
/* 2087 */       this.insurHomeCity = addrSchema.getBP();
/* 2088 */       this.insurHomeCounty = addrSchema.getHomePhone();
/* 2089 */       this.insurHomeRoad = addrSchema.getHomeAddress();
/* 2090 */       this.insurHomeVillage = addrSchema.getEMail();
/*      */     }
/*      */     catch (Exception e) {
/* 2093 */       buildError(e.getMessage());
/*      */     }
/*      */   }
/*      */ 
/*      */   private BankLNPContBean recOneContInfo(String contNo)
/*      */   {
/* 2099 */     BankLNPContBean bean = new BankLNPContBean();
/* 2100 */     PolicyMainInfo mainInfo = new PolicyMainInfo();
/* 2101 */     LNPContSchema tSchema = mainInfo.getContByContNo(contNo);
/* 2102 */     if (tSchema != null) {
/* 2103 */       bean.setSchema(tSchema);
/*      */     }
/* 2105 */     return bean;
/*      */   }
/*      */ 
/*      */   private BankLNPAppntBean recOneAppntPersonInfo(String contNo, String AppntId) {
/* 2109 */     BankLNPAppntBean bean = new BankLNPAppntBean();
/* 2110 */     LNPAppntDB db = new LNPAppntDB();
/* 2111 */     db.setContNo(contNo);
/* 2112 */     db.setAppntId(AppntId);
/* 2113 */     LNPAppntSet set = db.query();
/* 2114 */     if (set.size() > 0) {
/* 2115 */       bean.setSchema(set.get(1));
/*      */     }
/* 2117 */     System.out.println("&&&&&&&&&\u6295\u4FDD\u5355\u53F7" + contNo + "--appntID" + AppntId + "--bean" + bean.getSchema().getAppntName());
/* 2118 */     return bean;
/*      */   }
/*      */ 
/*      */   private String getAppntIDByContno(String contNo)
/*      */   {
/* 2127 */     BankLNPAppntBean bean = new BankLNPAppntBean();
/* 2128 */     LNPAppntDB db = new LNPAppntDB();
/* 2129 */     db.setContNo(contNo);
/* 2130 */     LNPAppntSet set = db.query();
/* 2131 */     if (set.size() > 0) {
/* 2132 */       bean.setSchema(set.get(1));
/*      */     }
/* 2134 */     return bean.getSchema().getAppntId();
/*      */   }
/*      */ 
/*      */   private CRSInfoBean recOneCRSInfo(String contNo) {
/* 2138 */     CRSInfoBean bean = new CRSInfoBean();
/* 2139 */     CRSInfoDB db = new CRSInfoDB();
/* 2140 */     db.setContNo(contNo);
/* 2141 */     CRSInfoSet set = db.query();
/* 2142 */     System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSS" + contNo + set.size());
/* 2143 */     if (set.size() > 0) {
/* 2144 */       bean.setSchema(set.get(1));
/*      */     }
/* 2146 */     return bean;
/*      */   }
/*      */ 
/*      */   private BankLNPInusredBean recOneInsuredPersonInfo(String contNo, String insuredId) {
/* 2150 */     BankLNPInusredBean bean = new BankLNPInusredBean();
/* 2151 */     LNPInsuredDB db = new LNPInsuredDB();
/* 2152 */     db.setContNo(contNo);
/* 2153 */     db.setInsuredId(insuredId);
/* 2154 */     LNPInsuredSet set = db.query();
/* 2155 */     if (set.size() > 0) {
/* 2156 */       bean.setSchema(set.get(1));
/*      */     }
/* 2158 */     return bean;
/*      */   }
/*      */ 
/*      */   private List<BankLNPBnfBean> recBnfList(String contNo)
/*      */   {
/* 2163 */     List tempList = new ArrayList();
/* 2164 */     String execSQL = "select * from lnpbnf where benefittype='2' and (health is null or health<>'delete') and contno = '" + 
/* 2165 */       contNo + "' order by bnforder";
/* 2166 */     LNPBnfDB db = new LNPBnfDB();
/* 2167 */     LNPBnfSet set = db.executeQuery(execSQL);
/* 2168 */     if ((set != null) && (set.size() > 0)) {
/* 2169 */       for (int i = 1; i <= set.size(); i++) {
/* 2170 */         BankLNPBnfBean bean = new BankLNPBnfBean();
/* 2171 */         bean.setSchema(set.get(i));
/* 2172 */         bean.setGender((String)genderMap.get(set.get(i).getSchema().getBnfSex()));
/* 2173 */         bean.setIdType((String)idTypeMap.get(set.get(i).getSchema().getIDType()));
/* 2174 */         bean.setRelationToInsured((String)relationToInsuredMap.get(set.get(i).getSchema().getRelationToInsured()));
/* 2175 */         tempList.add(bean);
/*      */       }
/*      */     }
/* 2178 */     return tempList;
/*      */   }
/*      */ 
/*      */   private BankLNPPersonBean recOnePersonInfo(String customerId) {
/* 2182 */     BankLNPPersonBean bean = new BankLNPPersonBean();
/* 2183 */     LNPPersonDB db = new LNPPersonDB();
/* 2184 */     db.setCustomerId(customerId);
/* 2185 */     LNPPersonSet set = db.query();
/* 2186 */     if (set.size() > 0) {
/* 2187 */       bean.setSchema(set.get(1));
/*      */     }
/* 2189 */     return bean;
/*      */   }
/*      */ 
/*      */   private BankLNPAddressBean recOneAddressInfo(String customerId) {
/* 2193 */     BankLNPAddressBean bean = new BankLNPAddressBean();
/* 2194 */     LNPAddressDB db = new LNPAddressDB();
/* 2195 */     db.setCustomerId(customerId);
/* 2196 */     LNPAddressSet set = db.query();
/* 2197 */     if (set.size() > 0) {
/* 2198 */       bean.setSchema(set.get(1));
/*      */     }
/* 2200 */     return bean;
/*      */   }
/*      */ 
/*      */   private boolean getInfoFromSession()
/*      */   {
/* 2212 */     boolean flag = false;
/* 2213 */     HttpSession session = null;
/*      */     try {
/* 2215 */       session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*      */ 
/* 2217 */       this.GI = ((IGlobalInput)session.getAttribute("NPGI"));
/*      */ 
/* 2221 */       if (((String)session.getAttribute("ContNo") != null) && 
/* 2222 */         (!((String)session.getAttribute("ContNo")).equals(""))) {
/* 2223 */         this.ContNo = ((String)session.getAttribute("ContNo"));
/*      */ 
/* 2225 */         waitPolicyCommited(session, this.ContNo);
/* 2226 */         turnCurrPolicyLockFlag(session, this.ContNo, "lock");
/* 2227 */         flag = true;
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 2231 */       turnCurrPolicyLockFlag(session, this.ContNo, "unlock");
/* 2232 */       flag = false;
/* 2233 */       buildError(e.getMessage());
/*      */     }
/* 2235 */     return flag;
/*      */   }
/*      */ 
/*      */   private void buildError(String msgErr)
/*      */   {
/* 2240 */     System.out.println("buildError:---------------" + msgErr);
/* 2241 */     this.message = msgErr;
/* 2242 */     this.operateResult = false;
/* 2243 */     System.out.println("buildError:--after-------------" + this.message);
/*      */   }
/*      */ 
/*      */   public void cancleOccupSession()
/*      */   {
/* 2250 */     System.out.println("----- -----" + this.OccType);
/* 2251 */     HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/* 2252 */     String occupationName = (String)session.getAttribute("occupationName");
/* 2253 */     String occupationCode = (String)session.getAttribute("occupationCode");
/* 2254 */     System.out.println("session inner-----" + occupationCode + ":" + occupationName);
/*      */ 
/* 2256 */     if ((occupationName != null) && (!occupationName.equals(""))) {
/* 2257 */       if ("appnt".equals(this.OccType))
/* 2258 */         this.AOccupationName = occupationName;
/*      */       else {
/* 2260 */         this.IOccupationName = occupationName;
/*      */       }
/*      */     }
/* 2263 */     else if ("appnt".equals(this.OccType))
/* 2264 */       this.AOccupationName = "";
/*      */     else {
/* 2266 */       this.IOccupationName = "";
/*      */     }
/*      */ 
/* 2269 */     if ((occupationCode != null) && (!occupationCode.equals(""))) {
/* 2270 */       if ("appnt".equals(this.OccType))
/* 2271 */         this.AOccupationCode = occupationCode;
/*      */       else {
/* 2273 */         this.IOccupationCode = occupationCode;
/*      */       }
/*      */     }
/* 2276 */     else if ("appnt".equals(this.OccType))
/* 2277 */       this.AOccupationCode = "";
/*      */     else {
/* 2279 */       this.IOccupationCode = "";
/*      */     }
/*      */ 
/* 2283 */     session.removeAttribute("occupationName");
/* 2284 */     session.removeAttribute("occupationCode");
/*      */   }
/*      */ 
/*      */   public void getOccNameByCode()
/*      */   {
/*      */     try
/*      */     {
/* 2291 */       String occName = (String)occNameMap.get(this.OccCode);
/* 2292 */       if ((occName != null) && (!"".equals(occName))) {
/* 2293 */         if ("appnt".equals(this.OccType)) {
/* 2294 */           this.AOccupationCode = this.OccCode;
/* 2295 */           this.AOccupationName = occName;
/*      */         } else {
/* 2297 */           this.IOccupationCode = this.OccCode;
/* 2298 */           this.IOccupationName = occName;
/*      */         }
/*      */ 
/*      */       }
/* 2302 */       else if ("appnt".equals(this.OccType)) {
/* 2303 */         this.AOccupationCode = "";
/* 2304 */         this.AOccupationName = "";
/*      */       } else {
/* 2306 */         this.IOccupationCode = "";
/* 2307 */         this.IOccupationName = "";
/*      */       }
/*      */ 
/* 2310 */       System.out.println("in-->" + this.OccCode + "|IOccupationCode:" + this.IOccupationCode + "|IOccupationName:" + 
/* 2311 */         this.IOccupationName + "|AOccupationCode:" + this.AOccupationCode + "|AOccupationName:" + this.AOccupationName);
/*      */     } catch (RuntimeException e) {
/* 2313 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   public void recAgeByBirthDay()
/*      */   {
/* 2322 */     this.CAge = "-1";
/*      */     try {
/* 2324 */       System.out.println(this.CBirth + "------------" + this.contBean.getSchema().getPValiDate());
/* 2325 */       String regex = "^(?:(?:(?:(?:(?:1[6-9]|[2-9]\\d)(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))0229)|(?:(?:(?:1[6-9]|[2-9]\\d)\\d{2})(?:(?:(?:0[13578]|1[02])31)|(?:(?:0[13-9]|1[0-2])(?:29|30))|(?:0[1-9]|1[0-2])(?:0[1-9]|1\\d|2[0-8]))))$";
/* 2326 */       if (Pattern.matches(regex, this.CBirth)) {
/* 2327 */         this.CAge = getAgeByBirthdayNew(this.CBirth, this.contBean.getSchema().getPValiDate());
/* 2328 */         if ("appnt".equals(this.CType))
/* 2329 */           this.AppntAge = this.CAge;
/*      */         else
/* 2331 */           this.InsurAge = this.CAge;
/*      */       }
/*      */       else {
/* 2334 */         this.CAge = "";
/*      */       }
/* 2336 */       System.out.println(this.CType + "-----------recAgeByBirthDay-------------" + this.CAge);
/*      */     } catch (Exception e) {
/* 2338 */       e.printStackTrace();
/* 2339 */       buildError(e.getMessage());
/*      */     }
/*      */   }
/*      */ 
/*      */   private String getAgeByBirthdayNew(String birth, String applyDate) {
/* 2344 */     String age = "-1";
/* 2345 */     String tBirth = birth.replaceAll("-", "");
/* 2346 */     String tApplyDate = applyDate.replaceAll("-", "");
/* 2347 */     if (Integer.parseInt(tBirth.trim()) > Integer.parseInt(tApplyDate.trim())) {
/* 2348 */       return age;
/*      */     }
/* 2350 */     String[] args = LNPPubFun.getAppAge(tBirth, tApplyDate);
/* 2351 */     if (args[0].equals("Y"))
/* 2352 */       age = args[1] + "\uFF08\u5468\u5C81\uFF09";
/*      */     else {
/* 2354 */       age = args[1] + "\uFF08\u5929\uFF09";
/*      */     }
/* 2356 */     return age;
/*      */   }
/*      */ 
/*      */   private String formatDate(String srcDate, String formate)
/*      */   {
/* 2361 */     String tDate = srcDate;
/* 2362 */     if ((srcDate != null) && (!"".equals(srcDate.trim()))) {
/* 2363 */       if (formate.indexOf("-") > 0)
/* 2364 */         tDate = srcDate.substring(0, 4) + "-" + srcDate.substring(4, 6) + "-" + srcDate.substring(6, 8);
/*      */       else {
/* 2366 */         tDate = srcDate.replaceAll("-", "");
/*      */       }
/*      */     }
/* 2369 */     return tDate;
/*      */   }
/*      */ 
/*      */   private static void initGenderMap()
/*      */   {
/* 2380 */     genderMap.clear();
/* 2381 */     ExeSQL tExeSQL = new ExeSQL();
/* 2382 */     String sql = "select code,codename from lnpcode where codetype='sex' order by code";
/* 2383 */     SSRS tSRS = tExeSQL.execSQL(sql);
/* 2384 */     for (int i = 1; i <= tSRS.MaxRow; i++)
/* 2385 */       genderMap.put(tSRS.GetText(i, 1), tSRS.GetText(i, 2));
/*      */   }
/*      */ 
/*      */   private static void initIdTypeMap()
/*      */   {
/* 2390 */     idTypeMap.clear();
/* 2391 */     ExeSQL tExeSQL = new ExeSQL();
/* 2392 */     String sql = "select code,codename from lnpcode where codetype='insuredidtype' order by code";
/* 2393 */     SSRS tSRS = tExeSQL.execSQL(sql);
/* 2394 */     for (int i = 1; i <= tSRS.MaxRow; i++)
/* 2395 */       idTypeMap.put(tSRS.GetText(i, 1), tSRS.GetText(i, 2));
/*      */   }
/*      */ 
/*      */   private static void initRelationToInsuredMap()
/*      */   {
/* 2400 */     relationToInsuredMap.clear();
/* 2401 */     ExeSQL tExeSQL = new ExeSQL();
/* 2402 */     String sql = "select code,codename from lnpcode where codetype='bnfrelationtoinsured' order by code";
/* 2403 */     SSRS tSRS = tExeSQL.execSQL(sql);
/* 2404 */     for (int i = 1; i <= tSRS.MaxRow; i++)
/* 2405 */       relationToInsuredMap.put(tSRS.GetText(i, 1), tSRS.GetText(i, 2));
/*      */   }
/*      */ 
/*      */   private static void initOccNameMap()
/*      */   {
/* 2410 */     occNameMap.clear();
/* 2411 */     ExeSQL tExeSQL = new ExeSQL();
/*      */ 
/* 2417 */     String sql = "select occupationcode,occupationname from lnpoccupation a where exists(select b.occupationcode from lnpoccupation b where b.relacode is not null and a.RELACODE=b.RELACODE)";
/* 2418 */     SSRS tSRS = tExeSQL.execSQL(sql);
/* 2419 */     for (int i = 1; i <= tSRS.MaxRow; i++)
/* 2420 */       occNameMap.put(tSRS.GetText(i, 1), tSRS.GetText(i, 2));
/*      */   }
/*      */ 
/*      */   public boolean isEditFlag()
/*      */   {
/* 2425 */     return this.editFlag;
/*      */   }
/*      */ 
/*      */   public void setEditFlag(boolean editFlag) {
/* 2429 */     this.editFlag = editFlag;
/*      */   }
/*      */ 
/*      */   public BankLNPContBean getContBean() {
/* 2433 */     return this.contBean;
/*      */   }
/*      */ 
/*      */   public void setContBean(BankLNPContBean contBean) {
/* 2437 */     this.contBean = contBean;
/*      */   }
/*      */ 
/*      */   public BankLNPAppntBean getAppntBean() {
/* 2441 */     return this.appntBean;
/*      */   }
/*      */ 
/*      */   public void setAppntBean(BankLNPAppntBean appntBean) {
/* 2445 */     this.appntBean = appntBean;
/*      */   }
/*      */ 
/*      */   public BankLNPInusredBean getInusredBean() {
/* 2449 */     return this.insuredBean;
/*      */   }
/*      */ 
/*      */   public void setInusredBean(BankLNPInusredBean inusredBean) {
/* 2453 */     this.insuredBean = inusredBean;
/*      */   }
/*      */ 
/*      */   public BankLNPPersonBean getInsurPersonBean() {
/* 2457 */     return this.insurPersonBean;
/*      */   }
/*      */ 
/*      */   public void setInsurPersonBean(BankLNPPersonBean insurPersonBean) {
/* 2461 */     this.insurPersonBean = insurPersonBean;
/*      */   }
/*      */ 
/*      */   public BankLNPAddressBean getInsuraddressBean() {
/* 2465 */     return this.insuraddressBean;
/*      */   }
/*      */ 
/*      */   public void setInsuraddressBean(BankLNPAddressBean insuraddressBean) {
/* 2469 */     this.insuraddressBean = insuraddressBean;
/*      */   }
/*      */ 
/*      */   public BankLNPPersonBean getAppntPersonBean() {
/* 2473 */     return this.appntPersonBean;
/*      */   }
/*      */ 
/*      */   public void setAppntPersonBean(BankLNPPersonBean appntPersonBean) {
/* 2477 */     this.appntPersonBean = appntPersonBean;
/*      */   }
/*      */ 
/*      */   public BankLNPAddressBean getAppntaddressBean() {
/* 2481 */     return this.appntaddressBean;
/*      */   }
/*      */ 
/*      */   public void setAppntaddressBean(BankLNPAddressBean appntaddressBean) {
/* 2485 */     this.appntaddressBean = appntaddressBean;
/*      */   }
/*      */ 
/*      */   public List<BankLNPBnfBean> getBnfList() {
/* 2489 */     return this.bnfList;
/*      */   }
/*      */ 
/*      */   public void setBnfList(List<BankLNPBnfBean> bnfList) {
/* 2493 */     this.bnfList = bnfList;
/*      */   }
/*      */ 
/*      */   public String getAIRealation() {
/* 2497 */     return this.AIRealation;
/*      */   }
/*      */ 
/*      */   public void setAIRealation(String aIRealation) {
/* 2501 */     this.AIRealation = aIRealation;
/*      */   }
/*      */ 
/*      */   public String getAppntVIP() {
/* 2505 */     return this.AppntVIP;
/*      */   }
/*      */ 
/*      */   public void setAppntVIP(String appntVIP) {
/* 2509 */     this.AppntVIP = appntVIP;
/*      */   }
/*      */ 
/*      */   public String getAppntName()
/*      */   {
/* 2514 */     return this.AppntName;
/*      */   }
/*      */ 
/*      */   public void setAppntName(String appntName)
/*      */   {
/* 2519 */     this.AppntName = appntName;
/*      */   }
/*      */ 
/*      */   public String getAppntSex() {
/* 2523 */     return this.AppntSex;
/*      */   }
/*      */ 
/*      */   public void setAppntSex(String appntSex) {
/* 2527 */     this.AppntSex = appntSex;
/*      */   }
/*      */ 
/*      */   public String getAppntBirthDay() {
/* 2531 */     return formatDate(this.AppntBirthDay, "YYYYMMDD");
/*      */   }
/*      */ 
/*      */   public void setAppntBirthDay(String appntBirthDay) {
/* 2535 */     this.AppntBirthDay = formatDate(appntBirthDay, "YYYY-MM-DD");
/*      */   }
/*      */ 
/*      */   public String getAppntAge() {
/* 2539 */     return this.AppntAge;
/*      */   }
/*      */ 
/*      */   public void setAppntAge(String appntAge) {
/* 2543 */     this.AppntAge = appntAge;
/*      */   }
/*      */ 
/*      */   public String getAppntIDType() {
/* 2547 */     return this.AppntIDType;
/*      */   }
/*      */ 
/*      */   public void setAppntIDType(String appntIDType) {
/* 2551 */     this.AppntIDType = appntIDType;
/*      */   }
/*      */ 
/*      */   public String getAppntID() {
/* 2555 */     return this.AppntID;
/*      */   }
/*      */ 
/*      */   public void setAppntID(String appntID) {
/* 2559 */     this.AppntID = appntID;
/*      */   }
/*      */ 
/*      */   public String getAppntIDVailityType() {
/* 2563 */     return this.AppntIDVailityType;
/*      */   }
/*      */ 
/*      */   public void setAppntIDVailityType(String appntIDVailityType) {
/* 2567 */     this.AppntIDVailityType = appntIDVailityType;
/*      */   }
/*      */ 
/*      */   public String getAppntIDVaility() {
/* 2571 */     return formatDate(this.AppntIDVaility, "YYYMMDD");
/*      */   }
/*      */ 
/*      */   public void setAppntIDVaility(String appntIDVaility) {
/* 2575 */     this.AppntIDVaility = formatDate(appntIDVaility, "YYYY-MM-DD");
/*      */   }
/*      */ 
/*      */   public String getAppntNative() {
/* 2579 */     return this.AppntNative;
/*      */   }
/*      */ 
/*      */   public void setAppntNative(String appntNative) {
/* 2583 */     this.AppntNative = appntNative;
/*      */   }
/*      */ 
/*      */   public String getAppntIDView() {
/* 2587 */     return this.AppntIDView;
/*      */   }
/*      */ 
/*      */   public void setAppntIDView(String appntIDView) {
/* 2591 */     this.AppntIDView = appntIDView;
/*      */   }
/*      */ 
/*      */   public String getAppntGrpName() {
/* 2595 */     return this.AppntGrpName;
/*      */   }
/*      */ 
/*      */   public void setAppntGrpName(String appntGrpName) {
/* 2599 */     this.AppntGrpName = appntGrpName;
/*      */   }
/*      */ 
/*      */   public String getOccType() {
/* 2603 */     return this.OccType;
/*      */   }
/*      */ 
/*      */   public void setOccType(String occType) {
/* 2607 */     this.OccType = occType;
/*      */   }
/*      */ 
/*      */   public String getAOccupationCode() {
/* 2611 */     return this.AOccupationCode;
/*      */   }
/*      */ 
/*      */   public void setAOccupationCode(String aOccupationCode) {
/* 2615 */     this.AOccupationCode = aOccupationCode;
/*      */   }
/*      */ 
/*      */   public String getAOccupationName() {
/* 2619 */     return this.AOccupationName;
/*      */   }
/*      */ 
/*      */   public void setAOccupationName(String aOccupationName) {
/* 2623 */     this.AOccupationName = aOccupationName;
/*      */   }
/*      */ 
/*      */   public String getAppntCompanyAddr() {
/* 2627 */     return this.AppntCompanyAddr;
/*      */   }
/*      */ 
/*      */   public void setAppntCompanyAddr(String appntCompanyAddr) {
/* 2631 */     this.AppntCompanyAddr = appntCompanyAddr;
/*      */   }
/*      */ 
/*      */   public String getAppntCompanyPhone() {
/* 2635 */     return this.AppntCompanyPhone;
/*      */   }
/*      */ 
/*      */   public void setAppntCompanyPhone(String appntCompanyPhone) {
/* 2639 */     this.AppntCompanyPhone = appntCompanyPhone;
/*      */   }
/*      */ 
/*      */   public String getAppntCompanyZipCode() {
/* 2643 */     return this.AppntCompanyZipCode;
/*      */   }
/*      */ 
/*      */   public void setAppntCompanyZipCode(String appntCompanyZipCode) {
/* 2647 */     this.AppntCompanyZipCode = appntCompanyZipCode;
/*      */   }
/*      */ 
/*      */   public String getAppntIPhone() {
/* 2651 */     return this.AppntIPhone;
/*      */   }
/*      */ 
/*      */   public void setAppntIPhone(String appntIPhone) {
/* 2655 */     this.AppntIPhone = appntIPhone;
/*      */   }
/*      */ 
/*      */   public String getAppntCompanyMail() {
/* 2659 */     return this.AppntCompanyMail;
/*      */   }
/*      */ 
/*      */   public void setAppntCompanyMail(String appntCompanyMail) {
/* 2663 */     this.AppntCompanyMail = appntCompanyMail;
/*      */   }
/*      */ 
/*      */   public String getAppntSalary() {
/* 2667 */     return this.AppntSalary;
/*      */   }
/*      */ 
/*      */   public void setAppntSalary(String appntSalary) {
/* 2671 */     this.AppntSalary = appntSalary;
/*      */   }
/*      */ 
/*      */   public String getAppntLinkAdr() {
/* 2675 */     return this.AppntLinkAdr;
/*      */   }
/*      */ 
/*      */   public void setAppntLinkAdr(String appntLinkAdr) {
/* 2679 */     this.AppntLinkAdr = appntLinkAdr;
/*      */   }
/*      */ 
/*      */   public String getAppntHomeZipCode() {
/* 2683 */     return this.AppntHomeZipCode;
/*      */   }
/*      */ 
/*      */   public void setAppntHomeZipCode(String appntHomeZipCode) {
/* 2687 */     this.AppntHomeZipCode = appntHomeZipCode;
/*      */   }
/*      */ 
/*      */   public String getAppntHomeAddr() {
/* 2691 */     return this.AppntHomeAddr;
/*      */   }
/*      */ 
/*      */   public void setAppntHomeAddr(String appntHomeAddr) {
/* 2695 */     this.AppntHomeAddr = appntHomeAddr;
/*      */   }
/*      */ 
/*      */   public String getInsurName()
/*      */   {
/* 2700 */     return this.InsurName;
/*      */   }
/*      */ 
/*      */   public void setInsurName(String insurName)
/*      */   {
/* 2705 */     this.InsurName = insurName;
/*      */   }
/*      */ 
/*      */   public String getInsurSex() {
/* 2709 */     return this.InsurSex;
/*      */   }
/*      */ 
/*      */   public void setInsurSex(String insurSex) {
/* 2713 */     this.InsurSex = insurSex;
/*      */   }
/*      */ 
/*      */   public String getInsurBirthDay() {
/* 2717 */     return formatDate(this.InsurBirthDay, "YYYYMMDD");
/*      */   }
/*      */ 
/*      */   public void setInsurBirthDay(String insurBirthDay) {
/* 2721 */     this.InsurBirthDay = formatDate(insurBirthDay, "YYYY-MM-DD");
/*      */   }
/*      */ 
/*      */   public String getInsurAge() {
/* 2725 */     return this.InsurAge;
/*      */   }
/*      */ 
/*      */   public void setInsurAge(String insurAge) {
/* 2729 */     this.InsurAge = insurAge;
/*      */   }
/*      */ 
/*      */   public String getInsurIDType() {
/* 2733 */     return this.InsurIDType;
/*      */   }
/*      */ 
/*      */   public void setInsurIDType(String insurIDType) {
/* 2737 */     this.InsurIDType = insurIDType;
/*      */   }
/*      */ 
/*      */   public String getInsurID() {
/* 2741 */     return this.InsurID;
/*      */   }
/*      */ 
/*      */   public void setInsurID(String insurID) {
/* 2745 */     this.InsurID = insurID;
/*      */   }
/*      */ 
/*      */   public String getInsurIDVailityType() {
/* 2749 */     return this.InsurIDVailityType;
/*      */   }
/*      */ 
/*      */   public void setInsurIDVailityType(String insurIDVailityType) {
/* 2753 */     this.InsurIDVailityType = insurIDVailityType;
/*      */   }
/*      */ 
/*      */   public String getInsurIDVaility() {
/* 2757 */     return formatDate(this.InsurIDVaility, "YYYYMMDD");
/*      */   }
/*      */ 
/*      */   public void setInsurIDVaility(String insurIDVaility) {
/* 2761 */     this.InsurIDVaility = formatDate(insurIDVaility, "YYYY-MM-DD");
/*      */   }
/*      */ 
/*      */   public String getInsurNative() {
/* 2765 */     return this.InsurNative;
/*      */   }
/*      */ 
/*      */   public void setInsurNative(String insurNative) {
/* 2769 */     this.InsurNative = insurNative;
/*      */   }
/*      */ 
/*      */   public String getInsurIDView() {
/* 2773 */     return this.InsurIDView;
/*      */   }
/*      */ 
/*      */   public void setInsurIDView(String insurIDView) {
/* 2777 */     this.InsurIDView = insurIDView;
/*      */   }
/*      */ 
/*      */   public String getInsurGrpName() {
/* 2781 */     return this.InsurGrpName;
/*      */   }
/*      */ 
/*      */   public void setInsurGrpName(String insurGrpName) {
/* 2785 */     this.InsurGrpName = insurGrpName;
/*      */   }
/*      */ 
/*      */   public String getIOccupationCode() {
/* 2789 */     return this.IOccupationCode;
/*      */   }
/*      */ 
/*      */   public void setIOccupationCode(String iOccupationCode) {
/* 2793 */     this.IOccupationCode = iOccupationCode;
/*      */   }
/*      */ 
/*      */   public String getIOccupationName() {
/* 2797 */     return this.IOccupationName;
/*      */   }
/*      */ 
/*      */   public void setIOccupationName(String iOccupationName) {
/* 2801 */     this.IOccupationName = iOccupationName;
/*      */   }
/*      */ 
/*      */   public String getInsurCompanyAddr() {
/* 2805 */     return this.InsurCompanyAddr;
/*      */   }
/*      */ 
/*      */   public void setInsurCompanyAddr(String insurCompanyAddr) {
/* 2809 */     this.InsurCompanyAddr = insurCompanyAddr;
/*      */   }
/*      */ 
/*      */   public String getInsurCompanyPhone() {
/* 2813 */     return this.InsurCompanyPhone;
/*      */   }
/*      */ 
/*      */   public void setInsurCompanyPhone(String insurCompanyPhone) {
/* 2817 */     this.InsurCompanyPhone = insurCompanyPhone;
/*      */   }
/*      */ 
/*      */   public String getInsurCompanyZipCode() {
/* 2821 */     return this.InsurCompanyZipCode;
/*      */   }
/*      */ 
/*      */   public void setInsurCompanyZipCode(String insurCompanyZipCode) {
/* 2825 */     this.InsurCompanyZipCode = insurCompanyZipCode;
/*      */   }
/*      */ 
/*      */   public String getInsurIPhone() {
/* 2829 */     return this.InsurIPhone;
/*      */   }
/*      */ 
/*      */   public void setInsurIPhone(String insurIPhone) {
/* 2833 */     this.InsurIPhone = insurIPhone;
/*      */   }
/*      */ 
/*      */   public String getInsurCompanyMail() {
/* 2837 */     return this.InsurCompanyMail;
/*      */   }
/*      */ 
/*      */   public void setInsurCompanyMail(String insurCompanyMail) {
/* 2841 */     this.InsurCompanyMail = insurCompanyMail;
/*      */   }
/*      */ 
/*      */   public String getInsurSalary() {
/* 2845 */     return this.InsurSalary;
/*      */   }
/*      */ 
/*      */   public void setInsurSalary(String insurSalary) {
/* 2849 */     this.InsurSalary = insurSalary;
/*      */   }
/*      */ 
/*      */   public String getInsurLinkAdr() {
/* 2853 */     return this.InsurLinkAdr;
/*      */   }
/*      */ 
/*      */   public void setInsurLinkAdr(String insurLinkAdr) {
/* 2857 */     this.InsurLinkAdr = insurLinkAdr;
/*      */   }
/*      */ 
/*      */   public String getInsurHomeZipCode() {
/* 2861 */     return this.InsurHomeZipCode;
/*      */   }
/*      */ 
/*      */   public void setInsurHomeZipCode(String insurHomeZipCode) {
/* 2865 */     this.InsurHomeZipCode = insurHomeZipCode;
/*      */   }
/*      */ 
/*      */   public String getInsurHomeAddr() {
/* 2869 */     return this.InsurHomeAddr;
/*      */   }
/*      */ 
/*      */   public void setInsurHomeAddr(String insurHomeAddr) {
/* 2873 */     this.InsurHomeAddr = insurHomeAddr;
/*      */   }
/*      */ 
/*      */   public String getMessage() {
/* 2877 */     System.out.println("get--------------" + this.message);
/* 2878 */     return this.message;
/*      */   }
/*      */ 
/*      */   public void setMessage(String message) {
/* 2882 */     System.out.println("set--------------" + message);
/* 2883 */     this.message = message;
/*      */   }
/*      */ 
/*      */   public boolean isAppntHasFlag() {
/* 2887 */     return this.appntHasFlag;
/*      */   }
/*      */ 
/*      */   public void setAppntHasFlag(boolean appntHasFlag) {
/* 2891 */     this.appntHasFlag = appntHasFlag;
/*      */   }
/*      */ 
/*      */   public boolean isInsurHasFlag() {
/* 2895 */     return this.insurHasFlag;
/*      */   }
/*      */ 
/*      */   public void setInsurHasFlag(boolean insurHasFlag) {
/* 2899 */     this.insurHasFlag = insurHasFlag;
/*      */   }
/*      */ 
/*      */   public boolean isBnfHasFlag() {
/* 2903 */     return this.bnfHasFlag;
/*      */   }
/*      */ 
/*      */   public void setBnfHasFlag(boolean bnfHasFlag) {
/* 2907 */     this.bnfHasFlag = bnfHasFlag;
/*      */   }
/*      */ 
/*      */   public IGlobalInput getGI() {
/* 2911 */     return this.GI;
/*      */   }
/*      */ 
/*      */   public void setGI(IGlobalInput gI) {
/* 2915 */     this.GI = gI;
/*      */   }
/*      */ 
/*      */   public String getBnfIsExist() {
/* 2919 */     return this.BnfIsExist;
/*      */   }
/*      */ 
/*      */   public void setBnfIsExist(String bnfIsExist) {
/* 2923 */     this.BnfIsExist = bnfIsExist;
/*      */   }
/*      */ 
/*      */   public String getBnfRecType() {
/* 2927 */     return this.BnfRecType;
/*      */   }
/*      */ 
/*      */   public void setBnfRecType(String bnfRecType) {
/* 2931 */     this.BnfRecType = bnfRecType;
/*      */   }
/*      */ 
/*      */   public boolean isOperateResult() {
/* 2935 */     return this.operateResult;
/*      */   }
/*      */ 
/*      */   public void setOperateResult(boolean operateResult) {
/* 2939 */     this.operateResult = operateResult;
/*      */   }
/*      */ 
/*      */   public List<BankLNPBnfBean> getDelBnfList() {
/* 2943 */     return this.delBnfList;
/*      */   }
/*      */ 
/*      */   public void setDelBnfList(List<BankLNPBnfBean> delBnfList) {
/* 2947 */     this.delBnfList = delBnfList;
/*      */   }
/*      */ 
/*      */   public int getBnfMinSize() {
/* 2951 */     return this.BnfMinSize;
/*      */   }
/*      */ 
/*      */   public void setBnfMinSize(int bnfMinSize) {
/* 2955 */     this.BnfMinSize = bnfMinSize;
/*      */   }
/*      */ 
/*      */   public int getBnfSize() {
/* 2959 */     return this.BnfSize;
/*      */   }
/*      */ 
/*      */   public void setBnfSize(int bnfSize) {
/* 2963 */     this.BnfSize = bnfSize;
/*      */   }
/*      */ 
/*      */   public String getCAge() {
/* 2967 */     return this.CAge;
/*      */   }
/*      */ 
/*      */   public void setCAge(String cAge) {
/* 2971 */     this.CAge = cAge;
/*      */   }
/*      */ 
/*      */   public String getCType() {
/* 2975 */     return this.CType;
/*      */   }
/*      */ 
/*      */   public void setCType(String cType) {
/* 2979 */     this.CType = cType;
/*      */   }
/*      */ 
/*      */   public String getCBirth() {
/* 2983 */     return this.CBirth;
/*      */   }
/*      */ 
/*      */   public void setCBirth(String cBirth) {
/* 2987 */     this.CBirth = cBirth;
/*      */   }
/*      */ 
/*      */   public boolean isAllCompelte() {
/* 2991 */     return this.allCompelte;
/*      */   }
/*      */ 
/*      */   public void setAllCompelte(boolean allCompelte) {
/* 2995 */     this.allCompelte = allCompelte;
/*      */   }
/*      */ 
/*      */   public String getOccCode() {
/* 2999 */     return this.OccCode;
/*      */   }
/*      */ 
/*      */   public void setOccCode(String occCode) {
/* 3003 */     this.OccCode = occCode;
/*      */   }
/*      */ 
/*      */   public String getCurBnfId() {
/* 3007 */     return this.curBnfId;
/*      */   }
/*      */ 
/*      */   public void setCurBnfId(String curBnfId) {
/* 3011 */     this.curBnfId = curBnfId;
/*      */   }
/*      */ 
/*      */   public int getCurIdx() {
/* 3015 */     return this.curIdx;
/*      */   }
/*      */ 
/*      */   public void setCurIdx(int curIdx) {
/* 3019 */     this.curIdx = curIdx;
/*      */   }
/*      */ 
/*      */   public String getAppntAreaCode() {
/* 3023 */     return this.appntAreaCode;
/*      */   }
/*      */ 
/*      */   public void setAppntAreaCode(String appntAreaCode) {
/* 3027 */     this.appntAreaCode = appntAreaCode;
/*      */   }
/*      */ 
/*      */   public String getAppntHomeProvince() {
/* 3031 */     return this.appntHomeProvince;
/*      */   }
/*      */ 
/*      */   public void setAppntHomeProvince(String appntHomeProvince) {
/* 3035 */     this.appntHomeProvince = appntHomeProvince;
/*      */   }
/*      */ 
/*      */   public String getAppntHomeCity() {
/* 3039 */     return this.appntHomeCity;
/*      */   }
/*      */ 
/*      */   public void setAppntHomeCity(String appntHomeCity) {
/* 3043 */     this.appntHomeCity = appntHomeCity;
/*      */   }
/*      */ 
/*      */   public String getAppntCompanyProvince() {
/* 3047 */     return this.appntCompanyProvince;
/*      */   }
/*      */ 
/*      */   public void setAppntCompanyProvince(String appntCompanyProvince) {
/* 3051 */     this.appntCompanyProvince = appntCompanyProvince;
/*      */   }
/*      */ 
/*      */   public String getAppntCompanyCity() {
/* 3055 */     return this.appntCompanyCity;
/*      */   }
/*      */ 
/*      */   public void setAppntCompanyCity(String appntCompanyCity) {
/* 3059 */     this.appntCompanyCity = appntCompanyCity;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getAppntHomeProvinceList()
/*      */   {
/* 3071 */     if (this.appntHomeProvinceList != null) {
/* 3072 */       this.appntHomeProvinceList.clear();
/*      */     }
/* 3074 */     this.appntHomeProvinceList = getProvinceCityList("provinceCity", 2, "", "home");
/*      */ 
/* 3076 */     return this.appntHomeProvinceList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getCrsBirthProvinceList()
/*      */   {
/* 3081 */     if (this.crsBirthProvinceList != null) {
/* 3082 */       this.crsBirthProvinceList.clear();
/*      */     }
/* 3084 */     this.crsBirthProvinceList = getProvinceCityList("provinceCity", 2, "", "home");
/*      */ 
/* 3086 */     return this.crsBirthProvinceList;
/*      */   }
/*      */ 
/*      */   public String getContNo()
/*      */   {
/* 3091 */     return this.contNo;
/*      */   }
/*      */ 
/*      */   public void setContNo(String contNo) {
/* 3095 */     this.contNo = contNo;
/*      */   }
/*      */ 
/*      */   public String getCustomerName() {
/* 3099 */     return this.customerName;
/*      */   }
/*      */ 
/*      */   public void setCustomerName(String customerName) {
/* 3103 */     this.customerName = customerName;
/*      */   }
/*      */ 
/*      */   public String getTaxResidentType() {
/* 3107 */     return this.taxResidentType;
/*      */   }
/*      */ 
/*      */   public void setTaxResidentType(String taxResidentType) {
/* 3111 */     this.taxResidentType = taxResidentType;
/*      */   }
/*      */ 
/*      */   public String getFirstName() {
/* 3115 */     return this.firstName;
/*      */   }
/*      */ 
/*      */   public void setFirstName(String firstName) {
/* 3119 */     this.firstName = firstName;
/*      */   }
/*      */ 
/*      */   public String getLastName() {
/* 3123 */     return this.lastName;
/*      */   }
/*      */ 
/*      */   public void setLastName(String lastName) {
/* 3127 */     this.lastName = lastName;
/*      */   }
/*      */ 
/*      */   public String getBirthday() {
/* 3131 */     return this.birthday;
/*      */   }
/*      */ 
/*      */   public void setBirthday(String birthday) {
/* 3135 */     this.birthday = birthday;
/*      */   }
/*      */ 
/*      */   public String getCurrentAddress_Country() {
/* 3139 */     return this.currentAddress_Country;
/*      */   }
/*      */ 
/*      */   public void setCurrentAddress_Country(String currentAddress_Country) {
/* 3143 */     this.currentAddress_Country = currentAddress_Country;
/*      */   }
/*      */ 
/*      */   public String getCurrentAddress_Province() {
/* 3147 */     return this.currentAddress_Province;
/*      */   }
/*      */ 
/*      */   public void setCurrentAddress_Province(String currentAddress_Province) {
/* 3151 */     this.currentAddress_Province = currentAddress_Province;
/*      */   }
/*      */ 
/*      */   public String getCurrentAddress_City() {
/* 3155 */     return this.currentAddress_City;
/*      */   }
/*      */ 
/*      */   public void setCurrentAddress_City(String currentAddress_City) {
/* 3159 */     this.currentAddress_City = currentAddress_City;
/*      */   }
/*      */ 
/*      */   public String getCurrentAddress_Detail() {
/* 3163 */     return this.currentAddress_Detail;
/*      */   }
/*      */ 
/*      */   public void setCurrentAddress_Detail(String currentAddress_Detail) {
/* 3167 */     this.currentAddress_Detail = currentAddress_Detail;
/*      */   }
/*      */ 
/*      */   public String getCurrentAddress_Country_en() {
/* 3171 */     return this.currentAddress_Country_en;
/*      */   }
/*      */ 
/*      */   public void setCurrentAddress_Country_en(String currentAddress_Country_en) {
/* 3175 */     this.currentAddress_Country_en = currentAddress_Country_en;
/*      */   }
/*      */ 
/*      */   public String getCurrentAddress_Province_en() {
/* 3179 */     return this.currentAddress_Province_en;
/*      */   }
/*      */ 
/*      */   public void setCurrentAddress_Province_en(String currentAddress_Province_en) {
/* 3183 */     this.currentAddress_Province_en = currentAddress_Province_en;
/*      */   }
/*      */ 
/*      */   public String getCurrentAddress_City_en() {
/* 3187 */     return this.currentAddress_City_en;
/*      */   }
/*      */ 
/*      */   public void setCurrentAddress_City_en(String currentAddress_City_en) {
/* 3191 */     this.currentAddress_City_en = currentAddress_City_en;
/*      */   }
/*      */ 
/*      */   public String getCurrentAddress_Detail_en() {
/* 3195 */     return this.currentAddress_Detail_en;
/*      */   }
/*      */ 
/*      */   public void setCurrentAddress_Detail_en(String currentAddress_Detail_en) {
/* 3199 */     this.currentAddress_Detail_en = currentAddress_Detail_en;
/*      */   }
/*      */ 
/*      */   public String getBirthAddress_Country() {
/* 3203 */     return this.birthAddress_Country;
/*      */   }
/*      */ 
/*      */   public void setBirthAddress_Country(String birthAddress_Country) {
/* 3207 */     this.birthAddress_Country = birthAddress_Country;
/*      */   }
/*      */ 
/*      */   public String getBirthAddress_Province() {
/* 3211 */     return this.birthAddress_Province;
/*      */   }
/*      */ 
/*      */   public void setBirthAddress_Province(String birthAddress_Province) {
/* 3215 */     this.birthAddress_Province = birthAddress_Province;
/*      */   }
/*      */ 
/*      */   public String getBirthAddress_City() {
/* 3219 */     return this.birthAddress_City;
/*      */   }
/*      */ 
/*      */   public void setBirthAddress_City(String birthAddress_City) {
/* 3223 */     this.birthAddress_City = birthAddress_City;
/*      */   }
/*      */ 
/*      */   public String getBirthAddress_Detail() {
/* 3227 */     return this.birthAddress_Detail;
/*      */   }
/*      */ 
/*      */   public void setBirthAddress_Detail(String birthAddress_Detail) {
/* 3231 */     this.birthAddress_Detail = birthAddress_Detail;
/*      */   }
/*      */ 
/*      */   public String getBirthAddress_Country_en() {
/* 3235 */     return this.birthAddress_Country_en;
/*      */   }
/*      */ 
/*      */   public void setBirthAddress_Country_en(String birthAddress_Country_en) {
/* 3239 */     this.birthAddress_Country_en = birthAddress_Country_en;
/*      */   }
/*      */ 
/*      */   public String getBirthAddress_Province_en() {
/* 3243 */     return this.birthAddress_Province_en;
/*      */   }
/*      */ 
/*      */   public void setBirthAddress_Province_en(String birthAddress_Province_en) {
/* 3247 */     this.birthAddress_Province_en = birthAddress_Province_en;
/*      */   }
/*      */ 
/*      */   public String getBirthAddress_City_en() {
/* 3251 */     return this.birthAddress_City_en;
/*      */   }
/*      */ 
/*      */   public void setBirthAddress_City_en(String birthAddress_City_en) {
/* 3255 */     this.birthAddress_City_en = birthAddress_City_en;
/*      */   }
/*      */ 
/*      */   public String getBirthAddress_Detail_en() {
/* 3259 */     return this.birthAddress_Detail_en;
/*      */   }
/*      */ 
/*      */   public void setBirthAddress_Detail_en(String birthAddress_Detail_en) {
/* 3263 */     this.birthAddress_Detail_en = birthAddress_Detail_en;
/*      */   }
/*      */ 
/*      */   public String getTaxResidentCountry1() {
/* 3267 */     return this.taxResidentCountry1;
/*      */   }
/*      */ 
/*      */   public void setTaxResidentCountry1(String taxResidentCountry1) {
/* 3271 */     this.taxResidentCountry1 = taxResidentCountry1;
/*      */   }
/*      */ 
/*      */   public String getTaxpayerCode1() {
/* 3275 */     return this.taxpayerCode1;
/*      */   }
/*      */ 
/*      */   public void setTaxpayerCode1(String taxpayerCode1) {
/* 3279 */     this.taxpayerCode1 = taxpayerCode1;
/*      */   }
/*      */ 
/*      */   public String getTaxResidentCountry2() {
/* 3283 */     return this.taxResidentCountry2;
/*      */   }
/*      */ 
/*      */   public void setTaxResidentCountry2(String taxResidentCountry2) {
/* 3287 */     this.taxResidentCountry2 = taxResidentCountry2;
/*      */   }
/*      */ 
/*      */   public String getTaxpayerCode2() {
/* 3291 */     return this.taxpayerCode2;
/*      */   }
/*      */ 
/*      */   public void setTaxpayerCode2(String taxpayerCode2) {
/* 3295 */     this.taxpayerCode2 = taxpayerCode2;
/*      */   }
/*      */ 
/*      */   public String getTaxResidentCountry3() {
/* 3299 */     return this.taxResidentCountry3;
/*      */   }
/*      */ 
/*      */   public void setTaxResidentCountry3(String taxResidentCountry3) {
/* 3303 */     this.taxResidentCountry3 = taxResidentCountry3;
/*      */   }
/*      */ 
/*      */   public String getTaxpayerCode3() {
/* 3307 */     return this.taxpayerCode3;
/*      */   }
/*      */ 
/*      */   public void setTaxpayerCode3(String taxpayerCode3) {
/* 3311 */     this.taxpayerCode3 = taxpayerCode3;
/*      */   }
/*      */ 
/*      */   public String getNoTaxpayercodeReason() {
/* 3315 */     return this.noTaxpayercodeReason;
/*      */   }
/*      */ 
/*      */   public void setNoTaxpayercodeReason(String noTaxpayercodeReason) {
/* 3319 */     this.noTaxpayercodeReason = noTaxpayercodeReason;
/*      */   }
/*      */ 
/*      */   public String getReasonDescription() {
/* 3323 */     return this.reasonDescription;
/*      */   }
/*      */ 
/*      */   public void setReasonDescription(String reasonDescription) {
/* 3327 */     this.reasonDescription = reasonDescription;
/*      */   }
/*      */ 
/*      */   public void setAppntHomeProvinceList(List<SelectItem> appntHomeProvinceList) {
/* 3331 */     this.appntHomeProvinceList = appntHomeProvinceList;
/*      */   }
/*      */ 
/*      */   public void setCrsBirthProvinceList(List<SelectItem> crsBirthProvinceList)
/*      */   {
/* 3337 */     this.crsBirthProvinceList = crsBirthProvinceList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getCrsBirthCityList() {
/* 3341 */     if ((this.crsBirthCityList == null) || ("".equals(this.birthAddress_Province)) || ("-1".equals(this.birthAddress_Province))) {
/* 3342 */       if (this.crsBirthCityList != null)
/* 3343 */         this.crsBirthCityList.clear();
/*      */     }
/*      */     else {
/* 3346 */       this.crsBirthCityList = getProvinceCityList("provinceCity", 4, this.birthAddress_Province, "home");
/*      */     }
/* 3348 */     return this.crsBirthCityList;
/*      */   }
/*      */ 
/*      */   public void setCrsBirthCityList(List<SelectItem> crsBirthCityList) {
/* 3352 */     this.crsBirthCityList = crsBirthCityList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getAppntHomeCityList()
/*      */   {
/* 3357 */     if ((this.appntHomeProvince == null) || ("".equals(this.appntHomeProvince)) || ("-1".equals(this.appntHomeProvince))) {
/* 3358 */       if (this.appntHomeCityList != null)
/* 3359 */         this.appntHomeCityList.clear();
/*      */     }
/*      */     else {
/* 3362 */       this.appntHomeCityList = getProvinceCityList("provinceCity", 4, this.appntHomeProvince, "home");
/*      */     }
/* 3364 */     return this.appntHomeCityList;
/*      */   }
/*      */ 
/*      */   public void setAppntHomeCityList(List<SelectItem> appntHomeCityList) {
/* 3368 */     this.appntHomeCityList = appntHomeCityList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getAppntHomeCountyList() {
/* 3372 */     if ((this.appntHomeCity == null) || ("".equals(this.appntHomeCity)) || ("-1".equals(this.appntHomeCity))) {
/* 3373 */       if (this.appntHomeCountyList != null)
/* 3374 */         this.appntHomeCountyList.clear();
/*      */     }
/*      */     else {
/* 3377 */       this.appntHomeCountyList = getProvinceCityList("provinceCity", 6, this.appntHomeCity, "home");
/*      */     }
/* 3379 */     return this.appntHomeCountyList;
/*      */   }
/*      */ 
/*      */   public void setAppntHomeCountyList(List<SelectItem> appntHomeCountyList) {
/* 3383 */     this.appntHomeCountyList = appntHomeCountyList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getAppntCompanyProvinceList() {
/* 3387 */     if (this.appntCompanyProvinceList != null) {
/* 3388 */       this.appntCompanyProvinceList.clear();
/*      */     }
/* 3390 */     this.appntCompanyProvinceList = getProvinceCityList("provinceCity", 2, "", "company");
/* 3391 */     return this.appntCompanyProvinceList;
/*      */   }
/*      */ 
/*      */   public void setAppntCompanyProvinceList(List<SelectItem> appntCompanyProvinceList) {
/* 3395 */     this.appntCompanyProvinceList = appntCompanyProvinceList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getAppntCompanyCityList() {
/* 3399 */     if ((this.appntCompanyProvince == null) || ("".equals(this.appntCompanyProvince)) || ("-1".equals(this.appntCompanyProvince))) {
/* 3400 */       if (this.appntCompanyCityList != null)
/* 3401 */         this.appntCompanyCityList.clear();
/*      */     }
/*      */     else {
/* 3404 */       this.appntCompanyCityList = getProvinceCityList("provinceCity", 4, this.appntCompanyProvince, "company");
/*      */     }
/* 3406 */     return this.appntCompanyCityList;
/*      */   }
/*      */ 
/*      */   public void setAppntCompanyCityList(List<SelectItem> appntCompanyCityList) {
/* 3410 */     this.appntCompanyCityList = appntCompanyCityList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getAppntCompanyCountyList() {
/* 3414 */     if ((this.appntCompanyCity == null) || ("".equals(this.appntCompanyCity)) || ("-1".equals(this.appntCompanyCity))) {
/* 3415 */       if (this.appntCompanyCountyList != null)
/* 3416 */         this.appntCompanyCountyList.clear();
/*      */     }
/*      */     else {
/* 3419 */       this.appntCompanyCountyList = getProvinceCityList("provinceCity", 6, this.appntCompanyCity, "company");
/*      */     }
/* 3421 */     return this.appntCompanyCountyList;
/*      */   }
/*      */ 
/*      */   public void setAppntCompanyCountyList(List<SelectItem> appntCompanyCountyList) {
/* 3425 */     this.appntCompanyCountyList = appntCompanyCountyList;
/*      */   }
/*      */ 
/*      */   public String getInsuAreaCode() {
/* 3429 */     return this.insuAreaCode;
/*      */   }
/*      */ 
/*      */   public void setInsuAreaCode(String insuAreaCode) {
/* 3433 */     this.insuAreaCode = insuAreaCode;
/*      */   }
/*      */ 
/*      */   public String getInsurHomeProvince() {
/* 3437 */     return this.insurHomeProvince;
/*      */   }
/*      */ 
/*      */   public void setInsurHomeProvince(String insurHomeProvince) {
/* 3441 */     this.insurHomeProvince = insurHomeProvince;
/*      */   }
/*      */ 
/*      */   public String getInsurHomeCity() {
/* 3445 */     return this.insurHomeCity;
/*      */   }
/*      */ 
/*      */   public void setInsurHomeCity(String insurHomeCity) {
/* 3449 */     this.insurHomeCity = insurHomeCity;
/*      */   }
/*      */ 
/*      */   public String getInsurCompanyProvince() {
/* 3453 */     return this.insurCompanyProvince;
/*      */   }
/*      */ 
/*      */   public void setInsurCompanyProvince(String insurCompanyProvince) {
/* 3457 */     this.insurCompanyProvince = insurCompanyProvince;
/*      */   }
/*      */ 
/*      */   public String getInsurCompanyCity() {
/* 3461 */     return this.insurCompanyCity;
/*      */   }
/*      */ 
/*      */   public void setInsurCompanyCity(String insurCompanyCity) {
/* 3465 */     this.insurCompanyCity = insurCompanyCity;
/*      */   }
/*      */ 
/*      */   public String getAppntHomeCounty() {
/* 3469 */     return this.appntHomeCounty;
/*      */   }
/*      */ 
/*      */   public void setAppntHomeCounty(String appntHomeCounty) {
/* 3473 */     this.appntHomeCounty = appntHomeCounty;
/*      */   }
/*      */ 
/*      */   public String getAppntHomeRoad() {
/* 3477 */     return this.appntHomeRoad;
/*      */   }
/*      */ 
/*      */   public void setAppntHomeRoad(String appntHomeRoad) {
/* 3481 */     this.appntHomeRoad = appntHomeRoad;
/*      */   }
/*      */ 
/*      */   public String getAppntHomeVillage() {
/* 3485 */     return this.appntHomeVillage;
/*      */   }
/*      */ 
/*      */   public void setAppntHomeVillage(String appntHomeVillage) {
/* 3489 */     this.appntHomeVillage = appntHomeVillage;
/*      */   }
/*      */ 
/*      */   public String getAppntCompanyCounty() {
/* 3493 */     return this.appntCompanyCounty;
/*      */   }
/*      */ 
/*      */   public void setAppntCompanyCounty(String appntCompanyCounty) {
/* 3497 */     this.appntCompanyCounty = appntCompanyCounty;
/*      */   }
/*      */ 
/*      */   public String getAppntCompanyRoad() {
/* 3501 */     return this.appntCompanyRoad;
/*      */   }
/*      */ 
/*      */   public void setAppntCompanyRoad(String appntCompanyRoad) {
/* 3505 */     this.appntCompanyRoad = appntCompanyRoad;
/*      */   }
/*      */ 
/*      */   public String getAppntCompanyVillage() {
/* 3509 */     return this.appntCompanyVillage;
/*      */   }
/*      */ 
/*      */   public void setAppntCompanyVillage(String appntCompanyVillage) {
/* 3513 */     this.appntCompanyVillage = appntCompanyVillage;
/*      */   }
/*      */ 
/*      */   public String getInsurHomeCounty() {
/* 3517 */     return this.insurHomeCounty;
/*      */   }
/*      */ 
/*      */   public void setInsurHomeCounty(String insurHomeCounty) {
/* 3521 */     this.insurHomeCounty = insurHomeCounty;
/*      */   }
/*      */ 
/*      */   public String getInsurHomeRoad() {
/* 3525 */     return this.insurHomeRoad;
/*      */   }
/*      */ 
/*      */   public void setInsurHomeRoad(String insurHomeRoad) {
/* 3529 */     this.insurHomeRoad = insurHomeRoad;
/*      */   }
/*      */ 
/*      */   public String getInsurHomeVillage() {
/* 3533 */     return this.insurHomeVillage;
/*      */   }
/*      */ 
/*      */   public void setInsurHomeVillage(String insurHomeVillage) {
/* 3537 */     this.insurHomeVillage = insurHomeVillage;
/*      */   }
/*      */ 
/*      */   public String getInsurCompanyCounty() {
/* 3541 */     return this.insurCompanyCounty;
/*      */   }
/*      */ 
/*      */   public void setInsurCompanyCounty(String insurCompanyCounty) {
/* 3545 */     this.insurCompanyCounty = insurCompanyCounty;
/*      */   }
/*      */ 
/*      */   public String getInsurCompanyRoad() {
/* 3549 */     return this.insurCompanyRoad;
/*      */   }
/*      */ 
/*      */   public void setInsurCompanyRoad(String insurCompanyRoad) {
/* 3553 */     this.insurCompanyRoad = insurCompanyRoad;
/*      */   }
/*      */ 
/*      */   public String getInsurCompanyVillage() {
/* 3557 */     return this.insurCompanyVillage;
/*      */   }
/*      */ 
/*      */   public void setInsurCompanyVillage(String insurCompanyVillage) {
/* 3561 */     this.insurCompanyVillage = insurCompanyVillage;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getInsurHomeProvinceList() {
/* 3565 */     if (this.insurHomeProvinceList != null) {
/* 3566 */       this.insurHomeProvinceList.clear();
/*      */     }
/* 3568 */     this.insurHomeProvinceList = getProvinceCityList("provinceCity", 2, "", "home");
/* 3569 */     return this.insurHomeProvinceList;
/*      */   }
/*      */ 
/*      */   public void setInsurHomeProvinceList(List<SelectItem> insurHomeProvinceList) {
/* 3573 */     this.insurHomeProvinceList = insurHomeProvinceList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getInsurHomeCityList() {
/* 3577 */     if ((this.insurHomeProvince == null) || ("".equals(this.insurHomeProvince)) || ("-1".equals(this.insurHomeProvince))) {
/* 3578 */       if (this.insurHomeCityList != null)
/* 3579 */         this.insurHomeCityList.clear();
/*      */     }
/*      */     else {
/* 3582 */       this.insurHomeCityList = getProvinceCityList("provinceCity", 4, this.insurHomeProvince, "home");
/*      */     }
/* 3584 */     return this.insurHomeCityList;
/*      */   }
/*      */ 
/*      */   public void setInsurHomeCityList(List<SelectItem> insurHomeCityList) {
/* 3588 */     this.insurHomeCityList = insurHomeCityList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getInsurHomeCountyList() {
/* 3592 */     if ((this.insurHomeCity == null) || ("".equals(this.insurHomeCity)) || ("-1".equals(this.insurHomeCity))) {
/* 3593 */       if (this.insurHomeCountyList != null)
/* 3594 */         this.insurHomeCountyList.clear();
/*      */     }
/*      */     else {
/* 3597 */       this.insurHomeCountyList = getProvinceCityList("provinceCity", 6, this.insurHomeCity, "home");
/*      */     }
/* 3599 */     return this.insurHomeCountyList;
/*      */   }
/*      */ 
/*      */   public void setInsurHomeCountyList(List<SelectItem> insurHomeCountyList) {
/* 3603 */     this.insurHomeCountyList = insurHomeCountyList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getInsurCompanyProvinceList() {
/* 3607 */     if (this.insurCompanyProvinceList != null) {
/* 3608 */       this.insurCompanyProvinceList.clear();
/*      */     }
/* 3610 */     this.insurCompanyProvinceList = getProvinceCityList("provinceCity", 2, "", "company");
/* 3611 */     return this.insurCompanyProvinceList;
/*      */   }
/*      */ 
/*      */   public void setInsurCompanyProvinceList(List<SelectItem> insurCompanyProvinceList) {
/* 3615 */     this.insurCompanyProvinceList = insurCompanyProvinceList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getInsurCompanyCityList() {
/* 3619 */     if ((this.insurCompanyProvince == null) || ("".equals(this.insurCompanyProvince)) || ("-1".equals(this.insurCompanyProvince))) {
/* 3620 */       if (this.insurCompanyCityList != null)
/* 3621 */         this.insurCompanyCityList.clear();
/*      */     }
/*      */     else {
/* 3624 */       this.insurCompanyCityList = getProvinceCityList("provinceCity", 4, this.insurCompanyProvince, "company");
/*      */     }
/* 3626 */     return this.insurCompanyCityList;
/*      */   }
/*      */ 
/*      */   public void setInsurCompanyCityList(List<SelectItem> insurCompanyCityList) {
/* 3630 */     this.insurCompanyCityList = insurCompanyCityList;
/*      */   }
/*      */ 
/*      */   public List<SelectItem> getInsurCompanyCountyList() {
/* 3634 */     if ((this.insurCompanyCity == null) || ("".equals(this.insurCompanyCity)) || ("-1".equals(this.insurCompanyCity))) {
/* 3635 */       if (this.insurCompanyCountyList != null)
/* 3636 */         this.insurCompanyCountyList.clear();
/*      */     }
/*      */     else {
/* 3639 */       this.insurCompanyCountyList = getProvinceCityList("provinceCity", 6, this.insurCompanyCity, "company");
/*      */     }
/* 3641 */     return this.insurCompanyCountyList;
/*      */   }
/*      */ 
/*      */   public void setInsurCompanyCountyList(List<SelectItem> insurCompanyCountyList) {
/* 3645 */     this.insurCompanyCountyList = insurCompanyCountyList;
/*      */   }
/*      */ 
/*      */   private List<SelectItem> getProvinceCityList(String typename, int codeLen, String codeFirstNum, String addrType)
/*      */   {
/* 3667 */     List reList = new ArrayList();
/* 3668 */     ExeSQL tExeSQL = new ExeSQL();
/*      */ 
/* 3670 */     String sql = "select code,codename from lnpcode where codetype='" + typename + "' and len(code)=" + codeLen;
/* 3671 */     if ((codeFirstNum != null) && (!"".equals(codeFirstNum))) {
/* 3672 */       sql = sql + " and code like '" + codeFirstNum + "%'";
/*      */     }
/* 3674 */     if ("company".equals(addrType)) {
/* 3675 */       sql = sql + " and codealias='1'";
/*      */     }
/* 3677 */     sql = sql + " order by codeName";
/*      */ 
/* 3679 */     SSRS tSRS = tExeSQL.execSQL(sql);
/* 3680 */     for (int i = 1; i <= tSRS.MaxRow; i++) {
/* 3681 */       reList.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*      */     }
/* 3683 */     return reList;
/*      */   }
/*      */ 
/*      */   public String getValiDate()
/*      */   {
/* 3690 */     return this.valiDate;
/*      */   }
/*      */ 
/*      */   public void setValiDate(String valiDate) {
/* 3694 */     this.valiDate = valiDate;
/*      */   }
/*      */ 
/*      */   private static String getCode(String name, String type)
/*      */   {
/* 3705 */     String code = "";
/* 3706 */     String sql = "";
/* 3707 */     ExeSQL tExeSQL = new ExeSQL();
/* 3708 */     if ("e".equals(type))
/* 3709 */       sql = "select code from crscode where  codetype='country' and codenameen='" + name + "'";
/*      */     else {
/* 3711 */       sql = "select code from crscode where  codetype='country' and codename='" + name + "'";
/*      */     }
/* 3713 */     SSRS tSRS = tExeSQL.execSQL(sql);
/* 3714 */     if (tSRS.getMaxRow() > 0) {
/* 3715 */       code = tSRS.GetText(1, 1);
/*      */     }
/* 3717 */     return code;
/*      */   }
/*      */ 
/*      */   private static String getAddressCode(String name, int len)
/*      */   {
/* 3725 */     String code = "";
/* 3726 */     ExeSQL tExeSQL = new ExeSQL();
/* 3727 */     String sql = "select code from lnpcode where  codetype='provinceCity' and codename='" + name + "' and len(code)=" + len;
/* 3728 */     SSRS tSRS = tExeSQL.execSQL(sql);
/* 3729 */     if (tSRS.getMaxRow() > 0) {
/* 3730 */       code = tSRS.GetText(1, 1);
/*      */     }
/* 3732 */     return code;
/*      */   }
/*      */ 
/*      */   private static String getAddressName(String code)
/*      */   {
/* 3742 */     String addr = "";
/* 3743 */     ExeSQL tExeSQL = new ExeSQL();
/* 3744 */     String sql = "select CodeName from lnpcode where  codetype='provinceCity' and code='" + code + "'";
/* 3745 */     SSRS tSRS = tExeSQL.execSQL(sql);
/* 3746 */     if (tSRS.getMaxRow() > 0) {
/* 3747 */       addr = tSRS.GetText(1, 1);
/*      */     }
/* 3749 */     return addr;
/*      */   }
/*      */ 
/*      */   private static String getCName(String code, String type)
/*      */   {
/* 3758 */     String cname = "";
/* 3759 */     String sql = "";
/* 3760 */     ExeSQL tExeSQL = new ExeSQL();
/* 3761 */     if ("e".equals(type))
/* 3762 */       sql = "select codenameen from crscode where  codetype='country' and code='" + code + "'";
/*      */     else {
/* 3764 */       sql = "select codename from crscode where  codetype='country' and code='" + code + "'";
/*      */     }
/* 3766 */     SSRS tSRS = tExeSQL.execSQL(sql);
/* 3767 */     if (tSRS.getMaxRow() > 0) {
/* 3768 */       cname = tSRS.GetText(1, 1);
/*      */     }
/* 3770 */     return cname;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.BankCustomerDetail
 * JD-Core Version:    0.6.0
 */