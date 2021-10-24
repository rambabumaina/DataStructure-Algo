package demo;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class URLSORT {

    Map<String, Integer> storeUrlsFrequency = new HashMap<>();

    public static void main(String[] args) {

        Website w = new Website("a");

        URLSORT u  = new URLSORT();
        u.addURL(new Website("a"));
        u.addURL(new Website("b"));
        u.addURL(new Website("c"));

        System.out.println(u.getMostVisitedURLs());
    }


    public void addURL(Website website){
        if(storeUrlsFrequency.containsKey(website.getURL())){
            storeUrlsFrequency.put(website.getURL(),storeUrlsFrequency.get(website.getURL())+1);
        }else{
            storeUrlsFrequency.put(website.getURL(),1);
        }
    }

    public List<String> getMostVisitedURLs(){
        Map<String, Integer> sortByValueMap = storeUrlsFrequency.entrySet().stream().sorted(Collections.reverseOrder(Entry.comparingByValue()))
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue(),
                        (entry1, entry2) -> entry2, LinkedHashMap::new));
        System.out.println(sortByValueMap);
        return new ArrayList<>(sortByValueMap.keySet());
    }
}



class Website{
    String URL;

    public Website(String URL){
        this.URL = URL;
    }

    public String getURL() {
        return URL;
    }
}