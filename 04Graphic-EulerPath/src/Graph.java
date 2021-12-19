
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;

public class Graph {
  int [][] a; int n;
  char [] v;//Vertices label
  Graph()
   {String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    v = s1.toCharArray();
   }
  void setData(String filename) throws IOException
   {int i,j;
    String s="", s1="";
    StringTokenizer t;
    RandomAccessFile f; 
    f = new RandomAccessFile(filename, "r");
    s = f.readLine();
    n = Integer.parseInt(s.trim());
    a = new int[n][n];
    for(i=0;i<n;i++)
     {s = f.readLine();
      t = new StringTokenizer(s);
      for(j=0;j<n;j++)
       {s1 = t.nextToken();
        a[i][j]=Integer.parseInt(s1.trim());
       }
     }

    f.close();
   }
  void displayData()
   {int i,j;
    System.out.println("\n The adjacency matrix of the graph:");
    System.out.println(" ==================================");
    for(i=0;i<n;i++)
      {System.out.println("\n");
       for(j=0;j<n;j++) 
         System.out.printf(" %3d",a[i][j]);
      }
    System.out.println();
   }
  //---------------------------------------------------------
  void display(EulerPath p)
   {for(int i=0;i<p.m;i++)
    System.out.print(" " + v[p.path[i]]);
   }
  //=========================================================
  boolean isUndirected() // The adjacency matrix is symmetric
   {int i,j;
    for(i=0;i<n;i++)
     for(j=0;j<n;j++)
      if(a[i][j]!=a[j][i]) return(false);
    return(true);
   }
  //---------------------------------------------------------
  boolean isConnected()
   {int i, h;
    boolean [] visited = new boolean[20];
    boolean [] pushed = new boolean[20];
    for(i=0;i<n;i++) {visited[i] = false; pushed[i]=false;}
    MyStack t = new MyStack();
    t.push(new Integer(0));pushed[0] = true;
    System.out.println();
    while(!t.isEmpty())
     {h = ((Integer) t.pop()).intValue(); visited[h] = true;
      for(i = n-1;i>=0; i--)
        if(a[h][i]>0 && !pushed[i]) {t.push(i);pushed[i]=true;}
     }
    for(i=0;i<n;i++) if(!visited[i]) return(false);
    return(true);
   }
  //---------------------------------------------------------
  int degree(int i)
   {int j,deg;
    deg=0;
    for(j=0;j<n;j++)
       deg += a[i][j];
    if(a[i][i]>1) deg += a[i][i]; // Khuyen duoc tinh hai lan
    return(deg);
   }
  //---------------------------------------------------------
  boolean have2OddDegrees()
   {int i,j,d, k;
    k = 0;
    for(i=0;i<n;i++)
     {d = degree(i);
      if(d%2==1) k++;
     } 
    if(k==2)
     return(true);
     else
     return(false);
   }
  //=======================================================
  //Tim duong di Euler
  boolean EulerPath(EulerPath p)
   {if((!isUndirected()) || (!isConnected()) || (!have2OddDegrees()))
      {p.m = 0;
       return(false);
      }
    MyStack t = new MyStack();int [][] b = new int[20][20];
    int i,j,k,h;
    k=0;
    for(i=0;i<n;i++)
      for(j=0;j<n;j++) b[i][j]=a[i][j];
    for(i=0;i<n;i++) // Tim dinh bac le
      if(degree(i)%2 == 1)
         {k = i;
          break; 
         } 
    t.push(new Integer(k));//Dua dinh k vao Stack
    j=-1;//Ban dau duong di chua co phan tu nao
    while(!t.isEmpty())
      {h = ((Integer) t.top()).intValue();i=0;
       while(i<n && a[h][i]==0) i++;//Tim i dau tien de a[h][i]#0
       if(i==n) //h da la dinh co lap, dua h vao duong di p
         {j++;p.path[j]=h;t.pop();}//Lay dinh co lap ra khoi Stack
         else
          {t.push(new Integer(i));a[h][i]--;a[i][h]--;}//Loai canh (i,h) khoi do thi
      }
    p.m = j+1;
    // Gan lai ma tran ke
    for(i=0;i<n;i++)
      for(j=0;j<n;j++) a[i][j] = b[i][j];
    return(true);
   }
  //---------------------------------------------------------
  void EulerPath()
   {EulerPath p = new EulerPath();
    boolean b = EulerPath(p);
    if(b)
      {System.out.print("\n The Euler path is:\n");
       display(p);
      }
       else
        System.out.print("\n Conditions are not satisfied\n");
   }
}
class EulerPath
 {int [] path; int m;
  EulerPath()
   {path = new int[50];
    m = 0;
   }
 }

