package com;

/*****
 *  @author Monster Xu
 *  @date 2020/7/23
 *****/
public class asdasd {

    public static void main(String[] args) {

//        String str = "abcdefghicjklaaab bbaaa mnopqrstuvwxyz";
//        String str = "求一句话中第一次重复的那个字";
//
//        char c = findString(str);
//
//        if (c==32){
//            System.out.println("没有重复的字符,或者重复的字符是 空格");
//        }else {
//
//            System.out.println("第一次重复的字符是："+c);
//        }

        String str = "5349b4ddd2781d08c09890f3";
        System.out.println(str.length());
    }

    private static char findString(String str) {
        //获取字符串的长度
        int length = str.length();
        //分割字符串，得到一个数组
        String[] array = str.split("");
        //定一个 flag 如果是真就跳出循环的作用
        boolean flag = false;

        //循环遍历字符数组
        for (int i = 0; i < length - 1; i++) {

            for (int j = 0; j < i; j++) {

                //如果两次遍历的字符是一样的，那就说明这两个字符相等
                if (array[i].equals(array[j])) {
                    //打印输出
                    //System.out.println(array[i]);
                    return array[i].charAt(0);
                }
            }
        }
        return ' ';
    }
}
