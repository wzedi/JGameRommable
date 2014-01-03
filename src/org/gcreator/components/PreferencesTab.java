/*     */ package org.gcreator.components;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.awt.Container;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JDesktopPane;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JSplitPane;
/*     */ import javax.swing.JTabbedPane;
/*     */ import javax.swing.SwingUtilities;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.plaf.metal.DefaultMetalTheme;
/*     */ import javax.swing.plaf.metal.MetalLookAndFeel;
/*     */ import javax.swing.plaf.metal.OceanTheme;
/*     */ import org.gcreator.core.Aurwindow;
/*     */ import org.gcreator.core.gcreator;
/*     */ import org.gcreator.managers.LangSupporter;
/*     */ import org.gcreator.units.Dictionary;
/*     */ import org.jdesktop.layout.GroupLayout;
/*     */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*     */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class PreferencesTab extends OptionPanel
/*     */ {
/*  70 */   public DefaultComboBoxModel lafmodel = new DefaultComboBoxModel()
/*     */   {
/*  72 */     public String[] vals = { PreferencesTab.this.getLang(17), PreferencesTab.this.getLang(18), PreferencesTab.this.getLang(19), PreferencesTab.this.getLang(132) };
/*     */ 
/*     */     public Object getElementAt(int pos) {
/*  75 */       return this.vals[pos];
/*     */     }
/*     */ 
/*     */     public int getSize() {
/*  79 */       return this.vals.length;
/*     */     }
/*  70 */   };
/*     */ 
/*  82 */   public DefaultComboBoxModel displaymodes = new DefaultComboBoxModel()
/*     */   {
/*  84 */     public String[] vals = { PreferencesTab.this.getLang(20), PreferencesTab.this.getLang(90), PreferencesTab.this.getLang(91), PreferencesTab.this.getLang(92), PreferencesTab.this.getLang(21) };
/*     */ 
/*     */     public Object getElementAt(int pos)
/*     */     {
/*  88 */       return this.vals[pos];
/*     */     }
/*     */ 
/*     */     public int getSize() {
/*  92 */       return this.vals.length;
/*     */     }
/*  82 */   };
/*     */   private JComboBox jComboBox1;
/*     */   private JComboBox jComboBox2;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */ 
/*     */   public PreferencesTab(String[] settings)
/*     */   {
/*  21 */     initComponents();
/*     */ 
/*  23 */     this.jComboBox1.setSelectedIndex(0);
/*     */     try {
/*  25 */       if ((settings != null) && (settings[0] != null) && (settings[0].equals("Native"))) {
/*  26 */         gcreator.window.look = 0;
/*  27 */       } else if ((settings == null) || (settings[0] == null) || (settings[0].equals("Cross-platform"))) {
/*  28 */         this.jComboBox1.setSelectedIndex(1);
/*  29 */         gcreator.window.look = 1;
/*  30 */       } else if (settings[0].equals("Motif")) {
/*  31 */         this.jComboBox1.setSelectedIndex(2);
/*  32 */         gcreator.window.look = 2;
/*  33 */       } else if (settings[0].equals("Metal")) {
/*  34 */         this.jComboBox1.setSelectedIndex(3);
/*  35 */         gcreator.window.look = 3;
/*     */       } else {
/*  37 */         this.jComboBox1.setSelectedIndex(1);
/*  38 */         gcreator.window.look = 1;
/*     */       }
/*     */     } catch (Exception e) {
/*  41 */       this.jComboBox1.setSelectedIndex(1);
/*  42 */       gcreator.window.look = 1;
/*     */     }
/*     */ 
/*  45 */     this.jComboBox2.setSelectedIndex(0);
/*     */ 
/*  47 */     if (settings[1].equals("MDI")) {
/*  48 */       this.jComboBox2.setSelectedIndex(4);
/*     */     }
/*     */ 
/*  52 */     if (settings[1].equals("Tabs (Left)")) {
/*  53 */       this.jComboBox2.setSelectedIndex(4);
/*     */     }
/*     */ 
/*  57 */     if (settings[1].equals("Tabs (Bottom)")) {
/*  58 */       this.jComboBox2.setSelectedIndex(4);
/*     */     }
/*     */ 
/*  62 */     if (settings[1].equals("Tabs (Right)")) {
/*  63 */       this.jComboBox2.setSelectedIndex(4);
/*     */     }
/*     */ 
/*  68 */     jComboBox2ActionPerformed(null);
/*     */   }
/*     */ 
/*     */   public String getLang(int lang)
/*     */   {
/*  97 */     return LangSupporter.activeLang.getEntry(lang);
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 108 */     this.jLabel1 = new JLabel();
/* 109 */     this.jComboBox1 = new JComboBox();
/* 110 */     this.jLabel2 = new JLabel();
/* 111 */     this.jComboBox2 = new JComboBox();
/*     */ 
/* 113 */     this.jLabel1.setText(getLang(15));
/*     */ 
/* 115 */     this.jComboBox1.setModel(this.lafmodel);
/* 116 */     this.jComboBox1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 118 */         PreferencesTab.this.jComboBox1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 122 */     this.jLabel2.setText(getLang(16));
/*     */ 
/* 124 */     this.jComboBox2.setModel(this.displaymodes);
/* 125 */     this.jComboBox2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 127 */         PreferencesTab.this.jComboBox2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 131 */     GroupLayout layout = new GroupLayout(this);
/* 132 */     setLayout(layout);
/* 133 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add(this.jLabel1).add(this.jLabel2)).addPreferredGap(0).add(layout.createParallelGroup(1).add(this.jComboBox2, 0, 310, 32767).add(this.jComboBox1, 0, 310, 32767)).addContainerGap()));
/*     */ 
/* 146 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(3).add(this.jLabel1).add(this.jComboBox1, -2, -1, -2)).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.jLabel2).add(this.jComboBox2, -2, -1, -2)).addContainerGap(243, 32767)));
/*     */   }
/*     */ 
/*     */   private void jComboBox1ActionPerformed(ActionEvent evt)
/*     */   {
/* 162 */     int sel = this.jComboBox1.getSelectedIndex();
/*     */     try
/*     */     {
/* 165 */       switch (sel) {
/*     */       case 0:
/* 167 */         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
/* 168 */         SwingUtilities.updateComponentTreeUI(gcreator.window);
/* 169 */         if (gcreator.window.istabs)
/* 170 */           SwingUtilities.updateComponentTreeUI(gcreator.window.mdi);
/*     */         else {
/* 172 */           SwingUtilities.updateComponentTreeUI(Aurwindow.tabs);
/*     */         }
/* 174 */         SwingUtilities.updateComponentTreeUI(gcreator.window.consolepopup);
/* 175 */         gcreator.window.look = 0;
/* 176 */         Aurwindow.workspace.updateUI();
/* 177 */         break;
/*     */       case 1:
/* 179 */         MetalLookAndFeel.setCurrentTheme(new OceanTheme());
/* 180 */         UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
/* 181 */         SwingUtilities.updateComponentTreeUI(gcreator.window);
/* 182 */         if (gcreator.window.istabs)
/* 183 */           SwingUtilities.updateComponentTreeUI(gcreator.window.mdi);
/*     */         else {
/* 185 */           SwingUtilities.updateComponentTreeUI(Aurwindow.tabs);
/*     */         }
/* 187 */         SwingUtilities.updateComponentTreeUI(gcreator.window.consolepopup);
/* 188 */         gcreator.window.look = 1;
/* 189 */         Aurwindow.workspace.updateUI();
/* 190 */         break;
/*     */       case 2:
/* 192 */         UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
/* 193 */         SwingUtilities.updateComponentTreeUI(gcreator.window);
/* 194 */         if (gcreator.window.istabs)
/* 195 */           SwingUtilities.updateComponentTreeUI(gcreator.window.mdi);
/*     */         else {
/* 197 */           SwingUtilities.updateComponentTreeUI(Aurwindow.tabs);
/*     */         }
/* 199 */         SwingUtilities.updateComponentTreeUI(gcreator.window.consolepopup);
/* 200 */         gcreator.window.look = 2;
/* 201 */         Aurwindow.workspace.updateUI();
/* 202 */         break;
/*     */       case 3:
/* 204 */         MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
/* 205 */         UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
/* 206 */         SwingUtilities.updateComponentTreeUI(gcreator.window);
/* 207 */         if (gcreator.window.istabs)
/* 208 */           SwingUtilities.updateComponentTreeUI(gcreator.window.mdi);
/*     */         else {
/* 210 */           SwingUtilities.updateComponentTreeUI(Aurwindow.tabs);
/*     */         }
/* 212 */         SwingUtilities.updateComponentTreeUI(gcreator.window.consolepopup);
/* 213 */         gcreator.window.look = 3;
/* 214 */         Aurwindow.workspace.updateUI();
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 222 */     int sel = this.jComboBox2.getSelectedIndex();
/*     */ 
/* 224 */     if ((sel < 4) && 
/* 225 */       (!gcreator.window.istabs)) {
/* 226 */       int k = gcreator.window.splitter2.getDividerLocation();
/* 227 */       Aurwindow.tabs.setVisible(true);
/* 228 */       gcreator.window.mdi.setVisible(false);
/* 229 */       if (gcreator.window.isWorkspaceLeft()) {
/* 230 */         gcreator.window.splitter2.setRightComponent(Aurwindow.tabs);
/* 231 */         if (gcreator.window.splitter2.getRightComponent().isVisible())
/* 232 */           gcreator.window.splitter2.setDividerLocation(k);
/*     */       }
/*     */       else {
/* 235 */         gcreator.window.splitter2.setLeftComponent(Aurwindow.tabs);
/* 236 */         if (gcreator.window.splitter2.getLeftComponent().isVisible()) {
/* 237 */           gcreator.window.splitter2.setDividerLocation(k);
/*     */         }
/*     */       }
/* 240 */       gcreator.window.istabs = true;
/* 241 */       for (int i = 0; i < gcreator.window.mdi.getDesktop().getComponents().length; i++)
/* 242 */         if ((gcreator.window.mdi.getDesktop().getComponent(i) instanceof ExtendedFrame))
/*     */         {
/*     */           try
/*     */           {
/* 246 */             TabPanel panel = ((ExtendedFrame)gcreator.window.mdi.getDesktop().getComponent(i)).getPanel();
/* 247 */             Aurwindow.tabs.addTab(panel.title, panel);
/* 248 */             int ver = Integer.parseInt(gcreator.getJavaVersion().replaceAll("1\\.([0-9])\\..*", "$1"));
/* 249 */             if (ver >= 6)
/* 250 */               Aurwindow.tabs.setTabComponentAt(Aurwindow.tabs.indexOfComponent(panel), new ButtonTabComponent(Aurwindow.tabs));
/*     */           }
/*     */           catch (ClassCastException e)
/*     */           {
/*     */           }
/*     */         }
/*     */     }
/*     */     try
/*     */     {
/* 259 */       switch (sel) {
/*     */       case 0:
/* 261 */         Aurwindow.tabs.setTabPlacement(1);
/* 262 */         break;
/*     */       case 1:
/* 264 */         Aurwindow.tabs.setTabPlacement(2);
/* 265 */         break;
/*     */       case 2:
/* 267 */         Aurwindow.tabs.setTabPlacement(3);
/* 268 */         break;
/*     */       case 3:
/* 270 */         Aurwindow.tabs.setTabPlacement(4);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/* 276 */     if ((sel == 4) && 
/* 277 */       (gcreator.window.istabs)) {
/* 278 */       int k = gcreator.window.splitter2.getDividerLocation();
/* 279 */       Aurwindow.tabs.setVisible(false);
/* 280 */       gcreator.window.mdi.setVisible(true);
/* 281 */       if (gcreator.window.isWorkspaceLeft()) {
/* 282 */         gcreator.window.splitter2.setRightComponent(gcreator.window.mdi);
/* 283 */         if (gcreator.window.splitter2.getRightComponent().isVisible())
/* 284 */           gcreator.window.splitter2.setDividerLocation(k);
/*     */       }
/*     */       else {
/* 287 */         gcreator.window.splitter2.setLeftComponent(gcreator.window.mdi);
/* 288 */         if (gcreator.window.splitter2.getLeftComponent().isVisible()) {
/* 289 */           gcreator.window.splitter2.setDividerLocation(k);
/*     */         }
/*     */       }
/*     */ 
/* 293 */       gcreator.window.istabs = false;
/* 294 */       Component[] panels = Aurwindow.tabs.getComponents();
/* 295 */       for (int i = 0; i < panels.length; i++)
/* 296 */         if ((panels[i] instanceof TabPanel)) {
/* 297 */           TabPanel panel = (TabPanel)panels[i];
/* 298 */           GroupLayout jInternalFrame1Layout = (GroupLayout)panel.frame.getContentPane().getLayout();
/* 299 */           jInternalFrame1Layout.setHorizontalGroup(jInternalFrame1Layout.createParallelGroup(1).add(panel, -1, -1, 32767));
/* 300 */           jInternalFrame1Layout.setVerticalGroup(jInternalFrame1Layout.createParallelGroup(1).add(panel, -1, -1, 32767));
/*     */         }
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.PreferencesTab
 * JD-Core Version:    0.6.2
 */