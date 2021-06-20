package Datastructures.maps;

public class AmazonOrder {


    public int getOrderId() {
        return orderId;
    }

    public String getpName() {
        return pName;
    }

    public double getPrice() {
        return price;
    }

    private int orderId;
    private String pName;
    private double price;

    public AmazonOrder(int orderId, String pName, double price) {
        this.orderId = orderId;
        this.pName = pName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "AmazonOrder{" +
                "orderId=" + orderId +
                ", pName='" + pName + '\'' +
                ", price=" + price +
                '}';
    }


}
