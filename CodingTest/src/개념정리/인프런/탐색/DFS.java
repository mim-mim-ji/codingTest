package 개념정리.인프런.탐색;

public class DFS {
    /*
      깊이 우선 탐색

      그래프 완전 탐색 기법 중 하나
      시작 노드에서 출발하여 탐색할 한 쪽 분기를 정하여 최대깊이까지 탐색을 마친 후 다른쪽 분기로 이동하여 다시 탐색을 수행하는 알고리즘

      시간복잡도: O(V+E)
      V= 노드 수, E = 엣지 수

      재귀함수 사용 -> 스택오버플로에 유의해야함

      문제: 단절점찾기, 단절선찾기, 사이클찾기, 위상 정렬 등

      * 핵심이론
      한번 방문한 노드를 다시 방문하면 안되므로 노드 방문 여부를 체크할 배열이 필요
      그래프는 인접 리스트로 표현
      후입선출 특성 = 스택

     */
}
