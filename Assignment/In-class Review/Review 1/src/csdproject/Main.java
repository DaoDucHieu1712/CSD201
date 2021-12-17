package csdproject;

class Main {
    public static void main(String[] args) throws Exception{
        Validation vali = new Validation();
        Ultility util = new Ultility();
        while(true){
            System.out.print("1.Book list\n2.Reader list\n3.Lending List\n4.Exit\nYour choice: ");
            int choice = vali.inputIntLimit(1, 4);
            switch(choice){
                case 1:
                    util.bookMenu();
                    break;
                case 2:
                    util.readerMenu();
                    break;
                case 3:
                    util.lendingMenu();
                case 4:
                    return;
            }
        }
    }
}

/* 11 
1 	 A 	  3 	    2 	    2.0 	 6.0
3 	 B 	  2 	    1 	    1.0 	 2.0
2 	 C 	  5 	    4 	    3.0 	 15.0
4 	 D 	  4 	    3 	    5.0 	 20.0
*/

/* 12
1 	 A 	  3 	    2 	    2.0
3 	 B 	  2 	    1 	    1.0
2 	 C 	  5 	    4 	    3.0
4 	 D 	  4 	    3 	    5.0
6 	 E 	  3 	    2 	    2.0
*/

/* 13
1 	 A 	  3 	    2 	    2.0
3 	 B 	  2 	    1 	    8.0
2 	 C 	  5 	    4 	    3.0
4 	 D 	  4 	    3 	    5.0
*/

/*14
1 	 A 	  3 	    2 	    2.0
3 	 B 	  2 	    1 	    1.0
2 	 C 	  5 	    4 	    3.0
*/

/*15
3 	 B 	  2 	    1 	    1.0
1 	 A 	  3 	    2 	    2.0
4 	 D 	  4 	    3 	    5.0
2 	 C 	  5 	    4 	    3.0
*/