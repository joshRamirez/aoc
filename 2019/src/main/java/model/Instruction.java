package model;

public class Instruction {
    private int opcode;
    private int parameter1;
    private int parameter2;
    private int parameter3;

    // default constructor
    public Instruction() {
    }

    public Instruction(int opcode, int parameter1, int parameter2, int parameter3) {
        this.opcode = opcode;
        this.parameter1 = parameter1;
        this.parameter2 = parameter2;
        this.parameter3 = parameter3;
    }

    public int getOpcode() {
        return opcode;
    }

    public void setOpcode(int opcode) {
        this.opcode = opcode;
    }

    public int getParameter1() {
        return parameter1;
    }

    public void setParameter1(int parameter1) {
        this.parameter1 = parameter1;
    }

    public int getParameter2() {
        return parameter2;
    }

    public void setParameter2(int parameter2) {
        this.parameter2 = parameter2;
    }

    public int getParameter3() {
        return parameter3;
    }

    public void setParameter3(int parameter3) {
        this.parameter3 = parameter3;
    }

    @Override
    public boolean equals(Object instruction) {
        if (instruction instanceof Instruction) {
            if (this.opcode == ((Instruction) instruction).opcode
                    && this.parameter1 == ((Instruction) instruction).parameter1
                    && this.parameter2 == ((Instruction) instruction).parameter2
                    && this.parameter3 == ((Instruction) instruction).parameter3) {
                return true;
            }
        }

        return false;
    }
}
