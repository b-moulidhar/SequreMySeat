package com.valtech.poc.sms.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.valtech.poc.sms.entities.Employee;
import com.valtech.poc.sms.entities.Seat;
import com.valtech.poc.sms.entities.SeatsBooked;
import com.valtech.poc.sms.repo.SeatRepo;

@Component
@ComponentScan
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
//

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
							String sbSDate = rs.getString("punch_in");
							LocalDateTime dateTime = LocalDateTime.parse(sbSDate, formatter);
							seatsBooked.setSbStartDate(dateTime);
							String sbEDate = rs.getString("punch_in");
							LocalDateTime dateTime1 = LocalDateTime.parse(sbEDate, formatter);
							seatsBooked.setSbEndDate(dateTime1);
							list.add(seatsBooked);
						}
						return list;
					}

				});
		return seatsBooked;
	}

	@SuppressWarnings("deprecation")
	@Override
	public SeatsBooked findCurrentSeat(Employee emp) {
		int empId = emp.geteId();
		String query = "select code from seats_booked where current = 1 and e_id = ?";
		return jdbcTemplate.queryForObject(query,new Object[]{empId},
		        new RowMapper<SeatsBooked>() {
        	public SeatsBooked mapRow(ResultSet rs, int rowNum) throws SQLException {
        		SeatsBooked seatsBooked = new SeatsBooked();
//                employee.setEmpName(rs.getString("emp_name"));
        		seatsBooked.seteId(emp);
        		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
				String sbDate = rs.getString("punch_in");
				LocalDateTime dateTime = LocalDateTime.parse(sbDate, formatter);
				seatsBooked.setSbStartDate(dateTime);
				String sbEDate = rs.getString("punch_in");
				LocalDateTime dateTime1 = LocalDateTime.parse(sbEDate, formatter);
				seatsBooked.setSbEndDate(dateTime1);
                return seatsBooked;
            }
			
        });
	}

	@Override
	public List<Integer> countTotalSeats() {
		String query = "SELECT COUNT(*) FROM seat";
		List<Integer> totalSeats = jdbcTemplate.queryForList(query, Integer.class);
		return totalSeats;
	}
  
	@SuppressWarnings("deprecation")
	@Override
	public List<Seat> findAvailableSeatsByDate(LocalDate date) {
	    String query = "SELECT s.s_id, s.s_name " +
	            "FROM seat s " +
	            "WHERE s.s_id NOT IN ( " +
	            "   SELECT sb.s_id " +
	            "   FROM seats_booked sb " +
	            "   WHERE DATE(sb.sb_date) = ? AND sb.current = true" +
	            ")";
		List<Seat> availableSeats = jdbcTemplate.query(query, new Object[]{date}, new BeanPropertyRowMapper<>(Seat.class));
	    return availableSeats;
	    // returns all the seats that are not booked on the given date. 
	}

}

//public List<Map<String, Object>> getSeatBookingsByEmpId(int empId) throws SQLException {
//    String sql = "SELECT s.s_name, sb.* " +
//                 "FROM seat s " +
//                 "JOIN seats_booked sb ON s.s_id = sb.s_id " +
//                 "WHERE sb.e_id = (SELECT e_id FROM employee WHERE emp_id = ?)";
//    try (Connection conn = dataSource.getConnection();
//         PreparedStatement stmt = conn.prepareStatement(sql)) {
//        stmt.setInt(1, empId);
//        try (ResultSet rs = stmt.executeQuery()) {
//            List<Map<String, Object>> results = new ArrayList<>();
//            ResultSetMetaData meta = rs.getMetaData();
//            int numColumns = meta.getColumnCount();
//            while (rs.next()) {
//                Map<String, Object> row = new HashMap<>();
//                for (int i = 1; i <= numColumns; i++) {
//                    String column = meta.getColumnName(i);
//                    Object value = rs.getObject(i);
//                    row.put(column, value);
//                }
//                results.add(row);
//            }
//            return results;
//        }
//    }
//}

//select s.*
//from seat s
//left join seats_booked sb on s.s_id = sb.s_id
//where sb.s_id IS NULL;
//
//}
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

//public List<Map<String, Object>> getSeatBookingsByEmployeeId(int employeeId) throws SQLException {
//    String sql = "SELECT s.s_name, sb.* " +
//                 "FROM seat s " +
//                 "JOIN seats_booked sb ON s.s_id = sb.s_id " +
//                 "WHERE sb.e_id = ?";
//    try (Connection conn = getConnection();
//         PreparedStatement stmt = conn.prepareStatement(sql)) {
//        stmt.setInt(1, employeeId);
//        try (ResultSet rs = stmt.executeQuery()) {
//            List<Map<String, Object>> results = new ArrayList<>();
//            ResultSetMetaData meta = rs.getMetaData();
//            int numColumns = meta.getColumnCount();
//            while (rs.next()) {
//                Map<String, Object> row = new HashMap<>();
//                for (int i = 1; i <= numColumns; i++) {
//                    String column = meta.getColumnName(i);
//                    Object value = rs.getObject(i);
//                    row.put(column, value);
//                }
//                results.add(row);
//            }
//            return results;
//        }
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
