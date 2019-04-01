/*     */ package com.sinosoft.map.encrypt;
/*     */ 
/*     */ public class MD5
/*     */ {
/*     */   static final int S11 = 7;
/*     */   static final int S12 = 12;
/*     */   static final int S13 = 17;
/*     */   static final int S14 = 22;
/*     */   static final int S21 = 5;
/*     */   static final int S22 = 9;
/*     */   static final int S23 = 14;
/*     */   static final int S24 = 20;
/*     */   static final int S31 = 4;
/*     */   static final int S32 = 11;
/*     */   static final int S33 = 16;
/*     */   static final int S34 = 23;
/*     */   static final int S41 = 6;
/*     */   static final int S42 = 10;
/*     */   static final int S43 = 15;
/*     */   static final int S44 = 21;
/*  30 */   static final byte[] PADDING = { 
/*  31 */     -128 };
/*     */ 
/*  37 */   private long[] state = new long[4];
/*  38 */   private long[] count = new long[2];
/*  39 */   private byte[] buffer = new byte[64];
/*     */   public String digestHexStr;
/*  45 */   private byte[] digest = new byte[16];
/*     */ 
/*     */   public String getMD5ofStr(String inbuf)
/*     */   {
/*  49 */     md5Init();
/*  50 */     md5Update(inbuf.getBytes(), inbuf.length());
/*  51 */     md5Final();
/*  52 */     this.digestHexStr = "";
/*  53 */     for (int i = 0; i < 16; i++) {
/*  54 */       this.digestHexStr += byteHEX(this.digest[i]);
/*     */     }
/*  56 */     return this.digestHexStr;
/*     */   }
/*     */ 
/*     */   public MD5()
/*     */   {
/*  62 */     md5Init();
/*     */   }
/*     */ 
/*     */   private void md5Init()
/*     */   {
/*  69 */     this.count[0] = 0L;
/*  70 */     this.count[1] = 0L;
/*     */ 
/*  73 */     this.state[0] = 1732584193L;
/*  74 */     this.state[1] = 4023233417L;
/*  75 */     this.state[2] = 2562383102L;
/*  76 */     this.state[3] = 271733878L;
/*     */   }
/*     */ 
/*     */   private long F(long x, long y, long z)
/*     */   {
/*  84 */     return x & y | (x ^ 0xFFFFFFFF) & z;
/*     */   }
/*     */ 
/*     */   private long G(long x, long y, long z)
/*     */   {
/*  89 */     return x & z | y & (z ^ 0xFFFFFFFF);
/*     */   }
/*     */ 
/*     */   private long H(long x, long y, long z)
/*     */   {
/*  94 */     return x ^ y ^ z;
/*     */   }
/*     */ 
/*     */   private long I(long x, long y, long z) {
/*  98 */     return y ^ (x | z ^ 0xFFFFFFFF);
/*     */   }
/*     */ 
/*     */   private long FF(long a, long b, long c, long d, long x, long s, long ac)
/*     */   {
/* 105 */     a += F(b, c, d) + x + ac;
/* 106 */     a = (int)a << (int)s | (int)a >>> (int)(32L - s);
/* 107 */     a += b;
/* 108 */     return a;
/*     */   }
/*     */ 
/*     */   private long GG(long a, long b, long c, long d, long x, long s, long ac)
/*     */   {
/* 113 */     a += G(b, c, d) + x + ac;
/* 114 */     a = (int)a << (int)s | (int)a >>> (int)(32L - s);
/* 115 */     a += b;
/* 116 */     return a;
/*     */   }
/*     */ 
/*     */   private long HH(long a, long b, long c, long d, long x, long s, long ac)
/*     */   {
/* 121 */     a += H(b, c, d) + x + ac;
/* 122 */     a = (int)a << (int)s | (int)a >>> (int)(32L - s);
/* 123 */     a += b;
/* 124 */     return a;
/*     */   }
/*     */ 
/*     */   private long II(long a, long b, long c, long d, long x, long s, long ac)
/*     */   {
/* 129 */     a += I(b, c, d) + x + ac;
/* 130 */     a = (int)a << (int)s | (int)a >>> (int)(32L - s);
/* 131 */     a += b;
/* 132 */     return a;
/*     */   }
/*     */ 
/*     */   private void md5Update(byte[] inbuf, int inputLen)
/*     */   {
/* 139 */     byte[] block = new byte[64];
/* 140 */     int index = (int)(this.count[0] >>> 3) & 0x3F;
/*     */ 
/* 142 */     if (this.count[0] += (inputLen << 3) < inputLen << 3)
/* 143 */       this.count[1] += 1L;
/* 144 */     this.count[1] += (inputLen >>> 29);
/*     */ 
/* 146 */     int partLen = 64 - index;
/*     */     int i;
/* 149 */     if (inputLen >= partLen) {
/* 150 */       md5Memcpy(this.buffer, inbuf, index, 0, partLen);
/* 151 */       md5Transform(this.buffer);
/*     */ 
/* 153 */       for (int i = partLen; i + 63 < inputLen; i += 64)
/*     */       {
/* 155 */         md5Memcpy(block, inbuf, 0, i, 64);
/* 156 */         md5Transform(block);
/*     */       }
/* 158 */       index = 0;
/*     */     }
/*     */     else
/*     */     {
/* 163 */       i = 0;
/*     */     }
/*     */ 
/* 166 */     md5Memcpy(this.buffer, inbuf, index, i, inputLen - i);
/*     */   }
/*     */ 
/*     */   private void md5Final()
/*     */   {
/* 172 */     byte[] bits = new byte[8];
/*     */ 
/* 176 */     Encode(bits, this.count, 8);
/*     */ 
/* 179 */     int index = (int)(this.count[0] >>> 3) & 0x3F;
/* 180 */     int padLen = index < 56 ? 56 - index : 120 - index;
/* 181 */     md5Update(PADDING, padLen);
/*     */ 
/* 184 */     md5Update(bits, 8);
/*     */ 
/* 187 */     Encode(this.digest, this.state, 16);
/*     */   }
/*     */ 
/*     */   private void md5Memcpy(byte[] output, byte[] input, int outpos, int inpos, int len)
/*     */   {
/* 197 */     for (int i = 0; i < len; i++)
/* 198 */       output[(outpos + i)] = input[(inpos + i)];
/*     */   }
/*     */ 
/*     */   private void md5Transform(byte[] block)
/*     */   {
/* 203 */     long a = this.state[0]; long b = this.state[1]; long c = this.state[2]; long d = this.state[3];
/* 204 */     long[] x = new long[16];
/*     */ 
/* 206 */     Decode(x, block, 64);
/*     */ 
/* 209 */     a = FF(a, b, c, d, x[0], 7L, 3614090360L);
/* 210 */     d = FF(d, a, b, c, x[1], 12L, 3905402710L);
/* 211 */     c = FF(c, d, a, b, x[2], 17L, 606105819L);
/* 212 */     b = FF(b, c, d, a, x[3], 22L, 3250441966L);
/* 213 */     a = FF(a, b, c, d, x[4], 7L, 4118548399L);
/* 214 */     d = FF(d, a, b, c, x[5], 12L, 1200080426L);
/* 215 */     c = FF(c, d, a, b, x[6], 17L, 2821735955L);
/* 216 */     b = FF(b, c, d, a, x[7], 22L, 4249261313L);
/* 217 */     a = FF(a, b, c, d, x[8], 7L, 1770035416L);
/* 218 */     d = FF(d, a, b, c, x[9], 12L, 2336552879L);
/* 219 */     c = FF(c, d, a, b, x[10], 17L, 4294925233L);
/* 220 */     b = FF(b, c, d, a, x[11], 22L, 2304563134L);
/* 221 */     a = FF(a, b, c, d, x[12], 7L, 1804603682L);
/* 222 */     d = FF(d, a, b, c, x[13], 12L, 4254626195L);
/* 223 */     c = FF(c, d, a, b, x[14], 17L, 2792965006L);
/* 224 */     b = FF(b, c, d, a, x[15], 22L, 1236535329L);
/*     */ 
/* 227 */     a = GG(a, b, c, d, x[1], 5L, 4129170786L);
/* 228 */     d = GG(d, a, b, c, x[6], 9L, 3225465664L);
/* 229 */     c = GG(c, d, a, b, x[11], 14L, 643717713L);
/* 230 */     b = GG(b, c, d, a, x[0], 20L, 3921069994L);
/* 231 */     a = GG(a, b, c, d, x[5], 5L, 3593408605L);
/* 232 */     d = GG(d, a, b, c, x[10], 9L, 38016083L);
/* 233 */     c = GG(c, d, a, b, x[15], 14L, 3634488961L);
/* 234 */     b = GG(b, c, d, a, x[4], 20L, 3889429448L);
/* 235 */     a = GG(a, b, c, d, x[9], 5L, 568446438L);
/* 236 */     d = GG(d, a, b, c, x[14], 9L, 3275163606L);
/* 237 */     c = GG(c, d, a, b, x[3], 14L, 4107603335L);
/* 238 */     b = GG(b, c, d, a, x[8], 20L, 72720877L);
/* 239 */     a = GG(a, b, c, d, x[13], 5L, 2850285829L);
/* 240 */     d = GG(d, a, b, c, x[2], 9L, 4243563512L);
/* 241 */     c = GG(c, d, a, b, x[7], 14L, 1735328473L);
/* 242 */     b = GG(b, c, d, a, x[12], 20L, 2368359562L);
/*     */ 
/* 245 */     a = HH(a, b, c, d, x[5], 4L, 4294588738L);
/* 246 */     d = HH(d, a, b, c, x[8], 11L, 2272392833L);
/* 247 */     c = HH(c, d, a, b, x[11], 16L, 1839030562L);
/* 248 */     b = HH(b, c, d, a, x[14], 23L, 4259657740L);
/* 249 */     a = HH(a, b, c, d, x[1], 4L, 2763975236L);
/* 250 */     d = HH(d, a, b, c, x[4], 11L, 1272893353L);
/* 251 */     c = HH(c, d, a, b, x[7], 16L, 4139469664L);
/* 252 */     b = HH(b, c, d, a, x[10], 23L, 3200236656L);
/* 253 */     a = HH(a, b, c, d, x[13], 4L, 681279174L);
/* 254 */     d = HH(d, a, b, c, x[0], 11L, 3936430074L);
/* 255 */     c = HH(c, d, a, b, x[3], 16L, 3572445317L);
/* 256 */     b = HH(b, c, d, a, x[6], 23L, 76029189L);
/* 257 */     a = HH(a, b, c, d, x[9], 4L, 3654602809L);
/* 258 */     d = HH(d, a, b, c, x[12], 11L, 3873151461L);
/* 259 */     c = HH(c, d, a, b, x[15], 16L, 530742520L);
/* 260 */     b = HH(b, c, d, a, x[2], 23L, 3299628645L);
/*     */ 
/* 263 */     a = II(a, b, c, d, x[0], 6L, 4096336452L);
/* 264 */     d = II(d, a, b, c, x[7], 10L, 1126891415L);
/* 265 */     c = II(c, d, a, b, x[14], 15L, 2878612391L);
/* 266 */     b = II(b, c, d, a, x[5], 21L, 4237533241L);
/* 267 */     a = II(a, b, c, d, x[12], 6L, 1700485571L);
/* 268 */     d = II(d, a, b, c, x[3], 10L, 2399980690L);
/* 269 */     c = II(c, d, a, b, x[10], 15L, 4293915773L);
/* 270 */     b = II(b, c, d, a, x[1], 21L, 2240044497L);
/* 271 */     a = II(a, b, c, d, x[8], 6L, 1873313359L);
/* 272 */     d = II(d, a, b, c, x[15], 10L, 4264355552L);
/* 273 */     c = II(c, d, a, b, x[6], 15L, 2734768916L);
/* 274 */     b = II(b, c, d, a, x[13], 21L, 1309151649L);
/* 275 */     a = II(a, b, c, d, x[4], 6L, 4149444226L);
/* 276 */     d = II(d, a, b, c, x[11], 10L, 3174756917L);
/* 277 */     c = II(c, d, a, b, x[2], 15L, 718787259L);
/* 278 */     b = II(b, c, d, a, x[9], 21L, 3951481745L);
/*     */ 
/* 280 */     this.state[0] += a;
/* 281 */     this.state[1] += b;
/* 282 */     this.state[2] += c;
/* 283 */     this.state[3] += d;
/*     */   }
/*     */ 
/*     */   private void Encode(byte[] output, long[] input, int len)
/*     */   {
/* 291 */     int i = 0; for (int j = 0; j < len; j += 4) {
/* 292 */       output[j] = (byte)(int)(input[i] & 0xFF);
/* 293 */       output[(j + 1)] = (byte)(int)(input[i] >>> 8 & 0xFF);
/* 294 */       output[(j + 2)] = (byte)(int)(input[i] >>> 16 & 0xFF);
/* 295 */       output[(j + 3)] = (byte)(int)(input[i] >>> 24 & 0xFF);
/*     */ 
/* 291 */       i++;
/*     */     }
/*     */   }
/*     */ 
/*     */   private void Decode(long[] output, byte[] input, int len)
/*     */   {
/* 303 */     int i = 0; for (int j = 0; j < len; j += 4) {
/* 304 */       output[i] = 
/* 307 */         (b2iu(input[j]) | 
/* 305 */         b2iu(input[(j + 1)]) << 8 | 
/* 306 */         b2iu(input[(j + 2)]) << 16 | 
/* 307 */         b2iu(input[(j + 3)]) << 24);
/*     */ 
/* 303 */       i++;
/*     */     }
/*     */   }
/*     */ 
/*     */   public static long b2iu(byte b)
/*     */   {
/* 314 */     return b < 0 ? b & 0xFF : b;
/*     */   }
/*     */ 
/*     */   public static String byteHEX(byte ib)
/*     */   {
/* 319 */     char[] Digit = { 
/* 320 */       '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
/* 321 */       'A', 'B', 'C', 'D', 'E', 'F' };
/* 322 */     char[] ob = new char[2];
/* 323 */     ob[0] = Digit[(ib >>> 4 & 0xF)];
/* 324 */     ob[1] = Digit[(ib & 0xF)];
/* 325 */     String s = new String(ob);
/* 326 */     return s;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.encrypt.MD5
 * JD-Core Version:    0.6.0
 */