/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPCalModeSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPCalModeSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPCalModeDBSet extends LNPCalModeSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPCalModeDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPCalMode");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPCalModeDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPCalMode");
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
/*  50 */     tError.moduleName = "LNPCalModeDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPCalMode WHERE  CalCode = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getCalCode() == null) || (get(i).getCalCode().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getCalCode());
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
/*  87 */       tError.moduleName = "LNPCalModeDBSet";
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
/* 126 */       pstmt = this.con.prepareStatement("UPDATE LNPCalMode SET  CalCode = ? , RiskCode = ? , Type = ? , CalSQL = ? , Remark = ? WHERE  CalCode = ?");
/* 127 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 129 */         if ((get(i).getCalCode() == null) || (get(i).getCalCode().equals("null")))
/* 130 */           pstmt.setString(1, null);
/*     */         else {
/* 132 */           pstmt.setString(1, get(i).getCalCode());
/*     */         }
/* 134 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 135 */           pstmt.setString(2, null);
/*     */         else {
/* 137 */           pstmt.setString(2, get(i).getRiskCode());
/*     */         }
/* 139 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 140 */           pstmt.setString(3, null);
/*     */         else {
/* 142 */           pstmt.setString(3, get(i).getType());
/*     */         }
/* 144 */         if ((get(i).getCalSQL() == null) || (get(i).getCalSQL().equals("null")))
/* 145 */           pstmt.setString(4, null);
/*     */         else {
/* 147 */           pstmt.setString(4, get(i).getCalSQL());
/*     */         }
/* 149 */         if ((get(i).getRemark() == null) || (get(i).getRemark().equals("null")))
/* 150 */           pstmt.setString(5, null);
/*     */         else {
/* 152 */           pstmt.setString(5, get(i).getRemark());
/*     */         }
/*     */ 
/* 155 */         if ((get(i).getCalCode() == null) || (get(i).getCalCode().equals("null")))
/* 156 */           pstmt.setString(6, null);
/*     */         else {
/* 158 */           pstmt.setString(6, get(i).getCalCode());
/*     */         }
/* 160 */         pstmt.addBatch();
/*     */       }
/* 162 */       pstmt.executeBatch();
/* 163 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 166 */       ex.printStackTrace();
/* 167 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 168 */       CError tError = new CError();
/* 169 */       tError.moduleName = "LNPCalModeDBSet";
/* 170 */       tError.functionName = "update()";
/* 171 */       tError.errorMessage = ex.toString();
/* 172 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 175 */         pstmt.close(); } catch (Exception e) {
/* 176 */         e.printStackTrace();
/*     */       }
/* 178 */       if (!this.mflag) {
/*     */         try {
/* 180 */           this.con.close(); } catch (Exception e) {
/* 181 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 184 */       return false;
/*     */     }
/*     */ 
/* 187 */     if (!this.mflag) {
/*     */       try {
/* 189 */         this.con.close(); } catch (Exception e) {
/* 190 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 193 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 199 */     PreparedStatement pstmt = null;
/*     */ 
/* 201 */     if (!this.mflag) {
/* 202 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 207 */       int tCount = size();
/* 208 */       pstmt = this.con.prepareStatement("INSERT INTO LNPCalMode VALUES( ? , ? , ? , ? , ?)");
/* 209 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 211 */         if ((get(i).getCalCode() == null) || (get(i).getCalCode().equals("null")))
/* 212 */           pstmt.setString(1, null);
/*     */         else {
/* 214 */           pstmt.setString(1, get(i).getCalCode());
/*     */         }
/* 216 */         if ((get(i).getRiskCode() == null) || (get(i).getRiskCode().equals("null")))
/* 217 */           pstmt.setString(2, null);
/*     */         else {
/* 219 */           pstmt.setString(2, get(i).getRiskCode());
/*     */         }
/* 221 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 222 */           pstmt.setString(3, null);
/*     */         else {
/* 224 */           pstmt.setString(3, get(i).getType());
/*     */         }
/* 226 */         if ((get(i).getCalSQL() == null) || (get(i).getCalSQL().equals("null")))
/* 227 */           pstmt.setString(4, null);
/*     */         else {
/* 229 */           pstmt.setString(4, get(i).getCalSQL());
/*     */         }
/* 231 */         if ((get(i).getRemark() == null) || (get(i).getRemark().equals("null")))
/* 232 */           pstmt.setString(5, null);
/*     */         else {
/* 234 */           pstmt.setString(5, get(i).getRemark());
/*     */         }
/* 236 */         pstmt.addBatch();
/*     */       }
/* 238 */       pstmt.executeBatch();
/* 239 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 242 */       ex.printStackTrace();
/* 243 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 244 */       CError tError = new CError();
/* 245 */       tError.moduleName = "LNPCalModeDBSet";
/* 246 */       tError.functionName = "insert()";
/* 247 */       tError.errorMessage = ex.toString();
/* 248 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 251 */         pstmt.close(); } catch (Exception e) {
/* 252 */         e.printStackTrace();
/*     */       }
/* 254 */       if (!this.mflag) {
/*     */         try {
/* 256 */           this.con.close(); } catch (Exception e) {
/* 257 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 260 */       return false;
/*     */     }
/*     */ 
/* 263 */     if (!this.mflag) {
/*     */       try {
/* 265 */         this.con.close(); } catch (Exception e) {
/* 266 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 269 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPCalModeDBSet
 * JD-Core Version:    0.6.0
 */