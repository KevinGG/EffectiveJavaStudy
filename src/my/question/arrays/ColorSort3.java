package my.question.arrays;

import java.util.Arrays;

public class ColorSort3 {
  public void sort(int[] colors) {
    if (colors == null || colors.length < 3)
      throw new RuntimeException("Invalid input");
    int idx0 = 0;
    while (colors[idx0] == 0)
      ++idx0;
    int idx2 = colors.length - 1;
    while (colors[idx2] == 2)
      --idx2;
    int i = idx0;
    while (i < idx2) {
      if(colors[i] == 1){
        ++i;
        continue;
      }
      if(colors[i] == 0){
        colors[i] = colors[idx0];
        colors[idx0] = 0;
        ++idx0;
      }else{
        colors[i] = colors[idx2];
        colors[idx2] = 2;
        --idx2;
      }
    } 
  }

  public static void main(String[] argv) {
    int[] colors = new int[] {2, 2, 2, 2, 1, 0, 1, 0, 1, 1, 1};
    new ColorSort3().sort(colors);
    System.out.println(Arrays.toString(colors));
  }
}
