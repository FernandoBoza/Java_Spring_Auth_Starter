package com.starter_kit.auth.Utils;

import java.util.Optional;

public class Utils {
    public static <T> T getFromOptional(Optional<T> opt) {
        return (T) opt.orElse(null);
    }
}
