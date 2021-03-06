package sst0.kitchenclover.logging;

import java.io.PrintWriter;
import java.io.Writer;

/**
 *@author Miles
 */

public class ExceptionWriter extends PrintWriter {

    public ExceptionWriter(Writer writer) {
        super(writer);
    }

    private String wrapAroundWithNewlines(String stringWithoutNewlines) {
        return ("\n" + stringWithoutNewlines + "\n");
    }

    public String getExceptionAsString(Throwable throwable) {
        throwable.printStackTrace(this);

        String exception = super.out.toString();

        return (wrapAroundWithNewlines(exception));
    }
}
