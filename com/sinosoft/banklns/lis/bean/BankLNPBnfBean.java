/*     */ package com.sinosoft.banklns.lis.bean;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.db.LNPBnfDB;
/*     */ import com.sinosoft.banklns.lis.schema.LNPBnfSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPBnfSet;
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public class BankLNPBnfBean extends BankBeanBasic
/*     */ {
/*  15 */   private LNPBnfSchema schema = new LNPBnfSchema();
/*     */   private String gender;
/*     */   private String idType;
/*     */   private String relationToInsured;
/*     */   private String benefitRate;
/*     */   private String IDVaility;
/*     */   private String birthday;
/*     */   private String bnfNative;
/*     */   private boolean isValidate;
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*   8 */     BankLNPBnfBean bean = new BankLNPBnfBean();
/*   9 */     LNPBnfDB db = new LNPBnfDB();
/*  10 */     db.setBnfId("00000000000000000300");
/*  11 */     bean.schema = db.query().get(1);
/*     */ 
/*  13 */     System.out.println(bean.isValidate());
/*     */   }
/*     */ 
/*     */   public boolean isValidate()
/*     */   {
/*  34 */     System.out.println((this.schema.getBnfName() != null) && (!"".equals(this.schema.getBnfName().trim())));
/*  35 */     System.out.println((this.schema.getRelationToInsured() != null) && (!"".equals(this.schema.getRelationToInsured().trim())) && (!"-1".equals(this.schema.getRelationToInsured().trim())));
/*  36 */     System.out.println(this.schema.getBenefitRate() > 0.0D);
/*  37 */     if (((this.schema.getBnfName() != null) && (!"".equals(this.schema.getBnfName().trim()))) || 
/*  38 */       ((this.schema.getRelationToInsured() != null) && (!"".equals(this.schema.getRelationToInsured().trim())) && (!"-1".equals(this.schema.getRelationToInsured().trim()))) || 
/*  40 */       (this.schema.getBenefitRate() > 0.0D))
/*     */     {
/*  42 */       this.isValidate = true;
/*     */     }
/*  44 */     else this.isValidate = false;
/*     */ 
/*  46 */     return this.isValidate;
/*     */   }
/*     */   public void setValidate(boolean isValidate) {
/*  49 */     this.isValidate = isValidate;
/*     */   }
/*     */   public LNPBnfSchema getSchema() {
/*  52 */     return this.schema;
/*     */   }
/*     */   public void setSchema(LNPBnfSchema schema) {
/*  55 */     this.schema = schema;
/*     */   }
/*     */   public String getGender() {
/*  58 */     return this.gender;
/*     */   }
/*     */   public void setGender(String gender) {
/*  61 */     this.gender = gender;
/*     */   }
/*     */   public String getIdType() {
/*  64 */     return this.idType;
/*     */   }
/*     */   public void setIdType(String idType) {
/*  67 */     this.idType = idType;
/*     */   }
/*     */   public String getRelationToInsured() {
/*  70 */     return this.relationToInsured;
/*     */   }
/*     */   public void setRelationToInsured(String relationToInsured) {
/*  73 */     this.relationToInsured = relationToInsured;
/*     */   }
/*     */   public String getBenefitRate() {
/*  76 */     return this.benefitRate;
/*     */   }
/*     */   public void setBenefitRate(String benefitRate) {
/*  79 */     this.benefitRate = benefitRate;
/*     */   }
/*     */   public String getIDVaility() {
/*  82 */     return formatDate(this.schema.getIDValidity(), "YYYYMMDD");
/*     */   }
/*     */   public void setIDVaility(String iDVaility) {
/*  85 */     this.IDVaility = formatDate(iDVaility, "YYYY-MM-DD");
/*  86 */     this.schema.setIDValidity(this.IDVaility);
/*     */   }
/*     */   public String getBirthday() {
/*  89 */     return formatDate(this.schema.getBnfBirthday(), "YYYYMMDD");
/*     */   }
/*     */   public void setBirthday(String birthday) {
/*  92 */     this.birthday = formatDate(birthday, "YYYY-MM-DD");
/*  93 */     this.schema.setBnfBirthday(this.birthday);
/*     */   }
/*     */ 
/*     */   private String formatDate(String srcDate, String formate)
/*     */   {
/* 104 */     String tDate = srcDate;
/* 105 */     if ((srcDate != null) && (!"".equals(srcDate.trim()))) {
/* 106 */       if (formate.indexOf("-") > 0)
/* 107 */         tDate = srcDate.substring(0, 4) + "-" + srcDate.substring(4, 6) + "-" + srcDate.substring(6, 8);
/*     */       else {
/* 109 */         tDate = srcDate.replaceAll("-", "");
/*     */       }
/*     */     }
/* 112 */     return tDate;
/*     */   }
/*     */ 
/*     */   public String getBnfNative() {
/* 116 */     return this.schema.getNativePlace();
/*     */   }
/*     */   public void setBnfNative(String bnfNative) {
/* 119 */     this.bnfNative = bnfNative;
/* 120 */     this.schema.setNativePlace(bnfNative);
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.bean.BankLNPBnfBean
 * JD-Core Version:    0.6.0
 */