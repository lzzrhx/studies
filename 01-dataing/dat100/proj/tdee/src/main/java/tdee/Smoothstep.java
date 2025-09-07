package tdee;

////////////////////////////////////////////////////////////////////////////////
// Smoothstep funksjoner
// adaptert til Java fra GLSL kode av Inigo Quilez
// https://iquilezles.org/articles/smoothsteps/
////////////////////////////////////////////////////////////////////////////////

public class Smoothstep {

    public static float run(float x) { return run(x, false, 1.0f, 0); }
    public static float run(float x, boolean inverse, float n, int index) {
        return switch (index)
        {
            case 1  -> quarticPolynomial(x, inverse);
            case 2  -> quinticPolynomial(x);
            case 3  -> quadraticRational(x, inverse);
            case 4  -> cubicRational(x, inverse);
            case 5  -> rational(x, inverse, n);
            case 6  -> piecewiseQuadratic(x, inverse);
            case 7  -> piecewisePolynomial(x, inverse, n);
            case 8  -> trigonometric(x, inverse);
            default -> cubicPolynomial(x, inverse);
        };
    }

    // #0
    // Cubic Polynomial
    // Continuity: C1
    public static float cubicPolynomial(float x) { return cubicPolynomial(x, false); }
    public static float cubicPolynomial(float x, boolean inverse)
    {
        if (inverse) { return 0.5f - (float)Math.sin( (float)Math.asin( 1.0f - 2.0f * x ) / 3.0f ); }
        return x * x * ( 3.0f - 2.0f * x );
    }

    // #1
    // Quartic Polynomial
    // Continuity: C1
    public static float quarticPolynomial(float x) { return quarticPolynomial(x, false); }
    public static float quarticPolynomial(float x, boolean inverse)
    {
        if (inverse) { return (float)Math.sqrt( 1.0f - (float)Math.sqrt( 1.0f - x ) ); }
        return x * x * ( 2.0f - x * x );                                   
    }

    // #2
    // Quintic Polynomial
    // Continuity: C2
    public static float quinticPolynomial(float x)
    {
        return x * x * x * ( x * ( x * 6.0f - 15.0f ) + 10.0f );
    }

    // #3
    // Quadratic Rational
    // Continuity: C1
    public static float quadraticRational(float x) { return quadraticRational(x, false); }
    public static float quadraticRational(float x, boolean inverse)
    {
        if (inverse) { return ( x - (float)Math.sqrt( x * ( 1.0f - x ) ) ) / ( 2.0f * x - 1.0f ); }
        return x * x / ( 2.0f * x * x - 2.0f * x + 1.0f );
    }
    
    // #4
    // Cubic Rational
    // Continuity: C2
    public static float cubicRational(float x) { return cubicRational(x, false); }
    public static float cubicRational(float x, boolean inverse)
    {
        if (inverse)
        { 
            float a = (float)Math.pow(        x, 1.0f / 3.0f );
            float b = (float)Math.pow( 1.0f - x, 1.0f / 3.0f );
            return a / ( a + b ); 
        }
        return x * x * x / ( 3.0f * x * x - 3.0f * x + 1.0f );
    }

    // #5
    // Rational
    // Continuity: C(n-1)
    public static float rational(float x) { return rational(x, false, 1.0f); }
    public static float rational(float x, boolean inverse, float n)
    {
        if (inverse) { n = 1.0f / n; }
        return (float)Math.pow( x, n ) / ( (float)Math.pow( x, n ) + (float)Math.pow( 1.0f - x, n ));
    }
    
    // #6
    // Piecewise Polynomial
    // Continuity: C1
    public static float piecewiseQuadratic(float x) { return piecewiseQuadratic(x, false); }
    public static float piecewiseQuadratic(float x, boolean inverse)
    {
        if (inverse) { return ( x < 0.5f ) ? (float)Math.sqrt( 0.5f * x ) : 1.0f - (float)Math.sqrt( 0.5f - 0.5f * x ); }
        return ( x < 0.5f ) ? 2.0f * x * x : 2.0f * x * ( 2.0f - x ) - 1.0f;
    }
    
    // #7
    // Piecewise Polynomial
    // Continuity: C(n-1)
    public static float piecewisePolynomial(float x) { return piecewisePolynomial(x, false, 1.0f); }
    public static float piecewisePolynomial(float x, boolean inverse, float n)
    {
        if (inverse) { n = 1.0f / n; }
        return ( x < 0.5f) ? 0.5f * (float)Math.pow( 2.0f * x, n) : 1.0f - 0.5f * (float)Math.pow( 2.0f * ( 1.0f - x ), n);
    }
    
    // #8
    // Trigonometric
    // Continuity: C1
    public static float trigonometric(float x) { return trigonometric(x, false); }
    public static float trigonometric(float x, boolean inverse)
    {
        if (inverse) { return (float)Math.acos( 1.0f - 2.0f * x ) / (float)Math.PI; }
        return 0.5f - 0.5f * (float)Math.cos( (float)Math.PI * x );
    }

}
