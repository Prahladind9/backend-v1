package edu.prahlad.zinterview.zolando;

import java.util.ArrayList;

public class Test {
        public static  int solution(String S) {
            ArrayList<Integer> stack = new ArrayList<>();
            for(String c:  S.split(" ")){
                if(c.equals("+") || c.equals("-")){
                    if(stack.size() < 2) return -1; // only one element in Stack

                    int tmp1 = stack.get(stack.size()-1);
                    int tmp2 = stack.get(stack.size() -2);

                    stack.remove(stack.size()-1);
                    stack.remove(stack.size()-1);

                    //for + sign
                    if(c.equals("+")){
                        if(stack.size() ==0) return-1;
                        else stack.add(tmp1 + tmp2);
                    }else{
                        stack.add(tmp1-tmp2);
                    }
                }else if(c.equals("POP")){
                    stack.remove(stack.size()-1);
                }else if(c.equals("DUP")){
                    stack.add(stack.get(stack.size()-1));
                }else {
                    stack.add(Integer.valueOf(c));
                }
            }

            if(stack.size() == 0) return -1;
            return stack.get(stack.size()-1);
        }

        public static void main(String[] args) {
            System.out.println(solution("3 DUP 5 - -"));
            System.out.println(solution("1048575 DUP +"));
            System.out.println(solution("13 DUP 4 POP 5 DUP + DUP + -"));
        }
    }
