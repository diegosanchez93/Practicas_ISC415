/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ClasesGeneradas;

/**
 *
 * @author jordani-vaio
 */
public class Usuario {
    private String usuarioid;
    private String clave;
    private String nombre;
    private String apellido;
    
    /**
     * 
     * @param ussuarioid
     * @return 
     */
    public String getUsuarioid(String ussuarioid){
        return ussuarioid;
    }
    
    /**
     * 
     * @param usuarioid 
     */
    public void setUsuarioid(String usuarioid){
        this.usuarioid = usuarioid;
    }
    
    /**
     * 
     * @param clave
     * @return 
     */
    public String getClave(String clave){
        return clave;
    }
    
    /**
     * 
     * @param clave 
     */
    public void setClave(String clave){
        this.clave = clave;
    }
    
    /**
     * 
     * @param nombre
     * @return 
     */
    public String getNombre(String nombre){
        return nombre;
    }
    
    /**
     * 
     * @param nombre 
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    /**
     * 
     * @param apellido
     * @return 
     */
    public String getApellido(String apellido){
        return apellido;
    }
    
    /**
     * 
     * @param apellido 
     */
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
}
