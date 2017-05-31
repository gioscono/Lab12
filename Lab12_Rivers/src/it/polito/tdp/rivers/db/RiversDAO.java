package it.polito.tdp.rivers.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.rivers.model.Flow;
import it.polito.tdp.rivers.model.River;


public class RiversDAO {
	

	
	
	public List<River> getAllRivers() {

		final String sql = "SELECT * FROM river";
		List<River> rivers = new ArrayList<River>();
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				River r = new River(rs.getInt("id"), rs.getString("name"));
				rivers.add(r);
				
			}
			
			conn.close();
			return rivers;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
	
	
	public List<Flow> getAllFlow(River r){
		
		final String sql = "Select * "+
				           "from flow "+
				           "where flow.river=? "+
				           "order by DATE(day)";
		
		List<Flow> misurazioni = new ArrayList<Flow>();
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setInt(1, r.getRiverId());
			
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Flow f = new Flow(rs.getInt("id"), rs.getDate("day").toLocalDate(), rs.getFloat("flow"), rs.getInt("river"));
				misurazioni.add(f);
				
			}
			
			conn.close();
			return misurazioni;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
	}

}
	
	


