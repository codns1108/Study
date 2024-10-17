package chap4.q1;

public class Sc {
    public static void main(String[] args) {
        Sc2 sc = new Sc2("손흥민", 34, "토트넘");
        sc.show();
        sc.change("맨유");
        sc.shoot();
        sc.show();

        Sc2 sc2 = new Sc2("이강인", 22, "파리");
        sc2.show();
    }
}
