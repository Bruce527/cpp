/*    */ package com.sinosoft.map.common.logs;
/*    */ 
/*    */ import com.sinosoft.map.utility.ExeSQL;
/*    */ import com.sinosoft.map.utility.SSRS;
/*    */ import java.io.File;
/*    */ import java.io.FileWriter;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Date;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ 
/*    */ public class ErrorsLog
/*    */ {
/* 22 */   public static boolean isTrack = true;
/*    */ 
/* 24 */   public static boolean isDebug = true;
/*    */ 
/* 26 */   public static String debugOpt = "console";
/*    */ 
/* 28 */   public static List<String> errorMessages = new ArrayList();
/*    */ 
/*    */   public static synchronized void log(String message)
/*    */   {
/* 35 */     if (!isTrack) {
/* 36 */       return;
/*    */     }
/* 38 */     errorMessages.add(message);
/*    */   }
/*    */ 
/*    */   public static void debug(String message)
/*    */   {
/* 43 */     if (!isDebug) {
/* 44 */       return;
/*    */     }
/* 46 */     if (debugOpt.equals("console"))
/* 47 */       System.out.println("debug:" + message);
/* 48 */     else if (debugOpt.equals("file"))
/* 49 */       log("debug:" + message);
/*    */   }
/*    */ 
/*    */   public static synchronized void errorLogs(List<String> errorMessages)
/*    */   {
/*    */     try
/*    */     {
/* 58 */       File logPath = new File(getErrorsLogPath());
/* 59 */       if (!logPath.exists()) {
/* 60 */         logPath.mkdirs();
/*    */       }
/* 62 */       Date theDate = new Date();
/* 63 */       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
/* 64 */       String fileName = "log" + sdf.format(theDate) + ".txt";
/* 65 */       sdf.applyPattern("HH:mm:ss");
/* 66 */       String nowTime = sdf.format(theDate);
/* 67 */       File logFile = new File(logPath, fileName);
/* 68 */       FileWriter fw = null;
/*    */ 
/* 70 */       fw = new FileWriter(logFile, true);
/* 71 */       Iterator errorIT = errorMessages.iterator();
/* 72 */       while (errorIT.hasNext()) {
/* 73 */         String message = (String)errorIT.next();
/* 74 */         fw.write("Log:[" + nowTime + "]");
/* 75 */         fw.write(message + "\r\n");
/*    */       }
/* 77 */       fw.flush();
/* 78 */       fw.close();
/*    */     } catch (IOException ioe) {
/* 80 */       System.out.println("Errorslog:\u521B\u5EFA\u9519\u8BEF\u65E5\u5FD7\u6587\u4EF6\u5931\u8D25");
/*    */     }
/*    */   }
/*    */ 
/*    */   private static String getErrorsLogPath()
/*    */   {
/* 88 */     String sql = "select varvalue from msysvar where vartype='logsPath' ";
/* 89 */     ExeSQL tExeSQL = new ExeSQL();
/* 90 */     SSRS tSSRS = tExeSQL.execSQL(sql);
/* 91 */     String path = tSSRS.GetText(1, 1);
/*    */ 
/* 93 */     path = path + File.separator + "web" + File.separator + "errorslog";
/* 94 */     return path;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.common.logs.ErrorsLog
 * JD-Core Version:    0.6.0
 */