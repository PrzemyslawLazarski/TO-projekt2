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