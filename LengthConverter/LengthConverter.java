public class LengthConverter
{
    final private double INCH_TO_METER = 0.0254;
    final private double FOOT_TO_METER = 0.3048;
    final private double MILE_TO_METER = 1609.344;
    final private double MM_TO_METER = 0.001;
    final private double CM_TO_METER = 0.01;
    final private double KM_TO_METER = 1000;
    final private double YD_TO_METER = 0.9144;
    private double factor;

    public LengthConverter(String unit)
    {
        if(unit.equals("in"))
        {
            factor = INCH_TO_METER;
        }
        else if(unit.equals("ft"))
        {
            factor = FOOT_TO_METER;
        }
        else if(unit.equals("mi"))
        {
            factor = MILE_TO_METER;
        }
        else if(unit.equals("mm"))
        {
            factor = MM_TO_METER;
        }
        else if(unit.equals("cm"))
        {
            factor = CM_TO_METER;
        }
        else if(unit.equals("km"))
        {
            factor = KM_TO_METER;
        }
        else if(unit.equals("yd"))
        {
            factor = YD_TO_METER;
        }
        else if(unit.equals("meter"))
        {
            factor = 1;
        }
        else
        {
            factor = 0;
        }
    }
    public double toMeters(double a)
    {
        return (a*factor);
    }
    public double fromMeters(double a)
    {
        return (a/factor);
    }
}
