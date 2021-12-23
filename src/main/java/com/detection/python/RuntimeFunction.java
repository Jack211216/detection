package com.detection.python;

import org.python.core.PyFunction;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;



/**
 * @Author ding
 * @Date 2021/12/22
 */

public class RuntimeFunction {
    public static void main(String[] args) {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile("F:\\File\\python\\loadlzx.py");

        // 第一个参数为期望获得的函数（变量）的名字，第二个参数为期望返回的对象类型
        PyFunction pyFunction = interpreter.get("newf", PyFunction.class);
        int a = 5, b = 10;
        String path="E:";
        //调用函数，如果函数需要参数，在Java中必须先将参数转化为对应的“Python类型”
        PyObject pyobj = pyFunction.__call__(new PyString(path));
        System.out.println("the anwser is: " + pyobj);
    }
}
