package org.op65n.magnolia.core.util;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Preloader {

    private static final Logger log = LoggerFactory.getLogger(Preloader.class);

    private Preloader() {}

    public static void initialPreloadSetup() {
        // load some required classes to avoid errors during shutdown if jar is replaced
        // also to guarantee our version loads over plugins
        // Paper start - preload logger classes to avoid plugins mixing versions
        tryPreloadClass("org.apache.logging.log4j.core.Core");
        tryPreloadClass("org.apache.logging.log4j.core.appender.AsyncAppender");
        tryPreloadClass("org.apache.logging.log4j.core.Appender");
        tryPreloadClass("org.apache.logging.log4j.core.ContextDataInjector");
        tryPreloadClass("org.apache.logging.log4j.core.Filter");
        tryPreloadClass("org.apache.logging.log4j.core.ErrorHandler");
        tryPreloadClass("org.apache.logging.log4j.core.LogEvent");
        tryPreloadClass("org.apache.logging.log4j.core.Logger");
        tryPreloadClass("org.apache.logging.log4j.core.LoggerContext");
        tryPreloadClass("org.apache.logging.log4j.core.LogEventListener");
        tryPreloadClass("org.apache.logging.log4j.core.AbstractLogEvent");
        tryPreloadClass("org.apache.logging.log4j.message.AsynchronouslyFormattable");
        tryPreloadClass("org.apache.logging.log4j.message.FormattedMessage");
        tryPreloadClass("org.apache.logging.log4j.message.ParameterizedMessage");
        tryPreloadClass("org.apache.logging.log4j.message.Message");
        tryPreloadClass("org.apache.logging.log4j.message.MessageFactory");
        tryPreloadClass("org.apache.logging.log4j.message.TimestampMessage");
        tryPreloadClass("org.apache.logging.log4j.message.SimpleMessage");
        tryPreloadClass("org.apache.logging.log4j.core.async.AsyncLogger");
        tryPreloadClass("org.apache.logging.log4j.core.async.AsyncLoggerContext");
        tryPreloadClass("org.apache.logging.log4j.core.async.AsyncQueueFullPolicy");
        tryPreloadClass("org.apache.logging.log4j.core.async.AsyncLoggerDisruptor");
        tryPreloadClass("org.apache.logging.log4j.core.async.RingBufferLogEvent");
        tryPreloadClass("org.apache.logging.log4j.core.async.DisruptorUtil");
        tryPreloadClass("org.apache.logging.log4j.core.async.RingBufferLogEventHandler");
        tryPreloadClass("org.apache.logging.log4j.core.impl.ThrowableProxy");
        tryPreloadClass("org.apache.logging.log4j.core.impl.ExtendedClassInfo");
        tryPreloadClass("org.apache.logging.log4j.core.impl.ExtendedStackTraceElement");
        tryPreloadClass("com.destroystokyo.paper.util.SneakyThrow");
        tryPreloadClass("com.google.common.collect.Iterators$PeekingImpl");
        tryPreloadClass("com.google.common.collect.MapMakerInternalMap$Values");
        tryPreloadClass("com.google.common.collect.MapMakerInternalMap$ValueIterator");
        tryPreloadClass("com.google.common.collect.MapMakerInternalMap$WriteThroughEntry");
        tryPreloadClass("com.google.common.collect.Iterables");
        for (int i = 1; i <= 15; i++) {
            tryPreloadClass("com.google.common.collect.Iterables$" + i, false);
        }
        tryPreloadClass("org.apache.commons.lang3.mutable.MutableBoolean");
        tryPreloadClass("org.apache.commons.lang3.mutable.MutableInt");
        tryPreloadClass("org.jline.terminal.impl.MouseSupport");
        tryPreloadClass("org.jline.terminal.impl.MouseSupport$1");
        tryPreloadClass("org.jline.terminal.Terminal$MouseTracking");
        tryPreloadClass("co.aikar.timings.TimingHistory");
        tryPreloadClass("co.aikar.timings.TimingHistory$MinuteReport");
        tryPreloadClass("io.netty.channel.AbstractChannelHandlerContext");
        tryPreloadClass("io.netty.channel.AbstractChannelHandlerContext$11");
        tryPreloadClass("io.netty.channel.AbstractChannelHandlerContext$12");
        tryPreloadClass("io.netty.channel.AbstractChannel$AbstractUnsafe$8");
        tryPreloadClass("io.netty.util.concurrent.DefaultPromise");
        tryPreloadClass("io.netty.util.concurrent.DefaultPromise$1");
        tryPreloadClass("io.netty.util.internal.PromiseNotificationUtil");
        tryPreloadClass("io.netty.util.internal.SystemPropertyUtil");
        tryPreloadClass("org.slf4j.helpers.MessageFormatter");
        tryPreloadClass("org.slf4j.helpers.FormattingTuple");
        tryPreloadClass("org.slf4j.helpers.BasicMarker");
        tryPreloadClass("org.slf4j.helpers.Util");
        tryPreloadClass("com.destroystokyo.paper.event.player.PlayerConnectionCloseEvent");
        tryPreloadClass("com.destroystokyo.paper.event.entity.EntityRemoveFromWorldEvent");
    }

    public static void tryPreloadClass(final @NotNull String className) {
        tryPreloadClass(className, true);
    }

    @SuppressWarnings("SameParameterValue")
    private static void tryPreloadClass(final @NotNull String className, final boolean printError) {
        try {
            Class.forName(className);
        } catch (final ClassNotFoundException exception) {
            if (printError) {
                log.error("An expected class {} was not found for preloading", className);
                log.error(exception.getMessage());
            }
        }
    }

}
