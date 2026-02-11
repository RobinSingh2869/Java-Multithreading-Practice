package LambdaExpression;

public class Test {
    public static void main(String[] args) {
        Student enginerringStudent = new Student() {
            @Override
            public String getBio(String name) {
                return name + " is enginerring student ";
            }
        };
        Student lawStudent = (name) -> {
            return name + " is law student ";
        };
        String bio = enginerringStudent.getBio("Ram");
        System.out.println(bio);

    }
}

