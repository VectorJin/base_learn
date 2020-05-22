package com.jinku.learn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * N 天后的牢房
 */
public class Num957 {

    public int[] prisonAfterNDays(int[] cells, int N) {
        int current = 0;
        Map<Integer, Integer> stateMap = new HashMap<>();
        int state = convert(cells);
        stateMap.put(state, current);

        while (current < N) {
            cells = nextDay(cells);
            state = convert(cells);
            Integer lastN = stateMap.get(state);
            current++;

            if (lastN == null) {
                stateMap.put(state, current);
            } else {
                // 找出循环 ：lastN 为循环起点，current - lastN 为循环步长
                N = (N - lastN) % (current - lastN) + lastN;
                for (Map.Entry<Integer, Integer> entry : stateMap.entrySet()) {
                    if (entry.getValue() == N) {
                        return restore(entry.getKey());
                    }
                }
            }
        }
        return cells;
    }

    public int[] nextDay(int[] cells) {
        int[] newCells = new int[cells.length];
        for (int i = 1; i < cells.length - 1; i++) {
            newCells[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        }
        return newCells;
    }

    public int convert(int[] cells) {
        int state = 0;
        for (int i = 0; i < cells.length; i++) {
            if (cells[i] > 0) {
                state ^= 1 << i;
            }
        }
        return state;
    }

    public int[] restore(int state) {
        int[] cells = new int[8];
        for (int i = 0; i < 8; i++) {
            cells[i] = ((state >> i) & 1) > 0 ? 1 : 0;
        }
        return cells;
    }
}
