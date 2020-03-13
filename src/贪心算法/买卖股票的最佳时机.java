package 贪心算法;

/**
 * @ClassName： 买卖股票的最佳时机
 * @description:
 * @author: lisheng
 * @create: 2020-03-05 10:13
 **/
public class 买卖股票的最佳时机 {
    //穷举法
    public static  int maxProfit(int[] prices) {
        //买时的价格
        int sum=0;
        int buyDay=0;
        //所有上升波段的和
        while (buyDay<prices.length-1){
            int sellDay=buyDay+1;
            int thisSum=0;
            int currDay=buyDay;
            while (sellDay<prices.length){
                if(prices[sellDay]>prices[currDay]){
                    thisSum+=prices[sellDay]-prices[currDay];
                    currDay=sellDay;
                }
                sellDay++;
            }
            sum=Math.max(thisSum,sum);
            buyDay++;
        }
        return sum;

    }
    public  static int maxProfit2(int[] prices){
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;


    }

    public static void main(String[] args) {

        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
