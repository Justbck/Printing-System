/** *********************************************************************
 * File:      LaserPrinter.java  (Class)
 * Author:    J.Bucko	
 * Contents:  6SENG002W CWK  
 *             
 *             
 *            
 * Date:      03/01/2021
 * Version:   1.0	
 ************************************************************************ */

//monitor not a thread !!!
//shared class


public class LaserPrinter implements ServicePrinter  {
    
     private final String printerName;
     private int currentPaperLevel;
     private int currentTonerLevel;
     private int numberOfDocumentsPrinted;
     
    //constructor 
    public LaserPrinter(String printerName){
        this.printerName = printerName;
        //initislise variables
        this.currentPaperLevel = 5;
        this.currentTonerLevel = 5;
        //no documnets printed 
        this.numberOfDocumentsPrinted = 0;
    }
    
    @Override
    //toner technician refills toner
    public synchronized void replaceTonerCartridge() {
        
         if (!(currentTonerLevel < ServicePrinter.Minimum_Toner_Level)) { // if toner is not under 10 it will wait 5 seconds and try to replace anyway
            try {
                wait(5000);
            } catch (InterruptedException e) {
                System.out.println("------------------- Thread  interrupted -------------------");
            }
        }

        if ((currentTonerLevel < ServicePrinter.Minimum_Toner_Level)) { // only replaces if toner level is under 10
            this.currentTonerLevel = ServicePrinter.Full_Toner_Level;
            printState("Refilled Toner: ");
        }

        notifyAll();
       
    }

    @Override
    //paper technician refills paper
    public synchronized void refillPaper() {
        //        while (!(currentPprLvl < (ServicePrinter.Full_Paper_Tray - ServicePrinter.SheetsPerPack))) {
        if (currentPaperLevel > (ServicePrinter.Full_Paper_Tray - ServicePrinter.SheetsPerPack)) { // if paper level is higher than 200 it will wait 5 secnds and try replace anyway
            try {
                wait(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }

        while (this.currentPaperLevel < (ServicePrinter.Full_Paper_Tray - ServicePrinter.SheetsPerPack)) { // it will replace as many packs as it can before the printer its full without wasting paper
            this.currentPaperLevel = this.currentPaperLevel + ServicePrinter.SheetsPerPack;
            printState("Refilled Paper: ");
        }

        notifyAll();
    }

    @Override
    //students prints document
    public void printDocument(Document document) {
       //if the printer does not have enought paper or toner, the process has to wait
       while ((currentPaperLevel < document.getNumberOfPages()) || (currentTonerLevel < document.getNumberOfPages()) ){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("ERROR");
            }
       }
       
        // gets pages of the given document and prints them
        // machine uses 1 paper per page 
        // and one unit of toner per page
        // state is upaded as those products are used
        
        for (int i = 1; i <= document.getNumberOfPages(); i++) { 
            this.currentPaperLevel--;
            this.currentTonerLevel--;
            printState("printDocument(): " + document.getUserID() + "." + document.getDocumentName() + ".Page(" + i + "/" + document.getNumberOfPages());
        }
        //adds 1 to the number of documents printed 
        this.numberOfDocumentsPrinted++;
        
        notifyAll();
        printState("Status(): "); // prints the paper status after each print
       
    }
    
    public void printState(String operation) {
        System.out.println("Laser Printer " + operation + this);
    }
    
    
    public String toString() {
       return new String("[ PRINTER ID: " + printerName
                + " // PAPER LEVEL: " + currentPaperLevel
                + " // TONER LEVEL: " + currentTonerLevel
                + " // DOCUMENTS PRINTED: " + numberOfDocumentsPrinted + " ]");
    }
    
    
    //implement ServicePrinter interface
    //  - This interface defines the complete 
    //    interface to the printer for both students and
    //    technicians. 
    //DONE !!!
    
    
    
    //use the Document class
    //  - Instances of this class are used to represent a "document" that students request the
    //    printer to be printed. 
    
    
    
    
    //Have private data members that hold the information associated with the printer, i.e.
    //the printer's name/id, the current paper level, the current toner level and the number
    //of documents printed.
    //DONE !!!

    
    // A single constructor that initializes the printer.
    //DONE !!!
    
    
    // A toString() method that returns a String representation of the current state of the
    //printer. For example:
    //[ PrinterID: lp-CG.24, Paper Level: 35, Toner Level: 310, Documents Printed: 4 ] 
    //DONE !!!


    
    //allow students to print documents using printDocumnet(document) method
    //assume that to print one page of a documnet you need 1  sheet of paper and one unit of toner
    
    //allow techintian to refill paper or toner of both using refillPaper()
    // 50 sheets per pack of paper
    // printer can hold 250 sheets of paper max

    //allow toner technitian to replace the toner cartidge using the replacaTonerCartridge() 
    //if has a toner level less than 10
    // toner can print 500 sheets of paper
    
    //the printer status must be a correct record
    
    //each user must have mutual exclusive and access to the printer
    
    //allow any user of the printer to call toString to get string representation of its status
}
