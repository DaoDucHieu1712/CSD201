public class Main {

    public static void main(String[] args) {
      //bai trong slide example 1
//        int [][] b = {
//     {  0,   7,   9, 99, 99, 14},
//      {  7,   0, 10, 15, 99, 99},
//      {  9, 10,   0, 11, 99,   2},
//      {99, 15, 11,   0,   6, 99},
//      {99, 99, 99,   6,   0,   9},
//      {14, 99,   2, 99,   9,   0}
//       };
       //bai trong slide example 2
//        int [][] b = {
//     {  0,   2,   5, 1, 99, 99},
//      {  2,   0, 3, 2, 99, 99},
//      {  5, 3,   0, 3, 1,   5},
//      {1, 2, 3,   0,   1, 99},
//      {99, 99, 1,   1,   0,   2},
//      {99, 99,   5, 99,   2,   0}
//       }; 
      //bai 4
      int [][] b = {
     {  0,   1,   99, 9, 99},
      {  99,   0, 2, 5, 10},
      {  99, 99,   0, 99, 3},
      {99, 99, 4,   0,   8},
      {6, 99, 99,   99,   0}
       };
      Graph g = new Graph();
      g.setData(b);
      g.dispAdj();
      System.out.println();
      System.out.println("1. Test Dijkstra's shortest path algorithm:");
      g.dijkstra(0, 4);
      System.out.println();
      
    }
    
}
