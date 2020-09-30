import java.util.ArrayList;

public class P2J3 {
	
	public static void main(String[] args) {
		int[] testArr =  {2, 4, 5, 8, 11, 13, 17};
		boolean result = subsetSum(testArr, 3, 23);
	}
	

	public static boolean subsetSum(int[] items, int n, int goal) {
        if (goal == 0) {
        	return true;         	
        }
        if (n == 0) {
        	return false;         	
        }
        if (items[n-1] > goal) {
        	return subsetSum(items, n-1, goal);         	
        }
        
        return subsetSum(items, n-1, goal) || subsetSum(items, n-1, goal-items[n-1]); 
	}

	
	public static String reverseVowels(String text) {
		StringBuilder vowelSb = new StringBuilder("aeiouAEIOU");
		StringBuilder vowelList = new StringBuilder();
		StringBuilder newString = new StringBuilder();
		ArrayList<Integer> idxList = new ArrayList<Integer>();
		ArrayList<Integer> isCapitalizedArr = new ArrayList<Integer>();	
		int listIdx = 0;
	
		for (int idx = 0; idx < text.length(); idx++) {
			char ch = text.charAt(idx);
			if (Character.isUpperCase(ch)) {
				isCapitalizedArr.add(idx);
			} 
			if (vowelSb.toString().contains(text.substring(idx, idx + 1))) {
				vowelList.append(ch);
				idxList.add(idx);
			}
		}
		
		vowelList.reverse();
	
		for (int idx = 0; idx < text.length(); idx++) {
			if (vowelList.toString().contains(text.substring(idx, idx + 1))) {
				Character ch = vowelList.charAt(listIdx);
				if (isCapitalizedArr.contains(idx)) {
					newString.append(Character.toUpperCase(ch));
				} else {
					if (Character.isUpperCase(ch)) {
						newString.append(Character.toLowerCase(ch));
					} else {
						newString.append(ch);						
					}
				}
				listIdx++;
			} else {
				Character ch = text.charAt(idx);
				if (isCapitalizedArr.contains(idx)) {
					newString.append(Character.toUpperCase(ch));										
				} else {
					newString.append(ch);	
				}
			}
		}
		return newString.toString();
	}
	
	public static String pancakeScramble(String text) {
		
		StringBuilder textSb = new StringBuilder(text);
		
		for (int flip = 2; flip < text.length() + 1; flip++) {
			StringBuilder tempSb = new StringBuilder();
			tempSb.append(textSb.substring(0, flip ));
			tempSb.reverse();
			tempSb.append(textSb.substring(flip, textSb.length()));
			textSb = new StringBuilder(tempSb);
			tempSb.delete(0, tempSb.length());
		}
		
		return textSb.toString();
	}
	
	
	public static int[] reverseAscendingSubarrays(int[] items) {
		ArrayList<Integer> ascendingSublist = new ArrayList<Integer>();
		int prevItem = 0;
		
		for (int idx = 0; idx < items.length; idx++) {
			int currentItem = items[idx]; 
			
			if (ascendingSublist.isEmpty()) {
				ascendingSublist.add(currentItem);
				prevItem = currentItem;
			}else {
				if (currentItem > prevItem) {
					ascendingSublist.add(currentItem);
					prevItem = currentItem; 	
				}else {
					for (int i = 0; i < ascendingSublist.size(); i++) {
						items[idx - i - 1] = ascendingSublist.get(i); 
					}
					ascendingSublist.clear();
					ascendingSublist.add(currentItem);
					prevItem = currentItem;
				}
			}
		}
		
		if (ascendingSublist.size() > 0) {
			for (int j = 0; j < ascendingSublist.size(); j++) {
				items[items.length - j - 1] = ascendingSublist.get(j); 
			}
		}
		return items;
	}
}
