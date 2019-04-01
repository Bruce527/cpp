/*     */ package com.sinosoft.banklns.utility;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.io.RandomAccessFile;
/*     */ 
/*     */ public class UserLog
/*     */ {
/*  29 */   private static String strUserLogFileName = ConfigInfo.GetValuebyName("userlogpath");
/*     */ 
/*  31 */   private static String strSysLogFileName = ConfigInfo.GetValuebyName("syslogpath");
/*     */ 
/*     */   public UserLog()
/*     */   {
/*  40 */     String userLogExtendsion = strUserLogFileName.substring(strUserLogFileName.indexOf("."));
/*  41 */     String strDate = StrTool.getDate();
/*  42 */     String strDateYear = strDate.substring(0, strDate.indexOf("/"));
/*  43 */     strDate = strDate.substring(strDate.indexOf("/") + 1);
/*  44 */     String strDateMonth = strDate.substring(0, strDate.indexOf("/"));
/*  45 */     strDate = strDate.substring(strDate.indexOf("/") + 1);
/*  46 */     String strDateDay = strDate;
/*     */ 
/*  51 */     if ((strUserLogFileName.indexOf("(") == -1) && (strUserLogFileName.indexOf(")") == -1)) {
/*  52 */       strUserLogFileName = strUserLogFileName.substring(0, strUserLogFileName.indexOf(".")) + 
/*  53 */         "(" + 
/*  54 */         strDateYear + 
/*  55 */         "_" + 
/*  56 */         strDateMonth + 
/*  57 */         "_" + 
/*  58 */         strDateDay + 
/*  59 */         ")" + 
/*  60 */         userLogExtendsion;
/*     */     }
/*     */ 
/*  64 */     String sysLogExtendsion = strSysLogFileName.substring(strSysLogFileName.indexOf("."));
/*  65 */     strDate = StrTool.getDate();
/*  66 */     strDateYear = strDate.substring(0, strDate.indexOf("/"));
/*  67 */     strDate = strDate.substring(strDate.indexOf("/") + 1);
/*  68 */     strDateMonth = strDate.substring(0, strDate.indexOf("/"));
/*  69 */     strDate = strDate.substring(strDate.indexOf("/") + 1);
/*  70 */     strDateDay = strDate;
/*     */ 
/*  75 */     if ((strSysLogFileName.indexOf("(") == -1) && (strSysLogFileName.indexOf(")") == -1))
/*  76 */       strSysLogFileName = strSysLogFileName.substring(0, strSysLogFileName.indexOf(".")) + 
/*  77 */         "(" + 
/*  78 */         strDateYear + 
/*  79 */         "_" + 
/*  80 */         strDateMonth + 
/*  81 */         "_" + 
/*  82 */         strDateDay + 
/*  83 */         ")" + 
/*  84 */         sysLogExtendsion;
/*     */   }
/*     */ 
/*     */   public UserLog(String AllLogPath)
/*     */   {
/*  92 */     strUserLogFileName = AllLogPath;
/*  93 */     strSysLogFileName = AllLogPath;
/*     */   }
/*     */ 
/*     */   public UserLog(String UserLogPath, String SysLogPath)
/*     */   {
/*  99 */     strUserLogFileName = UserLogPath;
/* 100 */     strSysLogFileName = SysLogPath;
/*     */   }
/*     */ 
/*     */   public static int generateTempFile(String strFileName, String strValue)
/*     */   {
/* 106 */     String strFileValue = strValue;
/*     */     try
/*     */     {
/* 110 */       RandomAccessFile in = new RandomAccessFile(strFileName, "rw");
/* 111 */       in.write(strFileValue.getBytes());
/* 112 */       in.close();
/*     */     }
/*     */     catch (IOException exception)
/*     */     {
/* 116 */       System.out.print(exception.toString());
/* 117 */       return -1;
/*     */     }
/* 119 */     return 0;
/*     */   }
/*     */ 
/*     */   private static int print(String strValue)
/*     */   {
/*     */     try
/*     */     {
/* 128 */       RandomAccessFile in = new RandomAccessFile(strUserLogFileName, "rw");
/* 129 */       in.seek(in.length());
/* 130 */       in.write(strValue.getBytes());
/* 131 */       in.write(13);
/* 132 */       in.write(10);
/* 133 */       in.close();
/*     */     }
/*     */     catch (IOException exception)
/*     */     {
/* 137 */       System.out.print(exception.toString());
/* 138 */       return -1;
/*     */     }
/* 140 */     return 0;
/*     */   }
/*     */ 
/*     */   public static int print(int intValue)
/*     */   {
/* 146 */     return print(intValue);
/*     */   }
/*     */ 
/*     */   public static int print(double doubleValue)
/*     */   {
/* 152 */     return print(doubleValue);
/*     */   }
/*     */ 
/*     */   public static int print(Object object)
/*     */   {
/* 158 */     return print(object.toString());
/*     */   }
/*     */ 
/*     */   public static int println(String strValue)
/*     */   {
/* 164 */     String finalstrValue = null;
/*     */ 
/* 166 */     finalstrValue = "<" + StrTool.getDate() + " " + StrTool.getTime() + ">" + strValue + "\n";
/* 167 */     return print(finalstrValue);
/*     */   }
/*     */ 
/*     */   public static int println(int intValue)
/*     */   {
/* 173 */     String finalstrValue = null;
/*     */ 
/* 175 */     finalstrValue = "<" + StrTool.getDate() + " " + StrTool.getTime() + ">" + intValue + "\n";
/* 176 */     return print(finalstrValue);
/*     */   }
/*     */ 
/*     */   public static int println(double doubleValue)
/*     */   {
/* 182 */     String finalstrValue = null;
/*     */ 
/* 184 */     finalstrValue = "<" + StrTool.getDate() + " " + StrTool.getTime() + ">" + doubleValue + "\n";
/* 185 */     return print(finalstrValue);
/*     */   }
/*     */ 
/*     */   public static int println(Object object)
/*     */   {
/* 191 */     String finalstrValue = null;
/*     */ 
/* 193 */     finalstrValue = "<" + StrTool.getDate() + " " + StrTool.getTime() + ">" + object.toString() + "\n";
/* 194 */     return print(finalstrValue);
/*     */   }
/*     */ 
/*     */   private static int printException(String strValue)
/*     */   {
/* 200 */     String strLog = "<" + StrTool.getDate() + " " + StrTool.getTime() + ">" + strValue + "\n";
/*     */     try
/*     */     {
/* 203 */       RandomAccessFile in = new RandomAccessFile(strSysLogFileName, "rw");
/* 204 */       in.seek(in.length());
/* 205 */       in.write(strLog.getBytes());
/* 206 */       in.write(13);
/* 207 */       in.write(10);
/* 208 */       in.close();
/*     */     }
/*     */     catch (IOException exception)
/*     */     {
/* 212 */       System.out.print(exception.toString());
/* 213 */       return -1;
/*     */     }
/* 215 */     return 0;
/*     */   }
/*     */ 
/*     */   public static int printException(int intValue)
/*     */   {
/* 222 */     return printException(intValue);
/*     */   }
/*     */ 
/*     */   public static int printException(double doubleValue)
/*     */   {
/* 228 */     return printException(doubleValue);
/*     */   }
/*     */ 
/*     */   public static int printException(Object object)
/*     */   {
/* 234 */     return printException(object.toString());
/*     */   }
/*     */ 
/*     */   public static int addUserLog(String strLog)
/*     */   {
/* 239 */     return println(strLog);
/*     */   }
/*     */ 
/*     */   public static int addSysLog(String strLog)
/*     */   {
/* 244 */     return printException(strLog);
/*     */   }
/*     */ 
/*     */   public static String getDefaultPath() {
/* 248 */     File defaultPath = new File(".");
/* 249 */     return defaultPath.getAbsolutePath();
/*     */   }
/*     */ 
/*     */   private static int readTest()
/*     */   {
/*     */     try
/*     */     {
/* 257 */       RandomAccessFile in = new RandomAccessFile(strUserLogFileName, "rw");
/*     */ 
/* 260 */       int tRead = 0;
/* 261 */       while (tRead != -1) {
/* 262 */         tRead = in.read();
/* 263 */         System.out.println(tRead);
/*     */       }
/*     */ 
/* 266 */       in.close();
/*     */     }
/*     */     catch (IOException exception)
/*     */     {
/* 270 */       System.out.print(exception.toString());
/* 271 */       return -1;
/*     */     }
/* 273 */     return 0;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 283 */     System.out.println("Start");
/* 284 */     UserLog testUserLog = new UserLog();
/*     */ 
/* 289 */     System.out.println("File save successful");
/* 290 */     System.out.println(getDefaultPath());
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.UserLog
 * JD-Core Version:    0.6.0
 */