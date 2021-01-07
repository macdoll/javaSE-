package com.zxg.collection.entity;


/**
 * @param
 * @author zhu_xingguo
 * @description
 * @time 2021/1/7 8:40
 * @return
 */
public class Book {
    private String name;
    private Integer price;

    public Book(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
    @Override
    public int hashCode(){
        final int prime=31;
        int result=1;
        result = prime*result+((name==null)?0:name.hashCode());
        result = prime*result+((price==null)?0:price.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj){
        if (this==obj){
            return true;
        }
        if (obj==null){
            return false;
        }
        if (!(obj.getClass()==this.getClass())){
            return false;
        }
        Book other = (Book)obj;
        if (this.price==null){
            if (other.price!=null){
                return false;
            }
        }else if (!(this.price.equals(other.price))){
            return false;
        }
        if (this.name==null){
            if (other.name!=null){
                return false;
            }
        }else if (!(this.name.equals(other.name))){
            return false;
        }
        return true;
    }
}
