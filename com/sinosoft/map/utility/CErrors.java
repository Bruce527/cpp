/*     */ package com.sinosoft.map.utility;
/*     */ 
/*     */ import com.sinosoft.map.lis.pubfun.PubFun;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Vector;
/*     */ 
/*     */ public class CErrors
/*     */   implements Cloneable
/*     */ {
/*  14 */   private Vector vErrors = new Vector();
/*  15 */   private int errorCount = 0;
/*     */ 
/*  17 */   private String flag = "";
/*  18 */   private String content = "";
/*  19 */   private String result = "";
/*     */ 
/*     */   public Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/*  25 */     CErrors cloned = (CErrors)super.clone();
/*     */ 
/*  27 */     return cloned;
/*     */   }
/*     */ 
/*     */   public String getFlag()
/*     */   {
/*  32 */     return this.flag;
/*     */   }
/*     */ 
/*     */   public void setFlag(String f)
/*     */   {
/*  37 */     this.flag = f;
/*     */   }
/*     */ 
/*     */   public String getContent()
/*     */   {
/*  42 */     return this.content;
/*     */   }
/*     */ 
/*     */   public void setContent(String c)
/*     */   {
/*  47 */     this.content = c;
/*     */   }
/*     */ 
/*     */   public String getResult()
/*     */   {
/*  52 */     return this.result;
/*     */   }
/*     */ 
/*     */   public void setResult(String c)
/*     */   {
/*  57 */     this.result = c;
/*     */   }
/*     */ 
/*     */   public void addOneError(CError cError)
/*     */   {
/*  67 */     this.vErrors.add(cError);
/*  68 */     this.errorCount += 1;
/*     */   }
/*     */ 
/*     */   public void addOneError(String cErrorString)
/*     */   {
/*  74 */     CError tError = new CError(cErrorString.trim());
/*  75 */     this.vErrors.add(tError);
/*  76 */     this.errorCount += 1;
/*     */   }
/*     */ 
/*     */   public void removeLastError()
/*     */   {
/*  82 */     if (this.errorCount > 0)
/*     */     {
/*  84 */       this.vErrors.removeElementAt(this.errorCount - 1);
/*  85 */       this.errorCount -= 1;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void removeError(int pos)
/*     */   {
/*  92 */     if ((this.errorCount > 0) && (pos < this.errorCount))
/*     */     {
/*  94 */       this.vErrors.removeElementAt(pos);
/*  95 */       this.errorCount -= 1;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void clearErrors()
/*     */   {
/* 102 */     this.vErrors.clear();
/* 103 */     this.errorCount = 0;
/*     */   }
/*     */ 
/*     */   public int getErrorCount()
/*     */   {
/* 109 */     return this.errorCount;
/*     */   }
/*     */ 
/*     */   public CError getError(int indexError)
/*     */   {
/* 116 */     CError tError = (CError)this.vErrors.get(indexError);
/*     */ 
/* 118 */     return tError;
/*     */   }
/*     */ 
/*     */   public String getFirstError()
/*     */   {
/*     */     try
/*     */     {
/* 126 */       CError tError = (CError)this.vErrors.get(0);
/*     */ 
/* 129 */       String strMsg = tError.errorMessage;
/*     */ 
/* 131 */       strMsg = strMsg.replace('\n', ' ');
/* 132 */       strMsg = strMsg.replace('"', ' ');
/* 133 */       strMsg = strMsg.replace('\'', ' ');
/*     */ 
/* 135 */       return strMsg;
/*     */     }
/*     */     catch (Exception e) {
/*     */     }
/* 139 */     return "";
/*     */   }
/*     */ 
/*     */   public String getLastError()
/*     */   {
/* 146 */     if (this.errorCount < 1)
/*     */     {
/* 148 */       return "";
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 153 */       CError tError = (CError)this.vErrors.get(this.errorCount - 1);
/*     */ 
/* 156 */       String strMsg = tError.errorMessage;
/*     */ 
/* 158 */       strMsg = strMsg.replace('\n', ' ');
/* 159 */       strMsg = strMsg.replace('"', ' ');
/* 160 */       strMsg = strMsg.replace('\'', ' ');
/*     */ 
/* 162 */       return strMsg;
/*     */     }
/*     */     catch (Exception e) {
/*     */     }
/* 166 */     return "";
/*     */   }
/*     */ 
/*     */   public boolean needDealError()
/*     */   {
/*     */     try
/*     */     {
/* 175 */       if (getErrorCount() > 0)
/*     */       {
/* 177 */         return true;
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 182 */       return false;
/*     */     }
/* 184 */     return false;
/*     */   }
/*     */ 
/*     */   public void copyAllErrors(CErrors cSourceErrors)
/*     */   {
/* 190 */     int i = 0;
/* 191 */     int iMax = 0;
/* 192 */     iMax = cSourceErrors.getErrorCount();
/*     */ 
/* 194 */     for (i = 0; i < iMax; i++)
/*     */     {
/* 196 */       addOneError(cSourceErrors.getError(i));
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getErrType()
/*     */   {
/* 203 */     int forbitNum = 0;
/* 204 */     int needSelectNum = 0;
/* 205 */     int allowNum = 0;
/* 206 */     int unknowNum = 0;
/*     */ 
/* 208 */     for (int i = 0; i < this.vErrors.size(); i++)
/*     */     {
/* 210 */       CError tError = (CError)this.vErrors.get(i);
/*     */ 
/* 212 */       if (tError.errorType.equals("1"))
/*     */       {
/* 214 */         forbitNum++;
/*     */       }
/* 216 */       else if (tError.errorType.equals("3"))
/*     */       {
/* 218 */         needSelectNum++;
/*     */       }
/* 220 */       else if (tError.errorType.equals("2"))
/*     */       {
/* 222 */         allowNum++;
/*     */       }
/*     */       else
/*     */       {
/* 226 */         unknowNum++;
/*     */       }
/*     */     }
/*     */ 
/* 230 */     if (forbitNum > 0)
/*     */     {
/* 232 */       return "1";
/*     */     }
/* 234 */     if (needSelectNum > 0)
/*     */     {
/* 236 */       return "3";
/*     */     }
/* 238 */     if (allowNum > 0)
/*     */     {
/* 240 */       return "2";
/*     */     }
/* 242 */     if (unknowNum > 0)
/*     */     {
/* 244 */       return "4";
/*     */     }
/*     */ 
/* 248 */     return "0";
/*     */   }
/*     */ 
/*     */   public String getErrContent()
/*     */   {
/* 255 */     this.content = ("\uFF08\u4E00\u5171\u53D1\u751F " + this.vErrors.size() + " \u4E2A\u9519\u8BEF\uFF09\n");
/* 256 */     String forbitContent = "";
/* 257 */     String needSelectContent = "";
/* 258 */     String allowContent = "";
/* 259 */     String unknowContent = "";
/*     */ 
/* 261 */     for (int i = 0; i < this.vErrors.size(); i++)
/*     */     {
/* 263 */       CError tError = (CError)this.vErrors.get(i);
/* 264 */       System.out.println("***********" + tError.errorMessage + "----------" + i);
/* 265 */       if (tError.errorType.equals("1"))
/*     */       {
/* 267 */         System.out.println("*****666****" + tError.errorType);
/* 268 */         forbitContent = forbitContent + "  " + "\uFF08\u9519\u8BEF\u7F16\u7801\uFF1A" + 
/* 269 */           tError.errorNo + "\uFF09" + 
/* 270 */           tError.errorMessage + "\n";
/*     */       }
/* 272 */       else if (tError.errorType.equals("3"))
/*     */       {
/* 274 */         needSelectContent = needSelectContent + "  " + "\uFF08\u9519\u8BEF\u7F16\u7801\uFF1A" + 
/* 275 */           tError.errorNo + "\uFF09" + 
/* 276 */           tError.errorMessage + "\n";
/*     */       }
/* 278 */       else if (tError.errorType.equals("2"))
/*     */       {
/* 280 */         allowContent = allowContent + "  " + "\uFF08\u9519\u8BEF\u7F16\u7801\uFF1A" + tError.errorNo + 
/* 281 */           "\uFF09" + 
/* 282 */           tError.errorMessage + "\n";
/*     */       }
/*     */       else
/*     */       {
/* 286 */         unknowContent = unknowContent + "  " + "\uFF08\u9519\u8BEF\u7F16\u7801\uFF1A\u610F\u5916\u9519\u8BEF\uFF09" + 
/* 287 */           tError.errorMessage + "\n";
/*     */       }
/*     */     }
/*     */ 
/* 291 */     if (!forbitContent.equals(""))
/*     */     {
/* 293 */       this.content = (this.content + "\u4E25\u91CD\u9519\u8BEF\u5982\u4E0B:\n" + forbitContent);
/*     */     }
/*     */ 
/* 296 */     if (!needSelectContent.equals(""))
/*     */     {
/* 298 */       this.content = (this.content + "\u9700\u8981\u9009\u62E9\u7684\u9519\u8BEF\u5982\u4E0B:\n" + needSelectContent);
/*     */     }
/*     */ 
/* 301 */     if (!allowContent.equals(""))
/*     */     {
/* 303 */       this.content = (this.content + "\u5141\u8BB8\u51FA\u73B0\u7684\u9519\u8BEF\u5982\u4E0B:\n" + allowContent);
/*     */     }
/*     */ 
/* 306 */     if (!unknowContent.equals(""))
/*     */     {
/* 308 */       this.content = (this.content + "\u610F\u5916\u9519\u8BEF\u5982\u4E0B:\n" + unknowContent);
/*     */     }
/*     */ 
/* 314 */     return this.content;
/*     */   }
/*     */ 
/*     */   public void checkErrors(CErrors cerrors)
/*     */   {
/* 321 */     if (cerrors.getErrType().equals("0"))
/*     */     {
/* 323 */       this.content = "\u64CD\u4F5C\u6210\u529F";
/* 324 */       this.flag = "Success";
/*     */     }
/*     */     else
/*     */     {
/* 328 */       String ErrorContent = cerrors.getErrContent();
/*     */ 
/* 330 */       if (cerrors.getErrType().equals("2"))
/*     */       {
/* 332 */         this.content = ("\u4FDD\u5B58\u6210\u529F\uFF0C\u4F46\u662F\uFF1A" + PubFun.changForHTML(ErrorContent));
/* 333 */         this.flag = "Success";
/*     */       }
/*     */       else
/*     */       {
/* 337 */         this.content = ("\u4FDD\u5B58\u5931\u8D25\uFF0C\u539F\u56E0\u662F\uFF1A" + PubFun.changForHTML(ErrorContent));
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
/* 350 */       this.content = "\u64CD\u4F5C\u6210\u529F";
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
/* 362 */       this.content = ("\u4FDD\u5B58\u6210\u529F\uFF0C\u4F46\u662F\uFF1A" + PubFun.changForHTML((String)v.get(1)));
/* 363 */       this.flag = "Success";
/*     */     }
/*     */     else
/*     */     {
/* 367 */       this.content = ("\u4FDD\u5B58\u5931\u8D25\uFF0C\u539F\u56E0\u662F\uFF1A" + PubFun.changForHTML((String)v.get(1)));
/* 368 */       this.flag = "Fail";
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.utility.CErrors
 * JD-Core Version:    0.6.0
 */