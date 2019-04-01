/*    */ package com.sinosoft.map.style.pdf;
/*    */ 
/*    */ public class ImageStyle
/*    */ {
/*    */   public static final int ALIGN_CENTER = 1;
/*    */   public static final int ALIGN_LEFT = 0;
/*    */   public static final int ALIGN_RIGHT = 2;
/*    */   public static final int ALIGN_TOP = 4;
/*    */   public static final int ALIGN_BOTTOM = 6;
/* 21 */   private String type = "";
/* 22 */   private int align = 0;
/*    */   private float size;
/*    */   private float px;
/*    */   private float py;
/* 26 */   private boolean absolute = true;
/*    */ 
/* 29 */   private boolean isAlone = true;
/*    */ 
/*    */   public void setImageType(String type)
/*    */   {
/* 36 */     this.type = type;
/*    */   }
/*    */ 
/*    */   public String getImageType()
/*    */   {
/* 41 */     return this.type;
/*    */   }
/*    */ 
/*    */   public void setAlign(int align)
/*    */   {
/* 46 */     this.align = align;
/*    */   }
/*    */ 
/*    */   public int getAlign()
/*    */   {
/* 51 */     return this.align;
/*    */   }
/*    */ 
/*    */   public void setPx(float px)
/*    */   {
/* 56 */     this.px = px;
/* 57 */     this.absolute = true;
/*    */   }
/*    */ 
/*    */   public void setPy(float py)
/*    */   {
/* 62 */     this.py = py;
/* 63 */     this.absolute = true;
/*    */   }
/*    */ 
/*    */   public float getPx()
/*    */   {
/* 68 */     return this.px;
/*    */   }
/*    */ 
/*    */   public float getPy()
/*    */   {
/* 73 */     return this.py;
/*    */   }
/*    */ 
/*    */   public void setScalePercent(float size)
/*    */   {
/* 78 */     this.size = size;
/*    */   }
/*    */ 
/*    */   public float getScalePercent()
/*    */   {
/* 83 */     return this.size;
/*    */   }
/*    */ 
/*    */   public boolean getAbsolute()
/*    */   {
/* 88 */     return this.absolute;
/*    */   }
/*    */   public boolean isAlone() {
/* 91 */     return this.isAlone;
/*    */   }
/*    */   public void setAlone(boolean isAlone) {
/* 94 */     this.isAlone = isAlone;
/*    */   }
/*    */   public void setAbsolute(boolean absolute) {
/* 97 */     this.absolute = absolute;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.style.pdf.ImageStyle
 * JD-Core Version:    0.6.0
 */