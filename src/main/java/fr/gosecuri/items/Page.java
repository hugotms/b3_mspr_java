package fr.gosecuri.items;

public class Page {
    private String type;
    private Object args;

    public Page(String type, Object args) {
        this.type = type;
        this.args = args;
    }

    public String getType() {
        return type;
    }

    public Object getArgs() {
        return args;
    }
}
