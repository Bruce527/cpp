/*    */ package com.sinosoft.map.lis.job;
/*    */ 
/*    */ import com.sinosoft.map.common.logs.ErrorsLog;
/*    */ import com.sinosoft.map.common.logs.VisitorLog;
/*    */ import java.io.PrintStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.quartz.Job;
/*    */ import org.quartz.JobExecutionContext;
/*    */ import org.quartz.JobExecutionException;
/*    */ 
/*    */ public class WriteVisitRecordsJob
/*    */   implements Job
/*    */ {
/*    */   public void execute(JobExecutionContext context)
/*    */     throws JobExecutionException
/*    */   {
/* 42 */     List webOperateInfoList = (List)((ArrayList)VisitorLog.webOperateInfoList).clone();
/*    */ 
/* 45 */     VisitorLog.webOperateInfoList.clear();
/*    */ 
/* 47 */     if (webOperateInfoList.size() > 0)
/*    */     {
/* 49 */       System.out.println("\u5F00\u59CB\u5199\u64CD\u4F5C\u65E5\u5FD7---------");
/*    */ 
/* 58 */       VisitorLog.logClick(webOperateInfoList);
/*    */     }
/*    */ 
/* 68 */     List tempErrorMessages = (List)((ArrayList)ErrorsLog.errorMessages).clone();
/* 69 */     ErrorsLog.errorMessages.clear();
/* 70 */     if ((tempErrorMessages != null) && (tempErrorMessages.size() > 0)) {
/* 71 */       System.out.println("\u5F00\u59CB\u5199\u5F02\u5E38\u65E5\u5FD7---------");
/* 72 */       ErrorsLog.errorLogs(tempErrorMessages);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.job.WriteVisitRecordsJob
 * JD-Core Version:    0.6.0
 */