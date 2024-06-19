package Programmers.level1;

public class EnglishWord {

	public static void main(String[] args) {
		String s = "one4seveneightone";
		System.out.println(solution2(s)); //1478

		String str1 = "안녕. 하세요. 반갑습니다.";
		String str2 = str1.replace(".", "~");
		String str3 = str1.replaceAll(".", "~");

		System.out.println(str2);
		System.out.println(str3);
	}

	public static int solution(String s) {
		int answer = 0;

		char[] ch = s.toCharArray();
		String[] words = {"zero","one","two","three","four","five","six","seven","eight","nine"};

		String word = "";
		String temp ="";

		for(int i=0;i<s.length();i++) {
			if(ch[i]>=65) {  //A이상이면
				word += ch[i];
				System.out.println("word:" + word);
				int k=0;
				for(String st:words) {   			   
					if(word.equals(st)) {
						System.out.println("index="+ k);
						temp += k;    				  
						word="";
					}
					k++;
				}

			}else {
				temp += ch[i];
			}
		}

		answer = Integer.parseInt(temp);
		return answer;
	}

	public static int solution2(String s) {
		
		String[] alphabets = {"zero","one","two","three","four","five","six","seven","eight","nine"};
		String[] digits = {"0","1","2","3","4","5","6","7","8","9"};

		for(int i=0; i<alphabets.length; i++){
			s = s.replace(alphabets[i],digits[i]);
		}

		return Integer.parseInt(s);
	}


	public static int solution3(String s) {
		String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		for (int i = 0; i < arr.length; i++) {

			s = s.replaceAll(arr[i], Integer.toString(i));

		}
		return Integer.parseInt(s);
	}

}
