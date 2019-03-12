import java.util.*;
public class Quick{
  public static int quickselect(int []data, int k){
    int index = partition(data,0,data.length-1);
    int start = 0;
    int end = data.length -1;
    while(index != k){
      if(index > k){
        index = partition(data,index, end);

      }
      if(index < k){
        index = partition(data,start,index -1);
      }

    }
    return data[index];

  }
  public static int partition (int [] data, int start, int end){
    Random random = new Random();
    int index = Math.abs(random.nextInt()) % (end - start + 1);
    int value = data[index];
    int placeholder =0;
    int beg = start;
    data[index] = data[start];
    data[start] = value;
    start += 1;
    while (start < end){
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
    if(data[start] < value){
      data[beg] = data[start];
      data[start] = value;
      return start;
    }
    if(data[start] > value){
      data[beg] = data[start -1];
      data[start-1] = value;
      return start -1;
    }
    return start;
  }
  public static void main(String[] args) {
    int[]ary = { 2, 10, 15, 23, 0,  5};
    System.out.println(quickselect(ary,3));
  }

}
