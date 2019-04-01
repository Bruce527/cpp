/*    */ package com.sinosoft.banklns.lnsmodel.entity;
/*    */ 
/*    */ import com.sinosoft.banklns.lis.schema.LNPBnfSchema;
/*    */ 
/*    */ public class LNPBnfBean
/*    */ {
/*    */   private LNPBnfSchema schema;
/*    */   private String gender;
/*    */   private String idType;
/*    */   private String relationToInsured;
/*    */   private String benefitRate;
/*    */   private String listEditFlag;
/*    */ 
/*    */   public LNPBnfSchema getSchema()
/*    */   {
/* 26 */     return this.schema;
/*    */   }
/*    */   public void setSchema(LNPBnfSchema schema) {
/* 29 */     this.schema = schema;
/*    */   }
/*    */   public String getGender() {
/* 32 */     return this.gender;
/*    */   }
/*    */   public void setGender(String gender) {
/* 35 */     this.gender = gender;
/*    */   }
/*    */   public String getIdType() {
/* 38 */     return this.idType;
/*    */   }
/*    */   public void setIdType(String idType) {
/* 41 */     this.idType = idType;
/*    */   }
/*    */   public String getRelationToInsured() {
/* 44 */     return this.relationToInsured;
/*    */   }
/*    */   public void setRelationToInsured(String relationToInsured) {
/* 47 */     this.relationToInsured = relationToInsured;
/*    */   }
/*    */   public String getBenefitRate() {
/* 50 */     return this.benefitRate;
/*    */   }
/*    */   public void setBenefitRate(String benefitRate) {
/* 53 */     this.benefitRate = benefitRate;
/*    */   }
/*    */   public String getListEditFlag() {
/* 56 */     return this.listEditFlag;
/*    */   }
/*    */   public void setListEditFlag(String listEditFlag) {
/* 59 */     this.listEditFlag = listEditFlag;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.entity.LNPBnfBean
 * JD-Core Version:    0.6.0
 */