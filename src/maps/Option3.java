// Autor: Pablo Alvarez 221082

package maps;

import Interfaces.IMap;
import java.util.*;
import java.util.Map.Entry;

public class Option3 implements IMap{
    TreeMap<String, String> products = new TreeMap<String, String>();



    @Override
    public int lenght() {
        // TODO Auto-generated method stub
        return products.size();
    }



    @Override
    public void orderByCategory() {
        List <Entry<String, String>> capitalList = new LinkedList<>(products.entrySet());

        // call the sort() method of Collections
        Collections.sort(capitalList, (l1, l2) -> l1.getValue().compareTo(l2.getValue()));
    
        // create a new map
        TreeMap<String, String> result = new TreeMap();
    
        // get entry from list to the map
        for (Map.Entry<String, String> entry : capitalList) {
          result.put(entry.getKey(), entry.getValue());
        }
        printMap();
    }

    @Override
    public void add(String name, String category) throws Exception{
        try{
            products.put(name,category);
        }catch(Exception e){
            throw new Exception("error");
        }
    }
    
   

  

    @Override
    public String find(String name) {
        // TODO Auto-generated method stub
        return products.get(name);
    }


    
    @Override
    public void printMap() {
        // TODO Auto-generated method stub
        for (Map.Entry<String, String> entry : products.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

}
