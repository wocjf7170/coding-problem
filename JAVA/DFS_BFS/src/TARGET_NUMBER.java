//https://school.programmers.co.kr/learn/courses/30/lessons/43165?language=java
public class TARGET_NUMBER {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");
    }
}
class Solution {

    int targetNum = 0;
    int[] globalNumbers;

    public int solution(int[] numbers, int target) {
        targetNum = target;
        globalNumbers = numbers;

        return makeTargetNumber(0, 0);
    }

    public int makeTargetNumber(int idx, int curSum) {

        if(idx == globalNumbers.length) {
            if(curSum == targetNum)
                return 1;
            else
                return 0;
        }

        return makeTargetNumber(idx + 1, globalNumbers[idx] + curSum)
                + makeTargetNumber(idx + 1, -globalNumbers[idx] + curSum);

    }
}