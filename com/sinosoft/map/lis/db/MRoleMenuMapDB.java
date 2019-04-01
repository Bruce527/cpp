/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MRoleMenuMapSchema;
/*      */ import com.sinosoft.map.lis.vschema.MRoleMenuMapSet;
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
/*      */ public class MRoleMenuMapDB extends MRoleMenuMapSchema
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
/*      */   public MRoleMenuMapDB(Connection tConnection)
/*      */   {
/*   30 */     this.con = tConnection;
/*   31 */     this.db = new DBOper(this.con, "MRoleMenuMap");
/*   32 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MRoleMenuMapDB()
/*      */   {
/*   37 */     this.con = null;
/*   38 */     this.db = new DBOper("MRoleMenuMap");
/*   39 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   45 */     MRoleMenuMapSchema tSchema = getSchema();
/*   46 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   48 */       return true;
/*      */     }
/*      */ 
/*   53 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   54 */     CError tError = new CError();
/*   55 */     tError.moduleName = "MRoleMenuMapDB";
/*   56 */     tError.functionName = "deleteSQL";
/*   57 */     tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*   58 */     this.mErrors.addOneError(tError);
/*   59 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   65 */     MRoleMenuMapSchema tSchema = getSchema();
/*      */ 
/*   67 */     int tCount = this.db.getCount(tSchema);
/*   68 */     if (tCount < 0)
/*      */     {
/*   71 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   72 */       CError tError = new CError();
/*   73 */       tError.moduleName = "MRoleMenuMapDB";
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
/*   94 */       pstmt = this.con.prepareStatement("DELETE FROM MRoleMenuMap WHERE  ID = ?");
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
/*  106 */       tError.moduleName = "MRoleMenuMapDB";
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
/*  143 */       pstmt = this.con.prepareStatement("UPDATE MRoleMenuMap SET  ID = ? , RoleID = ? , MenuID = ? , Type = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Int1 = ? , Int2 = ? , Varc1 = ? , Varc2 = ? WHERE  ID = ?");
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
/*      */ 
/*  202 */       if ((getID() == null) || (getID().equals("null")))
/*  203 */         pstmt.setNull(14, 12);
/*      */       else {
/*  205 */         pstmt.setString(14, getID());
/*      */       }
/*  207 */       pstmt.executeUpdate();
/*  208 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  211 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  212 */       CError tError = new CError();
/*  213 */       tError.moduleName = "MRoleMenuMapDB";
/*  214 */       tError.functionName = "update()";
/*  215 */       tError.errorMessage = ex.toString();
/*  216 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  219 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  222 */       if (!this.mflag)
/*      */         try {
/*  224 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  228 */       return false;
/*      */     }
/*      */ 
/*  231 */     if (!this.mflag)
/*      */       try {
/*  233 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  237 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  242 */     PreparedStatement pstmt = null;
/*      */ 
/*  244 */     if (!this.mflag) {
/*  245 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  250 */       pstmt = this.con.prepareStatement("INSERT INTO MRoleMenuMap VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  251 */       if ((getID() == null) || (getID().equals("null")))
/*  252 */         pstmt.setNull(1, 12);
/*      */       else {
/*  254 */         pstmt.setString(1, getID());
/*      */       }
/*  256 */       if ((getRoleID() == null) || (getRoleID().equals("null")))
/*  257 */         pstmt.setNull(2, 12);
/*      */       else {
/*  259 */         pstmt.setString(2, getRoleID());
/*      */       }
/*  261 */       if ((getMenuID() == null) || (getMenuID().equals("null")))
/*  262 */         pstmt.setNull(3, 12);
/*      */       else {
/*  264 */         pstmt.setString(3, getMenuID());
/*      */       }
/*  266 */       if ((getType() == null) || (getType().equals("null")))
/*  267 */         pstmt.setNull(4, 12);
/*      */       else {
/*  269 */         pstmt.setString(4, getType());
/*      */       }
/*  271 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  272 */         pstmt.setNull(5, 12);
/*      */       else {
/*  274 */         pstmt.setString(5, getOperator());
/*      */       }
/*  276 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  277 */         pstmt.setNull(6, 91);
/*      */       else {
/*  279 */         pstmt.setDate(6, Date.valueOf(getMakeDate()));
/*      */       }
/*  281 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  282 */         pstmt.setNull(7, 12);
/*      */       else {
/*  284 */         pstmt.setString(7, getMakeTime());
/*      */       }
/*  286 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  287 */         pstmt.setNull(8, 91);
/*      */       else {
/*  289 */         pstmt.setDate(8, Date.valueOf(getModifyDate()));
/*      */       }
/*  291 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  292 */         pstmt.setNull(9, 12);
/*      */       else {
/*  294 */         pstmt.setString(9, getModifyTime());
/*      */       }
/*  296 */       pstmt.setInt(10, getInt1());
/*  297 */       pstmt.setInt(11, getInt2());
/*  298 */       if ((getVarc1() == null) || (getVarc1().equals("null")))
/*  299 */         pstmt.setNull(12, 12);
/*      */       else {
/*  301 */         pstmt.setString(12, getVarc1());
/*      */       }
/*  303 */       if ((getVarc2() == null) || (getVarc2().equals("null")))
/*  304 */         pstmt.setNull(13, 12);
/*      */       else {
/*  306 */         pstmt.setString(13, getVarc2());
/*      */       }
/*      */ 
/*  309 */       pstmt.executeUpdate();
/*  310 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  313 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  314 */       CError tError = new CError();
/*  315 */       tError.moduleName = "MRoleMenuMapDB";
/*  316 */       tError.functionName = "insert()";
/*  317 */       tError.errorMessage = ex.toString();
/*  318 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  321 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  324 */       if (!this.mflag)
/*      */         try {
/*  326 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  330 */       return false;
/*      */     }
/*      */ 
/*  333 */     if (!this.mflag)
/*      */       try {
/*  335 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  339 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  344 */     PreparedStatement pstmt = null;
/*  345 */     ResultSet rs = null;
/*      */ 
/*  347 */     if (!this.mflag) {
/*  348 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  353 */       pstmt = this.con.prepareStatement("SELECT * FROM MRoleMenuMap WHERE  ID = ?", 
/*  354 */         1003, 1007);
/*  355 */       if ((getID() == null) || (getID().equals("null")))
/*  356 */         pstmt.setNull(1, 12);
/*      */       else {
/*  358 */         pstmt.setString(1, getID());
/*      */       }
/*  360 */       rs = pstmt.executeQuery();
/*  361 */       int i = 0;
/*  362 */       if (rs.next())
/*      */       {
/*  364 */         i++;
/*  365 */         if (!setSchema(rs, i))
/*      */         {
/*  368 */           CError tError = new CError();
/*  369 */           tError.moduleName = "MRoleMenuMapDB";
/*  370 */           tError.functionName = "getInfo";
/*  371 */           tError.errorMessage = "\u53D6\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  372 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  374 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  377 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  381 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  385 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  389 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  392 */       if (i == 0)
/*      */       {
/*  394 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  398 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  402 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  408 */       CError tError = new CError();
/*  409 */       tError.moduleName = "MRoleMenuMapDB";
/*  410 */       tError.functionName = "getInfo";
/*  411 */       tError.errorMessage = e.toString();
/*  412 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  414 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  417 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  421 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  425 */       return false;
/*      */     }
/*      */ 
/*  428 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  432 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  437 */     return true;
/*      */   }
/*      */ 
/*      */   public MRoleMenuMapSet query()
/*      */   {
/*  442 */     Statement stmt = null;
/*  443 */     ResultSet rs = null;
/*  444 */     MRoleMenuMapSet aMRoleMenuMapSet = new MRoleMenuMapSet();
/*      */ 
/*  446 */     if (!this.mflag) {
/*  447 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  452 */       stmt = this.con.createStatement(1003, 1007);
/*  453 */       SQLString sqlObj = new SQLString("MRoleMenuMap");
/*  454 */       MRoleMenuMapSchema aSchema = getSchema();
/*  455 */       sqlObj.setSQL(5, aSchema);
/*  456 */       String sql = sqlObj.getSQL();
/*      */ 
/*  458 */       rs = stmt.executeQuery(sql);
/*  459 */       int i = 0;
/*  460 */       while (rs.next())
/*      */       {
/*  462 */         i++;
/*  463 */         MRoleMenuMapSchema s1 = new MRoleMenuMapSchema();
/*  464 */         s1.setSchema(rs, i);
/*  465 */         aMRoleMenuMapSet.add(s1);
/*      */       }try {
/*  467 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  473 */       CError tError = new CError();
/*  474 */       tError.moduleName = "MRoleMenuMapDB";
/*  475 */       tError.functionName = "query";
/*  476 */       tError.errorMessage = e.toString();
/*  477 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  479 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  482 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  486 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  492 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  496 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  501 */     return aMRoleMenuMapSet;
/*      */   }
/*      */ 
/*      */   public MRoleMenuMapSet executeQuery(String sql)
/*      */   {
/*  506 */     Statement stmt = null;
/*  507 */     ResultSet rs = null;
/*  508 */     MRoleMenuMapSet aMRoleMenuMapSet = new MRoleMenuMapSet();
/*      */ 
/*  510 */     if (!this.mflag) {
/*  511 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  516 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  518 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  519 */       int i = 0;
/*  520 */       while (rs.next())
/*      */       {
/*  522 */         i++;
/*  523 */         MRoleMenuMapSchema s1 = new MRoleMenuMapSchema();
/*  524 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  527 */           CError tError = new CError();
/*  528 */           tError.moduleName = "MRoleMenuMapDB";
/*  529 */           tError.functionName = "executeQuery";
/*  530 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  531 */           this.mErrors.addOneError(tError);
/*      */         }
/*  533 */         aMRoleMenuMapSet.add(s1);
/*      */       }try {
/*  535 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  541 */       CError tError = new CError();
/*  542 */       tError.moduleName = "MRoleMenuMapDB";
/*  543 */       tError.functionName = "executeQuery";
/*  544 */       tError.errorMessage = e.toString();
/*  545 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  547 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  550 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  554 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  560 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  564 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  569 */     return aMRoleMenuMapSet;
/*      */   }
/*      */ 
/*      */   public MRoleMenuMapSet query(int nStart, int nCount)
/*      */   {
/*  574 */     Statement stmt = null;
/*  575 */     ResultSet rs = null;
/*  576 */     MRoleMenuMapSet aMRoleMenuMapSet = new MRoleMenuMapSet();
/*      */ 
/*  578 */     if (!this.mflag) {
/*  579 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  584 */       stmt = this.con.createStatement(1003, 1007);
/*  585 */       SQLString sqlObj = new SQLString("MRoleMenuMap");
/*  586 */       MRoleMenuMapSchema aSchema = getSchema();
/*  587 */       sqlObj.setSQL(5, aSchema);
/*  588 */       String sql = sqlObj.getSQL();
/*      */ 
/*  590 */       rs = stmt.executeQuery(sql);
/*  591 */       int i = 0;
/*  592 */       while (rs.next())
/*      */       {
/*  594 */         i++;
/*      */ 
/*  596 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  600 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  604 */         MRoleMenuMapSchema s1 = new MRoleMenuMapSchema();
/*  605 */         s1.setSchema(rs, i);
/*  606 */         aMRoleMenuMapSet.add(s1);
/*      */       }try {
/*  608 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  614 */       CError tError = new CError();
/*  615 */       tError.moduleName = "MRoleMenuMapDB";
/*  616 */       tError.functionName = "query";
/*  617 */       tError.errorMessage = e.toString();
/*  618 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  620 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  623 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  627 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  633 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  637 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  642 */     return aMRoleMenuMapSet;
/*      */   }
/*      */ 
/*      */   public MRoleMenuMapSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  647 */     Statement stmt = null;
/*  648 */     ResultSet rs = null;
/*  649 */     MRoleMenuMapSet aMRoleMenuMapSet = new MRoleMenuMapSet();
/*      */ 
/*  651 */     if (!this.mflag) {
/*  652 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  657 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  659 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  660 */       int i = 0;
/*  661 */       while (rs.next())
/*      */       {
/*  663 */         i++;
/*      */ 
/*  665 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  669 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  673 */         MRoleMenuMapSchema s1 = new MRoleMenuMapSchema();
/*  674 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  677 */           CError tError = new CError();
/*  678 */           tError.moduleName = "MRoleMenuMapDB";
/*  679 */           tError.functionName = "executeQuery";
/*  680 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  681 */           this.mErrors.addOneError(tError);
/*      */         }
/*  683 */         aMRoleMenuMapSet.add(s1);
/*      */       }try {
/*  685 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  691 */       CError tError = new CError();
/*  692 */       tError.moduleName = "MRoleMenuMapDB";
/*  693 */       tError.functionName = "executeQuery";
/*  694 */       tError.errorMessage = e.toString();
/*  695 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  697 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  700 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  704 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  710 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  714 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  719 */     return aMRoleMenuMapSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  724 */     Statement stmt = null;
/*      */ 
/*  726 */     if (!this.mflag) {
/*  727 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  732 */       stmt = this.con.createStatement(1003, 1007);
/*  733 */       SQLString sqlObj = new SQLString("MRoleMenuMap");
/*  734 */       MRoleMenuMapSchema aSchema = getSchema();
/*  735 */       sqlObj.setSQL(2, aSchema);
/*  736 */       String sql = "update MRoleMenuMap " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  738 */       int operCount = stmt.executeUpdate(sql);
/*  739 */       if (operCount == 0)
/*      */       {
/*  742 */         CError tError = new CError();
/*  743 */         tError.moduleName = "MRoleMenuMapDB";
/*  744 */         tError.functionName = "update";
/*  745 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u7EDE\u044D\u62F7\u951F\uFFFD!";
/*  746 */         this.mErrors.addOneError(tError);
/*      */ 
/*  748 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  752 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  756 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  762 */       CError tError = new CError();
/*  763 */       tError.moduleName = "MRoleMenuMapDB";
/*  764 */       tError.functionName = "update";
/*  765 */       tError.errorMessage = e.toString();
/*  766 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  768 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  770 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  774 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  778 */       return false;
/*      */     }
/*      */ 
/*  781 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  785 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  790 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  796 */     if (this.mResultSet != null)
/*      */     {
/*  799 */       CError tError = new CError();
/*  800 */       tError.moduleName = "MRoleMenuMapDB";
/*  801 */       tError.functionName = "prepareData";
/*  802 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u5F3A\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u4E4B\u951F\u65A4\u62F7\u6CA1\u951F\u53EB\u5173\u95ED\uFF4F\u62F7";
/*  803 */       this.mErrors.addOneError(tError);
/*  804 */       return false;
/*      */     }
/*      */ 
/*  807 */     if (!this.mflag)
/*      */     {
/*  809 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  813 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  814 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  819 */       CError tError = new CError();
/*  820 */       tError.moduleName = "MRoleMenuMapDB";
/*  821 */       tError.functionName = "prepareData";
/*  822 */       tError.errorMessage = e.toString();
/*  823 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  826 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  832 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  836 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  840 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  845 */       return false;
/*      */     }
/*      */ 
/*  848 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  852 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  857 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  863 */     boolean flag = true;
/*  864 */     if (this.mResultSet == null)
/*      */     {
/*  866 */       CError tError = new CError();
/*  867 */       tError.moduleName = "MRoleMenuMapDB";
/*  868 */       tError.functionName = "hasMoreData";
/*  869 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/*  870 */       this.mErrors.addOneError(tError);
/*  871 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  875 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  879 */       CError tError = new CError();
/*  880 */       tError.moduleName = "MRoleMenuMapDB";
/*  881 */       tError.functionName = "hasMoreData";
/*  882 */       tError.errorMessage = ex.toString();
/*  883 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  886 */         this.mResultSet.close();
/*  887 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  893 */         this.mStatement.close();
/*  894 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  898 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  902 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  907 */       return false;
/*      */     }
/*  909 */     return flag;
/*      */   }
/*      */ 
/*      */   public MRoleMenuMapSet getData()
/*      */   {
/*  914 */     int tCount = 0;
/*  915 */     MRoleMenuMapSet tMRoleMenuMapSet = new MRoleMenuMapSet();
/*  916 */     MRoleMenuMapSchema tMRoleMenuMapSchema = null;
/*  917 */     if (this.mResultSet == null)
/*      */     {
/*  919 */       CError tError = new CError();
/*  920 */       tError.moduleName = "MRoleMenuMapDB";
/*  921 */       tError.functionName = "getData";
/*  922 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/*  923 */       this.mErrors.addOneError(tError);
/*  924 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  928 */       tCount = 1;
/*  929 */       tMRoleMenuMapSchema = new MRoleMenuMapSchema();
/*  930 */       tMRoleMenuMapSchema.setSchema(this.mResultSet, 1);
/*  931 */       tMRoleMenuMapSet.add(tMRoleMenuMapSchema);
/*      */ 
/*  933 */       while (tCount++ < 5000)
/*      */       {
/*  935 */         if (!this.mResultSet.next())
/*      */           continue;
/*  937 */         tMRoleMenuMapSchema = new MRoleMenuMapSchema();
/*  938 */         tMRoleMenuMapSchema.setSchema(this.mResultSet, 1);
/*  939 */         tMRoleMenuMapSet.add(tMRoleMenuMapSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  945 */       CError tError = new CError();
/*  946 */       tError.moduleName = "MRoleMenuMapDB";
/*  947 */       tError.functionName = "getData";
/*  948 */       tError.errorMessage = ex.toString();
/*  949 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  952 */         this.mResultSet.close();
/*  953 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  959 */         this.mStatement.close();
/*  960 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  964 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  968 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  973 */       return null;
/*      */     }
/*  975 */     return tMRoleMenuMapSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/*  980 */     boolean flag = true;
/*      */     try
/*      */     {
/*  983 */       if (this.mResultSet == null)
/*      */       {
/*  985 */         CError tError = new CError();
/*  986 */         tError.moduleName = "MRoleMenuMapDB";
/*  987 */         tError.functionName = "closeData";
/*  988 */         tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/*  989 */         this.mErrors.addOneError(tError);
/*  990 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/*  994 */         this.mResultSet.close();
/*  995 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1000 */       CError tError = new CError();
/* 1001 */       tError.moduleName = "MRoleMenuMapDB";
/* 1002 */       tError.functionName = "closeData";
/* 1003 */       tError.errorMessage = ex2.toString();
/* 1004 */       this.mErrors.addOneError(tError);
/* 1005 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1009 */       if (this.mStatement == null)
/*      */       {
/* 1011 */         CError tError = new CError();
/* 1012 */         tError.moduleName = "MRoleMenuMapDB";
/* 1013 */         tError.functionName = "closeData";
/* 1014 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 1015 */         this.mErrors.addOneError(tError);
/* 1016 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1020 */         this.mStatement.close();
/* 1021 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1026 */       CError tError = new CError();
/* 1027 */       tError.moduleName = "MRoleMenuMapDB";
/* 1028 */       tError.functionName = "closeData";
/* 1029 */       tError.errorMessage = ex3.toString();
/* 1030 */       this.mErrors.addOneError(tError);
/* 1031 */       flag = false;
/*      */     }
/* 1033 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MRoleMenuMapDB
 * JD-Core Version:    0.6.0
 */