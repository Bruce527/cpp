/*     */ package com.sinosoft.banklns.utility;
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
/* 118 */     if (this.DBType.trim().toUpperCase().equals("ORACLE"))
/*     */     {
/* 123 */       sUrl.append("jdbc:oracle:thin:@");
/* 124 */       sUrl.append(this.IP);
/* 125 */       sUrl.append(":");
/* 126 */       sUrl.append(this.Port);
/* 127 */       sUrl.append(":");
/* 128 */       sUrl.append(this.DBName);
/*     */     }
/*     */ 
/* 132 */     if (this.DBType.trim().toUpperCase().equals("INFORMIX"))
/*     */     {
/* 140 */       sUrl.append("jdbc:informix-sqli://");
/* 141 */       sUrl.append(this.IP);
/* 142 */       sUrl.append(":");
/* 143 */       sUrl.append(this.Port);
/* 144 */       sUrl.append(this.DBName);
/* 145 */       sUrl.append(":");
/* 146 */       sUrl.append("informixserver=");
/* 147 */       sUrl.append(this.ServerName);
/* 148 */       sUrl.append(";");
/* 149 */       sUrl.append("user=");
/* 150 */       sUrl.append(this.UserName);
/* 151 */       sUrl.append(";");
/* 152 */       sUrl.append("password=");
/* 153 */       sUrl.append(this.PassWord);
/* 154 */       sUrl.append(";");
/*     */     }
/*     */ 
/* 158 */     if (this.DBType.trim().toUpperCase().equals("SQLSERVER"))
/*     */     {
/* 162 */       sUrl.append("jdbc:inetdae:");
/* 163 */       sUrl.append(this.IP);
/* 164 */       sUrl.append(":");
/* 165 */       sUrl.append(this.Port);
/* 166 */       sUrl.append("?sql7=true&database=");
/* 167 */       sUrl.append(this.DBName);
/* 168 */       sUrl.append("&charset=gbk");
/*     */     }
/*     */ 
/* 172 */     if (this.DBType.trim().toUpperCase().equals("WEBLOGICPOOL"))
/*     */     {
/* 175 */       sUrl.append("jdbc:weblogic:pool:");
/* 176 */       sUrl.append(this.DBName);
/*     */     }
/*     */ 
/* 180 */     if (this.DBType.trim().toUpperCase().equals("DB2"))
/*     */     {
/* 185 */       sUrl.append("jdbc:db2://");
/* 186 */       sUrl.append(this.IP);
/* 187 */       sUrl.append(":");
/* 188 */       sUrl.append(this.Port);
/* 189 */       sUrl.append("/");
/* 190 */       sUrl.append(this.DBName);
/*     */     }
/* 192 */     return sUrl.toString();
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.JdbcUrlBackUp
 * JD-Core Version:    0.6.0
 */