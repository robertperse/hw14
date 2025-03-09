package store.search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> searchables = new ArrayList<>();

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public List<Searchable> search(String query) {
        List<Searchable> results = new ArrayList<>();
        for (Searchable item : searchables) {
            if (item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results.add(item);
            }
        }
        return results;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxOccurrences = 0;

        for (Searchable item : searchables) {
            String searchTerm = item.getSearchTerm().toLowerCase();
            int count = 0, index = 0;
            while ((index = searchTerm.indexOf(search.toLowerCase(), index)) != -1) {
                count++;
                index += search.length();
            }

            if (count > maxOccurrences) {
                maxOccurrences = count;
                bestMatch = item;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Не найден лучший результат для запроса: " + search);
        }

        return bestMatch;
    }
}
