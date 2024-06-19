package BaekJoon.Gold5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MST_1717 {
    static int [] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];

        for(int i=1;i<=n;i++){
            parent[i] = i;
        }
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int dif = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(dif == 0){
                unite(a,b);
            }else if(dif==1){
                sb.append((same(a,b) ? "YES" : "NO") + "\n");
            }else{
                continue;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int find(int x) {
        if(x == parent[x]) return x;

        return parent[x] = find(parent[x]);
    }

    private static boolean same(int a, int b) {
        return find(a) == find(b);
    }

    private static void unite(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}
