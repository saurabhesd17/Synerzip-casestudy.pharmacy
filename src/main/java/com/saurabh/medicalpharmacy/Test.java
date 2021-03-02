package com.saurabh.medicalpharmacy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.saurabh.dao.DoctorDao;
import com.saurabh.dao.InventoryDao;
import com.saurabh.dao.MedicineDao;
import com.saurabh.dao.OrderDao;
import com.saurabh.dao.PharmacyDao;
import com.saurabh.entities.Doctor;
import com.saurabh.entities.Inventory;
import com.saurabh.entities.Medicine;
import com.saurabh.entities.Order;
import com.saurabh.entities.Pharmacy;

public class Test {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"com/saurabh/medicalpharmacy/jdbcconfig.xml");

		try {
			boolean condition = true;
			while (condition) {
				System.out.println("1.Medicine");
				System.out.println("2.Doctor");
				System.out.println("3.Order");
				System.out.println("4.Pharmacy");
				System.out.println("5.Inventory");
				System.out.println("Enter any key to exit");

				BufferedReader get = new BufferedReader(new InputStreamReader(System.in));

				int choice = Integer.parseInt(get.readLine());
				switch (choice) {
				case 1:
					System.out.println("1.Create Medicine");
					System.out.println("2.Search Medicine by name");
					System.out.println("3.Search Medicine by brand");
					System.out.println("4.Delete Medicine");
					System.out.println("Enter any key to go back to main menu");

					MedicineDao medicine = context.getBean("medicineDao", MedicineDao.class);

					int medicineChoice = Integer.parseInt(get.readLine());
					switch (medicineChoice) {
					case 1:
						Medicine md = context.getBean("medicine1", Medicine.class);
//						Medicine md = context.getBean("medicine2", Medicine.class);
//						Medicine md = context.getBean("medicine3", Medicine.class);
//						Medicine md = context.getBean("medicine4", Medicine.class);
//						Medicine md = context.getBean("medicine5", Medicine.class);

						int rows = medicine.create(md);
						System.out.println(rows + " number of rows affected");
						break;
					case 2:
						List<Medicine> name = medicine.searchByName("para");
						for (Medicine m : name) {
							System.out.println(m);
						}
						break;
					case 3:
						List<Medicine> brand = medicine.searchByBrand("phar");
						for (Medicine m : brand) {
							System.out.println(m);
						}
						break;
					case 4:
						int drows = medicine.delete(101);
						System.out.println(drows + " number of rows affected");
						break;
					default:
						break;
					}
					break;

				case 2:
					System.out.println("1.Create Doctor");
					System.out.println("2.Search Doctor");
					System.out.println("3.Delete Doctor");
					System.out.println("Enter any key to go back to main menu");

					DoctorDao doctor = context.getBean("doctorDao", DoctorDao.class);

					int doctorChoice = Integer.parseInt(get.readLine());
					switch (doctorChoice) {
					case 1:
						Doctor dr = context.getBean("doctor1", Doctor.class);
						int rows = doctor.create(dr);
						System.out.println(rows + " number of rows affected");
						break;
					case 2:
						List<Doctor> name = doctor.search("bh");
						for (Doctor d : name) {
							System.out.println(d);
						}
						break;
					case 3:
						int drows = doctor.delete(100);
						System.out.println(drows + " number of rows affected");
						break;
					default:
						break;
					}
					break;

				case 3:
					System.out.println("1.Make a Order");
					System.out.println("2.Display Pending Orders");
					System.out.println("3.Complete Orders");
					System.out.println("Enter any key to go back to main menu");

					OrderDao order = context.getBean("orderDao", OrderDao.class);

					int orderChoice = Integer.parseInt(get.readLine());
					switch (orderChoice) {
					case 1:
						Order or = context.getBean("order2", Order.class);
						int rows = order.makeOrder(or);
						System.out.println(rows + " number of rows affected");
						break;
					case 2:
						List<Order> pending = order.pendingOrders();
						for (Order o : pending) {
							System.out.println(o);
						}
						break;
					case 3:
						int complete = order.completeOrder(1);
						System.out.println(complete + " number of rows affected");
						break;
					default:
						break;
					}
					break;

				case 4:
					System.out.println("1.Create Pharmacy");
					System.out.println("2.Show Pharmacy Details");
					System.out.println("3.Delete Pharmacy");
					System.out.println("Enter any key to go back to main menu");

					PharmacyDao pharmacy = context.getBean("pharmacyDao", PharmacyDao.class);

					int pharmacyChoice = Integer.parseInt(get.readLine());
					switch (pharmacyChoice) {
					case 1:
						Pharmacy ph = context.getBean("pharmacy1", Pharmacy.class);
						int rows = pharmacy.create(ph);
						System.out.println(rows + " number of rows affected");
						break;
					case 2:
						Pharmacy ph1 = pharmacy.information(101);
						System.out.println(ph1);
						break;
					case 3:
						int drows = pharmacy.delete(101);
						System.out.println(drows + " number of rows affected");
					default:
						break;
					}
					break;

				case 5:
					System.out.println("1.Add Medicine in Inventory");
					System.out.println("2.Show Medicines in Inventory");
					System.out.println("Enter any key to go back to main menu");

					InventoryDao inventory = context.getBean("inventoryDao", InventoryDao.class);

					int inventoryChoice = Integer.parseInt(get.readLine());
					switch (inventoryChoice) {
					case 1:
						Inventory in = context.getBean("inventory1", Inventory.class);
						int rows = inventory.create(in);
						System.out.println(rows + " number of rows affected");
						break;
					case 2:
						List<Inventory> medicines = inventory.medicineList();
						for (Inventory i : medicines) {
							System.out.println(i);
						}
						break;
					default:
						break;
					}
					break;

				default:
					condition = false;
					System.out.println("Have a nice day");
					break;
				}
			}

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			context.close();
		}
	}
}
