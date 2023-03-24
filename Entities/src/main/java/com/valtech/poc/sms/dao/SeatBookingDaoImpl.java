package com.valtech.poc.sms.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public  class SeatBookingDaoImpl implements SeatBookingDao {

	@Autowired
	JdbcTemplate jdbcTemplate;


@Override
public List<Integer> getAllSeats() {
    String query = "SELECT s_id FROM seat";
    List<Integer> allSeats = jdbcTemplate.queryForList(query, Integer.class);
    return allSeats;
}
}


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
