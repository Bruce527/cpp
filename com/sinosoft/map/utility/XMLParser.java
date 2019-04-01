/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ import com.lowagie.text.xml.XmlParser;
/*     */ import com.sinosoft.map.style.pdf.OnlyTableBodyStyle;
/*     */ import com.sinosoft.map.style.pdf.TableHeadStyle;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ import org.w3c.dom.Text;
/*     */ import org.xml.sax.SAXException;
/*     */ 
/*     */ public class XMLParser
/*     */ {
/*  24 */   private static final Logger logger = Logger.getLogger(XMLParser.class);
/*     */ 
/*     */   public static TransferData getHeader(String filePath)
/*     */   {
/*  28 */     TransferData rTransferData = new TransferData();
/*  29 */     List headers = new LinkedList();
/*  30 */     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
/*     */     try {
/*  32 */       DocumentBuilder builder = factory.newDocumentBuilder();
/*  33 */       Document document = builder.parse(new File(filePath));
/*  34 */       Element config = document.getDocumentElement();
/*  35 */       if (logger.isDebugEnabled()) {
/*  36 */         logger.debug("getHeader(String) - the root element is " + 
/*  37 */           config.getTagName());
/*     */       }
/*  39 */       NodeList headerList = config.getElementsByTagName("header");
/*  40 */       Header head = null;
/*     */ 
/*  42 */       for (int i = 0; i < headerList.getLength(); i++) {
/*  43 */         headers.add(null);
/*     */       }
/*     */ 
/*  46 */       for (int i = 0; i < headerList.getLength(); i++) {
/*  47 */         Element header = (Element)headerList.item(i);
/*  48 */         String name = getTagContent(header, "name", "\u6CA1\u6709\u8868\u5934\u540D\u5B57");
/*  49 */         String row = getTagContent(header, "row", "");
/*  50 */         String col = getTagContent(header, "col", "0");
/*  51 */         String order = getTagContent(header, "order", "0");
/*  52 */         String excit = getTagContent(header, "excit", "0");
/*  53 */         String parentIndex = getTagContent(header, "parentIndex", "-1");
/*  54 */         String codeName = getTagContent(header, "codeName", "null");
/*  55 */         head = new Header();
/*  56 */         head.setName(name);
/*  57 */         head.setCol(Integer.parseInt(col));
/*  58 */         head.setRow(Integer.parseInt(row));
/*  59 */         head.setOrder(Integer.parseInt(order));
/*  60 */         head.setExcit(Integer.parseInt(excit));
/*  61 */         head.setParentIndex(Integer.parseInt(parentIndex));
/*  62 */         head.setCodeName(codeName);
/*  63 */         int orderflag = Integer.parseInt(order) - 1;
/*  64 */         if (logger.isDebugEnabled()) {
/*  65 */           logger
/*  66 */             .debug("getHeader(String) - enter xml parse value----" + 
/*  67 */             name + 
/*  68 */             "t" + 
/*  69 */             row + 
/*  70 */             "t" + 
/*  71 */             col + 
/*  72 */             "t" + 
/*  73 */             order);
/*     */         }
/*  75 */         if (orderflag > headers.size()) {
/*  76 */           if (!logger.isDebugEnabled()) continue;
/*  77 */           logger
/*  78 */             .debug("getHeader(String) - \u89E3\u6790XML\u51FA\u9519\uFF1A\u8BBE\u7F6E\u7684\u987A\u5E8F\u53F7\u5E94\u8BE5\u5C0F\u4E8E\u6574\u4F53header\u7684\u4E2A\u6570\u3002\u51FA\u9519\u6587\u4EF6\u4E3A\uFF1A" + 
/*  79 */             filePath);
/*     */         }
/*     */         else {
/*  82 */           headers.set(orderflag, head);
/*     */         }
/*     */       }
/*     */ 
/*  86 */       if (logger.isDebugEnabled()) {
/*  87 */         logger.debug("getHeader(String) - after sort---------");
/*     */       }
/*     */ 
/*  90 */       String colNum = getTagContent(config, "colnum", "0");
/*  91 */       String width = getTagContent(config, "width", "0");
/*  92 */       String[] widths = getTagContent(config, "widths", "2f,2f").split(",");
/*  93 */       String borderwidth = getTagContent(config, "borderwidth", "0");
/*  94 */       String fontname = getTagContent(config, "fontname", "0");
/*  95 */       String[] fontcolor = null;
/*  96 */       if (getTagContent(config, "fontcolor", null) != null) {
/*  97 */         fontcolor = getTagContent(config, "fontcolor", null).split(",");
/*     */       }
/*  99 */       String tablealign = getTagContent(config, "tablealign", "0");
/*     */ 
/* 101 */       rTransferData.setNameAndValue("Header", headers);
/* 102 */       rTransferData.setNameAndValue("ColMaxNumber", colNum);
/* 103 */       rTransferData.setNameAndValue("TableWidth", width);
/* 104 */       rTransferData.setNameAndValue("TableWidths", widths);
/* 105 */       rTransferData.setNameAndValue("BorderWidth", borderwidth);
/* 106 */       rTransferData.setNameAndValue("TableAlign", tablealign);
/* 107 */       rTransferData.setNameAndValue("FontName", fontname);
/* 108 */       rTransferData.setNameAndValue("FontColor", fontcolor);
/*     */     }
/*     */     catch (ParserConfigurationException e)
/*     */     {
/* 112 */       logger.error("getHeader(String)", e);
/*     */     }
/*     */     catch (IOException e) {
/* 115 */       logger.error("getHeader(String)", e);
/*     */     }
/*     */     catch (SAXException localSAXException) {
/*     */     }
/* 119 */     return rTransferData;
/*     */   }
/*     */ 
/*     */   public XmlTable getHeaderMap(String filePath)
/*     */   {
/* 126 */     XmlTable xmlTable = new XmlTable();
/* 127 */     TableHeadStyle tableHeadStyle = new TableHeadStyle();
/* 128 */     List headers = new LinkedList();
/* 129 */     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
/*     */     try {
/* 131 */       DocumentBuilder builder = factory.newDocumentBuilder();
/* 132 */       Document document = builder.parse(new File(filePath));
/* 133 */       Element config = document.getDocumentElement();
/* 134 */       if (logger.isDebugEnabled()) {
/* 135 */         logger.debug("getHeader(String) - the root element is " + 
/* 136 */           config.getTagName());
/*     */       }
/* 138 */       NodeList headerList = config.getElementsByTagName("header");
/* 139 */       Header head = null;
/*     */ 
/* 141 */       for (int i = 0; i < headerList.getLength(); i++) {
/* 142 */         headers.add(null);
/*     */       }
/*     */ 
/* 145 */       for (int i = 0; i < headerList.getLength(); i++) {
/* 146 */         Element header = (Element)headerList.item(i);
/* 147 */         String name = getTagContent(header, "name", "\u6CA1\u6709\u8868\u5934\u540D\u5B57");
/* 148 */         String row = getTagContent(header, "row", "");
/* 149 */         String col = getTagContent(header, "col", "0");
/* 150 */         String order = getTagContent(header, "order", "0");
/* 151 */         String wsorder = getTagContent(header, "wsorder", "-1");
/* 152 */         String excit = getTagContent(header, "excit", "0");
/* 153 */         String parentIndex = getTagContent(header, "parentindex", "-1");
/* 154 */         String codeName = getTagContent(header, "codename", "null");
/* 155 */         head = new Header();
/* 156 */         head.setName(name);
/* 157 */         head.setCol(Integer.parseInt(col));
/* 158 */         head.setRow(Integer.parseInt(row));
/* 159 */         head.setOrder(Integer.parseInt(order));
/* 160 */         head.setWsorder(Integer.parseInt(wsorder));
/* 161 */         head.setExcit(Integer.parseInt(excit));
/* 162 */         head.setParentIndex(Integer.parseInt(parentIndex));
/* 163 */         head.setCodeName(codeName);
/* 164 */         int orderflag = Integer.parseInt(order);
/* 165 */         if (logger.isDebugEnabled()) {
/* 166 */           logger
/* 167 */             .debug("getHeader(String) - enter xml parse value----" + 
/* 168 */             name + 
/* 169 */             "t" + 
/* 170 */             row + 
/* 171 */             "t" + 
/* 172 */             col + 
/* 173 */             "t" + 
/* 174 */             order);
/*     */         }
/* 176 */         if (orderflag > headers.size()) {
/* 177 */           if (!logger.isDebugEnabled()) continue;
/* 178 */           logger
/* 179 */             .debug("getHeader(String) - \u89E3\u6790XML\u51FA\u9519\uFF1A\u8BBE\u7F6E\u7684\u987A\u5E8F\u53F7\u5E94\u8BE5\u5C0F\u4E8E\u6574\u4F53header\u7684\u4E2A\u6570\u3002\u51FA\u9519\u6587\u4EF6\u4E3A\uFF1A" + 
/* 180 */             filePath);
/*     */         }
/*     */         else {
/* 183 */           headers.set(orderflag, head);
/*     */         }
/*     */       }
/*     */ 
/* 187 */       if (logger.isDebugEnabled()) {
/* 188 */         logger.debug("getHeader(String) - after sort---------");
/*     */       }
/* 190 */       String colNum = getTagContent(config, "colnum", "0");
/* 191 */       String width = getTagContent(config, "width", "0");
/* 192 */       String[] widths = getTagContent(config, "widths", "2f,2f").split(",");
/* 193 */       String borderwidth = getTagContent(config, "borderwidth", "0");
/* 194 */       String fontname = getTagContent(config, "fontname", "0");
/* 195 */       String[] fontColor = getTagContent(config, "fontcolor", "0,0,0").split(",");
/* 196 */       String[] BackColor = getTagContent(config, "fontcolor", "217,217,217").split(",");
/* 197 */       String tablealign = getTagContent(config, "tablealign", "0");
/* 198 */       xmlTable.setHeaders(headers);
/* 199 */       tableHeadStyle.setCol(Integer.parseInt(colNum));
/* 200 */       tableHeadStyle.setWidth(Float.parseFloat(width));
/* 201 */       tableHeadStyle.setWidths(CommonArray.stringToFloat(widths));
/* 202 */       tableHeadStyle.setBorder(Integer.parseInt(borderwidth));
/* 203 */       tableHeadStyle.setTableAlign(Integer.parseInt(tablealign));
/* 204 */       tableHeadStyle.setFontName(Integer.parseInt(fontname));
/* 205 */       int[] intfontcolor = CommonArray.stringToInt(fontColor);
/* 206 */       tableHeadStyle.setColor(intfontcolor[0], intfontcolor[1], intfontcolor[2]);
/* 207 */       int[] intBackcolor = CommonArray.stringToInt(BackColor);
/* 208 */       tableHeadStyle.setR(intBackcolor[0]);
/* 209 */       tableHeadStyle.setG(intBackcolor[0]);
/* 210 */       tableHeadStyle.setB(intBackcolor[0]);
/* 211 */       xmlTable.setTableHeadStyle(tableHeadStyle);
/*     */     }
/*     */     catch (ParserConfigurationException e) {
/* 214 */       logger.error("getHeader(String)", e);
/*     */     }
/*     */     catch (IOException e) {
/* 217 */       logger.error("getHeader(String)", e);
/*     */     } catch (Exception ex) {
/* 219 */       logger.error("getHeader(String)", ex);
/*     */     }
/*     */ 
/* 222 */     return xmlTable;
/*     */   }
/*     */ 
/*     */   public OnlyTableBodyStyle getbody(String filePath)
/*     */   {
/* 229 */     XmlParser xmlParser = new XmlParser();
/* 230 */     OnlyTableBodyStyle onlyTableBodyStyle = new OnlyTableBodyStyle();
/* 231 */     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
/*     */     try {
/* 233 */       DocumentBuilder builder = factory.newDocumentBuilder();
/* 234 */       Document document = builder.parse(new File(filePath));
/* 235 */       Element config = document.getDocumentElement();
/* 236 */       logger.debug("getbody(String) - the root element is " + 
/* 237 */         config.getTagName());
/* 238 */       logger.debug("getbody(String) - after sort---------");
/* 239 */       int colNum = Integer.parseInt(getTagContent(config, "colnum", "0"));
/* 240 */       onlyTableBodyStyle.setCol(colNum);
/* 241 */       int width = Integer.parseInt(getTagContent(config, "width", "100"));
/* 242 */       onlyTableBodyStyle.setWidth(width);
/* 243 */       if (getTagContent(config, "widths", null).split(",") != null) {
/* 244 */         String[] strAryWidths = getTagContent(config, "widths", null).split(
/* 245 */           ",");
/* 246 */         float[] fltAryWidths = new float[strAryWidths.length];
/* 247 */         for (int i = 0; i < strAryWidths.length; i++) {
/* 248 */           fltAryWidths[i] = Float.parseFloat(strAryWidths[i]);
/*     */         }
/*     */       }
/*     */ 
/* 252 */       int borderwidth = Integer.parseInt(getTagContent(config, 
/* 253 */         "borderwidth", "0"));
/* 254 */       onlyTableBodyStyle.setBorder(borderwidth);
/* 255 */       int Spadding = Integer.parseInt(getTagContent(config, 
/* 256 */         "Spadding", "0"));
/* 257 */       onlyTableBodyStyle.setSpacing(Spadding);
/*     */ 
/* 260 */       int fontname = Integer.parseInt(getTagContent(config, 
/* 261 */         "fontname", "0"));
/* 262 */       onlyTableBodyStyle.setFontName(fontname);
/*     */ 
/* 264 */       if (getTagContent(config, "fontcolor", null) != null) {
/* 265 */         String[] fontcolor = getTagContent(config, "fontcolor", null).split(
/* 266 */           ",");
/* 267 */         int[] intAryFontcolor = new int[3];
/* 268 */         for (int i = 0; i < fontcolor.length; i++) {
/* 269 */           intAryFontcolor[i] = Integer.parseInt(fontcolor[i]);
/*     */         }
/* 271 */         onlyTableBodyStyle.setColor(intAryFontcolor[0], 
/* 272 */           intAryFontcolor[1], intAryFontcolor[2]);
/*     */       }
/* 274 */       if (getTagContent(config, "tablealign", null) != null) {
/* 275 */         int tablealign = Integer.parseInt(getTagContent(config, 
/* 276 */           "tablealign", null));
/* 277 */         onlyTableBodyStyle.setAlign(tablealign);
/*     */       }
/*     */     }
/*     */     catch (ParserConfigurationException e)
/*     */     {
/* 282 */       logger.error("getbody(String)-\u8BFB\u53D6" + filePath + "\u5931\u8D25cinfig", e);
/*     */     }
/*     */     catch (IOException e) {
/* 285 */       logger.error("getbody(String)-\u8BFB\u53D6" + filePath + "\u5931\u8D25io", e);
/*     */     } catch (Exception ex) {
/* 287 */       logger.error("getHeader(String)", ex);
/*     */     }
/*     */ 
/* 290 */     return onlyTableBodyStyle;
/*     */   }
/*     */ 
/*     */   private int changeIntReadTag(String tagContent)
/*     */   {
/* 296 */     int reTagContect = -1;
/* 297 */     if (tagContent != null) {
/* 298 */       reTagContect = Integer.parseInt(tagContent);
/*     */     }
/* 300 */     return reTagContect;
/*     */   }
/*     */ 
/*     */   public static String read(String filePath)
/*     */   {
/* 305 */     TransferData rTransferData = new TransferData();
/* 306 */     List headers = new LinkedList();
/*     */ 
/* 308 */     String content = null;
/* 309 */     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
/*     */     try {
/* 311 */       DocumentBuilder builder = factory.newDocumentBuilder();
/* 312 */       Document document = builder.parse(new File(filePath));
/* 313 */       Element config = document.getDocumentElement();
/* 314 */       String name = getTagContentOne(config, "name");
/* 315 */       content = getTagContentOne(config, "content");
/* 316 */       if (content.trim().equals(""))
/* 317 */         content = null;
/*     */     }
/*     */     catch (ParserConfigurationException e)
/*     */     {
/* 321 */       logger.error("read(String)", e);
/*     */     }
/*     */     catch (IOException e) {
/* 324 */       logger.error("read(String)", e);
/*     */     }
/*     */     catch (SAXException localSAXException) {
/*     */     }
/* 328 */     return content;
/*     */   }
/*     */ 
/*     */   public static SSRS getHeaderContent(String filePath)
/*     */   {
/* 333 */     SSRS headers = null;
/* 334 */     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
/*     */     try
/*     */     {
/* 338 */       DocumentBuilder builder = factory.newDocumentBuilder();
/*     */ 
/* 341 */       Document document = builder.parse(new File(filePath));
/* 342 */       Element config = document.getDocumentElement();
/* 343 */       if (logger.isDebugEnabled()) {
/* 344 */         logger.debug("getHeaderContent(String) - the root element is " + 
/* 345 */           config.getTagName());
/*     */       }
/* 347 */       NodeList headerList = config.getElementsByTagName("header");
/*     */ 
/* 349 */       String colNum = getTagContent(config, "colnum", Integer.toString(headerList.getLength()));
/* 350 */       headers = new SSRS(Integer.parseInt(colNum));
/* 351 */       for (int i = 0; i < headerList.getLength(); i++) {
/* 352 */         Element header = (Element)headerList.item(i);
/* 353 */         String name = getTagContent(header, "name", "\u6CA1\u8BBE\u7F6E\u8868\u5934\u540D\u5B57");
/* 354 */         String order = getTagContent(header, "order", Integer.toString(i));
/* 355 */         int orderflag = Integer.parseInt(order) - 1;
/* 356 */         if (orderflag > headers.getMaxNumber()) {
/* 357 */           if (!logger.isDebugEnabled()) continue;
/* 358 */           logger
/* 359 */             .debug("getHeaderContent(String) - \u89E3\u6790XML\u51FA\u9519\uFF1A\u8BBE\u7F6E\u7684\u987A\u5E8F\u53F7\u5E94\u8BE5\u5C0F\u4E8E\u6574\u4F53header\u7684\u4E2A\u6570\u3002\u51FA\u9519\u6587\u4EF6\u4E3A\uFF1A" + 
/* 360 */             filePath);
/*     */         }
/*     */         else {
/* 363 */           headers.SetText(name);
/*     */         }
/*     */       }
/*     */ 
/* 367 */       if (logger.isDebugEnabled())
/* 368 */         logger.debug("getHeaderContent(String) - after sort---------");
/*     */     }
/*     */     catch (ParserConfigurationException e1)
/*     */     {
/* 372 */       logger.error("getHeaderContent(String)", e1);
/*     */     }
/*     */     catch (SAXException e) {
/* 375 */       logger.error("getHeaderContent(String)", e);
/*     */     }
/*     */     catch (IOException e) {
/* 378 */       logger.error("getHeaderContent(String)", e);
/*     */     }
/*     */ 
/* 381 */     return headers;
/*     */   }
/*     */ 
/*     */   public static String getTagContent(Element element, String tagName, String reInData) {
/* 385 */     NodeList list = element.getElementsByTagName(tagName);
/* 386 */     Node nameNode = list.item(0);
/* 387 */     if (nameNode == null) {
/* 388 */       if (logger.isDebugEnabled()) {
/* 389 */         logger.debug("getTagContent(Element, String) - \u89E3\u6790XML\u65F6\uFF0C" + 
/* 390 */           tagName + "\u7684\u503C\u4E3Anull\uFF01");
/*     */       }
/* 392 */       return reInData;
/*     */     }
/* 394 */     NodeList nodeList = nameNode.getChildNodes();
/* 395 */     Node node = nodeList.item(0);
/* 396 */     if ((node == null) || (node.getNodeValue() == null)) {
/* 397 */       return reInData;
/*     */     }
/* 399 */     return node.getNodeValue();
/*     */   }
/*     */ 
/*     */   public static String getTagContentOne(Element element, String tagName)
/*     */   {
/* 405 */     NodeList list = element.getElementsByTagName(tagName);
/* 406 */     Node nameNode = list.item(0);
/* 407 */     if (nameNode == null) {
/* 408 */       if (logger.isDebugEnabled()) {
/* 409 */         logger.debug("getTagContentOne(Element, String) - \u89E3\u6790XML\u65F6\uFF0C" + 
/* 410 */           tagName + "\u7684\u503C\u4E3Anull\uFF01");
/*     */       }
/* 412 */       return null;
/*     */     }
/* 414 */     NodeList nodeList = nameNode.getChildNodes();
/* 415 */     Node node = nodeList.item(0);
/* 416 */     String nodeValue = null;
/* 417 */     if (node.getNodeValue() == null) {
/* 418 */       return null;
/*     */     }
/* 420 */     if (node.getNodeValue().trim() != "") {
/* 421 */       nodeValue = node.getNodeValue();
/*     */     }
/* 423 */     return nodeValue;
/*     */   }
/*     */ 
/*     */   public static Element getElement(String filePath)
/*     */   {
/* 429 */     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
/* 430 */     DocumentBuilder builder = null;
/* 431 */     Document document = null;
/* 432 */     Element config = null;
/*     */     try {
/* 434 */       builder = factory.newDocumentBuilder();
/* 435 */       document = builder.parse(new File(filePath));
/* 436 */       config = document.getDocumentElement();
/*     */     }
/*     */     catch (ParserConfigurationException e) {
/* 439 */       e.printStackTrace();
/*     */     }
/*     */     catch (SAXException e) {
/* 442 */       e.printStackTrace();
/*     */     }
/*     */     catch (IOException e) {
/* 445 */       e.printStackTrace();
/*     */     }
/*     */ 
/* 451 */     return config;
/*     */   }
/*     */ 
/*     */   public static Element createElement(String root, String groupTagName, List content) {
/* 455 */     String[] tags = { "content", "size", "font", "style", "align", "isStart", "isEnd", "space" };
/*     */ 
/* 457 */     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
/* 458 */     DocumentBuilder builder = null;
/* 459 */     Document document = null;
/* 460 */     Element config = null;
/*     */     try {
/* 462 */       builder = factory.newDocumentBuilder();
/* 463 */       document = builder.newDocument();
/* 464 */       config = document.createElement(root);
/* 465 */       Element element = null;
/* 466 */       TransferData prop = null;
/*     */ 
/* 468 */       for (int i = 0; i < content.size(); i++) {
/* 469 */         element = document.createElement(groupTagName);
/* 470 */         config.appendChild(element);
/* 471 */         prop = (TransferData)content.get(i);
/*     */ 
/* 473 */         for (int j = 0; j < tags.length; j++) {
/* 474 */           appendElement(prop, tags[j], element, document);
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (ParserConfigurationException e)
/*     */     {
/* 481 */       e.printStackTrace();
/*     */     }
/*     */ 
/* 487 */     return config;
/*     */   }
/*     */ 
/*     */   public static void appendElement(TransferData prop, String tagName, Element fatherElement, Document doc) {
/* 491 */     String content = (String)prop.getValueByName(tagName);
/* 492 */     Element element = doc.createElement(tagName);
/* 493 */     fatherElement.appendChild(element);
/* 494 */     Text text = doc.createTextNode(content);
/* 495 */     element.appendChild(text);
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.XMLParser
 * JD-Core Version:    0.6.0
 */