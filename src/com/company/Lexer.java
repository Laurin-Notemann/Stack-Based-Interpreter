package com.company;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Lexer {
    //   private ArrayList<Integer>
    // private ArrayList<String>
    private Character separator;

    public void addSeparator(Character separator) {
        this.separator = separator;
    }

    public ArrayList<Integer> findSeparator(@NotNull String line) {
        ArrayList<Integer> separatorIndex = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == separator) {
                separatorIndex.add(i);
            }
        }
        return separatorIndex;
    }

    public ArrayList<String> tokenise(String line) {
        ArrayList<String> token = new ArrayList<>();
        int x = 0;
        if (findSeparator(line).size() != 0) {
            if (findSeparator(line).size() == 1) {
                token.add(line.substring(0, findSeparator(line).get(0)));
                token.add(line.substring(findSeparator(line).get(0) + 1));
            }
            if (findSeparator(line).size() > 1) {
                token.add(line.substring(0, findSeparator(line).get(0)));
                for (int i = 0; i < findSeparator(line).size() - 1; i++) {
                    int a = findSeparator(line).get(i) + 1;
                    int b = findSeparator(line).get(++i);
                    token.add(line.substring(a, b));
                    x++;
                    i--;
                }
                token.add(line.substring(findSeparator(line).get(x)));
            }
        } else {
            token.add(line);
        }

        return token;
    }

}
