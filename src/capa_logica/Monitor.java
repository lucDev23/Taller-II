package capa_logica;

import java.io.Serializable;

public class Monitor implements Serializable {
	
	private static final long serialVersionUID = 1L;
    private int lectores;
    private boolean alguienEscribe;
    
    private static Monitor monitor;
    
    private Monitor() {
        lectores = 0;
        alguienEscribe = false;
    }
    
    public static Monitor getMonitor() {
    	if (monitor == null)
    		monitor = new Monitor();
    	return monitor;
    }
    
    public synchronized void comienzoLectura() {
        if(alguienEscribe) {                                     
        	try {                                                      
        		this.wait();
            } catch(InterruptedException e) {    
            	
            }
        }
        lectores++;
    }
    
    public synchronized void terminoLectura() {
    	lectores--;
        if(lectores == 0) 
        	this.notify();
    }
    
    public synchronized void comienzoEscritura() {
        if(alguienEscribe || lectores > 0) {                
            try {
                this.wait();
            } catch(InterruptedException e) {
            	
            }
        }
        alguienEscribe = true;
    }
    
    public synchronized void terminoEscritura() {
    	alguienEscribe = false;                           
        this.notify();
    }
    
}	
