/*     */ package com.sinosoft.map.lis.schema;
/*     */ 
/*     */ import com.sinosoft.map.lis.db.MNewsClickCountDB;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.ChgData;
/*     */ import com.sinosoft.map.utility.Schema;
/*     */ import com.sinosoft.map.utility.StrTool;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ public class MNewsClickCountSchema
/*     */   implements Schema, Cloneable
/*     */ {
/*     */   private String newsID;
/*     */   private double clickRate;
/*     */   public static final int FIELDNUM = 2;
/*     */   private static String[] PK;
/*     */   public CErrors mErrors;
/*     */ 
/*     */   public MNewsClickCountSchema()
/*     */   {
/*  33 */     this.mErrors = new CErrors();
/*     */ 
/*  35 */     String[] pk = new String[1];
/*  36 */     pk[0] = "NewsID";
/*     */ 
/*  38 */     PK = pk;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  45 */     MNewsClickCountSchema cloned = (MNewsClickCountSchema)super.clone();
/*  46 */     cloned.mErrors = ((CErrors)this.mErrors.clone());
/*  47 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String[] getPK()
/*     */   {
/*  53 */     return PK;
/*     */   }
/*     */ 
/*     */   public String getNewsID()
/*     */   {
/*  58 */     return this.newsID;
/*     */   }
/*     */ 
/*     */   public void setNewsID(String aNewsID) {
/*  62 */     this.newsID = aNewsID;
/*     */   }
/*     */ 
/*     */   public double getClickRate() {
/*  66 */     return this.clickRate;
/*     */   }
/*     */ 
/*     */   public void setClickRate(double aClickRate) {
/*  70 */     this.clickRate = aClickRate;
/*     */   }
/*     */ 
/*     */   public void setClickRate(String aClickRate) {
/*  74 */     if ((aClickRate != null) && (!aClickRate.equals("")))
/*     */     {
/*  76 */       Double tDouble = new Double(aClickRate);
/*  77 */       double d = tDouble.doubleValue();
/*  78 */       this.clickRate = d;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setSchema(MNewsClickCountSchema aMNewsClickCountSchema)
/*     */   {
/*  86 */     this.newsID = aMNewsClickCountSchema.getNewsID();
/*  87 */     this.clickRate = aMNewsClickCountSchema.getClickRate();
/*     */   }
/*     */ 
/*     */   public boolean setSchema(ResultSet rs, int i)
/*     */   {
/*     */     try
/*     */     {
/*  96 */       if (rs.getString("NewsID") == null)
/*  97 */         this.newsID = null;
/*     */       else {
/*  99 */         this.newsID = rs.getString("NewsID").trim();
/*     */       }
/* 101 */       this.clickRate = rs.getDouble("ClickRate");
/*     */     }
/*     */     catch (SQLException sqle)
/*     */     {
/* 105 */       System.out.println("\u6570\u636E\u5E93\u4E2D\u7684MNewsClickCount\u8868\u5B57\u6BB5\u4E2A\u6570\u548CSchema\u4E2D\u7684\u5B57\u6BB5\u4E2A\u6570\u4E0D\u4E00\u81F4\uFF0C\u6216\u8005\u6267\u884Cdb.executeQuery\u67E5\u8BE2\u65F6\u6CA1\u6709\u4F7F\u7528select * from tables");
/*     */ 
/* 107 */       CError tError = new CError();
/* 108 */       tError.moduleName = "MNewsClickCountSchema";
/* 109 */       tError.functionName = "setSchema";
/* 110 */       tError.errorMessage = sqle.toString();
/* 111 */       this.mErrors.addOneError(tError);
/* 112 */       return false;
/*     */     }
/* 114 */     return true;
/*     */   }
/*     */ 
/*     */   public MNewsClickCountSchema getSchema()
/*     */   {
/* 119 */     MNewsClickCountSchema aMNewsClickCountSchema = new MNewsClickCountSchema();
/* 120 */     aMNewsClickCountSchema.setSchema(this);
/* 121 */     return aMNewsClickCountSchema;
/*     */   }
/*     */ 
/*     */   public MNewsClickCountDB getDB()
/*     */   {
/* 126 */     MNewsClickCountDB aDBOper = new MNewsClickCountDB();
/* 127 */     aDBOper.setSchema(this);
/* 128 */     return aDBOper;
/*     */   }
/*     */ 
/*     */   public String encode()
/*     */   {
/* 135 */     StringBuffer strReturn = new StringBuffer(256);
/* 136 */     strReturn.append(StrTool.cTrim(this.newsID)); strReturn.append("|");
/* 137 */     strReturn.append(ChgData.chgData(this.clickRate));
/* 138 */     return strReturn.toString();
/*     */   }
/*     */ 
/*     */   public boolean decode(String strMessage)
/*     */   {
/*     */     try
/*     */     {
/* 146 */       this.newsID = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, "|");
/* 147 */       this.clickRate = new Double(ChgData.chgNumericStr(StrTool.getStr(strMessage, 2, "|"))).doubleValue();
/*     */     }
/*     */     catch (NumberFormatException ex)
/*     */     {
/* 152 */       CError tError = new CError();
/* 153 */       tError.moduleName = "MNewsClickCountSchema";
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
/* 167 */     if (FCode.equalsIgnoreCase("newsID"))
/*     */     {
/* 169 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.newsID));
/*     */     }
/* 171 */     if (FCode.equalsIgnoreCase("clickRate"))
/*     */     {
/* 173 */       strReturn = StrTool.GBKToUnicode(String.valueOf(this.clickRate));
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
/* 190 */       strFieldValue = StrTool.GBKToUnicode(this.newsID);
/* 191 */       break;
/*     */     case 1:
/* 193 */       strFieldValue = String.valueOf(this.clickRate);
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
/* 210 */     if (FCode.equalsIgnoreCase("newsID"))
/*     */     {
/* 212 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 214 */         this.newsID = FValue.trim();
/*     */       }
/*     */       else
/* 217 */         this.newsID = null;
/*     */     }
/* 219 */     if (FCode.equalsIgnoreCase("clickRate"))
/*     */     {
/* 221 */       if ((FValue != null) && (!FValue.equals("")))
/*     */       {
/* 223 */         Double tDouble = new Double(FValue);
/* 224 */         double d = tDouble.doubleValue();
/* 225 */         this.clickRate = d;
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
/* 236 */     MNewsClickCountSchema other = (MNewsClickCountSchema)otherObject;
/* 237 */     if ((this.newsID == null) && (other.getNewsID() != null)) return false;
/* 238 */     if ((this.newsID != null) && (!this.newsID.equals(other.getNewsID()))) return false;
/* 239 */     return Double.doubleToLongBits(this.clickRate) == Double.doubleToLongBits(other.getClickRate());
/*     */   }
/*     */ 
/*     */   public int getFieldCount()
/*     */   {
/* 246 */     return 2;
/*     */   }
/*     */ 
/*     */   public int getFieldIndex(String strFieldName)
/*     */   {
/* 252 */     if (strFieldName.equals("newsID")) {
/* 253 */       return 0;
/*     */     }
/* 255 */     if (strFieldName.equals("clickRate")) {
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
/* 267 */       strFieldName = "newsID";
/* 268 */       break;
/*     */     case 1:
/* 270 */       strFieldName = "clickRate";
/* 271 */       break;
/*     */     default:
/* 273 */       strFieldName = "";
/*     */     }
/* 275 */     return strFieldName;
/*     */   }
/*     */ 
/*     */   public int getFieldType(String strFieldName)
/*     */   {
/* 281 */     if (strFieldName.equals("newsID")) {
/* 282 */       return 0;
/*     */     }
/* 284 */     if (strFieldName.equals("clickRate")) {
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
 * Qualified Name:     com.sinosoft.map.lis.schema.MNewsClickCountSchema
 * JD-Core Version:    0.6.0
 */