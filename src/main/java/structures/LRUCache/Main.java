package structures.LRUCache;

import java.util.Scanner;

public class Main {

    private static final Scanner in = new Scanner(System.in);

    private static int getNumber(int min, int max, String txt) {
        System.out.print(txt);
        int number = in.nextInt();
        while (number < min || number > max) {
            System.out.println("Try again: ");
            number = in.nextInt();
        }
        return number;
    }

    private static int menuItem() {
        System.out.println("1 - set");
        System.out.println("2 - get");
        System.out.println("3 - size");
        System.out.println("4 - limit");
        System.out.println("5 - print");
        System.out.println("0 - exit");
        return getNumber(0, 5, "Choose: ");
    }

    public static void main(String[] args) {
        LruCacheImpl<String, Integer> cache = new LruCacheImpl<String, Integer>(3);
        int val;
        String key;
        int item;
        do {
            item = menuItem();
            switch (item) {
                case 1: {
                    System.out.print("Input key: ");
                    key = in.next();
                    System.out.print("Input val: ");
                    val = in.nextInt();
                    cache.set(key, val);
                    break;
                }
                case 2: {
                    System.out.print("Input key: ");
                    key = in.next();
                    System.out.println("Value: " + cache.get(key));
                    break;
                }
                case 3: {
                    System.out.println(cache.getSize());
                    break;
                }
                case 4: {
                    System.out.println(cache.getLimit());
                    break;
                }
                case 5: {
                    cache.print();
                    break;
                }
            }
        } while (item != 0);
        in.close();
    }
}
