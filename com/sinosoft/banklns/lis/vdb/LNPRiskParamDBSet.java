/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPRiskParamSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPRiskParamSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPRiskParamDBSet extends LNPRiskParamSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPRiskParamDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPRiskParam");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPRiskParamDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPRiskParam");
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
/*  50 */     tError.moduleName = "LNPRiskParamDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPRiskParam WHERE  Type = ? AND RiskCode = ? AND Param = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getType());
/*     */         }
/*  78 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/*  79 */           pstmt.setString(2, null);
/*     */         else {
/*  81 */           pstmt.setString(2, get(i).getRiskCode());
/*     */         }
/*  83 */         if ((get(i).getParam() == null) || (get(i).getParam().equals("null")))
/*  84 */           pstmt.setString(3, null);
/*     */         else {
/*  86 */           pstmt.setString(3, get(i).getParam());
/*     */         }
/*  88 */         pstmt.addBatch();
/*     */       }
/*  90 */       pstmt.executeBatch();
/*  91 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  94 */       ex.printStackTrace();
/*  95 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  96 */       CError tError = new CError();
/*  97 */       tError.moduleName = "LNPRiskParamDBSet";
/*  98 */       tError.functionName = "delete()";
/*  99 */       tError.errorMessage = ex.toString();
/* 100 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 103 */         pstmt.close(); } catch (Exception e) {
/* 104 */         e.printStackTrace();
/*     */       }
/* 106 */       if (!this.mflag) {
/*     */         try {
/* 108 */           this.con.close(); } catch (Exception e) {
/* 109 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 112 */       return false;
/*     */     }
/*     */ 
/* 115 */     if (!this.mflag) {
/*     */       try {
/* 117 */         this.con.close(); } catch (Exception e) {
/* 118 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 121 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 127 */     PreparedStatement pstmt = null;
/*     */ 
/* 129 */     if (!this.mflag) {
/* 130 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 135 */       int tCount = size();
/* 136 */       pstmt = this.con.prepareStatement("UPDATE LNPRiskParam SET  Type = ? , RiskCode = ? , Param = ? , Expression = ? , Remark = ? WHERE  Type = ? AND RiskCode = ? AND Param = ?");
/* 137 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 139 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 140 */           pstmt.setString(1, null);
/*     */         else {
/* 142 */           pstmt.setString(1, get(i).getType());
/*     */         }
/* 144 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 145 */           pstmt.setString(2, null);
/*     */         else {
/* 147 */           pstmt.setString(2, get(i).getRiskCode());
/*     */         }
/* 149 */         if ((get(i).getParam() == null) || (get(i).getParam().equals("null")))
/* 150 */           pstmt.setString(3, null);
/*     */         else {
/* 152 */           pstmt.setString(3, get(i).getParam());
/*     */         }
/* 154 */         if ((get(i).getExpression() == null) || (get(i).getExpression().equals("null")))
/* 155 */           pstmt.setString(4, null);
/*     */         else {
/* 157 */           pstmt.setString(4, get(i).getExpression());
/*     */         }
/* 159 */         if ((get(i).getRemark() == null) || (get(i).getRemark().equals("null")))
/* 160 */           pstmt.setString(5, null);
/*     */         else {
/* 162 */           pstmt.setString(5, get(i).getRemark());
/*     */         }
/*     */ 
/* 165 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 166 */           pstmt.setString(6, null);
/*     */         else {
/* 168 */           pstmt.setString(6, get(i).getType());
/*     */         }
/* 170 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 171 */           pstmt.setString(7, null);
/*     */         else {
/* 173 */           pstmt.setString(7, get(i).getRiskCode());
/*     */         }
/* 175 */         if ((get(i).getParam() == null) || (get(i).getParam().equals("null")))
/* 176 */           pstmt.setString(8, null);
/*     */         else {
/* 178 */           pstmt.setString(8, get(i).getParam());
/*     */         }
/* 180 */         pstmt.addBatch();
/*     */       }
/* 182 */       pstmt.executeBatch();
/* 183 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 186 */       ex.printStackTrace();
/* 187 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 188 */       CError tError = new CError();
/* 189 */       tError.moduleName = "LNPRiskParamDBSet";
/* 190 */       tError.functionName = "update()";
/* 191 */       tError.errorMessage = ex.toString();
/* 192 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 195 */         pstmt.close(); } catch (Exception e) {
/* 196 */         e.printStackTrace();
/*     */       }
/* 198 */       if (!this.mflag) {
/*     */         try {
/* 200 */           this.con.close(); } catch (Exception e) {
/* 201 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 204 */       return false;
/*     */     }
/*     */ 
/* 207 */     if (!this.mflag) {
/*     */       try {
/* 209 */         this.con.close(); } catch (Exception e) {
/* 210 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 213 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 219 */     PreparedStatement pstmt = null;
/*     */ 
/* 221 */     if (!this.mflag) {
/* 222 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 227 */       int tCount = size();
/* 228 */       pstmt = this.con.prepareStatement("INSERT INTO LNPRiskParam VALUES( ? , ? , ? , ? , ?)");
/* 229 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 231 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 232 */           pstmt.setString(1, null);
/*     */         else {
/* 234 */           pstmt.setString(1, get(i).getType());
/*     */         }
/* 236 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 237 */           pstmt.setString(2, null);
/*     */         else {
/* 239 */           pstmt.setString(2, get(i).getRiskCode());
/*     */         }
/* 241 */         if ((get(i).getParam() == null) || (get(i).getParam().equals("null")))
/* 242 */           pstmt.setString(3, null);
/*     */         else {
/* 244 */           pstmt.setString(3, get(i).getParam());
/*     */         }
/* 246 */         if ((get(i).getExpression() == null) || (get(i).getExpression().equals("null")))
/* 247 */           pstmt.setString(4, null);
/*     */         else {
/* 249 */           pstmt.setString(4, get(i).getExpression());
/*     */         }
/* 251 */         if ((get(i).getRemark() == null) || (get(i).getRemark().equals("null")))
/* 252 */           pstmt.setString(5, null);
/*     */         else {
/* 254 */           pstmt.setString(5, get(i).getRemark());
/*     */         }
/* 256 */         pstmt.addBatch();
/*     */       }
/* 258 */       pstmt.executeBatch();
/* 259 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 262 */       ex.printStackTrace();
/* 263 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 264 */       CError tError = new CError();
/* 265 */       tError.moduleName = "LNPRiskParamDBSet";
/* 266 */       tError.functionName = "insert()";
/* 267 */       tError.errorMessage = ex.toString();
/* 268 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 271 */         pstmt.close(); } catch (Exception e) {
/* 272 */         e.printStackTrace();
/*     */       }
/* 274 */       if (!this.mflag) {
/*     */         try {
/* 276 */           this.con.close(); } catch (Exception e) {
/* 277 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 280 */       return false;
/*     */     }
/*     */ 
/* 283 */     if (!this.mflag) {
/*     */       try {
/* 285 */         this.con.close(); } catch (Exception e) {
/* 286 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 289 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPRiskParamDBSet
 * JD-Core Version:    0.6.0
 */