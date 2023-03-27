package com.valtech.poc.sms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.valtech.poc.sms.entities.Employee;
import com.valtech.poc.sms.entities.Seat;
import com.valtech.poc.sms.entities.SeatsBooked;
import com.valtech.poc.sms.repo.SeatRepo;

@Component
public class SeatBookingDaoImpl implements SeatBookingDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	SeatRepo seatRepo;

	@Override
	public List<Integer> getAllSeats() {
		String query = "SELECT s_id FROM seat";
		List<Integer> allSeats = jdbcTemplate.queryForList(query, Integer.class);
		return allSeats;
		// fetching all the available seats
	}

	@Override
	public List<Integer> availableSeats() {
		String query = "SELECT sb_id FROM seats_booked WHERE current = 1";
		List<Integer> availableSeats = jdbcTemplate.queryForList(query, Integer.class);
		return availableSeats;
		// fetching the seats which are booked
	}

	@Override
	public List<SeatsBooked> findAllByEId(Employee emp) {
		String query = "select * from seats_booked where e_id = ?";
		int empId = emp.geteId();
		@SuppressWarnings("deprecation")
		List<SeatsBooked> seatsBooked = jdbcTemplate.query(query, new Object[] { empId },
				new ResultSetExtractor<List<SeatsBooked>>() {
					public List<SeatsBooked> extractData(ResultSet rs) throws SQLException, DataAccessException {
						List<SeatsBooked> list = new ArrayList<SeatsBooked>();
						while (rs.next()) {
							SeatsBooked seatsBooked = new SeatsBooked();
							int seatId = rs.getInt("s_id");
							Seat seat = seatRepo.findById(seatId).get();
							seatsBooked.setsId(seat);
//					seatsBooked.setEmpName(rs.getString("emp_name"));
							seatsBooked.seteId(emp);
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
							String sbDate = rs.getString("punch_in");
							LocalDateTime dateTime = LocalDateTime.parse(sbDate, formatter);
							seatsBooked.setSbDate(dateTime);
							list.add(seatsBooked);
						}
						return list;
					}

				});
		return seatsBooked;
	}

	@Override
	public SeatsBooked findCurrentSeat(Employee emp) {
		
		return null;
	}

}
//@Override
//
//public List<Seat> findByBooked(boolean booked) {
//    String sql = "SELECT * FROM seats WHERE booked = ?";
//    return jdbcTemplate.query(sql, new SeatRowMapper(), !booked);
//}
//
//
//
//
//
//private class SeatRowMapper implements RowMapper {
//    public Seat mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Seat seat = new Seat();
//        seat.setsId(rs.getLong("id"));
//        seat.setNumber(rs.getInt("number"));
//        seat.setBooked(rs.getBoolean("booked"));
//        return seat;
//    }
//}

//@Override
//public List<Seat> findByBooked(boolean booked) {
//    String sql = "SELECT * FROM seats WHERE booked = ?";
//    return jdbcTemplate.query(sql, new SeatRowMapper(), !booked);
//}
//
//private class SeatRowMapper implements RowMapper<Seat> {
//    @Override
//    public Seat mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Seat seat = new Seat();
//        seat.setId(rs.getLong("id"));
//        seat.setNumber(rs.getInt("number"));
//        seat.setBooked(rs.getBoolean("booked"));
//        return seat;
//    }
//}
//}

//@Repository
//public class SeatRepositoryImpl implements SeatRepository {
//    private final JdbcTemplate jdbcTemplate;
//
//    public SeatRepositoryImpl(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Override
//    public List<Seat> findByBooked(boolean booked) {
//        String sql = "SELECT * FROM seats WHERE booked = ?";
//        return jdbcTemplate.query(sql, new SeatRowMapper(), booked);
//    }
//}
//
//class SeatRowMapper implements RowMapper<Seat> {
//    @Override
//    public Seat mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Seat seat = new Seat();
//        seat.setId(rs.getLong("id"));
//        seat.setNumber(rs.getInt("number"));
//        seat.setBooked(rs.getBoolean("booked"));
//        return seat;
//    }
//}

//@Repository
//public class SeatBookingDAOImpl implements SeatBookingDAO {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    public SeatBookingDAOImpl(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Override
//    public int bookSeat(int seatNumber) {
//        String sql = "UPDATE seats SET booked = true WHERE seat_number = ?";
//        return jdbcTemplate.update(sql, seatNumber);
//    }
//
//    @Override
//    public int unbookSeat(int seatNumber) {
//        String sql = "UPDATE seats SET booked = false WHERE seat_number = ?";
//        return jdbcTemplate.update(sql, seatNumber);
//    }
//
//    @Override
//    public List<Integer> getBookedSeats() {
//        String sql = "SELECT seat_number FROM seats WHERE booked = true";
//        return jdbcTemplate.queryForList(sql, Integer.class);
//    }
//
//    @Override
//    public int countBookedSeats() {
//        String sql = "SELECT COUNT(*) FROM seats WHERE booked = true";
//        return jdbcTemplate.queryForObject(sql, Integer.class);
//    }
//}
