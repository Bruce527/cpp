/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPRiskScreenSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPRiskScreenSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPRiskScreenDBSet extends LNPRiskScreenSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPRiskScreenDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPRiskScreen");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPRiskScreenDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPRiskScreen");
/*  36 */     this.con = this.db.getConnection();
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  41 */     if (this.db.deleteSQL(this))
/*     */     {
/*  43 */       return true;
/*     */     }
/*     */ 
/*  48 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*  49 */     CError tError = new CError();
/*  50 */     tError.moduleName = "LNPRiskScreenDBSet";
/*  51 */     tError.functionName = "deleteSQL";
/*  52 */     tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  53 */     this.mErrors.addOneError(tError);
/*  54 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean delete()
/*     */   {
/*  61 */     PreparedStatement pstmt = null;
/*     */ 
/*  63 */     if (!this.mflag) {
/*  64 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  69 */       int tCount = size();
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPRiskScreen WHERE  RiskCode = ? AND CtrlIndex = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getRiskCode());
/*     */         }
/*  78 */         pstmt.setInt(2, get(i).getCtrlIndex());
/*  79 */         pstmt.addBatch();
/*     */       }
/*  81 */       pstmt.executeBatch();
/*  82 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  85 */       ex.printStackTrace();
/*  86 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  87 */       CError tError = new CError();
/*  88 */       tError.moduleName = "LNPRiskScreenDBSet";
/*  89 */       tError.functionName = "delete()";
/*  90 */       tError.errorMessage = ex.toString();
/*  91 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/*  94 */         pstmt.close(); } catch (Exception e) {
/*  95 */         e.printStackTrace();
/*     */       }
/*  97 */       if (!this.mflag) {
/*     */         try {
/*  99 */           this.con.close(); } catch (Exception e) {
/* 100 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 103 */       return false;
/*     */     }
/*     */ 
/* 106 */     if (!this.mflag) {
/*     */       try {
/* 108 */         this.con.close(); } catch (Exception e) {
/* 109 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 112 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 118 */     PreparedStatement pstmt = null;
/*     */ 
/* 120 */     if (!this.mflag) {
/* 121 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 126 */       int tCount = size();
/* 127 */       pstmt = this.con.prepareStatement("UPDATE LNPRiskScreen SET  RiskCode = ? , CtrlIndex = ? , CtrlType = ? , CtrlCode = ? , CtrlName = ? , CtrlLevel = ? , CtrlProperty = ? , CtrlAlignX = ? , CtrlAlignY = ? , CtrlHorizontal = ? , CtrlVertical = ? , CtrlBackground = ? , LabelAlignX = ? , LabelAlignY = ? , LabelHorizontal = ? , LabelVertical = ? , LabelBackground = ? , DefaultValue = ? , DefaultSql = ? , CtrlProperty1 = ? , CtrlProperty2 = ? , Noti = ? WHERE  RiskCode = ? AND CtrlIndex = ?");
/* 128 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 130 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 131 */           pstmt.setString(1, null);
/*     */         else {
/* 133 */           pstmt.setString(1, get(i).getRiskCode());
/*     */         }
/* 135 */         pstmt.setInt(2, get(i).getCtrlIndex());
/* 136 */         if ((get(i).getCtrlType() == null) || (get(i).getCtrlType().equals("null")))
/* 137 */           pstmt.setString(3, null);
/*     */         else {
/* 139 */           pstmt.setString(3, get(i).getCtrlType());
/*     */         }
/* 141 */         if ((get(i).getCtrlCode() == null) || (get(i).getCtrlCode().equals("null")))
/* 142 */           pstmt.setString(4, null);
/*     */         else {
/* 144 */           pstmt.setString(4, get(i).getCtrlCode());
/*     */         }
/* 146 */         if ((get(i).getCtrlName() == null) || (get(i).getCtrlName().equals("null")))
/* 147 */           pstmt.setString(5, null);
/*     */         else {
/* 149 */           pstmt.setString(5, get(i).getCtrlName());
/*     */         }
/* 151 */         if ((get(i).getCtrlLevel() == null) || (get(i).getCtrlLevel().equals("null")))
/* 152 */           pstmt.setString(6, null);
/*     */         else {
/* 154 */           pstmt.setString(6, get(i).getCtrlLevel());
/*     */         }
/* 156 */         if ((get(i).getCtrlProperty() == null) || (get(i).getCtrlProperty().equals("null")))
/* 157 */           pstmt.setString(7, null);
/*     */         else {
/* 159 */           pstmt.setString(7, get(i).getCtrlProperty());
/*     */         }
/* 161 */         pstmt.setInt(8, get(i).getCtrlAlignX());
/* 162 */         pstmt.setInt(9, get(i).getCtrlAlignY());
/* 163 */         pstmt.setInt(10, get(i).getCtrlHorizontal());
/* 164 */         pstmt.setInt(11, get(i).getCtrlVertical());
/* 165 */         if ((get(i).getCtrlBackground() == null) || (get(i).getCtrlBackground().equals("null")))
/* 166 */           pstmt.setString(12, null);
/*     */         else {
/* 168 */           pstmt.setString(12, get(i).getCtrlBackground());
/*     */         }
/* 170 */         pstmt.setInt(13, get(i).getLabelAlignX());
/* 171 */         pstmt.setInt(14, get(i).getLabelAlignY());
/* 172 */         pstmt.setInt(15, get(i).getLabelHorizontal());
/* 173 */         pstmt.setInt(16, get(i).getLabelVertical());
/* 174 */         if ((get(i).getLabelBackground() == null) || (get(i).getLabelBackground().equals("null")))
/* 175 */           pstmt.setString(17, null);
/*     */         else {
/* 177 */           pstmt.setString(17, get(i).getLabelBackground());
/*     */         }
/* 179 */         if ((get(i).getDefaultValue() == null) || (get(i).getDefaultValue().equals("null")))
/* 180 */           pstmt.setString(18, null);
/*     */         else {
/* 182 */           pstmt.setString(18, get(i).getDefaultValue());
/*     */         }
/* 184 */         if ((get(i).getDefaultSql() == null) || (get(i).getDefaultSql().equals("null")))
/* 185 */           pstmt.setString(19, null);
/*     */         else {
/* 187 */           pstmt.setString(19, get(i).getDefaultSql());
/*     */         }
/* 189 */         if ((get(i).getCtrlProperty1() == null) || (get(i).getCtrlProperty1().equals("null")))
/* 190 */           pstmt.setString(20, null);
/*     */         else {
/* 192 */           pstmt.setString(20, get(i).getCtrlProperty1());
/*     */         }
/* 194 */         if ((get(i).getCtrlProperty2() == null) || (get(i).getCtrlProperty2().equals("null")))
/* 195 */           pstmt.setString(21, null);
/*     */         else {
/* 197 */           pstmt.setString(21, get(i).getCtrlProperty2());
/*     */         }
/* 199 */         if ((get(i).getNoti() == null) || (get(i).getNoti().equals("null")))
/* 200 */           pstmt.setString(22, null);
/*     */         else {
/* 202 */           pstmt.setString(22, get(i).getNoti());
/*     */         }
/*     */ 
/* 205 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 206 */           pstmt.setString(23, null);
/*     */         else {
/* 208 */           pstmt.setString(23, get(i).getRiskCode());
/*     */         }
/* 210 */         pstmt.setInt(24, get(i).getCtrlIndex());
/* 211 */         pstmt.addBatch();
/*     */       }
/* 213 */       pstmt.executeBatch();
/* 214 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 217 */       ex.printStackTrace();
/* 218 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 219 */       CError tError = new CError();
/* 220 */       tError.moduleName = "LNPRiskScreenDBSet";
/* 221 */       tError.functionName = "update()";
/* 222 */       tError.errorMessage = ex.toString();
/* 223 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 226 */         pstmt.close(); } catch (Exception e) {
/* 227 */         e.printStackTrace();
/*     */       }
/* 229 */       if (!this.mflag) {
/*     */         try {
/* 231 */           this.con.close(); } catch (Exception e) {
/* 232 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 235 */       return false;
/*     */     }
/*     */ 
/* 238 */     if (!this.mflag) {
/*     */       try {
/* 240 */         this.con.close(); } catch (Exception e) {
/* 241 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 244 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 250 */     PreparedStatement pstmt = null;
/*     */ 
/* 252 */     if (!this.mflag) {
/* 253 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 258 */       int tCount = size();
/* 259 */       pstmt = this.con.prepareStatement("INSERT INTO LNPRiskScreen VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 260 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 262 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 263 */           pstmt.setString(1, null);
/*     */         else {
/* 265 */           pstmt.setString(1, get(i).getRiskCode());
/*     */         }
/* 267 */         pstmt.setInt(2, get(i).getCtrlIndex());
/* 268 */         if ((get(i).getCtrlType() == null) || (get(i).getCtrlType().equals("null")))
/* 269 */           pstmt.setString(3, null);
/*     */         else {
/* 271 */           pstmt.setString(3, get(i).getCtrlType());
/*     */         }
/* 273 */         if ((get(i).getCtrlCode() == null) || (get(i).getCtrlCode().equals("null")))
/* 274 */           pstmt.setString(4, null);
/*     */         else {
/* 276 */           pstmt.setString(4, get(i).getCtrlCode());
/*     */         }
/* 278 */         if ((get(i).getCtrlName() == null) || (get(i).getCtrlName().equals("null")))
/* 279 */           pstmt.setString(5, null);
/*     */         else {
/* 281 */           pstmt.setString(5, get(i).getCtrlName());
/*     */         }
/* 283 */         if ((get(i).getCtrlLevel() == null) || (get(i).getCtrlLevel().equals("null")))
/* 284 */           pstmt.setString(6, null);
/*     */         else {
/* 286 */           pstmt.setString(6, get(i).getCtrlLevel());
/*     */         }
/* 288 */         if ((get(i).getCtrlProperty() == null) || (get(i).getCtrlProperty().equals("null")))
/* 289 */           pstmt.setString(7, null);
/*     */         else {
/* 291 */           pstmt.setString(7, get(i).getCtrlProperty());
/*     */         }
/* 293 */         pstmt.setInt(8, get(i).getCtrlAlignX());
/* 294 */         pstmt.setInt(9, get(i).getCtrlAlignY());
/* 295 */         pstmt.setInt(10, get(i).getCtrlHorizontal());
/* 296 */         pstmt.setInt(11, get(i).getCtrlVertical());
/* 297 */         if ((get(i).getCtrlBackground() == null) || (get(i).getCtrlBackground().equals("null")))
/* 298 */           pstmt.setString(12, null);
/*     */         else {
/* 300 */           pstmt.setString(12, get(i).getCtrlBackground());
/*     */         }
/* 302 */         pstmt.setInt(13, get(i).getLabelAlignX());
/* 303 */         pstmt.setInt(14, get(i).getLabelAlignY());
/* 304 */         pstmt.setInt(15, get(i).getLabelHorizontal());
/* 305 */         pstmt.setInt(16, get(i).getLabelVertical());
/* 306 */         if ((get(i).getLabelBackground() == null) || (get(i).getLabelBackground().equals("null")))
/* 307 */           pstmt.setString(17, null);
/*     */         else {
/* 309 */           pstmt.setString(17, get(i).getLabelBackground());
/*     */         }
/* 311 */         if ((get(i).getDefaultValue() == null) || (get(i).getDefaultValue().equals("null")))
/* 312 */           pstmt.setString(18, null);
/*     */         else {
/* 314 */           pstmt.setString(18, get(i).getDefaultValue());
/*     */         }
/* 316 */         if ((get(i).getDefaultSql() == null) || (get(i).getDefaultSql().equals("null")))
/* 317 */           pstmt.setString(19, null);
/*     */         else {
/* 319 */           pstmt.setString(19, get(i).getDefaultSql());
/*     */         }
/* 321 */         if ((get(i).getCtrlProperty1() == null) || (get(i).getCtrlProperty1().equals("null")))
/* 322 */           pstmt.setString(20, null);
/*     */         else {
/* 324 */           pstmt.setString(20, get(i).getCtrlProperty1());
/*     */         }
/* 326 */         if ((get(i).getCtrlProperty2() == null) || (get(i).getCtrlProperty2().equals("null")))
/* 327 */           pstmt.setString(21, null);
/*     */         else {
/* 329 */           pstmt.setString(21, get(i).getCtrlProperty2());
/*     */         }
/* 331 */         if ((get(i).getNoti() == null) || (get(i).getNoti().equals("null")))
/* 332 */           pstmt.setString(22, null);
/*     */         else {
/* 334 */           pstmt.setString(22, get(i).getNoti());
/*     */         }
/* 336 */         pstmt.addBatch();
/*     */       }
/* 338 */       pstmt.executeBatch();
/* 339 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 342 */       ex.printStackTrace();
/* 343 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 344 */       CError tError = new CError();
/* 345 */       tError.moduleName = "LNPRiskScreenDBSet";
/* 346 */       tError.functionName = "insert()";
/* 347 */       tError.errorMessage = ex.toString();
/* 348 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 351 */         pstmt.close(); } catch (Exception e) {
/* 352 */         e.printStackTrace();
/*     */       }
/* 354 */       if (!this.mflag) {
/*     */         try {
/* 356 */           this.con.close(); } catch (Exception e) {
/* 357 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 360 */       return false;
/*     */     }
/*     */ 
/* 363 */     if (!this.mflag) {
/*     */       try {
/* 365 */         this.con.close(); } catch (Exception e) {
/* 366 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 369 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPRiskScreenDBSet
 * JD-Core Version:    0.6.0
 */