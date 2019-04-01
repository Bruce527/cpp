/*    */ package com.sinosoft.map.lis.job;
/*    */ 
/*    */ import com.sinosoft.map.lis.batch.ModifyCaseFileDown;
/*    */ import java.io.PrintStream;
/*    */ import org.quartz.Job;
/*    */ import org.quartz.JobExecutionContext;
/*    */ import org.quartz.JobExecutionException;
/*    */ 
/*    */ public class ModifyCaseFileDownBatchJob
/*    */   implements Job
/*    */ {
/*    */   public synchronized void execute(JobExecutionContext context)
/*    */     throws JobExecutionException
/*    */   {
/* 22 */     System.out.println("=====ModifyCaseFileDownbatch===start=====");
/* 23 */     ModifyCaseFileDown tModifyCaseFileDown = new ModifyCaseFileDown();
/*    */ 
/* 25 */     tModifyCaseFileDown.newBatch();
/*    */ 
/* 31 */     System.out.println("=====ModifyCaseFileDownbatch===end=====");
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.job.ModifyCaseFileDownBatchJob
 * JD-Core Version:    0.6.0
 */