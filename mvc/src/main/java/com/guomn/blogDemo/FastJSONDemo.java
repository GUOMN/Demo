package com.guomn.blogDemo;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;

public class FastJSONDemo {

    public static void main(String[] args) {
        Entity1 e1 = new Entity1();
        e1.setSss("e1");

        Entity2 e2 = new Entity2("e2", "e2");

        Entity3 e3 = new Entity3();

        System.out.println("e1 --> json : " + JSON.toJSONString(e1));
        System.out.println("e2 --> json : " + 1);
        System.out.println("e3 --> json : " + JSON.toJSONString(e3));


    }
}
class Entity1 implements Serializable {
    private String sss;

    public String getSss() {
        return sss;
    }

    public void setSss(String sss) {
        this.sss = sss;
    }
}
@Data
class Entity2 implements Serializable{
    private String sss;
    private String asd;


    public Entity2(String sss, String sadfasfasd) {
        this.sss = sss;
        this.asd = sadfasfasd;
    }

}
class Entity3 implements Serializable{
    private String sss = "e3";

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}

// 结论:1)转JSON依赖get方法
//2)解析JSON依赖set
//解析对象必须有空构造方法

//JSON.parseObject(JSON.toJSONString(e2), Entity2.class)