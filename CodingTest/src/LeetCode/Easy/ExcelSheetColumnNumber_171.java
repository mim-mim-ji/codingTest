package LeetCode.Easy;

public interface ExcelSheetColumnNumber_171 {

    public static void main(String[] args) {
        String columnTitle = "AB";

        System.out.println(titleToNumber(columnTitle));
    }

    public static int titleToNumber(String columnTitle) {
        int result = 0;
        for(int i=0; i < columnTitle.length(); i++){
            result *= 26;
            result += columnTitle.charAt(i) - 'A' + 1;
        }
        return result;
    }
}
