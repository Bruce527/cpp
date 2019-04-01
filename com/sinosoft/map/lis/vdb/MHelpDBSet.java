/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MHelpSchema;
/*     */ import com.sinosoft.map.lis.vschema.MHelpSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MHelpDBSet extends MHelpSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MHelpDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MHelp");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MHelpDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MHelp");
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
/*  49 */     tError.moduleName = "MHelpDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MHelp WHERE  ID = ?");
/*  70 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  72 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/*  73 */           pstmt.setString(1, null);
/*     */         else {
/*  75 */           pstmt.setString(1, get(i).getID());
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
/*  86 */       tError.moduleName = "MHelpDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MHelp SET  ID = ? , ManageCom = ? , Application = ? , Person = ? , Email = ? , Tel = ? , VF1 = ? , VF2 = ? , VF3 = ? WHERE  ID = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 133 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getManageCom());
/*     */         }
/* 138 */         if ((get(i).getApplication() == null) || (get(i).getApplication().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getApplication());
/*     */         }
/* 143 */         if ((get(i).getPerson() == null) || (get(i).getPerson().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getPerson());
/*     */         }
/* 148 */         if ((get(i).getEmail() == null) || (get(i).getEmail().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getEmail());
/*     */         }
/* 153 */         if ((get(i).getTel() == null) || (get(i).getTel().equals("null")))
/* 154 */           pstmt.setString(6, null);
/*     */         else {
/* 156 */           pstmt.setString(6, get(i).getTel());
/*     */         }
/* 158 */         if ((get(i).getVF1() == null) || (get(i).getVF1().equals("null")))
/* 159 */           pstmt.setString(7, null);
/*     */         else {
/* 161 */           pstmt.setString(7, get(i).getVF1());
/*     */         }
/* 163 */         if ((get(i).getVF2() == null) || (get(i).getVF2().equals("null")))
/* 164 */           pstmt.setString(8, null);
/*     */         else {
/* 166 */           pstmt.setString(8, get(i).getVF2());
/*     */         }
/* 168 */         if ((get(i).getVF3() == null) || (get(i).getVF3().equals("null")))
/* 169 */           pstmt.setString(9, null);
/*     */         else {
/* 171 */           pstmt.setString(9, get(i).getVF3());
/*     */         }
/*     */ 
/* 174 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 175 */           pstmt.setString(10, null);
/*     */         else {
/* 177 */           pstmt.setString(10, get(i).getID());
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
/* 188 */       tError.moduleName = "MHelpDBSet";
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
/* 227 */       pstmt = this.con.prepareStatement("INSERT INTO MHelp VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 228 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 230 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 231 */           pstmt.setString(1, null);
/*     */         else {
/* 233 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 235 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 236 */           pstmt.setString(2, null);
/*     */         else {
/* 238 */           pstmt.setString(2, get(i).getManageCom());
/*     */         }
/* 240 */         if ((get(i).getApplication() == null) || (get(i).getApplication().equals("null")))
/* 241 */           pstmt.setString(3, null);
/*     */         else {
/* 243 */           pstmt.setString(3, get(i).getApplication());
/*     */         }
/* 245 */         if ((get(i).getPerson() == null) || (get(i).getPerson().equals("null")))
/* 246 */           pstmt.setString(4, null);
/*     */         else {
/* 248 */           pstmt.setString(4, get(i).getPerson());
/*     */         }
/* 250 */         if ((get(i).getEmail() == null) || (get(i).getEmail().equals("null")))
/* 251 */           pstmt.setString(5, null);
/*     */         else {
/* 253 */           pstmt.setString(5, get(i).getEmail());
/*     */         }
/* 255 */         if ((get(i).getTel() == null) || (get(i).getTel().equals("null")))
/* 256 */           pstmt.setString(6, null);
/*     */         else {
/* 258 */           pstmt.setString(6, get(i).getTel());
/*     */         }
/* 260 */         if ((get(i).getVF1() == null) || (get(i).getVF1().equals("null")))
/* 261 */           pstmt.setString(7, null);
/*     */         else {
/* 263 */           pstmt.setString(7, get(i).getVF1());
/*     */         }
/* 265 */         if ((get(i).getVF2() == null) || (get(i).getVF2().equals("null")))
/* 266 */           pstmt.setString(8, null);
/*     */         else {
/* 268 */           pstmt.setString(8, get(i).getVF2());
/*     */         }
/* 270 */         if ((get(i).getVF3() == null) || (get(i).getVF3().equals("null")))
/* 271 */           pstmt.setString(9, null);
/*     */         else {
/* 273 */           pstmt.setString(9, get(i).getVF3());
/*     */         }
/* 275 */         pstmt.addBatch();
/*     */       }
/* 277 */       pstmt.executeBatch();
/* 278 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 281 */       ex.printStackTrace();
/* 282 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 283 */       CError tError = new CError();
/* 284 */       tError.moduleName = "MHelpDBSet";
/* 285 */       tError.functionName = "insert()";
/* 286 */       tError.errorMessage = ex.toString();
/* 287 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 290 */         pstmt.close(); } catch (Exception e) {
/* 291 */         e.printStackTrace();
/*     */       }
/* 293 */       if (!this.mflag) {
/*     */         try {
/* 295 */           this.con.close(); } catch (Exception e) {
/* 296 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 299 */       return false;
/*     */     }
/*     */ 
/* 302 */     if (!this.mflag) {
/*     */       try {
/* 304 */         this.con.close(); } catch (Exception e) {
/* 305 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 308 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MHelpDBSet
 * JD-Core Version:    0.6.0
 */