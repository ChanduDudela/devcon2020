package aws.random.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WebsiteVisitPattern {
    static class Tuple{
        String name;
        int time;
        String page;

        public Tuple(String name, int timestmp, String page){
            name = name;
            time = timestmp;
            page = page;
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {

        List<Tuple> tuples = new ArrayList<>();

        for(int i=0; i < username.length; i++){
            tuples.add(new Tuple(username[i], timestamp[i], website[i]));
        }

        tuples.sort((a, b) -> (a.time - b.time));

        Map<String, List<String>> userPagesMap = new HashMap<>();

        //construct user - pages list in time asc order
        for(Tuple tup : tuples){
            userPagesMap.putIfAbsent(tup.name, new ArrayList<>());
            userPagesMap.get(tup.name).add(tup.page);
        }

        Map<List<String>, Integer> seqUserFreMap = new HashMap<>();

        for(List<String> list: userPagesMap.values()){
            if(list.size() < 3){
                continue;
            }

            Set<List<String>> threeSequences = generate3Seq(list);

            for(List<String> seq: threeSequences){
                seqUserFreMap.putIfAbsent(seq, 0);
                seqUserFreMap.put(seq, seqUserFreMap.get(seq) +1);
            }
        }

        List<String> res = new ArrayList();

        int max = 0;
        for(Map.Entry<List<String>, Integer> entry: seqUserFreMap.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();

                res = entry.getKey();
            } else if (entry.getValue() == max){
                if(entry.getKey().toString().compareTo(res.toString()) < 0){
                    res = entry.getKey();
                }
            }
        }

        return res;

    }

    //construct different combinations of 3 size list into a Set
    private Set<List<String>> generate3Seq(List<String> websitesList) {
        Set<List<String>> setOfListSeq= new HashSet<>();
        for(int i=0;i<websitesList.size();i++){
            for(int j=i+1;j<websitesList.size();j++){
                for(int k=j+1;k<websitesList.size();k++){
                    List<String> list = new ArrayList<>();
                    list.add(websitesList.get(i));
                    list.add(websitesList.get(j));
                    list.add(websitesList.get(k));
                    setOfListSeq.add(list);
                }
            }
        }
        return setOfListSeq;
    }
}
