public class Main {

    public static void main(String [] args) throws Exception
   {String filename;
    filename="matrix.txt";
    Graph g =new Graph();
    g.setData(filename);
    g.displayData();
    g.EulerPath();
    System.out.println();
   }
}
