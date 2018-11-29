package application;

/**
 * Berechnet das Formelrad
 *
 * @author Peter Rutschmann
 * @version 13.09.2018
 */
public class Calculator {

  private double leistung;
  private double spannung;
  private double strom;
  private double widerstand;

  public Calculator(double leistung, double spannung, double strom, double widerstand) {
    super();
    this.leistung = leistung;
    this.spannung = spannung;
    this.strom = strom;
    this.widerstand = widerstand;
  }

  public double getLeistung() {
    return leistung;
  }

  public double getSpannung() {
    return spannung;
  }

  public double getStrom() {
    return strom;
  }

  public double getWiderstand() {
    return widerstand;
  }

  @Override
  public String toString() {
    return "Calculator [leistung=" + leistung + ", spannung=" + spannung + ", strom=" + strom + ", widerstand="
        + widerstand + "]";
  }

    public void calculate() {
        /* Hier auf Grund der vorhanden Werte entscheiden
         * welche Methode unten aufgerufen werden muss.
         */
        if (spannung != 0.0) {
          if (widerstand != 0.0) {
            leistung = pFromUandR(spannung, widerstand);
            strom = iFromUandR(spannung, widerstand);
          } else if (leistung != 0.0) {
            strom = iFromPandU(leistung, spannung);
          } else if (strom != 0.0) {
            leistung = pFromUandI(spannung, strom);
          }
        } else if (widerstand != 0.0) {
          if (leistung != 0.0) {
            strom = iFromPandR(leistung, widerstand);
          } else if (strom != 0.0) {
            leistung = pFromIandR(strom, widerstand);
          }
        }
    }

  /* Hier die Methoden mit den Formlen hinzuf�gen
   */
  public double pFromUandI(double u, double i) {
    System.out.println("Berechne P mit U=" + u + " und I= " + i + ". Ergebnis  von P=" + u * i);
    return u * i;
  }

  public double pFromIandR(double i, double r) {
    System.out.println("Berechne P mit I=" + i + " und R=" + r + ". Ergebnis von P=" + r * i * i);
    return r * i * i;
  }

  public double pFromUandR(double u, double r) {
    System.out.println("Berechne P mit U=" + u + " und R=" + r + ". Ergebnis von P=" + u * u / r);
    return u * u / r;
  }

  public double iFromPandR(double p, double r) {
    System.out.println("Berechne I mit P=" + p + " und R=" + r + ". Ergebnis von I=" + Math.sqrt(p / r));
    return Math.sqrt(p / r);
  }

  public double iFromPandU(double p, double u) {
    System.out.println("Berechne I mit P=" + p + " und U=" + u + ". Ergebnis von I=" + p / u);
    return p / u;
  }

  public double iFromUandR(double u, double r) {
    System.out.println("Berechne I mit U=" + u + " und R=" + r + ". Ergebnis von I=" + u / r);
    return u / r;
  }
}
