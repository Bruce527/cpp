/*     */ package com.sinosoft.banklns.utility;
/*     */ 
/*     */ import java.util.Vector;
/*     */ 
/*     */ public class SSRS
/*     */ {
/*   7 */   private Vector RData = new Vector();
/*     */ 
/*   9 */   public int MaxCol = 0;
/*     */ 
/*  11 */   public int MaxRow = 0;
/*     */ 
/*  13 */   public int MaxNumber = 0;
/*     */ 
/*  15 */   public CErrors mErrors = new CErrors();
/*     */ 
/*  18 */   public boolean ErrorFlag = false;
/*     */ 
/*     */   public SSRS() {
/*     */   }
/*     */ 
/*     */   public SSRS(int n) {
/*  24 */     this.MaxCol = n;
/*     */   }
/*     */ 
/*     */   public void SetText(String strValue) {
/*     */     try {
/*  29 */       this.RData.addElement(strValue);
/*  30 */       this.MaxNumber = this.RData.size();
/*  31 */       if (this.MaxNumber % this.MaxCol == 0)
/*  32 */         this.MaxRow = (this.MaxNumber / this.MaxCol);
/*     */       else {
/*  34 */         this.MaxRow = (this.MaxNumber / this.MaxCol + 1);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*  40 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public String GetText(int cRow, int cCol)
/*     */   {
/*  46 */     String Result = "";
/*  47 */     int Number = (cRow - 1) * this.MaxCol + cCol - 1;
/*  48 */     if (Number <= this.MaxNumber) {
/*  49 */       Result = (String)this.RData.get(Number);
/*     */     }
/*     */     else {
/*  52 */       CError tError = new CError();
/*  53 */       tError.moduleName = "SSRS";
/*  54 */       tError.functionName = "GetText";
/*  55 */       tError.errorMessage = "\u6307\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u4F4D\u951F\u65A4\u62F7\u951F\u8282\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u77EB\u4F19\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7";
/*  56 */       this.mErrors.addOneError(tError);
/*  57 */       this.ErrorFlag = true;
/*     */     }
/*  59 */     return Result;
/*     */   }
/*     */ 
/*     */   public boolean SetText(int cRow, int cCol, String newValue) {
/*  63 */     String Result = "";
/*  64 */     int Number = (cRow - 1) * this.MaxCol + cCol - 1;
/*  65 */     if (Number <= this.MaxNumber) {
/*  66 */       this.RData.remove(Number);
/*  67 */       this.RData.add(Number, newValue);
/*     */     }
/*     */     else {
/*  70 */       CError tError = new CError();
/*  71 */       tError.moduleName = "SSRS";
/*  72 */       tError.functionName = "GetText";
/*  73 */       tError.errorMessage = "\u6307\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u4F4D\u951F\u65A4\u62F7\u951F\u8282\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u77EB\u4F19\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7";
/*  74 */       this.mErrors.addOneError(tError);
/*  75 */       this.ErrorFlag = true;
/*     */     }
/*  77 */     return true;
/*     */   }
/*     */ 
/*     */   public int getMaxCol() {
/*  81 */     return this.MaxCol;
/*     */   }
/*     */ 
/*     */   public int getMaxRow() {
/*  85 */     return this.MaxRow;
/*     */   }
/*     */ 
/*     */   public int getMaxNumber() {
/*  89 */     return this.MaxNumber;
/*     */   }
/*     */ 
/*     */   public void setMaxCol(int aMaxCol) {
/*  93 */     this.MaxCol = aMaxCol;
/*     */   }
/*     */ 
/*     */   public void setMaxRow(int aMaxRow) {
/*  97 */     this.MaxRow = aMaxRow;
/*     */   }
/*     */ 
/*     */   public void setMaxNumber(int aMaxNumber) {
/* 101 */     this.MaxNumber = aMaxNumber;
/*     */   }
/*     */ 
/*     */   public void Clear() {
/* 105 */     this.RData.clear();
/* 106 */     this.MaxRow = 0;
/* 107 */     this.MaxCol = 0;
/* 108 */     this.MaxNumber = 0;
/*     */   }
/*     */ 
/*     */   public String[] getRowData(int cRow) {
/* 112 */     String[] StrArr = new String[this.MaxCol];
/* 113 */     for (int i = 0; i < this.MaxCol; i++) {
/* 114 */       StrArr[i] = GetText(cRow, i + 1);
/*     */     }
/* 116 */     return StrArr;
/*     */   }
/*     */ 
/*     */   public String[][] getAllData() {
/* 120 */     String[][] StrArr = new String[this.MaxRow][this.MaxCol];
/* 121 */     for (int j = 0; j < this.MaxRow; j++) {
/* 122 */       StrArr[j] = getRowData(j + 1);
/*     */     }
/* 124 */     return StrArr;
/*     */   }
/*     */ 
/*     */   public String encode() {
/* 128 */     String strReturn = "";
/* 129 */     if (this.MaxNumber != 0) {
/* 130 */       strReturn = "0|" + String.valueOf(this.MaxRow) + 
/* 131 */         "^";
/* 132 */       for (int i = 1; i <= this.MaxRow; i++) {
/* 133 */         for (int j = 1; j <= this.MaxCol; j++) {
/* 134 */           if (j != this.MaxCol)
/* 135 */             strReturn = strReturn + GetText(i, j) + 
/* 136 */               "|";
/*     */           else {
/* 138 */             strReturn = strReturn + GetText(i, j);
/*     */           }
/*     */         }
/* 141 */         if (i != this.MaxRow) {
/* 142 */           strReturn = strReturn + "^";
/*     */         }
/*     */       }
/*     */     }
/* 146 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public boolean addCol(SSRS aSSRS) {
/* 150 */     if (this.MaxRow != aSSRS.getMaxRow())
/*     */     {
/* 152 */       CError tError = new CError();
/* 153 */       tError.moduleName = "SSRS";
/* 154 */       tError.functionName = "addCol";
/* 155 */       tError.errorMessage = "\u951F\u8F83\u8BE7\u62F7\u951F\u65A4\u62F7}\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u9F8B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\uFFFD";
/* 156 */       this.mErrors.addOneError(tError);
/* 157 */       return false;
/*     */     }
/* 159 */     SSRS bSSRS = null;
/*     */     try {
/* 161 */       bSSRS = (SSRS)clone();
/*     */     }
/*     */     catch (Exception ex) {
/* 164 */       ex.printStackTrace();
/* 165 */       CError tError = new CError();
/* 166 */       tError.moduleName = "SSRS";
/* 167 */       tError.functionName = "addCol";
/* 168 */       tError.errorMessage = "\u951F\u65A4\u62F7\u9686\u951F\u65A4\u62F7?\u951F\u65A4\u62F7\u951F\u65A4\u62F7";
/* 169 */       this.mErrors.addOneError(tError);
/* 170 */       return false;
/*     */     }
/* 172 */     Clear();
/* 173 */     setMaxCol(bSSRS.getMaxCol() + aSSRS.getMaxCol());
/*     */ 
/* 176 */     for (int row = 1; row <= aSSRS.getMaxRow(); row++) {
/* 177 */       for (int bcol = 1; bcol <= bSSRS.getMaxCol(); bcol++) {
/* 178 */         SetText(StrTool.cTrim(bSSRS.GetText(row, bcol)));
/*     */       }
/* 180 */       for (int acol = 1; acol <= aSSRS.getMaxCol(); acol++) {
/* 181 */         SetText(StrTool.cTrim(aSSRS.GetText(row, acol)));
/*     */       }
/*     */     }
/*     */ 
/* 185 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean addColSSRS(SSRS aSSRS)
/*     */   {
/* 192 */     int maxRow = getMaxRow();
/*     */ 
/* 194 */     if (this.MaxRow != aSSRS.getMaxRow()) {
/* 195 */       maxRow = Math.max(aSSRS.getMaxRow(), getMaxRow());
/*     */     }
/*     */ 
/* 198 */     SSRS bSSRS = null;
/*     */     try {
/* 200 */       bSSRS = (SSRS)clone();
/*     */     }
/*     */     catch (Exception ex) {
/* 203 */       ex.printStackTrace();
/* 204 */       CError tError = new CError();
/* 205 */       tError.moduleName = "SSRS";
/* 206 */       tError.functionName = "addCol";
/* 207 */       tError.errorMessage = "\u951F\u65A4\u62F7\u9686\u951F\u65A4\u62F7?\u951F\u65A4\u62F7\u951F\u65A4\u62F7";
/* 208 */       this.mErrors.addOneError(tError);
/* 209 */       return false;
/*     */     }
/* 211 */     Clear();
/* 212 */     setMaxCol(bSSRS.getMaxCol() + aSSRS.getMaxCol());
/*     */ 
/* 215 */     for (int row = 1; row <= maxRow; row++) {
/* 216 */       for (int bcol = 1; bcol <= bSSRS.getMaxCol(); bcol++) {
/* 217 */         if (row > bSSRS.getMaxRow())
/* 218 */           SetText(null);
/*     */         else {
/* 220 */           SetText(StrTool.cTrim(bSSRS.GetText(row, bcol)));
/*     */         }
/*     */       }
/* 223 */       for (int acol = 1; acol <= aSSRS.getMaxCol(); acol++) {
/* 224 */         if (row > aSSRS.getMaxRow())
/* 225 */           SetText(null);
/*     */         else {
/* 227 */           SetText(StrTool.cTrim(aSSRS.GetText(row, acol)));
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 232 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean uniteSSRS(SSRS aSSRS, int noAddRow)
/*     */   {
/* 238 */     int maxRow = getMaxRow();
/* 239 */     if (this.MaxRow != aSSRS.getMaxRow()) {
/* 240 */       maxRow = Math.max(aSSRS.getMaxRow(), getMaxRow());
/*     */     }
/* 242 */     int minRow = Math.min(aSSRS.getMaxRow(), getMaxRow());
/* 243 */     int maxCol = getMaxCol();
/* 244 */     if (this.MaxCol != aSSRS.getMaxCol()) {
/* 245 */       maxCol = Math.max(aSSRS.getMaxCol(), getMaxCol());
/*     */     }
/*     */ 
/* 248 */     SSRS bSSRS = null;
/*     */     try {
/* 250 */       bSSRS = (SSRS)clone();
/*     */     }
/*     */     catch (Exception ex) {
/* 253 */       ex.printStackTrace();
/* 254 */       CError tError = new CError();
/* 255 */       tError.moduleName = "SSRS";
/* 256 */       tError.functionName = "addCol";
/* 257 */       tError.errorMessage = "\u951F\u65A4\u62F7\u9686\u951F\u65A4\u62F7?\u951F\u65A4\u62F7\u951F\u65A4\u62F7";
/* 258 */       this.mErrors.addOneError(tError);
/* 259 */       return false;
/*     */     }
/* 261 */     Clear();
/* 262 */     setMaxCol(maxCol);
/* 263 */     for (int row = 1; row <= maxRow; row++) {
/* 264 */       for (int col = 1; col <= maxCol; col++) {
/* 265 */         if (row > maxRow)
/* 266 */           SetText(null);
/* 267 */         else if (row > aSSRS.getMaxRow())
/* 268 */           SetText(StrTool.cTrim(bSSRS.GetText(row, col)));
/* 269 */         else if ((row > bSSRS.getMaxRow()) || (this == null)) {
/* 270 */           SetText(StrTool.cTrim(aSSRS.GetText(row, col)));
/*     */         }
/* 272 */         else if (1 == col)
/* 273 */           SetText(StrTool.cTrim(bSSRS.GetText(row, col)));
/*     */         else {
/* 275 */           SetText(Double.toString(
/* 276 */             Double.parseDouble(StrTool.cTrim(aSSRS.GetText(row, 
/* 277 */             col))) + Double.parseDouble(
/* 278 */             StrTool.cTrim(bSSRS.GetText(row, col)))));
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 285 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean addRow(SSRS aSSRS) {
/* 289 */     if (this.MaxCol != aSSRS.getMaxCol())
/*     */     {
/* 291 */       CError tError = new CError();
/* 292 */       tError.moduleName = "SSRS";
/* 293 */       tError.functionName = "addRow";
/* 294 */       tError.errorMessage = "\u951F\u8F83\u8BE7\u62F7\u951F\u65A4\u62F7}\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u9F8B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\uFFFD";
/* 295 */       this.mErrors.addOneError(tError);
/* 296 */       return false;
/*     */     }
/* 298 */     SSRS bSSRS = null;
/*     */     try {
/* 300 */       bSSRS = (SSRS)clone();
/*     */     }
/*     */     catch (Exception ex) {
/* 303 */       ex.printStackTrace();
/* 304 */       CError tError = new CError();
/* 305 */       tError.moduleName = "SSRS";
/* 306 */       tError.functionName = "addRow";
/* 307 */       tError.errorMessage = "\u951F\u65A4\u62F7\u9686\u951F\u65A4\u62F7?\u951F\u65A4\u62F7\u951F\u65A4\u62F7";
/* 308 */       this.mErrors.addOneError(tError);
/* 309 */       return false;
/*     */     }
/* 311 */     Clear();
/* 312 */     setMaxCol(bSSRS.getMaxCol());
/*     */ 
/* 316 */     for (int row = 1; row <= bSSRS.getMaxRow(); row++) {
/* 317 */       for (int col = 1; col <= bSSRS.getMaxCol(); col++) {
/* 318 */         SetText(StrTool.cTrim(bSSRS.GetText(row, col)));
/*     */       }
/*     */     }
/* 321 */     for (int row = 1; row <= aSSRS.getMaxRow(); row++) {
/* 322 */       for (int col = 1; col <= aSSRS.getMaxCol(); col++) {
/* 323 */         SetText(StrTool.cTrim(aSSRS.GetText(row, col)));
/*     */       }
/*     */     }
/* 326 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean addRowSSRS(SSRS aSSRS)
/*     */   {
/* 332 */     int maxCol = getMaxCol();
/*     */ 
/* 334 */     if (this.MaxCol != aSSRS.getMaxCol()) {
/* 335 */       maxCol = Math.max(getMaxCol(), aSSRS.getMaxCol());
/*     */     }
/*     */ 
/* 338 */     SSRS bSSRS = null;
/*     */     try {
/* 340 */       bSSRS = (SSRS)clone();
/*     */     }
/*     */     catch (Exception ex) {
/* 343 */       ex.printStackTrace();
/* 344 */       CError tError = new CError();
/* 345 */       tError.moduleName = "SSRS";
/* 346 */       tError.functionName = "addRow";
/* 347 */       tError.errorMessage = "\u951F\u65A4\u62F7\u9686\u951F\u65A4\u62F7?\u951F\u65A4\u62F7\u951F\u65A4\u62F7";
/* 348 */       this.mErrors.addOneError(tError);
/* 349 */       return false;
/*     */     }
/* 351 */     Clear();
/* 352 */     setMaxCol(maxCol);
/*     */ 
/* 356 */     for (int row = 1; row <= bSSRS.getMaxRow(); row++) {
/* 357 */       for (int col = 1; col <= maxCol; col++) {
/* 358 */         if (col > bSSRS.getMaxCol())
/* 359 */           SetText(null);
/*     */         else {
/* 361 */           SetText(StrTool.cTrim(bSSRS.GetText(row, col)));
/*     */         }
/*     */       }
/*     */     }
/* 365 */     for (int row = 1; row <= aSSRS.getMaxRow(); row++) {
/* 366 */       for (int col = 1; col <= maxCol; col++) {
/* 367 */         if (col > aSSRS.getMaxCol())
/* 368 */           SetText(null);
/*     */         else {
/* 370 */           SetText(StrTool.cTrim(aSSRS.GetText(row, col)));
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 375 */     return true;
/*     */   }
/*     */ 
/*     */   public Object clone() throws CloneNotSupportedException {
/* 379 */     Object tObj = null;
/* 380 */     SSRS tSSRS = new SSRS();
/* 381 */     tSSRS.setMaxCol(getMaxCol());
/* 382 */     tSSRS.setMaxNumber(getMaxNumber());
/* 383 */     tSSRS.setMaxRow(getMaxRow());
/* 384 */     tSSRS.ErrorFlag = this.ErrorFlag;
/* 385 */     tSSRS.mErrors = this.mErrors;
/* 386 */     tSSRS.RData = ((Vector)this.RData.clone());
/* 387 */     tObj = tSSRS;
/* 388 */     return tObj;
/*     */   }
/*     */ 
/*     */   public String[] getColData(int col)
/*     */   {
/* 394 */     if (col > this.MaxCol) {
/* 395 */       return null;
/*     */     }
/*     */ 
/* 398 */     String[] StrArr = new String[this.MaxRow];
/* 399 */     for (int i = 0; i < this.MaxRow; i++) {
/* 400 */       StrArr[i] = GetText(i + 1, col);
/*     */     }
/*     */ 
/* 403 */     return StrArr;
/*     */   }
/*     */ 
/*     */   public boolean setTextAt(int aRow, int aCol, String aContent)
/*     */   {
/* 408 */     boolean result = false;
/* 409 */     int Number = (aRow - 1) * this.MaxCol + aCol - 1;
/* 410 */     if (Number <= this.MaxNumber) {
/*     */       try {
/* 412 */         this.RData.setElementAt(aContent, Number);
/*     */       } catch (Exception ex) {
/* 414 */         CError tError = new CError();
/* 415 */         tError.moduleName = "SSRS";
/* 416 */         tError.functionName = "GetText";
/* 417 */         tError.errorMessage = "\u6307\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u4F4D\u951F\u65A4\u62F7\u951F\u8282\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u77EB\u4F19\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7";
/* 418 */         this.mErrors.addOneError(tError);
/* 419 */         this.ErrorFlag = true;
/* 420 */         result = false;
/*     */       }
/*     */     }
/*     */     else {
/* 424 */       CError tError = new CError();
/* 425 */       tError.moduleName = "SSRS";
/* 426 */       tError.functionName = "GetText";
/* 427 */       tError.errorMessage = "\u6307\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u4F4D\u951F\u65A4\u62F7\u951F\u8282\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u77EB\u4F19\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7";
/* 428 */       this.mErrors.addOneError(tError);
/* 429 */       this.ErrorFlag = true;
/*     */     }
/* 431 */     return result;
/*     */   }
/*     */ 
/*     */   public boolean removeRow(int row)
/*     */   {
/* 436 */     if ((row <= 0) || (row > getMaxRow())) {
/* 437 */       CError tError = new CError();
/* 438 */       tError.moduleName = "SSRS";
/* 439 */       tError.functionName = "removeRow";
/* 440 */       tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8F83\u51E4\u62F7";
/* 441 */       this.mErrors.addOneError(tError);
/* 442 */       return false;
/*     */     }
/* 444 */     Vector data = this.RData;
/* 445 */     int preNum = getMaxCol() * (row - 1) + 1;
/* 446 */     int endNum = getMaxCol() * row;
/* 447 */     for (int i = endNum - 1; i >= preNum - 1; i--) {
/* 448 */       data.remove(i);
/*     */     }
/*     */ 
/* 451 */     this.MaxRow -= 1;
/* 452 */     this.MaxNumber -= getMaxCol();
/* 453 */     return true;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.SSRS
 * JD-Core Version:    0.6.0
 */