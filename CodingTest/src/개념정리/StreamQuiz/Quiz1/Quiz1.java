package 개념정리.StreamQuiz.Quiz1;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Quiz1 {

    private static final String TARGET = "좋아";
    private static final int TARGET_LENGTH = TARGET.length();

    // 1.1 각 취미를 선호하는 인원이 몇 명인지 계산하여라.
    public Map<String, Integer> quiz1() throws IOException, CsvException {
        List<String[]> csvLines = readCsvLines();

        return csvLines.stream()
                .map(line -> line[1].replaceAll("\\s","")) //\\s: 공백문자, 탭만을 허용만 정규표현식
                .flatMap(hobbies -> Arrays.stream(hobbies.split(":")))
                .collect(Collectors.toMap(hobby -> hobby, hobby -> 1, (oldValue, newValue) -> newValue += oldValue));
    }

    public void quiz1_1() throws IOException, CsvException {
        List<String[]> persons = readCsvLines();
        //첫 줄 제거
        persons.remove(0);
        //결과를 담을 해시맵 구성
        Map<String, Integer> result = new HashMap<>();
        persons.stream()
                .flatMap(member -> Arrays.stream(member[1].split(":"))) //취미를 플랫하게 스트림으로 분리
                .forEach(hobby -> result.merge(hobby, 1, (oldValue, newValue)->++oldValue));
        //출력
        result.entrySet().forEach(entry-> System.out.println(entry.getKey() + " " + entry.getValue()));
    }

    // 1.2 각 취미를 선호하는 정씨 성을 갖는 인원이 몇 명인지 계산하여라.
    public Map<String, Integer> quiz2() throws IOException, CsvException {
        List<String[]> csvLines = readCsvLines();
        return csvLines.stream()
                .filter(line -> line[0].startsWith("정"))
                .map(line -> line[1].replaceAll("\\s",""))
                .flatMap(hobbies -> Arrays.stream(hobbies.split(":")))
                .collect(Collectors.toMap(hobby -> hobby, hobby -> 1, (oldValue, newValue) -> newValue += oldValue));
    }

    // 1.3 소개 내용에 '좋아'가 몇번 등장하는지 계산하여라.
    public int quiz3() throws IOException, CsvException {
        List<String[]> csvLines = readCsvLines();
        return csvLines.stream()
                .map(line -> countContains(line[2],0))
                .reduce(0,Integer::sum);
    }

    private int countContains(String src, int fromIndex) {
        int index = src.indexOf(TARGET,fromIndex);
        if (index >= 0) {
            return 1 + countContains(src, index + TARGET_LENGTH);
        }
        return 0;
    }

    private List<String[]> readCsvLines() throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new FileReader(getClass().getResource("/user.csv").getFile()));
        csvReader.readNext();
        return csvReader.readAll();
    }

}
