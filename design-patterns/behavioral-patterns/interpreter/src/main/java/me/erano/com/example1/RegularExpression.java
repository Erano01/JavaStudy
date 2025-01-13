package me.erano.com.example1;

import java.util.List;

/*
expression ::= literal | alternation | sequence | repetition | '(' expression ')'
alternation ::- expression '|' expression
sequence ::- expression '&' expression
repetition ::= expression '*'
literal ::- 'a' | 'b' | 'c' | ... { 'a' | 'b' | 'c' | ... }*
 */
//Abstract Expression -> This class represents "Expression"
public abstract class RegularExpression {

    protected String context;

    public RegularExpression(String context) {
        this.context = context;
    }

    // You can return boolean,int etc parameter and return type is optional.
    public abstract boolean interpret(RegularExpression expression);

    public String getContext(){
        return this.context;
    }
}
