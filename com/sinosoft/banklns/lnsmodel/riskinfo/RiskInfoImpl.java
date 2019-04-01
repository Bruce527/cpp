/*     */ package com.sinosoft.banklns.lnsmodel.riskinfo;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPCodeDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPRiskDB;
/*     */ import com.sinosoft.banklns.lis.db.LNPStaticMsgUrlDB;
/*     */ import com.sinosoft.banklns.lis.schema.LNPCodeSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPRiskSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPStaticMsgUrlSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPCodeSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPRiskSet;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPStaticMsgUrlSet;
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public class RiskInfoImpl
/*     */ {
/*     */   private String getHost()
/*     */   {
/*  19 */     String sHost = "";
/*  20 */     LNPStaticMsgUrlSet LNPStaticMsgUrlSet = new LNPStaticMsgUrlDB().executeQuery("select * from LNPStaticMsgUrl where assurancecode='riskinfo'");
/*  21 */     if (LNPStaticMsgUrlSet != null) {
/*  22 */       for (int m = 1; m <= LNPStaticMsgUrlSet.size(); m++) {
/*  23 */         LNPStaticMsgUrlSchema staticMsgSchema = LNPStaticMsgUrlSet.get(m);
/*  24 */         sHost = staticMsgSchema.getMsgUrl();
/*     */       }
/*     */     }
/*  27 */     return sHost;
/*     */   }
/*     */ 
/*     */   public String getDocument(String riskName)
/*     */   {
/*  33 */     String result = null;
/*  34 */     if (riskName.equals("0"))
/*  35 */       result = "0=\u8BF7\u5148\u9009\u62E9\u9669\u79CD\u540D";
/*     */     else
/*  37 */       result = "0=\u8BF7\u9009\u62E9\u6587\u6863\u7C7B\u578B";
/*  38 */     String sHost = getHost();
/*  39 */     LNPStaticMsgUrlSet LNPStaticMsgUrlSet = new LNPStaticMsgUrlDB().executeQuery("select * from LNPStaticMsgUrl where assurancecode='" + riskName + "' order by flag");
/*  40 */     if (LNPStaticMsgUrlSet != null) {
/*  41 */       for (int m = 1; m <= LNPStaticMsgUrlSet.size(); m++) {
/*  42 */         if (!result.equals("")) result = result + "&";
/*  43 */         LNPStaticMsgUrlSchema staticMsgSchema = LNPStaticMsgUrlSet.get(m);
/*  44 */         String sURL = staticMsgSchema.getMsgUrl();
/*  45 */         if (!sHost.equals("")) {
/*  46 */           sURL = sURL.replace("..", sHost);
/*     */         }
/*  48 */         if (staticMsgSchema.getFlag().equals("1"))
/*  49 */           result = result + sURL + "=\u6761\u6B3E";
/*  50 */         else if (staticMsgSchema.getFlag().equals("2"))
/*  51 */           result = result + sURL + "=\u8D39\u7387";
/*  52 */         else if (staticMsgSchema.getFlag().equals("3")) {
/*  53 */           result = result + sURL + "=\u89C4\u5219";
/*     */         }
/*     */       }
/*     */     }
/*  57 */     return result;
/*     */   }
/*     */ 
/*     */   public String getAllRiskType(String channel)
/*     */   {
/*  63 */     String result = "every=\u6240\u6709\u9669\u79CD";
/*  64 */     String sql = "Select * From lnpcode where codetype='RiskType' and code in (select distinct riskprop from lnpriskapp where  riskcode in (select riskcode from lnpriskcomctrl where salechnl='" + 
/*  69 */       channel + "'))" + 
/*  70 */       " order by code";
/*  71 */     LNPCodeSet ldCodeSet = new LNPCodeDB().executeQuery(sql);
/*  72 */     if (ldCodeSet != null) {
/*  73 */       for (int i = 1; i <= ldCodeSet.size(); i++) {
/*  74 */         LNPCodeSchema ldcodeSchema = ldCodeSet.get(i);
/*     */ 
/*  76 */         if (!result.equals("")) result = result + "&";
/*  77 */         result = result + ldcodeSchema.getCode() + "=" + ldcodeSchema.getCodeName();
/*     */       }
/*  79 */       String lmRiskAppSet = getAllSubRisk(channel);
/*  80 */       if ((lmRiskAppSet != null) && (!lmRiskAppSet.equals("0=\u8BF7\u9009\u62E9\u9669\u79CD"))) {
/*  81 */         result = result + "&addition=\u9644\u52A0\u9669";
/*     */       }
/*  83 */       return result;
/*     */     }
/*  85 */     System.out.println("\u67E5\u8BE2\u6240\u6709\u9669\u79CD,\u6570\u636E\u83B7\u53D6\u5931\u8D25");
/*  86 */     return null;
/*     */   }
/*     */ 
/*     */   public String getAllSubRisk(String channel)
/*     */   {
/* 100 */     String sql = "select *  from lmrisk where riskcode in (  select riskcode  from lmriskapp where  riskcode in (select riskcode from lmriskcomctrl where salechnl='" + 
/* 105 */       channel + "')" + 
/* 106 */       " and subriskflag='S')" + 
/* 107 */       " order by riskcode";
/* 108 */     System.out.println(sql);
/* 109 */     LNPRiskSet setLMRisk = new LNPRiskDB().executeQuery(sql);
/*     */ 
/* 111 */     if (setLMRisk != null) {
/* 112 */       String result = "0=\u8BF7\u9009\u62E9\u9669\u79CD";
/* 113 */       for (int i = 1; i <= setLMRisk.size(); i++) {
/* 114 */         LNPRiskSchema lmRiskSchema = setLMRisk.get(i);
/* 115 */         if (!result.equals("")) result = result + "&";
/* 116 */         result = result + lmRiskSchema.getRiskCode() + "=[" + lmRiskSchema.getRiskCode() + "]" + lmRiskSchema.getRiskShortName();
/*     */       }
/* 118 */       return result;
/*     */     }
/* 120 */     System.out.println("\u67E5\u8BE2\u6240\u6709\u9644\u52A0\u9669,\u6570\u636E\u83B7\u53D6\u5931\u8D25");
/* 121 */     return null;
/*     */   }
/*     */ 
/*     */   public String getAllRiskKind(String channel)
/*     */   {
/* 135 */     String sql = "select *  from lmrisk where riskcode in (  select riskcode  from lmriskapp where  riskcode in (select riskcode from lmriskcomctrl where salechnl='" + 
/* 140 */       channel + "'))" + 
/* 141 */       " order by riskcode";
/* 142 */     System.out.println(sql);
/* 143 */     LNPRiskSet setLMRisk = new LNPRiskDB().executeQuery(sql);
/* 144 */     if (setLMRisk != null) {
/* 145 */       String result = "0=\u8BF7\u9009\u62E9\u9669\u79CD";
/* 146 */       for (int i = 1; i <= setLMRisk.size(); i++) {
/* 147 */         LNPRiskSchema lmRiskSchema = setLMRisk.get(i);
/* 148 */         if (!result.equals("")) result = result + "&";
/* 149 */         result = result + lmRiskSchema.getRiskCode() + "=[" + lmRiskSchema.getRiskCode() + "]" + lmRiskSchema.getRiskShortName();
/*     */       }
/* 151 */       return result;
/*     */     }
/* 153 */     System.out.println("\u67E5\u8BE2\u6240\u6709\u9669\u79CD,\u6570\u636E\u83B7\u53D6\u5931\u8D25");
/* 154 */     return null;
/*     */   }
/*     */ 
/*     */   public String getChosenRiskKind(String riskType, String channel)
/*     */   {
/* 167 */     String sql = "select *  from lmrisk where riskcode in (  select riskcode  from lmriskapp where  riskcode in (select riskcode from lmriskcomctrl where salechnl='" + 
/* 172 */       channel + "')" + 
/* 173 */       " and riskprop='" + riskType + "')" + 
/* 174 */       " order by riskcode";
/* 175 */     System.out.println(sql);
/* 176 */     LNPRiskSet setLMRisk = new LNPRiskDB().executeQuery(sql);
/* 177 */     if (setLMRisk != null) {
/* 178 */       String result = "0=\u8BF7\u9009\u62E9\u9669\u79CD";
/* 179 */       for (int i = 1; i <= setLMRisk.size(); i++) {
/* 180 */         LNPRiskSchema lmRiskSchema = setLMRisk.get(i);
/* 181 */         if (!result.equals("")) result = result + "&";
/* 182 */         result = result + lmRiskSchema.getRiskCode() + "=[" + lmRiskSchema.getRiskCode() + "]" + lmRiskSchema.getRiskShortName();
/*     */       }
/* 184 */       return result;
/*     */     }
/* 186 */     System.out.println("\u67E5\u8BE2\u9669\u79CD\u7C7B\u578B" + riskType + ",\u6570\u636E\u83B7\u53D6\u5931\u8D25");
/* 187 */     return null;
/*     */   }
/*     */ 
/*     */   public String getDocument(String riskName, String documentType)
/*     */   {
/* 193 */     String sHost = getHost();
/* 194 */     LNPStaticMsgUrlSet LNPStaticMsgUrlSet = new LNPStaticMsgUrlDB().executeQuery("select * from LNPStaticMsgUrl where assurancecode='" + riskName + "' and flag='" + documentType + "'");
/* 195 */     if (LNPStaticMsgUrlSet != null) {
/* 196 */       String result = "";
/* 197 */       for (int m = 1; m <= LNPStaticMsgUrlSet.size(); m++) {
/* 198 */         LNPStaticMsgUrlSchema staticMsgSchema = LNPStaticMsgUrlSet.get(m);
/* 199 */         if (!result.equals("")) result = result + "&";
/* 200 */         String sURL = staticMsgSchema.getMsgUrl();
/* 201 */         if (!sHost.equals("")) {
/* 202 */           sURL = sURL.replace("..", sHost);
/*     */         }
/* 204 */         if (staticMsgSchema.getFlag().equals("1"))
/* 205 */           result = result + sURL + "=\u6761\u6B3E";
/* 206 */         else if (staticMsgSchema.getFlag().equals("2"))
/* 207 */           result = result + sURL + "=\u8D39\u7387";
/* 208 */         else if (staticMsgSchema.getFlag().equals("3")) {
/* 209 */           result = result + sURL + "=\u89C4\u5219";
/*     */         }
/*     */       }
/* 212 */       return result;
/*     */     }
/* 214 */     System.out.println("\u67E5\u4E0D\u5230\u8BE5\u9669\u79CD\u53F7:" + riskName + "\u8BE5\u6587\u6863\u7C7B\u578B" + documentType + "\u5BF9\u5E94\u7684\u6587\u6863\u6D88\u606F");
/* 215 */     return null;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.riskinfo.RiskInfoImpl
 * JD-Core Version:    0.6.0
 */