/*    */ package org.gcreator.actions.mainactions;
/*    */ 
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.JTextField;
/*    */ import org.gcreator.actions.Action;
/*    */ import org.gcreator.actions.ActionPattern;
/*    */ import org.gcreator.actions.components.WarpToEditor;
/*    */ import org.gcreator.fileclass.Project;
/*    */ 
/*    */ public class WarpTo extends ActionPattern
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/* 22 */   public String who = ""; public String to_x = ""; public String to_y = "";
/*    */ 
/* 24 */   public static ImageIcon icon = new ImageIcon(WarpTo.class.getResource("/org/gcreator/actions/images/warp.png"));
/*    */ 
/*    */   public void save(JComponent panel)
/*    */   {
/* 35 */     this.who = ((WarpToEditor)panel).of.getText();
/* 36 */     this.to_x = ((WarpToEditor)panel).X.getText();
/* 37 */     this.to_y = ((WarpToEditor)panel).Y.getText();
/*    */   }
/*    */ 
/*    */   public void load(JComponent panel)
/*    */   {
/* 42 */     ((WarpToEditor)panel).of.setText(this.who);
/* 43 */     ((WarpToEditor)panel).X.setText(this.to_x);
/* 44 */     ((WarpToEditor)panel).Y.setText(this.to_y);
/*    */   }
/*    */ 
/*    */   public ImageIcon getStandardImage() {
/* 48 */     return icon;
/*    */   }
/*    */ 
/*    */   public void setStandardImage(ImageIcon img) {
/* 52 */     icon = img;
/*    */   }
/*    */ 
/*    */   public JComponent createNewPanel(Action action, Project project) {
/* 56 */     return new WarpToEditor();
/*    */   }
/*    */ 
/*    */   public String getStandardText(JComponent panel) {
/* 60 */     if ((panel != null) && ((panel instanceof WarpToEditor))) {
/* 61 */       save(panel);
/* 62 */       WarpToEditor editor = (WarpToEditor)panel;
/* 63 */       String who = editor.of.getText();
/* 64 */       if (who == null)
/* 65 */         who = "null";
/* 66 */       String x = editor.X.getText();
/* 67 */       if (x == null)
/* 68 */         x = "0";
/* 69 */       String y = editor.Y.getText();
/* 70 */       if (y == null)
/* 71 */         y = "0";
/* 72 */       return "Warp " + who + " to (" + x + ", " + y + ")";
/*    */     }
/* 74 */     return "Warp to";
/*    */   }
/*    */ 
/*    */   public String generateGCL(JComponent panel) {
/* 78 */     if ((panel != null) && ((panel instanceof WarpToEditor))) {
/* 79 */       WarpToEditor editor = (WarpToEditor)panel;
/* 80 */       save(panel);
/* 81 */       String s = "";
/* 82 */       String who = editor.of.getText();
/* 83 */       s = s + "(" + who + ").setX(" + editor.X.getText() + ");\n";
/* 84 */       s = s + "(" + who + ").setY(" + editor.Y.getText() + ");\n";
/* 85 */       return s;
/*    */     }
/* 87 */     return "";
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.actions.mainactions.WarpTo
 * JD-Core Version:    0.6.2
 */