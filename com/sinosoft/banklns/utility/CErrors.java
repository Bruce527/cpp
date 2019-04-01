/*     */ package com.sinosoft.banklns.utility;
/*     */ 
/*     */ import com.sinosoft.banklns.lis.pubfun.PubFun;
/*     */ import java.io.Serializable;
/*     */ import java.util.Vector;
/*     */ 
/*     */ public class CErrors
/*     */   implements Cloneable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  16 */   private Vector vErrors = new Vector();
/*  17 */   private int errorCount = 0;
/*     */ 
/*  19 */   private String flag = "";
/*  20 */   private String content = "";
/*  21 */   private String result = "";
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  26 */     CErrors cloned = (CErrors)super.clone();
/*     */ 
/*  28 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String getFlag()
/*     */   {
/*  33 */     return this.flag;
/*     */   }
/*     */ 
/*     */   public void setFlag(String f)
/*     */   {
/*  38 */     this.flag = f;
/*     */   }
/*     */ 
/*     */   public String getContent()
/*     */   {
/*  43 */     return this.content;
/*     */   }
/*     */ 
/*     */   public void setContent(String c)
/*     */   {
/*  48 */     this.content = c;
/*     */   }
/*     */ 
/*     */   public String getResult()
/*     */   {
/*  53 */     return this.result;
/*     */   }
/*     */ 
/*     */   public void setResult(String c)
/*     */   {
/*  58 */     this.result = c;
/*     */   }
/*     */ 
/*     */   public void addOneError(CError cError)
/*     */   {
/*  68 */     this.vErrors.add(cError);
/*  69 */     this.errorCount += 1;
/*     */   }
/*     */ 
/*     */   public void addOneError(String cErrorString)
/*     */   {
/*  75 */     CError tError = new CError(cErrorString.trim());
/*  76 */     this.vErrors.add(tError);
/*  77 */     this.errorCount += 1;
/*     */   }
/*     */ 
/*     */   public void removeLastError()
/*     */   {
/*  83 */     if (this.errorCount > 0)
/*     */     {
/*  85 */       this.vErrors.removeElementAt(this.errorCount - 1);
/*  86 */       this.errorCount -= 1;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void removeError(int pos)
/*     */   {
/*  93 */     if ((this.errorCount > 0) && (pos < this.errorCount))
/*     */     {
/*  95 */       this.vErrors.removeElementAt(pos);
/*  96 */       this.errorCount -= 1;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void clearErrors()
/*     */   {
/* 103 */     this.vErrors.clear();
/* 104 */     this.errorCount = 0;
/*     */   }
/*     */ 
/*     */   public int getErrorCount()
/*     */   {
/* 110 */     return this.errorCount;
/*     */   }
/*     */ 
/*     */   public CError getError(int indexError)
/*     */   {
/* 117 */     CError tError = (CError)this.vErrors.get(indexError);
/*     */ 
/* 119 */     return tError;
/*     */   }
/*     */ 
/*     */   public String getFirstError()
/*     */   {
/*     */     try
/*     */     {
/* 127 */       CError tError = (CError)this.vErrors.get(0);
/*     */ 
/* 130 */       String strMsg = tError.errorMessage;
/*     */ 
/* 132 */       strMsg = strMsg.replace('\n', ' ');
/* 133 */       strMsg = strMsg.replace('"', ' ');
/* 134 */       strMsg = strMsg.replace('\'', ' ');
/*     */ 
/* 136 */       return strMsg;
/*     */     }
/*     */     catch (Exception e) {
/*     */     }
/* 140 */     return "";
/*     */   }
/*     */ 
/*     */   public String getLastError()
/*     */   {
/* 147 */     if (this.errorCount < 1)
/*     */     {
/* 149 */       return "";
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 154 */       CError tError = (CError)this.vErrors.get(this.errorCount - 1);
/*     */ 
/* 157 */       String strMsg = tError.errorMessage;
/*     */ 
/* 159 */       strMsg = strMsg.replace('\n', ' ');
/* 160 */       strMsg = strMsg.replace('"', ' ');
/* 161 */       strMsg = strMsg.replace('\'', ' ');
/*     */ 
/* 163 */       return strMsg;
/*     */     }
/*     */     catch (Exception e) {
/*     */     }
/* 167 */     return "";
/*     */   }
/*     */ 
/*     */   public boolean needDealError()
/*     */   {
/*     */     try
/*     */     {
/* 176 */       if (getErrorCount() > 0)
/*     */       {
/* 178 */         return true;
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 183 */       return false;
/*     */     }
/*     */ 
/* 186 */     return false;
/*     */   }
/*     */ 
/*     */   public void copyAllErrors(CErrors cSourceErrors)
/*     */   {
/* 192 */     int i = 0;
/* 193 */     int iMax = 0;
/* 194 */     iMax = cSourceErrors.getErrorCount();
/*     */ 
/* 196 */     for (i = 0; i < iMax; i++)
/*     */     {
/* 198 */       addOneError(cSourceErrors.getError(i));
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getErrType()
/*     */   {
/* 205 */     int forbitNum = 0;
/* 206 */     int needSelectNum = 0;
/* 207 */     int allowNum = 0;
/* 208 */     int unknowNum = 0;
/*     */ 
/* 210 */     for (int i = 0; i < this.vErrors.size(); i++)
/*     */     {
/* 212 */       CError tError = (CError)this.vErrors.get(i);
/*     */ 
/* 214 */       if (tError.errorType.equals("1"))
/*     */       {
/* 216 */         forbitNum++;
/*     */       }
/* 218 */       else if (tError.errorType.equals("3"))
/*     */       {
/* 220 */         needSelectNum++;
/*     */       }
/* 222 */       else if (tError.errorType.equals("2"))
/*     */       {
/* 224 */         allowNum++;
/*     */       }
/*     */       else
/*     */       {
/* 228 */         unknowNum++;
/*     */       }
/*     */     }
/*     */ 
/* 232 */     if (forbitNum > 0)
/*     */     {
/* 234 */       return "1";
/*     */     }
/* 236 */     if (needSelectNum > 0)
/*     */     {
/* 238 */       return "3";
/*     */     }
/* 240 */     if (allowNum > 0)
/*     */     {
/* 242 */       return "2";
/*     */     }
/* 244 */     if (unknowNum > 0)
/*     */     {
/* 246 */       return "4";
/*     */     }
/*     */ 
/* 250 */     return "0";
/*     */   }
/*     */ 
/*     */   public String getErrContent()
/*     */   {
/* 257 */     this.content = ("\uFFFD\uFFFD\u04BB\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD " + this.vErrors.size() + " \uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\n");
/* 258 */     String forbitContent = "";
/* 259 */     String needSelectContent = "";
/* 260 */     String allowContent = "";
/* 261 */     String unknowContent = "";
/*     */ 
/* 263 */     for (int i = 0; i < this.vErrors.size(); i++)
/*     */     {
/* 265 */       CError tError = (CError)this.vErrors.get(i);
/*     */ 
/* 267 */       if (tError.errorType.equals("1"))
/*     */       {
/* 269 */         forbitContent = forbitContent + "  " + "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uB8FA" + 
/* 270 */           tError.errorNo + "\uFFFD\uFFFD" + 
/* 271 */           tError.errorMessage + "\n";
/*     */       }
/* 273 */       else if (tError.errorType.equals("3"))
/*     */       {
/* 275 */         needSelectContent = needSelectContent + "  " + "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uB8FA" + 
/* 276 */           tError.errorNo + "\uFFFD\uFFFD" + 
/* 277 */           tError.errorMessage + "\n";
/*     */       }
/* 279 */       else if (tError.errorType.equals("2"))
/*     */       {
/* 281 */         allowContent = allowContent + "  " + "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uB8FA" + tError.errorNo + 
/* 282 */           "\uFFFD\uFFFD" + 
/* 283 */           tError.errorMessage + "\n";
/*     */       }
/*     */       else
/*     */       {
/* 287 */         unknowContent = unknowContent + "  " + "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uB8FA\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD" + 
/* 288 */           tError.errorMessage + "\n";
/*     */       }
/*     */     }
/*     */ 
/* 292 */     if (!forbitContent.equals(""))
/*     */     {
/* 294 */       this.content = (this.content + "\uFFFD\uFFFD\uFFFD\u0634\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD:\n" + forbitContent);
/*     */     }
/*     */ 
/* 297 */     if (!needSelectContent.equals(""))
/*     */     {
/* 299 */       this.content = (this.content + "\uFFFD\uFFFD\u04AA\u0461\uFFFD\uFFFD\u0134\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD:\n" + needSelectContent);
/*     */     }
/*     */ 
/* 302 */     if (!allowContent.equals(""))
/*     */     {
/* 304 */       this.content = (this.content + "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u05B5\u0134\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD:\n" + allowContent);
/*     */     }
/*     */ 
/* 307 */     if (!unknowContent.equals(""))
/*     */     {
/* 309 */       this.content = (this.content + "\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD:\n" + unknowContent);
/*     */     }
/*     */ 
/* 315 */     return this.content;
/*     */   }
/*     */ 
/*     */   public void checkErrors(CErrors cerrors)
/*     */   {
/* 321 */     if (cerrors.getErrType().equals("0"))
/*     */     {
/* 323 */       this.content = "\uFFFD\uFFFD\uFFFD\uFFFD\u0279\uFFFD";
/* 324 */       this.flag = "Success";
/*     */     }
/*     */     else
/*     */     {
/* 328 */       String ErrorContent = cerrors.getErrContent();
/*     */ 
/* 330 */       if (cerrors.getErrType().equals("2"))
/*     */       {
/* 332 */         this.content = ("\uFFFD\uFFFD\uFFFD\uFFFD\u0279\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u01E3\uFFFD" + PubFun.changForHTML(ErrorContent));
/* 333 */         this.flag = "Success";
/*     */       }
/*     */       else
/*     */       {
/* 337 */         this.content = ("\uFFFD\uFFFD\uFFFD\uFFFD\u02A7\uFFFD\u0723\uFFFD\u052D\uFFFD\uFFFD\uFFFD\u01E3\uFFFD" + PubFun.changForHTML(ErrorContent));
/* 338 */         this.flag = "Fail";
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void checkWSErrors(VData v)
/*     */   {
/* 346 */     String type = (String)v.get(0);
/*     */ 
/* 348 */     if (type.equals("0"))
/*     */     {
/* 350 */       this.content = "\uFFFD\uFFFD\uFFFD\uFFFD\u0279\uFFFD";
/* 351 */       this.flag = "Success";
/*     */ 
/* 353 */       if (v.size() > 1)
/*     */       {
/* 355 */         this.result = ((String)v.get(1));
/*     */       }
/*     */ 
/*     */     }
/* 360 */     else if (type.equals("2"))
/*     */     {
/* 362 */       this.content = ("\uFFFD\uFFFD\uFFFD\uFFFD\u0279\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u01E3\uFFFD" + PubFun.changForHTML((String)v.get(1)));
/* 363 */       this.flag = "Success";
/*     */     }
/*     */     else
/*     */     {
/* 367 */       this.content = ("\uFFFD\uFFFD\uFFFD\uFFFD\u02A7\uFFFD\u0723\uFFFD\u052D\uFFFD\uFFFD\uFFFD\u01E3\uFFFD" + PubFun.changForHTML((String)v.get(1)));
/* 368 */       this.flag = "Fail";
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.CErrors
 * JD-Core Version:    0.6.0
 */