/*    */ package com.sinosoft.map.lis.job;
/*    */ 
/*    */ import com.sinosoft.map.lis.batch.BirthdayQuery;
/*    */ import com.sinosoft.map.lis.batch.HonorData;
/*    */ import com.sinosoft.map.lis.batch.MonthStatement;
/*    */ import com.sinosoft.map.lis.batch.PolicyYearCheck;
/*    */ import com.sinosoft.map.lis.batch.Preserve;
/*    */ import com.sinosoft.map.lis.batch.RenewalPayment;
/*    */ import com.sinosoft.map.lis.batch.WeddingDate;
/*    */ import org.quartz.Job;
/*    */ import org.quartz.JobExecutionContext;
/*    */ import org.quartz.JobExecutionException;
/*    */ 
/*    */ public class MessageBatchJob
/*    */   implements Job
/*    */ {
/*    */   public void execute(JobExecutionContext context)
/*    */     throws JobExecutionException
/*    */   {
/* 25 */     MonthStatement tMonthStatement = new MonthStatement();
/* 26 */     tMonthStatement.batch();
/*    */ 
/* 29 */     PolicyYearCheck tPolicyYearCheck = new PolicyYearCheck();
/* 30 */     tPolicyYearCheck.batch();
/*    */ 
/* 33 */     RenewalPayment tRenewalPayment = new RenewalPayment();
/* 34 */     tRenewalPayment.batch();
/*    */ 
/* 36 */     WeddingDate tWeddingDate = new WeddingDate();
/* 37 */     tWeddingDate.batch();
/*    */ 
/* 39 */     BirthdayQuery tBirthdayQuery = new BirthdayQuery();
/* 40 */     tBirthdayQuery.batch();
/*    */ 
/* 42 */     HonorData tHonorData = new HonorData();
/* 43 */     tHonorData.batch();
/*    */ 
/* 46 */     Preserve tPreserve = new Preserve();
/* 47 */     tPreserve.batch();
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/* 52 */     MonthStatement tMonthStatement = new MonthStatement();
/* 53 */     tMonthStatement.batch();
/*    */ 
/* 56 */     PolicyYearCheck tPolicyYearCheck = new PolicyYearCheck();
/* 57 */     tPolicyYearCheck.batch();
/*    */ 
/* 60 */     RenewalPayment tRenewalPayment = new RenewalPayment();
/* 61 */     tRenewalPayment.batch();
/*    */ 
/* 63 */     WeddingDate tWeddingDate = new WeddingDate();
/* 64 */     tWeddingDate.batch();
/*    */ 
/* 66 */     BirthdayQuery tBirthdayQuery = new BirthdayQuery();
/* 67 */     tBirthdayQuery.batch();
/*    */ 
/* 69 */     HonorData tHonorData = new HonorData();
/* 70 */     tHonorData.batch();
/*    */ 
/* 73 */     Preserve tPreserve = new Preserve();
/* 74 */     tPreserve.batch();
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.job.MessageBatchJob
 * JD-Core Version:    0.6.0
 */