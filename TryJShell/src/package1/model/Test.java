package package1.model;

public class Test {

    private String name;

    public String getName() {
        return name;
    }

    public Test(int id)
    {
        name=String.format("test %d",id);
    }
}
