/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MCCSAcceptanceStateSchema;
/*     */ import com.sinosoft.map.lis.vschema.MCCSAcceptanceStateSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MCCSAcceptanceStateDBSet extends MCCSAcceptanceStateSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MCCSAcceptanceStateDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MCCSAcceptanceState");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MCCSAcceptanceStateDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MCCSAcceptanceState");
/*  35 */     this.con = this.db.getConnection();
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL()
/*     */   {
/*  40 */     if (this.db.deleteSQL(this))
/*     */     {
/*  42 */       return true;
/*     */     }
/*     */ 
/*  47 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*  48 */     CError tError = new CError();
/*  49 */     tError.moduleName = "MCCSAcceptanceStateDBSet";
/*  50 */     tError.functionName = "deleteSQL";
/*  51 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*  52 */     this.mErrors.addOneError(tError);
/*  53 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean delete()
/*     */   {
/*  60 */     PreparedStatement pstmt = null;
/*     */ 
/*  62 */     if (!this.mflag) {
/*  63 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  68 */       int tCount = size();
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MCCSAcceptanceState WHERE  ServiceNo = ? AND AgentCode = ?");
/*  70 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  72 */         if ((get(i).getServiceNo() == null) || (get(i).getServiceNo().equals("null")))
/*  73 */           pstmt.setString(1, null);
/*     */         else {
/*  75 */           pstmt.setString(1, get(i).getServiceNo());
/*     */         }
/*  77 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/*  78 */           pstmt.setString(2, null);
/*     */         else {
/*  80 */           pstmt.setString(2, get(i).getAgentCode());
/*     */         }
/*  82 */         pstmt.addBatch();
/*     */       }
/*  84 */       pstmt.executeBatch();
/*  85 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  88 */       ex.printStackTrace();
/*  89 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  90 */       CError tError = new CError();
/*  91 */       tError.moduleName = "MCCSAcceptanceStateDBSet";
/*  92 */       tError.functionName = "delete()";
/*  93 */       tError.errorMessage = ex.toString();
/*  94 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/*  97 */         pstmt.close(); } catch (Exception e) {
/*  98 */         e.printStackTrace();
/*     */       }
/* 100 */       if (!this.mflag) {
/*     */         try {
/* 102 */           this.con.close(); } catch (Exception e) {
/* 103 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 106 */       return false;
/*     */     }
/*     */ 
/* 109 */     if (!this.mflag) {
/*     */       try {
/* 111 */         this.con.close(); } catch (Exception e) {
/* 112 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 115 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 121 */     PreparedStatement pstmt = null;
/*     */ 
/* 123 */     if (!this.mflag) {
/* 124 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 129 */       int tCount = size();
/* 130 */       pstmt = this.con.prepareStatement("UPDATE MCCSAcceptanceState SET  ServiceNo = ? , AgentCode = ? , Status = ? , BY1 = ? , BY2 = ? , BY3 = ? WHERE  ServiceNo = ? AND AgentCode = ?");
/* 131 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 133 */         if ((get(i).getServiceNo() == null) || (get(i).getServiceNo().equals("null")))
/* 134 */           pstmt.setString(1, null);
/*     */         else {
/* 136 */           pstmt.setString(1, get(i).getServiceNo());
/*     */         }
/* 138 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/* 139 */           pstmt.setString(2, null);
/*     */         else {
/* 141 */           pstmt.setString(2, get(i).getAgentCode());
/*     */         }
/* 143 */         if ((get(i).getStatus() == null) || (get(i).getStatus().equals("null")))
/* 144 */           pstmt.setString(3, null);
/*     */         else {
/* 146 */           pstmt.setString(3, get(i).getStatus());
/*     */         }
/* 148 */         if ((get(i).getBY1() == null) || (get(i).getBY1().equals("null")))
/* 149 */           pstmt.setString(4, null);
/*     */         else {
/* 151 */           pstmt.setString(4, get(i).getBY1());
/*     */         }
/* 153 */         if ((get(i).getBY2() == null) || (get(i).getBY2().equals("null")))
/* 154 */           pstmt.setString(5, null);
/*     */         else {
/* 156 */           pstmt.setString(5, get(i).getBY2());
/*     */         }
/* 158 */         if ((get(i).getBY3() == null) || (get(i).getBY3().equals("null")))
/* 159 */           pstmt.setString(6, null);
/*     */         else {
/* 161 */           pstmt.setString(6, get(i).getBY3());
/*     */         }
/*     */ 
/* 164 */         if ((get(i).getServiceNo() == null) || (get(i).getServiceNo().equals("null")))
/* 165 */           pstmt.setString(7, null);
/*     */         else {
/* 167 */           pstmt.setString(7, get(i).getServiceNo());
/*     */         }
/* 169 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/* 170 */           pstmt.setString(8, null);
/*     */         else {
/* 172 */           pstmt.setString(8, get(i).getAgentCode());
/*     */         }
/* 174 */         pstmt.addBatch();
/*     */       }
/* 176 */       pstmt.executeBatch();
/* 177 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 180 */       ex.printStackTrace();
/* 181 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 182 */       CError tError = new CError();
/* 183 */       tError.moduleName = "MCCSAcceptanceStateDBSet";
/* 184 */       tError.functionName = "update()";
/* 185 */       tError.errorMessage = ex.toString();
/* 186 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 189 */         pstmt.close(); } catch (Exception e) {
/* 190 */         e.printStackTrace();
/*     */       }
/* 192 */       if (!this.mflag) {
/*     */         try {
/* 194 */           this.con.close(); } catch (Exception e) {
/* 195 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 198 */       return false;
/*     */     }
/*     */ 
/* 201 */     if (!this.mflag) {
/*     */       try {
/* 203 */         this.con.close(); } catch (Exception e) {
/* 204 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 207 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 213 */     PreparedStatement pstmt = null;
/*     */ 
/* 215 */     if (!this.mflag) {
/* 216 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 221 */       int tCount = size();
/* 222 */       pstmt = this.con.prepareStatement("INSERT INTO MCCSAcceptanceState VALUES( ? , ? , ? , ? , ? , ?)");
/* 223 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 225 */         if ((get(i).getServiceNo() == null) || (get(i).getServiceNo().equals("null")))
/* 226 */           pstmt.setString(1, null);
/*     */         else {
/* 228 */           pstmt.setString(1, get(i).getServiceNo());
/*     */         }
/* 230 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/* 231 */           pstmt.setString(2, null);
/*     */         else {
/* 233 */           pstmt.setString(2, get(i).getAgentCode());
/*     */         }
/* 235 */         if ((get(i).getStatus() == null) || (get(i).getStatus().equals("null")))
/* 236 */           pstmt.setString(3, null);
/*     */         else {
/* 238 */           pstmt.setString(3, get(i).getStatus());
/*     */         }
/* 240 */         if ((get(i).getBY1() == null) || (get(i).getBY1().equals("null")))
/* 241 */           pstmt.setString(4, null);
/*     */         else {
/* 243 */           pstmt.setString(4, get(i).getBY1());
/*     */         }
/* 245 */         if ((get(i).getBY2() == null) || (get(i).getBY2().equals("null")))
/* 246 */           pstmt.setString(5, null);
/*     */         else {
/* 248 */           pstmt.setString(5, get(i).getBY2());
/*     */         }
/* 250 */         if ((get(i).getBY3() == null) || (get(i).getBY3().equals("null")))
/* 251 */           pstmt.setString(6, null);
/*     */         else {
/* 253 */           pstmt.setString(6, get(i).getBY3());
/*     */         }
/* 255 */         pstmt.addBatch();
/*     */       }
/* 257 */       pstmt.executeBatch();
/* 258 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 261 */       ex.printStackTrace();
/* 262 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 263 */       CError tError = new CError();
/* 264 */       tError.moduleName = "MCCSAcceptanceStateDBSet";
/* 265 */       tError.functionName = "insert()";
/* 266 */       tError.errorMessage = ex.toString();
/* 267 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 270 */         pstmt.close(); } catch (Exception e) {
/* 271 */         e.printStackTrace();
/*     */       }
/* 273 */       if (!this.mflag) {
/*     */         try {
/* 275 */           this.con.close(); } catch (Exception e) {
/* 276 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 279 */       return false;
/*     */     }
/*     */ 
/* 282 */     if (!this.mflag) {
/*     */       try {
/* 284 */         this.con.close(); } catch (Exception e) {
/* 285 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 288 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MCCSAcceptanceStateDBSet
 * JD-Core Version:    0.6.0
 */