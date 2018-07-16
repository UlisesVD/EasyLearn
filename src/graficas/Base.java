package graficas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import pojo.Acierto;

public class Base {

    Connection conn = null;
    PreparedStatement pst = null;
    Statement st = null;
    ResultSet rs = null;

    public Base() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void openConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/escuela2", "root", "root");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void closedConnection() {
        try {
            pst.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<String> obtenerTemas() {
        ArrayList<String> listaTemas = new ArrayList();
        try {
            openConnection();
            String sql = "SELECT nom_tem FROM tema ";

            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();

            while (rs.next()) {
                listaTemas.add(rs.getString("nom_tem"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closedConnection();
        }
        return listaTemas;
    }
    
    public ArrayList<Acierto> obtenerAciertos(String tema, String grupo) {
        ArrayList<Acierto> listaTemas = new ArrayList();
        try {
            openConnection();
            String sql = "select nom_per, ap_per, am_per, COUNT(nom_per) as acierto from persona as per join \n" +
            "alumno as al on al.cve_per = per.cve_per\n" +
            "join respuesta as re on re.cve_alu = al.cve_alu join pregunta as pr on \n" +
            "pr.cve_pre = re.cve_pre join tema as tm on tm.cve_tem = pr.cve_tem join\n" +
            "grupo_alumno as ga on al.cve_alu = ga.cve_alu join \n" +
            "grupo as gr on ga.cve_gru=gr.cve_gru \n" +
            "where respuesta_correcta_pre = resp_res and nom_tem = '"+tema+"' \n" +
            "and grupo_gru = '"+grupo+"' GROUP BY nom_per";

            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();

            while (rs.next()) {
                Acierto acierto = new Acierto(rs.getString("nom_per")+" "+rs.getString("ap_per")+" "+rs.getString("am_per"),rs.getInt("acierto"));
                listaTemas.add(acierto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closedConnection();
        }
        return listaTemas;
    }
    
    

}
