import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        _2DPolarInheritance vector2d = new _2DPolarInheritance(2, 3);
        Vector3DDecorator vector3ddecorator = new Vector3DDecorator(1, 2, 3);
        Vector3DInheritance vector3dinheritance = new Vector3DInheritance(3, 4, 5);

        System.out.println("Wspolrzedne wektorow:");
        System.out.println("Wektor 2d");
        double[] components2d = vector2d.getComponents();
        System.out.println("x: " + components2d[0] + ", y: " + components2d[1]);
        System.out.println("Wektor 3d inheritance");
        double[] components3dInheritance = vector3dinheritance.getComponents();
        System.out.println("x: " + components3dInheritance[0] + ", y: " + components3dInheritance[1] + ", z: " + components3dInheritance[2]);
        System.out.println("Wektor 3d decorator");
        double[] components3dDecorator = vector3ddecorator.getComponents();
        System.out.println("x: " + components3dDecorator[0] + ", y: " + components3dDecorator[1] + ", z: " + components3dDecorator[2]);

        System.out.println("\nUklad biegunowy: ");
        System.out.println("Wektor 2d ");
        System.out.println("promien wodzacy: " + vector2d.abs());
        System.out.println("wartosc kata: " + vector2d.getAngle());

        System.out.println("\nIloczyn wektorowy: ");
        Vector3DDecorator tmpVector3dDecorator = vector3ddecorator.cross(vector2d);
        double[] crossComponentsDecorator = tmpVector3dDecorator.getComponents();
        System.out.println("Wektor 3d decorator i wektor 2d: ");
        System.out.println("x: " + crossComponentsDecorator[0]);
        System.out.println("y: " + crossComponentsDecorator[1]);
        System.out.println("z: " + crossComponentsDecorator[2]);
        Vector3DInheritance tmpVector3dInheritance = vector3dinheritance.cross(vector2d);
        double[] crossComponentsInheritance = tmpVector3dInheritance.getComponents();
        System.out.println("Wektor 3d inheritance i wektor 2d: ");
        System.out.println("x: " + crossComponentsInheritance[0]);
        System.out.println("y: " + crossComponentsInheritance[1]);
        System.out.println("z: " + crossComponentsInheritance[2]);

        System.out.println("\nIloczyn skalarny: ");
        System.out.println("Wektor 2d z wektorem 2d: " + vector2d.cdot(vector2d));
        System.out.println("Wektor 3d inheritance z wektorem 2d: " + vector3dinheritance.cdot(vector2d));
        System.out.println("Wektor 3d decorator z wektorem 2d: " + vector3ddecorator.cdot(vector2d));
    }
}