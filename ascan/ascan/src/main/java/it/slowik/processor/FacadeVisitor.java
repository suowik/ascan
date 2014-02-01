package it.slowik.processor;

import javax.lang.model.element.*;

/**
 * Created by suowik
 * 01.02.14.
 */
public class FacadeVisitor implements ElementVisitor<Void, Element> {

    @Override
    public Void visit(Element e, Element element) {
        System.out.println(e.getSimpleName());
        return null;
    }

    @Override
    public Void visit(Element e) {
        System.out.println(e.getSimpleName());
        return null;
    }

    @Override
    public Void visitPackage(PackageElement e, Element element) {
        System.out.println(e.getSimpleName());
        return null;
    }

    @Override
    public Void visitType(TypeElement e, Element element) {
        System.out.println(e.getSimpleName());
        return null;
    }

    @Override
    public Void visitVariable(VariableElement e, Element element) {
        System.out.println(e.getSimpleName());
        return null;
    }

    @Override
    public Void visitExecutable(ExecutableElement e, Element element) {
        System.out.println(e.getSimpleName());
        return null;
    }

    @Override
    public Void visitTypeParameter(TypeParameterElement e, Element element) {
        System.out.println(e.getSimpleName());
        return null;
    }

    @Override
    public Void visitUnknown(Element e, Element element) {
        System.out.println(e.getSimpleName());
        return null;
    }
}
