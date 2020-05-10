package me.github.fwfurtado.lc.graphql.types;

import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateTimeCoercing implements Coercing<LocalDateTime, String> {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;

    @Override
    public String serialize(Object dataFetcherResult) throws CoercingSerializeException {
        var dateTime = (LocalDateTime) dataFetcherResult;
        return DATE_TIME_FORMATTER.format(dateTime);
    }

    @Override
    public LocalDateTime parseValue(Object input) throws CoercingParseValueException {
        var dateTimeString = (String) input;
        return LocalDateTime.parse(dateTimeString, DATE_TIME_FORMATTER);
    }

    @Override
    public LocalDateTime parseLiteral(Object input) throws CoercingParseLiteralException {
        return parseValue(input);
    }
}
