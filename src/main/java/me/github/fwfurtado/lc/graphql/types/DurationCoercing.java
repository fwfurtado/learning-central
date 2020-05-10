package me.github.fwfurtado.lc.graphql.types;

import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import org.springframework.boot.convert.DurationStyle;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.HOURS;

@Component
public class DurationCoercing implements Coercing<Duration, String> {

    @Override
    public String serialize(Object dataFetcherResult) throws CoercingSerializeException {
        var duration = (Duration) dataFetcherResult;

        return DurationStyle.SIMPLE.print(duration, HOURS);
    }

    @Override
    public Duration parseValue(Object input) throws CoercingParseValueException {
        var durationString = (String) input;

        return DurationStyle.SIMPLE.parse(durationString);
    }

    @Override
    public Duration parseLiteral(Object input) throws CoercingParseLiteralException {
        return parseValue(input);
    }
}
