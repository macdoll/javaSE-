package collection.test;

import collection.entity.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @param
 * @author zhu_xingguo
 * @description
 * @time 2021/1/7 10:24
 * @return
 */
public class testBook {
    List list = new ArrayList();
    @Before
    public void init(){
        Book book1 = new Book("sanguo",55);
        Book book2 = new Book("honglou",54);
        Book book3 = new Book("xiyou",52);
        Book book4 = new Book("xiyou",52);
        list.add(book1);
        list.add(book2);
        list.add(book3);
        list.add(book4);
    }
    @Test
    public void testBookDuplicateRemove(){
        System.out.println(list);
        List newList = new ArrayList();
        for (int i=0;i<list.size();i++){
            if (!(newList.contains(list.get(i)))){
                newList.add(list.get(i));
            }
        }
        System.out.println(newList);
    }
    @Test
    public void testBookSetDuplicateRemove(){
        Set set = new HashSet();
        set.addAll(list);
        list.clear();
        list.addAll(set);
        System.out.println(list);
    }
}
