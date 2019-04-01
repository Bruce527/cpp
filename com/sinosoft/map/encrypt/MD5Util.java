/*    */ package com.sinosoft.map.encrypt;
/*    */ 
/*    */ import java.security.MessageDigest;
/*    */ import java.security.NoSuchAlgorithmException;
/*    */ 
/*    */ public class MD5Util
/*    */ {
/*    */   static MessageDigest getDigest()
/*    */   {
/*    */     try
/*    */     {
/* 15 */       return MessageDigest.getInstance("MD5"); } catch (NoSuchAlgorithmException e) {
/*    */     }
/* 17 */     throw new RuntimeException(e);
/*    */   }
/*    */ 
/*    */   public static byte[] md5(byte[] data)
/*    */   {
/* 23 */     return getDigest().digest(data);
/*    */   }
/*    */ 
/*    */   public static byte[] md5(String data)
/*    */   {
/* 28 */     return md5(data.getBytes());
/*    */   }
/*    */ 
/*    */   public static String md5Hex(byte[] data)
/*    */   {
/* 33 */     return HexUtil.toHexString(md5(data));
/*    */   }
/*    */ 
/*    */   public static String md5Hex(String data)
/*    */   {
/* 38 */     return HexUtil.toHexString(md5(data));
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.encrypt.MD5Util
 * JD-Core Version:    0.6.0
 */