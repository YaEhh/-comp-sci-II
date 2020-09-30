import java.util.ArrayList;
import java.util.List;

public class WordCount extends FileProcessor<List<Integer>>{
	int characters;
	int words;
	int lines;
	protected  void startFile() {
		characters =0;
		words = 0;
		lines = 0;
	}

	protected  void processLine(String line) {
		//we can use split by ' ' and get the size of the string array
		char p = ' ';
		for(int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
		    if(!Character.isWhitespace(c) && Character.isWhitespace(p))
		    	words ++ ;	
		    p = c;
		}
		this.characters = characters + line.length();
		lines ++ ;	
	}

	protected List<Integer> endFile() {
		List<Integer> pList = new ArrayList<Integer>();
		pList.add(new Integer(characters));
		pList.add(new Integer(words));
		pList.add(new Integer(lines));
		return pList;	
	}
}
