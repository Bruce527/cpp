/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPDutySchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPDutySet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPDutyDBSet extends LNPDutySet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPDutyDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPDuty");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPDutyDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPDuty");
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
/*  50 */     tError.moduleName = "LNPDutyDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPDuty WHERE  DutyCode = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getDutyCode() == null) || (get(i).getDutyCode().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getDutyCode());
/*     */         }
/*  78 */         pstmt.addBatch();
/*     */       }
/*  80 */       pstmt.executeBatch();
/*  81 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  84 */       ex.printStackTrace();
/*  85 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  86 */       CError tError = new CError();
/*  87 */       tError.moduleName = "LNPDutyDBSet";
/*  88 */       tError.functionName = "delete()";
/*  89 */       tError.errorMessage = ex.toString();
/*  90 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/*  93 */         pstmt.close(); } catch (Exception e) {
/*  94 */         e.printStackTrace();
/*     */       }
/*  96 */       if (!this.mflag) {
/*     */         try {
/*  98 */           this.con.close(); } catch (Exception e) {
/*  99 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 102 */       return false;
/*     */     }
/*     */ 
/* 105 */     if (!this.mflag) {
/*     */       try {
/* 107 */         this.con.close(); } catch (Exception e) {
/* 108 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 111 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 117 */     PreparedStatement pstmt = null;
/*     */ 
/* 119 */     if (!this.mflag) {
/* 120 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 125 */       int tCount = size();
/* 126 */       pstmt = this.con.prepareStatement("UPDATE LNPDuty SET  DutyCode = ? , DutyName = ? , PayEndYear = ? , PayEndYearFlag = ? , PayEndDateCalRef = ? , PayEndDateCalMode = ? , GetYear = ? , GetYearFlag = ? , InsuYear = ? , InsuYearFlag = ? , AcciYear = ? , AcciYearFlag = ? , CalMode = ? , PayEndYearRela = ? , GetYearRela = ? , InsuYearRela = ? , BasicCalCode = ? , RiskCalCode = ? , AmntFlag = ? , VPU = ? , AddFeeFlag = ? , EndDateCalMode = ? WHERE  DutyCode = ?");
/* 127 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 129 */         if ((get(i).getDutyCode() == null) || (get(i).getDutyCode().equals("null")))
/* 130 */           pstmt.setString(1, null);
/*     */         else {
/* 132 */           pstmt.setString(1, get(i).getDutyCode());
/*     */         }
/* 134 */         if ((get(i).getDutyName() == null) || (get(i).getDutyName().equals("null")))
/* 135 */           pstmt.setString(2, null);
/*     */         else {
/* 137 */           pstmt.setString(2, get(i).getDutyName());
/*     */         }
/* 139 */         pstmt.setInt(3, get(i).getPayEndYear());
/* 140 */         if ((get(i).getPayEndYearFlag() == null) || (get(i).getPayEndYearFlag().equals("null")))
/* 141 */           pstmt.setString(4, null);
/*     */         else {
/* 143 */           pstmt.setString(4, get(i).getPayEndYearFlag());
/*     */         }
/* 145 */         if ((get(i).getPayEndDateCalRef() == null) || (get(i).getPayEndDateCalRef().equals("null")))
/* 146 */           pstmt.setString(5, null);
/*     */         else {
/* 148 */           pstmt.setString(5, get(i).getPayEndDateCalRef());
/*     */         }
/* 150 */         if ((get(i).getPayEndDateCalMode() == null) || (get(i).getPayEndDateCalMode().equals("null")))
/* 151 */           pstmt.setString(6, null);
/*     */         else {
/* 153 */           pstmt.setString(6, get(i).getPayEndDateCalMode());
/*     */         }
/* 155 */         pstmt.setInt(7, get(i).getGetYear());
/* 156 */         if ((get(i).getGetYearFlag() == null) || (get(i).getGetYearFlag().equals("null")))
/* 157 */           pstmt.setString(8, null);
/*     */         else {
/* 159 */           pstmt.setString(8, get(i).getGetYearFlag());
/*     */         }
/* 161 */         pstmt.setInt(9, get(i).getInsuYear());
/* 162 */         if ((get(i).getInsuYearFlag() == null) || (get(i).getInsuYearFlag().equals("null")))
/* 163 */           pstmt.setString(10, null);
/*     */         else {
/* 165 */           pstmt.setString(10, get(i).getInsuYearFlag());
/*     */         }
/* 167 */         pstmt.setInt(11, get(i).getAcciYear());
/* 168 */         if ((get(i).getAcciYearFlag() == null) || (get(i).getAcciYearFlag().equals("null")))
/* 169 */           pstmt.setString(12, null);
/*     */         else {
/* 171 */           pstmt.setString(12, get(i).getAcciYearFlag());
/*     */         }
/* 173 */         if ((get(i).getCalMode() == null) || (get(i).getCalMode().equals("null")))
/* 174 */           pstmt.setString(13, null);
/*     */         else {
/* 176 */           pstmt.setString(13, get(i).getCalMode());
/*     */         }
/* 178 */         if ((get(i).getPayEndYearRela() == null) || (get(i).getPayEndYearRela().equals("null")))
/* 179 */           pstmt.setString(14, null);
/*     */         else {
/* 181 */           pstmt.setString(14, get(i).getPayEndYearRela());
/*     */         }
/* 183 */         if ((get(i).getGetYearRela() == null) || (get(i).getGetYearRela().equals("null")))
/* 184 */           pstmt.setString(15, null);
/*     */         else {
/* 186 */           pstmt.setString(15, get(i).getGetYearRela());
/*     */         }
/* 188 */         if ((get(i).getInsuYearRela() == null) || (get(i).getInsuYearRela().equals("null")))
/* 189 */           pstmt.setString(16, null);
/*     */         else {
/* 191 */           pstmt.setString(16, get(i).getInsuYearRela());
/*     */         }
/* 193 */         if ((get(i).getBasicCalCode() == null) || (get(i).getBasicCalCode().equals("null")))
/* 194 */           pstmt.setString(17, null);
/*     */         else {
/* 196 */           pstmt.setString(17, get(i).getBasicCalCode());
/*     */         }
/* 198 */         if ((get(i).getRiskCalCode() == null) || (get(i).getRiskCalCode().equals("null")))
/* 199 */           pstmt.setString(18, null);
/*     */         else {
/* 201 */           pstmt.setString(18, get(i).getRiskCalCode());
/*     */         }
/* 203 */         if ((get(i).getAmntFlag() == null) || (get(i).getAmntFlag().equals("null")))
/* 204 */           pstmt.setString(19, null);
/*     */         else {
/* 206 */           pstmt.setString(19, get(i).getAmntFlag());
/*     */         }
/* 208 */         pstmt.setDouble(20, get(i).getVPU());
/* 209 */         if ((get(i).getAddFeeFlag() == null) || (get(i).getAddFeeFlag().equals("null")))
/* 210 */           pstmt.setString(21, null);
/*     */         else {
/* 212 */           pstmt.setString(21, get(i).getAddFeeFlag());
/*     */         }
/* 214 */         if ((get(i).getEndDateCalMode() == null) || (get(i).getEndDateCalMode().equals("null")))
/* 215 */           pstmt.setString(22, null);
/*     */         else {
/* 217 */           pstmt.setString(22, get(i).getEndDateCalMode());
/*     */         }
/*     */ 
/* 220 */         if ((get(i).getDutyCode() == null) || (get(i).getDutyCode().equals("null")))
/* 221 */           pstmt.setString(23, null);
/*     */         else {
/* 223 */           pstmt.setString(23, get(i).getDutyCode());
/*     */         }
/* 225 */         pstmt.addBatch();
/*     */       }
/* 227 */       pstmt.executeBatch();
/* 228 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 231 */       ex.printStackTrace();
/* 232 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 233 */       CError tError = new CError();
/* 234 */       tError.moduleName = "LNPDutyDBSet";
/* 235 */       tError.functionName = "update()";
/* 236 */       tError.errorMessage = ex.toString();
/* 237 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 240 */         pstmt.close(); } catch (Exception e) {
/* 241 */         e.printStackTrace();
/*     */       }
/* 243 */       if (!this.mflag) {
/*     */         try {
/* 245 */           this.con.close(); } catch (Exception e) {
/* 246 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 249 */       return false;
/*     */     }
/*     */ 
/* 252 */     if (!this.mflag) {
/*     */       try {
/* 254 */         this.con.close(); } catch (Exception e) {
/* 255 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 258 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 264 */     PreparedStatement pstmt = null;
/*     */ 
/* 266 */     if (!this.mflag) {
/* 267 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 272 */       int tCount = size();
/* 273 */       pstmt = this.con.prepareStatement("INSERT INTO LNPDuty VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 274 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 276 */         if ((get(i).getDutyCode() == null) || (get(i).getDutyCode().equals("null")))
/* 277 */           pstmt.setString(1, null);
/*     */         else {
/* 279 */           pstmt.setString(1, get(i).getDutyCode());
/*     */         }
/* 281 */         if ((get(i).getDutyName() == null) || (get(i).getDutyName().equals("null")))
/* 282 */           pstmt.setString(2, null);
/*     */         else {
/* 284 */           pstmt.setString(2, get(i).getDutyName());
/*     */         }
/* 286 */         pstmt.setInt(3, get(i).getPayEndYear());
/* 287 */         if ((get(i).getPayEndYearFlag() == null) || (get(i).getPayEndYearFlag().equals("null")))
/* 288 */           pstmt.setString(4, null);
/*     */         else {
/* 290 */           pstmt.setString(4, get(i).getPayEndYearFlag());
/*     */         }
/* 292 */         if ((get(i).getPayEndDateCalRef() == null) || (get(i).getPayEndDateCalRef().equals("null")))
/* 293 */           pstmt.setString(5, null);
/*     */         else {
/* 295 */           pstmt.setString(5, get(i).getPayEndDateCalRef());
/*     */         }
/* 297 */         if ((get(i).getPayEndDateCalMode() == null) || (get(i).getPayEndDateCalMode().equals("null")))
/* 298 */           pstmt.setString(6, null);
/*     */         else {
/* 300 */           pstmt.setString(6, get(i).getPayEndDateCalMode());
/*     */         }
/* 302 */         pstmt.setInt(7, get(i).getGetYear());
/* 303 */         if ((get(i).getGetYearFlag() == null) || (get(i).getGetYearFlag().equals("null")))
/* 304 */           pstmt.setString(8, null);
/*     */         else {
/* 306 */           pstmt.setString(8, get(i).getGetYearFlag());
/*     */         }
/* 308 */         pstmt.setInt(9, get(i).getInsuYear());
/* 309 */         if ((get(i).getInsuYearFlag() == null) || (get(i).getInsuYearFlag().equals("null")))
/* 310 */           pstmt.setString(10, null);
/*     */         else {
/* 312 */           pstmt.setString(10, get(i).getInsuYearFlag());
/*     */         }
/* 314 */         pstmt.setInt(11, get(i).getAcciYear());
/* 315 */         if ((get(i).getAcciYearFlag() == null) || (get(i).getAcciYearFlag().equals("null")))
/* 316 */           pstmt.setString(12, null);
/*     */         else {
/* 318 */           pstmt.setString(12, get(i).getAcciYearFlag());
/*     */         }
/* 320 */         if ((get(i).getCalMode() == null) || (get(i).getCalMode().equals("null")))
/* 321 */           pstmt.setString(13, null);
/*     */         else {
/* 323 */           pstmt.setString(13, get(i).getCalMode());
/*     */         }
/* 325 */         if ((get(i).getPayEndYearRela() == null) || (get(i).getPayEndYearRela().equals("null")))
/* 326 */           pstmt.setString(14, null);
/*     */         else {
/* 328 */           pstmt.setString(14, get(i).getPayEndYearRela());
/*     */         }
/* 330 */         if ((get(i).getGetYearRela() == null) || (get(i).getGetYearRela().equals("null")))
/* 331 */           pstmt.setString(15, null);
/*     */         else {
/* 333 */           pstmt.setString(15, get(i).getGetYearRela());
/*     */         }
/* 335 */         if ((get(i).getInsuYearRela() == null) || (get(i).getInsuYearRela().equals("null")))
/* 336 */           pstmt.setString(16, null);
/*     */         else {
/* 338 */           pstmt.setString(16, get(i).getInsuYearRela());
/*     */         }
/* 340 */         if ((get(i).getBasicCalCode() == null) || (get(i).getBasicCalCode().equals("null")))
/* 341 */           pstmt.setString(17, null);
/*     */         else {
/* 343 */           pstmt.setString(17, get(i).getBasicCalCode());
/*     */         }
/* 345 */         if ((get(i).getRiskCalCode() == null) || (get(i).getRiskCalCode().equals("null")))
/* 346 */           pstmt.setString(18, null);
/*     */         else {
/* 348 */           pstmt.setString(18, get(i).getRiskCalCode());
/*     */         }
/* 350 */         if ((get(i).getAmntFlag() == null) || (get(i).getAmntFlag().equals("null")))
/* 351 */           pstmt.setString(19, null);
/*     */         else {
/* 353 */           pstmt.setString(19, get(i).getAmntFlag());
/*     */         }
/* 355 */         pstmt.setDouble(20, get(i).getVPU());
/* 356 */         if ((get(i).getAddFeeFlag() == null) || (get(i).getAddFeeFlag().equals("null")))
/* 357 */           pstmt.setString(21, null);
/*     */         else {
/* 359 */           pstmt.setString(21, get(i).getAddFeeFlag());
/*     */         }
/* 361 */         if ((get(i).getEndDateCalMode() == null) || (get(i).getEndDateCalMode().equals("null")))
/* 362 */           pstmt.setString(22, null);
/*     */         else {
/* 364 */           pstmt.setString(22, get(i).getEndDateCalMode());
/*     */         }
/* 366 */         pstmt.addBatch();
/*     */       }
/* 368 */       pstmt.executeBatch();
/* 369 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 372 */       ex.printStackTrace();
/* 373 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 374 */       CError tError = new CError();
/* 375 */       tError.moduleName = "LNPDutyDBSet";
/* 376 */       tError.functionName = "insert()";
/* 377 */       tError.errorMessage = ex.toString();
/* 378 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 381 */         pstmt.close(); } catch (Exception e) {
/* 382 */         e.printStackTrace();
/*     */       }
/* 384 */       if (!this.mflag) {
/*     */         try {
/* 386 */           this.con.close(); } catch (Exception e) {
/* 387 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 390 */       return false;
/*     */     }
/*     */ 
/* 393 */     if (!this.mflag) {
/*     */       try {
/* 395 */         this.con.close(); } catch (Exception e) {
/* 396 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 399 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPDutyDBSet
 * JD-Core Version:    0.6.0
 */