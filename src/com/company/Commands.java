package com.company;


public class Commands {
    public static final String _CMD_CALC_ADDITION_ = "ADD"; // +
    public static final String _CMD_CALC_SUBTRAKT_ = "SUB"; // -
    public static final String _CMD_CALC_MULTIPLI_ = "MUL"; // *
    public static final String _CMD_CALC_DIVISION_ = "DIV"; // /

    public static final String _CMD_EVALLOGIC_AND_ = "AND"; // logical And
    public static final String _CMD_EVALLOGIC_ORR_ = "ORR"; // logical Or
    public static final String _CMD_EVALLOGIC_NOT_ = "NOT"; // logical Not

    public static final String _CMD_EVALLOGIC_BGR_ = "BGR"; // Bigger Than
    public static final String _CMD_EVALLOGIC_LWR_ = "LWR"; // Lower Than
    public static final String _CMD_EVALLOGIC_BEQ_ = "BEQ"; // Bigger or Equal
    public static final String _CMD_EVALLOGIC_LEQ_ = "LEQ"; // Lower or Equal
    public static final String _CMD_EVALLOGIC_EQU_ = "EQU"; // Equals

    public static final String _CMD_VARIABLE_DECL_ = "DCL"; // Declare Variable
    public static final String _CMD_VARIABLE_STOR_ = "STR"; // Store Content from Stack into Variable

    public static final String _CMD_STACK_PUSHNUM_ = "PSN"; // Push Number onto Stack
    public static final String _CMD_STACK_PUSHCHR_ = "PSC"; // Push Character onto Stack
    public static final String _CMD_STACK_PUSHVAR_ = "PSV"; // Push Variable onto Stack
    public static final String _CMD_STACK_POPVALU_ = "POP"; // Pop Content from global Stack

    public static final String _CMD_INCREMENT_NUM_ = "INC"; //
    public static final String _CMD_DECREMENT_NUM_ = "DEC"; //

    public static final String _CMD_IF_THEN_BEGIN_ = "IFT"; // If then
    public static final String _CMD_IF_THEN_ENDOF_ = "IFE"; // End of if then

    public static final String _CMD_CONSOLE_OUT___ = "OUT"; // Print peek of Stack
    public static final String _CMD_STOP_PROGRAM__ = "STP"; // Stop of program

    public static boolean hasNoArgument(String CMD) {
        return     CMD.equals(_CMD_CALC_ADDITION_) || CMD.equals(_CMD_CALC_SUBTRAKT_)
                || CMD.equals(_CMD_CALC_DIVISION_) || CMD.equals(_CMD_CALC_MULTIPLI_)
                || CMD.equals(_CMD_EVALLOGIC_AND_) || CMD.equals(_CMD_EVALLOGIC_ORR_)
                || CMD.equals(_CMD_EVALLOGIC_NOT_) || CMD.equals(_CMD_EVALLOGIC_BEQ_)
                || CMD.equals(_CMD_CONSOLE_OUT___) || CMD.equals(_CMD_EVALLOGIC_EQU_)
                || CMD.equals(_CMD_EVALLOGIC_BGR_) || CMD.equals(_CMD_EVALLOGIC_LEQ_)
                || CMD.equals(_CMD_EVALLOGIC_LWR_) || CMD.equals(_CMD_IF_THEN_BEGIN_)
                || CMD.equals(_CMD_IF_THEN_ENDOF_) || CMD.equals(_CMD_STOP_PROGRAM__)
                || CMD.equals(_CMD_INCREMENT_NUM_) || CMD.equals(_CMD_DECREMENT_NUM_)
                || CMD.equals(_CMD_STACK_POPVALU_);
    }

    public static boolean hasOneArgument(String CMD) {
        return     CMD.equals(_CMD_STACK_PUSHCHR_) || CMD.equals(_CMD_STACK_PUSHNUM_)
                || CMD.equals(_CMD_STACK_PUSHVAR_) || CMD.equals(_CMD_VARIABLE_DECL_)
                || CMD.equals(_CMD_VARIABLE_STOR_);
    }

}
