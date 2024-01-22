import controller.ProductController;
import model.ExportProduct;
import model.ImportProduct;
import model.Product;
import repository.ProductRepository;
import service.ProductService;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductService service = new ProductService(new ProductRepository("src/data/products.csv"));
        ProductController productController = new ProductController(service);
        boolean flag ;
        boolean returnFlag;
        do {
            flag = false;
            System.out.println("Chọn chức năng : \n" +
                    "1.Thêm mới sản phẩm\n" +
                    "2.Hiển thị sản phẩm\n" +
                    "3.Xóa sản phẩm theo Id\n" +
                    "4.Thoát");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    do {
                        returnFlag = false;
                        System.out.println("-Thêm mới sản phẩm");
                        System.out.println("---Chọn Loại sản phẩm :\n" +
                                "1.Thêm sản phẩm nhập khẩu\n" +
                                "2.Thêm sản phẩm xuất khẩu\n" +
                                "3.Thoát");
                        int addType = Integer.parseInt(scanner.nextLine());

                        switch (addType) {
                            case 1:
                                System.out.println(productController.add(inputImportProduct()));
                                break;
                            case 2:
                                System.out.println(productController.add(inputExportProduct()));
                                break;

                            case 3:
                                returnFlag = true;
                                break;
                        }
                    } while (!returnFlag);
                    break;
                case 2:
                    System.out.println("Hiển thị DS sản phẩm");
                    System.out.println("---Danh sách---");
                    ArrayList<Product> list = productController.getAll();
                    for (Product product : list) {
                        System.out.println(product.toString());
                    }
                    break;
                case 3:
                    System.out.println("Xóa sản pẩm");
                    System.out.println("Nhập mã sản phẩm :");
                    String productId = scanner.nextLine();
                    if (productController.get(productId) != null ) {
                        System.out.println("Xác nhận xóa sản phẩm (Y/N) : ");
                        String confirm = scanner.nextLine();
                        if (confirm.equals("Y")) {
                            if (productController.get(productId) != null) System.out.println(productController.delete(productId));
                            System.out.println(productController.delete(productId));

                        } else System.out.println("Hủy việc xóa sản phẩm !");

                    } else System.out.println("ProductId không tồn tại !");

                    // code xoá
                    break;
                case 4:
                    flag = true;
                    break;
            }
        } while (!flag);

        System.out.println("Kết thúc chương trình ");

    }
    public static ImportProduct inputImportProduct() {
        ArrayList<String> data = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name :");
        String name = sc.nextLine();
        System.out.println("Enter productId :");
        String productId = sc.nextLine();
        System.out.println("Enter price :");
        Double price = Double.parseDouble(sc.nextLine());
        System.out.println("Enter quantity :");
        int quantity = Integer.parseInt(sc.nextLine());
        System.out.println("Enter manufacturer :");
        String manufacturer = sc.nextLine();
        System.out.println("Enter import price :");
        Double impPrice = Double.parseDouble(sc.nextLine());
        System.out.println("Enter province :");
        String province = sc.nextLine();
        System.out.println("Enter tax :");
        Double tax = Double.parseDouble(sc.nextLine());
        return new ImportProduct(name,productId,price,quantity,manufacturer,impPrice,province,tax);
    }
    public static ExportProduct inputExportProduct() {
        ArrayList<String> data = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name :");
        String name = sc.nextLine();
        System.out.println("Enter productId :");
        String productId = sc.nextLine();
        System.out.println("Enter price :");
        Double price = Double.parseDouble(sc.nextLine());
        System.out.println("Enter quantity :");
        int quantity = Integer.parseInt(sc.nextLine());
        System.out.println("Enter manufacturer :");
        String manufacturer = sc.nextLine();
        System.out.println("Enter export price :");
        Double expPrice = Double.parseDouble(sc.nextLine());
        System.out.println("Enter nation :");
        String nation = sc.nextLine();
        System.out.println("Enter tax :");
        Double tax = Double.parseDouble(sc.nextLine());
        return new ExportProduct(name,productId,price,quantity,manufacturer,expPrice,nation);
    }
}