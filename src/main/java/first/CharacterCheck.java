package first;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class CharacterCheck {
//    public static void main(String[] args) {
//        ArrayList<String> arr = new ArrayList<String>();
//        arr.add("helloo");
//        arr.add("wooooooo");
//        Iterator iter = arr.iterator();
//        if (iter.hasNext()){
//            String result = charToList((String) (iter.next()));
//            System.out.println(result);
//        }
//    }
    //字符串转集合
    @Test
    public  void  charToList(){
        String s = "helloo";
        char[] charArr = s.toCharArray();
        ArrayList<Character> chars = new ArrayList<Character>();
        for (Character ch:charArr){
            chars.add(ch);
        }
        List tmpArr = new ArrayList<Character>();
        for (int i=0;i<chars.size()-5;i++){
            for (int j=i;j<=i+3;j++){
                tmpArr.add(tmpArr.get(j));
            }
            if (tmpArr.get(0)==tmpArr.get(1)&&tmpArr.get(1)==tmpArr.get(2)){
                chars.remove(i+2);
            }
            if (tmpArr.get(0)==tmpArr.get(1)&&tmpArr.get(2)==tmpArr.get(3)){
                chars.remove(i+2);
            }
            tmpArr.clear();
            System.out.println(tmpArr);
        }
        System.out.println(chars.toString());
    }
}
