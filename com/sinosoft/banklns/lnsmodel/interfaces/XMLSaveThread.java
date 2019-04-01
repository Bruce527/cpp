/*    */ package com.sinosoft.banklns.lnsmodel.interfaces;
/*    */ 
/*    */ import com.sinosoft.banklns.lis.pubfun.PubFun;
/*    */ import com.sinosoft.banklns.lnsmodel.util.EAIPropertiesFromDB;
/*    */ import java.io.File;
/*    */ import java.io.FileWriter;
/*    */ import java.io.PrintStream;
/*    */ import org.jdom.Document;
/*    */ import org.jdom.output.Format;
/*    */ import org.jdom.output.XMLOutputter;
/*    */ 
/*    */ public class XMLSaveThread extends Thread
/*    */ {
/* 16 */   private Document createdDoc = null;
/* 17 */   private String foldName = null;
/* 18 */   private String string = null;
/*    */ 
/*    */   public XMLSaveThread(Document createdDoc, String foldName, String string) {
/* 21 */     this.createdDoc = createdDoc;
/* 22 */     this.foldName = foldName;
/* 23 */     this.string = string;
/*    */   }
/*    */ 
/*    */   public void run() {
/*    */     try {
/* 28 */       System.out.println("~~~~~~~~~~~~~~~~~~thread start mdes~~");
/* 29 */       String fileName = this.foldName + this.string + PubFun.getCurrentDate().replace("-", "") + PubFun.getCurrentTime().replace(":", "") + ".xml";
/* 30 */       System.out.println("fileName1:" + fileName);
/*    */ 
/* 32 */       System.out.println("PubFun.getCurrentDate().replace(,):" + PubFun.getCurrentDate().replace("-", ""));
/* 33 */       System.out.println("foldName:" + this.foldName);
/* 34 */       System.out.println("EAIPropertiesFromDB.XMLSavePath:" + EAIPropertiesFromDB.XMLSavePath);
/*    */ 
/* 36 */       String savePath = EAIPropertiesFromDB.XMLSavePath + File.separator + this.foldName + File.separator + PubFun.getCurrentDate().replace("-", "") + File.separator;
/* 37 */       savePath = "C:/mdes_file_folder/lnp_tran" + File.separator + this.foldName + File.separator + PubFun.getCurrentDate().replace("-", "") + File.separator;
/* 38 */       System.out.println("savePath:" + savePath);
/*    */ 
/* 40 */       String saveFilePath = savePath + fileName;
/* 41 */       System.out.println("\u4FDD\u5B58\u63A5\u53E3\u7684XML\u6587\u4EF6\u8DEF\u5F84\u4E3A--------------------" + saveFilePath);
/* 42 */       File dirFile = new File(savePath);
/* 43 */       if (!dirFile.exists()) {
/* 44 */         dirFile.mkdir();
/*    */       }
/*    */ 
/* 47 */       XMLOutputter outputter = new XMLOutputter();
/* 48 */       outputter.setFormat(Format.getPrettyFormat().setEncoding("GBK"));
/* 49 */       outputter.output(this.createdDoc, new FileWriter(saveFilePath));
/* 50 */       System.out.println("\u4FDD\u5B58\u63A5\u53E3\u7684XML\u6587\u4EF6\u6210\u529F\uFF0C\u4FDD\u5B58\u8DEF\u5F84\u4E3A\uFF1A" + saveFilePath);
/*    */     } catch (Exception ex) {
/* 52 */       System.out.println("\u4FDD\u5B58\u63A5\u53E3\u7684XML\u6587\u4EF6\u53D1\u751F\u5F02\u5E38\uFF01" + ex.getLocalizedMessage());
/* 53 */       ex.printStackTrace();
/*    */     }
/* 55 */     System.out.println("thread end");
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.interfaces.XMLSaveThread
 * JD-Core Version:    0.6.0
 */