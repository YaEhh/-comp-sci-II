import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.CRC32;

import static org.junit.Assert.assertEquals;

public class TailTest {
    
    @Test
    public void scanWarAndPeace() throws IOException {
        CRC32 check = new CRC32();
        int totalLines = 0;
        for(int k = 10; k <= 100000; k = k * 10) {
            Tail tail = new Tail(k);
            BufferedReader fr = new BufferedReader(
                new InputStreamReader(new FileInputStream("warandpeace.txt"), "UTF-8")
                );
            List<String> result = tail.processFile(fr);
            totalLines += result.size();
            fr.close();
            for(String line: result) {
                check.update(line.getBytes());
            }
        }

        assertEquals(10 + 100 + 1000 + 10000 + 63852, totalLines);
        assertEquals(1946545910L, check.getValue());
    }
}