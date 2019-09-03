import java.util.ArrayList;

public class PilaTEC<Object> extends ArrayList<Object> {

    public int getSize() {
        return this.size();
    }

    public Object peek() {
        return this.get(getSize() - 1);
    }

    public Object pop() {
        Object o = this.get(getSize() - 1); this.remove(getSize() - 1);
        return o;
    }

    public void push(Object o) {
        this.add(o);
    }

    @Override
    public String toString() {
        String printthis = "PilaTEC:\n";
        for(int i = this.size() - 1; i >= 0; i--){
            printthis += "\t"+this.get(i)+"\n";
        }
        return printthis;
    }

}
