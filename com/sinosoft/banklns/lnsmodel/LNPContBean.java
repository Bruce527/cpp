/*     */ package com.sinosoft.banklns.lnsmodel;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*     */ import com.sinosoft.banklns.utility.ExeSQL;
/*     */ import com.sinosoft.banklns.utility.SSRS;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class LNPContBean
/*     */ {
/*     */   private LNPContSchema schema;
/*     */   private String prem;
/*     */   private String showState;
/*     */   private String netcode;
/*     */   private String riskList;
/*     */   private String signCom;
/*  18 */   private String display = "none";
/*     */ 
/*  20 */   private static Map<String, String> MapSignCom = new HashMap();
/*     */ 
/*     */   static
/*     */   {
/* 162 */     initMapSignManage();
/*     */   }
/*     */ 
/*     */   public String getRiskList()
/*     */   {
/*  40 */     return this.riskList;
/*     */   }
/*     */ 
/*     */   public String getDisplay() {
/*  44 */     return this.display;
/*     */   }
/*     */ 
/*     */   public void setDisplay(String display) {
/*  48 */     this.display = display;
/*     */   }
/*     */ 
/*     */   public static Map<String, String> getMapSignCom() {
/*  52 */     return MapSignCom;
/*     */   }
/*     */ 
/*     */   public static void setMapSignCom(Map<String, String> mapSignCom) {
/*  56 */     MapSignCom = mapSignCom;
/*     */   }
/*     */ 
/*     */   public void setRiskList(String riskList) {
/*  60 */     this.riskList = riskList;
/*     */   }
/*     */ 
/*     */   public String getShowState()
/*     */   {
/* 105 */     return this.showState;
/*     */   }
/*     */ 
/*     */   public void setShowState(String showState) {
/* 109 */     this.showState = showState;
/*     */   }
/*     */ 
/*     */   public LNPContSchema getSchema() {
/* 113 */     return this.schema;
/*     */   }
/*     */ 
/*     */   public void setSchema(LNPContSchema schema) {
/* 117 */     this.schema = schema;
/*     */   }
/*     */ 
/*     */   public String getPrem() {
/* 121 */     return this.schema.getSumPrem();
/*     */   }
/*     */ 
/*     */   public void setPrem(String prem) {
/* 125 */     this.prem = prem;
/*     */   }
/*     */ 
/*     */   public String getNetcode() {
/* 129 */     return this.netcode;
/*     */   }
/*     */ 
/*     */   public void setNetcode(String netcode) {
/* 133 */     this.netcode = netcode;
/*     */   }
/*     */ 
/*     */   public String getSignCom() {
/* 137 */     return getMappingSignCom(this.schema.getSignCom());
/*     */   }
/*     */ 
/*     */   public void setSignCom(String signCom) {
/* 141 */     this.signCom = signCom;
/*     */   }
/*     */ 
/*     */   private String getMappingSignCom(String ComCode) {
/* 145 */     String tCode = ComCode;
/*     */     try {
/* 147 */       if ((tCode != null) && (!"".equals(tCode)))
/* 148 */         if (MapSignCom.containsKey(ComCode)) {
/* 149 */           tCode = (String)MapSignCom.get(ComCode);
/*     */         } else {
/* 151 */           initMapSignManage();
/* 152 */           tCode = (String)MapSignCom.get(ComCode);
/*     */         }
/*     */     }
/*     */     catch (RuntimeException e) {
/* 156 */       e.printStackTrace();
/*     */     }
/* 158 */     return tCode;
/*     */   }
/*     */ 
/*     */   private static void initMapSignManage()
/*     */   {
/* 165 */     MapSignCom.clear();
/* 166 */     String sql = "select code,codename from lnpcode where codetype='lnpManageCom'";
/* 167 */     ExeSQL execSQL = new ExeSQL();
/* 168 */     SSRS ssrs = execSQL.execSQL(sql);
/* 169 */     for (int i = 1; i <= ssrs.MaxRow; i++)
/* 170 */       MapSignCom.put(ssrs.GetText(i, 1), ssrs.GetText(i, 2));
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.LNPContBean
 * JD-Core Version:    0.6.0
 */