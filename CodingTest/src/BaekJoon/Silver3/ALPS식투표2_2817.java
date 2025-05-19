package BaekJoon.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ALPS식투표2_2817 {
    /*
235217
3
A 107382
C 18059
B 43265
     */

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int participants = Integer.parseInt(br.readLine());
            int staffCount = Integer.parseInt(br.readLine());
            System.out.println(solution(staffCount, br, participants));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StringBuilder solution(int staffCount, BufferedReader br, int participants) throws IOException {
        PriorityQueue<StaffScore> staffScores = new PriorityQueue<>();
        Map<String, Integer> staffMap = new HashMap<>(); //참가자-칩 Map
        for (int i = 0; i < staffCount; i++) {
            String[] arr = br.readLine().split(" ");
            int vote = Integer.parseInt(arr[1]);
            if (vote < participants * 0.05) {
                continue;
            }
            staffMap.put(arr[0], 0); //칩 개수를 0으로 초기화
            makeScoreGroup(vote, arr, staffScores); //점수 집합 만들기
        }
        addChipMap(staffMap, staffScores);
        List<Staff> staff = getStaffList(staffMap); //Map을 List로 변환
        StringBuilder str = getResult(staff);
        return str;
    }

    private static StringBuilder getResult(List<Staff> staff) {
        StringBuilder str = new StringBuilder();
        Collections.sort(staff);
        for (Staff s : staff) {
            str.append(s.getName()).append(" ").append(s.getChip()).append("\n");
        }
        return str;
    }

    private static List<Staff> getStaffList(Map<String, Integer> staffMap) {
        List<Staff> staff = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : staffMap.entrySet()) {
            Staff staffMember = Staff.of(entry.getKey(), entry.getValue());
            staff.add(staffMember);
        }
        return staff;
    }

    private static void makeScoreGroup(int vote, String[] arr, PriorityQueue<StaffScore> scores) {
        for (int i = 1; i <= 14; i++) { //1~14로 나누어서 점수 집합 만들기
            StaffScore staffScore = StaffScore.of(arr[0], vote / (double)i);
            scores.add(staffScore);
        }
    }

    private static Map<String, Integer> addChipMap(Map<String, Integer> staffMap, PriorityQueue<StaffScore> scores) {
        for (int i = 0; i < 14 && !scores.isEmpty(); i++) { //점수집합이 14개 미만일 수도 있음(isEmpty 사용)
            StaffScore staffScore = scores.poll(); //점수 집합에서 하나 빼서
            staffMap.put(staffScore.name, staffMap.getOrDefault(staffScore.name, 0) + 1); //이름 비교해서 chip개수 올려줌
        }
        return staffMap;
    }

    static class Staff implements Comparable<Staff> {

        private String name;
        private int chip;

        public static Staff of(String name, int chip) {
            Staff staff = new Staff();
            staff.name = name;
            staff.chip = chip;
            return staff;
        }

        public String getName() {
            return name;
        }

        public int getChip() {
            return chip;
        }

        @Override
        public int compareTo(Staff o) {
            return this.name.compareTo(o.name); // 이름 오름차순 정렬
        }

    }

    static class StaffScore implements Comparable<StaffScore> {

        private String name;
        private double score;

        public StaffScore(String name, double score) {
            this.name = name;
            this.score = score;
        }

        public static StaffScore of(String name, double score) {
            return new StaffScore(name, score);
        }

        @Override
        public int compareTo(StaffScore o) {
            return Double.compare(o.score, this.score); //내림차순 정렬
        }

    }

}
