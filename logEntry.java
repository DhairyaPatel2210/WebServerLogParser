import java.util.*;
import edu.duke.*;
/**
 * Write a description of logEntry here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class logEntry {
    private String ipAddress;
    private Date accessTime;
    private String requests;
    private int statusCode;
    private int bytesReturned;
    
    public logEntry(String ip, Date time, String req, int status, int bytes){
        ipAddress = ip;
        accessTime = time;
        requests = req;
        statusCode = status;
        bytesReturned = bytes;
    }
    
    public String getIpAddress(){
        return ipAddress;
    }
    
    public Date getAccessTime(){
        return accessTime;
    }
    
    public String getRequests(){
        return requests;
    }
    
    public int getStatusCode(){
        return statusCode;
    }
    
    public int getBytes(){
        return bytesReturned;
    }
    
    public String toString(){
        return ipAddress + " " + accessTime + " " + requests + " " + statusCode + " " + bytesReturned;
        
    }
}

