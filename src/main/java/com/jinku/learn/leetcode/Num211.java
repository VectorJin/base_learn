package com.jinku.learn.leetcode;

/**
 * 添加与搜索单词 - 数据结构设计
 */
public class Num211 {

    static class WordDictionary {

        WordElement root;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new WordElement('a');
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            char[] array = word.toCharArray();
            WordElement next = root;
            for (char character : array) {
                int index = character - 'a';
                WordElement wordElement = next.children[index];
                if (wordElement == null) {
                    wordElement = new WordElement(character);
                    next.children[index] = wordElement;
                }
                next = wordElement;
            }
            next.children[26] = new WordElement('-');
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            char[] array = word.toCharArray();
            // 递归遍历
            return innerSearch(root, 0, array);
        }

        private boolean innerSearch(WordElement parent, int level, final char[] word) {
            if (parent == null) {
                return false;
            }

            if (level >= word.length) {
                if (parent.children[26] != null) {
                    char leaf = parent.children[26].value;
                    if (leaf == '-') {
                        return true;
                    }
                }
                return false;
            }

            char matchChar = word[level];
            if ('.' == matchChar) {
                // 通配符，所有子元素都遍历
                for (WordElement child : parent.children) {
                    if (child == null || child.value == '-') {
                        continue;
                    }
                    if (innerSearch(child, level + 1, word)) {
                        return true;
                    }
                }
                return false;
            } else {
                int index = matchChar - 'a';
                WordElement wordElement = parent.children[index];
                return innerSearch(wordElement, level + 1, word);
            }
        }
    }

    static class WordElement {
        char value;
        WordElement[] children;

        public WordElement(char value) {
            this.value = value;
            children = new WordElement[27];
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.e"));

        wordDictionary.addWord("a");
        wordDictionary.addWord("a");
        System.out.println(wordDictionary.search("."));
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search("aa"));
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search(".a"));
        System.out.println(wordDictionary.search("a."));
    }
}
