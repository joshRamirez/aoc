package model;

public class Intcode {
    private Integer code;
    private Integer position;
    private boolean terminated;

    public Intcode() {
    }

    public Intcode(Integer code, Integer position, boolean terminated) {
        this.code = code;
        this.position = position;
        this.terminated = terminated;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public boolean isTerminated() {
        return terminated;
    }

    public void setTerminated(boolean terminated) {
        this.terminated = terminated;
    }

    @Override
    public boolean equals(Object instruction) {
        if (instruction instanceof Intcode) {
            if (this.position == ((Intcode) instruction).position
                    && this.code == ((Intcode) instruction).code
                    && this.terminated == ((Intcode) instruction).terminated) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "(" + this.position + ", " + this.position + ", " + this.terminated + ")";
    }

}
