import java.util.LinkedList;
import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Part 1 findMinMax");
        LinkedList<Integer> sourceList = new LinkedList<>();
        for (int i = 0; i < 20; i++) {
            sourceList.add(i, (int) (10 + Math.random() * 10));
        }
        System.out.println("Source List : " + sourceList);

        Comparator<Integer> compareInt = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? 1 : -1;
            }
        };

        BiConsumer<Integer, Integer> minMaxIntegerConsumer = new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer min, Integer max) {
                System.out.println("min=" + min + ", max=" + max);
            }
        };

        findMinMax(sourceList.stream(), compareInt, minMaxIntegerConsumer);


        System.out.println("\nPart 2 - only even numbers");
        LinkedList<Integer> someList = new LinkedList<>();
        for (int i = 0; i < 20; i++) {
            someList.add(i, (int) (10 + Math.random() * 10));
        }
        System.out.println("Source List : " + someList);
        System.out.print("An even numbers : ");

        long amountEvenNumbers = someList.stream()
                .filter(x -> x % 2 == 0)
                .peek(s -> {
                    System.out.print(s + " ");
                })
                .count();
        System.out.println("\nNumber of even numbers : " + amountEvenNumbers);
    }

    public static <T> void findMinMax(
            Stream<T> stream,
            Comparator<T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<? extends T> list = stream.collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            list.sort(order);
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }
    }
}
