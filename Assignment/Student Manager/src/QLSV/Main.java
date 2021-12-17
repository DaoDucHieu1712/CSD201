package QLSV;

public class Main {

    public static void main(String[] args) {
        List var = new List();
        String a[] = {"The", "Hùng"};
        int b[] = {20, 21};
        for (int i = 0; i < a.length; i++) {
            var.addHead(a[i], b[i]);
        }
        System.out.println("Name  :  Age ");
        var.addHead("A", 1);
        var.addHead("B", 22);
        var.addTail("C", 19);
        var.addTail("D", 18);
        var.addTail("E", 19);
        var.traverse();
        var.addposition(3, "F", 17);
        var.addposition(5, "G", 18);
        var.addHead("H", 20);
        var.traverse();
        var.searchByName("I");
        var.searchByAge(20);
        var.delete_tail();
        var.traverse();
        var.deleteAt(5);
        var.traverse();
    }
}
