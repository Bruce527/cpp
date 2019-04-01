/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPUserRoleMapSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPUserRoleMapSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPUserRoleMapDBSet extends LNPUserRoleMapSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPUserRoleMapDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPUserRoleMap");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPUserRoleMapDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPUserRoleMap");
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
/*  50 */     tError.moduleName = "LNPUserRoleMapDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPUserRoleMap WHERE  ID = ?");
/*  71 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/*  73 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/*  74 */           pstmt.setString(1, null);
/*     */         else {
/*  76 */           pstmt.setString(1, get(i).getID());
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
/*  87 */       tError.moduleName = "LNPUserRoleMapDBSet";
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
/* 126 */       pstmt = this.con.prepareStatement("UPDATE LNPUserRoleMap SET  ID = ? , UserCode = ? , RoleCode = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Int1 = ? , Int2 = ? , Varc1 = ? , Varc2 = ? , Varc3 = ? WHERE  ID = ?");
/* 127 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 129 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 130 */           pstmt.setString(1, null);
/*     */         else {
/* 132 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 134 */         if ((get(i).getUserCode() == null) || (get(i).getUserCode().equals("null")))
/* 135 */           pstmt.setString(2, null);
/*     */         else {
/* 137 */           pstmt.setString(2, get(i).getUserCode());
/*     */         }
/* 139 */         if ((get(i).getRoleCode() == null) || (get(i).getRoleCode().equals("null")))
/* 140 */           pstmt.setString(3, null);
/*     */         else {
/* 142 */           pstmt.setString(3, get(i).getRoleCode());
/*     */         }
/* 144 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 145 */           pstmt.setString(4, null);
/*     */         else {
/* 147 */           pstmt.setString(4, get(i).getOperator());
/*     */         }
/* 149 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 150 */           pstmt.setDate(5, null);
/*     */         else {
/* 152 */           pstmt.setDate(5, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 154 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 155 */           pstmt.setString(6, null);
/*     */         else {
/* 157 */           pstmt.setString(6, get(i).getMakeTime());
/*     */         }
/* 159 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 160 */           pstmt.setDate(7, null);
/*     */         else {
/* 162 */           pstmt.setDate(7, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 164 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 165 */           pstmt.setString(8, null);
/*     */         else {
/* 167 */           pstmt.setString(8, get(i).getModifyTime());
/*     */         }
/* 169 */         pstmt.setInt(9, get(i).getInt1());
/* 170 */         pstmt.setInt(10, get(i).getInt2());
/* 171 */         if ((get(i).getVarc1() == null) || (get(i).getVarc1().equals("null")))
/* 172 */           pstmt.setString(11, null);
/*     */         else {
/* 174 */           pstmt.setString(11, get(i).getVarc1());
/*     */         }
/* 176 */         if ((get(i).getVarc2() == null) || (get(i).getVarc2().equals("null")))
/* 177 */           pstmt.setString(12, null);
/*     */         else {
/* 179 */           pstmt.setString(12, get(i).getVarc2());
/*     */         }
/* 181 */         if ((get(i).getVarc3() == null) || (get(i).getVarc3().equals("null")))
/* 182 */           pstmt.setString(13, null);
/*     */         else {
/* 184 */           pstmt.setString(13, get(i).getVarc3());
/*     */         }
/*     */ 
/* 187 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 188 */           pstmt.setString(14, null);
/*     */         else {
/* 190 */           pstmt.setString(14, get(i).getID());
/*     */         }
/* 192 */         pstmt.addBatch();
/*     */       }
/* 194 */       pstmt.executeBatch();
/* 195 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 198 */       ex.printStackTrace();
/* 199 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 200 */       CError tError = new CError();
/* 201 */       tError.moduleName = "LNPUserRoleMapDBSet";
/* 202 */       tError.functionName = "update()";
/* 203 */       tError.errorMessage = ex.toString();
/* 204 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 207 */         pstmt.close(); } catch (Exception e) {
/* 208 */         e.printStackTrace();
/*     */       }
/* 210 */       if (!this.mflag) {
/*     */         try {
/* 212 */           this.con.close(); } catch (Exception e) {
/* 213 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 216 */       return false;
/*     */     }
/*     */ 
/* 219 */     if (!this.mflag) {
/*     */       try {
/* 221 */         this.con.close(); } catch (Exception e) {
/* 222 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 225 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 231 */     PreparedStatement pstmt = null;
/*     */ 
/* 233 */     if (!this.mflag) {
/* 234 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 239 */       int tCount = size();
/* 240 */       pstmt = this.con.prepareStatement("INSERT INTO LNPUserRoleMap VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 241 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 243 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 244 */           pstmt.setString(1, null);
/*     */         else {
/* 246 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 248 */         if ((get(i).getUserCode() == null) || (get(i).getUserCode().equals("null")))
/* 249 */           pstmt.setString(2, null);
/*     */         else {
/* 251 */           pstmt.setString(2, get(i).getUserCode());
/*     */         }
/* 253 */         if ((get(i).getRoleCode() == null) || (get(i).getRoleCode().equals("null")))
/* 254 */           pstmt.setString(3, null);
/*     */         else {
/* 256 */           pstmt.setString(3, get(i).getRoleCode());
/*     */         }
/* 258 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 259 */           pstmt.setString(4, null);
/*     */         else {
/* 261 */           pstmt.setString(4, get(i).getOperator());
/*     */         }
/* 263 */         if ((get(i).getMakeDate() == null) || (get(i).getMakeDate().equals("null")))
/* 264 */           pstmt.setDate(5, null);
/*     */         else {
/* 266 */           pstmt.setDate(5, Date.valueOf(get(i).getMakeDate()));
/*     */         }
/* 268 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 269 */           pstmt.setString(6, null);
/*     */         else {
/* 271 */           pstmt.setString(6, get(i).getMakeTime());
/*     */         }
/* 273 */         if ((get(i).getModifyDate() == null) || (get(i).getModifyDate().equals("null")))
/* 274 */           pstmt.setDate(7, null);
/*     */         else {
/* 276 */           pstmt.setDate(7, Date.valueOf(get(i).getModifyDate()));
/*     */         }
/* 278 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 279 */           pstmt.setString(8, null);
/*     */         else {
/* 281 */           pstmt.setString(8, get(i).getModifyTime());
/*     */         }
/* 283 */         pstmt.setInt(9, get(i).getInt1());
/* 284 */         pstmt.setInt(10, get(i).getInt2());
/* 285 */         if ((get(i).getVarc1() == null) || (get(i).getVarc1().equals("null")))
/* 286 */           pstmt.setString(11, null);
/*     */         else {
/* 288 */           pstmt.setString(11, get(i).getVarc1());
/*     */         }
/* 290 */         if ((get(i).getVarc2() == null) || (get(i).getVarc2().equals("null")))
/* 291 */           pstmt.setString(12, null);
/*     */         else {
/* 293 */           pstmt.setString(12, get(i).getVarc2());
/*     */         }
/* 295 */         if ((get(i).getVarc3() == null) || (get(i).getVarc3().equals("null")))
/* 296 */           pstmt.setString(13, null);
/*     */         else {
/* 298 */           pstmt.setString(13, get(i).getVarc3());
/*     */         }
/* 300 */         pstmt.addBatch();
/*     */       }
/* 302 */       pstmt.executeBatch();
/* 303 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 306 */       ex.printStackTrace();
/* 307 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 308 */       CError tError = new CError();
/* 309 */       tError.moduleName = "LNPUserRoleMapDBSet";
/* 310 */       tError.functionName = "insert()";
/* 311 */       tError.errorMessage = ex.toString();
/* 312 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 315 */         pstmt.close(); } catch (Exception e) {
/* 316 */         e.printStackTrace();
/*     */       }
/* 318 */       if (!this.mflag) {
/*     */         try {
/* 320 */           this.con.close(); } catch (Exception e) {
/* 321 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 324 */       return false;
/*     */     }
/*     */ 
/* 327 */     if (!this.mflag) {
/*     */       try {
/* 329 */         this.con.close(); } catch (Exception e) {
/* 330 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 333 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPUserRoleMapDBSet
 * JD-Core Version:    0.6.0
 */