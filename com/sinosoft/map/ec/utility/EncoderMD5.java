/*    */ package com.sinosoft.map.ec.utility;
/*    */ 
/*    */ import com.sinosoft.map.common.logs.ErrorsLog;
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import java.security.MessageDigest;
/*    */ import java.security.NoSuchAlgorithmException;
/*    */ 
/*    */ public class EncoderMD5
/*    */ {
/*    */   public static String encodeByMD5(String str)
/*    */   {
/* 16 */     String securityStr = "";
/*    */     try
/*    */     {
/* 19 */       MessageDigest md5 = MessageDigest.getInstance("MD5");
/* 20 */       md5.update(str.getBytes("utf-8"));
/* 21 */       byte[] b = md5.digest();
/*    */ 
/* 23 */       StringBuffer buff = new StringBuffer("");
/* 24 */       for (int offset = 0; offset < b.length; offset++)
/*    */       {
/* 26 */         int i = b[offset];
/* 27 */         if (i < 0) i += 256;
/* 28 */         if (i < 16) buff.append("0");
/* 29 */         buff.append(Integer.toHexString(i));
/*    */       }
/*    */ 
/* 33 */       securityStr = buff.toString();
/*    */     }
/*    */     catch (NoSuchAlgorithmException e)
/*    */     {
/* 39 */       ErrorsLog.log("Encoder:encodeByMD5:" + e.getMessage());
/*    */     }
/*    */     catch (UnsupportedEncodingException ex)
/*    */     {
/* 43 */       ErrorsLog.log("Encoder:encodeByMD5:" + ex.getMessage());
/*    */     }
/*    */ 
/* 46 */     return securityStr;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.ec.utility.EncoderMD5
 * JD-Core Version:    0.6.0
 */