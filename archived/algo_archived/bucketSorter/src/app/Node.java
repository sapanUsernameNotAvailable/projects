package app;

public class Node implements Evaluable{
    
    int value;
    Node(int value) {
        this.value = value;
    }
    
    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
