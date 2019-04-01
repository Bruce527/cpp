/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ import com.sinosoft.map.common.WebApplication;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class JdbcUrlBackUp
/*     */ {
/*     */   private String DBType;
/*     */   private String IP;
/*     */   private String Port;
/*     */   private String DBName;
/*     */   private String ServerName;
/*     */   private String UserName;
/*     */   private String PassWord;
/*     */ 
/*     */   public JdbcUrlBackUp()
/*     */   {
/*  28 */     Map dbinfo = WebApplication.getInstance().get_jdbcurlbackup();
/*     */ 
/*  30 */     this.DBType = ((String)dbinfo.get("dbType"));
/*  31 */     this.DBName = ((String)dbinfo.get("dbName"));
/*  32 */     this.IP = ((String)dbinfo.get("dbIP"));
/*  33 */     this.Port = ((String)dbinfo.get("dbPort"));
/*  34 */     this.UserName = ((String)dbinfo.get("dbUserName"));
/*  35 */     this.PassWord = ((String)dbinfo.get("dbPassword"));
/*     */   }
/*     */ 
/*     */   public String getDBType()
/*     */   {
/*  42 */     return this.DBType;
/*     */   }
/*     */ 
/*     */   public String getIP()
/*     */   {
/*  47 */     return this.IP;
/*     */   }
/*     */ 
/*     */   public String getPort()
/*     */   {
/*  52 */     return this.Port;
/*     */   }
/*     */ 
/*     */   public String getDBName()
/*     */   {
/*  57 */     return this.DBName;
/*     */   }
/*     */ 
/*     */   public String getServerName()
/*     */   {
/*  62 */     return this.ServerName;
/*     */   }
/*     */ 
/*     */   public String getUserName()
/*     */   {
/*  67 */     return this.UserName;
/*     */   }
/*     */ 
/*     */   public String getPassWord()
/*     */   {
/*  72 */     return this.PassWord;
/*     */   }
/*     */ 
/*     */   public void setDBType(String aDBType)
/*     */   {
/*  77 */     this.DBType = aDBType;
/*     */   }
/*     */ 
/*     */   public void setIP(String aIP)
/*     */   {
/*  82 */     this.IP = aIP;
/*     */   }
/*     */ 
/*     */   public void setPort(String aPort)
/*     */   {
/*  87 */     this.Port = aPort;
/*     */   }
/*     */ 
/*     */   public void setDBName(String aDBName)
/*     */   {
/*  92 */     this.DBName = aDBName;
/*     */   }
/*     */ 
/*     */   public void setServerName(String aServerName)
/*     */   {
/*  97 */     this.ServerName = aServerName;
/*     */   }
/*     */ 
/*     */   public void setUser(String aUserName)
/*     */   {
/* 102 */     this.UserName = aUserName;
/*     */   }
/*     */ 
/*     */   public void setPassWord(String aPassWord)
/*     */   {
/* 107 */     this.PassWord = aPassWord;
/*     */   }
/*     */ 
/*     */   public String getJdbcUrl()
/*     */   {
/* 115 */     StringBuffer sUrl = new StringBuffer(256);
/*     */ 
/* 117 */     if (this.DBType.trim().toUpperCase().equals("ORACLE"))
/*     */     {
/* 122 */       sUrl.append("jdbc:oracle:thin:@");
/* 123 */       sUrl.append(this.IP);
/* 124 */       sUrl.append(":");
/* 125 */       sUrl.append(this.Port);
/* 126 */       sUrl.append(":");
/* 127 */       sUrl.append(this.DBName);
/*     */     }
/*     */ 
/* 130 */     if (this.DBType.trim().toUpperCase().equals("INFORMIX"))
/*     */     {
/* 138 */       sUrl.append("jdbc:informix-sqli://");
/* 139 */       sUrl.append(this.IP);
/* 140 */       sUrl.append(":");
/* 141 */       sUrl.append(this.Port);
/* 142 */       sUrl.append(this.DBName);
/* 143 */       sUrl.append(":");
/* 144 */       sUrl.append("informixserver=");
/* 145 */       sUrl.append(this.ServerName);
/* 146 */       sUrl.append(";");
/* 147 */       sUrl.append("user=");
/* 148 */       sUrl.append(this.UserName);
/* 149 */       sUrl.append(";");
/* 150 */       sUrl.append("password=");
/* 151 */       sUrl.append(this.PassWord);
/* 152 */       sUrl.append(";");
/*     */     }
/*     */ 
/* 155 */     if (this.DBType.trim().toUpperCase().equals("SQLSERVER"))
/*     */     {
/* 159 */       sUrl.append("jdbc:inetdae:");
/* 160 */       sUrl.append(this.IP);
/* 161 */       sUrl.append(":");
/* 162 */       sUrl.append(this.Port);
/* 163 */       sUrl.append("?sql7=true&database=");
/* 164 */       sUrl.append(this.DBName);
/* 165 */       sUrl.append("&charset=gbk");
/*     */     }
/*     */ 
/* 168 */     if (this.DBType.trim().toUpperCase().equals("WEBLOGICPOOL"))
/*     */     {
/* 171 */       sUrl.append("jdbc:weblogic:pool:");
/* 172 */       sUrl.append(this.DBName);
/*     */     }
/*     */ 
/* 175 */     if (this.DBType.trim().toUpperCase().equals("DB2"))
/*     */     {
/* 180 */       sUrl.append("jdbc:db2://");
/* 181 */       sUrl.append(this.IP);
/* 182 */       sUrl.append(":");
/* 183 */       sUrl.append(this.Port);
/* 184 */       sUrl.append("/");
/* 185 */       sUrl.append(this.DBName);
/*     */     }
/* 187 */     return sUrl.toString();
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.JdbcUrlBackUp
 * JD-Core Version:    0.6.0
 */