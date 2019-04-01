/*     */ package com.sinosoft.banklns.lnsmodel.util;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
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
/*     */ public class RiskElementDataToXML
/*     */ {
/*  15 */   private List initControlSet = new ArrayList();
/*     */ 
/*  18 */   private String riskCode = "";
/*     */ 
/*  21 */   private String riskName = "";
/*     */ 
/*  24 */   private String riskArticleURL = "";
/*     */ 
/*  27 */   private String riskRateUrl = "";
/*     */ 
/*  30 */   private String riskRules = "";
/*     */ 
/*  33 */   private List showOrHideList = new ArrayList();
/*     */ 
/*  36 */   private List relaControlCodeAndValueList = new ArrayList();
/*     */ 
/*  39 */   private Set initValues = new HashSet();
/*     */ 
/*     */   public void addShowOrHideControl(String controlCode, String dispaly)
/*     */   {
/*  43 */     if ((controlCode != null) && (controlCode.length() > 0)) {
/*  44 */       String[] temp = new String[2];
/*  45 */       temp[0] = controlCode;
/*  46 */       temp[1] = dispaly;
/*  47 */       this.showOrHideList.add(temp);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void addShowOrHideControls(String[][] showOrHideArray)
/*     */   {
/*  53 */     for (int i = 0; (showOrHideArray != null) && (showOrHideArray.length > 0); i++) {
/*  54 */       String[] temp = showOrHideArray[i];
/*  55 */       this.showOrHideList.add(temp);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void addInitValues(String controlId, String value)
/*     */   {
/*  62 */     String[] keyvalue = new String[2];
/*  63 */     keyvalue[0] = controlId;
/*  64 */     keyvalue[1] = value;
/*  65 */     this.initValues.add(keyvalue);
/*     */   }
/*     */ 
/*     */   public void addInitValues(String[][] keyValue)
/*     */   {
/*  70 */     for (int i = 0; (keyValue != null) && (keyValue.length > 0) && (
/*  71 */       i < keyValue.length); )
/*     */     {
/*  72 */       this.initValues.add(keyValue[i]);
/*     */ 
/*  71 */       i++;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void addRelaControlCodeAndValueList(String code, String type, String value, String readonly)
/*     */   {
/*  80 */     if ((code != null) && (code.length() > 0)) {
/*  81 */       String[] temp = new String[4];
/*  82 */       temp[0] = code;
/*  83 */       temp[1] = type;
/*  84 */       temp[2] = value;
/*  85 */       temp[3] = readonly;
/*  86 */       this.relaControlCodeAndValueList.add(temp);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void addRelaControlCodeAndValueLists(String[][] showOrHideArray)
/*     */   {
/*  92 */     for (int i = 0; (showOrHideArray != null) && (showOrHideArray.length > 0); i++) {
/*  93 */       String[] temp = showOrHideArray[i];
/*  94 */       this.relaControlCodeAndValueList.add(temp);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void addInitControlObject(String controlCode, String controlName, String controlType, String initValue, String prepareValue, String editable)
/*     */   {
/* 103 */     if ((controlCode == null) || (controlCode.length() == 0)) {
/* 104 */       return;
/*     */     }
/* 106 */     if ((controlName == null) || (controlName.length() == 0)) {
/* 107 */       controlName = "";
/*     */     }
/* 109 */     if ((controlType == null) || (controlType.length() == 0)) {
/* 110 */       controlType = "";
/*     */     }
/* 112 */     if ((initValue == null) || (initValue.length() == 0)) {
/* 113 */       initValue = "";
/*     */     }
/* 115 */     if ((prepareValue == null) || (prepareValue.length() == 0)) {
/* 116 */       prepareValue = "";
/*     */     }
/* 118 */     if ((editable == null) || (editable.length() == 0)) {
/* 119 */       editable = "";
/*     */     }
/*     */ 
/* 122 */     String[] controlObj = new String[6];
/* 123 */     controlObj[0] = controlCode;
/* 124 */     controlObj[1] = controlName;
/* 125 */     controlObj[2] = controlType;
/* 126 */     controlObj[3] = initValue;
/* 127 */     controlObj[4] = prepareValue;
/* 128 */     controlObj[5] = editable;
/* 129 */     this.initControlSet.add(controlObj);
/*     */   }
/*     */ 
/*     */   public void addInitControlObjects(String[][] controlArray) {
/* 133 */     for (int i = 0; (controlArray != null) && (controlArray.length > i); i++) {
/* 134 */       String[] temp = controlArray[i];
/* 135 */       this.initControlSet.add(temp);
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getRiskArticleURL() {
/* 140 */     return this.riskArticleURL;
/*     */   }
/*     */ 
/*     */   public void setRiskArticleURL(String riskArticleURL) {
/* 144 */     this.riskArticleURL = riskArticleURL;
/*     */   }
/*     */ 
/*     */   public String getRiskcode() {
/* 148 */     return this.riskCode;
/*     */   }
/*     */ 
/*     */   public void setRiskcode(String riskcode) {
/* 152 */     this.riskCode = riskcode;
/*     */   }
/*     */ 
/*     */   public String getRiskName() {
/* 156 */     return this.riskName;
/*     */   }
/*     */ 
/*     */   public void setRiskName(String riskName) {
/* 160 */     this.riskName = riskName;
/*     */   }
/*     */ 
/*     */   public String getRiskRateUrl() {
/* 164 */     return this.riskRateUrl;
/*     */   }
/*     */ 
/*     */   public void setRiskRateUrl(String riskRateUrl) {
/* 168 */     this.riskRateUrl = riskRateUrl;
/*     */   }
/*     */ 
/*     */   public String getRiskRules() {
/* 172 */     return this.riskRules;
/*     */   }
/*     */ 
/*     */   public void setRiskRules(String riskRules) {
/* 176 */     this.riskRules = riskRules;
/*     */   }
/*     */ 
/*     */   public void getResult(HttpServletResponse response)
/*     */   {
/* 184 */     Document doc = new Document();
/* 185 */     Element root = new Element("risk");
/*     */ 
/* 187 */     root.setAttribute("riskCode", this.riskCode);
/* 188 */     root.setAttribute("riskName", this.riskName);
/* 189 */     root.setAttribute("riskRules", this.riskRules);
/* 190 */     root.setAttribute("riskRateUrl", this.riskRateUrl);
/* 191 */     root.setAttribute("riskArticleURL", this.riskArticleURL);
/*     */ 
/* 195 */     doc.setRootElement(root);
/*     */ 
/* 199 */     if (this.initControlSet.size() > 0) {
/* 200 */       Element RiskElementData = new Element("ControlObjects");
/* 201 */       Iterator iterator = this.initControlSet.iterator();
/* 202 */       while (iterator.hasNext()) {
/* 203 */         String[] controlObj = (String[])iterator.next();
/* 204 */         Element objectElement = new Element("Control");
/* 205 */         for (int i = 0; i < controlObj.length; i++) {
/* 206 */           String value = controlObj[i];
/* 207 */           String name = "";
/* 208 */           switch (i) {
/*     */           case 0:
/* 210 */             name = "controlCode";
/*     */ 
/* 212 */             break;
/*     */           case 1:
/* 214 */             name = "controlName";
/*     */ 
/* 216 */             break;
/*     */           case 2:
/* 218 */             name = "controlType";
/*     */ 
/* 220 */             break;
/*     */           case 3:
/* 222 */             name = "initValue";
/*     */ 
/* 224 */             break;
/*     */           case 4:
/* 226 */             name = "prepareValue";
/*     */ 
/* 228 */             break;
/*     */           case 5:
/* 231 */             name = "editable";
/*     */           }
/*     */ 
/* 236 */           objectElement.setAttribute(name, value);
/*     */         }
/*     */ 
/* 239 */         RiskElementData.addContent(objectElement);
/*     */       }
/*     */ 
/* 243 */       root.addContent(RiskElementData);
/*     */     }
/*     */ 
/* 246 */     if (this.showOrHideList.size() > 0) {
/* 247 */       Element RiskElementData = new Element("HideOrShowObjects");
/* 248 */       Iterator iterator = this.showOrHideList.iterator();
/* 249 */       while (iterator.hasNext()) {
/* 250 */         String[] controlObj = (String[])iterator.next();
/* 251 */         Element objectElement = new Element("Control");
/* 252 */         for (int i = 0; i < controlObj.length; i++) {
/* 253 */           String value = controlObj[i];
/* 254 */           String name = "";
/* 255 */           switch (i) {
/*     */           case 0:
/* 257 */             name = "controlCode";
/*     */ 
/* 259 */             break;
/*     */           case 1:
/* 261 */             name = "controlValue";
/*     */           }
/*     */ 
/* 266 */           objectElement.setAttribute(name, value);
/*     */         }
/*     */ 
/* 269 */         RiskElementData.addContent(objectElement);
/*     */       }
/* 271 */       root.addContent(RiskElementData);
/*     */     }
/*     */ 
/* 276 */     if (this.relaControlCodeAndValueList.size() > 0) {
/* 277 */       Element RiskElementData = new Element("RelaValidateObjects");
/* 278 */       Iterator iterator = this.relaControlCodeAndValueList.iterator();
/* 279 */       while (iterator.hasNext()) {
/* 280 */         String[] controlObj = (String[])iterator.next();
/* 281 */         Element objectElement = new Element("Control");
/* 282 */         for (int i = 0; i < controlObj.length; i++) {
/* 283 */           String value = controlObj[i];
/* 284 */           String name = "";
/* 285 */           switch (i) {
/*     */           case 0:
/* 287 */             name = "controlCode";
/*     */ 
/* 289 */             break;
/*     */           case 1:
/* 291 */             name = "controlType";
/*     */ 
/* 293 */             break;
/*     */           case 2:
/* 295 */             name = "controlValue";
/*     */ 
/* 297 */             break;
/*     */           case 3:
/* 299 */             name = "readOnly";
/*     */           }
/*     */ 
/* 304 */           objectElement.setAttribute(name, value);
/*     */         }
/*     */ 
/* 307 */         RiskElementData.addContent(objectElement);
/*     */       }
/* 309 */       root.addContent(RiskElementData);
/*     */     }
/*     */ 
/* 314 */     if (this.initValues.size() > 0) {
/* 315 */       Element initValuesElement = new Element("initValues");
/* 316 */       Iterator iterator = this.initValues.iterator();
/* 317 */       while (iterator.hasNext()) {
/* 318 */         String[] option = (String[])iterator.next();
/* 319 */         Element controlElement = new Element("Control");
/* 320 */         controlElement.setAttribute("id", option[0]);
/* 321 */         controlElement.setText(option[1]);
/* 322 */         initValuesElement.addContent(controlElement);
/*     */       }
/* 324 */       root.addContent(initValuesElement);
/*     */     }
/*     */ 
/* 329 */     XMLOutputter xmlOut = new XMLOutputter();
/*     */ 
/* 332 */     Format fmt = Format.getPrettyFormat();
/* 333 */     fmt.setIndent("    ");
/*     */ 
/* 335 */     fmt.setEncoding("UTF-8");
/*     */ 
/* 337 */     xmlOut.setFormat(fmt);
/*     */     try {
/* 339 */       response.resetBuffer();
/* 340 */       response.setContentType("text/xml");
/* 341 */       response.setCharacterEncoding("UTF-8");
/* 342 */       xmlOut.output(doc, response.getWriter());
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 354 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.util.RiskElementDataToXML
 * JD-Core Version:    0.6.0
 */