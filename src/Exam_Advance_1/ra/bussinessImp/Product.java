package Exam_Advance_1.ra.bussinessImp;

import Exam_Advance_1.ra.bussiness.IShop;
import static Exam_Advance_1.ra.run.ProductManagement.catalogs;
import static Exam_Advance_1.ra.run.ProductManagement.scanner;

public class Product implements IShop,  Comparable<Product> {
    private int productId;
    private String productName;

    private String title;

    private String descriptions;

    private Catalog catalog;

    private float importPrice;

    private float exportPrice;

    private boolean productStatus;

    public Product(){

    }
    public Product(int productId, String productName, String title, String descriptions, Catalog catalog, float importPrice, float exportPrice, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.catalog = catalog;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData() {
        System.out.println("Nhập mã sản phẩm: ");
        productId = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập tên sản phẩm: ");
        productName = scanner.nextLine();

        System.out.println("Nhập tiêu đề sản phẩm: ");
        title = scanner.nextLine();

        System.out.println("Nhập mô tả sản phẩm: ");
        descriptions = scanner.nextLine();

        System.out.println("Danh sách Catalogs:");
        for (Catalog catalog : catalogs) {
            if (catalog != null) {
                System.out.println("ID: " + catalog.getCatalogId() + " Name:  " + catalog.getCatalogName());
            }
        }

        System.out.println("Chọn Catalog theo ID:");
        while (true) {
            int id = Integer.parseInt(scanner.nextLine());
            boolean flag = false;
            for (Catalog catalog : catalogs) {
                if (catalog != null && catalog.getCatalogId() == id) {
                    flag = true;
                    this.catalog = catalog;
                    break;
                }
            }
            if (!flag) {
                System.out.println("ID không đúng, vui lòng nhập lại!!!");
            } else {
                break;
            }
        }
        System.out.println("Nhập giá nhập sản phẩm: ");
        importPrice = Float.parseFloat(scanner.nextLine());

        exportPrice = this.importPrice * RATE;

        System.out.println("Nhập trạng thái sản phẩm (true/false): ");
        productStatus = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.println("ID sản phẩm: " + productId);
        System.out.println("Tên sản phẩm: " + productName);
        System.out.println("Tên danh mục: " + catalog.getCatalogName());
        System.out.println("Giá nhập sản phẩm: " + importPrice);
        System.out.println("Giá bán sản phẩm: " + exportPrice);
        System.out.println("Trạng thái sản phẩm: " + (productStatus ? "Đang bán" : "Hết hàng"));
        System.out.println("-------------------------------------------");
    }

    @Override
    public int compareTo(Product otherProduct) {
        if (this.exportPrice < otherProduct.exportPrice) {
            return -1;
        } else if (this.exportPrice > otherProduct.exportPrice) {
            return 1;
        } else {
            return 0;
        }
    }
}
