/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ public class ECJdbcUrlBackUp
/*     */ {
/*     */   private String DBType;
/*     */   private String IP;
/*     */   private String Port;
/*     */   private String DBName;
/*     */   private String ServerName;
/*     */   private String UserName;
/*     */   private String PassWord;
/*     */ 
/*     */   public ECJdbcUrlBackUp()
/*     */   {
/*  44 */     this.DBType = "ORACLE";
/*  45 */     this.IP = "172.19.1.43";
/*  46 */     this.Port = "1521";
/*  47 */     this.DBName = "DBtest01";
/*  48 */     this.UserName = "lishasl090701";
/*  49 */     this.PassWord = "lishasl090701";
/*     */   }
/*     */ 
/*     */   public String getDBType()
/*     */   {
/*  57 */     return this.DBType;
/*     */   }
/*     */ 
/*     */   public String getIP()
/*     */   {
/*  62 */     return this.IP;
/*     */   }
/*     */ 
/*     */   public String getPort()
/*     */   {
/*  67 */     return this.Port;
/*     */   }
/*     */ 
/*     */   public String getDBName()
/*     */   {
/*  72 */     return this.DBName;
/*     */   }
/*     */ 
/*     */   public String getServerName()
/*     */   {
/*  77 */     return this.ServerName;
/*     */   }
/*     */ 
/*     */   public String getUserName()
/*     */   {
/*  82 */     return this.UserName;
/*     */   }
/*     */ 
/*     */   public String getPassWord()
/*     */   {
/*  87 */     return this.PassWord;
/*     */   }
/*     */ 
/*     */   public void setDBType(String aDBType)
/*     */   {
/*  92 */     this.DBType = aDBType;
/*     */   }
/*     */ 
/*     */   public void setIP(String aIP)
/*     */   {
/*  97 */     this.IP = aIP;
/*     */   }
/*     */ 
/*     */   public void setPort(String aPort)
/*     */   {
/* 102 */     this.Port = aPort;
/*     */   }
/*     */ 
/*     */   public void setDBName(String aDBName)
/*     */   {
/* 107 */     this.DBName = aDBName;
/*     */   }
/*     */ 
/*     */   public void setServerName(String aServerName)
/*     */   {
/* 112 */     this.ServerName = aServerName;
/*     */   }
/*     */ 
/*     */   public void setUser(String aUserName)
/*     */   {
/* 117 */     this.UserName = aUserName;
/*     */   }
/*     */ 
/*     */   public void setPassWord(String aPassWord)
/*     */   {
/* 122 */     this.PassWord = aPassWord;
/*     */   }
/*     */ 
/*     */   public String getJdbcUrl()
/*     */   {
/* 130 */     StringBuffer sUrl = new StringBuffer(256);
/*     */ 
/* 132 */     if (this.DBType.trim().toUpperCase().equals("ORACLE"))
/*     */     {
/* 137 */       sUrl.append("jdbc:oracle:thin:@");
/* 138 */       sUrl.append(this.IP);
/* 139 */       sUrl.append(":");
/* 140 */       sUrl.append(this.Port);
/* 141 */       sUrl.append(":");
/* 142 */       sUrl.append(this.DBName);
/*     */     }
/*     */ 
/* 145 */     if (this.DBType.trim().toUpperCase().equals("INFORMIX"))
/*     */     {
/* 153 */       sUrl.append("jdbc:informix-sqli://");
/* 154 */       sUrl.append(this.IP);
/* 155 */       sUrl.append(":");
/* 156 */       sUrl.append(this.Port);
/* 157 */       sUrl.append(this.DBName);
/* 158 */       sUrl.append(":");
/* 159 */       sUrl.append("informixserver=");
/* 160 */       sUrl.append(this.ServerName);
/* 161 */       sUrl.append(";");
/* 162 */       sUrl.append("user=");
/* 163 */       sUrl.append(this.UserName);
/* 164 */       sUrl.append(";");
/* 165 */       sUrl.append("password=");
/* 166 */       sUrl.append(this.PassWord);
/* 167 */       sUrl.append(";");
/*     */     }
/*     */ 
/* 170 */     if (this.DBType.trim().toUpperCase().equals("SQLSERVER"))
/*     */     {
/* 174 */       sUrl.append("jdbc:inetdae:");
/* 175 */       sUrl.append(this.IP);
/* 176 */       sUrl.append(":");
/* 177 */       sUrl.append(this.Port);
/* 178 */       sUrl.append("?sql7=true&database=");
/* 179 */       sUrl.append(this.DBName);
/* 180 */       sUrl.append("&charset=gbk");
/*     */     }
/*     */ 
/* 183 */     if (this.DBType.trim().toUpperCase().equals("WEBLOGICPOOL"))
/*     */     {
/* 186 */       sUrl.append("jdbc:weblogic:pool:");
/* 187 */       sUrl.append(this.DBName);
/*     */     }
/*     */ 
/* 190 */     if (this.DBType.trim().toUpperCase().equals("DB2"))
/*     */     {
/* 195 */       sUrl.append("jdbc:db2://");
/* 196 */       sUrl.append(this.IP);
/* 197 */       sUrl.append(":");
/* 198 */       sUrl.append(this.Port);
/* 199 */       sUrl.append("/");
/* 200 */       sUrl.append(this.DBName);
/*     */     }
/* 202 */     return sUrl.toString();
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.ECJdbcUrlBackUp
 * JD-Core Version:    0.6.0
 */