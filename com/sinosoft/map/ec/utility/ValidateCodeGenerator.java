/*    */ package com.sinosoft.map.ec.utility;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Font;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
/*    */ import java.io.PrintStream;
/*    */ import java.io.Serializable;
/*    */ import java.util.Random;
/*    */ import javax.faces.context.ExternalContext;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.imageio.ImageIO;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ public class ValidateCodeGenerator
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -8161565799237268271L;
/*    */   private BufferedImage image;
/* 20 */   Integer width = Integer.valueOf(65);
/* 21 */   Integer height = Integer.valueOf(20);
/* 22 */   Color bankgroud = new Color(16777215);
/* 23 */   Color drawColor = new Color(0);
/* 24 */   Font textFont = new Font("Comic Sans ms", 0, 18);
/*    */ 
/* 26 */   String str = "A,2,X,E,5,J,7,L,9,B,C,D,4,F,G,H,6,K,8,M,N,P,Q,R,S,T,U,V,W,3,Y,Z";
/* 27 */   Random random = new Random();
/*    */ 
/*    */   public void paint(OutputStream out, Object data) throws IOException {
/* 30 */     if ((data instanceof ValidateCodeGenerator))
/*    */     {
/* 33 */       this.image = new BufferedImage(this.width.intValue(), this.height.intValue(), 1);
/* 34 */       Graphics graphics = this.image.getGraphics();
/* 35 */       graphics.setColor(this.bankgroud);
/* 36 */       graphics.fillRect(0, 0, this.width.intValue(), this.height.intValue());
/* 37 */       graphics.setColor(this.drawColor);
/* 38 */       graphics.drawRect(0, 0, this.width.intValue() - 1, this.height.intValue() - 1);
/* 39 */       graphics.setFont(this.textFont);
/*    */ 
/* 42 */       for (int i = 0; i < 160; i++) {
/* 43 */         int x = this.random.nextInt(this.width.intValue());
/* 44 */         int y = this.random.nextInt(this.height.intValue());
/* 45 */         int xl = this.random.nextInt(12);
/* 46 */         int yl = this.random.nextInt(12);
/* 47 */         graphics.setColor(getRandColor(100, 250));
/* 48 */         graphics.drawLine(x, y, x + xl, y + yl);
/*    */       }
/*    */ 
/* 52 */       graphics.setColor(this.drawColor);
/* 53 */       String code = "";
/* 54 */       String[] array = this.str.split(",");
/*    */ 
/* 56 */       for (int i = 0; i < 4; i++) {
/* 57 */         String rand = "";
/* 58 */         rand = array[this.random.nextInt(32)];
/* 59 */         code = code + rand;
/* 60 */         graphics.drawString(rand, 13 * i + 6, 16);
/*    */       }
/*    */ 
/* 63 */       System.out.println("\u9A8C\u8BC1\u7801\u662F\uFF1A" + code);
/* 64 */       FacesContext tFacesContext = FacesContext.getCurrentInstance();
/* 65 */       HttpServletRequest tHttpServletRequest = (HttpServletRequest)tFacesContext.getExternalContext().getRequest();
/* 66 */       HttpSession tHttpSession = tHttpServletRequest.getSession();
/* 67 */       tHttpSession.setAttribute("validateCode", code);
/* 68 */       graphics.dispose();
/*    */     }
/* 70 */     ImageIO.write(this.image, "JPEG", out);
/*    */   }
/*    */ 
/*    */   private Color getRandColor(int fc, int bc) {
/* 74 */     Random random = new Random();
/* 75 */     if (fc > 255)
/* 76 */       fc = 255;
/* 77 */     if (bc > 255)
/* 78 */       bc = 255;
/* 79 */     int r = fc + random.nextInt(bc - fc);
/* 80 */     int g = fc + random.nextInt(bc - fc);
/* 81 */     int b = fc + random.nextInt(bc - fc);
/* 82 */     return new Color(r, g, b);
/*    */   }
/*    */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.ec.utility.ValidateCodeGenerator
 * JD-Core Version:    0.6.0
 */