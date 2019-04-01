/*    */ package com.sinosoft.map.utility;
/*    */ 
/*    */ public class DBSemaphore
/*    */ {
/* 11 */   private static volatile boolean m_bInUse = false;
/* 12 */   private static String m_szObject = "DBSemaphore";
/*    */ 
/*    */   protected static synchronized boolean setInUseFlag(boolean bNewValue)
/*    */   {
/* 21 */     if (bNewValue)
/*    */     {
/* 23 */       if (m_bInUse)
/*    */       {
/* 25 */         return false;
/*    */       }
/*    */ 
/* 29 */       m_bInUse = true;
/* 30 */       return true;
/*    */     }
/*    */ 
/* 35 */     m_bInUse = false;
/* 36 */     return true;
/*    */   }
/*    */ 
/*    */   protected static void Lock()
/*    */     throws Exception
/*    */   {
/* 42 */     Lock(10);
/*    */   }
/*    */ 
/*    */   protected static void Lock(int nSeconds) throws Exception
/*    */   {
/* 47 */     if (nSeconds <= 0)
/*    */     {
/* 49 */       while (!setInUseFlag(true))
/*    */       {
/* 51 */         Thread.sleep(100L);
/*    */       }
/*    */     }
/*    */     else
/*    */     {
/*    */       do
/*    */       {
/* 58 */         Thread.sleep(100L);
/*    */       }
/* 56 */       while ((!setInUseFlag(true)) && (nSeconds-- > 0));
/*    */ 
/* 61 */       if (nSeconds == 0)
/*    */       {
/* 63 */         throw new Exception("Lock time out");
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   protected static void UnLock()
/*    */   {
/* 70 */     setInUseFlag(false);
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.DBSemaphore
 * JD-Core Version:    0.6.0
 */