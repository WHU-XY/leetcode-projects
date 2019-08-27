package hk;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/24 17:29
 */
public class A {
    public String show(D d){return ("AD");}
    public String show(A a){return ("AA");}
}
class B extends A{
    public String show(B b){return ("BB");}
    public String show(A a){return ("BA");}
}
class C extends B{}
class D extends B{}
class Test{
    public static void main(String[] args) {
        String s = new String("abc");
        String t = new String("abc");
        System.out.println(s.equals(t));
        double d = 1234.5;
        DecimalFormat df = new DecimalFormat("#00.00#");
        System.out.print(df.format(d));
    }
    public static int fun(){
        int i = 10;
        try {
            i = i/0;
            return --i;
        }catch (Exception e){
            --i;
            return i--;
        }finally {
            --i;
            return i--;
        }
    }

}
class Animal{
    int x =1;
    public Animal(){
        System.out.println("anima");
    }
}
class dog extends Animal{
    int x =2;
    public dog(){
        System.out.println("dog");
    }
}
