/*     */ package com.sinosoft.banklns.utility;
/*     */ 
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.util.Calendar;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ class TestClock extends JFrame
/*     */ {
/*  50 */   JPanel panel = new JPanel(new BorderLayout());
/*  51 */   JPanel panel1 = new JPanel();
/*  52 */   JPanel panel2 = new JPanel(new GridLayout(7, 7));
/*  53 */   JPanel panel3 = new JPanel();
/*  54 */   JLabel[] label = new JLabel[49];
/*  55 */   JLabel y_label = new JLabel("\u951F\u65A4\u62F7\u951F\uFFFD");
/*  56 */   JLabel m_label = new JLabel("\u951F\u94F0\u51E4\u62F7");
/*  57 */   JComboBox com1 = new JComboBox();
/*  58 */   JComboBox com2 = new JComboBox();
/*  59 */   JButton button = new JButton("\u951F\u4ECB\u770B");
/*     */   int re_year;
/*     */   int re_month;
/*     */   int x_size;
/*     */   int y_size;
/*     */   String year_num;
/*  63 */   Calendar now = Calendar.getInstance();
/*     */ 
/*     */   TestClock() {
/*  66 */     super("\u951F\u65A4\u62F7\u951F\u65A4\u62F7\u951F\u65A4\u62F7");
/*  67 */     setSize(300, 350);
/*  68 */     this.x_size = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
/*  69 */     this.y_size = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
/*  70 */     setLocation((this.x_size - 300) / 2, (this.y_size - 350) / 2);
/*  71 */     setDefaultCloseOperation(3);
/*  72 */     this.panel1.add(this.y_label);
/*  73 */     this.panel1.add(this.com1);
/*  74 */     this.panel1.add(this.m_label);
/*  75 */     this.panel1.add(this.com2);
/*  76 */     this.panel1.add(this.button);
/*  77 */     for (int i = 0; i < 49; i++)
/*     */     {
/*  79 */       this.label[i] = new JLabel("", 0);
/*  80 */       this.panel2.add(this.label[i]);
/*     */     }
/*  82 */     this.panel3.add(new Clock(this));
/*  83 */     this.panel.add(this.panel1, "North");
/*  84 */     this.panel.add(this.panel2, "Center");
/*  85 */     this.panel.add(this.panel3, "South");
/*  86 */     this.panel.setBackground(Color.white);
/*  87 */     this.panel1.setBackground(Color.white);
/*  88 */     this.panel2.setBackground(Color.white);
/*  89 */     this.panel3.setBackground(Color.white);
/*  90 */     Init();
/*  91 */     this.button.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e)
/*     */       {
/*  96 */         int c_year = Integer.parseInt(TestClock.this.com1.getSelectedItem().toString());
/*     */ 
/*  98 */         int c_month = Integer.parseInt(TestClock.this.com2.getSelectedItem().toString()) - 1;
/*  99 */         int c_week = TestClock.this.use(c_year, c_month);
/* 100 */         TestClock.this.Resetday(c_week, c_year, c_month);
/*     */       }
/*     */     });
/* 102 */     setContentPane(this.panel);
/* 103 */     setVisible(true);
/* 104 */     setResizable(false);
/*     */   }
/*     */ 
/*     */   public void Init()
/*     */   {
/* 109 */     String[] log = { "\u951F\u65A4\u62F7", "\u4E00", "\u951F\u65A4\u62F7", "\u951F\u65A4\u62F7", "\u951F\u65A4\u62F7", "\u951F\u65A4\u62F7", "\u951F\u65A4\u62F7" };
/* 110 */     for (int i = 0; i < 7; i++)
/*     */     {
/* 112 */       this.label[i].setText(log[i]);
/*     */     }
/* 114 */     for (int i = 0; i < 49; i += 7)
/*     */     {
/* 116 */       this.label[i].setForeground(Color.red);
/*     */     }
/* 118 */     for (int i = 6; i < 49; i += 7)
/*     */     {
/* 120 */       this.label[i].setForeground(Color.green);
/*     */     }
/*     */ 
/* 123 */     for (int i = 1; i < 10000; i++)
/*     */     {
/* 125 */       this.com1.addItem(i);
/*     */     }
/* 127 */     for (int i = 1; i < 13; i++)
/*     */     {
/* 129 */       this.com2.addItem(i);
/*     */     }
/* 131 */     int month_num = this.now.get(2);
/*     */ 
/* 133 */     int year = this.now.get(1);
/* 134 */     this.com1.setSelectedIndex(year - 1);
/* 135 */     this.com2.setSelectedIndex(month_num);
/* 136 */     int first_day_num = use(year, month_num);
/* 137 */     Resetday(first_day_num, year, month_num);
/*     */   }
/*     */ 
/*     */   public int use(int reyear, int remonth)
/*     */   {
/* 142 */     this.now.set(reyear, remonth, 1);
/* 143 */     int week_num = this.now.get(7);
/*     */ 
/* 145 */     return week_num;
/*     */   }
/*     */ 
/*     */   public void Resetday(int week_log, int year_log, int month_log)
/*     */   {
/* 152 */     int month_score_log = 0;
/* 153 */     int month_day_score = 0;
/* 154 */     int count = 1;
/* 155 */     if (((year_log % 4 == 0) && (year_log % 100 != 0)) || (year_log % 400 == 0))
/*     */     {
/* 157 */       month_score_log = 1;
/*     */     }
/* 159 */     month_log++;
/* 160 */     switch (month_log)
/*     */     {
/*     */     case 1:
/*     */     case 3:
/*     */     case 5:
/*     */     case 7:
/*     */     case 8:
/*     */     case 10:
/*     */     case 12:
/* 169 */       month_day_score = 31;
/* 170 */       break;
/*     */     case 4:
/*     */     case 6:
/*     */     case 9:
/*     */     case 11:
/* 175 */       month_day_score = 30;
/* 176 */       break;
/*     */     case 2:
/* 178 */       if (month_score_log == 1)
/*     */       {
/* 180 */         month_day_score = 29;
/*     */       }
/*     */       else
/*     */       {
/* 184 */         month_day_score = 28;
/*     */       }
/*     */     }
/*     */ 
/* 188 */     for (int i = 7; i < 49; i++)
/*     */     {
/* 190 */       this.label[i].setText("");
/*     */     }
/* 192 */     week_log += 6;
/* 193 */     month_day_score += week_log;
/* 194 */     for (int i = week_log; i < month_day_score; count++)
/*     */     {
/* 196 */       this.label[i].setText(count);
/*     */ 
/* 194 */       i++;
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 202 */     TestClock start = new TestClock();
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.TestClock
 * JD-Core Version:    0.6.0
 */