package ConLib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;


import GUI.CustomerReg;

public class JDBC extends Connector {

	JButton btn;

	public boolean save(CorpLib inse) {
		// declare and initialize
		boolean result = false;
		Connection conn;
		String sql = "insert into registration(Customerid,Fullname, Dob, gender ,address, email, MobileNum, customerType,CompanyName ) values(?,?,?,?,?,?,?,?,?)";

		PreparedStatement pstat;
		try {
			System.out.println(inse.getId());
			// sending data from textfield to sql
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, inse.getId());
			pstat.setString(2, inse.getName());
			pstat.setString(3, inse.getDob());
			pstat.setString(4, inse.getGender());
			pstat.setString(5, inse.getAddress());
			pstat.setString(6, inse.getEmail());
			pstat.setInt(7, inse.getPhone());
			pstat.setString(8, inse.getCusType());
			pstat.setString(9, inse.getCompany());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
			JOptionPane.showMessageDialog(btn, "Welcome to Hotel Luton!!");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(btn, "please try again!!");
			System.out.println("Error :" + ex.getMessage());
		}
		return result;

	}

	public LoginLibs logindata(LoginLibs user) {

		String sql = "insert into user (name , password, CustomerId, UserType) values(?,?,?,?)";
		try {

			Connection conn = connect();
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, user.getUsername());
			pstat.setString(2, user.getPassword());
			pstat.setInt(3, user.getId());
			pstat.setString(4, user.gettype());
			pstat.executeUpdate();

		}

		catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return user;
	}

	public LoginLibs logindatastaf(LoginLibs user) {

		String sql = "insert into user (name , password, StafId, UserType) values(?,?,?,?)";
		try {

			Connection conn = connect();
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, user.getUsername());
			pstat.setString(2, user.getPassword());
			pstat.setInt(3, user.getId());
			pstat.setString(4, user.gettype());
			pstat.executeUpdate();

		}

		catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return user;
	}

	public boolean saveCust(CustomerLib inse) {
		// declare and initialize
		boolean result = false;
		Connection conn;
		String sql = "insert into registration(Customerid, Fullname, Dob, gender ,address, email, MobileNum, customerType ) values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstat;
		try {
			// sending data from textfield to sql
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, inse.getId());
			pstat.setString(2, inse.getName());
			pstat.setString(3, inse.getDob());
			pstat.setString(4, inse.getGender());
			pstat.setString(5, inse.getAddress());
			pstat.setString(6, inse.getEmail());
			pstat.setInt(7, inse.getPhone());
			pstat.setString(8, inse.getCusType());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
			JOptionPane.showMessageDialog(btn, "Welcome to Hotel Luton!!");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(btn, "please try again!!");
			System.out.println("Error :" + ex.getMessage());
		}
		return result;

	}

	public boolean RequestBook(libBookRequest inse) {
		// declare and initialize
		boolean result = false;
		Connection conn;
		String sql = "insert into booking (Checkin_date,Checkout_date,roomPreference, Uid)values(?,?,?,?)";
		PreparedStatement pstat;
		try {
			// sending data from textfield to sql
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, inse.getCheckin_date());
			pstat.setString(2, inse.getCheckout_date());
			pstat.setString(3, inse.getPreffered_room());
			pstat.setInt(4, inse.getUid());

			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
			JOptionPane.showMessageDialog(btn, "Your Booking was a Sucess!!");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(btn, "please try again!!");
			System.out.println("Error :" + ex.getMessage());
		}
		return result;

	}

	public libBookRequest bookupdaterequest(libBookRequest inse) {
		Connection conn;

		try {

			String query1 = "update Booking set  Checkin_date =?, Checkout_date=?,roomPreference=? where uid= ? and roomPreference != ' '";
			conn = connect();
			PreparedStatement pst = conn.prepareStatement(query1);
			pst.setString(1, inse.getCheckin_date());
			pst.setString(2, inse.getCheckout_date());
			pst.setString(3, inse.getPreffered_room());
			pst.setInt(4, inse.getUid());

			pst.execute();
			JOptionPane.showMessageDialog(null, "Update Successfull");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return inse;

	}

	public boolean saveBook(libBook inse) {
		// declare and initialize
		boolean result = false;
		Connection conn;
		String sql = "update Booking set  Checkin_date =?, Checkout_date=?,Booking_status=?,guestName=?,roomId =? where Booking_ID= ? ";
		PreparedStatement pstat;
		try {
			// sending data from textfield to sql
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, inse.getCheckin_date());
			pstat.setString(2, inse.getCheckout_date());
			pstat.setString(3, inse.getBooking_status());
			pstat.setString(4, inse.getGuestName());
			pstat.setInt(5, inse.getRoomNo());
			pstat.setInt(6, inse.getUid());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
			JOptionPane.showMessageDialog(btn, " Booking was a Sucess!!");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(btn, "please try again!!");
			System.out.println("Error :" + ex.getMessage());
		}
		return result;

	}

	public boolean DeleteBook(libBook inse) {
		// declare and initialize
		boolean result = false;
		Connection conn;
		String sql = "delete from booking where uid = ? and roomID != ' ' ";
		PreparedStatement pstat;
		try {
			// sending data from textfield to sql
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, inse.getUid());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
			JOptionPane.showMessageDialog(btn, "Booking deleted");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(btn, "please try again!!");
			System.out.println("Error :" + ex.getMessage());
		}
		return result;

	}
	public boolean DeleteBookstaf(libBook inse) {
		// declare and initialize
		boolean result = false;
		Connection conn;
		String sql = "delete from booking where Booking_ID = ?";
		PreparedStatement pstat;
		try {
			// sending data from textfield to sql
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, inse.getUid());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
			JOptionPane.showMessageDialog(btn, "Booking deleted");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(btn, "please try again!!");
			System.out.println("Error :" + ex.getMessage());
		}
		return result;

	}

	public boolean saveStaff(staffLib inse) {
		// declare and initialize
		boolean result = false;
		Connection conn;
		String sql = "insert into staff(StaffID, FullName ,Gender,Address,DOB ,MobileNo,Email, StaffType) values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstat;
		try {
			// sending data from textfield to sql
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, inse.getId());
			pstat.setString(2, inse.getFullName());
			pstat.setString(3, inse.getGender());
			pstat.setString(4, inse.getAddress());
			pstat.setString(5, inse.getDOB());
			pstat.setInt(6, inse.getPhoneNo());
			pstat.setString(7, inse.getEmail());
			pstat.setString(8, inse.getStaffType());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
			JOptionPane.showMessageDialog(btn, "Welcome to Hotel Luton!!");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(btn, "please try again!!");
			System.out.println("Error :" + ex.getMessage());
		}
		return result;

	}

	public LoginLibs loginstaff(LoginLibs user) {

		String sql = "Select * from staff inner join user on user.StafId = staff.StaffID where Name = ? and Password =?";
		try {

			Connection conn = connect();
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, user.getUsername());
			pstat.setString(2, user.getPassword());
			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				user.setId(rs.getInt("UserId"));
				user.settype(rs.getString("UserType"));
			}

		}

		catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return user;
	}

	public LoginLibs loginCust(LoginLibs user) {

		String sql = "Select * from registration inner join user on \r\n"
				+ "user.CustomerId = registration.Customerid where Name = ? and Password =?; ";
		try {

			Connection conn = connect();
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, user.getUsername());
			pstat.setString(2, user.getPassword());
			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				user.setId(rs.getInt("UserId"));
				// user.setFullName(rs.getString("FullName"));
				// user.setAddress(rs.getString("Address"));
				// user.setEmail(rs.getString("Email"));
				// user.setPhoneNo(rs.getInt("PhoneNo"));
				user.settype(rs.getString("UserType"));
			}

		}

		catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return user;
	}

	public ArrayList Bookdata(BookDataLib bok1) {
		String query = "select * from Booking where roomPreference != ' ' ";
		Connection conn;
		PreparedStatement pstat;

		ArrayList search = new ArrayList();
		try {
			conn = connect();
			pstat = conn.prepareStatement(query);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				BookDataLib bok = new BookDataLib(rs.getString("Checkin_date"), rs.getString("Checkout_date"),
						rs.getString("Booking_status"), rs.getString("roomPreference"), rs.getInt("Uid"), (rs.getInt("Booking_ID")));

				search.add(bok);
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return search;
	}

	public boolean ReqService(LibServiceReq lib) {
		String sql = "insert into services(ServiceId,name,date,Quantity) values(?,?,?,?) ";
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, lib.getServiceid());
			pstat.setString(2, lib.getService());
			pstat.setString(3, lib.getDate());
			pstat.setString(4, lib.getQuantity());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
			JOptionPane.showMessageDialog(btn, "Service added successfully");
		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;

	}
	public boolean addServiceBook(LibServiceReq  lib) {
		String sql = " insert into booking (serviceId,Uid)values (? , ?)";
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, lib.getServiceid());
			pstat.setInt(2, lib.getUId());

			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
			
		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;

	}
	public boolean requpdateService(LibServiceReq lib ) {
		String sql = "update services set name = ? , date = ? , Quantity = ? where ServiceId = ? ";
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, lib.getService());
			pstat.setString(2, lib.getDate());
			pstat.setString(3, lib.getQuantity());
			
			pstat.setInt(4, lib.getServiceid());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
			JOptionPane.showMessageDialog(btn, "Service updated successfully");
		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;

	}

	
	public boolean SaveService(ServiceLib lib) {
		String sql = "update services set name = ?, type= ?, Rate = ?, Status = ?, date = ?,Quantity =  ? where ServiceId = ? ";
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, lib.getServices());
			pstat.setString(2, lib.getTypes());
			pstat.setString(3, lib.getRate());
			pstat.setString(4, lib.getStatus());
			pstat.setString(5, lib.getDate());
			pstat.setString(6, lib.getQuantity());
			
			pstat.setInt(7, lib.getServiceid());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
			JOptionPane.showMessageDialog(btn, "Service added successfully");
		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;

	}
	public LibServiceReq serviceId(LibServiceReq user) {

		String sql = "Select * from booking inner join services on Services.ServiceId = booking.serviceId where uid = ? and name= ?";
		try {

			Connection conn = connect();
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, user.getUId());
			pstat.setString(2, user.getService());
			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				user.setServiceid(rs.getInt("serviceId"));			
			}
		}

		catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return user;
	}
	public boolean deleteService(LibServiceReq lib) {
		boolean result = false;
		String sql = "DELETE  from services WHERE ServiceId = ? ";		
		Connection conn;
		PreparedStatement pstat;
		try {
			 conn = connect();
			 pstat = conn.prepareStatement(sql);
			 pstat.setInt(1, lib.getServiceid());
			 pstat.executeUpdate();
				pstat.close();
				conn.close();
				result = true;
				JOptionPane.showMessageDialog(btn, "service deleted");
		}catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;
	}
	public boolean deleteServiceinbook(LibServiceReq lib) {
		boolean result = false;
		String sql = "DELETE FROM booking WHERE serviceId = ? ";
		Connection conn;
		PreparedStatement pstat;
		try {
			 conn = connect();
			 pstat = conn.prepareStatement(sql);
			 pstat.setInt(1, lib.getServiceid());
			 pstat.executeUpdate();
				pstat.close();
				conn.close();
				result = true;
				
		}catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;
	}
	public ArrayList servicedata(ServiceLibdata lib) {
		String query = " select * from booking inner join services on services.serviceId = booking.serviceId";
		Connection conn;
		PreparedStatement pstat;

		ArrayList search = new ArrayList();
		try {
			conn = connect();
			pstat = conn.prepareStatement(query);
			
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				ServiceLibdata serve = new ServiceLibdata(rs.getInt("serviceId"), rs.getInt("Uid"),  rs.getString("name"),
						rs.getString("Status"), rs.getString("Quantity"), rs.getString("Date"));

				search.add(serve);
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return search;
	}

	public boolean ReqMenu(ReqMenuLib lib) {
		String sql = "insert into menu(MenuId, Item, date, Quantity, Menutype) values(?,?,?,?,?) ";
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, lib.getMenuid());
			pstat.setString(2, lib.getItem());
			pstat.setString(3, lib.getDate());
			pstat.setString(4, lib.getQuantiy());
			pstat.setString(5, lib.getType());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
			JOptionPane.showMessageDialog(btn, "Order successfully");
		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;

	}
	public boolean addMenuBook(ReqMenuLib   lib) {
		String sql = " insert into booking (menuid, Uid)values (? , ?)";
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, lib.getMenuid());
			pstat.setInt(2, lib.getUid());

			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
			
		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;

	}
	public ReqMenuLib menuId(ReqMenuLib user) {

		String sql = "Select * from booking inner join menu on menu.menuId = booking.menuid where uid = ? and Item= ?";
		try {

			Connection conn = connect();
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, user.getUid());
			pstat.setString(2, user.getItem());
			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				user.setMenuid(rs.getInt("menuid"));			
			}
		}

		catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return user;
	}
	public boolean requpdateMenue(ReqMenuLib lib ) {
		String sql = "update menu set Item = ? , date = ? , Quantity = ?, MenuType= ? where MenuId = ? ";
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, lib.getItem());
			pstat.setString(2, lib.getDate());
			pstat.setString(3, lib.getQuantiy());	
			pstat.setString(4, lib.getType());
			pstat.setInt(5, lib.getMenuid());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
			JOptionPane.showMessageDialog(btn, "menu updated successfully");
		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;

	}
	public boolean deleteMenu(ReqMenuLib lib) {
		boolean result = false;
		String sql = "DELETE  from menu WHERE  menuId = ? ";		
		Connection conn;
		PreparedStatement pstat;
		try {
			 conn = connect();
			 pstat = conn.prepareStatement(sql);
			 pstat.setInt(1, lib.getMenuid());
			 pstat.executeUpdate();
				pstat.close();
				conn.close();
				result = true;
				JOptionPane.showMessageDialog(btn, "service deleted");
		}catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;
	}
	public boolean deleteMenuinbook(ReqMenuLib lib) {
		boolean result = false;
		String sql = "DELETE FROM booking WHERE  menuId = ? ";
		Connection conn;
		PreparedStatement pstat;
		try {
			 conn = connect();
			 pstat = conn.prepareStatement(sql);
			 pstat.setInt(1, lib.getMenuid());
			 pstat.executeUpdate();
				pstat.close();
				conn.close();
				result = true;
				
		}catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;
	}
	public boolean SaveMenu(MenuLib lib) {
		String sql = "update menu set Item = ?, Rate= ?, MenuType= ?, Status = ?, Date = ?, Quantity =  ? where MenuId = ? ";
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, lib.getItem());
			pstat.setString(2, lib.getRate());
			pstat.setString(3, lib.getType());
			pstat.setString(4, lib.getStatus());
			pstat.setString(5, lib.getDate());
			pstat.setString(6, lib.getQuantity());		
			pstat.setInt(7, lib.getmenuId());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
			JOptionPane.showMessageDialog(btn, "Menu added successfully");
		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;

	}
	public boolean deleteMenustaf(MenuLib lib) {
		boolean result = false;
		String sql = "DELETE  from menu WHERE  menuId = ? ";		
		Connection conn;
		PreparedStatement pstat;
		try {
			 conn = connect();
			 pstat = conn.prepareStatement(sql);
			 pstat.setInt(1, lib.getmenuId());
			 pstat.executeUpdate();
				pstat.close();
				conn.close();
				result = true;
				JOptionPane.showMessageDialog(btn, "Item deleted");
		}catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;
	}
	public boolean deleteMenuinbookstaf(MenuLib lib) {
		boolean result = false;
		String sql = "DELETE FROM booking WHERE  menuId = ? ";
		Connection conn;
		PreparedStatement pstat;
		try {
			 conn = connect();
			 pstat = conn.prepareStatement(sql);
			 pstat.setInt(1, lib.getmenuId());
			 pstat.executeUpdate();
				pstat.close();
				conn.close();
				result = true;
				
		}catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;
	}
	public ArrayList menudata(MenuLibdata menu) {
		String query = "select * from booking inner join menu on booking.menuId = menu.menuId";
		Connection conn;
		PreparedStatement pstat;

		ArrayList search = new ArrayList();
		try {
			conn = connect();
			pstat = conn.prepareStatement(query);
			
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				MenuLibdata menu1 = new MenuLibdata(rs.getInt("Uid"), rs.getInt("menuid"), rs.getString("Item"),
						rs.getString("Status"), rs.getString("Quantity"),rs.getString("Date") );

				search.add(menu1);
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return search;
	}
	public ArrayList roomdata(libRoom rom1) {
		String query = "select * from room  where  roomType = ? and roomStatus =\"Available\";";
		Connection conn;
		PreparedStatement pstat;

		ArrayList search = new ArrayList();
		try {
			conn = connect();
			pstat = conn.prepareStatement(query);
			pstat.setString(1, rom1.getRoomType());
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				libRoom rom = new libRoom(rs.getInt("roomId"), rs.getString("roomPrice"), rs.getString("roomStatus"),
						rs.getString("roomType"), rs.getString("roomFacilities"));

				search.add(rom);
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return search;
	}

	public boolean saveroom(libRoom lib) {
		String sql = "insert into room(roomId,roomType,roomPrice,roomFacilities,roomStatus) values(?,?,?,?,?) ";
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, lib.getRoomNo());
			pstat.setString(2, lib.getRoomType());
			pstat.setString(3, lib.getRoomPrice());
			pstat.setString(4, lib.getFacilities());
			pstat.setString(5, lib.getRoomStatus());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			JOptionPane.showMessageDialog(btn, "Room added successfully");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return result;

	}
	
	public boolean updateroom(libRoom lib) {
		String sql = "update room set roomType =?, roomPrice = ?, roomFacilities = ?, roomStatus =?  where roomId = ?";
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);			
			pstat.setString(1, lib.getRoomType());
			pstat.setString(2, lib.getRoomPrice());
			pstat.setString(3, lib.getFacilities());
			pstat.setString(4, lib.getRoomStatus());
			pstat.setInt(5, lib.getRoomNo());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			JOptionPane.showMessageDialog(btn, "Room modified successfully");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return result;

	}
	public boolean deleteroom(libRoom lib) {
		String sql = "delete from room  where roomId = ?";
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);			
			pstat.setInt(1, lib.getRoomNo());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			JOptionPane.showMessageDialog(btn, "Room deleted successfully");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return result;

	}
	public boolean invoicestaf(BillLib lib) {
		String sql = "insert into invoice (Status,InvoiceDate,VatCharge,  Total, DetailId, bookingid) values(?,?,?,?,?,?) ";
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, lib.getStatus());
			pstat.setString(2, lib.getDate());
			pstat.setString(3, lib.getVat());
			pstat.setString(4, lib.getTotal());
			pstat.setInt(5, lib.getDetailid());
			pstat.setInt(6, lib.getBookID());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
			JOptionPane.showMessageDialog(btn, "Bill Generated");
		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;

	}
	public boolean detailstaf(BillLib lib) {
		String sql = "insert into InvoiceDetail(detailID, ItemName, ItemQuantity, ItmeRate) values(?,?,?,?) ";
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, lib.getDetailid());
			pstat.setString(2, lib.getItem());			
			pstat.setString(3, lib.getQuantity());
			pstat.setString(4, lib.getRate());			
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
			
		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;

	}
	public ReceiptLib  receiptdata(ReceiptLib lib) {
		
		String sql = "select * from Invoice i inner join InvoiceDetail id on i.DetailId = id.detailID inner join booking b on i.bookingid = b.Booking_ID where Uid = ? and ItemName = 'room' ";
		Connection conn;
		PreparedStatement pstat;
		try {
			 conn = connect();
			 pstat = conn.prepareStatement(sql);
			 pstat.setInt(1, lib.getUid());
			 ResultSet rs = pstat.executeQuery();

				while (rs.next()) {
					lib.setBilldate(rs.getString("InvoiceDate"));
					lib.setBillno(rs.getInt("Id"));
					lib.setCheckindate(rs.getString("Checkin_date"));
					lib.setCheckoutdate(rs.getString("Checkout_date"));
					lib.setName(rs.getString("guestName"));
				}		
							
		}catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return lib ;
	}
	public ArrayList receiptdata2(ReceiptLib2 lib) {
		String query = "select * from Invoice i inner join InvoiceDetail id on i.DetailId = id.detailID inner join booking b on i.bookingid = b.Booking_ID where Uid = ? ";
		Connection conn;
		PreparedStatement pstat;

		ArrayList search = new ArrayList();
		try {
			conn = connect();
			pstat = conn.prepareStatement(query);
			 pstat.setInt(1, lib.getUid());
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				ReceiptLib2 lib1 = new ReceiptLib2(rs.getInt("Id"),rs.getInt("Booking_ID")
						,rs.getString("ItemName"),rs.getString("ItemQuantity"),rs.getString("Total") );				
				search.add(lib1);
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return search;
	}
	public ArrayList billtable(Billdata lib) {
		String query = " select * from booking left join services on services.serviceId = booking.serviceId left join menu on menu.menuId = booking.menuid ";
		Connection conn;
		PreparedStatement pstat;

		ArrayList search = new ArrayList();
		try {
			conn = connect();
			pstat = conn.prepareStatement(query);
			
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				Billdata bill = new Billdata(rs.getInt("Booking_ID"), rs.getString("Quantity"),rs.getString("Item"),
						rs.getString("name"),rs.getInt("roomId"),  rs.getString("Date"));

				search.add(bill);
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return search;
	}
}
