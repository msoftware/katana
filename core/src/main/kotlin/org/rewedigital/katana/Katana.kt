package org.rewedigital.katana

/**
 * Global Katana configuration object.
 *
 * Currently only provides the possibility to specify a [Logger].
 *
 * @see logger
 */
object Katana {

    interface Logger {

        fun debug(msg: String)

        fun info(msg: String)

        fun warn(msg: String)

        fun error(msg: String, throwable: Throwable? = null)
    }

    /**
     * Pass an implementation of [Logger] here to enable Katana's logging functionality
     */
    var logger: Logger? = null
}
