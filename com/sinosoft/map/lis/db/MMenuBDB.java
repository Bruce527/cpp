/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MMenuBSchema;
/*      */ import com.sinosoft.map.lis.vschema.MMenuBSet;
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
/*      */ public class MMenuBDB extends MMenuBSchema
/*      */ {
/*      */   private Connection con;
/*      */   private DBOper db;
/*   21 */   private boolean mflag = false;
/*      */ 
/*   23 */   public CErrors mErrors = new CErrors();
/*      */ 
/*   26 */   private ResultSet mResultSet = null;
/*   27 */   private Statement mStatement = null;
/*      */ 
/*      */   public MMenuBDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MMenuB");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MMenuBDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MMenuB");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MMenuBSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MMenuBDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MMenuBSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MMenuBDB";
/*   75 */       tError.functionName = "getCount";
/*   76 */       tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   77 */       this.mErrors.addOneError(tError);
/*      */ 
/*   79 */       return -1;
/*      */     }
/*      */ 
/*   82 */     return tCount;
/*      */   }
/*      */ 
/*      */   public boolean delete()
/*      */   {
/*   87 */     PreparedStatement pstmt = null;
/*      */ 
/*   89 */     if (!this.mflag) {
/*   90 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MMenuB WHERE  EdorNo = ?");
/*   96 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*   97 */         pstmt.setNull(1, 12);
/*      */       else {
/*   99 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  101 */       pstmt.executeUpdate();
/*  102 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  105 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  106 */       CError tError = new CError();
/*  107 */       tError.moduleName = "MMenuBDB";
/*  108 */       tError.functionName = "delete()";
/*  109 */       tError.errorMessage = ex.toString();
/*  110 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  113 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  116 */       if (!this.mflag)
/*      */         try {
/*  118 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  122 */       return false;
/*      */     }
/*      */ 
/*  125 */     if (!this.mflag)
/*      */       try {
/*  127 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  131 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  136 */     PreparedStatement pstmt = null;
/*      */ 
/*  138 */     if (!this.mflag) {
/*  139 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MMenuB SET  NodeCode = ? , ParentID = ? , NodeLevel = ? , NodeName = ? , ChildFlag = ? , NodeKey = ? , RunScript = ? , NodeDesc = ? , NodeSign = ? , NodeOrder = ? , Int1 = ? , Int2 = ? , Varc1 = ? , Varc2 = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  EdorNo = ?");
/*  145 */       if ((getNodeCode() == null) || (getNodeCode().equals("null")))
/*  146 */         pstmt.setNull(1, 12);
/*      */       else {
/*  148 */         pstmt.setString(1, getNodeCode());
/*      */       }
/*  150 */       if ((getParentID() == null) || (getParentID().equals("null")))
/*  151 */         pstmt.setNull(2, 12);
/*      */       else {
/*  153 */         pstmt.setString(2, getParentID());
/*      */       }
/*  155 */       if ((getNodeLevel() == null) || (getNodeLevel().equals("null")))
/*  156 */         pstmt.setNull(3, 12);
/*      */       else {
/*  158 */         pstmt.setString(3, getNodeLevel());
/*      */       }
/*  160 */       if ((getNodeName() == null) || (getNodeName().equals("null")))
/*  161 */         pstmt.setNull(4, 12);
/*      */       else {
/*  163 */         pstmt.setString(4, getNodeName());
/*      */       }
/*  165 */       if ((getChildFlag() == null) || (getChildFlag().equals("null")))
/*  166 */         pstmt.setNull(5, 12);
/*      */       else {
/*  168 */         pstmt.setString(5, getChildFlag());
/*      */       }
/*  170 */       if ((getNodeKey() == null) || (getNodeKey().equals("null")))
/*  171 */         pstmt.setNull(6, 12);
/*      */       else {
/*  173 */         pstmt.setString(6, getNodeKey());
/*      */       }
/*  175 */       if ((getRunScript() == null) || (getRunScript().equals("null")))
/*  176 */         pstmt.setNull(7, 12);
/*      */       else {
/*  178 */         pstmt.setString(7, getRunScript());
/*      */       }
/*  180 */       if ((getNodeDesc() == null) || (getNodeDesc().equals("null")))
/*  181 */         pstmt.setNull(8, 12);
/*      */       else {
/*  183 */         pstmt.setString(8, getNodeDesc());
/*      */       }
/*  185 */       if ((getNodeSign() == null) || (getNodeSign().equals("null")))
/*  186 */         pstmt.setNull(9, 12);
/*      */       else {
/*  188 */         pstmt.setString(9, getNodeSign());
/*      */       }
/*  190 */       pstmt.setInt(10, getNodeOrder());
/*  191 */       pstmt.setInt(11, getInt1());
/*  192 */       pstmt.setInt(12, getInt2());
/*  193 */       if ((getVarc1() == null) || (getVarc1().equals("null")))
/*  194 */         pstmt.setNull(13, 12);
/*      */       else {
/*  196 */         pstmt.setString(13, getVarc1());
/*      */       }
/*  198 */       if ((getVarc2() == null) || (getVarc2().equals("null")))
/*  199 */         pstmt.setNull(14, 12);
/*      */       else {
/*  201 */         pstmt.setString(14, getVarc2());
/*      */       }
/*  203 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  204 */         pstmt.setNull(15, 12);
/*      */       else {
/*  206 */         pstmt.setString(15, getOperator());
/*      */       }
/*  208 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  209 */         pstmt.setNull(16, 91);
/*      */       else {
/*  211 */         pstmt.setDate(16, Date.valueOf(getMakeDate()));
/*      */       }
/*  213 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  214 */         pstmt.setNull(17, 12);
/*      */       else {
/*  216 */         pstmt.setString(17, getMakeTime());
/*      */       }
/*  218 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  219 */         pstmt.setNull(18, 91);
/*      */       else {
/*  221 */         pstmt.setDate(18, Date.valueOf(getModifyDate()));
/*      */       }
/*  223 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  224 */         pstmt.setNull(19, 12);
/*      */       else {
/*  226 */         pstmt.setString(19, getModifyTime());
/*      */       }
/*  228 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  229 */         pstmt.setNull(20, 12);
/*      */       else {
/*  231 */         pstmt.setString(20, getEdorNo());
/*      */       }
/*  233 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  234 */         pstmt.setNull(21, 12);
/*      */       else {
/*  236 */         pstmt.setString(21, getEdorType());
/*      */       }
/*  238 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  239 */         pstmt.setNull(22, 12);
/*      */       else {
/*  241 */         pstmt.setString(22, getEdorCase());
/*      */       }
/*  243 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  244 */         pstmt.setNull(23, 12);
/*      */       else {
/*  246 */         pstmt.setString(23, getOperator2());
/*      */       }
/*  248 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  249 */         pstmt.setNull(24, 91);
/*      */       else {
/*  251 */         pstmt.setDate(24, Date.valueOf(getMakeDate2()));
/*      */       }
/*  253 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  254 */         pstmt.setNull(25, 12);
/*      */       else {
/*  256 */         pstmt.setString(25, getMakeTime2());
/*      */       }
/*      */ 
/*  259 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  260 */         pstmt.setNull(26, 12);
/*      */       else {
/*  262 */         pstmt.setString(26, getEdorNo());
/*      */       }
/*  264 */       pstmt.executeUpdate();
/*  265 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  268 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  269 */       CError tError = new CError();
/*  270 */       tError.moduleName = "MMenuBDB";
/*  271 */       tError.functionName = "update()";
/*  272 */       tError.errorMessage = ex.toString();
/*  273 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  276 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  279 */       if (!this.mflag)
/*      */         try {
/*  281 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  285 */       return false;
/*      */     }
/*      */ 
/*  288 */     if (!this.mflag)
/*      */       try {
/*  290 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  294 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  299 */     PreparedStatement pstmt = null;
/*      */ 
/*  301 */     if (!this.mflag) {
/*  302 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  307 */       pstmt = this.con.prepareStatement("INSERT INTO MMenuB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  308 */       if ((getNodeCode() == null) || (getNodeCode().equals("null")))
/*  309 */         pstmt.setNull(1, 12);
/*      */       else {
/*  311 */         pstmt.setString(1, getNodeCode());
/*      */       }
/*  313 */       if ((getParentID() == null) || (getParentID().equals("null")))
/*  314 */         pstmt.setNull(2, 12);
/*      */       else {
/*  316 */         pstmt.setString(2, getParentID());
/*      */       }
/*  318 */       if ((getNodeLevel() == null) || (getNodeLevel().equals("null")))
/*  319 */         pstmt.setNull(3, 12);
/*      */       else {
/*  321 */         pstmt.setString(3, getNodeLevel());
/*      */       }
/*  323 */       if ((getNodeName() == null) || (getNodeName().equals("null")))
/*  324 */         pstmt.setNull(4, 12);
/*      */       else {
/*  326 */         pstmt.setString(4, getNodeName());
/*      */       }
/*  328 */       if ((getChildFlag() == null) || (getChildFlag().equals("null")))
/*  329 */         pstmt.setNull(5, 12);
/*      */       else {
/*  331 */         pstmt.setString(5, getChildFlag());
/*      */       }
/*  333 */       if ((getNodeKey() == null) || (getNodeKey().equals("null")))
/*  334 */         pstmt.setNull(6, 12);
/*      */       else {
/*  336 */         pstmt.setString(6, getNodeKey());
/*      */       }
/*  338 */       if ((getRunScript() == null) || (getRunScript().equals("null")))
/*  339 */         pstmt.setNull(7, 12);
/*      */       else {
/*  341 */         pstmt.setString(7, getRunScript());
/*      */       }
/*  343 */       if ((getNodeDesc() == null) || (getNodeDesc().equals("null")))
/*  344 */         pstmt.setNull(8, 12);
/*      */       else {
/*  346 */         pstmt.setString(8, getNodeDesc());
/*      */       }
/*  348 */       if ((getNodeSign() == null) || (getNodeSign().equals("null")))
/*  349 */         pstmt.setNull(9, 12);
/*      */       else {
/*  351 */         pstmt.setString(9, getNodeSign());
/*      */       }
/*  353 */       pstmt.setInt(10, getNodeOrder());
/*  354 */       pstmt.setInt(11, getInt1());
/*  355 */       pstmt.setInt(12, getInt2());
/*  356 */       if ((getVarc1() == null) || (getVarc1().equals("null")))
/*  357 */         pstmt.setNull(13, 12);
/*      */       else {
/*  359 */         pstmt.setString(13, getVarc1());
/*      */       }
/*  361 */       if ((getVarc2() == null) || (getVarc2().equals("null")))
/*  362 */         pstmt.setNull(14, 12);
/*      */       else {
/*  364 */         pstmt.setString(14, getVarc2());
/*      */       }
/*  366 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  367 */         pstmt.setNull(15, 12);
/*      */       else {
/*  369 */         pstmt.setString(15, getOperator());
/*      */       }
/*  371 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  372 */         pstmt.setNull(16, 91);
/*      */       else {
/*  374 */         pstmt.setDate(16, Date.valueOf(getMakeDate()));
/*      */       }
/*  376 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  377 */         pstmt.setNull(17, 12);
/*      */       else {
/*  379 */         pstmt.setString(17, getMakeTime());
/*      */       }
/*  381 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  382 */         pstmt.setNull(18, 91);
/*      */       else {
/*  384 */         pstmt.setDate(18, Date.valueOf(getModifyDate()));
/*      */       }
/*  386 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  387 */         pstmt.setNull(19, 12);
/*      */       else {
/*  389 */         pstmt.setString(19, getModifyTime());
/*      */       }
/*  391 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  392 */         pstmt.setNull(20, 12);
/*      */       else {
/*  394 */         pstmt.setString(20, getEdorNo());
/*      */       }
/*  396 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  397 */         pstmt.setNull(21, 12);
/*      */       else {
/*  399 */         pstmt.setString(21, getEdorType());
/*      */       }
/*  401 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  402 */         pstmt.setNull(22, 12);
/*      */       else {
/*  404 */         pstmt.setString(22, getEdorCase());
/*      */       }
/*  406 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  407 */         pstmt.setNull(23, 12);
/*      */       else {
/*  409 */         pstmt.setString(23, getOperator2());
/*      */       }
/*  411 */       if ((getMakeDate2() == null) || (getMakeDate2().equals("null")))
/*  412 */         pstmt.setNull(24, 91);
/*      */       else {
/*  414 */         pstmt.setDate(24, Date.valueOf(getMakeDate2()));
/*      */       }
/*  416 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  417 */         pstmt.setNull(25, 12);
/*      */       else {
/*  419 */         pstmt.setString(25, getMakeTime2());
/*      */       }
/*      */ 
/*  422 */       pstmt.executeUpdate();
/*  423 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  426 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  427 */       CError tError = new CError();
/*  428 */       tError.moduleName = "MMenuBDB";
/*  429 */       tError.functionName = "insert()";
/*  430 */       tError.errorMessage = ex.toString();
/*  431 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  434 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  437 */       if (!this.mflag)
/*      */         try {
/*  439 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  443 */       return false;
/*      */     }
/*      */ 
/*  446 */     if (!this.mflag)
/*      */       try {
/*  448 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  452 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  457 */     PreparedStatement pstmt = null;
/*  458 */     ResultSet rs = null;
/*      */ 
/*  460 */     if (!this.mflag) {
/*  461 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  466 */       pstmt = this.con.prepareStatement("SELECT * FROM MMenuB WHERE  EdorNo = ?", 
/*  467 */         1003, 1007);
/*  468 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  469 */         pstmt.setNull(1, 12);
/*      */       else {
/*  471 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  473 */       rs = pstmt.executeQuery();
/*  474 */       int i = 0;
/*  475 */       if (rs.next())
/*      */       {
/*  477 */         i++;
/*  478 */         if (!setSchema(rs, i))
/*      */         {
/*  481 */           CError tError = new CError();
/*  482 */           tError.moduleName = "MMenuBDB";
/*  483 */           tError.functionName = "getInfo";
/*  484 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  485 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  487 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  490 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  494 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  498 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  502 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  505 */       if (i == 0)
/*      */       {
/*  507 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  511 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  515 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  521 */       CError tError = new CError();
/*  522 */       tError.moduleName = "MMenuBDB";
/*  523 */       tError.functionName = "getInfo";
/*  524 */       tError.errorMessage = e.toString();
/*  525 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  527 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  530 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  534 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  538 */       return false;
/*      */     }
/*      */ 
/*  541 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  545 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  550 */     return true;
/*      */   }
/*      */ 
/*      */   public MMenuBSet query()
/*      */   {
/*  555 */     Statement stmt = null;
/*  556 */     ResultSet rs = null;
/*  557 */     MMenuBSet aMMenuBSet = new MMenuBSet();
/*      */ 
/*  559 */     if (!this.mflag) {
/*  560 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  565 */       stmt = this.con.createStatement(1003, 1007);
/*  566 */       SQLString sqlObj = new SQLString("MMenuB");
/*  567 */       MMenuBSchema aSchema = getSchema();
/*  568 */       sqlObj.setSQL(5, aSchema);
/*  569 */       String sql = sqlObj.getSQL();
/*      */ 
/*  571 */       rs = stmt.executeQuery(sql);
/*  572 */       int i = 0;
/*  573 */       while (rs.next())
/*      */       {
/*  575 */         i++;
/*  576 */         MMenuBSchema s1 = new MMenuBSchema();
/*  577 */         s1.setSchema(rs, i);
/*  578 */         aMMenuBSet.add(s1);
/*      */       }try {
/*  580 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  586 */       CError tError = new CError();
/*  587 */       tError.moduleName = "MMenuBDB";
/*  588 */       tError.functionName = "query";
/*  589 */       tError.errorMessage = e.toString();
/*  590 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  592 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  595 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  599 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  605 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  609 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  614 */     return aMMenuBSet;
/*      */   }
/*      */ 
/*      */   public MMenuBSet executeQuery(String sql)
/*      */   {
/*  619 */     Statement stmt = null;
/*  620 */     ResultSet rs = null;
/*  621 */     MMenuBSet aMMenuBSet = new MMenuBSet();
/*      */ 
/*  623 */     if (!this.mflag) {
/*  624 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  629 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  631 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  632 */       int i = 0;
/*  633 */       while (rs.next())
/*      */       {
/*  635 */         i++;
/*  636 */         MMenuBSchema s1 = new MMenuBSchema();
/*  637 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  640 */           CError tError = new CError();
/*  641 */           tError.moduleName = "MMenuBDB";
/*  642 */           tError.functionName = "executeQuery";
/*  643 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  644 */           this.mErrors.addOneError(tError);
/*      */         }
/*  646 */         aMMenuBSet.add(s1);
/*      */       }try {
/*  648 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  654 */       CError tError = new CError();
/*  655 */       tError.moduleName = "MMenuBDB";
/*  656 */       tError.functionName = "executeQuery";
/*  657 */       tError.errorMessage = e.toString();
/*  658 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  660 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  663 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  667 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  673 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  677 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  682 */     return aMMenuBSet;
/*      */   }
/*      */ 
/*      */   public MMenuBSet query(int nStart, int nCount)
/*      */   {
/*  687 */     Statement stmt = null;
/*  688 */     ResultSet rs = null;
/*  689 */     MMenuBSet aMMenuBSet = new MMenuBSet();
/*      */ 
/*  691 */     if (!this.mflag) {
/*  692 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  697 */       stmt = this.con.createStatement(1003, 1007);
/*  698 */       SQLString sqlObj = new SQLString("MMenuB");
/*  699 */       MMenuBSchema aSchema = getSchema();
/*  700 */       sqlObj.setSQL(5, aSchema);
/*  701 */       String sql = sqlObj.getSQL();
/*      */ 
/*  703 */       rs = stmt.executeQuery(sql);
/*  704 */       int i = 0;
/*  705 */       while (rs.next())
/*      */       {
/*  707 */         i++;
/*      */ 
/*  709 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  713 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  717 */         MMenuBSchema s1 = new MMenuBSchema();
/*  718 */         s1.setSchema(rs, i);
/*  719 */         aMMenuBSet.add(s1);
/*      */       }try {
/*  721 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  727 */       CError tError = new CError();
/*  728 */       tError.moduleName = "MMenuBDB";
/*  729 */       tError.functionName = "query";
/*  730 */       tError.errorMessage = e.toString();
/*  731 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  733 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  736 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  740 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  746 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  750 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  755 */     return aMMenuBSet;
/*      */   }
/*      */ 
/*      */   public MMenuBSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  760 */     Statement stmt = null;
/*  761 */     ResultSet rs = null;
/*  762 */     MMenuBSet aMMenuBSet = new MMenuBSet();
/*      */ 
/*  764 */     if (!this.mflag) {
/*  765 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  770 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  772 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  773 */       int i = 0;
/*  774 */       while (rs.next())
/*      */       {
/*  776 */         i++;
/*      */ 
/*  778 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  782 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  786 */         MMenuBSchema s1 = new MMenuBSchema();
/*  787 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  790 */           CError tError = new CError();
/*  791 */           tError.moduleName = "MMenuBDB";
/*  792 */           tError.functionName = "executeQuery";
/*  793 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  794 */           this.mErrors.addOneError(tError);
/*      */         }
/*  796 */         aMMenuBSet.add(s1);
/*      */       }try {
/*  798 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  804 */       CError tError = new CError();
/*  805 */       tError.moduleName = "MMenuBDB";
/*  806 */       tError.functionName = "executeQuery";
/*  807 */       tError.errorMessage = e.toString();
/*  808 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  810 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  813 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  817 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  823 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  827 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  832 */     return aMMenuBSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  837 */     Statement stmt = null;
/*      */ 
/*  839 */     if (!this.mflag) {
/*  840 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  845 */       stmt = this.con.createStatement(1003, 1007);
/*  846 */       SQLString sqlObj = new SQLString("MMenuB");
/*  847 */       MMenuBSchema aSchema = getSchema();
/*  848 */       sqlObj.setSQL(2, aSchema);
/*  849 */       String sql = "update MMenuB " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  851 */       int operCount = stmt.executeUpdate(sql);
/*  852 */       if (operCount == 0)
/*      */       {
/*  855 */         CError tError = new CError();
/*  856 */         tError.moduleName = "MMenuBDB";
/*  857 */         tError.functionName = "update";
/*  858 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  859 */         this.mErrors.addOneError(tError);
/*      */ 
/*  861 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  865 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  869 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  875 */       CError tError = new CError();
/*  876 */       tError.moduleName = "MMenuBDB";
/*  877 */       tError.functionName = "update";
/*  878 */       tError.errorMessage = e.toString();
/*  879 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  881 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  883 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  887 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  891 */       return false;
/*      */     }
/*      */ 
/*  894 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  898 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  903 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  909 */     if (this.mResultSet != null)
/*      */     {
/*  912 */       CError tError = new CError();
/*  913 */       tError.moduleName = "MMenuBDB";
/*  914 */       tError.functionName = "prepareData";
/*  915 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  916 */       this.mErrors.addOneError(tError);
/*  917 */       return false;
/*      */     }
/*      */ 
/*  920 */     if (!this.mflag)
/*      */     {
/*  922 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  926 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  927 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  932 */       CError tError = new CError();
/*  933 */       tError.moduleName = "MMenuBDB";
/*  934 */       tError.functionName = "prepareData";
/*  935 */       tError.errorMessage = e.toString();
/*  936 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  939 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  945 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  949 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  953 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  958 */       return false;
/*      */     }
/*      */ 
/*  961 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  965 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  970 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  976 */     boolean flag = true;
/*  977 */     if (this.mResultSet == null)
/*      */     {
/*  979 */       CError tError = new CError();
/*  980 */       tError.moduleName = "MMenuBDB";
/*  981 */       tError.functionName = "hasMoreData";
/*  982 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  983 */       this.mErrors.addOneError(tError);
/*  984 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  988 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  992 */       CError tError = new CError();
/*  993 */       tError.moduleName = "MMenuBDB";
/*  994 */       tError.functionName = "hasMoreData";
/*  995 */       tError.errorMessage = ex.toString();
/*  996 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  999 */         this.mResultSet.close();
/* 1000 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1006 */         this.mStatement.close();
/* 1007 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1011 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1015 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1020 */       return false;
/*      */     }
/* 1022 */     return flag;
/*      */   }
/*      */ 
/*      */   public MMenuBSet getData()
/*      */   {
/* 1027 */     int tCount = 0;
/* 1028 */     MMenuBSet tMMenuBSet = new MMenuBSet();
/* 1029 */     MMenuBSchema tMMenuBSchema = null;
/* 1030 */     if (this.mResultSet == null)
/*      */     {
/* 1032 */       CError tError = new CError();
/* 1033 */       tError.moduleName = "MMenuBDB";
/* 1034 */       tError.functionName = "getData";
/* 1035 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1036 */       this.mErrors.addOneError(tError);
/* 1037 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1041 */       tCount = 1;
/* 1042 */       tMMenuBSchema = new MMenuBSchema();
/* 1043 */       tMMenuBSchema.setSchema(this.mResultSet, 1);
/* 1044 */       tMMenuBSet.add(tMMenuBSchema);
/*      */ 
/* 1046 */       while (tCount++ < 5000)
/*      */       {
/* 1048 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1050 */         tMMenuBSchema = new MMenuBSchema();
/* 1051 */         tMMenuBSchema.setSchema(this.mResultSet, 1);
/* 1052 */         tMMenuBSet.add(tMMenuBSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1058 */       CError tError = new CError();
/* 1059 */       tError.moduleName = "MMenuBDB";
/* 1060 */       tError.functionName = "getData";
/* 1061 */       tError.errorMessage = ex.toString();
/* 1062 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1065 */         this.mResultSet.close();
/* 1066 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1072 */         this.mStatement.close();
/* 1073 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1077 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1081 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1086 */       return null;
/*      */     }
/* 1088 */     return tMMenuBSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1093 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1096 */       if (this.mResultSet == null)
/*      */       {
/* 1098 */         CError tError = new CError();
/* 1099 */         tError.moduleName = "MMenuBDB";
/* 1100 */         tError.functionName = "closeData";
/* 1101 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1102 */         this.mErrors.addOneError(tError);
/* 1103 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1107 */         this.mResultSet.close();
/* 1108 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1113 */       CError tError = new CError();
/* 1114 */       tError.moduleName = "MMenuBDB";
/* 1115 */       tError.functionName = "closeData";
/* 1116 */       tError.errorMessage = ex2.toString();
/* 1117 */       this.mErrors.addOneError(tError);
/* 1118 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1122 */       if (this.mStatement == null)
/*      */       {
/* 1124 */         CError tError = new CError();
/* 1125 */         tError.moduleName = "MMenuBDB";
/* 1126 */         tError.functionName = "closeData";
/* 1127 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1128 */         this.mErrors.addOneError(tError);
/* 1129 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1133 */         this.mStatement.close();
/* 1134 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1139 */       CError tError = new CError();
/* 1140 */       tError.moduleName = "MMenuBDB";
/* 1141 */       tError.functionName = "closeData";
/* 1142 */       tError.errorMessage = ex3.toString();
/* 1143 */       this.mErrors.addOneError(tError);
/* 1144 */       flag = false;
/*      */     }
/* 1146 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MMenuBDB
 * JD-Core Version:    0.6.0
 */