package com.yay;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/12/1 17:21
 */
public class MyBatisPluginActivator {

    public static void main(String[] args) throws NotFoundException {
        ClassPool pool = ClassPool.getDefault();

        pool.insertClassPath("D:/iMybatis-3.42.jar");
        CtClass m = pool.get("com.s7.mybatis.e.m");
        CtClass ar = pool.get("com.s7.mybatis.e.ar");
        CtClass h = pool.get("com.s7.mybatis.e.h");
        CtClass S = pool.get("com.s7.mybatis.e.S");
        CtClass an = pool.get("com.s7.mybatis.e.an");
        CtClass ao = pool.get("com.s7.mybatis.e.ao");
        pool.importPackage("com.google.gson.JsonObject;");
        pool.importPackage("com.intellij.openapi.diagnostic.Logger;");
        pool.importPackage("com.intellij.openapi.project.Project;");

        try {
            // productId
            // productVersion
            // sha
            // valid
            CtMethod ct = m.getDeclaredMethod("a", new CtClass[]{pool.get("java.lang.String")});
            ct.setBody("{" +
                    "       com.google.gson.JsonObject var3 = new com.google.gson.JsonObject();\n" +
                    "       var3.addProperty(\"productId\", Integer.valueOf(1));\n" +
                    "       var3.addProperty(\"productVersion\", \"3.154\");\n" +
                    "       return true;\n" +
                    "   }");

            ct = ar.getDeclaredMethod("a", new CtClass[]{pool.get("com.google.gson.JsonObject")});
            ct.setBody("{" +
                    "       com.google.gson.JsonObject v3 = new com.google.gson.JsonObject();\n" +
                    "       v3.addProperty(\"valid\", \"true\");\n" +
                    "       return v3;\n" +
                    "   }");


            ct = h.getDeclaredMethod("onSuccess");
            ct.setBody("{com.s7.mybatis.e.ao.h(\"Success\");}");

            ct = h.getDeclaredMethod("onThrowable");
            ct.setBody("{ }");

            ct = S.getDeclaredMethod("a");
            ct.setBody("{ return com.s7.mybatis.e.ao.g(\"1111111\"); }");

            ct = an.getDeclaredMethod("l");
            ct.setBody("{" +
                    "       com.google.gson.JsonObject jsonObject = new com.google.gson.JsonObject();\n" +
                    "       jsonObject.addProperty(\"pid\", com.s7.mybatis.e.an.d());\n" +
                    "       jsonObject.addProperty(\"userId\", com.s7.mybatis.e.an.e());\n" +
                    "       jsonObject.addProperty(\"version\", com.s7.mybatis.e.ac.b());\n" +
                    "       return jsonObject;" +
                    "   }");

            ct = ao.getDeclaredMethod("d");
            ct.setBody("{" +
                    "       com.google.gson.JsonObject jsonObject = com.s7.mybatis.e.an.l();\n" +
                    "       jsonObject.addProperty(\"license\", \"Cracked_By_Freeway\");\n" +
                    "       return new com.s7.mybatis.e.j(true, \"Freeway\");" +
                    "   }");

            ct = ao.getDeclaredMethod("b", new CtClass[]{});
            ct.setBody("{" +
                    "       return new com.s7.mybatis.e.ai(false, 365, true, true);" +
                    "   }");


            ct = ao.getDeclaredMethod("a", new CtClass[]{});
            ct.setBody("{" +
                    "       if (com.s7.mybatis.e.an.c().compareAndSet(false, true)) {\n" +
                    "           new Thread(new com.s7.mybatis.e.af()).start();" +
                    "       }" +
                    "   }");

            m.writeFile("d:\\ccc\\");
            ar.writeFile("d:\\ccc\\");
            h.writeFile("d:\\ccc\\");
            S.writeFile("d:\\ccc\\");
            an.writeFile("d:\\ccc\\");
            ao.writeFile("d:\\ccc\\");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
