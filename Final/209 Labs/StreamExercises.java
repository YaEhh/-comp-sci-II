import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExercises {
	
	public int countLines(Path path, int thres) throws IOException{

		List<String> list = new ArrayList<>();
		Stream<String> stream = Files.lines(path);

		list = stream
		    .filter(line -> line.length()>=thres)
		    .collect(Collectors.toList());
		return list.size();
		
	}
	
	public List<String> collectWords(Path path) throws IOException{
		
		List<String> list = new ArrayList<String>();
		Stream<String> streamStr = Files.lines(path); 
				
		list = streamStr.map(x -> x.toLowerCase().split("[^a-z]+")) 
		    .flatMap(x -> Arrays.stream(x))
		    .filter(x -> x.length() != 0)
		    .sorted()
		    .distinct()
		    .collect(Collectors.toList());
		return list;
	}
}