package org.atlasin.alcove

/**
 * Used for formatting log strings
 *
 * @since 1.0.0
 * @author TridiumX
 */
fun interface Formatter {

    /**
     * Formats the log message properties into a string.
     */
    fun format(
        level : Int,
        tag : String,
        message : String,
        throwable: Throwable?,
        args : Array<out Any?>?
    ) : String
}