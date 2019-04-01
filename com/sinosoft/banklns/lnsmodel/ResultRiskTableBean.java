/*     */ package com.sinosoft.banklns.lnsmodel;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPPolDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPUWQuestionDB;
/*     */ import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
/*     */ import com.sinosoft.banklns.lis.pubfun.MMap;
/*     */ import com.sinosoft.banklns.lis.pubfun.PubFun;
/*     */ import com.sinosoft.banklns.lis.pubfun.PubSubmit;
/*     */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPInsuredSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPPolSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPRiskSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPPolSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPUWQuestionSet;
/*     */ import com.sinosoft.banklns.utility.CodeQueryImpl;
/*     */ import com.sinosoft.banklns.utility.ExeSQL;
/*     */ import com.sinosoft.banklns.utility.SSRS;
/*     */ import com.sinosoft.banklns.utility.VData;
/*     */ import java.io.PrintStream;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.faces.context.ExternalContext;
/*     */ import javax.faces.context.FacesContext;
/*     */ import javax.servlet.http.HttpSession;
/*     */ 
/*     */ public class ResultRiskTableBean
/*     */ {
/*     */   private List List;
/*  30 */   private String id = "";
/*  31 */   private String idcon = "";
/*  32 */   private String result = "";
/*     */ 
/*     */   public String getResult() {
/*  35 */     return this.result;
/*     */   }
/*     */ 
/*     */   public void setResult(String result) {
/*  39 */     this.result = result;
/*     */   }
/*     */ 
/*     */   public List getList()
/*     */   {
/*  46 */     String ContNo = getIdcon();
/*  47 */     String InsuredNo = getId();
/*     */ 
/*  49 */     List resultList = getRiskPolForOneInsure(ContNo, InsuredNo);
/*  50 */     HttpSession session = (HttpSession)
/*  51 */       FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*  52 */     Boolean getEditFlag = (Boolean)session.getAttribute("editFlag");
/*  53 */     String editflag = "";
/*  54 */     if (getEditFlag != null) {
/*  55 */       if (getEditFlag.booleanValue())
/*  56 */         editflag = "inline-block";
/*     */       else {
/*  58 */         editflag = "none";
/*     */       }
/*     */     }
/*     */ 
/*  62 */     this.List = new ArrayList();
/*  63 */     if ((resultList != null) && (resultList.size() > 0) && (getEditFlag != null))
/*     */     {
/*  68 */       for (int i = 0; i < resultList.size(); i++) {
/*  69 */         String[] temp = (String[])resultList.get(i);
/*     */ 
/*  71 */         this.List.add(
/*  72 */           new RiskTableBean(temp[1], temp[2], temp[3], temp[4], 
/*  72 */           temp[5], temp[6], temp[7], temp[0], editflag));
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  83 */     return this.List;
/*     */   }
/*     */ 
/*     */   public String ModifyRisk()
/*     */   {
/*  88 */     HttpSession session = (HttpSession)FacesContext.getCurrentInstance()
/*  89 */       .getExternalContext().getSession(true);
/*  90 */     IGlobalInput tempGI = (IGlobalInput)session.getValue("NPGI");
/*  91 */     Map requestMap = FacesContext.getCurrentInstance().getExternalContext()
/*  92 */       .getRequestParameterMap();
/*  93 */     String currentpol = (String)requestMap.get("ModifyRiskpolno");
/*     */ 
/*  95 */     RiskPolImpl instanceRiskPolImpl = new RiskPolImpl();
/*     */ 
/*  98 */     String polno = instanceRiskPolImpl.transportPolNo(currentpol, tempGI);
/*  99 */     LNPPolSchema teLNPPolSchema = instanceRiskPolImpl.getPolInfo(polno);
/* 100 */     RiskImpl instanceRiskImpl = new RiskImpl();
/* 101 */     String riskElementUrl = instanceRiskImpl.getURLForRisk(teLNPPolSchema
/* 102 */       .getRiskCode(), "S");
/* 103 */     String riskRulesUrl = instanceRiskImpl.getURLForRisk(teLNPPolSchema
/* 104 */       .getRiskCode(), "3");
/* 105 */     if (riskElementUrl == null) {
/* 106 */       riskElementUrl = "";
/*     */     }
/* 108 */     if (riskRulesUrl == null) {
/* 109 */       riskRulesUrl = "";
/*     */     }
/*     */ 
/* 112 */     this.result = 
/* 114 */       (riskElementUrl + "&" + riskRulesUrl + "&" + polno + "&" + 
/* 113 */       teLNPPolSchema.getRiskCode() + "&" + 
/* 114 */       teLNPPolSchema.getMasterPolNo());
/* 115 */     return this.result;
/*     */   }
/*     */ 
/*     */   public void deleteRisk() {
/* 119 */     HttpSession session = (HttpSession)FacesContext.getCurrentInstance()
/* 120 */       .getExternalContext().getSession(true);
/* 121 */     Map requestMap = FacesContext.getCurrentInstance().getExternalContext()
/* 122 */       .getRequestParameterMap();
/* 123 */     String polno = (String)requestMap.get("deleteRiskpolno");
/* 124 */     IGlobalInput tempGI = (IGlobalInput)session.getValue("NPGI");
/* 125 */     String[] polsetarray = polno.split("~");
/* 126 */     RiskPolImpl instanceRiskPolImpl = new RiskPolImpl();
/*     */     try {
/* 128 */       ExeSQL reExeSQL = new ExeSQL();
/* 129 */       SSRS tSSRS = new SSRS();
/* 130 */       String sql = "select contno from lnppol where polno = '" + polno + "'";
/* 131 */       tSSRS = reExeSQL.execSQL(sql);
/*     */ 
/* 133 */       instanceRiskPolImpl.deletRisk(polsetarray, tempGI);
/*     */ 
/* 138 */       if ((polno != null) && (!polno.equals("")))
/*     */       {
/* 140 */         if (tSSRS != null)
/*     */         {
/* 142 */           String contno = tSSRS.GetText(1, 1);
/* 143 */           if ((contno != null) && (!contno.equals("")))
/*     */           {
/* 145 */             sql = "update lnppol set standprem=0,prem=0,sumprem=0 where contno ='" + contno + "'";
/* 146 */             reExeSQL.execUpdateSQL(sql);
/*     */           }
/*     */ 
/* 150 */           sql = "select count(1) from lnppol where contno = '" + contno + "';";
/* 151 */           tSSRS = reExeSQL.execSQL(sql);
/* 152 */           if ((tSSRS != null) && ("0".equals(tSSRS.GetText(1, 1))))
/*     */           {
/* 154 */             PolicyMainInfo tPolicyMainInfo = new PolicyMainInfo();
/* 155 */             LNPContSchema contSch = tPolicyMainInfo.getContByContNo(contno);
/* 156 */             StateOperatorDeal operatorDeal = new StateOperatorDeal();
/* 157 */             List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "delete", "04");
/*     */ 
/* 159 */             contSch.setState((String)stateList.get(0));
/* 160 */             contSch.setEditstate((String)stateList.get(1));
/*     */ 
/* 164 */             if ("2".equals(contSch.getUWFlag())) {
/* 165 */               contSch.setUWFlag("1");
/*     */             }
/* 167 */             String date = PubFun.getCurrentDate();
/* 168 */             String time = PubFun.getCurrentTime();
/* 169 */             contSch.setModifyDate(date);
/* 170 */             contSch.setModifyTime(time);
/*     */ 
/* 172 */             contSch.setPrem(0.0D);
/* 173 */             contSch.setSumPrem(0.0D);
/*     */ 
/* 176 */             PubSubmit ps = new PubSubmit();
/* 177 */             MMap map = new MMap();
/* 178 */             map.put(contSch, "UPDATE");
/* 179 */             VData vd = new VData();
/* 180 */             vd.add(map);
/* 181 */             if (ps.submitData(vd, ""))
/*     */             {
/* 184 */               afterupdateRisk(contno);
/*     */             }
/*     */           }
/*     */           else
/*     */           {
/* 189 */             PolicyMainInfo tPolicyMainInfo = new PolicyMainInfo();
/* 190 */             LNPContSchema contSch = tPolicyMainInfo.getContByContNo(contno);
/* 191 */             StateOperatorDeal operatorDeal = new StateOperatorDeal();
/* 192 */             List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "modify", "04");
/*     */ 
/* 194 */             contSch.setState((String)stateList.get(0));
/* 195 */             contSch.setEditstate((String)stateList.get(1));
/*     */ 
/* 197 */             if ("2".equals(contSch.getUWFlag())) {
/* 198 */               contSch.setUWFlag("1");
/*     */             }
/*     */ 
/* 201 */             String date = PubFun.getCurrentDate();
/* 202 */             String time = PubFun.getCurrentTime();
/* 203 */             contSch.setModifyDate(date);
/* 204 */             contSch.setModifyTime(time);
/*     */ 
/* 206 */             contSch.setPrem(0.0D);
/* 207 */             contSch.setSumPrem(0.0D);
/*     */ 
/* 209 */             PubSubmit ps = new PubSubmit();
/* 210 */             MMap map = new MMap();
/* 211 */             map.put(contSch, "UPDATE");
/* 212 */             VData vd = new VData();
/* 213 */             vd.add(map);
/* 214 */             if (ps.submitData(vd, ""))
/*     */             {
/* 217 */               afterupdateRisk(contno);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 226 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getId()
/*     */   {
/* 235 */     FacesContext fc = FacesContext.getCurrentInstance();
/* 236 */     this.id = ((String)fc.getExternalContext().getRequestParameterMap().get(
/* 237 */       "InsuredNo"));
/*     */ 
/* 239 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(String id) {
/* 243 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getIdcon() {
/* 247 */     FacesContext fc = FacesContext.getCurrentInstance();
/* 248 */     this.idcon = ((String)fc.getExternalContext().getRequestParameterMap().get(
/* 249 */       "ContNo"));
/* 250 */     return this.idcon;
/*     */   }
/*     */ 
/*     */   public void setIdcon(String idcon) {
/* 254 */     this.idcon = idcon;
/*     */   }
/*     */ 
/*     */   public List getRiskPolForOneInsure(String contNo, String insuredId)
/*     */   {
/* 259 */     RiskPolImpl riskPolImpl = new RiskPolImpl();
/* 260 */     RiskImpl riskImpl = new RiskImpl();
/*     */ 
/* 262 */     DecimalFormat formatMoneyInt = new DecimalFormat("#,###");
/*     */ 
/* 264 */     DecimalFormat formatMoney = new DecimalFormat("#,##0.00");
/*     */ 
/* 266 */     CodeQueryImpl codeQueryImpl = new CodeQueryImpl();
/*     */ 
/* 270 */     LNPInsuredSchema reLNPInsuredSchema = new LNPInsuredSchema();
/* 271 */     InsuredPersonInfo tInsuredPersonInfo = new InsuredPersonInfo();
/* 272 */     reLNPInsuredSchema = tInsuredPersonInfo.getOneInsuredPersonInfo(contNo, 
/* 273 */       insuredId);
/*     */ 
/* 275 */     String sql = "select * from lnppol where polno=masterpolno and contNo='" + 
/* 276 */       contNo + "' and insuredid='" + insuredId + "'  order by MakeDate , MakeTime ASC";
/* 277 */     LNPPolDB reLNPPolDB = new LNPPolDB();
/* 278 */     LNPPolSet teLNPPolSet = reLNPPolDB.executeQuery(sql);
/* 279 */     List list = new ArrayList();
/* 280 */     if ((teLNPPolSet != null) && (teLNPPolSet.size() > 0)) {
/* 281 */       for (int i = 1; i <= teLNPPolSet.size(); i++)
/*     */       {
/* 283 */         LNPPolSchema tempLNPPolSchema = teLNPPolSet.get(i);
/* 284 */         List listGroup = riskPolImpl.getPolList(tempLNPPolSchema
/* 285 */           .getPolNo(), i);
/* 286 */         List noList = (List)listGroup.get(0);
/* 287 */         List polList = (List)listGroup.get(1);
/*     */ 
/* 289 */         for (int j = 0; j < polList.size(); j++) {
/* 290 */           String[] polinfo = new String[8];
/*     */ 
/* 293 */           String serialNo = noList.get(j).toString();
/* 294 */           tempLNPPolSchema = (LNPPolSchema)polList.get(j);
/*     */ 
/* 296 */           polinfo[0] = tempLNPPolSchema.getPolNo();
/*     */ 
/* 299 */           LNPRiskSchema tempLNPRiskSchema = riskImpl
/* 300 */             .getRiskInfo(tempLNPPolSchema.getRiskCode());
/* 301 */           if (tempLNPRiskSchema != null) {
/* 302 */             polinfo[1] = ("\uFFFD\uFFFD" + tempLNPRiskSchema.getRiskCode() + "\uFFFD\uFFFD" + tempLNPRiskSchema.getRiskShortName());
/*     */ 
/* 304 */             if ("CIR(B)".equalsIgnoreCase(tempLNPRiskSchema.getRiskCode()))
/*     */             {
/* 306 */               polinfo[1] = ("\uFFFD\uFFFDCIR10" + tempLNPPolSchema.getStandbyFlag3() + "\uFFFD\uFFFD" + tempLNPRiskSchema.getRiskShortName());
/*     */             }
/*     */           } else {
/* 309 */             polinfo[1] = "";
/*     */           }
/*     */ 
/* 312 */           double amnt = tempLNPPolSchema.getAmnt();
/* 313 */           double mult = tempLNPPolSchema.getMult();
/* 314 */           if (mult > 0.0D) {
/* 315 */             polinfo[2] = (getFormatString(mult) + "\uFFFD\uFFFD");
/*     */           } else {
/* 317 */             String amntStr = formatMoneyInt.format(Math.floor(amnt)) + "\u052A";
/* 318 */             polinfo[2] = amntStr;
/*     */           }
/*     */ 
/* 321 */           int payintv = tempLNPPolSchema.getPayIntv();
/* 322 */           polinfo[3] = codeQueryImpl.getTextByCodeAndType("PayIntV", 
/* 323 */             payintv);
/*     */ 
/* 325 */           int insuyear = tempLNPPolSchema.getInsuYear();
/* 326 */           String insuYearFlag = tempLNPPolSchema.getInsuYearFlag();
/* 327 */           String insuStr = "";
/* 328 */           if (insuyear > 104)
/* 329 */             insuStr = "\uFFFD\uFFFD\uFFFD\uFFFD";
/* 330 */           else if (("A".equals(insuYearFlag)) && (insuyear <= 104))
/* 331 */             insuStr = "\uFFFD\uFFFD" + insuyear + "\uFFFD\uFFFD\uFFFD\uFFFD";
/*     */           else {
/* 333 */             insuStr = insuyear + "\uFFFD\uFFFD";
/*     */           }
/* 335 */           polinfo[4] = insuStr;
/*     */ 
/* 338 */           String PayEndYearStr = "";
/* 339 */           int PayEndYear = tempLNPPolSchema.getPayEndYear();
/* 340 */           String PayEndYearFlag = tempLNPPolSchema.getPayEndYearFlag();
/* 341 */           if ("A".equals(PayEndYearFlag)) {
/* 342 */             PayEndYearStr = "\uFFFD\uFFFD" + PayEndYear + "\uFFFD\uFFFD\uFFFD\uFFFD";
/*     */           }
/* 344 */           else if (PayEndYear == 1000) {
/* 345 */             PayEndYear = 1;
/* 346 */             PayEndYearStr = PayEndYear + "\uFFFD\uFFFD";
/*     */           } else {
/* 348 */             PayEndYearStr = PayEndYear + "\uFFFD\uFFFD";
/*     */           }
/*     */ 
/* 351 */           polinfo[5] = PayEndYearStr;
/*     */ 
/* 354 */           double prem = tempLNPPolSchema.getSumPrem();
/* 355 */           polinfo[6] = (formatMoney.format(prem) + "\u052A");
/*     */ 
/* 357 */           polinfo[7] = serialNo;
/* 358 */           list.add(polinfo);
/*     */         }
/*     */       }
/*     */     }
/* 362 */     return list;
/*     */   }
/*     */ 
/*     */   private boolean afterupdateRisk(String contno)
/*     */   {
/* 368 */     System.out.println("-----\uFFFD\u0431?\uFFFD\uFFFD \u027E\uFFFD\uFFFD\uFFFD\uFFFD\u07B8\uFFFD\uFFFD\uFFFD\uFFFD\u05B9\uFFFD\uFFFD \u027E\uFFFD\uFFFD\u02F1\uFFFD\uFFFD\uFFFD\uFFFD\u06F6\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD ----");
/* 369 */     boolean flag = false;
/*     */     try {
/* 371 */       PubSubmit ps = new PubSubmit();
/* 372 */       MMap mmap = new MMap();
/*     */ 
/* 374 */       LNPUWQuestionDB queDB = new LNPUWQuestionDB();
/*     */ 
/* 376 */       String sql = "select * from LNPUWQuestion where contno='" + contno + "'";
/* 377 */       LNPUWQuestionSet queSet = queDB.executeQuery(sql);
/* 378 */       if ((queSet != null) && (queSet.size() > 0)) {
/* 379 */         mmap.put(queSet, "DELETE");
/*     */       }
/* 381 */       PolicyMainInfo mainInfo = new PolicyMainInfo();
/* 382 */       LNPContSchema tLNPContSchema = mainInfo.getContByContNo(contno);
/* 383 */       if ("2".equals(tLNPContSchema.getUWFlag())) {
/* 384 */         tLNPContSchema.setUWFlag("1");
/*     */       }
/*     */ 
/* 388 */       tLNPContSchema.setApproveFlag("0");
/* 389 */       mmap.put(tLNPContSchema, "UPDATE");
/*     */ 
/* 391 */       VData vd = new VData();
/* 392 */       vd.add(mmap);
/*     */ 
/* 394 */       if (!ps.submitData(vd, ""))
/* 395 */         flag = false;
/*     */       else
/* 397 */         flag = true;
/*     */     }
/*     */     catch (RuntimeException e)
/*     */     {
/* 401 */       e.printStackTrace();
/*     */     }
/*     */ 
/* 404 */     return flag;
/*     */   }
/*     */ 
/*     */   private String getFormatString(double inputStr)
/*     */   {
/* 410 */     DecimalFormat myformat = new DecimalFormat("#0.00");
/*     */ 
/* 413 */     DecimalFormat myformatcheck = new DecimalFormat("#0");
/*     */ 
/* 416 */     String reuslt = "";
/* 417 */     if ((int)inputStr != inputStr)
/* 418 */       reuslt = myformat.format(inputStr);
/*     */     else {
/* 420 */       reuslt = myformatcheck.format(inputStr);
/*     */     }
/* 422 */     return reuslt;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.ResultRiskTableBean
 * JD-Core Version:    0.6.0
 */