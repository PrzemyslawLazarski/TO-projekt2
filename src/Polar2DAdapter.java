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