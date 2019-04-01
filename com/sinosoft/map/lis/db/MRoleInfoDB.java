/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MRoleInfoSchema;
/*      */ import com.sinosoft.map.lis.vschema.MRoleInfoSet;
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
/*      */ public class MRoleInfoDB extends MRoleInfoSchema
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
/*      */   public MRoleInfoDB(Connection tConnection)
/*      */   {
/*   30 */     this.con = tConnection;
/*   31 */     this.db = new DBOper(this.con, "MRoleInfo");
/*   32 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MRoleInfoDB()
/*      */   {
/*   37 */     this.con = null;
/*   38 */     this.db = new DBOper("MRoleInfo");
/*   39 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   45 */     MRoleInfoSchema tSchema = getSchema();
/*   46 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   48 */       return true;
/*      */     }
/*      */ 
/*   53 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   54 */     CError tError = new CError();
/*   55 */     tError.moduleName = "MRoleInfoDB";
/*   56 */     tError.functionName = "deleteSQL";
/*   57 */     tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*   58 */     this.mErrors.addOneError(tError);
/*   59 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   65 */     MRoleInfoSchema tSchema = getSchema();
/*      */ 
/*   67 */     int tCount = this.db.getCount(tSchema);
/*   68 */     if (tCount < 0)
/*      */     {
/*   71 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   72 */       CError tError = new CError();
/*   73 */       tError.moduleName = "MRoleInfoDB";
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
/*   94 */       pstmt = this.con.prepareStatement("DELETE FROM MRoleInfo WHERE  ID = ?");
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
/*  106 */       tError.moduleName = "MRoleInfoDB";
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
/*  143 */       pstmt = this.con.prepareStatement("UPDATE MRoleInfo SET  ID = ? , RoleCode = ? , Name = ? , Parent = ? , Describe = ? , RoleState = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Int1 = ? , Int2 = ? , Varc1 = ? , Varc2 = ? , Varc3 = ? WHERE  ID = ?");
/*  144 */       if ((getID() == null) || (getID().equals("null")))
/*  145 */         pstmt.setNull(1, 12);
/*      */       else {
/*  147 */         pstmt.setString(1, getID());
/*      */       }
/*  149 */       if ((getRoleCode() == null) || (getRoleCode().equals("null")))
/*  150 */         pstmt.setNull(2, 12);
/*      */       else {
/*  152 */         pstmt.setString(2, getRoleCode());
/*      */       }
/*  154 */       if ((getName() == null) || (getName().equals("null")))
/*  155 */         pstmt.setNull(3, 12);
/*      */       else {
/*  157 */         pstmt.setString(3, getName());
/*      */       }
/*  159 */       if ((getParent() == null) || (getParent().equals("null")))
/*  160 */         pstmt.setNull(4, 12);
/*      */       else {
/*  162 */         pstmt.setString(4, getParent());
/*      */       }
/*  164 */       if ((getDescribe() == null) || (getDescribe().equals("null")))
/*  165 */         pstmt.setNull(5, 12);
/*      */       else {
/*  167 */         pstmt.setString(5, getDescribe());
/*      */       }
/*  169 */       if ((getRoleState() == null) || (getRoleState().equals("null")))
/*  170 */         pstmt.setNull(6, 12);
/*      */       else {
/*  172 */         pstmt.setString(6, getRoleState());
/*      */       }
/*  174 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  175 */         pstmt.setNull(7, 12);
/*      */       else {
/*  177 */         pstmt.setString(7, getOperator());
/*      */       }
/*  179 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  180 */         pstmt.setNull(8, 91);
/*      */       else {
/*  182 */         pstmt.setDate(8, Date.valueOf(getMakeDate()));
/*      */       }
/*  184 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  185 */         pstmt.setNull(9, 12);
/*      */       else {
/*  187 */         pstmt.setString(9, getMakeTime());
/*      */       }
/*  189 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  190 */         pstmt.setNull(10, 91);
/*      */       else {
/*  192 */         pstmt.setDate(10, Date.valueOf(getModifyDate()));
/*      */       }
/*  194 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  195 */         pstmt.setNull(11, 12);
/*      */       else {
/*  197 */         pstmt.setString(11, getModifyTime());
/*      */       }
/*  199 */       pstmt.setInt(12, getInt1());
/*  200 */       pstmt.setInt(13, getInt2());
/*  201 */       if ((getVarc1() == null) || (getVarc1().equals("null")))
/*  202 */         pstmt.setNull(14, 12);
/*      */       else {
/*  204 */         pstmt.setString(14, getVarc1());
/*      */       }
/*  206 */       if ((getVarc2() == null) || (getVarc2().equals("null")))
/*  207 */         pstmt.setNull(15, 12);
/*      */       else {
/*  209 */         pstmt.setString(15, getVarc2());
/*      */       }
/*  211 */       if ((getVarc3() == null) || (getVarc3().equals("null")))
/*  212 */         pstmt.setNull(16, 12);
/*      */       else {
/*  214 */         pstmt.setString(16, getVarc3());
/*      */       }
/*      */ 
/*  217 */       if ((getID() == null) || (getID().equals("null")))
/*  218 */         pstmt.setNull(17, 12);
/*      */       else {
/*  220 */         pstmt.setString(17, getID());
/*      */       }
/*  222 */       pstmt.executeUpdate();
/*  223 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  226 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  227 */       CError tError = new CError();
/*  228 */       tError.moduleName = "MRoleInfoDB";
/*  229 */       tError.functionName = "update()";
/*  230 */       tError.errorMessage = ex.toString();
/*  231 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  234 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  237 */       if (!this.mflag)
/*      */         try {
/*  239 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  243 */       return false;
/*      */     }
/*      */ 
/*  246 */     if (!this.mflag)
/*      */       try {
/*  248 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  252 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  257 */     PreparedStatement pstmt = null;
/*      */ 
/*  259 */     if (!this.mflag) {
/*  260 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  265 */       pstmt = this.con.prepareStatement("INSERT INTO MRoleInfo VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  266 */       if ((getID() == null) || (getID().equals("null")))
/*  267 */         pstmt.setNull(1, 12);
/*      */       else {
/*  269 */         pstmt.setString(1, getID());
/*      */       }
/*  271 */       if ((getRoleCode() == null) || (getRoleCode().equals("null")))
/*  272 */         pstmt.setNull(2, 12);
/*      */       else {
/*  274 */         pstmt.setString(2, getRoleCode());
/*      */       }
/*  276 */       if ((getName() == null) || (getName().equals("null")))
/*  277 */         pstmt.setNull(3, 12);
/*      */       else {
/*  279 */         pstmt.setString(3, getName());
/*      */       }
/*  281 */       if ((getParent() == null) || (getParent().equals("null")))
/*  282 */         pstmt.setNull(4, 12);
/*      */       else {
/*  284 */         pstmt.setString(4, getParent());
/*      */       }
/*  286 */       if ((getDescribe() == null) || (getDescribe().equals("null")))
/*  287 */         pstmt.setNull(5, 12);
/*      */       else {
/*  289 */         pstmt.setString(5, getDescribe());
/*      */       }
/*  291 */       if ((getRoleState() == null) || (getRoleState().equals("null")))
/*  292 */         pstmt.setNull(6, 12);
/*      */       else {
/*  294 */         pstmt.setString(6, getRoleState());
/*      */       }
/*  296 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  297 */         pstmt.setNull(7, 12);
/*      */       else {
/*  299 */         pstmt.setString(7, getOperator());
/*      */       }
/*  301 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  302 */         pstmt.setNull(8, 91);
/*      */       else {
/*  304 */         pstmt.setDate(8, Date.valueOf(getMakeDate()));
/*      */       }
/*  306 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  307 */         pstmt.setNull(9, 12);
/*      */       else {
/*  309 */         pstmt.setString(9, getMakeTime());
/*      */       }
/*  311 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  312 */         pstmt.setNull(10, 91);
/*      */       else {
/*  314 */         pstmt.setDate(10, Date.valueOf(getModifyDate()));
/*      */       }
/*  316 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  317 */         pstmt.setNull(11, 12);
/*      */       else {
/*  319 */         pstmt.setString(11, getModifyTime());
/*      */       }
/*  321 */       pstmt.setInt(12, getInt1());
/*  322 */       pstmt.setInt(13, getInt2());
/*  323 */       if ((getVarc1() == null) || (getVarc1().equals("null")))
/*  324 */         pstmt.setNull(14, 12);
/*      */       else {
/*  326 */         pstmt.setString(14, getVarc1());
/*      */       }
/*  328 */       if ((getVarc2() == null) || (getVarc2().equals("null")))
/*  329 */         pstmt.setNull(15, 12);
/*      */       else {
/*  331 */         pstmt.setString(15, getVarc2());
/*      */       }
/*  333 */       if ((getVarc3() == null) || (getVarc3().equals("null")))
/*  334 */         pstmt.setNull(16, 12);
/*      */       else {
/*  336 */         pstmt.setString(16, getVarc3());
/*      */       }
/*      */ 
/*  339 */       pstmt.executeUpdate();
/*  340 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  343 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  344 */       CError tError = new CError();
/*  345 */       tError.moduleName = "MRoleInfoDB";
/*  346 */       tError.functionName = "insert()";
/*  347 */       tError.errorMessage = ex.toString();
/*  348 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  351 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  354 */       if (!this.mflag)
/*      */         try {
/*  356 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  360 */       return false;
/*      */     }
/*      */ 
/*  363 */     if (!this.mflag)
/*      */       try {
/*  365 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  369 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  374 */     PreparedStatement pstmt = null;
/*  375 */     ResultSet rs = null;
/*      */ 
/*  377 */     if (!this.mflag) {
/*  378 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  383 */       pstmt = this.con.prepareStatement("SELECT * FROM MRoleInfo WHERE  ID = ?", 
/*  384 */         1003, 1007);
/*  385 */       if ((getID() == null) || (getID().equals("null")))
/*  386 */         pstmt.setNull(1, 12);
/*      */       else {
/*  388 */         pstmt.setString(1, getID());
/*      */       }
/*  390 */       rs = pstmt.executeQuery();
/*  391 */       int i = 0;
/*  392 */       if (rs.next())
/*      */       {
/*  394 */         i++;
/*  395 */         if (!setSchema(rs, i))
/*      */         {
/*  398 */           CError tError = new CError();
/*  399 */           tError.moduleName = "MRoleInfoDB";
/*  400 */           tError.functionName = "getInfo";
/*  401 */           tError.errorMessage = "\u53D6\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  402 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  404 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  407 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  411 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  415 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  419 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  422 */       if (i == 0)
/*      */       {
/*  424 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  428 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  432 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  438 */       CError tError = new CError();
/*  439 */       tError.moduleName = "MRoleInfoDB";
/*  440 */       tError.functionName = "getInfo";
/*  441 */       tError.errorMessage = e.toString();
/*  442 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  444 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  447 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  451 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  455 */       return false;
/*      */     }
/*      */ 
/*  458 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  462 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  467 */     return true;
/*      */   }
/*      */ 
/*      */   public MRoleInfoSet query()
/*      */   {
/*  472 */     Statement stmt = null;
/*  473 */     ResultSet rs = null;
/*  474 */     MRoleInfoSet aMRoleInfoSet = new MRoleInfoSet();
/*      */ 
/*  476 */     if (!this.mflag) {
/*  477 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  482 */       stmt = this.con.createStatement(1003, 1007);
/*  483 */       SQLString sqlObj = new SQLString("MRoleInfo");
/*  484 */       MRoleInfoSchema aSchema = getSchema();
/*  485 */       sqlObj.setSQL(5, aSchema);
/*  486 */       String sql = sqlObj.getSQL();
/*      */ 
/*  488 */       rs = stmt.executeQuery(sql);
/*  489 */       int i = 0;
/*  490 */       while (rs.next())
/*      */       {
/*  492 */         i++;
/*  493 */         MRoleInfoSchema s1 = new MRoleInfoSchema();
/*  494 */         s1.setSchema(rs, i);
/*  495 */         aMRoleInfoSet.add(s1);
/*      */       }try {
/*  497 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  503 */       CError tError = new CError();
/*  504 */       tError.moduleName = "MRoleInfoDB";
/*  505 */       tError.functionName = "query";
/*  506 */       tError.errorMessage = e.toString();
/*  507 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  509 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  512 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  516 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  522 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  526 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  531 */     return aMRoleInfoSet;
/*      */   }
/*      */ 
/*      */   public MRoleInfoSet executeQuery(String sql)
/*      */   {
/*  536 */     Statement stmt = null;
/*  537 */     ResultSet rs = null;
/*  538 */     MRoleInfoSet aMRoleInfoSet = new MRoleInfoSet();
/*      */ 
/*  540 */     if (!this.mflag) {
/*  541 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  546 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  548 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  549 */       int i = 0;
/*  550 */       while (rs.next())
/*      */       {
/*  552 */         i++;
/*  553 */         MRoleInfoSchema s1 = new MRoleInfoSchema();
/*  554 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  557 */           CError tError = new CError();
/*  558 */           tError.moduleName = "MRoleInfoDB";
/*  559 */           tError.functionName = "executeQuery";
/*  560 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  561 */           this.mErrors.addOneError(tError);
/*      */         }
/*  563 */         aMRoleInfoSet.add(s1);
/*      */       }try {
/*  565 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  571 */       CError tError = new CError();
/*  572 */       tError.moduleName = "MRoleInfoDB";
/*  573 */       tError.functionName = "executeQuery";
/*  574 */       tError.errorMessage = e.toString();
/*  575 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  577 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  580 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  584 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  590 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  594 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  599 */     return aMRoleInfoSet;
/*      */   }
/*      */ 
/*      */   public MRoleInfoSet query(int nStart, int nCount)
/*      */   {
/*  604 */     Statement stmt = null;
/*  605 */     ResultSet rs = null;
/*  606 */     MRoleInfoSet aMRoleInfoSet = new MRoleInfoSet();
/*      */ 
/*  608 */     if (!this.mflag) {
/*  609 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  614 */       stmt = this.con.createStatement(1003, 1007);
/*  615 */       SQLString sqlObj = new SQLString("MRoleInfo");
/*  616 */       MRoleInfoSchema aSchema = getSchema();
/*  617 */       sqlObj.setSQL(5, aSchema);
/*  618 */       String sql = sqlObj.getSQL();
/*      */ 
/*  620 */       rs = stmt.executeQuery(sql);
/*  621 */       int i = 0;
/*  622 */       while (rs.next())
/*      */       {
/*  624 */         i++;
/*      */ 
/*  626 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  630 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  634 */         MRoleInfoSchema s1 = new MRoleInfoSchema();
/*  635 */         s1.setSchema(rs, i);
/*  636 */         aMRoleInfoSet.add(s1);
/*      */       }try {
/*  638 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  644 */       CError tError = new CError();
/*  645 */       tError.moduleName = "MRoleInfoDB";
/*  646 */       tError.functionName = "query";
/*  647 */       tError.errorMessage = e.toString();
/*  648 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  650 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  653 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  657 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  663 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  667 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  672 */     return aMRoleInfoSet;
/*      */   }
/*      */ 
/*      */   public MRoleInfoSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  677 */     Statement stmt = null;
/*  678 */     ResultSet rs = null;
/*  679 */     MRoleInfoSet aMRoleInfoSet = new MRoleInfoSet();
/*      */ 
/*  681 */     if (!this.mflag) {
/*  682 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  687 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  689 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  690 */       int i = 0;
/*  691 */       while (rs.next())
/*      */       {
/*  693 */         i++;
/*      */ 
/*  695 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  699 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  703 */         MRoleInfoSchema s1 = new MRoleInfoSchema();
/*  704 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  707 */           CError tError = new CError();
/*  708 */           tError.moduleName = "MRoleInfoDB";
/*  709 */           tError.functionName = "executeQuery";
/*  710 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  711 */           this.mErrors.addOneError(tError);
/*      */         }
/*  713 */         aMRoleInfoSet.add(s1);
/*      */       }try {
/*  715 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  721 */       CError tError = new CError();
/*  722 */       tError.moduleName = "MRoleInfoDB";
/*  723 */       tError.functionName = "executeQuery";
/*  724 */       tError.errorMessage = e.toString();
/*  725 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  727 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  730 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  734 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  740 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  744 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  749 */     return aMRoleInfoSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  754 */     Statement stmt = null;
/*      */ 
/*  756 */     if (!this.mflag) {
/*  757 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  762 */       stmt = this.con.createStatement(1003, 1007);
/*  763 */       SQLString sqlObj = new SQLString("MRoleInfo");
/*  764 */       MRoleInfoSchema aSchema = getSchema();
/*  765 */       sqlObj.setSQL(2, aSchema);
/*  766 */       String sql = "update MRoleInfo " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  768 */       int operCount = stmt.executeUpdate(sql);
/*  769 */       if (operCount == 0)
/*      */       {
/*  772 */         CError tError = new CError();
/*  773 */         tError.moduleName = "MRoleInfoDB";
/*  774 */         tError.functionName = "update";
/*  775 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u7EDE\u044D\u62F7\u951F\uFFFD!";
/*  776 */         this.mErrors.addOneError(tError);
/*      */ 
/*  778 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  782 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  786 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  792 */       CError tError = new CError();
/*  793 */       tError.moduleName = "MRoleInfoDB";
/*  794 */       tError.functionName = "update";
/*  795 */       tError.errorMessage = e.toString();
/*  796 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  798 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  800 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  804 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  808 */       return false;
/*      */     }
/*      */ 
/*  811 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  815 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  820 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  826 */     if (this.mResultSet != null)
/*      */     {
/*  829 */       CError tError = new CError();
/*  830 */       tError.moduleName = "MRoleInfoDB";
/*  831 */       tError.functionName = "prepareData";
/*  832 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u5F3A\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u4E4B\u951F\u65A4\u62F7\u6CA1\u951F\u53EB\u5173\u95ED\uFF4F\u62F7";
/*  833 */       this.mErrors.addOneError(tError);
/*  834 */       return false;
/*      */     }
/*      */ 
/*  837 */     if (!this.mflag)
/*      */     {
/*  839 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  843 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  844 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  849 */       CError tError = new CError();
/*  850 */       tError.moduleName = "MRoleInfoDB";
/*  851 */       tError.functionName = "prepareData";
/*  852 */       tError.errorMessage = e.toString();
/*  853 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  856 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  862 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  866 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  870 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  875 */       return false;
/*      */     }
/*      */ 
/*  878 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  882 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  887 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  893 */     boolean flag = true;
/*  894 */     if (this.mResultSet == null)
/*      */     {
/*  896 */       CError tError = new CError();
/*  897 */       tError.moduleName = "MRoleInfoDB";
/*  898 */       tError.functionName = "hasMoreData";
/*  899 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/*  900 */       this.mErrors.addOneError(tError);
/*  901 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  905 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  909 */       CError tError = new CError();
/*  910 */       tError.moduleName = "MRoleInfoDB";
/*  911 */       tError.functionName = "hasMoreData";
/*  912 */       tError.errorMessage = ex.toString();
/*  913 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  916 */         this.mResultSet.close();
/*  917 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  923 */         this.mStatement.close();
/*  924 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  928 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  932 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  937 */       return false;
/*      */     }
/*  939 */     return flag;
/*      */   }
/*      */ 
/*      */   public MRoleInfoSet getData()
/*      */   {
/*  944 */     int tCount = 0;
/*  945 */     MRoleInfoSet tMRoleInfoSet = new MRoleInfoSet();
/*  946 */     MRoleInfoSchema tMRoleInfoSchema = null;
/*  947 */     if (this.mResultSet == null)
/*      */     {
/*  949 */       CError tError = new CError();
/*  950 */       tError.moduleName = "MRoleInfoDB";
/*  951 */       tError.functionName = "getData";
/*  952 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/*  953 */       this.mErrors.addOneError(tError);
/*  954 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  958 */       tCount = 1;
/*  959 */       tMRoleInfoSchema = new MRoleInfoSchema();
/*  960 */       tMRoleInfoSchema.setSchema(this.mResultSet, 1);
/*  961 */       tMRoleInfoSet.add(tMRoleInfoSchema);
/*      */ 
/*  963 */       while (tCount++ < 5000)
/*      */       {
/*  965 */         if (!this.mResultSet.next())
/*      */           continue;
/*  967 */         tMRoleInfoSchema = new MRoleInfoSchema();
/*  968 */         tMRoleInfoSchema.setSchema(this.mResultSet, 1);
/*  969 */         tMRoleInfoSet.add(tMRoleInfoSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  975 */       CError tError = new CError();
/*  976 */       tError.moduleName = "MRoleInfoDB";
/*  977 */       tError.functionName = "getData";
/*  978 */       tError.errorMessage = ex.toString();
/*  979 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  982 */         this.mResultSet.close();
/*  983 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  989 */         this.mStatement.close();
/*  990 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  994 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  998 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1003 */       return null;
/*      */     }
/* 1005 */     return tMRoleInfoSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1010 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1013 */       if (this.mResultSet == null)
/*      */       {
/* 1015 */         CError tError = new CError();
/* 1016 */         tError.moduleName = "MRoleInfoDB";
/* 1017 */         tError.functionName = "closeData";
/* 1018 */         tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 1019 */         this.mErrors.addOneError(tError);
/* 1020 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1024 */         this.mResultSet.close();
/* 1025 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1030 */       CError tError = new CError();
/* 1031 */       tError.moduleName = "MRoleInfoDB";
/* 1032 */       tError.functionName = "closeData";
/* 1033 */       tError.errorMessage = ex2.toString();
/* 1034 */       this.mErrors.addOneError(tError);
/* 1035 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1039 */       if (this.mStatement == null)
/*      */       {
/* 1041 */         CError tError = new CError();
/* 1042 */         tError.moduleName = "MRoleInfoDB";
/* 1043 */         tError.functionName = "closeData";
/* 1044 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 1045 */         this.mErrors.addOneError(tError);
/* 1046 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1050 */         this.mStatement.close();
/* 1051 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1056 */       CError tError = new CError();
/* 1057 */       tError.moduleName = "MRoleInfoDB";
/* 1058 */       tError.functionName = "closeData";
/* 1059 */       tError.errorMessage = ex3.toString();
/* 1060 */       this.mErrors.addOneError(tError);
/* 1061 */       flag = false;
/*      */     }
/* 1063 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MRoleInfoDB
 * JD-Core Version:    0.6.0
 */