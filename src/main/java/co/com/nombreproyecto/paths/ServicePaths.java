package co.com.nombreproyecto.paths;

import co.com.nombreproyecto.data.Environment;
import co.com.nombreproyecto.data.EnvironmentProperties;
import org.aeonbits.owner.ConfigFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class ServicePaths {
    private static Environment environment;

    private static final String BASE_ENDPOINT = "reqres.baseurl";
    private static final String BASE_ENDPOINT_JSONTEST = "jsontest.baseurl";
    private static final String BASE_ENDPOINT_IEX = "iex.baseurl";
    static {
        environment = ConfigFactory.create(Environment.class);
    }

    public static URL pathReqResUsers2() throws MalformedURLException {
        return new URL(EnvironmentProperties.getProperty(BASE_ENDPOINT) + environment.urlUsersPage2());
    }
    public static URL pathJsonTest() throws MalformedURLException {
        return new URL(EnvironmentProperties.getProperty(BASE_ENDPOINT_JSONTEST) + environment.urlJsonTest());
    }
    public static URL pathIexTest() throws MalformedURLException {
        return new URL(EnvironmentProperties.getProperty(BASE_ENDPOINT_IEX) + environment.urlIexTopLast());
    }
    public static URL pathIexStatsRecords() throws MalformedURLException {
        return new URL(EnvironmentProperties.getProperty(BASE_ENDPOINT_IEX) + environment.urlIexStatsRecords());
    }
    public static URL pathReqResUsers() throws MalformedURLException {
        return new URL(EnvironmentProperties.getProperty(BASE_ENDPOINT) + environment.urlUsers());
    }
}
