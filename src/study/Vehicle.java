package study;
interface BaeMin{
    public void deliver();
}
abstract class Vehicle {
    protected int velocity;
    protected int wheelNum;
    public String carName;
    public Vehicle(){
        wheelNum = 6;
        velocity = 0;
    }
    public void setCarName(String name){
        carName = name;
    }
    public abstract void speedUp();
}
