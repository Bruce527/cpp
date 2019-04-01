/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPRiskSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPRiskSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPRiskDBSet extends LNPRiskSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPRiskDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPRisk");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPRiskDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPRisk");
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
/*  50 */     tError.moduleName = "LNPRiskDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPRisk WHERE  RiskCode = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getRiskCode());
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
/*  87 */       tError.moduleName = "LNPRiskDBSet";
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
/* 126 */       pstmt = this.con.prepareStatement("UPDATE LNPRisk SET  RiskCode = ? , RiskVer = ? , RiskName = ? , RiskShortName = ? , RiskEnName = ? , RiskEnShortName = ? , ChoDutyFlag = ? , CPayFlag = ? , GetFlag = ? , EdorFlag = ? , RnewFlag = ? , UWFlag = ? , RinsFlag = ? , InsuAccFlag = ? , DestRate = ? , OrigRiskCode = ? , SubRiskVer = ? , RiskStatName = ? WHERE  RiskCode = ?");
/* 127 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 129 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 130 */           pstmt.setString(1, null);
/*     */         else {
/* 132 */           pstmt.setString(1, get(i).getRiskCode());
/*     */         }
/* 134 */         if ((get(i).getRiskVer() == null) || (get(i).getRiskVer().equals("null")))
/* 135 */           pstmt.setString(2, null);
/*     */         else {
/* 137 */           pstmt.setString(2, get(i).getRiskVer());
/*     */         }
/* 139 */         if ((get(i).getRiskName() == null) || (get(i).getRiskName().equals("null")))
/* 140 */           pstmt.setString(3, null);
/*     */         else {
/* 142 */           pstmt.setString(3, get(i).getRiskName());
/*     */         }
/* 144 */         if ((get(i).getRiskShortName() == null) || (get(i).getRiskShortName().equals("null")))
/* 145 */           pstmt.setString(4, null);
/*     */         else {
/* 147 */           pstmt.setString(4, get(i).getRiskShortName());
/*     */         }
/* 149 */         if ((get(i).getRiskEnName() == null) || (get(i).getRiskEnName().equals("null")))
/* 150 */           pstmt.setString(5, null);
/*     */         else {
/* 152 */           pstmt.setString(5, get(i).getRiskEnName());
/*     */         }
/* 154 */         if ((get(i).getRiskEnShortName() == null) || (get(i).getRiskEnShortName().equals("null")))
/* 155 */           pstmt.setString(6, null);
/*     */         else {
/* 157 */           pstmt.setString(6, get(i).getRiskEnShortName());
/*     */         }
/* 159 */         if ((get(i).getChoDutyFlag() == null) || (get(i).getChoDutyFlag().equals("null")))
/* 160 */           pstmt.setString(7, null);
/*     */         else {
/* 162 */           pstmt.setString(7, get(i).getChoDutyFlag());
/*     */         }
/* 164 */         if ((get(i).getCPayFlag() == null) || (get(i).getCPayFlag().equals("null")))
/* 165 */           pstmt.setString(8, null);
/*     */         else {
/* 167 */           pstmt.setString(8, get(i).getCPayFlag());
/*     */         }
/* 169 */         if ((get(i).getGetFlag() == null) || (get(i).getGetFlag().equals("null")))
/* 170 */           pstmt.setString(9, null);
/*     */         else {
/* 172 */           pstmt.setString(9, get(i).getGetFlag());
/*     */         }
/* 174 */         if ((get(i).getEdorFlag() == null) || (get(i).getEdorFlag().equals("null")))
/* 175 */           pstmt.setString(10, null);
/*     */         else {
/* 177 */           pstmt.setString(10, get(i).getEdorFlag());
/*     */         }
/* 179 */         if ((get(i).getRnewFlag() == null) || (get(i).getRnewFlag().equals("null")))
/* 180 */           pstmt.setString(11, null);
/*     */         else {
/* 182 */           pstmt.setString(11, get(i).getRnewFlag());
/*     */         }
/* 184 */         if ((get(i).getUWFlag() == null) || (get(i).getUWFlag().equals("null")))
/* 185 */           pstmt.setString(12, null);
/*     */         else {
/* 187 */           pstmt.setString(12, get(i).getUWFlag());
/*     */         }
/* 189 */         if ((get(i).getRinsFlag() == null) || (get(i).getRinsFlag().equals("null")))
/* 190 */           pstmt.setString(13, null);
/*     */         else {
/* 192 */           pstmt.setString(13, get(i).getRinsFlag());
/*     */         }
/* 194 */         if ((get(i).getInsuAccFlag() == null) || (get(i).getInsuAccFlag().equals("null")))
/* 195 */           pstmt.setString(14, null);
/*     */         else {
/* 197 */           pstmt.setString(14, get(i).getInsuAccFlag());
/*     */         }
/* 199 */         pstmt.setDouble(15, get(i).getDestRate());
/* 200 */         if ((get(i).getOrigRiskCode() == null) || (get(i).getOrigRiskCode().equals("null")))
/* 201 */           pstmt.setString(16, null);
/*     */         else {
/* 203 */           pstmt.setString(16, get(i).getOrigRiskCode());
/*     */         }
/* 205 */         if ((get(i).getSubRiskVer() == null) || (get(i).getSubRiskVer().equals("null")))
/* 206 */           pstmt.setString(17, null);
/*     */         else {
/* 208 */           pstmt.setString(17, get(i).getSubRiskVer());
/*     */         }
/* 210 */         if ((get(i).getRiskStatName() == null) || (get(i).getRiskStatName().equals("null")))
/* 211 */           pstmt.setString(18, null);
/*     */         else {
/* 213 */           pstmt.setString(18, get(i).getRiskStatName());
/*     */         }
/*     */ 
/* 216 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 217 */           pstmt.setString(19, null);
/*     */         else {
/* 219 */           pstmt.setString(19, get(i).getRiskCode());
/*     */         }
/* 221 */         pstmt.addBatch();
/*     */       }
/* 223 */       pstmt.executeBatch();
/* 224 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 227 */       ex.printStackTrace();
/* 228 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 229 */       CError tError = new CError();
/* 230 */       tError.moduleName = "LNPRiskDBSet";
/* 231 */       tError.functionName = "update()";
/* 232 */       tError.errorMessage = ex.toString();
/* 233 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 236 */         pstmt.close(); } catch (Exception e) {
/* 237 */         e.printStackTrace();
/*     */       }
/* 239 */       if (!this.mflag) {
/*     */         try {
/* 241 */           this.con.close(); } catch (Exception e) {
/* 242 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 245 */       return false;
/*     */     }
/*     */ 
/* 248 */     if (!this.mflag) {
/*     */       try {
/* 250 */         this.con.close(); } catch (Exception e) {
/* 251 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 254 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 260 */     PreparedStatement pstmt = null;
/*     */ 
/* 262 */     if (!this.mflag) {
/* 263 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 268 */       int tCount = size();
/* 269 */       pstmt = this.con.prepareStatement("INSERT INTO LNPRisk VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 270 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 272 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 273 */           pstmt.setString(1, null);
/*     */         else {
/* 275 */           pstmt.setString(1, get(i).getRiskCode());
/*     */         }
/* 277 */         if ((get(i).getRiskVer() == null) || (get(i).getRiskVer().equals("null")))
/* 278 */           pstmt.setString(2, null);
/*     */         else {
/* 280 */           pstmt.setString(2, get(i).getRiskVer());
/*     */         }
/* 282 */         if ((get(i).getRiskName() == null) || (get(i).getRiskName().equals("null")))
/* 283 */           pstmt.setString(3, null);
/*     */         else {
/* 285 */           pstmt.setString(3, get(i).getRiskName());
/*     */         }
/* 287 */         if ((get(i).getRiskShortName() == null) || (get(i).getRiskShortName().equals("null")))
/* 288 */           pstmt.setString(4, null);
/*     */         else {
/* 290 */           pstmt.setString(4, get(i).getRiskShortName());
/*     */         }
/* 292 */         if ((get(i).getRiskEnName() == null) || (get(i).getRiskEnName().equals("null")))
/* 293 */           pstmt.setString(5, null);
/*     */         else {
/* 295 */           pstmt.setString(5, get(i).getRiskEnName());
/*     */         }
/* 297 */         if ((get(i).getRiskEnShortName() == null) || (get(i).getRiskEnShortName().equals("null")))
/* 298 */           pstmt.setString(6, null);
/*     */         else {
/* 300 */           pstmt.setString(6, get(i).getRiskEnShortName());
/*     */         }
/* 302 */         if ((get(i).getChoDutyFlag() == null) || (get(i).getChoDutyFlag().equals("null")))
/* 303 */           pstmt.setString(7, null);
/*     */         else {
/* 305 */           pstmt.setString(7, get(i).getChoDutyFlag());
/*     */         }
/* 307 */         if ((get(i).getCPayFlag() == null) || (get(i).getCPayFlag().equals("null")))
/* 308 */           pstmt.setString(8, null);
/*     */         else {
/* 310 */           pstmt.setString(8, get(i).getCPayFlag());
/*     */         }
/* 312 */         if ((get(i).getGetFlag() == null) || (get(i).getGetFlag().equals("null")))
/* 313 */           pstmt.setString(9, null);
/*     */         else {
/* 315 */           pstmt.setString(9, get(i).getGetFlag());
/*     */         }
/* 317 */         if ((get(i).getEdorFlag() == null) || (get(i).getEdorFlag().equals("null")))
/* 318 */           pstmt.setString(10, null);
/*     */         else {
/* 320 */           pstmt.setString(10, get(i).getEdorFlag());
/*     */         }
/* 322 */         if ((get(i).getRnewFlag() == null) || (get(i).getRnewFlag().equals("null")))
/* 323 */           pstmt.setString(11, null);
/*     */         else {
/* 325 */           pstmt.setString(11, get(i).getRnewFlag());
/*     */         }
/* 327 */         if ((get(i).getUWFlag() == null) || (get(i).getUWFlag().equals("null")))
/* 328 */           pstmt.setString(12, null);
/*     */         else {
/* 330 */           pstmt.setString(12, get(i).getUWFlag());
/*     */         }
/* 332 */         if ((get(i).getRinsFlag() == null) || (get(i).getRinsFlag().equals("null")))
/* 333 */           pstmt.setString(13, null);
/*     */         else {
/* 335 */           pstmt.setString(13, get(i).getRinsFlag());
/*     */         }
/* 337 */         if ((get(i).getInsuAccFlag() == null) || (get(i).getInsuAccFlag().equals("null")))
/* 338 */           pstmt.setString(14, null);
/*     */         else {
/* 340 */           pstmt.setString(14, get(i).getInsuAccFlag());
/*     */         }
/* 342 */         pstmt.setDouble(15, get(i).getDestRate());
/* 343 */         if ((get(i).getOrigRiskCode() == null) || (get(i).getOrigRiskCode().equals("null")))
/* 344 */           pstmt.setString(16, null);
/*     */         else {
/* 346 */           pstmt.setString(16, get(i).getOrigRiskCode());
/*     */         }
/* 348 */         if ((get(i).getSubRiskVer() == null) || (get(i).getSubRiskVer().equals("null")))
/* 349 */           pstmt.setString(17, null);
/*     */         else {
/* 351 */           pstmt.setString(17, get(i).getSubRiskVer());
/*     */         }
/* 353 */         if ((get(i).getRiskStatName() == null) || (get(i).getRiskStatName().equals("null")))
/* 354 */           pstmt.setString(18, null);
/*     */         else {
/* 356 */           pstmt.setString(18, get(i).getRiskStatName());
/*     */         }
/* 358 */         pstmt.addBatch();
/*     */       }
/* 360 */       pstmt.executeBatch();
/* 361 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 364 */       ex.printStackTrace();
/* 365 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 366 */       CError tError = new CError();
/* 367 */       tError.moduleName = "LNPRiskDBSet";
/* 368 */       tError.functionName = "insert()";
/* 369 */       tError.errorMessage = ex.toString();
/* 370 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 373 */         pstmt.close(); } catch (Exception e) {
/* 374 */         e.printStackTrace();
/*     */       }
/* 376 */       if (!this.mflag) {
/*     */         try {
/* 378 */           this.con.close(); } catch (Exception e) {
/* 379 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 382 */       return false;
/*     */     }
/*     */ 
/* 385 */     if (!this.mflag) {
/*     */       try {
/* 387 */         this.con.close(); } catch (Exception e) {
/* 388 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 391 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPRiskDBSet
 * JD-Core Version:    0.6.0
 */