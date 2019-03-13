import java.util.*;
public class Quick{
  public static int quickselect(int []data, int k){
    int start = 0;
    int end = data.length -1;
    int index = -1;
    while(index != k){
      System.out.println(Arrays.toString(data));
      index = partition(data,start,end);
      System.out.println(index);
      if(index > k){
        end = index -1;
      }
      if(index < k){
        start = index;
      }

    }
    System.out.println(Arrays.toString(data));
    return data[index];

  }
  public static int partition (int [] data, int start, int end){
    Random random = new Random();
    int index = Math.abs(random.nextInt()) % (end - start +1) + start;
    int value = data[index];
    int placeholder =0;
    int beg = start;
    System.out.println(index);
    data[index] = data[start];
    data[start] = value;
    start += 1;
    while (start < end){
      //System.out.println(start);
      if (data[start] < value){
        start +=1;
      }
      if (data[start] > value){
        placeholder = data[end];
        data[end] = data[start];
        data[start] = placeholder;
        end -=1;
      }
    }
System.out.println(start);
    if(data[start] < value){
      data[beg] = data[start];
      data[start] = value;
      System.out.println(Arrays.toString(data));
      return start;
    }
    if(data[start] > value){
      data[beg] = data[start -1];
      data[start-1] = value;
      System.out.println(Arrays.toString(data));
      return start -1;
    }
    return start;
  }
  public static void main(String[] args) {
    int[]ary = { 2, 10, 15, 23, 0,  5};
    System.out.println(quickselect(ary,4));
  }

}
