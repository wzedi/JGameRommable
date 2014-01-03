/*     */ package org.gcreator.plugins;
/*     */ 
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStream;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.net.URLConnection;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Vector;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipFile;

/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JOptionPane;

/*     */ import org.antlr.runtime.ANTLRFileStream;
/*     */ import org.antlr.runtime.CommonTokenStream;
/*     */ import org.gcreator.core.gcreator;
/*     */ import org.gcreator.core.utilities;
/*     */ import org.gcreator.fileclass.Folder;
/*     */ import org.gcreator.fileclass.GFile;
/*     */ import org.gcreator.fileclass.GObject;
/*     */ import org.gcreator.fileclass.Project;
/*     */ import org.gcreator.fileclass.res.Actor;
/*     */ import org.gcreator.fileclass.res.GImage;
/*     */ import org.gcreator.fileclass.res.Scene;
/*     */ import org.gcreator.fileclass.res.Sprite;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PlatformCore extends PluginCore
/*     */ {
/*     */   public Progress p;
/*  47 */   public static String returncode = "";
/*  48 */   int usingwith = 0;
/*  49 */   Vector localVariables = new Vector(1); Vector fieldVariables = new Vector(1); Vector globalVariables = new Vector(1); Vector with = new Vector(1);
/*  50 */   public String current = ""; public String event = "";
/*  51 */   public String updateURL = ""; public String compilername = "";
/*  52 */   public double version = 1.0D;
/*     */ 
/*     */   public void update()
/*     */   {
/*  56 */     URL url = null;
/*  57 */     URLConnection urlConn = null;
/*  58 */     InputStreamReader inStream = null;
/*  59 */     BufferedReader buff = null;
/*     */     try
/*     */     {
/*  63 */       url = new URL(this.updateURL);
/*  64 */       urlConn = url.openConnection();
/*  65 */       inStream = new InputStreamReader(urlConn.getInputStream());
/*     */ 
/*  67 */       buff = new BufferedReader(inStream);
/*     */       while (true)
/*     */       {
/*  71 */         String nextLine = buff.readLine();
/*  72 */         if (nextLine == null) break;
/*  73 */         String v = "";
/*  74 */         if (nextLine.contains("<version>"))
/*     */         {
/*  76 */           v = nextLine.replaceAll("<version>", "").replaceAll("</version>", "");
/*  77 */           double d = Double.parseDouble(v);
/*     */ 
/*  79 */           if (d > this.version)
/*     */           {
/*  81 */             int update = JOptionPane.showConfirmDialog(null, this.compilername + " update is available. Are you sure you want to update " + this.compilername);
/*  82 */             if ((update == 1) || (update == 2))
/*  83 */               return;
/*     */           }
/*     */           else {
/*  86 */             return;
/*     */           }
/*     */         }
/*  88 */         if (nextLine.contains("<zip>"))
/*     */         {
/*  90 */           v = nextLine.replaceAll("<zip>", "").replaceAll("</zip>", "");
/*  91 */           download(v, "plugins" + File.separator + this.compilername + ".zip");
/*  92 */           unzip("plugins" + File.separator + this.compilername + ".zip");
/*  93 */           System.out.println("unzipped");
/*  94 */           JOptionPane.showMessageDialog(gcreator.window, "Finished updating " + this.compilername);
/*     */         }
/*     */ 
/*  97 */         utilities.addStringMessage(nextLine);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (MalformedURLException e)
/*     */     {
/* 105 */       System.out.println("Please check the URL:" + e.toString());
/*     */     }
/*     */     catch (IOException e1) {
/* 108 */       System.out.println("Can't read  from the Internet: " + e1.toString());
/*     */     }
/*     */   }
/*     */ 
/*     */   public void unzip(String zipfile)
/*     */   {
/*     */     try
/*     */     {
/* 116 */       ZipFile zipFile = new ZipFile(zipfile);
/* 117 */       for (Enumeration entries = zipFile.entries(); entries.hasMoreElements(); ) {
/* 118 */         ZipEntry entry = (ZipEntry)entries.nextElement();
/* 119 */         if (entry.isDirectory())
/*     */         {
/* 121 */           new File("plugins" + File.separator + entry.getName()).mkdirs();
/*     */         }
/*     */         else {
/* 124 */           copyInputStream(zipFile.getInputStream(entry), new BufferedOutputStream(new FileOutputStream("plugins" + File.separator + entry.getName())));
/*     */         }
/*     */       }
/* 127 */       zipFile.close();
/*     */     }
/*     */     catch (IOException ioe) {
/* 130 */       ioe.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static final void copyInputStream(InputStream in, OutputStream out)
/*     */     throws IOException
/*     */   {
/* 137 */     byte[] buffer = new byte[1024];
/*     */     int len;
/* 139 */     while ((len = in.read(buffer)) >= 0) {
/* 140 */       out.write(buffer, 0, len);
/*     */     }
/* 142 */     in.close();
/* 143 */     out.close();
/*     */   }
/*     */ 
/*     */   public void download(String address, String localFileName) {
/*     */     try {
/* 148 */       OutputStream out = null;
/* 149 */       InputStream in = null;
/* 150 */       URLConnection conn = null;
/*     */ 
/* 152 */       URL url = new URL(address);
/* 153 */       out = new BufferedOutputStream(new FileOutputStream(localFileName));
/* 154 */       conn = url.openConnection();
/* 155 */       in = conn.getInputStream();
/* 156 */       byte[] buffer = new byte[1024];
/*     */       int numRead;
/* 159 */       for (int numWritten = 0; (numRead = in.read(buffer)) != -1; numWritten += numRead) {
/* 160 */         out.write(buffer, 0, numRead);
/*     */       }
/*     */ 
/* 165 */       System.out.println("Downloaded zip");
/*     */ 
/* 167 */       if (in != null) {
/* 168 */         in.close();
/*     */       }
/* 170 */       if (out != null) {
/* 171 */         out.close();
/*     */       }
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 176 */       System.out.println("" + ex.getLocalizedMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   public void putFolder(Folder folder)
/*     */   {
/* 185 */     for (int i = 0; i < folder.getChildArrayNum(); i++)
/*     */     {
/*     */       GObject childNode;
/* 186 */       if ((childNode = folder.childAt(i)) != null)
/* 187 */         if ((childNode instanceof GFile))
/*     */           try {
/* 189 */             System.out.println("" + ((GFile)childNode).type);
/*     */ 
/* 191 */             if (((GFile)childNode).type.equals("settings")) {
/* 192 */               parseSettings((String)((GFile)childNode).value, ((GFile)childNode).name);
/*     */             }
/*     */ 
/* 195 */             if (((GFile)childNode).type.equals("sprite")) {
/* 196 */               this.p.jProgressBar1.setValue(20);
/* 197 */               this.p.jLabel2.setText("Task: Converting sprite:" + ((GFile)childNode).name);
/* 198 */               this.current = ("Sprite: " + ((GFile)childNode).name);
/* 199 */               this.p.repaint();
/* 200 */               parseSprite((Sprite)((GFile)childNode).value);
/* 201 */             } else if (((GFile)childNode).type.equals("actor")) {
/* 202 */               this.current = ("Actor: " + ((GFile)childNode).name);
/* 203 */               parseActor((Actor)((GFile)childNode).value);
/*     */ 
/* 205 */               this.p.jLabel2.setText("Task: Converting actor:" + ((GFile)childNode).name);
/*     */ 
/* 207 */               this.p.repaint();
/* 208 */             } else if (((GFile)childNode).type.equals("scene")) {
/* 209 */               this.p.jProgressBar1.setValue(80);
/* 210 */               this.p.jLabel2.setText("Task: Converting scene:" + ((GFile)childNode).name);
/* 211 */               this.current = ("Scene: " + ((GFile)childNode).name);
/* 212 */               parseScene((Scene)((GFile)childNode).value);
/* 213 */               this.p.repaint();
/* 214 */             } else if (((GFile)childNode).type.equals("jpg")) {
/* 215 */               this.p.jProgressBar1.setValue(10);
/* 216 */               this.p.jLabel2.setText("Task: Converting image:" + ((GFile)childNode).name);
/* 217 */               parseImage((GImage)((GFile)childNode).value, (GFile)childNode);
/* 218 */             } else if (((GFile)childNode).type.equals("png")) {
/* 219 */               this.p.jProgressBar1.setValue(10);
/* 220 */               this.p.jLabel2.setText("Task: Converting image:" + ((GFile)childNode).name);
/* 221 */               parseImage((GImage)((GFile)childNode).value, (GFile)childNode);
/* 222 */             } else if (((GFile)childNode).type.equals("gif")) {
/* 223 */               parseImage((GImage)((GFile)childNode).value, (GFile)childNode);
/* 224 */               this.p.jProgressBar1.setValue(10);
/* 225 */               this.p.jLabel2.setText("Task: Converting image:" + ((GFile)childNode).name);
/* 226 */             } else if (((GFile)childNode).type.equals("gs")) {
/* 227 */               this.current = ("Script: " + ((GFile)childNode).name);
/* 228 */               this.p.jProgressBar1.setValue(40);
/* 229 */               this.p.jLabel2.setText("Task: Converting scripts:" + ((GFile)childNode).name);
/* 230 */               System.out.println("parsing script!");
/* 231 */               parseScript((String)((GFile)childNode).value, ((GFile)childNode).name);
/* 232 */             } else if (((GFile)childNode).type.equals("settings")) {
/* 233 */               parseSettings((String)((GFile)childNode).value, ((GFile)childNode).name);
/*     */             }
/*     */             else {
/* 236 */               PluginHelper.println("Invalid type:" + ((GFile)childNode).type);
/*     */             }
/*     */           } catch (Exception e) { System.out.println(e.getMessage()); }
/*     */ 
/* 240 */         else if ((childNode instanceof Folder))
/* 241 */           putFolder((Folder)childNode);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void recursivelyDeleteDirectory(File dir)
/*     */     throws IOException
/*     */   {
/* 249 */     if ((dir == null) || (!dir.isDirectory())) throw new IllegalArgumentException(dir + " not a directory");
/* 250 */     File[] files = dir.listFiles();
/* 251 */     int size = files.length;
/* 252 */     for (int i = 0; i < size; i++) {
/* 253 */       if (files[i].isDirectory())
/* 254 */         recursivelyDeleteDirectory(files[i]);
/* 255 */       else files[i].delete();
/*     */     }
/* 257 */     dir.delete();
/*     */   }
/*     */ 
/*     */   public boolean checkvariable(String name)
/*     */   {
/* 262 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean checkfunction(String name)
/*     */   {
/* 268 */     return true;
/*     */   }
/*     */ 
/*     */   public void parseSprite(Sprite s)
/*     */   {
/* 273 */     System.out.println("" + s.name);
/*     */   }
/*     */ 
/*     */   public void parseImage(ImageIcon i, GFile f) {
/* 277 */     System.out.println("called wrong method!");
/*     */   }
/*     */ 
/*     */   public void parseImage(GImage i, GFile f) {
/* 281 */     parseImage(i.getImage(), f);
/*     */   }
/*     */ 
/*     */   public void parseActor(Actor a) throws IOException {
/*     */   }
/*     */ 
/*     */   public void parseScene(Scene s) throws IOException {
/*     */   }
/*     */ 
/*     */   public void parseClass(String s, String name) throws IOException {
/* 291 */     System.out.println("called wrong method!");
/*     */   }
/*     */ 
/*     */   public String varstatement(String type, String vars)
/*     */   {
/* 304 */     if (type.equals("var"))
/* 305 */       type = "Object";
/* 306 */     else if (type.equals("globalvar"))
/* 307 */       type = "Object";
/* 308 */     return "/*var statement*/{" + vars + "}";
/*     */   }
/*     */ 
/*     */   public String fieldstatement(String m, String varstatement) {
/* 312 */     return m + " " + varstatement + ";";
/*     */   }
/*     */ 
/*     */   public String returnstatement(String exp) {
/* 316 */     return "return " + exp + ";";
/*     */   }
/*     */ 
/*     */   public String exitstatement() {
/* 320 */     return "return null;";
/*     */   }
/*     */ 
/*     */   public String ifstatement(String exp, String statement, String elses) {
/* 324 */     return "if (" + exp + ".getBoolean()) \n" + statement + " \n " + elses;
/*     */   }
/*     */ 
/*     */   public String elsestatement(String statement) {
/* 328 */     return " else " + statement;
/*     */   }
/*     */ 
/*     */   public String bstatement(String st) {
/* 332 */     return "{ \n" + st + "\n }";
/*     */   }
/*     */ 
/*     */   public String expression(String ex)
/*     */   {
/* 337 */     return ex;
/*     */   }
/*     */ 
/*     */   public String notexpression(String exp) {
/* 341 */     return " (" + exp + ").not()";
/*     */   }
/*     */ 
/*     */   public String pexpression(String exp) {
/* 345 */     return " (" + exp + ")";
/*     */   }
/*     */ 
/*     */   public String andexpression() {
/* 349 */     return " .and ";
/*     */   }
/*     */ 
/*     */   public String orexpression() {
/* 353 */     return " .or ";
/*     */   }
/*     */ 
/*     */   public String xorexpression() {
/* 357 */     return " .xor ";
/*     */   }
/*     */ 
/*     */   public String repeatstatement(String ex, String st) {
/* 361 */     return "G_CREATOR__repeat=new Double(0); \n while(G_CREATOR__repeat.lt(" + ex + ").getBoolean()){\n" + st + " G_CREATOR__repeat.add(new Integer(1));}";
/*     */   }
/*     */ 
/*     */   public String breakstatement() {
/* 365 */     return "break;";
/*     */   }
/*     */ 
/*     */   public String continuestatement() {
/* 369 */     return "continue;";
/*     */   }
/*     */ 
/*     */   public String dostatement(String statement, String expression) {
/* 373 */     return "do " + statement + "while(" + expression + ".getBoolean());";
/*     */   }
/*     */ 
/*     */   public String whilestatement(String exp, String st) {
/* 377 */     return "while (" + exp + ".getBoolean()) " + st;
/*     */   }
/*     */ 
/*     */   public String forstatement(String statement1, String exp, String statement2, String statements) {
/* 381 */     System.out.println(statement2.substring(statement2.length() - 1, statement2.length()));
/* 382 */     if (statement2.substring(statement2.length() - 1, statement2.length()).equals(";"))
/* 383 */       statement2 = statement2.substring(0, statement2.length() - 1);
/* 384 */     return "for (Object " + statement1 + exp + ".getBoolean(); " + statement2 + ") " + statements;
/*     */   }
/*     */ 
/*     */   public String switchstatement() {
/* 388 */     return "";
/*     */   }
/*     */ 
/*     */   public String withstatement(String exp, String statement) {
/* 392 */     this.usingwith += 1;
/* 393 */     this.with.add(exp);
/* 394 */     return "\n{\n" + statement + "\n}\n";
/*     */   }
/*     */ 
/*     */   public String assignmentstatement(String variable, String operator, String expression)
/*     */   {
/* 400 */     String instance = ""; String value = "";
/* 401 */     String tempvar = variable;
/*     */ 
/* 403 */     if (variable.contains("all.")) {
/* 404 */       instance = "(new All())";
/* 405 */     } else if (variable.contains("other.")) {
/* 406 */       instance = "other";
/* 407 */     } else if (variable.contains("noone.")) {
/* 408 */       instance = "(new Object())";
/* 409 */     } else if (variable.contains("self.")) {
/* 410 */       instance = "self";
/* 411 */     } else if (variable.contains("global.")) {
/* 412 */       instance = "Global";
/* 413 */     } else if (variable.contains("(")) {
/* 414 */       instance = "(new All" + variable.substring(0, variable.indexOf(".") - 1) + "))";
/* 415 */     } else if (variable.contains(".")) {
/* 416 */       instance = "(new All(" + variable.substring(0, variable.indexOf(".") - 1) + "))";
/* 417 */       tempvar = variable.substring(0, variable.indexOf(".") - 1);
/*     */     }
/*     */     else {
/* 420 */       instance = "self";
/*     */     }
/*     */ 
/* 423 */     if (checkvariable(tempvar)) {
/* 424 */       String var = new StringBuilder().append("").append(variable.charAt(0)).toString().toUpperCase() + variable.substring(1, variable.length());
/*     */ 
/* 426 */       value = instance + ".set" + var + "(";
/*     */ 
/* 428 */       if (operator.equals("="))
/* 429 */         value = value + expression;
/* 430 */       else if (operator.equals(":="))
/* 431 */         value = value + expression;
/* 432 */       else if (operator.equals("+="))
/* 433 */         value = value + instance + ".get" + var + "().setadd(" + expression + ")";
/* 434 */       else if (operator.equals("*="))
/* 435 */         value = value + instance + ".get" + var + "().setmult(" + expression + ")";
/* 436 */       else if (operator.equals("-="))
/* 437 */         value = value + instance + ".get" + var + "().setsub(" + expression + ")";
/* 438 */       else if (operator.equals("/="))
/* 439 */         value = value + instance + ".get" + var + "().setdiv(" + expression + ")";
/* 440 */       else if (operator.equals("&="))
/* 441 */         value = value + instance + ".get" + var + "().setband(" + expression + ")";
/* 442 */       else if (operator.equals("|="))
/* 443 */         value = value + instance + ".get" + var + "().setbor(" + expression + ")";
/* 444 */       else if (operator.equals("^="))
/* 445 */         value = value + instance + ".get" + var + "().setbxor(" + expression + ")";
/* 446 */       return value + ")";
/*     */     }
/*     */ 
/* 449 */     variable = variable.substring(variable.indexOf(".") + 1, variable.length());
/* 450 */     value = instance + ".setVariable(\"" + variable + "\",";
/*     */ 
/* 452 */     if (operator.equals("="))
/* 453 */       value = value + expression;
/* 454 */     else if (operator.equals(":="))
/* 455 */       value = value + expression;
/* 456 */     else if (operator.equals("+="))
/* 457 */       value = value + instance + ".getVariable(\"" + variable + "\").setadd(" + expression + ")";
/* 458 */     else if (operator.equals("*="))
/* 459 */       value = value + instance + ".getVariable(\"" + variable + "\").setmult(" + expression + ")";
/* 460 */     else if (operator.equals("-="))
/* 461 */       value = value + instance + ".getVariable(\"" + variable + "\").setsub(" + expression + ")";
/* 462 */     else if (operator.equals("/="))
/* 463 */       value = value + instance + ".getVariable(\"" + variable + "\").setdiv(" + expression + ")";
/* 464 */     else if (operator.equals("&="))
/* 465 */       value = value + instance + ".getVariable(\"" + variable + "\").setband(" + expression + ")";
/* 466 */     else if (operator.equals("|="))
/* 467 */       value = value + instance + ".getVariable(\"" + variable + "\").setbor(" + expression + ")";
/* 468 */     else if (operator.equals("^="))
/* 469 */       value = value + instance + ".getVariable(\"" + variable + "\").setbxor(" + expression + ")";
/* 470 */     return value + ")";
/*     */   }
/*     */ 
/*     */   public String functionstatement(String name, String parameters) {
/* 474 */     if (parameters == null)
/* 475 */       parameters = "";
/* 476 */     if (!checkfunction(name)) {
/* 477 */       showError("No function named: " + name + "(" + parameters + ")");
/* 478 */       return name + "(" + parameters + ")";
/*     */     }
/* 480 */     return name + "(" + parameters + ")";
/*     */   }
/*     */ 
/*     */   public void parseScript(String code, String name)
/*     */   {
/*     */   }
/*     */ 
/*     */   public String otherclassfunctionstatement(String name, String parameters)
/*     */   {
/* 489 */     return name + "(" + parameters + ")";
/*     */   }
/*     */ 
/*     */   public String array(String name, String exp) {
/* 493 */     return name + "[" + exp + "]";
/*     */   }
/*     */ 
/*     */   public String methodstatement(String m, String retvalue, String name, String st, String args) {
/* 497 */     return m + " " + retvalue + " " + name + " (" + args + ") " + st;
/*     */   }
/*     */ 
/*     */   public String variable(String variable)
/*     */   {
/* 502 */     String instance = ""; String value = "";
/*     */ 
/* 507 */     if (variable.equals("true"))
/* 508 */       return "(new Boolean(true))";
/* 509 */     if (variable.equals("false"))
/* 510 */       return "(new Boolean(false))";
/* 511 */     if (variable.equals("pi")) {
/* 512 */       return "(new Double(false))";
/*     */     }
/* 514 */     if (variable.contains("all."))
/* 515 */       instance = "(new All())";
/* 516 */     else if (variable.contains("other."))
/* 517 */       instance = "other";
/* 518 */     else if (variable.contains("noone."))
/* 519 */       instance = "(new Object())";
/* 520 */     else if (variable.contains("self."))
/* 521 */       instance = "self";
/* 522 */     else if (variable.contains("global."))
/* 523 */       instance = "Global";
/* 524 */     else if (variable.contains("."))
/* 525 */       instance = "(new All(new " + variable + "()))";
/* 526 */     else if (variable.contains("("))
/* 527 */       instance = "()";
/*     */     else {
/* 529 */       instance = "self";
/*     */     }
/*     */ 
/* 532 */     if (checkvariable(variable))
/* 533 */       return instance + ".get" + new StringBuilder().append("").append(variable.charAt(0)).toString().toUpperCase() + variable.substring(1, variable.length()) + "()";
/* 534 */     variable = variable.substring(variable.indexOf(".") + 1, variable.length());
/*     */ 
/* 536 */     value = instance + ".getVariable(\"" + variable + "\")";
/* 537 */     return value;
/*     */   }
/*     */ 
/*     */   public String aexpression(String operator, String expression)
/*     */   {
/* 549 */     if (operator.equals("+"))
/* 550 */       return ".add(" + expression + ")";
/* 551 */     if (operator.equals("-"))
/* 552 */       return ".sub(" + expression + ")";
/* 553 */     if (operator.equals("*"))
/* 554 */       return ".mult(" + expression + ")";
/* 555 */     if (operator.equals("/"))
/* 556 */       return ".div(" + expression + ")";
/* 557 */     if (operator.equals("|"))
/* 558 */       return ".bor(" + expression + ")";
/* 559 */     if (operator.equals("&"))
/* 560 */       return ".band(" + expression + ")";
/* 561 */     if (operator.equals("^"))
/* 562 */       return ".bxor(" + expression + ")";
/* 563 */     if (operator.equals(">>"))
/* 564 */       return ".bright(" + expression + ")";
/* 565 */     if (operator.equals("<<"))
/* 566 */       return ".bleft(" + expression + ")";
/* 567 */     if (operator.equals("div"))
/* 568 */       return ".div(" + expression + ")";
/* 569 */     if (operator.equals("mod"))
/* 570 */       return ".mod(" + expression + ")";
/* 571 */     return "aexpression";
/*     */   }
/*     */ 
/*     */   public String relationalExpression(String name, String operator, String name2)
/*     */   {
/* 577 */     if (operator.equals("=="))
/* 578 */       return name + ".equals(" + name2 + ")";
/* 579 */     if (operator.equals("="))
/* 580 */       return name + ".equals(" + name2 + ")";
/* 581 */     if (operator.equals(":="))
/* 582 */       return name + ".equals(" + name2 + ")";
/* 583 */     if (operator.equals("!="))
/* 584 */       return name + ".notequals(" + name2 + ")";
/* 585 */     if (operator.equals(">"))
/* 586 */       return name + ".gt(" + name2 + ")";
/* 587 */     if (operator.equals(">="))
/* 588 */       return name + ".gte(" + name2 + ")";
/* 589 */     if (operator.equals("<"))
/* 590 */       return name + ".lt(" + name2 + ")";
/* 591 */     if (operator.equals("<=")) {
/* 592 */       return name + ".lte(" + name2 + ")";
/*     */     }
/* 594 */     return name;
/*     */   }
/*     */ 
/*     */   public void showError(String msg)
/*     */   {
/* 599 */     JOptionPane.showMessageDialog(null, "Syntax Error while parsing " + this.current + ":" + this.event + "\n" + msg + "");
/*     */   }
/*     */ 
/*     */   public String parseGCL(String code, PlatformCore p)
/*     */     throws IOException
/*     */   {
/* 606 */     //gscriptLexer lex = null;
/*     */ 
/* 609 */     System.out.println("CODE:" + code);
/* 610 */     FileWriter ftempcode = new FileWriter("tempcode.gcl");
/* 611 */     BufferedWriter tempcode = new BufferedWriter(ftempcode);
/* 612 */     tempcode.write(code);
/* 613 */     tempcode.close();
/*     */ 
/* 615 */     //lex = new gscriptLexer(new ANTLRFileStream(new File("tempcode.gcl").getAbsolutePath()));
/* 616 */     //CommonTokenStream tokens = new CommonTokenStream(lex);
/*     */     try {
/* 618 */       //gscriptParser parser = new gscriptParser(tokens);
/*     */ 
/* 621 */       //parser.setPlatform(p);
/*     */ 
/* 624 */       //parser.code();
/*     */ 
/* 626 */       System.out.println("Finished! Code output:" + returncode);
/*     */     } catch (Exception e) {
/* 628 */       System.out.println("Error with parser:" + e + e.getLocalizedMessage() + " " + e.getMessage());
/*     */     }
/* 630 */     return returncode;
/*     */   }
/*     */ 
/*     */   public static String parseGCLClass(String code, PlatformCore p)
/*     */     throws IOException
/*     */   {
/* 636 */     //gscriptLexer lex = null;
/*     */ 
/* 640 */     FileWriter ftempcode = new FileWriter("tempcode.gcl");
/* 641 */     BufferedWriter tempcode = new BufferedWriter(ftempcode);
/* 642 */     tempcode.write(code);
/* 643 */     tempcode.close();
/* 644 */     System.out.println("test");
/* 645 */     //lex = new gscriptLexer(new ANTLRFileStream(new File("tempcode.gcl").getAbsolutePath()));
/* 646 */     //CommonTokenStream tokens = new CommonTokenStream(lex);
/*     */ 
/* 648 */     //gscriptParser parser = new gscriptParser(tokens);
/* 649 */     //parser.setPlatform(p);
/*     */     try {
/* 651 */       //parser.classes();
/* 652 */       System.out.println("Finished! Code output:" + returncode);
/*     */     } catch (Exception e) {
/* 654 */       System.out.println("Error:" + e.getLocalizedMessage() + " " + e.getMessage());
/*     */     }
/* 656 */     return "";
/*     */   }
/*     */ 
/*     */   public void startprogress()
/*     */   {
/* 661 */     this.p = new Progress(gcreator.window, false, this);
/* 662 */     this.p.repaint();
/* 663 */     this.p.run(this);
/*     */   }
/*     */ 
/*     */   public void run(Project project)
/*     */   {
/* 669 */     if (project != null)
/*     */     {
/* 671 */       putFolder(project);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void print(BufferedWriter file, String printString)
/*     */     throws IOException
/*     */   {
/* 678 */     file.write(printString);
/* 679 */     file.newLine();
/*     */   }
/*     */ 
/*     */   public static void openbrowser(String location) {
/* 683 */     if (System.getProperty("os.name").indexOf("Windows") == 0)
/*     */       try {
/* 685 */         Runtime.getRuntime().exec("explorer.exe " + location);
/*     */       } catch (IOException e) {
/* 687 */         e.printStackTrace();
/*     */       }
/*     */   }
/*     */ 
/*     */   public void copyDirectory(File srcDir, File dstDir)
/*     */     throws IOException
/*     */   {
/* 695 */     if (srcDir.isDirectory()) {
/* 696 */       if (!dstDir.exists()) {
/* 697 */         dstDir.mkdir();
/*     */       }
/*     */ 
/* 700 */       String[] children = srcDir.list();
/* 701 */       for (int i = 0; i < children.length; i++)
/* 702 */         copyDirectory(new File(srcDir, children[i]), new File(dstDir, children[i]));
/*     */     }
/*     */     else {
/* 705 */       copyFile(srcDir, dstDir);
/*     */     }
/*     */   }
/*     */ 
/*     */   void copyFile(File src, File dst)
/*     */     throws IOException
/*     */   {
/* 712 */     InputStream in = new FileInputStream(src);
/* 713 */     OutputStream out = new FileOutputStream(dst);
/*     */ 
/* 716 */     byte[] buf = new byte[1024];
/*     */     int len;
/* 718 */     while ((len = in.read(buf)) > 0) {
/* 719 */       out.write(buf, 0, len);
/*     */     }
/* 721 */     in.close();
/* 722 */     out.close();
/*     */   }
/*     */ 
/*     */   public void parseSettings(String string, String name) {
/* 726 */     System.out.println(string + "got here");
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.plugins.PlatformCore
 * JD-Core Version:    0.6.2
 */