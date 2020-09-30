import java.util.Comparator;
import java.util.Map;

public class MapCompare implements Comparator<Integer> {
	Map<Integer, Integer> frequencyMap;
	
	MapCompare(Map<Integer,Integer> mapCounter) {
		frequencyMap = mapCounter;
	}

	@Override
	public int compare(Integer first, Integer second) {
		// Map - item, freq
		
 
        int isSecondFreqGreater = frequencyMap.get(second).compareTo(frequencyMap.get(first)); 
  
        int isFirstgreater = first.compareTo(second); 
   
        if (isSecondFreqGreater == 0) 
            return isFirstgreater; 
        else
            return isSecondFreqGreater; 
    } 
}
