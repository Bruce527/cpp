/*     */ package com.sinosoft.banklns.utility;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.net.InetAddress;
/*     */ import java.net.UnknownHostException;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.security.SecureRandom;
/*     */ import java.util.Random;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ public class RandomGUID
/*     */ {
/*  13 */   protected final Log logger = LogFactory.getLog(getClass());
/*     */ 
/*  15 */   public String valueBeforeMD5 = "";
/*  16 */   public String valueAfterMD5 = "";
/*     */   private static Random myRand;
/*  27 */   private static SecureRandom mySecureRand = new SecureRandom();
/*     */   private static String s_id;
/*     */   private static final int PAD_BELOW = 16;
/*     */   private static final int TWO_BYTES = 255;
/*     */ 
/*     */   static
/*     */   {
/*  28 */     long secureInitializer = mySecureRand.nextLong();
/*  29 */     myRand = new Random(secureInitializer);
/*     */     try {
/*  31 */       s_id = InetAddress.getLocalHost().toString();
/*     */     } catch (UnknownHostException e) {
/*  33 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public RandomGUID()
/*     */   {
/*  41 */     getRandomGUID(false);
/*     */   }
/*     */ 
/*     */   public RandomGUID(boolean secure)
/*     */   {
/*  46 */     getRandomGUID(secure);
/*     */   }
/*     */ 
/*     */   private void getRandomGUID(boolean secure)
/*     */   {
/*  51 */     MessageDigest md5 = null;
/*  52 */     StringBuffer sbValueBeforeMD5 = new StringBuffer(128);
/*     */     try
/*     */     {
/*  55 */       md5 = MessageDigest.getInstance("MD5");
/*     */     } catch (NoSuchAlgorithmException e) {
/*  57 */       this.logger.error("Error: " + e);
/*     */     }
/*     */     try
/*     */     {
/*  61 */       long time = System.currentTimeMillis();
/*  62 */       long rand = 0L;
/*     */ 
/*  64 */       if (secure)
/*  65 */         rand = mySecureRand.nextLong();
/*     */       else {
/*  67 */         rand = myRand.nextLong();
/*     */       }
/*  69 */       sbValueBeforeMD5.append(s_id);
/*  70 */       sbValueBeforeMD5.append(":");
/*  71 */       sbValueBeforeMD5.append(Long.toString(time));
/*  72 */       sbValueBeforeMD5.append(":");
/*  73 */       sbValueBeforeMD5.append(Long.toString(rand));
/*     */ 
/*  75 */       this.valueBeforeMD5 = sbValueBeforeMD5.toString();
/*  76 */       md5.update(this.valueBeforeMD5.getBytes());
/*     */ 
/*  78 */       byte[] array = md5.digest();
/*  79 */       StringBuffer sb = new StringBuffer(32);
/*  80 */       for (int j = 0; j < array.length; j++) {
/*  81 */         int b = array[j] & 0xFF;
/*  82 */         if (b < 16)
/*  83 */           sb.append('0');
/*  84 */         sb.append(Integer.toHexString(b));
/*     */       }
/*     */ 
/*  87 */       this.valueAfterMD5 = sb.toString();
/*     */     }
/*     */     catch (Exception e) {
/*  90 */       this.logger.error("Error:" + e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/*  96 */     String raw = this.valueAfterMD5.toUpperCase();
/*  97 */     StringBuffer sb = new StringBuffer(64);
/*  98 */     sb.append(raw.substring(0, 8));
/*  99 */     sb.append("-");
/* 100 */     sb.append(raw.substring(8, 12));
/* 101 */     sb.append("-");
/* 102 */     sb.append(raw.substring(12, 16));
/* 103 */     sb.append("-");
/* 104 */     sb.append(raw.substring(16, 20));
/* 105 */     sb.append("-");
/* 106 */     sb.append(raw.substring(20));
/*     */ 
/* 108 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 114 */     for (int i = 0; i < 1; i++) {
/* 115 */       RandomGUID myGUID = new RandomGUID();
/*     */ 
/* 118 */       System.out.println("RandomGUID=" + myGUID.toString());
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.RandomGUID
 * JD-Core Version:    0.6.0
 */