package org.op65n.magnolia.core.console;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * This class overrides default output stream and
 * appends ASCII colors to the content, we are only overriding
 * error stream with red prefix and reset suffix to get red error
 * messages and exceptions in the terminal output
 *
 * @author sebba
 */
public final class ColoredErrorStream extends OutputStream {

    private static final String COLOR_RED = "\033[31m";
    private static final String COLOR_RESET = "\033[0m";

    private final OutputStream stream;

    private ColoredErrorStream(final @NotNull OutputStream stream) {
        this.stream = stream;
    }

    public static void overrideStream() {
        final ColoredErrorStream coloredStream = new ColoredErrorStream(System.err);
        final PrintStream printStream = new PrintStream(coloredStream, true);

        System.setErr(printStream);
    }

    @Override
    public void write(final int b) throws IOException {
        stream.write(COLOR_RED.getBytes());
        stream.write(b);
        stream.write(COLOR_RESET.getBytes());
    }

    @Override
    public void write(final byte @NotNull [] b) throws IOException {
        stream.write(COLOR_RED.getBytes());
        stream.write(b);
        stream.write(COLOR_RESET.getBytes());
    }

    @Override
    public void write(final byte @NotNull [] b, final int off, final int len) throws IOException {
        stream.write(COLOR_RED.getBytes());
        stream.write(b, off, len);
        stream.write(COLOR_RESET.getBytes());
    }

    @Override
    public void flush() throws IOException {
        stream.flush();
    }

    @Override
    public void close() throws IOException {
        stream.close();
    }

}
