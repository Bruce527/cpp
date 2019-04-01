/*      */ package com.sinosoft.banklns.lis.db;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.schema.LNPCheckFieldSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPCheckFieldSet;
/*      */ import com.sinosoft.banklns.utility.CError;
/*      */ import com.sinosoft.banklns.utility.CErrors;
/*      */ import com.sinosoft.banklns.utility.DBConnPool;
/*      */ import com.sinosoft.banklns.utility.DBOper;
/*      */ import com.sinosoft.banklns.utility.SQLString;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.sql.Connection;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.Statement;
/*      */ 
/*      */ public class LNPCheckFieldDB extends LNPCheckFieldSchema
/*      */ {
/*      */   private Connection con;
/*      */   private DBOper db;
/*   22 */   private boolean mflag = false;
/*      */ 
/*   24 */   public CErrors mErrors = new CErrors();
/*      */ 
/*   27 */   private ResultSet mResultSet = null;
/*   28 */   private Statement mStatement = null;
/*      */ 
/*      */   public LNPCheckFieldDB(Connection tConnection)
/*      */   {
/*   32 */     this.con = tConnection;
/*   33 */     this.db = new DBOper(this.con, "LNPCheckField");
/*   34 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public LNPCheckFieldDB()
/*      */   {
/*   39 */     this.con = null;
/*   40 */     this.db = new DBOper("LNPCheckField");
/*   41 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   47 */     LNPCheckFieldSchema tSchema = getSchema();
/*   48 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   50 */       return true;
/*      */     }
/*      */ 
/*   55 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   56 */     CError tError = new CError();
/*   57 */     tError.moduleName = "LNPCheckFieldDB";
/*   58 */     tError.functionName = "deleteSQL";
/*   59 */     tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   60 */     this.mErrors.addOneError(tError);
/*   61 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   67 */     LNPCheckFieldSchema tSchema = getSchema();
/*      */ 
/*   69 */     int tCount = this.db.getCount(tSchema);
/*   70 */     if (tCount < 0)
/*      */     {
/*   73 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   74 */       CError tError = new CError();
/*   75 */       tError.moduleName = "LNPCheckFieldDB";
/*   76 */       tError.functionName = "getCount";
/*   77 */       tError.errorMessage = "\u93BF\u5D84\u7D94\u6FB6\u8FAB\u89E6!";
/*   78 */       this.mErrors.addOneError(tError);
/*      */ 
/*   80 */       return -1;
/*      */     }
/*      */ 
/*   83 */     return tCount;
/*      */   }
/*      */ 
/*      */   public boolean delete()
/*      */   {
/*   88 */     PreparedStatement pstmt = null;
/*      */ 
/*   90 */     if (!this.mflag) {
/*   91 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*   96 */       pstmt = this.con.prepareStatement("DELETE FROM LNPCheckField WHERE  RiskCode = ? AND RiskVer = ? AND FieldName = ? AND SerialNo = ?");
/*   97 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*   98 */         pstmt.setNull(1, 12);
/*      */       else {
/*  100 */         pstmt.setString(1, getRiskCode());
/*      */       }
/*  102 */       if ((getRiskVer() == null) || (getRiskVer().equals("null")))
/*  103 */         pstmt.setNull(2, 12);
/*      */       else {
/*  105 */         pstmt.setString(2, getRiskVer());
/*      */       }
/*  107 */       if ((getFieldName() == null) || (getFieldName().equals("null")))
/*  108 */         pstmt.setNull(3, 12);
/*      */       else {
/*  110 */         pstmt.setString(3, getFieldName());
/*      */       }
/*  112 */       if ((getSerialNo() == null) || (getSerialNo().equals("null")))
/*  113 */         pstmt.setNull(4, 12);
/*      */       else {
/*  115 */         pstmt.setString(4, getSerialNo());
/*      */       }
/*  117 */       pstmt.executeUpdate();
/*  118 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  121 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  122 */       CError tError = new CError();
/*  123 */       tError.moduleName = "LNPCheckFieldDB";
/*  124 */       tError.functionName = "delete()";
/*  125 */       tError.errorMessage = ex.toString();
/*  126 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  129 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  132 */       if (!this.mflag)
/*      */         try {
/*  134 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  138 */       return false;
/*      */     }
/*      */ 
/*  141 */     if (!this.mflag)
/*      */       try {
/*  143 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  147 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean update()
/*      */   {
/*  152 */     PreparedStatement pstmt = null;
/*      */ 
/*  154 */     if (!this.mflag) {
/*  155 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  160 */       pstmt = this.con.prepareStatement("UPDATE LNPCheckField SET  RiskCode = ? , RiskVer = ? , FieldName = ? , SerialNo = ? , CalCode = ? , PageLocation = ? , Location = ? , Msg = ? , MsgFlag = ? , UpdFlag = ? , ValiFlag = ? , ReturnValiFlag = ? WHERE  RiskCode = ? AND RiskVer = ? AND FieldName = ? AND SerialNo = ?");
/*  161 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  162 */         pstmt.setNull(1, 12);
/*      */       else {
/*  164 */         pstmt.setString(1, getRiskCode());
/*      */       }
/*  166 */       if ((getRiskVer() == null) || (getRiskVer().equals("null")))
/*  167 */         pstmt.setNull(2, 12);
/*      */       else {
/*  169 */         pstmt.setString(2, getRiskVer());
/*      */       }
/*  171 */       if ((getFieldName() == null) || (getFieldName().equals("null")))
/*  172 */         pstmt.setNull(3, 12);
/*      */       else {
/*  174 */         pstmt.setString(3, getFieldName());
/*      */       }
/*  176 */       if ((getSerialNo() == null) || (getSerialNo().equals("null")))
/*  177 */         pstmt.setNull(4, 12);
/*      */       else {
/*  179 */         pstmt.setString(4, getSerialNo());
/*      */       }
/*  181 */       if ((getCalCode() == null) || (getCalCode().equals("null")))
/*  182 */         pstmt.setNull(5, 12);
/*      */       else {
/*  184 */         pstmt.setString(5, getCalCode());
/*      */       }
/*  186 */       if ((getPageLocation() == null) || (getPageLocation().equals("null")))
/*  187 */         pstmt.setNull(6, 12);
/*      */       else {
/*  189 */         pstmt.setString(6, getPageLocation());
/*      */       }
/*  191 */       if ((getLocation() == null) || (getLocation().equals("null")))
/*  192 */         pstmt.setNull(7, 12);
/*      */       else {
/*  194 */         pstmt.setString(7, getLocation());
/*      */       }
/*  196 */       if ((getMsg() == null) || (getMsg().equals("null")))
/*  197 */         pstmt.setNull(8, 12);
/*      */       else {
/*  199 */         pstmt.setString(8, getMsg());
/*      */       }
/*  201 */       if ((getMsgFlag() == null) || (getMsgFlag().equals("null")))
/*  202 */         pstmt.setNull(9, 12);
/*      */       else {
/*  204 */         pstmt.setString(9, getMsgFlag());
/*      */       }
/*  206 */       if ((getUpdFlag() == null) || (getUpdFlag().equals("null")))
/*  207 */         pstmt.setNull(10, 12);
/*      */       else {
/*  209 */         pstmt.setString(10, getUpdFlag());
/*      */       }
/*  211 */       if ((getValiFlag() == null) || (getValiFlag().equals("null")))
/*  212 */         pstmt.setNull(11, 12);
/*      */       else {
/*  214 */         pstmt.setString(11, getValiFlag());
/*      */       }
/*  216 */       if ((getReturnValiFlag() == null) || (getReturnValiFlag().equals("null")))
/*  217 */         pstmt.setNull(12, 12);
/*      */       else {
/*  219 */         pstmt.setString(12, getReturnValiFlag());
/*      */       }
/*      */ 
/*  222 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  223 */         pstmt.setNull(13, 12);
/*      */       else {
/*  225 */         pstmt.setString(13, getRiskCode());
/*      */       }
/*  227 */       if ((getRiskVer() == null) || (getRiskVer().equals("null")))
/*  228 */         pstmt.setNull(14, 12);
/*      */       else {
/*  230 */         pstmt.setString(14, getRiskVer());
/*      */       }
/*  232 */       if ((getFieldName() == null) || (getFieldName().equals("null")))
/*  233 */         pstmt.setNull(15, 12);
/*      */       else {
/*  235 */         pstmt.setString(15, getFieldName());
/*      */       }
/*  237 */       if ((getSerialNo() == null) || (getSerialNo().equals("null")))
/*  238 */         pstmt.setNull(16, 12);
/*      */       else {
/*  240 */         pstmt.setString(16, getSerialNo());
/*      */       }
/*  242 */       pstmt.executeUpdate();
/*  243 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  246 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  247 */       CError tError = new CError();
/*  248 */       tError.moduleName = "LNPCheckFieldDB";
/*  249 */       tError.functionName = "update()";
/*  250 */       tError.errorMessage = ex.toString();
/*  251 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  254 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  257 */       if (!this.mflag)
/*      */         try {
/*  259 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  263 */       return false;
/*      */     }
/*      */ 
/*  266 */     if (!this.mflag)
/*      */       try {
/*  268 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  272 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  277 */     PreparedStatement pstmt = null;
/*      */ 
/*  279 */     if (!this.mflag) {
/*  280 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  285 */       pstmt = this.con.prepareStatement("INSERT INTO LNPCheckField VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  286 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  287 */         pstmt.setNull(1, 12);
/*      */       else {
/*  289 */         pstmt.setString(1, getRiskCode());
/*      */       }
/*  291 */       if ((getRiskVer() == null) || (getRiskVer().equals("null")))
/*  292 */         pstmt.setNull(2, 12);
/*      */       else {
/*  294 */         pstmt.setString(2, getRiskVer());
/*      */       }
/*  296 */       if ((getFieldName() == null) || (getFieldName().equals("null")))
/*  297 */         pstmt.setNull(3, 12);
/*      */       else {
/*  299 */         pstmt.setString(3, getFieldName());
/*      */       }
/*  301 */       if ((getSerialNo() == null) || (getSerialNo().equals("null")))
/*  302 */         pstmt.setNull(4, 12);
/*      */       else {
/*  304 */         pstmt.setString(4, getSerialNo());
/*      */       }
/*  306 */       if ((getCalCode() == null) || (getCalCode().equals("null")))
/*  307 */         pstmt.setNull(5, 12);
/*      */       else {
/*  309 */         pstmt.setString(5, getCalCode());
/*      */       }
/*  311 */       if ((getPageLocation() == null) || (getPageLocation().equals("null")))
/*  312 */         pstmt.setNull(6, 12);
/*      */       else {
/*  314 */         pstmt.setString(6, getPageLocation());
/*      */       }
/*  316 */       if ((getLocation() == null) || (getLocation().equals("null")))
/*  317 */         pstmt.setNull(7, 12);
/*      */       else {
/*  319 */         pstmt.setString(7, getLocation());
/*      */       }
/*  321 */       if ((getMsg() == null) || (getMsg().equals("null")))
/*  322 */         pstmt.setNull(8, 12);
/*      */       else {
/*  324 */         pstmt.setString(8, getMsg());
/*      */       }
/*  326 */       if ((getMsgFlag() == null) || (getMsgFlag().equals("null")))
/*  327 */         pstmt.setNull(9, 12);
/*      */       else {
/*  329 */         pstmt.setString(9, getMsgFlag());
/*      */       }
/*  331 */       if ((getUpdFlag() == null) || (getUpdFlag().equals("null")))
/*  332 */         pstmt.setNull(10, 12);
/*      */       else {
/*  334 */         pstmt.setString(10, getUpdFlag());
/*      */       }
/*  336 */       if ((getValiFlag() == null) || (getValiFlag().equals("null")))
/*  337 */         pstmt.setNull(11, 12);
/*      */       else {
/*  339 */         pstmt.setString(11, getValiFlag());
/*      */       }
/*  341 */       if ((getReturnValiFlag() == null) || (getReturnValiFlag().equals("null")))
/*  342 */         pstmt.setNull(12, 12);
/*      */       else {
/*  344 */         pstmt.setString(12, getReturnValiFlag());
/*      */       }
/*      */ 
/*  347 */       pstmt.executeUpdate();
/*  348 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  351 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  352 */       CError tError = new CError();
/*  353 */       tError.moduleName = "LNPCheckFieldDB";
/*  354 */       tError.functionName = "insert()";
/*  355 */       tError.errorMessage = ex.toString();
/*  356 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  359 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  362 */       if (!this.mflag)
/*      */         try {
/*  364 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  368 */       return false;
/*      */     }
/*      */ 
/*  371 */     if (!this.mflag)
/*      */       try {
/*  373 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  377 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  382 */     PreparedStatement pstmt = null;
/*  383 */     ResultSet rs = null;
/*      */ 
/*  385 */     if (!this.mflag) {
/*  386 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  391 */       pstmt = this.con.prepareStatement("SELECT * FROM LNPCheckField WHERE  RiskCode = ? AND RiskVer = ? AND FieldName = ? AND SerialNo = ?", 
/*  392 */         1003, 1007);
/*  393 */       if ((getRiskCode() == null) || (getRiskCode().equals("null")))
/*  394 */         pstmt.setNull(1, 12);
/*      */       else {
/*  396 */         pstmt.setString(1, getRiskCode());
/*      */       }
/*  398 */       if ((getRiskVer() == null) || (getRiskVer().equals("null")))
/*  399 */         pstmt.setNull(2, 12);
/*      */       else {
/*  401 */         pstmt.setString(2, getRiskVer());
/*      */       }
/*  403 */       if ((getFieldName() == null) || (getFieldName().equals("null")))
/*  404 */         pstmt.setNull(3, 12);
/*      */       else {
/*  406 */         pstmt.setString(3, getFieldName());
/*      */       }
/*  408 */       if ((getSerialNo() == null) || (getSerialNo().equals("null")))
/*  409 */         pstmt.setNull(4, 12);
/*      */       else {
/*  411 */         pstmt.setString(4, getSerialNo());
/*      */       }
/*  413 */       rs = pstmt.executeQuery();
/*  414 */       int i = 0;
/*  415 */       if (rs.next())
/*      */       {
/*  417 */         i++;
/*  418 */         if (!setSchema(rs, i))
/*      */         {
/*  421 */           CError tError = new CError();
/*  422 */           tError.moduleName = "LNPCheckFieldDB";
/*  423 */           tError.functionName = "getInfo";
/*  424 */           tError.errorMessage = "\u9359\u6828\u669F\u6FB6\u8FAB\u89E6!";
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
/*  462 */       tError.moduleName = "LNPCheckFieldDB";
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
/*      */   public LNPCheckFieldSet query()
/*      */   {
/*  495 */     Statement stmt = null;
/*  496 */     ResultSet rs = null;
/*  497 */     LNPCheckFieldSet aLNPCheckFieldSet = new LNPCheckFieldSet();
/*      */ 
/*  499 */     if (!this.mflag) {
/*  500 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  505 */       stmt = this.con.createStatement(1003, 1007);
/*  506 */       SQLString sqlObj = new SQLString("LNPCheckField");
/*  507 */       LNPCheckFieldSchema aSchema = getSchema();
/*  508 */       sqlObj.setSQL(5, aSchema);
/*  509 */       String sql = sqlObj.getSQL();
/*      */ 
/*  511 */       rs = stmt.executeQuery(sql);
/*  512 */       int i = 0;
/*  513 */       while (rs.next())
/*      */       {
/*  515 */         i++;
/*  516 */         LNPCheckFieldSchema s1 = new LNPCheckFieldSchema();
/*  517 */         s1.setSchema(rs, i);
/*  518 */         aLNPCheckFieldSet.add(s1);
/*      */       }try {
/*  520 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  526 */       CError tError = new CError();
/*  527 */       tError.moduleName = "LNPCheckFieldDB";
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
/*  554 */     return aLNPCheckFieldSet;
/*      */   }
/*      */ 
/*      */   public LNPCheckFieldSet executeQuery(String sql)
/*      */   {
/*  559 */     Statement stmt = null;
/*  560 */     ResultSet rs = null;
/*  561 */     LNPCheckFieldSet aLNPCheckFieldSet = new LNPCheckFieldSet();
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
/*  576 */         LNPCheckFieldSchema s1 = new LNPCheckFieldSchema();
/*  577 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  580 */           CError tError = new CError();
/*  581 */           tError.moduleName = "LNPCheckFieldDB";
/*  582 */           tError.functionName = "executeQuery";
/*  583 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  584 */           this.mErrors.addOneError(tError);
/*      */         }
/*  586 */         aLNPCheckFieldSet.add(s1);
/*      */       }try {
/*  588 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  594 */       CError tError = new CError();
/*  595 */       tError.moduleName = "LNPCheckFieldDB";
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
/*  622 */     return aLNPCheckFieldSet;
/*      */   }
/*      */ 
/*      */   public LNPCheckFieldSet query(int nStart, int nCount)
/*      */   {
/*  627 */     Statement stmt = null;
/*  628 */     ResultSet rs = null;
/*  629 */     LNPCheckFieldSet aLNPCheckFieldSet = new LNPCheckFieldSet();
/*      */ 
/*  631 */     if (!this.mflag) {
/*  632 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  637 */       stmt = this.con.createStatement(1003, 1007);
/*  638 */       SQLString sqlObj = new SQLString("LNPCheckField");
/*  639 */       LNPCheckFieldSchema aSchema = getSchema();
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
/*  657 */         LNPCheckFieldSchema s1 = new LNPCheckFieldSchema();
/*  658 */         s1.setSchema(rs, i);
/*  659 */         aLNPCheckFieldSet.add(s1);
/*      */       }try {
/*  661 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  667 */       CError tError = new CError();
/*  668 */       tError.moduleName = "LNPCheckFieldDB";
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
/*  695 */     return aLNPCheckFieldSet;
/*      */   }
/*      */ 
/*      */   public LNPCheckFieldSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  700 */     Statement stmt = null;
/*  701 */     ResultSet rs = null;
/*  702 */     LNPCheckFieldSet aLNPCheckFieldSet = new LNPCheckFieldSet();
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
/*  726 */         LNPCheckFieldSchema s1 = new LNPCheckFieldSchema();
/*  727 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  730 */           CError tError = new CError();
/*  731 */           tError.moduleName = "LNPCheckFieldDB";
/*  732 */           tError.functionName = "executeQuery";
/*  733 */           tError.errorMessage = "sql\u7487\uE15E\u5F5E\u93C8\u590E\uE1E4\u951B\u5C83\uE1EC\u93CC\u30E7\u6E45\u741B\u3125\u6095\u9359\u5A42\u74E7\u5A08\u975B\u6095\u6DC7\u2103\u4F05!";
/*  734 */           this.mErrors.addOneError(tError);
/*      */         }
/*  736 */         aLNPCheckFieldSet.add(s1);
/*      */       }try {
/*  738 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  744 */       CError tError = new CError();
/*  745 */       tError.moduleName = "LNPCheckFieldDB";
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
/*  772 */     return aLNPCheckFieldSet;
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
/*  786 */       SQLString sqlObj = new SQLString("LNPCheckField");
/*  787 */       LNPCheckFieldSchema aSchema = getSchema();
/*  788 */       sqlObj.setSQL(2, aSchema);
/*  789 */       String sql = "update LNPCheckField " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  791 */       int operCount = stmt.executeUpdate(sql);
/*  792 */       if (operCount == 0)
/*      */       {
/*  795 */         CError tError = new CError();
/*  796 */         tError.moduleName = "LNPCheckFieldDB";
/*  797 */         tError.functionName = "update";
/*  798 */         tError.errorMessage = "\u93C7\u5B58\u67CA\u93C1\u7248\u5D41\u6FB6\u8FAB\u89E6!";
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
/*  816 */       tError.moduleName = "LNPCheckFieldDB";
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
/*  853 */       tError.moduleName = "LNPCheckFieldDB";
/*  854 */       tError.functionName = "prepareData";
/*  855 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55DB\u6F6A\u7ECC\u7334\u7D1D\u7ECB\u5B2A\u7C2D\u9366\u3125\u566F\u6FB6\u56E8\u669F\u93B9\uE1C0\u6CE6\u6D94\u5B2A\u6097\u951B\u5C7E\u75C5\u93C8\u590A\u53E7\u95C2\uE168\u7D12";
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
/*  873 */       tError.moduleName = "LNPCheckFieldDB";
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
/*  920 */       tError.moduleName = "LNPCheckFieldDB";
/*  921 */       tError.functionName = "hasMoreData";
/*  922 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
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
/*  933 */       tError.moduleName = "LNPCheckFieldDB";
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
/*      */   public LNPCheckFieldSet getData()
/*      */   {
/*  967 */     int tCount = 0;
/*  968 */     LNPCheckFieldSet tLNPCheckFieldSet = new LNPCheckFieldSet();
/*  969 */     LNPCheckFieldSchema tLNPCheckFieldSchema = null;
/*  970 */     if (this.mResultSet == null)
/*      */     {
/*  972 */       CError tError = new CError();
/*  973 */       tError.moduleName = "LNPCheckFieldDB";
/*  974 */       tError.functionName = "getData";
/*  975 */       tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D5\u8D1F\u7ECC\u7334\u7D1D\u7487\u5CF0\u539B\u9351\u55D7\uE62C\u93C1\u7248\u5D41\u95C6\u55ED\u7D12";
/*  976 */       this.mErrors.addOneError(tError);
/*  977 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  981 */       tCount = 1;
/*  982 */       tLNPCheckFieldSchema = new LNPCheckFieldSchema();
/*  983 */       tLNPCheckFieldSchema.setSchema(this.mResultSet, 1);
/*  984 */       tLNPCheckFieldSet.add(tLNPCheckFieldSchema);
/*      */ 
/*  986 */       while (tCount++ < 5000)
/*      */       {
/*  988 */         if (!this.mResultSet.next())
/*      */           continue;
/*  990 */         tLNPCheckFieldSchema = new LNPCheckFieldSchema();
/*  991 */         tLNPCheckFieldSchema.setSchema(this.mResultSet, 1);
/*  992 */         tLNPCheckFieldSet.add(tLNPCheckFieldSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  998 */       CError tError = new CError();
/*  999 */       tError.moduleName = "LNPCheckFieldDB";
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
/* 1028 */     return tLNPCheckFieldSet;
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
/* 1039 */         tError.moduleName = "LNPCheckFieldDB";
/* 1040 */         tError.functionName = "closeData";
/* 1041 */         tError.errorMessage = "\u93C1\u7248\u5D41\u95C6\u55D7\u51E1\u7F01\u5FD3\u53E7\u95C2\uE15D\u7C21\u951B\uFFFD";
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
/* 1054 */       tError.moduleName = "LNPCheckFieldDB";
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
/* 1065 */         tError.moduleName = "LNPCheckFieldDB";
/* 1066 */         tError.functionName = "closeData";
/* 1067 */         tError.errorMessage = "\u7487\uE15E\u5F5E\u5BB8\u832C\u7CA1\u934F\u62BD\u68F4\u6D5C\u55ED\u7D12";
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
/* 1080 */       tError.moduleName = "LNPCheckFieldDB";
/* 1081 */       tError.functionName = "closeData";
/* 1082 */       tError.errorMessage = ex3.toString();
/* 1083 */       this.mErrors.addOneError(tError);
/* 1084 */       flag = false;
/*      */     }
/* 1086 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.db.LNPCheckFieldDB
 * JD-Core Version:    0.6.0
 */