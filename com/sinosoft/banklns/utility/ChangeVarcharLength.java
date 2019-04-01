/*     */ package com.sinosoft.banklns.utility;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileReader;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class ChangeVarcharLength
/*     */ {
/*  19 */   private String absolutePath = "D:";
/*     */ 
/*     */   public void executeVarchar()
/*     */   {
/*  46 */     File file = new File("aclcsug.ddl");
/*  47 */     deal(file);
/*     */   }
/*     */ 
/*     */   private void deal(File file)
/*     */   {
/*  54 */     String name = file.getName();
/*  55 */     String tempname = name + "~";
/*  56 */     File read = new File(this.absolutePath + "/" + name);
/*  57 */     File write = new File(this.absolutePath + "/" + tempname);
/*     */     try
/*     */     {
/*  60 */       BufferedReader br = new BufferedReader(new FileReader(read));
/*  61 */       BufferedWriter bw = new BufferedWriter(new FileWriter(write));
/*  62 */       String temp = null;
/*  63 */       temp = br.readLine();
/*  64 */       while (temp != null) {
/*  65 */         temp = changeLength(temp);
/*  66 */         bw.write(temp + "\n");
/*     */ 
/*  69 */         temp = br.readLine();
/*     */       }
/*  71 */       bw.close();
/*  72 */       br.close();
/*     */     }
/*     */     catch (FileNotFoundException e) {
/*  75 */       e.printStackTrace();
/*     */     }
/*     */     catch (IOException e) {
/*  78 */       e.printStackTrace();
/*     */     }
/*     */ 
/*  84 */     deleteFile(read);
/*     */ 
/*  87 */     renameForFile(write, name);
/*     */   }
/*     */ 
/*     */   private String changeLength(String varcharStr) {
/*  91 */     String str = varcharStr;
/*  92 */     String regEx = "VARCHAR\\([0-9]*\\)";
/*  93 */     Pattern p = Pattern.compile(regEx, 2);
/*  94 */     Matcher m = p.matcher(str);
/*  95 */     StringBuffer sb = new StringBuffer();
/*  96 */     while (m.find())
/*     */     {
/*  98 */       String temp = m.group();
/*  99 */       int start = temp.indexOf('(');
/* 100 */       int end = temp.indexOf(')');
/* 101 */       String numStr = temp.substring(start + 1, end);
/* 102 */       int num = Integer.parseInt(numStr);
/* 103 */       int result = (int)(num * 1.5D);
/* 104 */       if (result < num * 1.5D) {
/* 105 */         result++;
/*     */       }
/* 107 */       String reStr = "VARCHAR(" + result + ")";
/* 108 */       m.appendReplacement(sb, reStr);
/*     */     }
/* 110 */     m.appendTail(sb);
/* 111 */     String result = sb.toString();
/* 112 */     return result;
/*     */   }
/*     */ 
/*     */   private void renameForFile(File file, String newName) {
/* 116 */     file.renameTo(new File(this.absolutePath + "/" + newName));
/*     */   }
/*     */ 
/*     */   private void deleteFile(File file) {
/* 120 */     file.delete();
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 126 */     ChangeVarcharLength reChangeVarcharLength = new ChangeVarcharLength();
/* 127 */     reChangeVarcharLength.executeVarchar();
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.ChangeVarcharLength
 * JD-Core Version:    0.6.0
 */