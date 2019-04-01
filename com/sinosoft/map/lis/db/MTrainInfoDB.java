/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MTrainInfoSchema;
/*      */ import com.sinosoft.map.lis.vschema.MTrainInfoSet;
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
/*      */ public class MTrainInfoDB extends MTrainInfoSchema
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
/*      */   public MTrainInfoDB(Connection tConnection)
/*      */   {
/*   30 */     this.con = tConnection;
/*   31 */     this.db = new DBOper(this.con, "MTrainInfo");
/*   32 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MTrainInfoDB()
/*      */   {
/*   37 */     this.con = null;
/*   38 */     this.db = new DBOper("MTrainInfo");
/*   39 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   45 */     MTrainInfoSchema tSchema = getSchema();
/*   46 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   48 */       return true;
/*      */     }
/*      */ 
/*   53 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   54 */     CError tError = new CError();
/*   55 */     tError.moduleName = "MTrainInfoDB";
/*   56 */     tError.functionName = "deleteSQL";
/*   57 */     tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*   58 */     this.mErrors.addOneError(tError);
/*   59 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   65 */     MTrainInfoSchema tSchema = getSchema();
/*      */ 
/*   67 */     int tCount = this.db.getCount(tSchema);
/*   68 */     if (tCount < 0)
/*      */     {
/*   71 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   72 */       CError tError = new CError();
/*   73 */       tError.moduleName = "MTrainInfoDB";
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
/*   94 */       pstmt = this.con.prepareStatement("DELETE FROM MTrainInfo WHERE  ID = ?");
/*   95 */       if ((getID() == null) || (getID().equals("null")))
/*   96 */         pstmt.setNull(1, 12);
/*      */       else {
/*   98 */         pstmt.setString(1, getID());
/*      */       }
/*  100 */       pstmt.executeUpdate();
/*  101 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  104 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  105 */       CError tError = new CError();
/*  106 */       tError.moduleName = "MTrainInfoDB";
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
/*  143 */       pstmt = this.con.prepareStatement("UPDATE MTrainInfo SET  ID = ? , AgentCode = ? , AgentName = ? , AgentGrade = ? , AgentGroup = ? , ManageCom = ? , BranchType = ? , CourseID = ? , TrainStart = ? , TrainEnd = ? , TrainAdd = ? , Hours = ? , Teacher = ? , PassFlag = ? , Score = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ID = ?");
/*  144 */       if ((getID() == null) || (getID().equals("null")))
/*  145 */         pstmt.setNull(1, 12);
/*      */       else {
/*  147 */         pstmt.setString(1, getID());
/*      */       }
/*  149 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  150 */         pstmt.setNull(2, 12);
/*      */       else {
/*  152 */         pstmt.setString(2, getAgentCode());
/*      */       }
/*  154 */       if ((getAgentName() == null) || (getAgentName().equals("null")))
/*  155 */         pstmt.setNull(3, 12);
/*      */       else {
/*  157 */         pstmt.setString(3, getAgentName());
/*      */       }
/*  159 */       if ((getAgentGrade() == null) || (getAgentGrade().equals("null")))
/*  160 */         pstmt.setNull(4, 12);
/*      */       else {
/*  162 */         pstmt.setString(4, getAgentGrade());
/*      */       }
/*  164 */       if ((getAgentGroup() == null) || (getAgentGroup().equals("null")))
/*  165 */         pstmt.setNull(5, 12);
/*      */       else {
/*  167 */         pstmt.setString(5, getAgentGroup());
/*      */       }
/*  169 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  170 */         pstmt.setNull(6, 12);
/*      */       else {
/*  172 */         pstmt.setString(6, getManageCom());
/*      */       }
/*  174 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  175 */         pstmt.setNull(7, 12);
/*      */       else {
/*  177 */         pstmt.setString(7, getBranchType());
/*      */       }
/*  179 */       if ((getCourseID() == null) || (getCourseID().equals("null")))
/*  180 */         pstmt.setNull(8, 12);
/*      */       else {
/*  182 */         pstmt.setString(8, getCourseID());
/*      */       }
/*  184 */       if ((getTrainAdd() == null) || (getTrainAdd().equals("null")))
/*  185 */         pstmt.setNull(11, 12);
/*      */       else {
/*  187 */         pstmt.setString(11, getTrainAdd());
/*      */       }
/*  189 */       if ((getHours() == null) || (getHours().equals("null")))
/*  190 */         pstmt.setNull(12, 12);
/*      */       else {
/*  192 */         pstmt.setString(12, getHours());
/*      */       }
/*  194 */       if ((getTeacher() == null) || (getTeacher().equals("null")))
/*  195 */         pstmt.setNull(13, 12);
/*      */       else {
/*  197 */         pstmt.setString(13, getTeacher());
/*      */       }
/*  199 */       if ((getPassFlag() == null) || (getPassFlag().equals("null")))
/*  200 */         pstmt.setNull(14, 12);
/*      */       else {
/*  202 */         pstmt.setString(14, getPassFlag());
/*      */       }
/*  204 */       if ((getScore() == null) || (getScore().equals("null")))
/*  205 */         pstmt.setNull(15, 12);
/*      */       else {
/*  207 */         pstmt.setString(15, getScore());
/*      */       }
/*  209 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  210 */         pstmt.setNull(16, 12);
/*      */       else {
/*  212 */         pstmt.setString(16, getOperator());
/*      */       }
/*  214 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  215 */         pstmt.setNull(18, 12);
/*      */       else {
/*  217 */         pstmt.setString(18, getMakeTime());
/*      */       }
/*  219 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  220 */         pstmt.setNull(20, 12);
/*      */       else {
/*  222 */         pstmt.setString(20, getModifyTime());
/*      */       }
/*      */ 
/*  225 */       if ((getID() == null) || (getID().equals("null")))
/*  226 */         pstmt.setNull(21, 12);
/*      */       else {
/*  228 */         pstmt.setString(21, getID());
/*      */       }
/*  230 */       pstmt.executeUpdate();
/*  231 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  234 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  235 */       CError tError = new CError();
/*  236 */       tError.moduleName = "MTrainInfoDB";
/*  237 */       tError.functionName = "update()";
/*  238 */       tError.errorMessage = ex.toString();
/*  239 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  242 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  245 */       if (!this.mflag)
/*      */         try {
/*  247 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  251 */       return false;
/*      */     }
/*      */ 
/*  254 */     if (!this.mflag)
/*      */       try {
/*  256 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  260 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  265 */     PreparedStatement pstmt = null;
/*      */ 
/*  267 */     if (!this.mflag) {
/*  268 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  273 */       pstmt = this.con.prepareStatement("INSERT INTO MTrainInfo VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  274 */       if ((getID() == null) || (getID().equals("null")))
/*  275 */         pstmt.setNull(1, 12);
/*      */       else {
/*  277 */         pstmt.setString(1, getID());
/*      */       }
/*  279 */       if ((getAgentCode() == null) || (getAgentCode().equals("null")))
/*  280 */         pstmt.setNull(2, 12);
/*      */       else {
/*  282 */         pstmt.setString(2, getAgentCode());
/*      */       }
/*  284 */       if ((getAgentName() == null) || (getAgentName().equals("null")))
/*  285 */         pstmt.setNull(3, 12);
/*      */       else {
/*  287 */         pstmt.setString(3, getAgentName());
/*      */       }
/*  289 */       if ((getAgentGrade() == null) || (getAgentGrade().equals("null")))
/*  290 */         pstmt.setNull(4, 12);
/*      */       else {
/*  292 */         pstmt.setString(4, getAgentGrade());
/*      */       }
/*  294 */       if ((getAgentGroup() == null) || (getAgentGroup().equals("null")))
/*  295 */         pstmt.setNull(5, 12);
/*      */       else {
/*  297 */         pstmt.setString(5, getAgentGroup());
/*      */       }
/*  299 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  300 */         pstmt.setNull(6, 12);
/*      */       else {
/*  302 */         pstmt.setString(6, getManageCom());
/*      */       }
/*  304 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  305 */         pstmt.setNull(7, 12);
/*      */       else {
/*  307 */         pstmt.setString(7, getBranchType());
/*      */       }
/*  309 */       if ((getCourseID() == null) || (getCourseID().equals("null")))
/*  310 */         pstmt.setNull(8, 12);
/*      */       else {
/*  312 */         pstmt.setString(8, getCourseID());
/*      */       }
/*  314 */       if ((getTrainAdd() == null) || (getTrainAdd().equals("null")))
/*  315 */         pstmt.setNull(11, 12);
/*      */       else {
/*  317 */         pstmt.setString(11, getTrainAdd());
/*      */       }
/*  319 */       if ((getHours() == null) || (getHours().equals("null")))
/*  320 */         pstmt.setNull(12, 12);
/*      */       else {
/*  322 */         pstmt.setString(12, getHours());
/*      */       }
/*  324 */       if ((getTeacher() == null) || (getTeacher().equals("null")))
/*  325 */         pstmt.setNull(13, 12);
/*      */       else {
/*  327 */         pstmt.setString(13, getTeacher());
/*      */       }
/*  329 */       if ((getPassFlag() == null) || (getPassFlag().equals("null")))
/*  330 */         pstmt.setNull(14, 12);
/*      */       else {
/*  332 */         pstmt.setString(14, getPassFlag());
/*      */       }
/*  334 */       if ((getScore() == null) || (getScore().equals("null")))
/*  335 */         pstmt.setNull(15, 12);
/*      */       else {
/*  337 */         pstmt.setString(15, getScore());
/*      */       }
/*  339 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  340 */         pstmt.setNull(16, 12);
/*      */       else {
/*  342 */         pstmt.setString(16, getOperator());
/*      */       }
/*  344 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  345 */         pstmt.setNull(18, 12);
/*      */       else {
/*  347 */         pstmt.setString(18, getMakeTime());
/*      */       }
/*  349 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  350 */         pstmt.setNull(20, 12);
/*      */       else {
/*  352 */         pstmt.setString(20, getModifyTime());
/*      */       }
/*      */ 
/*  355 */       pstmt.executeUpdate();
/*  356 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  359 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  360 */       CError tError = new CError();
/*  361 */       tError.moduleName = "MTrainInfoDB";
/*  362 */       tError.functionName = "insert()";
/*  363 */       tError.errorMessage = ex.toString();
/*  364 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  367 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  370 */       if (!this.mflag)
/*      */         try {
/*  372 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  376 */       return false;
/*      */     }
/*      */ 
/*  379 */     if (!this.mflag)
/*      */       try {
/*  381 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  385 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  390 */     PreparedStatement pstmt = null;
/*  391 */     ResultSet rs = null;
/*      */ 
/*  393 */     if (!this.mflag) {
/*  394 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  399 */       pstmt = this.con.prepareStatement("SELECT * FROM MTrainInfo WHERE  ID = ?", 
/*  400 */         1003, 1007);
/*  401 */       if ((getID() == null) || (getID().equals("null")))
/*  402 */         pstmt.setNull(1, 12);
/*      */       else {
/*  404 */         pstmt.setString(1, getID());
/*      */       }
/*  406 */       rs = pstmt.executeQuery();
/*  407 */       int i = 0;
/*  408 */       if (rs.next())
/*      */       {
/*  410 */         i++;
/*  411 */         if (!setSchema(rs, i))
/*      */         {
/*  414 */           CError tError = new CError();
/*  415 */           tError.moduleName = "MTrainInfoDB";
/*  416 */           tError.functionName = "getInfo";
/*  417 */           tError.errorMessage = "\u53D6\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  418 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  420 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  423 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  427 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  431 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  435 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  438 */       if (i == 0)
/*      */       {
/*  440 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  444 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  448 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  454 */       CError tError = new CError();
/*  455 */       tError.moduleName = "MTrainInfoDB";
/*  456 */       tError.functionName = "getInfo";
/*  457 */       tError.errorMessage = e.toString();
/*  458 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  460 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  463 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  467 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  471 */       return false;
/*      */     }
/*      */ 
/*  474 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  478 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  483 */     return true;
/*      */   }
/*      */ 
/*      */   public MTrainInfoSet query()
/*      */   {
/*  488 */     Statement stmt = null;
/*  489 */     ResultSet rs = null;
/*  490 */     MTrainInfoSet aMTrainInfoSet = new MTrainInfoSet();
/*      */ 
/*  492 */     if (!this.mflag) {
/*  493 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  498 */       stmt = this.con.createStatement(1003, 1007);
/*  499 */       SQLString sqlObj = new SQLString("MTrainInfo");
/*  500 */       MTrainInfoSchema aSchema = getSchema();
/*  501 */       sqlObj.setSQL(5, aSchema);
/*  502 */       String sql = sqlObj.getSQL();
/*      */ 
/*  504 */       rs = stmt.executeQuery(sql);
/*  505 */       int i = 0;
/*  506 */       while (rs.next())
/*      */       {
/*  508 */         i++;
/*  509 */         MTrainInfoSchema s1 = new MTrainInfoSchema();
/*  510 */         s1.setSchema(rs, i);
/*  511 */         aMTrainInfoSet.add(s1);
/*      */       }try {
/*  513 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  519 */       CError tError = new CError();
/*  520 */       tError.moduleName = "MTrainInfoDB";
/*  521 */       tError.functionName = "query";
/*  522 */       tError.errorMessage = e.toString();
/*  523 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  525 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  528 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  532 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  538 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  542 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  547 */     return aMTrainInfoSet;
/*      */   }
/*      */ 
/*      */   public MTrainInfoSet executeQuery(String sql)
/*      */   {
/*  552 */     Statement stmt = null;
/*  553 */     ResultSet rs = null;
/*  554 */     MTrainInfoSet aMTrainInfoSet = new MTrainInfoSet();
/*      */ 
/*  556 */     if (!this.mflag) {
/*  557 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  562 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  564 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  565 */       int i = 0;
/*  566 */       while (rs.next())
/*      */       {
/*  568 */         i++;
/*  569 */         MTrainInfoSchema s1 = new MTrainInfoSchema();
/*  570 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  573 */           CError tError = new CError();
/*  574 */           tError.moduleName = "MTrainInfoDB";
/*  575 */           tError.functionName = "executeQuery";
/*  576 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  577 */           this.mErrors.addOneError(tError);
/*      */         }
/*  579 */         aMTrainInfoSet.add(s1);
/*      */       }try {
/*  581 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  587 */       CError tError = new CError();
/*  588 */       tError.moduleName = "MTrainInfoDB";
/*  589 */       tError.functionName = "executeQuery";
/*  590 */       tError.errorMessage = e.toString();
/*  591 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  593 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  596 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  600 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  606 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  610 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  615 */     return aMTrainInfoSet;
/*      */   }
/*      */ 
/*      */   public MTrainInfoSet query(int nStart, int nCount)
/*      */   {
/*  620 */     Statement stmt = null;
/*  621 */     ResultSet rs = null;
/*  622 */     MTrainInfoSet aMTrainInfoSet = new MTrainInfoSet();
/*      */ 
/*  624 */     if (!this.mflag) {
/*  625 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  630 */       stmt = this.con.createStatement(1003, 1007);
/*  631 */       SQLString sqlObj = new SQLString("MTrainInfo");
/*  632 */       MTrainInfoSchema aSchema = getSchema();
/*  633 */       sqlObj.setSQL(5, aSchema);
/*  634 */       String sql = sqlObj.getSQL();
/*      */ 
/*  636 */       rs = stmt.executeQuery(sql);
/*  637 */       int i = 0;
/*  638 */       while (rs.next())
/*      */       {
/*  640 */         i++;
/*      */ 
/*  642 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  646 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  650 */         MTrainInfoSchema s1 = new MTrainInfoSchema();
/*  651 */         s1.setSchema(rs, i);
/*  652 */         aMTrainInfoSet.add(s1);
/*      */       }try {
/*  654 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  660 */       CError tError = new CError();
/*  661 */       tError.moduleName = "MTrainInfoDB";
/*  662 */       tError.functionName = "query";
/*  663 */       tError.errorMessage = e.toString();
/*  664 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  666 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  669 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  673 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  679 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  683 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  688 */     return aMTrainInfoSet;
/*      */   }
/*      */ 
/*      */   public MTrainInfoSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  693 */     Statement stmt = null;
/*  694 */     ResultSet rs = null;
/*  695 */     MTrainInfoSet aMTrainInfoSet = new MTrainInfoSet();
/*      */ 
/*  697 */     if (!this.mflag) {
/*  698 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  703 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  705 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  706 */       int i = 0;
/*  707 */       while (rs.next())
/*      */       {
/*  709 */         i++;
/*      */ 
/*  711 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  715 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  719 */         MTrainInfoSchema s1 = new MTrainInfoSchema();
/*  720 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  723 */           CError tError = new CError();
/*  724 */           tError.moduleName = "MTrainInfoDB";
/*  725 */           tError.functionName = "executeQuery";
/*  726 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  727 */           this.mErrors.addOneError(tError);
/*      */         }
/*  729 */         aMTrainInfoSet.add(s1);
/*      */       }try {
/*  731 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  737 */       CError tError = new CError();
/*  738 */       tError.moduleName = "MTrainInfoDB";
/*  739 */       tError.functionName = "executeQuery";
/*  740 */       tError.errorMessage = e.toString();
/*  741 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  743 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  746 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  750 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  756 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  760 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  765 */     return aMTrainInfoSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  770 */     Statement stmt = null;
/*      */ 
/*  772 */     if (!this.mflag) {
/*  773 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  778 */       stmt = this.con.createStatement(1003, 1007);
/*  779 */       SQLString sqlObj = new SQLString("MTrainInfo");
/*  780 */       MTrainInfoSchema aSchema = getSchema();
/*  781 */       sqlObj.setSQL(2, aSchema);
/*  782 */       String sql = "update MTrainInfo " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  784 */       int operCount = stmt.executeUpdate(sql);
/*  785 */       if (operCount == 0)
/*      */       {
/*  788 */         CError tError = new CError();
/*  789 */         tError.moduleName = "MTrainInfoDB";
/*  790 */         tError.functionName = "update";
/*  791 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u7EDE\u044D\u62F7\u951F\uFFFD!";
/*  792 */         this.mErrors.addOneError(tError);
/*      */ 
/*  794 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  798 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  802 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  808 */       CError tError = new CError();
/*  809 */       tError.moduleName = "MTrainInfoDB";
/*  810 */       tError.functionName = "update";
/*  811 */       tError.errorMessage = e.toString();
/*  812 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  814 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  816 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  820 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  824 */       return false;
/*      */     }
/*      */ 
/*  827 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  831 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  836 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  842 */     if (this.mResultSet != null)
/*      */     {
/*  845 */       CError tError = new CError();
/*  846 */       tError.moduleName = "MTrainInfoDB";
/*  847 */       tError.functionName = "prepareData";
/*  848 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u5F3A\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u4E4B\u951F\u65A4\u62F7\u6CA1\u951F\u53EB\u5173\u95ED\uFF4F\u62F7";
/*  849 */       this.mErrors.addOneError(tError);
/*  850 */       return false;
/*      */     }
/*      */ 
/*  853 */     if (!this.mflag)
/*      */     {
/*  855 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  859 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  860 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  865 */       CError tError = new CError();
/*  866 */       tError.moduleName = "MTrainInfoDB";
/*  867 */       tError.functionName = "prepareData";
/*  868 */       tError.errorMessage = e.toString();
/*  869 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  872 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  878 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  882 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  886 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
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
/*      */   public boolean hasMoreData()
/*      */   {
/*  909 */     boolean flag = true;
/*  910 */     if (this.mResultSet == null)
/*      */     {
/*  912 */       CError tError = new CError();
/*  913 */       tError.moduleName = "MTrainInfoDB";
/*  914 */       tError.functionName = "hasMoreData";
/*  915 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/*  916 */       this.mErrors.addOneError(tError);
/*  917 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  921 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  925 */       CError tError = new CError();
/*  926 */       tError.moduleName = "MTrainInfoDB";
/*  927 */       tError.functionName = "hasMoreData";
/*  928 */       tError.errorMessage = ex.toString();
/*  929 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  932 */         this.mResultSet.close();
/*  933 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  939 */         this.mStatement.close();
/*  940 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  944 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  948 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  953 */       return false;
/*      */     }
/*  955 */     return flag;
/*      */   }
/*      */ 
/*      */   public MTrainInfoSet getData()
/*      */   {
/*  960 */     int tCount = 0;
/*  961 */     MTrainInfoSet tMTrainInfoSet = new MTrainInfoSet();
/*  962 */     MTrainInfoSchema tMTrainInfoSchema = null;
/*  963 */     if (this.mResultSet == null)
/*      */     {
/*  965 */       CError tError = new CError();
/*  966 */       tError.moduleName = "MTrainInfoDB";
/*  967 */       tError.functionName = "getData";
/*  968 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/*  969 */       this.mErrors.addOneError(tError);
/*  970 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  974 */       tCount = 1;
/*  975 */       tMTrainInfoSchema = new MTrainInfoSchema();
/*  976 */       tMTrainInfoSchema.setSchema(this.mResultSet, 1);
/*  977 */       tMTrainInfoSet.add(tMTrainInfoSchema);
/*      */ 
/*  979 */       while (tCount++ < 5000)
/*      */       {
/*  981 */         if (!this.mResultSet.next())
/*      */           continue;
/*  983 */         tMTrainInfoSchema = new MTrainInfoSchema();
/*  984 */         tMTrainInfoSchema.setSchema(this.mResultSet, 1);
/*  985 */         tMTrainInfoSet.add(tMTrainInfoSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  991 */       CError tError = new CError();
/*  992 */       tError.moduleName = "MTrainInfoDB";
/*  993 */       tError.functionName = "getData";
/*  994 */       tError.errorMessage = ex.toString();
/*  995 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  998 */         this.mResultSet.close();
/*  999 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1005 */         this.mStatement.close();
/* 1006 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1010 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1014 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1019 */       return null;
/*      */     }
/* 1021 */     return tMTrainInfoSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1026 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1029 */       if (this.mResultSet == null)
/*      */       {
/* 1031 */         CError tError = new CError();
/* 1032 */         tError.moduleName = "MTrainInfoDB";
/* 1033 */         tError.functionName = "closeData";
/* 1034 */         tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 1035 */         this.mErrors.addOneError(tError);
/* 1036 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1040 */         this.mResultSet.close();
/* 1041 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1046 */       CError tError = new CError();
/* 1047 */       tError.moduleName = "MTrainInfoDB";
/* 1048 */       tError.functionName = "closeData";
/* 1049 */       tError.errorMessage = ex2.toString();
/* 1050 */       this.mErrors.addOneError(tError);
/* 1051 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1055 */       if (this.mStatement == null)
/*      */       {
/* 1057 */         CError tError = new CError();
/* 1058 */         tError.moduleName = "MTrainInfoDB";
/* 1059 */         tError.functionName = "closeData";
/* 1060 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 1061 */         this.mErrors.addOneError(tError);
/* 1062 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1066 */         this.mStatement.close();
/* 1067 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1072 */       CError tError = new CError();
/* 1073 */       tError.moduleName = "MTrainInfoDB";
/* 1074 */       tError.functionName = "closeData";
/* 1075 */       tError.errorMessage = ex3.toString();
/* 1076 */       this.mErrors.addOneError(tError);
/* 1077 */       flag = false;
/*      */     }
/* 1079 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MTrainInfoDB
 * JD-Core Version:    0.6.0
 */