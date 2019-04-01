/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPRiskRelaSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPRiskRelaSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPRiskRelaDBSet extends LNPRiskRelaSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPRiskRelaDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPRiskRela");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPRiskRelaDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPRiskRela");
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
/*  50 */     tError.moduleName = "LNPRiskRelaDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPRiskRela WHERE  RiskCode = ? AND RelaRiskCode = ? AND RelaCode = ? AND ManageComGrp = ? AND SaleChnl = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getRiskCode());
/*     */         }
/*  78 */         if ((get(i).getRelaRiskCode() == null) || (get(i).getRelaRiskCode().equals("null")))
/*  79 */           pstmt.setString(2, null);
/*     */         else {
/*  81 */           pstmt.setString(2, get(i).getRelaRiskCode());
/*     */         }
/*  83 */         if ((get(i).getRelaCode() == null) || (get(i).getRelaCode().equals("null")))
/*  84 */           pstmt.setString(3, null);
/*     */         else {
/*  86 */           pstmt.setString(3, get(i).getRelaCode());
/*     */         }
/*  88 */         if ((get(i).getManageComGrp() == null) || (get(i).getManageComGrp().equals("null")))
/*  89 */           pstmt.setString(4, null);
/*     */         else {
/*  91 */           pstmt.setString(4, get(i).getManageComGrp());
/*     */         }
/*  93 */         if ((get(i).getSaleChnl() == null) || (get(i).getSaleChnl().equals("null")))
/*  94 */           pstmt.setString(5, null);
/*     */         else {
/*  96 */           pstmt.setString(5, get(i).getSaleChnl());
/*     */         }
/*  98 */         pstmt.addBatch();
/*     */       }
/* 100 */       pstmt.executeBatch();
/* 101 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 104 */       ex.printStackTrace();
/* 105 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 106 */       CError tError = new CError();
/* 107 */       tError.moduleName = "LNPRiskRelaDBSet";
/* 108 */       tError.functionName = "delete()";
/* 109 */       tError.errorMessage = ex.toString();
/* 110 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 113 */         pstmt.close(); } catch (Exception e) {
/* 114 */         e.printStackTrace();
/*     */       }
/* 116 */       if (!this.mflag) {
/*     */         try {
/* 118 */           this.con.close(); } catch (Exception e) {
/* 119 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 122 */       return false;
/*     */     }
/*     */ 
/* 125 */     if (!this.mflag) {
/*     */       try {
/* 127 */         this.con.close(); } catch (Exception e) {
/* 128 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 131 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 137 */     PreparedStatement pstmt = null;
/*     */ 
/* 139 */     if (!this.mflag) {
/* 140 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 145 */       int tCount = size();
/* 146 */       pstmt = this.con.prepareStatement("UPDATE LNPRiskRela SET  RiskCode = ? , RelaRiskCode = ? , RelaCode = ? , ManageComGrp = ? , SaleChnl = ? , MinAppntAge = ? , MaxAppntAge = ? , MaxInsuredAge = ? , MinInsuredAge = ? WHERE  RiskCode = ? AND RelaRiskCode = ? AND RelaCode = ? AND ManageComGrp = ? AND SaleChnl = ?");
/* 147 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 149 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 150 */           pstmt.setString(1, null);
/*     */         else {
/* 152 */           pstmt.setString(1, get(i).getRiskCode());
/*     */         }
/* 154 */         if ((get(i).getRelaRiskCode() == null) || (get(i).getRelaRiskCode().equals("null")))
/* 155 */           pstmt.setString(2, null);
/*     */         else {
/* 157 */           pstmt.setString(2, get(i).getRelaRiskCode());
/*     */         }
/* 159 */         if ((get(i).getRelaCode() == null) || (get(i).getRelaCode().equals("null")))
/* 160 */           pstmt.setString(3, null);
/*     */         else {
/* 162 */           pstmt.setString(3, get(i).getRelaCode());
/*     */         }
/* 164 */         if ((get(i).getManageComGrp() == null) || (get(i).getManageComGrp().equals("null")))
/* 165 */           pstmt.setString(4, null);
/*     */         else {
/* 167 */           pstmt.setString(4, get(i).getManageComGrp());
/*     */         }
/* 169 */         if ((get(i).getSaleChnl() == null) || (get(i).getSaleChnl().equals("null")))
/* 170 */           pstmt.setString(5, null);
/*     */         else {
/* 172 */           pstmt.setString(5, get(i).getSaleChnl());
/*     */         }
/* 174 */         pstmt.setInt(6, get(i).getMinAppntAge());
/* 175 */         pstmt.setInt(7, get(i).getMaxAppntAge());
/* 176 */         pstmt.setInt(8, get(i).getMaxInsuredAge());
/* 177 */         pstmt.setInt(9, get(i).getMinInsuredAge());
/*     */ 
/* 179 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 180 */           pstmt.setString(10, null);
/*     */         else {
/* 182 */           pstmt.setString(10, get(i).getRiskCode());
/*     */         }
/* 184 */         if ((get(i).getRelaRiskCode() == null) || (get(i).getRelaRiskCode().equals("null")))
/* 185 */           pstmt.setString(11, null);
/*     */         else {
/* 187 */           pstmt.setString(11, get(i).getRelaRiskCode());
/*     */         }
/* 189 */         if ((get(i).getRelaCode() == null) || (get(i).getRelaCode().equals("null")))
/* 190 */           pstmt.setString(12, null);
/*     */         else {
/* 192 */           pstmt.setString(12, get(i).getRelaCode());
/*     */         }
/* 194 */         if ((get(i).getManageComGrp() == null) || (get(i).getManageComGrp().equals("null")))
/* 195 */           pstmt.setString(13, null);
/*     */         else {
/* 197 */           pstmt.setString(13, get(i).getManageComGrp());
/*     */         }
/* 199 */         if ((get(i).getSaleChnl() == null) || (get(i).getSaleChnl().equals("null")))
/* 200 */           pstmt.setString(14, null);
/*     */         else {
/* 202 */           pstmt.setString(14, get(i).getSaleChnl());
/*     */         }
/* 204 */         pstmt.addBatch();
/*     */       }
/* 206 */       pstmt.executeBatch();
/* 207 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 210 */       ex.printStackTrace();
/* 211 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 212 */       CError tError = new CError();
/* 213 */       tError.moduleName = "LNPRiskRelaDBSet";
/* 214 */       tError.functionName = "update()";
/* 215 */       tError.errorMessage = ex.toString();
/* 216 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 219 */         pstmt.close(); } catch (Exception e) {
/* 220 */         e.printStackTrace();
/*     */       }
/* 222 */       if (!this.mflag) {
/*     */         try {
/* 224 */           this.con.close(); } catch (Exception e) {
/* 225 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 228 */       return false;
/*     */     }
/*     */ 
/* 231 */     if (!this.mflag) {
/*     */       try {
/* 233 */         this.con.close(); } catch (Exception e) {
/* 234 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 237 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 243 */     PreparedStatement pstmt = null;
/*     */ 
/* 245 */     if (!this.mflag) {
/* 246 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 251 */       int tCount = size();
/* 252 */       pstmt = this.con.prepareStatement("INSERT INTO LNPRiskRela VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 253 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 255 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 256 */           pstmt.setString(1, null);
/*     */         else {
/* 258 */           pstmt.setString(1, get(i).getRiskCode());
/*     */         }
/* 260 */         if ((get(i).getRelaRiskCode() == null) || (get(i).getRelaRiskCode().equals("null")))
/* 261 */           pstmt.setString(2, null);
/*     */         else {
/* 263 */           pstmt.setString(2, get(i).getRelaRiskCode());
/*     */         }
/* 265 */         if ((get(i).getRelaCode() == null) || (get(i).getRelaCode().equals("null")))
/* 266 */           pstmt.setString(3, null);
/*     */         else {
/* 268 */           pstmt.setString(3, get(i).getRelaCode());
/*     */         }
/* 270 */         if ((get(i).getManageComGrp() == null) || (get(i).getManageComGrp().equals("null")))
/* 271 */           pstmt.setString(4, null);
/*     */         else {
/* 273 */           pstmt.setString(4, get(i).getManageComGrp());
/*     */         }
/* 275 */         if ((get(i).getSaleChnl() == null) || (get(i).getSaleChnl().equals("null")))
/* 276 */           pstmt.setString(5, null);
/*     */         else {
/* 278 */           pstmt.setString(5, get(i).getSaleChnl());
/*     */         }
/* 280 */         pstmt.setInt(6, get(i).getMinAppntAge());
/* 281 */         pstmt.setInt(7, get(i).getMaxAppntAge());
/* 282 */         pstmt.setInt(8, get(i).getMaxInsuredAge());
/* 283 */         pstmt.setInt(9, get(i).getMinInsuredAge());
/* 284 */         pstmt.addBatch();
/*     */       }
/* 286 */       pstmt.executeBatch();
/* 287 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 290 */       ex.printStackTrace();
/* 291 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 292 */       CError tError = new CError();
/* 293 */       tError.moduleName = "LNPRiskRelaDBSet";
/* 294 */       tError.functionName = "insert()";
/* 295 */       tError.errorMessage = ex.toString();
/* 296 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 299 */         pstmt.close(); } catch (Exception e) {
/* 300 */         e.printStackTrace();
/*     */       }
/* 302 */       if (!this.mflag) {
/*     */         try {
/* 304 */           this.con.close(); } catch (Exception e) {
/* 305 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 308 */       return false;
/*     */     }
/*     */ 
/* 311 */     if (!this.mflag) {
/*     */       try {
/* 313 */         this.con.close(); } catch (Exception e) {
/* 314 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 317 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPRiskRelaDBSet
 * JD-Core Version:    0.6.0
 */