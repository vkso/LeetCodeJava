package HWOD.niuke;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class hj68 {

    static class Student {
        String name;
        Integer score;
        Integer index;

        public Student(String name, Integer score, Integer index) {
            this.name = name;
            this.score = score;
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public Integer getScore() {
            return score;
        }

        public Integer getIndex() {
            return index;
        }

        @Override
        public String toString() {
            return name + " " + score;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int op = Integer.parseInt(sc.nextLine());

        // 升序优先队列
        PriorityQueue<Student> pqIncrease = new PriorityQueue<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getScore().equals(o2.getScore())) {
                    return o1.getIndex().compareTo(o2.getIndex());
                }
                return o1.getScore().compareTo(o2.getScore());
            }
        });

        // 降序优先队列
        PriorityQueue<Student> pqDecrease = new PriorityQueue<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getScore().equals(o2.getScore())) {
                    return o1.getIndex().compareTo(o2.getIndex());
                }
                return o2.getScore().compareTo(o1.getScore());
            }
        });

        PriorityQueue<Student> pq = null;

        pq = op == 0 ? pqDecrease : pqIncrease;

        for (int i = 0; i < n; i++) {
            String[] split = sc.nextLine().split(" ");

            Student student = new Student(split[0], Integer.parseInt(split[1]), i);
            pq.add(student);
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

    }
}
