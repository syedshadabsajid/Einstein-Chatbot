package dataProvider;
import java.io.IOException; 
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTP;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.OutputStream;


public class CsvFromFTP {
	
	public static void getFtpFile(String fileName) {
        
		  FTPClient client = new FTPClient();
		  
		  try {
		 
		client.connect("ftp.india.rsystems.com");
		  
		// Try to login and return the respective boolean value
		boolean login = client.login("Invisor", "Invisor!@#");
		  
		// If login is true notify user
		 
		if (login) {
		 
		    System.out.println("Connection established...");
		    
		    client.enterLocalPassiveMode();
            client.setFileType(FTP.BINARY_FILE_TYPE);
 
            // APPROACH #1: using retrieveFile(String, OutputStream)
            String remoteFile1 = "/" + fileName;
            String path = "C:/Download/" + fileName;
            File downloadFile1 = new File(path);
            OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
            boolean success = client.retrieveFile(remoteFile1, outputStream1);
            outputStream1.close();
 
            if (success) {
                System.out.println("File #1 has been downloaded successfully.");
            }
 
		
		    
		    // Try to logout and return the respective boolean value
		    boolean logout = client.logout();
		 
		    // If logout is true notify user
		    if (logout) {
		 
		  System.out.println("Connection close...");
		 
		    }
		//  Notify user for failure  
		} else {
		    System.out.println("Connection fail...");
		}
		  
		  } catch (IOException ex) {
	            System.out.println("Error: " + ex.getMessage());
	            ex.printStackTrace();
	        } finally {
	            try {
	                if (client.isConnected()) {
	                    client.logout();
	                    client.disconnect();
	                }
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	        }
	    }

}

