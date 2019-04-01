/*    */ package com.sinosoft.banklns.lis;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import javax.faces.context.ExternalContext;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ public abstract class BankBasicBL
/*    */ {
/*  7 */   private long waitTimeMillis = 300L;
/*  8 */   private long waitMaxTimes = 10L;
/*    */ 
/*    */   protected void waitPolicyCommited(HttpSession session, String ContNo) throws Exception {
/* 11 */     long startTime = System.currentTimeMillis();
/*    */ 
/* 13 */     while (isCurPolicyLock(session, ContNo)) {
/* 14 */       long endTime = System.currentTimeMillis();
/* 15 */       if ((endTime - startTime) / this.waitTimeMillis <= this.waitMaxTimes) {
/* 16 */         Thread.sleep(this.waitTimeMillis);
/*    */       } else {
/* 18 */         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~because of limit maxWati times");
/* 19 */         turnCurrPolicyLockFlag(session, ContNo, "unlock");
/* 20 */         break;
/*    */       }
/*    */     }
/* 23 */     long endTime = System.currentTimeMillis();
/* 24 */     System.out.println("~~~~~~~~~>startmillis:" + startTime + " |endmillis: " + endTime + " |~~~~~~~~~wait " + (endTime - startTime) / this.waitTimeMillis + " timeS  ,total time " + calHMS((endTime - startTime) / 1000L));
/* 25 */     System.out.println();
/*    */   }
/*    */ 
/*    */   protected void turnCurrPolicyLockFlag(HttpSession session, String contno, String lockState) throws RuntimeException {
/* 29 */     if (session == null) session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/* 30 */     session.setAttribute(contno, contno + lockState);
/* 31 */     System.out.println("turn------------current " + contno + " policy lock state:" + session.getAttribute(contno));
/*    */   }
/*    */ 
/*    */   protected boolean isCurPolicyLock(HttpSession session, String contno) throws RuntimeException {
/* 35 */     boolean flag = true;
/* 36 */     if (session == null) session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/* 37 */     String locked = (String)session.getAttribute(contno);
/* 38 */     System.out.println("is------------current " + contno + " policy lock state:" + session.getAttribute(contno));
/* 39 */     if ((turnNullToString(locked).equals("")) || (turnNullToString(locked).indexOf("unlock") > -1)) {
/* 40 */       flag = false;
/*    */     }
/* 42 */     return flag;
/*    */   }
/*    */ 
/*    */   private String turnNullToString(Object object)
/*    */   {
/* 47 */     String rst = "";
/*    */     try {
/* 49 */       rst = object;
/*    */     } catch (Exception e) {
/* 51 */       e.printStackTrace();
/*    */     }
/* 53 */     return rst.trim();
/*    */   }
/*    */ 
/*    */   private String calHMS(long timeInSeconds)
/*    */   {
/* 58 */     long hours = timeInSeconds / 3600L;
/* 59 */     timeInSeconds -= hours * 3600L;
/* 60 */     long minutes = timeInSeconds / 60L;
/* 61 */     timeInSeconds -= minutes * 60L;
/* 62 */     long seconds = timeInSeconds;
/* 63 */     return hours + " hour(s) " + minutes + " minute(s) " + seconds + " second(s)";
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.BankBasicBL
 * JD-Core Version:    0.6.0
 */