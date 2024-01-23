public class Program {

    public static void main(String[] args) {
        int age = 15;

        // Pre-condition
        assert (age > 0) : "Pre-condition";

        System.out.println("Age : " + age);

        age = performSomeOperation(age);

        System.out.println("Updated Age : " + age);

        // Class invariant: Ensure the object is in a valid state
        Person person = new Person("John", 0);
        person.setAge(-5);

        assert (person.isValid()) : "Class invariant failed: Person object is in an invalid state";
    }

    private static int performSomeOperation(final int value) {
        assert (value > 0) : "Pre-condition : age must be better than 0";

        int result = value * 2;
        // Post-condition
        assert result < 100 : "Post-condition : Age must be less than 100";
        return value * 2;
    }

    static class Person {
        private String name;
        private int age;


        public Person(String name, int age) {
            this.name = name;
            this.age = age;

            // Class invariant : Ensure age is non-negative when creating a person
            assert (age >= 0) : "Class invariant failed: Age must be non-negative";
        }

        public void setAge(int age) {
            this.age = age;
        }

        public boolean isValid() {
            // Class invariant: Ensure age is non-negative at all times
            return age >= 0;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }



}
