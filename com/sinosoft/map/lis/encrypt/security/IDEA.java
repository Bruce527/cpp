/*     */ package com.sinosoft.map.lis.encrypt.security;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public final class IDEA extends BlockCipher
/*     */ {
/*     */   private static final String LIBRARY_NAME = "idea";
/*  13 */   private static boolean native_link_ok = false;
/*  14 */   private static boolean native_lib_loaded = false;
/*  15 */   private static String native_link_err = "Class never loaded";
/*     */   public static final int BLOCK_LENGTH = 8;
/*     */   public static final int KEY_LENGTH = 16;
/*     */   private static final int INTERNAL_KEY_LENGTH = 104;
/*     */   private static final int KEYS_PER_ROUND = 6;
/*     */   private static final int ROUNDS = 8;
/*     */   private int[] ks;
/* 104 */   private int[] dks = null;
/*     */ 
/*     */   static
/*     */   {
/*     */     try
/*     */     {
/*  25 */       System.loadLibrary("idea");
/*  26 */       native_lib_loaded = true;
/*     */       try
/*     */       {
/*  32 */         if (idea_test() == 0)
/*     */         {
/*  34 */           native_link_ok = true;
/*  35 */           native_link_err = null;
/*     */         }
/*     */         else
/*     */         {
/*  39 */           native_link_err = "Self test failed";
/*     */         }
/*     */       }
/*     */       catch (UnsatisfiedLinkError ule)
/*     */       {
/*  44 */         native_link_err = "Errors linking to idea native library";
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (UnsatisfiedLinkError ule)
/*     */     {
/*  50 */       native_link_err = "The idea native library was not found";
/*     */     }
/*     */   }
/*     */ 
/*     */   public static boolean hasFileLibraryLoaded()
/*     */   {
/*  57 */     return native_lib_loaded;
/*     */   }
/*     */ 
/*     */   public static boolean isLibraryCorrect()
/*     */   {
/*  62 */     return native_link_ok;
/*     */   }
/*     */ 
/*     */   public static String getLinkErrorString()
/*     */   {
/*  67 */     return native_link_err;
/*     */   }
/*     */ 
/*     */   public int blockLength()
/*     */   {
/*  89 */     return 8;
/*     */   }
/*     */ 
/*     */   public int keyLength()
/*     */   {
/*  95 */     return 16;
/*     */   }
/*     */ 
/*     */   public IDEA(byte[] userKey)
/*     */   {
/* 111 */     if (userKey.length != 16)
/*     */     {
/* 113 */       throw new CryptoError("Idea: User key length wrong");
/*     */     }
/*     */ 
/* 116 */     if (native_link_ok)
/*     */     {
/* 118 */       native_ks(userKey);
/*     */     }
/*     */     else
/*     */     {
/* 122 */       java_ks(userKey);
/*     */     }
/*     */   }
/*     */ 
/*     */   private static int mul(int a, int b)
/*     */   {
/* 134 */     a &= 65535;
/* 135 */     b &= 65535;
/* 136 */     if (a != 0)
/*     */     {
/* 138 */       if (b != 0)
/*     */       {
/* 140 */         int p = a * b;
/* 141 */         b = p & 0xFFFF;
/* 142 */         a = p >>> 16;
/* 143 */         return b - a + (b < a ? 1 : 0) & 0xFFFF;
/*     */       }
/*     */ 
/* 147 */       return 1 - a & 0xFFFF;
/*     */     }
/*     */ 
/* 150 */     return 1 - b & 0xFFFF;
/*     */   }
/*     */ 
/*     */   private static int inv(int x)
/*     */   {
/* 166 */     x &= 65535;
/*     */ 
/* 168 */     if (x <= 1)
/*     */     {
/* 170 */       return x;
/*     */     }
/*     */ 
/* 173 */     int t1 = 65537 / x;
/* 174 */     int y = 65537 % x;
/* 175 */     if (y == 1)
/*     */     {
/* 177 */       return 1 - t1 & 0xFFFF;
/*     */     }
/*     */ 
/* 180 */     int t0 = 1;
/*     */     do
/*     */     {
/* 183 */       int q = x / y;
/* 184 */       x %= y;
/* 185 */       t0 = t0 + q * t1 & 0xFFFF;
/* 186 */       if (x == 1)
/*     */       {
/* 188 */         return t0;
/*     */       }
/* 190 */       q = y / x;
/* 191 */       y %= x;
/* 192 */       t1 += q * t0;
/*     */     }
/* 194 */     while (y != 1);
/*     */ 
/* 196 */     return 1 - t1 & 0xFFFF;
/*     */   }
/*     */ 
/*     */   private void java_ks(byte[] userKey)
/*     */   {
/* 207 */     this.ks = new int[52];
/*     */ 
/* 209 */     for (int i = 0; i < 8; i++)
/*     */     {
/* 211 */       this.ks[i] = 
/* 212 */         ((userKey[(i * 2)] & 0xFF) << 8 | 
/* 212 */         userKey[(i * 2 + 1)] & 0xFF);
/*     */     }
/*     */ 
/* 215 */     int j = 0;
/* 216 */     int koff = 0;
/* 217 */     for (; i < 52; i++)
/*     */     {
/* 219 */       j++;
/* 220 */       this.ks[
/* 221 */         (koff + j + 
/* 221 */         7)] = 
/* 222 */         ((this.ks[(koff + (j & 0x7))] << 9 | 
/* 222 */         this.ks[(koff + (j + 1 & 0x7))] >>> 7) & 0xFFFF);
/* 223 */       koff += (j & 0x8);
/* 224 */       j &= 7;
/*     */     }
/*     */   }
/*     */ 
/*     */   private void java_dks()
/*     */   {
/* 237 */     int j = 0;
/*     */ 
/* 239 */     this.dks = new int[52];
/*     */ 
/* 241 */     this.dks[48] = inv(this.ks[(j++)]);
/* 242 */     this.dks[49] = (-this.ks[(j++)]);
/* 243 */     this.dks[50] = (-this.ks[(j++)]);
/* 244 */     this.dks[51] = inv(this.ks[(j++)]);
/*     */ 
/* 246 */     for (int i = 42; i >= 0; i -= 6)
/*     */     {
/* 248 */       this.dks[(i + 4)] = this.ks[(j++)];
/* 249 */       this.dks[(i + 5)] = this.ks[(j++)];
/* 250 */       this.dks[(i + 0)] = inv(this.ks[(j++)]);
/* 251 */       if (i > 0)
/*     */       {
/* 253 */         this.dks[(i + 2)] = (-this.ks[(j++)]);
/* 254 */         this.dks[(i + 1)] = (-this.ks[(j++)]);
/*     */       }
/*     */       else
/*     */       {
/* 258 */         this.dks[(i + 1)] = (-this.ks[(j++)]);
/* 259 */         this.dks[(i + 2)] = (-this.ks[(j++)]);
/*     */       }
/* 261 */       this.dks[(i + 3)] = inv(this.ks[(j++)]);
/*     */     }
/*     */   }
/*     */ 
/*     */   private static void java_encrypt(byte[] in, int in_offset, byte[] out, int out_offset, int[] key)
/*     */   {
/* 273 */     int k = 0;
/*     */ 
/* 276 */     int x0 = in[(in_offset++)] << 8;
/* 277 */     x0 |= in[(in_offset++)] & 0xFF;
/* 278 */     int x1 = in[(in_offset++)] << 8;
/* 279 */     x1 |= in[(in_offset++)] & 0xFF;
/* 280 */     int x2 = in[(in_offset++)] << 8;
/* 281 */     x2 |= in[(in_offset++)] & 0xFF;
/* 282 */     int x3 = in[(in_offset++)] << 8;
/* 283 */     x3 |= in[in_offset] & 0xFF;
/*     */ 
/* 285 */     for (int i = 0; i < 8; i++)
/*     */     {
/* 287 */       x0 = mul(x0, key[(k++)]);
/* 288 */       x1 += key[(k++)];
/* 289 */       x2 += key[(k++)];
/* 290 */       x3 = mul(x3, key[(k++)]);
/*     */ 
/* 292 */       int t0 = x2;
/* 293 */       x2 = mul(x0 ^ x2, key[(k++)]);
/* 294 */       int t1 = x1;
/* 295 */       x1 = mul((x1 ^ x3) + x2, key[(k++)]);
/* 296 */       x2 += x1;
/*     */ 
/* 298 */       x0 ^= x1;
/* 299 */       x3 ^= x2;
/* 300 */       x1 ^= t0;
/* 301 */       x2 ^= t1;
/*     */     }
/*     */ 
/* 304 */     x0 = mul(x0, key[(k++)]);
/* 305 */     int t0 = x1;
/* 306 */     x1 = x2 + key[(k++)];
/* 307 */     x2 = t0 + key[(k++)];
/* 308 */     x3 = mul(x3, key[k]);
/*     */ 
/* 310 */     out[(out_offset++)] = (byte)(x0 >>> 8);
/* 311 */     out[(out_offset++)] = (byte)x0;
/* 312 */     out[(out_offset++)] = (byte)(x1 >>> 8);
/* 313 */     out[(out_offset++)] = (byte)x1;
/* 314 */     out[(out_offset++)] = (byte)(x2 >>> 8);
/* 315 */     out[(out_offset++)] = (byte)x2;
/* 316 */     out[(out_offset++)] = (byte)(x3 >>> 8);
/* 317 */     out[out_offset] = (byte)x3;
/*     */   }
/*     */ 
/*     */   protected void blockEncrypt(byte[] in, int in_offset, byte[] out, int out_offset)
/*     */   {
/* 331 */     if (this.ks == null)
/*     */     {
/* 333 */       throw new CryptoError("Idea: User key not set.");
/*     */     }
/*     */ 
/* 336 */     if (native_link_ok)
/*     */     {
/* 339 */       native_encrypt(in, in_offset, out, out_offset, this.ks);
/*     */     }
/*     */     else
/*     */     {
/* 344 */       java_encrypt(in, in_offset, out, out_offset, this.ks);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void blockDecrypt(byte[] in, int in_offset, byte[] out, int out_offset)
/*     */   {
/* 359 */     if (this.dks == null)
/*     */     {
/* 366 */       this.dks = new int[52];
/* 367 */       if (native_link_ok)
/*     */       {
/* 369 */         native_dks();
/*     */       }
/*     */       else
/*     */       {
/* 373 */         java_dks();
/*     */       }
/*     */     }
/*     */ 
/* 377 */     if (native_link_ok)
/*     */     {
/* 379 */       native_encrypt(in, in_offset, out, out_offset, this.dks);
/*     */     }
/*     */     else
/*     */     {
/* 383 */       java_encrypt(in, in_offset, out, out_offset, this.dks);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void native_ks(byte[] userKey)
/*     */   {
/* 396 */     java_ks(userKey);
/*     */   }
/*     */ 
/*     */   public void native_dks()
/*     */   {
/* 403 */     java_dks();
/*     */   }
/*     */ 
/*     */   public void native_encrypt(byte[] in, int in_offset, byte[] out, int out_offset, int[] key)
/*     */   {
/*     */   }
/*     */ 
/*     */   private static synchronized native int idea_test();
/*     */ 
/*     */   private static synchronized native void idea_ks(byte[] paramArrayOfByte);
/*     */ 
/*     */   private static synchronized native void idea_dks();
/*     */ 
/*     */   private static synchronized native void idea_encrypt(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, byte[] paramArrayOfByte3);
/*     */ 
/*     */   public static void self_test(PrintStream out, String[] argv)
/*     */     throws Exception
/*     */   {
/* 447 */     test(out, "00010002000300040005000600070008", "0000000100020003", 
/* 448 */       "11FBED2B01986DE5");
/* 449 */     test(out, "0005000A000F00140019001E00230028", "0102030405060708", 
/* 450 */       "3EC04780BEFF6E20");
/* 451 */     test(out, "3A984E2000195DB32EE501C8C47CEA60", "0102030405060708", 
/* 452 */       "97BCD8200780DA86");
/* 453 */     test(out, "006400C8012C019001F4025802BC0320", "05320A6414C819FA", 
/* 454 */       "65BE87E7A2538AED");
/* 455 */     test(out, "9D4075C103BC322AFB03E7BE6AB30006", "0808080808080808", 
/* 456 */       "F5DB1AC45E5EF9F9");
/*     */   }
/*     */ 
/*     */   private static void test(PrintStream out, String keyStr, String plainStr, String cipherStr)
/*     */   {
/* 462 */     byte[] key = fromString(keyStr);
/* 463 */     byte[] plain = fromString(plainStr);
/* 464 */     byte[] cipher = fromString(cipherStr);
/* 465 */     IDEA idea = new IDEA(key);
/* 466 */     byte[] encP = new byte[plain.length];
/* 467 */     byte[] decC = new byte[plain.length];
/* 468 */     idea.encrypt(plain, encP);
/*     */     String a;
/*     */     String b;
/* 470 */     out.println("plain:" + toString(plain) + " enc:" + (a = toString(encP)) + 
/* 471 */       " calc:" + (b = toString(cipher)));
/* 472 */     if (a.equals(b))
/*     */     {
/* 474 */       out.println("encryption good");
/*     */     }
/*     */     else
/*     */     {
/* 478 */       out.println(" ********* IDEA ENC FAILED ********* ");
/*     */     }
/* 480 */     idea.decrypt(encP, decC);
/* 481 */     out.println("  enc:" + toString(encP) + " dec:" + (a = toString(decC)) + 
/* 482 */       " calc:" + (b = toString(plain)));
/* 483 */     if (a.equals(b))
/*     */     {
/* 485 */       out.println("decryption good");
/*     */     }
/*     */     else
/*     */     {
/* 489 */       out.println(" ********* IDEA DEC FAILED ********* ");
/*     */     }
/*     */   }
/*     */ 
/*     */   private static byte[] fromString(String inHex)
/*     */   {
/* 495 */     int len = inHex.length();
/* 496 */     int pos = 0;
/* 497 */     byte[] buffer = new byte[(len + 1) / 2];
/* 498 */     if (len % 2 == 1)
/*     */     {
/* 500 */       buffer[0] = (byte)asciiToHex(inHex.charAt(0));
/* 501 */       pos = 1;
/* 502 */       len--;
/*     */     }
/*     */ 
/* 505 */     for (int ptr = pos; len > 0; len -= 2)
/*     */     {
/* 507 */       buffer[(pos++)] = (byte)(
/* 508 */         asciiToHex(inHex.charAt(ptr++)) << 4 | 
/* 509 */         asciiToHex(inHex.charAt(ptr++)));
/*     */     }
/*     */ 
/* 512 */     return buffer;
/*     */   }
/*     */ 
/*     */   private static String toString(byte[] buffer)
/*     */   {
/* 517 */     StringBuffer returnBuffer = new StringBuffer();
/* 518 */     int pos = 0; for (int len = buffer.length; pos < len; pos++)
/*     */     {
/* 520 */       returnBuffer.append(hexToAscii(buffer[pos] >>> 4 & 0xF))
/* 521 */         .append(hexToAscii(buffer[pos] & 0xF));
/*     */     }
/* 523 */     return returnBuffer.toString();
/*     */   }
/*     */ 
/*     */   private static int asciiToHex(char c)
/*     */   {
/* 528 */     if ((c >= 'a') && (c <= 'f'))
/*     */     {
/* 530 */       return c - 'a' + 10;
/*     */     }
/* 532 */     if ((c >= 'A') && (c <= 'F'))
/*     */     {
/* 534 */       return c - 'A' + 10;
/*     */     }
/* 536 */     if ((c >= '0') && (c <= '9'))
/*     */     {
/* 538 */       return c - '0';
/*     */     }
/* 540 */     throw new Error("ascii to hex failed");
/*     */   }
/*     */ 
/*     */   private static char hexToAscii(int h)
/*     */   {
/* 545 */     if ((h >= 10) && (h <= 15))
/*     */     {
/* 547 */       return (char)(65 + (h - 10));
/*     */     }
/* 549 */     if ((h >= 0) && (h <= 9))
/*     */     {
/* 551 */       return (char)(48 + h);
/*     */     }
/* 553 */     throw new Error("hex to ascii failed");
/*     */   }
/*     */ 
/*     */   public static void main(String[] argv)
/*     */   {
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.encrypt.security.IDEA
 * JD-Core Version:    0.6.0
 */