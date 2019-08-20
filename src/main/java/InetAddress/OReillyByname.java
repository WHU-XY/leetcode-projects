package InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/8 11:37
 */
public class OReillyByname {
    public static void main(String[] args) {
        try {
            //InetAddress address = InetAddress.getByName("www.baidu.com");
            InetAddress address = InetAddress.getLocalHost();
            System.out.println(Arrays.toString(address.getAddress()));
        } catch (UnknownHostException e) {
            System.out.println("Could not find www.baidu.com");
        }
    }
}
