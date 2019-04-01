/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPRiskRoleSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPRiskRoleSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPRiskRoleDBSet extends LNPRiskRoleSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPRiskRoleDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPRiskRole");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPRiskRoleDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPRiskRole");
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
/*  50 */     tError.moduleName = "LNPRiskRoleDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPRiskRole WHERE  RiskCode = ? AND RiskRole = ? AND RiskRoleSex = ? AND RiskRoleNo = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getRiskCode());
/*     */         }
/*  78 */         if ((get(i).getRiskRole() == null) || (get(i).getRiskRole().equals("null")))
/*  79 */           pstmt.setString(2, null);
/*     */         else {
/*  81 */           pstmt.setString(2, get(i).getRiskRole());
/*     */         }
/*  83 */         if ((get(i).getRiskRoleSex() == null) || (get(i).getRiskRoleSex().equals("null")))
/*  84 */           pstmt.setString(3, null);
/*     */         else {
/*  86 */           pstmt.setString(3, get(i).getRiskRoleSex());
/*     */         }
/*  88 */         if ((get(i).getRiskRoleNo() == null) || (get(i).getRiskRoleNo().equals("null")))
/*  89 */           pstmt.setString(4, null);
/*     */         else {
/*  91 */           pstmt.setString(4, get(i).getRiskRoleNo());
/*     */         }
/*  93 */         pstmt.addBatch();
/*     */       }
/*  95 */       pstmt.executeBatch();
/*  96 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  99 */       ex.printStackTrace();
/* 100 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 101 */       CError tError = new CError();
/* 102 */       tError.moduleName = "LNPRiskRoleDBSet";
/* 103 */       tError.functionName = "delete()";
/* 104 */       tError.errorMessage = ex.toString();
/* 105 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 108 */         pstmt.close(); } catch (Exception e) {
/* 109 */         e.printStackTrace();
/*     */       }
/* 111 */       if (!this.mflag) {
/*     */         try {
/* 113 */           this.con.close(); } catch (Exception e) {
/* 114 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 117 */       return false;
/*     */     }
/*     */ 
/* 120 */     if (!this.mflag) {
/*     */       try {
/* 122 */         this.con.close(); } catch (Exception e) {
/* 123 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 126 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 132 */     PreparedStatement pstmt = null;
/*     */ 
/* 134 */     if (!this.mflag) {
/* 135 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 140 */       int tCount = size();
/* 141 */       pstmt = this.con.prepareStatement("UPDATE LNPRiskRole SET  RiskCode = ? , RiskVer = ? , RiskRole = ? , RiskRoleSex = ? , RiskRoleNo = ? , MinAppAgeFlag = ? , MinAppAge = ? , MAXAppAgeFlag = ? , MAXAppAge = ? WHERE  RiskCode = ? AND RiskRole = ? AND RiskRoleSex = ? AND RiskRoleNo = ?");
/* 142 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 144 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 145 */           pstmt.setString(1, null);
/*     */         else {
/* 147 */           pstmt.setString(1, get(i).getRiskCode());
/*     */         }
/* 149 */         if ((get(i).getRiskVer() == null) || (get(i).getRiskVer().equals("null")))
/* 150 */           pstmt.setString(2, null);
/*     */         else {
/* 152 */           pstmt.setString(2, get(i).getRiskVer());
/*     */         }
/* 154 */         if ((get(i).getRiskRole() == null) || (get(i).getRiskRole().equals("null")))
/* 155 */           pstmt.setString(3, null);
/*     */         else {
/* 157 */           pstmt.setString(3, get(i).getRiskRole());
/*     */         }
/* 159 */         if ((get(i).getRiskRoleSex() == null) || (get(i).getRiskRoleSex().equals("null")))
/* 160 */           pstmt.setString(4, null);
/*     */         else {
/* 162 */           pstmt.setString(4, get(i).getRiskRoleSex());
/*     */         }
/* 164 */         if ((get(i).getRiskRoleNo() == null) || (get(i).getRiskRoleNo().equals("null")))
/* 165 */           pstmt.setString(5, null);
/*     */         else {
/* 167 */           pstmt.setString(5, get(i).getRiskRoleNo());
/*     */         }
/* 169 */         if ((get(i).getMinAppAgeFlag() == null) || (get(i).getMinAppAgeFlag().equals("null")))
/* 170 */           pstmt.setString(6, null);
/*     */         else {
/* 172 */           pstmt.setString(6, get(i).getMinAppAgeFlag());
/*     */         }
/* 174 */         pstmt.setInt(7, get(i).getMinAppAge());
/* 175 */         if ((get(i).getMAXAppAgeFlag() == null) || (get(i).getMAXAppAgeFlag().equals("null")))
/* 176 */           pstmt.setString(8, null);
/*     */         else {
/* 178 */           pstmt.setString(8, get(i).getMAXAppAgeFlag());
/*     */         }
/* 180 */         pstmt.setInt(9, get(i).getMAXAppAge());
/*     */ 
/* 182 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 183 */           pstmt.setString(10, null);
/*     */         else {
/* 185 */           pstmt.setString(10, get(i).getRiskCode());
/*     */         }
/* 187 */         if ((get(i).getRiskRole() == null) || (get(i).getRiskRole().equals("null")))
/* 188 */           pstmt.setString(11, null);
/*     */         else {
/* 190 */           pstmt.setString(11, get(i).getRiskRole());
/*     */         }
/* 192 */         if ((get(i).getRiskRoleSex() == null) || (get(i).getRiskRoleSex().equals("null")))
/* 193 */           pstmt.setString(12, null);
/*     */         else {
/* 195 */           pstmt.setString(12, get(i).getRiskRoleSex());
/*     */         }
/* 197 */         if ((get(i).getRiskRoleNo() == null) || (get(i).getRiskRoleNo().equals("null")))
/* 198 */           pstmt.setString(13, null);
/*     */         else {
/* 200 */           pstmt.setString(13, get(i).getRiskRoleNo());
/*     */         }
/* 202 */         pstmt.addBatch();
/*     */       }
/* 204 */       pstmt.executeBatch();
/* 205 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 208 */       ex.printStackTrace();
/* 209 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 210 */       CError tError = new CError();
/* 211 */       tError.moduleName = "LNPRiskRoleDBSet";
/* 212 */       tError.functionName = "update()";
/* 213 */       tError.errorMessage = ex.toString();
/* 214 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 217 */         pstmt.close(); } catch (Exception e) {
/* 218 */         e.printStackTrace();
/*     */       }
/* 220 */       if (!this.mflag) {
/*     */         try {
/* 222 */           this.con.close(); } catch (Exception e) {
/* 223 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 226 */       return false;
/*     */     }
/*     */ 
/* 229 */     if (!this.mflag) {
/*     */       try {
/* 231 */         this.con.close(); } catch (Exception e) {
/* 232 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 235 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 241 */     PreparedStatement pstmt = null;
/*     */ 
/* 243 */     if (!this.mflag) {
/* 244 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 249 */       int tCount = size();
/* 250 */       pstmt = this.con.prepareStatement("INSERT INTO LNPRiskRole VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 251 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 253 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 254 */           pstmt.setString(1, null);
/*     */         else {
/* 256 */           pstmt.setString(1, get(i).getRiskCode());
/*     */         }
/* 258 */         if ((get(i).getRiskVer() == null) || (get(i).getRiskVer().equals("null")))
/* 259 */           pstmt.setString(2, null);
/*     */         else {
/* 261 */           pstmt.setString(2, get(i).getRiskVer());
/*     */         }
/* 263 */         if ((get(i).getRiskRole() == null) || (get(i).getRiskRole().equals("null")))
/* 264 */           pstmt.setString(3, null);
/*     */         else {
/* 266 */           pstmt.setString(3, get(i).getRiskRole());
/*     */         }
/* 268 */         if ((get(i).getRiskRoleSex() == null) || (get(i).getRiskRoleSex().equals("null")))
/* 269 */           pstmt.setString(4, null);
/*     */         else {
/* 271 */           pstmt.setString(4, get(i).getRiskRoleSex());
/*     */         }
/* 273 */         if ((get(i).getRiskRoleNo() == null) || (get(i).getRiskRoleNo().equals("null")))
/* 274 */           pstmt.setString(5, null);
/*     */         else {
/* 276 */           pstmt.setString(5, get(i).getRiskRoleNo());
/*     */         }
/* 278 */         if ((get(i).getMinAppAgeFlag() == null) || (get(i).getMinAppAgeFlag().equals("null")))
/* 279 */           pstmt.setString(6, null);
/*     */         else {
/* 281 */           pstmt.setString(6, get(i).getMinAppAgeFlag());
/*     */         }
/* 283 */         pstmt.setInt(7, get(i).getMinAppAge());
/* 284 */         if ((get(i).getMAXAppAgeFlag() == null) || (get(i).getMAXAppAgeFlag().equals("null")))
/* 285 */           pstmt.setString(8, null);
/*     */         else {
/* 287 */           pstmt.setString(8, get(i).getMAXAppAgeFlag());
/*     */         }
/* 289 */         pstmt.setInt(9, get(i).getMAXAppAge());
/* 290 */         pstmt.addBatch();
/*     */       }
/* 292 */       pstmt.executeBatch();
/* 293 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 296 */       ex.printStackTrace();
/* 297 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 298 */       CError tError = new CError();
/* 299 */       tError.moduleName = "LNPRiskRoleDBSet";
/* 300 */       tError.functionName = "insert()";
/* 301 */       tError.errorMessage = ex.toString();
/* 302 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 305 */         pstmt.close(); } catch (Exception e) {
/* 306 */         e.printStackTrace();
/*     */       }
/* 308 */       if (!this.mflag) {
/*     */         try {
/* 310 */           this.con.close(); } catch (Exception e) {
/* 311 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 314 */       return false;
/*     */     }
/*     */ 
/* 317 */     if (!this.mflag) {
/*     */       try {
/* 319 */         this.con.close(); } catch (Exception e) {
/* 320 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 323 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPRiskRoleDBSet
 * JD-Core Version:    0.6.0
 */