/*     */ package com.sinosoft.banklns.lnsmodel;
/*     */ 
/*     */ public class RiskTableBean
/*     */ {
/*   6 */   private String riskname = "";
/*     */ 
/*   8 */   private String amntmult = "";
/*     */ 
/*  10 */   private String payintv = "";
/*     */ 
/*  12 */   private String insuyear = "";
/*     */ 
/*  14 */   private String payendyear = "";
/*     */ 
/*  16 */   private String prem = "";
/*     */ 
/*  18 */   private String serialNo = "";
/*     */ 
/*  20 */   private String polno = "";
/*     */   private String listEditFlag;
/*     */ 
/*     */   public String getListEditFlag()
/*     */   {
/*  26 */     return this.listEditFlag;
/*     */   }
/*     */ 
/*     */   public void setListEditFlag(String listEditFlag) {
/*  30 */     this.listEditFlag = listEditFlag;
/*     */   }
/*     */ 
/*     */   public RiskTableBean()
/*     */   {
/*     */   }
/*     */ 
/*     */   public RiskTableBean(String riskname, String amntmult, String payintv, String insuyear, String payendyear, String prem, String serialNo, String polno, String listEditFlag)
/*     */   {
/*  41 */     this.riskname = riskname;
/*  42 */     this.amntmult = amntmult;
/*  43 */     this.payintv = payintv;
/*  44 */     this.insuyear = insuyear;
/*  45 */     this.payendyear = payendyear;
/*  46 */     this.prem = prem;
/*  47 */     this.serialNo = serialNo;
/*  48 */     this.polno = polno;
/*  49 */     this.listEditFlag = listEditFlag;
/*     */   }
/*     */ 
/*     */   public String getAmntmult()
/*     */   {
/*  56 */     return this.amntmult;
/*     */   }
/*     */ 
/*     */   public void setAmntmult(String amntmult) {
/*  60 */     this.amntmult = amntmult;
/*     */   }
/*     */ 
/*     */   public String getInsuyear() {
/*  64 */     return this.insuyear;
/*     */   }
/*     */ 
/*     */   public void setInsuyear(String insuyear) {
/*  68 */     this.insuyear = insuyear;
/*     */   }
/*     */ 
/*     */   public String getPayendyear() {
/*  72 */     return this.payendyear;
/*     */   }
/*     */ 
/*     */   public void setPayendyear(String payendyear) {
/*  76 */     this.payendyear = payendyear;
/*     */   }
/*     */ 
/*     */   public String getPayintv() {
/*  80 */     return this.payintv;
/*     */   }
/*     */ 
/*     */   public void setPayintv(String payintv) {
/*  84 */     this.payintv = payintv;
/*     */   }
/*     */ 
/*     */   public String getPolno() {
/*  88 */     return this.polno;
/*     */   }
/*     */ 
/*     */   public void setPolno(String polno) {
/*  92 */     this.polno = polno;
/*     */   }
/*     */ 
/*     */   public String getPrem() {
/*  96 */     return this.prem;
/*     */   }
/*     */ 
/*     */   public void setPrem(String prem) {
/* 100 */     this.prem = prem;
/*     */   }
/*     */ 
/*     */   public String getRiskname() {
/* 104 */     return this.riskname;
/*     */   }
/*     */ 
/*     */   public void setRiskname(String riskname) {
/* 108 */     this.riskname = riskname;
/*     */   }
/*     */ 
/*     */   public String getSerialNo() {
/* 112 */     return this.serialNo;
/*     */   }
/*     */ 
/*     */   public void setSerialNo(String serialNo) {
/* 116 */     this.serialNo = serialNo;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.RiskTableBean
 * JD-Core Version:    0.6.0
 */