package package1;

import package1.model.*;

import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;
import java.io.Console;
import java.nio.file.Path;
import java.util.List;

public class HelloJShell {
    public static void main(String[] args)
    {
        StringBuilder head=new StringBuilder();
        String lineSep=System.lineSeparator().toString();
        head    .append("**********************************").append(lineSep)
                .append("***        Hello JShell        ***").append(lineSep)
                .append("**********************************").append(lineSep)
                .append(lineSep);
        System.out.println(head.toString());

        Rule rule1=new Rule(1);
        Condition condition1=new Condition("cell","$c");
        condition1.addConstraint("int b1=2;");
        condition1.addConstraint("b1+=1;");
        condition1.addConstraint("int b2=b1+10;");
        condition1.addConstraint("b1<b2;");

        Condition condition2=new Condition("entry", "$c");
        condition2.addConstraint("package package1;");
        condition2.addConstraint("import package1.model.*;");
        condition2.addConstraint("Test test1=new Test(1);");
        condition2.addConstraint(("String s=test1.getName();"));
        condition2.addConstraint("Test test2=new Test(2);");
        condition2.addConstraint(("test2.getName();"));

        /*Test test=new Test(3);
        System.out.println(test.getName());
        System.out.println();*/

        rule1.addCondition(condition1);
        rule1.addCondition(condition2);

        JShell jShell = JShell.create();
        jShell.addToClasspath("C:/Users/zkln/IdeaProjects/TryJShell/out/production/TryJShell/");
        //StringBuilder input=new StringBuilder();
        for(Condition c:rule1.getConditions())
        {
            for(String s:c.getConstraints())
            {
                //input.append(s).append(System.lineSeparator());
                System.out.println(s);
                List<SnippetEvent> events=jShell.eval(s);
                for(SnippetEvent e:events)
                {
                    System.out.print(e.status()+", ");
                    System.out.println(e.value());
                    //System.out.println(String.format("Value is: %s",e.snippet().toString()));
                }
            }
        }



        //Console console=System.console();
        //JShell jShell = JShell.create();
        System.out.println(jShell.toString());
        System.out.println();
        //System.out.println(input.toString());

        //List<SnippetEvent> snippetEvents=jShell.eval(input.toString());
        //System.out.println(String.format("Snippets count is %d",snippetEvents.size()));
        /*for(SnippetEvent e:snippetEvents)
            {
                System.out.print(e.status()+" ");
                System.out.println(String.format("Value is: %s",e.value()));
            }*/
        jShell.close();
        //System.out.println();
    }
}
