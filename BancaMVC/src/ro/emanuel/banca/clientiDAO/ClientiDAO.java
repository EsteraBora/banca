package ro.emanuel.banca.clientiDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.banca.helpers.DBHelper;
import ro.emanuel.banca.helpers.DBHelper2;
import ro.emanuel.banca.pojo.Banca;
import ro.emanuel.banca.clientiPOJO.Client;

public class ClientiDAO {
	 public static ArrayList<Client> getClient() throws SQLException {

	        String select = "select * from client";

	        Connection con = DBHelper2.getConnection();
	        
	        PreparedStatement stmt = con.prepareStatement(select);
	        ArrayList<Client> result = new ArrayList<Client>();
	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	         
	            int id = rs.getInt("id");
	            String nume = rs.getString("nume");
	            String prenume = rs.getString("prenume");
	            String cont = rs.getString("cont");
	            double sold = rs.getDouble("sold");
	            
	            Client c = new Client(id, nume, prenume, cont, sold);
	            
	            result.add(c);
	        }
	        DBHelper2.closeConnection();
	        return result;}
	        
	        public static void createClient(Client c) throws SQLException {
		        
		        String insert = "insert into client (nume,prenume, cont, sold)" + "value(?,?,?)";
               
		        
		        Connection con = DBHelper2.getConnection();

		        
		        PreparedStatement stmt = con.prepareStatement(insert);
		        stmt.setString(1, c.getNume());
		        stmt.setString(2, c.getPrenume());
		        stmt.setString(3, c.getCont());
		        stmt.setDouble(4, c.getSold());
		       
		        stmt.executeUpdate();

		        DBHelper2.closeConnection();
		    }

		    public static void updateClient(Client c) throws SQLException {

		        String update = "update client set nume = ?, prenume=?, cont=?, sold=? where id = ?";

		        Connection con = DBHelper2.getConnection();

		        PreparedStatement stmt = con.prepareStatement(update);
		        stmt.setString(1, c.getNume());
		        stmt.setString(2, c.getPrenume());
		        stmt.setString(3, c.getCont());
		        stmt.setInt(4, c.getId());
		        stmt.setDouble(5, c.getSold());
		        
		        stmt.executeUpdate();

		        DBHelper.closeConnection();
		    }

		    public static void deleteClient(Client c) throws SQLException {

		        String delete = "delete from client where nume = ?";

		        Connection con = DBHelper2.getConnection();

		        PreparedStatement stmt = con.prepareStatement(delete);
		        stmt.setString(1, c.getNume());
		 
		        stmt.executeUpdate();

		        DBHelper2.closeConnection();
		    }

		    public static Client getClientByID(int id) throws SQLException {
		        String select = "select * from client where id =?";
		        Connection con = DBHelper2.getConnection();
		        PreparedStatement stmt = con.prepareStatement(select);
		        stmt.setInt(1, id);
		        ResultSet rs = stmt.executeQuery();
		        Client result = null;
		        if (rs.next()) {
		            String nume = rs.getString("nume");
		            String prenume = rs.getString("prenume");
		            String cont = rs.getString("cont");
		            double sold = rs.getDouble("sold");
		            result = new Client(id, nume, prenume, cont, sold);
		        }
		        DBHelper.closeConnection();
		        return result;
		    }

		    public static ArrayList<Client> getClientByName(String nameQuery) throws SQLException {
		        String select = "select * from client WHERE nume LIKE ?";
		        Connection con = DBHelper2.getConnection();
		        PreparedStatement stmt = con.prepareStatement(select);
		        stmt.setString(1, '%' + nameQuery + '%');
		        ResultSet rs = stmt.executeQuery();
		        ArrayList<Client> result = new ArrayList<Client>();
		        while (rs.next()) {
		            int id = rs.getInt("id");
		            String nume = rs.getString("nume");
		            String prenume = rs.getString("prenume");
		            String cont = rs.getString("cont");
		            double sold = rs.getDouble("sold");
		            result.add(new Client(id, nume, prenume, cont, sold));
		        }
		        DBHelper2.closeConnection();
		        return result;
		    }

	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	 }
