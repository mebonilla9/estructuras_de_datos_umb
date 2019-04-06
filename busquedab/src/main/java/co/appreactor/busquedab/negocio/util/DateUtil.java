
package co.appreactor.busquedab.negocio.util;

/**
 *
 * @author Manuel Ernesto Bonilla Muñoz
 */
public class DateUtil {

    public static java.sql.Date parseDate(java.util.Date fecha) {
        if (fecha == null) {
            return null;
        }
        return new java.sql.Date(fecha.getTime());
    }

    public static java.sql.Timestamp parseTimestamp(java.util.Date fecha) {
        if (fecha == null) {
            return null;
        }
        return new java.sql.Timestamp(fecha.getTime());
    }
}
