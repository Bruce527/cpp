/*      */ package com.sinosoft.banklns.lnsmodel;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPPolDB;
/*      */ import com.sinosoft.banklns.lis.pubfun.IGlobalInput;
/*      */ import com.sinosoft.banklns.lis.pubfun.LNPPubFun;
/*      */ import com.sinosoft.banklns.lis.pubfun.MMap;
/*      */ import com.sinosoft.banklns.lis.pubfun.PubFun;
/*      */ import com.sinosoft.banklns.lis.pubfun.PubSubmit;
/*      */ import com.sinosoft.banklns.lis.schema.LNPAddressSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPAppntSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPBnfSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPContSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPInsuredSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPPersonSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPPolSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPPolSet;
/*      */ import com.sinosoft.banklns.utility.ExeSQL;
/*      */ import com.sinosoft.banklns.utility.SSRS;
/*      */ import com.sinosoft.banklns.utility.VData;
/*      */ import java.io.PrintStream;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import java.util.regex.Pattern;
/*      */ import javax.faces.context.ExternalContext;
/*      */ import javax.faces.context.FacesContext;
/*      */ import javax.servlet.http.HttpSession;
/*      */ 
/*      */ public class StateOperatorDeal
/*      */ {
/* 1010 */   private boolean ageChangeToJuvenilesFlag = false;
/*      */ 
/*      */   public List infoOperate(String state, String editState, String operateType, String infoType)
/*      */   {
/*   34 */     if (operateType.equals("add"))
/*   35 */       return addInfoOperator(state, editState, infoType);
/*   36 */     if (operateType.equals("modify"))
/*   37 */       return modifyInfoOperator(state, editState, infoType);
/*   38 */     if (operateType.equals("delete")) {
/*   39 */       return deleteInfoOperator(state, editState, infoType);
/*      */     }
/*   41 */     return null;
/*      */   }
/*      */ 
/*      */   public List addInfoOperator(String state, String editState, String infoType)
/*      */   {
/*   46 */     List reList = new ArrayList();
/*   47 */     String[] editStateArray = new String[editState.length()];
/*   48 */     String reState = state;
/*   49 */     String reEditState = "";
/*      */ 
/*   52 */     for (int i = 0; i < editState.length(); i++)
/*   53 */       editStateArray[i] = editState.substring(i, i + 1);
/*      */     int infoTypeNo;
/*      */     int infoTypeNo;
/*   56 */     if (infoType.startsWith("0"))
/*   57 */       infoTypeNo = Integer.parseInt(infoType.substring(1));
/*      */     else {
/*   59 */       infoTypeNo = Integer.parseInt(infoType);
/*      */     }
/*      */ 
/*   63 */     switch (infoTypeNo)
/*      */     {
/*      */     case 1:
/*   66 */       editStateArray[0] = "1";
/*   67 */       break;
/*      */     case 2:
/*   69 */       editStateArray[1] = "1";
/*   70 */       break;
/*      */     case 3:
/*   72 */       editStateArray[2] = "1";
/*   73 */       break;
/*      */     case 4:
/*   75 */       editStateArray[3] = "1";
/*      */ 
/*   80 */       reState = "01";
/*   81 */       break;
/*      */     case 5:
/*   83 */       editStateArray[4] = "1";
/*      */ 
/*   87 */       break;
/*      */     case 6:
/*   89 */       editStateArray[5] = "1";
/*      */ 
/*   92 */       if ((!reState.equals("03")) && (!reState.equals("05"))) break;
/*   93 */       reState = "02";
/*      */ 
/*   95 */       break;
/*      */     case 7:
/*   97 */       editStateArray[6] = "1";
/*      */ 
/*  100 */       if ((!reState.equals("03")) && (!reState.equals("05"))) break;
/*  101 */       reState = "02";
/*      */ 
/*  103 */       break;
/*      */     case 8:
/*  105 */       editStateArray[7] = "1";
/*  106 */       if ((!reState.equals("03")) && (!reState.equals("05"))) break;
/*  107 */       reState = "02";
/*      */ 
/*  109 */       break;
/*      */     case 9:
/*  111 */       editStateArray[8] = "1";
/*  112 */       if ((!reState.equals("03")) && (!reState.equals("05"))) break;
/*  113 */       reState = "02";
/*      */     }
/*      */ 
/*  120 */     for (int i = 0; i < editState.length(); i++) {
/*  121 */       reEditState = reEditState + editStateArray[i];
/*      */     }
/*      */ 
/*  124 */     reList.add(reState);
/*  125 */     reList.add(reEditState);
/*      */ 
/*  127 */     return reList;
/*      */   }
/*      */ 
/*      */   public List modifyInfoOperator(String state, String editState, String infoType) {
/*  131 */     List reList = new ArrayList();
/*  132 */     String[] editStateArray = new String[editState.length()];
/*  133 */     String reState = state;
/*  134 */     String reEditState = "";
/*      */ 
/*  137 */     for (int i = 0; i < editState.length(); i++)
/*  138 */       editStateArray[i] = editState.substring(i, i + 1);
/*      */     int infoTypeNo;
/*      */     int infoTypeNo;
/*  141 */     if (infoType.startsWith("0"))
/*  142 */       infoTypeNo = Integer.parseInt(infoType.substring(1));
/*      */     else {
/*  144 */       infoTypeNo = Integer.parseInt(infoType);
/*      */     }
/*      */ 
/*  147 */     switch (infoTypeNo)
/*      */     {
/*      */     case 1:
/*  150 */       editStateArray[0] = "1";
/*  151 */       state = "01";
/*  152 */       break;
/*      */     case 2:
/*  155 */       editStateArray[1] = "1";
/*  156 */       break;
/*      */     case 3:
/*  158 */       editStateArray[2] = "1";
/*  159 */       break;
/*      */     case 4:
/*  162 */       editStateArray[3] = "1";
/*      */ 
/*  165 */       editStateArray[9] = "0";
/*  166 */       reState = "01";
/*  167 */       break;
/*      */     case 5:
/*  169 */       editStateArray[4] = "1";
/*      */ 
/*  173 */       break;
/*      */     case 6:
/*  175 */       editStateArray[5] = "1";
/*  176 */       if ((!reState.equals("03")) && (!reState.equals("05"))) break;
/*  177 */       reState = "02";
/*      */ 
/*  179 */       break;
/*      */     case 7:
/*  181 */       editStateArray[6] = "1";
/*  182 */       if ((!reState.equals("03")) && (!reState.equals("05"))) break;
/*  183 */       reState = "02";
/*      */ 
/*  185 */       break;
/*      */     case 8:
/*  187 */       editStateArray[7] = "1";
/*      */ 
/*  189 */       if ((!reState.equals("03")) && (!reState.equals("05"))) break;
/*  190 */       reState = "02";
/*      */ 
/*  192 */       break;
/*      */     case 9:
/*  194 */       editStateArray[8] = "1";
/*  195 */       if ((!reState.equals("03")) && (!reState.equals("05"))) break;
/*  196 */       reState = "02";
/*      */     }
/*      */ 
/*  201 */     for (int i = 0; i < editState.length(); i++) {
/*  202 */       reEditState = reEditState + editStateArray[i];
/*      */     }
/*      */ 
/*  205 */     reList.add(reState);
/*  206 */     reList.add(reEditState);
/*      */ 
/*  208 */     return reList;
/*      */   }
/*      */ 
/*      */   public List deleteInfoOperator(String state, String editState, String infoType) {
/*  212 */     List reList = new ArrayList();
/*  213 */     String[] editStateArray = new String[editState.length()];
/*  214 */     String reState = state;
/*  215 */     String reEditState = "";
/*      */ 
/*  218 */     for (int i = 0; i < editState.length(); i++)
/*  219 */       editStateArray[i] = editState.substring(i, i + 1);
/*      */     int infoTypeNo;
/*      */     int infoTypeNo;
/*  222 */     if (infoType.startsWith("0"))
/*  223 */       infoTypeNo = Integer.parseInt(infoType.substring(1));
/*      */     else {
/*  225 */       infoTypeNo = Integer.parseInt(infoType);
/*      */     }
/*      */ 
/*  229 */     switch (infoTypeNo)
/*      */     {
/*      */     case 4:
/*  232 */       editStateArray[3] = "0";
/*      */ 
/*  234 */       reState = "01";
/*  235 */       break;
/*      */     case 6:
/*  237 */       editStateArray[5] = "0";
/*  238 */       if ((!reState.equals("03")) && (!reState.equals("05"))) break;
/*  239 */       reState = "02";
/*      */ 
/*  242 */       break;
/*      */     case 7:
/*  244 */       editStateArray[6] = "0";
/*  245 */       if ((!reState.equals("03")) && (!reState.equals("05"))) break;
/*  246 */       reState = "02";
/*      */ 
/*  249 */       break;
/*      */     case 9:
/*  251 */       editStateArray[8] = "0";
/*  252 */       if ((!reState.equals("03")) && (!reState.equals("05"))) break;
/*  253 */       reState = "02";
/*      */     case 5:
/*      */     case 8:
/*      */     }
/*      */ 
/*  259 */     for (int i = 0; i < editState.length(); i++) {
/*  260 */       reEditState = reEditState + editStateArray[i];
/*      */     }
/*      */ 
/*  263 */     reList.add(reState);
/*  264 */     reList.add(reEditState);
/*      */ 
/*  266 */     return reList;
/*      */   }
/*      */ 
/*      */   public boolean checkEditOperate(String state, String operatorType, String contno)
/*      */   {
/*  271 */     boolean flag = false;
/*  272 */     if (operatorType.equals("1")) {
/*  273 */       PolicyMainInfo mainInfo = new PolicyMainInfo();
/*  274 */       LNPContSchema lnpSch = mainInfo.getContByContNo(contno);
/*  275 */       if ((Pattern.matches("^[0][1|2|3]{1}", state)) && (("0".equals(lnpSch.getLang())) || ("2".equals(lnpSch.getLang())))) {
/*  276 */         flag = true;
/*      */       }
/*      */ 
/*  281 */       if (("05".equals(state)) && ("2".equals(lnpSch.getAppFlag())) && ("2".equals(lnpSch.getLang()))) {
/*  282 */         flag = true;
/*      */       }
/*      */ 
/*  285 */       if (("03".equals(state)) && ("3".equals(lnpSch.getAppFlag())) && ("1".equals(lnpSch.getLang())))
/*  286 */         flag = true;
/*      */     }
/*  288 */     else if (operatorType.equals("2"))
/*      */     {
/*  293 */       PolicyMainInfo mainInfo = new PolicyMainInfo();
/*  294 */       LNPContSchema lnpSch = mainInfo.getContByContNo(contno);
/*      */ 
/*  296 */       if ((!"0".equals(lnpSch.getLang())) && (!"04".equals(state))) {
/*  297 */         flag = true;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  307 */     return flag;
/*      */   }
/*      */ 
/*      */   public boolean checkContPayMentOperate(String state, String editState) {
/*  311 */     boolean flag = false;
/*      */ 
/*  313 */     if ((state.equals("01")) && (Pattern.matches("^([1]{4})[0|1]{6}[0|1]*", editState))) {
/*  314 */       flag = true;
/*      */     }
/*      */ 
/*  317 */     return flag;
/*      */   }
/*      */ 
/*      */   public boolean checkUnderWriteOperate(String state, String editState) {
/*  321 */     boolean flag = false;
/*      */ 
/*  323 */     if ((state.equals("02")) && (Pattern.matches("^([1]{4})[0|1]{1}[1]{1}[0|1]{1}[1]{2}[0|1|2]{1}[0|1]*", editState))) {
/*  324 */       flag = true;
/*      */     }
/*      */ 
/*  327 */     return flag;
/*      */   }
/*      */ 
/*      */   public boolean checkShowUnderWriteAnswerOperate(String contno) {
/*  331 */     boolean flag = false;
/*      */ 
/*  335 */     if ((contno != null) && (!contno.equals(""))) {
/*  336 */       String queSQL = "select UWMessages from  LNPCUWMaster where contno='" + contno + "' ;";
/*      */ 
/*  338 */       ExeSQL tExeSQL = new ExeSQL();
/*  339 */       SSRS tSSRS = tExeSQL.execSQL(queSQL);
/*  340 */       if (tSSRS.MaxRow > 0)
/*      */       {
/*  342 */         flag = true;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  350 */     return flag;
/*      */   }
/*      */ 
/*      */   public boolean checkSubmitFlagOperate(String state, String editState, String lnpUserType, String contno) {
/*  354 */     boolean flag = false;
/*      */ 
/*  357 */     if ((state.equals("03")) && (Pattern.matches("^([1]{6})[0|1]{1}[1]{2}[0|1]{1}[0|1]*", editState))) {
/*  358 */       flag = true;
/*      */     }
/*      */ 
/*  363 */     if (("2".equals(lnpUserType)) && ("05".equals(state))) {
/*  364 */       flag = true;
/*      */     }
/*      */ 
/*  369 */     if ("1".equals(lnpUserType)) {
/*  370 */       PolicyMainInfo mainInfo = new PolicyMainInfo();
/*  371 */       LNPContSchema lnpSch = mainInfo.getContByContNo(contno);
/*  372 */       if (("05".equals(state)) && ("2".equals(lnpSch.getAppFlag()))) {
/*  373 */         flag = true;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  379 */     return flag;
/*      */   }
/*      */ 
/*      */   public boolean checkRepealOperate(String state)
/*      */   {
/*  384 */     boolean flag = false;
/*      */ 
/*  386 */     if ((state.equals("02")) || (state.equals("03")) || (state.equals("05"))) {
/*  387 */       flag = true;
/*      */     }
/*  389 */     System.out.println("checkRepealOperate==" + flag);
/*  390 */     return flag;
/*      */   }
/*      */ 
/*      */   public String checkShowAddPremOperate(String contNo)
/*      */   {
/*  395 */     String flag = "0";
/*  396 */     PolicyMainInfo mainInfo = new PolicyMainInfo();
/*  397 */     LNPContSchema mainSch = mainInfo.getContByContNo(contNo);
/*      */ 
/*  399 */     if ((mainSch.getApproveFlag() == null) || (mainSch.getApproveFlag().trim().equals("")) || 
/*  400 */       (mainSch.getApproveFlag().equals("0")))
/*  401 */       flag = "0";
/*  402 */     else if (mainSch.getApproveFlag().equals("1"))
/*  403 */       flag = "1";
/*  404 */     else if (mainSch.getApproveFlag().equals("2")) {
/*  405 */       flag = "2";
/*      */     }
/*      */ 
/*  408 */     return flag;
/*      */   }
/*      */ 
/*      */   public String updateEditStateDone(String editstate, int index)
/*      */   {
/*  414 */     String reEditState = editstate.substring(0, index - 1) + "1" + editstate.substring(index);
/*  415 */     return reEditState;
/*      */   }
/*      */ 
/*      */   public String updateEditStateUNDone(String editstate, int index) {
/*  419 */     String reEditState = editstate.substring(0, index - 1) + "0" + editstate.substring(index);
/*  420 */     return reEditState;
/*      */   }
/*      */ 
/*      */   public boolean afterAddInsurance(String contno)
/*      */   {
/*      */     try
/*      */     {
/*  427 */       return setBnfSc(contno);
/*      */     } catch (RuntimeException e) {
/*  429 */       e.printStackTrace();
/*  430 */     }return false;
/*      */   }
/*      */ 
/*      */   public boolean afterModifyInsurance(String contno, boolean spelInfoChangeFlag, boolean ageChangeToJuvenilesFlag)
/*      */   {
/*  436 */     System.out.println("-- afterModifyInsurance --" + contno + "--" + spelInfoChangeFlag + "--" + ageChangeToJuvenilesFlag);
/*      */     try {
/*  438 */       boolean flag = false;
/*  439 */       PolicyMainInfo mainInfo = new PolicyMainInfo();
/*  440 */       LNPContSchema tempContSch = mainInfo.getContByContNo(contno);
/*      */ 
/*  442 */       PubSubmit ps = new PubSubmit();
/*  443 */       MMap mmap = new MMap();
/*      */ 
/*  446 */       BenefitPersonInfo bnfInfo = new BenefitPersonInfo();
/*      */ 
/*  448 */       if (!bnfInfo.checkScBnfExist(contno)) {
/*  449 */         setBnfSc(contno);
/*      */       }
/*      */ 
/*  453 */       if ((tempContSch.getAppntId() != null) && (!tempContSch.getAppntId().equals("")))
/*      */       {
/*  455 */         AppntPersonInfo appntDeal = new AppntPersonInfo();
/*  456 */         LNPAppntSchema checkAppntPeopleSchema = appntDeal.getAppntPeopleByContNo(contno, "");
/*      */ 
/*  458 */         if (ageChangeToJuvenilesFlag) {
/*  459 */           mmap = deleteAppntByInsured(mmap, tempContSch);
/*  460 */           tempContSch.setAppntId("");
/*  461 */           tempContSch.setAppntNo("");
/*  462 */           tempContSch.setAppntName("");
/*  463 */           tempContSch.setAppntBirthday("");
/*  464 */           tempContSch.setAppntIDType("");
/*  465 */           tempContSch.setAppntIDNo("");
/*  466 */           tempContSch.setEditstate(updateEditStateUNDone(tempContSch.getEditstate(), 3));
/*      */         }
/*      */ 
/*  469 */         if (checkAppntPeopleSchema.getRelationToInsured().equals("0"))
/*      */         {
/*  471 */           mmap = updateAppntByInsured(mmap, tempContSch);
/*  472 */           InsuredPersonInfo insuredDeal = new InsuredPersonInfo();
/*  473 */           LNPInsuredSchema insuredSch = insuredDeal.getInsuPeopleByContNo(tempContSch.getContNo(), tempContSch.getInsuredId());
/*      */ 
/*  475 */           tempContSch.setAppntName(insuredSch.getName());
/*  476 */           tempContSch.setAppntBirthday(insuredSch.getBirthday());
/*  477 */           tempContSch.setAppntIDType(insuredSch.getIDType());
/*  478 */           tempContSch.setAppntIDNo(insuredSch.getIDNo());
/*  479 */           List stateList = infoOperate(tempContSch.getState(), tempContSch.getEditstate(), "modify", "03");
/*  480 */           tempContSch.setState((String)stateList.get(0));
/*  481 */           tempContSch.setEditstate((String)stateList.get(1));
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*  486 */       BenefitPersonInfo bnfDeal = new BenefitPersonInfo();
/*  487 */       if (bnfDeal.checkScBnfExist(contno)) {
/*  488 */         mmap = modifyBnfSc(mmap, tempContSch.getContNo());
/*  489 */         List stateList = infoOperate(tempContSch.getState(), tempContSch.getEditstate(), "add", "06");
/*  490 */         tempContSch.setState((String)stateList.get(0));
/*  491 */         tempContSch.setEditstate((String)stateList.get(1));
/*      */       }
/*      */ 
/*  496 */       if (spelInfoChangeFlag)
/*      */       {
/*  500 */         LNPPolDB db = new LNPPolDB();
/*  501 */         db.setContNo(contno);
/*  502 */         LNPPolSet polSet = db.query();
/*  503 */         if (polSet != null) {
/*  504 */           mmap.put(polSet, "DELETE");
/*  505 */           tempContSch.setPrem(0.0D);
/*  506 */           tempContSch.setMult(0.0D);
/*  507 */           tempContSch.setSumPrem(0.0D);
/*  508 */           tempContSch.setAmnt(0.0D);
/*  509 */           List stateList = infoOperate(tempContSch.getState(), tempContSch.getEditstate(), "delete", "04");
/*  510 */           tempContSch.setState((String)stateList.get(0));
/*  511 */           tempContSch.setEditstate((String)stateList.get(1));
/*      */         }
/*      */       }
/*  514 */       String date = PubFun.getCurrentDate();
/*  515 */       String time = PubFun.getCurrentTime();
/*  516 */       tempContSch.setModifyDate(date);
/*  517 */       tempContSch.setModifyTime(time);
/*  518 */       mmap.put(tempContSch, "UPDATE");
/*  519 */       VData vd = new VData();
/*  520 */       vd = new VData();
/*  521 */       vd.add(mmap);
/*  522 */       if (ps.submitData(vd, "")) {
/*  523 */         flag = true;
/*      */       }
/*  525 */       System.out.println("-- afterModifyInsurance endflag--" + flag);
/*      */ 
/*  527 */       return flag;
/*      */     } catch (RuntimeException e) {
/*      */     }
/*  530 */     return false;
/*      */   }
/*      */ 
/*      */   private MMap deleteAppntByInsured(MMap mmap, LNPContSchema lnpContSch)
/*      */   {
/*      */     try
/*      */     {
/*  537 */       String deleteContNo = lnpContSch.getContNo();
/*      */ 
/*  539 */       AppntPersonInfo appntDeal = new AppntPersonInfo();
/*  540 */       LNPAppntSchema deleteAppntPeopleSchema = appntDeal.getAppntPeopleByContNo(deleteContNo, "");
/*      */ 
/*  543 */       if ((deleteAppntPeopleSchema != null) && (deleteAppntPeopleSchema != null))
/*      */       {
/*  546 */         mmap.put(deleteAppntPeopleSchema, "DELETE");
/*      */ 
/*  548 */         return mmap;
/*      */       }
/*      */     } catch (RuntimeException e) {
/*  551 */       return mmap;
/*      */     }
/*      */ 
/*  554 */     return mmap;
/*      */   }
/*      */ 
/*      */   private MMap deleteRiskInfo(MMap mmap, String contno)
/*      */   {
/*  560 */     LNPPolDB db = new LNPPolDB();
/*  561 */     db.setContNo(contno);
/*  562 */     PolicyMainInfo mainInfo = new PolicyMainInfo();
/*  563 */     LNPContSchema tempContSch = mainInfo.getContByContNo(contno);
/*  564 */     tempContSch.setPrem(0.0D);
/*  565 */     tempContSch.setMult(0.0D);
/*  566 */     tempContSch.setSumPrem(0.0D);
/*  567 */     tempContSch.setAmnt(0.0D);
/*      */ 
/*  569 */     List stateList = infoOperate(tempContSch.getState(), tempContSch.getEditstate(), "delete", "04");
/*      */ 
/*  571 */     tempContSch.setState((String)stateList.get(0));
/*  572 */     tempContSch.setEditstate((String)stateList.get(1));
/*      */ 
/*  574 */     LNPPolSet polSet = db.query();
/*  575 */     if (polSet != null)
/*      */     {
/*  577 */       mmap.put(polSet, "DELETE");
/*  578 */       mmap.put(tempContSch, "UPDATE");
/*      */     }
/*  580 */     return mmap;
/*      */   }
/*      */ 
/*      */   public boolean setBnfSc(String contno)
/*      */   {
/*  586 */     boolean flag = false;
/*      */ 
/*  588 */     HttpSession session = (HttpSession)FacesContext.getCurrentInstance()
/*  589 */       .getExternalContext().getSession(true);
/*      */ 
/*  591 */     IGlobalInput tempGInew = (IGlobalInput)session.getValue("NPGI");
/*  592 */     String date = PubFun.getCurrentDate();
/*  593 */     String time = PubFun.getCurrentTime();
/*      */ 
/*  595 */     PolicyMainInfo mainInfo = new PolicyMainInfo();
/*  596 */     LNPContSchema tempContSch = mainInfo.getContByContNo(contno);
/*      */     try
/*      */     {
/*  600 */       if ((tempContSch != null) && (tempContSch.getInsuredId() != null) && (!tempContSch.getInsuredId().equals("")))
/*      */       {
/*  602 */         PersonFunction pf = new PersonFunction();
/*      */ 
/*  604 */         LNPPersonSchema personSch = pf.getLnpPersonByCustomerId(tempContSch.getInsuredId());
/*  605 */         if (personSch != null)
/*      */         {
/*  609 */           LNPBnfSchema bnfSch = new LNPBnfSchema();
/*  610 */           bnfSch.setContNo(contno);
/*  611 */           bnfSch.setInsuredId(personSch.getCustomerId());
/*  612 */           bnfSch.setBenefitType("1");
/*      */ 
/*  614 */           bnfSch.setBenefitRate("100");
/*  615 */           bnfSch.setBenefitOrder("1");
/*  616 */           bnfSch.setBnfId(personSch.getCustomerId());
/*  617 */           bnfSch.setBnfName(personSch.getName());
/*  618 */           bnfSch.setBnfSex(personSch.getSex());
/*  619 */           bnfSch.setBnfBirthday(personSch.getBirthday());
/*  620 */           bnfSch.setBnfAge(personSch.getAge());
/*  621 */           bnfSch.setRelationToInsured("0");
/*  622 */           bnfSch.setIDType(personSch.getIDType());
/*  623 */           bnfSch.setIDNo(personSch.getIDNo());
/*  624 */           bnfSch.setNativePlace(personSch.getNativePlace());
/*  625 */           bnfSch.setMarriage(personSch.getMarriage());
/*      */ 
/*  627 */           bnfSch.setOccupationCode(personSch.getOccupationCode());
/*      */ 
/*  629 */           bnfSch.setOperator(tempGInew.Operator);
/*  630 */           bnfSch.setManageCom(tempGInew.ComCode);
/*  631 */           bnfSch.setMakeDate(date);
/*  632 */           bnfSch.setMakeTime(time);
/*  633 */           bnfSch.setModifyDate(date);
/*  634 */           bnfSch.setModifyTime(time);
/*      */ 
/*  636 */           List stateList = infoOperate(tempContSch.getState(), tempContSch.getEditstate(), "add", "06");
/*      */ 
/*  638 */           tempContSch.setState((String)stateList.get(0));
/*  639 */           tempContSch.setEditstate((String)stateList.get(1));
/*      */ 
/*  641 */           tempContSch.setModifyDate(date);
/*  642 */           tempContSch.setModifyTime(time);
/*      */ 
/*  644 */           PubSubmit ps = new PubSubmit();
/*  645 */           MMap map = new MMap();
/*      */ 
/*  647 */           map.put(bnfSch, "INSERT");
/*  648 */           map.put(tempContSch, "UPDATE");
/*      */ 
/*  650 */           VData vd = new VData();
/*  651 */           vd.add(map);
/*  652 */           if (!ps.submitData(vd, ""))
/*  653 */             System.out.println("-BenefitPersonInfo-\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD");
/*      */           else
/*  655 */             flag = true;
/*      */         }
/*      */       }
/*      */     }
/*      */     catch (RuntimeException e) {
/*  660 */       e.printStackTrace();
/*  661 */       flag = false;
/*      */     }
/*      */ 
/*  664 */     return flag;
/*      */   }
/*      */ 
/*      */   public MMap updateAppntByInsured(MMap mmap, LNPContSchema lnpContSch) {
/*      */     try {
/*  669 */       String date = PubFun.getCurrentDate();
/*  670 */       String time = PubFun.getCurrentTime();
/*  671 */       PersonFunction pf = new PersonFunction();
/*      */ 
/*  673 */       String midifyContNo = lnpContSch.getContNo();
/*  674 */       String midifyAppntId = lnpContSch.getAppntId();
/*      */ 
/*  676 */       InsuredPersonInfo insuredDeal = new InsuredPersonInfo();
/*  677 */       LNPInsuredSchema insuredSch = insuredDeal.getInsuPeopleByContNo(lnpContSch.getContNo(), lnpContSch.getInsuredId());
/*  678 */       LNPAddressSchema insuredAddSch = pf.getLnpAddrByCustomerId(lnpContSch.getInsuredId());
/*      */ 
/*  680 */       AppntPersonInfo appntDeal = new AppntPersonInfo();
/*  681 */       LNPAppntSchema modifyAppntPeopleSchema = appntDeal.getAppntPeopleByContNo(midifyContNo, "");
/*  682 */       LNPAddressSchema modifylnpAddressSchema = pf.getLnpAddrByCustomerId(midifyAppntId);
/*      */ 
/*  684 */       LNPPersonSchema modifylnpPersonSchema = pf.getLnpPersonByCustomerId(midifyAppntId);
/*      */ 
/*  686 */       if ((insuredSch != null) && (insuredSch.getAppAgeType() != null) && 
/*  687 */         ("Y".equals(insuredSch.getAppAgeType())) && (16 >= insuredSch.getAppAge())) {
/*  688 */         lnpContSch.setAppntId("");
/*  689 */         lnpContSch.setAppntNo("");
/*  690 */         lnpContSch.setAppntName("");
/*  691 */         lnpContSch.setAppntBirthday("");
/*  692 */         lnpContSch.setAppntIDType("");
/*  693 */         lnpContSch.setAppntIDNo("");
/*  694 */         lnpContSch.setEditstate(updateEditStateUNDone(lnpContSch.getEditstate(), 3));
/*  695 */         lnpContSch.setModifyDate(date);
/*  696 */         lnpContSch.setModifyTime(time);
/*      */ 
/*  698 */         mmap.put(modifyAppntPeopleSchema, "DELETE");
/*  699 */         mmap.put(modifylnpAddressSchema, "DELETE");
/*  700 */         mmap.put(modifylnpPersonSchema, "DELETE");
/*      */ 
/*  703 */         return mmap;
/*      */       }
/*      */ 
/*  707 */       if ((modifyAppntPeopleSchema != null) && 
/*  708 */         (modifylnpAddressSchema != null) && (modifylnpPersonSchema != null))
/*      */       {
/*  710 */         modifyAppntPeopleSchema.setAppntName(insuredSch.getName());
/*  711 */         modifyAppntPeopleSchema.setAppntSex(insuredSch.getSex());
/*  712 */         modifyAppntPeopleSchema.setAppntBirthday(insuredSch.getBirthday());
/*  713 */         modifyAppntPeopleSchema.setAppntAge(insuredSch.getAppAge());
/*  714 */         modifyAppntPeopleSchema.setAppntAgeType(insuredSch.getAppAgeType());
/*  715 */         modifyAppntPeopleSchema.setIDPerpetual(insuredSch.getIDPerpetual());
/*  716 */         modifyAppntPeopleSchema.setIDValidity(insuredSch.getIDValidity());
/*  717 */         modifyAppntPeopleSchema.setIDType(insuredSch.getIDType());
/*  718 */         modifyAppntPeopleSchema.setIDNo(insuredSch.getIDNo());
/*  719 */         modifyAppntPeopleSchema.setNativePlace(insuredSch
/*  720 */           .getNativePlace());
/*  721 */         modifyAppntPeopleSchema.setMarriage(insuredSch
/*  722 */           .getMarriage());
/*      */ 
/*  725 */         modifyAppntPeopleSchema.setOccupationCode(insuredSch
/*  726 */           .getOccupationCode());
/*  727 */         modifyAppntPeopleSchema.setModifyDate(date);
/*  728 */         modifyAppntPeopleSchema.setModifyTime(time);
/*      */ 
/*  731 */         modifylnpPersonSchema.setName(modifyAppntPeopleSchema.getAppntName());
/*  732 */         modifylnpPersonSchema.setSex(modifyAppntPeopleSchema.getAppntSex());
/*  733 */         modifylnpPersonSchema.setBirthday(modifyAppntPeopleSchema.getAppntBirthday());
/*  734 */         modifylnpPersonSchema.setIDType(modifyAppntPeopleSchema.getIDType());
/*  735 */         modifylnpPersonSchema.setIDNo(modifyAppntPeopleSchema.getIDNo());
/*  736 */         modifylnpPersonSchema.setNativePlace(modifyAppntPeopleSchema.getNativePlace());
/*  737 */         modifylnpPersonSchema.setMarriage(modifyAppntPeopleSchema.getMarriage());
/*  738 */         modifylnpPersonSchema.setOccupationCode(modifyAppntPeopleSchema.getOccupationCode());
/*      */ 
/*  740 */         modifylnpPersonSchema.setAge(modifyAppntPeopleSchema.getAppntAge());
/*  741 */         modifylnpPersonSchema.setAgeType(modifyAppntPeopleSchema.getAppntAgeType());
/*  742 */         modifylnpPersonSchema.setIDPerpetual(modifyAppntPeopleSchema.getIDPerpetual());
/*  743 */         modifylnpPersonSchema.setIDValidity(modifyAppntPeopleSchema.getIDValidity());
/*      */ 
/*  745 */         modifylnpPersonSchema.setModifyDate(date);
/*  746 */         modifylnpPersonSchema.setModifyTime(time);
/*      */ 
/*  751 */         modifylnpAddressSchema.setPostalAddress(insuredAddSch.getPostalAddress());
/*  752 */         modifylnpAddressSchema.setZipCode(insuredAddSch.getZipCode());
/*  753 */         modifylnpAddressSchema.setPhone(insuredAddSch.getPhone());
/*  754 */         modifylnpAddressSchema.setHomeAddress(insuredAddSch.getHomeAddress());
/*  755 */         modifylnpAddressSchema.setHomeZipCode(insuredAddSch.getHomeZipCode());
/*  756 */         modifylnpAddressSchema.setHomePhone(insuredAddSch.getHomePhone());
/*  757 */         modifylnpAddressSchema.setCompanyAddress(insuredAddSch.getCompanyAddress());
/*  758 */         modifylnpAddressSchema.setCompanyPhone(insuredAddSch.getCompanyPhone());
/*  759 */         modifylnpAddressSchema.setCompanyMail(insuredAddSch.getCompanyMail());
/*  760 */         modifylnpAddressSchema.setGrpName(insuredAddSch.getGrpName());
/*  761 */         modifylnpAddressSchema.setCompanyZipCode(insuredAddSch.getCompanyZipCode());
/*  762 */         modifylnpAddressSchema.setDuchy(insuredAddSch.getDuchy());
/*  763 */         modifylnpAddressSchema.setOtherDuchy(insuredAddSch.getOtherDuchy() != null ? insuredAddSch.getOtherDuchy() : "");
/*      */ 
/*  765 */         modifylnpAddressSchema.setModifyDate(date);
/*  766 */         modifylnpAddressSchema.setModifyTime(time);
/*      */ 
/*  769 */         lnpContSch.setAppntName(insuredSch.getName());
/*  770 */         lnpContSch.setAppntBirthday(insuredSch.getBirthday());
/*  771 */         lnpContSch.setAppntIDType(insuredSch.getIDType());
/*  772 */         lnpContSch.setAppntIDNo(insuredSch.getIDNo());
/*      */ 
/*  774 */         StateOperatorDeal operatorDeal = new StateOperatorDeal();
/*  775 */         List stateList = operatorDeal.infoOperate(lnpContSch.getState(), lnpContSch.getEditstate(), "modify", "03");
/*      */ 
/*  777 */         lnpContSch.setState((String)stateList.get(0));
/*  778 */         lnpContSch.setEditstate((String)stateList.get(1));
/*      */ 
/*  781 */         lnpContSch.setModifyDate(date);
/*  782 */         lnpContSch.setModifyTime(time);
/*      */ 
/*  784 */         mmap.put(modifyAppntPeopleSchema, "UPDATE");
/*  785 */         mmap.put(modifylnpPersonSchema, "UPDATE");
/*  786 */         mmap.put(modifylnpAddressSchema, "UPDATE");
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (RuntimeException e)
/*      */     {
/*  794 */       return mmap;
/*      */     }
/*      */ 
/*  797 */     return mmap;
/*      */   }
/*      */ 
/*      */   public MMap modifyBnfSc(MMap mmap, String contno) {
/*  801 */     HttpSession session = (HttpSession)FacesContext.getCurrentInstance()
/*  802 */       .getExternalContext().getSession(true);
/*      */ 
/*  804 */     IGlobalInput tempGInew = (IGlobalInput)session.getValue("NPGI");
/*  805 */     String date = PubFun.getCurrentDate();
/*  806 */     String time = PubFun.getCurrentTime();
/*  807 */     PolicyMainInfo mainInfo = new PolicyMainInfo();
/*  808 */     LNPContSchema tempContSch = mainInfo.getContByContNo(contno);
/*  809 */     BenefitPersonInfo bnfDeal = new BenefitPersonInfo();
/*      */ 
/*  811 */     LNPBnfSchema modifySch = bnfDeal.getBnfSgSchByBnfId(contno, "", "1");
/*      */     try
/*      */     {
/*  815 */       if ((tempContSch != null) && (tempContSch.getInsuredId() != null) && (!tempContSch.getInsuredId().equals("")))
/*      */       {
/*  817 */         PersonFunction pf = new PersonFunction();
/*      */ 
/*  819 */         LNPPersonSchema personSch = pf.getLnpPersonByCustomerId(tempContSch.getInsuredId());
/*      */ 
/*  821 */         if (personSch != null) {
/*  822 */           modifySch.setBnfId(personSch.getCustomerId());
/*  823 */           modifySch.setBnfName(personSch.getName());
/*  824 */           modifySch.setBnfSex(personSch.getSex());
/*  825 */           modifySch.setBnfBirthday(personSch.getBirthday());
/*  826 */           modifySch.setBnfAge(personSch.getAge());
/*  827 */           modifySch.setIDType(personSch.getIDType());
/*  828 */           modifySch.setIDNo(personSch.getIDNo());
/*  829 */           modifySch.setNativePlace(personSch.getNativePlace());
/*  830 */           modifySch.setMarriage(personSch.getMarriage());
/*      */ 
/*  832 */           modifySch.setOccupationCode(personSch.getOccupationCode());
/*      */ 
/*  834 */           modifySch.setOperator(tempGInew.Operator);
/*  835 */           modifySch.setManageCom(tempGInew.ComCode);
/*  836 */           modifySch.setModifyDate(date);
/*  837 */           modifySch.setModifyTime(time);
/*      */ 
/*  839 */           StateOperatorDeal operatorDeal = new StateOperatorDeal();
/*  840 */           List stateList = operatorDeal.infoOperate(tempContSch.getState(), tempContSch.getEditstate(), "add", "06");
/*      */ 
/*  842 */           tempContSch.setState((String)stateList.get(0));
/*  843 */           tempContSch.setEditstate((String)stateList.get(1));
/*      */ 
/*  845 */           tempContSch.setModifyDate(date);
/*  846 */           tempContSch.setModifyTime(time);
/*      */ 
/*  848 */           mmap.put(modifySch, "UPDATE");
/*      */         }
/*      */       }
/*      */     }
/*      */     catch (RuntimeException e) {
/*  853 */       e.printStackTrace();
/*      */     }
/*  855 */     return mmap;
/*      */   }
/*      */ 
/*      */   public boolean afterModifyAppnt(String contNo, boolean b)
/*      */   {
/*  861 */     boolean flag = false;
/*      */     try {
/*  863 */       PolicyMainInfo mainInfo = new PolicyMainInfo();
/*  864 */       LNPContSchema tempContSch = mainInfo.getContByContNo(contNo);
/*  865 */       if ((b) && ((tempContSch.getState().equals("03")) || (tempContSch.getState().equals("05")))) {
/*  866 */         tempContSch.setState("02");
/*      */       }
/*  868 */       if (hasExistRiskWithContNo(contNo)) {
/*  869 */         tempContSch.setEditstate(updateEditStateDone(tempContSch.getEditstate(), 4));
/*      */       }
/*      */ 
/*  873 */       if (riskBounsExist(tempContSch.getContNo()))
/*      */       {
/*  875 */         tempContSch.setEditstate(updateEditStateDone(tempContSch.getEditstate(), 5));
/*      */       }
/*      */ 
/*  878 */       PubSubmit ps = new PubSubmit();
/*  879 */       MMap map = new MMap();
/*      */ 
/*  881 */       map.put(tempContSch, "UPDATE");
/*      */ 
/*  883 */       VData vd = new VData();
/*  884 */       vd = new VData();
/*  885 */       vd.add(map);
/*  886 */       if (ps.submitData(vd, "")) {
/*  887 */         flag = true;
/*      */       }
/*  889 */       System.out.println("-- afterModifyAppnt endflag--" + flag);
/*      */     }
/*      */     catch (RuntimeException e) {
/*  892 */       e.printStackTrace();
/*      */     }
/*      */ 
/*  895 */     return flag;
/*      */   }
/*      */ 
/*      */   private boolean riskBounsExist(String contNo) {
/*  899 */     String sql = "select bonustype from lnpriskconfig  where riskcode = (select riskcode from lnppol where contno='" + 
/*  900 */       contNo + "' and masterpolno =polno);";
/*      */ 
/*  902 */     ExeSQL tExeSQL = new ExeSQL();
/*  903 */     SSRS tSSRS = tExeSQL.execSQL(sql);
/*      */ 
/*  905 */     return (tSSRS != null) && (tSSRS.MaxRow != 0) && (tSSRS.GetText(1, 1) != null) && (!tSSRS.GetText(1, 1).trim().equals(""));
/*      */   }
/*      */ 
/*      */   public boolean afterModifyMainInfo(String contNo)
/*      */   {
/*  916 */     boolean flag = false;
/*  917 */     String date = PubFun.getCurrentDate();
/*  918 */     String time = PubFun.getCurrentTime();
/*  919 */     PubSubmit ps = new PubSubmit();
/*  920 */     MMap map = new MMap();
/*      */     try {
/*  922 */       PolicyMainInfo maininfo = new PolicyMainInfo();
/*  923 */       LNPContSchema lnpcont = maininfo.getContByContNo(contNo);
/*  924 */       if ((lnpcont != null) && (lnpcont.getInsuredId() != null) && (!lnpcont.getInsuredId().equals(""))) {
/*  925 */         map = updateInsuredAge(map, lnpcont);
/*      */       }
/*      */ 
/*  928 */       if ((lnpcont != null) && (lnpcont.getAppntId() != null) && (!lnpcont.getAppntId().equals(""))) {
/*  929 */         map = updateAppntAge(map, lnpcont);
/*      */       }
/*      */ 
/*  935 */       LNPPolDB db = new LNPPolDB();
/*  936 */       db.setContNo(lnpcont.getContNo());
/*  937 */       LNPPolSet polSet = db.query();
/*  938 */       if ((polSet != null) && (polSet.size() > 0)) {
/*  939 */         for (int i = 1; i <= polSet.size(); i++) {
/*  940 */           LNPPolSchema polsch = polSet.get(i);
/*  941 */           polsch.setPrem(0.0D);
/*  942 */           map.put(polsch, "UPDATE");
/*      */         }
/*  944 */         lnpcont.setPrem(0.0D);
/*  945 */         lnpcont.setMult(0.0D);
/*  946 */         lnpcont.setSumPrem(0.0D);
/*  947 */         lnpcont.setAmnt(0.0D);
/*  948 */         List stateList = infoOperate(lnpcont.getState(), lnpcont.getEditstate(), "modify", "04");
/*  949 */         lnpcont.setState((String)stateList.get(0));
/*  950 */         lnpcont.setEditstate((String)stateList.get(1));
/*      */ 
/*  952 */         map.put(lnpcont, "UPDATE");
/*      */       }
/*      */ 
/*  959 */       VData vd = new VData();
/*  960 */       vd = new VData();
/*  961 */       vd.add(map);
/*  962 */       if (ps.submitData(vd, "")) {
/*  963 */         flag = true;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (RuntimeException e)
/*      */     {
/*  970 */       e.printStackTrace();
/*      */     }
/*  972 */     return flag;
/*      */   }
/*      */ 
/*      */   private MMap updateAppntAge(MMap map, LNPContSchema lnpcont)
/*      */   {
/*  977 */     AppntPersonInfo appnt = new AppntPersonInfo();
/*  978 */     LNPAppntSchema appntSch = appnt.getAppntPeopleByContNo(lnpcont.getContNo(), lnpcont.getAppntId());
/*      */ 
/*  980 */     if (appntSch != null) {
/*  981 */       String agePer = LNPPubFun.getAgeByBirthdayNew(appntSch.getAppntBirthday(), lnpcont.getPValiDate());
/*      */ 
/*  983 */       if (!agePer.equals("-1"))
/*      */       {
/*      */         String ageType;
/*  984 */         if (agePer.indexOf("\uFFFD\uFFFD") > -1) {
/*  985 */           String ageType = "D";
/*  986 */           agePer = agePer.substring(0, agePer.indexOf("\uFFFD\uFFFD"));
/*      */ 
/*  988 */           appntSch.setAppntAge(agePer);
/*  989 */           appntSch.setAppntAgeType(ageType);
/*      */         } else {
/*  991 */           ageType = "Y";
/*  992 */           agePer = agePer.substring(0, agePer.indexOf("\uFFFD\uFFFD"));
/*      */ 
/*  994 */           appntSch.setAppntAge(agePer);
/*  995 */           appntSch.setAppntAgeType(ageType);
/*      */         }
/*  997 */         PersonFunction pf = new PersonFunction();
/*  998 */         LNPPersonSchema lnpPersonSchema = pf.getLnpPersonByCustomerId(lnpcont.getAppntId());
/*  999 */         if (lnpPersonSchema != null) {
/* 1000 */           lnpPersonSchema.setAge(agePer);
/* 1001 */           lnpPersonSchema.setAgeType(ageType);
/* 1002 */           map.put(lnpPersonSchema, "UPDATE");
/*      */         }
/*      */       }
/* 1005 */       map.put(appntSch, "UPDATE");
/*      */     }
/* 1007 */     return map;
/*      */   }
/*      */ 
/*      */   private MMap updateInsuredAge(MMap map, LNPContSchema lnpcont)
/*      */   {
/* 1012 */     InsuredPersonInfo insured = new InsuredPersonInfo();
/* 1013 */     LNPInsuredSchema insuredSch = insured.getInsuPeopleByContNo(lnpcont.getContNo(), lnpcont.getInsuredId());
/* 1014 */     LNPInsuredSchema tmpinsuredSch = insuredSch;
/* 1015 */     if (insuredSch != null) {
/* 1016 */       String agePer = LNPPubFun.getAgeByBirthdayNew(insuredSch.getBirthday(), lnpcont.getPValiDate());
/*      */ 
/* 1018 */       if (!agePer.equals("-1"))
/*      */       {
/*      */         String ageType;
/* 1019 */         if (agePer.indexOf("\uFFFD\uFFFD") > -1) {
/* 1020 */           String ageType = "D";
/* 1021 */           agePer = agePer.substring(0, agePer.indexOf("\uFFFD\uFFFD"));
/* 1022 */           insuredSch.setAppAge(agePer);
/* 1023 */           insuredSch.setAppAgeType(ageType);
/*      */         } else {
/* 1025 */           ageType = "Y";
/* 1026 */           agePer = agePer.substring(0, agePer.indexOf("\uFFFD\uFFFD"));
/* 1027 */           insuredSch.setAppAge(agePer);
/* 1028 */           insuredSch.setAppAgeType(ageType);
/*      */         }
/* 1030 */         PersonFunction pf = new PersonFunction();
/* 1031 */         LNPPersonSchema lnpPersonSchema = pf.getLnpPersonByCustomerId(lnpcont.getInsuredId());
/* 1032 */         if (lnpPersonSchema != null) {
/* 1033 */           lnpPersonSchema.setAge(agePer);
/* 1034 */           lnpPersonSchema.setAgeType(ageType);
/* 1035 */           map.put(lnpPersonSchema, "UPDATE");
/*      */         }
/*      */       }
/*      */ 
/* 1039 */       map.put(insuredSch, "UPDATE");
/*      */ 
/* 1041 */       this.ageChangeToJuvenilesFlag = checkAgeChangeToJuveniles(tmpinsuredSch, insuredSch.getAppAge(), insuredSch.getAppAgeType());
/*      */     }
/*      */ 
/* 1044 */     return map;
/*      */   }
/*      */ 
/*      */   private boolean checkAgeChangeToJuveniles(LNPInsuredSchema tempmodifyInsuPeopleSchema, int appAge, String appAgeType) {
/* 1048 */     boolean flag = false;
/*      */ 
/* 1050 */     String relationToInsured = "";
/* 1051 */     String sql = "select relationtoinsured from lnpappnt where contno='" + tempmodifyInsuPeopleSchema.getContNo() + "'";
/* 1052 */     ExeSQL tExeSQL = new ExeSQL();
/* 1053 */     SSRS tSSRS = tExeSQL.execSQL(sql);
/* 1054 */     if ((tSSRS != null) && (tSSRS.getMaxRow() > 0))
/*      */     {
/* 1056 */       relationToInsured = tSSRS.GetText(1, 1);
/*      */     }
/* 1058 */     else return flag;
/*      */ 
/* 1062 */     if ("D".equals(tempmodifyInsuPeopleSchema.getAppAgeType())) {
/* 1063 */       flag = false;
/*      */     }
/*      */ 
/* 1066 */     if ("Y".equals(tempmodifyInsuPeopleSchema.getAppAgeType()))
/*      */     {
/* 1068 */       if (tempmodifyInsuPeopleSchema.getAppAge() >= 16)
/*      */       {
/* 1070 */         if ((("D".equals(appAgeType)) || (("Y".equals(appAgeType)) && (appAge < 16))) && ("0".equals(relationToInsured))) {
/* 1071 */           flag = true;
/*      */         }
/* 1073 */         else if ((("D".equals(appAgeType)) || (("Y".equals(appAgeType)) && (appAge < 10))) && (!"5".equals(relationToInsured)) && (!"6".equals(relationToInsured))) {
/* 1074 */           flag = true;
/*      */         }
/*      */       }
/* 1077 */       else if (((tempmodifyInsuPeopleSchema.getAppAge() < 16) || (tempmodifyInsuPeopleSchema.getAppAge() >= 10)) && 
/* 1078 */         (!"5".equals(relationToInsured)) && (!"6".equals(relationToInsured)))
/*      */       {
/* 1080 */         if (("D".equals(appAgeType)) || (("Y".equals(appAgeType)) && (appAge < 10))) {
/* 1081 */           flag = true;
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1087 */     return flag;
/*      */   }
/*      */ 
/*      */   private boolean hasExistRiskWithContNo(String cno)
/*      */   {
/* 1092 */     boolean flag = false;
/* 1093 */     String sql = "select * from lnppol where contno = '" + cno + "' ";
/* 1094 */     ExeSQL tExESQL = new ExeSQL();
/* 1095 */     SSRS tSSRS = tExESQL.execSQL(sql);
/* 1096 */     if ((tSSRS != null) && (tSSRS.MaxRow > 0)) {
/* 1097 */       flag = true;
/*      */     }
/* 1099 */     return flag;
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.StateOperatorDeal
 * JD-Core Version:    0.6.0
 */