package com.jinku.learn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现 Trie (前缀树)
 */
public class Num208 {


    static class Trie {

        WordNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new WordNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            WordNode curr = root;
            for (Character character : word.toCharArray()) {
                if (curr.childNodes.containsKey(character)) {
                    curr = curr.childNodes.get(character);
                    continue;
                }

                WordNode node = new WordNode();
                node.value = character;
                curr.childNodes.put(character, node);
                curr = node;
            }
            curr.flag = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            if (word == null || word.length() == 0) {
                return false;
            }
            WordNode curr = root;
            for (Character character : word.toCharArray()) {
                if (curr.childNodes.containsKey(character)) {
                    curr = curr.childNodes.get(character);
                    continue;
                }
                return false;
            }
            return curr.flag;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            if (prefix == null || prefix.length() == 0) {
                return false;
            }
            WordNode curr = root;
            for (Character character : prefix.toCharArray()) {
                if (curr.childNodes.containsKey(character)) {
                    curr = curr.childNodes.get(character);
                    continue;
                }
                return false;
            }
            return true;
        }
    }

    static class WordNode {
        public Character value;
        public Map<Character, WordNode> childNodes = new HashMap<>();
        public boolean flag;
    }
}
