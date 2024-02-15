package Aggregation;
class Course {
    static Instructor instructor = new Instructor();
    static Textbooks textbooks = new Textbooks();

    private String name;

    public void print() {
        System.out.printf("The course name is %s\n", name);
        System.out.printf("The instructor's name is %s %s and their office is %s\n", 
        instructor.getFirstName(), instructor.getLastName(), instructor.getOfficeNum());
        System.out.printf("The textbook required is %s, the author is %s, and the publisher is %s\n", 
        textbooks.getTitle(), textbooks.getAuthor(), textbooks.getPublisher());
    }
    public String getName() {
        return name;  
    }
    public void setName(String name) {
        this.name = name;
    }
    public Instructor getInstructor() {
        return instructor;  
    }
    public Textbooks getTextbooks() {
        return textbooks;
    }
}

class Instructor {
    String firstName;
    String lastName;
    String officeNum;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getOfficeNum() {
        return officeNum;
    }
    public void setOfficeNum(String officeNum) {
        this.officeNum = officeNum;
    }
}

class Textbooks {
    String title;
    String author;
    String publisher;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}

