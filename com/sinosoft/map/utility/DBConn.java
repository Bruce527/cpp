/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ import com.sinosoft.banklns.utility.JdbcUrlBackUp;
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
/*     */   public boolean createConnection() {
/*  44 */     int dbType = 0;
/*     */ 
/*  46 */     if (this.JUrl.getDBType().equalsIgnoreCase("WEBLOGICPOOL")) {
/*  47 */       dbType = 10;
/*  48 */       this.bIsPool = true;
/*  49 */       if (getWeblogicPoolConnection()) {
/*  50 */         return true;
/*     */       }
/*     */ 
/*  53 */       JdbcUrlBackUp tJdbcUrlBackUp = new JdbcUrlBackUp();
/*  54 */       this.JUrl.setDBName(tJdbcUrlBackUp.getDBName());
/*  55 */       this.JUrl.setDBType(tJdbcUrlBackUp.getDBType());
/*  56 */       this.JUrl.setIP(tJdbcUrlBackUp.getIP());
/*  57 */       this.JUrl.setPassWord(tJdbcUrlBackUp.getPassWord());
/*  58 */       this.JUrl.setPort(tJdbcUrlBackUp.getPort());
/*  59 */       this.JUrl.setServerName(tJdbcUrlBackUp.getServerName());
/*  60 */       this.JUrl.setUser(tJdbcUrlBackUp.getUserName());
/*     */     }
/*  64 */     else if (this.JUrl.getDBType().equalsIgnoreCase("COMMONSDBCP")) {
/*  65 */       this.bIsPool = true;
/*  66 */       if (getApachecommonDBCP()) {
/*  67 */         return true;
/*     */       }
/*     */ 
/*  70 */       JdbcUrlBackUp tJdbcUrlBackUp = new JdbcUrlBackUp();
/*  71 */       this.JUrl.setDBName(tJdbcUrlBackUp.getDBName());
/*  72 */       this.JUrl.setDBType(tJdbcUrlBackUp.getDBType());
/*  73 */       this.JUrl.setIP(tJdbcUrlBackUp.getIP());
/*  74 */       this.JUrl.setPassWord(tJdbcUrlBackUp.getPassWord());
/*  75 */       this.JUrl.setPort(tJdbcUrlBackUp.getPort());
/*  76 */       this.JUrl.setServerName(tJdbcUrlBackUp.getServerName());
/*  77 */       this.JUrl.setUser(tJdbcUrlBackUp.getUserName());
/*     */     }
/*  81 */     else if (this.JUrl.getDBType().equalsIgnoreCase("WEBSPHERE")) {
/*  82 */       this.bIsPool = true;
/*  83 */       if (getWebSpherePoolConnection()) {
/*  84 */         return true;
/*     */       }
/*     */ 
/*  87 */       JdbcUrlBackUp tJdbcUrlBackUp = new JdbcUrlBackUp();
/*  88 */       this.JUrl.setDBName(tJdbcUrlBackUp.getDBName());
/*  89 */       this.JUrl.setDBType(tJdbcUrlBackUp.getDBType());
/*  90 */       this.JUrl.setIP(tJdbcUrlBackUp.getIP());
/*  91 */       this.JUrl.setPassWord(tJdbcUrlBackUp.getPassWord());
/*  92 */       this.JUrl.setPort(tJdbcUrlBackUp.getPort());
/*  93 */       this.JUrl.setServerName(tJdbcUrlBackUp.getServerName());
/*  94 */       this.JUrl.setUser(tJdbcUrlBackUp.getUserName());
/*     */     }
/*  97 */     else if (this.JUrl.getDBType().equalsIgnoreCase("JBOSS")) {
/*  98 */       this.bIsPool = true;
/*  99 */       if (getJBOSSPoolConnection())
/* 100 */         return true;
/* 101 */       System.out.println(
/* 102 */         "/mdes--------------------jboos conPool is failed con get from jdbcurlbak-------------------------------");
/* 103 */       JdbcUrlBackUp tJdbcUrlBackUp = new JdbcUrlBackUp();
/* 104 */       this.JUrl.setDBName(tJdbcUrlBackUp.getDBName());
/* 105 */       this.JUrl.setDBType(tJdbcUrlBackUp.getDBType());
/* 106 */       this.JUrl.setIP(tJdbcUrlBackUp.getIP());
/* 107 */       this.JUrl.setPassWord(tJdbcUrlBackUp.getPassWord());
/* 108 */       this.JUrl.setPort(tJdbcUrlBackUp.getPort());
/* 109 */       this.JUrl.setServerName(tJdbcUrlBackUp.getServerName());
/* 110 */       this.JUrl.setUser(tJdbcUrlBackUp.getUserName());
/*     */     }
/*     */     try
/*     */     {
/* 114 */       if (this.con != null) {
/* 115 */         if (!this.con.isClosed()) {
/*     */           try
/*     */           {
/* 118 */             Statement stmt = this.con.createStatement();
/* 119 */             stmt.execute("select * from msysvar where vartype='onerow'");
/* 120 */             stmt.close();
/* 121 */             return true;
/*     */           } catch (SQLException e) {
/* 123 */             e.printStackTrace();
/* 124 */             System.out.println("DBConn : recreate DBConn");
/*     */             try
/*     */             {
/* 127 */               this.con.close();
/*     */             } catch (Exception ex) {
/* 129 */               e.printStackTrace();
/*     */             } finally {
/* 131 */               this.con.close();
/*     */             }
/* 133 */             this.con = null;
/*     */           }
/*     */         }
/* 136 */         this.con = null;
/*     */       }
/*     */ 
/* 139 */       if (this.JUrl.getDBType().equalsIgnoreCase("ORACLE"))
/* 140 */         dbType = 1;
/* 141 */       else if (this.JUrl.getDBType().equalsIgnoreCase("INFORMIX"))
/* 142 */         dbType = 2;
/* 143 */       else if (this.JUrl.getDBType().equalsIgnoreCase("SQLSERVER"))
/* 144 */         dbType = 3;
/* 145 */       else if (this.JUrl.getDBType().equalsIgnoreCase("DB2"))
/* 146 */         dbType = 4;
/* 147 */       else if (this.JUrl.getDBType().equalsIgnoreCase("SYBASE"))
/* 148 */         dbType = 5;
/* 149 */       else if (this.JUrl.getDBType().equalsIgnoreCase("SQLSERVER2012")) {
/* 150 */         dbType = 6;
/*     */       }
/*     */ 
/* 153 */       switch (dbType)
/*     */       {
/*     */       case 1:
/* 156 */         Class.forName("oracle.jdbc.driver.OracleDriver");
/* 157 */         break;
/*     */       case 2:
/* 160 */         Class.forName("com.informix.jdbc.IfxDriver");
/* 161 */         break;
/*     */       case 3:
/* 164 */         Class.forName("com.inet.tds.TdsDriver");
/* 165 */         break;
/*     */       case 4:
/* 168 */         Class.forName("com.ibm.db2.jcc.DB2Driver");
/* 169 */         break;
/*     */       case 5:
/* 172 */         Class.forName("com.sybase.jdbc2.jdbc.SybDriver");
/* 173 */         break;
/*     */       case 6:
/* 177 */         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
/* 178 */         break;
/*     */       default:
/* 180 */         System.out.println("\u76EE\u524D\u951F\u6377\u8BE7\u62F7\u652F\u951F\u8857\u8FBE\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9175\u7889\u62F7\u951F\u65A4\u62F7\u951F\u6377\u5321\u62F7!");
/* 181 */         return false;
/*     */       }
/*     */     } catch (Exception e) {
/* 184 */       return false;
/*     */     }
/*     */     try
/*     */     {
/* 188 */       System.out.println("\u5F00\u59CB\u83B7\u53D6\u6570\u636E\u5E93\u8FDE\u63A5......");
/* 189 */       switch (dbType)
/*     */       {
/*     */       case 1:
/* 193 */         Properties props = new Properties();
/* 194 */         props.setProperty("user", this.JUrl.getUserName());
/* 195 */         props.setProperty("password", this.JUrl.getPassWord());
/*     */ 
/* 197 */         props.setProperty("defaultRowPrefetch", "50");
/* 198 */         props.setProperty("defaultExecuteBatch", "50");
/* 199 */         this.con = DriverManager.getConnection(this.JUrl.getJdbcUrl(), props);
/*     */ 
/* 201 */         Statement stmt = this.con.createStatement(1005, 1008);
/* 202 */         stmt.execute("alter session set nls_date_format = 'YYYY-MM-DD HH24:MI:SS'");
/* 203 */         stmt.close();
/* 204 */         break;
/*     */       case 2:
/* 208 */         this.con = DriverManager.getConnection(this.JUrl.getJdbcUrl());
/* 209 */         break;
/*     */       case 3:
/* 213 */         this.con = DriverManager.getConnection(this.JUrl.getJdbcUrl(), this.JUrl.getUserName(), this.JUrl.getPassWord());
/* 214 */         break;
/*     */       case 4:
/* 217 */         this.con = DriverManager.getConnection(this.JUrl.getJdbcUrl(), this.JUrl.getUserName(), this.JUrl.getPassWord());
/* 218 */         break;
/*     */       case 5:
/* 221 */         this.con = DriverManager.getConnection(this.JUrl.getJdbcUrl(), this.JUrl.getUserName(), this.JUrl.getPassWord());
/* 222 */         break;
/*     */       case 6:
/* 224 */         this.con = DriverManager.getConnection(this.JUrl.getJdbcUrl(), this.JUrl.getUserName(), this.JUrl.getPassWord());
/*     */       }
/*     */     }
/*     */     catch (SQLException e) {
/* 228 */       System.out.println("\u83B7\u53D6\u6570\u636E\u5E93\u8FDE\u63A5\u5931\u8D25...");
/* 229 */       return false;
/*     */     }
/* 231 */     return true;
/*     */   }
/*     */ 
/*     */   private boolean getWeblogicPoolConnection() {
/*     */     try {
/* 236 */       Driver myDriver = (Driver)Class.forName("weblogic.jdbc.pool.Driver").newInstance();
/*     */ 
/* 238 */       this.con = myDriver.connect(this.JUrl.getJdbcUrl(), null);
/* 239 */       Statement stmt = this.con.createStatement(1005, 1008);
/* 240 */       stmt.execute("alter session set nls_date_format = 'YYYY-MM-DD HH24:MI:SS'");
/* 241 */       stmt.close();
/*     */     } catch (Exception ex) {
/* 243 */       System.out.println("$$$$$$$$WebLogicPool Connect Failed$$$$$");
/* 244 */       return false;
/*     */     }
/*     */ 
/* 247 */     return true;
/*     */   }
/*     */ 
/*     */   private boolean getJBOSSPoolConnection() {
/*     */     try {
/* 252 */       System.out.println("jndi name:jdbc/" + this.JUrl.getDBName());
/* 253 */       Context tContext = new InitialContext();
/* 254 */       DataSource tDataSource = (DataSource)tContext.lookup("java:comp/env/jdbc/" + this.JUrl.getDBName());
/* 255 */       if (tDataSource != null) {
/* 256 */         this.con = tDataSource.getConnection();
/* 257 */         if (this.con != null) {
/* 258 */           System.out.println("/map--- new Connection from JBOSS Pool ...");
/* 259 */           return true;
/*     */         }
/* 261 */         System.out.println("new Connection error ...");
/* 262 */         return false;
/*     */       }
/* 264 */       System.out.println("new DataSource error ...");
/* 265 */       return false;
/*     */     }
/*     */     catch (Throwable e) {
/* 268 */       System.out.println("look for jndi name error ...");
/* 269 */     }return false;
/*     */   }
/*     */ 
/*     */   private boolean getApachecommonDBCP()
/*     */   {
/*     */     try {
/* 275 */       Context tContext = new InitialContext();
/* 276 */       tContext = (Context)tContext.lookup("java:comp/env");
/* 277 */       Object obj = tContext.lookup(this.JUrl.getDBName());
/* 278 */       DataSource tDataSource = (DataSource)obj;
/* 279 */       if (tDataSource != null) {
/* 280 */         this.con = tDataSource.getConnection();
/*     */ 
/* 284 */         return this.con != null;
/*     */       }
/*     */ 
/* 288 */       System.out.println("a error occured when geting datasource");
/* 289 */       return false;
/*     */     }
/*     */     catch (Throwable e) {
/* 292 */       System.out.println("failure when connect apache commons dbcp ");
/* 293 */       e.printStackTrace();
/* 294 */     }return false;
/*     */   }
/*     */ 
/*     */   private boolean getWebSpherePoolConnection()
/*     */   {
/*     */     try {
/* 300 */       Context tContext = new InitialContext();
/* 301 */       System.out.println("------------------map_jndi-------------------------------");
/*     */ 
/* 303 */       DataSource tDataSource = (DataSource)tContext.lookup("java:comp/env/" + this.JUrl.getDBName());
/*     */ 
/* 305 */       if (tDataSource != null) {
/* 306 */         this.con = tDataSource.getConnection();
/* 307 */         Statement stmt = this.con.createStatement(1005, 1008);
/* 308 */         stmt.execute("alter session set nls_date_format = 'YYYY-MM-DD HH24:MI:SS'");
/* 309 */         stmt.close();
/*     */ 
/* 311 */         if (this.con != null) {
/* 312 */           System.out.println("Connect succeed from websphere!");
/* 313 */           return true;
/*     */         }
/* 315 */         System.out.println("new Connection error ...");
/* 316 */         return false;
/*     */       }
/*     */ 
/* 319 */       System.out.println("new DataSource error ...");
/* 320 */       return false;
/*     */     }
/*     */     catch (Throwable e) {
/* 323 */       System.out.println("look for jndi name error ...");
/* 324 */       e.printStackTrace();
/* 325 */     }return false;
/*     */   }
/*     */ 
/*     */   protected DBConn()
/*     */   {
/* 330 */     this.JUrl = new JdbcUrl();
/*     */ 
/* 332 */     this.bNotInUse = true;
/*     */   }
/*     */ 
/*     */   protected boolean isInnerClose() {
/*     */     try {
/* 337 */       if (this.con == null) {
/* 338 */         return true;
/*     */       }
/*     */ 
/* 341 */       return this.con.isClosed(); } catch (SQLException ex) {
/*     */     }
/* 343 */     return true;
/*     */   }
/*     */ 
/*     */   protected void setInUse()
/*     */   {
/* 349 */     new Throwable().printStackTrace(this.m_pw);
/*     */ 
/* 351 */     this.bNotInUse = false;
/*     */ 
/* 353 */     setLastestAccess();
/*     */   }
/*     */ 
/*     */   protected boolean isInUse() {
/* 357 */     return !this.bNotInUse;
/*     */   }
/*     */ 
/*     */   public void clearWarnings() throws SQLException {
/* 361 */     this.con.clearWarnings();
/*     */   }
/*     */ 
/*     */   public void close() throws SQLException {
/* 365 */     if (this.bIsPool)
/*     */     {
/* 367 */       this.con.close();
/*     */     }
/*     */     else {
/* 370 */       this.m_buf.reset();
/* 371 */       this.bNotInUse = true;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void commit() throws SQLException {
/* 376 */     this.con.commit();
/*     */   }
/*     */ 
/*     */   public Statement createStatement() throws SQLException {
/* 380 */     return this.con.createStatement();
/*     */   }
/*     */ 
/*     */   public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
/* 384 */     return this.con.createStatement(resultSetType, resultSetConcurrency);
/*     */   }
/*     */ 
/*     */   public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) {
/*     */     try {
/* 389 */       return this.con.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
/*     */     } catch (Exception ex) {
/* 391 */       ex.printStackTrace();
/*     */     }
/* 393 */     return null;
/*     */   }
/*     */ 
/*     */   public boolean getAutoCommit() throws SQLException {
/* 397 */     return this.con.getAutoCommit();
/*     */   }
/*     */ 
/*     */   public String getCatalog() throws SQLException {
/* 401 */     return this.con.getCatalog();
/*     */   }
/*     */ 
/*     */   public int getHoldability() {
/*     */     try {
/* 406 */       return this.con.getHoldability();
/*     */     } catch (Exception ex) {
/* 408 */       ex.printStackTrace();
/*     */     }
/* 410 */     return 0;
/*     */   }
/*     */ 
/*     */   public DatabaseMetaData getMetaData() throws SQLException {
/* 414 */     return this.con.getMetaData();
/*     */   }
/*     */ 
/*     */   public int getTransactionIsolation() throws SQLException {
/* 418 */     return this.con.getTransactionIsolation();
/*     */   }
/*     */ 
/*     */   public Map getTypeMap() throws SQLException {
/* 422 */     return this.con.getTypeMap();
/*     */   }
/*     */ 
/*     */   public SQLWarning getWarnings() throws SQLException {
/* 426 */     return this.con.getWarnings();
/*     */   }
/*     */ 
/*     */   public boolean isClosed() throws SQLException {
/* 430 */     if (this.bNotInUse) {
/* 431 */       return true;
/*     */     }
/* 433 */     return this.con.isClosed();
/*     */   }
/*     */ 
/*     */   public boolean isReadOnly() throws SQLException
/*     */   {
/* 438 */     return this.con.isReadOnly();
/*     */   }
/*     */ 
/*     */   public String nativeSQL(String sql) throws SQLException {
/* 442 */     return this.con.nativeSQL(sql);
/*     */   }
/*     */ 
/*     */   public CallableStatement prepareCall(String sql) throws SQLException {
/* 446 */     return this.con.prepareCall(sql);
/*     */   }
/*     */ 
/*     */   public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
/* 450 */     return this.con.prepareCall(sql, resultSetType, resultSetConcurrency);
/*     */   }
/*     */ 
/*     */   public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
/*     */   {
/*     */     try {
/* 456 */       return this.con.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
/*     */     } catch (Exception ex) {
/* 458 */       ex.printStackTrace();
/*     */     }
/* 460 */     return null;
/*     */   }
/*     */ 
/*     */   public PreparedStatement prepareStatement(String sql) throws SQLException {
/* 464 */     return this.con.prepareStatement(sql);
/*     */   }
/*     */ 
/*     */   public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) {
/*     */     try {
/* 469 */       return this.con.prepareStatement(sql, autoGeneratedKeys);
/*     */     } catch (Exception ex) {
/* 471 */       ex.printStackTrace();
/*     */     }
/* 473 */     return null;
/*     */   }
/*     */ 
/*     */   public PreparedStatement prepareStatement(String sql, int[] columnIndexes) {
/*     */     try {
/* 478 */       return this.con.prepareStatement(sql, columnIndexes);
/*     */     } catch (Exception ex) {
/* 480 */       ex.printStackTrace();
/*     */     }
/* 482 */     return null;
/*     */   }
/*     */ 
/*     */   public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException
/*     */   {
/* 487 */     return this.con.prepareStatement(sql, resultSetType, resultSetConcurrency);
/*     */   }
/*     */ 
/*     */   public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
/*     */   {
/*     */     try {
/* 493 */       return this.con.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
/*     */     } catch (Exception ex) {
/* 495 */       ex.printStackTrace();
/*     */     }
/* 497 */     return null;
/*     */   }
/*     */ 
/*     */   public PreparedStatement prepareStatement(String sql, String[] columnNames) {
/*     */     try {
/* 502 */       return this.con.prepareStatement(sql, columnNames);
/*     */     } catch (Exception ex) {
/* 504 */       ex.printStackTrace();
/*     */     }
/* 506 */     return null;
/*     */   }
/*     */ 
/*     */   public void releaseSavepoint(Savepoint savepoint) {
/*     */     try {
/* 511 */       this.con.releaseSavepoint(savepoint);
/*     */     } catch (Exception ex) {
/* 513 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void rollback() throws SQLException
/*     */   {
/* 519 */     this.con.rollback();
/*     */   }
/*     */ 
/*     */   public void rollback(Savepoint savepoint) {
/*     */     try {
/* 524 */       this.con.rollback(savepoint);
/*     */     } catch (Exception ex) {
/* 526 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setAutoCommit(boolean autoCommit) throws SQLException
/*     */   {
/* 532 */     if (this.con.getAutoCommit())
/* 533 */       this.con.setAutoCommit(autoCommit);
/*     */   }
/*     */ 
/*     */   public void setCatalog(String catalog) throws SQLException
/*     */   {
/* 538 */     this.con.setCatalog(catalog);
/*     */   }
/*     */ 
/*     */   public void setHoldability(int holdability) {
/*     */     try {
/* 543 */       this.con.setHoldability(holdability);
/*     */     } catch (Exception ex) {
/* 545 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setReadOnly(boolean readOnly) throws SQLException
/*     */   {
/* 551 */     this.con.setReadOnly(readOnly);
/*     */   }
/*     */ 
/*     */   public Savepoint setSavepoint() {
/*     */     try {
/* 556 */       return this.con.setSavepoint();
/*     */     } catch (Exception ex) {
/* 558 */       ex.printStackTrace();
/*     */     }
/* 560 */     return null;
/*     */   }
/*     */ 
/*     */   public Savepoint setSavepoint(String name) {
/*     */     try {
/* 565 */       return this.con.setSavepoint(name);
/*     */     } catch (Exception ex) {
/* 567 */       ex.printStackTrace();
/*     */     }
/* 569 */     return null;
/*     */   }
/*     */ 
/*     */   public void setTransactionIsolation(int level) throws SQLException {
/* 573 */     this.con.setTransactionIsolation(level);
/*     */   }
/*     */ 
/*     */   public void setTypeMap(Map map) throws SQLException
/*     */   {
/* 578 */     this.con.setTypeMap(map);
/*     */   }
/*     */ 
/*     */   protected void dumpConnInfo(OutputStream os) throws Exception
/*     */   {
/* 583 */     if (!isClosed())
/* 584 */       os.write(this.m_buf.toString().getBytes());
/*     */   }
/*     */ 
/*     */   protected void setLastestAccess()
/*     */   {
/* 589 */     this.m_lastestAccess = new Date();
/*     */   }
/*     */ 
/*     */   protected Date getLastestAccess() {
/* 593 */     return this.m_lastestAccess;
/*     */   }
/*     */ 
/*     */   protected void innerClose() {
/* 597 */     System.out.println("DBConn.innerClose");
/* 598 */     if (isInUse()) {
/* 599 */       return;
/*     */     }
/*     */ 
/* 602 */     this.m_lastestAccess = null;
/*     */     try
/*     */     {
/* 605 */       this.con.rollback();
/* 606 */       this.con.close();
/*     */     } catch (Exception ex) {
/* 608 */       ex.printStackTrace();
/* 609 */       this.con = null;
/*     */     }
/*     */   }
/*     */ 
/*     */   public Array createArrayOf(String arg0, Object[] arg1) throws SQLException
/*     */   {
/* 615 */     return null;
/*     */   }
/*     */ 
/*     */   public Blob createBlob() throws SQLException
/*     */   {
/* 620 */     return null;
/*     */   }
/*     */ 
/*     */   public Clob createClob() throws SQLException
/*     */   {
/* 625 */     return null;
/*     */   }
/*     */ 
/*     */   public Struct createStruct(String arg0, Object[] arg1) throws SQLException
/*     */   {
/* 630 */     return null;
/*     */   }
/*     */ 
/*     */   public Properties getClientInfo() throws SQLException
/*     */   {
/* 635 */     return null;
/*     */   }
/*     */ 
/*     */   public String getClientInfo(String arg0) throws SQLException
/*     */   {
/* 640 */     return null;
/*     */   }
/*     */ 
/*     */   public boolean isValid(int arg0) throws SQLException
/*     */   {
/* 645 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean isWrapperFor(Class<?> arg0) throws SQLException
/*     */   {
/* 650 */     return false;
/*     */   }
/*     */ 
/*     */   public <T> T unwrap(Class<T> arg0) throws SQLException
/*     */   {
/* 655 */     return null;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.DBConn
 * JD-Core Version:    0.6.0
 */