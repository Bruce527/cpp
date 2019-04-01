/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPDutyPaySchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPDutyPaySet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPDutyPayDBSet extends LNPDutyPaySet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPDutyPayDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPDutyPay");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPDutyPayDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPDutyPay");
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
/*  50 */     tError.moduleName = "LNPDutyPayDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPDutyPay WHERE  PayPlanCode = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getPayPlanCode() == null) || (get(i).getPayPlanCode().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getPayPlanCode());
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
/*  87 */       tError.moduleName = "LNPDutyPayDBSet";
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
/* 126 */       pstmt = this.con.prepareStatement("UPDATE LNPDutyPay SET  PayPlanCode = ? , PayPlanName = ? , Type = ? , PayIntv = ? , PayEndYearFlag = ? , PayEndYear = ? , PayEndDateCalRef = ? , PayEndDateCalMode = ? , DefaultVal = ? , CalCode = ? , CnterCalCode = ? , OthCalCode = ? , Rate = ? , MinPay = ? , AssuYield = ? , FeeRate = ? , PayToDateCalMode = ? , UrgePayFlag = ? , PayLackFlag = ? , PayOverFlag = ? , PayOverDeal = ? , AvoidPayFlag = ? , GracePeriod = ? , PubFlag = ? , ZeroFlag = ? , NeedAcc = ? , PayAimClass = ? WHERE  PayPlanCode = ?");
/* 127 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 129 */         if ((get(i).getPayPlanCode() == null) || (get(i).getPayPlanCode().equals("null")))
/* 130 */           pstmt.setString(1, null);
/*     */         else {
/* 132 */           pstmt.setString(1, get(i).getPayPlanCode());
/*     */         }
/* 134 */         if ((get(i).getPayPlanName() == null) || (get(i).getPayPlanName().equals("null")))
/* 135 */           pstmt.setString(2, null);
/*     */         else {
/* 137 */           pstmt.setString(2, get(i).getPayPlanName());
/*     */         }
/* 139 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 140 */           pstmt.setString(3, null);
/*     */         else {
/* 142 */           pstmt.setString(3, get(i).getType());
/*     */         }
/* 144 */         pstmt.setInt(4, get(i).getPayIntv());
/* 145 */         if ((get(i).getPayEndYearFlag() == null) || (get(i).getPayEndYearFlag().equals("null")))
/* 146 */           pstmt.setString(5, null);
/*     */         else {
/* 148 */           pstmt.setString(5, get(i).getPayEndYearFlag());
/*     */         }
/* 150 */         pstmt.setInt(6, get(i).getPayEndYear());
/* 151 */         if ((get(i).getPayEndDateCalRef() == null) || (get(i).getPayEndDateCalRef().equals("null")))
/* 152 */           pstmt.setString(7, null);
/*     */         else {
/* 154 */           pstmt.setString(7, get(i).getPayEndDateCalRef());
/*     */         }
/* 156 */         if ((get(i).getPayEndDateCalMode() == null) || (get(i).getPayEndDateCalMode().equals("null")))
/* 157 */           pstmt.setString(8, null);
/*     */         else {
/* 159 */           pstmt.setString(8, get(i).getPayEndDateCalMode());
/*     */         }
/* 161 */         pstmt.setDouble(9, get(i).getDefaultVal());
/* 162 */         if ((get(i).getCalCode() == null) || (get(i).getCalCode().equals("null")))
/* 163 */           pstmt.setString(10, null);
/*     */         else {
/* 165 */           pstmt.setString(10, get(i).getCalCode());
/*     */         }
/* 167 */         if ((get(i).getCnterCalCode() == null) || (get(i).getCnterCalCode().equals("null")))
/* 168 */           pstmt.setString(11, null);
/*     */         else {
/* 170 */           pstmt.setString(11, get(i).getCnterCalCode());
/*     */         }
/* 172 */         if ((get(i).getOthCalCode() == null) || (get(i).getOthCalCode().equals("null")))
/* 173 */           pstmt.setString(12, null);
/*     */         else {
/* 175 */           pstmt.setString(12, get(i).getOthCalCode());
/*     */         }
/* 177 */         pstmt.setDouble(13, get(i).getRate());
/* 178 */         pstmt.setDouble(14, get(i).getMinPay());
/* 179 */         pstmt.setDouble(15, get(i).getAssuYield());
/* 180 */         pstmt.setDouble(16, get(i).getFeeRate());
/* 181 */         if ((get(i).getPayToDateCalMode() == null) || (get(i).getPayToDateCalMode().equals("null")))
/* 182 */           pstmt.setString(17, null);
/*     */         else {
/* 184 */           pstmt.setString(17, get(i).getPayToDateCalMode());
/*     */         }
/* 186 */         if ((get(i).getUrgePayFlag() == null) || (get(i).getUrgePayFlag().equals("null")))
/* 187 */           pstmt.setString(18, null);
/*     */         else {
/* 189 */           pstmt.setString(18, get(i).getUrgePayFlag());
/*     */         }
/* 191 */         if ((get(i).getPayLackFlag() == null) || (get(i).getPayLackFlag().equals("null")))
/* 192 */           pstmt.setString(19, null);
/*     */         else {
/* 194 */           pstmt.setString(19, get(i).getPayLackFlag());
/*     */         }
/* 196 */         if ((get(i).getPayOverFlag() == null) || (get(i).getPayOverFlag().equals("null")))
/* 197 */           pstmt.setString(20, null);
/*     */         else {
/* 199 */           pstmt.setString(20, get(i).getPayOverFlag());
/*     */         }
/* 201 */         if ((get(i).getPayOverDeal() == null) || (get(i).getPayOverDeal().equals("null")))
/* 202 */           pstmt.setString(21, null);
/*     */         else {
/* 204 */           pstmt.setString(21, get(i).getPayOverDeal());
/*     */         }
/* 206 */         if ((get(i).getAvoidPayFlag() == null) || (get(i).getAvoidPayFlag().equals("null")))
/* 207 */           pstmt.setString(22, null);
/*     */         else {
/* 209 */           pstmt.setString(22, get(i).getAvoidPayFlag());
/*     */         }
/* 211 */         pstmt.setInt(23, get(i).getGracePeriod());
/* 212 */         if ((get(i).getPubFlag() == null) || (get(i).getPubFlag().equals("null")))
/* 213 */           pstmt.setString(24, null);
/*     */         else {
/* 215 */           pstmt.setString(24, get(i).getPubFlag());
/*     */         }
/* 217 */         if ((get(i).getZeroFlag() == null) || (get(i).getZeroFlag().equals("null")))
/* 218 */           pstmt.setString(25, null);
/*     */         else {
/* 220 */           pstmt.setString(25, get(i).getZeroFlag());
/*     */         }
/* 222 */         if ((get(i).getNeedAcc() == null) || (get(i).getNeedAcc().equals("null")))
/* 223 */           pstmt.setString(26, null);
/*     */         else {
/* 225 */           pstmt.setString(26, get(i).getNeedAcc());
/*     */         }
/* 227 */         if ((get(i).getPayAimClass() == null) || (get(i).getPayAimClass().equals("null")))
/* 228 */           pstmt.setString(27, null);
/*     */         else {
/* 230 */           pstmt.setString(27, get(i).getPayAimClass());
/*     */         }
/*     */ 
/* 233 */         if ((get(i).getPayPlanCode() == null) || (get(i).getPayPlanCode().equals("null")))
/* 234 */           pstmt.setString(28, null);
/*     */         else {
/* 236 */           pstmt.setString(28, get(i).getPayPlanCode());
/*     */         }
/* 238 */         pstmt.addBatch();
/*     */       }
/* 240 */       pstmt.executeBatch();
/* 241 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 244 */       ex.printStackTrace();
/* 245 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 246 */       CError tError = new CError();
/* 247 */       tError.moduleName = "LNPDutyPayDBSet";
/* 248 */       tError.functionName = "update()";
/* 249 */       tError.errorMessage = ex.toString();
/* 250 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 253 */         pstmt.close(); } catch (Exception e) {
/* 254 */         e.printStackTrace();
/*     */       }
/* 256 */       if (!this.mflag) {
/*     */         try {
/* 258 */           this.con.close(); } catch (Exception e) {
/* 259 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 262 */       return false;
/*     */     }
/*     */ 
/* 265 */     if (!this.mflag) {
/*     */       try {
/* 267 */         this.con.close(); } catch (Exception e) {
/* 268 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 271 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 277 */     PreparedStatement pstmt = null;
/*     */ 
/* 279 */     if (!this.mflag) {
/* 280 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 285 */       int tCount = size();
/* 286 */       pstmt = this.con.prepareStatement("INSERT INTO LNPDutyPay VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 287 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 289 */         if ((get(i).getPayPlanCode() == null) || (get(i).getPayPlanCode().equals("null")))
/* 290 */           pstmt.setString(1, null);
/*     */         else {
/* 292 */           pstmt.setString(1, get(i).getPayPlanCode());
/*     */         }
/* 294 */         if ((get(i).getPayPlanName() == null) || (get(i).getPayPlanName().equals("null")))
/* 295 */           pstmt.setString(2, null);
/*     */         else {
/* 297 */           pstmt.setString(2, get(i).getPayPlanName());
/*     */         }
/* 299 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 300 */           pstmt.setString(3, null);
/*     */         else {
/* 302 */           pstmt.setString(3, get(i).getType());
/*     */         }
/* 304 */         pstmt.setInt(4, get(i).getPayIntv());
/* 305 */         if ((get(i).getPayEndYearFlag() == null) || (get(i).getPayEndYearFlag().equals("null")))
/* 306 */           pstmt.setString(5, null);
/*     */         else {
/* 308 */           pstmt.setString(5, get(i).getPayEndYearFlag());
/*     */         }
/* 310 */         pstmt.setInt(6, get(i).getPayEndYear());
/* 311 */         if ((get(i).getPayEndDateCalRef() == null) || (get(i).getPayEndDateCalRef().equals("null")))
/* 312 */           pstmt.setString(7, null);
/*     */         else {
/* 314 */           pstmt.setString(7, get(i).getPayEndDateCalRef());
/*     */         }
/* 316 */         if ((get(i).getPayEndDateCalMode() == null) || (get(i).getPayEndDateCalMode().equals("null")))
/* 317 */           pstmt.setString(8, null);
/*     */         else {
/* 319 */           pstmt.setString(8, get(i).getPayEndDateCalMode());
/*     */         }
/* 321 */         pstmt.setDouble(9, get(i).getDefaultVal());
/* 322 */         if ((get(i).getCalCode() == null) || (get(i).getCalCode().equals("null")))
/* 323 */           pstmt.setString(10, null);
/*     */         else {
/* 325 */           pstmt.setString(10, get(i).getCalCode());
/*     */         }
/* 327 */         if ((get(i).getCnterCalCode() == null) || (get(i).getCnterCalCode().equals("null")))
/* 328 */           pstmt.setString(11, null);
/*     */         else {
/* 330 */           pstmt.setString(11, get(i).getCnterCalCode());
/*     */         }
/* 332 */         if ((get(i).getOthCalCode() == null) || (get(i).getOthCalCode().equals("null")))
/* 333 */           pstmt.setString(12, null);
/*     */         else {
/* 335 */           pstmt.setString(12, get(i).getOthCalCode());
/*     */         }
/* 337 */         pstmt.setDouble(13, get(i).getRate());
/* 338 */         pstmt.setDouble(14, get(i).getMinPay());
/* 339 */         pstmt.setDouble(15, get(i).getAssuYield());
/* 340 */         pstmt.setDouble(16, get(i).getFeeRate());
/* 341 */         if ((get(i).getPayToDateCalMode() == null) || (get(i).getPayToDateCalMode().equals("null")))
/* 342 */           pstmt.setString(17, null);
/*     */         else {
/* 344 */           pstmt.setString(17, get(i).getPayToDateCalMode());
/*     */         }
/* 346 */         if ((get(i).getUrgePayFlag() == null) || (get(i).getUrgePayFlag().equals("null")))
/* 347 */           pstmt.setString(18, null);
/*     */         else {
/* 349 */           pstmt.setString(18, get(i).getUrgePayFlag());
/*     */         }
/* 351 */         if ((get(i).getPayLackFlag() == null) || (get(i).getPayLackFlag().equals("null")))
/* 352 */           pstmt.setString(19, null);
/*     */         else {
/* 354 */           pstmt.setString(19, get(i).getPayLackFlag());
/*     */         }
/* 356 */         if ((get(i).getPayOverFlag() == null) || (get(i).getPayOverFlag().equals("null")))
/* 357 */           pstmt.setString(20, null);
/*     */         else {
/* 359 */           pstmt.setString(20, get(i).getPayOverFlag());
/*     */         }
/* 361 */         if ((get(i).getPayOverDeal() == null) || (get(i).getPayOverDeal().equals("null")))
/* 362 */           pstmt.setString(21, null);
/*     */         else {
/* 364 */           pstmt.setString(21, get(i).getPayOverDeal());
/*     */         }
/* 366 */         if ((get(i).getAvoidPayFlag() == null) || (get(i).getAvoidPayFlag().equals("null")))
/* 367 */           pstmt.setString(22, null);
/*     */         else {
/* 369 */           pstmt.setString(22, get(i).getAvoidPayFlag());
/*     */         }
/* 371 */         pstmt.setInt(23, get(i).getGracePeriod());
/* 372 */         if ((get(i).getPubFlag() == null) || (get(i).getPubFlag().equals("null")))
/* 373 */           pstmt.setString(24, null);
/*     */         else {
/* 375 */           pstmt.setString(24, get(i).getPubFlag());
/*     */         }
/* 377 */         if ((get(i).getZeroFlag() == null) || (get(i).getZeroFlag().equals("null")))
/* 378 */           pstmt.setString(25, null);
/*     */         else {
/* 380 */           pstmt.setString(25, get(i).getZeroFlag());
/*     */         }
/* 382 */         if ((get(i).getNeedAcc() == null) || (get(i).getNeedAcc().equals("null")))
/* 383 */           pstmt.setString(26, null);
/*     */         else {
/* 385 */           pstmt.setString(26, get(i).getNeedAcc());
/*     */         }
/* 387 */         if ((get(i).getPayAimClass() == null) || (get(i).getPayAimClass().equals("null")))
/* 388 */           pstmt.setString(27, null);
/*     */         else {
/* 390 */           pstmt.setString(27, get(i).getPayAimClass());
/*     */         }
/* 392 */         pstmt.addBatch();
/*     */       }
/* 394 */       pstmt.executeBatch();
/* 395 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 398 */       ex.printStackTrace();
/* 399 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 400 */       CError tError = new CError();
/* 401 */       tError.moduleName = "LNPDutyPayDBSet";
/* 402 */       tError.functionName = "insert()";
/* 403 */       tError.errorMessage = ex.toString();
/* 404 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 407 */         pstmt.close(); } catch (Exception e) {
/* 408 */         e.printStackTrace();
/*     */       }
/* 410 */       if (!this.mflag) {
/*     */         try {
/* 412 */           this.con.close(); } catch (Exception e) {
/* 413 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 416 */       return false;
/*     */     }
/*     */ 
/* 419 */     if (!this.mflag) {
/*     */       try {
/* 421 */         this.con.close(); } catch (Exception e) {
/* 422 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 425 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPDutyPayDBSet
 * JD-Core Version:    0.6.0
 */