package Composition;
import java.util.ArrayList;

abstract class Item {
    abstract String getName();
    abstract void setName(String name);
    abstract void print(int depth);
}

class Folder extends Item {
    ArrayList<Item> itemsInFolder = new ArrayList<>();

    String name;

    public Folder(String name) {
        this.name = name;
    }
    public ArrayList<Item> getItemsInFolder() {
        return itemsInFolder;
    }
    public String getName() {
        return name;  
    }
    public void setName(String name) {
        this.name = name;
    }
    public void addItem(Item item){
        itemsInFolder.add(item);
    }
    public void print(){
        int depth = 0;
        System.out.println("+" + name);
        for(Item i : itemsInFolder) {
            System.out.print("\t");
            i.print(depth+1);
        }
    }
    public void print(int depth){
        System.out.println("+" + name);
        for(Item i : itemsInFolder) {
            for(int j = 0; j < depth+1; j++) {
                System.out.print("\t");
            }
            i.print(depth+1);
        }
    }
    public void delete(Item item) {
        if(itemsInFolder.contains(item)) {
            itemsInFolder.remove(item);
        }
        else {
            for(Item i : itemsInFolder) {
                if(i instanceof Folder) {
                    ((Folder) i).delete(item);
                } 
            }
        }
        
    }
}

class File extends Item{
    String name;

    public File(String name) {
        this.name = name;
    }
    public String getName() {
        return name;  
    }
    public void setName(String name) {
        this.name = name;
    }
    public void print(int depth) {
        System.out.println(name);
    }
}