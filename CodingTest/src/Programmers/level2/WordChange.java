package Programmers.level2;

public class WordChange {

	/*
	 *  1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
		2. words에 있는 단어로만 변환할 수 있습니다.
		예를 들어 begin이 "hit", target가 "cog", words가 
		["hot","dot","dog","lot","log","cog"]라면 
		"hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 
		 4단계를 거쳐 변환할 수 있습니다.

		 변환할 수 없는 경우에는 0를 return 합니다.
	 */

	public static void main(String[] args) {

		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(solution(begin, target, words)); //4
	}

	static int answer=0;      //최소 단계
	static boolean[] visited; 
	
	public static int solution(String begin, String target, String[] words) {
		visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;

	}

	public static void dfs(String begin, String target, String[] words, int cnt) {
		if (begin.equals(target)) { //begin과 target이 같은 경우, cnt를 answer에 대입하고 종료
            answer = cnt;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {
                continue;
            }

            int k = 0;    // 같은 스펠링 몇개인지 세기
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    k++;
                }
            }

            if (k == begin.length() - 1) {  // 한글자 빼고 모두 같은 경우
                visited[i] = true; //찾은 단어는 true로 설정
                dfs(words[i], target, words, cnt + 1); //재귀함수
                visited[i] = false; //모든 경우의 수를 보기 위해 visited = false로 재설정한다.(초기값이 false니까)
            }
        }

	}

}
