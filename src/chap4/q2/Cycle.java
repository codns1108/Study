package chap4.q2;

//import BaeMin;

class Cycle implements BaeMin {
    int velocity;
    public void deliver()
    {
        System.out.println("자전거로 배달합니다");
    }

    public void speedUp()
    {
        velocity++;
    }

}
