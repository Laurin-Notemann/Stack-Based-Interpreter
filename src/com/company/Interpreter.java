package com.company;

import java.util.ArrayList;
import java.util.Stack;

public class Interpreter {
    boolean running;
    int commandLine;
    boolean EXEC;
    private ArrayList<Variable> variableList;
    private Stack<String> globalStack;
    private Stack<Boolean> conditionalStack;

    public Interpreter() {
        variableList = new ArrayList<>();
        globalStack = new Stack<>();
        conditionalStack = new Stack<>();
        running = true;
        commandLine = 0;
        conditionalStack.push(true);

    }

    public void run(ArrayList<ArrayList<String>> program) {
        //String CMD = program.get(commandLine).get(0);
        while (running) {
            String CMD = program.get(commandLine).get(0);
            EXEC = conditionalStack.peek();
            if (Commands.hasNoArgument(CMD)) {
                if (CMD.equals(Commands._CMD_CALC_ADDITION_) && EXEC) {
                    execute_CMD_ADD();
                } else if (CMD.equals(Commands._CMD_CALC_SUBTRAKT_) && EXEC) {
                    execute_CMD_SUB();
                } else if (CMD.equals(Commands._CMD_CALC_MULTIPLI_) && EXEC) {
                    execute_CMD_MUL();
                } else if (CMD.equals(Commands._CMD_CALC_DIVISION_) && EXEC) {
                    execute_CMD_DIV();
                } else if (CMD.equals(Commands._CMD_EVALLOGIC_AND_) && EXEC) {
                    execute_CMD_AND();
                } else if (CMD.equals(Commands._CMD_EVALLOGIC_ORR_) && EXEC) {
                    execute_CMD_ORR();
                } else if (CMD.equals(Commands._CMD_EVALLOGIC_NOT_) && EXEC) {
                    execute_CMD_NOT();
                } else if (CMD.equals(Commands._CMD_EVALLOGIC_BGR_) && EXEC) {
                    execute_CMD_BGR();
                } else if (CMD.equals(Commands._CMD_EVALLOGIC_LWR_) && EXEC) {
                    execute_CMD_LWR();
                } else if (CMD.equals(Commands._CMD_EVALLOGIC_BEQ_) && EXEC) {
                    execute_CMD_BEQ();
                } else if (CMD.equals(Commands._CMD_EVALLOGIC_LEQ_) && EXEC) {
                    execute_CMD_LEQ();
                } else if (CMD.equals(Commands._CMD_EVALLOGIC_EQU_) && EXEC) {
                    execute_CMD_EQU();
                } else if (CMD.equals(Commands._CMD_INCREMENT_NUM_) && EXEC) {
                    execute_CMD_INC();
                } else if (CMD.equals(Commands._CMD_DECREMENT_NUM_) && EXEC) {
                    execute_CMD_DEC();
                } else if (CMD.equals(Commands._CMD_CONSOLE_OUT___) && EXEC) {
                    execute_CMD_OUT();
                } else if (CMD.equals(Commands._CMD_STACK_POPVALU_) && EXEC) {
                    execute_CMD_POP();
                } else if (CMD.equals(Commands._CMD_STOP_PROGRAM__) && EXEC) {
                    execute_CMD_STP();
                } else if (CMD.equals(Commands._CMD_IF_THEN_BEGIN_)) {
                    execute_CMD_IFT();
                } else if (CMD.equals(Commands._CMD_IF_THEN_ENDOF_)) {
                    execute_CMD_IFE();
                }
            } else {
                if (CMD.equals(Commands._CMD_VARIABLE_DECL_) && EXEC) {
                    execute_CMD_DCL(program.get(commandLine).get(1));
                } else if (CMD.equals(Commands._CMD_VARIABLE_STOR_) && EXEC) {
                    execute_CMD_STR(program.get(commandLine).get(1));
                } else if (CMD.equals(Commands._CMD_STACK_PUSHNUM_) && EXEC) {
                    execute_CMD_PSN(program.get(commandLine).get(1));
                } else if (CMD.equals(Commands._CMD_STACK_PUSHCHR_) && EXEC) {
                    execute_CMD_PSC(program.get(commandLine).get(1));
                } else if (CMD.equals(Commands._CMD_STACK_PUSHVAR_) && EXEC) {
                    execute_CMD_PSV(program.get(commandLine).get(1));
                }
            }
            commandLine++;
        }
    }

    private void execute_CMD_PSV(String varname) {
        int x = 0;
        for (int i = 0; i <= variableList.size(); i++) {
            if (varname.equals(variableList.get(x).getIdentifier())) {
                globalStack.push(variableList.get(x).getContent());
            } else {
                x++;
            }
        }

    }

    private void execute_CMD_PSC(String value) {
        globalStack.push(value);
    }

    private void execute_CMD_PSN(String value) {
        globalStack.push(value);
    }

    private void execute_CMD_STR(String varname) {
        int x = 0;
        int var1 = Integer.parseInt(globalStack.pop());
        for (int i = 0; i <= variableList.size(); i++) {
            if (varname.equals(variableList.get(x).getIdentifier())) {
                variableList.get(x).setContent(String.valueOf(var1));
            } else {
                x++;
            }
        }
    }

    private void execute_CMD_DCL(String varname) {
        variableList.add(new Variable(varname));
    }

    private void execute_CMD_POP() {
        globalStack.pop();
    }

    private void execute_CMD_OUT() {
        System.out.println(globalStack.peek());
    }

    private void execute_CMD_DEC() {
        int var1 = Integer.parseInt(globalStack.pop());

        globalStack.push(String.valueOf(--var1));
    }

    private void execute_CMD_INC() {
        int var1 = Integer.parseInt(globalStack.pop());

        globalStack.push(String.valueOf(++var1));
    }

    private void execute_CMD_EQU() {
        int var1 = Integer.parseInt(globalStack.pop());
        int var2 = Integer.parseInt(globalStack.pop());

        globalStack.push(String.valueOf(var1 == var2));
    }

    private void execute_CMD_LEQ() {
        int var1 = Integer.parseInt(globalStack.pop());
        int var2 = Integer.parseInt(globalStack.pop());

        globalStack.push(String.valueOf(var1 <= var2));
    }

    private void execute_CMD_BEQ() {
        int var1 = Integer.parseInt(globalStack.pop());
        int var2 = Integer.parseInt(globalStack.pop());

        globalStack.push(String.valueOf(var1 >= var2));
    }

    private void execute_CMD_LWR() {
        int var1 = Integer.parseInt(globalStack.pop());
        int var2 = Integer.parseInt(globalStack.pop());

        globalStack.push(String.valueOf(var1 < var2));
    }

    private void execute_CMD_BGR() {
        int var1 = Integer.parseInt(globalStack.pop());
        int var2 = Integer.parseInt(globalStack.pop());

        globalStack.push(String.valueOf(var1 > var2));
    }

    private void execute_CMD_NOT() {
        boolean var1 = Boolean.parseBoolean(globalStack.pop());

        globalStack.push(String.valueOf(!var1));
    }

    private void execute_CMD_ORR() {
        boolean var1 = Boolean.parseBoolean(globalStack.pop());
        boolean var2 = Boolean.parseBoolean(globalStack.pop());

        globalStack.push(String.valueOf(var1 || var2));
    }

    private void execute_CMD_AND() {
        boolean var1 = Boolean.parseBoolean(globalStack.pop());
        boolean var2 = Boolean.parseBoolean(globalStack.pop());

        globalStack.push(String.valueOf(var1 && var2));

    }

    private void execute_CMD_DIV() {
        int var1 = Integer.parseInt(globalStack.pop());
        int var2 = Integer.parseInt(globalStack.pop());

        globalStack.push(String.valueOf(var1 / var2));

    }

    private void execute_CMD_MUL() {
        int var1 = Integer.parseInt(globalStack.pop());
        int var2 = Integer.parseInt(globalStack.pop());

        globalStack.push(String.valueOf(var1 * var2));

    }

    private void execute_CMD_SUB() {
        int var1 = Integer.parseInt(globalStack.pop());
        int var2 = Integer.parseInt(globalStack.pop());

        globalStack.push(String.valueOf(var1 - var2));

    }

    private void execute_CMD_ADD() {
        int var1 = Integer.parseInt(globalStack.pop());
        int var2 = Integer.parseInt(globalStack.pop());

        globalStack.push(String.valueOf(var1 + var2));
    }

    public void execute_CMD_STP() {
        running = false;
    }

    public void execute_CMD_IFT() {
        boolean condition = Boolean.parseBoolean(globalStack.pop()) && conditionalStack.peek();
        conditionalStack.push(condition);

    }

    public void execute_CMD_IFE() {
        conditionalStack.pop();
    }
}
