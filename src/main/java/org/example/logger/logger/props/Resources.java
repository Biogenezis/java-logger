package org.example.logger.logger.props;

import java.util.*;

public interface Resources {

    PropertiesLoader getProperties();

    String getValue(String key);

    Set<String> getKeySet(String value);

}
