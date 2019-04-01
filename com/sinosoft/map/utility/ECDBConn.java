/*     */ package com.sinosoft.map.utility;
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
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import javax.naming.Context;
/*     */ import javax.naming.InitialContext;
/*     */ import javax.sql.DataSource;
/*     */ 
/*     */ public class ECDBConn
/*     */   implements Connection
/*     */ {
/*     */   private ECJdbcUrl ECJUrl;
/*  36 */   private Connection con = null;
/*     */   private boolean bNotInUse;
/*  38 */   private boolean bIsPool = false;
/*  39 */   private Date m_lastestAccess = null;
/*  40 */   private CharArrayWriter m_buf = new CharArrayWriter();
/*  41 */   private PrintWriter m_pw = new PrintWriter(this.m_buf, true);
/*     */ 
/*     */   public boolean createECConnection()
/*     */   {
/*  46 */     int dbType = 0;
/*     */ 
/*  48 */     if (this.ECJUrl.getDBType().equalsIgnoreCase("WEBLOGICPOOL"))
/*     */     {
/*  50 */       dbType = 10;
/*  51 */       this.bIsPool = true;
/*  52 */       if (getWeblogicPoolConnection())
/*     */       {
/*  54 */         return true;
/*     */       }
/*     */ 
/*  59 */       ECJdbcUrlBackUp tECJdbcUrlBackUp = new ECJdbcUrlBackUp();
/*  60 */       this.ECJUrl.setDBName(tECJdbcUrlBackUp.getDBName());
/*  61 */       this.ECJUrl.setDBType(tECJdbcUrlBackUp.getDBType());
/*  62 */       this.ECJUrl.setIP(tECJdbcUrlBackUp.getIP());
/*  63 */       this.ECJUrl.setPassWord(tECJdbcUrlBackUp.getPassWord());
/*  64 */       this.ECJUrl.setPort(tECJdbcUrlBackUp.getPort());
/*  65 */       this.ECJUrl.setServerName(tECJdbcUrlBackUp.getServerName());
/*  66 */       this.ECJUrl.setUser(tECJdbcUrlBackUp.getUserName());
/*     */     }
/*  70 */     else if (this.ECJUrl.getDBType().equalsIgnoreCase("COMMONSDBCP"))
/*     */     {
/*  72 */       this.bIsPool = true;
/*  73 */       if (getApachecommonDBCP())
/*     */       {
/*  75 */         return true;
/*     */       }
/*     */ 
/*  80 */       ECJdbcUrlBackUp tECJdbcUrlBackUp = new ECJdbcUrlBackUp();
/*  81 */       this.ECJUrl.setDBName(tECJdbcUrlBackUp.getDBName());
/*  82 */       this.ECJUrl.setDBType(tECJdbcUrlBackUp.getDBType());
/*  83 */       this.ECJUrl.setIP(tECJdbcUrlBackUp.getIP());
/*  84 */       this.ECJUrl.setPassWord(tECJdbcUrlBackUp.getPassWord());
/*  85 */       this.ECJUrl.setPort(tECJdbcUrlBackUp.getPort());
/*  86 */       this.ECJUrl.setServerName(tECJdbcUrlBackUp.getServerName());
/*  87 */       this.ECJUrl.setUser(tECJdbcUrlBackUp.getUserName());
/*     */     }
/*  91 */     else if (this.ECJUrl.getDBType().equalsIgnoreCase("WEBSPHERE"))
/*     */     {
/*  93 */       this.bIsPool = true;
/*  94 */       if (getWebSpherePoolConnection())
/*     */       {
/*  96 */         return true;
/*     */       }
/*     */ 
/* 101 */       ECJdbcUrlBackUp tECJdbcUrlBackUp = new ECJdbcUrlBackUp();
/* 102 */       this.ECJUrl.setDBName(tECJdbcUrlBackUp.getDBName());
/* 103 */       this.ECJUrl.setDBType(tECJdbcUrlBackUp.getDBType());
/* 104 */       this.ECJUrl.setIP(tECJdbcUrlBackUp.getIP());
/* 105 */       this.ECJUrl.setPassWord(tECJdbcUrlBackUp.getPassWord());
/* 106 */       this.ECJUrl.setPort(tECJdbcUrlBackUp.getPort());
/* 107 */       this.ECJUrl.setServerName(tECJdbcUrlBackUp.getServerName());
/* 108 */       this.ECJUrl.setUser(tECJdbcUrlBackUp.getUserName());
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 117 */       if (this.con != null)
/*     */       {
/* 119 */         if (!this.con.isClosed())
/*     */         {
/*     */           try
/*     */           {
/* 124 */             Statement stmt = this.con.createStatement();
/* 125 */             stmt.execute("SELECT * FROM DUAL");
/* 126 */             stmt.close();
/* 127 */             return true;
/*     */           }
/*     */           catch (SQLException e)
/*     */           {
/* 131 */             e.printStackTrace();
/* 132 */             System.out.println("DBConn : recreate DBConn");
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
/* 154 */       if (this.ECJUrl.getDBType().equalsIgnoreCase("ORACLE"))
/*     */       {
/* 156 */         dbType = 1;
/*     */       }
/* 158 */       else if (this.ECJUrl.getDBType().equalsIgnoreCase("INFORMIX"))
/*     */       {
/* 160 */         dbType = 2;
/*     */       }
/* 162 */       else if (this.ECJUrl.getDBType().equalsIgnoreCase("SQLSERVER"))
/*     */       {
/* 164 */         dbType = 3;
/*     */       }
/* 166 */       else if (this.ECJUrl.getDBType().equalsIgnoreCase("DB2"))
/*     */       {
/* 168 */         dbType = 4;
/*     */       }
/* 170 */       else if (this.ECJUrl.getDBType().equalsIgnoreCase("SYBASE"))
/*     */       {
/* 172 */         dbType = 5;
/*     */       }
/*     */ 
/* 176 */       switch (dbType)
/*     */       {
/*     */       case 1:
/* 181 */         Class.forName("oracle.jdbc.driver.OracleDriver");
/* 182 */         break;
/*     */       case 2:
/* 186 */         Class.forName("com.informix.jdbc.IfxDriver");
/* 187 */         break;
/*     */       case 3:
/* 191 */         Class.forName("com.inet.tds.TdsDriver");
/* 192 */         break;
/*     */       case 4:
/* 196 */         Class.forName("com.ibm.db2.jcc.DB2Driver");
/* 197 */         break;
/*     */       case 5:
/* 201 */         Class.forName("com.sybase.jdbc2.jdbc.SybDriver");
/* 202 */         break;
/*     */       default:
/* 204 */         System.out.println("\u76EE\u524D\u951F\u6377\u8BE7\u62F7\u652F\u951F\u8857\u8FBE\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9175\u7889\u62F7\u951F\u65A4\u62F7\u951F\u6377\u5321\u62F7!");
/* 205 */         return false;
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 210 */       return false;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 215 */       switch (dbType)
/*     */       {
/*     */       case 1:
/* 223 */         Properties props = new Properties();
/* 224 */         props.setProperty("user", this.ECJUrl.getUserName());
/* 225 */         props.setProperty("password", this.ECJUrl.getPassWord());
/*     */ 
/* 228 */         props.setProperty("defaultRowPrefetch", "50");
/* 229 */         props.setProperty("defaultExecuteBatch", "50");
/* 230 */         this.con = DriverManager.getConnection(this.ECJUrl.getJdbcUrl(), props);
/*     */ 
/* 234 */         Statement stmt = this.con.createStatement(1005, 
/* 235 */           1008);
/* 236 */         stmt.execute("alter session set nls_date_format = 'YYYY-MM-DD HH24:MI:SS'");
/* 237 */         stmt.close();
/* 238 */         break;
/*     */       case 2:
/* 243 */         this.con = DriverManager.getConnection(this.ECJUrl.getJdbcUrl());
/* 244 */         break;
/*     */       case 3:
/* 249 */         this.con = DriverManager.getConnection(this.ECJUrl.getJdbcUrl(), this.ECJUrl.getUserName(), 
/* 250 */           this.ECJUrl.getPassWord());
/* 251 */         break;
/*     */       case 4:
/* 255 */         this.con = DriverManager.getConnection(this.ECJUrl.getJdbcUrl(), this.ECJUrl.getUserName(), 
/* 256 */           this.ECJUrl.getPassWord());
/* 257 */         break;
/*     */       case 5:
/* 261 */         this.con = DriverManager.getConnection(this.ECJUrl.getJdbcUrl(), this.ECJUrl.getUserName(), 
/* 262 */           this.ECJUrl.getPassWord());
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 268 */       System.out.println("\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7...");
/* 269 */       return false;
/*     */     }
/* 271 */     return true;
/*     */   }
/*     */ 
/*     */   private boolean getWeblogicPoolConnection()
/*     */   {
/*     */     try
/*     */     {
/* 280 */       Driver myDriver = (Driver)Class.forName("weblogic.jdbc.pool.Driver").newInstance();
/*     */ 
/* 282 */       this.con = myDriver.connect(this.ECJUrl.getJdbcUrl(), null);
/* 283 */       Statement stmt = this.con.createStatement(1005, 
/* 284 */         1008);
/* 285 */       stmt.execute("alter session set nls_date_format = 'YYYY-MM-DD HH24:MI:SS'");
/* 286 */       stmt.close();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 290 */       System.out.println("$$$$$$$$WebLogicPool Connect Failed$$$$$");
/* 291 */       return false;
/*     */     }
/*     */ 
/* 294 */     return true;
/*     */   }
/*     */ 
/*     */   private boolean getApachecommonDBCP()
/*     */   {
/*     */     try
/*     */     {
/* 303 */       Context tContext = new InitialContext();
/* 304 */       tContext = (Context)tContext.lookup("java:comp/env");
/* 305 */       Object obj = tContext.lookup(this.ECJUrl.getDBName());
/* 306 */       DataSource tDataSource = (DataSource)obj;
/* 307 */       if (tDataSource != null)
/*     */       {
/* 309 */         this.con = tDataSource.getConnection();
/*     */ 
/* 320 */         return this.con != null;
/*     */       }
/*     */ 
/* 326 */       System.out.println("a error occured when geting datasource");
/* 327 */       return false;
/*     */     }
/*     */     catch (Throwable e)
/*     */     {
/* 332 */       System.out.println("failure when connect apache commons dbcp ");
/* 333 */       e.printStackTrace();
/* 334 */     }return false;
/*     */   }
/*     */ 
/*     */   private boolean getWebSpherePoolConnection()
/*     */   {
/*     */     try
/*     */     {
/* 343 */       Context tContext = new InitialContext();
/*     */ 
/* 347 */       DataSource tDataSource = (DataSource)tContext.lookup(this.ECJUrl.getDBName());
/*     */ 
/* 349 */       if (tDataSource != null)
/*     */       {
/* 351 */         this.con = tDataSource.getConnection();
/* 352 */         Statement stmt = this.con.createStatement(1005, 
/* 354 */           1008);
/* 355 */         stmt.execute(
/* 356 */           "alter session set nls_date_format = 'YYYY-MM-DD HH24:MI:SS'");
/* 357 */         stmt.close();
/*     */ 
/* 359 */         if (this.con != null)
/*     */         {
/* 361 */           System.out.println("Connect succeed from websphere!");
/* 362 */           return true;
/*     */         }
/*     */ 
/* 366 */         System.out.println("new Connection error ...");
/* 367 */         return false;
/*     */       }
/*     */ 
/* 372 */       System.out.println("new DataSource error ...");
/* 373 */       return false;
/*     */     }
/*     */     catch (Throwable e)
/*     */     {
/* 378 */       System.out.println("look for jndi name error ...");
/* 379 */       e.printStackTrace();
/* 380 */     }return false;
/*     */   }
/*     */ 
/*     */   protected ECDBConn()
/*     */   {
/* 387 */     this.ECJUrl = new ECJdbcUrl();
/*     */ 
/* 389 */     this.bNotInUse = true;
/*     */   }
/*     */ 
/*     */   protected boolean isInnerClose()
/*     */   {
/*     */     try
/*     */     {
/* 396 */       if (this.con == null)
/*     */       {
/* 398 */         return true;
/*     */       }
/*     */ 
/* 401 */       return this.con.isClosed();
/*     */     }
/*     */     catch (SQLException ex) {
/*     */     }
/* 405 */     return true;
/*     */   }
/*     */ 
/*     */   protected void setInUse()
/*     */   {
/* 412 */     new Throwable().printStackTrace(this.m_pw);
/*     */ 
/* 414 */     this.bNotInUse = false;
/*     */ 
/* 417 */     setLastestAccess();
/*     */   }
/*     */ 
/*     */   protected boolean isInUse()
/*     */   {
/* 424 */     return !this.bNotInUse;
/*     */   }
/*     */ 
/*     */   public void clearWarnings()
/*     */     throws SQLException
/*     */   {
/* 432 */     this.con.clearWarnings();
/*     */   }
/*     */ 
/*     */   public void close()
/*     */     throws SQLException
/*     */   {
/* 440 */     if (this.bIsPool)
/*     */     {
/* 445 */       this.con.close();
/*     */     }
/*     */     else
/*     */     {
/* 450 */       this.m_buf.reset();
/* 451 */       this.bNotInUse = true;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void commit()
/*     */     throws SQLException
/*     */   {
/* 458 */     this.con.commit();
/*     */   }
/*     */ 
/*     */   public Statement createStatement()
/*     */     throws SQLException
/*     */   {
/* 464 */     return this.con.createStatement();
/*     */   }
/*     */ 
/*     */   public Statement createStatement(int resultSetType, int resultSetConcurrency)
/*     */     throws SQLException
/*     */   {
/* 472 */     return this.con.createStatement(resultSetType, resultSetConcurrency);
/*     */   }
/*     */ 
/*     */   public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
/*     */   {
/*     */     try
/*     */     {
/* 482 */       return this.con.createStatement(resultSetType, resultSetConcurrency, 
/* 483 */         resultSetHoldability);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 487 */       ex.printStackTrace();
/*     */     }
/* 489 */     return null;
/*     */   }
/*     */ 
/*     */   public boolean getAutoCommit()
/*     */     throws SQLException
/*     */   {
/* 495 */     return this.con.getAutoCommit();
/*     */   }
/*     */ 
/*     */   public String getCatalog()
/*     */     throws SQLException
/*     */   {
/* 501 */     return this.con.getCatalog();
/*     */   }
/*     */ 
/*     */   public int getHoldability()
/*     */   {
/*     */     try
/*     */     {
/* 509 */       return this.con.getHoldability();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 513 */       ex.printStackTrace();
/*     */     }
/* 515 */     return 0;
/*     */   }
/*     */ 
/*     */   public DatabaseMetaData getMetaData()
/*     */     throws SQLException
/*     */   {
/* 522 */     return this.con.getMetaData();
/*     */   }
/*     */ 
/*     */   public int getTransactionIsolation()
/*     */     throws SQLException
/*     */   {
/* 528 */     return this.con.getTransactionIsolation();
/*     */   }
/*     */ 
/*     */   public Map getTypeMap()
/*     */     throws SQLException
/*     */   {
/* 534 */     return this.con.getTypeMap();
/*     */   }
/*     */ 
/*     */   public SQLWarning getWarnings()
/*     */     throws SQLException
/*     */   {
/* 540 */     return this.con.getWarnings();
/*     */   }
/*     */ 
/*     */   public boolean isClosed()
/*     */     throws SQLException
/*     */   {
/* 546 */     if (this.bNotInUse)
/*     */     {
/* 548 */       return true;
/*     */     }
/*     */ 
/* 552 */     return this.con.isClosed();
/*     */   }
/*     */ 
/*     */   public boolean isReadOnly()
/*     */     throws SQLException
/*     */   {
/* 559 */     return this.con.isReadOnly();
/*     */   }
/*     */ 
/*     */   public String nativeSQL(String sql)
/*     */     throws SQLException
/*     */   {
/* 565 */     return this.con.nativeSQL(sql);
/*     */   }
/*     */ 
/*     */   public CallableStatement prepareCall(String sql)
/*     */     throws SQLException
/*     */   {
/* 571 */     return this.con.prepareCall(sql);
/*     */   }
/*     */ 
/*     */   public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency)
/*     */     throws SQLException
/*     */   {
/* 579 */     return this.con.prepareCall(sql, resultSetType, resultSetConcurrency);
/*     */   }
/*     */ 
/*     */   public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
/*     */   {
/*     */     try
/*     */     {
/* 589 */       return this.con.prepareCall(sql, resultSetType, resultSetConcurrency, 
/* 590 */         resultSetHoldability);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 594 */       ex.printStackTrace();
/*     */     }
/* 596 */     return null;
/*     */   }
/*     */ 
/*     */   public PreparedStatement prepareStatement(String sql)
/*     */     throws SQLException
/*     */   {
/* 602 */     return this.con.prepareStatement(sql);
/*     */   }
/*     */ 
/*     */   public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys)
/*     */   {
/*     */     try
/*     */     {
/* 611 */       return this.con.prepareStatement(sql, autoGeneratedKeys);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 615 */       ex.printStackTrace();
/*     */     }
/* 617 */     return null;
/*     */   }
/*     */ 
/*     */   public PreparedStatement prepareStatement(String sql, int[] columnIndexes)
/*     */   {
/*     */     try
/*     */     {
/* 624 */       return this.con.prepareStatement(sql, columnIndexes);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 628 */       ex.printStackTrace();
/*     */     }
/* 630 */     return null;
/*     */   }
/*     */ 
/*     */   public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
/*     */     throws SQLException
/*     */   {
/* 639 */     return this.con.prepareStatement(sql, resultSetType, resultSetConcurrency);
/*     */   }
/*     */ 
/*     */   public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
/*     */   {
/*     */     try
/*     */     {
/* 649 */       return this.con.prepareStatement(sql, resultSetType, 
/* 650 */         resultSetConcurrency, 
/* 651 */         resultSetHoldability);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 655 */       ex.printStackTrace();
/*     */     }
/* 657 */     return null;
/*     */   }
/*     */ 
/*     */   public PreparedStatement prepareStatement(String sql, String[] columnNames)
/*     */   {
/*     */     try
/*     */     {
/* 664 */       return this.con.prepareStatement(sql, columnNames);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 668 */       ex.printStackTrace();
/*     */     }
/* 670 */     return null;
/*     */   }
/*     */ 
/*     */   public void releaseSavepoint(Savepoint savepoint)
/*     */   {
/*     */     try
/*     */     {
/* 677 */       this.con.releaseSavepoint(savepoint);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 681 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void rollback()
/*     */     throws SQLException
/*     */   {
/* 689 */     this.con.rollback();
/*     */   }
/*     */ 
/*     */   public void rollback(Savepoint savepoint)
/*     */   {
/*     */     try
/*     */     {
/* 696 */       this.con.rollback(savepoint);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 700 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setAutoCommit(boolean autoCommit)
/*     */     throws SQLException
/*     */   {
/* 708 */     if (this.con.getAutoCommit())
/*     */     {
/* 710 */       this.con.setAutoCommit(autoCommit);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setCatalog(String catalog)
/*     */     throws SQLException
/*     */   {
/* 717 */     this.con.setCatalog(catalog);
/*     */   }
/*     */ 
/*     */   public void setHoldability(int holdability)
/*     */   {
/*     */     try
/*     */     {
/* 724 */       this.con.setHoldability(holdability);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 728 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setReadOnly(boolean readOnly)
/*     */     throws SQLException
/*     */   {
/* 736 */     this.con.setReadOnly(readOnly);
/*     */   }
/*     */ 
/*     */   public Savepoint setSavepoint()
/*     */   {
/*     */     try
/*     */     {
/* 743 */       return this.con.setSavepoint();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 747 */       ex.printStackTrace();
/*     */     }
/* 749 */     return null;
/*     */   }
/*     */ 
/*     */   public Savepoint setSavepoint(String name)
/*     */   {
/*     */     try
/*     */     {
/* 756 */       return this.con.setSavepoint(name);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 760 */       ex.printStackTrace();
/*     */     }
/* 762 */     return null;
/*     */   }
/*     */ 
/*     */   public void setTransactionIsolation(int level)
/*     */     throws SQLException
/*     */   {
/* 768 */     this.con.setTransactionIsolation(level);
/*     */   }
/*     */ 
/*     */   public void setTypeMap(Map map)
/*     */     throws SQLException
/*     */   {
/* 774 */     this.con.setTypeMap(map);
/*     */   }
/*     */ 
/*     */   protected void dumpConnInfo(OutputStream os)
/*     */     throws Exception
/*     */   {
/* 781 */     if (!isClosed())
/*     */     {
/* 783 */       os.write(this.m_buf.toString().getBytes());
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void setLastestAccess()
/*     */   {
/* 789 */     this.m_lastestAccess = new Date();
/*     */   }
/*     */ 
/*     */   protected Date getLastestAccess()
/*     */   {
/* 794 */     return this.m_lastestAccess;
/*     */   }
/*     */ 
/*     */   protected void innerClose()
/*     */   {
/* 799 */     System.out.println("DBConn.innerClose");
/* 800 */     if (isInUse())
/*     */     {
/* 802 */       return;
/*     */     }
/*     */ 
/* 805 */     this.m_lastestAccess = null;
/*     */     try
/*     */     {
/* 809 */       this.con.rollback();
/* 810 */       this.con.close();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 814 */       ex.printStackTrace();
/* 815 */       this.con = null;
/*     */     }
/*     */   }
/*     */ 
/*     */   public Array createArrayOf(String typeName, Object[] elements)
/*     */     throws SQLException
/*     */   {
/* 823 */     return null;
/*     */   }
/*     */ 
/*     */   public Blob createBlob()
/*     */     throws SQLException
/*     */   {
/* 829 */     return null;
/*     */   }
/*     */ 
/*     */   public Clob createClob()
/*     */     throws SQLException
/*     */   {
/* 835 */     return null;
/*     */   }
/*     */ 
/*     */   public Properties getClientInfo()
/*     */     throws SQLException
/*     */   {
/* 860 */     return null;
/*     */   }
/*     */ 
/*     */   public String getClientInfo(String name)
/*     */     throws SQLException
/*     */   {
/* 866 */     return null;
/*     */   }
/*     */ 
/*     */   public boolean isValid(int timeout)
/*     */     throws SQLException
/*     */   {
/* 872 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean isWrapperFor(Class<?> iface)
/*     */     throws SQLException
/*     */   {
/* 898 */     return false;
/*     */   }
/*     */ 
/*     */   public <T> T unwrap(Class<T> iface)
/*     */     throws SQLException
/*     */   {
/* 904 */     return null;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.ECDBConn
 * JD-Core Version:    0.6.0
 */