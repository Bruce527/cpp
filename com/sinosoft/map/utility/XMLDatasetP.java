/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.Vector;
/*     */ import org.jdom.Element;
/*     */ 
/*     */ public class XMLDatasetP
/*     */ {
/*     */   private Element _Element;
/*  17 */   private CErrors mErrors = new CErrors();
/*     */ 
/*     */   protected XMLDatasetP()
/*     */   {
/*  21 */     this._Element = new Element("DATASET");
/*  22 */     if (!createControlInfo())
/*     */     {
/*  24 */       this._Element = null;
/*     */     }
/*     */   }
/*     */ 
/*     */   protected XMLDatasetP(Element element)
/*     */   {
/*  32 */     this._Element = element;
/*  33 */     if (!createControlInfo())
/*     */     {
/*  35 */       this._Element = null;
/*     */     }
/*     */   }
/*     */ 
/*     */   private static boolean createControlInfo()
/*     */   {
/*  53 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean createFileListName(String FilePath)
/*     */   {
/*  58 */     if (this._Element == null)
/*     */     {
/*  60 */       return false;
/*     */     }
/*     */ 
/*  63 */     Element elementFile = new Element("file");
/*     */ 
/*  65 */     this._Element.addContent(elementFile);
/*     */ 
/*  67 */     FileViewer f = new FileViewer();
/*  68 */     f.setPath(FilePath);
/*  69 */     f.refreshList();
/*  70 */     while (f.nextFile())
/*     */     {
/*  72 */       Element elementRow = new Element("row");
/*  73 */       elementFile.addContent(elementRow);
/*  74 */       Element elementName = new Element("name");
/*  75 */       elementRow.addContent(elementName.addContent(f.getFileName()));
/*     */     }
/*     */ 
/*  84 */     return true;
/*     */   }
/*     */ 
/*     */   public Element getElement()
/*     */   {
/*  91 */     if (this._Element == null)
/*     */     {
/*  93 */       return null;
/*     */     }
/*     */ 
/*  96 */     return (Element)this._Element.clone();
/*     */   }
/*     */ 
/*     */   public XMLDatasetP addDisplayControl(String strName)
/*     */   {
/* 103 */     if (this._Element == null)
/*     */     {
/* 105 */       return null;
/*     */     }
/*     */ 
/* 108 */     Element elementControl = this._Element.getChild("CONTROL").getChild(
/* 109 */       "DISPLAY");
/* 110 */     elementControl.addContent(new Element(strName).addContent("1"));
/*     */ 
/* 112 */     return this;
/*     */   }
/*     */ 
/*     */   public XMLDatasetP setTemplate(String strTemplate)
/*     */   {
/* 119 */     if (this._Element == null)
/*     */     {
/* 121 */       return null;
/*     */     }
/*     */ 
/* 124 */     this._Element.getChild("CONTROL").getChild("TEMPLATE").setText(strTemplate);
/* 125 */     return this;
/*     */   }
/*     */ 
/*     */   public XMLDatasetP setPrinter(String strPrinter)
/*     */   {
/* 132 */     if (this._Element == null)
/*     */     {
/* 134 */       return null;
/*     */     }
/*     */ 
/* 137 */     this._Element.getChild("CONTROL").getChild("PRINTER").setText(strPrinter);
/* 138 */     return this;
/*     */   }
/*     */ 
/*     */   public boolean addDataObject(XMLDataObject xmlDataObject)
/*     */   {
/* 146 */     if (xmlDataObject.getDataObjectID().equals(""))
/*     */     {
/* 148 */       xmlDataObject.setDataObjectID("");
/*     */     }
/*     */ 
/* 151 */     return xmlDataObject.addDataTo(this._Element);
/*     */   }
/*     */ 
/*     */   public boolean addSchema(Schema schema)
/*     */   {
/* 158 */     this.mErrors.clearErrors();
/*     */ 
/* 160 */     if (schema == null)
/*     */     {
/* 162 */       buildError("addSchema", "\u53C2\u6570\u4E3A\u7A7A");
/* 163 */       return false;
/*     */     }
/*     */ 
/* 167 */     if (schema.getClass().getSuperclass().getName().equals(
/* 167 */       "com.sinosoft.map.lis.Schema"))
/*     */     {
/* 169 */       buildError("addSchema", "\u53C2\u6570\u4E0D\u662FSchema\u7684\u76F4\u63A5\u5B50\u7C7B");
/* 170 */       return false;
/*     */     }
/*     */ 
/* 173 */     String strClassName = schema.getClass().getName();
/*     */ 
/* 176 */     strClassName = strClassName.substring(strClassName.lastIndexOf(".") + 1);
/*     */ 
/* 179 */     strClassName = strClassName.substring(0, strClassName.indexOf("Schema"));
/*     */ 
/* 181 */     Field[] fields = schema.getClass().getDeclaredFields();
/*     */ 
/* 183 */     for (int nIndex = 0; nIndex < fields.length; nIndex++)
/*     */     {
/* 185 */       String strFieldName = fields[nIndex].getName();
/*     */ 
/* 187 */       if ((strFieldName.equals("FIELDNUM")) || (strFieldName.equals("PK")) || 
/* 188 */         (strFieldName.equals("mErrors")) || 
/* 189 */         (strFieldName.equals("fDate")))
/*     */       {
/*     */         continue;
/*     */       }
/*     */ 
/* 194 */       String strFieldType = fields[nIndex].getType().getName();
/* 195 */       String strFieldValue = schema.getV(strFieldName);
/*     */ 
/* 197 */       if ((strFieldType.equals("float")) && (!strFieldValue.equals("-100.0")))
/*     */       {
/* 199 */         this._Element.addContent(
/* 200 */           new Element(strClassName + "." + 
/* 200 */           strFieldName)
/* 201 */           .addContent(strFieldValue));
/*     */       }
/* 204 */       else if ((strFieldType.equals("int")) && (!strFieldValue.equals("-100")))
/*     */       {
/* 206 */         this._Element.addContent(
/* 207 */           new Element(strClassName + "." + 
/* 207 */           strFieldName)
/* 208 */           .addContent(strFieldValue));
/*     */       }
/* 211 */       else if ((strFieldType.equals("double")) && 
/* 212 */         (!strFieldValue.equals("-100")))
/*     */       {
/* 214 */         this._Element.addContent(
/* 215 */           new Element(strClassName + "." + 
/* 215 */           strFieldName)
/* 216 */           .addContent(strFieldValue));
/*     */       }
/* 219 */       else if ((strFieldType.equals("java.lang.String")) && 
/* 220 */         (!strFieldValue.equals("null")))
/*     */       {
/* 222 */         this._Element.addContent(
/* 223 */           new Element(strClassName + "." + 
/* 223 */           strFieldName)
/* 224 */           .addContent(strFieldValue));
/*     */       }
/* 227 */       else if ((strFieldType.equals("java.util.Date")) && 
/* 228 */         (!strFieldValue.equals("null")))
/*     */       {
/* 230 */         if (strFieldValue.indexOf('-') != -1)
/*     */         {
/* 232 */           strFieldValue = strFieldValue.substring(0, 4) + "\u5E74" + 
/* 233 */             strFieldValue.substring(5, 7) + "\u6708" + 
/* 234 */             strFieldValue.substring(8, 10) + "\u65E5";
/*     */         }
/* 236 */         this._Element.addContent(
/* 237 */           new Element(strClassName + "." + 
/* 237 */           strFieldName)
/* 238 */           .addContent(strFieldValue));
/*     */       }
/*     */       else
/*     */       {
/* 243 */         this._Element.addContent(
/* 244 */           new Element(strClassName + "." + 
/* 244 */           strFieldName)
/* 245 */           .addContent(""));
/*     */       }
/*     */     }
/*     */ 
/* 249 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean addSchemaSet(SchemaSet schemaSet, String strID)
/*     */   {
/* 256 */     this.mErrors.clearErrors();
/*     */ 
/* 258 */     if ((schemaSet == null) || (strID == null))
/*     */     {
/* 260 */       buildError("addSchemaSet", "\u53C2\u6570\u6709\u9519");
/* 261 */       return false;
/*     */     }
/*     */ 
/* 265 */     if (schemaSet.getClass().getSuperclass().getName().equals(
/* 265 */       "com.sinosoft.map.lis.SchemaSet"))
/*     */     {
/* 267 */       buildError("addSchemaSet", "\u53C2\u6570\u4E0D\u662FSchemaSet\u7684\u76F4\u63A5\u5B50\u7C7B");
/* 268 */       return false;
/*     */     }
/*     */ 
/* 271 */     String strClassName = schemaSet.getClass().getName();
/*     */ 
/* 274 */     strClassName = strClassName.substring(strClassName.lastIndexOf(".") + 1);
/*     */ 
/* 277 */     strClassName = strClassName.substring(0, strClassName.indexOf("Set"));
/*     */ 
/* 279 */     Element eleList = null;
/*     */ 
/* 281 */     if (strID.equals(""))
/*     */     {
/* 283 */       eleList = new Element(strClassName);
/*     */     }
/*     */     else
/*     */     {
/* 287 */       eleList = new Element(strID);
/*     */     }
/*     */ 
/* 290 */     this._Element.addContent(eleList);
/*     */ 
/* 293 */     strClassName = "com.sinosoft.map.lis.schema." + strClassName + "Schema";
/* 294 */     Field[] fields = null;
/*     */ 
/* 296 */     Vector vFields = new Vector();
/*     */     try
/*     */     {
/* 300 */       fields = Class.forName(strClassName).getDeclaredFields();
/*     */     }
/*     */     catch (ClassNotFoundException ex)
/*     */     {
/* 304 */       buildError("addSchemaSet", "\u627E\u4E0D\u5230\u5BF9\u5E94\u7684Schema\u7C7B");
/* 305 */       return false;
/*     */     }
/*     */ 
/* 308 */     Element eleHead = new Element("HEAD");
/* 309 */     eleList.addContent(eleHead);
/*     */ 
/* 311 */     String strColName = "";
/* 312 */     int nColNum = 0;
/*     */ 
/* 315 */     for (int nIndex = 0; nIndex < fields.length; nIndex++)
/*     */     {
/* 317 */       String strFieldName = fields[nIndex].getName();
/*     */ 
/* 319 */       if ((strFieldName.equals("FIELDNUM")) || (strFieldName.equals("PK")) || 
/* 320 */         (strFieldName.equals("mErrors")) || 
/* 321 */         (strFieldName.equals("fDate")))
/*     */       {
/*     */         continue;
/*     */       }
/*     */ 
/* 327 */       strColName = "COL" + String.valueOf(nColNum++);
/* 328 */       eleHead.addContent(new Element(strColName).addContent(
/* 329 */         strFieldName));
/* 330 */       vFields.add(fields[nIndex]);
/*     */     }
/*     */ 
/* 335 */     for (int nIndex = 0; nIndex < schemaSet.size(); nIndex++)
/*     */     {
/* 338 */       Element eleRow = new Element("ROW");
/* 339 */       eleList.addContent(eleRow);
/*     */ 
/* 341 */       Schema schema = (Schema)schemaSet.getObj(nIndex + 1);
/*     */ 
/* 343 */       nColNum = 0;
/* 344 */       for (int nCols = 0; nCols < vFields.size(); nCols++)
/*     */       {
/* 346 */         String strFieldName = ((Field)vFields.get(nCols)).getName();
/* 347 */         String strFieldType = ((Field)vFields.get(nCols)).getType()
/* 348 */           .getName();
/* 349 */         String strFieldValue = schema.getV(strFieldName);
/*     */ 
/* 351 */         strColName = "COL" + String.valueOf(nColNum++);
/* 352 */         if ((strFieldType.equals("float")) && 
/* 353 */           (!strFieldValue.equals("-100.0")))
/*     */         {
/* 355 */           eleRow.addContent(new Element(strColName).addContent(
/* 356 */             strFieldValue));
/*     */         }
/* 358 */         else if ((strFieldType.equals("double")) && 
/* 359 */           (!strFieldValue.equals("-100.0")))
/*     */         {
/* 361 */           eleRow.addContent(new Element(strColName).addContent(
/* 362 */             strFieldValue));
/*     */         }
/* 364 */         else if ((strFieldType.equals("int")) && 
/* 365 */           (!strFieldValue.equals("-100")))
/*     */         {
/* 367 */           eleRow.addContent(new Element(strColName).addContent(
/* 368 */             strFieldValue));
/*     */         }
/* 370 */         else if ((strFieldType.equals("java.lang.String")) && 
/* 371 */           (!strFieldValue.equals("null")))
/*     */         {
/* 373 */           eleRow.addContent(new Element(strColName).addContent(
/* 374 */             strFieldValue));
/*     */         }
/* 376 */         else if ((strFieldType.equals("java.util.Date")) && 
/* 377 */           (!strFieldValue.equals("null")))
/*     */         {
/* 379 */           if (strFieldValue.indexOf('-') != -1)
/*     */           {
/* 381 */             strFieldValue = strFieldValue.substring(0, 4) + "\u5E74" + 
/* 382 */               strFieldValue.substring(5, 7) + "\u6708" + 
/* 383 */               strFieldValue.substring(8, 10) + "\u65E5";
/*     */           }
/* 385 */           eleRow.addContent(new Element(strColName).addContent(
/* 386 */             strFieldValue));
/*     */         }
/*     */         else
/*     */         {
/* 390 */           eleRow.addContent(new Element(strColName).addContent(""));
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 396 */     return true;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */   {
/* 403 */     if (this._Element == null)
/*     */     {
/* 405 */       return null;
/*     */     }
/*     */ 
/* 408 */     return new XMLDatasetP(getElement());
/*     */   }
/*     */ 
/*     */   private void buildError(String szFunc, String szErrMsg)
/*     */   {
/* 413 */     CError cError = new CError();
/*     */ 
/* 415 */     cError.moduleName = "XmlExportHelper";
/* 416 */     cError.functionName = szFunc;
/* 417 */     cError.errorMessage = szErrMsg;
/* 418 */     this.mErrors.addOneError(cError);
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.XMLDatasetP
 * JD-Core Version:    0.6.0
 */