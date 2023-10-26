package ComplexNumbers;

public class ComplexNumber{
    protected double real;
    protected double imag;

    public ComplexNumber(){
        this.real = 0;
        this.imag = 0;
    }

    public ComplexNumber(double r, double i){
        this.real = r;
        this.imag = i;
    }

    public ComplexNumber(ComplexNumber rhs){
        this.real = rhs.real;
        this.imag = rhs.imag;
    }

    public void setReal(double r){
        this.real = r;
    }

    public void setImag(double i){
        this.imag = i;
    }

    public double getReal(){
        return this.real; 
    }

    public double getImag(){
        return this.imag;
    }

    @Override
    public String toString(){
        String str = "";
        if (this.imag < 0){
            double tempimag = this.imag * -1;
            str = Double.toString(this.real) + " - " + Double.toString(tempimag) + "i";
        }
        else{
            str = Double.toString(this.real) + " + " + Double.toString(this.imag) + "i";
        }
        return str;
    }

    public ComplexNumber add(ComplexNumber rhs){
        double newreal = this.real + rhs.real;
        double newimag = this.imag + rhs.imag;
        return new ComplexNumber(newreal, newimag);
    }

    public ComplexNumber sub(ComplexNumber rhs){
        double newreal = this.real - rhs.real;
        double newimag = this.imag - rhs.imag;
        return new ComplexNumber(newreal, newimag);
    }

    public ComplexNumber mult(ComplexNumber rhs){
        double newreal = (this.real * rhs.real) - (this.imag * rhs.imag);
        double newimag = (this.real * rhs.imag) + (this.imag * rhs.real);
        return new ComplexNumber(newreal, newimag);
    }

    // https://www.cuemath.com/numbers/division-of-complex-numbers/

    public ComplexNumber div(ComplexNumber rhs){
        if (rhs.getReal() == 0 && rhs.getImag() == 0){
            throw new ArithmeticException("Divided by Zero, NOT possible");
        }
        else{
            double newreal = ((this.real * rhs.real) + (this.imag * rhs.imag)) / ((rhs.real * rhs.real) + (rhs.imag * rhs.imag));
            double newimag = ((this.imag * rhs.real) - (this.real * rhs.imag)) / ((rhs.real * rhs.real) + (rhs.imag * rhs.imag));
            return new ComplexNumber(newreal, newimag);
        }
    }

    public double mag(){
        return Math.sqrt(this.real * this.real + this.imag * this.imag);
    }

    public ComplexNumber conj(){
        return new ComplexNumber(this.real, -this.imag);
    }

    public ComplexNumber sqrt(){
        double newreal;
        double newimag;
        if (this.getImag() == 0){
            if(this.getReal() < 0){
                newreal = 0;
                newimag = Math.sqrt(-this.real);
            }
            else{
                newreal = Math.sqrt(this.real);
                newimag = 0;
            }
        }
        else {
            newreal = Math.sqrt((this.real + Math.sqrt(this.real * this.real + this.imag * this.imag) )/2);
            newimag = (this.imag / Math.abs(this.imag)) * Math.sqrt(((-1 * this.real) + Math.sqrt(this.real * this.real + this.imag * this.imag)) / 2);
        }
        return new ComplexNumber(newreal, newimag);
    }

    @Override
    public boolean equals(Object o){
        if(this.real == ((ComplexNumber)o).getReal() && this.imag == ((ComplexNumber)o).getImag())
            return true;
        return false;
    }
}


