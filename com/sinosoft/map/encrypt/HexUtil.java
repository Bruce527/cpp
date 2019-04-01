/*    */ package com.sinosoft.map.encrypt;
/*    */ 
/*    */ public class HexUtil
/*    */ {
/*    */   private static final String HEX_CHARS = "0123456789abcdef";
/*    */ 
/*    */   public static String toHexString(byte[] b)
/*    */   {
/* 13 */     StringBuffer sb = new StringBuffer();
/* 14 */     for (int i = 0; i < b.length; i++) {
/* 15 */       sb.append("0123456789abcdef".charAt(b[i] >>> 4 & 0xF));
/* 16 */       sb.append("0123456789abcdef".charAt(b[i] & 0xF));
/*    */     }
/* 18 */     return sb.toString();
/*    */   }
/*    */ 
/*    */   public static byte[] toByteArray(String s)
/*    */   {
/* 23 */     byte[] buf = new byte[s.length() / 2];
/* 24 */     int j = 0;
/* 25 */     for (int i = 0; i < buf.length; i++) {
/* 26 */       buf[i] = 
/* 27 */         (byte)(Character.digit(s.charAt(j++), 16) << 4 | 
/* 27 */         Character.digit(s.charAt(j++), 16));
/*    */     }
/* 29 */     return buf;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.encrypt.HexUtil
 * JD-Core Version:    0.6.0
 */