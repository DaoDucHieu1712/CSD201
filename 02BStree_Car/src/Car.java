
public class Car {
    String name;int price;
    Car(){}
    Car(String xName,int xPrice){
        name=xName;
        price=xPrice;
    }    
    public String toString(){
        return "("+name+","+price+") ";
    }
}
