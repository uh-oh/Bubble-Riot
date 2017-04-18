/** this class contains the methods to take a decimal value for a character
* and converts it to useful information
*/

public class character
{
	String[] Value = {" ","!","\"","#","$","%","&","‘","(",")","*","+",",","-",
		".","/","0","1","2","3","4","5","6","7","8","9",":",";","<","=",">","?",
		"@","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q",
		"R","S","T","U","V","W","X","Y","Z","[","\\","]","^","_","`","a","b",
		"c","d","e","f","g","h","l","j","k","l","m","n","o","p","q","r","s","t",
		"u","v","w","x","y","z","{","|","}","~"};
	String[] Description = {"space","exclamation mark","quotation mark",
		"number sign, hash tag","dollar sign","percent sign","ampersand",
		"apostrophe","left parenthesis","right parenthesis","asterisk",
		"plus sign","comma","minus sign, hyphen","period","slash","zero",
		"one","two","three","four","five","six","seven","eight","nine","colon",
		"semicolon","less than sign","equal sign","greater than sign",
		"question mark","at sign","capital letter a","capital letter b",
		"capital letter c","capital letter d","capital letter e",
		"capital letter f","capital letter g","capital letter h",
		"capital letter i","capital letter j","capital letter k",
		"capital letter l","capital letter m","capital letter n",
		"capital letter o","capital letter p","capital letter q",
		"capital letter r","capital letter s","capital letter t",
		"capital letter u","capital letter v","capital letter w",
		"capital letter x","capital letter y","capital letter z",
		"left square bracket","backslash","right square bracket",
		"circumflex accent","lowline, underscore","grave accent",
		"small letter a","small letter b","small letter c","small letter d",
		"small letter e","small letter f","small letter g","small letter h",
		"small letter i","small letter j","small letter k","small letter l",
		"small letter m","small letter n","small letter o","small letter p",
		"small letter q","small letter r","small letter s","small letter t",
		"small letter u","small letter v","small letter w","small letter x",
		"small letter y","small letter z","left curly bracket","vertical bar",
		"right curly bracket","tilde"};
	String[] Unicode = {"U+0020","U+0021","U+0022","U+0023","U+0024","U+0025",
		"U+0026","U+0027","U+0028","U+0029","U+002A","U+002B","U+002C","U+002D",
		"U+002E","U+002F","U+0030","U+0031","U+0032","U+0033","U+0034","U+0035",
		"U+0036","U+0037","U+0038","U+0039","U+003A","U+003B","U+003C","U+003D",
		"U+003E","U+003F","U+0040","U+0041","U+0042","U+0043","U+0044","U+0045",
		"U+0046","U+0047","U+0048","U+0049","U+004A","U+004B","U+004C","U+004D",
		"U+004E","U+004F","U+0050","U+0051","U+0052","U+0053","U+0054","U+0055",
		"U+0056","U+0057","U+0058","U+0059","U+005A","U+005B","U+005C","U+005D",
		"U+005E","U+005F","U+0060","U+0061","U+0062","U+0063","U+0064","U+0065",
		"U+0066","U+0067","U+0068","U+0069","U+006A","U+006B","U+006C","U+006D",
		"U+006E","U+006F","U+0070","U+0071","U+0072","U+0073","U+0074","U+0075",
		"U+0076","U+0077","U+0078","U+0079","U+007A","U+007B","U+007C","U+007D",
		"U+007E"};

	public character(){}
	public String getValue(int a) {return Value[a-32];}
	public String getDescription(int a) {return Description[a-32];}
	public String getUnicode(int a) {return Unicode[a-32];}

}
