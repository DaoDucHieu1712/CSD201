public class Graph {
    int [][] a; int n;
    char [] v;
    Graph() {
      //v = "ABCDEF".toCharArray(); 
      v = "123456".toCharArray();
    }
    void setData(int [][] b) {
       n=b.length;
       int i,j;
       a = new int[n][n];
       for(i=0;i<n;i++)
           for(j=0;j<n;j++) a[i][j]=b[i][j];
    }
    void dispAdj() {
       int i,j;
       for(i=0;i<n;i++) {
          System.out.println();
           for(j=0;j<n;j++) {
               System.out.printf("%4d",a[i][j]);
           }
       }
    }
    void visit(int i) {
        System.out.print(v[i]+"  ");
    }
    void breadth(boolean [] en, int i) {
       MyQueue q = new MyQueue();
       q.enqueue(i); en[i]=true;
       int r;
       while(!q.isEmpty()) {
         r=q.dequeue();
         visit(r);
         for(int j=0;j<n;j++)
           if(!en[j] && a[r][j]>0 ) {
              q.enqueue(j);
              en[j]=true;
           }  
       }
    }
    void breadth(int k) {
      boolean [] en = new boolean[n];
      int i,j;
      for(i=0;i<n;i++) en[i]=false;
      breadth(en,k);
      for(i=0;i<n;i++) if(!en[i]) breadth(en,i);
      
    }
    void depth(boolean [] vis, int i) {
       visit(i);vis[i]=true;
       for(int j=0;j<n;j++)
         if(!vis[j] && a[i][j]>0) depth(vis,j);  
    }
    void depth(int k) {
      boolean [] vis = new boolean[n];
      int i,j;
      for(i=0;i<n;i++) vis[i]=false;
      depth(vis,k);
      for(i=0;i<n;i++) if(!vis[i]) depth(vis,i);
      
    }
    void dijkstra(int fro, int to) {
       int INF=99;
       boolean [] S = new boolean[n];//danh dau dinh da dua vao tap S
       int [] d = new int[n];// do dai duong di
       int [] p = new int[n];// dinh dung truoc
       int i,j,k,t; // t lam gia tri min tam thoi
       //khoi tao, chua dinh nao dua vao S
       for(i=0;i<n;i++) {
          S[i]=false;  // chua dinh nao duoc chon
          d[i]=a[fro][i]; //ban dau duong di truc tiep tu dinh xuat phat den dinh i
          p[i]=fro; // ban dau dinh truoc la dinh xuat phat
       }
       S[fro]=true; // chon dinh fro - dinh ban dau vao tap S
       while(true) {  //tim dinh min (k)
         t=INF; //khoi tao min (chua chac xuat phat tu 0)- giong tim min trong ds
         k=-1;  //find t sao cho d[k]=min
         for(i=0;i<n;i++) { 
           if(S[i]) continue; // S[i]=true: bo qua vi nó da o tap S
           if(d[i]<t) {
             t=d[i];
             k=i;
           }
         }//thoat khoi lap
           if(k==-1) {
              System.out.println("No solution");
              return;  //khong co nghiem
           }
          //k la noi nhan gia tri min
           // select k into the set S
           S[k]=true;
           if(k==to) break;
           // update data - cap nhat lai d[i]
           for(i=0;i<n;i++) {
             if(S[i]) continue;
             //duong di cu d[i] - sau la d[k]
             if(d[i]> d[k]+a[k][i]) {
                 d[i]=d[k]+a[k][i];
                 p[i]=k;//cap nhat lai dinh truoc
             }
           }
         }
       System.out.println("The shortest distance is " + d[to]);
       //lat nguoc lai khi gap fro - dung
       MyStack s = new MyStack();
       i=to;
       while(true) {
         s.push(i);
         if(i==fro) break;
         i=p[i];
       }
       i=s.pop();
       System.out.println("Th shotest path is");
       System.out.print(v[i]);//viet dinh phat phat
       while(!s.isEmpty()) {
          i=s.pop();
          System.out.print(" -> " + v[i]);//viet ra cac dinh di qua
        }
       System.out.println();
    }
}
