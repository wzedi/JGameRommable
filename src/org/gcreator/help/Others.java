/*    */ package org.gcreator.help;
/*    */ 
/*    */ import javax.swing.JEditorPane;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JScrollPane;
/*    */ import org.jdesktop.layout.GroupLayout;
/*    */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*    */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*    */ 
/*    */ public class Others extends JPanel
/*    */ {
/*    */   private JEditorPane jEditorPane1;
/*    */   private JLabel jLabel1;
/*    */   private JScrollPane jScrollPane1;
/*    */ 
/*    */   public Others()
/*    */   {
/* 17 */     initComponents();
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 28 */     this.jLabel1 = new JLabel();
/* 29 */     this.jScrollPane1 = new JScrollPane();
/* 30 */     this.jEditorPane1 = new JEditorPane();
/*    */ 
/* 32 */     this.jLabel1.setText("We would also like to give some credit to:");
/*    */ 
/* 34 */     this.jEditorPane1.setContentType("text/html");
/* 35 */     this.jEditorPane1.setEditable(false);
/* 36 */     this.jEditorPane1.setText("<html>\n  <head>\n\n  </head>\n  <body>\n<h1>G-Java Community Members</h1>\nHaving a community really helps a product moving forward, thank you for any suggestions and/or other contributions.\n  </body>\n</html>\n");
/* 37 */     this.jScrollPane1.setViewportView(this.jEditorPane1);
/*    */ 
/* 39 */     GroupLayout layout = new GroupLayout(this);
/* 40 */     setLayout(layout);
/* 41 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add(this.jScrollPane1, -1, 399, 32767).add(this.jLabel1)).addContainerGap()));
/*    */ 
/* 50 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(this.jLabel1).addPreferredGap(0).add(this.jScrollPane1, -1, 258, 32767).addContainerGap()));
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.help.Others
 * JD-Core Version:    0.6.2
 */