/*
 * Copyright (c) 2002-2016, the original author or authors.
 *
 * This software is distributable under the BSD license. See the terms of the
 * BSD license in the documentation provided with this software.
 *
 * http://www.opensource.org/licenses/bsd-license.php
 */
package jline.internal;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL helpers.
 *
 * @author <a href="mailto:jason@planet57.com">Jason Dillon</a>
 * @author <a href="mailto:gnodet@gmail.com">Guillaume Nodet</a>
 * @since 2.7
 */
public class Urls
{
    /**
     * <p>Creates a URL from a string.</p>
     *
     * <p>If the string represents a valid URL in a supported protocol, that URL is returned.
     *    Otherwise, the string is treated as a file path converted to a URL.</p>
     *
     * @param file the file path.
     * @return the URL.
     * @throws SecurityException if the file path cannot be accessed.
     */
    public static URL create(final String input) {
        if (input == null) {
            return null;
        }
        try {
            return new URL(input);
        }
        catch (MalformedURLException e) {
            return create(new File(input));
        }
    }

    /**
     * Creates a URL for a file path.
     *
     * @param file the file path.
     * @return the URL.
     * @throws SecurityException if the file path cannot be accessed.
     */
    public static URL create(final File file) {
        try {
            return file != null ? file.toURI().toURL() : null;
        }
        catch (MalformedURLException e) {
            throw new IllegalStateException(e);
        }
    }
}