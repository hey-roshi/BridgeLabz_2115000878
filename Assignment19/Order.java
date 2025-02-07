public class Order{
    int orderId;
    int orderDate;
    public Order(int orderId, int orderDate){
        this.orderId=orderId;
        this.orderDate=orderDate;
    }
    public void getOrderStatus(){
        System.out.println("put your order");
    }
    public static void main(String args[]){
       Order obj1=new Order(01,01/01/2020);
       obj1.getOrderStatus();
       Order obj2=new ShippedOrder(02,02/02/2020,56,"box");
       obj2.getOrderStatus();
    }
}
class ShippedOrder extends Order{
    int trackingNo;
    String type;
    public ShippedOrder(int orderId, int orderDate,int trackingNo, String type){
       super(orderId, orderDate);
       this.trackingNo=trackingNo;
       this.type=type;
    }
      public void getOrderStatus(){
        System.out.println("order is shipped");
    }

}
class DeliveredOrder extends ShippedOrder{
    int deliveryDate;
    String feedback;
    public DeliveredOrder(int orderId, int orderDate,int trackingNo, String type, int deliveryDate, String feedback){
        super(orderId,orderDate,trackingNo,type);
        this.deliveryDate=deliveryDate;
        this.feedback=feedback;
    }
      public void getOrderStatus(){
        System.out.println("order is delivered");
    }
  
}
