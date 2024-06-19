package Programmers.level1;

import java.util.*;

public class Complain {
    /*
    각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
    신고 횟수에 제한은 없습니다. 서로 다른 유저를 계속해서 신고할 수 있습니다.
    한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.
    k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.
    유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송합니다.

    유저 ID	 신고당한 횟수
    "muzi"	    1
    "frodo"	    2
    "apeach"	0
    "neo"	    2

    유저 ID	    유저가 신고한 ID	    정지된 ID
    "muzi"	    ["frodo", "neo"]	["frodo", "neo"]
    "frodo"	    ["neo"]	            ["neo"]
    "apeach"	["muzi", "frodo"]	["frodo"]
    "neo"	    없음	                없음

    따라서 "muzi"는 처리 결과 메일을 2회, "frodo"와 "apeach"는 각각 처리 결과 메일을 1회 받게 됩니다.
     */
    public static void main(String[] args) {

        String[] id_list={"muzi", "frodo", "apeach", "neo"};
        String[] report={"muzi frodo", "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        //result = {2,1,1,0}
        System.out.println(Arrays.toString(solution(id_list,report,k)));
        System.out.println(Arrays.toString(solution2(id_list,report,k)));
    }
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        //중복제거
        Set<String> set = new HashSet<>();

        //신고당한사람 횟수 map 저장
        Map<String, Integer> map = new HashMap<>();

        for(String s : report){
           set.add(s);
        }

        for(String repo : set){
            String[] arr = repo.split(" ");

            map.put(arr[1],map.getOrDefault(arr[1],0)+1);
        }

        for (String repo : set){
            String[] arr = repo.split(" ");
            if(map.get(arr[1]) >= k) {
                for (int i = 0; i < id_list.length; i++) {
                    if (id_list[i].equals(arr[0])) {
                        answer[i] += 1;
                    }
                }
            }
        }

        return answer;
    }

    public static int[] solution2(String[] id_list, String[] report, int k) {
        //key: 신고당한사람, value: 신고한 사람 리스트
        Map<String,Set<String>> map = new HashMap<>();

        for(String repo : report){
            String [] arr = repo.split(" ");
            Set<String> set = map.getOrDefault(arr[1],new HashSet<>());
            set.add(arr[0]); //신고한 사람 추가
            map.put(arr[1],set);
        }
        System.out.println(map);

        //key: 알림받을 사람, value: 알림받는 횟수
        Map<String,Integer> countMap = new LinkedHashMap<>();

        for(String id : id_list){
            countMap.put(id,0);
        }

        for(Map.Entry<String,Set<String>> entry : map.entrySet()){
            System.out.println(entry);
            if(entry.getValue().size()>=k){
                for(String value : entry.getValue()){ //신고한사람
                    countMap.put(value,countMap.getOrDefault(value,0)+1);
                }
            }
        }

        return countMap.values().stream().mapToInt(Integer::intValue).toArray();
    }
}
