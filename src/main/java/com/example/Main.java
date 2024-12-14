package com.example;

import com.example.MyArrayList.ArrayList_IliaBulatov;
import java.util.Comparator;

public class Main {
  public static void main(String[] args) {
//    LocalComparator localComparator = new LocalComparator<>();
    Comparator asc = Comparator.naturalOrder();
    Comparator desc = Comparator.reverseOrder();
    ArrayList_IliaBulatov<Integer> arrayListIliaBulatov = new ArrayList_IliaBulatov<>();
    arrayListIliaBulatov.add(5);
    arrayListIliaBulatov.add(4);
    arrayListIliaBulatov.add(3);
//    arrayListIliaBulatov.add(2);
//    arrayListIliaBulatov.add(1);
//    arrayListIliaBulatov.add(0);
    for(int i = 0;arrayListIliaBulatov.size()>=i;i++){
      System.out.println(arrayListIliaBulatov.get(i));
    }
    System.out.println("--------------------------------------");
    arrayListIliaBulatov.quickSort(asc);
    for(int i = 0;arrayListIliaBulatov.size()>=i;i++){
      System.out.println(arrayListIliaBulatov.get(i));
    }
  }
}

//class LocalComparator <E extends Comparable<E>> implements Comparator<E> {
//  @Override
//  public int compare(E o1, E o2) {
//    return o1.compareTo(o2);
//  }
//}
