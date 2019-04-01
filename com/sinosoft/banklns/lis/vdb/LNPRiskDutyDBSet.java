/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPRiskDutySchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPRiskDutySet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPRiskDutyDBSet extends LNPRiskDutySet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPRiskDutyDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPRiskDuty");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPRiskDutyDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPRiskDuty");
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
/*  50 */     tError.moduleName = "LNPRiskDutyDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPRiskDuty WHERE  RiskCode = ? AND DutyCode = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getRiskCode());
/*     */         }
/*  78 */         if ((get(i).getDutyCode() == null) || (get(i).getDutyCode().equals("null")))
/*  79 */           pstmt.setString(2, null);
/*     */         else {
/*  81 */           pstmt.setString(2, get(i).getDutyCode());
/*     */         }
/*  83 */         pstmt.addBatch();
/*     */       }
/*  85 */       pstmt.executeBatch();
/*  86 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  89 */       ex.printStackTrace();
/*  90 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  91 */       CError tError = new CError();
/*  92 */       tError.moduleName = "LNPRiskDutyDBSet";
/*  93 */       tError.functionName = "delete()";
/*  94 */       tError.errorMessage = ex.toString();
/*  95 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/*  98 */         pstmt.close(); } catch (Exception e) {
/*  99 */         e.printStackTrace();
/*     */       }
/* 101 */       if (!this.mflag) {
/*     */         try {
/* 103 */           this.con.close(); } catch (Exception e) {
/* 104 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 107 */       return false;
/*     */     }
/*     */ 
/* 110 */     if (!this.mflag) {
/*     */       try {
/* 112 */         this.con.close(); } catch (Exception e) {
/* 113 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 116 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 122 */     PreparedStatement pstmt = null;
/*     */ 
/* 124 */     if (!this.mflag) {
/* 125 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 130 */       int tCount = size();
/* 131 */       pstmt = this.con.prepareStatement("UPDATE LNPRiskDuty SET  RiskCode = ? , RiskVer = ? , DutyCode = ? , ChoFlag = ? , SpecFlag = ? WHERE  RiskCode = ? AND DutyCode = ?");
/* 132 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 134 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 135 */           pstmt.setString(1, null);
/*     */         else {
/* 137 */           pstmt.setString(1, get(i).getRiskCode());
/*     */         }
/* 139 */         if ((get(i).getRiskVer() == null) || (get(i).getRiskVer().equals("null")))
/* 140 */           pstmt.setString(2, null);
/*     */         else {
/* 142 */           pstmt.setString(2, get(i).getRiskVer());
/*     */         }
/* 144 */         if ((get(i).getDutyCode() == null) || (get(i).getDutyCode().equals("null")))
/* 145 */           pstmt.setString(3, null);
/*     */         else {
/* 147 */           pstmt.setString(3, get(i).getDutyCode());
/*     */         }
/* 149 */         if ((get(i).getChoFlag() == null) || (get(i).getChoFlag().equals("null")))
/* 150 */           pstmt.setString(4, null);
/*     */         else {
/* 152 */           pstmt.setString(4, get(i).getChoFlag());
/*     */         }
/* 154 */         if ((get(i).getSpecFlag() == null) || (get(i).getSpecFlag().equals("null")))
/* 155 */           pstmt.setString(5, null);
/*     */         else {
/* 157 */           pstmt.setString(5, get(i).getSpecFlag());
/*     */         }
/*     */ 
/* 160 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 161 */           pstmt.setString(6, null);
/*     */         else {
/* 163 */           pstmt.setString(6, get(i).getRiskCode());
/*     */         }
/* 165 */         if ((get(i).getDutyCode() == null) || (get(i).getDutyCode().equals("null")))
/* 166 */           pstmt.setString(7, null);
/*     */         else {
/* 168 */           pstmt.setString(7, get(i).getDutyCode());
/*     */         }
/* 170 */         pstmt.addBatch();
/*     */       }
/* 172 */       pstmt.executeBatch();
/* 173 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 176 */       ex.printStackTrace();
/* 177 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 178 */       CError tError = new CError();
/* 179 */       tError.moduleName = "LNPRiskDutyDBSet";
/* 180 */       tError.functionName = "update()";
/* 181 */       tError.errorMessage = ex.toString();
/* 182 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 185 */         pstmt.close(); } catch (Exception e) {
/* 186 */         e.printStackTrace();
/*     */       }
/* 188 */       if (!this.mflag) {
/*     */         try {
/* 190 */           this.con.close(); } catch (Exception e) {
/* 191 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 194 */       return false;
/*     */     }
/*     */ 
/* 197 */     if (!this.mflag) {
/*     */       try {
/* 199 */         this.con.close(); } catch (Exception e) {
/* 200 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 203 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 209 */     PreparedStatement pstmt = null;
/*     */ 
/* 211 */     if (!this.mflag) {
/* 212 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 217 */       int tCount = size();
/* 218 */       pstmt = this.con.prepareStatement("INSERT INTO LNPRiskDuty VALUES( ? , ? , ? , ? , ?)");
/* 219 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 221 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 222 */           pstmt.setString(1, null);
/*     */         else {
/* 224 */           pstmt.setString(1, get(i).getRiskCode());
/*     */         }
/* 226 */         if ((get(i).getRiskVer() == null) || (get(i).getRiskVer().equals("null")))
/* 227 */           pstmt.setString(2, null);
/*     */         else {
/* 229 */           pstmt.setString(2, get(i).getRiskVer());
/*     */         }
/* 231 */         if ((get(i).getDutyCode() == null) || (get(i).getDutyCode().equals("null")))
/* 232 */           pstmt.setString(3, null);
/*     */         else {
/* 234 */           pstmt.setString(3, get(i).getDutyCode());
/*     */         }
/* 236 */         if ((get(i).getChoFlag() == null) || (get(i).getChoFlag().equals("null")))
/* 237 */           pstmt.setString(4, null);
/*     */         else {
/* 239 */           pstmt.setString(4, get(i).getChoFlag());
/*     */         }
/* 241 */         if ((get(i).getSpecFlag() == null) || (get(i).getSpecFlag().equals("null")))
/* 242 */           pstmt.setString(5, null);
/*     */         else {
/* 244 */           pstmt.setString(5, get(i).getSpecFlag());
/*     */         }
/* 246 */         pstmt.addBatch();
/*     */       }
/* 248 */       pstmt.executeBatch();
/* 249 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 252 */       ex.printStackTrace();
/* 253 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 254 */       CError tError = new CError();
/* 255 */       tError.moduleName = "LNPRiskDutyDBSet";
/* 256 */       tError.functionName = "insert()";
/* 257 */       tError.errorMessage = ex.toString();
/* 258 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 261 */         pstmt.close(); } catch (Exception e) {
/* 262 */         e.printStackTrace();
/*     */       }
/* 264 */       if (!this.mflag) {
/*     */         try {
/* 266 */           this.con.close(); } catch (Exception e) {
/* 267 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 270 */       return false;
/*     */     }
/*     */ 
/* 273 */     if (!this.mflag) {
/*     */       try {
/* 275 */         this.con.close(); } catch (Exception e) {
/* 276 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 279 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPRiskDutyDBSet
 * JD-Core Version:    0.6.0
 */