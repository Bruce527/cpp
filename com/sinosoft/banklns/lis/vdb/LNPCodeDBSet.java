/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPCodeSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPCodeSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPCodeDBSet extends LNPCodeSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPCodeDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPCode");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPCodeDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPCode");
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
/*  50 */     tError.moduleName = "LNPCodeDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPCode WHERE  CodeType = ? AND Code = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getCodeType() == null) || (get(i).getCodeType().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getCodeType());
/*     */         }
/*  78 */         if ((get(i).getCode() == null) || (get(i).getCode().equals("null")))
/*  79 */           pstmt.setString(2, null);
/*     */         else {
/*  81 */           pstmt.setString(2, get(i).getCode());
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
/*  92 */       tError.moduleName = "LNPCodeDBSet";
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
/* 131 */       pstmt = this.con.prepareStatement("UPDATE LNPCode SET  CodeType = ? , Code = ? , CodeName = ? , CodeAlias = ? , ComCode = ? , OtherSign = ? WHERE  CodeType = ? AND Code = ?");
/* 132 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 134 */         if ((get(i).getCodeType() == null) || (get(i).getCodeType().equals("null")))
/* 135 */           pstmt.setString(1, null);
/*     */         else {
/* 137 */           pstmt.setString(1, get(i).getCodeType());
/*     */         }
/* 139 */         if ((get(i).getCode() == null) || (get(i).getCode().equals("null")))
/* 140 */           pstmt.setString(2, null);
/*     */         else {
/* 142 */           pstmt.setString(2, get(i).getCode());
/*     */         }
/* 144 */         if ((get(i).getCodeName() == null) || (get(i).getCodeName().equals("null")))
/* 145 */           pstmt.setString(3, null);
/*     */         else {
/* 147 */           pstmt.setString(3, get(i).getCodeName());
/*     */         }
/* 149 */         if ((get(i).getCodeAlias() == null) || (get(i).getCodeAlias().equals("null")))
/* 150 */           pstmt.setString(4, null);
/*     */         else {
/* 152 */           pstmt.setString(4, get(i).getCodeAlias());
/*     */         }
/* 154 */         if ((get(i).getComCode() == null) || (get(i).getComCode().equals("null")))
/* 155 */           pstmt.setString(5, null);
/*     */         else {
/* 157 */           pstmt.setString(5, get(i).getComCode());
/*     */         }
/* 159 */         if ((get(i).getOtherSign() == null) || (get(i).getOtherSign().equals("null")))
/* 160 */           pstmt.setString(6, null);
/*     */         else {
/* 162 */           pstmt.setString(6, get(i).getOtherSign());
/*     */         }
/*     */ 
/* 165 */         if ((get(i).getCodeType() == null) || (get(i).getCodeType().equals("null")))
/* 166 */           pstmt.setString(7, null);
/*     */         else {
/* 168 */           pstmt.setString(7, get(i).getCodeType());
/*     */         }
/* 170 */         if ((get(i).getCode() == null) || (get(i).getCode().equals("null")))
/* 171 */           pstmt.setString(8, null);
/*     */         else {
/* 173 */           pstmt.setString(8, get(i).getCode());
/*     */         }
/* 175 */         pstmt.addBatch();
/*     */       }
/* 177 */       pstmt.executeBatch();
/* 178 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 181 */       ex.printStackTrace();
/* 182 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 183 */       CError tError = new CError();
/* 184 */       tError.moduleName = "LNPCodeDBSet";
/* 185 */       tError.functionName = "update()";
/* 186 */       tError.errorMessage = ex.toString();
/* 187 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 190 */         pstmt.close(); } catch (Exception e) {
/* 191 */         e.printStackTrace();
/*     */       }
/* 193 */       if (!this.mflag) {
/*     */         try {
/* 195 */           this.con.close(); } catch (Exception e) {
/* 196 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 199 */       return false;
/*     */     }
/*     */ 
/* 202 */     if (!this.mflag) {
/*     */       try {
/* 204 */         this.con.close(); } catch (Exception e) {
/* 205 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 208 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 214 */     PreparedStatement pstmt = null;
/*     */ 
/* 216 */     if (!this.mflag) {
/* 217 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 222 */       int tCount = size();
/* 223 */       pstmt = this.con.prepareStatement("INSERT INTO LNPCode VALUES( ? , ? , ? , ? , ? , ?)");
/* 224 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 226 */         if ((get(i).getCodeType() == null) || (get(i).getCodeType().equals("null")))
/* 227 */           pstmt.setString(1, null);
/*     */         else {
/* 229 */           pstmt.setString(1, get(i).getCodeType());
/*     */         }
/* 231 */         if ((get(i).getCode() == null) || (get(i).getCode().equals("null")))
/* 232 */           pstmt.setString(2, null);
/*     */         else {
/* 234 */           pstmt.setString(2, get(i).getCode());
/*     */         }
/* 236 */         if ((get(i).getCodeName() == null) || (get(i).getCodeName().equals("null")))
/* 237 */           pstmt.setString(3, null);
/*     */         else {
/* 239 */           pstmt.setString(3, get(i).getCodeName());
/*     */         }
/* 241 */         if ((get(i).getCodeAlias() == null) || (get(i).getCodeAlias().equals("null")))
/* 242 */           pstmt.setString(4, null);
/*     */         else {
/* 244 */           pstmt.setString(4, get(i).getCodeAlias());
/*     */         }
/* 246 */         if ((get(i).getComCode() == null) || (get(i).getComCode().equals("null")))
/* 247 */           pstmt.setString(5, null);
/*     */         else {
/* 249 */           pstmt.setString(5, get(i).getComCode());
/*     */         }
/* 251 */         if ((get(i).getOtherSign() == null) || (get(i).getOtherSign().equals("null")))
/* 252 */           pstmt.setString(6, null);
/*     */         else {
/* 254 */           pstmt.setString(6, get(i).getOtherSign());
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
/* 265 */       tError.moduleName = "LNPCodeDBSet";
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
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPCodeDBSet
 * JD-Core Version:    0.6.0
 */