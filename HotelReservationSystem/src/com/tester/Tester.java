package com.tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.Hotel.Admin;
import com.Hotel.Booking;
import com.Hotel.BookingStatus;
import com.Hotel.Hotel;
import com.Hotel.RoomType;


public class Tester {

	public static void main(String[] args) {
		ArrayList<Hotel> list = new ArrayList<>();
		ArrayList<Booking> bookList = new ArrayList<>();
		Admin admin = new Admin();
		list = Populate.populateList();
		try (Scanner sc = new Scanner(System.in)) {
			
			boolean flag = true;
			while (flag) {
				System.out.println("Application menu: \n 1.Add hotel room \n" + " 2.Hotel Search \n "
						+ "3.Book a hotel Room\n " + "4.Cancel booking\n" + " 0.Exit");
				int choice = sc.nextInt();
				switch (choice) {

				case 1:
					System.out.println("Enter Username and PassWord");
					String username=sc.next();
					String password=sc.next();
					if(admin.getUsername().equals(username)&&admin.getPassword().equals(password)){
						//Hotel(String hotelName, String hotelAddress, int roomNo, RoomType roomType, double pricePerNight)
						System.out.println("Enter Hotel Name:");
						String name = sc.next();
						
						System.out.println("Enter Hotel City");
						String address = sc.next();
						
						System.out.println("Enter Room No.: ");
						int room = sc.nextInt();
						
						System.out.println("Enter Room Type ex: Single, Double, Suite");
						RoomType type = RoomType.valueOf(sc.next().toUpperCase());
						
						System.out.println("Enter Price Per Night");
						double price = sc.nextDouble();
						
						Hotel hotel = new Hotel(name, address, room, type, price);
						list.add(hotel);
					}else {
						System.out.println("Invalid Username or Password");
					}
					
					break;
					
				case 2: 
					for (Hotel i: list) {					
						System.out.println(i.toString());						
					}
					break;
					
				case 3: 
					/*String customerName, int age, String hotelName, int roomNumber, LocalDateTime checkInDate,
					LocalDateTime checkOutDate*/
					System.out.println("Enter Full Name:");
					String name = sc.next();
					
					System.out.println("Enter Age");
					int age = sc.nextInt();
					
					System.out.println("Enter Hotel Name");
					String hotel = sc.next();
					
					System.out.println("Enter Room No.to be booked: ");
					int room = sc.nextInt();
					
					System.out.println("Enter CheckIn date YYYY-MM-DD");
					LocalDate checkIn = LocalDate.parse(sc.next());
					
					System.out.println("Enter CheckOut date YYYY-MM-DD");
					LocalDate checkOut = LocalDate.parse(sc.next());
					
					Booking booking = new Booking(name, age, hotel, room, checkIn, checkOut);
					
					System.out.println("To confirm Your Hotel Room Booking Enter YES or NO: ");
					String confirm=sc.next().toUpperCase();
					
					if(confirm=="YES") {
						for(Booking i : bookList) {
							Boolean isBetween = booking.getCheckInDate().isAfter(i.getCheckInDate()) && booking.getCheckInDate().isBefore(i.getCheckOutDate());
							if(isBetween && booking.getRoomNumber()==i.getRoomNumber()) {
								System.out.println("Sorry the room is not available for"+booking.getCheckInDate()+"Date");
							}else {
								bookList.add(booking);
								System.out.println("Your for RoomNo."+booking.getRoomNumber()+"of Hotel"+booking.getHotelName()+"is confirmed");
								for(Hotel j: list) {
									if(booking.getRoomNumber()==j.getRoomNo()) {
										j.setBookingStat(BookingStatus.NOT_AVAILABLE);
										break;
									}
								}
							}
						}
						
					}
					
					
				case 4:
					System.out.println("Enter the Your Name please: ");
					String cname =sc.next();
					for(Booking i : bookList) {
						if(i.getCustomerName().equals(cname)) {
							System.out.println((i.toString()));
						}
					}
					
					System.out.println("Enter Room no. to  be cancelled");
					int roomno =sc.nextInt();
					for(Booking i : bookList) {
						if(bookList.contains(roomno)) {
							System.out.println("Your Booking for room no."+roomno+"is cancelled");
							bookList.remove(i);
						}else {
							System.out.println("Room no.does not exists");
						}
							
					}

					
				case 0 : 
					System.out.println("closing the application");
					flag=false;
					break;
					
				default:
					System.out.println("please enter a valid choice");
					
				}
				
			}

		}catch(Exception e) {
			e.getMessage();
		}

	}


}
