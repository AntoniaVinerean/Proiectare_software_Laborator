import Lab2.Student;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Student student1 = new Student("123", "Vinerean", "Antonia", "TI 22/1");
    System.out.println(student1);

    List<Integer> x= new ArrayList();
    List<Integer> y= new ArrayList();
    List<Integer> xPlusY= new ArrayList();
    Set<Integer> zSet = new TreeSet();
    List<Integer> xMinusY= new ArrayList();
    int p = 4;
    List<Integer> xPlusYLimitedByP= new ArrayList();

    Random rand = new Random();

    for(int i=0;i<=5;i++) {
        x.add(rand.nextInt(11));
    }

    for(int i=0; i<7;i++) {
        y.add(rand.nextInt(11));
    }

    Collections.sort(x);
    Collections.sort(y);

    System.out.println("x:"+x);
    System.out.println("y:"+y);

    xPlusY.addAll(x);
    xPlusY.addAll(y);
    Collections.sort(xPlusY);
    System.out.println("xPlusY:"+xPlusY);

    for(Integer element:x){
        if(y.contains(element)){
            zSet.add(element);
        }
    }
    System.out.println("zSet:"+zSet);

    for(Integer element:x){
        if(!y.contains(element)){
            xMinusY.add(element);
        }
    }
    System.out.println("xMinusY:"+xMinusY);

    Set<Integer> tempSet = new TreeSet();
    for(Integer val:x){
        if(val<=p) tempSet.add(val);
    }
    for(Integer val:y){
        if(val<=p) tempSet.add(val);
    }
    xPlusYLimitedByP.addAll(tempSet);

    System.out.println("xPlusYLimitedByP:"+xPlusYLimitedByP);
}
