package com.main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class StackImplementationArrayList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0){
            ArrayList<Integer> arrayList = new ArrayList<>();

            int n=sc.nextInt();
            for(int i=0;i<n;i++){
                int num = sc.nextInt();
                arrayList.add(num);
            }
          Stack<Integer> stack = _push(arrayList,n);
          _pop(stack);
        }
    }

    public static Stack<Integer> _push(ArrayList<Integer> arr, int n)
    {
        Stack<Integer> st = new Stack<>();
        //Your code here
        for(int i=0;i<n;i++){
            st.push(arr.get(n));
        }
       return st;
    }

    public static void _pop(Stack<Integer> s)
    {
        //Your code here
        while(!s.empty()){
            System.out.println(s.peek()+" ");
            s.pop();
        }
    }

}
