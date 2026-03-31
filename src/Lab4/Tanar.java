package Lab4;

public class Tanar {
    private String name;
    private int age;
    private String address;
    private float nota;

    public Tanar(String name, int age, String address, float nota) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Tanar{" + "name=" + name + ", age=" + age + ", address=" + address +" "+ "nota="+" "+nota +  '}';
    }

    public String getName(){
        return name;
    }
    public float getNota(){
        return nota;
    }


}
