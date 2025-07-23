public class MAKE_BiG_NUMBER {
    public String solution(String number, int k) {
        String answer = "";

        int curLen = number.length();
        int maxLen = curLen - k;

        StringBuilder sb = new StringBuilder();

        int tempMax = -1;
        int tempMaxIdx = 0;

        int maxLoop = curLen - maxLen + 1;

        if(maxLen == 0) {
            return "";
        }

        for(int i= 0; i < maxLoop; i ++) {
            int temp = number.charAt(i) - '0';

            if(temp > tempMax) {
                tempMax = temp;
                tempMaxIdx = i;
            }

            if(i == maxLoop - 1) {
                sb.append(tempMax);
                if(sb.length() == maxLen) {
                    break;
                }
                i = tempMaxIdx;
                tempMax = -1;
                tempMaxIdx = 0;
                maxLoop = curLen - (maxLen - sb.length()) + 1;

                if((maxLen - sb.length()) == ((i+1)-maxLoop)) {
                    sb.append(number.substring(i+1, maxLoop));
                }
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {

    }
}
