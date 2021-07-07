package javamysqlconnectivity;

class Node {

    private int productId;
    private String imageName;

    Node(int productId, String imageName) {
        this.productId = productId;
        this.imageName = imageName;
    }

    public int getId() {
        return productId;
    }

    public String getName() {
        return imageName;
    }
}
