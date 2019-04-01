/*     */ package com.sinosoft.banklns.lnsmodel.webservice;
/*     */ 
/*     */ import java.io.CharArrayReader;
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public class XMLEncoder
/*     */ {
/*     */   public static final int ENCODE_QUOT = 1;
/*  14 */   public static int ENCODE_128 = 2;
/*     */   private String Version;
/*     */ 
/*     */   public String getVersion()
/*     */   {
/*  24 */     return this.Version;
/*     */   }
/*     */ 
/*     */   public static String toDecode(String toConvert)
/*     */   {
/*  29 */     String aux = null;
/*  30 */     String aux2 = null;
/*  31 */     if (toConvert != null)
/*     */     {
/*  33 */       toConvert = toConvert.trim();
/*  34 */       StringBuffer buffer = new StringBuffer();
/*     */       try
/*     */       {
/*  39 */         while (toConvert.length() > 0)
/*     */         {
/*  41 */           aux = toConvert.substring(0, 1);
/*  42 */           if (toConvert.length() > 1)
/*  43 */             aux2 = toConvert.substring(1, 2);
/*  44 */           if ((!"%u".equals(aux + aux2)) || (toConvert.length() < 6))
/*     */           {
/*  46 */             buffer.append(toConvert.substring(toConvert.indexOf(aux), 1));
/*  47 */             toConvert = toConvert.substring(toConvert.indexOf(aux) + 1, toConvert.length());
/*  48 */             continue;
/*     */           }
/*  50 */           int ind = toConvert.indexOf("%");
/*  51 */           int ind2 = toConvert.indexOf("u", ind);
/*  52 */           if (ind2 < 1) {
/*  53 */             buffer.append(toConvert.substring(0, ind2 + 1)); continue;
/*     */           }
/*     */           try
/*     */           {
/*  57 */             ind2 = ind2 != 1 ? ind + 3 : ind + 6;
/*  58 */             String carac = toConvert.substring(ind + 1, ind2).replace('u', ' ').trim();
/*  59 */             carac = carac.equals("3000") ? "0020" : carac;
/*  60 */             if (carac.trim().length() < 4)
/*  61 */               throw new NumberFormatException();
/*  62 */             char c = (char)Integer.parseInt(carac, 16);
/*  63 */             toConvert = toConvert.substring(ind2, toConvert.length());
/*  64 */             buffer.append(c);
/*  65 */             ind = toConvert.indexOf("%");
/*  66 */             if (ind <= 0)
/*     */               continue;
/*  68 */             buffer.append(toConvert.substring(0, ind));
/*  69 */             toConvert = toConvert.substring(ind, toConvert.length());
/*  70 */             ind = toConvert.indexOf("%");
/*     */           }
/*     */           catch (NumberFormatException e)
/*     */           {
/*  75 */             buffer.append(toConvert.substring(toConvert.indexOf(aux), 1));
/*  76 */             toConvert = toConvert.substring(toConvert.indexOf(aux) + 1, toConvert.length());
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/*  83 */         e.printStackTrace();
/*     */       }
/*  85 */       return buffer.toString().trim();
/*     */     }
/*     */ 
/*  88 */     return null;
/*     */   }
/*     */ 
/*     */   public static String toUnicode(String toConvert)
/*     */   {
/*  94 */     if (toConvert != null)
/*     */     {
/*  97 */       StringBuffer buffer = new StringBuffer();
/*     */       try {
/*  99 */         CharArrayReader in = new CharArrayReader(toConvert.toCharArray());
/*     */         int ch;
/* 101 */         while ((ch = in.read()) > -1)
/*     */         {
/*     */           int ch;
/* 102 */           String hex = Integer.toHexString(ch);
/* 103 */           if (hex.length() == 4) {
/* 104 */             hex = hex.equals("3000") ? "0020" : hex;
/* 105 */             buffer.append("%u" + hex);
/*     */           }
/*     */           else
/*     */           {
/* 109 */             buffer.append((char)ch);
/*     */           }
/*     */         }
/* 112 */         in.close();
/*     */       } catch (Exception e) {
/* 114 */         System.out.println("TMAEncoder - TMAEncoder.toUnicode - Error: " + e.getMessage());
/*     */       }
/* 116 */       String converted = buffer.toString();
/*     */ 
/* 118 */       return converted;
/*     */     }
/* 120 */     return null;
/*     */   }
/*     */ 
/*     */   public static String XMLencode(String raw, int flags)
/*     */   {
/* 126 */     int len = raw.length();
/* 127 */     StringBuffer cooked = new StringBuffer(raw.length());
/* 128 */     for (int i = 0; i < len; i++)
/*     */     {
/* 130 */       char c = raw.charAt(i);
/* 131 */       switch (c)
/*     */       {
/*     */       case '<':
/* 134 */         cooked.append("&lt;");
/* 135 */         break;
/*     */       case '>':
/* 138 */         cooked.append("&gt;");
/* 139 */         break;
/*     */       case '&':
/* 142 */         cooked.append("&amp;");
/* 143 */         break;
/*     */       case '\'':
/* 146 */         cooked.append("&apos;");
/* 147 */         break;
/*     */       case '"':
/* 150 */         if ((flags & 0x1) != 0)
/* 151 */           cooked.append("&quot;");
/*     */         else
/* 153 */           cooked.append('"');
/* 154 */         break;
/*     */       default:
/* 157 */         if ((c >= '\u0080') && ((flags & ENCODE_128) != 0))
/* 158 */           cooked.append("&#" + c + ";");
/*     */         else {
/* 160 */           cooked.append(c);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 165 */     return cooked.toString();
/*     */   }
/*     */ 
/*     */   public static String XMLDecode(String raw, int flags)
/*     */   {
/* 170 */     int len = raw.length();
/* 171 */     StringBuffer cooked = new StringBuffer(raw.length());
/* 172 */     for (int i = 0; i < len; i++)
/*     */     {
/* 174 */       char c = raw.charAt(i);
/* 175 */       switch (c)
/*     */       {
/*     */       case '<':
/* 178 */         cooked.append("&lt;");
/* 179 */         break;
/*     */       case '>':
/* 182 */         cooked.append("&gt;");
/* 183 */         break;
/*     */       case '&':
/* 186 */         cooked.append("&amp;");
/* 187 */         break;
/*     */       case '\'':
/* 190 */         cooked.append("&apos;");
/* 191 */         break;
/*     */       case '"':
/* 194 */         if ((flags & 0x1) != 0)
/* 195 */           cooked.append("&quot;");
/*     */         else
/* 197 */           cooked.append('"');
/* 198 */         break;
/*     */       default:
/* 201 */         if ((c >= '\u0080') && ((flags & ENCODE_128) != 0))
/* 202 */           cooked.append("&#" + c + ";");
/*     */         else {
/* 204 */           cooked.append(c);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 209 */     return cooked.toString();
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.webservice.XMLEncoder
 * JD-Core Version:    0.6.0
 */