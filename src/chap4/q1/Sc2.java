package chap4.q1;

public class Sc2 {
    private String name;
    private int age;
    private String team;

    public Sc2(String name, int age, String team) {
        this.name = name;
        this.age = age;
        this.team = team;
    }

    public void show(){
        System.out.println(team + age + name);
    }

    public void change(String team) {
        this.team = team;
    }

    public void shoot() {
        System.out.println("슈팅을 날립니다.");
    }
}
