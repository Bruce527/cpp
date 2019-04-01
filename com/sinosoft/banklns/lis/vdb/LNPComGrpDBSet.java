/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPComGrpSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPComGrpSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPComGrpDBSet extends LNPComGrpSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPComGrpDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPComGrp");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPComGrpDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPComGrp");
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
/*  50 */     tError.moduleName = "LNPComGrpDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPComGrp WHERE  ComGrpCode = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getComGrpCode() == null) || (get(i).getComGrpCode().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getComGrpCode());
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
/*  87 */       tError.moduleName = "LNPComGrpDBSet";
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
/* 126 */       pstmt = this.con.prepareStatement("UPDATE LNPComGrp SET  ComGrpCode = ? , ComGrpName = ? , ComGrpDescription = ? , ComSign = ? , ComGrpType = ? , Operator = ? , MakeDate = ? , MakeTime = ? WHERE  ComGrpCode = ?");
/* 127 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 129 */         if ((get(i).getComGrpCode() == null) || (get(i).getComGrpCode().equals("null")))
/* 130 */           pstmt.setString(1, null);
/*     */         else {
/* 132 */           pstmt.setString(1, get(i).getComGrpCode());
/*     */         }
/* 134 */         if ((get(i).getComGrpName() == null) || (get(i).getComGrpName().equals("null")))
/* 135 */           pstmt.setString(2, null);
/*     */         else {
/* 137 */           pstmt.setString(2, get(i).getComGrpName());
/*     */         }
/* 139 */         if ((get(i).getComGrpDescription() == null) || (get(i).getComGrpDescription().equals("null")))
/* 140 */           pstmt.setString(3, null);
/*     */         else {
/* 142 */           pstmt.setString(3, get(i).getComGrpDescription());
/*     */         }
/* 144 */         if ((get(i).getComSign() == null) || (get(i).getComSign().equals("null")))
/* 145 */           pstmt.setString(4, null);
/*     */         else {
/* 147 */           pstmt.setString(4, get(i).getComSign());
/*     */         }
/* 149 */         if ((get(i).getComGrpType() == null) || (get(i).getComGrpType().equals("null")))
/* 150 */           pstmt.setString(5, null);
/*     */         else {
/* 152 */           pstmt.setString(5, get(i).getComGrpType());
/*     */         }
/* 154 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 155 */           pstmt.setString(6, null);
/*     */         else {
/* 157 */           pstmt.setString(6, get(i).getOperator());
/*     */         }
/* 159 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 160 */           pstmt.setDate(7, null);
/*     */         else {
/* 162 */           pstmt.setDate(7, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 164 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 165 */           pstmt.setString(8, null);
/*     */         else {
/* 167 */           pstmt.setString(8, get(i).getMakeTime());
/*     */         }
/*     */ 
/* 170 */         if ((get(i).getComGrpCode() == null) || (get(i).getComGrpCode().equals("null")))
/* 171 */           pstmt.setString(9, null);
/*     */         else {
/* 173 */           pstmt.setString(9, get(i).getComGrpCode());
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
/* 184 */       tError.moduleName = "LNPComGrpDBSet";
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
/* 223 */       pstmt = this.con.prepareStatement("INSERT INTO LNPComGrp VALUES( ? , ? , ? , ? , ? , ? , ? , ?)");
/* 224 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 226 */         if ((get(i).getComGrpCode() == null) || (get(i).getComGrpCode().equals("null")))
/* 227 */           pstmt.setString(1, null);
/*     */         else {
/* 229 */           pstmt.setString(1, get(i).getComGrpCode());
/*     */         }
/* 231 */         if ((get(i).getComGrpName() == null) || (get(i).getComGrpName().equals("null")))
/* 232 */           pstmt.setString(2, null);
/*     */         else {
/* 234 */           pstmt.setString(2, get(i).getComGrpName());
/*     */         }
/* 236 */         if ((get(i).getComGrpDescription() == null) || (get(i).getComGrpDescription().equals("null")))
/* 237 */           pstmt.setString(3, null);
/*     */         else {
/* 239 */           pstmt.setString(3, get(i).getComGrpDescription());
/*     */         }
/* 241 */         if ((get(i).getComSign() == null) || (get(i).getComSign().equals("null")))
/* 242 */           pstmt.setString(4, null);
/*     */         else {
/* 244 */           pstmt.setString(4, get(i).getComSign());
/*     */         }
/* 246 */         if ((get(i).getComGrpType() == null) || (get(i).getComGrpType().equals("null")))
/* 247 */           pstmt.setString(5, null);
/*     */         else {
/* 249 */           pstmt.setString(5, get(i).getComGrpType());
/*     */         }
/* 251 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 252 */           pstmt.setString(6, null);
/*     */         else {
/* 254 */           pstmt.setString(6, get(i).getOperator());
/*     */         }
/* 256 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 257 */           pstmt.setDate(7, null);
/*     */         else {
/* 259 */           pstmt.setDate(7, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 261 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 262 */           pstmt.setString(8, null);
/*     */         else {
/* 264 */           pstmt.setString(8, get(i).getMakeTime());
/*     */         }
/* 266 */         pstmt.addBatch();
/*     */       }
/* 268 */       pstmt.executeBatch();
/* 269 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 272 */       ex.printStackTrace();
/* 273 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 274 */       CError tError = new CError();
/* 275 */       tError.moduleName = "LNPComGrpDBSet";
/* 276 */       tError.functionName = "insert()";
/* 277 */       tError.errorMessage = ex.toString();
/* 278 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 281 */         pstmt.close(); } catch (Exception e) {
/* 282 */         e.printStackTrace();
/*     */       }
/* 284 */       if (!this.mflag) {
/*     */         try {
/* 286 */           this.con.close(); } catch (Exception e) {
/* 287 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 290 */       return false;
/*     */     }
/*     */ 
/* 293 */     if (!this.mflag) {
/*     */       try {
/* 295 */         this.con.close(); } catch (Exception e) {
/* 296 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 299 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPComGrpDBSet
 * JD-Core Version:    0.6.0
 */