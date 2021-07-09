package com.eoi.modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.eoi.servicios.conexion;
public class DAO {
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	Statement st;
	//crear un animal nuevo en sql
	public void AltaAnimal(Animales a) throws SQLException {
		String sql = "INSERT INTO Animales (AnimalNombre,AnimalTipo,AnimalEdad,AnimalId,AnimalRaza,AnimalSexo) values (?,?,?,?,?,?)";
		con= conexion.getInstance().getConnection();
		pst=con.prepareStatement(sql);
		pst.setString(1,a.getAnimalNombre());
		pst.setString(2,a.getAnimalTipo());
		pst.setString(3,a.getAnimalEdad());
		pst.setInt(4,a.getAnimalId());
		pst.setString(5,a.getAnimalRaza());
		pst.setString(6,a.getAnimalSexo());
		
		pst.executeUpdate();
		pst.close();
		con.close();
		
		
	}
	//borramos un anuncio
	public void BorraAnimal(int AnimalId) throws SQLException {
		String sql = "DELETE * FROM Animales WHERE AnimalId=?";
		con= conexion.getInstance().getConnection();
		pst=con.prepareStatement(sql);
		pst.setInt(1,AnimalId);
		pst.executeUpdate();
		pst.close();
		con.close();
	}
	//vamos a modificar
	public void ModificarAnimal (Animales a) throws SQLException {
		String sql = "UPDATE Animales SET AnimalNombre=?,AnimalTipo=?,AnimalEdad=?,AnimalRaza=?,AnimalSexo=? WHERE AnimalId=?";
		con= conexion.getInstance().getConnection();
		pst=con.prepareStatement(sql);
		pst.setString(1,a.getAnimalNombre());
		pst.setString(2,a.getAnimalTipo());
		pst.setString(3,a.getAnimalEdad());
		pst.setInt(4,a.getAnimalId());
		pst.setString(5,a.getAnimalRaza());
		pst.setString(6,a.getAnimalSexo());
		
		pst.executeUpdate();
		pst.close();
		con.close();
	}
	
	public void ReservaAnimal ( int IdUsuario, int AnimalId) throws SQLException{
		String sql = "UPDATE animales SET AnimalEstado='Reservado',IdUsuario = ? WHERE AnimalId=?";
		
		con= conexion.getInstance().getConnection();
		pst=con.prepareStatement(sql);
		pst.setInt(1,IdUsuario);
		pst.setInt(2,AnimalId);
		
		pst.executeUpdate();
		pst.close();
		con.close();
		
	}
	public List<Animales> SeleccionarAnimales (String AnimalTipo) {
		List<Animales> listaAnimales=new ArrayList<Animales>();
		Animales a;
		
		String sql = "Select * From animales";
		String sql2="Select * from animales where AnimalTipo=?";
		try {
			con= conexion.getInstance().getConnection();
			if(AnimalTipo.equals("todos")) {
				st=con.createStatement();
				rs=st.executeQuery(sql);
			}else {
				pst=con.prepareStatement(sql2);
				pst.setString(1, AnimalTipo);
				rs=pst.executeQuery();
			}
			while(rs.next()) {
				a=new Animales(rs.getString("AnimalNombre"),rs.getString("AnimalTipo"),rs.getString("AnimalEdad"),rs.getInt("AnimalId"),rs.getString("AnimalRaza"),rs.getString("AnimalSexo"),rs.getString("AnimalAlta"),rs.getString("AnimalPath"),rs.getString("AnimalCiudad"),rs.getString("AnimalEstado"));
				listaAnimales.add(a);
			}
			rs.close();
			if(AnimalTipo.equals("todos")) {
				
				st.close();
			}else {
				pst.close();
			}
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listaAnimales;
	}
	public Animales DescripcionAnimal (int AnimalId) throws SQLException{
		String sql = "Select * from animales where AnimalId=?";
		Animales a=new Animales(); 
		ResultSet rs= null;
		con= conexion.getInstance().getConnection();
		pst=con.prepareStatement(sql);
		pst.setInt(1,AnimalId);
		rs=pst.executeQuery();
		while(rs.next()) {
			a.setAnimalId(rs.getInt("AnimalId"));
			a.setAnimalNombre(rs.getString("AnimalNombre"));
			a.setAnimalTipo(rs.getString("AnimalTipo"));
			a.setAnimalEdad(rs.getString("AnimalEdad"));
			a.setAnimalRaza(rs.getString("AnimalRaza"));
			a.setAnimalSexo(rs.getString("AnimalSexo"));
			a.setAnimalAlta(rs.getString("AnimalAlta"));
			a.setAnimalPath(rs.getString("AnimalPath"));
			a.setAnimalCiudad(rs.getString("AnimalCiudad"));
			
			a.setAnimalEstado(rs.getString("AnimalEstado"));
			
		}
		rs.close();
		pst.close();
		con.close();
		
		return a;
		
	}
	}