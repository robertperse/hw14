package store.search;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> searchables = new HashSet<>();

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Set<Searchable> search(String query) {
        return searchables.stream()
                .filter(item -> item.getSearchTerm().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator
                        .comparingInt((Searchable o) -> -o.getName().length()) // Отрицательное число для сортировки по убыванию
                        .thenComparing(Searchable::getName))));
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