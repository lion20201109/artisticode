package org.artisticode.boot.utils.exception;

/**
 * @author ZH
 * @date 2021/9/30 16:51
 * @since jdk1.8
 */
public class ThrowNotStackException extends Throwable {

    public ThrowNotStackException(String message) {
        super(message);
    }

    public ThrowNotStackException(Throwable cause) {
        super(cause);
    }

    public ThrowNotStackException(String message, Throwable cause) {
        super(message, cause);
    }

    public static class ThrowException extends Exception {
        public ThrowException(String message) {
            super(message);
        }

        public ThrowException(Throwable cause) {
            super(cause);
        }

        public ThrowException(String message, Throwable cause) {
            super(message, cause);
        }

        @Override
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    public static class ThrowRuntimeException extends RuntimeException {
        public ThrowRuntimeException(String message) {
            super(message);
        }

        public ThrowRuntimeException(Throwable cause) {
            super(cause);
        }

        public ThrowRuntimeException(String message, Throwable cause) {
            super(message, cause);
        }

        @Override
        public Throwable fillInStackTrace() {
            return this;
        }
    }
}
