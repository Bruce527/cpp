/*     */ package com.sinosoft.banklns.utility;
/*     */ 
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.SystemColor;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.ComponentAdapter;
/*     */ import java.awt.event.ComponentEvent;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.util.Date;
/*     */ import java.util.GregorianCalendar;
/*     */ import java.util.Locale;
/*     */ import java.util.StringTokenizer;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.JToggleButton;
/*     */ import javax.swing.UIManager;
/*     */ 
/*     */ class JCalendar extends JPanel
/*     */ {
/*  27 */   private int year = 0;
/*  28 */   private int month = 0;
/*  29 */   private int day = 0;
/*  30 */   private JPanel Main = new JPanel();
/*  31 */   private JPanel jPanelDay = new JPanel();
/*  32 */   private JPanel jPanelMonth = new JPanel();
/*  33 */   private JTextField Year = new JTextField();
/*  34 */   private JTextField Month = new JTextField();
/*  35 */   private JButton MonthDown = new JButton();
/*  36 */   private JButton MonthUp = new JButton();
/*     */ 
/*  38 */   private JPanel jPanelButton = new JPanel();
/*  39 */   private JButton YearDown = new JButton();
/*  40 */   private JButton YearUp = new JButton();
/*  41 */   private JLabel Out = new JLabel();
/*  42 */   private Locale l = Locale.CHINESE;
/*  43 */   private GregorianCalendar cal = new GregorianCalendar(this.l);
/*  44 */   private JPanel weekPanel = new JPanel();
/*  45 */   private JToggleButton[] days = new JToggleButton[42];
/*  46 */   private JPanel Days = new JPanel();
/*  47 */   private JLabel jLabel1 = new JLabel();
/*  48 */   private JLabel jLabel2 = new JLabel();
/*  49 */   private JLabel jLabel3 = new JLabel();
/*  50 */   private JLabel jLabel4 = new JLabel();
/*  51 */   private JLabel jLabel5 = new JLabel();
/*  52 */   private JLabel jLabel6 = new JLabel();
/*  53 */   private JLabel jLabel7 = new JLabel();
/*  54 */   private JToggleButton cur = null;
/*  55 */   private int[] mm = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
/*     */ 
/*     */   public JCalendar() {
/*     */     try {
/*  59 */       jbInit();
/*     */     }
/*     */     catch (Exception e) {
/*  62 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public JCalendar(int year, int month, int day) {
/*  67 */     this.cal.set(year, month, day);
/*     */     try {
/*  69 */       jbInit();
/*     */     }
/*     */     catch (Exception e) {
/*  72 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public JCalendar(GregorianCalendar calendar) {
/*  76 */     this.cal = calendar;
/*     */     try {
/*  78 */       jbInit();
/*     */     }
/*     */     catch (Exception e) {
/*  81 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public JCalendar(Date date) {
/*  85 */     this.cal.setTime(date);
/*     */     try {
/*  87 */       jbInit();
/*     */     }
/*     */     catch (Exception e) {
/*  90 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jbInit() throws Exception {
/*  94 */     iniCalender();
/*     */ 
/*  96 */     setLayout(new BorderLayout());
/*  97 */     setBorder(BorderFactory.createRaisedBevelBorder());
/*  98 */     setMaximumSize(new Dimension(200, 200));
/*  99 */     setMinimumSize(new Dimension(200, 200));
/* 100 */     setPreferredSize(new Dimension(200, 200));
/*     */ 
/* 102 */     this.Main.setLayout(new BorderLayout());
/* 103 */     this.Main.setBackground(SystemColor.info);
/* 104 */     this.Main.setBorder(null);
/*     */ 
/* 106 */     this.Out.setBackground(Color.lightGray);
/* 107 */     this.Out.setHorizontalAlignment(0);
/* 108 */     this.Out.setMaximumSize(new Dimension(100, 19));
/* 109 */     this.Out.setMinimumSize(new Dimension(100, 19));
/* 110 */     this.Out.setPreferredSize(new Dimension(100, 19));
/*     */ 
/* 112 */     this.jLabel1.setForeground(Color.red);
/* 113 */     this.jLabel1.setHorizontalAlignment(0);
/* 114 */     this.jLabel1.setHorizontalTextPosition(0);
/* 115 */     this.jLabel1.setText("\u93C3\uFFFD");
/* 116 */     this.jLabel2.setForeground(Color.blue);
/* 117 */     this.jLabel2.setHorizontalAlignment(0);
/* 118 */     this.jLabel2.setHorizontalTextPosition(0);
/* 119 */     this.jLabel2.setText("\u934F\uFFFD");
/* 120 */     this.jLabel3.setHorizontalAlignment(0);
/* 121 */     this.jLabel3.setHorizontalTextPosition(0);
/* 122 */     this.jLabel3.setText("\u6D5C\uFFFD");
/* 123 */     this.jLabel4.setHorizontalAlignment(0);
/* 124 */     this.jLabel4.setHorizontalTextPosition(0);
/* 125 */     this.jLabel4.setText("\u9365\uFFFD");
/* 126 */     this.jLabel5.setHorizontalAlignment(0);
/* 127 */     this.jLabel5.setHorizontalTextPosition(0);
/* 128 */     this.jLabel5.setText("\u6D93\uFFFD");
/* 129 */     this.jLabel6.setBorder(null);
/* 130 */     this.jLabel6.setHorizontalAlignment(0);
/* 131 */     this.jLabel6.setHorizontalTextPosition(0);
/* 132 */     this.jLabel6.setText("\u6D5C\uFFFD");
/* 133 */     this.jLabel7.setBackground(Color.lightGray);
/* 134 */     this.jLabel7.setForeground(Color.black);
/* 135 */     this.jLabel7.setBorder(null);
/* 136 */     this.jLabel7.setHorizontalAlignment(0);
/* 137 */     this.jLabel7.setHorizontalTextPosition(0);
/* 138 */     this.jLabel7.setText("\u6D93\uFFFD");
/*     */ 
/* 140 */     this.weekPanel.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
/* 141 */     this.weekPanel.setBorder(BorderFactory.createEtchedBorder());
/* 142 */     this.weekPanel.setLayout(new GridLayout(1, 7));
/* 143 */     this.weekPanel.add(this.jLabel1, null);
/* 144 */     this.weekPanel.add(this.jLabel7, null);
/* 145 */     this.weekPanel.add(this.jLabel6, null);
/* 146 */     this.weekPanel.add(this.jLabel5, null);
/* 147 */     this.weekPanel.add(this.jLabel4, null);
/* 148 */     this.weekPanel.add(this.jLabel3, null);
/* 149 */     this.weekPanel.add(this.jLabel2, null);
/*     */ 
/* 151 */     this.MonthUp.setAlignmentX(0.0F);
/* 152 */     this.MonthUp.setActionMap(null);
/*     */ 
/* 154 */     this.jPanelMonth.setBackground(SystemColor.info);
/* 155 */     this.jPanelMonth.setLayout(new BorderLayout());
/* 156 */     this.jPanelMonth.setBorder(BorderFactory.createEtchedBorder());
/*     */ 
/* 159 */     this.Month.setBorder(null);
/* 160 */     this.Month.setHorizontalAlignment(0);
/* 161 */     this.Month.addMouseListener(new MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent e) {
/* 163 */         JCalendar.this.Month_mouseClicked(e);
/*     */       }
/*     */     });
/* 166 */     this.Month.addKeyListener(new KeyAdapter() {
/*     */       public void keyPressed(KeyEvent e) {
/* 168 */         JCalendar.this.Month_keyPressed(e);
/*     */       }
/*     */     });
/* 172 */     this.MonthDown.setBorder(null);
/* 173 */     this.MonthDown.setText("\u25C4");
/* 174 */     this.MonthDown.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 176 */         JCalendar.this.MonthDown_actionPerformed(e);
/*     */       }
/*     */     });
/* 179 */     this.MonthUp.setBorder(null);
/* 180 */     this.MonthUp.setText("\u25BA");
/* 181 */     this.MonthUp.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 183 */         JCalendar.this.MonthUp_actionPerformed(e);
/*     */       }
/*     */     });
/* 188 */     this.jPanelButton.setLayout(null);
/* 189 */     this.jPanelButton.setBorder(null);
/* 190 */     this.jPanelButton.addComponentListener(new ComponentAdapter() {
/*     */       public void componentResized(ComponentEvent evt) {
/* 192 */         JCalendar.this.jPanelButtonComponentResized(evt);
/*     */       }
/*     */     });
/* 196 */     this.Year.setBorder(BorderFactory.createEtchedBorder());
/* 197 */     this.Year.setMaximumSize(new Dimension(80, 25));
/* 198 */     this.Year.setMinimumSize(new Dimension(80, 25));
/* 199 */     this.Year.setPreferredSize(new Dimension(80, 25));
/* 200 */     this.Year.setHorizontalAlignment(0);
/* 201 */     this.Year.addMouseListener(new MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent e) {
/* 203 */         JCalendar.this.Year_mouseClicked(e);
/*     */       }
/*     */     });
/* 206 */     this.Year.addKeyListener(new KeyAdapter() {
/*     */       public void keyPressed(KeyEvent e) {
/* 208 */         JCalendar.this.Year_keyPressed(e);
/*     */       }
/*     */     });
/* 212 */     this.YearDown.setBorder(null);
/* 213 */     this.YearDown.setMaximumSize(new Dimension(16, 16));
/* 214 */     this.YearDown.setMinimumSize(new Dimension(16, 16));
/* 215 */     this.YearDown.setPreferredSize(new Dimension(16, 16));
/* 216 */     this.YearDown.setSize(new Dimension(16, 16));
/* 217 */     this.YearDown.setText("\u923B\uFFFD");
/* 218 */     this.YearDown.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 220 */         JCalendar.this.YearDown_actionPerformed(e);
/*     */       }
/*     */     });
/* 223 */     this.YearUp.setBorder(null);
/* 224 */     this.YearUp.setMaximumSize(new Dimension(16, 16));
/* 225 */     this.YearUp.setMinimumSize(new Dimension(16, 16));
/* 226 */     this.YearUp.setPreferredSize(new Dimension(16, 16));
/* 227 */     this.YearUp.setSize(new Dimension(16, 16));
/* 228 */     this.YearUp.setText("\u923B\uFFFD");
/* 229 */     this.YearUp.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 231 */         JCalendar.this.YearUp_actionPerformed(e);
/*     */       }
/*     */     });
/* 235 */     this.jPanelDay.setLayout(new BorderLayout());
/*     */ 
/* 237 */     this.Days.setLayout(new GridLayout(6, 7));
/* 238 */     this.Days.setBackground(SystemColor.info);
/*     */ 
/* 240 */     for (int i = 0; i < 42; i++) {
/* 241 */       this.days[i] = new JToggleButton();
/* 242 */       this.days[i].setBorder(null);
/* 243 */       this.days[i].setBackground(SystemColor.info);
/* 244 */       this.days[i].setHorizontalAlignment(0);
/* 245 */       this.days[i].setHorizontalTextPosition(0);
/*     */ 
/* 247 */       this.days[i].addActionListener(new ActionListener() {
/*     */         public void actionPerformed(ActionEvent e) {
/* 249 */           JCalendar.this.day = Integer.parseInt(((JToggleButton)e.getSource()).getText());
/* 250 */           JCalendar.this.showDate();
/* 251 */           JCalendar.this.showDays();
/*     */         }
/*     */       });
/* 254 */       this.Days.add(this.days[i]);
/*     */     }
/*     */ 
/* 257 */     add(this.Main, "North");
/* 258 */     add(this.jPanelDay, "Center");
/* 259 */     add(this.jPanelMonth, "South");
/*     */ 
/* 261 */     this.Main.add(this.Year, "Center");
/* 262 */     this.Main.add(this.Out, "West");
/* 263 */     this.Main.add(this.jPanelButton, "East");
/*     */ 
/* 265 */     this.jPanelButton.add(this.YearUp);
/* 266 */     this.jPanelButton.add(this.YearDown);
/*     */ 
/* 268 */     this.jPanelDay.add(this.weekPanel, "North");
/* 269 */     this.jPanelDay.add(this.Days, "Center");
/*     */ 
/* 271 */     this.jPanelMonth.add(this.Month, "Center");
/* 272 */     this.jPanelMonth.add(this.MonthDown, "West");
/* 273 */     this.jPanelMonth.add(this.MonthUp, "East");
/*     */ 
/* 275 */     showMonth();
/* 276 */     showYear();
/* 277 */     showDate();
/* 278 */     showDays();
/*     */   }
/*     */ 
/*     */   void jPanelButtonComponentResized(ComponentEvent evt) {
/* 282 */     this.YearUp.setLocation(0, 0);
/* 283 */     this.YearDown.setLocation(0, this.YearUp.getHeight());
/* 284 */     this.jPanelButton.setSize(this.YearUp.getWidth(), this.YearUp.getHeight() * 2);
/* 285 */     this.jPanelButton.setPreferredSize(new Dimension(this.YearUp.getWidth(), this.YearUp.getHeight() * 2));
/* 286 */     this.jPanelButton.updateUI();
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/* 290 */     JFrame f = new JFrame();
/* 291 */     f.setContentPane(new JCalendar());
/* 292 */     f.pack();
/* 293 */     f.show();
/*     */   }
/*     */ 
/*     */   void YearUp_actionPerformed(ActionEvent e) {
/* 297 */     this.year += 1;
/* 298 */     showYear();
/* 299 */     showDate();
/* 300 */     showDays();
/*     */   }
/*     */ 
/*     */   void YearDown_actionPerformed(ActionEvent e) {
/* 304 */     this.year -= 1;
/* 305 */     showYear();
/* 306 */     showDate();
/* 307 */     showDays();
/*     */   }
/*     */ 
/*     */   void MonthDown_actionPerformed(ActionEvent e) {
/* 311 */     this.month -= 1;
/* 312 */     if (this.month < 0) {
/* 313 */       this.month = 11;
/* 314 */       this.year -= 1;
/* 315 */       showYear();
/*     */     }
/* 317 */     showMonth();
/* 318 */     showDate();
/* 319 */     showDays();
/*     */   }
/*     */ 
/*     */   void MonthUp_actionPerformed(ActionEvent e) {
/* 323 */     this.month += 1;
/* 324 */     if (this.month == 12) {
/* 325 */       this.month = 0;
/* 326 */       this.year += 1;
/* 327 */       showYear();
/*     */     }
/* 329 */     showMonth();
/* 330 */     showDate();
/* 331 */     showDays();
/*     */   }
/*     */ 
/*     */   void iniCalender() {
/* 335 */     this.year = this.cal.get(1);
/* 336 */     this.month = this.cal.get(2);
/* 337 */     this.day = this.cal.get(5);
/*     */   }
/*     */ 
/*     */   void showMonth() {
/* 341 */     this.Month.setText(Integer.toString(this.month + 1) + "\u93C8\uFFFD");
/*     */   }
/*     */ 
/*     */   void showYear() {
/* 345 */     this.Year.setText(Integer.toString(this.year) + "\u9A9E\uFFFD");
/*     */   }
/*     */ 
/*     */   void showDate() {
/* 349 */     this.Out.setText(Integer.toString(this.year) + "-" + Integer.toString(this.month + 1) + "-" + Integer.toString(this.day));
/*     */   }
/*     */ 
/*     */   void showDays() {
/* 353 */     this.cal.set(this.year, this.month, 1);
/* 354 */     int firstDayOfWeek = this.cal.get(7);
/* 355 */     int n = this.mm[this.month];
/* 356 */     if ((this.cal.isLeapYear(this.year)) && (this.month == 1)) n++;
/* 357 */     int i = 0;
/* 358 */     for (; i < firstDayOfWeek - 1; i++) {
/* 359 */       this.days[i].setEnabled(false);
/* 360 */       this.days[i].setSelected(false);
/* 361 */       this.days[i].setText("");
/*     */     }
/* 363 */     int d = 1;
/* 364 */     for (; d <= n; d++) {
/* 365 */       this.days[i].setText(Integer.toString(d));
/* 366 */       this.days[i].setEnabled(true);
/* 367 */       if (d == this.day) this.days[i].setSelected(true); else
/* 368 */         this.days[i].setSelected(false);
/* 369 */       i++;
/*     */     }
/* 371 */     for (; i < 42; i++) {
/* 372 */       this.days[i].setEnabled(false);
/* 373 */       this.days[i].setSelected(false);
/* 374 */       this.days[i].setText("");
/*     */     }
/*     */   }
/*     */ 
/*     */   void SelectionYear() {
/* 379 */     this.Year.setSelectionStart(0);
/* 380 */     this.Year.setSelectionEnd(this.Year.getText().length());
/*     */   }
/*     */ 
/*     */   void SelectionMonth() {
/* 384 */     this.Month.setSelectionStart(0);
/* 385 */     this.Month.setSelectionEnd(this.Month.getText().length());
/*     */   }
/*     */ 
/*     */   void Month_mouseClicked(MouseEvent e)
/*     */   {
/* 390 */     inputMonth();
/*     */   }
/*     */ 
/*     */   void inputMonth()
/*     */   {
/*     */     String s;
/*     */     String s;
/* 395 */     if (this.Month.getText().endsWith("\u93C8\uFFFD"))
/*     */     {
/* 397 */       s = this.Month.getText().substring(0, this.Month.getText().length() - 1);
/*     */     }
/* 399 */     else s = this.Month.getText();
/* 400 */     this.month = (Integer.parseInt(s) - 1);
/* 401 */     showMe();
/*     */   }
/*     */ 
/*     */   void Month_keyPressed(KeyEvent e) {
/* 405 */     if (e.getKeyChar() == '\n')
/* 406 */       inputMonth();
/*     */   }
/*     */ 
/*     */   void Year_mouseClicked(MouseEvent e)
/*     */   {
/* 411 */     inputYear();
/*     */   }
/*     */ 
/*     */   void Year_keyPressed(KeyEvent e)
/*     */   {
/* 416 */     if (e.getKeyChar() == '\n')
/* 417 */       inputYear();
/*     */   }
/*     */ 
/*     */   void inputYear()
/*     */   {
/*     */     String s;
/*     */     String s;
/* 422 */     if (this.Year.getText().endsWith("\u9A9E\uFFFD"))
/*     */     {
/* 424 */       s = this.Year.getText().substring(0, this.Year.getText().length() - 1);
/*     */     }
/* 426 */     else s = this.Year.getText();
/* 427 */     this.year = Integer.parseInt(s);
/* 428 */     showMe();
/*     */   }
/*     */   public String getDate() {
/* 431 */     return this.Out.getText();
/*     */   }
/*     */   public void setDate(String date) {
/* 434 */     if (date != null) {
/* 435 */       StringTokenizer f = new StringTokenizer(date, "-");
/* 436 */       if (f.hasMoreTokens())
/* 437 */         this.year = Integer.parseInt(f.nextToken());
/* 438 */       if (f.hasMoreTokens())
/* 439 */         this.month = Integer.parseInt(f.nextToken());
/* 440 */       if (f.hasMoreTokens())
/* 441 */         this.day = Integer.parseInt(f.nextToken());
/* 442 */       this.cal.set(this.year, this.month, this.day);
/*     */     }
/* 444 */     showMe();
/*     */   }
/*     */ 
/*     */   public void setTime(Date date) {
/* 448 */     this.cal.setTime(date);
/* 449 */     iniCalender();
/* 450 */     showMe();
/*     */   }
/*     */   public Date getTime() {
/* 453 */     return this.cal.getTime();
/*     */   }
/*     */   public int getDay() {
/* 456 */     return this.day;
/*     */   }
/*     */ 
/*     */   public void setDay(int day) {
/* 460 */     this.day = day;
/* 461 */     this.cal.set(this.year, this.month, this.day);
/* 462 */     showMe();
/*     */   }
/*     */ 
/*     */   public void setYear(int year) {
/* 466 */     this.year = year;
/* 467 */     this.cal.set(this.year, this.month, this.day);
/* 468 */     showMe();
/*     */   }
/*     */ 
/*     */   public int getYear() {
/* 472 */     return this.year;
/*     */   }
/*     */ 
/*     */   public int getMonth() {
/* 476 */     return this.month;
/*     */   }
/*     */ 
/*     */   public void setMonth(int month) {
/* 480 */     this.month = month;
/* 481 */     this.cal.set(this.year, this.month, this.day);
/* 482 */     showMe();
/*     */   }
/*     */ 
/*     */   public void showMe() {
/* 486 */     showDays();
/* 487 */     showMonth();
/* 488 */     showYear();
/* 489 */     showDate();
/*     */   }
/*     */ }

/* Location:           C:\Kevin_File\temp\cs\classes\
 * Qualified Name:     com.sinosoft.banklns.utility.JCalendar
 * JD-Core Version:    0.6.0
 */