package algo;

/**
 * Created with IntelliJ IDEA.
 * User: abhinav
 * Date: 13/8/13
 * Time: 1:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class Trie<E> {
    private TrieNode<E> root;
    private String alphabet;
    private int wordCount;

    public Trie(String alphabet) {
        validateAlphabet();
        this.alphabet = alphabet;
        this.root = new TrieNode<E>(alphabet);
        this.wordCount = 0;
    }

    public void insert(String word) {
        validateWord();
        int wordLength = word.length();
        TrieNode<E> pCrawl = root;
        int index;

        for(int level = 0; level < wordLength; level++ )
        {
            index = charToIndex(word.charAt(level));
            if(pCrawl.pointerList[index] == null)
            {
                pCrawl.pointerList[index] = new TrieNode<E>(alphabet);
            }

            pCrawl = pCrawl.pointerList[index];
        }

        wordCount++;
        pCrawl.isAWord = true;
    }

    public boolean search(String word) {
        int wordLength = word.length();
        int index;
        TrieNode<E> pCrawl;

        pCrawl = root;

        for(int level = 0; level < wordLength; level++)
        {
            index = charToIndex(word.charAt(level));

            if(pCrawl.pointerList[index] == null)
            {
                return false;
            }

            pCrawl = pCrawl.pointerList[index];
        }

        return (pCrawl != null && pCrawl.isAWord);
    }

    private int charToIndex(char c) {
        return (int) c - (int) 'a';
    }

    private void validateAlphabet() {

    }

    private void validateWord() {

    }

    private class TrieNode<E> {
        private TrieNode<E>[] pointerList;
        private boolean isAWord;


        public TrieNode(String alphabet) {
            this.pointerList = new TrieNode[alphabet.length()];
            this.isAWord = false;
        }

        public boolean isAWord() {
            return isAWord;
        }
    }

    public static void main(String[] args) {
        Trie<Integer> trie = new Trie<Integer>("abc");
        trie.insert("c");
        trie.insert("ccab");
        trie.insert("a");
        trie.insert("baba");
        trie.search("a");
    }
}
