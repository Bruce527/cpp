/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.io.RandomAccessFile;
/*     */ 
/*     */ class UserLog
/*     */ {
/*  34 */   private static String strUserLogFileName = ConfigInfo.GetValuebyName(
/*  35 */     "userlogpath");
/*     */ 
/*  37 */   private static String strSysLogFileName = ConfigInfo.GetValuebyName("syslogpath");
/*     */ 
/*     */   public UserLog()
/*     */   {
/*  49 */     String userLogExtendsion = strUserLogFileName.substring(
/*  50 */       strUserLogFileName.indexOf("."));
/*  51 */     String strDate = StrTool.getDate();
/*  52 */     String strDateYear = strDate.substring(0, strDate.indexOf("/"));
/*  53 */     strDate = strDate.substring(strDate.indexOf("/") + 1);
/*  54 */     String strDateMonth = strDate.substring(0, strDate.indexOf("/"));
/*  55 */     strDate = strDate.substring(strDate.indexOf("/") + 1);
/*  56 */     String strDateDay = strDate;
/*     */ 
/*  60 */     if ((strUserLogFileName.indexOf("(") == -1) && 
/*  61 */       (strUserLogFileName.indexOf(")") == -1))
/*     */     {
/*  63 */       strUserLogFileName = strUserLogFileName.substring(0, 
/*  64 */         strUserLogFileName.indexOf(".")) + 
/*  65 */         "(" + 
/*  66 */         strDateYear + 
/*  67 */         "_" + 
/*  68 */         strDateMonth + 
/*  69 */         "_" + 
/*  70 */         strDateDay + 
/*  71 */         ")" + 
/*  72 */         userLogExtendsion;
/*     */     }
/*     */ 
/*  76 */     String sysLogExtendsion = strSysLogFileName.substring(strSysLogFileName
/*  77 */       .indexOf("."));
/*  78 */     strDate = StrTool.getDate();
/*  79 */     strDateYear = strDate.substring(0, strDate.indexOf("/"));
/*  80 */     strDate = strDate.substring(strDate.indexOf("/") + 1);
/*  81 */     strDateMonth = strDate.substring(0, strDate.indexOf("/"));
/*  82 */     strDate = strDate.substring(strDate.indexOf("/") + 1);
/*  83 */     strDateDay = strDate;
/*     */ 
/*  87 */     if ((strSysLogFileName.indexOf("(") == -1) && 
/*  88 */       (strSysLogFileName.indexOf(")") == -1))
/*     */     {
/*  90 */       strSysLogFileName = strSysLogFileName.substring(0, 
/*  91 */         strSysLogFileName.indexOf(".")) + 
/*  92 */         "(" + 
/*  93 */         strDateYear + 
/*  94 */         "_" + 
/*  95 */         strDateMonth + 
/*  96 */         "_" + 
/*  97 */         strDateDay + 
/*  98 */         ")" + 
/*  99 */         sysLogExtendsion;
/*     */     }
/*     */   }
/*     */ 
/*     */   public UserLog(String AllLogPath)
/*     */   {
/* 113 */     strUserLogFileName = AllLogPath;
/* 114 */     strSysLogFileName = AllLogPath;
/*     */   }
/*     */ 
/*     */   public UserLog(String UserLogPath, String SysLogPath)
/*     */   {
/* 125 */     strUserLogFileName = UserLogPath;
/* 126 */     strSysLogFileName = SysLogPath;
/*     */   }
/*     */ 
/*     */   public static int generateTempFile(String strFileName, String strValue)
/*     */   {
/* 138 */     String strFileValue = strValue;
/*     */     try
/*     */     {
/* 142 */       RandomAccessFile in = new RandomAccessFile(strFileName, "rw");
/* 143 */       in.write(strFileValue.getBytes());
/* 144 */       in.close();
/*     */     }
/*     */     catch (IOException exception)
/*     */     {
/* 148 */       System.out.print(exception.toString());
/* 149 */       return -1;
/*     */     }
/* 151 */     return 0;
/*     */   }
/*     */ 
/*     */   private static int print(String strValue)
/*     */   {
/*     */     try
/*     */     {
/* 165 */       RandomAccessFile in = new RandomAccessFile(strUserLogFileName, "rw");
/* 166 */       in.seek(in.length());
/* 167 */       in.write(strValue.getBytes());
/* 168 */       in.write(13);
/* 169 */       in.write(10);
/* 170 */       in.close();
/*     */     }
/*     */     catch (IOException exception)
/*     */     {
/* 174 */       System.out.print(exception.toString());
/* 175 */       return -1;
/*     */     }
/* 177 */     return 0;
/*     */   }
/*     */ 
/*     */   public static int print(int intValue)
/*     */   {
/* 188 */     return print(intValue);
/*     */   }
/*     */ 
/*     */   public static int print(double doubleValue)
/*     */   {
/* 199 */     return print(doubleValue);
/*     */   }
/*     */ 
/*     */   public static int print(Object object)
/*     */   {
/* 210 */     return print(object.toString());
/*     */   }
/*     */ 
/*     */   public static int println(String strValue)
/*     */   {
/* 221 */     String finalstrValue = null;
/*     */ 
/* 223 */     finalstrValue = "<" + StrTool.getDate() + " " + StrTool.getTime() + ">" + 
/* 224 */       strValue + "\n";
/* 225 */     return print(finalstrValue);
/*     */   }
/*     */ 
/*     */   public static int println(int intValue)
/*     */   {
/* 236 */     String finalstrValue = null;
/*     */ 
/* 238 */     finalstrValue = "<" + StrTool.getDate() + " " + StrTool.getTime() + ">" + 
/* 239 */       intValue + "\n";
/* 240 */     return print(finalstrValue);
/*     */   }
/*     */ 
/*     */   public static int println(double doubleValue)
/*     */   {
/* 251 */     String finalstrValue = null;
/*     */ 
/* 253 */     finalstrValue = "<" + StrTool.getDate() + " " + StrTool.getTime() + ">" + 
/* 254 */       doubleValue + "\n";
/* 255 */     return print(finalstrValue);
/*     */   }
/*     */ 
/*     */   public static int println(Object object)
/*     */   {
/* 266 */     String finalstrValue = null;
/*     */ 
/* 268 */     finalstrValue = "<" + StrTool.getDate() + " " + StrTool.getTime() + ">" + 
/* 269 */       object.toString() + "\n";
/* 270 */     return print(finalstrValue);
/*     */   }
/*     */ 
/*     */   private static int printException(String strValue)
/*     */   {
/* 281 */     String strLog = "<" + StrTool.getDate() + " " + StrTool.getTime() + ">" + 
/* 282 */       strValue + "\n";
/*     */     try
/*     */     {
/* 285 */       RandomAccessFile in = new RandomAccessFile(strSysLogFileName, "rw");
/* 286 */       in.seek(in.length());
/* 287 */       in.write(strLog.getBytes());
/* 288 */       in.write(13);
/* 289 */       in.write(10);
/* 290 */       in.close();
/*     */     }
/*     */     catch (IOException exception)
/*     */     {
/* 294 */       System.out.print(exception.toString());
/* 295 */       return -1;
/*     */     }
/* 297 */     return 0;
/*     */   }
/*     */ 
/*     */   public static int printException(int intValue)
/*     */   {
/* 309 */     return printException(intValue);
/*     */   }
/*     */ 
/*     */   public static int printException(double doubleValue)
/*     */   {
/* 320 */     return printException(doubleValue);
/*     */   }
/*     */ 
/*     */   public static int printException(Object object)
/*     */   {
/* 331 */     return printException(object.toString());
/*     */   }
/*     */ 
/*     */   public static int addUserLog(String strLog)
/*     */   {
/* 342 */     return println(strLog);
/*     */   }
/*     */ 
/*     */   public static int addSysLog(String strLog)
/*     */   {
/* 353 */     return printException(strLog);
/*     */   }
/*     */ 
/*     */   public static String getDefaultPath()
/*     */   {
/* 358 */     File defaultPath = new File(".");
/* 359 */     return defaultPath.getAbsolutePath();
/*     */   }
/*     */ 
/*     */   private static int readTest()
/*     */   {
/*     */     try
/*     */     {
/* 370 */       RandomAccessFile in = new RandomAccessFile(strUserLogFileName, "rw");
/*     */ 
/* 373 */       int tRead = 0;
/* 374 */       while (tRead != -1)
/*     */       {
/* 376 */         tRead = in.read();
/* 377 */         System.out.println(tRead);
/*     */       }
/*     */ 
/* 380 */       in.close();
/*     */     }
/*     */     catch (IOException exception)
/*     */     {
/* 384 */       System.out.print(exception.toString());
/* 385 */       return -1;
/*     */     }
/* 387 */     return 0;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 398 */     System.out.println("Start");
/* 399 */     UserLog testUserLog = new UserLog();
/*     */ 
/* 404 */     System.out.println("File save successful");
/* 405 */     System.out.println(getDefaultPath());
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.UserLog
 * JD-Core Version:    0.6.0
 */