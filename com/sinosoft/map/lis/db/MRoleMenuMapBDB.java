/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MRoleMenuMapBSchema;
/*      */ import com.sinosoft.map.lis.vschema.MRoleMenuMapBSet;
/*      */ import com.sinosoft.map.utility.CError;
/*      */ import com.sinosoft.map.utility.CErrors;
/*      */ import com.sinosoft.map.utility.DBConnPool;
/*      */ import com.sinosoft.map.utility.DBOper;
/*      */ import com.sinosoft.map.utility.SQLString;
/*      */ import com.sinosoft.map.utility.StrTool;
/*      */ import java.sql.Connection;
/*      */ import java.sql.Date;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.Statement;
/*      */ 
/*      */ public class MRoleMenuMapBDB extends MRoleMenuMapBSchema
/*      */ {
/*      */   private Connection con;
/*      */   private DBOper db;
/*   21 */   private boolean mflag = false;
/*      */ 
/*   23 */   public CErrors mErrors = new CErrors();
/*      */ 
/*   25 */   private ResultSet mResultSet = null;
/*   26 */   private Statement mStatement = null;
/*      */ 
/*      */   public MRoleMenuMapBDB(Connection tConnection)
/*      */   {
/*   30 */     this.con = tConnection;
/*   31 */     this.db = new DBOper(this.con, "MRoleMenuMapB");
/*   32 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MRoleMenuMapBDB()
/*      */   {
/*   37 */     this.con = null;
/*   38 */     this.db = new DBOper("MRoleMenuMapB");
/*   39 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   45 */     MRoleMenuMapBSchema tSchema = getSchema();
/*   46 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   48 */       return true;
/*      */     }
/*      */ 
/*   53 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   54 */     CError tError = new CError();
/*   55 */     tError.moduleName = "MRoleMenuMapBDB";
/*   56 */     tError.functionName = "deleteSQL";
/*   57 */     tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*   58 */     this.mErrors.addOneError(tError);
/*   59 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   65 */     MRoleMenuMapBSchema tSchema = getSchema();
/*      */ 
/*   67 */     int tCount = this.db.getCount(tSchema);
/*   68 */     if (tCount < 0)
/*      */     {
/*   71 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   72 */       CError tError = new CError();
/*   73 */       tError.moduleName = "MRoleMenuMapBDB";
/*   74 */       tError.functionName = "getCount";
/*   75 */       tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*   76 */       this.mErrors.addOneError(tError);
/*      */ 
/*   78 */       return -1;
/*      */     }
/*      */ 
/*   81 */     return tCount;
/*      */   }
/*      */ 
/*      */   public boolean delete()
/*      */   {
/*   86 */     PreparedStatement pstmt = null;
/*      */ 
/*   88 */     if (!this.mflag) {
/*   89 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*   94 */       pstmt = this.con.prepareStatement("DELETE FROM MRoleMenuMapB WHERE  EdorNo = ?");
/*   95 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*   96 */         pstmt.setNull(1, 12);
/*      */       else {
/*   98 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  100 */       pstmt.executeUpdate();
/*  101 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  104 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  105 */       CError tError = new CError();
/*  106 */       tError.moduleName = "MRoleMenuMapBDB";
/*  107 */       tError.functionName = "delete()";
/*  108 */       tError.errorMessage = ex.toString();
/*  109 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  112 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  115 */       if (!this.mflag)
/*      */         try {
/*  117 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  121 */       return false;
/*      */     }
/*      */ 
/*  124 */     if (!this.mflag)
/*      */       try {
/*  126 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  130 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  135 */     PreparedStatement pstmt = null;
/*      */ 
/*  137 */     if (!this.mflag) {
/*  138 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  143 */       pstmt = this.con.prepareStatement("UPDATE MRoleMenuMapB SET  ID = ? , RoleID = ? , MenuID = ? , Type = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Int1 = ? , Int2 = ? , Varc1 = ? , Varc2 = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  EdorNo = ?");
/*  144 */       if ((getID() == null) || (getID().equals("null")))
/*  145 */         pstmt.setNull(1, 12);
/*      */       else {
/*  147 */         pstmt.setString(1, getID());
/*      */       }
/*  149 */       if ((getRoleID() == null) || (getRoleID().equals("null")))
/*  150 */         pstmt.setNull(2, 12);
/*      */       else {
/*  152 */         pstmt.setString(2, getRoleID());
/*      */       }
/*  154 */       if ((getMenuID() == null) || (getMenuID().equals("null")))
/*  155 */         pstmt.setNull(3, 12);
/*      */       else {
/*  157 */         pstmt.setString(3, getMenuID());
/*      */       }
/*  159 */       if ((getType() == null) || (getType().equals("null")))
/*  160 */         pstmt.setNull(4, 12);
/*      */       else {
/*  162 */         pstmt.setString(4, getType());
/*      */       }
/*  164 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  165 */         pstmt.setNull(5, 12);
/*      */       else {
/*  167 */         pstmt.setString(5, getOperator());
/*      */       }
/*  169 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  170 */         pstmt.setNull(6, 91);
/*      */       else {
/*  172 */         pstmt.setDate(6, Date.valueOf(getMakeDate()));
/*      */       }
/*  174 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  175 */         pstmt.setNull(7, 12);
/*      */       else {
/*  177 */         pstmt.setString(7, getMakeTime());
/*      */       }
/*  179 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  180 */         pstmt.setNull(8, 91);
/*      */       else {
/*  182 */         pstmt.setDate(8, Date.valueOf(getModifyDate()));
/*      */       }
/*  184 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  185 */         pstmt.setNull(9, 12);
/*      */       else {
/*  187 */         pstmt.setString(9, getModifyTime());
/*      */       }
/*  189 */       pstmt.setInt(10, getInt1());
/*  190 */       pstmt.setInt(11, getInt2());
/*  191 */       if ((getVarc1() == null) || (getVarc1().equals("null")))
/*  192 */         pstmt.setNull(12, 12);
/*      */       else {
/*  194 */         pstmt.setString(12, getVarc1());
/*      */       }
/*  196 */       if ((getVarc2() == null) || (getVarc2().equals("null")))
/*  197 */         pstmt.setNull(13, 12);
/*      */       else {
/*  199 */         pstmt.setString(13, getVarc2());
/*      */       }
/*  201 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  202 */         pstmt.setNull(14, 12);
/*      */       else {
/*  204 */         pstmt.setString(14, getEdorNo());
/*      */       }
/*  206 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  207 */         pstmt.setNull(15, 12);
/*      */       else {
/*  209 */         pstmt.setString(15, getEdorType());
/*      */       }
/*  211 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  212 */         pstmt.setNull(16, 12);
/*      */       else {
/*  214 */         pstmt.setString(16, getEdorCase());
/*      */       }
/*  216 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  217 */         pstmt.setNull(17, 12);
/*      */       else {
/*  219 */         pstmt.setString(17, getOperator2());
/*      */       }
/*  221 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  222 */         pstmt.setNull(18, 91);
/*      */       else {
/*  224 */         pstmt.setDate(18, Date.valueOf(getMakeDate2()));
/*      */       }
/*  226 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  227 */         pstmt.setNull(19, 12);
/*      */       else {
/*  229 */         pstmt.setString(19, getMakeTime2());
/*      */       }
/*      */ 
/*  232 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  233 */         pstmt.setNull(20, 12);
/*      */       else {
/*  235 */         pstmt.setString(20, getEdorNo());
/*      */       }
/*  237 */       pstmt.executeUpdate();
/*  238 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  241 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  242 */       CError tError = new CError();
/*  243 */       tError.moduleName = "MRoleMenuMapBDB";
/*  244 */       tError.functionName = "update()";
/*  245 */       tError.errorMessage = ex.toString();
/*  246 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  249 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  252 */       if (!this.mflag)
/*      */         try {
/*  254 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  258 */       return false;
/*      */     }
/*      */ 
/*  261 */     if (!this.mflag)
/*      */       try {
/*  263 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  267 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  272 */     PreparedStatement pstmt = null;
/*      */ 
/*  274 */     if (!this.mflag) {
/*  275 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  280 */       pstmt = this.con.prepareStatement("INSERT INTO MRoleMenuMapB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  281 */       if ((getID() == null) || (getID().equals("null")))
/*  282 */         pstmt.setNull(1, 12);
/*      */       else {
/*  284 */         pstmt.setString(1, getID());
/*      */       }
/*  286 */       if ((getRoleID() == null) || (getRoleID().equals("null")))
/*  287 */         pstmt.setNull(2, 12);
/*      */       else {
/*  289 */         pstmt.setString(2, getRoleID());
/*      */       }
/*  291 */       if ((getMenuID() == null) || (getMenuID().equals("null")))
/*  292 */         pstmt.setNull(3, 12);
/*      */       else {
/*  294 */         pstmt.setString(3, getMenuID());
/*      */       }
/*  296 */       if ((getType() == null) || (getType().equals("null")))
/*  297 */         pstmt.setNull(4, 12);
/*      */       else {
/*  299 */         pstmt.setString(4, getType());
/*      */       }
/*  301 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  302 */         pstmt.setNull(5, 12);
/*      */       else {
/*  304 */         pstmt.setString(5, getOperator());
/*      */       }
/*  306 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  307 */         pstmt.setNull(6, 91);
/*      */       else {
/*  309 */         pstmt.setDate(6, Date.valueOf(getMakeDate()));
/*      */       }
/*  311 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  312 */         pstmt.setNull(7, 12);
/*      */       else {
/*  314 */         pstmt.setString(7, getMakeTime());
/*      */       }
/*  316 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  317 */         pstmt.setNull(8, 91);
/*      */       else {
/*  319 */         pstmt.setDate(8, Date.valueOf(getModifyDate()));
/*      */       }
/*  321 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  322 */         pstmt.setNull(9, 12);
/*      */       else {
/*  324 */         pstmt.setString(9, getModifyTime());
/*      */       }
/*  326 */       pstmt.setInt(10, getInt1());
/*  327 */       pstmt.setInt(11, getInt2());
/*  328 */       if ((getVarc1() == null) || (getVarc1().equals("null")))
/*  329 */         pstmt.setNull(12, 12);
/*      */       else {
/*  331 */         pstmt.setString(12, getVarc1());
/*      */       }
/*  333 */       if ((getVarc2() == null) || (getVarc2().equals("null")))
/*  334 */         pstmt.setNull(13, 12);
/*      */       else {
/*  336 */         pstmt.setString(13, getVarc2());
/*      */       }
/*  338 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  339 */         pstmt.setNull(14, 12);
/*      */       else {
/*  341 */         pstmt.setString(14, getEdorNo());
/*      */       }
/*  343 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  344 */         pstmt.setNull(15, 12);
/*      */       else {
/*  346 */         pstmt.setString(15, getEdorType());
/*      */       }
/*  348 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  349 */         pstmt.setNull(16, 12);
/*      */       else {
/*  351 */         pstmt.setString(16, getEdorCase());
/*      */       }
/*  353 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  354 */         pstmt.setNull(17, 12);
/*      */       else {
/*  356 */         pstmt.setString(17, getOperator2());
/*      */       }
/*  358 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  359 */         pstmt.setNull(18, 91);
/*      */       else {
/*  361 */         pstmt.setDate(18, Date.valueOf(getMakeDate2()));
/*      */       }
/*  363 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  364 */         pstmt.setNull(19, 12);
/*      */       else {
/*  366 */         pstmt.setString(19, getMakeTime2());
/*      */       }
/*      */ 
/*  369 */       pstmt.executeUpdate();
/*  370 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  373 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  374 */       CError tError = new CError();
/*  375 */       tError.moduleName = "MRoleMenuMapBDB";
/*  376 */       tError.functionName = "insert()";
/*  377 */       tError.errorMessage = ex.toString();
/*  378 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  381 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  384 */       if (!this.mflag)
/*      */         try {
/*  386 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  390 */       return false;
/*      */     }
/*      */ 
/*  393 */     if (!this.mflag)
/*      */       try {
/*  395 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  399 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  404 */     PreparedStatement pstmt = null;
/*  405 */     ResultSet rs = null;
/*      */ 
/*  407 */     if (!this.mflag) {
/*  408 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  413 */       pstmt = this.con.prepareStatement("SELECT * FROM MRoleMenuMapB WHERE  EdorNo = ?", 
/*  414 */         1003, 1007);
/*  415 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  416 */         pstmt.setNull(1, 12);
/*      */       else {
/*  418 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  420 */       rs = pstmt.executeQuery();
/*  421 */       int i = 0;
/*  422 */       if (rs.next())
/*      */       {
/*  424 */         i++;
/*  425 */         if (!setSchema(rs, i))
/*      */         {
/*  428 */           CError tError = new CError();
/*  429 */           tError.moduleName = "MRoleMenuMapBDB";
/*  430 */           tError.functionName = "getInfo";
/*  431 */           tError.errorMessage = "\u53D6\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  432 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  434 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  437 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  441 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  445 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  449 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  452 */       if (i == 0)
/*      */       {
/*  454 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  458 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  462 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  468 */       CError tError = new CError();
/*  469 */       tError.moduleName = "MRoleMenuMapBDB";
/*  470 */       tError.functionName = "getInfo";
/*  471 */       tError.errorMessage = e.toString();
/*  472 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  474 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  477 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  481 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  485 */       return false;
/*      */     }
/*      */ 
/*  488 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  492 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  497 */     return true;
/*      */   }
/*      */ 
/*      */   public MRoleMenuMapBSet query()
/*      */   {
/*  502 */     Statement stmt = null;
/*  503 */     ResultSet rs = null;
/*  504 */     MRoleMenuMapBSet aMRoleMenuMapBSet = new MRoleMenuMapBSet();
/*      */ 
/*  506 */     if (!this.mflag) {
/*  507 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  512 */       stmt = this.con.createStatement(1003, 1007);
/*  513 */       SQLString sqlObj = new SQLString("MRoleMenuMapB");
/*  514 */       MRoleMenuMapBSchema aSchema = getSchema();
/*  515 */       sqlObj.setSQL(5, aSchema);
/*  516 */       String sql = sqlObj.getSQL();
/*      */ 
/*  518 */       rs = stmt.executeQuery(sql);
/*  519 */       int i = 0;
/*  520 */       while (rs.next())
/*      */       {
/*  522 */         i++;
/*  523 */         MRoleMenuMapBSchema s1 = new MRoleMenuMapBSchema();
/*  524 */         s1.setSchema(rs, i);
/*  525 */         aMRoleMenuMapBSet.add(s1);
/*      */       }try {
/*  527 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  533 */       CError tError = new CError();
/*  534 */       tError.moduleName = "MRoleMenuMapBDB";
/*  535 */       tError.functionName = "query";
/*  536 */       tError.errorMessage = e.toString();
/*  537 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  539 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  542 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  546 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  552 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  556 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  561 */     return aMRoleMenuMapBSet;
/*      */   }
/*      */ 
/*      */   public MRoleMenuMapBSet executeQuery(String sql)
/*      */   {
/*  566 */     Statement stmt = null;
/*  567 */     ResultSet rs = null;
/*  568 */     MRoleMenuMapBSet aMRoleMenuMapBSet = new MRoleMenuMapBSet();
/*      */ 
/*  570 */     if (!this.mflag) {
/*  571 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  576 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  578 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  579 */       int i = 0;
/*  580 */       while (rs.next())
/*      */       {
/*  582 */         i++;
/*  583 */         MRoleMenuMapBSchema s1 = new MRoleMenuMapBSchema();
/*  584 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  587 */           CError tError = new CError();
/*  588 */           tError.moduleName = "MRoleMenuMapBDB";
/*  589 */           tError.functionName = "executeQuery";
/*  590 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  591 */           this.mErrors.addOneError(tError);
/*      */         }
/*  593 */         aMRoleMenuMapBSet.add(s1);
/*      */       }try {
/*  595 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  601 */       CError tError = new CError();
/*  602 */       tError.moduleName = "MRoleMenuMapBDB";
/*  603 */       tError.functionName = "executeQuery";
/*  604 */       tError.errorMessage = e.toString();
/*  605 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  607 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  610 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  614 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  620 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  624 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  629 */     return aMRoleMenuMapBSet;
/*      */   }
/*      */ 
/*      */   public MRoleMenuMapBSet query(int nStart, int nCount)
/*      */   {
/*  634 */     Statement stmt = null;
/*  635 */     ResultSet rs = null;
/*  636 */     MRoleMenuMapBSet aMRoleMenuMapBSet = new MRoleMenuMapBSet();
/*      */ 
/*  638 */     if (!this.mflag) {
/*  639 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  644 */       stmt = this.con.createStatement(1003, 1007);
/*  645 */       SQLString sqlObj = new SQLString("MRoleMenuMapB");
/*  646 */       MRoleMenuMapBSchema aSchema = getSchema();
/*  647 */       sqlObj.setSQL(5, aSchema);
/*  648 */       String sql = sqlObj.getSQL();
/*      */ 
/*  650 */       rs = stmt.executeQuery(sql);
/*  651 */       int i = 0;
/*  652 */       while (rs.next())
/*      */       {
/*  654 */         i++;
/*      */ 
/*  656 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  660 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  664 */         MRoleMenuMapBSchema s1 = new MRoleMenuMapBSchema();
/*  665 */         s1.setSchema(rs, i);
/*  666 */         aMRoleMenuMapBSet.add(s1);
/*      */       }try {
/*  668 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  674 */       CError tError = new CError();
/*  675 */       tError.moduleName = "MRoleMenuMapBDB";
/*  676 */       tError.functionName = "query";
/*  677 */       tError.errorMessage = e.toString();
/*  678 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  680 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  683 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  687 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  693 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  697 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  702 */     return aMRoleMenuMapBSet;
/*      */   }
/*      */ 
/*      */   public MRoleMenuMapBSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  707 */     Statement stmt = null;
/*  708 */     ResultSet rs = null;
/*  709 */     MRoleMenuMapBSet aMRoleMenuMapBSet = new MRoleMenuMapBSet();
/*      */ 
/*  711 */     if (!this.mflag) {
/*  712 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  717 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  719 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  720 */       int i = 0;
/*  721 */       while (rs.next())
/*      */       {
/*  723 */         i++;
/*      */ 
/*  725 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  729 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  733 */         MRoleMenuMapBSchema s1 = new MRoleMenuMapBSchema();
/*  734 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  737 */           CError tError = new CError();
/*  738 */           tError.moduleName = "MRoleMenuMapBDB";
/*  739 */           tError.functionName = "executeQuery";
/*  740 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  741 */           this.mErrors.addOneError(tError);
/*      */         }
/*  743 */         aMRoleMenuMapBSet.add(s1);
/*      */       }try {
/*  745 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  751 */       CError tError = new CError();
/*  752 */       tError.moduleName = "MRoleMenuMapBDB";
/*  753 */       tError.functionName = "executeQuery";
/*  754 */       tError.errorMessage = e.toString();
/*  755 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  757 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  760 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  764 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  770 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  774 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  779 */     return aMRoleMenuMapBSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  784 */     Statement stmt = null;
/*      */ 
/*  786 */     if (!this.mflag) {
/*  787 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  792 */       stmt = this.con.createStatement(1003, 1007);
/*  793 */       SQLString sqlObj = new SQLString("MRoleMenuMapB");
/*  794 */       MRoleMenuMapBSchema aSchema = getSchema();
/*  795 */       sqlObj.setSQL(2, aSchema);
/*  796 */       String sql = "update MRoleMenuMapB " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  798 */       int operCount = stmt.executeUpdate(sql);
/*  799 */       if (operCount == 0)
/*      */       {
/*  802 */         CError tError = new CError();
/*  803 */         tError.moduleName = "MRoleMenuMapBDB";
/*  804 */         tError.functionName = "update";
/*  805 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u7EDE\u044D\u62F7\u951F\uFFFD!";
/*  806 */         this.mErrors.addOneError(tError);
/*      */ 
/*  808 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  812 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  816 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  822 */       CError tError = new CError();
/*  823 */       tError.moduleName = "MRoleMenuMapBDB";
/*  824 */       tError.functionName = "update";
/*  825 */       tError.errorMessage = e.toString();
/*  826 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  828 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  830 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  834 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  838 */       return false;
/*      */     }
/*      */ 
/*  841 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  845 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  850 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  856 */     if (this.mResultSet != null)
/*      */     {
/*  859 */       CError tError = new CError();
/*  860 */       tError.moduleName = "MRoleMenuMapBDB";
/*  861 */       tError.functionName = "prepareData";
/*  862 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u5F3A\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u4E4B\u951F\u65A4\u62F7\u6CA1\u951F\u53EB\u5173\u95ED\uFF4F\u62F7";
/*  863 */       this.mErrors.addOneError(tError);
/*  864 */       return false;
/*      */     }
/*      */ 
/*  867 */     if (!this.mflag)
/*      */     {
/*  869 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  873 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  874 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  879 */       CError tError = new CError();
/*  880 */       tError.moduleName = "MRoleMenuMapBDB";
/*  881 */       tError.functionName = "prepareData";
/*  882 */       tError.errorMessage = e.toString();
/*  883 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  886 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  892 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  896 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  900 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  905 */       return false;
/*      */     }
/*      */ 
/*  908 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  912 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  917 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  923 */     boolean flag = true;
/*  924 */     if (this.mResultSet == null)
/*      */     {
/*  926 */       CError tError = new CError();
/*  927 */       tError.moduleName = "MRoleMenuMapBDB";
/*  928 */       tError.functionName = "hasMoreData";
/*  929 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/*  930 */       this.mErrors.addOneError(tError);
/*  931 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  935 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  939 */       CError tError = new CError();
/*  940 */       tError.moduleName = "MRoleMenuMapBDB";
/*  941 */       tError.functionName = "hasMoreData";
/*  942 */       tError.errorMessage = ex.toString();
/*  943 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  946 */         this.mResultSet.close();
/*  947 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  953 */         this.mStatement.close();
/*  954 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  958 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  962 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  967 */       return false;
/*      */     }
/*  969 */     return flag;
/*      */   }
/*      */ 
/*      */   public MRoleMenuMapBSet getData()
/*      */   {
/*  974 */     int tCount = 0;
/*  975 */     MRoleMenuMapBSet tMRoleMenuMapBSet = new MRoleMenuMapBSet();
/*  976 */     MRoleMenuMapBSchema tMRoleMenuMapBSchema = null;
/*  977 */     if (this.mResultSet == null)
/*      */     {
/*  979 */       CError tError = new CError();
/*  980 */       tError.moduleName = "MRoleMenuMapBDB";
/*  981 */       tError.functionName = "getData";
/*  982 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/*  983 */       this.mErrors.addOneError(tError);
/*  984 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  988 */       tCount = 1;
/*  989 */       tMRoleMenuMapBSchema = new MRoleMenuMapBSchema();
/*  990 */       tMRoleMenuMapBSchema.setSchema(this.mResultSet, 1);
/*  991 */       tMRoleMenuMapBSet.add(tMRoleMenuMapBSchema);
/*      */ 
/*  993 */       while (tCount++ < 5000)
/*      */       {
/*  995 */         if (!this.mResultSet.next())
/*      */           continue;
/*  997 */         tMRoleMenuMapBSchema = new MRoleMenuMapBSchema();
/*  998 */         tMRoleMenuMapBSchema.setSchema(this.mResultSet, 1);
/*  999 */         tMRoleMenuMapBSet.add(tMRoleMenuMapBSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1005 */       CError tError = new CError();
/* 1006 */       tError.moduleName = "MRoleMenuMapBDB";
/* 1007 */       tError.functionName = "getData";
/* 1008 */       tError.errorMessage = ex.toString();
/* 1009 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1012 */         this.mResultSet.close();
/* 1013 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1019 */         this.mStatement.close();
/* 1020 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1024 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1028 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1033 */       return null;
/*      */     }
/* 1035 */     return tMRoleMenuMapBSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1040 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1043 */       if (this.mResultSet == null)
/*      */       {
/* 1045 */         CError tError = new CError();
/* 1046 */         tError.moduleName = "MRoleMenuMapBDB";
/* 1047 */         tError.functionName = "closeData";
/* 1048 */         tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 1049 */         this.mErrors.addOneError(tError);
/* 1050 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1054 */         this.mResultSet.close();
/* 1055 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1060 */       CError tError = new CError();
/* 1061 */       tError.moduleName = "MRoleMenuMapBDB";
/* 1062 */       tError.functionName = "closeData";
/* 1063 */       tError.errorMessage = ex2.toString();
/* 1064 */       this.mErrors.addOneError(tError);
/* 1065 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1069 */       if (this.mStatement == null)
/*      */       {
/* 1071 */         CError tError = new CError();
/* 1072 */         tError.moduleName = "MRoleMenuMapBDB";
/* 1073 */         tError.functionName = "closeData";
/* 1074 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 1075 */         this.mErrors.addOneError(tError);
/* 1076 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1080 */         this.mStatement.close();
/* 1081 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1086 */       CError tError = new CError();
/* 1087 */       tError.moduleName = "MRoleMenuMapBDB";
/* 1088 */       tError.functionName = "closeData";
/* 1089 */       tError.errorMessage = ex3.toString();
/* 1090 */       this.mErrors.addOneError(tError);
/* 1091 */       flag = false;
/*      */     }
/* 1093 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MRoleMenuMapBDB
 * JD-Core Version:    0.6.0
 */