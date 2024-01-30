package com.tester;

import java.util.ArrayList;

import com.Hotel.Hotel;
import com.Hotel.RoomType;

public class Populate {
	public static ArrayList<Hotel> populateList(){
		ArrayList<Hotel> list = new ArrayList<>();
		list.add(new Hotel("SDI","Plaestine", 303, RoomType.SUITE,2000.00 ));
		
		return list;
		
	}
}
