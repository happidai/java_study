package first.train.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

    public static void main(String[] args) {

        String[] langs = {"Java", "C#", "Python", "PHP"};
//        langs[0] = "Java";
//        langs[1] = "C#";
//        langs[2] = "Python";
//        langs[3] = "PHP";

//for(int i = 0; i < langs.length; i++) {
//
//    System.out.println("I want to know "+
//     }

//        List<String> languages = new ArrayList<String>();
//        languages.add("Java");
//        languages.add("C#");
//        languages.add("Python");
//        languages.add("PHP");

        List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");

        for (int i = 1; i < languages.size(); i++) {
            System.out.println("I want to know " + languages.get(i));
        }

//        for(String l : languages){
//            System.out.println("I want to know "+ l);
//        }

        //список объектов произвольного типа
        List languages1 = Arrays.asList("Java", "C#", "Python", "PHP");

        for (Object l : languages1) {
            System.out.println("I want to know " + l);
        }

    }


}
