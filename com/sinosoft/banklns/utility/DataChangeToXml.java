/*     */ package com.sinosoft.banklns.utility;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.jdom.Document;
/*     */ import org.jdom.Element;
/*     */ import org.jdom.output.Format;
/*     */ import org.jdom.output.XMLOutputter;
/*     */ 
/*     */ public class DataChangeToXml
/*     */ {
/*  19 */   private String flag = "";
/*     */ 
/*  22 */   private String tipmsg = "";
/*     */ 
/*  25 */   private Set options = new HashSet();
/*     */ 
/*  28 */   private Set initValues = new HashSet();
/*     */ 
/*  31 */   private Set showOrHide = new HashSet();
/*     */ 
/*  34 */   private Set changeObjectInnerHtml = new HashSet();
/*     */ 
/*  37 */   private Set changeObjectInnerText = new HashSet();
/*     */ 
/*  40 */   private Set changeObjectClassName = new HashSet();
/*     */ 
/*  43 */   private Set tableData = new HashSet();
/*     */ 
/*  46 */   private Set autoCompleteData = new HashSet();
/*     */ 
/*     */   public void addOptions(String controlId, String value)
/*     */   {
/*  51 */     String[] keyvalue = new String[2];
/*  52 */     keyvalue[0] = controlId;
/*  53 */     keyvalue[1] = value;
/*  54 */     this.options.add(keyvalue);
/*     */   }
/*     */ 
/*     */   public void addOptions(String[][] keyAndOptionsvalue)
/*     */   {
/*  59 */     for (int i = 0; (keyAndOptionsvalue != null) && 
/*  60 */       (keyAndOptionsvalue.length > 0) && (
/*  61 */       i < keyAndOptionsvalue.length); )
/*     */     {
/*  62 */       this.options.add(keyAndOptionsvalue[i]);
/*     */ 
/*  61 */       i++;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void addInitValues(String controlId, String value)
/*     */   {
/*  68 */     String[] keyvalue = new String[2];
/*  69 */     keyvalue[0] = controlId;
/*  70 */     keyvalue[1] = value;
/*  71 */     this.initValues.add(keyvalue);
/*     */   }
/*     */ 
/*     */   public void addInitValues(String[][] keyValue)
/*     */   {
/*  76 */     for (int i = 0; (keyValue != null) && (keyValue.length > 0) && (
/*  77 */       i < keyValue.length); )
/*     */     {
/*  78 */       this.initValues.add(keyValue[i]);
/*     */ 
/*  77 */       i++;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void addShowOrHide(String controlId, String value)
/*     */   {
/*  84 */     String[] keyvalue = new String[2];
/*  85 */     keyvalue[0] = controlId;
/*  86 */     keyvalue[1] = value;
/*  87 */     this.showOrHide.add(keyvalue);
/*     */   }
/*     */ 
/*     */   public void addShowOrHide(String[][] keyValue)
/*     */   {
/*  92 */     for (int i = 0; (keyValue != null) && (keyValue.length > 0) && (
/*  93 */       i < keyValue.length); )
/*     */     {
/*  94 */       this.showOrHide.add(keyValue[i]);
/*     */ 
/*  93 */       i++;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void addChangeObjectInnerHtml(String controlId, String value)
/*     */   {
/* 100 */     String[] keyvalue = new String[2];
/* 101 */     keyvalue[0] = controlId;
/* 102 */     keyvalue[1] = value;
/* 103 */     this.changeObjectInnerHtml.add(keyvalue);
/*     */   }
/*     */ 
/*     */   public void addChangeObjectInnerHtml(String[][] keyValue)
/*     */   {
/* 108 */     for (int i = 0; (keyValue != null) && (keyValue.length > 0) && (
/* 109 */       i < keyValue.length); )
/*     */     {
/* 110 */       this.changeObjectInnerHtml.add(keyValue[i]);
/*     */ 
/* 109 */       i++;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void addChangeObjectInnerText(String controlId, String value)
/*     */   {
/* 116 */     String[] keyvalue = new String[2];
/* 117 */     keyvalue[0] = controlId;
/* 118 */     keyvalue[1] = value;
/* 119 */     this.changeObjectInnerText.add(keyvalue);
/*     */   }
/*     */ 
/*     */   public void addChangeObjectInnerText(String[][] keyValue)
/*     */   {
/* 124 */     for (int i = 0; (keyValue != null) && (keyValue.length > 0) && (
/* 125 */       i < keyValue.length); )
/*     */     {
/* 126 */       this.changeObjectInnerText.add(keyValue[i]);
/*     */ 
/* 125 */       i++;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void addChangeObjectClassName(String controlId, String value)
/*     */   {
/* 132 */     String[] keyvalue = new String[2];
/* 133 */     keyvalue[0] = controlId;
/* 134 */     keyvalue[1] = value;
/* 135 */     this.changeObjectClassName.add(keyvalue);
/*     */   }
/*     */ 
/*     */   public void addChangeObjectClassName(String[][] keyValue)
/*     */   {
/* 140 */     for (int i = 0; (keyValue != null) && (keyValue.length > 0) && (
/* 141 */       i < keyValue.length); )
/*     */     {
/* 142 */       this.changeObjectClassName.add(keyValue[i]);
/*     */ 
/* 141 */       i++;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void addTableData(String[][] data, String tableId, int totalRecords, int totalPages, int currentPage, int recordsOfPage)
/*     */   {
/* 150 */     List list = new ArrayList();
/* 151 */     list.add(tableId);
/* 152 */     list.add(data);
/* 153 */     list.add(Integer.valueOf(totalRecords));
/* 154 */     list.add(Integer.valueOf(totalPages));
/* 155 */     list.add(Integer.valueOf(currentPage));
/* 156 */     list.add(Integer.valueOf(recordsOfPage));
/*     */ 
/* 158 */     this.tableData.add(list);
/*     */   }
/*     */ 
/*     */   public void addCompleteData(String autoId, String targetId, String textRelaControlId, String contentContentId, String[][] itemData)
/*     */   {
/* 166 */     List list = new ArrayList();
/* 167 */     list.add(autoId);
/* 168 */     list.add(targetId);
/* 169 */     list.add(textRelaControlId);
/* 170 */     list.add(contentContentId);
/* 171 */     list.add(itemData);
/*     */ 
/* 173 */     this.autoCompleteData.add(list);
/*     */   }
/*     */ 
/*     */   public void getResult(HttpServletResponse response)
/*     */   {
/* 181 */     Document doc = new Document();
/* 182 */     Element root = new Element("data");
/*     */ 
/* 184 */     root.setAttribute("flag", this.flag);
/* 185 */     root.setAttribute("tipmsg", this.tipmsg);
/*     */ 
/* 188 */     doc.setRootElement(root);
/*     */ 
/* 191 */     if (this.options.size() > 0) {
/* 192 */       Element initOptionsElement = new Element("initOptions");
/* 193 */       Iterator iterator = this.options.iterator();
/* 194 */       while (iterator.hasNext()) {
/* 195 */         String[] option = (String[])iterator.next();
/* 196 */         Element optionElement = new Element("Control");
/* 197 */         optionElement.setAttribute("id", option[0]);
/* 198 */         optionElement.setText(option[1]);
/* 199 */         initOptionsElement.addContent(optionElement);
/*     */       }
/* 201 */       root.addContent(initOptionsElement);
/*     */     }
/*     */ 
/* 206 */     if (this.initValues.size() > 0) {
/* 207 */       Element initValuesElement = new Element("initValues");
/* 208 */       Iterator iterator = this.initValues.iterator();
/* 209 */       while (iterator.hasNext()) {
/* 210 */         String[] option = (String[])iterator.next();
/* 211 */         Element controlElement = new Element("Control");
/* 212 */         controlElement.setAttribute("id", option[0]);
/* 213 */         controlElement.setText(option[1]);
/* 214 */         initValuesElement.addContent(controlElement);
/*     */       }
/* 216 */       root.addContent(initValuesElement);
/*     */     }
/*     */ 
/* 220 */     if (this.showOrHide.size() > 0) {
/* 221 */       Element showOrHideElement = new Element("showOrHides");
/* 222 */       Iterator iterator = this.showOrHide.iterator();
/* 223 */       while (iterator.hasNext()) {
/* 224 */         String[] option = (String[])iterator.next();
/* 225 */         Element objectElement = new Element("Object");
/* 226 */         objectElement.setAttribute("id", option[0]);
/* 227 */         objectElement.setText(option[1]);
/* 228 */         showOrHideElement.addContent(objectElement);
/*     */       }
/* 230 */       root.addContent(showOrHideElement);
/*     */     }
/*     */ 
/* 234 */     if (this.changeObjectInnerHtml.size() > 0) {
/* 235 */       Element changeObjectInnerHtmlElement = new Element(
/* 236 */         "changeObjectInnerHtmls");
/* 237 */       Iterator iterator = this.changeObjectInnerHtml.iterator();
/* 238 */       while (iterator.hasNext()) {
/* 239 */         String[] option = (String[])iterator.next();
/* 240 */         Element objectElement = new Element("Object");
/* 241 */         objectElement.setAttribute("id", option[0]);
/* 242 */         objectElement.setText(option[1]);
/* 243 */         changeObjectInnerHtmlElement.addContent(objectElement);
/*     */       }
/* 245 */       root.addContent(changeObjectInnerHtmlElement);
/*     */     }
/*     */ 
/* 249 */     if (this.changeObjectInnerText.size() > 0) {
/* 250 */       Element changeObjectInnerTextElement = new Element(
/* 251 */         "changeObjectInnerTexts");
/* 252 */       Iterator iterator = this.changeObjectInnerText.iterator();
/* 253 */       while (iterator.hasNext()) {
/* 254 */         String[] option = (String[])iterator.next();
/* 255 */         Element objectElement = new Element("Object");
/* 256 */         objectElement.setAttribute("id", option[0]);
/* 257 */         objectElement.setText(option[1]);
/* 258 */         changeObjectInnerTextElement.addContent(objectElement);
/*     */       }
/* 260 */       root.addContent(changeObjectInnerTextElement);
/*     */     }
/*     */ 
/* 264 */     if (this.changeObjectClassName.size() > 0) {
/* 265 */       Element changeObjectClassNameElement = new Element(
/* 266 */         "changeObjectClassNames");
/* 267 */       Iterator iterator = this.changeObjectClassName.iterator();
/* 268 */       while (iterator.hasNext()) {
/* 269 */         String[] option = (String[])iterator.next();
/* 270 */         Element objectElement = new Element("Object");
/* 271 */         objectElement.setAttribute("id", option[0]);
/* 272 */         objectElement.setText(option[1]);
/* 273 */         changeObjectClassNameElement.addContent(objectElement);
/*     */       }
/* 275 */       root.addContent(changeObjectClassNameElement);
/*     */     }
/*     */ 
/* 280 */     if (this.tableData.size() > 0) {
/* 281 */       Element changeTableDataElement = new Element("changeTableData");
/* 282 */       Iterator iterator = this.tableData.iterator();
/* 283 */       while (iterator.hasNext()) {
/* 284 */         List tableList = (List)iterator.next();
/* 285 */         String id = (String)tableList.get(0);
/* 286 */         int totalRecords = ((Integer)tableList.get(2)).intValue();
/* 287 */         int totalPages = ((Integer)tableList.get(3)).intValue();
/* 288 */         int currentPage = ((Integer)tableList.get(4)).intValue();
/* 289 */         int recordsOfPage = ((Integer)tableList.get(5)).intValue();
/*     */ 
/* 291 */         Element objectElement = new Element("table");
/* 292 */         objectElement.setAttribute("id", id);
/* 293 */         objectElement.setAttribute("totalRecords", totalRecords);
/* 294 */         objectElement.setAttribute("totalPages", totalPages);
/* 295 */         objectElement.setAttribute("currentPage", currentPage);
/* 296 */         objectElement.setAttribute("recordsOfPage", recordsOfPage);
/*     */ 
/* 300 */         String[][] tableData = (String[][])tableList.get(1);
/* 301 */         for (int j = 0; (tableData != null) && (tableData.length > j); j++) {
/* 302 */           Element eltTr = new Element("tr");
/* 303 */           String[] tdArray = tableData[j];
/*     */ 
/* 305 */           for (int k = 0; (tdArray != null) && (tdArray.length > k); k++) {
/* 306 */             Element eltTd = new Element("td");
/* 307 */             eltTd.setText(tdArray[k]);
/* 308 */             eltTr.addContent(eltTd);
/*     */           }
/* 310 */           objectElement.addContent(eltTr);
/*     */         }
/*     */ 
/* 313 */         changeTableDataElement.addContent(objectElement);
/*     */       }
/*     */ 
/* 316 */       root.addContent(changeTableDataElement);
/*     */     }
/*     */ 
/* 321 */     if (this.autoCompleteData.size() > 0) {
/* 322 */       Element autoCompleteObjsElement = new Element("autoCompleteObjs");
/* 323 */       Iterator iterator = this.autoCompleteData.iterator();
/* 324 */       while (iterator.hasNext()) {
/* 325 */         List tableList = (List)iterator.next();
/* 326 */         String autoId = (String)tableList.get(0);
/* 327 */         String targetId = (String)tableList.get(1);
/* 328 */         String textRelaControlId = (String)tableList.get(2);
/* 329 */         String contentContentId = (String)tableList.get(3);
/* 330 */         String[][] itemData = (String[][])tableList.get(4);
/*     */ 
/* 332 */         if (textRelaControlId == null) {
/* 333 */           textRelaControlId = "";
/*     */         }
/* 335 */         if (contentContentId == null) {
/* 336 */           contentContentId = "";
/*     */         }
/* 338 */         Element objectElement = new Element("Obejct");
/* 339 */         objectElement.setAttribute("autoId", autoId);
/* 340 */         objectElement.setAttribute("targetId", targetId);
/* 341 */         objectElement.setAttribute("textRelaControlId", textRelaControlId);
/* 342 */         objectElement.setAttribute("contentContentId", contentContentId);
/*     */ 
/* 346 */         for (int j = 0; (itemData != null) && (itemData.length > j); j++) {
/* 347 */           Element eltItem = new Element("Item");
/* 348 */           String[] itemArray = itemData[j];
/* 349 */           eltItem.setAttribute("text", itemArray[0]);
/* 350 */           eltItem.setAttribute("content", itemArray[1]);
/* 351 */           objectElement.addContent(eltItem);
/*     */         }
/* 353 */         autoCompleteObjsElement.addContent(objectElement);
/*     */       }
/* 355 */       root.addContent(autoCompleteObjsElement);
/*     */     }
/*     */ 
/* 360 */     XMLOutputter xmlOut = new XMLOutputter();
/*     */ 
/* 363 */     Format fmt = Format.getPrettyFormat();
/* 364 */     fmt.setIndent("    ");
/*     */ 
/* 366 */     fmt.setEncoding("UTF-8");
/*     */ 
/* 368 */     xmlOut.setFormat(fmt);
/*     */     try {
/* 370 */       response.resetBuffer();
/* 371 */       response.setContentType("text/xml");
/* 372 */       response.setCharacterEncoding("UTF-8");
/* 373 */       xmlOut.output(doc, response.getWriter());
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 386 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] agrs) {
/* 391 */     long start = new Date().getTime();
/* 392 */     DataChangeToXml trDataChangeToXml = new DataChangeToXml();
/*     */ 
/* 396 */     trDataChangeToXml.addInitValues("Age", "26");
/* 397 */     trDataChangeToXml.addOptions("Kai", "osd=ii&idas=asdak");
/*     */ 
/* 399 */     String[][] data = new String[3][4];
/* 400 */     for (int i = 0; i < 3; i++) {
/* 401 */       for (int j = 0; j < 4; j++) {
/* 402 */         data[i][j] = (i + "." + j);
/*     */       }
/*     */     }
/* 405 */     trDataChangeToXml.addTableData(data, "CustomTable", 12, 3, 1, 10);
/*     */ 
/* 408 */     long end = new Date().getTime();
/* 409 */     System.out.println("\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u65F6\u951F\u6212\uFF1A" + (end - start) + "ms");
/*     */   }
/*     */ 
/*     */   public void setErrormsg(String tipmsg) {
/* 413 */     this.tipmsg = tipmsg;
/*     */   }
/*     */ 
/*     */   public void setFlag(String flag) {
/* 417 */     this.flag = flag;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.DataChangeToXml
 * JD-Core Version:    0.6.0
 */