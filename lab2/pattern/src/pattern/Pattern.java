package pattern;
public class Pattern {
    public static void main(String[] args) {
        int i;
        for(i=0; i<5;i++){
            System.out.println("*");
            for( int j=0; j<i+1;j++){
                System.out.print("*");
            }   
        }
        System.out.print("*");
        System.out.print("\n");  
    }   
}
