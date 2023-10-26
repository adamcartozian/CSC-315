package ComplexNumbers;

public class ComplexNumberPolar extends ComplexNumber {
    private double radius;
    private double theta;

    public ComplexNumberPolar(){
        this(new ComplexNumber());
    }

    public ComplexNumberPolar(double r, double t){
        this.radius = r;
        this.theta = t;
        new ComplexNumber((r*Math.cos(t)), (r*Math.sin(t)));
    }
    public ComplexNumberPolar(ComplexNumber CN){
        this.radius = Math.sqrt((CN.real * CN.real) + (CN.imag *CN.imag));
        this.theta = Math.atan2(CN.imag, CN.real);
    }

    public ComplexNumberPolar(ComplexNumberPolar CN){
        this.radius = CN.radius;
        this.theta = CN.theta;
    }

    public double getRadius(){
        return this.radius;
    }

    public double getTheta(){
        return this.theta;
    }

    public String toString(){
        String cn = "";
        if (this.calcImag() < 0){
            double tempimag = this.calcImag() * -1;
            cn = Double.toString(this.calcReal()) + " - " + Double.toString(tempimag) + "i";
        }
        else{
            cn = Double.toString(this.calcReal()) + " + " + Double.toString(this.calcImag()) + "i";
        }
        String polar = Double.toString(this.radius) + "(cos(" + Double.toString(this.theta) + ") + i sin(" + Double.toString(this.theta) + "))";
        String str = cn + " : " + polar;
        return str;
    }

    public ComplexNumberPolar mult(ComplexNumberPolar CNP){
        double newradius = this.radius * CNP.radius;
        double newtheta = this.theta + CNP.theta;
        return new ComplexNumberPolar(newradius, newtheta);
    }

    public ComplexNumberPolar div(ComplexNumberPolar CNP){
        double newradius = this.radius / CNP.radius;
        double newtheta = this.theta - CNP.theta;
        return new ComplexNumberPolar(newradius, newtheta);
    }

    public ComplexNumberPolar pow(int x){
        double power = x;
        double newradius = Math.pow(this.radius, power);
        double newtheta = this.theta * power;
        return new ComplexNumberPolar(newradius, newtheta);
    }

    public ComplexNumberPolar[] roots(int n){
        ComplexNumberPolar[] roots = new ComplexNumberPolar[n];
        double newradius = Math.pow(this.radius, (1.0 / n));
        for(int k = 0; k < n ; ++k){
        double newtheta = ((this.theta + (2 * k * Math.PI))/n);
        roots[k] = new ComplexNumberPolar(newradius, newtheta);
    }
    return roots;
    }

    private double calcReal(){
        double real = this.radius * Math.cos(this.theta);
        return real;
    }
    private double calcImag(){
        double imag = this.radius * Math.sin(this.theta);
        return imag;
    }
}
