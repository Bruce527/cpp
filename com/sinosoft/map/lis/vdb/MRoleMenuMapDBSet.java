/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MRoleMenuMapSchema;
/*     */ import com.sinosoft.map.lis.vschema.MRoleMenuMapSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MRoleMenuMapDBSet extends MRoleMenuMapSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MRoleMenuMapDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MRoleMenuMap");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MRoleMenuMapDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MRoleMenuMap");
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
/*  49 */     tError.moduleName = "MRoleMenuMapDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MRoleMenuMap WHERE  ID = ?");
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
/*  86 */       tError.moduleName = "MRoleMenuMapDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MRoleMenuMap SET  ID = ? , RoleID = ? , MenuID = ? , Type = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Int1 = ? , Int2 = ? , Varc1 = ? , Varc2 = ? WHERE  ID = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 133 */         if ((get(i).getRoleID() == null) || (get(i).getRoleID().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getRoleID());
/*     */         }
/* 138 */         if ((get(i).getMenuID() == null) || (get(i).getMenuID().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getMenuID());
/*     */         }
/* 143 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getType());
/*     */         }
/* 148 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getOperator());
/*     */         }
/* 153 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 154 */           pstmt.setDate(6, null);
/*     */         else {
/* 156 */           pstmt.setDate(6, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 158 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 159 */           pstmt.setString(7, null);
/*     */         else {
/* 161 */           pstmt.setString(7, get(i).getMakeTime());
/*     */         }
/* 163 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 164 */           pstmt.setDate(8, null);
/*     */         else {
/* 166 */           pstmt.setDate(8, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 168 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 169 */           pstmt.setString(9, null);
/*     */         else {
/* 171 */           pstmt.setString(9, get(i).getModifyTime());
/*     */         }
/* 173 */         pstmt.setInt(10, get(i).getInt1());
/* 174 */         pstmt.setInt(11, get(i).getInt2());
/* 175 */         if ((get(i).getVarc1() == null) || (get(i).getVarc1().equals("null")))
/* 176 */           pstmt.setString(12, null);
/*     */         else {
/* 178 */           pstmt.setString(12, get(i).getVarc1());
/*     */         }
/* 180 */         if ((get(i).getVarc2() == null) || (get(i).getVarc2().equals("null")))
/* 181 */           pstmt.setString(13, null);
/*     */         else {
/* 183 */           pstmt.setString(13, get(i).getVarc2());
/*     */         }
/*     */ 
/* 186 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 187 */           pstmt.setString(14, null);
/*     */         else {
/* 189 */           pstmt.setString(14, get(i).getID());
/*     */         }
/* 191 */         pstmt.addBatch();
/*     */       }
/* 193 */       pstmt.executeBatch();
/* 194 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 197 */       ex.printStackTrace();
/* 198 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 199 */       CError tError = new CError();
/* 200 */       tError.moduleName = "MRoleMenuMapDBSet";
/* 201 */       tError.functionName = "update()";
/* 202 */       tError.errorMessage = ex.toString();
/* 203 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 206 */         pstmt.close(); } catch (Exception e) {
/* 207 */         e.printStackTrace();
/*     */       }
/* 209 */       if (!this.mflag) {
/*     */         try {
/* 211 */           this.con.close(); } catch (Exception e) {
/* 212 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 215 */       return false;
/*     */     }
/*     */ 
/* 218 */     if (!this.mflag) {
/*     */       try {
/* 220 */         this.con.close(); } catch (Exception e) {
/* 221 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 224 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 230 */     PreparedStatement pstmt = null;
/*     */ 
/* 232 */     if (!this.mflag) {
/* 233 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 238 */       int tCount = size();
/* 239 */       pstmt = this.con.prepareStatement("INSERT INTO MRoleMenuMap VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 240 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 242 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 243 */           pstmt.setString(1, null);
/*     */         else {
/* 245 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 247 */         if ((get(i).getRoleID() == null) || (get(i).getRoleID().equals("null")))
/* 248 */           pstmt.setString(2, null);
/*     */         else {
/* 250 */           pstmt.setString(2, get(i).getRoleID());
/*     */         }
/* 252 */         if ((get(i).getMenuID() == null) || (get(i).getMenuID().equals("null")))
/* 253 */           pstmt.setString(3, null);
/*     */         else {
/* 255 */           pstmt.setString(3, get(i).getMenuID());
/*     */         }
/* 257 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 258 */           pstmt.setString(4, null);
/*     */         else {
/* 260 */           pstmt.setString(4, get(i).getType());
/*     */         }
/* 262 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 263 */           pstmt.setString(5, null);
/*     */         else {
/* 265 */           pstmt.setString(5, get(i).getOperator());
/*     */         }
/* 267 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 268 */           pstmt.setDate(6, null);
/*     */         else {
/* 270 */           pstmt.setDate(6, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 272 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 273 */           pstmt.setString(7, null);
/*     */         else {
/* 275 */           pstmt.setString(7, get(i).getMakeTime());
/*     */         }
/* 277 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 278 */           pstmt.setDate(8, null);
/*     */         else {
/* 280 */           pstmt.setDate(8, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 282 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 283 */           pstmt.setString(9, null);
/*     */         else {
/* 285 */           pstmt.setString(9, get(i).getModifyTime());
/*     */         }
/* 287 */         pstmt.setInt(10, get(i).getInt1());
/* 288 */         pstmt.setInt(11, get(i).getInt2());
/* 289 */         if ((get(i).getVarc1() == null) || (get(i).getVarc1().equals("null")))
/* 290 */           pstmt.setString(12, null);
/*     */         else {
/* 292 */           pstmt.setString(12, get(i).getVarc1());
/*     */         }
/* 294 */         if ((get(i).getVarc2() == null) || (get(i).getVarc2().equals("null")))
/* 295 */           pstmt.setString(13, null);
/*     */         else {
/* 297 */           pstmt.setString(13, get(i).getVarc2());
/*     */         }
/* 299 */         pstmt.addBatch();
/*     */       }
/* 301 */       pstmt.executeBatch();
/* 302 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 305 */       ex.printStackTrace();
/* 306 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 307 */       CError tError = new CError();
/* 308 */       tError.moduleName = "MRoleMenuMapDBSet";
/* 309 */       tError.functionName = "insert()";
/* 310 */       tError.errorMessage = ex.toString();
/* 311 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 314 */         pstmt.close(); } catch (Exception e) {
/* 315 */         e.printStackTrace();
/*     */       }
/* 317 */       if (!this.mflag) {
/*     */         try {
/* 319 */           this.con.close(); } catch (Exception e) {
/* 320 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 323 */       return false;
/*     */     }
/*     */ 
/* 326 */     if (!this.mflag) {
/*     */       try {
/* 328 */         this.con.close(); } catch (Exception e) {
/* 329 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 332 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MRoleMenuMapDBSet
 * JD-Core Version:    0.6.0
 */