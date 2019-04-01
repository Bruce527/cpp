/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MUserLogSchema;
/*      */ import com.sinosoft.map.lis.vschema.MUserLogSet;
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
/*      */ public class MUserLogDB extends MUserLogSchema
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
/*      */   public MUserLogDB(Connection tConnection)
/*      */   {
/*   30 */     this.con = tConnection;
/*   31 */     this.db = new DBOper(this.con, "MUserLog");
/*   32 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MUserLogDB()
/*      */   {
/*   37 */     this.con = null;
/*   38 */     this.db = new DBOper("MUserLog");
/*   39 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   45 */     MUserLogSchema tSchema = getSchema();
/*   46 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   48 */       return true;
/*      */     }
/*      */ 
/*   53 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   54 */     CError tError = new CError();
/*   55 */     tError.moduleName = "MUserLogDB";
/*   56 */     tError.functionName = "deleteSQL";
/*   57 */     tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*   58 */     this.mErrors.addOneError(tError);
/*   59 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   65 */     MUserLogSchema tSchema = getSchema();
/*      */ 
/*   67 */     int tCount = this.db.getCount(tSchema);
/*   68 */     if (tCount < 0)
/*      */     {
/*   71 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   72 */       CError tError = new CError();
/*   73 */       tError.moduleName = "MUserLogDB";
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
/*   94 */       pstmt = this.con.prepareStatement("DELETE FROM MUserLog WHERE  ID = ?");
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
/*  106 */       tError.moduleName = "MUserLogDB";
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
/*  143 */       pstmt = this.con.prepareStatement("UPDATE MUserLog SET  ID = ? , UserCode = ? , UserType = ? , TraceType = ? , MenuID = ? , MenuName = ? , Operation = ? , Discription = ? , CientIP = ? , MakeDate = ? , MakeTime = ? WHERE  ID = ?");
/*  144 */       if ((getID() == null) || (getID().equals("null")))
/*  145 */         pstmt.setNull(1, 12);
/*      */       else {
/*  147 */         pstmt.setString(1, getID());
/*      */       }
/*  149 */       if ((getUserCode() == null) || (getUserCode().equals("null")))
/*  150 */         pstmt.setNull(2, 12);
/*      */       else {
/*  152 */         pstmt.setString(2, getUserCode());
/*      */       }
/*  154 */       if ((getUserType() == null) || (getUserType().equals("null")))
/*  155 */         pstmt.setNull(3, 12);
/*      */       else {
/*  157 */         pstmt.setString(3, getUserType());
/*      */       }
/*  159 */       if ((getTraceType() == null) || (getTraceType().equals("null")))
/*  160 */         pstmt.setNull(4, 12);
/*      */       else {
/*  162 */         pstmt.setString(4, getTraceType());
/*      */       }
/*  164 */       if ((getMenuID() == null) || (getMenuID().equals("null")))
/*  165 */         pstmt.setNull(5, 12);
/*      */       else {
/*  167 */         pstmt.setString(5, getMenuID());
/*      */       }
/*  169 */       if ((getMenuName() == null) || (getMenuName().equals("null")))
/*  170 */         pstmt.setNull(6, 12);
/*      */       else {
/*  172 */         pstmt.setString(6, getMenuName());
/*      */       }
/*  174 */       if ((getOperation() == null) || (getOperation().equals("null")))
/*  175 */         pstmt.setNull(7, 12);
/*      */       else {
/*  177 */         pstmt.setString(7, getOperation());
/*      */       }
/*  179 */       if ((getDiscription() == null) || (getDiscription().equals("null")))
/*  180 */         pstmt.setNull(8, 12);
/*      */       else {
/*  182 */         pstmt.setString(8, getDiscription());
/*      */       }
/*  184 */       if ((getCientIP() == null) || (getCientIP().equals("null")))
/*  185 */         pstmt.setNull(9, 12);
/*      */       else {
/*  187 */         pstmt.setString(9, getCientIP());
/*      */       }
/*  189 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  190 */         pstmt.setNull(10, 91);
/*      */       else {
/*  192 */         pstmt.setDate(10, Date.valueOf(getMakeDate()));
/*      */       }
/*  194 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  195 */         pstmt.setNull(11, 12);
/*      */       else {
/*  197 */         pstmt.setString(11, getMakeTime());
/*      */       }
/*      */ 
/*  200 */       if ((getID() == null) || (getID().equals("null")))
/*  201 */         pstmt.setNull(12, 12);
/*      */       else {
/*  203 */         pstmt.setString(12, getID());
/*      */       }
/*  205 */       pstmt.executeUpdate();
/*  206 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  209 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  210 */       CError tError = new CError();
/*  211 */       tError.moduleName = "MUserLogDB";
/*  212 */       tError.functionName = "update()";
/*  213 */       tError.errorMessage = ex.toString();
/*  214 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  217 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  220 */       if (!this.mflag)
/*      */         try {
/*  222 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  226 */       return false;
/*      */     }
/*      */ 
/*  229 */     if (!this.mflag)
/*      */       try {
/*  231 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  235 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  240 */     PreparedStatement pstmt = null;
/*      */ 
/*  242 */     if (!this.mflag) {
/*  243 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  248 */       pstmt = this.con.prepareStatement("INSERT INTO MUserLog VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  249 */       if ((getID() == null) || (getID().equals("null")))
/*  250 */         pstmt.setNull(1, 12);
/*      */       else {
/*  252 */         pstmt.setString(1, getID());
/*      */       }
/*  254 */       if ((getUserCode() == null) || (getUserCode().equals("null")))
/*  255 */         pstmt.setNull(2, 12);
/*      */       else {
/*  257 */         pstmt.setString(2, getUserCode());
/*      */       }
/*  259 */       if ((getUserType() == null) || (getUserType().equals("null")))
/*  260 */         pstmt.setNull(3, 12);
/*      */       else {
/*  262 */         pstmt.setString(3, getUserType());
/*      */       }
/*  264 */       if ((getTraceType() == null) || (getTraceType().equals("null")))
/*  265 */         pstmt.setNull(4, 12);
/*      */       else {
/*  267 */         pstmt.setString(4, getTraceType());
/*      */       }
/*  269 */       if ((getMenuID() == null) || (getMenuID().equals("null")))
/*  270 */         pstmt.setNull(5, 12);
/*      */       else {
/*  272 */         pstmt.setString(5, getMenuID());
/*      */       }
/*  274 */       if ((getMenuName() == null) || (getMenuName().equals("null")))
/*  275 */         pstmt.setNull(6, 12);
/*      */       else {
/*  277 */         pstmt.setString(6, getMenuName());
/*      */       }
/*  279 */       if ((getOperation() == null) || (getOperation().equals("null")))
/*  280 */         pstmt.setNull(7, 12);
/*      */       else {
/*  282 */         pstmt.setString(7, getOperation());
/*      */       }
/*  284 */       if ((getDiscription() == null) || (getDiscription().equals("null")))
/*  285 */         pstmt.setNull(8, 12);
/*      */       else {
/*  287 */         pstmt.setString(8, getDiscription());
/*      */       }
/*  289 */       if ((getCientIP() == null) || (getCientIP().equals("null")))
/*  290 */         pstmt.setNull(9, 12);
/*      */       else {
/*  292 */         pstmt.setString(9, getCientIP());
/*      */       }
/*  294 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  295 */         pstmt.setNull(10, 91);
/*      */       else {
/*  297 */         pstmt.setDate(10, Date.valueOf(getMakeDate()));
/*      */       }
/*  299 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  300 */         pstmt.setNull(11, 12);
/*      */       else {
/*  302 */         pstmt.setString(11, getMakeTime());
/*      */       }
/*      */ 
/*  305 */       pstmt.executeUpdate();
/*  306 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  309 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  310 */       CError tError = new CError();
/*  311 */       tError.moduleName = "MUserLogDB";
/*  312 */       tError.functionName = "insert()";
/*  313 */       tError.errorMessage = ex.toString();
/*  314 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  317 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  320 */       if (!this.mflag)
/*      */         try {
/*  322 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  326 */       return false;
/*      */     }
/*      */ 
/*  329 */     if (!this.mflag)
/*      */       try {
/*  331 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  335 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  340 */     PreparedStatement pstmt = null;
/*  341 */     ResultSet rs = null;
/*      */ 
/*  343 */     if (!this.mflag) {
/*  344 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  349 */       pstmt = this.con.prepareStatement("SELECT * FROM MUserLog WHERE  ID = ?", 
/*  350 */         1003, 1007);
/*  351 */       if ((getID() == null) || (getID().equals("null")))
/*  352 */         pstmt.setNull(1, 12);
/*      */       else {
/*  354 */         pstmt.setString(1, getID());
/*      */       }
/*  356 */       rs = pstmt.executeQuery();
/*  357 */       int i = 0;
/*  358 */       if (rs.next())
/*      */       {
/*  360 */         i++;
/*  361 */         if (!setSchema(rs, i))
/*      */         {
/*  364 */           CError tError = new CError();
/*  365 */           tError.moduleName = "MUserLogDB";
/*  366 */           tError.functionName = "getInfo";
/*  367 */           tError.errorMessage = "\u53D6\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  368 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  370 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  373 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  377 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  381 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  385 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  388 */       if (i == 0)
/*      */       {
/*  390 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  394 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  398 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  404 */       CError tError = new CError();
/*  405 */       tError.moduleName = "MUserLogDB";
/*  406 */       tError.functionName = "getInfo";
/*  407 */       tError.errorMessage = e.toString();
/*  408 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  410 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  413 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  417 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  421 */       return false;
/*      */     }
/*      */ 
/*  424 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  428 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  433 */     return true;
/*      */   }
/*      */ 
/*      */   public MUserLogSet query()
/*      */   {
/*  438 */     Statement stmt = null;
/*  439 */     ResultSet rs = null;
/*  440 */     MUserLogSet aMUserLogSet = new MUserLogSet();
/*      */ 
/*  442 */     if (!this.mflag) {
/*  443 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  448 */       stmt = this.con.createStatement(1003, 1007);
/*  449 */       SQLString sqlObj = new SQLString("MUserLog");
/*  450 */       MUserLogSchema aSchema = getSchema();
/*  451 */       sqlObj.setSQL(5, aSchema);
/*  452 */       String sql = sqlObj.getSQL();
/*      */ 
/*  454 */       rs = stmt.executeQuery(sql);
/*  455 */       int i = 0;
/*  456 */       while (rs.next())
/*      */       {
/*  458 */         i++;
/*  459 */         MUserLogSchema s1 = new MUserLogSchema();
/*  460 */         s1.setSchema(rs, i);
/*  461 */         aMUserLogSet.add(s1);
/*      */       }try {
/*  463 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  469 */       CError tError = new CError();
/*  470 */       tError.moduleName = "MUserLogDB";
/*  471 */       tError.functionName = "query";
/*  472 */       tError.errorMessage = e.toString();
/*  473 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  475 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  478 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  482 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  488 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  492 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  497 */     return aMUserLogSet;
/*      */   }
/*      */ 
/*      */   public MUserLogSet executeQuery(String sql)
/*      */   {
/*  502 */     Statement stmt = null;
/*  503 */     ResultSet rs = null;
/*  504 */     MUserLogSet aMUserLogSet = new MUserLogSet();
/*      */ 
/*  506 */     if (!this.mflag) {
/*  507 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  512 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  514 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  515 */       int i = 0;
/*  516 */       while (rs.next())
/*      */       {
/*  518 */         i++;
/*  519 */         MUserLogSchema s1 = new MUserLogSchema();
/*  520 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  523 */           CError tError = new CError();
/*  524 */           tError.moduleName = "MUserLogDB";
/*  525 */           tError.functionName = "executeQuery";
/*  526 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  527 */           this.mErrors.addOneError(tError);
/*      */         }
/*  529 */         aMUserLogSet.add(s1);
/*      */       }try {
/*  531 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  537 */       CError tError = new CError();
/*  538 */       tError.moduleName = "MUserLogDB";
/*  539 */       tError.functionName = "executeQuery";
/*  540 */       tError.errorMessage = e.toString();
/*  541 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  543 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  546 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  550 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  556 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  560 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  565 */     return aMUserLogSet;
/*      */   }
/*      */ 
/*      */   public MUserLogSet query(int nStart, int nCount)
/*      */   {
/*  570 */     Statement stmt = null;
/*  571 */     ResultSet rs = null;
/*  572 */     MUserLogSet aMUserLogSet = new MUserLogSet();
/*      */ 
/*  574 */     if (!this.mflag) {
/*  575 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  580 */       stmt = this.con.createStatement(1003, 1007);
/*  581 */       SQLString sqlObj = new SQLString("MUserLog");
/*  582 */       MUserLogSchema aSchema = getSchema();
/*  583 */       sqlObj.setSQL(5, aSchema);
/*  584 */       String sql = sqlObj.getSQL();
/*      */ 
/*  586 */       rs = stmt.executeQuery(sql);
/*  587 */       int i = 0;
/*  588 */       while (rs.next())
/*      */       {
/*  590 */         i++;
/*      */ 
/*  592 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  596 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  600 */         MUserLogSchema s1 = new MUserLogSchema();
/*  601 */         s1.setSchema(rs, i);
/*  602 */         aMUserLogSet.add(s1);
/*      */       }try {
/*  604 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  610 */       CError tError = new CError();
/*  611 */       tError.moduleName = "MUserLogDB";
/*  612 */       tError.functionName = "query";
/*  613 */       tError.errorMessage = e.toString();
/*  614 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  616 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  619 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  623 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  629 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  633 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  638 */     return aMUserLogSet;
/*      */   }
/*      */ 
/*      */   public MUserLogSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  643 */     Statement stmt = null;
/*  644 */     ResultSet rs = null;
/*  645 */     MUserLogSet aMUserLogSet = new MUserLogSet();
/*      */ 
/*  647 */     if (!this.mflag) {
/*  648 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  653 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  655 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  656 */       int i = 0;
/*  657 */       while (rs.next())
/*      */       {
/*  659 */         i++;
/*      */ 
/*  661 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  665 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  669 */         MUserLogSchema s1 = new MUserLogSchema();
/*  670 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  673 */           CError tError = new CError();
/*  674 */           tError.moduleName = "MUserLogDB";
/*  675 */           tError.functionName = "executeQuery";
/*  676 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  677 */           this.mErrors.addOneError(tError);
/*      */         }
/*  679 */         aMUserLogSet.add(s1);
/*      */       }try {
/*  681 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  687 */       CError tError = new CError();
/*  688 */       tError.moduleName = "MUserLogDB";
/*  689 */       tError.functionName = "executeQuery";
/*  690 */       tError.errorMessage = e.toString();
/*  691 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  693 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  696 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  700 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  706 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  710 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  715 */     return aMUserLogSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  720 */     Statement stmt = null;
/*      */ 
/*  722 */     if (!this.mflag) {
/*  723 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  728 */       stmt = this.con.createStatement(1003, 1007);
/*  729 */       SQLString sqlObj = new SQLString("MUserLog");
/*  730 */       MUserLogSchema aSchema = getSchema();
/*  731 */       sqlObj.setSQL(2, aSchema);
/*  732 */       String sql = "update MUserLog " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  734 */       int operCount = stmt.executeUpdate(sql);
/*  735 */       if (operCount == 0)
/*      */       {
/*  738 */         CError tError = new CError();
/*  739 */         tError.moduleName = "MUserLogDB";
/*  740 */         tError.functionName = "update";
/*  741 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u7EDE\u044D\u62F7\u951F\uFFFD!";
/*  742 */         this.mErrors.addOneError(tError);
/*      */ 
/*  744 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  748 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  752 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  758 */       CError tError = new CError();
/*  759 */       tError.moduleName = "MUserLogDB";
/*  760 */       tError.functionName = "update";
/*  761 */       tError.errorMessage = e.toString();
/*  762 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  764 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  766 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  770 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  774 */       return false;
/*      */     }
/*      */ 
/*  777 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  781 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  786 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  792 */     if (this.mResultSet != null)
/*      */     {
/*  795 */       CError tError = new CError();
/*  796 */       tError.moduleName = "MUserLogDB";
/*  797 */       tError.functionName = "prepareData";
/*  798 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u5F3A\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u4E4B\u951F\u65A4\u62F7\u6CA1\u951F\u53EB\u5173\u95ED\uFF4F\u62F7";
/*  799 */       this.mErrors.addOneError(tError);
/*  800 */       return false;
/*      */     }
/*      */ 
/*  803 */     if (!this.mflag)
/*      */     {
/*  805 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  809 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  810 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  815 */       CError tError = new CError();
/*  816 */       tError.moduleName = "MUserLogDB";
/*  817 */       tError.functionName = "prepareData";
/*  818 */       tError.errorMessage = e.toString();
/*  819 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  822 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  828 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  832 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  836 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  841 */       return false;
/*      */     }
/*      */ 
/*  844 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  848 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  853 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  859 */     boolean flag = true;
/*  860 */     if (this.mResultSet == null)
/*      */     {
/*  862 */       CError tError = new CError();
/*  863 */       tError.moduleName = "MUserLogDB";
/*  864 */       tError.functionName = "hasMoreData";
/*  865 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/*  866 */       this.mErrors.addOneError(tError);
/*  867 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  871 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  875 */       CError tError = new CError();
/*  876 */       tError.moduleName = "MUserLogDB";
/*  877 */       tError.functionName = "hasMoreData";
/*  878 */       tError.errorMessage = ex.toString();
/*  879 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  882 */         this.mResultSet.close();
/*  883 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  889 */         this.mStatement.close();
/*  890 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  894 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  898 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  903 */       return false;
/*      */     }
/*  905 */     return flag;
/*      */   }
/*      */ 
/*      */   public MUserLogSet getData()
/*      */   {
/*  910 */     int tCount = 0;
/*  911 */     MUserLogSet tMUserLogSet = new MUserLogSet();
/*  912 */     MUserLogSchema tMUserLogSchema = null;
/*  913 */     if (this.mResultSet == null)
/*      */     {
/*  915 */       CError tError = new CError();
/*  916 */       tError.moduleName = "MUserLogDB";
/*  917 */       tError.functionName = "getData";
/*  918 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/*  919 */       this.mErrors.addOneError(tError);
/*  920 */       return null;
/*      */     }
/*      */     try
/*      */     {
/*  924 */       tCount = 1;
/*  925 */       tMUserLogSchema = new MUserLogSchema();
/*  926 */       tMUserLogSchema.setSchema(this.mResultSet, 1);
/*  927 */       tMUserLogSet.add(tMUserLogSchema);
/*      */ 
/*  929 */       while (tCount++ < 5000)
/*      */       {
/*  931 */         if (!this.mResultSet.next())
/*      */           continue;
/*  933 */         tMUserLogSchema = new MUserLogSchema();
/*  934 */         tMUserLogSchema.setSchema(this.mResultSet, 1);
/*  935 */         tMUserLogSet.add(tMUserLogSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  941 */       CError tError = new CError();
/*  942 */       tError.moduleName = "MUserLogDB";
/*  943 */       tError.functionName = "getData";
/*  944 */       tError.errorMessage = ex.toString();
/*  945 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  948 */         this.mResultSet.close();
/*  949 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  955 */         this.mStatement.close();
/*  956 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  960 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  964 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  969 */       return null;
/*      */     }
/*  971 */     return tMUserLogSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/*  976 */     boolean flag = true;
/*      */     try
/*      */     {
/*  979 */       if (this.mResultSet == null)
/*      */       {
/*  981 */         CError tError = new CError();
/*  982 */         tError.moduleName = "MUserLogDB";
/*  983 */         tError.functionName = "closeData";
/*  984 */         tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/*  985 */         this.mErrors.addOneError(tError);
/*  986 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/*  990 */         this.mResultSet.close();
/*  991 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/*  996 */       CError tError = new CError();
/*  997 */       tError.moduleName = "MUserLogDB";
/*  998 */       tError.functionName = "closeData";
/*  999 */       tError.errorMessage = ex2.toString();
/* 1000 */       this.mErrors.addOneError(tError);
/* 1001 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1005 */       if (this.mStatement == null)
/*      */       {
/* 1007 */         CError tError = new CError();
/* 1008 */         tError.moduleName = "MUserLogDB";
/* 1009 */         tError.functionName = "closeData";
/* 1010 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 1011 */         this.mErrors.addOneError(tError);
/* 1012 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1016 */         this.mStatement.close();
/* 1017 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1022 */       CError tError = new CError();
/* 1023 */       tError.moduleName = "MUserLogDB";
/* 1024 */       tError.functionName = "closeData";
/* 1025 */       tError.errorMessage = ex3.toString();
/* 1026 */       this.mErrors.addOneError(tError);
/* 1027 */       flag = false;
/*      */     }
/* 1029 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MUserLogDB
 * JD-Core Version:    0.6.0
 */