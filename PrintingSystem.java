/** *********************************************************************
 * File:      PrintingSystem.java  (Class)
 * Author:    J.Bucko	
 * Contents:  6SENG002W CWK  
 *             
 *             
 *            
 * Date:      03/01/2021
 * Version:   1.0	
 ************************************************************************ */

public class PrintingSystem {


    public static void main(String[] args) {
        
        
        
        //creates printing system object
        final String PRINTER_NAME = "lp-CG.24";
        System.out.println("Setting...");
        
        LaserPrinter prt1 = new LaserPrinter(PRINTER_NAME); 
        
        
        //creates 2 thread groups
        // - 1 thread  for technitians
        // - 1 thread for students 
        
        ThreadGroup StudentThreadGroup = new ThreadGroup("StudentThreadGroup");  // creates the thread groups
        ThreadGroup TechnicianThreadGroup = new ThreadGroup("TechnicianThreadGroup");
        
        
        //creates 4 instance of the student class
        // 4 different student threads
        
        Student s1 = new Student(prt1 , StudentThreadGroup, "Anna"); // creates the students
        Student s2 = new Student(prt1, StudentThreadGroup, "Ben");
        Student s3 = new Student(prt1, StudentThreadGroup, "Charlotte");
        Student s4 = new Student(prt1, StudentThreadGroup, "Daniel");
        
  
        
        //instance of thr PaperTechnitian
        PaperTechnician p1 = new PaperTechnician(prt1, TechnicianThreadGroup, "Eric"); // creates the technicians 
        //instance of thr TonerTechnitian
        TonerTechnician t1 = new TonerTechnician(prt1, TechnicianThreadGroup, "Frank");
        
        
        //constructor for each 
        
        //main program waits untill all 6 threads have terminated
        //at which point it prints out the final status of the printer 
        
        //it must print out reports of what it is doing and when
        //it has finished creating the threads and other objects
        
        System.out.println("Start Technicians & Students");

        s1.start();
        s2.start();
        s3.start();
        s4.start();

        p1.start();
        t1.start();
        
        System.out.println("Active Count StudentThreadGroup: " + StudentThreadGroup.activeCount() + "\nActive Count TechThreadGroup: " + TechnicianThreadGroup.activeCount());

//         wait for all threads to terminate
        try {
            p1.join();
            t1.join();

            s1.join();
            s2.join();
            s3.join();
            s4.join();
        } catch (Exception e) {
            System.out.println("Interrupted");
        }

        System.out.println("Done");

    
        
        

        
    }
    
}
