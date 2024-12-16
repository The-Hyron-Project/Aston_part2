package com.example;

import com.example.MyArrayList.ArrayList_IliaBulatov;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
  public static void main(String[] args) {
    //    создаём компаратор для сортировки по возрастанию
    Comparator asc = Comparator.naturalOrder();
    //    создаём компаратор для сортировки по убыванию
    Comparator desc = Comparator.reverseOrder();

    //    инициализируем аррейлист
    ArrayList_IliaBulatov<Number> arrayListIliaBulatov = new ArrayList_IliaBulatov<>();
    //    заполняем аррейлист
    arrayListIliaBulatov.add(55);
    arrayListIliaBulatov.add(98);
    arrayListIliaBulatov.add(33);
    System.out.println("--------------------------------------");
    //    Проверяем был ли аррейлист отсортирован (нет т.е. false)
    System.out.println(arrayListIliaBulatov.isSorted());
    System.out.println("--------------------------------------");
    //    получаем позиции аррейлиста по индексу
    for(int i = 0;arrayListIliaBulatov.size()>i;i++){
      System.out.println(arrayListIliaBulatov.get(i));
    }
    System.out.println("------------------Отсортировано по возрастанию--------------------");
    //    Сортируем аррейлист по возрастанию
    arrayListIliaBulatov.quickSort(asc);
    //    получаем позиции аррейлиста по индексу
    for(int i = 0;arrayListIliaBulatov.size()>i;i++){
      System.out.println(arrayListIliaBulatov.get(i));
    }
    System.out.println("------------------Отсортировано по убыванию--------------------");
    //    Сортируем аррейлист по убыванию
    arrayListIliaBulatov.quickSort(desc);
    //    получаем позиции аррейлиста по индексу
    for(int i = 0;arrayListIliaBulatov.size()>i;i++){
      System.out.println(arrayListIliaBulatov.get(i));
    }
    System.out.println("--------------------------------------");
    //    Проверяем был ли аррейлист отсортирован (да т.е. true)
    System.out.println(arrayListIliaBulatov.isSorted());
    System.out.println("--------------------------------------");
    // Проверяем размер аррейлиста (3)
    System.out.println(arrayListIliaBulatov.size());
    //    дополняем аррейлист
    arrayListIliaBulatov.add(525);
    arrayListIliaBulatov.add(535);
    arrayListIliaBulatov.add(666);
    System.out.println("--------------------------------------");
    //    Проверяем был ли аррейлист отсортирован (нет т.е. false т.к. были добавлены данные)
    System.out.println(arrayListIliaBulatov.isSorted());
    System.out.println("--------------------------------------");
    // Проверяем размер аррейлиста (6 т.е. размер по умолчанию был увеличен)
    System.out.println(arrayListIliaBulatov.size());
    System.out.println("--------------------------------------");
    //    заменяем данные по индексу 2 в аррейлист
    arrayListIliaBulatov.set(2, 999);
    //    получаем позиции аррейлиста по индексу
    for(int i = 0;arrayListIliaBulatov.size()>i;i++){
      System.out.println(arrayListIliaBulatov.get(i));
    }
    System.out.println("--------------------------------------");
    //    удаляем позицию аррейлиста по индексу
    arrayListIliaBulatov.remove(2);
    //    получаем позиции аррейлиста по индексу
    for(int i = 0;arrayListIliaBulatov.size()>i;i++){
      System.out.println(arrayListIliaBulatov.get(i));
    }
    System.out.println("--------------------------------------");
    //    добавляем данные по индексу 2 в аррейлист
    arrayListIliaBulatov.add(2, 999);
    for(int i = 0;arrayListIliaBulatov.size()>i;i++){
      System.out.println(arrayListIliaBulatov.get(i));
    }
    System.out.println("--------------------------------------");
    // Проверяем размер аррейлиста (6)
    System.out.println(arrayListIliaBulatov.size());
    System.out.println("--------------------------------------");
    // Добавляем аррейлист
    ArrayList<Integer> listToAdd = new ArrayList<>();
    listToAdd.add(1111);
    listToAdd.add(2222);
    arrayListIliaBulatov.addAll(listToAdd);
    for(int i = 0;arrayListIliaBulatov.size()>i;i++){
      System.out.println(arrayListIliaBulatov.get(i));
    }
    System.out.println("--------------------------------------");
    // Обрезаем аррейлист до 3
    arrayListIliaBulatov.split(3);
    for(int i = 0;arrayListIliaBulatov.size()>i;i++){
      System.out.println(arrayListIliaBulatov.get(i));
    }
    System.out.println("--------------------------------------");
    // Очищаем аррейлист
    arrayListIliaBulatov.clear();
    // Проверяем размер аррейлиста (0)
    System.out.println(arrayListIliaBulatov.size());
    System.out.println("--------------------------------------");
    // Создаём аррейлист с длинной 15
    ArrayList_IliaBulatov<Number> arrayListIliaBulatov2 = new ArrayList_IliaBulatov<>(15);
    System.out.println("--------------------------------------");
    // Создаём arraylist для добавления
    ArrayList<String> listToAdd2 = new ArrayList<>();
    listToAdd2.add("Яблоко");
    listToAdd2.add("Груша");
    listToAdd2.add("Апельсин");
    // Передаём arraylist в конструктор
    ArrayList_IliaBulatov<String> arrayListIliaBulatovString = new ArrayList_IliaBulatov<>(listToAdd2);
    //    получаем позиции аррейлиста по индексу
    for(int i = 0;arrayListIliaBulatovString.size()>i;i++){
      System.out.println(arrayListIliaBulatovString.get(i));
    }

  }
}
