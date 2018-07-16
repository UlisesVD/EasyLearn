package Conection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import pojo.Alumno;
import pojo.Grupo;
import pojo.Maestro;
import pojo.Pregunta;
import pojo.Respuesta;
public class Base {
    Connection conn = null;
    PreparedStatement pst = null;
    PreparedStatement pst2 = null;
    PreparedStatement pst3 = null;
    Statement st = null;
    ResultSet rs = null;
    private String cvePer=null;
    private String cveAlu=null;
    private String cveGrupo=null;
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
    public ArrayList<Pregunta> loadQuestions(String tema){
        ArrayList<Pregunta> preguntas = new ArrayList();
        try {
            openConnection();
            String sql = "select cve_pre, pregunta_pre, respuesta_correcta_pre, respuesta_incorrecta1_pre, respuesta_incorrecta2_pre"
                    + " from pregunta as p join tema as t on t.cve_tem = p.cve_tem  "
                    + "where nom_tem = ?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, tema);

            rs = pst.executeQuery();

            while (rs.next()) {
                //datos del objeto base
                int clave = rs.getInt("cve_pre");
                String ask = rs.getString("pregunta_pre");
                String respuestaC = rs.getString("respuesta_correcta_pre");
                String respuestaI1 = rs.getString("respuesta_incorrecta1_pre");
                String respuestaI2 = rs.getString("respuesta_incorrecta2_pre");
                
                Pregunta pregunta = new Pregunta(clave, ask, respuestaC, respuestaI1, respuestaI2);
                
                
                preguntas.add(pregunta);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closedConnection();
        }
        
        return preguntas;
    }
    public void inserta(Alumno alum){
        System.out.println(alum);
        try {
            this.openConnection();
             
            String insertaPersona="insert into persona values (null,?,?,?,?,?)";
            String insertaAlumno="insert into alumno values (null,?,?)";
            String insertaGrupo="insert into grupo_alumno values (null,?,?)";
            
            pst=conn.prepareStatement(insertaPersona);
            
            pst.setString(1, alum.getAp());
            pst.setString(2, alum.getAm());
            pst.setString(3, alum.getNombre());
            pst.setString(4, alum.getSexo());
            pst.setString(5, alum.getEdad());
            System.out.println(pst);
            pst.executeUpdate();
            
            String getCvePersona="select max(cve_per) from persona";
            pst=conn.prepareStatement(getCvePersona);
            rs=pst.executeQuery(getCvePersona);
            System.out.println(pst);
            if(rs.next()){
            cvePer=rs.getString("max(cve_per)");
            }
            
            String getCveGrupo="select cve_gru from grupo where grupo_gru='"+alum.getGrupo()+"'";
            pst=conn.prepareStatement(getCveGrupo);
            rs=pst.executeQuery(getCveGrupo);
            if(rs.next()){
            cveGrupo=rs.getString("cve_gru");
            }
            
            pst=conn.prepareStatement(insertaAlumno);
            
            pst.setString(1, cvePer);
            pst.setString(2, alum.getContraseña());
            
            pst.executeUpdate();
            
            String getCveAlumno="select max(cve_alu) from alumno";
            pst=conn.prepareStatement(getCveAlumno);
            rs=pst.executeQuery(getCveAlumno);
            System.out.println(pst);
            if(rs.next()){
            cveAlu=rs.getString("max(cve_alu)");
            }
            
            pst=conn.prepareStatement(insertaGrupo);
            
            pst.setString(1, cveAlu);
            pst.setString(2, cveGrupo);
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Alumno registrado con exito");
            
            cvePer=null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al insertar "+e);
         } finally {
            closedConnection();
        }
    }
    public Alumno getAlumno(Alumno alum){
    Alumno alum2 = new Alumno();
     try {
            openConnection();
            String getAlum="select * from alumno join persona join grupo_alumno join grupo on persona.cve_per = alumno.cve_per and"
                    + " grupo_alumno.cve_alu=alumno.cve_alu and grupo_alumno.cve_gru=grupo.cve_gru where nom_per='"+alum.getNombre()+
                    "' and ap_per='"+alum.getAp()+"' and am_per='"+alum.getAm()+"' and contra_alu='"+alum.getContraseña()+"'";
            pst = conn.prepareStatement(getAlum);
            rs = pst.executeQuery();
            while (rs.next()) {
                alum2 = new Alumno(rs.getString("nom_per"),rs.getString("ap_per"), rs.getString("am_per"), null, null,
                        rs.getString("contra_alu"),rs.getString("grupo_gru"),rs.getInt("cve_alu"));  
                System.out.println(alum2);
            }
            System.out.println(alum2);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closedConnection();
        }
        return alum2;
    }
    public boolean saveAnswers(Respuesta respuesta,int clave){
        try {
            System.out.println(clave);
            openConnection();
            String sql = "insert into respuesta values(null, ?, ?, ?,curdate())";
            pst = conn.prepareStatement(sql);
            pst.setString(1,respuesta.getRespuesta());
            pst.setInt(2, clave);
            pst.setInt(3, respuesta.getClavePegunta());
            pst.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            closedConnection();
        }
    }
    public int getAnswers(int cve,String tema){
        try {
            int cant=0;
            openConnection();
            String sql = "select nom_per, ap_per, am_per, COUNT(nom_per)as asiertos from respuesta as r join " +
            "  pregunta as pr on pr.cve_pre= r.cve_pre join tema as t on t.cve_tem = pr.cve_tem join alumno as al on " +
            "  r.cve_alu join persona as p on p.cve_per = al.cve_per = al.cve_alu " +
            "  where respuesta_correcta_pre = resp_res and nom_tem = '"+tema+"' and r.cve_alu="+cve+" GROUP BY p.cve_per;";
            pst = conn.prepareStatement(sql);
            
            rs = pst.executeQuery();
            
            if(rs.next()) {
                cant=rs.getInt("asiertos");
            }
            return cant;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            closedConnection();
        }
        
    }
    
    
    public ArrayList<Grupo> obtenerGrupos() {
        ArrayList<Grupo> listaGrupo = new ArrayList();
        try {
            openConnection();
            String sql = "SELECT cve_gru, grupo_gru FROM grupo ";

            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();

            while (rs.next()) {
                Grupo grupo = new Grupo(rs.getInt("cve_gru"),rs.getString("grupo_gru"));
                listaGrupo.add(grupo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closedConnection();
        }
        return listaGrupo;
    }
    
    public void insertarMaestro(Maestro maestro, String grupo){
        try {
            openConnection();
            String sql = "insert into persona values (null,?,?,?,?,?)";
            String sql2 = "insert into maestro values (null,?,?) ";
            String sql3 = "insert into grupo values (null,?,?)";

            conn.setAutoCommit(false);
            //Preparamos las sentencias
            pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst2 = conn.prepareStatement(sql2, PreparedStatement.RETURN_GENERATED_KEYS);
            pst3 = conn.prepareStatement(sql3);

            //Registramos a la persona
            pst.setString(1, maestro.getAp());
            pst.setString(2, maestro.getAm());
            pst.setString(3, maestro.getNombre());
            pst.setString(4, maestro.getSexo().substring(0,1));
            pst.setString(5, maestro.getEdad());

            pst.executeUpdate();

            //Obtenemos el clave que se genero al registrar a la persona
            ResultSet clavePer = pst.getGeneratedKeys();
            clavePer.next();
            int cve_per = clavePer.getInt(1);
            clavePer.close();
            pst.close();

            //Registramos al maestro
            pst2.setInt(1, cve_per);
            pst2.setString(2, maestro.getContraseña());
            pst2.executeUpdate();

            //Optener clave de maestro
            ResultSet claveMaestro = pst2.getGeneratedKeys();
            claveMaestro.next();
            int cve_maes = claveMaestro.getInt(1);
            claveMaestro.close();

            pst3.setString(1, grupo);
            pst3.setInt(2, cve_maes);
            
            pst3.executeUpdate();

            conn.commit();
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                ex.printStackTrace();
            }
            ex.printStackTrace();
        } finally {
            try {
                if (pst2 != null) {
                    pst2.close();
                }
                if (pst3 != null) {
                    pst3.close();
                }
                closedConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public boolean checarExistenciaMaestro(String fullName, String pass, String grupo){
        
        try {
            openConnection();
            StringTokenizer st = new StringTokenizer(fullName);
            String nombre = st.nextToken();
            String ap = st.nextToken();
            String am = st.nextToken();
            String sql = "select nom_per, ap_per, am_per, grupo_gru from persona as p join maestro as m on m.cve_per = "
                    + " p.cve_per join grupo as g on g.cve_mae = m.cve_mae where nom_per = '"+nombre+"' and ap_per = '"+ap+"' "
                    + " and am_per = '"+am+"' and grupo_gru = '"+grupo+"' and contra_mae = '"+pass+"'";

            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();

            while (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closedConnection();
        }
        
        return false;
    }
}