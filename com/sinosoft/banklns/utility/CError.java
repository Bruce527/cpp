/*     */ package com.sinosoft.banklns.utility;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.pubfun.PubFun;
/*     */ import java.io.PrintStream;
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.Field;
/*     */ 
/*     */ public class CError
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final String TYPE_NONEERR = "0";
/*     */   public static final String TYPE_FORBID = "1";
/*     */   public static final String TYPE_ALLOW = "2";
/*     */   public static final String TYPE_NEEDSELECT = "3";
/*     */   public static final String TYPE_UNKNOW = "4";
/*     */   public static final String SYSTEM = "10";
/*     */   public static final String COMMUNICATION = "11";
/*     */   public static final String SAFETY = "12";
/*     */   public static final String BL_RISK = "2101";
/*     */   public static final String BL_FINANCE = "2102";
/*     */   public static final String BL_TB = "2103";
/*     */   public static final String BL_BQ = "2104";
/*     */   public static final String BL_CASE = "2105";
/*     */   public static final String BL_LIVEGET = "2106";
/*     */   public static final String BL_AGENT = "2107";
/*     */   public static final String BL_BANK = "2108";
/*     */   public static final String BL_UNKNOW = "2109";
/*     */   public static final String DB_OPERATE = "22";
/*     */   public static final String UNKNOW = "23";
/*     */   public static final String TYPE_NONE = "0";
/*     */   public static final String WS_SERVER_CALL = "02010001";
/*     */   public static final String WS_TRANS_SOAP = "02010002";
/*  40 */   public String errorType = "1";
/*     */ 
/*  42 */   public String errorNo = "23";
/*     */   public String moduleName;
/*     */   public String functionName;
/*     */   public String errorMessage;
/*     */ 
/*     */   public CError()
/*     */   {
/*     */   }
/*     */ 
/*     */   public CError(String errString)
/*     */   {
/*  56 */     this.errorMessage = errString;
/*     */   }
/*     */ 
/*     */   public CError(String errString, String cModuleName, String cFunctionName) {
/*  60 */     this.errorMessage = errString;
/*  61 */     this.moduleName = cModuleName;
/*  62 */     this.functionName = cFunctionName;
/*     */   }
/*     */ 
/*     */   public static void buildErr(Object o, String errMessage)
/*     */   {
/*  67 */     buildErr(o, "", errMessage, "1", "23");
/*     */   }
/*     */ 
/*     */   public static void buildErr(Object o, String errMessage, String errType, String errNo)
/*     */   {
/*  73 */     buildErr(o, "", errMessage.trim(), errType, errNo);
/*     */   }
/*     */ 
/*     */   public static void buildErr(Object o, String functionName, String errMessage, String errType, String errNo)
/*     */   {
/*     */     try
/*     */     {
/*  82 */       CError tError = new CError();
/*  83 */       tError.moduleName = PubFun.getClassFileName(o);
/*  84 */       tError.functionName = functionName;
/*  85 */       tError.errorMessage = errMessage.trim();
/*  86 */       tError.errorType = errType;
/*  87 */       tError.errorNo = errNo;
/*     */ 
/*  89 */       Class c = o.getClass();
/*  90 */       Field f = c.getField("mErrors");
/*  91 */       ((CErrors)f.get(o)).addOneError(tError);
/*     */ 
/*  93 */       System.out.println("\n\u5728\uFF08" + tError.moduleName + "\uFF09\u4E2D\u629B\u51FA\u5982\u4E0B\u9519\u8BEF\uFF1A" + 
/*  94 */         errMessage);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*  98 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void buildErr(Object o, String errMessage, CErrors e)
/*     */   {
/* 104 */     buildErr(o, "", errMessage.trim(), e, "1", "23");
/*     */   }
/*     */ 
/*     */   public static void buildErr(Object o, String errMessage, CErrors e, String errType, String errNo)
/*     */   {
/* 110 */     buildErr(o, "", errMessage, e, errType, errNo);
/*     */   }
/*     */ 
/*     */   public static void buildErr(Object o, String functionName, String errMessage, CErrors e, String errType, String errNo)
/*     */   {
/*     */     try
/*     */     {
/* 119 */       Class c = o.getClass();
/* 120 */       Field f = c.getField("mErrors");
/* 121 */       ((CErrors)f.get(o)).copyAllErrors(e);
/*     */ 
/* 123 */       buildErr(o, functionName, errMessage, errType, errNo);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 127 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] arg)
/*     */   {
/* 133 */     CError e = new CError();
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.CError
 * JD-Core Version:    0.6.0
 */