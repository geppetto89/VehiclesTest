package android.mobile.micmen.vehiclestest.network;

/**
 * <h1>Retrofit Service factory<h1/>
 *
 * creates actual retrofit services
 *
 * @author Michele Meninno
 */
public interface ServiceFactory {

    <T> T makeService(Class<T> tClass);

}
