package Programmers.level2;

public class KeyPad {

	/*
	 * 왼: 1,4,7
	 * 오: 3,6,9
	 * 가운데 : 2,4,6,0
	 * 둘 중 가까운 손가락, 같으면 hand로 구별
	 */

	public static void main(String[] args) {
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		System.out.println(solution(numbers, hand)); //"LRLLLRLLRRL"
	}

	public static String solution(int[] numbers, String hand) {
		String answer = "";

		int LH = 10;
		int RH = 12;

		for(int num:numbers) {
			if(num == 1 || num==4 || num==7) { //1,4,7
				answer += "L";
				LH = num;
				
			}else if(num == 3 || num==6 || num==9){ //3,6,9
				answer += "R";
				RH = num;
				
			}else { //2,5,8,0 
				
				if(num==0) num=11; //num이 0이면 11
				
				int DLH = (num > LH) ? num-LH : LH-num;
				int DRH = (num > RH) ? num-RH : RH-num;
				int distanceL = (DLH / 3) + ( DLH % 3);
				int distanceR = (DRH / 3) + ( DRH % 3);

				if(distanceL > distanceR) {
					answer += "R";
					RH = num;
					
				}else if(distanceL < distanceR){
					answer += "L";
					LH = num;
					
				}else {
					if(hand.equals("right")) {
						answer += "R";
						RH = num;
						
					}else if(hand.equals("left")){
						answer += "L";
						LH = num;
						
					}
				}

			}

		}
		return answer;
	}

}
