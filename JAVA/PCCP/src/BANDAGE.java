//url: https://school.programmers.co.kr/learn/courses/30/lessons/250137

class BANDAGE {

    public static void main(String[] args) {
        System.out.print(
                solution(new int[]{5, 1, 5}, 30, new int[][]{{2, 10},{9, 15},{10, 5},{11, 5}})
        );
    }

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int preTime = 0;

        for(int i=0; i < attacks.length; i++){

            int time = attacks[i][0] - preTime - 1;
            int plusHealth = bandage[1] * (time)
                    + (time / bandage[0] * bandage[2]);
            health += plusHealth;
            health = health > maxHealth ? maxHealth : health;
            health = health - attacks[i][1];

            if(health < 0)
                break;

            preTime = attacks[i][0];
        }

        return (health <= 0 ? -1 : health);
    }
}
