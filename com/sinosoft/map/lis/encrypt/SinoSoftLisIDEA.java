/*     */ package com.sinosoft.map.lis.encrypt;
/*     */ 
/*     */ import com.sinosoft.map.lis.encrypt.security.IDEA;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class SinoSoftLisIDEA
/*     */ {
/*   9 */   String mCipherKeyStr = "12dc427f09a81e293d43db3b2378491d";
/*  10 */   int mStrLen = 8;
/*     */ 
/*     */   public String encryptString(String plainStr)
/*     */   {
/*  14 */     String tplainStr = "";
/*  15 */     int len = plainStr.length();
/*     */ 
/*  17 */     ArrayList arrStr = new ArrayList();
/*  18 */     if (len <= this.mStrLen)
/*     */     {
/*  20 */       for (int i = 0; i < len; i++)
/*     */       {
/*  22 */         tplainStr = tplainStr + plainStr.charAt(i);
/*     */       }
/*  24 */       for (int i = 0; i < this.mStrLen - len; i++)
/*     */       {
/*  26 */         tplainStr = tplainStr + " ";
/*     */       }
/*  28 */       arrStr.add(0, tplainStr);
/*     */     }
/*     */     else
/*     */     {
/*  32 */       int groupCount = 0;
/*  33 */       int modValue = 0;
/*  34 */       modValue = len % this.mStrLen;
/*  35 */       if (modValue != 0)
/*     */       {
/*  37 */         groupCount = len / this.mStrLen + 1;
/*     */       }
/*     */       else
/*     */       {
/*  41 */         groupCount = len / this.mStrLen;
/*     */       }
/*     */ 
/*  44 */       for (int iLoop = 0; iLoop < groupCount; iLoop++)
/*     */       {
/*  46 */         String temp_plainStr = "";
/*  47 */         if (iLoop < groupCount - 1)
/*     */         {
/*  49 */           for (int i = iLoop * this.mStrLen; i < (iLoop + 1) * this.mStrLen; i++)
/*     */           {
/*  51 */             temp_plainStr = temp_plainStr + plainStr.charAt(i);
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/*  56 */           temp_plainStr = plainStr.substring(iLoop * this.mStrLen);
/*  57 */           if (modValue != 0)
/*     */           {
/*  59 */             for (int jLoop = modValue + 1; jLoop <= this.mStrLen; jLoop++)
/*     */             {
/*  61 */               temp_plainStr = temp_plainStr + " ";
/*     */             }
/*     */           }
/*     */         }
/*     */ 
/*  66 */         arrStr.add(iLoop, temp_plainStr);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  71 */     String hexEncryptString = "";
/*  72 */     byte[] key = fromString(this.mCipherKeyStr);
/*  73 */     IDEA idea = new IDEA(key);
/*     */ 
/*  75 */     for (int kLoop = 0; kLoop < arrStr.size(); kLoop++)
/*     */     {
/*  77 */       String enceyptStr = (String)arrStr.get(kLoop);
/*  78 */       String hexPlainStr = stringToHexString(enceyptStr);
/*     */ 
/*  80 */       byte[] plain = fromString(hexPlainStr);
/*  81 */       byte[] encP = new byte[plain.length];
/*  82 */       idea.encrypt(plain, encP);
/*     */ 
/*  84 */       hexEncryptString = hexEncryptString + toString(encP);
/*     */     }
/*  86 */     return hexEncryptString;
/*     */   }
/*     */ 
/*     */   public String decryptString_pre(String encryptStr)
/*     */   {
/*  92 */     int len = encryptStr.length();
/*     */ 
/*  94 */     ArrayList arrStr = new ArrayList();
/*  95 */     if (len <= this.mStrLen * 2)
/*     */     {
/*  97 */       String tencryptStr = "";
/*  98 */       for (int i = 0; i < len; i++)
/*     */       {
/* 100 */         tencryptStr = tencryptStr + encryptStr.charAt(i);
/*     */       }
/* 102 */       for (int i = 0; i < this.mStrLen * 2 - len; i++)
/*     */       {
/* 104 */         tencryptStr = tencryptStr + " ";
/*     */       }
/* 106 */       arrStr.add(0, tencryptStr);
/*     */     }
/*     */     else
/*     */     {
/* 110 */       int groupCount = 0;
/* 111 */       int modValue = 0;
/* 112 */       modValue = len % (this.mStrLen * 2);
/* 113 */       if (modValue != 0)
/*     */       {
/* 115 */         groupCount = len / (this.mStrLen * 2) + 1;
/*     */       }
/*     */       else
/*     */       {
/* 119 */         groupCount = len / (this.mStrLen * 2);
/*     */       }
/*     */ 
/* 122 */       for (int iLoop = 0; iLoop < groupCount; iLoop++)
/*     */       {
/* 124 */         String temp_tencryptStr = "";
/* 125 */         if (iLoop < groupCount - 1)
/*     */         {
/* 127 */           for (int i = iLoop * (this.mStrLen * 2); i < (iLoop + 1) * (this.mStrLen * 2); i++)
/*     */           {
/* 129 */             temp_tencryptStr = temp_tencryptStr + encryptStr.charAt(i);
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 134 */           temp_tencryptStr = encryptStr.substring(iLoop * (this.mStrLen * 2));
/*     */ 
/* 136 */           if (modValue != 0)
/*     */           {
/* 138 */             for (int jLoop = modValue + 1; jLoop <= this.mStrLen * 2; jLoop++)
/*     */             {
/* 140 */               temp_tencryptStr = temp_tencryptStr + " ";
/*     */             }
/*     */           }
/*     */         }
/*     */ 
/* 145 */         arrStr.add(iLoop, temp_tencryptStr);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 150 */     byte[] key = fromString(this.mCipherKeyStr);
/* 151 */     IDEA idea = new IDEA(key);
/* 152 */     String hexDecryptStr = "";
/* 153 */     for (int kLoop = 0; kLoop < arrStr.size(); kLoop++)
/*     */     {
/* 155 */       String denceyptStr = (String)arrStr.get(kLoop);
/*     */ 
/* 158 */       byte[] encP = fromString(denceyptStr);
/* 159 */       byte[] decC = new byte[encP.length];
/* 160 */       idea.decrypt(encP, decC);
/* 161 */       hexDecryptStr = hexDecryptStr + toString(decC);
/*     */     }
/* 163 */     return hexStringToString(hexDecryptStr);
/*     */   }
/*     */ 
/*     */   public String decryptString(String encryptStr)
/*     */   {
/* 168 */     String hexEncryptStr = encryptStr;
/* 169 */     byte[] key = fromString(this.mCipherKeyStr);
/* 170 */     IDEA idea = new IDEA(key);
/* 171 */     byte[] encP = fromString(hexEncryptStr);
/* 172 */     byte[] decC = new byte[encP.length];
/* 173 */     idea.decrypt(encP, decC);
/* 174 */     String hexDecryptStr = toString(decC);
/* 175 */     return hexStringToString(hexDecryptStr);
/*     */   }
/*     */ 
/*     */   private String stringToHexString(String srcString)
/*     */   {
/* 181 */     String resultString = "";
/* 182 */     int srcLen = srcString.length();
/* 183 */     for (int pos = 0; pos < srcLen; pos++)
/*     */     {
/* 185 */       byte b = (byte)srcString.charAt(pos);
/* 186 */       int hexValue = b & 0xF;
/* 187 */       resultString = resultString + hexToAscii(hexValue);
/* 188 */       hexValue = b >> 4 & 0xF;
/* 189 */       resultString = resultString + hexToAscii(hexValue);
/*     */     }
/* 191 */     return resultString;
/*     */   }
/*     */ 
/*     */   private String hexStringToString(String hexString)
/*     */   {
/* 197 */     String resultString = "";
/* 198 */     int hexLen = hexString.length();
/* 199 */     for (int pos = 0; pos < hexLen; pos += 2)
/*     */     {
/* 201 */       char c1 = hexString.charAt(pos);
/* 202 */       char c2 = hexString.charAt(pos + 1);
/* 203 */       int hexvalue1 = asciiToHex(c1);
/* 204 */       int hexvalue2 = asciiToHex(c2);
/* 205 */       char c = (char)(hexvalue1 | hexvalue2 << 4);
/* 206 */       resultString = resultString + c;
/*     */     }
/*     */ 
/* 209 */     return resultString.trim();
/*     */   }
/*     */ 
/*     */   private byte[] fromString(String inHex)
/*     */   {
/* 215 */     int len = inHex.length();
/* 216 */     int pos = 0;
/* 217 */     byte[] buffer = new byte[(len + 1) / 2];
/* 218 */     if (len % 2 == 1)
/*     */     {
/* 220 */       buffer[0] = (byte)asciiToHex(inHex.charAt(0));
/* 221 */       pos = 1;
/* 222 */       len--;
/*     */     }
/*     */ 
/* 225 */     for (int ptr = pos; len > 0; len -= 2)
/*     */     {
/* 227 */       buffer[(pos++)] = (byte)(
/* 228 */         asciiToHex(inHex.charAt(ptr++)) << 4 | 
/* 229 */         asciiToHex(inHex.charAt(ptr++)));
/*     */     }
/*     */ 
/* 232 */     return buffer;
/*     */   }
/*     */ 
/*     */   private String toString(byte[] buffer)
/*     */   {
/* 239 */     StringBuffer returnBuffer = new StringBuffer();
/* 240 */     int pos = 0; for (int len = buffer.length; pos < len; pos++)
/*     */     {
/* 242 */       returnBuffer.append(hexToAscii(buffer[pos] >>> 4 & 0xF))
/* 243 */         .append(hexToAscii(buffer[pos] & 0xF));
/*     */     }
/* 245 */     return returnBuffer.toString();
/*     */   }
/*     */ 
/*     */   private int asciiToHex(char c)
/*     */   {
/* 252 */     if ((c >= 'a') && (c <= 'f'))
/*     */     {
/* 254 */       return c - 'a' + 10;
/*     */     }
/* 256 */     if ((c >= 'A') && (c <= 'F'))
/*     */     {
/* 258 */       return c - 'A' + 10;
/*     */     }
/* 260 */     if ((c >= '0') && (c <= '9'))
/*     */     {
/* 262 */       return c - '0';
/*     */     }
/* 264 */     throw new Error("ascii to hex failed");
/*     */   }
/*     */ 
/*     */   private char hexToAscii(int h)
/*     */   {
/* 270 */     if ((h >= 10) && (h <= 15))
/*     */     {
/* 272 */       return (char)(65 + (h - 10));
/*     */     }
/* 274 */     if ((h >= 0) && (h <= 9))
/*     */     {
/* 276 */       return (char)(48 + h);
/*     */     }
/* 278 */     throw new Error("hex to ascii failed");
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.encrypt.SinoSoftLisIDEA
 * JD-Core Version:    0.6.0
 */