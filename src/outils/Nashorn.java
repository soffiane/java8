package outils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * nouvel interpreteur js
 * encapsulable dans du code Java
 * remplace Rhino
 * meilleur perf
 * mode standalone
 * Java peut appeler du JS et vice et versa
 *
 * extensions :
 * appli JavaFX sont executables comme script
 *
 */

public class Nashorn {
    public static void main(String... args) throws ScriptException {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = engineManager.getEngineByName("nashorn");
        scriptEngine.eval("function sum(a,b){return a+b;}");
        System.out.println(scriptEngine.eval("sum(1,2)"));
    }
}
