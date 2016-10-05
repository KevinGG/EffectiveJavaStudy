package my.question.arrays;

import java.util.Arrays;

public class RainWaterManagement {
  public int trappedWater(int[][] m) {
    if (m == null || m.length == 0 || m[0].length == 0)
      return 0;
    int row = m.length;
    int col = m[0].length;
    int[][] watered = new int[row][col];
    for (int[] wateredRow : watered) {
      Arrays.fill(wateredRow, Integer.MAX_VALUE);
    }
    // for perimeter, no water could be trapped
    for (int i = 0; i < col; ++i) {
      watered[0][i] = m[0][i];
      watered[row - 1][i] = m[row - 1][i];
    }
    for (int i = 1; i < row - 1; ++i) {
      watered[i][0] = m[i][0];
      watered[i][col - 1] = m[i][col - 1];
    }
    for (int i = 1; i < col - 1; ++i) {
      waterDown(0, i, Direction.DOWN, row, col, watered, m);
      waterDown(row-1, i, Direction.UP, row, col, watered, m);
    }
    for(int i = 1; i < row - 1; ++i){
      waterDown(i, 0, Direction.RIGHT, row, col, watered, m);
      waterDown(i, col-1, Direction.LEFT, row, col, watered, m);
    }
    int water = 0;
    for(int i = 1; i < row - 1; ++i){
      for(int j = 1; j < col -1 ; ++j){
        water += watered[i][j] - m[i][j];
      }
    }
    return water;
  }

  private void waterDown(int i, int j, Direction direction, int row, int col, int[][] watered,
      int[][] m) {
    int ii = i, jj = j;
    switch (direction) {
      case RIGHT:
        ++jj;
        break;
      case LEFT:
        --jj;
        break;
      case DOWN:
        ++ii;
        break;
      case UP:
        --ii;
        break;
      default:
        return;
    }
    if (jj <= 0 || jj >= col - 1 || ii <= 0 || ii >= row - 1)
      return;
    if (watered[i][j] < watered[ii][jj]) {
      watered[ii][jj] = watered[i][j] < m[i][j] ? m[i][j] : watered[i][j];
      Direction oppo = Direction.oppo(direction);
      for (Direction d : Direction.values()) {
        if (d == oppo)
          continue;
        waterDown(ii, jj, d, row, col, watered, m);
      }
    }
  }


  private static enum Direction {
    RIGHT, LEFT, DOWN, UP;

    static Direction oppo(Direction d) {
      switch (d) {
        case RIGHT:
          return LEFT;
        case LEFT:
          return RIGHT;
        case DOWN:
          return UP;
        case UP:
          return DOWN;
        default:
          return null;
      }
    }
  }
  
  public static void main(String[] argv){
    int result = new RainWaterManagement().trappedWater(new int[][]{{1,1,1},{1,0,1},{1,1,1}});
    System.out.println(result);
  }
}
