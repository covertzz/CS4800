import java.io.File;

public class FlyweightDriver {
    public void driver() {
        File file = new File("output.txt");
        Message message1 = new Message("HelloWorldCS5800", "Times New Roman", "Black", 12);
        Message message2 = new Message("HelloWorldCS5800", "Ariel", "Red", 10);
        Message message3 = new Message("HelloWorldCS5800", "Calibri", "Green", 100);
        Message message4 = new Message("HelloWorldCS5800", "Papyrus", "Pink", 1);

        message1.print(file);
        message2.print(file);
        message3.print(file);
        message4.print(file);

    }
}
