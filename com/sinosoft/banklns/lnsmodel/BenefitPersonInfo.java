/*     */ package com.sinosoft.banklns.lnsmodel;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPBnfDB;
/*     */ import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
/*     */ import com.sinosoft.banklns.lis.pubfun.MMap;
/*     */ import com.sinosoft.banklns.lis.pubfun.PubFun;
/*     */ import com.sinosoft.banklns.lis.pubfun.PubSubmit;
/*     */ import com.sinosoft.banklns.lis.pubfun.SysMaxNoMAPNP;
/*     */ import com.sinosoft.banklns.lis.pubfun.ValidateTools;
/*     */ import com.sinosoft.banklns.lis.schema.LNPBnfSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPPersonSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPBnfSet;
/*     */ import com.sinosoft.banklns.lnsmodel.entity.LNPBnfBean;
/*     */ import com.sinosoft.banklns.utility.ExeSQL;
/*     */ import com.sinosoft.banklns.utility.SSRS;
/*     */ import com.sinosoft.banklns.utility.VData;
/*     */ import java.io.PrintStream;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.faces.context.ExternalContext;
/*     */ import javax.faces.context.FacesContext;
/*     */ import javax.faces.model.SelectItem;
/*     */ import javax.servlet.http.HttpSession;
/*     */ 
/*     */ public class BenefitPersonInfo
/*     */ {
/*  31 */   private boolean operateResult = true;
/*     */   private String message;
/*     */   private String infoSource;
/*     */   private String contNo;
/*  35 */   private List<LNPBnfBean> lnpBnfList = new ArrayList();
/*     */   private String operatorBnfId;
/*     */   private boolean editFlag;
/*     */   private boolean scEditFlag;
/*     */   private IGlobalInput tempGI;
/*     */   private String bnfremoveid;
/*     */   private LNPContSchema contSch;
/*  49 */   Map<String, String> genderMap = new HashMap();
/*  50 */   Map<String, String> idTypeMap = new HashMap();
/*  51 */   Map<String, String> relationToInsuredMap = new HashMap();
/*     */ 
/*  53 */   private boolean modifyFLag = false;
/*     */   private LNPBnfSchema bnfSgSchema;
/*     */   private String sex;
/*     */   private String idType;
/*     */   private String idPerpetual;
/*     */   private int bnfRate;
/*     */   private int bnfOrder;
/*  65 */   private List<SelectItem> idPerpetualList = new ArrayList();
/*     */   private String connectionWithInsurance_sc;
/*     */   private String connectionWithInsurance_sg;
/*     */   private boolean showMessageFlag;
/*     */ 
/*     */   public void initData()
/*     */   {
/*  75 */     System.out.println("-- BenefitPersonInfo initData --");
/*  76 */     this.connectionWithInsurance_sg = "";
/*  77 */     this.sex = "";
/*  78 */     this.idType = "";
/*  79 */     this.idPerpetual = "";
/*  80 */     initGenderMap();
/*  81 */     initIdTypeMap();
/*  82 */     initRelationToInsuredMap();
/*     */     try {
/*  84 */       HttpSession session = (HttpSession)FacesContext.getCurrentInstance()
/*  85 */         .getExternalContext().getSession(true);
/*  86 */       Boolean getEditFlag = (Boolean)session.getAttribute("editFlag");
/*  87 */       if ((getEditFlag != null) && (!getEditFlag.booleanValue())) {
/*  88 */         this.infoSource = "undo";
/*  89 */         this.editFlag = false;
/*     */       } else {
/*  91 */         this.editFlag = true;
/*     */       }
/*  93 */       this.bnfSgSchema = new LNPBnfSchema();
/*  94 */       this.bnfRate = 0;
/*  95 */       this.bnfOrder = 1;
/*  96 */       this.tempGI = ((IGlobalInput)session.getValue("NPGI"));
/*  97 */       if (((String)session.getAttribute("ContNo") != null) && (!((String)session.getAttribute("ContNo")).equals(""))) {
/*  98 */         this.contNo = ((String)session.getAttribute("ContNo"));
/*  99 */         PolicyMainInfo mainInfo = new PolicyMainInfo();
/* 100 */         this.contSch = mainInfo.getContByContNo(this.contNo);
/* 101 */         this.lnpBnfList = getLnpBnfList(this.contNo);
/* 102 */         this.scEditFlag = (!checkScBnfExist(this.contNo));
/*     */ 
/* 104 */         contOrder();
/*     */       }
/*     */     } catch (RuntimeException e) {
/* 107 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void savebnfSgPeople()
/*     */   {
/*     */     try {
/* 114 */       this.message = null;
/* 115 */       this.operateResult = true;
/*     */ 
/* 118 */       if (!checkScBnfExist(this.contNo)) {
/* 119 */         this.message = "\u8BF7\u5148\u586B\u5199\u751F\u5B58\u53D7\u76CA\u4EBA\u4FE1\u606F";
/* 120 */         this.operateResult = false;
/* 121 */         return;
/*     */       }
/* 123 */       System.out.println("----  savebnfSgPeople start ------");
/*     */ 
/* 126 */       if (!checkconnectionWithInsuranceSelf()) {
/* 127 */         this.operateResult = false;
/* 128 */         return;
/*     */       }
/*     */ 
/* 131 */       this.bnfSgSchema.setBnfSex(this.sex);
/* 132 */       this.bnfSgSchema.setIDType(this.idType);
/* 133 */       this.bnfSgSchema.setRelationToInsured(this.connectionWithInsurance_sg);
/* 134 */       this.bnfSgSchema.setBenefitRate(this.bnfRate);
/* 135 */       this.bnfSgSchema.setBenefitOrder(Integer.toString(this.bnfOrder));
/* 136 */       this.bnfSgSchema.setIDPerpetual(this.idPerpetual);
/*     */ 
/* 138 */       if (("0".equals(this.bnfSgSchema.getIDPerpetual().trim())) && (this.bnfSgSchema.getIDValidity() != null))
/* 139 */         this.bnfSgSchema.setIDValidity(this.bnfSgSchema.getIDValidity());
/*     */       else {
/* 141 */         this.bnfSgSchema.setIDValidity("");
/*     */       }
/* 143 */       if (!validate()) {
/* 144 */         this.operateResult = false;
/* 145 */         return;
/*     */       }
/*     */ 
/* 148 */       if (this.modifyFLag) {
/* 149 */         this.infoSource = "modify";
/* 150 */         if (modifySgBnf()) {
/* 151 */           this.message = "\u8EAB\u6545\u53D7\u76CA\u4EBA\u66F4\u65B0\u6210\u529F\uFF01";
/* 152 */           contOrder();
/*     */         } else {
/* 154 */           this.operateResult = false;
/* 155 */           return;
/*     */         }
/*     */       } else {
/* 158 */         this.infoSource = "add";
/* 159 */         if (addSgBnf()) {
/* 160 */           this.message = "\u8EAB\u6545\u53D7\u76CA\u4EBA\u4FDD\u5B58\u6210\u529F\uFF01";
/*     */ 
/* 162 */           contOrder();
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (RuntimeException e)
/*     */     {
/* 168 */       e.printStackTrace();
/*     */     }
/*     */ 
/* 172 */     System.out.println("----  savebnfSgPeople end ------");
/*     */   }
/*     */ 
/*     */   public void modifyBnf()
/*     */   {
/* 177 */     this.operateResult = true;
/* 178 */     this.message = "";
/*     */     try {
/* 180 */       System.out.println(" -- modifyBnf -- ");
/* 181 */       Map requestMap = FacesContext.getCurrentInstance().getExternalContext()
/* 182 */         .getRequestParameterMap();
/*     */ 
/* 184 */       String bnfId = (String)requestMap.get("bnfId");
/* 185 */       this.operatorBnfId = bnfId;
/* 186 */       this.modifyFLag = true;
/* 187 */       this.bnfSgSchema = getBnfSgSchByBnfId(this.contNo, bnfId, "2");
/* 188 */       this.bnfOrder = Integer.parseInt(this.bnfSgSchema.getBenefitOrder());
/* 189 */       this.sex = this.bnfSgSchema.getBnfSex();
/* 190 */       this.idType = this.bnfSgSchema.getIDType();
/* 191 */       this.idPerpetual = this.bnfSgSchema.getIDPerpetual();
/* 192 */       this.connectionWithInsurance_sg = this.bnfSgSchema.getRelationToInsured();
/*     */ 
/* 194 */       DecimalFormat df = new DecimalFormat("0");
/* 195 */       this.bnfRate = Integer.parseInt(df.format(this.bnfSgSchema.getBenefitRate()));
/*     */     } catch (NumberFormatException e) {
/* 197 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void deleteBnf()
/*     */   {
/* 203 */     this.bnfSgSchema = new LNPBnfSchema();
/* 204 */     this.sex = null;
/* 205 */     this.idType = null;
/* 206 */     this.connectionWithInsurance_sg = null;
/* 207 */     this.bnfRate = 0;
/*     */ 
/* 209 */     this.operateResult = true;
/* 210 */     this.message = "";
/* 211 */     System.out.println(" -- deleteBnf -- ");
/*     */     try
/*     */     {
/* 214 */       LNPBnfSchema deleteBnf = getBnfSgSchByBnfId(this.contNo, this.bnfremoveid, "2");
/* 215 */       PubSubmit ps = new PubSubmit();
/* 216 */       MMap map = new MMap();
/* 217 */       map.put(deleteBnf, "DELETE");
/* 218 */       VData vd = new VData();
/* 219 */       vd.add(map);
/* 220 */       if (!ps.submitData(vd, "")) {
/* 221 */         System.out.println("-BenefitPersonInfo-\u5220\u9664\u9519\u8BEF");
/* 222 */         this.message = "\u8EAB\u6545\u53D7\u76CA\u4EBA\u4FE1\u606F\u5220\u9664\u5931\u8D25\uFF01";
/* 223 */         this.operateResult = false;
/*     */       } else {
/* 225 */         this.message = "\u8EAB\u6545\u53D7\u76CA\u4EBA\u4FE1\u606F\u5220\u9664\u6210\u529F\uFF01";
/* 226 */         this.operateResult = true;
/* 227 */         removeNodeFromList(this.bnfremoveid);
/* 228 */         contOrder();
/*     */ 
/* 231 */         String sql = "select count(*) from lnpbnf where contno='" + deleteBnf.getContNo() + "' and benefittype='2' ";
/* 232 */         ExeSQL tExeSQL = new ExeSQL();
/* 233 */         SSRS tSSRS = tExeSQL.execSQL(sql);
/* 234 */         int i = Integer.parseInt(tSSRS.GetText(1, 1));
/* 235 */         if (i == 0) {
/* 236 */           String date = PubFun.getCurrentDate();
/* 237 */           String time = PubFun.getCurrentTime();
/* 238 */           StateOperatorDeal operatorDeal = new StateOperatorDeal();
/* 239 */           List stateList = operatorDeal.infoOperate(this.contSch.getState(), this.contSch.getEditstate(), "delate", "06");
/* 240 */           this.contSch.setState((String)stateList.get(0));
/* 241 */           this.contSch.setEditstate((String)stateList.get(1));
/*     */ 
/* 243 */           if ("2".equals(this.contSch.getUWFlag())) {
/* 244 */             this.contSch.setUWFlag("1");
/*     */           }
/* 246 */           this.contSch.setModifyDate(date);
/* 247 */           this.contSch.setModifyTime(time);
/* 248 */           map = new MMap();
/* 249 */           map.put(this.contSch, "UPDATE");
/* 250 */           vd = new VData();
/* 251 */           vd.add(map);
/* 252 */           if (!ps.submitData(vd, "")) {
/* 253 */             this.message = "\u6295\u4FDD\u4E66\u8D44\u6599\u7EF4\u62A4\u5931\u8D25\uFF01";
/* 254 */             this.operateResult = false;
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (RuntimeException e) {
/* 259 */       e.printStackTrace();
/*     */ 
/* 261 */       this.operateResult = false;
/*     */     }
/* 263 */     System.out.println("message : " + this.message);
/*     */   }
/*     */ 
/*     */   private boolean addSgBnf()
/*     */   {
/* 268 */     int sum = getBnfRateSumFun(this.bnfOrder);
/* 269 */     if ((sum != -1) && 
/* 270 */       (sum + this.bnfRate > 100)) {
/* 271 */       this.message = "\u540C\u4E00\u53D7\u76CA\u987A\u5E8F\u53D7\u76CA\u6BD4\u4F8B\u4E4B\u548C\u4E0D\u80FD\u5927\u4E8E100";
/* 272 */       this.operateResult = false;
/* 273 */       return false;
/*     */     }
/*     */ 
/* 276 */     if (this.lnpBnfList == null) {
/* 277 */       this.lnpBnfList = new ArrayList();
/*     */     }
/* 279 */     LNPBnfSchema getReBnf = addBnfOfNewCutomer();
/* 280 */     if (getReBnf != null) {
/* 281 */       LNPBnfBean bean = new LNPBnfBean();
/* 282 */       bean.setSchema(getReBnf);
/* 283 */       this.lnpBnfList.add(bean);
/* 284 */       reSetSgInfo();
/* 285 */       return true;
/*     */     }
/* 287 */     return false;
/*     */   }
/*     */ 
/*     */   private LNPBnfSchema addBnfOfNewCutomer()
/*     */   {
/* 292 */     String date = PubFun.getCurrentDate();
/* 293 */     String time = PubFun.getCurrentTime();
/*     */     try {
/* 295 */       SysMaxNoMAPNP maxNoMap = new SysMaxNoMAPNP();
/* 296 */       this.bnfSgSchema.setContNo(this.contNo);
/* 297 */       if ((this.contSch != null) && (this.contSch.getInsuredId() != null) && (!this.contSch.getInsuredId().equals(""))) {
/* 298 */         this.bnfSgSchema.setInsuredId(this.contSch.getInsuredId());
/*     */       } else {
/* 300 */         this.message = "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03E2\uFFFD\uFFFD\u02A7\uFFFD\uFFFD";
/* 301 */         return null;
/*     */       }
/* 303 */       this.bnfSgSchema.setBenefitType("2");
/*     */ 
/* 305 */       this.bnfSgSchema.setBenefitRate(getBnfRate());
/* 306 */       System.out.println(" -- bnfSgSchema.getBenefitOrder -- " + this.bnfSgSchema.getBenefitOrder());
/* 307 */       this.bnfSgSchema.setBnfId(maxNoMap.CreateMaxNo("CustomerNo", ""));
/* 308 */       this.bnfSgSchema.setRelationToInsured(getConnectionWithInsurance_sg());
/* 309 */       this.bnfSgSchema.setOperator(this.tempGI.Operator);
/* 310 */       this.bnfSgSchema.setManageCom(this.tempGI.ComCode);
/* 311 */       this.bnfSgSchema.setMakeDate(date);
/* 312 */       this.bnfSgSchema.setMakeTime(time);
/* 313 */       this.bnfSgSchema.setModifyDate(date);
/* 314 */       this.bnfSgSchema.setModifyTime(time);
/*     */ 
/* 330 */       StateOperatorDeal operatorDeal = new StateOperatorDeal();
/* 331 */       List stateList = operatorDeal.infoOperate(this.contSch.getState(), this.contSch.getEditstate(), this.infoSource, "06");
/* 332 */       this.contSch.setState((String)stateList.get(0));
/* 333 */       this.contSch.setEditstate((String)stateList.get(1));
/*     */ 
/* 335 */       if ("2".equals(this.contSch.getUWFlag())) {
/* 336 */         this.contSch.setUWFlag("1");
/*     */       }
/*     */ 
/* 339 */       this.contSch.setModifyDate(date);
/* 340 */       this.contSch.setModifyTime(time);
/*     */ 
/* 342 */       PubSubmit ps = new PubSubmit();
/* 343 */       MMap map = new MMap();
/* 344 */       map.put(this.bnfSgSchema, "INSERT");
/*     */ 
/* 346 */       map.put(this.contSch, "UPDATE");
/* 347 */       VData vd = new VData();
/* 348 */       vd.add(map);
/* 349 */       if (!ps.submitData(vd, "")) {
/* 350 */         System.out.println("-BenefitPersonInfo-\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD");
/* 351 */         this.message = "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03E2\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD";
/* 352 */         this.operateResult = false;
/*     */       } else {
/* 354 */         this.message = "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03E2\uFFFD\uFFFD\uFFFD\uFFFD\u0279\uFFFD\uFFFD\uFFFD";
/* 355 */         this.operateResult = true;
/*     */       }
/*     */     } catch (RuntimeException e) {
/* 358 */       this.message = "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03E2\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD";
/* 359 */       this.operateResult = false;
/* 360 */       e.printStackTrace();
/*     */     }
/* 362 */     return this.bnfSgSchema;
/*     */   }
/*     */ 
/*     */   private boolean modifySgBnf()
/*     */   {
/* 369 */     boolean flag = false;
/*     */ 
/* 371 */     String date = PubFun.getCurrentDate();
/* 372 */     String time = PubFun.getCurrentTime();
/* 373 */     LNPBnfSchema modifySch = new LNPBnfSchema();
/* 374 */     modifySch = getBnfSgSchByBnfId(this.contNo, this.operatorBnfId, "2");
/*     */ 
/* 377 */     if (modifySch != null)
/*     */     {
/* 382 */       int sum = getBnfRateSumFun(this.bnfOrder);
/* 383 */       if ((sum != -1) && 
/* 384 */         (sum + this.bnfRate - modifySch.getBenefitRate() > 100.0D)) {
/* 385 */         this.message = "\u036C\u04BB\uFFFD\uFFFD\uFFFD\uFFFD\u02F3\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u05AE\uFFFD\u0372\uFFFD\uFFFD\u0734\uFFFD\uFFFD\uFFFD100";
/* 386 */         this.operateResult = false;
/* 387 */         return false;
/*     */       }
/*     */ 
/* 390 */       modifySch = this.bnfSgSchema;
/* 391 */       StateOperatorDeal operatorDeal = new StateOperatorDeal();
/* 392 */       List stateList = operatorDeal.infoOperate(this.contSch.getState(), this.contSch.getEditstate(), this.infoSource, "06");
/* 393 */       this.contSch.setState((String)stateList.get(0));
/* 394 */       this.contSch.setEditstate((String)stateList.get(1));
/* 395 */       this.contSch.setModifyDate(date);
/* 396 */       this.contSch.setModifyTime(time);
/*     */ 
/* 398 */       PubSubmit ps = new PubSubmit();
/* 399 */       MMap map = new MMap();
/* 400 */       map.put(modifySch, "UPDATE");
/* 401 */       map.put(this.contSch, "UPDATE");
/* 402 */       VData vd = new VData();
/* 403 */       vd.add(map);
/* 404 */       if (!ps.submitData(vd, "")) {
/* 405 */         this.message = "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u02F8\uFFFD\uFFFD\uFFFD\u02A7\uFFFD\u0723\uFFFD";
/*     */       } else {
/* 407 */         this.message = "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u02F8\uFFFD\uFFFD\u00B3\u0279\uFFFD\uFFFD\uFFFD";
/* 408 */         this.modifyFLag = false;
/* 409 */         reSetSgInfo();
/* 410 */         flag = true;
/* 411 */         replaceNodeFromList(modifySch.getBnfId(), modifySch);
/*     */ 
/* 413 */         contOrder();
/*     */       }
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 420 */       this.message = "\uFFFD\uFFFD\u077F\uFFFD\uFFFD\u0432\uFFFD\uFFFD\uFFFD\uFFFD\u06B8\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u02E3\uFFFD";
/*     */     }
/* 422 */     System.out.println("message : " + this.message);
/* 423 */     initData();
/* 424 */     return flag;
/*     */   }
/*     */ 
/*     */   private void contOrder()
/*     */   {
/* 432 */     ExeSQL exeSQL = new ExeSQL();
/* 433 */     String sql = "select distinct cast(benefitorder as int) from lnpbnf where contno='" + this.contNo + "'  order by cast(benefitorder as int)";
/* 434 */     SSRS tSSRS = exeSQL.execSQL(sql);
/* 435 */     if ((tSSRS != null) && (tSSRS.getMaxRow() > 0)) {
/* 436 */       if (tSSRS.getMaxRow() != Integer.parseInt(tSSRS.GetText(tSSRS.MaxRow, 1))) {
/* 437 */         for (int k = 1; k <= tSSRS.getMaxRow() - 1; k++) {
/* 438 */           int cur = Integer.parseInt(tSSRS.GetText(k, 1));
/* 439 */           int aft = Integer.parseInt(tSSRS.GetText(k + 1, 1));
/* 440 */           int sum = getBnfRateSumFun(cur);
/* 441 */           if (sum < 100) {
/* 442 */             this.bnfOrder = cur;
/* 443 */             return;
/*     */           }
/* 445 */           if (cur - aft < -1) {
/* 446 */             this.bnfOrder = (cur + 1);
/* 447 */             return;
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 452 */         int maxOrder = Integer.parseInt(tSSRS.GetText(tSSRS.MaxRow, 1));
/*     */ 
/* 455 */         for (int i = 1; i <= maxOrder; i++) {
/* 456 */           int tempOrder = Integer.parseInt(tSSRS.GetText(i, 1));
/* 457 */           int sum = getBnfRateSumFun(tempOrder);
/*     */ 
/* 459 */           if (sum < 100) {
/* 460 */             this.bnfOrder = tempOrder;
/* 461 */             return;
/* 462 */           }if (sum == 100)
/* 463 */             this.bnfOrder = (tempOrder + 1);
/*     */         }
/*     */       }
/*     */     }
/*     */     else
/* 468 */       this.bnfOrder = 1;
/*     */   }
/*     */ 
/*     */   public int existUnFinishOrder(String contno)
/*     */   {
/* 476 */     int temporder = -1;
/* 477 */     ExeSQL exeSQL = new ExeSQL();
/* 478 */     String sql = "select top 1 cast(benefitorder as int) from (select cast(benefitorder as int),sum(benefitrate) benefitrate from lnpbnf where benefittype='2' and contno='" + 
/* 480 */       contno + "'  group by cast(benefitorder as int)) a where casta.benefitorder as int)<100;";
/* 481 */     SSRS tSSRS = exeSQL.execSQL(sql);
/* 482 */     if (tSSRS.getMaxRow() > 0) {
/* 483 */       temporder = Integer.parseInt(tSSRS.GetText(1, 1));
/*     */     }
/* 485 */     return temporder;
/*     */   }
/*     */ 
/*     */   public int existFinishOrder(String contno) {
/* 489 */     int temporder = -1;
/* 490 */     ExeSQL exeSQL = new ExeSQL();
/* 491 */     String sql = "select max(cast(benefitorder as int))  from (select cast(benefitorder as int),sum(benefitrate) benefitrate from lnpbnf where benefittype='2' and contno='" + 
/* 493 */       contno + "'  group by cast(benefitorder as int)) a where cast(a.benefitorder as int)=100;";
/* 494 */     SSRS tSSRS = exeSQL.execSQL(sql);
/* 495 */     if (tSSRS.getMaxRow() > 0) {
/* 496 */       temporder = Integer.parseInt(tSSRS.GetText(1, 1));
/*     */     }
/* 498 */     return temporder;
/*     */   }
/*     */ 
/*     */   private int getBnfRateSumFun(int order)
/*     */   {
/* 503 */     int rateSum = -1;
/* 504 */     ExeSQL exeSQL = new ExeSQL();
/* 505 */     String sql = "select  case when sum(benefitrate) is null then -1 else sum(benefitrate) end from lnpbnf where benefittype='2' and contno='" + 
/* 506 */       this.contNo + "' and benefitorder ='" + order + "'";
/* 507 */     SSRS tSSRS = exeSQL.execSQL(sql);
/* 508 */     if (tSSRS.MaxRow > 0) {
/* 509 */       rateSum = Integer.parseInt(tSSRS.GetText(1, 1));
/*     */     }
/* 511 */     return rateSum;
/*     */   }
/*     */ 
/*     */   private List<LNPBnfBean> getLnpBnfList(String contNo) {
/* 515 */     List relist = new ArrayList();
/* 516 */     LNPBnfDB db = new LNPBnfDB();
/*     */     try
/*     */     {
/* 522 */       String sqlBnf = "select * from lnpbnf where benefittype='2' and contno = '" + contNo + "' order by cast(benefitorder as int)";
/* 523 */       LNPBnfSet set = db.executeQuery(sqlBnf);
/* 524 */       if ((set != null) && (set.size() > 0))
/* 525 */         for (int i = 1; i <= set.size(); i++) {
/* 526 */           LNPBnfBean tempBean = new LNPBnfBean();
/* 527 */           tempBean.setSchema(set.get(i));
/* 528 */           tempBean.setGender((String)this.genderMap.get(tempBean.getSchema().getBnfSex()));
/* 529 */           tempBean.setIdType((String)this.idTypeMap.get(tempBean.getSchema().getIDType()));
/* 530 */           tempBean.setRelationToInsured((String)this.relationToInsuredMap.get(tempBean.getSchema().getRelationToInsured()));
/* 531 */           tempBean.setBenefitRate(tempBean.getSchema().getBenefitRate() + "%");
/* 532 */           if (this.editFlag)
/* 533 */             tempBean.setListEditFlag("inline-block");
/*     */           else {
/* 535 */             tempBean.setListEditFlag("none");
/*     */           }
/* 537 */           relist.add(tempBean);
/*     */         }
/*     */       else
/* 540 */         relist = null;
/*     */     }
/*     */     catch (RuntimeException e) {
/* 543 */       e.printStackTrace();
/*     */     }
/* 545 */     return relist;
/*     */   }
/*     */ 
/*     */   public boolean checkconnectionWithInsuranceSelf() {
/* 549 */     System.out.println("-- setconnectionWithInsuranceSelf --" + getConnectionWithInsurance_sg());
/*     */     try {
/* 551 */       if (getConnectionWithInsurance_sg() != null)
/* 552 */         if (!getConnectionWithInsurance_sg().equals("0")) {
/* 553 */           PersonFunction pf = new PersonFunction();
/* 554 */           LNPPersonSchema lnpPerson = pf.getLnpPersonByCustomerId(this.contSch.getInsuredId());
/* 555 */           if ((this.sex.equals(lnpPerson.getSex())) && (this.idType.equals(lnpPerson.getIDType())) && 
/* 556 */             (this.bnfSgSchema.getIDNo().equals(lnpPerson.getIDNo())) && (this.bnfSgSchema.getBnfName().equals(lnpPerson.getName())) && 
/* 557 */             (this.bnfSgSchema.getBnfBirthday().equals(lnpPerson.getBirthday()))) {
/* 558 */             this.message = "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u02F2\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03AA\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u02E3\uFFFD";
/* 559 */             return false;
/*     */           }
/*     */         } else {
/* 562 */           this.message = "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u02F2\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03AA\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u02E3\uFFFD";
/* 563 */           return false;
/*     */         }
/*     */     }
/*     */     catch (RuntimeException e) {
/* 567 */       e.printStackTrace();
/* 568 */       this.message = "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u02F2\uFFFD\uFFFD\uFFFD\u03F9\uFFFD\uFFFD\uFFFD";
/* 569 */       return false;
/*     */     }
/* 571 */     return true;
/*     */   }
/*     */ 
/*     */   private void initBnfByCustomerId(String customerId) {
/*     */     try {
/* 576 */       System.out.println(" -- initAppntByInsuredId --");
/* 577 */       PersonFunction pf = new PersonFunction();
/* 578 */       LNPPersonSchema lnpPersonTemp = pf.getLnpPersonByCustomerId(customerId);
/* 579 */       if (lnpPersonTemp != null) {
/* 580 */         this.bnfSgSchema.setBnfId(lnpPersonTemp.getCustomerId());
/* 581 */         this.bnfSgSchema.setBnfName(lnpPersonTemp.getName());
/* 582 */         this.bnfSgSchema.setBnfSex(lnpPersonTemp.getSex());
/* 583 */         this.bnfSgSchema.setBnfBirthday(lnpPersonTemp.getBirthday());
/* 584 */         this.bnfSgSchema.setIDType(lnpPersonTemp.getIDType());
/* 585 */         this.bnfSgSchema.setIDNo(lnpPersonTemp.getIDNo());
/*     */       }
/* 587 */       System.out.println(" -- initAppntByInsuredId end--");
/*     */     } catch (RuntimeException e) {
/* 589 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean checkScBnfExist(String contno)
/*     */   {
/* 595 */     boolean flag = false;
/* 596 */     LNPBnfDB db = new LNPBnfDB();
/* 597 */     db.setContNo(contno);
/* 598 */     db.setBenefitType("1");
/* 599 */     LNPBnfSet set = db.query();
/* 600 */     if (set.size() > 0)
/* 601 */       flag = true;
/*     */     else {
/* 603 */       flag = false;
/*     */     }
/* 605 */     return flag;
/*     */   }
/*     */ 
/*     */   private boolean checkSgBnfExist(LNPBnfSchema bnfSgSchema2)
/*     */   {
/* 611 */     boolean flag = false;
/* 612 */     ExeSQL tExeSQL = new ExeSQL();
/*     */ 
/* 614 */     String sql = "select * from lnpbnf where contno='" + this.contNo + 
/* 615 */       "' " + " and benefittype='2' and bnfname='" + bnfSgSchema2.getBnfName() + "' and bnfsex='" + bnfSgSchema2.getBnfSex() + "' " + 
/* 616 */       " and bnfbirthday='" + bnfSgSchema2.getBnfBirthday() + "' ";
/* 617 */     SSRS tSSRS = tExeSQL.execSQL(sql);
/* 618 */     if (tSSRS.MaxRow > 0) {
/* 619 */       flag = true;
/*     */     }
/* 621 */     return flag;
/*     */   }
/*     */ 
/*     */   private void reSetSgInfo()
/*     */   {
/* 629 */     this.bnfSgSchema = new LNPBnfSchema();
/* 630 */     this.connectionWithInsurance_sg = "-1";
/* 631 */     this.bnfRate = 0;
/* 632 */     this.sex = "-1";
/* 633 */     this.idType = "-1";
/*     */   }
/*     */ 
/*     */   public LNPBnfSchema getBnfSgSchByBnfId(String contno, String bnfId, String bnfType)
/*     */   {
/* 638 */     LNPBnfSchema relnpBnf = new LNPBnfSchema();
/* 639 */     LNPBnfDB db = new LNPBnfDB();
/*     */     try {
/* 641 */       db.setContNo(contno);
/* 642 */       db.setBenefitType(bnfType);
/* 643 */       if (bnfType.equals("2")) {
/* 644 */         db.setBnfId(bnfId);
/*     */       }
/* 646 */       LNPBnfSet set = db.query();
/*     */ 
/* 648 */       if (set.size() > 0)
/* 649 */         relnpBnf = set.get(1);
/*     */       else
/* 651 */         relnpBnf = null;
/*     */     }
/*     */     catch (RuntimeException e) {
/* 654 */       e.printStackTrace();
/* 655 */       relnpBnf = null;
/*     */     }
/* 657 */     return relnpBnf;
/*     */   }
/*     */ 
/*     */   private void removeNodeFromList(String bnfId)
/*     */   {
/* 664 */     for (int i = 0; i < this.lnpBnfList.size(); i++)
/* 665 */       if (((LNPBnfBean)this.lnpBnfList.get(i)).getSchema().getBnfId().equals(bnfId)) {
/* 666 */         this.lnpBnfList.remove(i);
/* 667 */         break;
/*     */       }
/*     */   }
/*     */ 
/*     */   private void replaceNodeFromList(String bnfId, LNPBnfSchema temp)
/*     */   {
/* 675 */     for (int i = 0; i < this.lnpBnfList.size(); i++)
/* 676 */       if (((LNPBnfBean)this.lnpBnfList.get(i)).getSchema().getBnfId().equals(bnfId)) {
/* 677 */         LNPBnfBean bean = new LNPBnfBean();
/* 678 */         bean.setSchema(temp);
/* 679 */         this.lnpBnfList.set(i, bean);
/* 680 */         break;
/*     */       }
/*     */   }
/*     */ 
/*     */   private void initGenderMap()
/*     */   {
/* 688 */     ExeSQL tExeSQL = new ExeSQL();
/* 689 */     String sql = "select code,codename from lnpcode where codetype='sex' order by code";
/* 690 */     SSRS tSRS = tExeSQL.execSQL(sql);
/* 691 */     for (int i = 1; i <= tSRS.MaxRow; i++)
/* 692 */       this.genderMap.put(tSRS.GetText(i, 1), tSRS.GetText(i, 2));
/*     */   }
/*     */ 
/*     */   private void initIdTypeMap()
/*     */   {
/* 697 */     ExeSQL tExeSQL = new ExeSQL();
/* 698 */     String sql = "select code,codename from lnpcode where codetype='insuredidtype' order by code";
/* 699 */     SSRS tSRS = tExeSQL.execSQL(sql);
/* 700 */     for (int i = 1; i <= tSRS.MaxRow; i++)
/* 701 */       this.idTypeMap.put(tSRS.GetText(i, 1), tSRS.GetText(i, 2));
/*     */   }
/*     */ 
/*     */   private void initRelationToInsuredMap()
/*     */   {
/* 706 */     ExeSQL tExeSQL = new ExeSQL();
/* 707 */     String sql = "select code,codename from lnpcode where codetype='bnfrelationtoinsured' order by code";
/* 708 */     SSRS tSRS = tExeSQL.execSQL(sql);
/* 709 */     for (int i = 1; i <= tSRS.MaxRow; i++)
/* 710 */       this.relationToInsuredMap.put(tSRS.GetText(i, 1), tSRS.GetText(i, 2));
/*     */   }
/*     */ 
/*     */   private boolean validate()
/*     */   {
/* 717 */     this.message = "";
/* 718 */     if ((this.bnfSgSchema.getBnfName() == null) || (this.bnfSgSchema.getBnfName().trim().equals(""))) {
/* 719 */       this.message = "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 720 */       return false;
/*     */     }
/* 722 */     if (!ValidateTools.isValidString1(this.bnfSgSchema.getBnfName())) {
/* 723 */       this.message = ("\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD" + ValidateTools.validString1ErrorMessage);
/* 724 */       return false;
/*     */     }
/*     */ 
/* 727 */     if ((this.bnfSgSchema.getBnfSex() == null) || (this.bnfSgSchema.getBnfSex().equals("")) || (this.bnfSgSchema.getBnfSex().equals("-1"))) {
/* 728 */       this.message = "\uFFFD\u0531\uFFFD\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 729 */       return false;
/*     */     }
/* 731 */     if ((this.bnfSgSchema.getBnfBirthday() == null) || (this.bnfSgSchema.getBnfBirthday().trim().equals(""))) {
/* 732 */       this.message = "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u06B2\uFFFD\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 733 */       return false;
/*     */     }
/* 735 */     if (!ValidateTools.isValidString1(this.bnfSgSchema.getBnfBirthday())) {
/* 736 */       return false;
/*     */     }
/*     */ 
/* 739 */     if ((this.bnfSgSchema.getIDType() == null) || (this.bnfSgSchema.getIDType().equals("")) || (this.bnfSgSchema.getIDType().equals("-1"))) {
/* 740 */       this.message = "\u05A4\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0372\uFFFD\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 741 */       return false;
/*     */     }
/* 743 */     if ((this.bnfSgSchema.getIDNo() == null) || (this.bnfSgSchema.getIDNo().trim().equals(""))) {
/* 744 */       this.message = "\u05A4\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uBCBB\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 745 */       return false;
/*     */     }
/*     */ 
/* 749 */     if (this.bnfSgSchema.getIDType().equals("1")) {
/* 750 */       String returnString = ValidateTools.isValidIDNo(this.bnfSgSchema.getIDNo(), this.bnfSgSchema.getBnfBirthday(), 
/* 751 */         this.bnfSgSchema.getBnfSex());
/* 752 */       if (!returnString.equals("")) {
/* 753 */         this.message = returnString;
/* 754 */         return false;
/*     */       }
/*     */     }
/*     */ 
/* 758 */     if ("0".equals(this.bnfSgSchema.getIDPerpetual().trim())) {
/* 759 */       if ((this.bnfSgSchema.getIDValidity() == null) || ("".equals(this.bnfSgSchema.getIDValidity().trim()))) {
/* 760 */         this.message = "\u05A4\uFFFD\uFFFD\uFFFD\uFFFD\u0427\uFFFD\uFFFD\uFFFD\u06B2\uFFFD\uFFFD\uFFFD\u03AA\uFFFD\u0563\uFFFD";
/* 761 */         return false;
/*     */       }
/* 763 */       if (!ValidateTools.isValidString1(this.bnfSgSchema.getIDValidity())) {
/* 764 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 769 */     if ((this.bnfSgSchema.getBenefitRate() < 0.0D) || (this.bnfSgSchema.getBenefitRate() > 100.0D)) {
/* 770 */       this.message = "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0434\uFFFD\uFFFD\u03A7\u03AA1-100";
/* 771 */       return false;
/*     */     }
/* 773 */     return true;
/*     */   }
/*     */ 
/*     */   public void reSetIdPerpetual()
/*     */   {
/* 778 */     this.idPerpetualList = getIdPerpetualListFromDB();
/*     */   }
/*     */ 
/*     */   private List<SelectItem> getIdPerpetualListFromDB()
/*     */   {
/* 783 */     List reList = new ArrayList();
/* 784 */     ExeSQL tExeSQL = new ExeSQL();
/* 785 */     String sql = "select code,codename from lnpcode where codetype='idPerpetualType' order by code";
/* 786 */     SSRS tSRS = tExeSQL.execSQL(sql);
/* 787 */     for (int i = 1; i <= tSRS.MaxRow; i++) {
/* 788 */       reList.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*     */     }
/* 790 */     return reList;
/*     */   }
/*     */ 
/*     */   public void validateConnection()
/*     */   {
/* 798 */     this.showMessageFlag = false;
/*     */ 
/* 800 */     if (!checkConn(this.connectionWithInsurance_sg))
/*     */     {
/* 803 */       this.showMessageFlag = true;
/* 804 */       this.message = "\uFFFD\uFFFD\uFFFD\u1E69\uFFFD\uFFFD\uFFFD\uFFFD\u02F5\uFFFD\uFFFD";
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean isShowMessageFlag() {
/* 808 */     return this.showMessageFlag;
/*     */   }
/*     */ 
/*     */   public void setShowMessageFlag(boolean showMessageFlag) {
/* 812 */     this.showMessageFlag = showMessageFlag;
/*     */   }
/*     */ 
/*     */   private boolean checkConn(String connectionWithInsurance_sg) {
/* 816 */     boolean reflag = false;
/*     */ 
/* 818 */     String sql = "select * from lnpcode where codetype='bnfrelationtoinsured' and othersign='1'and code ='" + 
/* 819 */       connectionWithInsurance_sg + "';";
/*     */ 
/* 821 */     ExeSQL tExeSQL = new ExeSQL();
/* 822 */     SSRS tSSRS = null;
/* 823 */     tSSRS = tExeSQL.execSQL(sql);
/*     */ 
/* 825 */     if ((tSSRS != null) && (tSSRS.MaxRow > 0)) {
/* 826 */       reflag = true;
/*     */     }
/* 828 */     return reflag;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getIdPerpetualList()
/*     */   {
/* 833 */     if (this.idPerpetualList != null) {
/* 834 */       this.idPerpetualList.clear();
/*     */     }
/* 836 */     this.idPerpetualList = getIdPerpetualListFromDB();
/* 837 */     return this.idPerpetualList;
/*     */   }
/*     */ 
/*     */   public void setIdPerpetualList(List<SelectItem> idPerpetualList)
/*     */   {
/* 842 */     this.idPerpetualList = idPerpetualList;
/*     */   }
/*     */ 
/*     */   public LNPBnfSchema getBnfSgSchema() {
/* 846 */     return this.bnfSgSchema;
/*     */   }
/*     */ 
/*     */   public void setBnfSgSchema(LNPBnfSchema bnfSgSchema) {
/* 850 */     this.bnfSgSchema = bnfSgSchema;
/*     */   }
/*     */ 
/*     */   public String getConnectionWithInsurance_sc() {
/* 854 */     return this.connectionWithInsurance_sc;
/*     */   }
/*     */ 
/*     */   public void setConnectionWithInsurance_sc(String connectionWithInsurance_sc)
/*     */   {
/* 860 */     this.connectionWithInsurance_sc = connectionWithInsurance_sc;
/*     */   }
/*     */ 
/*     */   public String getConnectionWithInsurance_sg() {
/* 864 */     return this.connectionWithInsurance_sg;
/*     */   }
/*     */ 
/*     */   public void setConnectionWithInsurance_sg(String connectionWithInsurance_sg) {
/* 868 */     this.connectionWithInsurance_sg = connectionWithInsurance_sg;
/*     */   }
/*     */   public String getIdType() {
/* 871 */     return this.idType;
/*     */   }
/*     */ 
/*     */   public void setIdType(String idType) {
/* 875 */     this.idType = idType;
/*     */   }
/*     */ 
/*     */   public String getMessage() {
/* 879 */     return this.message;
/*     */   }
/*     */ 
/*     */   public void setMessage(String message) {
/* 883 */     this.message = message;
/*     */   }
/*     */ 
/*     */   public String getSex() {
/* 887 */     return this.sex;
/*     */   }
/*     */ 
/*     */   public void setSex(String sex) {
/* 891 */     this.sex = sex;
/*     */   }
/*     */ 
/*     */   public List<LNPBnfBean> getLnpBnfList()
/*     */   {
/* 896 */     return this.lnpBnfList;
/*     */   }
/*     */ 
/*     */   public void setLnpBnfList(List<LNPBnfBean> lnpBnfList)
/*     */   {
/* 901 */     this.lnpBnfList = lnpBnfList;
/*     */   }
/*     */ 
/*     */   public boolean isOperateResult()
/*     */   {
/* 906 */     return this.operateResult;
/*     */   }
/*     */ 
/*     */   public void setOperateResult(boolean operateResult) {
/* 910 */     this.operateResult = operateResult;
/*     */   }
/*     */ 
/*     */   public int getBnfRate() {
/* 914 */     return this.bnfRate;
/*     */   }
/*     */ 
/*     */   public void setBnfRate(int bnfRate) {
/* 918 */     this.bnfRate = bnfRate;
/*     */   }
/*     */ 
/*     */   public String getOperatorBnfId() {
/* 922 */     return this.operatorBnfId;
/*     */   }
/*     */ 
/*     */   public void setOperatorBnfId(String c) {
/* 926 */     System.out.println("-- operatorBnfId -- " + this.operatorBnfId);
/* 927 */     this.operatorBnfId = this.operatorBnfId;
/*     */   }
/*     */ 
/*     */   public int getBnfOrder() {
/* 931 */     return this.bnfOrder;
/*     */   }
/*     */ 
/*     */   public void setBnfOrder(int bnfOrder) {
/* 935 */     this.bnfOrder = bnfOrder;
/*     */   }
/*     */   public boolean isEditFlag() {
/* 938 */     return this.editFlag;
/*     */   }
/*     */   public void setEditFlag(boolean editFlag) {
/* 941 */     this.editFlag = editFlag;
/*     */   }
/*     */   public boolean isScEditFlag() {
/* 944 */     return this.scEditFlag;
/*     */   }
/*     */   public void setScEditFlag(boolean scEditFlag) {
/* 947 */     this.scEditFlag = scEditFlag;
/*     */   }
/*     */ 
/*     */   public String getIdPerpetual()
/*     */   {
/* 952 */     return this.idPerpetual;
/*     */   }
/*     */ 
/*     */   public void setIdPerpetual(String idPerpetual)
/*     */   {
/* 957 */     this.idPerpetual = idPerpetual;
/*     */   }
/*     */ 
/*     */   public String getBnfremoveid()
/*     */   {
/* 962 */     return this.bnfremoveid;
/*     */   }
/*     */ 
/*     */   public void setBnfremoveid(String bnfremoveid)
/*     */   {
/* 967 */     this.bnfremoveid = bnfremoveid;
/*     */   }
/*     */ 
/*     */   public String getContNo()
/*     */   {
/* 972 */     return this.contNo;
/*     */   }
/*     */ 
/*     */   public void setContNo(String contNo)
/*     */   {
/* 977 */     this.contNo = contNo;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.BenefitPersonInfo
 * JD-Core Version:    0.6.0
 */