package com.kaminsky;

import java.util.Arrays;
import java.util.Stack;

public class MyStringBuilder {
    private char[] chars;
    private int size;
    private final Stack<MyStringBuilderSnapshot> history = new Stack<>();

    public MyStringBuilder(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.chars = str.toCharArray();
        this.size = chars.length;
    }

    public void undo() {
        if (!history.isEmpty()) {
            chars = history.pop().getState();
            size = chars.length;
        }
    }

    public void save(char[] tempArr) {
        history.push(new MyStringBuilderSnapshot(Arrays.copyOf(tempArr, size)));
    }

    public void append(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        broadenCapacity(size + str.length());

        save(chars);

        for (int i = 0; i < str.length(); i++) {
            chars[size++] = str.charAt(i);
        }
    }

    private void broadenCapacity(int minCapacity) {
        int newCapacity = chars.length * 2 + 2;
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        chars = Arrays.copyOf(chars, newCapacity);
    }

    @Override
    public String toString() {
        return new String(chars, 0, size);
    }

    public class MyStringBuilderSnapshot {
        private final char[] state;


        public MyStringBuilderSnapshot(char[] state) {
            this.state = state;
        }

        public char[] getState() {
            return state;
        }
    }


}
