/*     */ package com.sinosoft.map.lis.schema;
/*     */ 
/*     */ import com.sinosoft.map.lis.db.MLibraryRateDB;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.ChgData;
/*     */ import com.sinosoft.map.utility.Schema;
/*     */ import com.sinosoft.map.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ public class MLibraryRateSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String fileID;
/*     */   private double downloadRate;
/*     */   public static final int FIELDNUM = 2;
/*     */   private static String[] PK;
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public MLibraryRateSchema()
/*     */   {
/*  33 */     this.mErrors = new CErrors();
/*     */ 
/*  35 */     String[] pk = new String[1];
/*  36 */     pk[0] = "FileID";
/*     */ 
/*  38 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  45 */     MLibraryRateSchema cloned = (MLibraryRateSchema)super.clone();
/*  46 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  47 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  53 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getFileID()
/*     */   {
/*  58 */     return this.fileID;
/*     */   }
/*     */ 
/*     */   public void setFileID(String aFileID) {
/*  62 */     this.fileID = aFileID;
/*     */   }
/*     */ 
/*     */   public double getDownloadRate() {
/*  66 */     return this.downloadRate;
/*     */   }
/*     */ 
/*     */   public void setDownloadRate(double aDownloadRate) {
/*  70 */     this.downloadRate = aDownloadRate;
/*     */   }
/*     */ 
/*     */   public void setDownloadRate(String aDownloadRate) {
/*  74 */     if ((aDownloadRate != null) && (!aDownloadRate.equals("")))
/*     */     {
/*  76 */       Double tDouble = new Double(aDownloadRate);
/*  77 */       double d = tDouble.doubleValue();
/*  78 */       this.downloadRate = d;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setSchema(MLibraryRateSchema aMLibraryRateSchema)
/*     */   {
/*  86 */     this.fileID = aMLibraryRateSchema.getFileID();
/*  87 */     this.downloadRate = aMLibraryRateSchema.getDownloadRate();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/*  96 */       if (rs.getString("FileID") == null)
/*  97 */         this.fileID = null;
/*     */       else {
/*  99 */         this.fileID = rs.getString("FileID").trim();
/*     */       }
/* 101 */       this.downloadRate = rs.getDouble("DownloadRate");
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 105 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MLibraryRate\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*     */ 
/* 107 */       CError tError = new CError();
/* 108 */       tError.moduleName = "MLibraryRateSchema";
/* 109 */       tError.functionName = "setSchema";
/* 110 */       tError.errorMessage = sqle.toString();
/* 111 */       this.mErrors.addOneError(tError);
/* 112 */       return false;
/*     */     }
/* 114 */     return true;
/*     */   }
/*     */ 
/*     */   public MLibraryRateSchema getSchema()
/*     */   {
/* 119 */     MLibraryRateSchema aMLibraryRateSchema = new MLibraryRateSchema();
/* 120 */     aMLibraryRateSchema.setSchema(this);
/* 121 */     return aMLibraryRateSchema;
/*     */   }
/*     */ 
/*     */   public MLibraryRateDB getDB()
/*     */   {
/* 126 */     MLibraryRateDB aDBOper = new MLibraryRateDB();
/* 127 */     aDBOper.setSchema(this);
/* 128 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 135 */     StringBuffer strReturn = new StringBuffer(256);
/* 136 */     strReturn.append(StrTool.cTrim(this.fileID)); strReturn.append("|");
/* 137 */     strReturn.append(ChgData.chgData(this.downloadRate));
/* 138 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 146 */       this.fileID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 147 */       this.downloadRate = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 2, "|"))).doubleValue();
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 152 */       CError tError = new CError();
/* 153 */       tError.moduleName = "MLibraryRateSchema";
/* 154 */       tError.functionName = "decode";
/* 155 */       tError.errorMessage = ex.toString();
/* 156 */       this.mErrors.addOneError(tError);
/*     */ 
/* 158 */       return false;
/*     */     }
/* 160 */     return true;
/*     */   }
/*     */ 
/*     */   public String getV(String FCode)
/*     */   {
/* 166 */     String strReturn = "";
/* 167 */     if (FCode.equalsIgnoreCase("fileID"))
/*     */     {
/* 169 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.fileID));
/*     */     }
/* 171 */     if (FCode.equalsIgnoreCase("downloadRate"))
/*     */     {
/* 173 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.downloadRate));
/*     */     }
/* 175 */     if (strReturn.equals(""))
/*     */     {
/* 177 */       strReturn = "null";
/*     */     }
/*     */ 
/* 180 */     return strReturn;
/*     */   }
/*     */ 
/*     */   public String getV(int nFieldIndex)
/*     */   {
/* 187 */     String strFieldValue = "";
/* 188 */     switch (nFieldIndex) {
/*     */     case 0:
/* 190 */       strFieldValue = StrTool.GBKToUnicode(this.fileID);
/* 191 */       break;
/*     */     case 1:
/* 193 */       strFieldValue = String.valueOf(this.downloadRate);
/* 194 */       break;
/*     */     default:
/* 196 */       strFieldValue = "";
/*     */     }
/* 198 */     if (strFieldValue.equals("")) {
/* 199 */       strFieldValue = "null";
/*     */     }
/* 201 */     return strFieldValue;
/*     */   }
/*     */ 
/*     */   public boolean setV(String FCode, String FValue)
/*     */   {
/* 207 */     if (StrTool.cTrim(FCode).equals("")) {
/* 208 */       return false;
/*     */     }
/* 210 */     if (FCode.equalsIgnoreCase("fileID"))
/*     */     {
/* 212 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 214 */         this.fileID = FValue.trim();
/*     */       }
/*     */       else
/* 217 */         this.fileID = null;
/*     */     }
/* 219 */     if (FCode.equalsIgnoreCase("downloadRate"))
/*     */     {
/* 221 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 223 */         Double tDouble = new Double(FValue);
/* 224 */         double d = tDouble.doubleValue();
/* 225 */         this.downloadRate = d;
/*     */       }
/*     */     }
/* 228 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object otherObject)
/*     */   {
/* 233 */     if (otherObject == null) return false;
/* 234 */     if (this == otherObject) return true;
/* 235 */     if (getClass() != otherObject.getClass()) return false;
/* 236 */     MLibraryRateSchema other = (MLibraryRateSchema)otherObject;
/* 237 */     if ((this.fileID == null) && (other.getFileID() != null)) return false;
/* 238 */     if ((this.fileID != null) && (!this.fileID.equals(other.getFileID()))) return false;
/* 239 */     return Double.doubleToLongBits(this.downloadRate) == Double.doubleToLongBits(other.getDownloadRate());
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 246 */     return 2;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 252 */     if (strFieldName.equals("fileID")) {
/* 253 */       return 0;
/*     */     }
/* 255 */     if (strFieldName.equals("downloadRate")) {
/* 256 */       return 1;
/*     */     }
/* 258 */     return -1;
/*     */   }
/*     */ 
/*     */   public String getFieldName(int nFieldIndex)
/*     */   {
/* 264 */     String strFieldName = "";
/* 265 */     switch (nFieldIndex) {
/*     */     case 0:
/* 267 */       strFieldName = "fileID";
/* 268 */       break;
/*     */     case 1:
/* 270 */       strFieldName = "downloadRate";
/* 271 */       break;
/*     */     default:
/* 273 */       strFieldName = "";
/*     */     }
/* 275 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 281 */     if (strFieldName.equals("fileID")) {
/* 282 */       return 0;
/*     */     }
/* 284 */     if (strFieldName.equals("downloadRate")) {
/* 285 */       return 4;
/*     */     }
/* 287 */     return -1;
/*     */   }
/*     */ 
/*     */   public int getFieldType(int nFieldIndex)
/*     */   {
/* 293 */     int nFieldType = -1;
/* 294 */     switch (nFieldIndex) {
/*     */     case 0:
/* 296 */       nFieldType = 0;
/* 297 */       break;
/*     */     case 1:
/* 299 */       nFieldType = 4;
/* 300 */       break;
/*     */     default:
/* 302 */       nFieldType = -1;
/*     */     }
/* 304 */     return nFieldType;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.schema.MLibraryRateSchema
 * JD-Core Version:    0.6.0
 */