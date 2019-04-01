/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPRiskComCtrlSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPRiskComCtrlSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPRiskComCtrlDBSet extends LNPRiskComCtrlSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPRiskComCtrlDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPRiskComCtrl");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPRiskComCtrlDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPRiskComCtrl");
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
/*  50 */     tError.moduleName = "LNPRiskComCtrlDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPRiskComCtrl WHERE  RiskCode = ? AND ManageComGrp = ? AND SaleChnl = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getRiskCode());
/*     */         }
/*  78 */         if ((get(i).getManageComGrp() == null) || (get(i).getManageComGrp().equals("null")))
/*  79 */           pstmt.setString(2, null);
/*     */         else {
/*  81 */           pstmt.setString(2, get(i).getManageComGrp());
/*     */         }
/*  83 */         if ((get(i).getSaleChnl() == null) || (get(i).getSaleChnl().equals("null")))
/*  84 */           pstmt.setString(3, null);
/*     */         else {
/*  86 */           pstmt.setString(3, get(i).getSaleChnl());
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
/*  97 */       tError.moduleName = "LNPRiskComCtrlDBSet";
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
/* 136 */       pstmt = this.con.prepareStatement("UPDATE LNPRiskComCtrl SET  RiskCode = ? , ManageComGrp = ? , SaleChnl = ? , StartDate = ? , EndDate = ? , MAXAmnt = ? , MAXMult = ? , MAXPrem = ? , MINAmnt = ? , MINMult = ? , MINPrem = ? WHERE  RiskCode = ? AND ManageComGrp = ? AND SaleChnl = ?");
/* 137 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 139 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 140 */           pstmt.setString(1, null);
/*     */         else {
/* 142 */           pstmt.setString(1, get(i).getRiskCode());
/*     */         }
/* 144 */         if ((get(i).getManageComGrp() == null) || (get(i).getManageComGrp().equals("null")))
/* 145 */           pstmt.setString(2, null);
/*     */         else {
/* 147 */           pstmt.setString(2, get(i).getManageComGrp());
/*     */         }
/* 149 */         if ((get(i).getSaleChnl() == null) || (get(i).getSaleChnl().equals("null")))
/* 150 */           pstmt.setString(3, null);
/*     */         else {
/* 152 */           pstmt.setString(3, get(i).getSaleChnl());
/*     */         }
/* 154 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 155 */           pstmt.setDate(4, null);
/*     */         else {
/* 157 */           pstmt.setDate(4, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 159 */         if ((get(i).getEndDate() == null) || (get(i).getEndDate().equals("null")))
/* 160 */           pstmt.setDate(5, null);
/*     */         else {
/* 162 */           pstmt.setDate(5, Date.valueOf(get(i).getEndDate()));
/*     */         }
/* 164 */         pstmt.setDouble(6, get(i).getMAXAmnt());
/* 165 */         pstmt.setDouble(7, get(i).getMAXMult());
/* 166 */         pstmt.setDouble(8, get(i).getMAXPrem());
/* 167 */         pstmt.setDouble(9, get(i).getMINAmnt());
/* 168 */         pstmt.setDouble(10, get(i).getMINMult());
/* 169 */         pstmt.setDouble(11, get(i).getMINPrem());
/*     */ 
/* 171 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 172 */           pstmt.setString(12, null);
/*     */         else {
/* 174 */           pstmt.setString(12, get(i).getRiskCode());
/*     */         }
/* 176 */         if ((get(i).getManageComGrp() == null) || (get(i).getManageComGrp().equals("null")))
/* 177 */           pstmt.setString(13, null);
/*     */         else {
/* 179 */           pstmt.setString(13, get(i).getManageComGrp());
/*     */         }
/* 181 */         if ((get(i).getSaleChnl() == null) || (get(i).getSaleChnl().equals("null")))
/* 182 */           pstmt.setString(14, null);
/*     */         else {
/* 184 */           pstmt.setString(14, get(i).getSaleChnl());
/*     */         }
/* 186 */         pstmt.addBatch();
/*     */       }
/* 188 */       pstmt.executeBatch();
/* 189 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 192 */       ex.printStackTrace();
/* 193 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 194 */       CError tError = new CError();
/* 195 */       tError.moduleName = "LNPRiskComCtrlDBSet";
/* 196 */       tError.functionName = "update()";
/* 197 */       tError.errorMessage = ex.toString();
/* 198 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 201 */         pstmt.close(); } catch (Exception e) {
/* 202 */         e.printStackTrace();
/*     */       }
/* 204 */       if (!this.mflag) {
/*     */         try {
/* 206 */           this.con.close(); } catch (Exception e) {
/* 207 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 210 */       return false;
/*     */     }
/*     */ 
/* 213 */     if (!this.mflag) {
/*     */       try {
/* 215 */         this.con.close(); } catch (Exception e) {
/* 216 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 219 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 225 */     PreparedStatement pstmt = null;
/*     */ 
/* 227 */     if (!this.mflag) {
/* 228 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 233 */       int tCount = size();
/* 234 */       pstmt = this.con.prepareStatement("INSERT INTO LNPRiskComCtrl VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 235 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 237 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 238 */           pstmt.setString(1, null);
/*     */         else {
/* 240 */           pstmt.setString(1, get(i).getRiskCode());
/*     */         }
/* 242 */         if ((get(i).getManageComGrp() == null) || (get(i).getManageComGrp().equals("null")))
/* 243 */           pstmt.setString(2, null);
/*     */         else {
/* 245 */           pstmt.setString(2, get(i).getManageComGrp());
/*     */         }
/* 247 */         if ((get(i).getSaleChnl() == null) || (get(i).getSaleChnl().equals("null")))
/* 248 */           pstmt.setString(3, null);
/*     */         else {
/* 250 */           pstmt.setString(3, get(i).getSaleChnl());
/*     */         }
/* 252 */         if ((get(i).getStartDate() == null) || (get(i).getStartDate().equals("null")))
/* 253 */           pstmt.setDate(4, null);
/*     */         else {
/* 255 */           pstmt.setDate(4, Date.valueOf(get(i).getStartDate()));
/*     */         }
/* 257 */         if ((get(i).getEndDate() == null) || (get(i).getEndDate().equals("null")))
/* 258 */           pstmt.setDate(5, null);
/*     */         else {
/* 260 */           pstmt.setDate(5, Date.valueOf(get(i).getEndDate()));
/*     */         }
/* 262 */         pstmt.setDouble(6, get(i).getMAXAmnt());
/* 263 */         pstmt.setDouble(7, get(i).getMAXMult());
/* 264 */         pstmt.setDouble(8, get(i).getMAXPrem());
/* 265 */         pstmt.setDouble(9, get(i).getMINAmnt());
/* 266 */         pstmt.setDouble(10, get(i).getMINMult());
/* 267 */         pstmt.setDouble(11, get(i).getMINPrem());
/* 268 */         pstmt.addBatch();
/*     */       }
/* 270 */       pstmt.executeBatch();
/* 271 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 274 */       ex.printStackTrace();
/* 275 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 276 */       CError tError = new CError();
/* 277 */       tError.moduleName = "LNPRiskComCtrlDBSet";
/* 278 */       tError.functionName = "insert()";
/* 279 */       tError.errorMessage = ex.toString();
/* 280 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 283 */         pstmt.close(); } catch (Exception e) {
/* 284 */         e.printStackTrace();
/*     */       }
/* 286 */       if (!this.mflag) {
/*     */         try {
/* 288 */           this.con.close(); } catch (Exception e) {
/* 289 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 292 */       return false;
/*     */     }
/*     */ 
/* 295 */     if (!this.mflag) {
/*     */       try {
/* 297 */         this.con.close(); } catch (Exception e) {
/* 298 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 301 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPRiskComCtrlDBSet
 * JD-Core Version:    0.6.0
 */