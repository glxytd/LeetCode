package com.String;

public class ReverseWords {
    public static String reverseWords(String s) {
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=array.length-1;i>=0;i--){

            if(array[i].length()==0){
                continue;
            }
            System.out.println(i+":"+array[i]+" "+array[i].length());
            sb.append(array[i]).append(" ");
        }

        return sb.toString().trim();
    }

    public static String reverseWords2(String s) {
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<array.length;i++){
            //System.out.println(i+":"+array[i]+" "+array[i].length());
            char[] chars = array[i].toCharArray();
            for(int j=chars.length-1;j>=0;j--){
                sb.append(chars[j]);
            }
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords2("a good example"));
    }
}
