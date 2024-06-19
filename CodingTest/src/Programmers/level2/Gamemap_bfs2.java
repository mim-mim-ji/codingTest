package Programmers.level2;
import java.util.*;

public class Gamemap_bfs2 {
    public static void main(String[] args) {

        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        // answer = 11
        // 벽:0, 갈수있는 길:1
        System.out.println(solution(maps));
    }

        public static int solution(int[][] maps) {
            int n = maps.length;
            int m = maps[0].length;

            // 방문 여부를 저장하는 2차원 배열
            boolean[][] visited = new boolean[n][m];
            // 시작점 방문 처리
            visited[0][0] = true;

            // bfs 탐색을 위한 큐 생성
            Queue<int[]> q = new LinkedList<>();
            // 시작점 추가
            q.offer(new int[]{0, 0, 1}); // x좌표, y좌표, 이동 거리

            // bfs 탐색
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                int dist = cur[2];

                // 도착점에 도달한 경우 이동 거리를 반환
                if (x == n - 1 && y == m - 1) {
                    return dist;
                }

                // 현재 위치에서 이동 가능한 위치 탐색
                int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상, 하, 좌, 우
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    // 지도 범위를 벗어나는 경우 무시
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        continue;
                    }

                    // 벽인 경우 무시
                    if (maps[nx][ny] == 0) {
                        continue;
                    }

                    // 이미 방문한 위치인 경우 무시
                    if (visited[nx][ny]) {
                        continue;
                    }

                    // 이동 가능한 위치를 큐에 추가
                    q.offer(new int[]{nx, ny, dist + 1});
                    // 이동한 위치를 방문 처리
                    visited[nx][ny] = true;
                }
            }

            // 도착점에 도달할 수 없는 경우 -1 반환
            return -1;
        }
}
