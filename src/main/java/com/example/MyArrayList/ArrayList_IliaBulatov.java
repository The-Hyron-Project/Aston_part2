package com.example.MyArrayList;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * Класс аррейлиста ArrayList_IliaBulatov для интенсива Java Aston.
 * @autor Булатов Илья, поток 94.
 * @version 1.0
 */
public class ArrayList_IliaBulatov<E> implements IntensiveList<E> {
  /** Поле массива обобщённого типа. */
  E[] elementData;
  /** Поле размера массива по умолчанию.*/
  private static final int DEFAULT_CAPACITY = 5;
  /** Поле для указания размера массива вручную.*/
  private int size;
  /**
   * Поле для отслеживания индекса последней заполненной позиции.
   * Отсчёт от 0.
   * Значение -1 означает, что аррейлист не заполнен.
   */
  private int lastInsertedPosition = -1;
  /** Поле для создания копий массива.*/
  E[] elementTemporalCopy;
  /** Поле для фиксации проведения сортировки.*/
  boolean isSorted = false;

  /** Конструктор по умолчанию.*/
  public ArrayList_IliaBulatov(){
    this.elementData = (E[]) new Object[DEFAULT_CAPACITY];
    size = DEFAULT_CAPACITY;
  }

  /**
   * Конструктор, принимающий на вход arraylist.
   * @param c - arraylist с данными для переноса
   */
  public ArrayList_IliaBulatov(Collection<? extends E> c){
    this.elementData = (E[]) new Object[c.size()];
    this.size = c.size();
    for (E position : c) {
      this.add(position);
    }
  }

  /**
   * Конструктор, принимающий на вход размер массива.
   * @param sizeForCreation - значение типа int
   */
  public ArrayList_IliaBulatov(int sizeForCreation){
    if(sizeForCreation >=0){
      this.elementData = (E[]) new Object[sizeForCreation];
      this.size = sizeForCreation;
    }else{
      System.out.println("Указан некорректный размер массива.");
    }
  }

  /** Метод, возвращающий размер аррейлиста.
   * @return - значение типа int
   */
  @Override
  public int size() {
    if(lastInsertedPosition<0){
      return 0;
    }else{
      return lastInsertedPosition+1;
    }
  }

  /**
   * Метод, позволяющий добавить в аррейлист значение типа, указанного при инициализации.
   * @param e - данные для добавления
   */
  @Override
  public void add(E e) {
    lastInsertedPosition++;
    if(lastInsertedPosition>size-1){
      increaseSize();
    }
    isSorted = false;
    elementData[lastInsertedPosition]= e;
  }

  /**
   * Метод, позволяющий добавить в аррейлист значение типа, указанного при инициализации.
   * @param i - индекс добавляемой позиции
   * @param e - данные для добавления
   */
  @Override
  public void add(int i, E e) {
    lastInsertedPosition++;
    if(i>lastInsertedPosition){
      System.out.println("Указан некорректный индекс элемента.");
    } else if(lastInsertedPosition>size-1){
      increaseSize();
    } else{
      System.arraycopy(elementData, i, elementData, i+1, lastInsertedPosition-i);
      elementData[i]=e;
    }
  }

  /**
   * Метод, принимающий на вход arraylist для внесения.
   * @param c - arraylist с данными для переноса
   */
  public void addAll(Collection<? extends E> c){
    isSorted = false;
    for (E position : c) {
      this.add(position);
    }
  }

  /**
   * Метод, позволяющий получить данные из аррейлиста по индексу.
   * @param i - индекс запрашиваемой позиции
   * @return - значение типа, указанного при инициализации аррейлиста.
   */
  @Override
  public E get(int i) {
    if(i>lastInsertedPosition){
      System.out.println("Указан некорректный индекс элемента.");
      return null;
    }else{
      return elementData[i];
    }
  }

  /**
   * Метод, позволяющий заменить в аррейлисте значение типа, указанного при инициализации,
   * на новое, хранимое по определённому индексу.
   * @param i - индекс заменяемой позиции
   * @param e - новые данные для добавления
   * @return - значение типа, указанного при инициализации аррейлиста.
   */
  @Override
  public E set(int i, E e) {
    if(i>lastInsertedPosition){
      System.out.println("Указан некорректный индекс элемента.");
      return null;
    }else{
      elementData[i]=e;
      return e;
    }
  }

  /**
   * Метод, позволяющий удалить данные из аррейлиста по индексу.
   * @param i - индекс удаляемой позиции
   * @return - значение типа, указанного при инициализации аррейлиста (удаляемая позиция).
   */
  @Override
  public E remove(int i) {
    E removedElement;
    if(i>lastInsertedPosition){
      System.out.println("Указан некорректный индекс элемента.");
      return null;
    }else{
      removedElement = elementData[i];
      System.arraycopy(elementData, i + 1, elementData, i, lastInsertedPosition-i);
      elementData[lastInsertedPosition]=null;
      lastInsertedPosition=lastInsertedPosition-1;
      return removedElement;
    }
  }

  /**
   * Метод, позволяющий удалить данные из аррейлиста и вернуть его размер по умолчанию.
   */
  @Override
  public void clear() {
    this.elementData = (E[]) new Object[DEFAULT_CAPACITY];
    lastInsertedPosition = -1;
  }

  /**
   * Метод, позволяющий отсортировать данные в аррейлисте согласно переданному компаратору.
   * Запускает механизм сортировки.
   * @param comparator - передаваемый компаратор.
   */
  @Override
  public void quickSort(Comparator<E> comparator) {
    if(lastInsertedPosition>0){
      E[] leftElementData = (E[]) new Object[lastInsertedPosition+1];
      E[] rightElementData = (E[]) new Object[lastInsertedPosition+1];
      E[] elementTemporalCopy0 = (E[]) new Object[size];
      int countL=0;
      int countR=0;
      E middleElement = elementData[lastInsertedPosition/2];
      for(int i = 0; i<=lastInsertedPosition;i++){
        if(i==lastInsertedPosition/2)continue;
        if (comparator.compare(elementData[i], middleElement)<0){
          leftElementData[countL]=elementData[i];
          countL++;
        }else{
          rightElementData[countR]=elementData[i];
          countR++;
        }
      }
      if(countL>0){
        System.arraycopy(quickSortRecurcive(comparator,leftElementData, countL-1), 0, elementTemporalCopy0, 0, countL);
      }
        elementTemporalCopy0[countL]=middleElement;
      if(countR>0){
        System.arraycopy(quickSortRecurcive(comparator,rightElementData, countR-1), 0, elementTemporalCopy0, countL+1, countR);
      }
      elementData=elementTemporalCopy0;
    }
    isSorted = true;
  }

  /**
   * Метод, позволяющий отсортировать данные в аррейлисте согласно переданному компаратору.
   * Приватный метод, вызывается методом quickSort, требуется для выполнения сортировки рекурсивно.
   * @param comparator - передаваемый компаратор.
   * @param arr - передаваемый массив для сортировки.
   * @param size - размер передаваемого массива.
   * @return - отсортированный масссив.
   */
  private E[] quickSortRecurcive(Comparator<E> comparator, E[] arr, int size){
    if(size>0){
      E[] leftElementData = (E[]) new Object[size+1];
      E[] rightElementData = (E[]) new Object[size+1];
      E[] elementTemporalCopy0 = (E[]) new Object[size+1];
      int countL=0;
      int countR=0;
      E middleElement = arr[size/2];
      for(int i = 0; i<=size;i++){
        if(i==size/2)continue;
        if (comparator.compare(arr[i], middleElement)<0){
          leftElementData[countL]=arr[i];
          countL++;
        }else{
          rightElementData[countR]=arr[i];
          countR++;
        }
      }
      if(countL>0){
        System.arraycopy(quickSortRecurcive(comparator,leftElementData, countL-1), 0, elementTemporalCopy0, 0, countL);
      }
      elementTemporalCopy0[countL]=middleElement;
      if(countR>0){
        System.arraycopy(quickSortRecurcive(comparator,rightElementData, countR-1), 0, elementTemporalCopy0, countL+1, countR);
      }
      return elementTemporalCopy0;
    }
    return arr;
  }

  /**
   * Метод, позволяющий узнать был ли аррейлист отсортирован.
   * @return - значение булевого типа.
   */
  @Override
  public boolean isSorted() {
    return isSorted;
  }

  /**
   * Метод, позволяющий сократить размер аррейлиста с потерей данных, хранимых в позициях с индексом выше переданного.
   */
  @Override
  public void split(int i) {
    if(i>lastInsertedPosition){
      System.out.println("Указан некорректный индекс элемента.");
    }else{
      System.arraycopy(elementData, 0, elementData, 0, i);
      lastInsertedPosition=i;
    }
  }

  /**
   * Метод, позволяющий увеличить размер аррейлиста в 1,5 раза.
   */
  private void increaseSize(){
    int newSize = size + size/2;
    elementTemporalCopy = (E[]) new Object[newSize];
    System.arraycopy(elementData, 0, elementTemporalCopy, 0, size);
    elementData = (E[]) new Object[newSize];
    System.arraycopy(elementTemporalCopy, 0, elementData, 0, size);
    size = newSize;
  }

}
