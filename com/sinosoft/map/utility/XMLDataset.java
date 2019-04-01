/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.Vector;
/*     */ import org.jdom.Element;
/*     */ 
/*     */ public class XMLDataset
/*     */ {
/*     */   private Element _Element;
/*  17 */   private CErrors mErrors = new CErrors();
/*     */ 
/*     */   protected XMLDataset()
/*     */   {
/*  21 */     this._Element = new Element("DATASET");
/*  22 */     if (!createControlInfo())
/*     */     {
/*  24 */       this._Element = null;
/*     */     }
/*     */   }
/*     */ 
/*     */   protected XMLDataset(Element element)
/*     */   {
/*  32 */     this._Element = element;
/*  33 */     if (!createControlInfo())
/*     */     {
/*  35 */       this._Element = null;
/*     */     }
/*     */   }
/*     */ 
/*     */   private boolean createControlInfo()
/*     */   {
/*  42 */     if (this._Element == null)
/*     */     {
/*  44 */       return false;
/*     */     }
/*     */ 
/*  47 */     Element elementControl = new Element("CONTROL");
/*     */ 
/*  49 */     this._Element.addContent(elementControl);
/*     */ 
/*  51 */     elementControl.addContent(new Element("CONTTYPE").addContent(""));
/*  52 */     elementControl.addContent(new Element("TEMPLATE").addContent(""));
/*  53 */     elementControl.addContent(new Element("PRINTER").addContent(""));
/*  54 */     elementControl.addContent(new Element("DISPLAY").addContent(""));
/*     */ 
/*  56 */     return true;
/*     */   }
/*     */ 
/*     */   public Element getElement()
/*     */   {
/*  63 */     if (this._Element == null)
/*     */     {
/*  65 */       return null;
/*     */     }
/*     */ 
/*  68 */     return (Element)this._Element.clone();
/*     */   }
/*     */ 
/*     */   public XMLDataset addDisplayControl(String strName)
/*     */   {
/*  75 */     if (this._Element == null)
/*     */     {
/*  77 */       return null;
/*     */     }
/*     */ 
/*  80 */     Element elementControl = this._Element.getChild("CONTROL").getChild(
/*  81 */       "DISPLAY");
/*  82 */     elementControl.addContent(new Element(strName).addContent("1"));
/*     */ 
/*  84 */     return this;
/*     */   }
/*     */ 
/*     */   public XMLDataset setTemplate(String strTemplate)
/*     */   {
/*  91 */     if (this._Element == null)
/*     */     {
/*  93 */       return null;
/*     */     }
/*     */ 
/*  96 */     this._Element.getChild("CONTROL").getChild("TEMPLATE").setText(strTemplate);
/*  97 */     return this;
/*     */   }
/*     */ 
/*     */   public XMLDataset setPrinter(String strPrinter)
/*     */   {
/* 104 */     if (this._Element == null)
/*     */     {
/* 106 */       return null;
/*     */     }
/*     */ 
/* 109 */     this._Element.getChild("CONTROL").getChild("PRINTER").setText(strPrinter);
/* 110 */     return this;
/*     */   }
/*     */ 
/*     */   public XMLDataset setContType(String strContType)
/*     */   {
/* 116 */     if (this._Element == null)
/*     */     {
/* 118 */       return null;
/*     */     }
/*     */ 
/* 121 */     this._Element.getChild("CONTROL").getChild("CONTTYPE").setText(strContType);
/* 122 */     return this;
/*     */   }
/*     */ 
/*     */   public boolean addDataObject(XMLDataObject xmlDataObject)
/*     */   {
/* 129 */     if (xmlDataObject.getDataObjectID().equals(""))
/*     */     {
/* 131 */       xmlDataObject.setDataObjectID("");
/*     */     }
/*     */ 
/* 134 */     return xmlDataObject.addDataTo(this._Element);
/*     */   }
/*     */ 
/*     */   public boolean addSchema(Schema schema)
/*     */   {
/* 141 */     this.mErrors.clearErrors();
/*     */ 
/* 143 */     if (schema == null)
/*     */     {
/* 145 */       buildError("addSchema", "\u53C2\u6570\u4E3A\u7A7A");
/* 146 */       return false;
/*     */     }
/*     */ 
/* 150 */     if (schema.getClass().getSuperclass().getName().equals(
/* 150 */       "com.sinosoft.map.lis.Schema"))
/*     */     {
/* 152 */       buildError("addSchema", "\u53C2\u6570\u4E0D\u662FSchema\u7684\u76F4\u63A5\u5B50\u7C7B");
/* 153 */       return false;
/*     */     }
/*     */ 
/* 156 */     String strClassName = schema.getClass().getName();
/*     */ 
/* 159 */     strClassName = strClassName.substring(strClassName.lastIndexOf(".") + 1);
/*     */ 
/* 162 */     strClassName = strClassName.substring(0, strClassName.indexOf("Schema"));
/*     */ 
/* 164 */     Field[] fields = schema.getClass().getDeclaredFields();
/*     */ 
/* 166 */     for (int nIndex = 0; nIndex < fields.length; nIndex++)
/*     */     {
/* 168 */       String strFieldName = fields[nIndex].getName();
/*     */ 
/* 170 */       if ((strFieldName.equals("FIELDNUM")) || (strFieldName.equals("PK")) || 
/* 171 */         (strFieldName.equals("mErrors")) || 
/* 172 */         (strFieldName.equals("fDate")))
/*     */       {
/*     */         continue;
/*     */       }
/*     */ 
/* 177 */       String strFieldType = fields[nIndex].getType().getName();
/* 178 */       String strFieldValue = schema.getV(strFieldName);
/*     */ 
/* 180 */       if ((strFieldType.equals("float")) && (!strFieldValue.equals("-100.0")))
/*     */       {
/* 182 */         this._Element.addContent(
/* 183 */           new Element(strClassName + "." + 
/* 183 */           strFieldName).addContent(
/* 184 */           strFieldValue));
/*     */       }
/* 187 */       else if ((strFieldType.equals("int")) && (!strFieldValue.equals("-100")))
/*     */       {
/* 189 */         this._Element.addContent(
/* 190 */           new Element(strClassName + "." + 
/* 190 */           strFieldName).addContent(
/* 191 */           strFieldValue));
/*     */       }
/* 194 */       else if ((strFieldType.equals("double")) && 
/* 195 */         (!strFieldValue.equals("-100")))
/*     */       {
/* 197 */         this._Element.addContent(
/* 198 */           new Element(strClassName + "." + 
/* 198 */           strFieldName).addContent(
/* 199 */           strFieldValue));
/*     */       }
/* 202 */       else if ((strFieldType.equals("java.lang.String")) && 
/* 203 */         (!strFieldValue.equals("null")))
/*     */       {
/* 205 */         this._Element.addContent(
/* 206 */           new Element(strClassName + "." + 
/* 206 */           strFieldName).addContent(
/* 207 */           strFieldValue));
/*     */       }
/* 210 */       else if ((strFieldType.equals("java.util.Date")) && 
/* 211 */         (!strFieldValue.equals("null")))
/*     */       {
/* 213 */         if (strFieldValue.indexOf('-') != -1)
/*     */         {
/* 215 */           strFieldValue = strFieldValue.substring(0, 4) + "\u5E74" + 
/* 216 */             strFieldValue.substring(5, 7) + "\u6708" + 
/* 217 */             strFieldValue.substring(8, 10) + "\u65E5";
/*     */         }
/* 219 */         this._Element.addContent(
/* 220 */           new Element(strClassName + "." + 
/* 220 */           strFieldName).addContent(
/* 221 */           strFieldValue));
/*     */       }
/*     */       else
/*     */       {
/* 226 */         this._Element.addContent(
/* 227 */           new Element(strClassName + "." + 
/* 227 */           strFieldName).addContent(""));
/*     */       }
/*     */     }
/*     */ 
/* 231 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean addSchemaSet(SchemaSet schemaSet, String strID)
/*     */   {
/* 238 */     this.mErrors.clearErrors();
/*     */ 
/* 240 */     if ((schemaSet == null) || (strID == null))
/*     */     {
/* 242 */       buildError("addSchemaSet", "\u53C2\u6570\u6709\u9519");
/* 243 */       return false;
/*     */     }
/*     */ 
/* 247 */     if (schemaSet.getClass().getSuperclass().getName().equals(
/* 247 */       "com.sinosoft.map.lis.SchemaSet"))
/*     */     {
/* 249 */       buildError("addSchemaSet", "\u53C2\u6570\u4E0D\u662FSchemaSet\u7684\u76F4\u63A5\u5B50\u7C7B");
/* 250 */       return false;
/*     */     }
/*     */ 
/* 253 */     String strClassName = schemaSet.getClass().getName();
/*     */ 
/* 256 */     strClassName = strClassName.substring(strClassName.lastIndexOf(".") + 1);
/*     */ 
/* 259 */     strClassName = strClassName.substring(0, strClassName.indexOf("Set"));
/*     */ 
/* 261 */     Element eleList = null;
/*     */ 
/* 263 */     if (strID.equals(""))
/*     */     {
/* 265 */       eleList = new Element(strClassName);
/*     */     }
/*     */     else
/*     */     {
/* 269 */       eleList = new Element(strID);
/*     */     }
/*     */ 
/* 272 */     this._Element.addContent(eleList);
/*     */ 
/* 275 */     strClassName = "com.sinosoft.map.lis.schema." + strClassName + "Schema";
/* 276 */     Field[] fields = null;
/*     */ 
/* 278 */     Vector vFields = new Vector();
/*     */     try
/*     */     {
/* 282 */       fields = Class.forName(strClassName).getDeclaredFields();
/*     */     }
/*     */     catch (ClassNotFoundException ex)
/*     */     {
/* 286 */       buildError("addSchemaSet", "\u627E\u4E0D\u5230\u5BF9\u5E94\u7684Schema\u7C7B");
/* 287 */       return false;
/*     */     }
/*     */ 
/* 290 */     Element eleHead = new Element("HEAD");
/* 291 */     eleList.addContent(eleHead);
/*     */ 
/* 293 */     String strColName = "";
/* 294 */     int nColNum = 0;
/*     */ 
/* 297 */     for (int nIndex = 0; nIndex < fields.length; nIndex++)
/*     */     {
/* 299 */       String strFieldName = fields[nIndex].getName();
/*     */ 
/* 301 */       if ((strFieldName.equals("FIELDNUM")) || (strFieldName.equals("PK")) || 
/* 302 */         (strFieldName.equals("mErrors")) || 
/* 303 */         (strFieldName.equals("fDate")))
/*     */       {
/*     */         continue;
/*     */       }
/*     */ 
/* 309 */       strColName = "COL" + String.valueOf(nColNum++);
/* 310 */       eleHead.addContent(new Element(strColName).addContent(
/* 311 */         strFieldName));
/* 312 */       vFields.add(fields[nIndex]);
/*     */     }
/*     */ 
/* 317 */     for (int nIndex = 0; nIndex < schemaSet.size(); nIndex++)
/*     */     {
/* 320 */       Element eleRow = new Element("ROW");
/* 321 */       eleList.addContent(eleRow);
/*     */ 
/* 323 */       Schema schema = (Schema)schemaSet.getObj(nIndex + 1);
/*     */ 
/* 325 */       nColNum = 0;
/* 326 */       for (int nCols = 0; nCols < vFields.size(); nCols++)
/*     */       {
/* 328 */         String strFieldName = ((Field)vFields.get(nCols)).getName();
/* 329 */         String strFieldType = ((Field)vFields.get(nCols)).getType()
/* 330 */           .getName();
/* 331 */         String strFieldValue = schema.getV(strFieldName);
/*     */ 
/* 333 */         strColName = "COL" + String.valueOf(nColNum++);
/* 334 */         if ((strFieldType.equals("float")) && 
/* 335 */           (!strFieldValue.equals("-100.0")))
/*     */         {
/* 337 */           eleRow.addContent(new Element(strColName).addContent(
/* 338 */             strFieldValue));
/*     */         }
/* 340 */         else if ((strFieldType.equals("double")) && 
/* 341 */           (!strFieldValue.equals("-100.0")))
/*     */         {
/* 343 */           eleRow.addContent(new Element(strColName).addContent(
/* 344 */             strFieldValue));
/*     */         }
/* 346 */         else if ((strFieldType.equals("int")) && 
/* 347 */           (!strFieldValue.equals("-100")))
/*     */         {
/* 349 */           eleRow.addContent(new Element(strColName).addContent(
/* 350 */             strFieldValue));
/*     */         }
/* 352 */         else if ((strFieldType.equals("java.lang.String")) && 
/* 353 */           (!strFieldValue.equals("null")))
/*     */         {
/* 355 */           eleRow.addContent(new Element(strColName).addContent(
/* 356 */             strFieldValue));
/*     */         }
/* 358 */         else if ((strFieldType.equals("java.util.Date")) && 
/* 359 */           (!strFieldValue.equals("null")))
/*     */         {
/* 361 */           if (strFieldValue.indexOf('-') != -1)
/*     */           {
/* 363 */             strFieldValue = strFieldValue.substring(0, 4) + "\u5E74" + 
/* 364 */               strFieldValue.substring(5, 7) + "\u6708" + 
/* 365 */               strFieldValue.substring(8, 10) + "\u65E5";
/*     */           }
/* 367 */           eleRow.addContent(new Element(strColName).addContent(
/* 368 */             strFieldValue));
/*     */         }
/*     */         else
/*     */         {
/* 372 */           eleRow.addContent(new Element(strColName).addContent(""));
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 380 */     return true;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */   {
/* 387 */     if (this._Element == null)
/*     */     {
/* 389 */       return null;
/*     */     }
/*     */ 
/* 392 */     return new XMLDataset(getElement());
/*     */   }
/*     */ 
/*     */   private void buildError(String szFunc, String szErrMsg)
/*     */   {
/* 398 */     CError cError = new CError();
/* 399 */     cError.moduleName = "XmlExportHelper";
/* 400 */     cError.functionName = szFunc;
/* 401 */     cError.errorMessage = szErrMsg;
/* 402 */     this.mErrors.addOneError(cError);
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.XMLDataset
 * JD-Core Version:    0.6.0
 */