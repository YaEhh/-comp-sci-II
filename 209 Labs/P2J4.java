import java.util.*;


public class P2J4 {
	
	public static List<Integer> runningMedianOfThree(List<Integer> items) {
		List<Integer> result = new ArrayList<Integer>();
		List<Integer> median = new ArrayList<Integer>();
		
		for (int idx = 0; idx < items.size(); idx++) {
			if (idx < 2) {
				result.add(items.get(idx));
			} else {
				median.add(items.get(idx)); median.add(items.get(idx - 1)); median.add(items.get(idx - 2));
				Collections.sort(median);
				result.add(median.get(1));
				median.clear();
			}
			
		}
		return result;
	}
	
	public static int firstMissingPositive(List<Integer> items) {
		if (items.isEmpty())
			return 1;
		
		for (int idx = 0; idx < items.size(); idx++) {
			if (items.contains(idx + 1)) {
				continue;
			} else {
				return idx + 1;
			}
		}
		return 1;
	}
	
	public static void sortByElementFrequency(List<Integer> items) {
		Map<Integer, Integer> counterMap = new HashMap<Integer,Integer>();
		
		for (Integer item: items) {
			int freq = counterMap.getOrDefault(item, 0);
			counterMap.put(item, freq + 1);
		}
		
		MapCompare mp = new MapCompare(counterMap);
		Collections.sort(items, mp);
	}
	
	public static List<Integer> factorFactorial(int n) {
		List<Integer> result = new ArrayList<Integer>();
		Integer totalProduct = 1;
		
		
		for (int i = 2; i <= n; i++) {
			totalProduct *= i;
			addPrimeFactorsToList(i, result);
		}
		Collections.sort(result);
		return result;
	}
	
	private static void addPrimeFactorsToList(int n, List<Integer> result) {
		for(int i = 2; i <= n; i++) {
	         while(n % i == 0) {
	            result.add(i);
	            n = n/i;
	         }
	      }
	      if(n > 2) {
	         result.add(n);
	      }
	}
}
