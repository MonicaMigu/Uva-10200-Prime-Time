import java.util.Scanner;
import java.math.*;
import java.text.DecimalFormat;

class Main {
    public static int[] db = new int[100010042];    // 新增一個大於 10000 * 10000 + 10000 + 41 大小的質數表陣列

    public static void main(String args[]) {
        Prime prime = new Prime();
        prime.getTable(db);
        Scanner scn = new Scanner(System.in);
        DecimalFormat formatter = new DecimalFormat("#0.00");   // 把輸出格式設定為顯示至小數點後兩位
        while (scn.hasNext()) {
            int min = scn.nextInt();    // 輸入值範圍的最小值
            int max = scn.nextInt();    // 輸入值範圍的最大值
            int ok = 0; // 在輸入值範圍內是質數的數量
            for (int i = min; i <= max; i++) {
                if (db[i * i + i + 41] == 1) {  // 若輸入值範圍內的某一個數 = 1 (是質數)，則 ok + 1
                    ok++;
                }
            }
            double result = (double)ok * 10000/ (double)(max - min +1); // 算出 輸入值範圍內是質數的機率 * 100
            System.out.println(formatter.format((double)Math.round(result) / 100.0));   // 再用上面設定的輸出格式輸出 輸入值範圍內是質數的機率
        }
    }

    static class Prime {
      public void getTable(int[] box) {
        for (int i = 0; i < box.length; i++)
            box[i] = 1; // 質數表預設值皆等於 1 (true)
        box[0] = 0; // 0 不是質數，所以設 0 (false)
        box[1] = 0; // 1 不是質數，所以設 0 (false)
        for (int i = 2; i <= Math.sqrt(box.length); i++) {  // 因為任何數 1 以外的倍數絕對不會是質數，所以先把所有 2 的倍數挑掉，然後是 3，然後是 4 ...這樣依序做下去，直到把所有索求範圍內的倍數（非值數）挑掉
            for (int j = i * 2; j < box.length; j += i) {
                if (box[i] == 1)
                    box[j] = 0;
            }
        }
      }
    }
}