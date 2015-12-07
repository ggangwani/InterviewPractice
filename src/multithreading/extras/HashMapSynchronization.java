package multithreading.extras;
import java.util.*;

public class HashMapSynchronization {
    public static void main(String[] args) {
        // create map
        Map<String,String> map = new HashMap<String,String>();
        
        // populate the map
        map.put("1","ALIVE ");
        map.put("2","IS");
        map.put("3","AWESOME");
        
        // create a synchronized map
        Map<String,String> syncMap = Collections.synchronizedMap(map);
        map.put(null, null);
        //map.put(null, 123); not allowed compile time error, hashmap can have only 1 null key
        map.put("4", null); 
        System.out.println("Synchronized map :"+syncMap);
        
        Hashtable<String, String> hashTable = new Hashtable<String, String>();
        hashTable.put("1", "sdfs");
        //hashTable.put(null, "asfd"); - throws null pointer
        //hashTable.put("2", null);  - throws null pointer
        System.out.println("hashtable :"+hashTable);
    }
}