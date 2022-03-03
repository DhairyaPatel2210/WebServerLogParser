import java.util.*;
import edu.duke.*;
/**
 * Write a description of logAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class logAnalyzer {
    private ArrayList<logEntry> logs ;
    
    public logAnalyzer(){
        logs = new ArrayList<logEntry>();
    }
    
    public void readFile(String filename){
        FileResource fr = new FileResource("data/" + filename);
        for(String log : fr.lines()){
            logs.add(WebLogParser.parseEntry(log));
        }
    }
    
    public void printAll(){
        for(int i=0; i < logs.size() ; i++){
            System.out.println(logs.get(i));
        }
    }
    
    public int uniqueIps(){
        ArrayList<String> uniqueIp = new ArrayList<String>();
        for(logEntry le : logs){
            if(!uniqueIp.contains(le.getIpAddress())){
                uniqueIp.add(le.getIpAddress());
            }
        }
        return uniqueIp.size();
    }
    
    
    public void printAllHigherThanNum(int num){
        for(logEntry le : logs){
            if(le.getStatusCode() > num ){
                System.out.println(le.getStatusCode());
            }
        }
    }
    
    public ArrayList<String> uniqueIPVisitsOnDay(String day){
        ArrayList<String>  uniqueOnDay = new ArrayList<String>();
        for(logEntry le : logs){
            Date d = le.getAccessTime();
            String date = d.toString();
            String arrayString[] = date.split(" ");
            String currentDate = arrayString[1] + " " + arrayString[2];
            if(currentDate.equals(day)){
                if(!uniqueOnDay.contains(le.getIpAddress())){
                uniqueOnDay.add(le.getIpAddress());
            }
            }
        }
        return uniqueOnDay;
    }
    
    public int countUniqueIPsInRange(int low, int high){
        ArrayList<String> uniqueIp = new ArrayList<String>();
        for(logEntry le : logs){
            String ip = le.getIpAddress();
            int statusCode = le.getStatusCode();
            if(statusCode >= low && statusCode <= high){
                if(!uniqueIp.contains(ip)){
                    uniqueIp.add(ip);
                }
            }
        
        }
        return uniqueIp.size();
    }
    
    private HashMap<String,Integer> makeHashMap(){
        HashMap <String,Integer> testCounts = new HashMap<String,Integer>();
        for(logEntry le : logs){
            String ip  = le.getIpAddress();
            if(!testCounts.containsKey(ip)){
               testCounts.put(ip,1);
            }
            else{
                int value = testCounts.get(ip);
                testCounts.put(ip,value+1);
            }
        }
        return testCounts;
    }
    
    public HashMap<String,Integer> countVisitPerIp(){
        HashMap <String,Integer> counts = new HashMap<String,Integer>();
        counts = makeHashMap();
        
        return counts;
    }
    
    public int mostNumberVisitsByIp(){
        HashMap <String,Integer> counts = new HashMap<String,Integer>();
        counts = makeHashMap();
        int maximum = 0;
        
        for(String key : counts.keySet()){
            int value = counts.get(key);
            if(value>maximum){
                maximum = value;
            }
        }
        return maximum;
    }
    
    public ArrayList<String> iPsMostVisits(){
        ArrayList<String> ipMostVisits = new ArrayList<String>();
        HashMap <String,Integer> counts = new HashMap<String,Integer>();
        counts = makeHashMap();
        int maxVisit = mostNumberVisitsByIp();
        for(String key : counts.keySet()){
            int value = counts.get(key);
            if(value == maxVisit){
                ipMostVisits.add(key);
            }
        }
        return ipMostVisits;
    }
    
    private String getDay(Date d){
        String tempDate = d.toString();
        String []date = tempDate.split(" ");
        String day = date[1] + " " + date[2];
        return day;
    }
    
    
    public HashMap<String,ArrayList<String>> iPsForDays(){
        HashMap <String,ArrayList<String>> counts = new HashMap<String,ArrayList<String>>();
        for(logEntry le : logs){
            Date d = le.getAccessTime();
            String day = getDay(d);
            String ip = le.getIpAddress();
            ArrayList<String> tempIpList = new ArrayList<String>(); 
            if(!counts.containsKey(day)){
                tempIpList.add(ip);
                counts.put(day,tempIpList);
            }
            else{
                tempIpList = counts.get(day);
                tempIpList.add(ip);
                counts.put(day,tempIpList);
            }
        }
        return counts;
    }
    
    public String dayWithMostIPVisits(){
        HashMap <String,ArrayList<String>> counts = new HashMap<String,ArrayList<String>>();
        counts = iPsForDays();
        int max = 0;
        String dayWithMaxCount = " ";
        for(String key : counts.keySet()){
            int value = counts.get(key).size();
            if(value > max){
                max = value;
                dayWithMaxCount = key;
            }
        }
        return dayWithMaxCount;
    }
    
    private ArrayList<String> listOfIpWithMaxCount(ArrayList<String> ips){
        HashMap<String, Integer> ipCounts = new HashMap<String, Integer>();
        ArrayList<String> ipMostVisits = new ArrayList<String>();
        int maximumCount = 0;
        for(String ip : ips){
            if(!ipCounts.containsKey(ip)){
                ipCounts.put(ip,1);
            }
            else{
                int value = ipCounts.get(ip);
                ipCounts.put(ip,value+1);
            }
        }
        
        for(String key : ipCounts.keySet()){
            int value = ipCounts.get(key);
            if(value>maximumCount){
                maximumCount = value;
            }
        }
        
        for(String ip : ipCounts.keySet()){
            int value = ipCounts.get(ip);
            if(value == maximumCount){
                ipMostVisits.add(ip);
            }
        }
        return ipMostVisits;
    }
    
    public ArrayList<String> iPsWithMostVisitsOnDay(String day){
        HashMap <String,ArrayList<String>> counts = new HashMap<String,ArrayList<String>>();
        counts = iPsForDays();
        ArrayList<String> ipWithMaxCount = new ArrayList<String>();
        ArrayList<String> tempIPs = new ArrayList<String>();
        tempIPs = counts.get(day);
        ipWithMaxCount = listOfIpWithMaxCount(tempIPs);
        return ipWithMaxCount;
    }
}
