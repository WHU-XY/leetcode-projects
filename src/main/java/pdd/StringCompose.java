package pdd;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StringCompose {
    public static void main(String[] args) {
        int[] nums = {50,21,23,2,9};
        List<String> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            list.add(String.valueOf(nums[i]));
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if ((o1+o2).compareTo((o2+o1)) > 0){
                    return 1;
                }else {
                    return -1;
                }
            }
        });
        if (list.get(list.size() -1) == "0"){
            System.out.println(0);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.size()-1; i >= 0; i--){
            sb.append(list.get(i));
        }
        System.out.println(sb.toString());
    }

}
