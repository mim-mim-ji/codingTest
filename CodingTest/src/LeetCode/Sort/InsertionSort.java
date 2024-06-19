package LeetCode.Sort;

public class InsertionSort {
    /*
    [삽입정렬]
    1. 현재 타겟이 되는 숫자와 이전 위치에 있는 원소들을 비교한다. (첫 번째 타겟은 두 번째 원소부터 시작한다.)
    2. 타겟이 되는 숫자가 이전 위치에 있던 원소보다 작다면 위치를 서로 교환한다.
    3. 그 다음 타겟을 찾아 위와 같은 방법으로 반복한다.

    - 추가적인 메모리 소비가 적음
    - 안정 정렬
    - 시간복잡도 : 최선 O(N), 최악 O(N2)
     */

    public void insertionSort(int [] arr){

        for(int i=1 ; i<arr.length ; i++){
            int currentIndex = i;
            while(currentIndex >0 && arr[currentIndex-1] > arr[currentIndex]){
                //swap
                int temp = arr[currentIndex];
                arr[currentIndex] = arr[currentIndex-1];
                arr[currentIndex-1] = temp;
                currentIndex -= 1;
            }
        }
    }
}
