/*     */ package com.sinosoft.banklns.utility;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ 
/*     */ public class DBOper
/*     */ {
/*     */   private Connection con;
/*     */   private String tableName;
/*  16 */   private boolean cflag = false;
/*     */ 
/*  18 */   public CErrors mErrors = new CErrors();
/*     */ 
/*     */   public DBOper(Connection tConnection, String t)
/*     */   {
/*  23 */     this.con = tConnection;
/*  24 */     this.tableName = t;
/*     */   }
/*     */ 
/*     */   public DBOper(String t)
/*     */   {
/*  30 */     this.tableName = t;
/*  31 */     this.con = null;
/*  32 */     this.cflag = true;
/*     */   }
/*     */ 
/*     */   public Connection getConnection()
/*     */   {
/*  39 */     return DBConnPool.getConnection();
/*     */   }
/*     */ 
/*     */   public boolean insert(Schema s)
/*     */   {
/*  45 */     Statement stmt = null;
/*     */ 
/*  49 */     if (this.cflag)
/*     */     {
/*  51 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*  54 */     if (this.con == null)
/*     */     {
/*  56 */       CError tError = new CError();
/*  57 */       tError.moduleName = "DBOper";
/*  58 */       tError.functionName = "insert";
/*  59 */       tError.errorMessage = "Connection\u951F\u65A4\u62F7b\u5931\u951F\u65A4\u62F7!";
/*  60 */       this.mErrors.addOneError(tError);
/*  61 */       return false;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  66 */       stmt = this.con.createStatement();
/*  67 */       SQLString sqlObj = new SQLString(this.tableName);
/*     */ 
/*  69 */       sqlObj.setSQL(1, s);
/*  70 */       String sql = sqlObj.getSQL();
/*     */ 
/*  72 */       int operCount = stmt.executeUpdate(sql);
/*     */       boolean flag;
/*     */       boolean flag;
/*  73 */       if (operCount > 0)
/*     */       {
/*  75 */         flag = true;
/*     */       }
/*     */       else
/*     */       {
/*  80 */         CError tError = new CError();
/*  81 */         tError.moduleName = "DBOper";
/*  82 */         tError.functionName = "insert";
/*  83 */         tError.errorMessage = "\u5B9E\u951F\u7EDE\u8BE7\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u5F55\u951F\u65A4\u62F7\u4E3A\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\uFFFD";
/*  84 */         this.mErrors.addOneError(tError);
/*     */ 
/*  86 */         flag = false;
/*     */       }
/*  88 */       stmt.close();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  93 */       CError tError = new CError();
/*  94 */       tError.moduleName = "DBOper";
/*  95 */       tError.functionName = "insert";
/*  96 */       tError.errorMessage = e.getMessage();
/*  97 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 101 */         stmt.close();
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/* 106 */       if (this.cflag)
/*     */       {
/*     */         try
/*     */         {
/* 110 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/*     */       }
/* 115 */       return false;
/*     */     }
/*     */     boolean flag;
/* 118 */     if (this.cflag)
/*     */     {
/*     */       try
/*     */       {
/* 122 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3)
/*     */       {
/*     */       }
/*     */     }
/* 128 */     return flag;
/*     */   }
/*     */ 
/*     */   public boolean insert(SchemaSet s)
/*     */   {
/* 134 */     Statement stmt = null;
/*     */ 
/* 137 */     if (this.cflag)
/*     */     {
/* 139 */       this.con = DBConnPool.getConnection();
/*     */     }
/* 141 */     if (this.con == null)
/*     */     {
/* 143 */       CError tError = new CError();
/* 144 */       tError.moduleName = "DBOper";
/* 145 */       tError.functionName = "insert";
/* 146 */       tError.errorMessage = "Connection\u951F\u65A4\u62F7b\u5931\u951F\u65A4\u62F7!";
/* 147 */       this.mErrors.addOneError(tError);
/* 148 */       return false;
/*     */     }
/*     */     try
/*     */     {
/* 152 */       int n = s.size();
/* 153 */       Schema aSchema = null;
/* 154 */       String sql = null;
/* 155 */       SQLString sqlObj = null;
/* 156 */       stmt = this.con.createStatement();
/* 157 */       for (int i = 1; i <= n; i++)
/*     */       {
/* 159 */         aSchema = (Schema)s.getObj(i);
/* 160 */         sqlObj = new SQLString(this.tableName);
/*     */ 
/* 162 */         sqlObj.setSQL(1, aSchema);
/* 163 */         sql = sqlObj.getSQL();
/*     */ 
/* 165 */         stmt.addBatch(sql);
/*     */       }
/*     */       boolean flag;
/*     */       try
/*     */       {
/* 171 */         int[] operCount = stmt.executeBatch();
/*     */ 
/* 181 */         flag = true;
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/*     */         boolean flag;
/* 185 */         flag = false;
/*     */       }
/* 187 */       stmt.close();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 192 */       CError tError = new CError();
/* 193 */       tError.moduleName = "DBOper";
/* 194 */       tError.functionName = "insert";
/* 195 */       tError.errorMessage = e.getMessage();
/* 196 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 200 */         stmt.close();
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/* 205 */       if (this.cflag)
/*     */       {
/*     */         try
/*     */         {
/* 209 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/*     */       }
/* 214 */       return false;
/*     */     }
/*     */     boolean flag;
/* 217 */     if (this.cflag)
/*     */     {
/*     */       try
/*     */       {
/* 221 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3)
/*     */       {
/*     */       }
/*     */     }
/* 227 */     return flag;
/*     */   }
/*     */ 
/*     */   public boolean update(Schema s)
/*     */   {
/* 233 */     Statement stmt = null;
/*     */ 
/* 237 */     if (this.cflag)
/*     */     {
/* 239 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/* 242 */     if (this.con == null)
/*     */     {
/* 244 */       CError tError = new CError();
/* 245 */       tError.moduleName = "DBOper";
/* 246 */       tError.functionName = "update";
/* 247 */       tError.errorMessage = "Connection\u951F\u65A4\u62F7b\u5931\u951F\u65A4\u62F7!";
/* 248 */       this.mErrors.addOneError(tError);
/* 249 */       return false;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 254 */       stmt = this.con.createStatement();
/* 255 */       SQLString sqlObj = new SQLString(this.tableName);
/*     */ 
/* 257 */       sqlObj.setSQL(2, s);
/* 258 */       String sql = sqlObj.getSQL();
/*     */ 
/* 260 */       int operCount = stmt.executeUpdate(sql);
/*     */       boolean flag;
/*     */       boolean flag;
/* 261 */       if (operCount > 0)
/*     */       {
/* 263 */         flag = true;
/*     */       }
/*     */       else
/*     */       {
/* 268 */         CError tError = new CError();
/* 269 */         tError.moduleName = "DBOper";
/* 270 */         tError.functionName = "update";
/* 271 */         tError.errorMessage = "\u5B9E\u951F\u7EDE\u8BE7\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u6377\u7877\u62F7\u5F55\u951F\u65A4\u62F7\u4E3A\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\uFFFD";
/* 272 */         this.mErrors.addOneError(tError);
/*     */ 
/* 274 */         flag = false;
/*     */       }
/* 276 */       stmt.close();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 281 */       CError tError = new CError();
/* 282 */       tError.moduleName = "DBOper";
/* 283 */       tError.functionName = "update";
/* 284 */       tError.errorMessage = e.getMessage();
/* 285 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 289 */         stmt.close();
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/* 294 */       if (this.cflag)
/*     */       {
/*     */         try
/*     */         {
/* 298 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/*     */       }
/* 303 */       return false;
/*     */     }
/*     */     boolean flag;
/* 306 */     if (this.cflag)
/*     */     {
/*     */       try
/*     */       {
/* 310 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/*     */     }
/* 315 */     return flag;
/*     */   }
/*     */ 
/*     */   public boolean update(SchemaSet s)
/*     */   {
/* 321 */     Statement stmt = null;
/*     */ 
/* 325 */     if (this.cflag)
/*     */     {
/* 327 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/* 330 */     if (this.con == null)
/*     */     {
/* 332 */       CError tError = new CError();
/* 333 */       tError.moduleName = "DBOper";
/* 334 */       tError.functionName = "update";
/* 335 */       tError.errorMessage = "Connection\u951F\u65A4\u62F7b\u5931\u951F\u65A4\u62F7!";
/* 336 */       this.mErrors.addOneError(tError);
/* 337 */       return false;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 342 */       int n = s.size();
/* 343 */       Schema aSchema = null;
/* 344 */       String sql = null;
/* 345 */       SQLString sqlObj = null;
/* 346 */       stmt = this.con.createStatement();
/* 347 */       for (int i = 1; i <= n; i++)
/*     */       {
/* 349 */         aSchema = (Schema)s.getObj(i);
/* 350 */         sqlObj = new SQLString(this.tableName);
/*     */ 
/* 352 */         sqlObj.setSQL(2, aSchema);
/* 353 */         sql = sqlObj.getSQL();
/* 354 */         stmt.addBatch(sql);
/*     */       }
/*     */       boolean flag;
/*     */       try {
/* 359 */         int[] operCount = stmt.executeBatch();
/* 360 */         flag = true;
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/*     */         boolean flag;
/* 364 */         flag = false;
/*     */       }
/* 366 */       stmt.close();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 371 */       CError tError = new CError();
/* 372 */       tError.moduleName = "DBOper";
/* 373 */       tError.functionName = "update";
/* 374 */       tError.errorMessage = e.getMessage();
/* 375 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 379 */         stmt.close();
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/* 384 */       if (this.cflag)
/*     */       {
/*     */         try
/*     */         {
/* 388 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/*     */       }
/* 393 */       return false;
/*     */     }
/*     */     boolean flag;
/* 396 */     if (this.cflag)
/*     */     {
/*     */       try
/*     */       {
/* 400 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/*     */     }
/* 405 */     return flag;
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL(Schema s)
/*     */   {
/* 411 */     Statement stmt = null;
/*     */ 
/* 415 */     if (this.cflag)
/*     */     {
/* 417 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/* 420 */     if (this.con == null)
/*     */     {
/* 422 */       CError tError = new CError();
/* 423 */       tError.moduleName = "DBOper";
/* 424 */       tError.functionName = "deleteSQL";
/* 425 */       tError.errorMessage = "Connection\u951F\u65A4\u62F7b\u5931\u951F\u65A4\u62F7!";
/* 426 */       this.mErrors.addOneError(tError);
/* 427 */       return false;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 432 */       stmt = this.con.createStatement();
/* 433 */       SQLString sqlObj = new SQLString(this.tableName);
/*     */ 
/* 435 */       sqlObj.setSQL(3, s);
/*     */ 
/* 438 */       if (sqlObj.getWherePart().compareTo("") == 0)
/*     */       {
/* 441 */         CError tError = new CError();
/* 442 */         tError.moduleName = "DBOper";
/* 443 */         tError.functionName = "delete";
/* 444 */         tError.errorMessage = "\u5220\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8F7F\uE04E\u62F7\u951F\uFFFD";
/* 445 */         this.mErrors.addOneError(tError);
/*     */         try
/*     */         {
/* 449 */           stmt.close();
/*     */         }
/*     */         catch (Exception localException1)
/*     */         {
/*     */         }
/* 454 */         if (this.cflag)
/*     */         {
/*     */           try
/*     */           {
/* 458 */             this.con.close();
/*     */           }
/*     */           catch (Exception localException2) {
/*     */           }
/*     */         }
/* 463 */         return false;
/*     */       }
/* 465 */       String sql = sqlObj.getSQL();
/*     */ 
/* 467 */       int operCount = stmt.executeUpdate(sql);
/* 468 */       boolean flag = true;
/* 469 */       stmt.close();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 474 */       CError tError = new CError();
/* 475 */       tError.moduleName = "DBOper";
/* 476 */       tError.functionName = "deleteSQL";
/* 477 */       tError.errorMessage = e.getMessage();
/* 478 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 482 */         stmt.close();
/*     */       }
/*     */       catch (Exception localException3)
/*     */       {
/*     */       }
/* 487 */       if (this.cflag)
/*     */       {
/*     */         try
/*     */         {
/* 491 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException4) {
/*     */         }
/*     */       }
/* 496 */       return false;
/*     */     }
/*     */     boolean flag;
/* 499 */     if (this.cflag)
/*     */     {
/*     */       try
/*     */       {
/* 503 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException5) {
/*     */       }
/*     */     }
/* 508 */     return flag;
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL(SchemaSet s)
/*     */   {
/* 514 */     Statement stmt = null;
/*     */ 
/* 518 */     if (this.cflag)
/*     */     {
/* 520 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/* 523 */     if (this.con == null)
/*     */     {
/* 525 */       CError tError = new CError();
/* 526 */       tError.moduleName = "DBOper";
/* 527 */       tError.functionName = "deleteSQL";
/* 528 */       tError.errorMessage = "Connection\u951F\u65A4\u62F7b\u5931\u951F\u65A4\u62F7!";
/* 529 */       this.mErrors.addOneError(tError);
/* 530 */       return false;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 535 */       int n = s.size();
/* 536 */       Schema aSchema = null;
/* 537 */       String sql = null;
/* 538 */       SQLString sqlObj = null;
/* 539 */       stmt = this.con.createStatement();
/* 540 */       for (int i = 1; i <= n; i++)
/*     */       {
/* 542 */         aSchema = (Schema)s.getObj(i);
/* 543 */         sqlObj = new SQLString(this.tableName);
/*     */ 
/* 545 */         sqlObj.setSQL(3, aSchema);
/*     */ 
/* 548 */         if (sqlObj.getWherePart().compareTo("") == 0)
/*     */         {
/* 551 */           CError tError = new CError();
/* 552 */           tError.moduleName = "DBOper";
/* 553 */           tError.functionName = "delete";
/* 554 */           tError.errorMessage = "\u5220\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u8F7F\uE04E\u62F7\u951F\uFFFD";
/* 555 */           this.mErrors.addOneError(tError);
/*     */           try
/*     */           {
/* 559 */             stmt.close();
/*     */           }
/*     */           catch (Exception localException1)
/*     */           {
/*     */           }
/* 564 */           if (this.cflag)
/*     */           {
/*     */             try
/*     */             {
/* 568 */               this.con.close();
/*     */             }
/*     */             catch (Exception localException2) {
/*     */             }
/*     */           }
/* 573 */           return false;
/*     */         }
/* 575 */         sql = sqlObj.getSQL();
/* 576 */         stmt.addBatch(sql);
/*     */       }
/*     */       boolean flag;
/*     */       try {
/* 581 */         int[] operCount = stmt.executeBatch();
/* 582 */         flag = true;
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/*     */         boolean flag;
/* 586 */         flag = false;
/*     */       }
/* 588 */       stmt.close();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 593 */       CError tError = new CError();
/* 594 */       tError.moduleName = "DBOper";
/* 595 */       tError.functionName = "deleteSQL";
/* 596 */       tError.errorMessage = e.getMessage();
/* 597 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 601 */         stmt.close();
/*     */       }
/*     */       catch (Exception localException3)
/*     */       {
/*     */       }
/* 606 */       if (this.cflag)
/*     */       {
/*     */         try
/*     */         {
/* 610 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException4) {
/*     */         }
/*     */       }
/* 615 */       return false;
/*     */     }
/*     */     boolean flag;
/* 618 */     if (this.cflag)
/*     */     {
/*     */       try
/*     */       {
/* 622 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException5) {
/*     */       }
/*     */     }
/* 627 */     return flag;
/*     */   }
/*     */ 
/*     */   public boolean delete(Schema s)
/*     */   {
/* 633 */     Statement stmt = null;
/*     */ 
/* 637 */     if (this.cflag)
/*     */     {
/* 639 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/* 642 */     if (this.con == null)
/*     */     {
/* 644 */       CError tError = new CError();
/* 645 */       tError.moduleName = "DBOper";
/* 646 */       tError.functionName = "delete";
/* 647 */       tError.errorMessage = "Connection\u951F\u65A4\u62F7b\u5931\u951F\u65A4\u62F7!";
/* 648 */       this.mErrors.addOneError(tError);
/* 649 */       return false;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 654 */       stmt = this.con.createStatement();
/* 655 */       SQLString sqlObj = new SQLString(this.tableName);
/*     */ 
/* 657 */       sqlObj.setSQL(4, s);
/* 658 */       String sql = sqlObj.getSQL();
/*     */ 
/* 660 */       int operCount = stmt.executeUpdate(sql);
/* 661 */       boolean flag = true;
/* 662 */       stmt.close();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 667 */       CError tError = new CError();
/* 668 */       tError.moduleName = "DBOper";
/* 669 */       tError.functionName = "delete";
/* 670 */       tError.errorMessage = e.getMessage();
/* 671 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 675 */         stmt.close();
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/* 680 */       if (this.cflag)
/*     */       {
/*     */         try
/*     */         {
/* 684 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/*     */       }
/* 689 */       return false;
/*     */     }
/*     */     boolean flag;
/* 692 */     if (this.cflag)
/*     */     {
/*     */       try
/*     */       {
/* 696 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/*     */     }
/* 701 */     return flag;
/*     */   }
/*     */ 
/*     */   public boolean delete(SchemaSet s)
/*     */   {
/* 707 */     Statement stmt = null;
/*     */ 
/* 711 */     if (this.cflag)
/*     */     {
/* 713 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/* 716 */     if (this.con == null)
/*     */     {
/* 718 */       CError tError = new CError();
/* 719 */       tError.moduleName = "DBOper";
/* 720 */       tError.functionName = "delete";
/* 721 */       tError.errorMessage = "Connection\u951F\u65A4\u62F7b\u5931\u951F\u65A4\u62F7!";
/* 722 */       this.mErrors.addOneError(tError);
/* 723 */       return false;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 728 */       int n = s.size();
/* 729 */       Schema aSchema = null;
/* 730 */       String sql = null;
/* 731 */       SQLString sqlObj = null;
/* 732 */       stmt = this.con.createStatement();
/* 733 */       for (int i = 1; i <= n; i++)
/*     */       {
/* 735 */         aSchema = (Schema)s.getObj(i);
/* 736 */         sqlObj = new SQLString(this.tableName);
/*     */ 
/* 738 */         sqlObj.setSQL(4, aSchema);
/* 739 */         sql = sqlObj.getSQL();
/* 740 */         stmt.addBatch(sql);
/*     */       }
/*     */       boolean flag;
/*     */       try {
/* 745 */         int[] operCount = stmt.executeBatch();
/* 746 */         flag = true;
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/*     */         boolean flag;
/* 750 */         flag = false;
/*     */       }
/* 752 */       stmt.close();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 757 */       CError tError = new CError();
/* 758 */       tError.moduleName = "DBOper";
/* 759 */       tError.functionName = "delete";
/* 760 */       tError.errorMessage = e.getMessage();
/* 761 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 765 */         stmt.close();
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/* 770 */       if (this.cflag)
/*     */       {
/*     */         try
/*     */         {
/* 774 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/*     */       }
/* 779 */       return false;
/*     */     }
/*     */     boolean flag;
/* 782 */     if (this.cflag)
/*     */     {
/*     */       try
/*     */       {
/* 786 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/*     */     }
/* 791 */     return flag;
/*     */   }
/*     */ 
/*     */   public int getCount(Schema s)
/*     */   {
/* 796 */     Statement stmt = null;
/* 797 */     ResultSet rs = null;
/*     */ 
/* 801 */     if (this.cflag)
/*     */     {
/* 803 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/* 806 */     if (this.con == null)
/*     */     {
/* 808 */       CError tError = new CError();
/* 809 */       tError.moduleName = "DBOper";
/* 810 */       tError.functionName = "getCount";
/* 811 */       tError.errorMessage = "Connection\u951F\u65A4\u62F7b\u5931\u951F\u65A4\u62F7!";
/* 812 */       this.mErrors.addOneError(tError);
/* 813 */       return -1;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 818 */       stmt = this.con.createStatement();
/* 819 */       SQLString sqlObj = new SQLString(this.tableName);
/* 820 */       sqlObj.setSQL(7, s);
/* 821 */       String sql = sqlObj.getSQL();
/*     */ 
/* 823 */       rs = stmt.executeQuery(sql);
/* 824 */       rs.next();
/* 825 */       int RSCount = rs.getInt(1);
/* 826 */       rs.close();
/* 827 */       stmt.close();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 832 */       CError tError = new CError();
/* 833 */       tError.moduleName = "DBOper";
/* 834 */       tError.functionName = "getCount";
/* 835 */       tError.errorMessage = e.getMessage();
/* 836 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 840 */         rs.close();
/* 841 */         stmt.close();
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/* 846 */       if (this.cflag)
/*     */       {
/*     */         try
/*     */         {
/* 850 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/*     */       }
/* 855 */       return -1;
/*     */     }
/*     */     int RSCount;
/* 858 */     if (this.cflag)
/*     */     {
/*     */       try
/*     */       {
/* 862 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/*     */     }
/* 867 */     return RSCount;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.DBOper
 * JD-Core Version:    0.6.0
 */