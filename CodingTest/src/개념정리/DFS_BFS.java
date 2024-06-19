package 개념정리;

public class DFS_BFS {
    /*
    문제유형
    1. 모든 정점을 방문해야할 경우 : 둘 다 가능
    2. 경로의 특징을 저장해둬야 할 경우 : DFS
    3. 최단경로 : BFS
    4. 그래프의 규모가 정말 클 경우  : DFS
    5. 그래프의 규모가 크지 않고, 시작지점으로부터 멀지 않을 경우 : BFS
    6. 두 가지 일이 동시에 일어날 경우 : BFS

    * BFS 알고리즘
    BFS (Breadth-First Search) 알고리즘은 그래프 탐색 알고리즘 중 하나로, 너비 우선으로 탐색하는 방법입니다.
    즉, 시작 정점으로부터 가까운 정점부터 우선적으로 탐색하는 방법입니다.

    기본적인 BFS 알고리즘의 동작 방식은 다음과 같습니다.

    1. 시작 노드을 Queue에 넣고 방문 처리한다.
    2. Queue에서 노드를 꺼내고 인접 노드 중에 방문하지 않는 노드를 큐에 삽입한 뒤 방문 처리한다.
    3. 2번 과정을 더 수행할 수 없을 때까지 반복한다.

    --구현하기
    1. Queue에서 꺼내 온다. (Deque)
    2. 목적지인가?
        2-1. 목적지라면 return
    3. 연결 노드 순회
        3-1. 갈 수 있는가?
        3-1-1. 방문 체크
        3-1-2. Queue에 넣는다.

    BFS 알고리즘을 이용하여 그래프의 모든 정점을 탐색할 수 있으며, 시작 정점으로부터 각 정점까지의 최단 거리를 구할 수 있습니다.

    *DFS 알고리즘
    DFS(Depth-First Search) : 깊이 우선 탐색
    모든 노드를 방문할 경우, 이동과정에 제약이 있을 경우 사용한다.
    스택 자료 구조(혹은 재귀 함수)를 사용한다.

    1. 시작 노드를 스택에 넣고 방문 처리한다.
    2. 스택의 최상단 노드에 방문하지 않은 인접 노드가 있다면 그 노드를 스택에 넣고 방문 처리한다.
    3. 방문하지 않은 인접 노드가 없다면 스택에서 최상단 노드를 뺀다.
    4. 2번의 과정을 수행할 수 없을 때까지 반복한다.

    --구현하기
    1. 목적지인가?
        1-1. 목적지라면 return
    2. 연결 노드 순회
        2-1. 갈 수 있는가?
            2-1-1. dfs() 호출
     */
}
