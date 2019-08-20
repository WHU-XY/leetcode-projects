package InetAddress;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/8 15:18
 */
public class Book {
    private String name;
    private int price;

    public Book(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        final Book book = (Book) obj;

        if (this == book){
            return true;
        }else {
            return (this.name.equals(book.name) && this.price == book.price);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (name == null ? 0 : name.hashCode());
        return hash;
    }
}
