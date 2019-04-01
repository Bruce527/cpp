/*      */ package com.sinosoft.map.lis.db;
/*      */ 
/*      */ import com.sinosoft.map.lis.schema.MSysLinkSchema;
/*      */ import com.sinosoft.map.lis.vschema.MSysLinkSet;
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
/*      */ public class MSysLinkDB extends MSysLinkSchema
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
/*      */   public MSysLinkDB(Connection tConnection)
/*      */   {
/*   30 */     this.con = tConnection;
/*   31 */     this.db = new DBOper(this.con, "MSysLink");
/*   32 */     this.mflag = true;
/*      */   }
/*      */ 
/*      */   public MSysLinkDB()
/*      */   {
/*   37 */     this.con = null;
/*   38 */     this.db = new DBOper("MSysLink");
/*   39 */     this.mflag = false;
/*      */   }
/*      */ 
/*      */   public boolean deleteSQL()
/*      */   {
/*   45 */     MSysLinkSchema tSchema = getSchema();
/*   46 */     if (this.db.deleteSQL(tSchema))
/*      */     {
/*   48 */       return true;
/*      */     }
/*      */ 
/*   53 */     this.mErrors.copyAllErrors(this.db.mErrors);
/*   54 */     CError tError = new CError();
/*   55 */     tError.moduleName = "MSysLinkDB";
/*   56 */     tError.functionName = "deleteSQL";
/*   57 */     tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*   58 */     this.mErrors.addOneError(tError);
/*   59 */     return false;
/*      */   }
/*      */ 
/*      */   public int getCount()
/*      */   {
/*   65 */     MSysLinkSchema tSchema = getSchema();
/*      */ 
/*   67 */     int tCount = this.db.getCount(tSchema);
/*   68 */     if (tCount < 0)
/*      */     {
/*   71 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*   72 */       CError tError = new CError();
/*   73 */       tError.moduleName = "MSysLinkDB";
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
/*   94 */       pstmt = this.con.prepareStatement("DELETE FROM MSysLink WHERE  ID = ?");
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
/*  106 */       tError.moduleName = "MSysLinkDB";
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
/*  143 */       pstmt = this.con.prepareStatement("UPDATE MSysLink SET  ID = ? , RefURL = ? , Target = ? , Name = ? , LinkOrder = ? , State = ? , Type = ? , Icon = ? , ManageCom = ? , BranchType = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Description = ? WHERE  ID = ?");
/*  144 */       if ((getID() == null) || (getID().equals("null")))
/*  145 */         pstmt.setNull(1, 12);
/*      */       else {
/*  147 */         pstmt.setString(1, getID());
/*      */       }
/*  149 */       if ((getRefURL() == null) || (getRefURL().equals("null")))
/*  150 */         pstmt.setNull(2, 12);
/*      */       else {
/*  152 */         pstmt.setString(2, getRefURL());
/*      */       }
/*  154 */       if ((getTarget() == null) || (getTarget().equals("null")))
/*  155 */         pstmt.setNull(3, 12);
/*      */       else {
/*  157 */         pstmt.setString(3, getTarget());
/*      */       }
/*  159 */       if ((getName() == null) || (getName().equals("null")))
/*  160 */         pstmt.setNull(4, 12);
/*      */       else {
/*  162 */         pstmt.setString(4, getName());
/*      */       }
/*  164 */       pstmt.setInt(5, getLinkOrder());
/*  165 */       if ((getState() == null) || (getState().equals("null")))
/*  166 */         pstmt.setNull(6, 12);
/*      */       else {
/*  168 */         pstmt.setString(6, getState());
/*      */       }
/*  170 */       if ((getType() == null) || (getType().equals("null")))
/*  171 */         pstmt.setNull(7, 12);
/*      */       else {
/*  173 */         pstmt.setString(7, getType());
/*      */       }
/*  175 */       if ((getIcon() == null) || (getIcon().equals("null")))
/*  176 */         pstmt.setNull(8, 12);
/*      */       else {
/*  178 */         pstmt.setString(8, getIcon());
/*      */       }
/*  180 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  181 */         pstmt.setNull(9, 12);
/*      */       else {
/*  183 */         pstmt.setString(9, getManageCom());
/*      */       }
/*  185 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  186 */         pstmt.setNull(10, 12);
/*      */       else {
/*  188 */         pstmt.setString(10, getBranchType());
/*      */       }
/*  190 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  191 */         pstmt.setNull(11, 12);
/*      */       else {
/*  193 */         pstmt.setString(11, getVF01());
/*      */       }
/*  195 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  196 */         pstmt.setNull(12, 12);
/*      */       else {
/*  198 */         pstmt.setString(12, getNF01());
/*      */       }
/*  200 */       pstmt.setInt(13, getIF01());
/*  201 */       pstmt.setDouble(14, getDF02());
/*  202 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  203 */         pstmt.setNull(15, 91);
/*      */       else {
/*  205 */         pstmt.setDate(15, Date.valueOf(getDate01()));
/*      */       }
/*  207 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  208 */         pstmt.setNull(16, 12);
/*      */       else {
/*  210 */         pstmt.setString(16, getModifyOperator());
/*      */       }
/*  212 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  213 */         pstmt.setNull(17, 12);
/*      */       else {
/*  215 */         pstmt.setString(17, getOperator());
/*      */       }
/*  217 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  218 */         pstmt.setNull(18, 91);
/*      */       else {
/*  220 */         pstmt.setDate(18, Date.valueOf(getMakeDate()));
/*      */       }
/*  222 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  223 */         pstmt.setNull(19, 12);
/*      */       else {
/*  225 */         pstmt.setString(19, getMakeTime());
/*      */       }
/*  227 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  228 */         pstmt.setNull(20, 91);
/*      */       else {
/*  230 */         pstmt.setDate(20, Date.valueOf(getModifyDate()));
/*      */       }
/*  232 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  233 */         pstmt.setNull(21, 12);
/*      */       else {
/*  235 */         pstmt.setString(21, getModifyTime());
/*      */       }
/*  237 */       if ((getDescription() == null) || (getDescription().equals("null")))
/*  238 */         pstmt.setNull(22, 12);
/*      */       else {
/*  240 */         pstmt.setString(22, getDescription());
/*      */       }
/*      */ 
/*  243 */       if ((getID() == null) || (getID().equals("null")))
/*  244 */         pstmt.setNull(23, 12);
/*      */       else {
/*  246 */         pstmt.setString(23, getID());
/*      */       }
/*  248 */       pstmt.executeUpdate();
/*  249 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  252 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  253 */       CError tError = new CError();
/*  254 */       tError.moduleName = "MSysLinkDB";
/*  255 */       tError.functionName = "update()";
/*  256 */       tError.errorMessage = ex.toString();
/*  257 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  260 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  263 */       if (!this.mflag)
/*      */         try {
/*  265 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  269 */       return false;
/*      */     }
/*      */ 
/*  272 */     if (!this.mflag)
/*      */       try {
/*  274 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  278 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean insert()
/*      */   {
/*  283 */     PreparedStatement pstmt = null;
/*      */ 
/*  285 */     if (!this.mflag) {
/*  286 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  291 */       pstmt = this.con.prepareStatement("INSERT INTO MSysLink VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
/*  292 */       if ((getID() == null) || (getID().equals("null")))
/*  293 */         pstmt.setNull(1, 12);
/*      */       else {
/*  295 */         pstmt.setString(1, getID());
/*      */       }
/*  297 */       if ((getRefURL() == null) || (getRefURL().equals("null")))
/*  298 */         pstmt.setNull(2, 12);
/*      */       else {
/*  300 */         pstmt.setString(2, getRefURL());
/*      */       }
/*  302 */       if ((getTarget() == null) || (getTarget().equals("null")))
/*  303 */         pstmt.setNull(3, 12);
/*      */       else {
/*  305 */         pstmt.setString(3, getTarget());
/*      */       }
/*  307 */       if ((getName() == null) || (getName().equals("null")))
/*  308 */         pstmt.setNull(4, 12);
/*      */       else {
/*  310 */         pstmt.setString(4, getName());
/*      */       }
/*  312 */       pstmt.setInt(5, getLinkOrder());
/*  313 */       if ((getState() == null) || (getState().equals("null")))
/*  314 */         pstmt.setNull(6, 12);
/*      */       else {
/*  316 */         pstmt.setString(6, getState());
/*      */       }
/*  318 */       if ((getType() == null) || (getType().equals("null")))
/*  319 */         pstmt.setNull(7, 12);
/*      */       else {
/*  321 */         pstmt.setString(7, getType());
/*      */       }
/*  323 */       if ((getIcon() == null) || (getIcon().equals("null")))
/*  324 */         pstmt.setNull(8, 12);
/*      */       else {
/*  326 */         pstmt.setString(8, getIcon());
/*      */       }
/*  328 */       if ((getManageCom() == null) || (getManageCom().equals("null")))
/*  329 */         pstmt.setNull(9, 12);
/*      */       else {
/*  331 */         pstmt.setString(9, getManageCom());
/*      */       }
/*  333 */       if ((getBranchType() == null) || (getBranchType().equals("null")))
/*  334 */         pstmt.setNull(10, 12);
/*      */       else {
/*  336 */         pstmt.setString(10, getBranchType());
/*      */       }
/*  338 */       if ((getVF01() == null) || (getVF01().equals("null")))
/*  339 */         pstmt.setNull(11, 12);
/*      */       else {
/*  341 */         pstmt.setString(11, getVF01());
/*      */       }
/*  343 */       if ((getNF01() == null) || (getNF01().equals("null")))
/*  344 */         pstmt.setNull(12, 12);
/*      */       else {
/*  346 */         pstmt.setString(12, getNF01());
/*      */       }
/*  348 */       pstmt.setInt(13, getIF01());
/*  349 */       pstmt.setDouble(14, getDF02());
/*  350 */       if ((getDate01() == null) || (getDate01().equals("null")))
/*  351 */         pstmt.setNull(15, 91);
/*      */       else {
/*  353 */         pstmt.setDate(15, Date.valueOf(getDate01()));
/*      */       }
/*  355 */       if ((getModifyOperator() == null) || (getModifyOperator().equals("null")))
/*  356 */         pstmt.setNull(16, 12);
/*      */       else {
/*  358 */         pstmt.setString(16, getModifyOperator());
/*      */       }
/*  360 */       if ((getOperator() == null) || (getOperator().equals("null")))
/*  361 */         pstmt.setNull(17, 12);
/*      */       else {
/*  363 */         pstmt.setString(17, getOperator());
/*      */       }
/*  365 */       if ((getMakeDate() == null) || (getMakeDate().equals("null")))
/*  366 */         pstmt.setNull(18, 91);
/*      */       else {
/*  368 */         pstmt.setDate(18, Date.valueOf(getMakeDate()));
/*      */       }
/*  370 */       if ((getMakeTime() == null) || (getMakeTime().equals("null")))
/*  371 */         pstmt.setNull(19, 12);
/*      */       else {
/*  373 */         pstmt.setString(19, getMakeTime());
/*      */       }
/*  375 */       if ((getModifyDate() == null) || (getModifyDate().equals("null")))
/*  376 */         pstmt.setNull(20, 91);
/*      */       else {
/*  378 */         pstmt.setDate(20, Date.valueOf(getModifyDate()));
/*      */       }
/*  380 */       if ((getModifyTime() == null) || (getModifyTime().equals("null")))
/*  381 */         pstmt.setNull(21, 12);
/*      */       else {
/*  383 */         pstmt.setString(21, getModifyTime());
/*      */       }
/*  385 */       if ((getDescription() == null) || (getDescription().equals("null")))
/*  386 */         pstmt.setNull(22, 12);
/*      */       else {
/*  388 */         pstmt.setString(22, getDescription());
/*      */       }
/*      */ 
/*  391 */       pstmt.executeUpdate();
/*  392 */       pstmt.close();
/*      */     }
/*      */     catch (Exception ex) {
/*  395 */       this.mErrors.copyAllErrors(this.db.mErrors);
/*  396 */       CError tError = new CError();
/*  397 */       tError.moduleName = "MSysLinkDB";
/*  398 */       tError.functionName = "insert()";
/*  399 */       tError.errorMessage = ex.toString();
/*  400 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  403 */         pstmt.close();
/*      */       } catch (Exception localException1) {
/*      */       }
/*  406 */       if (!this.mflag)
/*      */         try {
/*  408 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException2) {
/*      */         }
/*  412 */       return false;
/*      */     }
/*      */ 
/*  415 */     if (!this.mflag)
/*      */       try {
/*  417 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException3) {
/*      */       }
/*  421 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean getInfo()
/*      */   {
/*  426 */     PreparedStatement pstmt = null;
/*  427 */     ResultSet rs = null;
/*      */ 
/*  429 */     if (!this.mflag) {
/*  430 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  435 */       pstmt = this.con.prepareStatement("SELECT * FROM MSysLink WHERE  ID = ?", 
/*  436 */         1003, 1007);
/*  437 */       if ((getID() == null) || (getID().equals("null")))
/*  438 */         pstmt.setNull(1, 12);
/*      */       else {
/*  440 */         pstmt.setString(1, getID());
/*      */       }
/*  442 */       rs = pstmt.executeQuery();
/*  443 */       int i = 0;
/*  444 */       if (rs.next())
/*      */       {
/*  446 */         i++;
/*  447 */         if (!setSchema(rs, i))
/*      */         {
/*  450 */           CError tError = new CError();
/*  451 */           tError.moduleName = "MSysLinkDB";
/*  452 */           tError.functionName = "getInfo";
/*  453 */           tError.errorMessage = "\u53D6\u951F\u65A4\u62F7\u5931\u951F\u65A4\u62F7!";
/*  454 */           this.mErrors.addOneError(tError);
/*      */           try {
/*  456 */             rs.close(); } catch (Exception localException1) {
/*      */           }try { pstmt.close(); } catch (Exception localException2) {
/*      */           }
/*  459 */           if (!this.mflag)
/*      */           {
/*      */             try
/*      */             {
/*  463 */               this.con.close();
/*      */             } catch (Exception localException3) {
/*      */             }
/*      */           }
/*  467 */           return false;
/*      */         }
/*      */       }
/*      */       try {
/*  471 */         rs.close(); } catch (Exception localException4) {
/*      */       }try { pstmt.close(); } catch (Exception localException5) {
/*      */       }
/*  474 */       if (i == 0)
/*      */       {
/*  476 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  480 */             this.con.close();
/*      */           } catch (Exception localException6) {
/*      */           }
/*      */         }
/*  484 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  490 */       CError tError = new CError();
/*  491 */       tError.moduleName = "MSysLinkDB";
/*  492 */       tError.functionName = "getInfo";
/*  493 */       tError.errorMessage = e.toString();
/*  494 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  496 */         rs.close(); } catch (Exception localException7) {
/*      */       }try { pstmt.close(); } catch (Exception localException8) {
/*      */       }
/*  499 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  503 */           this.con.close();
/*      */         } catch (Exception localException9) {
/*      */         }
/*      */       }
/*  507 */       return false;
/*      */     }
/*      */ 
/*  510 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  514 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException10) {
/*      */       }
/*      */     }
/*  519 */     return true;
/*      */   }
/*      */ 
/*      */   public MSysLinkSet query()
/*      */   {
/*  524 */     Statement stmt = null;
/*  525 */     ResultSet rs = null;
/*  526 */     MSysLinkSet aMSysLinkSet = new MSysLinkSet();
/*      */ 
/*  528 */     if (!this.mflag) {
/*  529 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  534 */       stmt = this.con.createStatement(1003, 1007);
/*  535 */       SQLString sqlObj = new SQLString("MSysLink");
/*  536 */       MSysLinkSchema aSchema = getSchema();
/*  537 */       sqlObj.setSQL(5, aSchema);
/*  538 */       String sql = sqlObj.getSQL();
/*      */ 
/*  540 */       rs = stmt.executeQuery(sql);
/*  541 */       int i = 0;
/*  542 */       while (rs.next())
/*      */       {
/*  544 */         i++;
/*  545 */         MSysLinkSchema s1 = new MSysLinkSchema();
/*  546 */         s1.setSchema(rs, i);
/*  547 */         aMSysLinkSet.add(s1);
/*      */       }try {
/*  549 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  555 */       CError tError = new CError();
/*  556 */       tError.moduleName = "MSysLinkDB";
/*  557 */       tError.functionName = "query";
/*  558 */       tError.errorMessage = e.toString();
/*  559 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  561 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  564 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  568 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  574 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  578 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  583 */     return aMSysLinkSet;
/*      */   }
/*      */ 
/*      */   public MSysLinkSet executeQuery(String sql)
/*      */   {
/*  588 */     Statement stmt = null;
/*  589 */     ResultSet rs = null;
/*  590 */     MSysLinkSet aMSysLinkSet = new MSysLinkSet();
/*      */ 
/*  592 */     if (!this.mflag) {
/*  593 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  598 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  600 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  601 */       int i = 0;
/*  602 */       while (rs.next())
/*      */       {
/*  604 */         i++;
/*  605 */         MSysLinkSchema s1 = new MSysLinkSchema();
/*  606 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  609 */           CError tError = new CError();
/*  610 */           tError.moduleName = "MSysLinkDB";
/*  611 */           tError.functionName = "executeQuery";
/*  612 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  613 */           this.mErrors.addOneError(tError);
/*      */         }
/*  615 */         aMSysLinkSet.add(s1);
/*      */       }try {
/*  617 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  623 */       CError tError = new CError();
/*  624 */       tError.moduleName = "MSysLinkDB";
/*  625 */       tError.functionName = "executeQuery";
/*  626 */       tError.errorMessage = e.toString();
/*  627 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  629 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  632 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  636 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  642 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  646 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  651 */     return aMSysLinkSet;
/*      */   }
/*      */ 
/*      */   public MSysLinkSet query(int nStart, int nCount)
/*      */   {
/*  656 */     Statement stmt = null;
/*  657 */     ResultSet rs = null;
/*  658 */     MSysLinkSet aMSysLinkSet = new MSysLinkSet();
/*      */ 
/*  660 */     if (!this.mflag) {
/*  661 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  666 */       stmt = this.con.createStatement(1003, 1007);
/*  667 */       SQLString sqlObj = new SQLString("MSysLink");
/*  668 */       MSysLinkSchema aSchema = getSchema();
/*  669 */       sqlObj.setSQL(5, aSchema);
/*  670 */       String sql = sqlObj.getSQL();
/*      */ 
/*  672 */       rs = stmt.executeQuery(sql);
/*  673 */       int i = 0;
/*  674 */       while (rs.next())
/*      */       {
/*  676 */         i++;
/*      */ 
/*  678 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  682 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  686 */         MSysLinkSchema s1 = new MSysLinkSchema();
/*  687 */         s1.setSchema(rs, i);
/*  688 */         aMSysLinkSet.add(s1);
/*      */       }try {
/*  690 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  696 */       CError tError = new CError();
/*  697 */       tError.moduleName = "MSysLinkDB";
/*  698 */       tError.functionName = "query";
/*  699 */       tError.errorMessage = e.toString();
/*  700 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  702 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  705 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  709 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  715 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  719 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  724 */     return aMSysLinkSet;
/*      */   }
/*      */ 
/*      */   public MSysLinkSet executeQuery(String sql, int nStart, int nCount)
/*      */   {
/*  729 */     Statement stmt = null;
/*  730 */     ResultSet rs = null;
/*  731 */     MSysLinkSet aMSysLinkSet = new MSysLinkSet();
/*      */ 
/*  733 */     if (!this.mflag) {
/*  734 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  739 */       stmt = this.con.createStatement(1003, 1007);
/*      */ 
/*  741 */       rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
/*  742 */       int i = 0;
/*  743 */       while (rs.next())
/*      */       {
/*  745 */         i++;
/*      */ 
/*  747 */         if (i < nStart)
/*      */         {
/*      */           continue;
/*      */         }
/*  751 */         if (i >= nStart + nCount)
/*      */         {
/*      */           break;
/*      */         }
/*  755 */         MSysLinkSchema s1 = new MSysLinkSchema();
/*  756 */         if (!s1.setSchema(rs, i))
/*      */         {
/*  759 */           CError tError = new CError();
/*  760 */           tError.moduleName = "MSysLinkDB";
/*  761 */           tError.functionName = "executeQuery";
/*  762 */           tError.errorMessage = "sql\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u4ECB\u770B\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8857\u8BB9\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u606F!";
/*  763 */           this.mErrors.addOneError(tError);
/*      */         }
/*  765 */         aMSysLinkSet.add(s1);
/*      */       }try {
/*  767 */         rs.close(); } catch (Exception localException1) {
/*      */       }try { stmt.close();
/*      */       } catch (Exception localException2) {
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  773 */       CError tError = new CError();
/*  774 */       tError.moduleName = "MSysLinkDB";
/*  775 */       tError.functionName = "executeQuery";
/*  776 */       tError.errorMessage = e.toString();
/*  777 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  779 */         rs.close(); } catch (Exception localException3) {
/*      */       }try { stmt.close(); } catch (Exception localException4) {
/*      */       }
/*  782 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  786 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException5) {
/*      */         }
/*      */       }
/*      */     }
/*  792 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  796 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException6) {
/*      */       }
/*      */     }
/*  801 */     return aMSysLinkSet;
/*      */   }
/*      */ 
/*      */   public boolean update(String strWherePart)
/*      */   {
/*  806 */     Statement stmt = null;
/*      */ 
/*  808 */     if (!this.mflag) {
/*  809 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  814 */       stmt = this.con.createStatement(1003, 1007);
/*  815 */       SQLString sqlObj = new SQLString("MSysLink");
/*  816 */       MSysLinkSchema aSchema = getSchema();
/*  817 */       sqlObj.setSQL(2, aSchema);
/*  818 */       String sql = "update MSysLink " + sqlObj.getUpdPart() + " where " + strWherePart;
/*      */ 
/*  820 */       int operCount = stmt.executeUpdate(sql);
/*  821 */       if (operCount == 0)
/*      */       {
/*  824 */         CError tError = new CError();
/*  825 */         tError.moduleName = "MSysLinkDB";
/*  826 */         tError.functionName = "update";
/*  827 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u7EDE\u044D\u62F7\u951F\uFFFD!";
/*  828 */         this.mErrors.addOneError(tError);
/*      */ 
/*  830 */         if (!this.mflag)
/*      */         {
/*      */           try
/*      */           {
/*  834 */             this.con.close();
/*      */           } catch (Exception localException1) {
/*      */           }
/*      */         }
/*  838 */         return false;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  844 */       CError tError = new CError();
/*  845 */       tError.moduleName = "MSysLinkDB";
/*  846 */       tError.functionName = "update";
/*  847 */       tError.errorMessage = e.toString();
/*  848 */       this.mErrors.addOneError(tError);
/*      */       try {
/*  850 */         stmt.close(); } catch (Exception localException2) {
/*      */       }
/*  852 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  856 */           this.con.close();
/*      */         } catch (Exception localException3) {
/*      */         }
/*      */       }
/*  860 */       return false;
/*      */     }
/*      */ 
/*  863 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  867 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  872 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean prepareData(String strSQL)
/*      */   {
/*  878 */     if (this.mResultSet != null)
/*      */     {
/*  881 */       CError tError = new CError();
/*  882 */       tError.moduleName = "MSysLinkDB";
/*  883 */       tError.functionName = "prepareData";
/*  884 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u5F3A\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u4E4B\u951F\u65A4\u62F7\u6CA1\u951F\u53EB\u5173\u95ED\uFF4F\u62F7";
/*  885 */       this.mErrors.addOneError(tError);
/*  886 */       return false;
/*      */     }
/*      */ 
/*  889 */     if (!this.mflag)
/*      */     {
/*  891 */       this.con = DBConnPool.getConnection();
/*      */     }
/*      */     try
/*      */     {
/*  895 */       this.mStatement = this.con.createStatement(1003, 1007);
/*  896 */       this.mResultSet = this.mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  901 */       CError tError = new CError();
/*  902 */       tError.moduleName = "MSysLinkDB";
/*  903 */       tError.functionName = "prepareData";
/*  904 */       tError.errorMessage = e.toString();
/*  905 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  908 */         this.mResultSet.close();
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  914 */         this.mStatement.close();
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  918 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  922 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  927 */       return false;
/*      */     }
/*      */ 
/*  930 */     if (!this.mflag)
/*      */     {
/*      */       try
/*      */       {
/*  934 */         this.con.close();
/*      */       }
/*      */       catch (Exception localException4) {
/*      */       }
/*      */     }
/*  939 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean hasMoreData()
/*      */   {
/*  945 */     boolean flag = true;
/*  946 */     if (this.mResultSet == null)
/*      */     {
/*  948 */       CError tError = new CError();
/*  949 */       tError.moduleName = "MSysLinkDB";
/*  950 */       tError.functionName = "hasMoreData";
/*  951 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/*  952 */       this.mErrors.addOneError(tError);
/*  953 */       return false;
/*      */     }
/*      */     try
/*      */     {
/*  957 */       flag = this.mResultSet.next();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  961 */       CError tError = new CError();
/*  962 */       tError.moduleName = "MSysLinkDB";
/*  963 */       tError.functionName = "hasMoreData";
/*  964 */       tError.errorMessage = ex.toString();
/*  965 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/*  968 */         this.mResultSet.close();
/*  969 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/*  975 */         this.mStatement.close();
/*  976 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/*  980 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/*  984 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/*  989 */       return false;
/*      */     }
/*  991 */     return flag;
/*      */   }
/*      */ 
/*      */   public MSysLinkSet getData()
/*      */   {
/*  996 */     int tCount = 0;
/*  997 */     MSysLinkSet tMSysLinkSet = new MSysLinkSet();
/*  998 */     MSysLinkSchema tMSysLinkSchema = null;
/*  999 */     if (this.mResultSet == null)
/*      */     {
/* 1001 */       CError tError = new CError();
/* 1002 */       tError.moduleName = "MSysLinkDB";
/* 1003 */       tError.functionName = "getData";
/* 1004 */       tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u8F7F\uE04E\u62F7\u7728\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u9636\u7877\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u951F\u65A4\u62F7";
/* 1005 */       this.mErrors.addOneError(tError);
/* 1006 */       return null;
/*      */     }
/*      */     try
/*      */     {
/* 1010 */       tCount = 1;
/* 1011 */       tMSysLinkSchema = new MSysLinkSchema();
/* 1012 */       tMSysLinkSchema.setSchema(this.mResultSet, 1);
/* 1013 */       tMSysLinkSet.add(tMSysLinkSchema);
/*      */ 
/* 1015 */       while (tCount++ < 5000)
/*      */       {
/* 1017 */         if (!this.mResultSet.next())
/*      */           continue;
/* 1019 */         tMSysLinkSchema = new MSysLinkSchema();
/* 1020 */         tMSysLinkSchema.setSchema(this.mResultSet, 1);
/* 1021 */         tMSysLinkSet.add(tMSysLinkSchema);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1027 */       CError tError = new CError();
/* 1028 */       tError.moduleName = "MSysLinkDB";
/* 1029 */       tError.functionName = "getData";
/* 1030 */       tError.errorMessage = ex.toString();
/* 1031 */       this.mErrors.addOneError(tError);
/*      */       try
/*      */       {
/* 1034 */         this.mResultSet.close();
/* 1035 */         this.mResultSet = null;
/*      */       }
/*      */       catch (Exception localException1)
/*      */       {
/*      */       }
/*      */       try {
/* 1041 */         this.mStatement.close();
/* 1042 */         this.mStatement = null;
/*      */       }
/*      */       catch (Exception localException2) {
/*      */       }
/* 1046 */       if (!this.mflag)
/*      */       {
/*      */         try
/*      */         {
/* 1050 */           this.con.close();
/*      */         }
/*      */         catch (Exception localException3) {
/*      */         }
/*      */       }
/* 1055 */       return null;
/*      */     }
/* 1057 */     return tMSysLinkSet;
/*      */   }
/*      */ 
/*      */   public boolean closeData()
/*      */   {
/* 1062 */     boolean flag = true;
/*      */     try
/*      */     {
/* 1065 */       if (this.mResultSet == null)
/*      */       {
/* 1067 */         CError tError = new CError();
/* 1068 */         tError.moduleName = "MSysLinkDB";
/* 1069 */         tError.functionName = "closeData";
/* 1070 */         tError.errorMessage = "\u951F\u65A4\u62F7\u83C1\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 1071 */         this.mErrors.addOneError(tError);
/* 1072 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1076 */         this.mResultSet.close();
/* 1077 */         this.mResultSet = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex2)
/*      */     {
/* 1082 */       CError tError = new CError();
/* 1083 */       tError.moduleName = "MSysLinkDB";
/* 1084 */       tError.functionName = "closeData";
/* 1085 */       tError.errorMessage = ex2.toString();
/* 1086 */       this.mErrors.addOneError(tError);
/* 1087 */       flag = false;
/*      */     }
/*      */     try
/*      */     {
/* 1091 */       if (this.mStatement == null)
/*      */       {
/* 1093 */         CError tError = new CError();
/* 1094 */         tError.moduleName = "MSysLinkDB";
/* 1095 */         tError.functionName = "closeData";
/* 1096 */         tError.errorMessage = "\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u4E2B\u951F\u65A4\u62F7\u4E47\u951F\u65A4\u62F7\u800D\u951F\uFFFD";
/* 1097 */         this.mErrors.addOneError(tError);
/* 1098 */         flag = false;
/*      */       }
/*      */       else
/*      */       {
/* 1102 */         this.mStatement.close();
/* 1103 */         this.mStatement = null;
/*      */       }
/*      */     }
/*      */     catch (Exception ex3)
/*      */     {
/* 1108 */       CError tError = new CError();
/* 1109 */       tError.moduleName = "MSysLinkDB";
/* 1110 */       tError.functionName = "closeData";
/* 1111 */       tError.errorMessage = ex3.toString();
/* 1112 */       this.mErrors.addOneError(tError);
/* 1113 */       flag = false;
/*      */     }
/* 1115 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.db.MSysLinkDB
 * JD-Core Version:    0.6.0
 */