package store.search;

import java.util.*;

public class SearchEngine {
    private final Set<Searchable> searchables = new TreeSet<>(new Comparator<Searchable>() {
        @Override
        public int compare(Searchable o1, Searchable o2) {
            int lengthComparison = Integer.compare(o2.getName().length(), o1.getName().length());
            if (lengthComparison == 0) {
                return o1.getName().compareTo(o2.getName());
            }
            return lengthComparison;
        }
    });

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Set<Searchable> search(String query) {
        Set<Searchable> results = new TreeSet<>(new Comparator<Searchable>() {
            @Override
            public int compare(Searchable o1, Searchable o2) {
                int lengthComparison = Integer.compare(o2.getName().length(), o1.getName().length());
                if (lengthComparison == 0) {
                    return o1.getName().compareTo(o2.getName());
                }
                return lengthComparison;
            }
        });
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
