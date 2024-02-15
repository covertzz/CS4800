package Aggregation;
class Driver {
    public static void main(String[] args) {
        Course course1 = new Course();
        course1.setName("CS4800");        
        course1.getInstructor().setFirstName("Nima");
        course1.getInstructor().setLastName("Davarpanah");
        course1.getInstructor().setOfficeNum("3-2636");
        course1.getTextbooks().setTitle("Clean Code");
        course1.getTextbooks().setAuthor("Robert C. Martin");
        course1.getTextbooks().setPublisher("Pearson Education");

        System.out.println("");

        Course course2 = new Course();
        course2.setName("BIO1210");        
        course2.getInstructor().setFirstName("Lucy");
        course2.getInstructor().setLastName("Liu");
        course2.getInstructor().setOfficeNum("94-282");
        course2.getTextbooks().setTitle("Biological Science, 6th ed.");
        course2.getTextbooks().setAuthor("Freeman");
        course2.getTextbooks().setPublisher("Pearson Education");

        course1.print();
        course2.print();
    }
}
