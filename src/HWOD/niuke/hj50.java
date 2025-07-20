package HWOD.niuke;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class hj50 {
    public static void main(String[] args) throws ScriptException {
        ScriptEngine javaScript = new ScriptEngineManager().getEngineByName("JavaScript");
        System.out.println(javaScript.eval("1+2*(3-1)"));
    }
}
