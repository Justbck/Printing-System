    /** *********************************************************************
 * File:      Student.java  (Class)
 * Author:    J.Bucko	
 * Contents:  6SENG002W CWK  
 *             
 *             
 *            
 * Date:      03/01/2021
 * Version:   1.0	
 ************************************************************************ */

public class Student extends Thread {
    
    private final LaserPrinter laserPrinter;
    private final String studentName;
    private final ThreadGroup StudentThreadGroup;
    
    
    
    public Student(LaserPrinter studentLaserPrinter, ThreadGroup StudentThreadGroup, String studentName) {
        super(StudentThreadGroup, studentName);
        this.laserPrinter = studentLaserPrinter;
        this.studentName = studentName; 
        this.StudentThreadGroup = StudentThreadGroup;
    }
    //constructor

    
    public void run() {
        
        Document CWK1 = new Document(studentName, "Coursework nr.1", 10); 
        Document CWK2 = new Document(studentName, "Coursework nr.2", 15);
        Document CWK3 = new Document(studentName, "Coursework nr.3", 20);
        Document CWK4 = new Document(studentName, "Coursework nr.4", 22);
        Document CWK5 = new Document(studentName, "Coursework nr.5", 25);

        laserPrinter.printDocument(CWK1); // prints each document 
        System.out.println(getName() + " Printed: " + CWK1.getDocumentName());

        try {
            sleep((int) (Math.random() * 500)); 
        } catch (InterruptedException e) {
        }

        laserPrinter.printDocument(CWK2);
        System.out.println(getName() + " Printed: " + CWK2.getDocumentName());

        try {
            sleep((int) (Math.random() * 500));          
        } catch (InterruptedException e) {
        }

        laserPrinter.printDocument(CWK3);
        System.out.println(getName() + " Printed: " + CWK3.getDocumentName());

        try {
            sleep((int) (Math.random() * 500));
        } catch (InterruptedException e) {
        }

        laserPrinter.printDocument(CWK4);
        System.out.println(getName() + " Printed: " + CWK4.getDocumentName());

        try {
            sleep((int) (Math.random() * 1000));
        } catch (InterruptedException e) {
        }

        laserPrinter.printDocument(CWK5);
        System.out.println(getName() + " Printed: " + CWK5.getDocumentName());

    }
        
        
        
    }
    
    
    //use the documnet class
    //instances of this class are used to represent a document 
    //that students request the printer to be printed
    // to create 5 instaces of this class to represent 5
    //"documents" that the student request the printer to print
    
    //example Joe Bloggs wants to print 20 pages of CWK2
    //Document CWK2 = new Document("JoeBloggs","cwk2", 20)
    //printer.printDocument( CWK2 )
    
    //have private data members that hold the information assosiated with him/her 
    //the tread group he/she is in; his/her printer; his/her name
    
    //single constructor that initialised his/hers information, 
    //including placing the student in the "student" thread group
    

    
    

