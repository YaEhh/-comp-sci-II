import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class Tail extends FileProcessor <List<String>> {
	private int nrOfLines;
	static LinkedList<String> list;
	
	public Tail(int n) {
		nrOfLines = n;
		list = new LinkedList<String>();
	}

	@Override
	protected void startFile() {
	}

	@Override
	protected void processLine(String line) {
		list.add(line);
		
	}

	@Override
	protected List<String> endFile() {
		ArrayList<String> out = new ArrayList<String>();
		if (nrOfLines > list.size()) {
			return list;
		}
		for(int i = list.size()- nrOfLines; i < list.size(); i++) {
			out.add( (String)list.get(i));
		}
		return out;
	}
}
