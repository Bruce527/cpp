/*     */ package com.sinosoft.banklns.utility;
/*     */ 
/*     */ import java.io.CharArrayWriter;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.sql.Array;
/*     */ import java.sql.Blob;
/*     */ import java.sql.CallableStatement;
/*     */ import java.sql.Clob;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DatabaseMetaData;
/*     */ import java.sql.Driver;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.SQLWarning;
/*     */ import java.sql.Savepoint;
/*     */ import java.sql.Statement;
/*     */ import java.sql.Struct;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import javax.naming.Context;
/*     */ import javax.naming.InitialContext;
/*     */ import javax.sql.DataSource;
/*     */ 
/*     */ public class DBConn
/*     */   implements Connection
/*     */ {
/*     */   private JdbcUrl JUrl;
/*  36 */   private Connection con = null;
/*     */   private boolean bNotInUse;
/*  38 */   private boolean bIsPool = false;
/*  39 */   private Date m_lastestAccess = null;
/*  40 */   private CharArrayWriter m_buf = new CharArrayWriter();
/*  41 */   private PrintWriter m_pw = new PrintWriter(this.m_buf, true);
/*     */ 
/*     */   public boolean createConnection()
/*     */   {
/*  45 */     int dbType = 0;
/*  46 */     if (this.JUrl.getDBType().equalsIgnoreCase("WEBLOGICPOOL"))
/*     */     {
/*  48 */       dbType = 10;
/*  49 */       this.bIsPool = true;
/*  50 */       if (getWeblogicPoolConnection())
/*     */       {
/*  52 */         return true;
/*     */       }
/*     */ 
/*  56 */       JdbcUrlBackUp tJdbcUrlBackUp = new JdbcUrlBackUp();
/*  57 */       this.JUrl.setDBName(tJdbcUrlBackUp.getDBName());
/*  58 */       this.JUrl.setDBType(tJdbcUrlBackUp.getDBType());
/*  59 */       this.JUrl.setIP(tJdbcUrlBackUp.getIP());
/*  60 */       this.JUrl.setPassWord(tJdbcUrlBackUp.getPassWord());
/*  61 */       this.JUrl.setPort(tJdbcUrlBackUp.getPort());
/*  62 */       this.JUrl.setServerName(tJdbcUrlBackUp.getServerName());
/*  63 */       this.JUrl.setUser(tJdbcUrlBackUp.getUserName());
/*     */     }
/*  66 */     else if (this.JUrl.getDBType().equalsIgnoreCase("COMMONSDBCP"))
/*     */     {
/*  68 */       this.bIsPool = true;
/*  69 */       if (getApachecommonDBCP())
/*     */       {
/*  71 */         return true;
/*     */       }
/*     */ 
/*  75 */       JdbcUrlBackUp tJdbcUrlBackUp = new JdbcUrlBackUp();
/*  76 */       this.JUrl.setDBName(tJdbcUrlBackUp.getDBName());
/*  77 */       this.JUrl.setDBType(tJdbcUrlBackUp.getDBType());
/*  78 */       this.JUrl.setIP(tJdbcUrlBackUp.getIP());
/*  79 */       this.JUrl.setPassWord(tJdbcUrlBackUp.getPassWord());
/*  80 */       this.JUrl.setPort(tJdbcUrlBackUp.getPort());
/*  81 */       this.JUrl.setServerName(tJdbcUrlBackUp.getServerName());
/*  82 */       this.JUrl.setUser(tJdbcUrlBackUp.getUserName());
/*     */     }
/*  85 */     else if (this.JUrl.getDBType().equalsIgnoreCase("WEBSPHERE"))
/*     */     {
/*  87 */       this.bIsPool = true;
/*  88 */       if (getWebSpherePoolConnection())
/*     */       {
/*  90 */         return true;
/*     */       }
/*     */ 
/*  94 */       JdbcUrlBackUp tJdbcUrlBackUp = new JdbcUrlBackUp();
/*  95 */       this.JUrl.setDBName(tJdbcUrlBackUp.getDBName());
/*  96 */       this.JUrl.setDBType(tJdbcUrlBackUp.getDBType());
/*  97 */       this.JUrl.setIP(tJdbcUrlBackUp.getIP());
/*  98 */       this.JUrl.setPassWord(tJdbcUrlBackUp.getPassWord());
/*  99 */       this.JUrl.setPort(tJdbcUrlBackUp.getPort());
/* 100 */       this.JUrl.setServerName(tJdbcUrlBackUp.getServerName());
/* 101 */       this.JUrl.setUser(tJdbcUrlBackUp.getUserName());
/*     */     }
/* 103 */     else if (this.JUrl.getDBType().equalsIgnoreCase("JBOSS"))
/*     */     {
/* 105 */       this.bIsPool = true;
/* 106 */       if (getJBOSSPoolConnection())
/* 107 */         return true;
/* 108 */       System.out.println("/banklns--------------------jboos conPool is failed\uFF0Ccon get from jdbcurlbak-------------------------------");
/* 109 */       JdbcUrlBackUp tJdbcUrlBackUp = new JdbcUrlBackUp();
/* 110 */       this.JUrl.setDBName(tJdbcUrlBackUp.getDBName());
/* 111 */       this.JUrl.setDBType(tJdbcUrlBackUp.getDBType());
/* 112 */       this.JUrl.setIP(tJdbcUrlBackUp.getIP());
/* 113 */       this.JUrl.setPassWord(tJdbcUrlBackUp.getPassWord());
/* 114 */       this.JUrl.setPort(tJdbcUrlBackUp.getPort());
/* 115 */       this.JUrl.setServerName(tJdbcUrlBackUp.getServerName());
/* 116 */       this.JUrl.setUser(tJdbcUrlBackUp.getUserName());
/*     */     }
/*     */     try
/*     */     {
/* 120 */       if (this.con != null)
/*     */       {
/* 122 */         if (!this.con.isClosed())
/*     */         {
/*     */           try
/*     */           {
/* 126 */             Statement stmt = this.con.createStatement();
/* 127 */             stmt.execute("select * from msysvar where vartype='onerow'");
/* 128 */             stmt.close();
/* 129 */             return true;
/*     */           }
/*     */           catch (SQLException e)
/*     */           {
/* 133 */             e.printStackTrace();
/* 134 */             System.out.println("DBConn : recreate DBConn");
/*     */             try
/*     */             {
/* 137 */               this.con.close();
/*     */             }
/*     */             catch (Exception ex)
/*     */             {
/* 141 */               e.printStackTrace();
/*     */             }
/*     */             finally
/*     */             {
/* 145 */               this.con.close();
/*     */             }
/* 147 */             this.con = null;
/*     */           }
/*     */         }
/* 150 */         this.con = null;
/*     */       }
/*     */ 
/* 153 */       if (this.JUrl.getDBType().equalsIgnoreCase("ORACLE"))
/*     */       {
/* 155 */         dbType = 1;
/*     */       }
/* 157 */       else if (this.JUrl.getDBType().equalsIgnoreCase("INFORMIX"))
/*     */       {
/* 159 */         dbType = 2;
/*     */       }
/* 161 */       else if (this.JUrl.getDBType().equalsIgnoreCase("SQLSERVER"))
/*     */       {
/* 163 */         dbType = 3;
/*     */       }
/* 165 */       else if (this.JUrl.getDBType().equalsIgnoreCase("DB2"))
/*     */       {
/* 167 */         dbType = 4;
/*     */       }
/* 169 */       else if (this.JUrl.getDBType().equalsIgnoreCase("SYBASE"))
/*     */       {
/* 171 */         dbType = 5;
/*     */       }
/* 173 */       else if (this.JUrl.getDBType().equalsIgnoreCase("SQLSERVER2012"))
/*     */       {
/* 175 */         dbType = 6;
/*     */       }
/*     */ 
/* 179 */       switch (dbType)
/*     */       {
/*     */       case 1:
/* 184 */         Class.forName("oracle.jdbc.driver.OracleDriver");
/* 185 */         break;
/*     */       case 2:
/* 189 */         Class.forName("com.informix.jdbc.IfxDriver");
/* 190 */         break;
/*     */       case 3:
/* 194 */         Class.forName("com.inet.tds.TdsDriver");
/* 195 */         break;
/*     */       case 4:
/* 199 */         Class.forName("com.ibm.db2.jcc.DB2Driver");
/* 200 */         break;
/*     */       case 5:
/* 204 */         Class.forName("com.sybase.jdbc2.jdbc.SybDriver");
/* 205 */         break;
/*     */       case 6:
/* 210 */         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
/* 211 */         break;
/*     */       default:
/* 213 */         System.out.println("\u76EE\u524D\u6682\u4E0D\u652F\u6301\u6B64\u79CD\u7C7B\u578B\u7684\u6570\u636E\u5E93!");
/* 214 */         return false;
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 219 */       return false;
/*     */     }
/*     */     try
/*     */     {
/* 223 */       System.out.println("\u7A0B\u5E8F\u4E2D\u521B\u5EFA\u8FDE\u63A5\u3002\u3002\u3002\u3002\u3002\u3002\u3002\u3002\u3002\u3002");
/* 224 */       switch (dbType)
/*     */       {
/*     */       case 1:
/* 229 */         Properties props = new Properties();
/* 230 */         props.setProperty("user", this.JUrl.getUserName());
/* 231 */         props.setProperty("password", this.JUrl.getPassWord());
/*     */ 
/* 233 */         props.setProperty("defaultRowPrefetch", "50");
/* 234 */         props.setProperty("defaultExecuteBatch", "50");
/* 235 */         this.con = DriverManager.getConnection(this.JUrl.getJdbcUrl(), props);
/*     */ 
/* 237 */         Statement stmt = this.con.createStatement(1005, 
/* 238 */           1008);
/* 239 */         stmt.execute("alter session set nls_date_format = 'YYYY-MM-DD HH24:MI:SS'");
/* 240 */         stmt.close();
/* 241 */         break;
/*     */       case 2:
/* 245 */         this.con = DriverManager.getConnection(this.JUrl.getJdbcUrl());
/* 246 */         break;
/*     */       case 3:
/* 250 */         this.con = DriverManager.getConnection(this.JUrl.getJdbcUrl(), this.JUrl.getUserName(), 
/* 251 */           this.JUrl.getPassWord());
/* 252 */         break;
/*     */       case 4:
/* 255 */         this.con = DriverManager.getConnection(this.JUrl.getJdbcUrl(), this.JUrl.getUserName(), 
/* 256 */           this.JUrl.getPassWord());
/* 257 */         break;
/*     */       case 5:
/* 260 */         this.con = DriverManager.getConnection(this.JUrl.getJdbcUrl(), this.JUrl.getUserName(), 
/* 261 */           this.JUrl.getPassWord());
/* 262 */         break;
/*     */       case 6:
/* 264 */         this.con = DriverManager.getConnection(this.JUrl.getJdbcUrl(), 
/* 265 */           this.JUrl.getUserName(), 
/* 266 */           this.JUrl.getPassWord());
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 272 */       System.out.println("\u521B\u5EFA\u8FDE\u63A5\u5931\u8D25...");
/* 273 */       return false;
/*     */     }
/* 275 */     return true;
/*     */   }
/*     */ 
/*     */   private boolean getJBOSSPoolConnection()
/*     */   {
/*     */     try
/*     */     {
/* 282 */       Context tContext = new InitialContext();
/* 283 */       DataSource tDataSource = (DataSource)tContext.lookup("jdbc/" + this.JUrl.getDBName());
/* 284 */       if (tDataSource != null) {
/* 285 */         this.con = tDataSource.getConnection();
/* 286 */         if (this.con != null) {
/* 287 */           System.out.println("/banklns--- new Connection from JBOSS Pool ...");
/* 288 */           return true;
/*     */         }
/* 290 */         System.out.println("new Connection error ...");
/* 291 */         return false;
/*     */       }
/*     */ 
/* 294 */       System.out.println("new DataSource error ...");
/* 295 */       return false;
/*     */     }
/*     */     catch (Throwable e)
/*     */     {
/* 300 */       System.out.println("look for jndi name error ...");
/* 301 */     }return false;
/*     */   }
/*     */ 
/*     */   private boolean getWeblogicPoolConnection()
/*     */   {
/*     */     try
/*     */     {
/* 309 */       Driver myDriver = (Driver)Class.forName("weblogic.jdbc.pool.Driver").newInstance();
/* 310 */       this.con = myDriver.connect(this.JUrl.getJdbcUrl(), null);
/* 311 */       Statement stmt = this.con.createStatement(1005, 
/* 312 */         1008);
/* 313 */       stmt.execute("alter session set nls_date_format = 'YYYY-MM-DD HH24:MI:SS'");
/* 314 */       stmt.close();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 318 */       System.out.println("$$$$$$$$WebLogicPool Connect Failed$$$$$");
/* 319 */       return false;
/*     */     }
/*     */ 
/* 322 */     return true;
/*     */   }
/*     */ 
/*     */   private boolean getApachecommonDBCP()
/*     */   {
/*     */     try
/*     */     {
/* 330 */       Context tContext = new InitialContext();
/* 331 */       tContext = (Context)tContext.lookup("java:comp/env");
/* 332 */       Object obj = tContext.lookup(this.JUrl.getDBName());
/* 333 */       DataSource tDataSource = (DataSource)obj;
/* 334 */       if (tDataSource != null)
/*     */       {
/* 336 */         this.con = tDataSource.getConnection();
/*     */ 
/* 339 */         return this.con != null;
/*     */       }
/*     */ 
/* 345 */       System.out.println("a error occured when geting datasource");
/* 346 */       return false;
/*     */     }
/*     */     catch (Throwable e)
/*     */     {
/* 351 */       System.out.println("failure when connect apache commons dbcp ");
/* 352 */       e.printStackTrace();
/* 353 */     }return false;
/*     */   }
/*     */ 
/*     */   private boolean getWebSpherePoolConnection()
/*     */   {
/*     */     try
/*     */     {
/* 361 */       Context tContext = new InitialContext();
/* 362 */       DataSource tDataSource = (DataSource)tContext.lookup("java:comp/env/" + this.JUrl.getDBName());
/* 363 */       if (tDataSource != null)
/*     */       {
/* 365 */         this.con = tDataSource.getConnection();
/* 366 */         Statement stmt = this.con.createStatement(1005, 
/* 368 */           1008);
/* 369 */         stmt.execute(
/* 370 */           "alter session set nls_date_format = 'YYYY-MM-DD HH24:MI:SS'");
/* 371 */         stmt.close();
/*     */ 
/* 373 */         if (this.con != null)
/*     */         {
/* 375 */           System.out.println("Connect succeed from websphere!");
/* 376 */           return true;
/*     */         }
/*     */ 
/* 380 */         System.out.println("new Connection error ...");
/* 381 */         return false;
/*     */       }
/*     */ 
/* 386 */       System.out.println("new DataSource error ...");
/* 387 */       return false;
/*     */     }
/*     */     catch (Throwable e)
/*     */     {
/* 392 */       System.out.println("look for jndi name error ...");
/* 393 */       e.printStackTrace();
/* 394 */     }return false;
/*     */   }
/*     */ 
/*     */   protected DBConn()
/*     */   {
/* 401 */     this.JUrl = new JdbcUrl();
/*     */ 
/* 403 */     this.bNotInUse = true;
/*     */   }
/*     */ 
/*     */   protected boolean isInnerClose()
/*     */   {
/*     */     try
/*     */     {
/* 410 */       if (this.con == null)
/*     */       {
/* 412 */         return true;
/*     */       }
/*     */ 
/* 415 */       return this.con.isClosed();
/*     */     }
/*     */     catch (SQLException ex) {
/*     */     }
/* 419 */     return true;
/*     */   }
/*     */ 
/*     */   protected void setInUse()
/*     */   {
/* 426 */     new Throwable().printStackTrace(this.m_pw);
/*     */ 
/* 428 */     this.bNotInUse = false;
/*     */ 
/* 431 */     setLastestAccess();
/*     */   }
/*     */ 
/*     */   protected boolean isInUse()
/*     */   {
/* 438 */     return !this.bNotInUse;
/*     */   }
/*     */ 
/*     */   public void clearWarnings()
/*     */     throws SQLException
/*     */   {
/* 446 */     this.con.clearWarnings();
/*     */   }
/*     */ 
/*     */   public void close()
/*     */     throws SQLException
/*     */   {
/* 454 */     if (this.bIsPool)
/*     */     {
/* 459 */       this.con.close();
/*     */     }
/*     */     else
/*     */     {
/* 464 */       this.m_buf.reset();
/* 465 */       this.bNotInUse = true;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void commit()
/*     */     throws SQLException
/*     */   {
/* 472 */     this.con.commit();
/*     */   }
/*     */ 
/*     */   public Statement createStatement()
/*     */     throws SQLException
/*     */   {
/* 478 */     return this.con.createStatement();
/*     */   }
/*     */ 
/*     */   public Statement createStatement(int resultSetType, int resultSetConcurrency)
/*     */     throws SQLException
/*     */   {
/* 486 */     return this.con.createStatement(resultSetType, resultSetConcurrency);
/*     */   }
/*     */ 
/*     */   public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
/*     */   {
/*     */     try
/*     */     {
/* 496 */       return this.con.createStatement(resultSetType, resultSetConcurrency, 
/* 497 */         resultSetHoldability);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 501 */       ex.printStackTrace();
/*     */     }
/* 503 */     return null;
/*     */   }
/*     */ 
/*     */   public boolean getAutoCommit()
/*     */     throws SQLException
/*     */   {
/* 509 */     return this.con.getAutoCommit();
/*     */   }
/*     */ 
/*     */   public String getCatalog()
/*     */     throws SQLException
/*     */   {
/* 515 */     return this.con.getCatalog();
/*     */   }
/*     */ 
/*     */   public int getHoldability()
/*     */   {
/*     */     try
/*     */     {
/* 523 */       return this.con.getHoldability();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 527 */       ex.printStackTrace();
/*     */     }
/* 529 */     return 0;
/*     */   }
/*     */ 
/*     */   public DatabaseMetaData getMetaData()
/*     */     throws SQLException
/*     */   {
/* 536 */     return this.con.getMetaData();
/*     */   }
/*     */ 
/*     */   public int getTransactionIsolation()
/*     */     throws SQLException
/*     */   {
/* 542 */     return this.con.getTransactionIsolation();
/*     */   }
/*     */ 
/*     */   public Map getTypeMap()
/*     */     throws SQLException
/*     */   {
/* 548 */     return this.con.getTypeMap();
/*     */   }
/*     */ 
/*     */   public SQLWarning getWarnings()
/*     */     throws SQLException
/*     */   {
/* 554 */     return this.con.getWarnings();
/*     */   }
/*     */ 
/*     */   public boolean isClosed()
/*     */     throws SQLException
/*     */   {
/* 560 */     if (this.bNotInUse)
/*     */     {
/* 562 */       return true;
/*     */     }
/*     */ 
/* 566 */     return this.con.isClosed();
/*     */   }
/*     */ 
/*     */   public boolean isReadOnly()
/*     */     throws SQLException
/*     */   {
/* 573 */     return this.con.isReadOnly();
/*     */   }
/*     */ 
/*     */   public String nativeSQL(String sql)
/*     */     throws SQLException
/*     */   {
/* 579 */     return this.con.nativeSQL(sql);
/*     */   }
/*     */ 
/*     */   public CallableStatement prepareCall(String sql)
/*     */     throws SQLException
/*     */   {
/* 585 */     return this.con.prepareCall(sql);
/*     */   }
/*     */ 
/*     */   public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency)
/*     */     throws SQLException
/*     */   {
/* 593 */     return this.con.prepareCall(sql, resultSetType, resultSetConcurrency);
/*     */   }
/*     */ 
/*     */   public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
/*     */   {
/*     */     try
/*     */     {
/* 603 */       return this.con.prepareCall(sql, resultSetType, resultSetConcurrency, 
/* 604 */         resultSetHoldability);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 608 */       ex.printStackTrace();
/*     */     }
/* 610 */     return null;
/*     */   }
/*     */ 
/*     */   public PreparedStatement prepareStatement(String sql)
/*     */     throws SQLException
/*     */   {
/* 616 */     return this.con.prepareStatement(sql);
/*     */   }
/*     */ 
/*     */   public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys)
/*     */   {
/*     */     try
/*     */     {
/* 625 */       return this.con.prepareStatement(sql, autoGeneratedKeys);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 629 */       ex.printStackTrace();
/*     */     }
/* 631 */     return null;
/*     */   }
/*     */ 
/*     */   public PreparedStatement prepareStatement(String sql, int[] columnIndexes)
/*     */   {
/*     */     try
/*     */     {
/* 638 */       return this.con.prepareStatement(sql, columnIndexes);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 642 */       ex.printStackTrace();
/*     */     }
/* 644 */     return null;
/*     */   }
/*     */ 
/*     */   public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
/*     */     throws SQLException
/*     */   {
/* 653 */     return this.con.prepareStatement(sql, resultSetType, resultSetConcurrency);
/*     */   }
/*     */ 
/*     */   public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
/*     */   {
/*     */     try
/*     */     {
/* 663 */       return this.con.prepareStatement(sql, resultSetType, 
/* 664 */         resultSetConcurrency, 
/* 665 */         resultSetHoldability);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 669 */       ex.printStackTrace();
/*     */     }
/* 671 */     return null;
/*     */   }
/*     */ 
/*     */   public PreparedStatement prepareStatement(String sql, String[] columnNames)
/*     */   {
/*     */     try
/*     */     {
/* 678 */       return this.con.prepareStatement(sql, columnNames);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 682 */       ex.printStackTrace();
/*     */     }
/* 684 */     return null;
/*     */   }
/*     */ 
/*     */   public void releaseSavepoint(Savepoint savepoint)
/*     */   {
/*     */     try
/*     */     {
/* 691 */       this.con.releaseSavepoint(savepoint);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 695 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void rollback()
/*     */     throws SQLException
/*     */   {
/* 703 */     this.con.rollback();
/*     */   }
/*     */ 
/*     */   public void rollback(Savepoint savepoint)
/*     */   {
/*     */     try
/*     */     {
/* 710 */       this.con.rollback(savepoint);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 714 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setAutoCommit(boolean autoCommit)
/*     */     throws SQLException
/*     */   {
/* 722 */     if (this.con.getAutoCommit())
/*     */     {
/* 724 */       this.con.setAutoCommit(autoCommit);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setCatalog(String catalog)
/*     */     throws SQLException
/*     */   {
/* 731 */     this.con.setCatalog(catalog);
/*     */   }
/*     */ 
/*     */   public void setHoldability(int holdability)
/*     */   {
/*     */     try
/*     */     {
/* 738 */       this.con.setHoldability(holdability);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 742 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setReadOnly(boolean readOnly)
/*     */     throws SQLException
/*     */   {
/* 750 */     this.con.setReadOnly(readOnly);
/*     */   }
/*     */ 
/*     */   public Savepoint setSavepoint()
/*     */   {
/*     */     try
/*     */     {
/* 757 */       return this.con.setSavepoint();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 761 */       ex.printStackTrace();
/*     */     }
/* 763 */     return null;
/*     */   }
/*     */ 
/*     */   public Savepoint setSavepoint(String name)
/*     */   {
/*     */     try
/*     */     {
/* 770 */       return this.con.setSavepoint(name);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 774 */       ex.printStackTrace();
/*     */     }
/* 776 */     return null;
/*     */   }
/*     */ 
/*     */   public void setTransactionIsolation(int level)
/*     */     throws SQLException
/*     */   {
/* 782 */     this.con.setTransactionIsolation(level);
/*     */   }
/*     */ 
/*     */   public void setTypeMap(Map map) throws SQLException {
/* 786 */     this.con.setTypeMap(map);
/*     */   }
/*     */ 
/*     */   protected void dumpConnInfo(OutputStream os)
/*     */     throws Exception
/*     */   {
/* 794 */     if (!isClosed())
/*     */     {
/* 796 */       os.write(this.m_buf.toString().getBytes());
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void setLastestAccess()
/*     */   {
/* 802 */     this.m_lastestAccess = new Date();
/*     */   }
/*     */ 
/*     */   protected Date getLastestAccess()
/*     */   {
/* 807 */     return this.m_lastestAccess;
/*     */   }
/*     */ 
/*     */   protected void innerClose()
/*     */   {
/* 812 */     System.out.println("DBConn.innerClose");
/* 813 */     if (isInUse())
/*     */     {
/* 815 */       return;
/*     */     }
/*     */ 
/* 818 */     this.m_lastestAccess = null;
/*     */     try
/*     */     {
/* 822 */       this.con.rollback();
/* 823 */       this.con.close();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 827 */       ex.printStackTrace();
/* 828 */       this.con = null;
/*     */     }
/*     */   }
/*     */ 
/*     */   public Array createArrayOf(String arg0, Object[] arg1)
/*     */     throws SQLException
/*     */   {
/* 835 */     return null;
/*     */   }
/*     */ 
/*     */   public Blob createBlob()
/*     */     throws SQLException
/*     */   {
/* 841 */     return null;
/*     */   }
/*     */ 
/*     */   public Clob createClob()
/*     */     throws SQLException
/*     */   {
/* 847 */     return null;
/*     */   }
/*     */ 
/*     */   public Struct createStruct(String arg0, Object[] arg1) throws SQLException
/*     */   {
/* 852 */     return null;
/*     */   }
/*     */ 
/*     */   public Properties getClientInfo()
/*     */     throws SQLException
/*     */   {
/* 858 */     return null;
/*     */   }
/*     */ 
/*     */   public String getClientInfo(String arg0)
/*     */     throws SQLException
/*     */   {
/* 864 */     return null;
/*     */   }
/*     */ 
/*     */   public boolean isValid(int arg0)
/*     */     throws SQLException
/*     */   {
/* 870 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean isWrapperFor(Class<?> arg0) throws SQLException
/*     */   {
/* 875 */     return false;
/*     */   }
/*     */ 
/*     */   public <T> T unwrap(Class<T> arg0)
/*     */     throws SQLException
/*     */   {
/* 881 */     return null;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.DBConn
 * JD-Core Version:    0.6.0
 */