package LeetCode.Easy;

public class ExcelSheetColumnTitle_168 {

    public static void main(String[] args) {
        int columnNumber = 28;
        System.out.println(convertToTitle(columnNumber));
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder title = new StringBuilder();
        while(columnNumber >0){
            columnNumber--;
            int remainder = columnNumber % 26;
            char letter = (char)('A' + remainder);
            title.insert(0,letter);
            columnNumber /= 26;
        }
        return title.toString();
    }
}
