import java.io.*;
import java.util.*;

public class Main {

    static class Person {
        String name;
        int day, month, year;

        public Person(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            people.add(new Person(name, day, month, year));
        }

        // 나이 비교: 가장 오래된 생일 -> 나이 많음
        people.sort((a, b) -> {
            if (a.year != b.year) return a.year - b.year;
            if (a.month != b.month) return a.month - b.month;
            return a.day - b.day;
        });

        // 가장 어린 사람: 리스트 마지막
        // 가장 나이 많은 사람: 리스트 첫 번째
        System.out.println(people.get(people.size() - 1).name);
        System.out.println(people.get(0).name);
    }
}
