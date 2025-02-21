package store.search;

import java.util.Arrays;

public class SearchEngine {
    private final Searchable[] searchables;
    private int count = 0;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
    }

    public void add(Searchable searchable) {
        if (count < searchables.length) {
            searchables[count++] = searchable;
        } else {
            System.out.println("Нельзя добавить больше элементов в поисковый движок.");
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int found = 0;

        for (Searchable item : searchables) {
            if (item != null && item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results[found++] = item;
                if (found == 5) break;
            }
        }
        return Arrays.copyOf(results, found);
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxOccurrences = 0;

        for (Searchable item : searchables) {
            if (item != null) {
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
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Не найден лучший результат для запроса: " + search);
        }

        return bestMatch;
    }
}
