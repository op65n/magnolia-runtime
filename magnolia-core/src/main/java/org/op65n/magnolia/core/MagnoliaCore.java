package org.op65n.magnolia.core;

import org.op65n.magnolia.core.console.ColoredErrorStream;
import org.op65n.magnolia.core.util.SystemProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MagnoliaCore {

    private static final Logger log = LoggerFactory.getLogger(MagnoliaCore.class);

    public static void bootstrapRuntime() {
        ColoredErrorStream.overrideStream(); // let's enjoy the red exceptions again, or at least try to :/

        SystemProperty.ifMissing("jdk.nio.maxCachedBufferSize", "262144"); // cap per-thread NIO cache size
        SystemProperty.ifMissing("java.awt.headless", "true"); // force AWT to work with its head chopped off - thanks Velocity
    }

}
