package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class InMemoryFileSystem {

    //Trie implementation
    static class Directory {
        // TrieNode contains both directories (Directory) and Files (String).
        // That is why value is of generic Object Type
        public Map<String, Object> contents;

        public Directory() {
            this.contents = new TreeMap<>();
        }
    }

    private final Directory root;

    public InMemoryFileSystem() {
        root = new Directory();
    }

    public List<String> ls(String path) {
        List<String> ans = new ArrayList<>();
        if (path.equals("/")) {
            ans.addAll(root.contents.keySet());
            return ans;
        }
        String[] nodes = path.split("/");
        int n = nodes.length;
        Directory p = root;
        for (int i = 1; i < n - 1; i++) {
            p = (Directory) p.contents.get(nodes[i]);
        }
        Object last = p.contents.get(nodes[n - 1]);
        if (last instanceof Directory) {
            p = (Directory) last;
            ans.addAll(p.contents.keySet());
        } else {
            ans.add(nodes[n - 1]);
        }
        return ans;
    }

    public void mkdir(String path) {
        String[] nodes = path.split("/");
        Directory p = root;
        for (int i = 1; i < nodes.length; i++) {
            if (!p.contents.containsKey(nodes[i])) {
                p.contents.put(nodes[i], new Directory());
            }
            p = (Directory) p.contents.get(nodes[i]);
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] nodes = filePath.split("/");
        Directory p = root;
        for (int i = 1; i < nodes.length - 1; i++) {
            p = (Directory) p.contents.get(nodes[i]);
        }
        String fileName = nodes[nodes.length - 1];
        p.contents.put(fileName, p.contents.getOrDefault(fileName, "") + content);
    }

    public String readContentFromFile(String filePath) {
        String[] nodes = filePath.split("/");
        Directory p = root;
        for (int i = 1; i < nodes.length - 1; i++) {
            p = (Directory) p.contents.get(nodes[i]);
        }
        return (String) p.contents.get(nodes[nodes.length - 1]);
    }
}
