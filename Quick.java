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
    //System.out.println(index);
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
//System.out.println(start);
    if(data[start] < value){
      data[beg] = data[start];
      data[start] = value;
      //System.out.println(Arrays.toString(data));
      return start;
    }
    if(data[start] > value){
      data[beg] = data[start -1];
      data[start-1] = value;
      //System.out.println(Arrays.toString(data));
      return start -1;
    }
    return start;
  }
  public static void quicksort(int[] data){
    quicksortH(data,0,data.length-1);
  }
  private static void quicksortH(int []data, int lo, int hi){
    if(lo >= hi){
      return;
    }
      int pivot = partition(data,lo,hi);
      quicksortH(data,lo,pivot-1);
      quicksortH(data,pivot +1, hi);
    }

  public static void main(String[] args) {
    //Random random = new Random();
    int[]ary ={90, 15, 53, 81, 27, 88, 94, 15};//, 19 41, 4, 41, 71, 0, 67, 40, 81, 44, 11, 85};
    //for(int i = 0; i <20; i++){
    //  ary[i] = Math.abs(random.nextInt()) % 100;
    //}
    //System.out.println(Arrays.toString(ary));
    System.out.println(partition(ary,0,ary.length-1));
    //System.out.println(Arrays.toString(ary));
  }

}
