package LeetCode.Easy;

public class ReverseBits_19 {

    public static void main(String[] args) {

    }

    public int reverseBits(int n) {
        String s = Integer.toBinaryString(n);
        System.out.println(s);

        String s2="";

        char arr[]=s.toCharArray();
        for(int i=s.length()-1;i>=0;i--){
            s2+=arr[i];
        }

        if(s.length()<32){
            for(int i=0;i<32-s.length();i++){
                s2+='0';
            }
        }

        long x = Long.parseLong(s2, 2);

        return (int) x;
    }
}
