/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public class DBConnPool
/*     */ {
/*  23 */   private static DBConn[] dbConns = new DBConn[60];
/*     */   private static final int nConnCount = 60;
/*     */ 
/*     */   static
/*     */   {
/*  24 */     for (int nIndex = 0; nIndex < 60; nIndex++)
/*     */     {
/*  26 */       dbConns[nIndex] = new DBConn();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static DBConn getConnection()
/*     */   {
/*  37 */     JdbcUrl JUrl = new JdbcUrl();
/*     */ 
/*  39 */     if ((JUrl.getDBType().toUpperCase().equals("WEBLOGICPOOL")) || 
/*  40 */       (JUrl.getDBType().toUpperCase().equals("COMMONSDBCP")) || 
/*  41 */       (JUrl.getDBType().toUpperCase().equals("WEBSPHERE")) || 
/*  42 */       (JUrl.getDBType().toUpperCase().equals("JBOSS")))
/*     */     {
/*  44 */       DBConn tDBConn = new DBConn();
/*  45 */       if (tDBConn.createConnection())
/*     */       {
/*  47 */         return tDBConn;
/*     */       }
/*     */ 
/*  51 */       return null;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  57 */       DBSemaphore.Lock();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*  61 */       ex.printStackTrace();
/*  62 */       return null;
/*     */     }
/*     */ 
/*  66 */     for (int nIndex = 0; nIndex < 60; nIndex++)
/*     */     {
/*  68 */       DBConn dbConn = dbConns[nIndex];
/*     */ 
/*  70 */       if (dbConn.isInUse())
/*     */       {
/*     */         continue;
/*     */       }
/*  74 */       if (!dbConn.createConnection())
/*     */       {
/*  77 */         DBSemaphore.UnLock();
/*  78 */         return null;
/*     */       }
/*     */ 
/*  81 */       if (nIndex >= 1)
/*     */       {
/*  83 */         System.out.println("DBConnPool : get connection, index is " + 
/*  84 */           String.valueOf(nIndex));
/*     */       }
/*     */ 
/*     */       try
/*     */       {
/*  89 */         dbConn.setAutoCommit(true);
/*  90 */         dbConn.setInUse();
/*  91 */         DBSemaphore.UnLock();
/*  92 */         return dbConn;
/*     */       }
/*     */       catch (Exception ex)
/*     */       {
/*  96 */         ex.printStackTrace();
/*     */ 
/*  98 */         DBSemaphore.UnLock();
/*     */ 
/* 100 */         return null;
/*     */       }
/*     */     }
/*     */ 
/* 104 */     System.out.println("DBConnPool : All connections are in use");
/*     */ 
/* 106 */     DBSemaphore.UnLock();
/* 107 */     return null;
/*     */   }
/*     */ 
/*     */   public static void dumpConnInfo(OutputStream os)
/*     */   {
/*     */     try
/*     */     {
/* 115 */       if (dbConns == null)
/*     */       {
/* 117 */         os.write("all connections are free".getBytes());
/* 118 */         return;
/*     */       }
/*     */ 
/* 121 */       for (int nIndex = 0; nIndex < 60; nIndex++)
/*     */       {
/* 123 */         DBConn dbConn = dbConns[nIndex];
/*     */ 
/* 125 */         os.write(
/* 126 */           (String.valueOf(nIndex) + 
/* 126 */           "------------------------------------\r\n\r")
/* 127 */           .getBytes());
/* 128 */         if ((dbConn == null) || (!dbConn.isInUse()))
/*     */           continue;
/* 130 */         dbConn.dumpConnInfo(os);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 136 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   protected static DBConn[] getDBConns()
/*     */   {
/* 142 */     return dbConns;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.DBConnPool
 * JD-Core Version:    0.6.0
 */