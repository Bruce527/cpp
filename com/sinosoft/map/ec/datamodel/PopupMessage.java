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
/*     */ public class PopupMessage extends BaseConfig
/*     */ {
/*  38 */   private String init = "";
/*     */ 
/*  41 */   private String agentCode = "";
/*  42 */   private String manageCom = "";
/*  43 */   private String branchType = "";
/*  44 */   private List<String[]> messageList = new ArrayList();
/*  45 */   private List<String[]> topmessageList = new ArrayList();
/*  46 */   private String messageNum = "";
/*  47 */   private boolean popmessageNum = false;
/*  48 */   private boolean mainFlag = true;
/*     */ 
/*     */   public String getAgentCode()
/*     */   {
/*  55 */     return this.agentCode;
/*     */   }
/*     */   public void setAgentCode(String agentCode) {
/*  58 */     this.agentCode = agentCode;
/*     */   }
/*     */ 
/*     */   public void setInit(String init)
/*     */   {
/*  69 */     this.init = init;
/*     */ 
/*  71 */     this.agentCode = ECPubFun.getWebVisitor().getUser().getUserCode();
/*  72 */     this.manageCom = ECPubFun.getWebVisitor().getUser().getManageCom();
/*  73 */     this.branchType = ECPubFun.getWebVisitor().getUser().getBranchType();
/*  74 */     initilise();
/*     */   }
/*     */ 
/*     */   public String initilise()
/*     */   {
/*  80 */     this.messageList.clear();
/*     */ 
/*  82 */     String strSQL = " select b.messagename,\tMessageContent,KeyData,MessageContent2,KeyData2,MessageContent3,KeyData3,MessageContent4,KeyData4,MessageContent5, b.script from MprivateMessage a inner join MmessageConfig b on a.messagetype=b.messagetype   where agentcode='" + 
/*  85 */       this.agentCode + "'and a.branchtype='" + this.branchType + "' and b.displaytype='01' and   state='1'   " + 
/*  86 */       " union all " + 
/*  87 */       " select b.messagename," + 
/*  88 */       " MessageContent,KeyData,MessageContent2,KeyData2,MessageContent3,KeyData3,MessageContent4,KeyData4, MessageContent5,b.script" + 
/*  89 */       " from MC2BMessage a inner join MmessageConfig b on a.messagetype=b.messagetype  " + 
/*  90 */       " where a.managecom='" + this.manageCom + "' and a.branchtype='" + this.branchType + "' and b.displaytype='01' and   state='1' " + 
/*  91 */       " union all " + 
/*  92 */       " select mc.messagename,pm.message,'','','','','','','','',mc.script " + 
/*  93 */       " from MPublicMessage pm, Mmessageconfig mc  " + 
/*  94 */       " where 1=1 and mc.messagetype = pm.Type " + 
/*  95 */       " and pm.receiveBranch in ('86','" + this.manageCom + "') " + 
/*  96 */       " and pm.branchtype='" + this.branchType + "' " + 
/*  97 */       " and mc.displaytype='01' " + 
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
/* 165 */       this.agentCode + "'and a.branchtype='" + this.branchType + "' and b.displaytype='01' and   state='1'   " + 
/* 166 */       " union all " + 
/* 167 */       " select b.messagename," + 
/* 168 */       " MessageContent,KeyData,MessageContent2,KeyData2,MessageContent3,KeyData3,MessageContent4,KeyData4, MessageContent5,b.script" + 
/* 169 */       " from MC2BMessage a inner join MmessageConfig b on a.messagetype=b.messagetype  " + 
/* 170 */       " where 1=1 and a.managecom='" + this.manageCom + "' and a.branchtype='" + this.branchType + "' and b.displaytype='01' and   state='1'  " + 
/* 171 */       " union all " + 
/* 173 */       " select mc.messagename,pm.message,'','','','','','','','',mc.script " + 
/* 174 */       " from MPublicMessage pm, Mmessageconfig mc  " + 
/* 175 */       " where 1=1 and mc.messagetype = pm.Type " + 
/* 176 */       " and pm.receiveBranch in ('86','" + this.manageCom + "') " + 
/* 177 */       " and pm.branchtype='" + this.branchType + "' " + 
/* 178 */       " and mc.displaytype='01' " + 
/* 179 */       " and pm.checkstate='2' " + 
/* 180 */       " and pm.state='1' " + 
/* 181 */       " and  pm.startdate<= CONVERT(varchar(24), getdate(), 23) " + 
/* 182 */       " and  CONVERT(varchar(24), getdate(), 23) <=pm.enddate ) as tb";
/*     */ 
/* 185 */     SSRS tSSRS1 = new SSRS();
/* 186 */     ExeSQL tExeSql1 = new ExeSQL();
/* 187 */     tSSRS1 = tExeSql1.execSQL(strSQL);
/*     */ 
/* 190 */     if ((tSSRS1 == null) || (tSSRS1.getMaxRow() < 1))
/*     */     {
/* 193 */       return this.topmessageList;
/*     */     }
/*     */ 
/* 198 */     this.mainFlag = true;
/* 199 */     this.messageNum = tSSRS1.MaxRow;
/* 200 */     for (int i = 1; i <= tSSRS1.MaxRow; i++)
/*     */     {
/* 202 */       String[] resultInfo = new String[tSSRS1.MaxCol];
/* 203 */       for (int j = 1; j <= tSSRS1.MaxCol; j++)
/*     */       {
/* 205 */         resultInfo[(j - 1)] = tSSRS1.GetText(i, j);
/*     */       }
/* 207 */       this.topmessageList.add(resultInfo);
/*     */     }
/*     */ 
/* 211 */     return this.topmessageList;
/*     */   }
/*     */ 
/*     */   public void setTopmessageList(List<String[]> topmessageList) {
/* 215 */     this.topmessageList = topmessageList;
/*     */   }
/*     */   public boolean isMainFlag() {
/* 218 */     return this.mainFlag;
/*     */   }
/*     */   public void setMainFlag(boolean mainFlag) {
/* 221 */     this.mainFlag = mainFlag;
/*     */   }
/*     */   public void changeFlag() {
/* 224 */     ECPubFun.getWebVisitor().getUser().setPopupFlag(false);
/* 225 */     this.mainFlag = false;
/*     */   }
/*     */   public boolean isPopmessageNum() {
/* 228 */     this.agentCode = ECPubFun.getWebVisitor().getUser().getUserCode();
/* 229 */     this.manageCom = ECPubFun.getWebVisitor().getUser().getManageCom();
/* 230 */     this.branchType = ECPubFun.getWebVisitor().getUser().getBranchType();
/*     */ 
/* 232 */     String strSQL = " select top 5 * from ( select b.messagename,\tMessageContent,KeyData,MessageContent2,KeyData2,MessageContent3,KeyData3,MessageContent4,KeyData4,MessageContent5, b.script from MprivateMessage a inner join MmessageConfig b on a.messagetype=b.messagetype   where agentcode='" + 
/* 235 */       this.agentCode + "'and a.branchtype='" + this.branchType + "' and b.displaytype='01' and   state='1'    " + 
/* 236 */       " union all " + 
/* 237 */       " select b.messagename," + 
/* 238 */       " MessageContent,KeyData,MessageContent2,KeyData2,MessageContent3,KeyData3,MessageContent4,KeyData4, MessageContent5,b.script" + 
/* 239 */       " from MC2BMessage a inner join MmessageConfig b on a.messagetype=b.messagetype  " + 
/* 240 */       " where a.managecom='" + this.manageCom + "' and a.branchtype='1' and b.displaytype='01' and   state='1' " + 
/* 241 */       " union all " + 
/* 242 */       " select mc.messagename,pm.message,'','','','','','','','',mc.script " + 
/* 243 */       " from MPublicMessage pm, Mmessageconfig mc  " + 
/* 244 */       " where 1=1 and mc.messagetype = pm.Type " + 
/* 245 */       " and pm.receiveBranch in ('86','" + this.manageCom + "') " + 
/* 246 */       " and pm.branchtype='1' " + 
/* 247 */       " and mc.displaytype='01' " + 
/* 248 */       " and pm.checkstate='2' " + 
/* 249 */       " and pm.state='1' " + 
/* 250 */       " and  pm.startdate<= CONVERT(varchar(24), getdate(), 23) " + 
/* 251 */       " and  CONVERT(varchar(24), getdate(), 23) <=pm.enddate ) as tb";
/*     */ 
/* 253 */     SSRS tSSRS1 = new SSRS();
/* 254 */     ExeSQL tExeSql1 = new ExeSQL();
/* 255 */     tSSRS1 = tExeSql1.execSQL(strSQL);
/*     */ 
/* 261 */     return (tSSRS1 != null) && (tSSRS1.getMaxRow() > 0);
/*     */   }
/*     */ 
/*     */   public void setPopmessageNum(boolean popmessageNum)
/*     */   {
/* 266 */     this.popmessageNum = popmessageNum;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.map.ec.datamodel.PopupMessage
 * JD-Core Version:    0.6.0
 */