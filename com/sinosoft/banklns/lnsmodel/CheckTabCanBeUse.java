/*     */ package com.sinosoft.banklns.lnsmodel;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
/*     */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ public class CheckTabCanBeUse
/*     */ {
/*     */   public String errorMsg;
/*     */ 
/*     */   public List checkAppntTab(String contNo, IGlobalInput tGlobalInput)
/*     */   {
/*  18 */     boolean insuredExistFlag = insuredExist(contNo);
/*  19 */     List list = new ArrayList();
/*  20 */     if (!insuredExistFlag)
/*     */     {
/*  22 */       list.add("\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u00F1\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD");
/*  23 */       list.add(null);
/*     */     }
/*  25 */     return list;
/*     */   }
/*     */ 
/*     */   public List checkBnfTab(String contNo, IGlobalInput tGlobalInput)
/*     */   {
/*  32 */     boolean insuredExistFlag = insuredExist(contNo);
/*  33 */     List list = new ArrayList();
/*  34 */     if (!insuredExistFlag)
/*     */     {
/*  36 */       list.add("\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u00F1\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD");
/*  37 */       list.add(null);
/*     */     }
/*  39 */     return list;
/*     */   }
/*     */ 
/*     */   public List checkDesignRiskTab(String contNo, IGlobalInput tGlobalInput)
/*     */   {
/*  47 */     boolean insuredExistFlag = insuredExist(contNo);
/*  48 */     List list = new ArrayList();
/*  49 */     if (!insuredExistFlag)
/*     */     {
/*  51 */       list.add("\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u00F1\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD");
/*  52 */       list.add(null);
/*     */     }
/*  54 */     boolean appntExistFlag = appntExist(contNo);
/*  55 */     if (!appntExistFlag)
/*     */     {
/*  57 */       list.add("\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u0376\uFFFD\uFFFD\uFFFD\uFFFD");
/*  58 */       list.add(null);
/*     */     }
/*  60 */     return list;
/*     */   }
/*     */ 
/*     */   public List checkBonusTab(String contNo, IGlobalInput tGlobalInput)
/*     */   {
/*  66 */     List list = new ArrayList();
/*  67 */     boolean insuredExistFlag = insuredExist(contNo);
/*  68 */     boolean policyInfoExistFlag = policyExist(contNo);
/*     */ 
/*  70 */     if (!insuredExistFlag) {
/*  71 */       list.add("\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u00F1\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD");
/*  72 */       list.add(null);
/*     */     }
/*     */ 
/*  75 */     if ((insuredExistFlag) && (!policyInfoExistFlag)) {
/*  76 */       list.add("\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u00F1\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD");
/*  77 */       list.add(null);
/*     */     }
/*     */ 
/*  80 */     return list;
/*     */   }
/*     */ 
/*     */   public List checkFAITab(String contNo, IGlobalInput tGlobalInput)
/*     */   {
/*  88 */     boolean insuredExistFlag = insuredExist(contNo);
/*  89 */     List list = new ArrayList();
/*  90 */     if (!insuredExistFlag)
/*     */     {
/*  92 */       list.add("\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u00F1\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD");
/*  93 */       list.add(null);
/*     */     }
/*     */ 
/*  96 */     return list;
/*     */   }
/*     */ 
/*     */   public List checkInsuDiscripTab(String contNo, IGlobalInput tGlobalInput)
/*     */   {
/* 104 */     boolean insuredExistFlag = insuredExist(contNo);
/* 105 */     boolean policyInfoExistFlag = policyExist(contNo);
/* 106 */     List list = new ArrayList();
/* 107 */     if (!insuredExistFlag)
/*     */     {
/* 109 */       list.add("\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u00F1\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD");
/* 110 */       list.add(null);
/*     */     }
/* 112 */     if ((insuredExistFlag) && (!policyInfoExistFlag)) {
/* 113 */       list.add("\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u00F1\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD");
/* 114 */       list.add(null);
/*     */     }
/*     */ 
/* 117 */     return list;
/*     */   }
/*     */ 
/*     */   public List checkAgentInformTab(String contNo, IGlobalInput tGlobalInput)
/*     */   {
/* 124 */     boolean insuredExistFlag = insuredExist(contNo);
/* 125 */     List list = new ArrayList();
/* 126 */     if (!insuredExistFlag)
/*     */     {
/* 128 */       list.add("\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u00F1\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD");
/* 129 */       list.add(null);
/*     */     }
/* 131 */     return list;
/*     */   }
/*     */ 
/*     */   private boolean insuredExist(String contNo) {
/* 135 */     PolicyMainInfo mainInfo = new PolicyMainInfo();
/* 136 */     LNPContSchema lnpSch = mainInfo.getContByContNo(contNo);
/*     */ 
/* 139 */     return (lnpSch.getInsuredId() != null) && (!lnpSch.getInsuredId().equals("")) && (lnpSch.getEditstate().substring(1, 2).equals("1"));
/*     */   }
/*     */ 
/*     */   private boolean appntExist(String contNo)
/*     */   {
/* 147 */     PolicyMainInfo mainInfo = new PolicyMainInfo();
/* 148 */     LNPContSchema lnpSch = mainInfo.getContByContNo(contNo);
/*     */ 
/* 151 */     return (lnpSch.getAppntId() != null) && (!lnpSch.getAppntId().equals("")) && (lnpSch.getEditstate().substring(2, 3).equals("1"));
/*     */   }
/*     */ 
/*     */   private boolean policyExist(String contNo)
/*     */   {
/* 160 */     PolicyMainInfo mainInfo = new PolicyMainInfo();
/* 161 */     String mark = mainInfo.getContByContNo(contNo).getEditstate();
/*     */ 
/* 163 */     String flag = mark.substring(3, 4);
/*     */ 
/* 166 */     return !flag.equals("0");
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.CheckTabCanBeUse
 * JD-Core Version:    0.6.0
 */