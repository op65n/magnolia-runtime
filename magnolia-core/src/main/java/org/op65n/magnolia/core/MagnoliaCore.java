package org.op65n.magnolia.core;

import org.op65n.magnolia.core.util.SystemProperty;

public class MagnoliaCore {

    public static void bootstrapRuntime() {
        SystemProperty.ifMissing("jdk.nio.maxCachedBufferSize", "262144"); // cap per-thread NIO cache size


    }

}
