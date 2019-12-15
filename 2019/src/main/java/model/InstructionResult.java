package model;

public class InstructionResult {
    private boolean isModified;
    private int pointer;

    public InstructionResult() {
    }

    public InstructionResult(boolean isModified, int pointer) {
        this.isModified = isModified;
        this.pointer = pointer;
    }

    public boolean isModified() {
        return isModified;
    }

    public void setModified(boolean modified) {
        isModified = modified;
    }

    public int getPointer() {
        return pointer;
    }

    public void setPointer(int pointer) {
        this.pointer = pointer;
    }

    @Override
    public boolean equals(Object instructionResult) {
        if (instructionResult instanceof InstructionResult) {
            if (this.isModified == ((InstructionResult) instructionResult).isModified
                    && this.pointer == ((InstructionResult) instructionResult).pointer) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "(" + this.isModified + ", " + this.pointer + ")";
    }
}
