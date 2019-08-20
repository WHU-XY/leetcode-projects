package InetAddress;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/8 15:24
 */
public class DistinctWithUserObjects {

    public static void main(String[] args) {
        List<Book> list = new ArrayList<>();
        list.add(new Book("Core Java", 200));
        list.add(new Book("Core Java", 200));
        list.add(new Book("Learning Freemarker", 150));
        list.add(new Book("Spring MVC", 300));
        list.add(new Book("Spring MVC", 300));

        long l = list.stream().distinct().count();
        System.out.println("No. of distinct books: "+l);
        list.stream().distinct().forEach(book -> System.out.println(book.getName()+","+book.getPrice()));

        System.out.println(list.stream().collect(Collectors.averagingDouble(Book::getPrice)));
    }
}
