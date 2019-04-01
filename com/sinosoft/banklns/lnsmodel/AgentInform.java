/*     */ package com.sinosoft.banklns.lnsmodel;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPAgentImpResultDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPAgentInfoDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPContDB;
/*     */ import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
/*     */ import com.sinosoft.banklns.lis.pubfun.MMap;
/*     */ import com.sinosoft.banklns.lis.pubfun.PubFun;
/*     */ import com.sinosoft.banklns.lis.pubfun.PubSubmit;
/*     */ import com.sinosoft.banklns.lis.pubfun.ValidateTools;
/*     */ import com.sinosoft.banklns.lis.schema.LNPAgentInfoSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPAgentImpResultSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPAgentInfoSet;
/*     */ import com.sinosoft.banklns.utility.ExeSQL;
/*     */ import com.sinosoft.banklns.utility.SSRS;
/*     */ import com.sinosoft.banklns.utility.VData;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.faces.context.ExternalContext;
/*     */ import javax.faces.context.FacesContext;
/*     */ import javax.servlet.http.HttpSession;
/*     */ 
/*     */ public class AgentInform
/*     */ {
/*  30 */   private LNPAgentInfoSchema lnpAgentInfoSchema = new LNPAgentInfoSchema();
/*     */ 
/*  33 */   private List<LNPAgentInfoSchema> lnpAgentInfoList = null;
/*     */ 
/*  35 */   private String message = "";
/*     */ 
/*  37 */   private boolean modifyTag = false;
/*     */ 
/*  39 */   private String contNo = "";
/*     */ 
/*  42 */   private boolean pageEditTag = true;
/*     */ 
/*  45 */   private boolean doClearTag = false;
/*     */ 
/*  47 */   private boolean editFlag = true;
/*     */ 
/*  49 */   private boolean showMesFlag = false;
/*     */ 
/*     */   public void initData()
/*     */   {
/*     */     try {
/*  54 */       HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*  55 */       Boolean getEditFlag = (Boolean)session.getAttribute("editFlag");
/*  56 */       if (getEditFlag != null) {
/*  57 */         if (getEditFlag.booleanValue())
/*  58 */           this.editFlag = true;
/*     */         else {
/*  60 */           this.editFlag = false;
/*     */         }
/*     */       }
/*  63 */       this.contNo = ((String)session.getAttribute("ContNo"));
/*  64 */       if (this.lnpAgentInfoList != null) {
/*  65 */         this.lnpAgentInfoList.clear();
/*     */       }
/*  67 */       if (this.contNo != null) {
/*  68 */         getLNPAgentInfoSchemaList(this.contNo);
/*  69 */         setpageEditTagWithSet();
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/*  73 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void saveAgentInform()
/*     */   {
/*  79 */     if ((validate()) && (this.contNo != null) && (!"".equals(this.contNo))) {
/*  80 */       MMap map = new MMap();
/*  81 */       LNPAgentInfoSchema tempSchema = getSchemaByContNo(this.contNo);
/*  82 */       if (tempSchema != null) {
/*  83 */         Integer agentOrderNum = new Integer(tempSchema.getAgentOrder());
/*  84 */         agentOrderNum = Integer.valueOf(agentOrderNum.intValue() + 1);
/*  85 */         this.lnpAgentInfoSchema.setAgentOrder(agentOrderNum.toString());
/*     */       } else {
/*  87 */         this.lnpAgentInfoSchema.setAgentOrder("1");
/*     */       }
/*  89 */       PolicyMainInfo mainInfo = new PolicyMainInfo();
/*  90 */       LNPContSchema contSch = mainInfo.getContByContNo(this.contNo);
/*  91 */       if (contSch != null) {
/*  92 */         this.lnpAgentInfoSchema.setGrpContNo(contSch.getGrpContNo());
/*  93 */         this.lnpAgentInfoSchema.setContNo(this.contNo);
/*  94 */         this.lnpAgentInfoSchema.setProposalContNo(this.contNo);
/*  95 */         this.lnpAgentInfoSchema.setPrtNo(contSch.getPrtNo());
/*  96 */         this.lnpAgentInfoSchema.setAgentName(this.lnpAgentInfoSchema.getAgentName());
/*  97 */         this.lnpAgentInfoSchema.setAgentCode(this.lnpAgentInfoSchema.getAgentCode());
/*  98 */         this.lnpAgentInfoSchema.setBranchName(this.lnpAgentInfoSchema.getBranchName());
/*  99 */         this.lnpAgentInfoSchema.setBranchAttr(this.lnpAgentInfoSchema.getBranchAttr());
/* 100 */         HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/* 101 */         IGlobalInput tempGI = (IGlobalInput)session.getAttribute("NPGI");
/* 102 */         if (tempGI != null) {
/* 103 */           this.lnpAgentInfoSchema.setOperator(tempGI.Operator);
/*     */         }
/* 105 */         String date = PubFun.getCurrentDate();
/* 106 */         String time = PubFun.getCurrentTime();
/* 107 */         this.lnpAgentInfoSchema.setMakeDate(date);
/* 108 */         this.lnpAgentInfoSchema.setMakeTime(time);
/* 109 */         this.lnpAgentInfoSchema.setModifyDate(date);
/* 110 */         this.lnpAgentInfoSchema.setModifyTime(time);
/* 111 */         StateOperatorDeal operatorDeal = new StateOperatorDeal();
/* 112 */         if ((checkDataNum(this.contNo)) || (checkApprizDataNum(this.contNo))) {
/* 113 */           List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "modify", "09");
/* 114 */           contSch.setState((String)stateList.get(0));
/* 115 */           contSch.setEditstate((String)stateList.get(1));
/*     */         } else {
/* 117 */           List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "add", "09");
/* 118 */           contSch.setState((String)stateList.get(0));
/* 119 */           contSch.setEditstate((String)stateList.get(1));
/*     */         }
/*     */ 
/* 122 */         if ("2".equals(contSch.getUWFlag()))
/* 123 */           contSch.setUWFlag("1");
/*     */       }
/*     */       try
/*     */       {
/* 127 */         LNPContSchema lnpContSchema = updateLNPCont(this.lnpAgentInfoSchema, "INSERT");
/* 128 */         PubSubmit ps = new PubSubmit();
/* 129 */         map.put(this.lnpAgentInfoSchema, "INSERT");
/* 130 */         map.put(lnpContSchema, "UPDATE");
/* 131 */         map.put(contSch, "UPDATE");
/* 132 */         VData vd = new VData();
/* 133 */         vd.add(map);
/* 134 */         if (ps.submitData(vd, "")) {
/* 135 */           this.message = "\u4EE3\u7406\u4EBA\u4FE1\u606F\u4FDD\u5B58\u6210\u529F";
/* 136 */           getLNPAgentInfoSchemaList(this.lnpAgentInfoSchema.getContNo());
/* 137 */           this.showMesFlag = false;
/*     */         } else {
/* 139 */           this.message = "\u4EE3\u7406\u4EBA\u4FE1\u606F\u4FDD\u5B58\u5931\u8D25";
/* 140 */           this.showMesFlag = true;
/*     */         }
/* 142 */         setpageEditTagWithSet();
/*     */       } catch (Exception e) {
/* 144 */         e.printStackTrace();
/*     */       }
/* 146 */       this.lnpAgentInfoSchema = new LNPAgentInfoSchema();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void modifyAgentInform()
/*     */   {
/*     */     try
/*     */     {
/* 154 */       Map resultMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
/* 155 */       String agentOrder = (String)resultMap.get("agentOrder");
/* 156 */       if (agentOrder != null) {
/* 157 */         this.lnpAgentInfoSchema = getSchemaByAgentOrder(agentOrder);
/* 158 */         if (this.lnpAgentInfoSchema == null) {
/* 159 */           this.lnpAgentInfoSchema = new LNPAgentInfoSchema();
/*     */         }
/* 161 */         this.modifyTag = true;
/* 162 */         this.pageEditTag = true;
/*     */       }
/*     */     } catch (Exception e) {
/* 165 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void removeAgentInform()
/*     */   {
/*     */     try
/*     */     {
/* 173 */       Map resultMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
/* 174 */       String agentOrder = (String)resultMap.get("agentOrder");
/* 175 */       if (agentOrder != null) {
/* 176 */         this.lnpAgentInfoSchema = getSchemaByAgentOrder(agentOrder);
/* 177 */         if (this.lnpAgentInfoSchema != null) {
/* 178 */           LNPContSchema lnpContSchema = updateLNPCont(this.lnpAgentInfoSchema, "DELETE");
/* 179 */           PubSubmit ps = new PubSubmit();
/* 180 */           MMap map = new MMap();
/* 181 */           PolicyMainInfo mainInfo = new PolicyMainInfo();
/* 182 */           LNPContSchema contSch = mainInfo.getContByContNo(this.contNo);
/* 183 */           StateOperatorDeal operatorDeal = new StateOperatorDeal();
/* 184 */           if ((checkDataNum(this.contNo)) || (checkApprizDataNum(this.contNo))) {
/* 185 */             List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "modify", "09");
/* 186 */             contSch.setState((String)stateList.get(0));
/* 187 */             contSch.setEditstate((String)stateList.get(1));
/*     */           } else {
/* 189 */             List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "delete", "09");
/* 190 */             contSch.setState((String)stateList.get(0));
/* 191 */             contSch.setEditstate((String)stateList.get(1));
/*     */           }
/*     */ 
/* 195 */           if ("2".equals(contSch.getUWFlag())) {
/* 196 */             contSch.setUWFlag("1");
/*     */           }
/* 198 */           map.put(this.lnpAgentInfoSchema, "DELETE");
/* 199 */           map.put(lnpContSchema, "UPDATE");
/* 200 */           map.put(contSch, "UPDATE");
/* 201 */           VData vd = new VData();
/* 202 */           vd.add(map);
/* 203 */           if (ps.submitData(vd, "")) {
/* 204 */             this.message = "\u4EE3\u7406\u4EBA\u4FE1\u606F\u5220\u9664\u6210\u529F";
/* 205 */             getLNPAgentInfoSchemaList(this.lnpAgentInfoSchema.getContNo());
/* 206 */             this.showMesFlag = false;
/*     */           } else {
/* 208 */             this.message = "\u4EE3\u7406\u4EBA\u4FE1\u606F\u5220\u9664\u5931\u8D25";
/* 209 */             this.showMesFlag = true;
/*     */           }
/* 211 */           setpageEditTagWithSet();
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 215 */       e.printStackTrace();
/*     */     }
/* 217 */     this.lnpAgentInfoSchema = new LNPAgentInfoSchema();
/* 218 */     initData();
/*     */   }
/*     */ 
/*     */   private void getLNPAgentInfoSchemaList(String contNoStr)
/*     */   {
/* 223 */     LNPAgentInfoDB db = new LNPAgentInfoDB();
/* 224 */     String sql = "select * from lnpagentinfo where  contno = '" + contNoStr + "'";
/* 225 */     LNPAgentInfoSet iSet = db.executeQuery(sql);
/* 226 */     if ((iSet != null) && (iSet.size() > 0)) {
/* 227 */       this.lnpAgentInfoList = new ArrayList();
/* 228 */       for (int i = 1; i <= iSet.size(); i++) {
/* 229 */         LNPAgentInfoSchema temp = iSet.get(i);
/* 230 */         if (this.editFlag)
/* 231 */           temp.setP1("inline-block");
/*     */         else {
/* 233 */           temp.setP1("none");
/*     */         }
/* 235 */         this.lnpAgentInfoList.add(temp);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private LNPAgentInfoSchema getSchemaByContNo(String contNoStr)
/*     */   {
/* 242 */     LNPAgentInfoDB db = new LNPAgentInfoDB();
/* 243 */     String sql = "select top 1 * from lnpagentinfo where  contno = '" + contNoStr + "' order by AgentOrder desc";
/* 244 */     LNPAgentInfoSet iSet = db.executeQuery(sql);
/* 245 */     if ((iSet != null) && (iSet.size() > 0)) {
/* 246 */       return iSet.get(1);
/*     */     }
/* 248 */     return null;
/*     */   }
/*     */ 
/*     */   private LNPAgentInfoSchema getSchemaByAgentOrder(String agentOrder)
/*     */   {
/* 254 */     LNPAgentInfoDB db = new LNPAgentInfoDB();
/* 255 */     db.setContNo(this.contNo);
/* 256 */     db.setAgentOrder(agentOrder);
/* 257 */     if (db.getInfo()) {
/* 258 */       return db.getSchema();
/*     */     }
/* 260 */     return null;
/*     */   }
/*     */ 
/*     */   private LNPContSchema updateLNPCont(LNPAgentInfoSchema lnpAgentInfoSchema, String type)
/*     */   {
/* 265 */     LNPContSchema lnpContSchema = new LNPContSchema();
/* 266 */     LNPContDB contDB = new LNPContDB();
/* 267 */     lnpContSchema.setContNo(lnpAgentInfoSchema.getContNo());
/* 268 */     contDB.setContNo(lnpAgentInfoSchema.getContNo());
/* 269 */     if (contDB.getInfo()) {
/* 270 */       lnpContSchema = contDB.getSchema();
/*     */     }
/* 272 */     if ("INSERT".equals(type)) {
/* 273 */       if ((lnpContSchema.getAgentCode() == null) || ("".equals(lnpContSchema.getAgentCode().trim()))) {
/* 274 */         lnpContSchema.setAgentCode(lnpAgentInfoSchema.getAgentCode());
/* 275 */         lnpContSchema.setAgentGroup(lnpAgentInfoSchema.getBranchAttr());
/*     */       } else {
/* 277 */         lnpContSchema.setAgentCode1(lnpAgentInfoSchema.getAgentCode());
/* 278 */         lnpContSchema.setAgentGroup1(lnpAgentInfoSchema.getBranchAttr());
/*     */       }
/*     */     }
/* 281 */     if ("DELETE".equals(type)) {
/* 282 */       if (lnpAgentInfoSchema.getAgentCode().equals(lnpContSchema.getAgentCode())) {
/* 283 */         lnpContSchema.setAgentCode("");
/* 284 */         lnpContSchema.setAgentGroup("");
/*     */       } else {
/* 286 */         lnpContSchema.setAgentCode1("");
/* 287 */         lnpContSchema.setAgentGroup1("");
/*     */       }
/*     */     }
/* 290 */     return lnpContSchema;
/*     */   }
/*     */ 
/*     */   public boolean checkDataNum(String contNoStr)
/*     */   {
/* 295 */     LNPAgentInfoDB db = new LNPAgentInfoDB();
/* 296 */     String sql = "select * from lnpagentinfo where  contno = '" + contNoStr + "'";
/* 297 */     LNPAgentInfoSet iSet = db.executeQuery(sql);
/*     */ 
/* 299 */     return (iSet != null) && (iSet.size() > 0);
/*     */   }
/*     */ 
/*     */   public boolean checkApprizDataNum(String contNoStr)
/*     */   {
/* 307 */     LNPAgentImpResultDB db = new LNPAgentImpResultDB();
/* 308 */     String sql = "select * from LNPAgentImpResult where  ContNo = '" + contNoStr + "'";
/* 309 */     LNPAgentImpResultSet ihSet = db.executeQuery(sql);
/*     */ 
/* 311 */     return (ihSet != null) && (ihSet.size() > 0);
/*     */   }
/*     */ 
/*     */   private LNPAgentInfoSet getLNPAgentInfoSetDatas(String contNoStr)
/*     */   {
/* 319 */     LNPAgentInfoDB db = new LNPAgentInfoDB();
/* 320 */     String sql = "select * from lnpagentinfo where  contno = '" + contNoStr + "'";
/* 321 */     LNPAgentInfoSet iSet = db.executeQuery(sql);
/* 322 */     return iSet;
/*     */   }
/*     */ 
/*     */   private void setpageEditTagWithSet()
/*     */   {
/* 327 */     LNPAgentInfoSet iSet = getLNPAgentInfoSetDatas(this.contNo);
/* 328 */     if ((iSet != null) && (iSet.size() >= 2))
/* 329 */       this.pageEditTag = false;
/*     */     else
/* 331 */       this.pageEditTag = true;
/*     */   }
/*     */ 
/*     */   public void getAgentInfo()
/*     */   {
/* 336 */     ExeSQL tExeSql = new ExeSQL();
/* 337 */     String branchType = "";
/* 338 */     String agentCode = this.lnpAgentInfoSchema.getAgentCode();
/* 339 */     HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/* 340 */     IGlobalInput tempGI = (IGlobalInput)session.getAttribute("NPGI");
/* 341 */     if (tempGI != null) {
/* 342 */       branchType = tempGI.chanlesign;
/*     */     }
/* 344 */     if (agentCode != null)
/*     */       try
/*     */       {
/* 347 */         String com = "";
/* 348 */         String preSql = "select t.comcode,t.name,t.validcode from lnpcom t where t.validcode = '" + this.contNo.substring(0, 2) + "'";
/* 349 */         SSRS tSSRSfromCom = tExeSql.execSQL(preSql);
/* 350 */         if ((tSSRSfromCom != null) && (tSSRSfromCom.MaxRow > 0)) {
/* 351 */           com = tSSRSfromCom.GetText(1, 1);
/*     */         }
/* 353 */         String vSql = "select v.name as agentname,v.agentcode,t.name as branchname,v.branchattr from laagentv v,labranchgroup t  where  t.agentgroup = v.agentgroup and v.managecom like '86%' and v.branchtype = '" + 
/* 355 */           branchType + "' and v.agentcode ='" + agentCode + "' and v.agentcode like '" + com + "%'";
/* 356 */         System.out.println("AgentInform vSQL : " + vSql);
/* 357 */         SSRS tSSRSfromDB = tExeSql.execSQL(vSql);
/* 358 */         if (hasExistSameAgentCode(agentCode)) {
/* 359 */           this.doClearTag = true;
/* 360 */           this.message = " \u4E0D\u5141\u8BB8\u5F55\u5165\u76F8\u540C\u7684\u4EE3\u7406\u4EBA\u4FE1\u606F \uFF01 ";
/*     */         }
/* 362 */         else if (tSSRSfromDB.MaxRow > 0) {
/* 363 */           this.lnpAgentInfoSchema.setAgentName(tSSRSfromDB.GetText(1, 1));
/* 364 */           this.lnpAgentInfoSchema.setAgentCode(agentCode);
/* 365 */           this.lnpAgentInfoSchema.setBranchName(tSSRSfromDB.GetText(1, 3));
/* 366 */           this.lnpAgentInfoSchema.setBranchAttr(tSSRSfromDB.GetText(1, 4));
/*     */ 
/* 368 */           this.doClearTag = false;
/*     */         } else {
/* 370 */           this.doClearTag = true;
/* 371 */           this.message = " \u6B64\u4EE3\u7406\u4EBA\u7684\u76F8\u5173\u4FE1\u606F\u4E0D\u5141\u8BB8\u5F55\u5165 \uFF01 ";
/*     */         }
/*     */       }
/*     */       catch (Exception e) {
/* 375 */         e.printStackTrace();
/*     */       }
/*     */   }
/*     */ 
/*     */   private boolean hasExistSameAgentCode(String agentCode)
/*     */   {
/* 382 */     String sql = "select * from LNPAgentInfo where contno='" + this.contNo + "' and agentcode='" + agentCode + "' ";
/* 383 */     ExeSQL tExeSql = new ExeSQL();
/* 384 */     SSRS tSSRSfromDB = tExeSql.execSQL(sql);
/*     */ 
/* 386 */     return (tSSRSfromDB != null) && (tSSRSfromDB.MaxRow > 0);
/*     */   }
/*     */ 
/*     */   private boolean validate()
/*     */   {
/* 396 */     this.message = "";
/* 397 */     if ((this.lnpAgentInfoSchema.getAgentCode() == null) || ("".equals(this.lnpAgentInfoSchema.getAgentCode().trim()))) {
/* 398 */       this.message = " \u8BF7\u586B\u5199\u4EE3\u7406\u4EBA\u4FE1\u606F\u540E\u518D\u8FDB\u884C\u8BBE\u7F6E\uFF01";
/* 399 */       return false;
/*     */     }
/* 401 */     if (!ValidateTools.isExistUselessChar(this.lnpAgentInfoSchema.getAgentCode())) {
/* 402 */       this.message = " \u4EE3\u7406\u4EBA\u7F16\u7801\u53EA\u80FD\u662F\u6570\u5B57\uFF0C\u8BF7\u66F4\u6B63\u540E\u518D\u8FDB\u884C\u8BBE\u7F6E\uFF01";
/* 403 */       return false;
/*     */     }
/*     */ 
/* 406 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPAgentInfoSchema getLnpAgentInfoSchema() {
/* 410 */     return this.lnpAgentInfoSchema;
/*     */   }
/*     */ 
/*     */   public void setLnpAgentInfoSchema(LNPAgentInfoSchema lnpAgentInfoSchema) {
/* 414 */     this.lnpAgentInfoSchema = lnpAgentInfoSchema;
/*     */   }
/*     */ 
/*     */   public String getMessage() {
/* 418 */     return this.message;
/*     */   }
/*     */ 
/*     */   public void setMessage(String message) {
/* 422 */     this.message = message;
/*     */   }
/*     */ 
/*     */   public List<LNPAgentInfoSchema> getLnpAgentInfoList() {
/* 426 */     return this.lnpAgentInfoList;
/*     */   }
/*     */ 
/*     */   public void setLnpAgentInfoList(List<LNPAgentInfoSchema> lnpAgentInfoList) {
/* 430 */     this.lnpAgentInfoList = lnpAgentInfoList;
/*     */   }
/*     */ 
/*     */   public boolean isModifyTag() {
/* 434 */     return this.modifyTag;
/*     */   }
/*     */ 
/*     */   public void setModifyTag(boolean modifyTag) {
/* 438 */     this.modifyTag = modifyTag;
/*     */   }
/*     */ 
/*     */   public boolean isPageEditTag() {
/* 442 */     return this.pageEditTag;
/*     */   }
/*     */ 
/*     */   public void setPageEditTag(boolean pageEditTag) {
/* 446 */     this.pageEditTag = pageEditTag;
/*     */   }
/*     */ 
/*     */   public boolean isDoClearTag() {
/* 450 */     return this.doClearTag;
/*     */   }
/*     */ 
/*     */   public void setDoClearTag(boolean doClearTag) {
/* 454 */     this.doClearTag = doClearTag;
/*     */   }
/*     */ 
/*     */   public boolean isEditFlag() {
/* 458 */     return this.editFlag;
/*     */   }
/*     */ 
/*     */   public void setEditFlag(boolean editFlag) {
/* 462 */     this.editFlag = editFlag;
/*     */   }
/*     */ 
/*     */   public boolean isShowMesFlag() {
/* 466 */     return this.showMesFlag;
/*     */   }
/*     */ 
/*     */   public void setShowMesFlag(boolean showMesFlag) {
/* 470 */     this.showMesFlag = showMesFlag;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.AgentInform
 * JD-Core Version:    0.6.0
 */