package interview.epam.ubs;

public class Test {
    static String str;

    public void Test() {
        str="Hello";
    }

    public static void main(String[] args) {
        Test t=new Test();
        System.out.println(str);
    }

    private static void badMethod() {
    }
}
