import java.util.ArrayList;
import java.util.Stack;

public class Parantesis {
    public static String IndexParantesis(String input) {
        MyStack<Integer> stack = new MyStack<>();
        MyStack<Integer> index = new MyStack<>();
        ArrayList<String> list1 = new ArrayList<>();

        String str = "";
        int maxLen = 0;
        int startIndex = -1;
        int endIndex = -1;
        int count = 1;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                startIndex = count;
                stack.push(i);
                index.push(count);
                //System.out.println(startIndex+"s");

            } else if (c == ')'){
                if (!stack.isEmpty() && stack.peek() != ')') {

                    stack.pop();
                    endIndex = count;
                    //System.out.println(endIndex+"e");
                    list1.add(index.pop()+","+endIndex);


                    /*if (stack.isEmpty()) {
                        startIndex = str.indexOf('(');
                        endIndex = i;
                        stack.push(startIndex);
                    } else {
                        startIndex = stack.peek() + 1;
                        endIndex = i;
                    }
                    int currentLen = endIndex - startIndex;
                    if (currentLen > maxLen) {
                        maxLen = currentLen;
                    }*/
                }
            }
            count++;
        }
        maxLen = 0;
        for (String s : list1){
            //System.out.println(s +"...");
            if (Integer.parseInt(s.substring(s.indexOf(',')+1))-Integer.parseInt(s.substring(0,s.indexOf(',')) ) > maxLen)
            {
                maxLen = Integer.parseInt(s.substring(s.indexOf(',')+1))-Integer.parseInt(s.substring(0,s.indexOf(',')) );
                startIndex = Integer.parseInt(s.substring(0,s.indexOf(',')) );
                endIndex = Integer.parseInt(s.substring(s.indexOf(',')+1) );
            }
        }


        if (startIndex != -1 && endIndex != -1) {
            return (startIndex ) + "," + (endIndex );
        } else {
            return "No valid parentheses found.";
        }
    }
}









