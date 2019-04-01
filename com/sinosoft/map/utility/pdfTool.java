/*      */ package com.sinosoft.map.utility;
/*      */ 
/*      */ import com.lowagie.text.Chunk;
/*      */ import com.lowagie.text.Document;
/*      */ import com.lowagie.text.DocumentException;
/*      */ import com.lowagie.text.Font;
/*      */ import com.lowagie.text.HeaderFooter;
/*      */ import com.lowagie.text.Image;
/*      */ import com.lowagie.text.PageSize;
/*      */ import com.lowagie.text.Paragraph;
/*      */ import com.lowagie.text.Rectangle;
/*      */ import com.lowagie.text.Table;
/*      */ import com.lowagie.text.pdf.BaseFont;
/*      */ import com.lowagie.text.pdf.PdfPCell;
/*      */ import com.lowagie.text.pdf.PdfPTable;
/*      */ import com.lowagie.text.pdf.PdfTemplate;
/*      */ import com.lowagie.text.pdf.PdfWriter;
/*      */ import com.sinosoft.map.lis.db.MCodeDB;
/*      */ import com.sinosoft.map.lis.vschema.MCodeSet;
/*      */ import com.sinosoft.map.style.pdf.FileStyle;
/*      */ import com.sinosoft.map.style.pdf.FooterStyle;
/*      */ import com.sinosoft.map.style.pdf.HeaderStyle;
/*      */ import com.sinosoft.map.style.pdf.ImageStyle;
/*      */ import com.sinosoft.map.style.pdf.TableBodyStyle;
/*      */ import com.sinosoft.map.style.pdf.TableHeadStyle;
/*      */ import com.sinosoft.map.style.pdf.TextStyle;
/*      */ import com.sinosoft.map.style.pdf.TitleStyle;
/*      */ import java.awt.Color;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import java.util.Vector;
/*      */ import org.apache.log4j.Logger;
/*      */ import org.w3c.dom.NodeList;
/*      */ 
/*      */ public class pdfTool extends PdfToolFun
/*      */ {
/*   32 */   private static final Logger logger = Logger.getLogger(pdfTool.class);
/*      */   protected Document document;
/*      */   protected PdfWriter pdfWriter;
/*      */   protected Table table;
/*      */   protected PdfPTable pdfPtable;
/*      */   protected Paragraph tempPara;
/*      */   private VData headerInfo;
/*      */   protected Image tempImage;
/*      */   public PdfTemplate tpl;
/*      */   public BaseFont helv;
/*   55 */   private int printNum = 0;
/*   56 */   private int recoverNum = 10000;
/*   57 */   private int recoverA4Num = 10000;
/*   58 */   private boolean needRepeat = false;
/*   59 */   private ArrayList<String> rotateList = new ArrayList();
/*      */ 
/*      */   public boolean makeFile(String tFilePath, FileStyle fs)
/*      */   {
/*   67 */     boolean needRotate = false;
/*   68 */     boolean needA4rotate = false;
/*   69 */     String riskCode = this.headerInfo.get(0).toString();
/*   70 */     String needAtone = this.headerInfo.get(1).toString();
/*      */ 
/*   72 */     MCodeDB MCodeDB = new MCodeDB();
/*   73 */     String sql = "select * from MCode where code='" + 
/*   74 */       riskCode + "' and codetype='printType'";
/*   75 */     MCodeSet MCodeSet = MCodeDB.executeQuery(sql);
/*   76 */     if ((MCodeSet != null) && (MCodeSet.size() != 0)) {
/*   77 */       needRotate = true;
/*      */     }
/*   79 */     if ((needRotate) && (needAtone.equals("one"))) {
/*   80 */       needA4rotate = true;
/*      */     }
/*   82 */     Vector vector = makeFileFun(this.document, this.pdfWriter, tFilePath, fs, needA4rotate);
/*   83 */     if (vector == null) {
/*   84 */       return false;
/*      */     }
/*   86 */     if (vector == null) {
/*   87 */       return false;
/*      */     }
/*   89 */     this.document = ((Document)vector.get(0));
/*   90 */     this.pdfWriter = ((PdfWriter)vector.get(1));
/*      */     try
/*      */     {
/*   95 */       BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", 
/*   96 */         false);
/*   97 */       Font localFont = new Font(bfChinese, 9.0F, 0);
/*      */     }
/*      */     catch (DocumentException e) {
/*  100 */       e.printStackTrace();
/*      */     }
/*      */     catch (IOException e) {
/*  103 */       e.printStackTrace();
/*      */     }
/*      */ 
/*  106 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean makeText(String tContent, TextStyle ts)
/*      */   {
/*      */     try {
/*  112 */       Paragraph paragraph = makeTextFun(tContent, ts);
/*  113 */       if (ts.isAlone())
/*  114 */         this.document.add(paragraph);
/*      */       else
/*  116 */         this.tempPara = paragraph;
/*      */     }
/*      */     catch (DocumentException de)
/*      */     {
/*  120 */       logger
/*  121 */         .error("makeText(String, TextStyle) - " + de.getMessage(), 
/*  122 */         de);
/*  123 */       return false;
/*      */     } catch (Exception ex) {
/*  125 */       logger
/*  126 */         .error("makeText(String, TextStyle) - " + ex.getMessage(), 
/*  127 */         ex);
/*  128 */       return false;
/*      */     }
/*  130 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean makeTitle(String title, TitleStyle ts)
/*      */   {
/*  135 */     boolean reBln = makeTitleFun(this.pdfWriter, title, ts);
/*  136 */     return reBln;
/*      */   }
/*      */ 
/*      */   public boolean makeImage(String path, ImageStyle is)
/*      */   {
/*      */     try {
/*  142 */       Image image = makeImageFun(path, is);
/*  143 */       if ((image != null) && (is.isAlone()))
/*  144 */         this.document.add(image);
/*      */       else
/*  146 */         this.tempImage = image;
/*      */     }
/*      */     catch (Exception ex) {
/*  149 */       logger.error("makeImage(String, ImageStyle) - " + ex.getMessage(), 
/*  150 */         ex);
/*  151 */       return false;
/*      */     }
/*      */ 
/*  154 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean makeTableHead(List headers, TableHeadStyle ths, boolean tableType)
/*      */   {
/*  160 */     if (tableType) {
/*  161 */       return makePdfPTableHead(headers, ths);
/*      */     }
/*      */ 
/*  164 */     return false;
/*      */   }
/*      */ 
/*      */   public boolean makeTableHead(String[] colNames, TableHeadStyle ths, boolean pdfpTable)
/*      */   {
/*  171 */     if (pdfpTable) {
/*  172 */       return makePdfPTableHead(colNames, ths);
/*      */     }
/*  174 */     return makeTableHead(colNames, ths);
/*      */   }
/*      */ 
/*      */   public boolean makeTableHead(String[] colNames, TableHeadStyle ths)
/*      */   {
/*  181 */     this.table = makeTableHeadFun(this.table, colNames, ths);
/*  182 */     if (this.table == null)
/*  183 */       return false;
/*      */     try
/*      */     {
/*  186 */       if (ths.haveTableBody())
/*  187 */         this.table.endHeaders();
/*      */       else {
/*  189 */         this.document.add(this.table);
/*      */       }
/*      */     }
/*      */     catch (DocumentException e)
/*      */     {
/*  194 */       logger.error("makeTableHead(String[], TableHeadStyle)", e);
/*      */     }
/*  196 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean makePdfPTableHead(String[] colNames, TableHeadStyle ths)
/*      */   {
/*      */     try
/*      */     {
/*  203 */       this.pdfPtable = makePdfPTableHeadFun(colNames, ths);
/*  204 */       if (ths.haveTableBody())
/*  205 */         this.pdfPtable.setHeaderRows(ths.getHeaderRows());
/*      */       else
/*  207 */         this.document.add(this.pdfPtable);
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  211 */       logger.error("makePdfPTableHead(String[], TableHeadStyle)", ex);
/*      */     }
/*  213 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean makePdfPTableHead(List headers, TableHeadStyle ths)
/*      */   {
/*      */     try
/*      */     {
/*  222 */       this.pdfPtable = makePdfPTableHeadFun(headers, ths);
/*      */     } catch (Exception ex) {
/*  224 */       logger.error("makeTableHead(List, TableHeadStyle) - " + 
/*  225 */         ex.getMessage(), ex);
/*  226 */       return false;
/*      */     }
/*  228 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean makePDFPTableBody(SSRS tSSRS, TableBodyStyle tbs)
/*      */   {
/*      */     try {
/*  234 */       makeTableBodyFun(this.pdfPtable, tSSRS, tbs);
/*  235 */       if ((tbs.getBodyType() == 0) || (tbs.getBodyType() == 2))
/*  236 */         this.document.add(this.pdfPtable);
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  240 */       logger.error("makeTableBody(SSRS, TableBodyStyle) - " + 
/*  241 */         ex.getMessage(), ex);
/*  242 */       return false;
/*      */     }
/*  244 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean makePDFPTableBodyH(SSRS tSSRS, TableBodyStyle tbs)
/*      */   {
/*      */     try {
/*  250 */       makeTableBodyFunH(this.pdfPtable, tSSRS, tbs);
/*  251 */       if ((tbs.getBodyType() == 0) || (tbs.getBodyType() == 2))
/*  252 */         this.document.add(this.pdfPtable);
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  256 */       logger.error("makeTableBody(SSRS, TableBodyStyle) - " + 
/*  257 */         ex.getMessage(), ex);
/*  258 */       return false;
/*      */     }
/*  260 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean makeTableBody(SSRS tSSRS, TableBodyStyle tbs)
/*      */   {
/*      */     try {
/*  266 */       makeTableBodyFun(this.table, tSSRS, tbs);
/*  267 */       if ((tbs.getBodyType() == 0) || (tbs.getBodyType() == 2))
/*      */       {
/*  269 */         this.document.add(this.table);
/*      */       }
/*      */     }
/*      */     catch (DocumentException e)
/*      */     {
/*  274 */       logger.error("makeTableBody(SSRS, TableBodyStyle)", e);
/*  275 */       return false;
/*      */     }
/*  277 */     return true;
/*      */   }
/*      */ 
/*      */   protected boolean makeOnTableBody(SSRS tSSRS, TableBodyStyle tbs)
/*      */   {
/*      */     try {
/*  283 */       PdfPTable pdfPTable = makeOnTableBodyFun(tSSRS, tbs);
/*  284 */       if ((tbs.getBodyType() == 0) || (tbs.getBodyType() == 2))
/*  285 */         this.document.add(pdfPTable);
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  289 */       logger.error("makeOnTableBody(SSRS, TableBodyStyle) - " + 
/*  290 */         ex.getMessage(), ex);
/*  291 */       return false;
/*      */     }
/*  293 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean makeHeader(String content, HeaderStyle hs)
/*      */   {
/*      */     try {
/*  299 */       HeaderFooter headerFooter = makeHeaderFun(content, hs);
/*  300 */       this.document.setHeader(headerFooter);
/*      */     } catch (Exception ex) {
/*  302 */       logger.error(
/*  303 */         "makeHeader(String, HeaderStyle) - " + ex.getMessage(), ex);
/*  304 */       if (logger.isDebugEnabled()) {
/*  305 */         logger.debug("makeHeader(String, HeaderStyle) - " + ex);
/*      */       }
/*  307 */       return false;
/*      */     }
/*  309 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean makeFooter(String content, FooterStyle fs)
/*      */   {
/*      */     try
/*      */     {
/*  316 */       if (!fs.isContinue()) {
/*  317 */         this.document.resetPageCount();
/*      */       }
/*  319 */       HeaderFooter footer = makeFooterFun(content, fs);
/*  320 */       this.document.setFooter(footer);
/*  321 */       if (logger.isDebugEnabled())
/*  322 */         logger
/*  323 */           .debug("makeFooter(String, FooterStyle) - yejiao success !");
/*      */     }
/*      */     catch (Exception ex) {
/*  326 */       logger.error(
/*  327 */         "makeFooter(String, FooterStyle) - " + ex.getMessage(), ex);
/*  328 */       return false;
/*      */     }
/*  330 */     return true;
/*      */   }
/*      */ 
/*      */   protected boolean makeNewLine()
/*      */   {
/*      */     try
/*      */     {
/*  337 */       Chunk chunk = new Chunk("                                                                                                                                            ");
/*      */ 
/*  341 */       chunk.setUnderline(new Color(128, 128, 128), 0.01F, 0.01F, 15.0F, 
/*  342 */         0.0F, 0);
/*  343 */       this.document.add(chunk);
/*      */     }
/*      */     catch (DocumentException e) {
/*  346 */       logger.error("makeNewLine()", e);
/*  347 */       return false;
/*      */     }
/*  349 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean makePicTalbe(TableBodyStyle tbs) {
/*  353 */     if ((this.tempImage == null) || (this.tempPara == null)) {
/*  354 */       logger.equals("mekePicTable fail");
/*  355 */       return false;
/*      */     }
/*  357 */     if (tbs.isUsePdfPTable()) {
/*  358 */       if (!makePicPdfPtable(tbs)) {
/*  359 */         return false;
/*      */       }
/*      */     }
/*  362 */     else if (!makePicTable(tbs)) {
/*  363 */       return false;
/*      */     }
/*      */ 
/*  368 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean makePicPdfPtable(TableBodyStyle tbs)
/*      */   {
/*  373 */     PdfPTable table = makePicPTableFun(this.tempPara, this.tempImage, tbs);
/*  374 */     PdfPTable pTable = new PdfPTable(1);
/*  375 */     pTable.setWidthPercentage(100.0F);
/*  376 */     PdfPCell cell = new PdfPCell(table);
/*  377 */     cell.setBorder(0);
/*  378 */     pTable.addCell(cell);
/*      */     try {
/*  380 */       this.document.add(pTable);
/*      */     }
/*      */     catch (DocumentException e) {
/*  383 */       logger.error("makePicPdfPtable(TableBodyStyle)", e);
/*      */     }
/*      */ 
/*  386 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean makeLargeText(org.w3c.dom.Element element) {
/*  390 */     Paragraph largeText = null;
/*  391 */     NodeList list = element.getElementsByTagName("header");
/*  392 */     org.w3c.dom.Element e = null;
/*  393 */     TextStyle ts = null;
/*  394 */     String size = null;
/*  395 */     String content = null;
/*  396 */     String font = null;
/*  397 */     String style = null;
/*  398 */     String align = null;
/*  399 */     String space = null;
/*  400 */     String remark = null;
/*  401 */     String isStart = null;
/*  402 */     String isEnd = null;
/*  403 */     for (int i = 0; i < list.getLength(); i++) {
/*  404 */       ts = new TextStyle();
/*  405 */       e = (org.w3c.dom.Element)list.item(i);
/*  406 */       size = XMLParser.getTagContent(e, "size", "");
/*  407 */       font = XMLParser.getTagContent(e, "font", "");
/*  408 */       style = XMLParser.getTagContent(e, "style", "");
/*  409 */       content = XMLParser.getTagContent(e, "content", "");
/*  410 */       align = XMLParser.getTagContent(e, "align", "");
/*  411 */       isStart = XMLParser.getTagContent(e, "isStart", "");
/*  412 */       isEnd = XMLParser.getTagContent(e, "isEnd", "");
/*  413 */       space = XMLParser.getTagContent(e, "space", "");
/*  414 */       ts.setSize(Float.parseFloat(size));
/*  415 */       if ((font == null) || (font.equals("")))
/*  416 */         ts.setFontName(0);
/*  417 */       else if (font.equalsIgnoreCase("\u9ED1\u4F53"))
/*  418 */         ts.setFontName(3);
/*  419 */       else if (font.equalsIgnoreCase("\u6977\u4F53"))
/*  420 */         ts.setFontName(2);
/*  421 */       else if (font.equalsIgnoreCase("\u4EFF\u5B8B"))
/*  422 */         ts.setFontName(1);
/*  423 */       else if (font.equalsIgnoreCase("Arial"))
/*  424 */         ts.setFontName(4);
/*  425 */       else if (font.equalsIgnoreCase("Arial_BOLD"))
/*  426 */         ts.setFontName(5);
/*  427 */       else if (font.equalsIgnoreCase("Arial_ITALIC"))
/*  428 */         ts.setFontName(6);
/*  429 */       else if (font.equalsIgnoreCase("Arial_BOLDITALIC")) {
/*  430 */         ts.setFontName(7);
/*      */       }
/*      */ 
/*  434 */       if (align == null)
/*  435 */         ts.setAlign(1);
/*  436 */       else if (align.equalsIgnoreCase("ALIGN_RIGHT"))
/*  437 */         ts.setAlign(2);
/*  438 */       else if (align.equalsIgnoreCase("ALIGN_LEFT"))
/*  439 */         ts.setAlign(0);
/*  440 */       else if (align.equalsIgnoreCase("ALIGN_CENTER")) {
/*  441 */         ts.setAlign(1);
/*      */       }
/*      */ 
/*  444 */       if ((style == null) || (style.trim().equals("")))
/*  445 */         ts.setStyle(0);
/*  446 */       else if (style.equalsIgnoreCase("BOLD"))
/*  447 */         ts.setStyle(1);
/*  448 */       else if (style.equalsIgnoreCase("ITALIC"))
/*  449 */         ts.setStyle(2);
/*  450 */       else if (style.equalsIgnoreCase("BOLDITALIC"))
/*  451 */         ts.setStyle(3);
/*      */       else {
/*  453 */         ts.setStyle(0);
/*      */       }
/*  455 */       if ((isStart != null) && (!isStart.equals(""))) {
/*  456 */         ts.setStart(Boolean.valueOf(isStart).booleanValue());
/*      */       }
/*  458 */       if ((isEnd != null) && (!isEnd.equals(""))) {
/*  459 */         ts.setEnd(Boolean.valueOf(isEnd).booleanValue());
/*      */       }
/*      */ 
/*  462 */       if (ts.isStart()) {
/*  463 */         if ((space != null) && (!space.equals("")))
/*  464 */           largeText = new Paragraph(Float.parseFloat(space));
/*      */         else {
/*  466 */           largeText = new Paragraph();
/*      */         }
/*      */       }
/*      */ 
/*  470 */       Chunk chunk = makeLargeTextFun(content, ts);
/*  471 */       largeText.add(chunk);
/*  472 */       largeText.setAlignment(ts.getAlign());
/*  473 */       if (!ts.isEnd()) continue;
/*      */       try {
/*  475 */         this.document.add(largeText);
/*      */       }
/*      */       catch (DocumentException e1) {
/*  478 */         logger.error("makeLargeText(org.w3c.dom.Element)", e1);
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  491 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean makePicTable(TableBodyStyle tbs) {
/*  495 */     return false;
/*      */   }
/*      */ 
/*      */   private boolean addElement(com.lowagie.text.Element element)
/*      */   {
/*      */     try {
/*  501 */       this.document.add(element);
/*      */     } catch (Exception e) {
/*  503 */       logger.error("PDF\u5728\u5904\u7406Element\u65F6\u53D1\u751F\u5F02\u5E38\uFF0C\u5177\u4F53\u539F\u56E0\u4E3A\uFF1A", e);
/*  504 */       return false;
/*      */     }
/*  506 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean MakePDF1(VData Vtype, VData Vcontent, VData Vstyle)
/*      */   {
/*  511 */     String type = "";
/*  512 */     String content = "";
/*      */ 
/*  514 */     if (Vtype.size() < 5) {
/*  515 */       Vtype.add("TEXT");
/*  516 */       Vcontent.add("  ");
/*  517 */       Vstyle.add(new TextStyle());
/*      */     }
/*  519 */     for (int i = 0; i < Vtype.size(); i++) {
/*  520 */       type = (String)Vtype.get(i);
/*      */ 
/*  522 */       if (logger.isDebugEnabled()) {
/*  523 */         logger.debug("MakePDF1(VData, VData, VData) - ID--" + i + 
/*  524 */           "********TYPE--" + type + "********Content--" + 
/*  525 */           Vcontent.get(i).toString());
/*      */       }
/*  527 */       if (type.equals("FILE")) {
/*  528 */         content = (String)Vcontent.get(i);
/*  529 */         FileStyle fs = (FileStyle)Vstyle.get(i);
/*  530 */         if (!makeFile(content, fs)) {
/*  531 */           return false;
/*      */         }
/*      */       }
/*  534 */       if (type.equals("TEXT"))
/*      */       {
/*  536 */         Object value = Vcontent.get(i);
/*  537 */         if ((value instanceof String)) {
/*  538 */           if (logger.isDebugEnabled()) {
/*  539 */             logger
/*  540 */               .debug("MakePDF1(VData, VData, VData) - content = " + 
/*  541 */               value);
/*      */           }
/*  543 */           TextStyle ts = new TextStyle();
/*  544 */           ts = (TextStyle)Vstyle.get(i);
/*  545 */           if (!makeText(value.toString(), ts))
/*  546 */             return false;
/*      */         }
/*  548 */         else if ((value instanceof org.w3c.dom.Element)) {
/*  549 */           org.w3c.dom.Element element = (org.w3c.dom.Element)value;
/*  550 */           if (!makeLargeText(element)) {
/*  551 */             return false;
/*      */           }
/*      */         }
/*      */       }
/*  555 */       if (type.equals("TITLE")) {
/*  556 */         content = (String)Vcontent.get(i);
/*  557 */         TitleStyle TS = new TitleStyle();
/*  558 */         TS = (TitleStyle)Vstyle.get(i);
/*  559 */         if (!makeTitle(content, TS)) {
/*  560 */           return false;
/*      */         }
/*      */       }
/*  563 */       if (type.equals("IMAGE")) {
/*  564 */         content = (String)Vcontent.get(i);
/*  565 */         ImageStyle is = new ImageStyle();
/*  566 */         is = (ImageStyle)Vstyle.get(i);
/*  567 */         String imageType = is.getImageType().toUpperCase();
/*  568 */         if (((imageType.equals("JPG")) || (imageType.equals("GIF")) || 
/*  569 */           (imageType.equals("PNG"))) && 
/*  570 */           (!makeImage(content, is))) {
/*  571 */           return false;
/*      */         }
/*      */       }
/*      */ 
/*  575 */       if (type.equals("TABLEHEAD")) {
/*  576 */         TableHeadStyle ths = new TableHeadStyle();
/*  577 */         ths = (TableHeadStyle)Vstyle.get(i);
/*  578 */         boolean usePDFPTable = false;
/*  579 */         if (ths.getheadType() < 0) {
/*  580 */           usePDFPTable = true;
/*      */         }
/*      */ 
/*  583 */         if (Math.abs(ths.getheadType()) == 1) {
/*  584 */           List list = (List)Vcontent.get(i);
/*  585 */           if (!makeTableHead(list, ths, usePDFPTable)) {
/*  586 */             return false;
/*      */           }
/*      */         }
/*      */ 
/*  590 */         if (Math.abs(ths.getheadType()) == 2) {
/*  591 */           String[] col = (String[])Vcontent.get(i);
/*  592 */           if (!makeTableHead(col, ths, usePDFPTable)) {
/*  593 */             return false;
/*      */           }
/*      */         }
/*      */       }
/*  597 */       if (type.equals("TABLEBODY")) {
/*  598 */         SSRS tSSRS = (SSRS)Vcontent.get(i);
/*  599 */         TableBodyStyle tbs = new TableBodyStyle();
/*  600 */         tbs = (TableBodyStyle)Vstyle.get(i);
/*  601 */         if (tbs.isUsePdfPTable()) {
/*  602 */           if (!makePDFPTableBody(tSSRS, tbs)) {
/*  603 */             return false;
/*      */           }
/*      */         }
/*  606 */         else if (!makeTableBody(tSSRS, tbs)) {
/*  607 */           return false;
/*      */         }
/*      */       }
/*      */ 
/*  611 */       if (type.equals("TABLEBODY-H"))
/*      */       {
/*  613 */         SSRS tSSRS = (SSRS)Vcontent.get(i);
/*  614 */         TableBodyStyle tbs = new TableBodyStyle();
/*  615 */         tbs = (TableBodyStyle)Vstyle.get(i);
/*  616 */         if (tbs.isUsePdfPTable()) {
/*  617 */           if (!makePDFPTableBodyH(tSSRS, tbs)) {
/*  618 */             return false;
/*      */           }
/*      */         }
/*  621 */         else if (!makeTableBody(tSSRS, tbs)) {
/*  622 */           return false;
/*      */         }
/*      */       }
/*      */ 
/*  626 */       if (type.equals("PICTABLEBODY")) {
/*  627 */         TableBodyStyle tbs = (TableBodyStyle)Vstyle.get(i);
/*  628 */         if (!makePicTalbe(tbs)) {
/*  629 */           return false;
/*      */         }
/*      */       }
/*      */ 
/*  633 */       if (type.equals("ONTABLEBODY")) {
/*  634 */         SSRS tSSRS = (SSRS)Vcontent.get(i);
/*  635 */         TableBodyStyle tbs = new TableBodyStyle();
/*  636 */         tbs = (TableBodyStyle)Vstyle.get(i);
/*  637 */         if (!makeOnTableBody(tSSRS, tbs)) {
/*  638 */           return false;
/*      */         }
/*      */       }
/*      */ 
/*  642 */       if (type.equals("HEADER")) {
/*  643 */         content = (String)Vcontent.get(i);
/*  644 */         if (logger.isDebugEnabled()) {
/*  645 */           logger.debug("MakePDF1(VData, VData, VData) - " + content);
/*      */         }
/*  647 */         HeaderStyle hs = new HeaderStyle();
/*  648 */         hs = (HeaderStyle)Vstyle.get(i);
/*  649 */         if (!makeHeader(content, hs)) {
/*  650 */           return false;
/*      */         }
/*      */       }
/*      */ 
/*  654 */       if (type.equals("FOOTER")) {
/*  655 */         content = (String)Vcontent.get(i);
/*  656 */         FooterStyle fs = new FooterStyle();
/*  657 */         fs = (FooterStyle)Vstyle.get(i);
/*  658 */         if (!makeFooter(content, fs)) {
/*  659 */           return false;
/*      */         }
/*      */       }
/*  662 */       if ((type.equals("NEWPAGE")) && 
/*  663 */         (!makeNewPageFun(this.document))) {
/*  664 */         return false;
/*      */       }
/*      */ 
/*  669 */       if (!type.equals("ELEMENT"))
/*      */         continue;
/*  671 */       com.lowagie.text.Element element = (com.lowagie.text.Element)Vcontent.get(i);
/*  672 */       if (!addElement(element)) {
/*  673 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  678 */     makeCloseFun(this.document);
/*  679 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean MakePDF1(VData Vtype, VData Vcontent, VData Vstyle, VData headerInfo)
/*      */   {
/*  684 */     setPrintNums(0);
/*  685 */     if (this.needRepeat) {
/*  686 */       SetneedRepeat(this.recoverNum, this.recoverA4Num);
/*      */     }
/*  688 */     boolean isLongTitle = false;
/*      */ 
/*  690 */     int isTitle = 0;
/*  691 */     this.headerInfo = headerInfo;
/*  692 */     String type = "";
/*  693 */     String content = "";
/*      */ 
/*  695 */     int newPage = 0;
/*  696 */     int isRotate = 0;
/*  697 */     int offset = 3;
/*      */ 
/*  699 */     boolean needRotate = false;
/*  700 */     int vcontentOffset = 5;
/*      */ 
/*  702 */     String riskCode = this.headerInfo.get(0).toString();
/*  703 */     String needAtone = this.headerInfo.get(1).toString();
/*  704 */     boolean haveT = ((Boolean)this.headerInfo.get(2)).booleanValue();
/*  705 */     boolean haveS = ((Boolean)this.headerInfo.get(3)).booleanValue();
/*      */ 
/*  707 */     MCodeDB MCodeDB = new MCodeDB();
/*  708 */     String sql = "select * from MCode where code='" + 
/*  709 */       riskCode + "' and codetype='printType'";
/*  710 */     MCodeSet MCodeSet = MCodeDB.executeQuery(sql);
/*  711 */     if ((MCodeSet != null) && (MCodeSet.size() != 0)) {
/*  712 */       needRotate = true;
/*  713 */       vcontentOffset = 3;
/*      */     }
/*      */ 
/*  716 */     if (haveT) {
/*  717 */       offset = 2;
/*      */     }
/*  719 */     for (int i = 0; i < Vtype.size(); i++) {
/*  720 */       this.rotateList.clear();
/*  721 */       type = (String)Vtype.get(i);
/*      */ 
/*  726 */       if ((i < Vcontent.size() - vcontentOffset) && (!type.equalsIgnoreCase("FOOTER")) && (!type.equalsIgnoreCase("HEADER")))
/*      */       {
/*  728 */         if ((!needRotate) || (!needAtone.equals("one")))
/*      */         {
/*  730 */           if ((needRotate) && (i + offset < Vcontent.size()) && (Vcontent.get(i + offset).toString().lastIndexOf("\u4FDD\u9669\u5229\u76CA\u6D4B\u7B97\u6F14\u793A\u8868") != -1))
/*      */           {
/*  732 */             if (i != 0) {
/*  733 */               newPage = 1;
/*  734 */               isRotate = 0;
/*      */             }
/*      */           }
/*      */ 
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*  742 */       if (type.equals("ELEMENT")) {
/*  743 */         openDocument();
/*  744 */         com.lowagie.text.Element element = (com.lowagie.text.Element)Vcontent.get(i);
/*      */ 
/*  746 */         if (!addElement(element)) {
/*  747 */           return false;
/*      */         }
/*      */       }
/*      */ 
/*  751 */       if (type.equals("FILE")) {
/*  752 */         content = (String)Vcontent.get(i);
/*  753 */         FileStyle fs = (FileStyle)Vstyle.get(i);
/*  754 */         if (!makeFile(content, fs)) {
/*  755 */           return false;
/*      */         }
/*      */       }
/*  758 */       if (type.equals("TEXT")) {
/*  759 */         openDocument();
/*  760 */         Object value = Vcontent.get(i);
/*  761 */         if ((value instanceof String)) {
/*  762 */           if (logger.isDebugEnabled()) {
/*  763 */             logger
/*  764 */               .debug("MakePDF1(VData, VData, VData) - content = " + 
/*  765 */               value);
/*      */           }
/*  767 */           TextStyle ts = new TextStyle();
/*  768 */           ts = (TextStyle)Vstyle.get(i);
/*  769 */           if (!makeText(value.toString(), ts))
/*  770 */             return false;
/*      */         }
/*  772 */         else if ((value instanceof org.w3c.dom.Element)) {
/*  773 */           org.w3c.dom.Element element = (org.w3c.dom.Element)value;
/*  774 */           if (!makeLargeText(element)) {
/*  775 */             return false;
/*      */           }
/*      */         }
/*      */       }
/*  779 */       if (type.equals("TITLE")) {
/*  780 */         openDocument();
/*  781 */         content = (String)Vcontent.get(i);
/*  782 */         TitleStyle TS = new TitleStyle();
/*  783 */         TS = (TitleStyle)Vstyle.get(i);
/*  784 */         if (!makeTitle(content, TS)) {
/*  785 */           return false;
/*      */         }
/*      */       }
/*  788 */       if (type.equals("IMAGE")) {
/*  789 */         openDocument();
/*  790 */         content = (String)Vcontent.get(i);
/*  791 */         ImageStyle is = new ImageStyle();
/*  792 */         is = (ImageStyle)Vstyle.get(i);
/*  793 */         String imageType = is.getImageType().toUpperCase();
/*  794 */         if (((imageType.equals("JPG")) || (imageType.equals("GIF")) || 
/*  795 */           (imageType.equals("PNG"))) && 
/*  796 */           (!makeImage(content, is))) {
/*  797 */           return false;
/*      */         }
/*      */       }
/*      */ 
/*  801 */       if (type.equals("TABLEHEAD")) {
/*  802 */         openDocument();
/*  803 */         TableHeadStyle ths = new TableHeadStyle();
/*  804 */         ths = (TableHeadStyle)Vstyle.get(i);
/*  805 */         boolean usePDFPTable = false;
/*  806 */         if (ths.getheadType() < 0) {
/*  807 */           usePDFPTable = true;
/*      */         }
/*      */ 
/*  810 */         if (Math.abs(ths.getheadType()) == 1) {
/*  811 */           List list = (List)Vcontent.get(i);
/*  812 */           if (!makeTableHead(list, ths, usePDFPTable)) {
/*  813 */             return false;
/*      */           }
/*      */         }
/*      */ 
/*  817 */         if (Math.abs(ths.getheadType()) == 2) {
/*  818 */           String[] col = (String[])Vcontent.get(i);
/*  819 */           if (!makeTableHead(col, ths, usePDFPTable)) {
/*  820 */             return false;
/*      */           }
/*      */         }
/*      */       }
/*  824 */       if (type.equals("TABLEBODY")) {
/*  825 */         openDocument();
/*  826 */         SSRS tSSRS = (SSRS)Vcontent.get(i);
/*  827 */         TableBodyStyle tbs = new TableBodyStyle();
/*  828 */         tbs = (TableBodyStyle)Vstyle.get(i);
/*  829 */         if (tbs.isUsePdfPTable()) {
/*  830 */           if (!makePDFPTableBody(tSSRS, tbs)) {
/*  831 */             return false;
/*      */           }
/*      */ 
/*      */         }
/*  835 */         else if (!makeTableBody(tSSRS, tbs)) {
/*  836 */           return false;
/*      */         }
/*      */       }
/*      */ 
/*  840 */       if (type.equals("TABLEBODY-H")) {
/*  841 */         openDocument();
/*      */ 
/*  843 */         SSRS tSSRS = (SSRS)Vcontent.get(i);
/*  844 */         TableBodyStyle tbs = new TableBodyStyle();
/*  845 */         tbs = (TableBodyStyle)Vstyle.get(i);
/*  846 */         if (tbs.isUsePdfPTable()) {
/*  847 */           if (!makePDFPTableBodyH(tSSRS, tbs)) {
/*  848 */             return false;
/*      */           }
/*      */ 
/*      */         }
/*  852 */         else if (!makeTableBody(tSSRS, tbs)) {
/*  853 */           return false;
/*      */         }
/*      */       }
/*      */ 
/*  857 */       if (type.equals("PICTABLEBODY")) {
/*  858 */         openDocument();
/*  859 */         TableBodyStyle tbs = (TableBodyStyle)Vstyle.get(i);
/*  860 */         if (!makePicTalbe(tbs)) {
/*  861 */           return false;
/*      */         }
/*      */       }
/*      */ 
/*  865 */       if (type.equals("ONTABLEBODY")) {
/*  866 */         openDocument();
/*  867 */         SSRS tSSRS = (SSRS)Vcontent.get(i);
/*  868 */         TableBodyStyle tbs = new TableBodyStyle();
/*  869 */         tbs = (TableBodyStyle)Vstyle.get(i);
/*  870 */         if (!makeOnTableBody(tSSRS, tbs)) {
/*  871 */           return false;
/*      */         }
/*      */       }
/*      */ 
/*  875 */       if (type.equals("HEADER")) {
/*  876 */         content = (String)Vcontent.get(i);
/*  877 */         if (logger.isDebugEnabled()) {
/*  878 */           logger.debug("MakePDF1(VData, VData, VData) - " + content);
/*      */         }
/*  880 */         HeaderStyle hs = new HeaderStyle();
/*  881 */         hs = (HeaderStyle)Vstyle.get(i);
/*  882 */         if (!makeHeader(content, hs)) {
/*  883 */           return false;
/*      */         }
/*      */       }
/*      */ 
/*  887 */       if (type.equals("FOOTER")) {
/*  888 */         content = (String)Vcontent.get(i);
/*  889 */         FooterStyle fs = new FooterStyle();
/*  890 */         fs = (FooterStyle)Vstyle.get(i);
/*  891 */         if (!makeFooter(content, fs)) {
/*  892 */           return false;
/*      */         }
/*      */       }
/*  895 */       if (type.equals("NEWPAGE")) {
/*  896 */         openDocument();
/*  897 */         if (!makeNewPageFun(this.document)) {
/*  898 */           return false;
/*      */         }
/*      */       }
/*      */ 
/*  902 */       if ((newPage == 1) && (isRotate != 1)) {
/*  903 */         this.rotateList.add("rorate");
/*  904 */         this.document.setPageSize(PageSize.A4.rotate());
/*  905 */         openDocument();
/*  906 */         if (!makeNewPageFun(this.document)) {
/*  907 */           return false;
/*      */         }
/*  909 */         newPage = 0;
/*  910 */         isRotate = 1;
/*      */       }
/*      */ 
/*  913 */       if ((needRotate) && (!haveT) && (!haveS)) {
/*  914 */         if ((!isLongTitle) && (needRotate)) {
/*  915 */           for (int j = Vcontent.size() - 1; j > 0; j--) {
/*  916 */             if ((j - 7 <= 0) || (Vcontent.get(j - 7).toString().lastIndexOf("\u4FDD\u9669\u5229\u76CA\u6D4B\u7B97\u6F14\u793A\u8868") == -1) || 
/*  917 */               (!needRotate)) continue;
/*  918 */             isLongTitle = true;
/*  919 */             isTitle = j;
/*  920 */             break;
/*      */           }
/*      */         }
/*      */ 
/*  924 */         if ((i == isTitle) && (needRotate)) {
/*  925 */           this.rotateList.add("rorateA4");
/*  926 */           this.document.setPageSize(PageSize.A4);
/*      */ 
/*  928 */           openDocument();
/*  929 */           if (!makeNewPageFun(this.document)) {
/*  930 */             return false;
/*      */           }
/*      */         }
/*      */       }
/*  934 */       else if ((i - 7 > 0) && (Vcontent.get(i - 7).toString().lastIndexOf("\u4FDD\u9669\u5229\u76CA\u6D4B\u7B97\u6F14\u793A\u8868") != -1) && 
/*  935 */         (needRotate)) {
/*  936 */         this.rotateList.add("rorateA4");
/*  937 */         this.document.setPageSize(PageSize.A4);
/*      */ 
/*  939 */         openDocument();
/*  940 */         if (!makeNewPageFun(this.document)) {
/*  941 */           return false;
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*  948 */       if ((this.rotateList.size() >= 1) && 
/*  949 */         ("rorate".equals(((String)this.rotateList.get(this.rotateList.size() - 1)).toString())))
/*      */       {
/*  951 */         this.printNum = getPrintNums();
/*  952 */         this.recoverNum = (this.printNum - 1);
/*      */ 
/*  954 */         this.needRepeat = true;
/*      */       }
/*      */ 
/*  958 */       if ((this.rotateList.size() < 1) || 
/*  959 */         (!"rorateA4".equals(((String)this.rotateList.get(this.rotateList.size() - 1)).toString())))
/*      */         continue;
/*  961 */       this.printNum = getPrintNums();
/*  962 */       this.recoverA4Num = (this.printNum - 1);
/*      */ 
/*  964 */       this.needRepeat = true;
/*      */     }
/*      */ 
/*  969 */     makeCloseFun(this.document);
/*  970 */     return true;
/*      */   }
/*      */ 
/*      */   private void openDocument() {
/*  974 */     if (!this.document.isOpen()) {
/*  975 */       this.pdfWriter.setPageEvent(this);
/*  976 */       this.document.open();
/*      */     }
/*      */   }
/*      */ 
/*      */   public pdfTool()
/*      */   {
/*      */   }
/*      */ 
/*      */   public pdfTool(String path) {
/*  985 */     this.path = path;
/*      */   }
/*      */ 
/*      */   public static void main(String[] args)
/*      */   {
/*      */   }
/*      */ 
/*      */   public VData getHeaderInfo() {
/*  993 */     return this.headerInfo;
/*      */   }
/*      */ 
/*      */   public void setHeaderInfo(VData headerInfo) {
/*  997 */     this.headerInfo = headerInfo;
/*      */   }
/*      */   public boolean isNeedRepeat() {
/* 1000 */     return this.needRepeat;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.pdfTool
 * JD-Core Version:    0.6.0
 */