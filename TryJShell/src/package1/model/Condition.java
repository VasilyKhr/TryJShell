package package1.model;

import java.util.ArrayList;
import java.util.List;

public class Condition {
    private String query;
    private String varName;

    public String getQuery() {
        return query;
    }

    public String getVarName() {
        return varName;
    }

    public Condition(String query, String var)
    {
        this.query=query;
        this.varName=varName;
    }

    private List<String> constraints=new ArrayList<>();
    public void addConstraint(String constr)
    {
        constraints.add(constr);
    }
    public List<String> getConstraints()
    {
        return constraints;
    }
}
