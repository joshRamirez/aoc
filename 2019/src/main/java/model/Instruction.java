package model;

public class Instruction {
    private int opcode;
    private int mode1;
    private int mode2;
    private int mode3;

    // default constructor
    public Instruction() {
    }

    public Instruction(int opcode, int mode1, int mode2, int mode3) {
        this.opcode = opcode;
        this.mode1 = mode1;
        this.mode2 = mode2;
        this.mode3 = mode3;
    }

    public int getOpcode() {
        return opcode;
    }

    public void setOpcode(int opcode) {
        this.opcode = opcode;
    }

    public int getMode1() {
        return mode1;
    }

    public void setMode1(int mode1) {
        this.mode1 = mode1;
    }

    public int getMode2() {
        return mode2;
    }

    public void setMode2(int mode2) {
        this.mode2 = mode2;
    }

    public int getMode3() {
        return mode3;
    }

    public void setMode3(int mode3) {
        this.mode3 = mode3;
    }

    @Override
    public boolean equals(Object instruction) {
        if (instruction instanceof Instruction) {
            if (this.opcode == ((Instruction) instruction).opcode
                    && this.mode1 == ((Instruction) instruction).mode1
                    && this.mode2 == ((Instruction) instruction).mode2
                    && this.mode3 == ((Instruction) instruction).mode3) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "(" + this.opcode + ", " + this.mode1 + ", " + this.mode2 + ", " + this.mode3 + ")";
    }
}
