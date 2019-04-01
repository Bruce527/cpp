/*     */ package com.sinosoft.map.utility;
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
/*  26 */     Map dbinfo = WebApplication.getInstance().get_jdbcurl();
/*     */ 
/*  29 */     this.DBType = ((String)dbinfo.get("dbType"));
/*  30 */     this.DBName = ((String)dbinfo.get("dbName"));
/*  31 */     this.IP = ((String)dbinfo.get("dbIP"));
/*  32 */     this.Port = ((String)dbinfo.get("dbPort"));
/*  33 */     this.UserName = ((String)dbinfo.get("dbUserName"));
/*  34 */     this.PassWord = ((String)dbinfo.get("dbPassword"));
/*     */   }
/*     */ 
/*     */   public String getDBType()
/*     */   {
/*  56 */     return this.DBType;
/*     */   }
/*     */ 
/*     */   public String getIP()
/*     */   {
/*  61 */     return this.IP;
/*     */   }
/*     */ 
/*     */   public String getPort()
/*     */   {
/*  66 */     return this.Port;
/*     */   }
/*     */ 
/*     */   public String getDBName()
/*     */   {
/*  71 */     return this.DBName;
/*     */   }
/*     */ 
/*     */   public String getServerName()
/*     */   {
/*  76 */     return this.ServerName;
/*     */   }
/*     */ 
/*     */   public String getUserName()
/*     */   {
/*  81 */     return this.UserName;
/*     */   }
/*     */ 
/*     */   public String getPassWord()
/*     */   {
/*  86 */     return this.PassWord;
/*     */   }
/*     */ 
/*     */   public void setDBType(String aDBType)
/*     */   {
/*  91 */     this.DBType = aDBType;
/*     */   }
/*     */ 
/*     */   public void setIP(String aIP)
/*     */   {
/*  96 */     this.IP = aIP;
/*     */   }
/*     */ 
/*     */   public void setPort(String aPort)
/*     */   {
/* 101 */     this.Port = aPort;
/*     */   }
/*     */ 
/*     */   public void setDBName(String aDBName)
/*     */   {
/* 106 */     this.DBName = aDBName;
/*     */   }
/*     */ 
/*     */   public void setServerName(String aServerName)
/*     */   {
/* 111 */     this.ServerName = aServerName;
/*     */   }
/*     */ 
/*     */   public void setUser(String aUserName)
/*     */   {
/* 116 */     this.UserName = aUserName;
/*     */   }
/*     */ 
/*     */   public void setPassWord(String aPassWord)
/*     */   {
/* 121 */     this.PassWord = aPassWord;
/*     */   }
/*     */ 
/*     */   public String getJdbcUrl()
/*     */   {
/* 129 */     StringBuffer sUrl = new StringBuffer(256);
/*     */ 
/* 131 */     if (this.DBType.trim().toUpperCase().equals("ORACLE"))
/*     */     {
/* 136 */       sUrl.append("jdbc:oracle:thin:@");
/* 137 */       sUrl.append(this.IP);
/* 138 */       sUrl.append(":");
/* 139 */       sUrl.append(this.Port);
/* 140 */       sUrl.append(":");
/* 141 */       sUrl.append(this.DBName);
/*     */     }
/*     */ 
/* 144 */     if (this.DBType.trim().toUpperCase().equals("INFORMIX"))
/*     */     {
/* 152 */       sUrl.append("jdbc:informix-sqli://");
/* 153 */       sUrl.append(this.IP);
/* 154 */       sUrl.append(":");
/* 155 */       sUrl.append(this.Port);
/* 156 */       sUrl.append(this.DBName);
/* 157 */       sUrl.append(":");
/* 158 */       sUrl.append("informixserver=");
/* 159 */       sUrl.append(this.ServerName);
/* 160 */       sUrl.append(";");
/* 161 */       sUrl.append("user=");
/* 162 */       sUrl.append(this.UserName);
/* 163 */       sUrl.append(";");
/* 164 */       sUrl.append("password=");
/* 165 */       sUrl.append(this.PassWord);
/* 166 */       sUrl.append(";");
/*     */     }
/*     */ 
/* 169 */     if (this.DBType.trim().toUpperCase().equals("SQLSERVER"))
/*     */     {
/* 173 */       sUrl.append("jdbc:inetdae:");
/* 174 */       sUrl.append(this.IP);
/* 175 */       sUrl.append(":");
/* 176 */       sUrl.append(this.Port);
/* 177 */       sUrl.append("?sql7=true&database=");
/* 178 */       sUrl.append(this.DBName);
/* 179 */       sUrl.append("&charset=gbk");
/*     */     }
/* 181 */     if (this.DBType.trim().toUpperCase().equals("SQLSERVER2012"))
/*     */     {
/* 183 */       sUrl = sUrl.append("jdbc:sqlserver://")
/* 184 */         .append(this.IP)
/* 185 */         .append("\\SQLEXPRESS")
/* 186 */         .append(":")
/* 187 */         .append(this.Port)
/* 188 */         .append(";databasename=")
/* 189 */         .append(this.DBName);
/*     */     }
/*     */ 
/* 192 */     if (this.DBType.trim().toUpperCase().equals("WEBLOGICPOOL"))
/*     */     {
/* 195 */       sUrl.append("jdbc:weblogic:pool:");
/* 196 */       sUrl.append(this.DBName);
/*     */     }
/*     */ 
/* 199 */     if (this.DBType.trim().toUpperCase().equals("DB2"))
/*     */     {
/* 204 */       sUrl.append("jdbc:db2://");
/* 205 */       sUrl.append(this.IP);
/* 206 */       sUrl.append(":");
/* 207 */       sUrl.append(this.Port);
/* 208 */       sUrl.append("/");
/* 209 */       sUrl.append(this.DBName);
/*     */     }
/* 211 */     System.out.println("\u6570\u636E\u5E93url:" + sUrl.toString());
/* 212 */     return sUrl.toString();
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.JdbcUrl
 * JD-Core Version:    0.6.0
 */