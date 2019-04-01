/*     */ package com.sinosoft.banklns.lnsmodel;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPFAndIImpResultDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPInsureHistoryDB;
/*     */ import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
/*     */ import com.sinosoft.banklns.lis.pubfun.MMap;
/*     */ import com.sinosoft.banklns.lis.pubfun.PubFun;
/*     */ import com.sinosoft.banklns.lis.pubfun.PubSubmit;
/*     */ import com.sinosoft.banklns.lis.pubfun.ValidateTools;
/*     */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPInsureHistorySchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPFAndIImpResultSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPInsureHistorySet;
/*     */ import com.sinosoft.banklns.lnsmodel.entity.LNPFinanceAndInsureBean;
/*     */ import com.sinosoft.banklns.utility.ExeSQL;
/*     */ import com.sinosoft.banklns.utility.SSRS;
/*     */ import com.sinosoft.banklns.utility.VData;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.faces.context.ExternalContext;
/*     */ import javax.faces.context.FacesContext;
/*     */ import javax.servlet.http.HttpSession;
/*     */ 
/*     */ public class FinanceAndInsure
/*     */ {
/*  33 */   private LNPInsureHistorySchema lnpInsureHistorySchema = new LNPInsureHistorySchema();
/*     */ 
/*  35 */   private LNPFinanceAndInsureBean lnpInsureHistoryBean = new LNPFinanceAndInsureBean();
/*     */ 
/*  37 */   private List<LNPFinanceAndInsureBean> insureHistoryList = null;
/*     */ 
/*  39 */   private boolean modifyTag = false;
/*     */ 
/*  41 */   private boolean operateResult = true;
/*     */ 
/*  43 */   private String message = "";
/*     */ 
/*  45 */   private String contNo = "";
/*     */ 
/*  47 */   private boolean pageEditTag = true;
/*     */ 
/*  49 */   private boolean editFlag = true;
/*     */ 
/*  51 */   private boolean showMesFlag = false;
/*     */ 
/*  53 */   Map<String, String> stateMap = new HashMap();
/*     */ 
/*     */   public void initData()
/*     */   {
/*     */     try
/*     */     {
/*  59 */       initStateMap();
/*  60 */       HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*  61 */       Boolean getEditFlag = (Boolean)session.getAttribute("editFlag");
/*  62 */       if (getEditFlag != null) {
/*  63 */         if (getEditFlag.booleanValue())
/*  64 */           this.editFlag = true;
/*     */         else {
/*  66 */           this.editFlag = false;
/*     */         }
/*     */       }
/*  69 */       this.contNo = ((String)session.getAttribute("ContNo"));
/*  70 */       if (this.insureHistoryList != null) {
/*  71 */         this.insureHistoryList.clear();
/*     */       }
/*  73 */       if (this.contNo != null) {
/*  74 */         getLnpInsureHistorySchemaList(this.contNo);
/*  75 */         setpageEditTagWithSet();
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/*  79 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void saveFinanceAndInsure()
/*     */   {
/*  86 */     if ((validate()) && (this.contNo != null) && (!"".equals(this.contNo)))
/*     */     {
/*  89 */       if (!this.modifyTag)
/*     */       {
/*  92 */         LNPInsureHistorySchema tempSchema = getContByNo(this.contNo);
/*  93 */         if (tempSchema != null)
/*     */         {
/*  95 */           Integer polOrderNum = new Integer(tempSchema.getPolOrder());
/*  96 */           polOrderNum = Integer.valueOf(polOrderNum.intValue() + 1);
/*  97 */           tempSchema.setPolOrder(polOrderNum.toString());
/*  98 */           this.lnpInsureHistorySchema.setPolOrder(tempSchema.getPolOrder());
/*     */         } else {
/* 100 */           this.lnpInsureHistorySchema.setPolOrder("1");
/*     */         }
/* 102 */         PolicyMainInfo mainInfo = new PolicyMainInfo();
/* 103 */         LNPContSchema contSch = mainInfo.getContByContNo(this.contNo);
/* 104 */         this.lnpInsureHistorySchema.setSumInsuredDeath(new Double(this.lnpInsureHistoryBean.getSumInsuredDeath()).doubleValue() * 10000.0D);
/* 105 */         this.lnpInsureHistorySchema.setSumInsuredDisease(new Double(this.lnpInsureHistoryBean.getSumInsuredDisease()).doubleValue() * 10000.0D);
/* 106 */         this.lnpInsureHistorySchema.setGrpContNo(contSch.getGrpContNo());
/* 107 */         this.lnpInsureHistorySchema.setContNo(this.contNo);
/* 108 */         this.lnpInsureHistorySchema.setProposalContNo(this.contNo);
/* 109 */         this.lnpInsureHistorySchema.setPrtNo(contSch.getPrtNo());
/* 110 */         this.lnpInsureHistorySchema.setComName(this.lnpInsureHistorySchema.getComName());
/* 111 */         this.lnpInsureHistorySchema.setSumInsuredDeath(this.lnpInsureHistorySchema.getSumInsuredDeath());
/* 112 */         this.lnpInsureHistorySchema.setSumInsuredDisease(this.lnpInsureHistorySchema.getSumInsuredDisease());
/* 113 */         this.lnpInsureHistorySchema.setPolicyState(this.lnpInsureHistorySchema.getPolicyState());
/* 114 */         HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/* 115 */         IGlobalInput tempGI = (IGlobalInput)session.getAttribute("NPGI");
/* 116 */         if (tempGI == null) {
/* 117 */           this.message = "\uFFFD\uFFFD\uFFFD\uD9B3\uDC31\uFFFD\uFFFD\u057E\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD";
/* 118 */           this.operateResult = false;
/*     */         }
/* 120 */         this.lnpInsureHistorySchema.setOperator(tempGI.Operator);
/* 121 */         String date = PubFun.getCurrentDate();
/* 122 */         String time = PubFun.getCurrentTime();
/* 123 */         this.lnpInsureHistorySchema.setMakeDate(date);
/* 124 */         this.lnpInsureHistorySchema.setMakeTime(time);
/* 125 */         this.lnpInsureHistorySchema.setModifyDate(date);
/* 126 */         this.lnpInsureHistorySchema.setModifyTime(time);
/*     */         try
/*     */         {
/* 129 */           PubSubmit ps = new PubSubmit();
/* 130 */           MMap map = new MMap();
/* 131 */           StateOperatorDeal operatorDeal = new StateOperatorDeal();
/* 132 */           List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "add", "07");
/* 133 */           contSch.setState((String)stateList.get(0));
/* 134 */           contSch.setEditstate((String)stateList.get(1));
/*     */ 
/* 137 */           if ("2".equals(contSch.getUWFlag())) {
/* 138 */             contSch.setUWFlag("1");
/*     */           }
/* 140 */           map.put(contSch, "UPDATE");
/* 141 */           map.put(this.lnpInsureHistorySchema, "INSERT");
/* 142 */           VData vd = new VData();
/* 143 */           vd.add(map);
/* 144 */           if (!ps.submitData(vd, "")) {
/* 145 */             this.message = "\uFFFD\uFFFD\uFFFD\uD9B3\uDC31\uFFFD\uFFFD\u057E\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD";
/* 146 */             this.operateResult = false;
/* 147 */             this.showMesFlag = true;
/*     */           } else {
/* 149 */             this.message = "\uFFFD\uFFFD\uFFFD\uD9B3\uDC31\uFFFD\uFFFD\u057E\uFFFD\uFFFD\uFFFD\uFFFD\u0279\uFFFD";
/* 150 */             this.operateResult = true;
/* 151 */             this.showMesFlag = false;
/* 152 */             getLnpInsureHistorySchemaList(this.lnpInsureHistorySchema.getContNo());
/*     */           }
/* 154 */           setpageEditTagWithSet();
/*     */         } catch (Exception e) {
/* 156 */           e.printStackTrace();
/*     */         }
/*     */       } else {
/* 159 */         PolicyMainInfo mainInfo = new PolicyMainInfo();
/* 160 */         LNPContSchema contSch = mainInfo.getContByContNo(this.contNo);
/*     */ 
/* 165 */         this.lnpInsureHistorySchema.setComName(this.lnpInsureHistorySchema.getComName());
/* 166 */         this.lnpInsureHistorySchema.setSumInsuredDeath(new Double(this.lnpInsureHistoryBean.getSumInsuredDeath()).doubleValue() * 10000.0D);
/* 167 */         this.lnpInsureHistorySchema.setSumInsuredDisease(new Double(this.lnpInsureHistoryBean.getSumInsuredDisease()).doubleValue() * 10000.0D);
/* 168 */         this.lnpInsureHistorySchema.setPolicyState(this.lnpInsureHistorySchema.getPolicyState());
/*     */         try
/*     */         {
/* 171 */           PubSubmit ps = new PubSubmit();
/* 172 */           MMap map = new MMap();
/* 173 */           StateOperatorDeal operatorDeal = new StateOperatorDeal();
/* 174 */           List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "modify", "07");
/* 175 */           contSch.setState((String)stateList.get(0));
/* 176 */           contSch.setEditstate((String)stateList.get(1));
/*     */ 
/* 179 */           if ("2".equals(contSch.getUWFlag())) {
/* 180 */             contSch.setUWFlag("1");
/*     */           }
/* 182 */           map.put(contSch, "UPDATE");
/* 183 */           map.put(this.lnpInsureHistorySchema, "UPDATE");
/* 184 */           VData vd = new VData();
/* 185 */           vd.add(map);
/* 186 */           if (!ps.submitData(vd, "")) {
/* 187 */             this.message = "\uFFFD\uFFFD\uFFFD\uD9B3\uDC31\uFFFD\uFFFD\u057E\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u00B4\uFFFD\uFFFD\uFFFD";
/* 188 */             this.operateResult = false;
/* 189 */             this.showMesFlag = true;
/*     */           } else {
/* 191 */             this.message = "\uFFFD\uFFFD\uFFFD\uD9B3\uDC31\uFFFD\uFFFD\u057E\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u00B3\u0279\uFFFD";
/* 192 */             this.operateResult = true;
/* 193 */             this.showMesFlag = true;
/*     */ 
/* 195 */             getLnpInsureHistorySchemaList(this.lnpInsureHistorySchema.getContNo());
/*     */           }
/* 197 */           setpageEditTagWithSet();
/*     */         } catch (Exception e) {
/* 199 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 202 */       this.lnpInsureHistorySchema = new LNPInsureHistorySchema();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void modifyFinanceAndInsure()
/*     */   {
/*     */     try
/*     */     {
/* 212 */       Map resultMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
/* 213 */       String polOrder = (String)resultMap.get("polOrder");
/* 214 */       this.lnpInsureHistorySchema = getContByPolOrder(polOrder);
/*     */ 
/* 217 */       this.lnpInsureHistoryBean.setSumInsuredDeath(getFormatString(this.lnpInsureHistorySchema.getSumInsuredDeath() / 10000.0D));
/* 218 */       this.lnpInsureHistoryBean.setSumInsuredDisease(getFormatString(this.lnpInsureHistorySchema.getSumInsuredDisease() / 10000.0D));
/* 219 */       this.modifyTag = true;
/* 220 */       this.pageEditTag = true;
/*     */     } catch (Exception e) {
/* 222 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void removeFinanceAndInsure()
/*     */   {
/*     */     try
/*     */     {
/* 230 */       PubSubmit ps = new PubSubmit();
/* 231 */       MMap map = new MMap();
/* 232 */       PolicyMainInfo mainInfo = new PolicyMainInfo();
/* 233 */       LNPContSchema contSch = mainInfo.getContByContNo(this.contNo);
/* 234 */       StateOperatorDeal operatorDeal = new StateOperatorDeal();
/* 235 */       if ((checkDataNum(this.contNo)) || (checkApprizDataNum(this.contNo))) {
/* 236 */         List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "modify", "07");
/* 237 */         contSch.setState((String)stateList.get(0));
/* 238 */         contSch.setEditstate((String)stateList.get(1));
/*     */       } else {
/* 240 */         List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "delete", "07");
/* 241 */         contSch.setState((String)stateList.get(0));
/* 242 */         contSch.setEditstate((String)stateList.get(1));
/*     */       }
/*     */ 
/* 246 */       if ("2".equals(contSch.getUWFlag())) {
/* 247 */         contSch.setUWFlag("1");
/*     */       }
/* 249 */       map.put(contSch, "UPDATE");
/* 250 */       Map resultMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
/* 251 */       String polOrder = (String)resultMap.get("polOrder");
/* 252 */       this.lnpInsureHistorySchema = getContByPolOrder(polOrder);
/* 253 */       map.put(this.lnpInsureHistorySchema, "DELETE");
/* 254 */       VData vd = new VData();
/* 255 */       vd.add(map);
/* 256 */       if (!ps.submitData(vd, "")) {
/* 257 */         this.message = "\uFFFD\uFFFD\uFFFD\uD9B3\uDC31\uFFFD\uFFFD\u057E\uFFFD\uFFFD\uFFFD\u027E\uFFFD\uFFFD\u02A7\uFFFD\uFFFD";
/* 258 */         this.operateResult = false;
/* 259 */         this.showMesFlag = true;
/*     */       } else {
/* 261 */         this.message = "\uFFFD\uFFFD\uFFFD\uD9B3\uDC31\uFFFD\uFFFD\u057E\uFFFD\uFFFD\uFFFD\u027E\uFFFD\uFFFD\u0279\uFFFD";
/* 262 */         this.operateResult = true;
/* 263 */         this.showMesFlag = false;
/* 264 */         this.pageEditTag = true;
/* 265 */         getLnpInsureHistorySchemaList(this.lnpInsureHistorySchema.getContNo());
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 269 */       e.printStackTrace();
/*     */     }
/* 271 */     this.lnpInsureHistorySchema = new LNPInsureHistorySchema();
/* 272 */     initData();
/*     */   }
/*     */ 
/*     */   public boolean checkDataNum(String contNoStr)
/*     */   {
/* 277 */     LNPInsureHistoryDB db = new LNPInsureHistoryDB();
/* 278 */     String sql = "select * from LNPInsureHistory where  ContNo = '" + contNoStr + "'";
/* 279 */     LNPInsureHistorySet ihSet = db.executeQuery(sql);
/*     */ 
/* 281 */     return (ihSet != null) && (ihSet.size() > 0);
/*     */   }
/*     */ 
/*     */   public boolean checkApprizDataNum(String contNoStr)
/*     */   {
/* 289 */     LNPFAndIImpResultDB db = new LNPFAndIImpResultDB();
/* 290 */     String sql = "select * from lnpfandiimpresult where  ContNo = '" + contNoStr + "'";
/* 291 */     LNPFAndIImpResultSet ihSet = db.executeQuery(sql);
/*     */ 
/* 293 */     return (ihSet != null) && (ihSet.size() > 0);
/*     */   }
/*     */ 
/*     */   private LNPInsureHistorySet getLNPInsureHistorySetDatas(String contNoStr)
/*     */   {
/* 301 */     LNPInsureHistoryDB db = new LNPInsureHistoryDB();
/* 302 */     String sql = "select * from LNPInsureHistory where  ContNo = '" + contNoStr + "'";
/* 303 */     LNPInsureHistorySet ihSet = db.executeQuery(sql);
/* 304 */     return ihSet;
/*     */   }
/*     */ 
/*     */   private void setpageEditTagWithSet()
/*     */   {
/* 309 */     LNPInsureHistorySet iSet = getLNPInsureHistorySetDatas(this.contNo);
/* 310 */     if ((iSet != null) && (iSet.size() >= 2))
/* 311 */       this.pageEditTag = false;
/*     */     else
/* 313 */       this.pageEditTag = true;
/*     */   }
/*     */ 
/*     */   private void getLnpInsureHistorySchemaList(String contNoStr)
/*     */   {
/* 319 */     LNPInsureHistoryDB db = new LNPInsureHistoryDB();
/* 320 */     String sql = "select * from LNPInsureHistory where  ContNo = '" + contNoStr + "'";
/* 321 */     LNPInsureHistorySet ihSet = db.executeQuery(sql);
/* 322 */     if ((ihSet != null) && (ihSet.size() > 0)) {
/* 323 */       this.insureHistoryList = new ArrayList();
/* 324 */       for (int i = 1; i <= ihSet.size(); i++) {
/* 325 */         LNPInsureHistorySchema temp = ihSet.get(i);
/* 326 */         LNPFinanceAndInsureBean tempbean = new LNPFinanceAndInsureBean();
/* 327 */         tempbean.setSchema(temp);
/* 328 */         String sumInsuredDeath = getFormatString(temp.getSumInsuredDeath() / 10000.0D);
/* 329 */         String sumInsuredDisease = getFormatString(temp.getSumInsuredDisease() / 10000.0D);
/*     */ 
/* 332 */         tempbean.setSumInsuredDeath(sumInsuredDeath);
/* 333 */         tempbean.setSumInsuredDisease(sumInsuredDisease);
/* 334 */         tempbean.setPolicyState((String)this.stateMap.get(temp.getPolicyState()));
/* 335 */         if (this.editFlag)
/* 336 */           tempbean.setListShowTag("inline-block");
/*     */         else {
/* 338 */           tempbean.setListShowTag("none");
/*     */         }
/* 340 */         this.insureHistoryList.add(tempbean);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private LNPInsureHistorySchema getContByNo(String contNoStr)
/*     */   {
/* 347 */     LNPInsureHistoryDB db = new LNPInsureHistoryDB();
/* 348 */     String sql = "SELECT top 1 * FROM LNPInsureHistory WHERE  ContNo = '" + contNoStr + "' order by PolOrder desc";
/* 349 */     LNPInsureHistorySet set = db.executeQuery(sql);
/* 350 */     if ((set != null) && (set.size() > 0)) {
/* 351 */       return set.get(1);
/*     */     }
/* 353 */     return null;
/*     */   }
/*     */ 
/*     */   private LNPInsureHistorySchema getContByPolOrder(String polOrder)
/*     */   {
/* 359 */     LNPInsureHistoryDB db = new LNPInsureHistoryDB();
/* 360 */     db.setContNo(this.contNo);
/* 361 */     db.setPolOrder(polOrder);
/* 362 */     if (db.getInfo()) {
/* 363 */       return db.getSchema();
/*     */     }
/* 365 */     return null;
/*     */   }
/*     */ 
/*     */   private void initStateMap()
/*     */   {
/* 371 */     ExeSQL tExeSQL = new ExeSQL();
/* 372 */     String sql = "select code,codename from lnpcode where codetype='contStatus' order by code";
/* 373 */     SSRS tSRS = tExeSQL.execSQL(sql);
/* 374 */     if ((tSRS != null) && (tSRS.MaxRow > 0))
/* 375 */       for (int i = 1; i <= tSRS.MaxRow; i++)
/* 376 */         this.stateMap.put(tSRS.GetText(i, 1), tSRS.GetText(i, 2));
/*     */   }
/*     */ 
/*     */   private String getDoubleStr(String value)
/*     */   {
/* 384 */     if (value == null) {
/* 385 */       return null;
/*     */     }
/* 387 */     String result = "";
/* 388 */     int ch = 0;
/* 389 */     ch = value.lastIndexOf(".");
/* 390 */     if (-1 == ch) {
/* 391 */       result = value;
/*     */     } else {
/* 393 */       String dotper = value.substring(0, ch);
/* 394 */       String dotAft = value.substring(ch, value.length());
/* 395 */       dotAft = dotAft.length() > 5 ? dotAft.substring(0, 5) : dotAft;
/* 396 */       result = dotper + dotAft;
/*     */     }
/* 398 */     return result;
/*     */   }
/*     */ 
/*     */   private String getFormatString(double inputStr)
/*     */   {
/* 403 */     DecimalFormat myformat = new DecimalFormat("#0.0000");
/*     */ 
/* 405 */     DecimalFormat myformatcheck = new DecimalFormat("#0");
/*     */ 
/* 407 */     String reuslt = "";
/* 408 */     if ((int)inputStr != inputStr)
/* 409 */       reuslt = myformat.format(inputStr);
/*     */     else {
/* 411 */       reuslt = myformatcheck.format(inputStr);
/*     */     }
/* 413 */     return reuslt;
/*     */   }
/*     */ 
/*     */   private boolean validate()
/*     */   {
/* 419 */     this.message = "";
/* 420 */     if ((this.lnpInsureHistorySchema.getComName() == null) || ("".equals(this.lnpInsureHistorySchema.getComName().trim()))) {
/* 421 */       this.message = " \uFFFD\uFFFD\u00BC\uFFFD\uBC63\uFFFD\u0579\uFFFD\u02FE\uFFFD\uFFFD\u01BA\uFFFD\uFFFD\u0671\uFFFD\uFFFD\u68E1";
/* 422 */       return false;
/*     */     }
/* 424 */     if (!ValidateTools.isExistUselessChar(this.lnpInsureHistorySchema.getComName())) {
/* 425 */       this.message = " \uFFFD\uFFFD\uFFFD\u0579\uFFFD\u02FE\uFFFD\uFFFD\uFFFD\u05BB\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0121\uFFFD\uFFFD\uFFFD\u0138\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u05BC\uFFFD\uFFFD\u05B7\uFFFD \uFFFD\uFFFD_\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD";
/* 426 */       return false;
/*     */     }
/*     */ 
/* 430 */     if (0.0D > this.lnpInsureHistorySchema.getSumInsuredDeath()) {
/* 431 */       this.message = "\uFFFD\uFFFD\u00BC\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0731\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0671\uFFFD\uFFFD\u68E1";
/* 432 */       return false;
/*     */     }
/*     */ 
/* 435 */     if (0.0D > this.lnpInsureHistorySchema.getSumInsuredDisease()) {
/* 436 */       this.message = "\uFFFD\uFFFD\u00BC\uFFFD\uFFFD\uFFFD\u0634\uDBB3\uDCB2\uFFFD\uFFFD\u0731\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0671\uFFFD\uFFFD\u68E1";
/* 437 */       return false;
/*     */     }
/*     */ 
/* 440 */     if (!ValidateTools.isExistUselessChar(String.valueOf(this.lnpInsureHistorySchema.getSumInsuredDeath()))) {
/* 441 */       this.message = " \uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0731\uFFFD\uFFFD\uFFFD\u05BB\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u05A3\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0671\uFFFD\uFFFD\u68E1";
/* 442 */       return false;
/*     */     }
/* 444 */     if (!ValidateTools.isExistUselessChar(String.valueOf(this.lnpInsureHistorySchema.getSumInsuredDisease()))) {
/* 445 */       this.message = " \uFFFD\u0634\uDBB3\uDCB2\uFFFD\uFFFD\u0731\uFFFD\uFFFD\uFFFD\u05BB\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u05A3\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0671\uFFFD\uFFFD\u68E1";
/* 446 */       return false;
/*     */     }
/* 448 */     if ((this.lnpInsureHistorySchema.getPolicyState() == null) || 
/* 449 */       ("".equals(this.lnpInsureHistorySchema.getPolicyState().trim())) || 
/* 450 */       ("-1".equals(this.lnpInsureHistorySchema.getPolicyState().trim()))) {
/* 451 */       this.message = " \uFFFD\uFFFD\u00BC\uFFFD\uBC63\uFFFD\uFFFD\u05F4\u032C\uFFFD\uFFFD\uFFFD\u0671\uFFFD\uFFFD\u68E1";
/* 452 */       return false;
/*     */     }
/* 454 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPInsureHistorySchema getLnpInsureHistorySchema()
/*     */   {
/* 459 */     return this.lnpInsureHistorySchema;
/*     */   }
/*     */ 
/*     */   public void setLnpInsureHistorySchema(LNPInsureHistorySchema lnpInsureHistorySchema)
/*     */   {
/* 464 */     this.lnpInsureHistorySchema = lnpInsureHistorySchema;
/*     */   }
/*     */ 
/*     */   public String getMessage() {
/* 468 */     return this.message;
/*     */   }
/*     */ 
/*     */   public void setMessage(String message) {
/* 472 */     this.message = message;
/*     */   }
/*     */ 
/*     */   public List<LNPFinanceAndInsureBean> getInsureHistoryList()
/*     */   {
/* 477 */     return this.insureHistoryList;
/*     */   }
/*     */ 
/*     */   public void setInsureHistoryList(List<LNPFinanceAndInsureBean> insureHistoryList) {
/* 481 */     this.insureHistoryList = insureHistoryList;
/*     */   }
/*     */ 
/*     */   public boolean isOperateResult() {
/* 485 */     return this.operateResult;
/*     */   }
/*     */ 
/*     */   public void setOperateResult(boolean operateResult) {
/* 489 */     this.operateResult = operateResult;
/*     */   }
/*     */ 
/*     */   public boolean isPageEditTag() {
/* 493 */     return this.pageEditTag;
/*     */   }
/*     */ 
/*     */   public void setPageEditTag(boolean pageEditTag) {
/* 497 */     this.pageEditTag = pageEditTag;
/*     */   }
/*     */ 
/*     */   public boolean isEditFlag() {
/* 501 */     return this.editFlag;
/*     */   }
/*     */ 
/*     */   public void setEditFlag(boolean editFlag) {
/* 505 */     this.editFlag = editFlag;
/*     */   }
/*     */ 
/*     */   public boolean isShowMesFlag() {
/* 509 */     return this.showMesFlag;
/*     */   }
/*     */ 
/*     */   public void setShowMesFlag(boolean showMesFlag) {
/* 513 */     this.showMesFlag = showMesFlag;
/*     */   }
/*     */ 
/*     */   public LNPFinanceAndInsureBean getLnpInsureHistoryBean() {
/* 517 */     return this.lnpInsureHistoryBean;
/*     */   }
/*     */ 
/*     */   public void setLnpInsureHistoryBean(LNPFinanceAndInsureBean lnpInsureHistoryBean) {
/* 521 */     this.lnpInsureHistoryBean = lnpInsureHistoryBean;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.FinanceAndInsure
 * JD-Core Version:    0.6.0
 */