import java.util.ArrayList;
import java.util.List;

public class LexicographSearch {
    public static void main(String[] args) {
        String[] products = {"carpet", "cart", "car", "camera", "crate"};
        String search = "camera";
        System.out.println(suggestedProducts(products, search));
    }
    /* For an array of n strings products and a word to
search, search, design a system that, when each
character of the searched word is typed, suggests
at most three product names from the products
array. The suggested products should share a
common prefix with the searched word. If more
than three products exist with a common prefix,
report the three product names that appear first
in lexicographical order.

Return the suggested products, which will be a list
of lists after each character of the searched word
is typed.

Note: A string xis considered lexicographically
smaller than another string yif xwill occur before
y in the English dictionary.

Example
Suppose n = 5, products = ["carpet", "cart", "car",
"camera", "crate"], and search = "camera".*/

    public static List<List<String>> suggestedProducts(String[] products, String search) {
        List<List<String>> result = new ArrayList<>();
        Triee trieee = new Triee();
        for (String product : products) {
            trieee.insert(product);
        }
        for (int i = 0; i < search.length(); i++) {
            List<String> suggestions = trieee.findSuggestions(search.substring(0, i + 1));
            result.add(suggestions);
        }
        return result;
    }

    static class TrieeNode {
        TrieeNode[] nodes;
        boolean word;

        public TrieeNode() {
            nodes = new TrieeNode[26];
            word = false;
        }
    }

    static class Triee {
        TrieeNode root;

        public Triee() {
            root = new TrieeNode();
        }

        public void insert(String word) {
            TrieeNode n = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (n.nodes[index] == null) {
                    n.nodes[index] = new TrieeNode();
                }
                n = n.nodes[index];
            }
            n.word = true;
        }

        public List<String> findSuggestions(String p) {
            List<String> r = new ArrayList<>();
            TrieeNode n = root;
            for (char c : p.toCharArray()) {
                int id = c - 'a';
                if (n.nodes[id] == null) {
                    return r;
                }
                n = n.nodes[id];
            }
            search(n, p, r);
            return r;
        }

        private void search(TrieeNode n, String p, List<String> r) {
            if (n.word) {
                if (r.size() == 3) {
                    return;
                }
                r.add(p);
            }
            for (int j = 0; j < 26; j++) {
                if (n.nodes[j] != null) {
                    search(n.nodes[j], p + (char) (j + 'a'), r);
                }
            }
        }
    }

}
