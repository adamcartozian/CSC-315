package Vector3D;


public class Vector3D implements VectorInterface3D {
    
    private double x;
    private double y;
    private double z;

    public Vector3D(double x1, double y1, double z1){
        x = x1;
        y = y1;
        z = z1;
    }

    public Vector3D(){
        this(0, 0, 0);
    }

    public Vector3D(Vector3D xyz) {

    }

    @Override
    public double get(COMPONENTS component){
        double exitvalue = 0;
        switch (component){
            case XCOMPONENT:
                exitvalue = x;
                break;
            case YCOMPONENT:
                exitvalue = y;
                break;
            case ZCOMPONENT:
                exitvalue = z;
                break;
        }
        return exitvalue;
    }

    @Override
    public void set(COMPONENTS component, double value){
        switch (component){
            case XCOMPONENT:
                x = value;
                break;
            case YCOMPONENT:
                y = value;
                break;
            case ZCOMPONENT:
                z = value;
                break;
        }
    }

    @Override
    public VectorInterface3D Add(VectorInterface3D rhs){
        double tempx = x + rhs.get(COMPONENTS.XCOMPONENT);
        double tempy = y + rhs.get(COMPONENTS.YCOMPONENT);
        double tempz = z + rhs.get(COMPONENTS.ZCOMPONENT);
        return new Vector3D(tempx, tempy, tempz);
    }

    @Override
    public VectorInterface3D Subtract(VectorInterface3D rhs){
        double tempx = x - rhs.get(COMPONENTS.XCOMPONENT);
        double tempy = y - rhs.get(COMPONENTS.YCOMPONENT);
        double tempz = z - rhs.get(COMPONENTS.ZCOMPONENT);
        return new Vector3D(tempx, tempy, tempz);
    }

    @Override
    public VectorInterface3D Multiply(double value){
        double tempx = x * value;
        double tempy = y * value;
        double tempz = z * value;
        return new Vector3D(tempx, tempy, tempz);
    }

    @Override
    public double Dot(VectorInterface3D rhs){
        double exitvalue = (x * rhs.get(COMPONENTS.XCOMPONENT)) + (y * rhs.get(COMPONENTS.YCOMPONENT)) + (z * rhs.get(COMPONENTS.ZCOMPONENT));
        return exitvalue;
    }

    @Override
    public VectorInterface3D Cross(VectorInterface3D rhs){
        double tempx = y * rhs.get(COMPONENTS.ZCOMPONENT) - z * rhs.get(COMPONENTS.YCOMPONENT);
        double tempy = z * rhs.get(COMPONENTS.XCOMPONENT) - x * rhs.get(COMPONENTS.ZCOMPONENT);
        double tempz = x * rhs.get(COMPONENTS.YCOMPONENT) - y * rhs.get(COMPONENTS.XCOMPONENT);
        return new Vector3D(tempx, tempy, tempz);
    }

    @Override
    public double Norm(){
        double norm = Math.sqrt(x * x + y * y + z * z);
        return norm;
    }

    @Override
    public VectorInterface3D Unit(){
        double tempx = x / Norm();
        double tempy = y / Norm();
        double tempz = z / Norm();
        return new Vector3D(tempx, tempy, tempz);
    }

    @Override
    public double AngleBetween(VectorInterface3D rhs){
        double angle = Math.acos(Dot(rhs) / (Norm() * rhs.Norm()));
        return angle;
    }

    @Override
    public double DirectionAngle(COMPONENTS component){
        double tempnum = 0;
        switch (component){
            case XCOMPONENT:
                tempnum = x;
                break;
            case YCOMPONENT:
                tempnum = y;
                break;
            case ZCOMPONENT:
                tempnum = z;
                break;
        }
        tempnum = Math.cos(tempnum / Norm());
        return tempnum;
    }

    @Override
    public boolean Parallel(VectorInterface3D rhs){
        if(Math.round(this.AngleBetween(rhs)) == 0){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean AntiParallel(VectorInterface3D rhs){
        if(this.AngleBetween(rhs) == Math.PI){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public VectorInterface3D Projection(VectorInterface3D rhs){
        return Multiply(Dot(rhs) / rhs.Dot(rhs));
    }

    @Override
    public String toString(){
        String str = "< " + Double.toString(this.x) + ", " + Double.toString(this.y) + ", " + Double.toString(this.z) + " >";
        return str;
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof VectorInterface3D) {
            VectorInterface3D vobj = (VectorInterface3D) obj;
            return ((Math.abs(x - vobj.get(COMPONENTS.XCOMPONENT)) < PRECISION)
                    && (Math.abs(y - vobj.get(COMPONENTS.YCOMPONENT)) < PRECISION)
                    && (Math.abs(z - vobj.get(COMPONENTS.ZCOMPONENT))) < PRECISION);
        }
        return false;
    }
}
