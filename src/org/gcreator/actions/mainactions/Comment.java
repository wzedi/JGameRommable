/*    */ package org.gcreator.actions.mainactions;
/*    */ 
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.JTextPane;
/*    */ import org.gcreator.actions.Action;
/*    */ import org.gcreator.actions.ActionPattern;
/*    */ import org.gcreator.actions.components.PlainTextPanel;
/*    */ import org.gcreator.fileclass.Project;
/*    */ import org.gcreator.managers.LangSupporter;
/*    */ import org.gcreator.units.Dictionary;
/*    */ 
/*    */ public class Comment extends ActionPattern
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/* 25 */   public String text = "";
/* 26 */   public static ImageIcon img = new ImageIcon(Comment.class.getResource("/org/gcreator/actions/images/comment.png"));
/*    */ 
/*    */   public void setStandardImage(ImageIcon img)
/*    */   {
/* 34 */     img = img;
/*    */   }
/*    */ 
/*    */   public ImageIcon getStandardImage() {
/* 38 */     return img;
/*    */   }
/*    */ 
/*    */   public void save(JComponent panel)
/*    */   {
/* 43 */     this.text = ((PlainTextPanel)panel).text.getText();
/*    */   }
/*    */ 
/*    */   public void load(JComponent panel)
/*    */   {
/* 48 */     ((PlainTextPanel)panel).text.setText(this.text);
/*    */   }
/*    */ 
/*    */   public JComponent createNewPanel(Action action, Project project) {
/* 52 */     PlainTextPanel panel = new PlainTextPanel();
/* 53 */     panel.text.setText(this.text);
/* 54 */     return panel;
/*    */   }
/*    */ 
/*    */   public String getStandardText(JComponent panel)
/*    */   {
/* 59 */     if (panel != null) {
/* 60 */       save(panel);
/* 61 */       this.text = ((PlainTextPanel)panel).text.getText();
/* 62 */       if ((this.text != null) && (!this.text.equals("")))
/* 63 */         return this.text;
/* 64 */       return LangSupporter.activeLang.getEntry(221);
/*    */     }
/* 66 */     return LangSupporter.activeLang.getEntry(221);
/*    */   }
/*    */ 
/*    */   public String generateGCL(JComponent panel)
/*    */   {
/* 71 */     save(panel);
/* 72 */     return "";
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.actions.mainactions.Comment
 * JD-Core Version:    0.6.2
 */