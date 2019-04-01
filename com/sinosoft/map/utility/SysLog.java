/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ import org.apache.log4j.Logger;
/*     */ import org.apache.log4j.Priority;
/*     */ 
/*     */ public class SysLog
/*     */ {
/*  15 */   private static String DEFAULT_LOGGER = "com.sinosoft.map.utility";
/*     */ 
/*  17 */   public static Logger logger = getLogger(DEFAULT_LOGGER);
/*     */   public static final int OFF = 2147483647;
/*     */   public static final int FATAL = 50000;
/*     */   public static final int ERROR = 40000;
/*     */   public static final int WARN = 30000;
/*     */   public static final int INFO = 20000;
/*     */   public static final int DEBUG = 10000;
/*     */   public static final int ALL = -2147483648;
/*     */ 
/*     */   private static Priority getPriority(int nPriority)
/*     */   {
/*  34 */     Priority priority = null;
/*     */ 
/*  36 */     switch (nPriority)
/*     */     {
/*     */     case 2147483647:
/*  39 */       priority = Priority.toPriority(2147483647);
/*  40 */       break;
/*     */     case 50000:
/*  42 */       priority = Priority.FATAL;
/*  43 */       break;
/*     */     case 40000:
/*  45 */       priority = Priority.ERROR;
/*  46 */       break;
/*     */     case 30000:
/*  48 */       priority = Priority.WARN;
/*  49 */       break;
/*     */     case 20000:
/*  51 */       priority = Priority.INFO;
/*  52 */       break;
/*     */     case 10000:
/*  54 */       priority = Priority.DEBUG;
/*  55 */       break;
/*     */     case -2147483648:
/*  57 */       priority = Priority.toPriority(-2147483648);
/*     */     }
/*     */ 
/*  61 */     return priority;
/*     */   }
/*     */ 
/*     */   public static Logger getLogger(String className)
/*     */   {
/*  67 */     return Logger.getLogger(className);
/*     */   }
/*     */ 
/*     */   public static Logger getLogger(Class className)
/*     */   {
/*  73 */     return Logger.getLogger(className);
/*     */   }
/*     */ 
/*     */   public static void log(Object obj)
/*     */   {
/*  78 */     logger.info(obj);
/*     */   }
/*     */ 
/*     */   public static void log(String strMessage)
/*     */   {
/*  83 */     logger.info(strMessage);
/*     */   }
/*     */ 
/*     */   public static void log(int n)
/*     */   {
/*  88 */     logger.info(String.valueOf(n));
/*     */   }
/*     */ 
/*     */   public static void log(float f)
/*     */   {
/*  93 */     logger.info(String.valueOf(f));
/*     */   }
/*     */ 
/*     */   public static void log(double d)
/*     */   {
/*  98 */     logger.info(String.valueOf(d));
/*     */   }
/*     */ 
/*     */   public static void log(int nLevel, Object obj)
/*     */   {
/* 103 */     logger.log(getPriority(nLevel), obj);
/*     */   }
/*     */ 
/*     */   public static void log(int nLevel, String strMessage)
/*     */   {
/* 108 */     logger.log(getPriority(nLevel), strMessage);
/*     */   }
/*     */ 
/*     */   public static void log(int nLevel, int n)
/*     */   {
/* 113 */     logger.log(getPriority(nLevel), String.valueOf(n));
/*     */   }
/*     */ 
/*     */   public static void log(int nLevel, float f)
/*     */   {
/* 118 */     logger.log(getPriority(nLevel), String.valueOf(f));
/*     */   }
/*     */ 
/*     */   public static void log(int nLevel, double d)
/*     */   {
/* 123 */     logger.log(getPriority(nLevel), String.valueOf(d));
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 128 */     SysLog sysLog = new SysLog();
/* 129 */     Logger log = getLogger(SysLog.class);
/* 130 */     log.info(".......");
/* 131 */     log.info("///////");
/*     */ 
/* 133 */     log = getLogger("com.sinosoft.map.utility");
/* 134 */     log.info("com.sinosoft.map.utility");
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.SysLog
 * JD-Core Version:    0.6.0
 */