package org.op65n.magnolia.core.util;

import org.jetbrains.annotations.NotNull;

public class SystemProperty {

    public static void ifMissing(final @NotNull String property, final @NotNull String value) {
        if (System.getProperty(property) == null) System.setProperty(property, value);
    }

}
