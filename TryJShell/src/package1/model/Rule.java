package package1.model;

import java.util.ArrayList;
import java.util.List;

public class Rule {
    private int id;

    public int getId() {
        return id;
    }

    private List<Condition> conditions=new ArrayList<>();

    public Rule(int id)
    {
        this.id=id;
    }
    public void addCondition(Condition condition)
    {
        conditions.add(condition);
    }
    public List<Condition> getConditions()
    {
        return conditions;
    }
}
