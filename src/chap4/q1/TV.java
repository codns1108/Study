package chap4.q1;

public class TV {
    private String name;
    private int year, size;
    public TV(String name, int year, int size){
        this.name = name;
        this.year = year;
        this.size = size;
    }

    public void show(){
        System.out.println(name + "에서 만든" + year + "년형" + size + "인치 TV");
    }
}
