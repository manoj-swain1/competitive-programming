package interview.shalini.morganstanley;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Child {


    public static void main(String[] args) {
        MyAD<Number> m=new MyAD<>();
        m.add(new Integer(1));
        m.add(new Double(1.0));
    }

    public static Iterator reverse(List list) {
        Collections.reverse(list);
        return list.iterator();
    }
}

class MyAD<T>{
    void add(T t){
        System.out.println(t);
    }
}


class Employee {
    private String fname;
    private String lname;

    public Employee(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(fname, employee.fname) && Objects.equals(lname, employee.lname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fname, lname);
    }


}
