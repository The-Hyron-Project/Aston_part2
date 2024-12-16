package com.example;

import com.example.MyArrayList.ArrayList_IliaBulatov;
import java.util.Comparator;

public class Main {
  public static void main(String[] args) {
    Comparator asc = Comparator.naturalOrder();
    Comparator desc = Comparator.reverseOrder();
//    ArrayList_IliaBulatov<Integer> arrayListIliaBulatov = new ArrayList_IliaBulatov<>();
//    arrayListIliaBulatov.add(5);
//    arrayListIliaBulatov.add(4);
//    arrayListIliaBulatov.add(3);
//    arrayListIliaBulatov.add(7);
//    arrayListIliaBulatov.add(6);
//    arrayListIliaBulatov.add(2);
//    arrayListIliaBulatov.add(66);
//    arrayListIliaBulatov.add(22);
//    arrayListIliaBulatov.add(76);
//    arrayListIliaBulatov.add(102);
//    arrayListIliaBulatov.add(1);
//    arrayListIliaBulatov.add(8);
//    arrayListIliaBulatov.add(0);

    ArrayList_IliaBulatov<String> arrayListIliaBulatov = new ArrayList_IliaBulatov<>();
    arrayListIliaBulatov.add("Яблоко");
    arrayListIliaBulatov.add("Апельсин");
    arrayListIliaBulatov.add("Мандарин");

    for(int i = 0;arrayListIliaBulatov.size()>i;i++){
      System.out.println(arrayListIliaBulatov.get(i));
    }
    System.out.println("--------------------------------------");
    arrayListIliaBulatov.quickSort(asc);
//    arrayListIliaBulatov.quickSort(desc);
    System.out.println("--------------------------------------");
    for(int i = 0;arrayListIliaBulatov.size()>i;i++){
      System.out.println(arrayListIliaBulatov.get(i));
    }
  }
}
