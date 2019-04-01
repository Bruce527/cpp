/*     */ package com.sinosoft.banklns.lis.tree;
/*     */ 
/*     */ import com.sinosoft.banklns.utility.ExeSQL;
/*     */ import com.sinosoft.banklns.utility.SSRS;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import javax.faces.context.ExternalContext;
/*     */ import javax.faces.context.FacesContext;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.richfaces.component.html.HtmlTree;
/*     */ import org.richfaces.event.NodeSelectedEvent;
/*     */ import org.richfaces.model.TreeNode;
/*     */ import org.richfaces.model.TreeNodeImpl;
/*     */ 
/*     */ public class OccupTreeBean
/*     */ {
/*     */   TreeNode1 root;
/*  32 */   String sql = "select OCCUPATIONCODE,OCCUPATIONNAME,LifeRate,HiRate,PaRate,WpRate,RELACODE from lnpoccupation";
/*  33 */   String eSql = "select OCCUPATIONCODE,OCCUPATIONNAME,LifeRate,HiRate,PaRate,WpRate,RELACODE from lnpoccupation";
/*  34 */   String tempOrderSql = " order by OCCUPATIONCODE asc";
/*  35 */   int level = 1;
/*     */   ArrayList currentList;
/*     */   ArrayList resultList;
/*  39 */   private TreeNode rootNode = null;
/*  40 */   private List<OccupBean> selectedNodeChildren = new ArrayList();
/*     */ 
/*  42 */   private int index = 0;
/*     */   private OccupBean OccupBean;
/*     */   private String occName;
/*     */   private boolean checkBox;
/*     */   private String message;
/*  48 */   private boolean flag = false;
/*  49 */   private boolean searchFlag = false;
/*     */   private String str;
/*     */ 
/*     */   public TreeNode1 getTreeData()
/*     */   {
/*  54 */     this.root = new TreeNode1();
/*  55 */     this.currentList = new ArrayList();
/*     */ 
/*  58 */     TreeNode1 currentParent = new TreeNode1();
/*     */ 
/*  60 */     currentParent = this.root;
/*     */ 
/*  63 */     ExeSQL exeSql = new ExeSQL();
/*     */ 
/*  65 */     this.eSql += " where RELACODE is null or RELACODE = ''";
/*  66 */     SSRS ssrs = exeSql.execSQL(this.eSql + this.tempOrderSql);
/*  67 */     if ((ssrs == null) || (ssrs.getMaxRow() == 0))
/*  68 */       return null;
/*  69 */     for (int i = 1; i <= ssrs.getMaxRow(); i++) {
/*  70 */       OccupBean occupBean = new OccupBean();
/*  71 */       TreeNode1 tempNode = new TreeNode1();
/*  72 */       occupBean.setCode(ssrs.GetText(i, 1));
/*  73 */       occupBean.setName(ssrs.GetText(i, 2));
/*  74 */       occupBean.setType(ssrs.GetText(i, 3));
/*     */ 
/*  76 */       tempNode.setBean(occupBean);
/*  77 */       this.root.addNode(tempNode);
/*     */     }
/*  79 */     this.tempOrderSql = " order by OCCUPATIONCODE,RELACODE asc";
/*  80 */     this.currentList.add(this.root);
/*  81 */     this.level += 1;
/*     */ 
/*  83 */     this.eSql = 
/*  84 */       (this.sql + " where RELACODE in (" + 
/*  84 */       this.eSql.replaceAll(",OCCUPATIONNAME,LifeRate,HiRate,PaRate,WpRate,RELACODE", "") + ")");
/*  85 */     ssrs = exeSql.execSQL(this.eSql + this.tempOrderSql);
/*  86 */     while ((ssrs != null) && (ssrs.getMaxRow() != 0)) {
/*  87 */       HashMap hm = getNodeList();
/*     */ 
/*  89 */       for (int i = 1; i <= ssrs.getMaxRow(); i++) {
/*  90 */         OccupBean occupBean = new OccupBean();
/*  91 */         TreeNode1 tempNode = new TreeNode1();
/*  92 */         occupBean.setCode(ssrs.GetText(i, 1));
/*  93 */         occupBean.setName(ssrs.GetText(i, 2));
/*  94 */         occupBean.setType(ssrs.GetText(i, 3));
/*  95 */         occupBean.setHiRate(ssrs.GetText(i, 4));
/*  96 */         occupBean.setPaRate(ssrs.GetText(i, 5));
/*  97 */         occupBean.setWpRate(ssrs.GetText(i, 6));
/*     */ 
/*  99 */         tempNode.setBean(occupBean);
/*     */ 
/* 101 */         ((TreeNode1)hm.get(ssrs.GetText(i, 7))).addNode(tempNode);
/*     */       }
/*     */ 
/* 104 */       this.eSql = 
/* 105 */         (this.sql + " where RELACODE in (" + 
/* 105 */         this.eSql.replaceAll(",OCCUPATIONNAME,LifeRate,HiRate,PaRate,WpRate,RELACODE", "") + ")");
/* 106 */       ssrs = exeSql.execSQL(this.eSql + this.tempOrderSql);
/* 107 */       this.level += 1;
/*     */     }
/*     */ 
/* 110 */     return this.root;
/*     */   }
/*     */ 
/*     */   public TreeNode1 getTreeData2(String str) {
/* 114 */     this.root = new TreeNode1();
/* 115 */     this.currentList = new ArrayList();
/*     */ 
/* 118 */     TreeNode1 currentParent = new TreeNode1();
/*     */ 
/* 120 */     currentParent = this.root;
/*     */ 
/* 123 */     ExeSQL exeSql = new ExeSQL();
/*     */ 
/* 125 */     String sql22 = "select OCCUPATIONCODE,OCCUPATIONNAME,LifeRate,HiRate,PaRate,WpRate,RELACODE from lnpoccupation where OCCUPATIONCODE in(select distinct relacode from lnpoccupation where OCCUPATIONNAME like '%" + str + "%') and" + 
/* 126 */       " RELACODE is null or RELACODE = ''";
/* 127 */     if (this.checkBox) {
/* 128 */       sql22 = "select OCCUPATIONCODE,OCCUPATIONNAME,LifeRate,HiRate,PaRate,WpRate,RELACODE from lnpoccupation where OCCUPATIONCODE in(select distinct relacode from lnpoccupation where OCCUPATIONNAME = '" + str + "') and" + 
/* 129 */         " RELACODE is null or RELACODE = ''";
/*     */     }
/* 131 */     this.eSql += " where RELACODE is null or RELACODE = ''";
/* 132 */     SSRS ssrs = exeSql.execSQL(sql22);
/* 133 */     if ((ssrs == null) || (ssrs.getMaxRow() == 0))
/* 134 */       return null;
/* 135 */     for (int i = 1; i <= ssrs.getMaxRow(); i++) {
/* 136 */       OccupBean occupBean = new OccupBean();
/* 137 */       TreeNode1 tempNode = new TreeNode1();
/* 138 */       occupBean.setCode(ssrs.GetText(i, 1));
/* 139 */       occupBean.setName(ssrs.GetText(i, 2));
/* 140 */       occupBean.setType(ssrs.GetText(i, 3));
/*     */ 
/* 142 */       tempNode.setBean(occupBean);
/* 143 */       this.root.addNode(tempNode);
/*     */     }
/* 145 */     this.tempOrderSql = " order by OCCUPATIONCODE,RELACODE asc";
/* 146 */     this.currentList.add(this.root);
/* 147 */     this.level += 1;
/* 148 */     if (this.checkBox)
/* 149 */       this.eSql = 
/* 150 */         (this.sql + " where RELACODE in (" + 
/* 150 */         this.eSql.replaceAll(",OCCUPATIONNAME,LifeRate,HiRate,PaRate,WpRate,RELACODE", "") + ") and OCCUPATIONNAME = '" + str + "'");
/*     */     else {
/* 152 */       this.eSql = 
/* 153 */         (this.sql + " where RELACODE in (" + 
/* 153 */         this.eSql.replaceAll(",OCCUPATIONNAME,LifeRate,HiRate,PaRate,WpRate,RELACODE", "") + ") and OCCUPATIONNAME like '%" + str + "%'");
/*     */     }
/* 155 */     ssrs = exeSql.execSQL(this.eSql + this.tempOrderSql);
/* 156 */     while ((ssrs != null) && (ssrs.getMaxRow() != 0)) {
/* 157 */       HashMap hm = getNodeList();
/*     */ 
/* 159 */       for (int i = 1; i <= ssrs.getMaxRow(); i++) {
/* 160 */         OccupBean occupBean = new OccupBean();
/* 161 */         TreeNode1 tempNode = new TreeNode1();
/* 162 */         occupBean.setCode(ssrs.GetText(i, 1));
/* 163 */         occupBean.setName(ssrs.GetText(i, 2));
/* 164 */         occupBean.setType(ssrs.GetText(i, 3));
/* 165 */         occupBean.setHiRate(ssrs.GetText(i, 4));
/* 166 */         occupBean.setPaRate(ssrs.GetText(i, 5));
/* 167 */         occupBean.setWpRate(ssrs.GetText(i, 6));
/*     */ 
/* 169 */         tempNode.setBean(occupBean);
/*     */ 
/* 171 */         ((TreeNode1)hm.get(ssrs.GetText(i, 7))).addNode(tempNode);
/*     */       }
/*     */ 
/* 174 */       this.eSql = 
/* 175 */         (this.sql + " where RELACODE in (" + 
/* 175 */         this.eSql.replaceAll(",OCCUPATIONNAME,LifeRate,HiRate,PaRate,WpRate,RELACODE", "") + ")");
/* 176 */       ssrs = exeSql.execSQL(this.eSql + this.tempOrderSql);
/* 177 */       this.level += 1;
/*     */     }
/*     */ 
/* 180 */     return this.root;
/*     */   }
/*     */ 
/*     */   public TreeNode1 getTreeData3(String str)
/*     */   {
/* 186 */     this.root = new TreeNode1();
/* 187 */     this.currentList = new ArrayList();
/*     */ 
/* 190 */     TreeNode1 currentParent = new TreeNode1();
/*     */ 
/* 192 */     currentParent = this.root;
/*     */ 
/* 195 */     ExeSQL exeSql = new ExeSQL();
/*     */ 
/* 197 */     String sql22 = "select OCCUPATIONCODE,OCCUPATIONNAME,LifeRate,HiRate,PaRate,WpRate,RELACODE from lnpoccupation where OCCUPATIONCODE in(select distinct occupationcode from lnpoccupation where OCCUPATIONNAME like '%" + 
/* 198 */       str + "%' " + 
/* 199 */       "and RELACODE is null or RELACODE = '')";
/* 200 */     if (this.checkBox) {
/* 201 */       sql22 = "select OCCUPATIONCODE,OCCUPATIONNAME,LifeRate,HiRate,PaRate,WpRate,RELACODE from lnpoccupation where OCCUPATIONCODE in(select distinct occupationcode from lnpoccupation where OCCUPATIONNAME = '" + 
/* 202 */         str + "' " + 
/* 203 */         "and RELACODE is null or RELACODE = '')";
/*     */     }
/* 205 */     SSRS ssrs = exeSql.execSQL(sql22);
/* 206 */     if ((ssrs == null) || (ssrs.getMaxRow() == 0))
/* 207 */       return null;
/* 208 */     for (int i = 1; i <= ssrs.getMaxRow(); i++) {
/* 209 */       OccupBean occupBean = new OccupBean();
/* 210 */       TreeNode1 tempNode = new TreeNode1();
/* 211 */       occupBean.setCode(ssrs.GetText(i, 1));
/* 212 */       occupBean.setName(ssrs.GetText(i, 2));
/* 213 */       occupBean.setType(ssrs.GetText(i, 3));
/*     */ 
/* 215 */       tempNode.setBean(occupBean);
/* 216 */       this.root.addNode(tempNode);
/*     */     }
/* 218 */     this.tempOrderSql = " order by OCCUPATIONCODE,RELACODE asc";
/* 219 */     this.currentList.add(this.root);
/* 220 */     this.level += 1;
/* 221 */     if (this.checkBox)
/* 222 */       this.eSql = 
/* 224 */         (this.sql + " where RELACODE in (" + 
/* 223 */         this.eSql.replaceAll(",OCCUPATIONNAME,LifeRate,HiRate,PaRate,WpRate,RELACODE", "") + " " + 
/* 224 */         "where OCCUPATIONNAME = '" + str + "' and (RELACODE is null or RELACODE = '') )");
/*     */     else {
/* 226 */       this.eSql = 
/* 228 */         (this.sql + " where RELACODE in (" + 
/* 227 */         this.eSql.replaceAll(",OCCUPATIONNAME,LifeRate,HiRate,PaRate,WpRate,RELACODE", "") + " " + 
/* 228 */         "where OCCUPATIONNAME like '%" + str + "%' and (RELACODE is null or RELACODE = '') )");
/*     */     }
/* 230 */     ssrs = exeSql.execSQL(this.eSql + this.tempOrderSql);
/* 231 */     while ((ssrs != null) && (ssrs.getMaxRow() != 0)) {
/* 232 */       HashMap hm = getNodeList();
/*     */ 
/* 234 */       for (int i = 1; i <= ssrs.getMaxRow(); i++) {
/* 235 */         OccupBean occupBean = new OccupBean();
/* 236 */         TreeNode1 tempNode = new TreeNode1();
/* 237 */         occupBean.setCode(ssrs.GetText(i, 1));
/* 238 */         occupBean.setName(ssrs.GetText(i, 2));
/* 239 */         occupBean.setType(ssrs.GetText(i, 3));
/* 240 */         occupBean.setHiRate(ssrs.GetText(i, 4));
/* 241 */         occupBean.setPaRate(ssrs.GetText(i, 5));
/* 242 */         occupBean.setWpRate(ssrs.GetText(i, 6));
/*     */ 
/* 244 */         tempNode.setBean(occupBean);
/*     */ 
/* 246 */         ((TreeNode1)hm.get(ssrs.GetText(i, 7))).addNode(tempNode);
/*     */       }
/*     */ 
/* 249 */       this.eSql = 
/* 250 */         (this.sql + " where RELACODE in (" + 
/* 250 */         this.eSql.replaceAll(",OCCUPATIONNAME,LifeRate,HiRate,PaRate,WpRate,RELACODE", "") + ")");
/* 251 */       ssrs = exeSql.execSQL(this.eSql + this.tempOrderSql);
/* 252 */       this.level += 1;
/*     */     }
/*     */ 
/* 255 */     return this.root;
/*     */   }
/*     */ 
/*     */   public HashMap getNodeList() {
/* 259 */     HashMap hm = new HashMap();
/* 260 */     ArrayList al = new ArrayList();
/*     */ 
/* 263 */     for (int i = 0; i < this.currentList.size(); i++) {
/* 264 */       ArrayList temp = ((TreeNode1)this.currentList.get(i)).getChildList();
/*     */ 
/* 266 */       for (int j = 0; j < temp.size(); j++) {
/* 267 */         al.add(temp.get(j));
/*     */       }
/*     */     }
/* 270 */     this.currentList = al;
/* 271 */     for (int i = 0; i < al.size(); i++) {
/* 272 */       hm.put(((TreeNode1)al.get(i)).getBean().getCode(), al.get(i));
/*     */     }
/*     */ 
/* 275 */     return hm;
/*     */   }
/*     */ 
/*     */   public void addNodes(TreeNode1 treeNode, TreeNode nodeImpl) {
/* 279 */     ArrayList list = treeNode.getChildList();
/* 280 */     for (int i = 0; i < list.size(); i++) {
/* 281 */       TreeNodeImpl treeNodeImpl = new TreeNodeImpl();
/* 282 */       TreeNode1 node1 = (TreeNode1)list.get(i);
/* 283 */       treeNodeImpl.setData(node1.getBean());
/* 284 */       nodeImpl.addChild(node1.getBean().getCode(), treeNodeImpl);
/* 285 */       addNodes(node1, treeNodeImpl);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void loadTree() {
/* 290 */     this.rootNode = new TreeNodeImpl();
/* 291 */     if (this.searchFlag)
/* 292 */       getTreeData3(this.str);
/*     */     else {
/* 294 */       getTreeData();
/*     */     }
/* 296 */     addNodes(this.root, this.rootNode);
/*     */   }
/*     */ 
/*     */   public void processSelection(NodeSelectedEvent event) {
/* 300 */     HtmlTree tree = (HtmlTree)event.getComponent();
/* 301 */     OccupBean ob = (OccupBean)tree.getRowData();
/*     */ 
/* 303 */     if ((!ob.code.equals("")) && (!ob.name.equals("")) && (!ob.paRate.equals(""))) {
/* 304 */       this.OccupBean = ob;
/*     */     }
/* 306 */     this.selectedNodeChildren.clear();
/*     */ 
/* 308 */     TreeNode currentNode = tree.getModelTreeNode(tree.getRowKey());
/* 309 */     if (currentNode.isLeaf())
/* 310 */       this.selectedNodeChildren.add((OccupBean)currentNode.getData());
/*     */     else {
/*     */       try
/*     */       {
/* 314 */         if (tree.isExpanded())
/*     */         {
/* 316 */           tree.queueCollapseAll();
/*     */         }
/*     */         else
/*     */         {
/* 320 */           tree.queueExpandAll();
/*     */         }
/*     */       }
/*     */       catch (IOException e) {
/* 324 */         e.printStackTrace();
/*     */       }
/*     */     }
/* 327 */     tree.clearTreeNodeState();
/*     */   }
/*     */ 
/*     */   public String search()
/*     */   {
/* 384 */     this.searchFlag = true;
/* 385 */     this.str = this.occName;
/* 386 */     this.occName = "";
/* 387 */     this.rootNode = null;
/* 388 */     this.eSql = "select OCCUPATIONCODE,OCCUPATIONNAME,LifeRate,HiRate,PaRate,WpRate,RELACODE from lnpoccupation";
/* 389 */     getTreeNode();
/* 390 */     return "";
/*     */   }
/*     */   public ArrayList asList() {
/* 393 */     if (this.root == null) {
/* 394 */       getTreeData();
/* 395 */       OccupBean ob = new OccupBean();
/* 396 */       ob.setCode("-1");
/* 397 */       this.root.setBean(ob);
/* 398 */       this.resultList = new ArrayList();
/* 399 */       recursive(this.root, -1, null);
/*     */     } else {
/* 401 */       this.resultList = new ArrayList();
/* 402 */       recursive(this.root, -1, null);
/*     */     }
/*     */ 
/* 405 */     return this.resultList;
/*     */   }
/*     */   public void recursive(TreeNode1 tn, int level, TreeNode1 parentNode) {
/* 408 */     level++;
/* 409 */     tn.setLevel(level);
/* 410 */     if (tn.hasChildNode()) {
/* 411 */       if (!tn.equals(this.root)) {
/* 412 */         tn.setParentNode(parentNode);
/* 413 */         this.resultList.add(tn);
/*     */       }
/* 415 */       ArrayList temp = tn.getChildList();
/* 416 */       for (int i = 0; i < temp.size(); i++)
/* 417 */         recursive((TreeNode1)temp.get(i), level, tn);
/*     */     } else {
/* 419 */       tn.setParentNode(parentNode);
/* 420 */       this.resultList.add(tn);
/*     */     }
/*     */   }
/*     */ 
/*     */   public TreeNode getTreeNode() {
/* 425 */     if (this.rootNode == null) {
/* 426 */       loadTree();
/*     */     }
/*     */ 
/* 429 */     return this.rootNode;
/*     */   }
/*     */ 
/*     */   public void saveOccup()
/*     */   {
/* 436 */     String name = this.OccupBean.name;
/* 437 */     String code = this.OccupBean.code;
/* 438 */     HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
/*     */ 
/* 440 */     session.setAttribute("occupationName", name);
/* 441 */     session.setAttribute("occupationCode", code);
/*     */   }
/*     */ 
/*     */   public void changeFlag()
/*     */   {
/* 446 */     this.flag = false;
/*     */   }
/*     */ 
/*     */   public String getOccName()
/*     */   {
/* 451 */     return this.occName;
/*     */   }
/*     */   public void setOccName(String occName) {
/* 454 */     this.occName = occName;
/*     */   }
/*     */   public int getIndex() {
/* 457 */     return this.index;
/*     */   }
/*     */   public void setIndex(int index) {
/* 460 */     this.index = index;
/*     */   }
/*     */   public void setOccupBean(OccupBean occBean) {
/* 463 */     this.OccupBean = occBean;
/*     */   }
/*     */   public OccupBean getOccupBean() {
/* 466 */     return this.OccupBean;
/*     */   }
/*     */   public boolean getCheckBox() {
/* 469 */     return this.checkBox;
/*     */   }
/*     */   public void setCheckBox(boolean checkbox) {
/* 472 */     this.checkBox = checkbox;
/*     */   }
/*     */   public void setMessage(String msg) {
/* 475 */     this.message = msg;
/*     */   }
/*     */   public String getMessage() {
/* 478 */     return this.message;
/*     */   }
/*     */   public void setFlag(boolean boo) {
/* 481 */     this.flag = boo;
/*     */   }
/*     */   public boolean getFlag() {
/* 484 */     return this.flag;
/*     */   }
/*     */ 
/*     */   public boolean isSearchFlag() {
/* 488 */     return this.searchFlag;
/*     */   }
/*     */ 
/*     */   public void setSearchFlag(boolean searchFlag) {
/* 492 */     this.searchFlag = searchFlag;
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lis.tree.OccupTreeBean
 * JD-Core Version:    0.6.0
 */