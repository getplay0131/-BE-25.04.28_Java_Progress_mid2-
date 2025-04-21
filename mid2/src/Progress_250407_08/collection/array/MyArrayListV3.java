package Progress_250407_08.collection.array;

import java.util.Arrays;

 public class MyArrayListV3 {
     private static final int DEFAULT_CAPACITY = 5;

     private Object[] elementData;
     private int size = 0;

     public MyArrayListV3() {
         elementData = new Object[DEFAULT_CAPACITY];
     }

     public MyArrayListV3(int initialCapacity){
         elementData  = new Object[initialCapacity];
     }

     public int getSize() {
         return size;
     }

     public void add(Object e){
         if (size == elementData.length) {
             grow();
         }

         elementData[size] = e;
         size++;
     }

     public void add(Object e, int index){
         if (size == elementData.length) {
             grow();
         }
         shiftRightFrom(index);
         elementData[index] = e;
         size++;
     }

     private void grow() {
         int oldCapacity = elementData.length;
         int newCapacity = oldCapacity * 2;
         elementData = Arrays.copyOf(elementData,newCapacity);

     }

     public Object remove(int index){
         Object object = get(index);
         shiftLeftFrom(index);

         size--;
         elementData[size] = null;
         return object;
     }

     public Object get(int idx){
         return elementData[idx];
     }

     public Object set(int index, Object element){
         Object oldValue = get(index);
         elementData[index] = element;
         return oldValue;
     }

     public int indexOf(Object o){
         for (int i = 0; i < size; i++){
             if (o.equals(elementData[i])){
                 return i;
             }
         }
         return  -1;
     }

     public void shiftRightFrom(int index){
         for (int i = size; i > index ; i--) {
             elementData[i] = elementData[i-1];
         }
     }


     public void shiftLeftFrom(int index){
         for (int i = index; i < size ; i++) {
             elementData[i] = elementData[i+1];
         }
     }
     @Override
     public String toString() {
         return Arrays.toString(Arrays.copyOf(elementData, size)) + " size=" +
                 size + ", capacity=" + elementData.length;
     }
 }
