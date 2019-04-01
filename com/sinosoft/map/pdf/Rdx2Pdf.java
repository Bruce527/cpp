/*     */ package com.sinosoft.map.pdf;
/*     */ 
/*     */ import com.lowagie.text.Cell;
/*     */ import com.lowagie.text.Chunk;
/*     */ import com.lowagie.text.Font;
/*     */ import com.lowagie.text.HeaderFooter;
/*     */ import com.lowagie.text.PageSize;
/*     */ import com.lowagie.text.Paragraph;
/*     */ import com.lowagie.text.Phrase;
/*     */ import com.lowagie.text.Table;
/*     */ import com.lowagie.text.pdf.PdfWriter;
/*     */ import com.sinosoft.map.lis.pubfun.XMLByJDOM;
/*     */ import com.sinosoft.map.pdf.iText.BaseStyle;
/*     */ import com.sinosoft.map.utility.StaticConst;
/*     */ import java.awt.Color;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.util.List;
/*     */ import org.jdom.Element;
/*     */ 
/*     */ public class Rdx2Pdf
/*     */ {
/*  28 */   private static boolean isTitle = false;
/*     */ 
/*     */   public static boolean ChangeToPdf(String rdxPath, String pdfPath) {
/*  31 */     boolean flag = true;
/*     */ 
/*  33 */     XMLByJDOM tXMLByJDOM = new XMLByJDOM();
/*     */ 
/*  38 */     org.jdom.Document doc111 = tXMLByJDOM.loadXMLFileByJDOM(rdxPath);
/*     */ 
/*  40 */     com.lowagie.text.Document document = null;
/*     */     try
/*     */     {
/*  45 */       document = new com.lowagie.text.Document(PageSize.A4, 50.0F, 50.0F, 49.0F, 50.0F);
/*     */ 
/*  47 */       PdfWriter pw = PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
/*     */ 
/*  50 */       Element preElement_page_width = null;
/*  51 */       Element reportProperties = doc111.getRootElement().getChild("ReportProperties");
/*  52 */       if (reportProperties != null) {
/*  53 */         Element page = reportProperties.getChild("Page");
/*  54 */         if (page != null) {
/*  55 */           preElement_page_width = page.getChild("Width");
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*  72 */       String page_width = getElementText("827", preElement_page_width);
/*     */ 
/*  84 */       Element premElement_header = doc111.getRootElement().getChild("Header");
/*     */ 
/*  86 */       if (premElement_header != null)
/*     */       {
/*  88 */         int pageNum = pw.getPageNumber();
/*  89 */         int curPage = pw.getCurrentPageNumber();
/*     */ 
/*  91 */         HeaderFooter localHeaderFooter1 = new HeaderFooter(new Phrase("This is a header."), false);
/*     */       }
/*     */ 
/*  98 */       Element premElement_footer = doc111.getRootElement().getChild("Footer");
/*  99 */       if (premElement_footer != null)
/*     */       {
/* 102 */         Font f = BaseStyle.getContext("\u5B8B\u4F53");
/* 103 */         HeaderFooter footer = new HeaderFooter(new Phrase("\u7B2C ", f), new Phrase(" \u9875", f));
/* 104 */         footer.setAlignment(1);
/* 105 */         footer.setBorder(0);
/*     */       }
/*     */ 
/* 113 */       document.open();
/*     */ 
/* 116 */       Element premElement_body = doc111.getRootElement().getChild("Body");
/* 117 */       List bodyElementList = premElement_body.getChildren();
/* 118 */       int inBodyAmount = bodyElementList.size();
/*     */ 
/* 121 */       for (int i = 0; i < inBodyAmount; i++) {
/* 122 */         Element el = (Element)bodyElementList.get(i);
/* 123 */         String el_name = el.getName();
/*     */ 
/* 127 */         if (el_name.equals("Table")) {
/* 128 */           addTable(document, el, page_width);
/*     */         }
/*     */ 
/* 132 */         if (el_name.equals("Text")) {
/* 133 */           addText(document, el);
/*     */         }
/*     */ 
/* 136 */         if (el_name.equals("PageBreak")) {
/* 137 */           document.newPage();
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 152 */       System.out.println("============= make " + pdfPath + " === error");
/* 153 */       e.printStackTrace();
/* 154 */       flag = false;
/*     */     }
/*     */     finally
/*     */     {
/* 158 */       document.close();
/*     */     }
/*     */ 
/* 161 */     return flag;
/*     */   }
/*     */ 
/*     */   private static void addTable(com.lowagie.text.Document document, Element el, String page_width) throws Exception {
/* 165 */     boolean blankFlag = false;
/*     */ 
/* 167 */     List rowsList = el.getChildren("TableRows");
/* 168 */     int rowsAmount = rowsList.size();
/*     */ 
/* 184 */     Table table = new Table(1);
/* 185 */     Table rowTable = null;
/*     */ 
/* 187 */     Element table_style = el.getChild("Style");
/* 188 */     Element table_pos_width = null;
/* 189 */     Element table_padding_bottom = null;
/* 190 */     if (table_style != null) {
/* 191 */       Element table_sty_pos = table_style.getChild("Positioning");
/* 192 */       Element table_sty_padding = table_style.getChild("Padding");
/* 193 */       if (table_sty_pos != null) {
/* 194 */         table_pos_width = table_sty_pos.getChild("Width");
/*     */       }
/* 196 */       if (table_sty_padding != null) {
/* 197 */         table_padding_bottom = table_sty_padding.getChild("Bottom");
/*     */       }
/*     */     }
/* 200 */     String tableWidth = getElementText("100%", table_pos_width);
/* 201 */     String tableBottom = getElementText("10", table_padding_bottom);
/* 202 */     String[] tab_width = tableWidth.split("%");
/* 203 */     table.setWidth(Float.parseFloat(tab_width[0]));
/*     */ 
/* 205 */     table.setBottom(Float.parseFloat(tableBottom));
/* 206 */     table.setBorder(0);
/*     */ 
/* 208 */     table.setPadding(0.0F);
/* 209 */     table.setSpacing(0.0F);
/*     */ 
/* 214 */     for (int c = 0; c < rowsAmount; c++)
/*     */     {
/* 216 */       List rowList = ((Element)rowsList.get(c)).getChildren("TableRow");
/* 217 */       int rows = rowList.size();
/*     */ 
/* 220 */       for (int j = 0; j < rows; j++) {
/* 221 */         List cellList = ((Element)rowList.get(j)).getChild("TableCells").getChildren("TableCell");
/* 222 */         int colAmount = cellList.size();
/*     */ 
/* 225 */         float[] widths = new float[colAmount];
/*     */ 
/* 228 */         for (int g = 0; g < colAmount; g++) {
/* 229 */           Element cell_sty = ((Element)cellList.get(g)).getChild("Style");
/* 230 */           String width = "100%";
/* 231 */           if (cell_sty != null) {
/* 232 */             Element cell_posi = cell_sty.getChild("Positioning");
/* 233 */             if (cell_posi != null) {
/* 234 */               width = cell_posi.getChildText("Width");
/*     */             }
/*     */ 
/*     */           }
/*     */ 
/* 239 */           if ((width == null) || (width.equals("")))
/*     */             continue;
/* 241 */           if (!width.contains("%"))
/*     */           {
/* 243 */             int ac = Integer.parseInt(width);
/* 244 */             Double acc = Double.valueOf(new Double(ac * 100 / Integer.parseInt(page_width)).doubleValue() * 72.0D / 25.399999618530273D);
/*     */ 
/* 246 */             widths[g] = acc.floatValue();
/*     */           } else {
/* 248 */             String[] ab = width.split("%");
/*     */ 
/* 251 */             Double doubleWidth = Double.valueOf(Double.parseDouble(ab[0]) * 72.0D / 25.399999618530273D);
/* 252 */             widths[g] = doubleWidth.floatValue();
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/* 263 */         rowTable = new Table(colAmount);
/* 264 */         rowTable.setWidth(100.0F);
/*     */ 
/* 266 */         rowTable.setWidths(widths);
/* 267 */         rowTable.setBorder(0);
/*     */ 
/* 271 */         for (int g = 0; g < colAmount; g++)
/*     */         {
/* 273 */           Element cell_sty = ((Element)cellList.get(g)).getChild("Style");
/* 274 */           Element cell_sty_bor_left = null;
/* 275 */           Element cell_sty_bor_right = null;
/* 276 */           Element cell_sty_bor_top = null;
/* 277 */           Element cell_sty_bor_bottom = null;
/* 278 */           Element cell_font_family = null;
/* 279 */           Element cell_font_color = null;
/* 280 */           Element cell_font_size = null;
/* 281 */           Element cell_font_blod = null;
/* 282 */           Element cell_posi_width = null;
/* 283 */           Element cell_format_align = null;
/* 284 */           if (cell_sty != null) {
/* 285 */             Element cell_sty_bor = cell_sty.getChild("Border");
/* 286 */             Element cell_font = cell_sty.getChild("Font");
/* 287 */             Element cell_posi = cell_sty.getChild("Positioning");
/* 288 */             Element cell_format = cell_sty.getChild("Format");
/* 289 */             if (cell_sty_bor != null) {
/* 290 */               cell_sty_bor_left = cell_sty_bor.getChild("LeftWidth");
/* 291 */               cell_sty_bor_right = cell_sty_bor.getChild("RightWidth");
/* 292 */               cell_sty_bor_top = cell_sty_bor.getChild("TopWidth");
/* 293 */               cell_sty_bor_bottom = cell_sty_bor.getChild("BottomWidth");
/*     */             }
/* 295 */             if (cell_font != null) {
/* 296 */               cell_font_family = cell_font.getChild("Family");
/* 297 */               cell_font_color = cell_font.getChild("Color");
/* 298 */               cell_font_size = cell_font.getChild("Size");
/* 299 */               cell_font_blod = cell_font.getChild("Bold");
/*     */ 
/* 301 */               Element cell_font_format = cell_font.getChild("Format");
/* 302 */               if (cell_font_format != null) {
/* 303 */                 cell_format_align = cell_font_format.getChild("Alignment");
/*     */               }
/*     */             }
/* 306 */             if (cell_posi != null) {
/* 307 */               cell_posi_width = cell_posi.getChild("Width");
/*     */             }
/* 309 */             if (cell_format != null) {
/* 310 */               cell_format_align = cell_format.getChild("Alignment");
/*     */             }
/*     */           }
/*     */ 
/* 314 */           String borderLeft = getElementText("0", cell_sty_bor_left);
/* 315 */           String borderRight = getElementText("0", cell_sty_bor_right);
/* 316 */           String borderTop = getElementText("0", cell_sty_bor_top);
/* 317 */           String borderBottom = getElementText("0", cell_sty_bor_bottom);
/* 318 */           String fontFamily = getElementText("\u5B8B\u4F53", cell_font_family);
/* 319 */           String fontColor = getElementText("Black", cell_font_color);
/* 320 */           String fontSize = getElementText("12", cell_font_size);
/* 321 */           String fontBlod = getElementText("false", cell_font_blod).toLowerCase();
/* 322 */           String positioningWidth = getElementText("33%", cell_posi_width);
/* 323 */           String format_align = getElementText("Left", cell_format_align);
/* 324 */           Element cell = ((Element)cellList.get(g)).getChild("Value");
/* 325 */           String cellText = getElementText("", cell).trim();
/*     */ 
/* 327 */           cellText = cellText.replace("\uFF1A", ":");
/*     */ 
/* 329 */           if ((g == 0) && (cellText.contains("\u544A\u77E5\u4E8B\u9879"))) {
/* 330 */             blankFlag = true;
/* 331 */             cellText = " " + cellText;
/*     */           }
/* 333 */           if (blankFlag) {
/* 334 */             cellText = " " + cellText;
/* 335 */             if (cellText.trim().startsWith("\u25A1")) cellText = "   " + cellText;
/*     */ 
/* 337 */             char[] chs = cellText.trim().toCharArray();
/* 338 */             if ((chs != null) && (chs.length > 0) && (
/* 339 */               ((chs[0] >= 'a') && (chs[0] <= 'z')) || ((chs[0] >= 'A') && (chs[0] <= 'Z')))) {
/* 340 */               cellText = " " + cellText;
/*     */             }
/*     */ 
/* 343 */             if (cellText.trim().endsWith("\u6309\u56FD\u5BB6\u89C4\u5B9A\u8FDB\u884C\u63A5\u79CD\uFF1F")) {
/* 344 */               cellText = cellText + "\n" + "\n";
/*     */             }
/*     */           }
/*     */ 
/* 348 */           if (fontFamily.contains("\u4EFF\u5B8B")) fontFamily = "\u4EFF\u5B8B";
/* 349 */           Font f = BaseStyle.getContext(fontFamily);
/*     */ 
/* 351 */           if (fontBlod.equals("true")) {
/* 352 */             f = new Font(StaticConst.getInstance().getFont(fontFamily).getBaseFont(), Float.parseFloat(fontSize), 1);
/*     */           }
/* 354 */           f.setSize(Float.parseFloat(fontSize));
/* 355 */           f.setColor(Color.BLACK);
/*     */ 
/* 357 */           Cell cel = new Cell(new Paragraph(cellText, f));
/*     */ 
/* 359 */           cel.setVerticalAlignment(1);
/* 360 */           if (format_align.equals("Center"))
/* 361 */             cel.setHorizontalAlignment(1);
/* 362 */           else if (format_align.endsWith("Right"))
/* 363 */             cel.setHorizontalAlignment(2);
/* 364 */           else if (format_align.endsWith("Left"))
/* 365 */             cel.setHorizontalAlignment(3);
/* 366 */           else cel.setHorizontalAlignment(1);
/*     */ 
/* 372 */           if ((borderLeft.equals("0")) || (borderRight.equals("0")) || (borderBottom.equals("0")) || (borderTop.equals("0"))) {
/* 373 */             if (!borderLeft.equals("0"))
/* 374 */               cel.setBorderWidthLeft(0.5F);
/*     */             else {
/* 376 */               cel.setBorderWidthLeft(0.0F);
/*     */             }
/* 378 */             if (!borderRight.equals("0"))
/* 379 */               cel.setBorderWidthRight(0.5F);
/*     */             else {
/* 381 */               cel.setBorderWidthRight(0.0F);
/*     */             }
/* 383 */             if (!borderTop.equals("0"))
/* 384 */               cel.setBorderWidthTop(0.5F);
/*     */             else {
/* 386 */               cel.setBorderWidthTop(0.0F);
/*     */             }
/* 388 */             if (!borderBottom.equals("0"))
/* 389 */               cel.setBorderWidthBottom(0.5F);
/*     */             else {
/* 391 */               cel.setBorderWidthBottom(0.0F);
/*     */             }
/*     */ 
/*     */           }
/*     */ 
/* 411 */           cel.setUseDescender(true);
/*     */ 
/* 414 */           if ((cellText.trim().equals("")) && ((!borderTop.equals("0")) || (!borderBottom.equals("0"))))
/*     */           {
/* 416 */             cel.add(new Paragraph("\n"));
/*     */           }
/*     */ 
/* 420 */           rowTable.addCell(cel);
/*     */         }
/*     */ 
/* 423 */         table.addCell(new Cell(rowTable));
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 428 */     document.add(table);
/*     */   }
/*     */ 
/*     */   private static void addText(com.lowagie.text.Document document, Element el)
/*     */     throws Exception
/*     */   {
/* 434 */     Element text_sty = el.getChild("Style");
/* 435 */     Element text_font_family = null;
/* 436 */     Element text_font_color = null;
/* 437 */     Element text_font_size = null;
/* 438 */     Element text_font_bold = null;
/* 439 */     Element text_font_align = null;
/* 440 */     Element text_padding_bottom = null;
/* 441 */     Element text_pos_width = null;
/* 442 */     if (text_sty != null) {
/* 443 */       Element text_sty_font = text_sty.getChild("Font");
/* 444 */       Element text_sty_padding = text_sty.getChild("Padding");
/* 445 */       Element text_sty_pos = text_sty.getChild("Positioning");
/* 446 */       if (text_sty_font != null) {
/* 447 */         text_font_family = text_sty_font.getChild("Family");
/* 448 */         text_font_color = text_sty_font.getChild("Color");
/* 449 */         text_font_size = text_sty_font.getChild("Size");
/* 450 */         text_font_bold = text_sty_font.getChild("Bold");
/* 451 */         Element text_font_format = text_sty_font.getChild("Format");
/* 452 */         if (text_font_format != null) {
/* 453 */           text_font_align = text_font_format.getChild("Alignment");
/*     */         }
/*     */       }
/* 456 */       if (text_sty_padding != null) {
/* 457 */         text_padding_bottom = text_sty_padding.getChild("Bottom");
/*     */       }
/* 459 */       if (text_sty_pos != null) {
/* 460 */         text_pos_width = text_sty_pos.getChild("Width");
/*     */       }
/*     */     }
/*     */ 
/* 464 */     String text_family = getElementText("\u5B8B\u4F53", text_font_family);
/* 465 */     if (text_family.contains("\u4EFF\u5B8B")) text_family = "\u4EFF\u5B8B";
/*     */ 
/* 469 */     String text_color = getElementText("BLACK", text_font_color);
/* 470 */     String text_size = getElementText("10", text_font_size);
/* 471 */     String text_bold = getElementText("false", text_font_bold);
/* 472 */     String text_align = getElementText("Left", text_font_align);
/* 473 */     String text_bottom = getElementText("20", text_padding_bottom);
/* 474 */     String text_width = getElementText("100%", text_pos_width);
/*     */ 
/* 479 */     String text = el.getChildText("Value");
/* 480 */     text = text.replace("\uFF1A", ":");
/*     */ 
/* 482 */     int align = 3;
/* 483 */     if (text_align.equals("Center"))
/* 484 */       align = 1;
/* 485 */     else if (text_align.equals("Left"))
/* 486 */       align = 3;
/* 487 */     else if (text_align.equals("Right")) {
/* 488 */       align = 2;
/*     */     }
/* 490 */     if (isTitle)
/*     */     {
/* 492 */       isTitle = false;
/*     */     }
/*     */ 
/* 495 */     if ((new Double(text_size).doubleValue() > 12.0D) && ("true".equals(text_bold)) && ("Center".equals(text_align))) {
/* 496 */       isTitle = true;
/* 497 */       text = "\n" + text;
/*     */     }
/* 499 */     Font f1 = BaseStyle.getContext(text_family);
/* 500 */     f1.setColor(Color.BLACK);
/* 501 */     f1.setSize(Float.parseFloat(text_size));
/* 502 */     if (text_bold.equals("true"))
/*     */     {
/* 505 */       f1 = new Font(StaticConst.getInstance().getFont(text_family).getBaseFont(), Float.parseFloat(text_size), 1);
/*     */     }
/*     */ 
/* 510 */     Chunk cc = new Chunk();
/*     */ 
/* 512 */     cc.setFont(f1);
/*     */ 
/* 516 */     String trimText = rightTrim(text);
/*     */ 
/* 518 */     if (rightTrim(text).startsWith("    ")) {
/* 519 */       trimText = "  " + rightTrim(text).trim();
/*     */     }
/* 521 */     if (text.trim().startsWith("\u25CE")) {
/* 522 */       trimText = leftTrim(trimText);
/*     */     }
/*     */ 
/* 526 */     cc.append(trimText);
/*     */ 
/* 532 */     Paragraph par = new Paragraph();
/*     */ 
/* 534 */     par.setAlignment(align);
/* 535 */     par.add(cc);
/*     */ 
/* 537 */     par.setSpacingAfter(Float.parseFloat(text_bottom));
/*     */ 
/* 539 */     par.setFont(f1);
/* 540 */     document.add(par);
/*     */   }
/*     */ 
/*     */   private static String getElementText(String defaultText, Element element)
/*     */   {
/* 551 */     if ((element != null) && (!"".equals(element.getText()))) {
/* 552 */       defaultText = element.getText();
/*     */     }
/* 554 */     return defaultText;
/*     */   }
/*     */ 
/*     */   public static void main(String[] arg)
/*     */   {
/* 560 */     ChangeToPdf("D:\\pdftest\\xml\\634160979311206822598_\u7EED\u5E74\u5EA6\u6838\u4FDD\u544A\u77E5\u4E66.rdx", "D:\\pdftest\\out\\634160979311206822598_\u7EED\u5E74\u5EA6\u6838\u4FDD\u544A\u77E5\u4E66.pdf");
/*     */   }
/*     */ 
/*     */   public static String rightTrim(String str)
/*     */   {
/* 567 */     int end = str.indexOf(str.trim());
/* 568 */     str = str.substring(0, end + str.trim().length());
/* 569 */     return str;
/*     */   }
/*     */ 
/*     */   public static String leftTrim(String str) {
/* 573 */     int end = str.indexOf(str.trim());
/* 574 */     str = str.substring(end, str.length());
/*     */ 
/* 576 */     return str;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.pdf.Rdx2Pdf
 * JD-Core Version:    0.6.0
 */