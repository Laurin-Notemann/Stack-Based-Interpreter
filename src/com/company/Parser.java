package com.company;

import java.util.ArrayList;

public class Parser {
    public int checkProgram(ArrayList<ArrayList<String>> program) {
        int currentLine = 0;
        for (ArrayList<String> line : program) {
            if (!checkLine(line)) {
                return currentLine + 1;
            }
            currentLine++;
        }
        return -1;
    }

    public boolean checkLine(ArrayList<String> line) {
        if (line.size() == 1) {
            String CMD = line.get(0);
            return Commands.hasNoArgument(CMD);
        } else if (line.size() == 2) {
            String CMD = line.get(0);
            return Commands.hasOneArgument(CMD);
        }
        return false;
    }
}
