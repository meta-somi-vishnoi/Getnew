package javamysqlconnectivity;

public class ResultSetDisplayQuery {
    private int categoryId;
    private int parentId;
    private String categoryName;

    ResultSetDisplayQuery(int categoryId, int parentId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getParentId() {
        return parentId;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
