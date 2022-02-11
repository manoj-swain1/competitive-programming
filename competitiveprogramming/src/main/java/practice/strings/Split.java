package practice.strings;

public class Split {

    private static String[] split(String str){
        return str.split("~");
    }
    public static void main(String[] args) {
        System.out.println(split("b~~ ").length);
    }
}
