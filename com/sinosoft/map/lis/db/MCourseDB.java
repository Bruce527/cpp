/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MCourseSchema;
/*      */ import com.sinosoft.map.lis.vschema.MCourseSet;
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
/*      */ public class MCourseDB extends MCourseSchema
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
/*      */   public MCourseDB(Connection tConnection)
/*      */   {
/*   31 */     this.con = tConnection;
/*   32 */     this.db = new DBOper(this.con, "MCourse");
/*   33 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MCourseDB()
/*      */   {
/*   38 */     this.con = null;
/*   39 */     this.db = new DBOper("MCourse");
/*   40 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   46 */     MCourseSchema tSchema = getSchema();
/*   47 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   49 */       return true;
/*      */     }
/*      */ 
/*   54 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   55 */     CError tError = new CError();
/*   56 */     tError.moduleName = "MCourseDB";
/*   57 */     tError.functionName = "deleteSQL";
/*   58 */     tError.errorMessage = "\u64CD\u4F5C\u5931\u8D25!";
/*   59 */     this.mErrors.addOneError(tError);
/*   60 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   66 */     MCourseSchema tSchema = getSchema();
/*      */ 
/*   68 */     int tCount = this.db.getCount(tSchema);
/*   69 */     if (tCount < 0)
/*      */     {
/*   72 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   73 */       CError tError = new CError();
/*   74 */       tError.moduleName = "MCourseDB";
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
/*   95 */       pstmt = this.con.prepareStatement("DELETE FROM MCourse WHERE  ID = ?");
/*   96 */       if ((getID() == null) || (getID().equals("null")))
/*   97 */         pstmt.setNull(1, 12);
/*      */       else {
/*   99 */         pstmt.setString(1, getID());
/*      */       }
/*  101 */       pstmt.executeUpdate();
/*  102 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  105 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  106 */       CError tError = new CError();
/*  107 */       tError.moduleName = "MCourseDB";
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
/*  144 */       pstmt = this.con.prepareStatement("UPDATE MCourse SET  ID = ? , CourseID = ? , CourseName = ? , ManageCom = ? , BranchType = ? , Hour = ? , DevelopBranch = ? , Developer = ? , DevelopeDate = ? , NoTi = ? , Operator = ? , ModifyOperator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , course1 = ? , course2 = ? , course3 = ? , course4 = ? WHERE  ID = ?");
/*  145 */       if ((getID() == null) || (getID().equals("null")))
/*  146 */         pstmt.setNull(1, 12);
/*      */       else {
/*  148 */         pstmt.setString(1, getID());
/*      */       }
/*  150 */       if ((getCourseID() == null) || (getCourseID().equals("null")))
/*  151 */         pstmt.setNull(2, 12);
/*      */       else {
/*  153 */         pstmt.setString(2, getCourseID());
/*      */       }
/*  155 */       if ((getCourseName() == null) || (getCourseName().equals("null")))
/*  156 */         pstmt.setNull(3, 12);
/*      */       else {
/*  158 */         pstmt.setString(3, getCourseName());
/*      */       }
/*  160 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  161 */         pstmt.setNull(4, 12);
/*      */       else {
/*  163 */         pstmt.setString(4, getManageCom());
/*      */       }
/*  165 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  166 */         pstmt.setNull(5, 12);
/*      */       else {
/*  168 */         pstmt.setString(5, getBranchType());
/*      */       }
/*  170 */       if ((getHour() == null) || (getHour().equals("null")))
/*  171 */         pstmt.setNull(6, 12);
/*      */       else {
/*  173 */         pstmt.setString(6, getHour());
/*      */       }
/*  175 */       if ((getDevelopBranch() == null) || (getDevelopBranch().equals("null")))
/*  176 */         pstmt.setNull(7, 12);
/*      */       else {
/*  178 */         pstmt.setString(7, getDevelopBranch());
/*      */       }
/*  180 */       if ((getDeveloper() == null) || (getDeveloper().equals("null")))
/*  181 */         pstmt.setNull(8, 12);
/*      */       else {
/*  183 */         pstmt.setString(8, getDeveloper());
/*      */       }
/*  185 */       if ((getNoTi() == null) || (getNoTi().equals("null")))
/*  186 */         pstmt.setNull(10, 12);
/*      */       else {
/*  188 */         pstmt.setString(10, getNoTi());
/*      */       }
/*  190 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  191 */         pstmt.setNull(11, 12);
/*      */       else {
/*  193 */         pstmt.setString(11, getOperator());
/*      */       }
/*  195 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  196 */         pstmt.setNull(12, 12);
/*      */       else {
/*  198 */         pstmt.setString(12, getModifyOperator());
/*      */       }
/*  200 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  201 */         pstmt.setNull(14, 12);
/*      */       else {
/*  203 */         pstmt.setString(14, getMakeTime());
/*      */       }
/*  205 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  206 */         pstmt.setNull(16, 12);
/*      */       else {
/*  208 */         pstmt.setString(16, getModifyTime());
/*      */       }
/*  210 */       if ((getCourse1() == null) || (getCourse1().equals("null")))
/*  211 */         pstmt.setNull(17, 12);
/*      */       else {
/*  213 */         pstmt.setString(17, getCourse1());
/*      */       }
/*  215 */       if ((getCourse2() == null) || (getCourse2().equals("null")))
/*  216 */         pstmt.setNull(18, 12);
/*      */       else {
/*  218 */         pstmt.setString(18, getCourse2());
/*      */       }
/*  220 */       if ((getCourse3() == null) || (getCourse3().equals("null")))
/*  221 */         pstmt.setNull(19, 12);
/*      */       else {
/*  223 */         pstmt.setString(19, getCourse3());
/*      */       }
/*      */ 
/*  226 */       if ((getID() == null) || (getID().equals("null")))
/*  227 */         pstmt.setNull(21, 12);
/*      */       else {
/*  229 */         pstmt.setString(21, getID());
/*      */       }
/*  231 */       pstmt.executeUpdate();
/*  232 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  235 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  236 */       CError tError = new CError();
/*  237 */       tError.moduleName = "MCourseDB";
/*  238 */       tError.functionName = "update()";
/*  239 */       tError.errorMessage = ex.toString();
/*  240 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  243 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  246 */       if (!this.mflag)
/*      */         try {
/*  248 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  252 */       return false;
/*      */     }
/*      */ 
/*  255 */     if (!this.mflag)
/*      */       try {
/*  257 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  261 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  266 */     PreparedStatement pstmt = null;
/*      */ 
/*  268 */     if (!this.mflag) {
/*  269 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  274 */       pstmt = this.con.prepareStatement("INSERT INTO MCourse VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  275 */       if ((getID() == null) || (getID().equals("null")))
/*  276 */         pstmt.setNull(1, 12);
/*      */       else {
/*  278 */         pstmt.setString(1, getID());
/*      */       }
/*  280 */       if ((getCourseID() == null) || (getCourseID().equals("null")))
/*  281 */         pstmt.setNull(2, 12);
/*      */       else {
/*  283 */         pstmt.setString(2, getCourseID());
/*      */       }
/*  285 */       if ((getCourseName() == null) || (getCourseName().equals("null")))
/*  286 */         pstmt.setNull(3, 12);
/*      */       else {
/*  288 */         pstmt.setString(3, getCourseName());
/*      */       }
/*  290 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  291 */         pstmt.setNull(4, 12);
/*      */       else {
/*  293 */         pstmt.setString(4, getManageCom());
/*      */       }
/*  295 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  296 */         pstmt.setNull(5, 12);
/*      */       else {
/*  298 */         pstmt.setString(5, getBranchType());
/*      */       }
/*  300 */       if ((getHour() == null) || (getHour().equals("null")))
/*  301 */         pstmt.setNull(6, 12);
/*      */       else {
/*  303 */         pstmt.setString(6, getHour());
/*      */       }
/*  305 */       if ((getDevelopBranch() == null) || (getDevelopBranch().equals("null")))
/*  306 */         pstmt.setNull(7, 12);
/*      */       else {
/*  308 */         pstmt.setString(7, getDevelopBranch());
/*      */       }
/*  310 */       if ((getDeveloper() == null) || (getDeveloper().equals("null")))
/*  311 */         pstmt.setNull(8, 12);
/*      */       else {
/*  313 */         pstmt.setString(8, getDeveloper());
/*      */       }
/*  315 */       if ((getNoTi() == null) || (getNoTi().equals("null")))
/*  316 */         pstmt.setNull(10, 12);
/*      */       else {
/*  318 */         pstmt.setString(10, getNoTi());
/*      */       }
/*  320 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  321 */         pstmt.setNull(11, 12);
/*      */       else {
/*  323 */         pstmt.setString(11, getOperator());
/*      */       }
/*  325 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  326 */         pstmt.setNull(12, 12);
/*      */       else {
/*  328 */         pstmt.setString(12, getModifyOperator());
/*      */       }
/*  330 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  331 */         pstmt.setNull(14, 12);
/*      */       else {
/*  333 */         pstmt.setString(14, getMakeTime());
/*      */       }
/*  335 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  336 */         pstmt.setNull(16, 12);
/*      */       else {
/*  338 */         pstmt.setString(16, getModifyTime());
/*      */       }
/*  340 */       if ((getCourse1() == null) || (getCourse1().equals("null")))
/*  341 */         pstmt.setNull(17, 12);
/*      */       else {
/*  343 */         pstmt.setString(17, getCourse1());
/*      */       }
/*  345 */       if ((getCourse2() == null) || (getCourse2().equals("null")))
/*  346 */         pstmt.setNull(18, 12);
/*      */       else {
/*  348 */         pstmt.setString(18, getCourse2());
/*      */       }
/*  350 */       if ((getCourse3() == null) || (getCourse3().equals("null")))
/*  351 */         pstmt.setNull(19, 12);
/*      */       else {
/*  353 */         pstmt.setString(19, getCourse3());
/*      */       }
/*      */ 
/*  356 */       pstmt.executeUpdate();
/*  357 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  360 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  361 */       CError tError = new CError();
/*  362 */       tError.moduleName = "MCourseDB";
/*  363 */       tError.functionName = "insert()";
/*  364 */       tError.errorMessage = ex.toString();
/*  365 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  368 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  371 */       if (!this.mflag)
/*      */         try {
/*  373 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  377 */       return false;
/*      */     }
/*      */ 
/*  380 */     if (!this.mflag)
/*      */       try {
/*  382 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  386 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  391 */     PreparedStatement pstmt = null;
/*  392 */     ResultSet rs = null;
/*      */ 
/*  394 */     if (!this.mflag) {
/*  395 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  400 */       pstmt = this.con.prepareStatement("SELECT * FROM MCourse WHERE  ID = ?", 
/*  401 */         1003, 1007);
/*  402 */       if ((getID() == null) || (getID().equals("null")))
/*  403 */         pstmt.setNull(1, 12);
/*      */       else {
/*  405 */         pstmt.setString(1, getID());
/*      */       }
/*  407 */       rs = pstmt.executeQuery();
/*  408 */       int i = 0;
/*  409 */       if (rs.next())
/*      */       {
/*  411 */         i++;
/*  412 */         if (!setSchema(rs, i))
/*      */         {
/*  415 */           CError tError = new CError();
/*  416 */           tError.moduleName = "MCourseDB";
/*  417 */           tError.functionName = "getInfo";
/*  418 */           tError.errorMessage = "\u53D6\u6570\u5931\u8D25!";
/*  419 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  421 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  424 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  428 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  432 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  436 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  439 */       if (i == 0)
/*      */       {
/*  441 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  445 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  449 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  455 */       CError tError = new CError();
/*  456 */       tError.moduleName = "MCourseDB";
/*  457 */       tError.functionName = "getInfo";
/*  458 */       tError.errorMessage = e.toString();
/*  459 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  461 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  464 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  468 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  472 */       return false;
/*      */     }
/*      */ 
/*  475 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  479 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  484 */     return true;
/*      */   }
/*      */ 
/*      */   public MCourseSet query()
/*      */   {
/*  489 */     Statement stmt = null;
/*  490 */     ResultSet rs = null;
/*  491 */     MCourseSet aMCourseSet = new MCourseSet();
/*      */ 
/*  493 */     if (!this.mflag) {
/*  494 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  499 */       stmt = this.con.createStatement(1003, 1007);
/*  500 */       SQLString sqlObj = new SQLString("MCourse");
/*  501 */       MCourseSchema aSchema = getSchema();
/*  502 */       sqlObj.setSQL(5, aSchema);
/*  503 */       String sql = sqlObj.getSQL();
/*      */ 
/*  505 */       rs = stmt.executeQuery(sql);
/*  506 */       int i = 0;
/*  507 */       while (rs.next())
/*      */       {
/*  509 */         i++;
/*  510 */         MCourseSchema s1 = new MCourseSchema();
/*  511 */         s1.setSchema(rs, i);
/*  512 */         aMCourseSet.add(s1);
/*      */       }try {
/*  514 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  520 */       CError tError = new CError();
/*  521 */       tError.moduleName = "MCourseDB";
/*  522 */       tError.functionName = "query";
/*  523 */       tError.errorMessage = e.toString();
/*  524 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  526 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  529 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  533 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  539 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  543 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  548 */     return aMCourseSet;
/*      */   }
/*      */ 
/*      */   public MCourseSet executeQuery(String sql)
/*      */   {
/*  553 */     Statement stmt = null;
/*  554 */     ResultSet rs = null;
/*  555 */     MCourseSet aMCourseSet = new MCourseSet();
/*      */ 
/*  557 */     if (!this.mflag) {
/*  558 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  563 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  565 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  566 */       int i = 0;
/*  567 */       while (rs.next())
/*      */       {
/*  569 */         i++;
/*  570 */         MCourseSchema s1 = new MCourseSchema();
/*  571 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  574 */           CError tError = new CError();
/*  575 */           tError.moduleName = "MCourseDB";
/*  576 */           tError.functionName = "executeQuery";
/*  577 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  578 */           this.mErrors.addOneError(tError);
/*      */         }
/*  580 */         aMCourseSet.add(s1);
/*      */       }try {
/*  582 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  588 */       CError tError = new CError();
/*  589 */       tError.moduleName = "MCourseDB";
/*  590 */       tError.functionName = "executeQuery";
/*  591 */       tError.errorMessage = e.toString();
/*  592 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  594 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  597 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  601 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  607 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  611 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  616 */     return aMCourseSet;
/*      */   }
/*      */ 
/*      */   public MCourseSet query(int nStart, int nCount)
/*      */   {
/*  621 */     Statement stmt = null;
/*  622 */     ResultSet rs = null;
/*  623 */     MCourseSet aMCourseSet = new MCourseSet();
/*      */ 
/*  625 */     if (!this.mflag) {
/*  626 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  631 */       stmt = this.con.createStatement(1003, 1007);
/*  632 */       SQLString sqlObj = new SQLString("MCourse");
/*  633 */       MCourseSchema aSchema = getSchema();
/*  634 */       sqlObj.setSQL(5, aSchema);
/*  635 */       String sql = sqlObj.getSQL();
/*      */ 
/*  637 */       rs = stmt.executeQuery(sql);
/*  638 */       int i = 0;
/*  639 */       while (rs.next())
/*      */       {
/*  641 */         i++;
/*      */ 
/*  643 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  647 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  651 */         MCourseSchema s1 = new MCourseSchema();
/*  652 */         s1.setSchema(rs, i);
/*  653 */         aMCourseSet.add(s1);
/*      */       }try {
/*  655 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  661 */       CError tError = new CError();
/*  662 */       tError.moduleName = "MCourseDB";
/*  663 */       tError.functionName = "query";
/*  664 */       tError.errorMessage = e.toString();
/*  665 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  667 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  670 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  674 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  680 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  684 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  689 */     return aMCourseSet;
/*      */   }
/*      */ 
/*      */   public MCourseSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  694 */     Statement stmt = null;
/*  695 */     ResultSet rs = null;
/*  696 */     MCourseSet aMCourseSet = new MCourseSet();
/*      */ 
/*  698 */     if (!this.mflag) {
/*  699 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  704 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  706 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  707 */       int i = 0;
/*  708 */       while (rs.next())
/*      */       {
/*  710 */         i++;
/*      */ 
/*  712 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  716 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  720 */         MCourseSchema s1 = new MCourseSchema();
/*  721 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  724 */           CError tError = new CError();
/*  725 */           tError.moduleName = "MCourseDB";
/*  726 */           tError.functionName = "executeQuery";
/*  727 */           tError.errorMessage = "sql\u8BED\u53E5\u6709\u8BEF\uFF0C\u8BF7\u67E5\u770B\u8868\u540D\u53CA\u5B57\u6BB5\u540D\u4FE1\u606F!";
/*  728 */           this.mErrors.addOneError(tError);
/*      */         }
/*  730 */         aMCourseSet.add(s1);
/*      */       }try {
/*  732 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  738 */       CError tError = new CError();
/*  739 */       tError.moduleName = "MCourseDB";
/*  740 */       tError.functionName = "executeQuery";
/*  741 */       tError.errorMessage = e.toString();
/*  742 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  744 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  747 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  751 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  757 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  761 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  766 */     return aMCourseSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  771 */     Statement stmt = null;
/*      */ 
/*  773 */     if (!this.mflag) {
/*  774 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  779 */       stmt = this.con.createStatement(1003, 1007);
/*  780 */       SQLString sqlObj = new SQLString("MCourse");
/*  781 */       MCourseSchema aSchema = getSchema();
/*  782 */       sqlObj.setSQL(2, aSchema);
/*  783 */       String sql = "update MCourse " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  785 */       int operCount = stmt.executeUpdate(sql);
/*  786 */       if (operCount == 0)
/*      */       {
/*  789 */         CError tError = new CError();
/*  790 */         tError.moduleName = "MCourseDB";
/*  791 */         tError.functionName = "update";
/*  792 */         tError.errorMessage = "\u66F4\u65B0\u6570\u636E\u5931\u8D25!";
/*  793 */         this.mErrors.addOneError(tError);
/*      */ 
/*  795 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  799 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  803 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  809 */       CError tError = new CError();
/*  810 */       tError.moduleName = "MCourseDB";
/*  811 */       tError.functionName = "update";
/*  812 */       tError.errorMessage = e.toString();
/*  813 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  815 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  817 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  821 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  825 */       return false;
/*      */     }
/*      */ 
/*  828 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  832 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  837 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  843 */     if (this.mResultSet != null)
/*      */     {
/*  846 */       CError tError = new CError();
/*  847 */       tError.moduleName = "MCourseDB";
/*  848 */       tError.functionName = "prepareData";
/*  849 */       tError.errorMessage = "\u6570\u636E\u96C6\u975E\u7A7A\uFF0C\u7A0B\u5E8F\u5728\u51C6\u5907\u6570\u636E\u96C6\u4E4B\u540E\uFF0C\u6CA1\u6709\u5173\u95ED\uFF01";
/*  850 */       this.mErrors.addOneError(tError);
/*  851 */       return false;
/*      */     }
/*      */ 
/*  854 */     if (!this.mflag)
/*      */     {
/*  856 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  860 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  861 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  866 */       CError tError = new CError();
/*  867 */       tError.moduleName = "MCourseDB";
/*  868 */       tError.functionName = "prepareData";
/*  869 */       tError.errorMessage = e.toString();
/*  870 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  873 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  879 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  883 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  887 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  892 */       return false;
/*      */     }
/*      */ 
/*  895 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  899 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  904 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  910 */     boolean flag = true;
/*  911 */     if (this.mResultSet == null)
/*      */     {
/*  913 */       CError tError = new CError();
/*  914 */       tError.moduleName = "MCourseDB";
/*  915 */       tError.functionName = "hasMoreData";
/*  916 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  917 */       this.mErrors.addOneError(tError);
/*  918 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  922 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  926 */       CError tError = new CError();
/*  927 */       tError.moduleName = "MCourseDB";
/*  928 */       tError.functionName = "hasMoreData";
/*  929 */       tError.errorMessage = ex.toString();
/*  930 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  933 */         this.mResultSet.close();
/*  934 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  940 */         this.mStatement.close();
/*  941 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  945 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  949 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  954 */       return false;
/*      */     }
/*  956 */     return flag;
/*      */   }
/*      */ 
/*      */   public MCourseSet getData()
/*      */   {
/*  961 */     int tCount = 0;
/*  962 */     MCourseSet tMCourseSet = new MCourseSet();
/*  963 */     MCourseSchema tMCourseSchema = null;
/*  964 */     if (this.mResultSet == null)
/*      */     {
/*  966 */       CError tError = new CError();
/*  967 */       tError.moduleName = "MCourseDB";
/*  968 */       tError.functionName = "getData";
/*  969 */       tError.errorMessage = "\u6570\u636E\u96C6\u4E3A\u7A7A\uFF0C\u8BF7\u5148\u51C6\u5907\u6570\u636E\u96C6\uFF01";
/*  970 */       this.mErrors.addOneError(tError);
/*  971 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  975 */       tCount = 1;
/*  976 */       tMCourseSchema = new MCourseSchema();
/*  977 */       tMCourseSchema.setSchema(this.mResultSet, 1);
/*  978 */       tMCourseSet.add(tMCourseSchema);
/*      */ 
/*  980 */       while (tCount++ < 5000)
/*      */       {
/*  982 */         if (!this.mResultSet.next())
/*      */           continue;
/*  984 */         tMCourseSchema = new MCourseSchema();
/*  985 */         tMCourseSchema.setSchema(this.mResultSet, 1);
/*  986 */         tMCourseSet.add(tMCourseSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  992 */       CError tError = new CError();
/*  993 */       tError.moduleName = "MCourseDB";
/*  994 */       tError.functionName = "getData";
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
/* 1020 */       return null;
/*      */     }
/* 1022 */     return tMCourseSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1027 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1030 */       if (this.mResultSet == null)
/*      */       {
/* 1032 */         CError tError = new CError();
/* 1033 */         tError.moduleName = "MCourseDB";
/* 1034 */         tError.functionName = "closeData";
/* 1035 */         tError.errorMessage = "\u6570\u636E\u96C6\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1036 */         this.mErrors.addOneError(tError);
/* 1037 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1041 */         this.mResultSet.close();
/* 1042 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1047 */       CError tError = new CError();
/* 1048 */       tError.moduleName = "MCourseDB";
/* 1049 */       tError.functionName = "closeData";
/* 1050 */       tError.errorMessage = ex2.toString();
/* 1051 */       this.mErrors.addOneError(tError);
/* 1052 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1056 */       if (this.mStatement == null)
/*      */       {
/* 1058 */         CError tError = new CError();
/* 1059 */         tError.moduleName = "MCourseDB";
/* 1060 */         tError.functionName = "closeData";
/* 1061 */         tError.errorMessage = "\u8BED\u53E5\u5DF2\u7ECF\u5173\u95ED\u4E86\uFF01";
/* 1062 */         this.mErrors.addOneError(tError);
/* 1063 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1067 */         this.mStatement.close();
/* 1068 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1073 */       CError tError = new CError();
/* 1074 */       tError.moduleName = "MCourseDB";
/* 1075 */       tError.functionName = "closeData";
/* 1076 */       tError.errorMessage = ex3.toString();
/* 1077 */       this.mErrors.addOneError(tError);
/* 1078 */       flag = false;
/*      */     }
/* 1080 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MCourseDB
 * JD-Core Version:    0.6.0
 */