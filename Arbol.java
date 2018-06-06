
public class Arbol {
    private int n;
    private int tope;
    private Object pila[];
    
    public Arbol(int n) {
        this.n = n;
        tope = 0;
        pila = new Object[n];
        
    }
    
    public boolean estaVacia(){
        return tope == 0;         
                
    }
    
    public boolean estaLlena(){
        return tope == n;
        
    }
    
    public boolean apilar(Object dato){
        if(estaLlena()){
            return false;
        }
        pila [tope] = dato;
        tope++;
        return true;
        
        
    }
    public Object desapilar(){
        if(estaVacia()) {
            return null;
        }
        tope--;
        return pila[tope];
        
    }
    public Object elementoTope(){
        return pila[tope - 1];
        
    }
    
    
}

