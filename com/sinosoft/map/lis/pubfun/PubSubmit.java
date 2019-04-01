/*     */ package com.sinosoft.map.lis.pubfun;
/*     */ 
/*     */ import com.sinosoft.map.utility.CBlob;
/*     */ import com.sinosoft.map.utility.CError;
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.ExeSQL;
/*     */ import com.sinosoft.map.utility.SSRS;
/*     */ import com.sinosoft.map.utility.Schema;
/*     */ import com.sinosoft.map.utility.VData;
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.sql.Connection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class PubSubmit
/*     */ {
/*     */   private VData mInputData;
/*  23 */   public CErrors mErrors = new CErrors();
/*     */ 
/*  25 */   private Connection conn = null;
/*     */ 
/*  27 */   private final boolean commitFlag = true;
/*     */ 
/*  29 */   private String checkType = "";
/*     */ 
/*     */   public boolean submitData(VData cInputData, String cOperate)
/*     */   {
/*  38 */     this.mInputData = ((VData)cInputData.clone());
/*     */     try {
/*  40 */       if (!saveData())
/*  41 */         return false;
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*  45 */       CError.buildErr(this, "\u4E1A\u52A1\u6570\u636E\u4FDD\u5B58\u5931\u8D25\uFF01");
/*  46 */       return false;
/*     */     }
/*  48 */     this.mInputData = null;
/*  49 */     return true;
/*     */   }
/*     */ 
/*     */   private boolean saveData()
/*     */     throws Exception
/*     */   {
/*  58 */     if ((this.conn == null) || (this.conn.isClosed()))
/*     */     {
/*  60 */       this.conn = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*  63 */     if (this.conn == null)
/*     */     {
/*  66 */       CError.buildErr(this, "\u6570\u636E\u5E93\u8FDE\u63A5\u5931\u8D25");
/*  67 */       return false;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  73 */       this.conn.setAutoCommit(false);
/*     */ 
/*  75 */       String action = "";
/*  76 */       String className = "";
/*  77 */       Object o = null;
/*  78 */       Object DBObject = null;
/*  79 */       Method m = null;
/*  80 */       Constructor constructor = null;
/*  81 */       Class[] parameterC = new Class[1];
/*  82 */       Object[] parameterO = new Object[1];
/*     */ 
/*  86 */       MMap map = (MMap)this.mInputData.getObjectByObjectName("MMap", 0);
/*  87 */       if ((map != null) && (map.keySet().size() != 0))
/*     */       {
/*  89 */         Set set = map.keySet();
/*     */ 
/*  92 */         for (int j = 0; j < set.size(); j++)
/*     */         {
/*  96 */           o = map.getOrder().get(String.valueOf(j + 1));
/*     */ 
/*  98 */           action = (String)map.get(o);
/*  99 */           if (action == null)
/*     */           {
/*     */             continue;
/*     */           }
/*     */ 
/* 107 */           className = o.getClass().getName();
/*     */ 
/* 111 */           if (className.endsWith("String"))
/*     */           {
/* 113 */             if (action.equals("UPDATE"))
/*     */             {
/* 115 */               className = "com.sinosoft.map.lis.db." + 
/* 116 */                 className
/* 117 */                 .substring(className.lastIndexOf(".") + 
/* 118 */                 1, className.lastIndexOf("S")) + 
/* 119 */                 "DB";
/* 120 */               String tSQL = (String)o;
/* 121 */               ExeSQL tExeSQL = new ExeSQL(this.conn);
/*     */ 
/* 123 */               if (tExeSQL.execUpdateSQL(tSQL))
/*     */                 continue;
/* 125 */               CError.buildErr(this, "\u6267\u884C\u66F4\u65B0\u8BED\u53E5\u5931\u8D25\u539F\u56E0:" + tExeSQL.mErrors.getError(0).errorMessage);
/*     */ 
/* 127 */               this.conn.rollback();
/* 128 */               this.conn.close();
/* 129 */               return false;
/*     */             }
/*     */ 
/* 133 */             if (action.equals("DELETE"))
/*     */             {
/* 135 */               className = "com.sinosoft.map.lis.db." + 
/* 136 */                 className
/* 137 */                 .substring(className.lastIndexOf(".") + 
/* 138 */                 1, className.lastIndexOf("S")) + 
/* 139 */                 "DB";
/* 140 */               String tSQL = (String)o;
/* 141 */               ExeSQL tExeSQL = new ExeSQL(this.conn);
/*     */ 
/* 143 */               if (tExeSQL.execUpdateSQL(tSQL))
/*     */                 continue;
/* 145 */               CError.buildErr(this, "\u6267\u884C\u5220\u9664\u8BED\u53E5\u5931\u8D25\u539F\u56E0:" + tExeSQL.mErrors.getError(0).errorMessage);
/*     */ 
/* 147 */               this.conn.rollback();
/* 148 */               this.conn.close();
/* 149 */               return false;
/*     */             }
/*     */ 
/* 153 */             if (action.equals("INSERT"))
/*     */             {
/* 155 */               className = "com.sinosoft.map.lis.db." + 
/* 156 */                 className
/* 157 */                 .substring(className.lastIndexOf(".") + 
/* 158 */                 1, className.lastIndexOf("S")) + 
/* 159 */                 "DB";
/* 160 */               String tSQL = (String)o;
/* 161 */               ExeSQL tExeSQL = new ExeSQL(this.conn);
/*     */ 
/* 163 */               if (tExeSQL.execUpdateSQL(tSQL))
/*     */                 continue;
/* 165 */               CError.buildErr(this, 
/* 166 */                 "\u6267\u884C\u63D2\u5165\u8BED\u53E5\u5931\u8D25\u539F\u56E0\uFF1A" + 
/* 167 */                 tExeSQL.mErrors.getError(0).errorMessage);
/*     */ 
/* 169 */               this.conn.rollback();
/* 170 */               this.conn.close();
/* 171 */               return false;
/*     */             }
/*     */ 
/* 175 */             if (action.equals("SELECT"))
/*     */             {
/* 177 */               className = "com.sinosoft.map.lis.db." + 
/* 178 */                 className
/* 179 */                 .substring(className.lastIndexOf(".") + 
/* 180 */                 1, className.lastIndexOf("S")) + 
/* 181 */                 "DB";
/* 182 */               String tSQL = (String)o;
/* 183 */               ExeSQL tExeSQL = new ExeSQL(this.conn);
/* 184 */               SSRS tSSRS = new SSRS();
/* 185 */               System.out.println("\u6267\u884CSQL\u8BED\u53E5:" + tSQL);
/* 186 */               tSSRS = tExeSQL.execSQL(tSQL);
/*     */ 
/* 188 */               if (tSSRS.getMaxRow() <= 0)
/*     */                 continue;
/* 190 */               CError.buildErr(this, "\u8BE5\u64CD\u4F5C\u5DF2\u7ECF\u6267\u884C\uFF0C\u8BF7\u68C0\u67E5\u6570\u636E\uFF01");
/* 191 */               this.conn.rollback();
/* 192 */               this.conn.close();
/* 193 */               return false;
/*     */             }
/*     */ 
/*     */           }
/* 198 */           else if (className.endsWith("Schema"))
/*     */           {
/* 200 */             className = "com.sinosoft.map.lis.db." + 
/* 201 */               className
/* 202 */               .substring(className.lastIndexOf(".") + 1, 
/* 203 */               className.lastIndexOf("S")) + 
/* 204 */               "DB";
/*     */           }
/* 206 */           else if (className.endsWith("BLSet"))
/*     */           {
/* 208 */             className = "com.sinosoft.map.lis.vdb." + 
/* 209 */               className
/* 210 */               .substring(className.lastIndexOf(".") + 1, 
/* 211 */               className.lastIndexOf("B")) + 
/* 212 */               "DBSet";
/*     */           }
/* 214 */           else if (className.endsWith("Set"))
/*     */           {
/* 216 */             className = "com.sinosoft.map.lis.vdb." + 
/* 217 */               className
/* 218 */               .substring(className.lastIndexOf(".") + 1, 
/* 219 */               className.lastIndexOf("S")) + 
/* 220 */               "DBSet";
/*     */           }
/* 222 */           Class DBClass = Class.forName(className);
/*     */ 
/* 225 */           parameterC[0] = Connection.class;
/* 226 */           constructor = DBClass.getConstructor(parameterC);
/* 227 */           parameterO[0] = this.conn;
/* 228 */           DBObject = constructor.newInstance(parameterO);
/*     */ 
/* 231 */           parameterC[0] = o.getClass();
/* 232 */           if (o.getClass().getName().endsWith("Schema"))
/*     */           {
/* 234 */             m = DBObject.getClass().getMethod("setSchema", 
/* 235 */               parameterC);
/*     */           }
/* 237 */           else if (o.getClass().getName().endsWith("Set"))
/*     */           {
/* 239 */             m = DBObject.getClass().getMethod("set", parameterC);
/*     */           }
/* 241 */           parameterO[0] = o;
/* 242 */           m.invoke(DBObject, parameterO);
/*     */ 
/* 245 */           if (action.equals("INSERT"))
/*     */           {
/* 248 */             m = DBObject.getClass().getMethod("insert", null);
/* 249 */             Boolean b = (Boolean)m.invoke(DBObject, null);
/*     */ 
/* 251 */             if (b.booleanValue())
/*     */             {
/*     */               continue;
/*     */             }
/* 255 */             CError.buildErr(this, "\u6267\u884C\u63D2\u5165\u8BED\u53E5\u5931\u8D25" + getDBErrorsMessage(DBObject));
/*     */             try
/*     */             {
/* 258 */               this.conn.rollback();
/*     */             }
/*     */             catch (Exception localException1) {
/*     */             }
/* 262 */             this.conn.close();
/* 263 */             System.out.println(DBObject.getClass().getName() + 
/* 264 */               " " + action + " Failed");
/* 265 */             return false;
/*     */           }
/*     */ 
/* 268 */           if (action.equals("UPDATE"))
/*     */           {
/* 270 */             m = DBObject.getClass().getMethod("update", null);
/* 271 */             Boolean b = (Boolean)m.invoke(DBObject, null);
/*     */ 
/* 273 */             if (b.booleanValue())
/*     */               continue;
/* 275 */             CError.buildErr(this, "\u6267\u884C\u66F4\u65B0\u8BED\u53E5\u5931\u8D25" + getDBErrorsMessage(DBObject));
/*     */             try
/*     */             {
/* 278 */               this.conn.rollback();
/*     */             }
/*     */             catch (Exception localException2) {
/*     */             }
/* 282 */             this.conn.close();
/* 283 */             System.out.println(DBObject.getClass().getName() + 
/* 284 */               " " + action + " Failed");
/* 285 */             return false;
/*     */           }
/*     */ 
/* 288 */           if (action.equals("DELETE"))
/*     */           {
/* 290 */             m = DBObject.getClass().getMethod("delete", null);
/* 291 */             Boolean b = (Boolean)m.invoke(DBObject, null);
/*     */ 
/* 293 */             if (b.booleanValue())
/*     */               continue;
/* 295 */             CError.buildErr(this, "\u6267\u884C\u5220\u9664\u8BED\u53E5\u5931\u8D25" + getDBErrorsMessage(DBObject));
/*     */             try
/*     */             {
/* 298 */               this.conn.rollback();
/*     */             }
/*     */             catch (Exception localException3) {
/*     */             }
/* 302 */             this.conn.close();
/* 303 */             System.out.println(DBObject.getClass().getName() + 
/* 304 */               " " + action + " Failed");
/* 305 */             return false;
/*     */           }
/*     */ 
/* 308 */           if (action.equals("DELETE&INSERT"))
/*     */           {
/* 311 */             m = DBObject.getClass().getMethod("delete", null);
/* 312 */             Boolean b = (Boolean)m.invoke(DBObject, null);
/*     */ 
/* 316 */             if (!b.booleanValue())
/*     */             {
/* 318 */               CError.buildErr(this, "\u6267\u884C\u5220\u9664\uFF0C\u63D2\u5165\u8BED\u53E5\u5931\u8D25" + getDBErrorsMessage(DBObject));
/*     */               try
/*     */               {
/* 321 */                 this.conn.rollback();
/*     */               }
/*     */               catch (Exception localException4) {
/*     */               }
/* 325 */               this.conn.close();
/* 326 */               System.out.println(DBObject.getClass().getName() + 
/* 327 */                 " " + action + " Failed");
/* 328 */               return false;
/*     */             }
/*     */ 
/* 332 */             m = DBObject.getClass().getMethod("insert", null);
/* 333 */             b = (Boolean)m.invoke(DBObject, null);
/*     */ 
/* 335 */             if (b.booleanValue())
/*     */               continue;
/* 337 */             CError.buildErr(this, "\u6267\u884C\u63D2\u5165\u8BED\u53E5\u5931\u8D25" + getDBErrorsMessage(DBObject));
/*     */             try
/*     */             {
/* 340 */               this.conn.rollback();
/*     */             }
/*     */             catch (Exception localException5) {
/*     */             }
/* 344 */             this.conn.close();
/* 345 */             System.out.println(DBObject.getClass().getName() + 
/* 346 */               " " + action + " Failed");
/* 347 */             return false;
/*     */           }
/*     */ 
/* 350 */           if (action.equals("BLOBINSERT"))
/*     */           {
/* 353 */             String tSQL = "";
/*     */ 
/* 355 */             String pWhereSQL = " and ";
/* 356 */             String pTabName = "";
/* 357 */             String pUpdateField = "";
/*     */ 
/* 359 */             String[] parmStrArr = getBlobInsertStr(o, tSQL, 
/* 360 */               pWhereSQL, pTabName, 
/* 361 */               pUpdateField);
/*     */ 
/* 377 */             String aClassName = o.getClass().getName();
/* 378 */             Schema s = (Schema)o;
/*     */ 
/* 380 */             m = o.getClass().getMethod("get" + parmStrArr[2], null);
/* 381 */             InputStream ins = (InputStream)m.invoke(o, null);
/*     */ 
/* 395 */             if (!CBlob.BlobInsert(ins, parmStrArr, this.conn))
/*     */             {
/* 397 */               CError.buildErr(this, "\u6267\u884C\u66F4\u65B0blob\u8BED\u53E5\u5931\u8D25");
/*     */               try
/*     */               {
/* 400 */                 this.conn.rollback();
/*     */               }
/*     */               catch (Exception localException6) {
/*     */               }
/* 404 */               this.conn.close();
/* 405 */               ins.close();
/* 406 */               System.out.println("tCBlob.BlobInsert " + 
/* 407 */                 action + " Failed");
/* 408 */               return false;
/*     */             }
/* 410 */             ins.close();
/*     */           }
/* 412 */           else if (action.equals("BLOBUPDATE"))
/*     */           {
/* 415 */             String tSQL = "";
/*     */ 
/* 417 */             String pWhereSQL = " and ";
/* 418 */             String pTabName = "";
/* 419 */             String pUpdateField = "";
/*     */ 
/* 421 */             String[] parmStrArr = getBlobInsertStr(o, tSQL, 
/* 422 */               pWhereSQL, pTabName, 
/* 423 */               pUpdateField);
/*     */ 
/* 427 */             String aClassName = o.getClass().getName();
/* 428 */             Schema s = (Schema)o;
/*     */ 
/* 430 */             m = o.getClass().getMethod("get" + parmStrArr[2], null);
/* 431 */             InputStream ins = (InputStream)m.invoke(o, null);
/*     */ 
/* 449 */             if (!CBlob.BlobUpdate(ins, parmStrArr, this.conn))
/*     */             {
/* 451 */               CError.buildErr(this, "\u6267\u884C\u66F4\u65B0blob\u8BED\u53E5\u5931\u8D25");
/*     */               try
/*     */               {
/* 454 */                 this.conn.rollback();
/*     */               }
/*     */               catch (Exception localException7) {
/*     */               }
/* 458 */               this.conn.close();
/* 459 */               ins.close();
/* 460 */               System.out.println("tCBlob.BlobUpdate " + 
/* 461 */                 action + " Failed");
/* 462 */               return false;
/*     */             }
/* 464 */             ins.close();
/*     */           } else {
/* 466 */             if (!action.equals("BLOBDELETE")) {
/*     */               continue;
/*     */             }
/* 469 */             m = DBObject.getClass().getMethod("delete", null);
/* 470 */             Boolean b = (Boolean)m.invoke(DBObject, null);
/*     */ 
/* 472 */             if (b.booleanValue())
/*     */               continue;
/* 474 */             CError.buildErr(this, "\u6267\u884C\u5220\u9664\u8BED\u53E5\u5931\u8D25");
/*     */             try
/*     */             {
/* 477 */               this.conn.rollback();
/*     */             }
/*     */             catch (Exception localException8) {
/*     */             }
/* 481 */             this.conn.close();
/* 482 */             System.out.println(DBObject.getClass().getName() + 
/* 483 */               " " + action + " Failed");
/* 484 */             return false;
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 495 */       this.conn.commit();
/* 496 */       this.conn.close();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 508 */       CError.buildErr(this, e.toString());
/*     */       try
/*     */       {
/* 511 */         this.conn.rollback();
/*     */       }
/*     */       catch (Exception localException9) {
/*     */       }
/* 515 */       return false;
/*     */     }
/*     */ 
/* 518 */     this.conn = null;
/* 519 */     return true;
/*     */   }
/*     */ 
/*     */   public void setCheckType(String checkType)
/*     */   {
/* 525 */     this.checkType = checkType;
/*     */   }
/*     */ 
/*     */   private static String[] getBlobInsertStr(Object o, String tSQL, String pTabName, String pUpdateField, String pWhereSQL)
/*     */   {
/* 531 */     String aClassName = o.getClass().getName();
/*     */ 
/* 533 */     if (aClassName.endsWith("Schema"))
/*     */     {
/* 535 */       Schema s = (Schema)o;
/* 536 */       String[] pk = s.getPK();
/* 537 */       pTabName = aClassName.substring(aClassName
/* 538 */         .lastIndexOf(".") + 1, 
/* 539 */         aClassName.lastIndexOf("S"));
/*     */ 
/* 542 */       String ValPart = "values(";
/* 543 */       String mark = "'";
/*     */ 
/* 545 */       int nFieldCount = s.getFieldCount();
/* 546 */       int jj = 0;
/*     */ 
/* 548 */       for (int i = 0; i < nFieldCount - 1; i++)
/*     */       {
/* 550 */         String strFieldName = s.getFieldName(i);
/* 551 */         String strFieldValue = s.getV(i);
/* 552 */         for (int ii = 0; ii < pk.length; ii++)
/*     */         {
/* 554 */           if (!strFieldName.equals(pk[ii]))
/*     */             continue;
/* 556 */           pWhereSQL = pWhereSQL + strFieldName + " = '" + strFieldValue + 
/* 557 */             "' and ";
/*     */         }
/*     */ 
/* 560 */         int nFieldType = s.getFieldType(i);
/* 561 */         boolean bFlag = false;
/*     */ 
/* 563 */         switch (nFieldType)
/*     */         {
/*     */         case 0:
/*     */         case 1:
/* 567 */           if (strFieldValue.equals("null"))
/*     */             break;
/* 569 */           strFieldValue = mark + strFieldValue + 
/* 570 */             mark;
/* 571 */           bFlag = true;
/*     */ 
/* 573 */           break;
/*     */         case 2:
/*     */         case 3:
/*     */         case 4:
/* 577 */           bFlag = true;
/* 578 */           break;
/*     */         default:
/* 580 */           bFlag = false;
/*     */         }
/*     */ 
/* 584 */         if (!bFlag)
/*     */           continue;
/* 586 */         jj++;
/* 587 */         if (jj != 1)
/*     */         {
/* 590 */           ValPart = ValPart + ",";
/*     */         }
/*     */ 
/* 593 */         ValPart = ValPart + strFieldValue;
/*     */       }
/*     */ 
/* 597 */       ValPart = ValPart + ",";
/* 598 */       ValPart = ValPart + "empty_blob()";
/* 599 */       ValPart = ValPart + ")";
/* 600 */       tSQL = "insert into " + pTabName + " " + 
/* 601 */         ValPart;
/* 602 */       if (jj == 0)
/*     */       {
/* 604 */         tSQL = "";
/*     */       }
/* 606 */       pUpdateField = s.getFieldName(nFieldCount - 1);
/* 607 */       if (pWhereSQL.lastIndexOf("and") != -1)
/*     */       {
/* 609 */         pWhereSQL = "and " + 
/* 610 */           pWhereSQL.substring(0, pWhereSQL.lastIndexOf("and"));
/*     */       }
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 616 */       return null;
/*     */     }
/* 618 */     String[] returnStr = new String[4];
/* 619 */     returnStr[0] = tSQL;
/* 620 */     returnStr[1] = pTabName;
/* 621 */     returnStr[2] = pUpdateField;
/* 622 */     returnStr[3] = pWhereSQL;
/* 623 */     return returnStr;
/*     */   }
/*     */ 
/*     */   public String getDBErrorsMessage(Object obj)
/*     */   {
/*     */     try
/*     */     {
/* 631 */       Field f = obj.getClass().getField("mErrors");
/* 632 */       CErrors tCErrors = (CErrors)f.get(obj);
/* 633 */       if (tCErrors != null)
/*     */       {
/* 635 */         return tCErrors.getError(0).errorMessage;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 641 */       System.out.println("DB\u7C7B\u6CA1\u6709\u4EA7\u751F\u9519\u8BEF\u4FE1\u606F!");
/*     */     }
/*     */ 
/* 644 */     return "";
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/* 648 */     PubSubmit pubSubmit1 = new PubSubmit();
/*     */ 
/* 664 */     VData mResult = new VData();
/*     */ 
/* 670 */     MMap map = new MMap();
/* 671 */     map.put("select 1 from dual WHERE 1=1", "SELECT");
/* 672 */     mResult.addElement(map);
/* 673 */     pubSubmit1.submitData(mResult, "");
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.pubfun.PubSubmit
 * JD-Core Version:    0.6.0
 */