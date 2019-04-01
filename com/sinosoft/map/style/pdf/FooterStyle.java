/*    */ package com.sinosoft.map.style.pdf;
/*    */ 
/*    */ public class FooterStyle extends FontStyle
/*    */ {
/*    */   public static final int CONTENT_NONE = 0;
/*    */   public static final int CONTENT_TEXT = 1;
/*    */   public static final int CONTENT_IMAGE = 2;
/* 11 */   private int align = 1;
/* 12 */   private boolean numbered = false;
/* 13 */   private boolean restartNum = true;
/* 14 */   private int contentType = 1;
/* 15 */   private int border = 0;
/*    */ 
/*    */   public void setAlign(int align)
/*    */   {
/* 22 */     this.align = align;
/*    */   }
/*    */ 
/*    */   public int getAlign()
/*    */   {
/* 27 */     return this.align;
/*    */   }
/*    */ 
/*    */   public void setNumbered(boolean numbered)
/*    */   {
/* 32 */     this.numbered = numbered;
/*    */   }
/*    */ 
/*    */   public boolean getBumbered()
/*    */   {
/* 37 */     return this.numbered;
/*    */   }
/*    */ 
/*    */   public void setBorder(int border)
/*    */   {
/* 42 */     this.border = border;
/*    */   }
/*    */ 
/*    */   public int getBorder()
/*    */   {
/* 47 */     return this.border;
/*    */   }
/*    */ 
/*    */   public void setRestart(boolean restartFlag)
/*    */   {
/* 52 */     this.restartNum = restartFlag;
/*    */   }
/*    */ 
/*    */   public boolean isContinue()
/*    */   {
/* 57 */     return !this.restartNum;
/*    */   }
/*    */ 
/*    */   public void setContentType(int type)
/*    */   {
/* 64 */     this.contentType = type;
/*    */   }
/*    */ 
/*    */   public int getContentType()
/*    */   {
/* 69 */     return this.contentType;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.style.pdf.FooterStyle
 * JD-Core Version:    0.6.0
 */