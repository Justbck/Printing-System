/** *********************************************************************
 * File:      TonerTechnician.java  (Class)
 * Author:    J.Bucko	
 * Contents:  6SENG002W CWK  
 *             
 *            
 *            
 * Date:      03/01/2021
 * Version:   1.0	
 ************************************************************************ */

public class TonerTechnician extends Thread {
    
    private final LaserPrinter laserPrinter;
    private final String tonerTechnicianName;
    private final ThreadGroup TechnicianThreadGroup;
    
    public TonerTechnician(LaserPrinter technicianLaserPrinter, ThreadGroup TechnicianThreadGroup, String tonerTechnicianName){
        super(TechnicianThreadGroup, tonerTechnicianName);
        this.tonerTechnicianName =  tonerTechnicianName;
        this.laserPrinter = technicianLaserPrinter;
        this.TechnicianThreadGroup = TechnicianThreadGroup;
    }


    

    public void run() {
        laserPrinter.replaceTonerCartridge(); 
        System.out.println(getName() + " Toner refill // nr.1: ");

        try {
            sleep((int) (Math.random() * 1000)); 
        } catch (InterruptedException e) {
        }

        laserPrinter.replaceTonerCartridge();
        System.out.println(getName() + " Toner refill // nr.2: ");

        try {
            sleep((int) (Math.random() * 1000));
        } catch (InterruptedException e) {
        }

        laserPrinter.replaceTonerCartridge();
        System.out.println(getName() + " Toner refill // nr.3: ");
    }
    
}
