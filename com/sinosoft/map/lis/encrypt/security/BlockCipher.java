/*     */ package com.sinosoft.map.lis.encrypt.security;
/*     */ 
/*     */ public abstract class BlockCipher
/*     */ {
/*     */   public final void encrypt(byte[] text)
/*     */   {
/*  14 */     encrypt(text, text);
/*     */   }
/*     */ 
/*     */   public final void decrypt(byte[] text)
/*     */   {
/*  21 */     decrypt(text, text);
/*     */   }
/*     */ 
/*     */   public final void encrypt(byte[] in, byte[] out)
/*     */   {
/*  28 */     int len = blockLength();
/*     */ 
/*  30 */     if ((in.length != len) || (out.length != len))
/*  31 */       throw new CryptoError(getClass().getName() + 
/*  32 */         ": encrypt buffers must be the same size as cipher length");
/*  33 */     encrypt(in, 0, out, 0);
/*     */   }
/*     */ 
/*     */   public final void decrypt(byte[] in, byte[] out)
/*     */   {
/*  40 */     int len = blockLength();
/*  41 */     if ((in.length != len) || (out.length != len))
/*  42 */       throw new CryptoError(getClass().getName() + 
/*  43 */         ": decrypt buffers must be the same size as cipher length");
/*  44 */     decrypt(in, 0, out, 0);
/*     */   }
/*     */ 
/*     */   public final void encrypt(byte[] in, int in_offset, byte[] out, int out_offset)
/*     */   {
/*  51 */     int blkLength = blockLength();
/*     */ 
/*  53 */     if ((in_offset < 0) || (out_offset < 0))
/*     */     {
/*  55 */       throw new ArrayIndexOutOfBoundsException(
/*  56 */         getClass().getName() + 
/*  57 */         ": Negative offset not allowed");
/*     */     }
/*     */ 
/*  60 */     if ((in_offset + blkLength > in.length) || 
/*  61 */       (out_offset + blkLength > out.length))
/*     */     {
/*  63 */       throw new ArrayIndexOutOfBoundsException(
/*  64 */         getClass().getName() + 
/*  65 */         ": Offset past end of array");
/*     */     }
/*     */ 
/*  75 */     blockEncrypt(in, in_offset, out, out_offset);
/*     */   }
/*     */ 
/*     */   public final void decrypt(byte[] in, int in_offset, byte[] out, int out_offset)
/*     */   {
/*  82 */     int blkLength = blockLength();
/*     */ 
/*  84 */     if ((in_offset < 0) || (out_offset < 0))
/*     */     {
/*  86 */       throw new ArrayIndexOutOfBoundsException(
/*  87 */         getClass().getName() + 
/*  88 */         ": Negative offset not allowed");
/*     */     }
/*     */ 
/*  91 */     if ((in_offset + blkLength > in.length) || 
/*  92 */       (out_offset + blkLength > out.length))
/*     */     {
/*  94 */       throw new ArrayIndexOutOfBoundsException(
/*  95 */         getClass().getName() + 
/*  96 */         ": Offset past end of array");
/*     */     }
/*     */ 
/* 104 */     blockDecrypt(in, in_offset, out, out_offset);
/*     */   }
/*     */ 
/*     */   protected abstract void blockEncrypt(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2);
/*     */ 
/*     */   protected abstract void blockDecrypt(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2);
/*     */ 
/*     */   public abstract int blockLength();
/*     */ 
/*     */   public abstract int keyLength();
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.encrypt.security.BlockCipher
 * JD-Core Version:    0.6.0
 */