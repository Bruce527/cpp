/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.Vector;
/*     */ 
/*     */ public class FileViewer
/*     */ {
/*     */   File myDir;
/*     */   File[] contents;
/*     */   Vector vectorList;
/*     */   Iterator currentFileView;
/*     */   File currentFile;
/*     */   String path;
/*     */ 
/*     */   public FileViewer()
/*     */   {
/*  23 */     this.path = new String("");
/*  24 */     this.vectorList = new Vector();
/*     */   }
/*     */ 
/*     */   public FileViewer(String path)
/*     */   {
/*  29 */     this.path = path;
/*  30 */     this.vectorList = new Vector();
/*     */   }
/*     */ 
/*     */   public void setPath(String path)
/*     */   {
/*  37 */     this.path = path;
/*     */   }
/*     */ 
/*     */   public String getDirectory()
/*     */   {
/*  44 */     return this.myDir.getPath();
/*     */   }
/*     */ 
/*     */   public void refreshList()
/*     */   {
/*  51 */     if (this.path.equals(""))
/*     */     {
/*  53 */       this.path = "c:\\";
/*     */     }
/*  55 */     this.myDir = new File(this.path);
/*     */ 
/*  57 */     this.vectorList.clear();
/*  58 */     this.contents = this.myDir.listFiles();
/*     */ 
/*  60 */     for (int i = 0; i < this.contents.length; i++)
/*     */     {
/*  62 */       this.vectorList.add(this.contents[i]);
/*     */     }
/*     */ 
/*  65 */     this.currentFileView = this.vectorList.iterator();
/*     */   }
/*     */ 
/*     */   public boolean nextFile()
/*     */   {
/*  72 */     if (this.currentFileView.hasNext())
/*     */     {
/*  74 */       this.currentFile = ((File)this.currentFileView.next());
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */ 
/*     */   public String getFileName()
/*     */   {
/*  84 */     return this.currentFile.getName();
/*     */   }
/*     */ 
/*     */   public String getFileSize()
/*     */   {
/*  91 */     return new Long(this.currentFile.length()).toString();
/*     */   }
/*     */ 
/*     */   public String getFileTimeStamp()
/*     */   {
/*  98 */     return new Date(this.currentFile.lastModified()).toString();
/*     */   }
/*     */ 
/*     */   public boolean getFileType()
/*     */   {
/* 105 */     return this.currentFile.isDirectory();
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.FileViewer
 * JD-Core Version:    0.6.0
 */