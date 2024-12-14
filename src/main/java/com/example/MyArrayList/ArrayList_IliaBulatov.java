package com.example.MyArrayList;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class ArrayList_IliaBulatov<E> implements IntensiveList<E> {
  E[] elementData;
  private static final int DEFAULT_CAPACITY = 5;
  private int size;
  private int lastInsertedPosition = -1;
  E[] elementTemporalCopy;
  boolean isSorted = false;

  public ArrayList_IliaBulatov(){
    this.elementData = (E[]) new Object[DEFAULT_CAPACITY];
    size = DEFAULT_CAPACITY;
  }

  public ArrayList_IliaBulatov(Collection<? extends E> c){
    this.elementData = (E[]) new Object[c.size()];
    this.size = c.size();
    for (E position : c) {
      this.add(position);
    }
  }

  public ArrayList_IliaBulatov(int sizeForCreation){
    if(sizeForCreation >=0){
      this.elementData = (E[]) new Object[sizeForCreation];
      this.size = sizeForCreation;
    }else{
      System.out.println("Указан некорректный размер массива.");
    }
  }

  @Override
  public int size() {
    if(lastInsertedPosition<0){
      return 0;
    }else{
      return lastInsertedPosition;
    }
  }

  @Override
  public void add(E e) {
    lastInsertedPosition++;
    if(lastInsertedPosition>size-1){
      increaseSize();
    }
    isSorted = false;
    elementData[lastInsertedPosition]= e;
  }

  @Override
  public void add(int i, E e) {
    if(i>lastInsertedPosition){
      System.out.println("Указан некорректный индекс элемента.");
    }else{
      System.arraycopy(elementData, i, elementData, i+1, lastInsertedPosition+1);
      lastInsertedPosition=lastInsertedPosition+1;
      elementData[i]=e;
    }
  }

  public void addAll(Collection<? extends E> c){
    isSorted = false;
    for (E position : c) {
      this.add(position);
    }
  }

  @Override
  public E get(int i) {
    if(i>lastInsertedPosition){
      System.out.println("Указан некорректный индекс элемента.");
      return null;
    }else{
      return elementData[i];
    }
  }

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

  @Override
  public void clear() {
    this.elementData = (E[]) new Object[DEFAULT_CAPACITY];
    lastInsertedPosition = -1;
  }

  @Override
  public void quickSort(Comparator<E> comparator) {
    if(lastInsertedPosition>0){
      int firstPart;
      int secondPart;
      if(lastInsertedPosition==1){
        firstPart=1;
        secondPart=1;
      }
      else if(lastInsertedPosition % 2 == 0){
        firstPart = lastInsertedPosition/2;
        secondPart = lastInsertedPosition/2;
      }else{
        firstPart = lastInsertedPosition/2;
        secondPart = lastInsertedPosition/2+1;
      }
      E[] leftElementData = (E[]) new Object[firstPart];
      E[] rightElementData = (E[]) new Object[secondPart];
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
      System.arraycopy(elementData, 0, quickSortRecircive(comparator,leftElementData, firstPart), 0, firstPart);
      System.arraycopy(elementData, secondPart, quickSortRecircive(comparator,rightElementData, secondPart), secondPart, secondPart);
    }
    isSorted = true;
  }

  private E[] quickSortRecircive(Comparator<E> comparator, E[] arr, int size){
    if(size>1){
      int firstPart;
      int secondPart;
      if(size==1){
        firstPart=1;
        secondPart=1;
      }
      else if(size % 2 == 0){
        firstPart = size/2;
        secondPart = size/2;
      }else{
        firstPart = size/2;
        secondPart = size/2+1;
      }
      E[] finalArr = (E[]) new Object[size];
      E[] leftElementData = (E[]) new Object[firstPart];
      E[] rightElementData = (E[]) new Object[secondPart];
      int countL=0;
      int countR=0;
      E middleElement = arr[size/2];
      for(int i = 0; i<=size;i++){
        if(i==size/2)continue;
        if (comparator.compare(arr[i], middleElement)>0){
          leftElementData[countL]=arr[i];
          countL++;
        }else{
          rightElementData[countR]=arr[i];
          countR++;
        }
      }
      System.arraycopy(finalArr, 0, quickSortRecircive(comparator,leftElementData, firstPart), 0, firstPart);
      System.arraycopy(finalArr, secondPart, quickSortRecircive(comparator,rightElementData, secondPart), secondPart, secondPart);
    }
    return arr;
  }


  @Override
  public boolean isSorted() {
    return isSorted;
  }

  @Override
  public void split(int i) {
    if(i>lastInsertedPosition){
      System.out.println("Указан некорректный индекс элемента.");
    }else{
      System.arraycopy(elementData, 0, elementData, 0, i);
      lastInsertedPosition=i;
    }
  }

  private void increaseSize(){
    int newSize = size + size/2;
    elementTemporalCopy = (E[]) new Object[newSize];
    System.arraycopy(elementData, 0, elementTemporalCopy, 0, size);
    elementData = (E[]) new Object[newSize];
    System.arraycopy(elementTemporalCopy, 0, elementData, 0, size);
    size = newSize;
  }
}
