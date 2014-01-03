/*     */ package org.gcreator.languages;
/*     */ 
/*     */ import org.gcreator.units.Dictionary;
/*     */ 
/*     */ public class English extends Dictionary
/*     */ {
/*     */   public English()
/*     */   {
/*  22 */     this.status = "Finished";
/*  23 */     this.language = "English";
/*  24 */     this.authors = new String[10];
/*  25 */     this.authors[0] = "Luís Reis";
/*     */ 
/*  27 */     this.entry = new String[300];
/*  28 */     this.entry[0] = "File";
/*  29 */     this.entry[1] = "Edit";
/*  30 */     this.entry[2] = "View";
/*  31 */     this.entry[3] = "Build&Run";
/*  32 */     this.entry[4] = "Help";
/*  33 */     this.entry[5] = "New Project";
/*  34 */     this.entry[6] = "New File"; ///Group";
/*  35 */     this.entry[7] = "Open Project";
/*  36 */     this.entry[8] = "Save Project";
/*  37 */     this.entry[9] = "Save Project As";
/*  38 */     this.entry[10] = "Import";
/*  39 */     this.entry[11] = "Export...";
/*  40 */     this.entry[12] = "Close Project";
/*  41 */     this.entry[13] = "Exit";
/*  42 */     this.entry[14] = "Clear Console";
/*  43 */     this.entry[15] = "Look&Feel";
/*  44 */     this.entry[16] = "Display mode";
/*  45 */     this.entry[17] = "Native look";
/*  46 */     this.entry[18] = "Cross-platform look";
/*  47 */     this.entry[19] = "Motif look";
/*  48 */     this.entry[20] = "Tabs (Top)";
/*  49 */     this.entry[21] = "MDI";
/*  50 */     this.entry[22] = "Display output box";
/*  51 */     this.entry[23] = "Select language";
/*  52 */     this.entry[24] = "About";
/*  53 */     this.entry[25] = "Help";
/*  54 */     this.entry[26] = "Welcome!";
/*  55 */     this.entry[27] = "Help!";
/*  56 */     this.entry[28] = "Select language";
/*  57 */     this.entry[29] = "Finished loading application.";
/*  58 */     this.entry[30] = "Error creating settings file";
/*  59 */     this.entry[31] = "Error writing settings file";
/*  60 */     this.entry[32] = "Error reading settings file";
/*  61 */     this.entry[33] = "Bad settings file structure";
/*  62 */     this.entry[34] = "Doubled setting node";
/*  63 */     this.entry[35] = "Missing setting property";
/*  64 */     this.entry[36] = "Language unavailable";
/*  65 */     this.entry[37] = "Welcome to Aurora,";
/*  66 */     this.entry[38] = "the next generation of G-Creator.";
/*     */ 
/*  68 */     this.entry[39] = "New Project";
/*  69 */     this.entry[40] = "Open Project";
/*  70 */     this.entry[41] = "Save";
/*  71 */     this.entry[42] = "Save As";
/*  72 */     this.entry[43] = "Add Sprite";
/*  73 */     this.entry[44] = "Add Sound";
/*  74 */     this.entry[45] = "Add Object";
/*  75 */     this.entry[46] = "Add Level";
/*     */ 
/*  77 */     this.entry[47] = "Language";
/*  78 */     this.entry[48] = "Status";
/*  79 */     this.entry[49] = "Apply Language";
/*  80 */     this.entry[50] = "Restart the application to apply the changes";
/*     */ 
/*  82 */     this.entry[51] = "Workspace";
/*     */ 
/*  84 */     this.entry[52] = "Add Class";
/*     */ 
/*  86 */     this.entry[53] = "Save All Projects";
/*     */ 
/*  88 */     this.entry[54] = "Choose the type of your project";
/*  89 */     this.entry[55] = "New Project";
/*  90 */     this.entry[56] = "Games";
/*  91 */     this.entry[57] = "Packages";
/*  92 */     this.entry[58] = "Empty Game";
/*  93 */     this.entry[59] = "Empty Package";
/*  94 */     this.entry[60] = "Project name";
/*  95 */     this.entry[61] = "Organized Package";
/*  96 */     this.entry[62] = "Extensions";
/*  97 */     this.entry[63] = "Empty Extension";
/*  98 */     this.entry[64] = "Graphics";
/*  99 */     this.entry[65] = "Start in full-screen mode";
/* 100 */     this.entry[66] = "Allow the player to resize the room window";
/* 101 */     this.entry[67] = "Don't draw a border in windowed mode";
/* 102 */     this.entry[68] = "Don't show the buttons in the window caption";
/* 103 */     this.entry[69] = "Display mouse";
/* 104 */     this.entry[70] = "Display FPS in window caption";
/* 105 */     this.entry[71] = "Resolution";
/* 106 */     this.entry[72] = "Set the resolution of the screen";
/* 107 */     this.entry[73] = "Colour Depth";
/* 108 */     this.entry[74] = "No change";
/*     */ 
/* 110 */     this.entry[75] = "View toolbars";
/*     */ 
/* 112 */     this.entry[76] = "Find";
/* 113 */     this.entry[77] = "Find";
/* 114 */     this.entry[78] = "Text to find";
/* 115 */     this.entry[79] = "Find";
/* 116 */     this.entry[80] = "Case-Sensitive";
/* 117 */     this.entry[81] = "Use Regular expressions";
/* 118 */     this.entry[82] = "Treat \\n as line break";
/*     */ 
/* 120 */     this.entry[83] = "Find&Replace";
/* 121 */     this.entry[84] = "Replace";
/* 122 */     this.entry[85] = "by";
/* 123 */     this.entry[86] = "Replace";
/* 124 */     this.entry[87] = "Replace All";
/*     */ 
/* 126 */     this.entry[88] = "Save file";
/* 127 */     this.entry[89] = "Save all files";
/* 128 */     this.entry[90] = "Tabs (Left)";
/* 129 */     this.entry[91] = "Tabs (Bottom)";
/* 130 */     this.entry[92] = "Tabs (Right)";
/* 131 */     this.entry[114] = "Tools";
/* 132 */     this.entry[93] = "Update";
/* 133 */     this.entry[94] = "Create";
/*     */ 
/* 135 */     this.entry[95] = "New...";
/* 136 */     this.entry[96] = "New File or Group";
/* 137 */     this.entry[97] = "Standard items";
/* 138 */     this.entry[98] = "Set as main project";
/* 139 */     this.entry[99] = "Clean current project";
/* 140 */     this.entry[100] = "Clean main project";
/* 141 */     this.entry[101] = "Build current project";
/* 142 */     this.entry[102] = "Test current project";
/* 143 */     this.entry[103] = "Build&Test current project";
/* 144 */     this.entry[104] = "Final Build current project";
/* 145 */     this.entry[105] = "Build main project";
/* 146 */     this.entry[106] = "Test main project";
/* 147 */     this.entry[107] = "Build&Test main project";
/* 148 */     this.entry[108] = "Final Build main project";
/*     */ 
/* 150 */     this.entry[109] = "Extensions manager";
/* 151 */     this.entry[110] = "Extensions manager";
/* 152 */     this.entry[111] = "Add";
/* 153 */     this.entry[112] = "Remove";
/* 154 */     this.entry[113] = "Revert changes";
/*     */ 
/* 157 */     this.entry[115] = "Copy message";
/* 158 */     this.entry[116] = "Hide console";
/* 159 */     this.entry[117] = "Hide toolbar";
/* 160 */     this.entry[118] = "Import image";
/* 161 */     this.entry[119] = "Zoom";
/*     */ 
/* 163 */     this.entry[120] = "Frequency";
/* 164 */     this.entry[121] = "Other";
/* 165 */     this.entry[122] = "Default Keys";
/* 166 */     this.entry[123] = "Let <ESC> end the game";
/* 167 */     this.entry[124] = "Let <F4> switch between screen modes";
/* 168 */     this.entry[125] = "Let <F5> save the game and <F6> load it.";
/* 169 */     this.entry[126] = "Loading";
/* 170 */     this.entry[127] = "Show image while loading";
/* 171 */     this.entry[128] = "Image:";
/* 172 */     this.entry[129] = "Icon:";
/*     */ 
/* 174 */     this.entry[130] = "Global settings";
/* 175 */     this.entry[131] = "Global settings";
/*     */ 
/* 177 */     this.entry[132] = "Metal theme";
/*     */ 
/* 179 */     this.entry[133] = "Add To Sprite";
/* 180 */     this.entry[134] = "Edit";
/* 181 */     this.entry[135] = "Remove";
/* 182 */     this.entry[136] = "Name:";
/* 183 */     this.entry[137] = "Sprite";
/* 184 */     this.entry[138] = "Edit";
/* 185 */     this.entry[139] = "Visible";
/* 186 */     this.entry[140] = "Solid";
/* 187 */     this.entry[141] = "Persistant";
/* 188 */     this.entry[142] = "Depth:";
/* 189 */     this.entry[143] = "Extends:";
/* 190 */     this.entry[144] = "Mask:";
/* 191 */     this.entry[145] = "Add Event";
/* 192 */     this.entry[146] = "Add";
/* 193 */     this.entry[147] = "Objects";
/* 194 */     this.entry[148] = "Settings";
/* 195 */     this.entry[149] = "Backgrounds";
/* 196 */     this.entry[150] = "Views";
/* 197 */     this.entry[151] = "Add";
/* 198 */     this.entry[152] = "Remove";
/* 199 */     this.entry[153] = "Enable the use of views";
/* 200 */     this.entry[154] = "<HTML>Visible when the<br/>room starts";
/* 201 */     this.entry[155] = "View in scene";
/* 202 */     this.entry[156] = "Port on screen";
/* 203 */     this.entry[157] = "Draw background Color";
/* 204 */     this.entry[158] = "Color:";
/* 205 */     this.entry[159] = "Name:";
/* 206 */     this.entry[160] = "Caption for the scene:";
/* 207 */     this.entry[161] = "Width";
/* 208 */     this.entry[162] = "Height";
/* 209 */     this.entry[163] = "Speed";
/* 210 */     this.entry[164] = "Persistent";
/* 211 */     this.entry[165] = "Creation code";
/* 212 */     this.entry[166] = "Name:";
/* 213 */     this.entry[167] = "Play";
/* 214 */     this.entry[168] = "Play&Loop";
/* 215 */     this.entry[169] = "Stop";
/* 216 */     this.entry[170] = "Load Sound";
/* 217 */     this.entry[171] = "Macros";
/* 218 */     this.entry[172] = "Play macro";
/* 219 */     this.entry[173] = "Edit macro";
/* 220 */     this.entry[174] = "Record new macro";
/* 221 */     this.entry[175] = "Choose macro name";
/* 222 */     this.entry[176] = "Macro recording error";
/* 223 */     this.entry[177] = "Macro with the same name already exists";
/* 224 */     this.entry[178] = "Choose a macro to play";
/* 225 */     this.entry[179] = "Cancel";
/* 226 */     this.entry[180] = "Play Macro";
/* 227 */     this.entry[181] = "Macro player";
/* 228 */     this.entry[182] = "Stop recording macro";
/* 229 */     this.entry[183] = "Import from PowerPack";
/* 230 */     this.entry[184] = "PowerPack Explorer";
/* 231 */     this.entry[185] = "File";
/* 232 */     this.entry[186] = "Project";
/* 233 */     this.entry[187] = "Choose resource to import";
/* 234 */     this.entry[188] = "Filter";
/* 235 */     this.entry[189] = "Image";
/* 236 */     this.entry[190] = "Add Tileset";
/*     */ 
/* 238 */     this.entry[191] = "Name";
/* 239 */     this.entry[192] = "Begin At";
/*     */ 
/* 241 */     this.entry[193] = "Workspace Tree position";
/* 242 */     this.entry[194] = "Left";
/* 243 */     this.entry[195] = "Right";
/* 244 */     this.entry[196] = "WARNING:";
/* 245 */     this.entry[197] = "<HTML>If you use a PowerPack resource, your game<br/><b>MUST</b> be licensed under GPL v3";
/*     */ 
/* 247 */     this.entry[198] = "Add Image";
/* 248 */     this.entry[199] = "Main";
/* 249 */     this.entry[200] = "Move";
/* 250 */     this.entry[201] = "Draw 2D";
/* 251 */     this.entry[202] = "Clipboard";
/* 252 */     this.entry[203] = "System";
/* 253 */     this.entry[204] = "Add timeline";
/* 254 */     this.entry[205] = "Empty Module";
/* 255 */     this.entry[206] = "Modules";
/* 256 */     this.entry[207] = "Add script";
/* 257 */     this.entry[208] = "Levels";
/* 258 */     this.entry[209] = "Images";
/* 259 */     this.entry[210] = "Sprites";
/* 260 */     this.entry[211] = "Tilesets";
/* 261 */     this.entry[212] = "Sounds";
/* 262 */     this.entry[213] = "Timelines";
/* 263 */     this.entry[214] = "Objects";
/* 264 */     this.entry[215] = "Levels";
/* 265 */     this.entry[216] = "Scripts";
/* 266 */     this.entry[217] = "Distribution";
/* 267 */     this.entry[218] = "Settings";
/* 268 */     this.entry[219] = "Begin block";
/* 269 */     this.entry[220] = "End block";
/* 270 */     this.entry[221] = "Comment";
/* 271 */     this.entry[222] = "Execute code";
/* 272 */     this.entry[223] = "Set horizontal speed";
/* 273 */     this.entry[224] = "Set $apply's horizontal speed to $value";
/* 274 */     this.entry[225] = "Set vertical speed";
/* 275 */     this.entry[226] = "Set $apply's vertical speed to $value";
/* 276 */     this.entry[227] = "Go to the next scene";
/* 277 */     this.entry[228] = "Go to the previous scene";
/* 278 */     this.entry[229] = "Add image to sprite";
/* 279 */     this.entry[230] = "If Clipboard has text";
/* 280 */     this.entry[231] = "If Clipboard is empty";
/* 281 */     this.entry[232] = "Image URL";
/* 282 */     this.entry[233] = "Warning: It is not recommended to load images from the Internet";
/* 283 */     this.entry[234] = "Sprite";
/* 284 */     this.entry[235] = "What to do if loading fails?";
/* 285 */     this.entry[236] = "What to do if the image can't be added to the Sprite?";
/* 286 */     this.entry[237] = "Ignore";
/* 287 */     this.entry[238] = "Abort";
/* 288 */     this.entry[239] = "Interrupt event";
/* 289 */     this.entry[240] = "Set the horizontal speed";
/* 290 */     this.entry[241] = "Of:";
/* 291 */     this.entry[242] = "To:";
/* 292 */     this.entry[243] = "NOT";
/* 293 */     this.entry[244] = "About";
/* 294 */     this.entry[245] = "Add Group";
/* 295 */     this.entry[246] = "Delete";
/* 296 */     this.entry[247] = "Minimize";
/* 297 */     this.entry[248] = "Restore";
/* 298 */     this.entry[249] = "Maximize";
/* 299 */     this.entry[250] = "Cascade";
/* 300 */     this.entry[251] = "Navigator";
/* 301 */     this.entry[252] = "Cut";
/* 302 */     this.entry[253] = "Copy";
/* 303 */     this.entry[254] = "Paste";
/* 304 */     this.entry[255] = "Delete";
/*     */     try
/*     */     {
/* 307 */       init();
/*     */     }
/*     */     catch (Exception e) {
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getSpecialEntry(String value) {
/* 314 */     if (value.equals("GPlus.CompileCur"))
/* 315 */       return "Compile Current Extension";
/* 316 */     if (value.equals("GAH.Menu"))
/* 317 */       return "Advanced";
/* 318 */     if (value.equals("GAH.GC"))
/* 319 */       return "Force garbage collection";
/* 320 */     return "";
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.languages.English
 * JD-Core Version:    0.6.2
 */