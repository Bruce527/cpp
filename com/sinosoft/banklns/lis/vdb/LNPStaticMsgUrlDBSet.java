/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPStaticMsgUrlSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPStaticMsgUrlSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPStaticMsgUrlDBSet extends LNPStaticMsgUrlSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPStaticMsgUrlDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPStaticMsgUrl");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPStaticMsgUrlDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPStaticMsgUrl");
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
/*  50 */     tError.moduleName = "LNPStaticMsgUrlDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPStaticMsgUrl WHERE  StaMsgID = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         pstmt.setInt(1, get(i).getStaMsgID());
/*  74 */         pstmt.addBatch();
/*     */       }
/*  76 */       pstmt.executeBatch();
/*  77 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/*  80 */       ex.printStackTrace();
/*  81 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  82 */       CError tError = new CError();
/*  83 */       tError.moduleName = "LNPStaticMsgUrlDBSet";
/*  84 */       tError.functionName = "delete()";
/*  85 */       tError.errorMessage = ex.toString();
/*  86 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/*  89 */         pstmt.close(); } catch (Exception e) {
/*  90 */         e.printStackTrace();
/*     */       }
/*  92 */       if (!this.mflag) {
/*     */         try {
/*  94 */           this.con.close(); } catch (Exception e) {
/*  95 */           e.printStackTrace();
/*     */         }
/*     */       }
/*  98 */       return false;
/*     */     }
/*     */ 
/* 101 */     if (!this.mflag) {
/*     */       try {
/* 103 */         this.con.close(); } catch (Exception e) {
/* 104 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 107 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean update()
/*     */   {
/* 113 */     PreparedStatement pstmt = null;
/*     */ 
/* 115 */     if (!this.mflag) {
/* 116 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 121 */       int tCount = size();
/* 122 */       pstmt = this.con.prepareStatement("UPDATE LNPStaticMsgUrl SET  StaMsgID = ? , AssuranceCode = ? , MsgUrl = ? , flag = ? , Remarks = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  StaMsgID = ?");
/* 123 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 125 */         pstmt.setInt(1, get(i).getStaMsgID());
/* 126 */         if ((get(i).getAssuranceCode() == null) || (get(i).getAssuranceCode().equals("null")))
/* 127 */           pstmt.setString(2, null);
/*     */         else {
/* 129 */           pstmt.setString(2, get(i).getAssuranceCode());
/*     */         }
/* 131 */         if ((get(i).getMsgUrl() == null) || (get(i).getMsgUrl().equals("null")))
/* 132 */           pstmt.setString(3, null);
/*     */         else {
/* 134 */           pstmt.setString(3, get(i).getMsgUrl());
/*     */         }
/* 136 */         if ((get(i).getFlag() == null) || (get(i).getFlag().equals("null")))
/* 137 */           pstmt.setString(4, null);
/*     */         else {
/* 139 */           pstmt.setString(4, get(i).getFlag());
/*     */         }
/* 141 */         if ((get(i).getRemarks() == null) || (get(i).getRemarks().equals("null")))
/* 142 */           pstmt.setString(5, null);
/*     */         else {
/* 144 */           pstmt.setString(5, get(i).getRemarks());
/*     */         }
/* 146 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 147 */           pstmt.setString(6, null);
/*     */         else {
/* 149 */           pstmt.setString(6, get(i).getOperator());
/*     */         }
/* 151 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 152 */           pstmt.setDate(7, null);
/*     */         else {
/* 154 */           pstmt.setDate(7, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 156 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 157 */           pstmt.setDate(8, null);
/*     */         else {
/* 159 */           pstmt.setDate(8, Date.valueOf(get(i).getMakeTime()));
/*     */         }
/* 161 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 162 */           pstmt.setDate(9, null);
/*     */         else {
/* 164 */           pstmt.setDate(9, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 166 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 167 */           pstmt.setDate(10, null);
/*     */         else {
/* 169 */           pstmt.setDate(10, Date.valueOf(get(i).getModifyTime()));
/*     */         }
/*     */ 
/* 172 */         pstmt.setInt(11, get(i).getStaMsgID());
/* 173 */         pstmt.addBatch();
/*     */       }
/* 175 */       pstmt.executeBatch();
/* 176 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 179 */       ex.printStackTrace();
/* 180 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 181 */       CError tError = new CError();
/* 182 */       tError.moduleName = "LNPStaticMsgUrlDBSet";
/* 183 */       tError.functionName = "update()";
/* 184 */       tError.errorMessage = ex.toString();
/* 185 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 188 */         pstmt.close(); } catch (Exception e) {
/* 189 */         e.printStackTrace();
/*     */       }
/* 191 */       if (!this.mflag) {
/*     */         try {
/* 193 */           this.con.close(); } catch (Exception e) {
/* 194 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 197 */       return false;
/*     */     }
/*     */ 
/* 200 */     if (!this.mflag) {
/*     */       try {
/* 202 */         this.con.close(); } catch (Exception e) {
/* 203 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 206 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 212 */     PreparedStatement pstmt = null;
/*     */ 
/* 214 */     if (!this.mflag) {
/* 215 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 220 */       int tCount = size();
/* 221 */       pstmt = this.con.prepareStatement("INSERT INTO LNPStaticMsgUrl VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 222 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 224 */         pstmt.setInt(1, get(i).getStaMsgID());
/* 225 */         if ((get(i).getAssuranceCode() == null) || (get(i).getAssuranceCode().equals("null")))
/* 226 */           pstmt.setString(2, null);
/*     */         else {
/* 228 */           pstmt.setString(2, get(i).getAssuranceCode());
/*     */         }
/* 230 */         if ((get(i).getMsgUrl() == null) || (get(i).getMsgUrl().equals("null")))
/* 231 */           pstmt.setString(3, null);
/*     */         else {
/* 233 */           pstmt.setString(3, get(i).getMsgUrl());
/*     */         }
/* 235 */         if ((get(i).getFlag() == null) || (get(i).getFlag().equals("null")))
/* 236 */           pstmt.setString(4, null);
/*     */         else {
/* 238 */           pstmt.setString(4, get(i).getFlag());
/*     */         }
/* 240 */         if ((get(i).getRemarks() == null) || (get(i).getRemarks().equals("null")))
/* 241 */           pstmt.setString(5, null);
/*     */         else {
/* 243 */           pstmt.setString(5, get(i).getRemarks());
/*     */         }
/* 245 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 246 */           pstmt.setString(6, null);
/*     */         else {
/* 248 */           pstmt.setString(6, get(i).getOperator());
/*     */         }
/* 250 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 251 */           pstmt.setDate(7, null);
/*     */         else {
/* 253 */           pstmt.setDate(7, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 255 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 256 */           pstmt.setDate(8, null);
/*     */         else {
/* 258 */           pstmt.setDate(8, Date.valueOf(get(i).getMakeTime()));
/*     */         }
/* 260 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 261 */           pstmt.setDate(9, null);
/*     */         else {
/* 263 */           pstmt.setDate(9, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 265 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 266 */           pstmt.setDate(10, null);
/*     */         else {
/* 268 */           pstmt.setDate(10, Date.valueOf(get(i).getModifyTime()));
/*     */         }
/* 270 */         pstmt.addBatch();
/*     */       }
/* 272 */       pstmt.executeBatch();
/* 273 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 276 */       ex.printStackTrace();
/* 277 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 278 */       CError tError = new CError();
/* 279 */       tError.moduleName = "LNPStaticMsgUrlDBSet";
/* 280 */       tError.functionName = "insert()";
/* 281 */       tError.errorMessage = ex.toString();
/* 282 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 285 */         pstmt.close(); } catch (Exception e) {
/* 286 */         e.printStackTrace();
/*     */       }
/* 288 */       if (!this.mflag) {
/*     */         try {
/* 290 */           this.con.close(); } catch (Exception e) {
/* 291 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 294 */       return false;
/*     */     }
/*     */ 
/* 297 */     if (!this.mflag) {
/*     */       try {
/* 299 */         this.con.close(); } catch (Exception e) {
/* 300 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 303 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPStaticMsgUrlDBSet
 * JD-Core Version:    0.6.0
 */