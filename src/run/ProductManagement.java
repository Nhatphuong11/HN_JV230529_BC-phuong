package run;

import bussinessImp.Catalog;
import bussinessImp.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    public static List<Catalog> categoryList = new ArrayList<>();
    public static List<Product> productList = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public static int choice;
    public static void main(String[] args) {
        do {
            System.out.println("*****************************Product Management*****************************");
            System.out.println("1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục");
            System.out.println("2. Nhập số sản phẩm và nhập thông tin các sản phẩm");
            System.out.println("3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần");
            System.out.println("4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm");
            System.out.println("5. Thoát");
            System.out.print("Nhập vào lựa chọn của bạn (1-5): ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addCatelog();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    sortDown();
                    break;
                case 4:
                    search();
                    break;
                case 5:
                    System.out.println("Đã thoát!");
                    System.exit(0);
                    break;
            }
        } while (true);
    }
    public static void addCatelog(){
        System.out.print("Nhập số lượng danh mục: ");
        int CatalogToAdd = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < CatalogToAdd; i++) {
            Catalog catalog = new Catalog();
            catalog.inputData(sc);
            categoryList.add(catalog);
        }
    }
    public static void addProduct(){
        System.out.print("Nhập số lượng sản phẩm: ");
        int ProductToAdd = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < ProductToAdd; i++) {
            Product product = new Product();
            product.inputData(sc);
            productList.add(product);
        }
    }
    public static void sortDown() {
        Collections.sort(productList,(s1, s2)->Double.compare(s1.getExportPrice(), s2.getExportPrice()));
        for (Product element : productList) {
            element.displayData();
        }
    }
    public static void search(){
        System.out.println("Nhập tên danh mục để tìm sản phẩm");
        String searchNameCata = sc.nextLine();
        boolean check = false;
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getCatalog().getCatalogName().toLowerCase().contains(searchNameCata.toLowerCase())){
                productList.get(i).displayData();
                check = true;
            }
        }
        if (!check) {
            System.out.println("Sản phẩm không tìm thấy");
        }
    }

}
