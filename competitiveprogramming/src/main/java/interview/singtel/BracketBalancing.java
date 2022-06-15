package interview.singtel;

import java.util.Stack;

public class BracketBalancing {

    public static int balancedBrackets(String str) {
        int ans = 0;
        int n = str.length();
        Stack<String> st=new Stack<>();

        for (int i = 0; i < n; i++) {

            if (str.charAt(i) == '(')
                st.push("(");

            else {
                if(!st.empty()){
                    st.pop();
                    ans=ans+2;
                }

            }
        }

        // Return the required answer
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(balancedBrackets("())"));
        System.out.println(balancedBrackets("((())))"));
        System.out.println(balancedBrackets("))(()(("));
        System.out.println(balancedBrackets("))))"));
    }
}
