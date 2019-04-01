/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPInvestRiskDataSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPInvestRiskDataSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPInvestRiskDataDBSet extends LNPInvestRiskDataSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPInvestRiskDataDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPInvestRiskData");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPInvestRiskDataDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPInvestRiskData");
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
/*  50 */     tError.moduleName = "LNPInvestRiskDataDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPInvestRiskData WHERE  Dataid = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getDataid() == null) || (get(i).getDataid().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getDataid());
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
/*  87 */       tError.moduleName = "LNPInvestRiskDataDBSet";
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
/* 126 */       pstmt = this.con.prepareStatement("UPDATE LNPInvestRiskData SET  Dataid = ? , Signno = ? , Type = ? , Serialno = ? , Age = ? , Degree = ? , Value = ? , Protagonist = ? , exponent = ? , banlance = ? , solidity = ? , prevent = ? , remark1 = ? , remark2 = ? , remark3 = ? , remark4 = ? WHERE  Dataid = ?");
/* 127 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 129 */         if ((get(i).getDataid() == null) || (get(i).getDataid().equals("null")))
/* 130 */           pstmt.setString(1, null);
/*     */         else {
/* 132 */           pstmt.setString(1, get(i).getDataid());
/*     */         }
/* 134 */         if ((get(i).getSignno() == null) || (get(i).getSignno().equals("null")))
/* 135 */           pstmt.setString(2, null);
/*     */         else {
/* 137 */           pstmt.setString(2, get(i).getSignno());
/*     */         }
/* 139 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 140 */           pstmt.setString(3, null);
/*     */         else {
/* 142 */           pstmt.setString(3, get(i).getType());
/*     */         }
/* 144 */         pstmt.setInt(4, get(i).getSerialno());
/* 145 */         pstmt.setInt(5, get(i).getAge());
/* 146 */         pstmt.setInt(6, get(i).getDegree());
/* 147 */         pstmt.setDouble(7, get(i).getValue());
/* 148 */         pstmt.setInt(8, get(i).getProtagonist());
/* 149 */         pstmt.setInt(9, get(i).getExponent());
/* 150 */         pstmt.setInt(10, get(i).getBanlance());
/* 151 */         pstmt.setInt(11, get(i).getSolidity());
/* 152 */         pstmt.setInt(12, get(i).getPrevent());
/* 153 */         if ((get(i).getRemark1() == null) || (get(i).getRemark1().equals("null")))
/* 154 */           pstmt.setString(13, null);
/*     */         else {
/* 156 */           pstmt.setString(13, get(i).getRemark1());
/*     */         }
/* 158 */         if ((get(i).getRemark2() == null) || (get(i).getRemark2().equals("null")))
/* 159 */           pstmt.setString(14, null);
/*     */         else {
/* 161 */           pstmt.setString(14, get(i).getRemark2());
/*     */         }
/* 163 */         if ((get(i).getRemark3() == null) || (get(i).getRemark3().equals("null")))
/* 164 */           pstmt.setString(15, null);
/*     */         else {
/* 166 */           pstmt.setString(15, get(i).getRemark3());
/*     */         }
/* 168 */         if ((get(i).getRemark4() == null) || (get(i).getRemark4().equals("null")))
/* 169 */           pstmt.setString(16, null);
/*     */         else {
/* 171 */           pstmt.setString(16, get(i).getRemark4());
/*     */         }
/*     */ 
/* 174 */         if ((get(i).getDataid() == null) || (get(i).getDataid().equals("null")))
/* 175 */           pstmt.setString(17, null);
/*     */         else {
/* 177 */           pstmt.setString(17, get(i).getDataid());
/*     */         }
/* 179 */         pstmt.addBatch();
/*     */       }
/* 181 */       pstmt.executeBatch();
/* 182 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 185 */       ex.printStackTrace();
/* 186 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 187 */       CError tError = new CError();
/* 188 */       tError.moduleName = "LNPInvestRiskDataDBSet";
/* 189 */       tError.functionName = "update()";
/* 190 */       tError.errorMessage = ex.toString();
/* 191 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 194 */         pstmt.close(); } catch (Exception e) {
/* 195 */         e.printStackTrace();
/*     */       }
/* 197 */       if (!this.mflag) {
/*     */         try {
/* 199 */           this.con.close(); } catch (Exception e) {
/* 200 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 203 */       return false;
/*     */     }
/*     */ 
/* 206 */     if (!this.mflag) {
/*     */       try {
/* 208 */         this.con.close(); } catch (Exception e) {
/* 209 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 212 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 218 */     PreparedStatement pstmt = null;
/*     */ 
/* 220 */     if (!this.mflag) {
/* 221 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 226 */       int tCount = size();
/* 227 */       pstmt = this.con.prepareStatement("INSERT INTO LNPInvestRiskData VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 228 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 230 */         if ((get(i).getDataid() == null) || (get(i).getDataid().equals("null")))
/* 231 */           pstmt.setString(1, null);
/*     */         else {
/* 233 */           pstmt.setString(1, get(i).getDataid());
/*     */         }
/* 235 */         if ((get(i).getSignno() == null) || (get(i).getSignno().equals("null")))
/* 236 */           pstmt.setString(2, null);
/*     */         else {
/* 238 */           pstmt.setString(2, get(i).getSignno());
/*     */         }
/* 240 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 241 */           pstmt.setString(3, null);
/*     */         else {
/* 243 */           pstmt.setString(3, get(i).getType());
/*     */         }
/* 245 */         pstmt.setInt(4, get(i).getSerialno());
/* 246 */         pstmt.setInt(5, get(i).getAge());
/* 247 */         pstmt.setInt(6, get(i).getDegree());
/* 248 */         pstmt.setDouble(7, get(i).getValue());
/* 249 */         pstmt.setInt(8, get(i).getProtagonist());
/* 250 */         pstmt.setInt(9, get(i).getExponent());
/* 251 */         pstmt.setInt(10, get(i).getBanlance());
/* 252 */         pstmt.setInt(11, get(i).getSolidity());
/* 253 */         pstmt.setInt(12, get(i).getPrevent());
/* 254 */         if ((get(i).getRemark1() == null) || (get(i).getRemark1().equals("null")))
/* 255 */           pstmt.setString(13, null);
/*     */         else {
/* 257 */           pstmt.setString(13, get(i).getRemark1());
/*     */         }
/* 259 */         if ((get(i).getRemark2() == null) || (get(i).getRemark2().equals("null")))
/* 260 */           pstmt.setString(14, null);
/*     */         else {
/* 262 */           pstmt.setString(14, get(i).getRemark2());
/*     */         }
/* 264 */         if ((get(i).getRemark3() == null) || (get(i).getRemark3().equals("null")))
/* 265 */           pstmt.setString(15, null);
/*     */         else {
/* 267 */           pstmt.setString(15, get(i).getRemark3());
/*     */         }
/* 269 */         if ((get(i).getRemark4() == null) || (get(i).getRemark4().equals("null")))
/* 270 */           pstmt.setString(16, null);
/*     */         else {
/* 272 */           pstmt.setString(16, get(i).getRemark4());
/*     */         }
/* 274 */         pstmt.addBatch();
/*     */       }
/* 276 */       pstmt.executeBatch();
/* 277 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 280 */       ex.printStackTrace();
/* 281 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 282 */       CError tError = new CError();
/* 283 */       tError.moduleName = "LNPInvestRiskDataDBSet";
/* 284 */       tError.functionName = "insert()";
/* 285 */       tError.errorMessage = ex.toString();
/* 286 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 289 */         pstmt.close(); } catch (Exception e) {
/* 290 */         e.printStackTrace();
/*     */       }
/* 292 */       if (!this.mflag) {
/*     */         try {
/* 294 */           this.con.close(); } catch (Exception e) {
/* 295 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 298 */       return false;
/*     */     }
/*     */ 
/* 301 */     if (!this.mflag) {
/*     */       try {
/* 303 */         this.con.close(); } catch (Exception e) {
/* 304 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 307 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPInvestRiskDataDBSet
 * JD-Core Version:    0.6.0
 */