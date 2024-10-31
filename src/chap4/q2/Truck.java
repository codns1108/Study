package chap4.q2;

public class Truck extends Car implements BaeMin {
    public void speedUp(){
        velocity += 30;
    }
    public  void warn(){
        System.out.println("경적을 울림");
    }
    public  void deliver(){
        System.out.println("트럭으로 배달합니다");
    }
    public static void main(String[] args) {
        Truck myTruck = new Truck();
        myTruck.speedUp();
        System.out.println("트럭의 속도" + myTruck.velocity);

        Car myCar = myTruck;
        myCar.speedUp();
        System.out.println("트럭의 속도" + myCar.velocity);

        // myCar.warn();

        BaeMin myBaemin = new Cycle();
        myBaemin.deliver();
        myBaemin = myTruck;
        myBaemin.deliver();

//        객체지향 4대 특성 추상화, 캡슐화, 상속성, 다형성
        // 레퍼런스 변수
        //재정의  > 메소드오버라이딩
        // 상속 쓰는 이유 1. 구현된 기능, 데이터 이어받으려고 > 구현상속
        // 중요함 2. 다형성 - 표현은 동일 기능은 다르게
        // 조건 1. 상위 레퍼런스 변수가 하위 객체를 받을 수 있어야함
        // 조건 2. 오버라이딩 메소드 호출 시 하위 객체 메소드가 호출 되어야한다. > 동적바인딩
    }
}
