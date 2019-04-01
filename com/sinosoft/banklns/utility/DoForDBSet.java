/*    */ package com.sinosoft.banklns.utility;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.BufferedWriter;
/*    */ import java.io.File;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.FileReader;
/*    */ import java.io.FileWriter;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class DoForDBSet
/*    */ {
/* 17 */   private String absolutePath = "D:/Project/ACLife/src/com/sinosoft/lis/vdb";
/*    */ 
/*    */   private List getAllFile()
/*    */   {
/* 21 */     File file = new File(this.absolutePath);
/* 22 */     String[] filelist = file.list();
/* 23 */     List list = new ArrayList();
/* 24 */     for (int i = 0; i < filelist.length; i++) {
/* 25 */       File tempfile = new File(this.absolutePath + "/" + filelist[i]);
/* 26 */       System.out.println("\u951F\u65A4\u62F7\u951F\u8282\u8FBE\u62F7\u951F\u65A4\u62F7\u951F\u4FA5\u7877\u62F7: " + tempfile.getName() + "  ...............");
/* 27 */       if (tempfile.getName().indexOf(".java") > -1) {
/* 28 */         list.add(tempfile);
/*    */       }
/* 30 */       System.out.println("\u951F\u65A4\u62F7\u7EB1\u951F\u65A4\u62F7\u951F\uFFFD..........");
/*    */     }
/* 32 */     return list;
/*    */   }
/*    */ 
/*    */   public void execute() {
/* 36 */     List list = getAllFile();
/* 37 */     for (int i = 0; (list != null) && (i < list.size()); i++) {
/* 38 */       File fl = (File)list.get(i);
/* 39 */       deal(fl);
/*    */     }
/*    */   }
/*    */ 
/*    */   private void deal(File file)
/*    */   {
/* 45 */     String name = file.getName();
/* 46 */     String tempname = name + "~";
/* 47 */     File read = new File(this.absolutePath + "/" + name);
/* 48 */     File write = new File(this.absolutePath + "/" + tempname);
/*    */     try
/*    */     {
/* 51 */       BufferedReader br = new BufferedReader(new FileReader(read));
/* 52 */       BufferedWriter bw = new BufferedWriter(new FileWriter(write));
/* 53 */       String temp = null;
/* 54 */       temp = br.readLine();
/* 55 */       while (temp != null) {
/* 56 */         if (temp.indexOf("con = db.getConnection();") < 0)
/*    */         {
/* 60 */           bw.write(temp + "\n");
/*    */         }
/*    */ 
/* 64 */         temp = br.readLine();
/*    */       }
/* 66 */       bw.close();
/* 67 */       br.close();
/*    */     }
/*    */     catch (FileNotFoundException e) {
/* 70 */       e.printStackTrace();
/*    */     }
/*    */     catch (IOException e) {
/* 73 */       e.printStackTrace();
/*    */     }
/*    */ 
/* 77 */     deleteFile(file);
/*    */ 
/* 79 */     File tempFile = new File(this.absolutePath + "/" + tempname);
/* 80 */     renameForFile(tempFile, name);
/*    */   }
/*    */ 
/*    */   private void renameForFile(File file, String newName) {
/* 84 */     file.renameTo(new File(this.absolutePath + "/" + newName));
/*    */   }
/*    */ 
/*    */   private void deleteFile(File file) {
/* 88 */     file.delete();
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/* 94 */     DoForDBSet reDoForDBSet = new DoForDBSet();
/* 95 */     reDoForDBSet.execute();
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.DoForDBSet
 * JD-Core Version:    0.6.0
 */