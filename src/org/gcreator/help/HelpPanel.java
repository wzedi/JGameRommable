/*    */ package org.gcreator.help;
/*    */ 
/*    */ import java.net.URL;
/*    */ import javax.swing.JEditorPane;
/*    */ import javax.swing.JScrollPane;
/*    */ import javax.swing.JSplitPane;
/*    */ import javax.swing.JTree;
/*    */ import javax.swing.event.HyperlinkEvent;
/*    */ import javax.swing.event.HyperlinkEvent.EventType;
/*    */ import javax.swing.event.HyperlinkListener;
/*    */ import org.gcreator.components.TabPanel;
/*    */ import org.gcreator.managers.LangSupporter;
/*    */ import org.gcreator.units.Dictionary;
/*    */ import org.jdesktop.layout.GroupLayout;
/*    */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*    */ 
/*    */ public class HelpPanel extends TabPanel
/*    */ {
/*    */   private JEditorPane jEditorPane1;
/*    */   private JScrollPane jScrollPane1;
/*    */   private JScrollPane jScrollPane2;
/*    */   private JSplitPane jSplitPane1;
/*    */   private JTree jTree1;
/*    */ 
/*    */   public void loadPage(String page)
/*    */   {
/*    */     try
/*    */     {
/* 23 */       this.jEditorPane1.setPage(new URL("http://g-creator.org/docs/" + page + "?lang=" + LangSupporter.activeLang.getLanguage()));
/*    */     }
/*    */     catch (Exception e) {
/* 26 */       this.jEditorPane1.setText("<h1>ERROR!</h1>Could not load page!<br/>" + e.getMessage());
/*    */     }
/*    */   }
/*    */ 
/*    */   public HelpPanel()
/*    */   {
/* 32 */     initComponents();
/* 33 */     this.jEditorPane1.addHyperlinkListener(new HyperlinkListener() {
/*    */       public void hyperlinkUpdate(HyperlinkEvent evt) {
/* 35 */         if (evt.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
/* 36 */           HelpPanel.this.loadPage(evt.getDescription());
/*    */       }
/*    */     });
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 49 */     this.jSplitPane1 = new JSplitPane();
/* 50 */     this.jScrollPane1 = new JScrollPane();
/* 51 */     this.jTree1 = new JTree();
/* 52 */     this.jScrollPane2 = new JScrollPane();
/* 53 */     this.jEditorPane1 = new JEditorPane();
/*    */ 
/* 55 */     this.jTree1.setModel(null);
/* 56 */     this.jScrollPane1.setViewportView(this.jTree1);
/*    */ 
/* 58 */     this.jSplitPane1.setLeftComponent(this.jScrollPane1);
/*    */ 
/* 60 */     this.jEditorPane1.setContentType("text/html");
/* 61 */     this.jEditorPane1.setEditable(false);
/* 62 */     this.jEditorPane1.setText("<html>\n<a href=\"something.html\">Bcd</a>\n</html>");
/* 63 */     this.jScrollPane2.setViewportView(this.jEditorPane1);
/*    */ 
/* 65 */     this.jSplitPane1.setRightComponent(this.jScrollPane2);
/*    */ 
/* 67 */     GroupLayout layout = new GroupLayout(this);
/* 68 */     setLayout(layout);
/* 69 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(this.jSplitPane1, -1, 400, 32767));
/*    */ 
/* 73 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(this.jSplitPane1, -1, 300, 32767));
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.help.HelpPanel
 * JD-Core Version:    0.6.2
 */