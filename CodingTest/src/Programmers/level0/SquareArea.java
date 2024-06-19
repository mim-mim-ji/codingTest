package Programmers.level0;

public class SquareArea {
    public static void main(String[] args) {
        int[][] dots = {{1, 1}, {2, 1}, {2, 2}, {1, 2}};

        System.out.println(solution(dots));
    }

    public static int solution(int[][] dots) {
        int answer = 0;

        int x1 = 0;
        int x2 = 0;
        int y1 = 0;
        int y2 = 0;

        for(int i=0;i<dots.length;i++){
            x1 = dots[i][0];
            y1 = dots[i][1];
            for(int j=1;j<dots.length;j++){
                if(x1 != dots[j][0]) x2 = dots[j][0];
                if(y1 != dots[j][1]) y2 = dots[j][1];
            }
        }

        answer = Math.abs(x1-x2) * Math.abs(y1-y2);
        return answer;
    }
}
