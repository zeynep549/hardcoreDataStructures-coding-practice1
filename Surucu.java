
    public class Surucu {

        public static void main(String[] args) {

            MyStack<String> s = new MyStack<>();
            Parantesis p = new Parantesis();
            s.push("merhaba");
            s.push("nasılsın");
            s.push("nasılsın");
            s.push("zeynep");

            System.out.println(s);
            System.out.println(s.findMultiple());
            System.out.println(s.search("nasılsın"));
            System.out.println(s.peek());
            System.out.println(s.pop());
            System.out.println(s.pop());

            s.reverse();
            System.out.println(s);
           // System.out.println(p.IndexParantesis());
            String dizi = "()((()))";
            String dizi1 = ")(()(())";

            System.out.println(p.IndexParantesis(dizi));
            System.out.println(p.IndexParantesis(dizi1));



        }



    }

