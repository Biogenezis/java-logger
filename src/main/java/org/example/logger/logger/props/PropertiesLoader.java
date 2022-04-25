package org.example.logger.logger.props;


import java.util.ResourceBundle;
import java.util.Set;

public final class PropertiesLoader implements Resources{

    private final ResourceBundle resourceBundle;

    public PropertiesLoader() {
        this.resourceBundle = ResourceBundle.getBundle("app");
    }

    public PropertiesLoader(String bundleName) {
        this.resourceBundle = ResourceBundle.getBundle(bundleName);
    }

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }


    @Override
    public String getValue(String key) {
        return resourceBundle.getString(key);
    }

    @Override
    public Set<String> getKeySet(String value) {
        return resourceBundle.keySet();
    }

    @Override
    public PropertiesLoader getProperties() {
        return new PropertiesLoader();
    }
}
