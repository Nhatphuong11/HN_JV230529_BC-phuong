package bussinessImp;

import bussiness.IShop;

import java.util.Scanner;

public class Catalog implements IShop {
    private int catalogId;
    private String catalogName;
    private int priority;
    private String descriptions;
    private boolean catalogStatus;

    public Catalog() {
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public int getPriority() {
        return priority;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }


    @Override
    public void inputData(Scanner sc) {
        System.out.println("Vui lòng nhập id danh mục: ");
        this.catalogId = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập tên danh mục");
        this.catalogName = sc.nextLine();
        System.out.println("Vui lòng nhập độ ưu tiên: ");
        this.priority = Integer.parseInt(sc.nextLine());
        System.out.println("Vui lòng nhập mô tả: ");
        this.descriptions = sc.nextLine();
        System.out.println("Nhập trạng thái");
        this.catalogStatus = Boolean.parseBoolean(sc.nextLine());
    }

    @Override
    public void displayData() {
        System.out.printf("Mã danh mục: %d - Tên danh mục: %s - Mô Tả: %s - Độ ưu tiên: %d - Trạng thái: %s\n", this.catalogId, this.catalogName, this.descriptions, this.priority ,this.catalogStatus ? "Có" : "Không");
    }
}
