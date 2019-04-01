/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPRiskSaleGroupToRiskSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPRiskSaleGroupToRiskSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPRiskSaleGroupToRiskDBSet extends LNPRiskSaleGroupToRiskSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPRiskSaleGroupToRiskDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPRiskSaleGroupToRisk");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPRiskSaleGroupToRiskDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPRiskSaleGroupToRisk");
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
/*  50 */     tError.moduleName = "LNPRiskSaleGroupToRiskDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPRiskSaleGroupToRisk WHERE  GroupCode = ? AND RiskCode = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getGroupCode() == null) || (get(i).getGroupCode().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getGroupCode());
/*     */         }
/*  78 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/*  79 */           pstmt.setString(2, null);
/*     */         else {
/*  81 */           pstmt.setString(2, get(i).getRiskCode());
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
/*  92 */       tError.moduleName = "LNPRiskSaleGroupToRiskDBSet";
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
/* 131 */       pstmt = this.con.prepareStatement("UPDATE LNPRiskSaleGroupToRisk SET  GroupCode = ? , RiskCode = ? WHERE  GroupCode = ? AND RiskCode = ?");
/* 132 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 134 */         if ((get(i).getGroupCode() == null) || (get(i).getGroupCode().equals("null")))
/* 135 */           pstmt.setString(1, null);
/*     */         else {
/* 137 */           pstmt.setString(1, get(i).getGroupCode());
/*     */         }
/* 139 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 140 */           pstmt.setString(2, null);
/*     */         else {
/* 142 */           pstmt.setString(2, get(i).getRiskCode());
/*     */         }
/*     */ 
/* 145 */         if ((get(i).getGroupCode() == null) || (get(i).getGroupCode().equals("null")))
/* 146 */           pstmt.setString(3, null);
/*     */         else {
/* 148 */           pstmt.setString(3, get(i).getGroupCode());
/*     */         }
/* 150 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 151 */           pstmt.setString(4, null);
/*     */         else {
/* 153 */           pstmt.setString(4, get(i).getRiskCode());
/*     */         }
/* 155 */         pstmt.addBatch();
/*     */       }
/* 157 */       pstmt.executeBatch();
/* 158 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 161 */       ex.printStackTrace();
/* 162 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 163 */       CError tError = new CError();
/* 164 */       tError.moduleName = "LNPRiskSaleGroupToRiskDBSet";
/* 165 */       tError.functionName = "update()";
/* 166 */       tError.errorMessage = ex.toString();
/* 167 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 170 */         pstmt.close(); } catch (Exception e) {
/* 171 */         e.printStackTrace();
/*     */       }
/* 173 */       if (!this.mflag) {
/*     */         try {
/* 175 */           this.con.close(); } catch (Exception e) {
/* 176 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 179 */       return false;
/*     */     }
/*     */ 
/* 182 */     if (!this.mflag) {
/*     */       try {
/* 184 */         this.con.close(); } catch (Exception e) {
/* 185 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 188 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 194 */     PreparedStatement pstmt = null;
/*     */ 
/* 196 */     if (!this.mflag) {
/* 197 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 202 */       int tCount = size();
/* 203 */       pstmt = this.con.prepareStatement("INSERT INTO LNPRiskSaleGroupToRisk VALUES( ? , ?)");
/* 204 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 206 */         if ((get(i).getGroupCode() == null) || (get(i).getGroupCode().equals("null")))
/* 207 */           pstmt.setString(1, null);
/*     */         else {
/* 209 */           pstmt.setString(1, get(i).getGroupCode());
/*     */         }
/* 211 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 212 */           pstmt.setString(2, null);
/*     */         else {
/* 214 */           pstmt.setString(2, get(i).getRiskCode());
/*     */         }
/* 216 */         pstmt.addBatch();
/*     */       }
/* 218 */       pstmt.executeBatch();
/* 219 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 222 */       ex.printStackTrace();
/* 223 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 224 */       CError tError = new CError();
/* 225 */       tError.moduleName = "LNPRiskSaleGroupToRiskDBSet";
/* 226 */       tError.functionName = "insert()";
/* 227 */       tError.errorMessage = ex.toString();
/* 228 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 231 */         pstmt.close(); } catch (Exception e) {
/* 232 */         e.printStackTrace();
/*     */       }
/* 234 */       if (!this.mflag) {
/*     */         try {
/* 236 */           this.con.close(); } catch (Exception e) {
/* 237 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 240 */       return false;
/*     */     }
/*     */ 
/* 243 */     if (!this.mflag) {
/*     */       try {
/* 245 */         this.con.close(); } catch (Exception e) {
/* 246 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 249 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPRiskSaleGroupToRiskDBSet
 * JD-Core Version:    0.6.0
 */