package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

public class ProductCRUDDemo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ProductService pservice=new ProductServiceImpl();
		int choice=0;
		do {
			System.out.println("1. Add new product\n2. Delete product\n3. Modify product");
			System.out.println("4. Display all\n5. Display by id\n6. Display in sorted order of price\n7. Exit");
			System.out.println("Choice : ");
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				pservice.addNewProduct();
				break;
			case 2:
				System.out.println("Enter Id :");
				int id = sc.nextInt();
				boolean status = pservice.deleteById(id);
				if(status) {
					System.out.println("Deleted Successfully !!!");
				}else {
					System.out.println("Id Not Found!!!");
				}
				break;
			case 3:
				System.out.println("Enter id to Update: ");
				id=sc.nextInt();
				status=pservice.updateById(id);
				if(status) {
					System.out.println("Updated Successfully !!!");
				}else {
					System.out.println("Id Not Found!!!");
				}
				break;
			case 4:
				List<Product> plist = pservice.displayAll();
				plist.forEach(System.out::println);
				break;
			case 5:
				System.out.println("Enter Id to Display: ");
				id=sc.nextInt();
				Product p= pservice.getById(id);
				if(p!=null) {
					System.out.println(p);
				}else {
					System.out.println("Id Not Found..!!");
				}
				break;
			case 6:
				plist = pservice.displaySorted();
				plist.forEach(System.out::println);
				break;
			case 7:
				pservice.closeMyConnection();
				sc.close();
				break;
			}
			
		}while(choice!=7);

	}

}
