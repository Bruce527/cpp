/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPRiskScreenValidateSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPRiskScreenValidateSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPRiskScreenValidateDBSet extends LNPRiskScreenValidateSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPRiskScreenValidateDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPRiskScreenValidate");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPRiskScreenValidateDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPRiskScreenValidate");
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
/*  50 */     tError.moduleName = "LNPRiskScreenValidateDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPRiskScreenValidate WHERE  ControlId = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getControlId() == null) || (get(i).getControlId().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getControlId());
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
/*  87 */       tError.moduleName = "LNPRiskScreenValidateDBSet";
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
/* 126 */       pstmt = this.con.prepareStatement("UPDATE LNPRiskScreenValidate SET  ControlId = ? , RiskCode = ? , ControlCode = ? , ControlValue = ? , FunctionType = ? , RelaDivCode = ? , RelaDivShow = ? , RelaControlCode = ? , RelaControlType = ? , RelaValueSql = ? , CalCode = ? , Noti = ? WHERE  ControlId = ?");
/* 127 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 129 */         if ((get(i).getControlId() == null) || (get(i).getControlId().equals("null")))
/* 130 */           pstmt.setString(1, null);
/*     */         else {
/* 132 */           pstmt.setString(1, get(i).getControlId());
/*     */         }
/* 134 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 135 */           pstmt.setString(2, null);
/*     */         else {
/* 137 */           pstmt.setString(2, get(i).getRiskCode());
/*     */         }
/* 139 */         if ((get(i).getControlCode() == null) || (get(i).getControlCode().equals("null")))
/* 140 */           pstmt.setString(3, null);
/*     */         else {
/* 142 */           pstmt.setString(3, get(i).getControlCode());
/*     */         }
/* 144 */         if ((get(i).getControlValue() == null) || (get(i).getControlValue().equals("null")))
/* 145 */           pstmt.setString(4, null);
/*     */         else {
/* 147 */           pstmt.setString(4, get(i).getControlValue());
/*     */         }
/* 149 */         if ((get(i).getFunctionType() == null) || (get(i).getFunctionType().equals("null")))
/* 150 */           pstmt.setString(5, null);
/*     */         else {
/* 152 */           pstmt.setString(5, get(i).getFunctionType());
/*     */         }
/* 154 */         if ((get(i).getRelaDivCode() == null) || (get(i).getRelaDivCode().equals("null")))
/* 155 */           pstmt.setString(6, null);
/*     */         else {
/* 157 */           pstmt.setString(6, get(i).getRelaDivCode());
/*     */         }
/* 159 */         if ((get(i).getRelaDivShow() == null) || (get(i).getRelaDivShow().equals("null")))
/* 160 */           pstmt.setString(7, null);
/*     */         else {
/* 162 */           pstmt.setString(7, get(i).getRelaDivShow());
/*     */         }
/* 164 */         if ((get(i).getRelaControlCode() == null) || (get(i).getRelaControlCode().equals("null")))
/* 165 */           pstmt.setString(8, null);
/*     */         else {
/* 167 */           pstmt.setString(8, get(i).getRelaControlCode());
/*     */         }
/* 169 */         if ((get(i).getRelaControlType() == null) || (get(i).getRelaControlType().equals("null")))
/* 170 */           pstmt.setString(9, null);
/*     */         else {
/* 172 */           pstmt.setString(9, get(i).getRelaControlType());
/*     */         }
/* 174 */         if ((get(i).getRelaValueSql() == null) || (get(i).getRelaValueSql().equals("null")))
/* 175 */           pstmt.setString(10, null);
/*     */         else {
/* 177 */           pstmt.setString(10, get(i).getRelaValueSql());
/*     */         }
/* 179 */         if ((get(i).getCalCode() == null) || (get(i).getCalCode().equals("null")))
/* 180 */           pstmt.setString(11, null);
/*     */         else {
/* 182 */           pstmt.setString(11, get(i).getCalCode());
/*     */         }
/* 184 */         if ((get(i).getNoti() == null) || (get(i).getNoti().equals("null")))
/* 185 */           pstmt.setString(12, null);
/*     */         else {
/* 187 */           pstmt.setString(12, get(i).getNoti());
/*     */         }
/*     */ 
/* 190 */         if ((get(i).getControlId() == null) || (get(i).getControlId().equals("null")))
/* 191 */           pstmt.setString(13, null);
/*     */         else {
/* 193 */           pstmt.setString(13, get(i).getControlId());
/*     */         }
/* 195 */         pstmt.addBatch();
/*     */       }
/* 197 */       pstmt.executeBatch();
/* 198 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 201 */       ex.printStackTrace();
/* 202 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 203 */       CError tError = new CError();
/* 204 */       tError.moduleName = "LNPRiskScreenValidateDBSet";
/* 205 */       tError.functionName = "update()";
/* 206 */       tError.errorMessage = ex.toString();
/* 207 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 210 */         pstmt.close(); } catch (Exception e) {
/* 211 */         e.printStackTrace();
/*     */       }
/* 213 */       if (!this.mflag) {
/*     */         try {
/* 215 */           this.con.close(); } catch (Exception e) {
/* 216 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 219 */       return false;
/*     */     }
/*     */ 
/* 222 */     if (!this.mflag) {
/*     */       try {
/* 224 */         this.con.close(); } catch (Exception e) {
/* 225 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 228 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 234 */     PreparedStatement pstmt = null;
/*     */ 
/* 236 */     if (!this.mflag) {
/* 237 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 242 */       int tCount = size();
/* 243 */       pstmt = this.con.prepareStatement("INSERT INTO LNPRiskScreenValidate VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 244 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 246 */         if ((get(i).getControlId() == null) || (get(i).getControlId().equals("null")))
/* 247 */           pstmt.setString(1, null);
/*     */         else {
/* 249 */           pstmt.setString(1, get(i).getControlId());
/*     */         }
/* 251 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 252 */           pstmt.setString(2, null);
/*     */         else {
/* 254 */           pstmt.setString(2, get(i).getRiskCode());
/*     */         }
/* 256 */         if ((get(i).getControlCode() == null) || (get(i).getControlCode().equals("null")))
/* 257 */           pstmt.setString(3, null);
/*     */         else {
/* 259 */           pstmt.setString(3, get(i).getControlCode());
/*     */         }
/* 261 */         if ((get(i).getControlValue() == null) || (get(i).getControlValue().equals("null")))
/* 262 */           pstmt.setString(4, null);
/*     */         else {
/* 264 */           pstmt.setString(4, get(i).getControlValue());
/*     */         }
/* 266 */         if ((get(i).getFunctionType() == null) || (get(i).getFunctionType().equals("null")))
/* 267 */           pstmt.setString(5, null);
/*     */         else {
/* 269 */           pstmt.setString(5, get(i).getFunctionType());
/*     */         }
/* 271 */         if ((get(i).getRelaDivCode() == null) || (get(i).getRelaDivCode().equals("null")))
/* 272 */           pstmt.setString(6, null);
/*     */         else {
/* 274 */           pstmt.setString(6, get(i).getRelaDivCode());
/*     */         }
/* 276 */         if ((get(i).getRelaDivShow() == null) || (get(i).getRelaDivShow().equals("null")))
/* 277 */           pstmt.setString(7, null);
/*     */         else {
/* 279 */           pstmt.setString(7, get(i).getRelaDivShow());
/*     */         }
/* 281 */         if ((get(i).getRelaControlCode() == null) || (get(i).getRelaControlCode().equals("null")))
/* 282 */           pstmt.setString(8, null);
/*     */         else {
/* 284 */           pstmt.setString(8, get(i).getRelaControlCode());
/*     */         }
/* 286 */         if ((get(i).getRelaControlType() == null) || (get(i).getRelaControlType().equals("null")))
/* 287 */           pstmt.setString(9, null);
/*     */         else {
/* 289 */           pstmt.setString(9, get(i).getRelaControlType());
/*     */         }
/* 291 */         if ((get(i).getRelaValueSql() == null) || (get(i).getRelaValueSql().equals("null")))
/* 292 */           pstmt.setString(10, null);
/*     */         else {
/* 294 */           pstmt.setString(10, get(i).getRelaValueSql());
/*     */         }
/* 296 */         if ((get(i).getCalCode() == null) || (get(i).getCalCode().equals("null")))
/* 297 */           pstmt.setString(11, null);
/*     */         else {
/* 299 */           pstmt.setString(11, get(i).getCalCode());
/*     */         }
/* 301 */         if ((get(i).getNoti() == null) || (get(i).getNoti().equals("null")))
/* 302 */           pstmt.setString(12, null);
/*     */         else {
/* 304 */           pstmt.setString(12, get(i).getNoti());
/*     */         }
/* 306 */         pstmt.addBatch();
/*     */       }
/* 308 */       pstmt.executeBatch();
/* 309 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 312 */       ex.printStackTrace();
/* 313 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 314 */       CError tError = new CError();
/* 315 */       tError.moduleName = "LNPRiskScreenValidateDBSet";
/* 316 */       tError.functionName = "insert()";
/* 317 */       tError.errorMessage = ex.toString();
/* 318 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 321 */         pstmt.close(); } catch (Exception e) {
/* 322 */         e.printStackTrace();
/*     */       }
/* 324 */       if (!this.mflag) {
/*     */         try {
/* 326 */           this.con.close(); } catch (Exception e) {
/* 327 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 330 */       return false;
/*     */     }
/*     */ 
/* 333 */     if (!this.mflag) {
/*     */       try {
/* 335 */         this.con.close(); } catch (Exception e) {
/* 336 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 339 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPRiskScreenValidateDBSet
 * JD-Core Version:    0.6.0
 */