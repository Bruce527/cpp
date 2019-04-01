/*     */ package com.sinosoft.banklns.lnsmodel;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPPolSchema;
/*     */ import com.sinosoft.banklns.utility.ExeSQL;
/*     */ import com.sinosoft.banklns.utility.SSRS;
/*     */ import java.io.PrintStream;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class LNPPolBean
/*     */ {
/*  16 */   private LNPPolSchema schema = new LNPPolSchema();
/*     */   private String amntMoney;
/*     */   private String premMoney;
/*     */   private String riskName;
/*  21 */   private static DecimalFormat formatMoney = new DecimalFormat("#,##0.00");
/*     */ 
/*  23 */   private static Map<String, String> mappRiskNames = new HashMap();
/*     */ 
/*     */   static
/*     */   {
/*  41 */     mappRiskNames();
/*     */   }
/*     */ 
/*     */   private String turnNullToString(Object object)
/*     */   {
/*  31 */     String rst = "";
/*     */     try {
/*  33 */       rst = object;
/*     */     } catch (Exception e) {
/*  35 */       e.printStackTrace();
/*     */     }
/*  37 */     return rst.trim();
/*     */   }
/*     */ 
/*     */   private static void mappRiskNames()
/*     */   {
/*  45 */     mappRiskNames.clear();
/*  46 */     ExeSQL tExeSQL = new ExeSQL();
/*  47 */     String sql = "select riskcode,RiskName from mdes_dicode";
/*  48 */     SSRS tSRS = tExeSQL.execSQL(sql);
/*  49 */     for (int i = 1; i <= tSRS.MaxRow; i++)
/*  50 */       mappRiskNames.put(tSRS.GetText(i, 1), tSRS.GetText(i, 2));
/*     */   }
/*     */ 
/*     */   private String getRiskName(String riskCode)
/*     */   {
/*  55 */     System.out.println("--------" + riskCode);
/*     */     try {
/*  57 */       if ((!turnNullToString(riskCode).equals("")) && (!mappRiskNames.containsKey(riskCode))) {
/*  58 */         mappRiskNames();
/*     */       }
/*  60 */       return (String)mappRiskNames.get(riskCode);
/*     */     }
/*     */     catch (Exception localException) {
/*     */     }
/*  64 */     return "";
/*     */   }
/*     */ 
/*     */   public void setSchema(LNPPolSchema schema, String vRiskType) {
/*  68 */     if ("Z".equals(vRiskType)) {
/*  69 */       if (("A".equals(schema.getPremToAmnt())) && (!"106".equals(schema.getPayLocation()))) {
/*  70 */         schema.setInsuYearFlag("\u81F3" + schema.getPayLocation() + "\u5C81");
/*     */       }
/*  72 */       if (("A".equals(schema.getPremToAmnt())) && ("106".equals(schema.getPayLocation()))) {
/*  73 */         schema.setInsuYearFlag("\u7EC8\u8EAB");
/*     */       }
/*  75 */       if ("Y".equals(schema.getPremToAmnt())) {
/*  76 */         schema.setInsuYearFlag("\u4FDD\u969C" + schema.getPayLocation() + "\u5E74");
/*     */       }
/*  78 */       if ("A".equals(schema.getAcciYearFlag())) {
/*  79 */         schema.setPayEndYearFlag("\u81F3" + schema.getPayMode() + "\u5C81");
/*     */       }
/*  81 */       if (("Y".equals(schema.getAcciYearFlag())) && ("1000".equals(schema.getPayMode()))) {
/*  82 */         schema.setPayEndYearFlag("\u8DB8\u4EA4");
/*     */       }
/*  84 */       if (("Y".equals(schema.getAcciYearFlag())) && (!"1000".equals(schema.getPayMode()))) {
/*  85 */         schema.setPayEndYearFlag("\u7F34\u8D39" + schema.getPayMode() + "\u5E74");
/*     */       }
/*     */     }
/*  88 */     else if ("N".equals(vRiskType)) {
/*  89 */       if (("A".equals(schema.getPremToAmnt())) && (!schema.getPayLocation().equals(String.valueOf(SpecialProductFun.getRiskPro(schema.getRiskCode()))))) {
/*  90 */         schema.setInsuYearFlag("\u81F3" + schema.getPayLocation() + "\u5C81");
/*     */       }
/*  92 */       if (("A".equals(schema.getPremToAmnt())) && (schema.getPayLocation().equals(String.valueOf(SpecialProductFun.getRiskPro(schema.getRiskCode()))))) {
/*  93 */         schema.setInsuYearFlag("\u7EC8\u8EAB");
/*     */       }
/*  95 */       if ("Y".equals(schema.getPremToAmnt())) {
/*  96 */         schema.setInsuYearFlag("\u4FDD\u969C" + schema.getPayLocation() + "\u5E74");
/*     */       }
/*  98 */       if ("A".equals(schema.getAcciYearFlag())) {
/*  99 */         schema.setPayEndYearFlag("\u81F3" + schema.getPayMode() + "\u5C81");
/*     */       }
/* 101 */       if (("Y".equals(schema.getAcciYearFlag())) && ("1000".equals(schema.getPayMode()))) {
/* 102 */         schema.setPayEndYearFlag("\u8DB8\u4EA4");
/*     */       }
/* 104 */       if (("Y".equals(schema.getAcciYearFlag())) && (!"1000".equals(schema.getPayMode())))
/* 105 */         schema.setPayEndYearFlag("\u7F34\u8D39" + schema.getPayMode() + "\u5E74");
/*     */     }
/*     */     else
/*     */     {
/* 109 */       if (("A".equals(schema.getInsuYearFlag())) && (schema.getInsuYear() != SpecialProductFun.getRiskPro(schema.getRiskCode()))) {
/* 110 */         schema.setInsuYearFlag("\u81F3" + schema.getInsuYear() + "\u5C81");
/*     */       }
/* 112 */       if (("A".equals(schema.getInsuYearFlag())) && (schema.getInsuYear() == SpecialProductFun.getRiskPro(schema.getRiskCode()))) {
/* 113 */         schema.setInsuYearFlag("\u7EC8\u8EAB");
/*     */       }
/* 115 */       if ("Y".equals(schema.getInsuYearFlag())) {
/* 116 */         schema.setInsuYearFlag("\u4FDD\u969C" + schema.getInsuYear() + "\u5E74");
/*     */       }
/* 118 */       if ("A".equals(schema.getPayEndYearFlag())) {
/* 119 */         schema.setPayEndYearFlag("\u81F3" + schema.getPayEndYear() + "\u5C81");
/*     */       }
/* 121 */       if (("Y".equals(schema.getPayEndYearFlag())) && (schema.getPayEndYear() == 1000)) {
/* 122 */         schema.setPayEndYearFlag("\u8DB8\u4EA4");
/*     */       }
/* 124 */       if (("Y".equals(schema.getPayEndYearFlag())) && (schema.getPayEndYear() != 1000)) {
/* 125 */         schema.setPayEndYearFlag("\u7F34\u8D39" + schema.getPayEndYear() + "\u5E74");
/*     */       }
/*     */     }
/*     */ 
/* 129 */     if (schema.getPayIntv() == 1) {
/* 130 */       schema.setRemark("\u5E74\u4EA4");
/*     */     }
/* 132 */     if (schema.getPayIntv() == 2) {
/* 133 */       schema.setRemark("\u534A\u5E74\u4EA4");
/*     */     }
/* 135 */     if (schema.getPayIntv() == 3) {
/* 136 */       schema.setRemark("\u5B63\u4EA4");
/*     */     }
/* 138 */     if (schema.getPayIntv() == 4) {
/* 139 */       schema.setRemark("\u6708\u4EA4");
/*     */     }
/* 141 */     if (schema.getPayIntv() == 5) {
/* 142 */       schema.setRemark("\u4E00\u6B21\u6027");
/*     */     }
/* 144 */     this.schema = schema;
/*     */   }
/*     */ 
/*     */   public String getAmntMoney() {
/* 148 */     return formatMoney.format(this.schema.getAmnt());
/*     */   }
/*     */ 
/*     */   public void setAmntMoney(String amntMoney) {
/* 152 */     this.amntMoney = amntMoney;
/*     */   }
/*     */ 
/*     */   public String getPremMoney() {
/* 156 */     return formatMoney.format(this.schema.getPrem());
/*     */   }
/*     */ 
/*     */   public void setPremMoney(String premMoney) {
/* 160 */     this.premMoney = premMoney;
/*     */   }
/*     */ 
/*     */   public LNPPolSchema getSchema() {
/* 164 */     return this.schema;
/*     */   }
/*     */ 
/*     */   public String getRiskName() {
/* 168 */     return getRiskName(this.schema.getRiskCode());
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.LNPPolBean
 * JD-Core Version:    0.6.0
 */