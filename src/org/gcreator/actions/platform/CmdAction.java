/*     */ package org.gcreator.actions.platform;
/*     */ 
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import org.gcreator.actions.Action;
/*     */ import org.gcreator.actions.ActionPattern;
/*     */ import org.jdesktop.layout.GroupLayout;
/*     */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*     */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class CmdAction extends ActionPattern
/*     */ {
/*     */   String text;
/*     */ 
/*     */   public CmdAction()
/*     */   {
/*  21 */     this.text = "";
/*     */   }
/*     */ 
/*     */   public JComponent createNewPanel(Action action)
/*     */   {
/*  29 */     return new test();
/*     */   }
/*     */ 
/*     */   public String generateGCL(JComponent panel)
/*     */   {
/*  34 */     return "Platform.printCmd(\"" + this.text + "\");";
/*     */   }
/*     */ 
/*     */   public String writeXml(JComponent panel)
/*     */   {
/*  39 */     return super.writeXml(panel);
/*     */   }
/*     */ 
/*     */   public void setStandardImage(ImageIcon icon)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String getStandardText(JComponent panel)
/*     */   {
/* 115 */     if ((panel != null) && ((panel instanceof test))) {
/* 116 */       test editor = (test)panel;
/* 117 */       this.text = editor.jTextField1.getText();
/*     */     }
/*     */     else {
/* 120 */       this.text = "";
/* 121 */     }return "CMD: " + this.text;
/*     */   }
/*     */ 
/*     */   public ImageIcon getStandardImage() {
/* 125 */     return new ImageIcon(getClass().getResource("/org/gcreator/actions/images/Blank_action.png"));
/*     */   }
/*     */ 
/*     */   class test extends JPanel
/*     */   {
/*     */     private JCheckBox jCheckBox1;
/*     */     private JLabel jLabel1;
/*     */     private JLabel jLabel2;
/*     */     public JTextField jTextField1;
/*     */ 
/*     */     test()
/*     */     {
/*  45 */       initComponents();
/*  46 */       this.jTextField1.setText(CmdAction.this.text);
/*     */     }
/*     */ 
/*     */     private void initComponents()
/*     */     {
/*  56 */       this.jLabel1 = new JLabel();
/*  57 */       this.jTextField1 = new JTextField();
/*  58 */       this.jCheckBox1 = new JCheckBox();
/*  59 */       this.jLabel2 = new JLabel();
/*     */ 
/*  61 */       this.jLabel1.setText("Command line message:");
/*     */ 
/*  63 */       this.jTextField1.setText("Hello World");
/*     */ 
/*  65 */       this.jCheckBox1.setText("As Error (Will be treated as an error on the command line)");
/*     */ 
/*  67 */       this.jLabel2.setText("<html>This action will use the platforms command prompt to write a message. The message is enclosed by \" when compiled so no need to use them unless you want to add variables. To display the value of a variable use \"+variable+\"</html>");
/*     */ 
/*  69 */       GroupLayout layout = new GroupLayout(this);
/*  70 */       setLayout(layout);
/*  71 */       layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add(this.jLabel2, -1, 447, 32767).add(layout.createSequentialGroup().add(this.jCheckBox1).addContainerGap(54, 32767)).add(2, layout.createSequentialGroup().add(this.jTextField1, -1, 435, 32767).addContainerGap()).add(layout.createSequentialGroup().add(this.jLabel1).addContainerGap(287, 32767)))));
/*     */ 
/*  87 */       layout.setVerticalGroup(layout.createParallelGroup(1).add(2, layout.createSequentialGroup().add(this.jLabel2, -1, 87, 32767).addPreferredGap(0).add(this.jLabel1).addPreferredGap(0).add(this.jTextField1, -2, -1, -2).addPreferredGap(0).add(this.jCheckBox1).addContainerGap()));
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.actions.platform.CmdAction
 * JD-Core Version:    0.6.2
 */