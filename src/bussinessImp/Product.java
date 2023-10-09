package bussinessImp;

import bussiness.IShop;

import java.util.Scanner;

import static run.ProductManagement.categoryList;

public class Product implements IShop {
    private int productId;

    private Catalog catalog;
    private String productName;
    private String categoryName;
    private String title;
    private String descriptions;
    private float importPrice;
    private float exportPrice;
    public Product() {
    }
    public Product(int productId, String productName, String title, String descriptions, Catalog catalog, float importPrice, boolean productStatus ,float exportPrice) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.catalog = catalog;
        this.importPrice = importPrice;
        this.productStatus = productStatus;
        this.exportPrice =exportPrice;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getTitle() {
        return title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public String getCategoryName() {
        return categoryName;
    }

    private boolean productStatus;
    @Override
    public void inputData(Scanner sc) {
        System.out.println("Vui lòng nhập Mã sản phẩm: ");
        this.productId = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập tên sản phẩm");
        this.productName = sc.nextLine();
        System.out.println("Nhập tên tiêu đề");
        this.title = sc.nextLine();
        System.out.println("Nhập mô tả sản phẩm");
        this.descriptions = sc.nextLine();
        System.out.println("Giá nhâp");
        this.importPrice = Float.parseFloat(sc.nextLine());
        this.exportPrice = this.importPrice * RATE;
        System.out.println("Nhập trạng thái");
        this.productStatus = Boolean.parseBoolean(sc.nextLine());
        System.out.println("lựa chọn Danh mục: ");
        boolean isExit = true;
        do {
            for (int i = 0; i < categoryList.size(); i++) {
                categoryList.get(i).displayData();
            }
            System.out.println("Nhập Mã danh mục cho sản phẩm: ");
            int catalogID = Integer.parseInt(sc.nextLine());
            boolean check = false;
            for (Catalog cataItem : categoryList) {
                if (cataItem.getCatalogId() == catalogID) {
                    this.catalog = cataItem;
                    check = true;
                }
            }
            if (check) {
                isExit = false;
            } else {
                System.out.println("Yêu cầu nhập đúng Mã danh mục tồn tại");
            }

        } while (isExit);

    }

    @Override
    public void displayData() {
        System.out.printf("Mã sản phẩm: %d - Tên sản phẩm: %s - Tiêu đề: %s - Mô Tả: %s\n", this.productId, this.productName, this.title, this.descriptions);
        System.out.printf("Danh Mục: %s - Giá bán: %f - Trạng thái: %s\n", this.catalog.getCatalogName(), this.exportPrice, this.productStatus ? "Còn hàng" : "Hết hàng");
    }
}
