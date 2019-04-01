/*     */ package com.sinosoft.banklns.utility;
/*     */ 
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public class DBConnPool
/*     */ {
/*  16 */   private static DBConn[] dbConns = new DBConn[50];
/*     */   private static final int nConnCount = 50;
/*     */ 
/*     */   static
/*     */   {
/*  17 */     for (int nIndex = 0; nIndex < 50; nIndex++)
/*     */     {
/*  19 */       dbConns[nIndex] = new DBConn();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static DBConn getConnection()
/*     */   {
/*  29 */     int curfreeIndex = 0;
/*  30 */     DBConn dbConn = null;
/*     */     try {
/*  32 */       JdbcUrl JUrl = new JdbcUrl();
/*     */       DBConn localDBConn1;
/*  33 */       if ((JUrl.getDBType().toUpperCase().equals("WEBLOGICPOOL")) || 
/*  34 */         (JUrl.getDBType().toUpperCase().equals("COMMONSDBCP")) || 
/*  35 */         (JUrl.getDBType().toUpperCase().equals("WEBSPHERE")) || 
/*  36 */         (JUrl.getDBType().toUpperCase().equals("JBOSS")) || 
/*  37 */         (JUrl.getDBType().toUpperCase().equals("SQLSERVER2012")))
/*     */       {
/*  39 */         DBConn tDBConn = new DBConn();
/*  40 */         if (tDBConn.createConnection())
/*     */         {
/*  42 */           localDBConn1 = tDBConn;
/*     */           int i;
/*     */           return localDBConn1;
/*     */         }
/*     */         DBConn tDBConn;
/*     */         JdbcUrl JUrl;
/*     */         int i;
/*     */         return null;
/*     */       }
/*     */       try
/*     */       {
/*     */         JdbcUrl JUrl;
/*  52 */         DBSemaphore.Lock();
/*     */       }
/*     */       catch (Exception ex)
/*     */       {
/*  56 */         ex.printStackTrace();
/*     */         try
/*     */         {
/* 106 */           if (curfreeIndex > 15) {
/* 107 */             System.out.println("\u53EA\u8BD5\u7528\u672C\u5730\u5F00\u53D1\uFF0CUAT\u4E0A\u8FD8\u662F\u7528\u8FDE\u63A5\u6C60------------current con idx is " + curfreeIndex);
/* 108 */             System.out.println("get in close connections  what if it is free");
/* 109 */             for (int i = 0; i < curfreeIndex; i++)
/* 110 */               if ((dbConns[i].isInnerClose()) || (dbConns[i].isClosed()) || (!dbConns[i].isInUse()) || (curfreeIndex > 20)) {
/* 111 */                 dbConns[i].close();
/* 112 */                 System.out.println("--------------------->current idx: " + i + " con is not use");
/*     */               }
/*     */           }
/*     */         }
/*     */         catch (Exception e) {
/* 117 */           e.printStackTrace();
/*     */         }
/*  57 */         return null;
/*     */       }
/*     */       JdbcUrl JUrl;
/*     */       int nIndex;
/*     */       JdbcUrl JUrl;
/*  59 */       for (int nIndex = 0; nIndex < 50; nIndex++)
/*     */       {
/*  61 */         dbConn = dbConns[nIndex];
/*  62 */         if (dbConn.isInUse())
/*     */         {
/*  64 */           if ((dbConn.isInnerClose()) || (dbConn.isClosed())) {
/*  65 */             dbConn.close();
/*  66 */             System.out.println("--------------------->current " + nIndex + " idx con isClosed");
/*     */           }
/*     */         }
/*     */         else {
/*  70 */           if (!dbConn.createConnection())
/*     */           {
/*  72 */             DBSemaphore.UnLock();
/*     */             int i;
/*     */             return null;
/*     */           }
/*     */           int nIndex;
/*     */           JdbcUrl JUrl;
/*  75 */           if (nIndex >= 1)
/*     */           {
/*  77 */             System.out.println("--------------------->MDES DBConnPool :  get connection, current min free index is " + 
/*  78 */               String.valueOf(nIndex));
/*  79 */             curfreeIndex = nIndex;
/*     */           }
/*     */           try
/*     */           {
/*  83 */             dbConn.setAutoCommit(true);
/*  84 */             dbConn.setInUse();
/*  85 */             DBSemaphore.UnLock();
/*  86 */             localDBConn1 = dbConn;
/*     */             try
/*     */             {
/* 106 */               if (curfreeIndex > 15) {
/* 107 */                 System.out.println("\u53EA\u8BD5\u7528\u672C\u5730\u5F00\u53D1\uFF0CUAT\u4E0A\u8FD8\u662F\u7528\u8FDE\u63A5\u6C60------------current con idx is " + curfreeIndex);
/* 108 */                 System.out.println("get in close connections  what if it is free");
/* 109 */                 for (int i = 0; i < curfreeIndex; i++)
/* 110 */                   if ((dbConns[i].isInnerClose()) || (dbConns[i].isClosed()) || (!dbConns[i].isInUse()) || (curfreeIndex > 20)) {
/* 111 */                     dbConns[i].close();
/* 112 */                     System.out.println("--------------------->current idx: " + i + " con is not use");
/*     */                   }
/*     */               }
/*     */             }
/*     */             catch (Exception e) {
/* 117 */               e.printStackTrace();
/*     */             }
/*  86 */             return localDBConn1;
/*     */           }
/*     */           catch (Exception ex)
/*     */           {
/*     */             int nIndex;
/*     */             JdbcUrl JUrl;
/*  90 */             ex.printStackTrace();
/*     */ 
/*  92 */             DBSemaphore.UnLock();
/*     */             try
/*     */             {
/* 106 */               if (curfreeIndex > 15) {
/* 107 */                 System.out.println("\u53EA\u8BD5\u7528\u672C\u5730\u5F00\u53D1\uFF0CUAT\u4E0A\u8FD8\u662F\u7528\u8FDE\u63A5\u6C60------------current con idx is " + curfreeIndex);
/* 108 */                 System.out.println("get in close connections  what if it is free");
/* 109 */                 for (int i = 0; i < curfreeIndex; i++)
/* 110 */                   if ((dbConns[i].isInnerClose()) || (dbConns[i].isClosed()) || (!dbConns[i].isInUse()) || (curfreeIndex > 20)) {
/* 111 */                     dbConns[i].close();
/* 112 */                     System.out.println("--------------------->current idx: " + i + " con is not use");
/*     */                   }
/*     */               }
/*     */             }
/*     */             catch (Exception e) {
/* 117 */               e.printStackTrace();
/*     */             }
/*  94 */             return null;
/*     */           }
/*     */         }
/*     */       }
/*  98 */       System.out.println("--------------------->MDES DBConnPool : All connections are in use");
/*  99 */       DBSemaphore.UnLock();
/*     */       int i;
/*     */       return null;
/*     */     }
/*     */     catch (Exception e) {
/* 103 */       e.printStackTrace();
/*     */       try
/*     */       {
/* 106 */         if (curfreeIndex > 15) {
/* 107 */           System.out.println("\u53EA\u8BD5\u7528\u672C\u5730\u5F00\u53D1\uFF0CUAT\u4E0A\u8FD8\u662F\u7528\u8FDE\u63A5\u6C60------------current con idx is " + curfreeIndex);
/* 108 */           System.out.println("get in close connections  what if it is free");
/* 109 */           for (int i = 0; i < curfreeIndex; i++)
/* 110 */             if ((dbConns[i].isInnerClose()) || (dbConns[i].isClosed()) || (!dbConns[i].isInUse()) || (curfreeIndex > 20)) {
/* 111 */               dbConns[i].close();
/* 112 */               System.out.println("--------------------->current idx: " + i + " con is not use");
/*     */             }
/*     */         }
/*     */       }
/*     */       catch (Exception e) {
/* 117 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*     */       try
/*     */       {
/* 106 */         if (curfreeIndex > 15) {
/* 107 */           System.out.println("\u53EA\u8BD5\u7528\u672C\u5730\u5F00\u53D1\uFF0CUAT\u4E0A\u8FD8\u662F\u7528\u8FDE\u63A5\u6C60------------current con idx is " + curfreeIndex);
/* 108 */           System.out.println("get in close connections  what if it is free");
/* 109 */           for (int i = 0; i < curfreeIndex; i++)
/* 110 */             if ((dbConns[i].isInnerClose()) || (dbConns[i].isClosed()) || (!dbConns[i].isInUse()) || (curfreeIndex > 20)) {
/* 111 */               dbConns[i].close();
/* 112 */               System.out.println("--------------------->current idx: " + i + " con is not use");
/*     */             }
/*     */         }
/*     */       }
/*     */       catch (Exception e) {
/* 117 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 120 */     return dbConn;
/*     */   }
/*     */ 
/*     */   public static void dumpConnInfo(OutputStream os)
/*     */   {
/*     */     try
/*     */     {
/* 128 */       if (dbConns == null)
/*     */       {
/* 130 */         os.write("all connections are free".getBytes());
/* 131 */         return;
/*     */       }
/*     */ 
/* 134 */       for (int nIndex = 0; nIndex < 50; nIndex++)
/*     */       {
/* 136 */         DBConn dbConn = dbConns[nIndex];
/*     */ 
/* 138 */         os.write(
/* 139 */           (String.valueOf(nIndex) + 
/* 139 */           "------------------------------------\r\n\r")
/* 140 */           .getBytes());
/* 141 */         if ((dbConn == null) || (!dbConn.isInUse()))
/*     */           continue;
/* 143 */         dbConn.dumpConnInfo(os);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 149 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   protected static DBConn[] getDBConns()
/*     */   {
/* 155 */     return dbConns;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.DBConnPool
 * JD-Core Version:    0.6.0
 */