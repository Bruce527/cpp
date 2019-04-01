/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ 
/*     */ public class DBOper
/*     */ {
/*     */   private Connection con;
/*     */   private String tableName;
/*  18 */   private boolean cflag = false;
/*     */ 
/*  20 */   public CErrors mErrors = new CErrors();
/*     */ 
/*     */   public DBOper(Connection tConnection, String t)
/*     */   {
/*  25 */     this.con = tConnection;
/*  26 */     this.tableName = t;
/*     */   }
/*     */ 
/*     */   public DBOper(String t)
/*     */   {
/*  32 */     this.tableName = t;
/*  33 */     this.con = null;
/*  34 */     this.cflag = true;
/*     */   }
/*     */ 
/*     */   public Connection getConnection()
/*     */   {
/*  41 */     return DBConnPool.getConnection();
/*     */   }
/*     */ 
/*     */   public boolean insert(Schema s)
/*     */   {
/*  47 */     Statement stmt = null;
/*     */ 
/*  51 */     if (this.cflag)
/*     */     {
/*  53 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*  56 */     if (this.con == null)
/*     */     {
/*  58 */       CError tError = new CError();
/*  59 */       tError.moduleName = "DBOper";
/*  60 */       tError.functionName = "insert";
/*  61 */       tError.errorMessage = "Connection\u5EFA\u7ACB\u5931\u8D25!";
/*  62 */       this.mErrors.addOneError(tError);
/*  63 */       return false;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  68 */       stmt = this.con.createStatement();
/*  69 */       SQLString sqlObj = new SQLString(this.tableName);
/*     */ 
/*  71 */       sqlObj.setSQL(1, s);
/*  72 */       String sql = sqlObj.getSQL();
/*     */ 
/*  74 */       int operCount = stmt.executeUpdate(sql);
/*     */       boolean flag;
/*     */       boolean flag;
/*  75 */       if (operCount > 0)
/*     */       {
/*  77 */         flag = true;
/*     */       }
/*     */       else
/*     */       {
/*  82 */         CError tError = new CError();
/*  83 */         tError.moduleName = "DBOper";
/*  84 */         tError.functionName = "insert";
/*  85 */         tError.errorMessage = "\u5B9E\u9645\u64CD\u4F5C\u7684\u6570\u636E\u8BB0\u5F55\u6570\u4E3A\uFF10\u6761\u6570\u636E";
/*  86 */         this.mErrors.addOneError(tError);
/*     */ 
/*  88 */         flag = false;
/*     */       }
/*  90 */       stmt.close();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  95 */       CError tError = new CError();
/*  96 */       tError.moduleName = "DBOper";
/*  97 */       tError.functionName = "insert";
/*  98 */       tError.errorMessage = e.getMessage();
/*  99 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 103 */         stmt.close();
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/* 108 */       if (this.cflag)
/*     */       {
/*     */         try
/*     */         {
/* 112 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/*     */       }
/* 117 */       return false;
/*     */     }
/*     */     boolean flag;
/* 120 */     if (this.cflag)
/*     */     {
/*     */       try
/*     */       {
/* 124 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3)
/*     */       {
/*     */       }
/*     */     }
/* 130 */     return flag;
/*     */   }
/*     */ 
/*     */   public boolean insert(SchemaSet s)
/*     */   {
/* 136 */     Statement stmt = null;
/*     */ 
/* 139 */     if (this.cflag)
/*     */     {
/* 141 */       this.con = DBConnPool.getConnection();
/*     */     }
/* 143 */     if (this.con == null)
/*     */     {
/* 145 */       CError tError = new CError();
/* 146 */       tError.moduleName = "DBOper";
/* 147 */       tError.functionName = "insert";
/* 148 */       tError.errorMessage = "Connection\u5EFA\u7ACB\u5931\u8D25!";
/* 149 */       this.mErrors.addOneError(tError);
/* 150 */       return false;
/*     */     }
/*     */     try
/*     */     {
/* 154 */       int n = s.size();
/* 155 */       Schema aSchema = null;
/* 156 */       String sql = null;
/* 157 */       SQLString sqlObj = null;
/* 158 */       stmt = this.con.createStatement();
/* 159 */       for (int i = 1; i <= n; i++)
/*     */       {
/* 161 */         aSchema = (Schema)s.getObj(i);
/* 162 */         sqlObj = new SQLString(this.tableName);
/*     */ 
/* 164 */         sqlObj.setSQL(1, aSchema);
/* 165 */         sql = sqlObj.getSQL();
/*     */ 
/* 167 */         stmt.addBatch(sql);
/*     */       }
/*     */       boolean flag;
/*     */       try
/*     */       {
/* 173 */         int[] operCount = stmt.executeBatch();
/*     */ 
/* 183 */         flag = true;
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/*     */         boolean flag;
/* 187 */         flag = false;
/*     */       }
/* 189 */       stmt.close();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 194 */       CError tError = new CError();
/* 195 */       tError.moduleName = "DBOper";
/* 196 */       tError.functionName = "insert";
/* 197 */       tError.errorMessage = e.getMessage();
/* 198 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 202 */         stmt.close();
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/* 207 */       if (this.cflag)
/*     */       {
/*     */         try
/*     */         {
/* 211 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/*     */       }
/* 216 */       return false;
/*     */     }
/*     */     boolean flag;
/* 219 */     if (this.cflag)
/*     */     {
/*     */       try
/*     */       {
/* 223 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3)
/*     */       {
/*     */       }
/*     */     }
/* 229 */     return flag;
/*     */   }
/*     */ 
/*     */   public boolean update(Schema s)
/*     */   {
/* 235 */     Statement stmt = null;
/*     */ 
/* 239 */     if (this.cflag)
/*     */     {
/* 241 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/* 244 */     if (this.con == null)
/*     */     {
/* 246 */       CError tError = new CError();
/* 247 */       tError.moduleName = "DBOper";
/* 248 */       tError.functionName = "update";
/* 249 */       tError.errorMessage = "Connection\u5EFA\u7ACB\u5931\u8D25!";
/* 250 */       this.mErrors.addOneError(tError);
/* 251 */       return false;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 256 */       stmt = this.con.createStatement();
/* 257 */       SQLString sqlObj = new SQLString(this.tableName);
/*     */ 
/* 259 */       sqlObj.setSQL(2, s);
/* 260 */       String sql = sqlObj.getSQL();
/*     */ 
/* 262 */       int operCount = stmt.executeUpdate(sql);
/*     */       boolean flag;
/*     */       boolean flag;
/* 263 */       if (operCount > 0)
/*     */       {
/* 265 */         flag = true;
/*     */       }
/*     */       else
/*     */       {
/* 270 */         CError tError = new CError();
/* 271 */         tError.moduleName = "DBOper";
/* 272 */         tError.functionName = "update";
/* 273 */         tError.errorMessage = "\u5B9E\u9645\u64CD\u4F5C\u7684\u6570\u636E\u8BB0\u5F55\u6570\u4E3A\uFF10\u6761\u6570\u636E";
/* 274 */         this.mErrors.addOneError(tError);
/*     */ 
/* 276 */         flag = false;
/*     */       }
/* 278 */       stmt.close();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 283 */       CError tError = new CError();
/* 284 */       tError.moduleName = "DBOper";
/* 285 */       tError.functionName = "update";
/* 286 */       tError.errorMessage = e.getMessage();
/* 287 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 291 */         stmt.close();
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/* 296 */       if (this.cflag)
/*     */       {
/*     */         try
/*     */         {
/* 300 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/*     */       }
/* 305 */       return false;
/*     */     }
/*     */     boolean flag;
/* 308 */     if (this.cflag)
/*     */     {
/*     */       try
/*     */       {
/* 312 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/*     */     }
/* 317 */     return flag;
/*     */   }
/*     */ 
/*     */   public boolean update(SchemaSet s)
/*     */   {
/* 323 */     Statement stmt = null;
/*     */ 
/* 327 */     if (this.cflag)
/*     */     {
/* 329 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/* 332 */     if (this.con == null)
/*     */     {
/* 334 */       CError tError = new CError();
/* 335 */       tError.moduleName = "DBOper";
/* 336 */       tError.functionName = "update";
/* 337 */       tError.errorMessage = "Connection\u5EFA\u7ACB\u5931\u8D25!";
/* 338 */       this.mErrors.addOneError(tError);
/* 339 */       return false;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 344 */       int n = s.size();
/* 345 */       Schema aSchema = null;
/* 346 */       String sql = null;
/* 347 */       SQLString sqlObj = null;
/* 348 */       stmt = this.con.createStatement();
/* 349 */       for (int i = 1; i <= n; i++)
/*     */       {
/* 351 */         aSchema = (Schema)s.getObj(i);
/* 352 */         sqlObj = new SQLString(this.tableName);
/*     */ 
/* 354 */         sqlObj.setSQL(2, aSchema);
/* 355 */         sql = sqlObj.getSQL();
/* 356 */         stmt.addBatch(sql);
/*     */       }
/*     */       boolean flag;
/*     */       try {
/* 361 */         int[] operCount = stmt.executeBatch();
/* 362 */         flag = true;
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/*     */         boolean flag;
/* 366 */         flag = false;
/*     */       }
/* 368 */       stmt.close();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 373 */       CError tError = new CError();
/* 374 */       tError.moduleName = "DBOper";
/* 375 */       tError.functionName = "update";
/* 376 */       tError.errorMessage = e.getMessage();
/* 377 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 381 */         stmt.close();
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/* 386 */       if (this.cflag)
/*     */       {
/*     */         try
/*     */         {
/* 390 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/*     */       }
/* 395 */       return false;
/*     */     }
/*     */     boolean flag;
/* 398 */     if (this.cflag)
/*     */     {
/*     */       try
/*     */       {
/* 402 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException3) {
/*     */       }
/*     */     }
/* 407 */     return flag;
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL(Schema s)
/*     */   {
/* 413 */     Statement stmt = null;
/*     */ 
/* 417 */     if (this.cflag)
/*     */     {
/* 419 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/* 422 */     if (this.con == null)
/*     */     {
/* 424 */       CError tError = new CError();
/* 425 */       tError.moduleName = "DBOper";
/* 426 */       tError.functionName = "deleteSQL";
/* 427 */       tError.errorMessage = "Connection\u5EFA\u7ACB\u5931\u8D25!";
/* 428 */       this.mErrors.addOneError(tError);
/* 429 */       return false;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 434 */       stmt = this.con.createStatement();
/* 435 */       SQLString sqlObj = new SQLString(this.tableName);
/*     */ 
/* 437 */       sqlObj.setSQL(3, s);
/*     */ 
/* 439 */       if (sqlObj.getWherePart().compareTo("") == 0)
/*     */       {
/* 442 */         CError tError = new CError();
/* 443 */         tError.moduleName = "DBOper";
/* 444 */         tError.functionName = "delete";
/* 445 */         tError.errorMessage = "\u5220\u9664\u6761\u4EF6\u4E3A\u7A7A";
/* 446 */         this.mErrors.addOneError(tError);
/*     */         try
/*     */         {
/* 450 */           stmt.close();
/*     */         }
/*     */         catch (Exception localException1)
/*     */         {
/*     */         }
/* 455 */         if (this.cflag)
/*     */         {
/*     */           try
/*     */           {
/* 459 */             this.con.close();
/*     */           }
/*     */           catch (Exception localException2) {
/*     */           }
/*     */         }
/* 464 */         return false;
/*     */       }
/* 466 */       String sql = sqlObj.getSQL();
/*     */ 
/* 468 */       int operCount = stmt.executeUpdate(sql);
/* 469 */       boolean flag = true;
/* 470 */       stmt.close();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 475 */       CError tError = new CError();
/* 476 */       tError.moduleName = "DBOper";
/* 477 */       tError.functionName = "deleteSQL";
/* 478 */       tError.errorMessage = e.getMessage();
/* 479 */       this.mErrors.addOneError(tError);
/*     */       try
/*     */       {
/* 483 */         stmt.close();
/*     */       }
/*     */       catch (Exception localException3)
/*     */       {
/*     */       }
/* 488 */       if (this.cflag)
/*     */       {
/*     */         try
/*     */         {
/* 492 */           this.con.close();
/*     */         }
/*     */         catch (Exception localException4) {
/*     */         }
/*     */       }
/* 497 */       return false;
/*     */     }
/*     */     boolean flag;
/* 500 */     if (this.cflag)
/*     */     {
/*     */       try
/*     */       {
/* 504 */         this.con.close();
/*     */       }
/*     */       catch (Exception localException5) {
/*     */       }
/*     */     }
/* 509 */     return flag;
/*     */   }
/*     */ 
/*     */   public boolean deleteSQL(SchemaSet s)
/*     */   {
/* 515 */     Statement stmt = null;
/*     */ 
/* 519 */     if (this.cflag)
/*     */     {
/* 521 */       this.con = DBConnPool.getConnection();
/*     */     }
/*     */ 
/* 524 */     if (this.con == null)
/*     */     {
/* 526 */       CError tError = new CError();
/* 527 */       tError.moduleName = "DBOper";
/* 528 */       tError.functionName = "deleteSQL";
/* 529 */       tError.errorMessage = "Connection\u5EFA\u7ACB\u5931\u8D25!";
/* 530 */       this.mErrors.addOneError(tError);
/* 531 */       return false;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 536 */       int n = s.size();
/* 537 */       Schema aSchema = null;
/* 538 */       String sql = null;
/* 539 */       SQLString sqlObj = null;
/* 540 */       stmt = this.con.createStatement();
/* 541 */       for (int i = 1; i <= n; i++)
/*     */       {
/* 543 */         aSchema = (Schema)s.getObj(i);
/* 544 */         sqlObj = new SQLString(this.tableName);
/*     */ 
/* 546 */         sqlObj.setSQL(3, aSchema);
/*     */ 
/* 548 */         if (sqlObj.getWherePart().compareTo("") == 0)
/*     */         {
/* 551 */           CError tError = new CError();
/* 552 */           tError.moduleName = "DBOper";
/* 553 */           tError.functionName = "delete";
/* 554 */           tError.errorMessage = "\u5220\u9664\u6761\u4EF6\u4E3A\u7A7A";
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
/* 647 */       tError.errorMessage = "Connection\u5EFA\u7ACB\u5931\u8D25!";
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
/* 721 */       tError.errorMessage = "Connection\u5EFA\u7ACB\u5931\u8D25!";
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
/* 811 */       tError.errorMessage = "Connection\u5EFA\u7ACB\u5931\u8D25!";
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
 * Qualified Name:     com.sinosoft.map.utility.DBOper
 * JD-Core Version:    0.6.0
 */