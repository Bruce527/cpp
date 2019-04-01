/*     */ package com.sinosoft.banklns.lis.vdb;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.schema.LNPAgentTraceSchema;
/*     */ import com.sinosoft.banklns.lis.vschema.LNPAgentTraceSet;
/*     */ import com.sinosoft.banklns.utility.CError;
/*     */ import com.sinosoft.banklns.utility.CErrors;
/*     */ import com.sinosoft.banklns.utility.DBConnPool;
/*     */ import com.sinosoft.banklns.utility.DBOper;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class LNPAgentTraceDBSet extends LNPAgentTraceSet
/*     */ {
/*     */   private Connection con;
/*     */   private DBOper db;
/*  22 */   private boolean mflag = false;
/*     */ 
/*     */   public LNPAgentTraceDBSet(Connection tConnection)
/*     */   {
/*  28 */     this.con = tConnection;
/*  29 */     this.db = new DBOper(this.con, "LNPAgentTrace");
/*  30 */     this.mflag = true;
/*     */   }
/*     */ 
/*     */   public LNPAgentTraceDBSet()
/*     */   {
/*  35 */     this.db = new DBOper("LNPAgentTrace");
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
/*  50 */     tError.moduleName = "LNPAgentTraceDBSet";
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
/*  70 */       pstmt = this.con.prepareStatement("DELETE FROM LNPAgentTrace WHERE  ID = ?");
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
/*  87 */       tError.moduleName = "LNPAgentTraceDBSet";
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
/* 126 */       pstmt = this.con.prepareStatement("UPDATE LNPAgentTrace SET  ID = ? , Contno = ? , Operator = ? , OperatorDate = ? , OperatorTime = ? , OperatorType = ? , Int1 = ? , Int2 = ? , Varc1 = ? , Varc2 = ? , Varc5 = ? , Varc3 = ? , Varc4 = ? , Varc6 = ? , Date1 = ? , Date2 = ? WHERE  ID = ?");
/* 127 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 129 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 130 */           pstmt.setString(1, null);
/*     */         else {
/* 132 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 134 */         if ((get(i).getContno() == null) || (get(i).getContno().equals("null")))
/* 135 */           pstmt.setString(2, null);
/*     */         else {
/* 137 */           pstmt.setString(2, get(i).getContno());
/*     */         }
/* 139 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 140 */           pstmt.setString(3, null);
/*     */         else {
/* 142 */           pstmt.setString(3, get(i).getOperator());
/*     */         }
/* 144 */         if ((get(i).getOperatorDate() == null) || (get(i).getOperatorDate().equals("null")))
/* 145 */           pstmt.setDate(4, null);
/*     */         else {
/* 147 */           pstmt.setDate(4, Date.valueOf(get(i).getOperatorDate()));
/*     */         }
/* 149 */         if ((get(i).getOperatorTime() == null) || (get(i).getOperatorTime().equals("null")))
/* 150 */           pstmt.setString(5, null);
/*     */         else {
/* 152 */           pstmt.setString(5, get(i).getOperatorTime());
/*     */         }
/* 154 */         if ((get(i).getOperatorType() == null) || (get(i).getOperatorType().equals("null")))
/* 155 */           pstmt.setString(6, null);
/*     */         else {
/* 157 */           pstmt.setString(6, get(i).getOperatorType());
/*     */         }
/* 159 */         pstmt.setInt(7, get(i).getInt1());
/* 160 */         pstmt.setInt(8, get(i).getInt2());
/* 161 */         if ((get(i).getVarc1() == null) || (get(i).getVarc1().equals("null")))
/* 162 */           pstmt.setString(9, null);
/*     */         else {
/* 164 */           pstmt.setString(9, get(i).getVarc1());
/*     */         }
/* 166 */         if ((get(i).getVarc2() == null) || (get(i).getVarc2().equals("null")))
/* 167 */           pstmt.setString(10, null);
/*     */         else {
/* 169 */           pstmt.setString(10, get(i).getVarc2());
/*     */         }
/* 171 */         if ((get(i).getVarc5() == null) || (get(i).getVarc5().equals("null")))
/* 172 */           pstmt.setString(11, null);
/*     */         else {
/* 174 */           pstmt.setString(11, get(i).getVarc5());
/*     */         }
/* 176 */         if ((get(i).getVarc3() == null) || (get(i).getVarc3().equals("null")))
/* 177 */           pstmt.setString(12, null);
/*     */         else {
/* 179 */           pstmt.setString(12, get(i).getVarc3());
/*     */         }
/* 181 */         if ((get(i).getVarc4() == null) || (get(i).getVarc4().equals("null")))
/* 182 */           pstmt.setString(13, null);
/*     */         else {
/* 184 */           pstmt.setString(13, get(i).getVarc4());
/*     */         }
/* 186 */         if ((get(i).getVarc6() == null) || (get(i).getVarc6().equals("null")))
/* 187 */           pstmt.setString(14, null);
/*     */         else {
/* 189 */           pstmt.setString(14, get(i).getVarc6());
/*     */         }
/* 191 */         if ((get(i).getDate1() == null) || (get(i).getDate1().equals("null")))
/* 192 */           pstmt.setDate(15, null);
/*     */         else {
/* 194 */           pstmt.setDate(15, Date.valueOf(get(i).getDate1()));
/*     */         }
/* 196 */         if ((get(i).getDate2() == null) || (get(i).getDate2().equals("null")))
/* 197 */           pstmt.setDate(16, null);
/*     */         else {
/* 199 */           pstmt.setDate(16, Date.valueOf(get(i).getDate2()));
/*     */         }
/*     */ 
/* 202 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 203 */           pstmt.setString(17, null);
/*     */         else {
/* 205 */           pstmt.setString(17, get(i).getID());
/*     */         }
/* 207 */         pstmt.addBatch();
/*     */       }
/* 209 */       pstmt.executeBatch();
/* 210 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 213 */       ex.printStackTrace();
/* 214 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 215 */       CError tError = new CError();
/* 216 */       tError.moduleName = "LNPAgentTraceDBSet";
/* 217 */       tError.functionName = "update()";
/* 218 */       tError.errorMessage = ex.toString();
/* 219 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 222 */         pstmt.close(); } catch (Exception e) {
/* 223 */         e.printStackTrace();
/*     */       }
/* 225 */       if (!this.mflag) {
/*     */         try {
/* 227 */           this.con.close(); } catch (Exception e) {
/* 228 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 231 */       return false;
/*     */     }
/*     */ 
/* 234 */     if (!this.mflag) {
/*     */       try {
/* 236 */         this.con.close(); } catch (Exception e) {
/* 237 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 240 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean insert()
/*     */   {
/* 246 */     PreparedStatement pstmt = null;
/*     */ 
/* 248 */     if (!this.mflag) {
/* 249 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 254 */       int tCount = size();
/* 255 */       pstmt = this.con.prepareStatement("INSERT INTO LNPAgentTrace VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/* 256 */       for (int i = 1; i <= tCount; i++)
/*     */       {
/* 258 */         if ((get(i).getID() == null) || (get(i).getID().equals("null")))
/* 259 */           pstmt.setString(1, null);
/*     */         else {
/* 261 */           pstmt.setString(1, get(i).getID());
/*     */         }
/* 263 */         if ((get(i).getContno() == null) || (get(i).getContno().equals("null")))
/* 264 */           pstmt.setString(2, null);
/*     */         else {
/* 266 */           pstmt.setString(2, get(i).getContno());
/*     */         }
/* 268 */         if ((get(i).getOperator() == null) || (get(i).getOperator().equals("null")))
/* 269 */           pstmt.setString(3, null);
/*     */         else {
/* 271 */           pstmt.setString(3, get(i).getOperator());
/*     */         }
/* 273 */         if ((get(i).getOperatorDate() == null) || (get(i).getOperatorDate().equals("null")))
/* 274 */           pstmt.setDate(4, null);
/*     */         else {
/* 276 */           pstmt.setDate(4, Date.valueOf(get(i).getOperatorDate()));
/*     */         }
/* 278 */         if ((get(i).getOperatorTime() == null) || (get(i).getOperatorTime().equals("null")))
/* 279 */           pstmt.setString(5, null);
/*     */         else {
/* 281 */           pstmt.setString(5, get(i).getOperatorTime());
/*     */         }
/* 283 */         if ((get(i).getOperatorType() == null) || (get(i).getOperatorType().equals("null")))
/* 284 */           pstmt.setString(6, null);
/*     */         else {
/* 286 */           pstmt.setString(6, get(i).getOperatorType());
/*     */         }
/* 288 */         pstmt.setInt(7, get(i).getInt1());
/* 289 */         pstmt.setInt(8, get(i).getInt2());
/* 290 */         if ((get(i).getVarc1() == null) || (get(i).getVarc1().equals("null")))
/* 291 */           pstmt.setString(9, null);
/*     */         else {
/* 293 */           pstmt.setString(9, get(i).getVarc1());
/*     */         }
/* 295 */         if ((get(i).getVarc2() == null) || (get(i).getVarc2().equals("null")))
/* 296 */           pstmt.setString(10, null);
/*     */         else {
/* 298 */           pstmt.setString(10, get(i).getVarc2());
/*     */         }
/* 300 */         if ((get(i).getVarc5() == null) || (get(i).getVarc5().equals("null")))
/* 301 */           pstmt.setString(11, null);
/*     */         else {
/* 303 */           pstmt.setString(11, get(i).getVarc5());
/*     */         }
/* 305 */         if ((get(i).getVarc3() == null) || (get(i).getVarc3().equals("null")))
/* 306 */           pstmt.setString(12, null);
/*     */         else {
/* 308 */           pstmt.setString(12, get(i).getVarc3());
/*     */         }
/* 310 */         if ((get(i).getVarc4() == null) || (get(i).getVarc4().equals("null")))
/* 311 */           pstmt.setString(13, null);
/*     */         else {
/* 313 */           pstmt.setString(13, get(i).getVarc4());
/*     */         }
/* 315 */         if ((get(i).getVarc6() == null) || (get(i).getVarc6().equals("null")))
/* 316 */           pstmt.setString(14, null);
/*     */         else {
/* 318 */           pstmt.setString(14, get(i).getVarc6());
/*     */         }
/* 320 */         if ((get(i).getDate1() == null) || (get(i).getDate1().equals("null")))
/* 321 */           pstmt.setDate(15, null);
/*     */         else {
/* 323 */           pstmt.setDate(15, Date.valueOf(get(i).getDate1()));
/*     */         }
/* 325 */         if ((get(i).getDate2() == null) || (get(i).getDate2().equals("null")))
/* 326 */           pstmt.setDate(16, null);
/*     */         else {
/* 328 */           pstmt.setDate(16, Date.valueOf(get(i).getDate2()));
/*     */         }
/* 330 */         pstmt.addBatch();
/*     */       }
/* 332 */       pstmt.executeBatch();
/* 333 */       pstmt.close();
/*     */     }
/*     */     catch (Exception ex) {
/* 336 */       ex.printStackTrace();
/* 337 */       this.mErrors.copyAllErrors(this.db.mErrors);
/* 338 */       CError tError = new CError();
/* 339 */       tError.moduleName = "LNPAgentTraceDBSet";
/* 340 */       tError.functionName = "insert()";
/* 341 */       tError.errorMessage = ex.toString();
/* 342 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 345 */         pstmt.close(); } catch (Exception e) {
/* 346 */         e.printStackTrace();
/*     */       }
/* 348 */       if (!this.mflag) {
/*     */         try {
/* 350 */           this.con.close(); } catch (Exception e) {
/* 351 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 354 */       return false;
/*     */     }
/*     */ 
/* 357 */     if (!this.mflag) {
/*     */       try {
/* 359 */         this.con.close(); } catch (Exception e) {
/* 360 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 363 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.vdb.LNPAgentTraceDBSet
 * JD-Core Version:    0.6.0
 */