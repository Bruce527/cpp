/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ public class ECJdbcUrl
/*     */ {
/*     */   private String DBType;
/*     */   private String IP;
/*     */   private String Port;
/*     */   private String DBName;
/*     */   private String ServerName;
/*     */   private String UserName;
/*     */   private String PassWord;
/*     */ 
/*     */   public ECJdbcUrl()
/*     */   {
/*  54 */     this.DBType = "ORACLE";
/*  55 */     this.IP = "192.168.71.46";
/*  56 */     this.Port = "1521";
/*  57 */     this.DBName = "hasl";
/*  58 */     this.UserName = "oes";
/*  59 */     this.PassWord = "oes";
/*     */   }
/*     */ 
/*     */   public String getDBType()
/*     */   {
/*  67 */     return this.DBType;
/*     */   }
/*     */ 
/*     */   public String getIP()
/*     */   {
/*  72 */     return this.IP;
/*     */   }
/*     */ 
/*     */   public String getPort()
/*     */   {
/*  77 */     return this.Port;
/*     */   }
/*     */ 
/*     */   public String getDBName()
/*     */   {
/*  82 */     return this.DBName;
/*     */   }
/*     */ 
/*     */   public String getServerName()
/*     */   {
/*  87 */     return this.ServerName;
/*     */   }
/*     */ 
/*     */   public String getUserName()
/*     */   {
/*  92 */     return this.UserName;
/*     */   }
/*     */ 
/*     */   public String getPassWord()
/*     */   {
/*  97 */     return this.PassWord;
/*     */   }
/*     */ 
/*     */   public void setDBType(String aDBType)
/*     */   {
/* 102 */     this.DBType = aDBType;
/*     */   }
/*     */ 
/*     */   public void setIP(String aIP)
/*     */   {
/* 107 */     this.IP = aIP;
/*     */   }
/*     */ 
/*     */   public void setPort(String aPort)
/*     */   {
/* 112 */     this.Port = aPort;
/*     */   }
/*     */ 
/*     */   public void setDBName(String aDBName)
/*     */   {
/* 117 */     this.DBName = aDBName;
/*     */   }
/*     */ 
/*     */   public void setServerName(String aServerName)
/*     */   {
/* 122 */     this.ServerName = aServerName;
/*     */   }
/*     */ 
/*     */   public void setUser(String aUserName)
/*     */   {
/* 127 */     this.UserName = aUserName;
/*     */   }
/*     */ 
/*     */   public void setPassWord(String aPassWord)
/*     */   {
/* 132 */     this.PassWord = aPassWord;
/*     */   }
/*     */ 
/*     */   public String getJdbcUrl()
/*     */   {
/* 140 */     StringBuffer sUrl = new StringBuffer(256);
/*     */ 
/* 142 */     if (this.DBType.trim().toUpperCase().equals("ORACLE"))
/*     */     {
/* 147 */       sUrl.append("jdbc:oracle:thin:@");
/* 148 */       sUrl.append(this.IP);
/* 149 */       sUrl.append(":");
/* 150 */       sUrl.append(this.Port);
/* 151 */       sUrl.append(":");
/* 152 */       sUrl.append(this.DBName);
/*     */     }
/*     */ 
/* 155 */     if (this.DBType.trim().toUpperCase().equals("INFORMIX"))
/*     */     {
/* 163 */       sUrl.append("jdbc:informix-sqli://");
/* 164 */       sUrl.append(this.IP);
/* 165 */       sUrl.append(":");
/* 166 */       sUrl.append(this.Port);
/* 167 */       sUrl.append(this.DBName);
/* 168 */       sUrl.append(":");
/* 169 */       sUrl.append("informixserver=");
/* 170 */       sUrl.append(this.ServerName);
/* 171 */       sUrl.append(";");
/* 172 */       sUrl.append("user=");
/* 173 */       sUrl.append(this.UserName);
/* 174 */       sUrl.append(";");
/* 175 */       sUrl.append("password=");
/* 176 */       sUrl.append(this.PassWord);
/* 177 */       sUrl.append(";");
/*     */     }
/*     */ 
/* 180 */     if (this.DBType.trim().toUpperCase().equals("SQLSERVER"))
/*     */     {
/* 184 */       sUrl.append("jdbc:inetdae:");
/* 185 */       sUrl.append(this.IP);
/* 186 */       sUrl.append(":");
/* 187 */       sUrl.append(this.Port);
/* 188 */       sUrl.append("?sql7=true&database=");
/* 189 */       sUrl.append(this.DBName);
/* 190 */       sUrl.append("&charset=gbk");
/*     */     }
/*     */ 
/* 193 */     if (this.DBType.trim().toUpperCase().equals("WEBLOGICPOOL"))
/*     */     {
/* 196 */       sUrl.append("jdbc:weblogic:pool:");
/* 197 */       sUrl.append(this.DBName);
/*     */     }
/*     */ 
/* 200 */     if (this.DBType.trim().toUpperCase().equals("DB2"))
/*     */     {
/* 205 */       sUrl.append("jdbc:db2://");
/* 206 */       sUrl.append(this.IP);
/* 207 */       sUrl.append(":");
/* 208 */       sUrl.append(this.Port);
/* 209 */       sUrl.append("/");
/* 210 */       sUrl.append(this.DBName);
/*     */     }
/* 212 */     return sUrl.toString();
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.ECJdbcUrl
 * JD-Core Version:    0.6.0
 */