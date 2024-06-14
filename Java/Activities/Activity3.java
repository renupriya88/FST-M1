package activities;

public class Activity3 {
    public static void main(String[] arg)
    {
        double ageSeconds = 1000000000;
        double ageEarth = 31557600;
        double ageMercury = 0.2408467;
        double ageVenus = 0.61519726;
        double ageMars = 1.8808158;
        double ageJupiter = 11.862615;
        double ageSaturn = 29.447498;
        double ageUranus = 84.016846;
        double ageNeptune = 164.79132;

        age(ageSeconds,ageEarth,ageMercury, ageVenus, ageMars, ageJupiter, ageSaturn, ageUranus, ageNeptune);
    }

    public static void age (double ageSeconds, double ageEarth, double ageMercury, double ageVenus, double ageMars, double ageJupiter, double ageSaturn, double ageUranus, double ageNeptune)
    {
        System.out.println("Earth Age : " + ageSeconds/ageEarth);
        System.out.println("Mercury Age : " + ageSeconds/(ageEarth * ageMercury));
        System.out.println("Venus Age : " + ageSeconds/(ageEarth * ageVenus));
        System.out.println("Mars Age : " + ageSeconds/(ageEarth * ageMars));
        System.out.println("Jupiter Age : " + ageSeconds/(ageEarth * ageJupiter));
        System.out.println("Saturn Age : " + ageSeconds/(ageEarth * ageSaturn));
        System.out.println("Uranus Age : " + ageSeconds/(ageEarth * ageUranus));
        System.out.println("Neptune Age : " + ageSeconds/(ageEarth * ageNeptune));
    }
}
