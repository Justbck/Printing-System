/** *********************************************************************
 * File:      PaperTechnician.java  (Class)
 * Author:    J.Bucko	
 * Contents:  6SENG002W CWK  
 *             
 *             
 *            
 * Date:      03/01/2021
 * Version:   1.0	
 ************************************************************************ */

public class PaperTechnician extends Thread {
    
    private final LaserPrinter laserPrinter;
    private final String paperTechnicianName;
    private final ThreadGroup TechnicianThreadGroup;
    
    public PaperTechnician(LaserPrinter technicianLaserPrinter, ThreadGroup TechnicianThreadGroup, String paperTechnicianName){
        super(TechnicianThreadGroup, paperTechnicianName);
        this.paperTechnicianName =  paperTechnicianName;
        this.laserPrinter = technicianLaserPrinter;
        this.TechnicianThreadGroup = TechnicianThreadGroup;        
    }

    

    public void run() {
        
        
        laserPrinter.refillPaper(); 
        System.out.println(getName() + " Paper Refill // nr.1: ");

        try {
            sleep((int) (Math.random() * 1000)); 
        } catch (InterruptedException e) {
        }

        laserPrinter.refillPaper();
        System.out.println(getName() + " Paper Refill // nr.2: ");

        try {
            sleep((int) (Math.random() * 1000));
        } catch (InterruptedException e) {
        }

        laserPrinter.refillPaper();
        System.out.println(getName() + " Paper Refill // nr.3: ");
        
    }
    
    
}
