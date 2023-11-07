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