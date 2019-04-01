/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.CaseFileDownlLogSchema;
/*     */ import com.sinosoft.map.lis.vschema.CaseFileDownlLogSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class CaseFileDownlLogDBSet extends CaseFileDownlLogSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public CaseFileDownlLogDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "CaseFileDownlLog");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public CaseFileDownlLogDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("CaseFileDownlLog");
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
/*  49 */     tError.moduleName = "CaseFileDownlLogDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM CaseFileDownlLog WHERE  Id = ?");
/*  70 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  72 */         if ((get(i).getId() == null) || (get(i).getId().equals("null")))
/*  73 */           pstmt.setString(1, null);
/*     */         else {
/*  75 */           pstmt.setString(1, get(i).getId());
/*     */         }
/*  77 */         pstmt.addBatch();
/*     */       }
/*  79 */       pstmt.executeBatch();
/*  80 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  83 */       ex.printStackTrace();
/*  84 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  85 */       CError tError = new CError();
/*  86 */       tError.moduleName = "CaseFileDownlLogDBSet";
/*  87 */       tError.functionName = "delete()";
/*  88 */       tError.errorMessage = ex.toString();
/*  89 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/*  92 */         pstmt.close(); } catch (Exception e) {
/*  93 */         e.printStackTrace();
/*     */       }
/*  95 */       if (!this.mflag) {
/*     */         try {
/*  97 */           this.con.close(); } catch (Exception e) {
/*  98 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 101 */       return false;
/*     */     }
/*     */ 
/* 104 */     if (!this.mflag) {
/*     */       try {
/* 106 */         this.con.close(); } catch (Exception e) {
/* 107 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 110 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 116 */     PreparedStatement pstmt = null;
/*     */ 
/* 118 */     if (!this.mflag) {
/* 119 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 124 */       int tCount = size();
/* 125 */       pstmt = this.con.prepareStatement("UPDATE CaseFileDownlLog SET  Id = ? , FileDate = ? , FDownDate = ? , FDownTime = ? , Flag = ? , ModifyDate = ? , ModityTime = ? , LastOperator = ? , BY1 = ? , BY2 = ? , BY3 = ? , BY4 = ? WHERE  Id = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getId() == null) || (get(i).getId().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getId());
/*     */         }
/* 133 */         if ((get(i).getFileDate() == null) || (get(i).getFileDate().equals("null")))
/* 134 */           pstmt.setDate(2, null);
/*     */         else {
/* 136 */           pstmt.setDate(2, Date.valueOf(get(i).getFileDate()));
/*     */         }
/* 138 */         if ((get(i).getFDownDate() == null) || (get(i).getFDownDate().equals("null")))
/* 139 */           pstmt.setDate(3, null);
/*     */         else {
/* 141 */           pstmt.setDate(3, Date.valueOf(get(i).getFDownDate()));
/*     */         }
/* 143 */         if ((get(i).getFDownTime() == null) || (get(i).getFDownTime().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getFDownTime());
/*     */         }
/* 148 */         if ((get(i).getFlag() == null) || (get(i).getFlag().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getFlag());
/*     */         }
/* 153 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 154 */           pstmt.setDate(6, null);
/*     */         else {
/* 156 */           pstmt.setDate(6, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 158 */         if ((get(i).getModityTime() == null) || (get(i).getModityTime().equals("null")))
/* 159 */           pstmt.setString(7, null);
/*     */         else {
/* 161 */           pstmt.setString(7, get(i).getModityTime());
/*     */         }
/* 163 */         if ((get(i).getLastOperator() == null) || (get(i).getLastOperator().equals("null")))
/* 164 */           pstmt.setString(8, null);
/*     */         else {
/* 166 */           pstmt.setString(8, get(i).getLastOperator());
/*     */         }
/* 168 */         if ((get(i).getBY1() == null) || (get(i).getBY1().equals("null")))
/* 169 */           pstmt.setDate(9, null);
/*     */         else {
/* 171 */           pstmt.setDate(9, Date.valueOf(get(i).getBY1()));
/*     */         }
/* 173 */         if ((get(i).getBY2() == null) || (get(i).getBY2().equals("null")))
/* 174 */           pstmt.setDate(10, null);
/*     */         else {
/* 176 */           pstmt.setDate(10, Date.valueOf(get(i).getBY2()));
/*     */         }
/* 178 */         if ((get(i).getBY3() == null) || (get(i).getBY3().equals("null")))
/* 179 */           pstmt.setString(11, null);
/*     */         else {
/* 181 */           pstmt.setString(11, get(i).getBY3());
/*     */         }
/* 183 */         if ((get(i).getBY4() == null) || (get(i).getBY4().equals("null")))
/* 184 */           pstmt.setString(12, null);
/*     */         else {
/* 186 */           pstmt.setString(12, get(i).getBY4());
/*     */         }
/*     */ 
/* 189 */         if ((get(i).getId() == null) || (get(i).getId().equals("null")))
/* 190 */           pstmt.setString(13, null);
/*     */         else {
/* 192 */           pstmt.setString(13, get(i).getId());
/*     */         }
/* 194 */         pstmt.addBatch();
/*     */       }
/* 196 */       pstmt.executeBatch();
/* 197 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 200 */       ex.printStackTrace();
/* 201 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 202 */       CError tError = new CError();
/* 203 */       tError.moduleName = "CaseFileDownlLogDBSet";
/* 204 */       tError.functionName = "update()";
/* 205 */       tError.errorMessage = ex.toString();
/* 206 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 209 */         pstmt.close(); } catch (Exception e) {
/* 210 */         e.printStackTrace();
/*     */       }
/* 212 */       if (!this.mflag) {
/*     */         try {
/* 214 */           this.con.close(); } catch (Exception e) {
/* 215 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 218 */       return false;
/*     */     }
/*     */ 
/* 221 */     if (!this.mflag) {
/*     */       try {
/* 223 */         this.con.close(); } catch (Exception e) {
/* 224 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 227 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 233 */     PreparedStatement pstmt = null;
/*     */ 
/* 235 */     if (!this.mflag) {
/* 236 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 241 */       int tCount = size();
/* 242 */       pstmt = this.con.prepareStatement("INSERT INTO CaseFileDownlLog VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 243 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 245 */         if ((get(i).getId() == null) || (get(i).getId().equals("null")))
/* 246 */           pstmt.setString(1, null);
/*     */         else {
/* 248 */           pstmt.setString(1, get(i).getId());
/*     */         }
/* 250 */         if ((get(i).getFileDate() == null) || (get(i).getFileDate().equals("null")))
/* 251 */           pstmt.setDate(2, null);
/*     */         else {
/* 253 */           pstmt.setDate(2, Date.valueOf(get(i).getFileDate()));
/*     */         }
/* 255 */         if ((get(i).getFDownDate() == null) || (get(i).getFDownDate().equals("null")))
/* 256 */           pstmt.setDate(3, null);
/*     */         else {
/* 258 */           pstmt.setDate(3, Date.valueOf(get(i).getFDownDate()));
/*     */         }
/* 260 */         if ((get(i).getFDownTime() == null) || (get(i).getFDownTime().equals("null")))
/* 261 */           pstmt.setString(4, null);
/*     */         else {
/* 263 */           pstmt.setString(4, get(i).getFDownTime());
/*     */         }
/* 265 */         if ((get(i).getFlag() == null) || (get(i).getFlag().equals("null")))
/* 266 */           pstmt.setString(5, null);
/*     */         else {
/* 268 */           pstmt.setString(5, get(i).getFlag());
/*     */         }
/* 270 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 271 */           pstmt.setDate(6, null);
/*     */         else {
/* 273 */           pstmt.setDate(6, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 275 */         if ((get(i).getModityTime() == null) || (get(i).getModityTime().equals("null")))
/* 276 */           pstmt.setString(7, null);
/*     */         else {
/* 278 */           pstmt.setString(7, get(i).getModityTime());
/*     */         }
/* 280 */         if ((get(i).getLastOperator() == null) || (get(i).getLastOperator().equals("null")))
/* 281 */           pstmt.setString(8, null);
/*     */         else {
/* 283 */           pstmt.setString(8, get(i).getLastOperator());
/*     */         }
/* 285 */         if ((get(i).getBY1() == null) || (get(i).getBY1().equals("null")))
/* 286 */           pstmt.setDate(9, null);
/*     */         else {
/* 288 */           pstmt.setDate(9, Date.valueOf(get(i).getBY1()));
/*     */         }
/* 290 */         if ((get(i).getBY2() == null) || (get(i).getBY2().equals("null")))
/* 291 */           pstmt.setDate(10, null);
/*     */         else {
/* 293 */           pstmt.setDate(10, Date.valueOf(get(i).getBY2()));
/*     */         }
/* 295 */         if ((get(i).getBY3() == null) || (get(i).getBY3().equals("null")))
/* 296 */           pstmt.setString(11, null);
/*     */         else {
/* 298 */           pstmt.setString(11, get(i).getBY3());
/*     */         }
/* 300 */         if ((get(i).getBY4() == null) || (get(i).getBY4().equals("null")))
/* 301 */           pstmt.setString(12, null);
/*     */         else {
/* 303 */           pstmt.setString(12, get(i).getBY4());
/*     */         }
/* 305 */         pstmt.addBatch();
/*     */       }
/* 307 */       pstmt.executeBatch();
/* 308 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 311 */       ex.printStackTrace();
/* 312 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 313 */       CError tError = new CError();
/* 314 */       tError.moduleName = "CaseFileDownlLogDBSet";
/* 315 */       tError.functionName = "insert()";
/* 316 */       tError.errorMessage = ex.toString();
/* 317 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 320 */         pstmt.close(); } catch (Exception e) {
/* 321 */         e.printStackTrace();
/*     */       }
/* 323 */       if (!this.mflag) {
/*     */         try {
/* 325 */           this.con.close(); } catch (Exception e) {
/* 326 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 329 */       return false;
/*     */     }
/*     */ 
/* 332 */     if (!this.mflag) {
/*     */       try {
/* 334 */         this.con.close(); } catch (Exception e) {
/* 335 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 338 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.CaseFileDownlLogDBSet
 * JD-Core Version:    0.6.0
 */