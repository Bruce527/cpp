/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MMenuSchema;
/*      */ import com.sinosoft.map.lis.vschema.MMenuSet;
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
/*      */ public class MMenuDB extends MMenuSchema
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
/*      */   public MMenuDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MMenu");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MMenuDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MMenu");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MMenuSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MMenuDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MMenuSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MMenuDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MMenu WHERE  NodeCode = ?");
/*   96 */       if ((getNodeCode() == null) || (getNodeCode().equals("null")))
/*   97 */         pstmt.setNull(1, 12);
/*      */       else {
/*   99 */         pstmt.setString(1, getNodeCode());
/*      */       }
/*  101 */       pstmt.executeUpdate();
/*  102 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  105 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  106 */       CError tError = new CError();
/*  107 */       tError.moduleName = "MMenuDB";
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
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MMenu SET  NodeCode = ? , NodeName = ? , ParentNodeCode = ? , NodeLevel = ? , ChildFlag = ? , NodeKey = ? , RunScript = ? , NodeDesc = ? , NodeSign = ? , NodeOrder = ? , Int1 = ? , Int2 = ? , Varc1 = ? , Varc2 = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  NodeCode = ?");
/*  145 */       if ((getNodeCode() == null) || (getNodeCode().equals("null")))
/*  146 */         pstmt.setNull(1, 12);
/*      */       else {
/*  148 */         pstmt.setString(1, getNodeCode());
/*      */       }
/*  150 */       if ((getNodeName() == null) || (getNodeName().equals("null")))
/*  151 */         pstmt.setNull(2, 12);
/*      */       else {
/*  153 */         pstmt.setString(2, getNodeName());
/*      */       }
/*  155 */       if ((getParentNodeCode() == null) || (getParentNodeCode().equals("null")))
/*  156 */         pstmt.setNull(3, 12);
/*      */       else {
/*  158 */         pstmt.setString(3, getParentNodeCode());
/*      */       }
/*  160 */       if ((getNodeLevel() == null) || (getNodeLevel().equals("null")))
/*  161 */         pstmt.setNull(4, 12);
/*      */       else {
/*  163 */         pstmt.setString(4, getNodeLevel());
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
/*      */ 
/*  229 */       if ((getNodeCode() == null) || (getNodeCode().equals("null")))
/*  230 */         pstmt.setNull(20, 12);
/*      */       else {
/*  232 */         pstmt.setString(20, getNodeCode());
/*      */       }
/*  234 */       pstmt.executeUpdate();
/*  235 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  238 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  239 */       CError tError = new CError();
/*  240 */       tError.moduleName = "MMenuDB";
/*  241 */       tError.functionName = "update()";
/*  242 */       tError.errorMessage = ex.toString();
/*  243 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  246 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  249 */       if (!this.mflag)
/*      */         try {
/*  251 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  255 */       return false;
/*      */     }
/*      */ 
/*  258 */     if (!this.mflag)
/*      */       try {
/*  260 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  264 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  269 */     PreparedStatement pstmt = null;
/*      */ 
/*  271 */     if (!this.mflag) {
/*  272 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  277 */       pstmt = this.con.prepareStatement("INSERT INTO MMenu VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  278 */       if ((getNodeCode() == null) || (getNodeCode().equals("null")))
/*  279 */         pstmt.setNull(1, 12);
/*      */       else {
/*  281 */         pstmt.setString(1, getNodeCode());
/*      */       }
/*  283 */       if ((getNodeName() == null) || (getNodeName().equals("null")))
/*  284 */         pstmt.setNull(2, 12);
/*      */       else {
/*  286 */         pstmt.setString(2, getNodeName());
/*      */       }
/*  288 */       if ((getParentNodeCode() == null) || (getParentNodeCode().equals("null")))
/*  289 */         pstmt.setNull(3, 12);
/*      */       else {
/*  291 */         pstmt.setString(3, getParentNodeCode());
/*      */       }
/*  293 */       if ((getNodeLevel() == null) || (getNodeLevel().equals("null")))
/*  294 */         pstmt.setNull(4, 12);
/*      */       else {
/*  296 */         pstmt.setString(4, getNodeLevel());
/*      */       }
/*  298 */       if ((getChildFlag() == null) || (getChildFlag().equals("null")))
/*  299 */         pstmt.setNull(5, 12);
/*      */       else {
/*  301 */         pstmt.setString(5, getChildFlag());
/*      */       }
/*  303 */       if ((getNodeKey() == null) || (getNodeKey().equals("null")))
/*  304 */         pstmt.setNull(6, 12);
/*      */       else {
/*  306 */         pstmt.setString(6, getNodeKey());
/*      */       }
/*  308 */       if ((getRunScript() == null) || (getRunScript().equals("null")))
/*  309 */         pstmt.setNull(7, 12);
/*      */       else {
/*  311 */         pstmt.setString(7, getRunScript());
/*      */       }
/*  313 */       if ((getNodeDesc() == null) || (getNodeDesc().equals("null")))
/*  314 */         pstmt.setNull(8, 12);
/*      */       else {
/*  316 */         pstmt.setString(8, getNodeDesc());
/*      */       }
/*  318 */       if ((getNodeSign() == null) || (getNodeSign().equals("null")))
/*  319 */         pstmt.setNull(9, 12);
/*      */       else {
/*  321 */         pstmt.setString(9, getNodeSign());
/*      */       }
/*  323 */       pstmt.setInt(10, getNodeOrder());
/*  324 */       pstmt.setInt(11, getInt1());
/*  325 */       pstmt.setInt(12, getInt2());
/*  326 */       if ((getVarc1() == null) || (getVarc1().equals("null")))
/*  327 */         pstmt.setNull(13, 12);
/*      */       else {
/*  329 */         pstmt.setString(13, getVarc1());
/*      */       }
/*  331 */       if ((getVarc2() == null) || (getVarc2().equals("null")))
/*  332 */         pstmt.setNull(14, 12);
/*      */       else {
/*  334 */         pstmt.setString(14, getVarc2());
/*      */       }
/*  336 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  337 */         pstmt.setNull(15, 12);
/*      */       else {
/*  339 */         pstmt.setString(15, getOperator());
/*      */       }
/*  341 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  342 */         pstmt.setNull(16, 91);
/*      */       else {
/*  344 */         pstmt.setDate(16, Date.valueOf(getMakeDate()));
/*      */       }
/*  346 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  347 */         pstmt.setNull(17, 12);
/*      */       else {
/*  349 */         pstmt.setString(17, getMakeTime());
/*      */       }
/*  351 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  352 */         pstmt.setNull(18, 91);
/*      */       else {
/*  354 */         pstmt.setDate(18, Date.valueOf(getModifyDate()));
/*      */       }
/*  356 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  357 */         pstmt.setNull(19, 12);
/*      */       else {
/*  359 */         pstmt.setString(19, getModifyTime());
/*      */       }
/*      */ 
/*  362 */       pstmt.executeUpdate();
/*  363 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  366 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  367 */       CError tError = new CError();
/*  368 */       tError.moduleName = "MMenuDB";
/*  369 */       tError.functionName = "insert()";
/*  370 */       tError.errorMessage = ex.toString();
/*  371 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  374 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  377 */       if (!this.mflag)
/*      */         try {
/*  379 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  383 */       return false;
/*      */     }
/*      */ 
/*  386 */     if (!this.mflag)
/*      */       try {
/*  388 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  392 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  397 */     PreparedStatement pstmt = null;
/*  398 */     ResultSet rs = null;
/*      */ 
/*  400 */     if (!this.mflag) {
/*  401 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  406 */       pstmt = this.con.prepareStatement("SELECT * FROM MMenu WHERE  NodeCode = ?", 
/*  407 */         1003, 1007);
/*  408 */       if ((getNodeCode() == null) || (getNodeCode().equals("null")))
/*  409 */         pstmt.setNull(1, 12);
/*      */       else {
/*  411 */         pstmt.setString(1, getNodeCode());
/*      */       }
/*  413 */       rs = pstmt.executeQuery();
/*  414 */       int i = 0;
/*  415 */       if (rs.next())
/*      */       {
/*  417 */         i++;
/*  418 */         if (!setSchema(rs, i))
/*      */         {
/*  421 */           CError tError = new CError();
/*  422 */           tError.moduleName = "MMenuDB";
/*  423 */           tError.functionName = "getInfo";
/*  424 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  425 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  427 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  430 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  434 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  438 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  442 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  445 */       if (i == 0)
/*      */       {
/*  447 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  451 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  455 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  461 */       CError tError = new CError();
/*  462 */       tError.moduleName = "MMenuDB";
/*  463 */       tError.functionName = "getInfo";
/*  464 */       tError.errorMessage = e.toString();
/*  465 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  467 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  470 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  474 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  478 */       return false;
/*      */     }
/*      */ 
/*  481 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  485 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  490 */     return true;
/*      */   }
/*      */ 
/*      */   public MMenuSet query()
/*      */   {
/*  495 */     Statement stmt = null;
/*  496 */     ResultSet rs = null;
/*  497 */     MMenuSet aMMenuSet = new MMenuSet();
/*      */ 
/*  499 */     if (!this.mflag) {
/*  500 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  505 */       stmt = this.con.createStatement(1003, 1007);
/*  506 */       SQLString sqlObj = new SQLString("MMenu");
/*  507 */       MMenuSchema aSchema = getSchema();
/*  508 */       sqlObj.setSQL(5, aSchema);
/*  509 */       String sql = sqlObj.getSQL();
/*      */ 
/*  511 */       rs = stmt.executeQuery(sql);
/*  512 */       int i = 0;
/*  513 */       while (rs.next())
/*      */       {
/*  515 */         i++;
/*  516 */         MMenuSchema s1 = new MMenuSchema();
/*  517 */         s1.setSchema(rs, i);
/*  518 */         aMMenuSet.add(s1);
/*      */       }try {
/*  520 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  526 */       CError tError = new CError();
/*  527 */       tError.moduleName = "MMenuDB";
/*  528 */       tError.functionName = "query";
/*  529 */       tError.errorMessage = e.toString();
/*  530 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  532 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  535 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  539 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  545 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  549 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  554 */     return aMMenuSet;
/*      */   }
/*      */ 
/*      */   public MMenuSet executeQuery(String sql)
/*      */   {
/*  559 */     Statement stmt = null;
/*  560 */     ResultSet rs = null;
/*  561 */     MMenuSet aMMenuSet = new MMenuSet();
/*      */ 
/*  563 */     if (!this.mflag) {
/*  564 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  569 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  571 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  572 */       int i = 0;
/*  573 */       while (rs.next())
/*      */       {
/*  575 */         i++;
/*  576 */         MMenuSchema s1 = new MMenuSchema();
/*  577 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  580 */           CError tError = new CError();
/*  581 */           tError.moduleName = "MMenuDB";
/*  582 */           tError.functionName = "executeQuery";
/*  583 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  584 */           this.mErrors.addOneError(tError);
/*      */         }
/*  586 */         aMMenuSet.add(s1);
/*      */       }try {
/*  588 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  594 */       CError tError = new CError();
/*  595 */       tError.moduleName = "MMenuDB";
/*  596 */       tError.functionName = "executeQuery";
/*  597 */       tError.errorMessage = e.toString();
/*  598 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  600 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  603 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  607 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  613 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  617 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  622 */     return aMMenuSet;
/*      */   }
/*      */ 
/*      */   public MMenuSet query(int nStart, int nCount)
/*      */   {
/*  627 */     Statement stmt = null;
/*  628 */     ResultSet rs = null;
/*  629 */     MMenuSet aMMenuSet = new MMenuSet();
/*      */ 
/*  631 */     if (!this.mflag) {
/*  632 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  637 */       stmt = this.con.createStatement(1003, 1007);
/*  638 */       SQLString sqlObj = new SQLString("MMenu");
/*  639 */       MMenuSchema aSchema = getSchema();
/*  640 */       sqlObj.setSQL(5, aSchema);
/*  641 */       String sql = sqlObj.getSQL();
/*      */ 
/*  643 */       rs = stmt.executeQuery(sql);
/*  644 */       int i = 0;
/*  645 */       while (rs.next())
/*      */       {
/*  647 */         i++;
/*      */ 
/*  649 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  653 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  657 */         MMenuSchema s1 = new MMenuSchema();
/*  658 */         s1.setSchema(rs, i);
/*  659 */         aMMenuSet.add(s1);
/*      */       }try {
/*  661 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  667 */       CError tError = new CError();
/*  668 */       tError.moduleName = "MMenuDB";
/*  669 */       tError.functionName = "query";
/*  670 */       tError.errorMessage = e.toString();
/*  671 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  673 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  676 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  680 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  686 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  690 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  695 */     return aMMenuSet;
/*      */   }
/*      */ 
/*      */   public MMenuSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  700 */     Statement stmt = null;
/*  701 */     ResultSet rs = null;
/*  702 */     MMenuSet aMMenuSet = new MMenuSet();
/*      */ 
/*  704 */     if (!this.mflag) {
/*  705 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  710 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  712 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  713 */       int i = 0;
/*  714 */       while (rs.next())
/*      */       {
/*  716 */         i++;
/*      */ 
/*  718 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  722 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  726 */         MMenuSchema s1 = new MMenuSchema();
/*  727 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  730 */           CError tError = new CError();
/*  731 */           tError.moduleName = "MMenuDB";
/*  732 */           tError.functionName = "executeQuery";
/*  733 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  734 */           this.mErrors.addOneError(tError);
/*      */         }
/*  736 */         aMMenuSet.add(s1);
/*      */       }try {
/*  738 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  744 */       CError tError = new CError();
/*  745 */       tError.moduleName = "MMenuDB";
/*  746 */       tError.functionName = "executeQuery";
/*  747 */       tError.errorMessage = e.toString();
/*  748 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  750 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  753 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  757 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  763 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  767 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  772 */     return aMMenuSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  777 */     Statement stmt = null;
/*      */ 
/*  779 */     if (!this.mflag) {
/*  780 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  785 */       stmt = this.con.createStatement(1003, 1007);
/*  786 */       SQLString sqlObj = new SQLString("MMenu");
/*  787 */       MMenuSchema aSchema = getSchema();
/*  788 */       sqlObj.setSQL(2, aSchema);
/*  789 */       String sql = "update MMenu " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  791 */       int operCount = stmt.executeUpdate(sql);
/*  792 */       if (operCount == 0)
/*      */       {
/*  795 */         CError tError = new CError();
/*  796 */         tError.moduleName = "MMenuDB";
/*  797 */         tError.functionName = "update";
/*  798 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  799 */         this.mErrors.addOneError(tError);
/*      */ 
/*  801 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  805 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  809 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  815 */       CError tError = new CError();
/*  816 */       tError.moduleName = "MMenuDB";
/*  817 */       tError.functionName = "update";
/*  818 */       tError.errorMessage = e.toString();
/*  819 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  821 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  823 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  827 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  831 */       return false;
/*      */     }
/*      */ 
/*  834 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  838 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  843 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  849 */     if (this.mResultSet != null)
/*      */     {
/*  852 */       CError tError = new CError();
/*  853 */       tError.moduleName = "MMenuDB";
/*  854 */       tError.functionName = "prepareData";
/*  855 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  856 */       this.mErrors.addOneError(tError);
/*  857 */       return false;
/*      */     }
/*      */ 
/*  860 */     if (!this.mflag)
/*      */     {
/*  862 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  866 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  867 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  872 */       CError tError = new CError();
/*  873 */       tError.moduleName = "MMenuDB";
/*  874 */       tError.functionName = "prepareData";
/*  875 */       tError.errorMessage = e.toString();
/*  876 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  879 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  885 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  889 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  893 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  898 */       return false;
/*      */     }
/*      */ 
/*  901 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  905 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  910 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  916 */     boolean flag = true;
/*  917 */     if (this.mResultSet == null)
/*      */     {
/*  919 */       CError tError = new CError();
/*  920 */       tError.moduleName = "MMenuDB";
/*  921 */       tError.functionName = "hasMoreData";
/*  922 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  923 */       this.mErrors.addOneError(tError);
/*  924 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  928 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  932 */       CError tError = new CError();
/*  933 */       tError.moduleName = "MMenuDB";
/*  934 */       tError.functionName = "hasMoreData";
/*  935 */       tError.errorMessage = ex.toString();
/*  936 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  939 */         this.mResultSet.close();
/*  940 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  946 */         this.mStatement.close();
/*  947 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  951 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  955 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  960 */       return false;
/*      */     }
/*  962 */     return flag;
/*      */   }
/*      */ 
/*      */   public MMenuSet getData()
/*      */   {
/*  967 */     int tCount = 0;
/*  968 */     MMenuSet tMMenuSet = new MMenuSet();
/*  969 */     MMenuSchema tMMenuSchema = null;
/*  970 */     if (this.mResultSet == null)
/*      */     {
/*  972 */       CError tError = new CError();
/*  973 */       tError.moduleName = "MMenuDB";
/*  974 */       tError.functionName = "getData";
/*  975 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  976 */       this.mErrors.addOneError(tError);
/*  977 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  981 */       tCount = 1;
/*  982 */       tMMenuSchema = new MMenuSchema();
/*  983 */       tMMenuSchema.setSchema(this.mResultSet, 1);
/*  984 */       tMMenuSet.add(tMMenuSchema);
/*      */ 
/*  986 */       while (tCount++ < 5000)
/*      */       {
/*  988 */         if (!this.mResultSet.next())
/*      */           continue;
/*  990 */         tMMenuSchema = new MMenuSchema();
/*  991 */         tMMenuSchema.setSchema(this.mResultSet, 1);
/*  992 */         tMMenuSet.add(tMMenuSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  998 */       CError tError = new CError();
/*  999 */       tError.moduleName = "MMenuDB";
/* 1000 */       tError.functionName = "getData";
/* 1001 */       tError.errorMessage = ex.toString();
/* 1002 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1005 */         this.mResultSet.close();
/* 1006 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1012 */         this.mStatement.close();
/* 1013 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1017 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1021 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1026 */       return null;
/*      */     }
/* 1028 */     return tMMenuSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1033 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1036 */       if (this.mResultSet == null)
/*      */       {
/* 1038 */         CError tError = new CError();
/* 1039 */         tError.moduleName = "MMenuDB";
/* 1040 */         tError.functionName = "closeData";
/* 1041 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1042 */         this.mErrors.addOneError(tError);
/* 1043 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1047 */         this.mResultSet.close();
/* 1048 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1053 */       CError tError = new CError();
/* 1054 */       tError.moduleName = "MMenuDB";
/* 1055 */       tError.functionName = "closeData";
/* 1056 */       tError.errorMessage = ex2.toString();
/* 1057 */       this.mErrors.addOneError(tError);
/* 1058 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1062 */       if (this.mStatement == null)
/*      */       {
/* 1064 */         CError tError = new CError();
/* 1065 */         tError.moduleName = "MMenuDB";
/* 1066 */         tError.functionName = "closeData";
/* 1067 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1068 */         this.mErrors.addOneError(tError);
/* 1069 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1073 */         this.mStatement.close();
/* 1074 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1079 */       CError tError = new CError();
/* 1080 */       tError.moduleName = "MMenuDB";
/* 1081 */       tError.functionName = "closeData";
/* 1082 */       tError.errorMessage = ex3.toString();
/* 1083 */       this.mErrors.addOneError(tError);
/* 1084 */       flag = false;
/*      */     }
/* 1086 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MMenuDB
 * JD-Core Version:    0.6.0
 */