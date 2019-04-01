/*      */ package com.sinosoft.map.lis.excel;
/*      */ 
/*      */ import com.sinosoft.map.utility.ListTable;
/*      */ import com.sinosoft.map.utility.SSRS;
/*      */ import java.io.BufferedWriter;
/*      */ import java.io.File;
/*      */ import java.io.FileInputStream;
/*      */ import java.io.FileNotFoundException;
/*      */ import java.io.FileOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.OutputStreamWriter;
/*      */ import java.io.PrintStream;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.Vector;
/*      */ import java.util.zip.ZipEntry;
/*      */ import java.util.zip.ZipOutputStream;
/*      */ import jxl.Cell;
/*      */ import jxl.Range;
/*      */ import jxl.Workbook;
/*      */ import jxl.biff.FontRecord;
/*      */ import jxl.format.Alignment;
/*      */ import jxl.format.Border;
/*      */ import jxl.format.BorderLineStyle;
/*      */ import jxl.format.CellFormat;
/*      */ import jxl.format.VerticalAlignment;
/*      */ import jxl.read.biff.BiffException;
/*      */ import jxl.write.Label;
/*      */ import jxl.write.Number;
/*      */ import jxl.write.NumberFormat;
/*      */ import jxl.write.WritableCellFormat;
/*      */ import jxl.write.WritableFont;
/*      */ import jxl.write.WritableSheet;
/*      */ import jxl.write.WritableWorkbook;
/*      */ import jxl.write.WriteException;
/*      */ import jxl.write.biff.RowsExceededException;
/*      */ 
/*      */ public class SimpleWorkbook
/*      */ {
/*   48 */   private WritableWorkbook workbook = null;
/*      */ 
/*   50 */   private int sheetIndex = 0;
/*      */ 
/*   52 */   private int size = 0;
/*      */ 
/*   54 */   private WritableCellFormat defaultFormat = null;
/*      */ 
/*   58 */   private Map colFormat = new HashMap();
/*      */ 
/*   60 */   private Map rowFormat = new HashMap();
/*      */ 
/*   62 */   private CellFormat bothFormat = null;
/*      */ 
/*   65 */   private Map numberCols = new HashMap();
/*      */ 
/*   67 */   private Map numberColFormat = new HashMap();
/*      */ 
/*   69 */   private Set mergeCol = new HashSet();
/*      */ 
/*   71 */   private Set downNullMergeCol = new HashSet();
/*      */ 
/*   73 */   private Set mergerAllCol = new HashSet();
/*      */ 
/*   75 */   private Set noZeroNumber = new HashSet();
/*      */ 
/*   78 */   private Map arrayCol = new HashMap();
/*      */ 
/*   81 */   private int startCol = 0;
/*      */ 
/*   83 */   private int startRow = 0;
/*      */ 
/*   85 */   private int endCol = -1;
/*      */ 
/*   89 */   private int templetRow = 0;
/*      */ 
/*   91 */   private int templetCol = 0;
/*      */   private static final String ROW = "#row#";
/*      */   private static final String COL = "#col#";
/*      */   private static final String BOTH = "#default#";
/*      */   private static final String CELL = "#cell#";
/*      */   private static final String MERGE = "#merge#";
/*      */   private static final String DOWN_NULL_MERGE = "dmerge";
/*      */   private static final String TRAIL = "#trail#";
/*      */   private static final String END = "#end#";
/*      */   private static final String MERGE_ROW_FLAG = "#merge(-1,-0)";
/*  117 */   private String fileName = null;
/*      */ 
/*  120 */   EvanLog logger = EvanLog.getLoger();
/*      */ 
/*      */   public SimpleWorkbook()
/*      */   {
/*      */   }
/*      */ 
/*      */   public SimpleWorkbook(String resultPath, String templetPath)
/*      */     throws ExcelException
/*      */   {
/*  138 */     this.fileName = resultPath;
/*      */     try {
/*  140 */       this.workbook = Workbook.createWorkbook(new File(resultPath), 
/*  141 */         Workbook.getWorkbook(new File(templetPath)));
/*      */     } catch (BiffException e) {
/*  143 */       throw new ExcelException(e);
/*      */     } catch (IOException e) {
/*  145 */       throw new ExcelException(e.getMessage());
/*      */     }
/*      */ 
/*  149 */     WritableFont datawf = new WritableFont(WritableFont.ARIAL, 10, 
/*  150 */       WritableFont.NO_BOLD, false);
/*      */ 
/*  152 */     this.defaultFormat = new WritableCellFormat(datawf);
/*      */     try {
/*  154 */       this.defaultFormat.setWrap(true);
/*  155 */       this.defaultFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
/*  156 */       this.defaultFormat.setAlignment(Alignment.CENTRE);
/*  157 */       this.defaultFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
/*      */     } catch (WriteException e) {
/*  159 */       e.printStackTrace();
/*      */     }
/*  161 */     collectFormat();
/*      */   }
/*      */ 
/*      */   private void collectFormat()
/*      */   {
/*  166 */     WritableSheet sheet = this.workbook.getSheet(0);
/*  167 */     this.templetCol = sheet.getColumns();
/*  168 */     this.templetRow = sheet.getRows();
/*      */ 
/*  172 */     this.logger.log("SimpleWorkbook collectFormat()------for start");
/*  173 */     for (int i = 0; i < this.templetRow; i++)
/*  174 */       for (int j = 0; j < this.templetCol; j++) {
/*  175 */         Cell cell = sheet.getWritableCell(j, i);
/*  176 */         String c = cell.getContents();
/*      */ 
/*  181 */         if ((c == null) || (c.trim().equals(""))) {
/*      */           continue;
/*      */         }
/*  184 */         String contents = c.trim();
/*      */ 
/*  188 */         if (contents.equals("#default#")) {
/*  189 */           this.bothFormat = cell.getCellFormat();
/*  190 */           this.startCol = j;
/*  191 */           this.startRow = i;
/*  192 */         } else if (contents.equals("#row#")) {
/*  193 */           this.rowFormat.put(new Integer(cell.getRow()), cell
/*  194 */             .getCellFormat());
/*  195 */         } else if (contents.equals("#col#")) {
/*  196 */           this.colFormat.put(new Integer(cell.getColumn()), cell
/*  197 */             .getCellFormat());
/*  198 */         } else if ((contents.startsWith("#.")) && (contents.endsWith("##")))
/*      */         {
/*  201 */           int length = contents.trim().length();
/*  202 */           if (length < 3) {
/*      */             continue;
/*      */           }
/*  205 */           Integer i2 = null;
/*      */           try {
/*  207 */             i2 = new Integer(contents.substring(2, length - 2));
/*      */           } catch (Exception e) {
/*  209 */             continue;
/*      */           }
/*  211 */           this.numberCols.put(new Integer(cell.getColumn()), i2);
/*  212 */           this.colFormat.put(new Integer(cell.getColumn()), cell
/*  213 */             .getCellFormat());
/*  214 */           this.noZeroNumber.add(new Integer(cell.getColumn()));
/*  215 */         } else if ((contents.startsWith("#.")) && (contents.endsWith("#")))
/*      */         {
/*  217 */           int length = contents.trim().length();
/*  218 */           if (length < 3) {
/*      */             continue;
/*      */           }
/*  221 */           Integer i2 = null;
/*      */           try {
/*  223 */             i2 = new Integer(contents.substring(2, length - 1));
/*      */           } catch (Exception e) {
/*  225 */             continue;
/*      */           }
/*  227 */           this.numberCols.put(new Integer(cell.getColumn()), i2);
/*  228 */           this.colFormat.put(new Integer(cell.getColumn()), cell
/*  229 */             .getCellFormat());
/*  230 */         } else if ((contents.startsWith("[")) && (contents.endsWith("]")))
/*      */         {
/*  232 */           int length = contents.trim().length();
/*  233 */           if (length < 3)
/*      */           {
/*      */             continue;
/*      */           }
/*  237 */           WritableCellFormat fivedpsFormat = null;
/*      */           try {
/*  239 */             String format = contents.substring(1, length - 1);
/*  240 */             NumberFormat fivedps = new NumberFormat(format);
/*  241 */             fivedpsFormat = new WritableCellFormat(fivedps);
/*      */           }
/*      */           catch (Exception e) {
/*  244 */             continue;
/*      */           }
/*  246 */           this.numberCols.put(new Integer(cell.getColumn()), new Integer(-100));
/*  247 */           this.colFormat.put(new Integer(cell.getColumn()), fivedpsFormat);
/*  248 */         } else if (contents.equals("#merge#")) {
/*  249 */           this.mergeCol.add(new Integer(j));
/*  250 */         } else if ((contents.startsWith("#$")) && (contents.endsWith("#")))
/*      */         {
/*  252 */           int k = contents.length();
/*  253 */           String str = contents.substring(2, k - 1);
/*      */           try {
/*  255 */             this.arrayCol.put(new Integer(cell.getColumn()), 
/*  256 */               new Integer(str));
/*      */           } catch (Exception e) {
/*  258 */             e.printStackTrace();
/*      */           }
/*  260 */         } else if (contents.equalsIgnoreCase("dmerge")) {
/*  261 */           this.downNullMergeCol.add(new Integer(j));
/*  262 */         } else if (contents.equals("#end#")) {
/*  263 */           this.endCol = cell.getColumn();
/*      */         }
/*      */       }
/*  266 */     this.logger.log("SimpleWorkbook collectFormat()------for end");
/*      */   }
/*      */ 
/*      */   private SimpleWorkbook add(int row, int column, String contents, String sign) throws ExcelException
/*      */   {
/*  271 */     return add(row, column, contents, sign, 0);
/*      */   }
/*      */ 
/*      */   private SimpleWorkbook add(int row, int column, String contents, String sign, int sheetIndex)
/*      */     throws ExcelException
/*      */   {
/*  286 */     WritableSheet sheet = this.workbook.getSheet(sheetIndex);
/*  287 */     Cell oldCell = sheet.getCell(column, row);
/*  288 */     CellFormat format = getFormat(oldCell);
/*      */     try
/*      */     {
/*  291 */       if (((sign.equals("AUTO")) || (sign.equals("NUMBER"))) && 
/*  292 */         (isNumber(oldCell))) {
/*  293 */         if ((contents == null) || (contents.trim().equalsIgnoreCase("null")) || 
/*  294 */           (contents.trim().equals(""))) {
/*  295 */           contents = "";
/*  296 */           Label label = new Label(column, row, "", format);
/*  297 */           sheet.addCell(label);
/*  298 */         } else if (contents.toLowerCase().contains("#merge")) {
/*  299 */           String tmp = contents.substring(contents.indexOf("(") + 1, contents.indexOf(")"));
/*  300 */           String left = tmp.substring(0, tmp.indexOf(","));
/*  301 */           String up = tmp.substring(tmp.indexOf(",") + 1);
/*  302 */           sheet.mergeCells(column + Integer.parseInt(left), row + Integer.parseInt(up), column, row);
/*  303 */         } else if ((Double.parseDouble(contents.trim()) == 0.0D) && (!"0".equals(contents.trim())) && (this.noZeroNumber.contains(new Integer(column))))
/*      */         {
/*  305 */           Label label = new Label(column, row, "", format);
/*  306 */           sheet.addCell(label);
/*      */         } else {
/*  308 */           WritableCellFormat wcf = getNumberFormat(oldCell);
/*  309 */           Number number = new Number(column, row, 
/*  310 */             new Double(contents
/*  310 */             .toString()).doubleValue(), wcf);
/*  311 */           sheet.addCell(number);
/*      */         }
/*      */       } else {
/*  314 */         if ((contents == null) || (contents.trim().equalsIgnoreCase("null")) || 
/*  315 */           (contents.trim().equals(""))) {
/*  316 */           contents = "";
/*      */         }
/*  318 */         Label label = new Label(column, row, contents, format);
/*  319 */         sheet.addCell(label);
/*      */       }
/*      */     } catch (RowsExceededException e1) {
/*  322 */       e1.printStackTrace();
/*      */     } catch (NumberFormatException e1) {
/*  324 */       e1.printStackTrace();
/*      */     } catch (WriteException e1) {
/*  326 */       e1.printStackTrace();
/*      */     }
/*  328 */     return this;
/*      */   }
/*      */ 
/*      */   private WritableCellFormat getNumberFormat(Cell oldCell) {
/*  332 */     WritableCellFormat wcf = 
/*  333 */       (WritableCellFormat)this.numberColFormat
/*  333 */       .get(new Integer(oldCell.getColumn()));
/*  334 */     if (wcf == null) {
/*  335 */       if (getFrac(oldCell) == 0)
/*      */       {
/*  337 */         wcf = new WritableCellFormat(new NumberFormat("0"));
/*  338 */       } else if (getFrac(oldCell) == -100)
/*      */       {
/*  340 */         wcf = (WritableCellFormat)this.colFormat.get(new Integer(oldCell.getColumn()));
/*      */         try {
/*  342 */           wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
/*      */         } catch (WriteException e) {
/*  344 */           e.printStackTrace();
/*      */         }
/*      */       }
/*  347 */       else if (getFrac(oldCell) == -1) {
/*  348 */         wcf = new WritableCellFormat();
/*      */       } else {
/*  350 */         StringBuffer sb = new StringBuffer("0.");
/*  351 */         this.logger.log("simpleWorkbook getNumberFormat(Cell oldCell)----for start");
/*  352 */         for (int i = 0; i < getFrac(oldCell); i++) {
/*  353 */           sb.append("0");
/*      */         }
/*  355 */         this.logger.log("simpleWorkbook getNumberFormat(Cell oldCell)----for end");
/*  356 */         NumberFormat nf = new NumberFormat(sb.toString());
/*  357 */         wcf = new WritableCellFormat(nf);
/*      */       }
/*      */ 
/*  360 */       CellFormat format = (CellFormat)this.colFormat.get(
/*  361 */         new Integer(oldCell
/*  361 */         .getColumn()));
/*  362 */       if (format == null) {
/*  363 */         format = this.bothFormat;
/*      */       }
/*  365 */       copy(format, wcf);
/*      */ 
/*  367 */       this.numberColFormat.put(new Integer(oldCell.getColumn()), wcf);
/*      */     }
/*      */ 
/*  370 */     return wcf;
/*      */   }
/*      */ 
/*      */   public void add(String[][] strArr)
/*      */   {
/*  387 */     addTrail(strArr.length + this.startRow + 1);
/*      */ 
/*  389 */     this.size = strArr.length;
/*  390 */     int col = this.startCol;
/*  391 */     int colt = this.startCol;
/*  392 */     int row = this.startRow;
/*  393 */     this.logger.log("SimpleWorkbook add(String[][] strArr)-----for start");
/*  394 */     for (int i = 0; i < strArr.length; i++) {
/*  395 */       for (int j = 0; j < strArr[i].length; j++) {
/*  396 */         Integer colTmp = redirect(col);
/*      */         try {
/*  398 */           if (colTmp != null)
/*  399 */             add(row, col, strArr[i][colTmp.intValue()], "AUTO");
/*      */           else
/*  401 */             add(row, col, strArr[i][j], "AUTO");
/*      */         }
/*      */         catch (ExcelException e) {
/*  404 */           e.printStackTrace();
/*      */         }
/*  406 */         col++;
/*  407 */         if (col >= strArr[i].length + colt)
/*  408 */           col = colt;
/*  409 */         if (col == this.endCol) {
/*  410 */           col = colt;
/*  411 */           break;
/*      */         }
/*      */       }
/*  414 */       row++;
/*      */     }
/*  416 */     this.logger.log("SimpleWorkbook add(String[][] strArr)-----for end");
/*  417 */     clearSign();
/*  418 */     merge();
/*      */     try {
/*  420 */       write();
/*      */     } catch (ExcelException e) {
/*  422 */       e.printStackTrace();
/*      */     }
/*      */     try
/*      */     {
/*  426 */       close();
/*      */     } catch (ExcelException e) {
/*  428 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   public void createZip(String[] array, String txtName, String txtPath)
/*      */   {
/*  544 */     System.out.println("SimpleWorkbook----add(array array):" + 
/*  545 */       array);
/*      */ 
/*  547 */     int maxRow = 0;
/*  548 */     if (array.length >= maxRow)
/*      */     {
/*  587 */       System.out.println("aaaaaaaaaaa" + this.fileName);
/*  588 */       int t = this.fileName.indexOf("E");
/*  589 */       System.out.println("bbbbbbbbbbbbb" + t);
/*  590 */       String temtxtPath = txtPath.replace('/', File.separatorChar) + this.fileName.substring(t + "E:\tmp".length() + 1);
/*      */ 
/*  592 */       System.out.println("temtxtPath=" + temtxtPath);
/*  593 */       String zipfile = temtxtPath.replaceAll(".xls", ".zip");
/*      */ 
/*  595 */       System.out.println("create zip:" + temtxtPath);
/*      */ 
/*  597 */       BufferedWriter writer = null;
/*      */       try
/*      */       {
/*  617 */         ZipOutputStream zipout = new ZipOutputStream(
/*  618 */           new FileOutputStream(zipfile));
/*  619 */         zipout.putNextEntry(new ZipEntry(txtName + ".txt"));
/*  620 */         writer = new BufferedWriter(new OutputStreamWriter(zipout));
/*      */ 
/*  622 */         for (int i = 0; i < array.length; i++) {
/*  623 */           String row = array[i];
/*      */ 
/*  630 */           writer.write(row);
/*  631 */           writer.newLine();
/*      */         }
/*  633 */         writer.flush();
/*  634 */         if (writer != null) {
/*  635 */           writer.close();
/*  636 */           zipout = null;
/*      */         }
/*  638 */         if (zipout != null) {
/*  639 */           zipout.close();
/*      */         }
/*      */       }
/*      */       catch (FileNotFoundException e)
/*      */       {
/*  644 */         e.printStackTrace();
/*      */       }
/*      */       catch (IOException e) {
/*  647 */         e.printStackTrace();
/*      */       }
/*      */     }
/*      */     try
/*      */     {
/*  652 */       write();
/*      */     } catch (ExcelException e) {
/*  654 */       e.printStackTrace();
/*      */     }
/*      */     try
/*      */     {
/*  658 */       close();
/*      */     } catch (ExcelException e) {
/*  660 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   public void createTxt(String[] array, String txtName, String txtPath)
/*      */   {
/*  666 */     System.out.println("SimpleWorkbook----add(array array):" + 
/*  667 */       array);
/*      */ 
/*  669 */     int maxRow = 0;
/*  670 */     if (array.length >= maxRow)
/*      */     {
/*  709 */       System.out.println("aaaaaaaaaaa" + this.fileName);
/*  710 */       int t = this.fileName.indexOf("E");
/*  711 */       System.out.println("bbbbbbbbbbbbb" + t);
/*  712 */       String temtxtPath = txtPath.replace('/', File.separatorChar) + this.fileName.substring(t + "E:\tmp".length() + 1);
/*      */ 
/*  714 */       System.out.println("temtxtPath=" + temtxtPath);
/*  715 */       String txtfile = temtxtPath.replaceAll(".xls", ".zip");
/*      */ 
/*  717 */       System.out.println("create txt:" + txtfile);
/*      */ 
/*  719 */       BufferedWriter writer = null;
/*      */       try
/*      */       {
/*  739 */         FileOutputStream txtout = new FileOutputStream(
/*  740 */           new File(txtfile));
/*      */ 
/*  742 */         writer = new BufferedWriter(new OutputStreamWriter(txtout));
/*      */ 
/*  744 */         for (int i = 0; i < array.length; i++) {
/*  745 */           String row = array[i];
/*      */ 
/*  752 */           writer.write(row);
/*  753 */           writer.newLine();
/*      */         }
/*  755 */         writer.flush();
/*  756 */         if (writer != null) {
/*  757 */           writer.close();
/*  758 */           txtout = null;
/*      */         }
/*  760 */         if (txtout != null) {
/*  761 */           txtout.close();
/*      */         }
/*      */       }
/*      */       catch (FileNotFoundException e)
/*      */       {
/*  766 */         e.printStackTrace();
/*      */       }
/*      */       catch (IOException e) {
/*  769 */         e.printStackTrace();
/*      */       }
/*      */     }
/*      */     try
/*      */     {
/*  774 */       write();
/*      */     } catch (ExcelException e) {
/*  776 */       e.printStackTrace();
/*      */     }
/*      */     try
/*      */     {
/*  780 */       close();
/*      */     } catch (ExcelException e) {
/*  782 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   private Integer redirect(int col) {
/*  787 */     return (Integer)this.arrayCol.get(new Integer(col));
/*      */   }
/*      */ 
/*      */   public void add(SSRS sSRS)
/*      */   {
/*  804 */     addTrail(sSRS.getMaxRow() + this.startRow + 1);
/*      */ 
/*  806 */     this.size = sSRS.getMaxRow();
/*  807 */     int col = this.startCol;
/*  808 */     int colt = this.startCol;
/*  809 */     int row = this.startRow;
/*  810 */     this.logger.log("SimpleWorkbook add(SSRS sSRS)-----for start");
/*  811 */     for (int i = 0; i < sSRS.getMaxRow(); i++) {
/*  812 */       for (int j = 0; j < sSRS.getMaxCol(); j++) {
/*  813 */         Integer colTmp = redirect(col);
/*      */         try {
/*  815 */           if (colTmp != null)
/*  816 */             add(row, col, sSRS.GetText(i + 1, colTmp.intValue()), 
/*  817 */               "AUTO");
/*      */           else
/*  819 */             add(row, col, sSRS.GetText(i + 1, j + 1), "AUTO");
/*      */         }
/*      */         catch (ExcelException e) {
/*  822 */           e.printStackTrace();
/*      */         }
/*  824 */         col++;
/*  825 */         if (col >= sSRS.getMaxCol() + colt)
/*  826 */           col = colt;
/*  827 */         if (col == this.endCol) {
/*  828 */           col = colt;
/*  829 */           break;
/*      */         }
/*      */       }
/*  832 */       row++;
/*      */     }
/*  834 */     this.logger.log("SimpleWorkbook add(SSRS sSRS)-----for end");
/*  835 */     clearSign();
/*  836 */     merge();
/*      */     try {
/*  838 */       write();
/*      */     } catch (ExcelException e) {
/*  840 */       e.printStackTrace();
/*      */     }
/*      */     try
/*      */     {
/*  844 */       close();
/*      */     } catch (ExcelException e) {
/*  846 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   public void add(ListTable listTable) {
/*  851 */     System.out.println("SimpleWorkbook----add(ListTable listTable):" + listTable);
/*      */ 
/*  865 */     addTrail(listTable.size() + this.startRow + 1);
/*  866 */     System.out.println("SimpleWorkbook----addTrail();");
/*  867 */     this.size = listTable.size();
/*  868 */     int col = this.startCol;
/*  869 */     int colt = this.startCol;
/*  870 */     int row = this.startRow;
/*      */ 
/*  872 */     this.logger.log("SimpleWorkbook add(ListTable listTable)-----for start");
/*  873 */     for (int i = 0; i < listTable.size(); i++) {
/*  874 */       String[] strArr = listTable.get(i);
/*  875 */       for (int j = 0; j < strArr.length; j++) {
/*  876 */         Integer colTmp = redirect(col);
/*      */         try {
/*  878 */           if (colTmp != null)
/*  879 */             add(row, col, strArr[colTmp.intValue()], "AUTO");
/*      */           else
/*  881 */             add(row, col, strArr[j], "AUTO");
/*      */         }
/*      */         catch (ExcelException e)
/*      */         {
/*  885 */           e.printStackTrace();
/*      */         }
/*  887 */         col++;
/*  888 */         if (col >= strArr.length + colt)
/*  889 */           col = colt;
/*  890 */         if (col == this.endCol) {
/*  891 */           col = colt;
/*  892 */           break;
/*      */         }
/*      */       }
/*  895 */       row++;
/*      */     }
/*  897 */     this.logger.log("SimpleWorkbook add(ListTable listTable)-----for end");
/*  898 */     System.out.println("SimpleWorkbook----listTable added");
/*  899 */     clearSign();
/*  900 */     System.out.println("SimpleWorkbook----clearSign();");
/*  901 */     merge();
/*  902 */     System.out.println("SimpleWorkbook----merge();");
/*      */     try {
/*  904 */       write();
/*      */     } catch (ExcelException e) {
/*  906 */       e.printStackTrace();
/*      */     }
/*      */     try
/*      */     {
/*  910 */       close();
/*      */     } catch (ExcelException e) {
/*  912 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   private void addTrail(int trailStartRow) {
/*  917 */     WritableSheet sheet = this.workbook.getSheet(0);
/*  918 */     int r = sheet.getRows();
/*  919 */     int c = sheet.getColumns();
/*  920 */     Vector cells = new Vector();
/*  921 */     Vector trailRanges = new Vector();
/*  922 */     int startR = 0;
/*  923 */     int trailH = 0;
/*      */ 
/*  926 */     this.logger.log("SimpleWorkbook addTrail(int trailStartRow)-----for1 start");
/*  927 */     for (int i = 0; i < r; i++) {
/*  928 */       for (int j = 0; j < c; j++) {
/*  929 */         Cell cell = sheet.getCell(j, i);
/*  930 */         String contents = cell.getContents();
/*  931 */         if ((contents == null) || (contents.trim() == "") || 
/*  932 */           (!contents.trim().equalsIgnoreCase("#trail#"))) continue;
/*  933 */         startR = i + 1;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  938 */     this.logger.log("SimpleWorkbook addTrail(int trailStartRow)-----for1 end");
/*      */ 
/*  940 */     trailH = sheet.getRows() - startR + 1;
/*      */ 
/*  943 */     if (startR > 0) {
/*  944 */       this.logger.log("SimpleWorkbook addTrail(int trailStartRow)-----for2 start");
/*  945 */       for (int i2 = startR; i2 <= r; i2++)
/*      */       {
/*  947 */         Cell[] cell2s = sheet.getRow(i2);
/*  948 */         cells.add(cell2s);
/*  949 */         Range[] ranges = sheet.getMergedCells();
/*  950 */         for (int range = 0; range < ranges.length; range++) {
/*  951 */           if ((ranges[range].getTopLeft().getRow() < startR) || 
/*  952 */             (ranges[range].getBottomRight().getRow() > r))
/*      */             continue;
/*  954 */           trailRanges.add(ranges[range]);
/*      */         }
/*      */       }
/*  957 */       this.logger.log("SimpleWorkbook addTrail(int trailStartRow)-----for2 end");
/*      */ 
/*  960 */       this.logger.log("SimpleWorkbook addTrail(int trailStartRow)-----for3 start");
/*  961 */       for (int i3 = 0; i3 < cells.size(); i3++) {
/*  962 */         Cell[] cs = (Cell[])cells.get(i3);
/*  963 */         for (int j3 = 0; j3 < cs.length; j3++) {
/*  964 */           CellFormat format = cs[j3].getCellFormat();
/*  965 */           Label label = null;
/*  966 */           if (format != null)
/*  967 */             label = new Label(j3, i3 + trailStartRow, cs[j3]
/*  968 */               .getContents(), format);
/*      */           else {
/*  970 */             label = new Label(j3, i3 + trailStartRow, cs[j3]
/*  971 */               .getContents());
/*      */           }
/*      */           try
/*      */           {
/*  975 */             sheet.addCell(label);
/*      */           } catch (RowsExceededException e) {
/*  977 */             e.printStackTrace();
/*      */           } catch (WriteException e) {
/*  979 */             e.printStackTrace();
/*      */           }
/*      */         }
/*      */       }
/*  983 */       this.logger.log("SimpleWorkbook addTrail(int trailStartRow)-----for3 end");
/*      */ 
/*  986 */       this.logger.log("SimpleWorkbook addTrail(int trailStartRow)-----for4 start");
/*  987 */       for (int t = 0; t < trailRanges.size(); t++) {
/*  988 */         Range range = (Range)trailRanges.get(t);
/*  989 */         Cell topLeft = range.getTopLeft();
/*  990 */         Cell bottomRight = range.getBottomRight();
/*  991 */         int row2 = topLeft.getRow();
/*      */         try
/*      */         {
/*  997 */           sheet.mergeCells(topLeft.getColumn(), topLeft.getRow() - 
/*  998 */             startR + trailStartRow, bottomRight.getColumn(), 
/*  999 */             bottomRight.getRow() - startR + trailStartRow);
/*      */         } catch (RowsExceededException e) {
/* 1001 */           e.printStackTrace();
/*      */         } catch (WriteException e) {
/* 1003 */           e.printStackTrace();
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/* 1008 */       this.logger.log("SimpleWorkbook addTrail(int trailStartRow)-----for4 end");
/*      */ 
/* 1011 */       this.logger.log("SimpleWorkbook addTrail(int trailStartRow)-----for5 start");
/* 1012 */       for (int i4 = 0; i4 <= trailH; i4++) {
/* 1013 */         for (int j4 = 0; j4 < trailRanges.size(); j4++) {
/* 1014 */           sheet.unmergeCells((Range)trailRanges.get(j4));
/*      */         }
/*      */       }
/* 1017 */       this.logger.log("SimpleWorkbook addTrail(int trailStartRow)-----for5 end");
/*      */     }
/*      */   }
/*      */ 
/*      */   private void merge()
/*      */   {
/* 1023 */     contentsMerge();
/* 1024 */     downNullMerge();
/*      */   }
/*      */ 
/*      */   private void contentsMerge() {
/* 1028 */     WritableSheet sheet = this.workbook.getSheet(0);
/* 1029 */     int rows = sheet.getRows();
/* 1030 */     Iterator it = this.mergeCol.iterator();
/* 1031 */     this.logger.log("SimpleWorkbook contentsMerge()-----while start");
/* 1032 */     while (it.hasNext()) {
/* 1033 */       Integer col = (Integer)it.next();
/* 1034 */       Map map = new HashMap();
/* 1035 */       String last = null;
/* 1036 */       int count = 0;
/* 1037 */       for (int i = this.startRow; i <= rows; i++) {
/* 1038 */         Cell cell = sheet.getCell(col.intValue(), i);
/* 1039 */         String contents = cell.getContents();
/* 1040 */         if ((last == null) || (last == "")) {
/* 1041 */           last = contents;
/*      */         }
/* 1044 */         else if (contents.equals(last)) {
/* 1045 */           count++;
/*      */         } else {
/* 1047 */           if (count > 0) {
/* 1048 */             map.put(new Integer(i - count - 1), new Integer(i - 1));
/* 1049 */             count = 0;
/*      */           }
/* 1051 */           last = contents;
/*      */         }
/*      */       }
/* 1054 */       if (count > 0) {
/* 1055 */         map.put(new Integer(rows - count), new Integer(rows));
/* 1056 */         count = 0;
/*      */       }
/*      */ 
/* 1061 */       Set set = map.keySet();
/* 1062 */       Iterator it2 = set.iterator();
/* 1063 */       while (it2.hasNext()) {
/* 1064 */         Integer row = (Integer)it2.next();
/* 1065 */         Integer row2 = (Integer)map.get(row);
/*      */         try {
/* 1067 */           sheet.mergeCells(col.intValue(), row.intValue(), col
/* 1068 */             .intValue(), row2.intValue());
/*      */         } catch (Exception e) {
/* 1070 */           e.printStackTrace();
/*      */         }
/*      */       }
/*      */     }
/* 1074 */     this.logger.log("SimpleWorkbook contentsMerge()-----while end");
/*      */   }
/*      */ 
/*      */   private void downNullMerge()
/*      */   {
/* 1120 */     WritableSheet sheet = this.workbook.getSheet(0);
/* 1121 */     int rows = sheet.getRows();
/* 1122 */     Iterator it = this.downNullMergeCol.iterator();
/* 1123 */     this.logger.log("SimpleWorkbook downNullMerge()-----while start");
/* 1124 */     while (it.hasNext()) {
/* 1125 */       Integer col = (Integer)it.next();
/* 1126 */       Map map = new HashMap();
/* 1127 */       String last = null;
/* 1128 */       int count = 0;
/* 1129 */       for (int i = this.startRow; i <= rows; i++) {
/* 1130 */         Cell cell = sheet.getCell(col.intValue(), i);
/* 1131 */         String contents = cell.getContents();
/* 1132 */         if ((contents == null) || (contents.trim().equals(""))) {
/* 1133 */           count++;
/*      */         }
/*      */         else {
/* 1136 */           if ((count > 0) && (last != null)) {
/* 1137 */             map.put(new Integer(i - count - 1), new Integer(i - 1));
/* 1138 */             count = 0;
/*      */           }
/* 1140 */           last = contents;
/*      */         }
/*      */       }
/* 1143 */       if (count > 0) {
/* 1144 */         map.put(new Integer(rows - count), new Integer(rows));
/* 1145 */         count = 0;
/*      */       }
/*      */ 
/* 1150 */       Set set = map.keySet();
/* 1151 */       Iterator it2 = set.iterator();
/* 1152 */       while (it2.hasNext()) {
/* 1153 */         Integer row = (Integer)it2.next();
/* 1154 */         Integer row2 = (Integer)map.get(row);
/*      */         try {
/* 1156 */           sheet.mergeCells(col.intValue(), row.intValue(), col
/* 1157 */             .intValue(), row2.intValue());
/*      */         } catch (Exception e) {
/* 1159 */           e.printStackTrace();
/*      */         }
/*      */       }
/*      */     }
/* 1163 */     this.logger.log("SimpleWorkbook downNullMerge()-----while end");
/*      */   }
/*      */ 
/*      */   public void set(String name, String value)
/*      */   {
/* 1168 */     if (value == null) {
/* 1169 */       System.out.println("\u5C06" + name + "\u7684\u503Cnull\u8F6C\u5316\u6210\u4E86\u7A7A");
/* 1170 */       value = "";
/*      */     }
/* 1172 */     WritableSheet sheet = this.workbook.getSheet(0);
/* 1173 */     this.logger.log("SimpleWorkbook set(String name, String value)-----for start");
/* 1174 */     for (int i = 0; i < sheet.getRows(); i++) {
/* 1175 */       for (int j = 0; j < sheet.getColumns(); j++) {
/* 1176 */         Cell cell2 = sheet.getCell(j, i);
/* 1177 */         String cont = cell2.getContents().trim();
/*      */ 
/* 1179 */         if (!contains(cont, name))
/*      */           continue;
/* 1181 */         cont = replace(cont, name, value);
/*      */         try
/*      */         {
/* 1189 */           add(i, j, cont, "TEXT");
/*      */         } catch (ExcelException e) {
/* 1191 */           e.printStackTrace();
/*      */         }
/*      */       }
/*      */     }
/* 1195 */     this.logger.log("SimpleWorkbook set(String name, String value)-----for end");
/*      */   }
/*      */ 
/*      */   private static String replace(String str, String name, String value) {
/* 1199 */     if ((str == null) || (str.trim().equals("")))
/* 1200 */       return "";
/* 1201 */     int index = str.indexOf(name);
/* 1202 */     if (index == -1) {
/* 1203 */       return str;
/*      */     }
/* 1205 */     if ((str.substring(index - 2, index).equals("#=")) && 
/* 1206 */       (str.substring(index + name.length()).startsWith("#"))) {
/* 1207 */       StringBuffer sb = new StringBuffer(str.substring(0, index - 2));
/* 1208 */       sb.append(value);
/* 1209 */       sb.append(str.substring(index + name.length() + 1));
/* 1210 */       return replace(sb.toString(), name, value);
/*      */     }
/* 1212 */     return str;
/*      */   }
/*      */ 
/*      */   private void copy(CellFormat format, WritableCellFormat wcf)
/*      */   {
/*      */     try
/*      */     {
/* 1225 */       wcf.setAlignment(format.getAlignment());
/* 1226 */       wcf
/* 1227 */         .setBackground(format.getBackgroundColour(), format
/* 1228 */         .getPattern());
/*      */ 
/* 1230 */       wcf.setFont((FontRecord)format.getFont());
/* 1231 */       wcf.setOrientation(format.getOrientation());
/*      */ 
/* 1233 */       wcf.setBorder(Border.TOP, format.getBorder(Border.TOP));
/* 1234 */       wcf.setBorder(Border.LEFT, format.getBorder(Border.LEFT));
/*      */ 
/* 1236 */       wcf.setBorder(Border.RIGHT, format.getBorder(Border.RIGHT));
/* 1237 */       wcf.setBorder(Border.BOTTOM, format.getBorder(Border.BOTTOM));
/*      */ 
/* 1240 */       wcf.setVerticalAlignment(format.getVerticalAlignment());
/* 1241 */       wcf.setWrap(format.getWrap());
/*      */     } catch (WriteException e) {
/* 1243 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   private int getFrac(Cell oldCell)
/*      */   {
/* 1249 */     int column = oldCell.getColumn();
/* 1250 */     Integer i = (Integer)this.numberCols.get(new Integer(column));
/* 1251 */     return i.intValue();
/*      */   }
/*      */ 
/*      */   private boolean isNumber(Cell cell) {
/* 1255 */     int column = cell.getColumn();
/* 1256 */     return this.numberCols.containsKey(new Integer(column));
/*      */   }
/*      */ 
/*      */   private CellFormat getFormat(Cell cell) {
/* 1260 */     CellFormat format = null;
/* 1261 */     String contents = cell.getContents();
/* 1262 */     if ((contents != null) && (contents != "")) {
/* 1263 */       int s = contents.indexOf("#=");
/* 1264 */       if ((contents.trim().equals("#cell#")) || (s != -1)) {
/* 1265 */         format = cell.getCellFormat();
/* 1266 */         return format;
/*      */       }
/*      */     }
/*      */ 
/* 1270 */     Integer row = new Integer(cell.getRow());
/* 1271 */     Integer col = new Integer(cell.getColumn());
/* 1272 */     if (this.rowFormat.containsKey(row)) {
/* 1273 */       format = (CellFormat)this.rowFormat.get(row);
/* 1274 */       return format;
/* 1275 */     }if (this.colFormat.containsKey(col))
/*      */     {
/* 1277 */       format = (CellFormat)this.colFormat.get(col);
/* 1278 */       return format;
/* 1279 */     }if (this.bothFormat != null) {
/* 1280 */       format = this.bothFormat;
/* 1281 */       return format;
/*      */     }
/*      */ 
/* 1284 */     return this.defaultFormat;
/*      */   }
/*      */ 
/*      */   public void write() throws ExcelException
/*      */   {
/*      */     try {
/* 1290 */       this.workbook.write();
/* 1291 */       System.out.println("SimpleWorkbook----write();");
/*      */     } catch (IOException e) {
/* 1293 */       throw new ExcelException(e);
/*      */     }
/*      */   }
/*      */ 
/*      */   public void close()
/*      */     throws ExcelException
/*      */   {
/*      */     try
/*      */     {
/* 1305 */       this.workbook.close();
/*      */ 
/* 1309 */       System.out.println("SimpleWorkbook----close();");
/*      */     } catch (IOException e) {
/* 1311 */       e.printStackTrace();
/* 1312 */       throw new ExcelException(e);
/*      */     }
/*      */   }
/*      */ 
/*      */   private void clearSign() {
/* 1317 */     WritableSheet sheet = this.workbook.getSheet(0);
/* 1318 */     this.logger.log("SimpleWorkbook clearSign()-----for start");
/* 1319 */     Range[] mc = sheet.getMergedCells();
/* 1320 */     for (int i = 0; i < this.templetRow; i++) {
/* 1321 */       for (int j = 0; j < this.templetCol; j++) {
/* 1322 */         Cell cell2 = sheet.getWritableCell(j, i);
/* 1323 */         String contents = cell2.getContents();
/* 1324 */         if (isSign(contents)) {
/* 1325 */           for (int t = 0; t < mc.length; t++)
/*      */           {
/* 1327 */             if ((mc[t].getTopLeft().getColumn() > cell2.getColumn()) || (mc[t].getTopLeft().getRow() > cell2.getRow()) || 
/* 1328 */               (mc[t].getBottomRight().getColumn() < cell2.getColumn()) || (mc[t].getBottomRight().getRow() < cell2.getRow()))
/*      */               continue;
/* 1330 */             int tlc = mc[t].getTopLeft().getColumn();
/* 1331 */             int tlr = mc[t].getTopLeft().getRow();
/* 1332 */             int brc = mc[t].getBottomRight().getColumn();
/* 1333 */             int brr = mc[t].getBottomRight().getRow();
/* 1334 */             sheet.unmergeCells(mc[t]);
/*      */             try {
/* 1336 */               for (int t2r = tlr; t2r <= brr; t2r++)
/* 1337 */                 for (int t2c = tlc; t2c <= brc; t2c++)
/*      */                 {
/* 1339 */                   sheet.addCell(new Label(t2c, t2r, ""));
/*      */                 }
/*      */             }
/*      */             catch (Exception e)
/*      */             {
/* 1344 */               e.printStackTrace();
/*      */             }
/*      */           }
/*      */ 
/*      */           try
/*      */           {
/* 1350 */             Label label = new Label(j, i, "");
/* 1351 */             sheet.addCell(label);
/*      */           }
/*      */           catch (Exception e) {
/* 1354 */             e.printStackTrace();
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/* 1359 */     this.logger.log("SimpleWorkbook clearSign()-----for end");
/*      */   }
/*      */ 
/*      */   private boolean isSign(String str) {
/* 1363 */     String cont = str.trim();
/*      */ 
/* 1365 */     return cont.startsWith("#");
/*      */   }
/*      */ 
/*      */   private boolean contains(String str, String var)
/*      */   {
/* 1371 */     int s = str.indexOf("#=");
/* 1372 */     if ((s == -1) || (s >= str.length() - 2)) {
/* 1373 */       return false;
/*      */     }
/* 1375 */     StringBuffer sb = new StringBuffer();
/* 1376 */     sb.append(str.substring(0, s));
/*      */ 
/* 1378 */     String tmp = str.substring(s + 2);
/*      */ 
/* 1380 */     int e = tmp.indexOf("#");
/* 1381 */     if (e == -1) {
/* 1382 */       return false;
/*      */     }
/* 1384 */     String v = tmp.substring(0, e);
/*      */ 
/* 1386 */     return v.equalsIgnoreCase(var);
/*      */   }
/*      */ 
/*      */   public static ZipInfo getZipFiles(String[] srcFileName, String zipFileName, long usefullLifeSec)
/*      */   {
/* 1465 */     ZipInfo info = new ZipInfo();
/* 1466 */     long usefulLifeSecs1 = usefullLifeSec;
/* 1467 */     File[] files = new File[srcFileName.length];
/*      */ 
/* 1469 */     for (int i = 0; i < srcFileName.length; i++) {
/* 1470 */       files[i] = new File(Config.getWorkPath() + File.separator + srcFileName[i]);
/*      */     }
/* 1472 */     File zipFile = new File(Config.getWorkPath() + File.separator + zipFileName);
/* 1473 */     byte[] buf = new byte[1024];
/*      */     try {
/* 1475 */       ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFile));
/*      */ 
/* 1477 */       for (int i = 0; i < files.length; i++) {
/* 1478 */         FileInputStream in = new FileInputStream(files[i]);
/*      */ 
/* 1480 */         out.putNextEntry(new ZipEntry(files[i].getName()));
/*      */         int len;
/* 1483 */         while ((len = in.read(buf)) > 0)
/*      */         {
/*      */           int len;
/* 1484 */           out.write(buf, 0, len);
/*      */         }
/*      */ 
/* 1487 */         out.closeEntry();
/* 1488 */         in.close();
/*      */       }
/*      */ 
/* 1491 */       out.close();
/* 1492 */       System.out.println("\u538B\u7F29\u5B8C\u6210.");
/*      */ 
/* 1494 */       info = ExcelUtil.prepare1(zipFileName, usefulLifeSecs1);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/* 1499 */       info.zipExists = false;
/* 1500 */       e.printStackTrace();
/*      */     }
/* 1502 */     return info;
/*      */   }
/*      */ 
/*      */   public static void copyFile(String oldPath, String newPath) {
/*      */     try {
/* 1507 */       int bytesum = 0;
/* 1508 */       int byteread = 0;
/* 1509 */       File oldfile = new File(oldPath);
/* 1510 */       if (oldfile.exists()) {
/* 1511 */         InputStream inStream = new FileInputStream(oldPath);
/* 1512 */         FileOutputStream fs = new FileOutputStream(newPath);
/* 1513 */         byte[] buffer = new byte[1444];
/*      */ 
/* 1515 */         while ((byteread = inStream.read(buffer)) != -1) {
/* 1516 */           bytesum += byteread;
/* 1517 */           System.out.println(bytesum);
/* 1518 */           fs.write(buffer, 0, byteread);
/*      */         }
/* 1520 */         inStream.close();
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1524 */       System.out.println("\u590D\u5236\u5355\u4E2A\u6587\u4EF6\u64CD\u4F5C\u51FA\u9519");
/* 1525 */       e.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   public static void main(String[] args)
/*      */     throws ExcelException
/*      */   {
/* 1532 */     SimpleWorkbook workbook = new SimpleWorkbook("d:\\var\\map_e2e_file_folder\\tmp\\2007\\8\\22\\633233789295244910282.xls", "d:\\var\\map_e2e_file_folder\\tmp\\2007\\8\\22\\1\\633233789295244910282.xls");
/* 1533 */     String[][] array = { { "1", "1", "1", "1" }, 
/* 1534 */       { "2", "2", "2", "2" }, 
/* 1535 */       { "0", "0", "0", "0" }, 
/* 1536 */       { "3", "3", "3", "3" }, 
/* 1537 */       { "", "", "", "" }, 
/* 1538 */       { "   ", "   ", "   ", "   " }, 
/* 1539 */       { "null", "null", "null", "null" } };
/*      */ 
/* 1541 */     workbook.add(array);
/* 1542 */     workbook.close();
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.excel.SimpleWorkbook
 * JD-Core Version:    0.6.0
 */