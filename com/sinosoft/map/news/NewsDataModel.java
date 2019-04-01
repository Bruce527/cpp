/*     */ package com.sinosoft.map.news;
/*     */ 
/*     */ import com.sinosoft.map.common.WebVisitor;
/*     */ import com.sinosoft.map.common.config.BaseConfig;
/*     */ import com.sinosoft.map.common.validators.ValidatorConfig;
/*     */ import com.sinosoft.map.ec.utility.ECPubFun;
/*     */ import com.sinosoft.map.lis.db.MNewsDB;
/*     */ import com.sinosoft.map.lis.pubfun.FDate;
/*     */ import com.sinosoft.map.lis.pubfun.PubFun;
/*     */ import com.sinosoft.map.lis.schema.MNewsSchema;
/*     */ import com.sinosoft.map.lis.vschema.MNewsSet;
/*     */ import com.sinosoft.map.user.UserModel;
/*     */ import com.sinosoft.map.utility.ExeSQL;
/*     */ import com.sinosoft.map.utility.SSRS;
/*     */ import java.io.PrintStream;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ public class NewsDataModel extends BaseConfig
/*     */ {
/*     */   private List<NewsDataModelSchema> newsList;
/*     */   private List<NewsDataModelSchema> newsNewList;
/*     */   private List<NewsDataModelSchema> newsHotList;
/*     */   private List<NewsDataModelSchema> newsCompanyList;
/*     */   private List<NewsDataModelSchema> newsBranchList;
/*     */   private List<NewsDataModelSchema> newsSearchList;
/*     */   private List<NewsDataModelSchema> newsHomeCompanyList;
/*     */   private List<NewsDataModelSchema> newsHomeBranchList;
/*  54 */   private int pagesize = 20;
/*  55 */   private int pagecount = 0;
/*  56 */   private int recordcount = 0;
/*     */ 
/*  58 */   String initList = "";
/*  59 */   String queryTitle = "";
/*  60 */   private String newsPageId = "";
/*  61 */   String pageURL = "";
/*     */ 
/*  63 */   private String ListInfo = "";
/*  64 */   private String operateResult = "";
/*  65 */   private String controlType = "";
/*     */ 
/*  67 */   private String moreType = "";
/*     */ 
/*  69 */   private ValidatorConfig vc = new ValidatorConfig();
/*  70 */   private String init = "";
/*  71 */   private String currentUserCode = "";
/*     */ 
/*  73 */   private FDate tFData = new FDate();
/*  74 */   private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
/*  75 */   private String SQL = "";
/*     */ 
/*     */   public String getNewsPageId()
/*     */   {
/*  80 */     return this.newsPageId;
/*     */   }
/*     */ 
/*     */   public void setNewsPageId(String newsPageId)
/*     */   {
/*  85 */     this.newsPageId = newsPageId;
/*  86 */     addNewsClick(newsPageId);
/*     */   }
/*     */ 
/*     */   public void addNewsClick(String newsPageId)
/*     */   {
/*     */   }
/*     */ 
/*     */   private String getSql(String type)
/*     */   {
/* 100 */     WebVisitor tWebVisitor = new WebVisitor();
/* 101 */     tWebVisitor = ECPubFun.getWebVisitor();
/*     */ 
/* 103 */     UserModel user = tWebVisitor.getUser();
/*     */ 
/* 105 */     String curDate = PubFun.getCurrentDate();
/* 106 */     String curTime = PubFun.getCurrentTime();
/*     */ 
/* 108 */     StringBuffer strSQL = new StringBuffer();
/*     */ 
/* 111 */     if ((type.equals("search")) || (type.equals("moreNew")) || (type.equals("moreHot")) || (type.equals("moreCompany")) || (type.equals("moreBranch")))
/*     */     {
/* 113 */       strSQL.append(" select top 400 * from MNews m ");
/*     */     }
/*     */     else
/*     */     {
/* 117 */       strSQL.append(" select top 10 * from MNews m ");
/*     */     }
/*     */ 
/* 120 */     strSQL.append(" where 1=1 ");
/*     */ 
/* 122 */     if ((type.equals("company")) || (type.equals("moreCompany")))
/*     */     {
/* 124 */       strSQL.append(" and m.managecom in ('86') ");
/*     */     }
/* 126 */     else if ((type.equals("branch")) || (type.equals("moreBranch")))
/*     */     {
/* 128 */       if ((user.getManageCom() != null) && (user.getManageCom().equals("86")))
/*     */       {
/* 130 */         strSQL.append(" and m.managecom <> '86' ");
/*     */       }
/*     */       else
/*     */       {
/* 134 */         strSQL.append(" and m.managecom in ('" + user.getManageCom() + "') and m.managecom <> '86' ");
/*     */       }
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 140 */       strSQL.append(" and m.managecom in ('86','" + user.getManageCom() + "') ");
/*     */     }
/*     */ 
/* 144 */     strSQL.append(" and m.Branchtype = '" + user.getBranchType() + "' ");
/* 145 */     strSQL.append(" and (m.MinDisplayGrade <= '" + user.getAgentGrade() + "' or m.mindisplaygrade is null) ");
/*     */ 
/* 147 */     strSQL.append(" and m.CheckState = '2' ");
/*     */ 
/* 149 */     strSQL.append(" and ((m.StartDisplayDate < '" + curDate + "' or m.StartDisplayDate is null) or (m.StartDisplayDate = '" + curDate + "' and m.StartDisplayTime <= '" + curTime + "' ))");
/* 150 */     strSQL.append(" and ((m.EndDisplayDate > '" + curDate + "' or m.EndDisplayDate is null) or (m.EndDisplayDate = '" + curDate + "' and m.EndDisplayTime >= '" + curTime + "' ))");
/*     */ 
/* 152 */     if (type.equals("search"))
/*     */     {
/* 154 */       strSQL.append(" and m.title like '%" + this.queryTitle + "%'");
/*     */     }
/*     */ 
/* 158 */     if ((type.equals("hot")) || (type.equals("moreHot")))
/*     */     {
/* 160 */       strSQL.append(" order by m.FixedTop desc, m.ClickRate desc, m.makedate desc, m.maketime desc");
/*     */     }
/*     */     else
/*     */     {
/* 164 */       strSQL.append(" order by m.FixedTop desc, m.makedate desc, m.maketime desc ");
/*     */     }
/*     */ 
/* 169 */     return strSQL.toString();
/*     */   }
/*     */ 
/*     */   public void search()
/*     */   {
/* 175 */     System.out.println("search======================================");
/*     */     try
/*     */     {
/* 178 */       this.moreType = "\u93C2\u4F34\u6908\u93BC\u6EC5\u50A8\u7F01\u64B4\u7049:";
/* 179 */       this.newsSearchList = getNewsList("search");
/*     */ 
/* 181 */       if ((this.newsSearchList != null) && (this.newsSearchList.size() != 0))
/*     */       {
/* 183 */         this.operateResult = "News_Control_SearchSucc";
/* 184 */         this.operateResult = ("Succ|" + ECPubFun.getDisplayString(this.vc.getBundle(), this.operateResult, null));
/*     */       }
/*     */       else
/*     */       {
/* 189 */         this.operateResult = "Succ|resultisnull";
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 197 */       this.moreType = "\u93C2\u4F34\u6908\u93BC\u6EC5\u50A8\u7F01\u64B4\u7049:";
/* 198 */       this.operateResult = "News_Control_SearchFail";
/* 199 */       this.operateResult = ("Fail|" + ECPubFun.getDisplayString(this.vc.getBundle(), this.operateResult, null));
/*     */     }
/*     */   }
/*     */ 
/*     */   public void searchMoreNew()
/*     */   {
/* 211 */     System.out.println("searchMoreNew======================================");
/*     */     try
/*     */     {
/* 214 */       this.moreType = "\u93C8\uFFFD\u93C2\u7248\u67CA\u95C2\uFFFD:";
/* 215 */       this.newsSearchList = getNewsList("moreNew");
/*     */ 
/* 217 */       if ((this.newsSearchList != null) && (this.newsSearchList.size() != 0))
/*     */       {
/* 219 */         this.operateResult = "News_Control_SearchSucc";
/* 220 */         this.operateResult = ("Succ|" + ECPubFun.getDisplayString(this.vc.getBundle(), this.operateResult, null));
/*     */       }
/*     */       else
/*     */       {
/* 225 */         this.operateResult = "Succ|resultisnull";
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 231 */       this.moreType = "\u93C8\uFFFD\u93C2\u7248\u67CA\u95C2\uFFFD:";
/* 232 */       this.operateResult = "News_Control_SearchFail";
/* 233 */       this.operateResult = ("Fail|" + ECPubFun.getDisplayString(this.vc.getBundle(), this.operateResult, null));
/*     */     }
/*     */   }
/*     */ 
/*     */   public void searchMoreHot()
/*     */   {
/* 242 */     System.out.println("searchMoreHot======================================");
/*     */     try
/*     */     {
/* 245 */       this.moreType = "\u9411\uE162\u68EC\u93BA\u6395\uE511:";
/* 246 */       this.newsSearchList = getNewsList("moreHot");
/*     */ 
/* 248 */       if ((this.newsSearchList != null) && (this.newsSearchList.size() != 0))
/*     */       {
/* 250 */         this.operateResult = "News_Control_SearchSucc";
/* 251 */         this.operateResult = ("Succ|" + ECPubFun.getDisplayString(this.vc.getBundle(), this.operateResult, null));
/*     */       }
/*     */       else
/*     */       {
/* 256 */         this.operateResult = "Succ|resultisnull";
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 262 */       this.moreType = "\u9411\uE162\u68EC\u93BA\u6395\uE511:";
/* 263 */       this.operateResult = "News_Control_SearchFail";
/* 264 */       this.operateResult = ("Fail|" + ECPubFun.getDisplayString(this.vc.getBundle(), this.operateResult, null));
/*     */     }
/*     */   }
/*     */ 
/*     */   public void searchMoreCompany()
/*     */   {
/* 272 */     System.out.println("searchMoreCompany======================================");
/*     */     try
/*     */     {
/* 275 */       this.moreType = "\u93AC\u8BF2\u53D5\u9359\u544A\u67CA\u95C2\uFFFD:";
/* 276 */       this.newsSearchList = getNewsList("moreCompany");
/*     */ 
/* 278 */       if ((this.newsSearchList != null) && (this.newsSearchList.size() != 0))
/*     */       {
/* 280 */         this.operateResult = "News_Control_SearchSucc";
/* 281 */         this.operateResult = ("Succ|" + ECPubFun.getDisplayString(this.vc.getBundle(), this.operateResult, null));
/*     */       }
/*     */       else
/*     */       {
/* 286 */         this.operateResult = "Succ|resultisnull";
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 292 */       this.moreType = "\u93AC\u8BF2\u53D5\u9359\u544A\u67CA\u95C2\uFFFD:";
/* 293 */       this.operateResult = "News_Control_SearchFail";
/* 294 */       this.operateResult = ("Fail|" + ECPubFun.getDisplayString(this.vc.getBundle(), this.operateResult, null));
/*     */     }
/*     */   }
/*     */ 
/*     */   public void searchMoreBranch()
/*     */   {
/* 302 */     System.out.println("searchMoreBranch======================================");
/*     */     try
/*     */     {
/* 305 */       this.moreType = "\u9352\u55D7\u53D5\u9359\u544A\u67CA\u95C2\uFFFD:";
/* 306 */       this.newsSearchList = getNewsList("moreBranch");
/*     */ 
/* 308 */       if ((this.newsSearchList != null) && (this.newsSearchList.size() != 0))
/*     */       {
/* 310 */         this.operateResult = "News_Control_SearchSucc";
/* 311 */         this.operateResult = ("Succ|" + ECPubFun.getDisplayString(this.vc.getBundle(), this.operateResult, null));
/*     */       }
/*     */       else
/*     */       {
/* 316 */         this.operateResult = "Succ|resultisnull";
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 322 */       this.moreType = "\u9352\u55D7\u53D5\u9359\u544A\u67CA\u95C2\uFFFD:";
/* 323 */       this.operateResult = "News_Control_SearchFail";
/* 324 */       this.operateResult = ("Fail|" + ECPubFun.getDisplayString(this.vc.getBundle(), this.operateResult, null));
/*     */     }
/*     */   }
/*     */ 
/*     */   private void refreshFields()
/*     */   {
/* 331 */     this.controlType = "";
/* 332 */     this.operateResult = "";
/* 333 */     this.currentUserCode = "";
/*     */   }
/*     */ 
/*     */   public List<NewsDataModelSchema> getNewsNewList()
/*     */   {
/* 339 */     return this.newsNewList;
/*     */   }
/*     */ 
/*     */   public int getPagesize()
/*     */   {
/* 344 */     return this.pagesize;
/*     */   }
/*     */ 
/*     */   public void setPagesize(int pagesize)
/*     */   {
/* 349 */     this.pagesize = pagesize;
/*     */   }
/*     */ 
/*     */   public int getPagecount()
/*     */   {
/* 354 */     return this.pagecount;
/*     */   }
/*     */ 
/*     */   public void setPagecount(int pagecount)
/*     */   {
/* 359 */     this.pagecount = pagecount;
/*     */   }
/*     */ 
/*     */   public String getOperateResult()
/*     */   {
/* 364 */     return this.operateResult;
/*     */   }
/*     */ 
/*     */   public String getControlType()
/*     */   {
/* 369 */     return this.controlType;
/*     */   }
/*     */ 
/*     */   public void setControlType(String controlType)
/*     */   {
/* 374 */     this.controlType = controlType;
/*     */   }
/*     */ 
/*     */   private void transFields(NewsDataModelSchema a, MNewsSchema t)
/*     */   {
/* 379 */     a.setNewsID(t.getNewsID());
/* 380 */     a.setTitle(t.getTitle());
/* 381 */     a.setAuthor(t.getAuthor());
/* 382 */     a.setMakeDate(t.getMakeDate());
/* 383 */     a.setNewsType(t.getNewsType());
/* 384 */     a.setStaticPageURL(t.getStaticPageURL());
/* 385 */     a.setClickRate(t.getClickRate());
/* 386 */     a.setFixedTop(t.getFixedTop());
/*     */   }
/*     */ 
/*     */   public String getInit()
/*     */   {
/* 392 */     return this.init;
/*     */   }
/*     */ 
/*     */   public void setInit(String init)
/*     */   {
/* 399 */     this.init = init;
/*     */   }
/*     */ 
/*     */   public List<NewsDataModelSchema> getNewsHotList()
/*     */   {
/* 405 */     return this.newsHotList;
/*     */   }
/*     */ 
/*     */   public void setNewsHotList(List<NewsDataModelSchema> newsHotList) {
/* 409 */     this.newsHotList = newsHotList;
/*     */   }
/*     */ 
/*     */   public List<NewsDataModelSchema> getNewsCompanyList()
/*     */   {
/* 415 */     return this.newsCompanyList;
/*     */   }
/*     */ 
/*     */   public void setNewsCompanyList(List<NewsDataModelSchema> newsCompanyList) {
/* 419 */     this.newsCompanyList = newsCompanyList;
/*     */   }
/*     */ 
/*     */   public List<NewsDataModelSchema> getNewsBranchList()
/*     */   {
/* 425 */     return this.newsBranchList;
/*     */   }
/*     */ 
/*     */   public void setNewsBranchList(List<NewsDataModelSchema> newsBranchList) {
/* 429 */     this.newsBranchList = newsBranchList;
/*     */   }
/*     */ 
/*     */   public List<NewsDataModelSchema> getNewsSearchList() {
/* 433 */     return this.newsSearchList;
/*     */   }
/*     */ 
/*     */   public void setNewsSearchList(List<NewsDataModelSchema> newsSearchList) {
/* 437 */     this.newsSearchList = newsSearchList;
/*     */   }
/*     */ 
/*     */   public List<NewsDataModelSchema> getNewsHomeCompanyList()
/*     */   {
/* 443 */     return this.newsHomeCompanyList;
/*     */   }
/*     */ 
/*     */   public void setNewsHomeCompanyList(List<NewsDataModelSchema> newsHomeCompanyList) {
/* 447 */     this.newsHomeCompanyList = newsHomeCompanyList;
/*     */   }
/*     */ 
/*     */   public List<NewsDataModelSchema> getNewsHomeBranchList() {
/* 451 */     return this.newsHomeBranchList;
/*     */   }
/*     */ 
/*     */   public void setNewsHomeBranchList(List<NewsDataModelSchema> newsHomeBranchList) {
/* 455 */     this.newsHomeBranchList = newsHomeBranchList;
/*     */   }
/*     */ 
/*     */   public String getQueryTitle() {
/* 459 */     return this.queryTitle;
/*     */   }
/*     */ 
/*     */   public void setQueryTitle(String queryTitle) {
/* 463 */     this.queryTitle = queryTitle;
/*     */   }
/*     */ 
/*     */   public List<NewsDataModelSchema> getNewsList(String type)
/*     */   {
/* 469 */     this.newsList = new ArrayList();
/* 470 */     String curDate = PubFun.getCurrentDate();
/* 471 */     MNewsDB dao = new MNewsDB();
/* 472 */     String sql = "";
/*     */ 
/* 474 */     String sqlSysDateNum = "select varvalue from msysvar where vartype='newsnewday'";
/* 475 */     ExeSQL tExeSQL = new ExeSQL();
/* 476 */     SSRS tSSRS = tExeSQL.execSQL(sqlSysDateNum);
/*     */ 
/* 478 */     int sysDateNum = Integer.parseInt(tSSRS.GetText(1, 1));
/*     */ 
/* 481 */     String sqlHotNum = "select varvalue from msysvar where vartype='newshotnum'";
/*     */ 
/* 483 */     tSSRS = tExeSQL.execSQL(sqlHotNum);
/* 484 */     int newsHotNum = Integer.parseInt(tSSRS.GetText(1, 1));
/*     */ 
/* 487 */     sql = getSql(type);
/*     */ 
/* 489 */     System.out.println(sql);
/* 490 */     MNewsSet tMNewsSet = dao.executeQuery(sql);
/*     */ 
/* 493 */     if ((tMNewsSet != null) && (tMNewsSet.size() > 0))
/*     */     {
/* 495 */       for (int iLoop = 1; iLoop <= tMNewsSet.size(); iLoop++)
/*     */       {
/* 498 */         int titleSize = 32;
/*     */ 
/* 500 */         MNewsSchema t = tMNewsSet.get(iLoop);
/* 501 */         NewsDataModelSchema a = new NewsDataModelSchema();
/* 502 */         transFields(a, t);
/* 503 */         if ((a.getNewsType() != null) && (a.getNewsType().equals("02")))
/*     */         {
/* 505 */           a.setNewsTypeSign("(\u9365\uFFFD)");
/* 506 */           titleSize -= 4;
/*     */         }
/*     */ 
/* 509 */         if (a.getFixedTop() == 1)
/*     */         {
/* 511 */           a.setNewsTopSign("(\u95B2\u5D88\uE6E6)");
/* 512 */           titleSize -= 6;
/*     */         }
/*     */ 
/* 515 */         int dateNum = PubFun.calInterval2(a.getMakeDate(), curDate, "D");
/* 516 */         if (dateNum < sysDateNum)
/*     */         {
/* 518 */           a.setNewPic("../images/main/new.gif");
/* 519 */           titleSize -= 4;
/*     */         }
/*     */         else
/*     */         {
/* 523 */           a.setNewPic("../images/main/space.gif");
/*     */         }
/* 525 */         if ((a.getClickRate() != 0) && (iLoop <= newsHotNum))
/*     */         {
/* 527 */           a.setHotPic("../images/main/hot.gif");
/* 528 */           titleSize -= 4;
/*     */         }
/*     */         else
/*     */         {
/* 532 */           a.setHotPic("../images/main/space.gif");
/*     */         }
/*     */ 
/* 535 */         if ((type.equals("search")) || (type.equals("moreNew")) || (type.equals("moreHot")) || (type.equals("moreCompany")) || (type.equals("moreBranch")))
/*     */         {
/* 537 */           if ((a.getTitle() != null) && (a.getTitle().length() > 30))
/*     */           {
/* 539 */             a.setNewsShortTitle(a.getTitle().substring(0, 30) + "...");
/*     */           }
/*     */           else
/*     */           {
/* 543 */             a.setNewsShortTitle(a.getTitle());
/*     */           }
/*     */ 
/*     */         }
/* 548 */         else if ((a.getTitle() != null) && (a.getTitle().length() > titleSize / 2))
/*     */         {
/* 550 */           a.setNewsShortTitle(a.getTitle().substring(0, titleSize / 2) + "...");
/*     */         }
/*     */         else
/*     */         {
/* 554 */           a.setNewsShortTitle(a.getTitle());
/*     */         }
/*     */ 
/* 559 */         this.newsList.add(a);
/*     */       }
/*     */ 
/* 562 */       this.recordcount = this.newsList.size();
/*     */     }
/*     */ 
/* 566 */     return this.newsList;
/*     */   }
/*     */ 
/*     */   public void setNewsList(List<NewsDataModelSchema> newsList) {
/* 570 */     this.newsList = newsList;
/*     */   }
/*     */ 
/*     */   public String getMoreType() {
/* 574 */     return this.moreType;
/*     */   }
/*     */ 
/*     */   public void setMoreType(String moreType) {
/* 578 */     this.moreType = moreType;
/*     */   }
/*     */ 
/*     */   public String getInitList() {
/* 582 */     return this.initList;
/*     */   }
/*     */ 
/*     */   public void setInitList(String initList)
/*     */   {
/* 587 */     this.newsNewList = getNewsList("new");
/* 588 */     this.newsHotList = getNewsList("hot");
/* 589 */     this.newsCompanyList = getNewsList("company");
/* 590 */     this.newsBranchList = getNewsList("branch");
/* 591 */     this.initList = initList;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.news.NewsDataModel
 * JD-Core Version:    0.6.0
 */