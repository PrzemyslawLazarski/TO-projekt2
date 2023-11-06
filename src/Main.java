import java.util.ArrayList;
import java.util.List;

interface IVector {
    double[] getComponents();

    double abs();

    double cdot(IVector param);
}

interface IPolar2D {
    double getAngle();

    double abs();
}

class Vector2D implements IVector {
    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double[] getComponents() {
        return new double[]{x, y};
    }

    public double abs() {
        return Math.sqrt(x * x + y * y);
    }

    public double cdot(IVector param) {
        double[] paramComponents = param.getComponents();
        return x * paramComponents[0] + y * paramComponents[1];
    }
}

class Polar2DAdapter implements IPolar2D, IVector {
    private Vector2D srcVector;

    public Polar2DAdapter(Vector2D vector2D) {
        this.srcVector = vector2D;
    }

    public double abs() {
        return srcVector.abs();
    }

    public double cdot(IVector param) {
        double[] paramComponents = param.getComponents();
        return srcVector.cdot(new Vector2D(paramComponents[0], paramComponents[1]));
    }

    public double[] getComponents() {
        return srcVector.getComponents();
    }

    public double getAngle() {
        double[] components = srcVector.getComponents();
        return Math.atan(components[1] / components[0]);
    }
}

class Vector3DDecorator extends Vector2D implements IVector {
    private double z;

    public Vector3DDecorator(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double abs() {
        double[] components = getComponents();
        return Math.sqrt(components[0] * components[0] + components[1] * components[1] + z * z);
    }

    public double cdot(IVector param) {
        double[] components = getComponents();
        double[] paramComponents = param.getComponents();
        return components[0] * paramComponents[0] + components[1] * paramComponents[1] + z * 0;
    }

    public double[] getComponents() {
        double[] components = super.getComponents();
        return new double[]{components[0], components[1], z};
    }

    public Vector3DDecorator cross(IVector param) {
        double[] components = getComponents();
        double[] paramComponents = param.getComponents();
        double tempX = components[1] * 0 - z * paramComponents[1];
        double tempY = components[0] * 0 - z * paramComponents[0];
        double tempZ = components[0] * paramComponents[1] - components[1] * paramComponents[0];
        return new Vector3DDecorator(tempX, tempY, tempZ);
    }
}

class Vector3DInheritance extends Vector2D implements IVector {
    private double z;

    public Vector3DInheritance(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double abs() {
        double[] components = getComponents();
        return Math.sqrt(components[0] * components[0] + components[1] * components[1] + z * z);
    }

    public double cdot(IVector param) {
        double[] components = getComponents();
        double[] paramComponents = param.getComponents();
        return components[0] * paramComponents[0] + components[1] * paramComponents[1] + z * 0;
    }

    public double[] getComponents() {
        double[] components = super.getComponents();
        return new double[]{components[0], components[1], z};
    }

    public Vector3DInheritance cross(IVector param) {
        double[] components = getComponents();
        double[] paramComponents = param.getComponents();
        double tempX = components[1] * 0 - z * paramComponents[1];
        double tempY = components[0] * 0 - z * paramComponents[0];
        double tempZ = components[0] * paramComponents[1] - components[1] * paramComponents[0];
        return new Vector3DInheritance(tempX, tempY, tempZ);
    }
}

class _2DPolarInheritance extends Vector2D implements IPolar2D {
    public _2DPolarInheritance(double x, double y) {
        super(x, y);
    }

    public double getAngle() {
        double[] components = getComponents();
        return Math.atan(components[1] / components[0]);
    }
}

public class Main {
    public static void main(String[] args) {
        _2DPolarInheritance vector2d = new _2DPolarInheritance(1, 2);
        Vector3DDecorator vector3ddecorator = new Vector3DDecorator(1, 2, 3);
        Vector3DInheritance vector3dinheritance = new Vector3DInheritance(11, 10, 9);

        System.out.println("UKŁAD KARTEZJANSKI:");
        System.out.println("Wektor 2d");
        double[] components2d = vector2d.getComponents();
        System.out.println("x: " + components2d[0] + ", y: " + components2d[1]);
        System.out.println("Wektor 3d inheritance");
        double[] components3dInheritance = vector3dinheritance.getComponents();
        System.out.println("x: " + components3dInheritance[0] + ", y: " + components3dInheritance[1] + ", z: " + components3dInheritance[2]);
        System.out.println("Wektor 3d decorator");
        double[] components3dDecorator = vector3ddecorator.getComponents();
        System.out.println("x: " + components3dDecorator[0] + ", y: " + components3dDecorator[1] + ", z: " + components3dDecorator[2]);

        System.out.println("\nUKŁAD BIEGUNOWY: ");
        System.out.println("Wektor 2d ");
        System.out.println("promien wodzacy: " + vector2d.abs());
        System.out.println("wartosc kata: " + vector2d.getAngle());

        System.out.println("\nILOCZYN WEKTOROWY");
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

        System.out.println("\nILOCZYN SKALARNY");
        System.out.println("Wektor 2d z wektorem 2d: " + vector2d.cdot(vector2d));
        System.out.println("Wektor 3d inheritance z wektorem 2d: " + vector3dinheritance.cdot(vector2d));
        System.out.println("Wektor 3d decorator z wektorem 2d: " + vector3ddecorator.cdot(vector2d));
    }
}