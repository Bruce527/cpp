/*    */ package com.sinosoft.map.utility;
/*    */ 
/*    */ import org.jdom.Element;
/*    */ 
/*    */ public class XMLDataTag extends XMLDataObject
/*    */ {
/*    */   private String _Value;
/*    */ 
/*    */   public XMLDataTag(String strName, String strValue)
/*    */   {
/* 19 */     setDataObjectID(strName);
/*    */ 
/* 21 */     this._Value = strValue;
/*    */   }
/*    */ 
/*    */   public XMLDataTag(String strName, int iValue)
/*    */   {
/* 26 */     setDataObjectID(strName);
/*    */ 
/* 28 */     this._Value = String.valueOf(iValue);
/*    */   }
/*    */ 
/*    */   public void setName(String strName)
/*    */   {
/* 33 */     setDataObjectID(strName);
/*    */   }
/*    */ 
/*    */   public void setValue(String strValue)
/*    */   {
/* 38 */     this._Value = strValue;
/*    */   }
/*    */ 
/*    */   public void setValue(int iValue)
/*    */   {
/* 43 */     this._Value = String.valueOf(iValue);
/*    */   }
/*    */ 
/*    */   public int getDataObjectType()
/*    */   {
/* 48 */     return 0;
/*    */   }
/*    */ 
/*    */   public boolean addDataTo(Element element)
/*    */   {
/* 53 */     element.addContent(new Element(this._ID).addContent(this._Value));
/* 54 */     return true;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.XMLDataTag
 * JD-Core Version:    0.6.0
 */