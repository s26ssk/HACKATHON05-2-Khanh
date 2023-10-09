package Exam_Advance_1.ra.run;

import Exam_Advance_1.ra.bussinessImp.Catalog;
import Exam_Advance_1.ra.bussinessImp.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    private static List<Product> products = new ArrayList<>();
    public static List<Catalog> catalogs  = new ArrayList<>();

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choise;
        do {
            System.out.println("********************** JAVA-HACKATHON-05-ADVANCE-2-MENU *************************");
            System.out.println("1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục");
            System.out.println("2. Nhập số sản phẩm và nhập thông tin các sản phẩm");
            System.out.println("3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần (Comparable/Comparator)");
            System.out.println("4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choise = scanner.nextInt();
            scanner.nextLine();

            switch (choise){
                case 1:
                    inputCatalogs();
                    break;
                case 2:
                    inputProducts();
                    break;
                case 3:
                    sortProductsByPrice();
                    break;
                case 4:
                    searchProductByCatalogName();
                    break;
                case 5:
                    System.out.println("Đã thoát chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }while (choise != 5);
    }
    private static void inputCatalogs() {
        System.out.print("Nhập số danh mục sản phẩm: ");
        int numCatalogs = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numCatalogs; i++) {
            Catalog catalog = new Catalog();
            catalog.inputData();
            catalogs.add(catalog);
        }
    }

    private static void inputProducts() {
        if (catalogs.isEmpty()) {
            System.out.println("Chưa có danh mục sản phẩm. Vui lòng thêm danh mục trước.");
            return;
        }
        System.out.print("Nhập số sản phẩm: ");
        int numProducts = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numProducts; i++) {
            Product product = new Product();
            product.inputData();
            products.add(product);
        }
    }

    private static void sortProductsByPrice() {
        Collections.sort(products);
        System.out.println("Danh sách sản phẩm sau khi sắp xếp theo giá tăng dần:");
        for (Product product : products) {
            product.displayData();
        }
    }

    private static void searchProductByCatalogName() {
        System.out.print("Nhập tên danh mục sản phẩm cần tìm: ");
        String searchName = scanner.nextLine();
        boolean found = false;

        for (Product product : products) {
            if (product.getCatalog().getCatalogName().equalsIgnoreCase(searchName)) {
                product.displayData();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sản phẩm nào thuộc danh mục " + searchName);
        }
    }
}
