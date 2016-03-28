interface Car { 
     void showYourTopSpeed(); 
     void showYourTopSpeed(Car h); 
} 
class Supercar implements Car { 
     public void showYourTopSpeed() { 
          System.out.println("F"); 
     } 
     public void showYourTopSpeed(Car h) { 
          System.out.println("G"); 
     } 
     public void showYourTopSpeed(Supercar h) { 
          System.out.println("E"); 
     } 
} 
class NissanGTR extends Supercar { 
     public void showYourTopSpeed(Car h) { 
          System.out.println("D"); 
     } 
     public void showYourTopSpeed(Supercar h) { 
          if (h instanceof Porsche911) { 
               System.out.println("A"); 
          } 
     } 
} 
class Porsche911 extends Supercar { 
     public void showYourTopSpeed(Car h){ 
          System.out.println("C"); 
     } 
     public void showYourTopSpeed(Supercar h) { 
          if (h instanceof NissanGTR) { 
               System.out.println("B"); 
          } 
     } 
} 
public class OOD { 
     public static void main(String[] args) { 
          Car myCar = new Porsche911(); 
          Car neighborCar = new NissanGTR(); 
          Supercar supercar = new Supercar(); 
          Supercar gtr = new NissanGTR(); 
          Supercar porsche911 = new Porsche911(); 
          
          gtr.showYourTopSpeed(porsche911);
          porsche911.showYourTopSpeed(gtr);
          porsche911.showYourTopSpeed(myCar);
          gtr.showYourTopSpeed(neighborCar);
          supercar.showYourTopSpeed(porsche911);
     }
}
