/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ import java.util.Vector;
/*     */ 
/*     */ public class SSRS
/*     */ {
/*  13 */   private Vector RData = new Vector();
/*  14 */   public int MaxCol = 0;
/*  15 */   public int MaxRow = 0;
/*  16 */   public int MaxNumber = 0;
/*  17 */   public CErrors mErrors = new CErrors();
/*     */ 
/*  20 */   public boolean ErrorFlag = false;
/*     */ 
/*     */   public SSRS()
/*     */   {
/*     */   }
/*     */ 
/*     */   public SSRS(int n) {
/*  27 */     this.MaxCol = n;
/*     */   }
/*     */ 
/*     */   public void SetText(String strValue)
/*     */   {
/*  33 */     this.RData.addElement(strValue);
/*  34 */     this.MaxNumber = this.RData.size();
/*  35 */     if (this.MaxNumber % this.MaxCol == 0)
/*     */     {
/*  37 */       this.MaxRow = (this.MaxNumber / this.MaxCol);
/*     */     }
/*     */     else
/*     */     {
/*  41 */       this.MaxRow = (this.MaxNumber / this.MaxCol + 1);
/*     */     }
/*     */   }
/*     */ 
/*     */   public String GetText(int cRow, int cCol)
/*     */   {
/*  48 */     String Result = "";
/*  49 */     int Number = (cRow - 1) * this.MaxCol + cCol - 1;
/*  50 */     if (Number <= this.MaxNumber)
/*     */     {
/*  52 */       Result = (String)this.RData.get(Number);
/*     */     }
/*     */     else
/*     */     {
/*  57 */       CError tError = new CError();
/*  58 */       tError.moduleName = "SSRS";
/*  59 */       tError.functionName = "GetText";
/*  60 */       tError.errorMessage = "\u6307\u5B9A\u7684\u4F4D\u7F6E\u5728\u7ED3\u679C\u96C6\u4E2D\u6CA1\u6709\u6570\u636E";
/*  61 */       this.mErrors.addOneError(tError);
/*  62 */       this.ErrorFlag = true;
/*     */     }
/*  64 */     return Result;
/*     */   }
/*     */ 
/*     */   public int getMaxCol()
/*     */   {
/*  69 */     return this.MaxCol;
/*     */   }
/*     */ 
/*     */   public int getMaxRow()
/*     */   {
/*  74 */     return this.MaxRow;
/*     */   }
/*     */ 
/*     */   public int getMaxNumber()
/*     */   {
/*  79 */     return this.MaxNumber;
/*     */   }
/*     */ 
/*     */   public void setMaxCol(int aMaxCol)
/*     */   {
/*  84 */     this.MaxCol = aMaxCol;
/*     */   }
/*     */ 
/*     */   public void setMaxRow(int aMaxRow)
/*     */   {
/*  89 */     this.MaxRow = aMaxRow;
/*     */   }
/*     */ 
/*     */   public void setMaxNumber(int aMaxNumber)
/*     */   {
/*  94 */     this.MaxNumber = aMaxNumber;
/*     */   }
/*     */ 
/*     */   public void Clear()
/*     */   {
/*  99 */     this.RData.clear();
/* 100 */     this.MaxRow = 0;
/* 101 */     this.MaxCol = 0;
/* 102 */     this.MaxNumber = 0;
/*     */   }
/*     */ 
/*     */   public String[] getRowData(int cRow)
/*     */   {
/* 107 */     String[] StrArr = new String[this.MaxCol];
/* 108 */     for (int i = 0; i < this.MaxCol; i++)
/*     */     {
/* 110 */       StrArr[i] = GetText(cRow, i + 1);
/*     */     }
/* 112 */     return StrArr;
/*     */   }
/*     */ 
/*     */   public String[][] getAllData()
/*     */   {
/* 117 */     String[][] StrArr = new String[this.MaxRow][this.MaxCol];
/* 118 */     for (int j = 0; j < this.MaxRow; j++)
/*     */     {
/* 120 */       StrArr[j] = getRowData(j + 1);
/*     */     }
/* 122 */     return StrArr;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 127 */     String strReturn = "";
/* 128 */     if (this.MaxNumber != 0)
/*     */     {
/* 130 */       strReturn = "0|" + String.valueOf(this.MaxRow) + 
/* 131 */         "^";
/* 132 */       for (int i = 1; i <= this.MaxRow; i++)
/*     */       {
/* 134 */         for (int j = 1; j <= this.MaxCol; j++)
/*     */         {
/* 136 */           if (j != this.MaxCol)
/*     */           {
/* 138 */             strReturn = strReturn + GetText(i, j) + 
/* 139 */               "|";
/*     */           }
/*     */           else
/*     */           {
/* 143 */             strReturn = strReturn + GetText(i, j);
/*     */           }
/*     */         }
/* 146 */         if (i == this.MaxRow)
/*     */           continue;
/* 148 */         strReturn = strReturn + "^";
/*     */       }
/*     */     }
/*     */ 
/* 152 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public boolean addCol(SSRS aSSRS)
/*     */   {
/* 157 */     if (this.MaxRow != aSSRS.getMaxRow())
/*     */     {
/* 160 */       CError tError = new CError();
/* 161 */       tError.moduleName = "SSRS";
/* 162 */       tError.functionName = "addCol";
/* 163 */       tError.errorMessage = "\u5408\u5E76\u7684\u4E24\u4E2A\u7ED3\u679C\u96C6\u884C\u6570\u4E0D\u7B49\uFF01\uFF01\uFF01";
/* 164 */       this.mErrors.addOneError(tError);
/* 165 */       return false;
/*     */     }
/*     */ 
/* 169 */     SSRS bSSRS = null;
/*     */     try
/*     */     {
/* 172 */       bSSRS = (SSRS)clone();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 177 */       ex.printStackTrace();
/* 178 */       CError tError = new CError();
/* 179 */       tError.moduleName = "SSRS";
/* 180 */       tError.functionName = "addCol";
/* 181 */       tError.errorMessage = "\u514B\u9686\u51FA\u9519\uFF01\uFF01\uFF01";
/* 182 */       this.mErrors.addOneError(tError);
/* 183 */       return false;
/*     */     }
/* 185 */     Clear();
/* 186 */     setMaxCol(bSSRS.getMaxCol() + aSSRS.getMaxCol());
/*     */ 
/* 189 */     for (int row = 1; row <= aSSRS.getMaxRow(); row++)
/*     */     {
/* 191 */       for (int bcol = 1; bcol <= bSSRS.getMaxCol(); bcol++)
/*     */       {
/* 193 */         SetText(StrTool.cTrim(bSSRS.GetText(row, bcol)));
/*     */       }
/* 195 */       for (int acol = 1; acol <= aSSRS.getMaxCol(); acol++)
/*     */       {
/* 197 */         SetText(StrTool.cTrim(aSSRS.GetText(row, acol)));
/*     */       }
/*     */     }
/*     */ 
/* 201 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean addRow(SSRS aSSRS)
/*     */   {
/* 207 */     if (this.MaxCol != aSSRS.getMaxCol())
/*     */     {
/* 210 */       CError tError = new CError();
/* 211 */       tError.moduleName = "SSRS";
/* 212 */       tError.functionName = "addRow";
/* 213 */       tError.errorMessage = "\u5408\u5E76\u7684\u4E24\u4E2A\u7ED3\u679C\u96C6\u5217\u6570\u4E0D\u7B49\uFF01\uFF01\uFF01";
/* 214 */       this.mErrors.addOneError(tError);
/* 215 */       return false;
/*     */     }
/*     */ 
/* 219 */     SSRS bSSRS = null;
/*     */     try
/*     */     {
/* 222 */       bSSRS = (SSRS)clone();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 227 */       ex.printStackTrace();
/* 228 */       CError tError = new CError();
/* 229 */       tError.moduleName = "SSRS";
/* 230 */       tError.functionName = "addRow";
/* 231 */       tError.errorMessage = "\u514B\u9686\u51FA\u9519\uFF01\uFF01\uFF01";
/* 232 */       this.mErrors.addOneError(tError);
/* 233 */       return false;
/*     */     }
/* 235 */     Clear();
/* 236 */     setMaxCol(bSSRS.getMaxCol());
/*     */ 
/* 240 */     for (int row = 1; row <= bSSRS.getMaxRow(); row++)
/*     */     {
/* 242 */       for (int col = 1; col <= bSSRS.getMaxCol(); col++)
/*     */       {
/* 244 */         SetText(StrTool.cTrim(bSSRS.GetText(row, col)));
/*     */       }
/*     */     }
/* 247 */     for (int row = 1; row <= aSSRS.getMaxRow(); row++)
/*     */     {
/* 249 */       for (int col = 1; col <= aSSRS.getMaxCol(); col++)
/*     */       {
/* 251 */         SetText(StrTool.cTrim(aSSRS.GetText(row, col)));
/*     */       }
/*     */     }
/* 254 */     return true;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/* 260 */     Object tObj = null;
/* 261 */     SSRS tSSRS = new SSRS();
/* 262 */     tSSRS.setMaxCol(getMaxCol());
/* 263 */     tSSRS.setMaxNumber(getMaxNumber());
/* 264 */     tSSRS.setMaxRow(getMaxRow());
/* 265 */     tSSRS.ErrorFlag = this.ErrorFlag;
/* 266 */     tSSRS.mErrors = this.mErrors;
/* 267 */     tSSRS.RData = ((Vector)this.RData.clone());
/* 268 */     tObj = tSSRS;
/* 269 */     return tObj;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.SSRS
 * JD-Core Version:    0.6.0
 */