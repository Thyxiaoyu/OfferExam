package dongfangcaifu;

import java.util.Scanner;

/**
 * @author ThyXiaoyu
 * @create 2019-08-06 21:24
 * 描述：假设你已经提前知道股票的连续n天的价格走势，以长度为n的整数数组表示，数组中第i个元素代表该股票第i天的股价。假设你一开始没有股票，但有至多
 * 两次买入1股而后卖出的机会，并且买入前一定要先保证手上没有股票。计算你能获得的最大收益。测试用例：
 * 6
 * 2 5 3 9 15 2
 * 输出：15
 */
public class Q2 {
    private static void method(int n, int[] nums) {
        int[][][] dp = new int[n][3][2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                if (i == 0 && j == 0) {
                    dp[0][i][j] = 0;
                } else if (i == 1 && j == 1) {
                    dp[0][i][j] = -nums[0];
                } else {
                    dp[0][i][j] = Integer.MIN_VALUE;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 3; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + nums[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], (dp[i - 1][j - 1][0] == Integer.MIN_VALUE)? Integer.MIN_VALUE : dp[i - 1][j - 1][0] - nums[i]);
            }
        }








        /*dp[0][0][0] = 0;
        dp[0][0][1] = -nums[0];
        for (int i = 1; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                dp[0][i][j] = Integer.MIN_VALUE;
            }
        }
        for (int i = 1; i < n; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - nums[i]);
            for (int j = 1; j < 3; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + nums[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], (dp[i - 1][j][0] == Integer.MIN_VALUE)? Integer.MIN_VALUE: dp[i - 1][j][0] - nums[i]);
            }
        }*/
        System.out.println(dp[n - 1][2][0]);
        /*int fBuy = Integer.MIN_VALUE;
        int fSell = 0;
        int sBuy = Integer.MIN_VALUE;
        int sSell = 0;
        for (int num : nums) {
            fBuy = Math.max(fBuy, -num);
            fSell = Math.max(fSell, fBuy + num);
            sBuy = Math.max(sBuy, fSell - num);
            sSell = Math.max(sSell, sBuy + num);
        }
        System.out.println(sSell);*/
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        method(n,nums);
    }
}
