/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MNewsContentSchema;
/*     */ import com.sinosoft.map.lis.vschema.MNewsContentSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MNewsContentDBSet extends MNewsContentSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MNewsContentDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MNewsContent");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MNewsContentDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MNewsContent");
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
/*  49 */     tError.moduleName = "MNewsContentDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MNewsContent WHERE  ContentID = ?");
/*  70 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  72 */         if ((get(i).getContentID() == null) || (get(i).getContentID().equals("null")))
/*  73 */           pstmt.setString(1, null);
/*     */         else {
/*  75 */           pstmt.setString(1, get(i).getContentID());
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
/*  86 */       tError.moduleName = "MNewsContentDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MNewsContent SET  ContentID = ? , NewsID = ? , Content = ? , ContOrder = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ContentID = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getContentID() == null) || (get(i).getContentID().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getContentID());
/*     */         }
/* 133 */         if ((get(i).getNewsID() == null) || (get(i).getNewsID().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getNewsID());
/*     */         }
/* 138 */         if ((get(i).getContent() == null) || (get(i).getContent().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getContent());
/*     */         }
/* 143 */         pstmt.setInt(4, get(i).getContOrder());
/* 144 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 145 */           pstmt.setString(5, null);
/*     */         else {
/* 147 */           pstmt.setString(5, get(i).getOperator());
/*     */         }
/* 149 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 150 */           pstmt.setDate(6, null);
/*     */         else {
/* 152 */           pstmt.setDate(6, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 154 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 155 */           pstmt.setString(7, null);
/*     */         else {
/* 157 */           pstmt.setString(7, get(i).getMakeTime());
/*     */         }
/* 159 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 160 */           pstmt.setDate(8, null);
/*     */         else {
/* 162 */           pstmt.setDate(8, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 164 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 165 */           pstmt.setString(9, null);
/*     */         else {
/* 167 */           pstmt.setString(9, get(i).getModifyTime());
/*     */         }
/*     */ 
/* 170 */         if ((get(i).getContentID() == null) || (get(i).getContentID().equals("null")))
/* 171 */           pstmt.setString(10, null);
/*     */         else {
/* 173 */           pstmt.setString(10, get(i).getContentID());
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
/* 184 */       tError.moduleName = "MNewsContentDBSet";
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
/* 223 */       pstmt = this.con.prepareStatement("INSERT INTO MNewsContent VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 224 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 226 */         if ((get(i).getContentID() == null) || (get(i).getContentID().equals("null")))
/* 227 */           pstmt.setString(1, null);
/*     */         else {
/* 229 */           pstmt.setString(1, get(i).getContentID());
/*     */         }
/* 231 */         if ((get(i).getNewsID() == null) || (get(i).getNewsID().equals("null")))
/* 232 */           pstmt.setString(2, null);
/*     */         else {
/* 234 */           pstmt.setString(2, get(i).getNewsID());
/*     */         }
/* 236 */         if ((get(i).getContent() == null) || (get(i).getContent().equals("null")))
/* 237 */           pstmt.setString(3, null);
/*     */         else {
/* 239 */           pstmt.setString(3, get(i).getContent());
/*     */         }
/* 241 */         pstmt.setInt(4, get(i).getContOrder());
/* 242 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 243 */           pstmt.setString(5, null);
/*     */         else {
/* 245 */           pstmt.setString(5, get(i).getOperator());
/*     */         }
/* 247 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 248 */           pstmt.setDate(6, null);
/*     */         else {
/* 250 */           pstmt.setDate(6, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 252 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 253 */           pstmt.setString(7, null);
/*     */         else {
/* 255 */           pstmt.setString(7, get(i).getMakeTime());
/*     */         }
/* 257 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 258 */           pstmt.setDate(8, null);
/*     */         else {
/* 260 */           pstmt.setDate(8, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 262 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 263 */           pstmt.setString(9, null);
/*     */         else {
/* 265 */           pstmt.setString(9, get(i).getModifyTime());
/*     */         }
/* 267 */         pstmt.addBatch();
/*     */       }
/* 269 */       pstmt.executeBatch();
/* 270 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 273 */       ex.printStackTrace();
/* 274 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 275 */       CError tError = new CError();
/* 276 */       tError.moduleName = "MNewsContentDBSet";
/* 277 */       tError.functionName = "insert()";
/* 278 */       tError.errorMessage = ex.toString();
/* 279 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 282 */         pstmt.close(); } catch (Exception e) {
/* 283 */         e.printStackTrace();
/*     */       }
/* 285 */       if (!this.mflag) {
/*     */         try {
/* 287 */           this.con.close(); } catch (Exception e) {
/* 288 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 291 */       return false;
/*     */     }
/*     */ 
/* 294 */     if (!this.mflag) {
/*     */       try {
/* 296 */         this.con.close(); } catch (Exception e) {
/* 297 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 300 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MNewsContentDBSet
 * JD-Core Version:    0.6.0
 */