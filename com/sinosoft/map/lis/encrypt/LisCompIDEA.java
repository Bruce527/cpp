/*     */ package com.sinosoft.map.lis.encrypt;
/*     */ 
/*     */ import com.sinosoft.map.lis.encrypt.security.IDEA;
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public final class LisCompIDEA
/*     */ {
/*  19 */   final String mCipherKeyStr = "12dc427f09a81e293d43db3b2378491d";
/*  20 */   final int mStrLen = 8;
/*     */ 
/*     */   public LisCompIDEA()
/*     */   {
/*     */     try
/*     */     {
/*  12 */       jbInit();
/*     */     } catch (Exception ex) {
/*  14 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public String encryptString(String fullPlainStr)
/*     */   {
/*  24 */     int length = fullPlainStr.length();
/*  25 */     int times = length / 8;
/*     */ 
/*  27 */     if (length % 8 == 0) {
/*  28 */       times--;
/*     */     }
/*  30 */     String eightStr = "";
/*  31 */     String tString = "";
/*  32 */     String finalString = "";
/*  33 */     for (int i = 0; i <= times; i++)
/*     */     {
/*  35 */       if (i == times) {
/*  36 */         eightStr = fullPlainStr.substring(i * 8);
/*  37 */         tString = eightLenEncryptString(eightStr);
/*  38 */         finalString = finalString + tString;
/*  39 */         return finalString;
/*     */       }
/*     */ 
/*  43 */       eightStr = fullPlainStr.substring(i * 8, (i + 1) * 8);
/*  44 */       tString = eightLenEncryptString(eightStr);
/*  45 */       finalString = finalString + tString;
/*     */     }
/*     */ 
/*  48 */     return "";
/*     */   }
/*     */ 
/*     */   public String encryptStringAES(String plainStr)
/*     */   {
/*  56 */     String tplainStr = "";
/*  57 */     int len = plainStr.length();
/*  58 */     if (len <= 8) {
/*  59 */       for (int i = 0; i < len; i++)
/*  60 */         tplainStr = tplainStr + plainStr.charAt(i);
/*  61 */       for (int i = 0; i < 8 - len; i++)
/*  62 */         tplainStr = tplainStr + " ";
/*     */     } else {
/*  64 */       for (int i = 0; i < 8; i++)
/*  65 */         tplainStr = tplainStr + plainStr.charAt(i);
/*     */     }
/*  67 */     System.out.println("tplainStr len:" + tplainStr.length());
/*  68 */     String hexPlainStr = stringToHexString(tplainStr);
/*  69 */     byte[] key = fromString("12dc427f09a81e293d43db3b2378491d");
/*  70 */     byte[] plain = fromString(hexPlainStr);
/*  71 */     IDEA idea = new IDEA(key);
/*  72 */     byte[] encP = new byte[plain.length];
/*     */ 
/*  74 */     idea.encrypt(plain, encP);
/*     */ 
/*  76 */     String hexEncryptString = toString(encP);
/*  77 */     return hexEncryptString;
/*     */   }
/*     */ 
/*     */   public String eightLenEncryptString(String plainStr)
/*     */   {
/*  87 */     String tplainStr = "";
/*  88 */     int len = plainStr.length();
/*     */ 
/*  90 */     if (len <= 8) {
/*  91 */       for (int i = 0; i < len; i++) {
/*  92 */         tplainStr = tplainStr + plainStr.charAt(i);
/*     */       }
/*  94 */       for (int i = 0; i < 8 - len; i++)
/*  95 */         tplainStr = tplainStr + " ";
/*     */     }
/*     */     else {
/*  98 */       for (int i = 0; i < 8; i++) {
/*  99 */         tplainStr = tplainStr + plainStr.charAt(i);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 104 */     String hexPlainStr = stringToHexString(tplainStr);
/*     */ 
/* 106 */     byte[] key = fromString("12dc427f09a81e293d43db3b2378491d");
/* 107 */     byte[] plain = fromString(hexPlainStr);
/*     */ 
/* 109 */     IDEA idea = new IDEA(key);
/* 110 */     byte[] encP = new byte[plain.length];
/*     */ 
/* 112 */     idea.encrypt(plain, encP);
/* 113 */     String hexEncryptString = toString(encP);
/* 114 */     return hexEncryptString;
/*     */   }
/*     */ 
/*     */   public String decryptString_pre(String encryptStr)
/*     */   {
/* 122 */     String tencryptStr = "";
/* 123 */     int len = encryptStr.length();
/* 124 */     if (len <= 8) {
/* 125 */       for (int i = 0; i < len; i++) {
/* 126 */         tencryptStr = tencryptStr + encryptStr.charAt(i);
/*     */       }
/*     */ 
/* 129 */       for (int i = 1; i < 8 - len; i++)
/* 130 */         tencryptStr = tencryptStr + " ";
/*     */     }
/*     */     else {
/* 133 */       for (int i = 0; i < 8; i++) {
/* 134 */         tencryptStr = tencryptStr + encryptStr.charAt(i);
/*     */       }
/*     */     }
/*     */ 
/* 138 */     String hexEncryptStr = stringToHexString(tencryptStr);
/* 139 */     byte[] key = fromString("12dc427f09a81e293d43db3b2378491d");
/* 140 */     IDEA idea = new IDEA(key);
/* 141 */     byte[] encP = fromString(hexEncryptStr);
/* 142 */     byte[] decC = new byte[encP.length];
/* 143 */     idea.decrypt(encP, decC);
/* 144 */     String hexDecryptStr = toString(decC);
/* 145 */     return hexStringToString(hexDecryptStr);
/*     */   }
/*     */ 
/*     */   public String decryptString(String fullEncryptedStr)
/*     */   {
/* 150 */     int length = fullEncryptedStr.length();
/* 151 */     int times = length / 16;
/* 152 */     String tString = "";
/* 153 */     String sixteenLenString = "";
/* 154 */     String finalString = "";
/* 155 */     for (int i = 0; i < times; i++) {
/* 156 */       sixteenLenString = fullEncryptedStr.substring(i * 16, (i + 1) * 16);
/* 157 */       tString = decryptSixteenLenString(sixteenLenString);
/* 158 */       finalString = finalString + tString;
/*     */     }
/* 160 */     return finalString;
/*     */   }
/*     */ 
/*     */   public String decryptSixteenLenString(String encryptedStr) {
/* 164 */     String hexEncryptedStr = encryptedStr;
/* 165 */     byte[] key = fromString("12dc427f09a81e293d43db3b2378491d");
/* 166 */     IDEA idea = new IDEA(key);
/* 167 */     byte[] encP = fromString(hexEncryptedStr);
/* 168 */     byte[] decC = new byte[encP.length];
/* 169 */     idea.decrypt(encP, decC);
/* 170 */     String hexDecryptStr = toString(decC);
/* 171 */     return hexStringToString(hexDecryptStr);
/*     */   }
/*     */ 
/*     */   private static String stringToHexString(String srcString)
/*     */   {
/* 177 */     String resultString = "";
/* 178 */     int srcLen = srcString.length();
/* 179 */     for (int pos = 0; pos < srcLen; pos++) {
/* 180 */       byte b = (byte)srcString.charAt(pos);
/*     */ 
/* 182 */       int hexValue = b & 0xF;
/*     */ 
/* 184 */       resultString = resultString + hexToAscii(hexValue);
/*     */ 
/* 186 */       hexValue = b >> 4 & 0xF;
/*     */ 
/* 188 */       resultString = resultString + hexToAscii(hexValue);
/*     */     }
/*     */ 
/* 192 */     return resultString;
/*     */   }
/*     */ 
/*     */   private static String hexStringToString(String hexString)
/*     */   {
/* 197 */     String resultString = "";
/* 198 */     int hexLen = hexString.length();
/* 199 */     for (int pos = 0; pos < hexLen; pos += 2) {
/* 200 */       char c1 = hexString.charAt(pos);
/* 201 */       char c2 = hexString.charAt(pos + 1);
/* 202 */       int hexvalue1 = asciiToHex(c1);
/* 203 */       int hexvalue2 = asciiToHex(c2);
/* 204 */       char c = (char)(hexvalue1 | hexvalue2 << 4);
/* 205 */       resultString = resultString + c;
/*     */     }
/*     */ 
/* 208 */     return resultString.trim();
/*     */   }
/*     */ 
/*     */   private static byte[] fromString(String inHex)
/*     */   {
/* 214 */     int len = inHex.length();
/* 215 */     int pos = 0;
/* 216 */     byte[] buffer = new byte[(len + 1) / 2];
/*     */ 
/* 218 */     if (len % 2 == 1) {
/* 219 */       buffer[0] = (byte)asciiToHex(inHex.charAt(0));
/* 220 */       pos = 1;
/* 221 */       len--;
/*     */     }
/*     */ 
/* 224 */     for (int ptr = pos; len > 0; len -= 2)
/*     */     {
/* 226 */       buffer[(pos++)] = (byte)(
/* 227 */         asciiToHex(inHex.charAt(ptr++)) << 4 | 
/* 228 */         asciiToHex(inHex.charAt(ptr++)));
/*     */     }
/*     */ 
/* 231 */     return buffer;
/*     */   }
/*     */ 
/*     */   private static String toString(byte[] buffer)
/*     */   {
/* 237 */     StringBuffer returnBuffer = new StringBuffer();
/* 238 */     int pos = 0; for (int len = buffer.length; pos < len; pos++) {
/* 239 */       returnBuffer.append(hexToAscii(buffer[pos] >>> 4 & 0xF))
/* 240 */         .append(hexToAscii(buffer[pos] & 0xF));
/*     */     }
/* 242 */     return returnBuffer.toString();
/*     */   }
/*     */ 
/*     */   private static int asciiToHex(char c)
/*     */   {
/* 248 */     if ((c >= 'a') && (c <= 'f')) {
/* 249 */       return c - 'a' + 10;
/*     */     }
/* 251 */     if ((c >= 'A') && (c <= 'F')) {
/* 252 */       return c - 'A' + 10;
/*     */     }
/* 254 */     if ((c >= '0') && (c <= '9')) {
/* 255 */       return c - '0';
/*     */     }
/* 257 */     throw new Error("ascii to hex failed");
/*     */   }
/*     */ 
/*     */   private static char hexToAscii(int h)
/*     */   {
/* 262 */     if ((h >= 10) && (h <= 15)) {
/* 263 */       return (char)(65 + (h - 10));
/*     */     }
/* 265 */     if ((h >= 0) && (h <= 9)) {
/* 266 */       return (char)(48 + h);
/*     */     }
/* 268 */     throw new Error("hex to ascii failed");
/*     */   }
/*     */ 
/*     */   public static void main(String[] argv)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void jbInit()
/*     */     throws Exception
/*     */   {
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.encrypt.LisCompIDEA
 * JD-Core Version:    0.6.0
 */