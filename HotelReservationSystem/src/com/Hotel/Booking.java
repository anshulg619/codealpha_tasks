package com.Hotel;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Booking {
		String customerName;
		int age;
		String hotelName;
		int roomNumber;
		LocalDate checkInDate;
		LocalDate checkOutDate;
		public Booking(String customerName, int age, String hotelName, int roomNumber, LocalDate checkInDate,
				LocalDate checkOutDate) {
			super();
			this.customerName = customerName;
			this.age = age;
			this.hotelName = hotelName;
			this.roomNumber = roomNumber;
			this.checkInDate = checkInDate;
			this.checkOutDate = checkOutDate;
		}
		public String getCustomerName() {
			return customerName;
		}
		public String getHotelName() {
			return hotelName;
		}
		public int getRoomNumber() {
			return roomNumber;
		}
		public LocalDate getCheckInDate() {
			return checkInDate;
		}
		public LocalDate getCheckOutDate() {
			return checkOutDate;
		}
		@Override
		public String toString() {
			return "Booking [customerName=" + customerName + ", age=" + age + ", hotelName=" + hotelName
					+ ", roomNumber=" + roomNumber + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate
					+ "]";
		}
		
		
}
