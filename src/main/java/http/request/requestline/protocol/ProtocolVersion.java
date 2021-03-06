package http.request.requestline.protocol;

import http.request.requestline.exception.RequestLineParsingException;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.regex.Pattern;

@Getter
@EqualsAndHashCode
public class ProtocolVersion {

    private final String version;

    ProtocolVersion(String version) {
        if (isIllegalPattern(version)) {
            throw new RequestLineParsingException();
        }

        this.version = version;
    }

    private boolean isIllegalPattern(String version) {
        return !ProtocolVersionMatcher.match(version);
    }

    private static class ProtocolVersionMatcher {

        private static final String VERSION_REGEX = "^[0-9][.][0-9]$";

        private ProtocolVersionMatcher() {
        }

        public static boolean match(String version) {
            return Pattern.matches(VERSION_REGEX, version);
        }
    }
}
