/*     */ package com.sinosoft.banklns.lis.pubfun;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPCheckFieldSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPCheckFieldSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.VData;
/*     */ import java.io.PrintStream;
/*     */ import java.lang.reflect.AccessibleObject;
/*     */ import java.lang.reflect.Field;
/*     */ 
/*     */ public class CheckFieldCom
/*     */ {
/*  17 */   public CErrors mErrors = new CErrors();
/*  18 */   private Calculator mCalculator = new Calculator();
/*  19 */   private FieldCarrier mFieldCarrier = new FieldCarrier();
/*  20 */   private LNPCheckFieldSchema mLNPCheckFieldSchema = new LNPCheckFieldSchema();
/*  21 */   private LNPCheckFieldSet mLNPCheckFieldSet = new LNPCheckFieldSet();
/*     */ 
/*     */   private boolean InitData(VData InputData)
/*     */   {
/*  48 */     if (InputData == null)
/*     */     {
/*  50 */       return SetError("InitData", "\u4F20\u5165\u53C2\u6570(VData)\u4E0D\u80FD\u4E3A\u7A7A\uFF01");
/*     */     }
/*  52 */     this.mFieldCarrier = ((FieldCarrier)InputData.getObjectByObjectName(
/*  53 */       "FieldCarrier", 0));
/*  54 */     if (this.mFieldCarrier == null)
/*     */     {
/*  57 */       return SetError("InitData", "\u4F20\u5165\u53C2\u6570(FieldCarrier)\u4E0D\u80FD\u4E3A\u7A7A\uFF01");
/*     */     }
/*  59 */     this.mLNPCheckFieldSchema = 
/*  60 */       ((LNPCheckFieldSchema)InputData
/*  60 */       .getObjectByObjectName("LNPCheckFieldSchema", 0));
/*  61 */     if (this.mLNPCheckFieldSchema == null)
/*     */     {
/*  64 */       return SetError("InitData", "\u4F20\u5165\u53C2\u6570(LNPCheckFieldSchema)\u4E0D\u80FD\u4E3A\u7A7A\uFF01");
/*     */     }
/*     */ 
/*  67 */     return true;
/*     */   }
/*     */ 
/*     */   private boolean SaveFactor()
/*     */   {
/*  73 */     Class ClassOfFieldCarrier = this.mFieldCarrier.getClass();
/*     */ 
/*  75 */     Field[] fields = ClassOfFieldCarrier.getDeclaredFields();
/*     */ 
/*  77 */     AccessibleObject.setAccessible(fields, true);
/*  78 */     for (int n = 0; n < fields.length; n++)
/*     */     {
/*  80 */       String fieldName = fields[n].getName();
/*     */ 
/*  82 */       Class classOfFieldType = fields[n].getType();
/*  83 */       String fieldTypeName = classOfFieldType.getName();
/*  84 */       if (fields[n].isAccessible())
/*     */       {
/*     */         try
/*     */         {
/*  89 */           Object localObject = fields[n].get(this.mFieldCarrier);
/*     */         }
/*     */         catch (Exception ex)
/*     */         {
/*  99 */           System.out.println("\u629B\u51FA\u4F8B\u5916\uFF1A" + ex.toString());
/* 100 */           return SetError("SaveField", ex.toString());
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 105 */         return SetError("SaveField", "\u4F20\u5165\u53C2\u6570\u7684\u5B57\u6BB5" + fieldName + "\u5C5E\u6027\u4E3A\u4E0D\u80FD\u5B58\u53D6\uFF01");
/*     */       }
/*     */     }
/* 108 */     return true;
/*     */   }
/*     */ 
/*     */   public LNPCheckFieldSet GetCheckFieldSet()
/*     */   {
/* 202 */     return this.mLNPCheckFieldSet;
/*     */   }
/*     */ 
/*     */   private boolean SetError(String funName, String errMsg)
/*     */   {
/* 222 */     CError tError = new CError();
/* 223 */     tError.moduleName = "CheckFieldCom";
/* 224 */     tError.functionName = funName;
/* 225 */     tError.errorMessage = errMsg;
/* 226 */     this.mErrors.addOneError(tError);
/* 227 */     return false;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.pubfun.CheckFieldCom
 * JD-Core Version:    0.6.0
 */