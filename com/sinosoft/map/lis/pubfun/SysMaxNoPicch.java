/*     */ package com.sinosoft.map.lis.pubfun;
/*     */ 
/*     */ import com.sinosoft.map.utility.CErrors;
/*     */ import com.sinosoft.map.utility.DBConnPool;
/*     */ import com.sinosoft.map.utility.ExeSQL;
/*     */ import com.sinosoft.map.utility.VData;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.util.Random;
/*     */ 
/*     */ public class SysMaxNoPicch
/*     */   implements SysMaxNo
/*     */ {
/*     */   public String CreateMaxNo(String cNoType, String cNoLimit, VData cVData)
/*     */   {
/*  19 */     return CreateMaxNo(cNoType, cNoLimit);
/*     */   }
/*     */ 
/*     */   public String CreateMaxNo(String cNoType, int cNoLength)
/*     */   {
/*  25 */     if ((cNoType == null) || (cNoType.trim().length() <= 0) || 
/*  26 */       (cNoLength <= 0))
/*     */     {
/*  28 */       System.out.println("NoType\u957F\u5EA6\u9519\u8BEF\u6216NoLength\u9519\u8BEF");
/*     */ 
/*  30 */       return null;
/*     */     }
/*     */ 
/*  33 */     cNoType = cNoType.toUpperCase();
/*     */ 
/*  36 */     Connection conn = DBConnPool.getConnection();
/*     */ 
/*  38 */     if (conn == null)
/*     */     {
/*  40 */       System.out.println("CreateMaxNo : fail to get db connection");
/*     */ 
/*  42 */       return null;
/*     */     }
/*     */ 
/*  45 */     String tReturn = "";
/*  46 */     String cNoLimit = "SN";
/*  47 */     int tMaxNo = 0;
/*  48 */     tReturn = cNoLimit;
/*     */     try
/*     */     {
/*  53 */       conn.setAutoCommit(false);
/*     */ 
/*  55 */       String strSQL = "select MaxNo from LDMaxNo where notype='" + 
/*  56 */         cNoType + "' and nolimit='" + cNoLimit + 
/*  57 */         "' for update";
/*     */ 
/*  59 */       if ("ORACLE".equals("ORACLE"))
/*     */       {
/*  61 */         strSQL = strSQL + " nowait";
/*     */       }
/*     */ 
/*  64 */       ExeSQL exeSQL = new ExeSQL(conn);
/*  65 */       String result = null;
/*  66 */       result = exeSQL.getOneValue(strSQL);
/*     */ 
/*  68 */       if ((result == null) || (exeSQL.mErrors.needDealError()))
/*     */       {
/*  70 */         System.out.println("CreateMaxNo \u8D44\u6E90\u5FD9\uFF0C\u8BF7\u7A0D\u540E!");
/*  71 */         conn.rollback();
/*  72 */         conn.close();
/*     */ 
/*  74 */         return null;
/*     */       }
/*     */ 
/*  77 */       if (result.equals(""))
/*     */       {
/*  79 */         strSQL = "insert into ldmaxno(notype, nolimit, maxno) values('" + 
/*  80 */           cNoType + "', '" + cNoLimit + "', 1)";
/*  81 */         exeSQL = new ExeSQL(conn);
/*     */ 
/*  83 */         if (!exeSQL.execUpdateSQL(strSQL))
/*     */         {
/*  85 */           System.out.println("CreateMaxNo \u63D2\u5165\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5!");
/*  86 */           conn.rollback();
/*  87 */           conn.close();
/*     */ 
/*  89 */           return null;
/*     */         }
/*     */ 
/*  93 */         tMaxNo = 1;
/*     */       }
/*     */       else
/*     */       {
/*  98 */         strSQL = "update ldmaxno set maxno = maxno + 1 where notype = '" + 
/*  99 */           cNoType + "' and nolimit = '" + 
/* 100 */           cNoLimit + "'";
/* 101 */         exeSQL = new ExeSQL(conn);
/*     */ 
/* 103 */         if (!exeSQL.execUpdateSQL(strSQL))
/*     */         {
/* 105 */           System.out.println("CreateMaxNo \u66F4\u65B0\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5!");
/* 106 */           conn.rollback();
/* 107 */           conn.close();
/*     */ 
/* 109 */           return null;
/*     */         }
/*     */ 
/* 113 */         tMaxNo = Integer.parseInt(result) + 1;
/*     */       }
/*     */ 
/* 117 */       conn.commit();
/* 118 */       conn.close();
/*     */     }
/*     */     catch (Exception Ex)
/*     */     {
/*     */       try
/*     */       {
/* 124 */         conn.rollback();
/* 125 */         conn.close();
/*     */ 
/* 127 */         return null;
/*     */       }
/*     */       catch (Exception e1)
/*     */       {
/* 131 */         e1.printStackTrace();
/*     */ 
/* 133 */         return null;
/*     */       }
/*     */     }
/*     */ 
/* 137 */     String tStr = String.valueOf(tMaxNo);
/* 138 */     tStr = PubFun.LCh(tStr, "0", cNoLength);
/* 139 */     tReturn = tStr.trim();
/*     */ 
/* 141 */     return tReturn;
/*     */   }
/*     */ 
/*     */   public String CreateMaxNo(String cNoType, String cInput)
/*     */   {
/* 148 */     if ((cNoType == null) || (cNoType.trim().length() <= 0))
/*     */     {
/* 150 */       System.out.println("NoType\u957F\u5EA6\u9519\u8BEF");
/* 151 */       return null;
/*     */     }
/*     */ 
/* 154 */     String tReturn = null;
/* 155 */     cNoType = cNoType.toUpperCase();
/*     */ 
/* 157 */     String tDate = PubFun.getCurrentDate();
/* 158 */     String tDateCode = tDate.substring(2, 4) + tDate.substring(5, 7) + tDate.substring(8, 10);
/*     */ 
/* 161 */     if (cNoType.equals("FamilyNo"))
/*     */     {
/* 163 */       tReturn = "F" + CreateMaxNo(cNoType, 9);
/*     */     }
/* 167 */     else if (cNoType.equals("CUSTOMERNO"))
/*     */     {
/* 169 */       tReturn = CreateMaxNo(cNoType, 9);
/*     */     }
/* 173 */     else if (cNoType.equals("PROPOSALCONTNO"))
/*     */     {
/* 175 */       tReturn = "13" + CreateMaxNo(cNoType, 9);
/*     */     }
/* 179 */     else if (cNoType.equals("PROGRPCONTNO"))
/*     */     {
/* 181 */       tReturn = "14" + CreateMaxNo(cNoType, 8);
/*     */     }
/* 185 */     else if (cNoType.equals("POLNO"))
/*     */     {
/* 187 */       tReturn = "21" + CreateMaxNo(cNoType, 9);
/*     */     }
/* 191 */     else if (cNoType.equals("GRPPOLNO"))
/*     */     {
/* 193 */       tReturn = "22" + CreateMaxNo(cNoType, 8);
/*     */     }
/* 197 */     else if (cNoType.equals("CONTNO"))
/*     */     {
/* 199 */       if ((cInput == null) || (cInput.length() != 9))
/*     */       {
/* 201 */         System.out.println("\u8BF7\u8F93\u51659\u4F4D\u5BA2\u6237\u53F7!");
/* 202 */         return null;
/*     */       }
/* 204 */       tReturn = cInput + CreateMaxNo(cNoType, 2);
/*     */     }
/* 208 */     else if (cNoType.equals("GRPPERSONCONTNO"))
/*     */     {
/* 210 */       tReturn = "23" + CreateMaxNo(cNoType, 8);
/*     */     }
/* 214 */     else if (cNoType.equals("PRINTNO"))
/*     */     {
/* 216 */       tReturn = "16" + CreateMaxNo(cNoType, 9);
/*     */     }
/* 220 */     else if (cNoType.equals("GRPNO"))
/*     */     {
/* 222 */       tReturn = CreateMaxNo(cNoType, 8);
/*     */     }
/* 226 */     else if (cNoType.equals("GRPINSUREDNO"))
/*     */     {
/* 228 */       if ((cInput == null) || (cInput.length() != 9))
/*     */       {
/* 230 */         System.out.println("\u8BF7\u8F93\u51659\u4F4D\u5BA2\u6237\u53F7!");
/* 231 */         return null;
/*     */       }
/* 233 */       tReturn = cInput + CreateMaxNo(cNoType, 2);
/*     */     }
/* 237 */     else if (cNoType.equals("GRPCONTNO"))
/*     */     {
/* 239 */       if ((cInput == null) || (cInput.length() != 8))
/*     */       {
/* 241 */         System.out.println("\u8BF7\u8F93\u51658\u4F4D\u5BA2\u6237\u53F7!");
/* 242 */         return null;
/*     */       }
/* 244 */       tReturn = cInput + CreateMaxNo(cNoType, 2);
/*     */     }
/* 248 */     else if (cNoType.equals("GRPQUERYNO"))
/*     */     {
/* 250 */       if ((cInput == null) || (cInput.length() != 8))
/*     */       {
/* 252 */         System.out.println("\u8BF7\u8F93\u51658\u4F4D\u5BA2\u6237\u53F7!");
/* 253 */         return null;
/*     */       }
/* 255 */       tReturn = "R" + cInput + CreateMaxNo(cNoType, 3);
/*     */     }
/* 257 */     else if (cNoType.equals("PROPOSALNO"))
/*     */     {
/* 259 */       tReturn = "11" + CreateMaxNo(cNoType, 9);
/*     */     }
/* 263 */     else if (cNoType.equals("GRPPROPOSALNO"))
/*     */     {
/* 265 */       tReturn = "12" + CreateMaxNo(cNoType, 9);
/*     */     }
/* 269 */     else if (cNoType.equals("GRPCOMFIRMPRTNO"))
/*     */     {
/* 271 */       tReturn = "18" + CreateMaxNo(cNoType, 9);
/*     */     }
/* 275 */     else if (cNoType.equals("GRPQUERYPRTNO"))
/*     */     {
/* 277 */       tReturn = "19" + CreateMaxNo(cNoType, 9);
/*     */     }
/* 281 */     else if (cNoType.equals("BARCODENO"))
/*     */     {
/* 283 */       if (cInput == null)
/*     */       {
/* 285 */         System.out.println("\u8BF7\u8F93\u51659\u4F4D\u5BA2\u6237\u53F7!");
/* 286 */         return null;
/*     */       }
/* 288 */       Random random = new Random();
/* 289 */       tReturn = cInput + Math.abs(random.nextInt()) % 100;
/*     */     }
/* 294 */     else if (cNoType.equals("NOTICENO"))
/*     */     {
/* 301 */       cInput = getClaimLimit(cInput);
/* 302 */       tReturn = "T" + cInput + tDateCode + 
/* 303 */         CreateMaxNo(new StringBuilder(String.valueOf(cNoType)).append(tDateCode).toString(), 6);
/*     */     }
/* 306 */     else if (cNoType.equals("COSULTNO"))
/*     */     {
/* 313 */       cInput = getClaimLimit(cInput);
/* 314 */       tReturn = "Z" + cInput + tDateCode + 
/* 315 */         CreateMaxNo(new StringBuilder(String.valueOf(cNoType)).append(tDateCode).toString(), 6);
/*     */     }
/* 319 */     else if (cNoType.equals("CNNO"))
/*     */     {
/* 326 */       cInput = getClaimLimit(cInput);
/* 327 */       tReturn = "H" + cInput + tDateCode + 
/* 328 */         CreateMaxNo(new StringBuilder(String.valueOf(cNoType)).append(tDateCode).toString(), 6);
/*     */     }
/* 332 */     else if (cNoType.equals("CASENO"))
/*     */     {
/* 339 */       cInput = getClaimLimit(cInput);
/* 340 */       tReturn = "C" + cInput + tDateCode + 
/* 341 */         CreateMaxNo(new StringBuilder(String.valueOf(cNoType)).append(tDateCode).toString(), 6);
/*     */     }
/* 345 */     else if (cNoType.equals("APPEALNO"))
/*     */     {
/* 352 */       cInput = getClaimLimit(cInput);
/* 353 */       tReturn = "S" + cInput + tDateCode + 
/* 354 */         CreateMaxNo(new StringBuilder(String.valueOf(cNoType)).append(tDateCode).toString(), 6);
/*     */     }
/* 358 */     else if (cNoType.equals("LLERRORNO"))
/*     */     {
/* 365 */       cInput = getClaimLimit(cInput);
/* 366 */       tReturn = "R" + cInput + tDateCode + 
/* 367 */         CreateMaxNo(new StringBuilder(String.valueOf(cNoType)).append(tDateCode).toString(), 6);
/*     */     }
/* 371 */     else if (cNoType.equals("RGTNO"))
/*     */     {
/* 378 */       cInput = getClaimLimit(cInput);
/* 379 */       tReturn = "P" + cInput + tDateCode + 
/* 380 */         CreateMaxNo(new StringBuilder(String.valueOf(cNoType)).append(tDateCode).toString(), 6);
/*     */     }
/* 384 */     else if (cNoType.equals("SUBRPTNO"))
/*     */     {
/* 391 */       cInput = getClaimLimit(cInput);
/* 392 */       tReturn = "A" + cInput + tDateCode + 
/* 393 */         CreateMaxNo(new StringBuilder(String.valueOf(cNoType)).append(tDateCode).toString(), 6);
/*     */     }
/* 397 */     else if (cNoType.equals("PAYNOTICENO"))
/*     */     {
/* 399 */       tReturn = "31" + CreateMaxNo(cNoType, 9);
/*     */     }
/* 403 */     else if (cNoType.equals("PAYNO"))
/*     */     {
/* 405 */       tReturn = "32" + CreateMaxNo(cNoType, 9);
/*     */     }
/* 409 */     else if (cNoType.equals("GETNOTICENO"))
/*     */     {
/* 411 */       tReturn = "36" + CreateMaxNo(cNoType, 9);
/*     */     }
/* 415 */     else if (cNoType.equals("GETNO"))
/*     */     {
/* 417 */       tReturn = "37" + CreateMaxNo(cNoType, 9);
/*     */     }
/* 421 */     else if (cNoType.equals("EDORAPPNO"))
/*     */     {
/* 423 */       tReturn = "41" + CreateMaxNo(cNoType, 9);
/*     */     }
/* 427 */     else if (cNoType.equals("EDORNO"))
/*     */     {
/* 429 */       tReturn = "42" + CreateMaxNo(cNoType, 9);
/*     */     }
/* 433 */     else if (cNoType.equals("EDORGRPAPPNO"))
/*     */     {
/* 435 */       tReturn = "43" + CreateMaxNo(cNoType, 9);
/*     */     }
/* 439 */     else if (cNoType.equals("EDORGRPNO"))
/*     */     {
/* 441 */       tReturn = "44" + CreateMaxNo(cNoType, 9);
/*     */     }
/* 444 */     else if (cNoType.equals("PROTOCOLNO"))
/*     */     {
/* 446 */       tReturn = "71" + CreateMaxNo(cNoType, 9);
/*     */     }
/* 450 */     else if (cNoType.equals("PRTNO"))
/*     */     {
/* 452 */       tReturn = "80" + CreateMaxNo(cNoType, 9);
/*     */     }
/* 456 */     else if (cNoType.equals("PRTSEQNO"))
/*     */     {
/* 458 */       tReturn = "81" + CreateMaxNo(cNoType, 9);
/*     */     }
/* 462 */     else if (cNoType.equals("PRTSEQ2NO"))
/*     */     {
/* 464 */       tReturn = "82" + CreateMaxNo(cNoType, 9);
/*     */     }
/* 468 */     else if (cNoType.equals("TAKEBACKNO"))
/*     */     {
/* 470 */       tReturn = "61" + CreateMaxNo(cNoType, 9);
/*     */     }
/* 474 */     else if (cNoType.equals("BATCHNO"))
/*     */     {
/* 476 */       tReturn = "62" + CreateMaxNo(cNoType, 9);
/*     */     }
/* 480 */     else if (cNoType.equals("VOUCHERIDNO"))
/*     */     {
/* 482 */       tReturn = "63" + CreateMaxNo(cNoType, 9);
/*     */     }
/* 486 */     else if (cNoType.equals("WAGENO"))
/*     */     {
/* 488 */       tReturn = "90" + CreateMaxNo(cNoType, 9);
/*     */     }
/* 492 */     else if (cNoType.equals("SERIALNO"))
/*     */     {
/* 494 */       tReturn = "98" + CreateMaxNo(cNoType, 9);
/*     */     }
/*     */     else
/*     */     {
/* 500 */       SysMaxNoZhongYing zhongying = new SysMaxNoZhongYing();
/* 501 */       tReturn = zhongying.CreateMaxNo(cNoType, cInput);
/*     */     }
/*     */ 
/* 504 */     return tReturn;
/*     */   }
/*     */ 
/*     */   private String getClaimLimit(String MngComCode)
/*     */   {
/* 509 */     return MngComCode.substring(2, 6);
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 514 */     SysMaxNoPicch tSysMaxNoPicch = new SysMaxNoPicch();
/*     */ 
/* 528 */     System.out.println("CASERELANO" + tSysMaxNoPicch.CreateMaxNo("CASERELANO", "8600"));
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.lis.pubfun.SysMaxNoPicch
 * JD-Core Version:    0.6.0
 */