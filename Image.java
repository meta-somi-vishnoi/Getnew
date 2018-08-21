package javamysqlconnectivity;

class Image {
    private int productId;
    private String imageName;

    Image(int productId, String imageName) {
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
