/*    */ package com.sinosoft.map.utility;
/*    */ 
/*    */ import org.jdom.Element;
/*    */ 
/*    */ public abstract class XMLDataObject
/*    */ {
/*    */   public static final int TYPE_TAG = 0;
/*    */   public static final int TYPE_LIST = 1;
/*    */   public static final int TYPE_MINE = 2;
/*    */   public static final int TYPE_BLOB = 3;
/*    */   protected String _ID;
/* 20 */   private XMLDataFormater m_xdf = null;
/*    */ 
/*    */   public final void setDataObjectID(String strID)
/*    */   {
/* 28 */     if (strID.equals("null")) {
/* 29 */       strID = "";
/*    */     }
/* 31 */     this._ID = strID;
/*    */   }
/*    */ 
/*    */   public final String getDataObjectID()
/*    */   {
/* 36 */     if (this._ID == null)
/*    */     {
/* 38 */       return null;
/*    */     }
/*    */ 
/* 42 */     return this._ID;
/*    */   }
/*    */ 
/*    */   public final void setDataFormater(XMLDataFormater xdf)
/*    */   {
/* 48 */     this.m_xdf = xdf;
/*    */   }
/*    */ 
/*    */   public final XMLDataFormater getDataFormater()
/*    */   {
/* 53 */     return this.m_xdf;
/*    */   }
/*    */ 
/*    */   public abstract boolean addDataTo(Element paramElement);
/*    */ 
/*    */   public abstract int getDataObjectType();
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.XMLDataObject
 * JD-Core Version:    0.6.0
 */