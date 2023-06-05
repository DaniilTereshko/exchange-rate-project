package by.it_academy.jd2.dao.mapper.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {
    private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";
    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String formattedDate = localDateTime.format(DateTimeFormatter.ofPattern(dateFormat));
        jsonGenerator.writeString(formattedDate); ;
    }
}
