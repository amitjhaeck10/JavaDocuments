package main.java.com.datastructure;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditorProblem {
   /* public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(Collectors.toList());

        TextSolution.textEditor(ops);
    }*/

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = "";
        Stack<String> st = new Stack<String>();
        st.push(s);
        for (int i = 0; i < n; i++) {
            int t = in.nextInt();
            if (t == 1) {
                s = s + in.next();
                st.push(s);
            } else if (t == 2) {
                s = s.substring(0, s.length() - in.nextInt());
                st.push(s);
            } else if (t == 3) {
                System.out.println(s.charAt(in.nextInt() - 1));
            } else {
                st.pop();
                s = st.peek();
            }
        }
    }
}

class TextSolution {
    public static void textEditor(List<String> ops) {
        String text = "";
        Stack<String> in = new Stack<>();
        in.push(text);
        for (String str : ops) {
            String[] operation = str.split(" ");
            if ("1".equals(operation[0])) {
                text = text + operation[1];
                in.push(text);
            }
            if ("2".equals(operation[0])) {
                Integer k = Integer.parseInt(operation[1]);
                text = text.substring(0, text.length() - k);
                in.push(text);
            }
            if ("3".equals(operation[0])) {
                Integer k = Integer.parseInt(operation[1]);
                System.out.println(text.charAt(k - 1));
            }
            if ("4".equals(operation[0])) {
                if (!in.isEmpty()) {
                    in.pop();
                    text = in.peek();
                }
            }
        }
    }
}
