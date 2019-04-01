/*    */ package com.sinosoft.map.pdf.iText;
/*    */ 
/*    */ import com.lowagie.text.Font;
/*    */ import com.lowagie.text.pdf.BaseFont;
/*    */ import com.sinosoft.map.utility.StaticConst;
/*    */ import java.awt.Color;
/*    */ 
/*    */ public class BaseStyle
/*    */ {
/* 19 */   static BaseFont bfChinese = StaticConst.getInstance().getFont("\u4EFF\u5B8B").getBaseFont();
/*    */ 
/*    */   public static Font getH1()
/*    */   {
/* 28 */     return new Font(bfChinese, 20.0F, 0, Color.BLACK);
/*    */   }
/*    */ 
/*    */   public static Font getH2() {
/* 32 */     return new Font(bfChinese, 15.0F, 0, Color.BLACK);
/*    */   }
/*    */ 
/*    */   public static Font getH3() {
/* 36 */     return new Font(bfChinese, 10.0F, 0, Color.BLACK);
/*    */   }
/*    */ 
/*    */   public static Font getTitle() {
/* 40 */     return new Font(bfChinese, 10.0F, 0, Color.BLACK);
/*    */   }
/*    */ 
/*    */   public static Font getContext()
/*    */   {
/* 45 */     return new Font(bfChinese, 10.0F, 0, Color.BLACK);
/*    */   }
/*    */ 
/*    */   public static Font getContext(String fontName) {
/* 49 */     BaseFont font = getBaseFont(fontName);
/* 50 */     return new Font(font, 10.0F, 0, Color.BLACK);
/*    */   }
/*    */ 
/*    */   public static BaseFont getBaseFont(String font) {
/* 54 */     bfChinese = StaticConst.getInstance().getFont(font).getBaseFont();
/* 55 */     return bfChinese;
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.pdf.iText.BaseStyle
 * JD-Core Version:    0.6.0
 */