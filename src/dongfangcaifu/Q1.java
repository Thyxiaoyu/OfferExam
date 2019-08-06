package dongfangcaifu;

import java.util.Scanner;

/**
 * @author ThyXiaoyu
 * @create 2019-08-06 20:46
 * 描述：给出三个字符串str1,str2,str3，判断str3是否由str1和str2交叉组成，如果是则输出TRUE,否则输出FALSE。
 * 测试用例：
 * aabcc dbbca aadbbcbcac
 * 输出：TRUE
 */
public class Q1 {
    private static boolean method(String s1, String s2, String s3) {
        if (s1.length() <= 0) return s2.equals(s3);
        if (s2.length() <= 0) return s1.equals(s3);
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        //System.out.println(core(c1, c2, c3, 0, 0, 0));
        return core(c1, c2, c3, 0, 0, 0);
    }
    private static boolean core(char[] c1, char[] c2, char[] c3, int l1, int l2, int l3) {
        if (l3 == c3.length) return true;
        char c = c3[l3];
        boolean ans = false;
        if (l1 < c1.length && c1[l1] == c) {
            ans = ans || core(c1, c2, c3, l1 + 1, l2, l3 + 1);
        }
        if (l2 < c2.length && c2[l2] == c) {
            ans = ans || core(c1, c2, c3, l1, l2 + 1, l3 + 1);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split(" ");
        boolean ans = method(ss[0], ss[1],ss[2]);
        if (ans) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
        //method("aabcc", "dbbca", "aadbbcdcac");
    }
}
