/*    */ package org.gcreator.actions.mainactions;
/*    */ 
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JComponent;

/*    */ import org.gcreator.actions.Action;
/*    */ import org.gcreator.actions.ActionPattern;
/*    */ import org.gcreator.components.SyntaxHighlighter;
/*    */ import org.gcreator.fileclass.Project;
/*    */ import org.gcreator.managers.LangSupporter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ExecuteCode extends ActionPattern
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/* 36 */   public String code = "//Some GCL Code";
/* 37 */   public static ImageIcon img = new ImageIcon(ExecuteCode.class.getResource("/org/gcreator/actions/images/Execute_Code.png"));
/*    */ 
/*    */   public void setStandardImage(ImageIcon icon)
/*    */   {
/* 45 */     img = icon;
/*    */   }
/*    */ 
/*    */   public ImageIcon getStandardImage() {
/* 49 */     return img;
/*    */   }
/*    */ 
/*    */   public void save(JComponent panel)
/*    */   {
/* 54 */     this.code = ((SyntaxHighlighter)panel).getText();
/*    */   }
/*    */ 
/*    */   public void load(JComponent panel)
/*    */   {
/* 59 */     ((SyntaxHighlighter)panel).setText(this.code);
/*    */   }
/*    */ 
/*    */   public JComponent createNewPanel(Action action, Project project) {
/* 63 */     //Scanner scanner = new GScriptScanner();
/* 64 */     //SyntaxHighlighter panel = new SyntaxHighlighter(100, 100, scanner, project);
/* 65 */     //panel.setText(this.code);
/*    */ 
/* 77 */     return null; //panel;
/*    */   }
/*    */ 
/*    */   public String getStandardText(JComponent panel)
/*    */   {
/* 82 */     if (panel != null) {
/* 83 */       save(panel);
/* 84 */       this.code = ((SyntaxHighlighter)panel).getText();
/* 85 */       if ((this.code == null) || (!this.code.equals("")))
/* 86 */         return LangSupporter.activeLang.getEntry(222);
/* 87 */       return this.code;
/*    */     }
/*    */ 
/* 90 */     return LangSupporter.activeLang.getEntry(222);
/*    */   }
/*    */ 
/*    */   public String generateGCL(JComponent panel)
/*    */   {
/* 95 */     save(panel);
/* 96 */     this.code = ((SyntaxHighlighter)panel).getText();
/* 97 */     return this.code;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.actions.mainactions.ExecuteCode
 * JD-Core Version:    0.6.2
 */