package it.slowik.processor;

import com.sun.codemodel.*;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.io.File;
import java.util.Set;

/**
 * Created by suowik
 * 01.02.14.
 */
@SupportedAnnotationTypes("it.slowik.annotation.FacadeScan")
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class RemoteProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        writeCodeModel("it.slowik.dupa");
        Messager messager = processingEnv.getMessager();
        messager.printMessage(Diagnostic.Kind.WARNING,"warn");
        for (Element element : annotations) {
            messager.printMessage(Diagnostic.Kind.NOTE, element.getSimpleName());
            element.accept(new FacadeVisitor(), element);
        }
        return true;
    }

    public void writeCodeModel(String factoryPackage) {
        try {

            /* Creating java code model classes */
            JCodeModel jCodeModel = new JCodeModel();

            /* Adding packages here */
            JPackage jp = jCodeModel._package(factoryPackage);

            /* Giving Class Name to Generate */
            JDefinedClass jc = jp._class("GeneratedFactory");

            /* Adding class level coment */
            JDocComment jDocComment = jc.javadoc();
            jDocComment.add("Class Level Java Docs");


            /* Adding method to the Class which is public static and returns com.somclass.AnyXYZ.class */
            String mehtodName = "myFirstMehtod";
            JMethod jmCreate = jc.method(JMod.PUBLIC | JMod.STATIC, jCodeModel.BOOLEAN, "create" + mehtodName);

            /* Addign java doc for method */
            jmCreate.javadoc().add("Method Level Java Docs");

            /* Adding method body */
            JBlock jBlock = jmCreate.body();

            /* Defining method parameter */
            JType jt = getTypeDetailsForCodeModel(jCodeModel, "Unsigned32");
            if (jt != null) {
                jmCreate.param(jt, "data");
            } else {
                jmCreate.param(java.lang.String.class, "data");
            }

            /* Building class at given location */
            jCodeModel.build(new File("src/main/java/"));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public JType getTypeDetailsForCodeModel(JCodeModel jCodeModel, String type) {
        switch (type) {
            case "Unsigned32":
                return jCodeModel.LONG;
            case "Unsigned64":
                return jCodeModel.LONG;
            case "Integer32":
                return jCodeModel.INT;
            case "Integer64":
                return jCodeModel.LONG;
            case "Enumerated":
                return jCodeModel.INT;
            case "Float32":
                return jCodeModel.FLOAT;
            case "Float64":
                return jCodeModel.DOUBLE;
            default:
                return null;
        }
    }
}
