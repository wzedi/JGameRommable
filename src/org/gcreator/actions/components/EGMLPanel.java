/*    */ package org.gcreator.actions.components;
/*    */ 
/*    */ import javax.swing.JPanel;

/*    */ import org.gcreator.components.SyntaxHighlighter;
/*    */ import org.gcreator.fileclass.Project;
/*    */ import org.jdesktop.layout.GroupLayout;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EGMLPanel extends JPanel
/*    */ {
/*    */   SyntaxHighlighter text;
/*    */ 
/*    */   public EGMLPanel(Project project)
/*    */   {
/* 27 */     initComponents();
/* 28 */     //Scanner scanner = new GCLScanner();
/* 29 */     //this.text = new SyntaxHighlighter(100, 100, scanner, project);
/* 30 */     this.text.setText("//some GCL code");
/* 31 */     add(this.text);
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 52 */     GroupLayout layout = new GroupLayout(this);
/* 53 */     setLayout(layout);
/* 54 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(0, 133, 32767));
/*    */ 
/* 58 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(0, 132, 32767));
/*    */   }
/*    */ 
/*    */   public String getText()
/*    */   {
/* 66 */     return this.text.getText();
/*    */   }
/*    */ 
/*    */   public void setText(String text) {
/* 70 */     this.text.setText(text);
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.actions.components.EGMLPanel
 * JD-Core Version:    0.6.2
 */