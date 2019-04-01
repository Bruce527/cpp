/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ import com.sinosoft.map.lis.pubfun.PubFun;
/*     */ import java.io.PrintStream;
/*     */ import java.lang.reflect.Field;
/*     */ 
/*     */ public class CError
/*     */ {
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
/*  38 */   public String errorType = "1";
/*     */ 
/*  41 */   public String errorNo = "23";
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
/*  59 */     this.errorMessage = errString;
/*     */   }
/*     */ 
/*     */   public CError(String errString, String cModuleName, String cFunctionName)
/*     */   {
/*  65 */     this.errorMessage = errString;
/*  66 */     this.moduleName = cModuleName;
/*  67 */     this.functionName = cFunctionName;
/*     */   }
/*     */ 
/*     */   public static void buildErr(Object o, String errMessage)
/*     */   {
/*  73 */     buildErr(o, "", errMessage, "1", "23");
/*     */   }
/*     */ 
/*     */   public static void buildErr(Object o, String errMessage, String errType, String errNo)
/*     */   {
/*  80 */     buildErr(o, "", errMessage.trim(), errType, errNo);
/*     */   }
/*     */ 
/*     */   public static void buildErr(Object o, String functionName, String errMessage, String errType, String errNo)
/*     */   {
/*     */     try
/*     */     {
/*  89 */       CError tError = new CError();
/*     */ 
/*  91 */       tError.moduleName = PubFun.getClassFileName(o);
/*  92 */       tError.functionName = functionName;
/*  93 */       tError.errorMessage = errMessage.trim();
/*  94 */       tError.errorType = errType;
/*  95 */       tError.errorNo = errNo;
/*     */ 
/*  97 */       Class c = o.getClass();
/*     */ 
/*  99 */       Field f = c.getField("mErrors");
/* 100 */       ((CErrors)f.get(o)).addOneError(tError);
/*     */ 
/* 102 */       System.out.print("\u5728\uFF08");
/* 103 */       System.out.print(tError.moduleName);
/* 104 */       System.out.print("\uFF09\u4E2D\u629B\u51FA\u5982\u4E0B\u9519\u8BEF\uFF1A");
/* 105 */       System.out.println(errMessage);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 109 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void buildErr(Object o, String errMessage, CErrors e)
/*     */   {
/* 116 */     buildErr(o, "", errMessage.trim(), e, "1", "23");
/*     */   }
/*     */ 
/*     */   public static void buildErr(Object o, String errMessage, CErrors e, String errType, String errNo)
/*     */   {
/* 123 */     buildErr(o, "", errMessage, e, errType, errNo);
/*     */   }
/*     */ 
/*     */   public static void buildErr(Object o, String functionName, String errMessage, CErrors e, String errType, String errNo)
/*     */   {
/*     */     try
/*     */     {
/* 136 */       buildErr(o, functionName, errMessage, errType, errNo);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 140 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] arg)
/*     */   {
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.CError
 * JD-Core Version:    0.6.0
 */