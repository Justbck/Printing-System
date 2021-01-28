/** *********************************************************************
 * File:      Document.java  (Class)
 * Author:    J.Bucko	
 * Contents:  6SENG002W CWK  
 *            This provides an "abstract" document object. 
 *            It includes the user id, the document's name & its length 
 *            in pages.
 * Date:      03/01/2021
 * Version:   1.0	
 ************************************************************************ */

public class Document
{
    private final String userID ;  
    private final String documentName ;  
    private final int    numberOfPages ;


    public Document( String studentName, String name, int length )
    {
        this.userID        = studentName ; 
        this.documentName  = name ;
        this.numberOfPages = length ;
    }


    public String getUserID() {
        return userID ; 
    }

    public String getDocumentName() { 
        return documentName ; 
    }

    public int getNumberOfPages() {
        return numberOfPages ; 
    }


    public String toString()
    {
       return new String( "DOCUMENT:  "  +
                                     "UserID: " + userID        + "/ " + 
                                     "Name: "   + documentName  + "/ " + 
                                     "Number of Pages: "  + numberOfPages + 
                                  " "  ) ;
    }

} // Document


