package com.Hotel;

public class Hotel {
	private String hotelName;
	private String hotelAddress;
	private int roomNo;
	private RoomType roomType;
	private double pricePerNight;
	private BookingStatus bookingStat;
	public Hotel(String hotelName, String hotelAddress, int roomNo, RoomType roomType, double pricePerNight)
	{
		this.hotelName = hotelName;
		this.hotelAddress = hotelAddress;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.pricePerNight = pricePerNight;
		this.bookingStat = BookingStatus.AVAILAIBLE;
	}
	public double getPricePerNight() {
		return pricePerNight;
	}
	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	public BookingStatus getBookingStat() {
		return bookingStat;
	}
	public void setBookingStat(BookingStatus bookingStat) {
		this.bookingStat = bookingStat;
	}
	public String getHotelName() {
		return hotelName;
	}
	public String getHotelAddress() {
		return hotelAddress;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public RoomType getRoomType() {
		return roomType;
	}
	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", hotelAddress=" + hotelAddress + ", roomNo=" + roomNo + ", roomType="
				+ roomType + ", pricePerNight=" + pricePerNight + ", bookingStatus=" + bookingStat + "]";
	}
	
	
	

}
