/*    */ package org.gcreator.managers;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.PrintStream;
/*    */ import javax.xml.parsers.DocumentBuilder;
/*    */ import javax.xml.parsers.DocumentBuilderFactory;
/*    */ import org.w3c.dom.Document;
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
/*    */ 
/*    */ @Deprecated
/*    */ public class PluginsList
/*    */ {
/*    */   public static String[] loadPluglist()
/*    */   {
/* 29 */     File target = new File("./settings/pluglist.xml");
/* 30 */     if (!target.exists()) {
/* 31 */       return null;
/*    */     }
/* 33 */     String[] a = new String[50];
/* 34 */     DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
/*    */     try
/*    */     {
/* 38 */       DocumentBuilder builder = fact.newDocumentBuilder();
/* 39 */       Document doc = builder.parse("./settings/pluglist.xml");
/* 40 */       Node node = doc.getDocumentElement();
/* 41 */       String root = node.getNodeName();
/* 42 */       if (!root.equals("pluglist")) {
/* 43 */         return null;
/*    */       }
/* 45 */       NodeList childs = node.getChildNodes();
/*    */ 
/* 47 */       int id = 0;
/* 48 */       for (int i = 0; i < childs.getLength(); i++) {
/* 49 */         Node child = childs.item(i);
/* 50 */         String name = child.getNodeName();
/* 51 */         if (!name.equals("plugin"))
/* 52 */           return null;
/* 53 */         a[(id++)] = child.getTextContent();
/* 54 */         System.out.println("val: " + a[(id - 1)]);
/*    */       }
/* 56 */       return a;
/*    */     }
/*    */     catch (Exception e) {
/*    */     }
/* 60 */     return null;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.managers.PluginsList
 * JD-Core Version:    0.6.2
 */