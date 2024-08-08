package 개념정리.인프런.그래프;

public class 그래프 {
    /*
    그래프는 노드와 엣지로 구성된 집합
    노드: 데이터를 표현하는 단위
    엣지: 노드를 연결

    1. 유니온 파인드: 그래프의 사이클이 생성되는지 판별하는 알고리즘

    2. 위상정렬
     - 조건: 사이클x, 방향이 있는 그래프, 노드를 정렬해주는 알고리즘, 정렬결과가 꼭 1개가 아님
     ex) 수강신청 문제

    3. 다익스트라: 시작점이 있고 다른 모든 노드로 가는 최단거리를 구하는 알고리즘, 단 음수간선은 x

    4. 벨만-포드: 시작점이 있고 다른 모든 노드로 가는 최단거리를 구하는 알고리즘, 음수간선 o
     - 음수사이클이 있는지?
     ex) 시간여행

    5. 플로이드-워셜: 시작점 X, 임의의 모든 노드 쌍의 최단거리 구하는 알고리즘
    - 모든 도시간의 최단거리, n이 작을 때 사용가능

    3,4,5 -> 최단거리 알고리즘

    6. 최소 신장 트리(MST): 그래프에서 최소의 가중치 합으로 모든 노드를 연결할 수 있게 해주는 알고리즘
    - 유니온 파인드 구현하는 부분 있음(사이클 있으면 안되기 때문)


     */
}
