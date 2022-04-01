package sample.data;

public class Field {
    private boolean empty = true;
    private Type type;
    private int x;
    private int y;


    public Field(boolean empty, Type type, int x, int y) {
        this.empty = empty;
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Field{" +
                "empty=" + empty +
                ", type=" + type +
                '}';
    }
}
