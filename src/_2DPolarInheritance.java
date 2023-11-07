class _2DPolarInheritance extends Vector2D implements IPolar2D {
    public _2DPolarInheritance(double x, double y) {
        super(x, y);
    }

    public double getAngle() {
        double[] components = getComponents();
        return Math.atan(components[1] / components[0]);
    }
}