package interview.shalini.emaratech;

import java.util.ArrayList;


public class Parent  {
    protected void show() {
        System.out.println("child");
    }

    public static void main(String[] args) {
        ArrayList names=new ArrayList();
        names.add("a");
        ArrayList list=new ArrayList();
        names.add("b");
        names.addAll(list);
        System.out.println(names);
    }
}
