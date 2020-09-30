import java.util.ArrayList;

public class P2J2 {
	
	public static int recaman(int n) {
		ArrayList<Integer> recamanSequence = new ArrayList<Integer>();
		boolean[ ] containArr = new boolean[10*n ];
		
		for (int i = 0; i < n +1;  i++) {
			if (i == 0 ) {
				recamanSequence.add(i);
				containArr[i] = true;
				continue;
			}
			int sub = recamanSequence.get(i - 1) - i;
			if ((sub >  0) && (!containArr[ (sub) ] ))  {
				recamanSequence.add(sub);
				containArr[sub] = true;
			} else {
				recamanSequence.add(recamanSequence.get(i - 1) + i);
				containArr[recamanSequence.get(i - 1) + i] = true;
			}
		}
		
		return recamanSequence.get(recamanSequence.size() - 1);
	}
	
//	 1, 3, 6, 2, 7, 13, 20, 12, 21, 11,
//	7th returns 20
//	19th returns 62
	
	public static String removeDuplicates(String text) {
		String newText = "";
		char previous_ch = '\0';
		
		for (int i = 0; i < text.length(); i++) {
			if (i == 0) {
				newText += text.charAt(i);
				previous_ch = text.charAt(i);
				continue;
			}
			
			if (text.charAt(i) == previous_ch) {
				previous_ch = text.charAt(i);
				continue;
			}
			
			previous_ch = text.charAt(i);
			newText += text.charAt(i);
		}
		
		return newText;
	}
	
	public static String uniqueCharacters(String text) {
		String newText = "";
		char[ ] uniqueLettersArr = new char[text.length()];
		int uniqueIndex = 0;
		
		for (int i = 0; i < text.length(); i++) {
			boolean contain = false;
			char c = text.charAt(i);
			
			for (char ch : uniqueLettersArr) {
				if (ch == c) {
					contain = true;
					break;
				}
			}
			
			if (!contain) {
				newText += c;
				uniqueLettersArr[uniqueIndex] = c;
				uniqueIndex++;
			}
		}
		return newText;
	}
	
	public static int countSafeSquaresRooks(int n, boolean[][] rooks) {
		int safeSquares = 0;
		ArrayList<Integer> rowsWithRooks = new ArrayList<Integer>();
		ArrayList<Integer> colsWithRooks = new ArrayList<Integer>();
		
		for (int row = 0; row < rooks.length; row++) {
			 for (int col = 0; col < rooks[row].length; col++) {
				 if (rooks[row][col]) {
					 if (!rowsWithRooks.contains(row)) {
						 rowsWithRooks.add(row);						 
					 }
					 if (!colsWithRooks.contains(col)) {
						 colsWithRooks.add(col);					 
					 }
					 
				 }
			 }
		}
		
		for (int row = 0; row < rooks.length; row++) {
			 for (int col = 0; col < rooks[row].length; col++) {
				 if (!rowsWithRooks.contains(row) && !colsWithRooks.contains(col)) {
					 safeSquares++;
				 }
			 }
		}
		
		return safeSquares;
	}

}
