package org.aliu.springboot.model.second.config;




import org.aliu.springboot.model.second.common.Constants;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author amrjlg
 * @date 2021-07-20 13:59
 **/
@Component
public class StringConverter implements Converter<String, String> {
    @Override
    public String convert(String source) {
        if (Objects.isNull(source)) {
            return null;
        }
        String result = source.trim();
        if (Constants.NULL_STRING.equalsIgnoreCase(result) || Constants.UNDEFINED.equalsIgnoreCase(result) || result.length() < 1) {
            return null;
        }
        return result;
    }
}
