/*      */ package com.sinosoft.banklns.lnsmodel;
/*      */ 
/*      */ import com.sinosoft.banklns.lis.db.LNPCalModeDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPDutyDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPDutyGetDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPDutyPayDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPPolDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPRiskAppDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPRiskCodeDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPRiskParamDB;
/*      */ import com.sinosoft.banklns.lis.db.LNPSysVarDB;
/*      */ import com.sinosoft.banklns.lis.schema.LNPDutyGetSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPDutyPaySchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPDutySchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPPolSchema;
/*      */ import com.sinosoft.banklns.lis.schema.LNPRiskParamSchema;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPDutyGetSet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPDutyPaySet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPDutySet;
/*      */ import com.sinosoft.banklns.lis.vschema.LNPRiskParamSet;
/*      */ import com.sinosoft.banklns.lnsmodel.util.ForSpcCalImpl;
/*      */ import com.sinosoft.banklns.lnsmodel.util.PolElementSchema;
/*      */ import com.sinosoft.banklns.utility.EvalJavaTool;
/*      */ import com.sinosoft.banklns.utility.ExeSQL;
/*      */ import com.sinosoft.banklns.utility.PubFun;
/*      */ import com.sinosoft.banklns.utility.StrTool;
/*      */ import java.util.Hashtable;
/*      */ 
/*      */ public class InsuCoreImpl
/*      */ {
/*      */   public double calAmnt(PolElementSchema inPolElementSchema, String dutyCode)
/*      */     throws Exception
/*      */   {
/*   77 */     LNPDutyDB reLNPDutyDB = new LNPDutyDB();
/*   78 */     reLNPDutyDB.setDutyCode(dutyCode);
/*   79 */     reLNPDutyDB.getInfo();
/*   80 */     String calFlag = reLNPDutyDB.getCalMode();
/*      */ 
/*   82 */     String sql = "select * from lnpdutyget where getdutycode = (select  getdutycode from LnpDutyGetRela where dutycode='" + 
/*   84 */       inPolElementSchema.getDutyCode() + "')";
/*   85 */     LNPDutyGetDB ewLNPDutyGetDB = new LNPDutyGetDB();
/*   86 */     LNPDutyGetSet ewLNPDutyGetSet = ewLNPDutyGetDB.executeQuery(sql);
/*   87 */     ewLNPDutyGetDB = ewLNPDutyGetSet.get(1).getDB();
/*      */ 
/*   89 */     String calCode = null;
/*   90 */     if ("P".equals(calFlag))
/*      */     {
/*   92 */       calCode = ewLNPDutyGetDB.getCalCode();
/*   93 */     } else if (("G".equals(calFlag)) || ("I".equals(calFlag)))
/*      */     {
/*   95 */       calCode = ewLNPDutyGetDB.getCnterCalCode();
/*   96 */     } else if ("O".equals(calFlag))
/*      */     {
/*   98 */       calCode = ewLNPDutyGetDB.getOthCalCode();
/*      */     }
/*      */ 
/*  101 */     LNPCalModeDB reLNPCalModeDB = new LNPCalModeDB();
/*  102 */     reLNPCalModeDB.setCalCode(calCode);
/*  103 */     reLNPCalModeDB.getInfo();
/*  104 */     String calsql = reLNPCalModeDB.getCalSQL();
/*      */ 
/*  107 */     calsql = transportExpression(calsql, inPolElementSchema);
/*      */ 
/*  109 */     ExeSQL stExeSQL = new ExeSQL();
/*  110 */     String resultstr = stExeSQL.getOneValue(calsql);
/*      */ 
/*  112 */     double result = 0.0D;
/*  113 */     if ((resultstr == null) || (resultstr.equals("")) || 
/*  114 */       (resultstr.equals("null")))
/*  115 */       result = 0.0D;
/*      */     else {
/*  117 */       result = Double.parseDouble(resultstr);
/*      */     }
/*      */ 
/*  120 */     if ((ewLNPDutyGetDB.getZeroFlag().equals("N")) && (result == 0.0D))
/*      */     {
/*  122 */       throw new Exception("\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD4\uFFFD\u0131\uFFFD\uFFFD\uECBB\uFFFD\uFFFD\u03AA0.");
/*      */     }
/*      */ 
/*  126 */     return result;
/*      */   }
/*      */ 
/*      */   public double calPrem(PolElementSchema inPolElementSchema, String dutyCode)
/*      */     throws Exception
/*      */   {
/*  141 */     String sql = "select * from lnpdutypay where payplancode = (select  payplancode from LNPDutyPayRela where dutycode='" + 
/*  143 */       inPolElementSchema.getDutyCode() + "')";
/*  144 */     LNPDutyPayDB erLNPDutyPayDB = new LNPDutyPayDB();
/*  145 */     LNPDutyPaySet erLMDutyPaySet = erLNPDutyPayDB.executeQuery(sql);
/*  146 */     erLNPDutyPayDB = erLMDutyPaySet.get(1).getDB();
/*      */ 
/*  149 */     int payintInt = erLNPDutyPayDB.getPayIntv();
/*  150 */     if (payintInt != -1)
/*      */     {
/*  152 */       inPolElementSchema.setPayIntv(payintInt);
/*      */     }
/*  154 */     if (inPolElementSchema.getPayIntv() == 0)
/*      */     {
/*  156 */       inPolElementSchema.setPayEndYear(1000);
/*  157 */       inPolElementSchema.setPayYears(1);
/*  158 */       inPolElementSchema.setPayEndYearFlag("Y");
/*      */     }
/*      */ 
/*  198 */     double result = 0.0D;
/*  199 */     return result;
/*      */   }
/*      */ 
/*      */   public double calExtFee(PolElementSchema inPolElementSchema)
/*      */     throws Exception
/*      */   {
/*  271 */     double result = 0.0D;
/*  272 */     return result;
/*      */   }
/*      */ 
/*      */   public String calcuteAmntAndPrem(PolElementSchema inPolElementSchema, String flag)
/*      */   {
/*  465 */     String resultStr = "";
/*  466 */     return resultStr;
/*      */   }
/*      */ 
/*      */   public PolElementSchema calcutePol(PolElementSchema inPolElementSchema)
/*      */   {
/*  473 */     inPolElementSchema = preparePolInitData(inPolElementSchema);
/*      */ 
/*  476 */     inPolElementSchema = dealPolData(inPolElementSchema, inPolElementSchema
/*  477 */       .getDutyCode());
/*      */ 
/*  480 */     double get = 0.0D;
/*      */     try {
/*  482 */       get = calAmnt(inPolElementSchema, inPolElementSchema.getDutyCode());
/*      */     } catch (Exception e) {
/*  484 */       e.printStackTrace();
/*  485 */       get = 0.0D;
/*      */     }
/*      */ 
/*  488 */     inPolElementSchema.setGet(get);
/*  489 */     inPolElementSchema.setAmnt(get);
/*      */ 
/*  491 */     double prem = 0.0D;
/*      */     try
/*      */     {
/*  497 */       prem = calPrem(inPolElementSchema, inPolElementSchema.getDutyCode());
/*  498 */       prem = 0.0D;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  510 */       e.printStackTrace();
/*  511 */       prem = 0.0D;
/*      */     }
/*      */ 
/*  514 */     inPolElementSchema.setPrem(prem);
/*      */     try
/*      */     {
/*  518 */       savePolData(inPolElementSchema);
/*      */     } catch (Exception e) {
/*  520 */       e.printStackTrace();
/*      */     }
/*  522 */     return inPolElementSchema;
/*      */   }
/*      */ 
/*      */   private String transportExpression(String oriStr, PolElementSchema inPolElementSchema)
/*      */   {
/*  528 */     if ((oriStr == null) || (oriStr.length() == 0)) {
/*  529 */       return "";
/*      */     }
/*  531 */     oriStr = StrTool.replace(oriStr, "?InsuredId?", inPolElementSchema
/*  532 */       .getInsuredId());
/*  533 */     oriStr = 
/*  534 */       StrTool.replace(oriStr, "?Name?", inPolElementSchema.getName());
/*  535 */     oriStr = StrTool.replace(oriStr, "?Sex?", inPolElementSchema.getSex());
/*  536 */     oriStr = StrTool.replace(oriStr, "?Birthday?", inPolElementSchema
/*  537 */       .getBirthday());
/*  538 */     oriStr = StrTool.replace(oriStr, "?OccupationCode?", inPolElementSchema
/*  539 */       .getOccupationCode());
/*  540 */     oriStr = StrTool.replace(oriStr, "?AppAge?", inPolElementSchema
/*  541 */       .getAppAge());
/*      */ 
/*  543 */     oriStr = StrTool.replace(oriStr, "?AppAgeType?", inPolElementSchema
/*  544 */       .getAppAgeType());
/*      */ 
/*  546 */     oriStr = StrTool.replace(oriStr, "?RelationToAppnt?", 
/*  547 */       inPolElementSchema.getRelationToAppnt());
/*  548 */     oriStr = StrTool.replace(oriStr, "?InsuredNativePlace?", 
/*  549 */       inPolElementSchema.getInsuredNativePlace());
/*  550 */     oriStr = StrTool.replace(oriStr, "?InsuredNo2?", inPolElementSchema
/*  551 */       .getInsuredNo2());
/*  552 */     oriStr = StrTool.replace(oriStr, "?AppAge2?", inPolElementSchema
/*  553 */       .getAppAge2());
/*  554 */     oriStr = StrTool.replace(oriStr, "?AppAge2Type?", inPolElementSchema
/*  555 */       .getAppAge2Type());
/*  556 */     oriStr = StrTool.replace(oriStr, "?AppntId?", inPolElementSchema
/*  557 */       .getAppntId());
/*  558 */     oriStr = StrTool.replace(oriStr, "?AppntNativePlace?", 
/*  559 */       inPolElementSchema.getAppntNativePlace());
/*  560 */     oriStr = StrTool.replace(oriStr, "?AppntOccupationCode?", 
/*  561 */       inPolElementSchema.getAppntOccupationCode());
/*  562 */     oriStr = StrTool.replace(oriStr, "?AppntAge?", inPolElementSchema
/*  563 */       .getAppntAge());
/*      */ 
/*  565 */     oriStr = StrTool.replace(oriStr, "?AppntAgeType?", inPolElementSchema
/*  566 */       .getAppntAgeType());
/*      */ 
/*  568 */     oriStr = StrTool.replace(oriStr, "?AppntSex?", inPolElementSchema
/*  569 */       .getAppntSex());
/*  570 */     oriStr = StrTool.replace(oriStr, "?RiskChannel?", inPolElementSchema
/*  571 */       .getRiskChannel());
/*  572 */     oriStr = StrTool.replace(oriStr, "?ManageCom?", inPolElementSchema
/*  573 */       .getManageCom());
/*  574 */     oriStr = StrTool.replace(oriStr, "?MainPolNo?", inPolElementSchema
/*  575 */       .getMainPolNo());
/*  576 */     oriStr = StrTool.replace(oriStr, "?MainPolAmnt?", inPolElementSchema
/*  577 */       .getMainPolAmnt());
/*  578 */     oriStr = StrTool.replace(oriStr, "?ContNo?", inPolElementSchema
/*  579 */       .getContNo());
/*  580 */     oriStr = StrTool.replace(oriStr, "?DutyCode?", inPolElementSchema
/*  581 */       .getDutyCode());
/*  582 */     oriStr = StrTool.replace(oriStr, "?RiskCode?", inPolElementSchema
/*  583 */       .getRiskCode());
/*  584 */     oriStr = StrTool.replace(oriStr, "?PolNo?", inPolElementSchema
/*  585 */       .getPolNo());
/*  586 */     oriStr = StrTool.replace(oriStr, "?Amnt?", inPolElementSchema.getAmnt());
/*      */ 
/*  588 */     oriStr = StrTool.replace(oriStr, "?TopUpPrem?", inPolElementSchema.getTopUpPrem());
/*      */ 
/*  590 */     oriStr = StrTool.replace(oriStr, "?DeadAmntType?", inPolElementSchema.getDeadAmntType());
/*      */ 
/*  592 */     oriStr = StrTool.replace(oriStr, "?Get?", inPolElementSchema.getGet());
/*      */ 
/*  594 */     oriStr = StrTool.replace(oriStr, "?Mult?", inPolElementSchema.getMult());
/*      */ 
/*  596 */     oriStr = StrTool.replace(oriStr, "?Prem?", inPolElementSchema.getPrem());
/*      */ 
/*  598 */     oriStr = StrTool.replace(oriStr, "?StandardPrem?", inPolElementSchema
/*  599 */       .getStandardPrem());
/*      */ 
/*  601 */     oriStr = StrTool.replace(oriStr, "?Vpu?", inPolElementSchema.getVPU());
/*  602 */     oriStr = StrTool.replace(oriStr, "?PayEndYear?", inPolElementSchema
/*  603 */       .getPayEndYear());
/*      */ 
/*  605 */     oriStr = StrTool.replace(oriStr, "?PayEndYearFlag?", inPolElementSchema
/*  606 */       .getPayEndYearFlag());
/*  607 */     oriStr = StrTool.replace(oriStr, "?GetYear?", inPolElementSchema
/*  608 */       .getGetYear());
/*      */ 
/*  610 */     oriStr = StrTool.replace(oriStr, "?GetYearFlag?", inPolElementSchema
/*  611 */       .getGetYearFlag());
/*  612 */     oriStr = StrTool.replace(oriStr, "?InsuYear?", inPolElementSchema
/*  613 */       .getInsuYear());
/*      */ 
/*  615 */     oriStr = StrTool.replace(oriStr, "?InsuYearFlag?", inPolElementSchema
/*  616 */       .getInsuYearFlag());
/*  617 */     oriStr = StrTool.replace(oriStr, "?PayIntv?", inPolElementSchema
/*  618 */       .getPayIntv());
/*      */ 
/*  620 */     oriStr = StrTool.replace(oriStr, "?GetIntv?", inPolElementSchema
/*  621 */       .getGetIntv());
/*      */ 
/*  623 */     oriStr = StrTool.replace(oriStr, "?Years?", inPolElementSchema
/*  624 */       .getYears());
/*      */ 
/*  626 */     oriStr = StrTool.replace(oriStr, "?PayYears?", inPolElementSchema
/*  627 */       .getPayYears());
/*      */ 
/*  629 */     oriStr = StrTool.replace(oriStr, "?LiveGetMode?", inPolElementSchema
/*  630 */       .getLiveGetMode());
/*  631 */     oriStr = StrTool.replace(oriStr, "?SubRiskFlag?", inPolElementSchema
/*  632 */       .getSubRiskFlag());
/*  633 */     oriStr = StrTool.replace(oriStr, "?BonusGetMode?", inPolElementSchema
/*  634 */       .getBonusGetMode());
/*  635 */     oriStr = StrTool.replace(oriStr, "?StandByFlag1?", inPolElementSchema
/*  636 */       .getStandbyFlag1());
/*  637 */     oriStr = StrTool.replace(oriStr, "?StandByFlag2?", inPolElementSchema
/*  638 */       .getStandbyFlag2());
/*  639 */     oriStr = StrTool.replace(oriStr, "?StandByFlag3?", inPolElementSchema
/*  640 */       .getStandbyFlag3());
/*  641 */     oriStr = StrTool.replace(oriStr, "?RiskAmnt?", inPolElementSchema
/*  642 */       .getRiskAmnt());
/*      */ 
/*  644 */     oriStr = StrTool.replace(oriStr, "?SumLifeRiskAmnt?", 
/*  645 */       inPolElementSchema.getSumLifeRiskAmnt());
/*  646 */     oriStr = StrTool.replace(oriStr, "?SumAccRiskAmnt?", inPolElementSchema
/*  647 */       .getSumAccRiskAmnt());
/*      */ 
/*  649 */     oriStr = StrTool.replace(oriStr, "?SumDeaRiskAmnt?", inPolElementSchema
/*  650 */       .getSumDeaRiskAmnt());
/*      */ 
/*  652 */     oriStr = StrTool.replace(oriStr, "?SumBodRiskAmnt?", inPolElementSchema
/*  653 */       .getSumBodRiskAmnt());
/*      */ 
/*  655 */     return oriStr;
/*      */   }
/*      */ 
/*      */   private PolElementSchema preparePolInitData(PolElementSchema inPolElementSchema)
/*      */   {
/*  666 */     LNPSysVarDB tLNPSysVarDB = new LNPSysVarDB();
/*  667 */     tLNPSysVarDB.setSysVar("GrpContNo");
/*  668 */     tLNPSysVarDB.getInfo();
/*  669 */     inPolElementSchema.setGrpContNo(tLNPSysVarDB.getSysVarValue());
/*      */ 
/*  672 */     inPolElementSchema.setGrpPolNo(tLNPSysVarDB.getSysVarValue());
/*      */ 
/*  675 */     tLNPSysVarDB.setSysVar("PrtNo");
/*  676 */     tLNPSysVarDB.getInfo();
/*  677 */     inPolElementSchema.setPrtNo(tLNPSysVarDB.getSysVarValue());
/*      */ 
/*  681 */     inPolElementSchema.setProposalContNo(inPolElementSchema.getContNo());
/*      */ 
/*  684 */     if ((inPolElementSchema.getPolNo() == null) || 
/*  685 */       (inPolElementSchema.getPolNo().length() == 0))
/*      */     {
/*  692 */       LNPRiskCodeDB tLNPRiskCodeDB = new LNPRiskCodeDB();
/*  693 */       tLNPRiskCodeDB.setRiskCode(inPolElementSchema.getRiskCode());
/*  694 */       String sysRiskCode = "9999";
/*  695 */       if (tLNPRiskCodeDB.getInfo())
/*      */       {
/*  697 */         sysRiskCode = tLNPRiskCodeDB.getSysRiskCode();
/*      */       }
/*      */ 
/*  700 */       inPolElementSchema.setPolNo(inPolElementSchema.getContNo() + sysRiskCode);
/*      */     }
/*      */ 
/*  704 */     inPolElementSchema.setProposalNo(inPolElementSchema.getPolNo());
/*      */ 
/*  706 */     LNPRiskAppDB tLNPRiskAppDB = new LNPRiskAppDB();
/*  707 */     tLNPRiskAppDB.setRiskCode(inPolElementSchema.getRiskCode());
/*  708 */     tLNPRiskAppDB.getInfo();
/*      */ 
/*  710 */     if ("M".endsWith(tLNPRiskAppDB.getSubRiskFlag()))
/*      */     {
/*  712 */       inPolElementSchema.setMasterPolNo(inPolElementSchema.getPolNo());
/*      */     }
/*  714 */     else "S".endsWith(tLNPRiskAppDB.getSubRiskFlag());
/*      */ 
/*  740 */     inPolElementSchema.setGet(inPolElementSchema.getAmnt());
/*      */ 
/*  773 */     LNPRiskAppDB reLNPRiskAppDB = new LNPRiskAppDB();
/*  774 */     reLNPRiskAppDB.setRiskCode(inPolElementSchema.getRiskCode());
/*  775 */     reLNPRiskAppDB.getInfo();
/*  776 */     inPolElementSchema.setSubRiskFlag(reLNPRiskAppDB.getSubRiskFlag());
/*      */ 
/*  778 */     if ("S".equals(inPolElementSchema.getSubRiskFlag())) {
/*  779 */       int oldpayintv = inPolElementSchema.getPayIntv();
/*      */ 
/*  782 */       LNPRiskParamDB tLNPRiskParamDB = new LNPRiskParamDB();
/*  783 */       tLNPRiskParamDB.setType("RelaToMainRisk");
/*  784 */       tLNPRiskParamDB.setRiskCode(inPolElementSchema.getRiskCode());
/*  785 */       LNPRiskParamSet tLNPRiskParamSet = tLNPRiskParamDB.query();
/*      */ 
/*  787 */       LNPPolDB mainLNPPolDB = new LNPPolDB();
/*  788 */       mainLNPPolDB.setPolNo(inPolElementSchema.getMasterPolNo());
/*      */ 
/*  791 */       if ((mainLNPPolDB.getInfo()) && (tLNPRiskParamSet != null) && 
/*  792 */         (tLNPRiskParamSet.size() > 0)) {
/*  793 */         for (int i = 1; i <= tLNPRiskParamSet.size(); i++) {
/*  794 */           LNPRiskParamSchema tempLNPRiskParamSchema = tLNPRiskParamSet
/*  795 */             .get(i);
/*  796 */           String result = getDataFromMainPol(tempLNPRiskParamSchema, 
/*  797 */             mainLNPPolDB);
/*  798 */           if ((result == null) || (result.equals("null")) || 
/*  799 */             (result.equals(""))) {
/*      */             continue;
/*      */           }
/*  802 */           String param = tempLNPRiskParamSchema.getParam();
/*  803 */           if (param.equals("Amnt")) {
/*  804 */             inPolElementSchema.setAmnt(Double.parseDouble(result));
/*  805 */             inPolElementSchema.setGet(Double.parseDouble(result));
/*  806 */           } else if (param.equals("Get")) {
/*  807 */             inPolElementSchema.setAmnt(Double.parseDouble(result));
/*  808 */             inPolElementSchema.setGet(Double.parseDouble(result));
/*  809 */           } else if (param.equals("Prem")) {
/*  810 */             inPolElementSchema.setPrem(Double.parseDouble(result));
/*  811 */           } else if (param.equals("Mult")) {
/*  812 */             inPolElementSchema.setMult(Double.parseDouble(result));
/*  813 */           } else if (param.equals("PayIntv"))
/*      */           {
/*  815 */             oldpayintv = inPolElementSchema.getPayIntv();
/*      */ 
/*  818 */             inPolElementSchema.setPayIntv(Integer.parseInt(result));
/*      */ 
/*  821 */             int newpayintv = inPolElementSchema.getPayIntv();
/*  822 */             String riskcode = inPolElementSchema.getRiskCode();
/*  823 */             if ((inPolElementSchema.getPayEndYear() != 1000) || (newpayintv == 0) || 
/*  824 */               (!"ADR".equals(riskcode)) || 
/*  825 */               (!"PWA".equals(mainLNPPolDB.getRiskCode()))) continue;
/*  826 */             inPolElementSchema.setPayEndYear(5);
/*  827 */             inPolElementSchema.setPayEndYearFlag("Y");
/*      */           }
/*  830 */           else if (param.equals("InsuYear")) {
/*  831 */             inPolElementSchema
/*  832 */               .setInsuYear(Integer.parseInt(result));
/*  833 */           } else if (param.equals("InsuYearFlag")) {
/*  834 */             inPolElementSchema.setInsuYearFlag(result);
/*  835 */           } else if (param.equals("PayEndYear")) {
/*  836 */             inPolElementSchema.setPayEndYear(
/*  837 */               Integer.parseInt(result));
/*  838 */           } else if (param.equals("PayEndYearFlag")) {
/*  839 */             inPolElementSchema.setPayEndYearFlag(result);
/*  840 */           } else if (param.equals("LiveGetMode")) {
/*  841 */             inPolElementSchema.setLiveGetMode(result);
/*  842 */           } else if (param.equals("StandbyFlag1")) {
/*  843 */             inPolElementSchema.setStandbyFlag1(result);
/*  844 */           } else if (param.equals("StandbyFlag2")) {
/*  845 */             inPolElementSchema.setStandbyFlag2(result);
/*  846 */           } else if (param.equals("StandbyFlag3")) {
/*  847 */             inPolElementSchema.setStandbyFlag3(result);
/*      */           }
/*      */ 
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*  854 */       if ((oldpayintv != 0) || (mainLNPPolDB.getPayIntv() == 0))
/*      */       {
/*  857 */         inPolElementSchema.setPayIntv(mainLNPPolDB.getPayIntv());
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/*  862 */       inPolElementSchema.setSubRiskFlag("M");
/*      */     }
/*      */ 
/*  868 */     String sql = "SELECT * FROM lnpduty where dutycode in (select dutycode from lnpriskduty where riskcode='" + 
/*  870 */       inPolElementSchema.getRiskCode() + "')";
/*  871 */     LNPDutyDB reLNPDutyDB = new LNPDutyDB();
/*  872 */     LNPDutySet reLNPDutySet = reLNPDutyDB.executeQuery(sql);
/*  873 */     reLNPDutyDB = reLNPDutySet.get(1).getDB();
/*      */ 
/*  875 */     inPolElementSchema.setDutyCode(reLNPDutyDB.getDutyCode());
/*      */ 
/*  877 */     inPolElementSchema.setVPU(reLNPDutyDB.getVPU());
/*      */ 
/*  879 */     String flag = reLNPDutyDB.getInsuYearRela();
/*  880 */     if (flag.equals("4")) {
/*  881 */       inPolElementSchema.setInsuYear(reLNPDutyDB.getInsuYear());
/*  882 */       inPolElementSchema.setInsuYearFlag(reLNPDutyDB.getInsuYearFlag());
/*      */     }
/*      */ 
/*  885 */     flag = reLNPDutyDB.getPayEndYearRela();
/*  886 */     if (flag.equals("4")) {
/*  887 */       inPolElementSchema.setPayEndYear(reLNPDutyDB.getPayEndYear());
/*  888 */       inPolElementSchema
/*  889 */         .setPayEndYearFlag(reLNPDutyDB.getPayEndYearFlag());
/*      */     }
/*      */ 
/*  892 */     flag = reLNPDutyDB.getGetYearRela();
/*  893 */     if (flag.equals("4")) {
/*  894 */       inPolElementSchema.setGetYear(reLNPDutyDB.getGetYear());
/*  895 */       inPolElementSchema.setGetYearFlag(reLNPDutyDB.getGetYearFlag());
/*      */     }
/*      */ 
/*  899 */     return inPolElementSchema;
/*      */   }
/*      */ 
/*      */   private String getDataFromMainPol(LNPRiskParamSchema inLNPRiskParamSchema, LNPPolSchema mainLNPPolShcema)
/*      */   {
/*  905 */     String expression = inLNPRiskParamSchema.getExpression();
/*  906 */     Hashtable reHashtable = new Hashtable();
/*  907 */     reHashtable.put("Amnt", Double.valueOf(mainLNPPolShcema.getAmnt()));
/*      */ 
/*  909 */     reHashtable.put("TopUpPrem", Double.valueOf(mainLNPPolShcema.getTopUpPrem()));
/*  910 */     reHashtable.put("DeadAmntType", mainLNPPolShcema.getDeadAmntType());
/*      */ 
/*  912 */     reHashtable.put("Get", Double.valueOf(mainLNPPolShcema.getAmnt()));
/*  913 */     reHashtable.put("Prem", Double.valueOf(mainLNPPolShcema.getPrem()));
/*  914 */     reHashtable.put("Mult", Double.valueOf(mainLNPPolShcema.getMult()));
/*  915 */     reHashtable.put("PayIntv", Integer.valueOf(mainLNPPolShcema.getPayIntv()));
/*  916 */     reHashtable.put("InsuYear", Integer.valueOf(mainLNPPolShcema.getInsuYear()));
/*  917 */     reHashtable.put("InsuYearFlag", mainLNPPolShcema.getInsuYearFlag());
/*  918 */     reHashtable.put("PayEndYear", Integer.valueOf(mainLNPPolShcema.getPayEndYear()));
/*  919 */     reHashtable.put("PayEndYearFlag", mainLNPPolShcema.getPayEndYearFlag());
/*      */ 
/*  921 */     reHashtable.put("LiveGetMode", mainLNPPolShcema.getLiveGetMode());
/*  922 */     reHashtable.put("StandbyFlag1", mainLNPPolShcema.getStandbyFlag1());
/*  923 */     reHashtable.put("StandbyFlag2", mainLNPPolShcema.getStandbyFlag2());
/*  924 */     reHashtable.put("StandbyFlag3", mainLNPPolShcema.getStandbyFlag3());
/*      */ 
/*  926 */     reHashtable.put("MainRiskCode", mainLNPPolShcema.getRiskCode());
/*      */ 
/*  928 */     EvalJavaTool evalJavaTool = new EvalJavaTool();
/*  929 */     ForSpcCalImpl forSpcCalImpl = new ForSpcCalImpl();
/*      */ 
/*  931 */     reHashtable.put("SpcCalInst", forSpcCalImpl);
/*      */ 
/*  933 */     String result = evalJavaTool.executeByExpress(expression, reHashtable);
/*  934 */     return result;
/*      */   }
/*      */ 
/*      */   private PolElementSchema dealPolData(PolElementSchema inPolElementSchema, String dutyCode)
/*      */   {
/*  941 */     LNPDutyDB reLNPDutyDB = new LNPDutyDB();
/*  942 */     reLNPDutyDB.setDutyCode(dutyCode);
/*  943 */     if (reLNPDutyDB.getInfo())
/*      */     {
/*  946 */       String flag = reLNPDutyDB.getInsuYearRela();
/*  947 */       if (flag.equals("2"))
/*      */       {
/*  950 */         inPolElementSchema.setInsuYear(inPolElementSchema.getGetYear());
/*  951 */         inPolElementSchema.setInsuYearFlag(inPolElementSchema
/*  952 */           .getGetYearFlag());
/*  953 */       } else if (flag.equals("1"))
/*      */       {
/*  956 */         inPolElementSchema.setInsuYear(inPolElementSchema
/*  957 */           .getPayEndYear());
/*  958 */         inPolElementSchema.setInsuYearFlag(inPolElementSchema
/*  959 */           .getPayEndYearFlag());
/*      */       }
/*      */ 
/*  963 */       flag = reLNPDutyDB.getPayEndYearRela();
/*  964 */       if ("2".equals(flag))
/*      */       {
/*  967 */         inPolElementSchema.setPayEndYear(inPolElementSchema
/*  968 */           .getGetYear());
/*  969 */         inPolElementSchema.setPayEndYearFlag(inPolElementSchema
/*  970 */           .getGetYearFlag());
/*  971 */       } else if ("3".equals(flag))
/*      */       {
/*  974 */         inPolElementSchema.setPayEndYear(inPolElementSchema
/*  975 */           .getInsuYear());
/*  976 */         inPolElementSchema.setPayEndYearFlag(inPolElementSchema
/*  977 */           .getInsuYearFlag());
/*      */       }
/*      */ 
/*  981 */       flag = reLNPDutyDB.getGetYearRela();
/*  982 */       if ("1".equals(flag))
/*      */       {
/*  985 */         inPolElementSchema.setGetYear(inPolElementSchema
/*  986 */           .getPayEndYear());
/*  987 */         inPolElementSchema.setGetYearFlag(inPolElementSchema
/*  988 */           .getPayEndYearFlag());
/*  989 */       } else if ("3".equals(flag))
/*      */       {
/*  992 */         inPolElementSchema.setGetYear(inPolElementSchema.getInsuYear());
/*  993 */         inPolElementSchema.setGetYearFlag(inPolElementSchema
/*  994 */           .getInsuYearFlag());
/*      */       }
/*      */ 
/*  998 */       int years = 0;
/*  999 */       if ("Y".equals(inPolElementSchema.getInsuYearFlag()))
/* 1000 */         years = inPolElementSchema.getInsuYear();
/* 1001 */       else if ("A".equals(inPolElementSchema.getInsuYearFlag()))
/*      */       {
/* 1003 */         if ("Y".equals(inPolElementSchema.getAppAgeType()))
/*      */         {
/* 1005 */           years = inPolElementSchema.getInsuYear() - 
/* 1006 */             inPolElementSchema.getAppAge();
/*      */         }
/* 1008 */         else if ("D".equals(inPolElementSchema.getAppAgeType()))
/*      */         {
/* 1011 */           years = inPolElementSchema.getInsuYear() - 
/* 1012 */             0;
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/* 1018 */       inPolElementSchema.setYears(years);
/*      */ 
/* 1022 */       int payyears = 0;
/* 1023 */       if ("Y".equals(inPolElementSchema.getPayEndYearFlag()))
/* 1024 */         payyears = inPolElementSchema.getPayEndYear();
/* 1025 */       else if ("A".equals(inPolElementSchema.getPayEndYearFlag()))
/*      */       {
/* 1027 */         if ("Y".equals(inPolElementSchema.getAppAgeType()))
/*      */         {
/* 1029 */           payyears = inPolElementSchema.getPayEndYear() - 
/* 1030 */             inPolElementSchema.getAppAge();
/*      */         }
/* 1032 */         else if ("D".equals(inPolElementSchema.getAppAgeType()))
/*      */         {
/* 1035 */           payyears = inPolElementSchema.getPayEndYear() - 
/* 1036 */             0;
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/* 1041 */       inPolElementSchema.setPayYears(payyears);
/*      */     }
/* 1043 */     return inPolElementSchema;
/*      */   }
/*      */ 
/*      */   private void savePolData(PolElementSchema inPolElementSchema)
/*      */     throws Exception
/*      */   {
/* 1049 */     LNPPolDB weLNPPolDB = new LNPPolDB();
/*      */ 
/* 1051 */     weLNPPolDB.setGrpContNo(inPolElementSchema.getGrpContNo());
/* 1052 */     weLNPPolDB.setGrpPolNo(inPolElementSchema.getGrpPolNo());
/* 1053 */     weLNPPolDB.setPrtNo(inPolElementSchema.getPrtNo());
/* 1054 */     weLNPPolDB.setProposalContNo(inPolElementSchema.getProposalContNo());
/* 1055 */     weLNPPolDB.setProposalNo(inPolElementSchema.getProposalNo());
/* 1056 */     weLNPPolDB.setContNo(inPolElementSchema.getContNo());
/* 1057 */     weLNPPolDB.setPolNo(inPolElementSchema.getPolNo());
/* 1058 */     weLNPPolDB.setMainPolNo(inPolElementSchema.getMainPolNo());
/* 1059 */     weLNPPolDB.setMasterPolNo(inPolElementSchema.getMasterPolNo());
/* 1060 */     weLNPPolDB.setRiskCode(inPolElementSchema.getRiskCode());
/* 1061 */     weLNPPolDB.setManageCom(inPolElementSchema.getManageCom());
/* 1062 */     weLNPPolDB.setSaleChnl(inPolElementSchema.getRiskChannel());
/* 1063 */     weLNPPolDB.setInsuredId(inPolElementSchema.getInsuredId());
/* 1064 */     weLNPPolDB.setInsuredNo(inPolElementSchema.getInsuredNo());
/*      */ 
/* 1066 */     weLNPPolDB.setGetYear(inPolElementSchema.getGetYear());
/* 1067 */     weLNPPolDB.setGetYearFlag(inPolElementSchema.getGetYearFlag());
/* 1068 */     weLNPPolDB.setPayEndYear(inPolElementSchema.getPayEndYear());
/* 1069 */     weLNPPolDB.setPayEndYearFlag(inPolElementSchema.getPayEndYearFlag());
/* 1070 */     weLNPPolDB.setInsuYear(inPolElementSchema.getInsuYear());
/* 1071 */     weLNPPolDB.setInsuYearFlag(inPolElementSchema.getInsuYearFlag());
/* 1072 */     weLNPPolDB.setPayIntv(inPolElementSchema.getPayIntv());
/* 1073 */     weLNPPolDB.setPayYears(inPolElementSchema.getPayYears());
/* 1074 */     weLNPPolDB.setYears(inPolElementSchema.getYears());
/* 1075 */     weLNPPolDB.setAmnt(inPolElementSchema.getAmnt());
/* 1076 */     weLNPPolDB.setPrem(inPolElementSchema.getPrem());
/*      */ 
/* 1078 */     weLNPPolDB.setTopUpPrem(inPolElementSchema.getTopUpPrem());
/* 1079 */     weLNPPolDB.setDeadAmntType(inPolElementSchema.getDeadAmntType());
/*      */ 
/* 1081 */     weLNPPolDB.setStandPrem(inPolElementSchema.getStandardPrem());
/* 1082 */     weLNPPolDB.setMult(inPolElementSchema.getMult());
/* 1083 */     weLNPPolDB.setLiveGetMode(inPolElementSchema.getLiveGetMode());
/* 1084 */     weLNPPolDB.setBonusGetMode(inPolElementSchema.getBonusGetMode());
/* 1085 */     weLNPPolDB.setSubFlag(inPolElementSchema.getSubRiskFlag());
/*      */ 
/* 1087 */     weLNPPolDB.setOperator(inPolElementSchema.getAgentCode());
/* 1088 */     weLNPPolDB.setStandbyFlag1(inPolElementSchema.getStandbyFlag1());
/* 1089 */     weLNPPolDB.setStandbyFlag2(inPolElementSchema.getStandbyFlag2());
/* 1090 */     weLNPPolDB.setStandbyFlag3(inPolElementSchema.getStandbyFlag3());
/*      */ 
/* 1092 */     weLNPPolDB.setAppFlag("0");
/* 1093 */     weLNPPolDB.setContType("1");
/* 1094 */     weLNPPolDB.setPolTypeFlag("0");
/* 1095 */     weLNPPolDB.setPolState("1");
/*      */ 
/* 1097 */     weLNPPolDB.setSaleChnlDetail(inPolElementSchema.getBranchType());
/*      */ 
/* 1099 */     weLNPPolDB.setMakeDate(inPolElementSchema.getMakeDate());
/* 1100 */     weLNPPolDB.setMakeTime(inPolElementSchema.getMakeTime());
/* 1101 */     String modifydate = PubFun.getCurrentDate();
/* 1102 */     String modifytime = PubFun.getCurrentTime();
/* 1103 */     weLNPPolDB.setModifyDate(modifydate);
/* 1104 */     weLNPPolDB.setModifyTime(modifytime);
/*      */     try
/*      */     {
/* 1108 */       weLNPPolDB.insert();
/*      */     } catch (Exception e) {
/* 1110 */       e.printStackTrace();
/* 1111 */       throw new Exception("\uFFFD\uFFFD\uFFFD\u6C63\uFFFD\uFFFD\uFFFD\uFFFD\uFFFD\u02A7\uFFFD\uFFFD.");
/*      */     }
/*      */   }
/*      */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.lnsmodel.InsuCoreImpl
 * JD-Core Version:    0.6.0
 */