import java.util.ArrayList;
import java.io.*;

class TextStyle {
    String font;
    String color;
    int size;

    public TextStyle(String font, String color, int size) {
        this.font = font;
        this.color = color;
        this.size = size;
    }
    public void setFont(String font) {
        this.font = font;
    }
    public String getFont() {
        return font;
    }
    public void setColor(String font) {
        this.font = font;
    }
    public String getColor() {
        return font;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public int getSize() {
        return size;
    }
    public void print(String message, File file) {
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Font: " + font + ", Color: " + color + ", Size: " + size + ", Message: " + message + "\n");
            bw.close();
            fw.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    
}

class TextFactory {
    private static ArrayList<TextStyle> listOfTextStyles = new ArrayList<>();

    public static TextStyle getTextStyle(String font, String color, int size) {
        for(TextStyle textStyle : listOfTextStyles) {
            if(textStyle.getFont().equals(font) && textStyle.getColor().equals(color) && textStyle.getSize() == size) {
                return textStyle;
            }
        }
        return new TextStyle(font, color, size);
    }

}

class Message {
    String message;
    TextStyle textStyle;

    public Message(String message, String font, String color, int size) {
        this.message = message;
        textStyle = new TextStyle(font, color, size);
    }

    public void print(File file) {
        textStyle.print(message, file);
    }
}
