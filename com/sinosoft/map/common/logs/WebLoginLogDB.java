/*     */ package com.sinosoft.map.common.logs;
/*     */ 
/*     */ import com.sinosoft.map.common.WebVisitor;
/*     */ import com.sinosoft.map.lis.db.MWebLoginLogDB;
/*     */ import com.sinosoft.map.lis.pubfun.MMap;
/*     */ import com.sinosoft.map.lis.pubfun.PubFun;
/*     */ import com.sinosoft.map.lis.pubfun.PubSubmit;
/*     */ import com.sinosoft.map.lis.pubfun.SysMaxNoMap;
/*     */ import com.sinosoft.map.lis.schema.MWebLoginLogSchema;
/*     */ import com.sinosoft.map.lis.vschema.MWebLoginLogSet;
/*     */ import com.sinosoft.map.user.UserModel;
/*     */ import com.sinosoft.map.utility.VData;
/*     */ import java.io.Serializable;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpSession;
/*     */ 
/*     */ public class WebLoginLogDB
/*     */   implements Serializable
/*     */ {
/*     */   public static synchronized boolean saveLoginLog(WebVisitor visitor)
/*     */   {
/*  19 */     MWebLoginLogSchema tMWebLoginLogSchema = new MWebLoginLogSchema();
/*     */ 
/*  21 */     SysMaxNoMap tSysMaxNoMap = new SysMaxNoMap("MWebLoginLogId", 20, 1);
/*     */ 
/*  23 */     tMWebLoginLogSchema.setID(tSysMaxNoMap.next());
/*  24 */     tMWebLoginLogSchema.setUserCode(visitor.getUser().getUserCode());
/*  25 */     tMWebLoginLogSchema.setLoginDate(visitor.getUser().getLoginDate());
/*  26 */     tMWebLoginLogSchema.setLoginTime(visitor.getUser().getLoginTime());
/*  27 */     if ((visitor.getUser().getUserType() != null) && (visitor.getUser().getUserType().equalsIgnoreCase("LP")))
/*     */     {
/*  29 */       tMWebLoginLogSchema.setUserType("1");
/*     */     }
/*     */     else
/*     */     {
/*  33 */       tMWebLoginLogSchema.setUserType("2");
/*     */     }
/*     */ 
/*  36 */     String ip = visitor.getHttpServletRequest().getRemoteAddr();
/*  37 */     String sessionId = visitor.getHttpServletRequest().getSession().getId();
/*     */ 
/*  39 */     tMWebLoginLogSchema.setClientName("");
/*  40 */     tMWebLoginLogSchema.setClientType("");
/*  41 */     tMWebLoginLogSchema.setClientIP(ip);
/*  42 */     tMWebLoginLogSchema.setSessionId(sessionId);
/*     */ 
/*  44 */     PubSubmit ps = new PubSubmit();
/*  45 */     MMap map = new MMap();
/*  46 */     map.put(tMWebLoginLogSchema, "INSERT");
/*     */ 
/*  48 */     VData vd = new VData();
/*  49 */     vd.add(map);
/*     */ 
/*  52 */     return ps.submitData(vd, "");
/*     */   }
/*     */ 
/*     */   public static synchronized boolean saveLogoutLog(WebVisitor visitor)
/*     */   {
/*  59 */     MWebLoginLogSchema tMWebLoginLogSchema = new MWebLoginLogSchema();
/*  60 */     MWebLoginLogSchema rMWebLoginLogSchema = new MWebLoginLogSchema();
/*     */ 
/*  62 */     MWebLoginLogDB tMWebLoginLogDB = new MWebLoginLogDB();
/*  63 */     MWebLoginLogSet tMWebLoginLogSet = new MWebLoginLogSet();
/*     */ 
/*  65 */     String sessionId = visitor.getHttpServletRequest().getSession().getId();
/*  66 */     String tUserCode = visitor.getUser().getUserCode();
/*  67 */     tMWebLoginLogSchema.setSessionId(sessionId);
/*  68 */     tMWebLoginLogSchema.setUserCode(tUserCode);
/*     */ 
/*  70 */     tMWebLoginLogDB.setSchema(tMWebLoginLogSchema);
/*  71 */     tMWebLoginLogSet = tMWebLoginLogDB.query();
/*     */ 
/*  73 */     if ((tMWebLoginLogSet != null) && (tMWebLoginLogSet.size() > 0))
/*     */     {
/*  75 */       rMWebLoginLogSchema = tMWebLoginLogSet.get(1);
/*     */     }
/*     */ 
/*  78 */     if ((rMWebLoginLogSchema.getLogoutDate() == null) && (rMWebLoginLogSchema.getLogoutTime() == null))
/*     */     {
/*  80 */       rMWebLoginLogSchema.setLogoutDate(PubFun.getCurrentDate());
/*  81 */       rMWebLoginLogSchema.setLogoutTime(PubFun.getCurrentTime());
/*     */ 
/*  83 */       PubSubmit ps = new PubSubmit();
/*  84 */       MMap map = new MMap();
/*  85 */       map.put(rMWebLoginLogSchema, "UPDATE");
/*     */ 
/*  87 */       VData vd = new VData();
/*  88 */       vd.add(map);
/*  89 */       if (!ps.submitData(vd, ""))
/*     */       {
/*  91 */         return false;
/*     */       }
/*     */     }
/*     */ 
/*  95 */     return true;
/*     */   }
/*     */ 
/*     */   public static synchronized boolean saveLogoutLogOther(String sessionId, String userCode)
/*     */   {
/* 100 */     MWebLoginLogSchema tMWebLoginLogSchema = new MWebLoginLogSchema();
/* 101 */     MWebLoginLogSchema rMWebLoginLogSchema = new MWebLoginLogSchema();
/*     */ 
/* 103 */     MWebLoginLogDB tMWebLoginLogDB = new MWebLoginLogDB();
/* 104 */     MWebLoginLogSet tMWebLoginLogSet = new MWebLoginLogSet();
/*     */ 
/* 108 */     tMWebLoginLogSchema.setSessionId(sessionId);
/* 109 */     tMWebLoginLogSchema.setUserCode(userCode);
/*     */ 
/* 111 */     tMWebLoginLogDB.setSchema(tMWebLoginLogSchema);
/* 112 */     tMWebLoginLogSet = tMWebLoginLogDB.query();
/*     */ 
/* 114 */     if ((tMWebLoginLogSet != null) && (tMWebLoginLogSet.size() > 0))
/*     */     {
/* 116 */       rMWebLoginLogSchema = tMWebLoginLogSet.get(1);
/*     */     }
/*     */ 
/* 119 */     if ((rMWebLoginLogSchema.getLogoutDate() == null) && (rMWebLoginLogSchema.getLogoutTime() == null))
/*     */     {
/* 121 */       rMWebLoginLogSchema.setLogoutDate(PubFun.getCurrentDate());
/* 122 */       rMWebLoginLogSchema.setLogoutTime(PubFun.getCurrentTime());
/*     */ 
/* 124 */       PubSubmit ps = new PubSubmit();
/* 125 */       MMap map = new MMap();
/* 126 */       map.put(rMWebLoginLogSchema, "UPDATE");
/*     */ 
/* 128 */       VData vd = new VData();
/* 129 */       vd.add(map);
/* 130 */       if (!ps.submitData(vd, ""))
/*     */       {
/* 132 */         return false;
/*     */       }
/*     */     }
/* 135 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.common.logs.WebLoginLogDB
 * JD-Core Version:    0.6.0
 */