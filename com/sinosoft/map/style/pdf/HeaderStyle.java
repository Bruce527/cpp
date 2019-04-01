/*    */ package com.sinosoft.map.style.pdf;
/*    */ 
/*    */ public class HeaderStyle extends FontStyle
/*    */ {
/*    */   public static final int CONTENT_NONE = 0;
/*    */   public static final int CONTENT_TEXT = 1;
/*    */   public static final int CONTENT_IMAGE = 2;
/* 18 */   private int align = 1;
/* 19 */   private int border = 0;
/* 20 */   private int contentType = 1;
/* 21 */   private float leading = (0.0F / 0.0F);
/* 22 */   private boolean numbered = false;
/*    */ 
/*    */   public void setAlign(int align)
/*    */   {
/* 29 */     this.align = align;
/*    */   }
/*    */ 
/*    */   public int getAlign()
/*    */   {
/* 34 */     return this.align;
/*    */   }
/*    */ 
/*    */   public void setLeading(float leading)
/*    */   {
/* 39 */     this.leading = leading;
/*    */   }
/*    */ 
/*    */   public float getLeading()
/*    */   {
/* 44 */     return this.leading;
/*    */   }
/*    */ 
/*    */   public void setNumbered(boolean numbered)
/*    */   {
/* 49 */     this.numbered = numbered;
/*    */   }
/*    */ 
/*    */   public boolean getBumbered()
/*    */   {
/* 54 */     return this.numbered;
/*    */   }
/*    */ 
/*    */   public void setBorder(int border) {
/* 58 */     this.border = border;
/*    */   }
/*    */ 
/*    */   public int getBoder()
/*    */   {
/* 63 */     return this.border;
/*    */   }
/*    */ 
/*    */   public void setContentType(int type)
/*    */   {
/* 68 */     this.contentType = type;
/*    */   }
/*    */ 
/*    */   public int getContentType()
/*    */   {
/* 73 */     return this.contentType;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.style.pdf.HeaderStyle
 * JD-Core Version:    0.6.0
 */