package com.sap.hcp.cf.logging.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * A {@link Value} implementation representing a <i>date</i>.
 * <p>
 * When serialized into a String, the value will be formatted using timezone
 * "UTC" and format <code>"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"</code>.
 *
 */
public class DateTimeValue implements Value {
    private static final TimeZone UTC_TZ = TimeZone.getTimeZone("UTC");
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    private long timestamp;

    public DateTimeValue(long timestamp) {
        this.timestamp = timestamp;
        DATE_FORMAT.setTimeZone(UTC_TZ);
    }

    public DateTimeValue(String dt) {
        try {
            synchronized (DATE_FORMAT) {
                timestamp = DATE_FORMAT.parse(dt).getTime();
            }
        } catch (ParseException pex) {
            timestamp = 0;
        }
    }

    @Override
    public String toString() {
        synchronized (DATE_FORMAT) {
            return DATE_FORMAT.format(timestamp);
        }
    }

    @Override
    public Object getValue() {
        try {
            synchronized (DATE_FORMAT) {
                return DATE_FORMAT.parse(DATE_FORMAT.format(timestamp));
            }
        } catch (ParseException pex) {
            return null;
        }
    }

    @Override
    public long asLong() {
        return timestamp;
    }

    @Override
    public double asDouble() {
        return timestamp;
    }

    @Override
    public String asString() {
        return toString();
    }

}
