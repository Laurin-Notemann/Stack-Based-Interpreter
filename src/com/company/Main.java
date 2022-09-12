package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Lexer lexer = new Lexer();
        lexer.addSeparator(' ');
        ArrayList<ArrayList<String>> program = new ArrayList<>();

        program.add(lexer.tokenise("DCL X"));
        program.add(lexer.tokenise("PSN 4"));
        program.add(lexer.tokenise("STR X"));
        program.add(lexer.tokenise("PSV X"));
        program.add(lexer.tokenise("PSN 5"));
        program.add(lexer.tokenise("BGR"));
        program.add(lexer.tokenise("PSN 4"));
        program.add(lexer.tokenise("PSN 3"));
        program.add(lexer.tokenise("LWR"));
        program.add(lexer.tokenise("AND"));
        program.add(lexer.tokenise("IFT"));
        program.add(lexer.tokenise("PSV X"));
        program.add(lexer.tokenise("INC"));
        program.add(lexer.tokenise("IFE"));
        program.add(lexer.tokenise("OUT"));
        program.add(lexer.tokenise("STP"));


        Parser parser = new Parser();
        int checkstatus = parser.checkProgram(program);

        if (checkstatus == -1) {
            System.out.println("Parser: Check OK");
        } else {
            System.out.println("Parser: Error occured in line: " + checkstatus);
            return;
        }

        Interpreter interpreter = new Interpreter();
        interpreter.run(program);
    }
}
