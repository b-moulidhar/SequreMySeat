package com.valtech.poc.sms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.valtech.poc.sms.entities.Seat;

@Component
@ComponentScan
public    class SeatBookingDaoImpl implements SeatBookingDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

//
@Override
public List<Integer> getAllSeats() {
    String query = "SELECT s_id FROM seat";
    List<Integer> allSeats = jdbcTemplate.queryForList(query, Integer.class);
    return allSeats;
    // fetching all the available seats
}

@Override
 public List<Integer> availableSeats() {
	String query = "SELECT sb_id FROM seats_booked WHERE current = 0";
    List<Integer> availableSeats = jdbcTemplate.queryForList(query, Integer.class);
    return availableSeats;
    // fetching the seats which are booked
}


@Override
public  List<Integer> countTotalSeats() {
    String query = "SELECT COUNT(*) FROM seat";
    List<Integer> totalSeats = jdbcTemplate.queryForList(query, Integer.class);
    return totalSeats;
}



}
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
