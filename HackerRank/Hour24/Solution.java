import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int rq = in.nextInt();
        int cq = in.nextInt();
        int subq = rq - cq;
        int addq = rq + cq;
        int u = -1;
        int d = -1;
        int l = -1;
        int r = -1;
        int ul = -1;
        int ur = -1;
        int dl = -1;
        int dr = -1;
        int sub = 0;
        int add = 0;
        for(int a0 = 0; a0 < k; a0++){
            int ro = in.nextInt();
            int co = in.nextInt();
            sub = ro - co;
            add = ro + co;
            // your code goes here
            if(ro == rq){
                if((co - cq) > 0){
                    if((co - cq) < r || r == -1)
                        r = co - cq - 1;
                }
                else{
                    if((cq - co) < l || l == -1){
                        // System.out.println(cq);
                        l = cq - co - 1;
                    }
                }
            }
            else if(co == cq){
                if((ro - rq) > 0){
                    if((ro - rq) < u || u == -1)
                        u = ro - rq - 1;
                }
                else{
                    if((rq - ro) < d || d == -1)
                        d = rq - ro - 1;
                }
            }
            else if(sub == subq){
                if((co - cq) > 0){
                    if((co - cq) < ur || ur == -1)
                        ur = co - cq - 1;
                }
                else{
                    if((cq - co) < dl || dl == -1)
                        dl = cq - co - 1;
                }
            }
            else if(add == addq){
                if((co - cq) > 0){
                    if((co - cq) < dr || dr == -1)
                        dr = co - cq - 1;
                }
                else{
                    if((cq - co) < ul || ul ==  -1)
                        ul = cq - co - 1;
                }
            }
        }
        if(l == -1){
            // System.out.println(rq);   
            l = cq-1;
        }
        if(u == -1)
            u = n - rq;
        if(r == -1)
            r = n -cq;
        if(d == -1)
            d = rq - 1;
        if(dl == -1)
            dl = Math.min(cq-1,rq-1);
        if(ul == -1)
            ul = Math.min(cq-1,n-rq);
        if(dr == -1)
            dr = Math.min(n-cq,rq-1);
        if(ur == -1)
            ur = Math.min(n-cq,n-rq);
        
        // System.out.println("u:"+u);
        // System.out.println("l:"+l);
        // System.out.println("r:"+r);
        // System.out.println("d:"+d);
        // System.out.println("ul:"+ul);
        // System.out.println("ur:"+ur);
        // System.out.println("dl:"+dl);
        // System.out.println("dr:"+dr);
        
        System.out.println(u+l+d+r+ul+ur+dl+dr);
    }
}
