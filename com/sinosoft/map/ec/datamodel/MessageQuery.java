/*     */ package com.sinosoft.map.ec.datamodel;
/*     */ 
/*     */ import com.sinosoft.map.common.WebVisitor;
/*     */ import com.sinosoft.map.common.config.BaseConfig;
/*     */ import com.sinosoft.map.ec.utility.ECPubFun;
/*     */ import com.sinosoft.map.user.UserModel;
/*     */ import com.sinosoft.map.utility.ExeSQL;
/*     */ import com.sinosoft.map.utility.SSRS;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ public class MessageQuery extends BaseConfig
/*     */ {
/*  38 */   private String init = "";
/*     */ 
/*  41 */   private String agentCode = "";
/*  42 */   private String manageCom = "";
/*  43 */   private String branchType = "";
/*  44 */   private List<String[]> messageList = new ArrayList();
/*  45 */   private List<String[]> topmessageList = new ArrayList();
/*  46 */   private String messageNum = "";
/*     */ 
/*     */   public String getAgentCode()
/*     */   {
/*  53 */     return this.agentCode;
/*     */   }
/*     */   public void setAgentCode(String agentCode) {
/*  56 */     this.agentCode = agentCode;
/*     */   }
/*     */ 
/*     */   public void setInit(String init)
/*     */   {
/*  67 */     this.init = init;
/*     */ 
/*  69 */     this.agentCode = ECPubFun.getWebVisitor().getUser().getUserCode();
/*  70 */     this.manageCom = ECPubFun.getWebVisitor().getUser().getManageCom();
/*  71 */     this.branchType = ECPubFun.getWebVisitor().getUser().getBranchType();
/*  72 */     search();
/*     */   }
/*     */ 
/*     */   public String search()
/*     */   {
/*  78 */     this.messageList.clear();
/*     */ 
/*  82 */     String strSQL = " select b.messagename,\tMessageContent,KeyData,MessageContent2,KeyData2,MessageContent3,KeyData3,MessageContent4,KeyData4,MessageContent5, b.script from MprivateMessage a inner join MmessageConfig b on a.messagetype=b.messagetype   where agentcode='" + 
/*  85 */       this.agentCode + "'and a.branchtype='" + this.branchType + "' and b.displaytype='02' and   state='1' " + 
/*  86 */       " union all " + 
/*  87 */       " select b.messagename," + 
/*  88 */       " MessageContent,KeyData,MessageContent2,KeyData2,MessageContent3,KeyData3,MessageContent4,KeyData4, MessageContent5,b.script" + 
/*  89 */       " from MC2BMessage a inner join MmessageConfig b on a.messagetype=b.messagetype  " + 
/*  90 */       " where a.managecom='" + this.manageCom + "' and a.branchtype='" + this.branchType + "' and b.displaytype='02' and   state='1' " + 
/*  91 */       " union all " + 
/*  92 */       " select mc.messagename,pm.message,'','','','','','','','',mc.script " + 
/*  93 */       " from MPublicMessage pm, Mmessageconfig mc  " + 
/*  94 */       " where 1=1 and mc.messagetype = pm.Type " + 
/*  95 */       " and pm.receiveBranch in ('86','" + this.manageCom + "') " + 
/*  96 */       " and pm.branchtype='" + this.branchType + "' " + 
/*  97 */       " and mc.displaytype='02' " + 
/*  98 */       " and pm.checkstate='2' " + 
/*  99 */       " and pm.state='1' " + 
/* 100 */       " and pm.startdate<= CONVERT(varchar(24), getdate(), 23) " + 
/* 101 */       " and CONVERT(varchar(24), getdate(), 23) <=pm.enddate ";
/*     */ 
/* 103 */     SSRS tSSRS1 = new SSRS();
/* 104 */     ExeSQL tExeSql1 = new ExeSQL();
/* 105 */     tSSRS1 = tExeSql1.execSQL(strSQL);
/*     */ 
/* 108 */     if ((tSSRS1 == null) || (tSSRS1.getMaxRow() < 1))
/*     */     {
/* 110 */       ECPubFun.addInfoMessage(getBundle(), "\u65E0\u7ED3\u679C\u6216\u67E5\u8BE2\u5931\u8D25\uFF01");
/* 111 */       return "failure";
/*     */     }
/*     */ 
/* 116 */     this.messageNum = tSSRS1.MaxRow;
/* 117 */     for (int i = 1; i <= tSSRS1.MaxRow; i++)
/*     */     {
/* 119 */       String[] resultInfo = new String[tSSRS1.MaxCol];
/* 120 */       for (int j = 1; j <= tSSRS1.MaxCol; j++)
/*     */       {
/* 122 */         resultInfo[(j - 1)] = tSSRS1.GetText(i, j);
/*     */       }
/* 124 */       this.messageList.add(resultInfo);
/*     */     }
/*     */ 
/* 131 */     return "success";
/*     */   }
/*     */ 
/*     */   public String getInit()
/*     */   {
/* 138 */     return this.init;
/*     */   }
/*     */ 
/*     */   public List<String[]> getMessageList()
/*     */   {
/* 144 */     return this.messageList;
/*     */   }
/*     */   public void setMessageList(List<String[]> messageList) {
/* 147 */     this.messageList = messageList;
/*     */   }
/*     */   public String getMessageNum() {
/* 150 */     return this.messageNum;
/*     */   }
/*     */   public void setMessageNum(String messageNum) {
/* 153 */     this.messageNum = messageNum;
/*     */   }
/*     */   public List<String[]> getTopmessageList() {
/* 156 */     this.agentCode = ECPubFun.getWebVisitor().getUser().getUserCode();
/* 157 */     this.manageCom = ECPubFun.getWebVisitor().getUser().getManageCom();
/* 158 */     this.branchType = ECPubFun.getWebVisitor().getUser().getBranchType();
/* 159 */     this.topmessageList.clear();
/*     */ 
/* 162 */     String strSQL = " select top 5 * from ( select b.messagename,\tMessageContent,KeyData,MessageContent2,KeyData2,MessageContent3,KeyData3,MessageContent4,KeyData4,MessageContent5, b.script from MprivateMessage a inner join MmessageConfig b on a.messagetype=b.messagetype   where agentcode='" + 
/* 165 */       this.agentCode + "'and a.branchtype='" + this.branchType + "' and b.displaytype='02' and   state='1'   " + 
/* 166 */       " union all " + 
/* 167 */       " select b.messagename," + 
/* 168 */       " MessageContent,KeyData,MessageContent2,KeyData2,MessageContent3,KeyData3,MessageContent4,KeyData4, MessageContent5,b.script" + 
/* 169 */       " from MC2BMessage a inner join MmessageConfig b on a.messagetype=b.messagetype  " + 
/* 170 */       " where 1=1 and a.managecom='" + this.manageCom + "' and a.branchtype='" + this.branchType + "' and b.displaytype='02' and   state='1'  " + 
/* 171 */       " union all " + 
/* 173 */       " select mc.messagename,pm.message,'','','','','','','','',mc.script " + 
/* 174 */       " from MPublicMessage pm, Mmessageconfig mc  " + 
/* 175 */       " where 1=1 and mc.messagetype = pm.Type " + 
/* 176 */       " and pm.receiveBranch in ('86','" + this.manageCom + "') " + 
/* 177 */       " and pm.branchtype='" + this.branchType + "' " + 
/* 178 */       " and mc.displaytype='02' " + 
/* 179 */       " and pm.checkstate='2' " + 
/* 180 */       " and pm.state='1' " + 
/* 181 */       " and  pm.startdate<= CONVERT(varchar(24), getdate(), 23) " + 
/* 182 */       " and  CONVERT(varchar(24), getdate(), 23) <=pm.enddate ) as tb";
/*     */ 
/* 184 */     SSRS tSSRS1 = new SSRS();
/* 185 */     ExeSQL tExeSql1 = new ExeSQL();
/* 186 */     tSSRS1 = tExeSql1.execSQL(strSQL);
/*     */ 
/* 189 */     if ((tSSRS1 == null) || (tSSRS1.getMaxRow() < 1))
/*     */     {
/* 192 */       return this.topmessageList;
/*     */     }
/*     */ 
/* 197 */     this.messageNum = tSSRS1.MaxRow;
/* 198 */     for (int i = 1; i <= tSSRS1.MaxRow; i++)
/*     */     {
/* 200 */       String[] resultInfo = new String[tSSRS1.MaxCol];
/* 201 */       for (int j = 1; j <= tSSRS1.MaxCol; j++)
/*     */       {
/* 203 */         resultInfo[(j - 1)] = tSSRS1.GetText(i, j);
/*     */       }
/* 205 */       this.topmessageList.add(resultInfo);
/*     */     }
/*     */ 
/* 209 */     return this.topmessageList;
/*     */   }
/*     */   public void setTopmessageList(List<String[]> topmessageList) {
/* 212 */     this.topmessageList = topmessageList;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.ec.datamodel.MessageQuery
 * JD-Core Version:    0.6.0
 */