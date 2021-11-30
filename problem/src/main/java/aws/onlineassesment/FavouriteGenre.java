package aws.onlineassesment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/discuss/interview-question/373006
public class FavouriteGenre {
    /*
        invert map: song -> genre
        groupBy: user -> [genre, [song]]
        count: user -> [genre, count]
        select having=max: user -> [genre]

        Input:
        userMap =
        {
           "David": ["song1", "song2", "song3", "song4", "song8"],
           "Emma":  ["song5", "song6", "song7"]
        }

        genreMap =
        {
           "Rock":    ["song1", "song3"],
           "Dubstep": ["song7"],
           "Techno":  ["song2", "song4"],
           "Pop":     ["song5", "song6"],
           "Jazz":    ["song8", "song9"]
        }

        Output:
        {
           "David": ["Rock", "Techno"],
           "Emma":  ["Pop"]
        }
     */

    public Map<String, List<String>> getFavouriteGenre(
        Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {

        Map<String, List<String>> userGenresMap = new HashMap<>();

        Map<String, String> songToGenreMap = new HashMap<>();

        for (String genre : genreMap.keySet()) {
            List<String> songs = genreMap.get(genre);
            songs.forEach(s -> songToGenreMap.put(s, genre));
        }

        Map<String, Integer> genreCountMap = new HashMap<>();

        if (genreMap.size() == 0 || userMap.size() == 0) {
            return userGenresMap;
        }

        int max = 0;
        for (String user : userMap.keySet()) {
            List<String> songsList = userMap.get(user);

            userGenresMap.put(user, new ArrayList<>());

            for (String s : songsList) {
                String genre = songToGenreMap.get(s);
                int count = genreCountMap.getOrDefault(genre, 0) + 1;
                genreCountMap.put(genre, count);
                max = Integer.max(max, count);
            }
            for (String genre : genreCountMap.keySet()) {
                if (genreCountMap.get(genre) == max) {
                    userGenresMap.get(user).add(genre);
                }
            }
        }
        return userGenresMap;
    }
}
