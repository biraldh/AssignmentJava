package ConLib;

public class BookDataLib {
	 	String Checkin_date;
	    String Checkout_date;
	    String Booking_status;
	    String Preference;
	    int Uid;
	    int bookid;
		
		public BookDataLib(String checkin_date, String checkout_date, String booking_status, String preference, int uid,
				int bookid) {
			super();
			Checkin_date = checkin_date;
			Checkout_date = checkout_date;
			Booking_status = booking_status;
			Preference = preference;
			Uid = uid;
			this.bookid = bookid;
		}

		public BookDataLib() {
			
			Checkin_date = "";
			Checkout_date = "";
			Booking_status = "";
			Preference = "";
			Uid = 0;
			bookid = 0;
		}

		public String getCheckin_date() {
			return Checkin_date;
		}

		public void setCheckin_date(String checkin_date) {
			Checkin_date = checkin_date;
		}

		public String getCheckout_date() {
			return Checkout_date;
		}

		public void setCheckout_date(String checkout_date) {
			Checkout_date = checkout_date;
		}

		public String getBooking_status() {
			return Booking_status;
		}

		public void setBooking_status(String booking_status) {
			Booking_status = booking_status;
		}

		public String getPreference() {
			return Preference;
		}

		public void setPreference(String preference) {
			Preference = preference;
		}

		public int getUid() {
			return Uid;
		}

		public void setUid(int uid) {
			Uid = uid;
		}

		public int getBookid() {
			return bookid;
		}

		public void setBookid(int bookid) {
			this.bookid = bookid;
		}
	    
	    
}
