/*     */ package com.sinosoft.banklns.lnsmodel.util;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPInsuredSchema;
/*     */ import com.sinosoft.banklns.lis.schema.LNPRiskSchema;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class SugError
/*     */ {
/*  16 */   private LNPContSchema sugInfo = null;
/*     */ 
/*  19 */   private List insuErrorList = new ArrayList();
/*     */ 
/*     */   public boolean hasError()
/*     */   {
/*  23 */     boolean flag = false;
/*  24 */     if ((this.insuErrorList != null) && (this.insuErrorList.size() > 0)) {
/*  25 */       flag = true;
/*     */     }
/*  27 */     return flag;
/*     */   }
/*     */ 
/*     */   public List getInsuErrorList()
/*     */   {
/*  32 */     return this.insuErrorList;
/*     */   }
/*     */ 
/*     */   public void addInsuError(InsuError insuError)
/*     */   {
/*  37 */     List errorList = insuError.getRiskErrorList();
/*  38 */     LNPInsuredSchema tempLNPInsuredSchema = insuError.getInsuInfo();
/*  39 */     if ((insuError != null) && (errorList != null) && (errorList.size() > 0)) {
/*  40 */       String insuno = tempLNPInsuredSchema.getInsuredNo();
/*  41 */       for (int i = 0; (this.insuErrorList != null) && (i < this.insuErrorList.size()); i++) {
/*  42 */         if (((InsuError)this.insuErrorList.get(i)).getInsuInfo().equals(insuno)) {
/*     */           break;
/*     */         }
/*     */       }
/*  46 */       this.insuErrorList.add(insuError);
/*     */     }
/*     */   }
/*     */ 
/*     */   public LNPContSchema getSugInfo()
/*     */   {
/*  53 */     return this.sugInfo;
/*     */   }
/*     */ 
/*     */   public void setSugInfo(LNPContSchema sugInfo)
/*     */   {
/*  58 */     this.sugInfo = sugInfo;
/*     */   }
/*     */ 
/*     */   public String makeErrorHTML()
/*     */   {
/*  63 */     StringBuffer sb = new StringBuffer();
/*  64 */     if (hasError()) {
/*  65 */       for (int i = 0; i < this.insuErrorList.size(); i++) {
/*  66 */         InsuError reInsuError = null;
/*  67 */         reInsuError = (InsuError)this.insuErrorList.get(i);
/*  68 */         LNPInsuredSchema tempLNPInsuredSchema = reInsuError.getInsuInfo();
/*  69 */         sb.append("<table width='100%' border='0' cellpadding='0' cellspacing='2' bgcolor='#FFFFFF'><tr><td width='100' align='center' valign='middle' bgcolor='#F4FFF4' style='font-family:Courier New;font-size:12px;color:#00CC99;'><strong>" + 
/*  71 */           tempLNPInsuredSchema.getName() + "</strong></td><td align='left' valign='top' bgcolor='#FFFFFF'>");
/*  72 */         List riskErrorList = reInsuError.getRiskErrorList();
/*  73 */         for (int j = 0; (riskErrorList != null) && (riskErrorList.size() > j); j++) {
/*  74 */           RiskError reRiskError = (RiskError)riskErrorList.get(j);
/*  75 */           LNPRiskSchema reLNPRiskSchema = reRiskError.getRiskInfo();
/*  76 */           sb.append("<table width='100%' border='0' cellspacing='2' cellpadding='0'>");
/*  77 */           sb.append("<tr>");
/*  78 */           String riskName = reLNPRiskSchema.getRiskName();
/*  79 */           String riskCode = reLNPRiskSchema.getRiskCode();
/*  80 */           sb.append("<td width='150' align='center' valign='middle' bgcolor='#F4FFF4' style='color: #3399FF;\tfont-size: 12px;font-weight: normal;'>[" + riskCode + "] " + riskName + "</td>");
/*  81 */           sb.append("<td bgcolor='#F4FFF4' class='hei'><table width='100%' border='0' cellspacing='2' cellpadding='0'>");
/*  82 */           Set set = reRiskError.getRiskError();
/*  83 */           Iterator iterator = set.iterator();
/*  84 */           while (iterator.hasNext()) {
/*  85 */             String error = iterator.next().toString();
/*  86 */             sb.append("<tr><td bgcolor='#F4FFF4' style='color: #4F4F4F ;font-size: 12px; font-weight: normal; font-family: Courier New;'>" + error + "</td></tr>");
/*     */           }
/*  88 */           sb.append("</table></td>");
/*  89 */           sb.append("</tr>");
/*  90 */           sb.append("</table>");
/*     */         }
/*  92 */         sb.append("</td></tr></table>");
/*     */       }
/*     */     }
/*  95 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public String makeErrorStr() {
/*  99 */     StringBuffer sb = new StringBuffer();
/* 100 */     if (hasError()) {
/* 101 */       for (int i = 0; i < this.insuErrorList.size(); i++) {
/* 102 */         InsuError reInsuError = null;
/* 103 */         reInsuError = (InsuError)this.insuErrorList.get(i);
/* 104 */         LNPInsuredSchema tempLNPInsuredSchema = reInsuError.getInsuInfo();
/* 105 */         sb.append("Lname" + tempLNPInsuredSchema.getName() + "@pnc");
/* 106 */         List riskErrorList = reInsuError.getRiskErrorList();
/* 107 */         for (int j = 0; (riskErrorList != null) && (riskErrorList.size() > j); j++) {
/* 108 */           RiskError reRiskError = (RiskError)riskErrorList.get(j);
/* 109 */           LNPRiskSchema reLNPRiskSchema = reRiskError.getRiskInfo();
/* 110 */           String riskName = reLNPRiskSchema.getRiskName();
/* 111 */           String riskCode = reLNPRiskSchema.getRiskCode();
/* 112 */           if (j > 0) {
/* 113 */             sb.append("pname");
/*     */           }
/* 115 */           sb.append("[" + riskCode + "] " + riskName + "@n");
/* 116 */           Set set = reRiskError.getRiskError();
/* 117 */           Iterator iterator = set.iterator();
/* 118 */           while (iterator.hasNext()) {
/* 119 */             String error = iterator.next().toString();
/* 120 */             sb.append(error + "<br>");
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 125 */     return sb.toString();
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.util.SugError
 * JD-Core Version:    0.6.0
 */