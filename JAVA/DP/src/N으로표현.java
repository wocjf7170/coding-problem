//https://school.programmers.co.kr/learn/courses/30/lessons/42895

import java.util.*;

class N으로표현 {

    public static void main(String[] args) {

    }
    public long solution(int N, int number) {

        LinkedList<HashSet<Long>> dp = new LinkedList<>();

        long combinedN = N;

        for(int i=0; i<=8; i++){
            dp.add(new HashSet<>());
            if(i== 1) {
                dp.get(i).add(combinedN);
            }
            else if(i > 1) {
                combinedN = N * (long)Math.pow(10,i - 1) + combinedN;
                dp.get(i).add(combinedN);
            }
        }

        if(N == number)
            return 1;


        for(int i=2; i<9; i++){

            for(int j= 1; j< i; j++) {
                for(int k =1; k+ j <= i; k++) {
                    for(long num : dp.get(j)){
                        for(long num2: dp.get(k)) {
                            dp.get(i).add(num + num2);
                            dp.get(i).add(num - num2);
                            dp.get(i).add(num * num2);

                            if(num2>0)
                                dp.get(i).add(num / num2);

                        }
                    }
                }
            }
            if(dp.get(i).contains((long)number))
                return i;
        }

        return -1;
    }
}
