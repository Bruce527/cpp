/*     */ package com.sinosoft.map.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.map.lis.schema.MLinkSchema;
/*     */ import com.sinosoft.map.lis.vschema.MLinkSet;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class MLinkDBSet extends MLinkSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  21 */   private boolean mflag = false;
/*     */ 
/*     */   public MLinkDBSet(Connection tConnection)
/*     */   {
/*  27 */     this.con = tConnection;
/*  28 */     this.db = new DBOper(this.con, "MLink");
/*  29 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public MLinkDBSet()
/*     */   {
/*  34 */     this.db = new DBOper("MLink");
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
/*  49 */     tError.moduleName = "MLinkDBSet";
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
/*  69 */       pstmt = this.con.prepareStatement("DELETE FROM MLink WHERE  ID = ?");
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
/*  86 */       tError.moduleName = "MLinkDBSet";
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
/* 125 */       pstmt = this.con.prepareStatement("UPDATE MLink SET  ID = ? , AgentCode = ? , RefURL = ? , Target = ? , Name = ? , LinkOrder = ? , State = ? , Type = ? , Icon = ? , ManageCom = ? , BranchType = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Description = ? WHERE  ID = ?");
/* 126 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 128 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 129 */           pstmt.setString(1, null);
/*     */         else {
/* 131 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 133 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/* 134 */           pstmt.setString(2, null);
/*     */         else {
/* 136 */           pstmt.setString(2, get(i).getAgentCode());
/*     */         }
/* 138 */         if ((get(i).getRefURL() == null) || (get(i).getRefURL().equals("null")))
/* 139 */           pstmt.setString(3, null);
/*     */         else {
/* 141 */           pstmt.setString(3, get(i).getRefURL());
/*     */         }
/* 143 */         if ((get(i).getTarget() == null) || (get(i).getTarget().equals("null")))
/* 144 */           pstmt.setString(4, null);
/*     */         else {
/* 146 */           pstmt.setString(4, get(i).getTarget());
/*     */         }
/* 148 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 149 */           pstmt.setString(5, null);
/*     */         else {
/* 151 */           pstmt.setString(5, get(i).getName());
/*     */         }
/* 153 */         pstmt.setInt(6, get(i).getLinkOrder());
/* 154 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 155 */           pstmt.setString(7, null);
/*     */         else {
/* 157 */           pstmt.setString(7, get(i).getState());
/*     */         }
/* 159 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 160 */           pstmt.setString(8, null);
/*     */         else {
/* 162 */           pstmt.setString(8, get(i).getType());
/*     */         }
/* 164 */         if ((get(i).getIcon() == null) || (get(i).getIcon().equals("null")))
/* 165 */           pstmt.setString(9, null);
/*     */         else {
/* 167 */           pstmt.setString(9, get(i).getIcon());
/*     */         }
/* 169 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 170 */           pstmt.setString(10, null);
/*     */         else {
/* 172 */           pstmt.setString(10, get(i).getManageCom());
/*     */         }
/* 174 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 175 */           pstmt.setString(11, null);
/*     */         else {
/* 177 */           pstmt.setString(11, get(i).getBranchType());
/*     */         }
/* 179 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 180 */           pstmt.setString(12, null);
/*     */         else {
/* 182 */           pstmt.setString(12, get(i).getVF01());
/*     */         }
/* 184 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 185 */           pstmt.setString(13, null);
/*     */         else {
/* 187 */           pstmt.setString(13, get(i).getNF01());
/*     */         }
/* 189 */         pstmt.setInt(14, get(i).getIF01());
/* 190 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 191 */           pstmt.setString(17, null);
/*     */         else {
/* 193 */           pstmt.setString(17, get(i).getModifyOperator());
/*     */         }
/* 195 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 196 */           pstmt.setString(18, null);
/*     */         else {
/* 198 */           pstmt.setString(18, get(i).getOperator());
/*     */         }
/* 200 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 201 */           pstmt.setString(20, null);
/*     */         else {
/* 203 */           pstmt.setString(20, get(i).getMakeTime());
/*     */         }
/* 205 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 206 */           pstmt.setString(22, null);
/*     */         else {
/* 208 */           pstmt.setString(22, get(i).getModifyTime());
/*     */         }
/* 210 */         if ((get(i).getDescription() == null) || (get(i).getDescription().equals("null")))
/* 211 */           pstmt.setString(23, null);
/*     */         else {
/* 213 */           pstmt.setString(23, get(i).getDescription());
/*     */         }
/*     */ 
/* 216 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 217 */           pstmt.setString(24, null);
/*     */         else {
/* 219 */           pstmt.setString(24, get(i).getID());
/*     */         }
/* 221 */         pstmt.addBatch();
/*     */       }
/* 223 */       pstmt.executeBatch();
/* 224 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 227 */       ex.printStackTrace();
/* 228 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 229 */       CError tError = new CError();
/* 230 */       tError.moduleName = "MLinkDBSet";
/* 231 */       tError.functionName = "update()";
/* 232 */       tError.errorMessage = ex.toString();
/* 233 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 236 */         pstmt.close(); } catch (Exception e) {
/* 237 */         e.printStackTrace();
/*     */       }
/* 239 */       if (!this.mflag) {
/*     */         try {
/* 241 */           this.con.close(); } catch (Exception e) {
/* 242 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 245 */       return false;
/*     */     }
/*     */ 
/* 248 */     if (!this.mflag) {
/*     */       try {
/* 250 */         this.con.close(); } catch (Exception e) {
/* 251 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 254 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 260 */     PreparedStatement pstmt = null;
/*     */ 
/* 262 */     if (!this.mflag) {
/* 263 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 268 */       int tCount = size();
/* 269 */       pstmt = this.con.prepareStatement("INSERT INTO MLink VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 270 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 272 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 273 */           pstmt.setString(1, null);
/*     */         else {
/* 275 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 277 */         if ((get(i).getAgentCode() == null) || (get(i).getAgentCode().equals("null")))
/* 278 */           pstmt.setString(2, null);
/*     */         else {
/* 280 */           pstmt.setString(2, get(i).getAgentCode());
/*     */         }
/* 282 */         if ((get(i).getRefURL() == null) || (get(i).getRefURL().equals("null")))
/* 283 */           pstmt.setString(3, null);
/*     */         else {
/* 285 */           pstmt.setString(3, get(i).getRefURL());
/*     */         }
/* 287 */         if ((get(i).getTarget() == null) || (get(i).getTarget().equals("null")))
/* 288 */           pstmt.setString(4, null);
/*     */         else {
/* 290 */           pstmt.setString(4, get(i).getTarget());
/*     */         }
/* 292 */         if ((get(i).getName() == null) || (get(i).getName().equals("null")))
/* 293 */           pstmt.setString(5, null);
/*     */         else {
/* 295 */           pstmt.setString(5, get(i).getName());
/*     */         }
/* 297 */         pstmt.setInt(6, get(i).getLinkOrder());
/* 298 */         if ((get(i).getState() == null) || (get(i).getState().equals("null")))
/* 299 */           pstmt.setString(7, null);
/*     */         else {
/* 301 */           pstmt.setString(7, get(i).getState());
/*     */         }
/* 303 */         if ((get(i).getType() == null) || (get(i).getType().equals("null")))
/* 304 */           pstmt.setString(8, null);
/*     */         else {
/* 306 */           pstmt.setString(8, get(i).getType());
/*     */         }
/* 308 */         if ((get(i).getIcon() == null) || (get(i).getIcon().equals("null")))
/* 309 */           pstmt.setString(9, null);
/*     */         else {
/* 311 */           pstmt.setString(9, get(i).getIcon());
/*     */         }
/* 313 */         if ((get(i).getManageCom() == null) || (get(i).getManageCom().equals("null")))
/* 314 */           pstmt.setString(10, null);
/*     */         else {
/* 316 */           pstmt.setString(10, get(i).getManageCom());
/*     */         }
/* 318 */         if ((get(i).getBranchType() == null) || (get(i).getBranchType().equals("null")))
/* 319 */           pstmt.setString(11, null);
/*     */         else {
/* 321 */           pstmt.setString(11, get(i).getBranchType());
/*     */         }
/* 323 */         if ((get(i).getVF01() == null) || (get(i).getVF01().equals("null")))
/* 324 */           pstmt.setString(12, null);
/*     */         else {
/* 326 */           pstmt.setString(12, get(i).getVF01());
/*     */         }
/* 328 */         if ((get(i).getNF01() == null) || (get(i).getNF01().equals("null")))
/* 329 */           pstmt.setString(13, null);
/*     */         else {
/* 331 */           pstmt.setString(13, get(i).getNF01());
/*     */         }
/* 333 */         pstmt.setInt(14, get(i).getIF01());
/* 334 */         if ((get(i).getModifyOperator() == null) || (get(i).getModifyOperator().equals("null")))
/* 335 */           pstmt.setString(17, null);
/*     */         else {
/* 337 */           pstmt.setString(17, get(i).getModifyOperator());
/*     */         }
/* 339 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 340 */           pstmt.setString(18, null);
/*     */         else {
/* 342 */           pstmt.setString(18, get(i).getOperator());
/*     */         }
/* 344 */         if ((get(i).getMakeTime() == null) || (get(i).getMakeTime().equals("null")))
/* 345 */           pstmt.setString(20, null);
/*     */         else {
/* 347 */           pstmt.setString(20, get(i).getMakeTime());
/*     */         }
/* 349 */         if ((get(i).getModifyTime() == null) || (get(i).getModifyTime().equals("null")))
/* 350 */           pstmt.setString(22, null);
/*     */         else {
/* 352 */           pstmt.setString(22, get(i).getModifyTime());
/*     */         }
/* 354 */         if ((get(i).getDescription() == null) || (get(i).getDescription().equals("null")))
/* 355 */           pstmt.setString(23, null);
/*     */         else {
/* 357 */           pstmt.setString(23, get(i).getDescription());
/*     */         }
/* 359 */         pstmt.addBatch();
/*     */       }
/* 361 */       pstmt.executeBatch();
/* 362 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 365 */       ex.printStackTrace();
/* 366 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 367 */       CError tError = new CError();
/* 368 */       tError.moduleName = "MLinkDBSet";
/* 369 */       tError.functionName = "insert()";
/* 370 */       tError.errorMessage = ex.toString();
/* 371 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 374 */         pstmt.close(); } catch (Exception e) {
/* 375 */         e.printStackTrace();
/*     */       }
/* 377 */       if (!this.mflag) {
/*     */         try {
/* 379 */           this.con.close(); } catch (Exception e) {
/* 380 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 383 */       return false;
/*     */     }
/*     */ 
/* 386 */     if (!this.mflag) {
/*     */       try {
/* 388 */         this.con.close(); } catch (Exception e) {
/* 389 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 392 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.vdb.MLinkDBSet
 * JD-Core Version:    0.6.0
 */