package study;

 class Car {
     protected int velocity;
     protected int wheelNum;
     protected String carName;
     public Car(){
         wheelNum = 4;
         velocity = 100;
     }
     public void speedUp(){
         velocity++;
     }

}
