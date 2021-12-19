public class Main {

    public static void main(String[] args) {
        //vi du 1
//     int [][] b = {
//         {0,1,2,1}, 
//         {1,0,1,0}, 
//         {2,1,0,1}, 
//         {1,0,1,0} 
//      };
     //vi du 2
  int[][] b=   {{0,1,0,0,1},
          {1,0,1,1,1},
          {0,1,0,1,0},
          {0,1,1,0,2},
          {1,1,0,2,0}};
     Graph g=new Graph();
     g.setData(b);
     System.out.println("1. Test Euler's cycle:");
     g.eulerCycle(0);
     System.out.println();

    }
    
}
