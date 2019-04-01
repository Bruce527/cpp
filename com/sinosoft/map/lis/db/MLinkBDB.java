/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MLinkBSchema;
/*      */ import com.sinosoft.map.lis.vschema.MLinkBSet;
/*      */ import com.sinosoft.map.utility.CError;
/*      */ import com.sinosoft.map.utility.CErrors;
/*      */ import com.sinosoft.map.utility.DBConnPool;
/*      */ import com.sinosoft.map.utility.DBOper;
/*      */ import com.sinosoft.map.utility.SQLString;
/*      */ import com.sinosoft.map.utility.StrTool;
/*      */ import java.sql.Connection;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.Statement;
/*      */ 
/*      */ public class MLinkBDB extends MLinkBSchema
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
/*      */   public MLinkBDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MLinkB");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MLinkBDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MLinkB");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MLinkBSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MLinkBDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MLinkBSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MLinkBDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MLinkB WHERE  EdorNo = ?");
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
/*  107 */       tError.moduleName = "MLinkBDB";
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
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MLinkB SET  ID = ? , RefURL = ? , Target = ? , Name = ? , LinkOrder = ? , State = ? , Type = ? , AgentCode = ? , Icon = ? , ManageCom = ? , BranchType = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Description = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  EdorNo = ?");
/*  145 */       if ((getID() == null) || (getID().equals("null")))
/*  146 */         pstmt.setNull(1, 12);
/*      */       else {
/*  148 */         pstmt.setString(1, getID());
/*      */       }
/*  150 */       if ((getRefURL() == null) || (getRefURL().equals("null")))
/*  151 */         pstmt.setNull(2, 12);
/*      */       else {
/*  153 */         pstmt.setString(2, getRefURL());
/*      */       }
/*  155 */       if ((getTarget() == null) || (getTarget().equals("null")))
/*  156 */         pstmt.setNull(3, 12);
/*      */       else {
/*  158 */         pstmt.setString(3, getTarget());
/*      */       }
/*  160 */       if ((getName() == null) || (getName().equals("null")))
/*  161 */         pstmt.setNull(4, 12);
/*      */       else {
/*  163 */         pstmt.setString(4, getName());
/*      */       }
/*  165 */       pstmt.setInt(5, getLinkOrder());
/*  166 */       if ((getState() == null) || (getState().equals("null")))
/*  167 */         pstmt.setNull(6, 12);
/*      */       else {
/*  169 */         pstmt.setString(6, getState());
/*      */       }
/*  171 */       if ((getType() == null) || (getType().equals("null")))
/*  172 */         pstmt.setNull(7, 12);
/*      */       else {
/*  174 */         pstmt.setString(7, getType());
/*      */       }
/*  176 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  177 */         pstmt.setNull(8, 12);
/*      */       else {
/*  179 */         pstmt.setString(8, getAgentCode());
/*      */       }
/*  181 */       if ((getIcon() == null) || (getIcon().equals("null")))
/*  182 */         pstmt.setNull(9, 12);
/*      */       else {
/*  184 */         pstmt.setString(9, getIcon());
/*      */       }
/*  186 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  187 */         pstmt.setNull(10, 12);
/*      */       else {
/*  189 */         pstmt.setString(10, getManageCom());
/*      */       }
/*  191 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  192 */         pstmt.setNull(11, 12);
/*      */       else {
/*  194 */         pstmt.setString(11, getBranchType());
/*      */       }
/*  196 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  197 */         pstmt.setNull(12, 12);
/*      */       else {
/*  199 */         pstmt.setString(12, getVF01());
/*      */       }
/*  201 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  202 */         pstmt.setNull(13, 12);
/*      */       else {
/*  204 */         pstmt.setString(13, getNF01());
/*      */       }
/*  206 */       pstmt.setInt(14, getIF01());
/*  207 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  208 */         pstmt.setNull(17, 12);
/*      */       else {
/*  210 */         pstmt.setString(17, getModifyOperator());
/*      */       }
/*  212 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  213 */         pstmt.setNull(18, 12);
/*      */       else {
/*  215 */         pstmt.setString(18, getOperator());
/*      */       }
/*  217 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  218 */         pstmt.setNull(20, 12);
/*      */       else {
/*  220 */         pstmt.setString(20, getMakeTime());
/*      */       }
/*  222 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  223 */         pstmt.setNull(22, 12);
/*      */       else {
/*  225 */         pstmt.setString(22, getModifyTime());
/*      */       }
/*  227 */       if ((getDescription() == null) || (getDescription().equals("null")))
/*  228 */         pstmt.setNull(23, 12);
/*      */       else {
/*  230 */         pstmt.setString(23, getDescription());
/*      */       }
/*  232 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  233 */         pstmt.setNull(24, 12);
/*      */       else {
/*  235 */         pstmt.setString(24, getEdorNo());
/*      */       }
/*  237 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  238 */         pstmt.setNull(25, 12);
/*      */       else {
/*  240 */         pstmt.setString(25, getEdorType());
/*      */       }
/*  242 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  243 */         pstmt.setNull(26, 12);
/*      */       else {
/*  245 */         pstmt.setString(26, getEdorCase());
/*      */       }
/*  247 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  248 */         pstmt.setNull(27, 12);
/*      */       else {
/*  250 */         pstmt.setString(27, getOperator2());
/*      */       }
/*  252 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  253 */         pstmt.setNull(29, 12);
/*      */       else {
/*  255 */         pstmt.setString(29, getMakeTime2());
/*      */       }
/*      */ 
/*  258 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  259 */         pstmt.setNull(30, 12);
/*      */       else {
/*  261 */         pstmt.setString(30, getEdorNo());
/*      */       }
/*  263 */       pstmt.executeUpdate();
/*  264 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  267 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  268 */       CError tError = new CError();
/*  269 */       tError.moduleName = "MLinkBDB";
/*  270 */       tError.functionName = "update()";
/*  271 */       tError.errorMessage = ex.toString();
/*  272 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  275 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  278 */       if (!this.mflag)
/*      */         try {
/*  280 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  284 */       return false;
/*      */     }
/*      */ 
/*  287 */     if (!this.mflag)
/*      */       try {
/*  289 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  293 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  298 */     PreparedStatement pstmt = null;
/*      */ 
/*  300 */     if (!this.mflag) {
/*  301 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  306 */       pstmt = this.con.prepareStatement("INSERT INTO MLinkB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  307 */       if ((getID() == null) || (getID().equals("null")))
/*  308 */         pstmt.setNull(1, 12);
/*      */       else {
/*  310 */         pstmt.setString(1, getID());
/*      */       }
/*  312 */       if ((getRefURL() == null) || (getRefURL().equals("null")))
/*  313 */         pstmt.setNull(2, 12);
/*      */       else {
/*  315 */         pstmt.setString(2, getRefURL());
/*      */       }
/*  317 */       if ((getTarget() == null) || (getTarget().equals("null")))
/*  318 */         pstmt.setNull(3, 12);
/*      */       else {
/*  320 */         pstmt.setString(3, getTarget());
/*      */       }
/*  322 */       if ((getName() == null) || (getName().equals("null")))
/*  323 */         pstmt.setNull(4, 12);
/*      */       else {
/*  325 */         pstmt.setString(4, getName());
/*      */       }
/*  327 */       pstmt.setInt(5, getLinkOrder());
/*  328 */       if ((getState() == null) || (getState().equals("null")))
/*  329 */         pstmt.setNull(6, 12);
/*      */       else {
/*  331 */         pstmt.setString(6, getState());
/*      */       }
/*  333 */       if ((getType() == null) || (getType().equals("null")))
/*  334 */         pstmt.setNull(7, 12);
/*      */       else {
/*  336 */         pstmt.setString(7, getType());
/*      */       }
/*  338 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  339 */         pstmt.setNull(8, 12);
/*      */       else {
/*  341 */         pstmt.setString(8, getAgentCode());
/*      */       }
/*  343 */       if ((getIcon() == null) || (getIcon().equals("null")))
/*  344 */         pstmt.setNull(9, 12);
/*      */       else {
/*  346 */         pstmt.setString(9, getIcon());
/*      */       }
/*  348 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  349 */         pstmt.setNull(10, 12);
/*      */       else {
/*  351 */         pstmt.setString(10, getManageCom());
/*      */       }
/*  353 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  354 */         pstmt.setNull(11, 12);
/*      */       else {
/*  356 */         pstmt.setString(11, getBranchType());
/*      */       }
/*  358 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  359 */         pstmt.setNull(12, 12);
/*      */       else {
/*  361 */         pstmt.setString(12, getVF01());
/*      */       }
/*  363 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  364 */         pstmt.setNull(13, 12);
/*      */       else {
/*  366 */         pstmt.setString(13, getNF01());
/*      */       }
/*  368 */       pstmt.setInt(14, getIF01());
/*  369 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  370 */         pstmt.setNull(17, 12);
/*      */       else {
/*  372 */         pstmt.setString(17, getModifyOperator());
/*      */       }
/*  374 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  375 */         pstmt.setNull(18, 12);
/*      */       else {
/*  377 */         pstmt.setString(18, getOperator());
/*      */       }
/*  379 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  380 */         pstmt.setNull(20, 12);
/*      */       else {
/*  382 */         pstmt.setString(20, getMakeTime());
/*      */       }
/*  384 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  385 */         pstmt.setNull(22, 12);
/*      */       else {
/*  387 */         pstmt.setString(22, getModifyTime());
/*      */       }
/*  389 */       if ((getDescription() == null) || (getDescription().equals("null")))
/*  390 */         pstmt.setNull(23, 12);
/*      */       else {
/*  392 */         pstmt.setString(23, getDescription());
/*      */       }
/*  394 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  395 */         pstmt.setNull(24, 12);
/*      */       else {
/*  397 */         pstmt.setString(24, getEdorNo());
/*      */       }
/*  399 */       if ((getEdorType() == null) || (getEdorType().equals("null")))
/*  400 */         pstmt.setNull(25, 12);
/*      */       else {
/*  402 */         pstmt.setString(25, getEdorType());
/*      */       }
/*  404 */       if ((getEdorCase() == null) || (getEdorCase().equals("null")))
/*  405 */         pstmt.setNull(26, 12);
/*      */       else {
/*  407 */         pstmt.setString(26, getEdorCase());
/*      */       }
/*  409 */       if ((getOperator2() == null) || (getOperator2().equals("null")))
/*  410 */         pstmt.setNull(27, 12);
/*      */       else {
/*  412 */         pstmt.setString(27, getOperator2());
/*      */       }
/*  414 */       if ((getMakeTime2() == null) || (getMakeTime2().equals("null")))
/*  415 */         pstmt.setNull(29, 12);
/*      */       else {
/*  417 */         pstmt.setString(29, getMakeTime2());
/*      */       }
/*      */ 
/*  420 */       pstmt.executeUpdate();
/*  421 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  424 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  425 */       CError tError = new CError();
/*  426 */       tError.moduleName = "MLinkBDB";
/*  427 */       tError.functionName = "insert()";
/*  428 */       tError.errorMessage = ex.toString();
/*  429 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  432 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  435 */       if (!this.mflag)
/*      */         try {
/*  437 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  441 */       return false;
/*      */     }
/*      */ 
/*  444 */     if (!this.mflag)
/*      */       try {
/*  446 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  450 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  455 */     PreparedStatement pstmt = null;
/*  456 */     ResultSet rs = null;
/*      */ 
/*  458 */     if (!this.mflag) {
/*  459 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  464 */       pstmt = this.con.prepareStatement("SELECT * FROM MLinkB WHERE  EdorNo = ?", 
/*  465 */         1003, 1007);
/*  466 */       if ((getEdorNo() == null) || (getEdorNo().equals("null")))
/*  467 */         pstmt.setNull(1, 12);
/*      */       else {
/*  469 */         pstmt.setString(1, getEdorNo());
/*      */       }
/*  471 */       rs = pstmt.executeQuery();
/*  472 */       int i = 0;
/*  473 */       if (rs.next())
/*      */       {
/*  475 */         i++;
/*  476 */         if (!setSchema(rs, i))
/*      */         {
/*  479 */           CError tError = new CError();
/*  480 */           tError.moduleName = "MLinkBDB";
/*  481 */           tError.functionName = "getInfo";
/*  482 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  483 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  485 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  488 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  492 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  496 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  500 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  503 */       if (i == 0)
/*      */       {
/*  505 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  509 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  513 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  519 */       CError tError = new CError();
/*  520 */       tError.moduleName = "MLinkBDB";
/*  521 */       tError.functionName = "getInfo";
/*  522 */       tError.errorMessage = e.toString();
/*  523 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  525 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  528 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  532 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  536 */       return false;
/*      */     }
/*      */ 
/*  539 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  543 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  548 */     return true;
/*      */   }
/*      */ 
/*      */   public MLinkBSet query()
/*      */   {
/*  553 */     Statement stmt = null;
/*  554 */     ResultSet rs = null;
/*  555 */     MLinkBSet aMLinkBSet = new MLinkBSet();
/*      */ 
/*  557 */     if (!this.mflag) {
/*  558 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  563 */       stmt = this.con.createStatement(1003, 1007);
/*  564 */       SQLString sqlObj = new SQLString("MLinkB");
/*  565 */       MLinkBSchema aSchema = getSchema();
/*  566 */       sqlObj.setSQL(5, aSchema);
/*  567 */       String sql = sqlObj.getSQL();
/*      */ 
/*  569 */       rs = stmt.executeQuery(sql);
/*  570 */       int i = 0;
/*  571 */       while (rs.next())
/*      */       {
/*  573 */         i++;
/*  574 */         MLinkBSchema s1 = new MLinkBSchema();
/*  575 */         s1.setSchema(rs, i);
/*  576 */         aMLinkBSet.add(s1);
/*      */       }try {
/*  578 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  584 */       CError tError = new CError();
/*  585 */       tError.moduleName = "MLinkBDB";
/*  586 */       tError.functionName = "query";
/*  587 */       tError.errorMessage = e.toString();
/*  588 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  590 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  593 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  597 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  603 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  607 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  612 */     return aMLinkBSet;
/*      */   }
/*      */ 
/*      */   public MLinkBSet executeQuery(String sql)
/*      */   {
/*  617 */     Statement stmt = null;
/*  618 */     ResultSet rs = null;
/*  619 */     MLinkBSet aMLinkBSet = new MLinkBSet();
/*      */ 
/*  621 */     if (!this.mflag) {
/*  622 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  627 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  629 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  630 */       int i = 0;
/*  631 */       while (rs.next())
/*      */       {
/*  633 */         i++;
/*  634 */         MLinkBSchema s1 = new MLinkBSchema();
/*  635 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  638 */           CError tError = new CError();
/*  639 */           tError.moduleName = "MLinkBDB";
/*  640 */           tError.functionName = "executeQuery";
/*  641 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  642 */           this.mErrors.addOneError(tError);
/*      */         }
/*  644 */         aMLinkBSet.add(s1);
/*      */       }try {
/*  646 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  652 */       CError tError = new CError();
/*  653 */       tError.moduleName = "MLinkBDB";
/*  654 */       tError.functionName = "executeQuery";
/*  655 */       tError.errorMessage = e.toString();
/*  656 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  658 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  661 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  665 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  671 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  675 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  680 */     return aMLinkBSet;
/*      */   }
/*      */ 
/*      */   public MLinkBSet query(int nStart, int nCount)
/*      */   {
/*  685 */     Statement stmt = null;
/*  686 */     ResultSet rs = null;
/*  687 */     MLinkBSet aMLinkBSet = new MLinkBSet();
/*      */ 
/*  689 */     if (!this.mflag) {
/*  690 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  695 */       stmt = this.con.createStatement(1003, 1007);
/*  696 */       SQLString sqlObj = new SQLString("MLinkB");
/*  697 */       MLinkBSchema aSchema = getSchema();
/*  698 */       sqlObj.setSQL(5, aSchema);
/*  699 */       String sql = sqlObj.getSQL();
/*      */ 
/*  701 */       rs = stmt.executeQuery(sql);
/*  702 */       int i = 0;
/*  703 */       while (rs.next())
/*      */       {
/*  705 */         i++;
/*      */ 
/*  707 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  711 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  715 */         MLinkBSchema s1 = new MLinkBSchema();
/*  716 */         s1.setSchema(rs, i);
/*  717 */         aMLinkBSet.add(s1);
/*      */       }try {
/*  719 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  725 */       CError tError = new CError();
/*  726 */       tError.moduleName = "MLinkBDB";
/*  727 */       tError.functionName = "query";
/*  728 */       tError.errorMessage = e.toString();
/*  729 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  731 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  734 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  738 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  744 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  748 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  753 */     return aMLinkBSet;
/*      */   }
/*      */ 
/*      */   public MLinkBSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  758 */     Statement stmt = null;
/*  759 */     ResultSet rs = null;
/*  760 */     MLinkBSet aMLinkBSet = new MLinkBSet();
/*      */ 
/*  762 */     if (!this.mflag) {
/*  763 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  768 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  770 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  771 */       int i = 0;
/*  772 */       while (rs.next())
/*      */       {
/*  774 */         i++;
/*      */ 
/*  776 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  780 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  784 */         MLinkBSchema s1 = new MLinkBSchema();
/*  785 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  788 */           CError tError = new CError();
/*  789 */           tError.moduleName = "MLinkBDB";
/*  790 */           tError.functionName = "executeQuery";
/*  791 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  792 */           this.mErrors.addOneError(tError);
/*      */         }
/*  794 */         aMLinkBSet.add(s1);
/*      */       }try {
/*  796 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  802 */       CError tError = new CError();
/*  803 */       tError.moduleName = "MLinkBDB";
/*  804 */       tError.functionName = "executeQuery";
/*  805 */       tError.errorMessage = e.toString();
/*  806 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  808 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  811 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  815 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  821 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  825 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  830 */     return aMLinkBSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  835 */     Statement stmt = null;
/*      */ 
/*  837 */     if (!this.mflag) {
/*  838 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  843 */       stmt = this.con.createStatement(1003, 1007);
/*  844 */       SQLString sqlObj = new SQLString("MLinkB");
/*  845 */       MLinkBSchema aSchema = getSchema();
/*  846 */       sqlObj.setSQL(2, aSchema);
/*  847 */       String sql = "update MLinkB " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  849 */       int operCount = stmt.executeUpdate(sql);
/*  850 */       if (operCount == 0)
/*      */       {
/*  853 */         CError tError = new CError();
/*  854 */         tError.moduleName = "MLinkBDB";
/*  855 */         tError.functionName = "update";
/*  856 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  857 */         this.mErrors.addOneError(tError);
/*      */ 
/*  859 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  863 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  867 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  873 */       CError tError = new CError();
/*  874 */       tError.moduleName = "MLinkBDB";
/*  875 */       tError.functionName = "update";
/*  876 */       tError.errorMessage = e.toString();
/*  877 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  879 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  881 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  885 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  889 */       return false;
/*      */     }
/*      */ 
/*  892 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  896 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  901 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  907 */     if (this.mResultSet != null)
/*      */     {
/*  910 */       CError tError = new CError();
/*  911 */       tError.moduleName = "MLinkBDB";
/*  912 */       tError.functionName = "prepareData";
/*  913 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  914 */       this.mErrors.addOneError(tError);
/*  915 */       return false;
/*      */     }
/*      */ 
/*  918 */     if (!this.mflag)
/*      */     {
/*  920 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  924 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  925 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  930 */       CError tError = new CError();
/*  931 */       tError.moduleName = "MLinkBDB";
/*  932 */       tError.functionName = "prepareData";
/*  933 */       tError.errorMessage = e.toString();
/*  934 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  937 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  943 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  947 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  951 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  956 */       return false;
/*      */     }
/*      */ 
/*  959 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  963 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  968 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  974 */     boolean flag = true;
/*  975 */     if (this.mResultSet == null)
/*      */     {
/*  977 */       CError tError = new CError();
/*  978 */       tError.moduleName = "MLinkBDB";
/*  979 */       tError.functionName = "hasMoreData";
/*  980 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  981 */       this.mErrors.addOneError(tError);
/*  982 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  986 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  990 */       CError tError = new CError();
/*  991 */       tError.moduleName = "MLinkBDB";
/*  992 */       tError.functionName = "hasMoreData";
/*  993 */       tError.errorMessage = ex.toString();
/*  994 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  997 */         this.mResultSet.close();
/*  998 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1004 */         this.mStatement.close();
/* 1005 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1009 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1013 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1018 */       return false;
/*      */     }
/* 1020 */     return flag;
/*      */   }
/*      */ 
/*      */   public MLinkBSet getData()
/*      */   {
/* 1025 */     int tCount = 0;
/* 1026 */     MLinkBSet tMLinkBSet = new MLinkBSet();
/* 1027 */     MLinkBSchema tMLinkBSchema = null;
/* 1028 */     if (this.mResultSet == null)
/*      */     {
/* 1030 */       CError tError = new CError();
/* 1031 */       tError.moduleName = "MLinkBDB";
/* 1032 */       tError.functionName = "getData";
/* 1033 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1034 */       this.mErrors.addOneError(tError);
/* 1035 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1039 */       tCount = 1;
/* 1040 */       tMLinkBSchema = new MLinkBSchema();
/* 1041 */       tMLinkBSchema.setSchema(this.mResultSet, 1);
/* 1042 */       tMLinkBSet.add(tMLinkBSchema);
/*      */ 
/* 1044 */       while (tCount++ < 5000)
/*      */       {
/* 1046 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1048 */         tMLinkBSchema = new MLinkBSchema();
/* 1049 */         tMLinkBSchema.setSchema(this.mResultSet, 1);
/* 1050 */         tMLinkBSet.add(tMLinkBSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1056 */       CError tError = new CError();
/* 1057 */       tError.moduleName = "MLinkBDB";
/* 1058 */       tError.functionName = "getData";
/* 1059 */       tError.errorMessage = ex.toString();
/* 1060 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1063 */         this.mResultSet.close();
/* 1064 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1070 */         this.mStatement.close();
/* 1071 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1075 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1079 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1084 */       return null;
/*      */     }
/* 1086 */     return tMLinkBSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1091 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1094 */       if (this.mResultSet == null)
/*      */       {
/* 1096 */         CError tError = new CError();
/* 1097 */         tError.moduleName = "MLinkBDB";
/* 1098 */         tError.functionName = "closeData";
/* 1099 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1100 */         this.mErrors.addOneError(tError);
/* 1101 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1105 */         this.mResultSet.close();
/* 1106 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1111 */       CError tError = new CError();
/* 1112 */       tError.moduleName = "MLinkBDB";
/* 1113 */       tError.functionName = "closeData";
/* 1114 */       tError.errorMessage = ex2.toString();
/* 1115 */       this.mErrors.addOneError(tError);
/* 1116 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1120 */       if (this.mStatement == null)
/*      */       {
/* 1122 */         CError tError = new CError();
/* 1123 */         tError.moduleName = "MLinkBDB";
/* 1124 */         tError.functionName = "closeData";
/* 1125 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1126 */         this.mErrors.addOneError(tError);
/* 1127 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1131 */         this.mStatement.close();
/* 1132 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1137 */       CError tError = new CError();
/* 1138 */       tError.moduleName = "MLinkBDB";
/* 1139 */       tError.functionName = "closeData";
/* 1140 */       tError.errorMessage = ex3.toString();
/* 1141 */       this.mErrors.addOneError(tError);
/* 1142 */       flag = false;
/*      */     }
/* 1144 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MLinkBDB
 * JD-Core Version:    0.6.0
 */