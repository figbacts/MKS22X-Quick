import java.util.*;
public class Quick{
  public static int quickselect(int []data, int k){
    int start = 0;
    int end = data.length -1;
    int index = -1;
    while(index != k){
      //System.out.println(Arrays.toString(data));
      index = partition(data,start,end);
      //System.out.println(index);
      if(index > k){
        end = index -1;
      }
      if(index < k){
        start = index;
      }

    }
    //System.out.println(Arrays.toString(data));
    return data[index];

  }
  public static int partition (int [] data, int start, int end){
    Random random = new Random();
    int index = Math.abs(random.nextInt()) % (end - start +1) + start;
    //int index = (start + end) /2;
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
      if (data[start] == value){
        int rand = Math.abs(random.nextInt()) % 2;
        if(rand == 0){
          start +=1;
        }
        if(rand ==1){
          placeholder = data[end];
          data[end] = data[start];
          data[start] = placeholder;
          end -=1;
        }
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
    if (hi - lo < 180){
      insertionsort(data,lo,hi);
      return;
    }
      int pivot = partition(data,lo,hi);
      quicksortH(data,lo,pivot-1);
      quicksortH(data,pivot +1, hi);
    }
    public static void insertionsort(int[] data, int lo,int hi){
      int len = hi - lo + 1;
    for (int i = 1; i<len; i++){
      int hold = data[lo + i];
      int index = i;
    while (index > 0 &&  hold <data[lo + index -1]){
      data[lo + index] = data[lo + index -1];
      index --;
    }
    data[lo + index] = hold;
    }
    }
    public static void main(String[]args){
    System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          Quick.quicksort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    }
  }


}
