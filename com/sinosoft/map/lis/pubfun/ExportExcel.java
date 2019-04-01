/*     */ package com.sinosoft.map.lis.pubfun;
/*     */ 
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.StrTool;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import org.apache.poi.hssf.usermodel.HSSFCell;
/*     */ import org.apache.poi.hssf.usermodel.HSSFCellStyle;
/*     */ import org.apache.poi.hssf.usermodel.HSSFFont;
/*     */ import org.apache.poi.hssf.usermodel.HSSFRow;
/*     */ import org.apache.poi.hssf.usermodel.HSSFSheet;
/*     */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*     */ import org.apache.poi.hssf.util.Region;
/*     */ 
/*     */ public class ExportExcel
/*     */ {
/*     */   public static void AddCellToList(ArrayList list, String text, int row, int col, int width, int height, boolean bBorder, boolean bBold)
/*     */   {
/*  87 */     Cell tCell = new Cell();
/*  88 */     tCell.row = row;
/*  89 */     tCell.col = col;
/*  90 */     tCell.bBorder = bBorder;
/*  91 */     tCell.bBold = bBold;
/*  92 */     tCell.height = height;
/*  93 */     tCell.width = width;
/*  94 */     tCell.content = text;
/*  95 */     list.add(tCell);
/*     */   }
/*     */ 
/*     */   public boolean write(Format format, BufferedOutputStream bos)
/*     */   {
/* 104 */     if (format == null)
/* 105 */       return false;
/* 106 */     ArrayList listCell = format.mListCell;
/* 107 */     ArrayList listLB = format.mListBL;
/* 108 */     ArrayList listColWidth = format.mListColWidth;
/*     */ 
/* 110 */     if ((listCell == null) && (listLB == null))
/* 111 */       return false;
/* 112 */     if (bos == null) {
/* 113 */       return false;
/*     */     }
/* 115 */     HSSFWorkbook wb = new HSSFWorkbook();
/* 116 */     HSSFSheet sheet = wb.createSheet("new sheet");
/*     */     try
/*     */     {
/* 120 */       if (listColWidth != null) {
/* 121 */         for (int i = 0; i < listColWidth.size(); i++) {
/* 122 */           String[] para = (String[])listColWidth.get(i);
/* 123 */           short nCol = (short)Integer.parseInt(para[0]);
/* 124 */           short nWidth = (short)Integer.parseInt(para[1]);
/* 125 */           sheet.setColumnWidth(nCol, nWidth);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 130 */       HSSFFont fontBold = wb.createFont();
/* 131 */       fontBold.setFontHeightInPoints(10);
/* 132 */       fontBold.setFontName("\u5B8B\u4F53");
/* 133 */       fontBold.setBoldweight(700);
/*     */ 
/* 135 */       HSSFFont fontNormal = wb.createFont();
/* 136 */       fontNormal.setFontHeightInPoints(10);
/* 137 */       fontNormal.setFontName("\u5B8B\u4F53");
/* 138 */       fontNormal.setBoldweight(400);
/*     */ 
/* 140 */       HSSFCellStyle styleBorderBold = wb.createCellStyle();
/* 141 */       styleBorderBold.setBorderBottom(1);
/* 142 */       styleBorderBold.setBorderLeft(1);
/* 143 */       styleBorderBold.setBorderRight(1);
/* 144 */       styleBorderBold.setBorderTop(1);
/* 145 */       styleBorderBold.setFont(fontBold);
/*     */ 
/* 147 */       HSSFCellStyle styleBorderNormal = wb.createCellStyle();
/* 148 */       styleBorderNormal.setBorderBottom(1);
/* 149 */       styleBorderNormal.setBorderLeft(1);
/* 150 */       styleBorderNormal.setBorderRight(1);
/* 151 */       styleBorderNormal.setBorderTop(1);
/* 152 */       styleBorderNormal.setFont(fontNormal);
/*     */ 
/* 154 */       HSSFCellStyle styleBold = wb.createCellStyle();
/* 155 */       styleBold.setFont(fontBold);
/*     */ 
/* 157 */       HSSFCellStyle styleNormal = wb.createCellStyle();
/* 158 */       styleNormal.setFont(fontNormal);
/*     */ 
/* 160 */       if (listLB != null) {
/* 161 */         for (int iLB = 0; iLB < listLB.size(); iLB++) {
/* 162 */           ListBlock currLB = (ListBlock)listLB.get(iLB);
/* 163 */           int startRow = currLB.row1;
/* 164 */           for (int i = 0; (currLB.colName != null) && (i < currLB.colName.length); i++) {
/* 165 */             int rowIndex = startRow;
/* 166 */             int colIndex = currLB.col1 + i;
/* 167 */             HSSFRow row = sheet.getRow(rowIndex);
/* 168 */             if (row == null)
/* 169 */               row = sheet.createRow(rowIndex);
/* 170 */             HSSFCell cell = row.getCell((short)colIndex);
/* 171 */             if (cell == null)
/* 172 */               cell = row.createCell((short)colIndex);
/* 173 */             cell.setCellType(1);
/* 174 */             cell.setCellStyle(styleBorderBold);
/* 175 */             cell.setEncoding(1);
/* 176 */             cell.setCellValue(currLB.colName[i]);
/*     */           }
/*     */ 
/* 179 */           if (currLB.colName != null) {
/* 180 */             startRow = currLB.row1 + 1;
/*     */           }
/* 182 */           String[][] data = currLB.data;
/* 183 */           if (data != null) {
/* 184 */             for (int i = 0; i < data.length; i++) {
/* 185 */               for (int j = 0; j < data[i].length; j++) {
/* 186 */                 int rowIndex = startRow + i;
/* 187 */                 int colIndex = currLB.col1 + j;
/*     */ 
/* 189 */                 HSSFRow row = sheet.getRow(rowIndex);
/* 190 */                 if (row == null)
/* 191 */                   row = sheet.createRow(rowIndex);
/* 192 */                 HSSFCell cell = row.getCell((short)colIndex);
/* 193 */                 if (cell == null)
/* 194 */                   cell = row.createCell((short)colIndex);
/* 195 */                 cell.setCellType(1);
/* 196 */                 cell.setCellStyle(styleBorderNormal);
/* 197 */                 cell.setEncoding(1);
/* 198 */                 cell.setCellValue(data[i][j]);
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 206 */       if (listCell != null) {
/* 207 */         for (int i = 0; i < listCell.size(); i++) {
/* 208 */           Cell currCell = (Cell)listCell.get(i);
/* 209 */           for (int j = currCell.row; j < currCell.row + currCell.height; j++) {
/* 210 */             for (int k = currCell.col; k < currCell.col + currCell.width; k++) {
/* 211 */               HSSFRow trow = sheet.getRow(j);
/* 212 */               if (trow == null)
/* 213 */                 trow = sheet.createRow(j);
/* 214 */               HSSFCell tcell = trow.getCell((short)k);
/* 215 */               if (tcell == null)
/* 216 */                 tcell = trow.createCell((short)k);
/* 217 */               tcell.setCellType(1);
/* 218 */               tcell.setEncoding(1);
/* 219 */               if ((j == currCell.row) && (k == currCell.col))
/* 220 */                 tcell.setCellValue(currCell.content);
/* 221 */               if (currCell.bBorder) {
/* 222 */                 if (currCell.bBold)
/* 223 */                   tcell.setCellStyle(styleBorderBold);
/*     */                 else {
/* 225 */                   tcell.setCellStyle(styleBorderNormal);
/*     */                 }
/*     */               }
/* 228 */               else if (currCell.bBold)
/* 229 */                 tcell.setCellStyle(styleBold);
/*     */               else {
/* 231 */                 tcell.setCellStyle(styleNormal);
/*     */               }
/*     */             }
/*     */           }
/* 235 */           if ((currCell.height > 1) || (currCell.width > 1)) {
/* 236 */             sheet.addMergedRegion(new Region(currCell.row, (short)currCell.col, currCell.row + currCell.height - 1, (short)(currCell.col + currCell.width - 1)));
/*     */           }
/*     */         }
/*     */       }
/* 240 */       wb.write(bos);
/*     */     }
/*     */     catch (Exception e) {
/* 243 */       System.out.println(e);
/* 244 */       return false;
/*     */     }
/*     */ 
/* 247 */     return true;
/*     */   }
/*     */ 
/*     */   public static String[][] exeSQL(String sql, String companyCode)
/*     */   {
/* 252 */     String[][] retArray = null;
/*     */ 
/* 254 */     Statement stmt = null;
/* 255 */     ResultSet rs = null;
/* 256 */     ResultSetMetaData rsmd = null;
/* 257 */     String mResult = "";
/* 258 */     ArrayList tempList = new ArrayList();
/*     */ 
/* 260 */     System.out.println("ExportExcel.exeSQL() : " + sql.trim());
/* 261 */     Connection conn = null;
/* 262 */     conn = DBConnPool.getConnection();
/* 263 */     if (conn == null)
/*     */     {
/* 265 */       System.out.println("\u6570\u636E\u5E93\u8FDE\u63A5\u5931\u8D25\uFF01");
/* 266 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 270 */       stmt = conn.createStatement(1003, 1007);
/*     */ 
/* 272 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 273 */       rsmd = rs.getMetaData();
/* 274 */       int n = rsmd.getColumnCount();
/* 275 */       int k = 0;
/*     */ 
/* 278 */       while (rs.next()) {
/* 279 */         String[] tempRow = new String[n];
/* 280 */         k++;
/* 281 */         for (int j = 1; j <= n; j++) {
/* 282 */           String strValue = "";
/*     */ 
/* 284 */           strValue = getDataValue(rsmd, rs, j);
/* 285 */           tempRow[(j - 1)] = strValue;
/*     */         }
/* 287 */         tempList.add(tempRow);
/*     */       }
/* 289 */       rs.close();
/* 290 */       stmt.close();
/*     */ 
/* 292 */       if (tempList.size() > 0) {
/* 293 */         retArray = new String[tempList.size()][];
/* 294 */         for (int i = 0; i < tempList.size(); i++) {
/* 295 */           String[] row = (String[])tempList.get(i);
/* 296 */           retArray[i] = row;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 304 */       e.printStackTrace();
/*     */       try { rs.close(); stmt.close(); } catch (Exception localException1) {
/*     */       }
/*     */       try {
/* 308 */         conn.close(); } catch (Exception localException2) {
/*     */       } } finally { try { conn.close();
/*     */       } catch (Exception localException3) {
/*     */       } }
/* 311 */     return retArray;
/*     */   }
/*     */ 
/*     */   public static String[][] exeSQL(String sql, Connection conn) {
/* 315 */     String[][] retArray = null;
/*     */ 
/* 317 */     Statement stmt = null;
/* 318 */     ResultSet rs = null;
/* 319 */     ResultSetMetaData rsmd = null;
/* 320 */     String mResult = "";
/* 321 */     ArrayList tempList = new ArrayList();
/*     */ 
/* 323 */     System.out.println("ExportExcel.exeSQL() : " + sql.trim());
/* 324 */     boolean connflag = true;
/* 325 */     if (conn == null)
/*     */     {
/* 327 */       System.out.println("\u6570\u636E\u5E93\u8FDE\u63A5\u5931\u8D25\uFF01");
/* 328 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 332 */       stmt = conn.createStatement(1003, 1007);
/*     */ 
/* 334 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/* 335 */       rsmd = rs.getMetaData();
/* 336 */       int n = rsmd.getColumnCount();
/* 337 */       int k = 0;
/*     */ 
/* 340 */       while (rs.next()) {
/* 341 */         String[] tempRow = new String[n];
/* 342 */         k++;
/* 343 */         for (int j = 1; j <= n; j++) {
/* 344 */           String strValue = "";
/*     */ 
/* 346 */           strValue = getDataValue(rsmd, rs, j);
/* 347 */           tempRow[(j - 1)] = strValue;
/*     */         }
/* 349 */         tempList.add(tempRow);
/*     */       }
/* 351 */       rs.close();
/* 352 */       stmt.close();
/*     */ 
/* 354 */       if (tempList.size() > 0) {
/* 355 */         retArray = new String[tempList.size()][];
/* 356 */         for (int i = 0; i < tempList.size(); i++) {
/* 357 */           String[] row = (String[])tempList.get(i);
/* 358 */           retArray[i] = row;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 366 */       e.printStackTrace();
/*     */       try { rs.close(); stmt.close(); } catch (Exception localException1) {
/*     */       }
/*     */     }
/* 369 */     return retArray;
/*     */   }
/*     */ 
/*     */   public static String getDataValue(ResultSetMetaData rsmd, ResultSet rs, int i)
/*     */   {
/* 375 */     String strValue = "";
/*     */     try
/*     */     {
/* 378 */       int dataType = rsmd.getColumnType(i);
/* 379 */       int dataScale = rsmd.getScale(i);
/* 380 */       int dataPrecision = rsmd.getPrecision(i);
/* 381 */       if ((dataType == 1) || (dataType == 12)) strValue = StrTool.unicodeToGBK(rs.getString(i));
/* 382 */       if ((dataType == 93) || (dataType == 91)) strValue = new FDate().getString(rs.getDate(i));
/* 383 */       if ((dataType == 3) || (dataType == 8)) strValue = String.valueOf(rs.getDouble(i));
/* 384 */       if ((dataType == 4) || (dataType == 5)) strValue = String.valueOf(rs.getInt(i));
/* 385 */       if (dataType == 2)
/*     */       {
/* 387 */         if (dataScale == 0)
/*     */         {
/* 389 */           if (dataPrecision == 0)
/* 390 */             strValue = String.valueOf(rs.getDouble(i));
/*     */           else
/* 392 */             strValue = String.valueOf(rs.getLong(i));
/*     */         }
/*     */         else {
/* 395 */           strValue = String.valueOf(rs.getBigDecimal(i));
/* 396 */           System.out.println("BigDecimal: The Numeric is = " + strValue);
/*     */         }
/*     */       }
/* 399 */       if (strValue == null)
/* 400 */         strValue = "";
/* 401 */       strValue = PubFun.getInt(strValue);
/*     */     }
/*     */     catch (Exception localException) {
/*     */     }
/* 405 */     return strValue;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 410 */     ExportExcel excel = new ExportExcel();
/*     */     try {
/* 412 */       Format format = new Format();
/* 413 */       ArrayList listCell = new ArrayList();
/* 414 */       ArrayList listLB = new ArrayList();
/* 415 */       ArrayList listColWidth = new ArrayList();
/* 416 */       format.mListCell = listCell;
/* 417 */       format.mListBL = listLB;
/* 418 */       format.mListColWidth = listColWidth;
/*     */ 
/* 420 */       listColWidth.add(new String[] { "0", "5000" });
/*     */ 
/* 448 */       ListBlock tLB1 = new ListBlock("001");
/*     */ 
/* 453 */       tLB1.colName = new String[] { "\u96C6\u4F53\u5408\u540C\u53F7\u7801", "\u88AB\u4FDD\u4EBA\u5BA2\u6237\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u51FA\u751F\u65E5\u671F", "\u8BC1\u4EF6\u7C7B\u578B", "\u8BC1\u4EF6\u53F7\u7801", "\u4FDD\u9669\u8BA1\u5212" };
/* 454 */       tLB1.sql = "select Grpcontno,InsuredNo,Name,Sex,Birthday,IDType,IDNo,ContPlanCode From LCInsured where Grpcontno='140110000000041'";
/*     */ 
/* 456 */       tLB1.col1 = 0;
/*     */ 
/* 458 */       tLB1.row1 = 0;
/* 459 */       tLB1.InitData();
/* 460 */       listLB.add(tLB1);
/*     */ 
/* 462 */       File of = new File("d:\\excel.xls");
/* 463 */       FileOutputStream ofs = new FileOutputStream(of);
/* 464 */       BufferedOutputStream bos = new BufferedOutputStream(ofs);
/* 465 */       excel.write(format, bos);
/*     */     } catch (Exception e) {
/* 467 */       System.out.println(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class Cell
/*     */   {
/*     */     public int col;
/*     */     public int row;
/*  23 */     public int width = 1;
/*  24 */     public int height = 1;
/*  25 */     public boolean bBorder = false;
/*  26 */     public boolean bBold = false;
/*  27 */     public String content = "";
/*     */   }
/*     */ 
/*     */   public static class Format
/*     */   {
/*  15 */     public ArrayList mListCell = null;
/*  16 */     public ArrayList mListBL = null;
/*  17 */     public ArrayList mListColWidth = null;
/*     */   }
/*     */ 
/*     */   public static class ListBlock
/*     */   {
/*     */     private String companyCode;
/*  34 */     public String[] colName = null;
/*     */     public String sql;
/*  36 */     public int row1 = 0;
/*  37 */     public int col1 = 0;
/*     */     public int row2;
/*     */     public int col2;
/*  40 */     public int size = 0;
/*  41 */     public String[][] data = null;
/*     */ 
/*     */     public ListBlock(String str)
/*     */     {
/*  32 */       this.companyCode = str;
/*     */     }
/*     */ 
/*     */     public boolean InitData()
/*     */     {
/*  43 */       if ((this.sql == null) || (this.sql.equals("")))
/*  44 */         return false;
/*  45 */       Connection conn = null;
/*     */       try {
/*  47 */         conn = DBConnPool.getConnection();
/*  48 */         if (conn == null)
/*     */         {
/*  50 */           System.out.println("\u6570\u636E\u5E93\u8FDE\u63A5\u5931\u8D25\uFF01");
/*     */           return false;
/*     */         }
/*  53 */         this.data = ExportExcel.exeSQL(this.sql, conn);
/*  54 */         if (this.data == null) {
/*  55 */           this.row2 = this.row1;
/*  56 */           this.col2 = this.col1;
/*  57 */           if (this.colName != null) {
/*  58 */             this.row2 += 1;
/*  59 */             this.col2 += this.colName.length;
/*     */           }
/*     */         }
/*     */         else {
/*  63 */           this.row2 = (this.row1 + this.data.length);
/*  64 */           this.size = this.data.length;
/*  65 */           if (this.colName != null) {
/*  66 */             this.row2 += 1;
/*  67 */             this.col2 = (this.col1 + this.colName.length);
/*     */           }
/*  69 */           else if (this.data.length > 1) {
/*  70 */             this.col2 = (this.col1 + this.data[0].length);
/*     */           }
/*     */           else {
/*  73 */             this.col2 = this.col1;
/*     */           }
/*     */         }
/*     */       } catch (Exception e) {
/*  77 */         System.out.println(e);
/*     */         return false;
/*     */       } finally {
/*     */         try {
/*  80 */           conn.close(); } catch (Exception localException3) {  }
/*     */       }try { conn.close(); } catch (Exception localException4) {
/*     */       }
/*  82 */       return true;
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.pubfun.ExportExcel
 * JD-Core Version:    0.6.0
 */