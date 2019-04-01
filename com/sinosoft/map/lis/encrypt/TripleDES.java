/*     */ package com.sinosoft.map.lis.encrypt;
/*     */ 
/*     */ import com.sinosoft.map.common.Constants;
/*     */ import com.sinosoft.map.lis.pubfun.PubFun;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.security.InvalidKeyException;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.security.spec.InvalidKeySpecException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.StringTokenizer;
/*     */ import javax.crypto.BadPaddingException;
/*     */ import javax.crypto.Cipher;
/*     */ import javax.crypto.IllegalBlockSizeException;
/*     */ import javax.crypto.KeyGenerator;
/*     */ import javax.crypto.NoSuchPaddingException;
/*     */ import javax.crypto.SecretKey;
/*     */ import javax.crypto.SecretKeyFactory;
/*     */ import javax.crypto.spec.DESedeKeySpec;
/*     */ 
/*     */ public class TripleDES
/*     */ {
/*  31 */   private String filePath = PubFun.getRealPath();
/*     */ 
/*  33 */   private File keyFile = new File(this.filePath + "/sysmanage/sinosoft_metlife_secretKey");
/*     */ 
/*  36 */   private SecretKey key = null;
/*     */ 
/*     */   public TripleDES()
/*     */   {
/*     */     try
/*     */     {
/*  42 */       this.key = Constants.key;
/*  43 */       if (this.key == null)
/*     */       {
/*  45 */         this.key = readKey();
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (NoSuchAlgorithmException e)
/*     */     {
/*  51 */       e.printStackTrace();
/*     */     }
/*     */     catch (InvalidKeySpecException e)
/*     */     {
/*  55 */       e.printStackTrace();
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/*  59 */       e.printStackTrace();
/*     */     }
/*     */     catch (InvalidKeyException e)
/*     */     {
/*  63 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   private SecretKey generateKey()
/*     */     throws NoSuchAlgorithmException
/*     */   {
/*  71 */     KeyGenerator keygen = KeyGenerator.getInstance("DESede");
/*  72 */     keygen.init(112);
/*     */ 
/*  74 */     return keygen.generateKey();
/*     */   }
/*     */ 
/*     */   private SecretKey readKey()
/*     */     throws IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException
/*     */   {
/*  83 */     DataInputStream in = new DataInputStream(new FileInputStream(this.keyFile));
/*  84 */     byte[] rawkey = new byte[(int)this.keyFile.length()];
/*  85 */     in.readFully(rawkey);
/*  86 */     in.close();
/*     */ 
/*  89 */     DESedeKeySpec keyspec = new DESedeKeySpec(rawkey);
/*  90 */     SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
/*  91 */     SecretKey key = keyfactory.generateSecret(keyspec);
/*  92 */     return key;
/*     */   }
/*     */ 
/*     */   public String encryptString(String password)
/*     */   {
/*  98 */     String encodedPassword = password;
/*     */     try
/*     */     {
/* 101 */       if ((password != null) && (!"".equals(password.trim())) && 
/* 102 */         (this.key != null))
/*     */       {
/* 105 */         Cipher cipher = Cipher.getInstance("DESede");
/* 106 */         cipher.init(1, this.key);
/* 107 */         byte[] cleartext = password.getBytes();
/* 108 */         byte[] ciphertext = cipher.doFinal(cleartext);
/* 109 */         StringBuffer buf = new StringBuffer();
/* 110 */         for (int i = 0; i < ciphertext.length; i++)
/*     */         {
/* 112 */           buf.append(Byte.toString(ciphertext[i]) + "%");
/*     */         }
/* 114 */         encodedPassword = buf.toString().replace("-", "$");
/*     */       }
/*     */     }
/*     */     catch (NoSuchAlgorithmException e)
/*     */     {
/* 119 */       e.printStackTrace();
/*     */     }
/*     */     catch (NoSuchPaddingException e)
/*     */     {
/* 123 */       e.printStackTrace();
/*     */     }
/*     */     catch (InvalidKeyException e)
/*     */     {
/* 127 */       e.printStackTrace();
/*     */     }
/*     */     catch (IllegalBlockSizeException e)
/*     */     {
/* 131 */       e.printStackTrace();
/*     */     }
/*     */     catch (BadPaddingException e)
/*     */     {
/* 135 */       e.printStackTrace();
/*     */     }
/* 137 */     return encodedPassword;
/*     */   }
/*     */ 
/*     */   public String decryptString_pre(String password)
/*     */   {
/* 143 */     String decodedPassword = null;
/* 144 */     if ((password != null) && (!"".equals(password.trim())) && 
/* 145 */       (this.key != null))
/*     */     {
/* 147 */       password = password.replace("$", "-");
/* 148 */       ArrayList list = new ArrayList();
/* 149 */       StringTokenizer toker = new StringTokenizer(password, "%");
/* 150 */       while (toker.hasMoreElements())
/*     */       {
/* 152 */         list.add(toker.nextToken());
/*     */       }
/* 154 */       byte[] cleartext = new byte[list.size()];
/* 155 */       int i = 0;
/* 156 */       for (Iterator iter = list.iterator(); iter.hasNext(); )
/*     */       {
/* 158 */         String element = (String)iter.next();
/* 159 */         cleartext[i] = Byte.parseByte(element);
/* 160 */         i++;
/*     */       }
/*     */ 
/*     */       try
/*     */       {
/* 166 */         Cipher cipher = Cipher.getInstance("DESede");
/* 167 */         cipher.init(2, this.key);
/* 168 */         byte[] ciphertext = cipher.doFinal(cleartext);
/* 169 */         decodedPassword = new String(ciphertext);
/*     */       }
/*     */       catch (NoSuchAlgorithmException e)
/*     */       {
/* 173 */         e.printStackTrace();
/*     */       }
/*     */       catch (NoSuchPaddingException e)
/*     */       {
/* 177 */         e.printStackTrace();
/*     */       }
/*     */       catch (InvalidKeyException e)
/*     */       {
/* 181 */         e.printStackTrace();
/*     */       }
/*     */       catch (IllegalBlockSizeException e)
/*     */       {
/* 185 */         e.printStackTrace();
/*     */       }
/*     */       catch (BadPaddingException e)
/*     */       {
/* 189 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 192 */     return decodedPassword;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 197 */     TripleDES tTripleDES = new TripleDES();
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.encrypt.TripleDES
 * JD-Core Version:    0.6.0
 */