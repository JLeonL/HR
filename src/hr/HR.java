/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author usuario
 */
public class HR {

    //Region
    
    public int insertarRegion(Region region){
        return 0;
    }
    
    
    public int borrarRegion(int regionId){
        return 0;
    }
    
    public int modificarRegion(int regionId, Region region){
        return 0;
    }
    
    public Region leerRegion(int regionId){
        return null;
    }
    
    public ArrayList<Region> leerRegions(){
        return null;
    }
    
    //Country
    
    public int insertarCountry(Country country) throws ExcepcionHR{
        //sentencias preparadas
        return 0;
    }
    
    
    public int borraCountry(String countryId) throws ExcepcionHR{
        String dml = "";
        int registrosAfectados=0;
         try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "HR", "kk");
            String llamada = "call BORRAR_COUNTRY(?)";
            CallableStatement sentenciaLlamable = conexion.prepareCall(llamada);
            
            sentenciaLlamable.setString(1, countryId);
            registrosAfectados=sentenciaLlamable.executeUpdate();
            
            sentenciaLlamable.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Error - Clase no Encontrada: " + ex.getMessage());
        } catch (SQLException ex) {
            ExcepcionHR excepcionHR=new ExcepcionHR(ex.getErrorCode(),ex.getMessage(),null,dml);
            switch (ex.getErrorCode()) {
                case 2292:  excepcionHR.setMensajeErrorUsuario("No se puede borrar porque tiene localidades asociadas");
                            break;
                default:    excepcionHR.setMensajeErrorUsuario("Error general del sistema. Consulte con el administrador.");
                            break;
            }
            throw excepcionHR;
        }
        return registrosAfectados;
    }
    
    public int modificarCountry(String countryId, Country country){
        return 0;
    }
    
    public Country leerCountry(String countryId){
        return null;
    }
    
    public ArrayList<Country> leerCountrys(){
        return null;
    }
    
    //Location
    
    public int insertarLocation(Location location){
        return 0;
    }
    
    
    public int borrarLocation(int locationId){
        return 0;
    }
    
    public int modificarLocation(int locationId, Location location){
        return 0;
    }
    
    public Country leerLocation(int locationId){
        return null;
    }
    
    public ArrayList<Location> leerLocations(){
        return null;
    }
    
    //Department
    
    public int insertarDepartment(Department department){
        return 0;
    }
    
    
    public int borrarDepartment(int departmentId){
        return 0;
    }
    
    public int modificarDepartment(int departmentId, Department department) throws ExcepcionHR{
        
        String dml = "";
        int registrosAfectados=0;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "HR", "kk");
            Statement sentencia = conexion.createStatement();

            dml = "update DEPARTMENTS set "
                    + "DEPARTMENT_ID="+department.getDepartmentId()+","
                    + "DEPARTMENT_NAME='"+department.getDepartmentName()+"',"
                    + "MANAGER_ID="+department.getManager().getEmployeeId()+","
                    + "LOCATION_ID="+department.getLocation().getLocationId()+" "
                    + "where DEPARTMENT_ID="+departmentId;
            
            registrosAfectados = sentencia.executeUpdate(dml);

                    
            sentencia.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Error - Clase no Encontrada: " + ex.getMessage());
        } catch (SQLException ex) {
            ExcepcionHR excepcionHR = new ExcepcionHR(ex.getErrorCode(),ex.getMessage(),null,dml);
            switch (ex.getErrorCode()) {
                case 2291:  
                    excepcionHR.setMensajeErrorUsuario("La localidad elegida no existe o el jefe de departamento no es un empleado de la empresa");
                        break;
                            
                case 1407:  
                    excepcionHR.setMensajeErrorUsuario("El identidicador de departamento y el nombre de departamento son obligatorios");
                        break;
                            
                case 2292:  
                    excepcionHR.setMensajeErrorUsuario("No se puede modificar el identificador de departamento ya que tiene empleados asociados o datos historicos asociados");
                        break;
                            
                case 1:     
                    excepcionHR.setMensajeErrorUsuario("El identificador de departamento ya existe");
                        break;
                            
                default:    
                    excepcionHR.setMensajeErrorUsuario("Error general del sistema. Consulte con el administrador");
                        break;
            }
            throw excepcionHR;
        }
        
        return registrosAfectados;
    }
    
    public Country leerDepartment(int departmentId){
        return null;
    }
    
    public ArrayList<Department> leerDepartments(){
        return null;
    }
    
    //Employee
    
    public int insertarEmployee(Employee employee){
        return 0;
    }
    
    
    public int borrarEmployee(int employeeId){
        return 0;
    }
    
    public int modificarEmployee(int employeeId, Employee employee){
        return 0;
    }
    
    public Country leerEmployee(int employeeId){
        return null;
    }
    
    public ArrayList<Employee> leerEmployees(){
        return null;
    }
    
    //Job
    
    public int insertarJob(Job job){
        return 0;
    }
    
    
    public int borrarJob(String jobId){
        return 0;
    }
    
    public int modificarJob(String jobId, Job job){
        return 0;
    }
    
    public Country leerJob(String jobId){
        return null;
    }
    
    public ArrayList<Job> leerJobs(){
        return null;
    }
    
    //JobHistory
    
    public int insertarJobHistory(JobHistory jobHistory){
        return 0;
    }
    
    
    public int borrarJobHistory(int employeeId, Date startDate){
        return 0;
    }
    
    public int modificarJobHistory(int employeeId, Date startDate, JobHistory jobHistory){
        return 0;
    }
    
    public Country leerJobHistory(int employeeId, Date startDate){
        return null;
    }
    
    public ArrayList<JobHistory> leerJobHistorys(){
        return null;
    }
}
