/*    */ package com.sinosoft.map.utility;
/*    */ 
/*    */ import com.lowagie.text.Document;
/*    */ import com.lowagie.text.HeaderFooter;
/*    */ import com.lowagie.text.pdf.PdfWriter;
/*    */ import com.sinosoft.map.style.pdf.FileStyle;
/*    */ import com.sinosoft.map.style.pdf.FooterStyle;
/*    */ import java.io.PrintStream;
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class pdfToolMAP extends pdfTool
/*    */ {
/*    */   public boolean makeFile(String tFilePath, FileStyle fs)
/*    */   {
/* 25 */     Vector vctGetReData = makeFileHfFun(this.document, this.pdfWriter, tFilePath, fs);
/* 26 */     if (vctGetReData.size() != 2) {
/* 27 */       return false;
/*    */     }
/* 29 */     this.document = ((Document)vctGetReData.get(0));
/* 30 */     this.pdfWriter = ((PdfWriter)vctGetReData.get(1));
/* 31 */     return true;
/*    */   }
/*    */ 
/*    */   public boolean makeFooter(String content, FooterStyle fs)
/*    */   {
/*    */     try
/*    */     {
/* 40 */       if (!fs.isContinue()) {
/* 41 */         this.document.resetPageCount();
/*    */       }
/* 43 */       HeaderFooter footer = makeFooterFun(content, fs);
/* 44 */       this.document.setFooter(footer);
/* 45 */       System.out.println("yejiao success !");
/* 46 */       this.document.open();
/*    */     } catch (Exception ex) {
/* 48 */       System.err.println(ex.getMessage());
/* 49 */       return false;
/*    */     }
/* 51 */     return true;
/*    */   }
/*    */ 
/*    */   public pdfToolMAP() {
/*    */   }
/*    */ 
/*    */   public pdfToolMAP(String path) {
/* 58 */     this.path = path;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.pdfToolMAP
 * JD-Core Version:    0.6.0
 */