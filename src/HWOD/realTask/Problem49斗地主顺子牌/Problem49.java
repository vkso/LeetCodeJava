package HWOD.realTask.Problem49斗地主顺子牌;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem49 {

    static class Card {
        int weight;
        String cardType;

        public Card(String cardType) {
            this.cardType = cardType;
            this.weight = changeToWeight(this.cardType);
        }

        public int getWeight() {
            return weight;
        }

        public String getCardType() {
            return cardType;
        }

        public int changeToWeight(String cardType) {
            switch (cardType) {
                case "3":
                    return 1;
                case "4":
                    return 2;
                case "5":
                    return 3;
                case "6":
                    return 4;
                case "7":
                    return 5;
                case "8":
                    return 6;
                case "9":
                    return 7;
                case "10":
                    return 8;
                case "J":
                    return 9;
                case "Q":
                    return 10;
                case "K":
                    return 11;
                case "A":
                    return 12;
                case "2":
                    return 13;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");

        ArrayList<Card> cards = new ArrayList<>();
        for (String card : split) {
            cards.add(new Card(card));
        }

        cards.sort((a, b) -> a.getWeight() - b.getWeight());

        ArrayList<ArrayList<String>> result = new ArrayList<>();

        int left = 0;
        for (int i = 1; i < cards.size(); i++) {
            // 当前不连续
            // 【核心代码】
            if (cards.get(i).getWeight() != cards.get(i - 1).getWeight() + 1) {
                if (i - left >= 5) {
                    // 如果前面有 5 长牌，可以凑成顺子，那么可以将其添加到结果数组中
                    ArrayList<String> tempList = new ArrayList<>();
                    for (int j = left; j < i; j++) {
                        tempList.add(cards.get(j).getCardType());
                    }
                    result.add(tempList);
                }
                left = i;
            }
        }

        // 处理最后一段
        if (cards.size() - left >= 5) {
            ArrayList<String> list = new ArrayList<>();
            for (int j = left; j < cards.size(); j++) {
                list.add(cards.get(j).getCardType());
            }
            result.add(list);
        }

        if (result == null || result.isEmpty()) {
            System.out.println("No");
            return;
        }

        result.forEach(list -> {
            System.out.println(String.join(" ", list));
        });
    }
}
