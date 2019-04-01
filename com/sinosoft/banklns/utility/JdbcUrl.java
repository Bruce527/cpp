/*     */ package com.sinosoft.banklns.utility;
/*     */ 
/*     */ import com.sinosoft.map.common.WebApplication;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class JdbcUrl
/*     */ {
/*     */   private String DBType;
/*     */   private String IP;
/*     */   private String Port;
/*     */   private String DBName;
/*     */   private String ServerName;
/*     */   private String UserName;
/*     */   private String PassWord;
/*     */ 
/*     */   public JdbcUrl()
/*     */   {
/*  27 */     WebApplication.getInstance().initConnection();
/*  28 */     Map dbinfo = WebApplication.getInstance().get_jdbcurl();
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
/*  54 */     return this.DBType;
/*     */   }
/*     */ 
/*     */   public String getIP()
/*     */   {
/*  59 */     return this.IP;
/*     */   }
/*     */ 
/*     */   public String getPort()
/*     */   {
/*  64 */     return this.Port;
/*     */   }
/*     */ 
/*     */   public String getDBName()
/*     */   {
/*  69 */     return this.DBName;
/*     */   }
/*     */ 
/*     */   public String getServerName()
/*     */   {
/*  74 */     return this.ServerName;
/*     */   }
/*     */ 
/*     */   public String getUserName()
/*     */   {
/*  79 */     return this.UserName;
/*     */   }
/*     */ 
/*     */   public String getPassWord()
/*     */   {
/*  84 */     return this.PassWord;
/*     */   }
/*     */ 
/*     */   public void setDBType(String aDBType)
/*     */   {
/*  89 */     this.DBType = aDBType;
/*     */   }
/*     */ 
/*     */   public void setIP(String aIP)
/*     */   {
/*  94 */     this.IP = aIP;
/*     */   }
/*     */ 
/*     */   public void setPort(String aPort)
/*     */   {
/*  99 */     this.Port = aPort;
/*     */   }
/*     */ 
/*     */   public void setDBName(String aDBName)
/*     */   {
/* 104 */     this.DBName = aDBName;
/*     */   }
/*     */ 
/*     */   public void setServerName(String aServerName)
/*     */   {
/* 109 */     this.ServerName = aServerName;
/*     */   }
/*     */ 
/*     */   public void setUser(String aUserName)
/*     */   {
/* 114 */     this.UserName = aUserName;
/*     */   }
/*     */ 
/*     */   public void setPassWord(String aPassWord)
/*     */   {
/* 119 */     this.PassWord = aPassWord;
/*     */   }
/*     */ 
/*     */   public String getJdbcUrl()
/*     */   {
/* 127 */     StringBuffer sUrl = new StringBuffer(256);
/*     */ 
/* 129 */     if (this.DBType.trim().toUpperCase().equals("ORACLE"))
/*     */     {
/* 134 */       sUrl.append("jdbc:oracle:thin:@");
/* 135 */       sUrl.append(this.IP);
/* 136 */       sUrl.append(":");
/* 137 */       sUrl.append(this.Port);
/* 138 */       sUrl.append(":");
/* 139 */       sUrl.append(this.DBName);
/*     */     }
/*     */ 
/* 142 */     if (this.DBType.trim().toUpperCase().equals("INFORMIX"))
/*     */     {
/* 150 */       sUrl.append("jdbc:informix-sqli://");
/* 151 */       sUrl.append(this.IP);
/* 152 */       sUrl.append(":");
/* 153 */       sUrl.append(this.Port);
/* 154 */       sUrl.append(this.DBName);
/* 155 */       sUrl.append(":");
/* 156 */       sUrl.append("informixserver=");
/* 157 */       sUrl.append(this.ServerName);
/* 158 */       sUrl.append(";");
/* 159 */       sUrl.append("user=");
/* 160 */       sUrl.append(this.UserName);
/* 161 */       sUrl.append(";");
/* 162 */       sUrl.append("password=");
/* 163 */       sUrl.append(this.PassWord);
/* 164 */       sUrl.append(";");
/*     */     }
/*     */ 
/* 167 */     if (this.DBType.trim().toUpperCase().equals("SQLSERVER"))
/*     */     {
/* 171 */       sUrl.append("jdbc:inetdae:");
/* 172 */       sUrl.append(this.IP);
/* 173 */       sUrl.append(":");
/* 174 */       sUrl.append(this.Port);
/* 175 */       sUrl.append("?sql7=true&database=");
/* 176 */       sUrl.append(this.DBName);
/* 177 */       sUrl.append("&charset=gbk");
/*     */     }
/* 179 */     if (this.DBType.trim().toUpperCase().equals("SQLSERVER2012"))
/*     */     {
/* 181 */       sUrl = sUrl.append("jdbc:sqlserver://")
/* 182 */         .append(this.IP)
/* 183 */         .append("\\SQLEXPRESS")
/* 184 */         .append(":")
/* 185 */         .append(this.Port)
/* 186 */         .append(";databasename=")
/* 187 */         .append(this.DBName);
/*     */     }
/*     */ 
/* 190 */     if (this.DBType.trim().toUpperCase().equals("WEBLOGICPOOL"))
/*     */     {
/* 193 */       sUrl.append("jdbc:weblogic:pool:");
/* 194 */       sUrl.append(this.DBName);
/*     */     }
/*     */ 
/* 197 */     if (this.DBType.trim().toUpperCase().equals("DB2"))
/*     */     {
/* 202 */       sUrl.append("jdbc:db2://");
/* 203 */       sUrl.append(this.IP);
/* 204 */       sUrl.append(":");
/* 205 */       sUrl.append(this.Port);
/* 206 */       sUrl.append("/");
/* 207 */       sUrl.append(this.DBName);
/*     */     }
/* 209 */     System.out.println("\u6570\u636E\u5E93url:" + sUrl.toString());
/* 210 */     return sUrl.toString();
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.JdbcUrl
 * JD-Core Version:    0.6.0
 */