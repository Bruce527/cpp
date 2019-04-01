/*      */ package com.sinosoft.map.utility;
/*      */ 
/*      */ import com.lowagie.text.BadElementException;
/*      */ import com.lowagie.text.Cell;
/*      */ import com.lowagie.text.Chunk;
/*      */ import com.lowagie.text.Document;
/*      */ import com.lowagie.text.DocumentException;
/*      */ import com.lowagie.text.Font;
/*      */ import com.lowagie.text.HeaderFooter;
/*      */ import com.lowagie.text.Image;
/*      */ import com.lowagie.text.PageSize;
/*      */ import com.lowagie.text.Paragraph;
/*      */ import com.lowagie.text.Phrase;
/*      */ import com.lowagie.text.Rectangle;
/*      */ import com.lowagie.text.Table;
/*      */ import com.lowagie.text.pdf.BaseFont;
/*      */ import com.lowagie.text.pdf.PdfContentByte;
/*      */ import com.lowagie.text.pdf.PdfPCell;
/*      */ import com.lowagie.text.pdf.PdfPTable;
/*      */ import com.lowagie.text.pdf.PdfPageEventHelper;
/*      */ import com.lowagie.text.pdf.PdfTemplate;
/*      */ import com.lowagie.text.pdf.PdfWriter;
/*      */ import com.sinosoft.map.style.pdf.FileStyle;
/*      */ import com.sinosoft.map.style.pdf.FontStyle;
/*      */ import com.sinosoft.map.style.pdf.FooterStyle;
/*      */ import com.sinosoft.map.style.pdf.HeaderStyle;
/*      */ import com.sinosoft.map.style.pdf.ImageStyle;
/*      */ import com.sinosoft.map.style.pdf.TableBodyStyle;
/*      */ import com.sinosoft.map.style.pdf.TableHeadStyle;
/*      */ import com.sinosoft.map.style.pdf.TextStyle;
/*      */ import com.sinosoft.map.style.pdf.TitleStyle;
/*      */ import java.awt.Color;
/*      */ import java.io.File;
/*      */ import java.io.FileOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.PrintStream;
/*      */ import java.net.MalformedURLException;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Vector;
/*      */ import org.apache.log4j.Logger;
/*      */ 
/*      */ public class PdfToolFun extends PdfPageEventHelper
/*      */ {
/*   31 */   private static final Logger logger = Logger.getLogger(pdfTool.class);
/*      */   public static final int TYPE_FILE = 0;
/*      */   public static final int TYPE_HEADER = 1;
/*      */   public static final int TYPE_FOOTER = 2;
/*      */   public static final int TYPE_IMAGE = 6;
/*      */   public static final int TYPE_TEXT = 5;
/*      */   public static final int TYPE_TITLE = 4;
/*      */   public static final int TYPE_NEWPAGE = 3;
/*      */   public static final int TYPE_TABLEHEAD = 7;
/*      */   public static final int TYPE_TABLEBODY = 8;
/*   52 */   private int recoverNum = 10000;
/*   53 */   private int recoverA4Num = 10000;
/*   54 */   private int printNums = 0;
/*   55 */   protected String path = "";
/*      */   public PdfTemplate tpl;
/*      */   public BaseFont helv;
/*   63 */   protected HashMap hsmTitleUnitRow = new HashMap();
/*      */ 
/*      */   public Vector makeFileFun(Document document, PdfWriter pdfWriter, String tFilePath, FileStyle fs)
/*      */   {
/*   73 */     Vector vetData = new Vector();
/*      */     try {
/*   75 */       document = new Document();
/*   76 */       document.setMargins(fs.getMarginLeft(), fs.getMarginRight(), fs
/*   77 */         .getMarginTop(), fs.getMarginBottom());
/*   78 */       document.setPageSize(fs.getPageSize());
/*      */ 
/*   80 */       File file = new File(tFilePath);
/*   81 */       pdfWriter = PdfWriter.getInstance(document, 
/*   82 */         new FileOutputStream(file));
/*      */ 
/*   84 */       BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", 
/*   85 */         "UniGB-UCS2-H", false);
/*   86 */       Font pageNumFont = new Font(bfChinese, 9.0F, 0);
/*      */ 
/*   90 */       if (!fs.isHeaderOrFooterInFirstPage())
/*      */       {
/*   93 */         pdfWriter.setPageEvent(this);
/*   94 */         document.open();
/*      */       }
/*      */ 
/*   97 */       document.open();
/*   98 */       vetData.add(document);
/*   99 */       vetData.add(pdfWriter);
/*      */     } catch (DocumentException de) {
/*  101 */       logger
/*  102 */         .error("makeFile(String, FileStyle) - " + de.getMessage(), 
/*  103 */         de);
/*  104 */       return null;
/*      */     } catch (IOException ioe) {
/*  106 */       logger.error("makeFile(String, FileStyle) - " + ioe.getMessage(), 
/*  107 */         ioe);
/*  108 */       return null;
/*      */     }
/*      */ 
/*  111 */     return vetData;
/*      */   }
/*      */ 
/*      */   public Vector makeFileFun(Document document, PdfWriter pdfWriter, String tFilePath, FileStyle fs, boolean needA4rotate)
/*      */   {
/*  116 */     Vector vetData = new Vector();
/*      */     try {
/*  118 */       document = new Document();
/*  119 */       document.setMargins(fs.getMarginLeft(), fs.getMarginRight(), fs
/*  120 */         .getMarginTop(), fs.getMarginBottom());
/*      */ 
/*  122 */       document.setPageSize(fs.getPageSize());
/*  123 */       if (needA4rotate) {
/*  124 */         document.setPageSize(PageSize.A4.rotate());
/*      */       }
/*      */ 
/*  127 */       File file = new File(tFilePath);
/*  128 */       pdfWriter = PdfWriter.getInstance(document, 
/*  129 */         new FileOutputStream(file));
/*      */ 
/*  131 */       BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", 
/*  132 */         "UniGB-UCS2-H", false);
/*  133 */       Font pageNumFont = new Font(bfChinese, 9.0F, 0);
/*      */ 
/*  137 */       if (!fs.isHeaderOrFooterInFirstPage())
/*      */       {
/*  140 */         pdfWriter.setPageEvent(this);
/*  141 */         document.open();
/*      */       }
/*      */ 
/*  145 */       vetData.add(document);
/*  146 */       vetData.add(pdfWriter);
/*      */     } catch (DocumentException de) {
/*  148 */       logger
/*  149 */         .error("makeFile(String, FileStyle) - " + de.getMessage(), 
/*  150 */         de);
/*  151 */       return null;
/*      */     } catch (IOException ioe) {
/*  153 */       logger.error("makeFile(String, FileStyle) - " + ioe.getMessage(), 
/*  154 */         ioe);
/*  155 */       return null;
/*      */     }
/*      */ 
/*  158 */     return vetData;
/*      */   }
/*      */ 
/*      */   public Vector makeFileHfFun(Document document, PdfWriter pdfWriter, String tFilePath, FileStyle fs)
/*      */   {
/*  165 */     Vector vctReData = new Vector();
/*      */     try {
/*  167 */       document = new Document();
/*  168 */       document.setMargins(fs.getMarginLeft(), fs.getMarginRight(), fs
/*  169 */         .getMarginTop(), fs.getMarginBottom());
/*  170 */       document.setPageSize(fs.getPageSize());
/*      */ 
/*  173 */       pdfWriter = PdfWriter.getInstance(document, 
/*  174 */         new FileOutputStream(tFilePath));
/*      */ 
/*  179 */       vctReData.add(document);
/*  180 */       vctReData.add(pdfWriter);
/*      */     } catch (DocumentException de) {
/*  182 */       logger.error(
/*  183 */         "makeFileHfFun(Document, PdfWriter, String, FileStyle) - " + 
/*  184 */         de.getMessage(), de);
/*  185 */       return null;
/*      */     } catch (IOException ioe) {
/*  187 */       logger.error(
/*  188 */         "makeFileHfFun(Document, PdfWriter, String, FileStyle) - " + 
/*  189 */         ioe.getMessage(), ioe);
/*  190 */       return null;
/*      */     }
/*      */ 
/*  193 */     return vctReData;
/*      */   }
/*      */ 
/*      */   protected boolean makeCloseFun(Document document)
/*      */   {
/*  198 */     document.close();
/*  199 */     return true;
/*      */   }
/*      */ 
/*      */   protected Font getFontChineseFun(FontStyle fs)
/*      */   {
/*      */     try {
/*  205 */       BaseFont bfChinese = getBaseFontFun(fs);
/*      */ 
/*  207 */       Font FontChinese = new Font(bfChinese, fs.getSize(), fs.getStyle(), 
/*  208 */         fs.getColor());
/*      */ 
/*  210 */       return FontChinese;
/*      */     } catch (Exception ex) {
/*  212 */       logger.error("getFontChinese(FontStyle) - " + ex.getMessage(), ex);
/*      */     }
/*  214 */     return null;
/*      */   }
/*      */ 
/*      */   protected BaseFont getBaseFontFun(FontStyle fs)
/*      */   {
/*      */     try {
/*  220 */       BaseFont bfChinese = BaseFont.createFont(this.path + "conf/Font/simkai.ttf", 
/*  221 */         "Identity-H", false);
/*  222 */       switch (fs.getFontName()) {
/*      */       case 1:
/*  224 */         bfChinese = BaseFont.createFont(this.path + "conf/Font/simkai.ttf", 
/*  225 */           "Identity-H", false);
/*  226 */         break;
/*      */       case 2:
/*  229 */         bfChinese = BaseFont.createFont(this.path + "conf/Font/simkai.ttf", 
/*  230 */           "Identity-H", false);
/*  231 */         break;
/*      */       case 3:
/*  234 */         bfChinese = BaseFont.createFont(this.path + "conf/Font/simhei.ttf", 
/*  235 */           "Identity-H", false);
/*  236 */         break;
/*      */       case 4:
/*  239 */         bfChinese = BaseFont.createFont(this.path + "conf/Font/arial.ttf", 
/*  240 */           "Cp1252", false);
/*  241 */         break;
/*      */       case 5:
/*  244 */         bfChinese = BaseFont.createFont(this.path + "conf/Font/arialbd.ttf", 
/*  245 */           "Cp1252", false);
/*  246 */         break;
/*      */       case 6:
/*  249 */         bfChinese = BaseFont.createFont(this.path + "conf/Font/ariali.ttf", 
/*  250 */           "Cp1252", false);
/*  251 */         break;
/*      */       case 7:
/*  254 */         bfChinese = BaseFont.createFont(this.path + "conf/Font/arialbi.ttf", 
/*  255 */           "Cp1252", false);
/*  256 */         break;
/*      */       case 8:
/*  259 */         bfChinese = BaseFont.createFont(this.path + "conf/Font/tahoma.ttf", 
/*  260 */           "Cp1252", false);
/*  261 */         break;
/*      */       }
/*      */ 
/*  267 */       return bfChinese;
/*      */     } catch (Exception ex) {
/*  269 */       logger.error("getBaseFont(FontStyle) - " + ex.getMessage(), ex);
/*      */     }
/*  271 */     return null;
/*      */   }
/*      */ 
/*      */   public Paragraph makeTextFun(String tContent, TextStyle ts)
/*      */   {
/*  276 */     tContent = StrTool.replaceEx(tContent, "<br>", "\n");
/*  277 */     Paragraph paragraph = new Paragraph(ts.getLeading(), tContent, 
/*  278 */       getFontChineseFun(ts));
/*  279 */     paragraph.setAlignment(ts.getAlign());
/*      */ 
/*  281 */     return paragraph;
/*      */   }
/*      */ 
/*      */   public boolean makeTitleFun(PdfWriter pdfWriter, String title, TitleStyle ts)
/*      */   {
/*  289 */     String[] titles = title.split("<br>");
/*      */ 
/*  291 */     PdfContentByte cb = pdfWriter.getDirectContent();
/*      */     try {
/*  293 */       cb.beginText();
/*  294 */       cb.setFontAndSize(getBaseFontFun(ts), ts.getSize());
/*  295 */       float step = 5.0F;
/*  296 */       for (int i = 0; i < titles.length; i++) {
/*  297 */         cb.showTextAligned(ts.getAlign(), titles[i], 
/*  298 */           ts.getPx() * 72.0F / 25.4F, 
/*  299 */           (ts.getPy() - step * i) * 72.0F / 25.4F, 0.0F);
/*      */       }
/*  301 */       cb.endText();
/*      */     } catch (Exception ex) {
/*  303 */       logger.error("makeTitle(String, TitleStyle) - " + ex.getMessage(), 
/*  304 */         ex);
/*  305 */       return false;
/*      */     }
/*      */ 
/*  308 */     return true;
/*      */   }
/*      */ 
/*      */   public Image makeImageFun(String path, ImageStyle is)
/*      */   {
/*  313 */     Image image = null;
/*  314 */     File file = new File(path);
/*  315 */     if (file.exists()) {
/*      */       try {
/*  317 */         image = Image.getInstance(path);
/*      */       }
/*      */       catch (BadElementException e) {
/*  320 */         logger.error("makeImageFun(String, ImageStyle)", e);
/*      */       }
/*      */       catch (MalformedURLException e) {
/*  323 */         logger.error("makeImageFun(String, ImageStyle)", e);
/*      */       }
/*      */       catch (IOException e) {
/*  326 */         logger.error("makeImageFun(String, ImageStyle)", e);
/*      */       }
/*  328 */       image.setAlignment(is.getAlign());
/*  329 */       image.scalePercent(is.getScalePercent());
/*      */ 
/*  331 */       if (is.getAbsolute()) {
/*  332 */         image.setAbsolutePosition(is.getPx(), is.getPy());
/*      */       }
/*      */     }
/*  335 */     return image;
/*      */   }
/*      */ 
/*      */   public Table makeTableHeadFun(Table table, String[] colNames, TableHeadStyle ths)
/*      */   {
/*      */     try
/*      */     {
/*  342 */       int col = ths.getCol();
/*  343 */       table = new Table(col);
/*  344 */       table.setBorderWidth(ths.getBorder());
/*  345 */       table.setWidth(ths.getWidth());
/*      */ 
/*  347 */       if (ths.getWidths() != null) {
/*  348 */         table.setWidths(ths.getWidths());
/*      */       }
/*  350 */       table.setBorderColor(ths.getColor());
/*  351 */       table.setPadding(ths.getPadding());
/*  352 */       table.setSpacing(ths.getSpacing());
/*  353 */       Font font = getFontChineseFun(ths);
/*  354 */       for (int i = 0; i < col; i++) {
/*  355 */         Phrase phrase = new Phrase(colNames[i], font);
/*  356 */         Cell cell = new Cell(phrase);
/*  357 */         cell.setHorizontalAlignment(ths.getAlign());
/*  358 */         cell.setBorder(ths.getBorder());
/*  359 */         cell.setBackgroundColor(
/*  360 */           new Color(ths.getR(), ths.getG(), ths
/*  360 */           .getB()));
/*  361 */         table.addCell(cell);
/*      */       }
/*  363 */       table.endHeaders();
/*      */     } catch (Exception ex) {
/*  365 */       logger.error("makeTableHead(String[], TableHeadStyle) - " + 
/*  366 */         ex.getMessage(), ex);
/*  367 */       logger.error("makeTableHeadFun(Table, String[], TableHeadStyle)", 
/*  368 */         ex);
/*      */     }
/*  370 */     return table;
/*      */   }
/*      */ 
/*      */   public PdfPTable makePdfPTableHeadFun(String[] colNames, TableHeadStyle ths) {
/*  374 */     PdfPTable pdfpTable = null;
/*      */     try {
/*  376 */       int col = ths.getCol();
/*  377 */       pdfpTable = new PdfPTable(col);
/*  378 */       if (ths.getWidths() != null) {
/*  379 */         pdfpTable.setWidths(ths.getWidths());
/*      */       }
/*  381 */       pdfpTable.setWidthPercentage(ths.getWidth());
/*  382 */       pdfpTable.setHorizontalAlignment(ths.getTableAlign());
/*  383 */       pdfpTable.setSpacingBefore(ths.getPadding());
/*  384 */       pdfpTable.setSpacingAfter(ths.getPadding());
/*  385 */       Font font = getFontChineseFun(ths);
/*      */ 
/*  387 */       for (int i = 0; i < col; i++) {
/*  388 */         Phrase phrase = new Phrase(colNames[i], font);
/*  389 */         PdfPCell pdfpCell = new PdfPCell(phrase);
/*  390 */         pdfpCell.setHorizontalAlignment(ths.getAlign());
/*  391 */         pdfpCell.setVerticalAlignment(1);
/*  392 */         pdfpCell.setBorder(ths.getBorder());
/*  393 */         pdfpCell.setBackgroundColor(
/*  394 */           new Color(ths.getR(), ths.getG(), 
/*  394 */           ths.getB()));
/*  395 */         pdfpTable.addCell(pdfpCell);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  409 */       logger.error("makePdfPTableHeadFun(String[], TableHeadStyle)", ex);
/*      */     }
/*  411 */     return pdfpTable;
/*      */   }
/*      */ 
/*      */   public Table makeTableHeadFun(List headers, TableHeadStyle ths)
/*      */   {
/*      */     try {
/*  417 */       int col = ths.getCol();
/*  418 */       Table table = new Table(col);
/*  419 */       table.setBorderWidth(ths.getBorder());
/*  420 */       table.setBorder(0);
/*  421 */       table.setWidth(ths.getWidth());
/*  422 */       table.setWidths(ths.getWidths());
/*  423 */       table.setPadding(ths.getPadding());
/*  424 */       table.setSpacing(ths.getSpacing());
/*  425 */       table.setAlignment(ths.getTableAlign());
/*  426 */       Font font = getFontChineseFun(ths);
/*  427 */       Cell cell = null;
/*  428 */       for (int i = 0; i < headers.size(); i++) {
/*  429 */         cell = getHeaderToCell((Header)headers.get(i), cell, 
/*  430 */           font, ths);
/*  431 */         table.addCell(cell);
/*      */       }
/*  433 */       table.endHeaders();
/*      */     } catch (Exception ex) {
/*  435 */       logger.error("makeTableHead(List, TableHeadStyle) - " + 
/*  436 */         ex.getMessage(), ex);
/*  437 */       logger.error("makeTableHeadFun(List, TableHeadStyle)", ex);
/*  438 */       return null;
/*      */     }
/*      */     Table table;
/*  440 */     return table;
/*      */   }
/*      */ 
/*      */   public PdfPTable makePdfPTableHeadFun(List headers, TableHeadStyle ths)
/*      */   {
/*  445 */     PdfPTable table = new PdfPTable(ths.getCol());
/*      */     try {
/*  447 */       table.setWidthPercentage(ths.getWidth());
/*  448 */       table.setWidths(ths.getWidths());
/*  449 */       table.setSpacingBefore(ths.getPadding());
/*  450 */       table.setSpacingAfter(ths.getPadding());
/*  451 */       Font font = getFontChineseFun(ths);
/*  452 */       PdfPCell pdfpcell = null;
/*  453 */       XmlTable xmlTable = null;
/*  454 */       PdfPTable tableElement = null;
/*  455 */       for (int i = 0; i < headers.size(); i++) {
/*  456 */         if (headers.get(i).getClass().getSimpleName().equals("Header")) {
/*  457 */           pdfpcell = getHeaderToPdfPCell(
/*  458 */             (Header)headers.get(i), font, ths);
/*  459 */           table.addCell(pdfpcell);
/*      */         } else {
/*  461 */           xmlTable = (XmlTable)headers.get(i);
/*  462 */           tableElement = makePdfPTableFun(xmlTable.getHeaders(), 
/*  463 */             xmlTable.getTableHeadStyle(), ths);
/*  464 */           pdfpcell = getHeaderToTable(tableElement, font, ths);
/*  465 */           table.addCell(pdfpcell);
/*      */         }
/*      */       }
/*  468 */       table.setHeadersInEvent(true);
/*  469 */       table.setHeaderRows(table.size());
/*      */     } catch (Exception ex) {
/*  471 */       logger.error("makeTableHead(List, TableHeadStyle) - " + 
/*  472 */         ex.getMessage(), ex);
/*  473 */       logger.error("makePdfPTableHeadFun(List, TableHeadStyle)", ex);
/*  474 */       return null;
/*      */     }
/*  476 */     return table;
/*      */   }
/*      */ 
/*      */   public PdfPTable makePdfPTableFun(List headers, TableHeadStyle ths, TableHeadStyle thstwo)
/*      */   {
/*  481 */     PdfPTable pdfPTable = null;
/*  482 */     int col = ths.getCol();
/*  483 */     pdfPTable = new PdfPTable(col);
/*  484 */     pdfPTable.setWidthPercentage(ths.getWidth());
/*      */     try
/*      */     {
/*  487 */       pdfPTable.setWidths(ths.getWidths());
/*      */     }
/*      */     catch (DocumentException e) {
/*  490 */       logger
/*  491 */         .error(
/*  492 */         "makePdfPTableFun(List, TableHeadStyle, TableHeadStyle)", 
/*  493 */         e);
/*      */     }
/*      */     try {
/*  496 */       Font font = getFontChineseFun(thstwo);
/*      */ 
/*  498 */       for (int i = 0; i < headers.size(); i++) {
/*  499 */         PdfPCell pdfPCell = getHeaderToPdfPCell(
/*  500 */           (Header)headers.get(i), font, ths);
/*  501 */         pdfPTable.addCell(pdfPCell);
/*      */       }
/*      */     } catch (Exception ex) {
/*  504 */       logger.error("makeTableHead(List, TableHeadStyle) - " + 
/*  505 */         ex.getMessage(), ex);
/*  506 */       logger.error(
/*  507 */         "makePdfPTableFun(List, TableHeadStyle, TableHeadStyle)", 
/*  508 */         ex);
/*  509 */       return null;
/*      */     }
/*  511 */     return pdfPTable;
/*      */   }
/*      */ 
/*      */   private Cell getHeaderToCell(Header header, Cell cell, Font font, TableHeadStyle ths)
/*      */   {
/*  517 */     if (cell == null)
/*  518 */       cell = new Cell();
/*      */     try
/*      */     {
/*  521 */       cell = new Cell(new Phrase(header.getName(), font));
/*      */     }
/*      */     catch (BadElementException e) {
/*  524 */       throw new RuntimeException("headrtocell\u8F6C\u6362\u9519\u8BEF", e);
/*      */     }
/*  526 */     cell.setHorizontalAlignment(ths.getAlign());
/*  527 */     cell.setVerticalAlignment(0);
/*  528 */     cell.setBackgroundColor(new Color(ths.getR(), ths.getG(), ths.getB()));
/*  529 */     if (header.getRow() > 1) {
/*  530 */       cell.setRowspan(header.getRow());
/*      */     }
/*  532 */     if (header.getCol() > 1) {
/*  533 */       cell.setColspan(header.getCol());
/*      */     }
/*  535 */     return cell;
/*      */   }
/*      */ 
/*      */   private PdfPCell getHeaderToPdfPCell(Header header, Font font, TableHeadStyle ths)
/*      */   {
/*  542 */     PdfPCell cell = new PdfPCell(new Phrase(header.getName(), font));
/*  543 */     cell.setHorizontalAlignment(ths.getAlign());
/*  544 */     cell.setVerticalAlignment(5);
/*      */ 
/*  546 */     cell.setBackgroundColor(new Color(ths.getR(), ths.getG(), ths.getB()));
/*  547 */     if (header.getCol() > 1) {
/*  548 */       cell.setColspan(header.getCol());
/*      */     }
/*  550 */     return cell;
/*      */   }
/*      */ 
/*      */   private Cell getHeaderToTable(Table table, Font font, TableHeadStyle ths)
/*      */   {
/*  556 */     Cell cell = null;
/*      */     try {
/*  558 */       cell = new Cell(table);
/*      */     }
/*      */     catch (BadElementException e) {
/*  561 */       throw new RuntimeException("headrtocell\u8F6C\u6362\u9519\u8BEF", e);
/*      */     }
/*  563 */     cell.setHorizontalAlignment(ths.getAlign());
/*  564 */     cell.setVerticalAlignment(0);
/*  565 */     cell.setBackgroundColor(new Color(ths.getR(), ths.getG(), ths.getB()));
/*  566 */     if (table.size() > 1) {
/*  567 */       cell.setRowspan(table.size());
/*      */     }
/*  569 */     if (logger.isDebugEnabled()) {
/*  570 */       logger.debug("getHeaderToTable(Table, Font, TableHeadStyle) - " + 
/*  571 */         table.size() + "table.size()");
/*      */     }
/*  573 */     if (table.getColumns() > 1) {
/*  574 */       cell.setColspan(table.getColumns());
/*      */     }
/*  576 */     if (logger.isDebugEnabled()) {
/*  577 */       logger.debug("getHeaderToTable(Table, Font, TableHeadStyle) - " + 
/*  578 */         table.getColumns() + "table.columns()");
/*      */     }
/*  580 */     return cell;
/*      */   }
/*      */ 
/*      */   private PdfPCell getHeaderToTable(PdfPTable table, Font font, TableHeadStyle ths)
/*      */   {
/*  585 */     PdfPCell cell = null;
/*      */ 
/*  587 */     cell = new PdfPCell(table);
/*      */ 
/*  589 */     cell.setPaddingBottom(0.0F);
/*  590 */     cell.setPaddingTop(0.0F);
/*  591 */     cell.setPadding(0.0F);
/*  592 */     cell.setHorizontalAlignment(ths.getAlign());
/*  593 */     cell.setBackgroundColor(new Color(ths.getR(), ths.getG(), ths.getB()));
/*  594 */     if (table.getAbsoluteWidths().length > 1) {
/*  595 */       cell.setColspan(table.getAbsoluteWidths().length);
/*      */     }
/*  597 */     return cell;
/*      */   }
/*      */ 
/*      */   public PdfPTable makeTableBodyFun(PdfPTable table, SSRS tSSRS, TableBodyStyle tbs)
/*      */   {
/*      */     try {
/*  603 */       Font font = getFontChineseFun(tbs);
/*      */ 
/*  605 */       int Align = tbs.getAlign();
/*      */ 
/*  607 */       for (int j = 1; j <= tSSRS.getMaxRow(); j++) {
/*  608 */         for (int i = 1; i <= tSSRS.getMaxCol(); i++)
/*      */         {
/*  610 */           Phrase phrase = new Phrase(tSSRS.GetText(j, i), font);
/*      */ 
/*  612 */           PdfPCell cell = new PdfPCell(phrase);
/*  613 */           if ((Align == 3) && (i == tSSRS.getMaxCol())) {
/*  614 */             cell.setHorizontalAlignment(2);
/*      */           }
/*  616 */           else if ((Align == 3) && (i < tSSRS.getMaxCol())) {
/*  617 */             cell.setHorizontalAlignment(1);
/*      */           }
/*  620 */           else if ((Align == 20) && (i < 3)) {
/*  621 */             cell.setHorizontalAlignment(1);
/*      */           }
/*  623 */           else if ((Align == 20) && (i >= 3)) {
/*  624 */             cell.setHorizontalAlignment(2);
/*      */           }
/*      */           else {
/*  627 */             cell.setHorizontalAlignment(tbs.getAlign());
/*      */           }
/*      */ 
/*  631 */           cell.setVerticalAlignment(0);
/*  632 */           cell.setBorder(tbs.getBorder());
/*  633 */           if (tbs.getBodyType() != 2) {
/*  634 */             if (j % 2 == 0)
/*  635 */               cell.setBackgroundColor(
/*  636 */                 new Color(tbs.getR(), tbs
/*  636 */                 .getG(), tbs.getB()));
/*      */           }
/*      */           else {
/*  639 */             cell.setBackgroundColor(
/*  640 */               new Color(tbs.getR(), tbs
/*  640 */               .getG(), tbs.getB()));
/*      */           }
/*  642 */           table.addCell(cell);
/*      */         }
/*      */       }
/*  645 */       if ((tbs.getBodyType() == 0) || (tbs.getBodyType() == 2))
/*  646 */         return table;
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  650 */       logger.error("makeTableBody(SSRS, TableBodyStyle) - " + 
/*  651 */         ex.getMessage(), ex);
/*  652 */       return null;
/*      */     }
/*  654 */     return null;
/*      */   }
/*      */ 
/*      */   public PdfPTable makeTableBodyFunH(PdfPTable table, SSRS tSSRS, TableBodyStyle tbs)
/*      */   {
/*      */     try {
/*  660 */       Font font = getFontChineseFun(tbs);
/*      */ 
/*  664 */       for (int j = 1; j <= tSSRS.getMaxRow(); j++) {
/*  665 */         if (j == tSSRS.getMaxRow() - 1) {
/*  666 */           int k = tSSRS.getMaxCol();
/*  667 */           Phrase phrase = new Phrase(tSSRS.GetText(j, k - 1), font);
/*      */ 
/*  669 */           PdfPCell cell = new PdfPCell(phrase);
/*  670 */           cell.setColspan(k - 1);
/*  671 */           cell.setHorizontalAlignment(2);
/*  672 */           cell.setVerticalAlignment(0);
/*  673 */           cell.setBorder(tbs.getBorder());
/*  674 */           if (tbs.getBodyType() != 2) {
/*  675 */             if (j % 2 == 0)
/*  676 */               cell.setBackgroundColor(
/*  677 */                 new Color(tbs.getR(), tbs
/*  677 */                 .getG(), tbs.getB()));
/*      */           }
/*      */           else {
/*  680 */             cell.setBackgroundColor(
/*  681 */               new Color(tbs.getR(), tbs
/*  681 */               .getG(), tbs.getB()));
/*      */           }
/*  683 */           table.addCell(cell);
/*  684 */           phrase = new Phrase(tSSRS.GetText(j, k), font);
/*      */ 
/*  686 */           PdfPCell cellL = new PdfPCell(phrase);
/*  687 */           cellL.setHorizontalAlignment(2);
/*  688 */           cellL.setVerticalAlignment(0);
/*  689 */           cellL.setBorder(tbs.getBorder());
/*  690 */           if (tbs.getBodyType() != 2) {
/*  691 */             if (j % 2 == 0)
/*  692 */               cellL.setBackgroundColor(
/*  693 */                 new Color(tbs.getR(), tbs
/*  693 */                 .getG(), tbs.getB()));
/*      */           }
/*      */           else {
/*  696 */             cellL.setBackgroundColor(
/*  697 */               new Color(tbs.getR(), tbs
/*  697 */               .getG(), tbs.getB()));
/*      */           }
/*  699 */           table.addCell(cellL);
/*  700 */         } else if (j == tSSRS.getMaxRow()) {
/*  701 */           int k = tSSRS.getMaxCol();
/*  702 */           Phrase phrase = new Phrase(tSSRS.GetText(j, 1), font);
/*      */ 
/*  704 */           PdfPCell cell = new PdfPCell(phrase);
/*      */ 
/*  706 */           cell.setHorizontalAlignment(tbs.getAlign());
/*  707 */           cell.setVerticalAlignment(0);
/*  708 */           cell.setBorder(tbs.getBorder());
/*  709 */           if (tbs.getBodyType() != 2) {
/*  710 */             if (j % 2 == 0)
/*  711 */               cell.setBackgroundColor(
/*  712 */                 new Color(tbs.getR(), tbs
/*  712 */                 .getG(), tbs.getB()));
/*      */           }
/*      */           else {
/*  715 */             cell.setBackgroundColor(
/*  716 */               new Color(tbs.getR(), tbs
/*  716 */               .getG(), tbs.getB()));
/*      */           }
/*  718 */           table.addCell(cell);
/*      */ 
/*  720 */           phrase = new Phrase(tSSRS.GetText(j, k), font);
/*      */ 
/*  722 */           PdfPCell cellL = new PdfPCell(phrase);
/*  723 */           cellL.setColspan(k - 1);
/*  724 */           cellL.setHorizontalAlignment(2);
/*  725 */           cellL.setVerticalAlignment(0);
/*  726 */           cellL.setBorder(tbs.getBorder());
/*  727 */           if (tbs.getBodyType() != 2) {
/*  728 */             if (j % 2 == 0)
/*  729 */               cellL.setBackgroundColor(
/*  730 */                 new Color(tbs.getR(), tbs
/*  730 */                 .getG(), tbs.getB()));
/*      */           }
/*      */           else {
/*  733 */             cellL.setBackgroundColor(
/*  734 */               new Color(tbs.getR(), tbs
/*  734 */               .getG(), tbs.getB()));
/*      */           }
/*  736 */           table.addCell(cellL);
/*      */         } else {
/*  738 */           for (int i = 1; i <= tSSRS.getMaxCol(); i++)
/*      */           {
/*  740 */             Phrase phrase = new Phrase(tSSRS.GetText(j, i), font);
/*      */ 
/*  742 */             PdfPCell cell = new PdfPCell(phrase);
/*  743 */             if ((i == tSSRS.getMaxCol()) || (i == tSSRS.getMaxCol() - 1))
/*  744 */               cell.setHorizontalAlignment(2);
/*      */             else {
/*  746 */               cell.setHorizontalAlignment(tbs.getAlign());
/*      */             }
/*  748 */             cell.setVerticalAlignment(0);
/*  749 */             cell.setBorder(tbs.getBorder());
/*  750 */             if (tbs.getBodyType() != 2) {
/*  751 */               if (j % 2 == 0)
/*  752 */                 cell.setBackgroundColor(
/*  753 */                   new Color(tbs.getR(), tbs
/*  753 */                   .getG(), tbs.getB()));
/*      */             }
/*      */             else {
/*  756 */               cell.setBackgroundColor(
/*  757 */                 new Color(tbs.getR(), tbs
/*  757 */                 .getG(), tbs.getB()));
/*      */             }
/*  759 */             table.addCell(cell);
/*      */           }
/*      */         }
/*      */       }
/*  763 */       if ((tbs.getBodyType() == 0) || (tbs.getBodyType() == 2))
/*  764 */         return table;
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  768 */       logger.error("makeTableBody(SSRS, TableBodyStyle) - " + 
/*  769 */         ex.getMessage(), ex);
/*  770 */       return null;
/*      */     }
/*  772 */     return null;
/*      */   }
/*      */ 
/*      */   public Table makeTableBodyFun(Table table, SSRS tSSRS, TableBodyStyle tbs)
/*      */   {
/*      */     try
/*      */     {
/*  780 */       Font font = getFontChineseFun(tbs);
/*      */ 
/*  784 */       for (int j = 1; j <= tSSRS.getMaxRow(); j++) {
/*  785 */         for (int i = 1; i <= tSSRS.getMaxCol(); i++)
/*      */         {
/*  787 */           Phrase phrase = new Phrase(tSSRS.GetText(j, i), font);
/*      */ 
/*  789 */           Cell cell = new Cell(phrase);
/*  790 */           cell.setHorizontalAlignment(tbs.getAlign());
/*  791 */           cell.setVerticalAlignment(0);
/*  792 */           if (tbs.getBodyType() != 2) {
/*  793 */             if (j % 2 == 0)
/*  794 */               cell.setBackgroundColor(
/*  795 */                 new Color(tbs.getR(), tbs
/*  795 */                 .getG(), tbs.getB()));
/*      */           }
/*      */           else {
/*  798 */             cell.setBackgroundColor(
/*  799 */               new Color(tbs.getR(), tbs
/*  799 */               .getG(), tbs.getB()));
/*      */           }
/*  801 */           table.addCell(cell);
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*  807 */       if ((tbs.getBodyType() == 0) || (tbs.getBodyType() == 2))
/*  808 */         return table;
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  812 */       logger.error("makeTableBody(SSRS, TableBodyStyle) - " + 
/*  813 */         ex.getMessage(), ex);
/*  814 */       return null;
/*      */     }
/*  816 */     return null;
/*      */   }
/*      */ 
/*      */   protected PdfPTable makeOnTableBodyFun(SSRS tSSRS, TableBodyStyle tbs)
/*      */   {
/*  825 */     String sqbf = "";
/*      */     try
/*      */     {
/*  828 */       PdfPTable table = new PdfPTable(tSSRS.getMaxCol());
/*  829 */       Font font = getFontChineseFun(tbs);
/*      */ 
/*  831 */       table.setWidthPercentage(100.0F);
/*  832 */       table.setWidths(tbs.getWidths());
/*  833 */       table.setSpacingBefore(tbs.getPad());
/*  834 */       table.setSpacingAfter(tbs.getPad());
/*  835 */       int maxCellRow = 0;
/*  836 */       for (int j = 1; j <= tSSRS.getMaxRow(); j++) {
/*  837 */         for (int i = 1; i <= tSSRS.getMaxCol(); i++)
/*      */         {
/*  839 */           String value = tSSRS.GetText(j, i);
/*      */ 
/*  841 */           int maxRowNum = value.length() / 32;
/*  842 */           if (maxRowNum > maxCellRow) {
/*  843 */             maxCellRow = maxRowNum;
/*      */           }
/*  845 */           String type = value.substring(value.lastIndexOf(".") + 1)
/*  846 */             .toUpperCase();
/*  847 */           value = StrTool.replaceEx(value, "<br>", "\n");
/*  848 */           Phrase phrase = new Phrase(value, font);
/*      */ 
/*  850 */           PdfPCell cell = new PdfPCell(phrase);
/*  851 */           cell.setPadding(10.0F);
/*  852 */           cell.setLeading(1.0F, 1.5F);
/*  853 */           if (i == 1) {
/*  854 */             cell.setHorizontalAlignment(1);
/*      */           }
/*      */           else {
/*  857 */             cell.setHorizontalAlignment(0);
/*      */           }
/*  859 */           if (tbs.getBodyType() != 2) {
/*  860 */             if (i % 2 == 1)
/*  861 */               cell.setBackgroundColor(
/*  862 */                 new Color(tbs.getR(), tbs
/*  862 */                 .getG(), tbs.getB()));
/*      */           }
/*      */           else {
/*  865 */             cell.setBackgroundColor(
/*  866 */               new Color(tbs.getR(), tbs
/*  866 */               .getG(), tbs.getB()));
/*      */           }
/*  868 */           table.addCell(cell);
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*  873 */       if ((tbs.getBodyType() == 0) || (tbs.getBodyType() == 2))
/*  874 */         return table;
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  878 */       logger.error("makeOnTableBody(SSRS, TableBodyStyle) - " + 
/*  879 */         ex.getMessage(), ex);
/*  880 */       return null;
/*      */     }
/*      */     PdfPTable table;
/*  882 */     return table;
/*      */   }
/*      */ 
/*      */   public HeaderFooter makeHeaderFun(String content, HeaderStyle hs)
/*      */   {
/*      */     try
/*      */     {
/*  891 */       Phrase phrase = null;
/*  892 */       Image image = Image.getInstance(content);
/*  893 */       image.scalePercent(60.0F);
/*  894 */       image.setAlignment(hs.getAlign());
/*  895 */       Paragraph p = new Paragraph();
/*  896 */       p.add(image);
/*      */ 
/*  901 */       HeaderFooter header = new HeaderFooter(p, false);
/*      */ 
/*  903 */       header.setBorder(0);
/*  904 */       header.setBorderWidth(0.0F);
/*  905 */       if (logger.isDebugEnabled()) {
/*  906 */         logger.debug("makeHeader(String, HeaderStyle) - " + 
/*  907 */           header.getHeight());
/*      */       }
/*  909 */       if (logger.isDebugEnabled())
/*  910 */         logger
/*  911 */           .debug("makeHeader(String, HeaderStyle) - yemei success !");
/*      */     }
/*      */     catch (Exception ex) {
/*  914 */       logger.error(
/*  915 */         "makeHeader(String, HeaderStyle) - " + ex.getMessage(), ex);
/*  916 */       return null;
/*      */     }
/*      */     HeaderFooter header;
/*  918 */     return header;
/*      */   }
/*      */ 
/*      */   public HeaderFooter makeFooterFun(String content, FooterStyle fs)
/*      */   {
/*  923 */     HeaderFooter footer = null;
/*      */     try
/*      */     {
/*  928 */       Phrase phrase = null;
/*  929 */       Phrase afterPhrase = null;
/*  930 */       Phrase paragraph = new Phrase(content, getFontChineseFun(fs));
/*  931 */       switch (fs.getContentType()) {
/*      */       case 0:
/*  933 */         phrase = new Phrase();
/*  934 */         break;
/*      */       case 1:
/*  937 */         String[] tempStr = content.split("pagenumber");
/*  938 */         phrase = new Phrase(StrTool.replaceEx(tempStr[0], "<br>", "\n"), 
/*  939 */           getFontChineseFun(fs));
/*  940 */         if (tempStr.length <= 1) break;
/*  941 */         afterPhrase = new Phrase(StrTool.replaceEx(tempStr[1], "<br>", "\n"), 
/*  942 */           getFontChineseFun(fs));
/*      */ 
/*  944 */         break;
/*      */       case 2:
/*  947 */         Image image = Image.getInstance(content);
/*  948 */         paragraph = new Paragraph(new Chunk(image, 0.0F, 0.0F));
/*      */       }
/*      */ 
/*  953 */       if (fs.getBumbered())
/*      */       {
/*  956 */         footer = new HeaderFooter(phrase, false);
/*      */       }
/*  958 */       else footer = new HeaderFooter(phrase, false);
/*      */ 
/*  963 */       footer.setBorder(fs.getBorder());
/*      */     }
/*      */     catch (Exception ex) {
/*  966 */       logger.error("makeFooterFun(String, FooterStyle)", ex);
/*      */     }
/*  968 */     return footer;
/*      */   }
/*      */ 
/*      */   public boolean makeNewPageFun(Document document)
/*      */   {
/*      */     try {
/*  974 */       document.newPage();
/*      */     } catch (Exception ex) {
/*  976 */       logger.error("makeNewPage() - " + ex.getMessage(), ex);
/*  977 */       return false;
/*      */     }
/*  979 */     return true;
/*      */   }
/*      */ 
/*      */   protected Phrase getPhraseFun(String value, FooterStyle fs)
/*      */   {
/*  985 */     float size = fs.getSize();
/*  986 */     int style = fs.getStyle();
/*  987 */     if ((value.indexOf("<size:") != -1) && (value.indexOf(">") != -1)) {
/*  988 */       size = Float.parseFloat(value.substring(
/*  989 */         value.indexOf("<size:") + 6, value.indexOf(">")));
/*  990 */       value = value.substring(value.indexOf(">") + 1);
/*      */     }
/*  992 */     FontStyle fontStyle = new FontStyle();
/*  993 */     fontStyle.setSize(size);
/*  994 */     fontStyle.setStyle(style);
/*  995 */     fontStyle.setColor(fs.getColor());
/*  996 */     Font font = getFontChineseFun(fontStyle);
/*  997 */     return new Phrase(value, font);
/*      */   }
/*      */ 
/*      */   public boolean makePdfPTableHead(List headers, TableHeadStyle ths)
/*      */   {
/* 1003 */     PdfPTable pdfpTable = null;
/*      */     try {
/* 1005 */       int col = ths.getCol();
/* 1006 */       pdfpTable = new PdfPTable(col);
/* 1007 */       pdfpTable.setTotalWidth(ths.getWidth());
/* 1008 */       pdfpTable.setWidths(ths.getWidths());
/* 1009 */       pdfpTable.setHorizontalAlignment(ths.getTableAlign());
/* 1010 */       pdfpTable.setSpacingBefore(ths.getPadding());
/* 1011 */       pdfpTable.setSpacingAfter(ths.getPadding());
/*      */ 
/* 1013 */       Font font = getFontChineseFun(ths);
/* 1014 */       String colName = "";
/* 1015 */       int colSpan = 1;
/* 1016 */       PdfPCell pdfpCell = null;
/* 1017 */       Phrase phrase = null;
/* 1018 */       Header header = null;
/* 1019 */       for (int i = 0; i < headers.size(); i++) {
/* 1020 */         header = (Header)headers.get(i);
/* 1021 */         colName = header.getName();
/* 1022 */         colSpan = header.getCol();
/* 1023 */         phrase = new Phrase(colName, font);
/* 1024 */         pdfpCell = new PdfPCell(phrase);
/* 1025 */         pdfpCell.setHorizontalAlignment(ths.getAlign());
/* 1026 */         pdfpCell.setVerticalAlignment(1);
/* 1027 */         pdfpCell.setBorderWidth(ths.getBorder());
/* 1028 */         pdfpCell.setBackgroundColor(
/* 1029 */           new Color(ths.getR(), ths.getG(), 
/* 1029 */           ths.getB()));
/* 1030 */         if (colSpan > 1) {
/* 1031 */           pdfpCell.setColspan(colSpan);
/*      */         }
/* 1033 */         pdfpTable.addCell(pdfpCell);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1047 */       logger.error("\u5728\u5904\u7406Table\u8868\u5934\u65F6\u53D1\u751F\u5F02\u5E38\uFF0C\u5177\u4F53\u539F\u56E0\u4E3A\uFF1A", ex);
/* 1048 */       return false;
/*      */     }
/* 1050 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean makeTableHead(String[] colNames, TableHeadStyle ths)
/*      */   {
/* 1058 */     int col = ths.getCol();
/* 1059 */     Table table = null;
/*      */     try {
/* 1061 */       table = new Table(col);
/* 1062 */       table.setBorderWidth(ths.getBorder());
/* 1063 */       table.setWidth(ths.getWidth());
/*      */ 
/* 1065 */       if (ths.getWidths() != null) {
/* 1066 */         table.setWidths(ths.getWidths());
/*      */       }
/* 1068 */       table.setBorderColor(ths.getColor());
/* 1069 */       table.setPadding(ths.getPadding());
/* 1070 */       table.setSpacing(ths.getSpacing());
/* 1071 */       Font font = getFontChineseFun(ths);
/* 1072 */       for (int i = 0; i < col; i++) {
/* 1073 */         Phrase phrase = new Phrase(colNames[i], font);
/* 1074 */         Cell cell = new Cell(phrase);
/* 1075 */         cell.setHorizontalAlignment(ths.getAlign());
/* 1076 */         cell.setBorder(ths.getBorder());
/* 1077 */         cell.setBackgroundColor(
/* 1078 */           new Color(ths.getR(), ths.getG(), ths
/* 1078 */           .getB()));
/* 1079 */         table.addCell(cell);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1088 */       logger.error("makeTableHead(String[], TableHeadStyle)", ex);
/*      */     }
/* 1090 */     return true;
/*      */   }
/*      */ 
/*      */   public Table makeTableHead(List headers, TableHeadStyle ths)
/*      */   {
/* 1095 */     int col = ths.getCol();
/* 1096 */     Table table = null;
/*      */     try {
/* 1098 */       table = new Table(col);
/* 1099 */       table.setBorderWidth(ths.getBorder());
/* 1100 */       table.setWidth(ths.getWidth());
/* 1101 */       table.setWidths(ths.getWidths());
/* 1102 */       table.setPadding(ths.getPadding());
/* 1103 */       table.setSpacing(ths.getSpacing());
/* 1104 */       table.setAlignment(ths.getTableAlign());
/*      */ 
/* 1106 */       Font font = getFontChineseFun(ths);
/* 1107 */       String colName = "";
/* 1108 */       int rowSpan = 1;
/* 1109 */       int colSpan = 1;
/* 1110 */       Cell cell = null;
/* 1111 */       Phrase phrase = null;
/* 1112 */       Header header = null;
/* 1113 */       for (int i = 0; i < headers.size(); i++) {
/* 1114 */         header = (Header)headers.get(i);
/* 1115 */         colName = header.getName();
/* 1116 */         rowSpan = header.getRow();
/* 1117 */         colSpan = header.getCol();
/* 1118 */         phrase = new Phrase(colName, font);
/* 1119 */         cell = new Cell(phrase);
/* 1120 */         cell.setHorizontalAlignment(ths.getAlign());
/* 1121 */         cell.setBorder(ths.getBorder());
/* 1122 */         cell.setBackgroundColor(
/* 1123 */           new Color(ths.getR(), ths.getG(), ths
/* 1123 */           .getB()));
/* 1124 */         if (rowSpan > 1) {
/* 1125 */           cell.setRowspan(rowSpan);
/*      */         }
/* 1127 */         if (colSpan > 1) {
/* 1128 */           cell.setColspan(colSpan);
/*      */         }
/* 1130 */         table.addCell(cell);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1139 */       logger.error("makeTableHead(List, TableHeadStyle)", ex);
/* 1140 */       logger.error("\u5728\u5904\u7406Table\u8868\u5934\u65F6\u53D1\u751F\u5F02\u5E38\uFF0C\u5177\u4F53\u539F\u56E0\u4E3A\uFF1A", ex);
/*      */     }
/*      */ 
/* 1143 */     return table;
/*      */   }
/*      */ 
/*      */   public Chunk makeLargeTextFun(String content, TextStyle ts) {
/* 1147 */     Font font = getFontChineseFun(ts);
/* 1148 */     Chunk chunk = new Chunk(content, font);
/* 1149 */     return chunk;
/*      */   }
/*      */ 
/*      */   public PdfPTable makePicPTableFun(Paragraph p, Image image, TableBodyStyle tbs)
/*      */   {
/* 1155 */     PdfPTable table = new PdfPTable(1);
/*      */     try {
/* 1157 */       if (!tbs.isHasHead()) {
/* 1158 */         table.setWidthPercentage(100.0F);
/*      */ 
/* 1160 */         table.setWidths(tbs.getWidths());
/* 1161 */         table.setHorizontalAlignment(tbs.getAlign());
/* 1162 */         table.setSpacingBefore(tbs.getPad());
/* 1163 */         table.setSpacingAfter(tbs.getPad());
/*      */       }
/*      */ 
/* 1167 */       PdfPCell cell = new PdfPCell(p);
/* 1168 */       cell.setBorder(2);
/* 1169 */       cell.setVerticalAlignment(5);
/* 1170 */       cell.setHorizontalAlignment(0);
/* 1171 */       cell.setMinimumHeight(20.0F);
/* 1172 */       table.addCell(cell);
/*      */ 
/* 1174 */       PdfPCell cell1 = new PdfPCell(image);
/* 1175 */       cell1.setBorder(0);
/* 1176 */       cell1.setVerticalAlignment(5);
/* 1177 */       cell.setHorizontalAlignment(0);
/* 1178 */       table.addCell(cell1);
/*      */     }
/*      */     catch (DocumentException e)
/*      */     {
/* 1185 */       logger.error("makePicPTableFun(Paragraph, Image, TableBodyStyle)", 
/* 1186 */         e);
/*      */     }
/* 1188 */     return table;
/*      */   }
/*      */ 
/*      */   public PdfToolFun()
/*      */   {
/*      */   }
/*      */ 
/*      */   public PdfToolFun(String path)
/*      */   {
/* 1197 */     this.path = path;
/*      */   }
/*      */ 
/*      */   public void SetneedRepeat(int recoverNum, int recoverA4Num) {
/* 1201 */     this.recoverNum = recoverNum;
/* 1202 */     this.recoverA4Num = recoverA4Num;
/*      */   }
/*      */ 
/*      */   private Font getFontChinese(FontStyle fs) {
/*      */     try {
/* 1207 */       BaseFont bfChinese = getBaseFontFun(fs);
/*      */ 
/* 1209 */       Font FontChinese = new Font(bfChinese, fs.getSize(), fs.getStyle(), 
/* 1210 */         fs.getColor());
/*      */ 
/* 1212 */       return FontChinese;
/*      */     } catch (Exception ex) {
/* 1214 */       logger.error("getFontChinese(FontStyle fs)", 
/* 1215 */         ex);
/*      */     }
/* 1217 */     return null;
/*      */   }
/*      */ 
/*      */   public void onCloseDocument(PdfWriter writer, Document arg1)
/*      */   {
/* 1224 */     this.tpl.beginText();
/* 1225 */     this.tpl.setFontAndSize(this.helv, 9.0F);
/* 1226 */     this.tpl.setTextMatrix(0.0F, 0.0F);
/* 1227 */     this.tpl.showText(writer.getPageNumber() - 1 + "\u9875");
/* 1228 */     this.tpl.endText();
/*      */   }
/*      */ 
/*      */   public void onStartPage(PdfWriter writer, Document document)
/*      */   {
/* 1234 */     this.printNums += 1;
/* 1235 */     super.onStartPage(writer, document);
/*      */   }
/*      */ 
/*      */   public void onEndPage(PdfWriter writer, Document document)
/*      */   {
/* 1240 */     if (this.printNums == this.recoverNum)
/*      */     {
/* 1242 */       document.setPageSize(PageSize.A4.rotate());
/*      */     }
/* 1244 */     if (this.printNums == this.recoverA4Num) {
/* 1245 */       System.out.println(this.printNums + "-------------------------" + this.recoverA4Num);
/* 1246 */       document.setPageSize(PageSize.A4);
/*      */     }
/*      */ 
/* 1249 */     PdfContentByte cb = writer.getDirectContent();
/* 1250 */     String text = "                                                                                              \u7B2C " + 
/* 1251 */       writer.getPageNumber() + " \u9875/\u5171 ";
/* 1252 */     if (writer.getPageNumber() == 0) {
/* 1253 */       text = "                                                                                                                                                                                  ";
/*      */     }
/* 1255 */     float textSize = this.helv.getWidthPoint(text, 9.0F);
/* 1256 */     float textBase = document.bottom();
/* 1257 */     cb.beginText();
/* 1258 */     cb.setFontAndSize(this.helv, 9.0F);
/*      */ 
/* 1260 */     cb.setTextMatrix(document.right(278.0F), textBase);
/* 1261 */     cb.showText(text);
/* 1262 */     cb.endText();
/* 1263 */     cb.addTemplate(this.tpl, document.right(278.0F) + textSize, textBase);
/*      */   }
/*      */ 
/*      */   public void onOpenDocument(PdfWriter writer, Document arg1)
/*      */   {
/*      */     try
/*      */     {
/* 1274 */       this.tpl = writer.getDirectContent().createTemplate(100.0F, 100.0F);
/* 1275 */       this.helv = BaseFont.createFont("STSongStd-Light", 
/* 1276 */         "UniGB-UCS2-H", false);
/*      */     }
/*      */     catch (Exception localException) {
/*      */     }
/*      */   }
/*      */ 
/*      */   public int getPrintNums() {
/* 1283 */     return this.printNums;
/*      */   }
/*      */   public void setPrintNums(int printNums) {
/* 1286 */     this.printNums = printNums;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.PdfToolFun
 * JD-Core Version:    0.6.0
 */