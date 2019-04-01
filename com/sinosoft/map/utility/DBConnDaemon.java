/*    */ package com.sinosoft.map.utility;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class DBConnDaemon extends Thread
/*    */ {
/* 13 */   public CErrors mErrors = new CErrors();
/*    */ 
/*    */   public void run()
/*    */   {
/* 18 */     int nStep = 0;
/*    */     while (true)
/*    */     {
/*    */       try
/*    */       {
/* 24 */         Thread.sleep(30000L);
/* 25 */         nStep = 0;
/*    */ 
/* 27 */         DBSemaphore.Lock();
/* 28 */         nStep = 1;
/*    */ 
/* 30 */         daemonFunc();
/*    */ 
/* 32 */         DBSemaphore.UnLock();
/* 33 */         nStep = 2;
/*    */ 
/* 35 */         continue;
/*    */       } catch (Exception ex) {
/*    */       }
/* 38 */       if (nStep != 1)
/*    */         continue;
/* 40 */       DBSemaphore.UnLock();
/*    */     }
/*    */   }
/*    */ 
/*    */   private void daemonFunc()
/*    */     throws Exception
/*    */   {
/* 48 */     DBConn[] dbConns = DBConnPool.getDBConns();
/*    */ 
/* 50 */     if (dbConns == null)
/*    */     {
/* 52 */       return;
/*    */     }
/*    */ 
/* 55 */     int nIndex = 0;
/* 56 */     long lCurTime = new Date().getTime();
/*    */ 
/* 58 */     for (nIndex = 0; nIndex < dbConns.length; nIndex++)
/*    */     {
/* 60 */       Date lastestAccess = dbConns[nIndex].getLastestAccess();
/*    */ 
/* 62 */       if (lastestAccess == null)
/*    */       {
/*    */         continue;
/*    */       }
/*    */ 
/* 67 */       long lLastestAccess = lastestAccess.getTime();
/*    */ 
/* 70 */       if (dbConns[nIndex].isInUse())
/*    */       {
/* 73 */         if (lCurTime - lLastestAccess <= 600000L)
/*    */           continue;
/* 75 */         dbConns[nIndex].close();
/*    */       }
/*    */       else
/*    */       {
/* 82 */         if (lCurTime - lLastestAccess <= 1800000L)
/*    */           continue;
/* 84 */         dbConns[nIndex].innerClose();
/*    */       }
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.DBConnDaemon
 * JD-Core Version:    0.6.0
 */