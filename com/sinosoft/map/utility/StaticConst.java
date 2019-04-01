/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ import com.lowagie.text.DocumentException;
/*     */ import com.lowagie.text.Font;
/*     */ import com.lowagie.text.pdf.BaseFont;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Enumeration;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Properties;
/*     */ import java.util.Set;
/*     */ import javax.servlet.ServletContext;
/*     */ 
/*     */ public class StaticConst
/*     */ {
/*     */   private static StaticConst me;
/*  26 */   private String RealRootPath = null;
/*  27 */   private String root = null;
/*  28 */   private HashMap<String, BaseFont> fontMapping = new HashMap();
/*     */   private ServletContext ctx;
/*  30 */   String path = "/MAPFont";
/*     */ 
/* 707 */   private int maleDeathAge = 0;
/*     */ 
/* 709 */   private int femaleDeathAge = 0;
/*     */   private int defaultEduEne;
/*     */   private int femaleRetireAge;
/*     */   private int maleRetireAge;
/*     */   private double AfterDeathRate;
/*     */   private double ChildAdoutRate;
/*     */   private double RetiredRate;
/*     */   private double AfterDeathRateR;
/*     */   private int childFeedEndAge;
/*     */   private int levelChildAdout;
/*     */   private int levelRetired;
/*     */   private int levelDeath;
/* 799 */   private int endAge = 105;
/*     */ 
/* 805 */   private int PdfImgWidth = 800;
/* 806 */   private int PdfImgHeight = 800;
/* 807 */   private int PdfImgLabelSize = 12;
/*     */ 
/* 821 */   private int PageImgWidth = 800;
/* 822 */   private int PageImgHeight = 800;
/* 823 */   private int PageImgLabelSize = 12;
/*     */   private double BLoanRate;
/*     */   private double LoanRate;
/*     */ 
/*     */   private StaticConst(ServletContext ctx)
/*     */   {
/*  32 */     this.ctx = ctx;
/*     */ 
/*  39 */     init();
/*     */   }
/*     */   private StaticConst() {
/*  42 */     newInit();
/*     */   }
/*     */   private void newInit() {
/*  45 */     System.out.println(" new init");
/*     */ 
/*  47 */     ExeSQL tExeSQL = new ExeSQL();
/*  48 */     SSRS tSSRS = new SSRS();
/*  49 */     String sql1 = " select varvalue from msysvar where vartype='MAPFontPath' ";
/*     */ 
/*  53 */     Properties config = new Properties();
/*     */     try
/*     */     {
/*  56 */       config.load(
/*  57 */         new FileInputStream(new File(this.path + "/init_params.properties")));
/*     */     }
/*     */     catch (FileNotFoundException e1) {
/*  60 */       e1.printStackTrace();
/*     */     } catch (IOException e1) {
/*  62 */       e1.printStackTrace();
/*     */     }
/*     */     try
/*     */     {
/*  66 */       this.defaultEduEne = Integer.parseInt(config
/*  67 */         .getProperty("SYSTEMCONST.defaultEduEne"));
/*  68 */       System.out.println("SYSTEMCONST.defaultEduEne = " + this.defaultEduEne);
/*     */     } catch (Exception e) {
/*  70 */       this.defaultEduEne = 18;
/*     */     }
/*     */     try
/*     */     {
/*  74 */       this.femaleDeathAge = Integer.parseInt(config
/*  75 */         .getProperty("SYSTEMCONST.femaleDeathAge"));
/*  76 */       System.out
/*  77 */         .println("SYSTEMCONST.femaleDeathAge = " + this.femaleDeathAge);
/*     */     } catch (Exception e) {
/*  79 */       this.femaleDeathAge = 83;
/*     */     }
/*     */     try
/*     */     {
/*  83 */       this.femaleRetireAge = Integer.parseInt(config
/*  84 */         .getProperty("SYSTEMCONST.femaleRetireAge"));
/*  85 */       System.out.println("SYSTEMCONST.femaleRetireAge = " + 
/*  86 */         this.femaleRetireAge);
/*     */     } catch (Exception e) {
/*  88 */       this.femaleRetireAge = 55;
/*     */     }
/*     */     try
/*     */     {
/*  92 */       this.maleDeathAge = Integer.parseInt(config
/*  93 */         .getProperty("SYSTEMCONST.maleDeathAge"));
/*  94 */       System.out.println("SYSTEMCONST.maleDeathAge = " + this.maleDeathAge);
/*     */     } catch (Exception e) {
/*  96 */       this.maleDeathAge = 79;
/*     */     }
/*     */     try
/*     */     {
/* 100 */       this.maleRetireAge = Integer.parseInt(config
/* 101 */         .getProperty("SYSTEMCONST.maleRetireAge"));
/* 102 */       System.out.println("SYSTEMCONST.maleRetireAge = " + this.maleRetireAge);
/*     */     } catch (Exception e) {
/* 104 */       this.maleRetireAge = 60;
/*     */     }
/*     */     try
/*     */     {
/* 108 */       this.AfterDeathRate = Double.parseDouble(config
/* 109 */         .getProperty("SYSTEMCONST.afterDeathRate"));
/* 110 */       System.out
/* 111 */         .println("SYSTEMCONST.afterDeathRate = " + this.AfterDeathRate);
/*     */     } catch (Exception e) {
/* 113 */       this.AfterDeathRate = 0.8D;
/*     */     }
/*     */     try
/*     */     {
/* 117 */       this.ChildAdoutRate = Double.parseDouble(config
/* 118 */         .getProperty("SYSTEMCONST.ChildAdoutRate"));
/* 119 */       System.out
/* 120 */         .println("SYSTEMCONST.ChildAdoutRate = " + this.ChildAdoutRate);
/*     */     } catch (Exception e) {
/* 122 */       this.ChildAdoutRate = 0.7D;
/*     */     }
/*     */     try
/*     */     {
/* 126 */       this.childFeedEndAge = Integer.parseInt(config
/* 127 */         .getProperty("SYSTEMCONST.childFeedEndAge"));
/* 128 */       System.out.println("SYSTEMCONST.childFeedEndAge = " + 
/* 129 */         this.childFeedEndAge);
/*     */     } catch (Exception e) {
/* 131 */       this.childFeedEndAge = 22;
/*     */     }
/*     */     try
/*     */     {
/* 135 */       this.RetiredRate = Double.parseDouble(config
/* 136 */         .getProperty("SYSTEMCONST.RetiredRate"));
/* 137 */       System.out.println("SYSTEMCONST.RetiredRate = " + this.RetiredRate);
/*     */     } catch (Exception e) {
/* 139 */       this.RetiredRate = 0.8D;
/*     */     }
/*     */     try
/*     */     {
/* 143 */       this.AfterDeathRateR = Double.parseDouble(config
/* 144 */         .getProperty("SYSTEMCONST.AfterDeathRateR"));
/* 145 */       System.out.println("SYSTEMCONST.AfterDeathRateR = " + 
/* 146 */         this.AfterDeathRateR);
/*     */     } catch (Exception e) {
/* 148 */       this.AfterDeathRateR = 0.5D;
/*     */     }
/*     */     try
/*     */     {
/* 152 */       this.endAge = Integer.parseInt(config
/* 153 */         .getProperty("SYSTEMCONST.RET_ENDAGE"));
/* 154 */       System.out.println("SYSTEMCONST.RET_ENDAGE = " + this.endAge);
/*     */     } catch (Exception e) {
/* 156 */       this.endAge = 105;
/*     */     }
/*     */     try
/*     */     {
/* 160 */       this.PdfImgHeight = Integer.parseInt(config
/* 161 */         .getProperty("SYSTEMCONST.PDF_IMG_HEIGHT"));
/* 162 */       System.out.println("SYSTEMCONST.PDF_IMG_HEIGHT = " + this.PdfImgHeight);
/*     */     } catch (Exception e) {
/* 164 */       this.PdfImgHeight = 1000;
/*     */     }
/*     */     try
/*     */     {
/* 168 */       this.PdfImgWidth = Integer.parseInt(config
/* 169 */         .getProperty("SYSTEMCONST.PDF_IMG_WIDTH"));
/* 170 */       System.out.println("SYSTEMCONST.PDF_IMG_WIDTH = " + this.PdfImgWidth);
/*     */     } catch (Exception e) {
/* 172 */       this.PdfImgWidth = 1000;
/*     */     }
/*     */     try
/*     */     {
/* 176 */       this.PdfImgLabelSize = Integer.parseInt(config
/* 177 */         .getProperty("SYSTEMCONST.PDF_IMG_LABELSIZE"));
/* 178 */       System.out.println("SYSTEMCONST.PDF_IMG_LABELSIZE = " + 
/* 179 */         this.PdfImgLabelSize);
/*     */     } catch (Exception e) {
/* 181 */       this.PdfImgLabelSize = 16;
/*     */     }
/*     */     try
/*     */     {
/* 185 */       this.PageImgWidth = Integer.parseInt(config
/* 186 */         .getProperty("SYSTEMCONST.PAGE_IMG_WIDTH"));
/* 187 */       System.out.println("SYSTEMCONST.PAGE_IMG_WIDTH = " + this.PageImgWidth);
/*     */     } catch (Exception e) {
/* 189 */       this.PageImgWidth = 800;
/*     */     }
/*     */     try
/*     */     {
/* 193 */       this.PageImgHeight = Integer.parseInt(config
/* 194 */         .getProperty("SYSTEMCONST.PAGE_IMG_HEIGHT"));
/* 195 */       System.out
/* 196 */         .println("SYSTEMCONST.PAGE_IMG_HEIGHT = " + this.PageImgHeight);
/*     */     } catch (Exception e) {
/* 198 */       this.PageImgHeight = 800;
/*     */     }
/*     */     try
/*     */     {
/* 202 */       this.PageImgLabelSize = Integer.parseInt(config
/* 203 */         .getProperty("SYSTEMCONST.PAGE_IMG_LABELSIZE"));
/* 204 */       System.out.println("SYSTEMCONST.PAGE_IMG_LABELSIZE = " + 
/* 205 */         this.PageImgLabelSize);
/*     */     } catch (Exception e) {
/* 207 */       this.PageImgLabelSize = 12;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 212 */       this.levelChildAdout = Integer.parseInt(config
/* 213 */         .getProperty("RET_CONST.ChildAdout"));
/* 214 */       System.out.println("RET_CONST.ChildAdout = " + this.levelChildAdout);
/*     */     } catch (Exception e) {
/* 216 */       this.levelChildAdout = 2;
/*     */     }
/*     */     try
/*     */     {
/* 220 */       this.levelRetired = Integer.parseInt(config
/* 221 */         .getProperty("RET_CONST.Retired"));
/* 222 */       System.out.println("RET_CONST.Retired = " + this.levelRetired);
/*     */     } catch (Exception e) {
/* 224 */       this.levelRetired = 1;
/*     */     }
/*     */     try
/*     */     {
/* 228 */       this.levelDeath = Integer.parseInt(config
/* 229 */         .getProperty("RET_CONST.Death"));
/* 230 */       System.out.println("RET_CONST.Death = " + this.levelDeath);
/*     */     } catch (Exception e) {
/* 232 */       this.levelDeath = 3;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 237 */       this.BLoanRate = Double.parseDouble(config
/* 238 */         .getProperty("client.BLoanRate"));
/* 239 */       System.out.println("client.BLoanRate = " + this.BLoanRate);
/*     */     } catch (Exception e) {
/* 241 */       this.BLoanRate = 0.0612D;
/*     */     }
/*     */     try
/*     */     {
/* 245 */       this.LoanRate = Double.parseDouble(config
/* 246 */         .getProperty("client.LoanRate"));
/* 247 */       System.out.println("client.LoanRate = " + this.LoanRate);
/*     */     } catch (Exception e) {
/* 249 */       this.LoanRate = 0.0387D;
/*     */     }
/*     */     try
/*     */     {
/* 253 */       this.fontMapping.put("\u5B8B\u4F53", BaseFont.createFont(this.path + "/songti.ttf", "Identity-H", 
/* 254 */         false));
/* 255 */       this.fontMapping.put("\u4EFF\u5B8B", BaseFont.createFont(this.path + "/simkai.ttf", "Identity-H", 
/* 256 */         false));
/*     */ 
/* 258 */       this.fontMapping.put("\u6977\u4F53", BaseFont.createFont(
/* 259 */         this.path + "/simkai.ttf", "Identity-H", 
/* 260 */         false));
/*     */ 
/* 262 */       this.fontMapping.put("\u9ED1\u4F53", BaseFont.createFont(
/* 263 */         this.path + "/simhei.ttf", "Identity-H", 
/* 264 */         false));
/*     */ 
/* 266 */       this.fontMapping.put("\u534E\u6587\u7EC6\u9ED1", BaseFont.createFont(
/* 267 */         this.path + "/STXIHEI.TTF", 
/* 268 */         "Identity-H", false));
/*     */ 
/* 270 */       this.fontMapping.put("ARIAL", BaseFont.createFont(
/* 271 */         this.path + "/arial.ttf", "Cp1252", 
/* 272 */         false));
/*     */ 
/* 274 */       this.fontMapping.put("ARIALBOLD", BaseFont.createFont(
/* 275 */         this.path + "/arialbd.ttf", "Cp1252", 
/* 276 */         false));
/*     */ 
/* 278 */       this.fontMapping.put("ARIAL_BOLD", BaseFont.createFont(
/* 279 */         this.path + "/arialbd.ttf", "Cp1252", 
/* 280 */         false));
/*     */ 
/* 282 */       this.fontMapping.put("ARIALITALIC", BaseFont.createFont(
/* 283 */         this.path + "/ariali.ttf", "Cp1252", 
/* 284 */         false));
/*     */ 
/* 286 */       this.fontMapping.put("ARIAL_ITALIC", BaseFont.createFont(
/* 287 */         this.path + "/ariali.ttf", "Cp1252", 
/* 288 */         false));
/*     */ 
/* 290 */       this.fontMapping.put("ARIALBOLDITALIC", BaseFont.createFont(
/* 291 */         this.path + "/arialbi.ttf", "Cp1252", 
/* 292 */         false));
/*     */ 
/* 294 */       this.fontMapping.put("ARIAL_BOLDITALIC", BaseFont.createFont(
/* 295 */         this.path + "/arialbi.ttf", "Cp1252", 
/* 296 */         false));
/*     */ 
/* 298 */       this.fontMapping.put("TAHOMA", BaseFont.createFont(
/* 299 */         this.path + "/tahoma.ttf", "Cp1252", 
/* 300 */         false));
/*     */ 
/* 302 */       this.fontMapping.put("STSongStd-Light", BaseFont.createFont(
/* 303 */         "STSongStd-Light", "UniGB-UCS2-H", false));
/*     */     }
/*     */     catch (DocumentException e) {
/* 306 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 308 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void init() {
/* 312 */     this.RealRootPath = this.ctx.getRealPath("/");
/*     */ 
/* 315 */     this.root = this.ctx.getAttribute("javax.servlet.context.tempdir")
/* 316 */       .toString();
/*     */ 
/* 322 */     if (this.root.indexOf("\\") >= 0)
/* 323 */       this.root = 
/* 324 */         ("/" + 
/* 324 */         this.root.substring(this.root.lastIndexOf("\\") + 1, this.root.length()));
/*     */     else {
/* 326 */       this.root = this.root.substring(this.root.lastIndexOf("/"), this.root.length());
/*     */     }
/*     */ 
/* 329 */     this.root = this.root.replaceAll("\\.war", "");
/*     */ 
/* 340 */     Enumeration names = this.ctx.getAttributeNames();
/* 341 */     while (names.hasMoreElements()) {
/* 342 */       String name = names.nextElement().toString();
/* 343 */       String str1 = this.ctx.getAttribute(name).toString();
/*     */     }
/*     */ 
/* 348 */     Properties config = new Properties();
/*     */     try
/*     */     {
/* 351 */       config.load(
/* 352 */         new FileInputStream(new File(getRealPath("/conf/init_params.properties"))));
/*     */     }
/*     */     catch (FileNotFoundException e1) {
/* 355 */       e1.printStackTrace();
/*     */     } catch (IOException e1) {
/* 357 */       e1.printStackTrace();
/*     */     }
/*     */     try
/*     */     {
/* 361 */       this.defaultEduEne = Integer.parseInt(config
/* 362 */         .getProperty("SYSTEMCONST.defaultEduEne"));
/* 363 */       System.out.println("SYSTEMCONST.defaultEduEne = " + this.defaultEduEne);
/*     */     } catch (Exception e) {
/* 365 */       this.defaultEduEne = 18;
/*     */     }
/*     */     try
/*     */     {
/* 369 */       this.femaleDeathAge = Integer.parseInt(config
/* 370 */         .getProperty("SYSTEMCONST.femaleDeathAge"));
/* 371 */       System.out
/* 372 */         .println("SYSTEMCONST.femaleDeathAge = " + this.femaleDeathAge);
/*     */     } catch (Exception e) {
/* 374 */       this.femaleDeathAge = 83;
/*     */     }
/*     */     try
/*     */     {
/* 378 */       this.femaleRetireAge = Integer.parseInt(config
/* 379 */         .getProperty("SYSTEMCONST.femaleRetireAge"));
/* 380 */       System.out.println("SYSTEMCONST.femaleRetireAge = " + 
/* 381 */         this.femaleRetireAge);
/*     */     } catch (Exception e) {
/* 383 */       this.femaleRetireAge = 55;
/*     */     }
/*     */     try
/*     */     {
/* 387 */       this.maleDeathAge = Integer.parseInt(config
/* 388 */         .getProperty("SYSTEMCONST.maleDeathAge"));
/* 389 */       System.out.println("SYSTEMCONST.maleDeathAge = " + this.maleDeathAge);
/*     */     } catch (Exception e) {
/* 391 */       this.maleDeathAge = 79;
/*     */     }
/*     */     try
/*     */     {
/* 395 */       this.maleRetireAge = Integer.parseInt(config
/* 396 */         .getProperty("SYSTEMCONST.maleRetireAge"));
/* 397 */       System.out.println("SYSTEMCONST.maleRetireAge = " + this.maleRetireAge);
/*     */     } catch (Exception e) {
/* 399 */       this.maleRetireAge = 60;
/*     */     }
/*     */     try
/*     */     {
/* 403 */       this.AfterDeathRate = Double.parseDouble(config
/* 404 */         .getProperty("SYSTEMCONST.afterDeathRate"));
/* 405 */       System.out
/* 406 */         .println("SYSTEMCONST.afterDeathRate = " + this.AfterDeathRate);
/*     */     } catch (Exception e) {
/* 408 */       this.AfterDeathRate = 0.8D;
/*     */     }
/*     */     try
/*     */     {
/* 412 */       this.ChildAdoutRate = Double.parseDouble(config
/* 413 */         .getProperty("SYSTEMCONST.ChildAdoutRate"));
/* 414 */       System.out
/* 415 */         .println("SYSTEMCONST.ChildAdoutRate = " + this.ChildAdoutRate);
/*     */     } catch (Exception e) {
/* 417 */       this.ChildAdoutRate = 0.7D;
/*     */     }
/*     */     try
/*     */     {
/* 421 */       this.childFeedEndAge = Integer.parseInt(config
/* 422 */         .getProperty("SYSTEMCONST.childFeedEndAge"));
/* 423 */       System.out.println("SYSTEMCONST.childFeedEndAge = " + 
/* 424 */         this.childFeedEndAge);
/*     */     } catch (Exception e) {
/* 426 */       this.childFeedEndAge = 22;
/*     */     }
/*     */     try
/*     */     {
/* 430 */       this.RetiredRate = Double.parseDouble(config
/* 431 */         .getProperty("SYSTEMCONST.RetiredRate"));
/* 432 */       System.out.println("SYSTEMCONST.RetiredRate = " + this.RetiredRate);
/*     */     } catch (Exception e) {
/* 434 */       this.RetiredRate = 0.8D;
/*     */     }
/*     */     try
/*     */     {
/* 438 */       this.AfterDeathRateR = Double.parseDouble(config
/* 439 */         .getProperty("SYSTEMCONST.AfterDeathRateR"));
/* 440 */       System.out.println("SYSTEMCONST.AfterDeathRateR = " + 
/* 441 */         this.AfterDeathRateR);
/*     */     } catch (Exception e) {
/* 443 */       this.AfterDeathRateR = 0.5D;
/*     */     }
/*     */     try
/*     */     {
/* 447 */       this.endAge = Integer.parseInt(config
/* 448 */         .getProperty("SYSTEMCONST.RET_ENDAGE"));
/* 449 */       System.out.println("SYSTEMCONST.RET_ENDAGE = " + this.endAge);
/*     */     } catch (Exception e) {
/* 451 */       this.endAge = 105;
/*     */     }
/*     */     try
/*     */     {
/* 455 */       this.PdfImgHeight = Integer.parseInt(config
/* 456 */         .getProperty("SYSTEMCONST.PDF_IMG_HEIGHT"));
/* 457 */       System.out.println("SYSTEMCONST.PDF_IMG_HEIGHT = " + this.PdfImgHeight);
/*     */     } catch (Exception e) {
/* 459 */       this.PdfImgHeight = 1000;
/*     */     }
/*     */     try
/*     */     {
/* 463 */       this.PdfImgWidth = Integer.parseInt(config
/* 464 */         .getProperty("SYSTEMCONST.PDF_IMG_WIDTH"));
/* 465 */       System.out.println("SYSTEMCONST.PDF_IMG_WIDTH = " + this.PdfImgWidth);
/*     */     } catch (Exception e) {
/* 467 */       this.PdfImgWidth = 1000;
/*     */     }
/*     */     try
/*     */     {
/* 471 */       this.PdfImgLabelSize = Integer.parseInt(config
/* 472 */         .getProperty("SYSTEMCONST.PDF_IMG_LABELSIZE"));
/* 473 */       System.out.println("SYSTEMCONST.PDF_IMG_LABELSIZE = " + 
/* 474 */         this.PdfImgLabelSize);
/*     */     } catch (Exception e) {
/* 476 */       this.PdfImgLabelSize = 16;
/*     */     }
/*     */     try
/*     */     {
/* 480 */       this.PageImgWidth = Integer.parseInt(config
/* 481 */         .getProperty("SYSTEMCONST.PAGE_IMG_WIDTH"));
/* 482 */       System.out.println("SYSTEMCONST.PAGE_IMG_WIDTH = " + this.PageImgWidth);
/*     */     } catch (Exception e) {
/* 484 */       this.PageImgWidth = 800;
/*     */     }
/*     */     try
/*     */     {
/* 488 */       this.PageImgHeight = Integer.parseInt(config
/* 489 */         .getProperty("SYSTEMCONST.PAGE_IMG_HEIGHT"));
/* 490 */       System.out
/* 491 */         .println("SYSTEMCONST.PAGE_IMG_HEIGHT = " + this.PageImgHeight);
/*     */     } catch (Exception e) {
/* 493 */       this.PageImgHeight = 800;
/*     */     }
/*     */     try
/*     */     {
/* 497 */       this.PageImgLabelSize = Integer.parseInt(config
/* 498 */         .getProperty("SYSTEMCONST.PAGE_IMG_LABELSIZE"));
/* 499 */       System.out.println("SYSTEMCONST.PAGE_IMG_LABELSIZE = " + 
/* 500 */         this.PageImgLabelSize);
/*     */     } catch (Exception e) {
/* 502 */       this.PageImgLabelSize = 12;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 507 */       this.levelChildAdout = Integer.parseInt(config
/* 508 */         .getProperty("RET_CONST.ChildAdout"));
/* 509 */       System.out.println("RET_CONST.ChildAdout = " + this.levelChildAdout);
/*     */     } catch (Exception e) {
/* 511 */       this.levelChildAdout = 2;
/*     */     }
/*     */     try
/*     */     {
/* 515 */       this.levelRetired = Integer.parseInt(config
/* 516 */         .getProperty("RET_CONST.Retired"));
/* 517 */       System.out.println("RET_CONST.Retired = " + this.levelRetired);
/*     */     } catch (Exception e) {
/* 519 */       this.levelRetired = 1;
/*     */     }
/*     */     try
/*     */     {
/* 523 */       this.levelDeath = Integer.parseInt(config
/* 524 */         .getProperty("RET_CONST.Death"));
/* 525 */       System.out.println("RET_CONST.Death = " + this.levelDeath);
/*     */     } catch (Exception e) {
/* 527 */       this.levelDeath = 3;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 532 */       this.BLoanRate = Double.parseDouble(config
/* 533 */         .getProperty("client.BLoanRate"));
/* 534 */       System.out.println("client.BLoanRate = " + this.BLoanRate);
/*     */     } catch (Exception e) {
/* 536 */       this.BLoanRate = 0.0612D;
/*     */     }
/*     */     try
/*     */     {
/* 540 */       this.LoanRate = Double.parseDouble(config
/* 541 */         .getProperty("client.LoanRate"));
/* 542 */       System.out.println("client.LoanRate = " + this.LoanRate);
/*     */     } catch (Exception e) {
/* 544 */       this.LoanRate = 0.0387D;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 615 */       this.fontMapping.put("\u5B8B\u4F53", BaseFont.createFont(this.path + "/songti.ttf", "Identity-H", 
/* 616 */         false));
/*     */ 
/* 618 */       this.fontMapping.put("\u4EFF\u5B8B", BaseFont.createFont(
/* 619 */         getRealPath("/conf/Font/simkai.ttf"), "Identity-H", 
/* 620 */         false));
/*     */ 
/* 622 */       this.fontMapping.put("\u6977\u4F53", BaseFont.createFont(
/* 623 */         getRealPath("/conf/Font/simkai.ttf"), "Identity-H", 
/* 624 */         false));
/*     */ 
/* 626 */       this.fontMapping.put("\u9ED1\u4F53", BaseFont.createFont(
/* 627 */         getRealPath("/conf/Font/simhei.ttf"), "Identity-H", 
/* 628 */         false));
/*     */ 
/* 630 */       this.fontMapping.put("\u534E\u6587\u7EC6\u9ED1", BaseFont.createFont(
/* 631 */         getRealPath("/conf/Font/STXIHEI.TTF"), 
/* 632 */         "Identity-H", false));
/*     */ 
/* 634 */       this.fontMapping.put("ARIAL", BaseFont.createFont(
/* 635 */         getRealPath("/conf/Font/arial.ttf"), "Cp1252", 
/* 636 */         false));
/*     */ 
/* 638 */       this.fontMapping.put("ARIALBOLD", BaseFont.createFont(
/* 639 */         getRealPath("/conf/Font/arialbd.ttf"), "Cp1252", 
/* 640 */         false));
/*     */ 
/* 642 */       this.fontMapping.put("ARIAL_BOLD", BaseFont.createFont(
/* 643 */         getRealPath("/conf/Font/arialbd.ttf"), "Cp1252", 
/* 644 */         false));
/*     */ 
/* 646 */       this.fontMapping.put("ARIALITALIC", BaseFont.createFont(
/* 647 */         getRealPath("/conf/Font/ariali.ttf"), "Cp1252", 
/* 648 */         false));
/*     */ 
/* 650 */       this.fontMapping.put("ARIAL_ITALIC", BaseFont.createFont(
/* 651 */         getRealPath("/conf/Font/ariali.ttf"), "Cp1252", 
/* 652 */         false));
/*     */ 
/* 654 */       this.fontMapping.put("ARIALBOLDITALIC", BaseFont.createFont(
/* 655 */         getRealPath("/conf/Font/arialbi.ttf"), "Cp1252", 
/* 656 */         false));
/*     */ 
/* 658 */       this.fontMapping.put("ARIAL_BOLDITALIC", BaseFont.createFont(
/* 659 */         getRealPath("/conf/Font/arialbi.ttf"), "Cp1252", 
/* 660 */         false));
/*     */ 
/* 662 */       this.fontMapping.put("TAHOMA", BaseFont.createFont(
/* 663 */         getRealPath("/conf/Font/tahoma.ttf"), "Cp1252", 
/* 664 */         false));
/*     */ 
/* 666 */       this.fontMapping.put("STSongStd-Light", BaseFont.createFont(
/* 667 */         "STSongStd-Light", "UniGB-UCS2-H", false));
/*     */     }
/*     */     catch (DocumentException e) {
/* 670 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 672 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static StaticConst getInstance()
/*     */   {
/* 678 */     if (me == null)
/*     */     {
/* 680 */       me = new StaticConst();
/*     */     }
/*     */ 
/* 684 */     return me;
/*     */   }
/*     */ 
/*     */   public static StaticConst getInstance(ServletContext ctx) {
/* 688 */     if (me == null) {
/* 689 */       me = new StaticConst(ctx);
/*     */     }
/* 691 */     return me;
/*     */   }
/*     */ 
/*     */   public String getRealRootPath() {
/* 695 */     return this.RealRootPath;
/*     */   }
/*     */ 
/*     */   public String getRealPath(String path) {
/* 699 */     return this.ctx.getRealPath(path);
/*     */   }
/*     */ 
/*     */   public int getChildFeedEndAge()
/*     */   {
/* 729 */     return this.childFeedEndAge;
/*     */   }
/*     */ 
/*     */   public int getMaleDeathAge()
/*     */   {
/* 734 */     return this.maleDeathAge;
/*     */   }
/*     */ 
/*     */   public int getFemaleDeathAge()
/*     */   {
/* 739 */     return this.femaleDeathAge;
/*     */   }
/*     */ 
/*     */   public int getDefaultEduEne()
/*     */   {
/* 744 */     return this.defaultEduEne;
/*     */   }
/*     */ 
/*     */   public int getFemaleRetireAge()
/*     */   {
/* 749 */     return this.femaleRetireAge;
/*     */   }
/*     */ 
/*     */   public int getMaleRetireAge()
/*     */   {
/* 754 */     return this.maleRetireAge;
/*     */   }
/*     */ 
/*     */   public double getRetiredRate()
/*     */   {
/* 759 */     return this.RetiredRate;
/*     */   }
/*     */ 
/*     */   public double getAfterDeathRate()
/*     */   {
/* 764 */     return this.AfterDeathRate;
/*     */   }
/*     */ 
/*     */   public double getChildAdoutRate()
/*     */   {
/* 769 */     return this.ChildAdoutRate;
/*     */   }
/*     */ 
/*     */   public int getLevelChildAdout()
/*     */   {
/* 777 */     return this.levelChildAdout;
/*     */   }
/*     */ 
/*     */   public int getLevelRetired() {
/* 781 */     return this.levelRetired;
/*     */   }
/*     */ 
/*     */   public int getLevelDeath() {
/* 785 */     return this.levelDeath;
/*     */   }
/*     */ 
/*     */   public Font getFont(String str_fontname) {
/* 789 */     Iterator it = this.fontMapping.keySet().iterator();
/* 790 */     boolean flag = false;
/* 791 */     while (it.hasNext()) {
/* 792 */       String fontName = (String)it.next();
/* 793 */       if (!fontName.equals(str_fontname)) continue; flag = true;
/*     */     }
/* 795 */     if (!flag) str_fontname = "\u5B8B\u4F53";
/* 796 */     return new Font((BaseFont)this.fontMapping.get(str_fontname));
/*     */   }
/*     */ 
/*     */   public int getEndAge()
/*     */   {
/* 802 */     return this.endAge;
/*     */   }
/*     */ 
/*     */   public int getPdfImgWidth()
/*     */   {
/* 810 */     return this.PdfImgWidth;
/*     */   }
/*     */ 
/*     */   public int getPdfImgHeight() {
/* 814 */     return this.PdfImgHeight;
/*     */   }
/*     */ 
/*     */   public int getPdfImgLabelSize() {
/* 818 */     return this.PdfImgLabelSize;
/*     */   }
/*     */ 
/*     */   public int getPageImgWidth()
/*     */   {
/* 826 */     return this.PageImgWidth;
/*     */   }
/*     */ 
/*     */   public int getPageImgHeight() {
/* 830 */     return this.PageImgHeight;
/*     */   }
/*     */ 
/*     */   public int getPageImgLabelSize() {
/* 834 */     return this.PageImgLabelSize;
/*     */   }
/*     */ 
/*     */   public double getAfterDeathRateR() {
/* 838 */     return this.AfterDeathRateR;
/*     */   }
/*     */ 
/*     */   public double getBLoanRate()
/*     */   {
/* 847 */     return this.BLoanRate;
/*     */   }
/*     */ 
/*     */   public double getLoanRate() {
/* 851 */     return this.LoanRate;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.StaticConst
 * JD-Core Version:    0.6.0
 */