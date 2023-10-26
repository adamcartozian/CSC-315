package Homeowrk.RationalNumbers;

public class RationalNumber implements RationalNumberInterface {
    private int numerator;
    private int denominator;

    public RationalNumber(){
        this.numerator = 0;
        this.denominator = 1;
    }

    public RationalNumber(int n, int d) throws IllegalArgumentException{
        this.numerator = n;
        this.denominator = d;
        if(d == 0){
            throw new IllegalArgumentException("Divided by Zero, not possible");
        }
    }


    public RationalNumber(RationalNumberInterface rhs){
        this.numerator = rhs.getNumerator();
        this.denominator = rhs.getDenominator();
    }

    @Override
    public int getNumerator(){
        return this.numerator;
    }

    @Override
    public int getDenominator(){
        return this.denominator;
    }

    @Override
    public boolean equals(Object o){
        if(this.numerator == ((RationalNumber) o).getNumerator() && this.denominator == ((RationalNumber) o).getDenominator())
            return true;
        return false;
    }

    @Override
    public String toString(){
        int tempnum = this.numerator;
        int tempden = this.denominator;
        int count = 0;
        boolean neg = false;
        String str= " ";
        if(tempnum < 0){
            neg = true;
            tempnum = tempnum * -1;
        }
        else if(tempden < 0){
            neg = true;
            tempden = tempden * -1;
        }

        while (tempnum > tempden){
            tempnum = tempnum - tempden;
            count++;
        }
        if(count != 0){
            if(neg == true){
                str = ("-" + Integer.toString(count) + " " + Integer.toString(tempnum) + "/" + Integer.toString(tempden));
            }
            else{
                str = (Integer.toString(count) + " " + Integer.toString(tempnum) + "/" + Integer.toString(tempden));
            }
        }
        else{
            if(neg == true){
                str = ("-"+ Integer.toString(tempnum) + "/" + Integer.toString(tempden));
            }
            else{
                str = (Integer.toString(tempnum) + "/" + Integer.toString(tempden));
            }
        }
        return str;
    }

    @Override
    public RationalNumberInterface add(RationalNumberInterface rhs){
        int newnum = (this.numerator * rhs.getDenominator()) + (this.denominator * rhs.getNumerator());
        int newden = this.denominator *rhs.getDenominator();
        return new RationalNumber(SimpNum(newnum, findGCD(newnum, newden)), SimpDen(newden, findGCD(newnum, newden)));
    }

    @Override
    public RationalNumberInterface sub(RationalNumberInterface rhs) {
        int newnum = (this.numerator * rhs.getDenominator()) - (this.denominator * rhs.getNumerator());
        int newden = this.denominator *rhs.getDenominator();
        return new RationalNumber(SimpNum(newnum, findGCD(newnum, newden)), SimpDen(newden, findGCD(newnum, newden)));
    }

    @Override
    public RationalNumberInterface mult(RationalNumberInterface rhs){
        int newnum = (this.numerator * rhs.getNumerator());
        int newden = this.denominator *rhs.getDenominator();
        return new RationalNumber(SimpNum(newnum, findGCD(newnum, newden)), SimpDen(newden, findGCD(newnum, newden)));
    }

    @Override
    public RationalNumberInterface div(RationalNumberInterface rhs){
        if (rhs.getNumerator() == 0){
            throw new ArithmeticException("Divided by Zero, not possible");
        }
        else{
            int newnum = (this.numerator * rhs.getDenominator());
            int newden = this.denominator *rhs.getNumerator();
            return new RationalNumber(SimpNum(newnum, findGCD(newnum, newden)), SimpDen(newden, findGCD(newnum, newden)));
        }
    }

    @Override
    public double sqrt() throws ArithmeticException{
        if(this.numerator < 0){
            throw new ArithmeticException("Cannot Squareroot a Negative Number");
        }
        else{
            return Math.sqrt((double)this.numerator / (double)this.denominator);
        }
    }

    private static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }

    private static int SimpNum(int a, int b){
        int simplifiedNumerator = a/b;
        return simplifiedNumerator;
    }

     private static int SimpDen(int a, int b){
        int simplifiedDenominator = a/b;
        return simplifiedDenominator;
     }
}