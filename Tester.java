import java.util.*;
import edu.duke.*;
/**
 * Write a description of Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tester {
    private logAnalyzer la;
    
    private void initialiser(){
        la = new logAnalyzer();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter FileName : ");
        String fileName = sc.nextLine();
        la.readFile(fileName);
    }
    
    public void testLogAnalyzer(){
        initialiser();
        la.printAll();
    }
    
    public void testUniqueIps(){
        initialiser();
        System.out.println("There are " + la.uniqueIps() + "IPs");
        //la.printAllHigherThanNum(400);
    }
    
    public void testUniqueIPsOnDay(){
        initialiser();
        ArrayList<String> uniqueIpOnDay = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Day : ");
        String day = sc.nextLine();
        uniqueIpOnDay = la.uniqueIPVisitsOnDay(day);
        System.out.println("number of unique users on day : " + uniqueIpOnDay.size());
    }
    
    public void testCountUniqueIPsInRange(){
        initialiser();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Low point : ");
        int low = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter High point : ");
        int high = sc.nextInt();
        sc.nextLine();
        System.out.println("number of unique users in range : " + la.countUniqueIPsInRange(low,high));
      
    }
    
    public void testVisitsPerIp(){
        initialiser();
        HashMap<String,Integer> counts = new HashMap<String,Integer>(); 
        counts = la.countVisitPerIp();
        for(String key : counts.keySet()){
            System.out.println(key + " " + counts.get(key));
        }
    }
    
    public void testMostNumberVisitsByIp(){
        initialiser();
        int maximumCount = la.mostNumberVisitsByIp();
        System.out.println("Maximum count of visitors : " + maximumCount);
    }
    
    public void testIPsMostVisits(){
        initialiser();
        ArrayList<String> mostVisitedIps = la.iPsMostVisits();
        System.out.println("Ip with most visits are listed below : ");
        for(String ip : mostVisitedIps){
            System.out.println(ip);
        }
    }
    
    public void testIPsForDays(){
        initialiser();
        HashMap<String,ArrayList<String>> counts = new HashMap<String,ArrayList<String>>(); 
        counts = la.iPsForDays();
        for(String key : counts.keySet()){
            System.out.println(key + " " + counts.get(key));
        }
    }
    
    public void testDayWithMostIPVisits(){
        initialiser();
        String dayWithMaxCount = la.dayWithMostIPVisits();
        System.out.println("Day with maximum count of ip : " + dayWithMaxCount);
    }
    
    public void testIPsWithMostVisitsOnDay(){
        initialiser();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the day : ");
        String day = sc.nextLine();
        ArrayList<String> listOfIPs = la.iPsWithMostVisitsOnDay(day);
        System.out.println("IPs with max count : " + listOfIPs);
    }
}
