import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class UnitTests {
    public static void testAll() {
        songProxyFetchTimeTest();
        textStylesTest();
    }

    public static void songProxyFetchTimeTest() {
        Song testSong = new Song("test", "test", "test", 0, 0);

        long startTime1 = System.nanoTime();
        testSong.playSong();
        long endTime1 = System.nanoTime();

        long startTime2 = System.nanoTime();
        testSong.playSong();
        long endTime2 = System.nanoTime();

        if((endTime1-startTime1)/10000000 < 1 || (endTime2-startTime2)/1000000 > 1) {
            System.out.println("ERROR: songProxyFetchTimeTest");
        }
    }

    public static void textStylesTest() {
        File testFile = new File("testOutput.txt");
        Message message = new Message("test message", "test font", "test color", 15);

        message.print(testFile);
        
        try {
            Scanner scanner = new Scanner(testFile);
            boolean found = false;
            while(scanner.hasNext()) {
                String line = scanner.nextLine();
                if(line.equals("Font: test font, Color: test color, Size: 15, Message: test message")) {
                    found = true;
                }
            }
            scanner.close();

            if(!found) {
                System.out.println("ERROR: textStylesTest");
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        
    }

}
