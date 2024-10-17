public class Person {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void swapPerson(Person p) {
        String tempName = this.name;
        this.name = p.name;
        p.name = tempName;
    }
}