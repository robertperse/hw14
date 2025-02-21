package store.search;

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
                System.out.println(item.getStringRepresentation());
                if (found == 5) break;
            }
        }
        return results;
    }
}
