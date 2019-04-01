/*     */ package com.sinosoft.map.common;
/*     */ 
/*     */ import com.sinosoft.map.lis.pubfun.PubFun;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.io.Serializable;
/*     */ import javax.crypto.SecretKey;
/*     */ import javax.crypto.SecretKeyFactory;
/*     */ import javax.crypto.spec.DESedeKeySpec;
/*     */ 
/*     */ public class Constants
/*     */   implements Serializable
/*     */ {
/*     */   public static final String OUT_SUCCESS = "success";
/*     */   public static final String OUT_FAILURE = "failure";
/*     */   public static final String OUT_ERROR = "error";
/*     */   public static final String OUT_FATAL = "fatal";
/*     */   public static final String PATH_CONNECTION = "/WEB-INF/config/dbconn/dbconnection.xml";
/*     */   public static final String DATABASE_SYSFRAME = "hasl";
/*     */   public static final String BUNDLE_PROGRAM = "com.sinosoft.map.international.resource.programresource";
/*     */   public static final String BUNDLE_INNER = "com.sinosoft.map.international.resource.innerresource";
/*     */   public static final String BUNDLE_OUTER = "com.sinosoft.map.international.resource.outerresource";
/*     */   public static final String BUNDLE_INNERMESSAGE = "com.sinosoft.map.international.message.innermessage";
/*     */   public static final String BUNDLE_OUTERMESSAGE = "com.sinosoft.map.international.message.outermessage";
/*     */   public static final String VISITOR_KEY = "webVisitor";
/*     */   public static final String GROUP_ADMIN = "admin";
/*     */   public static final String GROUP_USER = "user";
/*     */   public static final String PATH_ERRORSLOG = "/logs/errorslog";
/*     */   public static final String PATH_VISITORLOG = "/logs/visitorlog";
/*     */   public static final String PATH_WEBVISITORLOG = "/logs/webvisitorlog";
/*     */   public static final String PATH_VISITLOG = "/logs/visitlog";
/*     */   public static final String PATH_APPCONFIG = "/WEB-INF/config/app-config.xml";
/*     */   public static final String PATH_ACCESSAUTH = "/WEB-INF/config/common/accessauth.xml";
/*     */   public static final String PATH_DISACCESS = "/WEB-INF/config/common/disaccess.xml";
/*     */   public static final String PATH_TRAN28a_XML = "/templete/tran28a.xml";
/*     */   public static final String PATH_TRAN28b_XML = "/templete/tran28b.xml";
/*     */   public static final String PATH_TRAN28f_XML = "/templete/tran28f.xml";
/*     */   public static final String PATH_TRAN28g_XML = "/templete/tran28g.xml";
/*  76 */   private static final File keyFile = new File(PubFun.getRealPath() + "/sysmanage/sinosoft_metlife_secretKey");
/*     */ 
/*  81 */   public static SecretKey key = readKey();
/*     */ 
/*     */   private static SecretKey readKey()
/*     */   {
/*  87 */     System.out.println("\u951F\u65A4\u62F7\u53D6key");
/*     */     try
/*     */     {
/*  90 */       if (key != null)
/*     */       {
/*  92 */         return key;
/*     */       }
/*     */ 
/*  97 */       DataInputStream in = new DataInputStream(new FileInputStream(keyFile));
/*  98 */       byte[] rawkey = new byte[(int)keyFile.length()];
/*  99 */       in.readFully(rawkey);
/* 100 */       in.close();
/*     */ 
/* 103 */       DESedeKeySpec keyspec = new DESedeKeySpec(rawkey);
/* 104 */       SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
/* 105 */       key = keyfactory.generateSecret(keyspec);
/* 106 */       return key;
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */     }
/* 111 */     return null;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.common.Constants
 * JD-Core Version:    0.6.0
 */