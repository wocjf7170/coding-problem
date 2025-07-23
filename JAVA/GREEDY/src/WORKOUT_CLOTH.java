//url : https://school.programmers.co.kr/learn/courses/30/lessons/42862

import java.util.Arrays;

public class WORKOUT_CLOTH {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] students = new int[n];
        Arrays.fill(students, 1);

        for(int i: lost)
            students[i - 1] --;

        for(int i: reserve)
            students[i - 1] ++;

        for(int i = 0; i < n ; i ++) {
            if(students[i] == 0) {
                if(i - 1 >= 0 && students[i - 1] == 2) {
                    students[i] ++ ;
                    students[i - 1] -- ;
                } else if(i + 1 < n && students[i + 1] == 2) {
                    students[i] ++ ;
                    students[i + 1] -- ;
                }
            }
        }

        for(int i : students)
            answer += i == 2 ? 1 : i;

        return answer;
    }
}