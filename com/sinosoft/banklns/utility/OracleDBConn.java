/*     */ package com.sinosoft.banklns.utility;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Array;
/*     */ import java.sql.Blob;
/*     */ import java.sql.CallableStatement;
/*     */ import java.sql.Clob;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DatabaseMetaData;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.SQLWarning;
/*     */ import java.sql.Savepoint;
/*     */ import java.sql.Statement;
/*     */ import java.sql.Struct;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ 
/*     */ public class OracleDBConn
/*     */   implements Connection
/*     */ {
/*     */   private JdbcUrl JUrl;
/*  34 */   private Connection con = null;
/*     */   private boolean bNotInUse;
/*  36 */   private ByteArrayOutputStream bos = new ByteArrayOutputStream();
/*     */ 
/*  38 */   public CErrors mErrors = new CErrors();
/*     */ 
/*     */   public boolean createConnection()
/*     */   {
/*  48 */     int dbType = 0;
/*     */     try
/*     */     {
/*  51 */       if (this.con != null) {
/*  52 */         if (!this.con.isClosed()) {
/*     */           try {
/*  54 */             Statement stmt = this.con.createStatement();
/*  55 */             stmt.execute("SELECT * FROM DUAL");
/*  56 */             stmt.close();
/*     */ 
/*  58 */             return true;
/*     */           } catch (Exception e) {
/*  60 */             System.out.println("DBConn : recreate DBConn");
/*  61 */             this.con.close();
/*  62 */             this.con = null;
/*     */           }
/*     */         }
/*  65 */         this.con = null;
/*     */       }
/*     */ 
/*  68 */       if (this.JUrl.getDBType().toUpperCase().equals("ORACLE"))
/*  69 */         dbType = 1;
/*  70 */       if (this.JUrl.getDBType().toUpperCase().equals("INFORMIX"))
/*  71 */         dbType = 2;
/*  72 */       if (this.JUrl.getDBType().toUpperCase().equals("SQLSERVER"))
/*  73 */         dbType = 3;
/*  74 */       if (this.JUrl.getDBType().toUpperCase().equals("MYSQL"))
/*  75 */         dbType = 4;
/*  76 */       if (this.JUrl.getDBType().toUpperCase().equals("ACCESS")) {
/*  77 */         dbType = 5;
/*     */       }
/*  79 */       switch (dbType) {
/*     */       case 1:
/*  81 */         Class.forName("oracle.jdbc.driver.OracleDriver");
/*  82 */         break;
/*     */       case 2:
/*  84 */         Class.forName("com.informix.jdbc.IfxDriver");
/*  85 */         break;
/*     */       case 3:
/*  87 */         Class.forName("com.inet.tds.TdsDriver");
/*  88 */         break;
/*     */       case 4:
/*  90 */         Class.forName("org.gjt.mm.mysql.Driver");
/*  91 */         break;
/*     */       case 5:
/*  93 */         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
/*  94 */         break;
/*     */       default:
/*  97 */         CError tError = new CError();
/*  98 */         tError.moduleName = "DBConn";
/*  99 */         tError.functionName = "createConnection";
/* 100 */         tError.errorMessage = "\u9429\uE1BC\u58A0\u93C6\u5099\u7B09\u93C0\uE21B\u5BD4\u59DD\u3087\uE752\u7EEB\u8BF2\u7037\u9428\u52EC\u669F\u93B9\uE1BC\u7C31!";
/* 101 */         this.mErrors.addOneError(tError);
/*     */ 
/* 103 */         return false;
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 107 */       CError tError = new CError();
/* 108 */       tError.moduleName = "DBConn";
/* 109 */       tError.functionName = "createConnection";
/* 110 */       tError.errorMessage = e.toString();
/* 111 */       this.mErrors.addOneError(tError);
/* 112 */       return false;
/*     */     }
/*     */     try
/*     */     {
/* 116 */       switch (dbType) {
/*     */       case 1:
/* 118 */         this.con = DriverManager.getConnection(this.JUrl.getJdbcUrl(), this.JUrl.getUserName(), this.JUrl.getPassWord());
/* 119 */         Statement stmt = this.con.createStatement(1005, 1008);
/* 120 */         stmt.execute("alter session set nls_date_format = 'YYYY-MM-DD HH24:MI:SS'");
/* 121 */         stmt.close();
/* 122 */         break;
/*     */       case 2:
/* 124 */         this.con = DriverManager.getConnection(this.JUrl.getJdbcUrl());
/* 125 */         break;
/*     */       case 3:
/* 127 */         this.con = DriverManager.getConnection(this.JUrl.getJdbcUrl(), this.JUrl.getUserName(), this.JUrl.getPassWord());
/* 128 */         break;
/*     */       case 4:
/* 130 */         this.con = DriverManager.getConnection(this.JUrl.getJdbcUrl(), this.JUrl.getUserName(), this.JUrl.getPassWord());
/*     */       case 5:
/* 132 */         this.con = DriverManager.getConnection(this.JUrl.getJdbcUrl(), this.JUrl.getUserName(), this.JUrl.getPassWord());
/*     */       }
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 137 */       CError tError = new CError();
/* 138 */       tError.moduleName = "DBConn";
/* 139 */       tError.functionName = "createConnection";
/* 140 */       tError.errorMessage = ("Connect failed!  error code =" + e.getErrorCode());
/* 141 */       this.mErrors.addOneError(tError);
/*     */ 
/* 143 */       return false;
/*     */     }
/*     */ 
/* 146 */     return true;
/*     */   }
/*     */ 
/*     */   protected OracleDBConn() {
/* 150 */     this.JUrl = new JdbcUrl();
/*     */ 
/* 152 */     this.bNotInUse = true;
/*     */   }
/*     */ 
/*     */   protected boolean isInnerClose() {
/*     */     try {
/* 157 */       if (this.con == null) {
/* 158 */         return true;
/*     */       }
/* 160 */       return this.con.isClosed(); } catch (SQLException ex) {
/*     */     }
/* 162 */     return true;
/*     */   }
/*     */ 
/*     */   protected void setInUse()
/*     */   {
/* 168 */     PrintStream err = System.err;
/* 169 */     System.setErr(new FilterPrintStream());
/* 170 */     Thread.currentThread(); Thread.dumpStack();
/* 171 */     System.setErr(err);
/*     */ 
/* 173 */     this.bNotInUse = false;
/*     */   }
/*     */ 
/*     */   protected boolean isInUse() {
/* 177 */     return !this.bNotInUse;
/*     */   }
/*     */ 
/*     */   public void clearWarnings() throws SQLException {
/* 181 */     this.con.clearWarnings();
/*     */   }
/*     */ 
/*     */   public void close() throws SQLException {
/* 185 */     System.out.println("DBConn : user release connection!");
/* 186 */     this.bos.reset();
/* 187 */     this.bNotInUse = true;
/*     */   }
/*     */ 
/*     */   public void commit() throws SQLException {
/* 191 */     this.con.commit();
/*     */   }
/*     */ 
/*     */   public Statement createStatement() throws SQLException {
/* 195 */     return this.con.createStatement();
/*     */   }
/*     */ 
/*     */   public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException
/*     */   {
/* 200 */     return this.con.createStatement();
/*     */   }
/*     */ 
/*     */   public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException
/*     */   {
/* 205 */     return this.con.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
/*     */   }
/*     */ 
/*     */   public boolean getAutoCommit() throws SQLException {
/* 209 */     return this.con.getAutoCommit();
/*     */   }
/*     */ 
/*     */   public String getCatalog() throws SQLException {
/* 213 */     return this.con.getCatalog();
/*     */   }
/*     */ 
/*     */   public int getHoldability() throws SQLException {
/* 217 */     return this.con.getHoldability();
/*     */   }
/*     */ 
/*     */   public DatabaseMetaData getMetaData() throws SQLException {
/* 221 */     return this.con.getMetaData();
/*     */   }
/*     */ 
/*     */   public int getTransactionIsolation() throws SQLException {
/* 225 */     return this.con.getTransactionIsolation();
/*     */   }
/*     */ 
/*     */   public Map getTypeMap() throws SQLException {
/* 229 */     return this.con.getTypeMap();
/*     */   }
/*     */ 
/*     */   public SQLWarning getWarnings() throws SQLException {
/* 233 */     return this.con.getWarnings();
/*     */   }
/*     */ 
/*     */   public boolean isClosed() throws SQLException {
/* 237 */     if (this.bNotInUse) {
/* 238 */       return true;
/*     */     }
/* 240 */     return this.con.isClosed();
/*     */   }
/*     */ 
/*     */   public boolean isReadOnly() throws SQLException
/*     */   {
/* 245 */     return this.con.isReadOnly();
/*     */   }
/*     */ 
/*     */   public String nativeSQL(String sql) throws SQLException {
/* 249 */     return this.con.nativeSQL(sql);
/*     */   }
/*     */ 
/*     */   public CallableStatement prepareCall(String sql) throws SQLException {
/* 253 */     return this.con.prepareCall(sql);
/*     */   }
/*     */ 
/*     */   public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
/* 257 */     return this.con.prepareCall(sql, resultSetType, resultSetConcurrency);
/*     */   }
/*     */ 
/*     */   public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException
/*     */   {
/* 262 */     return this.con.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
/*     */   }
/*     */ 
/*     */   public PreparedStatement prepareStatement(String sql) throws SQLException {
/* 266 */     return this.con.prepareStatement(sql);
/*     */   }
/*     */ 
/*     */   public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
/* 270 */     return this.con.prepareStatement(sql, autoGeneratedKeys);
/*     */   }
/*     */ 
/*     */   public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
/* 274 */     return this.con.prepareStatement(sql, columnIndexes);
/*     */   }
/*     */ 
/*     */   public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException
/*     */   {
/* 279 */     return this.con.prepareStatement(sql, resultSetType, resultSetConcurrency);
/*     */   }
/*     */ 
/*     */   public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException
/*     */   {
/* 284 */     return this.con.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
/*     */   }
/*     */ 
/*     */   public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
/* 288 */     return this.con.prepareStatement(sql, columnNames);
/*     */   }
/*     */ 
/*     */   public void releaseSavepoint(Savepoint savepoint) throws SQLException {
/* 292 */     this.con.releaseSavepoint(savepoint);
/*     */   }
/*     */ 
/*     */   public void rollback() throws SQLException {
/* 296 */     this.con.rollback();
/*     */   }
/*     */ 
/*     */   public void rollback(Savepoint savepoint) throws SQLException {
/* 300 */     this.con.rollback(savepoint);
/*     */   }
/*     */ 
/*     */   public void setAutoCommit(boolean autoCommit) throws SQLException {
/* 304 */     this.con.setAutoCommit(autoCommit);
/*     */   }
/*     */ 
/*     */   public void setCatalog(String catalog) throws SQLException {
/* 308 */     this.con.setCatalog(catalog);
/*     */   }
/*     */ 
/*     */   public void setHoldability(int holdability) throws SQLException {
/* 312 */     this.con.setHoldability(holdability);
/*     */   }
/*     */ 
/*     */   public void setReadOnly(boolean readOnly) throws SQLException {
/* 316 */     this.con.setReadOnly(readOnly);
/*     */   }
/*     */ 
/*     */   public Savepoint setSavepoint() throws SQLException {
/* 320 */     return this.con.setSavepoint();
/*     */   }
/*     */ 
/*     */   public Savepoint setSavepoint(String name) throws SQLException {
/* 324 */     return this.con.setSavepoint(name);
/*     */   }
/*     */ 
/*     */   public void setTransactionIsolation(int level) throws SQLException {
/* 328 */     this.con.setTransactionIsolation(level);
/*     */   }
/*     */ 
/*     */   public void setTypeMap(Map map) throws SQLException {
/* 332 */     this.con.setTypeMap(map);
/*     */   }
/*     */ 
/*     */   protected void dumpConnInfo(OutputStream os) throws Exception
/*     */   {
/* 337 */     if (!isClosed())
/* 338 */       os.write(this.bos.toByteArray());
/*     */   }
/*     */ 
/*     */   public Array createArrayOf(String arg0, Object[] arg1)
/*     */     throws SQLException
/*     */   {
/* 344 */     return null;
/*     */   }
/*     */ 
/*     */   public Blob createBlob() throws SQLException
/*     */   {
/* 349 */     return null;
/*     */   }
/*     */ 
/*     */   public Clob createClob() throws SQLException
/*     */   {
/* 354 */     return null;
/*     */   }
/*     */ 
/*     */   public Struct createStruct(String arg0, Object[] arg1)
/*     */     throws SQLException
/*     */   {
/* 360 */     return null;
/*     */   }
/*     */ 
/*     */   public Properties getClientInfo() throws SQLException
/*     */   {
/* 365 */     return null;
/*     */   }
/*     */ 
/*     */   public String getClientInfo(String arg0) throws SQLException
/*     */   {
/* 370 */     return null;
/*     */   }
/*     */ 
/*     */   public boolean isValid(int arg0) throws SQLException
/*     */   {
/* 375 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean isWrapperFor(Class<?> arg0)
/*     */     throws SQLException
/*     */   {
/* 381 */     return false;
/*     */   }
/*     */ 
/*     */   public <T> T unwrap(Class<T> arg0) throws SQLException
/*     */   {
/* 386 */     return null;
/*     */   }
/*     */ 
/*     */   class FilterPrintStream extends PrintStream
/*     */   {
/*     */     public FilterPrintStream()
/*     */     {
/*  43 */       super();
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.OracleDBConn
 * JD-Core Version:    0.6.0
 */