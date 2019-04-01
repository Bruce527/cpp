/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public class ECDBConnPool
/*     */ {
/*  23 */   private static ECDBConn[] ECDBConns = new ECDBConn[600];
/*     */   private static final int nConnCount = 600;
/*     */ 
/*     */   static
/*     */   {
/*  24 */     for (int nIndex = 0; nIndex < 600; nIndex++)
/*     */     {
/*  26 */       ECDBConns[nIndex] = new ECDBConn();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static ECDBConn getECConnection()
/*     */   {
/*  37 */     ECJdbcUrl JUrl = new ECJdbcUrl();
/*     */ 
/*  39 */     if ((JUrl.getDBType().toUpperCase().equals("WEBLOGICPOOL")) || 
/*  40 */       (JUrl.getDBType().toUpperCase().equals("COMMONSDBCP")) || 
/*  41 */       (JUrl.getDBType().toUpperCase().equals("WEBSPHERE")))
/*     */     {
/*  43 */       ECDBConn tECDBConn = new ECDBConn();
/*  44 */       if (tECDBConn.createECConnection())
/*     */       {
/*  46 */         return tECDBConn;
/*     */       }
/*     */ 
/*  50 */       return null;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  56 */       DBSemaphore.Lock();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*  60 */       ex.printStackTrace();
/*  61 */       return null;
/*     */     }
/*     */ 
/*  65 */     for (int nIndex = 0; nIndex < 600; nIndex++)
/*     */     {
/*  67 */       ECDBConn ECDBConn = ECDBConns[nIndex];
/*     */ 
/*  69 */       if (ECDBConn.isInUse())
/*     */       {
/*     */         continue;
/*     */       }
/*  73 */       if (!ECDBConn.createECConnection())
/*     */       {
/*  76 */         DBSemaphore.UnLock();
/*  77 */         return null;
/*     */       }
/*     */ 
/*  80 */       if (nIndex >= 1)
/*     */       {
/*  82 */         System.out.println("ECDBConnPool : get connection, index is " + 
/*  83 */           String.valueOf(nIndex));
/*     */       }
/*     */ 
/*     */       try
/*     */       {
/*  88 */         ECDBConn.setAutoCommit(true);
/*  89 */         ECDBConn.setInUse();
/*  90 */         DBSemaphore.UnLock();
/*  91 */         return ECDBConn;
/*     */       }
/*     */       catch (Exception ex)
/*     */       {
/*  95 */         ex.printStackTrace();
/*     */ 
/*  97 */         DBSemaphore.UnLock();
/*     */ 
/*  99 */         return null;
/*     */       }
/*     */     }
/*     */ 
/* 103 */     System.out.println("ECDBConnPool : All connections are in use");
/*     */ 
/* 105 */     DBSemaphore.UnLock();
/* 106 */     return null;
/*     */   }
/*     */ 
/*     */   public static void dumpConnInfo(OutputStream os)
/*     */   {
/*     */     try
/*     */     {
/* 114 */       if (ECDBConns == null)
/*     */       {
/* 116 */         os.write("all connections are free".getBytes());
/* 117 */         return;
/*     */       }
/*     */ 
/* 120 */       for (int nIndex = 0; nIndex < 600; nIndex++)
/*     */       {
/* 122 */         ECDBConn ECDBConn = ECDBConns[nIndex];
/*     */ 
/* 124 */         os.write(
/* 125 */           (String.valueOf(nIndex) + 
/* 125 */           "------------------------------------\r\n\r")
/* 126 */           .getBytes());
/* 127 */         if ((ECDBConn == null) || (!ECDBConn.isInUse()))
/*     */           continue;
/* 129 */         ECDBConn.dumpConnInfo(os);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 135 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   protected static ECDBConn[] getECDBConns()
/*     */   {
/* 141 */     return ECDBConns;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.ECDBConnPool
 * JD-Core Version:    0.6.0
 */