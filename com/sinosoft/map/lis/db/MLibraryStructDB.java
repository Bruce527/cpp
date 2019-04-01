/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MLibraryStructSchema;
/*      */ import com.sinosoft.map.lis.vschema.MLibraryStructSet;
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
/*      */ public class MLibraryStructDB extends MLibraryStructSchema
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
/*      */   public MLibraryStructDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MLibraryStruct");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MLibraryStructDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MLibraryStruct");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MLibraryStructSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MLibraryStructDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MLibraryStructSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MLibraryStructDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MLibraryStruct WHERE  NodeID = ?");
/*   96 */       if ((getNodeID() == null) || (getNodeID().equals("null")))
/*   97 */         pstmt.setNull(1, 12);
/*      */       else {
/*   99 */         pstmt.setString(1, getNodeID());
/*      */       }
/*  101 */       pstmt.executeUpdate();
/*  102 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  105 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  106 */       CError tError = new CError();
/*  107 */       tError.moduleName = "MLibraryStructDB";
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
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MLibraryStruct SET  NodeID = ? , Name = ? , ParentID = ? , Discription = ? , ManageCom = ? , BranchType = ? , Position = ? , Operation = ? , DirFlag = ? , FileFlag = ? , ChildDirNum = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  NodeID = ?");
/*  145 */       if ((getNodeID() == null) || (getNodeID().equals("null")))
/*  146 */         pstmt.setNull(1, 12);
/*      */       else {
/*  148 */         pstmt.setString(1, getNodeID());
/*      */       }
/*  150 */       if ((getName() == null) || (getName().equals("null")))
/*  151 */         pstmt.setNull(2, 12);
/*      */       else {
/*  153 */         pstmt.setString(2, getName());
/*      */       }
/*  155 */       if ((getParentID() == null) || (getParentID().equals("null")))
/*  156 */         pstmt.setNull(3, 12);
/*      */       else {
/*  158 */         pstmt.setString(3, getParentID());
/*      */       }
/*  160 */       if ((getDiscription() == null) || (getDiscription().equals("null")))
/*  161 */         pstmt.setNull(4, 12);
/*      */       else {
/*  163 */         pstmt.setString(4, getDiscription());
/*      */       }
/*  165 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  166 */         pstmt.setNull(5, 12);
/*      */       else {
/*  168 */         pstmt.setString(5, getManageCom());
/*      */       }
/*  170 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  171 */         pstmt.setNull(6, 12);
/*      */       else {
/*  173 */         pstmt.setString(6, getBranchType());
/*      */       }
/*  175 */       pstmt.setInt(7, getPosition());
/*  176 */       if ((getOperation() == null) || (getOperation().equals("null")))
/*  177 */         pstmt.setNull(8, 12);
/*      */       else {
/*  179 */         pstmt.setString(8, getOperation());
/*      */       }
/*  181 */       if ((getDirFlag() == null) || (getDirFlag().equals("null")))
/*  182 */         pstmt.setNull(9, 12);
/*      */       else {
/*  184 */         pstmt.setString(9, getDirFlag());
/*      */       }
/*  186 */       if ((getFileFlag() == null) || (getFileFlag().equals("null")))
/*  187 */         pstmt.setNull(10, 12);
/*      */       else {
/*  189 */         pstmt.setString(10, getFileFlag());
/*      */       }
/*  191 */       pstmt.setInt(11, getChildDirNum());
/*  192 */       if ((getCheckState() == null) || (getCheckState().equals("null")))
/*  193 */         pstmt.setNull(12, 12);
/*      */       else {
/*  195 */         pstmt.setString(12, getCheckState());
/*      */       }
/*  197 */       if ((getCheckOperator() == null) || (getCheckOperator().equals("null")))
/*  198 */         pstmt.setNull(13, 12);
/*      */       else {
/*  200 */         pstmt.setString(13, getCheckOperator());
/*      */       }
/*  202 */       if ((getCheckReason() == null) || (getCheckReason().equals("null")))
/*  203 */         pstmt.setNull(14, 12);
/*      */       else {
/*  205 */         pstmt.setString(14, getCheckReason());
/*      */       }
/*  207 */       if ((getCheckDate() == null) || (getCheckDate().equals("null")))
/*  208 */         pstmt.setNull(15, 91);
/*      */       else {
/*  210 */         pstmt.setDate(15, Date.valueOf(getCheckDate()));
/*      */       }
/*  212 */       if ((getCheckTime() == null) || (getCheckTime().equals("null")))
/*  213 */         pstmt.setNull(16, 12);
/*      */       else {
/*  215 */         pstmt.setString(16, getCheckTime());
/*      */       }
/*  217 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  218 */         pstmt.setNull(17, 12);
/*      */       else {
/*  220 */         pstmt.setString(17, getVF01());
/*      */       }
/*  222 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  223 */         pstmt.setNull(18, 12);
/*      */       else {
/*  225 */         pstmt.setString(18, getNF01());
/*      */       }
/*  227 */       pstmt.setInt(19, getIF01());
/*  228 */       pstmt.setDouble(20, getDF02());
/*  229 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  230 */         pstmt.setNull(21, 91);
/*      */       else {
/*  232 */         pstmt.setDate(21, Date.valueOf(getDate01()));
/*      */       }
/*  234 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  235 */         pstmt.setNull(22, 12);
/*      */       else {
/*  237 */         pstmt.setString(22, getModifyOperator());
/*      */       }
/*  239 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  240 */         pstmt.setNull(23, 12);
/*      */       else {
/*  242 */         pstmt.setString(23, getOperator());
/*      */       }
/*  244 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  245 */         pstmt.setNull(24, 91);
/*      */       else {
/*  247 */         pstmt.setDate(24, Date.valueOf(getMakeDate()));
/*      */       }
/*  249 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  250 */         pstmt.setNull(25, 12);
/*      */       else {
/*  252 */         pstmt.setString(25, getMakeTime());
/*      */       }
/*  254 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  255 */         pstmt.setNull(26, 91);
/*      */       else {
/*  257 */         pstmt.setDate(26, Date.valueOf(getModifyDate()));
/*      */       }
/*  259 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  260 */         pstmt.setNull(27, 12);
/*      */       else {
/*  262 */         pstmt.setString(27, getModifyTime());
/*      */       }
/*      */ 
/*  265 */       if ((getNodeID() == null) || (getNodeID().equals("null")))
/*  266 */         pstmt.setNull(28, 12);
/*      */       else {
/*  268 */         pstmt.setString(28, getNodeID());
/*      */       }
/*  270 */       pstmt.executeUpdate();
/*  271 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  274 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  275 */       CError tError = new CError();
/*  276 */       tError.moduleName = "MLibraryStructDB";
/*  277 */       tError.functionName = "update()";
/*  278 */       tError.errorMessage = ex.toString();
/*  279 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  282 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  285 */       if (!this.mflag)
/*      */         try {
/*  287 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  291 */       return false;
/*      */     }
/*      */ 
/*  294 */     if (!this.mflag)
/*      */       try {
/*  296 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  300 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  305 */     PreparedStatement pstmt = null;
/*      */ 
/*  307 */     if (!this.mflag) {
/*  308 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  313 */       pstmt = this.con.prepareStatement("INSERT INTO MLibraryStruct VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  314 */       if ((getNodeID() == null) || (getNodeID().equals("null")))
/*  315 */         pstmt.setNull(1, 12);
/*      */       else {
/*  317 */         pstmt.setString(1, getNodeID());
/*      */       }
/*  319 */       if ((getName() == null) || (getName().equals("null")))
/*  320 */         pstmt.setNull(2, 12);
/*      */       else {
/*  322 */         pstmt.setString(2, getName());
/*      */       }
/*  324 */       if ((getParentID() == null) || (getParentID().equals("null")))
/*  325 */         pstmt.setNull(3, 12);
/*      */       else {
/*  327 */         pstmt.setString(3, getParentID());
/*      */       }
/*  329 */       if ((getDiscription() == null) || (getDiscription().equals("null")))
/*  330 */         pstmt.setNull(4, 12);
/*      */       else {
/*  332 */         pstmt.setString(4, getDiscription());
/*      */       }
/*  334 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  335 */         pstmt.setNull(5, 12);
/*      */       else {
/*  337 */         pstmt.setString(5, getManageCom());
/*      */       }
/*  339 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  340 */         pstmt.setNull(6, 12);
/*      */       else {
/*  342 */         pstmt.setString(6, getBranchType());
/*      */       }
/*  344 */       pstmt.setInt(7, getPosition());
/*  345 */       if ((getOperation() == null) || (getOperation().equals("null")))
/*  346 */         pstmt.setNull(8, 12);
/*      */       else {
/*  348 */         pstmt.setString(8, getOperation());
/*      */       }
/*  350 */       if ((getDirFlag() == null) || (getDirFlag().equals("null")))
/*  351 */         pstmt.setNull(9, 12);
/*      */       else {
/*  353 */         pstmt.setString(9, getDirFlag());
/*      */       }
/*  355 */       if ((getFileFlag() == null) || (getFileFlag().equals("null")))
/*  356 */         pstmt.setNull(10, 12);
/*      */       else {
/*  358 */         pstmt.setString(10, getFileFlag());
/*      */       }
/*  360 */       pstmt.setInt(11, getChildDirNum());
/*  361 */       if ((getCheckState() == null) || (getCheckState().equals("null")))
/*  362 */         pstmt.setNull(12, 12);
/*      */       else {
/*  364 */         pstmt.setString(12, getCheckState());
/*      */       }
/*  366 */       if ((getCheckOperator() == null) || (getCheckOperator().equals("null")))
/*  367 */         pstmt.setNull(13, 12);
/*      */       else {
/*  369 */         pstmt.setString(13, getCheckOperator());
/*      */       }
/*  371 */       if ((getCheckReason() == null) || (getCheckReason().equals("null")))
/*  372 */         pstmt.setNull(14, 12);
/*      */       else {
/*  374 */         pstmt.setString(14, getCheckReason());
/*      */       }
/*  376 */       if ((getCheckDate() == null) || (getCheckDate().equals("null")))
/*  377 */         pstmt.setNull(15, 91);
/*      */       else {
/*  379 */         pstmt.setDate(15, Date.valueOf(getCheckDate()));
/*      */       }
/*  381 */       if ((getCheckTime() == null) || (getCheckTime().equals("null")))
/*  382 */         pstmt.setNull(16, 12);
/*      */       else {
/*  384 */         pstmt.setString(16, getCheckTime());
/*      */       }
/*  386 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  387 */         pstmt.setNull(17, 12);
/*      */       else {
/*  389 */         pstmt.setString(17, getVF01());
/*      */       }
/*  391 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  392 */         pstmt.setNull(18, 12);
/*      */       else {
/*  394 */         pstmt.setString(18, getNF01());
/*      */       }
/*  396 */       pstmt.setInt(19, getIF01());
/*  397 */       pstmt.setDouble(20, getDF02());
/*  398 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  399 */         pstmt.setNull(21, 91);
/*      */       else {
/*  401 */         pstmt.setDate(21, Date.valueOf(getDate01()));
/*      */       }
/*  403 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  404 */         pstmt.setNull(22, 12);
/*      */       else {
/*  406 */         pstmt.setString(22, getModifyOperator());
/*      */       }
/*  408 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  409 */         pstmt.setNull(23, 12);
/*      */       else {
/*  411 */         pstmt.setString(23, getOperator());
/*      */       }
/*  413 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  414 */         pstmt.setNull(24, 91);
/*      */       else {
/*  416 */         pstmt.setDate(24, Date.valueOf(getMakeDate()));
/*      */       }
/*  418 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  419 */         pstmt.setNull(25, 12);
/*      */       else {
/*  421 */         pstmt.setString(25, getMakeTime());
/*      */       }
/*  423 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  424 */         pstmt.setNull(26, 91);
/*      */       else {
/*  426 */         pstmt.setDate(26, Date.valueOf(getModifyDate()));
/*      */       }
/*  428 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  429 */         pstmt.setNull(27, 12);
/*      */       else {
/*  431 */         pstmt.setString(27, getModifyTime());
/*      */       }
/*      */ 
/*  434 */       pstmt.executeUpdate();
/*  435 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  438 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  439 */       CError tError = new CError();
/*  440 */       tError.moduleName = "MLibraryStructDB";
/*  441 */       tError.functionName = "insert()";
/*  442 */       tError.errorMessage = ex.toString();
/*  443 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  446 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  449 */       if (!this.mflag)
/*      */         try {
/*  451 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  455 */       return false;
/*      */     }
/*      */ 
/*  458 */     if (!this.mflag)
/*      */       try {
/*  460 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  464 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  469 */     PreparedStatement pstmt = null;
/*  470 */     ResultSet rs = null;
/*      */ 
/*  472 */     if (!this.mflag) {
/*  473 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  478 */       pstmt = this.con.prepareStatement("SELECT * FROM MLibraryStruct WHERE  NodeID = ?", 
/*  479 */         1003, 1007);
/*  480 */       if ((getNodeID() == null) || (getNodeID().equals("null")))
/*  481 */         pstmt.setNull(1, 12);
/*      */       else {
/*  483 */         pstmt.setString(1, getNodeID());
/*      */       }
/*  485 */       rs = pstmt.executeQuery();
/*  486 */       int i = 0;
/*  487 */       if (rs.next())
/*      */       {
/*  489 */         i++;
/*  490 */         if (!setSchema(rs, i))
/*      */         {
/*  493 */           CError tError = new CError();
/*  494 */           tError.moduleName = "MLibraryStructDB";
/*  495 */           tError.functionName = "getInfo";
/*  496 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  497 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  499 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  502 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  506 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  510 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  514 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  517 */       if (i == 0)
/*      */       {
/*  519 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  523 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  527 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  533 */       CError tError = new CError();
/*  534 */       tError.moduleName = "MLibraryStructDB";
/*  535 */       tError.functionName = "getInfo";
/*  536 */       tError.errorMessage = e.toString();
/*  537 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  539 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  542 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  546 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  550 */       return false;
/*      */     }
/*      */ 
/*  553 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  557 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  562 */     return true;
/*      */   }
/*      */ 
/*      */   public MLibraryStructSet query()
/*      */   {
/*  567 */     Statement stmt = null;
/*  568 */     ResultSet rs = null;
/*  569 */     MLibraryStructSet aMLibraryStructSet = new MLibraryStructSet();
/*      */ 
/*  571 */     if (!this.mflag) {
/*  572 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  577 */       stmt = this.con.createStatement(1003, 1007);
/*  578 */       SQLString sqlObj = new SQLString("MLibraryStruct");
/*  579 */       MLibraryStructSchema aSchema = getSchema();
/*  580 */       sqlObj.setSQL(5, aSchema);
/*  581 */       String sql = sqlObj.getSQL();
/*      */ 
/*  583 */       rs = stmt.executeQuery(sql);
/*  584 */       int i = 0;
/*  585 */       while (rs.next())
/*      */       {
/*  587 */         i++;
/*  588 */         MLibraryStructSchema s1 = new MLibraryStructSchema();
/*  589 */         s1.setSchema(rs, i);
/*  590 */         aMLibraryStructSet.add(s1);
/*      */       }try {
/*  592 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  598 */       CError tError = new CError();
/*  599 */       tError.moduleName = "MLibraryStructDB";
/*  600 */       tError.functionName = "query";
/*  601 */       tError.errorMessage = e.toString();
/*  602 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  604 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  607 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  611 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  617 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  621 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  626 */     return aMLibraryStructSet;
/*      */   }
/*      */ 
/*      */   public MLibraryStructSet executeQuery(String sql)
/*      */   {
/*  631 */     Statement stmt = null;
/*  632 */     ResultSet rs = null;
/*  633 */     MLibraryStructSet aMLibraryStructSet = new MLibraryStructSet();
/*      */ 
/*  635 */     if (!this.mflag) {
/*  636 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  641 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  643 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  644 */       int i = 0;
/*  645 */       while (rs.next())
/*      */       {
/*  647 */         i++;
/*  648 */         MLibraryStructSchema s1 = new MLibraryStructSchema();
/*  649 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  652 */           CError tError = new CError();
/*  653 */           tError.moduleName = "MLibraryStructDB";
/*  654 */           tError.functionName = "executeQuery";
/*  655 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  656 */           this.mErrors.addOneError(tError);
/*      */         }
/*  658 */         aMLibraryStructSet.add(s1);
/*      */       }try {
/*  660 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  666 */       CError tError = new CError();
/*  667 */       tError.moduleName = "MLibraryStructDB";
/*  668 */       tError.functionName = "executeQuery";
/*  669 */       tError.errorMessage = e.toString();
/*  670 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  672 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  675 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  679 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  685 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  689 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  694 */     return aMLibraryStructSet;
/*      */   }
/*      */ 
/*      */   public MLibraryStructSet query(int nStart, int nCount)
/*      */   {
/*  699 */     Statement stmt = null;
/*  700 */     ResultSet rs = null;
/*  701 */     MLibraryStructSet aMLibraryStructSet = new MLibraryStructSet();
/*      */ 
/*  703 */     if (!this.mflag) {
/*  704 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  709 */       stmt = this.con.createStatement(1003, 1007);
/*  710 */       SQLString sqlObj = new SQLString("MLibraryStruct");
/*  711 */       MLibraryStructSchema aSchema = getSchema();
/*  712 */       sqlObj.setSQL(5, aSchema);
/*  713 */       String sql = sqlObj.getSQL();
/*      */ 
/*  715 */       rs = stmt.executeQuery(sql);
/*  716 */       int i = 0;
/*  717 */       while (rs.next())
/*      */       {
/*  719 */         i++;
/*      */ 
/*  721 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  725 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  729 */         MLibraryStructSchema s1 = new MLibraryStructSchema();
/*  730 */         s1.setSchema(rs, i);
/*  731 */         aMLibraryStructSet.add(s1);
/*      */       }try {
/*  733 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  739 */       CError tError = new CError();
/*  740 */       tError.moduleName = "MLibraryStructDB";
/*  741 */       tError.functionName = "query";
/*  742 */       tError.errorMessage = e.toString();
/*  743 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  745 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  748 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  752 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  758 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  762 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  767 */     return aMLibraryStructSet;
/*      */   }
/*      */ 
/*      */   public MLibraryStructSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  772 */     Statement stmt = null;
/*  773 */     ResultSet rs = null;
/*  774 */     MLibraryStructSet aMLibraryStructSet = new MLibraryStructSet();
/*      */ 
/*  776 */     if (!this.mflag) {
/*  777 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  782 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  784 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  785 */       int i = 0;
/*  786 */       while (rs.next())
/*      */       {
/*  788 */         i++;
/*      */ 
/*  790 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  794 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  798 */         MLibraryStructSchema s1 = new MLibraryStructSchema();
/*  799 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  802 */           CError tError = new CError();
/*  803 */           tError.moduleName = "MLibraryStructDB";
/*  804 */           tError.functionName = "executeQuery";
/*  805 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  806 */           this.mErrors.addOneError(tError);
/*      */         }
/*  808 */         aMLibraryStructSet.add(s1);
/*      */       }try {
/*  810 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  816 */       CError tError = new CError();
/*  817 */       tError.moduleName = "MLibraryStructDB";
/*  818 */       tError.functionName = "executeQuery";
/*  819 */       tError.errorMessage = e.toString();
/*  820 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  822 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  825 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  829 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  835 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  839 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  844 */     return aMLibraryStructSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  849 */     Statement stmt = null;
/*      */ 
/*  851 */     if (!this.mflag) {
/*  852 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  857 */       stmt = this.con.createStatement(1003, 1007);
/*  858 */       SQLString sqlObj = new SQLString("MLibraryStruct");
/*  859 */       MLibraryStructSchema aSchema = getSchema();
/*  860 */       sqlObj.setSQL(2, aSchema);
/*  861 */       String sql = "update MLibraryStruct " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  863 */       int operCount = stmt.executeUpdate(sql);
/*  864 */       if (operCount == 0)
/*      */       {
/*  867 */         CError tError = new CError();
/*  868 */         tError.moduleName = "MLibraryStructDB";
/*  869 */         tError.functionName = "update";
/*  870 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  871 */         this.mErrors.addOneError(tError);
/*      */ 
/*  873 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  877 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  881 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  887 */       CError tError = new CError();
/*  888 */       tError.moduleName = "MLibraryStructDB";
/*  889 */       tError.functionName = "update";
/*  890 */       tError.errorMessage = e.toString();
/*  891 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  893 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  895 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  899 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  903 */       return false;
/*      */     }
/*      */ 
/*  906 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  910 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  915 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  921 */     if (this.mResultSet != null)
/*      */     {
/*  924 */       CError tError = new CError();
/*  925 */       tError.moduleName = "MLibraryStructDB";
/*  926 */       tError.functionName = "prepareData";
/*  927 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  928 */       this.mErrors.addOneError(tError);
/*  929 */       return false;
/*      */     }
/*      */ 
/*  932 */     if (!this.mflag)
/*      */     {
/*  934 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  938 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  939 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  944 */       CError tError = new CError();
/*  945 */       tError.moduleName = "MLibraryStructDB";
/*  946 */       tError.functionName = "prepareData";
/*  947 */       tError.errorMessage = e.toString();
/*  948 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  951 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  957 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  961 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  965 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  970 */       return false;
/*      */     }
/*      */ 
/*  973 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  977 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  982 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  988 */     boolean flag = true;
/*  989 */     if (this.mResultSet == null)
/*      */     {
/*  991 */       CError tError = new CError();
/*  992 */       tError.moduleName = "MLibraryStructDB";
/*  993 */       tError.functionName = "hasMoreData";
/*  994 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  995 */       this.mErrors.addOneError(tError);
/*  996 */       return false;
/*      */     }
/*      */     try
/*      */     {
/* 1000 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1004 */       CError tError = new CError();
/* 1005 */       tError.moduleName = "MLibraryStructDB";
/* 1006 */       tError.functionName = "hasMoreData";
/* 1007 */       tError.errorMessage = ex.toString();
/* 1008 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1011 */         this.mResultSet.close();
/* 1012 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1018 */         this.mStatement.close();
/* 1019 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1023 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1027 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1032 */       return false;
/*      */     }
/* 1034 */     return flag;
/*      */   }
/*      */ 
/*      */   public MLibraryStructSet getData()
/*      */   {
/* 1039 */     int tCount = 0;
/* 1040 */     MLibraryStructSet tMLibraryStructSet = new MLibraryStructSet();
/* 1041 */     MLibraryStructSchema tMLibraryStructSchema = null;
/* 1042 */     if (this.mResultSet == null)
/*      */     {
/* 1044 */       CError tError = new CError();
/* 1045 */       tError.moduleName = "MLibraryStructDB";
/* 1046 */       tError.functionName = "getData";
/* 1047 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/* 1048 */       this.mErrors.addOneError(tError);
/* 1049 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1053 */       tCount = 1;
/* 1054 */       tMLibraryStructSchema = new MLibraryStructSchema();
/* 1055 */       tMLibraryStructSchema.setSchema(this.mResultSet, 1);
/* 1056 */       tMLibraryStructSet.add(tMLibraryStructSchema);
/*      */ 
/* 1058 */       while (tCount++ < 5000)
/*      */       {
/* 1060 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1062 */         tMLibraryStructSchema = new MLibraryStructSchema();
/* 1063 */         tMLibraryStructSchema.setSchema(this.mResultSet, 1);
/* 1064 */         tMLibraryStructSet.add(tMLibraryStructSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1070 */       CError tError = new CError();
/* 1071 */       tError.moduleName = "MLibraryStructDB";
/* 1072 */       tError.functionName = "getData";
/* 1073 */       tError.errorMessage = ex.toString();
/* 1074 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1077 */         this.mResultSet.close();
/* 1078 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1084 */         this.mStatement.close();
/* 1085 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1089 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1093 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1098 */       return null;
/*      */     }
/* 1100 */     return tMLibraryStructSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1105 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1108 */       if (this.mResultSet == null)
/*      */       {
/* 1110 */         CError tError = new CError();
/* 1111 */         tError.moduleName = "MLibraryStructDB";
/* 1112 */         tError.functionName = "closeData";
/* 1113 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1114 */         this.mErrors.addOneError(tError);
/* 1115 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1119 */         this.mResultSet.close();
/* 1120 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1125 */       CError tError = new CError();
/* 1126 */       tError.moduleName = "MLibraryStructDB";
/* 1127 */       tError.functionName = "closeData";
/* 1128 */       tError.errorMessage = ex2.toString();
/* 1129 */       this.mErrors.addOneError(tError);
/* 1130 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1134 */       if (this.mStatement == null)
/*      */       {
/* 1136 */         CError tError = new CError();
/* 1137 */         tError.moduleName = "MLibraryStructDB";
/* 1138 */         tError.functionName = "closeData";
/* 1139 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1140 */         this.mErrors.addOneError(tError);
/* 1141 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1145 */         this.mStatement.close();
/* 1146 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1151 */       CError tError = new CError();
/* 1152 */       tError.moduleName = "MLibraryStructDB";
/* 1153 */       tError.functionName = "closeData";
/* 1154 */       tError.errorMessage = ex3.toString();
/* 1155 */       this.mErrors.addOneError(tError);
/* 1156 */       flag = false;
/*      */     }
/* 1158 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MLibraryStructDB
 * JD-Core Version:    0.6.0
 */