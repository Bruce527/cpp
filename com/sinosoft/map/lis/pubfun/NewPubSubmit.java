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
/*     */ import java.lang.reflect.Method;
/*     */ import java.sql.Connection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class NewPubSubmit
/*     */ {
/*     */   private VData mInputData;
/*  22 */   public CErrors mErrors = new CErrors();
/*     */ 
/*  24 */   private Connection conn = null;
/*     */ 
/*  26 */   private final boolean commitFlag = true;
/*     */ 
/*     */   public boolean submitData(VData cInputData, String cOperate)
/*     */   {
/*  36 */     this.mInputData = ((VData)cInputData.clone());
/*     */ 
/*  38 */     if (!saveData())
/*     */     {
/*  40 */       return false;
/*     */     }
/*  42 */     this.mInputData = null;
/*  43 */     return true;
/*     */   }
/*     */ 
/*     */   private boolean saveData()
/*     */   {
/*  52 */     if (this.conn == null)
/*     */     {
/*  54 */       this.conn = DBConnPool.getConnection();
/*     */     }
/*     */ 
/*  57 */     if (this.conn == null)
/*     */     {
/*  60 */       CError.buildErr(this, "\u6570\u636E\u5E93\u8FDE\u63A5\u5931\u8D25");
/*  61 */       return false;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  67 */       this.conn.setAutoCommit(false);
/*     */ 
/*  69 */       String action = "";
/*  70 */       String className = "";
/*  71 */       Object o = null;
/*  72 */       Object DBObject = null;
/*  73 */       Method m = null;
/*  74 */       Constructor constructor = null;
/*  75 */       Class[] parameterC = new Class[1];
/*  76 */       Object[] parameterO = new Object[1];
/*     */ 
/*  80 */       MMap map = (MMap)this.mInputData.getObjectByObjectName("MMap", 0);
/*  81 */       if ((map != null) && (map.keySet().size() != 0))
/*     */       {
/*  83 */         Set set = map.keySet();
/*     */ 
/*  86 */         for (int j = 0; j < set.size(); j++)
/*     */         {
/*  90 */           o = map.getOrder().get(String.valueOf(j + 1));
/*     */ 
/*  92 */           action = (String)map.get(o);
/*  93 */           if (action == null)
/*     */           {
/*     */             continue;
/*     */           }
/*     */ 
/* 101 */           className = o.getClass().getName();
/*     */ 
/* 105 */           if (className.endsWith("String"))
/*     */           {
/* 107 */             if (action.equals("UPDATE"))
/*     */             {
/* 109 */               className = "com.sinosoft.map.lis.db." + 
/* 110 */                 className
/* 111 */                 .substring(className.lastIndexOf(".") + 
/* 112 */                 1, className.lastIndexOf("S")) + 
/* 113 */                 "DB";
/* 114 */               String tSQL = (String)o;
/* 115 */               ExeSQL tExeSQL = new ExeSQL(this.conn);
/*     */ 
/* 117 */               tExeSQL.execUpdateSQL(tSQL);
/*     */ 
/* 124 */               continue;
/*     */             }
/* 126 */             if (action.equals("DELETE"))
/*     */             {
/* 128 */               className = "com.sinosoft.map.lis.db." + 
/* 129 */                 className
/* 130 */                 .substring(className.lastIndexOf(".") + 
/* 131 */                 1, className.lastIndexOf("S")) + 
/* 132 */                 "DB";
/* 133 */               String tSQL = (String)o;
/* 134 */               ExeSQL tExeSQL = new ExeSQL(this.conn);
/*     */ 
/* 136 */               tExeSQL.execUpdateSQL(tSQL);
/*     */ 
/* 143 */               continue;
/*     */             }
/* 145 */             if (action.equals("INSERT"))
/*     */             {
/* 147 */               className = "com.sinosoft.map.lis.db." + 
/* 148 */                 className
/* 149 */                 .substring(className.lastIndexOf(".") + 
/* 150 */                 1, className.lastIndexOf("S")) + 
/* 151 */                 "DB";
/* 152 */               String tSQL = (String)o;
/* 153 */               ExeSQL tExeSQL = new ExeSQL(this.conn);
/*     */ 
/* 155 */               if (tExeSQL.execUpdateSQL(tSQL))
/*     */               {
/*     */                 continue;
/*     */               }
/*     */ 
/* 164 */               System.out.println("\u7B2C" + j + "\u884C\u6570\u636E\u4FDD\u5B58\u5931\u8D25\uFF01");
/* 165 */               CError.buildErr(this, "\u7B2C" + j + 1 + "\u884C\u6570\u636E\u4FDD\u5B58\u5931\u8D25\uFF01");
/*     */ 
/* 168 */               continue;
/*     */             }
/* 170 */             if (action.equals("SELECT"))
/*     */             {
/* 172 */               className = "com.sinosoft.map.lis.db." + 
/* 173 */                 className
/* 174 */                 .substring(className.lastIndexOf(".") + 
/* 175 */                 1, className.lastIndexOf("S")) + 
/* 176 */                 "DB";
/* 177 */               String tSQL = (String)o;
/* 178 */               ExeSQL tExeSQL = new ExeSQL(this.conn);
/* 179 */               SSRS tSSRS = new SSRS();
/* 180 */               System.out.println("\u6267\u884CSQL\u8BED\u53E5:" + tSQL);
/* 181 */               tSSRS = tExeSQL.execSQL(tSQL);
/*     */ 
/* 183 */               tSSRS.getMaxRow();
/*     */ 
/* 190 */               continue;
/*     */             }
/*     */           }
/* 193 */           else if (className.endsWith("Schema"))
/*     */           {
/* 195 */             className = "com.sinosoft.map.lis.db." + 
/* 196 */               className
/* 197 */               .substring(className.lastIndexOf(".") + 1, 
/* 198 */               className.lastIndexOf("S")) + 
/* 199 */               "DB";
/*     */           }
/* 201 */           else if (className.endsWith("BLSet"))
/*     */           {
/* 203 */             className = "com.sinosoft.map.lis.vdb." + 
/* 204 */               className
/* 205 */               .substring(className.lastIndexOf(".") + 1, 
/* 206 */               className.lastIndexOf("B")) + 
/* 207 */               "DBSet";
/*     */           }
/* 209 */           else if (className.endsWith("Set"))
/*     */           {
/* 211 */             className = "com.sinosoft.map.lis.vdb." + 
/* 212 */               className
/* 213 */               .substring(className.lastIndexOf(".") + 1, 
/* 214 */               className.lastIndexOf("S")) + 
/* 215 */               "DBSet";
/*     */           }
/* 217 */           Class DBClass = Class.forName(className);
/*     */ 
/* 220 */           parameterC[0] = Connection.class;
/* 221 */           constructor = DBClass.getConstructor(parameterC);
/* 222 */           parameterO[0] = this.conn;
/* 223 */           DBObject = constructor.newInstance(parameterO);
/*     */ 
/* 226 */           parameterC[0] = o.getClass();
/* 227 */           if (o.getClass().getName().endsWith("Schema"))
/*     */           {
/* 229 */             m = DBObject.getClass().getMethod("setSchema", 
/* 230 */               parameterC);
/*     */           }
/* 232 */           else if (o.getClass().getName().endsWith("Set"))
/*     */           {
/* 234 */             m = DBObject.getClass().getMethod("set", parameterC);
/*     */           }
/* 236 */           parameterO[0] = o;
/* 237 */           m.invoke(DBObject, parameterO);
/*     */ 
/* 240 */           if (action.equals("INSERT"))
/*     */           {
/* 242 */             m = DBObject.getClass().getMethod("insert", null);
/* 243 */             Boolean b = (Boolean)m.invoke(DBObject, null);
/*     */ 
/* 245 */             if (b.booleanValue()) {
/*     */               continue;
/*     */             }
/*     */             try
/*     */             {
/* 250 */               this.conn.rollback();
/*     */             }
/*     */             catch (Exception localException1) {
/*     */             }
/* 254 */             this.conn.close();
/* 255 */             System.out.println(DBObject.getClass().getName() + 
/* 256 */               " " + action + " Failed");
/* 257 */             return false;
/*     */           }
/*     */ 
/* 260 */           if (action.equals("UPDATE"))
/*     */           {
/* 262 */             m = DBObject.getClass().getMethod("update", null);
/* 263 */             Boolean b = (Boolean)m.invoke(DBObject, null);
/*     */ 
/* 265 */             if (b.booleanValue()) {
/*     */               continue;
/*     */             }
/*     */             try
/*     */             {
/* 270 */               this.conn.rollback();
/*     */             }
/*     */             catch (Exception localException2) {
/*     */             }
/* 274 */             this.conn.close();
/* 275 */             System.out.println(DBObject.getClass().getName() + 
/* 276 */               " " + action + " Failed");
/* 277 */             return false;
/*     */           }
/*     */ 
/* 280 */           if (action.equals("DELETE"))
/*     */           {
/* 282 */             m = DBObject.getClass().getMethod("delete", null);
/* 283 */             Boolean b = (Boolean)m.invoke(DBObject, null);
/*     */ 
/* 285 */             if (b.booleanValue()) {
/*     */               continue;
/*     */             }
/*     */             try
/*     */             {
/* 290 */               this.conn.rollback();
/*     */             }
/*     */             catch (Exception localException3) {
/*     */             }
/* 294 */             this.conn.close();
/* 295 */             System.out.println(DBObject.getClass().getName() + 
/* 296 */               " " + action + " Failed");
/* 297 */             return false;
/*     */           }
/*     */ 
/* 300 */           if (action.equals("DELETE&INSERT"))
/*     */           {
/* 303 */             m = DBObject.getClass().getMethod("delete", null);
/* 304 */             Boolean b = (Boolean)m.invoke(DBObject, null);
/*     */ 
/* 306 */             if (!b.booleanValue())
/*     */             {
/*     */               try
/*     */               {
/* 311 */                 this.conn.rollback();
/*     */               }
/*     */               catch (Exception localException4) {
/*     */               }
/* 315 */               this.conn.close();
/* 316 */               System.out.println(DBObject.getClass().getName() + 
/* 317 */                 " " + action + " Failed");
/* 318 */               return false;
/*     */             }
/*     */ 
/* 322 */             m = DBObject.getClass().getMethod("insert", null);
/* 323 */             b = (Boolean)m.invoke(DBObject, null);
/*     */ 
/* 325 */             if (b.booleanValue()) {
/*     */               continue;
/*     */             }
/*     */             try
/*     */             {
/* 330 */               this.conn.rollback();
/*     */             }
/*     */             catch (Exception localException5) {
/*     */             }
/* 334 */             this.conn.close();
/* 335 */             System.out.println(DBObject.getClass().getName() + 
/* 336 */               " " + action + " Failed");
/* 337 */             return false;
/*     */           }
/*     */ 
/* 340 */           if (action.equals("BLOBINSERT"))
/*     */           {
/* 343 */             String tSQL = "";
/*     */ 
/* 345 */             String pWhereSQL = " and ";
/* 346 */             String pTabName = "";
/* 347 */             String pUpdateField = "";
/*     */ 
/* 349 */             String[] parmStrArr = getBlobInsertStr(o, tSQL, 
/* 350 */               pWhereSQL, pTabName, 
/* 351 */               pUpdateField);
/*     */ 
/* 367 */             String aClassName = o.getClass().getName();
/* 368 */             Schema s = (Schema)o;
/*     */ 
/* 370 */             m = o.getClass().getMethod("get" + parmStrArr[2], null);
/* 371 */             InputStream ins = (InputStream)m.invoke(o, null);
/*     */ 
/* 385 */             CBlob.BlobInsert(ins, parmStrArr, this.conn);
/*     */ 
/* 400 */             ins.close();
/*     */           }
/* 402 */           else if (action.equals("BLOBUPDATE"))
/*     */           {
/* 405 */             String tSQL = "";
/*     */ 
/* 407 */             String pWhereSQL = " and ";
/* 408 */             String pTabName = "";
/* 409 */             String pUpdateField = "";
/*     */ 
/* 411 */             String[] parmStrArr = getBlobInsertStr(o, tSQL, 
/* 412 */               pWhereSQL, pTabName, 
/* 413 */               pUpdateField);
/*     */ 
/* 417 */             String aClassName = o.getClass().getName();
/* 418 */             Schema s = (Schema)o;
/*     */ 
/* 420 */             m = o.getClass().getMethod("get" + parmStrArr[2], null);
/* 421 */             InputStream ins = (InputStream)m.invoke(o, null);
/*     */ 
/* 439 */             CBlob.BlobUpdate(ins, parmStrArr, this.conn);
/*     */ 
/* 454 */             ins.close();
/*     */           } else {
/* 456 */             if (!action.equals("BLOBDELETE")) {
/*     */               continue;
/*     */             }
/* 459 */             m = DBObject.getClass().getMethod("delete", null);
/* 460 */             Boolean b = (Boolean)m.invoke(DBObject, null);
/*     */ 
/* 462 */             b.booleanValue();
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 485 */       this.conn.commit();
/* 486 */       this.conn.close();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 498 */       CError.buildErr(this, e.toString());
/*     */       try
/*     */       {
/* 501 */         this.conn.rollback();
/*     */       }
/*     */       catch (Exception localException6) {
/*     */       }
/* 505 */       return false;
/*     */     }
/* 507 */     return true;
/*     */   }
/*     */ 
/*     */   private static String[] getBlobInsertStr(Object o, String tSQL, String pTabName, String pUpdateField, String pWhereSQL)
/*     */   {
/* 515 */     String aClassName = o.getClass().getName();
/*     */ 
/* 517 */     if (aClassName.endsWith("Schema"))
/*     */     {
/* 519 */       Schema s = (Schema)o;
/* 520 */       String[] pk = s.getPK();
/* 521 */       pTabName = aClassName.substring(aClassName
/* 522 */         .lastIndexOf(".") + 1, 
/* 523 */         aClassName.lastIndexOf("S"));
/*     */ 
/* 526 */       String ValPart = "values(";
/* 527 */       String mark = "'";
/*     */ 
/* 529 */       int nFieldCount = s.getFieldCount();
/* 530 */       int jj = 0;
/*     */ 
/* 532 */       for (int i = 0; i < nFieldCount - 1; i++)
/*     */       {
/* 534 */         String strFieldName = s.getFieldName(i);
/* 535 */         String strFieldValue = s.getV(i);
/* 536 */         for (int ii = 0; ii < pk.length; ii++)
/*     */         {
/* 538 */           if (!strFieldName.equals(pk[ii]))
/*     */             continue;
/* 540 */           pWhereSQL = pWhereSQL + strFieldName + " = '" + strFieldValue + 
/* 541 */             "' and ";
/*     */         }
/*     */ 
/* 544 */         int nFieldType = s.getFieldType(i);
/* 545 */         boolean bFlag = false;
/*     */ 
/* 547 */         switch (nFieldType)
/*     */         {
/*     */         case 0:
/*     */         case 1:
/* 551 */           if (strFieldValue.equals("null"))
/*     */             break;
/* 553 */           strFieldValue = mark + strFieldValue + 
/* 554 */             mark;
/* 555 */           bFlag = true;
/*     */ 
/* 557 */           break;
/*     */         case 2:
/*     */         case 3:
/*     */         case 4:
/* 561 */           bFlag = true;
/* 562 */           break;
/*     */         default:
/* 564 */           bFlag = false;
/*     */         }
/*     */ 
/* 568 */         if (!bFlag)
/*     */           continue;
/* 570 */         jj++;
/* 571 */         if (jj != 1)
/*     */         {
/* 574 */           ValPart = ValPart + ",";
/*     */         }
/*     */ 
/* 577 */         ValPart = ValPart + strFieldValue;
/*     */       }
/*     */ 
/* 581 */       ValPart = ValPart + ",";
/* 582 */       ValPart = ValPart + "empty_blob()";
/* 583 */       ValPart = ValPart + ")";
/* 584 */       tSQL = "insert into " + pTabName + " " + 
/* 585 */         ValPart;
/* 586 */       if (jj == 0)
/*     */       {
/* 588 */         tSQL = "";
/*     */       }
/* 590 */       pUpdateField = s.getFieldName(nFieldCount - 1);
/* 591 */       if (pWhereSQL.lastIndexOf("and") != -1)
/*     */       {
/* 593 */         pWhereSQL = "and " + 
/* 594 */           pWhereSQL.substring(0, pWhereSQL.lastIndexOf("and"));
/*     */       }
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 600 */       return null;
/*     */     }
/* 602 */     String[] returnStr = new String[4];
/* 603 */     returnStr[0] = tSQL;
/* 604 */     returnStr[1] = pTabName;
/* 605 */     returnStr[2] = pUpdateField;
/* 606 */     returnStr[3] = pWhereSQL;
/* 607 */     return returnStr;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 612 */     PubSubmit pubSubmit1 = new PubSubmit();
/*     */ 
/* 628 */     VData mResult = new VData();
/*     */ 
/* 634 */     MMap map = new MMap();
/* 635 */     map.put("select 1 from dual WHERE 1=1", "SELECT");
/* 636 */     mResult.addElement(map);
/* 637 */     pubSubmit1.submitData(mResult, "");
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.pubfun.NewPubSubmit
 * JD-Core Version:    0.6.0
 */