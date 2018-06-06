import java.util.Scanner;
public class Nodo {            
    
    public static double evaluar(String infija, String infija1){
        String prefija= convertirpre(infija1);
        String posfija = convertirpos(infija);
        System.out.println("La expresión posfija es: " + posfija);
        System.out.println("La expresión infija es: " + infija);  
        System.out.println("La expresión prefija es: " + prefija);
        
        return evaluar(posfija);
        
    }    
    
    private static String convertirpre(String infija) {
       String prefija = "";
       Arbol pila = new Arbol(infija.length());
       for (int i = 0; i < infija.length(); i++){
           char letra = infija.charAt(i);
           if(!esOperador(letra)){
               if(pila.estaVacia()){
                   pila.apilar(letra);
               }else{
                   int pe = prioridadEnExpresion(letra);
                   int pp = prioridadEnPila((char)pila.elementoTope());  
               if(pe > pp){
                    pila.apilar(letra);
               }else{
                   prefija += pila.desapilar();
                   pila.apilar(letra);
               }
            }
           }else{
               prefija += letra;
               
           }
         }
       while(!pila.estaVacia()){
           prefija += pila.desapilar();
       }
       return prefija;
       
     }
    
    private static String convertirpos(String infija) {
       String posfija = "";
       Arbol pila = new Arbol(infija.length());
       for (int i = 0; i < infija.length(); i++){
           char letra = infija.charAt(i);
           if(esOperador(letra)){
               if(pila.estaVacia()){
                   pila.apilar(letra);
               }else{
                   int pe = prioridadEnExpresion(letra);
                   int pp = prioridadEnPila((char)pila.elementoTope());  
               if(pe > pp){
                    pila.apilar(letra);
               }else{
                   posfija += pila.desapilar();
                   pila.apilar(letra);
               }
            }
           }else{
               posfija += letra;
               
           }
         }
       while(!pila.estaVacia()){
           posfija += pila.desapilar();
       }
       return posfija;
       
     }
    
    private static int prioridadEnExpresion(char operador)      {
          if(operador == '^') return 4;
          if(operador == '*' || operador == '/' ) return 2;
          if(operador == '+' || operador == '-' ) return 1;
          
        return 0;
          
      }
       
    private static int prioridadEnPila(char operador)      {
          if(operador == '^') return 3;
          if(operador == '*' || operador == '/' ) return 2;
          if(operador == '+' || operador == '-' ) return 1;
          
          return 0;
      }    
    
    private static double evaluar(String posfija) {
        Arbol pila = new Arbol(posfija.length());
        for (int i = 0; i < posfija.length(); i++){
          char letra = posfija.charAt(i);
          
          if(!esOperador(letra)){
             double num = new Double(letra + "");
             pila.apilar(num); 
          }else{
              double num2 = (double) pila.desapilar();
              double num1 = (double) pila.desapilar();
              double num3 = operacion(letra, num1, num2);
              pila.apilar(num3);
          }
        }
        return (double)pila.elementoTope();
    }

    private static boolean esOperador(char letra) {
       if(letra == '*'|| letra == '/'|| letra == '+'||
          letra == '-'|| letra == '^'){
          return true;
    }
        return false;
              
        
     
    }

    private static double operacion(char letra, double num1, double num2) {
        if(letra == '*') return num1 * num2;
        if(letra == '/') return num1 / num2;
        if(letra == '+') return num1 + num2;
        if(letra == '-') return num1 - num2;
        if(letra == '^') return Math.pow(num1, num2);
        return 0;
    }
    
    public static void main(String[] args) {
        try{
        Scanner sc = new Scanner(System.in);
        System.out.println("Capture la expresión");
        String infija = sc.next();
        String infija1=infija;
        System.out.println("El resultado es: " + Nodo.evaluar(infija,infija1));
       
        }catch(java.lang.ArrayIndexOutOfBoundsException e){
            
        }  
    }
}