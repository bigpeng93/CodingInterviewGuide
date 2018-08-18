package RecursionAndDynamic.Hanoi;

/**
 * 汉诺塔问题
 * <p>
 * 给定一个整数n,代表汉诺塔游戏中从小到大放置的n个圆盘,假设开始时所有的圆盘都放在左边的柱子上,
 * 想按照汉诺塔游戏的要求把所有的圆盘都移到右边的柱子上,实现函数打印最优移动轨迹。
 * <p>
 * 举例：
 * n = 1时，打印：
 * move from left to right
 * n = 2时,打印:
 * move from left to mid
 * move from left to right
 * move from mid to right
 */
public class OrgQuestion {
    public void hanoi(int n) {
        if (n > 0) {
            func(n, "from", "mid", "to");
        }
    }

    public void func(int n, String from, String mid, String to) {
        if (n == 1) {
            System.out.println("move from " + from + " to " + to);
        } else {
            func(n - 1, from, to, mid);
            func(1, from, mid, to);
            func(n - 1, mid, from, to);
        }
    }
}
