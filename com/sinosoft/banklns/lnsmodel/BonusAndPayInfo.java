/*     */ package com.sinosoft.banklns.lnsmodel;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPBonusInfoDB;
/*     */ import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
/*     */ import com.sinosoft.banklns.lis.pubfun.MMap;
/*     */ import com.sinosoft.banklns.lis.pubfun.PubFun;
/*     */ import com.sinosoft.banklns.lis.pubfun.PubSubmit;
/*     */ import com.sinosoft.banklns.lis.schema.LNPBonusInfoSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*     */ import com.sinosoft.banklns.utility.ExeSQL;
/*     */ import com.sinosoft.banklns.utility.SSRS;
/*     */ import com.sinosoft.banklns.utility.VData;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.faces.context.ExternalContext;
/*     */ import javax.faces.context.FacesContext;
/*     */ import javax.faces.model.SelectItem;
/*     */ import javax.servlet.http.HttpSession;
/*     */ 
/*     */ public class BonusAndPayInfo
/*     */ {
/*  24 */   private LNPBonusInfoSchema lnpBonusInfoSchema = new LNPBonusInfoSchema();
/*     */ 
/*  26 */   private List<SelectItem> bonusAndPayTypeList = new ArrayList();
/*     */ 
/*  29 */   private List<SelectItem> frontalClearedTypeList = new ArrayList();
/*     */ 
/*  32 */   private String message = "";
/*     */ 
/*  34 */   private String contNo = "";
/*     */ 
/*  36 */   private boolean isHasExist = false;
/*     */ 
/*  38 */   private boolean editFlag = true;
/*     */ 
/*  40 */   private boolean hasBonusAndPaytag = true;
/*     */ 
/*     */   public void initData() {
/*     */     try {
/*  44 */       HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*  45 */       this.contNo = ((String)session.getAttribute("ContNo"));
/*     */ 
/*  47 */       if (this.contNo != null) {
/*  48 */         this.lnpBonusInfoSchema = getLnpBonusInfoSchemaFromDB(this.contNo);
/*     */       }
/*  50 */       Boolean getEditFlag = (Boolean)session.getAttribute("editFlag");
/*  51 */       if (getEditFlag != null) {
/*  52 */         if (getEditFlag.booleanValue())
/*  53 */           this.editFlag = true;
/*     */         else {
/*  55 */           this.editFlag = false;
/*     */         }
/*     */       }
/*  58 */       List list = getBonusAndPayTypeList();
/*  59 */       if (list.size() > 0) {
/*  60 */         this.hasBonusAndPaytag = true;
/*     */       } else {
/*  62 */         this.hasBonusAndPaytag = false;
/*  63 */         this.message = " \uFFFD\uFFFD\u01F0\uFFFD\uFFFD\u01B7\uFFFD\u07BA\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03E2\uFFFD\uFFFD ";
/*     */       }
/*     */     } catch (Exception e) {
/*  66 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void saveBonusAndPayInfo()
/*     */   {
/*  73 */     PubSubmit ps = new PubSubmit();
/*  74 */     MMap map = new MMap();
/*  75 */     StateOperatorDeal operatorDeal = new StateOperatorDeal();
/*  76 */     PolicyMainInfo mainInfo = new PolicyMainInfo();
/*  77 */     LNPContSchema contSch = mainInfo.getContByContNo(this.contNo);
/*  78 */     if ((validate()) && (this.contNo != null) && (!"".equals(this.contNo.trim())) && (contSch != null)) {
/*  79 */       if (this.isHasExist) {
/*  80 */         LNPBonusInfoSchema delSchema = getLnpBonusInfoSchemaFromDB(this.contNo);
/*  81 */         map.put(delSchema, "DELETE");
/*  82 */         List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "modify", "05");
/*  83 */         contSch.setState((String)stateList.get(0));
/*  84 */         contSch.setEditstate((String)stateList.get(1));
/*     */       } else {
/*  86 */         List stateList = operatorDeal.infoOperate(contSch.getState(), contSch.getEditstate(), "add", "05");
/*  87 */         contSch.setState((String)stateList.get(0));
/*  88 */         contSch.setEditstate((String)stateList.get(1));
/*     */       }
/*  90 */       map.put(contSch, "UPDATE");
/*  91 */       LNPBonusInfoSchema tempSchema = new LNPBonusInfoSchema();
/*  92 */       tempSchema.setGrpContNo(contSch.getGrpContNo());
/*  93 */       tempSchema.setContNo(this.contNo);
/*  94 */       tempSchema.setProposalContNo(this.contNo);
/*  95 */       tempSchema.setPrtNo(contSch.getPrtNo());
/*  96 */       String bonusType = "";
/*  97 */       ExeSQL tExeSql = new ExeSQL();
/*  98 */       String sql = "select top 1 cfg.bonustype from lnppol pol,lnpriskconfig cfg where pol.contno = '" + 
/*  99 */         this.contNo + "' " + 
/* 100 */         "and pol.masterpolno = pol.polno and pol.riskcode=cfg.riskcode";
/* 101 */       SSRS ssrs = tExeSql.execSQL(sql);
/* 102 */       if ((ssrs != null) && (ssrs.MaxRow > 0) && (ssrs.GetText(1, 1) != null)) {
/* 103 */         bonusType = ssrs.GetText(1, 1).trim();
/*     */       }
/* 105 */       tempSchema.setBonusType(bonusType);
/* 106 */       tempSchema.setBonusWay(this.lnpBonusInfoSchema.getBonusWay());
/* 107 */       tempSchema.setAutoRepaid(this.lnpBonusInfoSchema.getAutoRepaid());
/* 108 */       tempSchema.setCutPayAll(this.lnpBonusInfoSchema.getCutPayAll());
/* 109 */       HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/* 110 */       IGlobalInput tempGI = (IGlobalInput)session.getAttribute("NPGI");
/* 111 */       if (tempGI != null) {
/* 112 */         tempSchema.setOperator(tempGI.Operator);
/*     */       }
/* 114 */       String date = PubFun.getCurrentDate();
/* 115 */       String time = PubFun.getCurrentTime();
/* 116 */       tempSchema.setMakeDate(date);
/* 117 */       tempSchema.setMakeTime(time);
/* 118 */       tempSchema.setModifyDate(date);
/* 119 */       tempSchema.setModifyTime(time);
/*     */       try {
/* 121 */         map.put(tempSchema, "INSERT");
/* 122 */         VData vd = new VData();
/* 123 */         vd.add(map);
/* 124 */         if (ps.submitData(vd, ""))
/* 125 */           this.message = " \uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03E2\uFFFD\uFFFD\uFFFD\uFFFD\u0279\uFFFD! ";
/*     */         else
/* 127 */           this.message = " \uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u03E2\uFFFD\uFFFD\uFFFD\uFFFD\u02A7\uFFFD\uFFFD ! ";
/*     */       }
/*     */       catch (Exception e) {
/* 130 */         e.printStackTrace();
/*     */       }
/* 132 */       System.out.println("message : " + this.message);
/*     */     }
/*     */   }
/*     */ 
/*     */   private LNPBonusInfoSchema getLnpBonusInfoSchemaFromDB(String str)
/*     */   {
/* 139 */     LNPBonusInfoDB db = new LNPBonusInfoDB();
/* 140 */     db.setContNo(str);
/* 141 */     if (db.getInfo()) {
/* 142 */       this.isHasExist = true;
/* 143 */       return db.getSchema();
/*     */     }
/* 145 */     this.isHasExist = false;
/* 146 */     return new LNPBonusInfoSchema();
/*     */   }
/*     */ 
/*     */   private List<SelectItem> getBonusAndPayTypeListList(String typename, String contNo)
/*     */   {
/* 152 */     List reList = new ArrayList();
/* 153 */     ExeSQL tExeSQL = new ExeSQL();
/* 154 */     String sql = "select d.code,d.codename from lnpcode d,lnpbonusconfig c,lnpriskconfig b,lnppol a where  d.code = c.bonusway and c.bonustype = b.bonustype and b.riskcode = a.riskcode and a.masterpolno = a.polno and a.contno = '" + 
/* 156 */       contNo + "' and d.codetype='" + typename + "' order by d.code";
/*     */ 
/* 158 */     SSRS tSRS = tExeSQL.execSQL(sql);
/* 159 */     if (tSRS != null) {
/* 160 */       for (int i = 1; i <= tSRS.MaxRow; i++) {
/* 161 */         reList.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*     */       }
/*     */     }
/* 164 */     return reList;
/*     */   }
/*     */ 
/*     */   private List<SelectItem> getFrontalClearedTypeListList(String typename, String contNo)
/*     */   {
/* 179 */     List reList = new ArrayList();
/* 180 */     ExeSQL tExeSQL = new ExeSQL();
/*     */ 
/* 184 */     String sql = "select code,codename from lnpcode where codetype = '" + typename + "' " + 
/* 185 */       "and codealias =(" + 
/* 186 */       "select p1 from LNPRiskConfig a,lnppol b where a.riskcode =b.riskcode and b.contno='" + contNo + "') " + 
/* 187 */       "union " + 
/* 188 */       "select code,codename from lnpcode where codetype = '" + typename + "' " + 
/* 189 */       "and comcode =(" + 
/* 190 */       "select p1 from LNPRiskConfig a,lnppol b where a.riskcode =b.riskcode and b.contno='" + contNo + "')";
/* 191 */     SSRS tSRS = tExeSQL.execSQL(sql);
/*     */ 
/* 193 */     if (tSRS != null) {
/* 194 */       for (int i = 1; i <= tSRS.MaxRow; i++) {
/* 195 */         reList.add(new SelectItem(tSRS.GetText(i, 1), tSRS.GetText(i, 2)));
/*     */       }
/*     */     }
/* 198 */     return reList;
/*     */   }
/*     */ 
/*     */   private boolean validate()
/*     */   {
/* 204 */     this.message = "";
/* 205 */     if ((this.lnpBonusInfoSchema.getBonusWay() == null) || 
/* 206 */       ("".equals(this.lnpBonusInfoSchema.getBonusWay().trim())) || 
/* 207 */       ("-1".equals(this.lnpBonusInfoSchema.getBonusWay().trim()))) {
/* 208 */       this.message = " \uFFFD\uFFFD\u0461\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u00F7\uFFFD\u02BD\uFFFD\uFFFD\uFFFD\u0671\uFFFD\uFFFD\u68E1";
/* 209 */       return false;
/*     */     }
/* 211 */     if ((this.lnpBonusInfoSchema.getAutoRepaid() == null) || 
/* 212 */       ("".equals(this.lnpBonusInfoSchema.getAutoRepaid().trim())) || 
/* 213 */       ("-1".equals(this.lnpBonusInfoSchema.getAutoRepaid().trim()))) {
/* 214 */       this.message = " \uFFFD\uFFFD\u0461\uFFFD\uD986\uDCF7\uFFFD\uFFFD\u0536\uFFFD\uFFFD\u6F7B\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0671\uFFFD\uFFFD\u68E1";
/* 215 */       return false;
/*     */     }
/* 217 */     if ((this.lnpBonusInfoSchema.getCutPayAll() == null) || 
/* 218 */       ("".equals(this.lnpBonusInfoSchema.getCutPayAll().trim())) || 
/* 219 */       ("-1".equals(this.lnpBonusInfoSchema.getCutPayAll().trim()))) {
/* 220 */       this.message = " \uFFFD\uFFFD\u0461\uFFFD\uFFFD\uFFFD\uEF7B\uFFFD\u5C63\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0671\uFFFD\uFFFD\u68E1";
/* 221 */       return false;
/*     */     }
/* 223 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPBonusInfoSchema getLnpBonusInfoSchema()
/*     */   {
/* 228 */     return this.lnpBonusInfoSchema;
/*     */   }
/*     */ 
/*     */   public void setLnpBonusInfoSchema(LNPBonusInfoSchema lnpBonusInfoSchema)
/*     */   {
/* 233 */     this.lnpBonusInfoSchema = lnpBonusInfoSchema;
/*     */   }
/*     */ 
/*     */   public String getMessage()
/*     */   {
/* 238 */     return this.message;
/*     */   }
/*     */ 
/*     */   public void setMessage(String message)
/*     */   {
/* 243 */     this.message = message;
/*     */   }
/*     */ 
/*     */   public boolean isEditFlag()
/*     */   {
/* 248 */     return this.editFlag;
/*     */   }
/*     */ 
/*     */   public void setEditFlag(boolean editFlag)
/*     */   {
/* 253 */     this.editFlag = editFlag;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getBonusAndPayTypeList()
/*     */   {
/* 260 */     if (this.bonusAndPayTypeList != null) {
/* 261 */       this.bonusAndPayTypeList.clear();
/*     */     }
/* 263 */     this.bonusAndPayTypeList = getBonusAndPayTypeListList("bonusAndPayType", this.contNo);
/* 264 */     return this.bonusAndPayTypeList;
/*     */   }
/*     */ 
/*     */   public void setBonusAndPayTypeList(List<SelectItem> bonusAndPayTypeList)
/*     */   {
/* 269 */     this.bonusAndPayTypeList = bonusAndPayTypeList;
/*     */   }
/*     */ 
/*     */   public boolean isHasBonusAndPaytag()
/*     */   {
/* 274 */     return this.hasBonusAndPaytag;
/*     */   }
/*     */ 
/*     */   public void setHasBonusAndPaytag(boolean hasBonusAndPaytag)
/*     */   {
/* 279 */     this.hasBonusAndPaytag = hasBonusAndPaytag;
/*     */   }
/*     */ 
/*     */   public void setFrontalClearedTypeList(List<SelectItem> frontalClearedTypeList)
/*     */   {
/* 284 */     this.frontalClearedTypeList = frontalClearedTypeList;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getFrontalClearedTypeList()
/*     */   {
/* 291 */     if (this.frontalClearedTypeList != null) {
/* 292 */       this.frontalClearedTypeList.clear();
/*     */     }
/* 294 */     this.frontalClearedTypeList = getFrontalClearedTypeListList("frontalClearedType", this.contNo);
/* 295 */     return this.frontalClearedTypeList;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.BonusAndPayInfo
 * JD-Core Version:    0.6.0
 */