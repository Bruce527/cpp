/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPRiskCodeSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPRiskCodeSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPRiskCodeDBSet extends LNPRiskCodeSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPRiskCodeDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPRiskCode");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPRiskCodeDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPRiskCode");
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
/*  50 */     tError.moduleName = "LNPRiskCodeDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPRiskCode WHERE  RiskCode = ?");
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
/*  87 */       tError.moduleName = "LNPRiskCodeDBSet";
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
/* 126 */       pstmt = this.con.prepareStatement("UPDATE LNPRiskCode SET  RiskCode = ? , RiskVer = ? , RiskName = ? , KindCode = ? , RiskType = ? , SysRiskCode = ? , MappingRiskCode = ? , RiskCodeBy1 = ? , RiskCodeBy2 = ? , RiskCodeBy3 = ? , RiskCodeBy4 = ? , RiskCodeBy5 = ? WHERE  RiskCode = ?");
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
/* 144 */         if ((get(i).getKindCode() == null) || (get(i).getKindCode().equals("null")))
/* 145 */           pstmt.setString(4, null);
/*     */         else {
/* 147 */           pstmt.setString(4, get(i).getKindCode());
/*     */         }
/* 149 */         if ((get(i).getRiskType() == null) || (get(i).getRiskType().equals("null")))
/* 150 */           pstmt.setString(5, null);
/*     */         else {
/* 152 */           pstmt.setString(5, get(i).getRiskType());
/*     */         }
/* 154 */         if ((get(i).getSysRiskCode() == null) || (get(i).getSysRiskCode().equals("null")))
/* 155 */           pstmt.setString(6, null);
/*     */         else {
/* 157 */           pstmt.setString(6, get(i).getSysRiskCode());
/*     */         }
/* 159 */         if ((get(i).getMappingRiskCode() == null) || (get(i).getMappingRiskCode().equals("null")))
/* 160 */           pstmt.setString(7, null);
/*     */         else {
/* 162 */           pstmt.setString(7, get(i).getMappingRiskCode());
/*     */         }
/* 164 */         if ((get(i).getRiskCodeBy1() == null) || (get(i).getRiskCodeBy1().equals("null")))
/* 165 */           pstmt.setString(8, null);
/*     */         else {
/* 167 */           pstmt.setString(8, get(i).getRiskCodeBy1());
/*     */         }
/* 169 */         if ((get(i).getRiskCodeBy2() == null) || (get(i).getRiskCodeBy2().equals("null")))
/* 170 */           pstmt.setString(9, null);
/*     */         else {
/* 172 */           pstmt.setString(9, get(i).getRiskCodeBy2());
/*     */         }
/* 174 */         if ((get(i).getRiskCodeBy3() == null) || (get(i).getRiskCodeBy3().equals("null")))
/* 175 */           pstmt.setString(10, null);
/*     */         else {
/* 177 */           pstmt.setString(10, get(i).getRiskCodeBy3());
/*     */         }
/* 179 */         if ((get(i).getRiskCodeBy4() == null) || (get(i).getRiskCodeBy4().equals("null")))
/* 180 */           pstmt.setString(11, null);
/*     */         else {
/* 182 */           pstmt.setString(11, get(i).getRiskCodeBy4());
/*     */         }
/* 184 */         if ((get(i).getRiskCodeBy5() == null) || (get(i).getRiskCodeBy5().equals("null")))
/* 185 */           pstmt.setString(12, null);
/*     */         else {
/* 187 */           pstmt.setString(12, get(i).getRiskCodeBy5());
/*     */         }
/*     */ 
/* 190 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 191 */           pstmt.setString(13, null);
/*     */         else {
/* 193 */           pstmt.setString(13, get(i).getRiskCode());
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
/* 204 */       tError.moduleName = "LNPRiskCodeDBSet";
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
/* 243 */       pstmt = this.con.prepareStatement("INSERT INTO LNPRiskCode VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 244 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 246 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 247 */           pstmt.setString(1, null);
/*     */         else {
/* 249 */           pstmt.setString(1, get(i).getRiskCode());
/*     */         }
/* 251 */         if ((get(i).getRiskVer() == null) || (get(i).getRiskVer().equals("null")))
/* 252 */           pstmt.setString(2, null);
/*     */         else {
/* 254 */           pstmt.setString(2, get(i).getRiskVer());
/*     */         }
/* 256 */         if ((get(i).getRiskName() == null) || (get(i).getRiskName().equals("null")))
/* 257 */           pstmt.setString(3, null);
/*     */         else {
/* 259 */           pstmt.setString(3, get(i).getRiskName());
/*     */         }
/* 261 */         if ((get(i).getKindCode() == null) || (get(i).getKindCode().equals("null")))
/* 262 */           pstmt.setString(4, null);
/*     */         else {
/* 264 */           pstmt.setString(4, get(i).getKindCode());
/*     */         }
/* 266 */         if ((get(i).getRiskType() == null) || (get(i).getRiskType().equals("null")))
/* 267 */           pstmt.setString(5, null);
/*     */         else {
/* 269 */           pstmt.setString(5, get(i).getRiskType());
/*     */         }
/* 271 */         if ((get(i).getSysRiskCode() == null) || (get(i).getSysRiskCode().equals("null")))
/* 272 */           pstmt.setString(6, null);
/*     */         else {
/* 274 */           pstmt.setString(6, get(i).getSysRiskCode());
/*     */         }
/* 276 */         if ((get(i).getMappingRiskCode() == null) || (get(i).getMappingRiskCode().equals("null")))
/* 277 */           pstmt.setString(7, null);
/*     */         else {
/* 279 */           pstmt.setString(7, get(i).getMappingRiskCode());
/*     */         }
/* 281 */         if ((get(i).getRiskCodeBy1() == null) || (get(i).getRiskCodeBy1().equals("null")))
/* 282 */           pstmt.setString(8, null);
/*     */         else {
/* 284 */           pstmt.setString(8, get(i).getRiskCodeBy1());
/*     */         }
/* 286 */         if ((get(i).getRiskCodeBy2() == null) || (get(i).getRiskCodeBy2().equals("null")))
/* 287 */           pstmt.setString(9, null);
/*     */         else {
/* 289 */           pstmt.setString(9, get(i).getRiskCodeBy2());
/*     */         }
/* 291 */         if ((get(i).getRiskCodeBy3() == null) || (get(i).getRiskCodeBy3().equals("null")))
/* 292 */           pstmt.setString(10, null);
/*     */         else {
/* 294 */           pstmt.setString(10, get(i).getRiskCodeBy3());
/*     */         }
/* 296 */         if ((get(i).getRiskCodeBy4() == null) || (get(i).getRiskCodeBy4().equals("null")))
/* 297 */           pstmt.setString(11, null);
/*     */         else {
/* 299 */           pstmt.setString(11, get(i).getRiskCodeBy4());
/*     */         }
/* 301 */         if ((get(i).getRiskCodeBy5() == null) || (get(i).getRiskCodeBy5().equals("null")))
/* 302 */           pstmt.setString(12, null);
/*     */         else {
/* 304 */           pstmt.setString(12, get(i).getRiskCodeBy5());
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
/* 315 */       tError.moduleName = "LNPRiskCodeDBSet";
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
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPRiskCodeDBSet
 * JD-Core Version:    0.6.0
 */